# Cull Fewer Leaves

Review status: **Evidence inventory; behavioral review pending**

Project: [Cull Fewer Leaves](https://modrinth.com/mod/cull-fewer-leaves)
Selected artifact version: `1.1.2`
Published implementation source: https://codeberg.org/MicrocontrollersDev/Cull-Fewer-Leaves
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Cull leaves while looking hot! A continuation of Cull Less Leaves.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `80e1763a3e0f2746aaa27da4d20837f62f5bea22fff326a6b7cecff43923ba1de91c6c5d4d8e5125bc263f35464cc858b556aa8ce8f1118e612677341d96d5d2`
- `sha1`: `0b603a240e2b1f424ef37562ebbe830b07008b30`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 10
Reconstructed Java files: 10

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "sodium:config_api_user": [
    "dev.microcontrollers.cullfewerleaves.compat.sodium.CullFewerLeavesSodiumConfig"
  ],
  "client": [
    "dev.microcontrollers.cullfewerleaves.CullFewerLeaves"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "minecraft": ">=26.1",
  "java": ">=25",
  "sodium": "*"
}
```

**breaks**

```json
{
  "moreculling": "*"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/kaleido-config-0.3.3+1.3.2.jar` | 215 | `folk_sisby_kaleido-config` | No |
| `META-INF/jars/mixinconstraints-1.1.0.jar` | 21 | `com_moulberry_mixinconstraints` | No |
| `META-INF/jars/mixinsquared-fabric-0.3.3.jar` | 62 | `mixinsquared` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/microcontrollers/cullfewerleaves/compat/sodium/CullFewerLeavesSodiumConfig.java` | `` |  | cfg, registerConfigLate |
| top-level / `dev/microcontrollers/cullfewerleaves/config/CullFewerLeavesConfig.java` | `` |  |  |
| top-level / `dev/microcontrollers/cullfewerleaves/Cullable.java` | `` |  |  |
| top-level / `dev/microcontrollers/cullfewerleaves/CullFewerLeaves.java` | `` |  | onInitializeClient, shouldCullSide |
| top-level / `dev/microcontrollers/cullfewerleaves/mixins/accessor/DirectionAccessor.java` | `value={Direction.class})` | Accessor:1 |  |
| top-level / `dev/microcontrollers/cullfewerleaves/mixins/blocks/LeavesBlockMixin.java` | `value={LeavesBlock.class})` |  | cfl$shouldCullSide |
| top-level / `dev/microcontrollers/cullfewerleaves/mixins/blocks/MangroveRootsBlockMixin.java` | `value={MangroveRootsBlock.class})` |  | cfl$shouldCullSide |
| top-level / `dev/microcontrollers/cullfewerleaves/mixins/blocks/PowderSnowBlockMixin.java` | `value={PowderSnowBlock.class})` |  | cfl$shouldCullSide |
| top-level / `dev/microcontrollers/cullfewerleaves/mixins/sodium/AbstractBlockRenderContextMixin.java` | `value={AbstractBlockRenderContext.class})` | ModifyExpressionValue:1 | shouldCullSide |
| top-level / `dev/microcontrollers/cullfewerleaves/util/BlockConstantRandom.java` | `` |  | getConstantRandomSeeded |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
