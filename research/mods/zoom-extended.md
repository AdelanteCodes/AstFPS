# Zoom Extended

Review status: **Evidence inventory; behavioral review pending**

Project: [Zoom Extended](https://modrinth.com/mod/zoom-extended)
Selected artifact version: `1.3.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

An overly configurable zoom mod with extensive customization.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `fbd0d22b1b1e65b7413cb51e5ac4c4a02fe599c04285f2c363e864366c46c07000eea70a26a138ccd2ca09ba5acd1f9125c6ac2db11c74acb90df9531c37d566`
- `sha1`: `d2de4242176f2db36f94355d1df3fceef21c554b`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 38
Reconstructed Java files: 23

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "modmenu": [
    "dev.theunnamed.zoomextended.ModMenuIntegration"
  ],
  "client": [
    "dev.theunnamed.zoomextended.loader.ZoomExtendedFabricClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/theunnamed/zoomextended/Easing.java` | `` |  | apply, bounceOut, next |
| top-level / `dev/theunnamed/zoomextended/EntityViewOptimizer.java` | `` |  | shouldCull, currentZoomFactor, classify |
| top-level / `dev/theunnamed/zoomextended/KeyMappingCompat.java` | `` |  | create |
| top-level / `dev/theunnamed/zoomextended/loader/ZoomExtendedFabricClient.java` | `` |  | onInitializeClient |
| top-level / `dev/theunnamed/zoomextended/MinecraftCompat.java` | `` |  | literal, overlayMessage |
| top-level / `dev/theunnamed/zoomextended/mixin/CameraMixin.java` | `value={Camera.class})` | Inject:2 | zoomExtended$worldFov, zoomExtended$handFov |
| top-level / `dev/theunnamed/zoomextended/mixin/EntityRenderDistanceMixin.java` | `value={Entity.class})` | Inject:1 | zoomExtended$optimizedEntityView |
| top-level / `dev/theunnamed/zoomextended/mixin/GameRendererMixin.java` | `value={GameRenderer.class})` | Inject:2 | zoomExtended$applyHudMode, zoomExtended$hideHand |
| top-level / `dev/theunnamed/zoomextended/mixin/HudOverlayMixin.java` | `value={Hud.class})` | Inject:1 | zoomExtended$fadeHud |
| top-level / `dev/theunnamed/zoomextended/mixin/MinecraftTickMixin.java` | `value={Minecraft.class})` | Inject:1 | zoomExtended$tick |
| top-level / `dev/theunnamed/zoomextended/mixin/MouseHandlerMixin.java` | `value={MouseHandler.class})` | Inject:2 | zoomExtended$scrollZoom, zoomExtended$relativeSensitivity |
| top-level / `dev/theunnamed/zoomextended/mixin/ThirdPersonCameraDistanceMixin.java` | `value={Camera.class})` | ModifyVariable:1 | zoomExtended$expandThirdPersonDistance |
| top-level / `dev/theunnamed/zoomextended/mixin/ZoomConfigStableMixin.java` | `value={ZoomConfig.class}, remap=false)` | Inject:2 | zoomExtended$saveStableOptions, zoomExtended$migrateStableDefaults |
| top-level / `dev/theunnamed/zoomextended/mixin/ZoomSensitivityMixin.java` | `targets={"dev.theunnamed.zoomextended.ZoomController"}, remap=false)` | Inject:1 | zoomExtended$precisionSensitivity |
| top-level / `dev/theunnamed/zoomextended/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `dev/theunnamed/zoomextended/ThirdPersonRuntimeState.java` | `` |  | update, isOutwardThirdPerson |
| top-level / `dev/theunnamed/zoomextended/ThirdPersonZoomConfig.java` | `` |  | get, usesOutwardZoom, appliesFovInThirdPerson, cycleMode, resetDefaults, desiredDistance, load, save, applyStable011Migration, readProperties, decimal, next, displayName |
| top-level / `dev/theunnamed/zoomextended/ZoomConfig.java` | `` |  | load, save, setStepCount, setZoomRange, redistributeSteps, defaultZoomSteps, isLegacyFiveStepDefault, applyOptimizationProfile, markOptimizationCustom, scaleSteps, joinSteps, bool, integer, decimal, enumValue, next, next, next, next |
| top-level / `dev/theunnamed/zoomextended/ZoomController.java` | `` |  | init, isActive, step, factor, targetFactor, isAnimating, resetStepToDefault, setActive, toggle, changeStep, scrollStep, changeStep, applyToFov, currentTargetFactor, startTransition, startTransitionFrom, animatedFactor, normalizedZoomAmount, sensitivityScale, stepPitch, clampPitch, fmt |
| top-level / `dev/theunnamed/zoomextended/ZoomExtendedClient.java` | `` |  | createKeyMappings, tick |
| top-level / `dev/theunnamed/zoomextended/ZoomHudOverlay.java` | `` |  | extract, reflectedDimension |
| top-level / `dev/theunnamed/zoomextended/ZoomSettingsScreen.java` | `` |  | init, calculateLayout, rebuildPage, addNavigation, buildGeneralPage, buildMotionPage, buildCameraPage, buildStepsPage, buildFeedbackPage, buildPerformancePage, addDistanceSlider, addToggle, addToggle, addCycle, addCycle, addInfo, addSlider, addSetting, layoutSettings, rowHeight, switchPage, markChanged, saveNow, requestReset, resetCurrentPage, tick, mouseScrolled, onClose, extractRenderState, drawAmbientBackground, drawPanel, drawHeader, drawPageHeading, contextualHelp, drawFooter, drawSidebarSummary, drawScrollbar, drawSaveState, ellipsize, stepsPreview, pretty, formatBlocks, format, round, mixColor, withAlpha, clamp, clamp, Page, extractWidgetRenderState, onClick, keyPressed, updateWidgetNarration, extractWidgetRenderState, onClick, keyPressed, updateWidgetNarration, drawControl, onClick, keyPressed, valueText, controlWidth, controlLeft, isMouseOver, extractWidgetRenderState, updateWidgetNarration, drawControl, onClick, keyPressed, valueText, drawControl, onClick, onDrag, onRelease, keyPressed, setFromMouse, apply, normalized, valueText |
| top-level / `dev/theunnamed/zoomextended/ZoomSounds.java` | `` |  | play |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
