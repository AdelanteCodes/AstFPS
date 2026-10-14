# Environmental Fog Disable

Review status: **Evidence inventory; behavioral review pending**

Project: [Environmental Fog Disable](https://modrinth.com/mod/environmental-fog-disable)
Selected artifact version: `1.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Disable the environmental fog introduced in 1.21.6 via a toggleable setting.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `5c8d5a238b0288d58b7375a78c8972bc8335b765c0e6892253364eba2ec3fe95be5a498d3c5a3be0b096d7dcb52e1603e4cabcbde8471c1f8bfc9deb4411ae85`
- `sha1`: `c4487b08748effe98423c2868b2df43d4c55f1bc`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 5
Reconstructed Java files: 4

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.tyler.envfogdisable.EnvFogDisableMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "fabric-api": "*",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/tyler/envfogdisable/ConfigManager.java` | `` |  | isFogEnabled, setFogEnabled, toggle, load, save |
| top-level / `com/tyler/envfogdisable/EnvFogDisableMod.java` | `` |  | onInitializeClient, isFogEnabled, getFogOption |
| top-level / `com/tyler/envfogdisable/mixin/FogRendererMixin.java` | `value={FogRenderer.class})` | Accessor:2 | setFogEnabled, isFogEnabled |
| top-level / `com/tyler/envfogdisable/mixin/VideoOptionsScreenMixin.java` | `value={VideoSettingsScreen.class})` | Inject:1 | addEnvironmentalFogOption |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
