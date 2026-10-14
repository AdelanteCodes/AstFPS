# ServerCore

Review status: **Evidence inventory; behavioral review pending**

Project: [ServerCore](https://modrinth.com/mod/servercore)
Selected artifact version: `1.5.20+26.3`
Published implementation source: https://github.com/Wesley1808/ServerCore
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A mod that aims to optimize the minecraft server.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `ec5fdf4798e29e483fa861dead101b0d9d6d72cb`
- `sha512`: `abe1f806ea587971faf7de826e18b07314a4a9e690f64a4c3a54e7f61c3e6f4792633b13a917252bd8de154cec39da6619110d83799cf533450c5b4cac7a8448`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 131
Reconstructed Java files: 129

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "me.wesley1808.servercore.fabric.common.ServerCoreFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3-",
  "fabric-api-base": "*",
  "fabric-command-api-v2": "*",
  "fabric-lifecycle-events-v1": "*"
}
```

**breaks**

```json
{
  "cardboard": "*"
}
```

**accessWidener**

```json
"servercore.accesswidener"
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/dazzleconf-core-1.3.0-M2.jar` | 119 | `space_arim_dazzleconf_dazzleconf-core` | No |
| `META-INF/jars/dazzleconf-ext-snakeyaml-1.3.0-M2.jar` | 16 | `space_arim_dazzleconf_dazzleconf-ext-snakeyaml` | No |
| `META-INF/jars/placeholder-api-3.2.0+26.3.jar` | 122 | `placeholder-api` | No |
| `META-INF/jars/snakeyaml-2.7.jar` | 233 | `org_yaml_snakeyaml` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `architectury_inject_ServerCore_common_d1ae532af7a646beabfd8b5f48fd21ef_573af8e6f3d314fc0a5c71d466fed7846bee300f29768364804600dfba69b6f7servercore1520263devjar/PlatformMethods.java` | `` |  | getCurrentTarget |
| top-level / `me/wesley1808/servercore/common/activation_range/ActivationRange.java` | `` |  | initializeEntityActivationType, isExcluded, activateEntities, activateEntity, isWithinRange, checkEntityImmunities, canBeImmunizedInWater, canBeImmunizedWhileFlying, checkIfActive, shouldTick, checkInactiveWakeup |
| top-level / `me/wesley1808/servercore/common/activation_range/EntityTypeTests.java` | `` |  | register, get, getKey |
| top-level / `me/wesley1808/servercore/common/collections/FilteredList.java` | `` |  | listIterator, hasNext, next, calculateNext, previous, nextIndex, previousIndex, hasPrevious |
| top-level / `me/wesley1808/servercore/common/commands/MobcapsCommand.java` | `` |  | register, mobcaps |
| top-level / `me/wesley1808/servercore/common/commands/ServerCoreCommand.java` | `` |  | register, reloadConfig, settings, modifyDynamic, reload, getStatus |
| top-level / `me/wesley1808/servercore/common/commands/StatisticsCommand.java` | `` |  | register, displayOverview, display, display, display, display, displayEntities, displayBlockEntities, displayFeedback, createEntry, createHeader, createFooter, parseCommand |
| top-level / `me/wesley1808/servercore/common/config/Config.java` | `` |  | optimizations, get, getSafe, loadOptimizationConfig, reload, onChanged, getOrCreateConfigManager, enableValidation, shouldValidate |
| top-level / `me/wesley1808/servercore/common/config/ConfigManager.java` | `` |  | create, reload, reloadConfigData, printError, get, isLoaded, copyAndSetData |
| top-level / `me/wesley1808/servercore/common/config/Copyable.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/config/data/activation_range/ActivationRangeConfig.java` | `` |  | defaultExcludedEntityTypes, defaultActivationTypes |
| top-level / `me/wesley1808/servercore/common/config/data/activation_range/ActivationType.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/config/data/activation_range/CustomActivationType.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/config/data/breeding_cap/BreedingCap.java` | `` |  | getAreaAt, resetLove, resetAge |
| top-level / `me/wesley1808/servercore/common/config/data/breeding_cap/BreedingCapConfig.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/config/data/CommandConfig.java` | `` |  | defaultPrimaryColor, defaultSecondaryColor, defaultTertiaryColor |
| top-level / `me/wesley1808/servercore/common/config/data/dynamic/DynamicConfig.java` | `` |  | defaultDynamicValues, defaultSettings |
| top-level / `me/wesley1808/servercore/common/config/data/dynamic/Setting.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/config/data/FeatureConfig.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/config/data/mob_spawning/EnforcedMobcap.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/config/data/mob_spawning/MobSpawnConfig.java` | `` |  | defaultCategories |
| top-level / `me/wesley1808/servercore/common/config/data/mob_spawning/MobSpawnEntry.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/config/impl/activation_range/ActivationRangeConfigImpl.java` | `` |  | enabled, tickNewEntities, useVerticalRange, skipNonImmune, villagerTickPanic, villagerWorkImmunityAfter, villagerWorkImmunityFor, excludedEntityTypes, defaultActivationType, activationTypes |
| top-level / `me/wesley1808/servercore/common/config/impl/activation_range/ActivationTypeImpl.java` | `` |  | activationRange, tickInterval, wakeupInterval, extraHeightUp, extraHeightDown |
| top-level / `me/wesley1808/servercore/common/config/impl/activation_range/CustomActivationTypeImpl.java` | `` |  | name, matchers |
| top-level / `me/wesley1808/servercore/common/config/impl/breeding_cap/BreedingCapConfigImpl.java` | `` |  | enabled, villagers, happyGhasts, animals |
| top-level / `me/wesley1808/servercore/common/config/impl/breeding_cap/BreedingCapImpl.java` | `` |  | limit, range, unlimitedHeight |
| top-level / `me/wesley1808/servercore/common/config/impl/dynamic/DynamicConfigImpl.java` | `` |  | enabled, targetMspt, defaultValues, settings |
| top-level / `me/wesley1808/servercore/common/config/impl/dynamic/SettingImpl.java` | `` |  | dynamicSetting, max, min, increment, interval |
| top-level / `me/wesley1808/servercore/common/config/impl/FeatureConfigImpl.java` | `` |  | preventEnderpearlChunkLoading, chunkTickDistanceAffectsRandomTicks, preventMovingIntoUnloadedChunks, autosaveIntervalSeconds, xpMergeFraction, xpMergeRadius, itemMergeRadius, lobotomizeVillagers, lobotomizedTickInterval |
| top-level / `me/wesley1808/servercore/common/config/impl/MainConfigImpl.java` | `` |  | features, dynamic, breedingCap, mobSpawning, commands, activationRange |
| top-level / `me/wesley1808/servercore/common/config/impl/mob_spawning/EnforcedMobcapImpl.java` | `` |  | enforcesMobcap, additionalCapacity |
| top-level / `me/wesley1808/servercore/common/config/impl/mob_spawning/MobSpawnConfigImpl.java` | `` |  | zombieReinforcements, portalRandomTicks, monsterSpawner, infested, categories |
| top-level / `me/wesley1808/servercore/common/config/impl/mob_spawning/MobSpawnEntryImpl.java` | `` |  | category, capacity, spawnInterval, despawnDistance |
| top-level / `me/wesley1808/servercore/common/config/MainConfig.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/config/OptimizationConfig.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/config/serialization/EntityTypeSerializer.java` | `` |  | getTargetClass, deserialise, serialise |
| top-level / `me/wesley1808/servercore/common/config/serialization/EntityTypeTestSerializer.java` | `` |  | getTargetClass, deserialise, serialise |
| top-level / `me/wesley1808/servercore/common/config/serialization/TextColorSerializer.java` | `` |  | getTargetClass, deserialise, serialise |
| top-level / `me/wesley1808/servercore/common/dynamic/DynamicManager.java` | `` |  | getInstance, reload, update, updateValues, calculateAverageTickTime, runPerformanceChecks, modifyViewDistance, modifySimulationDistance, modifyMobcaps, getAverageTickTime |
| top-level / `me/wesley1808/servercore/common/dynamic/DynamicSetting.java` | `` |  | initDefaultValues, recalculateValues, resetAll, set, notifyChanged, get, getLowerBound, getUpperBound, getDefaultValue, getFormattedName, getFormattedValue |
| top-level / `me/wesley1808/servercore/common/dynamic/LinkedSetting.java` | `` |  | initialize, shouldRun, modify, shouldModify, newValue, isMinimum, isMaximum |
| top-level / `me/wesley1808/servercore/common/dynamic/SparkDynamicManager.java` | `` |  | calculateAverageTickTime |
| top-level / `me/wesley1808/servercore/common/interfaces/activation_range/ActivationEntity.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/interfaces/activation_range/Inactive.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/interfaces/chunk/ILevelChunk.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/interfaces/chunk/IServerChunkCache.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/interfaces/IMinecraftServer.java` | `` |  | onStarted |
| top-level / `me/wesley1808/servercore/common/interfaces/IMobCategory.java` | `` |  | of, getSpawnInterval, getOriginalCapacity, modifyCapacity, reload, modify |
| top-level / `me/wesley1808/servercore/common/ServerCore.java` | `` |  | initialize, applyOptimizations |
| top-level / `me/wesley1808/servercore/common/services/Events.java` | `` |  | onTick, onServerStarted, onShutdown, registerCommands |
| top-level / `me/wesley1808/servercore/common/services/Formatter.java` | `` |  | parse, addLines |
| top-level / `me/wesley1808/servercore/common/services/Permission.java` | `` |  | visitPermissions, check, require, register |
| top-level / `me/wesley1808/servercore/common/services/PermNode.java` | `` |  | PermNode |
| top-level / `me/wesley1808/servercore/common/services/platform/MinecraftPlatform.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/services/platform/ModPlatform.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/services/platform/PlatformHelper.java` | `` |  | initialize, isClient, isModLoaded, getConfigDir, getVersion, parseText, hasPermission, load |
| top-level / `me/wesley1808/servercore/common/utils/ChunkManager.java` | `` |  | getRoughBiome, getBlockState, getChunkNow, getChunkNow, getChunkFromFuture, getChunkFromHolder, getChunkHolder, hasChunk, hasChunk, hasChunk, areChunksLoadedForMove |
| top-level / `me/wesley1808/servercore/common/utils/ChunkTickManager.java` | `` |  | isChunkTickable, isChunkTickable, distanceFromSource, isWithinChunkDistance |
| top-level / `me/wesley1808/servercore/common/utils/EntityTags.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/utils/Environment.java` | `` |  |  |
| top-level / `me/wesley1808/servercore/common/utils/Mobcaps.java` | `` |  | canSpawnForCategory, canSpawnForCategory, toGlobalCapacity, getPlayersNear |
| top-level / `me/wesley1808/servercore/common/utils/statistics/entry/EntityStatisticEntry.java` | `` |  | increment, formatValue, isActive |
| top-level / `me/wesley1808/servercore/common/utils/statistics/entry/StatisticEntry.java` | `` |  | increment, formatValue, compareTo |
| top-level / `me/wesley1808/servercore/common/utils/statistics/GroupBy.java` | `` |  | getName |
| top-level / `me/wesley1808/servercore/common/utils/statistics/Statistics.java` | `` |  | getInstance, getAllEntities, getAllBlockEntities, getEntitiesByType, getBlockEntitiesByType, getEntitiesByPlayer, getBlockEntitiesByPlayer, getAll, getByType, getByPlayer, getEntitiesNear, getBlockEntitiesNear, getChunkCount, isNearby |
| top-level / `me/wesley1808/servercore/common/utils/statistics/StatisticType.java` | `` |  | getName, getCommandFormat |
| top-level / `me/wesley1808/servercore/common/utils/Util.java` | `` |  | iteratePage, getIndex, getPage, sortByValue, suggestAll, hasTasks, hasTasks, map |
| top-level / `me/wesley1808/servercore/fabric/common/FabricMinecraftPlatform.java` | `` |  | hasPermission, parseText |
| top-level / `me/wesley1808/servercore/fabric/common/FabricModPlatform.java` | `` |  | isClient, isModLoaded, getConfigDir, getVersion, getVersionString |
| top-level / `me/wesley1808/servercore/fabric/common/PlaceHolders.java` | `` |  | register, registerDynamic, registerStatistics, cachedValue, register |
| top-level / `me/wesley1808/servercore/fabric/common/ServerCoreFabric.java` | `` |  | onInitialize |
| top-level / `me/wesley1808/servercore/fabric/mixin/optimizations/misc/BlockGetterMixin.java` | `value={BlockGetter.class})` | Redirect:1 | servercore$fastFluidCheck |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/EntityMixin.java` | `value={Entity.class})` | Inject:5, WrapWithCondition:1 | servercore$setupActivationStates, servercore$replaceTickCount, servercore$onPistonMove, servercore$ignorePushingWhileInactive, servercore$onLoadNbt, servercore$onTagAdded, servercore$getActivationType, servercore$isExcluded, servercore$getActivatedTick, servercore$setActivatedTick, servercore$getActivatedImmunityTick, servercore$setActivatedImmunityTick, servercore$isInactive, servercore$setInactive, servercore$getFullTickCount, servercore$inactiveTick |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/fixes/CatMixin.java` | `value={Cat.class})` | Redirect:1 | servercore$fixCatDespawning |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/fixes/OcelotMixin.java` | `value={Ocelot.class})` | Redirect:1 | servercore$fixOcelotDespawning |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/fixes/PistonMovingBlockEntityMixin.java` | `value={PistonMovingBlockEntity.class}, priority=900)` | Inject:1 | servercore$onPushEntity |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/inactive_ticks/AgeableMobMixin.java` | `value={AgeableMob.class})` |  | servercore$inactiveTick |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/inactive_ticks/AreaEffectCloudMixin.java` | `value={AreaEffectCloud.class})` |  | servercore$inactiveTick |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/inactive_ticks/ArrowMixin.java` | `value={Arrow.class})` |  | servercore$inactiveTick |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/inactive_ticks/BeeMixin.java` | `value={Bee.class})` |  | servercore$inactiveTick |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/inactive_ticks/ChickenMixin.java` | `value={Chicken.class})` |  | servercore$inactiveTick |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/inactive_ticks/GoalSelectorMixin.java` | `value={GoalSelector.class})` |  | servercore$inactiveTick |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/inactive_ticks/ItemEntityMixin.java` | `value={ItemEntity.class})` |  | servercore$inactiveTick |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/inactive_ticks/LivingEntityMixin.java` | `value={LivingEntity.class})` |  | servercore$inactiveTick |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/inactive_ticks/MobMixin.java` | `value={Mob.class})` |  | servercore$inactiveTick |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/inactive_ticks/SkeletonHorseMixin.java` | `value={SkeletonHorse.class})` |  | servercore$inactiveTick |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/inactive_ticks/SpectralArrowMixin.java` | `value={SpectralArrow.class})` |  | servercore$inactiveTick |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/inactive_ticks/TadpoleMixin.java` | `value={Tadpole.class})` |  | servercore$inactiveTick |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/inactive_ticks/VillagerMixin.java` | `value={Villager.class})` |  | servercore$inactiveTick |
| top-level / `me/wesley1808/servercore/mixin/features/activation_range/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:1, WrapWithCondition:2 | servercore$activateEntities, servercore$shouldTickEntity, servercore$shouldTickPassenger |
| top-level / `me/wesley1808/servercore/mixin/features/breeding_cap/AllayMixin.java` | `value={Allay.class})` | Inject:1 | servercore$enforceBreedCap |
| top-level / `me/wesley1808/servercore/mixin/features/breeding_cap/DriedGhastBlockMixin.java` | `value={DriedGhastBlock.class})` | WrapWithCondition:1 | servercore$enforceBreedCap |
| top-level / `me/wesley1808/servercore/mixin/features/breeding_cap/tasks/AnimalMakeLoveMixin.java` | `value={AnimalMakeLove.class})` | WrapWithCondition:1 | servercore$enforceBreedCap |
| top-level / `me/wesley1808/servercore/mixin/features/breeding_cap/tasks/BreedGoalMixin.java` | `value={BreedGoal.class})` | WrapWithCondition:1 | servercore$enforceBreedCap |
| top-level / `me/wesley1808/servercore/mixin/features/breeding_cap/tasks/VillagerMakeLoveMixin.java` | `value={VillagerMakeLove.class})` | Inject:1 | servercore$enforceBreedCap |
| top-level / `me/wesley1808/servercore/mixin/features/breeding_cap/ThrownEggMixin.java` | `value={ThrownEgg.class})` | ModifyExpressionValue:1 | servercore$enforceBreedCap |
| top-level / `me/wesley1808/servercore/mixin/features/dynamic/ChunkMapMixin.java` | `value={ChunkMap.class})` | ModifyReturnValue:1, WrapWithCondition:1 | servercore$withinChunkTickDistance, servercore$forEachBlockTickingChunk$notTheCauseOfTickLag |
| top-level / `me/wesley1808/servercore/mixin/features/dynamic/MobCategoryMixin.java` | `value={MobCategory.class}, priority=900)` | Inject:2 | servercore$onInit, servercore$getCapacity, servercore$getSpawnInterval, servercore$getOriginalCapacity, servercore$modifyCapacity, servercore$modifySpawningConfig |
| top-level / `me/wesley1808/servercore/mixin/features/dynamic/PlayerListMixin.java` | `value={PlayerList.class})` | Inject:2 | servercore$updateViewDistance, servercore$updateSimulationDistance |
| top-level / `me/wesley1808/servercore/mixin/features/ender_pearls/ServerPlayerMixin.java` | `value={ServerPlayer.class})` | Inject:2 | servercore$preventEnderpearlRegistration, servercore$preventEnderpearlLoading |
| top-level / `me/wesley1808/servercore/mixin/features/ender_pearls/ThrownEnderPearlMixin.java` | `value={ThrownEnderpearl.class})` | ModifyExpressionValue:1, WrapWithCondition:1 | servercore$preventEnderpearlChunkLoading, servercore$preventEnderpearlChunkLoading |
| top-level / `me/wesley1808/servercore/mixin/features/merging/ExperienceOrbMixin.java` | `value={ExperienceOrb.class})` | ModifyConstant:1, ModifyArg:1 | servercore$modifyMergeFraction, servercore$modifyMergeRadius |
| top-level / `me/wesley1808/servercore/mixin/features/merging/ItemEntityMixin.java` | `value={ItemEntity.class})` | ModifyConstant:1 | servercore$modifyMergeRadius |
| top-level / `me/wesley1808/servercore/mixin/features/misc/MinecraftServerMixin.java` | `value={MinecraftServer.class}, priority=900)` | ModifyConstant:1 | servercore$modifyAutoSaveInterval |
| top-level / `me/wesley1808/servercore/mixin/features/misc/ServerGamePacketListenerImplMixin.java` | `value={ServerGamePacketListenerImpl.class})` | Inject:4 | servercore$handleMoveVehicle, servercore$handlePlayerPositionChange, servercore$preHandleMovePlayer, servercore$postHandleMovePlayer, servercore$shouldPreventMovement |
| top-level / `me/wesley1808/servercore/mixin/features/mob_spawning/BaseSpawnerMixin.java` | `value={BaseSpawner.class})` | Inject:1 | servercore$enforceMobcap |
| top-level / `me/wesley1808/servercore/mixin/features/mob_spawning/InfestedMobEffectMixin.java` | `targets={"net/minecraft/world/effect/InfestedMobEffect"})` | Inject:1 | servercore$enforceMobcap |
| top-level / `me/wesley1808/servercore/mixin/features/mob_spawning/NaturalSpawnerMixin.java` | `value={NaturalSpawner.class}, priority=900)` | ModifyVariable:1, Redirect:1 | servercore$alwaysSpawnPersistent, servercore$canSpawn |
| top-level / `me/wesley1808/servercore/mixin/features/mob_spawning/NetherPortalBlockMixin.java` | `value={NetherPortalBlock.class})` | ModifyExpressionValue:1 | servercore$enforceMobCap |
| top-level / `me/wesley1808/servercore/mixin/features/mob_spawning/ZombieMixin.java` | `value={Zombie.class})` | ModifyExpressionValue:1 | servercore$enforceMobCap |
| top-level / `me/wesley1808/servercore/mixin/features/ticking/VillagerMixin.java` | `value={Villager.class})` | WrapWithCondition:1 | servercore$shouldTickBrain, servercore$isLobotomized, servercore$canTravel, servercore$canTravelTo, servercore$hasCollisionAt |
| top-level / `me/wesley1808/servercore/mixin/MinecraftServerMixin.java` | `value={MinecraftServer.class})` |  | servercore$onStarted, servercore$getStatistics, servercore$getDynamicManager |
| top-level / `me/wesley1808/servercore/mixin/optimizations/biome_lookups/NaturalSpawnerMixin.java` | `value={NaturalSpawner.class})` | Redirect:1 | servercore$fastBiomeLookup |
| top-level / `me/wesley1808/servercore/mixin/optimizations/command_blocks/BaseCommandBlockMixin.java` | `value={BaseCommandBlock.class}, priority=2000)` | Redirect:1, Inject:2 | servercore$useCachedParseResults, servercore$resetCache, servercore$resetCache |
| top-level / `me/wesley1808/servercore/mixin/optimizations/misc/PathFinderMixin.java` | `value={PathFinder.class})` | Redirect:3 | servercore$reduceStreams, servercore$reduceStreams, servercore$reduceStreams |
| top-level / `me/wesley1808/servercore/mixin/optimizations/sync_loads/BeeMixin.java` | `value={Bee.class})` | ModifyExpressionValue:1 | servercore$onlyFetchHiveIfLoaded |
| top-level / `me/wesley1808/servercore/mixin/optimizations/sync_loads/DynamicGameEventListenerMixin.java` | `value={DynamicGameEventListener.class})` | Redirect:1 | servercore$onlyUpdateIfLoaded |
| top-level / `me/wesley1808/servercore/mixin/optimizations/sync_loads/LevelMixin.java` | `value={Level.class})` | Redirect:1 | servercore$onlyUpdateIfLoaded |
| top-level / `me/wesley1808/servercore/mixin/optimizations/sync_loads/MapItemMixin.java` | `value={MapItem.class})` | Redirect:2 | servercore$onlyUpdateIfLoaded, servercore$validateNotNull |
| top-level / `me/wesley1808/servercore/mixin/optimizations/sync_loads/RemoveBlockGoalMixin.java` | `value={RemoveBlockGoal.class})` | Redirect:1 | servercore$onlyValidateIfLoaded |
| top-level / `me/wesley1808/servercore/mixin/optimizations/sync_loads/SleepInBedMixin.java` | `value={SleepInBed.class})` | Inject:1 | servercore$onlyProcessIfLoaded |
| top-level / `me/wesley1808/servercore/mixin/optimizations/tickets/ChunkGeneratorMixin.java` | `value={ChunkGenerator.class})` | Redirect:1 | servercore$preventAddingTickets |
| top-level / `me/wesley1808/servercore/mixin/optimizations/tickets/NaturalSpawnerMixin.java` | `value={NaturalSpawner.class})` | Redirect:1 | servercore$preventAddingTickets |
| top-level / `me/wesley1808/servercore/mixin/optimizations/ticking/chunk/cache/ServerChunkCacheMixin.java` | `value={ServerChunkCache.class}, priority=900)` | Inject:2, Redirect:3, WrapWithCondition:2 | servercore$onInit, servercore$beforeChunkTicks, servercore$cacheBlockTickingChunks$notTheCauseOfTickLag, servercore$cacheSpawnTickingChunks, servercore$ignoreUnloadedSpawnTicks, servercore$cancelShuffle, servercore$cancelListClear |
| top-level / `me/wesley1808/servercore/mixin/optimizations/ticking/chunk/random/LevelChunkMixin.java` | `value={LevelChunk.class})` | Inject:1 | servercore$shouldDoLightning, servercore$initLightingTick |
| top-level / `me/wesley1808/servercore/mixin/optimizations/ticking/chunk/random/LiquidBlockMixin.java` | `value={LiquidBlock.class}, priority=900)` | Redirect:1 | servercore$cancelDuplicateFluidTicks |
| top-level / `me/wesley1808/servercore/mixin/optimizations/ticking/chunk/random/ServerLevelMixin.java` | `value={ServerLevel.class}, priority=900)` | Redirect:1 | servercore$replaceLightningCheck |
| top-level / `me/wesley1808/servercore/mixin/ServerCoreMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, shouldEnableCompatMixin, acceptTargets, getMixins, preApply, postApply |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
