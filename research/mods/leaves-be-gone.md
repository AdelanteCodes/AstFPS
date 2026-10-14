# Leaves Be Gone

Review status: **Evidence inventory; behavioral review pending**

Project: [Leaves Be Gone](https://modrinth.com/mod/leaves-be-gone)
Selected artifact version: `26.3.0`
Published implementation source: https://github.com/Fuzss/leavesbegone
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Quick leaf decay from cutting down trees. Built for fast performance and mod compat!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `8b9ac3bd8fb28cf4c1c06ec3d1f4c33b86993461e298fc4517e017518d22b0588fb4ac8a1daa8d6f8f6a74406bc69dcdbc8f39714d7b303d03bdd17e4336ccc2`
- `sha1`: `a0d33c0e9a6ba5a53cb4af42deb8426ee45767e3`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 16
Reconstructed Java files: 16

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "fuzs.leavesbegone.fabric.client.LeavesBeGoneFabricClient"
  ],
  "main": [
    "fuzs.leavesbegone.fabric.LeavesBeGoneFabric"
  ]
}
```

**depends**

```json
{
  "minecraft": "~26.3-",
  "fabricloader": ">=0.19.5",
  "fabric-api": ">=0.160.6",
  "forgeconfigapiport": "*",
  "puzzleslib": ">=26.3.4"
}
```

**accessWidener**

```json
"leavesbegone.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `fuzs/leavesbegone/common/client/LeavesBeGoneClient.java` | `` |  |  |
| top-level / `fuzs/leavesbegone/common/config/ServerConfig.java` | `` |  |  |
| top-level / `fuzs/leavesbegone/common/data/ModBlockTagProvider.java` | `` |  | addTags |
| top-level / `fuzs/leavesbegone/common/helper/LeavesDistanceHelper.java` | `` |  | updateDistance, mustResetDistance, createBlockTag |
| top-level / `fuzs/leavesbegone/common/init/ModRegistry.java` | `` |  | bootstrap |
| top-level / `fuzs/leavesbegone/common/LeavesBeGone.java` | `` |  | onConstructMod, registerEventHandlers, id |
| top-level / `fuzs/leavesbegone/common/mixin/ChunkAccess$PackedTicksMixin.java` | `value={ChunkAccess.PackedTicks.class})` |  | leavesbegone$getRandomBlocks, leavesbegone$setRandomBlocks |
| top-level / `fuzs/leavesbegone/common/mixin/LeavesBlockMixin.java` | `value={LeavesBlock.class})` | ModifyExpressionValue:2 | updateShape, updateDistance |
| top-level / `fuzs/leavesbegone/common/mixin/LevelChunkMixin.java` | `value={LevelChunk.class})` | Inject:3, ModifyReturnValue:1 | leavesbegone$getRandomBlockTicks, leavesbegone$setRandomBlockTicks, unpackTicks, registerTickContainerInLevel, unregisterTickContainerFromLevel, getTicksForSerialization |
| top-level / `fuzs/leavesbegone/common/mixin/SerializableChunkDataMixin.java` | `value={SerializableChunkData.class})` | ModifyVariable:2, Inject:1 | parse, read, saveTicks |
| top-level / `fuzs/leavesbegone/common/mixin/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:3 | leavesbegone$getRandomBlockTicks, tick, tickBlock$0, tickBlock$1 |
| top-level / `fuzs/leavesbegone/common/server/level/RandomBlockTickerLevel.java` | `` |  |  |
| top-level / `fuzs/leavesbegone/common/world/level/chunk/RandomBlockTickerChunk.java` | `` |  |  |
| top-level / `fuzs/leavesbegone/common/world/level/chunk/RandomBlockTickerPackedTicks.java` | `` |  |  |
| top-level / `fuzs/leavesbegone/fabric/client/LeavesBeGoneFabricClient.java` | `` |  | onInitializeClient |
| top-level / `fuzs/leavesbegone/fabric/LeavesBeGoneFabric.java` | `` |  | onInitialize |

## Data-driven behavior

Resource category counts: `tags`: 14.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
