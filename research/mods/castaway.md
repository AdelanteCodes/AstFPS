# Cast Away

Review status: **Evidence inventory; behavioral review pending**

Project: [Cast Away](https://modrinth.com/mod/castaway)
Selected artifact version: `3.0.2`
Published implementation source: https://github.com/GMalvestiti/CastAway
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Disables lava casts with no performance overhead

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `1d616bc467e4404bb25a6379a7176eb61e14d3cb87a3f88350a0dd26a97fd5541ca49d2e1123a8c149f5095898a6fdd8833de778fed9dc8c0663ac1888bc4ad5`
- `sha1`: `70f3e6053336439d42233d4e12bd7fadbdc48b07`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 5
Reconstructed Java files: 5

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "net.riser876.castaway.CastAway"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.5",
  "minecraft": ">=26.1"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/riser876/castaway/CastAway.java` | `` |  | onInitialize, setFlowingWater |
| top-level / `net/riser876/castaway/config/Config.java` | `` |  |  |
| top-level / `net/riser876/castaway/config/ConfigManager.java` | `` |  | loadConfig, loadDefaultConfig, saveConfig, validateConfig |
| top-level / `net/riser876/castaway/mixin/CastAwayMixinPlugin.java` | `` |  | onLoad, shouldApplyMixin, getRefMapperConfig, acceptTargets, getMixins, preApply, postApply |
| top-level / `net/riser876/castaway/mixin/LiquidBlockMixin.java` | `value={LiquidBlock.class})` | WrapOperation:1 | castAway$wrapSetBlockState |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
