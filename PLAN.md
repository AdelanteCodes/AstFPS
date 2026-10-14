# Implementation milestones

1. Verify Minecraft 26.3 Fabric tooling, required JDK, and stable versions of each candidate dependency. Record source URLs, versions, hashes and notices. Set up Gradle wrapper and a client-only Fabric project with repeatable build instructions. The current machine has Java 17; do not assume it satisfies the target.
2. Build a bounded frame-time recorder and benchmark start/stop control. Export frame times plus game/mod versions, resolution, render and simulation distances, shader identity/preset and active profile. Keep benchmark results local; no telemetry.
3. Add Quality, Balanced, Maximum FPS and Custom controls with persistence and reset. Preserve render distance by default. Quality preserves visuals; any changes to visual quality in other profiles must be visible and reversible. Settings requiring restart must say so. Avoid overriding upstream settings without documented adapters and restoring saved values.
4. Establish a pinned dependency baseline. Compare each extra optimization against Sodium alone and the full baseline. Keep only compatible modules that help relevant scenes or solve a demonstrated memory/stutter issue. Choose a packaging format after compatibility checks; default to one installation package.
5. Profile on the gaming PC before developing new rendering patches. Select one demonstrated bottleneck, implement a feature toggle, and compare enabled/disabled behavior. No renderer replacement, arbitrary thread-priority tweaks or heap-size promises in the initial milestone.
6. Develop optional shader presets after the performance baseline works. Evaluate legally reusable shader sources, then specify one coherent pipeline; do not concatenate shader packs. Keep shader quality separate from performance profiles. No universal FPS guarantees.

## Validation
Build and launch a development client here if hardware/runtime permits. Check menus, world entry/reload, toggles, malformed settings recovery and dependency conflicts. Mark unavailable checks explicitly.

At home: benchmark standing still and traveling through warmed chunks, terrain, forests, dense entities/block entities and GUI-heavy scenes at 16 and 20 chunks. Compare shaders off/on and 1440p/1080p; repeat fixed routes three times. Record average FPS, p99 frame time and stalls. Compare visual correctness, shadows, transparency, particles and entity visibility. Never claim beating Sodium until repeated measurements support it at equivalent settings.

## Deliverables
Source, build instructions, repository handoff notes, version manifest and notices; then a tested mod JAR and installation package. Benchmark evidence is separate from compile success.
