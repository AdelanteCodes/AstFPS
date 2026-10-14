# Optimized Cushions

Review status: **Evidence inventory; behavioral review pending**

Project: [Optimized Cushions](https://modrinth.com/mod/optimized-cushions)
Selected artifact version: `1.2.0`
Published implementation source: https://github.com/NikitaCartes/Optimized-Cushions
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Optimizing cushions on client and server

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `1deeb6cf109e319cd9140b33d80a6485288974c4`
- `sha512`: `8f70588a6f8ad6482d76699e020507131be50d86f2455e054f84d85816fbed50e920f7e6f5368c1ca92b4e7c927db0370ef97d766692552e51bd0905182713ad`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 33
Reconstructed Java files: 30

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "xyz.nikitacartes.optimizedcushions.OptimizedCushionsClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3-",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `xyz/nikitacartes/optimizedcushions/CushionBaker.java` | `` |  | emit, templates, capture, diffuseByFace, QuadTemplate, CaptureSet |
| top-level / `xyz/nikitacartes/optimizedcushions/CushionExt.java` | `` |  |  |
| top-level / `xyz/nikitacartes/optimizedcushions/CushionRenderStateExt.java` | `` |  |  |
| top-level / `xyz/nikitacartes/optimizedcushions/CushionSectionTasks.java` | `` |  | addTask, executeTasks, clear |
| top-level / `xyz/nikitacartes/optimizedcushions/CushionTracker.java` | `` |  | onLoad, onUnload, markChanged, tick, isBaked, getForSection, flush, update, drop, isBakeable, commitBakedSection, commitUnbaked, snapshot, removeFromSection, markDirty, Snapshot |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/CushionMixin.java` | `value={Cushion.class})` | Inject:1 | optimizedcushions$isBaked, optimizedcushions$setBaked, optimizedcushions$onSetPos |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/CushionRendererMixin.java` | `value={CushionRenderer.class})` | Inject:2 | optimizedcushions$flagBaked, optimizedcushions$skipModel |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/CushionRenderStateMixin.java` | `value={CushionRenderState.class})` |  | optimizedcushions$setBaked, optimizedcushions$isBaked |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/EntityMixin.java` | `value={Entity.class})` | Inject:1 | optimizedcushions$onDataUpdated |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/LevelExtractorMixin.java` | `value={LevelExtractor.class})` | WrapOperation:1 | optimizedcushions$skipBakedCushions |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/LevelRendererMixin.java` | `value={LevelRenderer.class})` | Inject:1 | optimizedcushions$commitCushions |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/OptimizedCushionsMixinPlugin.java` | `` |  | onLoad, shouldApplyMixin, getRefMapperConfig, acceptTargets, getMixins, preApply, postApply |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/RenderSectionMixin.java` | `value={SectionRenderDispatcher.RenderSection.class})` | Inject:1 | optimizedcushions$commitCushions |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/SectionCompilerMixin.java` | `value={SectionCompiler.class})` | Inject:1 | optimizedcushions$bakeCushions |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/server/ChunkMapMixin.java` | `value={ChunkMap.class})` | Inject:2, WrapOperation:4 | optimizedcushions$resetQuiescent, optimizedcushions$classifyMove, optimizedcushions$skipStaticUpdatePlayer, optimizedcushions$widenCushionRange, optimizedcushions$classifyTrackedEntity, optimizedcushions$skipQuiescentSendChanges |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/server/CushionMixin.java` | `value={Cushion.class})` |  | optimizedcushions$isServerTicking, optimizedcushions$setServerTicking, optimizedcushions$isInTicker, optimizedcushions$setInTicker |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/server/EntityCallbacksMixin.java` | `targets={"net.minecraft.server.level.ServerLevel$EntityCallbacks"})` | Inject:2 | optimizedcushions$routeTickingStart, optimizedcushions$routeTickingEnd |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/server/EntityMixin.java` | `value={Entity.class})` | Inject:2 | optimizedcushions$onAddPassenger, optimizedcushions$onRemovePassenger, optimizedcushions$promote, optimizedcushions$demote |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/server/ServerEntityAccessor.java` | `value={ServerEntity.class})` | Accessor:1 |  |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/server/ServerLevelAccessor.java` | `value={ServerLevel.class})` | Accessor:2 |  |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/server/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:1 | optimizedcushions$cushionTicker, optimizedcushions$tickCushions |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/server/ServerPlayerMixin.java` | `value={ServerPlayer.class})` |  | optimizedcushions$skipCushionTracking |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/server/TrackedEntityMixin.java` | `targets={"net.minecraft.server.level.ChunkMap$TrackedEntity"})` |  | optimizedcushions$entity, optimizedcushions$serverEntity |
| top-level / `xyz/nikitacartes/optimizedcushions/mixin/SodiumChunkMeshMixin.java` | `targets={"net.caffeinemc.mods.sodium.fabric.level.FabricLevelRenderHooks", "net.caffeinemc.mods.sodium.neoforge.level.NeoForgeLevelRenderHooks"}, remap=false)` | Inject:1 | optimizedcushions$bakeCushions |
| top-level / `xyz/nikitacartes/optimizedcushions/OptimizedCushionsClient.java` | `` |  | isObeLoaded, isSodiumLoaded, onInitializeClient |
| top-level / `xyz/nikitacartes/optimizedcushions/server/CushionServerExt.java` | `` |  |  |
| top-level / `xyz/nikitacartes/optimizedcushions/server/CushionServerTicker.java` | `` |  | add, remove, promoteToVanilla, demoteIfIdle, tick |
| top-level / `xyz/nikitacartes/optimizedcushions/server/ServerLevelExt.java` | `` |  |  |
| top-level / `xyz/nikitacartes/optimizedcushions/server/ServerPlayerExt.java` | `` |  |  |
| top-level / `xyz/nikitacartes/optimizedcushions/server/TrackedEntityExt.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
