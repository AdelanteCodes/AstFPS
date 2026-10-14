# Material Rule Compiler

Review status: **Evidence inventory; behavioral review pending**

Project: [Material Rule Compiler](https://modrinth.com/mod/zmaterial-rule-compiler)
Selected artifact version: `1.1.2+26.3`
Published implementation source: https://codeberg.org/ZenXArch/FastNoise
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A vanilla worldgen optimization mod. Works by compiling material rules to bytecode and optimizing material rules.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `0daf682fefca09212897d06e5cce544b4985cf79d17aed73f98a65b91513e70c06679fbbc261ffa1abbb89b92b99abb103368bedd645fe485b50a98d2a24e463`
- `sha1`: `93280f68a8a2cb2f79bb175fed5d3f618744028a`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 82
Reconstructed Java files: 47

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
"zmatcomp.ct"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `org/codeberg/zenxarch/matcomp/biome/FastBiomeAccumulator.java` | `` |  | accumulate, accumulate |
| top-level / `org/codeberg/zenxarch/matcomp/biome/FastBiomeCache.java` | `` |  | getBit, findIdx, getBitIdx, getBiomeOrNull, getBiomeOrNull, getBiomeIdxOrNull, getBiomeIdxOrNull, getCacheForY, getForSectionY |
| top-level / `org/codeberg/zenxarch/matcomp/biome/FastChunkBiomeCache.java` | `` |  | fillArray, setBit, indexOf, getBiome |
| top-level / `org/codeberg/zenxarch/matcomp/biome/FastPosToBiome.java` | `` |  | createPosToBiome, collectChunks, getBiomes, getBiomes, apply, apply, apply |
| top-level / `org/codeberg/zenxarch/matcomp/compiler/CompiledBlockStateRule.java` | `` |  |  |
| top-level / `org/codeberg/zenxarch/matcomp/compiler/CompiledMaterialRule.java` | `` |  | compile, codec |
| top-level / `org/codeberg/zenxarch/matcomp/compiler/cw/BaseMaterialRuleClassWriter.java` | `` |  | emitIfElse, emitNullReturn, emitReturn, emitBlockStateRule, emitStaticRule, emitTailCall, callCondition, emitConditionCall, callBlockStateRule, callBlockStateRule, callBlockStateRuleMethodInClass, loadConditions, loadRules, loadx, loady, loadz, loadCtx |
| top-level / `org/codeberg/zenxarch/matcomp/compiler/cw/ExtendedClassWriter.java` | `` |  | dumpClass, start, finish, addStaticFinalField, beginStaticInit, initStaticField, finishStaticInit, newMethod, startMethodVisit, endMethodVisit, loadIntVar, loadObjVar, defineTemporaryClass, definePermanentClass, loadClass |
| top-level / `org/codeberg/zenxarch/matcomp/compiler/cw/FlattenedMaterialRuleClassWriter.java` | `` |  | compile, writeBlockFields, putfields, writeStaticCondition, visitFunctionParams, loadCtx |
| top-level / `org/codeberg/zenxarch/matcomp/compiler/cw/MaterialRuleClassWriter.java` | `` |  | compile, commonVariableCount, compile, newMethod, getCurrentBiome, contains, emitBiomeListContains, emitSingleBiomeEquals, visitFunctionParams, callBlockStateRuleMethodInClass |
| top-level / `org/codeberg/zenxarch/matcomp/compiler/cw/PreCompileMaterialRuleClassWriter.java` | `` |  | objToBoolean, compile, commonVariableCount, compile, newMethod, emitBiomeCondition, visitFunctionParams, callBlockStateRuleMethodInClass, callBlockStateRuleMethodInClass, loadBiomeConditions |
| top-level / `org/codeberg/zenxarch/matcomp/compiler/ir/FlattenedBlockStateRule.java` | `` |  |  |
| top-level / `org/codeberg/zenxarch/matcomp/compiler/ir/FlattenedMaterialRule.java` | `` |  | invertOpcode, flatten, push, pushCond, dereference, dereference, add |
| top-level / `org/codeberg/zenxarch/matcomp/compiler/MaterialRuleCompilerCache.java` | `` |  | equals, hashCode, create, get, CacheKey |
| top-level / `org/codeberg/zenxarch/matcomp/compiler/MaterialRuleCompilerCacheHeightContextSpecific.java` | `` |  | get, get, getCacheKey, getCompiled, fillBiomeCacheKey, fillBiomeCacheKeySingle, of, access, conditionalPush, conditionalPushWithInst, push, prog, addInst, removeInst, build |
| top-level / `org/codeberg/zenxarch/matcomp/compiler/MaterialRuleCompilerCacheHolder.java` | `` |  |  |
| top-level / `org/codeberg/zenxarch/matcomp/compiler/MaterialRuleCompilerFunctions.java` | `` |  | loadX, loadY, loadZ, loadStoneDepthAbove, loadStoneDepthBelow, loadRunDepth, loadFluidHeight, getMultipliedSecondaryDepthRange, xoroVerticalGradient, checkedVerticalGradient, negativeRunDepth, surfacePredicate, biomeTemperaturePredicate, steepSlopePredicate, slopeCondition, slopeConditionAbove, slopeConditionBelow, slopeConditionEquals |
| top-level / `org/codeberg/zenxarch/matcomp/compiler/PreCompileBlockStateRule.java` | `` |  |  |
| top-level / `org/codeberg/zenxarch/matcomp/compiler/StaticMaterialCondition.java` | `` |  | callFuncWithCtxAtEnd, retBoolean, retBoolean, retBooleanUsingJump, loadX, loadY, loadZ, loadStoneDepthAbove, loadStoneDepthBelow, loadRunDepth, loadFluidHeight, getMultipliedSecondaryDepthRange, getDescriptorForCondition, emitBytecode, emitBytecode, emitBytecode, emitBytecode, emitBytecode, emitBytecode, emitBytecode, emitBytecode, emitBytecode, emitBytecode |
| top-level / `org/codeberg/zenxarch/matcomp/compiler/StaticMaterialRule.java` | `` |  | callTerracottaRule, getRule, emitBytecode |
| top-level / `org/codeberg/zenxarch/matcomp/config/MaterialRuleCompilerConfig.java` | `` |  | scaleByMemory |
| top-level / `org/codeberg/zenxarch/matcomp/config/MaterialRuleCompilerConfigEntries.java` | `` |  |  |
| top-level / `org/codeberg/zenxarch/matcomp/MaterialRuleCompilerConstants.java` | `` |  |  |
| top-level / `org/codeberg/zenxarch/matcomp/mixin/lithostitched/AllOfConditionMixin.java` | `targets={"dev/worldgen/lithostitched/impl/worldgen/material/condition/AllOfCondition"})` | Overwrite:1 | compile |
| top-level / `org/codeberg/zenxarch/matcomp/mixin/lithostitched/AnyOfConditionMixin.java` | `targets={"dev/worldgen/lithostitched/impl/worldgen/material/condition/AnyOfCondition"})` | Overwrite:1 | compile |
| top-level / `org/codeberg/zenxarch/matcomp/mixin/lithostitched/BandlandsRuleMixin.java` | `targets={"dev/worldgen/lithostitched/impl/worldgen/material/rule/BandlandsRule"}); targets={"dev/worldgen/lithostitched/impl/worldgen/bandlands/Bandlands"})` | Overwrite:1 | compile |
| top-level / `org/codeberg/zenxarch/matcomp/mixin/lithostitched/SlopeConditionMixin.java` | `targets={"dev/worldgen/lithostitched/impl/worldgen/material/condition/SlopeCondition"})` | Overwrite:1 | compile |
| top-level / `org/codeberg/zenxarch/matcomp/mixin/MaterialRuleCompilerMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `org/codeberg/zenxarch/matcomp/mixin/perf/biome/SurfaceBuilderMixin.java` | `value={MaterialSystem.class})` | ModifyArg:1 | zenxarch$setPosToBiome |
| top-level / `org/codeberg/zenxarch/matcomp/mixin/perf/compiler/SequenceMaterialRuleMixin.java` | `value={SequenceRule.class}, priority=2000)` | Overwrite:1 | compile |
| top-level / `org/codeberg/zenxarch/matcomp/mixin/perf/compiler/SurfaceBuilderMixin.java` | `value={MaterialSystem.class})` |  | zenxarch$getCache |
| top-level / `org/codeberg/zenxarch/matcomp/mixin/perf/packed/ChunkGeneratingMixin.java` | `value={ChunkStatusTasks.class})` | Overwrite:1 | collectPossibleBiomes |
| top-level / `org/codeberg/zenxarch/matcomp/mixin/perf/surface/AboveYMaterialConditionMixin.java` | `value={YCondition.class})` | Overwrite:1 | compile |
| top-level / `org/codeberg/zenxarch/matcomp/mixin/perf/surface/BiomeMaterialConditionMixin.java` | `value={BiomeCondition.class})` | Overwrite:1 | compile |
| top-level / `org/codeberg/zenxarch/matcomp/mixin/perf/surface/ConditionMaterialRuleMixin.java` | `value={ConditionRule.class})` | Overwrite:1 | compile |
| top-level / `org/codeberg/zenxarch/matcomp/mixin/perf/surface/OreVeinSamplerMixin.java` | `value={OreVeinRule.class})` | WrapMethod:1 | getBlockStateRule |
| top-level / `org/codeberg/zenxarch/matcomp/mixin/perf/surface/SurfaceBuilderMixin.java` | `value={MaterialSystem.class})` | Overwrite:1 | getSurfaceDepth |
| top-level / `org/codeberg/zenxarch/matcomp/rules/AboveYPredicate.java` | `` |  | test |
| top-level / `org/codeberg/zenxarch/matcomp/rules/BiomePredicate.java` | `` |  | getSupplier, test, test |
| top-level / `org/codeberg/zenxarch/matcomp/rules/ConditionalBlockStateRule.java` | `` |  |  |
| top-level / `org/codeberg/zenxarch/matcomp/rules/LithostitchedConditions.java` | `` |  | compileAllofCondition, compileAnyofCondition, compileSlopeCondition, test, test, test |
| top-level / `org/codeberg/zenxarch/matcomp/rules/LithostitchedRules.java` | `` |  | compile |
| top-level / `org/codeberg/zenxarch/matcomp/rules/OreVeinMaterialRule.java` | `` |  | create |
| top-level / `org/codeberg/zenxarch/matcomp/rules/StoneDepthPredicate.java` | `` |  | create, test |
| top-level / `org/codeberg/zenxarch/matcomp/rules/VanillaBiomePredicate.java` | `` |  | test |
| top-level / `org/codeberg/zenxarch/matcomp/rules/VerticalGradientPredicate.java` | `` |  | test, map, test, test |
| top-level / `org/codeberg/zenxarch/matcomp/util/AllocFreeRandom.java` | `` |  | splitXoroshiro, nextFloatXoroshiro, nextFloatXoroshiroLast, nextFloatXoroshiro, nextFloatChecked, nextDoubleXoroshiro, nextDoubleChecked |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
