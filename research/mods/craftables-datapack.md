# Craftables

Review status: **Evidence inventory; behavioral review pending**

Project: [Craftables](https://modrinth.com/mod/craftables-datapack)
Selected artifact version: `1.16-26.3+mod`
Published implementation source: https://github.com/MrCoderPro123/Craftables-Data-Pack
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A Datapack that makes Uncraftable things Craftable!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha512`: `3691e5de1c50e8f5ecc36a7099b81900569fc8ae9c454a737f58b4c35d9987e7f0e03c88062cbe35eca51daa3f3ecc00bfb721fa295a1514d09c48c8d10349a9`
- `sha1`: `01c83b0708080946fbe259cf09e6462a0869b099`

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

Resource category counts: `advancement`: 10, `function`: 2, `recipe`: 117, `tags`: 2.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
