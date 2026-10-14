# GGTU

Review status: **Evidence inventory; behavioral review pending**

Project: [GGTU](https://modrinth.com/mod/ggtu)
Selected artifact version: `Neo-1.1.2+mc26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Your go-to choice for upscaling and frame generation with shaders! Boosts FPS even on low-end PCs.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `6d2ae7135a1cd4e68b80621f72a6833436ddd9825c5a7fe855ee7a0bc9b959ca290aff240c74f67a8cd09a1db2ee1b2fa16afcf0596e2253bd5f011f865669a8`
- `sha1`: `e6416e8d67dc35be9af5be4649ac00ab7a891f21`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 131
Reconstructed Java files: 100

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "com.maxim.resolutionscaler.FabricEntry"
  ],
  "client": [
    "com.maxim.resolutionscaler.FabricEntry"
  ],
  "modmenu": [
    "com.maxim.resolutionscaler.client.ModMenuApiImpl"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.0",
  "minecraft": "~26.3",
  "java": ">=21",
  "fabric-api": "*",
  "cloth-config": ">=26.3.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/maxim/resolutionscaler/client/Hotkeys.java` | `` |  | onUpscaleKey, onFrameGenKey, isSettling, onEndTick, committed, refuseAfterFailure, presetName, next, show |
| top-level / `com/maxim/resolutionscaler/client/ModMenuApiImpl.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/maxim/resolutionscaler/client/ResolutionScalerConfigScreen.java` | `` |  | create, label, addDescription, description |
| top-level / `com/maxim/resolutionscaler/ClientBoot.java` | `` |  | runAtEndOfTick, init, isFirstLaunch, onClientStarted, onEndTick, checkShaderWarning |
| top-level / `com/maxim/resolutionscaler/compat/DhCompat.java` | `` |  | isDhLoaded, syncDitherFade, apply, ensurePoller |
| top-level / `com/maxim/resolutionscaler/compat/DhLodCompat.java` | `` |  | onRender, read, capture, querySize, convention, projectionOnly, depthGlId, depthWidth, depthHeight, zeroToOne, reverseZ, mvp |
| top-level / `com/maxim/resolutionscaler/compat/DhSettings.java` | `` |  | DhSettings |
| top-level / `com/maxim/resolutionscaler/compat/DhWrapper.java` | `` |  | init, setValue, resolveEnum |
| top-level / `com/maxim/resolutionscaler/compat/HotkeyCompat.java` | `` |  | register, poll |
| top-level / `com/maxim/resolutionscaler/compat/IrisCompat.java` | `` |  | isIrisLoaded, isShaderPackInUse, getCurrentShaderPackName, getShaderpacksDirectory, reloadShaderpack, areShadowsBeingRendered |
| top-level / `com/maxim/resolutionscaler/compat/IrisDepthVersionFix.java` | `` |  | bump, resolve |
| top-level / `com/maxim/resolutionscaler/compat/IrisTerrainSamplers.java` | `` |  | init, field, gpuSamplers, irisGlIds, signature, entries |
| top-level / `com/maxim/resolutionscaler/compat/IrisWrapper.java` | `` |  | init, lookup |
| top-level / `com/maxim/resolutionscaler/compat/LodDepth.java` | `` |  | available, capture, name, depthGlId, depthWidth, depthHeight, depthFramebuffer, depthTranslucent, zeroToOne, reverseZ, mvp, worldDepthMap, depthLine, distanceAt, effectiveNear |
| top-level / `com/maxim/resolutionscaler/compat/PackMatrixProbe.java` | `` |  | resolve, probe, logScreenError, ratio |
| top-level / `com/maxim/resolutionscaler/compat/PackProjectionScan.java` | `` |  | dropsOffCenterProjection, scan, isShaderSource |
| top-level / `com/maxim/resolutionscaler/compat/RendererNotice.java` | `` |  | notifyPlayerIfNeeded |
| top-level / `com/maxim/resolutionscaler/compat/ShaderProfileSync.java` | `` |  | isCurrentPackSupported, flushNotice, packDisplayName, ensureAntiAliasingDisabled, aaOffValues, familyOf, suffixOf, enumOffValue, scanDefineValues, scanOptionDefaults, putDefault, sameOptionValue, scanGlsl, collectDefines, restoreAntiAliasing, syncToGpu, resolveProfile, findProfileKey, readShadersProperties |
| top-level / `com/maxim/resolutionscaler/compat/VersionCompat.java` | `` |  | isModLoaded, isReversedDepth, isZeroToOneDepth, configDir, isShaderModLoaded, colorMask, sendChat, rendererNoticeKey, isDebugOverlayShown, partialTick, setScreen, isHudHidden, mainTarget, isScreenOpen, setMainTarget, syncSkyRenderTarget, blitToScreen, canPresentMidFrame, swapBuffers, primaryDisplayMode, showActionBar, isFullscreenInBackground |
| top-level / `com/maxim/resolutionscaler/compat/VoxyCompat.java` | `` |  | isLoaded, init, capture, blockSampler, blockSamplerOwner, depthFramebuffer, depthTranslucent, captured, depthGlId, depthWidth, depthHeight, zeroToOne, reverseZ, mvp |
| top-level / `com/maxim/resolutionscaler/FabricEntry.java` | `` |  | onInitialize, onInitializeClient |
| top-level / `com/maxim/resolutionscaler/hardware/DisplayResolutionDetector.java` | `` |  | getRefreshRateHz, detectRefreshRate, isLowResolution, detect |
| top-level / `com/maxim/resolutionscaler/hardware/HardwareDetector.java` | `` |  | runOnFirstLaunch, applyNow, shaderProfileForGpu, gpuLabel, classify, isUnknown, cleanLabel, buildSortedKeywords, addAll, upscaleMode, KeywordEntry |
| top-level / `com/maxim/resolutionscaler/mixin/client/AbstractConfigScreenAccessor.java` | `value={AbstractConfigScreen.class})` | Accessor:1 |  |
| top-level / `com/maxim/resolutionscaler/mixin/client/ClothConfigScreenMixin.java` | `value={ClothConfigScreen.class})` | Inject:1 | resolutionScaler$addFooterWidgets, resolutionScaler$addHardwareWidgets, resolutionScaler$forceFirstInChildren |
| top-level / `com/maxim/resolutionscaler/mixin/client/DhRenderParamsMixin.java` | `targets={"com/seibel/distanthorizons/core/render/renderer/LodRenderer"}, remap=false)` | Inject:1 | resolutionScaler$params |
| top-level / `com/maxim/resolutionscaler/mixin/client/FrameGenMixin.java` | `value={Minecraft.class})` | Redirect:1 | resolutionScaler$present |
| top-level / `com/maxim/resolutionscaler/mixin/client/FrameLoopMixin.java` | `value={Minecraft.class})` | Inject:2 | resolutionScaler$frameStart, resolutionScaler$frameEnd |
| top-level / `com/maxim/resolutionscaler/mixin/client/FramerateLimiterMixin.java` | `value={FramerateLimiter.class})` | Inject:2 | resolutionScaler$beforeLimit, resolutionScaler$afterLimit |
| top-level / `com/maxim/resolutionscaler/mixin/client/FrameSwapMixin.java` | `value={Minecraft.class})` | Redirect:1 | resolutionScaler$skipRedundantSwap |
| top-level / `com/maxim/resolutionscaler/mixin/client/GameRendererMixin.java` | `value={GameRenderer.class})` | ModifyArg:2, Inject:3 | resolutionScaler$jitterProjection, resolutionScaler$captureViewRotation, resolutionScaler$beforeLevelRender, resolutionScaler$afterLevelRender, resolutionScaler$captureHandMask |
| top-level / `com/maxim/resolutionscaler/mixin/client/GlCommandEncoderMixin.java` | `targets={"com/mojang/renderpearl/backend/opengl/GlCommandEncoder"})` | Inject:1 | resolutionScaler$presentHeldFrame |
| top-level / `com/maxim/resolutionscaler/mixin/client/HandPoseMixin.java` | `value={FirstPersonHandsAndItemsRenderer.class})` | Inject:1 | resolutionScaler$captureHandPose |
| top-level / `com/maxim/resolutionscaler/mixin/client/LevelRendererAccessor.java` | `value={LevelRenderer.class})` | Accessor:2 |  |
| top-level / `com/maxim/resolutionscaler/mixin/client/LevelRenderViewMixin.java` | `value={LevelRenderer.class})` | Inject:1 | resolutionScaler$finalView |
| top-level / `com/maxim/resolutionscaler/mixin/client/MinecraftAccessor.java` | `value={GameRenderer.class})` | Accessor:2 |  |
| top-level / `com/maxim/resolutionscaler/mixin/client/OptionsScreenMixin.java` | `value={OptionsScreen.class})` | Inject:1 | resolutionScaler$addButton |
| top-level / `com/maxim/resolutionscaler/mixin/client/SamplerCacheAccessor.java` | `value={SamplerCache.class})` | Accessor:1 |  |
| top-level / `com/maxim/resolutionscaler/mixin/client/ScreenChildrenAccessor.java` | `value={Screen.class})` | Accessor:1 |  |
| top-level / `com/maxim/resolutionscaler/mixin/client/TickPresentMixin.java` | `value={Minecraft.class})` | Inject:4 | resolutionScaler$tickStart, resolutionScaler$afterTasks, resolutionScaler$afterClientTick, resolutionScaler$afterMouse |
| top-level / `com/maxim/resolutionscaler/mixin/client/VideoSettingsScreenMixin.java` | `value={VideoSettingsScreen.class})` | Inject:1 | resolutionScaler$addSettingsButton |
| top-level / `com/maxim/resolutionscaler/mixin/client/VignetteMixin.java` | `value={Hud.class})` | ModifyArg:1 | resolutionScaler$recordVignette |
| top-level / `com/maxim/resolutionscaler/mixin/client/VoxyLodDetailMixin.java` | `targets={"me/cortex/voxy/client/core/rendering/hierachical/HierarchicalOcclusionTraverser"}, remap=false)` | ModifyArg:1 | resolutionScaler$minScreenArea |
| top-level / `com/maxim/resolutionscaler/mixin/client/VoxyViewportMixin.java` | `targets={"me/cortex/voxy/client/core/VoxyRenderSystem"}, remap=false)` | ModifyVariable:2 | resolutionScaler$projection, resolutionScaler$modelView |
| top-level / `com/maxim/resolutionscaler/render/AsyncPresenter.java` | `` |  | isActive, ensureStarted, onCycleEndSwapped, submit, drain, tryRecover, where, probe, readProbes, overTwoOfThree, binBlocked, describe, fail, run, waitUntil, report |
| top-level / `com/maxim/resolutionscaler/render/ColorGradeParams.java` | `` |  | ColorGradeParams, simple |
| top-level / `com/maxim/resolutionscaler/render/ColorGrader.java` | `` |  | paramsFor |
| top-level / `com/maxim/resolutionscaler/render/CompareView.java` | `` |  | toggle, isEnabled, scalePercent |
| top-level / `com/maxim/resolutionscaler/render/Denoiser.java` | `` |  | filter, release, ensure, ensureBuffer |
| top-level / `com/maxim/resolutionscaler/render/DepthConvention.java` | `` |  | observe, reversed, zeroToOne |
| top-level / `com/maxim/resolutionscaler/render/Encoder.java` | `` |  |  |
| top-level / `com/maxim/resolutionscaler/render/EntityVelocity.java` | `` |  | capture, recycle, nextSplat, project, projectBox, release, reset, ensure, ensureBuffer |
| top-level / `com/maxim/resolutionscaler/render/FailSafe.java` | `` |  | isTripped, guard, trip, notifyPlayerIfNeeded, rearm |
| top-level / `com/maxim/resolutionscaler/render/Fence.java` | `` |  |  |
| top-level / `com/maxim/resolutionscaler/render/Filter.java` | `` |  |  |
| top-level / `com/maxim/resolutionscaler/render/FrameGenerator.java` | `` |  | captureWorld, keepDepth, releaseDepthPair, snapshotDepth, ensureDepthSnapshot, releaseDepthSnapshot, captureHandMask, logHandMask, captureHandFrame, releaseHandFrame, generate, bindVoxy, isSimple, captureSimple, ensureSimple, releaseSimple, generateSimple, viewProjAt, restOf, noteViewRest, edgeFlags, syntheticThisCycle, pendingFrame, holdRealFrame, getHeldFrame, invalidate, ensureExtraPhase, releaseExtraPhase, releaseExtraPhases, releaseBuffers, ensure, ensureBuffer, ensureMaskBuffer |
| top-level / `com/maxim/resolutionscaler/render/FrameGenHud.java` | `` |  | extractRenderState |
| top-level / `com/maxim/resolutionscaler/render/FrameGenHudContent.java` | `` |  | collect, pacing, timings, pipeline, passBreakdown, orderKey, accumulatorInputs |
| top-level / `com/maxim/resolutionscaler/render/FrameGenStats.java` | `` |  | recordCycle, recordRealOnly, reset, getDisplayRealFps, getDisplayGeneratedFps, report |
| top-level / `com/maxim/resolutionscaler/render/FramePacer.java` | `` |  | reset, onFrameBoundary, multiplier, slotNanos, isExtraImagePointless, enoughMultiplier, syntheticCount, parkedMillis, slackMillis, effectiveMultiplier, avoidHeavyPass, autoHeld, autoMultiplier, awaitPresentSlot, drainMidPresents, parkThroughMids, awaitNextCycle, awaitLastGapBelowGrid, belowGridBudgetNanos, placeBelowGrid, park, logSpinIfDue, armMidPresents, rotateTimeline, isMidDue, noteGpuBusy, noteCycleStart, timelineAt, onLimiterEnter, onLimiterExit, limiterSleepMillis, isMidBadlyLate, isMidPending, pendingMidCount, midIndex, clearMidPending, handOffMids, noteParked, computeSlot, noteOvershoot, cushionNanos, cushionMillis, generationWorthwhile, isAutoMode, bypassAllowed, isGenerationActive, updateRefreshInterval |
| top-level / `com/maxim/resolutionscaler/render/FramePresenter.java` | `` |  | onRenderPassFinished, presentIfDue, presentGuarded, onTickPoint, flushPending, presentOne, presentCycleEnd, takeWindowSwapped, clearWindowSwapped, takeSwapBlockedNanos, lastMidPresentNanos, swapWindow, present, saveState, restoreState |
| top-level / `com/maxim/resolutionscaler/render/FramePresentHook.java` | `` |  | mayTakeAnotherImage, setPastFramePresent, isInEndOfFramePresent, isInRenderFrame, setInRenderFrame, present, presentGenerated, isFullscreenInBackground, handOffToPresentThread |
| top-level / `com/maxim/resolutionscaler/render/FrameThrottle.java` | `` |  | onPassBoundary, freeQuietly, onCycle, release, isActive, waitedMillis, behindShare, disable, mark, reached, await, clientWait, free |
| top-level / `com/maxim/resolutionscaler/render/FsrUpscaler.java` | `` |  | upscale, upscaleOnePass, releaseSpatialTargets, releaseIntermediate, releaseFxaaTarget, antialias, sharpen, sharpenAmount, renderMeasu, nearestDepth, runFxaa, postProcessInPlace, ensureInPlace, ensureIntermediate, ensureFxaaTarget, ensureBuffers |
| top-level / `com/maxim/resolutionscaler/render/FxaaTuning.java` | `` |  | FxaaTuning |
| top-level / `com/maxim/resolutionscaler/render/GeometryHistory.java` | `` |  | capture, current, release, ensure, ensureBuffer |
| top-level / `com/maxim/resolutionscaler/render/GpuCompat.java` | `` |  | deviceReady, rendererName, onRenderThread, createTexture, createCopyTexture, copyTexture, view, format, sampler, createUbo, map, data, close, std140, encoder, pass, passClearedToZero, draw, createTarget, colorView, depthView, vignetteView, colorTexture, glTextureId, glTextureIdOf, depthTexture, copyDepthTexture, samplerSetToken, applyLodBias, applyLodBiasToSampler, bindFramebuffer, viewport, scissorBox, scissorTest, depthMask, colorMask, saveVersionState, restoreVersionState, fence, close, close, close, putVec2, putVec4, putMat4f, setPipeline, bindTexture, setUniform, close, signalled, await, close |
| top-level / `com/maxim/resolutionscaler/render/GpuTimer.java` | `` |  | otherMillis, beginFrame, expireStale, begin, end, millis, isAvailable, collect, ensureCreated, fail |
| top-level / `com/maxim/resolutionscaler/render/HandMotion.java` | `` |  | capture, capture, endFrame, delta, lastShiftNdc, shiftAtCentre |
| top-level / `com/maxim/resolutionscaler/render/MappedBuffer.java` | `` |  |  |
| top-level / `com/maxim/resolutionscaler/render/McasTuning.java` | `` |  | McasTuning |
| top-level / `com/maxim/resolutionscaler/render/MipBias.java` | `` |  | apply, applyVoxy, hardwareMaxAnisotropy |
| top-level / `com/maxim/resolutionscaler/render/Pass.java` | `` |  |  |
| top-level / `com/maxim/resolutionscaler/render/PassTimeline.java` | `` |  | onCycleEnd, onFrame, isRecording, isPlanning, onPassBoundary, decideAgain, decide, notePresented, collect, plan, describe, reset, forget, fail, issue, ready, read, gpuNow |
| top-level / `com/maxim/resolutionscaler/render/Pipeline.java` | `` |  |  |
| top-level / `com/maxim/resolutionscaler/render/PipelineCompat.java` | `` |  | fullScreen, fullScreenWithDefine, ownVertexShader, colorTarget, build |
| top-level / `com/maxim/resolutionscaler/render/PipelineProbe.java` | `` |  | beginFrame, mark, addCpu, fenceHere, cpuMillis, caughtUpPercent, isAvailable, reset, closePending, fail |
| top-level / `com/maxim/resolutionscaler/render/PreciseSleep.java` | `` |  | open, fail |
| top-level / `com/maxim/resolutionscaler/render/PresentClock.java` | `` |  | stamp, collect, isAvailable, reset, fail, issue, ready, read, gpuNow |
| top-level / `com/maxim/resolutionscaler/render/PresentPacing.java` | `` |  | onDisplayed, judgeShownCycle, onPresented, onPresented, onPresented, noteSwapBlock, noteUnplaced, noteEndHold, noteShadowDefer, noteTickPoint, reset, evenPercent, clumpedPerSecond, worstMillis, shadowDefersPerSecond, report, isFromScreen, reportBreakdown, clearBreakdown |
| top-level / `com/maxim/resolutionscaler/render/ResolutionScalerPipelines.java` | `` |  |  |
| top-level / `com/maxim/resolutionscaler/render/Sampler.java` | `` |  |  |
| top-level / `com/maxim/resolutionscaler/render/SpinMargin.java` | `` |  |  |
| top-level / `com/maxim/resolutionscaler/render/Std140.java` | `` |  |  |
| top-level / `com/maxim/resolutionscaler/render/TaauTuning.java` | `` |  | TaauTuning, needsGeometryHistory |
| top-level / `com/maxim/resolutionscaler/render/TemporalAccumulator.java` | `` |  | handDepthMax, accumulate, ensureDebugTarget, releaseDebugTarget, stillScale, texelFlags, release, recordRace, frameScale, recordPeaks, diagStale, sustainedFps, diagSustainedFps, diagPeakFrameMs, diagFrameMs, diagResampleWidth, diagPeakResampleWidth, diagClampGamma, diagTroughClampGamma, diagCameraMovedFrames, shapeStrengthScale, resampleWidth, adaptiveClampGammaStatic, scaleClipGamma, adaptiveClampFloor, mix, smoothstep, ensure, ensureBuffer |
| top-level / `com/maxim/resolutionscaler/render/TemporalJitter.java` | `` |  | cycleForcedOrder, forcedOrder, logState, reset, activePercent, recordScale, rateScale, orderForRate, isSmoothActive, activeOrderKind, next, order, bounded, constrained, worstCrawl, crawlAt, meanStep, halton |
| top-level / `com/maxim/resolutionscaler/render/Tex.java` | `` |  |  |
| top-level / `com/maxim/resolutionscaler/render/TexelInfo.java` | `` |  | capture, current, release, ensure |
| top-level / `com/maxim/resolutionscaler/render/TexFmt.java` | `` |  |  |
| top-level / `com/maxim/resolutionscaler/render/TexView.java` | `` |  |  |
| top-level / `com/maxim/resolutionscaler/render/Ubo.java` | `` |  |  |
| top-level / `com/maxim/resolutionscaler/render/UboRing.java` | `` |  | lastUsePending, next, current, used, takeWaits, close |
| top-level / `com/maxim/resolutionscaler/render/Vignette.java` | `` |  | viewOr, putNone, record, recordArgb, latch, active, anyActive, putCurr, putPrev, putMap |
| top-level / `com/maxim/resolutionscaler/render/VoxyDepth.java` | `` |  | copy, logProbe, readRow, view, width, height, prevView, ensureTexture, ensureGl, shader, run, set, release |
| top-level / `com/maxim/resolutionscaler/render/VramMonitor.java` | `` |  | available, describe |
| top-level / `com/maxim/resolutionscaler/render/WglShare.java` | `` |  | isSupportedPlatform, createFromCurrent, makeCurrent, release, applySwapInterval, swapBuffers, destroy, fence |
| top-level / `com/maxim/resolutionscaler/render/WorldRenderHook.java` | `` |  | renderWidth, renderHeight, captureViewRotation, levelRenderView, levelBob, noteRenderCamera, checkRenderCamera, jitterGpuProjection, applyGpuJitter, viewJitterOnly, jitterView, voxyProjection, voxyModelView, voxyDetailAreaScale, voxyNearRatio, rotateView, splitBob, isViewRotated, jitterRotM00, jitterRotM11, shearView, captureProjection, beforeLevelRender, beforeLevelRenderUnguarded, ensureWorldTarget, releaseWorldTarget, afterLevelRender, restoreMainTargetAfterFailure, probePackMatrices, afterLevelRenderUnguarded, simpleHandMax, captureHandMask, entityMotionFor, generationWantsFrame, advanceHistory, doAccumulate, accumulateAndSharpen |
| top-level / `com/maxim/resolutionscaler/ResolutionScaler.java` | `` |  |  |
| top-level / `com/maxim/resolutionscaler/ResolutionScalerConfig.java` | `` |  | get, reload, load, resetFromOlderVersion, takeResetNotice, wasFreshlyCreated, save, validate, clampFinite, isUpscalingEnabled, setUpscalingEnabled, getPreset, setPreset, getRenderScale, getSharpness, getJitterPoints, getTaauTuning, getTaauCoverageReactivePercent, setTaauCoverageReactivePercent, isTaauDisocclusion, isTaauEntityMotion, setTaauEntityMotion, setTaauDisocclusion, getTaauShadingChangePercent, setTaauShadingChangePercent, isTemporalFxaa, setTemporalFxaa, isTaauSmoothJitterOrder, setTaauSmoothJitterOrder, isTaauErrorFeedback, setTaauErrorFeedback, getTextureAnisotropy, getTextureAnisotropyStep, setTextureAnisotropyStep, getTaauMotionAccumScale, getMotionSharpnessPercent, setMotionSharpnessPercent, isTaauAdaptiveHistoryTrust, setTaauAdaptiveHistoryTrust, getTaauKernelShape, setTaauKernelShape, getTaauKernelWidthPercent, setTaauKernelWidthPercent, getTaauAccumStrengthTenths, setTaauAccumStrengthTenths, getTaauClampGammaStaticPercent, setTaauClampGammaStaticPercent, getTaauClampGammaMotionPercent, setTaauClampGammaMotionPercent, getTaauMotionFullPxTenths, setTaauMotionFullPxTenths, getTaauMipBias, getTaauMipBiasHundredths, setTaauMipBiasHundredths, getShaderAaBackup, putShaderAaBackup, removeShaderAaBackup, isDisableShaderAntiAliasing, setDisableShaderAntiAliasing, isFrameGenQueueLimit, isFrameGenGpuTimeline, isFrameGenAsyncPresent, getFrameGenQuality, setFrameGenQuality, isFrameGenAvoidHeavyPass, setFrameGenAvoidHeavyPass, isFrameGenSmoothHand, isFrameGenCameraSolve, isFrameGenVignette, isFrameGenEdgeSolve, isFrameGenInpaint, isFrameGenFastPath, isTaauHistory10Bit, isClassicFxaaBeforeUpscale, isTaauTexelGrid, setTaauTexelGrid, isTaauThinGuard, isTaauTemporalBox, getTaauStillMinFrames, isClassicTexelSnap, isClassicLegacyChain, isShaderPresetSync, setShaderPresetSync, getSharpenSuppression, isSharpenAntiRing, isTaauDebugHistory, isTaauViewJitter, isTaauViewJitterRotate, isTaauHandUnjitter, isVoxyNativeLodDetail, isVoxyMipBias, isVoxyDenoiseAsGeometry, isVoxyTranslucentDepth, isVoxyFrameGen, isDhLodDepth, isDhViewJitter, isDhDisableAntiAliasing, getMeasuEdgeAaPixels, setMeasuEdgeAaPixels, getFxaaStrengthPercent, setFxaaStrengthPercent, isFrameGenAutoDisable, setFrameGenAutoDisable, isFrameGenLockToRefresh, setFrameGenLockToRefresh, isFrameGenLowLatency, setFrameGenLowLatency, isPerformanceOverlayEnabled, setPerformanceOverlayEnabled, getDenoisePercent, setDenoisePercent, getSharpenSuppressionPercent, setSharpenSuppressionPercent, getTextureSharpnessPercent, setTextureSharpnessPercent, getTaauClampFloorPercent, setTaauClampFloorPercent, isTaauSubLsbDither, setTaauSubLsbDither, getCustomRenderScale, setCustomRenderScale, getCustomSharpness, setCustomSharpness, getCustomRenderScalePercent, setCustomRenderScalePercent, getCustomSharpnessPercent, setCustomSharpnessPercent, getMeasuEdgeAaPercent, setMeasuEdgeAaPercent, getSubPixelWriteMode, setSubPixelWriteMode, getMcasEdgeLowThousandths, setMcasEdgeLowThousandths, getMcasEdgeHighThousandths, setMcasEdgeHighThousandths, getMcasEdgeSuppressionPercent, setMcasEdgeSuppressionPercent, getMcasNoiseLowThousandths, setMcasNoiseLowThousandths, getMcasNoiseHighThousandths, setMcasNoiseHighThousandths, getMcasNoiseSuppressionPercent, setMcasNoiseSuppressionPercent, getFxaaEdgeThresholdThousandths, setFxaaEdgeThresholdThousandths, getFxaaSubpixelQualityPercent, setFxaaSubpixelQualityPercent, getMcasTuning, setCustomMcasTuning, getSharpnessPercent, setSharpnessPercent, getFrameGenMode, setFrameGenMode, isFrameGenerationEnabled, getFrameGenMultiplier, isFrameGenHudEnabled, setFrameGenHudEnabled, getUpscaleMode, setUpscaleMode, isTemporalUpscale, getFxaaTuning, getFxaaSearchStep, getSharpenDeadZone, getShaderNoiseStrength, getShaderNoisePercent, setShaderNoisePercent, getSkyNoiseStrength, getSkyNoisePercent, getSkyDetailGuardPercent, setSkyDetailGuardPercent, setSkyNoisePercent, setCustomFxaaTuning, getCustomGpuLabel, setCustomGpuLabel, getCustomShaderProfile, setCustomShaderProfile, getColorGrading, setColorGrading, renderScale, sharpness, mcasTuning, fxaaTuning, multiplier |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
