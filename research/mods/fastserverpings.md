# Fast Server Pings

Review status: **Evidence inventory; behavioral review pending**

Project: [Fast Server Pings](https://modrinth.com/mod/fastserverpings)
Selected artifact version: `1.1.5+26.3`
Published implementation source: https://github.com/vansencool/FastServerPings
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Rewritten server ping pipeline using optimized Netty I/O, along with SWR caching.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `28654544c71c32c6b169905a48cb85f649a18f9d`
- `sha512`: `33987a90a3951b6069cdd7df5544bdf8b7465004666c19e0de294414038bf178e87d26e059379f1a944f8b05354fe35767d0705da689d05d3bd373c78361db8a`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 17
Reconstructed Java files: 13

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "net.vansen.fastserverpings.FastServerPings"
  ]
}
```

**depends**

```json
{
  "fabricloader": "*",
  "minecraft": ">=26.1- <26.4-"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/vansen/fastserverpings/cache/CacheEntry.java` | `` |  | CacheEntry |
| top-level / `net/vansen/fastserverpings/cache/FastPingCache.java` | `` |  | get, put, isFresh |
| top-level / `net/vansen/fastserverpings/command/FastPingCommand.java` | `` |  | register |
| top-level / `net/vansen/fastserverpings/FastServerPings.java` | `` |  | onInitializeClient |
| top-level / `net/vansen/fastserverpings/metrics/PingAvgMetrics.java` | `` |  | start, end, toggleEnable, sendAndReset |
| top-level / `net/vansen/fastserverpings/mixin/ServerPingerMixin.java` | `value={ServerStatusPinger.class})` | Invoker:1, Inject:1 | fastping$findTranslatingVersionSetter, fastping$setTranslatingVersion, pingWithRetry, fastping$buildPlayerListSummary, fastping$add |
| top-level / `net/vansen/fastserverpings/pipeline/FastPing.java` | `` |  | log, ping, initChannel, pinger, eventLoopGroup, parse, parseMotd, channelActive, channelRead, channelInactive, handlePacket, exceptionCaught, handshakeBuf, statusRequestBuf, pingPacket, frame |
| top-level / `net/vansen/fastserverpings/pipeline/srv/Resolved.java` | `` |  | Resolved |
| top-level / `net/vansen/fastserverpings/pipeline/srv/SrvResolver.java` | `` |  | resolve, Cached |
| top-level / `net/vansen/fastserverpings/pipeline/status/Status.java` | `` |  | Status |
| top-level / `net/vansen/fastserverpings/pipeline/status/StatusType.java` | `` |  |  |
| top-level / `net/vansen/fastserverpings/pipeline/utils/VarIntUtils.java` | `` |  | writeVarInt, readVarInt |
| top-level / `net/vansen/fastserverpings/servers/PresetServers.java` | `` |  | addServers, removeServers |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
