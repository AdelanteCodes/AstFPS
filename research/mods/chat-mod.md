# Chat Mod

Review status: **Evidence inventory; behavioral review pending**

Project: [Chat Mod](https://modrinth.com/mod/chat-mod)
Selected artifact version: `2.1.5`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

MOTD Ingame, Full custom info command setup, Timed Broadcasts, Broadcasts for events with the world clock for events and countdowns :)

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha512`: `74d5750140de13c960a344880a6e1f942f58c3e5688aae6fb5c87b464b13e7fc785220f153e4d1eff8d352c70335a2a9c12410d83f8b32dbaac757bd3fc5e869`
- `sha1`: `80515e171cf29d1d90686e91fe82b829f039dd97`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 47
Reconstructed Java files: 34

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "me.andy.chatmod.Broadcaster"
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

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/placeholder-api-3.2.0+26.3.jar` | 122 | `placeholder-api` | No |
| `META-INF/jars/snakeyaml-2.2.jar` | 232 | `org_yaml_snakeyaml` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/andy/broadcaster/client/BroadcasterDataGenerator.java` | `` |  | onInitializeDataGenerator |
| top-level / `me/andy/chatmod/Broadcaster.java` | `` |  | registerChatRelayListener, registerBroadcastRelayListener, fireChatRelay, fireBroadcastRelay, onInitialize, getConfigManager, getPlayerDataManager, getPlayerChatColorManager, getLegacyBroadcastManager, getInfoManager, getMessagesManager, getPredefinedBroadcastManager, getScheduledBroadcastManager, getPredefinedItemManager, getPlaceholdersManager, getSpritesManager, getServerInstance, isShopshelvesWaitingForChat, dispatchShopshelvesChat, selectHoverProfile, buildPlayerNameHoverEvent, buildHoverFromLines, resolveHoverLine, resolveCfmProfilePlaceholders, resolveEcobalPlaceholders, parseCommandToClickEvent, buildPlayerNameClickEvt, applyToLeaf |
| top-level / `me/andy/chatmod/command/BroadcasterCommand.java` | `` |  | checkOpLevelPermission, checkPermission, register, registerChatModCommands, buildChatColorNode, resolveColorInput, hasColorPermission, executeChatColorSet, executeChatColorClear, executeBcNowToPlayer, openPredefinedItemsGui, listPredefinedItems, showHelpPage, reloadAllConfigs, listInfoFiles, createInfoFile, testMotd, testLegacyBroadcast, listPredefinedBroadcasts, executePredefinedBroadcast, buildTimedBcnowNode, executeAdHocBroadcast, showPredefinedBroadcastToSender, tagPlayerCommand |
| top-level / `me/andy/chatmod/config/BroadcasterConfig.java` | `` |  | getServerTimezone, isMotdEnabled, getMotdMessages, isBroadcastEnabled, isBroadcastRandomize, isLogChatToConsole, getBroadcastIntervalSeconds, getBroadcastMessages, getPlayerCountIntervals |
| top-level / `me/andy/chatmod/config/ConfigManager.java` | `` |  | loadConfig, saveConfig, getConfig, setConfig, parseConfig, buildMap, toStringList |
| top-level / `me/andy/chatmod/config/InfoFileConfig.java` | `` |  | createDefaultHelpConfig, createExample, isWorking, setWorking, getAliases, setAliases, getPages, isPermissionRequired, setPermissionRequired, getPermissionNode, setPermissionNode |
| top-level / `me/andy/chatmod/config/MessagesConfig.java` | `` |  |  |
| top-level / `me/andy/chatmod/config/MessagesManager.java` | `` |  | loadMessages, saveMessages, getMessagesConfig, parseMessages, buildMap, mergeDefaults, camelToSnake |
| top-level / `me/andy/chatmod/config/PlaceholdersConfig.java` | `` |  |  |
| top-level / `me/andy/chatmod/config/PredefinedBroadcast.java` | `` |  | getLines, getType, isPermissionRequired, getPermissionNode, getDurationSeconds, getBossBarColor, getBossBarOverlay |
| top-level / `me/andy/chatmod/config/PredefinedBroadcastsConfig.java` | `` |  | getBroadcasts |
| top-level / `me/andy/chatmod/config/PredefinedItemData.java` | `` |  | fromItemStack, toItemStack, getNbtString, setNbtString |
| top-level / `me/andy/chatmod/config/PredefinedItemsConfig.java` | `` |  | getItems, setItems |
| top-level / `me/andy/chatmod/config/YamlConfigHelper.java` | `` |  | buildYaml, load, save, ensureExists, migrateJsonToYaml, copyDefault, getString, getBoolean, getInt, getList, getMap |
| top-level / `me/andy/chatmod/data/PlayerChatColorManager.java` | `` |  | loadData, saveData, getColor, setColor, clearColor, namedColorToCode, permissionForNamedColor, permissionForLegacyCode, permissionForHexColor |
| top-level / `me/andy/chatmod/data/PlayerData.java` | `` |  | getTotalPlaytimeMillis, setTotalPlaytimeMillis, getFirstLoginTimeMillis, setFirstLoginTimeMillis, getLastLoginTimeMillis, setLastLoginTimeMillis, getCurrentSessionStartTimeMillis, setCurrentSessionStartTimeMillis, onLogin, onLogout |
| top-level / `me/andy/chatmod/data/PlayerDataManager.java` | `` |  | loadPlayerData, savePlayerData, getPlayerData, getPlayerData, onPlayerJoin, onPlayerLeave, flagPlayerForChatHandling, unflagPlayerForChatHandling, isPlayerFlaggedForChatHandling |
| top-level / `me/andy/chatmod/event/PlayerJoinHandler.java` | `` |  | onPlayReady |
| top-level / `me/andy/chatmod/event/PlayerLeaveHandler.java` | `` |  | onPlayDisconnect |
| top-level / `me/andy/chatmod/gui/PredefinedItemsInventory.java` | `` |  | configSlot, loadItemsFromManager, saveItemsToManager, getContainerSize, isEmpty, getItem, removeItem, removeItemNoUpdate, setItem, setChanged, stillValid, clearContent |
| top-level / `me/andy/chatmod/info/InfoManager.java` | `` |  | setLastDispatcherForRefresh, getInfoFileConfiguration, ensureExampleInfoFileExists, ensureInfoFile, loadInfoFiles, saveInfoFileConfig, createInfoFile, registerInfoCommands, registerInfoFileCommandNode, executeInfoCommandInternal, displayInfoFileSection, toggleInfoFileExecute, togglePermissionRequired, setPermissionNode, addInfoAlias, removeInfoAlias, suggestAliasesForFile, suggestLoadedInfoFiles, getPermittedInfoCommandNames, getLoadedInfoFileNames, refreshCommands, parseInfoFileConfig, buildInfoFileMap, sendLines |
| top-level / `me/andy/chatmod/manager/PlaceholdersManager.java` | `` |  | loadConfig, saveConfig, getConfig, parseConfig, buildMap, toStringList |
| top-level / `me/andy/chatmod/manager/PredefinedBroadcastManager.java` | `` |  | loadConfig, saveConfig, getBroadcast, getAllBroadcastNames, getPermittedBroadcastNames, hasPermissionForBroadcast, parseConfig, buildMap |
| top-level / `me/andy/chatmod/manager/PredefinedItemManager.java` | `` |  | loadConfig, parseConfig, buildMap, saveConfig, getItemStack, setItemStack, removeItemStack, getConfig, getAllItems, setAllItems |
| top-level / `me/andy/chatmod/manager/ScheduledBroadcastManager.java` | `` |  | setServer, parseDurationToMillis, scheduleBroadcast, sendError, buildMessageLines, addAndScheduleTask, executeScheduledTaskRunnable, executeGlobalBroadcast, executeGlobalBroadcast, loadScheduledTasks, parseConfig, parseTaskData, rescheduleTasksOnLoad, saveScheduledTasks, buildMap, shutdown |
| top-level / `me/andy/chatmod/manager/SpritesManager.java` | `` |  | loadConfig, isVanillaReplacementKey, resolve, resolveVanillaReplacement, getAliases, getVanillaReplacements |
| top-level / `me/andy/chatmod/message/AtlasSpriteHelper.java` | `` |  | buildSpriteComponent, buildSpriteFromItemStack, resolveAlias, atlasForPath, spriteIdForPath, buildFromJson, buildPlayerHeadComponent |
| top-level / `me/andy/chatmod/message/BroadcastManager.java` | `` |  | buildScheduler, start, updateIntervalFromConfig, onTick, executeBroadcast, stop, reload |
| top-level / `me/andy/chatmod/message/ChatMessageDecorator.java` | `` |  | decorate, preprocessMessageContent, processContent, deriveIconTyped, deriveIconOnlyTyped, processFormatCodes, sendPlayerTagSound, sendEveryoneTagSound |
| top-level / `me/andy/chatmod/message/MessageFormatter.java` | `` |  | isNullOrWhitespace, isLikelyUrlCandidate, ensureUrlScheme, expandTypedPlaceholders, deriveIconTyped, deriveIconOnlyTyped, formatMessage, formatForChatFormat, formatMessageAsHover, formatLines, parseSingleLine, processIconOnlyItem, buildIconOnlyResult, processIconItem, buildIconItemResult, processTextItem, buildTextItemResult, processSpriteToken, processCustomPlaceholder, resolveAtPlayerName, buildPlayerNameHover, buildPlayerNameClickEvent, buildAtPlayerIconOnly, buildAtPlayerIconAndName, buildAtPlayerNameOnly, buildAtPlayerTag, buildAtPlayerWithFormat, processEveryoneTag, applyIconOnlyFmt, applyIconNameFmt, propagateHover, resolveItemStack, buildItemName, createClickEvent, applyMinecraftFormatting, getMessagesConfig, getPlaceholderTagFormat, stripFormattingForLength |
| top-level / `me/andy/chatmod/message/PlaceholderResolver.java` | `` |  | resolve, resolvePlaceholders, resolveInternal, resolveToComponent, replaceWithNA, formatDuration, formatTimestamp |
| top-level / `me/andy/chatmod/scheduler/BroadcastTask.java` | `` |  | run, handleActionBar, sendAndHoldActionBar, handleTitle, sendTitleSet, holdActionBarOnly, handleBossBar, showBossBar |
| top-level / `me/andy/chatmod/scheduler/ScheduledBroadcastsStore.java` | `` |  | getScheduledTasks |
| top-level / `me/andy/chatmod/scheduler/ScheduledBroadcastTaskData.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
