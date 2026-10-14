# Random Death Drop

Review status: **Evidence inventory; behavioral review pending**

Project: [Random Death Drop](https://modrinth.com/mod/random-death-drop)
Selected artifact version: `fabric`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This Plugin adds at every dead one inventary slot drops or armor slot the cpability is variable in config or In-Game GUI

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unknown`. Server support: `unknown`.

Artifact identity:
- `sha1`: `71a51c940b69dc91d01381f5ad2172efc38ef404`
- `sha512`: `8b8ca54e14c4ce535ac5e2e4bb0f146f3096ad87cc9d6df3f3968b0800c20be5b1eb628862ca11e872e561d76bd6ca8783bc14c86feaafc9790457cfb6f5dd28`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 6
Reconstructed Java files: 4

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "de.josias.deathdroprandom.DeathDropRandom"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.0",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `de/josias/deathdroprandom/DeathDropRandom.java` | `` |  | onInitialize, onPlayerDeath, findKiller |
| top-level / `de/josias/deathdroprandom/DropManager.java` | `` |  | dropRandomItems, dropKillerHead, getRandomSlots, getRandomDrop, getRandomHead, normalizeId, create, spawn |
| top-level / `de/josias/deathdroprandom/ModConfig.java` | `` |  | load, save |
| top-level / `de/josias/deathdroprandom/SkillManager.java` | `` |  | addKill, resetKills, getKills, updateActionBar |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
