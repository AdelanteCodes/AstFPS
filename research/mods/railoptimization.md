# RailOptimization

Review status: **Evidence inventory; behavioral review pending**

Project: [RailOptimization](https://modrinth.com/mod/railoptimization)
Selected artifact version: `2.0`
Published implementation source: https://github.com/EasterGhost/RailOptimization
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A simple mod that makes powered/activator rails turn on/off up to 12x faster.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `545a3a92a0191c176ce3fd44230a7e53402fd351`
- `sha512`: `a0f7d92db42cfdb44cd815b82f8bbb68528b54531836b4ff27ac724f2ac3cc3ab51b5b5b9798c0ccd8d5aa03cbf386183d973d731d705d896d330bc3d618dc4e`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 28
Reconstructed Java files: 22

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "RailOptimization.RailOptimizationFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": "*",
  "fabric-api": "*",
  "minecraft": ">=26.1"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `RailOptimization/config/RailOptimizationConfig.java` | `` |  | RailOptimizationConfig, defaults, normalizePowerLimit |
| top-level / `RailOptimization/config/RailOptimizationConfigManager.java` | `` |  | initialize, setEnabled, setPowerLimit, reloadAsync, applyReloaded, flushWrites, applyConfig, saveAsync, readConfig, readBoolean, readInteger, writeConfig, getConfigPath, ReloadResult |
| top-level / `RailOptimization/LevelEpochAccess.java` | `` |  |  |
| top-level / `RailOptimization/mixin/BaseRailBlockMixin.java` | `value={BaseRailBlock.class})` | WrapOperation:1 | railoptimization$reuseSupportCheck |
| top-level / `RailOptimization/mixin/BlockStateMixin.java` | `value={BlockState.class})` |  | railoptimization$getRailData |
| top-level / `RailOptimization/mixin/LevelChunkMixin.java` | `value={LevelChunk.class}, priority=990)` | Inject:1 | railoptimization$setBlockState |
| top-level / `RailOptimization/mixin/LevelMixin.java` | `value={Level.class})` |  | railoptimization$getBlockChangeEpoch |
| top-level / `RailOptimization/mixin/PoweredRailBlockMixin.java` | `value={PoweredRailBlock.class}, priority=990)` | WrapMethod:1 | railoptimization$updateState |
| top-level / `RailOptimization/RailChangeList.java` | `` |  |  |
| top-level / `RailOptimization/RailLaneUpdater.java` | `` |  | getRailDirections, setRailPositionsPower, setRailPositionsDePower, setConnectedRailPositionsDePower, setStraightRailPositionsDePower, setRailPowerState, updateChangedRails |
| top-level / `RailOptimization/RailLogic.java` | `` |  | newUpdateContext, releaseUpdateContext, setRailPowerLimit, isOptimizationEnabled, setOptimizationEnabled, tryCustomUpdateState, canReuseConfirmedState, customUpdateStateWithCurrentPowerLimit |
| top-level / `RailOptimization/RailNeighborSignalChecker.java` | `` |  | belowStateWhenNoNeighborSignal, belowStateWhenNoNeighborSignalInChunk, createDirectSignalDirections, getBlockState |
| top-level / `RailOptimization/RailOptimizationCommands.java` | `` |  | register, setEnabled, setPowerLimit, reloadConfig, errorMessage, sendStatus |
| top-level / `RailOptimization/RailOptimizationFabric.java` | `` |  | onInitialize |
| top-level / `RailOptimization/RailPath.java` | `` |  | setStep, directionConnectsBackTo, isSameRailWithAxis |
| top-level / `RailOptimization/RailSearchCache.java` | `` |  | putAt, findOrEmpty |
| top-level / `RailOptimization/RailSignalSearcher.java` | `` |  | checkedPosFlags, findPoweredRailSignalAt, findPoweredRailSignalFromState |
| top-level / `RailOptimization/RailStateAccess.java` | `` |  |  |
| top-level / `RailOptimization/RailSupportCache.java` | `` |  | shouldBeRemoved, checkAndRecord, supportFlags, supportFlags, refresh |
| top-level / `RailOptimization/RailUpdateContext.java` | `` |  | getChunk |
| top-level / `RailOptimization/RailUpdateMemo.java` | `` |  | onBlockStateChanged, checkEntry, expectedMeta, levelEpoch, hashIndex |
| top-level / `RailOptimization/RailUpdateNotifier.java` | `` |  | updateEastWestRails, updateNorthSouthRails, notifyDeferredSouthEndpoint, notifyNorthSouthBranch, notifyRail, notifyMain, notifyShape, notifySupport, notifyOuter, setPosition |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
