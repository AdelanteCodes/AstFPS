# Xeno

Review status: **Evidence inventory; behavioral review pending**

Project: [Xeno](https://modrinth.com/mod/xeno)
Selected artifact version: `0.1.9`
Published implementation source: https://github.com/ExodusCoder9/Xeno
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A Performant Rendering optimization Mod for Minecraft.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `3649165b93d7eec4e6b0e2f0fedc0c06ac3949a7`
- `sha512`: `cc95cc7c80f41a7b7910bffdecbd427ff77f22ee5deb2c4cf9fc57c3bb7f7afe555ec2deb1371508c4210af10184da7aae185eb5a6d6d2da15e1630db1a438f9`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 66
Reconstructed Java files: 45

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.xeno.fabric.Xeno"
  ],
  "client": [
    "com.xeno.fabric.XenoClient"
  ],
  "modmenu": [
    "com.xeno.fabric.client.ModMenuCompat"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": "26.3.x",
  "java": ">=25"
}
```

**accessWidener**

```json
"xeno.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/xeno/client/common/memory/MemoryAccess.java` | `` |  | getAddress, packShorts, packShorts, fieldOffset, getInt, getInt, getFloat, putLong, putFloat, putInt, putShort, putByte, packFloats, packInts |
| top-level / `com/xeno/client/common/render/block/XenoFluidRenderer.java` | `` |  | isFaceOccludedByState, isFaceOccludedBySelf, shouldRenderFace, tesselate, calculateAverageHeight, getHeight, getHeight, getLightCoords, getState |
| top-level / `com/xeno/client/common/render/block/XenoLightDataCache.java` | `` |  | get, reset, getState, getLightCoords, getShadeBrightness, populate, isWithinBounds, index |
| top-level / `com/xeno/client/common/render/block/XenoModelRenderer.java` | `` |  | emit, configureTintCache, resetTintCache, emitAmbientOcclusion, emitFlat, shouldRenderFace, putQuadWithTint, getTintColor, computeTintColor |
| top-level / `com/xeno/client/common/render/block/XenoOcclusionCache.java` | `` |  | isEmpty, isFullCube, occludes |
| top-level / `com/xeno/client/common/render/block/XenoQuadLighter.java` | `` |  | resetForBlock, getLightCoords, prepareQuadAmbientOcclusion, prepareQuadFlat, isFaceCubic, getDirectionalBrightness, computeFaceLighting, getFaceTangentU, getFaceTangentV, projectU, projectV |
| top-level / `com/xeno/client/common/render/chunk/XenoChunkExecutorService.java` | `` |  | workerLoop, waitForNextJob, execute, shutdown, isShutdown, isTerminated, awaitTermination, optimalThreadCount |
| top-level / `com/xeno/client/common/render/chunk/XenoSectionCompiler.java` | `` |  | isBlockLayout |
| top-level / `com/xeno/client/common/render/chunk/XenoSectionLayerBuffer.java` | `` |  | layer, build, writeBlockQuad, unpackU, unpackV, writeQuad, writeQuad, writeVertex, addVertex |
| top-level / `com/xeno/client/common/render/chunk/XenoSectionTaskQueue.java` | `` |  | poll, size, clear, rebuild, isImportant, cameraSectionKey |
| top-level / `com/xeno/client/common/render/chunk/XenoSharedQuadIndexBuffer.java` | `` |  | ensureCapacity, fillQuadsShort, fillQuadsInt, roundUp4, hasCapacity, type |
| top-level / `com/xeno/client/common/render/chunk/XenoVertexEncoder.java` | `` |  | quantizePosition, packPositionHi, packPositionLo, packUV, packLightAndData, unpackCoord |
| top-level / `com/xeno/client/common/render/chunk/XenoVertexFormats.java` | `` |  |  |
| top-level / `com/xeno/client/common/render/entity/FastCuboidRenderer.java` | `` |  | renderCuboid |
| top-level / `com/xeno/client/common/render/entity/XenoBufferWriter.java` | `` |  |  |
| top-level / `com/xeno/client/common/render/entity/XenoCuboidData.java` | `` |  |  |
| top-level / `com/xeno/client/common/render/entity/XenoCuboidHolder.java` | `` |  |  |
| top-level / `com/xeno/client/common/render/font/XenoFontRenderer.java` | `` |  | renderGlyph, emitQuad, writeVertex |
| top-level / `com/xeno/client/common/render/XenoChunkRenderer.java` | `` |  | renderChunks, renderOit |
| top-level / `com/xeno/client/common/render/XenoRenderPipelines.java` | `` |  | getPipeline, getOitPipeline |
| top-level / `com/xeno/client/gui/widget/XenoButton.java` | `` |  | builder, builder, onPress, extractContents, updateWidgetNarration |
| top-level / `com/xeno/client/gui/widget/XenoScroller.java` | `` |  | vertical, setScrollRange, getScrollAmount, setScrollAmount, getScrollFraction, applyScrollDelta, getThumbY, getX, setX, getY, setY, extractRenderState, mouseClicked, mouseDragged, mouseReleased, getTabOrderGroup, updateNarration |
| top-level / `com/xeno/client/gui/widget/XenoSlider.java` | `` |  | builder, getDoubleValue, onPress, onClick, onDrag, onRelease, keyPressed, setValueFromMouse, setValue, handleCursor, extractContents, updateWidgetNarration |
| top-level / `com/xeno/client/gui/widget/XenoTab.java` | `` |  | builder, isSelected, onPress, extractContents, updateWidgetNarration |
| top-level / `com/xeno/client/gui/XenoVideoSettingsScreen.java` | `` |  | init, extractContents, extractContents, queryInitialResolution, getOptionValue, markOptionChanged, setGraphicsPresetToCustom, applyPresetToPending, populateOptionsForTab, getResolutionText, addResolution, extractContents, addSlider, extractContents, addDoubleSlider, extractContents, addDoubleToggle, extractContents, addToggle, extractContents, addCycle, extractContents, getOptionValueText, getSliderValueText, capitalize, applyOptions, updateScrollerRange, updateWidgetPositions, findHoveredOption, extractRenderState, renderTooltip, mouseClicked, mouseScrolled, onClose, OptionEntry, getText, getColor |
| top-level / `com/xeno/client/mixin/BufferBuilderMixin.java` | `value={BufferBuilder.class})` |  | ensureBuilding, endLastVertex, xeno$isEntityFormat, xeno$isGlyphFormat, xeno$reserveVertices |
| top-level / `com/xeno/client/mixin/ClientPackSourceMixin.java` | `value={ClientPackSource.class})` | Redirect:1 | xeno$addXenoResources |
| top-level / `com/xeno/client/mixin/CubeMixin.java` | `value={ModelPart.Cube.class})` | Inject:2 | onInit, xeno$getCuboidData, onCompile |
| top-level / `com/xeno/client/mixin/OptionsScreenMixin.java` | `value={OptionsScreen.class})` | Redirect:1 | xeno$replaceVideoSettings |
| top-level / `com/xeno/client/mixin/RenderSectionRegionAccessor.java` | `value={RenderSectionRegion.class})` | Invoker:1 |  |
| top-level / `com/xeno/client/mixin/SectionCopyAccessor.java` | `value={SectionCopy.class})` | Accessor:1 |  |
| top-level / `com/xeno/client/mixin/XenoBakedGlyphMixin.java` | `value={BakedSheetGlyph.class})` | Inject:1 | onRender |
| top-level / `com/xeno/client/mixin/XenoBufferBuilderMixin.java` | `value={BufferBuilder.class})` | Inject:1, Overwrite:1 | beginVertex, onInit, addVertex, xeno$putPackedUv, xeno$putNormals, xeno$normalIntValue |
| top-level / `com/xeno/client/mixin/XenoChunkExecutorMixin.java` | `value={LevelRenderer.class})` | Redirect:2 | xeno$useXenoChunkExecutor, xeno$compileSectionAsync |
| top-level / `com/xeno/client/mixin/XenoChunkSectionLayerMixin.java` | `value={ChunkSectionLayer.class})` | Inject:2 | xeno$overridePipeline, xeno$overrideVertexFormat |
| top-level / `com/xeno/client/mixin/XenoChunkSectionsToRenderMixin.java` | `value={ChunkSectionsToRender.class})` | Overwrite:2 | renderGroup, renderOit |
| top-level / `com/xeno/client/mixin/XenoCloudRendererMixin.java` | `value={CloudRenderer.class})` | Overwrite:1 | isNorthEmpty, isEastEmpty, isSouthEmpty, isWestEmpty, buildMesh, xeno$tryBuildCellFast, xeno$encodeFaceFast |
| top-level / `com/xeno/client/mixin/XenoDebugEntrySimplePerformanceImpactorsMixin.java` | `value={DebugEntrySimplePerformanceImpactors.class})` | Inject:1 | xeno$overrideTerrainRenderingLine |
| top-level / `com/xeno/client/mixin/XenoLevelRendererMixin.java` | `value={LevelRenderer.class})` | Redirect:2 | xeno$ignoreKnownIssues, xeno$useXenoCompiler |
| top-level / `com/xeno/client/mixin/XenoMeshDataMixin.java` | `value={MeshData.class})` | Overwrite:1 | decodeQuadCentroids |
| top-level / `com/xeno/client/mixin/XenoSectionRenderDispatcherMixin.java` | `value={SectionRenderDispatcher.class})` | Redirect:1 | xeno$useXenoTaskQueue |
| top-level / `com/xeno/client/mixin/XenoShaderManagerMixin.java` | `value={ShaderManager.class})` | Redirect:1 | xeno$injectXenoShaders |
| top-level / `com/xeno/fabric/client/ModMenuCompat.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/xeno/fabric/Xeno.java` | `` |  | onInitialize |
| top-level / `com/xeno/fabric/XenoClient.java` | `` |  | onInitializeClient |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
