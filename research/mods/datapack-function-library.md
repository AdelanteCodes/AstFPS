# datapack function library

Review status: **Evidence inventory; behavioral review pending**

Project: [datapack function library](https://modrinth.com/mod/datapack-function-library)
Selected artifact version: `5.0.0+mod`
Published implementation source: https://github.com/TouchController/E1epack/tree/main/subprojects/datapack-function-library
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This data pack provides developers with some useful functions and is compatible with all versions of Minecraft (except for those versions where data packs cannot be installed).

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha512`: `9651aeaf696065fa6c17e204f4c4849324e3dbc0384f00bd36302d9ceb31eddbafb4b5b38ecf69bdf94567adc74cce73173f5fb55eac8cd054e58e97c48ce19a`
- `sha1`: `f97211f4a8ba7341b7a3b94f5cb2f78a10549b4b`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 0
Reconstructed Java files: Not available

**environment**

```json
"*"
```

**depends**

```json
{
  "fabric-resource-loader-v0": "*"
}
```

## Data-driven behavior

Resource category counts: `dialog`: 2, `function`: 48, `functions`: 48, `tags`: 2.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
