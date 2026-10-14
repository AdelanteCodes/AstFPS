# Xaero's Optimal Beacons Add-On

Review status: **Evidence inventory; behavioral review pending**

Project: [Xaero's Optimal Beacons Add-On](https://modrinth.com/mod/xaeros-optimal-beacons-add-on)
Selected artifact version: `1.3.0`
Published implementation source: https://github.com/deanxbox/Xaero-s-Optimal-Beacons-Add-On
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Plan beacon networks directly on the map. This addon for Xaero's World Map and Xaero's Minimap lets you preview beacon coverage and automatically calculate optimal beacon placements for any selected area.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `5a069f2a7bffdd41afb556a9be41263f6c8bf5f63c40153a21b8bf29ee52dc9f7bd0fe10862698dd3c49d104ff5c19d195df92ca20cfe0c242533717cc0f8981`
- `sha1`: `251aeddf463be60d840fc993c46e01d719c013b5`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 31
Reconstructed Java files: 25

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "deanxbox.xaeros_beacon_addon.XaerosOptimalBeaconsAddOnClient"
  ],
  "modmenu": [
    "deanxbox.xaeros_beacon_addon.integration.BeaconModMenuApi"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": ">=0.160.5",
  "cloth-config": ">=26.3.158",
  "xaeroworldmap": ">=1.46.2"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `deanxbox/xaeros_beacon_addon/beacon/BeaconPlacement.java` | `` |  | BeaconPlacement, coverage |
| top-level / `deanxbox/xaeros_beacon_addon/beacon/BeaconPlacementPlan.java` | `` |  | BeaconPlacementPlan, beaconCount, pyramidBlocksPerBeacon, totalPyramidBlocks, fullStacks, remainingBlocks, stackBreakdown, coveragePercent |
| top-level / `deanxbox/xaeros_beacon_addon/beacon/BeaconPlacementSolver.java` | `` |  | solve, solve, solve, translatePlan, prioritizeGapDirection, buildDirectionalGridPlan, buildDirectionalHexPlan, sortedDistinctAxis, distributeDirectionalCenters, solveFullArea, solveMinimizeBeacons, solveHexOptimal, remapPreference, buildGridPlan, buildHexPlan, buildPlan, staggeredCenters, nearestChunkCenter, distributeCenters, distributeCenters, distributeChunkCenters, validChunkCenters, maxGridCount, calculateCoverageRatio, overlapScore, coveredBlocksInRow, overlapInRow, rowCoverageIntervals, coverageCount, snapDelta, clampDeltaX, clampDeltaZ, sameCoverage, ceilDiv |
| top-level / `deanxbox/xaeros_beacon_addon/beacon/BeaconPlanExport.java` | `` |  | numberedPlacementLines, numberedPlacementLines, toClipboardText, sortedPlacements, formatPlacementLine |
| top-level / `deanxbox/xaeros_beacon_addon/beacon/BeaconPlanPreference.java` | `` |  | displayName, next |
| top-level / `deanxbox/xaeros_beacon_addon/beacon/BeaconPlanSnapMode.java` | `` |  | displayName |
| top-level / `deanxbox/xaeros_beacon_addon/beacon/BeaconTier.java` | `` |  | tier, horizontalRadius, coverageDiameter, max |
| top-level / `deanxbox/xaeros_beacon_addon/beacon/BlockArea.java` | `` |  | BlockArea, width, height, containsBlock, intersectsChunk, intersectsRegion |
| top-level / `deanxbox/xaeros_beacon_addon/beacon/GapDirection.java` | `` |  | menuLabel |
| top-level / `deanxbox/xaeros_beacon_addon/config/BeaconClientConfig.java` | `` |  | get, save, load, sanitize, rgba |
| top-level / `deanxbox/xaeros_beacon_addon/integration/BeaconConfigScreen.java` | `` |  | create, addColorEntry |
| top-level / `deanxbox/xaeros_beacon_addon/integration/BeaconModMenuApi.java` | `` |  | getModConfigScreenFactory |
| top-level / `deanxbox/xaeros_beacon_addon/menu/BeaconRightClickOption.java` | `` |  | onAction |
| top-level / `deanxbox/xaeros_beacon_addon/menu/BeaconTierMenu.java` | `` |  | getRightClickOptions, isRightClickValid |
| top-level / `deanxbox/xaeros_beacon_addon/mixin/client/DropDownWidgetAccessor.java` | `value={DropDownWidget.class})` | Accessor:1 |  |
| top-level / `deanxbox/xaeros_beacon_addon/mixin/client/GuiMapMixin.java` | `value={GuiMap.class})` | Inject:2 | addBeaconOptions, renderBeaconUi, renderPlanStatsPanel, inactiveInfoOption, copyPlanToClipboard, sendPlanToChat, shortPreference, shortSnapMode, shortPlanMetrics, togglePlanLabel, toggledPlan, planSummary, blockSummary, coverageText, safeCoverageText, updatePlanningTier, nextTier, nextSnapMode, hasDraggedSelection, selectedArea |
| top-level / `deanxbox/xaeros_beacon_addon/mixin/client/HighlighterRegistryMixin.java` | `value={HighlighterRegistry.class})` | Inject:1 | registerBeaconHighlighterBeforeFreeze |
| top-level / `deanxbox/xaeros_beacon_addon/overlay/BeaconMinimapSync.java` | `` |  | syncCurrentWorld, createPlanTemporaryWaypoints, clearGeneratedPlanWaypoints, currentWorld, removeGeneratedPlanWaypoints, resetSyncCache, nameFor, symbolFor, colorFor |
| top-level / `deanxbox/xaeros_beacon_addon/overlay/BeaconOverlay.java` | `` |  | BeaconOverlay, minX, maxX, minZ, maxZ, containsBlock, intersectsChunk, intersectsRegion, isBorderBlock, isInnerBorderBlock, isCenterMarkerCore, isCenterMarkerInnerRing, isCenterMarkerOuterRing, isPreviewPillar, isPreviewTop, isPreviewBase, distanceToBorder |
| top-level / `deanxbox/xaeros_beacon_addon/overlay/BeaconOverlayHighlighter.java` | `` |  | calculateRegionHash, regionHasHighlights, chunkIsHighlit, getChunkHighlitColor, getBlockHighlightSubtleTooltip, getBlockHighlightBluntTooltip, addMinimapBlockHighlightTooltips, findOverlay, colorFor, overlapColor, innerBorderColor, borderColor, ringColor, coreColor |
| top-level / `deanxbox/xaeros_beacon_addon/overlay/BeaconOverlaySource.java` | `` |  |  |
| top-level / `deanxbox/xaeros_beacon_addon/overlay/BeaconOverlayState.java` | `` |  | getInstance, getDefaultManualTier, setDefaultManualTier, placeManualBeacon, updateManualBeaconTier, removeManualBeacon, clearManualBeacons, setSelectedPlanTier, getSelectedPlanTier, setSelectedPlanSnapMode, getSelectedPlanSnapMode, setSelectedPlanPreference, getSelectedPlanPreference, setPlan, clearPlan, hasPlan, getPlan, hasManualBeacons, getOverlays, findManualBeaconAt, findOverlayAt, canAdjustPlanGaps, invalidateHighlights, onStateChanged, rebuildPlannedBeacons |
| top-level / `deanxbox/xaeros_beacon_addon/overlay/MinimapCompat.java` | `` |  | isAvailable, syncCurrentWorld, createPlanTemporaryWaypoints, clearGeneratedPlanWaypoints |
| top-level / `deanxbox/xaeros_beacon_addon/XaerosOptimalBeaconsAddOn.java` | `` |  |  |
| top-level / `deanxbox/xaeros_beacon_addon/XaerosOptimalBeaconsAddOnClient.java` | `` |  | onInitializeClient |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
