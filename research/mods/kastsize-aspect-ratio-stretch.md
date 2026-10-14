# KastSize — Aspect Ratio Stretch

Review status: **Evidence inventory; behavioral review pending**

Project: [KastSize — Aspect Ratio Stretch](https://modrinth.com/mod/kastsize-aspect-ratio-stretch)
Selected artifact version: `1.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Aspect ratio stretch presets + custom mode for a “stretched” competitive look.  (растяг экрана)

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `0019ffc9b0cc9113a8ea3ac05e4239c51d874d19`
- `sha512`: `e64a46fb31b16a74090b299d409832bebe33e5dd81472eae0842d44a57820aa36e7488984a0f64c23a6ce3965da0bd9004d7c6c61e8b303c7b140d06d5c85357`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 9
Reconstructed Java files: 9

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.kast1ent.kastsize.client.KastSizeClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "26.3",
  "java": ">=25",
  "fabric-api": ">=0.160.5+26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/kast1ent/kastsize/AspectPreset.java` | `` |  | getAspectRatio, getDisplayName, byNameOrDefault |
| top-level / `com/kast1ent/kastsize/client/AspectSliderWidget.java` | `` |  | toSliderValue, fromSliderValue, getAspect, updateMessage, applyValue |
| top-level / `com/kast1ent/kastsize/client/KastSizeClient.java` | `` |  | onInitializeClient, onClientTick, toggleStretch, isStretchEnabled, getTargetAspectRatio |
| top-level / `com/kast1ent/kastsize/client/KastSizeScreen.java` | `` |  | init, onClose, isPauseScreen, customAspectText, disableShakeText, stateText |
| top-level / `com/kast1ent/kastsize/KastSize.java` | `` |  | init, getConfig, setConfig, getConfigPath, loadConfig, saveConfig |
| top-level / `com/kast1ent/kastsize/KastSizeConfig.java` | `` |  | getPresetEnum, setPreset, normalize |
| top-level / `com/kast1ent/kastsize/mixin/BackgroundRendererMixin.java` | `targets={"net.minecraft.client.render.BackgroundRenderer"})` |  |  |
| top-level / `com/kast1ent/kastsize/mixin/GameRendererMixin.java` | `value={Projection.class})` | Inject:1 | kastsize$modifyProjection |
| top-level / `com/kast1ent/kastsize/mixin/GameRendererShakeMixin.java` | `value={GameRenderer.class})` | Inject:2 | kastsize$shakeOff, kastsize$bobView, kastsize$bobHurt |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
