# More Culling

Review status: **Evidence inventory; behavioral review pending**

Project: [More Culling](https://modrinth.com/mod/moreculling)
Selected artifact version: `1.9.0`
Published implementation source: https://github.com/fxmorin/moreculling
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A mod that changes how multiple types of culling are handled in order to improve performance

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `7308b0b0b6fffb0e076cabf97db7fc889d9ada68`
- `sha512`: `b1975ef43606a3baa1c93a040fbef96abfbf46ae6a1e364c60effd03a42568f945ede0bde329241e87adc6a9c2769dd1d13ad286869c689018035eff677442b2`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 149
Reconstructed Java files: 135

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "ca.fxco.moreculling.MoreCullingFabric"
  ],
  "modmenu": [
    "ca.fxco.moreculling.config.ModMenuCompat"
  ],
  "sodium:config_api_user": [
    "ca.fxco.moreculling.config.sodium.MoreCullingSodiumConfigBuilder"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.15.0",
  "minecraft": ">=26.3",
  "java": ">=25",
  "cloth-config": ">=16.0.0"
}
```

**breaks**

```json
{
  "sodium": "<=0.6.6",
  "fabric-api": "<=0.145.2"
}
```

**accessWidener**

```json
"moreculling.classTweaker"
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/conditional-mixin-fabric-0.6.3.jar` | 19 | `conditional-mixin` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `ca/fxco/moreculling/api/block/LeavesCulling.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/block/MoreBlockCulling.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/blockstate/MoreStateCulling.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/blockstate/StateCullingShapeCache.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/config/ConfigAdditions.java` | `` |  | addOption, disableOption, disableOption, useSeparateTab, disableSeparateTab, isGroupSeparate, getOptions, getDisabledOptions |
| top-level / `ca/fxco/moreculling/api/config/ConfigModIncompatibility.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/config/ConfigModLimit.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/config/ConfigOption.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/config/ConfigOptionFlag.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/config/ConfigOptionImpact.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/config/ConfigSliderOption.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/config/defaults/ConfigBooleanOption.java` | `` |  | getTranslationKey, getSetter, getGetter, getChanged, getDefaultValue, getImpact, getFlag |
| top-level / `ca/fxco/moreculling/api/config/defaults/ConfigEnumOption.java` | `` |  | getTranslationKey, getSetter, getGetter, getChanged, getDefaultValue, getImpact, getFlag, getTypeClass, getLocalizedNames |
| top-level / `ca/fxco/moreculling/api/config/defaults/ConfigFloatOption.java` | `` |  | getTranslationKey, getSetter, getGetter, getChanged, getDefaultValue, getImpact, getFlag, getMin, getMax, getInterval, getStringFormat |
| top-level / `ca/fxco/moreculling/api/config/defaults/ConfigIntOption.java` | `` |  | getSetter, getGetter, getChanged, getTranslationKey, getDefaultValue, getImpact, getFlag, getMin, getMax, getInterval, getStringFormat |
| top-level / `ca/fxco/moreculling/api/config/OptionOverride.java` | `` |  | OptionOverride |
| top-level / `ca/fxco/moreculling/api/data/QuadBounds.java` | `` |  | getMinX, getMinY, getMaxX, getMaxY |
| top-level / `ca/fxco/moreculling/api/map/MapOpacity.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/model/BakedOpacity.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/model/CullShapeElement.java` | `` |  | deserialize, deserializeTo, deserializeFrom, deserializeVec3f |
| top-level / `ca/fxco/moreculling/api/model/ExtendedUnbakedModel.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/quad/QuadOpacity.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/renderers/ExtendedBlockModelRenderState.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/renderers/ExtendedItemStackRenderState.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/renderers/ExtendedLevelExtractor.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/renderers/ExtendedMapRenderState.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/renderers/ExtendedOrderedSubmitNodeCollector.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/renderers/ExtendedPaintingRenderState.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/api/renderers/modelsubmit/BlockModelSubmitFor3Faces.java` | `` |  | shouldCull |
| top-level / `ca/fxco/moreculling/api/renderers/modelsubmit/BlockModelSubmitForFace.java` | `` |  | shouldCull |
| top-level / `ca/fxco/moreculling/api/renderers/modelsubmit/BlockModelSubmitForFaces.java` | `` |  | shouldCull |
| top-level / `ca/fxco/moreculling/api/renderers/modelsubmit/BlockModelSubmitWithoutFace.java` | `` |  | shouldCull |
| top-level / `ca/fxco/moreculling/api/renderers/modelsubmit/MorecullingBlockModelSubmit.java` | `` |  | pose, renderType, modelParts, tintLayers, lightCoords, overlayCoords, tintColor, sheetedDecalPose, mesh, distanceToCameraSq, featureType |
| top-level / `ca/fxco/moreculling/api/renderers/MorecullingBlockModelFeatureRenderer.java` | `` |  | buildGroup, putPartQuads, putQuad |
| top-level / `ca/fxco/moreculling/api/renderers/MorecullingFabricBlockModelFeatureRenderer.java` | `` |  | emitDirectly, buildGroup, putPartQuads, bufferQuad, putQuad, clear |
| top-level / `ca/fxco/moreculling/api/sprite/SpriteOpacity.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/config/cloth/AbstractDynamicBuilder.java` | `` |  | getValue, getLocked, setLocked, setModIncompatibility, setModLimited, setValue, setErrorSupplier, requireRestart, setSaveConsumer, setChangeConsumer, setDefaultValue, setDefaultValue, setTooltip, setTooltipSupplier, setTooltipSupplier, build |
| top-level / `ca/fxco/moreculling/config/cloth/AbstractDynamicEntry.java` | `` |  | onChange, save, isEnabled, isLocked, isEdited, setEnabledState, getChangeConsumer, getValue, setValue, getOriginal, getDefaultValue, extractRenderState, getDisplayedFieldName, children, narratables |
| top-level / `ca/fxco/moreculling/config/cloth/DynamicBooleanBuilder.java` | `` |  | getYesNoTextSupplier, setYesNoTextSupplier, runBuild, getYesNoText |
| top-level / `ca/fxco/moreculling/config/cloth/DynamicBooleanListEntry.java` | `` |  | onChange, createMainWidget, onRender, getYesNoText |
| top-level / `ca/fxco/moreculling/config/cloth/DynamicEnumBuilder.java` | `` |  | setEnumNameProvider, runBuild |
| top-level / `ca/fxco/moreculling/config/cloth/DynamicEnumEntry.java` | `` |  | isEdited, setValue, getValue, createMainWidget, onRender, getDefaultIndex |
| top-level / `ca/fxco/moreculling/config/cloth/DynamicFloatSliderBuilder.java` | `` |  | setTextGetter, setMax, setMin, setStep, runBuild |
| top-level / `ca/fxco/moreculling/config/cloth/DynamicFloatSliderEntry.java` | `` |  | roundStep, getTextGetter, setTextGetter, setValue, createMainWidget, onRender, updateMessage, applyValue, keyPressed, mouseDragged, getProgress, setProgress, setValue |
| top-level / `ca/fxco/moreculling/config/cloth/DynamicIntSliderBuilder.java` | `` |  | setTextGetter, setMax, setMin, runBuild |
| top-level / `ca/fxco/moreculling/config/cloth/DynamicIntSliderEntry.java` | `` |  | getTextGetter, setTextGetter, setValue, createMainWidget, onRender, updateMessage, applyValue, keyPressed, mouseDragged, getProgress, setProgress, setValue |
| top-level / `ca/fxco/moreculling/config/cloth/MoreCullingClothConfigBuilder.java` | `` |  | create, isAlwaysShowTabs, setAlwaysShowTabs, setTransparentBackground, hasTransparentBackground, setAfterInitConsumer, setGlobalized, setGlobalizedExpanded, setFallbackCategory, getParentScreen, setParentScreen, getTitle, setTitle, isEditable, setEditable, getOrCreateCategory, removeCategory, removeCategoryIfExists, hasCategory, setShouldTabsSmoothScroll, isTabsSmoothScrolling, setShouldListSmoothScroll, isListSmoothScrolling, setDoesConfirmSave, doesConfirmSave, getDefaultBackgroundTexture, setDefaultBackgroundTexture, setSavingRunnable, getAfterInitConsumer, build, getSavingRunnable |
| top-level / `ca/fxco/moreculling/config/cloth/MoreCullingClothConfigCategory.java` | `` |  | getCategoryKey, getEntries, addEntry, setCategoryBackground, removeCategory, setBackground, getBackground, getDescription, setDescription |
| top-level / `ca/fxco/moreculling/config/cloth/MoreCullingClothConfigScreen.java` | `` |  | init, isTransparentBackground |
| top-level / `ca/fxco/moreculling/config/ConfigUpdater.java` | `` |  | updateConfig |
| top-level / `ca/fxco/moreculling/config/MixinConfigPlugin.java` | `` |  | onLoad, getRefMapperConfig, acceptTargets, getMixins |
| top-level / `ca/fxco/moreculling/config/ModMenuCompat.java` | `` |  | getModConfigScreenFactory |
| top-level / `ca/fxco/moreculling/config/ModMenuConfig.java` | `` |  | createConfigScreen, createConfigScreenBuilder, generateConfigCategories |
| top-level / `ca/fxco/moreculling/config/MoreCullingConfig.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/config/option/LeavesCullingMode.java` | `` |  | getText, getKey, hasAmount, getLocalizedNames |
| top-level / `ca/fxco/moreculling/config/sodium/MoreCullingSodiumConfigBuilder.java` | `` |  | registerConfigLate, isEnabled |
| top-level / `ca/fxco/moreculling/config/sodium/MoreCullingSodiumOptionsStorage.java` | `` |  | getData, save, setSignTextCulling, getSignTextCulling, setRainCulling, getRainCulling, setIncludeMangroveRoots, getIncludeMangroveRoots, setEndGatewayCulling, getEndGatewayCulling, setUseBlockStateCulling, getUseBlockStateCulling, setLeavesCullingAmount, getLeavesCullingAmount, setLeavesCullingMode, getLeavesCullingMode |
| top-level / `ca/fxco/moreculling/mixin/accessors/BlockBehaviourAccessor.java` | `value={BlockBehaviour.class})` | Invoker:1 |  |
| top-level / `ca/fxco/moreculling/mixin/accessors/BlockStateModelSetAccessor.java` | `value={BlockStateModelSet.class})` | Accessor:1 |  |
| top-level / `ca/fxco/moreculling/mixin/accessors/SpriteContentsAccessor.java` | `value={SpriteContents.class})` | Accessor:1 |  |
| top-level / `ca/fxco/moreculling/mixin/BakedQuad_cacheMixin.java` | `value={BakedQuad.class})` |  | moreculling$getTextureTranslucency, moreculling$resetTranslucencyCache |
| top-level / `ca/fxco/moreculling/mixin/blockentity/SignRenderer_textMixin.java` | `value={AbstractSignRenderer.class})` | WrapOperation:1 | moreculling$cullSignText |
| top-level / `ca/fxco/moreculling/mixin/blocks/BaseRailBlock_cullAgainstMixin.java` | `value={BaseRailBlock.class})` |  | moreculling$cantCullAgainst |
| top-level / `ca/fxco/moreculling/mixin/blocks/cullshape/BaseTorchBlock_voxelMixin.java` | `value={BaseTorchBlock.class})` |  | getOcclusionShape |
| top-level / `ca/fxco/moreculling/mixin/blocks/cullshape/BrewingStandBlock_voxelMixin.java` | `value={BrewingStandBlock.class})` |  | getOcclusionShape |
| top-level / `ca/fxco/moreculling/mixin/blocks/cullshape/CampfireBlock_voxelMixin.java` | `value={CampfireBlock.class})` |  | getOcclusionShape |
| top-level / `ca/fxco/moreculling/mixin/blocks/cullshape/ChorusFlowerBlock_voxelMixin.java` | `value={ChorusFlowerBlock.class})` |  | getOcclusionShape |
| top-level / `ca/fxco/moreculling/mixin/blocks/cullshape/EndRodBlock_voxelMixin.java` | `value={EndRodBlock.class})` |  | getOcclusionShape |
| top-level / `ca/fxco/moreculling/mixin/blocks/cullshape/LightningRodBlock_voxelMixin.java` | `value={LightningRodBlock.class})` |  | getOcclusionShape |
| top-level / `ca/fxco/moreculling/mixin/blocks/cullshape/MossyCarpetBlock_voxelMixin.java` | `value={MossyCarpetBlock.class})` |  | getOcclusionShape |
| top-level / `ca/fxco/moreculling/mixin/blocks/DoorBlock_cullAgainstMixin.java` | `value={DoorBlock.class})` |  | moreculling$cantCullAgainst |
| top-level / `ca/fxco/moreculling/mixin/blocks/EndGatewayBlock_cullMixin.java` | `value={EndGatewayBlock.class})` |  | getRenderShape, moreculling$shouldAttemptToCull, moreculling$shouldAttemptToCullAgainst, getOcclusionShape |
| top-level / `ca/fxco/moreculling/mixin/blocks/LadderBlock_cullAgainstMixin.java` | `value={LadderBlock.class})` |  | moreculling$cantCullAgainst |
| top-level / `ca/fxco/moreculling/mixin/blocks/LeavesBlock_typesMixin.java` | `value={LeavesBlock.class}, priority=1220)` | Inject:1 | skipRendering, moreculling$usesCustomShouldDrawFace, moreculling$customShouldDrawFace, moreculling$cantCullAgainst |
| top-level / `ca/fxco/moreculling/mixin/blocks/MangroveRootsBlock_typesMixin.java` | `value={MangroveRootsBlock.class}, priority=1220)` | Inject:1 | moreculling$skipRendering, moreculling$usesCustomShouldDrawFace, moreculling$customShouldDrawFace |
| top-level / `ca/fxco/moreculling/mixin/blocks/PowderSnowBlock_cullMixin.java` | `value={PowderSnowBlock.class}, priority=1200)` |  | moreculling$usesCustomShouldDrawFace, moreculling$customShouldDrawFace |
| top-level / `ca/fxco/moreculling/mixin/blocks/ShulkerBoxBlock_cullMixin.java` | `value={ShulkerBoxBlock.class})` |  | getOcclusionShape, moreculling$cantCullAgainst |
| top-level / `ca/fxco/moreculling/mixin/blockstates/Block_drawSideMixin.java` | `value={Block.class}, priority=2500)` |  | moreculling$cantCullAgainst, moreculling$shouldAttemptToCull, moreculling$shouldAttemptToCullAgainst, moreculling$canCull, moreculling$setCanCull |
| top-level / `ca/fxco/moreculling/mixin/blockstates/Block_fabricDrawSideMixin.java` | `value={Block.class}, priority=2500)` | Inject:1 | moreculling$customShouldDrawSide |
| top-level / `ca/fxco/moreculling/mixin/blockstates/BlockStateBase_moreMixin.java` | `value={BlockBehaviour.BlockStateBase.class})` |  | moreculling$hasQuadsOnSide, moreculling$setHasQuadsOnSide, moreculling$hasTextureTranslucency, moreculling$setHasTextureTranslucency, moreculling$usesCustomShouldDrawFace, moreculling$customShouldDrawFace, moreculling$shouldAttemptToCull, moreculling$shouldAttemptToCullAgainst, moreculling$cantCullAgainst, moreculling$canCull |
| top-level / `ca/fxco/moreculling/mixin/blockstates/Minecraft_loadBlocksMixin.java` | `value={Minecraft.class})` | Inject:1 | moreculling$onInit |
| top-level / `ca/fxco/moreculling/mixin/compat/AbstractBlockRenderContext_vulkanModMixin.java` | `value={AbstractBlockRenderContext.class})` | Inject:1 | moreculling$useMoreCulling |
| top-level / `ca/fxco/moreculling/mixin/compat/BlockOcclusionCache_sodiumMixin.java` | `value={AbstractBlockRenderContext.class})` | Inject:1 | moreculling$useMoreCulling |
| top-level / `ca/fxco/moreculling/mixin/compat/MorecullingFabricBlockModelFeatureRenderer_sodiumMixin.java` | `value={MorecullingFabricBlockModelFeatureRenderer.class})` | WrapOperation:1 | emitDirectly, render, bufferQuad |
| top-level / `ca/fxco/moreculling/mixin/compat/SignBlock_ebeMixin.java` | `value={SignBlock.class})` |  | getOcclusionShape |
| top-level / `ca/fxco/moreculling/mixin/entities/ItemFrameRenderer_cullMixin.java` | `value={ItemFrameRenderer.class}, priority=1200)` | WrapOperation:2, Inject:1 | moreculling$cullFrame, moreculling$cullItem, moreculling$cullFrameWithMap |
| top-level / `ca/fxco/moreculling/mixin/LevelExtractor_frustumMixin.java` | `value={LevelExtractor.class})` | WrapOperation:1 | storeFrustum, moreculling$getFrustum |
| top-level / `ca/fxco/moreculling/mixin/MapItemSavedData_cacheMixin.java` | `value={MapItemSavedData.class})` | Inject:2 | moreculling$hasTransparency, moreculling$onSetColor, moreculling$onLoad |
| top-level / `ca/fxco/moreculling/mixin/Minecraft_managersMixin.java` | `value={Minecraft.class})` | Inject:1 | moreculling$onBakedModelManagerInitialized |
| top-level / `ca/fxco/moreculling/mixin/Minecraft_registerReloadListenersMixin.java` | `value={Minecraft.class})` | Inject:2 | moreculling$onBlockRenderManagerInitialized, onStart |
| top-level / `ca/fxco/moreculling/mixin/models/BakedModel_extendsMixin.java` | `value={BlockStateModel.class})` |  |  |
| top-level / `ca/fxco/moreculling/mixin/models/cullshape/BlockModel_cullShapeMixin.java` | `value={CuboidModel.class})` | WrapOperation:1 | moreculling$setCullShapeElements, moreculling$getCullShapeElements, moreculling$setUseModelShape, moreculling$getUseModelShape, moreculling$setHasAutoModelShape, moreculling$getHasAutoModelShape, moreculling$registerCustomTypeAdapter |
| top-level / `ca/fxco/moreculling/mixin/models/cullshape/BlockStateBase_cullShapeMixin.java` | `value={BlockBehaviour.BlockStateBase.class})` |  | moreculling$initCustomCullingShape, moreculling$getFaceCullingShape |
| top-level / `ca/fxco/moreculling/mixin/models/cullshape/BlockStateModelPart_extendsMixin.java` | `value={BlockStateModelPart.class})` |  |  |
| top-level / `ca/fxco/moreculling/mixin/models/cullshape/Deserializer_cullShapeMixin.java` | `value={CuboidModel.Deserializer.class})` | Inject:1 | moreculling$onDeserialize, moreculling$cullshapesFromJson |
| top-level / `ca/fxco/moreculling/mixin/models/cullshape/ModelManager_cullShapeMixin.java` | `value={ModelManager.class}, priority=1050)` | ModifyArg:1 | moreculling$enableModelShape |
| top-level / `ca/fxco/moreculling/mixin/models/cullshape/SimpleModelWrapper_cullShapeMixin.java` | `value={SimpleModelWrapper.class})` | Inject:1 | moreculling$onBake, moreculling$getCullingShape, moreculling$setCullingShape, moreculling$canSetCullingShape, moreculling$getHasAutoModelShape, moreculling$setHasAutoModelShape |
| top-level / `ca/fxco/moreculling/mixin/models/cullshape/UnbakedModel_extendsMixin.java` | `value={UnbakedModel.class})` |  |  |
| top-level / `ca/fxco/moreculling/mixin/models/MultiPartModel_cacheMixin.java` | `value={MultiPartModel.class}, priority=1010)` |  | moreculling$resetTranslucencyCache, moreculling$getCullingShape |
| top-level / `ca/fxco/moreculling/mixin/models/SingleVariant_cacheMixin.java` | `value={SingleVariant.class})` |  | moreculling$resetTranslucencyCache, moreculling$getCullingShape, moreculling$setCullingShape, moreculling$canSetCullingShape, moreculling$getHasAutoModelShape, moreculling$setHasAutoModelShape |
| top-level / `ca/fxco/moreculling/mixin/models/WeightedVariants_cacheMixin.java` | `value={WeightedVariants.class}, priority=1010)` |  | moreculling$resetTranslucencyCache |
| top-level / `ca/fxco/moreculling/mixin/models/WrapperBlockStateModel_cullMixin.java` | `value={WrapperBlockStateModel.class})` |  | moreculling$resetTranslucencyCache, moreculling$getCullingShape, moreculling$setCullingShape, moreculling$getHasAutoModelShape, moreculling$setHasAutoModelShape, moreculling$canSetCullingShape |
| top-level / `ca/fxco/moreculling/mixin/renderers/BlockModelRenderState_cullMixin.java` | `value={BlockModelRenderState.class})` |  | moreculling$submitModelWithoutFace, moreculling$submitModelForFace, moreculling$submitModelFor3Faces, moreculling$submitModelForFaces |
| top-level / `ca/fxco/moreculling/mixin/renderers/BlockModelRenderState_fabricCullMixin.java` | `value={BlockModelRenderState.class}, priority=1200)` |  | moreculling$submitModelWithoutFace, moreculling$submitModelForFace, moreculling$submitModelFor3Faces, moreculling$submitModelForFaces |
| top-level / `ca/fxco/moreculling/mixin/renderers/FeatureRenderDispatcher_cullMixin.java` | `value={FeatureRenderDispatcher.class})` | Inject:1 | moreculling$registerMorecullingModelSubmits |
| top-level / `ca/fxco/moreculling/mixin/renderers/FeatureRenderDispatcher_fabricCullMixin.java` | `value={FeatureRenderDispatcher.class})` | Inject:1 | moreculling$registerMorecullingModelSubmits |
| top-level / `ca/fxco/moreculling/mixin/renderers/ItemStackRenderState_apiMixin.java` | `value={ItemStackRenderState.class})` |  | moreculling$submitBakedItemModelWithoutFace, moreculling$submitBakedItemModelOnly3Faces, moreculling$submitBakedItemModelForFace, moreculling$submitItemFrameItem |
| top-level / `ca/fxco/moreculling/mixin/renderers/ItemStackRenderState_faceCullingMixin.java` | `value={ItemStackRenderState.LayerRenderState.class}, priority=1100)` | WrapOperation:1 | moreculling$onlySomeFaces$Vanilla |
| top-level / `ca/fxco/moreculling/mixin/renderers/MapRenderer_cullMixin.java` | `value={MapRenderer.class})` | Inject:1 | moreculling$checkForTransparency |
| top-level / `ca/fxco/moreculling/mixin/renderers/MapRenderState_apiMixin.java` | `value={MapRenderState.class})` |  | moreculling$hasTransparency, moreculling$setHasTransparency |
| top-level / `ca/fxco/moreculling/mixin/renderers/OrderedSubmitNodeCollector_apiMixin.java` | `value={OrderedSubmitNodeCollector.class})` |  |  |
| top-level / `ca/fxco/moreculling/mixin/renderers/PaintingRenderer_faceCullingMixin.java` | `value={PaintingRenderer.class})` | Inject:1, WrapOperation:2 | vertex, moreculling$getPaintingPos, moreculling$getPaintingPos, moreculling$cullFace |
| top-level / `ca/fxco/moreculling/mixin/renderers/PaintingRenderState_apiMixin.java` | `value={PaintingRenderState.class})` |  | moreculling$getBlockPoses, moreculling$setBlockPos |
| top-level / `ca/fxco/moreculling/mixin/renderers/SubmitNodeCollection_apiMixin.java` | `value={SubmitNodeCollection.class})` |  | moreculling$submitBlockModelWithoutFace, moreculling$submitBlockModelForFace, moreculling$submitBlockModelFor3Faces, moreculling$submitBlockModelForFaces |
| top-level / `ca/fxco/moreculling/mixin/renderers/SubmitNodeStorage_apiMixin.java` | `value={SubmitNodeStorage.class})` |  | moreculling$submitBlockModelWithoutFace, moreculling$submitBlockModelForFace, moreculling$submitBlockModelFor3Faces, moreculling$submitBlockModelForFaces |
| top-level / `ca/fxco/moreculling/mixin/TextureAtlasSprite_opacityMixin.java` | `value={TextureAtlasSprite.class})` |  | moreculling$getUnmipmappedImage, moreculling$hasTransparency, moreculling$hasTransparency, moreculling$hasTranslucency, moreculling$hasTranslucency, moreculling$hasTranslucency, moreculling$hasTranslucency |
| top-level / `ca/fxco/moreculling/mixin/WeatherEffectRenderer_rainMixin.java` | `value={WeatherEffectRenderer.class})` | WrapOperation:1 | moreculling$checkRainFrustum |
| top-level / `ca/fxco/moreculling/MoreCulling.java` | `` |  | init, deserialize, saveConfig |
| top-level / `ca/fxco/moreculling/MoreCullingFabric.java` | `` |  | onInitializeClient |
| top-level / `ca/fxco/moreculling/platform/FabricPlatformHelper.java` | `` |  | getPlatformName, isModLoaded, isDevelopmentEnvironment, getModName, getQuads |
| top-level / `ca/fxco/moreculling/platform/services/IPlatformHelper.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/platform/Services.java` | `` |  | load |
| top-level / `ca/fxco/moreculling/states/ItemRendererStates.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/utils/BitUtils.java` | `` |  | set, unset, get, fromStringByte, set, unset, get, fromStringShort, set, unset, get, fromStringInt, set, unset, get, fromStringLong |
| top-level / `ca/fxco/moreculling/utils/CacheUtils.java` | `` |  | resetAllCache |
| top-level / `ca/fxco/moreculling/utils/CompatUtils.java` | `` |  |  |
| top-level / `ca/fxco/moreculling/utils/CullingUtils.java` | `` |  | shouldDrawSideCulling, shouldDrawFace, areLeavesOpaque, shouldDrawFaceCheck, shouldDrawFaceGap, shouldDrawFaceDepth, shouldDrawFaceRandom, shouldCullBack, shouldShowMapFace, shouldHideWallSignText, cullSignText, isSignTextEmpty, shouldCullPaintingBack, cullItemQuads |
| top-level / `ca/fxco/moreculling/utils/DirectionBits.java` | `` |  | add, add, remove, remove, clear, fill, contains, contains, isEmpty, containsAny, isFull, notFull, getBits, of, of, of, fromStringByte |
| top-level / `ca/fxco/moreculling/utils/DirectionUtils.java` | `` |  | getAllDirectionsExcluding, changeDirectionUsingTransformation, magicalRotation, shiftDirection |
| top-level / `ca/fxco/moreculling/utils/ImprovedThreadLocal.java` | `` |  | initialValue, get, set, remove |
| top-level / `ca/fxco/moreculling/utils/MathUtils.java` | `` |  | isBehindLine, isAngleBetween, clamp, clamp |
| top-level / `ca/fxco/moreculling/utils/ShapeUtils.java` | `` |  | orUnoptimized |
| top-level / `ca/fxco/moreculling/utils/SpriteUtils.java` | `` |  | doesHaveTransparency, doesHaveTransparency, doesHaveTransparency, doesHaveTransparency, doesHaveTranslucency, doesHaveTranslucency, doesHaveTranslucency, printOpacity, printOpacity, printOpacity |
| top-level / `ca/fxco/moreculling/utils/TransformationUtils.java` | `` |  | canCullTransformation |
| top-level / `ca/fxco/moreculling/utils/VertexUtils.java` | `` |  | isTriangleInvisible, applyTransformation, getUv, getQuadUvBounds, isAxisAligned |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
