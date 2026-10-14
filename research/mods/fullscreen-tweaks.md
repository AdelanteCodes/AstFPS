# Fullscreen Tweaks

Review status: **Evidence inventory; behavioral review pending**

Project: [Fullscreen Tweaks](https://modrinth.com/mod/fullscreen-tweaks)
Selected artifact version: `2.0.1+26.3-fabric`
Published implementation source: https://github.com/oggvik/stop-minimizing-on-focus-loss-mc
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Expands Minecraft's window settings with native and borderless fullscreen modes, customizable focus-loss behavior, and independent loading-screen options — including staying minimized until the game finishes launching!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `0d1f0f00176d3c4137d6e23e317d81dfad15de82`
- `sha512`: `ed521e7170f5c7c075e40763d9fcda8015ab6d44bfe6a79c2583e5bb091f685b23f818e4d857b59a26a56d0e3db07223020864e8d4e9f38f70808c426d54c478`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 22
Reconstructed Java files: 20

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "oggvik.mods.fullscreentweaks.platform.PlatformEntrypoint"
  ],
  "modmenu": [
    "oggvik.mods.fullscreentweaks.platform.ModMenuEntrypoint"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/fabric-api-base-2.0.6+fcdff87f5d.jar` | 17 | `fabric-api-base` | No |
| `META-INF/jars/fabric-resource-loader-v1-3.0.4+fcdff87f5d.jar` | 77 | `fabric-resource-loader-v1` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `oggvik/mods/fullscreentweaks/client/ButtonPlacement.java` | `` |  | find, fits |
| top-level / `oggvik/mods/fullscreentweaks/client/FullscreenSettingsScreen.java` | `` |  | init, tick, updateExclusiveFullscreenTooltip, addControl, addLoadingModeControl, addTooltip, addWidget, selectFullscreenMode, togglePrevention, selectLoadingMode, toggleStartMinimized, saveAndRefresh, preventionLabel, startMinimizedLabel, radioLabel, fallbackTooltip, translate, sectionHeading, onClose, extractRenderState, contains |
| top-level / `oggvik/mods/fullscreentweaks/client/SettingsButtonHost.java` | `` |  |  |
| top-level / `oggvik/mods/fullscreentweaks/config/FullscreenMode.java` | `` |  | platformDefault, parse |
| top-level / `oggvik/mods/fullscreentweaks/config/FullscreenSettings.java` | `` |  | defaults, getFullscreenMode, isPreventAutoIconify, getLoadingScreenMode, isStartMinimized, withFullscreenMode, withPreventAutoIconify, withLoadingScreenMode, withStartMinimized, parseBoolean |
| top-level / `oggvik/mods/fullscreentweaks/config/LoadingScreenMode.java` | `` |  | next, parse |
| top-level / `oggvik/mods/fullscreentweaks/config/SettingsManager.java` | `` |  | initialize, get, set, configPath, legacyConfigPath, configDirectory, warn |
| top-level / `oggvik/mods/fullscreentweaks/FullscreenTweaks.java` | `` |  | init |
| top-level / `oggvik/mods/fullscreentweaks/mixins/GuiMixin.java` | `value={Gui.class})` | Inject:1 | fullscreenTweaks$restoreModeAfterLoading |
| top-level / `oggvik/mods/fullscreentweaks/mixins/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:2 | fullscreenTweaks$applyLoadingWindowSettings, fullscreenTweaks$restoreAfterLoadingResources |
| top-level / `oggvik/mods/fullscreentweaks/mixins/OptionsScreenMixin.java` | `value={OptionsScreen.class})` | Inject:1 | fullscreenTweaks$addSettingsButton, fullscreenTweaks$placeSettingsButton, fullscreenTweaks$bounds, fullscreenTweaks$openSettings |
| top-level / `oggvik/mods/fullscreentweaks/mixins/ScreenLayoutMixin.java` | `value={Screen.class})` | Inject:1 | fullscreenTweaks$layout |
| top-level / `oggvik/mods/fullscreentweaks/mixins/WidgetBoundsAccessor.java` | `value={AbstractWidget.class})` | Accessor:7 |  |
| top-level / `oggvik/mods/fullscreentweaks/mixins/WindowMixin.java` | `value={Window.class})` | ModifyVariable:1, Inject:3, ModifyArg:1 | fullscreenTweaks$selectLoadingWindowMode, fullscreenTweaks$applySettingsAfterCreate, fullscreenTweaks$applySettingsAfterModeChange, fullscreenTweaks$configureInitialWindowFlags, fullscreenTweaks$applyFocusLossPolicy, fullscreenTweaks$applyWindowPolicy |
| top-level / `oggvik/mods/fullscreentweaks/mixins/WindowModeAccessor.java` | `value={Window.class})` | Accessor:2, Invoker:1 |  |
| top-level / `oggvik/mods/fullscreentweaks/platform/MinecraftWindowBridge.java` | `` |  | createFullscreenButton, createExclusiveFullscreenButton, exclusiveFullscreenSetting, fullscreenSetting, startMinimizedSupported, setFullscreenSetting, showScreen, reapply, minecraftWindow |
| top-level / `oggvik/mods/fullscreentweaks/platform/ModMenuEntrypoint.java` | `` |  | getModConfigScreenFactory |
| top-level / `oggvik/mods/fullscreentweaks/platform/PlatformEntrypoint.java` | `` |  | onInitializeClient |
| top-level / `oggvik/mods/fullscreentweaks/window/SdlWindowController.java` | `` |  | supportsStartupMinimized, apply, handleFocusChanged, shouldMinimizeOnFocusLoss, minimize, restore |
| top-level / `oggvik/mods/fullscreentweaks/window/StartupWindowController.java` | `` |  | prepareLoading, reapplyLoadingState, reapplyLoadingMinimized, reapplyLoadingMode, configureInitialWindowFlags, restoreAfterLoadingResources, finishLoading, restoreStartupMinimized, minimize, restore |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
