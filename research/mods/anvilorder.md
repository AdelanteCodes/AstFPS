# AnvilOrder

Review status: **Evidence inventory; behavioral review pending**

Project: [AnvilOrder](https://modrinth.com/mod/anvilorder)
Selected artifact version: `26.3`
Published implementation source: https://github.com/DUzzL/AnvilOrder
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This mod adds IAmCal's Enchantment Ordering tool directly into the anvil interface ingame. Huge thank you to him, this project would not have been possible without his work.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `6a5fb52fdb263d7192210ba856b81f370afc04f20e0004624d74bc04d9a7e9913108c4622dde12cdce6a92e08f4d57aa8228a65d2f3a5d84eceaee2a0958cab3`
- `sha1`: `785646717a46becea9016bab60e0414a6d121b59`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 15
Reconstructed Java files: 12

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.anvilorder.client.AnvilOrderClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "26.3",
  "fabric-api": ">=0.160.5",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/anvilorder/client/AnvilOrderClient.java` | `` |  | onInitializeClient |
| top-level / `com/anvilorder/client/mixin/AnvilScreenMixin.java` | `value={AnvilScreen.class})` | Inject:5 | applySplitLayout, anvilorder$subInit, anvilorder$resize, anvilorder$tick, syncPanelPosition, updateButtonState, anvilorder$extractBackgroundHead, anvilorder$extractBackground, mouseScrolled, mouseClicked, mouseDragged, mouseReleased, onClose |
| top-level / `com/anvilorder/client/screen/AnvilGuidePanel.java` | `` |  | setResult, clear, isVisible, totalContentH, maxTextW, contentTop, contentBottom, visibleH, maxScrollY, maxScrollX, render, mouseScrolled, mouseClicked, dragH, mouseReleased, mouseDragged |
| top-level / `com/anvilorder/client/screen/EnchantmentSelectScreen.java` | `` |  | init, buildWidgets, updateSlotPositions, extractRenderState, hasSelectedConflict, mouseScrolled, mouseClicked, mouseReleased, mouseDragged, runCalc, onClose, updateMessage, applyValue |
| top-level / `com/anvilorder/client/screen/IncompatibleEnchantmentsScreen.java` | `` |  | init, extractRenderState, onClose |
| top-level / `com/anvilorder/client/screen/ResultHolder.java` | `` |  | setResult, clear |
| top-level / `com/anvilorder/data/EnchantmentData.java` | `` |  | initWeights, initIncompatibilities, addConflictPair, addConflictGroup, initItemEnchants, addItemEnchants, ensureKeysInitialized, getWeight, getWeight, getMaxLevel, getIncompatible, areCompatible, getEnchantmentsForItem, getEnchantKey, getEnchantEntry, getAllEnchantPaths, getSimpleItemName |
| top-level / `com/anvilorder/solver/CombineNode.java` | `` |  |  |
| top-level / `com/anvilorder/solver/CombineStep.java` | `` |  |  |
| top-level / `com/anvilorder/solver/EnchantmentSolver.java` | `` |  | solve, mergeOrNull, singleStepResult, hashItemList, cheapestItemsFromList, cheapestItemFromItems2, cheapestItemsFromListN, cheapestItemsFromTwoDictionaries, compareCheapest, removeExpensiveCandidates, extractInstructions, extractInstructionsRecursive, relabelLeaf, describeNode, findItemType, collectLeafLabels, formatEnchantDisplayName, calculateNaiveCost, EnchantInput |
| top-level / `com/anvilorder/solver/SolverResult.java` | `` |  | empty |
| top-level / `com/anvilorder/solver/VirtualItem.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
