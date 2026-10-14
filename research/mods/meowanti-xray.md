# Meow Anti-Xray

Review status: **Evidence inventory; behavioral review pending**

Project: [Meow Anti-Xray](https://modrinth.com/mod/meowanti-xray)
Selected artifact version: `1.7.0+mc26.3.fabric`
Published implementation source: https://github.com/xiaoyiluck666/MeowAnti-Xray
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

🛡️ Server-side AntiXray & ore obfuscation for Fabric/NeoForge. 💎 Hides unexposed ores from X-ray clients. 🚀 No client install. Minecraft 26.1–26.3.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `05d96f2c280d63f4fcaa79621cba704019acd602`
- `sha512`: `4a1efe4d13a67ef71d291216eb78ea71b647b62da4feb51891f47eeb2e0cba05b460a8eb4fe7f0579a18b2956f7c51cf135d114d154787a7339f0cc6c994713c`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 70
Reconstructed Java files: 23

**environment**

```json
"server"
```

**entrypoints**

```json
{
  "main": [
    "com.meowantixray.fabric.MeowAntiXrayFabricMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3 <26.4",
  "java": ">=25",
  "fabric-api": ">=0.161.0+26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/meowantixray/antixray/FakeOreConfig.java` | `` |  | loadOrCreate, loadSummary, validateSyntax, stripUtf8Bom, hasUnclosedQuote, stripCommentStatic, countIndentStatic, stripYamlQuotesStatic, supplementMissingKeys, collectGlobalSupplements, collectDimensionSupplements, parseDimensionBlocks, setDimensionDefaults, read, applyGlobalScalar, applyDimensionScalar, parseInlineList, parseBoolean, parseInt, parseString, stripComment, countIndent, normalizeDimensionKey, writeConfigChecked, renderConfigLines, renderMissingGlobalScalarLines, renderGlobalListSection, renderDimensionSettingsSection, renderDimensionBlock, renderMissingDimensionScalarLines, renderDimensionListSection, appendGlobalScalarIfMissing, appendDimensionScalarIfMissing, isGlobalScalarKey, isDimensionScalarKey, findTopLevelSection, findBlockEnd, firstExistingIndex, contentOf, keyOf, sectionNameOf, splitInlineList, stripYamlQuotes, writeLines, defaultHiddenBlocks, defaultReplacementBlocks, IntRange, InsertFragment |
| top-level / `com/meowantixray/antixray/FakeOreService.java` | `` |  | asyncRewriteCapacity, reloadConfig, activateConfig, applyConfig, onPlayerDisconnect, shouldBypassForPlayer, sendChunkPacket, shutdownAsyncExecutor, obfuscateChunkPacket, onBlockBroken, onBlockChange, onBlockBreakStarted, onExplosionBlocksChanged, onServerTick, describeConfig, statusDetails, configDetails, isEnabled, stressChunkRewrite, configLoadSummary, configPathSummary, reloadConfigWithSummary, validateConfig, validateRuntimeConfig, validatePaletteConfig, validateBlockIds, formatValidationIssues, profileSummary, formatRatio, asyncAvailablePermits, recordDuration, formatAverageMillis, formatMillis, formatMillis, debugBlock, inspectBlockDetails, playerList, revealAround, updateNearbyBlocksLikePaper, collectPaperNeighborResync, collectResyncCandidate, addRevealCandidate, cachedVisibilityBuild, addRevealPosition, sendRevealBatches, createChunkSendContext, sendPacket, fallbackSyncChunkSend, ensureChunkRewriteExecutor, tryAcquireAsyncRewritePermit, ensureChunkRewritePermits, releaseAsyncRewritePermit, submitAsyncChunkRewrite, createChunkRewriteController, createChunkRewriteRuntime, scheduleChunkRewriteCompletion, prepareChunkRewrite, snapshotCenterSections, snapshotNeighborSections, snapshotSection, snapshotPaletteEntries, processAsyncChunkTask, obfuscateLiveSectionLayers, blockY, sourceState, fakeState, recordChange, obfuscateSnapshotSectionLayers, blockY, sourceState, fakeState, recordChange, obfuscateSectionLayers, obfuscateLayer, completeAsyncChunkSend, applyRevealCandidatesToPlayer, updateBlockLikePaper, clearTrackedPosition, trackedBlockLocation, isPaperSolid, inspectBlockRevealState, inspectBlockRevealState, inspectBlockRevealState, isExposed, isHiddenState, isExposed, getSectionByY, buildSectionVisibilityForBlock, buildSectionVisibilityForSection, buildSectionVisibilityForLoadedSection, resolveLoadedChunkSection, buildSectionVisibility, buildSectionVisibility, buildSectionVisibility, propagateOpenTransparencyBottomUp, propagateOpenTransparencyTopDown, floodLayerOpenTransparency, enqueueLayerNeighbor, seedVerticalIncoming, clearLayerWindow, touchesHorizontalBoundaryTransparent, isVerticalBoundaryTransparent, touchesTransparentBoundary, isAdjacentToOpenCell, blockIndex, isPaperTransparentOverride, snapshotNullableSectionPalette, snapshotNullableSectionPalette, readVisibilityNeighborhood, readVisibilityNeighborhood, snapshotPaletteRead, readSectionPalette, readSectionPalette, readSectionPalette, readGlobalPaletteStates, readLocalPaletteStates, isTransparentNeighbor, rewriteSections, applyObfuscationPlanToSection, serializeSectionBytes, tryPatchSectionBytesInPlace, repackSectionBytes, buildTargetPaletteEntries, remapIndicesForTargetPalette, resolveTargetPaletteId, indexOfState, writeTargetPalette, readPackedLong, writePackedLong, chooseFakeState, chooseFakeState, chooseLayerFakeState, mixBlockSeed, mixSectionSeed, normalizeNonZeroSeed, xorshift32, scaleUnsignedBound, createObfuscationRandom, createChunkPacketInfo, createChunkPacketInfo, isHiddenState, isReplacementState, isTargetState, isSolidState, registryStateId, naturalReplacement, naturalReplacement, replacementProfile, paletteFor, normalizeDimensionKey, buildPalette, buildTargetStateLookup, obfuscatesReplacementBlocks, isEntityBlock, normalizePermissionNode, captureStatusSnapshot, formatStatusLines, describeConfigChanges, appendChange, appendDimensionChange, Palette, ActivationResult, ChunkSendContext, ChunkRewriteController, ChunkPacketInfo, SectionPaletteReadResult, matches, hiddenAt, replacementAt, solidAt, VisibilityBuildResult, isExposed, recordLive, recordSnapshot, isEmpty, reachedBudget, changedBlocks, trackedInSection, changedIndices, fakeStates, toShortArray, enterLayer, nextDecoyIndex, nextReplacementIndex, LoadedChunkSection, BlockRevealContext, RuntimeStatusSnapshot, ChunkRewritePreparation, toAsyncChunkTask, clearTrackedSections, applyTrackedSections, resolvePlayerMask, applyAsyncResult, SectionSnapshot, stateCount, stateAt, findPaletteId, AsyncChunkTask, AsyncChunkResult, ReloadReport, ValidationReport, TrackedBlockLocation, ChunkRewriteRuntime, refresh, storage, palette, close, initDataField, initDataMethod, readData, readStorage, readPalette, VisibilityNeighborhood, reset, clearLayerWindows, ensurePaletteCapacity, result, set, DimensionStatus |
| top-level / `com/meowantixray/compat/MinecraftCompat.java` | `` |  | currentMinecraftVersionId, tryLevelKey, findBlockById, chunkX, chunkZ, minBuildY, maxBuildY, hasCommandPermission, hasCommandPermission, dayTime, setDayTime, trackDebugChunkIfSupported, paletteSerializedSize, writeLongArray, copySection, getJumpBoost, isBoatEntity, openUrlClickEvent, copyToClipboardClickEvent, showTextHoverEvent, createBossBar, getEffect, readChunkCoordinate, invokeInt, commandPermissionForLevel, overworldClockHolder, tryParseId, parseId, normalizeId, namespace, path, invokeNoArg, invokeStaticSingleArg, invokeStaticSingleArg, invokeSingleArg, invokeSingleArg, tryInvokeSingleArg, tryInvokeTwoArgs, acceptsArg, instantiateNested, instantiateDirect, readStaticField, instanceOf, findField, findClass, findClassOrNull, requireNonNull |
| top-level / `com/meowantixray/fabric/FabricModPlatform.java` | `` |  | loaderType, configDir, gameDir, isModLoaded, modVersion, hasPermission, hasPermission, findCheckMethod |
| top-level / `com/meowantixray/fabric/MeowAntiXrayFabricMod.java` | `` |  | onInitialize |
| top-level / `com/meowantixray/MeowAntiXrayCommands.java` | `` |  | register, buildAntiXrayCommand, stressCommand, inspectCommand, commandArgument, hasAdminPermission, sendAntiXrayStatus, sendAntiXrayConfig, validateAntiXrayConfig, reloadAntiXray, sendAntiXrayProfile, stressAntiXray, inspectAntiXrayBlock, resolveWorld, sendCommandLines, stripPrefix, worldLabel, worldId |
| top-level / `com/meowantixray/MeowAntiXrayMod.java` | `` |  | fakeOre, currentServer, initialize, onServerStarted, onServerStopping, onServerTick, onPlayerDisconnect, onPlayerJoin, onPlayerBreakBlock, isAdminLikePlayer |
| top-level / `com/meowantixray/metrics/BStatsMetrics.java` | `` |  | start, shutdown, recordServerTick, loadConfig, saveConfig, submitSafely, submit, gzip, platformName, parseServiceId, quote, info, warn |
| top-level / `com/meowantixray/mixin/ClientboundLevelChunkPacketDataAccessor.java` | `value={ClientboundLevelChunkPacketData.class})` | Accessor:2 |  |
| top-level / `com/meowantixray/mixin/LegacyServerExplosionMixin.java` | `targets={"net.minecraft.world.level.Explosion"})` | Inject:1 | meowconsole$refreshAntiXrayAfterLegacyExplosion |
| top-level / `com/meowantixray/mixin/MeowAntiXrayMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply, classExists, hasMethod, isInterface, readClassNode, classResource |
| top-level / `com/meowantixray/mixin/PalettedContainerAccessor.java` | `value={PalettedContainer.class})` | Accessor:1 |  |
| top-level / `com/meowantixray/mixin/PalettedContainerDataAccessor.java` | `targets={"net.minecraft.world.level.chunk.PalettedContainer$Data"})` | Accessor:2 |  |
| top-level / `com/meowantixray/mixin/PlayerChunkSenderMixin.java` | `value={PlayerChunkSender.class})` | Inject:1, Redirect:1 | meowconsole$sendNeoForgeChunkWithAntiXray, meowconsole$obfuscateChunkPacketBeforeSend, shouldUseVanillaChunkPacketContext |
| top-level / `com/meowantixray/mixin/ServerExplosionMixin.java` | `targets={"net.minecraft.world.level.ServerExplosion"})` | Inject:1 | meowconsole$afterInteractWithBlocks |
| top-level / `com/meowantixray/mixin/ServerLevelBlockUpdateMixin.java` | `value={Level.class})` | Inject:2 | meowconsole$captureOldState, meowconsole$refreshAntiXrayNearby |
| top-level / `com/meowantixray/mixin/ServerPlayerGameModeMixin.java` | `value={ServerPlayerGameMode.class})` | Inject:1 | meowconsole$onStartDestroy |
| top-level / `com/meowantixray/platform/LoadedModInfo.java` | `` |  | LoadedModInfo |
| top-level / `com/meowantixray/platform/LoaderType.java` | `` |  | modrinthLoaderId |
| top-level / `com/meowantixray/platform/ModPlatform.java` | `` |  |  |
| top-level / `com/meowantixray/platform/PlatformHelper.java` | `` |  | bind, get, loaderType, configDir, gameDir, isModLoaded, modVersion, hasPermission |
| top-level / `com/meowantixray/platform/PlatformSupport.java` | `` |  | hasUsablePermissionRequest |
| top-level / `com/meowantixray/update/ModrinthUpdateChecker.java` | `` |  | checkAsync, statusSummary, notifyAdminIfUpdateAvailable, sendStatusTo, shutdown, check, updateUri, encodeJsonArray, latestVersion, remoteVersion, primaryDownloadUrl, releaseNotes, cleanMarkdownLine, truncate, stringMember, parseDate, normalizeVersion, versionParts, logStatus, notifyOnlineAdmins, link, sendSystemMessage, literal, UpdateStatus, RemoteVersion, compareTo, newThread |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
