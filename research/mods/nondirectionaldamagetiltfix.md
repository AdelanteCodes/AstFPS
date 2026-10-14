# Nondirectional Damage Tilt Fix

Review status: **Evidence inventory; behavioral review pending**

Project: [Nondirectional Damage Tilt Fix](https://modrinth.com/mod/nondirectionaldamagetiltfix)
Selected artifact version: `3.0.0`
Published implementation source: https://github.com/cintlep/Damage-Tilt-Fixes
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Restores a missing check in modern damage tilt code for indirect sources of damage. Fixes MC-259212

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `d9eb866131e5bc361530cded06b3dc92f9e66b55fb92046c3bcfb261dd2b9e31895810a55b5f62e74903ed8e62af2aee7d53b4506f420c375745f9fa0829f26b`
- `sha1`: `924fe1a29f2902dc368e8ea6611a51fd5d804383`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 2
Reconstructed Java files: 2

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "cintlex.nondirectionaldamagetiltfix.NondirectionalDamageTiltFix"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.17.0",
  "minecraft": ">=26.1",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `cintlex/nondirectionaldamagetiltfix/mixin/tiltmixinB.java` | `value={Camera.class})` | WrapOperation:1 | ndtf$nondirectionaltilt, directionaltilt |
| top-level / `cintlex/nondirectionaldamagetiltfix/NondirectionalDamageTiltFix.java` | `` |  | onInitializeClient |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
