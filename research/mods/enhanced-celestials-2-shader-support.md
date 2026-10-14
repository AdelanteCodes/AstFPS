# Enhanced Celestials 2: Shader Support

Review status: **Evidence inventory; behavioral review pending**

Project: [Enhanced Celestials 2: Shader Support](https://modrinth.com/mod/enhanced-celestials-2-shader-support)
Selected artifact version: `5.0.0.0-fabric`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Bridge mod adding support for sodium / iris shaders in order for moon colors to work correctly.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `a022b95eeedd0c708826cdd8f69943a9f3ff4142`
- `sha512`: `f3cdbd19edbf1b91e532b63b972f82b363e78b18ac2bad3baaf25ccec1c6967a012bbec56c091849eee1240b1dc1dcde893bf3c42038822b70b47ef7eb92943e`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 12
Reconstructed Java files: 12

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "dev.corgitaco.enhancedcelestials2shaders.fabric.EnhancedCelestialsShadersFabric"
  ],
  "client": [
    "dev.corgitaco.enhancedcelestials2shaders.fabric.LunarShadersFabricClient"
  ],
  "modmenu": [
    "dev.corgitaco.enhancedcelestials2shaders.fabric.EnhancedCelestialsShadersModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "fabric-api": "*",
  "minecraft": ">=26.3",
  "java": ">=25",
  "enhancedcelestials2core": ">=5.0.0.0",
  "sodium": "*",
  "iris": "*"
}
```

**breaks**

```json
{
  "enhancedcelestials": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/corgitaco/enhancedcelestials2shaders/api/LunarEventUtils.java` | `` |  | getDefaultColor, formatEventName, isActiveEvent, clampBlend, clampColor, copyArray, copyInto, truncate, shouldLog, logInfo, logDebug, logWarn, logError |
| top-level / `dev/corgitaco/enhancedcelestials2shaders/client/ClientLunarHandler.java` | `` |  | getInstance, onClientTick, logStateTransition, reset, getDebugInfo |
| top-level / `dev/corgitaco/enhancedcelestials2shaders/EnhancedCelestials2Shaders.java` | `` |  | createLocation |
| top-level / `dev/corgitaco/enhancedcelestials2shaders/fabric/EnhancedCelestialsShadersFabric.java` | `` |  | onInitialize |
| top-level / `dev/corgitaco/enhancedcelestials2shaders/fabric/EnhancedCelestialsShadersModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `dev/corgitaco/enhancedcelestials2shaders/fabric/LunarShadersFabricClient.java` | `` |  | onInitializeClient |
| top-level / `dev/corgitaco/enhancedcelestials2shaders/fabric/platform/FabricPlatformHelper.java` | `` |  | getPlatformName, getMinecraftVersion, isModLoaded, isClient, isDedicatedServer, getGameDirectory, getConfigDirectory, areShadersActive, getClientLevel |
| top-level / `dev/corgitaco/enhancedcelestials2shaders/LunarShadersMod.java` | `` |  | init, getPlatform, isInitialized |
| top-level / `dev/corgitaco/enhancedcelestials2shaders/platform/PlatformHelper.java` | `` |  |  |
| top-level / `dev/corgitaco/enhancedcelestials2shaders/render/LunarColorRenderer.java` | `` |  | getInstance, update, getSkyColor, getMoonColor, getGlowColor, getBlend, getGlowIntensity, getGlowPulse, isRenderingActive, reset, setDefault, resolveGlowColor, lerpInto, advanceFrameClock, updatePulse, getDebugInfo |
| top-level / `dev/corgitaco/enhancedcelestials2shaders/render/LunarEffectCompute.java` | `` |  | tintRGBA, glowRGBA |
| top-level / `dev/corgitaco/enhancedcelestials2shaders/render/LunarTintRenderer.java` | `` |  | guiPipeline, render |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
