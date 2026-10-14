# Better Resolution

Review status: **Evidence inventory; behavioral review pending**

Project: [Better Resolution](https://modrinth.com/mod/better-resolution)
Selected artifact version: `1.1.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Better Resolution improves GPU performance by lowering Minecraft’s internal render resolution and then reconstructing it back to native resolution using smart and lightweight algorithms.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `1787c439b0f789d309456c3289b304d4f880fe8c2d7416fe6fb8a1b5e9a753d93dde6100b91a360cb3e56e5bbfd06922fb423d7b58af533e7f6e7b700af86ea8`
- `sha1`: `bbcdf40dc94a0c184d71d305e50973d1c55e25ed`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 17
Reconstructed Java files: 13

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.warma.betterresolution.BetterResolutionClient"
  ],
  "sodium:config_api_user": [
    "com.warma.betterresolution.compat.sodium.BetterResolutionSodiumConfigEntryPoint"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.4",
  "minecraft": ">=26.3 <26.4",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/warma/betterresolution/BetterResolutionClient.java` | `` |  | onInitializeClient, registerResourceReloadHook |
| top-level / `com/warma/betterresolution/BetterResolutionGameRendererAccess.java` | `` |  |  |
| top-level / `com/warma/betterresolution/BetterResolutionReload.java` | `` |  | requestReload, isReloadRequested, consumeReloadRequest |
| top-level / `com/warma/betterresolution/BetterResolutionRenderPipelines.java` | `` |  | postPipeline, initialize, id |
| top-level / `com/warma/betterresolution/ClientHooks.java` | `` |  | registerResourceReloadApplyHook, onConfigApplied |
| top-level / `com/warma/betterresolution/compat/iris/IrisCompatibility.java` | `` |  | initialize |
| top-level / `com/warma/betterresolution/compat/iris/IrisMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, isCompatible, findResizeMethod, nextInstruction, acceptTargets, getMixins, preApply, postApply |
| top-level / `com/warma/betterresolution/compat/sodium/BetterResolutionSodiumConfigEntryPoint.java` | `` |  | key, registerConfigEarly, registerConfigLate, modeName, presetName |
| top-level / `com/warma/betterresolution/config/BetterResolutionConfig.java` | `` |  | load, save, effectiveScalePercent, clampPercent, parseMode, parsePreset, scalePercent |
| top-level / `com/warma/betterresolution/mixin/compat/iris/IrisRenderTargetsMixin.java` | `targets={"net.irisshaders.iris.targets.RenderTargets"}, remap=false)` | Inject:1 | betterresolution$checkDepthTextureIdentity |
| top-level / `com/warma/betterresolution/mixin/GameRendererMixin.java` | `value={GameRenderer.class})` | ModifyArgs:1, Inject:3, WrapOperation:2, WrapMethod:1 | betterresolution$sizeInitialHudDepth, betterresolution$onInit, betterresolution$resizeRenderTarget, betterresolution$resizeLevelRenderer, betterresolution$onResize, betterresolution$applyPendingResourceReload, betterresolution$renderScaledWorld, betterresolution$onClose, betterresolution$updateTargets, betterresolution$ensureWorldTarget, betterresolution$ensureEdgeInfoTarget, betterresolution$destroyWorldTarget, betterresolution$destroyEdgeInfoTarget, betterresolution$resetSkyRenderer, betterresolution$blitWorldTo, betterresolution$blitSharpTo, betterresolution$blitSmoothTo, betterresolution$drawEdgeInfoPass, betterresolution$drawSmoothPass, betterresolution$blitDepthTo |
| top-level / `com/warma/betterresolution/mixin/LevelRendererAccessor.java` | `value={LevelRenderer.class})` | Accessor:2 |  |
| top-level / `com/warma/betterresolution/ResolutionHelper.java` | `` |  | isScalingActive, getScaleFactor, scale |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
