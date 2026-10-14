# LazyAI

Review status: **Evidence inventory; behavioral review pending**

Project: [LazyAI](https://modrinth.com/mod/lazyai)
Selected artifact version: `1.7.1`
Published implementation source: https://github.com/PixelIndieDev/LazyAI
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Optimizes Minecraft mob AI by scaling calculations based on distance to players, improving performance with as minimal gameplay impact as possible

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `55069fed2abdbc375867b0d178499ac10590fddb66c42c95168a3c50002b10a7cd3c11f92ece04336ade2938dba6e824ea5744d74ea2430bbcd745de2440101a`
- `sha1`: `907fbd71492571d97bf2040cff763996b210ad44`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 55
Reconstructed Java files: 53

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.pixelindiedev.lazy_ai_pixelindiedev.Lazy_ai_pixelindiedev"
  ],
  "modmenu": [
    "com.pixelindiedev.lazy_ai_pixelindiedev.config.integration.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/classes/TickCycleTracker.java` | `` |  | applyTickCycleTrackerStuff |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/config/integration/LazyAiConfigScreen.java` | `` |  | init, onClose |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/config/integration/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/config/ModConfig.java` | `` |  | load, save, hasExternalChange, getMultiplierUsingDistanceScaling, getBlockDistance_Close_Multiplier, getBlockDistance_Far_Multiplier |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/config/ModConfigDefaults.java` | `` |  |  |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/EntityClassificationer.java` | `` |  | GetEntityCategory, IsEntityFarmAnimal, IsAmbientAnimal, IsWaterAmbientAnimal, CanBePet |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/enums/CriticalTPSModeEnum.java` | `` |  |  |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/enums/DistanceScalingType.java` | `` |  |  |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/enums/DistanceType.java` | `` |  |  |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/enums/EntityCategoryEnum.java` | `` |  |  |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/enums/OptimalizationType.java` | `` |  |  |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/enums/TemptDelayEnum.java` | `` |  |  |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/helpers/BlockDistancesHelper.java` | `` |  | SetSimulationDistance, SetBlockDistances |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/helpers/CooldownHelper.java` | `` |  | shouldThrottle, canTick, canTick, getCurrentCooldownList, getCooldownList |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/helpers/LoggerHolder.java` | `` |  |  |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/helpers/ThrottleHelper.java` | `` |  | ShouldThrottlePushing |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/interfaces/TickCancellingAware.java` | `` |  |  |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/interfaces/VillagerCacheAccessor.java` | `` |  |  |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/Lazy_ai_pixelindiedev.java` | `` |  | tpsToMs, onServerTick, getMsPerTick, GetCurrentCriticalMode, GetClosestPlayerDistance, getDistance, chunksToSquaredBlocks, getTemptGoal, getOptimalizationType, getDisableZombieEggStomping, getEnableVanillaMobTicking, getServerTick, GetMobEntity, UpdateDistanceValues, DoesTPSHaveHeadroomFor, throttleSeverity, EstimatedEasingMarginFor, onInitialize |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/LazyAI$BlockChecker.java` | `` |  | initializeCache, hasSolidCollision, hasSolidCollision, hasCollisionFast |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/LazyAi$ChestCacheManager.java` | `` |  | getCachedStorage, addChest, addChest, addChestWorld, removeChest, invalidateChunk, clearWorld, scanChunkForChests, packChunkPos |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/entity/AnimalEntityMixin.java` | `value={Animal.class}, priority=1010)` | Inject:1 | compensateLoveTicks |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/entity/LivingEntityMixin.java` | `value={LivingEntity.class}, priority=900)` | Inject:4 | lazy_ai$getSkippedTicks, limitCramming, assignOffset, ThrottleWholeAI, ThrottleRiptide, isMobInFight |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/entity/VillagerEntityMixin.java` | `value={Villager.class})` | Inject:2 | captureMob, lazyai$invalidateBlockCache, skipIdleTradingHallTick, isInTradingCell, getCachedProfession, getCachedSolidBlock |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/attack/AttackGoalMixin.java` | `value={OcelotAttackGoal.class}, priority=1001)` | Inject:1 | throttleTick |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/attack/BowAttackGoalMixin.java` | `value={RangedBowAttackGoal.class}, priority=1001)` | Inject:1 | compensateCooldown |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/attack/CrossbowAttackGoalMixin.java` | `value={RangedCrossbowAttackGoal.class}, priority=1001)` | Inject:1 | compensateCooldown |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/attack/GhastShootFireballGoalMixin.java` | `targets={"net.minecraft.world.entity.monster.Ghast$GhastShootFireballGoal"}, priority=600)` | Inject:1, ModifyExpressionValue:3 | throttleFireballTick, adjustSightDelay2, adjustSightDelay1, adjustSightDelay |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/attack/MeleeAttackGoalMixin.java` | `value={MeleeAttackGoal.class}, priority=1003)` | Inject:1 | compensateCooldown |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/attack/ProjectileAttackGoalMixin.java` | `value={RangedAttackGoal.class}, priority=1001)` | Inject:1 | compensateCooldown |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/brain/BrainMixin.java` | `value={Brain.class})` | Inject:1 | throttleSensors |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/look/LookAroundGoalMixin.java` | `value={RandomLookAroundGoal.class}, priority=1001)` | Inject:1 | throttleLookAround |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/look/LookAtEntityGoalMixin.java` | `value={LookAtPlayerGoal.class}, priority=1001)` | Inject:1 | throttleLookAt |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/movement/DestroyEggGoalMixin.java` | `value={RemoveBlockGoal.class}, priority=1001)` | Inject:1 | ThrottleEggCheck |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/movement/FleeEntityGoalMixin.java` | `value={AvoidEntityGoal.class}, priority=1003)` | Inject:2 | throttleDetection, reduceTickFrequency |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/movement/FollowMobGoalMixin.java` | `value={FollowMobGoal.class}, priority=1001)` | Inject:1 | throttleFollowMob |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/movement/MoveThroughVillageGoalMixin.java` | `value={MoveThroughVillageGoal.class}, priority=1001)` | Inject:1 | throttleVillageScan |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/movement/MoveToTargetPosGoalMixin.java` | `value={MoveToBlockGoal.class}, priority=1001)` | Inject:2 | ThrottleSearch, reduceTickLoad |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/movement/SwimGoalMixin.java` | `value={FloatGoal.class}, priority=1003)` | Inject:1 | onlyTickWhenUnderwater |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/movement/TemptGoalmixin.java` | `value={TemptGoal.class}, priority=600)` | ModifyExpressionValue:1 | replaceInt |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/movement/WanderAroundGoalMixin.java` | `value={RandomStrollGoal.class}, priority=1002)` | Inject:1 | ThrottleWandering |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/goals/universal/UniversalAngerGoalmixin.java` | `value={ResetUniversalAngerTargetGoal.class}, priority=1001)` | Inject:1 | TrotthleAngerChecks |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/integration/EntityAccessor.java` | `value={Entity.class})` | Accessor:1, Invoker:2 |  |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/integration/LivingEntityAccessor.java` | `value={LivingEntity.class})` | Accessor:2 |  |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/integration/MoveItemsTaskAccessor.java` | `value={TransportItemsBetweenContainers.class})` | Invoker:3 | invokeGetVisitedPositions, invokeGetUnreachablePositions, invokeCanPickUpItem |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/integration/VillagerEntityAccessor.java` | `value={Villager.class})` | Accessor:2 |  |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/LookControlMixin.java` | `value={LookControl.class})` | Inject:1 | onTick |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/MobPushingMixin.java` | `value={LivingEntity.class})` | Inject:2 | captureMob, ThrottlePush |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/MoveItemsTaskMixin.java` | `value={TransportItemsBetweenContainers.class}, priority=1002)` | Inject:6 | injectCachedStorage, isInventoryFull, containsMatchingItem, beforePlaceStack, afterPlaceStack, onMarkUnreachable, findNearestValidStorage, testContainerFast, skipUnchangedVisited, reset |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/navigation/EntityNavigationMixin.java` | `value={PathNavigation.class}, priority=1004)` | Inject:1 | ThrottleEntityNav |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/PlayerListMixin.java` | `value={PlayerList.class})` | Inject:1 | onSimulationDistanceChanged |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/mixin/WorldMixin.java` | `value={ServerLevel.class})` | Inject:3 | invalidateBlockCacheNearbyVillagers, onChunkUnload, onWorldClose |
| top-level / `com/pixelindiedev/lazy_ai_pixelindiedev/records/ThrottleResult.java` | `` |  | ThrottleResult |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
