# No More Pop-ups

Review status: **Evidence inventory; behavioral review pending**

Project: [No More Pop-ups](https://modrinth.com/mod/no-more-popups)
Selected artifact version: `2.3.1`
Published implementation source: https://github.com/Alfakynz/No-More-Popups/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A Minecraft mod to remove in-game pop-ups

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `d9db0f4e83b691d6d21a05ba1c3ab242d97f77f4afde7ade538a970ffd231c71f97f153a6423f7e5b7bd8d2b50f03972f113a3f403bd26b910e778c76ec52857`
- `sha1`: `96c03e26539c520a97454e8b263e78598cde1019`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 22
Reconstructed Java files: 21

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.alfakynz.nomorepopups.NoMorePopupsFabric"
  ],
  "modmenu": [
    "com.alfakynz.nomorepopups.config.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "minecraft": ">=26.2",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/alfakynz/nomorepopups/config/ConfigSettings.java` | `` |  | generalSetting, moddedSetting, Setting |
| top-level / `com/alfakynz/nomorepopups/config/ModConfig.java` | `` |  | createDefault, load, save, migrateOldFormat, map, general, modded, ensureDefaults |
| top-level / `com/alfakynz/nomorepopups/config/ModConfigScreen.java` | `` |  | create |
| top-level / `com/alfakynz/nomorepopups/config/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/alfakynz/nomorepopups/Constants.java` | `` |  |  |
| top-level / `com/alfakynz/nomorepopups/mixin/AccessibilityMixin.java` | `value={AccessibilityOnboardingScreen.class})` | Inject:1 | nomorepopups$skipOnboarding |
| top-level / `com/alfakynz/nomorepopups/mixin/accessor/SystemToastAccessor.java` | `value={SystemToast.class})` | Accessor:2 |  |
| top-level / `com/alfakynz/nomorepopups/mixin/AdvancementMixin.java` | `value={ClientPacketListener.class})` | Inject:1 | onGameMessage |
| top-level / `com/alfakynz/nomorepopups/mixin/compat/ModdedMessageClientMixin.java` | `value={LocalPlayer.class})` | Inject:2 | onSendSystemMessage, onSendOverlayMessage, no_More_Popups$handleMessage |
| top-level / `com/alfakynz/nomorepopups/mixin/compat/ModdedMessageServerMixin.java` | `value={ClientPacketListener.class})` | Inject:1 | onSystemChat |
| top-level / `com/alfakynz/nomorepopups/mixin/compat/ModdedToastMixin.java` | `value={ToastManager.class})` | Inject:1 | blockFrozenLibToasts |
| top-level / `com/alfakynz/nomorepopups/mixin/ExperimentalMixin.java` | `value={WorldOpenFlows.class})` | ModifyVariable:1 | removeExperimentalWarning |
| top-level / `com/alfakynz/nomorepopups/mixin/ExperimentalWorldMixin.java` | `value={PrimaryLevelData.class})` | Inject:1 | disableExperimentalWorldWarning |
| top-level / `com/alfakynz/nomorepopups/mixin/OptionsMixin.java` | `value={Options.class})` | Inject:2 | nomorepopups$onLoad, nomorepopups$onSave |
| top-level / `com/alfakynz/nomorepopups/mixin/ResourcePackMixin.java` | `value={PackCompatibility.class})` | Inject:1 | alwaysCompatible |
| top-level / `com/alfakynz/nomorepopups/mixin/ToastManagerMixin.java` | `value={ToastManager.class})` | Inject:4 | blockRecipeToast, blockTutorialToast, blockAdvancementToast, blockSystemToast, no_More_Popups$flatten |
| top-level / `com/alfakynz/nomorepopups/NoMorePopups.java` | `` |  | init |
| top-level / `com/alfakynz/nomorepopups/NoMorePopupsFabric.java` | `` |  | onInitialize |
| top-level / `com/alfakynz/nomorepopups/platform/FabricPlatformHelper.java` | `` |  | getPlatformName, isModLoaded, isDevelopmentEnvironment |
| top-level / `com/alfakynz/nomorepopups/platform/services/IPlatformHelper.java` | `` |  |  |
| top-level / `com/alfakynz/nomorepopups/platform/Services.java` | `` |  | load |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
