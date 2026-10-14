# Optimized Block Entities [OBE]

Review status: **Evidence inventory; behavioral review pending**

Project: [Optimized Block Entities [OBE]](https://modrinth.com/mod/obe)
Selected artifact version: `1.1.52`
Published implementation source: https://github.com/maDU59/OptimisedBlockEntities
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A client-side optimization mod to make block entities render faster

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `297475f2898e24aa50f1898e329a49a38c393a98317b09a87a93769a81d386001f1f001756098f8d1a0ec6e495643eef12c8496fe59aeabef3550d896d5ef956`
- `sha1`: `6962bed3882efa84c112ac32a1dca4602d5ca359`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 107
Reconstructed Java files: 89

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "fr.madu59.obe.OBE"
  ],
  "client": [
    "fr.madu59.obe.client.OBEClient"
  ],
  "modmenu": [
    "fr.madu59.obe.client.config.configscreen.ModMenuIntegration"
  ],
  "sodium:config_api_user": [
    "fr.madu59.obe.client.config.configscreen.SodiumIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "minecraft": "~26.3-alpha.1",
  "java": ">=25",
  "fabric-api": "*"
}
```

**breaks**

```json
{
  "entity_model_features": "<3.3.2-fabric-26.3",
  "entitytexturefeatures": "<7.2.1-fabric-26.3"
}
```

**accessWidener**

```json
"obe.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `fr/madu59/obe/client/api/blockentity/BlockEntityAPI.java` | `` |  | addSpecialRenderer |
| top-level / `fr/madu59/obe/client/api/registry/RegistryApi.java` | `` |  | registerGroup, registerBlockEntityType, registerMaterialProvider, registerMaterialProvider, registerMaterialProvider, registerSupportedBlockEntity, registerTransformationProvider, registerTransformationProvider, registerTransformationProvider, registerModelLayerLocationProvider, registerModelLayerLocationProvider, registerModelLayerLocationProvider, registerSpecialModelProvider, registerSpecialModelProvider, registerSpecialModelProvider, runWhenReady |
| top-level / `fr/madu59/obe/client/chunk/ChunkTaskHolder.java` | `` |  | addTask, executeTasks, clearTasks, clearTasks |
| top-level / `fr/madu59/obe/client/compat/bclib/BclibCompat.java` | `` |  | init |
| top-level / `fr/madu59/obe/client/compat/emf/EMFCompat.java` | `` |  | applyRestPose, applyRestPose |
| top-level / `fr/madu59/obe/client/compat/iris/IrisCompat.java` | `` |  | isShadowPass |
| top-level / `fr/madu59/obe/client/compat/lootr/LootrCompat.java` | `` |  | init, getChestMaterial, getShulkerBoxMaterial, transformChest, getChestCacheKey, getShulkerBoxCacheKey |
| top-level / `fr/madu59/obe/client/compat/ModCompat.java` | `` |  | init, onWorldLoad, isIrisLoaded, isSodiumLoaded, isEMFLoaded, isPunchyLoaded, isShadowPass, applyEMFRestPose, isIncompatibilityDetected, getIncompatibleMod |
| top-level / `fr/madu59/obe/client/compat/ModCompatPlugin.java` | `` |  | shouldApplyMixin, onLoad, getRefMapperConfig, acceptTargets, getMixins, preApply, postApply |
| top-level / `fr/madu59/obe/client/config/configscreen/entries/builders/AbstractEntryBuilder.java` | `` |  | getDefaultIndent |
| top-level / `fr/madu59/obe/client/config/configscreen/entries/builders/ButtonBuilder.java` | `` |  | isEnabled, indent, indent, build |
| top-level / `fr/madu59/obe/client/config/configscreen/entries/builders/CategoryBuilder.java` | `` |  | isEnabled, style, build |
| top-level / `fr/madu59/obe/client/config/configscreen/entries/builders/SliderBuilder.java` | `` |  | isEnabled, indent, indent, range, step, build, updateMessage, applyValue |
| top-level / `fr/madu59/obe/client/config/configscreen/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `fr/madu59/obe/client/config/configscreen/MyConfigListWidget.java` | `` |  | update, scrollBarX, getRowWidth, addBuiltEntry, category, button, slider, extractContent, narratables, children, extractContent, narratables, children, mouseClicked, extractContent, narratables, children, updateState, getHeight, getContentHeight, isEnabled |
| top-level / `fr/madu59/obe/client/config/configscreen/OptimisedBlockEntitiesConfigScreen.java` | `` |  | registerCommand, init, onClose, extractRenderState |
| top-level / `fr/madu59/obe/client/config/configscreen/SodiumIntegration.java` | `` |  | afterSave, registerConfigLate, createBooleanOption |
| top-level / `fr/madu59/obe/client/config/Option.java` | `` |  | resetToDefault, getRunnable, getValue, getDefaultValue, getId, getName, getDescription, setToNextValue, setValue, setName, setDescription, cycle |
| top-level / `fr/madu59/obe/client/config/SettingsManager.java` | `` |  | saveSettings, toMap, loadSettings, getOptionValue, loadOptionWithDefaults, loadOptionWithDefaults, loadOptionWithDefaults, loadOptionWithDefaults |
| top-level / `fr/madu59/obe/client/mixin/blockentity/banner/BannerBlockEntityMixin.java` | `value={BannerBlockEntity.class})` | Inject:1 | obe$init |
| top-level / `fr/madu59/obe/client/mixin/blockentity/bell/BellBlockEntityMixin.java` | `value={BellBlockEntity.class})` | Inject:2 | obe$init, tick |
| top-level / `fr/madu59/obe/client/mixin/blockentity/BlockEntityMixin.java` | `value={BlockEntity.class})` | Inject:1 | obe$onSetBlockState |
| top-level / `fr/madu59/obe/client/mixin/blockentity/chest/ChestBlockEntityMixin.java` | `value={ChestBlockEntity.class})` | Inject:1, WrapMethod:1 | obe$init, obe$lidAnimateTick |
| top-level / `fr/madu59/obe/client/mixin/blockentity/chest/EnderChestBlockEntityMixin.java` | `value={EnderChestBlockEntity.class})` | Inject:1, WrapMethod:1 | obe$init, obe$lidAnimateTick |
| top-level / `fr/madu59/obe/client/mixin/blockentity/compat/lootr/LootrChestBlockEntityMixin.java` | `value={LootrChestBlockEntity.class}, remap=false)` | Inject:2 | obe$register, obe$lidAnimateTick |
| top-level / `fr/madu59/obe/client/mixin/blockentity/compat/lootr/LootrShulkerBoxBlockEntityMixin.java` | `value={LootrShulkerBoxBlockEntity.class}, remap=false)` | Inject:2 | obe$register, obe$lidAnimateTick |
| top-level / `fr/madu59/obe/client/mixin/blockentity/coppergolemstatues/CopperGolemStatueBlockEntityMixin.java` | `value={CopperGolemStatueBlockEntity.class})` | Inject:1 | init |
| top-level / `fr/madu59/obe/client/mixin/blockentity/decoratedpot/DecoratedPotBlockEntityMixin.java` | `value={DecoratedPotBlockEntity.class})` | Inject:5 | init, obe$load, obe$applyComponents, obe$triggerEvent, obe$updateTimer, obe$updatePot |
| top-level / `fr/madu59/obe/client/mixin/blockentity/ext/BlockEntityMixin.java` | `value={BlockEntity.class})` |  | obe$isSupported, obe$isSupported, obe$renderMode, obe$renderMode, obe$renderModeDelayed, obe$renderModeDelayed, obe$hasSpecialRenderer, obe$hasSpecialRenderer, obe$isEnabled, obe$isEnabled, obe$renderBoth, obe$renderBoth, obe$isTimerFinished, obe$setTimer, obe$shouldSkipRendering, obe$shouldSkipRendering, obe$shouldSkipRenderingAndUpdate, obe$forceEntity, obe$forceEntity |
| top-level / `fr/madu59/obe/client/mixin/blockentity/ext/BlockEntityRenderStateMixin.java` | `value={BlockEntityRenderState.class})` |  | blockEntity, blockEntity |
| top-level / `fr/madu59/obe/client/mixin/blockentity/lectern/LecternBlockEntityMixin.java` | `value={LecternBlockEntity.class})` | Inject:1 | obe$init |
| top-level / `fr/madu59/obe/client/mixin/blockentity/renderers/banner/BannerRendererMixin.java` | `value={BannerRenderer.class})` | Inject:2 | obe$cancelSubmit, obe$cancelExtract |
| top-level / `fr/madu59/obe/client/mixin/blockentity/renderers/bell/BellRendererMixin.java` | `value={BellRenderer.class})` | Inject:2 | obe$cancelSubmit, obe$cancelExtract |
| top-level / `fr/madu59/obe/client/mixin/blockentity/renderers/chest/ChestRendererMixin.java` | `value={ChestRenderer.class})` | Inject:2 | obe$cancelSubmit, obe$cancelExtract |
| top-level / `fr/madu59/obe/client/mixin/blockentity/renderers/coppergolemstatue/CopperGolemStatueBlockRendererMixin.java` | `value={CopperGolemStatueBlockRenderer.class})` | Inject:2 | obe$cancelSubmit, obe$cancelExtract |
| top-level / `fr/madu59/obe/client/mixin/blockentity/renderers/decoratedpot/DecoratedPotRendererMixin.java` | `value={DecoratedPotRenderer.class})` | Inject:2 | obe$cancelSubmit, obe$cancelExtract |
| top-level / `fr/madu59/obe/client/mixin/blockentity/renderers/shulkerbox/ShulkerBoxRendererMixin.java` | `value={ShulkerBoxRenderer.class})` | Inject:2 | obe$cancelSubmit, obe$cancelExtract |
| top-level / `fr/madu59/obe/client/mixin/blockentity/renderers/sign/AbstractSignRendererMixin.java` | `value={AbstractSignRenderer.class})` | Inject:1 | obe$cancelSignText, obe$isFacingCamera |
| top-level / `fr/madu59/obe/client/mixin/blockentity/renderers/skull/SkullBlockRendererMixin.java` | `value={SkullBlockRenderer.class})` | Inject:2 | obe$cancelSubmit, obe$cancelExtract |
| top-level / `fr/madu59/obe/client/mixin/blockentity/shulkerbox/ShulkerBoxBlockEntityMixin.java` | `value={ShulkerBoxBlockEntity.class})` | Inject:2 | obe$init, obe$updateAnimation |
| top-level / `fr/madu59/obe/client/mixin/blockentity/sign/SignTextMixin.java` | `value={SignText.class})` |  | obe$hasMessage |
| top-level / `fr/madu59/obe/client/mixin/blockentity/skull/SkullBlockEntityMixin.java` | `value={SkullBlockEntity.class})` | Inject:4 | obe$init, obe$updateAnimation, obe$checkProfile, obe$checkProfileBis, obe$isDynamicTexture |
| top-level / `fr/madu59/obe/client/mixin/BlockStateModelSetMixin.java` | `value={BlockStateModelSet.class})` | Inject:1 | obe$getBlockStateModel, obe$getOriginalModel |
| top-level / `fr/madu59/obe/client/mixin/core/ModelManagerMixin.java` | `value={ModelManager.class})` | Inject:1 | obe$onTextureReloadComplete |
| top-level / `fr/madu59/obe/client/mixin/entity/cushion/CushionMixin.java` | `value={Cushion.class})` | Inject:4 | obe$init, obe$beforeMove, obe$afterMove, obe$onColorChange |
| top-level / `fr/madu59/obe/client/mixin/entity/EntityMixin.java` | `value={Entity.class})` | Inject:1 | optimizedcushions$onDataUpdated |
| top-level / `fr/madu59/obe/client/mixin/entity/ext/EntityMixin.java` | `value={Entity.class})` |  | obe$isSupported, obe$isSupported, obe$renderMode, obe$renderMode, obe$renderModeDelayed, obe$renderModeDelayed, obe$hasSpecialRenderer, obe$hasSpecialRenderer, obe$isEnabled, obe$isEnabled, obe$isTimerFinished, obe$setTimer, obe$shouldSkipRendering, obe$shouldSkipRendering, obe$shouldSkipRenderingAndUpdate, obe$forceEntity, obe$forceEntity |
| top-level / `fr/madu59/obe/client/mixin/entity/ext/EntityRenderStateMixin.java` | `value={EntityRenderState.class})` |  | entity, entity |
| top-level / `fr/madu59/obe/client/mixin/entity/renderers/cushion/CushionRendererMixin.java` | `value={CushionRenderer.class})` | Inject:2 | obe$submit, obe$cancelExtract |
| top-level / `fr/madu59/obe/client/mixin/renderer/compat/sodium/ChunkBuilderMeshingTaskMixin.java` | `value={ChunkBuilderMeshingTask.class}, remap=false)` | WrapOperation:3, ModifyArg:1, Inject:1 | obe$getBlockState, obe$getRenderShape, obe$wrapRenderModel, obe$wrapShouldRender, obe$appendMeshData |
| top-level / `fr/madu59/obe/client/mixin/renderer/compat/sodium/RenderSectionManagerMixin.java` | `value={RenderSectionManager.class}, remap=false)` | WrapOperation:1 | obe$wrapProcessChunkBuildResults |
| top-level / `fr/madu59/obe/client/mixin/renderer/compat/sodium/SodiumWorldRendererMixin.java` | `value={SodiumWorldRenderer.class}, remap=false)` | Inject:2 | obe$preventUselessExtraction, obe$shouldRenderEntity |
| top-level / `fr/madu59/obe/client/mixin/renderer/compat/vulkanmod/BlockRendererMixin.java` | `value={BlockRenderer.class}, remap=false)` | WrapOperation:1 | obe$getCorrectedModel |
| top-level / `fr/madu59/obe/client/mixin/renderer/compat/vulkanmod/BuildTaskMixin.java` | `value={BuildTask.class}, remap=false)` | WrapOperation:2, Inject:2 | obe$getBlockState, obe$getRenderShape, obe$suppressEntityRender, obe$appendMeshData |
| top-level / `fr/madu59/obe/client/mixin/renderer/compat/vulkanmod/CompileResultMixin.java` | `value={CompileResult.class}, remap=false)` | Inject:1 | obe$executeChunkTasks |
| top-level / `fr/madu59/obe/client/mixin/renderer/compat/vulkanmod/WorldRendererMixin.java` | `value={WorldRenderer.class}, remap=false)` | WrapOperation:1 | obe$preventUselessExtraction |
| top-level / `fr/madu59/obe/client/mixin/renderer/LevelRendererMixin.java` | `value={LevelExtractor.class})` | WrapOperation:1, Inject:1 | obe$redirectGetRenderableBlockEntities, obe$shouldRenderEntity |
| top-level / `fr/madu59/obe/client/mixin/renderer/SectionCompilerMixin.java` | `value={SectionCompiler.class})` | WrapOperation:3, Inject:1 | obe$getBlockState, obe$getRenderShape, obe$wrapRenderModel, obe$appendCustomDataToCutout |
| top-level / `fr/madu59/obe/client/mixin/renderer/SectionRenderDispatcherMixin.java` | `value={SectionRenderDispatcher.RenderSection.class})` | Inject:1 | obe$onTaskDone |
| top-level / `fr/madu59/obe/client/model/BlockEntityStateModel.java` | `` |  | collectParts, generateModel, getBakedQuads, getDirection, shouldFixBFC, shouldSkipQuad, createQuadCollection, particleMaterial |
| top-level / `fr/madu59/obe/client/model/CompositeBlockStateModel.java` | `` |  | collectParts, particleMaterial |
| top-level / `fr/madu59/obe/client/OBEClient.java` | `` |  | onInitializeClient, debug |
| top-level / `fr/madu59/obe/client/platform/PlatformHelper.java` | `` |  | getPlatformName, isModLoaded, getConfigDir, getModName, registerPlatformEvents |
| top-level / `fr/madu59/obe/client/registry/MaterialGetter.java` | `` |  | init, registerDefault, register, register, getMaterial, getMaterial |
| top-level / `fr/madu59/obe/client/registry/ModelLayerLocationGetter.java` | `` |  | init, registerDefault, register, register, getModelLayerLocation, getModelLayerLocation |
| top-level / `fr/madu59/obe/client/registry/Registry.java` | `` |  | init, runWhenReady, register, registerGroup, addBlockEntityTypeInGroup, isSupported, isSupported, hasGroup, getGroup, getGroup, getGroupInternal, getBlockEntityType |
| top-level / `fr/madu59/obe/client/registry/SpecialModelGetter.java` | `` |  | init, registerDefault, register, register, getSpecialModelProvider, getSpecialModelProvider, keepOriginalModel, getModelLayerLocationProvider, getMaterialProvider, getTransformationProvider, getCacheKeyProvider, shouldKeepOriginalModel, getDummyCacheKey |
| top-level / `fr/madu59/obe/client/registry/TransformationGetter.java` | `` |  | init, registerDefault, register, register, applyTransformation, applyTransformation |
| top-level / `fr/madu59/obe/client/renderer/blockentity/BlockEntityModelsManager.java` | `` |  | getModel, getModel, getBlockModel, getDecoratedPotModel, getAmbientOcclusion, fail |
| top-level / `fr/madu59/obe/client/renderer/blockentity/ext/BlockEntityExt.java` | `` |  |  |
| top-level / `fr/madu59/obe/client/renderer/blockentity/ext/BlockEntityRenderStateExt.java` | `` |  |  |
| top-level / `fr/madu59/obe/client/renderer/blockentity/sign/ext/SignTextExt.java` | `` |  |  |
| top-level / `fr/madu59/obe/client/renderer/blockentity/SpecialBlockEntityRenderingManager.java` | `` |  | shouldSkipRendering, isContainerEmpty, isEmpty, hasMessage |
| top-level / `fr/madu59/obe/client/renderer/entity/ext/EntityExt.java` | `` |  |  |
| top-level / `fr/madu59/obe/client/renderer/entity/ext/EntityRenderStateExt.java` | `` |  |  |
| top-level / `fr/madu59/obe/client/renderer/entity/MeshableEntityTracker.java` | `` |  | registerMeshableEntity, deregisterMeshableEntity, deleteInvalidMeshableEntity, updateMeshableEntity, getMeshableEntities, getSectionMap, getSectionMap, getModel, isEnabled |
| top-level / `fr/madu59/obe/client/renderer/misc/RenderModeManager.java` | `` |  | setRenderMode, setRenderMode, shouldRenderEntity, shouldRenderEntity, shouldRenderEntity, shouldRenderEntity, shouldRenderEntity, shouldRenderEntity, shouldRenderEntity, shouldRenderEntity, shouldRenderEntity, shouldRenderEntityFast, setRenderModeDelayed, setRenderModeDelayed, setDirty, updateBlockEntityOnChunkRemesh, canBeTerrain |
| top-level / `fr/madu59/obe/client/resources/loader/SkullPackLoader.java` | `` |  | apply |
| top-level / `fr/madu59/obe/client/resources/ResourceUtil.java` | `` |  | getSprite, getOrCreateModel, getOrCreateModel, getOrCreateSubModel, getModel, getModel, cacheContains, cacheContains, cache, cache, clearCache, entityTextureFormatter, getDefaultModel, SpecialModelCacheKey, ModelCacheKey |
| top-level / `fr/madu59/obe/client/util/blockentity/BannerUtil.java` | `` |  | getMaterial, getModelLayerLocation, transform |
| top-level / `fr/madu59/obe/client/util/blockentity/BellUtil.java` | `` |  | getMaterial, getModelLayerLocation, transform, getMaterial, getModelLayerLocation, transform |
| top-level / `fr/madu59/obe/client/util/blockentity/ChestUtil.java` | `` |  | getMaterial, getModelLayerLocation, getModelLayerLocation, transform, transform, getChestMaterial, getChestModelLayerLocation, transformChest, getChestMaterial, getChestModelLayerLocation, transformChest, getOtherHalf |
| top-level / `fr/madu59/obe/client/util/blockentity/CopperGolemStatueUtil.java` | `` |  | getMaterial, getModelLayerLocation, transform |
| top-level / `fr/madu59/obe/client/util/blockentity/DecoratedPotUtil.java` | `` |  | getMaterial, getModelLayerLocation, getSideModelLayerLocation, transform |
| top-level / `fr/madu59/obe/client/util/blockentity/ShulkerBoxUtil.java` | `` |  | getMaterial, getModelLayerLocation, transform, getModelLayerLocation, transform |
| top-level / `fr/madu59/obe/client/util/blockentity/SkullBlockUtil.java` | `` |  | getMaterial, getModelLayerLocation, transform, transform, getModelLayerLocation, getMaterial, hasBuiltInTexture, getBuiltInTexture, getBuiltInTextureValue |
| top-level / `fr/madu59/obe/client/util/entity/CushionUtil.java` | `` |  | getModelLayerLocation, getMaterial, getModel, clearCache, CacheKey |
| top-level / `fr/madu59/obe/client/util/meshing/SectionMeshingUtil.java` | `` |  | getCorrectedRenderShape, getCorrectedModel |
| top-level / `fr/madu59/obe/OBE.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
