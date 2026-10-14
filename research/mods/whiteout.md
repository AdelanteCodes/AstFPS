# Whiteout

Review status: **Evidence inventory; behavioral review pending**

Project: [Whiteout](https://modrinth.com/mod/whiteout)
Selected artifact version: `0.21.0`
Published implementation source: https://github.com/Rektroth/Whiteout
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A Fabric implementation of the bug fixes offered by the Paper project.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `2a3a896698fc621d14d145fc4071633e306bc1e41c81a510d9342cbb7ffa063097773b2d3244a2cf6acdc3f812448726cb05aec923e55cbc289056497360f9df`
- `sha1`: `61ee0486c7143534094f139d95fb3f9c5e30b808`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 61
Reconstructed Java files: 59

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "io.github.rektroth.whiteout.Whiteout"
  ]
}
```

**depends**

```json
{
  "fabricloader": "~0.19.0",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

**breaks**

```json
{
  "lithium": "<0.26.1 >=0.27.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/github/rektroth/whiteout/accessors/CaptureTreeGenerationAccessor.java` | `` |  |  |
| top-level / `io/github/rektroth/whiteout/accessors/GeneratedByDragonFightAccessor.java` | `` |  |  |
| top-level / `io/github/rektroth/whiteout/config/Option.java` | `` |  | setEnabled, addModOverride, isEnabled, isOverridden, isUserDefined, isModDefined, getName, clearModsDefiningValue, getDefiningMods |
| top-level / `io/github/rektroth/whiteout/config/WhiteoutConfig.java` | `` |  | load, addMixinRule, readProperties, applyModOverrides, applyModOverride, getEffectiveOptionForMixin, writeDefaultConfig, getOptionCount, getOptionOverrideCount, isCompatMixin, getCompatMod |
| top-level / `io/github/rektroth/whiteout/mixin/breakingpermablocks/BlockBehaviourMixin.java` | `value={BlockBehaviour.class})` | Redirect:1, Inject:1 | isNotAirAndIsDestroyable, canOnlyBeReplacedIfDestroyable |
| top-level / `io/github/rektroth/whiteout/mixin/breakingpermablocks/BlockStateBaseMixin.java` | `value={BlockBehaviour.BlockStateBase.class})` | Inject:1 | blockIfPermanent |
| top-level / `io/github/rektroth/whiteout/mixin/breakingpermablocks/DispenseItemBehaviorMixin.java` | `value={DispenseItemBehavior.class})` | Redirect:1 | captureTreeGeneration, execute |
| top-level / `io/github/rektroth/whiteout/mixin/breakingpermablocks/ItemStackMixin.java` | `value={ItemStack.class})` | Inject:2 | captureTreeGeneration, captureTreeGeneration |
| top-level / `io/github/rektroth/whiteout/mixin/breakingpermablocks/LevelMixin.java` | `value={Level.class})` | Inject:1 | whiteout$setCaptureTreeGeneration, whiteout$getCaptureTreeGeneration, checkReplacePermaBlock |
| top-level / `io/github/rektroth/whiteout/mixin/breakingpermablocks/PistonBaseBlockMixin.java` | `value={PistonBaseBlock.class})` | Inject:1, Redirect:1 | cancelIfWrongDirection, removeBlockIfNotPermanent |
| top-level / `io/github/rektroth/whiteout/mixin/breakingpermablocks/PortalForcerMixin.java` | `value={PortalForcer.class})` | Inject:1 | doNotReplacePermanentBlock |
| top-level / `io/github/rektroth/whiteout/mixin/breakingpermablocks/SaplingBlockMixin.java` | `value={SaplingBlock.class})` | Redirect:1 | doNotDestroyPermanentBlocksWhenGrowing |
| top-level / `io/github/rektroth/whiteout/mixin/breakingpermablocks/ServerExplosionMixin.java` | `value={ServerExplosion.class})` | Redirect:1 | addIfDestroyable |
| top-level / `io/github/rektroth/whiteout/mixin/mc108513/EndCrystalMixin.java` | `value={EndCrystal.class})` | Inject:3 | whiteout$setGeneratedByDragonFight, tickNotInvulnerable, writeGeneratedByDragonFightToNbt, readGeneratedByDragonFightFromNbt |
| top-level / `io/github/rektroth/whiteout/mixin/mc108513/EnderDragonFightAccessor.java` | `value={EnderDragonFight.class})` | Accessor:1 |  |
| top-level / `io/github/rektroth/whiteout/mixin/mc108513/EndSpikeFeatureMixin.java` | `value={EndSpikeFeature.class})` | Inject:1 | setGeneratedByDragonFight |
| top-level / `io/github/rektroth/whiteout/mixin/mc117075/LevelMixin.java` | `value={Level.class})` | Inject:2, Redirect:1 | instantiateToRemove, addToRemove, removeAll |
| top-level / `io/github/rektroth/whiteout/mixin/mc121706/RangedBowAttackGoalMixin.java` | `value={RangedBowAttackGoal.class})` | Redirect:1, Inject:1 | skipOriginalSetLookAt, newSetLookAt |
| top-level / `io/github/rektroth/whiteout/mixin/mc123450/ItemFrameMixin.java` | `value={ItemFrame.class})` | Redirect:1 | shouldPlaySound |
| top-level / `io/github/rektroth/whiteout/mixin/mc123848/ItemFrameMixin.java` | `value={ItemFrame.class})` |  | spawnAtLocation |
| top-level / `io/github/rektroth/whiteout/mixin/mc145260/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Inject:1 | isEnforceWhitelistAndWhitelistEnabled |
| top-level / `io/github/rektroth/whiteout/mixin/mc147659/CatSpawnMixin.java` | `value={CatSpawner.class})` | Inject:1, Redirect:1 | refreshPositionAndAnglesBeforeInitialize, skipRefreshPositionAndAngles |
| top-level / `io/github/rektroth/whiteout/mixin/mc153010/FoxMixin.java` | `value={Fox.class})` | Redirect:1 | notIsNotEmptyAndDoMobLoot |
| top-level / `io/github/rektroth/whiteout/mixin/mc153086/BeaconBlockEntityMixin.java` | `value={BeaconBlockEntity.class})` | Redirect:1 | playSoundIfNoBeam |
| top-level / `io/github/rektroth/whiteout/mixin/mc157395/ArmorStandMixin.java` | `value={ArmorStand.class})` |  | shouldDropExperience, shouldDropLoot |
| top-level / `io/github/rektroth/whiteout/mixin/mc157464/VillagerGoalPackagesMixin.java` | `value={VillagerGoalPackages.class})` | Redirect:1 | goToWantedItemFix |
| top-level / `io/github/rektroth/whiteout/mixin/mc158900/PlayerListMixin.java` | `value={PlayerList.class})` | Redirect:1 | containsAndIsNotNull |
| top-level / `io/github/rektroth/whiteout/mixin/mc163962/MerchantOfferMixin.java` | `value={MerchantOffer.class})` | Inject:1 | fixedUpdateDemandBonus |
| top-level / `io/github/rektroth/whiteout/mixin/mc167279/BeeMixin.java` | `value={Bee.class})` | Inject:1 | fixedMoveControl |
| top-level / `io/github/rektroth/whiteout/mixin/mc171420/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Redirect:1 | isAllowedOrOp |
| top-level / `io/github/rektroth/whiteout/mixin/mc177381/LocateCommandMixin.java` | `value={LocateCommand.class})` | Redirect:1 | hypot |
| top-level / `io/github/rektroth/whiteout/mixin/mc179072/SwellGoalMixin.java` | `value={SwellGoal.class})` | Inject:1 | cancelSwellIfCreativeOrSpectator |
| top-level / `io/github/rektroth/whiteout/mixin/mc188840/PistonBaseBlockMixin.java` | `value={PistonBaseBlock.class})` | Redirect:1 | createPistonHeadWithAir |
| top-level / `io/github/rektroth/whiteout/mixin/mc243057/AbstractFurnaceBlockEntityMixin.java` | `value={AbstractFurnaceBlockEntity.class})` | Inject:1 | doNotAccountFuelStack |
| top-level / `io/github/rektroth/whiteout/mixin/mc248588/LayeredCauldronBlockMixin.java` | `value={LayeredCauldronBlock.class})` | Redirect:1 | handleEntityOnFireInside, canGrief2 |
| top-level / `io/github/rektroth/whiteout/mixin/mc257487/EnderDragonFightMixin.java` | `value={EnderDragonFight.class})` | Inject:1 | fixedCustomNameCheck |
| top-level / `io/github/rektroth/whiteout/mixin/mc259832/MobEffectInstanceAccessor.java` | `value={MobEffectInstance.class})` | Accessor:1 |  |
| top-level / `io/github/rektroth/whiteout/mixin/mc259832/MobEffectInstanceMixin.java` | `value={MobEffectInstance.class})` | Overwrite:1 | downgradeToHiddenEffect |
| top-level / `io/github/rektroth/whiteout/mixin/mc262422/ServerLevelMixin.java` | `value={ServerLevel.class})` | Redirect:1 | andIsNotSpectator |
| top-level / `io/github/rektroth/whiteout/mixin/mc263999/BreakDoorGoalMixin.java` | `value={BreakDoorGoal.class})` | Inject:1, Redirect:1 | getOldDoorState, syncWorldEventWithOldDoorState |
| top-level / `io/github/rektroth/whiteout/mixin/mc264285/CreeperMixin.java` | `value={Creeper.class})` | Redirect:1 | isMaxDamageNotEqualToZero |
| top-level / `io/github/rektroth/whiteout/mixin/mc264979/SettingsMixin.java` | `value={Settings.class})` | Inject:1 | doNotLoadPropertiesIfFileDoesNotExist |
| top-level / `io/github/rektroth/whiteout/mixin/mc27056/compat/lithium/LithiumCompatExplosionImplMixin.java` | `value={ServerExplosion.class})` | Redirect:1 | getBlocksAndHeadlessPistonsToDestroy |
| top-level / `io/github/rektroth/whiteout/mixin/mc27056/ServerExplosionMixin.java` | `value={ServerExplosion.class})` | Inject:1 | destroyHeadlessPiston |
| top-level / `io/github/rektroth/whiteout/mixin/mc297169/HappyGhastMixin.java` | `value={HappyGhast.class})` | Redirect:2 | onlyPlaySoundOnMountIfNotSilenced, onlyPlaySoundOnDismountIfNotSilenced |
| top-level / `io/github/rektroth/whiteout/mixin/mc300685/WaypointCommandMixin.java` | `value={WaypointCommand.class})` | Redirect:1 | betterGetWorld |
| top-level / `io/github/rektroth/whiteout/mixin/mc301114/CombatTrackerMixin.java` | `value={CombatTracker.class})` | Inject:1 | clearExcessCombatEntries |
| top-level / `io/github/rektroth/whiteout/mixin/mc33041/DedicatedServerMixin.java` | `value={DedicatedServer.class})` | ModifyVariable:1 | handleConsoleInput, betterConsoleThread, run |
| top-level / `io/github/rektroth/whiteout/mixin/mc84789/WolfBegGoalMixin.java` | `value={BegGoal.class})` | Redirect:1 | isBoneAndNotTamed |
| top-level / `io/github/rektroth/whiteout/mixin/mc98153/PlayerListMixin.java` | `value={PlayerList.class})` | Inject:1 | resetPlayerPos |
| top-level / `io/github/rektroth/whiteout/mixin/mc99075/ServerGamePacketListenerImplMixin.java` | `value={ServerGamePacketListenerImpl.class})` | Inject:1 | fixInventoryDesync |
| top-level / `io/github/rektroth/whiteout/mixin/nethervoiddamage/compat/lithium/LithiumCompatPortalForcerMixin.java` | `value={PortalForcer.class})` | Overwrite:1, ModifyVariable:1 | findClosestPortalPosition, roofMaximum |
| top-level / `io/github/rektroth/whiteout/mixin/nethervoiddamage/EntityMixin.java` | `value={Entity.class})` | Inject:1 | attemptTickInRoofVoid |
| top-level / `io/github/rektroth/whiteout/mixin/nethervoiddamage/PortalForcerMixin.java` | `value={PortalForcer.class})` | Redirect:1, ModifyVariable:1 | filterPointsOutsideLogic, roofMaximum |
| top-level / `io/github/rektroth/whiteout/mixin/WhiteoutMixinPlugin.java` | `` |  | shouldApplyMixin, onLoad, getRefMapperConfig, acceptTargets, getMixins, preApply, postApply |
| top-level / `io/github/rektroth/whiteout/util/BeeFlyingMoveControl.java` | `` |  | tick |
| top-level / `io/github/rektroth/whiteout/util/BlockUtil.java` | `` |  | isDestroyable |
| top-level / `io/github/rektroth/whiteout/util/PortalUtil.java` | `` |  | isBelowCeiling |
| top-level / `io/github/rektroth/whiteout/Whiteout.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
