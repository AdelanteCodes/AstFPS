# AstFPS next optimization plan

## Current baseline

0.5.0-dev.6-local is a development snapshot: six bundled upstream modules, three visual profiles, and opt-in AstFPS experiments. Compilation and static archive checks passed. Runtime compatibility and FPS improvements are unmeasured; no 3x claim is established. The suffix is retained so the published bytes match the checked local build.

## Priority order

1. Measurement: when game execution is authorized, compare vanilla, the six-module baseline and AstFPS on identical scenes, settings and resource packs. Separate same-visual comparisons from Maximum-mode reductions. Record median FPS, 1% lows, frame-time percentiles, CPU/GPU timing, allocations, GC pauses and process/GPU memory. Include integrated Intel/AMD graphics and low-core-count CPUs. Warm up and repeat captures; keep changes only when improvements exceed run-to-run noise.
2. Visibility: prototype conservative entity/block-entity occlusion with bounded work and fail-open handling for camera changes, unloaded chunks, stale results, custom renderers and transparent occluders. Preserve simulation. Avoid GPU readbacks that stall integrated GPUs.
3. Chunk CPU work: profile section building, lighting/model lookup, allocation and upload preparation. Evaluate existing scratch/cache experiments individually before enabling defaults. Bound worker concurrency and retained scratch memory; prioritize nearby visible sections without starving background work.
4. GPU submission: reduce redundant draw setup, state changes, geometry and uploads within the original renderer. Verify transparency ordering and buffer lifetimes. Prefer reduced bandwidth and stable frame times on integrated GPUs; do not assume indirect drawing wins on every driver.
5. Memory and loading: measure retained caches versus allocation savings; enforce budgets and world/reload cleanup. Extend resource indexing only with preserved ZIP order, duplicate-entry and closure semantics. Keep mipmaps unless measurements justify a change; lower mip levels can increase sampling bandwidth and aliasing.
6. Profiles: preserve original visuals in Balanced; keep intentional visual reductions in Maximum. Evaluate configurable distance/particle budgets before adaptive control, with hysteresis to avoid rebuild oscillations. Do not sacrifice gameplay ticks for advertised FPS.
7. Compatibility and shaders: validate supported hardware and mod combinations, then integrate shader support as a separate stage. Promote experiments only after runtime validation; retain safe-mode and per-feature disable paths.

## Milestones

First establish a reproducible bottleneck report. Next ship one measured CPU/visibility win and one integrated-GPU/bandwidth win. Then promote only proven features to defaults. A 3x target is an aspiration for suitable CPU-bound scenes, not a release guarantee or a two-day commitment.
