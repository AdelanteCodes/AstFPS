# A* Pathfinding

Review status: **Evidence inventory; behavioral review pending**

Project: [A* Pathfinding](https://modrinth.com/mod/a-star-pathfinding)
Selected artifact version: `0.7.3+mod`
Published implementation source: https://github.com/CJDevZ/A-Star-Pathfinding
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Minecraft Pathfinder for Entities

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha1`: `1d1761b9c0120ba35cb2d1a6213912d51576e329`
- `sha512`: `9c5c9026fe2ce54a60693f940ed919535e1ef25d318ce885c321d9a3c0bff09c085c0dda18c323221686b06100ce08f63fe1e93c2cc4c4faeb24ff2545f2d8a0`

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

Resource category counts: `context_float_provider`: 1, `context_int_provider`: 2, `function`: 18, `predicate`: 12, `tags`: 11.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
