# Fast Surface

Review status: **Evidence inventory; behavioral review pending**

Project: [Fast Surface](https://modrinth.com/mod/zfastsurface)
Selected artifact version: `1.0.0+26.3`
Published implementation source: https://codeberg.org/ZenXArch/FastNoise
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A vanilla worldgen optimization mod to optimise block calculations during surface builder

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `94bf26960bba98cec7027ef01ec7184c7d450c19`
- `sha512`: `7a8f2b72bcb903625bb521d6f99186741e7fc2e63bac574714e3f5fa4c606fea9249104f4756e7384b907245de74564c1c53397dfe951cb292d84cb0fc9747e4`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 20
Reconstructed Java files: 19

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
  "moonrise": "*"
}
```

**accessWidener**

```json
"zfastsurface.ct"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `org/codeberg/zenxarch/fastsurface/config/FastSurfaceConfig.java` | `` |  |  |
| top-level / `org/codeberg/zenxarch/fastsurface/config/FastSurfaceConfigEntries.java` | `` |  |  |
| top-level / `org/codeberg/zenxarch/fastsurface/FastSurfaceConstants.java` | `` |  |  |
| top-level / `org/codeberg/zenxarch/fastsurface/heightmap/HeightmapUtil.java` | `` |  | calculateHeightmaps, updateHeightmap, getHeightmapY |
| top-level / `org/codeberg/zenxarch/fastsurface/mixin/FastSurfaceMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `org/codeberg/zenxarch/fastsurface/mixin/HeightmapAccessor.java` | `value={Heightmap.class})` | Accessor:2 |  |
| top-level / `org/codeberg/zenxarch/fastsurface/mixin/MaterialRuleInterpreterMixin.java` | `targets={"org/codeberg/zenxarch/matcomp/compiler/MaterialRuleInterpreter"})` | Invoker:1 |  |
| top-level / `org/codeberg/zenxarch/fastsurface/mixin/perf/surface/NoiseChunkGeneratorMixin.java` | `value={NoiseBasedChunkGenerator.class})` | WrapOperation:1 | zenxarch$buildSurface |
| top-level / `org/codeberg/zenxarch/fastsurface/surface/cache/FastColumnBitMask.java` | `` |  | get, isSet, isUnset, numberOfTrailingOnes, numberOfTrailingOnes, nor, not, builder, set, build |
| top-level / `org/codeberg/zenxarch/fastsurface/surface/cache/FastColumnIterator.java` | `` |  | isTrivial, getIterator |
| top-level / `org/codeberg/zenxarch/fastsurface/surface/cache/FastIsFluidCache.java` | `` |  | isFluid |
| top-level / `org/codeberg/zenxarch/fastsurface/surface/cache/FastPaletteIndexCache.java` | `` |  | highestNonEmptySection, size, getIdx, updateBlock, getIdxFast, updateBlockFast, finish |
| top-level / `org/codeberg/zenxarch/fastsurface/surface/cache/GenericFastColumnIterator.java` | `` |  | updateBuilders, air, liquid, defaultIdx, start, hasNext, nextY, step, stepStone, step, recalculateSolidBlocksBelowAtStart, recalculateSolidBlocksBelow, computeSolidBlocksBelow |
| top-level / `org/codeberg/zenxarch/fastsurface/surface/cache/TrivialFastColumnIterator.java` | `` |  | start, hasNext, nextY, step, stepStone, step, recalculateSolidBlocksBelow, recalculateSolidBlocksBelowAtStart |
| top-level / `org/codeberg/zenxarch/fastsurface/surface/FastBlockColumn.java` | `` |  | getCompletedMask, updateXZ, getSectionIndex, getSection, zenxarch$getSection, getBlock, setBlock, fastUpdateHeightmap, willHeightmapUpdate |
| top-level / `org/codeberg/zenxarch/fastsurface/surface/FastPosToBiomeBindings.java` | `` |  | call_FastPosToBiome$createPosToBiome |
| top-level / `org/codeberg/zenxarch/fastsurface/surface/FastSurfaceGen.java` | `` |  | canUseSurfaceBuilder, containsAny, sanityCheck, buildSurface, getSteepnessX, getSteepnessZ, willAddWater, willGrow, canSkipSurfaceBuilder |
| top-level / `org/codeberg/zenxarch/fastsurface/surface/MaterialRuleContextHelper.java` | `` |  | initHorizontalContext, air, water, oreOrStone |
| top-level / `org/codeberg/zenxarch/fastsurface/surface/MaterialRuleInterpreterAccessor.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
