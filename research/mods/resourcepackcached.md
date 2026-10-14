# ResourcePackCached

Review status: **Evidence inventory; behavioral review pending**

Project: [ResourcePackCached](https://modrinth.com/mod/resourcepackcached)
Selected artifact version: `1.2.8`
Published implementation source: https://github.com/Furq07/ResourcePackCached
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Keeps server resource packs loaded, so they don't need to be reloaded when you rejoin.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `3e837ae16d24ead8037bde880ac121f5f5295716`
- `sha512`: `3c4c8b5e59ced423315c33c143e773beb7487d4c6fc05a5de93187a6bcaaf28ce9932c692f56786274e8a3bc871a1613d4529a92a8937cfb374a06144ba6e624`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 8
Reconstructed Java files: 6

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "dev.furq.resourcepackcached.ResourcePackCached"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.17",
  "minecraft": ">=26.1 <=26.3"
}
```

**accessWidener**

```json
"rpc.ct"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/furq/resourcepackcached/mixin/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | Inject:1 | onHandleLogin |
| top-level / `dev/furq/resourcepackcached/mixin/DownloadedPackSourceMixin.java` | `value={DownloadedPackSource.class})` | Redirect:1, Inject:2 | onStartReload, onConfigureForServerControl, onConfigureForLocalWorld |
| top-level / `dev/furq/resourcepackcached/mixin/JoinMultiplayerScreenMixin.java` | `value={JoinMultiplayerScreen.class})` | Inject:3 | rpc$placeButton, rpc$disarmConfirm, rpc$onResetPressed, onInit, onTick, onRepositionElements |
| top-level / `dev/furq/resourcepackcached/mixin/ServerPackManagerMixin.java` | `value={ServerPackManager.class})` | Inject:5 | onPushPack, afterDownload, onRegisterForUpdate, onTriggerReloadIfNeeded, onPopAll |
| top-level / `dev/furq/resourcepackcached/ResourcePackCached.java` | `` |  | onInitializeClient, packsToLoad, onSuccess, onFailure |
| top-level / `dev/furq/resourcepackcached/utils/CachingUtils.java` | `` |  | normalizeServerAddress, getCurrentServerAddress, readCacheData, writeCacheFile, writeCacheFile, updateCachedServer, readCacheFile, isCachedResourcePack, clearCacheFile, unloadAllPacks, resetCachedPacks, onNewConnection, onGameJoin, CacheData |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
