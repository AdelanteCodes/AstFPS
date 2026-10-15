# Current local plan

See LOCAL-DEVELOPMENT.md for current completed stages and remaining work. README.md describes the runnable three profiles and experimental flags. The bundle uses six credited, unmodified modules; original renderer development continues separately. Publication authorized by the user on 2026-10-15. See OPTIMIZATION_PLAN.md for the next priorities.

## Accepted selection strategy, 2026-10-15

User clarified: choose the best compatible option for each optimization category, not every mod. "Best" means a provisional fit supported by inspected implementation and native contracts; only matched benchmarks can establish performance winners. Do not accumulate overlapping engines just to increase the module count.

| Area | Selected foundation | Current status / limits |
| --- | --- | --- |
| Immediate rendering, HUD, text, maps | ImmediatelyFast | Bundled, pinned; avoid duplicating its batching/atlas hooks. |
| Game logic and integrated-server CPU | Lithium | Bundled; client-only deployment does not accelerate a remote server. |
| Block-state/model memory | FerriteCore | Bundled with existing compatibility override. |
| Resource/model loading | ModernFix-mVUS plus narrow AstFPS pack/texture helpers | Module bundled; AstFPS additions opt-in and runtime unverified. |
| Repeated enum allocation | Jasione | Bundled; do not duplicate values-array rewriting. |
| Terrain and native GPU submission | Original AstFPS native-engine integration | Existing opt-in terrain scratch/submission/FBO work; not a completed Sodium replacement. No Sodium dependency under current user constraint. |
| Hidden entities/block entities | EntityCulling design as the next conservative occlusion candidate | Not integrated. Prefer visual-only culling; resolve publication, stale-result and custom geometry boundaries first. Do not enable client tick suppression by default. |
| Local world pregeneration | Chunky | Bundled utility; optional user operation, not an automatic stationary-FPS accelerator. |
| Maximum-mode visual reductions | Native options plus narrow AstFPS container distance cap | Explicit tradeoffs; do not present as same-visual benchmark gains. |

Keep alternate full renderers, overlapping simulation engines, broad codec rewrites, unproven async world reads, placeholder texture eviction and native worldgen changes out of the default build. Krypton/ScalableLux/upscaling remain category candidates, not approved bundled additions merely because they advertise optimizations. Shader integration remains a later separate phase.

Next engineering priority is conservative visibility work with exact lifecycle ownership, followed by matched runtime validation when authorized. Do not imply that planning or compiling it means it is implemented or faster.
