# Escape from the Void with Totem of Undying

Review status: **Evidence inventory; behavioral review pending**

Project: [Escape from the Void with Totem of Undying](https://modrinth.com/mod/escape-from-the-void-with-totem-of-undying)
Selected artifact version: `1.07`
Published implementation source: https://github.com/silvicky/tou-void
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This data pack can save you when you fall into the void.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `31d853a6f79c75f028334186549e26bde26ab5a9968772bc8f590716855cc2e02d3279afdd91f7f8a832affbcb3168cf447e5fd82a137d7e1698bf98aa8348f4`
- `sha1`: `edbda45c5a5c79c22cf123ca316eae62e537e43d`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 1
Reconstructed Java files: 1

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "io.silvicky.tou.Tou"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.15.11",
  "minecraft": ">=26.1",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/silvicky/tou/Tou.java` | `` |  | onInitialize, hasTotem, isOutOfWorld |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
