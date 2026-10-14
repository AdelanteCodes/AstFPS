# Item Name Gradients

Review status: **Evidence inventory; behavioral review pending**

Project: [Item Name Gradients](https://modrinth.com/mod/item-name-gradients)
Selected artifact version: `1.0.2`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Style item names with gradients based on rarity or custom settings.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `ea5fecbfe95730062550aeda9e4bb9f4f3ef98fa00a878ac31a0c436feb9b9e90266967b403e26e57687097f6d6d8edb1edbb688e6fcc089e9c0fd09aadc82ca`
- `sha1`: `98b1cb0e18928d3951ffd156416a4e875b2e6b03`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 15
Reconstructed Java files: 9

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.thenev.ItemNames"
  ],
  "client": [
    "com.thenev.client.ItemNamesClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.2",
  "minecraft": "~26.3-",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/thenev/client/GradientConfig.java` | `` |  | parsePalette |
| top-level / `com/thenev/client/GradientItemNameRegistry.java` | `` |  | getStyledName, getPaletteOptions, getPaletteFor, getPaletteFor, getPaletteFor, setPaletteFor, setPaletteFor, clearPaletteFor, hasItemOverride, getItemKey, getItemSearchName, getDefaultPalette, samplePaletteColor, getPreviewComponent, getPreviewComponent, getRarityLabel, sanitize, titleCase, applyGradient, displayName, smooth, blend, lerp |
| top-level / `com/thenev/client/GradientRarityMenuScreen.java` | `` |  | onClose, removed, capturesInput, isPauseScreen, setFocusedField, isAnyFieldFocused, updateTextInputArea, mouseClicked, mouseDragged, mouseReleased, mouseScrolled, charTyped, keyPressed, renderBackground, render, drawWindow, drawHeader, drawMainArea, drawSideArea, drawPreviewCard, drawPaletteSection, drawPaletteCard, drawListRow, drawField, drawTabs, drawTab, drawButton, drawPanel, drawScrollbar, renderPreviewSwatch, applyPalette, switchMode, rememberSessionState, restoreSessionState, hasSelection, ensureSelection, clearSelection, selectEntry, moveSelection, revealSelection, revealActivePalette, activePaletteIndex, selectedEntryIndex, currentPalette, currentEntries, filteredItems, buildItemEntries, headerMeta, sideTitle, sideSubtitle, previewTitle, previewSubtitle, previewDisplayName, friendlyRarityTitle, maxListScroll, maxPaletteRowScroll, paletteTotalRows, scrollFromClick, scrollbarThumbHeight, scrollbarThumbY, isSearchCharacter, contains, clamp, ellipsize, panelLeft, panelTop, layoutScale, virtualScreenWidth, virtualScreenHeight, virtualMouseX, virtualMouseY, headerButtonY, tabsX, tabsY, tabWidth, doneButtonX, previewFieldX, previewFieldY, previewFieldWidth, previewSwatchX, previewSwatchY, previewSwatchWidth, resetButtonX, resetButtonY, paletteGridX, paletteGridY, paletteGridWidth, paletteAvailableHeight, paletteVisibleRows, paletteGridHeight, paletteScrollbarX, paletteScrollbarY, paletteScrollbarHeight, searchFieldX, searchFieldY, searchFieldWidth, listX, listWidth, listStartY, listAvailableHeight, visibleListRows, listScrollbarX, listScrollbarY, listScrollbarHeight, ListEntry, ItemEntry |
| top-level / `com/thenev/client/ItemNamesClient.java` | `` |  | onInitializeClient, getCurrentScreen |
| top-level / `com/thenev/client/LegacyScreen.java` | `` |  | extractBackground, extractRenderState, renderBackground, render |
| top-level / `com/thenev/client/mixin/ItemStackNameGradientMixin.java` | `value={ItemStack.class})` | Inject:2 | happyGhast$applyGradientHoverName, happyGhast$applyGradientName |
| top-level / `com/thenev/ItemNames.java` | `` |  | onInitialize |
| top-level / `com/thenev/mixin/ExampleMixin.java` | `value={MinecraftServer.class})` | Inject:1 | init |
| top-level / `net/minecraft/client/gui/GuiGraphics.java` | `` |  | pose, fill, fillGradient, drawString, drawString, drawString, drawString, drawCenteredString, drawCenteredString, drawString, drawString, renderItem, renderItem, renderItemDecorations, renderItemDecorations, blit, blit, blit, blit, blit, blitSprite, blitSprite, blitSprite, setTooltipForNextFrame, setTooltipForNextFrame, setPreeditOverlay, getSprite |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
