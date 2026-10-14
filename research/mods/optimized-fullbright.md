# Optimized Fullbright

Review status: **Evidence inventory; behavioral review pending**

Project: [Optimized Fullbright](https://modrinth.com/mod/optimized-fullbright)
Selected artifact version: `2.0.0+26.2-fabric`
Published implementation source: https://github.com/tricube3/optimized_fullbright
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Fullbright mod that disables the lighting system to improve performance. Now toggleable with a keybind!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `d584f34b5798b140c67823801a0fdda2e3405f2419a6d8fc8d3e35d8b8a94e86ba18a7fb224f78a2417f17a5ad9cc501637ebff0e5e91fb476148ad2ada61f1b`
- `sha1`: `b68440d38e06648d6a0ffe9294690d839fd8a9f9`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 17
Reconstructed Java files: 16

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "net.tricube.optimized_fullbright.platform.fabric.FabricEntrypoint"
  ],
  "client": [
    "net.tricube.optimized_fullbright.platform.fabric.FabricClientEntrypoint"
  ],
  "fabric-datagen": [
    "net.tricube.optimized_fullbright.platform.fabric.datagen.FabricDataGeneratorEntrypoint"
  ]
}
```

**depends**

```json
{
  "craft_config": "*",
  "fabric-api": "*",
  "fabricloader": "*",
  "java": ">=25",
  "minecraft": ">=26.2"
}
```

**breaks**

```json
{}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/tricube/optimized_fullbright/config/Config.java` | `` |  | init |
| top-level / `net/tricube/optimized_fullbright/FullbrightState.java` | `` |  | setRequireUpdate, requireUpdate |
| top-level / `net/tricube/optimized_fullbright/mixin/BlockLightMixin.java` | `value={BlockLightEngine.class}, priority=10005)` | Inject:2 | disablePropagateIncrease, disablePropagateDecrease |
| top-level / `net/tricube/optimized_fullbright/mixin/BlockTintGetterMixin.java` | `value={BlockAndLightGetter.class}, priority=10005)` | Inject:2 | disableGetBrightness, disableGetRawBrightness |
| top-level / `net/tricube/optimized_fullbright/mixin/BypassLimitMixin.java` | `value={OptionInstance.UnitDouble.class}, priority=10005)` | Inject:1 | stopValidation |
| top-level / `net/tricube/optimized_fullbright/mixin/GammaMixin.java` | `value={Options.class}, priority=10005)` | Inject:1 | changeGamma |
| top-level / `net/tricube/optimized_fullbright/mixin/LightLevelEngineMixin.java` | `value={LevelLightEngine.class}, priority=10005)` | Inject:2 | disableLightUpates, disableGetRawBrightness |
| top-level / `net/tricube/optimized_fullbright/mixin/LightmapMixin.java` | `value={Lightmap.class}, priority=10005)` | Inject:1 | disableLightTextureUpdate |
| top-level / `net/tricube/optimized_fullbright/mixin/LightMixin.java` | `value={LightEngine.class}, priority=10005)` | Inject:1 | disableGetLightValue |
| top-level / `net/tricube/optimized_fullbright/mixin/WorldRendererMixin.java` | `value={LevelRenderer.class}, priority=10005)` |  |  |
| top-level / `net/tricube/optimized_fullbright/ModInit.java` | `` |  | onInitialize, onInitializeClient, createPlatformInstance, id, id |
| top-level / `net/tricube/optimized_fullbright/platform/fabric/FabricClientEntrypoint.java` | `` |  | onInitializeClient |
| top-level / `net/tricube/optimized_fullbright/platform/fabric/FabricEntrypoint.java` | `` |  | onInitialize |
| top-level / `net/tricube/optimized_fullbright/platform/fabric/FabricPlatform.java` | `` |  | isModLoaded, loader, mcVersion, isDevelopmentEnvironment |
| top-level / `net/tricube/optimized_fullbright/platform/Platform.java` | `` |  |  |
| top-level / `net/tricube/optimized_fullbright/ThreadChecker.java` | `` |  | isClient, checkScalableLux, hasScalableLux, shouldCancel |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
