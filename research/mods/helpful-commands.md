# Helpful Commands

Review status: **Evidence inventory; behavioral review pending**

Project: [Helpful Commands](https://modrinth.com/mod/helpful-commands)
Selected artifact version: `4.2.3`
Published implementation source: https://github.com/expecticament/helpful-commands
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Feature-rich Minecraft mod that adds many useful commands. Interactive, supports permissions, easy to configure.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `46670070174ed28262653cb5248a64710822aa19`
- `sha512`: `e6d6d8386cbf69a8d609ffe12f05d1e39fc422ee04521e1da5a2f57c07533ce043f0adbe20c92c11612e9438b84fd132b52cf3eff35ce850680ea62c58887a93`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 109
Reconstructed Java files: 71

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.expecticament.helpfulcommands.HelpfulCommandsFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "fabric-api": "*",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/fabric-permissions-api-0.7.0.jar` | 7 | `fabric-permissions-api-v0` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/expecticament/helpfulcommands/command/abilities/FlyCommand.java` | `` |  | register, checkBaseCommandRequirements, executeSelf, executeSelf, executeOther, toggleFlying |
| top-level / `com/expecticament/helpfulcommands/command/abilities/GodCommand.java` | `` |  | register, checkBaseCommandRequirements, executeSelf, executeSelf, executeOther, toggleInvulnerability |
| top-level / `com/expecticament/helpfulcommands/command/HelpfulCommandsCommand.java` | `` |  | getModCommand, canExecute, validatePlayerOnly, validateAnySource |
| top-level / `com/expecticament/helpfulcommands/command/itemsAndInventory/DisenchantCommand.java` | `` |  | register, checkBaseCommandRequirements, executeSelf, executeOther, removeEnchantment, removeAllEnchantments, getEnchantmentLevelComponent, getEnchantmentNameAndLevelComponent, getEnchantmentNameAndLevelComponent, getRemovedEnchantmentsCountComponent, getRemovedEnchantmentsCountComponent, EnchantmentData |
| top-level / `com/expecticament/helpfulcommands/command/itemsAndInventory/EchestCommand.java` | `` |  | register, checkBaseCommandRequirements, execute, execute, openOnlineInventory, openOfflineInventory, saveOfflineInventory, removed, stillValid, stillValid |
| top-level / `com/expecticament/helpfulcommands/command/itemsAndInventory/InvseeCommand.java` | `` |  | register, checkBaseCommandRequirements, execute, openOnlineInventory, openOfflineInventory, saveOfflineInventory, readEquipmentSlot, writeEquipmentSlot, removed, stillValid, stillValid, mayPlace, mayPickup, mayPlace, mayPickup |
| top-level / `com/expecticament/helpfulcommands/command/itemsAndInventory/RenameCommand.java` | `` |  | register, checkBaseCommandRequirements, executeSelf, executeOther, rename |
| top-level / `com/expecticament/helpfulcommands/command/itemsAndInventory/RepairCommand.java` | `` |  | register, checkBaseCommandRequirements, executeSelf, executeOther, repair |
| top-level / `com/expecticament/helpfulcommands/command/itemsAndInventory/SmeltCommand.java` | `` |  | register, checkBaseCommandRequirements, executeSelf, executeOther, smelt |
| top-level / `com/expecticament/helpfulcommands/command/main/HcCommand.java` | `` |  | register, checkBaseCommandRequirements, singleplayerOwnerCheck, about, commandList, commandListAll, commandListAvailableOnly, getCommandHoverEvent, getCommandStateHoverEvent, config, configField, setCommandState, queryCommandState, setConfigField, queryConfigField, clearCooldown, clearCooldown, clearAllCooldowns |
| top-level / `com/expecticament/helpfulcommands/command/movementAndTeleportation/DeathposCommand.java` | `` |  | register, checkBaseCommandRequirements, query, query, teleport, teleport |
| top-level / `com/expecticament/helpfulcommands/command/movementAndTeleportation/DimensionCommand.java` | `` |  | register, checkBaseCommandRequirements, executeSelf, executeOther, switchDimension, getDimensionText |
| top-level / `com/expecticament/helpfulcommands/command/movementAndTeleportation/HomeCommand.java` | `` |  | register, checkBaseCommandRequirements, teleport, addHome, removeHome, editHomeName, editHomeLocation, homeInfo |
| top-level / `com/expecticament/helpfulcommands/command/movementAndTeleportation/JumpCommand.java` | `` |  | register, checkBaseCommandRequirements, execute |
| top-level / `com/expecticament/helpfulcommands/command/movementAndTeleportation/SpawnCommand.java` | `` |  | register, checkBaseCommandRequirements, executePlayerTp, executeWorldTp, executePlayerQuery, executeWorldQuery, buildInfoComponent, teleportToPlayerSpawn, teleportToWorldSpawn |
| top-level / `com/expecticament/helpfulcommands/command/movementAndTeleportation/TprCommand.java` | `` |  | register, checkBaseCommandRequirements, executeRequest, executeCancel, executeAccept, executeDeny, canAccept, canDeny |
| top-level / `com/expecticament/helpfulcommands/command/movementAndTeleportation/WarpCommand.java` | `` |  | register, checkBaseCommandRequirements, teleport, teleport, buildTeleportFeedbackMessage, addWarp, addWarp, addWarp, addWarp, removeWarp, editWarpName, editWarpDescription, editWarpLocation, editWarpLocation, editWarpLocation, warpInfo |
| top-level / `com/expecticament/helpfulcommands/command/playersAndEntities/CoordsCommand.java` | `` |  | register, checkBaseCommandRequirements, execute, broadcast, broadcast, share, query |
| top-level / `com/expecticament/helpfulcommands/command/playersAndEntities/DmgCommand.java` | `` |  | register, checkBaseCommandRequirements, execute |
| top-level / `com/expecticament/helpfulcommands/command/playersAndEntities/ExtinguishCommand.java` | `` |  | register, checkBaseCommandRequirements, executeSelf, executeOther, extinguish |
| top-level / `com/expecticament/helpfulcommands/command/playersAndEntities/FeedCommand.java` | `` |  | register, checkBaseCommandRequirements, executeSelf, executeOther, feed |
| top-level / `com/expecticament/helpfulcommands/command/playersAndEntities/GmCommand.java` | `` |  | register, checkBaseCommandRequirements, executeSelf, executeOther |
| top-level / `com/expecticament/helpfulcommands/command/playersAndEntities/HatCommand.java` | `` |  | register, checkBaseCommandRequirements, executeSelf, executeSelf, executeOther, getItemName, put |
| top-level / `com/expecticament/helpfulcommands/command/playersAndEntities/HealCommand.java` | `` |  | register, checkBaseCommandRequirements, executeSelf, executeSelf, executeOther, heal |
| top-level / `com/expecticament/helpfulcommands/command/playersAndEntities/IgniteCommand.java` | `` |  | register, checkBaseCommandRequirements, executeSelf, executeOther, ignite |
| top-level / `com/expecticament/helpfulcommands/command/social/CoinflipCommand.java` | `` |  | register, checkBaseCommandRequirements, execute, randomSide |
| top-level / `com/expecticament/helpfulcommands/command/world/ExplosionCommand.java` | `` |  | register, checkBaseCommandRequirements, executePosition, executeTarget, validatePowerArgument |
| top-level / `com/expecticament/helpfulcommands/command/world/FireballCommand.java` | `` |  | register, checkBaseCommandRequirements, execute, execute |
| top-level / `com/expecticament/helpfulcommands/command/world/KillitemsCommand.java` | `` |  | register, checkBaseCommandRequirements, execute, execute, execute |
| top-level / `com/expecticament/helpfulcommands/command/world/LightningCommand.java` | `` |  | register, checkBaseCommandRequirements, executePosition, executeTarget |
| top-level / `com/expecticament/helpfulcommands/command/world/TimeCommand.java` | `` |  | register, checkBaseCommandRequirements, execute, getDefaultClock |
| top-level / `com/expecticament/helpfulcommands/Constants.java` | `` |  |  |
| top-level / `com/expecticament/helpfulcommands/HelpfulCommands.java` | `` |  | init, onServerStarting, save, isDedicatedServer |
| top-level / `com/expecticament/helpfulcommands/HelpfulCommandsFabric.java` | `` |  | onInitialize |
| top-level / `com/expecticament/helpfulcommands/manager/ConfigManager.java` | `` |  | initialize, readConfig, writeToDisk, writeField, writeField, readField, readField, validateFieldValue, setCommandState, getCommandState, properties, lpMetaSupport, dbl, dbl, dbl, integer, integer, integer, bool, getValueType, getDefaultValue, getMin, getMax |
| top-level / `com/expecticament/helpfulcommands/manager/CooldownManager.java` | `` |  | applyCooldown, applyCooldown, getRemainingCooldown, getRemainingCooldown, removeCooldown, removeCooldown, removeAllCooldowns, removeAllCooldowns, removeAllCooldowns, removeExpired, initialize, writeToDisk, isExpired, expiresIn |
| top-level / `com/expecticament/helpfulcommands/manager/CustomConfigDeserializer.java` | `` |  | deserialize |
| top-level / `com/expecticament/helpfulcommands/manager/home/Home.java` | `` |  |  |
| top-level / `com/expecticament/helpfulcommands/manager/home/HomeException.java` | `` |  |  |
| top-level / `com/expecticament/helpfulcommands/manager/home/HomeManager.java` | `` |  | initialize, flush, hasHome, getHome, getHomes, createHome, removeHome, setHomeName, setHomeLocation, getData, playerHomes, playerHomes |
| top-level / `com/expecticament/helpfulcommands/manager/ModCommandManager.java` | `` |  | registerCommands, getCommandList, getCommandListByCategory, sendCommandsToEveryone, getName, getCategory, isEnabledByDefault |
| top-level / `com/expecticament/helpfulcommands/manager/StylingManager.java` | `` |  | initialize, getStyle, getCurrentStyle, getStyleByName, getAllStyles, setCurrentStyle |
| top-level / `com/expecticament/helpfulcommands/manager/TpRequestsManager.java` | `` |  | newRequest, removeRequest, removeExpired, getSentRequest, getSentRequest, getSentRequest, getSentRequest, hasSentRequest, hasSentRequest, getReceivedRequests, getReceivedRequests, hasReceivedRequests, hasReceivedRequests, isExpired, expiresIn, getFrom, getTo |
| top-level / `com/expecticament/helpfulcommands/manager/translation/ComponentBuilder.java` | `` |  | resolveLang, appendLiteral, appendTranslatable, appendComponent, appendWhitespace, appendNewline, setStyle, build |
| top-level / `com/expecticament/helpfulcommands/manager/translation/TranslationManager.java` | `` |  | translate, translate, translate, getFallbackLang, initialize, loadLanguage |
| top-level / `com/expecticament/helpfulcommands/manager/warp/Warp.java` | `` |  |  |
| top-level / `com/expecticament/helpfulcommands/manager/warp/WarpException.java` | `` |  |  |
| top-level / `com/expecticament/helpfulcommands/manager/warp/WarpManager.java` | `` |  | initialize, flush, exists, getWarp, getWarps, createWarp, removeWarp, setWarpName, setWarpDescription, setWarpLocation, getData |
| top-level / `com/expecticament/helpfulcommands/permission/ModPermissions.java` | `` |  | getId, getDefaultRequiredPermission |
| top-level / `com/expecticament/helpfulcommands/permission/PermissionHandler.java` | `` |  |  |
| top-level / `com/expecticament/helpfulcommands/permission/PermissionHandlerFabricImpl.java` | `` |  | hasPermission |
| top-level / `com/expecticament/helpfulcommands/permission/PermissionHandlerProvider.java` | `` |  | get |
| top-level / `com/expecticament/helpfulcommands/platform/FabricPlatformHelper.java` | `` |  | getPlatform, getModVersion, isModLoaded, isDevelopmentEnvironment, getEnvironmentName |
| top-level / `com/expecticament/helpfulcommands/platform/Platform.java` | `` |  | toString |
| top-level / `com/expecticament/helpfulcommands/platform/services/IPlatformHelper.java` | `` |  |  |
| top-level / `com/expecticament/helpfulcommands/platform/Services.java` | `` |  | load |
| top-level / `com/expecticament/helpfulcommands/style/DefaultStyle.java` | `` |  | getDisplayName, getTextStyles, getTextDecorators |
| top-level / `com/expecticament/helpfulcommands/style/HelpfulCommandsStyle.java` | `` |  | getTitlePrefix, getTitleSeparator, getTitleSuffix, getBulletPoint, getSeparator, getButtonPrefix, getButtonSuffix, getButtonSeparator, getCross, getCheckmark, getRemove, getEdit, getReset, getTeleport, getCategoryStartingChar, getCategoryTrailingChar, getCategoryEndingChar, getPrimary, getSecondary, getTertiary, getSuccess, getWarning, getAffectedNeutral, getAffectedPositive, getAffectedNegative, getAvailable, getUnavailable, getEnabled, getDisabled, getSubtle, getTitlePrimary, getTitleSecondary, getButton, getDangerousAction, getAxisX, getAxisY, getAxisZ |
| top-level / `com/expecticament/helpfulcommands/suggestionProvider/HelpfulCommandsCommandSuggestionProvider.java` | `` |  | getSuggestions |
| top-level / `com/expecticament/helpfulcommands/suggestionProvider/HomeNameSuggestionProvider.java` | `` |  | getSuggestions |
| top-level / `com/expecticament/helpfulcommands/suggestionProvider/TprReceivedRequestsPlayerNameSuggestionProvider.java` | `` |  | getSuggestions |
| top-level / `com/expecticament/helpfulcommands/suggestionProvider/WarpDescriptionSuggestionProvider.java` | `` |  | getSuggestions |
| top-level / `com/expecticament/helpfulcommands/suggestionProvider/WarpNameSuggestionProvider.java` | `` |  | getSuggestions |
| top-level / `com/expecticament/helpfulcommands/util/GameRulesUtil.java` | `` |  | getRuleValue, isCommandFeedbackEnabled |
| top-level / `com/expecticament/helpfulcommands/util/io/GenericIO.java` | `` |  | updateBuffer, getData, flush, flush, getPath |
| top-level / `com/expecticament/helpfulcommands/util/io/JsonIO.java` | `` |  | updateBuffer, flush, flush, getData |
| top-level / `com/expecticament/helpfulcommands/util/PermissionsUtil.java` | `` |  | hasPermission, hasPermissionLuckPerms, getMetaOrElseConfigValue, getMetaOrElseConfigValue, isLuckPermsAvailable |
| top-level / `com/expecticament/helpfulcommands/util/PlayerDataUtil.java` | `` |  | loadOfflinePlayerData, saveOfflinePlayerData |
| top-level / `com/expecticament/helpfulcommands/util/ServerLevelUtil.java` | `` |  | initialize, getLevel, getLevelLocation |
| top-level / `com/expecticament/helpfulcommands/util/SoundUtil.java` | `` |  | playSound |
| top-level / `com/expecticament/helpfulcommands/util/StylingUtil.java` | `` |  | getAffectedEntityNameText, getAffectedEntitiesNumberText, getAffectedEntitiesNumberText, getTitle, getTitle, getButton, getButton, getButton, getButton, getPositionText, getPositionText, getLocationText, getLocationText, getLocationText, getItemStackName, formatDuration, formatDuration |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
