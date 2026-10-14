# macOS Chat Fixes

Review status: **Evidence inventory; behavioral review pending**

Project: [macOS Chat Fixes](https://modrinth.com/mod/macos-chat-fixes)
Selected artifact version: `1.0.1`
Published implementation source: https://github.com/pe3ep/macos-chat-fixes
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Fixes Minecraft's text fields to use native macOS keyboard shortcuts, i.e. ⌘+Arrow jumps to line start/end, ⌥+Arrow jumps by word, etc.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `e12a77da29667c3a86791d9c65f5268db2e335faedf44e8535ca90557479de704331b1cacae103c85a0e01cea3cd38c0b0bbc6e089cca9488e5128902f6f7428`
- `sha1`: `d01cc514f3b9cb57e0308538ae80566137c5e242`

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
  "main": [
    "cc.pe3epwithyou.macosChatFixes.MacosChatFixes"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `cc/pe3epwithyou/macosChatFixes/MacosChatFixes.java` | `` |  | getInstance, onInitialize, isMac |
| top-level / `cc/pe3epwithyou/macosChatFixes/mixins/EditBoxMixin.java` | `value={EditBox.class})` | Inject:1 | isWordChar, isPlainWordChar, isEditable, macosChatFixes$onKeyPressed, macWordPosition |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
