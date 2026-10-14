# First Steps

Review status: **Evidence inventory; behavioral review pending**

Project: [First Steps](https://modrinth.com/mod/first-step-mod)
Selected artifact version: `2.30`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Displays a title when entering structures

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha512`: `943918392d6e1d9eeca5bf1b9fd8fc0711e3514b475d3745778449b866d71197543323726a42817dba896d2264ea1375c49bc900f37f74f60d03595255c0e67b`
- `sha1`: `722f88cd79cce17a498a266b162bcd69afcb10a1`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 38
Reconstructed Java files: 9

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.example.firststeps.FirstStepsServerMod"
  ],
  "modmenu": [
    "com.example.firststeps.modmenu.ModMenuIntegration"
  ],
  "client": [
    "com.example.firststeps.FirstStepsClientMod"
  ]
}
```

**depends**

```json
{
  "minecraft": ">=26.1",
  "fabricloader": ">=0.16.0",
  "fabric-api": "*"
}
```

**breaks**

```json
{
  "modmenu": "<11.0.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/example/firststeps/config/ModConfig.java` | `` |  | getEffectiveCheckInterval, getInstance, load, validateAndMigrate, sanitizeAddedStructures, sanitizeDiscoveredStructures, sanitizeStructureIdList, sanitizeCustomStructures, sanitizeAutoDisabledStructures, sanitizeObservedStructureRadii, sanitizePersonalization, migrateAccidentalGlobalPersonalization, applyPersonalizationToGlobal, personalizationEquals, hasPersonalizationValues, clamp, save, setOnConfigChanged, addOnConfigChangedListener, notifyConfigChanged, reset, resetPersonalization, resetGlobal, copy |
| top-level / `com/example/firststeps/FirstStepLog.java` | `` |  | isDebugEnabled, info, warn, error |
| top-level / `com/example/firststeps/FirstStepsClientMod.java` | `` |  | describePos, describeLocation, describeStructureInfo, describePlayer, logClient, logClientError, logClientState, onInitializeClient, getInstance, warmObservedStructureRadiiAroundPlayer, suspendLocalDetection, shouldSuspendLocalDetectionForServer, onConfigChanged, onTick, checkAndShowTitle, handleCachedStructure, resetState, clearStructureStyles, clearDisplayedTitleOverlay, clearVanillaTitleOverlay, isSpectatorMode, isSameStructure, applyCurrentStructureState, clearCurrentStructureState, tryShowCurrentStructureIfVisible, resolveCurrentStructureInfo, hasActiveServerStructureSync, shouldTrustServerVisibility, shouldRetainCurrentStructureOnServerClear, isCurrentStructureStillInDetectionRange, shouldShowTitle, markStructureVisited, getHorizontalSpeedSqr, getMovementAdjustedCheckInterval, getTitleVisibilityRecheckInterval, getStructureAtPlayer, getStructureFromChunks, parseStructureLocation, refineCandidateGeometryForPlayer, findBestStructureInChunk, findStructureFromNearbyChunks, getOrBuildChunkCandidates, pruneChunkStructureCache, maybePruneChunkStructureCache, buildChunkCandidates, toChunkKey, distanceToRange, isWithinDetectionRange, canPlayerSeeStructure, isPlayerInsideStructureBounds, hasLineOfSightToStructure, hasDirectLookAtStructure, getVisibilityBoxes, isOnAnyBoundingBoxSurface, isOnBoundingBoxSurface, collectPieceBoxes, selectRepresentativePieceBoxes, addRepresentativeBoxesByComparator, addEvenlyDistributedBoxes, addPieceBoxSelection, distanceToBoundingBoxSqr, buildStructureVisibilitySamples, addVisibilitySample, clampToRange, isInsideAnyBoundingBox, isInsideBoundingBox, getStructureId, isSoundDisabled, toStructureId, isAutoDisabledSmallStructureBySetting, isStructureHiddenByShowSetting, isStructureDisabledByDefault, hasEnabledStructurePersonalization, isStructureDetectionDisabled, invalidateStructureFilterCaches, isAutoHiddenSmallStructure, isSmallStructure, isUndergroundStructure, isUndergroundStructure, getStructurePriority, getWorldId, isEnabled, isServerStyleActive, getServerStyleOverride, isSingleplayer, getStructureIntSetting, resolveSettingString, getStyleValue, getStyleForComponent, isTruthy, showTitle, playEnterSound, getStructureSound, isModernUILoaded, renderCustomTitle, renderTitleWithCompatibility, refreshRenderCache, getComponentRgb, withAlpha, validateIntSetting, getStructureIntSetting, getStructureBooleanSetting, getStructureBooleanSetting, getStructureSpecificBooleanSetting, parseBool, getTitleTime, getTitleColor, getSubtitleColor, parseColor, getStructureName, formatStructureName, getDimensionName, getDimensionKey, getPrefixStyle, getDimensionStyle, getColorFromLang, loadWorldVisitedStructures, saveWorldVisitedStructures, flushPendingWorldVisitedStructures, getSafeFileName, StructureInfo, StructureCandidate, ChunkStructureCacheEntry, StructureCandidateKey, BoundingBoxKey |
| top-level / `com/example/firststeps/FirstStepsServerMod.java` | `` |  | describePlayer, describePos, describeChunk, describeStructureCandidate, describeDetectionState, logServer, logServerError, getHelloVersion, getCachedStructureId, toChunkKey, isSoundDisabled, toStructureId, isAutoDisabledSmallStructureBySetting, hasEnabledStructurePersonalization, isStructureDisabledByDefault, isStructureDetectionDisabled, invalidateStructureFilterCaches, isAutoHiddenSmallStructure, isSmallStructure, isUndergroundStructure, isUndergroundStructure, getStructurePriority, calculateStructurePriority, isWithinDetectionRange, canPlayerSeeStructure, isPlayerInsideStructureBounds, hasLineOfSightToStructure, hasDirectLookAtStructure, getVisibilityBoxes, isOnAnyBoundingBoxSurface, isOnBoundingBoxSurface, collectPieceBoxes, selectRepresentativePieceBoxes, addRepresentativeBoxesByComparator, addEvenlyDistributedBoxes, addPieceBoxSelection, distanceToBoundingBoxSqr, buildStructureVisibilitySamples, addVisibilitySample, clampToRange, isInsideAnyBoundingBox, isInsideBoundingBox, distanceToRange, getOrBuildChunkCandidates, pruneChunkStructureCache, maybePruneChunkStructureCache, resolveStructureStart, buildChunkCandidates, getSurfaceYForDetection, getHorizontalSpeedSqr, getMovementAdjustedCheckInterval, getActiveStructureVisibilityRecheckInterval, observePlayerChunk, isChunkObservationStable, getActiveStructureCandidate, updateActiveStructureState, clearDetectionStateForDisabledServer, syncPlayerDetectionState, refineCandidateGeometryForPlayer, findBestCandidateInChunk, detectStructure, getInstance, detectStructureSnapshot, getCachedStructureSnapshot, onConfigChanged, onInitialize, sendServerStyleOverrides, isStyleKey, StructureCandidate, PlayerDetectionState, BoundingBoxKey, ChunkStructureCacheEntry, StructureCandidateKey, PlayerChunkObservation, ActiveStructureState, DetectedStructureSnapshot |
| top-level / `com/example/firststeps/modmenu/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory, copyForTab, openBaseLanguageStream, loadBaseStructuresFromJson, structureTranslationKeyToId, formatStructureNameForList, safeInputValue, getStructureListDisplayName, normalizeKnownStructureId, appendKnownStructureId, appendKnownStructureId, appendKnownStructureIds, appendRuntimeStructuresFromRegistry, appendInstalledModStructures, collectInstalledModStructures, loadInstalledStructureTranslations, loadInstalledStructureTranslationsFile, persistDiscoveredStructureIds, loadStructuresFromJson, dedupeStructureListPreservingOrder, getCanonicalStructureListId, addScrollableWidget, addFixedWidget, updateScrollableWidgetsVisibility, setScrollOffsetClamped, createPersonalizationFromGlobal, isAutoDisabledSmallStructure, getStructureBooleanSetting, parseBool, isLangDisabledStructure, isDefaultDisabledStructure, isAutoDisabledOnly, isListedDisabledStructure, getStructureDisableReason, syncAutoDisabledSelection, createAutoDisabledPersonalization, pruneDefaultDisabledStructures, rebuildCustomStructureState, rebuildAllStructureState, createDisabledDefaultPersonalization, createPersonalizationBaseForTargets, getPersonalizationBaseForStructure, resetStructurePersonalization, findCommonStructureSetParent, isSoundDisabled, isEffectivelyDisabledStructure, getFilteredDisabledStructures, isStructureExplicitlyConfiguredDisabled, isAutoDisabledStructure, rebuildAutoDisabledOnlyState, resetPersonalizationEditorState, takePersonalizationSnapshot, clearPersonalizationSnapshot, restorePersonalizationSnapshot, clearPersonalizationEditorDraft, refreshStructureFilterState, maybeWarmObservedStructureRadii, isEditingGlobalPersonalization, isBatchPersonalizationEdit, sortStructureIds, getActivePersonalizationTargets, getAllStructuresTargetText, getPersonalizationEditorContextKey, getEditorPersonalization, createInitialEditorPersonalization, createBatchEditorPersonalization, getEffectivePersonalization, resolveSharedPersonalizationValue, markPersonalizationFieldDirty, mergePersonalizationWithBase, compactPersonalization, compactPersonalizationForStructure, compactPersonalizationAgainstBase, hasCustomValues, normalizeCustomStructures, applyPersonalizationToGlobal, resetGlobalPersonalization, resetPersonalizationTargets, switchTab, init, summarizeThrowable, buildErrorFallback, buildGlobalTab, buildPersonalizationTab, buildStructureListTab, applySearchFilter, updateCountInfo, extractWidgetRenderState, updateWidgetNarration, mouseClicked, extractWidgetRenderState, updateWidgetNarration, mouseClicked, buildStructureButtons, getFilteredStructures, getFilteredStructures, compareStructureListOrder, getStructureNamespace, getDisplayNamespace, getStructureCategory, matchesCategoryRules, getStructureCategoryDisplayName, getStructureListModLabel, getStructureListButtonText, groupStructuresByCategory, getCanonicalNamespace, normalizeStructureIdInput, addCompactGlobalInput, addPersInput, addTextLabel, extractWidgetRenderState, updateWidgetNarration, mouseClicked, addFixedFormattedLabel, extractWidgetRenderState, updateWidgetNarration, mouseClicked, addFixedLabel, extractWidgetRenderState, updateWidgetNarration, mouseClicked, addTextLabel, addTextLabel, extractWidgetRenderState, updateWidgetNarration, mouseClicked, parseHex, savePers, applyDirtyFieldsToPersonalization, getCustomDescription, isPersonalizationFullyDisabled, getScrollAreaTop, getScrollAreaBottom, getScrollbarVisualX, getScrollbarHitboxLeft, getScrollbarHitboxRight, getScrollbarTrackHeight, getThumbHeight, getThumbY, isMouseOverScrollbar, updateScrollbarDrag, extractRenderState, mouseClicked, mouseDragged, mouseMoved, mouseReleased, mouseScrolled, children, keyPressed, charTyped, onClose, buildBaseLabel, appendSelectionMarker, buildNormalMessage, buildHoverMessage, extractContents |
| top-level / `com/example/firststeps/network/NetworkPackets.java` | `` |  | register, type, type, type |
| top-level / `com/example/firststeps/StructureDetectionRules.java` | `` |  | findStableInsertionIndex, addLocalPieceBox, createLocalPieceBoxList, distanceToBoundingBoxSqr, distanceToRange, representativeTargetOrdinal, addRepresentativeBox, isOnBoundingBoxSurface, get, size, BoundingBoxKey |
| top-level / `com/example/firststeps/StructureFilterRules.java` | `` |  | onConfigChanged, getCompatibleCacheTickTime, createStructureAliases, registerAliasGroup, createStructureSets, addRepurposedStructuresSets, addQraftyfiedStructureSets, addTerralithStructureSets, addTrekStructureSets, addDungeonsAndTavernsSets, addStructorySets, toImmutableSet, isStructureSet, getStructureSetMembers, getStructureSetParent, buildStructureSetReverseIndex, pathToTranslationSegments, toStructureId, normalizeStructureId, getEquivalentStructureIdsForList, getEquivalentStructureIds, getStructurePath, isAutoDisableSizeExempt, matchesPathSegment, shouldAutoDisableBySize, recordObservedStructureRadius, recordObservedStructureRadius, getObservedStructureHorizontalRadius, hydrateObservedStructureRadiiFromConfig, getKnownStructureHorizontalRadiusHint, getHeuristicStructureHorizontalRadiusHint, getKnownOrObservedStructureHorizontalRadius, minPositive, maxPositive, isObservedSmallStructure, isBoundingBoxWithinSmallStructureRadius, isAutoDisabledSmallStructureId, matchesUndergroundThreshold, isBelowUndergroundThreshold, isBelowTrimmedSurface, getConfiguredDetectionPercent, computeDetectionRange, getStructureHorizontalRadius, getEffectiveStructureHorizontalRadius, getRepresentativePieceHorizontalRadius, isWithinAnyBoundingBox, isInsideExpandedBoundingBox, isOnBoundingBoxSurface, isSameBoundingBox, matchesUndergroundPath, estimateTrimmedSurfaceY, sampleTrimmedSurfaceY, getSurfaceBlockY, isGrassLike, trimmedAverage, interpolateSample, pruneSurfaceSampleCache, matchesStructureRule, SurfaceSampleKey, SurfaceSampleCacheEntry |
| top-level / `com/example/firststeps/TestWidget.java` | `` |  | test |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
