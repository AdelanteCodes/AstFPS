# Local development checkpoint

## Further integration: 0.5.0-dev.5-local

Added four opt-in feature groups: OpenGL FBO lookup probe (preserves native FBO creation/destruction), bounded negative ZIP resource lookups, allocation-reduced texture-reference lookup during model baking, and Maximum-profile 32-block ordinary chest/shulker rendering distance. The last is an intentional visual tradeoff and never changes ticking. Startup properties: astfps.enableFboLookupProbe, astfps.enableZipEntryMissCache, astfps.enableTextureSlotSuffixLookup, astfps.enableMaximumBlockEntityDistance. All default off; known competing modules are gated where relevant. No module binaries added or changed. Native contracts and limitations are recorded in work/dev5-integration-notes.md and the referenced evidence files. FPS and runtime compatibility remain unmeasured.

## Full inventory continuation: 0.5.0-dev.4-local

All 410 inventory entries now have second-pass applicability dispositions. The consolidated ledger and 732 verified source/resource receipts are in the workspace work/full-pass-summary.json and full-pass-1/2/3 files. Coverage is explicitly scoped, not exhaustive source understanding or a claim of 410 implemented mods.

New original changes: bounded tab-list sorted-result reuse after checking all native comparator inputs and source order; reload-time renderer identity indexing replaces the discarded per-lookup wrapper; native pack resource path concatenation avoids Formatter; terrain direct section-info arrays reuse up to four exact lengths with one combined 16,384-reference budget; state-cache cleanup indices use shorts, saving 16,000 array payload bytes per initialized worker.

Startup experiments remain opt-in: astfps.enableTabListCache, astfps.enableRendererIdentityIndex, astfps.enablePackResourcePath. Tab cache has a runtime tab-list command and failure gate; renderer indexing and pack-path hooks require startup/reload semantics and are not advertised as dynamically reversible. Existing terrain/state startup flags control their new scratch changes. Known overlapping mods cause bypass. Unknown injected callbacks and full runtime Mixin compatibility remain unverified. No new module JARs were bundled; the same six retained modules are unchanged. No default FPS gain or 3x target achievement is claimed.

2026-10-15 follow-up: 0.5.0-dev.3-local compiled and packaged successfully. Added startup-only experiments for renderer type lookups, exact VarInt sizing, and compact identifier encoding. All remain off by default. Renderer lookup wrapper/guard cost may exceed the lookup saving; no net benefit claimed. Identifier shortening affects outgoing serialization, not remote-server rendering or incoming traffic. Six bundled modules remain unchanged. All 55 recorded review entries received integration dispositions; this does not mean 55 mods were bundled or every feature implemented. No Minecraft, unit tests or FPS benchmarks executed. Original repository remains unchanged.

2026-10-15: local-only 0.5.0-dev.2-local, based on 0.4.0-dev.5. Original Git checkout unchanged. No publication operation was performed. This restriction remains until the user changes it.

Completed: selected core study of 27 downloaded mods; deeper Sodium capture/meshing, visibility/transparency and GPU lifecycle studies; OptiFine documented-feature review; three native visual profiles; compile-local state memo; direct terrain array reuse; offset validation; diagnostics; compilation and static package verification.

Research is in sibling important-mod-study. The original 410-artifact survey is a first pass, not an exhaustive source audit. Current Sodium source HEAD03198cb36ab831c99694403d18e4cf4a1726df72 differs from acquisition-reported07b349c6c85d34bbff721438fb57c815964d3fcf; release-binary match remains unproven. Source paths, hashes and line bounds were checked. No Sodium or OptiFine implementation code was copied into AstFPS.

Remaining engineering:

1. Matched later PC captures and individual gate comparisons using Balanced. Cross-profile comparisons must disclose different visuals.
2. Original mesh output with vanilla vertex fidelity, AO, fluids, tint, custom models and Fabric APIs; explicit world/model generation publication and cancellation.
3. Portable GPU arenas, relocation-aware command caching and resource retirement under actual engine synchronization contracts.
4. Conservative visibility and sprite-use tracking across terrain, entities, items, UI and shader shadow/reflection passes.
5. Version-specific shader bridge. Quality selects native fidelity options; it does not load shaders or prove Iris compatibility with the original renderer.
6. Static block-entity batches, bounded scheduling and exact storage/SIMD work where profiling identifies material cost. Avoid overlapping bundled-module hooks blindly.

The full performance objective remains open. Compilation does not establish visual parity, broad compatibility or speed. A complete renderer/shader adapter has no reliable completion ETA yet.

## Local continuation 2026-10-15

Implemented a shared compile lifecycle, reusable mesh scratch, exact-version Fabric AO-helper reuse, direct terrain callback reuse, native vertex-format setup reuse, optional model rotation scratch, and bounded diagnostics. Java compilation and static package checks passed. New hooks remain opt-in; no game, unit tests, runtime parity or FPS measurements were run. Cube-vector pooling was rejected because bridge allocations could outweigh its saving. Full renderer and shader integration remain unfinished.


## Local dev.6: weak-PC Maximum profile

Maximum now caps native terrain render distance at eight chunks (never raises a lower baseline), uses minimal particles and disables biome blending. Resolution, simulation distance and gameplay ticks remain unchanged. These are explicit visual reductions, not same-scene engine speedups. All ten options are captured and restored across profile switches. Each profile now applies final values directly instead of restoring the baseline before reducing it, avoiding unnecessary intermediate option callbacks and rebuild requests. Native option setters retain ownership of distance updates. Compile/static validation only; FPS, integrated-GPU memory savings and runtime behavior remain unmeasured.
