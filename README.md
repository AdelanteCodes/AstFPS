# AstFPS 0.5.0-dev.6-local

Local experimental Fabric client build for Minecraft Java **26.3**, Java **25**, Fabric Loader **0.19.5+** and matching Fabric API **0.162.0+26.3**. Development snapshot published with user authorization. See OPTIMIZATION_PLAN.md for next priorities.

## Install later

Use `artifacts/AstFPS-0.5.0-dev.6-local.jar` with matching Fabric API. Remove older AstFPS and separate copies of the six bundled modules. No launcher or game configuration was modified during preparation.

## Three profiles

| Command | Current behavior |
|---|---|
| `/astfps profile quality` | Enables native ambient occlusion, detailed leaves, improved transparency and entity shadows; biome blend at least 2. Preserves resource packs and cloud choices. Shader integration pending. |
| `/astfps profile balanced` | Restores the captured visual baseline; shared optimizations remain active. |
| `/astfps profile maximum` | Clouds and entity shadows off; minimal particles; entity distance at most 0.75; biome blend disabled; weather radius at most 3; fast leaves and transparency; terrain distance capped at 8 chunks, preserving lower settings. |
| `/astfps profile restore` | Restores all ten captured options and releases the session baseline. |

Quality and Balanced preserve terrain distance; Maximum caps it at 8 chunks. Profiles preserve resolution, simulation, AI, ticks, textures, FPS limits and VSync. The baseline is captured once before the first profile change and survives repeated switches. Commands do not explicitly save options. Other game actions or shutdown may save current settings, so use Restore before leaving if you want your previous disk settings. Vanilla's preset label may remain Custom: restoring that label would reapply unrelated options. Profile switches are blocked while recording a benchmark.

## New original work

- Bounded compile-local block-state cache, keyed by exact captured region and coordinates. Misses, unsupported classes/bounds and nested calls delegate. All state/region references clear in finally; counters aggregate once per outer compilation.
- Exact-length CPU section-info array reuse for direct terrain submission. Entries clear after synchronous serialization; GPU slices and result draw lists keep engine ownership.
- Terrain preparation validates counts, alignment, offsets, index types and current buffer bounds before GPU writes; transparency order is preserved.
- Profiles and state-cache counters appear in status, diagnostics and benchmark exports. OptiFine/OptiFabric join the known renderer-conflict bypass.

These extend the original CPU submission stage. Vanilla still owns meshes, visibility, shader pipelines and GPU storage. Full independent rendering, smart animation tracking and shader integration remain unfinished.

## Optional experimental hooks

All original experimental hooks remain off by default; profile selection does not enable them. Startup flags:

```text
-Dastfps.enableTerrainBatcher=true
-Dastfps.enableSectionWorkerCache=true
-Dastfps.enableSectionStateCache=true
```

For block-state verification add `-Dastfps.verifySectionStateCache=true`: hits also invoke the original getter, compare identity and disable the cache on mismatch while returning the current result. Verification intentionally saves no lookup work. Unknown mods can add getter side effects or dynamic substitutions that unverified hits skip. The known noammaddons bypass does not establish general compatibility. No fluid, light, tint or block-entity cache was added.

Use `/astfps terrain false|true` and `/astfps state-cache false|true` to switch installed hooks. Failure disables the gate until restart. `-Dastfps.safeMode=true` disables AstFPS hooks; bundled modules keep their own configurations. Existing visibility memo, zero-offset and world-target flags remain available.

`/astfps status`, `/astfps diagnose`, `/astfps label <scene>` and `/astfps benchmark start|stop` provide local diagnostics and frame-start interval captures including pacing.

## Bundle and verification

ImmediatelyFast 1.17.1+26.3; Lithium 0.26.2+mc26.3; FerriteCore 9.0.0; ModernFix-mVUS 5.27.20-build.2; Jasione 1.0.9+26.1.2-fabric; Chunky 1.5.3. All six remain unmodified and credited. Chunky starts no job automatically. Sodium and OptiFine are not bundled or required.

Java 25 compilation and static archive/module/hash checks passed; see `artifacts/release-0.5.0-dev.6-local.json`. No Minecraft execution, unit tests, runtime compatibility checks, visual comparisons or FPS benchmarks were run. 60 to 150 FPS and 100 to 500 FPS remain targets with no measured guarantee.

Build: `gradlew.bat jar sourcesJar --no-daemon -x test -x coreChecks -x check`, then the static inspection/packaging scripts. The Windows build-only TCP selector workaround lives outside this copy and is not embedded in the JAR. See LOCAL-DEVELOPMENT.md for remaining work and PROJECT_LOG.md for earlier history. Maintained by AdelanteCodes.

## Local continuation 2026-10-15

Implemented a shared compile lifecycle, reusable mesh scratch, exact-version Fabric AO-helper reuse, direct terrain callback reuse, native vertex-format setup reuse, optional model rotation scratch, and bounded diagnostics. Java compilation and static package checks passed. New hooks remain opt-in; no game, unit tests, runtime parity or FPS measurements were run. Cube-vector pooling was rejected because bridge allocations could outweigh its saving. Full renderer and shader integration remain unfinished.
