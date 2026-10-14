# Simple AutoPickup

Review status: **Evidence inventory; behavioral review pending**

Project: [Simple AutoPickup](https://modrinth.com/mod/simple-autopickup)
Selected artifact version: `1.4.17+26.3`
Published implementation source: https://github.com/lukarbonite/AutoPickup
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Instantly collect items from mined blocks directly into your inventory with the AutoPickup mod. Mob loot & more configurable!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `82683220e36940b69e783b92f675fb88e3ef8ec88b76f894fd6981ed7e7d5cef6553efba35454bf7fd25d5a88078581f63f72452371fa6350587707314e08c06`
- `sha1`: `b9bcf7e11a40923c63c4c2c4a27673c959c1f145`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 88
Reconstructed Java files: 66

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.lukarbonite.autopickup.AutoPickupFabric"
  ],
  "client": [
    "com.lukarbonite.autopickup.client.AutoPickupFabricClient"
  ],
  "modmenu": [
    "com.lukarbonite.autopickup.compat.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16.12",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/lukarbonite/autopickup/accessor/DamageTrackerAccessor.java` | `` |  |  |
| top-level / `com/lukarbonite/autopickup/AutoPickupApi.java` | `` |  | setBlockBreaker, clearBlockBreaker, getBlockBreaker, isMasterEnabled, isBlocksEnabled, isBlockXpEnabled, isMobLootEnabled, isMobXpEnabled, isSplitMobLootEnabled, isSplitMobXpEnabled, tryPickup, tryPickupFromMob, insertDrops, tryPickupBlockExperience, tryPickupMobExperience, giveExperience |
| top-level / `com/lukarbonite/autopickup/AutoPickupCommand.java` | `` |  | register, checkPermission, playerOf, executeSync, executeQueryPlayer, executeQueryGlobal, executeSetPlayerConfig, showServerStatus, formatRow, setGlobal |
| top-level / `com/lukarbonite/autopickup/AutoPickupCommon.java` | `` |  | getConfigDir, init |
| top-level / `com/lukarbonite/autopickup/AutoPickupConfig.java` | `` |  | getInstance, loadForWorld, load, save |
| top-level / `com/lukarbonite/autopickup/AutoPickupFabric.java` | `` |  | onInitialize |
| top-level / `com/lukarbonite/autopickup/AutoPickupSessions.java` | `` |  | blockAt, enterPlayerBreak, exitPlayerBreak, currentActionPlayer, begin, addBreak, addBreak, addUsePos, beginDropContext, hasDropContext, endDropContext, findOwner, findOwnerInDropContext, findOwnerByBreakPos, findOwnerInUseContext, findOwnerSameTickTight, findLinkedOwnerForBreak, openLinkedDropContext, openLinkedDropContextStrict, closeLinkedDropContext, openUseContext, closeUseContext, preRegisterFallPosition, getAndRemovePendingFallOwner, trackFallingBlock, peekFallingBlockOwner, getAndRemoveFallingBlockOwner, onServerTickEnd |
| top-level / `com/lukarbonite/autopickup/client/AutoPickupConfigScreen.java` | `` |  | create, init, keyPressed, getKeybindLabel, addClientToggle, switchTab, tick, extractRenderState, onClose |
| top-level / `com/lukarbonite/autopickup/client/AutoPickupFabricClient.java` | `` |  | onInitializeClient |
| top-level / `com/lukarbonite/autopickup/client/AutoPickupKeyBindings.java` | `` |  |  |
| top-level / `com/lukarbonite/autopickup/client/AutoPickupYACLConfigScreen.java` | `` |  | create, createKeybindOption, option, formatValue, provideWidget, setFocused, isFocused, extractRenderState, mouseClicked, keyPressed, clientBool, option, formatValue, provideWidget, setFocused, isFocused, extractRenderState, mouseClicked, createTickerOption, option, formatValue, provideWidget, setFocused, isFocused, extractRenderState, getStyle, getContents, getSiblings, getVisualOrderText |
| top-level / `com/lukarbonite/autopickup/client/ClientConfigManager.java` | `` |  | updateConnection, load, save, getProfile, isMaster, isBlocks, isBlockXp, isMobLoot, isMobXp, isSplitMobLoot, isSplitMobXp |
| top-level / `com/lukarbonite/autopickup/client/ClientNetworkManager.java` | `` |  | sendConfig |
| top-level / `com/lukarbonite/autopickup/client/ClientSyncHandler.java` | `` |  | handleDataResponse, updateClientAllowances |
| top-level / `com/lukarbonite/autopickup/client/ConfigUIUtils.java` | `` |  | updateSnapshots, requestGlobalConfig, applyAdminChanges, sendGlobal, sendPlayer, getText, fromEncoded, getText, fromState |
| top-level / `com/lukarbonite/autopickup/compat/fallingtree/FallingTreeLeafTracker.java` | `` |  | trackLeaves, trackPos, findOwner, Entry |
| top-level / `com/lukarbonite/autopickup/compat/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/lukarbonite/autopickup/compat/travelersbackpack/AutoPickupTBBridge.java` | `` |  | insertIntoTB |
| top-level / `com/lukarbonite/autopickup/core/CommandLogic.java` | `` |  | applyClientSync, isClientAllowed, playerOverrideMask, globalMask, encodeTristate, parseOverride, expandPlayerKey, setGlobal, statusRows, label |
| top-level / `com/lukarbonite/autopickup/core/Mending.java` | `` |  | repair |
| top-level / `com/lukarbonite/autopickup/core/SessionTracker.java` | `` |  | key, floor, enterPlayerBreak, exitPlayerBreak, currentActionPlayer, usable, session, begin, addBreak, addBreak, addLinkedBreakAnchor, blockAt, addUsePos, beginDropContext, hasDropContext, endDropContext, findOwner, findOwnerInDropContext, findOwnerByBreakPos, findLinkedOwnerForBreak, openLinkedDropContext, openLinkedDropContextStrict, closeLinkedDropContext, openUseContext, closeUseContext, findOwnerInUseContext, preRegisterFallPosition, getAndRemovePendingFallOwner, trackFallingBlock, peekFallingBlockOwner, getAndRemoveFallingBlockOwner, findOwnerSameTickTight, onServerTickEnd |
| top-level / `com/lukarbonite/autopickup/core/Settings.java` | `` |  | resolve, isMasterEnabled, isBlocksEnabled, isBlockXpEnabled, isMobLootEnabled, isMobXpEnabled, isSplitMobLootEnabled, isSplitMobXpEnabled |
| top-level / `com/lukarbonite/autopickup/core/Split.java` | `` |  | participants, shares |
| top-level / `com/lukarbonite/autopickup/core/XpCache.java` | `` |  | add, tick |
| top-level / `com/lukarbonite/autopickup/ExperienceCache.java` | `` |  | add, onServerTick |
| top-level / `com/lukarbonite/autopickup/LootSplittingLogic.java` | `` |  | getParticipants, distributeLoot, distributeXp |
| top-level / `com/lukarbonite/autopickup/mixin/AutoPickupMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `com/lukarbonite/autopickup/mixin/BlockDropExperienceMixin.java` | `value={Block.class})` | Inject:1 | autopickup_captureAndCacheExperience |
| top-level / `com/lukarbonite/autopickup/mixin/BlockMixin.java` | `value={Block.class})` | Inject:1 | autopickup_onDropStacks |
| top-level / `com/lukarbonite/autopickup/mixin/BlockUseWithoutItemMixin.java` | `value={ServerPlayerGameMode.class})` | Inject:2 | autopickup_openUseContext, autopickup_closeUseContext, registerColumn |
| top-level / `com/lukarbonite/autopickup/mixin/BrushableBlockMixin.java` | `value={BrushableBlockEntity.class})` | Inject:2 | autopickup_openBrushContext, autopickup_closeBrushContext |
| top-level / `com/lukarbonite/autopickup/mixin/BrushEntityMixin.java` | `value={LivingEntity.class})` | Inject:2 | autopickup_openBrushEntityContext, autopickup_closeBrushEntityContext |
| top-level / `com/lukarbonite/autopickup/mixin/compat/fallingtree/BlockBreakListenerMixin.java` | `value={BlockBreakListener.class}, remap=false)` | Inject:2 | onHead, onReturn |
| top-level / `com/lukarbonite/autopickup/mixin/compat/fallingtree/FallingAnimationHandlerMixin.java` | `value={FallingAnimationTreeBreakingHandler.class}, remap=false)` | Inject:3 | onBreakTreeHead, onFallLeafHead, onFallLeafReturn |
| top-level / `com/lukarbonite/autopickup/mixin/compat/fallingtree/FallingTreeFallingBlockMixin.java` | `value={FallingBlockEntity.class})` | Inject:2, WrapOperation:1 | onTickHead, onTickTail, wrapLandingSetBlock |
| top-level / `com/lukarbonite/autopickup/mixin/compat/fallingtree/FallingTreeLeavesDecayMixin.java` | `value={LeavesBlock.class})` | Inject:2 | autopickup_openFallingTreeContext, autopickup_closeFallingTreeContext |
| top-level / `com/lukarbonite/autopickup/mixin/compat/fallingtree/LeafBreakingHandlerMixin.java` | `value={LeafBreakingHandler.class}, remap=false)` | Inject:1 | onAddSchedule |
| top-level / `com/lukarbonite/autopickup/mixin/compat/fallingtree/LeafForceBreakerMixin.java` | `value={LeafForceBreaker.class}, remap=false)` | WrapOperation:1 | wrapLeafDropResources |
| top-level / `com/lukarbonite/autopickup/mixin/compat/fallingtree/TreeBreakingHandlerMixin.java` | `value={InstantaneousTreeBreakingHandler.class, FallingAnimationTreeBreakingHandler.class, ShiftDownTreeBreakingHandler.class}, remap=false)` | Inject:2 | onHead, onReturn |
| top-level / `com/lukarbonite/autopickup/mixin/compat/travelersbackpack/AutoPickupTBMixin.java` | `value={AutoPickupApi.class})` | WrapOperation:1 | interceptInventoryAdd, insertIntoTB |
| top-level / `com/lukarbonite/autopickup/mixin/compat/treeharvester/LeavesBlockDecayMixin.java` | `value={LeavesBlock.class})` | Inject:2 | autopickup_isDecaying, autopickup_openDecayContext, autopickup_closeDecayContext |
| top-level / `com/lukarbonite/autopickup/mixin/compat/treeharvester/natamus/AutoPickupApiMixin_TreeHarvester.java` | `value={AutoPickupApi.class}, remap=false)` | Inject:1 | onInsertDrops |
| top-level / `com/lukarbonite/autopickup/mixin/compat/treeharvester/natamus/LeafEventsMixin.java` | `value={LeafEvents.class}, remap=false)` | WrapOperation:2 | wrapDrop, wrapRandom, handle |
| top-level / `com/lukarbonite/autopickup/mixin/compat/treeharvester/natamus/LeafProcessingMixin.java` | `value={LeafProcessing.class}, remap=false)` | WrapOperation:1 | tagLeaf |
| top-level / `com/lukarbonite/autopickup/mixin/compat/treeharvester/natamus/TreeCutEventsMixin.java` | `value={TreeCutEvents.class}, remap=false)` | Inject:2, WrapOperation:1 | onHead, onReturn, wrapLogDrop |
| top-level / `com/lukarbonite/autopickup/mixin/compat/treeharvester/serilum/AutoPickupApiMixin_TreeHarvester.java` | `value={AutoPickupApi.class}, remap=false)` | Inject:1 | onInsertDrops |
| top-level / `com/lukarbonite/autopickup/mixin/compat/treeharvester/serilum/LeafEventsMixin.java` | `value={LeafEvents.class}, remap=false)` | WrapOperation:2 | wrapDrop, wrapRandom, handle |
| top-level / `com/lukarbonite/autopickup/mixin/compat/treeharvester/serilum/LeafProcessingMixin.java` | `value={LeafProcessing.class}, remap=false)` | WrapOperation:1 | tagLeaf |
| top-level / `com/lukarbonite/autopickup/mixin/compat/treeharvester/serilum/TreeCutEventsMixin.java` | `value={TreeCutEvents.class}, remap=false)` | Inject:2, WrapOperation:1 | onHead, onReturn, wrapLogDrop |
| top-level / `com/lukarbonite/autopickup/mixin/DamageTrackerMixin.java` | `value={LivingEntity.class})` | Inject:1 | autopickup_addAttacker, autopickup_getAttackers, autopickup_onDamage |
| top-level / `com/lukarbonite/autopickup/mixin/ExperienceOrbAwardMixin.java` | `value={ExperienceOrb.class})` | Inject:1 | autopickup_captureVeinMinerXp |
| top-level / `com/lukarbonite/autopickup/mixin/FabricMixinPlugin.java` | `` |  | shouldApplyMixin, classExists, onLoad, getRefMapperConfig, acceptTargets, getMixins, preApply, postApply |
| top-level / `com/lukarbonite/autopickup/mixin/ItemFrameMixin.java` | `value={ItemFrame.class})` | Inject:2 | autopickup_openFrameContext, autopickup_closeFrameContext |
| top-level / `com/lukarbonite/autopickup/mixin/LevelBreakBlockMixin.java` | `value={Level.class})` | Inject:2 | autopickup_openLinkedContext, autopickup_closeLinkedContext |
| top-level / `com/lukarbonite/autopickup/mixin/MobLootMixin.java` | `value={LivingEntity.class})` | Inject:1, WrapOperation:1 | autopickup_onDropLoot, autopickup_redirectExperience |
| top-level / `com/lukarbonite/autopickup/mixin/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:2 | autopickup_interceptItemSpawns, autopickup_cleanupDelayedSpawns |
| top-level / `com/lukarbonite/autopickup/mixin/ServerPlayerGameModeMixin.java` | `value={ServerPlayerGameMode.class})` | Inject:2 | autopickup_onTryBreakBlock, autopickup_onBreakBlockReturn |
| top-level / `com/lukarbonite/autopickup/mixin/ServerTickMixin.java` | `value={MinecraftServer.class})` | Inject:1 | onServerTickEnd |
| top-level / `com/lukarbonite/autopickup/mixin/ShearMixin.java` | `value={Mob.class})` | Inject:2 | autopickup_openShearContext, autopickup_closeShearContext |
| top-level / `com/lukarbonite/autopickup/platform/FabricPlatformHelper.java` | `` |  | getConfigDir, isModLoadedEarly |
| top-level / `com/lukarbonite/autopickup/platform/PlatformHelper.java` | `` |  | get |
| top-level / `com/lukarbonite/autopickup/platform/VersionHelper.java` | `` |  |  |
| top-level / `com/lukarbonite/autopickup/platform/VersionHelperImpl.java` | `` |  | hasMending, isArmorOrHandSlot, isOp, getLevel, getInventory, literal, sendSuccess |
| top-level / `com/lukarbonite/autopickup/PlayerConfigs.java` | `` |  | getState, loadForWorld, setClientPreference, setAdminOverride, load, save |
| top-level / `com/lukarbonite/autopickup/util/OwnedBlockPos.java` | `` |  | getOwnerUUID |
| top-level / `com/lukarbonite/autopickup/WorldConfigs.java` | `` |  | load |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
