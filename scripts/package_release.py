"""Verify and retain the compiled release artifacts without executing game code."""
import hashlib
import io
import json
from pathlib import Path
import shutil
import zipfile

ROOT = Path(__file__).resolve().parents[1]

def main():
    properties = dict(line.split('=', 1) for line in (ROOT / 'gradle.properties').read_text().splitlines() if '=' in line)
    version = properties['version']
    source = ROOT / f'build/libs/xe-mod-{version}.jar'
    components = json.loads((ROOT / 'third-party/components.json').read_text())
    with zipfile.ZipFile(source) as jar:
        assert jar.testzip() is None
        meta = json.loads(jar.read('fabric.mod.json'))
        assert meta['id'] == 'xe_mod' and meta['version'] == version
        expected = {'META-INF/jars/' + Path(c['file']).name for c in components}
        assert {j['file'] for j in meta['jars']} == expected
        for c in components:
            data = jar.read('META-INF/jars/' + Path(c['file']).name)
            assert hashlib.sha512(data).hexdigest() == c['sha512']
            assert data == (ROOT / c['file']).read_bytes()
            with zipfile.ZipFile(io.BytesIO(data)) as child:
                assert child.testzip() is None
        assert 'META-INF/jars/xe-mod-0.1.0-alpha.1.jar' not in jar.namelist()
        for name in ['AabbZeroOffsetMixin', 'WorldTargetCleanupMixin', 'XeMixinPlugin', 'MinecraftFrameMixin']:
            data = jar.read('dev/kyzer/xemod/client/mixin/' + name + '.class')
            assert int.from_bytes(data[6:8], 'big') == 69, 'Expected Java 25 classes'
        assert meta['custom']['lithium:options']['mixin.world.temperature_cache'] is False
        assert 'useSmallThreadingDetector' in meta['custom']['ferritecore:disabled_options']
    out = ROOT / 'artifacts'
    paths = []
    for suffix in ['', '-sources']:
        path = ROOT / f'build/libs/xe-mod-{version}{suffix}.jar'
        with zipfile.ZipFile(path) as jar: assert jar.testzip() is None
        target = out / path.name
        shutil.copyfile(path, target); paths.append(target)
    report = {'version': version, 'core': 'Fresh Java 25 compilation of current source; no old alpha core nested',
              'modules': components, 'validation': ['Java compilation', 'archive integrity', 'pinned nested binaries', 'metadata module list', 'compatibility overrides', 'Java class version'],
              'runtimeVerification': False, 'fpsImprovementMeasured': False,
              'buildEnvironment': 'Local Windows Java 25; build-only TCP selector workaround outside repository, not included in artifacts.'}
    (out / f'release-{version}.json').write_text(json.dumps(report, indent=2) + '\n')
    (out / f'SHA256SUMS-{version}.txt').write_text(''.join(hashlib.sha256(p.read_bytes()).hexdigest() + '  ' + p.name + '\n' for p in paths))
    for path in paths: print(path, path.stat().st_size)

if __name__ == '__main__': main()
