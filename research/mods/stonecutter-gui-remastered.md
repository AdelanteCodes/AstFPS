# Stonecutter GUI Remastered

Review status: **Evidence inventory; behavioral review pending**

Project: [Stonecutter GUI Remastered](https://modrinth.com/mod/stonecutter-gui-remastered)
Selected artifact version: `2.1.1-1.26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Changes the Stonecutter GUI to a more clear GUI with enlarged Icons and automatic refill

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `d9d47a6257247733bd2328147390217401673b88d2559cc1db721d7f71a37f7e7226d8e22e1f18f728c6e36fcd85004b27804fecfe737b9a5eac203903f3db9f`
- `sha1`: `44a3fabfe32ce1d8fe468d4fc8a7749764bab930`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 8
Reconstructed Java files: 8

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "net.a5ho9999.StonecutterRemasteredMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

**accessWidener**

```json
"stonecutter-remastered.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/a5ho9999/mixin/item/DrawContextMixin.java` | `value={GuiGraphicsExtractor.class})` |  | stonecutter_remastered$setRenderSize |
| top-level / `net/a5ho9999/mixin/screen/AbstractContainerScreenAccessor.java` | `value={AbstractContainerScreen.class})` | Accessor:2 |  |
| top-level / `net/a5ho9999/mixin/screen/StonecutterScreenHandlerMixin.java` | `value={StonecutterMenu.class})` | ModifyConstant:1, Redirect:1, Inject:3 | remastered$refill, remastered$bulk, remastered$overrideOutputSlotLocation, remastered$overridePlayerInventoryLocation, remaster$onContentChanged, remaster$onButtonClick, remastered$quickMove, quickMove_v2 |
| top-level / `net/a5ho9999/mixin/screen/StonecutterScreenMixin.java` | `value={StonecutterScreen.class})` | Inject:6 | StonecutterScreen, drawBackground, drawMouseoverTooltip, mouseClicked, mouseDragged, mouseScrolled, renderRecipeBackground, renderRecipeIcons, shouldScroll, getMaxScroll, setRefill, setBulk |
| top-level / `net/a5ho9999/StonecutterRemasteredMod.java` | `` |  | onInitialize, OnLog |
| top-level / `net/a5ho9999/util/DrawContextAccess.java` | `` |  |  |
| top-level / `net/a5ho9999/util/StonecutterRefillAccess.java` | `` |  |  |
| top-level / `net/a5ho9999/util/StonecutterUtil.java` | `` |  | quickRefill |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
