# FixMCStats

Review status: **Evidence inventory; behavioral review pending**

Project: [FixMCStats](https://modrinth.com/mod/fixmcstats)
Selected artifact version: `fabric-2.5.0`
Published implementation source: https://github.com/elmital/FixMCStats
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Mod that aims to fix multiple issues with the Minecraft statistics 🤓

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha512`: `3369025b15324d0b14625e5f8a60fdf5ed5300ead20001497d6f0b7ba64563ea2c2cc2047f5ed7e3022b0a08d11072cc6d568a6c73e14efaf347a52e007b58a8`
- `sha1`: `739fd20e080dcb52c8d90625336c53de2a71cbb8`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 50
Reconstructed Java files: 41

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "be.elmital.fixmcstats.FixMcStats"
  ],
  "client": [
    "be.elmital.fixmcstats.FixMcStatsClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `be/elmital/fixmcstats/BasicCommand.java` | `` |  | commandNodeBuilder, notifySource, pathAction, getPathAction, patchArgument, getPatch, parse, getExamples, generateExamples, listSuggestions |
| top-level / `be/elmital/fixmcstats/CommonClass.java` | `` |  | init |
| top-level / `be/elmital/fixmcstats/Config.java` | `` |  | instance, initConfig, getConfigDirectoryPath, getConfigPath, updateConfig, removeFromConfig |
| top-level / `be/elmital/fixmcstats/Configs.java` | `` |  | getValidConfigEntries, getAllPatchConfigEntries, getAllValidPatchConfigEntries, registerEntry, getKey, getDefault, isAPatchConfig, getPatchId, getPatchLink, isExperimental, isDeprecated, isActive, requireRestart |
| top-level / `be/elmital/fixmcstats/Constants.java` | `` |  |  |
| top-level / `be/elmital/fixmcstats/FixMcStats.java` | `` |  | onInitialize |
| top-level / `be/elmital/fixmcstats/FixMcStatsClient.java` | `` |  | onInitializeClient, sendClientFeedBack |
| top-level / `be/elmital/fixmcstats/mixin/ArmorStandEntityMixin.java` | `value={ArmorStand.class})` | Inject:1 | equipEntity |
| top-level / `be/elmital/fixmcstats/mixin/BlockMixin.java` | `value={Block.class})` | ModifyArg:1 | modifyStat |
| top-level / `be/elmital/fixmcstats/mixin/BlocksAttacksFabricMixin.java` | `value={net.minecraft.world.item.component.BlocksAttacks.class})` | Redirect:1 | awardingStat |
| top-level / `be/elmital/fixmcstats/mixin/CampfireBlockEntityMixin.java` | `value={CampfireBlockEntity.class})` | Inject:2 | addCookerNBT, ensureHolder |
| top-level / `be/elmital/fixmcstats/mixin/CraftingResultSlotMixin.java` | `value={ResultSlot.class})` | ModifyArg:1 | modifyIncrementedAmount |
| top-level / `be/elmital/fixmcstats/mixin/CreeperEntityMixin.java` | `value={Creeper.class})` | Inject:2 | trackIgniter, incrementDamageStat |
| top-level / `be/elmital/fixmcstats/mixin/CrossbowItemMixin.java` | `value={CrossbowItem.class})` | Inject:2 | cancelTardiveMethodCall, awardPlayer |
| top-level / `be/elmital/fixmcstats/mixin/DecoratedPotBlockMixin.java` | `value={DecoratedPotBlock.class})` | Inject:1 | breakBlock |
| top-level / `be/elmital/fixmcstats/mixin/EntityMixin.java` | `value={Entity.class})` | Inject:1 | onLanding |
| top-level / `be/elmital/fixmcstats/mixin/EntityStatsListWidgetEntryMixin.java` | `targets={"net.minecraft.client.gui.screens.achievement.StatsScreen$MobsStatisticsList$MobRow"})` | ModifyArg:1 | injected |
| top-level / `be/elmital/fixmcstats/mixin/FlowerPotBlockMixin.java` | `value={FlowerPotBlock.class})` | Inject:1 | incrementUsedStat |
| top-level / `be/elmital/fixmcstats/mixin/ForgingScreenHandlerMixin.java` | `value={ItemCombinerMenu.class})` | Invoker:2, ModifyArg:1 | modifySlot, mayPlace, onQuickCraft, mayPickup, onTake |
| top-level / `be/elmital/fixmcstats/mixin/GeneralStatsListWidgetMixin.java` | `value={StatsScreen.GeneralStatisticsList.class})` | ModifyArg:1 | sort |
| top-level / `be/elmital/fixmcstats/mixin/ItemComparatorMixin.java` | `value={StatsScreen.ItemStatisticsList.ItemRowComparator.class})` | ModifyExpressionValue:1 | compareEntries |
| top-level / `be/elmital/fixmcstats/mixin/ItemStatsListWidgetEntryMixin.java` | `value={StatsScreen.ItemStatisticsList.class})` | Inject:1 | onInit |
| top-level / `be/elmital/fixmcstats/mixin/JukeboxPlayableMixin.java` | `value={JukeboxPlayable.class})` | Inject:1 | awardRecordUseStat |
| top-level / `be/elmital/fixmcstats/mixin/LivingEntityFabricMixin.java` | `value={net.minecraft.world.entity.LivingEntity.class})` | WrapOperation:1 | incrementBreakingStat |
| top-level / `be/elmital/fixmcstats/mixin/LivingEntityMixin.java` | `value={LivingEntity.class})` | Inject:2 | incrementDamageDealtStatForProjectile, onDamage |
| top-level / `be/elmital/fixmcstats/mixin/PlaceableOnWaterItemMixin.java` | `value={PlaceOnWaterBlockItem.class})` | Inject:1 | incrementStat |
| top-level / `be/elmital/fixmcstats/mixin/PotionSlotMixin.java` | `value={BrewingStandMenu.PotionSlot.class})` | Inject:1 | onTake |
| top-level / `be/elmital/fixmcstats/mixin/PowderSnowBlockMixin.java` | `value={PowderSnowBlock.class})` | Inject:1 | incrementOnLanding |
| top-level / `be/elmital/fixmcstats/mixin/RespawnAnchorBlockMixin.java` | `value={RespawnAnchorBlock.class})` | Inject:1 | awardPlayer |
| top-level / `be/elmital/fixmcstats/mixin/ServerPlayerEntityMixin.java` | `value={ServerPlayer.class})` | Inject:3, ModifyArg:2, ModifyArgs:1, WrapWithCondition:1 | cancelIncrement, modifyTargetStat, modifyBeforeSuperTickRiding, modifyAfterSuperTickRiding, cancelStatIncrement, useCrawlStat, incrementStat |
| top-level / `be/elmital/fixmcstats/mixin/StatsAccessor.java` | `value={Stats.class})` | Accessor:1 | getCUSTOM |
| top-level / `be/elmital/fixmcstats/mixin/StonecutterScreenHandlerMixin.java` | `value={StonecutterMenu.class})` | Invoker:1, Inject:1 | injected, mayPlace, onQuickCraft, onTake, getInputStacks |
| top-level / `be/elmital/fixmcstats/mixinlogic/BlocksAttacks.java` | `` |  | checkAwardingStat |
| top-level / `be/elmital/fixmcstats/mixinlogic/LivingEntity.java` | `` |  | awardElytraBrokenStat |
| top-level / `be/elmital/fixmcstats/ModEnvironment.java` | `` |  |  |
| top-level / `be/elmital/fixmcstats/Patch.java` | `` |  | Patch, of, getPatchId, getIssueLink |
| top-level / `be/elmital/fixmcstats/platform/FabricPlatformHelper.java` | `` |  | getConfigDir, getPlatformName, isModLoaded, isDevelopmentEnvironment, isDedicatedServer, registerArgumentType |
| top-level / `be/elmital/fixmcstats/platform/services/IPlatformHelper.java` | `` |  |  |
| top-level / `be/elmital/fixmcstats/platform/Services.java` | `` |  | load |
| top-level / `be/elmital/fixmcstats/utils/LanguageBasedCollator.java` | `` |  | generateCollator |
| top-level / `be/elmital/fixmcstats/utils/StatisticUtils.java` | `` |  | register, registerAllCustomStats, CustomStatistic |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
