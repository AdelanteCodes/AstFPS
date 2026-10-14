# No Waypoints/Locator Bar

Review status: **Evidence inventory; behavioral review pending**

Project: [No Waypoints/Locator Bar](https://modrinth.com/mod/no-way)
Selected artifact version: `1.4.0`
Published implementation source: https://github.com/litetex-oss/mcm-no-way
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A minimalistic mod that disables Waypoints/Locator Bar

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `615fd9b6dc2bb1f1609a5b942741b82dd2e5cd59`
- `sha512`: `34bb2d1a2b3a03665aceecc016f53092eebfcdf0a0f96b9a1ae2488199e8f0e307f2b4e2ac428817c7ca53c098b1e569d2ed370d6a97de612e5393ca6edb96ec`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 7
Reconstructed Java files: 7

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "net.litetex.noway.client.NoWayFabricClientInitializer"
  ]
}
```

**accessWidener**

```json
"no-way.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/litetex/noway/client/config/ClientConfig.java` | `` |  | isAlwaysHideLocatorBar, setAlwaysHideLocatorBar, reset, createDefault |
| top-level / `net/litetex/noway/client/NoWayClient.java` | `` |  | instance, setInstance, saveConfig, alwaysHideLocatorBar, toggleAlwaysHideLocatorBar |
| top-level / `net/litetex/noway/client/NoWayFabricClientInitializer.java` | `` |  | onInitializeClient, configFilePath, loadConfig, saveConfig, initKeys |
| top-level / `net/litetex/noway/mixin/client/InGameHudMixin.java` | `value={Hud.class})` | Redirect:1 | hasWaypoint |
| top-level / `net/litetex/noway/mixin/LivingEntityMixin.java` | `value={LivingEntity.class})` | Inject:1 | hasWaypoint |
| top-level / `net/litetex/noway/mixin/ServerPlayerEntityMixin.java` | `value={ServerPlayer.class})` | Inject:1 | canReceiveWaypoints |
| top-level / `net/litetex/noway/mixin/ServerWaypointHandlerMixin.java` | `value={ServerWaypointManager.class})` | Inject:9 | onTrack, onUpdate, onUntrack, addPlayer, updatePlayerPos, removePlayer, removePlayer, refreshTracking, isLocatorBarEnabled |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
