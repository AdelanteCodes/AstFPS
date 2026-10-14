# Async Logger

Review status: **Evidence inventory; behavioral review pending**

Project: [Async Logger](https://modrinth.com/mod/asynclogger)
Selected artifact version: `2.2.2+26.1.2-fabric`
Published implementation source: https://github.com/decce6/AsyncLogger
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Asynchronous logging and efficient filtering - performance improvements and utility for keeping your logs clean

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `2775a667b13ade2e2596a5de0662abef41c837c5cb33152b305beb59eacbfe671f2fc0853f50f86c162d96ff78b7f9f59cf4ba654e6a9d3685b6d73709b05253`
- `sha1`: `d1affbf48c50f60ae59e6b66fb78b1e6427bfddf`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 374
Reconstructed Java files: 257

**entrypoints**

```json
{
  "preLaunch": [
    "me.decce.asynclogger.service.fabric.FabricPreLaunchEntrypoint"
  ],
  "main": [
    "me.decce.asynclogger.fabric.FabricEntrypoint"
  ]
}
```

**depends**

```json
{
  "minecraft": ">=26.1",
  "fabricloader": ">=0.16.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/lmax/disruptor/AbstractSequencer.java` | `` |  | getCursor, getBufferSize, addGatingSequences, removeGatingSequence, getMinimumSequence, newBarrier, newPoller, toString |
| top-level / `com/lmax/disruptor/AggregateEventHandler.java` | `` |  | onEvent, onStart, onShutdown |
| top-level / `com/lmax/disruptor/AlertException.java` | `` |  | fillInStackTrace |
| top-level / `com/lmax/disruptor/BatchEventProcessor.java` | `` |  | getSequence, halt, isRunning, setExceptionHandler, run, processEvents, earlyExit, notifyTimeout, notifyStart, notifyShutdown, handleEventException, handleOnStartException, handleOnShutdownException, getExceptionHandler, attemptRewindGetNextSequence, attemptRewindGetNextSequence |
| top-level / `com/lmax/disruptor/BatchEventProcessorBuilder.java` | `` |  | setMaxBatchSize, build, build |
| top-level / `com/lmax/disruptor/BatchRewindStrategy.java` | `` |  |  |
| top-level / `com/lmax/disruptor/BlockingWaitStrategy.java` | `` |  | waitFor, signalAllWhenBlocking, toString |
| top-level / `com/lmax/disruptor/BusySpinWaitStrategy.java` | `` |  | waitFor, signalAllWhenBlocking |
| top-level / `com/lmax/disruptor/Cursored.java` | `` |  |  |
| top-level / `com/lmax/disruptor/DataProvider.java` | `` |  |  |
| top-level / `com/lmax/disruptor/dsl/ConsumerInfo.java` | `` |  |  |
| top-level / `com/lmax/disruptor/dsl/ConsumerRepository.java` | `` |  | add, add, startAll, haltAll, hasBacklog, getEventProcessorFor, getSequenceFor, unMarkEventProcessorsAsEndOfChain, getBarrierFor, getEventProcessorInfo, getEventProcessorInfo |
| top-level / `com/lmax/disruptor/dsl/Disruptor.java` | `` |  | handleEventsWith, handleEventsWith, handleEventsWith, handleEventsWith, handleExceptionsWith, setDefaultExceptionHandler, handleExceptionsFor, after, after, publishEvent, publishEvent, publishEvents, publishEvent, publishEvent, start, halt, shutdown, shutdown, getRingBuffer, getCursor, getBufferSize, get, getBarrierFor, getSequenceValueFor, hasBacklog, hasStarted, updateGatingSequencesForNextInChain, checkNotStarted, checkOnlyStartedOnce, toString |
| top-level / `com/lmax/disruptor/dsl/EventHandlerGroup.java` | `` |  | and, and, then, then, then, handleEventsWith, handleEventsWith, handleEventsWith, asSequenceBarrier |
| top-level / `com/lmax/disruptor/dsl/EventProcessorFactory.java` | `` |  |  |
| top-level / `com/lmax/disruptor/dsl/EventProcessorInfo.java` | `` |  | getEventProcessor, getSequences, getBarrier, isEndOfChain, start, halt, markAsUsedInBarrier, isRunning |
| top-level / `com/lmax/disruptor/dsl/ExceptionHandlerSetting.java` | `` |  | with |
| top-level / `com/lmax/disruptor/dsl/ExceptionHandlerWrapper.java` | `` |  | switchTo, handleEventException, handleOnStartException, handleOnShutdownException, getExceptionHandler |
| top-level / `com/lmax/disruptor/dsl/ProducerType.java` | `` |  |  |
| top-level / `com/lmax/disruptor/EventFactory.java` | `` |  |  |
| top-level / `com/lmax/disruptor/EventHandler.java` | `` |  |  |
| top-level / `com/lmax/disruptor/EventHandlerBase.java` | `` |  |  |
| top-level / `com/lmax/disruptor/EventHandlerIdentity.java` | `` |  |  |
| top-level / `com/lmax/disruptor/EventPoller.java` | `` |  | poll, newInstance, getSequence |
| top-level / `com/lmax/disruptor/EventProcessor.java` | `` |  |  |
| top-level / `com/lmax/disruptor/EventSequencer.java` | `` |  |  |
| top-level / `com/lmax/disruptor/EventSink.java` | `` |  |  |
| top-level / `com/lmax/disruptor/EventTranslator.java` | `` |  |  |
| top-level / `com/lmax/disruptor/EventTranslatorOneArg.java` | `` |  |  |
| top-level / `com/lmax/disruptor/EventTranslatorThreeArg.java` | `` |  |  |
| top-level / `com/lmax/disruptor/EventTranslatorTwoArg.java` | `` |  |  |
| top-level / `com/lmax/disruptor/EventTranslatorVararg.java` | `` |  |  |
| top-level / `com/lmax/disruptor/EventuallyGiveUpBatchRewindStrategy.java` | `` |  | handleRewindException |
| top-level / `com/lmax/disruptor/ExceptionHandler.java` | `` |  |  |
| top-level / `com/lmax/disruptor/ExceptionHandlers.java` | `` |  | defaultHandler |
| top-level / `com/lmax/disruptor/FatalExceptionHandler.java` | `` |  | handleEventException, handleOnStartException, handleOnShutdownException |
| top-level / `com/lmax/disruptor/FixedSequenceGroup.java` | `` |  | get, toString, set, compareAndSet, incrementAndGet, addAndGet |
| top-level / `com/lmax/disruptor/IgnoreExceptionHandler.java` | `` |  | handleEventException, handleOnStartException, handleOnShutdownException |
| top-level / `com/lmax/disruptor/InsufficientCapacityException.java` | `` |  | fillInStackTrace |
| top-level / `com/lmax/disruptor/LhsPadding.java` | `` |  |  |
| top-level / `com/lmax/disruptor/LiteBlockingWaitStrategy.java` | `` |  | waitFor, signalAllWhenBlocking, toString |
| top-level / `com/lmax/disruptor/LiteTimeoutBlockingWaitStrategy.java` | `` |  | waitFor, signalAllWhenBlocking, toString |
| top-level / `com/lmax/disruptor/MultiProducerSequencer.java` | `` |  | hasAvailableCapacity, hasAvailableCapacity, claim, next, next, tryNext, tryNext, remainingCapacity, publish, publish, setAvailable, setAvailableBufferValue, isAvailable, getHighestPublishedSequence, calculateAvailabilityFlag, calculateIndex, toString |
| top-level / `com/lmax/disruptor/NanosecondPauseBatchRewindStrategy.java` | `` |  | handleRewindException |
| top-level / `com/lmax/disruptor/NoOpEventProcessor.java` | `` |  | getSequence, halt, isRunning, run, get |
| top-level / `com/lmax/disruptor/PhasedBackoffWaitStrategy.java` | `` |  | withLock, withLiteLock, withSleep, waitFor, signalAllWhenBlocking |
| top-level / `com/lmax/disruptor/ProcessingSequenceBarrier.java` | `` |  | waitFor, getCursor, isAlerted, alert, clearAlert, checkAlert |
| top-level / `com/lmax/disruptor/RewindableEventHandler.java` | `` |  |  |
| top-level / `com/lmax/disruptor/RewindableException.java` | `` |  |  |
| top-level / `com/lmax/disruptor/RewindAction.java` | `` |  |  |
| top-level / `com/lmax/disruptor/RewindHandler.java` | `` |  |  |
| top-level / `com/lmax/disruptor/RhsPadding.java` | `` |  |  |
| top-level / `com/lmax/disruptor/RingBuffer.java` | `` |  | createMultiProducer, createMultiProducer, createSingleProducer, createSingleProducer, create, get, next, next, tryNext, tryNext, claimAndGetPreallocated, isAvailable, addGatingSequences, getMinimumGatingSequence, removeGatingSequence, newBarrier, newPoller, getCursor, getBufferSize, hasAvailableCapacity, publishEvent, tryPublishEvent, publishEvent, tryPublishEvent, publishEvent, tryPublishEvent, publishEvent, tryPublishEvent, publishEvent, tryPublishEvent, publishEvents, publishEvents, tryPublishEvents, tryPublishEvents, publishEvents, publishEvents, tryPublishEvents, tryPublishEvents, publishEvents, publishEvents, tryPublishEvents, tryPublishEvents, publishEvents, publishEvents, tryPublishEvents, tryPublishEvents, publishEvents, publishEvents, tryPublishEvents, tryPublishEvents, publish, publish, remainingCapacity, checkBounds, checkBatchSizing, checkBounds, checkBounds, checkBounds, checkBounds, batchOverRuns, translateAndPublish, translateAndPublish, translateAndPublish, translateAndPublish, translateAndPublish, translateAndPublishBatch, translateAndPublishBatch, translateAndPublishBatch, translateAndPublishBatch, translateAndPublishBatch, toString |
| top-level / `com/lmax/disruptor/RingBufferFields.java` | `` |  | fill, elementAt |
| top-level / `com/lmax/disruptor/RingBufferPad.java` | `` |  |  |
| top-level / `com/lmax/disruptor/Sequence.java` | `` |  | get, set, setVolatile, compareAndSet, incrementAndGet, addAndGet, getAndAdd, toString |
| top-level / `com/lmax/disruptor/SequenceBarrier.java` | `` |  |  |
| top-level / `com/lmax/disruptor/Sequenced.java` | `` |  |  |
| top-level / `com/lmax/disruptor/SequenceGroup.java` | `` |  | get, set, add, remove, size, addWhileRunning |
| top-level / `com/lmax/disruptor/SequenceGroups.java` | `` |  | countMatching |
| top-level / `com/lmax/disruptor/Sequencer.java` | `` |  |  |
| top-level / `com/lmax/disruptor/SimpleBatchRewindStrategy.java` | `` |  | handleRewindException |
| top-level / `com/lmax/disruptor/SingleProducerSequencer.java` | `` |  | hasAvailableCapacity, hasAvailableCapacity, next, next, tryNext, tryNext, remainingCapacity, claim, publish, publish, isAvailable, getHighestPublishedSequence, toString, sameThread, isSameThreadProducingTo |
| top-level / `com/lmax/disruptor/SingleProducerSequencerFields.java` | `` |  |  |
| top-level / `com/lmax/disruptor/SingleProducerSequencerPad.java` | `` |  |  |
| top-level / `com/lmax/disruptor/SleepingWaitStrategy.java` | `` |  | waitFor, signalAllWhenBlocking, applyWaitMethod |
| top-level / `com/lmax/disruptor/TimeoutBlockingWaitStrategy.java` | `` |  | waitFor, signalAllWhenBlocking, toString |
| top-level / `com/lmax/disruptor/TimeoutException.java` | `` |  | fillInStackTrace |
| top-level / `com/lmax/disruptor/util/DaemonThreadFactory.java` | `` |  | newThread |
| top-level / `com/lmax/disruptor/util/ThreadHints.java` | `` |  | onSpinWait |
| top-level / `com/lmax/disruptor/util/Util.java` | `` |  | ceilingNextPowerOfTwo, getMinimumSequence, getMinimumSequence, getSequencesFor, log2, awaitNanos |
| top-level / `com/lmax/disruptor/Value.java` | `` |  |  |
| top-level / `com/lmax/disruptor/WaitStrategy.java` | `` |  |  |
| top-level / `com/lmax/disruptor/YieldingWaitStrategy.java` | `` |  | waitFor, signalAllWhenBlocking, applyWaitMethod |
| top-level / `me/decce/asynclogger/AsyncLoggerMod.java` | `` |  | init |
| top-level / `me/decce/asynclogger/constants/Constants.java` | `` |  |  |
| top-level / `me/decce/asynclogger/core/AsyncFilter.java` | `` |  | resultOf, filter, filter, filter, filter, filter, filter, filter, filter, filter, filter, filter, filter, filter, filter |
| top-level / `me/decce/asynclogger/core/AsyncLogger.java` | `` |  | compileFilters |
| top-level / `me/decce/asynclogger/core/AsyncLoggerConfig.java` | `` |  |  |
| top-level / `me/decce/asynclogger/core/FilterImpl.java` | `` |  | checkLevel, checkLogger, checkStrings, checkStringsSafe, checkRegexes, checkRegexesSafe, checkMessage, filter, filter, filter, filter, filter |
| top-level / `me/decce/asynclogger/core/FilteringInfo.java` | `` |  | toString, hashCode, equals, levels, loggers, strings, regexes |
| top-level / `me/decce/asynclogger/core/LoggerConfigurator.java` | `` |  | configure, copyList, copyMap, configureRootLogger, configureDebugLog, configureFilter, configureSysOutErr |
| top-level / `me/decce/asynclogger/core/LoggerTester.java` | `` |  | testAll, warmup, testString, testPlaceholder, testThrowable, elapsedTimeInMs, toString, hashCode, equals, item, elapsedNanos, toString |
| top-level / `me/decce/asynclogger/core/sysout/FilteringPrintStream.java` | `` |  | nullOutputStream, write, print, println, println |
| top-level / `me/decce/asynclogger/core/sysout/RedirectingPrintStream.java` | `` |  | wrappedPrint, print, println, println, format, format, flushBuffer |
| top-level / `me/decce/asynclogger/core/sysout/WrappedPrintStream.java` | `` |  | print, print, print, print, print, print, print, print, println, println, println, println, println, println, println, println |
| top-level / `me/decce/asynclogger/fabric/FabricEntrypoint.java` | `` |  | onInitialize |
| top-level / `me/decce/asynclogger/mixins/ClientMainMixin.java` | `value={Main.class})` |  |  |
| top-level / `me/decce/asynclogger/mixins/ServerMainMixin.java` | `value={Main.class})` |  |  |
| top-level / `me/decce/asynclogger/service/Bootstrapper.java` | `` |  | bootstrap, initConfig |
| top-level / `me/decce/asynclogger/service/ClassLoaderHandlerImpl.java` | `` |  | removeModClassesFromServiceLayer, walkResource, close |
| top-level / `me/decce/asynclogger/service/ConfigLoader.java` | `` |  | makeNightConfig, save, load, loadConfig, loadExtras, readExtras, combineLists, toNightConfig, fromNightConfig |
| top-level / `me/decce/asynclogger/service/fabric/FabricLanguageAdapter.java` | `` |  | create |
| top-level / `me/decce/asynclogger/service/fabric/FabricPreLaunchEntrypoint.java` | `` |  | onPreLaunch |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/AbstractCommentedConfig.java` | `` |  | getDefaultCommentMap, getComment, setComment, removeComment, containsComment, commentMap, entrySet, clear, clearComments, getPath, getComment, setComment, removeComment, equals, hashCode, toString |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/AbstractConfig.java` | `` |  | getDefaultMapCreator, getWildcardMapCreator, getRaw, set, add, remove, contains, isNull, getOrCreateMap, getMap, clear, size, valueMap, entrySet, hashCode, equals, toString, getKey, getRawValue, setValue, equals, hashCode |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/CheckedCommentedConfig.java` | `` |  | checked, set, add, valueMap, entrySet, toString, checkValue, checkedValue |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/CheckedConfig.java` | `` |  | checked, set, add, valueMap, entrySet, toString, checkValue, checkedValue |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/CommentedConfig.java` | `` |  | getRaw, getComment, contains, containsComment, size, valueMap, commentMap, getComments, entrySet, configFormat, of, of, ofConcurrent, inMemory, inMemoryConcurrent, wrap, copy, copy, copy, copy, copy, copy, copy, copy, concurrentCopy, concurrentCopy, concurrentCopy, concurrentCopy, fake |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/concurrent/ConcurrentCommentedConfig.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/concurrent/ConcurrentConfig.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/concurrent/StampedConfig.java` | `` |  | replaceContentBy, replaceContentBy, newAccumulator, newAccumulatorCopy, copyValueInAccumulator, mapLockGet, mapLockContains, mapLockRemove, mapLockPut, mapLockPutIfAbsent, getExistingConfig, getOrCreateConfig, size, createSubConfig, configFormat, valueMap, clear, getRaw, contains, add, remove, set, convertSubConfigs, convertValue, putAll, unsafePutAll, unsafeRemoveAll, removeAll, clearComments, removeComment, setComment, containsComment, getComment, commentMap, putAllComments, putAllComments, equals, toString, entrySet, checkStateForBulkOp, checkStateForNormalOp, bulkRead, bulkUpdate, bulkCommentedRead, bulkCommentedUpdate, clear, containsKey, containsValue, entrySet, size, isEmpty, contains, getKey, getRawValue, iterator, hasNext, next, getKey, getValue, setValue, remove, toArray, toArray, add, remove, containsAll, addAll, retainAll, removeAll, clear, get, isEmpty, keySet, values, put, putAll, remove, size, clear, removeAll, putAll, clearComments, createSubConfig, valueMap, entrySet, getKey, getValue, setValue, remove, removeComment, set, setComment, add, removeComment, setComment, setValue, checkValid, commentMap, entrySet, containsComment, getComment, configFormat, contains, getRaw, size, valueMap, toString, equals, getComment, getKey, getRawValue, checkValid, removeComment, setComment, setValue, getKey, getRawValue, getComment, toString, removeComment, setComment, setValue, getKey, getRawValue, getComment, toString, hasNext, next, remove, forEachRemaining, iterator, size, forEach, add, clear, contains, isEmpty, remove, checkValid, replaceValue, clone, createSubConfig, configFormat |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/concurrent/SynchronizedConfig.java` | `` |  | convert, convert, convertSubConfigs, convertValue, replaceContentBy, replaceContentBy, bulkCommentedRead, bulkCommentedUpdate, add, clearComments, commentMap, removeComment, setComment, containsComment, getComment, configFormat, clear, createSubConfig, entrySet, remove, set, toString, contains, equals, getRaw, hashCode, isEmpty, size, valueMap, add, addAll, putAll, remove, removeAll, set, unmodifiable, update, apply, get, isNull, getComments, getComments, putAllComments, putAllComments, forEachRemaining, hasNext, next, remove, add, addAll, clear, contains, containsAll, isEmpty, iterator, remove, removeAll, retainAll, size, toArray, toArray, removeIf, forEach, equals, hashCode, toString, clear, containsKey, containsValue, entrySet, get, isEmpty, keySet, put, putAll, remove, size, values, clone, createSubConfig, configFormat |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/ConcurrentConfigSpec.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/Config.java` | `` |  | getRaw, contains, size, valueMap, entrySet, configFormat, of, of, ofConcurrent, inMemory, inMemoryUniversal, inMemoryConcurrent, inMemoryUniversalConcurrent, wrap, copy, copy, copy, copy, concurrentCopy, concurrentCopy, isInsertionOrderPreserved, setInsertionOrderPreserved, getDefaultMapCreator, getDefaultMapCreator |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/ConfigCopier.java` | `` |  | deepCopy, deepCopyTo |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/ConfigFormat.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/ConfigSpec.java` | `` |  | define, define, define, define, define, define, defineOfClass, defineOfClass, defineOfClass, defineOfClass, defineInList, defineInList, defineInList, defineInList, defineInRange, defineInRange, defineInRange, defineInRange, defineList, defineList, defineList, defineList, defineEnum, defineEnum, defineEnum, defineEnum, defineRestrictedEnum, defineRestrictedEnum, defineRestrictedEnum, defineRestrictedEnum, undefine, undefine, isDefined, isDefined, isCorrect, isCorrect, isCorrect, isCorrect, correct, correct, correct, correct, correct, handleCorrection, get |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/AbstractConvertedCommentedConfig.java` | `` |  | getComment, containsComment, setComment, removeComment, clearComments, getComments, putAllComments, putAllComments, commentMap, entrySet, getComment, setComment, removeComment, getKey, getRawValue, setValue, createSubConfig |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/AbstractConvertedConfig.java` | `` |  | set, valueMap, getRaw, configFormat, toString |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/AdvancedPath.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/AnnotationUtils.java` | `` |  | checkFieldSpec, checkFieldSpec, checkFieldSpec, checkFieldSpec, checkFieldSpec, checkFieldSpec, checkFieldSpec, checkFieldSpec, checkFieldSpec, checkNotNull, checkClass |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/Conversion.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/ConversionTable.java` | `` |  | put, remove, contains, convert, convertShallow, convertDeep, getConversionFunction, chainThen, wrap, getRaw, valueMap, entrySet, getKey, getRawValue, configFormat, wrapRead, wrapRead, wrapRead, wrapRead, wrapWrite, wrapWrite, wrapWrite, wrapWrite, clone, toString |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/ConvertedCommentedConfig.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/ConvertedCommentedFileConfig.java` | `` |  | getFile, getNioPath, save, load, close, bulkRead, bulkCommentedRead, bulkCommentedUpdate, bulkUpdate, createSubConfig |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/ConvertedConfig.java` | `` |  | entrySet, setValue, getKey, getRawValue |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/ConvertedFileConfig.java` | `` |  | getFile, getNioPath, save, load, close, bulkRead, bulkUpdate, createSubConfig |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/ConvertedFormat.java` | `` |  | createWriter, createParser, createConfig, createConcurrentConfig, createConfig, supportsComments, supportsType |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/Converter.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/ForceBreakdown.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/InvalidValueException.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/ObjectBinder.java` | `` |  | bind, bind, bind, bind, bind, createBoundConfig, convertToField, convertFromField, convertToField, convertFromField, toString, registerField, searchInfosOrConfig, getRaw, contains, set, add, remove, clear, configFormat, createSubConfig, valueMap, entrySet, setValue, getKey, getRawValue, size, toString |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/ObjectConverter.java` | `` |  | toConfig, toConfig, toConfig, toConfig, toObject, toObject, convertToConfig, convertToObject, bottomElementType, detectElementTypes, elementTypes, bottomElementType, convertConfigsToObject, convertObjectsToConfigs, createInstance |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/Path.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/PreserveNotNull.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/ReflectionException.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/SpecClassInArray.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/SpecDoubleInRange.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/SpecEnum.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/SpecFloatInRange.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/SpecIntInRange.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/SpecLongInRange.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/SpecNotNull.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/SpecStringInArray.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/SpecStringInRange.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/conversion/SpecValidator.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/EnumGetMethod.java` | `` |  | isCaseSensitive, isOrdinalOk, get, validate |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/file/AsyncFileConfig.java` | `` |  | saveNow, loadNow, getFile, getNioPath, save, asyncLoad, load, close |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/file/AutoreloadFileConfig.java` | `` |  | autoReload, getFile, getNioPath, save, load, close |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/file/AutosaveCommentedFileConfig.java` | `` |  | autoSave, save, set, add, remove, setComment, removeComment, removeAll, putAll, clear, clearComments, putAllComments, putAllComments, valueMap, commentMap, getFile, getNioPath, load, close, bulkCommentedUpdate, bulkUpdate |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/file/CheckedCommentedFileConfig.java` | `` |  | getNioPath, getFile, save, load, close, bulkCommentedRead, bulkCommentedUpdate, checked, set, add, valueMap, entrySet, toString, checkValue, checkedValue |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/file/CheckedFileConfig.java` | `` |  | getNioPath, getFile, save, load, close, bulkRead, bulkUpdate, checked, set, add, valueMap, entrySet, toString, createSubConfig, checkValue, checkedValue |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/file/CommentedFileConfig.java` | `` |  | of, of, of, of, of, of, ofConcurrent, ofConcurrent, ofConcurrent, ofConcurrent, ofConcurrent, ofConcurrent, builder, builder, builder, builder, builder, builder |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/file/CommentedFileConfigBuilder.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/file/ConfigLoadFilter.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/file/DebouncedRunnable.java` | `` |  | run, andThen |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/file/FileConfig.java` | `` |  | of, of, of, of, of, of, ofConcurrent, ofConcurrent, ofConcurrent, ofConcurrent, ofConcurrent, ofConcurrent, builder, builder, builder, builder, builder, builder |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/file/FileConfigBuilder.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/file/FileNotFoundAction.java` | `` |  | copyData, copyData, copyData, copyData, copyResource |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/file/FileWatcher.java` | `` |  | defaultInstance, addWatch, addWatch, addWatchFuture, setWatch, setWatch, setWatchFuture, addOrPutWatch, removeWatch, removeWatch, removeWatchFuture, removeWatch, stop, stopFuture, failIfStopped, newThread, from, toString, toString, watchDirectory, run |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/file/FormatDetector.java` | `` |  | registerExtension, registerExtension, detect, detect, detectByName, tryLoad |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/file/GenericBuilder.java` | `` |  | charset, writingMode, parsingMode, onFileNotFound, defaultResource, defaultData, defaultData, defaultData, sync, async, asyncWithDebouncing, autosave, autoreload, autoreload, onAutoReload, onAutoSave, onLoad, onSave, onLoadFilter, concurrent, preserveInsertionOrder, backingMapCreator, runnableOrNothing, build, buildAutosave, buildNormal |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/file/NoFormatFoundException.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/file/SyncFileConfig.java` | `` |  | getFile, getNioPath, save, load, close |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/IncompatibleIntermediaryLevelException.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/InMemoryCommentedFormat.java` | `` |  | defaultInstance, withSupport, withUniversalSupport, createWriter, createParser, createConfig, supportsComments, supportsType, isInMemory |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/InMemoryFormat.java` | `` |  | defaultInstance, withSupport, withUniversalSupport, createWriter, createParser, createConfig, supportsComments, supportsType, isInMemory |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/AbstractInput.java` | `` |  | read, readChar, peek, peek, peekChar, peekChar, skipPeeks, pushBack, readUntil, readCharsUntil, consumeDeque |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/AdditionalCharsets.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/ArrayInput.java` | `` |  | directRead, directReadChar, read, readChars |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/CharacterInput.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/CharacterOutput.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/CharsetUnicodeBom.java` | `` |  | canEncode, contains, newDecoder, newEncoder, canEncode, canEncode, isLegalReplacement, implReset, implFlush, encodeLoop, setupDecoder, isAutoDetecting, isCharsetDetected, detectedCharset, implFlush, implReset, decodeLoop |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/CharsWrapper.java` | `` |  | isEmpty, length, charAt, get, set, replaceAll, contains, indexOf, indexOfFirst, equals, equalsIgnoreCase, contentEquals, contentEquals, startsWith, subSequence, subView, subView, trimmedView, toString, hashCode, clone, iterator, hasNext, next, ensureCapacity, append, append, append, append, append, append, append, append, append, append, flush, close, write, write, write, write, write, write, write, length, getChars, get, set, compact, build, build, build, copyAndBuild, copyAndBuild, copyAndBuild, toString, toString, toString |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/ConfigParser.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/ConfigWriter.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/IndentStyle.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/IoUtils.java` | `` |  | tempConfigFileName, retryIfAccessDenied, retryIfAccessDenied |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/NewlineStyle.java` | `` |  | system |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/ParsingException.java` | `` |  | readFailed, notEnoughData |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/ParsingMode.java` | `` |  | prepareParsing, put, put, put |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/ReaderInput.java` | `` |  | directRead, directReadChar, read, readChars |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/Utils.java` | `` |  | arrayContains, arrayIndexOf, parseLong, parseInt, parseDouble |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/WriterOutput.java` | `` |  | write, write, write |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/WritingException.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/io/WritingMode.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/NullObject.java` | `` |  | toString, equals, hashCode |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/AbstractObjectDeserializer.java` | `` |  | deserializeToCollection, deserializeToMap, deserializeFields, deserializeFields, findValueDeserializer, findDefaultValueSupplier |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/AnnotationProcessor.java` | `` |  | resolveAssertPredicate1, resolveSkipDeserializingIfPredicate1, resolveSkipSerializingIfPredicate1, pedicateFromField, combineOr, combineAnd, findCustomPredicate, findFieldOrMethodIn, defaultSupplierFromField, defaultSupplierFromMethod, anyFromField, supplierFromMethod, predicateFromMethod |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/annotations/SerdeAssert.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/annotations/SerdeAssertsContainer.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/annotations/SerdeComment.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/annotations/SerdeCommentsContainer.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/annotations/SerdeDefault.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/annotations/SerdeDefaultsContainer.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/annotations/SerdeKey.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/annotations/SerdePhase.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/annotations/SerdeSkipDeserializingIf.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/annotations/SerdeSkipSerializingIf.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/ConfigToPojoDeserializer.java` | `` |  | deserialize |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/DeserializerContext.java` | `` |  | deserializeValue, deserializeFields, normalizeForDeserialization, configKey, skipField, assertField, preCheck |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/ObjectDeserializer.java` | `` |  | builder, blankBuilder, standard, deserializeToCollection, deserializeToMap, deserializeFields, deserializeFields |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/ObjectDeserializerBuilder.java` | `` |  | build, deserializeTransientFields, withDeserializerForClass, withDeserializerProvider, withDefaultDeserializerProvider, withDefaultDeserializerProvider, registerStandardDeserializers, provide |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/ObjectSerializer.java` | `` |  | builder, blankBuilder, standard, serialize, serializeFields, serializeFields |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/ObjectSerializerBuilder.java` | `` |  | build, withSerializerForExactClass, withSerializerForClass, withSerializerProvider, withDefaultSerializerProvider, withDefaultSerializerProvider, serializeTransientFields, registerStandardSerializers, provide |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/SerdeAssertException.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/SerdeException.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/SerializerContext.java` | `` |  | configFormat, createConfig, createCommentedConfig, serializeValue, serializeFields, configKey, configComment, skipField, assertField, preCheck |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/StandardDeserializers.java` | `` |  | isNumberTypeSupported, deserialize, deserialize, deserialize, deserialize, deserialize, createCollectionInstance, extractCollectionValueType, deserialize, extractMapKVType, createMapInstance, deserialize |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/StandardSerializers.java` | `` |  | serialize, serialize, serialize, serialize, serialize, serialize, serialize, serialize |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/TypeConstraint.java` | `` |  | getFullType, getSatisfyingRawType, resolveTypeArgumentsFor, toString, findSatisfyingRawType, resolveTypeArgumentsFor, resolveIfVariable, findParent, wildcardLowerBound, wildcardUpperBound, getActualTypeArguments, getOwnerType, getRawType, toString, equals, getLowerBounds, getUpperBounds, toString, equals, hashCode |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/Util.java` | `` |  | isEmptyWithReflection, toString, classOrNull |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/ValueDeserializer.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/ValueDeserializerProvider.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/ValueSerializer.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/serde/ValueSerializerProvider.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/SimpleCommentedConfig.java` | `` |  | configFormat, createSubConfig, clone |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/SimpleConfig.java` | `` |  | configFormat, createSubConfig, clone |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/UnmodifiableCommentedConfig.java` | `` |  | fake, getComment, getChildren |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/UnmodifiableConfig.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/AbstractObserved.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/CommentedConfigWrapper.java` | `` |  | getComment, containsComment, setComment, removeComment, commentMap, entrySet, clearComments, putAllComments, putAllComments, getComments, createSubConfig, toString |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/ConcurrentCommentedConfigWrapper.java` | `` |  | createSubConfig, bulkRead, bulkRead, bulkCommentedRead, bulkCommentedRead, bulkUpdate, bulkUpdate, bulkCommentedUpdate, bulkCommentedUpdate |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/ConfigWrapper.java` | `` |  | entrySet, set, add, remove, clear, createSubConfig, toString |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/FakeCommentedConfig.java` | `` |  | unwrap, getComment, containsComment, setComment, removeComment, clearComments, getComments, putAllComments, putAllComments, commentMap, entrySet, createSubConfig, getComment, getKey, getRawValue, setComment, removeComment, setValue |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/FakeUnmodifiableCommentedConfig.java` | `` |  | getComment, containsComment, getComments, commentMap, entrySet, getComment, getKey, getRawValue |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/FastStringReader.java` | `` |  | read, read, skip, markSupported, mark, reset, ready, close |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/IntDeque.java` | `` |  | isPowerOfTwo, nextPowerOfTwo, clear, isEmpty, size, compact, grow, addFirst, addLast, get, getFirst, getLast, removeFirst, removeLast |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/ObservedEntry.java` | `` |  | getKey, getValue, setValue, equals, hashCode |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/ObservedIterator.java` | `` |  | hasNext, next, remove, forEachRemaining, equals, hashCode |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/ObservedMap.java` | `` |  | size, isEmpty, containsKey, containsValue, get, put, remove, putAll, replaceAll, putIfAbsent, remove, replace, replace, computeIfAbsent, computeIfPresent, compute, merge, clear, keySet, values, entrySet, equals, hashCode |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/ObservedSet.java` | `` |  | size, isEmpty, contains, iterator, toArray, toArray, add, remove, containsAll, addAll, retainAll, removeAll, clear, removeIf, equals, hashCode |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/ObservedSet2.java` | `` |  | size, isEmpty, contains, iterator, toArray, toArray, add, remove, containsAll, addAll, retainAll, removeAll, clear, removeIf, equals, hashCode |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/StringUtils.java` | `` |  | split, split, splitLines, splitLines |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/TransformingCollection.java` | `` |  | size, isEmpty, contains, iterator, toArray, toArray, add, remove, containsAll, addAll, removeAll, removeIf, retainAll, clear, spliterator, stream, parallelStream, forEach, hashCode, equals, toString |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/TransformingIterator.java` | `` |  | hasNext, next, remove, forEachRemaining, hashCode, equals, toString |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/TransformingList.java` | `` |  | addAll, get, set, add, remove, indexOf, lastIndexOf, listIterator, listIterator, subList |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/TransformingListIterator.java` | `` |  | hasPrevious, previous, nextIndex, previousIndex, set, add |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/TransformingMap.java` | `` |  | size, isEmpty, containsKey, containsValue, get, put, remove, putAll, clear, keySet, values, entrySet, getOrDefault, forEach, replaceAll, putIfAbsent, remove, replace, replace, computeIfAbsent, computeIfPresent, compute, merge, transform, transform2 |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/TransformingMapEntry.java` | `` |  | getKey, getValue, setValue, equals, hashCode |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/TransformingSet.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/TransformingSpliterator.java` | `` |  | tryAdvance, forEachRemaining, trySplit, estimateSize, getExactSizeIfKnown, characteristics, hasCharacteristics, getComparator, hashCode, equals, toString |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/UnmodifiableConfigWrapper.java` | `` |  | getRaw, valueMap, entrySet, contains, size, isEmpty, equals, hashCode, configFormat |
| top-level / `me/decce/asynclogger/shadow/nightconfig/core/utils/WriterSupplier.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/toml/ArrayParser.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/toml/ArrayWriter.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/toml/StringParser.java` | `` |  | buildMultilineString, unescape, parseUnicodeCodepoint, isWhitespace |
| top-level / `me/decce/asynclogger/shadow/nightconfig/toml/StringWriter.java` | `` |  | writeBasicChar |
| top-level / `me/decce/asynclogger/shadow/nightconfig/toml/TableParser.java` | `` |  | checkDuplicateKeyBecauseOfParents, checkDuplicateKey |
| top-level / `me/decce/asynclogger/shadow/nightconfig/toml/TableWriter.java` | `` |  | writeWithHeader, writeSubTables, writeArraysOfTables, writeTableArrayName, writeTableName, writeTableName, toString |
| top-level / `me/decce/asynclogger/shadow/nightconfig/toml/TemporalParser.java` | `` |  | parseDate, parseTime |
| top-level / `me/decce/asynclogger/shadow/nightconfig/toml/TemporalWriter.java` | `` |  | writeDate, writeHour, writePadded, writePaddedAndTrimmed |
| top-level / `me/decce/asynclogger/shadow/nightconfig/toml/Toml.java` | `` |  |  |
| top-level / `me/decce/asynclogger/shadow/nightconfig/toml/TomlFormat.java` | `` |  | instance, newConfig, newConfig, newConcurrentConfig, createWriter, createParser, createConfig, supportsComments, supportsType |
| top-level / `me/decce/asynclogger/shadow/nightconfig/toml/TomlParser.java` | `` |  | clearParsingState, parse, parse, parse, getSubTable, checkContainsOnlySubtables, isLenientWithSeparators, setLenientWithSeparators, isLenientWithBareKeys, setLenientWithBareKeys, setInitialStringBuilderCapacity, setInitialListCapacity, getFormat |
| top-level / `me/decce/asynclogger/shadow/nightconfig/toml/TomlWriter.java` | `` |  | write, isHidingRedundantLevels, setHideRedundantLevels, isOmitIntermediateLevels, setOmitIntermediateLevels, isLenientWithBareKeys, setLenientWithBareKeys, setWriteTableInlinePredicate, setWriteStringLiteralPredicate, setWriteStringMultilinePredicate, setIndentArrayElementsPredicate, setIndent, setIndent, setNewline, setNewline |
| top-level / `me/decce/asynclogger/shadow/nightconfig/toml/ValueParser.java` | `` |  | shouldBeTemporal, parseNumber, isDigitChar, simplifyNumber, parseFalse, parseTrue |
| top-level / `me/decce/asynclogger/shadow/nightconfig/toml/ValueWriter.java` | `` |  | writeString |
| top-level / `me/decce/asynclogger/transform/ClassLoaderHandler.java` | `` |  | toClassName, loadCoreClasses, getClassesStream, walkResource, loadClass, expandModuleReads, close |
| top-level / `me/decce/asynclogger/util/ClassLoaderHelper.java` | `` |  | defineClass, isClassLoaded |
| top-level / `me/decce/asynclogger/util/ImplLookupAccessor.java` | `` |  | getImplLookup, getImplLookupJava8, getImplLookupJavaLatest |
| top-level / `me/decce/asynclogger/util/JavaHelper.java` | `` |  | major |
| top-level / `me/decce/asynclogger/util/ModuleHelper.java` | `` |  | getModuleOfClass, implAddReadsAllUnnamed |
| top-level / `me/decce/asynclogger/util/ReflectionHelper.java` | `` |  | unchecked, unreflect, unreflectOrNull, unreflectGetter |
| top-level / `META-INF/versions/17/me/decce/asynclogger/shadow/nightconfig/core/serde/ConfigToPojoDeserializer.java` | `` |  | deserialize, deserializeToNormalClass, deserializeToRecord, getCanonicalRecordConstructor |
| top-level / `META-INF/versions/17/me/decce/asynclogger/shadow/nightconfig/core/serde/ObjectDeserializer.java` | `` |  | builder, blankBuilder, standard, deserializeToCollection, deserializeToMap, deserializeFields, deserializeFields, deserializeToRecord |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
