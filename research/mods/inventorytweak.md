# InventoryTweak

Review status: **Evidence inventory; behavioral review pending**

Project: [InventoryTweak](https://modrinth.com/mod/inventorytweak)
Selected artifact version: `4.2`
Published implementation source: https://github.com/anviaan/InventoryTweak
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Fast and easy inventory sorter

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `65ae22637c4cb808e92c5c0f2a4972d2f4c5e51c`
- `sha512`: `3c60b5fe45242cde64dafd61bd76c1526e1d8613e75d812021eda42399835c2dbc9610d626675094e091a9818b05ad7904a5139ed3ffda650b7c08fca5aac376`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 14
Reconstructed Java files: 12

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "net.anvian.inventorytweaks.FabricClient"
  ],
  "modmenu": [
    "net.anvian.inventorytweaks.config.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "~26.3",
  "java": ">=25",
  "cloth-config": ">=26.3.159",
  "anvianslib": ">=1.5.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/anvian/inventorytweaks/config/ModConfig.java` | `` |  |  |
| top-level / `net/anvian/inventorytweaks/config/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `net/anvian/inventorytweaks/FabricClient.java` | `` |  | onInitializeClient |
| top-level / `net/anvian/inventorytweaks/features/durability_warning/DurabilityWarning.java` | `` |  | onStartTick, getDurabilityPercentage, buildWarningMessage |
| top-level / `net/anvian/inventorytweaks/features/sort/SortInventory.java` | `` |  | sortPlayerInventory, sortContainerInventory, cursorCleared, mergeItemStacks, sortItemStacks, getSortedSlots, clearCursor |
| top-level / `net/anvian/inventorytweaks/handler/Interaction.java` | `` |  | getCursorStack, hasEmptyCursor, clickStack, swapStacks, getSyncId |
| top-level / `net/anvian/inventorytweaks/handler/ModKeyBinding.java` | `` |  |  |
| top-level / `net/anvian/inventorytweaks/InventoryTweak.java` | `` |  | init |
| top-level / `net/anvian/inventorytweaks/mixin/MixinKeyInputHandler.java` | `value={AbstractContainerScreen.class})` | Inject:2 | onKeyPressed, onMouseClicked, inventoryTweakSortingKeyPressed |
| top-level / `net/anvian/inventorytweaks/slots/ContainerSlots.java` | `` |  | get |
| top-level / `net/anvian/inventorytweaks/slots/InventorySlots.java` | `` |  | getLastSlot, excludeOffhand |
| top-level / `net/anvian/inventorytweaks/slots/PlayerSlots.java` | `` |  | get |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
