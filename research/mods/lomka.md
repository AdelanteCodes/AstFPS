# Lomka

Review status: **Evidence inventory; behavioral review pending**

Project: [Lomka](https://modrinth.com/mod/lomka)
Selected artifact version: `mc26.3-0.7.0-fabric`
Published implementation source: https://github.com/Starlevka/Lomka
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Mix of small optimizations for your Minecraft

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha512`: `9ef1c35242012d9571cb1427a50280c457ed7eca27ed439243eec851ade1b652d9b84ffa7adcafb435cc2a159e45cb6f870aa4a06ca12b6a37f0f76c13232bd3`
- `sha1`: `9f2d4a75ab4a31650ee0e64578bbfc35ff388a94`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 92
Reconstructed Java files: 86

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "lomka.Lomka$Fabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.0",
  "minecraft": ">=26.3"
}
```

**accessWidener**

```json
"26.3.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `lomka/Lomka.java` | `` |  | init, onInitialize |
| top-level / `lomka/starl/config/LomkaMixinPlugin.java` | `` |  | shouldApplyMixin, lomka$lookup, lomka$loadOptions, lomka$defaultConfig, lomka$packagedMixins, getRefMapperConfig, getMixins, acceptTargets, onLoad, preApply, postApply |
| top-level / `lomka/starl/duck/IBitSetDiscreteVoxelShape.java` | `` |  |  |
| top-level / `lomka/starl/duck/IDiscreteVoxelShape.java` | `` |  |  |
| top-level / `lomka/starl/duck/IFrameBufferCacheKey.java` | `` |  |  |
| top-level / `lomka/starl/duck/IGlyphSource.java` | `` |  |  |
| top-level / `lomka/starl/duck/IHeightmap.java` | `` |  |  |
| top-level / `lomka/starl/duck/IKeyframeAnimationEntry.java` | `` |  |  |
| top-level / `lomka/starl/duck/IPalettedContainer.java` | `` |  |  |
| top-level / `lomka/starl/duck/ISpriteContents.java` | `` |  |  |
| top-level / `lomka/starl/mixins/accessor/InvokerBlockBehaviour.java` | `value={BlockBehaviour.class})` | Invoker:1 |  |
| top-level / `lomka/starl/mixins/com/mojang/blaze3d/audio/MixinChannel.java` | `value={Channel.class})` | Inject:1 | lomka$setSelfPosition |
| top-level / `lomka/starl/mixins/com/mojang/blaze3d/audio/MixinListener.java` | `value={Listener.class})` | Overwrite:1 | setTransform |
| top-level / `lomka/starl/mixins/com/mojang/blaze3d/buffers/MixinStd140Builder.java` | `value={Std140Builder.class})` | Overwrite:1 | align |
| top-level / `lomka/starl/mixins/com/mojang/blaze3d/buffers/MixinStd140SizeCalculator.java` | `value={Std140SizeCalculator.class})` | Overwrite:1 | align |
| top-level / `lomka/starl/mixins/com/mojang/blaze3d/platform/MixinKey.java` | `value={InputConstants.Key.class})` | Overwrite:1 | hashCode |
| top-level / `lomka/starl/mixins/com/mojang/blaze3d/platform/MixinLighting.java` | `value={Lighting.class})` | Inject:1, Overwrite:2 | updateBuffer, lomka$initSlices, setupFor, updateLevel |
| top-level / `lomka/starl/mixins/com/mojang/blaze3d/systems/MixinAutoStorageIndexBuffer.java` | `value={RenderSystem.AutoStorageIndexBuffer.class})` | ModifyConstant:1, ModifyArg:1 | lomka$widenIndexBufferGrowth, lomka$warmupIndexBuffer |
| top-level / `lomka/starl/mixins/com/mojang/blaze3d/vertex/MixinBufferBuilder.java` | `value={BufferBuilder.class}, priority=2000)` | Overwrite:4 | beginElement, lomka$packColor, putRgba, setColor, setUv, uvShort |
| top-level / `lomka/starl/mixins/com/mojang/blaze3d/vertex/MixinByteBufferBuilder.java` | `value={ByteBufferBuilder.class}, priority=999)` | Overwrite:1 | reserve, lomka$grow |
| top-level / `lomka/starl/mixins/com/mojang/blaze3d/vertex/MixinUberGpuBuffer.java` | `value={UberGpuBuffer.class})` | Redirect:1 | lomka$fastStagedEntries |
| top-level / `lomka/starl/mixins/com/mojang/blaze3d/vertex/MixinVertexConsumer.java` | `value={VertexConsumer.class}, priority=999)` | Overwrite:3 |  |
| top-level / `lomka/starl/mixins/com/mojang/math/MixinTransformation.java` | `value={Transformation.class})` | Overwrite:1 | inverse |
| top-level / `lomka/starl/mixins/com/mojang/renderpearl/backend/opengl/MixinFrameBufferCache.java` | `value={FrameBufferCache.class})` | Overwrite:1 | getFbo |
| top-level / `lomka/starl/mixins/com/mojang/renderpearl/backend/opengl/MixinFrameBufferCacheKey.java` | `value={FrameBufferCache.CacheKey.class})` |  | lomka$reset |
| top-level / `lomka/starl/mixins/net/minecraft/client/animation/MixinEntry.java` | `targets={"net.minecraft.client.animation.KeyframeAnimation$Entry"})` |  | lomka$apply |
| top-level / `lomka/starl/mixins/net/minecraft/client/animation/MixinKeyframeAnimation.java` | `value={KeyframeAnimation.class})` | Overwrite:1 | apply |
| top-level / `lomka/starl/mixins/net/minecraft/client/gui/font/MixinFontSet.java` | `value={FontSet.class})` | Inject:1 | lomka$clearAdvanceCaches |
| top-level / `lomka/starl/mixins/net/minecraft/client/gui/font/MixinSource.java` | `value={FontSet.Source.class})` |  | lomka$clear, getAdvance |
| top-level / `lomka/starl/mixins/net/minecraft/client/gui/MixinFont.java` | `value={Font.class})` | ModifyArg:1 | getGlyphSource, lomka$cachedWidthProvider |
| top-level / `lomka/starl/mixins/net/minecraft/client/gui/MixinGlyphSource.java` | `value={GlyphSource.class})` |  |  |
| top-level / `lomka/starl/mixins/net/minecraft/client/model/geom/MixinModelPart.java` | `value={ModelPart.class})` | Overwrite:1 | rotateBy |
| top-level / `lomka/starl/mixins/net/minecraft/client/model/MixinModel.java` | `value={Model.class})` | Overwrite:1 | resetPose |
| top-level / `lomka/starl/mixins/net/minecraft/client/renderer/block/MixinBlockModelLighter.java` | `value={BlockModelLighter.class}, priority=500)` | Redirect:1, Inject:2 | lomka$memoisedState, lomka$stateHash, lomka$openWindow, lomka$closeWindow, lomka$clearStates |
| top-level / `lomka/starl/mixins/net/minecraft/client/renderer/entity/MixinDisplayRenderer.java` | `value={DisplayRenderer.class})` | Redirect:1 | lomka$reuseOrientation |
| top-level / `lomka/starl/mixins/net/minecraft/client/renderer/MixinDynamicGpuDataStorageMapped.java` | `value={DynamicGpuDataStorageMapped.class})` | Overwrite:2 | lomka$sliceFor, resizeBuffers, writeData, writeData |
| top-level / `lomka/starl/mixins/net/minecraft/client/renderer/MixinLightmap.java` | `value={Lightmap.class}, priority=500)` | Overwrite:1 | render |
| top-level / `lomka/starl/mixins/net/minecraft/client/renderer/MixinLightmapRenderStateExtractor.java` | `value={LightmapRenderStateExtractor.class}, priority=500)` | Inject:1 | lomka$extract, calculateDarknessScale, lomka$setVector3fFromRGB24 |
| top-level / `lomka/starl/mixins/net/minecraft/client/renderer/texture/MixinSpriteContents.java` | `value={SpriteContents.class})` |  | lomka$releaseUnusedMipLevels |
| top-level / `lomka/starl/mixins/net/minecraft/client/renderer/texture/MixinTextureAtlas.java` | `value={TextureAtlas.class}, priority=500)` | Inject:1, Overwrite:2 | lomka$initDevice, cycleAnimationFrames, uploadAnimationFrames |
| top-level / `lomka/starl/mixins/net/minecraft/client/renderer/texture/MixinTextureAtlasMip.java` | `value={TextureAtlas.class})` | Inject:1 | lomka$releaseUnusedMipLevels |
| top-level / `lomka/starl/mixins/net/minecraft/client/resources/model/MixinBuilder.java` | `value={QuadCollection.Builder.class})` | Overwrite:3 | createFromSublists, addCulledFace, build, addAll, lomka$addFaceList, lomka$getList |
| top-level / `lomka/starl/mixins/net/minecraft/client/sounds/MixinChunkedSampleByteBuf.java` | `value={ChunkedSampleByteBuf.class})` | Overwrite:2 | accept, get, grow |
| top-level / `lomka/starl/mixins/net/minecraft/client/sounds/MixinJOrbisAudioStream.java` | `value={JOrbisAudioStream.class})` | Overwrite:1 | getSamplesToWrite, isError, copyMono, copyStereo, copyAnyChannels, readChunk |
| top-level / `lomka/starl/mixins/net/minecraft/client/sounds/MixinSoundEngine.java` | `value={SoundEngine.class})` | Redirect:1, Inject:1 | lomka$acquireChannelHandle, lomka$dropPooledHandles, lomka$topUp, lomka$poll, lomka$refill, lomka$queues, lomka$counters, lomka$sizes |
| top-level / `lomka/starl/mixins/net/minecraft/core/MixinBlockPos.java` | `value={BlockPos.class})` | Overwrite:1 | betweenClosed, computeNext |
| top-level / `lomka/starl/mixins/net/minecraft/core/MixinCursor3D.java` | `value={Cursor3D.class})` | Overwrite:1 | advance |
| top-level / `lomka/starl/mixins/net/minecraft/core/MixinDirect.java` | `value={HolderSet.Direct.class})` | Overwrite:1 | contains |
| top-level / `lomka/starl/mixins/net/minecraft/core/MixinDirection.java` | `value={Direction.class})` | Overwrite:2 | getClockWise, getCounterClockWise |
| top-level / `lomka/starl/mixins/net/minecraft/core/MixinSectionPos.java` | `value={SectionPos.class})` | Overwrite:3 | y, z, blockToSectionCoord, offset, aroundAndAtBlockPos, betweenClosedStream, tryAdvance, forEachRemaining |
| top-level / `lomka/starl/mixins/net/minecraft/core/MixinVec3i.java` | `value={Vec3i.class}, priority=999)` | Overwrite:3 | get, distManhattan, hashCode |
| top-level / `lomka/starl/mixins/net/minecraft/nbt/MixinIntArrayTag.java` | `targets={"net.minecraft.nbt.IntArrayTag$1"})` | Overwrite:1 | load, lomka$readInts |
| top-level / `lomka/starl/mixins/net/minecraft/nbt/MixinLongArrayTag.java` | `targets={"net.minecraft.nbt.LongArrayTag$1"})` | Overwrite:1 | load, lomka$readLongs |
| top-level / `lomka/starl/mixins/net/minecraft/network/MixinCompressionDecoder.java` | `value={CompressionDecoder.class})` | Overwrite:1 | setupInflaterInput |
| top-level / `lomka/starl/mixins/net/minecraft/network/MixinCompressionEncoder.java` | `value={CompressionEncoder.class})` | Overwrite:1 | encode |
| top-level / `lomka/starl/mixins/net/minecraft/network/MixinFriendlyByteBuf.java` | `value={FriendlyByteBuf.class})` | Overwrite:2 | writeEnumSet, readEnumSet |
| top-level / `lomka/starl/mixins/net/minecraft/network/protocol/game/MixinVecDeltaCodec.java` | `value={VecDeltaCodec.class}, priority=999)` | Overwrite:1 | delta |
| top-level / `lomka/starl/mixins/net/minecraft/server/packs/resources/MixinFallbackResourceManager.java` | `value={FallbackResourceManager.class})` | Inject:1 | parseMetadata, lomka$isMetadata, lomka$getIdentifierFromMetadata, lomka$convertToMetadata, lomka$isIncluded, wrapForDebug, lomka$listResources |
| top-level / `lomka/starl/mixins/net/minecraft/server/packs/resources/MixinMultiPackResourceManager.java` | `value={MultiPackResourceManager.class})` | Overwrite:2 | checkTrailingDirectoryPath, listResources, listResourceStacks |
| top-level / `lomka/starl/mixins/net/minecraft/util/MixinARGB.java` | `value={ARGB.class})` | Overwrite:9 | alphaFloat, redFloat, greenFloat, blueFloat, alphaBlend, scaleRGB, scaleRGB, average, multiply |
| top-level / `lomka/starl/mixins/net/minecraft/util/MixinArrayListDeque.java` | `value={ArrayListDeque.class})` | ModifyVariable:1, Overwrite:7 | lomka$incModCount, lomka$roundToPowerOfTwo, getIndex, grow, addFirst, addLast, removeFirst, removeLast, remove |
| top-level / `lomka/starl/mixins/net/minecraft/util/MixinByIdMap.java` | `value={ByIdMap.class})` | Overwrite:3 | createMap, sparse, createSortedArray, continuous |
| top-level / `lomka/starl/mixins/net/minecraft/util/MixinLightCoordsUtil.java` | `value={LightCoordsUtil.class})` | Overwrite:3 | addSmoothBlockEmission, getLightCoords, getLightCoords |
| top-level / `lomka/starl/mixins/net/minecraft/util/MixinMth.java` | `value={Mth.class})` | Overwrite:6 | ceillog2, log2, smallestEncompassingPowerOfTwo, binarySearch, unpackDegrees, hsvToArgb |
| top-level / `lomka/starl/mixins/net/minecraft/util/MixinUtil.java` | `value={Util.class})` | Overwrite:9 | getEpochMillis, sanitizeName, isSymmetrical, createIndexIdentityLookup, shuffle, toShuffledList, offsetByCodepoints, allOf, anyOf |
| top-level / `lomka/starl/mixins/net/minecraft/util/random/MixinCompact.java` | `targets={"net.minecraft.util.random.WeightedList$Compact"})` | Inject:1, Overwrite:1 | lomka$buildPrefixSums, get, lomka$linearScan |
| top-level / `lomka/starl/mixins/net/minecraft/util/thread/MixinBlockableEventLoop.java` | `value={BlockableEventLoop.class})` | Redirect:1 | lomka$noIdeTaskZone |
| top-level / `lomka/starl/mixins/net/minecraft/world/level/block/state/MixinBlockStateBase.java` | `targets={"net.minecraft.world.level.block.state.BlockBehaviour$BlockStateBase"})` | Overwrite:1 | getCollisionShape |
| top-level / `lomka/starl/mixins/net/minecraft/world/level/block/state/MixinBlockStateBaseCache.java` | `targets={"net.minecraft.world.level.block.state.BlockBehaviour$BlockStateBase$Cache"})` | Inject:1, Overwrite:1 | lomka$initSturdyMask, isFaceSturdy |
| top-level / `lomka/starl/mixins/net/minecraft/world/level/chunk/MixinPalettedContainer.java` | `value={PalettedContainer.class})` | Inject:2, Overwrite:1 | lomka$invalidateUniform, lomka$invalidateBeforeRead, lomka$invalidateBeforeResize, lomka$uniformValue, get |
| top-level / `lomka/starl/mixins/net/minecraft/world/level/chunk/status/MixinChunkStatus.java` | `value={ChunkStatus.class})` | Overwrite:1 | getStatusList |
| top-level / `lomka/starl/mixins/net/minecraft/world/level/levelgen/MixinHeightmap.java` | `value={Heightmap.class}, priority=999)` | Overwrite:1 | lomka$setHeightAt, primeHeightmaps |
| top-level / `lomka/starl/mixins/net/minecraft/world/level/levelgen/MixinLegacyRandomSource.java` | `value={LegacyRandomSource.class})` | Inject:2 | lomka$fastNext, lomka$syncPlainSeed |
| top-level / `lomka/starl/mixins/net/minecraft/world/level/levelgen/MixinXoroshiroRandomSource.java` | `value={XoroshiroRandomSource.class})` | Inject:1 | lomka$reseedInPlace |
| top-level / `lomka/starl/mixins/net/minecraft/world/level/lighting/MixinLayerLightSectionStorage.java` | `value={LayerLightSectionStorage.class})` | Overwrite:1 | setStoredLevel |
| top-level / `lomka/starl/mixins/net/minecraft/world/level/MixinBlockGetter.java` | `value={BlockGetter.class})` | Overwrite:1 | forEachBlockIntersectedBetween |
| top-level / `lomka/starl/mixins/net/minecraft/world/phys/MixinAABB.java` | `value={AABB.class})` | Overwrite:3 | clip, clip |
| top-level / `lomka/starl/mixins/net/minecraft/world/phys/MixinVec3.java` | `value={Vec3.class})` | Overwrite:1 | normalize |
| top-level / `lomka/starl/mixins/net/minecraft/world/phys/shapes/MixinBitSetDiscreteVoxelShape.java` | `value={BitSetDiscreteVoxelShape.class})` | Overwrite:1 | lomka$storage, lomka$index, lomka$flushRun, lomka$setBounds, join |
| top-level / `lomka/starl/mixins/net/minecraft/world/phys/shapes/MixinDiscreteVoxelShape.java` | `value={DiscreteVoxelShape.class})` |  | lomka$boxes |
| top-level / `lomka/starl/mixins/net/minecraft/world/phys/shapes/MixinVoxelShape.java` | `value={VoxelShape.class})` | Overwrite:2 | forAllBoxes, toAabbs |
| top-level / `lomka/starl/utils/cache/UniformPaletteCache.java` | `` |  |  |
| top-level / `lomka/starl/utils/constants/DirectionTables.java` | `` |  |  |
| top-level / `lomka/starl/utils/math/AxisPoseRotate.java` | `` |  | mulPose, rotateX, rotateY, rotateZ |
| top-level / `lomka/starl/utils/math/BlockStepSweep.java` | `` |  | forEachBlockIntersectedBetween, lomka$addCollisionsAlongTravel, lomka$walkCorners, lomka$hit, lomka$span, lomka$offset |
| top-level / `lomka/starl/utils/pack/ResourceEntry.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
