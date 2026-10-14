# Dynamic FPS

Review status: **Evidence inventory; behavioral review pending**

Project: [Dynamic FPS](https://modrinth.com/mod/dynamic-fps)
Selected artifact version: `3.11.10`
Published implementation source: https://github.com/juliand665/Dynamic-FPS
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Reduce resource usage while Minecraft is in the background, idle, or on battery.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `a4860c9480f0ce1a468e1e4c254214b1f97e19b3`
- `sha512`: `7976d11411babfa3ac0c38898f26ee6192f22a4f595b637eeae3cc5185f326c0e4b9fd7d00b3d7e8d020dd861295f0df52f9a9d7c67e88946d0ba9fff4a9f894`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 5
Reconstructed Java files: 5

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "net.lostluma.dynamic_fps.impl.fabric.compat.FREX"
  ],
  "modmenu": [
    "net.lostluma.dynamic_fps.impl.fabric.compat.ModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "minecraft": ">=26.2.0-",
  "fabric-resource-loader-v0": "*",
  "fabric-lifecycle-events-v1": "*"
}
```

**conflicts**

```json
{
  "optifabric": "*",
  "smoothmenu": "*"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/battery-2.1.0.jar` | 41 | `net_lostluma_battery` | No |
| `META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar` | 62 | `dynamic_fps_common` | Reconstructed source; semantic review pending |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/lostluma/dynamic_fps/impl/fabric/compat/FREX.java` | `` |  | isFlawlessFramesActive, onInitializeClient |
| top-level / `net/lostluma/dynamic_fps/impl/fabric/compat/ModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `net/lostluma/dynamic_fps/impl/fabric/mixin/OptionsMixin.java` | `value={Options.class})` | Inject:1 | load |
| top-level / `net/lostluma/dynamic_fps/impl/fabric/service/FabricModCompat.java` | `` |  | isDisabled, disableOverlayOptimization, parseModMetadata, parseOverlayOverride |
| top-level / `net/lostluma/dynamic_fps/impl/fabric/service/FabricPlatform.java` | `` |  | getName, getCacheDir, getConfigDir, isDevelopmentEnvironment, isModLoaded, getModVersion, registerStartTickEvent, ensureDir |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/compat/ClothConfig.java` | `` |  | genConfigScreen, idleTimeMessage, getVolumeStepTransformer, volumeTransitionMessage, getFpsTransformer, fpsTargetMessage, valueAsPercentMessage, ignoreInitialClickMessage, IdleConditionMessage, idleConditionTooltip, graphicsStateMessage, batteryIndicatorConditionMessage, batteryIndicatorPlacementMessage, graphicsStateTooltip |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/compat/GLFW.java` | `` |  | applyWorkaround, useWorkaround, isEnterEventBroken |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/config/BatteryTrackerConfig.java` | `` |  | enabled, setEnabled, criticalLevel, setCriticalLevel, switchStates, setSwitchStates, notifications, setNotifications, showWhenDebug, setShowWhenDebug, display, condition, setCondition, placement, setPlacement, isActive |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/config/Config.java` | `` |  | frameRateTarget, setFrameRateTarget, enableVsync, setEnableVsync, volumeMultiplier, rawVolumeMultiplier, setVolumeMultiplier, soundSourceName, graphicsState, setGraphicsState, showToasts, setShowToasts, runGarbageCollector, setRunGarbageCollector |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/config/DynamicFPSConfig.java` | `` |  | get, enabled, setEnabled, idle, batteryTracker, volumeTransitionSpeed, uncapMenuFrameRate, setUncapMenuFrameRate, ignoreInitialClick, setIgnoreInitialClick, downloadNatives, setDownloadNatives, mockBatteryData, setMockBatteryData, save |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/config/IdleConfig.java` | `` |  | timeout, setTimeout, condition, setCondition |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/config/option/BatteryIndicatorCondition.java` | `` |  | isConditionMet |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/config/option/BatteryIndicatorPlacement.java` | `` |  | values, valueOf, get |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/config/option/GraphicsState.java` | `` |  |  |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/config/option/IdleCondition.java` | `` |  |  |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/config/option/IgnoreInitialClick.java` | `` |  |  |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/config/Serialization.java` | `` |  | save, write, move, removeUnchangedFields, loadPersonalized, loadDefault, upgradeConfig, addMissingFields, upgradeVolumeMultiplier, upgradeIdleConfig, getStatesAsObject |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/config/VolumeTransitionConfig.java` | `` |  | getUp, setUp, getDown, setDown, isActive |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/Constants.java` | `` |  |  |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/DynamicFPSMod.java` | `` |  | init, disabledByUser, getWindow, getClickHandler, isDisabled, whyIsTheModNotWorking, toggleDisabled, onConfigChanged, getConfigScreen, onStatusChanged, powerState, isForcingLowFPS, toggleForceLowFPS, setWindow, checkForRender, renderedCurrentFrame, targetFrameRate, enableVsync, volumeMultiplier, shouldShowToasts, graphicsState, shouldShowLevels, onBatteryChargeChanged, onBatteryStatusChanged, doInit, initClickHandler, showNotification, isLevelCoveredByOverlay, handleStateChange, checkForStateChanges, checkForStateChanges0, checkForRender |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/feature/battery/BaseToast.java` | `` |  | getWantedVisibility, update, extractRenderState, onFirstRender |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/feature/battery/BatteryToast.java` | `` |  | queueToast, onFirstRender |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/feature/battery/BatteryTracker.java` | `` |  | charge, status, hasBatteries, init, close, isFeatureEnabled, updateState, updateBatteries, customizeInstallation, createManager, getSystemBatteryView |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/feature/battery/ErrorToast.java` | `` |  | queueToast |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/feature/state/ClickIgnoreHandler.java` | `` |  | isFeatureActive, shouldIgnoreClick, onFocused |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/feature/state/IdleHandler.java` | `` |  | init, onActivity, isIdle, checkActivity, checkPlayerActivity |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/feature/state/OptionHolder.java` | `` |  | copyOptions, applyOptions |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/feature/state/WindowObserver.java` | `` |  | isFocused, isHovered, isIconified, onEvent |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/feature/volume/SmoothVolumeHandler.java` | `` |  | init, onStateChange, volumeMultiplier, tickVolumes, updateVolume |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/mixin/bugfix/BlockableEventLoopMixin.java` | `value={BlockableEventLoop.class})` | Overwrite:1 | waitForTasks |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/mixin/DebugEntryFpsMixin.java` | `value={DebugEntryFps.class})` | WrapOperation:1 | display |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/mixin/FramerateLimitTrackerMixin.java` | `value={FramerateLimitTracker.class})` | Inject:2 | getFramerateLimit, getMenuFramerateLimit, getFramerateTarget, getMenuFramerateLimit, isInLevel |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/mixin/GuiMixin.java` | `value={Gui.class})` | Inject:1 | setScreen |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/mixin/HudMixin.java` | `value={Hud.class})` | Inject:1 | extractCrosshair |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/mixin/LoadingOverlayMixin.java` | `value={LoadingOverlay.class})` |  | dynamic_fps$isReloadComplete |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:2, WrapMethod:1, WrapOperation:1 | onInit, renderFrame, renderFrame, close |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/mixin/OptionsMixin.java` | `value={Options.class})` | Inject:2, ModifyReturnValue:1 | save0, save1, getSoundSourceVolume |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/mixin/SDLEventHandlerMixin.java` | `value={SDLEventHandler.class})` | Inject:2 | pollEvents, handleMouseButtonEvent |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/mixin/SoundEngineMixin.java` | `value={SoundEngine.class})` | Inject:2 | calculateVolume, dynamic_fps$updateVolume, play, playDelayed, dynamic_fps$resumeMusic |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/mixin/ToastManagerMixin.java` | `value={ToastManager.class})` | Inject:1 | freeSlotCount |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/PowerState.java` | `` |  |  |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/service/ModCompat.java` | `` |  | getInstance |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/service/Platform.java` | `` |  | getInstance |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/service/Services.java` | `` |  |  |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/util/BatteryUtil.java` | `` |  | isCharging |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/util/Components.java` | `` |  | translationKey, literal, translatable, translatable |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/util/duck/DuckLoadingOverlay.java` | `` |  |  |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/util/duck/DuckSoundEngine.java` | `` |  |  |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/util/FallbackConfigScreen.java` | `` |  | init, extractRenderState, onClose |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/util/HudInfoRenderer.java` | `` |  | renderInfo, drawCenteredText, drawBatteryOverlay |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/util/JsonUtil.java` | `` |  | toJson, toJson, toJsonTree, fromJson, fromJson, serialize, deserialize |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/util/KeyMappingHandler.java` | `` |  | getHandlers, keyMapping, onStartTick |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/util/Logging.java` | `` |  | getLogger |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/util/ResourceLocations.java` | `` |  | of |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/util/Threads.java` | `` |  | runOnMainThread, create |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/util/VariableStepTransformer.java` | `` |  | addStep, toStep, toValue, sortSteps, compare, Step |
| META-INF/jars/dynamic-fps-3.11.10+minecraft-26.3.0-common.jar / `dynamic_fps/impl/util/Version.java` | `` |  | of, of, major, minor, patch, isPreRelease, preRelease, hasBuildMetadata, buildMetadata, toString, compareTo |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
