# QuickTrigger

Review status: **Evidence inventory; behavioral review pending**

Project: [QuickTrigger](https://modrinth.com/mod/quicktrigger)
Selected artifact version: `1.3.0`
Published implementation source: https://github.com/DylanDelobel/QuickTrigger
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Adds Spawn and Home teleport buttons directly to your inventory, made for the VanillaTweaks Homes & Spawn datapacks

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `dec9cdaa8c98e9742c9db39c5de3c772d02565a0`
- `sha512`: `3aca2a4bf5eb6f5a5a9ceed03256da1c4addf9663b9a153473d5dd8304e94de5359c78e0a96393b77f6e60b6db4c4bff5076a343673ad55487a249deabda87b2`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 13
Reconstructed Java files: 9

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.quicktrigger.QuickTrigger"
  ],
  "client": [
    "com.quicktrigger.QuickTriggerClient"
  ],
  "modmenu": [
    "com.quicktrigger.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "~26.3",
  "java": ">=21"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/quicktrigger/ClientState.java` | `` |  |  |
| top-level / `com/quicktrigger/ConfigDirProvider.java` | `` |  |  |
| top-level / `com/quicktrigger/ConfigScreen.java` | `` |  | serverKey, init, extractRenderState, shouldCloseOnEsc, onClose, safeStack |
| top-level / `com/quicktrigger/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/quicktrigger/QuickTrigger.java` | `` |  | onInitialize, sendLimit |
| top-level / `com/quicktrigger/QuickTriggerClient.java` | `` |  | resolveServerKey, homeTooltip, command, onInitializeClient, onClick, extractWidgetRenderState, updateWidgetNarration |
| top-level / `com/quicktrigger/QuickTriggerConfig.java` | `` |  | init, getColor, setColor, getNamesForServer, getItemStack, load, save, fromName, toString |
| top-level / `com/quicktrigger/QuickTriggerPayloads.java` | `` |  | type |
| top-level / `com/quicktrigger/QuickTriggerServerConfig.java` | `` |  | init, load, save |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
