# Serverlist Fix

Review status: **Behavioral static review**

Project: [Serverlist Fix](https://modrinth.com/mod/serverlist-fix)
Selected artifact version: `1.0.2`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Simple mod that removes the thread limit for server pinging.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `6a2fb3e9ed0dbe3ac7028b27571fda9daf9b6cf2`
- `sha512`: `beab355fb6b4ca52b85a6bdf10ff5b247cc83d37e6e4afabc1ed48c19677ecd6ee9d11bd65c3a616f59bb0a6ae6ba89c74eb3a5edfabd3489ce2d7b613cfe571`

## Reviewed mechanism

Both reconstructed classes reviewed.

- Replaces the server-selection static ping executor with Executors.newCachedThreadPool, using daemon threads and an uncaught-exception handler.
- Cached pools create threads as needed and expire idle excess workers. The initializer only prints a startup message.

## Lifecycle, correctness, and failure questions

- Concurrency is not bounded by a small fixed worker count. Many slow pings can cause thread growth.
- The reconstructed static replacement does not show shutdown of the old executor; source/bytecode and mixin merge behavior should confirm its lifecycle.

## Checks needed to establish equivalence

- Test server lists with slow endpoints, screen transitions, repeat refreshes, executor shutdown/expiry, and overlap with other pinger mods.

## Relevance to AstFPS

Server-list UI latency; no gameplay FPS benefit.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 2
Reconstructed Java files: 2

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "eu.packsolite.serverlistfix.ServerlistFix"
  ]
}
```

**depends**

```json
{
  "minecraft": [
    ">=26.3"
  ]
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `eu/packsolite/serverlistfix/mixin/MultiplayerServerListWidgetMixin.java` | `value={ServerSelectionList.class})` |  |  |
| top-level / `eu/packsolite/serverlistfix/ServerlistFix.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
