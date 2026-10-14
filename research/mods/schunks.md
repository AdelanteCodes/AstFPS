# SeamlessChunks

Review status: **Evidence inventory; behavioral review pending**

Project: [SeamlessChunks](https://modrinth.com/mod/schunks)
Selected artifact version: `0.1.0-beta.7+26.3-fabric`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Smoother chunk loading with network-aware send rates, multiplayer fair share, and in-game tuning.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha512`: `3788f3cdc81edce4eb369c032c959163fd712791accf36a687a953a9eaefd49dbcbc75b9b7d6ae02f0c9169d35d4c309a8e0567f41407be440ff412669f1bcf2`
- `sha1`: `58c5514282ba54ae609443c0f966d849188ceeba`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 32
Reconstructed Java files: 30

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.rhintypler.fabric.seamlesschunksFabric"
  ],
  "client": [
    "com.rhintypler.client.SeamlessChunksFabricClient"
  ],
  "modmenu": [
    "com.rhintypler.fabric.client.SeamlessChunksModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "architectury": ">=22.0.2",
  "fabric-api": "*",
  "yet_another_config_lib_v3": ">=3.9.7"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `architectury_inject_seamlesschunks_common_4c5b8dcf04584b31a0dae154c3625435_cf412e2534f390a96515d62bb832c0f7b2dcbd53871951b319e02144291b7dbeseamlesschunkscommon010beta7devjar/PlatformMethods.java` | `` |  | getCurrentTarget |
| top-level / `com/rhintypler/ChunkOptimization.java` | `` |  |  |
| top-level / `com/rhintypler/client/ClientScreens.java` | `` |  | open, open |
| top-level / `com/rhintypler/client/HighSpecDetector.java` | `` |  | isHighSpec, getSystemMemoryBytes |
| top-level / `com/rhintypler/client/HighSpecNoticeScreen.java` | `` |  | init, extractRenderState, shouldCloseOnEsc |
| top-level / `com/rhintypler/client/metrics/ClientChunkLoadMetrics.java` | `` |  | register, recordBatchReceived, recordAckSent, recordDesiredRate, boostRate, clientPingMultiplier, logWindow, formatSeconds, formatRate, formatMultiplier |
| top-level / `com/rhintypler/client/SeamlessChunksClient.java` | `` |  | init, tryShowNotice |
| top-level / `com/rhintypler/client/SeamlessChunksClientScreens.java` | `` |  | register, create, isRegistered |
| top-level / `com/rhintypler/client/SeamlessChunksFabricClient.java` | `` |  | onInitializeClient |
| top-level / `com/rhintypler/client/SeamlessChunksYaclScreens.java` | `` |  | create, generalCategory, featuresCategory, networkCategory, serverCategory, clientCategory, boolOption, intSlider, floatSlider |
| top-level / `com/rhintypler/config/SeamlessChunksConfig.java` | `` |  | load, isOptimizationsEnabled, setOptimizationsEnabled, shouldHideHighSpecNotice, setHideHighSpecNotice, isNetworkAdaptationEnabled, setNetworkAdaptationEnabled, isMultiplayerFairShareEnabled, setMultiplayerFairShareEnabled, isChunkPriorityEnabled, setChunkPriorityEnabled, isWorkerPoolEnabled, setWorkerPoolEnabled, getWorkerPoolMode, setWorkerPoolMode, cycleWorkerPoolMode, getWorkerPoolThreads, setWorkerPoolThreads, isWorkerPoolActive, isCompatibilityMode, setCompatibilityMode, isDetailedStatisticsEnabled, setDetailedStatisticsEnabled, getLanPingThresholdMs, setLanPingThresholdMs, getHighPingThresholdMs, setHighPingThresholdMs, shouldSkipLightWait, shouldSkipSendSync, resetToDefaults, getStartChunksPerTick, setStartChunksPerTick, getMaxChunksPerTick, setMaxChunksPerTick, getMinChunksAfterAck, setMinChunksAfterAck, getInitialUnackBatches, setInitialUnackBatches, getChunkSendPassesPerTick, setChunkSendPassesPerTick, getDistanceManagerPassesPerTick, setDistanceManagerPassesPerTick, getMinBoostedChunksPerTick, setMinBoostedChunksPerTick, getClientBoostMultiplier, setClientBoostMultiplier, getHighPriorityRenderQuota, setHighPriorityRenderQuota, startChunksPerTick, maxChunksPerTick, minChunksAfterAck, initialUnackBatches, chunkSendPassesPerTick, distanceManagerPassesPerTick, minBoostedChunksPerTick, clientBoostMultiplier, highPriorityRenderQuota, ensureLoaded, read, save, parseFloat, parseInt, migrateLegacyClientConfig, configPath |
| top-level / `com/rhintypler/fabric/client/SeamlessChunksModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/rhintypler/fabric/seamlesschunksFabric.java` | `` |  | onInitialize |
| top-level / `com/rhintypler/metrics/ChunkLoadMetrics.java` | `` |  | register, recordLightWaitSkipped, recordSendSyncBypass, recordDistanceManagerPasses, recordChunkSendPass, recordChunksDispatched, recordClientAck, recordDesiredChunksPerTick, recordAckLatency, recordPriorityReorder, recordServerTps, lastServerTps, snapshot, logWindow, resetWindowBaselines, formatSeconds, formatRate, formatMultiplier, formatMs, formatTps, Snapshot |
| top-level / `com/rhintypler/mixin/ChunkHolderMixin.java` | `value={ChunkHolder.class})` | Inject:1 | seamlesschunks$skipSendSyncGate |
| top-level / `com/rhintypler/mixin/ChunkMapMixin.java` | `value={ChunkMap.class})` | Inject:1 | seamlesschunks$skipLightWait |
| top-level / `com/rhintypler/mixin/client/ChunkBatchSizeCalculatorMixin.java` | `value={ChunkBatchSizeCalculator.class})` | Inject:1 | seamlesschunks$raiseFloor |
| top-level / `com/rhintypler/mixin/client/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | Inject:2 | seamlesschunks$recordBatch, seamlesschunks$recordAck |
| top-level / `com/rhintypler/mixin/client/GameRendererMixin.java` | `value={GameRenderer.class})` | Inject:1 | seamlesschunks$skipWithoutCameraEntity |
| top-level / `com/rhintypler/mixin/client/PauseScreenMixin.java` | `value={PauseScreen.class})` | Inject:1 | seamlesschunks$addSettingsButton, isReturnToGameButton |
| top-level / `com/rhintypler/mixin/client/ScreenAccessor.java` | `value={Screen.class})` | Invoker:1 |  |
| top-level / `com/rhintypler/mixin/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Redirect:1 | seamlesschunks$sendChunksMultiple |
| top-level / `com/rhintypler/mixin/PlayerChunkSenderMixin.java` | `value={PlayerChunkSender.class})` | Inject:6 | seamlesschunks$initPipeline, seamlesschunks$adaptRate, seamlesschunks$markBatchSent, seamlesschunks$recordAckLatency, seamlesschunks$boostPipeline, seamlesschunks$prioritizeAndRecord |
| top-level / `com/rhintypler/mixin/ServerChunkCacheMixin.java` | `value={ServerChunkCache.class})` | Inject:1 | runDistanceManagerUpdates, seamlesschunks$extraDistanceUpdates |
| top-level / `com/rhintypler/network/NetworkRateAdapter.java` | `` |  | computeMultiplier, pingFactor, lossFactor |
| top-level / `com/rhintypler/priority/ChunkPrioritySorter.java` | `` |  | prioritize, score, sign |
| top-level / `com/rhintypler/seamlesschunks.java` | `` |  | init |
| top-level / `com/rhintypler/server/ServerLoadBalancer.java` | `` |  | computeFairShareMultiplier |
| top-level / `com/rhintypler/worker/ChunkWorkerMode.java` | `` |  | fromConfig, toConfig |
| top-level / `com/rhintypler/worker/ChunkWorkerPool.java` | `` |  | register, isActive, currentPoolSize, tasksCompleted, parallelBatches, resolveDesiredThreads, forEachIndex, notifyConfigChanged, onServerTick, ensurePool, shutdown, computePlayerWeights, orderPlayersByDemand, compute |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
