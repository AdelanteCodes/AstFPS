# Released prototype comparison

This separate test-only project launches normal Minecraft 26.3 with Fabric API and an identical automation harness in all cases. It does not use the client gametest framework, which synchronizes game threads and can distort timing.

The baseline has no AstFPS JAR. The default case installs the current `1.0.0` JAR with its optional visibility memo disabled. The memo case installs the same JAR and enables that cache through the runtime feature gate. The comparison code is not packaged in AstFPS.

The workflow uses the same GitHub runner for three launches of each case, reversing order in the second repetition. Each launch creates a fixed flat world with seed 5600, 128 stationary cows, a fixed camera, and noon. Settings are 2560x1440, Fancy graphics, render distance 16, simulation distance 8, VSync off, and the vanilla unlimited FPS option. Terrain work settles before at least 30 seconds of warm-up, followed by 45–90 seconds of measurement. Frame intervals include normal game-loop work and pacing.

The report gives median FPS, 1% lows, p99 frame time, each paired FPS change, raw intervals, mod identities, and cache hit counts. Screenshots and logs accompany the report. Mesa software graphics and a synthetic fixed scene cannot establish FPS on the user's home PC, moving through new terrain, or a full modpack.

Run `./gradlew -p benchmarks/client runClient -PbenchmarkMode=baseline -PbenchmarkRunDirectory=run-baseline` to run the baseline locally. For default/memo cases, put the published runtime JAR in the selected run directory's `mods` folder first. Each comparison needs a fresh run directory. The workflow automates all nine launches and checks the downloaded release checksum.
