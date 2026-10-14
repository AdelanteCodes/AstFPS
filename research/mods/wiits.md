# WhatIsInThatShelf

Review status: **Evidence inventory; behavioral review pending**

Project: [WhatIsInThatShelf](https://modrinth.com/mod/wiits)
Selected artifact version: `1.0.1`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

See exactly what's on display! A Quality of Life HUD mod that shows you the tooltip of any item inside a shelf block just by looking at it

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `e6537f1c701e950937138dc5f8464d52d1ad07f5baadd71dabb7671ce99f78fcfcc5483bca1821cc91985f25109352225332db6f68f8a481a9bc63b155e36c38`
- `sha1`: `aa98468d67961b18a31b37dada5e4ac92b4be8a6`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 15
Reconstructed Java files: 7

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "me.andy.whatisinthatshelf.Whatisinthatshelf"
  ],
  "client": [
    "me.andy.whatisinthatshelf.client.WhatisinthatshelfClient"
  ],
  "fabric-datagen": [
    "me.andy.whatisinthatshelf.client.WhatisinthatshelfDataGenerator"
  ]
}
```

**depends**

```json
{
  "fabricloader": "*",
  "fabric-api": "*",
  "minecraft": ">=26.3 <=26.3.5"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/andy/whatisinthatshelf/client/compat/WiitsWthitPlugin.java` | `` |  | register, onBeforeTooltipRender, getHoveredItemModName |
| top-level / `me/andy/whatisinthatshelf/client/gui/WhatisinthatshelfSettingsScreen.java` | `` |  | panelHeight, init, extractRenderState, extractBackground, openConfigFolder, addPair, addToggle, toggleText, addCycle, shortAmtPos, onClose, isPauseScreen, updateMessage, applyValue, toScale, updateMessage, applyValue, toSpacing |
| top-level / `me/andy/whatisinthatshelf/client/WhatisinthatshelfClient.java` | `` |  | onInitializeClient, onHudRender, renderLogic, getBaseX, buildComponents, isVanillaModNameLine, isAdvancedOnlyLine, recolor, resolveModName, applyAmountLogic, buildAmountText, readDrawerSlotAmount, isInventoryLikeScreen |
| top-level / `me/andy/whatisinthatshelf/client/WhatisinthatshelfDataGenerator.java` | `` |  | onInitializeDataGenerator |
| top-level / `me/andy/whatisinthatshelf/compat/WiitsWthitCommonPlugin.java` | `` |  | register |
| top-level / `me/andy/whatisinthatshelf/Whatisinthatshelf.java` | `` |  | onInitialize |
| top-level / `me/andy/whatisinthatshelf/WhatisinthatshelfConfig.java` | `` |  | cyclePosition, cycleAmountPosition, save, load, resolveColorPrefix |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
