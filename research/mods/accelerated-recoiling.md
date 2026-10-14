# Accelerated Recoiling

Review status: **Evidence inventory; behavioral review pending**

Project: [Accelerated Recoiling](https://modrinth.com/mod/accelerated-recoiling)
Selected artifact version: `26.3.0-fabric`
Published implementation source: https://github.com/wiyuka0/AcceleratedRecoiling/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A mod of aabb collision optimization.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `ea0984492dd884181091f30776ce9cfbdc4bfabb`
- `sha512`: `8424beda6571e7a2d19c3e28589382c15efc72023f4f9b6f4c84e50c939e66d87599932694e02569c893d4402a979c407e1e7a1bfdb99cc91c34be173437fee7`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 38
Reconstructed Java files: 29

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.wiyuka.acceleratedrecoiling.AcceleratedRecoiling"
  ],
  "client": [
    "com.wiyuka.acceleratedrecoiling.client.AcceleratedRecoilingClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16.0",
  "minecraft": "26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/wiyuka/acceleratedrecoiling/AcceleratedRecoiling.java` | `` |  | onInitialize |
| top-level / `com/wiyuka/acceleratedrecoiling/client/AcceleratedRecoilingClient.java` | `` |  | onInitializeClient |
| top-level / `com/wiyuka/acceleratedrecoiling/client/ConfigScreen.java` | `` |  | init, repositionElements, onClose |
| top-level / `com/wiyuka/acceleratedrecoiling/config/FoldConfig.java` | `` |  | loadConfig, saveConfig |
| top-level / `com/wiyuka/acceleratedrecoiling/listeners/ServerStop.java` | `` |  | register |
| top-level / `com/wiyuka/acceleratedrecoiling/mixin/BatchedEntityStateMixin.java` | `value={Entity.class})` | Inject:4 | ar$stateChanged, ar$mounted, ar$blockCachePopulated, ar$blockCacheCleared |
| top-level / `com/wiyuka/acceleratedrecoiling/mixin/BatchedLevelAccess.java` | `value={Level.class})` | Invoker:1 |  |
| top-level / `com/wiyuka/acceleratedrecoiling/mixin/BatchedLivingEntityMixin.java` | `value={LivingEntity.class})` | WrapMethod:1 | ar$batchPlainCollisions |
| top-level / `com/wiyuka/acceleratedrecoiling/mixin/BatchedMovementMixin.java` | `value={Entity.class})` | WrapOperation:1 | ar$softSections |
| top-level / `com/wiyuka/acceleratedrecoiling/mixin/BatchedScoreboardMixin.java` | `value={Scoreboard.class})` | Inject:2 | ar$joined, ar$left |
| top-level / `com/wiyuka/acceleratedrecoiling/mixin/BatchedSyncedStateMixin.java` | `value={SynchedEntityData.class})` | Inject:1 | ar$dataChanged |
| top-level / `com/wiyuka/acceleratedrecoiling/mixin/ClimbableTagMixin.java` | `value={Holder.Reference.class})` | Inject:1, WrapMethod:1 | ar$tagsChanged, ar$climbableTag |
| top-level / `com/wiyuka/acceleratedrecoiling/mixin/EntityMixin.java` | `value={Entity.class})` | Inject:1 | ar$bindSection, ar$unbindSection, ar$collisionStateDirty, ar$cachedBlockState, ar$section, ar$sectionSlot, ar$boxChanged |
| top-level / `com/wiyuka/acceleratedrecoiling/mixin/LivingEntityDoPushInvoker.java` | `value={LivingEntity.class})` | Invoker:1 |  |
| top-level / `com/wiyuka/acceleratedrecoiling/mixin/PushableMemoryMixin.java` | `value={LivingEntity.class})` | WrapOperation:1 | ar$invalidatePushable, ar$memoizedClimbable |
| top-level / `com/wiyuka/acceleratedrecoiling/mixin/RealtimeGetterAccess.java` | `value={LevelEntityGetterAdapter.class})` | Accessor:1 |  |
| top-level / `com/wiyuka/acceleratedrecoiling/mixin/RealtimeSectionMixin.java` | `value={EntitySection.class})` | Inject:2 | ar$realtimeSection, added, removed |
| top-level / `com/wiyuka/acceleratedrecoiling/mixin/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:1 | ar$initialize |
| top-level / `com/wiyuka/acceleratedrecoiling/natives/realtime/BatchDiagnostics.java` | `` |  |  |
| top-level / `com/wiyuka/acceleratedrecoiling/natives/realtime/BatchedCollisions.java` | `` |  | buffer, clear, stats, noEntityObstacles, tryPush, canPush, collectSections, prepareSectionDescriptors, queryAndPush, dispatchPushes |
| top-level / `com/wiyuka/acceleratedrecoiling/natives/realtime/BatchedRules.java` | `` |  | computeValue, computeValue, computeValue, computeValue, epoch, invalidatePolicy, vanillaEntity, plain, orderedSections, soft, cleanWorld, classify |
| top-level / `com/wiyuka/acceleratedrecoiling/natives/realtime/CollisionMethods.java` | `` |  | interfacesUnchanged, loadReferences, pushable, soft |
| top-level / `com/wiyuka/acceleratedrecoiling/natives/realtime/IndexedEntity.java` | `` |  |  |
| top-level / `com/wiyuka/acceleratedrecoiling/natives/realtime/IndexedSection.java` | `` |  |  |
| top-level / `com/wiyuka/acceleratedrecoiling/natives/realtime/LithiumCompatibility.java` | `` |  | loadMixins, isLoaded, allows, status |
| top-level / `com/wiyuka/acceleratedrecoiling/natives/realtime/PushableCache.java` | `` |  | reset |
| top-level / `com/wiyuka/acceleratedrecoiling/natives/realtime/PushableMemoryEntity.java` | `` |  |  |
| top-level / `com/wiyuka/acceleratedrecoiling/natives/realtime/RealtimeNative.java` | `` |  | initialize, isAvailable, isEnabled, platformPath, kernelName |
| top-level / `com/wiyuka/acceleratedrecoiling/natives/realtime/RealtimeSection.java` | `` |  | currentView, stateDirty, prepareBatch, softOnly, added, removed, view, update, clearBox, writeBox, quantize, entities, sectionPosition, address, stride, count, retain, release |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
