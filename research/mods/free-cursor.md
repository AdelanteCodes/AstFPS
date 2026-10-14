# Free Cursor

Review status: **Evidence inventory; behavioral review pending**

Project: [Free Cursor](https://modrinth.com/mod/free-cursor)
Selected artifact version: `1.3.1+mc26.3`
Published implementation source: https://github.com/Makev1ch/freecursor
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Instantly unlock your cursor with a configurable keybind

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `733811eeeec0ee5fed0d5799e4510e6adc33c2ed`
- `sha512`: `aa9cc023059644fb77bea8f7aa9e90f2400680820c30d713853a23e4214ca329980fe5d526bfa19e4af00580974843ac24f75ddc5cef585c5f46ac436159624a`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 6
Reconstructed Java files: 6

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.makev1ch.freecursor.FreeCursor"
  ],
  "client": [
    "com.makev1ch.freecursor.FreeCursorClient"
  ],
  "modmenu": [
    "com.makev1ch.freecursor.FreeCursorModMenuIntegration"
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
| top-level / `com/makev1ch/freecursor/FreeCursor.java` | `` |  | onInitialize |
| top-level / `com/makev1ch/freecursor/FreeCursorClient.java` | `` |  | onInitializeClient, getFreeCursorKey |
| top-level / `com/makev1ch/freecursor/FreeCursorConfig.java` | `` |  | getInstance, load, save, isSimulateF1, setSimulateF1, isDisableBlur, setDisableBlur |
| top-level / `com/makev1ch/freecursor/FreeCursorConfigScreen.java` | `` |  | init, updateButtonTexts, extractRenderState, onClose, isPauseScreen, isAllowedInPortal |
| top-level / `com/makev1ch/freecursor/FreeCursorModMenuIntegration.java` | `` |  | getModConfigScreenFactory, createConfigScreen |
| top-level / `com/makev1ch/freecursor/FreeCursorScreen.java` | `` |  | extractRenderState, isPauseScreen, isAllowedInPortal, mouseClicked, keyPressed, closeScreen, removed |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
