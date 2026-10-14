# Log Cleaner Multi Loader

Review status: **Evidence inventory; behavioral review pending**

Project: [Log Cleaner Multi Loader](https://modrinth.com/mod/log-cleaner-multiloader)
Selected artifact version: `2.0.0`
Published implementation source: https://github.com/noramibu/LogCleaner
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A lightweight mod to clean old, unused log files. Forked for adding Forge & 26.1 support

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `e8b171552e28ad99a7727fea16f36bfe000a92bf`
- `sha512`: `b8e4a70706d1b79c7a45e716791cca4c2f52528ce916b55ec058ce4a055b9335786ebfef58896efa8330e2a386dc30a5a7c6297aa02a7f3cb458250a4fbdddce`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 2
Reconstructed Java files: 1

**entrypoints**

```json
{
  "main": [
    "altrisi.mods.logcleaner.LogCleaner::runF"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.12.0",
  "minecraft": ">=1.14"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `altrisi/mods/logcleaner/LogCleaner.java` | `` |  | runF, runQ, run |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
