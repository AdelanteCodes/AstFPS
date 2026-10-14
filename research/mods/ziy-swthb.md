# Simple-Warp-Tpa-Home-Back

Review status: **Evidence inventory; behavioral review pending**

Project: [Simple-Warp-Tpa-Home-Back](https://modrinth.com/mod/ziy-swthb)
Selected artifact version: `1.3`
Published implementation source: https://github.com/ziy-ziy/simple-warp-tpa-home
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

no pop-ups, no prerequisites, complete translation, lightweight teleport mod, supports TPA, home, back,and teleport

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha512`: `41af7f2bf05621a68d4086731618003ffb10823c63d87fa70ccaeb030be756ba67b6f8e3261ba66dda96a4f9e8151b398a1301f8d49aa73fde64aefe9a2b285d`
- `sha1`: `b2b45e56b1c7a259563267d5e606a4e9a2058be2`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 20
Reconstructed Java files: 13

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "zy.swthb.SimpleWarpTpaHomeBack"
  ],
  "fabric-datagen": [
    "zy.swthb.SimpleWarpTpaHomeBackDataGenerator"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `zy/swthb/command/BackCommand.java` | `` |  | register, executeBack |
| top-level / `zy/swthb/command/BackHandler.java` | `` |  | registerEvents, saveBackPoint, getBackPoint, BackPoint |
| top-level / `zy/swthb/command/DimensionDisplay.java` | `` |  | of |
| top-level / `zy/swthb/command/HomeCommand.java` | `` |  | register, executeHome, executeHomes, executeSetHome, executeDelHome, suggestHomes |
| top-level / `zy/swthb/command/SwthbConfigCommand.java` | `` |  | register, executeSetMaxHomes, executeSetMaxWarps, executeSetTeleportDelay, executeSetBackEnabled, executeSetTeleportEffectsEnabled, executeReload, executeSave |
| top-level / `zy/swthb/command/TeleportHandler.java` | `` |  | startTeleport, cancelTeleport, playArrivalEffects, tick, TeleportTask |
| top-level / `zy/swthb/command/TpaCommand.java` | `` |  | registerCleanupEvent, register, executeTpa, executeTpay, executeTpan, cleanup, PendingRequest |
| top-level / `zy/swthb/command/WarpCommand.java` | `` |  | register, executeWarp, executeWarps, executeSetWarp, executeDelWarp, suggestWarps |
| top-level / `zy/swthb/config/ModConfig.java` | `` |  | getInstance, getServer, load, save, reset, getMaxHomes, setMaxHomes, getHomes, getHome, isAtMaxHomes, homeExists, getHomeCount, setHome, removeHome, getTeleportDelay, setTeleportDelay, isTeleportEffectsEnabled, setTeleportEffectsEnabled, isBackEnabled, setBackEnabled, getMaxWarps, setMaxWarps, getWarps, getWarp, setWarp, removeWarp, getName, getWorld, getX, getY, getZ, getYaw, getPitch, getWorld, getX, getY, getZ, getYaw, getPitch |
| top-level / `zy/swthb/mixin/ChatAutoCloseMixin.java` | `value={ClientPacketListener.class})` | Inject:1 | afterSendUnattendedCommand |
| top-level / `zy/swthb/mixin/DeathMixin.java` | `value={ServerPlayer.class})` | Inject:1 | onDeath |
| top-level / `zy/swthb/SimpleWarpTpaHomeBack.java` | `` |  | onInitialize |
| top-level / `zy/swthb/SimpleWarpTpaHomeBackDataGenerator.java` | `` |  | onInitializeDataGenerator |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
