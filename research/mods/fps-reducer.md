# FPS Reducer

Review status: **Evidence inventory; behavioral review pending**

Project: [FPS Reducer](https://modrinth.com/mod/fps-reducer)
Selected artifact version: `26.3-2.18`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Reduce GPU and CPU usage automatically when no user operation exists.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `08450f7380b61af2aadcf38cb61cb31ee74fd522`
- `sha512`: `048396a4cd2802271cf9e6cb445dfafa2ab9a68b059967c674ea845ae2735636594e247a16a813c69f7b70b02e3fdf1c299faf770f10425164439f768b0a942a`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 43
Reconstructed Java files: 38

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [],
  "client": [
    "bre2el.fpsreducer.FpsReducer"
  ],
  "modmenu": [
    "bre2el.fpsreducer.compat.modmenu.MenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.0",
  "minecraft": ">=26.3-",
  "java": ">=25",
  "fabric-api": "*"
}
```

**accessWidener**

```json
"fpsreducer.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `bre2el/fpsreducer/compat/modmenu/MenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `bre2el/fpsreducer/config/Config.java` | `` |  | update, prepareSave, initHudPosDefaultValues, setInstance, setHudReferencePos, getHudReferencePos, resetHudOffsetsAndAlignments, hexToDec, hexToDec, decToHex |
| top-level / `bre2el/fpsreducer/config/ConfigManager.java` | `` |  | init, load, save |
| top-level / `bre2el/fpsreducer/config/Profile.java` | `` |  | setProfile, compareToProfile, correctProfile |
| top-level / `bre2el/fpsreducer/FpsReducer.java` | `` |  | onInitializeClient |
| top-level / `bre2el/fpsreducer/gui/components/ButtonEx.java` | `` |  | onPress, extractContents, setTooltip |
| top-level / `bre2el/fpsreducer/gui/components/CheckboxButtonEx.java` | `` |  | extractContents, getYImage, onPress, isChecked, setIsChecked, updateWidgetNarration |
| top-level / `bre2el/fpsreducer/gui/components/GuiLabelEx.java` | `` |  | addLine, setCentered, drawLabel |
| top-level / `bre2el/fpsreducer/gui/components/GuiSlider.java` | `` |  | addSubstituteText, addAdditionalText, updateMessage, onRelease, applyValue, getValueInt, getValue, setResolution, setTooltip, setTooltipWait |
| top-level / `bre2el/fpsreducer/gui/components/GuiSliderFlexTime.java` | `` |  | updateMessage, getTimeSec, val2Time, time2Val |
| top-level / `bre2el/fpsreducer/gui/components/SelectButtons.java` | `` |  | add, resetOthers, resetAll |
| top-level / `bre2el/fpsreducer/gui/components/TexturedButtonEx.java` | `` |  | onPress, extractContents, setPressed, setSelectButtons, setTooltip, setTooltipWait |
| top-level / `bre2el/fpsreducer/gui/components/UnobtrusiveTooltip.java` | `` |  | updateLastHoveredTime |
| top-level / `bre2el/fpsreducer/gui/Hud.java` | `` |  | getInstance, setFPSCPUData, drawHud, updateBoxPosition, drawHudBox, drawLineToHudBox, updateHudText, cpuLoadValStr, updateAlignOffset, update, updatePosition, drawRectFrame, getPosX, getPosY, setPos, setDragOffset, getBoxPosX, getBoxPosY, isMouseOver |
| top-level / `bre2el/fpsreducer/gui/HudPos.java` | `` |  | setOffset, copy |
| top-level / `bre2el/fpsreducer/gui/screen/GuiConfigAdvanced.java` | `` |  | init, onClose, extractRenderState, isPauseScreen |
| top-level / `bre2el/fpsreducer/gui/screen/GuiConfigScreen.java` | `` |  | init, onClose, extractRenderState, isPauseScreen |
| top-level / `bre2el/fpsreducer/gui/screen/GuiHudPosAdjuster.java` | `` |  | init, reinitGui, placeButtons, getButtonsPos, isSelected, actionPerformed, extractRenderState, renderLabels, mouseClicked, mouseReleased, mouseDragged, resize, keyPressed, shouldCloseOnEsc |
| top-level / `bre2el/fpsreducer/gui/screen/GuiScreenEx.java` | `` |  | init, addWidget, mouseMoved, getStringOnOff |
| top-level / `bre2el/fpsreducer/handler/GuiOpenEventHandler.java` | `` |  | onGuiOpenEvent |
| top-level / `bre2el/fpsreducer/handler/InputEventHandler.java` | `` |  | onAnyInput, getLastEventNanoSec, updateLastEventNanoSec, clearInputEventInIdle, isInputEventInIdle, onMouseButtonDown, onMouseButtonUp, isAnyMouseButtonPressed |
| top-level / `bre2el/fpsreducer/handler/KeyInputEventHandler.java` | `` |  | onKeyInput |
| top-level / `bre2el/fpsreducer/handler/OverlayEventHandler.java` | `` |  | onRenderGameOverlay |
| top-level / `bre2el/fpsreducer/handler/WakeupEventHandler.java` | `` |  | onMouseClicked, onMouseScroll, onKeyboardKeyPressed, makeWindowStatusActive, onClientTick, calcTps, getTps, checkWakeupEvent, checkWakeup, checkMoving, checkMovingSimply, checkRotation, resetWaitingTimer, checkWaitingTimer, reduceFPS, recoverFPS, recoverNormalFPS, loggingReduceFps, loggingRecoverFps, forceReduceFPS, forceRecoverFPS, stopSound, recoverSound, getWaitingTimeSecond, setCancelableWaitEvents, setFramerateLimit, getFramerateLimit |
| top-level / `bre2el/fpsreducer/KeyBindingHelper.java` | `` |  | registerKeyBinding |
| top-level / `bre2el/fpsreducer/mixin/FramerateLimiterMixin.java` | `value={FramerateLimiter.class})` | Inject:1 | fastResumeOnInput, runEventAwareWait, isInputDetected |
| top-level / `bre2el/fpsreducer/mixin/FramerateLimitTrackerMixin.java` | `value={FramerateLimitTracker.class})` | Inject:1 | getFramerateLimit |
| top-level / `bre2el/fpsreducer/mixin/GuiMixin.java` | `value={Gui.class})` | Inject:1 | handleGuiOpenEvent |
| top-level / `bre2el/fpsreducer/mixin/KeyboardHandlerMixin.java` | `value={KeyboardHandler.class})` | Inject:1 | fireKeyInput |
| top-level / `bre2el/fpsreducer/mixin/MouseHandlerMixin.java` | `value={MouseHandler.class})` | Inject:3 | onCursorMove, onMouseButton, onMouseScroll |
| top-level / `bre2el/fpsreducer/mixin/VideoSettingScreenMixin.java` | `value={VideoSettingsScreen.class})` |  | init |
| top-level / `bre2el/fpsreducer/mixin/WindowMixin.java` | `value={Window.class})` |  | injection |
| top-level / `bre2el/fpsreducer/MixinConfigPlugin.java` | `` |  | hasClass, onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `bre2el/fpsreducer/util/GlUtils.java` | `` |  | pushState, popState, setColor4f, drawSquare, drawLine3, drawDotLine |
| top-level / `bre2el/fpsreducer/util/Logger.java` | `` |  | init, debug, info, warn, error |
| top-level / `bre2el/fpsreducer/util/ModLib.java` | `` |  | getProcessCpuLoad, getCpuUsage, getThreadCpuUsage |
| top-level / `bre2el/fpsreducer/util/Reflection.java` | `` |  | getPrivateField, setPrivateField, getField, setField, hasClassMethod, hasClassField |
| top-level / `bre2el/fpsreducer/util/SdlUtils.java` | `` |  | isWindowFocused |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
