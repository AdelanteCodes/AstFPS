# cbbg 🥬

Review status: **Evidence inventory; behavioral review pending**

Project: [cbbg 🥬](https://modrinth.com/mod/cbbg)
Selected artifact version: `1.5.0+mc26.3-fabric`
Published implementation source: https://github.com/qb20nh/cbbg
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

color banding be gone - Remove pesky color banding from Minecraft

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `69a8e3acb34f5d57096677a94b4ed7b681fdcc66`
- `sha512`: `cbcbb9ae517e7c0da574f36c608e0d438c5ae4611f2f98bdfd7b3582456e386acb2de78d34324b6c1656259fc63a510801a984a65968d4ad39058446d99e8320`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 66
Reconstructed Java files: 50

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.qb20nh.cbbg.CbbgClient"
  ],
  "modmenu": [
    "com.qb20nh.cbbg.compat.modmenu.CbbgModMenuApi"
  ],
  "preLaunch": [
    "com.qb20nh.cbbg.CbbgEarlyInit"
  ],
  "sodium:config_api_user": [
    "com.qb20nh.cbbg.compat.sodium.CbbgSodiumConfig"
  ]
}
```

**depends**

```json
{
  "cbbg_lib": ">=1.0.0-beta.1 <2.0.0",
  "fabric-api": ">=0.160.3+26.3 <1.0.0",
  "fabricloader": ">=0.19.5 <1.0.0",
  "java": ">=25",
  "minecraft": "26.3"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/cbbg-lib-1.0.0-beta.1+mc26.3-fabric.jar` | 7 | `cbbg_lib` | Reconstructed source; semantic review pending |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/qb20nh/cbbg/a/a.java` | `` |  | a, b, a, a, a, b, c, d, a, a |
| top-level / `com/qb20nh/cbbg/a/b.java` | `` |  | a |
| top-level / `com/qb20nh/cbbg/a.java` | `` |  |  |
| top-level / `com/qb20nh/cbbg/b/a/a.java` | `` |  | a, onClose, init, a, extractBackground, extractRenderState, a |
| top-level / `com/qb20nh/cbbg/b/a/b.java` | `` |  | a, a, a, b, a, updateMessage, applyValue, a, updateMessage, applyValue, a |
| top-level / `com/qb20nh/cbbg/b/a/c.java` | `` |  |  |
| top-level / `com/qb20nh/cbbg/b/a/d.java` | `` |  |  |
| top-level / `com/qb20nh/cbbg/b/a/e.java` | `` |  | extractBackground, a, extractRenderState, a, b, a, a, toString, hashCode, equals |
| top-level / `com/qb20nh/cbbg/b/a/f.java` | `` |  |  |
| top-level / `com/qb20nh/cbbg/b/a.java` | `` |  | a, a, a, a, a, b, a, a, a, b, b, a, a, a, a, b, c, b, c, d, e, f, g, h, i, equals, hashCode, toString, a, a, b, a, a, b, c |
| top-level / `com/qb20nh/cbbg/c/a.java` | `` |  | display, a |
| top-level / `com/qb20nh/cbbg/CbbgClient.java` | `` |  | getEffectiveMode, areShadersActive, isEnabled, onInitializeClient |
| top-level / `com/qb20nh/cbbg/CbbgEarlyInit.java` | `` |  | onPreLaunch, configureSettings |
| top-level / `com/qb20nh/cbbg/CbbgLanguageAdapter.java` | `` |  | create |
| top-level / `com/qb20nh/cbbg/compat/a/a.java` | `` |  | a, a |
| top-level / `com/qb20nh/cbbg/compat/b/a.java` | `` |  | a, b, c |
| top-level / `com/qb20nh/cbbg/compat/c/a.java` | `` |  | a |
| top-level / `com/qb20nh/cbbg/compat/modmenu/CbbgModMenuApi.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/qb20nh/cbbg/compat/sodium/CbbgSodiumConfig.java` | `` |  | registerConfigLate |
| top-level / `com/qb20nh/cbbg/d/a/a/a.java` | `` |  | a, a, b, c, d, m, n, o, a, e, f, g, h, i, j, b, p, c, k, close, l, a, b, b, q, r, a, toString, s, t, u, b, v |
| top-level / `com/qb20nh/cbbg/d/a/a/b.java` | `` |  |  |
| top-level / `com/qb20nh/cbbg/d/a/a/c.java` | `` |  | a, a, a, b, a, c, b, b, d, c, e, b, a, a, flush, close, d, f, g, h |
| top-level / `com/qb20nh/cbbg/d/a/a/d.java` | `` |  |  |
| top-level / `com/qb20nh/cbbg/e/a.java` | `` |  | a |
| top-level / `com/qb20nh/cbbg/mixin/DebugScreenEntriesMixin.java` | `value={DebugScreenEntries.class})` | Inject:1 | register, cbbg$register |
| top-level / `com/qb20nh/cbbg/mixin/FrontendRenderPassMixin.java` | `value={FrontendRenderPass.class})` | ModifyVariable:1 | cbbg$matchFloatAttachments |
| top-level / `com/qb20nh/cbbg/mixin/IrisPipelineManagerMixin.java` | `targets={"net.irisshaders.iris.pipeline.PipelineManager"}, remap=false)` | Inject:1 | cbbg$refreshShaderTransition |
| top-level / `com/qb20nh/cbbg/mixin/MainTargetMixin.java` | `value={MainTarget.class})` | Inject:1, Redirect:1 | cbbg$trackTarget, cbbg$allocateMain |
| top-level / `com/qb20nh/cbbg/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:2, ModifyArg:1 | cbbg$prepareFrame, cbbg$present, cbbg$close |
| top-level / `com/qb20nh/cbbg/mixin/PipelineCacheMixin.java` | `value={PipelineCache.class})` | Inject:2 | cbbg$rememberInserted, cbbg$rememberResolved |
| top-level / `com/qb20nh/cbbg/mixin/PostChainMixin.java` | `value={PostChain.class})` | WrapMethod:1, ModifyExpressionValue:1 | cbbg$blurScope, cbbg$floatBlurDescriptor |
| top-level / `com/qb20nh/cbbg/mixin/RenderTargetMixin.java` | `value={RenderTarget.class})` | Redirect:1 | cbbg$resizeMain |
| top-level / `com/qb20nh/cbbg/mixin/ScreenshotMixin.java` | `value={Screenshot.class})` | Inject:1 | cbbg$convertFloatScreenshot |
| top-level / `com/qb20nh/cbbg/render/a/a.java` | `` |  | a, a, a, a, a |
| top-level / `com/qb20nh/cbbg/render/a/b.java` | `` |  | a, a |
| top-level / `com/qb20nh/cbbg/render/a/c.java` | `` |  | a, done, a, toString, hashCode, equals, a, b |
| top-level / `com/qb20nh/cbbg/render/a/d.java` | `` |  | a, a, a |
| top-level / `com/qb20nh/cbbg/render/a.java` | `` |  | a, a, a, b, c, d, e, f, g, h, a, toString, hashCode, equals |
| top-level / `com/qb20nh/cbbg/render/b.java` | `` |  | a, c |
| top-level / `com/qb20nh/cbbg/render/c.java` | `` |  | a |
| top-level / `com/qb20nh/cbbg/render/d.java` | `` |  | a, a |
| top-level / `com/qb20nh/cbbg/render/e.java` | `` |  | a, a, toString, hashCode, equals |
| top-level / `com/qb20nh/cbbg/render/f.java` | `` |  | a, b, a, b, c, a, d |
| top-level / `com/qb20nh/cbbg/render/g.java` | `` |  | a |
| top-level / `com/qb20nh/cbbg/render/h.java` | `` |  | a, a |
| top-level / `com/qb20nh/cbbg/render/i.java` | `` |  | a, a |
| top-level / `com/qb20nh/cbbg/render/j.java` | `` |  |  |
| top-level / `com/qb20nh/cbbg/render/k.java` | `` |  | a |
| top-level / `com/qb20nh/cbbg/render/l.java` | `` |  | a |
| top-level / `com/qb20nh/cbbg/render/m.java` | `` |  | a |
| META-INF/jars/cbbg-lib-1.0.0-beta.1+mc26.3-fabric.jar / `com/qb20nh/cbbg/api/Dithering.java` | `` |  | rgba8 |
| META-INF/jars/cbbg-lib-1.0.0-beta.1+mc26.3-fabric.jar / `com/qb20nh/cbbg/api/DitherOptions.java` | `` |  | strength, scaleX, scaleY, demo |
| META-INF/jars/cbbg-lib-1.0.0-beta.1+mc26.3-fabric.jar / `com/qb20nh/cbbg/api/NoiseVolume.java` | `` |  | generate, a, a, width, height, depth, pixelABGR, frameRGBA |
| META-INF/jars/cbbg-lib-1.0.0-beta.1+mc26.3-fabric.jar / `com/qb20nh/cbbg/api/package-info.java` | `` |  |  |
| META-INF/jars/cbbg-lib-1.0.0-beta.1+mc26.3-fabric.jar / `com/qb20nh/cbbg/lib/internal/a.java` | `` |  | a, a, a, a, a, a |
| META-INF/jars/cbbg-lib-1.0.0-beta.1+mc26.3-fabric.jar / `com/qb20nh/cbbg/lib/internal/b.java` | `` |  | a, a, b, c, d, a |
| META-INF/jars/cbbg-lib-1.0.0-beta.1+mc26.3-fabric.jar / `com/qb20nh/cbbg/render/DitherPass.java` | `` |  | render, a, render, close |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
