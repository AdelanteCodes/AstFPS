# Shulker & Bundle

Review status: **Evidence inventory; behavioral review pending**

Project: [Shulker & Bundle](https://modrinth.com/mod/shulker-bundle)
Selected artifact version: `1.7`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Shulkerbox shift click opening and picking up items when in offhand.
Bundles shift click opening and picking up items no matter the inventory location.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `273ce543b97eb73b7e4511a2fbadc75fdb17bc07`
- `sha512`: `fb54f38a264c011de7b72917096f165bd460fe79c41faf33c68aa44dfea4f8e6363ad61d7726269bdab48c748f24bbbf9d40198d70711012a32d838712ad299b`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 29
Reconstructed Java files: 25

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "be.andy.shulkerbundle.ShulkerPickup"
  ],
  "client": [
    "be.andy.shulkerbundle.client.ShulkerPickupClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": "*",
  "minecraft": ">=26.3 <=26.3.4",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `be/andy/shulkerbundle/BundleItemScreenHandler.java` | `` |  | getHandContext, getOriginalBundleItemType, getOriginalCustomName, getBundleSlotsInventory, getBundleGuiInventorySize, getOriginalSlot, getPlaceholderStack, getScreenHandlerTypeForRows, removed, open, quickMoveStack, stillValid, mayPlace |
| top-level / `be/andy/shulkerbundle/client/gui/ShulkerBundleConfigScreen.java` | `` |  | isSingleplayer, init, addPersonalToggle, addServerToggle, addBundleSlotsButton, toggleLabel, bundleSlotsLabel, extractRenderState, refreshServerSyncedButtons, setToggle, setBundleSlots, removed |
| top-level / `be/andy/shulkerbundle/client/ShulkerBundleKeybinds.java` | `` |  | register |
| top-level / `be/andy/shulkerbundle/client/ShulkerBundleServerSettingsCache.java` | `` |  | update, reset, isSynced, canEditServer, isGlobalPickupEnabledShulker, isGlobalPickupEnabledBundle, isGlobalGuiEnabledShulker, isGlobalGuiEnabledBundle, isGlobalNotifyEnabledShulker, isGlobalNotifyEnabledBundle, isNotifyPlayerEnabled, getBundleGuiMinSlots |
| top-level / `be/andy/shulkerbundle/client/ShulkerPickupClient.java` | `` |  | onInitializeClient, sendCurrentClientSettings |
| top-level / `be/andy/shulkerbundle/command/ShulkerBundleCommand.java` | `` |  | initializeHelp, init, register, buildCommandStructure, registerGlobalSubCommand, toggleGlobalSetting, executeSetBundleSlots, executeToggleNotifyPlayer, registerPersonalSubCommand, togglePersonalSetting, showHelp |
| top-level / `be/andy/shulkerbundle/config/ClientConfig.java` | `` |  | getInstance, isSpGuiShulkerEnabled, isSpGuiBundleEnabled, isSpPickupShulkerEnabled, isSpPickupBundleEnabled, isSpNotifyShulkerEnabled, isSpNotifyBundleEnabled, setSpGuiShulkerEnabled, setSpGuiBundleEnabled, setSpPickupShulkerEnabled, setSpPickupBundleEnabled, setSpNotifyShulkerEnabled, setSpNotifyBundleEnabled, isMpGuiShulkerEnabled, isMpGuiBundleEnabled, isMpPickupShulkerEnabled, isMpPickupBundleEnabled, isMpNotifyShulkerEnabled, isMpNotifyBundleEnabled, isMpDenyPermissionsEnabled, setMpGuiShulkerEnabled, setMpGuiBundleEnabled, setMpPickupShulkerEnabled, setMpPickupBundleEnabled, setMpNotifyShulkerEnabled, setMpNotifyBundleEnabled, setMpDenyPermissionsEnabled, loadConfig, saveConfig |
| top-level / `be/andy/shulkerbundle/config/ModConfig.java` | `` |  | getInstance, isGlobalNotifyEnabledShulker, isGlobalNotifyEnabledBundle, isGlobalPickupEnabledShulker, isGlobalPickupEnabledBundle, isGlobalGuiEnabledShulker, isGlobalGuiEnabledBundle, isNotifyPlayerEnabled, getBundleGuiMinSlots, setGlobalNotifyEnabledShulker, setGlobalNotifyEnabledBundle, setGlobalPickupEnabledShulker, setGlobalPickupEnabledBundle, setGlobalGuiEnabledShulker, setGlobalGuiEnabledBundle, setNotifyPlayerEnabled, setBundleGuiMinSlots, cycleBundleGuiMinSlots, loadConfig, saveConfig |
| top-level / `be/andy/shulkerbundle/config/PlayerConfig.java` | `` |  | isNotifyShulkerEnabled, isNotifyBundleEnabled, isPickupShulkerEnabled, isPickupBundleEnabled, isGuiShulkerEnabled, isGuiBundleEnabled, isDenyMultiplayerPermissions, getNotificationCount, setNotifyShulkerEnabled, setNotifyBundleEnabled, setPickupShulkerEnabled, setPickupBundleEnabled, setGuiShulkerEnabled, setGuiBundleEnabled, setDenyMultiplayerPermissions, setNotificationCount, toNbt, fromNbt |
| top-level / `be/andy/shulkerbundle/config/PlayerConfigManager.java` | `` |  | init, getOrCreatePlayerConfig, savePlayerConfig, loadPlayerConfig, removePlayerConfig |
| top-level / `be/andy/shulkerbundle/mixin/AbstractContainerMenuClickMixin.java` | `value={AbstractContainerMenu.class})` | Inject:1 | shulkerbundle_handlePlaceholderAndFastClick |
| top-level / `be/andy/shulkerbundle/mixin/BundleItemMixin.java` | `value={BundleItem.class})` | Inject:1 | inventoryControl_onUseBundle |
| top-level / `be/andy/shulkerbundle/mixin/BundleItemOperationsMixin.java` | `value={BundleItem.class})` | Inject:2 | inventoryControl_onClickedItemOntoBundle, inventoryControl_onBundleOnCursorClickedOnSlot, isInsertionDisallowed |
| top-level / `be/andy/shulkerbundle/mixin/InventoryAccess.java` | `value={Inventory.class})` | Accessor:1 |  |
| top-level / `be/andy/shulkerbundle/mixin/InventoryMixin.java` | `value={Inventory.class})` | Inject:1 | getDisplayName, processBundleInteraction, onInsertStack |
| top-level / `be/andy/shulkerbundle/mixin/PlayerDropItemMixin.java` | `value={LivingEntity.class})` | Inject:1 | shulkerbundle_interceptPlaceholderDrop |
| top-level / `be/andy/shulkerbundle/mixin/ShulkerBoxEntityAccess.java` | `value={ShulkerBoxBlockEntity.class})` | Accessor:1 |  |
| top-level / `be/andy/shulkerbundle/networking/ClientSettingsPayload.java` | `` |  | type |
| top-level / `be/andy/shulkerbundle/networking/ModMenuHandshakePayload.java` | `` |  | type |
| top-level / `be/andy/shulkerbundle/networking/ServerSettingsPayload.java` | `` |  | type |
| top-level / `be/andy/shulkerbundle/networking/UpdateServerSettingPayload.java` | `` |  | type |
| top-level / `be/andy/shulkerbundle/PermissionChecker.java` | `` |  | check, checkLeveledPermission |
| top-level / `be/andy/shulkerbundle/ShulkerInventory.java` | `` |  | addStack, addToExistingSlot, addToNewSlot, transfer, getInventory |
| top-level / `be/andy/shulkerbundle/ShulkerItemScreenHandler.java` | `` |  | isPlaceholderMode, getOriginalShulkerItemType, getOriginalCustomName, getStackUsedToOpenGui, getHandUsed, getInventory, getOriginalSlot, stillValid, quickMoveStack, removed, open, mayPlace |
| top-level / `be/andy/shulkerbundle/ShulkerPickup.java` | `` |  | setLastModifiedBundle, clearLastModifiedBundle, isAutoPickupBlacklisted, isGuiBlacklisted, hasMod, isPlaceholderBundle, isPlaceholderShulkerBox, createBundlePlaceholder, createShulkerPlaceholder, setPlaceholderFlag, stripPlaceholderFlag, isBundleEmpty, checkPermission, isFeatureEnabled, isReinforcedShulkerBox, getReinforcedShulkerBoxSize, rowsForSlotCount, getShulkerTypeInfo, findAndCreateInfo, findScreenHandler, onInitialize, sendServerSettingsToPlayer, sendServerSettingsToAllPlayers, isClickTooFast, getShulkerBoxColor, getBundleItemCount, getBundleDisplayColor, sendActionBarMessage, handleShulkerAndBundleNotifications, ShulkerTypeInfo |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
