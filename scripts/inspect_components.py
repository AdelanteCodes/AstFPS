"""Static archive and mixin target inspection. Does not launch Minecraft."""
import collections
import hashlib
import io
import json
from pathlib import Path
import struct
import zipfile

ROOT = Path(__file__).resolve().parents[1]

def targets(data):
    pos = 8
    def u1():
        nonlocal pos
        value = data[pos]; pos += 1; return value
    def u2():
        nonlocal pos
        value = struct.unpack_from('>H', data, pos)[0]; pos += 2; return value
    def u4():
        nonlocal pos
        value = struct.unpack_from('>I', data, pos)[0]; pos += 4; return value
    pool = [None] * u2()
    index = 1
    while index < len(pool):
        tag = u1()
        if tag == 1:
            length = u2(); pool[index] = data[pos:pos+length].decode('utf-8', errors='replace'); pos += length
        elif tag in (3, 4): pos += 4
        elif tag in (5, 6): pos += 8; index += 1
        elif tag in (7, 8, 16, 19, 20): pos += 2
        elif tag in (9, 10, 11, 12, 17, 18): pos += 4
        elif tag == 15: pos += 3
        else: raise ValueError(tag)
        index += 1
    pos += 6
    interface_count = u2()
    pos += 2 * interface_count
    for _ in range(2):
        for _ in range(u2()):
            pos += 6
            for _ in range(u2()):
                u2(); length = u4(); pos += length
    def value():
        tag = chr(u1())
        if tag == '[': return [value() for _ in range(u2())]
        if tag == '@': return annotation()
        if tag == 'e': return (u2(), u2())
        return pool[u2()]
    def annotation():
        kind = pool[u2()]
        fields = {}
        for _ in range(u2()):
            name = pool[u2()]; fields[name] = value()
        return kind, fields
    found = []
    for _ in range(u2()):
        name = pool[u2()]; length = u4(); end = pos + length
        if name in ('RuntimeVisibleAnnotations', 'RuntimeInvisibleAnnotations'):
            for _ in range(u2()):
                kind, fields = annotation()
                if kind == 'Lorg/spongepowered/asm/mixin/Mixin;':
                    found += fields.get('value', []) + fields.get('targets', [])
        pos = end
    return [name.strip('L;').replace('/', '.') for name in found]

def main():
    components = json.loads((ROOT / 'third-party/components.json').read_text())
    overlap = collections.defaultdict(list)
    records = []
    for item in components:
        path = ROOT / item['file']
        assert hashlib.sha512(path.read_bytes()).hexdigest() == item['sha512']
        with zipfile.ZipFile(path) as archive:
            assert archive.testzip() is None
            meta = json.loads(archive.read('fabric.mod.json'))
            assert meta['id'] == item['id'] and meta['version'] == item['version']
            for entry in meta.get('entrypoints', {}).values():
                for name in entry:
                    name = name if isinstance(name, str) else name['value']
                    if '::' not in name: assert name.replace('.', '/') + '.class' in archive.namelist(), name
            for config in meta.get('mixins', []):
                config = config if isinstance(config, str) else config['config']
                mixins = json.loads(archive.read(config))
                for name in mixins.get('mixins', []) + mixins.get('client', []) + mixins.get('server', []):
                    classname = mixins['package'] + '.' + name
                    for target in targets(archive.read(classname.replace('.', '/') + '.class')):
                        overlap[target].append({'module': item['id'], 'mixin': classname})
            if meta.get('accessWidener'): assert meta['accessWidener'] in archive.namelist()
            for nested in meta.get('jars', []):
                with zipfile.ZipFile(io.BytesIO(archive.read(nested['file']))) as child:
                    assert child.testzip() is None
            records.append({'id': meta['id'], 'version': meta['version'], 'depends': meta.get('depends'), 'breaks': meta.get('breaks')})
    report = {'modules': records, 'sharedMixinTargets': {name: matches for name, matches in overlap.items() if len({m['module'] for m in matches}) > 1},
              'limits': 'Shared targets identify review candidates, not proven incompatibilities. No mixin application or game execution.'}
    out = ROOT / 'artifacts/component-static-review.json'
    out.write_text(json.dumps(report, indent=2) + '\n')
    print('Checked', len(records), 'modules;', len(report['sharedMixinTargets']), 'shared targets; report:', out)

if __name__ == '__main__': main()
