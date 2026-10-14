# Optimization research

## Evidence and current limits
Collection targets Modrinth projects tagged optimization and advertising Fabric + Minecraft 26.3. Category matches include unrelated utilities; inclusion does not imply an FPS benefit or compatibility. Versions, publisher hashes, dependencies, channels, licenses and source URLs are recorded locally. All downloaded files must be screened before integration.

Archive inventories establish entrypoints, mixin names, declared dependencies and embedded libraries. They do not establish algorithmic correctness or runtime behavior. Published source is preferred; decompiled output must be labeled and checked against bytecode. Reviewed default branches may differ from downloaded release versions. Match release commits before adopting code.

## Initial foundations
| Project | Mechanism supported by initial evidence | Xe-Mod implication |
|---|---|---|
| Sodium | Terrain geometry construction workers, section visibility, region management and GPU upload scheduling | Baseline terrain renderer; avoid layering competing terrain hooks without explicit integration |
| ImmediatelyFast | Batches immediate-mode rendering and GPU uploads for entities, particles, text and HUD | Candidate complement to terrain optimization; test modded rendering and shader compatibility |
| EntityCulling | Async visibility tracing and configurable client entity tick culling | Candidate reduction of hidden entity work; out-of-bounds renderers and shader shadows need correctness tests |
| FerriteCore | Shared and compact structures reduce memory used by block states/models | Memory benefits are distinct from immediate FPS gains; verify with heap measurements |
| Lithium | Simulation and allocation optimizations across AI, block ticking, entities and other systems | Especially relevant to integrated-server load; do not assume remote-server simulation becomes faster |
| MoreCulling | Model/face visibility hooks; archive includes block, item-frame, painting and Sodium compatibility mixins | Overlaps with other culling systems; screen visual tradeoffs and compatibility |
| Nvidium | NVIDIA-specific alternative Sodium rendering backend; source checks mesh shader, bindless drawing and sparse-buffer capabilities | Interesting for the target NVIDIA PC; capability and Iris/shader compatibility must be tested on exact versions |
| C2ME | Multiple chunk scheduling, IO, worldgen and threading modules | Separate chunk-generation/loading performance from steady-state rendering; concurrency correctness must be validated |

## Source references
- https://github.com/CaffeineMC/sodium/blob/dev/common/src/main/java/net/caffeinemc/mods/sodium/client/render/chunk/RenderSectionManager.java
- https://github.com/CaffeineMC/sodium/blob/dev/common/src/main/java/net/caffeinemc/mods/sodium/client/render/chunk/compile/executor/ChunkBuilder.java
- https://github.com/RaphiMC/ImmediatelyFast
- https://github.com/tr7zw/EntityCulling
- https://github.com/malte0811/FerriteCore/blob/26.1/summary.md
- https://github.com/CaffeineMC/lithium
- https://github.com/FxMorin/MoreCulling
- https://github.com/MCRcortex/nvidium/blob/dev/src/main/java/me/cortex/nvidium/Nvidium.java
- https://github.com/RelativityMC/C2ME-fabric

## Per-project audit procedure
1. Match the downloaded version to a source tag/commit; record uncertainty if not resolvable.
2. Trace initialization, mixin targets, state lifecycle, data structures, allocation and threading behavior.
3. Describe which work is removed, cached, batched or moved off-thread, with code references.
4. Identify invalidation rules, correctness risks, configuration tradeoffs and overlapping hooks.
5. Record applicable license and notices before reusing any implementation in the public project.
6. Validate behavior in controlled scenes; distinguish measured improvement from inference.

No claim of complete understanding of every collected project has been made. The source audit is an ongoing research milestone.
