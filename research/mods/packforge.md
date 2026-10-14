# PackForge - Optimized Resource Pack Loading Time

Review status: **Evidence inventory; behavioral review pending**

Project: [PackForge - Optimized Resource Pack Loading Time](https://modrinth.com/mod/packforge)
Selected artifact version: `1.4.1`
Published implementation source: https://github.com/Teenkung123/packforge
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Faster resourcepack reloads and atlas overflow recovery for large resource packs.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `641f004d8b4fe8149d48f737ccbafe60c713e7c5`
- `sha512`: `98c54f99d005d05e37b89d29387cce10b713f94a11f11951fee45ef3450bd74ee0cfde7479af9c475115f697b173f3ba3d7289df0b3e32fcbe08ddd386516815`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 250
Reconstructed Java files: 129

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "com.teenkung.packforge.fabric.PackForgeFabric"
  ],
  "client": [
    "com.teenkung.packforge.fabric.PackForgeFabricClient"
  ],
  "modmenu": [
    "com.teenkung.packforge.client.config.PackForgeModMenuApi"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.1 <=26.3",
  "java": ">=25"
}
```

**accessWidener**

```json
"packforge.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/teenkung/packforge/client/atlas/AtlasDiagnostics.java` | `` |  | capture, observeLoaders, size, get, recordSupplier, start, stage, wallStage, wrap, observeSprite, recordSprite, decodeFinished, observeStream, read, read, observingRead, cpuNow, bounded, bind, retain, close, releaseIfUnused, Sample, close |
| top-level / `com/teenkung/packforge/client/atlas/AtlasLoadInvocation.java` | `` |  | current, diagnostics, call, bind, atlas, resourcePackUnboundedOwner, state, bindState |
| top-level / `com/teenkung/packforge/client/atlas/AtlasReport.java` | `` |  | logAtlas |
| top-level / `com/teenkung/packforge/client/atlas/AtlasRetry.java` | `` |  | stitch, isExactStitchFailure, halveAll, halveOne, closeReplaced, logCapUnavailable, logRetryUnavailable |
| top-level / `com/teenkung/packforge/client/atlas/AtlasSplitGuards.java` | `` |  | applyStartupGuards, removeUnsafeTargets |
| top-level / `com/teenkung/packforge/client/atlas/AtlasTimings.java` | `` |  | start, recordSource, recordDecode, recordStitch, recordMip, recordUpload, recordSource, recordDecode, recordStitch, recordMip, recordUpload, logAtlas, logAtlas, resetForReload, record, ms, csv |
| top-level / `com/teenkung/packforge/client/atlas/BoundedMipWork.java` | `` |  | runWorker, claim, isStopped, fail, stop, disarmQueued, workerFinished, admission, close, run, Ticket |
| top-level / `com/teenkung/packforge/client/atlas/BoundedSpriteDecode.java` | `` |  | capturePlan, decode, filterAndPropagateCancellation, closeAll, Plan, atlasCapApplies, atlasRetryApplies |
| top-level / `com/teenkung/packforge/client/atlas/CappedSpriteResourceLoader.java` | `` |  | wrap, loadSprite |
| top-level / `com/teenkung/packforge/client/atlas/DiagnosticSpriteResourceLoader.java` | `` |  | wrap |
| top-level / `com/teenkung/packforge/client/atlas/MipSpriteAccess.java` | `` |  |  |
| top-level / `com/teenkung/packforge/client/atlas/SolidifyKernel.java` | `` |  | solidify, apply, nearer |
| top-level / `com/teenkung/packforge/client/atlas/SolidifyQueue.java` | `` |  | enqueue, dequeueInt, isEmpty, size, capacity, clear, trim, enqueueFirst, dequeueLastInt |
| top-level / `com/teenkung/packforge/client/atlas/SolidifyQueueWorkspace.java` | `` |  | open, newQueue, newQueue, close |
| top-level / `com/teenkung/packforge/client/atlas/SpriteCap.java` | `` |  | computeScale |
| top-level / `com/teenkung/packforge/client/atlas/SpriteMetadataCache.java` | `` |  | bind, enter, enter, withAtlas, withAtlas, recordConstructed, findState, contains, finish, fail, resetForReload, removeLocked, contextKey, closeDistinct, addConstructed, record, replace, spriteCount, replacementCount, stitchAttempts, plan, atlas, matches, removeAndClose, closeAll, closeOnce, complete, abort, close, sprite, image, frameSize, animation, additional, texture |
| top-level / `com/teenkung/packforge/client/atlas/SpriteMipPreparation.java` | `` |  | submit, tryParallel, eligible, scratchBytes, observeWorker, runOriginal, attachSource, sourceFinished, cancellationRequested, requestCancellation, cancelSources, finishAfterCommand, detach, cancel |
| top-level / `com/teenkung/packforge/client/atlas/SpriteResize.java` | `` |  | resize |
| top-level / `com/teenkung/packforge/client/compat/ImmediatelyFastFontAtlasCompat.java` | `` |  | disableReenableForPackRemoval, disableReenableForPackRemoval, setStaticConfigBoolean |
| top-level / `com/teenkung/packforge/client/compat/MinecraftGuiBridge.java` | `` |  |  |
| top-level / `com/teenkung/packforge/client/compat/MinecraftGuiCompat.java` | `` |  | setScreen, screen, setOverlay, toastManager, bridge |
| top-level / `com/teenkung/packforge/client/compat/ResourcePackUnboundedBridge.java` | `` |  | configuredOwner, resolve, registerFallbackProviderIfAvailable, registerFallbackProvider, logFailure, Access, invoke, supports, resize, integer |
| top-level / `com/teenkung/packforge/client/config/PackForgeConfigDraft.java` | `` |  | working, dirty, reset, resetAll, discard, apply |
| top-level / `com/teenkung/packforge/client/config/PackForgeConfigScreen.java` | `` |  | init, initRecommendations, cancelRecommendations, onClose, addCategoryButtons, categoryText, rebuildList, matches, apply, closeWithoutSaving, hasInvalidInput, setInputValidity, updateDoneButton, booleanText, description, description, getRowWidth, extractContent, children, narratables, visitWidgets, place, createControl, updateInteger, setInvalid, extractContent, children, narratables, visitWidgets, place |
| top-level / `com/teenkung/packforge/client/config/PackForgeConfigScreenLayout.java` | `` |  | pageSize, pageSize |
| top-level / `com/teenkung/packforge/client/config/PackForgeConfigScreenModel.java` | `` |  | allOptions, availableOptions, availableOptions, availableOptions, availableCategories, sameValues, recommendedChanges, previewRecommendations, recommendedChanges, optimizationDecision, hasIndependentDecision, buildOptions, bool, integer, stringList, validateCommon, parseList, id, translationKey, RecommendedChange, apply, get, set, reset, sameValue, translationKey, get, set, valid, reset, sameValue, get, format, set, reset, sameValue |
| top-level / `com/teenkung/packforge/client/config/PackForgeModMenuApi.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/teenkung/packforge/client/config/ResourcePackButtonLayout.java` | `` |  | findPlacement, moveRight, moveLeft, firstCollision, Rectangle, right, bottom, contains, overlaps, ActionButtonAnchors |
| top-level / `com/teenkung/packforge/client/config/ResourcePackButtonLayoutTracker.java` | `` |  | shouldReflow, beginSignature, includeWidget, mix |
| top-level / `com/teenkung/packforge/client/diagnostics/AsyncDiagnosticCsv.java` | `` |  | append, executor |
| top-level / `com/teenkung/packforge/client/diagnostics/ReloadPhaseTimings.java` | `` |  | start, record, snapshot, writeCsvAsync, reset, csv, Phase |
| top-level / `com/teenkung/packforge/client/font/FontPreparationBundle.java` | `` |  | options, selections, selectionsByStack, diagnostics, coordinator, close, selectionFor, selectionFor |
| top-level / `com/teenkung/packforge/client/font/FontPreparationCoordinator.java` | `` |  | ensureBookkeeping, current, executor, finalizeProviders, finalizeReserved, selection, supportedCount, compute, prepareOrdered, setSelectionIfAbsent, pair, resolve, diagnostics, close, hashCode, equals, OrderedGlyphs, Statistics |
| top-level / `com/teenkung/packforge/client/font/FontPreparedSelection.java` | `` |  | close, providers, activeProviders, glyphsByWidth, elapsedNs, computeOwned |
| top-level / `com/teenkung/packforge/client/font/FontProviderStackKey.java` | `` |  | of, equals, hashCode, Slot, equals, hashCode |
| top-level / `com/teenkung/packforge/client/font/FontReloadDiagnostics.java` | `` |  | snapshot, snapshot, snapshot, startApply, recordFontSetCreate, finishApply, writeCsv, ms, csv, enabled, Snapshot |
| top-level / `com/teenkung/packforge/client/font/FontSelectionRegistry.java` | `` |  | preparationHooksEnabled, prepare, prepareAsync, prepareAsync, reserveBookkeeping, closeSelections, beginApply, currentSelection, currentSelection, currentSelection, currentBundle, beginFontSet, endFontSet, clear, resetForReload, store, fontSets, reloadFeatures, discard |
| top-level / `com/teenkung/packforge/client/font/FontSelectionSummary.java` | `` |  | aligned |
| top-level / `com/teenkung/packforge/client/font/PackForgeFontSetAccess.java` | `` |  |  |
| top-level / `com/teenkung/packforge/client/font/SpaceAdvanceCodec.java` | `` |  | wrap, decode, fallback, eligible, decodeJson, encode, keys, toString |
| top-level / `com/teenkung/packforge/client/mixin/atlas/ParallelMipMixin.java` | `value={SpriteLoader.class})` | WrapOperation:2 | packforge$parallelMipFuture, packforge$parallelMipLoop |
| top-level / `com/teenkung/packforge/client/mixin/atlas/SpriteContentsMixin.java` | `value={SpriteContents.class})` | Inject:2 | packforge$mipImages, packforge$recordContents, packforge$recordSimpleContents |
| top-level / `com/teenkung/packforge/client/mixin/atlas/SpriteLoaderMixin.java` | `value={SpriteLoader.class})` | WrapOperation:3, WrapMethod:3 | packforge$wrapLoader, packforge$associateAtlasState, packforge$timeSources, packforge$timeMipChain, packforge$retryOriginalStitch, packforge$decodeBounded, packforge$resourcePackUnboundedOwnsAtlas |
| top-level / `com/teenkung/packforge/client/mixin/atlas/SpriteResourceLoaderMixin.java` | `value={SpriteResourceLoader.class})` | WrapOperation:1 | packforge$timeSpriteStream |
| top-level / `com/teenkung/packforge/client/mixin/atlas/TextureAtlasMixin.java` | `value={TextureAtlas.class})` | WrapMethod:1 | packforge$timeUpload |
| top-level / `com/teenkung/packforge/client/mixin/atlas/TextureUtilMixin.java` | `value={TextureUtil.class})` | WrapMethod:1, WrapOperation:1 | packforge$accountSolidifyQueue, packforge$boundedSolidifyQueue |
| top-level / `com/teenkung/packforge/client/mixin/compat/Gui26_2Mixin.java` | `value={Gui.class})` |  | packforge$setScreen, packforge$screen, packforge$setOverlay, packforge$toastManager |
| top-level / `com/teenkung/packforge/client/mixin/compat/GuiCompatMixinPlugin.java` | `` |  | shouldApplyMixin, hasMethod |
| top-level / `com/teenkung/packforge/client/mixin/compat/MinecraftGui26_1Mixin.java` | `value={Minecraft.class})` |  | packforge$setScreen, packforge$screen, packforge$setOverlay, packforge$toastManager |
| top-level / `com/teenkung/packforge/client/mixin/compat/ShaderManagerCompatMixin.java` | `value={ShaderManager.class})` | Inject:1 | packforge$beforeShaderApply |
| top-level / `com/teenkung/packforge/client/mixin/config/PackSelectionScreenMixin.java` | `value={PackSelectionScreen.class}, priority=100)` | Inject:3 | packforge$addConfigButton, packforge$repositionConfigButton, packforge$detectLateConfigButtons, packforge$refreshConfigButtonPlacement, packforge$buttonCollides, packforge$placeConfigButton, packforge$overlapsVertically, packforge$overlaps, packforge$rectangle |
| top-level / `com/teenkung/packforge/client/mixin/font/FontManagerMixin.java` | `value={FontManager.class})` | WrapMethod:4 | packforge$bindFontId, packforge$prepareProviderSelection, packforge$coordinateWarmup, packforge$apply, packforge$fontOptions |
| top-level / `com/teenkung/packforge/client/mixin/font/FontManagerPreparationAccessor.java` | `targets={"net.minecraft.client.gui.font.FontManager$Preparation"})` | Accessor:1 |  |
| top-level / `com/teenkung/packforge/client/mixin/font/FontProviderGlyphMapAccessor.java` | `value={BitmapProvider.class, UnihexProvider.class, TrueTypeGlyphProvider.class})` | Accessor:1 |  |
| top-level / `com/teenkung/packforge/client/mixin/font/FontSetMixin.java` | `value={FontSet.class})` | Invoker:1, WrapMethod:1 | packforge$reloadPreselectedIfAvailable, packforge$reloadPreselected |
| top-level / `com/teenkung/packforge/client/mixin/font/SpaceProviderDefinitionCodecMixin.java` | `value={SpaceProvider.Definition.class})` | WrapOperation:1 | packforge$boundedAdvanceDecoding |
| top-level / `com/teenkung/packforge/client/mixin/model/FaceBakeryMixin.java` | `value={FaceBakery.class})` | Redirect:1 | packforge$clampTransparencyProbe |
| top-level / `com/teenkung/packforge/client/mixin/model/ModelManagerMixin.java` | `value={ModelManager.class})` | WrapOperation:4 | packforge$loadBlockModelsBatched, packforge$observeModelEnumeration, packforge$observeOriginalModelParse, packforge$observeNeoForgeModelParse |
| top-level / `com/teenkung/packforge/client/mixin/observe/LoadingOverlayTraceMixin.java` | `value={LoadingOverlay.class})` | Inject:1 | packforge$traceReload |
| top-level / `com/teenkung/packforge/client/mixin/options/OptionsMixin.java` | `value={Options.class})` | Inject:2 | packforge$captureOldPacks, packforge$capturePackDiff |
| top-level / `com/teenkung/packforge/client/mixin/startup/GuiStartupMixin.java` | `value={Gui.class})` | Inject:2 | packforge$initialScreensStart, packforge$initialScreensEnd |
| top-level / `com/teenkung/packforge/client/mixin/startup/MainStartupMixin.java` | `value={Main.class})` | Inject:1 | packforge$mainStart |
| top-level / `com/teenkung/packforge/client/mixin/startup/MinecraftStartupMixin.java` | `value={Minecraft.class})` | Inject:10 | packforge$constructorEnd, packforge$runStart, packforge$initialScreensStart, packforge$initialScreensEnd, packforge$resourceLoadFinished, packforge$gameLoadFinished, packforge$tickStart, packforge$tickEnd, packforge$renderStart, packforge$renderEnd, packforge$sampleStart, packforge$sampleEnd |
| top-level / `com/teenkung/packforge/client/mixin/ui/LoadingOverlayMixin.java` | `value={LoadingOverlay.class})` | Invoker:1, Inject:4 | packforge$skipFadeOut, packforge$showReloadSummaryToast, packforge$drawOngoingBar, packforge$drawReloadStatus |
| top-level / `com/teenkung/packforge/client/model/ModelBatchPlan.java` | `` |  | create, Range |
| top-level / `com/teenkung/packforge/client/model/ModelParseTimings.java` | `` |  | start, recordList, recordRead, recordParse, recordCollect, recordBatch, log, reset, record, ms |
| top-level / `com/teenkung/packforge/client/model/ModelSourceDiagnostics.java` | `` |  | observe, start, enumerated, parse, record, released, read, read, update, skip, ready, markSupported, mark, reset, close, run |
| top-level / `com/teenkung/packforge/client/PackForgeClient.java` | `` |  | initClient |
| top-level / `com/teenkung/packforge/client/ui/ReloadSummaryToast.java` | `` |  | pump, showPending, refresh, width, clipped |
| top-level / `com/teenkung/packforge/concurrent/CoalescingExecutor.java` | `` |  | bounded, execute, submit, completeSubmission, rejectSubmission, drain, runEntry, throwUnchecked, run |
| top-level / `com/teenkung/packforge/concurrent/ModelSchedulingPlan.java` | `` |  | ModelSchedulingPlan, current, from |
| top-level / `com/teenkung/packforge/concurrent/OrderedAsync.java` | `` |  | map, attach, detach, recordTerminalRetention, retentionSnapshot, cancel, start, runWorker, publish, recordFailure, cancel, finishWorker, finishIfReady, orderedResultList, takeOwnedResultsLocked, retentionSnapshot, retainedResultSlotsLocked, disposeAll, disposeOne, attachCleanupFailures, claimChunk, chunkCount, workerLimit, compareTo |
| top-level / `com/teenkung/packforge/concurrent/PreparationBudget.java` | `` |  | openScope, openScope, limit, used, peak, tryReserve, used, isRetired, onRetire, retire, close, bytes, reduceTo, close |
| top-level / `com/teenkung/packforge/config/FeatureFlags.java` | `` |  | reloadOptimizerEnabled, resourceReadReuseEnabled, optimizationMemoryMiB, largeAtlasFixerEnabled, loaderIndexEnabled, loaderZipPoolEnabled, loaderTimingsEnabled, reloadListenerTimingsEnabled, shaderApplyStallDiagnosticsEnabled, immediatelyFastFontAtlasCompatEnabled, loadingStatusOverlayEnabled, loadingScreenFadeOutDisabled, reloadSummaryToastEnabled, modelUvTransparencyClampEnabled, fontReloadDiagnosticsEnabled, fontPrepareProviderSelectionEnabled, fontBitmapProviderCacheEnabled, atlasPhaseTimingsEnabled, atlasMipParallelEnabled, atlasMipBatchSize, atlasDecodeBatchingEnabled, atlasDecodeBatchSize, modelParseBatchingEnabled, modelParseBatchSize, modelParseTimingEnabled, modelAdaptiveBatchingEnabled, modelDuplicateParseCacheEnabled, atlasCapEnabled, atlasCapPx, atlasRetryEnabled, atlasRetryMaxAttempts, atlasExcludes, atlasExclusionIds, experimentalAtlasSplitConfigured, atlasSplitFallbackToDownscale, atlasSplitDiagnostics, startupOptimizerEnabled, startupTimingsEnabled, startupStatusOverlayEnabled, startupExecutorTuningEnabled, startupWorkerThreads, startupThreadPriority, startupSkipWithSmoothBoot, startupAsyncDataParsingEnabled, startupAsyncClassScanEnabled, startupAsyncFontAtlasEnabled |
| top-level / `com/teenkung/packforge/config/OptimizationPlan.java` | `` |  | capture, create, decision, enabled, decisions, shaderGuard, withdrawn, externalOwner, configured, requested, Decision |
| top-level / `com/teenkung/packforge/config/PackForgeCapabilities.java` | `` |  | supports, target, available, unavailable, unknownIdentifiers, unavailableReason, loadFromClasspath |
| top-level / `com/teenkung/packforge/config/PackForgeCapability.java` | `` |  |  |
| top-level / `com/teenkung/packforge/config/PackForgeCapabilityProfile.java` | `` |  | currentDevelopment, safeFallback, fromProperties, target, supports, available, unavailable, unknownIdentifiers, unavailableReason, immutableCapabilities, copy |
| top-level / `com/teenkung/packforge/config/PackForgeConfig.java` | `` |  | get, isLoaded, load, save, applyAndSave, copyOf, write, configFile, validateKnownFields, applyMissingDefaults, sanitize, clamp, SaveResult, success, failure |
| top-level / `com/teenkung/packforge/config/ReloadFeatureSnapshot.java` | `` |  | ReloadFeatureSnapshot, capture, statusTrackingEnabled, externalFeedbackEnabled, detailedTaskTelemetryEnabled, taskExecutorWrappingEnabled, atlasExcluded, capExclusions, boundedWorkerBudget, positive |
| top-level / `com/teenkung/packforge/fabric/FabricPackForgePlatform.java` | `` |  | loaderName, isModLoaded, configDirectory, gameDirectory, isDevelopmentEnvironment, backgroundExecutor, logPlatformInfo |
| top-level / `com/teenkung/packforge/fabric/PackForgeFabric.java` | `` |  | onInitialize |
| top-level / `com/teenkung/packforge/fabric/PackForgeFabricClient.java` | `` |  | onInitializeClient |
| top-level / `com/teenkung/packforge/internal/compat/MixinCompatibility.java` | `` |  | shouldApply |
| top-level / `com/teenkung/packforge/internal/loader/SharedZipFileAccessBridge.java` | `` |  |  |
| top-level / `com/teenkung/packforge/loader/InitialUiResourceReadiness.java` | `` |  | hasNamedListener, isListenerBoundary, hasIntermediaryClass |
| top-level / `com/teenkung/packforge/loader/InputStreamSupplier.java` | `` |  |  |
| top-level / `com/teenkung/packforge/loader/LoaderTimings.java` | `` |  | recordGetResource, recordGetResource, recordGetNamespaces, recordGetNamespaces, recordListResources, recordListResources, onReloadStart, onReloadStart, onReloadEnd, onReloadEnd, recordListenerWall, recordListenerWall, recordListenerPrepare, recordListenerPrepare, recordListenerApply, recordListenerApply, onReloadComplete, onReloadComplete, logApplyStalls, writeReloadCountersCsvAsync, writeReloadCountersCsv, writeListenerCsvAsync, writeListenerCsv, csv, current, loaderTimingsEnabled, listenerTimingsEnabled, backgroundExecutor, ms, ListenerReport |
| top-level / `com/teenkung/packforge/loader/PackArchiveState.java` | `` |  | index, pooledSupplier, status, indexedZipFile, indexFailure, isClosed, invalidate, close, uninitialized, ready, failed, bypassedDuplicates, IndexFailure |
| top-level / `com/teenkung/packforge/loader/PackIndex.java` | `` |  | build, zipFile, entryFor, forEachFileWithPrefix, forEachEntryWithPrefix, forEachWithPrefix, entriesWithPrefix, hasMoreElements, nextElement, centralEntriesWithPrefix, namespacesFor, namespacesFor, hasDuplicatePath, size, entryCount, duplicatePathCount, prefixCacheSize, namespaceCacheSize, cachedPrefixOrdinalCount, cachesEnabled, invalidateCaches, prefixOrdinals, buildNamespaces, prefixRange, lowerBound, cachedPrefix, cachePrefix, cachedNamespace, cacheNamespace, stableSortOrdinals, initialEntryCapacity, initialMapCapacity, grownCapacity, immutableSet, IndexedEntry, NamespaceCacheKey, NamespaceResult, PrefixCacheKey, PrefixRange |
| top-level / `com/teenkung/packforge/loader/PackIndexCache.java` | `` |  | getOrBuild, invalidate, close |
| top-level / `com/teenkung/packforge/loader/ReloadDirectoryIndex.java` | `` |  | list, namespace, statistics, close, list, close, Statistics, open, release, close, discardIfUnused, visit, finish, close |
| top-level / `com/teenkung/packforge/loader/ReloadExecutionContext.java` | `` |  | start, start, startForTesting, current, bind, bindRunnable, bindPreparationExecutor, bindTask, isCurrent, finish, preparationBudget, fontPreparationPending, beginFontPreparation, endFontPreparation, readCache, directoryIndex, retirePreparation, reloadId, features, metrics, close |
| top-level / `com/teenkung/packforge/loader/ReloadHooks.java` | `` |  | registerStartHook, registerCompletionHook, fireStart, fireCompletion |
| top-level / `com/teenkung/packforge/loader/ReloadLifecycle.java` | `` |  | startReload, finishReload |
| top-level / `com/teenkung/packforge/loader/ReloadListenerTelemetry.java` | `` |  | prepare, apply, prepareExecutor, applyExecutor, observeListenerFuture, canonicalName, readableStartupName |
| top-level / `com/teenkung/packforge/loader/ReloadMetrics.java` | `` |  | started, finished, snapshot, timing, decrement, nonNegative, CounterSnapshot, ListenerSnapshot |
| top-level / `com/teenkung/packforge/loader/ReloadReadCache.java` | `` |  | statistics, open, load, finish, openOriginal, recordBudgetBypass, increment, await, close, leased, Statistics, Key, equals, hashCode, close |
| top-level / `com/teenkung/packforge/loader/ReloadSessionTracker.java` | `` |  | capturePackDiff, startReload, current, difference, PackDiff, ReloadSession |
| top-level / `com/teenkung/packforge/loader/ReloadStatus.java` | `` |  | start, start, finish, finish, prepareStarted, prepareFinished, applyStarted, applyFinished, resourceApplied, isStatusTextReady, isActive, externalFeedbackEnabled, isComplete, line, displayProgress, detailLine, consumeSummaryToast, humanize, ReloadSummary |
| top-level / `com/teenkung/packforge/loader/ReloadTrace.java` | `` |  | started, created, failedCreation, completed, overlay, isEnabled, enabled, initiatingPath, identity, session, overlaySession, cleanReloads, cleanOverlays, hashCode, equals, PackIdentity |
| top-level / `com/teenkung/packforge/loader/ResourceNamePolicy.java` | `` |  | current, legacy1201, isValidNamespace, isValidNamespace, omitEmptyNamespaceSegments, isValidPath, validNamespaceCharacters |
| top-level / `com/teenkung/packforge/loader/ZipFilePools.java` | `` |  | supplier, invalidate, close |
| top-level / `com/teenkung/packforge/loader/ZipReadPool.java` | `` |  | archiveFile, maxHandles, isClosed, isFailed, openHandleCount, open, reportFailure, failLocked, close, closeHandlesLocked, FileStamp, Failure |
| top-level / `com/teenkung/packforge/loader/ZipResourceReadReuse.java` | `` |  | register, open, eligible, find, retire |
| top-level / `com/teenkung/packforge/mixin/compat/OptimizationMixinPlugin.java` | `` |  | onLoad, shouldApplyMixin, getRefMapperConfig, acceptTargets, getMixins, preApply, postApply |
| top-level / `com/teenkung/packforge/mixin/loader/FilePackResourcesMixin.java` | `value={FilePackResources.class})` | Inject:1, WrapOperation:5 | packforge$captureArchive, packforge$addPrefix, packforge$loaderIndexEnabled, packforge$loaderZipPoolEnabled, packforge$index, packforge$poolIfSafe, packforge$lookupEntry, packforge$resourceSupplier, packforge$namespaceEntries, packforge$listEntries, packforge$listSupplier |
| top-level / `com/teenkung/packforge/mixin/loader/PathPackResourcesMixin.java` | `value={PathPackResources.class})` | WrapOperation:1 | packforge$listDirectory |
| top-level / `com/teenkung/packforge/mixin/loader/SharedZipFileAccessAccessor.java` | `targets={"net.minecraft.server.packs.FilePackResources$SharedZipFileAccess"})` | Accessor:1, Invoker:1 |  |
| top-level / `com/teenkung/packforge/mixin/loader/SharedZipFileAccessMixin.java` | `targets={"net.minecraft.server.packs.FilePackResources$SharedZipFileAccess"})` | Inject:2 | packforge$createState, packforge$archiveFile, packforge$getOrCreateZipFile, packforge$archiveState, packforge$closeStateBeforeVanilla |
| top-level / `com/teenkung/packforge/mixin/loader/ZipIoSupplierReadReuseMixin.java` | `value={IoSupplier.class})` | WrapOperation:1 | packforge$reuseCertifiedRead |
| top-level / `com/teenkung/packforge/mixin/observe/ReloadableResourceManagerMixin.java` | `value={ReloadableResourceManager.class})` | WrapMethod:1 | packforge$createReload |
| top-level / `com/teenkung/packforge/mixin/observe/SimpleReloadInstanceMixin.java` | `value={SimpleReloadInstance.class})` | WrapOperation:1 | packforge$telemetry |
| top-level / `com/teenkung/packforge/mixin/startup/UtilExecutorMixin.java` | `value={Util.class})` | Redirect:2 | packforge$tuneMaxThreads, packforge$tuneThreadPriority |
| top-level / `com/teenkung/packforge/PackForge.java` | `` |  |  |
| top-level / `com/teenkung/packforge/PackForgeCore.java` | `` |  | init |
| top-level / `com/teenkung/packforge/platform/EarlyModDiscovery.java` | `` |  | capture |
| top-level / `com/teenkung/packforge/platform/OptimizationCompatibility.java` | `` |  | fromDiscovery, installEarly, current, captureRuntimeDiscovery, capture, State |
| top-level / `com/teenkung/packforge/platform/PackForgeCommandRegistrar.java` | `` |  |  |
| top-level / `com/teenkung/packforge/platform/PackForgeCompat.java` | `` |  | isSodiumLikePresent, isShaderPipelinePresent, isSmoothBootPresent, isImmediatelyFastPresent, mustPreservePlatformModelLoading |
| top-level / `com/teenkung/packforge/platform/PackForgePlatform.java` | `` |  |  |
| top-level / `com/teenkung/packforge/platform/PackForgeReloadListener.java` | `` |  |  |
| top-level / `com/teenkung/packforge/platform/PackForgeServices.java` | `` |  | init, isInitialized, platform |
| top-level / `com/teenkung/packforge/startup/StartupAsyncFeatures.java` | `` |  | startConfiguredWork, startClassScanTelemetry, scanModJars, isJar |
| top-level / `com/teenkung/packforge/startup/StartupEarlyConfig.java` | `` |  | get, isLikelySmoothBootPresent, load, scanModsFolder, booleanValue, intValue, Settings |
| top-level / `com/teenkung/packforge/startup/StartupExecutorTuner.java` | `` |  | tuneMaxThreads, applyThreadSettings, startupExecutorTuningEnabled, skipForSmoothBoot |
| top-level / `com/teenkung/packforge/startup/StartupStatus.java` | `` |  | start, update, finish, isActive, isComplete, line, detailLine |
| top-level / `com/teenkung/packforge/startup/StartupTimings.java` | `` |  | reset, resetIfUnused, hasRecordedWork, isActive, complete, mark, markBoundary, event, recordDuration, recordStall, executorTuning, logSummary, startupTimingsEnabled, addDuration, writeCsv, writeCsvNow, writeSummaryCsvAsync, writeSummaryCsvNow, backgroundExecutor, csv, PhaseReport |
| top-level / `com/teenkung/packforge/startup/StartupWorkerConfig.java` | `` |  | configuredWorkerThreads, configuredThreadPriority, autoWorkerThreads, clamp |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
