# Deobfuscator

Review status: **Evidence inventory; behavioral review pending**

Project: [Deobfuscator](https://modrinth.com/mod/deobfuscator)
Selected artifact version: `1.0.0+26.3`
Published implementation source: https://github.com/TheVoidBlock/Deobfuscator
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Deobfuscate obfuscated/magic text. Reveals hidden players on servers such as the DonutSMP.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `45499fe14c4abf0f4459d43b5ea52538da5300e805aef69e6fa3b74d7e0a3a495cbc429cbef590c4d0cf2de3bf114f983562dde7f59ac239e563f0d2392ddc71`
- `sha1`: `d836da288a5713589b694074f7008c086a85b539`

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
  "client": [
    "io.github.thevoidblock.deobfuscator.Deobfuscator"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/github/thevoidblock/deobfuscator/Deobfuscator.java` | `` |  | onInitializeClient, styleBoolean |
| top-level / `io/github/thevoidblock/deobfuscator/mixin/StyleMixin.java` | `value={Style.class})` | ModifyReturnValue:1 |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
