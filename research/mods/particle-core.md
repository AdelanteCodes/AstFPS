# Particle Core

Review status: **Evidence inventory; behavioral review pending**

Project: [Particle Core](https://modrinth.com/mod/particle-core)
Selected artifact version: `0.3.3+fix1+26.2`
Published implementation source: https://github.com/fzzyhmstrs/pc
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Particle optimizations: Culling, rendering optimizations, configurable particle-type-specific spawn reduction, and potion particle disabling. Compatible with Sodium, improves performance over Sodium alone.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `1e04e1a40ea29c704c5ce008a8e737938a53a7f5`
- `sha512`: `7818227221913c2be92f7ef2882abfa85629e126fdd86c5715772df27334c1774aa30a87e88cd373d7d65cebdde2576592b10767ac62fcb5de2cf54d41a8bca5`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 50
Reconstructed Java files: 38

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [],
  "client": [
    {
      "adapter": "kotlin",
      "value": "me.fzzyhmstrs.particle_core.PcConfig"
    }
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.2",
  "fabric-language-kotlin": ">=1.13.9+kotlin.2.3.10",
  "minecraft": ">=26.2",
  "fzzy_config": ">=0.7.6"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/conditional-mixin-0.5.1.jar` | 16 | `conditional-mixin` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/fzzyhmstrs/particle_core/CustomBlockCollisionSpliterator.java` | `` |  | getChunk, computeNext |
| top-level / `me/fzzyhmstrs/particle_core/interfaces/BlockPosStorer.java` | `` |  |  |
| top-level / `me/fzzyhmstrs/particle_core/interfaces/CachedLightPreparer.java` | `` |  |  |
| top-level / `me/fzzyhmstrs/particle_core/interfaces/CachedLightProvider.java` | `` |  |  |
| top-level / `me/fzzyhmstrs/particle_core/interfaces/FrustumBlacklisted.java` | `` |  |  |
| top-level / `me/fzzyhmstrs/particle_core/interfaces/FrustumProvider.java` | `` |  |  |
| top-level / `me/fzzyhmstrs/particle_core/interfaces/ParticleCreator.java` | `` |  |  |
| top-level / `me/fzzyhmstrs/particle_core/interfaces/RotationProvider.java` | `` |  |  |
| top-level / `me/fzzyhmstrs/particle_core/interfaces/TickResult.java` | `` |  | TickResult, Results |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ClientLevelDecreaseMixin.java` | `value={ClientLevel.class})` | WrapOperation:1 | particle_core_reduceParticleSpawnType |
| top-level / `me/fzzyhmstrs/particle_core/mixins/FireworksSparkParticleMixin.java` | `value={FireworkParticles.Starter.class})` | WrapOperation:1 | particle_core_handleParticleNullability |
| top-level / `me/fzzyhmstrs/particle_core/mixins/FrustumAccessor.java` | `value={Frustum.class})` | Accessor:4 |  |
| top-level / `me/fzzyhmstrs/particle_core/mixins/LivingEntityMixin.java` | `value={LivingEntity.class})` | WrapWithCondition:1 | particle_core_turnOffPotionParticles |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ParticleAccessor.java` | `value={Particle.class})` | Accessor:3 |  |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ParticleBrightnessCacheMixin.java` | `value={Particle.class})` | WrapOperation:1 | particle_core_getCachedBrightness, particle_core_tickLightUpdate, getLightmap |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ParticleCachePosMixin.java` | `value={Particle.class})` |  | particle_core_tickCachedPos, particle_core_getCachedPos, particle_core_getCachedState, particle_core_getCachedEmpty |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ParticleEngineAsyncMixin.java` | `value={ParticleEngine.class}, priority=100000)` | WrapOperation:3 | particle_core_setupSynchronizedParticleMap, particle_core_synchronizeParticleAdds, particle_core_asyncParticleTicking, syncTickParticles, asyncTickParticles, tickParticleSafe, checkStackTrace, finalizeParticles |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ParticleEngineCachedLightMixin.java` | `value={ParticleEngine.class})` | Inject:1 | particle_core_getCache, particle_core_clearCache |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ParticleEngineCreatorMixin.java` | `value={ParticleEngine.class})` | Invoker:1 | particle_core_createSafe |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ParticleEngineFrustumMixin.java` | `value={ParticleEngine.class})` | Inject:1 | particle_core_setFrustum, particle_core_getFrustum, particle_core_setupBlacklistForParticle |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ParticleEngineRenderDistanceMixin.java` | `value={ParticleEngine.class}, priority=100000)` | Inject:1 | particle_core_setupViewDistance |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ParticleEngineTypeMixin.java` | `value={ParticleEngine.class})` | Inject:1 | particle_core_excludeAndChanceParticles |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ParticleFrustumBlacklistMixin.java` | `value={Particle.class})` |  | particle_core_setBlacklisted, particle_core_isBlacklisted |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ParticleGroupAccessor.java` | `value={ParticleGroup.class})` | Invoker:1, Accessor:1 |  |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ParticleGroupBrightnessTickMixin.java` | `value={ParticleGroup.class})` | WrapOperation:1 | particle_core_tickParticleLightUpdates |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ParticleGroupCachedPosMixin.java` | `value={ParticleGroup.class})` | WrapOperation:1 | particle_core_tickParticlePositions |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ParticleGroupCountMixin.java` | `value={ParticleGroup.class}, priority=100000)` | ModifyConstant:1 | particle_core_modifyParticleMaxCount |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ParticleGroupFrustumMixin.java` | `value={QuadParticleGroup.class})` | WrapOperation:1 | particle_core_cullParticles |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ParticleGroupRenderDistanceMixin.java` | `value={QuadParticleGroup.class})` | WrapWithCondition:1 | particle_core_buildGeoIfWithinRenderDistance |
| top-level / `me/fzzyhmstrs/particle_core/mixins/ParticleMoveAdjustMixin.java` | `value={Particle.class})` | WrapOperation:1 | particle_core_optimizeOpenAirParticleCollisions, adjustMovementForCollisions, adjustMovementForCollisions, getBlockCollisions |
| top-level / `me/fzzyhmstrs/particle_core/PcConfig.java` | `` |  | getLogger, getRenderDistance$particle_core, setRenderDistance$particle_core, getPreviousChoices$particle_core, setPreviousChoices$particle_core, getChoiceFlags$particle_core, setChoiceFlags$particle_core, getImpl, setImpl, shouldRenderParticle, shouldDisablePotionParticle, onInitializeClient, impl$lambda$0, getPotionParticles_Allowed_Values, setPotionParticles_Allowed_Values, getParticlesAllChance, setParticlesAllChance, getParticlesDecreasedChance, setParticlesDecreasedChance, getParticlesByType, setParticlesByType, getDisableParticles, setDisableParticles, getDisable_Optimizations_Options, setDisable_Optimizations_Options, prefix, values, valueOf, getEntries, pass, shouldKeep, pass, shouldKeep, pass, shouldKeep, getMapTo, prefix, values, valueOf, getEntries, getFlags, getChoicePredicate, prefix, values, valueOf, getEntries, _init_$lambda$0, _init_$lambda$1, _init_$lambda$2, _init_$lambda$3, _init_$lambda$4 |
| top-level / `me/fzzyhmstrs/particle_core/PcConfigImpl.java` | `` |  | update, getDisableParticles, setDisableParticles, getMaxParticlesPerSheet, setMaxParticlesPerSheet, getAsynchronousTicking, setAsynchronousTicking, setupParticleViewDistance, shouldSpawnParticle, passParticleCull, keepParticle, shouldBlacklistParticle, getReducedParticleSpawnType, turnOffPotionParticlesV2$lambda$0$0, turnOffPotionParticlesV2$lambda$0 |
| top-level / `me/fzzyhmstrs/particle_core/PcDisable.java` | `` |  | getDisabledMixinsConfig, getDisabledOptimizations, setDisabledOptimizations, get_Disable_Optimizations_Options, set_Disable_Optimizations_Options, getDisableOptimizations, setDisableOptimizations, shouldDisableMixin |
| top-level / `me/fzzyhmstrs/particle_core/PcUtils.java` | `` |  | getRandom$particle_core |
| top-level / `me/fzzyhmstrs/particle_core/plugin/PcConditionTester.java` | `` |  | isSatisfied |
| top-level / `me/fzzyhmstrs/particle_core/plugin/PcMixinPlugin.java` | `` |  | getRefMapperConfig, acceptTargets, getMixins |
| top-level / `me/fzzyhmstrs/particle_core/SynchronizedIdentityHashMap.java` | `` |  | size, isEmpty, containsKey, containsValue, get, put, remove, putAll, clear, keySet, entrySet, values, equals, hashCode, toString, getOrDefault, forEach, replaceAll, putIfAbsent, remove, replace, replace, computeIfAbsent, computeIfPresent, compute, merge, equals, hashCode, size, isEmpty, contains, toArray, iterator, add, remove, containsAll, addAll, removeAll, retainAll, clear, toString, forEach, removeIf, spliterator, stream, parallelStream |
| top-level / `me/fzzyhmstrs/particle_core/VertexContainer.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
