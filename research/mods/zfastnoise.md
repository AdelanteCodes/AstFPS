# Fast Noise

Review status: **Evidence inventory; behavioral review pending**

Project: [Fast Noise](https://modrinth.com/mod/zfastnoise)
Selected artifact version: `1.1.1+26.3`
Published implementation source: https://codeberg.org/ZenXArch/FastNoise
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Vanilla Worldgen optimization mod

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `81e9e2063fac33293b14701b7c72b922febda5eaf5c7c631ab9f588c96ba835df7dfd14dcac6763f414e83366c72445fdfae4d74ba7f7a9b73707446a264c87f`
- `sha1`: `f440a683630858b8d4d69a170eae4428e0e5af51`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 19
Reconstructed Java files: 17

**environment**

```json
"*"
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "zconfig": ">=1.0.0+26.x"
}
```

**breaks**

```json
{
  "moonrise": "*",
  "antixray": "*"
}
```

**accessWidener**

```json
"zfastnoise.ct"
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/zfastnoise-ocl-1.0.0-beta.1+26.3.jar` | 2 | `zfastnoise-ocl` | Reconstructed source; semantic review pending |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `org/codeberg/zenxarch/fastnoise/biome/FastBiomeGen.java` | `` |  | populateBiomes, populateBiomesImpl, packSingleBiome, populateBiomes, getEndBiomeFromHeight, populateEndBiomes, sampleAndStep |
| top-level / `org/codeberg/zenxarch/fastnoise/biome/TheEndBiomeSupplier.java` | `` |  | getNoiseBiome |
| top-level / `org/codeberg/zenxarch/fastnoise/config/FastNoiseConfig.java` | `` |  |  |
| top-level / `org/codeberg/zenxarch/fastnoise/config/FastNoiseConfigEntries.java` | `` |  | of, of, mixin |
| top-level / `org/codeberg/zenxarch/fastnoise/FastNoiseConstants.java` | `` |  |  |
| top-level / `org/codeberg/zenxarch/fastnoise/heightmap/HeightmapUtil.java` | `` |  | calculateHeightmaps, updateHeightmap, getHeightmapY, getLocalY, findFirstNonEmptySection, populateHeightmapPostNoise, get |
| top-level / `org/codeberg/zenxarch/fastnoise/mixin/debug/disable_carve_features_and_entities/ChunkGeneratingMixin.java` | `value={ChunkStatusTasks.class})` | Inject:1 | noopStuff |
| top-level / `org/codeberg/zenxarch/fastnoise/mixin/FastNoiseMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `org/codeberg/zenxarch/fastnoise/mixin/HeightmapAccessor.java` | `value={Heightmap.class})` | Accessor:2 |  |
| top-level / `org/codeberg/zenxarch/fastnoise/mixin/perf/biome/ChunkMixin.java` | `value={ChunkAccess.class})` | WrapMethod:1 | zenxarch$populateBiomes |
| top-level / `org/codeberg/zenxarch/fastnoise/mixin/perf/biome/TheEndBiomeSourceMixin.java` | `value={TheEndBiomeSource.class})` | Overwrite:1 | createResolver |
| top-level / `org/codeberg/zenxarch/fastnoise/mixin/perf/noise/NoiseChunkGeneratorMixin.java` | `value={NoiseBasedChunkGenerator.class})` | Redirect:2, WrapMethod:1 | zenxarch$cancelLocking, zenxarch$cancelSetAdd, zenxarch$populateNoise |
| top-level / `org/codeberg/zenxarch/fastnoise/noise/container/BlockCountingPalettedContainer.java` | `` |  | updateCount, updateCount, count, revert |
| top-level / `org/codeberg/zenxarch/fastnoise/noise/EndBiomeStorageCache.java` | `` |  | getBits, createCache, createCache, indexFromValues, get |
| top-level / `org/codeberg/zenxarch/fastnoise/noise/FastChunkSection.java` | `` |  | setDefaultBlockState, getIndex, setBlockState, setBlockState, recalculateCounts |
| top-level / `org/codeberg/zenxarch/fastnoise/noise/FastNoiseGen.java` | `` |  | isEmpty, populateNoise, finalizeChunks |
| top-level / `org/codeberg/zenxarch/fastnoise/noise/FastNoisePaletteHelper.java` | `` |  | pack, repackBiomeStorage, packSingleElement, index, packFourEntries |
| META-INF/jars/zfastnoise-ocl-1.0.0-beta.1+26.3.jar / `org/codeberg/zenxarch/fastnoise/ocl/FastChunkSection.java` | `` |  | getIndex, handleLong, initDefaultPacked, recalculateCounts |
| META-INF/jars/zfastnoise-ocl-1.0.0-beta.1+26.3.jar / `org/codeberg/zenxarch/fastnoise/ocl/FastCopyBufferDataIntoChunks.java` | `` |  | copyData, copyData, copyDataIntoChunk, copyDataIntoChunk, getLong, handleLong, finalizeChunks |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
