# ClickOptimizer

Review status: **Evidence inventory; behavioral review pending**

Project: [ClickOptimizer](https://modrinth.com/mod/clickoptimizer)
Selected artifact version: `1.0.0`
Published implementation source: https://github.com/mami137/ClickOptimizer.git
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Eliminates input lag and lost clicks by capturing mouse and keyboard inputs at the render-frame level (FPS) instead of the 20 TPS tick rate. 100% Client-side.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `663c01e208c869f5367ccfb1f4e2dedf80552b03a6604d1c8f125e471b92eb866bc8fd5ff64d2be05be114c81bedf400239b977030e4d811a7df3f5af44fc85e`
- `sha1`: `4a2c101b586e3113c79e547a29fc4c760fd76a18`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 4
Reconstructed Java files: 4

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.subtick.SubTickInputEngine"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.15.0",
  "minecraft": ">=26.1",
  "java": ">=17",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/subtick/config/SubTickConfig.java` | `` |  | getInstance, load, save, getConfigFilePath, validate, isEnabled, setEnabled, isHudEnabled, setHudEnabled, toggleHud, isDebugMode, setDebugMode, getMaxBufferCapacity, setMaxBufferCapacity, getMaxEventsPerFlush, setMaxEventsPerFlush, isCaptureMouseMove, setCaptureMouseMove, isCaptureKeyboard, setCaptureKeyboard, getHudScale, setHudScale, getHudX, setHudX, getHudY, setHudY |
| top-level / `com/subtick/hud/SubTickHud.java` | `` |  | recordLeftClick, recordRightClick, getCps, register, extractRenderState, getColorForCps |
| top-level / `com/subtick/mixin/MouseInputMixin.java` | `value={MouseHandler.class})` | Inject:1 | subtick$captureMouseButton |
| top-level / `com/subtick/SubTickInputEngine.java` | `` |  | onInitializeClient |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
