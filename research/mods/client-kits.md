# Client Kits

Review status: **Evidence inventory; behavioral review pending**

Project: [Client Kits](https://modrinth.com/mod/client-kits)
Selected artifact version: `2.1.0+26.3`
Published implementation source: https://github.com/Walksy/ClientKits
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Store and load custom kits

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `b6614e01ef36a407cab4f2e563cef6b88c63d544`
- `sha512`: `6e2e5a896fd63493313c70116094bfaf1e5aecef3c2843ba25ac632fbcfd1660657c43163f77cf82f8f79cd46fc50c309c149e5773c62b08ba88869af97a958b`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 25
Reconstructed Java files: 15

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "walksy.clientkits.ClientKits"
  ],
  "walksylib": [
    "walksy.clientkits.config.ClientKitsConfig"
  ]
}
```

**depends**

```json
{
  "minecraft": "26.3",
  "java": ">=25",
  "fabric-api": "*",
  "walksylib": ">=2.0.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `walksy/clientkits/ClientKits.java` | `` |  | onInitializeClient |
| top-level / `walksy/clientkits/config/ClientKitsConfig.java` | `` |  | config, save, kitNames, hasKit, kit, keybindFor, putKit, removeKit, enderKitNames, hasEnderKit, enderKit, putEnderKit, uniqueKitName, uniqueEnderKitName, uniqueName, freeEnderKitName, removeEnderKit, renameKeybind, autoCreative, glassEnderButtons, define |
| top-level / `walksy/clientkits/kit/command/ClientKitCommands.java` | `` |  | literal, argument, create, save, load, delete, preview, result, saveEnder, loadEnder, deleteEnder, listEnder, list, openConfig, sendMsg, sendMsg, prefix |
| top-level / `walksy/clientkits/kit/EnderChests.java` | `` |  | kitSlot, isEnderChestScreen, menuOf, isEnderChestTitle, openMenu, capture, stackAt, filledCount, filledCount |
| top-level / `walksy/clientkits/kit/KitCodes.java` | `` |  | copyToClipboard, readClipboard, encode, decode, isBase64, deflate, inflate, byId, Decoded |
| top-level / `walksy/clientkits/kit/LegacyKits.java` | `` |  | migrate, read, toLocalSlot, parseByte, topLevelValue, elements, endOfValue, endOfQuoted, skipSpace, unquote |
| top-level / `walksy/clientkits/manager/KitManager.java` | `` |  | saveKit, copyKit, pasteKit, loadKit, saveEnderKit, replaceEnderKit, captureEnderKit, loadEnderKit, report, beginCreativeSwitch, tick, checkKeybinds, applyKit, applyEnderKit, stage, previewInventory, reset |
| top-level / `walksy/clientkits/manager/PreviewInventory.java` | `` |  | of, model |
| top-level / `walksy/clientkits/mixin/AbstractContainerScreenMixin.java` | `value={AbstractContainerScreen.class})` | Inject:9 | clientkits$init, clientkits$removed, clientkits$extract, clientkits$suppressTooltip, clientkits$mouseClicked, clientkits$mouseReleased, clientkits$mouseDragged, clientkits$mouseScrolled, clientkits$keyPressed, charTyped |
| top-level / `walksy/clientkits/screen/EnderChestKitOverlay.java` | `` |  | onInit, onRemoved, retire, of, extract, capturesPointer, mouseClicked, mouseReleased, mouseDragged, mouseScrolled, keyPressed, charTyped, clampX, clampY |
| top-level / `walksy/clientkits/screen/GlassKitControls.java` | `` |  | title, label, secondaryLabel, tertiaryLabel, rowHoverFill, scrollbar, retire, capturesPointer, mouseClicked, mouseReleased, mouseDragged, mouseScrolled, keyPressed, charTyped, buttons, uiScale, layoutButtons, extract, extractButton, approach, openLoadPopover, openSavePopover, open, values, label, itemId, trailing, emptyMessage, values, label, itemId, trailing |
| top-level / `walksy/clientkits/screen/KitControls.java` | `` |  |  |
| top-level / `walksy/clientkits/screen/KitPreviewScreen.java` | `` |  | extractLabels, extractBackground, showsActiveEffects, mouseClicked, mouseDragged, mouseReleased, getRecipeBookButtonPosition, keyPressed |
| top-level / `walksy/clientkits/screen/PopoverButton.java` | `` |  | panelStyle, labelFont, style, layout, layout, widthFor, heightFor, cornerRadius, isArmed, settleInteraction, extract, extractLabel, extractLabel, onClick, onRelease, fire, isLeftMouseDown, approach, clamp |
| top-level / `walksy/clientkits/screen/VanillaKitControls.java` | `` |  | setExpanded, font, buttons, layoutButtons, widthFor, extract, capturesPointer, mouseClicked, mouseReleased, mouseDragged, mouseScrolled, keyPressed, retire, openLoad, openSave, centeredText, clamp, titleHeight, scrollable, layout, rowsTop, scrollBy, isOverPanel, mouseClicked, extract, extractScrollbar, Row |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
