# Lightweight Inventory Sorting

Review status: **Evidence inventory; behavioral review pending**

Project: [Lightweight Inventory Sorting](https://modrinth.com/mod/lightweight-inventory-sorting)
Selected artifact version: `1.1.7+26.3`
Published implementation source: https://github.com/borknbeans/LightweightInventorySorting
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Lightweight client-side inventory sorting with no extra fluff

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `41152ab137a60c80c0f949553fcd6c7388db14702dfb182e31526261dc2bb956e8d9de9d7436f21f3a040660667e5655fcbdcdb894fe82fb4cf063ab80e7ad08`
- `sha1`: `9b557c77f39e565f8f3be6685c1f0bdba7f14c02`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 22
Reconstructed Java files: 18

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "borknbeans.lightweightinventorysorting.LightweightInventorySorting"
  ],
  "client": [
    "borknbeans.lightweightinventorysorting.LightweightInventorySortingClient"
  ],
  "modmenu": [
    "borknbeans.lightweightinventorysorting.config.ModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16.14",
  "minecraft": ">=26.3 <26.4",
  "java": ">=21",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `borknbeans/lightweightinventorysorting/config/ButtonSize.java` | `` |  | getButtonSize, getButtonTexture, getButtonHoverTexture |
| top-level / `borknbeans/lightweightinventorysorting/config/Config.java` | `` |  | load, save |
| top-level / `borknbeans/lightweightinventorysorting/config/ModMenu.java` | `` |  | getModConfigScreenFactory, createConfigScreen |
| top-level / `borknbeans/lightweightinventorysorting/config/SortType.java` | `` |  | compare |
| top-level / `borknbeans/lightweightinventorysorting/LightweightInventorySorting.java` | `` |  | onInitialize |
| top-level / `borknbeans/lightweightinventorysorting/LightweightInventorySortingClient.java` | `` |  | getCreativeIndex, reloadIndices, onInitializeClient, registerKeyBindings, loadResourcePacks |
| top-level / `borknbeans/lightweightinventorysorting/mixin/client/ContainerScreenMixin.java` | `value={ContainerScreen.class})` |  | init, keyPressed |
| top-level / `borknbeans/lightweightinventorysorting/mixin/client/CreativeModeInventoryScreenMixin.java` | `value={CreativeModeInventoryScreen.class})` | Inject:3 | addSortButton, onTabSelected, updateSortButton, onKeyPressed, isInventoryTab |
| top-level / `borknbeans/lightweightinventorysorting/mixin/client/HorseInventoryScreenMixin.java` | `value={HorseInventoryScreen.class})` |  | init, keyPressed |
| top-level / `borknbeans/lightweightinventorysorting/mixin/client/InventoryScreenMixin.java` | `value={InventoryScreen.class})` | Inject:2 | onInit, onRecipeBookToggle, keyPressed, setButtonCoordinates |
| top-level / `borknbeans/lightweightinventorysorting/mixin/client/ShulkerBoxScreenMixin.java` | `value={ShulkerBoxScreen.class})` |  | init, keyPressed |
| top-level / `borknbeans/lightweightinventorysorting/sorting/ClickOperation.java` | `` |  | execute, click, postClickVerification, getItemStackString, canSafelyClick |
| top-level / `borknbeans/lightweightinventorysorting/sorting/PotionComparator.java` | `` |  | isPotion, compare, primaryEffect, effectName |
| top-level / `borknbeans/lightweightinventorysorting/sorting/SortButton.java` | `` |  | getSortStartIndex, getSortEndIndex, extractWidgetRenderState, onClick, updateWidgetNarration |
| top-level / `borknbeans/lightweightinventorysorting/sorting/SortComparator.java` | `` |  | compare |
| top-level / `borknbeans/lightweightinventorysorting/sorting/Sorter.java` | `` |  | getSafeSlots, getSnapshotForSlots, getFirstEmptySafeSlotIndex, sortContainerClientside, clearMouseStack, combineLikeStacks, sort, getInventorySnapshot, getInventoryStack, getMouseStack |
| top-level / `borknbeans/lightweightinventorysorting/sorting/SortSnapshotClientside.java` | `` |  | encode, serialize |
| top-level / `borknbeans/lightweightinventorysorting/SortSnapshotServerside.java` | `` |  | decode, deserialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
