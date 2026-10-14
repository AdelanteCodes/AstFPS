# ScalableLux

Review status: **Evidence inventory; behavioral review pending**

Project: [ScalableLux](https://modrinth.com/mod/scalablelux)
Selected artifact version: `0.3.0-alpha.0.6+26.3`
Published implementation source: https://github.com/RelativityMC/ScalableLux
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A Fabric mod based on Starlight that improves the performance of light updates in Minecraft.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `d51dcbe901452a1cb378139ca351009254e7ab0d`
- `sha512`: `ded5a939fb20ab81c1f33b147ca9b98050773dbb28dff16df939c7d567b626809522994ec8dbfb99e7f498dc6a4e62f25e141a87d18efb43f73fc5ad1569ccc9`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 79
Reconstructed Java files: 61

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "ca.spottedleaf.starlight.common.ScalableLuxEntrypoint"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3-rc.1"
}
```

**breaks**

```json
{
  "phosphor": "*"
}
```

**accessWidener**

```json
"scalablelux.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `ca/spottedleaf/starlight/common/blockstate/ExtendedAbstractBlockState.java` | `` |  |  |
| top-level / `ca/spottedleaf/starlight/common/chunk/ExtendedChunk.java` | `` |  |  |
| top-level / `ca/spottedleaf/starlight/common/config/Config.java` | `` |  | init, getInt, getBoolean, getBoolean0, parseBoolean |
| top-level / `ca/spottedleaf/starlight/common/integration/v0/ChunkSystemHooks.java` | `` |  | isTicketThreadSafe, isNonFullTicket, avoidLightCopy, addLightTicket, removeLightTicket |
| top-level / `ca/spottedleaf/starlight/common/light/BlockStarLightEngine.java` | `` |  | getEmptinessMap, setEmptinessMap, getNibblesOnChunk, setNibbles, canUseChunk, setNibbleNull, initNibble, checkBlock, calculateLightValue, propagateBlockChanges, getSources, lightChunk |
| top-level / `ca/spottedleaf/starlight/common/light/ClientStarLightLightingProvider.java` | `` |  |  |
| top-level / `ca/spottedleaf/starlight/common/light/SkyStarLightEngine.java` | `` |  | initNibble, setNibbleNull, initNibble, rewriteNibbleCacheForSkylight, checkNullSection, getLightLevelExtruded, getEmptinessMap, setEmptinessMap, getNibblesOnChunk, setNibbles, canUseChunk, checkChunkEdges, checkChunkEdges, checkBlock, calculateLightValue, propagateBlockChanges, lightChunk, processDelayedIncreases, processDelayedDecreases, tryPropagateSkylight |
| top-level / `ca/spottedleaf/starlight/common/light/StarLightEngine.java` | `` |  | setupEncodeOffset, setupCaches, getChunkInCache, setChunkInCache, getChunkSection, setChunkSectionInCache, setBlocksForChunkInCache, getNibbleFromCache, getNibblesForChunkFromCache, setNibbleInCache, setNibblesForChunkInCache, updateVisible, destroyCaches, getBlockState, getBlockState, getLightLevel, getLightLevel, setLightLevel, postLightUpdate, setLightLevel, getEmptinessMap, setEmptinessMapCache, getFilledEmptySaveState, getFilledEmptySaveState, getFilledEmptyLight, getFilledEmptyLight, blocksChangedInChunk, checkChunkEdge, checkChunkEdges, checkChunkEdges, propagateNeighbourLevels, getEmptySectionsForChunk, forceHandleEmptySectionChanges, handleEmptySectionChanges, handleEmptySectionChanges, checkChunkEdges, checkChunkEdges, light, relightChunks, resizeIncreaseQueue, resizeDecreaseQueue, appendToIncreaseQueue, appendToDecreaseQueue, performLightIncrease, performLightDecrease, getOpposite |
| top-level / `ca/spottedleaf/starlight/common/light/StarLightInterface.java` | `` |  | checkBlock, propagateLightSources, hasLightWork, runLightUpdates, setLightEnabled, getDataLayerData, getLightValue, updateSectionStatus, checkBlock, propagateLightSources, hasLightWork, runLightUpdates, setLightEnabled, getDataLayerData, getLightValue, updateSectionStatus, hasSkyLight, hasBlockLight, getSkyLightValue, getBlockLightValue, getRawBrightness, getSkyReader, getBlockReader, hasSectionSkyLight, hasSectionBlockLight, isClientSide, getAnyChunkNow, hasUpdates, getWorld, getLightAccess, getSkyLightEngine, releaseSkyLightEngine, getBlockLightEngine, releaseBlockLightEngine, blockChange, sectionChange, forceLoadInChunk, loadInChunk, lightChunk, relightChunks, checkChunkEdges, checkSkyEdges, checkBlockEdges, checkSkyEdges, checkBlockEdges, scheduleChunkLight, syncFuture, propagateChanges, needsScheduling, schedulePropagation0, handleUpdateInternal, isEmpty, queueBlockChange, queueSectionChange, queueChunkLighting, queueChunkSkylightEdgeCheck, queueChunkBlocklightEdgeCheck, getChunkSyncFuture, removeChunk, removeFirstTask, rehash, isEmpty, queueBlockChange, queueSectionChange, queueChunkLighting, queueChunkSkylightEdgeCheck, queueChunkBlocklightEdgeCheck, getChunkSyncFuture, takeTask, enqueueImpl, getChunkTasksOrNull, getOrCreateChunkTasks |
| top-level / `ca/spottedleaf/starlight/common/light/StarLightLightingProvider.java` | `` |  |  |
| top-level / `ca/spottedleaf/starlight/common/light/SWMRNibbleArray.java` | `` |  | allocateBytes, freeBytes, fromVanilla, toString, getSaveState, getSaveState, isAllZero, extrudeLower, setFull, setZero, setNonNull, setNull, setUninitialised, setHidden, isDirty, isNullNibbleUpdating, isNullNibbleVisible, isUninitialisedUpdating, isUninitialisedVisible, isInitialisedUpdating, isInitialisedVisible, isHiddenUpdating, isHiddenVisible, swapUpdatingAndMarkDirty, updateVisible, toVanillaNibble, getUpdating, getUpdating, getVisible, getVisible, set, set |
| top-level / `ca/spottedleaf/starlight/common/light/vanillainterface/BaseLevelLightEngineVanillaInterface.java` | `` |  | checkBlock, hasLightWork, runLightUpdates, updateSectionStatus, setLightEnabled, propagateLightSources, getLayerListener, getDebugData, getDebugSectionType, queueSectionData, retainData, getRawBrightness, lightOnInColumn, getLightSectionCount, getMinLightSection, getMaxLightSection, updateSectionStatus, scalablelux$getLightEngine, scalablelux$getLightingEnabledChunks, scalablelux$getBlockLightMap, scalablelux$getSkyLightMap, scalablelux$clientUpdateLight, scalablelux$clientRemoveLightData, scalablelux$clientChunkLoad |
| top-level / `ca/spottedleaf/starlight/common/light/vanillainterface/CommonLightEngineUtils.java` | `` |  | checkBlock, hasLightWork, runLightUpdates, updateSectionStatus, setLightEnabled, propagateLightSources, getLayerListener, getDebugData, getDebugSectionType, queueSectionData, retainData, getRawBrightness, lightOnInColumn |
| top-level / `ca/spottedleaf/starlight/common/light/vanillainterface/ThreadedLevelLightEngineVanillaInterface.java` | `` |  | scalablelux$queueTaskForSection, checkBlock, hasLightWork, runLightUpdates, updateSectionStatus, setLightEnabled, propagateLightSources, getLayerListener, getDebugData, getDebugSectionType, queueSectionData, retainData, getRawBrightness, lightOnInColumn, getLightSectionCount, getMinLightSection, getMaxLightSection, updateSectionStatus, scalablelux$getLightEngine, scalablelux$getLightingEnabledChunks, scalablelux$getBlockLightMap, scalablelux$getSkyLightMap, close, updateChunkStatus, initializeLight, lightChunk, tryScheduleUpdate, waitForPendingTasks |
| top-level / `ca/spottedleaf/starlight/common/ScalableLuxEntrypoint.java` | `` |  | onInitialize |
| top-level / `ca/spottedleaf/starlight/common/thread/GlobalExecutors.java` | `` |  |  |
| top-level / `ca/spottedleaf/starlight/common/thread/LockTokenImpl.java` | `` |  |  |
| top-level / `ca/spottedleaf/starlight/common/thread/SchedulingUtil.java` | `` |  | scheduleTask, isExternallyManaged |
| top-level / `ca/spottedleaf/starlight/common/thread/SimpleTask.java` | `` |  | run, propagateException, lockTokens |
| top-level / `ca/spottedleaf/starlight/common/util/CoordinateUtils.java` | `` |  | getNeighbourMappedIndex, getChunkKey, getChunkKey, getChunkKey, getChunkKey, getChunkKey, getChunkX, getChunkZ, getChunkCoordinate, getChunkSectionKey, getChunkSectionKey, getChunkSectionKey, getChunkSectionKey, getChunkSectionKey, getChunkSectionX, getChunkSectionY, getChunkSectionZ, getBlockCoordinate, getBlockKey, getBlockKey, getBlockKey |
| top-level / `ca/spottedleaf/starlight/common/util/IntegerUtil.java` | `` |  | ceilLog2, ceilLog2, floorLog2, floorLog2, roundCeilLog2, roundCeilLog2, roundFloorLog2, roundFloorLog2, isPowerOfTwo, isPowerOfTwo, getTrailingBit, getTrailingBit, trailingZeros, trailingZeros, getDivisorMultiple, getDivisorShift, getDivisorNumbers, branchlessAbs, branchlessAbs, hash0, hash1, hash2, hash3, hash1, hash2, hash3 |
| top-level / `ca/spottedleaf/starlight/common/util/SaveUtil.java` | `` |  | prepareSaveVanillaLightHook, prepareSaveVanillaLightHookReal, loadVanillaLightHook, loadVanillaLightHookReal |
| top-level / `ca/spottedleaf/starlight/common/util/WorldUtil.java` | `` |  | getMaxSection, getMinSection, getMaxLightSection, getMinLightSection, getTotalSections, getTotalLightSections, getMinBlockY, getMaxBlockY |
| top-level / `ca/spottedleaf/starlight/common/world/ExtendedSerializableChunkData.java` | `` |  |  |
| top-level / `ca/spottedleaf/starlight/common/world/ExtendedWorld.java` | `` |  |  |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/executor/DynamicPriorityTaskQueue.java` | `` |  | enqueue, changePriority, dequeue, contains, remove, size |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/executor/ExecutorManager.java` | `` |  | callListeners, shutdown, schedule, schedule0, schedule, executor, changePriority |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/executor/LockToken.java` | `` |  |  |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/executor/SimpleTask.java` | `` |  | run, propagateException, lockTokens |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/executor/Task.java` | `` |  |  |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/executor/test/TestThroughput.java` | `` |  | main, run |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/executor/WorkerThread.java` | `` |  | run, pollTasks, shutdown |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/scheduler/BusyRefCounter.java` | `` |  | isBusy, addListener, addListenerOnce, incrementRefCount, decrementRefCount |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/scheduler/Cancellable.java` | `` |  | setup, complete, cancel, isCancelled, isCompleted |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/scheduler/ExceptionHandlingAction.java` | `` |  |  |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/scheduler/ItemHolder.java` | `` |  | rehash, createFutures, getTargetStatus, getStatus, isBusy, changingStatusTo, addTicket, removeTicket, swapTicket, submitOp, subscribeOp, finishAction, submitAction, tryCancelAction, getOpFuture, submitOpListener, consolidateMarkDirty, getCriticalSectionExecutor, getCriticalSectionScheduler, executeCriticalSectionAndBusy, markDirty, tryMarkDirty, markDirty0, setStatus, setDependencies, getDependencies, getKey, getFutureForStatus, getFutureForStatus0, getItem, getUserData, getFlags, setFlag, clearFlag, addDependencyTicket, removeDependencyTicket, isDependencyDirty, holdsDependency, scheduleFlushDependencyCache, flushDependencyCache0, assertOpen, isOpen |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/scheduler/ItemStatus.java` | `` |  |  |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/scheduler/ItemTicket.java` | `` |  | getSource, getType, consumeCallback, equals, hashCode0, hashCode, getDescription |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/scheduler/KeyStatusPair.java` | `` |  | key, status, equals, hashCode, toString |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/scheduler/ObjectFactory.java` | `` |  | createConcurrentHashMap, createConcurrentSet, newMPMCQueue, newMPSCQueue |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/scheduler/StatusAdvancingScheduler.java` | `` |  | rehash, getSchedulerBackedByBackgroundExecutor, handleTransactionException, handleUnrecoverableException, onItemConstruct, onItemCreation, onItemRemoval, onItemUpgrade, onItemDowngrade, tickHandleBusy0, downgradeStatus0, advanceStatus0, rerequestDependencies, getHolder, getOrCreateHolder, itemCount, wakeUp, getDependencyFuture0, addTicket, addTicket, addTicket, addTicket0, createHolder0, removeTicket, removeTicket, removeTicket0, swapTicket, getNextStatus, tryHandleTransactionException, clearDependencies0, releaseDependencies |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/scheduler/TicketSet.java` | `` |  | checkAdd, addUnchecked, checkRemove, removeUnchecked, updateTargetStatus, getTargetStatus, getTicketsForStatus, computeTargetStatusSlow |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/structs/OneTaskAtATimeExecutor.java` | `` |  | canRun, run0, trySchedule, needsWakeup, execute |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/structs/SimpleObjectPool.java` | `` |  | alloc, release |
| top-level / `ca/spottedleaf/starlight/interndep/flowsched/util/Assertions.java` | `` |  | assertTrue, assertTrue, assertTrue |
| top-level / `ca/spottedleaf/starlight/mixin/client/multiplayer/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class}, priority=1001)` | WrapOperation:4, Inject:1 | starlightCallUpdateImmediately, loadLightDataHook, unloadLightDataHook, postChunkLoadHookRedirect, postChunkLoadHook |
| top-level / `ca/spottedleaf/starlight/mixin/client/world/ClientLevelMixin.java` | `value={ClientLevel.class})` |  | scalablelux$getChunkAtImmediately, scalablelux$getAnyChunkImmediately |
| top-level / `ca/spottedleaf/starlight/mixin/common/blockstate/BlockStateBaseMixin.java` | `value={BlockBehaviour.BlockStateBase.class})` | Inject:1 | initLightAccessState, scalablelux$isConditionallyFullOpaque |
| top-level / `ca/spottedleaf/starlight/mixin/common/chunk/ChunkAccessMixin.java` | `value={ChunkAccess.class})` | Inject:1, WrapWithCondition:1 | scalablelux$getBlockNibbles, scalablelux$setBlockNibbles, scalablelux$getSkyNibbles, scalablelux$setSkyNibbles, scalablelux$getSkyEmptinessMap, scalablelux$setSkyEmptinessMap, scalablelux$getBlockEmptinessMap, scalablelux$setBlockEmptinessMap, nullSources, skipInit, scalablelux$usingStarlight |
| top-level / `ca/spottedleaf/starlight/mixin/common/chunk/EmptyLevelChunkMixin.java` | `value={EmptyLevelChunk.class})` |  | scalablelux$getBlockNibbles, scalablelux$setBlockNibbles, scalablelux$getSkyNibbles, scalablelux$setSkyNibbles, scalablelux$getSkyEmptinessMap, scalablelux$setSkyEmptinessMap, scalablelux$getBlockEmptinessMap, scalablelux$setBlockEmptinessMap, scalablelux$usingStarlight |
| top-level / `ca/spottedleaf/starlight/mixin/common/chunk/ImposterProtoChunkMixin.java` | `value={ImposterProtoChunk.class})` |  | scalablelux$getBlockNibbles, scalablelux$setBlockNibbles, scalablelux$getSkyNibbles, scalablelux$setSkyNibbles, scalablelux$getSkyEmptinessMap, scalablelux$setSkyEmptinessMap, scalablelux$getBlockEmptinessMap, scalablelux$setBlockEmptinessMap |
| top-level / `ca/spottedleaf/starlight/mixin/common/chunk/LevelChunkMixin.java` | `value={LevelChunk.class})` | Inject:1, Redirect:1 | onTransitionToFull, skipLightSources |
| top-level / `ca/spottedleaf/starlight/mixin/common/chunk/ProtoChunkMixin.java` | `value={ProtoChunk.class})` | Redirect:1 | skipLightSources |
| top-level / `ca/spottedleaf/starlight/mixin/common/lightengine/ChunkMapMixin.java` | `value={ChunkMap.class})` | Redirect:1 | redirectLightEngine |
| top-level / `ca/spottedleaf/starlight/mixin/common/lightengine/ClientChunkCacheMixin.java` | `value={ClientChunkCache.class})` | Redirect:1 | redirectLightEngine |
| top-level / `ca/spottedleaf/starlight/mixin/common/lightengine/LevelLightEngineMixin.java` | `value={LevelLightEngine.class})` | Inject:1 | construct |
| top-level / `ca/spottedleaf/starlight/mixin/common/lightengine/ThreadedLevelLightEngineMixin.java` | `value={ThreadedLevelLightEngine.class})` | WrapOperation:2 | redirectUpdate, redirectHasUpdates |
| top-level / `ca/spottedleaf/starlight/mixin/common/world/LevelMixin.java` | `value={Level.class})` |  | scalablelux$getChunkAtImmediately, scalablelux$getAnyChunkImmediately |
| top-level / `ca/spottedleaf/starlight/mixin/common/world/SerializableChunkDataMixin.java` | `value={SerializableChunkData.class})` | Inject:2, WrapOperation:1 | scalablelux$setLightCorrect, prepareSaveLightHook, loadLightHook, noopVanillaLightRead |
| top-level / `ca/spottedleaf/starlight/mixin/common/world/ServerWorldMixin.java` | `value={ServerLevel.class})` |  | scalablelux$getChunkAtImmediately, scalablelux$getAnyChunkImmediately |
| top-level / `ca/spottedleaf/starlight/mixin/common/world/WorldGenRegionMixin.java` | `value={WorldGenRegion.class})` |  | getBrightness, getRawBrightness |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
