# veinminer++

Review status: **Evidence inventory; behavioral review pending**

Project: [veinminer++](https://modrinth.com/mod/veinminer-plus-plus)
Selected artifact version: `0.6.0+mc26.3`
Published implementation source: https://github.com/kestalkayden/veinminer-plus-plus
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Vein Miner, Ore Harvester, Shovel Master, Tree Feller. Guided area. All rolled into one nice package!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha512`: `8b8f9e04e3a1e63d55825bc6afec5b0bf8de2f5baad7e5d0ca15656138c7c2fccc88dbf7a75fe62f7a262ba360dccb01c892b9fff40980555af371d6cc70b466`
- `sha1`: `a95612ebbb56dfb85ff9d161049521def366f75d`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 26
Reconstructed Java files: 19

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.kestalkayden.veinminerplusplus.VeinMinerPlusFabric"
  ],
  "client": [
    "com.kestalkayden.veinminerplusplus.VeinMinerPlusFabricClient"
  ],
  "modmenu": [
    "com.kestalkayden.veinminerplusplus.client.VeinMinerPlusModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": ">=26.3 <26.4",
  "java": ">=25"
}
```

**accessWidener**

```json
"veinminerplusplus.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/kestalkayden/veinminerplusplus/client/IrisCompat.java` | `` |  | assignToLinesProgram |
| top-level / `com/kestalkayden/veinminerplusplus/client/ShapeGuideRenderer.java` | `` |  | render |
| top-level / `com/kestalkayden/veinminerplusplus/client/VeinMinerPlusConfigScreen.java` | `` |  | init, repositionElements, onClose, removed, getRowWidth, populateEntries, addHeader, addOption, extractContent, children, narratables, extractContent, children, narratables |
| top-level / `com/kestalkayden/veinminerplusplus/client/VeinMinerPlusModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/kestalkayden/veinminerplusplus/config/VeinMinerPlusConfig.java` | `` |  | setConfigDir, load, save, get, getConfigDir, apply, resolveFile, clamp, clampInt, writeFile, migrateLegacyFiles, moveIfAbsent, loadVoidBlocks, writeVoidFile |
| top-level / `com/kestalkayden/veinminerplusplus/core/BlockMatcher.java` | `` |  | vanillaBlockTag, forOrigin, matches |
| top-level / `com/kestalkayden/veinminerplusplus/core/ClientShapeState.java` | `` |  | onCycle |
| top-level / `com/kestalkayden/veinminerplusplus/core/ClientState.java` | `` |  |  |
| top-level / `com/kestalkayden/veinminerplusplus/core/MineShape.java` | `` |  | isBox, cycle, positions, bounds, directionInto |
| top-level / `com/kestalkayden/veinminerplusplus/core/PlayerState.java` | `` |  | isEnabled, setEnabled, isActivationHeld, setActivationHeld, clear |
| top-level / `com/kestalkayden/veinminerplusplus/core/ShapeState.java` | `` |  | get, set, clear, cycle |
| top-level / `com/kestalkayden/veinminerplusplus/core/VeinMiner.java` | `` |  | isBreaking, onBlockBroken, canMine, collectBox, hasLeavesNearby, hasAdjacentLeaf, addIsolatedCanopy, flood, tick, applyDurabilityMultiplier, chargeVoidDurability, chargeScaled, Target |
| top-level / `com/kestalkayden/veinminerplusplus/core/VeinMinerConfig.java` | `` |  |  |
| top-level / `com/kestalkayden/veinminerplusplus/network/ActivationHeldPayload.java` | `` |  | type |
| top-level / `com/kestalkayden/veinminerplusplus/network/ShapeSelectPayload.java` | `` |  | type |
| top-level / `com/kestalkayden/veinminerplusplus/network/ToggleEnabledPayload.java` | `` |  | type |
| top-level / `com/kestalkayden/veinminerplusplus/VeinMinerPlus.java` | `` |  |  |
| top-level / `com/kestalkayden/veinminerplusplus/VeinMinerPlusFabric.java` | `` |  | onInitialize |
| top-level / `com/kestalkayden/veinminerplusplus/VeinMinerPlusFabricClient.java` | `` |  | onInitializeClient, onClientTick, send |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
