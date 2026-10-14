# Rabbit Pathfinding Fixed

Review status: **Evidence inventory; behavioral review pending**

Project: [Rabbit Pathfinding Fixed](https://modrinth.com/mod/rabbit-pathfinding-fix)
Selected artifact version: `1.5.0`
Published implementation source: https://github.com/litetex-oss/mcm-rabbit-pathfinding-fix
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Fixes rabbit pathfinding efficiently

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha1`: `a25b00376e906c3969b7a2b3b7f40b4412d31f0d`
- `sha512`: `39f0131efb3a413a581227ca00d22730c15e3591dbc2421418ce1015808920a82ab1b8a22809535bf066b60cc0df7542fc4cd7db24a4cc91efe863ec9a4f7941`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 8
Reconstructed Java files: 8

**environment**

```json
"*"
```

**accessWidener**

```json
"rabbit-pathfinding-fix.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/litetex/rpf/mixin/client/RabbitModelMixin.java` | `value={RabbitModel.class})` | Inject:1 |  |
| top-level / `net/litetex/rpf/mixin/EntityNavigationMixin.java` | `value={PathNavigation.class})` | Inject:1, ModifyConstant:1 | checkTimeoutsBreakInfinite |
| top-level / `net/litetex/rpf/mixin/RabbitEntity_EntityMixin.java` | `value={Entity.class})` |  |  |
| top-level / `net/litetex/rpf/mixin/RabbitEntity_LivingEntityMixin.java` | `value={LivingEntity.class})` |  |  |
| top-level / `net/litetex/rpf/mixin/RabbitEntity_MobEntityMixin.java` | `value={Mob.class})` |  |  |
| top-level / `net/litetex/rpf/mixin/RabbitEntityEatCarrotCropGoalMixin.java` | `value={Rabbit.RaidGardenGoal.class})` | Redirect:1, Inject:2 | moveMobToBlock, tickSuperRedirect, tickWaitUntilRabbitHasCompletedJump, isTargetPosDoNotAbortWhenHavingTarget, findNearestBlock |
| top-level / `net/litetex/rpf/mixin/RabbitEntityMixin.java` | `value={Rabbit.class})` | Inject:2 | getJumpVelocityOptimized, getBaseJumpPower, isYRequiringJump, self, initGoalsAddLookAroundGoal |
| top-level / `net/litetex/rpf/mixin/RabbitEntityRabbitMoveControlMixin.java` | `value={Rabbit.RabbitMoveControl.class})` | WrapOperation:1 |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
