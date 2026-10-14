# Better Block Entities

Review status: **Evidence inventory; behavioral review pending**

Project: [Better Block Entities](https://modrinth.com/mod/better-block-entities)
Selected artifact version: `1.3.9+mc26.3`
Published implementation source: https://github.com/ceeden/betterblockentities
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A Minecraft optimization mod for Fabric-Sodium that improves framerates by improving block entity rendering via a hybrid renderer

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `151330c3ea5a1c93e841ea4cda0788c93b5b986d`
- `sha512`: `dbad4387672fea686a6610ac238d0243fdbce718bed3aafc6006068bf769df2eea8f2c7189f5cb3835008f11eb9c767f1e2eaf436c67bddc17fb8607af26dd88`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 124
Reconstructed Java files: 99

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "betterblockentities.client.BBEFabric"
  ],
  "sodium:config_api_user": [
    "betterblockentities.client.gui.config.builder.SodiumConfigBuilder"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16.7",
  "minecraft": ">=26.3-rc.1",
  "sodium": ">=0.9.2-beta.2"
}
```

**breaks**

```json
{
  "optifabric": "*"
}
```

**accessWidener**

```json
"betterblockentities-fabric.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `betterblockentities/client/BBEFabric.java` | `` |  | onInitializeClient |
| top-level / `betterblockentities/client/chunk/pipeline/BBEBlockRenderer.java` | `` |  | emitBlockModel, emitChest, emitShulker, emitBell, emitDecoratedPot, emitBanner, emitCopperGolemStatue, tryGetBlockEntity, tryGetPairs, shouldRender, clearParts |
| top-level / `betterblockentities/client/chunk/pipeline/BBEEmitter.java` | `` |  | emit, buffer, applyRenderType, applySprite, applyTransformation, applyColor, applyAmbientOcclusionMode, applyShadeMode, applyFlags, setRenderType, setTransformation, setRotation, setRotation, setColor, setSprite, setSprite, setAmbientOcclusionMode, setShadeMode, setFlag, clear |
| top-level / `betterblockentities/client/chunk/section/SectionRebuildCallbacks.java` | `` |  | keyFromBlockPos, keyFromSectionPos, await, remove, isEmpty, fireIfWaiting |
| top-level / `betterblockentities/client/chunk/section/SectionUpdateDispatcher.java` | `` |  | queueRebuildAtBlockPos, queueRebuildAtBlockPos, queueUpdateAllSections |
| top-level / `betterblockentities/client/chunk/translucent_sorting/TQuadExt.java` | `` |  |  |
| top-level / `betterblockentities/client/chunk/translucent_sorting/TranslucentGeometryCollectorExt.java` | `` |  |  |
| top-level / `betterblockentities/client/chunk/util/QuadLighter.java` | `` |  | prepare, computeDirectionalLight, shadeEntityQuad |
| top-level / `betterblockentities/client/chunk/util/QuadTransform.java` | `` |  | rotateXYZ, rotate, expand, remapSprite |
| top-level / `betterblockentities/client/gui/config/BBEConfig.java` | `` |  | buildConfigStorages, load, save, updateConfigCache, rebuildFromConfig |
| top-level / `betterblockentities/client/gui/config/builder/ConfigBuilder.java` | `` |  | buildMainStorage, buildExperimentalStorage, buildHiddenStorage |
| top-level / `betterblockentities/client/gui/config/builder/SodiumConfigBuilder.java` | `` |  | registerGeneralPage, registerOptimizationPage, registerAnimationPage, registerAdvancedPage, registerConfigLate |
| top-level / `betterblockentities/client/gui/config/ConfigCache.java` | `` |  |  |
| top-level / `betterblockentities/client/gui/config/wrapper/GenericConfigWrapper.java` | `` |  | getGenericBooleanOption, getGenericIntegerOption, debugOverlays, getGenericBooleanOption, getGenericIntegerOption, master, optimizeChests, optimizeShulker, optimizeSign, optimizeDecoratedPot, optimizeBanner, optimizeBell, optimizeCopperGolemStatue, optimizeShelf, optimizeCampfire, optimizeLectern, animateChest, animateShulker, animateBell, animateDecoratedpot, bannerPose, bannerGraphics, useChristmasChestTextures, signTextDistance, signText, signTextCulling, updateScheduler, shadeMode |
| top-level / `betterblockentities/client/gui/DebugScreen.java` | `` |  | display, isAllowed |
| top-level / `betterblockentities/client/gui/option/BooleanOption.java` | `` |  | getValue, setValue, getKey |
| top-level / `betterblockentities/client/gui/option/EnumTypes.java` | `` |  | map, map, map, map, map, map |
| top-level / `betterblockentities/client/gui/option/FloatOption.java` | `` |  | getValue, setValue, getKey |
| top-level / `betterblockentities/client/gui/option/IntegerOption.java` | `` |  | getValue, setValue, getKey |
| top-level / `betterblockentities/client/gui/option/OptionObject.java` | `` |  |  |
| top-level / `betterblockentities/client/gui/storage/ConfigStorageCollection.java` | `` |  | getStorage, addStorage |
| top-level / `betterblockentities/client/gui/storage/ConfigStorageIdentifiers.java` | `` |  |  |
| top-level / `betterblockentities/client/gui/storage/ConfigStorageObject.java` | `` |  | getStorageId, addOption, getOption, setOption, getAllOptions |
| top-level / `betterblockentities/client/gui/storage/SodiumConfigStorage.java` | `` |  | save |
| top-level / `betterblockentities/client/model/geometry/GeometryRegistry.java` | `` |  | cacheGeometry, getModel, clearCache, getCache |
| top-level / `betterblockentities/client/model/geometry/ModelBakery.java` | `` |  | generateAppend, bakeLayerSetupAndAppend, setupShulker, setupChest, setupBell, setupDecoratedPot, setupBanners, setupCopperGolemStatue, tryGetEntityModelSet, calculateBannerPhase |
| top-level / `betterblockentities/client/model/geometry/ModelResourceUtil.java` | `` |  | getChestLayer, getBannerFlagLayer, getBannerBaseLayer, getCGSLayer, getShulkerBoxLayer, getBellLayer, getDecoratedPotBaseLayer, getDecoratedPotSideLayer, collectSingleModelParts, collectMultiModelParts |
| top-level / `betterblockentities/client/model/geometry/MultiPartBlockModel.java` | `` |  | generateMeshModel, toBakedQuads, normalToDirection, toUnculledCollection, constructSingleVariants, createModelPairs, getPairs, collectParts, particleMaterial |
| top-level / `betterblockentities/client/model/geometry/SupportedModelLayers.java` | `` |  |  |
| top-level / `betterblockentities/client/model/texture/PlaceHolderSpriteIdentifiers.java` | `` |  |  |
| top-level / `betterblockentities/client/model/texture/SpriteSelector.java` | `` |  | getBannerPatternSprite, getDecoratedPotSideSprite, getDecoratedPotMaterial, getCopperGolemStatueSprite, getChestSprite, getShulkerBoxSprite, getBlockSprite, PotSideSprite, create |
| top-level / `betterblockentities/client/render/immediate/blockentity/extentions/BlockEntityExt.java` | `` |  |  |
| top-level / `betterblockentities/client/render/immediate/blockentity/extentions/BlockEntityRenderStateExt.java` | `` |  |  |
| top-level / `betterblockentities/client/render/immediate/blockentity/manager/InstancedBlockEntityManager.java` | `` |  | getBlockEntity, isIdle, isAnimating, setAnimating, setDurationTask, isValid, forceKill, run, tick, trigger, shouldBeImmediate, isDurationStillRunning, enterImmediate, requestTerrainFence, isSmartSchedulerEnabled, isVisibleInFov |
| top-level / `betterblockentities/client/render/immediate/blockentity/manager/SpecialBlockEntityManager.java` | `` |  | isCameraFrontFacing, hasAnyText, checkDistanceToCamera |
| top-level / `betterblockentities/client/render/immediate/blockentity/misc/LidControllerSync.java` | `` |  | sync, syncRenderingModes, setImmediate, tryGetBlockEntity |
| top-level / `betterblockentities/client/render/immediate/blockentity/misc/RenderingMode.java` | `` |  |  |
| top-level / `betterblockentities/client/render/immediate/blockentity/renderers/BBEDummyRenderer.java` | `` |  | createRenderState, submit, extractRenderState, shouldRenderOffScreen, getViewDistance, shouldRender |
| top-level / `betterblockentities/client/render/immediate/overlay/OverlayDrawPhase.java` | `` |  |  |
| top-level / `betterblockentities/client/render/immediate/overlay/OverlayNodeCollection.java` | `` |  | submitModel, submitCrumblingOverlay |
| top-level / `betterblockentities/client/render/immediate/overlay/OverlayNodeStorage.java` | `` |  | order, push, pop, last, SubmitParameters, SubmitResolution, SubmitCall, close |
| top-level / `betterblockentities/client/render/immediate/overlay/OverlayRenderer.java` | `` |  | submitCrumblingOverlay, submitCrumblingOverlay |
| top-level / `betterblockentities/client/render/immediate/util/BlockVisibilityChecker.java` | `` |  | isBlockInFOVAndVisible, setupBox, getOppositeChestHalf, getOtherChestHalf |
| top-level / `betterblockentities/client/tasks/ManagerTasks.java` | `` |  | schedule, process, clearActive, getBlockPosKey |
| top-level / `betterblockentities/client/tasks/ResourceTasks.java` | `` |  | populateGeometryRegistry |
| top-level / `betterblockentities/client/tasks/TaskScheduler.java` | `` |  | schedule, scheduleOnReload |
| top-level / `betterblockentities/data/RegistrationInfo.java` | `` |  | RegistrationInfo |
| top-level / `betterblockentities/data/SupportedBlockEntityTypes.java` | `` |  | type |
| top-level / `betterblockentities/data/ValidationChecks.java` | `` |  | registrationTypeValid |
| top-level / `betterblockentities/mixin/accessors/AbstractBlockRenderContextAccessor.java` | `value={AbstractBlockRenderContext.class})` | Accessor:9, Invoker:4 |  |
| top-level / `betterblockentities/mixin/accessors/BlockEntityRenderersAccessor.java` | `value={BlockEntityRenderers.class})` | Invoker:1, Accessor:1 | bbe$register, bbe$getProviders |
| top-level / `betterblockentities/mixin/accessors/ChestBlockEntityAccessor.java` | `value={ChestBlockEntity.class})` | Accessor:1 |  |
| top-level / `betterblockentities/mixin/accessors/ChestLidControllerAccessor.java` | `value={ChestLidController.class})` | Accessor:6 |  |
| top-level / `betterblockentities/mixin/accessors/DebugScreenEntriesAccessor.java` | `value={DebugScreenEntries.class})` | Invoker:1 | bbe$register |
| top-level / `betterblockentities/mixin/accessors/MipMapGeneratorAccessor.java` | `value={MipmapGenerator.class})` | Invoker:1 | bbe$scaleAlphaToCoverage |
| top-level / `betterblockentities/mixin/accessors/ModelPartAccessor.java` | `value={ModelPart.class})` | Accessor:11, Invoker:2 |  |
| top-level / `betterblockentities/mixin/accessors/RenderSectionAccessor.java` | `value={RenderSection.class})` | Accessor:3 |  |
| top-level / `betterblockentities/mixin/core/ClientLevelMixin.java` | `value={ClientLevel.class})` | Inject:2 | bbe$syncLidControllerBeforeRenderUpdate, bbe$syncLidControllers |
| top-level / `betterblockentities/mixin/core/MinecraftMixin.java` | `value={Minecraft.class})` | WrapOperation:2 | bbe$pollManagerQueue |
| top-level / `betterblockentities/mixin/model/item/ChestSpecialRendererMixin.java` | `value={ChestSpecialRenderer.class})` | Redirect:1 | bbe$submit |
| top-level / `betterblockentities/mixin/model/item/ClientItemInfoLoaderMixin.java` | `value={ClientItemInfoLoader.class})` | Inject:1 | bbe$rewriteChestItemAssets, bbe$shouldOverrideVanilla, bbe$rewriteChestItems, bbe$patchOne, bbe$patchModel |
| top-level / `betterblockentities/mixin/render/BlockEntityRenderDispatcherMixin.java` | `value={BlockEntityRenderDispatcher.class})` | Inject:1 | bbe$reloadAltDispatcher |
| top-level / `betterblockentities/mixin/render/FeatureRenderDispatcherMixin.java` | `value={FeatureRenderDispatcher.class})` | WrapOperation:1 | bbe$drainOverlayStorage, bbe$mergeOverlayStorage |
| top-level / `betterblockentities/mixin/render/immediate/blockentity/BannerBlockEntityMixin.java` | `value={BannerBlockEntity.class})` | Inject:1 | bbe$init |
| top-level / `betterblockentities/mixin/render/immediate/blockentity/BellBlockEntityMixin.java` | `value={BellBlockEntity.class})` | Inject:2 | bbe$init, bbe$onTick |
| top-level / `betterblockentities/mixin/render/immediate/blockentity/BlockEntityRenderersMixin.java` | `value={BlockEntityRenderers.class})` | Inject:1 | bbe$replaceVanillaRenderers, bbe$removeRegistration |
| top-level / `betterblockentities/mixin/render/immediate/blockentity/CampfireBlockEntityMixin.java` | `value={CampfireBlockEntity.class})` | Inject:1 | bbe$init |
| top-level / `betterblockentities/mixin/render/immediate/blockentity/ChestBlockEntityMixin.java` | `value={ChestBlockEntity.class})` | Inject:2 | bbe$init, bbe$onTick |
| top-level / `betterblockentities/mixin/render/immediate/blockentity/ChestRendererMixin.java` | `value={ChestRenderer.class})` | ModifyVariable:1 | bbe$useChristmasTextures |
| top-level / `betterblockentities/mixin/render/immediate/blockentity/CopperGolemStatueBlockEntityMixin.java` | `value={CopperGolemStatueBlockEntity.class})` | Inject:1 | bbe$init |
| top-level / `betterblockentities/mixin/render/immediate/blockentity/DecoratedPotBlockEntityMixin.java` | `value={DecoratedPotBlockEntity.class})` | Inject:2 | bbe$init, bbe$onBlockEvent |
| top-level / `betterblockentities/mixin/render/immediate/blockentity/EnderChestBlockEntityMixin.java` | `value={EnderChestBlockEntity.class})` | Inject:2 | bbe$init, bbe$onTick |
| top-level / `betterblockentities/mixin/render/immediate/blockentity/extentions/BlockEntityMixin.java` | `value={BlockEntity.class})` |  | bbe$isSupportedBlockEntity, bbe$setSupportedBlockEntity, bbe$getRenderingMode, bbe$setRenderingMode, bbe$isTerrainMeshReady, bbe$setTerrainMeshReady, bbe$hasSpecialManager, bbe$setSpecialManager, bbe$getOptKind, bbe$setOptKind |
| top-level / `betterblockentities/mixin/render/immediate/blockentity/extentions/BlockEntityRenderStateMixin.java` | `value={BlockEntityRenderState.class})` | Inject:1 | bbe$fillBaseState, bbe$setBlockEntity, bbe$getBlockEntity |
| top-level / `betterblockentities/mixin/render/immediate/blockentity/LecternBlockEntityMixin.java` | `value={LecternBlockEntity.class})` | Inject:1 | bbe$init |
| top-level / `betterblockentities/mixin/render/immediate/blockentity/ShelfBlockEntityMixin.java` | `value={ShelfBlockEntity.class})` | Inject:1 | bbe$init |
| top-level / `betterblockentities/mixin/render/immediate/blockentity/ShulkerBoxBlockEntityMixin.java` | `value={ShulkerBoxBlockEntity.class})` | Inject:2 | bbe$init, bbe$onTick |
| top-level / `betterblockentities/mixin/render/immediate/blockentity/SignBlockEntityMixin.java` | `value={SignBlockEntity.class})` | Inject:1 | bbe$init |
| top-level / `betterblockentities/mixin/render/LevelRendererMixin.java` | `value={LevelRenderer.class})` | Inject:3, WrapOperation:1 | bbe$captureFrustum, bbe$submitBreakingOverlays, bbe$submitAltRenderers, bbe$clearRenderStates |
| top-level / `betterblockentities/mixin/resource/ReloadableResourceManagerMixin.java` | `value={ReloadableResourceManager.class})` | Inject:1 | bbe$schedulePostReloadTasks |
| top-level / `betterblockentities/mixin/sodium/config/ConfigMixin.java` | `value={Config.class})` | Inject:1 | bbe$updateConfigStorage |
| top-level / `betterblockentities/mixin/sodium/pipeline/BlockRendererMixin.java` | `value={BlockRenderer.class})` | Inject:2, Redirect:1, WrapOperation:2 | bbe$init, bbe$prepare, bbe$emitModel, bbe$shadeQuad, bbe$appendQuad |
| top-level / `betterblockentities/mixin/sodium/render/RenderSectionManagerMixin.java` | `value={RenderSectionManager.class})` | Redirect:1 | bbe$callback |
| top-level / `betterblockentities/mixin/sodium/render/SodiumWorldRendererMixin.java` | `value={SodiumWorldRenderer.class})` | Overwrite:1 | extractBlockEntity, bbe$shouldManage |
| top-level / `betterblockentities/mixin/sodium/translucent_sorting/InnerPartitionBSPNodeMixin.java` | `targets={"net.caffeinemc.mods.sodium.client.render.chunk.translucent_sorting.bsp_tree.InnerPartitionBSPNode"})` | WrapOperation:1 | bbe$skipSplitForTaggedQuads |
| top-level / `betterblockentities/mixin/sodium/translucent_sorting/TQuadMixin.java` | `value={TQuad.class})` |  | bbe$setSplittingMode, bbe$getSplittingMode |
| top-level / `betterblockentities/mixin/sodium/translucent_sorting/TranslucentGeometryCollectorMixin.java` | `value={TranslucentGeometryCollector.class})` | WrapOperation:1 | bbe$appendQuad, bbe$setIncomingQuadSplitMode, bbe$getLastSplitMode, bbe$deferSplittingMode |
| top-level / `betterblockentities/mixin/texture/AtlasManagerMixin.java` | `value={AtlasManager.class})` | Redirect:1 | bbe$cancelForEntityTextures |
| top-level / `betterblockentities/mixin/texture/MipMapGeneratorMixin.java` | `value={MipmapGenerator.class})` | Redirect:1 | bbe$skipEntityTextureAlphaCoverage, bbe$shouldScale |
| top-level / `betterblockentities/platform/FabricPlatformAccess.java` | `` |  | isModLoaded, getEntryPoints |
| top-level / `betterblockentities/platform/GlobalScope.java` | `` |  | collectEntryPoints |
| top-level / `betterblockentities/platform/PlatformInterface.java` | `` |  |  |
| top-level / `betterblockentities/registration/AltRendererRegistration.java` | `` |  | registerRenderer |
| top-level / `betterblockentities/registration/BBEApiEntryPoint.java` | `` |  |  |
| top-level / `betterblockentities/registration/RegistrationCollection.java` | `` |  | addRegistration, collectEntryPoints, getRegistrations |
| top-level / `betterblockentities/render/AltRenderDispatcher.java` | `` |  | getRenderers, getRenderers, prepare, tryExtractRenderStates, submit, addStateRendererPair, clearStateRendererPairs, onResourceManagerReload |
| top-level / `betterblockentities/render/AltRenderer.java` | `` |  |  |
| top-level / `betterblockentities/render/AltRendererProvider.java` | `` |  | Context, bakeLayer |
| top-level / `betterblockentities/render/AltRenderers.java` | `` |  | createAltEntityRenderers, hasRendererOverride, forRenderer, getLoadedAltRenderers, renderersLoaded, clear |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
