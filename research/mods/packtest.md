# PackTest

Review status: **Evidence inventory; behavioral review pending**

Project: [PackTest](https://modrinth.com/mod/packtest)
Selected artifact version: `2.7.0`
Published implementation source: https://github.com/misode/packtest
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Fabric mod for testing data packs, with data packs!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `5c49a76e018f26cc351e5698e9e1e45a35abb59a`
- `sha512`: `18d5d0946c8073ccd29e92016b9ff73898762663457d53eb43758fd76f954655b244d539dd9339ed20b61b44106b8963b77c197094b7586559d72461d138bf60`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 59
Reconstructed Java files: 49

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "io.github.misode.packtest.PackTest"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.15.10",
  "minecraft": ">=26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

**accessWidener**

```json
"packtest.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/github/misode/packtest/ChatListener.java` | `` |  | broadcast, stop, filter, reset, Message |
| top-level / `io/github/misode/packtest/commands/AssertCommand.java` | `` |  | register, addConditions, assertBlock, assertEntity, assertEntityInside, assertPredicate, assertItemsEntity, assertItemsBlock, addScoreCheck, assertScores, assertScoreRange, formatRange, assertData, assertChatUnfiltered, assertChatFiltered, assertChat, err, err, ok, ok, result, get, run |
| top-level / `io/github/misode/packtest/commands/AwaitCommand.java` | `` |  | register, addConditions |
| top-level / `io/github/misode/packtest/commands/DummyCommand.java` | `` |  | createError, register, getDummy, spawn, leave, respawn, jump, sneak, sprint, dropMainhand, swap, selectSlot, useItem, useBlock, useEntity, attackEntity, mineBlock |
| top-level / `io/github/misode/packtest/commands/FailCommand.java` | `` |  | register, run |
| top-level / `io/github/misode/packtest/commands/SucceedCommand.java` | `` |  | register, run |
| top-level / `io/github/misode/packtest/dummy/Dummy.java` | `` |  | createRandom, create, getUsername, leave, respawn, adjustSpawnLocation, tick, die, onEquipItem, getIpAddress |
| top-level / `io/github/misode/packtest/dummy/DummyClientConnection.java` | `` |  | setReadOnly, handleDisconnection, setListenerForServerboundHandshake, setupInboundProtocol |
| top-level / `io/github/misode/packtest/LineNumberException.java` | `` |  | getLineNumber |
| top-level / `io/github/misode/packtest/LoadDiagnostics.java` | `` |  | error, loadErrors, Diagnostic |
| top-level / `io/github/misode/packtest/mixin/BlockPredicateArgumentBlockMixin.java` | `targets={"net.minecraft.commands.arguments.blocks.BlockPredicateArgument$BlockPredicate"})` |  | packtest$getSource, packtest$setSource |
| top-level / `io/github/misode/packtest/mixin/BlockPredicateArgumentMixin.java` | `value={BlockPredicateArgument.class})` | Inject:1, ModifyReturnValue:1 | getCursor, returnSelector |
| top-level / `io/github/misode/packtest/mixin/BlockPredicateArgumentTagMixin.java` | `targets={"net.minecraft.commands.arguments.blocks.BlockPredicateArgument$TagPredicate"})` |  | packtest$getSource, packtest$setSource |
| top-level / `io/github/misode/packtest/mixin/CommandSourceStackMixin.java` | `value={CommandSourceStack.class})` | ModifyReturnValue:11 | packtest$getHelper, packtest$setHelper, withSource, withEntity, withPosition, withRotation, withCallback, withSuppressedOutput, withPermission, withMaximumPermission, withAnchor, withLevel, withSigningContext |
| top-level / `io/github/misode/packtest/mixin/EntityArgumentMixin.java` | `value={EntityArgument.class})` | Inject:1, ModifyReturnValue:1 | getCursor, returnSelector |
| top-level / `io/github/misode/packtest/mixin/EntitySelectorMixin.java` | `value={EntitySelector.class})` |  | packtest$getSource, packtest$setSource, packtest$getPlayerName |
| top-level / `io/github/misode/packtest/mixin/ForceLoadCommandMixin.java` | `value={ForceLoadCommand.class})` | WrapOperation:2 | changeForceLoad, removeAll, handleChange |
| top-level / `io/github/misode/packtest/mixin/GameTestAssertExceptionMixin.java` | `value={GameTestAssertException.class})` |  | packtest$getMessage, packtest$getTick |
| top-level / `io/github/misode/packtest/mixin/GameTestHelperMixin.java` | `value={GameTestHelper.class})` |  | packtest$getInfo |
| top-level / `io/github/misode/packtest/mixin/GameTestInfoMixin.java` | `value={GameTestInfo.class})` | Inject:2 | packtest$getTick, packtest$setChatListener, packtest$getChatListener, finish, succeed |
| top-level / `io/github/misode/packtest/mixin/GameTestRunner1Mixin.java` | `targets={"net.minecraft.gametest.framework.GameTestRunner$1"})` | WrapOperation:2 | testCompleted, testFailed |
| top-level / `io/github/misode/packtest/mixin/GameTestSequenceMixin.java` | `value={GameTestSequence.class})` |  | packtest$thenIdle |
| top-level / `io/github/misode/packtest/mixin/GameTestServerMixin.java` | `value={GameTestServer.class})` | Inject:1, WrapOperation:1, ModifyExpressionValue:2 | tickServer, checkNoTests, onServerExit, startTests |
| top-level / `io/github/misode/packtest/mixin/LogTestReporterMixin.java` | `value={LogTestReporter.class})` | Inject:1 | onTestFailed |
| top-level / `io/github/misode/packtest/mixin/MappedRegistryMixin.java` | `value={MappedRegistry.class})` |  | packtest$setFrozen |
| top-level / `io/github/misode/packtest/mixin/PlayerListMixin.java` | `value={PlayerList.class})` | Inject:1, WrapOperation:2 | skipSaveDummy, getPlayerAdvancements, createDummy |
| top-level / `io/github/misode/packtest/mixin/ReloadableServerResourcesMixin.java` | `value={ReloadableServerResources.class})` | Inject:1, ModifyReturnValue:1 | init, listeners |
| top-level / `io/github/misode/packtest/mixin/ReportGameListenerMixin.java` | `value={ReportGameListener.class})` | ModifyArg:1 | visualizeFailedTest |
| top-level / `io/github/misode/packtest/mixin/server/EulaMixin.java` | `value={Eula.class})` | WrapOperation:1, Inject:1 | readFile, hasAgreedToEULA |
| top-level / `io/github/misode/packtest/mixin/server/MainMixin.java` | `value={Main.class})` | Inject:2 | mainStartServer, exitOnError |
| top-level / `io/github/misode/packtest/mixin/server/SettingsMixin.java` | `value={Settings.class})` | WrapOperation:1 | loadFromFile |
| top-level / `io/github/misode/packtest/mixin/ServerFunctionLibraryMixin.java` | `value={ServerFunctionLibrary.class})` | WrapOperation:1 | catchFunctionError |
| top-level / `io/github/misode/packtest/mixin/ServerPlayerMixin.java` | `value={ServerPlayer.class})` | Inject:1 | sendSystemMessage |
| top-level / `io/github/misode/packtest/mixin/SimpleJsonResourceReloadListenerMixin.java` | `value={SimpleJsonResourceReloadListener.class})` | WrapOperation:2 | resourceParseError, resourceException |
| top-level / `io/github/misode/packtest/mixin/StructureUtilsMixin.java` | `value={StructureUtils.class})` | Inject:1 | clearDummies |
| top-level / `io/github/misode/packtest/mixin/TagLoaderMixin.java` | `value={TagLoader.class})` | WrapOperation:2 | catchTagError, catchTagReferenceError |
| top-level / `io/github/misode/packtest/mixin/TestInstanceBlockEntityMixin.java` | `value={TestInstanceBlockEntity.class})` | WrapOperation:1 | setChunkForced |
| top-level / `io/github/misode/packtest/PackTest.java` | `` |  | isAutoEnabled, isAutoColoringEnabled, isAnnotationsEnabled, shouldGenerateCommands, onInitialize, generateCommandsReport, registerCommands, runHeadlessServer, wrapError, wrapWarning |
| top-level / `io/github/misode/packtest/PackTestArgumentSource.java` | `` |  |  |
| top-level / `io/github/misode/packtest/PackTestAssertException.java` | `` |  |  |
| top-level / `io/github/misode/packtest/PackTestFunction.java` | `` |  | PackTestFunction, run, fromLines, getDummyPos, getTestData, Step, register |
| top-level / `io/github/misode/packtest/PackTestHelper.java` | `` |  |  |
| top-level / `io/github/misode/packtest/PackTestInfo.java` | `` |  |  |
| top-level / `io/github/misode/packtest/PackTestLibrary.java` | `` |  | setRegistries, setPermissionSet, reload, readLines |
| top-level / `io/github/misode/packtest/PackTestPlayerName.java` | `` |  |  |
| top-level / `io/github/misode/packtest/PackTestRegistry.java` | `` |  |  |
| top-level / `io/github/misode/packtest/PackTestSequence.java` | `` |  |  |
| top-level / `io/github/misode/packtest/PackTestSourceStack.java` | `` |  |  |
| top-level / `io/github/misode/packtest/TemporaryForcedChunks.java` | `` |  | isTemporary, markTemporary, unmarkTemporary, TemporaryChunk, from |

## Data-driven behavior

Resource category counts: `structure`: 1.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
