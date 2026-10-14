# !lag

Review status: **Evidence inventory; behavioral review pending**

Project: [!lag](https://modrinth.com/mod/lag)
Selected artifact version: `3.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Client-side Fabric optimization mod for Minecraft 1.21+–26.3 with integrated Video Settings controls, safe culling, particle limits, and an FPS HUD.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `79fe19efb16f9f56fb1d2b367bf8b3cb6352a3c106e73c9fd138e97adf70fce01c5d23ed15665c388bfb72cc2dfcdede24728915c3a8068e5fdaf3d7af11ed5f`
- `sha1`: `277158c0932f4a7c6c382a3b10008a4089c48f54`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 62
Reconstructed Java files: 46

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.ilag.client.ILagClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/ilag/client/config/ILagSettings.java` | `` |  | configPath, get, load, save, getParticleBudgetPerTick, setParticleBudgetPerTick, getVisibilityCacheInterval, getAsyncVisibilityWorkers, zoomMultiplier, setZoomStrengthPercent, clamp, clamp |
| top-level / `com/ilag/client/debug/MixinHookLog.java` | `` |  | once |
| top-level / `com/ilag/client/feature/AdaptiveRenderDistanceController.java` | `` |  | tick, resetBaseline |
| top-level / `com/ilag/client/feature/BackgroundFpsController.java` | `` |  | markInput, tick, currentCap, shouldApplyMenuFpsCap, shouldApplyMenuFpsCap, mergeCap |
| top-level / `com/ilag/client/feature/BenchmarkSession.java` | `` |  | isRunning, lastSummary, start, onFrame, finish |
| top-level / `com/ilag/client/feature/ChunkCompileBudget.java` | `` |  | onFrameStart, tryScheduleCompile, scheduledThisFrame, currentFrameId |
| top-level / `com/ilag/client/feature/CrashHelper.java` | `` |  | install, writeCrashHint |
| top-level / `com/ilag/client/feature/CullingExemptions.java` | `` |  | exemptBlockEntityFromDistanceCull, exemptEntityFromDistanceCull, isBossEntity, isLargeEntity, isLongRangeBlockEntityId |
| top-level / `com/ilag/client/feature/CullingRules.java` | `` |  | shouldCull, shouldCull |
| top-level / `com/ilag/client/feature/DistanceCullMath.java` | `` |  | beyondSquared, effectiveDistance, visibilityPhase, shouldRecomputeVisibility |
| top-level / `com/ilag/client/feature/EntityExtractThrottle.java` | `` |  | framesBetweenUpdates, shouldReuseCache |
| top-level / `com/ilag/client/feature/EntityRenderCache.java` | `` |  | onFrameStart, peek, store, Entry |
| top-level / `com/ilag/client/feature/EntitySubpixelCull.java` | `` |  | shouldHide |
| top-level / `com/ilag/client/feature/FogBufferCache.java` | `` |  | shouldSkipUpload, invalidate, fingerprint |
| top-level / `com/ilag/client/feature/FpsHudRenderer.java` | `` |  | render |
| top-level / `com/ilag/client/feature/FrameTimeTracker.java` | `` |  | onFrameStart, recordFrameNs, averageFps, percentileLowFps, reset, sampleCount |
| top-level / `com/ilag/client/feature/LightmapExtractCache.java` | `` |  | shouldSkipExtract, invalidate, fingerprint |
| top-level / `com/ilag/client/feature/MemoryOptimizer.java` | `` |  | tick |
| top-level / `com/ilag/client/feature/ModCompatibility.java` | `` |  | initialize, isSodiumPresent, isIrisPresent, terrainMeshOptimizationsAllowed |
| top-level / `com/ilag/client/feature/OptimizationDiagnostics.java` | `` |  | snapshot, status, OptimizationStatus |
| top-level / `com/ilag/client/feature/ParticleBudget.java` | `` |  | allow |
| top-level / `com/ilag/client/feature/ParticleCullDistance.java` | `` |  | beyondCullDistance |
| top-level / `com/ilag/client/feature/ParticleExtractCull.java` | `` |  | effectiveSpawnCullDistance |
| top-level / `com/ilag/client/feature/SectionCompilePolicy.java` | `` |  | shouldDeferDistantRecompile |
| top-level / `com/ilag/client/feature/ShaderCompat.java` | `` |  | aggressiveOptimizationsEnabled |
| top-level / `com/ilag/client/feature/VisibilityCache.java` | `` |  | entityCullCached, blockCullCached, pack |
| top-level / `com/ilag/client/feature/ZoomController.java` | `` |  | setZoomStrength, tick, isActive, apply, onMouseScroll |
| top-level / `com/ilag/client/ILagClient.java` | `` |  | onInitializeClient, setFullbright, isFullbrightEnabled, isZoomPressed, openScreen, currentScreen, getLastScreen, invokeScreenMethod, invokeNoArgMethod, readField |
| top-level / `com/ilag/client/mixin/BlockEntityRenderDispatcherMixin.java` | `value={BlockEntityRenderDispatcher.class}, remap=false)` | Inject:2 | notlag$distanceCull, notlag$skipExtract |
| top-level / `com/ilag/client/mixin/CameraZoomMixin.java` | `value={Camera.class}, remap=false)` | Inject:1 | notlag$applyZoom |
| top-level / `com/ilag/client/mixin/EntityRenderDispatcherMixin.java` | `value={EntityRenderDispatcher.class}, remap=false)` | Inject:2 | notlag$reuseExtract, notlag$storeExtract |
| top-level / `com/ilag/client/mixin/EntityRendererMixin.java` | `value={EntityRenderer.class}, remap=false)` | Inject:1 | notlag$distanceCull |
| top-level / `com/ilag/client/mixin/FogRendererMixin.java` | `value={FogRenderer.class}, remap=false)` | Inject:1 | notlag$skipFogUpload |
| top-level / `com/ilag/client/mixin/FramerateLimitTrackerMixin.java` | `value={FramerateLimitTracker.class}, remap=false)` | Inject:1 | notlag$backgroundFpsCaps |
| top-level / `com/ilag/client/mixin/GameRendererMixin.java` | `value={GameRenderer.class}, remap=false)` | Inject:2 | notlag$frameStart, notlag$frameEnd |
| top-level / `com/ilag/client/mixin/KeyboardHandlerMixin.java` | `value={KeyboardHandler.class}, remap=false)` | Inject:1 | notlag$markInput |
| top-level / `com/ilag/client/mixin/LevelExtractorMixin.java` | `value={LevelExtractor.class}, remap=false)` | Inject:1 | notlag$subpixelCull |
| top-level / `com/ilag/client/mixin/LightmapRenderStateExtractorMixin.java` | `value={LightmapRenderStateExtractor.class}, remap=false)` | Inject:2 | notlag$skipStableLightmap, notlag$fullbright |
| top-level / `com/ilag/client/mixin/LoadingOverlayMixin.java` | `value={LoadingOverlay.class}, remap=false)` | Inject:1 | notlag$drawSplash, drawStatusBars, drawLogo, drawV2, drawBackgroundMark, rect |
| top-level / `com/ilag/client/mixin/MouseHandlerInputMixin.java` | `value={MouseHandler.class}, remap=false)` | Inject:2 | notlag$markMove, notlag$markButton |
| top-level / `com/ilag/client/mixin/MouseScrollZoomMixin.java` | `value={MouseHandler.class}, remap=false)` | Inject:1 | notlag$zoomScroll |
| top-level / `com/ilag/client/mixin/ParticleEngineMixin.java` | `value={ParticleEngine.class})` | Inject:1 | notlag$limitParticles |
| top-level / `com/ilag/client/mixin/RenderSectionMixin.java` | `targets={"net.minecraft.client.renderer.chunk.SectionRenderDispatcher$RenderSection"}, remap=false)` | Inject:1 | notlag$deferDistantRecompile |
| top-level / `com/ilag/client/mixin/SectionRenderDispatcherMixin.java` | `value={SectionRenderDispatcher.class}, remap=false)` | Inject:1 | notlag$compileBudget |
| top-level / `com/ilag/client/mixin/WeatherEffectRendererMixin.java` | `value={WeatherEffectRenderer.class}, remap=false)` | Inject:4 | notlag$skipWeatherExtract, notlag$skipWeatherPrepare, notlag$skipWeatherRender, notlag$skipWeatherOit |
| top-level / `com/ilag/client/screen/ILag26Screen.java` | `` |  | init, layout, layoutFull, applyScroll, updateScrollMetrics, countVisibleEntries, visibleEntries, placeContentRows, repositionContentRows, removeWidgets, extractRenderState, mouseScrolled, onClose, buildEntries, applyZoomStrength, label, panel, field, control, drawScrollBar, extractWidgetRenderState, onClick, updateWidgetNarration, Entry, updateMessage, updateMessage, updateMessage, updateMessage, extractWidgetRenderState, updateMessage, applyValue, normalize, getMessage, onClick |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
