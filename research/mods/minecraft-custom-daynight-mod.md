# Minecraft Custom Day/Night Mod

Review status: **Evidence inventory; behavioral review pending**

Project: [Minecraft Custom Day/Night Mod](https://modrinth.com/mod/minecraft-custom-daynight-mod)
Selected artifact version: `2.2.0`
Published implementation source: https://github.com/mozartsghost1212/mg-custom-day-night-mod
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A server-side only Fabric mod for Minecraft that allows you to configure the length of day and night.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `f1e9ea946fcd98a2638097ad74ec24aa23d37ba7bafd79d03936cbdb4feb0c62dc91f8f1c18a7aac3c0d121214f4aee293f006f882bfa1450cb305a380f135e5`
- `sha1`: `e057768868cce417ef7f28b5bfa852b20e074e50`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 4
Reconstructed Java files: 3

**environment**

```json
"server"
```

**entrypoints**

```json
{
  "main": [
    "com.github.mozartsghost1212.customdaynightmod.CustomDayNightMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": ">=0.161.0+26.3",
  "minecraft": "26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/github/mozartsghost1212/customdaynightmod/CustomDayNightCommand.java` | `` |  | register, showMenu, sectionHeader, computeEffectiveTicks, formatDuration, send, createSuggestButton, createFloatRow, createIntRow, formatMinutes, createBoolRow, setDurationMinutes, setDayMultiplier, setNightMultiplier, setAbsoluteDayLength, setAbsoluteNightLength, multiplierFeedback, lengthFeedback, reload, save, resetDefaults, status, togglePhaseLogging |
| top-level / `com/github/mozartsghost1212/customdaynightmod/CustomDayNightMod.java` | `` |  | onInitialize, onServerTick |
| top-level / `com/github/mozartsghost1212/customdaynightmod/ModConfig.java` | `` |  | loadConfig, saveConfig, resetDefaults, clampValues, clampMultiplier, clampAbsoluteLength |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
