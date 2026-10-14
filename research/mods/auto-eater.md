# Auto Eater

Review status: **Evidence inventory; behavioral review pending**

Project: [Auto Eater](https://modrinth.com/mod/auto-eater)
Selected artifact version: `1.5.1`
Published implementation source: https://github.com/nicolas-reig/Auto-Eater
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This is a simple client mod to stop worrying about eating all the time, that selects the food and eats it. It detects whenever the foodbar falls a certain threshold, selects food in your hotbar, and starts eating it.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `f24fd5fcc2d3df5c0fad3a42a509dc87b7ff57ba8f0926af6a9901bd5fb2fde2777f587c47defadd1dd94cea745d733410fd8e1c6e383ab01a32ec3c9b14e479`
- `sha1`: `afb110a79eb0cdeeb48828400157b1a798d20a03`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 10
Reconstructed Java files: 4

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.autoeater.AutoEaterClient"
  ],
  "modmenu": [
    "com.autoeater.ModMenuIntegration"
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
| top-level / `com/autoeater/AutoEaterClient.java` | `` |  | onInitializeClient, cancelEating, isEatingCancelled, processToggleKey, getToggleKeyName, getToggleKeyDisplayName, setToggleKey, handleEating, initializePlayerState, cancelForDamage, cancelForScrollAway, cancelForManualAttack, cancelForManualUse, updatePlayerState, getCombinedHealth, getConfiguredCancelTicks, updateThreshold, isLookingAtUsableBlock, isLookingAtEntity, tryAutoEat, findFoodSlot, isFoodCandidate, startEating, swapInventorySlotIntoHotbar, getMenuSlotIndex, restoreInventoryFallbackSwap, stopEating, forceReleaseUseAction, isCancelActive, isConsumableFood |
| top-level / `com/autoeater/AutoEaterConfig.java` | `` |  | isBlacklisted, loadConfig, saveConfig, toData, apply, getToggleKeyDisplayName, takeLegacyToggleKeyName, getLegacyToggleKeyName, legacyAlphaNumericKeyCode, validateBlacklist, parseBlacklist, formatBlacklist, getConfigScreen |
| top-level / `com/autoeater/AutoEaterConfigScreen.java` | `` |  | init, onClose, keyPressed, mouseScrolled, toggleLabel, thresholdLabel, cancelCooldownLabel, inventoryScanLabel, toggleKeyLabel, saveAndClose, addBlacklistEntry, removeSelectedBlacklistEntry, resetBlacklistToDefaults, refreshBlacklistEntries, clampScroll, applyScroll, addScrollableWidget, setScrollableBaseY, relayoutBlacklistSection, getSelectedBlacklistIndex, blacklistLabel, selectBlacklistEntry, extractWidgetRenderState, updateWidgetNarration, updateMessage, applyValue, updateMessage, applyValue |
| top-level / `com/autoeater/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
