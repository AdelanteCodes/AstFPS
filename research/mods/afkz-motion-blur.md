# Motion Blur

Review status: **Evidence inventory; behavioral review pending**

Project: [Motion Blur](https://modrinth.com/mod/afkz-motion-blur)
Selected artifact version: `1.0-release`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This mod gives you the cleanest blur
Almost 90% similar to lunar motion blur

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `844b792b7e13746fc874c02f7134907bf265dac11fb3d0738508e20107ec96180c8b66384ae9b2f5d7471c55fe14fd4967484688299e1d651d9c464fd6f1b3dc`
- `sha1`: `12c32ab085917bc93615a12e59cab25d727cbe8f`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 11
Reconstructed Java files: 6

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.afkzmotionblur.AfkzMotionBlurClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.15.0",
  "minecraft": "~26.3",
  "fabric-api": "*"
}
```

**breaks**

```json
{
  "optifine-any": "*",
  "oculus": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/afkzmotionblur/ActivePostChainTracker.java` | `` |  |  |
| top-level / `com/afkzmotionblur/AfkzMotionBlurClient.java` | `` |  | getClientWorld, getCurrentPostEffect, doClearPostEffect, applyEffectId, onInitializeClient, onTick, handleCameraChange, onWorldChange, resetStateOnDisconnect, runResetSequence, scheduleReset, registerCommands, setEnabled, setDefaultEnabled, applyOrFallback, evaluateCompatibility, updateCompatibilityStatus, applyCurrentState, clearOurPostProcessor, stealPreviousTarget, clearPersistentTargets, effectIdForConfig, flushConfig, sendMessage, initializeIrisReflections |
| top-level / `com/afkzmotionblur/config/AfkzMotionBlurConfig.java` | `` |  | AfkzMotionBlurConfig, defaults, load, withEnabled, withDefaultEnabled, withStrength, save, parseInt, parseBoolean, clampStrength |
| top-level / `com/afkzmotionblur/mixin/GameRendererAccessor.java` | `value={GameRenderer.class})` |  |  |
| top-level / `com/afkzmotionblur/mixin/PostChainMixin.java` | `value={PostChain.class})` | Inject:3 | afkzmotionblur$clearPersistentTargets, afkzmotionblur$clearCachedTarget, afkzmotionblur$resetPreviousTarget, afkzmotionblur$cachePreviousTarget, findPreviousTargetId, findPreviousTarget, afkzmotionblur$onProcess, afkzmotionblur$onClose, afkzmotionblur$onGetOrCreatePersistentTarget, removePreviousTarget |
| top-level / `com/afkzmotionblur/PostChainExt.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
