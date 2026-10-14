# Item Blocker

Review status: **Evidence inventory; behavioral review pending**

Project: [Item Blocker](https://modrinth.com/mod/item-blocker)
Selected artifact version: `1.6+26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A client side mod that allows you to stop picking up items you don't want.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha512`: `6c25de0f1ff47b9860f398f0c7c3ae7297f1e337448a8c49bf492815e42cee877964953435f00084fe096a81da1d3c993cd9a3b8c131cb34c0baf235e0d5f597`
- `sha1`: `eb1a28a35350ac20ba3698b6cd0baf686ca6f995`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 68
Reconstructed Java files: 57

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "com.itemblocker.client.ItemBlockerClient",
    "com.itemblocker.init.ConfigInit"
  ],
  "modmenu": [
    "com.itemblocker.init.ModMenuInit"
  ],
  "main": [
    "com.itemblocker.init.ServerSideInit"
  ],
  "server": [
    "com.itemblocker.init.ServerSideInit"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "minecraft": ">=26.2 ",
  "java": ">=25"
}
```

**accessWidener**

```json
"itemblocker.classtweaker"
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/commons-text-1.9.jar` | 135 | `org_apache_commons_commons-text` | No |
| `META-INF/jars/jankson-1.2.3.jar` | 42 | `blue_endless_jankson` | No |
| `META-INF/jars/mixinsquared-fabric-0.3.7-beta.1.jar` | 75 | `mixinsquared` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/itemblocker/api/dropping/DroppingUtils.java` | `` |  | iterateInventory, getAmountToChange |
| top-level / `com/itemblocker/api/enums/AlignmentMode.java` | `` |  | getDisplayText |
| top-level / `com/itemblocker/api/enums/ItemIDMode.java` | `` |  | getDisplayText |
| top-level / `com/itemblocker/api/enums/MouseClick.java` | `` |  | value |
| top-level / `com/itemblocker/api/enums/PickupMode.java` | `` |  | getDisplayText |
| top-level / `com/itemblocker/api/item/ItemUtil.java` | `` |  | getItemNameFromID, getItemNameFromID, getItemName, getItemId, getItemDetails, getHeldItem, setItemXPos, setItemYPos, setItemZPos, setBobOffset, setAge, setVisualRotation, setYRot, setHealth, itemXPos, itemYPos, itemZPos, bobOffset, age, visualRotation, yRot, health, getCurrentItemInMemory, setCurrentItemInMemory, setPos |
| top-level / `com/itemblocker/api/keymapping/KeyHandler.java` | `` |  | getOptions, handleKeyMappings |
| top-level / `com/itemblocker/api/keymapping/KeyOptions.java` | `` |  | process, registerKeyMappings, isTemporaryAllowPressed, isToggled, setToggled, setIsTemporaryAllowPressed |
| top-level / `com/itemblocker/api/logging/InvalidPresetCodeException.java` | `` |  |  |
| top-level / `com/itemblocker/api/logging/Loggers.java` | `` |  |  |
| top-level / `com/itemblocker/api/PresetSharing.java` | `` |  | exportPreset, importPreset, ExportedPreset, ImportedPreset |
| top-level / `com/itemblocker/api/raycasting/RaycastUtils.java` | `` |  | raycast, sendOverlay, specialBlockCheck, addSpecialBlocksToList |
| top-level / `com/itemblocker/api/records/ItemEntry.java` | `` |  | ItemEntry, getItemStack |
| top-level / `com/itemblocker/api/RegistryUtils.java` | `` |  | createDefaultLoadConfig, loadRegistry |
| top-level / `com/itemblocker/api/screen/AbstractItemWidget.java` | `` |  | init, extractRenderState, renderWidget, renderSearchButton, renderScrollBar, renderScrollArrow, scrollbarX0, scrollbarX1, scrollbarTrackY0, scrollbarTrackHeight, computeScrollThumb, handleScrollbarClick, updateScrollFromThumbY, updateDragTilt, approach, stepSpring, renderItemIcon, renderItemRow, mouseClicked, getActiveList, mouseScrolled, keyPressed, onClose, mouseDragged, mouseReleased, startShake, shakeAllItems, clearScreenEffects, getScrollOffset, resetScrollOffset, incrementScrollOffset, decrementScrollOffset, decreaseScrollOffset, increaseScrollOffset, tick, sortList, refreshResults, collectItemsInMatchingTags, matchesQuery, isMusicDisc, getMusicDiscName, line, arrow, animatedButton, ScrollThumbGeometry |
| top-level / `com/itemblocker/api/screen/GlobalScreen.java` | `` |  | extractRenderState, isPauseScreen, isAllowedInPortal, onClose, getFadeManager, getTextSupplier, playClickSound, registerCustomCursors, createCursor, readResourceToByteBuffer |
| top-level / `com/itemblocker/api/screen/LeftAlignedItemWidget.java` | `` |  | init, extractRenderState, renderWidget, renderScrollBar, renderScrollArrow, scrollbarX0, scrollbarX1, scrollbarTrackY0, scrollbarTrackHeight, computeScrollThumb, handleScrollbarClick, updateScrollFromThumbY, updateDragTilt, approach, stepSpring, renderItemIcon, renderItemRow, mouseClicked, mouseScrolled, keyPressed, mouseDragged, mouseReleased, startShake, shakeAllItems, clearScreenEffects, getScrollOffset, resetScrollOffset, incrementScrollOffset, decrementScrollOffset, decreaseScrollOffset, increaseScrollOffset, tick, ScrollThumbGeometry |
| top-level / `com/itemblocker/api/screen/misc/AbstractFadeManager.java` | `` |  | fadeOut, fadeIn, fadeOut, fadeIn, fadeInOut, fadeInOut |
| top-level / `com/itemblocker/api/screen/misc/Colors.java` | `` |  | color |
| top-level / `com/itemblocker/api/screen/misc/Fade.java` | `` |  | getColor, getStartTime, getFadeInDuration, getFadeOutDuration, getTotalTime |
| top-level / `com/itemblocker/api/screen/misc/TextCoordinate.java` | `` |  | TextCoordinate |
| top-level / `com/itemblocker/api/screen/misc/TextSupplier.java` | `` |  | addText, addText, addText, addText, removeText, removeText, removeText, removeText, removeText, addTextToList, textList, getInstance |
| top-level / `com/itemblocker/client/config/BlockedItemsConfig.java` | `` |  | load, loadJson5, migrateFromJson, save, isBlocked, isBlocked, shouldLoadRegistryOnLaunch, devFlagsEnabled, getAlignmentMode, setAlignmentMode, getItemIdMode, setUseItemIds, hasDoneTutorial, finishTutorial, addBlockedItem, addBlockedItem, removeBlockedItem, getPickupMode, setPickupMode, listItemsAlphabetically, sortItems |
| top-level / `com/itemblocker/client/config/PresetsConfig.java` | `` |  | load, loadJson5, migrateFromJson, save, createPreset, deletePreset, renamePreset, addItemToPreset, removeItemFromPreset, getPreset, getPresetNames, applyPreset |
| top-level / `com/itemblocker/client/ItemBlockerClient.java` | `` |  | onInitializeClient, tick, isUsingClientMode, getOptions, isUsingIDMode, isCenterAligned, isAddMod |
| top-level / `com/itemblocker/client/screen/BlockedItemsScreen.java` | `` |  | getHeaderText, getListY, getListX, getListWidth, getListHeight, getEditBox, getItemList, getEmptyListText, isItemSelected, init, refreshList, extractRenderState, renderButtons, approach, mouseClicked, keyPressed, checkItemId, tick, startTutorial, finishTutorial |
| top-level / `com/itemblocker/client/screen/LeftAlignedScreen.java` | `` |  | getHeaderText, getListY, getListX, getListWidth, getListHeight, getEditBox, getItemList, getEmptyListText, init, refreshList, extractRenderState, mouseClicked, checkItemId |
| top-level / `com/itemblocker/client/screen/presets/CreatePresetScreen.java` | `` |  | init, extractRenderState, keyPressed |
| top-level / `com/itemblocker/client/screen/presets/edit/EditPresetNameScreen.java` | `` |  | init, extractRenderState, keyPressed, rename |
| top-level / `com/itemblocker/client/screen/presets/edit/EditPresetScreen.java` | `` |  | getHeaderText, getListY, getListX, getListWidth, getEditBox, getListHeight, getItemList, getEmptyListText, isItemSelected, init, refreshList, extractRenderState, mouseClicked, checkItemId |
| top-level / `com/itemblocker/client/screen/presets/ImportPresetScreen.java` | `` |  | init, tryImport, extractRenderState, keyPressed |
| top-level / `com/itemblocker/client/screen/presets/PresetsScreen.java` | `` |  | init, refreshList, extractRenderState, renderButtons, renderExportPopup, renderDeletePopup, mouseClicked, mouseScrolled, keyPressed, PresetEntry |
| top-level / `com/itemblocker/client/screen/SettingsScreen.java` | `` |  | init, extractRenderState, onClose |
| top-level / `com/itemblocker/init/ConfigInit.java` | `` |  | onInitializeClient |
| top-level / `com/itemblocker/init/ModMenuInit.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/itemblocker/init/ServerSideInit.java` | `` |  | onInitializeServer, onInitialize |
| top-level / `com/itemblocker/mixin/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | Inject:1, ModifyArg:1, WrapOperation:1 | isFromGround, setParticle, stopSound |
| top-level / `com/itemblocker/mixin/compat/pickupnotifications/ItemPickupMixin.java` | `value={ItemPickup.class})` | Inject:1 | cancelEmit |
| top-level / `com/itemblocker/mixin/compat/pickupnotifier/AddEntriesHandlerMixin.java` | `value={AddEntriesHandler.class})` | Inject:1 | cancelNotification |
| top-level / `com/itemblocker/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:2 | loadRegistry, isRemoveMod, runTick |
| top-level / `com/itemblocker/mixin/MultiPlayerGameModeMixin.java` | `value={MultiPlayerGameMode.class})` | Inject:2 | pickBlockCheck, pickEntityCheck |
| top-level / `com/itemblocker/mixin/OptionsMixin.java` | `value={Options.class})` | Inject:1 | registerKeyMappings |
| top-level / `com/itemblocker/mixin/renderer/ArmedEntityRenderStateMixin.java` | `value={ArmedEntityRenderState.class})` | Inject:2, ModifyArg:2 | setStateItem, setRightItem, setLeftItem, getEntity |
| top-level / `com/itemblocker/mixin/renderer/ArrowRendererMixin.java` | `value={ArrowRenderer.class})` | Inject:1 | renderGizmos |
| top-level / `com/itemblocker/mixin/renderer/AvatarRendererMixin.java` | `value={AvatarRenderer.class})` | ModifyArgs:1, Inject:1 | setItem, getItem |
| top-level / `com/itemblocker/mixin/renderer/ItemEntityRendererMixin.java` | `value={ItemEntityRenderer.class})` | Inject:1 | renderGizmos |
| top-level / `com/itemblocker/mixin/renderer/ItemInHandLayerMixin.java` | `value={ItemInHandLayer.class})` | WrapOperation:2, ModifyVariable:1 | cancelRender, cancelRender2, renderEmpty |
| top-level / `com/itemblocker/mixin/screen/AbstractContainerMenuMixin.java` | `value={AbstractContainerMenu.class})` | Inject:1 | getIndex |
| top-level / `com/itemblocker/mixin/screen/AbstractContainerScreenMixin.java` | `value={AbstractContainerScreen.class})` | Inject:4, ModifyArgs:1 | getItem, setItemSlot, cancelItemText, cancelTooltip, setVariables, setPos |
| top-level / `com/itemblocker/mixin/screen/CreativeModeInventoryScreenMixin.java` | `value={CreativeModeInventoryScreen.class})` | Inject:2 | getTab, setTab |
| top-level / `com/itemblocker/mixin/screen/CursorTypeInvoker.java` | `value={CursorType.class})` | Invoker:1 | create |
| top-level / `com/itemblocker/mixin/screen/GuiMixin.java` | `value={Gui.class})` | Inject:1 | getScreen |
| top-level / `com/itemblocker/mixin/screen/HudMixin.java` | `value={Hud.class})` | WrapOperation:2 | cancelItem, cancelItemText |
| top-level / `com/itemblocker/mixin/server/AbstractArrowMixin.java` | `value={AbstractArrow.class})` | Inject:1 | setPositions |
| top-level / `com/itemblocker/mixin/server/ItemEntityMixin.java` | `value={ItemEntity.class})` | Inject:2, ModifyArg:2, ModifyReturnValue:1, WrapOperation:1 | setValues, setYRot, setCount, setVisualRotation, onCollideWithEntity, cancelStatAward |
| top-level / `com/itemblocker/mixin/server/LivingEntityMixin.java` | `value={LivingEntity.class})` | ModifyArgs:3, Inject:3 | cancelVelocity, cancelVelocityTwo, setItemPos, setStack, getItem, cancelSwing |
| top-level / `com/itemblocker/mixin/server/ServerPlayerMixin.java` | `value={ServerPlayer.class})` | Inject:1, WrapOperation:2 | cancelStat, cancelStat, cancelStat |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
