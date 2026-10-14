# Carpet PRY Addition

Review status: **Artifact unavailable; implementation not verified**

Project: [Carpet PRY Addition](https://modrinth.com/mod/carpet-pry-addition)
Selected artifact version: `v1.3.0-mc26.3`
Published implementation source: https://github.com/brokeyuan/Carpet-Primaryuan-Addition
Artifact acquisition: Error: The read operation timed out

## Purpose and applicability

A Carpet Mod (fabric-carpet) extension that contains some useful functions for Improve the experience

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

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
