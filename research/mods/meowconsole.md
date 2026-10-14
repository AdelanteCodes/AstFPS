# MeowConsole

Review status: **Evidence inventory; behavioral review pending**

Project: [MeowConsole](https://modrinth.com/mod/meowconsole)
Selected artifact version: `1.5.0+mc26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Server-side operations console for Minecraft 26.1-26.3 on Fabric/NeoForge: colorful dashboards, health/TPS/entity diagnostics, granular permissions, and panel compatibility.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `71ae662dd435b4b18d148481790b8c28512acdbbb8f0c5a87a508cae9cbdd4597137d721bf142713f7d8daa9b8b9b6f4d7fc443ae2d8198507a7b3c4ee863fc7`
- `sha1`: `faafaebe7b264496e372ad9b9dde1e63184c1dda`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 57
Reconstructed Java files: 36

**environment**

```json
"server"
```

**entrypoints**

```json
{
  "main": [
    "com.meowconsole.fabric.MeowConsoleFabricMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "26.3",
  "java": ">=25",
  "fabric-api": ">=0.161.0+26.3"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/jline-native-3.30.6.jar` | 18 | `org_jline_jline-native` | No |
| `META-INF/jars/jline-reader-3.30.6.jar` | 75 | `org_jline_jline-reader` | No |
| `META-INF/jars/jline-terminal-3.30.6.jar` | 114 | `org_jline_jline-terminal` | No |
| `META-INF/jars/jline-terminal-jni-3.30.6.jar` | 15 | `org_jline_jline-terminal-jni` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/meowconsole/compat/MinecraftCompat.java` | `` |  | currentMinecraftVersionId, tryLevelKey, findBlockById, chunkX, chunkZ, minBuildY, maxBuildY, hasCommandPermission, hasCommandPermission, dayTime, setDayTime, playersSleepingPercentage, canPlayersSleepThroughNight, advanceTimeWhenPlayersSleep, advanceWeatherWhenPlayersSleep, moveToWakeUpFromSleep, isRaining, resetWeatherCycle, isSleepingLongEnough, readBooleanGameRule, trackDebugChunkIfSupported, paletteSerializedSize, writeLongArray, copySection, getJumpBoost, isBoatEntity, openUrlClickEvent, copyToClipboardClickEvent, showTextHoverEvent, createBossBar, getEffect, readChunkCoordinate, invokeInt, commandPermissionForLevel, overworldClockHolder, tryParseId, parseId, normalizeId, namespace, path, invokeNoArg, invokeStaticSingleArg, invokeStaticSingleArg, invokeSingleArg, invokeSingleArg, tryInvokeSingleArg, tryInvokeTwoArgs, acceptsArg, instantiateNested, instantiateDirect, readStaticField, instanceOf, findField, findClass, findClassOrNull, requireNonNull |
| top-level / `com/meowconsole/config/ConfigFileIO.java` | `` |  | writeLinesAtomically, backupBrokenFile |
| top-level / `com/meowconsole/config/ConsoleConfig.java` | `` |  | defaults, loadOrCreate, historyEnabled, historyMaxEntries, logFilterEnabled, layoutMode, compactWidthThreshold, useCompactLayout, healthWarnTps, healthWarnMspt, loadSummary, validationWarnings, describe, shouldFilterConsoleLog, read, applyScalarOrList, parseInlineList, addListValue, compileRegexRules, supplementMissingKeys, renderConfigLines, renderMissingKeys, appendIfMissing, writeConfig, backupBrokenConfig, findTopLevelSection, findBlockEnd, stripComment, countIndent, contentOf, keyOf, unquote, parseBoolean, parseInt, parseDouble, parseLayoutMode, format |
| top-level / `com/meowconsole/config/McdrCompatibilityConfig.java` | `` |  | loadOrCreate, loadSummary, describeConfig, supplementMissingKeys, read, applyScalar, renderConfigLines, renderMissingKeys, appendIfMissing, parseBoolean, writeConfig, writeLines, backupBrokenConfig, findTopLevelSection, findBlockEnd, stripComment, countIndent, contentOf, keyOf |
| top-level / `com/meowconsole/config/MeowConsoleFeatureConfigPaths.java` | `` |  | sharedPath, legacyPlayerMessagesPath, legacySleepAccelerationPath, legacyVelocityPath, consoleHistoryPath |
| top-level / `com/meowconsole/ConsoleTextRenderer.java` | `` |  | renderLegacyFormatting, renderChat, renderComponent, styleToAnsi, isLegacyFormattingMarker, ansiForLegacyHexColor, isHexDigit, ansiForLegacyCode, ansiColor |
| top-level / `com/meowconsole/EntityDiagnostics.java` | `` |  | resolveWorld, worldLabel |
| top-level / `com/meowconsole/fabric/FabricModPlatform.java` | `` |  | loaderType, configDir, gameDir, isModLoaded, modVersion, loadedMods, hasPermission, permissionSummary |
| top-level / `com/meowconsole/fabric/FabricPermissionBridge.java` | `` |  |  |
| top-level / `com/meowconsole/fabric/MeowConsoleFabricMod.java` | `` |  | onInitialize |
| top-level / `com/meowconsole/flightguard/FlightGuardConfig.java` | `` |  | loadOrCreate, loadSummary, describe, supplementMissingKeys, read, applyScalar, renderConfigLines, renderMissingKeys, appendIfMissing, parseBoolean, parseInt, normalizeAction, parseDouble, format, writeConfig, writeLines, backupBrokenConfig, findTopLevelSection, findBlockEnd, stripComment, countIndent, contentOf, keyOf |
| top-level / `com/meowconsole/flightguard/FlightGuardService.java` | `` |  | reloadConfig, onPlayerJoin, onPlayerDisconnect, onPlayerDamaged, onPlayerDamaged, onServerTick, configLoadSummary, describeConfig, profileSummary, isEnabled, handlePlayer, handleBoat, respond, resetState, format, reset, update |
| top-level / `com/meowconsole/McdrCompatibilityService.java` | `` |  | reloadConfig, configLoadSummary, describeConfig, detectionSummary, isCompatibilityActive, preserveStdout, preserveVanillaConsoleInput, preserveChatLog, preserveJoinLeaveLog, consoleInputPreservationReason, detectEnvironment, commandLine |
| top-level / `com/meowconsole/MeowConsoleCommands.java` | `` |  | register, executeIfAllowed, showStatus, showHealth, showPerformance, showAlerts, showMods, showEntityWorlds, showEntities, showConsoleStatus, validateConsoleConfig, reloadConsoleConfig, reload, checkUpdate, send |
| top-level / `com/meowconsole/MeowConsoleMod.java` | `` |  | tickMetrics, flightGuard, playerMessages, sleepAcceleration, velocityBridge, currentServer, mcdrCompatibility, shouldPreserveStdout, shouldPreserveVanillaConsoleInput, shouldPreserveChatLog, shouldPreserveJoinLeaveLog, deferVanillaConsoleThread, activateVanillaConsoleFallback, printStyledConsoleLog, printConsoleInfo, initialize, onServerStarting, onServerStarted, onServerStopping, onServerTick, onPlayerDisconnect, onPlayerJoin, isAdminLike, isAdminLikePlayer, reloadConsoleConfig, consoleConfigLoadSummary, consoleConfigSummary, consoleConfigValidationWarnings, consoleHealthWarnTps, consoleHealthWarnMspt |
| top-level / `com/meowconsole/mixin/DedicatedServerMixin.java` | `value={DedicatedServer.class})` | Redirect:1 | meowconsole$skipVanillaConsoleHandler |
| top-level / `com/meowconsole/mixin/MeowConsoleMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply, hasMethod, resourcePath |
| top-level / `com/meowconsole/mixin/MinecraftServerChatLogMixin.java` | `value={MinecraftServer.class})` | Inject:1 | meowconsole$renderColoredChat |
| top-level / `com/meowconsole/mixin/PlayerListJoinLeaveMessageMixin.java` | `value={PlayerList.class})` | Redirect:2 | meowconsole$customJoinMessage, meowconsole$customJoinMessageWithFilter |
| top-level / `com/meowconsole/mixin/ServerGamePacketListenerDisconnectMixin.java` | `value={ServerGamePacketListenerImpl.class})` | Redirect:1 | meowconsole$customLeaveMessage |
| top-level / `com/meowconsole/mixin/ServerPlayerDamageMixin.java` | `value={ServerPlayer.class})` | Inject:1 | meowconsole$markDamageGrace |
| top-level / `com/meowconsole/PaperLikeConsole.java` | `` |  | runConsoleLoop, createTerminal, tryCreateTerminal, buildTerminal, selectTerminalProviders, createSystemTerminal, configureCompletionTabBinding, bindTabToCompleteWord, installLogBridge, append, uninstallLogBridge, handleLocalConsoleCommand, printManualCompletions, printConsoleValidation, handleImplicitCompletionFromTrailingSpaces, printCompletionCandidates, countTrailingPadding, countTrailingTabs, quoteInput, printPerformanceSnapshot, joinTps, joinMspt, formatMsptWindow, colorizeTps, colorizeMspt, formatOneDecimal, printEntitySnapshot, printEntityTypeRanking, parseEntityCommandInput, isPositiveInt, parsePositiveInt, availableWorldHints, collectModState, filterMods, filterNames, printUserPanel, printSystemPanel, printLoadedPanel, printUnloadedPanel, joinModInfos, normalizePath, printPanel, printSectionHeader, printSectionHint, printDetailLine, printAlertLine, padRight, currentTerminalWidth, sectionWidth, printStartupDashboardContent, printAlertPanelContent, collectAlerts, statusText, runManualUpdateCheck, printUpdateStatus, formatLogLine, buildConsoleLogLine, complete, collectCandidates, suggestionValue, candidateKey, completeLocal, localCandidate, modsTooltip, velocityTooltip, flightTooltip, sleepTooltip, messageTooltip, mcdrTooltip, updateTooltip, highlight, highlightBrigadier, highlightLocal, appendLocalTokens, styleForToken, isLocalCommand, setErrorPattern, setErrorIndex, EntityCommandInput, BrigadierInput, of, toOriginalCursor |
| top-level / `com/meowconsole/permission/ConsolePermission.java` | `` |  | path, fallbackLevel, fabricNode, neoForgeNode, test, all |
| top-level / `com/meowconsole/platform/LoadedModInfo.java` | `` |  | LoadedModInfo |
| top-level / `com/meowconsole/platform/LoaderType.java` | `` |  | modrinthLoaderId |
| top-level / `com/meowconsole/platform/ModPlatform.java` | `` |  |  |
| top-level / `com/meowconsole/platform/PlatformHelper.java` | `` |  | bind, get, loaderType, configDir, gameDir, isModLoaded, modVersion, loadedMods, hasPermission, permissionSummary |
| top-level / `com/meowconsole/playermessages/PlayerMessageConfig.java` | `` |  | loadOrCreate, loadSummary, migrateFromLegacyIfPresent, tryReadLegacyValues, supplementMissingKeys, read, applyScalar, renderConfigLines, renderMissingKeys, quote, appendIfMissing, unquote, parseBoolean, writeConfig, writeLines, backupBrokenConfig, findTopLevelSection, findBlockEnd, stripComment, countIndent, contentOf, keyOf |
| top-level / `com/meowconsole/playermessages/PlayerMessageHooks.java` | `` |  | broadcastJoin, broadcastLeave, passThrough |
| top-level / `com/meowconsole/playermessages/PlayerMessageService.java` | `` |  | reloadConfig, configLoadSummary, describeConfig, isEnabled, isJoinMessageEnabled, isLeaveMessageEnabled, createJoinMessage, createLeaveMessage, renderTemplate |
| top-level / `com/meowconsole/RuntimeHealthSnapshot.java` | `` |  |  |
| top-level / `com/meowconsole/sleepacceleration/SleepAccelerationConfig.java` | `` |  | loadOrCreate, loadSummary, describeConfig, migrateFromLegacyIfPresent, tryReadLegacyValues, supplementMissingKeys, read, applyScalar, applyCompatibilityAliases, renderConfigLines, renderMissingKeys, appendIfMissing, appendCommentedIfMissing, parseBoolean, parseInt, parseDouble, writeConfig, writeLines, backupBrokenConfig, findTopLevelSection, findBlockEnd, stripComment, countIndent, contentOf, keyOf, stripQuotes |
| top-level / `com/meowconsole/sleepacceleration/SleepAccelerationService.java` | `` |  | reloadConfig, configLoadSummary, describeConfig, isEnabled, onServerTick, filterTrackedPlayers, broadcastOverlay, skipNight |
| top-level / `com/meowconsole/TickMetricsService.java` | `` |  | tpsWindow, msptWindow, indexFromNewest, nanosToMillis |
| top-level / `com/meowconsole/update/ModrinthUpdateChecker.java` | `` |  | checkAsync, checkAsync, checkAsyncForAdminJoin, cachedStatus, versionsPage, submitCheck, isAutomaticResultFresh, checkNow, failedResult, announceToConsoleIfNeeded, notifyOnlineAdminsIfNeeded, currentVersion, fetchLatestVersion, apiUrlForCurrentGameVersion, hasUpdateAvailable, hasAdminJoinReminder, formatConsoleUpdateAvailable, formatConsoleUpdatePage, sendAdminJoinReminder, sendAdminReminder, buildAdminStatusLine, buildAdminActionLine, safeValue, CheckResult, parse, compareTo |
| top-level / `com/meowconsole/velocity/VelocityBridgeService.java` | `` |  | reloadAndApply, statusSummary, loadSummary, applySummary, isEnabled, fabricProxyLiteModId, isFabricProxyLiteLoaded, loadOrCreateConfig, parseSectionConfig, parseFlatConfig, parseMap, supplementMissingKeys, writeNewConfig, renderConfigSectionLines, renderMissingKeys, appendIfMissing, quote, findTopLevelSection, findBlockEnd, stripComment, countIndent, contentOf, keyOf, writeLines, applyFabricProxyLiteConfig, backupBrokenConfig, mergeToml, parseBoolean, parseForwarding, parseSecret, sanitizeFileName, sanitizeModId, sanitizeVersion, parseText, unquote, escape, randomSecret, defaults |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
