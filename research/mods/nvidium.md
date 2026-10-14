# Nvidium

Review status: **Evidence inventory; behavioral review pending**

Project: [Nvidium](https://modrinth.com/mod/nvidium)
Selected artifact version: `0.4.4-beta7-26.3`
Published implementation source: https://github.com/MCRcortex/nvidium
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Fast nvidia only rendering engine for sodium

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `36cfe2f0efdbcbf44e7a5367441eb0655257561f929434b1aa821ba0442fa845232cae7320e7dadd26f2962150b8a42c16e4fd1dd3d94d6a4bd0bfb46fdff6d1`
- `sha1`: `6741b037b97a2a0b50231b52780feb893b3d51fc`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 81
Reconstructed Java files: 69

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "sodium:config_api_user": [
    "me.cortex.nvidium.config.ConfigGuiBuilder"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "minecraft": [
    "26.3"
  ],
  "sodium": [
    "0.9.2"
  ]
}
```

**accessWidener**

```json
"nvidium.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/cortex/nvidium/api0/NvidiumAPI.java` | `` |  | hideSection, showSection, setRegionTransformId, setTransformation, setOrigin |
| top-level / `me/cortex/nvidium/config/ConfigGuiBuilder.java` | `` |  | registerConfigLate |
| top-level / `me/cortex/nvidium/config/NvidiumConfig.java` | `` |  | loadOrCreate, save, getConfigPath |
| top-level / `me/cortex/nvidium/config/NvidiumConfigStore.java` | `` |  | getData, save |
| top-level / `me/cortex/nvidium/config/StatisticsLoggingLevel.java` | `` |  |  |
| top-level / `me/cortex/nvidium/config/TranslucencySortingLevel.java` | `` |  |  |
| top-level / `me/cortex/nvidium/gl/buffers/Buffer.java` | `` |  |  |
| top-level / `me/cortex/nvidium/gl/buffers/DeviceOnlyMappedBuffer.java` | `` |  | delete, getDeviceAddress, free, getSize |
| top-level / `me/cortex/nvidium/gl/buffers/IClientMappedBuffer.java` | `` |  |  |
| top-level / `me/cortex/nvidium/gl/buffers/IDeviceMappedBuffer.java` | `` |  |  |
| top-level / `me/cortex/nvidium/gl/buffers/PersistentClientMappedBuffer.java` | `` |  | clientAddress, delete, free, getSize |
| top-level / `me/cortex/nvidium/gl/buffers/PersistentSparseAddressableBuffer.java` | `` |  | alignUp, doCommit, allocatePages, deallocatePages, getPagesCommitted, ensureAllocated, deallocate, getDeviceAddress, delete, free, getSize |
| top-level / `me/cortex/nvidium/gl/GlFence.java` | `` |  | signaled, free |
| top-level / `me/cortex/nvidium/gl/GlObject.java` | `` |  | getId |
| top-level / `me/cortex/nvidium/gl/images/DepthOnlyFrameBuffer.java` | `` |  | getDepthBuffer, bind, delete |
| top-level / `me/cortex/nvidium/gl/IResource.java` | `` |  |  |
| top-level / `me/cortex/nvidium/gl/RenderDevice.java` | `` |  | createClientMappedBuffer, flush, barrier, copyBuffer, createSparseBuffer, createDeviceOnlyMappedBuffer |
| top-level / `me/cortex/nvidium/gl/shader/IShaderProcessor.java` | `` |  |  |
| top-level / `me/cortex/nvidium/gl/shader/Shader.java` | `` |  | make, make, bind, delete, free, addSource, compile, printProgramLinkLog, verifyProgramLinked, createShader |
| top-level / `me/cortex/nvidium/gl/shader/ShaderType.java` | `` |  |  |
| top-level / `me/cortex/nvidium/gl/TrackedObject.java` | `` |  | free0, assertNotFreed, isFreed, register, Ref |
| top-level / `me/cortex/nvidium/managers/RegionManager.java` | `` |  | delete, commitChanges, setRegionMetadata, getSectionRefId, setSectionData, removeSection, allocateSection, markDirty, regionCount, maxRegions, maxRegionIndex, regionExists, isRegionVisible, distance, withinSquare, isRegionInACameraAxis, getRegionBufferAddress, getSectionBufferAddress, regionIdToKey, setRegionTransformId, destroy, delete, verifyIntegrity |
| top-level / `me/cortex/nvidium/managers/RegionVisibilityTracker.java` | `` |  | computeVisibility, delete, resetRegion, findMostLikelyLeastSeenRegion |
| top-level / `me/cortex/nvidium/managers/SectionManager.java` | `` |  | uploadIndexBuffer, uploadChunkSort, uploadChunkBuildResult, setHideBit, deleteSection, deleteSection, destroy, commitChanges, getRegionManager, removeRegionById |
| top-level / `me/cortex/nvidium/mixin/minecraft/FrontendCommandEncoderAccessor.java` | `value={FrontendCommandEncoder.class})` | Accessor:1 |  |
| top-level / `me/cortex/nvidium/mixin/minecraft/FrontendRenderPassAccessor.java` | `value={FrontendRenderPass.class})` | Accessor:1 |  |
| top-level / `me/cortex/nvidium/mixin/minecraft/GlCommandEncoderAccessor.java` | `value={GlCommandEncoder.class})` | Accessor:1 |  |
| top-level / `me/cortex/nvidium/mixin/minecraft/MixinCamera.java` | `value={Camera.class})` | ModifyExpressionValue:1 | nvidium$modifyDepthFar |
| top-level / `me/cortex/nvidium/mixin/minecraft/MixinFogRenderer.java` | `value={FogRenderer.class})` | ModifyVariable:1, ModifyArg:1 | modifyFogRD, clampSkyEnd |
| top-level / `me/cortex/nvidium/mixin/minecraft/MixinGlDevice.java` | `value={GlDevice.class})` | Inject:1 | init |
| top-level / `me/cortex/nvidium/mixin/minecraft/TextureAtlasAccessor.java` | `value={TextureAtlas.class})` | Invoker:2 |  |
| top-level / `me/cortex/nvidium/mixin/sodium/MixinChunkBuilderMeshingTask.java` | `value={ChunkBuilderMeshingTask.class}, remap=false)` | Inject:2 | captureVertexFormat, repackageResults |
| top-level / `me/cortex/nvidium/mixin/sodium/MixinChunkBuildOutput.java` | `value={ChunkBuildOutput.class}, remap=false)` | Inject:1 | getOutput, set, cleanup |
| top-level / `me/cortex/nvidium/mixin/sodium/MixinChunkJobQueue.java` | `targets={"net.caffeinemc.mods.sodium.client.render.chunk.compile.executor.ChunkJobQueue"}, remap=false)` | Redirect:1 | returnAlot |
| top-level / `me/cortex/nvidium/mixin/sodium/MixinOptionFlag.java` | `value={OptionFlag.class}, remap=false)` | Invoker:1 | optionFlagCreator |
| top-level / `me/cortex/nvidium/mixin/sodium/MixinRenderRegionManager.java` | `value={RenderRegionManager.class}, remap=false)` | Inject:1 | redirectUpload, setWorldRenderer |
| top-level / `me/cortex/nvidium/mixin/sodium/MixinRenderSection.java` | `value={RenderSection.class}, remap=false)` |  | isSubmittedRebuild, isSubmittedRebuild, isSeen, isSeen |
| top-level / `me/cortex/nvidium/mixin/sodium/MixinRenderSectionManager.java` | `value={RenderSectionManager.class}, remap=false, priority=1500)` | Inject:3, ModifyArg:1, Redirect:1 | updateNvidiumIsEnabled, init, modifyVertexType, destroy, deleteSection, redirectDebug, getRenderer |
| top-level / `me/cortex/nvidium/mixin/sodium/MixinSodiumWorldRenderer.java` | `value={SodiumWorldRenderer.class}, remap=false)` | Inject:2 | getRenderer, trackViewport, renderLayer |
| top-level / `me/cortex/nvidium/mixin/sodium/ViewportAccessor.java` | `value={Viewport.class})` | Accessor:2 |  |
| top-level / `me/cortex/nvidium/Nvidium.java` | `` |  | checkSystemIsCapable |
| top-level / `me/cortex/nvidium/NvidiumWorldRenderer.java` | `` |  | enqueueRegionSort, delete, reloadShaders, renderFrame, renderTranslucent, deleteSection, uploadBuildResult, addDebugInfo, update_allowed_memory, getSectionManager, setTransformation, setOrigin, getMaxGeometryMemory |
| top-level / `me/cortex/nvidium/renderers/CmdBufferBuilder.java` | `` |  | dispatch, delete |
| top-level / `me/cortex/nvidium/renderers/Phase.java` | `` |  | delete, getTiming |
| top-level / `me/cortex/nvidium/renderers/PrimaryTerrainRasterizer.java` | `` |  | setTexture, raster, delete |
| top-level / `me/cortex/nvidium/renderers/RegionRasterizer.java` | `` |  | raster, delete |
| top-level / `me/cortex/nvidium/renderers/SectionRasterizer.java` | `` |  | raster, delete |
| top-level / `me/cortex/nvidium/renderers/SortRegionSectionPhase.java` | `` |  | dispatch, delete |
| top-level / `me/cortex/nvidium/renderers/TemporalTerrainRasterizer.java` | `` |  | setTexture, raster, delete |
| top-level / `me/cortex/nvidium/renderers/TranslucentTerrainRasterizer.java` | `` |  | setTexture, linkRenderpearlSampler, raster, delete |
| top-level / `me/cortex/nvidium/RenderPipeline.java` | `` |  | setTransformation, setOrigin, renderFrame, removeRegion, removeARegion, renderTranslucent, delete, addDebugInfo, reloadShaders |
| top-level / `me/cortex/nvidium/sodiumCompat/INvidiumWorldRendererGetter.java` | `` |  |  |
| top-level / `me/cortex/nvidium/sodiumCompat/INvidiumWorldRendererSetter.java` | `` |  |  |
| top-level / `me/cortex/nvidium/sodiumCompat/IRenderSectionExtension.java` | `` |  |  |
| top-level / `me/cortex/nvidium/sodiumCompat/IRepackagedResult.java` | `` |  |  |
| top-level / `me/cortex/nvidium/sodiumCompat/IrisCheck.java` | `` |  | checkIrisShaders, checkIrisShouldDisable |
| top-level / `me/cortex/nvidium/sodiumCompat/NvidiumCompactChunkVertex.java` | `` |  | getVertexFormat, getEncoder, compactLight, encodePosition, encodeDrawParameters, encodeColor, encodeTexture |
| top-level / `me/cortex/nvidium/sodiumCompat/NvidiumOptionFlags.java` | `` |  |  |
| top-level / `me/cortex/nvidium/sodiumCompat/RepackagedSectionOutput.java` | `` |  | RepackagedSectionOutput, delete |
| top-level / `me/cortex/nvidium/sodiumCompat/ShaderLoader.java` | `` |  | parse, parse |
| top-level / `me/cortex/nvidium/sodiumCompat/SodiumResultCompatibility.java` | `` |  | repackage, copyQuad, computeRanges, copyRange, packageSectionGeometry, decodePosition, scalePos, updateSectionBounds, updateSectionBounds |
| top-level / `me/cortex/nvidium/util/BufferArena.java` | `` |  | allocQuads, free, upload, delete, getAllocatedMB, getUsedMB, getMemoryUsed, getFragmentation, canReuse |
| top-level / `me/cortex/nvidium/util/DownloadTaskStream.java` | `` |  | download, delete, Download |
| top-level / `me/cortex/nvidium/util/GlslPreprocessor.java` | `` |  | process, processImports, injectDefines, resolve |
| top-level / `me/cortex/nvidium/util/GPUTiming.java` | `` |  | marker, addSample, getAverageMs, tick, free, capture, download, tick, getQuery, free, InflightRequest, callbackIfReady |
| top-level / `me/cortex/nvidium/util/IdProvider.java` | `` |  | provide, release, maxIndex |
| top-level / `me/cortex/nvidium/util/SegmentedManager.java` | `` |  | getSize, alloc, free, expand, getSize, main, setLimit |
| top-level / `me/cortex/nvidium/util/TickableManager.java` | `` |  | register, register, remove, remove, TickAll |
| top-level / `me/cortex/nvidium/util/UploadingBufferStream.java` | `` |  | upload, commit, tick, delete, UploadData, UploadFrame |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
