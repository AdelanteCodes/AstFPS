# Alternate Current

Review status: **Evidence inventory; behavioral review pending**

Project: [Alternate Current](https://modrinth.com/mod/alternate-current)
Selected artifact version: `mc26.3-1.9.0`
Published implementation source: https://github.com/SpaceWalkerRS/alternate-current
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

An efficient and non-locational redstone dust implementation

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `347fa8d0338a7e113c0cde70306d05037dbf9fc1e33c476159b4f5cf7b4fce8d3798d820ebf0e0dedd8450417802cb3a030bdcbecaf509961a83b2e43a469ad5`
- `sha1`: `1316efc4195fbf152f8521542bc2435bd588ddb6`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 31
Reconstructed Java files: 21

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "alternate.current.AlternateCurrentMod"
  ]
}
```

**depends**

```json
{
  "minecraft": "26.3.x"
}
```

**breaks**

```json
{}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `alternate/current/AlternateCurrentMod.java` | `` |  | onInitialize, createProfiler |
| top-level / `alternate/current/command/AlternateCurrentCommand.java` | `` |  | register, parseUpdateOrder, queryEnabled, setEnabled, queryUpdateOrder, setUpdateOrder, resetProfiler |
| top-level / `alternate/current/interfaces/mixin/IServerLevel.java` | `` |  |  |
| top-level / `alternate/current/mixin/CommandsMixin.java` | `value={Commands.class})` | Inject:1 | alternate_current$registerCommands |
| top-level / `alternate/current/mixin/ExperimentalRedstoneUtilsMixin.java` | `value={ExperimentalRedstoneUtils.class})` | Inject:1 | noRandomOrientation |
| top-level / `alternate/current/mixin/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Inject:1 | alternate_current$save |
| top-level / `alternate/current/mixin/RedstoneWireBlockMixin.java` | `value={RedstoneWireBlock.class})` | Inject:4 | alternate_current$onUpdate, alternate_current$onPlace, alternate_current$onRemove, alternate_current$onNeighborChanged |
| top-level / `alternate/current/mixin/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:1 | alternate_current$parseConfig, alternate_current$getWireHandler |
| top-level / `alternate/current/util/profiler/ACProfiler.java` | `` |  | start, end, push, pop, swap |
| top-level / `alternate/current/util/profiler/Profiler.java` | `` |  | start, end, push, pop, swap |
| top-level / `alternate/current/util/profiler/ProfilerResults.java` | `` |  | clear, add, log |
| top-level / `alternate/current/wire/Config.java` | `` |  | forLevel, getEnabled, setEnabled, getUpdateOrder, setUpdateOrder, load, save, getEnabled, setEnabled, getUpdateOrder, setUpdateOrder, load, save |
| top-level / `alternate/current/wire/LevelHelper.java` | `` |  |  |
| top-level / `alternate/current/wire/Node.java` | `` |  | equals, hashCode, isWire, isConductor, isSignalSource, asWire |
| top-level / `alternate/current/wire/PriorityQueue.java` | `` |  | offer, poll, peek, clear, iterator, size, contains, move, remove, insert, linkHead, linkTail, linkAfter, linkBetween, findPrev |
| top-level / `alternate/current/wire/SimpleQueue.java` | `` |  | offer, poll, peek, clear, iterator, size, hasNext, next |
| top-level / `alternate/current/wire/UpdateOrder.java` | `` |  | forEachNeighbor, forEachNeighbor, forEachNeighbor, forEachNeighbor, id, byId, directNeighbors, cardinalNeighbors |
| top-level / `alternate/current/wire/WireConnection.java` | `` |  |  |
| top-level / `alternate/current/wire/WireConnectionManager.java` | `` |  | clear, add, add |
| top-level / `alternate/current/wire/WireHandler.java` | `` |  | getConfig, getOrAddNode, getOrAddNode, removeNode, getNextNode, getNextNode, increaseNodeCache, fillNodeCache, revalidateNode, getNeighbor, onWireUpdated, onWireAdded, onWireRemoved, invalidate, findRoots, findRootsAround, findRoot, findRoot, discover, findPower, findWirePower, findExternalPower, getExternalPower, getDirectSignalTo, needsUpdate, searchRoot, search, tryUpdate, update, searchNetwork, depowerNetwork, powerNetwork, findPowerFlow, transmitPower, updateNeighborShapes, updateShape, queueNeighbors, queueNeighbor, queueWire, updateBlock, iOpposite, index |
| top-level / `alternate/current/wire/WireNode.java` | `` |  | isWire, asWire |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
