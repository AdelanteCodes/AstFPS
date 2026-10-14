# NoPackCompatCheck

Review status: **Evidence inventory; behavioral review pending**

Project: [NoPackCompatCheck](https://modrinth.com/mod/nopackcompatcheck)
Selected artifact version: `v0.1.1-fabric-mc26.1+`
Published implementation source: https://github.com/Wudji/NoPackCompatCheck
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Disables the “incompatible” warning when loading resource packs with different compact versions.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `a797f976aecc556f06953606e729ae263fa8b509`
- `sha512`: `42cffcc506703379f0b15369e676c1c3a4b629f2db3e349909bfccd1eca4813f490d70d32225e07f07b33aaf69a8427f8dce25f8ef399719dcf825d0e1f109bc`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

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
  "main": [
    "com.wudji.nopackcompatcheck.Nopackcompatcheck"
  ]
}
```

**depends**

```json
{
  "minecraft": ">=26.1"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/wudji/nopackcompatcheck/mixin/client/MixinResourcePackCompatibility.java` | `value={PackCompatibility.class})` | ModifyReturnValue:1 | alwaysCompatible |
| top-level / `com/wudji/nopackcompatcheck/Nopackcompatcheck.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
