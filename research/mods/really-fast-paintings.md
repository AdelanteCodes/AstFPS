# Really Fast Paintings

Review status: **Evidence inventory; behavioral review pending**

Project: [Really Fast Paintings](https://modrinth.com/mod/really-fast-paintings)
Selected artifact version: `2.0.0`
Published implementation source: https://github.com/justbecauseph/really-fast-paintings
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Block-backed paintings for Minecraft on Fabric.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha1`: `cdebc1802e40f7d477d792c44c75816abe736fd7`
- `sha512`: `4c7c042566b51ebd4a8e14ded1aec26a08c506ef02407d0b306fffe1475d0d8fb1c5479a8cb1883767ba287c1f7d7a6d19585ce4b8c84144072b8fd0537e5473`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 36
Reconstructed Java files: 22

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "me.justbecause.fastpaintings.FastPaintings"
  ],
  "client": [
    "me.justbecause.fastpaintings.client.FastPaintingsClient"
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
| top-level / `me/justbecause/fastpaintings/block/entity/PaintingBlockEntity.java` | `` |  | setBlockState, getFacing, setVariant, isRemoving, setRemoving, markLightDirty, isLightDirty, getOrCreateLightCache, setCachedLight, setLastRenderLod, getPaintingWidth, getPaintingHeight, getFootprint, getRenderBoundingBox, preRemoveSideEffects, removeFootprint, dropItem, saveAdditional, loadAdditional, getUpdateTag |
| top-level / `me/justbecause/fastpaintings/block/PaintingBlock.java` | `` |  | createBlockStateDefinition, getShape, getShapeForFacing, getCollisionShape, canSurvive, neighborChanged, playerWillDestroy, onProjectileHit, affectNeighborsAfterRemoval, getStateForPlacement, updateShape, getFluidState, getCloneItemStack |
| top-level / `me/justbecause/fastpaintings/block/PaintingPartBlock.java` | `` |  | createBlockStateDefinition, getShape, getCollisionShape, canSurvive, findAnchorLookup, neighborChanged, playerWillDestroy, onProjectileHit, affectNeighborsAfterRemoval, updateShape, getFluidState, getCloneItemStack |
| top-level / `me/justbecause/fastpaintings/client/compat/distantdecorations/FastPaintingDistantDecorationRenderer.java` | `` |  | init, cullBelowProjectedPixelSize, type, render, vertex |
| top-level / `me/justbecause/fastpaintings/client/FastPaintingsClient.java` | `` |  | onInitializeClient |
| top-level / `me/justbecause/fastpaintings/client/render/PaintingBlockRenderer.java` | `` |  | createRenderState, extractFullLighting, submit, renderFull, renderSimplified, renderFar, vertex, shouldRenderOffScreen, shouldRender, getViewDistance |
| top-level / `me/justbecause/fastpaintings/client/render/PaintingBlockRenderState.java` | `` |  |  |
| top-level / `me/justbecause/fastpaintings/client/render/PaintingInstrumentation.java` | `` |  | isEnabled, reset, takeSnapshot, Snapshot, delta, toFormattedString |
| top-level / `me/justbecause/fastpaintings/client/render/PaintingLodManager.java` | `` |  | classifyLod |
| top-level / `me/justbecause/fastpaintings/client/render/PaintingRenderMetrics.java` | `` |  | getInstance, update, update, calculateProjectedSize |
| top-level / `me/justbecause/fastpaintings/command/PaintingMigrationCommand.java` | `` |  | init, register, runStats, runConvert, runRestore, findLoadedChunks, collectChunk, scanChunk, countAnchorsInChunk, countHelperPartsInChunk, countAnchorBlockEntitiesInChunk, ChunkScan |
| top-level / `me/justbecause/fastpaintings/compat/distantdecorations/FastPaintingDistantData.java` | `` |  | FastPaintingDistantData |
| top-level / `me/justbecause/fastpaintings/compat/distantdecorations/FastPaintingDistantDecorationProvider.java` | `` |  | init, type, matches, capture, calculateBounds |
| top-level / `me/justbecause/fastpaintings/config/FastPaintingsConfig.java` | `` |  | load, save |
| top-level / `me/justbecause/fastpaintings/event/PaintingEntityHandler.java` | `` |  | init, onEntityLoad |
| top-level / `me/justbecause/fastpaintings/FastPaintings.java` | `` |  | onInitialize, id |
| top-level / `me/justbecause/fastpaintings/init/ModRegistry.java` | `` |  | init |
| top-level / `me/justbecause/fastpaintings/mixin/HangingEntityItemMixin.java` | `value={HangingEntityItem.class})` | Inject:1 | fastpaintings$interceptPaintingPlacement |
| top-level / `me/justbecause/fastpaintings/painting/PaintingConversionService.java` | `` |  | removeEldestEntry, suppressRestoredEntity, unsuppressRestoredEntity, isRestorationSuppressed, isRestorationSuppressed, tryConvert, tryConvert, tryRestore, tryRestore, defaultEntityCleanup, tryRestore, tryRestore, tryRestore, tryRestore, rollbackRestoration |
| top-level / `me/justbecause/fastpaintings/painting/PaintingFootprint.java` | `` |  | PaintingFootprint, of, calculateBoundingBox, calculateSupportBox, computeCellsFromBox, getOffsetX, getOffsetY, getAnchorPos, getCellPos, isSupported, canOccupy, containsOccupied, containsSupport |
| top-level / `me/justbecause/fastpaintings/painting/PaintingPlacementService.java` | `` |  | tryPlacePainting, tryPlacePainting, selectBestVariant, canPlaceFootprint, placePaintingBlocksTransactional, placePaintingBlocksTransactional |
| top-level / `me/justbecause/fastpaintings/painting/RestorationException.java` | `` |  |  |

## Data-driven behavior

Resource category counts: `tags`: 3.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
