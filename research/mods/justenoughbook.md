# Just Enough Book

Review status: **Evidence inventory; behavioral review pending**

Project: [Just Enough Book](https://modrinth.com/mod/justenoughbook)
Selected artifact version: `1.1.1-26.3`
Published implementation source: https://github.com/Rofumer/JEB/tree/master
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Just Enough Book (JEB) – Minecraft Recipe Book Mod

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `2451f99ab85e07e884e42e9c9af43fe574b106c6`
- `sha512`: `69dbbbdcd71d137b218221feb33357ad6be2fa08398c10f61eaa85a4ff21dd4c5c2312d186ffc3f5399d24746c0c13f51aabbf4f8378041bd63507bb821a6b9a`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 30
Reconstructed Java files: 28

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "jeb.client.JEBClient"
  ],
  "main": [
    "jeb.JEBMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "26.3.x",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `jeb/accessor/AnimatedResultButtonExtension.java` | `` |  |  |
| top-level / `jeb/accessor/ClientRecipeBookAccessor.java` | `` |  |  |
| top-level / `jeb/accessor/RecipeBookWidgetBridge.java` | `` |  |  |
| top-level / `jeb/client/FavoritesManager.java` | `` |  | loadFavoriteItemIds, removeFavorite, saveFavorite, readFavorites, writeFavorites, nativeCharset, sortFavorites, getServerName, getSerializedNbt |
| top-level / `jeb/client/JEBClient.java` | `` |  | generateCustomRecipeList, createDummyResultCollection, loadConfig, saveConfig, onInitializeClient |
| top-level / `jeb/client/RecipeIndex.java` | `` |  | resultKey, buildRecipeIndex, fastSearch, fastSearch, generateCustomRecipeList, createDummyResultCollection, fillItemIndex, recipeIdExistsInIndex, updateIndexesWithRecipe, addRecipeToCollectionIfAbsent, addAndIndexRecipeIfAbsent |
| top-level / `jeb/client/RecipeListScreen.java` | `` |  | init, printObjectDetails, printCategoryDetails, loadAllRecipes, showAllRecipes, onClose |
| top-level / `jeb/client/RecipeLoader.java` | `` |  | loadVanillaStats, tagSlot, getVanillaRecipeCount, getVanillaCTID, parseBracketedList, fixResourceName, loadRecipesFromLog, parseLineToRecipeEntry, parseRecipeIndex, parseGroup, parseCategory, extractItemIdFromItemSlot, parseItemSlotField, parseSingleCompositeItem, parseTagId, parseStationItem, parseStackResult, parseIngredientsFromLine, parseIngredientsFromRequirements, parseSmithingResultSlot, extractItemSlotDisplays, splitTopLevelSlotDisplays |
| top-level / `jeb/client/RecipeSearchQueries.java` | `` |  | forResult, forIngredient |
| top-level / `jeb/client/SearchHistoryEntry.java` | `` |  | SearchHistoryEntry |
| top-level / `jeb/JEBMod.java` | `` |  | onInitialize |
| top-level / `jeb/mixin/AbstractContainerScreenAccessor.java` | `value={AbstractContainerScreen.class})` | Accessor:1 |  |
| top-level / `jeb/mixin/AbstractCraftingRecipeBookWidgetMixin.java` | `value={CraftingRecipeBookComponent.class})` | Inject:1, Redirect:1 | alwaysDisplayRecipes, jeb$replaceTabs |
| top-level / `jeb/mixin/AnimatedResultButtonMixin.java` | `value={RecipeButton.class})` | Inject:2, Redirect:1 | jeb$flash, jeb$isFlashing, jeb$drawBorderCompat, jeb$renderFlash, redirectFilter, onGetTooltip |
| top-level / `jeb/mixin/ClickableWidgetAccessor.java` | `value={AbstractWidget.class})` | Accessor:2 |  |
| top-level / `jeb/mixin/ClientPlayNetworkHandlerMixin.java` | `value={ClientPacketListener.class})` | Inject:2 | injectOnRecipeBookAdd, afterRecipeBookAdd |
| top-level / `jeb/mixin/ClientRecipeBookMixin.java` | `value={ClientRecipeBook.class})` | Accessor:1, Inject:1 | injectToGroupedMap |
| top-level / `jeb/mixin/RecipeAlternativesWidgetMixin.java` | `value={OverlayRecipeComponent.class})` | Redirect:1 | redirectList2Filter |
| top-level / `jeb/mixin/RecipeBookHoverHotkeyMixin.java` | `value={AbstractRecipeBookScreen.class})` | Inject:1 | jeb$onHoverHotkey |
| top-level / `jeb/mixin/RecipeBookResultsAccessor.java` | `value={RecipeBookPage.class})` | Accessor:2 |  |
| top-level / `jeb/mixin/RecipeBookResultsMixin.java` | `value={RecipeBookPage.class})` | Inject:1 | onRightClickInject, canDisplay |
| top-level / `jeb/mixin/RecipeBookWidgetAccessor.java` | `value={RecipeBookComponent.class})` | Invoker:3, Accessor:5 |  |
| top-level / `jeb/mixin/RecipeBookWidgetMixin.java` | `value={RecipeBookComponent.class})` | Inject:2 | onRecipeClicked, items$beforeSetResults, getItemFromSlotDisplay |
| top-level / `jeb/mixin/RecipeBookWidgetSearchMixin.java` | `value={RecipeBookComponent.class})` | ModifyVariable:1, Inject:7 | jeb$refresh, jeb$history, jeb$pushHistory, jeb$goBack, jeb$hasHistory, jeb$restoreSearchOnFirstInit, jeb$addCustomToggleButton, jeb$renderCustomToggle, populateAllRecipes, jeb$clickCustomToggle, isFavoritesTabActive, onKeyPressed, onRecipeClicked, recipeDisplayMatchesIngredientQuery, recipeResultMatchesQuery, createDummySingleItemRecipe, onCustomSearch, jEB$sortCraftableFirst, canDisplay |
| top-level / `jeb/mixin/RecipeGroupButtonWidgetMixin.java` | `value={RecipeBookTabButton.class})` | Inject:1 | updateVisibilityMethod |
| top-level / `jeb/mixin/RecipeResultCollectionMixin.java` | `value={RecipeCollection.class})` | Inject:1 | showAllRecipes |
| top-level / `jeb/mixin/ServerRecipeBookMixin.java` | `value={ServerRecipeBook.class})` | Inject:1 | injectAllRecipes |
| top-level / `jeb/server/JEBServer.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
