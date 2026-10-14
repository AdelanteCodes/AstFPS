# Hot-Reload Resource Packs Forked

Review status: **Evidence inventory; behavioral review pending**

Project: [Hot-Reload Resource Packs Forked](https://modrinth.com/mod/hot-reload-resource-packs-forked)
Selected artifact version: `1.2.0`
Published implementation source: https://github.com/Alfakynz/hot-reload-resource-packs
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A forked version of Hot-Reload Resource Packs

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `b5580a1c92a64e44985cd118597c3f2064b0804bcd6d3ef94796cf3c3115f54a2383931289181b9cc7f6ddd87cbdd2e762feb01d33dbfc8995222eb61c1f11bb`
- `sha1`: `97374b78d83c08738f989fc24bbb620a66864e3e`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 3
Reconstructed Java files: 2

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "online.carteris.hot_reload_resource_packs.HotReloadResourcePacks"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "minecraft": ">=26.2",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `online/carteris/hot_reload_resource_packs/HotReloader.java` | `` |  | run, preVisitDirectory, isResourcifyScreen |
| top-level / `online/carteris/hot_reload_resource_packs/HotReloadResourcePacks.java` | `` |  | onInitialize, getResourcePacksPath |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
