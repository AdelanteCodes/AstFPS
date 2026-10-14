# HUD - FPS Veltium

Review status: **Evidence inventory; behavioral review pending**

Project: [HUD - FPS Veltium](https://modrinth.com/mod/veltium)
Selected artifact version: `0.1.22+26.3`
Published implementation source: https://github.com/m5120/Veltium
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Displays FPS, coordinates, ping, time, days, and RAM usage – all in one informative HUD! Extensive customization and freedom of action.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `be8dc1d8c4b5350468b1b88c7413ad80f7a6baa12e85df202dcc8de8f0d7af1d27297c409b7fd6d6e597020bbc6bc78c4091b7a83b283d9c9d8378ace369e58b`
- `sha1`: `50ab255c79a21fe8b6b9efc74bb33cd45f5f6b3b`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 10
Reconstructed Java files: 7

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.veltium.TemplateMod"
  ],
  "client": [
    "com.veltium.Veltium"
  ],
  "modmenu": [
    "com.veltium.OptimizationModMenuIntegration"
  ],
  "sodium:config_api_user": [
    "com.veltium.config.VeltiumSodiumConfig"
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
  "yet_another_config_lib_v3": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/veltium/config/VeltiumSodiumConfig.java` | `` |  | registerConfigLate, tooltip |
| top-level / `com/veltium/config/YACLConfig.java` | `` |  | getInstance, intToColor, colorToInt, getFpsColor, getMemoryColor, getPingColor, load, save, copyFrom, createConfigScreen, track, createBooleanOption, createColorOption, createFpsColorGroup, createMemoryColorGroup, createPingColorGroup, getDisplayName, next, isCenterX, isBottom, isRight |
| top-level / `com/veltium/mixin/client/ExampleClientMixin.java` | `value={Minecraft.class})` | Inject:1 | init |
| top-level / `com/veltium/mixin/ExampleMixin.java` | `value={MinecraftServer.class})` | Inject:1 | init |
| top-level / `com/veltium/OptimizationModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/veltium/TemplateMod.java` | `` |  | onInitialize |
| top-level / `com/veltium/Veltium.java` | `` |  | onInitializeClient, renderHud, updateStatistics, updateCachedStats, getFpsMin, getFpsAvg, getFpsMax, getMemoryMin, getMemoryAvg, getMemoryMax, getPingMin, getPingAvg, getPingMax, renderHudElements, renderLineBackground, renderColoredCoordinates, updateCache, renderTextLine, renderTextLine, getHudTextWidth, clampToScreen, createHudText |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
