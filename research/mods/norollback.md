# NoRollback

Review status: **Evidence inventory; behavioral review pending**

Project: [NoRollback](https://modrinth.com/mod/norollback)
Selected artifact version: `2.2.0`
Published implementation source: https://github.com/Solmeye/NoRollback
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Remove (annoying) rollbacks

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha512`: `6be868d8df4f110c6055a30df48114fb5f7a88681fa34774f7791d92ca5b8ac9f92aaf025d94e2bfbba8174c764da5310ebea67e6e8fc8781c9f377d3e8976d2`
- `sha1`: `4b5dd192cc85c52f08f567eef86958a4a60b6e39`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

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
| top-level / `com/modrinth/K4Ytaql5/ModrinthWrapper.java` | `` |  |  |

## Data-driven behavior

Resource category counts: `function`: 4, `functions`: 1, `tags`: 2.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
