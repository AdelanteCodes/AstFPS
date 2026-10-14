# Xe-Mod

Public Minecraft Java optimization research and development project: https://github.com/KyzerGoated/Xe-Mod.

## Goal
One simple installation with customizable Quality, Balanced, Maximum FPS, and Custom profiles. Optional shaders have independent quality and appearance presets. Target Minecraft Java 26.3; verify compatible stable dependencies before pinning versions.

Target gaming PC: Ryzen 5 5600X, RTX 5060 Ti 16GB, 32GB DDR4, 1440p 300Hz monitor; typical render distance 16–20 chunks. CPU limitation is unconfirmed. No FPS improvement has been measured yet.

## Architecture
Start with our own Fabric client mod plus compatible upstream optimization dependencies. Prefer an installation package over flattening upstream JARs. Investigate supported nested-JAR packaging only after verifying licenses, loader behavior, duplicate detection, and compatibility. Preserve upstream mod IDs and notices. Never load duplicate copies.

The first milestone supplies profiling, configurable profiles, and a reproducible baseline. Reuse Sodium for terrain rendering; investigate ImmediatelyFast, EntityCulling, Lithium and memory optimizers individually, with version-specific evidence. Do not enable overlapping optimizations blindly. Iris and existing shaders are optional. A unified custom shader pack is a later milestone requiring an explicit source/license and rendering design review.

## Continue on another PC
Clone the repository, open its folder in Codex, and ask: "Read README.md, PLAN.md, and STATUS.md, then continue the next milestone."

Commit and push before switching computers; pull before starting. Project files carry the context; the chat itself is not included in Git.
