# YugiTotem

Review status: **Evidence inventory; behavioral review pending**

Project: [YugiTotem](https://modrinth.com/mod/yugitotem)
Selected artifact version: `1.3.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

YugiTotem is a custom Minecraft Fabric client-side mod focused on improving gameplay with useful features, smooth animations, quality-of-life improvements, and customizable tools

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `e728cbc679e514c8aa939201f2bd389e9de25ddf`
- `sha512`: `ab23dcfe8227b55df26e9526da72d41643f91eaa0805cd230792ebdd020038ee9f44badcc904d988ea3c09ddb8aab9820ad98611ebf2af523ef804caac4a616a`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 30
Reconstructed Java files: 24

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.yugiyx.yugitotem.YugiTotemClient"
  ],
  "modmenu": [
    "com.yugiyx.yugitotem.YugiTotemModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "=26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/yugiyx/yugitotem/auth/MicrosoftAuth.java` | `` |  | requestDeviceCode, pollDeviceCode, refresh, loginToMinecraft, postJson, getJson, sendJson, urlEncode, DeviceCode, MsaTokens, McSession |
| top-level / `com/yugiyx/yugitotem/auth/SessionRefreshManager.java` | `` |  | startBackgroundChecks, checkAndRefreshIfNeeded, refreshNow, applySession |
| top-level / `com/yugiyx/yugitotem/IconTextures.java` | `` |  | draw, load |
| top-level / `com/yugiyx/yugitotem/ImageProcessor.java` | `` |  | processToSquare, toArgb |
| top-level / `com/yugiyx/yugitotem/mixin/ConnectScreenMixin.java` | `value={ConnectScreen.class})` | Inject:1 | yugitotem$disconnectExistingConnection |
| top-level / `com/yugiyx/yugitotem/mixin/GameOptionsMixin.java` | `value={Options.class})` | Inject:1 | yugitotem$prepareInitialPack |
| top-level / `com/yugiyx/yugitotem/mixin/MinecraftClientSessionAccessor.java` | `value={Minecraft.class})` | Accessor:1 |  |
| top-level / `com/yugiyx/yugitotem/mixin/WindowIconAccessor.java` | `value={Window.class})` | Invoker:1 |  |
| top-level / `com/yugiyx/yugitotem/ModuleMenuScreen.java` | `` |  | init, cardOrigin, extractRenderState, mouseClicked, onClose |
| top-level / `com/yugiyx/yugitotem/MultiplayerAccessScreen.java` | `` |  | init, extractRenderState, isCurrentServer, mouseClicked, mouseScrolled, joinServer, onClose |
| top-level / `com/yugiyx/yugitotem/NamePresetScreen.java` | `` |  | init, confirm, stripExtension, extractRenderState, onClose |
| top-level / `com/yugiyx/yugitotem/PlatformCompat.java` | `` |  | currentScreen, setScreen, openUri |
| top-level / `com/yugiyx/yugitotem/Preset.java` | `` |  | vanilla, defaultPreset, lizka, isVanilla |
| top-level / `com/yugiyx/yugitotem/PresetStore.java` | `` |  | presetsDir, addCustomPreset, customPresetFile, deleteCustomPresetFile |
| top-level / `com/yugiyx/yugitotem/SessionLoginScreen.java` | `` |  | init, beginLogin, extractRenderState, wrap, onClose, shouldCloseOnEsc |
| top-level / `com/yugiyx/yugitotem/ThumbnailManager.java` | `` |  | get, invalidate, loadNativeImage, sanitize |
| top-level / `com/yugiyx/yugitotem/TotemPackManager.java` | `` |  | packRoot, prepareStartup, finishStartup, applyConfig, isEnabled, preparePack, readBundledResource, writePackIfDifferent, writeIfDifferent, removeStaleModelOverride, syncOptions, PreparedPack |
| top-level / `com/yugiyx/yugitotem/WindowIconApplier.java` | `` |  | apply |
| top-level / `com/yugiyx/yugitotem/YugiTotemClient.java` | `` |  | onInitializeClient, getOpenGuiKey, getOpenModuleMenuKey, addMultiplayerButton |
| top-level / `com/yugiyx/yugitotem/YugiTotemConfig.java` | `` |  | load, ensureDefaults, getSelected, save |
| top-level / `com/yugiyx/yugitotem/YugiTotemConfigScreen.java` | `` |  | displayedPresets, init, maxPage, extractRenderState, drawDeleteBadge, mouseClicked, selectPreset, deletePreset, openFileChooser, onPresetNamed, onClose |
| top-level / `com/yugiyx/yugitotem/YugiTotemModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `org/lwjgl/util/tinyfd/package-info.java` | `` |  |  |
| top-level / `org/lwjgl/util/tinyfd/TinyFileDialogs.java` | `` |  | tinyfd_getGlobalInt, tinyfd_getGlobalInt, tinyfd_setGlobalInt, tinyfd_setGlobalInt, tinyfd_notifyPopup, tinyfd_notifyPopup, tinyfd_messageBox, tinyfd_messageBox |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
