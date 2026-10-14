# Carpet ROF Addition

Review status: **Evidence inventory; behavioral review pending**

Project: [Carpet ROF Addition](https://modrinth.com/mod/carpet-rof-addition)
Selected artifact version: `1.6.1`
Published implementation source: https://github.com/Melationin/ROF-Carpet-Addition
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

An optimized Carpet mod that slightly disrupts vanilla features.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `f97cf3c18f332df4f6b8af82634d042b122bea5e`
- `sha512`: `aa458f9a6a5b619631ca2644a28d06cd2be491af1ba9800c46699efa6f96a1da694c0a5b1343d19fcfac54c2aa24a3c79c98e02e49f3d9bb8998925880a6e7f2`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 197
Reconstructed Java files: 165

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.carpet.rof.ROFCarpetServer"
  ]
}
```

**depends**

```json
{
  "minecraft": "26.3",
  "fabricloader": ">=0.4.0",
  "carpet": "*",
  "lithium": "*"
}
```

**accessWidener**

```json
"CarpetRofAddition.aw"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/carpet/rof/annotation/PublicField.java` | `` |  |  |
| top-level / `com/carpet/rof/annotation/QuickTranslations.java` | `` |  |  |
| top-level / `com/carpet/rof/commands/AsyncWorldgenDebugCommand.java` | `` |  | register, start, sendResult |
| top-level / `com/carpet/rof/commands/BaseCommand.java` | `` |  | register |
| top-level / `com/carpet/rof/commands/BetterPlayerCommand.java` | `` |  | register |
| top-level / `com/carpet/rof/commands/BiomeGetterCommand.java` | `` |  | register |
| top-level / `com/carpet/rof/commands/ExposureCacheDebugCommand.java` | `` |  | register, start, stop, reset, report, send |
| top-level / `com/carpet/rof/commands/extraChunkData/ExceedChunkCommand.java` | `` |  | display, getWorldFromContext, loadFromWorld, setTopY, clear, save, registerCommand |
| top-level / `com/carpet/rof/commands/extraChunkData/ExtraChunkDatasCommand.java` | `` |  | register |
| top-level / `com/carpet/rof/commands/FakePlayerMatrixDebugCommand.java` | `` |  | register, spawnMatrix, killFakes |
| top-level / `com/carpet/rof/commands/ISECommand.java` | `` |  |  |
| top-level / `com/carpet/rof/commands/ItemFillDebugCommand.java` | `` |  | register, stats |
| top-level / `com/carpet/rof/commands/LoadedChunkFinderCommand.java` | `` |  | register |
| top-level / `com/carpet/rof/commands/loggerCommand/PacketLoggerCommand.java` | `` |  | register, printPacketData, byteSizeToString |
| top-level / `com/carpet/rof/commands/OecDebugCommand.java` | `` |  | register, stats, reset |
| top-level / `com/carpet/rof/commands/OptimizedExplosionDebugCommand.java` | `` |  | register, start, stop, reset, report, send |
| top-level / `com/carpet/rof/commands/RepeatDebugCommand.java` | `` |  | register |
| top-level / `com/carpet/rof/commands/RequirementModifyCommand.java` | `` |  | initialization, register, RequirementModify |
| top-level / `com/carpet/rof/commands/SearchCommand.java` | `` |  | makeSetRuleButton, displayInteractiveSetting, executeCommand, register, getSuggestions |
| top-level / `com/carpet/rof/commands/TickSprintFullCommand.java` | `` |  | register, sprintFull |
| top-level / `com/carpet/rof/debug/EnderPearlDebug.java` | `` |  | getDebugName, isDebugName, parseVelocity, direction, reportLanding, fmtVec, fmtPos |
| top-level / `com/carpet/rof/debug/ItemFillStats.java` | `` |  | snapshot, bar, Snapshot, lines |
| top-level / `com/carpet/rof/debug/OptimizedExplosionStats.java` | `` |  | isActive, start, stop, reset, clearCounters, onExplosion, onSkipped, onCachedVerdict, onDryRun, onUnsafeVerdict, onBelowThreshold, onForceStopped, onUnavailable, onExposureComputed, onExposureReused, onExposureMiss, onExposureMissIndex, onExposureUnmanaged, onEntityQuery, lines, exposureLines, percent |
| top-level / `com/carpet/rof/debug/SprintTickTimer.java` | `` |  | start, isRunning, onTickEnd, finish |
| top-level / `com/carpet/rof/Docs.java` | `` |  | mdSafe, parseSettingsClass, generateDocument, generateCommand, saveStringToFile, main1, main2 |
| top-level / `com/carpet/rof/event/ROFEvents.java` | `` |  | getData, getData, putData, register, run, register, register, run, apply |
| top-level / `com/carpet/rof/extraWorldData/asyncWorldgen/DelayedChunkSnapshot.java` | `` |  | isFresh, beginRefresh, chunks, clear |
| top-level / `com/carpet/rof/extraWorldData/ExtraChunkData.java` | `` |  | needSave, enable, setEnable, setNeedSave |
| top-level / `com/carpet/rof/extraWorldData/extraChunkDatas/ChunkEntitySpawnLogger.java` | `` |  | run, add, get, Key, equals, hashCode |
| top-level / `com/carpet/rof/extraWorldData/extraChunkDatas/ChunkLoadedFinder.java` | `` |  | getConnectedChunks, size, getCenterChunk |
| top-level / `com/carpet/rof/extraWorldData/extraChunkDatas/ExceedChunkMarker.java` | `` |  | getName, clear, isNotHighChunk, addChunk, removeChunk, mustBeAir, mustBeAir, getHighest, getSize, update, write, read, toNbt, loadFromWorld |
| top-level / `com/carpet/rof/extraWorldData/ExtraWorldDatas.java` | `` |  | fromWorld, write, read, toNbt |
| top-level / `com/carpet/rof/generated/CommandList.java` | `` |  |  |
| top-level / `com/carpet/rof/generated/SettingList.java` | `` |  |  |
| top-level / `com/carpet/rof/logger/packetLogger/PacketLogger.java` | `` |  | addPacket, addPacket, clear, start, stop, getTicks, getRealTime, setEndtime, run |
| top-level / `com/carpet/rof/mixin/async/ChunkMapMixin.java` | `value={ChunkMap.class})` | Inject:2 | rof$useCachedSpawningChunks, rof$cacheSpawningChunks |
| top-level / `com/carpet/rof/mixin/async/LevelChunkMixin.java` | `value={LevelChunk.class})` |  | rof$getRandomTickResult, rof$setRandomTickResult, rof$getSpawnResult, rof$setSpawnResult |
| top-level / `com/carpet/rof/mixin/async/NaturalSpawnerMixin.java` | `value={NaturalSpawner.class})` | Inject:1 | rof$asyncNaturalSpawning |
| top-level / `com/carpet/rof/mixin/async/ServerChunkCacheMixin.java` | `value={ServerChunkCache.class})` | WrapOperation:1, Inject:1 | rof$cacheBlockTickingChunks, rof$submitSpawningBatch |
| top-level / `com/carpet/rof/mixin/async/ServerLevelMixin.java` | `value={ServerLevel.class}, priority=900)` | Inject:1 | rof$asyncRandomTick |
| top-level / `com/carpet/rof/mixin/blockChange/LevelChunkMixin.java` | `value={LevelChunk.class})` | Inject:1 | rof$getBlockChangeStamp, rof$bumpBlockChangeStamp |
| top-level / `com/carpet/rof/mixin/blockChange/LevelMixin.java` | `value={Level.class})` |  | rof$getBlockChangeStamp, rof$blockChangeStampAdd, rof$setBlockChangeStamp |
| top-level / `com/carpet/rof/mixin/debug/ChunkStatusTasksMixin.java` | `value={ChunkStatusTasks.class})` | Inject:1 | rof$logChunkFull |
| top-level / `com/carpet/rof/mixin/debug/ServerTickRateManagerMixin.java` | `value={ServerTickRateManager.class})` | Inject:3 | rof$reportSprintTick, rof$finishReportOnRestart, rof$finishReport |
| top-level / `com/carpet/rof/mixin/debug/ThrownEnderpearlDebugMixin.java` | `value={ThrownEnderpearl.class}, priority=900)` | Inject:2 | rofDebugTickHead, rofDebugOnRemoval |
| top-level / `com/carpet/rof/mixin/event/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:3 | init, tickEnd, tickBegin |
| top-level / `com/carpet/rof/mixin/event/ServerMixin.java` | `value={MinecraftServer.class})` | Inject:3 | tickEnd, tickBegin, save |
| top-level / `com/carpet/rof/mixin/extraWorldData/forceEntity/LevelMixin.java` | `value={Level.class})` | Inject:1 | getEntityInject |
| top-level / `com/carpet/rof/mixin/extraWorldData/forceEntity/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:1 | collectEntitiesByTypeInject |
| top-level / `com/carpet/rof/mixin/extraWorldData/HeightmapMixin.java` | `value={Heightmap.class})` | Inject:1 | SetMixin |
| top-level / `com/carpet/rof/mixin/extraWorldData/raycast/BlockGetterMixin2.java` | `value={BlockGetter.class})` | Inject:1 | traverseBlocks, blockHitFactory, missFactory |
| top-level / `com/carpet/rof/mixin/extraWorldData/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:4 | rof$getROFextraWorldDatas, shouldBeForceLoaded, isReadyToEntityTick |
| top-level / `com/carpet/rof/mixin/ISE/EntityMixin.java` | `value={Entity.class})` |  |  |
| top-level / `com/carpet/rof/mixin/loadedChunkFinder/ServerLevelMixin.java` | `value={ServerLevel.class}, priority=899)` | Inject:1 | tickChunk |
| top-level / `com/carpet/rof/mixin/logger/packetLogger/PacketEncoderMixin.java` | `value={PacketEncoder.class})` | Inject:1 | encode |
| top-level / `com/carpet/rof/mixin/packetRules/ChunkMapMixin.java` | `value={ChunkMap.class})` | Inject:1 | recoverSpawnLimitedEntities |
| top-level / `com/carpet/rof/mixin/packetRules/EntityTrackerMixin.java` | `value={ChunkMap.TrackedEntity.class})` | Inject:1 | rof$recoverSpawnLimit |
| top-level / `com/carpet/rof/mixin/packetRules/ServerEntityMixin.java` | `value={ServerEntity.class})` | Inject:1 | syncEntityData |
| top-level / `com/carpet/rof/mixin/rules/betterNoAi/MobMixin.java` | `value={Mob.class})` | Inject:3 | rof$getNoBrainAi, rof$setNoBrainAi, rof$readNoBrainAi, rof$writeNoBrainAi, rof$suppressAi |
| top-level / `com/carpet/rof/mixin/rules/enderPearl/EntityMixin.java` | `value={Entity.class})` | WrapOperation:1 | rof$mustSkipPearlInsideBlock, rof$filterPearlInsideBlocks |
| top-level / `com/carpet/rof/mixin/rules/enderPearl/ThrownEnderpearlMixin.java` | `value={ThrownEnderpearl.class})` | Inject:4, WrapOperation:1 | EndPearlHead, EndPearlBetterForce, EndPearlForcedSync, ChunkUnloadingEnd, rof$betterEnderPearlTicket |
| top-level / `com/carpet/rof/mixin/rules/explosion/EntityMixin.java` | `value={Entity.class})` | Inject:1 | rof$getExposureStamp, rof$setExposureStamp, rof$getExposureIndex, rof$setExposureIndex, rof$invalidateExposureOnMove |
| top-level / `com/carpet/rof/mixin/rules/explosion/ServerExplosionMixin.java` | `value={ServerExplosion.class}, priority=500)` | WrapOperation:4 | rof$optimizeExplosionBlocks, rof$useTrackedEntities, rof$mergeKnockback, rof$reuseExposure, isSameGroup |
| top-level / `com/carpet/rof/mixin/rules/explosion/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:2 | rof$clearExplosionMergeData, rof$trackSpawnedEntity |
| top-level / `com/carpet/rof/mixin/rules/fakePlayerTick/EntityPlayerMPFakeMixin.java` | `value={EntityPlayerMPFake.class})` | Inject:1 | optimizedFakePlayerTick$disableWaypoint |
| top-level / `com/carpet/rof/mixin/rules/fakePlayerTick/InventoryMixin.java` | `value={Inventory.class})` | Inject:1 | optimizedFakePlayerTick$mainHandOnly |
| top-level / `com/carpet/rof/mixin/rules/fakePlayerTick/PlayerAiStepMixin.java` | `value={Player.class})` | WrapOperation:1 | optimizedFakePlayerTick$skipShoulderEntities |
| top-level / `com/carpet/rof/mixin/rules/fakePlayerTick/ServerPlayerTickMixin.java` | `value={ServerPlayer.class})` | WrapOperation:5, Inject:3 | isFakeOptimized, optimizedFakePlayerTick$skipContainerBroadcast, optimizedFakePlayerTick$skipPlayerTrigger, optimizedFakePlayerTick$skipLevitationTrigger, optimizedFakePlayerTick$skipAdvancementTracking, optimizedFakePlayerTick$skipFlushDirty, optimizedFakePlayerTick$skipStats, optimizedFakePlayerTick$skipInventoryMapScan, optimizedFakePlayerTick$skipScoreCriteria |
| top-level / `com/carpet/rof/mixin/rules/merge/EntityMixin.java` | `value={Entity.class})` |  | rof$getTickOrder, rof$setTickOrder |
| top-level / `com/carpet/rof/mixin/rules/merge/ItemEntityLazyIterationConsumerMixin.java` | `value={ItemEntityLazyIterationConsumer.class})` | WrapOperation:1 | allowPartialMerge |
| top-level / `com/carpet/rof/mixin/rules/merge/ItemEntityListMixin.java` | `value={ItemEntityList.class})` | ModifyExpressionValue:1 | useAllSameTypeItems |
| top-level / `com/carpet/rof/mixin/rules/merge/ItemEntityMixin.java` | `value={ItemEntity.class})` | WrapOperation:1 | allowPartialMerge |
| top-level / `com/carpet/rof/mixin/rules/merge/PrimedTntMixin.java` | `value={PrimedTnt.class})` | Inject:5 | rof$addMergeCount, rof$getMergedTNTNCount, rof$setMergedTNTNCount, merge, tick, rof$tntExplodes, explode2, onExplode, writeCustomData, readCustomData |
| top-level / `com/carpet/rof/mixin/rules/merge/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:1 | onTick, rof$willTick |
| top-level / `com/carpet/rof/mixin/rules/mobAi/ActivityDataMixin.java` | `value={ActivityData.class})` | Inject:1 | onInit |
| top-level / `com/carpet/rof/mixin/rules/mobAi/BrainProviderMixin.java` | `value={Brain.Provider.class})` | Inject:1 | onMakeBrain |
| top-level / `com/carpet/rof/mixin/rules/mobAi/MobMixin.java` | `value={Mob.class})` | Inject:3 | rof$readMobAi, rof$writeMobAi, rof$mobAiStep, rof$decideMobAi |
| top-level / `com/carpet/rof/mixin/rules/oec/EntityMixin.java` | `value={Entity.class})` | Inject:1 | rof$getEntitySection, rof$setEntitySection, rof$getPushStamp, rof$setPushStamp, rof$getRegisteredCells, rof$setRegisteredCells, rof$getPushableBit, rof$setPushableBit, rof$registerNewCells |
| top-level / `com/carpet/rof/mixin/rules/oec/EntitySectionMixin.java` | `value={EntitySection.class})` | Inject:2 | rof$setSectionKey, rof$sectionKey, rof$entityCount, rof$grid, rof$entities, rof$ensureGrid, rof$clearCells, rof$releaseGrid, rof$onEntityAdded, rof$onEntityRemoved |
| top-level / `com/carpet/rof/mixin/rules/oec/EntitySectionStorageMixin.java` | `value={EntitySectionStorage.class})` | Inject:2 | rof$sectionIds, rof$spanCache, rof$rememberSectionKey, rof$releaseRemovedSection |
| top-level / `com/carpet/rof/mixin/rules/oec/LevelEntityGetterAdapterMixin.java` | `value={LevelEntityGetterAdapter.class})` |  | rof$entitySectionStorage |
| top-level / `com/carpet/rof/mixin/rules/oec/lithium/BlockStateBaseMixin.java` | `value={BlockBehaviour.BlockStateBase.class})` |  | rof$getClimbableCacheEpoch, rof$getClimbableCacheValue, rof$setClimbableCache |
| top-level / `com/carpet/rof/mixin/rules/oec/lithium/LivingEntityClimbableMixin.java` | `value={LivingEntity.class})` | WrapOperation:1 | rof$cacheClimbableTag |
| top-level / `com/carpet/rof/mixin/rules/oec/lithium/WorldHelperMixin.java` | `value={WorldHelper.class}, remap=false)` | WrapOperation:2 | rof$collectPushableEntities, rof$forEachAccessibleNonEmptySection |
| top-level / `com/carpet/rof/mixin/rules/oec/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:1 | rof$entitySectionStorage, rof$rebuildPushGrids |
| top-level / `com/carpet/rof/mixin/rules/particlesPacketsRange/ServerLevelMixin.java` | `value={ServerLevel.class})` | ModifyConstant:1 | modifyNearbyDistance |
| top-level / `com/carpet/rof/mixin/rules/piglinRules/BrainMixin2.java` | `value={Brain.class}, priority=2000)` | Inject:1 | tickSensors |
| top-level / `com/carpet/rof/mixin/rules/piglinRules/MobMixin.java` | `value={Mob.class})` | Inject:1 | loot |
| top-level / `com/carpet/rof/mixin/rules/piglinRules/PiglinAiMixin2.java` | `value={PiglinAi.class})` | Inject:1, WrapOperation:2 | cancelGather, CoreAndIdleWrapper, OtherWrapper, rof$wrap |
| top-level / `com/carpet/rof/mixin/rules/piglinRules/PiglinMixin.java` | `value={Piglin.class})` | Inject:3 | rof$getSuppressingAI, piglinTick, writeCustomData, readCustomData |
| top-level / `com/carpet/rof/mixin/rules/spawnStatistic/ServerChunkCacheMixin.java` | `value={ServerChunkCache.class})` | WrapOperation:1 | rof$simplifySpawnStatistic |
| top-level / `com/carpet/rof/mixin/rules/spawnStatistic/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:1 | rof$getSpawnStatisticSimplified, rof$setSpawnStatisticSimplified, rof$initSpawnStatisticSimplified |
| top-level / `com/carpet/rof/mixin/rules/spawnStatistic/SpawnStateMixin.java` | `value={NaturalSpawner.SpawnState.class})` | Inject:2 | rof$simplifySpawnStatistic, rof$spawnStatisticCanSpawn, rof$spawnStatisticAfterSpawn |
| top-level / `com/carpet/rof/mixinAccessor/EntityAccessor.java` | `` |  | of |
| top-level / `com/carpet/rof/mixinAccessor/LevelAccessor.java` | `` |  | of |
| top-level / `com/carpet/rof/mixinAccessor/LevelChunkAccessor.java` | `` |  | of |
| top-level / `com/carpet/rof/mixinAccessor/MobAccessor.java` | `` |  | of |
| top-level / `com/carpet/rof/mixinAccessor/PiglinAccessor.java` | `` |  | of |
| top-level / `com/carpet/rof/mixinAccessor/PrimedTntAccessor.java` | `` |  | of |
| top-level / `com/carpet/rof/mixinAccessor/ServerLevelAccessor.java` | `` |  | of |
| top-level / `com/carpet/rof/ROFCarpetServer.java` | `` |  | loadExtension, version, onInitialize, onGameStarted, onServerClosed, onServerLoaded, initOnServer, canHasTranslations, registerCommands, registerLoggers |
| top-level / `com/carpet/rof/ROFCommands.java` | `` |  | register |
| top-level / `com/carpet/rof/ROFLoggers.java` | `` |  | register |
| top-level / `com/carpet/rof/ROFSettings.java` | `` |  | loadClasses |
| top-level / `com/carpet/rof/rules/asyncWorldgen/AsyncExecutor.java` | `` |  | start, stop, submitRandomTick, submitSpawning, create, submit, shutdown |
| top-level / `com/carpet/rof/rules/asyncWorldgen/AsyncSettings.java` | `` |  |  |
| top-level / `com/carpet/rof/rules/asyncWorldgen/DebugStats.java` | `` |  | start, stop, current, recordRandomTickDecision, recordNaturalSpawnDecision, recordRandomTickDecision, recordNaturalSpawnDecision, recordRandomTickResult, recordNaturalSpawnResult, snapshot, Snapshot, randomTickAsyncRatio, randomTickResultsPerChunk, naturalSpawnAsyncRatio, naturalSpawnAttemptsPerChunk |
| top-level / `com/carpet/rof/rules/asyncWorldgen/LoadedBlockGetter.java` | `` |  | findChunk, getBlockEntity, getHeight, getMinY, isAvailable, chunk |
| top-level / `com/carpet/rof/rules/asyncWorldgen/randomTick/AsyncRandomTick.java` | `` |  | collect, rof$canSpreadFireAround, submitBatch, compute, consume, Work |
| top-level / `com/carpet/rof/rules/asyncWorldgen/randomTick/RandomTickResult.java` | `` |  | RandomTickResult |
| top-level / `com/carpet/rof/rules/asyncWorldgen/spawner/AsyncNaturalSpawner.java` | `` |  | collect, consume, submitBatch, consumePlan, remainingPositionChecks, compute, Work |
| top-level / `com/carpet/rof/rules/asyncWorldgen/spawner/AsyncSpawnMobSelector.java` | `` |  | mobsAt, fortress, biome |
| top-level / `com/carpet/rof/rules/asyncWorldgen/spawner/AsyncSpawnPlacementValidator.java` | `` |  | result, empty, vanilla |
| top-level / `com/carpet/rof/rules/asyncWorldgen/spawner/SpawnCandidate.java` | `` |  | SpawnCandidate |
| top-level / `com/carpet/rof/rules/asyncWorldgen/spawner/SpawnResult.java` | `` |  | SpawnResult |
| top-level / `com/carpet/rof/rules/BaseSetting.java` | `` |  |  |
| top-level / `com/carpet/rof/rules/betterNoAi/BetterNoAiSettings.java` | `` |  |  |
| top-level / `com/carpet/rof/rules/enderPearl/BetterEnderPearlTicket.java` | `` |  | tryReplaceTicket, isSafe, vanillaTicketTimer |
| top-level / `com/carpet/rof/rules/enderPearl/EnderPearlSettings.java` | `` |  |  |
| top-level / `com/carpet/rof/rules/explosion/ExplosionMergeData.java` | `` |  | isUsed, matches, begin, markBlockDamageEmpty, captureBlockStamp, isBlockVerdictValid, clear, release, tryAddEntity, tryAddEntity, entitySnapshot, cachedExposure, cacheExposure, resetExposureCache |
| top-level / `com/carpet/rof/rules/explosion/OptimizedExplosionSettings.java` | `` |  | enabled |
| top-level / `com/carpet/rof/rules/explosion/OptimizedExplosionUtil.java` | `` |  | shouldSkipBlockCalculation, isApplicable, isSupportedCalculator, makeEntityBox, worstCaseDestroysBlock, rayDestroysBlock |
| top-level / `com/carpet/rof/rules/extraChunkDatas/ExceedChunkMarkerSetting.java` | `` |  |  |
| top-level / `com/carpet/rof/rules/fakePlayerTick/FakePlayerTickSettings.java` | `` |  |  |
| top-level / `com/carpet/rof/rules/ListSettingValidator.java` | `` |  | validate, description |
| top-level / `com/carpet/rof/rules/merge/MergeSetting.java` | `` |  | canPartialMerge, EntityPosAndVec, shouldRegister |
| top-level / `com/carpet/rof/rules/mobAi/BCWrapper.java` | `` |  | getStatus, tryStart, tickOrStop, doStop |
| top-level / `com/carpet/rof/rules/mobAi/MobAiEntityListValidator.java` | `` |  | parseEntry, accept, entryDescription |
| top-level / `com/carpet/rof/rules/mobAi/MobAiFilter.java` | `` |  | isEmpty, matches, matchesAny, allowedEntries, deniedEntries, Entry, ofType, ofTag, matches |
| top-level / `com/carpet/rof/rules/mobAi/MobAiSettings.java` | `` |  | enabled, validate, description |
| top-level / `com/carpet/rof/rules/mobAi/MobAIUtil.java` | `` |  | activityIndex, nextBCIndex, onActivityDataCreated, onBrainCreated |
| top-level / `com/carpet/rof/rules/oec/ClimbableTagCacheSettings.java` | `` |  |  |
| top-level / `com/carpet/rof/rules/oec/lithium/ClimbableBlockStateCache.java` | `` |  | epoch, invalidate |
| top-level / `com/carpet/rof/rules/oec/lithium/ClimbableStateCacheAccess.java` | `` |  |  |
| top-level / `com/carpet/rof/rules/oec/lithium/LithiumPushCollector.java` | `` |  | tryCollect |
| top-level / `com/carpet/rof/rules/oec/OecEntityAccess.java` | `` |  |  |
| top-level / `com/carpet/rof/rules/oec/OecMetrics.java` | `` |  | summary, reset |
| top-level / `com/carpet/rof/rules/oec/OecSectionAccess.java` | `` |  |  |
| top-level / `com/carpet/rof/rules/oec/OecSectionSpanCache.java` | `` |  | get, invalidateIfContains, build, isFinite |
| top-level / `com/carpet/rof/rules/oec/OecSectionStorageAccess.java` | `` |  |  |
| top-level / `com/carpet/rof/rules/oec/OecSettings.java` | `` |  | validate |
| top-level / `com/carpet/rof/rules/oec/OecStorageHolder.java` | `` |  |  |
| top-level / `com/carpet/rof/rules/oec/OecUtil.java` | `` |  | nextStamp, stamp, cell, packRange, rangeContains, isFinite, maybePushable, currentlyPushable, storageOf, registerNewCells, rebuild, fillSection, registerGrid, unregisterGrid, activeGrids, releaseAllGrids, neighbor |
| top-level / `com/carpet/rof/rules/oec/SectionEntityGrid.java` | `` |  | isFine, isValid, clear, add, localCell, cellEntities, cellMask, cellSize, release |
| top-level / `com/carpet/rof/rules/packerRules/PacketRulesSettings.java` | `` |  |  |
| top-level / `com/carpet/rof/rules/packerRules/TrackedEntityRecoveryAccessor.java` | `` |  |  |
| top-level / `com/carpet/rof/rules/piglinRules/PiglinBCWrapper.java` | `` |  | condition |
| top-level / `com/carpet/rof/rules/piglinRules/PiglinRulesSettings.java` | `` |  |  |
| top-level / `com/carpet/rof/rules/spawnStatistic/SpawnStateSimplifyAccess.java` | `` |  |  |
| top-level / `com/carpet/rof/rules/spawnStatistic/SpawnStatisticSimplifySettings.java` | `` |  | isSimplified |
| top-level / `com/carpet/rof/rules/spawnStatistic/SpawnStatisticSimplifyUtil.java` | `` |  | countMobs |
| top-level / `com/carpet/rof/rules/spawnStatistic/SpawnStatisticSimplifyValidator.java` | `` |  | validate, description |
| top-level / `com/carpet/rof/utils/AutoMixinAuditExecutor.java` | `` |  | isEnabled, run |
| top-level / `com/carpet/rof/utils/ChunkPosHelper.java` | `` |  | x, containing, z, unpack, pack, pack, pack |
| top-level / `com/carpet/rof/utils/CommandHelper.java` | `` |  | reused, predicate, setCommandRequirementNode, command, hasArgument, carpetRequire, getArgumentOrDefault, registerCommandList, setCommandRequirement, registerCommand, r, rCarpet, s, reused, arg, command |
| top-level / `com/carpet/rof/utils/NBTData.java` | `` |  |  |
| top-level / `com/carpet/rof/utils/ROFCarpetTranslations.java` | `` |  | getTranslationFromResourcePath |
| top-level / `com/carpet/rof/utils/ROFConfig.java` | `` |  | load, save, get, get, set, has, remove, snapshot, clear, toString |
| top-level / `com/carpet/rof/utils/ROFIO.java` | `` |  | isGzip, loadFromRegion, loadFromRegion, forEachExistingChunk, forEachExistingChunkParallel |
| top-level / `com/carpet/rof/utils/ROFTextTool.java` | `` |  | getWorldName, getStringToClip, text, textS, processDisplay |
| top-level / `com/carpet/rof/utils/ROFTool.java` | `` |  | isNetherWorld, getSavePath, getPlayerPath, fastHash, getChunkPos, toString_, toString_short, canLoadAi, rDEBUG, saveNBT2Data |
| top-level / `com/carpet/rof/utils/ROFWarp.java` | `` |  | getFromNbt, getGameMode, showText, suggestCommand, copyToClipboard, getPacketType, getBlockPosIt, getWorld_, getPos_ |
| top-level / `com/carpet/rof/utils/singleTaskWorker/ROFTask.java` | `` |  |  |
| top-level / `com/carpet/rof/utils/singleTaskWorker/SingleTaskWorker.java` | `` |  | get, start, addBuffer, addBuffer, removeBuffer, stop, close |
| top-level / `com/carpet/rof/utils/singleTaskWorker/SPSCRingBuffer.java` | `` |  | offer, poll, isEmpty |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
