# Basic Macros

Review status: **Evidence inventory; behavioral review pending**

Project: [Basic Macros](https://modrinth.com/mod/auto-keybinds)
Selected artifact version: `0.0.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This project adds autonomous keybinds for when you go AFK...

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `344745801996f634892f8328e8fc3d078d3dc014`
- `sha512`: `2a0d5ef3f4c6aac7a1d5c43192bb4a962d8e30a329d5bbf27c73b890121f961ce08aed3b397e046044410b829571c70b8167319edd42c71d9daecd18dbce14e8`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 11
Reconstructed Java files: 9

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.orcaengine.auto_keybind_1b657fd6.client.AutoKeybindClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/orcaengine/auto_keybind_1b657fd6/client/AutoKeybindClient.java` | `` |  | onInitializeClient, setScreen |
| top-level / `com/orcaengine/auto_keybind_1b657fd6/client/AutoKeybindConfig.java` | `` |  | rules, load, save, path |
| top-level / `com/orcaengine/auto_keybind_1b657fd6/client/AutoKeybindManager.java` | `` |  | initialize, config, onKeyPress, stopAll, save, consumeOpenRequest |
| top-level / `com/orcaengine/auto_keybind_1b657fd6/client/AutoKeybindScreen.java` | `` |  | init, addRuleRow, keyPressed, onClose, refresh, addDrawableChild, keyName |
| top-level / `com/orcaengine/auto_keybind_1b657fd6/client/TargetAction.java` | `` |  | label, next, keyMapping |
| top-level / `com/orcaengine/auto_keybind_1b657fd6/mixin/GuiMixin.java` | `value={Gui.class})` | Inject:1 | stopAutoKeybindsForScreens |
| top-level / `com/orcaengine/auto_keybind_1b657fd6/mixin/KeyboardHandlerMixin.java` | `value={KeyboardHandler.class})` | Inject:1 | handleAutoKeybind |
| top-level / `com/orcaengine/auto_keybind_1b657fd6/mixin/PauseScreenMixin.java` | `value={PauseScreen.class})` | Inject:1 | addAutoKeybindButton |
| top-level / `com/orcaengine/auto_keybind_1b657fd6/mixin/TitleScreenMixin.java` | `value={TitleScreen.class})` | Inject:1 | addAutoKeybindButton |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
