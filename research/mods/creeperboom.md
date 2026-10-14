# CreeperBoom

Review status: **Evidence inventory; behavioral review pending**

Project: [CreeperBoom](https://modrinth.com/mod/creeperboom)
Selected artifact version: `1.1+mc26.3-fabric`
Published implementation source: https://github.com/BaizhouziYou/CreeperBoom
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Control the behavior of Creepers after exploding

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `4bf16371a3cf09f4ddb3452b4f731c76e0f666b1`
- `sha512`: `efb27f0b478f94c490f43bfb6305d1274fb3ff46a1ea3ec45cb889ffbf9662e9a46f8e9aeb1b36348fba5d127a35344cd61eccb466467720093add488d1cf1be`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 5
Reconstructed Java files: 5

**entrypoints**

```json
{
  "main": [
    "org.bzzy.creeper.Creeper"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `org/bzzy/creeper/ConfigManager.java` | `` |  | load, save, get |
| top-level / `org/bzzy/creeper/Creeper.java` | `` |  | onInitialize, isKilledByChargedCreeper, dropPlayerHead |
| top-level / `org/bzzy/creeper/mixin/CreeperEntityMixin.java` | `value={Creeper.class})` | ModifyArg:1 | modifyExplosionType |
| top-level / `org/bzzy/creeper/mixin/v.java` | `` |  |  |
| top-level / `org/bzzy/creeper/ModConfig.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
