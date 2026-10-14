# RenderScale

Review status: **Evidence inventory; behavioral review pending**

Project: [RenderScale](https://modrinth.com/mod/renderscale)
Selected artifact version: `1.4.0-alpha.6-fabric+26.3`
Published implementation source: https://github.com/Zolo101/RenderScale
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Change resolution without affecting the UI

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `a88437220a4324eecc186e0d70a3902612686faf33ba299e6f53c31b735d3e3133d87de0b268b48ac191af93a02e3bf2ebba1029ed7494f8a6201e2d95b71eb3`
- `sha1`: `6743f7b7820474da25eee0f8afa6fb5eb272b6ee`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 21
Reconstructed Java files: 18

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "dev.zelo.renderscale.platform.fabric.FabricClientEntrypoint"
  ],
  "modmenu": [
    "dev.zelo.renderscale.compat.modmenu.ModMenuApiImpl"
  ],
  "sodium:config_api_user": [
    "dev.zelo.renderscale.compat.sodium.RenderScaleSodiumConfig"
  ],
  "fabric-datagen": [
    "dev.zelo.renderscale.platform.fabric.datagen.FabricDataGeneratorEntrypoint"
  ],
  "fabric-client-gametest": [
    "dev.zelo.renderscale.gametest.RenderScaleClientGameTest"
  ]
}
```

**depends**

```json
{
  "cloth-config": ">=26.3.158",
  "fabric-api": ">=0.160.7+26.3",
  "fabricloader": ">=0.19.5",
  "java": ">=25",
  "minecraft": "26.3.*"
}
```

**breaks**

```json
{
  "resolutioncontrol": "*",
  "resolutioncontrol-plus": "*",
  "resolutioncontrol-plus-plus": "*",
  "superresolution": "*"
}
```

**accessWidener**

```json
"aw/26.3.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/zelo/renderscale/accessors/MainRenderTargetSetter.java` | `` |  |  |
| top-level / `dev/zelo/renderscale/compat/iris/IrisCompatibility.java` | `` |  | reloadShaders, findClass |
| top-level / `dev/zelo/renderscale/compat/modmenu/ModMenuApiImpl.java` | `` |  | getModConfigScreenFactory |
| top-level / `dev/zelo/renderscale/compat/sodium/RenderScaleSodiumConfig.java` | `` |  | registerConfigLate, id, config, dynamicScaleTooltip, getScalePercent, setScalePercent, getMinimumScalePercent, setMinimumScalePercent, getIrisScalePercent, setIrisScalePercent, formatPercent, formatIrisScale |
| top-level / `dev/zelo/renderscale/config/RenderScaleConfig.java` | `` |  | validatePostLoad, init, getScale, isDynamicScaleEnabled, isDynamicScaleAvailable, getTargetFrameRate, getMinimumScale, getFilter, getKey |
| top-level / `dev/zelo/renderscale/Constants.java` | `` |  |  |
| top-level / `dev/zelo/renderscale/DynamicScaleController.java` | `` |  | getScale, reset, resetTiming, update |
| top-level / `dev/zelo/renderscale/gametest/RenderScaleClientGameTest.java` | `` |  | runTest, verifyWindowResize, verifyFilters, verifyDynamicScale, setRenderScale |
| top-level / `dev/zelo/renderscale/gametest/ScreenshotVerifier.java` | `` |  | verifyFilteredScaling, verifyScaling, readImage, uniformBlockFraction, blockUniform, meanChannelDifference, isMonochrome |
| top-level / `dev/zelo/renderscale/mixin/accessors/MixinGameRendererAccessor.java` | `value={GameRenderer.class})` |  | renderScale$setMainRenderTarget |
| top-level / `dev/zelo/renderscale/mixin/compat/iris/MixinIris.java` | `targets={"net.irisshaders.iris.Iris"}, remap=false)` | Inject:1 | reload |
| top-level / `dev/zelo/renderscale/mixin/MixinDebugScreenOverlay.java` | `value={DebugScreenEntries.class})` | Invoker:1, Inject:1 | renderScale$register, renderScale$registerDebugEntry, display, renderScale$addToProfiles |
| top-level / `dev/zelo/renderscale/mixin/MixinGameRenderer.java` | `value={GameRenderer.class})` | Inject:3 | renderScale$updateDynamicScale, takeOver, handBack |
| top-level / `dev/zelo/renderscale/mixin/MixinWindow.java` | `value={Window.class})` | ModifyReturnValue:3, Inject:2 | renderScale$scaleWidth, renderScale$scaleHeight, renderScale$modifyGuiScale, renderScale$onFramebufferResize, renderScale$refreshFramebufferSize, renderScale$scale |
| top-level / `dev/zelo/renderscale/platform/fabric/FabricClientEntrypoint.java` | `` |  | onInitializeClient |
| top-level / `dev/zelo/renderscale/platform/fabric/FabricPlatform.java` | `` |  | isModLoaded, loader, isDevelopmentEnvironment |
| top-level / `dev/zelo/renderscale/platform/Platform.java` | `` |  |  |
| top-level / `dev/zelo/renderscale/RenderScale.java` | `` |  | createPlatformInstance, init, init, getInstance, getConfig, onResolutionChanged, setClientRenderTarget, getProfile, setShouldScale, getCurrentScaleFactor, getRenderScaleFactor, updateDynamicScale, getWindow, resizeRenderTarget, resizeRenderTarget, resizeMinecraftRenderTargetSize, clamp, resize, blitAndBlendToTexture, setPipeline |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
