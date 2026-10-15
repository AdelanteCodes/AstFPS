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
    source = ROOT / f'build/libs/AstFPS-{version}.jar'
    components = json.loads((ROOT / 'third-party/components.json').read_text())
    with zipfile.ZipFile(source) as jar:
        assert jar.testzip() is None
        meta = json.loads(jar.read('fabric.mod.json'))
        assert meta['id'] == 'astfps' and meta['version'] == version
        expected = {'META-INF/jars/' + Path(c['file']).name for c in components}
        assert {j['file'] for j in meta['jars']} == expected
        for c in components:
            data = jar.read('META-INF/jars/' + Path(c['file']).name)
            assert hashlib.sha512(data).hexdigest() == c['sha512']
            assert data == (ROOT / c['file']).read_bytes()
            with zipfile.ZipFile(io.BytesIO(data)) as child:
                assert child.testzip() is None
        assert 'assets/astfps/shaders/core/frame_interpolate.fsh' in jar.namelist()
        assert 'assets/astfps/shaders/frame_interpolate.fsh' not in jar.namelist()
        shader = jar.read('assets/astfps/shaders/core/frame_interpolate.fsh')
        for uniform in (b'PreviousSampler', b'CurrentSampler', b'PreviousDepthSampler', b'CurrentDepthSampler'):
            assert uniform in shader, f'Missing interpolation uniform: {uniform.decode()}'
        renderer = jar.read('dev/adelantecodes/astfps/client/render/FrameInterpolationRenderer.class')
        assert b'core/frame_interpolate' in renderer, 'Pipeline identifier does not map to packaged shader'
        assert b'register' in renderer, 'Interpolation pipelines are not registered for shader reload'
        mixins = json.loads(jar.read('astfps.client.mixins.json'))
        assert 'SectionCompilationScopeMixin' in mixins['client'] and 'RegionStateCacheMixin' in mixins['client']
        for name in mixins['client'] + ['AstFPSMixinPlugin']:
            data = jar.read('dev/adelantecodes/astfps/client/mixin/' + name + '.class')
            assert int.from_bytes(data[6:8], 'big') == 69, 'Expected Java 25 classes'
        for obsolete in ('EntityRendererLookupMixin', 'BlockEntityRendererLookupMixin'):
            assert 'dev/adelantecodes/astfps/client/mixin/' + obsolete + '.class' not in jar.namelist(), 'Obsolete per-lookup experiment packaged'
        assert 'PlayerTabSnapshotMixin' in mixins['client'] and 'PackResourcePathMixin' in mixins['client']
        assert 'EntityRendererIdentityIndexMixin' in mixins['client'] and 'BlockEntityRendererIdentityIndexMixin' in mixins['client']
        assert meta['custom']['lithium:options']['mixin.world.temperature_cache'] is False
        assert 'useSmallThreadingDetector' in meta['custom']['ferritecore:disabled_options']
    out = ROOT / 'build' / 'release'
    out.mkdir(parents=True, exist_ok=True)
    paths = []
    for suffix in ['', '-sources']:
        path = ROOT / f'build/libs/AstFPS-{version}{suffix}.jar'
        with zipfile.ZipFile(path) as jar: assert jar.testzip() is None
        target = out / path.name
        shutil.copyfile(path, target); paths.append(target)
    report = {'version': version, 'core': 'Fresh Java 25 compilation of current source; no old alpha core nested',
              'modules': components, 'validation': ['Java compilation', 'unit tests', 'core checks', 'archive integrity', 'pinned nested binaries', 'metadata module list', 'compatibility overrides', 'Java class version', 'frame interpolation shader path and uniforms'],
              'runtimeVerification': False, 'fpsImprovementMeasured': False, 'localOnly': True,
              'profiles': ['quality', 'balanced', 'maximum'],
              'frameGenerationModes': ['off', 'auto', '2x', '4x'],
              'frameGenerationDefault': 'auto',
              'adaptiveTiers': ['conservative', 'balanced', 'throughput'],
              'adaptiveSignals': ['frame pacing', 'GPU utilization', 'heap pressure', 'CPU count', 'chunk backlog', 'measured section compile cost'],
              'compatibilityIsolation': 'terrain, chunk compilation, frame generation, visibility, and entity distance are gated independently',
              'terrainBackendSelection': 'capability-based compatibility, multi-draw, or persistent-indirect tier',
              'shaderIntegrationComplete': True, 'independentRendererComplete': False,
              'buildEnvironment': 'Local Windows Java 25; build-only TCP selector workaround outside repository, not included in artifacts.'}
    (out / f'release-{version}.json').write_text(json.dumps(report, indent=2) + '\n')
    (out / f'SHA256SUMS-{version}.txt').write_text(''.join(hashlib.sha256(p.read_bytes()).hexdigest() + '  ' + p.name + '\n' for p in paths))
    for path in paths: print(path, path.stat().st_size)

if __name__ == '__main__': main()
