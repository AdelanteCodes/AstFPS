# User-run comparison of the original terrain stage

No benchmark was run here. This procedure isolates our terrain submission stage;
it does not measure the entire package against Minecraft without AstFPS.

Install the 0.4.0-dev.3 JAR with Fabric API, removing old AstFPS/bundle copies and
separate bundled modules. Leave Sodium and other renderer replacements out.
Add -Dastfps.enableTerrainBatcher=true to JVM arguments. Keep the same world snapshot,
PC, Java/heap, GPU backend, drivers, graphics, resolution, render/simulation distance,
resource packs, route, entities and time/weather for both modes.

Choose uncapped FPS and VSync off yourself for this comparison; AstFPS won't
change them. The API's FPS setting 260 means unlimited in vanilla 26.3. Remain
focused and active so background/AFK throttling does not limit the run.

1. Warm up the fixed scene/route for at least 60 seconds; wait for terrain loading.
2. Set a descriptive fixed label: /astfps label fixed-world-route-1.
3. Set /astfps terrain false. Record 45 seconds using /astfps benchmark start then stop.
4. Set /astfps terrain true. Warm up again and record the identical route for 45 seconds.
5. Repeat until there are at least three captures per mode. Alternate starting order.
6. Export /astfps diagnose. If optimized captures show no submitted terrain frames,
   the hook was skipped, disabled or failed; the capture cannot establish a backend gain.

Compare the local JSON files with:

    python benchmarks/compare_user_runs.py --baseline before1.json before2.json before3.json --optimized after1.json after2.json after3.json

The reader rejects different recorded contexts, labels or module versions,
changed settings, short/capped captures, Sodium presence, incorrect feature states,
and optimized captures where our path did not run. It reports FPS and paired
multipliers from raw measured intervals, including frame pacing. These guards do
not prove identical world state or visual parity: screenshots/profiles and manual
scene matching are still required. No GPU timing is inferred from frame intervals.

For the whole-package 5x target, also collect external frame-time traces from a
matched Minecraft baseline without AstFPS, keeping other mods/settings unchanged.
The original-stage comparison alone cannot establish that whole-package result.
