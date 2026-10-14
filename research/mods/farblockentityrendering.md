# Far Block Entity Rendering

Review status: **Evidence inventory; behavioral review pending**

Project: [Far Block Entity Rendering](https://modrinth.com/mod/farblockentityrendering)
Selected artifact version: `2.1+26.3`
Published implementation source: https://github.com/IlyRac/FarBlockEntityRendering
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Extends block entity render distance beyond the default 64-block limit

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `49e4d7f3568848eaf6142839da77a3056901742780b81a7dd1b4ff93138db65490e9c13f22efb3bb2b9afc10685b8f34ef5a04574f3527f5e1831d24d9a98722`
- `sha1`: `d663e8a43c13a01eb1887a684d208a8558f7b790`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 8
Reconstructed Java files: 6

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.ilyrac.farblockentityrendering.FarBlockEntityRendering"
  ],
  "client": [
    "com.ilyrac.farblockentityrendering.client.FarBlockEntityRenderingClient"
  ],
  "modmenu": [
    "com.ilyrac.farblockentityrendering.client.integration.ModMenuIntegration"
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
| top-level / `com/ilyrac/farblockentityrendering/client/config/ConfigManager.java` | `` |  | loadConfig, getConfig, getBlockEntityRenderDistance, getBlockEntityRenderDistanceSquared, setRenderDistanceChunks, refreshRenderers |
| top-level / `com/ilyrac/farblockentityrendering/client/config/SimpleConfig.java` | `` |  | load, save, getRenderDistanceBlocks |
| top-level / `com/ilyrac/farblockentityrendering/client/FarBlockEntityRenderingClient.java` | `` |  | onInitializeClient |
| top-level / `com/ilyrac/farblockentityrendering/client/integration/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory, init, extractRenderState, updateMessage, applyValue, getValue, setSliderValue |
| top-level / `com/ilyrac/farblockentityrendering/client/mixin/BlockEntityRendererMixin.java` | `value={BlockEntityRenderer.class})` | Overwrite:1 |  |
| top-level / `com/ilyrac/farblockentityrendering/FarBlockEntityRendering.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
