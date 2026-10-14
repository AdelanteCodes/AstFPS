# Accelerated Decay

Review status: **Evidence inventory; behavioral review pending**

Project: [Accelerated Decay](https://modrinth.com/mod/accelerated-decay)
Selected artifact version: `26.3.0.1`
Published implementation source: https://github.com/ErrorMikey/AcceleratedDecay
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Speeds up the leaf decaying process

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha1`: `03fa4f7b834fc9d90b7fa76850f4457fe93d4ca3`
- `sha512`: `1ea1785b70411c99e98c462e79474862b3822d11ebb2dc537667cd615575c010d09a141cc940d1698e8be9db9570ef5cafc90d2bb92f9fa23dacd85c82c8de80`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 5
Reconstructed Java files: 3

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "pro.mikey.accelerateddecay.fabric.AcceleratedDecayFabric"
  ]
}
```

**depends**

```json
{
  "fabric-api": ">=0.161.0+26.3",
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `pro/mikey/accelerateddecay/AcceleratedDecay.java` | `` |  | init, levelTick, tryAddLeaveToQueue, destroyBlockWithOptionalSoundAndParticles, getOrCreate |
| top-level / `pro/mikey/accelerateddecay/fabric/AcceleratedDecayFabric.java` | `` |  | onInitialize |
| top-level / `pro/mikey/accelerateddecay/mixins/LevelMixin.java` | `value={Level.class})` | Inject:1 | acceleratedDecay$onBlockStateUpdate |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
