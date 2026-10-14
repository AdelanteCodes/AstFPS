# PathWeaver

Review status: **Evidence inventory; behavioral review pending**

Project: [PathWeaver](https://modrinth.com/mod/pathweaver)
Selected artifact version: `0.9.0+26.3`
Published implementation source: https://github.com/zimdin12/PathWeaver
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Mob pathfinding runs on the server thread and causes tick spikes. PathWeaver moves it to spare CPU cores: mean tick roughly halved with 1024 mobs, worst-1% ticks down 55-61%. Server-side, clients need nothing. Read the warning before installing.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha1`: `db28f8f73a598d17ea9a6db0afbb9a5953212480`
- `sha512`: `cf8384da34a03e08eadaaa29ce14c36c33b8c7ad36b6d53c5d83e01cfbde5f858b749a672c1a87c7568b56cf0feb8f6b49df6ea562d8695a2814842a7d0d442f`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 118
Reconstructed Java files: 65

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "dev.pathweaver.PathWeaver"
  ],
  "modmenu": [
    "dev.pathweaver.config.PathWeaverModMenu"
  ]
}
```

**depends**

```json
{
  "minecraft": ">=26.3 <26.4",
  "java": ">=25",
  "fabricloader": ">=0.19",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/pathweaver/async/EntityInstallSink.java` | `` |  | setTick, register, isRegistered, isRegistered, isRegisteredUnder, pendingDecision, pendingDecision, supersede, cancel, finishDiscard, releasePendingBrainSink, rearmRecomputeIfStranded, abortFailedInstall, rollbackOptimisticTarget, armEpilogue, owesEpilogue, runEpilogue, finishCallback, shouldForceSync, sweepExpiredCooldowns, noteBrainSinkDispatch, hasPendingBrainSink, takeBrainSinkPath, parkForBrain, matching, isStale, install, discard, noPath, failed, inFlightCount, clear, clear, Registration, BrainSinkSlot, OwedEpilogue |
| top-level / `dev/pathweaver/async/EvaluatorCloner.java` | `` |  | computeValue, cloneWithConfig, canClone, resolve, resolveOrThrow, hasUnaccountedState, declaredConstructor, soleFinalBooleanField, soleFieldOfType, soleMatch |
| top-level / `dev/pathweaver/async/NavigationIdentity.java` | `` |  | NavigationIdentity, sameLiveIdentity |
| top-level / `dev/pathweaver/async/PathOutcome.java` | `` |  | PathOutcome, success, cancelled, noPath, failed |
| top-level / `dev/pathweaver/async/PathRequest.java` | `` |  | PathRequest |
| top-level / `dev/pathweaver/async/PathWeaverThread.java` | `` |  | currentWorker, requireWorker, isWorker, searchRunsOffThread, enterAsyncPrologue, exitAsyncPrologue, workerRandom, enterWorker, exitWorker, setWorkerStepHeight, clearWorkerStepHeight, setWorkerMaxFallDistance, clearWorkerMaxFallDistance, workerMaxFallDistance, workerStepHeight |
| top-level / `dev/pathweaver/async/PathWorkerPool.java` | `` |  | start, submit, logFailure, reportSearchFailure, logCompletionFailure, inFlight, maxInFlight, threads, failureCount, completionFailureCount, shutdown |
| top-level / `dev/pathweaver/async/RequestKey.java` | `` |  | RequestKey |
| top-level / `dev/pathweaver/async/RequestOrigin.java` | `` |  |  |
| top-level / `dev/pathweaver/async/RequestOutcome.java` | `` |  | description, setupFailure, strandsRecompute, isDiscard, countsAgainstDispatched, isGoodNews, hasRegistered |
| top-level / `dev/pathweaver/async/RequestTarget.java` | `` |  | RequestTarget, of |
| top-level / `dev/pathweaver/async/ResultInstaller.java` | `` |  | enqueue, enqueueDiscard, drain, deliver, pending, clear, Result |
| top-level / `dev/pathweaver/async/SearchStartGate.java` | `` |  | awaitStart, open, cancel, authorizedSearch |
| top-level / `dev/pathweaver/brain/BrainSinkCandidate.java` | `` |  | BrainSinkCandidate, eligible, fromBrain, forTarget, evaluate, declined |
| top-level / `dev/pathweaver/brain/BrainSinkDiagnostics.java` | `` |  | setEnabled, recordStartCheck, recordTickHook, last, startChecks, tickHooks, recordLifecycle, lifecycle, clear |
| top-level / `dev/pathweaver/brain/BrainSinkPolicy.java` | `` |  | consecutiveDeferrals, decide, defer, Decision, Probe, refused, ran |
| top-level / `dev/pathweaver/brain/BrainSinkPort.java` | `` |  | takeParked, hasPending, isRegistered, acceptableToVanilla, probe |
| top-level / `dev/pathweaver/cache/BlockChangeObserver.java` | `` |  | observe |
| top-level / `dev/pathweaver/cache/CachedPath.java` | `` |  | CachedPath, samePosition |
| top-level / `dev/pathweaver/cache/CacheLookup.java` | `` |  | CacheLookup, served, isServed |
| top-level / `dev/pathweaver/cache/CacheStatusLines.java` | `` |  | render, share |
| top-level / `dev/pathweaver/cache/PathCache.java` | `` |  | removeEldestEntry, noteBlockChange, lookup, remember, completed, crossPolicyBarrier, forget, clear, size, capacity, counters, usableHits, Pending |
| top-level / `dev/pathweaver/cache/PathCacheKey.java` | `` |  | PathCacheKey, dimensionHash, equals, hashCode |
| top-level / `dev/pathweaver/cache/PathCacheKeys.java` | `` |  | of |
| top-level / `dev/pathweaver/cache/PathCopies.java` | `` |  | deepCopy, sectionsOf, contains |
| top-level / `dev/pathweaver/cache/SectionChangeClock.java` | `` |  | slot, recordChange, unchangedSince, clear |
| top-level / `dev/pathweaver/command/MobEligibility.java` | `` |  | describe, of, of, of, evaluatorReason, live, blocksLandFamilies, Verdict |
| top-level / `dev/pathweaver/command/PathWeaverCommand.java` | `` |  | register, status, withExtra, mobs, verdictFor, verdictFor, pathFinderOf, evaluatorOf, say |
| top-level / `dev/pathweaver/config/ClothScreen.java` | `` |  | build, isOption, tooltip, addEntry, keyOf, set |
| top-level / `dev/pathweaver/config/CompatibilityTier.java` | `` |  | allowsAudited, bypassesScan, getKey |
| top-level / `dev/pathweaver/config/ConfigFile.java` | `` |  | exists, serialize, deserialize, createDefault, readVersion, strictBoolean, rejectLegacyKeys, strictOptionalStringList, validateCurrentFieldTypes, migrateCompatibilityTier, migrateRenamedTier, migrateRepathTolerance, strictOptionalEnum, strictOptionalBoolean, strictOptionalInteger, strictOptionalNumber |
| top-level / `dev/pathweaver/config/ConfigLoad.java` | `` |  | from, from, Result |
| top-level / `dev/pathweaver/config/PathCacheMode.java` | `` |  | getKey |
| top-level / `dev/pathweaver/config/PathWeaverConfig.java` | `` |  | get, generation, set, installFailClosedDefaults, publishLoaded, bypassesCompatibilityScan, allowsAuditedCompatibility, moddedMobAsyncAllowed, resultCacheActive, resultCacheServes, recordsBlockChanges, save, copyOf, validatePostLoad, resolvedPoolThreads |
| top-level / `dev/pathweaver/config/PathWeaverModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `dev/pathweaver/duck/PWNavigation.java` | `` |  |  |
| top-level / `dev/pathweaver/elision/RepathTolerance.java` | `` |  | reusableTarget, manhattan, compareCoordinates, CurrentPath |
| top-level / `dev/pathweaver/gate/ActiveCompatibilityPolicy.java` | `` |  | allowsAudited, bypassesScan |
| top-level / `dev/pathweaver/gate/AuditedMixinCompatibility.java` | `` |  | verifyServerCoreMixin, verifyServerCoreHandlerBody, verifyServerCorePlugin, verifyRabbitMixin, requireVanillaMethod, method, realOpcodes, foreignInjections, findAnnotation, findAnnotation, annotationValue, annotationContains, singleAnnotation, unverified |
| top-level / `dev/pathweaver/gate/CertifiedLandProviders.java` | `` |  | certify, certifyWorldIndependentDynamic, certifyAuditedDynamic, isCertified, frozenProvider, Table |
| top-level / `dev/pathweaver/gate/DiagonalBlocksCompatibility.java` | `` |  | unverified |
| top-level / `dev/pathweaver/gate/FabricInteractionCompatibility.java` | `` |  | verifyConfig, verifyMixin, collectBlockStateCalls, headOnly, classNode, annotations, findAnnotation, annotationValue, annotationContains, readModuleArtifact, readModResource, readWorkerEvaluators, readClassBytes |
| top-level / `dev/pathweaver/gate/FabricLandPathRegistryLatch.java` | `` |  | beforeProviderMutation, certifiedProviderRegistered, auditedDynamicProviderRegistered, certifiedProviderObserved, recordWorkerProviderLookupBypass, workerProviderLookupBypasses, allowsWalkDispatch, allowsWalkInstall, providerRegistrationObserved |
| top-level / `dev/pathweaver/gate/FabricSwimCompatibility.java` | `` |  | loadRuntimeBundle, verifyConfig, verifyStructuralBlockStateMixin, verifyLandRegistry, verifyFabricContextMixin, verifySwimRoute, collectContextCalls, classNode, annotations, findAnnotation, annotationValue, annotationContains, readModuleArtifact, readModResource, readClassBytes, invalidEvidence |
| top-level / `dev/pathweaver/gate/FarmersDelightStoveCompatibility.java` | `` |  | run |
| top-level / `dev/pathweaver/gate/ForeignMixinScanner.java` | `` |  | allowlistByName, isAuditedExemption, scanFailed, targetsTouchingAllowlist, denialsForTargets, normalizeTargetName, decide, decide, decide, decide, denialsForConfig, exactFabricSwimClaimShape, readServerMixinConfigNames, readClientMixinConfigNames, readEnvironmentMixinConfigNames, frozenEquivalentTier, freezeActiveTier, frozenTierAllowsAudited, frozenTierBypassesScan, tierFrozen, scanCompleted, anyActiveClaimTargets, blockingModIds, trustedModIdsInUse, operatorTrustedMods, lastScanReport, activeMixinConfigs, configCensus, rescanIfConfigsChanged, scanAndPopulate, ScanReport, ScanDecision, SwimExemptionEvidence, unverified, AuditedExemptionEvidence, verifies, unverified, unverified, ActiveConfig, pluginContributed, targets, TargetClaim, PluginIdentity, DeclaredConfig |
| top-level / `dev/pathweaver/gate/LithiumPathfindingCompatibility.java` | `` |  | requireTarget, mentionsConstructor, findInject, annotationValue, unverified |
| top-level / `dev/pathweaver/gate/MobOriginGate.java` | `` |  | computeValue, isAllowed, codeSource |
| top-level / `dev/pathweaver/gate/ModAttribution.java` | `` | Overwrite:2, Redirect:1 | loadModIds |
| top-level / `dev/pathweaver/gate/SafetyGate.java` | `` |  | allowlist, addIfPresent, allowlisted, tripRuntimeFailure, runtimeFailureDenials, snapshotDenials, scanEnforcedFamilyCount, denialCount, familiesRefusedByRuntimeFailure, isDeniedByRuntimeFailure, allowlistedFamilyOf, isEvaluatorAllowed, isDenied, isWaivableSubclass, isAllowed, canDispatch, canDispatch, requiresEmptyLandRegistry, isLandDerived, landRegistryBlocksWalkFamilies |
| top-level / `dev/pathweaver/gate/WorkerFailureBreaker.java` | `` |  | setTick, reset, windowedCount, cumulativeCount, recordSearchFailure, record, tripReason |
| top-level / `dev/pathweaver/lod/RecomputeThrottle.java` | `` |  | allows, allows |
| top-level / `dev/pathweaver/mixin/AmphibiousNodeEvaluatorMixin.java` | `value={AmphibiousNodeEvaluator.class})` | Redirect:1 | pathweaver$capturedStepHeight |
| top-level / `dev/pathweaver/mixin/FlyNodeEvaluatorMixin.java` | `value={FlyNodeEvaluator.class})` | Redirect:1 | pathweaver$workerLocalRandom |
| top-level / `dev/pathweaver/mixin/LandPathTypeRegistryMixin.java` | `value={LandPathTypeRegistry.class})` | Inject:2, Redirect:1 | pathweaver$beforeStaticProviderMutation, pathweaver$beforeDynamicProviderMutation, pathweaver$keepWorkerOutOfLiveProviderMap |
| top-level / `dev/pathweaver/mixin/MoveToTargetSinkMixin.java` | `value={MoveToTargetSink.class})` | Inject:6, WrapOperation:1 | reachedTarget, pathweaver$deferBeforeVanillaCanForgetTheTarget, pathweaver$claimAndDecide, pathweaver$releaseDecisionClaim, pathweaver$decideDefers, pathweaver$deferRepath, pathweaver$supply, pathweaver$traceStart, pathweaver$traceCanStillUse, pathweaver$traceStop, pathweaver$useAlreadyComputedPath |
| top-level / `dev/pathweaver/mixin/PathFinderAccessor.java` | `value={PathFinder.class})` | Accessor:1 |  |
| top-level / `dev/pathweaver/mixin/PathFinderMixin.java` | `value={PathFinder.class})` | Redirect:2 | pathweaver$prepareOnMainThreadInstead, pathweaver$finishOnMainThreadInstead |
| top-level / `dev/pathweaver/mixin/PathfindingContextMixin.java` | `value={PathfindingContext.class})` | Redirect:1 | pathweaver$isolateCache |
| top-level / `dev/pathweaver/mixin/PathNavigationMixin.java` | `value={PathNavigation.class})` | Inject:8, WrapOperation:4, Redirect:1 | resetStuckTimeout, pathweaver$captureCoordinateSpeed, pathweaver$captureCoordinateReachSpeed, pathweaver$captureEntitySpeed, pathweaver$deferredMovementResult, pathweaver$beginMovementRequest, pathweaver$enterMovementRequest, pathweaver$consumeAcceptedDeferred, pathweaver$exitMovementRequest, pathweaver$enterBrainSinkRequest, pathweaver$exitBrainSinkRequest, pathweaver$replayCreatePathTail, pathweaver$beginMovement, pathweaver$throttleDistantRecompute, pathweaver$supersedeBeforeRecomputeGuard, pathweaver$armRecomputePath, pathweaver$armCoordinateMove, pathweaver$armCoordinateMoveWithReach, pathweaver$armEntityMove, pathweaver$reuseCheckSeesThePathsOwnTarget, pathweaver$reuseExistingPathWithinTolerance, pathweaver$asyncCreatePath, pathweaver$dispatchSearch, pathweaver$install, pathweaver$rearmRecompute, pathweaver$abortFailedInstall, pathweaver$rollbackOptimisticTarget, pathweaver$stale, pathweaver$identity, pathweaver$invalidateStoppedRequest |
| top-level / `dev/pathweaver/mixin/ServerLevelBlockChangeMixin.java` | `value={ServerLevel.class})` | Inject:1 | pathweaver$noteBlockChange |
| top-level / `dev/pathweaver/mixin/WalkNodeEvaluatorMixin.java` | `value={WalkNodeEvaluator.class})` | Redirect:2 | pathweaver$capturedStepHeight, pathweaver$capturedMaxFallDistance |
| top-level / `dev/pathweaver/mixin/WallClimberNavigationMixin.java` | `value={WallClimberNavigation.class})` | Inject:2, WrapOperation:1 | pathweaver$captureWallClimberEntitySpeed, pathweaver$wallClimberDeferredResult, pathweaver$armWallClimberEntityMove |
| top-level / `dev/pathweaver/PathWeaver.java` | `` |  | onInitialize |
| top-level / `dev/pathweaver/PathWeaverRuntime.java` | `` |  | get, dispatchedCount, outcomeCount, installedCount, discardedCount, outcomeBreakdown, markDispatched, claimSetupFailureLog, markOutcome, pool, installer, entitySink, resultCache, isRunning, currentServerEpoch, nextRequestKey, onServerStarting, warnIfLandProviderCorrectnessIsWaived, reportWhetherItIsDoingAnything, onServerStopping, onEndTick |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
