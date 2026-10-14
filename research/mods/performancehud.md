# PerformanceHUD

Review status: **Evidence inventory; behavioral review pending**

Project: [PerformanceHUD](https://modrinth.com/mod/performancehud)
Selected artifact version: `1.2.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Lightweight client-side HUD showing FPS, RAM, entities, chunks, ping, and CPU in one customizable corner overlay.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `43d58d2fca21ee863b7524e570aa4708bebfb0c6`
- `sha512`: `b03b8708495dfb35d048f6a6383fb38cc9b3c9b2458dd76e0ef9cb625367de7be23b94c3923f08b46d72b47d1c6ea6b484be0648dd8997aa4ac21dc65725b0af`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 45
Reconstructed Java files: 45

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "dev.nikrecs.performancehud.fabric.PerformanceHudFabricClient"
  ]
}
```

**depends**

```json
{
  "architectury": "^22.0.1",
  "fabricloader": ">=0.19.5",
  "fabric-api": ">=0.160.5+26.3",
  "minecraft": "26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `architectury_inject_performancehud263_common_2d8425fb29224b7fa8a3cfaeb8099e2d_72cad36488184ba574978ba78fe9343da0feef8f8f2a153ff86e144d00acc9e3performancehudcommon263120devjar/PlatformMethods.java` | `` |  | getCurrentTarget |
| top-level / `dev/nikrecs/performancehud/architectury/ArchitecturyClientRegistration.java` | `` |  | registerClientHooks |
| top-level / `dev/nikrecs/performancehud/client/command/PerformanceHudCommandActions.java` | `` |  | requestSettingsOpen, sendStatus, reloadConfig, resetConfig |
| top-level / `dev/nikrecs/performancehud/client/command/PerformanceHudCommandTree.java` | `` |  | createAndGetRootCommand |
| top-level / `dev/nikrecs/performancehud/client/command/PerformanceHudSettingCommands.java` | `` |  | createAndGetBooleanCommand, createAndGetIntegerCommand, sendBooleanValue, sendIntegerValue |
| top-level / `dev/nikrecs/performancehud/client/command/PerformanceHudStatusText.java` | `` |  | getStatusComponent, getOnOffLabel, getHexColorText |
| top-level / `dev/nikrecs/performancehud/client/CurrentFps.java` | `` |  | getCurrentFps |
| top-level / `dev/nikrecs/performancehud/client/FpsStringParser.java` | `` |  | parseLeadingFps, getLeadingDigitCount |
| top-level / `dev/nikrecs/performancehud/client/hud/HudColors.java` | `` |  | getBackgroundColor, getTextColor |
| top-level / `dev/nikrecs/performancehud/client/hud/HudMetricReader.java` | `` |  | readOrNull |
| top-level / `dev/nikrecs/performancehud/client/hud/HudPanelLayout.java` | `` |  | createAndGet, getLineX, getLineY, getTextRight, getTextTop, getLineStep, getBoxLeft, getBoxTop, getBoxRight, getBoxBottom |
| top-level / `dev/nikrecs/performancehud/client/hud/HudValueFormat.java` | `` |  | getFpsText, getRamText, getValueText, getValueText |
| top-level / `dev/nikrecs/performancehud/client/hud/HudVisibility.java` | `` |  | isGuiHidden |
| top-level / `dev/nikrecs/performancehud/client/hud/PerformanceHudCollector.java` | `` |  | collectLines |
| top-level / `dev/nikrecs/performancehud/client/hud/PerformanceHudLayer.java` | `` |  | render |
| top-level / `dev/nikrecs/performancehud/client/hud/PerformanceHudRenderer.java` | `` |  | render, drawPanel |
| top-level / `dev/nikrecs/performancehud/client/hud/PerformanceMetrics.java` | `` |  | getEntityCount, getLoadedChunkCount, getPing, getCpuPercent, readPing, readCpuPercent, createAndGetReader |
| top-level / `dev/nikrecs/performancehud/client/input/PerformanceHudKeyMappings.java` | `` |  | createAndGetToggleHudKey |
| top-level / `dev/nikrecs/performancehud/client/PerformanceHudClientController.java` | `` |  | registerKeyMappings, requestSettingsOpen, runClientTick, toggleHud |
| top-level / `dev/nikrecs/performancehud/client/PerformanceHudPlayerMessages.java` | `` |  | sendChatMessage, sendActionBar |
| top-level / `dev/nikrecs/performancehud/client/ScreenAccess.java` | `` |  | getCurrentScreen, openScreen |
| top-level / `dev/nikrecs/performancehud/client/TranslationKeyConstants.java` | `` |  |  |
| top-level / `dev/nikrecs/performancehud/client/ui/AbstractPerformanceHudConfigScreen.java` | `` |  | init, onClose, positionRows, getDrawnRowWidgets, scrollRows, isClickOnClippedRow, addSettingRows, addButtons, createAndGetToggleButton, addRowWidget, addButtonWidget, isParkedOffscreen, getButtonWidgets, getConfig, getLayout, getScrollGeometry, getScrollOffset |
| top-level / `dev/nikrecs/performancehud/client/ui/ConfigScreenActions.java` | `` |  | saveAndClose, close, getToggleMessage |
| top-level / `dev/nikrecs/performancehud/client/ui/ConfigScreenColorConstants.java` | `` |  |  |
| top-level / `dev/nikrecs/performancehud/client/ui/ConfigScreenLayout.java` | `` |  | createAndGetClipped, createAndGetRowAligned, getContentWidth, getRowLeft, getRowWidth, getRowY, getViewportHeight, getButtonRowY, getSideButtonWidth, getDoneButtonLeft, getCancelButtonLeft, isInScrollArea, isInContentColumnOutsideScrollArea, isInContentColumn, getDesiredScrollAreaBottom, createAndGet, getScreenWidth, getScreenHeight, getContentLeft, getContentRight, getScrollAreaTop, getScrollAreaBottom |
| top-level / `dev/nikrecs/performancehud/client/ui/ConfigScreenLayoutConstants.java` | `` |  |  |
| top-level / `dev/nikrecs/performancehud/client/ui/ConfigScreenPainter.java` | `` |  | paintBackdrop, paintHeader, paintScrollbar, paintHint |
| top-level / `dev/nikrecs/performancehud/client/ui/ConfigScrollGeometry.java` | `` |  | createAndGet, clampScrollOffset, clampScrollOffsetToRows, getScrolledRowY, isRowOverlappingScrollArea, isRowInsideScrollArea, isScrollbarShown, getScrollbarLeft, getScrollbarRight, getTrackTop, getTrackBottom, getThumbHeight, getThumbTop |
| top-level / `dev/nikrecs/performancehud/client/ui/DrawSurface.java` | `` |  |  |
| top-level / `dev/nikrecs/performancehud/client/ui/GuiDrawSurface.java` | `` |  | getGuiWidth, fillRectangle, drawTextWithShadow, drawCenteredText |
| top-level / `dev/nikrecs/performancehud/client/ui/PerformanceHudConfigScreen.java` | `` |  | extractRenderState, mouseScrolled, mouseClicked, createAndGetScreen |
| top-level / `dev/nikrecs/performancehud/client/ui/widget/IntSliderWidget.java` | `` |  | updateMessage, applyValue, getSliderValue, getSliderPosition |
| top-level / `dev/nikrecs/performancehud/config/BooleanSetting.java` | `` |  | getValue, setValue, toggleValue, getName, getLabelKey |
| top-level / `dev/nikrecs/performancehud/config/ConfigBooleanSetter.java` | `` |  |  |
| top-level / `dev/nikrecs/performancehud/config/ConfigLimitConstants.java` | `` |  |  |
| top-level / `dev/nikrecs/performancehud/config/ConfigMutation.java` | `` |  |  |
| top-level / `dev/nikrecs/performancehud/config/IntegerSetting.java` | `` |  | getValue, setValue, getName, getLabelKey, getMinimum, getMaximum |
| top-level / `dev/nikrecs/performancehud/config/PerformanceHudConfig.java` | `` |  | createAndGetDefaults, createAndGetCopy, clampToValidValues, clampToRange |
| top-level / `dev/nikrecs/performancehud/config/PerformanceHudConfigStore.java` | `` |  | initializeAndLoad, getConfigSnapshot, saveConfig, mutateConfig, reloadConfig, resetForTesting, loadFromDisk, moveUnreadableFileToBackup, saveToDisk, logWarning |
| top-level / `dev/nikrecs/performancehud/config/SettingConstants.java` | `` |  |  |
| top-level / `dev/nikrecs/performancehud/config/TextColorChannels.java` | `` |  | getRed, getGreen, getBlue, getColorWithRed, getColorWithGreen, getColorWithBlue, getChannel, getColorWithChannel |
| top-level / `dev/nikrecs/performancehud/fabric/FabricPerformanceHudOverlay.java` | `` |  | registerHudHook |
| top-level / `dev/nikrecs/performancehud/fabric/PerformanceHudFabricClient.java` | `` |  | onInitializeClient |
| top-level / `dev/nikrecs/performancehud/PerformanceHudConstants.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
