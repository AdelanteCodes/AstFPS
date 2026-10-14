# Debugify

Review status: **Evidence inventory; behavioral review pending**

Project: [Debugify](https://modrinth.com/mod/debugify)
Selected artifact version: `26.3.0.0`
Published implementation source: https://github.com/isXander/Debugify/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Fixes Minecraft bugs found on the bug tracker

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha512`: `921a2f31531990df93af4099cd7bece26886b7fc38021642ae32032e435b8686a0ee208dba4eb1ed0057e6e0b3332f990fb77778781afccfe0e52d28dfb07c26`
- `sha1`: `62876ccaaaaad48c04499e4cf211433dc6c6e53b`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 133
Reconstructed Java files: 129

**entrypoints**

```json
{
  "main": [
    "dev.isxander.debugify.Debugify::onInitialize"
  ],
  "client": [
    "dev.isxander.debugify.client.DebugifyClient::onInitializeClient"
  ],
  "modmenu": [
    "dev.isxander.debugify.client.integrations.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "minecraft": "=26.3",
  "fabricloader": ">=0.19",
  "fabric-resource-loader-v0": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/isxander/debugify/api/DebugifyApi.java` | `` |  |  |
| top-level / `dev/isxander/debugify/client/DebugifyClient.java` | `` |  | onInitializeClient |
| top-level / `dev/isxander/debugify/client/gui/BugFixController.java` | `` |  | provideWidget, matchesSearch, recalculateTooltipString |
| top-level / `dev/isxander/debugify/client/gui/ConfigGuiHelper.java` | `` |  | createConfigGui |
| top-level / `dev/isxander/debugify/client/gui/NoYACLScreen.java` | `` |  |  |
| top-level / `dev/isxander/debugify/client/helpers/mc118740/LocalPlayerDuck.java` | `` |  |  |
| top-level / `dev/isxander/debugify/client/helpers/mc197260/DebugifyLightProvider.java` | `` |  |  |
| top-level / `dev/isxander/debugify/client/helpers/mc237493/DebugifyTelemetry.java` | `` |  | caption, tooltip |
| top-level / `dev/isxander/debugify/client/helpers/mc237493/DebugifyTelemetryAccessor.java` | `` |  |  |
| top-level / `dev/isxander/debugify/client/helpers/mc251068/LastWorldDeleted.java` | `` |  | mark, consume |
| top-level / `dev/isxander/debugify/client/integrations/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc105068/LivingEntityMixin.java` | `value={LivingEntity.class})` | WrapOperation:1 | beforeCond30 |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc115092/SquidRendererMixin.java` | `value={SquidRenderer.class})` | Inject:2 | getSquidEntity, applyRotation |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc116379/FishingHookRendererMixin.java` | `value={FishingHookRenderer.class})` | ModifyExpressionValue:1 | modifyHandSwingProgress |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc118740/HudMixin.java` | `value={Hud.class})` | WrapOperation:1 | useFixedCooldown |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc118740/LivingEntityMixin.java` | `value={LivingEntity.class})` | Inject:1 | swing |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc118740/LocalPlayerMixin.java` | `value={LocalPlayer.class})` |  | debugify$getVisualAttackStrengthScale, debugify$resetVisualAttackStrengthScale, debugify$incrementVisualAttackStrengthScale |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc118740/PlayerMixin.java` | `value={Player.class})` | Inject:2 | resetAttackStrengthTicker, tick |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc122627/CommandSuggestionsMixin.java` | `value={CommandSuggestions.class})` | ModifyExpressionValue:1 | modifyX2 |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc127970/ItemInHandRendererMixin.java` | `value={FirstPersonHandsAndItemsRenderer.class})` | ModifyExpressionValue:1 | isUsingRiptideHand |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc143474/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | Inject:1 | persistInventorySlot2 |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc165305/RenderPipelinesMixin.java` | `value={RenderPipelines.class})` | WrapOperation:1 | disableCull |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc165381/MultiPlayerGameModeMixin.java` | `value={MultiPlayerGameMode.class})` | Inject:1 | onDropItem |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc176559/ItemStackAccessor.java` | `value={ItemStack.class})` | Accessor:1 |  |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc176559/MultiPlayerGameModeMixin.java` | `value={MultiPlayerGameMode.class}, priority=1010)` | WrapOperation:1 | isSameItem, isSameItemSameComponentsIgnoringDurability |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc188359/CakeBlockMixin.java` | `value={CakeBlock.class})` | Inject:1 | playBurpSound |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc188359/ConsumableMixin.java` | `value={Consumable.class})` | Inject:1 | addBurpSound |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc197260/ArmorStandRendererMixin.java` | `value={ArmorStandRenderer.class})` |  | debugify$modifyLightCoords |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc197260/LivingEntityRendererMixin.java` | `value={LivingEntityRenderer.class})` | Inject:1 | fixLightLevel |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc210318/BookSignScreenMixin.java` | `value={BookSignScreen.class})` | ModifyArg:1 | restoreBookTitleMaxLength |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc211561/FishingHookRendererMixin.java` | `value={FishingHookRenderer.class})` | ModifyReturnValue:1 | fixHoldingArm |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc215531/HudMixin.java` | `value={Hud.class})` | ModifyExpressionValue:1 | shouldRenderPumpkinOverlay |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc217716/LevelExtractorMixin.java` | `value={LevelExtractor.class})` | ModifyExpressionValue:1 | shouldShowNauseaOverlay |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc237493/OptionsMixin.java` | `value={Options.class})` | Inject:1 | getTelemetryOption, shouldAcceptVanillaTelemetry |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc237493/TelemetryEventInstanceMixin.java` | `value={TelemetryEventInstance.class})` | ModifyReturnValue:1 | preventEvents |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc237493/TelemetryEventWidgetMixin.java` | `value={TelemetryEventWidget.class})` | ModifyExpressionValue:1, Inject:1 | modifyInUseTelemetry, addDebugifyContent |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc237493/TelemetryInfoScreenMixin.java` | `value={TelemetryInfoScreen.class})` | WrapOperation:1, Inject:1 | createTelemetryCheckbox, repositionCycleButton |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc242809/DirectJoinServerScreenMixin.java` | `value={DirectJoinServerScreen.class})` | ModifyExpressionValue:2 | trimIpSelect, trimIpInit |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc242809/ManageServerScreenMixin.java` | `value={ManageServerScreen.class})` | ModifyExpressionValue:1 | trimIp |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc251068/WorldListEntryMixin.java` | `value={WorldSelectionList.WorldListEntry.class})` | Inject:1 | markLastWorldDeleted |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc251068/WorldSelectionListMixin.java` | `value={WorldSelectionList.class})` | WrapWithCondition:1 | dontShowEmptyWorldList |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc267376/CameraMixin.java` | `value={Camera.class})` | ModifyArg:1 | scaleNearClipDistance |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc268420/HudMixin.java` | `value={Hud.class})` | WrapWithCondition:1 | fixAttackIndicatorFlashing |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc280220/DolphinCarryingItemLayerMixin.java` | `value={DolphinCarryingItemLayer.class})` | Inject:1 | flipItem |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc298225/CameraMixin.java` | `value={Camera.class})` | ModifyExpressionValue:1 | fixSkyboxFarplaneClipping |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc298558/AtmosphericFogEnvironmentMixin.java` | `value={AtmosphericFogEnvironment.class})` | ModifyExpressionValue:1 | clampFog |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc35361/MinecraftMixin.java` | `value={Minecraft.class})` | WrapWithCondition:1 | addNetherPortalCheck |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc4490/FishingHookRendererMixin.java` | `value={FishingHookRenderer.class})` | ModifyExpressionValue:1 | renderSneakOffset |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc46737/GameRendererMixin.java` | `value={GameRenderer.class})` | WrapWithCondition:1 | thirdPersonCheck |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc46766/MinecraftMixin.java` | `value={Minecraft.class})` | ModifyArg:1 | shouldContinueAttack |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc57057/GuardianAttackSoundInstanceMixin.java` | `value={GuardianAttackSoundInstance.class})` | Inject:1 | fixAttenuation |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc577/AbstractContainerScreenMixin.java` | `value={AbstractContainerScreen.class})` | ModifyExpressionValue:1, Inject:1 | shouldReturn, dropWithMouse, mouseInventoryClose |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc61489/BookEditScreenMixin.java` | `value={BookEditScreen.class})` | ModifyArg:1, ModifyReturnValue:1 | modifyHeight, modifyTop |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc61489/BookViewScreenMixin.java` | `value={BookViewScreen.class})` | ModifyReturnValue:1 | modifyTop |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc79545/ExperienceBarMixin.java` | `value={ExperienceBar.class})` | ModifyExpressionValue:1 | getNextLevelExperience |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc80859/AbstractContainerScreenMixin.java` | `value={AbstractContainerScreen.class})` | WrapOperation:1 | stopInvisibleSlots |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc90683/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | WrapWithCondition:1 | shouldWarn |
| top-level / `dev/isxander/debugify/client/mixins/basic/mc93384/LivingEntityMixin.java` | `value={LivingEntity.class})` | ModifyExpressionValue:1 | addEyeHeightToBubblePos |
| top-level / `dev/isxander/debugify/client/mixins/gameplay/mc159163/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | Inject:1 | removeLocalEntityPose |
| top-level / `dev/isxander/debugify/client/mixins/gameplay/mc231097/MultiPlayerGameModeMixin.java` | `value={MultiPlayerGameMode.class})` | Inject:1 | onDropItem |
| top-level / `dev/isxander/debugify/client/utils/ClientUtils.java` | `` |  | isInMultiplayerWorld |
| top-level / `dev/isxander/debugify/config/DebugifyConfig.java` | `` |  | registerBugFix, preload, save, isBugFixEnabled, getBugFixes, doesJsonHaveIdenticalKeys |
| top-level / `dev/isxander/debugify/Debugify.java` | `` |  | onPreInitialize, onInitialize, getEnv, isGameplayFixesEnabled |
| top-level / `dev/isxander/debugify/error/CrashReportInjector.java` | `` |  | addDetailsToCrashReport, stringifyErrorEntry |
| top-level / `dev/isxander/debugify/error/DebugifyErrorHandler.java` | `` |  | onPrepareError, onApplyError, handleError, hasErrored, getErroredFixes |
| top-level / `dev/isxander/debugify/error/ErrorStage.java` | `` |  |  |
| top-level / `dev/isxander/debugify/error/MixinErrorEntry.java` | `` |  | MixinErrorEntry |
| top-level / `dev/isxander/debugify/fixes/BugFix.java` | `` |  | getDisplayName, getDescriptionKey |
| top-level / `dev/isxander/debugify/fixes/BugFixData.java` | `` |  | registerApiConflict, getActiveConflicts, satisfiesOSRequirement, equals, compareTo |
| top-level / `dev/isxander/debugify/fixes/FixCategory.java` | `` |  | getDisplayName |
| top-level / `dev/isxander/debugify/fixes/OS.java` | `` |  | getOperatingSystem, getDisplayName |
| top-level / `dev/isxander/debugify/mixinplugin/BugFixDataCache.java` | `` |  | getOrResolve, getIfResolved, resolve, getClassNode, getAnnotationEnumValue |
| top-level / `dev/isxander/debugify/mixinplugin/DebugifyDebugFlags.java` | `` |  | boolProp |
| top-level / `dev/isxander/debugify/mixinplugin/MixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `dev/isxander/debugify/mixins/basic/mc100991/FishingHookMixin.java` | `value={FishingHook.class})` | Inject:1 | onPullEntity |
| top-level / `dev/isxander/debugify/mixins/basic/mc119754/FireworkRocketEntityMixin.java` | `value={FireworkRocketEntity.class})` | ModifyExpressionValue:1 | shouldFly |
| top-level / `dev/isxander/debugify/mixins/basic/mc121706/RangedBowAttackGoalMixin.java` | `value={RangedBowAttackGoal.class})` | Inject:1 | lookAtTarget |
| top-level / `dev/isxander/debugify/mixins/basic/mc121903/MinecraftCommandBlockMixin.java` | `value={MinecartCommandBlock.class})` | Inject:2 | readNbt, writeNbt |
| top-level / `dev/isxander/debugify/mixins/basic/mc123450/ItemFrameMixin.java` | `value={ItemFrame.class})` | WrapWithCondition:1 | playSound |
| top-level / `dev/isxander/debugify/mixins/basic/mc131562/ServerGamePacketListenerImplMixin.java` | `value={ServerGamePacketListenerImpl.class})` | WrapWithCondition:1 | checkEmptyCommandBeforeMessage |
| top-level / `dev/isxander/debugify/mixins/basic/mc132878/ArmorStandMixin.java` | `value={ArmorStand.class})` | Inject:2 | breakParticlesExplosion, breakParticlesFire |
| top-level / `dev/isxander/debugify/mixins/basic/mc133218/ServerPlayerMixin.java` | `value={ServerPlayer.class})` | Inject:1 | stopUsingItemOnDeath |
| top-level / `dev/isxander/debugify/mixins/basic/mc134110/ChestBlockMixin.java` | `value={ChestBlock.class})` | WrapMethod:1 | fixChestRotations |
| top-level / `dev/isxander/debugify/mixins/basic/mc139041/FishingRodItemMixin.java` | `value={FishingRodItem.class})` | ModifyArg:1 | modifyFishingBobberSounds |
| top-level / `dev/isxander/debugify/mixins/basic/mc147659/CatSpawnerMixin.java` | `value={CatSpawner.class})` | WrapWithCondition:1, Inject:1 | removeOldCatSnap, addNewCatSnap |
| top-level / `dev/isxander/debugify/mixins/basic/mc153010/FoxMixin.java` | `value={Fox.class})` | ModifyExpressionValue:1 | preventLootDropIfGameruleIsFalse |
| top-level / `dev/isxander/debugify/mixins/basic/mc155509/PufferfishMixin.java` | `value={Pufferfish.class})` | ModifyExpressionValue:1 | shouldStingPlayer |
| top-level / `dev/isxander/debugify/mixins/basic/mc158900/PlayerListMixin.java` | `value={PlayerList.class})` | WrapOperation:1 | removeExpiredBeforeCheck |
| top-level / `dev/isxander/debugify/mixins/basic/mc160095/CactusBlockMixin.java` | `value={CactusBlock.class})` | WrapOperation:1 | replaceBlockState |
| top-level / `dev/isxander/debugify/mixins/basic/mc168573/BlocksAttacksMixin.java` | `value={BlocksAttacks.class})` | WrapOperation:1 | fixShieldBreakItemUse |
| top-level / `dev/isxander/debugify/mixins/basic/mc170462/MobEffectsMixin.java` | `value={MobEffects.class})` | ModifyArg:1 | badOmenEffectCategory |
| top-level / `dev/isxander/debugify/mixins/basic/mc176806/RespawnAnchorBlockMixin.java` | `value={RespawnAnchorBlock.class})` | Inject:1 | awardGlowstoneStat |
| top-level / `dev/isxander/debugify/mixins/basic/mc177381/LocateCommandMixin.java` | `value={LocateCommand.class})` | WrapMethod:1 | distanceHypot |
| top-level / `dev/isxander/debugify/mixins/basic/mc179072/SwellGoalMixin.java` | `value={SwellGoal.class})` | ModifyExpressionValue:1 | shouldIgniteCreeper |
| top-level / `dev/isxander/debugify/mixins/basic/mc183990/MobMixin.java` | `value={Mob.class})` | Inject:1 | clearTargetIfDead |
| top-level / `dev/isxander/debugify/mixins/basic/mc187100/EnderDragonMixin.java` | `value={EnderDragon.class})` | WrapMethod:1, Inject:1 | dontFindNearestCrystalIfDying, clearNearestCrystalOnDeath |
| top-level / `dev/isxander/debugify/mixins/basic/mc200418/ZombieVillagerMixin.java` | `value={ZombieVillager.class})` | Inject:1 | dismountIfJockey |
| top-level / `dev/isxander/debugify/mixins/basic/mc201374/CampfireBlockMixin.java` | `value={CampfireBlock.class})` | ModifyArg:1 | fixedBlockPos |
| top-level / `dev/isxander/debugify/mixins/basic/mc202637/FoodPropertiesMixin.java` | `value={FoodProperties.class})` | ModifyArg:1 | modifyEatSoundSource |
| top-level / `dev/isxander/debugify/mixins/basic/mc206922/EntityMixin.java` | `value={Entity.class})` | WrapMethod:1 | bypassStruckByLightning |
| top-level / `dev/isxander/debugify/mixins/basic/mc206922/ItemEntityMixin.java` | `value={ItemEntity.class})` |  | bypassStruckByLightning |
| top-level / `dev/isxander/debugify/mixins/basic/mc215530/ServerPlayerMixin.java` | `value={ServerPlayer.class})` | Inject:1 | onChangeToSpectator |
| top-level / `dev/isxander/debugify/mixins/basic/mc221257/ShulkerBulletMixin.java` | `value={ShulkerBullet.class})` | Inject:1 | addMissingBubbleParticles |
| top-level / `dev/isxander/debugify/mixins/basic/mc223153/BlocksMixin.java` | `value={Blocks.class})` | ModifyArg:1 | addCopperSound |
| top-level / `dev/isxander/debugify/mixins/basic/mc224729/ChunkMapMixin.java` | `value={ChunkMap.class})` | ModifyArg:2, ModifyExpressionValue:1 | alwaysAccessibleFlushSave, saveProtoChunks, alwaysAccessibleChunkSave |
| top-level / `dev/isxander/debugify/mixins/basic/mc226961/ExperienceOrbMixin.java` | `value={ExperienceOrb.class})` | ModifyExpressionValue:1 | checkEyeLevel |
| top-level / `dev/isxander/debugify/mixins/basic/mc227337/ShulkerBulletMixin.java` | `value={ShulkerBullet.class})` | Inject:1 | playSoundAndDisplayParticles |
| top-level / `dev/isxander/debugify/mixins/basic/mc231743/FlowerPotBlockMixin.java` | `value={FlowerPotBlock.class})` | Inject:1 | onIncrementPottedPlantStat |
| top-level / `dev/isxander/debugify/mixins/basic/mc232869/StriderMixin.java` | `value={Strider.class})` | ModifyExpressionValue:1 | preventPeacefulJocky |
| top-level / `dev/isxander/debugify/mixins/basic/mc245394/RaidMixin.java` | `value={Raid.class})` | ModifyArg:1 | modifyRaidSoundSource |
| top-level / `dev/isxander/debugify/mixins/basic/mc263999/BreakDoorGoalMixin.java` | `value={BreakDoorGoal.class})` | Inject:1, WrapOperation:1 | storeBlockStatePreRemoval, injectCorrectBlockState |
| top-level / `dev/isxander/debugify/mixins/basic/mc264285/CreeperMixin.java` | `value={Creeper.class})` | WrapOperation:1 | shouldNotShrinkStack |
| top-level / `dev/isxander/debugify/mixins/basic/mc264979/SettingsMixin.java` | `value={Settings.class})` | WrapMethod:1 | dontLoadMissingFile |
| top-level / `dev/isxander/debugify/mixins/basic/mc267125/PlayerListMixin.java` | `value={PlayerList.class})` | Inject:1 | sendCommandSuggestions |
| top-level / `dev/isxander/debugify/mixins/basic/mc268617/FileUtilMixin.java` | `value={FileUtil.class})` | ModifyArg:1 | fixWindowsReservedFilename |
| top-level / `dev/isxander/debugify/mixins/basic/mc271899/StructureTemplateMixin.java` | `value={StructureTemplate.Palette.class})` |  |  |
| top-level / `dev/isxander/debugify/mixins/basic/mc272431/EnderDragonMixin.java` | `value={EnderDragon.class})` | ModifyExpressionValue:2 | fixTargetPath, fixVerticalVelocity |
| top-level / `dev/isxander/debugify/mixins/basic/mc297837/WaypointTransmitterMixin.java` | `value={WaypointTransmitter.class})` | WrapOperation:1 | useOnlyHorizontalDistance |
| top-level / `dev/isxander/debugify/mixins/basic/mc30391/LivingEntityMixin.java` | `value={LivingEntity.class})` | ModifyExpressionValue:1 | shouldntSpawnParticles |
| top-level / `dev/isxander/debugify/mixins/basic/mc7569/RconConsoleSourceMixin.java` | `value={RconConsoleSource.class})` | Inject:1 | appendNewline |
| top-level / `dev/isxander/debugify/mixins/basic/mc82263/EnderDragonMixin.java` | `value={EnderDragon.class})` |  | getDeathSound |
| top-level / `dev/isxander/debugify/mixins/basic/mc84661/MobEffectsMixin.java` | `value={MobEffects.class})` | ModifyExpressionValue:1 | badOmenEffectCategory |
| top-level / `dev/isxander/debugify/mixins/basic/mc88371/DragonLandingPhaseMixin.java` | `value={DragonLandingPhase.class})` | ModifyExpressionValue:1 | getLandingPos |
| top-level / `dev/isxander/debugify/mixins/basic/mc89146/ChunkAccessMixin.java` | `value={ChunkAccess.class})` |  |  |
| top-level / `dev/isxander/debugify/mixins/basic/mc93018/AnimalMixin.java` | `value={Animal.class})` | WrapWithCondition:1 | loveCondition |
| top-level / `dev/isxander/debugify/mixins/basic/mc94054/WallClimberNavigationMixin.java` | `value={WallClimberNavigation.class})` | ModifyExpressionValue:1 | fixSpiderSpinning |
| top-level / `dev/isxander/debugify/mixins/errorhandler/CrashReportMixin.java` | `value={CrashReport.class})` | Inject:1 | appendCrashReport |
| top-level / `dev/isxander/debugify/mixins/gameplay/mc136249/LivingEntityMixin.java` | `value={LivingEntity.class})` | ModifyExpressionValue:1 | checkRiptide |
| top-level / `dev/isxander/debugify/mixins/gameplay/mc8187/TreeFeatureMixin.java` | `value={TreeFeature.class})` | ModifyExpressionValue:1 | fixOffsetNew |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
