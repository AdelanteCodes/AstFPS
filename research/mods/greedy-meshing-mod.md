# Greedy Meshing Mod

Review status: **Evidence inventory; behavioral review pending**

Project: [Greedy Meshing Mod](https://modrinth.com/mod/greedy-meshing-mod)
Selected artifact version: `0.6.1+26.3`
Published implementation source: https://github.com/programmer1o1/GreedyMeshingMod
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Optimizes chunk rendering by merging identical adjacent block faces into larger quads, reducing the total number of quads the GPU needs to render.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `ae10161ec35e398652657e5085a7b9981aacb5b4`
- `sha512`: `a0665424229c1aa7a421440f88ab1a653d1bfbce4b8ee472c8e5baa2c655fddad4479d3fae567395126a771c40c540e68ce143dc07b9d45150c424f7276462db`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 53
Reconstructed Java files: 35

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "hi.sierra.greedy_meshing.client.GreedyMeshingClient"
  ],
  "main": [
    "hi.sierra.greedy_meshing.GreedyMeshing"
  ],
  "modmenu": [
    "hi.sierra.greedy_meshing.client.GreedyModMenuIntegration"
  ],
  "sodium:config_api_user": [
    "hi.sierra.greedy_meshing.client.sodium.GreedySodiumConfigEntryPoint"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `hi/sierra/greedy_meshing/client/GreedyConfigScreen.java` | `` |  | create |
| top-level / `hi/sierra/greedy_meshing/client/GreedyCtmSupport.java` | `` |  | reload, parseInto, splitEntries, normalizeBlockId, normalizeTileId, globToPattern, matchesBlock, matchesTile, excludedCount |
| top-level / `hi/sierra/greedy_meshing/client/GreedyDebugDraw.java` | `` |  | useFills, setCamera, outline, grid, triangles, drawFilledQuad, fillVertex, drawEdge |
| top-level / `hi/sierra/greedy_meshing/client/GreedyDebugHudRenderer.java` | `` |  | render, fmt |
| top-level / `hi/sierra/greedy_meshing/client/GreedyDebugStore.java` | `` |  | setSectionQuads, clear, clearSection, getQuads, countQuads, countSections, getQuadsNear, countQuadsNear, removeSectionsIf, countSectionsNear, DebugQuad |
| top-level / `hi/sierra/greedy_meshing/client/GreedyEmissiveSupport.java` | `` |  | find |
| top-level / `hi/sierra/greedy_meshing/client/GreedyLighting.java` | `` |  | computeTileLighting, computeGreedyCornerLighting, useSmoothLighting, fillFlatLighting, isOpen, greedyMeshing$getLightColor, mergeLightKey, blend |
| top-level / `hi/sierra/greedy_meshing/client/GreedyMeshingClient.java` | `` |  | onInitializeClient, onClientTick, greedyMeshing$refreshMergeZone, greedyMeshing$pruneUnloadedSections, readOptionValue |
| top-level / `hi/sierra/greedy_meshing/client/GreedyModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `hi/sierra/greedy_meshing/client/GreedyPerformanceStats.java` | `` |  | reset, setSectionGeometry, clearSectionGeometry, pruneBeyond, onVanillaCompileHook, onSodiumTaskHook, onGreedySectionBuilt, snapshot, formatVertexSavings, fmtCount, fmtBytes, Snapshot, savedQuads, liveSavedQuads, liveSavedVertices, liveApproxBytesSaved |
| top-level / `hi/sierra/greedy_meshing/client/GreedyResourceReloadListener.java` | `` |  | register, getFabricId, onResourceManagerReload |
| top-level / `hi/sierra/greedy_meshing/client/GreedyRuntimeState.java` | `` |  | isRuntimeGreedyActive, isRuntimeGreedyActive, isRuntimeGreedyActive, backendName, requiresCrackSafeSubdivision, isShaderPackActive, isInSableSubLevel, inactiveReason, isSmoothLightingEnabled, readOptionValue |
| top-level / `hi/sierra/greedy_meshing/client/GreedySpriteSupport.java` | `` |  | supportsGreedySpriteSizes, clearCache, isFullCubeFace, isFullCubeFace, checkVertex, isUnit, ctmExcludesMerging, supportsModelSprites, supportsFaceLayers, isGreedyCompatible, supportsMergedShaderSprite, mergedFaceAlpha, hasStandardCubeGeometry, faceIsFullCube |
| top-level / `hi/sierra/greedy_meshing/client/GreedyVanillaWorkState.java` | `` |  | reset, initialized, greedyActive, baseX, baseY, baseZ, sectionStates, visibleFaces, eligibleCount, faceMergeKeys, eligibleIndices, addEligible |
| top-level / `hi/sierra/greedy_meshing/client/GreedyWireframeRenderer.java` | `` |  | render |
| top-level / `hi/sierra/greedy_meshing/client/sodium/GreedySodiumConfigEntryPoint.java` | `` |  | registerConfigLate |
| top-level / `hi/sierra/greedy_meshing/client/sodium/GreedySodiumIds.java` | `` |  |  |
| top-level / `hi/sierra/greedy_meshing/client/sodium/GreedySodiumSpriteKey.java` | `` |  | GreedySodiumSpriteKey |
| top-level / `hi/sierra/greedy_meshing/client/sodium/GreedySodiumWorkState.java` | `` |  | reset, sectionStates, buildContext, world, world, blockRenderer, blockRenderer, sectionOrigin, sectionOrigin, greedyActive, sectionKey, sectionKey, eligibleCount, incrementEligibleCount, captureDebug, faceMergeKeys |
| top-level / `hi/sierra/greedy_meshing/GreedyConfig.java` | `` |  | load, save, enabled, aggressiveGreedy, greedyWater, mergeOrientedBlocks, mergeCtmBlocks, gpuCrackFix, debugWireframe, debugComparison, debugTrianglesHud, debugScreenOverlay, meshOpacity, minMeshDistance, activeSettingsSummary, append, snapshot, apply, setApplyListener, clamp |
| top-level / `hi/sierra/greedy_meshing/GreedyEligibility.java` | `` |  | fancyGrassModPresent, isGreedyOpaqueCube, hasOrientationProperty, isGreedyWaterSource, clearCache |
| top-level / `hi/sierra/greedy_meshing/GreedyMesher.java` | `` |  | mesh, mesh, mesh, mesh, mesh, meshWithKeys, sweep, binarySweep, binaryKeyedSweep, createFaceMaskArray, clearFaceMaskArray, index, buildSweepTable, buildInverseSweepTable, GreedyQuad |
| top-level / `hi/sierra/greedy_meshing/GreedyMeshing.java` | `` |  | onInitialize |
| top-level / `hi/sierra/greedy_meshing/mixin/client/ClientChunkCacheMixin.java` | `value={ClientChunkCache.class})` | Inject:1 | greedyMeshing$markSectionDirtyOnLightUpdate |
| top-level / `hi/sierra/greedy_meshing/mixin/client/DebugRendererMixin.java` | `value={DebugRenderer.class})` |  |  |
| top-level / `hi/sierra/greedy_meshing/mixin/client/DebugScreenEntryListMixin.java` | `value={DebugScreenEntryList.class}, remap=false)` | Inject:1 | greedyMeshing$enableEntry |
| top-level / `hi/sierra/greedy_meshing/mixin/client/DebugScreenOverlayMixin.java` | `value={DebugScreenEntries.class}, remap=false)` | Inject:1 | register, greedyMeshing$registerDebugEntry, display, fmt |
| top-level / `hi/sierra/greedy_meshing/mixin/client/SectionCompilerMixin.java` | `value={SectionCompiler.class})` | Inject:2, WrapOperation:1 | greedyMeshing$beginCompile, greedyMeshing$wrapGetRenderShape, greedyMeshing$emitGreedyQuads, toDebugQuad, greedyMeshing$resolveFaceLayers, greedyMeshing$resolveWaterFaceLayers, populateFaceVisibility, isFlatWaterSurface, computeAoKey, emitGreedyQuad, greedyMeshing$computeSkirtMask, greedyMeshing$edgeHasNeighbor, greedyMeshing$cellVisible, emitSubQuad, emitTiledQuads, greedyMeshing$interpolate, greedyMeshing$fillCornerBlockPositions, tintColorForTile, greedyMeshing$waterSurfaceTop, corners, fillCorners, skirtCorners, FaceAppearance |
| top-level / `hi/sierra/greedy_meshing/mixin/client/SectionCompilerResultsAccessor.java` | `value={SectionCompiler.Results.class})` | Accessor:4 |  |
| top-level / `hi/sierra/greedy_meshing/mixin/client/sodium/SodiumBlockRendererAccessor.java` | `value={BlockRenderer.class})` | Accessor:1 |  |
| top-level / `hi/sierra/greedy_meshing/mixin/client/sodium/SodiumChunkBuildContextAccessor.java` | `value={ChunkBuildContext.class})` | Accessor:2 |  |
| top-level / `hi/sierra/greedy_meshing/mixin/client/sodium/SodiumChunkBuilderMeshingTaskMixin.java` | `value={ChunkBuilderMeshingTask.class})` | Inject:3, Redirect:2 | greedyMeshing$beginSodiumTask, greedyMeshing$endSodiumTask, greedyMeshing$redirectSodiumRenderModel, greedyMeshing$redirectSodiumFluidRender, greedyMeshing$redirectSodiumFluidRender0, greedyMeshing$emitGreedyBeforeSodiumMeshBuild, getWorldSlice, toDebugQuad, greedyMeshing$resolveFaceLayers, greedyMeshing$resolveWaterFaceLayers, populateFaceVisibility, isFlatWaterSurface, computeAoKey, emitMergedQuad, greedyMeshing$computeSkirtMask, greedyMeshing$edgeHasNeighbor, greedyMeshing$cellVisible, greedyMeshing$skirtCorners, emitSodiumSubQuad, emitTiledQuads, interpolate, tileBlockCoord, greedyMeshing$cornerBlockPositions, greedyMeshing$cornerBlockPositionsInto, tintColorForTile, greedyMeshing$waterSurfaceTop, corners, cornersInto, FaceAppearance |
| top-level / `hi/sierra/greedy_meshing/mixin/client/sodium/SodiumChunkBuilderTaskAccessor.java` | `value={ChunkBuilderTask.class})` | Accessor:1 |  |
| top-level / `hi/sierra/greedy_meshing/mixin/client/sodium/SodiumOptionsGUIMixin.java` | `` |  |  |
| top-level / `hi/sierra/greedy_meshing/mixin/client/sodium/SodiumShaderLoaderMixin.java` | `value={ShaderManager.Configs.class})` | Inject:1 | greedyMeshing$injectGreedyShaderCode, greedyMeshing$varyingLayout, greedyMeshing$injectVertexShader, greedyMeshing$injectFragmentShader |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
