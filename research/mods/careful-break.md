# Careful Break

Review status: **Evidence inventory; behavioral review pending**

Project: [Careful Break](https://modrinth.com/mod/careful-break)
Selected artifact version: `1.3.1`
Published implementation source: https://github.com/yankees88888g/careful-break
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Adds a feature allowing one to sneak and have the drops go directly into their inventory when mining.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `d296c734e82b42c6fe9f5dd1903c043e84146f11`
- `sha512`: `3477c2b5ca4d027f4ff2ff43ae26eff8fac6794127ce25f844293e856649a99028cfea6a53d829433786369a4577d3ce27a42348f16f71d07aa099ac0d056a35`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 3
Reconstructed Java files: 3

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.yankees88888g.Main"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/yankees88888g/FileLoader.java` | `` |  | loadFile, updateFile, getPath |
| top-level / `com/yankees88888g/Main.java` | `` |  | onInitialize |
| top-level / `com/yankees88888g/mixin/BlockBreakMixin.java` | `value={Block.class})` | Redirect:1 | dropStacks |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
