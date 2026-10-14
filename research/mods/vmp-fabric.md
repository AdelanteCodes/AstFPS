# Very Many Players (Fabric)

Review status: **Artifact unavailable; implementation not verified**

Project: [Very Many Players (Fabric)](https://modrinth.com/mod/vmp-fabric)
Selected artifact version: `0.2.0+beta.7.238+26.3`
Published implementation source: https://github.com/RelativityMC/VMP-fabric
Artifact acquisition: Useful; latest and alternate downloads failed

## Purpose and applicability

A Fabric mod designed to improve server performance at high playercounts.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: Not available
Reconstructed Java files: Not available

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
