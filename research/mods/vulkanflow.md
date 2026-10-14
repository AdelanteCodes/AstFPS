# VulkanFlow

Review status: **Evidence inventory; behavioral review pending**

Project: [VulkanFlow](https://modrinth.com/mod/vulkanflow)
Selected artifact version: `0.1.12-alpha`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

VulkanFlow brings bloom, shadows and shader like effects to Minecraft highly optimized for integrated GPUs and low end devicec. Achieve stable 60 FPS on hardware like Intel UHD 620, fully compatible with Sodium.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `d9ddc599b6b1ef047a4852a11809df06ff338b44`
- `sha512`: `29969ccb0db3ba393d438e289f234ea54d25940c5a09e46ca268b63eb0ff36bab7238174b33e4ffd221b832771a04816476f570326474f318bba765c981258ce`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 40
Reconstructed Java files: 38

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "dev.vulkanflow.VulkanFlow"
  ],
  "client": [
    "dev.vulkanflow.client.VulkanFlowClient"
  ],
  "sodium:config_api_user": [
    "dev.vulkanflow.client.integration.sodium.VulkanFlowSodiumConfig"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.0",
  "fabric-api": "*",
  "minecraft": ">=26.1"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/vulkanflow/client/command/VulkanFlowDebugCommand.java` | `` |  | register, toggle, syncBloomPipeline, toggleShadows, toggleDebugDepth |
| top-level / `dev/vulkanflow/client/integration/sodium/SodiumCompat.java` | `` |  | isLoaded, getVersion |
| top-level / `dev/vulkanflow/client/integration/sodium/SodiumWindCompat.java` | `` |  | registerIfNeeded |
| top-level / `dev/vulkanflow/client/integration/sodium/VulkanFlowSodiumConfig.java` | `` |  | registerConfigLate, t, id, refreshVisualPipelines |
| top-level / `dev/vulkanflow/client/keybind/VulkanFlowKeybinds.java` | `` |  | register, registerTickHandler |
| top-level / `dev/vulkanflow/client/mixin/BlockRenderDispatcherMixin.java` | `value={ModelBlockRenderer.class})` | ModifyVariable:1 | vulkanflow$wrapIfWaving |
| top-level / `dev/vulkanflow/client/mixin/GameRendererMixin.java` | `value={GameRenderer.class})` | Inject:4 | vulkanflow$onFramePrepare, vulkanflow$beforeRenderLevel, vulkanflow$afterRenderLevelPostProcess, vulkanflow$onRenderTail, getField |
| top-level / `dev/vulkanflow/client/mixin/LevelRendererMixin.java` | `value={LevelRenderer.class})` | Inject:2 | vulkanflow$beforeRenderLevel, vulkanflow$afterRenderLevel |
| top-level / `dev/vulkanflow/client/render/bloom/BloomPipeline.java` | `` |  | initialize, reload, render, loadChain, close |
| top-level / `dev/vulkanflow/client/render/chraberration/ChromaticAberrationPipeline.java` | `` |  | initialize, reload, render, tryLoad, close |
| top-level / `dev/vulkanflow/client/render/colorgrading/ColorGradingPipeline.java` | `` |  | initialize, reload, render, tryLoad, close |
| top-level / `dev/vulkanflow/client/render/filmgrain/FilmGrainPipeline.java` | `` |  | initialize, reload, render, tryLoad, close |
| top-level / `dev/vulkanflow/client/render/fxaa/FxaaPipeline.java` | `` |  | initialize, reload, render, tryLoad, close |
| top-level / `dev/vulkanflow/client/render/IRenderHook.java` | `` |  |  |
| top-level / `dev/vulkanflow/client/render/shadow/ShadowPostProcessor.java` | `` |  | setDebugDepthVisualization, isDebugDepthVisualization, apply, close, ensureInitialized, init, read, compile |
| top-level / `dev/vulkanflow/client/render/sharpen/SharpenPipeline.java` | `` |  | initialize, reload, render, tryLoad, close |
| top-level / `dev/vulkanflow/client/render/tonemapping/TonemappingPipeline.java` | `` |  | initialize, reload, render, tryLoad, close |
| top-level / `dev/vulkanflow/client/render/underwater/UnderwaterDistortionPipeline.java` | `` |  | initialize, reload, render, isPlayerUnderwater, tryLoad, close |
| top-level / `dev/vulkanflow/client/render/util/VulkanFlowMath.java` | `` |  | hash, clamp01 |
| top-level / `dev/vulkanflow/client/render/vignette/VignettePipeline.java` | `` |  | initialize, reload, render, tryLoad, close |
| top-level / `dev/vulkanflow/client/render/VulkanFlowRenderHook.java` | `` |  | initializeVisualCore, onBeforeRenderLevel, onFramePrepare, afterOpaqueTerrainPass, onFrameFinish, toggleDebugDepthVisualization, close, getBloomPipeline, getTonemappingPipeline, getVignettePipeline, getChrAberrationPipeline, getSharpenPipeline, getFilmGrainPipeline, getColorGradingPipeline, getUnderwaterPipeline, getFxaaPipeline, recordSceneFboId, applyShadowOverlay, buildProjectionFromViewport, captureCurrentDepth, tryGetDirectDepthTexture, ensureDepthCapture, destroyDepthCapture, getSunDirection, afternoonSun, getFieldObj, clearGlErrors |
| top-level / `dev/vulkanflow/client/render/wind/WavingBlockQuadOutput.java` | `` |  | put |
| top-level / `dev/vulkanflow/client/render/wind/WavingBlocks.java` | `` |  | isWaving |
| top-level / `dev/vulkanflow/client/render/wind/WavingVertexConsumer.java` | `` |  | addVertex, setColor, setColor, setUv, setUv1, setUv2, setUv3, setNormal, setLineWidth |
| top-level / `dev/vulkanflow/client/render/wind/WindRenderer.java` | `` |  | initialize, tick, isEnabled, getAccumulatedTime |
| top-level / `dev/vulkanflow/client/render/wind/WindUniformManager.java` | `` |  | computeStrength, computeDistance, ensureUbo, uploadToUbo, tryUploadOnCurrentProgram, uploadToAllKnownPrograms |
| top-level / `dev/vulkanflow/client/VulkanFlowClient.java` | `` |  | onInitializeClient |
| top-level / `dev/vulkanflow/config/BloomQuality.java` | `` |  | resourcePath |
| top-level / `dev/vulkanflow/config/ColorGradingPreset.java` | `` |  |  |
| top-level / `dev/vulkanflow/config/QualityPreset.java` | `` |  | applyTo |
| top-level / `dev/vulkanflow/config/ShadowDistanceLevel.java` | `` |  |  |
| top-level / `dev/vulkanflow/config/ShadowIntensityLevel.java` | `` |  |  |
| top-level / `dev/vulkanflow/config/ShadowQuality.java` | `` |  |  |
| top-level / `dev/vulkanflow/config/TonemappingMode.java` | `` |  |  |
| top-level / `dev/vulkanflow/config/VulkanFlowConfig.java` | `` |  | loadOrCreate, save |
| top-level / `dev/vulkanflow/config/WindDistanceLevel.java` | `` |  |  |
| top-level / `dev/vulkanflow/config/WindStrengthLevel.java` | `` |  |  |
| top-level / `dev/vulkanflow/VulkanFlow.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
