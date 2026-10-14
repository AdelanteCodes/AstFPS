# FluidCam

Review status: **Evidence inventory; behavioral review pending**

Project: [FluidCam](https://modrinth.com/mod/fluidcam)
Selected artifact version: `1.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

FluidCam is a Fabric mod that smooths out camera and mouse movement, making PvP and general gameplay feel more fluid and responsive.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `94fc6faf7bc5629a31f970d8fa4a6a5b6b5a37ba`
- `sha512`: `01d73b7c67d43352f270bbbfa6504ebdb600add573809b67b7c6f36f8b8e31937ad8cfe1c78b417bfa7ac798b4278df5b1dbccf468051f1c10cced809b88a120`

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
    "net.fluidcam.FluidCamClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.15.0",
  "minecraft": ">=1.21 <=27.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/fluidcam/FluidCamClient.java` | `` |  | onInitializeClient |
| top-level / `net/fluidcam/FluidCamConfig.java` | `` |  | get, load, save, parseBoolean, parseDouble, parseInt |
| top-level / `net/fluidcam/FluidCamEngine.java` | `` |  | processLook, onKey |
| top-level / `net/fluidcam/mixin/KeyboardMixin.java` | `value={class_309.class})` | Inject:1 | onKeyInput |
| top-level / `net/fluidcam/mixin/MouseMixin.java` | `value={class_312.class})` | Redirect:1 | redirectChangeLookDirection |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
