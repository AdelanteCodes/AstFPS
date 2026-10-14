# AirPlace

Review status: **Evidence inventory; behavioral review pending**

Project: [AirPlace](https://modrinth.com/mod/airplace)
Selected artifact version: `1.1.1`
Published implementation source: https://github.com/wueffi/AirPlace
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Simple Mod that let's you place Blocks in air.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `6ca3eda2f39d48d20247e95bd2c4403efbd26e72`
- `sha512`: `552ca7b4be445221fab360f24d394733130709400c6513dfd277755a561acffeda1cd6d7158eb0e61353bf9a44eab11a709b0adf44d4d37bcdf769f733b3f36f`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 8
Reconstructed Java files: 7

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "wueffi.airplace.client.AirPlaceClient"
  ],
  "main": [
    "wueffi.airplace.AirPlaceMain"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "fabric-api": "*",
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `wueffi/airplace/AirPlaceMain.java` | `` |  | onInitialize |
| top-level / `wueffi/airplace/client/AirPlaceClient.java` | `` |  | onInitializeClient |
| top-level / `wueffi/airplace/client/AirPlaceCommand.java` | `` |  | register |
| top-level / `wueffi/airplace/client/AirPlaceConfig.java` | `` |  | load, save, saveDefault, setColor, setSpeed, setActive, setRenderMode, getSpeed |
| top-level / `wueffi/airplace/client/OutlineRenderer.java` | `` |  | render |
| top-level / `wueffi/airplace/client/PlacementHandler.java` | `` |  | tick |
| top-level / `wueffi/airplace/client/UpdateHandler.java` | `` |  | initialize, checkForUpdates, containsString, compareVersions, parseIntSafe |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
