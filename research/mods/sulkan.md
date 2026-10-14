# Sulkan

Review status: **Evidence inventory; behavioral review pending**

Project: [Sulkan](https://modrinth.com/mod/sulkan)
Selected artifact version: `0.5.1`
Published implementation source: https://github.com/mravatins/sulkanShaders
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Native Vulkan shaders for Minecraft 26.2. Client-side Fabric mod powered by Sodium, with a built-in shader pack and support for native Sulkan packs.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `b8b4a3268d9b91240952ba81da21caa5c68a39a142e688ebaee6195df6ad795b778f7ac7c8d2cc0bb995299485bf3510f2da84b40f4c027b4afdec27cd88a154`
- `sha1`: `a0a687fdc0a33539a17f51972415c90121484771`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 112
Reconstructed Java files: 79

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.sulkan.shaders.SulkanShadersClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.4",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": ">=0.160.5",
  "sodium": ">=0.9.2"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/sulkan/shaders/config/ShaderConfig.java` | `` |  | enabled, selectedPackId, withSelection, load, save, configPath |
| top-level / `com/sulkan/shaders/config/ShaderQualityPreset.java` | `` |  | serializedName, tier, enabled, displayName, fromSerializedName |
| top-level / `com/sulkan/shaders/graph/ComputeProgram.java` | `` |  | prefix, formatName, type, allocateDescriptors, check, close, Descriptors |
| top-level / `com/sulkan/shaders/graph/GraphAllocations.java` | `` |  | GraphAllocations, plan |
| top-level / `com/sulkan/shaders/graph/GraphBuffers.java` | `` |  | close |
| top-level / `com/sulkan/shaders/graph/GraphFrame.java` | `` |  | matrixReady, projectionChanged |
| top-level / `com/sulkan/shaders/graph/GraphGpuSmoke.java` | `` |  | tick, finishWorldSmoke, setupDemoScene, checkMaterialEncoding |
| top-level / `com/sulkan/shaders/graph/GraphMipmaps.java` | `` |  |  |
| top-level / `com/sulkan/shaders/graph/GraphRenderer.java` | `` |  | materials, heldShadows, renderedFrames, sceneReplacementCount, invalidateHistory, terrainCaptures, captureTerrain, captureWorldDepth, pipeline, allocate, render, image, generateMipmaps, resolve, sampler, loadTextures, beginScene, weatherView, handProjection, projection, environment, environment, shadowQuality, shadowDistance, animatedShadowCasters, scenePipeline, scenePipeline, sceneFallback, sceneAttachments, hasSceneAttachments, bindSceneUniforms, destroy, close, close |
| top-level / `com/sulkan/shaders/graph/GraphSceneCapture.java` | `` |  | close, close |
| top-level / `com/sulkan/shaders/graph/GraphShaderSources.java` | `` |  | put, get, contains, isNative, remember, original, compile, onRetire, remove, Source, isNative, getShader, applyImport, getInclude, close, text |
| top-level / `com/sulkan/shaders/graph/HeldLight.java` | `` |  | active, position, prepareMatrices, matrix, createFaceBases, faceMatrix, faceMatrix |
| top-level / `com/sulkan/shaders/graph/MaterialChunkVertex.java` | `` |  | getVertexFormat, getEncoder |
| top-level / `com/sulkan/shaders/graph/MaterialContext.java` | `` |  | enter, leave, clearIce |
| top-level / `com/sulkan/shaders/graph/MaterialTable.java` | `` |  | enabled, id |
| top-level / `com/sulkan/shaders/graph/NativeEnvironmentSmoke.java` | `` |  | setup, fail |
| top-level / `com/sulkan/shaders/graph/NativePackRuntime.java` | `` |  | captureHandProjection, captureWorldProjection, isNative, selected, packFiles, prepare, settings, optionFile, loadOptions, applyOptions, activate, render, heldShadows, usesNativeTransparency, scope, beginScene, finishScene, sceneAttachments, scenePipeline, pause, bindSceneUniforms, weatherView, captureTerrain, captureTranslucentDepth, terrainCaptures, captureWorldDepth, failScene, failure, renderedFrames, sceneReplacementCount, replacesEnvironment, shadowQuality, shadowDistance, animatedShadowCasters, shadowFrameReady, materials, rebuildGeometry, requestGeometryRebuild, flushGeometryRebuild, close |
| top-level / `com/sulkan/shaders/graph/NativeShadowSmoke.java` | `` |  | captureStability, checkMaps, select, capture, fail |
| top-level / `com/sulkan/shaders/graph/PackFiles.java` | `` |  | read, bundled, rooted, add, safe, text, binary, shader, expand |
| top-level / `com/sulkan/shaders/graph/PackGraph.java` | `` |  | PackGraph, shadowQuality, shadowDistance, parse, withOptions, schedule, visit, allocationBytes, bufferBytes, previous, current, identifier, keys, required, integer, Environment, Option, Pass, isCompute, Resource, width, height, sameShape, mipLevels, bytes, SceneProgram, matches, Buffer, BufferBinding, Texture |
| top-level / `com/sulkan/shaders/graph/PackSwitchSmoke.java` | `` |  | rendered, log, select, fail |
| top-level / `com/sulkan/shaders/graph/ScenePrograms.java` | `` |  | targets, close, Sources, defines, layouts |
| top-level / `com/sulkan/shaders/graph/SceneRenderPass.java` | `` |  | wrap, outside, close, pushDebugGroup, popDebugGroup, writeTimestamp, setPipeline, setUniform, setUniform, setUniform, pushConstants, enableScissor, disableScissor, setVertexBuffer, setIndexBuffer, drawIndexed, multiDrawIndexed, multiDrawIndexed, drawIndexedIndirect, drawMultipleIndexed, draw, multiDraw, multiDraw, drawIndirect |
| top-level / `com/sulkan/shaders/graph/StorageImageScope.java` | `` |  | active, depth, close |
| top-level / `com/sulkan/shaders/graph/WaterReflectionSmoke.java` | `` |  | options, setup, fail |
| top-level / `com/sulkan/shaders/mixin/CloudRendererMixin.java` | `value={CloudRenderer.class})` | Inject:1 | sulkan$renderVolumetricClouds |
| top-level / `com/sulkan/shaders/mixin/GraphDeviceAccessor.java` | `value={FrontendGpuDevice.class})` | Accessor:1 |  |
| top-level / `com/sulkan/shaders/mixin/GraphStorageTextureMixin.java` | `value={VulkanGpuTexture.class})` | ModifyArg:5 | sulkan$storageUsage, sulkan$imageDimension, sulkan$imageDepth, sulkan$volumeLayers, sulkan$volumeBarrierLayers |
| top-level / `com/sulkan/shaders/mixin/GraphStorageViewMixin.java` | `value={VulkanGpuTextureView.class})` | ModifyArg:1 | sulkan$volumeView |
| top-level / `com/sulkan/shaders/mixin/LevelRendererPostMixin.java` | `value={LevelRenderer.class})` | Inject:1 | sulkan$prepareVolumetricCloudFrame |
| top-level / `com/sulkan/shaders/mixin/LevelRendererShadowMixin.java` | `value={LevelRenderer.class})` | Inject:3 | sulkan$collectDirectionalShadowEntities, sulkan$addDirectionalShadowPass, sulkan$renderSodiumTerrainShadow, sulkan$closeDirectionalShadowFeatureDispatcher, sulkan$renderShadowEntityFrame, sulkan$prepareAndRenderShadowEntities, sulkan$shadowFeatureDispatcher, sulkan$submitNativeShadowEntities, sulkan$hasShadowSubmits |
| top-level / `com/sulkan/shaders/mixin/NativeFrameBoundaryMixin.java` | `value={Minecraft.class})` | Inject:1 | sulkan$rebuildAtFrameBoundary |
| top-level / `com/sulkan/shaders/mixin/NativePipelineCacheMixin.java` | `value={PipelineCache.class})` | Inject:3 | sulkan$nativePipeline, sulkan$rememberPipeline, sulkan$rememberPrecompiled |
| top-level / `com/sulkan/shaders/mixin/NativeRenderPassMixin.java` | `value={FrontendRenderPass.class})` | ModifyVariable:1, Inject:1 | sulkan$nativeScenePipeline, sulkan$nativeFrameUniforms |
| top-level / `com/sulkan/shaders/mixin/NativeSceneAttachmentsMixin.java` | `value={FrontendCommandEncoder.class})` | ModifyVariable:1, Inject:1 | sulkan$sceneTargets, sulkan$splitScenePass |
| top-level / `com/sulkan/shaders/mixin/NativeSceneMixin.java` | `value={GameRenderer.class})` | Inject:4 | sulkan$nativeTransparency, sulkan$beginNativeScene, sulkan$preserveWorldDepthBeforeHand, sulkan$finishNativeScene |
| top-level / `com/sulkan/shaders/mixin/NativeWeatherMixin.java` | `value={WeatherEffectRenderer.class})` | Inject:1 | sulkan$weatherLayer |
| top-level / `com/sulkan/shaders/mixin/NativeWorldProjectionMixin.java` | `value={GameRenderer.class})` | ModifyArg:2 | sulkan$captureWorldProjection, sulkan$captureHandProjection |
| top-level / `com/sulkan/shaders/mixin/OptionsBackendMixin.java` | `value={Options.class})` | Inject:1 | sulkan$preferVulkanOnCleanStartup |
| top-level / `com/sulkan/shaders/mixin/OptionsScreenMixin.java` | `value={OptionsScreen.class})` | ModifyArg:1 | sulkan$addShadersButton |
| top-level / `com/sulkan/shaders/mixin/RenderPipelinesAccessor.java` | `value={RenderPipelines.class})` | Accessor:1 | sulkan$entitySnippet |
| top-level / `com/sulkan/shaders/mixin/RenderTypeMixin.java` | `value={PreparedRenderType.class})` | Inject:1 | sulkan$drawEntityShadowCaster |
| top-level / `com/sulkan/shaders/mixin/SkyRendererMixin.java` | `value={SkyRenderer.class})` | Inject:1 | sulkan$renderCustomCelestialOrbit |
| top-level / `com/sulkan/shaders/mixin/sodium/BlockMaterialMixin.java` | `value={BlockRenderer.class}, remap=false)` | ModifyArg:1, Inject:2 | sulkan$clearIceLayer, sulkan$material, sulkan$clearMaterial |
| top-level / `com/sulkan/shaders/mixin/sodium/FluidMaterialMixin.java` | `value={FluidRendererImpl.class}, remap=false)` | Inject:2 | sulkan$fluidMaterial, sulkan$clearFluidMaterial |
| top-level / `com/sulkan/shaders/mixin/sodium/MaterialVertexFormatMixin.java` | `value={ChunkMeshFormats.class}, remap=false)` | Inject:1 | sulkan$materialFormat |
| top-level / `com/sulkan/shaders/mixin/sodium/RenderRegionMixin.java` | `value={RenderRegion.class}, remap=false)` | Inject:7 | sulkan$shareSourceMeshStorage, sulkan$useDedicatedShadowBatch, sulkan$invalidateShadowBatches, sulkan$markShadowPlansDirty, sulkan$markClearedShadowPlansDirty, sulkan$clearResizedShadowBatches, sulkan$deleteShadowBatches, sulkan$clearShadowBatches, sulkan$shadowRevision |
| top-level / `com/sulkan/shaders/mixin/sodium/RenderSectionManagerAccessor.java` | `value={RenderSectionManager.class}, remap=false)` | Accessor:1 |  |
| top-level / `com/sulkan/shaders/mixin/sodium/ShaderChunkRendererMixin.java` | `value={ShaderChunkRenderer.class}, remap=false)` | Inject:1 | createShader, sulkan$useTerrainShadowPipeline |
| top-level / `com/sulkan/shaders/mixin/sodium/ShadowChunkPreparationMixin.java` | `value={DefaultChunkRenderer.class}, remap=false)` | ModifyExpressionValue:1, WrapOperation:1 | sulkan$drawFlags, sulkan$prepareShadowBatch, sulkan$combineOpaqueShadowCommands |
| top-level / `com/sulkan/shaders/mixin/sodium/ShadowPassIndexMixin.java` | `value={DefaultTerrainRenderPasses.class}, remap=false)` | Inject:1 | sulkan$shadowPassIndex |
| top-level / `com/sulkan/shaders/mixin/sodium/SodiumWorldRendererAccessor.java` | `value={SodiumWorldRenderer.class}, remap=false)` | Accessor:2 |  |
| top-level / `com/sulkan/shaders/mixin/sodium/SodiumWorldRendererMixin.java` | `value={SodiumWorldRenderer.class}, remap=false)` | Inject:2 | sulkan$captureSceneBeforeSodiumTranslucent, sulkan$captureTranslucentDepth |
| top-level / `com/sulkan/shaders/mixin/sodium/TerrainRenderPassMixin.java` | `value={TerrainRenderPass.class}, remap=false)` | Inject:1 | sulkan$useShadowTarget |
| top-level / `com/sulkan/shaders/mixin/SubmitNodeStorageMixin.java` | `value={SubmitNodeStorage.class})` | Inject:1 | sulkan$disableVanillaBlobShadows |
| top-level / `com/sulkan/shaders/mixin/VulkanDeviceShaderCompilerMixin.java` | `value={GlslCompiler.class})` | Inject:1 | sulkan$compileNative |
| top-level / `com/sulkan/shaders/pack/LegacyPackMigration.java` | `` |  | detach |
| top-level / `com/sulkan/shaders/pack/ShaderPackScanner.java` | `` |  | shaderPackDirectory, ensureShaderPackDirectory, listAvailablePacks, scan, isKnownPackId, classify, isCandidatePack, toAvailablePack, containsSupportedShaders, ScanResult, UnsupportedShaderPack, AvailableShaderPack |
| top-level / `com/sulkan/shaders/render/shadow/DirectionalShadowPipelines.java` | `` |  | ensureInitialized, close, entityDepthPipeline, entity, casterLayout |
| top-level / `com/sulkan/shaders/render/shadow/DirectionalShadowRenderer.java` | `` |  | beginLocal, get, isRenderingShadowMap, activeCascade, beginCascade, beginEntityCascade, endCascade, prepare, activeCascadeCount, cascadeLayoutVersion, cascadeMatrix, shouldUpdateCascade, shouldUpdateEntityCascade, cascadeEnd, lightDirection, cameraForward, shadowDistance, entityShadowDistance, entityCascadeEnd, target, entityTarget, activeTarget, sectionIntersectsCascade, uploadCascade, cascadeSlice, uploadShadowData, shadowDataSlice, resourcesReady, clearCascade, clearEntityCascade, ensureResources, retireTargets, retireUnused, shouldUpdateCascade, fitCascadeMatrix, buildFrustumSlice, destroyTargets, splitDistances, smoothstep, putVec4, close |
| top-level / `com/sulkan/shaders/render/shadow/DirectionalShadowSubmitFilter.java` | `` |  | order, submitShadow, submitNameTag, submitText, submitFlame, submitLeash, submitModel, submitMovingBlock, submitBlockModel, submitBreakingBlockModel, submitShapeOutline, submitItem, submitCustomGeometry, submitQuadParticleGroup, submitGizmoPrimitives, submitTextBackground, submitCrumblingOverlay, acceptsDistance |
| top-level / `com/sulkan/shaders/render/shadow/HeldLightShadowRenderer.java` | `` |  | light, active, layout, bind, render, terrainLists, close |
| top-level / `com/sulkan/shaders/render/shadow/ShadowChunkState.java` | `` |  |  |
| top-level / `com/sulkan/shaders/render/shadow/ShadowRegionState.java` | `` |  |  |
| top-level / `com/sulkan/shaders/render/shadow/ShadowService.java` | `` |  | enabled, entities, quality, distance, memoryBytes, layout, bindTerrain |
| top-level / `com/sulkan/shaders/render/shadow/SodiumShadowTerrainPasses.java` | `` |  | solid, cutout, combined, isCombined, terrainPasses, source, passesFor |
| top-level / `com/sulkan/shaders/render/shadow/SodiumShadowTerrainRenderer.java` | `` |  | preparingPasses, shadowPassIndex, renderCascade, markTerrainDirty, terrainRevision, close, planFor, renderPasses, buildRenderLists, buildRegionPlan, clearChangedPlanBatches, clearRegionBatches, clearPlanBatches, CascadePlan, matches, spatiallyMatches, iterator, hasNext, next, PlanContents, RegionPlan |
| top-level / `com/sulkan/shaders/render/shadow/SodiumTerrainShadowPipelines.java` | `` |  | caster, close, build, sodiumLayout |
| top-level / `com/sulkan/shaders/render/sky/CustomCelestials.java` | `` |  | setCelestialDirection |
| top-level / `com/sulkan/shaders/runtime/BackendStatus.java` | `` |  | vulkanActive, unavailableMessage |
| top-level / `com/sulkan/shaders/runtime/NativeShaderCompiler.java` | `` |  | compile, requiresStableGeometryInterface, compileCompute, close, code, close |
| top-level / `com/sulkan/shaders/runtime/NativeShaderPreprocessor.java` | `` |  | process, injectDefines |
| top-level / `com/sulkan/shaders/runtime/ShaderResourceIds.java` | `` |  | id, coreShader |
| top-level / `com/sulkan/shaders/runtime/ShaderRuntime.java` | `` |  | init, bootstrap, config, packs, shadersEnabled, resourceReloading, reloadPacks, applySelection, applyConfig, applyConfigInternal, close, closeReloadableResources, invalidateTerrainRenderer, normalizePackId, findPack |
| top-level / `com/sulkan/shaders/screen/NativePackSettingsScreen.java` | `` |  | init, tab, extractRenderState |
| top-level / `com/sulkan/shaders/screen/PackSettingsModel.java` | `` |  |  |
| top-level / `com/sulkan/shaders/screen/ShaderScreenBase.java` | `` |  | extractBackground, isPauseScreen, onClose, fillPanel, wrappedHeight |
| top-level / `com/sulkan/shaders/screen/ShadersScreen.java` | `` |  | init, extractRenderState, repositionElements, repositionCompact, compactStatusY, layout, refreshState, refreshPackEntries, selectPack, toggleShaders, applySelection, openShaderFolder, refreshFolder, updateInteractivity, resetStatus, toggleLabel, updateButtonLabels, packLabelText, getRowWidth, scrollBarX, entriesCanBeSelected, extractListBackground, extractListSeparators, Layout, getNarration, extractContent, mouseClicked |
| top-level / `com/sulkan/shaders/SulkanShadersClient.java` | `` |  | onInitializeClient |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
