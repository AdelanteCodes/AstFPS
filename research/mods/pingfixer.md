# ServerPingFixer

Review status: **Behavioral static review**

Project: [ServerPingFixer](https://modrinth.com/mod/pingfixer)
Selected artifact version: `1.0.2+26.1-26.3`
Published implementation source: https://github.com/InvalidJoker/ServerPingFixer
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

ServerPingFixer fixes the issue where the first Minecraft server ping fails

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `ac2c3c2cc450346c2a62983d25f00f3af5432fda972f164316482fcffbf486e821bd73ed0c87194b0861155af2d1a156745b36c79ef0f729f2bc74c5d67a1a3d`
- `sha1`: `5045dfeaf0957a5df0eb012ac5a09803429ececf`

## Reviewed mechanism

Both reconstructed Java source files reviewed, including the anonymous packet-listener class.

- Wraps the server-status packet listener and forwards status/pong/acceptance events. On a non-success disconnect, increments a concurrent per-server attempt counter and queues a retry until the third failure.
- A tail hook on the pinger tick drains queued retry tasks. Retried pongs remove attempt state before invoking the normal callback; final failures and retry exceptions also clean up.

## Lifecycle, correctness, and failure questions

- The initial successful-listener path does not show the same counter cleanup as the retry pong callback. Successful disconnect recognition depends on a translation key.
- The static retry queue and attempt map can outlive a screen/pinger instance. Leaving the screen, changing server data, and retrying closed event-loop holders need lifecycle checks.

## Checks needed to establish equivalence

- Test first/second/third-attempt success and failure, legacy/status disconnect reasons, screen close before retry, repeated refresh, and retained map/queue entries.

## Relevance to Xe-Mod

Server-list reliability; not gameplay rendering performance.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 3
Reconstructed Java files: 2

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "de.joker.ServerPingFixer"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.1 <=26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `de/joker/mixin/ServerStatusPingerMixin.java` | `value={ServerStatusPinger.class})` | Inject:1, ModifyVariable:1 | runQueuedRetries, replaceListener, handleStatusResponse, handlePongResponse, onDisconnect, isAcceptingMessages, retryPing, isFinished, isFinishedReason, cleanup |
| top-level / `de/joker/ServerPingFixer.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
