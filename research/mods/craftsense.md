# CraftSense

Review status: **Evidence inventory; behavioral review pending**

Project: [CraftSense](https://modrinth.com/mod/craftsense)
Selected artifact version: `2.0.0`
Published implementation source: https://github.com/dooji2/craftsense/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Autocomplete for the crafting table. It tracks what you craft, suggests recipes, and lets you take the result from the output slot without placing the rest of the ingredients!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha512`: `02d4948c0f5f6e5a50405669454666b930172d21ecef9fff6662ad5d26620b17fd9ff9fb4ffedb208253a2c93c783129de0132b4c6472584119d45684ddd3fcc`
- `sha1`: `fcc7a99031f4fd86a9e30bb0eed3b057b7a79f49`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 26
Reconstructed Java files: 22

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.dooji.craftsense.CraftSense"
  ],
  "client": [
    "com.dooji.craftsense.CraftSenseClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": ">=0.161.0+26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/dooji/craftsense/CraftingPredictor.java` | `` |  | getInstance, setRecipes, getRecipes, getRecipeId, getIngredients, fits, getResult, getCraftingRecipes, getAvailableItems, isGridEmpty, copyItemStacks, decrementAvailableItemCount, itemsAndComponentsMatch, suggestRecipe, hasRequiredIngredients, calculateMatchScore, calculateInputHash, matchShapedRecipe, matchShapelessRecipe, playerInventoryContainsWeapon, suggestCombatRecipe, suggestLastCraftedItem |
| top-level / `com/dooji/craftsense/CraftSense.java` | `` |  | onInitialize |
| top-level / `com/dooji/craftsense/CraftSenseClient.java` | `` |  | onInitializeClient |
| top-level / `com/dooji/craftsense/manager/CategoryGenerator.java` | `` |  | generateCategories, formatCategoryName, capitalize, pluralize, isVowel, saveCategoriesToFile |
| top-level / `com/dooji/craftsense/manager/CategoryHabitsTracker.java` | `` |  | getInstance, load, readCounts, save, recordCraft, getCraftCount, getItemCraftCount, getLastCraftedItem |
| top-level / `com/dooji/craftsense/manager/CategoryManager.java` | `` |  | getCategory |
| top-level / `com/dooji/craftsense/manager/ConfigurationManager.java` | `` |  | isFirstTime, toggleFirstTime, loadConfig, saveConfig |
| top-level / `com/dooji/craftsense/manager/CraftSenseTracker.java` | `` |  | checkPlayerConditions, triggerCombatCondition, isPrioritizingCombatItems |
| top-level / `com/dooji/craftsense/mixin/CraftingEventMixin.java` | `value={Item.class})` | Inject:1 | onCraft |
| top-level / `com/dooji/craftsense/mixin/CraftingScreenHandlerAccessor.java` | `value={AbstractCraftingMenu.class})` | Accessor:1 |  |
| top-level / `com/dooji/craftsense/mixin/CraftingScreenMixin.java` | `value={AbstractRecipeBookScreen.class})` | Inject:2 | renderCraftingPrediction, onSuggestedRecipeClick, renderShapedRecipeIngredients, renderShapelessRecipeIngredients, renderGhostItem, drawTransparentRectangle, isMouseOverSlot, renderTooltip |
| top-level / `com/dooji/craftsense/mixin/HandledScreenAccessor.java` | `value={AbstractContainerScreen.class})` | Accessor:2 |  |
| top-level / `com/dooji/craftsense/mixin/RecipeBookScreenAccessor.java` | `value={AbstractRecipeBookScreen.class})` | Accessor:1 |  |
| top-level / `com/dooji/craftsense/mixin/StatsScreenMixin.java` | `value={StatsScreen.class})` | ModifyArg:1, Inject:1 | addCraftSenseTab, setCraftSenseTabActive |
| top-level / `com/dooji/craftsense/network/CraftSenseClientNetworking.java` | `` |  | init, recordCraft |
| top-level / `com/dooji/craftsense/network/CraftSenseNetworking.java` | `` |  | init, handleCraftItemPayload, selectIngredients, createRecipeInput, canInsertResult |
| top-level / `com/dooji/craftsense/network/payloads/CraftItemPayload.java` | `` |  | type |
| top-level / `com/dooji/craftsense/network/payloads/RecipesPayload.java` | `` |  | type |
| top-level / `com/dooji/craftsense/network/payloads/RecipesRequestPayload.java` | `` |  | type |
| top-level / `com/dooji/craftsense/network/payloads/RecordCraftPayload.java` | `` |  | type |
| top-level / `com/dooji/craftsense/ui/CraftSenseStatsListWidget.java` | `` |  | getRowWidth, entriesCanBeSelected, extractListBackground, extractListSeparators, mouseClicked, extractContent, getNarration |
| top-level / `com/dooji/craftsense/ui/CraftSenseStatsTab.java` | `` |  | doLayout |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
