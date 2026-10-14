# SettingsManagerLib

Review status: **Evidence inventory; behavioral review pending**

Project: [SettingsManagerLib](https://modrinth.com/mod/settingsmanagerlib)
Selected artifact version: `1.1.3+26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A simple, easy-to-set-up config library using YACL and Mod Menu to create simple or complex config menus

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `55595d65947c090784b15a31df6c811b73d853982f5e3d94d466cae974127805c1c4f8f31bb60f6ea36e156b954cd980fa3f3987130cd7af591137b45825fc86`
- `sha1`: `32265fde34249151fb20f36684e8473b20c1358b`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 12
Reconstructed Java files: 7

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.github.wyzzard225.settingsmanager.client.SettingsmanagerClient"
  ],
  "main": [
    "com.github.wyzzard225.settingsmanager.Settingsmanager"
  ],
  "modmenu": [
    "com.github.wyzzard225.settingsmanager.client.ModMenuAPI"
  ]
}
```

**depends**

```json
{
  "yet_another_config_lib_v3": ">=3.9.7+26.3-fabric",
  "fabricloader": ">=0.18",
  "minecraft": ">=26.3 <30"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/github/wyzzard225/settingsmanager/client/CustomConfigScreen.java` | `` |  | create |
| top-level / `com/github/wyzzard225/settingsmanager/client/Enums.java` | `` |  | itemFromString, itemFromEnum |
| top-level / `com/github/wyzzard225/settingsmanager/client/ExampleClient.java` | `` |  | onInitializeClient |
| top-level / `com/github/wyzzard225/settingsmanager/client/ModMenuAPI.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/github/wyzzard225/settingsmanager/client/Settings.java` | `` |  | resetSettings, setup, cleanup, orderGroups, orderOptions, expandGroup, expandGroups, collapseGroup, collapseGroups, registerValue, registerValue, registerValue, add, add, add, add, addSlider, addSlider, addSlider, addSlider, add, add, add, add, addColor, addColor, add, add, add, add, hide, show, delete, hideGroup, showGroup, get, get, get, get, get, loadFromFile, saveToFile, set, getChroma, importSettings, getConfig, createEnumOption, registerSaveEvent, registerAutoSaveEvent, executeSaveRunnables, executeAutoSaveRunnables, autoSaveChanged, refreshGui |
| top-level / `com/github/wyzzard225/settingsmanager/client/SettingsmanagerClient.java` | `` |  | onInitializeClient, configSaved |
| top-level / `com/github/wyzzard225/settingsmanager/Settingsmanager.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
