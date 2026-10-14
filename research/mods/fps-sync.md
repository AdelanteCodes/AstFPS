# FPS-Sync (FPS Limiter)

Review status: **Evidence inventory; behavioral review pending**

Project: [FPS-Sync (FPS Limiter)](https://modrinth.com/mod/fps-sync)
Selected artifact version: `1.0.0`
Published implementation source: https://github.com/ItsPasi/fps-sync
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Limits FPS to the monitors refresh rate without V-Sync.
Adds the option to limit framerate up to 1000 FPS.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `5824f79439ae9ac6d61a6e226f49883b59d8b66b`
- `sha512`: `15b75ade0010335dbbf5ffc6786e3a8f604b0da158857fcfa4833b68497592633298c3b20b67eb2b07b6b5b737fba96674f70c2fd8ff1729fbbe284c73c7c786`

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
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.fpssync.FpsSyncMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "minecraft": ">=26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/fpssync/FpsSyncMod.java` | `` |  | onInitializeClient |
| top-level / `com/fpssync/FrameLimiter.java` | `` |  | setEnabled, setManualLimit, limitFrame |
| top-level / `com/fpssync/mixin/GameRendererMixin.java` | `value={GameRenderer.class})` | Inject:1 | onFrameEnd |
| top-level / `com/fpssync/mixin/OptionsMixin.java` | `value={Options.class})` | Inject:1 | overrideFpsSlider |
| top-level / `com/fpssync/mixin/SodiumConfigBuilderMixin.java` | `value={SodiumConfigBuilder.class}, remap=false)` | Redirect:2 | redirectFpsSliderRange, redirectFpsValueFormatter |
| top-level / `com/fpssync/MonitorInfoProvider.java` | `` |  | updateDisplayInfo, getRefreshRate, detectRefreshRate |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
