"""Package pinned, unmodified Fabric modules; no compilation or game tests."""
import hashlib
import io
import json
from pathlib import Path
import zipfile

ROOT = Path(__file__).resolve().parents[1]
BASE_HASH = '305bd31aec577fd2218130c395487ebe5f8fcdb84a7c45b9414aaf2aecc2931f'

def main():
    components = json.loads((ROOT / 'third-party/components.json').read_text())
    base = ROOT / 'vendor/xe-mod-0.1.0-alpha.1.jar'
    assert hashlib.sha256(base.read_bytes()).hexdigest() == BASE_HASH, 'Core hash mismatch'
    paths = [base]
    receipts = []
    for item in components:
        path = ROOT / item['file']
        assert hashlib.sha512(path.read_bytes()).hexdigest() == item['sha512'], path
        paths.append(path)
    ids = set()
    for path in paths:
        with zipfile.ZipFile(path) as archive:
            assert archive.testzip() is None, f'Corrupt archive: {path}'
            metadata = json.loads(archive.read('fabric.mod.json'))
            assert metadata['id'] not in ids, 'Duplicate module ID'
            ids.add(metadata['id'])
            for nested in metadata.get('jars', []):
                assert nested['file'] in archive.namelist(), 'Missing nested dependency'
            for mixin in metadata.get('mixins', []):
                config = mixin if isinstance(mixin, str) else mixin['config']
                assert config in archive.namelist(), f'Missing mixin config: {config}'
            if metadata.get('accessWidener'):
                assert metadata['accessWidener'] in archive.namelist()
            receipts.append({'file': path.name, 'id': metadata['id'],
                'version': metadata['version'], 'depends': metadata.get('depends', {}),
                'breaks': metadata.get('breaks', {}),
                'sha256': hashlib.sha256(path.read_bytes()).hexdigest()})
    metadata = {'schemaVersion': 1, 'id': 'xe_mod_bundle', 'version': '0.2.0-dev',
        'name': 'Xe-Mod Memory Bundle', 'environment': 'client',
        'description': 'Xe-Mod core plus memory optimization and opt-in chunk pregeneration.',
        'authors': ['KyzerGoated'],
        'jars': [{'file': 'META-INF/jars/' + path.name} for path in paths],
        'depends': {'fabricloader': '>=0.19.5', 'minecraft': '~26.3',
                    'java': '>=25', 'fabric-api': '*'}}
    output = ROOT / 'artifacts/xe-mod-memory-bundle-0.2.0-dev.jar'
    output.parent.mkdir(exist_ok=True)
    report = {'modules': receipts, 'validation': 'Archive integrity, pinned hashes, unique IDs and referenced resources checked. No game execution or tests.',
              'core': 'Unmodified compiled 0.1.0-alpha.1; newer source-only hooks are not in this artifact.'}
    with zipfile.ZipFile(output, 'w', zipfile.ZIP_DEFLATED) as archive:
        archive.writestr('fabric.mod.json', json.dumps(metadata, indent=2))
        archive.writestr('META-INF/xe-mod/package-manifest.json', json.dumps(report, indent=2))
        for path in paths:
            archive.write(path, 'META-INF/jars/' + path.name)
        notices = ROOT / 'src/main/resources/META-INF/xe-mod'
        for path in notices.rglob('*'):
            if path.is_file():
                archive.write(path, 'META-INF/xe-mod/' + path.relative_to(notices).as_posix())
    with zipfile.ZipFile(output) as archive:
        assert archive.testzip() is None
        for path in paths:
            assert archive.read('META-INF/jars/' + path.name) == path.read_bytes()
    (output.parent / 'package-manifest.json').write_text(json.dumps(report, indent=2) + '\n')
    (output.parent / 'SHA256SUMS.txt').write_text(hashlib.sha256(output.read_bytes()).hexdigest() + '  ' + output.name + '\n')
    print(str(output))
    print(json.dumps(report, indent=2))

if __name__ == '__main__':
    main()
