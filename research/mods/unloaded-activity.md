# Unloaded Activity

Review status: **Evidence inventory; behavioral review pending**

Project: [Unloaded Activity](https://modrinth.com/mod/unloaded-activity)
Selected artifact version: `0.7.3+26.3`
Published implementation source: https://github.com/KeMoonoDev/Unloaded-Activity
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Simulates blocks and entities to catch up after being unloaded for a period of time.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `7d3e95f88503063e149081b316c5b7acea462d91c21926c99e16f8e1ff12d6e33f191559e21945d946c3c39fc7290e04d10a2148b2914674e0bb3814ca8bba57`
- `sha1`: `01e4d55d36ae4661a4e8030c55ca09f158e0956b`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 197
Reconstructed Java files: 144

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "dev.moono.unloadedactivity.fabric.UnloadedActivityFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": "*",
  "minecraft": "26.3",
  "java": ">=17"
}
```

**accessWidener**

```json
"unloadedactivityofficial.accesswidener"
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/fabric-api-base-2.0.6+fcdff87f5d.jar` | 17 | `fabric-api-base` | No |
| `META-INF/jars/fabric-command-api-v2-3.1.2+fcdff87f5d.jar` | 23 | `fabric-command-api-v2` | No |
| `META-INF/jars/fabric-lifecycle-events-v1-4.1.9+ffef5f675d.jar` | 89 | `fabric-lifecycle-events-v1` | No |
| `META-INF/jars/fabric-resource-loader-v1-3.0.4+fcdff87f5d.jar` | 77 | `fabric-resource-loader-v1` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/moono/unloadedactivity/api/ActiveGroupSimulateData.java` | `` |  | getGroupMemberInfo, getSimulationMethod, getRemainingUpdates, addUpdateCount, getCurrentUpdateCount, getState, updateAndGetProbability, passTicks, updateBlockInfo, invalidateAllCaches, isIgnored, invalidateAndFixCaches, getGroupSum, getGroupCount, getGroupHigherValueCount, getGroupLowerValueCount, getGroupEqualValueCount, getGroupRandomHigherValue, getGroupRandomHigherOrEqualValue, getGroupRandomLowerValue, getGroupRandomLowerOrEqualValue, getGroupRandomNotEqualValue |
| top-level / `dev/moono/unloadedactivity/api/condition/Condition.java` | `` |  | Condition, isValid, canBeAffectedByWeather, isRandom, canBeAffectedByTime, getNextConditionSwitchDuration, parse |
| top-level / `dev/moono/unloadedactivity/api/condition/FixedCondition.java` | `` |  | isValid, isValidFixed, isValidFixed, isValidFixed, isValidFixed |
| top-level / `dev/moono/unloadedactivity/api/condition/RandomizedCondition.java` | `` |  | isValid, isValidRandomized, isValidRandomized, isValidRandomized, isValidRandomized |
| top-level / `dev/moono/unloadedactivity/api/condition/UpdatingCondition.java` | `` |  | isValid, isValidUpdating, isValidUpdating, isValidUpdating, isValidUpdating |
| top-level / `dev/moono/unloadedactivity/api/context/ExpressionContext.java` | `` |  | fixed, updating, randomized, getRandomSource, getCurrentTime, isRaining, isThundering, getLevel, getServerLevel, getBlockState, getBlockPos, getNumberMap, getGroupSimulateData, getGameRules |
| top-level / `dev/moono/unloadedactivity/api/context/FixedContext.java` | `` |  | of, of, of, of |
| top-level / `dev/moono/unloadedactivity/api/context/RandomizedContext.java` | `` |  | of, of, of, of |
| top-level / `dev/moono/unloadedactivity/api/context/TimeDependantContext.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/api/context/UpdatingContext.java` | `` |  | of, of, of, of |
| top-level / `dev/moono/unloadedactivity/api/context/WeatherDependantContext.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/api/number_fetcher/FixedNumberFetcher.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/api/number_fetcher/NumberFetcher.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/api/number_fetcher/RandomizedNumberFetcher.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/api/number_fetcher/TimeDependantNumberFetcher.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/api/number_fetcher/WeatherAndTimeDependantNumberFetcher.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/api/number_fetcher/WeatherDependantNumberFetcher.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/api/NumberFetcherRegistry.java` | `` |  | register, register, registerNumber, getNumber, resolve, resolve |
| top-level / `dev/moono/unloadedactivity/api/OccurrencesAndTimings.java` | `` |  | OccurrencesAndTimings, empty, fastDuration, getTimeAtOccurrence, getFinalTime |
| top-level / `dev/moono/unloadedactivity/api/SimulatedTime.java` | `` |  | SimulatedTime, fromLastMs, fromLastTick, fromRemainingMs, fromRemainingTicks, remainingMs, currentMs, currentTick, passTicks, subTicks |
| top-level / `dev/moono/unloadedactivity/api/simulation_method/GroupableSimulationMethod.java` | `` |  | simulatesWithGroup, getNewBlockStates, simulate |
| top-level / `dev/moono/unloadedactivity/api/simulation_method/SeparableSimulationMethod.java` | `` |  | canDoMore, probabilityMultiplier, simulate |
| top-level / `dev/moono/unloadedactivity/api/simulation_method/SimulationMethod.java` | `` |  | simulatesWithGroup, hasValidConditions, canSimulate, shouldCalculateDuration |
| top-level / `dev/moono/unloadedactivity/api/SimulationConfig.java` | `` |  | merge, isDefined, getValue, getList, getMap, getNumberNullable, getNumber, getNumberOrDefault, getNumberList, getNumberMap, getBooleanNullable, getBoolean, getBooleanOrDefault, getBooleanList, getBooleanMap, getStringNullable, getString, getStringOrDefault, getStringList, getStringMap, getBlockNullable, getBlock, getBlockOrDefault, getBlockList, getBlockMap, getEntityTypeNullable, getEntityType, getEntityTypeOrDefault, getEntityTypeList, getEntityTypeMap, getFixedNumberExpressionNullable, getFixedNumberExpression, getFixedNumberExpressionOrDefault, getFixedNumberExpressionList, getFixedNumberExpressionMap, getUpdatingNumberExpressionNullable, getUpdatingNumberExpression, getUpdatingNumberExpressionOrDefault, getUpdatingNumberExpressionList, getUpdatingNumberExpressionMap, getRandomizedNumberExpressionNullable, getRandomizedNumberExpression, getRandomizedNumberExpressionOrDefault, getRandomizedNumberExpressionList, getRandomizedNumberExpressionMap, getFixedStringExpressionNullable, getFixedStringExpression, getFixedStringExpressionOrDefault, getFixedStringExpressionList, getFixedStringExpressionMap, getUpdatingStringExpressionNullable, getUpdatingStringExpression, getUpdatingStringExpressionOrDefault, getUpdatingStringExpressionList, getUpdatingStringExpressionMap, getRandomizedStringExpressionNullable, getRandomizedStringExpression, getRandomizedStringExpressionOrDefault, getRandomizedStringExpressionList, getRandomizedStringExpressionMap, getFixedBlockExpressionNullable, getFixedBlockExpression, getFixedBlockExpressionOrDefault, getFixedBlockExpressionList, getFixedBlockExpressionMap, getUpdatingBlockExpressionNullable, getUpdatingBlockExpression, getUpdatingBlockExpressionOrDefault, getUpdatingBlockExpressionList, getUpdatingBlockExpressionMap, getRandomizedBlockExpressionNullable, getRandomizedBlockExpression, getRandomizedBlockExpressionOrDefault, getRandomizedBlockExpressionList, getRandomizedBlockExpressionMap, getFixedConditionNullable, getFixedCondition, getFixedConditionOrDefault, getFixedConditionList, getFixedConditionMap, getUpdatingConditionNullable, getUpdatingCondition, getUpdatingConditionOrDefault, getUpdatingConditionList, getUpdatingConditionMap, getRandomizedConditionNullable, getRandomizedCondition, getRandomizedConditionOrDefault, getRandomizedConditionList, getRandomizedConditionMap, getConfigNullable, getConfig, getConfigOrDefault, getConfigList, getConfigMap, throwIfNull |
| top-level / `dev/moono/unloadedactivity/api/SimulationMethodConstructor.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/api/SimulationMethodRegistry.java` | `` |  | register, get |
| top-level / `dev/moono/unloadedactivity/api/UnloadedActivityApi.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/api/value_expression/FixedValueExpression.java` | `` |  | evaluate, evaluateFixed, evaluateFixed, evaluateFixed, evaluateFixed |
| top-level / `dev/moono/unloadedactivity/api/value_expression/RandomizedValueExpression.java` | `` |  | evaluate, evaluateRandomized, evaluateRandomized, evaluateRandomized, evaluateRandomized |
| top-level / `dev/moono/unloadedactivity/api/value_expression/UpdatingValueExpression.java` | `` |  | evaluate, evaluateUpdating, evaluateUpdating, evaluateUpdating, evaluateUpdating, getNextValueSwitchDuration, getNextValueSwitchDuration, getNextValueSwitchDuration, getNextValueSwitchDuration, getNextValueSwitchDuration |
| top-level / `dev/moono/unloadedactivity/api/value_expression/ValueExpression.java` | `` |  | parseNumber, parseNumberNullable, parseString, parseStringNullable |
| top-level / `dev/moono/unloadedactivity/api/weather_history/WeatherHistory.java` | `` |  | getWeatherList, shouldCheckForRain, updateValues, getWeatherAtTime, getNextWeatherChangeDuration |
| top-level / `dev/moono/unloadedactivity/api/weather_history/WeatherMsHistory.java` | `` |  | getWeatherStream |
| top-level / `dev/moono/unloadedactivity/api/weather_history/WeatherTickHistory.java` | `` |  | getWeatherStream |
| top-level / `dev/moono/unloadedactivity/config/BlockOrTag.java` | `` |  | equals, hashCode, toString, deserialize, serialize |
| top-level / `dev/moono/unloadedactivity/config/ConfigOption.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/config/UnloadedActivityConfig.java` | `` |  | registerInt, registerFloat, registerBoolean, registerIdList, isBlockBlacklisted, addCommand, addCommand, getSuggestions |
| top-level / `dev/moono/unloadedactivity/datapack/group/GroupInfo.java` | `` |  | getOffsetsWithoutZero, iterateOffsets, computeNext, computeNext, computeNext |
| top-level / `dev/moono/unloadedactivity/datapack/group/GroupInfoResource.java` | `` |  | apply, clearAllGroupInfos, clearAllRawGroupInfos, buildAllGroupInfos, getBlockMemberInfo |
| top-level / `dev/moono/unloadedactivity/datapack/group/GroupMemberInfo.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/datapack/group/IncompleteGroupInfo.java` | `` |  | merge, parse |
| top-level / `dev/moono/unloadedactivity/datapack/group/IncompleteGroupMemberInfo.java` | `` |  | merge, parse |
| top-level / `dev/moono/unloadedactivity/datapack/JsonResourcesCollector.java` | `` |  | prepare |
| top-level / `dev/moono/unloadedactivity/datapack/simulation_data/SimulationData.java` | `` |  | isEmpty |
| top-level / `dev/moono/unloadedactivity/datapack/simulation_data/SimulationDataResource.java` | `` |  | apply, clearAllSimulationData, clearAllRawSimulationData, buildAllSimulationData, getSimulationData, compareJsonPriority |
| top-level / `dev/moono/unloadedactivity/DeferredBlockPlacer.java` | `` |  | empty, iterator, forEach, size, isEmpty, get, lastPlacedBlock, sortListIfNeeded, setBlock, setBlock, setBlock, setBlock, BlockPlacementInfo, SingleBlockPlacement |
| top-level / `dev/moono/unloadedactivity/fabric/GroupInfoResourceFabric.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/fabric/mixin/AbstractFurnaceBlockEntityInvoker.java` | `value={AbstractFurnaceBlockEntity.class})` | Invoker:1 | invokeBurn |
| top-level / `dev/moono/unloadedactivity/fabric/mixin/CropBlockInvoker.java` | `value={CropBlock.class})` | Invoker:1 | invokeGetGrowthSpeed |
| top-level / `dev/moono/unloadedactivity/fabric/platform/FabricPlatformHelper.java` | `` |  | getConfigDirectory, isModLoaded, getGrowthSpeed, burn |
| top-level / `dev/moono/unloadedactivity/fabric/SimulationDataResourceFabric.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/fabric/UnloadedActivityFabric.java` | `` |  | onInitialize |
| top-level / `dev/moono/unloadedactivity/GameUtils.java` | `` |  | parseOffset, getWeatherMsHistory, getWeatherTickHistory, getWeatherHistory, isRainingAtTime, nextWeatherSwitchTickDuration, getEntityTypeRegistry, getBlockRegistry, parseId, createId, getEntityType, getBlockTags, getBlockTags, getBlock, getBlockId, getTime, chunkPosFromWorldPos, isChunkLoaded, getChunk, getRand, toLong, chunkPosFromLong, isValidGourdPosition, canGrow, isFreeHangingStalactite, blocksStalagmiteScan, isUnmergedTipWithDirection, canTipGrow, isValidSpeleothemPlacement, isStalactiteStartPos, findTip, grow, growStalagmiteBelow, getProperty, getCropAge |
| top-level / `dev/moono/unloadedactivity/GroupChunkIndex.java` | `` |  | getLastTick, setLastTick, getLastMs, setLastMs, setPositions, setPositions, getPositions, getAndFilterBlocks |
| top-level / `dev/moono/unloadedactivity/impl/Comparison.java` | `` |  | compare, compare, compare, compare, compare, compare, fromString |
| top-level / `dev/moono/unloadedactivity/impl/ContainerKind.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/impl/FieldType.java` | `` |  | deserialize, deserialize, deserialize, deserialize, deserialize, deserialize, deserialize, deserialize, deserialize, deserialize, deserialize, deserialize, deserialize, deserialize, deserialize, deserialize, deserialize, deserialize |
| top-level / `dev/moono/unloadedactivity/impl/LookupShape.java` | `` |  | fromString |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/AvailableSpaceForGourdValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/BlockBrightnessValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/CustomValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/farmersdelight/CanClimbValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/GrassCanGrowValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/GrassCanStayAliveValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/GroupFetchValue.java` | `` |  | evaluate, evaluate, evaluate, evaluate, evaluate, evaluate, evaluate, evaluate, isRandom, evaluate, isRandom, evaluate, isRandom, evaluate, isRandom, evaluate, isRandom, canBeAffectedByWeather, canBeAffectedByTime, isRandom, getNextValueSwitchDuration, register |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/GrowthSpeedValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/IsBlockMatchValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/IsBlockNeighborsMatchValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/IsDoorHalfValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/IsPrecipitationValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/IsRainingAtValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/IsRainingValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/LocalBrightnessValue.java` | `` |  | test, evaluate, getNextValueSwitchDuration, getNextValueSwitchDurationFromLights, getNextConditionSwitchDuration, getStartArray, getEndArray, getCurrentSkyDarken, getNextSkyDarkenStartDuration, getNextSkyDarkenStopDuration |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/MaxSnowHeightValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/NamedPropertyValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/neapolitan/IsWhiteValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/neapolitan/ShouldBeMoistValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/PropertyValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/RandomValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/RawBrightnessValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/ShouldFreezeValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/ShouldSnowValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/number_fetchers/WaterEvaporatesValue.java` | `` |  | evaluate |
| top-level / `dev/moono/unloadedactivity/impl/Operator.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/impl/simulation_methods/BuddingMethod.java` | `` |  | canDoMore, isDependable, simulate |
| top-level / `dev/moono/unloadedactivity/impl/simulation_methods/DecayMethod.java` | `` |  | isDependable, getMaxUpdateCount, getNewBlockState |
| top-level / `dev/moono/unloadedactivity/impl/simulation_methods/GrowBambooMethod.java` | `` |  | countAirAboveUpToMax, canDoMore, isDependable, shouldCalculateDuration, simulate |
| top-level / `dev/moono/unloadedactivity/impl/simulation_methods/GrowBlockMethod.java` | `` |  | isDependable, shouldCalculateDuration, getMaxUpdateCount, getNewBlockStates, RestrictHeightConfig |
| top-level / `dev/moono/unloadedactivity/impl/simulation_methods/GrowFruitMethod.java` | `` |  | isDependable, getMaxUpdateCount, getNewBlockStates |
| top-level / `dev/moono/unloadedactivity/impl/simulation_methods/GrowTreeMethod.java` | `` |  | canDoMore, isDependable, simulate |
| top-level / `dev/moono/unloadedactivity/impl/simulation_methods/HatchMethod.java` | `` |  | isDependable, shouldCalculateDuration, getMaxUpdateCount, getNewBlockState |
| top-level / `dev/moono/unloadedactivity/impl/simulation_methods/IncrementPropertyGrowthMethod.java` | `` |  | isDependable, shouldCalculateDuration, getMaxUpdateCount, getNewBlockStates |
| top-level / `dev/moono/unloadedactivity/impl/simulation_methods/MaxPropertyGrowthMethod.java` | `` |  | isDependable, shouldCalculateDuration, getMaxUpdateCount, getNewBlockStates, AgeBloomConfig |
| top-level / `dev/moono/unloadedactivity/impl/simulation_methods/neapolitan/GrowBananaMethod.java` | `` |  | getMaxUpdateCount, getNewBlockStates, isDependable |
| top-level / `dev/moono/unloadedactivity/impl/simulation_methods/nomansland/GrowFruitLeavesMethod.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/impl/simulation_methods/nomansland/RotFruitLeavesMethod.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/impl/simulation_methods/nomansland/TapMethod.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/impl/simulation_methods/PropertyMethod.java` | `` |  | hasValidConditions, isDependable, getMaxUpdateCount, getNewBlockState, isInValidState, getMax, getCurrent, set |
| top-level / `dev/moono/unloadedactivity/impl/simulation_methods/ReplaceMethod.java` | `` |  | isDependable, shouldCalculateDuration, getMaxUpdateCount, getNewBlockState |
| top-level / `dev/moono/unloadedactivity/impl/simulation_methods/SpeleothemMethod.java` | `` |  | getMaxGrowthLength, getBottomSearchRange, getBottomStalagmiteDistance, getExtendedCauldronPos, canDoMore, isDependable, simulate, CauldronFillConfig, getCauldronDripProbability, ConvertBlockConfig |
| top-level / `dev/moono/unloadedactivity/impl/simulation_methods/supplementaries/GrowFlaxMethod.java` | `` |  | getMaxUpdateCount, getNewBlockStates, isDependable |
| top-level / `dev/moono/unloadedactivity/impl/SimulationUtils.java` | `` |  | applySetProperties, applySetNamedProperties, setNamedPropertyValue, resultingBlocksMayNeedDuration, anyNeedsDuration, needsDuration |
| top-level / `dev/moono/unloadedactivity/impl/TypeDescriptor.java` | `` |  | TypeDescriptor, is |
| top-level / `dev/moono/unloadedactivity/impl/value_expression/ConditionalValue.java` | `` |  | evaluate, getPossibleValues, canBeAffectedByWeather, canBeAffectedByTime, isRandom, getNextValueSwitchDuration, replicate, replaceSuper, map |
| top-level / `dev/moono/unloadedactivity/impl/value_expression/NumberOperatorValue.java` | `` |  | evaluate, canBeAffectedByWeather, canBeAffectedByTime, isRandom, getNextValueSwitchDuration, replicate, replaceSuper |
| top-level / `dev/moono/unloadedactivity/impl/value_expression/SimpleValue.java` | `` |  | evaluate, getPossibleValues, canBeAffectedByWeather, canBeAffectedByTime, isRandom, getNextValueSwitchDuration, replicate, replaceSuper, map |
| top-level / `dev/moono/unloadedactivity/impl/value_expression/SuperValue.java` | `` |  | evaluate, getPossibleValues, canBeAffectedByWeather, canBeAffectedByTime, isRandom, isSuper, getNextValueSwitchDuration, replicate, replaceSuper, map |
| top-level / `dev/moono/unloadedactivity/impl/value_expression/TimelineValue.java` | `` |  | evaluate, getPossibleValues, canBeAffectedByWeather, isRandom, canBeAffectedByTime, map, getNextValueSwitchDuration, replicate, replaceSuper |
| top-level / `dev/moono/unloadedactivity/interfaces/BlockEntityTimeData.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/interfaces/ChunkIndexQueue.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/interfaces/ChunkTimeData.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/interfaces/SimulateBlockEntity.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/interfaces/SimulateEntity.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/MathUtils.java` | `` |  | getRandomPickProbability, getPrecipitationPickProbability, getOccurrences, getOccurrences, getOccurrences, getOccurrences, getOccurrences, getOccurrences, getOccurrencesWithFastDuration, getOccurrencesWithAccurateDuration, getOccurrencesSimple, sampleNegativeBinomial, sampleNegativeBinomialWithMax, samplePoisson, sampleGamma |
| top-level / `dev/moono/unloadedactivity/mixin/block_entities/AbstractFurnaceBlockEntityMixin.java` | `value={AbstractFurnaceBlockEntity.class})` |  | unloadedactivity$getLitTimeRemaining, unloadedactivity$getLitTotalTime, unloadedactivity$getCookingTimer, unloadedactivity$getCookingTotalTime, unloadedactivity$setLitTimeRemaining, unloadedactivity$setLitTotalTime, unloadedactivity$setCookingTimer, unloadedactivity$setCookingTotalTime, getTotalCookTime, isLit, shouldSimulate, unloadedactivity$simulateTime |
| top-level / `dev/moono/unloadedactivity/mixin/BlockEntityMixin.java` | `value={BlockEntity.class}, priority=999)` | Inject:2 | getLastTick, setLastTick, getLastMs, setLastMs, save, load |
| top-level / `dev/moono/unloadedactivity/mixin/BoundTickingBlockEntityMixin.java` | `targets={"net.minecraft.world.level.chunk.LevelChunk$BoundTickingBlockEntity"})` | Inject:1 | blockEntityTick |
| top-level / `dev/moono/unloadedactivity/mixin/ChunkAccessMixin.java` | `value={ChunkAccess.class})` |  | getLastTick, setLastTick, getLastMs, setLastMs, getSimulationVersion, setSimulationVersion, getGroupIndexes, setGroupIndexes, getSimulationBlocks, setSimulationBlocks, addSimulationBlock, removeSimulationBlock |
| top-level / `dev/moono/unloadedactivity/mixin/ChunkSerializerMixin.java` | `value={SerializableChunkData.class}, priority=999)` | Inject:4 | write, read, fromChunk, fromNbt |
| top-level / `dev/moono/unloadedactivity/mixin/CropBlockInvoker.java` | `value={AirBlock.class})` |  |  |
| top-level / `dev/moono/unloadedactivity/mixin/entities/AgeableMobMixin.java` | `value={AgeableMob.class})` |  | getAge, canAgeDown, shouldSimulate, unloadedactivity$simulateTime |
| top-level / `dev/moono/unloadedactivity/mixin/entities/SheepMixin.java` | `value={Sheep.class})` |  | shouldSimulate, unloadedactivity$simulateTime |
| top-level / `dev/moono/unloadedactivity/mixin/EntityMixin.java` | `value={Entity.class}, priority=999)` | Inject:4 | tickMovement, init, save, load |
| top-level / `dev/moono/unloadedactivity/mixin/IntegerPropertyAccessor.java` | `value={IntegerProperty.class})` | Accessor:1 |  |
| top-level / `dev/moono/unloadedactivity/mixin/LevelChunkMixin.java` | `value={LevelChunk.class})` | Inject:2 | blockChanged, initLevelChunk |
| top-level / `dev/moono/unloadedactivity/mixin/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Inject:1 | getNextValidChunk, addChunkToQueueFront, addChunkToQueue, tickChildren |
| top-level / `dev/moono/unloadedactivity/mixin/PointedDripstoneBlockAccessor.java` | `value={PointedDripstoneBlock.class})` | Invoker:1 | unloadedactivity$invokeFindFillableCauldronBelowStalactiteTip |
| top-level / `dev/moono/unloadedactivity/mixin/ServerLevelMixin.java` | `value={ServerLevel.class}, priority=1001)` | Inject:4 | getLevel, tickChunk, getMultiplier, tick, finishTickTime, createState |
| top-level / `dev/moono/unloadedactivity/mixin/SpeleothemBlockAccessor.java` | `value={SpeleothemBlock.class})` | Accessor:1, Invoker:11 | unloadedactivity$getMaxStalagmiteSearchRangeWhenGrowing, unloadedactivity$invokeIsStalactiteStartPos, unloadedactivity$invokeFindTip, unloadedactivity$invokeIsFreeHangingStalactite |
| top-level / `dev/moono/unloadedactivity/neoforge/mixin/AbstractFurnaceBlockEntityInvoker.java` | `value={AbstractFurnaceBlockEntity.class})` | Invoker:1 | invokeBurn |
| top-level / `dev/moono/unloadedactivity/neoforge/mixin/CropBlockInvoker.java` | `value={CropBlock.class})` | Invoker:1 | invokeGetGrowthSpeed |
| top-level / `dev/moono/unloadedactivity/neoforge/mixin/EndDataPackReloadMixin.java` | `value={MinecraftServer.class})` | Inject:1 | endResourceReload |
| top-level / `dev/moono/unloadedactivity/neoforge/NeoForgeEventHandler.java` | `` |  | onServerStarted, onServerStopping, onChunkLoad, onRegisterCommands, onAddReloadListener |
| top-level / `dev/moono/unloadedactivity/neoforge/platform/NeoForgePlatformHelper.java` | `` |  | getConfigDirectory, isModLoaded, getGrowthSpeed, burn |
| top-level / `dev/moono/unloadedactivity/neoforge/UnloadedActivityNeoForge.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/platform/IPlatformHelper.java` | `` |  |  |
| top-level / `dev/moono/unloadedactivity/registrations/DefaultRegistrations.java` | `` |  | registerNumberFetchers, registerSimulationMethods |
| top-level / `dev/moono/unloadedactivity/registrations/FarmersDelightRegistrations.java` | `` |  | registerNumberFetchers, registerSimulationMethods |
| top-level / `dev/moono/unloadedactivity/registrations/NeapolitanRegistrations.java` | `` |  | registerNumberFetchers, registerSimulationMethods |
| top-level / `dev/moono/unloadedactivity/registrations/NoMansLandRegistrations.java` | `` |  | registerNumberFetchers, registerSimulationMethods |
| top-level / `dev/moono/unloadedactivity/registrations/SupplementariesRegistrations.java` | `` |  | registerNumberFetchers, registerSimulationMethods |
| top-level / `dev/moono/unloadedactivity/TimeMachine.java` | `` |  | simulateChunk, isChunkIndexed, indexChunk, getRandomTickableBlocks, getPrecipitationTickableBlocks, simulateGroupTicks, generateActiveGroupDataMap, separateToIsolatedGroups, simulateTicks, simulateBlock, simulateBlockEntity, simulateEntity |
| top-level / `dev/moono/unloadedactivity/UnloadedActivity.java` | `` |  | init, init, loadRegistries, loadConfig, saveConfig, id, parseId, shouldDoCompat, addChunkToQueue, dataPackReloaded |
| top-level / `dev/moono/unloadedactivity/UnloadedActivityCommand.java` | `` |  | register, addConfigs, addBenchmark |

## Data-driven behavior

Resource category counts: `simulate_info`: 93, `tags`: 8.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
