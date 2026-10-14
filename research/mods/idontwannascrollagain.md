# I DON'T WANNA SCROLL AGAIN!

Review status: **Evidence inventory; behavioral review pending**

Project: [I DON'T WANNA SCROLL AGAIN!](https://modrinth.com/mod/idontwannascrollagain)
Selected artifact version: `1.0.0+26.3`
Published implementation source: https://github.com/TheVoidBlock/IDONTWANNASCROLLAGAIN/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Stop Minecraft from resetting your scrollbar when you refresh your server list

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `593bce4c893f54e967eb3cf81951d1d44d9dee0ee2bf3653945aff1427de177c6476b56c2f4c978f875490f6a93f9b7eabffd68b35bdcdee9152ecbe64926700`
- `sha1`: `0f6ef9fc2f448f8f0b653b5f76a6a549f7581e18`

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
| top-level / `io/github/thevoidblock/idontwannascrollagain/mixin/JoinMultiplayerScreenAccessor.java` | `value={JoinMultiplayerScreen.class})` | Accessor:1 |  |
| top-level / `io/github/thevoidblock/idontwannascrollagain/mixin/JoinMultiplayerScreenMixin.java` | `value={JoinMultiplayerScreen.class})` | Inject:1 |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
