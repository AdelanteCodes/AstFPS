# ZoomHehe

Review status: **Evidence inventory; behavioral review pending**

Project: [ZoomHehe](https://modrinth.com/mod/zoomhehe)
Selected artifact version: `4.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A lightweight, smooth, and fully customizable OptiFine-style cinematic zoom mod for Fabric.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `077f1333b9e3f153acb401bae02da7618593b9f3b3cba4226cc26809efe19820faf3e6946f9ac8c798eb9ce9ec0d33598e6b89b3e0cdba08fd5d1777b8e8af5d`
- `sha1`: `583eec5df592caaacd971119c81aa074d4858811`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 17
Reconstructed Java files: 12

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.adarshhehe.zoomhehe.ZoomHeheClient"
  ],
  "modmenu": [
    "com.adarshhehe.zoomhehe.config.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3",
  "java": ">=25",
  "fabric-api": "*",
  "yet_another_config_lib_v3": ">=3.9.7"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/adarshhehe/zoomhehe/animation/EasingType.java` | `` |  | apply, apply, apply, apply, apply, getId, getTranslationKey, getDisplayName, toString |
| top-level / `com/adarshhehe/zoomhehe/animation/ZoomAnimator.java` | `` |  | setTarget, getCurrent, step, snapTo, isAtTarget |
| top-level / `com/adarshhehe/zoomhehe/config/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/adarshhehe/zoomhehe/config/ZoomConfig.java` | `` |  | get, load, save |
| top-level / `com/adarshhehe/zoomhehe/config/ZoomConfigScreen.java` | `` |  | create |
| top-level / `com/adarshhehe/zoomhehe/hud/SpyglassOverlay.java` | `` |  | register, extract |
| top-level / `com/adarshhehe/zoomhehe/input/KeybindManager.java` | `` |  | register |
| top-level / `com/adarshhehe/zoomhehe/mixin/GameRendererMixin.java` | `value={Camera.class})` | Inject:1 | onCalculateFov |
| top-level / `com/adarshhehe/zoomhehe/mixin/MinecraftClientMixin.java` | `value={Minecraft.class})` |  |  |
| top-level / `com/adarshhehe/zoomhehe/mixin/MouseMixin.java` | `value={MouseHandler.class})` | Inject:1, ModifyArg:2 | onScroll, modifyLookX, modifyLookY |
| top-level / `com/adarshhehe/zoomhehe/zoom/ZoomController.java` | `` |  | register, onClientTick, setZoomActive, onScroll, getTargetZoomLevel, getFovMultiplier, isZoomActive, getMouseSensitivityMultiplier, shouldShowSpyglassOverlay |
| top-level / `com/adarshhehe/zoomhehe/ZoomHeheClient.java` | `` |  | onInitializeClient, getZoomController |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
