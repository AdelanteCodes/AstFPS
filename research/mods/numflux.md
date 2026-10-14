# NumFlux

Review status: **Evidence inventory; behavioral review pending**

Project: [NumFlux](https://modrinth.com/mod/numflux)
Selected artifact version: `1.0.6-26.3-fabric`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A small server-only mod that speeds up certain interactions between entities and simplifies certain mathematical formulas.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `1b345c64e2a7d4905294d9472b86b3b567310d7c`
- `sha512`: `2ba34cf4f39f6ff3f6b70c7cae90796e15e55f45899ce7a5662861c6161cd7ec4e6417559d86c3a3199e1479fd9d5fdf517fccc1492eb81bc485b74802b19af8`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 16
Reconstructed Java files: 16

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.mr_toad.num_flux.fabric.NumFluxFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.1",
  "minecraft": "*",
  "java": ">=25",
  "architectury": "*",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/mr_toad/num_flux/api/FluxMath.java` | `` |  | lengthSquared, invsqrt, cosFromSin |
| top-level / `com/mr_toad/num_flux/fabric/NumFluxFabric.java` | `` |  | onInitialize |
| top-level / `com/mr_toad/num_flux/mixin/block/ComposterBlockEmptyContainerMixin.java` | `targets={"net/minecraft/world/level/block/ComposterBlock$EmptyContainer"})` | Inject:1 | getConstant |
| top-level / `com/mr_toad/num_flux/mixin/block/ComposterBlockInputContainerMixin.java` | `targets={"net/minecraft/world/level/block/ComposterBlock$InputContainer"})` | Inject:1 | getConstant |
| top-level / `com/mr_toad/num_flux/mixin/block/ComposterBlockOutputContainerMixin.java` | `targets={"net/minecraft/world/level/block/ComposterBlock$OutputContainer"})` | Inject:1 | getConstant |
| top-level / `com/mr_toad/num_flux/mixin/ChunkMapAccessor.java` | `value={ChunkMap.class})` | Invoker:2 |  |
| top-level / `com/mr_toad/num_flux/mixin/entity/AbstractArrowMixin.java` | `value={AbstractArrow.class})` | Redirect:3, ModifyArg:1 | isFire, clientOnlyBParticles, clientOnlyCParticles, simpleRotation |
| top-level / `com/mr_toad/num_flux/mixin/entity/ExperienceOrbMixin.java` | `value={ExperienceOrb.class})` | ModifyExpressionValue:1 | sh$widerMerge |
| top-level / `com/mr_toad/num_flux/mixin/entity/ItemEntityMixin.java` | `value={ItemEntity.class})` | ModifyExpressionValue:1 | sh$widerMerge |
| top-level / `com/mr_toad/num_flux/mixin/entity/MobMixin.java` | `value={Mob.class})` | Inject:1, ModifyConstant:1 | sh$throttle, sh$scaleRoll |
| top-level / `com/mr_toad/num_flux/mixin/gen/BelowZeroRetrogenMixin.java` | `value={BelowZeroRetrogen.class})` | Inject:3 | initArr, hasBedrockHolesF, hasBedrockHoleF |
| top-level / `com/mr_toad/num_flux/mixin/math/GivensParametersMixin.java` | `value={GivensParameters.class})` | Inject:2 | fastUnNorm, fastAngle |
| top-level / `com/mr_toad/num_flux/mixin/math/MthMixin.java` | `value={Mth.class})` | Inject:3 | fastFM, fastCL2, fastFL2 |
| top-level / `com/mr_toad/num_flux/mixin/TrackedEntityMixin.java` | `targets={"net/minecraft/server/level/ChunkMap$TrackedEntity"})` | Inject:1 | nf$fastUpdatePlayer |
| top-level / `com/mr_toad/num_flux/mixin/UtilMixin.java` | `value={Util.class})` | Inject:3 | getMaxThreadsNF, getOS, sanitizeNameFast |
| top-level / `com/mr_toad/num_flux/NumFlux.java` | `` |  | init |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
