# Entity Culling

Review status: **Evidence inventory; behavioral review pending**

Project: [Entity Culling](https://modrinth.com/mod/entityculling)
Selected artifact version: `1.11.3`
Published implementation source: https://github.com/tr7zw/EntityCulling
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Using async path-tracing to hide Block-/Entities that are not visible

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `45f47f7a067f5efd733a32767dc3d1d770678b2a`
- `sha512`: `b6209bb62d72376d3fd284da137ec93a6dd38ebe5fd38ab9190deeade68b5b7f4bf915f4abcb4a807afe18cb9f0b59e11be789d46df6f0e6f64388ed2edc284d`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 38
Reconstructed Java files: 35

**entrypoints**

```json
{
  "client": [
    "dev.tr7zw.entityculling.EntityCullingMod"
  ],
  "modmenu": [
    "dev.tr7zw.entityculling.config.EntityCullingModMenu"
  ]
}
```

**depends**

```json
{
  "minecraft": "~26.3",
  "fabric-api": "*"
}
```

**breaks**

```json
{
  "tlskincape": "*"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/TRansition-1.0.26-26.3-fabric-SNAPSHOT.jar` | 751 | `transition` | No |
| `META-INF/jars/TRender-1.0.17-26.3-fabric-SNAPSHOT.jar` | 151 | `trender` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/logisticscraft/occlusionculling/cache/ArrayOcclusionCache.java` | `` |  | resetCache, setVisible, setHidden, getState, setLastVisible, setLastHidden |
| top-level / `com/logisticscraft/occlusionculling/cache/OcclusionCache.java` | `` |  |  |
| top-level / `com/logisticscraft/occlusionculling/DataProvider.java` | `` |  |  |
| top-level / `com/logisticscraft/occlusionculling/OcclusionCullingInstance.java` | `` |  | isAABBVisible, isVoxelVisible, rayIntersection, isVisible, stepRay, getCacheValue, cacheResult, cacheResult, resetCache, from |
| top-level / `com/logisticscraft/occlusionculling/util/MathUtilities.java` | `` |  | floor, fastFloor, ceil |
| top-level / `com/logisticscraft/occlusionculling/util/Vec3d.java` | `` |  | getX, getY, getZ, set, setAdd, div, normalize, equals, hashCode, toString |
| top-level / `dev/tr7zw/entityculling/access/Cullable.java` | `` |  |  |
| top-level / `dev/tr7zw/entityculling/access/EntityRendererInter.java` | `` |  |  |
| top-level / `dev/tr7zw/entityculling/BlockEntityRenderFabricExtension.java` | `` |  |  |
| top-level / `dev/tr7zw/entityculling/config/ConfigScreenProvider.java` | `` |  | createConfigScreen, getStringEntity, getStringBlockEntity, save, reset |
| top-level / `dev/tr7zw/entityculling/config/EntityCullingModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `dev/tr7zw/entityculling/CullTask.java` | `` |  | run, cullEntities, cullBlockEntities, closerThan, distSqr, setIngame, setEntitiesForRendering, setBlockEntities, setCameraMC |
| top-level / `dev/tr7zw/entityculling/DebugCollector.java` | `` |  | requestStart, tick, dumpData, addEntity, addBlockEntity, isRunning, getDataHolder, clear |
| top-level / `dev/tr7zw/entityculling/debugEntries/CulledBlockEntitiesEntry.java` | `` |  | display, isAllowed, category |
| top-level / `dev/tr7zw/entityculling/debugEntries/CulledEntitiesEntry.java` | `` |  | display, isAllowed, category |
| top-level / `dev/tr7zw/entityculling/debugEntries/CullTimingEntry.java` | `` |  | display, isAllowed, category |
| top-level / `dev/tr7zw/entityculling/debugEntries/TickCullingEntry.java` | `` |  | display, isAllowed, category |
| top-level / `dev/tr7zw/entityculling/EntityCullingMod.java` | `` |  | onInitializeClient, initModloader, setupAABB, registerDebugLine |
| top-level / `dev/tr7zw/entityculling/EntityCullingModBase.java` | `` |  | onInitialize, worldTick, clientTick, prefetchBlockEntityData, prefetchEntityData, isBlockEntityDynamicWhitelisted, isEntityDynamicWhitelisted, addDynamicBlockEntityWhitelist, addDynamicEntityWhitelist |
| top-level / `dev/tr7zw/entityculling/KeybindHolder.java` | `` |  | registerKeybinds |
| top-level / `dev/tr7zw/entityculling/mixin/BlockEntityRenderDispatcherMixin.java` | `value={BlockEntityRenderDispatcher.class})` | Inject:1 | tryExtractRenderState |
| top-level / `dev/tr7zw/entityculling/mixin/BlockEntityRendererMixin.java` | `value={BlockEntityRenderer.class})` |  |  |
| top-level / `dev/tr7zw/entityculling/mixin/ClientWorldMixin.java` | `value={ClientLevel.class})` | Inject:1 | tickEntity, processDisplay, basicTick, getWardenHeartBeatDelay |
| top-level / `dev/tr7zw/entityculling/mixin/CullableMixin.java` | `value={Entity.class, BlockEntity.class})` |  | setTimeout, isForcedVisible, setCulled, isCulled, setOutOfCamera, isOutOfCamera, isShouldEntityAppearGlowing, setShouldEntityAppearGlowing, getEc$BoundingBox, setEc$BoundingBox, getEc$Position, setEc$Position, getEc$PBlockPos, setEc$PBlockPos |
| top-level / `dev/tr7zw/entityculling/mixin/DebugHudMixin.java` | `value={DebugScreenOverlay.class})` |  |  |
| top-level / `dev/tr7zw/entityculling/mixin/DebugScreenEntriesAccessor.java` | `value={DebugScreenEntries.class})` | Invoker:1 | invokeRegister |
| top-level / `dev/tr7zw/entityculling/mixin/DisplayAccessor.java` | `value={Display.class})` | Invoker:2 |  |
| top-level / `dev/tr7zw/entityculling/mixin/EntityRendererMixin.java` | `value={EntityRenderer.class})` |  | shadowShouldShowName, entityCullingIgnoresCulling, entityCullingGetCullingBox |
| top-level / `dev/tr7zw/entityculling/mixin/LivingEntityRendererAccessor.java` | `value={LivingEntityRenderer.class})` | Invoker:1 |  |
| top-level / `dev/tr7zw/entityculling/mixin/WorldRendererMixin.java` | `value={LevelExtractor.class})` | Inject:2 | extractEntityRedir, processNametag, extractVisibleEntities |
| top-level / `dev/tr7zw/entityculling/NMSCullingHelper.java` | `` |  | ignoresCulling, getCullingBox, getRenderOffset |
| top-level / `dev/tr7zw/entityculling/Provider.java` | `` |  | prepareChunk, isOpaqueFullCube, cleanup |
| top-level / `dev/tr7zw/entityculling/versionless/Config.java` | `` |  |  |
| top-level / `dev/tr7zw/entityculling/versionless/ConfigUpgrader.java` | `` |  | upgradeConfig |
| top-level / `dev/tr7zw/entityculling/versionless/EntityCullingVersionlessBase.java` | `` |  | onInitialize, writeConfig |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
