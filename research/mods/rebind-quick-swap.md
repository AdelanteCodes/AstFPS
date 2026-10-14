# Rebind Quick Swap

Review status: **Evidence inventory; behavioral review pending**

Project: [Rebind Quick Swap](https://modrinth.com/mod/rebind-quick-swap)
Selected artifact version: `2.1.0+26.3`
Published implementation source: https://github.com/Walksy/RebindQuickSwap
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Allows you to rebind the quick swap action (holding shift and clicking in the inventory)

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `2a05f3acddc79f0d835cfdb99a94bb02070be58f`
- `sha512`: `0bcb014d5296ac0bd0e416b41d188115a242e3a8dbb3cd96c9065c6ea7eb798a3e961ff9f6c9f5d81628a367b92a101d23bd597ff68bd0fed87ead8a2b5996fe`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 4
Reconstructed Java files: 4

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "walksy.quickswaprebinder.RebindQuickSwapMod"
  ],
  "walksylib": [
    "walksy.quickswaprebinder.config.RebindQuickSwapConfig"
  ]
}
```

**depends**

```json
{
  "minecraft": "26.3",
  "java": ">=25",
  "fabric-api": "*",
  "walksylib": ">=2.0.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `walksy/quickswaprebinder/config/RebindQuickSwapConfig.java` | `` |  | define |
| top-level / `walksy/quickswaprebinder/mixin/HandledScreenMixin.java` | `value={AbstractContainerScreen.class}, priority=1500)` | ModifyExpressionValue:2 | redirectClick, redirectRelease |
| top-level / `walksy/quickswaprebinder/mixin/RecipeBookComponentMixin.java` | `value={RecipeBookComponent.class}, priority=1500)` | Redirect:1 | redirectRecipeClick |
| top-level / `walksy/quickswaprebinder/RebindQuickSwapMod.java` | `` |  | onInitialize, shouldQuickSwap |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
