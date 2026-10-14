"""Compare user-created captures; never launches Minecraft or estimates missing FPS."""
import argparse
import json
from pathlib import Path
import statistics

def read(path):
    run = json.loads(Path(path).read_text())
    if not run.get('contextStable'): raise ValueError(f'{path}: missing or changed capture settings')
    if run.get('sampleCapReached'): raise ValueError(f'{path}: recorder capacity reached; use shorter captures')
    intervals = run['frameIntervalsNanos']
    if len(intervals) < 300 or any(value <= 0 for value in intervals): raise ValueError(f'{path}: insufficient/invalid intervals')
    if sum(intervals) < 30e9: raise ValueError(f'{path}: capture at least 30 seconds after warming up')
    if run.get('label') in (None, '', 'unlabelled'): raise ValueError(f'{path}: label the fixed scene/route first')
    if run.get('mods', {}).get('sodium'): raise ValueError(f'{path}: target is Xe-Mod without Sodium')
    context = run['startContext']
    if context['vsync']: raise ValueError(f'{path}: VSync caps the requested uncapped comparison')
    # Lower targets intentionally remain valid; a 5x claim additionally needs enough cap headroom.
    return run, len(intervals) * 1e9 / sum(intervals)

def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--baseline', nargs='+', required=True)
    parser.add_argument('--optimized', nargs='+', required=True)
    args = parser.parse_args()
    if len(args.baseline) != len(args.optimized) or len(args.baseline) < 3:
        parser.error('Supply at least three matched captures per mode')
    baseline = [read(path) for path in args.baseline]
    optimized = [read(path) for path in args.optimized]
    first = baseline[0][0]
    for run, _ in baseline + optimized:
        if run['startContext'] != first['startContext'] or run['label'] != first['label'] or run['mods'] != first['mods']:
            raise ValueError('PC/settings, labels and loaded mod versions must match across all captures')
    if any(run.get('terrainBatcherEnabled') for run, _ in baseline): raise ValueError('Baseline must use vanilla terrain submission')
    if not all(run.get('terrainBatcherEnabled') for run, _ in optimized): raise ValueError('Optimized captures must enable Xe terrain submission')
    if not all(run.get('terrainFramesInCapture', 0) > 0 for run, _ in optimized): raise ValueError('No original terrain frames were submitted; GPU may be using vanilla direct draws')
    old = statistics.median(fps for _, fps in baseline)
    new = statistics.median(fps for _, fps in optimized)
    paired = [new_fps / old_fps for (_, old_fps), (_, new_fps) in zip(baseline, optimized)]
    ratio = new / old
    cap = first['startContext']['fpsLimit']
    report = {'baselineMedianFps': old, 'optimizedMedianFps': new, 'speedup': ratio,
        'fpsIncreasePercent': (ratio - 1) * 100, 'pairedSpeedups': paired,
        'fiveTimesObserved': ratio >= 5 and min(paired) >= 5 and (first['startContext'].get('fpsUnlimited') or cap >= old * 5),
        'fpsCap': cap, 'capAllowsFiveTimesBaseline': bool(first['startContext'].get('fpsUnlimited') or cap >= old * 5),
        'limits': 'User measurements of original terrain submission only. Same label/settings cannot prove identical world state, hardware, driver, route or thermals. No general-purpose FPS guarantee.'}
    print(json.dumps(report, indent=2))

if __name__ == '__main__': main()
