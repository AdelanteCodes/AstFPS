# Enttick

Review status: **Evidence inventory; behavioral review pending**

Project: [Enttick](https://modrinth.com/mod/enttick)
Selected artifact version: `0.2.0`
Published implementation source: https://github.com/cintlep/Enttick
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Restores pre 1.14s responsive entity impulse by reordering the entity tracker tick. Fixes MC-297196.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `48015edea46d89a9f86db15de8d0d72a35d01bf6`
- `sha512`: `bf5ab291b5971900a3788bb38b605081c24cc1bf7f99930ea6338ec852e38fea027815e9aa8fed8aa3596b3a890cb1c793a42e98a14d7f4499a36dfd97b1998c`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 4
Reconstructed Java files: 4

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "cintlex.enttick.Enttick"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.17",
  "minecraft": ">=26.1"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `cintlex/enttick/Enttick.java` | `` |  | onInitialize |
| top-level / `cintlex/enttick/mixin/AllowMeToInvokeThisTick.java` | `value={ChunkMap.class})` | Invoker:1 |  |
| top-level / `cintlex/enttick/mixin/DontTickHere.java` | `value={ServerChunkCache.class})` | WrapOperation:1 | enttick$cancel |
| top-level / `cintlex/enttick/mixin/TickHere.java` | `value={ServerLevel.class})` | Inject:1 | enttick$tickchunkmap |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
