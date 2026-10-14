# VectorX

Review status: **Evidence inventory; behavioral review pending**

Project: [VectorX](https://modrinth.com/mod/vectorx)
Selected artifact version: `0.2.0`
Published implementation source: https://github.com/etil2jz/VectorX
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Vectorizes specific Minecraft hot paths to make them faster

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `03f593d99ab7c87c803b660273179190bd04a92f`
- `sha512`: `36141338ba4ba254124a8cef5cd31801feae0f11032f303f88f37c56eba5a3e047c133ce1be82691aa97ff3bb1743d2768b3576ab96e1375d62c9f9bc5d198e5`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 74
Reconstructed Java files: 54

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "xyz.blanchot.vectorx.VectorX"
  ],
  "client": [
    "xyz.blanchot.vectorx.client.VectorXClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fzzy_config": ">=0.7.7",
  "fabric-language-kotlin": ">=1.13.13"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `xyz/blanchot/vectorx/carve/CanyonCarveGeometry.java` | `` |  | sweepVectorized, sweepReference, referenceShouldSkip |
| top-level / `xyz/blanchot/vectorx/client/VectorXClient.java` | `` |  | onInitializeClient |
| top-level / `xyz/blanchot/vectorx/compat/CompatibilityRegistry.java` | `` |  | conflictingKernels, knownConflicts |
| top-level / `xyz/blanchot/vectorx/config/VectorXFzzyConfig.java` | `` |  | toSnapshot |
| top-level / `xyz/blanchot/vectorx/diag/Diagnostics.java` | `` |  | oneLineSummary, fullReport, appendKernelLine |
| top-level / `xyz/blanchot/vectorx/diag/VectorXLog.java` | `` |  | noop, info, warn, console, info, warn |
| top-level / `xyz/blanchot/vectorx/dispatch/CarverSkipDispatcher.java` | `` |  | globalDisableReason, tryLoadVectorBackend, backend, configKey, isVector, disableReason |
| top-level / `xyz/blanchot/vectorx/dispatch/ClampDispatcher.java` | `` |  | globalDisableReason, tryLoadVectorBackend, backend, configKey, isVector, disableReason |
| top-level / `xyz/blanchot/vectorx/dispatch/DensityMapDispatcher.java` | `` |  | globalDisableReason, tryLoadVectorBackend, backend, configKey, isVector, disableReason |
| top-level / `xyz/blanchot/vectorx/dispatch/KernelDispatcher.java` | `` |  |  |
| top-level / `xyz/blanchot/vectorx/dispatch/MinMaxDispatcher.java` | `` |  | globalDisableReason, tryLoadVectorBackend, backend, configKey, isVector, disableReason |
| top-level / `xyz/blanchot/vectorx/dispatch/PackedBitsDispatcher.java` | `` |  | globalDisableReason, tryLoadVectorBackend, backend, configKey, isVector, disableReason |
| top-level / `xyz/blanchot/vectorx/dispatch/SelectDispatcher.java` | `` |  | globalDisableReason, tryLoadVectorBackend, backend, configKey, isVector, disableReason |
| top-level / `xyz/blanchot/vectorx/dispatch/VectorModuleProbe.java` | `` |  | isModuleInBootLayer, canResolveProbeClass |
| top-level / `xyz/blanchot/vectorx/kernel/CarverSkipKernels.java` | `` |  |  |
| top-level / `xyz/blanchot/vectorx/kernel/ClampKernels.java` | `` |  |  |
| top-level / `xyz/blanchot/vectorx/kernel/DensityBinaryKernels.java` | `` |  |  |
| top-level / `xyz/blanchot/vectorx/kernel/DensityBinaryOp.java` | `` |  |  |
| top-level / `xyz/blanchot/vectorx/kernel/DensityMapKernels.java` | `` |  |  |
| top-level / `xyz/blanchot/vectorx/kernel/DensityMapOp.java` | `` |  |  |
| top-level / `xyz/blanchot/vectorx/kernel/DensitySelectKernels.java` | `` |  |  |
| top-level / `xyz/blanchot/vectorx/kernel/PackedBitsKernels.java` | `` |  |  |
| top-level / `xyz/blanchot/vectorx/kernel/scalar/ScalarCarverSkipKernels.java` | `` |  | canyonSkipMask, describe |
| top-level / `xyz/blanchot/vectorx/kernel/scalar/ScalarClampKernels.java` | `` |  | transform, clampInPlace, describe |
| top-level / `xyz/blanchot/vectorx/kernel/scalar/ScalarDensityBinaryKernels.java` | `` |  | combine, combineConst, applyBuffer, applyConst, describe |
| top-level / `xyz/blanchot/vectorx/kernel/scalar/ScalarDensityMapKernels.java` | `` |  | leakyReLU, clamp, squeeze, transform, apply, leakyReLU, describe |
| top-level / `xyz/blanchot/vectorx/kernel/scalar/ScalarDensitySelectKernels.java` | `` |  | mthLerp, lerpElement, chooseConst, lerp, rangeChoiceConst, rangeChoice, describe |
| top-level / `xyz/blanchot/vectorx/kernel/scalar/ScalarPackedBitsKernels.java` | `` |  | unpack, pack, describe |
| top-level / `xyz/blanchot/vectorx/kernel/SelfDescribing.java` | `` |  |  |
| top-level / `xyz/blanchot/vectorx/kernel/simd/SimdCarverSkipKernels.java` | `` |  | laneOffsets, canyonSkipMask, describe |
| top-level / `xyz/blanchot/vectorx/kernel/simd/SimdClampKernels.java` | `` |  | clampInPlace, describe |
| top-level / `xyz/blanchot/vectorx/kernel/simd/SimdDensityBinaryKernels.java` | `` |  | combine, combineConst, applyBuffer, applyConst, describe |
| top-level / `xyz/blanchot/vectorx/kernel/simd/SimdDensityMapKernels.java` | `` |  | leakyReLU, squeeze, transform, apply, leakyReLU, describe |
| top-level / `xyz/blanchot/vectorx/kernel/simd/SimdDensitySelectKernels.java` | `` |  | lerp, rangeChoiceConst, rangeChoice, describe |
| top-level / `xyz/blanchot/vectorx/kernel/simd/SimdPackedBitsKernels.java` | `` |  | buildShiftBases4, ceilDiv, buildOddShiftBases, unpack, pack, pack4, unpack5, unpack6, unpack7, unpack15, unpack4, unpack8, unpack16, unpack32, describe |
| top-level / `xyz/blanchot/vectorx/mixin/BinaryFunctionMinMaxMixin.java` | `targets={"net.minecraft.world.level.levelgen.densityfunction.op.BinaryFunction$MinSampler", "net.minecraft.world.level.levelgen.densityfunction.op.BinaryFunction$MaxSampler", "net.minecraft.world.level.levelgen.densityfunction.op.BinaryFunction$ConstMinSampler", "net.minecraft.world.level.levelgen.densityfunction.op.BinaryFunction$ConstMaxSampler"})` | Inject:1 | vectorx$twoBuffer, vectorx$values, vectorx$sampleVolume |
| top-level / `xyz/blanchot/vectorx/mixin/CanyonWorldCarverMixin.java` | `value={CanyonWorldCarver.class})` | Redirect:1 | vectorx$vectorizedCarveEllipsoid, vectorx$carveEllipsoid |
| top-level / `xyz/blanchot/vectorx/mixin/ClampFunctionSamplerMixin.java` | `targets={"net.minecraft.world.level.levelgen.densityfunction.op.ClampFunction$Sampler"})` | Inject:1 | vectorx$sampleVolume |
| top-level / `xyz/blanchot/vectorx/mixin/DensityBufferAccessor.java` | `value={DensityBuffer.class})` | Accessor:1 |  |
| top-level / `xyz/blanchot/vectorx/mixin/LerpFunctionSamplerMixin.java` | `targets={"net.minecraft.world.level.levelgen.densityfunction.op.LerpFunction$Sampler"})` | Inject:1 | vectorx$values, vectorx$sampleVolume |
| top-level / `xyz/blanchot/vectorx/mixin/PalettedContainerMixin.java` | `value={PalettedContainer.class})` | Redirect:2 | vectorx$redirectUnpack, vectorx$vectorizedConstruct, vectorx$redirectPack |
| top-level / `xyz/blanchot/vectorx/mixin/RangeChoiceFunctionConstSamplerMixin.java` | `targets={"net.minecraft.world.level.levelgen.densityfunction.op.RangeChoiceFunction$ConstSampler"})` | Inject:1 | vectorx$sampleVolume |
| top-level / `xyz/blanchot/vectorx/mixin/RangeChoiceFunctionSamplerMixin.java` | `targets={"net.minecraft.world.level.levelgen.densityfunction.op.RangeChoiceFunction$Sampler"})` | Inject:1 | vectorx$values, vectorx$sampleVolume |
| top-level / `xyz/blanchot/vectorx/mixin/SimpleBitStorageMixin.java` | `value={SimpleBitStorage.class})` | Inject:2 | vectorx$unpack, vectorx$getAll |
| top-level / `xyz/blanchot/vectorx/mixin/UnaryFunctionSamplerMixin.java` | `targets={"net.minecraft.world.level.levelgen.densityfunction.op.UnaryFunction$SqueezeSampler", "net.minecraft.world.level.levelgen.densityfunction.op.UnaryFunction$LeakyReLUSampler"})` | Inject:1 | vectorx$values, vectorx$sampleVolume |
| top-level / `xyz/blanchot/vectorx/selftest/CarverSkipSelfTest.java` | `` |  | run, checkRandom, checkBoundary, compare, Result |
| top-level / `xyz/blanchot/vectorx/selftest/ClampSelfTest.java` | `` |  | run, interestingValues, check, bitwiseEquals, Result |
| top-level / `xyz/blanchot/vectorx/selftest/DensityBinarySelfTest.java` | `` |  | run, interestingValues, source, checkBuffer, checkConst, compare, bitwiseEquals, Result |
| top-level / `xyz/blanchot/vectorx/selftest/DensityMapSelfTest.java` | `` |  | run, interestingValues, source, check, checkLeakyReLU, compare, bitwiseEquals, Result |
| top-level / `xyz/blanchot/vectorx/selftest/DensitySelectSelfTest.java` | `` |  | run, alphas, operands, withCanaryTail, checkLerp, checkRangeChoiceConst, checkRangeChoice, compare, bitwiseEquals, Result |
| top-level / `xyz/blanchot/vectorx/selftest/PackedBitsSelfTest.java` | `` |  | run, check, checkPack, checkPattern, maskTailBits, compare, Result |
| top-level / `xyz/blanchot/vectorx/Slf4jLog.java` | `` |  | info, warn |
| top-level / `xyz/blanchot/vectorx/VectorX.java` | `` |  | densityMap, clamp, packedBits, carverSkip, minMax, select, onInitialize |
| top-level / `xyz/blanchot/vectorx/VectorXConfig.java` | `` |  | defaults, of, withBackendForcedScalar, withKernelMode, backendForcedScalar, selfTestEnabled, diagnosticsEnabled, modeFor, configValue |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
