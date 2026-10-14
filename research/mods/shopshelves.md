# ShopShelves

Review status: **Evidence inventory; behavioral review pending**

Project: [ShopShelves](https://modrinth.com/mod/shopshelves)
Selected artifact version: `1.0.14`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

New advanced way of admin shops and playershops. ShopShelves and PlayerShelves

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha512`: `09ceea20e54c31a46b7d38306322aa13effefb2c1aaeb29278de8517bb970323b065f5f06d0c2fcc3c3f5049a9b0e67b0ceb9d7509710d971ac002393ec3a1d7`
- `sha1`: `d4a4ca5c6d1c41770d4036e2e3faae1d378af71f`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 53
Reconstructed Java files: 36

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "fabric-datagen": [
    "me.andy.shopshelves.client.ShopshelvesDataGenerator"
  ],
  "client": [
    "me.andy.shopshelves.client.ShopshelvesClient"
  ],
  "main": [
    "me.andy.shopshelves.Shopshelves"
  ]
}
```

**depends**

```json
{
  "fabricloader": "*",
  "fabric-api": "*",
  "minecraft": ">=26.3 <=26.3.5"
}
```

**accessWidener**

```json
"shopshelves.accesswidener"
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/snakeyaml-2.2.jar` | 232 | `org_yaml_snakeyaml` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/andy/shopshelves/api/ShopshelvesApi.java` | `` |  | getInstance, isShopShelf, getShopMode, getShopOwner |
| top-level / `me/andy/shopshelves/client/ShopshelvesClient.java` | `` |  | onInitializeClient |
| top-level / `me/andy/shopshelves/client/ShopshelvesDataGenerator.java` | `` |  | onInitializeDataGenerator |
| top-level / `me/andy/shopshelves/command/ShopshelvesCommand.java` | `` |  | init, addCoreSubcommands, register, buildPriceStampCommand, executePriceStamp, showHelp, updateAllShopsCommand, reloadConfigsAndUpdate, buildItemPriceCommand, showItemPrice, executeItemPrice, showCurrentModes, setMode, suggestAllModes, toggleAdminMode, toggleOtherPlayerAdminMode, buildChopstickCommand, executeChopstick, isChopstick |
| top-level / `me/andy/shopshelves/config/MessageFormattingData.java` | `` |  | chat, actionbar |
| top-level / `me/andy/shopshelves/config/MessageFormattingManager.java` | `` |  | initialize, getMessages, load, migrateAddMissingKeys, countNewKeys, copyDefaultFromJar, loadFromJar, getJarResource, buildYaml |
| top-level / `me/andy/shopshelves/config/ShopPricing.java` | `` |  | load, parseRaw, toInt, toDouble, save, copyDefaultFromJar, buildYaml, createDefaultConfig, getPriceEntry, getPriceEntry, setPrice, calculatePrice, PriceEntry |
| top-level / `me/andy/shopshelves/config/ShopshelvesConfig.java` | `` |  | load, migrateAddMissingKeys, sanitise, copyDefaultFromJar, buildYaml, save, fetchLangAsync, formatItemName, toTitleCase, isWorldAllowedForPlayerShops, isWorldAllowedForPlayerShops, clampScale, get, getMessageDeliveryMode, setMessageDeliveryMode, getTextDisplayRenderDistanceBlocks, getPriceDisplayRenderDistanceBlocks, getPriceDisplayMode, setPriceDisplayMode, shouldRoundOffDisplayPrices, getMainDisplayScale, getAmountDisplayScale, getPriceDisplayScale, getDefaultPlayerShelfLimit, isLimitPlayerShelfToSingleType, getLabelMaxLength, getItemLanguage, getAllowedWorlds |
| top-level / `me/andy/shopshelves/logic/ShopHelper.java` | `` |  | formatPrice, formatAccuratePrice, getUnitPrice, handleAdminSetup, applyAndCleanPlayerShopPriceStamp, getPrice, getLinkedContainerInventory, isPlayerShelfOutOfOrder, handlePlayerShelfBuy, handlePlayerShelfSell, handleBuyInteraction, handleSellInteraction, countItems, removeItems, addItems, hasRoomForPurchase, deliverPurchase, countSellableItems, removeSellableItems, hasEnoughSpace, canStack, getVariationId, getPotionSuffix |
| top-level / `me/andy/shopshelves/mixin/AbstractBlockMixin.java` | `value={BlockBehaviour.class})` | Inject:1 | shopshelves$onExploded |
| top-level / `me/andy/shopshelves/mixin/BlockEntityMixin.java` | `value={BlockEntity.class})` | Inject:1 | onShopBlockReplaced |
| top-level / `me/andy/shopshelves/mixin/ChestBlockMixin.java` | `value={ChestBlock.class})` | Inject:1 | shopshelves$handleProtectionAndMerge |
| top-level / `me/andy/shopshelves/mixin/HopperBlockEntityMixin.java` | `value={HopperBlockEntity.class})` | Inject:1 | shopshelves$blockShopShelfTransfer, isActiveShopShelf |
| top-level / `me/andy/shopshelves/mixin/ScreenHandlerMixin.java` | `value={AbstractContainerMenu.class})` | Inject:1 | beforeSlotClick |
| top-level / `me/andy/shopshelves/mixin/ServerPlayerEntityMixin.java` | `value={ServerPlayer.class})` | Inject:1 | shopshelves$onDropItem |
| top-level / `me/andy/shopshelves/mixin/ShelfBlockEntityMixin.java` | `value={ShelfBlockEntity.class})` | Inject:2 | shopshelves$triggerDisplayUpdate, getShopMode, setShopMode, getOwner, setOwner, getCustomPrice, setCustomPrice, getLinkedContainerPos, setLinkedContainerPos, getCustomLabel, setCustomLabel, getShopProfit, addShopProfit, getShopLoss, addShopLoss, writeCustomData, readCustomData |
| top-level / `me/andy/shopshelves/mixin/ShelfBlockMixin.java` | `value={ShelfBlock.class})` | Inject:4 | isAuthorized, shopshelves$preBucketAndVanillaUse, shopshelves$preventFluidPropagationAndChaining, onShopBroken, shopshelves$postVanillaUseWithItem |
| top-level / `me/andy/shopshelves/mixin/ShopPriceGuiScreenHandlerMixin.java` | `value={AbstractContainerMenu.class})` | Inject:2 | shopshelves$onGuiSlotClick, shopshelves$onGuiClosed |
| top-level / `me/andy/shopshelves/mixin/TextDisplayUpdateIntervalMixin.java` | `value={ServerEntity.class})` | WrapOperation:1 | shopshelves$slowShopDisplayInterval |
| top-level / `me/andy/shopshelves/mixin/WitherEntityMixin.java` | `value={WitherBoss.class})` | Inject:1 | shopshelves$protectShelvesFromWither |
| top-level / `me/andy/shopshelves/Shopshelves.java` | `` |  | api, onInitialize, hasPriceStamp, removePriceStamp, updateAllShops, checkPermission |
| top-level / `me/andy/shopshelves/util/AdminModeManager.java` | `` |  | toggleAdminMode, isAdmin, clearAdmins |
| top-level / `me/andy/shopshelves/util/EconomyManager.java` | `` |  | isEconomyEnabled, hasEnough, hasEnough, deposit, deposit, withdraw, withdraw |
| top-level / `me/andy/shopshelves/util/MessageFormatter.java` | `` |  | ensureUrlScheme, formatLines, parseSingleLine, createClickEvent, applyMinecraftFormatting |
| top-level / `me/andy/shopshelves/util/MessageUtil.java` | `` |  | sendMessage, sendError, replacePlaceholders, sendPlayerMessage, sendMessage, sendError, getMessageObject |
| top-level / `me/andy/shopshelves/util/ShopDataManager.java` | `` |  | get, getAllShops, getConfigFile, load, save, setShopDisplayUuids, removeShopDisplayUuids, countPlayerShelves, isContainerLinked, getShelfForContainer, addLink, removeLink, clear |
| top-level / `me/andy/shopshelves/util/ShopLinkUtil.java` | `` |  | getContainerPositions, getOtherChestHalf |
| top-level / `me/andy/shopshelves/util/ShopPermissionUtil.java` | `` |  | checkPermissionsApiLoaded, checkPermission, getPlayerShelfLimit |
| top-level / `me/andy/shopshelves/util/ShopPriceGuiData.java` | `` |  | ShopPriceGuiData |
| top-level / `me/andy/shopshelves/util/ShopPriceGuiHandler.java` | `` |  | onGuiSlotClick, onGuiClose, onChatMessage, openPriceChatInput, handlePriceInput, openLabelChatInput, clearLabel, handleLabelInput, resolveEffectiveSlot, readDisplayTotal, adjustPrice, resetPrice, applyPrices, readCustomTotal, refreshGui, getBlockEntity, sendMsg, sendMsg, parse, orDefault, hasPendingChat, removePendingChat |
| top-level / `me/andy/shopshelves/util/ShopPriceGuiManager.java` | `` |  | idx, slotDecDec, slotDec, slotItem, slotInc, slotIncInc, slotReset, slotChat, orDefault, openPriceGui, stillValid, canPlaceItem, fillGui, buildPublicStatsBook, buildStatsBook, buildGlass, buildButton, noItalic, splitLore, prependLine |
| top-level / `me/andy/shopshelves/util/ShopShelf.java` | `` |  |  |
| top-level / `me/andy/shopshelves/util/ShopViewerGuiData.java` | `` |  | ShopViewerGuiData |
| top-level / `me/andy/shopshelves/util/ShopViewerGuiManager.java` | `` |  | openViewerGui, stillValid, canPlaceItem, fillViewerGui, buildStatsBook, orDefault |
| top-level / `me/andy/shopshelves/util/TextDisplayManager.java` | `` |  | cacheKey, clearCache, calculateScaleFactor, removeShopDisplays, updateShopDisplay, canHaveBuyPrice, canHaveSellPrice, computeContentFingerprint, createSinglePriceDisplay, createDisplay, resolveDualFormat, createBaseDisplay, buildShopText, getFormatStringFromFormats, getFormatStringFromFormats |
| top-level / `me/andy/shopshelves/util/TextUtil.java` | `` |  | format |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
