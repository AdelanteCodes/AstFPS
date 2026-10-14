# Pack Tools

Review status: **Evidence inventory; behavioral review pending**

Project: [Pack Tools](https://modrinth.com/mod/pack-tools)
Selected artifact version: `1.26.6.2`
Published implementation source: https://github.com/frikinjay/pack-tools
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Qol tweaks, utilities and features for modpacks, servers and singleplayer.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `b9db9d0805c82a1bbc988e73eebb0e5980d0bf2e`
- `sha512`: `6fda72ccdd6021e8878a43584f1eedfdc426e3c70e4d59185732080035759178a8afbadd7dfd477f1506e6cc721a7a78da14e380cd5bb39a8bf1541d79da5686`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 130
Reconstructed Java files: 110

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "preLaunch": [
    "com.frikinjay.packtools.fabric.PackToolsPreLaunch"
  ],
  "main": [
    "com.frikinjay.packtools.fabric.PackToolsFabric"
  ],
  "client": [
    "com.frikinjay.packtools.fabric.client.PackToolsFabricClient"
  ],
  "server": [
    "com.frikinjay.packtools.fabric.PackToolsServer"
  ],
  "fabric-datagen": [],
  "modmenu": [
    "com.frikinjay.packtools.integration.fabric.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.6",
  "minecraft": ">=26.1",
  "java": ">=25",
  "fabric-api": "*"
}
```

**accessWidener**

```json
"packtools.classtweaker"
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/cloth-config-fabric-26.1.154.jar` | 625 | `cloth-config` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `architectury_inject_packtools_common_3f9a452db07643468dd0d4aa620b339b_9d316213cd7582ff8526fd41e0fdd6f09973e840959c794df867e10335bd5264PackTools261xcommon12662devjar/PlatformMethods.java` | `` |  | getCurrentTarget |
| top-level / `com/frikinjay/packtools/client/features/armorhud/ClientArmorHudHelper.java` | `` |  | renderArmorHud, renderArmorIcons, getArmorHudHeight |
| top-level / `com/frikinjay/packtools/client/features/effectshud/ClientEffectsHudHelper.java` | `` |  | renderEffectsHud, renderEffectIcons, renderEffectIcon, getEffectsHudHeight |
| top-level / `com/frikinjay/packtools/client/features/effectstooltips/ClientEffectsTooltipHelper.java` | `` |  | createClientComponent, createMultiComponent, calculateEffectWidth, toRomanNumeral, calculateMaxWidth, formatDuration |
| top-level / `com/frikinjay/packtools/client/features/foodtooltips/ClientFoodTooltipHelper.java` | `` |  | createClientComponent, createMultiComponent, calculateWidth, formatValue |
| top-level / `com/frikinjay/packtools/client/features/healthhud/ClientHealthHudHelper.java` | `` |  | renderHealthOverlay, renderHealthIcons, getFullHeartTexture, getHalfHeartTexture, getColorName |
| top-level / `com/frikinjay/packtools/client/features/mouseandkeytweaks/ClientMouseAndKeysTweaksHelper.java` | `` |  | onMousePressed, onMouseReleased, onRender, isCreativeInfiniteSlot, areDifferentInventoryAreas, onMouseScrolled, moveSingleItemOut, moveSingleItemIn, findTargetSlot, onMouseMiddleClicked, sortContainer |
| top-level / `com/frikinjay/packtools/client/features/quickzoom/QuickZoomHelper.java` | `` |  | createZoomKey, modifyFov, handleScroll, shouldPreventHotbarScroll, handleZoomStateChange, updateMouseSensitivity |
| top-level / `com/frikinjay/packtools/client/features/restocker/ClientRestockerHelper.java` | `` |  | setProcessingServerUpdate, isProcessingServerUpdate, scheduleRestockChecked, scheduleRestockUnchecked, performRestock, clear, RestockAction, sendPacketToServer, findReplacementWithSlot, areStacksCompatible, areComponentsEqual, ReplacementResult |
| top-level / `com/frikinjay/packtools/client/features/restorehud/ClientRestoreHudHelper.java` | `` |  | renderHealthRestoreOverlay, renderFoodRestoreOverlay, getConsumableItem, calculateHealthRegeneration, getPulsingAlpha, renderHealthRestoreIcons, renderFoodRestoreIcons, getFullHeartTexture, getHalfHeartTexture, getVanillaFullHeartTexture, getVanillaHalfHeartTexture, getColorName |
| top-level / `com/frikinjay/packtools/client/features/toughnesshud/ClientToughnessHudHelper.java` | `` |  | renderToughnessHud, renderToughnessIcons, getToughnessHudHeight |
| top-level / `com/frikinjay/packtools/client/gui/PTConfigScreen.java` | `` |  | init, extractBackground, extractRenderState, renderBanner, renderScrollbar, mouseScrolled, mouseClicked, mouseReleased, mouseDragged, getMaxScroll, onClose, formatName, createWidget, updatePosition, renderLabel, getButtonText, createWidget, updatePosition, renderLabel, createWidget, updatePosition, renderLabel, extractContents, renderNineSlice, renderRepeatingTexture |
| top-level / `com/frikinjay/packtools/client/PackToolsClient.java` | `` |  |  |
| top-level / `com/frikinjay/packtools/client/util/ClientEffectsTooltip.java` | `` |  | getHeight, getWidth, extractImage, renderColoredBackground, renderPotionIcon, renderEffectText, formatEffectText, toRomanNumeral, formatDuration, getEffectTextColor |
| top-level / `com/frikinjay/packtools/client/util/ClientFoodTooltip.java` | `` |  | getHeight, getWidth, extractImage, formatValue |
| top-level / `com/frikinjay/packtools/client/util/ConfigButtonHelper.java` | `` |  | createConfigButton, extractContents |
| top-level / `com/frikinjay/packtools/client/util/ConfigKeybindHelper.java` | `` |  | createConfigKey, handleKeybinds |
| top-level / `com/frikinjay/packtools/client/util/HudPositionManager.java` | `` |  | calculateLayout, shouldShowAirBubbles, getPlayerVehicleWithHealth, getVehicleHealthRows, getToughnessHudHeight, calculateEffectsHeight, getYPositionAboveEffects, isVehicleHealthVisible, areAirBubblesVisible, getRightSideVerticalOffset, getBaseHudY, getLeftHudX, getRightHudX, getDebugInfo |
| top-level / `com/frikinjay/packtools/client/util/MultiTooltip.java` | `` |  | getHeight, getWidth, extractImage |
| top-level / `com/frikinjay/packtools/config/ConfigEntry.java` | `` |  | getName, getComment, getCategory, getDefaultValue, getValue, setValue, getType, getMinValue, getMaxValue, hasRange |
| top-level / `com/frikinjay/packtools/config/ConfigManager.java` | `` |  | init, loadFromFile, save, reload, getConfigPath |
| top-level / `com/frikinjay/packtools/config/ConfigRegistry.java` | `` |  | register, getAllEntries, getEntry, getBooleanEntries, getIntegerEntries |
| top-level / `com/frikinjay/packtools/fabric/client/PackToolsFabricClient.java` | `` |  | onInitializeClient |
| top-level / `com/frikinjay/packtools/fabric/mixin/client/features/hud/FabricGuiMixin.java` | `value={Gui.class})` | ModifyVariable:1 | packtools$limitMaxHealthForRendering |
| top-level / `com/frikinjay/packtools/fabric/network/PTNetworkingFabric.java` | `` |  | init |
| top-level / `com/frikinjay/packtools/fabric/network/PTServerNetworkingFabric.java` | `` |  | init |
| top-level / `com/frikinjay/packtools/fabric/PackToolsFabric.java` | `` |  | onInitialize |
| top-level / `com/frikinjay/packtools/fabric/PackToolsPreLaunch.java` | `` |  | onPreLaunch |
| top-level / `com/frikinjay/packtools/fabric/PackToolsServer.java` | `` |  | onInitializeServer |
| top-level / `com/frikinjay/packtools/features/betterdoors/BetterDoorsHelper.java` | `` |  | isWalkthroughDoor, getEmptyShape |
| top-level / `com/frikinjay/packtools/features/clumped/ClumpedOrbHandler.java` | `` |  | getClumpedMap, setClumpedMap, resolve, processPlayerPickup, captureRepairItem, calculateRepairAndRemainingXp, mergeWith, tryMergeToExisting, saveToNBT, loadFromNBT |
| top-level / `com/frikinjay/packtools/features/clumped/IClumpedOrb.java` | `` |  |  |
| top-level / `com/frikinjay/packtools/features/defaultoverrides/DefaultFilesManager.java` | `` |  | initialize, processDefaultFiles, processWorldDefaults, visitFile, preVisitDirectory, processAllWorldDefaults, createDirectories, ensureBackupFolderExists, cleanupOldBackups, deleteDirectory, visitFile, postVisitDirectory, filesAreIdentical, calculateFileHash, processGlobalReplacements, visitFile, preVisitDirectory, backupAndReplace, onWorldLoad, onGameStart |
| top-level / `com/frikinjay/packtools/features/doubledoors/DoubleDoorsHelper.java` | `` |  | getMatchingDoor, updateFenceGates |
| top-level / `com/frikinjay/packtools/features/durabilitytooltips/DurabilityTooltipHelper.java` | `` |  | createDurabilityTooltip, getDurabilityColor |
| top-level / `com/frikinjay/packtools/features/easyharvest/EasyHarvestHelper.java` | `` |  | harvestCrop, harvestTallPlant, radiusHarvest, isMatureCrop, getResetState, getHoeRadius |
| top-level / `com/frikinjay/packtools/features/effectshud/EffectsHudHelper.java` | `` |  | getActiveEffects, calculateRowCount, periodicCleanup, cleanupPlayer, clearAllTracking |
| top-level / `com/frikinjay/packtools/features/effectstooltips/EffectsTooltipHelper.java` | `` |  | extractEffects, injectEffectsTooltip |
| top-level / `com/frikinjay/packtools/features/elytrareplenisher/ElytraReplenisherHelper.java` | `` |  | getExecutor, chunkKey, indexShip, checkPlayerInsideShip, checkStructureAsync, processStructureStart, findDragonHeadFloodFill, scanBoundingBoxForDragonHead, registerNewShip, processReplenishment, replenishTreasures, createStructuredPos, save, load, shutdown |
| top-level / `com/frikinjay/packtools/features/foodtooltips/FoodTooltipHelper.java` | `` |  | injectFoodTooltip |
| top-level / `com/frikinjay/packtools/features/jumpover/JumpOverHelper.java` | `` |  | nearJumpableBlock |
| top-level / `com/frikinjay/packtools/features/modnametooltips/ModNameTooltipHelper.java` | `` |  | createModNameTooltip |
| top-level / `com/frikinjay/packtools/features/packloader/PackLoaderConfig.java` | `` |  | setCustomPaths |
| top-level / `com/frikinjay/packtools/features/packloader/PackLoaderHelper.java` | `` |  | loadPacks, findValidPacks, isValidPack, applyOrdering, createPack, createResourcesSupplier, initializeOrderingFile |
| top-level / `com/frikinjay/packtools/features/packloader/PackToolsPackRepositorySource.java` | `` |  | loadPacks |
| top-level / `com/frikinjay/packtools/features/quickplace/QuickPlaceHelper.java` | `` |  | tick, getValidHand, performRaycast, findPlacementTarget, findVerticalTarget, findHorizontalTarget, isTopSlab, isBottomSlab, getCurrentTarget, getDisplayTicks, hasActiveTarget, canPlace, getClickedBlock, createPlacementHit, isVertical, getTargetHand, shouldAttemptQuickPlace, PlacementTarget, RaycastKey, equals, hashCode |
| top-level / `com/frikinjay/packtools/features/quickplace/QuickPlaceRenderer.java` | `` |  | render2D, render3D |
| top-level / `com/frikinjay/packtools/features/restocker/RestockerHelper.java` | `` |  | processRestock, checkRateLimit, validatePacketStructure, validateReturnItem, validateInventoryState, executeRestock, cleanupRateLimits, removePlayerRateLimit |
| top-level / `com/frikinjay/packtools/features/stackmaxxer/StackMaxxerHelper.java` | `` |  | getModifiedStackSize |
| top-level / `com/frikinjay/packtools/features/swingthrough/SwingThroughHelper.java` | `` |  | isSwingThroughBlock, isTransparentBlock, isValidTarget |
| top-level / `com/frikinjay/packtools/features/tagtooltips/TagTooltipsHelper.java` | `` |  | getTagComponents, getItemTags, getBlockTags, formatTag |
| top-level / `com/frikinjay/packtools/integration/fabric/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/frikinjay/packtools/mixin/client/features/experimental/LifecycleMixin.java` | `value={Lifecycle.class})` | WrapMethod:1 | packTools$disableExperimentalMessage |
| top-level / `com/frikinjay/packtools/mixin/client/features/hud/GuiMixin.java` | `value={Gui.class})` | Inject:4 | packtools$renderCustomHud, packtools$renderHealthOverlay, packtools$renderFoodRestoreOverlay, packtools$cancelVanillaArmor |
| top-level / `com/frikinjay/packtools/mixin/client/features/mouseandkeytweaks/AbstractContainerScreenAccessor.java` | `value={AbstractContainerScreen.class})` | Accessor:1 |  |
| top-level / `com/frikinjay/packtools/mixin/client/features/mouseandkeytweaks/AbstractContainerScreenMixin.java` | `value={AbstractContainerScreen.class})` | Inject:4 | packtools$onMouseClicked, packtools$onMouseReleased, packtools$onRender, packtools$onMouseScrolled |
| top-level / `com/frikinjay/packtools/mixin/client/features/mouseandkeytweaks/InventoryScreenMixin.java` | `value={InventoryScreen.class})` | Inject:1 | packtools$onRenderInventory |
| top-level / `com/frikinjay/packtools/mixin/client/features/ping/AccessibilityOnboardingScreenMixin.java` | `value={AccessibilityOnboardingScreen.class})` | Inject:1 | packTools$accessibilityScreenPing |
| top-level / `com/frikinjay/packtools/mixin/client/features/ping/TitleScreenMixin.java` | `value={TitleScreen.class})` | Inject:1 | packTools$accessibilityScreenPing |
| top-level / `com/frikinjay/packtools/mixin/client/features/quickplace/GuiMixin.java` | `value={Gui.class})` | Inject:1 | packtools$renderQuickPlaceIndicator |
| top-level / `com/frikinjay/packtools/mixin/client/features/quickplace/LevelRendererMixin.java` | `value={LevelRenderer.class})` |  |  |
| top-level / `com/frikinjay/packtools/mixin/client/features/quickplace/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | packtools$updateQuickPlace |
| top-level / `com/frikinjay/packtools/mixin/client/features/quickplace/MultiPlayerGameModeMixin.java` | `value={MultiPlayerGameMode.class})` | Inject:1 | packtools$quickPlaceOnUseItem |
| top-level / `com/frikinjay/packtools/mixin/client/features/quickzoom/CameraMixin.java` | `value={Camera.class})` | ModifyReturnValue:1 | packtools$modifyFovForZoom |
| top-level / `com/frikinjay/packtools/mixin/client/features/quickzoom/GameRendererMixin.java` | `value={GameRenderer.class})` |  |  |
| top-level / `com/frikinjay/packtools/mixin/client/features/quickzoom/MouseHandlerMixin.java` | `value={MouseHandler.class})` | Inject:1, WrapWithCondition:1 | packtools$onMouseScroll, packtools$preventHotbarScrollOnZoom |
| top-level / `com/frikinjay/packtools/mixin/client/features/quickzoom/OptionsMixin.java` | `value={Options.class})` | Inject:1 | packtools$onInit |
| top-level / `com/frikinjay/packtools/mixin/client/features/restocker/AbstractContainerMenuMixin.java` | `value={AbstractContainerMenu.class})` | Inject:4 | packtools$scheduleRestockOnSlotUpdate, packtools$performRestockAfterSlotUpdate, packtools$markServerUpdateStart, packtools$markServerUpdateEnd |
| top-level / `com/frikinjay/packtools/mixin/client/features/restocker/LivingEntityMixin.java` | `value={LivingEntity.class})` | Inject:2, ModifyVariable:1 | packtools$captureBeforeConsume, packtools$captureFinishResult, packtools$restockAfterConsume |
| top-level / `com/frikinjay/packtools/mixin/client/features/restocker/LocalPlayerMixin.java` | `value={LocalPlayer.class})` | Inject:3 | packtools$clearOnScreenClose, packtools$captureBeforeDrop, packtools$restockAfterDrop |
| top-level / `com/frikinjay/packtools/mixin/client/features/restocker/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:2 | packtools$captureBeforeUse, packtools$restockAfterUse |
| top-level / `com/frikinjay/packtools/mixin/client/features/swingthrough/LocalPlayerMixin.java` | `value={LocalPlayer.class})` | Inject:2, WrapOperation:2 | packtools$clearStashOnStart, packtools$allowPickThroughTransparent, packtools$applyEnhancedFilter, packtools$restoreBlockHitIfNoEntity |
| top-level / `com/frikinjay/packtools/mixin/client/features/tutorial/ToastManagerMixin.java` | `value={ToastManager.class})` | Inject:1 | packtools$addToast |
| top-level / `com/frikinjay/packtools/mixin/client/util/configbutton/TitleScreenMixin.java` | `value={TitleScreen.class})` | Inject:1 | packtools$addCustomButton |
| top-level / `com/frikinjay/packtools/mixin/client/util/keyboard/KeyMappingMixin.java` | `value={KeyMapping.class})` | Inject:1 | packtools$addCtrlModifierText |
| top-level / `com/frikinjay/packtools/mixin/client/util/keyboard/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | packtools$checkConfigKeybind |
| top-level / `com/frikinjay/packtools/mixin/client/util/keyboard/OptionsMixin.java` | `value={Options.class})` | Inject:1 | packtools$onInit |
| top-level / `com/frikinjay/packtools/mixin/features/betterdoors/BlockBehaviourMixin.java` | `value={BlockBehaviour.class})` | Inject:1 | packtools$removeOpenDoorCollision |
| top-level / `com/frikinjay/packtools/mixin/features/clumped/ExperienceOrbMixin.java` | `value={ExperienceOrb.class}, priority=1001)` | Inject:8, ModifyVariable:1 | packtools$clumpedEnabled, packtools$handler, packtools$canMerge, packtools$canMergeStatic, packtools$playerTouch, packtools$captureRepairItem, packtools$repairPlayerItems, packtools$merge, packtools$tryMergeToExisting, packtools$addAdditionalSaveData, packtools$readAdditionalSaveData, packtools$getHandler, packtools$getAge, packtools$setAge, packtools$setCount |
| top-level / `com/frikinjay/packtools/mixin/features/defaultoverrides/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Inject:1 | packtools$beforeWorldsLoad |
| top-level / `com/frikinjay/packtools/mixin/features/doubledoors/DoorBlockMixin.java` | `value={DoorBlock.class})` | Inject:2 | packtools$onPlayerInteract, packtools$onEntityInteract |
| top-level / `com/frikinjay/packtools/mixin/features/doubledoors/FenceGateBlockMixin.java` | `value={FenceGateBlock.class})` | Inject:1 | packtools$onGateInteract |
| top-level / `com/frikinjay/packtools/mixin/features/dragonegg/EnderDragonFightMixin.java` | `value={EnderDragonFight.class})` | Inject:1 | packTools$spawnDragonEgg |
| top-level / `com/frikinjay/packtools/mixin/features/easyharvest/BlockBehaviourMixin.java` | `value={BlockBehaviour.class}, priority=900)` | Inject:1 | packtools$onUseWithoutItem |
| top-level / `com/frikinjay/packtools/mixin/features/easyharvest/CropBlockAccessor.java` | `value={CropBlock.class})` | Invoker:1 |  |
| top-level / `com/frikinjay/packtools/mixin/features/elytrareplenisher/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Inject:3 | packtools$onStart, packtools$onSave, packtools$onStop |
| top-level / `com/frikinjay/packtools/mixin/features/elytrareplenisher/ServerPlayerMixin.java` | `value={ServerPlayer.class})` | Inject:1 | packtools$onTick |
| top-level / `com/frikinjay/packtools/mixin/features/globalsounds/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:1 | packTools$disableGlobalSounds |
| top-level / `com/frikinjay/packtools/mixin/features/jumpover/LivingEntityMixin.java` | `value={LivingEntity.class})` | Inject:1 | packtools$jumpOver |
| top-level / `com/frikinjay/packtools/mixin/features/notrample/FarmlandBlockMixin.java` | `value={FarmlandBlock.class})` | Redirect:1 | packtools$cancelTurnToDirt |
| top-level / `com/frikinjay/packtools/mixin/features/packloader/PackRepositoryMixin.java` | `value={PackRepository.class})` | ModifyVariable:1 | packtools$addCustomSource |
| top-level / `com/frikinjay/packtools/mixin/features/rapidpiglin/PiglinAiMixin.java` | `value={PiglinAi.class})` | Inject:1, ModifyConstant:2 | packtools$updateField, packtools$modifyAdmireDurationInt, packtools$modifyAdmireDurationLong |
| top-level / `com/frikinjay/packtools/mixin/features/stackmaxxer/ItemInstanceMixin.java` | `value={ItemInstance.class})` | ModifyReturnValue:1 | packtools$modifyStackSize |
| top-level / `com/frikinjay/packtools/mixin/features/stackmaxxer/ItemMixin.java` | `value={Item.class})` | ModifyReturnValue:1 | packtools$modifyDefaultStackSize |
| top-level / `com/frikinjay/packtools/mixin/features/tooltips/food/ItemStackMixin.java` | `value={ItemStack.class})` | Inject:1 | packtools$injectCustomTooltips |
| top-level / `com/frikinjay/packtools/mixin/features/tooltips/ItemStackMixin.java` | `value={ItemStack.class})` | Inject:1 | packtools$addCustomTooltips |
| top-level / `com/frikinjay/packtools/mixin/util/attributefix/LivingEntityMixin.java` | `value={LivingEntity.class}, priority=9001)` | ModifyArg:1, Inject:1 | packtools$setRestorePoint, packtools$getSavedHealth, packtools$tick |
| top-level / `com/frikinjay/packtools/mixin/util/attributefix/PlayerListMixin.java` | `value={PlayerList.class})` | Inject:1 | packtools$onRespawn |
| top-level / `com/frikinjay/packtools/mixin/util/attributefix/RangedAttributeMixin.java` | `value={RangedAttribute.class})` | Inject:2 | packtools$attributeFix, packtools$preventHealthClamping |
| top-level / `com/frikinjay/packtools/network/RestockerItemPacket.java` | `` |  | encode |
| top-level / `com/frikinjay/packtools/PackTools.java` | `` |  | init |
| top-level / `com/frikinjay/packtools/platform/CommonPlatformHelper.java` | `` |  | registerBlock, registerItem, isModLoaded, getModName, getGameDirectory |
| top-level / `com/frikinjay/packtools/platform/fabric/CommonPlatformHelperImpl.java` | `` |  | registerBlock, registerItem, isModLoaded, getModName, getGameDirectory |
| top-level / `com/frikinjay/packtools/registry/PTTags.java` | `` |  | init, registerTag |
| top-level / `com/frikinjay/packtools/util/attributefix/IHealthRestorePoint.java` | `` |  |  |
| top-level / `com/frikinjay/packtools/util/tooltip/EffectsTooltip.java` | `` |  |  |
| top-level / `com/frikinjay/packtools/util/tooltip/FoodTooltip.java` | `` |  |  |
| top-level / `com/frikinjay/packtools/util/tooltip/MultiTooltipData.java` | `` |  |  |
| top-level / `com/frikinjay/packtools/util/tooltip/TooltipOrdering.java` | `` |  | orderTooltips |
| top-level / `com/frikinjay/packtools/util/tooltip/TooltipType.java` | `` |  | getType |

## Data-driven behavior

Resource category counts: `tags`: 8.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
