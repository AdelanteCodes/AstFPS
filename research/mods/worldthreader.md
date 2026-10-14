# Worldthreader

Review status: **Evidence inventory; behavioral review pending**

Project: [Worldthreader](https://modrinth.com/mod/worldthreader)
Selected artifact version: `mc26.3-3.2.0-fabric`
Published implementation source: https://github.com/2No2Name/worldthreader
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Worldthreader speeds up servers by safely running each dimension on a separate thread.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `35efb40e3b1d3e6f5840f3fd5f856ed113820ac55c9a0fa2ec4a462f1257515d0e8e4709ace1698f31a7a42c5e0a07af5ecd40789f4be0a1928a9841d30259ae`
- `sha1`: `75350c22d092fb9f4f1ea2eb3cc7b107745ba835`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 97
Reconstructed Java files: 96

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "no2.worldthreader.WorldThreaderMod"
  ]
}
```

**depends**

```json
{
  "minecraft": [
    "26.3.x"
  ]
}
```

**accessWidener**

```json
"worldthreader.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `no2/worldthreader/common/dimension_change/DimensionChangeHelper.java` | `` |  | isDummy, expectDummy, shouldConvertSelfToTeleportedEntityInfo, getNonPassengerDummyTeleportTarget, nonPassengerArriveInWorld, arriveIntoWorld, restoreEntityInWorld |
| top-level / `no2/worldthreader/common/dimension_change/TeleportedEntityInfo.java` | `` |  | TeleportedEntityInfo |
| top-level / `no2/worldthreader/common/interdimensional/InterdimensionalEntityInfo.java` | `` |  | InterdimensionalEntityInfo |
| top-level / `no2/worldthreader/common/mixin_support/interfaces/BeforeThreadingInitialization.java` | `` |  |  |
| top-level / `no2/worldthreader/common/mixin_support/interfaces/EntityExtended.java` | `` |  |  |
| top-level / `no2/worldthreader/common/mixin_support/interfaces/EntityLookupExtended.java` | `` |  |  |
| top-level / `no2/worldthreader/common/mixin_support/interfaces/EntityReferenceExtended.java` | `` |  |  |
| top-level / `no2/worldthreader/common/mixin_support/interfaces/MinecraftServerExtended.java` | `` |  |  |
| top-level / `no2/worldthreader/common/mixin_support/interfaces/ServerPlayerInstanceSwapper.java` | `` |  |  |
| top-level / `no2/worldthreader/common/mixin_support/interfaces/ServerWorldExtended.java` | `` |  |  |
| top-level / `no2/worldthreader/common/mixin_support/interfaces/ServerWorldWithWirelessRedstoneFix.java` | `` |  |  |
| top-level / `no2/worldthreader/common/scoreboard/AtomicArithmeticScore.java` | `` |  |  |
| top-level / `no2/worldthreader/common/scoreboard/MutablePlayerTeam.java` | `` |  |  |
| top-level / `no2/worldthreader/common/scoreboard/ThreadsafeScoreboard.java` | `` |  |  |
| top-level / `no2/worldthreader/common/ServerWorldTicking.java` | `` |  | isMainWorld, runWorldThread, tickThreaded, delegateCrash, finishTeleportsToWorld, recoverFailedTeleports |
| top-level / `no2/worldthreader/common/thread/ThreadHelper.java` | `` |  | swapOnMultithreadTickStart, swapOnMultithreadTickEnd, setWorldThreadName |
| top-level / `no2/worldthreader/common/thread/ThreadLocals.java` | `` |  |  |
| top-level / `no2/worldthreader/common/thread/ThreadOwnedObject.java` | `` |  |  |
| top-level / `no2/worldthreader/common/thread/WorldThreadingManager.java` | `` |  | numberOfLevels, ensureExclusiveScoreboardAccess, crashIfNoExclusiveScoreboardAccess, hasExclusiveScoreboardAccess, isPlacingReceivedTeleports, isRecoveringTeleports, get, isMultiThreadedPhase, setMultiThreadedPhase, isWorldThread, isWorldThreadOf, isWorldThreadOf, isAccessibleForOtherThread, hasToAcquireExclusiveAccessBeforeAccessing, isWrongThreadForWorld, isMultithreadingAndCorrectThreadForWorld, tickBarrier, withinTickBarrier, shouldKeepTickingThreaded, terminate, threadingSafePoint, releaseLevel, reacquireLevel, barrier, waitForExclusiveWorldAccess, setOwnershipOfAllThreadOwnedObjects, resetOwnershipOfAllThreadOwnedObjects, tryGiveAwayExclusiveWorldAccess, handleCrash, throwCrashIfPresent, updateThreadsafePlayerInfos, updateThreadsafeUUIDInfos, getUUIDLevel, wasUUIDAPlayer, wasPlayerAlive, wasPlayerDead, wasPlayerWonGame, getLastPlayerGameMode, PlayerInfo |
| top-level / `no2/worldthreader/common/tuples/Pair.java` | `` |  |  |
| top-level / `no2/worldthreader/common/tuples/Triplet.java` | `` |  |  |
| top-level / `no2/worldthreader/common/WorldThreaderTickPhase.java` | `` |  |  |
| top-level / `no2/worldthreader/init/ModGameRules.java` | `` |  | registerGameRules, syncDebugFlag |
| top-level / `no2/worldthreader/mixin/core/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Redirect:1, Inject:1 | worldthreader$onLevelAddedOrRemoved, replaceWorldThreadingManager, multiThreadWorldLoop, worldthreader$isTickMultithreaded, shutdownThreading, worldthreader$getThreadingManager, worldthreader$shouldKeepTickingThreaded |
| top-level / `no2/worldthreader/mixin/core/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:2, Redirect:1 | threadSafetyForPretickTimeWeatherAndSleeping, getScheduledEventsUnsafe, threadSafety2ForPretickTimeWeatherAndSleeping |
| top-level / `no2/worldthreader/mixin/debug/ServerChunkCacheMixin.java` | `value={ServerChunkCache.class}, priority=1010)` | WrapMethod:2 | debugThreadSafety0, debugThreadSafety1, debugThreadSafety |
| top-level / `no2/worldthreader/mixin/dimension_change/arrival/EntityMixin.java` | `value={Entity.class})` | WrapOperation:7, Inject:1 | getPassengerOrEmpty, getSize, ejectPassengers, placePassengers, restoreFromNbt0, restoreFromNbt1, removeOldEntity, getPositionMoveRelation |
| top-level / `no2/worldthreader/mixin/dimension_change/arrival/ItemEntityMixin.java` | `value={ItemEntity.class})` |  | worldthreader$onArrivedInServerWorld |
| top-level / `no2/worldthreader/mixin/dimension_change/arrival/NetherPortalBlockMixin.java` | `value={NetherPortalBlock.class})` | Redirect:2, ModifyArg:3 | avoidAccessingWrongWorld, restorePortalAxis, avoidAccessingWrongWorld2, restorePortalAxis2, restoreInPortalPos |
| top-level / `no2/worldthreader/mixin/dimension_change/arrival/PrimedTntMixin.java` | `value={PrimedTnt.class})` |  | worldthreader$onArrivedInServerWorld |
| top-level / `no2/worldthreader/mixin/dimension_change/arrival/ServerPlayerMixin.java` | `value={ServerPlayer.class})` | ModifyExpressionValue:2, WrapOperation:1, WrapWithCondition:3 | isRemovedAndNotArrivalPhase, isMissingRespawnBlockAndNotArrivalPhase, createCommonSpawnInfoIfDeparture, sendIfDeparture, sendPlayerPermissionLevelIfDeparture, removePlayerImmediatelyIfDeparture |
| top-level / `no2/worldthreader/mixin/dimension_change/arrival/ThrownEnderpearlMixin.java` | `value={ThrownEnderpearl.class})` |  | worldthreader$onArrivedInServerWorld |
| top-level / `no2/worldthreader/mixin/dimension_change/departure/EntityMixin.java` | `value={Entity.class})` | WrapOperation:2, Inject:1 | getDummyPassengerTransition, convertPassengersToTeleportedEntityInfos, convertSelfToTeleportedEntityInfo, restoreFromToNBT |
| top-level / `no2/worldthreader/mixin/dimension_change/departure/FallingBlockEntityMixin.java` | `value={FallingBlockEntity.class})` | Inject:1 | worldthreader$allowFallingBlockDuplication |
| top-level / `no2/worldthreader/mixin/dimension_change/departure/position/NetherPortalBlockMixin.java` | `value={NetherPortalBlock.class})` | Inject:1 | storeNetherPortalAxisAndRelativePosition |
| top-level / `no2/worldthreader/mixin/dimension_change/departure/ServerPlayerMixin.java` | `value={ServerPlayer.class})` | Inject:2 | check, convertSelfToTeleportedEntityInfo |
| top-level / `no2/worldthreader/mixin/dimension_change/departure/triggers/ender_pearl/ProjectileMixin.java` | `value={Projectile.class})` | Redirect:1, WrapOperation:1 | setCachedOwnerWrapped, getOwnerInSameDimension |
| top-level / `no2/worldthreader/mixin/dimension_change/departure/triggers/ender_pearl/ServerPlayerMixin.java` | `value={ServerPlayer.class})` | WrapOperation:1 | handleOffthread |
| top-level / `no2/worldthreader/mixin/dimension_change/departure/triggers/ender_pearl/ThrownEnderpearlMixin.java` | `value={ThrownEnderpearl.class})` | Redirect:1, WrapOperation:5 | setCachedOwnerWrapped, avoidGettingOwner, handleNullPlayer, handleNullPlayer2, handleNullPlayer2, getServerLevel, registerAndUpdate |
| top-level / `no2/worldthreader/mixin/dimension_change/departure/triggers/EndPortalBlockMixin.java` | `value={EndPortalBlock.class})` | Redirect:1, Inject:1 | getWorldWithoutExclusiveAccess, handleOffthreadTeleport |
| top-level / `no2/worldthreader/mixin/dimension_change/departure/triggers/NetherPortalBlockMixin.java` | `value={NetherPortalBlock.class})` | Redirect:1, Inject:1 | getWorldWithoutExclusiveAccess, handleOffthreadTeleport |
| top-level / `no2/worldthreader/mixin/dimension_change/player/instance_swap/PlayerListMixin.java` | `value={PlayerList.class})` | WrapOperation:10, WrapWithCondition:6, Inject:1 | worldthreader$swapRemovedPlayerWithNewCopy, initIsNotSwapAndFindRespawnPositionAndUseSpawnBlockIfNot, isNotSwap, newLevel, missingRespawnBlockIfNotSwap, positionIfNotSwap, rotationIfNotSwap, isNotSwap, getLevelDataIfNotSwap, createCommonSpawnInfoIfNotSwap, connectionTeleportIfNotSwap, getDifficultyIfNotSwap, isDifficultyLockedIfNotSwap, ifNotSwap, ifNotSwap, ifNotSwap, ifNotSwap, cancelIfSwap |
| top-level / `no2/worldthreader/mixin/dimension_change/player/instance_swap/ServerGamePacketListenerImplMixin.java` | `value={ServerGamePacketListenerImpl.class})` |  | worldthreader$swapRemovedPlayerWithNewCopy |
| top-level / `no2/worldthreader/mixin/dimension_change/player/instance_swap/ServerPlayerMixin.java` | `value={ServerPlayer.class})` | Redirect:1, Inject:1, ModifyReceiver:10, ModifyArg:5, ModifyReturnValue:1 | getDimensionOrRecover, swapPlayerWithNewInstance, useNewPlayer, useNewPlayer2, useNewPlayer3, useNewPlayer4, useNewPlayer5, useNewPlayer6, useNewPlayer7, useNewPlayer8, useNewPlayer9, useNewPlayer10, useNewPlayer11, useNewPlayer12, useNewPlayer13, useNewPlayer14, useNewPlayer15, useNewPlayer16 |
| top-level / `no2/worldthreader/mixin/dimension_change/recover_failure/EntityMixin.java` | `value={Entity.class})` |  | worldthreader$restoreEntity |
| top-level / `no2/worldthreader/mixin/dimension_change/recover_failure/LivingEntityMixin.java` | `value={LivingEntity.class})` |  | worldthreader$restoreEntity, worldthreader$restoreEquipment |
| top-level / `no2/worldthreader/mixin/dimension_change/recover_failure/ServerPlayerMixin.java` | `value={ServerPlayer.class})` |  | worldthreader$restoreEntity |
| top-level / `no2/worldthreader/mixin/dimension_change/ServerLevelMixin.java` | `value={ServerLevel.class})` |  | worldthreader$receiveTeleportedEntity, worldthreader$finishReceivingTeleportedEntities, worldthreader$receiveFailedTeleport, worldthreader$recoverFailedTeleports, worldthreader$arrivingEntityInfo, worldthreader$setArrivingEntityInfo, worldthreader$removeDepartingEntityInfo, worldthreader$putDepartingPassengerEntityInfo, worldthreader$getTickPhase, worldthreader$setTickPhase |
| top-level / `no2/worldthreader/mixin/entity_id_wireless_redstone_fix/ServerLevelMixin.java` | `value={ServerLevel.class})` | Redirect:1 | getNextEntityIDThreaded |
| top-level / `no2/worldthreader/mixin/entity_id_wireless_redstone_fix/ServerWorldMixin.java` | `value={ServerLevel.class})` |  | worldthreader$getNextEntityId |
| top-level / `no2/worldthreader/mixin/exclusive_world_access/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Inject:4 | worldthreader$getLevelUnsynchronized, acquireSingleThreadedWorldAccess, avoidParallelWorldAccess1, avoidParallelWorldAccess2, avoidParallelWorldAccess3, avoidParallelServerDataAccess |
| top-level / `no2/worldthreader/mixin/fixes/anger/NeutralMobMixin.java` | `value={NeutralMob.class})` | WrapOperation:4 | isTargetCreativeOrSpectatorPlayerOrIsPeaceful, isCreative, isSpectator |
| top-level / `no2/worldthreader/mixin/fixes/entity_reference/EntityLookupMixin.java` | `value={EntityLookup.class})` |  | worldthreader$copyUUIDSet |
| top-level / `no2/worldthreader/mixin/fixes/entity_reference/EntityReferenceMixin.java` | `value={EntityReference.class})` | ModifyArg:1 | getEntityInAnyDimension |
| top-level / `no2/worldthreader/mixin/fixes/entity_reference/PersistentEntitySectionManagerAccessor.java` | `value={PersistentEntitySectionManager.class})` | Accessor:1 |  |
| top-level / `no2/worldthreader/mixin/fixes/entity_reference/ServerLevelAccessor.java` | `value={ServerLevel.class})` | Accessor:1 |  |
| top-level / `no2/worldthreader/mixin/fixes/last_hurt_by_mob/LivingEntityMixin.java` | `value={LivingEntity.class})` | Redirect:1, ModifyReturnValue:1 | updateLastHurtByMobAndGetNull, getAliveLastHurtByMob |
| top-level / `no2/worldthreader/mixin/fixes/leash/LeashableMixin.java` | `value={Leashable.class})` | Inject:1, Redirect:1, ModifyConstant:1 | handleTeleportedPlayer, getThreadedIsAlive, skipDestroyingLeashIfTeleportedPlayer |
| top-level / `no2/worldthreader/mixin/safepoints/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:4 | safePointAtProfilerPush, safePointAtProfilerPopPush, safePointAtProfilerPop, safePointBeforeEntityTick, safePoint |
| top-level / `no2/worldthreader/mixin/thread_ownership/ServerChunkCacheMixin.java` | `value={ServerChunkCache.class})` |  | worldthreader$getOwningThread, worldthreader$setOwningThread |
| top-level / `no2/worldthreader/mixin/thread_ownership/WorldMixin.java` | `value={Level.class})` |  | worldthreader$getOwningThread, worldthreader$setOwningThread |
| top-level / `no2/worldthreader/mixin/threading_compatibility/block_behavior/OptionalDispenseItemBehaviorMixin.java` | `value={OptionalDispenseItemBehavior.class})` | Overwrite:2 | isSuccess, setSuccess |
| top-level / `no2/worldthreader/mixin/threading_compatibility/block_behavior/patterns/CarvedPumpkinBlockMixin.java` | `value={CarvedPumpkinBlock.class})` |  | worldthreader$initBeforeThreading |
| top-level / `no2/worldthreader/mixin/threading_compatibility/block_behavior/patterns/EndPortalFrameBlockMixin.java` | `value={EndPortalFrameBlock.class})` |  | worldthreader$initBeforeThreading |
| top-level / `no2/worldthreader/mixin/threading_compatibility/block_behavior/patterns/WitherSkullBlockMixin.java` | `value={WitherSkullBlock.class})` |  | worldthreader$initBeforeThreading |
| top-level / `no2/worldthreader/mixin/threading_compatibility/block_behavior/RedstoneWireBlockMixin.java` | `value={RedstoneWireBlock.class})` | Redirect:2, ModifyExpressionValue:2 | getReceivedRedstonePowerBefore, shouldSignalSafe, shouldSignalSafe1, shouldSignalSafe2 |
| top-level / `no2/worldthreader/mixin/threading_compatibility/commands/WeatherCommandMixin.java` | `value={WeatherCommand.class})` | Inject:1 | ensureSafe |
| top-level / `no2/worldthreader/mixin/threading_compatibility/commands/WhitelistCommandMixin.java` | `value={WhitelistCommand.class})` | Inject:2 | ensureSafe, ensureSafe |
| top-level / `no2/worldthreader/mixin/threading_compatibility/commands/WorldBorderCommandMixin.java` | `value={WorldBorderCommand.class})` | Inject:4 | ensureSafe, ensureSafe, ensureSafe, ensureSafe |
| top-level / `no2/worldthreader/mixin/threading_compatibility/EntityReferenceMixin.java` | `value={EntityReference.class})` | Inject:1 | checkCrossDimensionAccess, worldthreader$isEntityInSameDimension, worldthreader$getEntitySameDimension |
| top-level / `no2/worldthreader/mixin/threading_compatibility/EntitySelectorMixin.java` | `value={EntitySelector.class})` | Inject:1 | ensureSafe |
| top-level / `no2/worldthreader/mixin/threading_compatibility/FishingRodItemMixin.java` | `value={FishingRodItem.class})` | WrapOperation:1 | threadSafeFishingRodRetrieve |
| top-level / `no2/worldthreader/mixin/threading_compatibility/fixes/dedicated_server_console/DedicatedServer$ConsoleHandlerThreadMixin.java` | `targets={"net.minecraft.server.dedicated.DedicatedServer$1"})` | Redirect:1 | getNull |
| top-level / `no2/worldthreader/mixin/threading_compatibility/fixes/dedicated_server_console/DedicatedServerMixin.java` | `value={DedicatedServer.class})` | Redirect:1 | getCommandSourceStack |
| top-level / `no2/worldthreader/mixin/threading_compatibility/fixes/poi/ServerLevelMixin.java` | `value={ServerLevel.class})` | WrapOperation:1 | useWorldThread |
| top-level / `no2/worldthreader/mixin/threading_compatibility/GameruleCommandMixin.java` | `value={GameRuleCommand.class})` | Inject:1 | getExclusiveGameruleAccess |
| top-level / `no2/worldthreader/mixin/threading_compatibility/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Inject:7 | ensureSafe, ensureSafe1, ensureSafe1, ensureSafe2, ensureSafe2, ensureSafe2, ensureSafety, worldthreader$getScheduledEventsUnsafe |
| top-level / `no2/worldthreader/mixin/threading_compatibility/PlayerListMixin.java` | `value={PlayerList.class})` | Inject:3 | ensureSafety, ensureSafety, ensureSafety |
| top-level / `no2/worldthreader/mixin/threading_compatibility/RedstoneTorchBlockMixin.java` | `value={RedstoneTorchBlock.class})` |  | worldthreader$initBeforeThreading |
| top-level / `no2/worldthreader/mixin/threading_compatibility/SensorMixin.java` | `value={Sensor.class})` | Redirect:6 | updateThreadLocalTargetConditions, updateThreadLocalTargetConditionsIgnoreInvisibilityTesting, updateThreadLocalAttackTargetConditions, updateThreadLocalAttackTargetConditionsIgnoreInvisibilityTesting, updateThreadLocalAttackTargetConditionsIgnoreLineOfSight, updateThreadLocalAttackTargetConditionsIgnoreInvisibilityAndLineOfSight |
| top-level / `no2/worldthreader/mixin/threading_compatibility/ServerPlayerMixin.java` | `value={ServerPlayer.class})` | Inject:1 | serializeExecution |
| top-level / `no2/worldthreader/mixin/threading_compatibility/ServerTickRateManagerMixin.java` | `value={ServerTickRateManager.class})` | Inject:4 | ensureSafe, ensureSafe, ensureSafe, ensureSafe |
| top-level / `no2/worldthreader/mixin/threadsafe_scoreboard/atomic_arithmetic/OperationArgument$SimpleOperationMixin.java` | `targets={"net/minecraft/commands/arguments/OperationArgument$SimpleOperation"})` | Overwrite:1 |  |
| top-level / `no2/worldthreader/mixin/threadsafe_scoreboard/atomic_arithmetic/Scoreboard$ScoreAccessMixin.java` | `targets={"net/minecraft/world/scores/Scoreboard$1"})` |  | add, worldthreader$addToValueAndGet, worldthreader$compareExchangeValue, beforeModify, afterModify |
| top-level / `no2/worldthreader/mixin/threadsafe_scoreboard/ObjectiveMixin.java` | `value={Objective.class})` | Inject:1 | ensureSafe, ensureSafe1 |
| top-level / `no2/worldthreader/mixin/threadsafe_scoreboard/PlayerScoresMixin.java` | `value={PlayerScores.class})` | Redirect:6, ModifyArg:1 | getThreadSafe, removeThreadSafe, putThreadSafe, isEmptyThreadsafe, useThreadsafeMap, useThreadsafeMap, useThreadsafeMap |
| top-level / `no2/worldthreader/mixin/threadsafe_scoreboard/ScoreboardCommandMixin.java` | `value={ScoreboardCommand.class})` | Redirect:2 | score, score |
| top-level / `no2/worldthreader/mixin/threadsafe_scoreboard/ScoreboardMixin.java` | `value={Scoreboard.class})` | Inject:3, Overwrite:2 | createThreadsafeCollections, ensureSafe, ensureSafe, getObjectives, getObjectiveNames |
| top-level / `no2/worldthreader/mixin/threadsafe_scoreboard/ScoreboardSaveDataMixin.java` | `value={ScoreboardSaveData.class})` |  | setDirty, isDirty |
| top-level / `no2/worldthreader/mixin/threadsafe_scoreboard/ScoreMixin.java` | `value={Score.class})` | Inject:1, Overwrite:8 | init, worldthreader$addToValueAndGet, worldthreader$compareExchangeValue, value, value, isLocked, setLocked, display, display, numberFormat, numberFormat |
| top-level / `no2/worldthreader/mixin/threadsafe_scoreboard/ServerScoreboardMixin.java` | `value={ServerScoreboard.class})` | Inject:1 | worldthreader$ensureExclusiveScoreboardAccess, worldthreader$crashIfNoExclusiveScoreboardAccess, ensureSafe |
| top-level / `no2/worldthreader/mixin/threadsafe_scoreboard/teams/PlayerTeamMixin.java` | `value={PlayerTeam.class})` | Inject:10 | init, getPlayers, worldthreader$getMutablePlayerSet, ensureSafe, worldthreader$onMutablePlayerSetModifiedExternally, setDisplayName, setPlayerPrefix, setPlayerSuffix, setAllowFriendlyFire, setSeeFriendlyInvisibles, setNameTagVisibility, setDeathMessageVisibility, setCollisionRule, setColor |
| top-level / `no2/worldthreader/mixin/threadsafe_scoreboard/teams/ScoreboardMixin.java` | `value={Scoreboard.class})` | Overwrite:2, Inject:3, Redirect:1 | getTeamNames, getPlayerTeams, ensureSafe, getMutablePlayerSet, notifyAboutModification, notifyAboutModification |
| top-level / `no2/worldthreader/mixin/threadsafe_scoreboard/teams/ServerScoreboardMixin.java` | `value={ServerScoreboard.class})` | Inject:2 | ensureSafe, ensureSafe1 |
| top-level / `no2/worldthreader/WorldThreaderMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `no2/worldthreader/WorldThreaderMod.java` | `` |  | onInitialize, initializeBeforeThreading |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
