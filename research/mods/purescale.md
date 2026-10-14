# Purescale

Review status: **Evidence inventory; behavioral review pending**

Project: [Purescale](https://modrinth.com/mod/purescale)
Selected artifact version: `1.2.1`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A performance mod that uses the upscaling and frame generation features.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `eb6a91b65ae390b55a5d65f00ea6ccdd41ca24332038ee1d564f8d7f106dfeb854a53ae3bfe6c01e61abb084f6263422505852c61cd245b6461c9fbd97c995a5`
- `sha1`: `7ffd92de4ef1d983de0d6cad93d6e7aa24d27245`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 63
Reconstructed Java files: 34

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "com.purescale.Purescale"
  ],
  "client": [
    "com.purescale.client.PurescaleClient"
  ],
  "sodium:config_api_user": [
    "com.purescale.client.compat.PurescaleSodiumConfig"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*",
  "sodium": "*"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/junrar-7.5.5.jar` | 102 | `com_github_junrar_junrar` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/purescale/client/compat/PurescaleSodiumConfig.java` | `` |  | registerConfigLate, qualityLabel, frameGenLabel |
| top-level / `com/purescale/client/gui/PGfx.java` | `` |  | fadeEdges, faded, lerpColor, guiWidth, guiHeight, enableScissor, disableScissor, fill, fillGradient, setTooltipForNextFrame, hasTexturedBlit, blit, nextStratum, text, text, centeredText, text |
| top-level / `com/purescale/client/gui/PurescaleLegacyMenuBlur.java` | `` |  | draw, release |
| top-level / `com/purescale/client/gui/PurescaleOptions.java` | `` |  | enabled, upscaler, quality, sharpness, frameGeneration, targetFps, overlay, overlayDetailed, fgEngine, reprojectQuality, fgEngines, fgEngineLabel, reprojectQualityLabel, frameWarp, vibrance, vibranceStrength, historyStrength, ghostReduction, renderScale, motionAdaptive, performanceMode, lowFpsRescue, staticRefine, fgPacing, entityMvec, handNative, handMvec, fxaa, rayReconDenoise, lowLatency, outputSharpen, outputSharpenStrength, fgQuickTurnGuard, fgArtifactGuard, fgEdgeFill, fgRealisticLatency, fgMotionResolution, reprojection, motionSharpen, motionSharpenStrength, fgDenoise, fgDenoiseStrength, fgClarity, fgClarityStrength, framePacing, motionSharpenCamera, bfi, bfiStrength, qualityLabel, qualityName, frameGenLabel, presetLabel, modeLabel, buildUpscalerList, upscalerLabel, advanceUpscaler, upscalerLabels, upscalerIndex |
| top-level / `com/purescale/client/gui/PurescaleOptionsScreen.java` | `` |  | frameGenChoices, dropdownSlots, dropdownBounds, openDropdown, dropdownClick, dropdownScroll, dropdownKey, drawDropdown, tooltipBounds, drawWrappedTip, init, card, placeRow, cycle, baseScale, refreshProfiles, selectedProfile, selectByName, profileNew, profileSave, profileLoad, profileDelete, applyScroll, mouseScrolled, keyPressed, scrollThumb, overScrollBar, scrollToThumbY, beginScrollDrag, mouseClicked, mouseDragged, mouseReleased, extractBackground, blurBounds, blurWorld, drawBackground, extractRenderState, drawForeground, drawDone, isPauseScreen, onClose, roundRect, drawContent, onClick, drawContent, onClick, extractWidgetRenderState, drawRow, updateWidgetNarration, Card, drawContent, onClick, drawContent, setFromMouse, onClick, onDrag, drawContent, onClick, displayValue, commit, drawContent, onClick, charTyped, capturesInput, keyPressed, setFocused, drawContent, onClick, extractWidgetRenderState, onClick, updateWidgetNarration, drawContent, onClick |
| top-level / `com/purescale/client/gui/PurescalePanelBlur.java` | `` |  | screen, target, capture, restore, copy, release |
| top-level / `com/purescale/client/gui/PurescaleUiLayout.java` | `` |  | panelWidth |
| top-level / `com/purescale/client/hud/PurescaleHud.java` | `` |  | showToast, extractRenderState, draw, drawFpsPill, onePercentLow, drawToast, perfColor, lerpColor, lerpByte, withAlpha |
| top-level / `com/purescale/client/Keybinds.java` | `` |  | register, reg, onTick, playUi |
| top-level / `com/purescale/client/mixin/GameRendererMixin.java` | `value={GameRenderer.class})` | Inject:5, ModifyArg:1, Invoker:1, Redirect:2 | purescale$mainTarget, purescale$beginLevel, purescale$jitterProjection, purescale$endLevel, purescale$prepareHandShading, purescale$upscaleBeforeNativeHand, purescale$handRenderTarget, purescale$handDepthTarget, purescale$redirectTarget |
| top-level / `com/purescale/client/mixin/MinecraftMixin.java` | `value={Minecraft.class})` |  |  |
| top-level / `com/purescale/client/mixin/PurescaleMenuBlurMixin.java` | `value={Options.class})` | Inject:1 | purescale$menuBlur |
| top-level / `com/purescale/client/mixin/PurescalePanelBlurMixin.java` | `value={GameRenderer.class})` | Inject:2 | purescale$captureSharpScene, purescale$restoreOutsidePanel |
| top-level / `com/purescale/client/mixin/RenderPipelinesAccessor.java` | `value={RenderPipelines.class})` | Invoker:1 | purescale$register |
| top-level / `com/purescale/client/mixin/RenderSystemAccessor.java` | `value={RenderSystem.class})` | Accessor:1 | purescale$getFallbackPipelineCache |
| top-level / `com/purescale/client/mixin/VideoSettingsScreenMixin.java` | `value={VideoSettingsScreen.class})` | Inject:1 | purescale$addOptions |
| top-level / `com/purescale/client/PurescaleBenchmark.java` | `` |  | tick, applyResult |
| top-level / `com/purescale/client/PurescaleClient.java` | `` |  | onInitializeClient, getFabricId, onResourceManagerReload |
| top-level / `com/purescale/client/PurescaleFirstJoinFix.java` | `` |  | tick |
| top-level / `com/purescale/client/PurescaleModernOffer.java` | `` |  | open |
| top-level / `com/purescale/client/PurescaleSupport.java` | `` |  | downloads, avatarReady, avatarW, avatarH, openProfile, metaFile, avatarFile, fetchAsync, refresh, writeMeta, loadAvatarFromDisk, uploadAvatar, maskCircle, get, getBytes, request |
| top-level / `com/purescale/client/render/PurescaleEntityMotion.java` | `` |  | recs, reset, capture |
| top-level / `com/purescale/client/render/PurescaleFrameHistory.java` | `` |  | capture, reset, hasHistory, lastMotionPixels, currentViewProj, previousViewProj, cameraDelta, estimateMotionPixels |
| top-level / `com/purescale/client/render/PurescaleJitter.java` | `` |  | halton, advance, reset, clipX, clipY, pixelX, pixelY |
| top-level / `com/purescale/client/render/PurescaleRenderer.java` | `` |  | draw, bindTex, samplersReady, zZeroToOne, makeTarget, compileCommunity, usePipeline, resolvePipeline, historyWeight, entityMvecUboSize, profPresentTick, isInsideLevel, sceneTarget, internalWidth, internalHeight, outputWidth, outputHeight, logFirstUpscale, realCycleMs, shouldDeferHand, beginHandRedraw, endHandRedraw, markOutsideLevel, shouldEngage, beginLevel, isTemporalActive, jitterActive, updateDynamicScale, realFpsForAuto, updateAutoFps, rescueEligible, resetRescue, updateLowFpsRescue, updateMotionScale, updateStaticRefine, upscaleTo, finishPost, other, supersampleDownscale, ensureSharpen, sharpenPass, ensureVibrance, vibrancePass, ensureMotionSharpen, motionSharpenPass, framePaceTick, applyBfiIfDark, ensureBfi, applyFgClean, ensureFgClean, ensurePostTargets, ensureFxaa, ensureCompare, fxaaPass, comparePass, taaResolve, ensureTaaResources, ensureRayReconDenoise, rayReconDenoisePass, baseFpsLimitTick, frameGenBegin, paceGeneratedFrame, frameGenStashCamera, isStaticPair, isFlickPair, sleepNanos, updateFgFactorCeiling, updateDynamicFrameGenFactor, presentInterpolated, presentCapActive, maybeWarnFgPresentCap, resolveEngine, cinematicGuard, liveViewAngles, frameGenCompleteReal, frameGenRollAndPresent, ensureInterpResources, fgDepthCopy, dispose, releaseGpuResources, requestReset, ensureResources |
| top-level / `com/purescale/client/render/PurescaleShaders.java` | `` |  | initialize, make, colorState, communityPipeline |
| top-level / `com/purescale/client/upscaler/CommunityUpscaler.java` | `` |  | shaderSource, getShader, getInclude, close |
| top-level / `com/purescale/client/upscaler/PurescaleRarReader.java` | `` |  |  |
| top-level / `com/purescale/client/upscaler/PurescaleUpscalerRegistry.java` | `` |  | packsDir, reload, loadEntry, addPack, folderReader, zipReader, addRarPack, ensureDirAndExample, copyBundled, optString, baseName, all, get, isEmpty |
| top-level / `com/purescale/client/upscaler/UpscalePackReader.java` | `` |  |  |
| top-level / `com/purescale/config/PurescaleConfig.java` | `` |  | capabilitySummary, matchingPreset, applyPreset, effectiveRenderScale, historyStrengthFactor, ghostMultiplier, isSupersample, isNativeAa, coerceSupportedMode, isFrameGenActive, isLiveReproject, isOpticalFlow, mayUseOpticalFlow, isTemporalMode, isNativePostMode, staticRefineActive, isSimpleSpatial, usesDynamicFrameGen, frameGenFactor, frameGenGenerated, isReprojectionCapable, isActive, configPath, get, load, save, applyFrom, markCustom, toggleEnabled, setPerformanceMode, cycleFrameGen, cycleQuality, generatedFrames |
| top-level / `com/purescale/config/PurescaleProfiles.java` | `` |  | dir, sanitize, list, nextDefaultName, save, load, delete |
| top-level / `com/purescale/Purescale.java` | `` |  | onInitialize, id |
| top-level / `com/purescale/PurescaleSounds.java` | `` |  | register |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
