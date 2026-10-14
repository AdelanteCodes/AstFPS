# XP Stream

Review status: **Evidence inventory; behavioral review pending**

Project: [XP Stream](https://modrinth.com/mod/xp-stream)
Selected artifact version: `1.1.8`
Published implementation source: https://github.com/Jed-Tech/XP_Stream
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Absorbs XP orbs faster without clumping, while preserving the magic feel and core mechanics of normal XP collection.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `68fd0af3027cfc961124c33fb7c50a4e3aa5d17a599a6076ec462b4f8cc14afbbe4c48c720adc39db8b3e75f48e317bd24d3eea2be8acf6d4f6ecc095e54a46a`
- `sha1`: `392a0975dce78a426c7f58c2416e66f869eade4d`

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
    "com.jedtech.xp_stream.fabric.XpStreamFabricMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "minecraft": ">=26.3-alpha.1 <26.4-"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/jedtech/xp_stream/api/XpStreamPlatform.java` | `` |  |  |
| top-level / `com/jedtech/xp_stream/fabric/XpStreamFabricMod.java` | `` |  | onInitialize |
| top-level / `com/jedtech/xp_stream/mixin/ExperienceOrbEntityMixin.java` | `value={ExperienceOrb.class})` | Inject:1 | xp_stream$burstPickup |
| top-level / `com/jedtech/xp_stream/XpStreamConfig.java` | `` |  | get, load, saveDefault, validate, log, getMaxBurstOrbs, isDebug |
| top-level / `com/jedtech/xp_stream/XpStreamConstants.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
