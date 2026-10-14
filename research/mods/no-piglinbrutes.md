# No Piglin Brutes

Review status: **Evidence inventory; behavioral review pending**

Project: [No Piglin Brutes](https://modrinth.com/mod/no-piglinbrutes)
Selected artifact version: `1+mod`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

original no piglin brutes after 1.16.1 version on planetminecraft.com

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha512`: `66229e0a6aec2a5029e9a51ead078b550e28d501b379b67269a808063ee9eff422c326a155e12dea4ddfd162e4bea7983f288c3114f0a9cc08dc2126e929e2a0`
- `sha1`: `0e9fc36c7917f9418f6023ed0dd1edfc23dd4d4d`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 1
Reconstructed Java files: 1

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

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/modrinth/_9nQCRwx/ModrinthWrapper.java` | `` |  |  |

## Data-driven behavior

Resource category counts: `advancements`: 2, `functions`: 2, `tags`: 2.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
