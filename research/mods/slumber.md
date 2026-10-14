# Slumber

Review status: **Evidence inventory; behavioral review pending**

Project: [Slumber](https://modrinth.com/mod/slumber)
Selected artifact version: `mc26.2-2.0.0`
Published implementation source: https://github.com/QPCrummer/Slumber
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Let the server rest while there are no players online

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `cd18a78c42bc9f3b96a4890c8b56da8479e9d64ebd599a482268836821332e7d0a76378503e0c5dcde4f99b4847f7d84899703263fb9689393b758fbe22a48ff`
- `sha1`: `a7715948850f61b0509877773fcc8641363ca017`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 10
Reconstructed Java files: 10

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [],
  "server": []
}
```

**depends**

```json
{
  "fabricloader": "*",
  "minecraft": ">=26.1.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/github/tatercertified/slumber/MinecraftServerInterface.java` | `` |  |  |
| top-level / `com/github/tatercertified/slumber/mixin/CommandRegistrationMixin.java` | `value={Commands.class})` | Inject:1 | slumber$registerCommand |
| top-level / `com/github/tatercertified/slumber/mixin/DedicatedServerMixin.java` | `value={DedicatedServer.class})` | Inject:1 | slumber$onServerStarted |
| top-level / `com/github/tatercertified/slumber/mixin/DedicatedServerPropertiesMixin.java` | `value={DedicatedServerProperties.class})` | Redirect:1 | slumber$redirectMojangImpl |
| top-level / `com/github/tatercertified/slumber/mixin/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | WrapOperation:1, Redirect:1, Inject:2 | setAutoSave, slumber$checkAutoSaving, slumber$removeMojangImplementation, slumber$initMod, slumber$serverStarting |
| top-level / `com/github/tatercertified/slumber/mixin/PlayerListMixin.java` | `value={PlayerList.class})` | Inject:2 | slumber$onPlayerJoin, slumber$onPlayerLeave |
| top-level / `com/github/tatercertified/slumber/mixin/ServerTickRateManagerMixin.java` | `value={ServerTickRateManager.class})` |  | setFrozenNoPacket, setTickRateNoPacket |
| top-level / `com/github/tatercertified/slumber/Slumber.java` | `` |  | onInitialize, storecfg, fillDefaults, checkProperty, loadcfg, parse, freeze, freezeServerAction, changeTickRateAction, sendToDebugLogger, calculateTimeElapsed |
| top-level / `com/github/tatercertified/slumber/SlumberCommand.java` | `` |  | register, status, set |
| top-level / `com/github/tatercertified/slumber/TickManagerInterface.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
