# Xaero's Biome Filter

Review status: **Evidence inventory; behavioral review pending**

Project: [Xaero's Biome Filter](https://modrinth.com/mod/xaeros-biome-filter)
Selected artifact version: `1.1.2+26.3`
Published implementation source: https://github.com/deanxbox/Xaero-s-Biome-Filter
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A client-side Fabric mod that adds biome filtering to Xaero's World Map.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `be22b3916b8c0abfc240e0f67902a82b376dfc0b`
- `sha512`: `7f3847f2b35e1f15a5aefd1817a49aa9e2c66b12f3a74837084a4158fdb50be9bfece5ea826c918f82eb142d1738a8b9adfd30de50c02a00f8e1323d177b7876`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 19
Reconstructed Java files: 16

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "deanxbox.xaerosbiomefilter.XaerosBiomeFilterClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3 <26.4",
  "java": ">=25",
  "xaeroworldmap": ">=1.46.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `deanxbox/xaerosbiomefilter/config/BiomeFilterConfig.java` | `` |  | isEnabled, setEnabled, getMode, setMode, getSelectedBiomes, isSelected, setSelected, clearSelectedBiomes |
| top-level / `deanxbox/xaerosbiomefilter/config/BiomeFilterConfigStore.java` | `` |  | load, save, toJson, escapeJsonString, unescapeJsonString |
| top-level / `deanxbox/xaerosbiomefilter/config/BiomeFilterMode.java` | `` |  | next |
| top-level / `deanxbox/xaerosbiomefilter/filter/BiomeFilter.java` | `` |  | allows |
| top-level / `deanxbox/xaerosbiomefilter/filter/ClientBiomeLookup.java` | `` |  | biomeIdAt |
| top-level / `deanxbox/xaerosbiomefilter/mixin/GuiMapBiomeFilterRenderMixin.java` | `value={GuiMap.class}, remap=false)` | Inject:2 | xaerosBiomeFilter$renderFullBiomeOverlay, xaerosBiomeFilter$renderSubRectBiomeOverlay |
| top-level / `deanxbox/xaerosbiomefilter/mixin/GuiMapToolbarMixin.java` | `value={GuiMap.class}, remap=false)` | Inject:1 | xaerosBiomeFilter$addToolbarButton |
| top-level / `deanxbox/xaerosbiomefilter/mixin/MinimapTileColorMixin.java` | `value={MinimapTile.class}, remap=false)` | Inject:1 | xaerosBiomeFilter$blackOutUnselectedBiome |
| top-level / `deanxbox/xaerosbiomefilter/mixin/RegionTextureRenderRegistryMixin.java` | `value={RegionTexture.class}, remap=false)` | Inject:2 | xaerosBiomeFilter$registerRenderedTexture, xaerosBiomeFilter$unregisterDeletedTexture |
| top-level / `deanxbox/xaerosbiomefilter/mixin/XaerosBiomeFilterMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `deanxbox/xaerosbiomefilter/render/BiomeFilterRenderOverlay.java` | `` |  | clearCache, renderFull, renderSubRect, render, getMask, buildMask, isFiltered, isActive, clampTexturePixel, fillBlack, CachedMask, Run |
| top-level / `deanxbox/xaerosbiomefilter/render/BiomeFilterRenderTextureRegistry.java` | `` |  | register, unregister, get |
| top-level / `deanxbox/xaerosbiomefilter/render/MinimapRefresh.java` | `` |  | request |
| top-level / `deanxbox/xaerosbiomefilter/ui/BiomeFilterScreen.java` | `` |  | init, refreshBiomeListButtons, addBiomeListButton, extractRenderState, onClose, isPauseScreen, enabledMessage, modeMessage, selectedViewMessage, biomeMessage, loadBiomeList, rebuildBiomeList, maxPage, BiomeEntry |
| top-level / `deanxbox/xaerosbiomefilter/ui/BiomeNameFormatter.java` | `` |  | displayName, capitalize |
| top-level / `deanxbox/xaerosbiomefilter/XaerosBiomeFilterClient.java` | `` |  | onInitializeClient, config, filter, filterRevision, refreshFilter, saveConfig |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
