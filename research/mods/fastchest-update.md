# FastChest Update

Review status: **Behavioral static review**

Project: [FastChest Update](https://modrinth.com/mod/fastchest-update)
Selected artifact version: `1.10+26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Unofficial port of FastChest to Minecraft 26.1-26.3 Replaces 3D chest renderers with static block models for improved FPS. Original mod by Domi.

Este mod hace que los cofres utilicen modelos de bloques estáticos para un mejor rendimiento.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `af66ed1b2835077fbbbb3a85eadf8fefae9359a7`
- `sha512`: `d58e7a7f229cc2c238db037931de343b06d185d3c1b06b373ee01d3e493e988e7a3042bf13d7bffc0a4ca66cd606d639d45427837542fac8dd04575ab6cb6ce1`

## Reviewed mechanism

All eight reconstructed Java classes reviewed; resource model appearance still requires resource/visual review.

- For enabled chest categories, returns null from block-entity render-state extraction, suppressing the dynamic chest renderer.
- Mixin methods provide a block render shape via the superclass so static block models can render instead. Disabled categories return INVISIBLE so their dynamic renderer remains the intended path.
- Configuration exposes normal, trapped, ender, and copper chest switches. Closing the config screen triggers a full level render rebuild.

## Lifecycle, correctness, and failure questions

- Static models replace animated geometry, including opening lids, so image/animation behavior changes. Resource models and texture variants determine the substitute appearance.
- Per-category toggles must pair block-model and dynamic-renderer paths correctly or chests can disappear/double-render. High-priority render-shape overrides can overlap other mods.

## Checks needed to establish equivalence

- Check opening/closing, double chests, copper variants, seasonal textures, category toggles, resource reload, and chunk rebuilds.

## Relevance to AstFPS

Reduces dynamic-rendering work through static visual replacement; excluded from unchanged visuals.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 8
Reconstructed Java files: 8

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "modmenu": [
    "re.domi.fastchest.config.ModMenuImpl"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.0",
  "fabric-api": "*",
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `re/domi/fastchest/config/Config.java` | `` |  | read |
| top-level / `re/domi/fastchest/config/ConfigScreen.java` | `` |  | init, applyAndClose, onClose, extractRenderState |
| top-level / `re/domi/fastchest/config/ModMenuImpl.java` | `` |  | getModConfigScreenFactory |
| top-level / `re/domi/fastchest/mixin/BlockEntityRenderManagerMixin.java` | `value={BlockEntityRenderDispatcher.class})` | Inject:1 | removeBlockEntityRenderer |
| top-level / `re/domi/fastchest/mixin/ChestBlockMixin.java` | `value={ChestBlock.class}, priority=1500)` | Inject:1 | getRenderShape, replaceRenderType |
| top-level / `re/domi/fastchest/mixin/CopperChestBlockMixin.java` | `value={CopperChestBlock.class}, priority=1500)` |  | getRenderShape |
| top-level / `re/domi/fastchest/mixin/EnderChestBlockMixin.java` | `value={EnderChestBlock.class}, priority=1500)` | Inject:1 | getRenderShape, replaceRenderType |
| top-level / `re/domi/fastchest/mixin/TrappedChestBlockMixin.java` | `value={TrappedChestBlock.class}, priority=1500)` |  | getRenderShape |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
