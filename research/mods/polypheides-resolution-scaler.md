# Polypheides Resolution Scaler

Review status: **Evidence inventory; behavioral review pending**

Project: [Polypheides Resolution Scaler](https://modrinth.com/mod/polypheides-resolution-scaler)
Selected artifact version: `1.2.3+mc26.3`
Published implementation source: https://github.com/Polypheides/Polypheides-Resolution-Scaler.git
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Allows you to change your 3D game resolution without affecting the user interface.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `2511a9eae47626221d60819c3b38c12a7e4dbd6f`
- `sha512`: `5284f45f85aac3e6e4d8eba035edb10e69070d41ef27248a463433a795f514f48d9dfbf889638b95bef52f2c6accc5827833ae5a1408265cde81d502d3db21ee`

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
    "com.polypheides.resolutionscaler.ResolutionScaler"
  ],
  "sodium:config_api_user": [
    "com.polypheides.resolutionscaler.integration.PrsSodiumConfig"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": "~26.3-beta.1",
  "java": ">=25",
  "fabric-api": ">=0.159.1+26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/polypheides/resolutionscaler/integration/PrsSodiumConfig.java` | `` |  | registerConfigEarly, registerConfigLate |
| top-level / `com/polypheides/resolutionscaler/mixin/GameRendererMixin.java` | `value={GameRenderer.class})` | Inject:2 | onRenderLevelHead, onRenderLevelReturn |
| top-level / `com/polypheides/resolutionscaler/mixin/GlobalSettingsUniformMixin.java` | `value={GlobalSettingsUniform.class})` | ModifyVariable:2 | modifyWidth, modifyHeight |
| top-level / `com/polypheides/resolutionscaler/mixin/SkyRendererMixin.java` | `value={SkyRenderer.class})` | Redirect:1 | redirectGetRenderTarget |
| top-level / `com/polypheides/resolutionscaler/mixin/VideoSettingsScreenMixin.java` | `value={VideoSettingsScreen.class})` | Inject:1 | injectResolutionOption |
| top-level / `com/polypheides/resolutionscaler/ResolutionScaler.java` | `` |  | scale, scale, resizeTarget, onInitializeClient, loadConfig, saveConfig |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
