# Better Biome Blend

Review status: **Evidence inventory; behavioral review pending**

Project: [Better Biome Blend](https://modrinth.com/mod/better-biome-blend)
Selected artifact version: `26.3-1.4.0-fabric`
Published implementation source: https://github.com/FionaTheMortal/better-biome-blend
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Improves biome colors

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `66e82c5e86b8377c20978dfca7c1fb69b68513d738df0c6dfbb387ac01a96f0932093b3dd674ee7bf40ede98da59f3677938a455affa08ac7629fe6efb595edc`
- `sha1`: `8361c6d55399052d0ee13c191163d19660ab4af1`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 36
Reconstructed Java files: 35

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "fionathemortal.betterbiomeblend.fabric.BetterBiomeBlendFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

**accessWidener**

```json
"betterbiomeblend.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `fionathemortal/betterbiomeblend/BetterBiomeBlend.java` | `` |  |  |
| top-level / `fionathemortal/betterbiomeblend/BetterBiomeBlendClient.java` | `` |  | getBlendRadiusSetting, setBlendRadiusSetting |
| top-level / `fionathemortal/betterbiomeblend/BetterBiomeBlendOptions.java` | `` |  |  |
| top-level / `fionathemortal/betterbiomeblend/common/cache/CacheConfig.java` | `` |  | floorBlockToSample, ceilBlockToSample, floorSampleToSlice, ceilSampleToSlice, floorBlockToSlice, ceilBlockToSlice, getSampleFromSlice |
| top-level / `fionathemortal/betterbiomeblend/common/cache/LocalCache.java` | `` |  | getColorType, getSlice, putSlice, ensureColorTypeSupport |
| top-level / `fionathemortal/betterbiomeblend/common/cache/Slice.java` | `` |  | init, getInvalidationKey, isSolid, getColor, setColor, getReferenceCount, release, acquire, markAsInvalid, linkRemove, linkInsert |
| top-level / `fionathemortal/betterbiomeblend/common/cache/SliceCache.java` | `` |  | ownsSlice, getKey, getInvalidationKey, getInvalidationKey, getSlice, newSlice, putSlice, releaseSlice, invalidateBlocks, invalidateChunk, destroy, getGenTick, lockedInvalidateSlice, lockedInvalidateSlices, lockedInvalidateSamplesInSlice, lockedInvalidateSamplesInSlices, invalidateSlices, getFreeList, getFreeList, getHash, getHash, allocSlices, lockedReleaseSlice, lockedAddToFreeList, lockedAddToInvalidationHash, lockedAddToHash, lockedRemoveFromInvalidationHash, lockedRemoveFromHash, lockedGetSlice, lockedGetSlice, lockedPutSlice, lockedEvictLRUSlice, lockedNewSlice |
| top-level / `fionathemortal/betterbiomeblend/common/ColorBlending.java` | `` |  | getSampleContribution, copyLineForBlending, blendColorsInLine, accumulateLine, initLineBuffers, blendColorsInPlane, accumulatePlane, initPlaneBuffers, blendColors |
| top-level / `fionathemortal/betterbiomeblend/common/ColorConfig.java` | `` |  | getCurrentConfig, getSourceConfig, getResultConfig, floorBlockToSample, ceilBlockToSample, getBlockFromSample, getSampleFromSlice, getSliceFromSample |
| top-level / `fionathemortal/betterbiomeblend/common/ColorGather.java` | `` |  | getBiomeForBlock, getColorForBlock, getRandomSamplePosition, gatherColorsInSlice, gatherColors |
| top-level / `fionathemortal/betterbiomeblend/common/ColorGen.java` | `` |  | acquireContext, endChunkGen, gatherColors, gatherColors, outputSingleColor, outputColorsDirectly, blendColors |
| top-level / `fionathemortal/betterbiomeblend/common/ColorGenContext.java` | `` |  | initSource, initOutput, releaseOutput, resetColorBits, isSolid, getSingleColor, setColorSample, ensureBufferCapacities |
| top-level / `fionathemortal/betterbiomeblend/common/ColorSource.java` | `` |  | getSlice, genSlice, releaseSlice, invalidateChunk, destroy |
| top-level / `fionathemortal/betterbiomeblend/common/ColorType.java` | `` |  | getColorTypeFromResolver |
| top-level / `fionathemortal/betterbiomeblend/common/compat/CustomColorResolver.java` | `` |  | addNewColorResolverID, addNewColorResolver, getColorType |
| top-level / `fionathemortal/betterbiomeblend/common/debug/Debug.java` | `` |  | toggleBenchmark, getAverageElapsedTime, collateDebugEvents, initialize, teardown, growEventBuffer, pushDebugEvent, pushColorGenEvent, pushSubevent, endEvent, countColorType |
| top-level / `fionathemortal/betterbiomeblend/common/debug/DebugEvent.java` | `` |  |  |
| top-level / `fionathemortal/betterbiomeblend/common/debug/DebugEventType.java` | `` |  |  |
| top-level / `fionathemortal/betterbiomeblend/common/debug/DebugSummary.java` | `` |  |  |
| top-level / `fionathemortal/betterbiomeblend/common/util/Array1c.java` | `` |  | getArrayIndex, getSize, ensureCapacity |
| top-level / `fionathemortal/betterbiomeblend/common/util/Array2c.java` | `` |  | getArrayIndex, getSize, ensureCapacity |
| top-level / `fionathemortal/betterbiomeblend/common/util/Array3c.java` | `` |  | getArrayIndex, getStrideX, getStrideY, getStrideZ, getSize, ensureCapacity |
| top-level / `fionathemortal/betterbiomeblend/common/util/Array3i.java` | `` |  | fill, copy, getStrideX, getStrideY, getStrideZ, getArrayIndex, getSize, ensureCapacity |
| top-level / `fionathemortal/betterbiomeblend/common/util/Color.java` | `` |  | makeRGBAWithFullAlpha, RGBAGetR, RGBAGetG, RGBAGetB, byteToNormalizedFloat, normalizedFloatToByte, sRGBToLinear, linearTosRGB, sRGBByteToLinearFloat, linearFloatTosRGBByte, sRGBByteToOKLabs, OKLabsTosRGBByte, OKLabsTosRGBAInt |
| top-level / `fionathemortal/betterbiomeblend/common/util/Random.java` | `` |  | noise |
| top-level / `fionathemortal/betterbiomeblend/common/util/Util.java` | `` |  | lowerBitMask32, lowerBitMask64, lowerBits, lowerBits, blockToChunk, chunkToBlock, getBlockInChunk |
| top-level / `fionathemortal/betterbiomeblend/fabric/BetterBiomeBlendFabric.java` | `` |  | onInitializeClient |
| top-level / `fionathemortal/betterbiomeblend/fabric/compat/sodium/mixin/MixinBiomeColorCache.java` | `value={LevelColorCache.class})` | Inject:2, Overwrite:1 | bbb$onInit, bbb$onUpdate, getColor, bbb$isValid, bbb$invalidate |
| top-level / `fionathemortal/betterbiomeblend/fabric/compat/sodium/mixin/MixinSodiumConfigBuilder.java` | `value={SodiumConfigBuilder.class}, remap=false)` | Inject:1 | bbb$biomeBlendFormatter, bbb$onBuildQualityPage |
| top-level / `fionathemortal/betterbiomeblend/fabric/compat/sodium/SodiumColorGather.java` | `` |  | getColor, gatherColors |
| top-level / `fionathemortal/betterbiomeblend/fabric/compat/sodium/SodiumColorGen.java` | `` |  | acquireContext, endChunkGen, gatherColors, genColors |
| top-level / `fionathemortal/betterbiomeblend/fabric/compat/sodium/SodiumConfig.java` | `` |  | getCurrentConfig |
| top-level / `fionathemortal/betterbiomeblend/mixin/MixinClientWorld.java` | `value={ClientLevel.class}, priority=500)` | Inject:3, Overwrite:1 | bbb$onInit, bbb$onClearTintCaches, bbb$onOnChunkLoaded, bbb$getColorSource, getBlockTint |
| top-level / `fionathemortal/betterbiomeblend/mixin/MixinOptions.java` | `value={Options.class})` | Invoker:1, Inject:2 | bbb$initBiomeBlendRadius, bbb$onProcessDumpedOptions, betterBiomeBlendRadius, bbb$operateOnLevelExtractor |
| top-level / `fionathemortal/betterbiomeblend/mixin/MixinVideoSettingsScreen.java` | `value={VideoSettingsScreen.class})` | Inject:1 | bbb$modifyQualityOptions |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
