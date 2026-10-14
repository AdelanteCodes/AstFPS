# Boosters

Review status: **Evidence inventory; behavioral review pending**

Project: [Boosters](https://modrinth.com/mod/boosters)
Selected artifact version: `1.3.4.1-hotfix`
Published implementation source: https://github.com/IsnotKrix/boosters
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Throttles distant mob AI, culls off-screen entities, slows down far-away block entity ticking (except the ones you'd actually notice, like hoppers and pistons), and cuts particle count — deferring to Sodium/Lithium/EntityCulling instead of fighting them.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha512`: `348df5cfd04d78c7238991a556345ddafb7761bc872834a3e78e72d3ad3e921bc0b8535ddaa793db717a7ef0350ce94f6306449c3cbd22c01be373907e678703`
- `sha1`: `6b14f067c22bfe8b8a14cba19a4125e81fa60366`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 19
Reconstructed Java files: 19

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.boosters.BoostersMod"
  ],
  "client": [
    "com.boosters.client.BoostersModClient"
  ],
  "modmenu": [
    "com.boosters.client.BoostersModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*",
  "cloth-config": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/boosters/BoostersConfig.java` | `` |  | get, load, save |
| top-level / `com/boosters/BoostersMod.java` | `` |  | onInitialize, id |
| top-level / `com/boosters/BoostersPreset.java` | `` |  | displayName, applyTo, matches, near, matching |
| top-level / `com/boosters/BoostersStats.java` | `` |  | incrementAiStepsSkipped, incrementBlockEntityTicksSkipped, incrementItemTicksSkipped, incrementEntitiesCulled, incrementParticlesDropped, snapshotAndReset, aiStepsSkippedPerSecond, blockEntityTicksSkippedPerSecond, itemTicksSkippedPerSecond, entitiesCulledPerSecond, particlesDroppedPerSecond |
| top-level / `com/boosters/client/BoostersConfigScreen.java` | `` |  | note, build |
| top-level / `com/boosters/client/BoostersModClient.java` | `` |  | onInitializeClient |
| top-level / `com/boosters/client/BoostersModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/boosters/client/mixin/BlockEntityRendererDistanceMixin.java` | `value={BlockEntityRenderer.class})` | Inject:1 | boosters$scaleViewDistance |
| top-level / `com/boosters/client/mixin/DebugScreenStatusMixin.java` | `value={DebugScreenOverlay.class})` | Inject:1 | boosters$versionLine, boosters$appendStatusLine |
| top-level / `com/boosters/client/mixin/EntityDistanceCullMixin.java` | `value={EntityRenderDispatcher.class})` | Inject:1 | boosters$cullDistantEntities |
| top-level / `com/boosters/client/mixin/EntityNameTagCullMixin.java` | `value={EntityRenderer.class})` | Inject:1 | boosters$cullDistantNameTags |
| top-level / `com/boosters/client/mixin/EntityShadowCullMixin.java` | `value={EntityRenderer.class})` | Inject:1 | boosters$cullDistantShadows |
| top-level / `com/boosters/client/mixin/ParticleReductionMixin.java` | `value={ParticleEngine.class})` | Inject:1 | boosters$reduceParticles |
| top-level / `com/boosters/compat/ModCompat.java` | `` |  | init, checkMod, logIfPresent, shouldDeferEntityCulling, distanceMultiplier, detectedModsSummary |
| top-level / `com/boosters/mixin/BlockEntityThrottleMixin.java` | `targets={"net.minecraft.world.level.chunk.LevelChunk$BoundTickingBlockEntity"})` | Inject:1 | boosters$throttleTick |
| top-level / `com/boosters/mixin/ExperienceOrbThrottleMixin.java` | `value={ExperienceOrb.class})` | Inject:1 | boosters$throttleTick |
| top-level / `com/boosters/mixin/ItemEntityThrottleMixin.java` | `value={ItemEntity.class})` | Inject:1 | boosters$throttleTick |
| top-level / `com/boosters/mixin/MobAiThrottleMixin.java` | `value={Mob.class})` | Inject:1 | boosters$throttleAiStep |
| top-level / `com/boosters/util/ThrottleUtil.java` | `` |  | intervalForDistance, shouldTick |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
