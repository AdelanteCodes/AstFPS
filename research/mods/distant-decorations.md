# Distant Decorations

Review status: **Evidence inventory; behavioral review pending**

Project: [Distant Decorations](https://modrinth.com/mod/distant-decorations)
Selected artifact version: `2.0.0`
Published implementation source: https://github.com/justbecauseph/distant-decorations
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Distant Decorations is a high-performance Fabric framework that lets participating mods persist and render decorative block-entity visuals far beyond vanilla chunk distances.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha512`: `45fdde055a7e576a009420922f57b8b901c875882b70e12abcea09630da5f67351398eb79bdfe34128c17cf539e7bfb64b8a194712ef799e96122647adb85b25`
- `sha1`: `0414a6f217d0a6b37b7c854fa006947b3b39f5e3`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 43
Reconstructed Java files: 35

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "me.justbecause.distantdecorations.DistantDecorations"
  ],
  "client": [
    "me.justbecause.distantdecorations.client.DistantDecorationsClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "26.3",
  "java": ">=25",
  "fabric-api": ">=0.161.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/justbecause/distantdecorations/api/client/ClientDecorationRegistry.java` | `` |  | registerRenderer, getRenderer, getRenderers |
| top-level / `me/justbecause/distantdecorations/api/client/DecorationClientRenderer.java` | `` |  |  |
| top-level / `me/justbecause/distantdecorations/api/DecorationId.java` | `` |  | DecorationId, writeToNetwork, readFromNetwork, writeToStream, readFromStream |
| top-level / `me/justbecause/distantdecorations/api/DecorationProvider.java` | `` |  |  |
| top-level / `me/justbecause/distantdecorations/api/DecorationRecord.java` | `` |  | DecorationRecord, pos, writeToNetwork, readFromNetwork, writeToStream, readFromStream, equals, hashCode |
| top-level / `me/justbecause/distantdecorations/api/DecorationRegistry.java` | `` |  | registerType, registerProvider, unregisterProvider, getType, getProvider, getTypes, getProviders, findProvider |
| top-level / `me/justbecause/distantdecorations/api/DecorationType.java` | `` |  | id, encode, decode, toBytes, fromBytes, equals, hashCode, toString |
| top-level / `me/justbecause/distantdecorations/client/DistantDecorationsClient.java` | `` |  | onInitializeClient, registerClientCommands |
| top-level / `me/justbecause/distantdecorations/client/network/ClientNetworkManager.java` | `` |  | getInstance, init, triggerSubscriptionRefresh, sendClientHello, sendSubscriptionUpdate |
| top-level / `me/justbecause/distantdecorations/client/render/DecorationRenderManager.java` | `` |  | getInstance, getOrCreateWorld, getWorld, getHandoffTracker, getBudget, clearAll, renderFrame |
| top-level / `me/justbecause/distantdecorations/client/render/LiveHandoffTracker.java` | `` |  | onChunkLoaded, onChunkUnloaded, clear, isSuppressed, getState |
| top-level / `me/justbecause/distantdecorations/client/render/RenderBudget.java` | `` |  | getMaxSubmissionsPerFrame, setMaxSubmissionsPerFrame, getMinProjectedPixelSize, setMinProjectedPixelSize, getMaxRenderDistance, setMaxRenderDistance, calculatePriority, RenderCandidate, record |
| top-level / `me/justbecause/distantdecorations/client/spatial/ClientDecoration.java` | `` |  | record, id, bounds, revision, decodedPayload, renderer, isValid |
| top-level / `me/justbecause/distantdecorations/client/spatial/ClientDecorationRegion.java` | `` |  | regionX, regionZ, revision, setRevision, bounds, size, isEmpty, getAllDecorations, getAllRecords, getCells, getCellForBlock, putBulk, addOrUpdate, remove, clear, recalculateBounds |
| top-level / `me/justbecause/distantdecorations/client/spatial/ClientDecorationWorld.java` | `` |  | dimension, packRegionKey, getRegion, getOrCreateRegion, getLoadedRegions, putSnapshotPart, putSnapshot, applyDelta, unloadRegion, clear, getAllRegions, getTotalDecorationsCount, PendingDelta |
| top-level / `me/justbecause/distantdecorations/client/spatial/DecorationRenderCell.java` | `` |  | cellX, cellZ, getBounds, getDecorations, isEmpty, size, addWithoutBoundsRecalc, addOrUpdate, addOrUpdate, remove, clear, calculateDefaultBounds, recalculateBounds |
| top-level / `me/justbecause/distantdecorations/client/spatial/ProjectionMetrics.java` | `` |  | ProjectionMetrics, of, calculateProjectedPixelSize, calculateProjectedPixelSize, getDistanceSq, getDistanceSq |
| top-level / `me/justbecause/distantdecorations/config/DistantDecorationsConfig.java` | `` |  | isMasterEnabled, setMasterEnabled, isClientRenderingEnabled, setClientRenderingEnabled, isBenchmarkMode, setBenchmarkMode, getClientSubscriptionRadiusChunks, setOnSubscriptionRadiusChanged, setClientSubscriptionRadiusChunks, getMinProjectedPixelSize, setMinProjectedPixelSize, getMaxRenderDistance, setMaxRenderDistance, isProviderEnabled |
| top-level / `me/justbecause/distantdecorations/DistantDecorations.java` | `` |  | id, onInitialize, registerCommands, publish, publish, remove |
| top-level / `me/justbecause/distantdecorations/integration/chunky/ChunkyIngestService.java` | `` |  | onChunkCompleted, commitChunk |
| top-level / `me/justbecause/distantdecorations/mixin/chunky/MixinFabricWorld.java` | `value={FabricWorld.class}, remap=false)` | WrapOperation:1 | captureGeneratedChunk |
| top-level / `me/justbecause/distantdecorations/mixin/DistantDecorationsMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `me/justbecause/distantdecorations/mixin/MixinBlockEntity.java` | `value={BlockEntity.class})` | Inject:1 | dd$onSetChanged |
| top-level / `me/justbecause/distantdecorations/mixin/MixinLevelChunk.java` | `value={LevelChunk.class})` | Inject:3 | dd$onAddAndRegisterBlockEntity, dd$onSetBlockEntity, dd$onRemoveBlockEntity |
| top-level / `me/justbecause/distantdecorations/network/c2s/C2SClientHello.java` | `` |  | type |
| top-level / `me/justbecause/distantdecorations/network/c2s/C2SSubscriptionUpdate.java` | `` |  | type |
| top-level / `me/justbecause/distantdecorations/network/NetworkHandler.java` | `` |  | init |
| top-level / `me/justbecause/distantdecorations/network/s2c/S2CRegionDelta.java` | `` |  | type |
| top-level / `me/justbecause/distantdecorations/network/s2c/S2CRegionSnapshot.java` | `` |  | type |
| top-level / `me/justbecause/distantdecorations/network/s2c/S2CRegionUnload.java` | `` |  | type |
| top-level / `me/justbecause/distantdecorations/server/ServerDecorationManager.java` | `` |  | getInstance, init, openIndex, openIndex, openIndex, handleLevelUnload, retryPendingRecovery, handleServerStopping, getPendingRecoveryIndices, isStoragePendingRecovery, registerIndexForTesting, registerRecoveryForTesting, clearForTesting, getIndex, getIndex, publish, publish, remove |
| top-level / `me/justbecause/distantdecorations/server/ServerNetworkManager.java` | `` |  | getInstance, onPlayerJoin, onPlayerLeave, handleClientHello, handleSubscriptionUpdate, updateSubscriptions, resetSubscriptionState, tick, tick, tickInternal, chunkSnapshot, estimatePacketBytes, broadcastDelta, registerSubscriptionForTesting, registerTestSubscription, getPendingPacketsCountForTesting, clearRetryCooldownForTesting, enqueuePendingJobForTesting, isRegionSyncedForTesting, isRegionStreamingForTesting, isRegionPendingForTesting, getFailedAttemptsForTesting, clearForTesting |
| top-level / `me/justbecause/distantdecorations/server/storage/ServerDecorationRegion.java` | `` |  | regionX, regionZ, revision, setRevision, incrementRevision, isDirty, markDirty, markClean, getLastAccessTime, touch, size, isEmpty, getAllRecords, getRecord, addOrUpdate, remove, getDecorationsInChunk, writeToStream, readFromStream |
| top-level / `me/justbecause/distantdecorations/server/storage/ServerDecorationWorldIndex.java` | `` |  | packRegionKey, chunkToRegionCoord, getLevel, getStorageDir, getLevelIdentifier, isRegionBlocked, blockRegionForTesting, unblockRegion, getOrCreateRegion, getRegion, getLoadedRegions, publish, publishTyped, remove, reconcileChunk, tick, performMaintenance, getTotalIndexedDecorations, getRegionFilePath, openInputStream, moveFileToQuarantine, loadRegionFromFileWithResult, isDiagnosedCorruption, handleDiagnosedCorruption, loadRegionFromFile, saveRegionToFile, saveAll, close, RegionLoadResult, success, missing, quarantined, quarantineFailed, readError |
| top-level / `me/justbecause/distantdecorations/telemetry/TelemetryMetrics.java` | `` |  | beginClientFrame, resetAll |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
