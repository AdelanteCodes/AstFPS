# Miner's Dreams

Review status: **Evidence inventory; behavioral review pending**

Project: [Miner's Dreams](https://modrinth.com/mod/miners-dreams)
Selected artifact version: `1.0.1`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Adds a Miner's Dream item, allowing you to carve your own caves at your will!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha512`: `628a571ff4f51dc1b6a8f84d4c6284a6af072d2f9c6c7d1225561b9e1ff8888d0c266c254a29e67ce29e150343a94a13445c5d083ed934deb5b70c0367a07576`
- `sha1`: `d2b08614d104f9e60b5d05b392fc330d4f5bbb51`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 15
Reconstructed Java files: 10

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.craisinlord.minersdream.fabric.MinersDreamFabric"
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
| top-level / `com/craisinlord/minersdream/config/MinersDreamConfig.java` | `` |  | enabled, minimumRange, maximumRange, torchSpacing, blocksPerTick, minHorizontalRadius, maxHorizontalRadius, minVerticalRadius, maxVerticalRadius, maxVerticalDrift, maxTurnDegrees, maxActiveCaves, isBlacklisted, load, parseBlacklist, readStringList, readBoolean, readDouble, readInt, save |
| top-level / `com/craisinlord/minersdream/content/item/MinersDreamCaveGenerator.java` | `` |  | generate, collectNodeCandidates, isCarvable, isChunkLoaded, CaveNode, CaveGenerationResult |
| top-level / `com/craisinlord/minersdream/content/item/MinersDreamExcavation.java` | `` |  | owner, dimension, isFinished, tick, advanceNode, spawnBreakParticles, spawnFrontDust, playRumble, playCompletionSound |
| top-level / `com/craisinlord/minersdream/content/item/MinersDreamExcavationManager.java` | `` |  | hasActiveExcavation, tryStart, clear, tick |
| top-level / `com/craisinlord/minersdream/content/item/MinersDreamItem.java` | `` |  | useOn, appendHoverText |
| top-level / `com/craisinlord/minersdream/content/item/MinersDreamTorchPlacer.java` | `` |  | tryPlaceTorch, findFloorSpot, placeFloorTorch, placeWallTorch, isOpenForTorch |
| top-level / `com/craisinlord/minersdream/content/MinersDreamProtection.java` | `` |  | beforeBreak, afterBreak, setBreakHooks, mayModify, afterBreak |
| top-level / `com/craisinlord/minersdream/content/MinersDreamTags.java` | `` |  |  |
| top-level / `com/craisinlord/minersdream/fabric/MinersDreamFabric.java` | `` |  | onInitialize, beforeBreak, afterBreak |
| top-level / `com/craisinlord/minersdream/MinersDream.java` | `` |  | init |

## Data-driven behavior

Resource category counts: `advancement`: 1, `recipe`: 1, `tags`: 2.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
