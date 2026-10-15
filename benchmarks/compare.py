import json
import pathlib
import statistics
import sys

directory = pathlib.Path(sys.argv[1])
runs = {}
for mode in ('baseline', 'default', 'memo'):
    runs[mode] = [json.loads((directory / f'{mode}-{repetition}.json').read_text()) for repetition in (1, 2, 3)]
    for run in runs[mode]:
        assert ('astfps' in run['loadedMods']) == (mode != 'baseline')
        assert (run['width'], run['height'], run['renderDistance'], run['simulationDistance'], run['vsync']) == (2560, 1440, 16, 8, False)
        assert run['samples'] >= 60
        assert run['mode'] == mode
        assert run['loadedMods'].get('astfps', '1.0.0') == '1.0.0'

summary = {}
for mode, measurements in runs.items():
    summary[mode] = {metric: statistics.median(run[metric] for run in measurements)
                     for metric in ('averageFps', 'onePercentLowFps', 'p99FrameTimeMs')}
    summary[mode]['individualAverageFps'] = [run['averageFps'] for run in measurements]
    summary[mode]['pairedAverageFpsChangePercent'] = [
        100 * (run['averageFps'] / baseline['averageFps'] - 1)
        for run, baseline in zip(measurements, runs['baseline'])]
    summary[mode]['medianPairedAverageFpsChangePercent'] = statistics.median(summary[mode]['pairedAverageFpsChangePercent'])
    if mode != 'baseline':
        hits = sum(run['visibilityHits'] for run in measurements)
        misses = sum(run['visibilityMisses'] for run in measurements)
        summary[mode]['visibilityHitPercent'] = 100 * hits / (hits + misses) if hits + misses else 0

report = {'settings': 'Minecraft 26.3, 2560x1440, Fancy, 16 chunks, simulation 8; flat seed 5600, 128 cows, fixed camera',
          'method': 'Same hosted runner, three fresh-world launches per mode, one reversed repetition; >=30s warm-up, 45-90s frame intervals; identical harness and Fabric API in all modes',
          'limits': 'Software graphics; this synthetic scene is not representative of a home GPU or a full modpack. Repeats quantify variability, not a general FPS guarantee.',
          'summary': summary}
(directory / 'comparison.json').write_text(json.dumps(report, indent=2))
lines = ['# AstFPS cloud comparison', '', report['settings'], '', report['method'], '',
         '| Mode | Median FPS | Median 1% low | Median p99 ms | Median paired FPS change |',
         '|---|---:|---:|---:|---:|']
for mode, result in summary.items():
    lines.append(f"| {mode} | {result['averageFps']:.2f} | {result['onePercentLowFps']:.2f} | {result['p99FrameTimeMs']:.2f} | {result['medianPairedAverageFpsChangePercent']:+.2f}% |")
lines.extend(['', report['limits'], '', 'Individual runs and raw frame intervals are included in the comparison artifact.'])
document = '\n'.join(lines) + '\n'
(directory / 'comparison.md').write_text(document)
print(document)
