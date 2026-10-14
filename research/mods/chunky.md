# Chunky

Review status: **Evidence inventory; behavioral review pending**

Project: [Chunky](https://modrinth.com/mod/chunky)
Selected artifact version: `1.5.3`
Published implementation source: https://github.com/pop4959/Chunky
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Pre-generates chunks, quickly and efficiently

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `fc1f2f374c5c82117599071ed18b6ef9bba2c7fb`
- `sha512`: `b83bfe7b218d0aa6232af977ae741dc1f82b10e50cd12bb759f65cf416b8b62beccb543e587ef0b9670abe03815660f8e091bc6823624d65cf07300571573516`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 137
Reconstructed Java files: 128

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "org.popcraft.chunky.ChunkyFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.1",
  "fabric-api": "*",
  "minecraft": ">=26.1",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `org/popcraft/chunky/api/ChunkyAPI.java` | `` |  |  |
| top-level / `org/popcraft/chunky/api/ChunkyAPIImpl.java` | `` |  | version, isRunning, startTask, pauseTask, continueTask, cancelTask, onGenerationProgress, onGenerationComplete |
| top-level / `org/popcraft/chunky/api/event/task/GenerationCompleteEvent.java` | `` |  |  |
| top-level / `org/popcraft/chunky/api/event/task/GenerationProgressEvent.java` | `` |  |  |
| top-level / `org/popcraft/chunky/Chunky.java` | `` |  | disable, loadLimit, loadVersion, loadCommands, getScheduler, getServer, getConfig, getTaskLoader, getEventBus, getGenerationTasks, getTrimTasks, getCommands, getSelection, getPendingAction, setPendingAction, setLanguage, getRegionCache, getLimit, getVersion, getApi |
| top-level / `org/popcraft/chunky/ChunkyFabric.java` | `` |  | onInitialize, registerArguments, getChunky |
| top-level / `org/popcraft/chunky/ChunkyProvider.java` | `` |  | get |
| top-level / `org/popcraft/chunky/command/CancelCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/CenterCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/ChunkyCommand.java` | `` |  |  |
| top-level / `org/popcraft/chunky/command/CommandArguments.java` | `` |  | of, of, empty, size, next, remaining, joined |
| top-level / `org/popcraft/chunky/command/CommandLiteral.java` | `` |  |  |
| top-level / `org/popcraft/chunky/command/ConfirmCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/ContinueCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/CornersCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/HelpCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/PatternCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/PauseCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/ProgressCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/QuietCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/RadiusCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/ReloadCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/SelectionCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/ShapeCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/SilentCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/SpawnCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/StartCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/suggestion/PatternSuggestionProvider.java` | `` |  | getSuggestions |
| top-level / `org/popcraft/chunky/command/suggestion/ShapeSuggestionProvider.java` | `` |  | getSuggestions |
| top-level / `org/popcraft/chunky/command/suggestion/SuggestionProviders.java` | `` |  |  |
| top-level / `org/popcraft/chunky/command/suggestion/TrimModeSuggestionProvider.java` | `` |  | getSuggestions |
| top-level / `org/popcraft/chunky/command/TrimCommand.java` | `` |  | execute, checkRegion, shouldDeleteRegion, deleteRegion, trimRegion, suggestions, isCancelled, setCancelled |
| top-level / `org/popcraft/chunky/command/WorldBorderCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/command/WorldCommand.java` | `` |  | execute, suggestions |
| top-level / `org/popcraft/chunky/ducks/MinecraftServerExtension.java` | `` |  |  |
| top-level / `org/popcraft/chunky/event/Cancellable.java` | `` |  | isCancelled, setCancelled |
| top-level / `org/popcraft/chunky/event/command/ReloadCommandEvent.java` | `` |  |  |
| top-level / `org/popcraft/chunky/event/Event.java` | `` |  |  |
| top-level / `org/popcraft/chunky/event/EventBus.java` | `` |  | subscribe, unsubscribe, unsubscribeAll, unsubscribeAll, call |
| top-level / `org/popcraft/chunky/event/task/GenerationTaskFinishEvent.java` | `` |  |  |
| top-level / `org/popcraft/chunky/event/task/GenerationTaskUpdateEvent.java` | `` |  |  |
| top-level / `org/popcraft/chunky/GenerationTask.java` | `` |  | update, run, stop, getChunky, getSelection, getCount, getChunkIterator, getShape, isCancelled, getTotalTime, getProgress, getWorld, getChunkCount, isComplete, getPercentComplete, getHours, getMinutes, getSeconds, getRate, getChunkX, getChunkZ, sendUpdate |
| top-level / `org/popcraft/chunky/integration/BorderIntegration.java` | `` |  |  |
| top-level / `org/popcraft/chunky/integration/Integration.java` | `` |  |  |
| top-level / `org/popcraft/chunky/iterator/ChunkIterator.java` | `` |  |  |
| top-level / `org/popcraft/chunky/iterator/ChunkIteratorFactory.java` | `` |  | getChunkIterator, getChunkIterator |
| top-level / `org/popcraft/chunky/iterator/ConcentricChunkIterator.java` | `` |  | hasNext, next, total, name |
| top-level / `org/popcraft/chunky/iterator/CsvChunkIterator.java` | `` |  | hasNext, next, total, name |
| top-level / `org/popcraft/chunky/iterator/Loop2ChunkIterator.java` | `` |  | hasNext, next, total, name |
| top-level / `org/popcraft/chunky/iterator/PatternType.java` | `` |  |  |
| top-level / `org/popcraft/chunky/iterator/RegionChunkIterator.java` | `` |  | hasNext, next, nextRegionChunkProgress, nextRegionChunkProgress, total, name, hasNext, next, total, name |
| top-level / `org/popcraft/chunky/iterator/SpiralChunkIterator.java` | `` |  | hasNext, next, total, name |
| top-level / `org/popcraft/chunky/iterator/WorldChunkIterator.java` | `` |  | hasNext, next, total, name, process |
| top-level / `org/popcraft/chunky/listeners/bossbar/BossBarTaskFinishListener.java` | `` |  | accept |
| top-level / `org/popcraft/chunky/listeners/bossbar/BossBarTaskUpdateListener.java` | `` |  | accept, createNewBossBar, bossBarColor |
| top-level / `org/popcraft/chunky/mixin/ChunkMapMixin.java` | `value={ChunkMap.class})` | Invoker:3, Accessor:1 |  |
| top-level / `org/popcraft/chunky/mixin/client/IntegratedServerMixin.java` | `value={IntegratedServer.class})` | Inject:1 | tickPaused |
| top-level / `org/popcraft/chunky/mixin/MinecraftServerAccess.java` | `value={MinecraftServer.class})` | Accessor:1 |  |
| top-level / `org/popcraft/chunky/mixin/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Inject:1 | tickPaused, chunky$runChunkSystemHousekeeping, chunky$markChunkSystemHousekeeping |
| top-level / `org/popcraft/chunky/mixin/ServerChunkCacheMixin.java` | `value={ServerChunkCache.class})` | Invoker:3 |  |
| top-level / `org/popcraft/chunky/mixin/ServerLevelMixin.java` | `value={ServerLevel.class})` | Accessor:1 |  |
| top-level / `org/popcraft/chunky/nbt/ByteArrayTag.java` | `` |  | read, skip, write, search, type, typeName, print, value, value |
| top-level / `org/popcraft/chunky/nbt/ByteTag.java` | `` |  | read, skip, write, search, type, typeName, print, value, value |
| top-level / `org/popcraft/chunky/nbt/CompoundTag.java` | `` |  | read, skip, write, search, type, typeName, print, get, getByteArray, getByte, getCompound, getDouble, getFloat, getIntArray, getInt, getList, getLongArray, getLong, getShort, getString, put, remove |
| top-level / `org/popcraft/chunky/nbt/DoubleTag.java` | `` |  | read, skip, write, search, type, typeName, print, value, value |
| top-level / `org/popcraft/chunky/nbt/EndTag.java` | `` |  | read, skip, write, search, type, typeName, print |
| top-level / `org/popcraft/chunky/nbt/FloatTag.java` | `` |  | read, skip, write, search, type, typeName, print, value, value |
| top-level / `org/popcraft/chunky/nbt/IntArrayTag.java` | `` |  | read, skip, write, search, type, typeName, print, value, value |
| top-level / `org/popcraft/chunky/nbt/IntTag.java` | `` |  | read, skip, write, search, type, typeName, print, value, value |
| top-level / `org/popcraft/chunky/nbt/ListTag.java` | `` |  | read, skip, write, search, type, typeName, print, value, value |
| top-level / `org/popcraft/chunky/nbt/LongArrayTag.java` | `` |  | read, skip, write, search, type, typeName, print, value, value |
| top-level / `org/popcraft/chunky/nbt/LongTag.java` | `` |  | read, skip, write, search, type, typeName, print, value, value |
| top-level / `org/popcraft/chunky/nbt/NBT.java` | `` |  | load, save, loadCompressed, saveCompressed |
| top-level / `org/popcraft/chunky/nbt/ShortTag.java` | `` |  | read, skip, write, search, type, typeName, print, value, value |
| top-level / `org/popcraft/chunky/nbt/StringTag.java` | `` |  | read, skip, write, search, type, typeName, print, value, value |
| top-level / `org/popcraft/chunky/nbt/Tag.java` | `` |  | load, pass, save, find, create, name, toString |
| top-level / `org/popcraft/chunky/nbt/TagType.java` | `` |  |  |
| top-level / `org/popcraft/chunky/nbt/util/Chunk.java` | `` |  | getData, getX, setX, getZ, setZ, setData, getLastModified, setLastModified |
| top-level / `org/popcraft/chunky/nbt/util/ChunkFilter.java` | `` |  | of, getType, getName |
| top-level / `org/popcraft/chunky/nbt/util/ChunkPos.java` | `` |  | ChunkPos, of |
| top-level / `org/popcraft/chunky/nbt/util/RegionFile.java` | `` |  | getChunks, getChunk |
| top-level / `org/popcraft/chunky/platform/Border.java` | `` |  |  |
| top-level / `org/popcraft/chunky/platform/Config.java` | `` |  |  |
| top-level / `org/popcraft/chunky/platform/FabricBorder.java` | `` |  | getCenter, getRadiusX, getRadiusZ, getShape |
| top-level / `org/popcraft/chunky/platform/FabricPlayer.java` | `` |  | isPlayer, getName, getWorld, getLocation, sendMessage, getUUID, teleport, sendActionBar, formatColored |
| top-level / `org/popcraft/chunky/platform/FabricSender.java` | `` |  | isPlayer, getName, getWorld, getLocation, hasPermission, hasPermission, sendMessage |
| top-level / `org/popcraft/chunky/platform/FabricServer.java` | `` |  | getIntegrations, getWorld, getWorlds, getMaxWorldSize, getConsole, getPlayers, getPlayer, getConfig |
| top-level / `org/popcraft/chunky/platform/FabricWorld.java` | `` |  | getName, getKey, isChunkGenerated, getChunkAtAsync, getUUID, getSeaLevel, getSpawn, getWorldBorder, getElevation, getMaxElevation, playEffect, playSound, getDirectory, getWorld |
| top-level / `org/popcraft/chunky/platform/impl/GsonConfig.java` | `` |  | getDirectory, getVersion, getLanguage, getContinueOnRestart, isForceLoadExistingChunks, isSilent, setSilent, getUpdateInterval, setUpdateInterval, reload, saveConfig, getVersion, setVersion, getLanguage, setLanguage, getContinueOnRestart, setContinueOnRestart, getForceLoadExistingChunks, setForceLoadExistingChunks, getTasks, setTasks, isSilent, setSilent, getUpdateInterval, setUpdateInterval, getCancelled, setCancelled, getRadius, setRadius, getRadiusZ, setRadiusZ, getCenterX, setCenterX, getCenterZ, setCenterZ, getIterator, setIterator, getShape, setShape, getCount, setCount, getTime, setTime |
| top-level / `org/popcraft/chunky/platform/Player.java` | `` |  |  |
| top-level / `org/popcraft/chunky/platform/Sender.java` | `` |  |  |
| top-level / `org/popcraft/chunky/platform/Server.java` | `` |  |  |
| top-level / `org/popcraft/chunky/platform/util/Location.java` | `` |  | toVector, add, setDirection, getWorld, setWorld, getX, setX, getY, setY, getZ, setZ, getYaw, setYaw, getPitch, setPitch |
| top-level / `org/popcraft/chunky/platform/util/Vector2.java` | `` |  | of, add, multiply, normalize, distance, distanceSquared, length, lengthSquared, getX, setX, getZ, setZ |
| top-level / `org/popcraft/chunky/platform/util/Vector3.java` | `` |  | of, add, multiply, normalize, distance, distanceSquared, length, lengthSquared, getX, setX, getY, setY, getZ, setZ |
| top-level / `org/popcraft/chunky/platform/World.java` | `` |  |  |
| top-level / `org/popcraft/chunky/Selection.java` | `` |  | builder, chunky, world, centerX, centerZ, radiusX, radiusZ, pattern, shape, centerChunkX, centerChunkZ, radiusChunksX, radiusChunksZ, diameterChunksX, diameterChunksZ, centerRegionX, centerRegionZ, radiusRegionsX, radiusRegionsZ, diameterRegionsX, diameterRegionsZ, world, center, centerX, centerZ, radius, radiusX, radiusZ, pattern, shape, spawn, worldborder, build |
| top-level / `org/popcraft/chunky/shape/AbstractEllipse.java` | `` |  |  |
| top-level / `org/popcraft/chunky/shape/AbstractPolygon.java` | `` |  |  |
| top-level / `org/popcraft/chunky/shape/AbstractShape.java` | `` |  | center |
| top-level / `org/popcraft/chunky/shape/Circle.java` | `` |  | isBounding, name, radii |
| top-level / `org/popcraft/chunky/shape/Diamond.java` | `` |  | points, isBounding, name |
| top-level / `org/popcraft/chunky/shape/Ellipse.java` | `` |  | isBounding, name, radii |
| top-level / `org/popcraft/chunky/shape/Hexagon.java` | `` |  | points, isBounding, name |
| top-level / `org/popcraft/chunky/shape/Pentagon.java` | `` |  | points, isBounding, name |
| top-level / `org/popcraft/chunky/shape/Rectangle.java` | `` |  | points, isBounding, name |
| top-level / `org/popcraft/chunky/shape/Shape.java` | `` |  |  |
| top-level / `org/popcraft/chunky/shape/ShapeFactory.java` | `` |  | getShape, getShape, registerCustom, getCustomTypes |
| top-level / `org/popcraft/chunky/shape/ShapeType.java` | `` |  | all |
| top-level / `org/popcraft/chunky/shape/ShapeUtil.java` | `` |  | insideLine, intersection, pointOnEllipse, closestPointOnLine, distanceBetweenPoints |
| top-level / `org/popcraft/chunky/shape/Square.java` | `` |  | points, isBounding, name |
| top-level / `org/popcraft/chunky/shape/Star.java` | `` |  | points, isBounding, name |
| top-level / `org/popcraft/chunky/shape/Triangle.java` | `` |  | points, isBounding, name |
| top-level / `org/popcraft/chunky/util/ChunkCoordinate.java` | `` |  | fromRegionFile, compareTo, equals, hashCode, toString |
| top-level / `org/popcraft/chunky/util/ChunkMath.java` | `` |  | pack, regionIndex |
| top-level / `org/popcraft/chunky/util/Disk.java` | `` |  | estimatedSpace, remainingSpace |
| top-level / `org/popcraft/chunky/util/Formatting.java` | `` |  | bytes, radius, number |
| top-level / `org/popcraft/chunky/util/Hilbert.java` | `` |  | regionDistanceToChunkCoordinateOffset, chunkCoordinateOffsets |
| top-level / `org/popcraft/chunky/util/Input.java` | `` |  | tryWorld, tryPattern, tryShape, tryBoolean, tryInteger, tryIntegerSuffixed, tryDouble, tryDoubleSuffixed, tryLong, trySign, isPastWorldLimit, checkLanguage, suffixValue |
| top-level / `org/popcraft/chunky/util/Pair.java` | `` |  | of |
| top-level / `org/popcraft/chunky/util/Parameter.java` | `` |  | of, of, getType, getValue, toString |
| top-level / `org/popcraft/chunky/util/PendingAction.java` | `` |  | getAction, hasExpired |
| top-level / `org/popcraft/chunky/util/RegionCache.java` | `` |  | getWorld, clear, setGenerated, isGenerated |
| top-level / `org/popcraft/chunky/util/TaskLoader.java` | `` |  | reload, loadTask, loadTasks, saveTask, saveTasks, cancelTask, cancelTasks, writeTask, key |
| top-level / `org/popcraft/chunky/util/TaskScheduler.java` | `` |  | runTask, cancelTasks |
| top-level / `org/popcraft/chunky/util/TranslationKey.java` | `` |  |  |
| top-level / `org/popcraft/chunky/util/Translator.java` | `` |  | setLanguage, isValidLanguage, translateKey, translate, addCustomTranslation, load |
| top-level / `org/popcraft/chunky/util/Version.java` | `` |  | isEqualTo, isHigherThan, isHigherThanOrEqualTo, isLowerThan, isLowerThanOrEqualTo, isValid, compareTo, equals, hashCode |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
