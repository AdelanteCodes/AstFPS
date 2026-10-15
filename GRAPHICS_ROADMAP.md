# Original renderer and the 5x target

Local continuation: README.md and LOCAL-DEVELOPMENT.md describe 0.5.0-dev.1-local. Sections below retain the previous 0.4.0-dev.5 stage. Full renderer and shader integration remain pending.

User direction: build original terrain-rendering code, do not depend on Sodium.
The user will run before/after captures on their PC later. Minecraft execution
and runtime tests remain off in this environment. The active goal is not achieved.

## Current original stage: 0.4.0-dev.5

AstFPSTerrainBatcher independently collects visible section draws, groups opaque
commands by actual GPU-buffer identity within each terrain layer, and submits
indirect command lists through Minecraft's portable GPU API. Empty layers skip
dispatcher buffer lookups; ordered transparency only groups adjacent compatible
draws, then preserves the engine's reverse submission order. No meshes, lights,
textures, visible entities, particles, resolution or distance settings are reduced.

This replaces CPU preparation for both the engine's direct and indirect terrain paths. It still
uses vanilla meshing, visibility, GPU allocation and shader pipelines. It is not
a completed independent terrain engine or a demonstrated Sodium replacement.
Minecraft 26.3 already has shared terrain buffers and indirect multi-draw; adding
those names alone is not evidence of a speedup. Our stage could still regress.

Opt in with -Dastfps.enableTerrainBatcher=true. The hook is skipped in AstFPS safe mode
and when Sodium, Iris, Nvidium, VulkanMod, VulkanFlow or Meshelium is loaded.
Unrecognized renderer mods remain unassessed. On devices where Minecraft chooses
direct drawing, our stage constructs direct draw descriptors instead of requiring indirect hardware support. The first RuntimeException disables
our stage, records a stack trace and leaves the vanilla method uncancelled.
This is a defensive fallback, not proof that every runtime error is recoverable.

Use /astfps terrain false|true to switch installed paths between captures. Changing
the backend or scene label while recording is disallowed. /astfps diagnose reports
frames, section draws, GPU batches, fallbacks and startup hook receipts.

## What 5x means

100 FPS averages 10 ms per frame. 500 FPS averages 2 ms per frame: 400% more FPS
and 80% less frame time. The monitor's 300 Hz refresh does not prevent uncapped
rendering of 500 FPS, but it does not display 500 distinct full refreshes/second.
A VSync/FPS cap can obscure gains. AstFPS does not change those options for users.

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

## dev.2 CPU reuse and direct backend

Renderer-owned scratch now reuses layer containers, grouping maps and immutable
integer-only command records when all five command fields match. GPU buffer
identities/offsets are re-read every frame under the dispatcher lock; no GPU slices,
meshes, world objects or mutable render commands are cached across frames.
Scratch drops GPU references in a finally block, limits retained records to 16,384
across at most 32 batches per layer, trims high-water arrays, and is released on
renderer close or feature failure. Direct descriptors capture uniform indices by
value and have frame-owned result lists.

Vanilla DynamicGpuDataStorageMapped.writeDataBatchedMultiple serializes command
lists synchronously inside a mapped-view scope and retains only the last immutable
record; this was checked against the 26.3 client bytecode/decompilation before
adding CPU scratch reuse. GPU storage and in-flight lifetime management remain
vanilla. Compilation does not establish visual parity or an FPS gain.

## 0.4.0-dev.5 — terrain preparation allocation reduction

Continued the original graphics stage after the identity update. Reuse immutable
section origin/fade records only when every primitive field matches exactly,
including raw float bits. Still recompute visibility every frame and upload current
data through vanilla storage. Truncate old list tails before every upload; retain
at most 16,384 primitive-only records per renderer. Remove per-vertex candidate-list
allocations with pooled batch chains; reuse reverse command-list views. Clear batch
chains and GPU references in finally. Added section-record allocated/reused counters
to status, diagnostics and capture exports. See research/renderer-section-record-reuse.md
for vanilla writer contracts and the bounded-retention tradeoff. The feature remains
opt-in; no Minecraft execution, FPS gain or visual parity is claimed.
