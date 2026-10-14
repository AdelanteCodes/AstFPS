# Rendersnap

Review status: **Evidence inventory; behavioral review pending**

Project: [Rendersnap](https://modrinth.com/mod/rendersnap)
Selected artifact version: `1.3.2`
Published implementation source: https://github.com/Star-endMC/Rendersnap
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A Minecraft Mod that improves performance by using aggressive culling techniques.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `3d8ce9cbaa47b1cadb6b48d5cd9853083c9b6a8fc69b32a10e6ffac4b01c3a3bd93b468c42484c1b8e038a95c144a5f518e832c3bf292766f12db7496888be8f`
- `sha1`: `fab5f7db63f1095eb2bbdb3a0e8b212364096acf`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 38
Reconstructed Java files: 31

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "rendersnap.star.end.client.RendersnapClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.6",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `rendersnap/star/end/client/cfg/Opts.java` | `` |  | save, load, put, configPath, bool, intV |
| top-level / `rendersnap/star/end/client/ChunkUpdatePacing.java` | `` |  | enable, disable, sync |
| top-level / `rendersnap/star/end/client/ChunkWorkerPool.java` | `` |  | executor, close, activeWorkers, vanillaExecutor |
| top-level / `rendersnap/star/end/client/Compatibility.java` | `` |  | initialize, allowsVanillaHooks, rendererStatus, disableConflictingOptions |
| top-level / `rendersnap/star/end/client/FrameMetrics.java` | `` |  | record, medianNs, percentileNs |
| top-level / `rendersnap/star/end/client/hud/FpsHud.java` | `` |  | draw, draw0, col |
| top-level / `rendersnap/star/end/client/McCompat.java` | `` |  | toastManager, setScreen, hasScreen, monitorIndexOfMode, monitorModeCount, monitorMode |
| top-level / `rendersnap/star/end/client/menu/SnapPage.java` | `` |  | addOptions, optimization, effects, behindCam, chunkWorkers, zoomEase, bool, refreshChunks, restartToast, tip |
| top-level / `rendersnap/star/end/client/menu/VideoPage.java` | `` |  | addOptions, tick, onClose, removed, mouseScrolled, fullscreen, pageButton, open |
| top-level / `rendersnap/star/end/client/render/Cuts.java` | `` |  | setChunkShadeTrim, setFarLayerTrim, setEntityCulling, setFogOcclusion, setBehindCamMode, setHideWeather, shouldHideWeather, warmup, stopWarmup, beginRendererTransition, clearWorldState, tickWarmup, updateCamera, shouldCullEntity, shouldUseChunkAo, trimsFarLayers, shouldSkipSectionLayer, shouldSkipFarTranslucencyResort, appendDebug, warming, distanceSq, behind |
| top-level / `rendersnap/star/end/client/render/Fog.java` | `` |  | setOcclusionEnabled, readVanillaFog, isOccludingDistance |
| top-level / `rendersnap/star/end/client/render/gpu/Gpu.java` | `` |  | reportActiveAdapter, vendor, renderer, version, glString |
| top-level / `rendersnap/star/end/client/render/ShadowReuse.java` | `` |  | restore, capture, clear, appendDebug, Entry, matches |
| top-level / `rendersnap/star/end/client/render/zoom/Zoom.java` | `` |  | registerKeybind, setTransition, onClientTick, isZooming, modifyFov, handleScroll, transitionLabel, applyZoomControls, restoreControls, zoomFov, ease, ease, hasScreen |
| top-level / `rendersnap/star/end/client/RenderReport.java` | `` |  | registerKeybind, onClientTick, write, report, line |
| top-level / `rendersnap/star/end/client/RendersnapClient.java` | `` |  | onInitializeClient, hud, clientStart, ticks, readOptions |
| top-level / `rendersnap/star/end/client/WorldWarmup.java` | `` |  | tick, joined |
| top-level / `rendersnap/star/end/mixin/cam/FP.java` | `value={FogRenderer.class})` | Inject:1 | pullFog |
| top-level / `rendersnap/star/end/mixin/cam/PlrView.java` | `value={Camera.class})` | Inject:1 | zoomFov |
| top-level / `rendersnap/star/end/mixin/cam/VH.java` | `value={GameRenderer.class})` | Inject:1 | hideHand |
| top-level / `rendersnap/star/end/mixin/entity/MR.java` | `value={EntityRenderDispatcher.class})` | Inject:1 | skipHiddenMob |
| top-level / `rendersnap/star/end/mixin/entity/SSM.java` | `value={EntityRenderer.class})` | Inject:3 | rendersnap$captureEntity, rendersnap$reuseSameTickShadow, rendersnap$storeSameTickShadow |
| top-level / `rendersnap/star/end/mixin/scene/RB.java` | `value={WeatherEffectRenderer.class})` | Inject:1 | hideWeather |
| top-level / `rendersnap/star/end/mixin/ui/OB.java` | `value={OptionsScreen.class})` | Inject:1 | videoButton |
| top-level / `rendersnap/star/end/mixin/ui/Wheel.java` | `value={MouseHandler.class})` | Inject:1 | zoomWheel |
| top-level / `rendersnap/star/end/mixin/world/CG.java` | `value={LevelRenderer.class})` | Inject:2 | rendersnap$updateCamera, rendersnap$skipFarResort |
| top-level / `rendersnap/star/end/mixin/world/CS.java` | `value={ModelBlockRenderer.class})` | Redirect:1 | rendersnap$trimChunkAo |
| top-level / `rendersnap/star/end/mixin/world/CWLM.java` | `value={LevelRenderer.class})` | Redirect:1, Inject:1 | rendersnap$chunkWorkerExecutor, rendersnap$closeChunkWorkers |
| top-level / `rendersnap/star/end/mixin/world/GMSG.java` | `value={MultiPlayerGameMode.class})` | Inject:1 | rendersnap$skipTickWithoutPlayer |
| top-level / `rendersnap/star/end/mixin/world/IHSGM.java` | `targets={"net.minecraft.client.renderer.ItemInHandRenderer"})` | Inject:1 | rendersnap$skipTickWithoutPlayer |
| top-level / `rendersnap/star/end/Rendersnap.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
