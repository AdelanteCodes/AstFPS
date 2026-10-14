# Antideath-Carpet-addition

Review status: **Evidence inventory; behavioral review pending**

Project: [Antideath-Carpet-addition](https://modrinth.com/mod/antideath-carpet-addition)
Selected artifact version: `v1.6.0-mc26.3`
Published implementation source: https://github.com/jfglzs/Antideath-Carpet-addition
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Antideath-Carpet-addition is a Carpet Mod extension for Fabric Minecraft servers (versions 1.21.x - 26.2) designed to enhance and optimize the game experience.

It adds a suite of new loggers for server monitoring and game rules for survival, optimizatio

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `optional`.

Artifact identity:
- `sha1`: `1c4ca6a68c82a44f4b766b4cbdaca3fabef27c0f`
- `sha512`: `fdf4ea9e37bc433f5874e7bb4de6e3f5b3dc325151fb8e53dc6d55296c4293970dafe16ea07fd59ca0a82472ed68117e874828d30bc97616fb4c9dc4fc4f3afb`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 72
Reconstructed Java files: 68

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "io.github.jfglzs.aca.ACAEntry"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16",
  "minecraft": "26.3",
  "carpet": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/github/jfglzs/aca/ACAEntry.java` | `` |  | onInitialize |
| top-level / `io/github/jfglzs/aca/ACAServer.java` | `` |  | onGameStarted, onTick, onServerClosed, canHasTranslations, registerLoggers, registerCommands, version, initConfig |
| top-level / `io/github/jfglzs/aca/AcaSetting.java` | `` |  |  |
| top-level / `io/github/jfglzs/aca/accessors/AbstractMinecartAccessor.java` | `` |  |  |
| top-level / `io/github/jfglzs/aca/accessors/EntityAccessor.java` | `` |  |  |
| top-level / `io/github/jfglzs/aca/accessors/EntityPlayerMPFakeAccessor.java` | `` |  |  |
| top-level / `io/github/jfglzs/aca/accessors/GoalAccessor.java` | `` |  |  |
| top-level / `io/github/jfglzs/aca/accessors/GoalSelectorAccessor.java` | `` |  |  |
| top-level / `io/github/jfglzs/aca/accessors/IVehicleAccessor.java` | `` |  |  |
| top-level / `io/github/jfglzs/aca/accessors/IVillagerAccessor.java` | `` |  |  |
| top-level / `io/github/jfglzs/aca/accessors/LivingEntityAccessor.java` | `` |  |  |
| top-level / `io/github/jfglzs/aca/accessors/SpawnStateAccessor.java` | `` |  |  |
| top-level / `io/github/jfglzs/aca/command/HatCommand.java` | `` |  | register |
| top-level / `io/github/jfglzs/aca/command/MannequinCommand.java` | `` |  |  |
| top-level / `io/github/jfglzs/aca/command/PlayerCommand.java` | `` |  | registerCommand, lockPlayer, unlockPlayer |
| top-level / `io/github/jfglzs/aca/command/PreventCommand.java` | `` |  | registerCommand, addWhiteList, addBlackList, addPrefix, removeWhiteList, removeBlackList, removePrefix, listPrefix, listWhiteList, listBlackList, reload, addOrRemoveFromList |
| top-level / `io/github/jfglzs/aca/command/SearchEntityCommand.java` | `` |  | registerCommand, execute, sendFeedback |
| top-level / `io/github/jfglzs/aca/event/Event.java` | `` |  | update, register |
| top-level / `io/github/jfglzs/aca/event/onLogging.java` | `` |  |  |
| top-level / `io/github/jfglzs/aca/logger/AbstractHUDLogger.java` | `` |  |  |
| top-level / `io/github/jfglzs/aca/logger/cpu/CpuLogger.java` | `` |  | updateHUD, getCpuLoad, getCpuPerCoreLoad, coreLoad |
| top-level / `io/github/jfglzs/aca/logger/disk/DiskLogger.java` | `` |  | updateHUD, logDisk, logReadAndWrite, logStorage, DiskSnapShot |
| top-level / `io/github/jfglzs/aca/logger/entities/EntityLogger.java` | `` |  | updateHUD, getDimension |
| top-level / `io/github/jfglzs/aca/logger/Loggers.java` | `` |  | registerLoggers, registerLogger |
| top-level / `io/github/jfglzs/aca/logger/memory/MemoryAllocationRateLogger.java` | `` |  | toMiB, updateHUD, getCollectionCount |
| top-level / `io/github/jfglzs/aca/logger/memory/MemoryLogger.java` | `` |  | toMiB, updateHUD, logMemory |
| top-level / `io/github/jfglzs/aca/logger/network/NetworkLogger.java` | `` |  | updateHUD, logNetwork, calculate, isPhysicDevice |
| top-level / `io/github/jfglzs/aca/mixin/carpet/EntityPlayerMpFake_Mixin.java` | `value={EntityPlayerMPFake.class})` |  | aca$setLockState, aca$getLockState |
| top-level / `io/github/jfglzs/aca/mixin/carpet/HUDController_Mixin.java` | `value={HUDController.class})` | Inject:1 | updateHUD_Inject |
| top-level / `io/github/jfglzs/aca/mixin/carpet/PlayerCommand_Invoker.java` | `value={PlayerCommand.class})` | Invoker:1 | getPlayer |
| top-level / `io/github/jfglzs/aca/mixin/carpet/PlayerCommand_Mixin.java` | `value={PlayerCommand.class})` | Inject:2 | getPlayer, kill, cantSpawn |
| top-level / `io/github/jfglzs/aca/mixin/carpet/SettingsManager_Mixin.java` | `value={SettingsManager.class})` | Inject:1 | listAllSettings |
| top-level / `io/github/jfglzs/aca/mixin/rule/anvilNeverDamageByFalling/AnvilBlock_Mixin.java` | `value={AnvilBlock.class})` | Inject:1 | getLandingState_Inject |
| top-level / `io/github/jfglzs/aca/mixin/rule/beaconOptimization/BeaconBlockEntity_Mixin.java` | `value={BeaconBlockEntity.class})` | ModifyConstant:1, ModifyVariable:1 | modifyColorChangeInterval, modifyRange |
| top-level / `io/github/jfglzs/aca/mixin/rule/beeOptimization/Bee_Mixin.java` | `value={Bee.class})` | Inject:1, WrapOperation:1 | aca$ensureInit, registerGoals, registerGoals |
| top-level / `io/github/jfglzs/aca/mixin/rule/beeOptimization/Goal_Mixin.java` | `value={Goal.class})` |  | aca$setAccessible, aca$getAccessiblie |
| top-level / `io/github/jfglzs/aca/mixin/rule/beeOptimization/GoalSelector_Mixin.java` | `value={GoalSelector.class})` | WrapOperation:1 | aca$setEntity, isRunning |
| top-level / `io/github/jfglzs/aca/mixin/rule/beeOptimization/LivingEntity_Mixin.java` | `value={LivingEntity.class}, priority=900)` | Inject:1 | travel_Inject |
| top-level / `io/github/jfglzs/aca/mixin/rule/boatOptimization/AbstractBoat_Mixin.java` | `value={AbstractBoat.class})` | WrapOperation:2, Inject:4 | tick, isUnderwater_Cache, isUnderwater, startRiding, aca$getRideCount, addAdditionalSaveData, readAdditionalSaveData |
| top-level / `io/github/jfglzs/aca/mixin/rule/boatOptimization/Entity_Mixin.java` | `value={Entity.class})` | Inject:2 | move, baseTick |
| top-level / `io/github/jfglzs/aca/mixin/rule/commandPreventer/Commands_Mixin.java` | `value={Commands.class})` | Inject:1 | execute_Inject, preventCommand |
| top-level / `io/github/jfglzs/aca/mixin/rule/endermanNeverGetAngryByPlayer/EnderMan_Mixin.java` | `value={Enderman.class})` | Inject:1 | setAngerTime_Inject |
| top-level / `io/github/jfglzs/aca/mixin/rule/fastClickPacketLimit/ServerGamePacketListenerImpl_Mixin.java` | `value={ServerGamePacketListenerImpl.class})` | Inject:1 | handleUseItem_Limit |
| top-level / `io/github/jfglzs/aca/mixin/rule/flippinToTemOfUndying/BlockRotator_Mixin.java` | `value={BlockRotator.class})` | Inject:2 | flippinEligibility_Inject, flipBlockWithCactus_Inject |
| top-level / `io/github/jfglzs/aca/mixin/rule/hardDecoratedPot/DecoratedPotBlock_Mixin.java` | `value={DecoratedPotBlock.class})` | Inject:1 | onProjectileHit |
| top-level / `io/github/jfglzs/aca/mixin/rule/itemDespawnImmediately/ItemEntity_Mixin.java` | `value={ItemEntity.class})` | Inject:1, WrapWithCondition:1 | tick, discard_Wrap |
| top-level / `io/github/jfglzs/aca/mixin/rule/ItemFrameAlwaysStayAttach/ItemFrame_Mixin.java` | `value={ItemFrame.class})` | Inject:1 | CanStayAttached_Inject |
| top-level / `io/github/jfglzs/aca/mixin/rule/itemPickUpRange/Player_Mixin.java` | `value={Player.class})` | Inject:1, Redirect:1 | tickMovement_Inject, getOtherEntities_Redirect |
| top-level / `io/github/jfglzs/aca/mixin/rule/mcdrPrefixCompatible/PlayerList_Mixin.java` | `value={PlayerList.class})` | ModifyArgs:1 | broadcastChatMessage |
| top-level / `io/github/jfglzs/aca/mixin/rule/neverDropLeashBySpectator/Leashable_Mixin.java` | `value={Leashable.class})` | WrapOperation:1 | dropLeash |
| top-level / `io/github/jfglzs/aca/mixin/rule/softAnvil/FallingBlockEntity_Mixin.java` | `value={FallingBlockEntity.class})` | Inject:1 | handleFallDamage_Inject |
| top-level / `io/github/jfglzs/aca/mixin/rule/superSponge/SpongeBlock_Mixin.java` | `value={SpongeBlock.class})` | WrapOperation:1 | iterateRecursively_Wrap |
| top-level / `io/github/jfglzs/aca/mixin/rule/villagerOptimization/Brain_Mixin.java` | `value={Brain.class})` | WrapWithCondition:1 | tickSensors_Wrap |
| top-level / `io/github/jfglzs/aca/mixin/rule/villagerOptimization/Entity_Mixin.java` | `value={Entity.class})` | Inject:1 | tickBlockCollision_Inject |
| top-level / `io/github/jfglzs/aca/mixin/rule/villagerOptimization/LivingEntity_Mixin.java` | `value={LivingEntity.class}, priority=900)` | Inject:3 | travel, pushEntities, baseTick |
| top-level / `io/github/jfglzs/aca/mixin/rule/villagerOptimization/NearestLivingEntitySensor_Mixin.java` | `value={NearestLivingEntitySensor.class})` | WrapOperation:1 | sort_WrapOperation |
| top-level / `io/github/jfglzs/aca/mixin/rule/villagerOptimization/Villager_Mixin.java` | `value={Villager.class})` | Inject:4 | mobTick_Inject, aca$canDisableAI, aca$addCount, foreach_Inject, addAdditionalSaveData, readAdditionalSaveData |
| top-level / `io/github/jfglzs/aca/mixin/rule/villagerOptimization/VillagerGoalPackages_Mixin.java` | `value={VillagerGoalPackages.class})` | WrapMethod:5 | validateBedPoi, getIdlePackage, getCorePackage_Wrap, getPreRaidPackage, getRaidPackage, getPanicPackage, cullAll |
| top-level / `io/github/jfglzs/aca/utils/CommandUtils.java` | `` |  | runCommand |
| top-level / `io/github/jfglzs/aca/utils/config/ConfigBean.java` | `` |  |  |
| top-level / `io/github/jfglzs/aca/utils/config/ConfigUtils.java` | `` |  | load, create, init, exists, write, loadConfigFile, saveConfig, addToConfig, removeConfig, toBoolean |
| top-level / `io/github/jfglzs/aca/utils/DataUtils.java` | `` |  |  |
| top-level / `io/github/jfglzs/aca/utils/EntityUtils.java` | `` |  | getEntityPos, shouldSkip, pack |
| top-level / `io/github/jfglzs/aca/utils/RuleTranslator.java` | `` |  | getTranslationFromResourcePath |
| top-level / `io/github/jfglzs/aca/utils/ThreadUtils.java` | `` |  |  |
| top-level / `io/github/jfglzs/aca/utils/validator/GreaterThanZeroValidator.java` | `` |  | validate |
| top-level / `io/github/jfglzs/aca/utils/wrap/Cache.java` | `` |  | tick, isExpired, getValue |
| top-level / `io/github/jfglzs/aca/utils/wrap/FullSuppressBehaviorWrapper.java` | `` |  | wrap, getStatus, getRequiredMemories, tryStart, doStop, debugString, tickOrStop |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
