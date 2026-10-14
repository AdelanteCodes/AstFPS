# Fast Recipe

Review status: **Evidence inventory; behavioral review pending**

Project: [Fast Recipe](https://modrinth.com/mod/fast-recipe)
Selected artifact version: `1.0.3+26.3+fabric`
Published implementation source: https://github.com/ZipeStudio/Fast-Recipe
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Adds quick crafting in the recipe book. Press [Ctrl + LMB] on a recipe to craft it instantly.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `a2122b3316c58f99e510cdd6a56214ed06d306f9`
- `sha512`: `682ab79f6373c59dcc142090eaa967e31af8bb9a495e69ed214e625c69c4e2409fff18380bd201dc0fcb1bd1f80b012ae93e64c6b9d1fea69a5a5af181b91414`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 9
Reconstructed Java files: 9

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "me.zipestudio.fastrecipe.entrypoint.CommonEntrypoint"
  ],
  "client": [
    "me.zipestudio.fastrecipe.entrypoint.ClientEntrypoint"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": ">=26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

**accessWidener**

```json
"aws/fabric-26.3.classTweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/zipestudio/fastrecipe/client/FSClient.java` | `` |  | getSlotListener, canStartWaiting, onInitializeClient, setWaitingResult, getWaitingResult |
| top-level / `me/zipestudio/fastrecipe/entrypoint/ClientEntrypoint.java` | `` |  | onInitializeClient |
| top-level / `me/zipestudio/fastrecipe/entrypoint/CommonEntrypoint.java` | `` |  | onInitialize |
| top-level / `me/zipestudio/fastrecipe/FSServer.java` | `` |  | onInitialize |
| top-level / `me/zipestudio/fastrecipe/mixin/AbstractContainerMenuMixin.java` | `value={AbstractContainerMenu.class})` | Inject:1 | startListening |
| top-level / `me/zipestudio/fastrecipe/mixin/RecipeBookComponentMixin.java` | `value={RecipeBookComponent.class})` | Inject:1 | init |
| top-level / `me/zipestudio/fastrecipe/mixin/SlotMixin.java` | `value={Slot.class})` | Inject:1 | fastRecipe$setListener, setStackNoCallbacks |
| top-level / `me/zipestudio/fastrecipe/slot/ListenableSlot.java` | `` |  |  |
| top-level / `me/zipestudio/fastrecipe/slot/SlotListener.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
