# Gnetum

Review status: **Evidence inventory; behavioral review pending**

Project: [Gnetum](https://modrinth.com/mod/gnetum)
Selected artifact version: `4.6.3+26.3-fabric`
Published implementation source: https://github.com/decce6/Gnetum
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Distribute HUD updates over multiple frames to improve performance

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `d6237dced5a4a92a295872d3077ebc786d394471`
- `sha512`: `8c26bfc3bdb1d1a46106849a3770f2c028ad415acabf49db3ae37f1e5b21313aaef03c51d46215a80a6706cffc5409a2963e6429b57f3bfbb689ce3181c10a67`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 64
Reconstructed Java files: 61

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "me.decce.gnetum.platform.fabric.FabricEntrypoint"
  ],
  "sodium:config_api_user": [
    "me.decce.gnetum.compat.sodium.SodiumEntrypoint"
  ]
}
```

**depends**

```json
{
  "minecraft": ">=26.3",
  "fabricloader": ">=0.16.0",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/decce/gnetum/CachedElement.java` | `` |  | next, begin, end, shouldRender, isUncached |
| top-level / `me/decce/gnetum/compat/CompatHelper.java` | `` |  |  |
| top-level / `me/decce/gnetum/compat/iris/IrisCompat.java` | `` |  | isRenderingLevelAvailable, runOutsideLevel |
| top-level / `me/decce/gnetum/compat/jade/JadeCompat.java` | `` |  |  |
| top-level / `me/decce/gnetum/compat/legacy_fapi/ArrayBackedEventAccessor.java` | `` |  |  |
| top-level / `me/decce/gnetum/compat/sodium/SodiumCompat.java` | `` |  | isVignetteEnabled |
| top-level / `me/decce/gnetum/compat/sodium/SodiumEntrypoint.java` | `` |  | registerConfigLate, addElements, elementTooltip, consume, supply |
| top-level / `me/decce/gnetum/compat/xaerominimap/XaeroMinimapCompat.java` | `` |  | update, tryRenderWaypoint, runSafely |
| top-level / `me/decce/gnetum/Constants.java` | `` |  |  |
| top-level / `me/decce/gnetum/Distributor.java` | `` |  | update, resolve, resolve |
| top-level / `me/decce/gnetum/FpsCounter.java` | `` |  | reset, tick, getFps, belowMax |
| top-level / `me/decce/gnetum/FramebufferBlitter.java` | `` |  | blit, buildVertices, pipeline, textureSetup, scissorArea, bounds |
| top-level / `me/decce/gnetum/Framebuffers.java` | `` |  | blit, fixMatrix, resize, swapFramebuffers, dropCurrentFrame, bind, unbind, clear, markForCatchUp, needsCatchUp, back |
| top-level / `me/decce/gnetum/FramebufferTracker.java` | `` |  | getCurrentlyBoundFbo, setCurrentlyBoundFbo |
| top-level / `me/decce/gnetum/Gnetum.java` | `` |  | init, nextPass, finishAllPasses, checkForPoseCatchUp, getFpsString, isCurrentElementForceCached, disableCachingForCurrentElement, disableCachingForElement, getElement, getElement, getUnknownElement, shouldRender, isCurrentElementUncached, time, framebuffers, platform, createPlatformInstance, reset |
| top-level / `me/decce/gnetum/GnetumConfig.java` | `` |  | isEnabled, createDefault, load, validate, clamp, reload, reset, save, getMaxFps, getRawMaxFps, setMaxFps, getNumberOfPasses, setNumberOfPasses |
| top-level / `me/decce/gnetum/HudDeltaTracker.java` | `` |  | update, reset, store, disable, isReady, getRealtimeDeltaTicks, getGameTimeDeltaTicks |
| top-level / `me/decce/gnetum/mixins/compat/bossbar/BossHealthOverlayMixin.java` | `value={BossHealthOverlay.class})` | Inject:3 | gnetum$render$0, gnetum$render$1, gnetum$drawBar |
| top-level / `me/decce/gnetum/mixins/compat/effects/GuiMixin.java` | `value={Hud.class})` | Inject:2 | gnetum$renderEffects$0, gnetum$renderEffects$1 |
| top-level / `me/decce/gnetum/mixins/compat/jade/ClientProxyMixin.java` | `targets={"snownee.jade.util.ClientProxy"}, remap=false)` | Redirect:1 | getBossBarRect |
| top-level / `me/decce/gnetum/mixins/compat/journeymap/HudOverlayHandlerMixin.java` | `targets={}, remap=false)` |  |  |
| top-level / `me/decce/gnetum/mixins/compat/sodium/SodiumOptionsGUIMixin.java` | `targets={})` |  |  |
| top-level / `me/decce/gnetum/mixins/compat/xaerominimap/ClientEventsMixin.java` | `targets={"xaero.common.events.ClientEvents"}, remap=false)` | Inject:1 | gnetum$beforeIngameGuiRender |
| top-level / `me/decce/gnetum/mixins/compat/xaerominimap/XaeroMinimapCoreMixin.java` | `targets={"xaero.common.core.XaeroMinimapCore"}, remap=false)` | Inject:1 | gnetum$beforeIngameGuiRender |
| top-level / `me/decce/gnetum/mixins/DebugEntryFpsMixin.java` | `value={DebugEntryFps.class})` | Inject:1 | gnetum$displayHudFps |
| top-level / `me/decce/gnetum/mixins/DeltaTrackerMixin.java` | `value={DeltaTracker.Timer.class})` | ModifyReturnValue:2 | gnetum$getRealtimeDeltaTicks, gnetum$getGameTimeDeltaTicks |
| top-level / `me/decce/gnetum/mixins/fabric/GuiMixin.java` | `value={Hud.class})` | WrapOperation:1 | gnetum$wrapInfoBar |
| top-level / `me/decce/gnetum/mixins/fabric/HudElementRegistryImplAccessor.java` | `value={HudElementRegistryImpl.class}, remap=false)` | Accessor:3 | getVanillaElementIds, getFirst, getLast |
| top-level / `me/decce/gnetum/mixins/fabric/HudRenderCallbackMixin.java` | `targets={})` |  |  |
| top-level / `me/decce/gnetum/mixins/fabric/RootLayerMixin.java` | `value={HudElementRegistryImpl.RootLayer.class}, remap=false)` | WrapMethod:1 | gnetum$wrapRender |
| top-level / `me/decce/gnetum/mixins/GameRendererAccessor.java` | `value={GameRenderer.class})` | Accessor:4 |  |
| top-level / `me/decce/gnetum/mixins/GameRendererMixin.java` | `value={GameRenderer.class})` | Inject:2, WrapMethod:1 | gnetum$updateDeltaTrackerAndPoseCatchup, gnetum$updateScreenCatchup, gnetum$checkForScreenCatchUp, gnetum$wrapRenderItemInHand |
| top-level / `me/decce/gnetum/mixins/GlStateManagerMixin.java` | `targets={})` |  |  |
| top-level / `me/decce/gnetum/mixins/GpuBufferPoolMixin.java` | `targets={"net.minecraft.client.renderer.StagedVertexBuffer$GpuBufferPool"})` | ModifyExpressionValue:1 | gnetum$doNotRecycleBufferWhenFlushing |
| top-level / `me/decce/gnetum/mixins/Gui_Graphics_Accessor.java` | `value={GuiGraphicsExtractor.class})` | Accessor:1, Invoker:1 |  |
| top-level / `me/decce/gnetum/mixins/GuiAccessor.java` | `value={Gui.class})` |  |  |
| top-level / `me/decce/gnetum/mixins/GuiMixin.java` | `value={Gui.class})` | WrapOperation:1 | gnetum$wrapRenderDebugOverlay |
| top-level / `me/decce/gnetum/mixins/GuiRendererAccessor.java` | `value={GuiRenderer.class})` | Accessor:2 |  |
| top-level / `me/decce/gnetum/mixins/GuiRendererScissorMixin.java` | `value={GuiRenderer.class})` | Inject:1 | gnetum$scissorInGuiSpace |
| top-level / `me/decce/gnetum/mixins/GuiRenderStateMixin.java` | `value={GuiRenderState.class})` | Inject:4 | gnetum$submit, gnetum$addText, gnetum$submitPIP, gnetum$addItem, gnetum$addGuiElement, gnetum$handleBlend, gnetum$submitForUncached, gnetum$isBlendIncompatible, gnetum$isUsingDestColor |
| top-level / `me/decce/gnetum/mixins/HudMixin.java` | `value={Hud.class}, priority=5000)` | WrapMethod:1, Inject:2 | gnetum$wrapHudRender, gnetum$render$tail, gnetum$doNotDeferSubtitles |
| top-level / `me/decce/gnetum/mixins/LayeredDrawAccessor.java` | `targets={})` |  |  |
| top-level / `me/decce/gnetum/mixins/LegacyScissorMixin.java` | `targets={})` |  |  |
| top-level / `me/decce/gnetum/mixins/MappableRingBufferMixin.java` | `value={MappableRingBuffer.class}, priority=2000)` | ModifyExpressionValue:2 | gnetum$increaseBufferSize, gnetum$rotate$increaseBufferSize |
| top-level / `me/decce/gnetum/mixins/MinecraftAccessor.java` | `value={Minecraft.class})` | Accessor:1 |  |
| top-level / `me/decce/gnetum/mixins/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:2 | gnetum$finishInitialization, gnetum$setLevel |
| top-level / `me/decce/gnetum/mixins/RenderPipelineAccessor.java` | `value={RenderPipeline.class})` | Accessor:2 |  |
| top-level / `me/decce/gnetum/platform/ElementGatherer.java` | `` |  | gather |
| top-level / `me/decce/gnetum/platform/fabric/ElementGathererFabricImpl.java` | `` |  | gatherImpl, gatherCompatPre, gather, gatherLegacy |
| top-level / `me/decce/gnetum/platform/fabric/FabricEntrypoint.java` | `` |  | onInitializeClient |
| top-level / `me/decce/gnetum/platform/fabric/FabricPlatform.java` | `` |  | determineLocation, isModLoaded, getModName, getModId, elementGatherer |
| top-level / `me/decce/gnetum/platform/Platform.java` | `` |  |  |
| top-level / `me/decce/gnetum/time/Blaze3DTimeSource.java` | `` |  | get, nanos |
| top-level / `me/decce/gnetum/time/TimeSource.java` | `` |  |  |
| top-level / `me/decce/gnetum/util/AnyBoolean.java` | `` |  |  |
| top-level / `me/decce/gnetum/util/AnyBooleanValue.java` | `` |  | text |
| top-level / `me/decce/gnetum/util/Beautifier.java` | `` |  | beautify, toUpper |
| top-level / `me/decce/gnetum/util/TriStateBoolean.java` | `` |  | get, next, text, effectiveText, tooltip, tooltip |
| top-level / `me/decce/gnetum/util/TwoStateBoolean.java` | `` |  | get, next, text |
| top-level / `me/decce/gnetum/VersionCompatUtil.java` | `` |  | profilerPush, profilerPop, profilerPopPush, stringValueOf, flush, isHudHidden, isInScreen, i18nExists, setMainRenderTarget, getRawMainRenderTarget |
| top-level / `me/decce/gnetum/versioned/StatefulHudHandler.java` | `` |  | submitLater, dropDeferredSubmission, performDeferredSubmission |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
