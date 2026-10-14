# Mercurizer

Review status: **Evidence inventory; behavioral review pending**

Project: [Mercurizer](https://modrinth.com/mod/mercurizer)
Selected artifact version: `0.9.2+mc26.3-1.1`
Published implementation source: https://github.com/ModderZellior/Mecurizer
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Better performance for low-end PCs, potato PCs. Possibly on mobile, and also on some mid- or high-end PCs

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `e296f2aaac93d38be3bbe579eabdaeb6bd30d5e9`
- `sha512`: `089d1bef03f8844c3909e508dca314066117513be86cec664f69ee65a67ff5c83c81f8a0da041b5a1659ff3a932f8bbb4e201e458e0affbf6db1a3575b8730f8`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 33
Reconstructed Java files: 29

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "net.caffeinemc.mods.sodium.fabric.MercurizerFabricMod"
  ],
  "sodium:config": [
    "net.caffeinemc.mods.sodium.fabric.MercurizerConfigEntryPoint"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16.0",
  "sodium": "0.9.2+mc26.3"
}
```

**breaks**

```json
{
  "embeddium": "*",
  "optifabric": "*",
  "canvas": "*",
  "vulkanmod": "*",
  "optimalaim": "<2.0.0",
  "sodium-blendingregistry": "*",
  "ocrenderfix_sodium": "*",
  "betterfpsdist": "<=1.21-4.5",
  "bobby": "<5.2.4",
  "chunksfadein": "<2.0.2-1.21.2",
  "cull-less-leaves": "<=1.3.0",
  "cullleaves": "<=3.4.0-fabric",
  "custom_hud": "<3.4.2",
  "farsight": "<=1.21-4.3",
  "iceberg": "<1.2.7",
  "iris": "<=1.10.8",
  "movingelevators": "<=1.4.7",
  "notenoughcrashes": "<4.4.8",
  "noxesium": "<2.3.3",
  "reeses-sodium-options": "<2.0.2",
  "fabric-api": "<0.145.1",
  "sodium-extra": "<0.8.0",
  "audio_engine_tweaks": "<1.2.12",
  "sspb": "<6.0.0",
  "moreculling": "<1.6.0-beta.2",
  "simply-no-shading": "<7.6.2",
  "betterend": "<=21.0.11",
  "enchanteds_sodium_options": "<1.0.1"
}
```

**accessWidener**

```json
"mercurizer-fabric.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/caffeinemc/mods/sodium/client/checks/MercurizerResourcePackMetadata.java` | `` |  | MercurizerResourcePackMetadata |
| top-level / `net/caffeinemc/mods/sodium/client/MercurizerBenchmark.java` | `` |  | run, runCpuOnly, runFull, runCpuBenchmark, processCpuData, bandwidthFromSamples, fillBuffer |
| top-level / `net/caffeinemc/mods/sodium/client/MercurizerBenchmarkController.java` | `` |  | shouldShowBenchmarkScreen, markDone, resetForRebenchmark, onBenchmarkComplete |
| top-level / `net/caffeinemc/mods/sodium/client/MercurizerBenchmarkResult.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/sodium/client/MercurizerBenchmarkScreen.java` | `` |  | extractBackground, extractRenderState, measureUpload, freeGlResources, buildSizeSet, detectLargeBufferSize, sizeLabel, sizeProgress, startCpuThread, startVulkanThread, handleBenchmarkDone, computeCandidate, acceptResult, resetForRerun, onClose, shouldCloseOnEsc, isPlateaued, draw, currentCov, toLongArray, bwFromNs, processCpu, fillBuf |
| top-level / `net/caffeinemc/mods/sodium/client/MercurizerBenchmarkStore.java` | `` |  | setActiveRenderer, needsBenchmark, saveWithHistory, updateLatestRefined, load, loadLatest, loadHistory, loadGameStartCount, incrementGameStartCount, resetStartupSequence, loadWrapper, writeWrapper, computeWeightedAverage |
| top-level / `net/caffeinemc/mods/sodium/client/MercurizerCapabilities.java` | `` |  | getCached, clearCache, isIntegratedGpu, getOsPlatform, probeAndCache, probe, getExtensions, safeGetInt, glVersionAtLeast |
| top-level / `net/caffeinemc/mods/sodium/client/MercurizerConfig.java` | `` |  | get, update, hasMeasurementOverrides, withMeasurementOverrides, isEnabled, file, load, save, isEmpty |
| top-level / `net/caffeinemc/mods/sodium/client/MercurizerConfigIcon.java` | `` |  | loadContents |
| top-level / `net/caffeinemc/mods/sodium/client/MercurizerConfigScreen.java` | `` |  | init, addToggle, extractBackground, extractRenderState, onClose, current, matchesBenchmark, updateMessage, applyValue |
| top-level / `net/caffeinemc/mods/sodium/client/MercurizerFrameTracker.java` | `` |  | onFrameStart, getUploadBudgetNs, getConfiguredBudgetNs, isRecovering, getUploadFraction, isStable, onUploadComplete, getP95FrameTimeNs, getRecentMeanFrameTimeNs, configure, resetRefinementWindow |
| top-level / `net/caffeinemc/mods/sodium/client/MercurizerIGpuWarningScreen.java` | `` |  | shouldShow, shouldShow, isNoDgpuFlagged, writeNoDgpuFlag, init, extractBackground, extractRenderState, onClose |
| top-level / `net/caffeinemc/mods/sodium/client/MercurizerInfoScreen.java` | `` |  | init, extractBackground, extractRenderState, buildLines, configured, onClose |
| top-level / `net/caffeinemc/mods/sodium/client/MercurizerRuntimePolicy.java` | `` |  | computeSafeStagingPath, preferSafeStagingPath, isSafeStagingPathDetected, getEffectiveCpuRenderAheadLimit, shouldUseNoErrorContext, getEffectiveChunkWorkerCount, getDefaultChunkWorkerCount, shouldAnimateVisibleTexturesThisFrame |
| top-level / `net/caffeinemc/mods/sodium/client/MercurizerTuning.java` | `` |  | setLatestRaw, getLatestRaw, getLastResult, getBaseUploadFraction, getBaseMinUploadBudgetNs, getTextureAnimThresholdNs, getUploadFraction, getMinUploadBudgetNs, getBenchmarkUploadFraction, getBenchmarkMinUploadBudgetNs, getBenchmarkTextureAnimThresholdNs, getAppliedResult, reapply, apply, apply, checkRefinement, gpuMultiplier |
| top-level / `net/caffeinemc/mods/sodium/client/MercurizerVulkanBenchmark.java` | `` |  | run, doRun, setupAndRun, findTransferQueue, runBenchmark, measure, adaptiveSample, copy, allocBuf, pickMemoryType, freeBuf, fillStaging, bw |
| top-level / `net/caffeinemc/mods/sodium/client/MercurizerVulkanDeviceInfo.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/sodium/client/MercurizerVulkanProbe.java` | `` |  | probe, doProbe, pickBestDevice, readDeviceInfo |
| top-level / `net/caffeinemc/mods/sodium/fabric/MercurizerConfigEntryPoint.java` | `` |  | registerConfigLate, addLabel |
| top-level / `net/caffeinemc/mods/sodium/fabric/MercurizerFabricMod.java` | `` |  | onInitializeClient |
| top-level / `net/caffeinemc/mods/sodium/mixin/addon/ChunkBuilderMixin.java` | `value={ChunkBuilder.class})` | WrapOperation:1 | wrapGetOptimalThreadCount |
| top-level / `net/caffeinemc/mods/sodium/mixin/addon/MercurizerCameraMixin.java` | `value={Camera.class})` | Inject:1 | guardNullLevel |
| top-level / `net/caffeinemc/mods/sodium/mixin/addon/MercurizerPauseScreenMixin.java` | `value={PauseScreen.class})` | Inject:1 | addMercurizerButton |
| top-level / `net/caffeinemc/mods/sodium/mixin/addon/MercurizerTitleScreenMixin.java` | `value={TitleScreen.class})` | Inject:2 | checkScreens, addMercurizerButton |
| top-level / `net/caffeinemc/mods/sodium/mixin/addon/RenderSectionManagerMixin.java` | `value={RenderSectionManager.class})` | Inject:3, ModifyConstant:2 | recordFrameTime, recordUploadComplete, limitTextureAnimation, modifyUploadFraction, modifyMinUploadBudget |
| top-level / `net/caffeinemc/mods/sodium/mixin/addon/ResourcePackScannerMixin.java` | `targets={"net.caffeinemc.mods.sodium.client.checks.ResourcePackScanner"})` | Inject:1 | addMercurizerIgnoredShaders |
| top-level / `net/caffeinemc/mods/sodium/mixin/addon/SodiumConfigBuilderMixin.java` | `value={SodiumConfigBuilder.class})` | Inject:1 | registerMercurizerIcon |
| top-level / `net/caffeinemc/mods/sodium/mixin/addon/SodiumDebugEntryMixin.java` | `value={SodiumDebugEntry.class})` | WrapOperation:1 | addMercurizerDebugInfo |
| top-level / `net/caffeinemc/mods/sodium/mixin/MercurizerMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
