# Rhenium

Review status: **Behavioral static review**

Project: [Rhenium](https://modrinth.com/mod/rhenium-mod)
Selected artifact version: `1.2.1`
Published implementation source: https://github.com/ItzTidez/Rhenium
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Optimization for minecraft that culls block entities, entities, particles and items.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha512`: `6586f1c57ffe6158954f1ba058d1ef639b065056055b08a7ffc6718ab23ac4240a79a291cdc09981547d40a5e00a1c05d41a3f19308eed5492c18bcfab311f80`
- `sha1`: `079b5922a4f6d8bbbaad9d451f3521fae8a5569b`

## Reviewed mechanism

All nine reconstructed Java classes reviewed.

- Applies configured distance cutoffs to chest render eligibility, entity rendering, and particle ticking.
- Cancels stationary grounded item ticks on three of four invocations. Cancels hopper pushItemsTick on eleven of twelve invocations while its cooldown is positive.
- Config fields also advertise entity tick culling and chunk-load spreading, but no implementing hook for those fields is shown in these reconstructed classes.

## Lifecycle, correctness, and failure questions

- Skipping particle tick can freeze movement/age and delay expiry instead of merely avoiding invisible drawing. Skipping entire item ticks can alter despawn/pickup/timers.
- Hopper cancellation may stop normal cooldown progression inside the cancelled method; transfer timing must be checked rather than assuming idle behavior is unchanged.
- The entity-distance hook uses incoming coordinates as a world point; verify whether that call passes camera-relative coordinates. Config parsing catches I/O failures but not every malformed JSON/runtime failure.

## Checks needed to establish equivalence

- Inspect coordinate conventions and cooldown ownership. Test pickup/despawn, hopper throughput/cooldowns, distant particles returning to view, world switches, and malformed config.

## Relevance to AstFPS

Mostly distance cuts and tick throttling with behavior changes; does not meet unchanged-visuals/behavior requirements as observed.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 9
Reconstructed Java files: 9

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.rhenium.RheniumMod"
  ],
  "modmenu": [
    "com.rhenium.RheniumModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "~26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/rhenium/config/RheniumConfig.java` | `` |  | get, load, save |
| top-level / `com/rhenium/config/RheniumConfigScreen.java` | `` |  | create |
| top-level / `com/rhenium/mixin/client/ChestRenderDistanceMixin.java` | `value={BlockEntityRenderer.class})` | Inject:1 | rhenium$cullDistantChests |
| top-level / `com/rhenium/mixin/client/EntityRendererCullMixin.java` | `value={EntityRenderDispatcher.class})` | Inject:1 | rhenium$cullDistantEntities |
| top-level / `com/rhenium/mixin/client/ParticleCullMixin.java` | `value={Particle.class})` | Inject:1 | rhenium$cullDistantParticle |
| top-level / `com/rhenium/mixin/HopperBlockEntityMixin.java` | `value={HopperBlockEntity.class})` | Inject:1 | rhenium$throttleIdleHopper |
| top-level / `com/rhenium/mixin/ItemEntityMixin.java` | `value={ItemEntity.class})` | Inject:1 | rhenium$throttleItemTick |
| top-level / `com/rhenium/RheniumMod.java` | `` |  | onInitialize |
| top-level / `com/rhenium/RheniumModMenuIntegration.java` | `` |  | getModConfigScreenFactory |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
