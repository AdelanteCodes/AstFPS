# Dynamic Performance

Review status: **Evidence inventory; behavioral review pending**

Project: [Dynamic Performance](https://modrinth.com/mod/dynamic-performance)
Selected artifact version: `0.2.0+26.1-fabric`
Published implementation source: https://github.com/nwrenger/dynamic-performance
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A vanilla-preserving and lightweight performance mod that dynamically adjusts view distance, simulation distance, and the mob cap based on the server's load.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `9617a68f7d43f7ecad8b66d7adca714becdcba4e`
- `sha512`: `5263a71933969ada61bfb8fb8ced3809cc80870a71b0ed82d3623fcfac816863edabab7a8246b6fa951ebd4ccb8436853bf6fd90877ce96402bdf8949ba6cdda`

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
"*"
```

**entrypoints**

```json
{
  "main": [
    "io.github.nwrenger.dynamicperformance.DynamicPerformance"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "fabric-api": "*",
  "minecraft": ">=26.1",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/github/nwrenger/dynamicperformance/cmd/AboutCommand.java` | `` |  | run, message |
| top-level / `io/github/nwrenger/dynamicperformance/cmd/Command.java` | `` |  | register, createRoot, header, entry |
| top-level / `io/github/nwrenger/dynamicperformance/cmd/ConfigCommand.java` | `` |  | run, message, levelType, levelUnit |
| top-level / `io/github/nwrenger/dynamicperformance/cmd/ReloadCommand.java` | `` |  | run, success, failure |
| top-level / `io/github/nwrenger/dynamicperformance/cmd/State.java` | `` |  | label, color |
| top-level / `io/github/nwrenger/dynamicperformance/cmd/StatusCommand.java` | `` |  | run, message, getTickTimeColor, getState |
| top-level / `io/github/nwrenger/dynamicperformance/Common.java` | `` |  | init, id, loadConfig, getConfig, tick, check, scaleDown, scaleUp, getScaleDownLevel, getScaleUpLevel, canScaleDown, canScaleUp, getCurrentValue, applyValue |
| top-level / `io/github/nwrenger/dynamicperformance/Config.java` | `` |  | save, load, validate, validateBounds, validateRange, intoTicks |
| top-level / `io/github/nwrenger/dynamicperformance/Constants.java` | `` |  |  |
| top-level / `io/github/nwrenger/dynamicperformance/Distance.java` | `` |  | setView, setSimulation |
| top-level / `io/github/nwrenger/dynamicperformance/DynamicPerformance.java` | `` |  | onInitialize |
| top-level / `io/github/nwrenger/dynamicperformance/level/Level.java` | `` |  |  |
| top-level / `io/github/nwrenger/dynamicperformance/level/LevelType.java` | `` |  |  |
| top-level / `io/github/nwrenger/dynamicperformance/mixin/MobCategoryAccessor.java` | `value={MobCategory.class})` | Accessor:2 |  |
| top-level / `io/github/nwrenger/dynamicperformance/MobCap.java` | `` |  | setPercentage, getPercentage, percentageFromCategory, calculateMobCap, setMobCap, applyDefaults |
| top-level / `io/github/nwrenger/dynamicperformance/platform/FabricPlatformHelper.java` | `` |  | getPlatformName, getConfigDir, isModLoaded, isPhysicalClient, isDevelopmentEnvironment, registerCommands, registerEndServerTick |
| top-level / `io/github/nwrenger/dynamicperformance/platform/services/IPlatformHelper.java` | `` |  |  |
| top-level / `io/github/nwrenger/dynamicperformance/platform/Services.java` | `` |  | load |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
