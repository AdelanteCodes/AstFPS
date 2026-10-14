# Lower Shelves

Review status: **Evidence inventory; behavioral review pending**

Project: [Lower Shelves](https://modrinth.com/mod/lower-shelves)
Selected artifact version: `1.0.7`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Right Click a Shelf and it lower's its items to the bottom.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha1`: `79590bf37a34dfbdef1c118aefd6e2cb677865b9`
- `sha512`: `a478d410b457cd33ed7c4fcb88625dda510b3e64fff2a042037ebe132c986309ee31fc54943a51d3b14e67a72e9e0b7ca9aef6b98724df54fc813be7b391a5c0`

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
  "client": [
    "com.spider.lower_shelf.client.Lower_shelfClient"
  ],
  "main": [
    "com.spider.lower_shelf.Lower_shelf"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "26.x"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/spider/lower_shelf/client/Lower_shelfClient.java` | `` |  | onInitializeClient |
| top-level / `com/spider/lower_shelf/Lower_shelf.java` | `` |  | onInitialize |
| top-level / `com/spider/lower_shelf/ShelfToggleHandler.java` | `` |  | register |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
