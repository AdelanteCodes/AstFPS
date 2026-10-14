# Optis

Review status: **Evidence inventory; behavioral review pending**

Project: [Optis](https://modrinth.com/mod/optis)
Selected artifact version: `1.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Optis is a client-side texture memory optimizer for Minecraft.
It tracks texture usage and dynamically manages VRAM to keep performance smooth.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `6ea8781c82ca7501b161fb8b41ddcbb719f6c73b5b40d5bec8e26dc3aced9ee720f6031a7bd49aaafaa2f790374f228444534207c2e8367199f61d87de2e0d09`
- `sha1`: `1f36a3fd2b9446b7685f902c16a50c0c3dc25419`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 25
Reconstructed Java files: 24

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "optis.OptisClient"
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
| top-level / `optis/config/OptisConfig.java` | `` |  | load, get, save, createConfigDirectory, read, readInt, readBoolean, validate, clamp |
| top-level / `optis/debug/OptisDebugOverlay.java` | `` |  | register, extract, buildLines, extractLines |
| top-level / `optis/mixin/client/AbstractTextureInvoker.java` | `value={AbstractTexture.class})` | Invoker:1 |  |
| top-level / `optis/mixin/client/DynamicTextureInvoker.java` | `value={DynamicTexture.class})` | Invoker:1 |  |
| top-level / `optis/mixin/client/ReloadableTextureMixin.java` | `value={ReloadableTexture.class})` | Inject:1 | optis$trackReload |
| top-level / `optis/mixin/client/TextureAtlasMixin.java` | `value={TextureAtlas.class})` | Inject:1 | optis$trackAtlasCreate |
| top-level / `optis/mixin/client/TextureManagerAccessor.java` | `value={TextureManager.class})` | Accessor:2 |  |
| top-level / `optis/mixin/client/TextureManagerMixin.java` | `value={TextureManager.class})` | Inject:2 | optis$trackRegistration, optis$trackUsage |
| top-level / `optis/Optis.java` | `` |  |  |
| top-level / `optis/OptisClient.java` | `` |  | onInitializeClient |
| top-level / `optis/resource/OptisResourceReloadListener.java` | `` |  | register, onResourceManagerReload |
| top-level / `optis/runtime/OptisRuntime.java` | `` |  | getInstance, init, onClientTick, onResourceReload, getCurrentTick, getResourceReloadGeneration, getConfig, getTextureRegistry, getTextureResidencyManager, getTextureUploadQueue |
| top-level / `optis/scheduler/TextureLoadExecutor.java` | `` |  | getInstance, execute, getPendingLoadCount, newThread |
| top-level / `optis/scheduler/TextureUploadQueue.java` | `` |  | enqueue, processTick, discardAll, size, clearQueued |
| top-level / `optis/scheduler/TextureUploadTask.java` | `` |  | getId, getImage, getUploadAction, getDebugLabel, getReloadGeneration, execute, discard |
| top-level / `optis/texture/PlaceholderTexture.java` | `` |  | getInstance, getIdentifier, getTexture, isPlaceholderIdentifier, isPlaceholderTexture, ensureRegistered, resetForResourceReload, createTexture |
| top-level / `optis/texture/ResidencyState.java` | `` |  |  |
| top-level / `optis/texture/TextureDemoter.java` | `` |  | demoteToWarm, demoteToCold, removeTickListenerIfNeeded, releaseGpuResources |
| top-level / `optis/texture/TextureInspectionUtil.java` | `` |  | trackRegisteredTexture, trackTextureUsage, trackReloadedTexture, trackAtlasTexture, resolveTextureForRendering, canSafelyDemote, prepareTrackedTexture, logTrackedTexture |
| top-level / `optis/texture/TextureMemoryEstimator.java` | `` |  | estimateBytes, formatMegabytes |
| top-level / `optis/texture/TexturePromoter.java` | `` |  | getInstance, requestPromotion, requestWarmPromotion, requestColdPromotion, canPromoteFromCpuImage, canPromoteFromReload, promoteFromCpuImageOnClientThread, loadColdTexture, promoteFromReloadOnClientThread, recreateAndUploadTexture, addTickListenerIfNeeded, logPromotionFailure, logLoadFailure, closeQuietly |
| top-level / `optis/texture/TextureRegistry.java` | `` |  | getInstance, registerOrUpdate, getOrCreate, get, all, count, countByState, getEstimatedHotBytes, markUsed, clearForResourceReload, isLikelyCritical, isLikelyAtlasTexture, copyInto, classify, recalculateEstimatedBytes, logRegistration, normalizePath |
| top-level / `optis/texture/TextureResidencyManager.java` | `` |  | onClientTick, evaluatePolicy, classifyRealizedState, determineIntendedState, getTicksSinceLastUse, sortKey, logSummaryIfEnabled |
| top-level / `optis/texture/TrackedTexture.java` | `` |  | getId, getWidth, setWidth, getHeight, setHeight, getEstimatedBytes, setEstimatedBytes, getLastUsedTick, setLastUsedTick, markUsed, getState, setState, isCritical, setCritical, isAtlasTexture, setAtlasTexture, isUsingPlaceholder, setUsingPlaceholder, isPromotionQueued, setPromotionQueued, isPromotionFailureLogged, setPromotionFailureLogged, isLoadQueued, setLoadQueued, isLoadFailureLogged, setLoadFailureLogged, getCpuImage, setCpuImage, hasCpuImage, getGpuTexture, setGpuTexture, hasGpuTexture |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
