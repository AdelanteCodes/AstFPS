# Original renderer and the 5x target

User direction: build original terrain-rendering code, do not depend on Sodium.
The user will run before/after captures on their PC later. Minecraft execution
and runtime tests remain off in this environment. The active goal is not achieved.

## Current original stage: 0.4.0-dev.1

XeTerrainBatcher independently collects visible section draws, groups opaque
commands by actual GPU-buffer identity within each terrain layer, and submits
indirect command lists through Minecraft's portable GPU API. Empty layers skip
dispatcher buffer lookups; ordered transparency only groups adjacent compatible
draws, then preserves the engine's reverse submission order. No meshes, lights,
textures, visible entities, particles, resolution or distance settings are reduced.

This replaces CPU preparation for the engine's indirect terrain path. It still
uses vanilla meshing, visibility, GPU allocation and shader pipelines. It is not
a completed independent terrain engine or a demonstrated Sodium replacement.
Minecraft 26.3 already has shared terrain buffers and indirect multi-draw; adding
those names alone is not evidence of a speedup. Our stage could still regress.

Opt in with -Dxe.enableTerrainBatcher=true. The hook is skipped in Xe safe mode
and when Sodium, Iris, Nvidium, VulkanMod, VulkanFlow or Meshelium is loaded.
Unrecognized renderer mods remain unassessed. On devices where Minecraft chooses
direct drawing, that path stays vanilla. The first RuntimeException disables
our stage, records a stack trace and leaves the vanilla method uncancelled.
This is a defensive fallback, not proof that every runtime error is recoverable.

Use /xe terrain false|true to switch installed paths between captures. Changing
the backend or scene label while recording is disallowed. /xe diagnose reports
frames, section draws, GPU batches, fallbacks and startup hook receipts.

## What 5x means

100 FPS averages 10 ms per frame. 500 FPS averages 2 ms per frame: 400% more FPS
and 80% less frame time. The monitor's 300 Hz refresh does not prevent uncapped
rendering of 500 FPS, but it does not display 500 distinct full refreshes/second.
A VSync/FPS cap can obscure gains. Xe-Mod does not change those options for users.

There is no measured percentage for this package. ImmediatelyFast's author reports
an old entity-heavy benchmark with Sodium going from 21 to 82 FPS (~3.90x), using
1,000 cows on Minecraft 1.19.3 and different hardware. That is a specific historical
workload, not evidence of 5x on Minecraft 26.3 or our code. Component gains cannot
be multiplied or added to forecast the package. Source:
https://github.com/RaphiMC/ImmediatelyFast#performance

## Remaining engineering

1. Obtain matched PC captures before making performance claims; compare original
   terrain submission against vanilla submission with all other bundled modules
   unchanged. Capture CPU/GPU profiles separately to locate remaining expensive work.
2. If CPU submission dominates, examine reusable frame-owned command storage and
   stable topology caching. First establish GPU-buffer relocation and resource-reload
   invalidation contracts; never cache stale slices or reuse in-flight commands.
3. Develop original section mesh compilation and vertex packing incrementally,
   preserving ambient occlusion, biome tint, lighting, animated textures, fluid
   surfaces, modded block models and resource reloads. Keep vanilla fallback for
   unsupported models and transparent geometry until equivalence is established.
4. Develop conservative hierarchical visibility using published geometry concepts.
   Retain all geometry whose occlusion is uncertain; do not use stale async results
   to claim unchanged visuals. Current vanilla visibility remains authoritative.
5. Build GPU resource lifetime management, capability-based direct/indirect backends,
   mod compatibility checks and visual comparison coverage before enabling a full
   renderer by default. Do not require a GPU vendor or NVIDIA-only extensions.

No deadline, universal multiplier or 500-FPS guarantee is established. The 5x
target remains active and requires real measurements of a fixed agreed workload.
