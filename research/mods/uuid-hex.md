# UUID Hex

Review status: **Evidence inventory; behavioral review pending**

Project: [UUID Hex](https://modrinth.com/mod/uuid-hex)
Selected artifact version: `1.4+mod`
Published implementation source: https://github.com/CJDevZ/UUID-Hex
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

High-performance library for formatting UUIDs into hexadecimal strings.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha512`: `c01e7efe76144cf18586fab91a36376f622d0869d3e5f3225dc53b880057ada7dd563281704403265b598e5d2b01cbb09480f28d160d5f0f472a3b8ab9bbea40`
- `sha1`: `ff260224dac265d59d911ddc3a741fa65a131e08`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

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

Resource category counts: `function`: 5, `functions`: 5, `tags`: 2.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
