# Command Profiler

Review status: **Evidence inventory; behavioral review pending**

Project: [Command Profiler](https://modrinth.com/mod/command-profiler)
Selected artifact version: `1.4.1+26.3-pre.2`
Published implementation source: https://gitlab.epicpix.dev/EpicPix/command-profiler
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A mod which profiles commands and functions

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `d1812266e4e42c65cb4c3bebc81173256cf8d6bee9f55b54343c254b2406afb0ffd411e51ba3e17d825072e912b9be70d4a8a07bc0f8a5801591deb52fe8ef1f`
- `sha1`: `5aa827f66d6dd224233ec5b93e1ee7797346f36f`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 52
Reconstructed Java files: 41

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "dev.epicpix.command_profiler.CommandProfilerMain"
  ],
  "cmdprof": [
    "dev.epicpix.command_profiler.common.CommandProfilerExtensions"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.3",
  "minecraft": "26.3.x"
}
```

**accessWidener**

```json
"command-profiler.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/epicpix/command_profiler/CommandProfilerCommand.java` | `` |  | exportCallTree, register |
| top-level / `dev/epicpix/command_profiler/CommandProfilerMain.java` | `` |  | onInitialize |
| top-level / `dev/epicpix/command_profiler/common/arguments/ExportTypeSuggestionProvider.java` | `` |  | getSuggestions |
| top-level / `dev/epicpix/command_profiler/common/arguments/GranularitySuggestionProvider.java` | `` |  | getSuggestions |
| top-level / `dev/epicpix/command_profiler/common/bench/BenchmarkResults.java` | `` |  | BenchmarkResults |
| top-level / `dev/epicpix/command_profiler/common/bench/QueuedBenchmark.java` | `` |  | QueuedBenchmark |
| top-level / `dev/epicpix/command_profiler/common/bench/RunningBenchmark.java` | `` |  | sortSamples, getResults |
| top-level / `dev/epicpix/command_profiler/common/CommandProfilerApi.java` | `` |  |  |
| top-level / `dev/epicpix/command_profiler/common/CommandProfilerExtensions.java` | `` |  | execute |
| top-level / `dev/epicpix/command_profiler/common/ExecutionDepthTracker.java` | `` |  | enterMacroCommand, enterCommand, enterFunctionDepth, enterMacroFunctionDepth, exitCommandDepth, exitDepth, exitLast, enter, exitAll |
| top-level / `dev/epicpix/command_profiler/common/ExecutionType.java` | `` |  | getReplaceability |
| top-level / `dev/epicpix/command_profiler/common/ExportType.java` | `` |  |  |
| top-level / `dev/epicpix/command_profiler/common/extensions/BenchmarkStateHolderExtension.java` | `` |  |  |
| top-level / `dev/epicpix/command_profiler/common/extensions/CommandMetadataExtension.java` | `` |  |  |
| top-level / `dev/epicpix/command_profiler/common/extensions/ExecutionContextExtension.java` | `` |  |  |
| top-level / `dev/epicpix/command_profiler/common/extensions/FunctionBuilderExtension.java` | `` |  |  |
| top-level / `dev/epicpix/command_profiler/common/extensions/RealFunctionIdExtension.java` | `` |  |  |
| top-level / `dev/epicpix/command_profiler/common/extensions/ScoreboardDirtyTrackerExtension.java` | `` |  |  |
| top-level / `dev/epicpix/command_profiler/common/Profiler.java` | `` |  | isProfilerEnabled, hasNoData, setProfilerEnabled, enterFunction, enterTag, enterBlock, enterCommand, enterMacroFunction, enterMacroCommand, enterMacroFunctionInstantiation, enterMacroCommandInstantiation, exit, getMemoryBytes, generateCallTree, printCallTreeValue, getSortedIterator, printCallTree, writeVarInt, writeVarLong, treeValueToBytes, treeToBytes, mergeTreeInto, collectEvents, jsonEventDetails, treeToJson, getJsonCallTree, getJsonTraceTree, getBytesCallTree, getBytesTraceTree, takeOnlineTree, printTrace, printEvents, clearEvents, reset, resetOnline, insertJsonString, equals, hashCode, totalDuration, totalMemory, type, content, execCount, children, next, hasNext, currentTypeRaw, currentTimeNanos, currentMemoryBytes, currentType, consumeContent, CallTreeState, toMutable, writeLine, PrintCallTreeAction, getString, CallTreeToMutState |
| top-level / `dev/epicpix/command_profiler/common/ProfilerEventContent.java` | `` |  | nthInt, nthString, equals, hashCode |
| top-level / `dev/epicpix/command_profiler/common/ProfilerEventType.java` | `` |  | commandFormat, blockFormat, register, id, name, prettyPrint, equals, hashCode, toString, enter, enter, enter, enter, enter, enter, enter, enter |
| top-level / `dev/epicpix/command_profiler/common/ProfilerExtension.java` | `` |  | register, registerMarker, registerDynamicMarker, extensions, id, set, get, defaultValue, configurable |
| top-level / `dev/epicpix/command_profiler/common/ProfilerSettings.java` | `` |  | resetConfig, loadConfig, saveConfig, getOrDefault |
| top-level / `dev/epicpix/command_profiler/common/websocket/WebsocketApi.java` | `` |  | connectWebsocket, stopWebsocket, isConnected, runTick, sendScoreboard, clearScoreboard |
| top-level / `dev/epicpix/command_profiler/common/websocket/WebsocketConnection.java` | `` |  | getConnectionId, onOpen, onBinary, onError, onClose, handleWebsocketData, close, tick, checkTimePassed, sendData, sendScoreboard |
| top-level / `dev/epicpix/command_profiler/extensions/InstantiatedMacroFunction.java` | `` |  | id, entries, cmdprof$getRealId |
| top-level / `dev/epicpix/command_profiler/mixin/BaseCommandBlockMixin.java` | `value={BaseCommandBlock.class})` | Inject:2 | performCommandBefore, performCommandAfter |
| top-level / `dev/epicpix/command_profiler/mixin/CallFunctionMixin.java` | `value={CallFunction.class})` | Inject:1 | cmdprof$getLineNumber, cmdprof$setLineNumber, cmdprof$getOriginalCommand, execute |
| top-level / `dev/epicpix/command_profiler/mixin/CommandFunctionMixin.java` | `value={CommandFunction.class})` | Inject:2 | fromLines_addCommand, fromLines_addMacro |
| top-level / `dev/epicpix/command_profiler/mixin/CommandsMixin.java` | `value={Commands.class})` | Inject:1 | init |
| top-level / `dev/epicpix/command_profiler/mixin/ExecuteCommandMixin.java` | `value={ExecuteCommand.class})` |  | cmdprof$getLineNumber, cmdprof$setLineNumber, cmdprof$getOriginalCommand |
| top-level / `dev/epicpix/command_profiler/mixin/ExecutionContextMixin.java` | `value={ExecutionContext.class})` | Inject:2 | cmdprof$depthTracker, runCommandQueueFrame, runCommandQueue |
| top-level / `dev/epicpix/command_profiler/mixin/FunctionBuilderMixin.java` | `value={FunctionBuilder.class})` |  | cmdprof$assignLineNumber |
| top-level / `dev/epicpix/command_profiler/mixin/MacroEntryMixin.java` | `value={MacroFunction.MacroEntry.class})` | Inject:2 | cmdprof$getLineNumber, cmdprof$setLineNumber, cmdprof$getOriginalCommand, instantiate, instantiateThrow |
| top-level / `dev/epicpix/command_profiler/mixin/MacroFunctionMixin.java` | `value={MacroFunction.class})` | Redirect:1, Inject:2 | instantiate, substituteAndParse_before, substituteAndParse_after |
| top-level / `dev/epicpix/command_profiler/mixin/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Inject:2 | processPacketsAndTick, cmdprof$addDirtyObjectiveScoreHolder, stopServer |
| top-level / `dev/epicpix/command_profiler/mixin/PlainTextEntryMixin.java` | `value={MacroFunction.PlainTextEntry.class})` |  | cmdprof$getLineNumber, cmdprof$setLineNumber, cmdprof$getOriginalCommand |
| top-level / `dev/epicpix/command_profiler/mixin/PlainTextFunctionMixin.java` | `value={PlainTextFunction.class})` |  | cmdprof$getRealId |
| top-level / `dev/epicpix/command_profiler/mixin/ServerFunctionManagerMixin.java` | `value={ServerFunctionManager.class})` | Inject:4 | tagStart, tagEnd, runCappedIterations, timeUnit, tickEnd, postReload, cmdprof$queueBenchmark, cmdprof$cancelBenchmark |
| top-level / `dev/epicpix/command_profiler/mixin/ServerScoreboardMixin.java` | `value={ServerScoreboard.class})` | Inject:5 | onObjectiveAdded, onObjectiveRemoved, onPlayerRemoved, onPlayerScoreRemoved, onScoreChanged |
| top-level / `dev/epicpix/command_profiler/mixin/UnboundMixin.java` | `value={BuildContexts.Unbound.class})` | Inject:1 | cmdprof$getLineNumber, cmdprof$setLineNumber, cmdprof$getOriginalCommand, cmdprof$setOriginalCommand, execute |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
