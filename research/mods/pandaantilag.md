# Panda Anti-Lag

Review status: **Evidence inventory; behavioral review pending**

Project: [Panda Anti-Lag](https://modrinth.com/mod/pandaantilag)
Selected artifact version: `2.3.0+26.3`
Published implementation source: https://github.com/TreeOfSelf/PandaAntiLag/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Stop common causes of lag on your server. Configure to your likings.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `c05e1eb813cf306164b3ae0db273025bd181d83a`
- `sha512`: `c486fa013718fc76120fb810e21f367b48cf10a0af11352ce81a0d216683f951a7c0c62acb482910b956d1c8364ba9e495b45fa607d6f48fa3be2db6e4ba425b`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 21
Reconstructed Java files: 20

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "me.TreeOfSelf.PandaAntiLag.PandaAntiLag"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.6",
  "minecraft": ">=26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/TreeOfSelf/PandaAntiLag/AntiLagSettings.java` | `` |  | loadConfig, saveConfig |
| top-level / `me/TreeOfSelf/PandaAntiLag/ChunkEntityData.java` | `` |  |  |
| top-level / `me/TreeOfSelf/PandaAntiLag/EnderPearlLimiter.java` | `` |  | init, onServerTick, checkAndRemoveExcessEnderPearls |
| top-level / `me/TreeOfSelf/PandaAntiLag/LagPos.java` | `` |  | fromChunkPos, of, hashCode, equals |
| top-level / `me/TreeOfSelf/PandaAntiLag/mixin/accessor/ArmadilloEntityAccessor.java` | `value={Armadillo.class})` | Accessor:2 |  |
| top-level / `me/TreeOfSelf/PandaAntiLag/mixin/accessor/BeeEntityAccessor.java` | `value={Bee.class})` | Accessor:10 |  |
| top-level / `me/TreeOfSelf/PandaAntiLag/mixin/accessor/SheepEntityAccessor.java` | `value={Sheep.class})` | Accessor:1 |  |
| top-level / `me/TreeOfSelf/PandaAntiLag/mixin/accessor/TadpoleEntityAccessor.java` | `value={Tadpole.class})` | Accessor:2 |  |
| top-level / `me/TreeOfSelf/PandaAntiLag/mixin/accessor/TurtleEntityAccessor.java` | `value={Turtle.class})` | Accessor:2 |  |
| top-level / `me/TreeOfSelf/PandaAntiLag/mixin/EntityPortalMixin.java` | `value={Entity.class})` | WrapMethod:1, Inject:1 | trackTeleportSource, capPortalTicket |
| top-level / `me/TreeOfSelf/PandaAntiLag/mixin/MobMixin.java` | `value={Mob.class})` | Inject:2 | pandaAntiLag$needsMovementTick, pandaAntiLag$setMovementOnly, movementOnlyAiStep, despawnWithoutPlayers |
| top-level / `me/TreeOfSelf/PandaAntiLag/mixin/NetherPortalBlockMixin.java` | `value={NetherPortalBlock.class})` | Inject:1 | capPortalSpawns |
| top-level / `me/TreeOfSelf/PandaAntiLag/mixin/ProjectileEntityMixin.java` | `value={Projectile.class})` | Inject:2 | handleProjectileSpawn, spawn, spawn |
| top-level / `me/TreeOfSelf/PandaAntiLag/mixin/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:1, Redirect:1 | getEntityType, onTickStart, regionKey, countAround, pandaAntiLag$countNearby, updateDivisors, redirectEntityTick |
| top-level / `me/TreeOfSelf/PandaAntiLag/mixin/ThrownEnderpearlPortalMixin.java` | `value={ThrownEnderpearl.class})` | WrapMethod:1 | trackTeleportSource |
| top-level / `me/TreeOfSelf/PandaAntiLag/PandaAntiLag.java` | `` |  | onInitialize |
| top-level / `me/TreeOfSelf/PandaAntiLag/PandaAntiLagCommand.java` | `` |  | register |
| top-level / `me/TreeOfSelf/PandaAntiLag/PortalOwnership.java` | `` |  | startTeleport, endTeleport, allowTicket, findOwner, countOwned, Area |
| top-level / `me/TreeOfSelf/PandaAntiLag/RegionMobCounts.java` | `` |  |  |
| top-level / `me/TreeOfSelf/PandaAntiLag/ThrottledMovement.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
