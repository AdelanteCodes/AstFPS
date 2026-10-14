# Afterburner: Optimized

Review status: **Evidence inventory; behavioral review pending**

Project: [Afterburner: Optimized](https://modrinth.com/mod/afterburner-optimized)
Selected artifact version: `0.1.26`
Published implementation source: https://github.com/HamdanProfessional/afterburner-optimized
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Extreme optimizations to minecraft that includes faster chunk rendering, faster server tick time, collision optimizations and more

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `c60b992415e83035cb744a02b505389adc97eef1`
- `sha512`: `1b4eafa4e3cddd17635e5a55da23ccec9c503ed229b6611699fc4a448e9a67293826ac7c82600e479fd1d5c2511ad6dc1efb6b48f97a050100c4250f28041cc5`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 225
Reconstructed Java files: 189

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.afterburner.Afterburner"
  ],
  "client": [
    "com.afterburner.client.AfterburnerClient"
  ],
  "sodium:config_api_user": [
    "com.afterburner.client.gui.SodiumSettingsPage"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

**accessWidener**

```json
"afterburner.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/afterburner/Afterburner.java` | `` |  | onInitialize, id |
| top-level / `com/afterburner/AfterburnerMixinPlugin.java` | `` |  | shouldApplyMixin, onLoad, getRefMapperConfig, acceptTargets, getMixins, preApply, postApply |
| top-level / `com/afterburner/ai/AiCheck.java` | `` |  | result, summary |
| top-level / `com/afterburner/ai/BlockSearch.java` | `` |  | computeValue, plain, mightFind |
| top-level / `com/afterburner/ai/PoiColumns.java` | `` |  |  |
| top-level / `com/afterburner/ai/PoiSquare.java` | `` |  | tryAdvance, nextSection, nextColumn |
| top-level / `com/afterburner/chunk/ChunkLocks.java` | `` |  | takeReady, canStart, claim, finish, run |
| top-level / `com/afterburner/chunk/ParallelWorldgen.java` | `` |  | apply, locks |
| top-level / `com/afterburner/client/Addons.java` | `` |  | shaderPackActive, farTerrainChunks, addSettings |
| top-level / `com/afterburner/client/AfterburnerAddon.java` | `` |  |  |
| top-level / `com/afterburner/client/AfterburnerClient.java` | `` |  | onInitializeClient |
| top-level / `com/afterburner/client/gui/SettingsScreen.java` | `` |  | addTitle, addOptions, screen, header, add, add, fpsTargetSlider, addRow, addFooter, changed, allOn, refresh, removed, locked, atStart, restartNeeded, tooltip |
| top-level / `com/afterburner/client/gui/SodiumSettingsPage.java` | `` |  | registerConfigLate |
| top-level / `com/afterburner/client/memory/ChunkBufferSizes.java` | `` |  | heapSize |
| top-level / `com/afterburner/client/memory/MemoryTrim.java` | `` |  | init, onFrame, trim |
| top-level / `com/afterburner/client/mixin/CompiledSectionMeshMixin.java` | `value={CompiledSectionMesh.class})` | Inject:1 | afterburner$sortFaces |
| top-level / `com/afterburner/client/mixin/DrawPrepMixin.java` | `value={LevelRenderer.class})` | WrapOperation:1 | afterburner$skipEmptyLayers |
| top-level / `com/afterburner/client/mixin/LevelRendererMixin.java` | `value={LevelRenderer.class})` | WrapOperation:1 | afterburner$drawVisibleFaces |
| top-level / `com/afterburner/client/mixin/memory/HeapAccessor.java` | `value={TlsfAllocator.Heap.class})` | Accessor:1 |  |
| top-level / `com/afterburner/client/mixin/memory/UberGpuBufferMixin.java` | `value={UberGpuBuffer.class})` | WrapOperation:1 | afterburner$heap |
| top-level / `com/afterburner/client/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | afterburner$onFrame |
| top-level / `com/afterburner/client/mixin/MultiDrawMixin.java` | `value={LevelRenderer.class})` | WrapOperation:1 | afterburner$allowIntelMultiDraw |
| top-level / `com/afterburner/client/mixin/perf/FpsTargetCloudsMixin.java` | `value={Options.class})` | ModifyReturnValue:1 | afterburner$clouds |
| top-level / `com/afterburner/client/mixin/perf/FpsTargetExtractMixin.java` | `value={LevelExtractor.class})` | ModifyExpressionValue:1, Inject:1, ModifyReturnValue:1 | afterburner$drawDistanceChanged, afterburner$drawDistance, afterburner$entityDrawDistance |
| top-level / `com/afterburner/client/mixin/perf/FpsTargetFogMixin.java` | `value={GameRenderer.class})` | ModifyArg:1 | afterburner$fogDistance |
| top-level / `com/afterburner/client/mixin/perf/FpsTargetFrameMixin.java` | `value={Minecraft.class})` | Inject:1, WrapOperation:2 | afterburner$targetFrame, afterburner$targetLimiter, afterburner$targetPresent |
| top-level / `com/afterburner/client/mixin/render/AnimatedAtlasMixin.java` | `value={TextureAtlas.class})` | WrapOperation:1, Inject:1 | afterburner$track, afterburner$findAnimated |
| top-level / `com/afterburner/client/mixin/render/AnimatedMeshMixin.java` | `value={CompiledSectionMesh.class})` | Inject:1 | afterburner$takeAnimated, afterburner$setAnimated |
| top-level / `com/afterburner/client/mixin/render/AnimatedResultsMixin.java` | `value={SectionCompiler.Results.class})` |  | afterburner$setAnimated |
| top-level / `com/afterburner/client/mixin/render/AnimatedScanMixin.java` | `value={SectionCompiler.class})` | Inject:1 | afterburner$findAnimated |
| top-level / `com/afterburner/client/mixin/render/AnimatedSpriteMixin.java` | `value={SpriteContents.class})` |  | afterburner$seenAt, afterburner$see, afterburner$listed, afterburner$list |
| top-level / `com/afterburner/client/mixin/render/AnimationSkipMixin.java` | `value={SpriteContents.AnimationState.class})` | Inject:2 | afterburner$track, afterburner$skipUnseen, afterburner$skip |
| top-level / `com/afterburner/client/mixin/render/AnimationTickMixin.java` | `value={TextureManager.class})` | Inject:1 | afterburner$markVisible |
| top-level / `com/afterburner/client/mixin/render/BiomeBlendMixin.java` | `value={ClientLevel.class})` | WrapOperation:1 | afterburner$rememberedBiome |
| top-level / `com/afterburner/client/mixin/render/BiomeMemoCompileMixin.java` | `value={SectionCompiler.class})` | WrapMethod:1 | afterburner$rememberBiomes |
| top-level / `com/afterburner/client/mixin/render/BlockEntityCullingMixin.java` | `value={BlockEntityRenderDispatcher.class})` | WrapOperation:1 | afterburner$occluded |
| top-level / `com/afterburner/client/mixin/render/BlockEntityOcclusionMixin.java` | `value={BlockEntity.class})` |  | afterburner$hiddenAt, afterburner$movedSq, afterburner$setHiddenAt |
| top-level / `com/afterburner/client/mixin/render/BlockEntityScanMixin.java` | `value={LevelExtractor.class})` | WrapOperation:1 | afterburner$withBlockEntities |
| top-level / `com/afterburner/client/mixin/render/BlockModelLighterAccessor.java` | `value={BlockModelLighter.class})` | Accessor:1 | afterburner$cache |
| top-level / `com/afterburner/client/mixin/render/BufferBuilderAccessor.java` | `value={BufferBuilder.class})` | Accessor:1 |  |
| top-level / `com/afterburner/client/mixin/render/BuildCopyMixin.java` | `targets={"net.minecraft.client.renderer.chunk.SectionRenderDispatcher$RenderSection$CompileTask"})` | WrapOperation:1 | afterburner$letGo |
| top-level / `com/afterburner/client/mixin/render/ChunkBatchingMixin.java` | `value={LevelRenderer.class})` | Inject:2, WrapOperation:1 | afterburner$batch, afterburner$batchIndirect, afterburner$regionCorner |
| top-level / `com/afterburner/client/mixin/render/CompactUploadMixin.java` | `targets={"net.minecraft.client.renderer.chunk.SectionRenderDispatcher$RenderSection$CompileTask"})` | WrapOperation:1 | afterburner$compact |
| top-level / `com/afterburner/client/mixin/render/CullingExtractMixin.java` | `value={LevelExtractor.class})` | Inject:4 | afterburner$startFrame, afterburner$entities, afterburner$blockEntities, afterburner$done |
| top-level / `com/afterburner/client/mixin/render/DrawSeparateMixin.java` | `value={ChunkSectionsToRender.DrawSeparate.class})` | Inject:1 | afterburner$setFrame, afterburner$drawBatches |
| top-level / `com/afterburner/client/mixin/render/EntityCullingMixin.java` | `value={EntityRenderer.class})` | WrapOperation:1 | afterburner$occluded |
| top-level / `com/afterburner/client/mixin/render/EntityOcclusionMixin.java` | `value={Entity.class})` |  | afterburner$hiddenAt, afterburner$movedSq, afterburner$setHiddenAt |
| top-level / `com/afterburner/client/mixin/render/FilteringShortcutMixin.java` | `value={ShaderSource.CachedIncludeSource.class})` | ModifyVariable:1 | afterburner$fewerReads |
| top-level / `com/afterburner/client/mixin/render/HeapAffinityMixin.java` | `value={UberGpuBuffer.class})` | WrapOperation:3 | afterburner$placing, afterburner$freed, afterburner$placed, afterburner$inUse |
| top-level / `com/afterburner/client/mixin/render/LeafCullingIndigoMixin.java` | `targets={"net.fabricmc.fabric.impl.client.indigo.renderer.render.AltModelBlockRendererImpl"})` | WrapOperation:1 | afterburner$cullLeaves |
| top-level / `com/afterburner/client/mixin/render/LeafCullingMixin.java` | `value={ModelBlockRenderer.class})` | ModifyReturnValue:1 | afterburner$cullLeaves |
| top-level / `com/afterburner/client/mixin/render/LightMemoCompileMixin.java` | `value={SectionCompiler.class})` | Inject:1 | afterburner$anchorLight |
| top-level / `com/afterburner/client/mixin/render/LightMemoMixin.java` | `value={BlockModelLighter.Cache.class})` | Inject:2, ModifyArg:1, Redirect:2 | afterburner$register, afterburner$anchor, afterburner$unanchor, afterburner$index, afterburner$rememberedLight, afterburner$packedBrightness, afterburner$rememberedShade, afterburner$shade, afterburner$stats, afterburner$resetStats |
| top-level / `com/afterburner/client/mixin/render/OcclusionProjectionMixin.java` | `value={GameRenderer.class})` | ModifyArg:1 | afterburner$levelProjection |
| top-level / `com/afterburner/client/mixin/render/OcclusionRayMixin.java` | `value={SectionOcclusionGraph.class})` | Inject:2, WrapOperation:1 | afterburner$beginLines, afterburner$endLines, afterburner$rememberedLine, afterburner$walk |
| top-level / `com/afterburner/client/mixin/render/OcclusionSectionMixin.java` | `value={SectionRenderDispatcher.RenderSection.class})` |  | afterburner$hiddenAt, afterburner$setHiddenAt |
| top-level / `com/afterburner/client/mixin/render/OffscreenBuildMixin.java` | `value={LevelExtractor.class})` | Inject:2 | afterburner$chunkOrLight, afterburner$buildOffscreen |
| top-level / `com/afterburner/client/mixin/render/OffscreenSectionMixin.java` | `value={SectionRenderDispatcher.RenderSection.class})` | Inject:1 | afterburner$firstBuild |
| top-level / `com/afterburner/client/mixin/render/PassDescriptorMixin.java` | `value={FrontendCommandEncoder.class})` | Inject:1 | afterburner$remember |
| top-level / `com/afterburner/client/mixin/render/PassRestartMixin.java` | `value={FrontendRenderPass.class})` |  | afterburner$setDescriptor, afterburner$restart, afterburner$restart |
| top-level / `com/afterburner/client/mixin/render/RegionMeshMixin.java` | `value={CompiledSectionMesh.class})` | Inject:1 | afterburner$takeRegion, afterburner$inRegion, afterburner$regionSlot, afterburner$regionKey, afterburner$format, afterburner$setFormat, afterburner$setBlockRuns, afterburner$forgetSlices, afterburner$setOwner |
| top-level / `com/afterburner/client/mixin/render/SectionChangeMixin.java` | `value={SectionRenderDispatcher.RenderSection.class})` | Inject:3 | afterburner$newMesh, afterburner$meshSet, afterburner$reset, afterburner$meshVersion, afterburner$meshChanged, afterburner$builtAt, afterburner$builtIndex, afterburner$builtVersion, afterburner$built, afterburner$frameAt, afterburner$frameIndex, afterburner$inFrame, afterburner$listedAt, afterburner$listed, afterburner$hasBlockEntities |
| top-level / `com/afterburner/client/mixin/render/SectionCompilerMixin.java` | `value={SectionCompiler.class})` | Inject:1 | afterburner$moveToRegion |
| top-level / `com/afterburner/client/mixin/render/SectionResultsMixin.java` | `value={SectionCompiler.Results.class})` |  | afterburner$setBlockRuns, afterburner$regionSlot, afterburner$setRegionSlot, afterburner$regionKey, afterburner$setRegionKey |
| top-level / `com/afterburner/client/mixin/render/SectionToNodeMapAccessor.java` | `value={SectionOcclusionGraph.SectionToNodeMap.class})` | Accessor:1 |  |
| top-level / `com/afterburner/client/mixin/render/SeenBlockModelMixin.java` | `value={BlockModelFeatureRenderer.class})` | Inject:1 | afterburner$seen |
| top-level / `com/afterburner/client/mixin/render/SeenFlameMixin.java` | `value={FlameFeatureRenderer.class})` | ModifyExpressionValue:1 | afterburner$seen |
| top-level / `com/afterburner/client/mixin/render/SeenGuiSpriteMixin.java` | `value={GuiGraphicsExtractor.class})` | Inject:1 | afterburner$seen |
| top-level / `com/afterburner/client/mixin/render/SeenItemMixin.java` | `value={ItemFeatureRenderer.class})` | ModifyExpressionValue:1 | afterburner$seen |
| top-level / `com/afterburner/client/mixin/render/SeenMovingBlockMixin.java` | `value={MovingBlockFeatureRenderer.class})` | Inject:1 | afterburner$seen |
| top-level / `com/afterburner/client/mixin/render/SeenOverlayMixin.java` | `value={LevelExtractor.class})` | ModifyExpressionValue:1 | afterburner$seen |
| top-level / `com/afterburner/client/mixin/render/SeenScreenEffectMixin.java` | `value={ScreenEffectRenderer.class})` | ModifyExpressionValue:1 | afterburner$seen |
| top-level / `com/afterburner/client/mixin/render/SliceCacheMixin.java` | `value={UberGpuBuffer.class})` | WrapOperation:1, Inject:1 | afterburner$forgetOnUpload, afterburner$forgetOnFree, moved |
| top-level / `com/afterburner/client/mixin/render/TerrainAtlasMixin.java` | `value={TextureAtlas.class})` | Inject:1 | afterburner$findSprites |
| top-level / `com/afterburner/client/mixin/render/TerrainBlocksMixin.java` | `value={SectionCompiler.class})` | ModifyExpressionValue:1, WrapOperation:1, Inject:1 | afterburner$noteBlock, afterburner$noteFluid, afterburner$keepRuns |
| top-level / `com/afterburner/client/mixin/render/TranslucentCentersMixin.java` | `value={CompactVectorArray.class})` |  | afterburner$setFacings |
| top-level / `com/afterburner/client/mixin/render/TranslucentFacingsMixin.java` | `value={MeshData.class})` | WrapOperation:1 | afterburner$facings |
| top-level / `com/afterburner/client/mixin/render/TranslucentMeshMixin.java` | `value={CompiledSectionMesh.class})` |  | afterburner$frontIndices, afterburner$pointOfView, afterburner$setPartition |
| top-level / `com/afterburner/client/mixin/render/TranslucentSortMixin.java` | `value={MeshData.SortState.class})` | Inject:1 | afterburner$split |
| top-level / `com/afterburner/client/mixin/render/TranslucentUploadMixin.java` | `value={SectionRenderDispatcher.RenderSection.class})` | ModifyReturnValue:1, WrapOperation:1 | afterburner$relative, afterburner$keepSplit |
| top-level / `com/afterburner/client/mixin/render/VertexAlignMixin.java` | `value={UberGpuBuffer.class})` | Inject:1 | afterburner$alignForBoth, gcd |
| top-level / `com/afterburner/client/mixin/render/ViewAreaAccessor.java` | `value={ViewArea.class})` | Accessor:1 |  |
| top-level / `com/afterburner/client/mixin/render/WideSectionsMixin.java` | `value={SectionOcclusionGraph.class})` | ModifyReturnValue:1 | afterburner$graphChanged |
| top-level / `com/afterburner/client/mixin/TranslucencyPointOfViewAccessor.java` | `value={TranslucencyPointOfView.class})` | Accessor:3 |  |
| top-level / `com/afterburner/client/mixin/VideoSettingsMixin.java` | `value={VideoSettingsScreen.class})` | Inject:1 | afterburner$addSettingsButton |
| top-level / `com/afterburner/client/mixin/WorkerPriorityMixin.java` | `targets={"net.minecraft.util.Util$2"})` | Inject:1 | afterburner$lowerPriority |
| top-level / `com/afterburner/client/perf/FpsTarget.java` | `` |  | target, set, farCap, cloudsOff, drawCap, consumeDrawChange, fogDistance, drawn, filter, idle, timing, frame, judge, goal, settings, plan, apply, log, describe, read, save |
| top-level / `com/afterburner/client/render/AnimatedMesh.java` | `` |  |  |
| top-level / `com/afterburner/client/render/AnimatedSprites.java` | `` |  | beginTick, skips, seen, seen, setVisible, collect, atlasUploaded, inside, Bits, equals, hashCode |
| top-level / `com/afterburner/client/render/BatchedSections.java` | `` |  |  |
| top-level / `com/afterburner/client/render/BiomeMemo.java` | `` |  | begin, end, biome, check, reset, summary |
| top-level / `com/afterburner/client/render/BlockEntitySections.java` | `` |  | of, check |
| top-level / `com/afterburner/client/render/BuiltSection.java` | `` |  |  |
| top-level / `com/afterburner/client/render/ChunkBatcher.java` | `` |  | changed, changed, takeChanged, generation, moved, prepare, frameFor, check, vertexSizes, elements, sameSections, rememberSections, sameVisible, rememberVisible, shadowFrame, readLocked, lookUp, copy, partition, patch, record, patchOrRetake, retake, adding, lookUpAdded, leaveOut, reorder, addFading, addSection, fillOnce, holds, refill, fillOne, uncount, checkFill, fillContents, mix, fillDraw, sides, sortOut, writeOcclusion, regionSlot, add, ordered, newBatch, draw, drawBatches, prepare, contents, upload, draw, hasTranslucent, clear, same, remember, add, addLate, multiDraw, multiDrawInterleaved |
| top-level / `com/afterburner/client/render/ChunkRegions.java` | `` |  | originX, originY, originZ, slot, key, key, moveToRegion |
| top-level / `com/afterburner/client/render/CompactVertices.java` | `` |  | vertexSize, build, appliesTo, extendedAppliesTo, stored, convert, fits, convertExtended, octahedral |
| top-level / `com/afterburner/client/render/EntityCulling.java` | `` |  | startFrame, phase, hide, cullable, hide, reach, near, add, resetStats, computeValue |
| top-level / `com/afterburner/client/render/FaceSortedMesh.java` | `` |  |  |
| top-level / `com/afterburner/client/render/LeafCulling.java` | `` |  | render, reset, summary |
| top-level / `com/afterburner/client/render/LightMemo.java` | `` |  | reset, summary |
| top-level / `com/afterburner/client/render/OccludedObject.java` | `` |  |  |
| top-level / `com/afterburner/client/render/OccludedSection.java` | `` |  |  |
| top-level / `com/afterburner/client/render/OcclusionCulling.java` | `` |  | recent, resetStats, init, initCompute, sampler, program, room, flat, handle, uniforms, uploadBoxes, buildPyramid, readBack, collect, apply |
| top-level / `com/afterburner/client/render/OcclusionPortable.java` | `` |  | prepare, room |
| top-level / `com/afterburner/client/render/OcclusionRays.java` | `` |  | begin, start, end, index, inView, known, remember, reset, summary |
| top-level / `com/afterburner/client/render/OffscreenBuilds.java` | `` |  | cubeInFrustum, isVisible, changed, schedule, pick |
| top-level / `com/afterburner/client/render/Probe.java` | `` |  | get, set |
| top-level / `com/afterburner/client/render/RegionMesh.java` | `` |  |  |
| top-level / `com/afterburner/client/render/RegionResults.java` | `` |  |  |
| top-level / `com/afterburner/client/render/RestartablePass.java` | `` |  |  |
| top-level / `com/afterburner/client/render/SectionFaces.java` | `` |  | order, classify, diagonal, same, isPositive, visible, matches, copyTo, addVisible, addVisible, holds, add |
| top-level / `com/afterburner/client/render/SeenSprite.java` | `` |  |  |
| top-level / `com/afterburner/client/render/TerrainExtras.java` | `` |  | active, used, use, moveRuns, atlasUploaded, spriteCenter, block, fluid, change, add |
| top-level / `com/afterburner/client/render/TrackedAnimation.java` | `` |  |  |
| top-level / `com/afterburner/client/render/TranslucentCulling.java` | `` |  | forget, take, side, pointOfView, pointOfView, holds, sort |
| top-level / `com/afterburner/client/render/WideSections.java` | `` |  | graphChanged |
| top-level / `com/afterburner/collision/BoxShape.java` | `` |  |  |
| top-level / `com/afterburner/collision/CollisionCheck.java` | `` |  | result, summary |
| top-level / `com/afterburner/collision/EntityBumps.java` | `` |  | collisions, vanilla, fast, bumps, shapes |
| top-level / `com/afterburner/collision/HardEntities.java` | `` |  | computeValue, computeValue, isHard, bumpsOnlyIntoHard, declaredIn |
| top-level / `com/afterburner/collision/HardEntityCount.java` | `` |  |  |
| top-level / `com/afterburner/entity/HopperSearch.java` | `` |  | check, holdsItems, summary |
| top-level / `com/afterburner/entity/SectionSearch.java` | `` |  | forEach, add, look, lookColumn, walk, summary |
| top-level / `com/afterburner/Features.java` | `` |  | needs, forced, enabled, active, live, setActive, key, label, group, replacedBy, summary |
| top-level / `com/afterburner/light/LightStorageAccess.java` | `` |  |  |
| top-level / `com/afterburner/memory/SectionLocks.java` | `` |  | acquire, release, acquireSlow, releaseSlow |
| top-level / `com/afterburner/mixin/ai/BrainMixin.java` | `value={Brain.class})` | Inject:1, Overwrite:2 | afterburner$onBehaviorsChanged, afterburner$entries, startEachNonRunningBehavior, getRunningBehaviors, afterburner$check |
| top-level / `com/afterburner/mixin/ai/GateBehaviorMixin.java` | `value={GateBehavior.class})` | Overwrite:2 | tryStart, tickOrStop |
| top-level / `com/afterburner/mixin/ai/GoalSelectorMixin.java` | `value={GoalSelector.class})` | Overwrite:1 | goalContainsAnyFlags |
| top-level / `com/afterburner/mixin/ai/MoveToBlockGoalMixin.java` | `value={MoveToBlockGoal.class})` | WrapMethod:1 | afterburner$findNearestBlock |
| top-level / `com/afterburner/mixin/ai/PoiManagerMixin.java` | `value={PoiManager.class})` | WrapMethod:1 | afterburner$getInSquare |
| top-level / `com/afterburner/mixin/ai/PoiSectionAccessor.java` | `value={PoiSection.class})` | Accessor:1 |  |
| top-level / `com/afterburner/mixin/ai/RemoveBlockGoalAccessor.java` | `value={RemoveBlockGoal.class})` | Accessor:1 |  |
| top-level / `com/afterburner/mixin/ai/SectionStorageMixin.java` | `value={SectionStorage.class})` | WrapOperation:1 | afterburner$onPut, afterburner$getOrLoad, afterburner$minSection, afterburner$sectionCount |
| top-level / `com/afterburner/mixin/ChunkStepMixin.java` | `value={ChunkStep.class})` | WrapMethod:1 | afterburner$runInParallel |
| top-level / `com/afterburner/mixin/collision/BlockCollisionsMixin.java` | `value={BlockCollisions.class})` | Inject:2 | afterburner$init, afterburner$computeNext, afterburner$bumps, afterburner$overlap, afterburner$kinds, afterburner$check, sameShape |
| top-level / `com/afterburner/mixin/collision/EntityCollisionsMixin.java` | `value={Level.class})` |  | getEntityCollisions |
| top-level / `com/afterburner/mixin/collision/EntitySectionMixin.java` | `value={EntitySection.class})` | Inject:2 | afterburner$onAdd, afterburner$onRemove, afterburner$hardEntities |
| top-level / `com/afterburner/mixin/collision/LevelEntitiesAccessor.java` | `value={Level.class})` | Invoker:1 |  |
| top-level / `com/afterburner/mixin/collision/LevelEntityGetterAdapterAccessor.java` | `value={LevelEntityGetterAdapter.class})` | Accessor:1 |  |
| top-level / `com/afterburner/mixin/collision/VoxelShapeMixin.java` | `value={VoxelShape.class})` |  | afterburner$isBox |
| top-level / `com/afterburner/mixin/entity/EntitySectionStorageMixin.java` | `value={EntitySectionStorage.class})` | Inject:1 | afterburner$forEach |
| top-level / `com/afterburner/mixin/entity/HopperSearchMixin.java` | `value={HopperBlockEntity.class})` | WrapOperation:1 | afterburner$containers |
| top-level / `com/afterburner/mixin/entity/HopperSectionMixin.java` | `value={EntitySection.class})` | Inject:2 | afterburner$onAdd, afterburner$onRemove, afterburner$containers |
| top-level / `com/afterburner/mixin/entity/MobTicksEntityMixin.java` | `value={Entity.class})` | WrapOperation:1 | afterburner$rainOnFire |
| top-level / `com/afterburner/mixin/entity/MobTicksLivingMixin.java` | `value={LivingEntity.class})` | WrapOperation:1 | afterburner$frozenFirst |
| top-level / `com/afterburner/mixin/entity/TrackingRangeMixin.java` | `targets={"net.minecraft.server.level.ChunkMap$TrackedEntity"})` | WrapOperation:1 | afterburner$riders |
| top-level / `com/afterburner/mixin/light/BlockLightEngineMixin.java` | `value={BlockLightEngine.class})` | Overwrite:2 | getEmission, propagateIncrease, propagateDecrease |
| top-level / `com/afterburner/mixin/light/DataLayerStorageMapMixin.java` | `value={DataLayerStorageMap.class})` | Overwrite:2, Inject:3 | afterburner$slot, copyDataLayer, afterburner$onSet, afterburner$onRemove, afterburner$onClear, afterburner$forget, afterburner$clear |
| top-level / `com/afterburner/mixin/light/LayerLightSectionStorageMixin.java` | `value={LayerLightSectionStorage.class})` | Overwrite:1, Inject:1 | afterburner$noKeys, afterburner$slot, setStoredLevel, afterburner$set, afterburner$onSwap |
| top-level / `com/afterburner/mixin/light/LightEngineMixin.java` | `value={LightEngine.class})` | Overwrite:1, Inject:1 | getState, afterburner$onClearChunks, afterburner$clear |
| top-level / `com/afterburner/mixin/light/SkyLightEngineMixin.java` | `value={SkyLightEngine.class})` | Overwrite:2 | countEmptySectionsBelowIfAtBorder, propagateFromEmptySections, propagateIncrease, propagateDecrease |
| top-level / `com/afterburner/mixin/memory/PalettedContainerMixin.java` | `value={PalettedContainer.class})` | WrapOperation:1, Overwrite:2 | acquire, release |
| top-level / `com/afterburner/mixin/spawn/AttributeSamplerAccessor.java` | `targets={"net.minecraft.world.attribute.EnvironmentAttributeSystem$ValueSampler"})` | Accessor:2 |  |
| top-level / `com/afterburner/mixin/spawn/AttributeSystemMixin.java` | `value={EnvironmentAttributeSystem.class})` |  | afterburner$samplers, afterburner$spawnCosts |
| top-level / `com/afterburner/mixin/spawn/NaturalSpawnerMixin.java` | `value={NaturalSpawner.class})` | Inject:1, WrapOperation:2, ModifyReturnValue:1 | afterburner$forget, afterburner$biomeForFish, afterburner$picked, afterburner$mayStay |
| top-level / `com/afterburner/mixin/spawn/SpawnBiomesMixin.java` | `value={ChunkAccess.class})` | Inject:1 | afterburner$biomesGiven |
| top-level / `com/afterburner/mixin/spawn/SpawnBiomesReadMixin.java` | `value={SerializableChunkData.class})` | ModifyReturnValue:1 | afterburner$read |
| top-level / `com/afterburner/mixin/spawn/SpawnCostMixin.java` | `value={NaturalSpawner.class})` | WrapOperation:1 | afterburner$cost |
| top-level / `com/afterburner/mixin/spawn/SpawnStateMixin.java` | `value={NaturalSpawner.SpawnState.class})` | WrapOperation:2 | afterburner$costToTry, afterburner$costSpawned |
| top-level / `com/afterburner/mixin/StructureStartMixin.java` | `value={StructureStart.class})` | WrapMethod:1 | afterburner$oneChunkAtATime |
| top-level / `com/afterburner/mixin/tick/ChunkMapTicksMixin.java` | `value={ChunkMap.class})` | Inject:2, WrapOperation:1 | afterburner$listen, afterburner$takenBack, afterburner$visible |
| top-level / `com/afterburner/mixin/tick/DistanceManagerAccessor.java` | `value={DistanceManager.class})` | Accessor:1 |  |
| top-level / `com/afterburner/mixin/tick/EntityLoadMixin.java` | `value={PersistentEntitySectionManager.class})` | WrapOperation:1 | afterburner$listen, afterburner$loaded |
| top-level / `com/afterburner/mixin/tick/LevelTicksMixin.java` | `value={LevelTicks.class})` | WrapOperation:1, Inject:3 | afterburner$attach, afterburner$parked, afterburner$wake, afterburner$park, afterburner$setAside, afterburner$check, afterburner$added, afterburner$removed |
| top-level / `com/afterburner/mixin/tick/RandomTickChunkMixin.java` | `value={LevelChunk.class})` | Inject:1 | afterburner$tickingSections |
| top-level / `com/afterburner/mixin/tick/RandomTickLevelMixin.java` | `value={ServerLevel.class})` | ModifyExpressionValue:1 | afterburner$tickingSections, afterburner$quietSection |
| top-level / `com/afterburner/mixin/tick/RandomTickSectionMixin.java` | `value={LevelChunkSection.class})` | ModifyReturnValue:1, Inject:1 | afterburner$own, afterburner$changed, afterburner$recounted, afterburner$update |
| top-level / `com/afterburner/mixin/tick/ServerLevelTicksMixin.java` | `value={ServerLevel.class})` | Inject:2 | afterburner$attachTicks, afterburner$startsTicking, afterburner$wakeTicks |
| top-level / `com/afterburner/mixin/tick/SimulationTrackerMixin.java` | `value={SimulationChunkTracker.class})` | Inject:1 | afterburner$listen, afterburner$levelChanged |
| top-level / `com/afterburner/mixin/tick/TicketStorageMixin.java` | `value={TicketStorage.class})` | Inject:1 | afterburner$keepActive, afterburner$keeps |
| top-level / `com/afterburner/mixin/worldgen/BulkSectionAccessMixin.java` | `value={BulkSectionAccess.class})` | Inject:1, Redirect:2 | afterburner$height, afterburner$sectionIndex, afterburner$sectionsCount |
| top-level / `com/afterburner/mixin/worldgen/ClimateLeafMixin.java` | `targets={"net.minecraft.world.level.biome.Climate$RTree$Leaf"})` |  | afterburner$index, afterburner$setIndex |
| top-level / `com/afterburner/mixin/worldgen/ClimateListMixin.java` | `value={Climate.ParameterList.class})` | WrapMethod:1 | afterburner$findValueIndex |
| top-level / `com/afterburner/mixin/worldgen/JigsawPlacementMixin.java` | `value={JigsawPlacement.class})` | WrapOperation:1 | afterburner$room |
| top-level / `com/afterburner/mixin/worldgen/JigsawPlacerMixin.java` | `targets={"net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement$Placer"})` | WrapOperation:3 | afterburner$roomInside, afterburner$taken, afterburner$cut |
| top-level / `com/afterburner/mixin/worldgen/OreVeinShareMixin.java` | `value={MaterialRuleContext.class})` | WrapMethod:1 | afterburner$fillOnce |
| top-level / `com/afterburner/Settings.java` | `` |  | get, set, load, save |
| top-level / `com/afterburner/spawn/SpawnCosts.java` | `` |  | value, arrived, of, workOut |
| top-level / `com/afterburner/spawn/SpawnLookups.java` | `` |  | picked, justPicked, forget, check, checkCost, summary |
| top-level / `com/afterburner/tick/ChunkListener.java` | `` |  |  |
| top-level / `com/afterburner/tick/ParkedTicks.java` | `` |  |  |
| top-level / `com/afterburner/tick/TickingSections.java` | `` |  | pick, check, checkKeepActive, summary |
| top-level / `com/afterburner/tick/TickParking.java` | `` |  | checked, reset, summary |
| top-level / `com/afterburner/tick/TickWaker.java` | `` |  |  |
| top-level / `com/afterburner/worldgen/ClimateIndex.java` | `` |  | of, search, search, distance, last, restore, compare, summary, field, fieldValue, computeValue |
| top-level / `com/afterburner/worldgen/ClimateLeaf.java` | `` |  |  |
| top-level / `com/afterburner/worldgen/FreeSpace.java` | `` |  | full, around, inside, isBox, fits, fitsBox, without, toVanilla, real, getCoords, check, summary, Hole |
| top-level / `com/afterburner/worldgen/OreVeinShare.java` | `` |  | shared, compare, summary |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
