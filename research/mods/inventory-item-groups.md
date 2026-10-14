# Inventory Item Groups

Review status: **Evidence inventory; behavioral review pending**

Project: [Inventory Item Groups](https://modrinth.com/mod/inventory-item-groups)
Selected artifact version: `1.5.3-fabric+26.3`
Published implementation source: https://github.com/BizCub/inventory-item-groups
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Adds groups of items to the inventory in the creative game mode

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `4d4eb140c5eacc30ab87846520f20c78923915ca`
- `sha512`: `46ace0f7759695ef0d44f1e12171db50af9d9eaca1a361188637fead90e386fdce9a32048d4d3775149a8818d03b994d23165bb00eadc9beecdaed3bb20e3a30`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 18
Reconstructed Java files: 15

**entrypoints**

```json
{
  "modmenu": [
    "io.github.bizcub.inventoryItemGroups.platform.Fabric$ModMenu"
  ],
  "client": [
    "io.github.bizcub.inventoryItemGroups.platform.Fabric"
  ]
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/github/bizcub/inventoryItemGroups/config/ClothConfig.java` | `` |  | getConfigScreen, getConfig, load, save, getTranslate, sort, showItemsInGroup, groups |
| top-level / `io/github/bizcub/inventoryItemGroups/config/Config.java` | `` |  | get, set |
| top-level / `io/github/bizcub/inventoryItemGroups/config/ConfigHelper.java` | `` |  | isModLoaded, isClothConfigLoaded, isSimpleConfigLoaded, isConfigLoaded, getScreen |
| top-level / `io/github/bizcub/inventoryItemGroups/config/ItemGroup.java` | `` |  |  |
| top-level / `io/github/bizcub/inventoryItemGroups/config/SimpleConfig.java` | `` |  | getInstance, sort, showItemsInGroup, groups |
| top-level / `io/github/bizcub/inventoryItemGroups/config/Sort.java` | `` |  | getKey |
| top-level / `io/github/bizcub/inventoryItemGroups/Group.java` | `` |  | sort, removeDuplicates, getName, getTab, getItems, getItemsWithIndexes, setItemWithIndex, isVisibility, setVisibility, getIcon, getIconIndex, setIconIndex |
| top-level / `io/github/bizcub/inventoryItemGroups/IndexedItemStack.java` | `` |  | getItemStack, getIndex, setIndex |
| top-level / `io/github/bizcub/inventoryItemGroups/Main.java` | `` |  | init, getTabId, getTabIds, calculateIndex, groupsOnSelectedTab, findGroupByIndex, setIndexes, addItems, createGroups, getDefaultGroups, addGroup, addGroup, getGroupTranslate, getHoverEvent, getClickEvent |
| top-level / `io/github/bizcub/inventoryItemGroups/mixin/AbstractContainerScreenMixin.java` | `value={AbstractContainerScreen.class})` | WrapOperation:2, Inject:2 | iig$onScreen, iig$getSprite, iig$renderSprite, iig$renderItems, iig$renderSlotSprites, iig$renderVisibilitySprites, iig$renderGroupName |
| top-level / `io/github/bizcub/inventoryItemGroups/mixin/CreativeModeInventoryScreenMixin.java` | `value={CreativeModeInventoryScreen.class})` | WrapOperation:1, WrapWithCondition:1, Inject:1 | iig$groupsImplementation, iig$toggleInsteadOfCarry, iig$updateSelectedTab |
| top-level / `io/github/bizcub/inventoryItemGroups/mixin/ItemPickerMenuMixin.java` | `value={CreativeModeInventoryScreen.ItemPickerMenu.class})` | Inject:1 | iig$toggleGroupVisibility, iig$currentTopRow |
| top-level / `io/github/bizcub/inventoryItemGroups/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | iig$clearGroups |
| top-level / `io/github/bizcub/inventoryItemGroups/platform/Fabric.java` | `` |  | onInitializeClient, getModConfigScreenFactory |
| top-level / `io/github/bizcub/inventoryItemGroups/RawGroup.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
