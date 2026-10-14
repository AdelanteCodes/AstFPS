# Explodee

Review status: **Evidence inventory; behavioral review pending**

Project: [Explodee](https://modrinth.com/mod/explodee)
Selected artifact version: `1.1+26.1-26.3-fabric`
Published implementation source: https://github.com/KnownSH/Explodee/tree/main
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Makes Minecraft's explosion algorithm propagate spherically. Leading to more intense explosions.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `e6a420f83c841a293a06a51885b7934baa5c953f`
- `sha512`: `2c5d0154c48002a2994974bc54d6e022d578bb3d047e70fb72b88dee2b509ab3861b1740dbcce42b8154731d38e22cf1f4a5ce333295b7dc6855b4190ffd674a`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 4
Reconstructed Java files: 4

**environment**

```json
"*"
```

**entrypoints**

```json
{}
```

**depends**

```json
{
  "fabricloader": ">=0.16",
  "minecraft": ">=26.1 <26.4-",
  "java": ">=25"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/mixinsquared-fabric-0.3.7.jar` | 76 | `mixinsquared` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `derg/explodee/api/ExplodeeMath.java` | `` |  | rayCount, phi, theta, x, y, z |
| top-level / `derg/explodee/mixin/compat/LithiumExplosionMixinMixin.java` | `value={ServerExplosion.class}, priority=1500)` | ModifyConstant:3, ModifyVariable:3 | explodee$rayCount, explodee$singleY, explodee$singleZ, explodee$dirX, explodee$dirY, explodee$dirZ |
| top-level / `derg/explodee/mixin/ExplodeeMixinPlugin.java` | `` |  | hasLithiumExplosionMixin, onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `derg/explodee/mixin/ExplosionMixin.java` | `value={ServerExplosion.class})` | ModifyConstant:3, ModifyVariable:4 | explodee$singleJ, explodee$singleK, explodee$rayCount, explodee$directionX, explodee$directionY, explodee$directionZ, epxlodee$unitLength |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
