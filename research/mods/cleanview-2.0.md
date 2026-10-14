# Clean View

Review status: **Evidence inventory; behavioral review pending**

Project: [Clean View](https://modrinth.com/mod/cleanview-2.0)
Selected artifact version: `1.0.9`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Tired of particles covering your screen? CleanView makes your Minecraft view clean and clear — no more potion swirls or crumbs in your face!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `b4fa13ee5492521bc255452363ba33cb200ee821`
- `sha512`: `4d08399f3fcb0b1cec85ce67a46d332f973d2134f667c8abb558155c1c09e1baaec8914057164e09222f4128e766d57b444141b82c657e3044a80bd33caa9393`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 6
Reconstructed Java files: 6

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "notzeox.cleanview.CleanView"
  ],
  "modmenu": [
    "notzeox.cleanview.CleanViewModMenuEntry"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3 <26.4",
  "java": ">=25",
  "cloth-config": "*",
  "modmenu": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `notzeox/cleanview/CleanView.java` | `` |  | onInitializeClient, isEnabled, setEnabled |
| top-level / `notzeox/cleanview/CleanViewConfigScreen.java` | `` |  | build |
| top-level / `notzeox/cleanview/CleanViewModMenuEntry.java` | `` |  | getModConfigScreenFactory |
| top-level / `notzeox/cleanview/config/CleanViewConfig.java` | `` |  | load, save, clamp, getInt, getBoolean |
| top-level / `notzeox/cleanview/mixin/ParticleManagerMixin.java` | `value={ParticleEngine.class})` | Inject:1 | cleanview_filterParticles, shouldFilterStatusEffectParticle, isWithinFilterDistance, shouldFilterParticle, getKeepChance |
| top-level / `notzeox/cleanview/mixin/ParticleOpacityMixin.java` | `value={SingleQuadParticle.class})` | ModifyArgs:2 | cleanview_applyParticleOpacityModern, cleanview_applyParticleOpacityLegacy, applyParticleOpacity, isWithinOpacityDistance |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
