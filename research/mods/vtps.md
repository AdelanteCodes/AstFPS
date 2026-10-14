# Vanilla+ TPS

Review status: **Evidence inventory; behavioral review pending**

Project: [Vanilla+ TPS](https://modrinth.com/mod/vtps)
Selected artifact version: `2.8.4.3`
Published implementation source: https://github.com/Damir00109/VTPS/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

light mod for viewing tps/mspt/ping data on the server with quick updates to new versions.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha1`: `bcbbaca98984e42435f44b775d641199cd83be58`
- `sha512`: `6d4a1a96de96723b586228ef822200ae74dbe3dd2e8c29cfb25da4d2fd3e5cddd385f15ef683b90ca50600d8b8245052fa324f69196cd7ed8902d38b651a2061`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 6
Reconstructed Java files: 6

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.damir00109.VTPS"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "minecraft": [
    "~26.2-",
    "~26.3-"
  ],
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/damir00109/ActionBar.java` | `` |  | isActionBarEnabled, toggleActionBar, startActionBarUpdates, stopActionBarUpdates, updateActionBar |
| top-level / `com/damir00109/BossBarTPS.java` | `` |  | toggleBossBar, startBossBarUpdates, stopBossBarUpdates, updateBossBar, getBossBarColor |
| top-level / `com/damir00109/mixin/CommandManagerMixin.java` | `value={Commands.class})` | Inject:1 | registerCommands |
| top-level / `com/damir00109/mixin/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Inject:1 | onServerTick |
| top-level / `com/damir00109/TPS.java` | `` |  | getTpsInfo, getAverage |
| top-level / `com/damir00109/VTPS.java` | `` |  | onInitialize, onServerTick, collectStatistics, getCurrentTPS, getCurrentMSPT, getCpuUsage, getRamUsagePercentage, getRamUsageFormatted, registerCommands |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
