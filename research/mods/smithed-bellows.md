# Bellows

Review status: **Evidence inventory; behavioral review pending**

Project: [Bellows](https://modrinth.com/mod/smithed-bellows)
Selected artifact version: `1.1.1`
Published implementation source: https://github.com/Smithed-MC/Bellows
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

No-compromises drop-in optimizations for Minecraft Commands/Datapacks.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `e3aa83067cc06f26d03f607352077b04418de28a`
- `sha512`: `7a09889f543fdface6bc20489618f6c7c70de8dfa09cd4d70a4e73f4232d8c19cdd27d49c6ed562646099c5c673ae778f56c894b676b5e2178ab29c374c3af48`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 68
Reconstructed Java files: 68

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "net.smithed.bellows.Bellows"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.0",
  "fabric-api": ">=0.160.0+26.3",
  "minecraft": "26.3",
  "java": ">=25"
}
```

**accessWidener**

```json
"bellows.classTweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/smithed/bellows/Bellows.java` | `` |  | onInitialize, logDebug, logDebugFormat |
| top-level / `net/smithed/bellows/commands/ActiveBellowsDebugLogger.java` | `` |  | logDebug, logDebugFormat |
| top-level / `net/smithed/bellows/commands/BellowsCommand.java` | `` |  | register, version, debug, getBellowsNbtMode, setBellowsNbtMode, getBellowsSelectorMode, setBellowsSelectorMode, getBellowsDebugMode, setBellowsDebugMode, getBellowsBlockForceloadFix, setBellowsBlockForceloadFix |
| top-level / `net/smithed/bellows/commands/BellowsConfig.java` | `` |  |  |
| top-level / `net/smithed/bellows/commands/BellowsDebugLogger.java` | `` |  |  |
| top-level / `net/smithed/bellows/commands/EmptyBellowsDebugLogger.java` | `` |  | logDebug, logDebugFormat |
| top-level / `net/smithed/bellows/mixin/blockforceload/BlockDataAccessorMixin.java` | `value={BlockDataAccessor.class})` |  |  |
| top-level / `net/smithed/bellows/mixin/blockforceload/BlockInWorldMixin.java` | `value={BlockInWorld.class})` | WrapOperation:2 | bellows_getBlockState, bellows_getBlockEntity |
| top-level / `net/smithed/bellows/mixin/blockforceload/ExecuteCommandMixin.java` | `value={ExecuteCommand.class})` | WrapOperation:2 | bellows_checkRegions_blockState, bellows_checkRegions_blockEntity |
| top-level / `net/smithed/bellows/mixin/blockforceload/LevelMixin.java` | `value={Level.class})` |  | bellows_getBlockStateNoLoad, bellows_getBlockEntityNoLoad |
| top-level / `net/smithed/bellows/mixin/blockforceload/ServerChunkCacheMixin.java` | `value={ServerChunkCache.class})` |  | bellows_getTicketStorage |
| top-level / `net/smithed/bellows/mixin/BuildContextsMixin.java` | `value={BuildContexts.class})` | Inject:1 | bellows_execute |
| top-level / `net/smithed/bellows/mixin/nbt/DataCommandsMixin.java` | `value={DataCommands.class})` | WrapOperation:8 | bellows_getSingleTag, bellows_manipulateData_get, bellows_manipulateData_set, bellows_mergeData_get, bellows_mergeData_set, bellows_removeData_get, bellows_removeData_set, bellows_resolveSourcePath |
| top-level / `net/smithed/bellows/mixin/nbt/entity/AbstractVillagerMixin.java` | `value={AbstractVillager.class})` |  | bellows_addAdditionalSaveDataFiltered, bellows_readAdditionalSaveDataFiltered |
| top-level / `net/smithed/bellows/mixin/nbt/entity/AgeableMobMixin.java` | `value={AgeableMob.class})` |  | bellows_addAdditionalSaveDataFiltered, bellows_readAdditionalSaveDataFiltered |
| top-level / `net/smithed/bellows/mixin/nbt/entity/CopperGolemMixin.java` | `value={CopperGolem.class})` |  | getWeatherState, setWeatherState, bellows_addAdditionalSaveDataFiltered, bellows_readAdditionalSaveDataFiltered |
| top-level / `net/smithed/bellows/mixin/nbt/entity/DisplayMixin.java` | `value={Display.class})` | Inject:2 | bellows_init, bellows_culling, bellows_addAdditionalSaveDataFiltered, bellows_readAdditionalSaveDataFiltered, bellows_setTranslation, bellows_setLeftRotation, bellows_setScale, bellows_setRightRotation |
| top-level / `net/smithed/bellows/mixin/nbt/entity/EntityMixin.java` | `value={Entity.class})` | WrapOperation:2, Inject:2 | addTag, removeTag, bellows_load, bellows_load, bellows_addAdditionalSaveDataFiltered, bellows_readAdditionalSaveDataFiltered, bellows_saveWithoutIdFiltered, bellows_loadFiltered |
| top-level / `net/smithed/bellows/mixin/nbt/entity/ItemDisplayMixin.java` | `value={Display.ItemDisplay.class})` |  | bellows_addAdditionalSaveDataFiltered, bellows_readAdditionalSaveDataFiltered |
| top-level / `net/smithed/bellows/mixin/nbt/entity/ItemEntityMixin.java` | `value={ItemEntity.class})` |  | bellows_addAdditionalSaveDataFiltered, bellows_readAdditionalSaveDataFiltered |
| top-level / `net/smithed/bellows/mixin/nbt/entity/LivingEntityMixin.java` | `value={LivingEntity.class})` |  | bellows_addAdditionalSaveDataFiltered, bellows_readAdditionalSaveDataFiltered |
| top-level / `net/smithed/bellows/mixin/nbt/entity/MannequinMixin.java` | `value={Mannequin.class})` |  | getImmovable, setProfile, setImmovable, setDescription, setHideDescription, bellows_addAdditionalSaveDataFiltered, bellows_readAdditionalSaveDataFiltered |
| top-level / `net/smithed/bellows/mixin/nbt/entity/MobMixin.java` | `value={Mob.class})` |  | bellows_addAdditionalSaveDataFiltered, bellows_readAdditionalSaveDataFiltered |
| top-level / `net/smithed/bellows/mixin/nbt/entity/PlayerMixin.java` | `value={Player.class})` |  | bellows_addAdditionalSaveDataFiltered |
| top-level / `net/smithed/bellows/mixin/nbt/entity/ServerPlayerMixin.java` | `value={ServerPlayer.class})` |  | bellows_addAdditionalSaveDataFiltered |
| top-level / `net/smithed/bellows/mixin/nbt/entity/ShulkerMixin.java` | `value={Shulker.class})` |  | getAttachFace, setAttachFace, bellows_addAdditionalSaveDataFiltered, bellows_readAdditionalSaveDataFiltered |
| top-level / `net/smithed/bellows/mixin/nbt/entity/TextDisplayMixin.java` | `value={Display.TextDisplay.class})` |  | storeFlag, loadFlag, bellows_addAdditionalSaveDataFiltered, bellows_readAdditionalSaveDataFiltered |
| top-level / `net/smithed/bellows/mixin/nbt/entity/VillagerMixin.java` | `value={Villager.class})` |  | bellows_addAdditionalSaveDataFiltered, bellows_readAdditionalSaveDataFiltered |
| top-level / `net/smithed/bellows/mixin/nbt/entity/WanderingTraderMixin.java` | `value={WanderingTrader.class})` |  | bellows_addAdditionalSaveDataFiltered, bellows_readAdditionalSaveDataFiltered |
| top-level / `net/smithed/bellows/mixin/nbt/EntityDataAccessorMixin.java` | `value={EntityDataAccessor.class})` |  | bellows_getDataFiltered, bellows_setDataFiltered, bellows_getContents |
| top-level / `net/smithed/bellows/mixin/nbt/EntitySelectorOptionsMixin.java` | `value={EntitySelectorOptions.class})` | Inject:1 | bellows_nbt |
| top-level / `net/smithed/bellows/mixin/nbt/ExecuteCommandMixin.java` | `value={ExecuteCommand.class})` | WrapOperation:3 | bellows_checkMatchingData, bellows_storeData_getData, bellows_storeData_setData |
| top-level / `net/smithed/bellows/mixin/nbt/inventory/InventoryMixin.java` | `value={Inventory.class})` |  |  |
| top-level / `net/smithed/bellows/mixin/nbt/inventory/PlayerEnderChestContainerMixin.java` | `value={PlayerEnderChestContainer.class})` |  |  |
| top-level / `net/smithed/bellows/mixin/nbt/NbtPredicateMixin.java` | `value={NbtPredicate.class})` | WrapOperation:1 | bellows_getEntityTagToCompare |
| top-level / `net/smithed/bellows/mixin/nbt/quick_data/CompoundTagArgumentMixin.java` | `value={CompoundTagArgument.class})` | ModifyReturnValue:1 | bellows_parse |
| top-level / `net/smithed/bellows/mixin/nbt/quick_data/CompoundTagMixin.java` | `value={CompoundTag.class})` | Inject:1 | bellows_merge, bellows_precompileQuickActions, bellows_getQuickActions |
| top-level / `net/smithed/bellows/mixin/selector/EntityLookupMixin.java` | `value={EntityLookup.class})` | Inject:2 | bellows_add, bellows_remove, bellows_addEntityToTagMap, bellows_removeEntityFromTagMap, bellows_getTaggedEntities, bellows_getEntities |
| top-level / `net/smithed/bellows/mixin/selector/EntityMixin.java` | `value={Entity.class})` | Inject:1 | bellows_init, bellows_getEncodeId |
| top-level / `net/smithed/bellows/mixin/selector/EntitySelectorMixin.java` | `value={EntitySelector.class})` | Inject:1 | bellows_setContainer |
| top-level / `net/smithed/bellows/mixin/selector/EntitySelectorOptionsMixin.java` | `value={EntitySelectorOptions.class})` | Inject:3 | bellows_bootstrap_typeTag, bellows_bootstrap_type, bellows_bootstrap_tag |
| top-level / `net/smithed/bellows/mixin/selector/EntitySelectorParserMixin.java` | `value={EntitySelectorParser.class})` | Inject:1 | bellows_parse, bellows_getSelectorContainer |
| top-level / `net/smithed/bellows/mixin/selector/LevelEntityGetterAdapterMixin.java` | `value={LevelEntityGetterAdapter.class})` |  | bellows_getVisibleEntities |
| top-level / `net/smithed/bellows/mixin/selector/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Inject:2 | bellows_init, bellows_reloadResources, bellows_constructEntityTypes, bellows_getEntityTagEntries |
| top-level / `net/smithed/bellows/mixin/selector/moonrise/MoonriseEntityLookupMixin.java` | `value={EntityLookup.class})` | Inject:2 | bellows_addEntity, bellows_removeEntity, bellows_addEntityToTagMap, bellows_removeEntityFromTagMap, bellows_getTaggedEntities, bellows_getEntities, bellows_getVisibleEntities |
| top-level / `net/smithed/bellows/mixin/selector/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:1 | bellows_tryAddFreshEntityWithPassengers, bellows_getEntityIndex, bellows_getEntities |
| top-level / `net/smithed/bellows/mixin_interface/blockforceload/LevelExtender.java` | `` |  |  |
| top-level / `net/smithed/bellows/mixin_interface/blockforceload/ServerChunkCacheExtender.java` | `` |  |  |
| top-level / `net/smithed/bellows/mixin_interface/nbt/CompoundTagExtender.java` | `` |  |  |
| top-level / `net/smithed/bellows/mixin_interface/nbt/DisplayEntityExtender.java` | `` |  |  |
| top-level / `net/smithed/bellows/mixin_interface/nbt/EnderChestInventoryExtender.java` | `` |  |  |
| top-level / `net/smithed/bellows/mixin_interface/nbt/EntityDataAccessorExtender.java` | `` |  |  |
| top-level / `net/smithed/bellows/mixin_interface/nbt/EntityExtender.java` | `` |  |  |
| top-level / `net/smithed/bellows/mixin_interface/nbt/FilteredNbtAccessExtender.java` | `` |  |  |
| top-level / `net/smithed/bellows/mixin_interface/nbt/PlayerInventoryExtender.java` | `` |  |  |
| top-level / `net/smithed/bellows/mixin_interface/selector/EntityExtender.java` | `` |  |  |
| top-level / `net/smithed/bellows/mixin_interface/selector/EntityLookupExtender.java` | `` |  |  |
| top-level / `net/smithed/bellows/mixin_interface/selector/EntitySelectorExtender.java` | `` |  |  |
| top-level / `net/smithed/bellows/mixin_interface/selector/EntitySelectorParserExtender.java` | `` |  |  |
| top-level / `net/smithed/bellows/mixin_interface/selector/LevelEntityGetterAdapterExtender.java` | `` |  |  |
| top-level / `net/smithed/bellows/mixin_interface/selector/MinecraftServerExtender.java` | `` |  |  |
| top-level / `net/smithed/bellows/mixin_interface/selector/ServerLevelExtender.java` | `` |  |  |
| top-level / `net/smithed/bellows/MixinConfig.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, isMoonriseLoaded, acceptTargets, getMixins, preApply, postApply |
| top-level / `net/smithed/bellows/utils/ContextMutation.java` | `` |  | getBlockEntity, getFilteredNbt, isPathSelectedItem |
| top-level / `net/smithed/bellows/utils/MixinShortcuts.java` | `` |  | getData, setData, getBlockState, getBlockEntity |
| top-level / `net/smithed/bellows/utils/NBTUtils.java` | `` |  | getSlot, getTopLevelPaths, getTopLevelPaths |
| top-level / `net/smithed/bellows/utils/QuickActions.java` | `` |  | computeQuickActions, hasQuickActions, getQuickActionTags, getQuickActions, merge |
| top-level / `net/smithed/bellows/utils/SelectorContainer.java` | `` |  | toString |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
