# Console Spam Fix : Reborn

Review status: **Evidence inventory; behavioral review pending**

Project: [Console Spam Fix : Reborn](https://modrinth.com/mod/console-spam-fix-reborn)
Selected artifact version: `2.1.0`
Published implementation source: https://github.com/At87668/ConsoleSpamFixReborn
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A log filter that hide configured messages or errors from console and logs.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unknown`. Server support: `unknown`.

Artifact identity:
- `sha1`: `ef0cc77c66b8b398d87cbc5fc0c4259209bdeb79`
- `sha512`: `a9d9f47430d051ac22d4e4ca2c6147c698d5b24a3f3ce89afa19d15ad842253ad793a3df17902df83b4942e188076b78373b8943accea3e5e066fcced3715b06`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 851
Reconstructed Java files: 488

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "server": [
    "link.star_dust.consolefix.fabric.FabricCSF"
  ],
  "client": [
    "link.star_dust.consolefix.fabric.FabricClientCSF"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.14.0",
  "fabric-api": "*",
  "java": ">=17"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/leangen/geantyref/AnnotatedArrayTypeImpl.java` | `` |  | getAnnotatedGenericComponentType, equals, hashCode, toString |
| top-level / `io/leangen/geantyref/AnnotatedCaptureType.java` | `` |  |  |
| top-level / `io/leangen/geantyref/AnnotatedCaptureTypeImpl.java` | `` |  | getDeclaredAnnotations, getAnnotatedUpperBounds, setAnnotatedUpperBounds, getAnnotatedLowerBounds, getAnnotatedTypeVariable, getAnnotatedWildcardType |
| top-level / `io/leangen/geantyref/AnnotatedParameterizedTypeImpl.java` | `` |  | getAnnotatedActualTypeArguments, equals, hashCode, toString |
| top-level / `io/leangen/geantyref/AnnotatedTypeImpl.java` | `` |  | getType, getAnnotation, getAnnotations, getDeclaredAnnotations, equals, hashCode, toString |
| top-level / `io/leangen/geantyref/AnnotatedTypeMap.java` | `` |  | size, isEmpty, containsKey, containsValue, get, put, remove, putAll, clear, keySet, values, entrySet, equals, hashCode, getOrDefault, forEach, replaceAll, putIfAbsent, remove, replace, replace, computeIfAbsent, computeIfPresent, compute, merge |
| top-level / `io/leangen/geantyref/AnnotatedTypeSet.java` | `` |  | size, isEmpty, contains, iterator, toArray, toArray, add, remove, containsAll, addAll, retainAll, removeAll, clear, canonical |
| top-level / `io/leangen/geantyref/AnnotatedTypeVariableImpl.java` | `` |  | getAnnotatedBounds, equals, toString |
| top-level / `io/leangen/geantyref/AnnotatedWildcardTypeImpl.java` | `` |  | getAnnotatedLowerBounds, getAnnotatedUpperBounds, equals, hashCode, toString, validateBounds |
| top-level / `io/leangen/geantyref/AnnotationFormatException.java` | `` |  |  |
| top-level / `io/leangen/geantyref/AnnotationInvocationHandler.java` | `` |  | invoke, annotationType, equals, hashCode, toString, calculateHashCode, calculateHashCode |
| top-level / `io/leangen/geantyref/CaptureType.java` | `` |  |  |
| top-level / `io/leangen/geantyref/CaptureTypeImpl.java` | `` |  | getLowerBounds, getUpperBounds, setUpperBounds, getTypeVariable, getWildcardType, toString |
| top-level / `io/leangen/geantyref/GenericArrayTypeImpl.java` | `` |  | getGenericComponentType, equals, hashCode, toString |
| top-level / `io/leangen/geantyref/GenericTypeReflector.java` | `` |  | erase, box, isFullyBound, mapTypeParameters, mapTypeParameters, resolveExactType, resolveExactType, resolveType, resolveType, resolveType, isMissingTypeParameters, addWildcardParameters, getExactSuperType, getExactSuperType, getExactSubType, getExactSubType, getTypeParameter, getTypeParameter, isSuperType, isArraySupertype, getArrayComponentType, getArrayComponentType, contains, extractVariables, getExactDirectSuperTypes, getArrayExactDirectSuperTypes, getExactReturnType, getExactReturnType, getReturnType, getReturnType, getReturnType, getExactFieldType, getExactFieldType, getFieldType, getFieldType, getFieldType, getExactParameterTypes, getExactParameterTypes, getParameterTypes, getParameterTypes, getParameterTypes, capture, capture, getTypeName, getUpperBoundClassAndInterfaces, annotate, annotate, annotate, annotate, replaceAnnotations, updateAnnotations, mergeAnnotations, replaceParameters, replaceParameters, toCanonical, toCanonicalBoxed, toCanonical, visitClass, visitArray, visitParameterizedType, expandGenerics, visitClass, transform, expandClassGenerics, merge, hashCode, equals, buildUpperBoundClassAndInterfaces, hashCode, equals, hashCode, equals |
| top-level / `io/leangen/geantyref/ParameterizedTypeImpl.java` | `` |  | getRawType, getActualTypeArguments, getOwnerType, equals, hashCode, toString |
| top-level / `io/leangen/geantyref/TypeArgumentNotInBoundException.java` | `` |  | getArgument, getParameter, getBound |
| top-level / `io/leangen/geantyref/TypeFactory.java` | `` |  | parameterizedClass, annotatedClass, parameterizedAnnotatedClass, annotatedInnerClass, parameterizedAnnotatedInnerClass, parameterizedAnnotatedType, innerClass, parameterizedInnerClass, checkParametersWithinBound, couldHaveCommonSubtype, transformOwner, unboundWildcard, wildcardExtends, wildcardSuper, arrayOf, arrayOf, annotation |
| top-level / `io/leangen/geantyref/TypeToken.java` | `` |  | get, get, getType, getAnnotatedType, getCanonicalType, extractType, equals, hashCode |
| top-level / `io/leangen/geantyref/TypeVariableImpl.java` | `` |  | annotateBounds, getBounds, getGenericDeclaration, getName, getAnnotatedBounds, getAnnotation, getAnnotations, getDeclaredAnnotations, equals, hashCode, toString, annotationsString |
| top-level / `io/leangen/geantyref/TypeVisitor.java` | `` |  | visitParameterizedType, visitWildcardType, visitVariable, visitArray, visitCaptureType, visitClass, visitUnmatched, hashCode, equals |
| top-level / `io/leangen/geantyref/UnresolvedTypeVariableException.java` | `` |  |  |
| top-level / `io/leangen/geantyref/VarMap.java` | `` |  |  |
| top-level / `io/leangen/geantyref/WildcardTypeImpl.java` | `` |  | getUpperBounds, getLowerBounds, equals, hashCode, toString |
| top-level / `link/star_dust/bstats/bukkit/Metrics.java` | `` |  | addCustomChart, appendPlatformData, appendServiceData, getPlayerAmount |
| top-level / `link/star_dust/bstats/bungeecord/Metrics.java` | `` |  | loadConfig, writeFile, addCustomChart, appendPlatformData, appendServiceData |
| top-level / `link/star_dust/bstats/charts/AdvancedBarChart.java` | `` |  | getChartData |
| top-level / `link/star_dust/bstats/charts/AdvancedPie.java` | `` |  | getChartData |
| top-level / `link/star_dust/bstats/charts/CustomChart.java` | `` |  | getRequestJsonObject |
| top-level / `link/star_dust/bstats/charts/DrilldownPie.java` | `` |  | getChartData |
| top-level / `link/star_dust/bstats/charts/MultiLineChart.java` | `` |  | getChartData |
| top-level / `link/star_dust/bstats/charts/SimpleBarChart.java` | `` |  | getChartData |
| top-level / `link/star_dust/bstats/charts/SimplePie.java` | `` |  | getChartData |
| top-level / `link/star_dust/bstats/charts/SingleLineChart.java` | `` |  | getChartData |
| top-level / `link/star_dust/bstats/config/MetricsConfig.java` | `` |  | getServerUUID, isEnabled, isLogErrorsEnabled, isLogSentDataEnabled, isLogResponseStatusTextEnabled, didExistBefore, setupConfig, writeConfig, readConfig, getConfigValue, readFile, writeFile |
| top-level / `link/star_dust/bstats/json/JsonObjectBuilder.java` | `` |  | appendNull, appendField, appendField, appendField, appendField, appendField, appendField, appendFieldUnescaped, build, escape, toString |
| top-level / `link/star_dust/bstats/MetricsBase.java` | `` |  | addCustomChart, startSubmitting, submitData, sendData, checkRelocation, compress |
| top-level / `link/star_dust/bstats/velocity/Metrics.java` | `` | Inject:1 | addCustomChart, appendPlatformData, appendServiceData, make |
| top-level / `link/star_dust/consolefix/bukkit/BukkitCsfContext.java` | `` |  | getStringList, getString, getStringWithColor, info, warn, error, reloadConfig, logFilteredMessage |
| top-level / `link/star_dust/consolefix/bukkit/CommandHandler.java` | `` |  | onCommand |
| top-level / `link/star_dust/consolefix/bukkit/ConfigHandler.java` | `` |  | loadConfig, initFilteredLog, checkConfigVersion, getStringList, getString, getStringWithColor, isLogFilteredMessagesEnabled, logFilteredMessage |
| top-level / `link/star_dust/consolefix/bukkit/CSF.java` | `` |  | onEnable, onDisable, getConfigHandler, getEngine, getLogFilterManager, getCsfContext |
| top-level / `link/star_dust/consolefix/bukkit/FoliaCheck.java` | `` |  | isFolia |
| top-level / `link/star_dust/consolefix/bungee/BungeeCommandHandler.java` | `` |  | execute |
| top-level / `link/star_dust/consolefix/bungee/BungeeCSF.java` | `` |  | onEnable, updateLogFilter, getConfigHandler, getEngine, getCsfContext, getDataDirectory |
| top-level / `link/star_dust/consolefix/bungee/BungeeCsfContext.java` | `` |  | getStringList, getString, getStringWithColor, info, warn, error, reloadConfig, logFilteredMessage |
| top-level / `link/star_dust/consolefix/bungee/ConfigHandler.java` | `` |  | loadConfig, initFilteredLog, checkConfigVersion, getStringList, getString, isLogFilteredMessagesEnabled, logFilteredMessage |
| top-level / `link/star_dust/consolefix/common/CommandBridge.java` | `` |  |  |
| top-level / `link/star_dust/consolefix/common/CsfContext.java` | `` |  |  |
| top-level / `link/star_dust/consolefix/common/EngineInterface.java` | `` |  |  |
| top-level / `link/star_dust/consolefix/common/FastStatsCompat.java` | `` |  | create, preSubmissionStart, getProjectName, metricsFactory, create, scheduleAtFixedRate, shutdown, loggerFactory, configPath, create, appendDefaultData |
| top-level / `link/star_dust/consolefix/core/ConfigStore.java` | `` |  | load, getStringList, getString, getBoolean, reload |
| top-level / `link/star_dust/consolefix/core/FastReflection.java` | `` |  | invoke, invokeStatic, get, methodHandle, getterHandle, buildMethodHandle, buildGetterHandle, lookupFor |
| top-level / `link/star_dust/consolefix/core/FilteredLogWriter.java` | `` |  | write, close, nextAvailableFile, parseSequence |
| top-level / `link/star_dust/consolefix/core/LogFilter.java` | `` |  | reloadFilters, compileRegexSafe, checkMessage, getState, initialize, isStarted, isStopped, stop, start, stop, filter, filter, filter, filter, filter, filter, filter, filter, filter, filter, filter, filter, filter, filter, getOnMatch, getOnMismatch |
| top-level / `link/star_dust/consolefix/core/LogFilterManager.java` | `` |  | updateFilter |
| top-level / `link/star_dust/consolefix/core/NewEngine.java` | `` |  | getHiddenMessagesCount, addHiddenMsg, hideConsoleMessages |
| top-level / `link/star_dust/consolefix/fabric/FabricClientCommandBridge.java` | `` |  | send |
| top-level / `link/star_dust/consolefix/fabric/FabricClientCommandHandler.java` | `` |  |  |
| top-level / `link/star_dust/consolefix/fabric/FabricClientCSF.java` | `` |  | onInitializeClient |
| top-level / `link/star_dust/consolefix/fabric/FabricCommandBridge.java` | `` |  | createText, getSender, isPlayer, isConsole, hasPermission, findAllCheckMethods, checkLPPermission, checkVanillaOpLevel, resolvePlayerEntity, isPlayerOperator, sendMessage, sendSuccess, sendFailure, sendFeedback |
| top-level / `link/star_dust/consolefix/fabric/FabricCommandHandler.java` | `` |  |  |
| top-level / `link/star_dust/consolefix/fabric/FabricCSF.java` | `` |  | onInitializeServer |
| top-level / `link/star_dust/consolefix/fabric/FabricCsfContext.java` | `` |  | initFilteredLog, getStringList, getString, getStringWithColor, info, warn, error, reloadConfig, logFilteredMessage |
| top-level / `link/star_dust/consolefix/fabric/FabricEventBus.java` | `` |  | tryRegisterCommandV2, tryRegisterCommandV1, handleObjectMethods, findAbstractMethod, register, fromConsumer |
| top-level / `link/star_dust/consolefix/fabric/FabricFastStatsData.java` | `` |  | playerAmount, onlineMode, serverSoftware, platformTag, serverVersion |
| top-level / `link/star_dust/consolefix/fabric/FabricReflection.java` | `` |  | log, unwrap, tryLoad, findMethodImpl, findField, equals, hashCode, equals, hashCode, equals, hashCode |
| top-level / `link/star_dust/consolefix/fabric/FabricReflectionConstants.java` | `` |  | im, ifd, putM |
| top-level / `link/star_dust/consolefix/forge/ForgeCommandBridge.java` | `` |  | createText, getSender, isPlayer, isConsole, hasPermission, checkForgePermission, checkForgeLuckPerms, playerUuid, extractPlayerUuid, resolvePlayer, checkVanillaOpLevel, sendMessage, sendSuccess, sendFailure, sendFeedback |
| top-level / `link/star_dust/consolefix/forge/ForgeCommandHandler.java` | `` |  | register |
| top-level / `link/star_dust/consolefix/forge/ForgeCSF.java` | `` |  |  |
| top-level / `link/star_dust/consolefix/forge/ForgeCsfContext.java` | `` |  | initFilteredLog, getStringList, getString, getStringWithColor, info, warn, error, reloadConfig, logFilteredMessage |
| top-level / `link/star_dust/consolefix/forge/ForgeFastStatsData.java` | `` |  | playerAmount, onlineMode, serverSoftware, platformTag, serverVersion |
| top-level / `link/star_dust/consolefix/forge/ForgePermissionRegistry.java` | `` |  | onGatherNodes |
| top-level / `link/star_dust/consolefix/forge/ForgeReflection.java` | `` |  | log, unwrap, tryLoad, tryLoadWith, findMethodImpl, tryMethod, paramsMatch, findAddListener, makeConsumer, accept, equals, hashCode, equals, hashCode, equals, hashCode |
| top-level / `link/star_dust/consolefix/forge/ForgeReflectionConstants.java` | `` |  |  |
| top-level / `link/star_dust/consolefix/neoforge/NeoForgeCommandBridge.java` | `` |  | createText, getSender, isPlayer, isConsole, hasPermission, checkNeoForgePermission, nativePermission, checkNeoForgeLuckPerms, playerUuid, extractPlayerUuid, resolvePlayer, checkVanillaOpLevel, sendMessage, sendSuccess, sendFailure, sendFeedback |
| top-level / `link/star_dust/consolefix/neoforge/NeoForgeCommandHandler.java` | `` |  | register |
| top-level / `link/star_dust/consolefix/neoforge/NeoForgeCSF.java` | `` |  |  |
| top-level / `link/star_dust/consolefix/neoforge/NeoForgeCsfContext.java` | `` |  | initFilteredLog, getStringList, getString, getStringWithColor, info, warn, error, reloadConfig, logFilteredMessage |
| top-level / `link/star_dust/consolefix/neoforge/NeoForgeFastStatsData.java` | `` |  | playerAmount, onlineMode, serverSoftware, platformTag, serverVersion |
| top-level / `link/star_dust/consolefix/neoforge/NeoForgePermissionRegistry.java` | `` |  | onGatherNodes |
| top-level / `link/star_dust/consolefix/neoforge/NeoForgeReflection.java` | `` |  | log, unwrap, tryLoad, tryLoadWith, findMethodImpl, tryMethod, paramsMatch, findAddListener, makeConsumer, accept, equals, hashCode, equals, hashCode, equals, hashCode |
| top-level / `link/star_dust/consolefix/neoforge/NeoForgeReflectionConstants.java` | `` |  |  |
| top-level / `link/star_dust/consolefix/velocity/ConfigHandler.java` | `` |  | loadConfig, copyDefaultConfigFromJar, checkConfigVersion, getStringList, getString, getChatMessage, isLogFilteredMessagesEnabled, logFilteredMessage |
| top-level / `link/star_dust/consolefix/velocity/VelocityCommandHandler.java` | `` |  | execute, hasPermission |
| top-level / `link/star_dust/consolefix/velocity/VelocityCSF.java` | `` | Inject:1 | updateLogFilter, onProxyInitialize, getConfigHandler, getEngine, getLogFilterManager, getCsfContext, getLogger, getDataDirectory, getPluginContainer |
| top-level / `link/star_dust/consolefix/velocity/VelocityCsfContext.java` | `` |  | getStringList, getString, getStringWithColor, info, warn, error, reloadConfig, logFilteredMessage |
| top-level / `link/star_dust/errorprone/annotations/CanIgnoreReturnValue.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/CheckReturnValue.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/CompatibleWith.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/CompileTimeConstant.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/concurrent/GuardedBy.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/concurrent/LazyInit.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/concurrent/LockMethod.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/concurrent/UnlockMethod.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/DoNotCall.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/DoNotMock.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/FormatMethod.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/FormatString.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/ForOverride.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/Immutable.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/ImmutableTypeParameter.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/IncompatibleModifiers.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/InlineMe.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/InlineMeValidationDisabled.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/Keep.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/Modifier.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/MustBeClosed.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/NoAllocation.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/OverridingMethodsMustInvokeSuper.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/RequiredModifiers.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/RestrictedApi.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/SuppressPackageLocation.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/ThreadSafe.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/ThreadSafeTypeParameter.java` | `` |  |  |
| top-level / `link/star_dust/errorprone/annotations/Var.java` | `` |  |  |
| top-level / `link/star_dust/faststats/Attributes.java` | `` |  | empty, copyOf, join |
| top-level / `link/star_dust/faststats/config/SimpleConfig.java` | `` |  | read, preSubmissionStart |
| top-level / `link/star_dust/faststats/Config.java` | `` |  |  |
| top-level / `link/star_dust/faststats/data/Metric.java` | `` |  | object, array, primitive, stringArray, booleanArray, numberArray, stringMap, booleanMap, numberMap, bool, string, number |
| top-level / `link/star_dust/faststats/data/SimpleMetric.java` | `` |  | getId, compute, equals, hashCode, toString, getData, getData, getData, getData |
| top-level / `link/star_dust/faststats/data/SourceId.java` | `` |  |  |
| top-level / `link/star_dust/faststats/ErrorHelper.java` | `` |  | compile, compileAll, appendCauseChain, populateTraces, collapseStackTrace, collapseRepeatingPattern, collapseConsecutiveDuplicates, isSameLoader, isSameLoader, findFirstNonLibraryFrameIndex, isFromLoader, isSameClassLoader, defaultAnonymizationEntries, discordWebhookPattern, ipv4Pattern, ipv6Pattern, jdbcUrlPattern, userHomePathPattern, usernamePattern |
| top-level / `link/star_dust/faststats/ErrorTracker.java` | `` |  | contextAware, contextAware, contextUnaware, isSameLoader |
| top-level / `link/star_dust/faststats/ErrorTrackerService.java` | `` |  |  |
| top-level / `link/star_dust/faststats/FastStatsContext.java` | `` |  |  |
| top-level / `link/star_dust/faststats/FeatureFlag.java` | `` |  |  |
| top-level / `link/star_dust/faststats/FeatureFlagService.java` | `` |  |  |
| top-level / `link/star_dust/faststats/internal/Logger.java` | `` |  | getLevel |
| top-level / `link/star_dust/faststats/internal/LoggerFactory.java` | `` |  | isDebug, setDebug |
| top-level / `link/star_dust/faststats/internal/package-info.java` | `` |  |  |
| top-level / `link/star_dust/faststats/internal/PlatformLoggerFactory.java` | `` |  | getLogger, caller, factory, print |
| top-level / `link/star_dust/faststats/Metrics.java` | `` |  |  |
| top-level / `link/star_dust/faststats/SdkInfo.java` | `` |  |  |
| top-level / `link/star_dust/faststats/SimpleAttributes.java` | `` |  | put, put, put, remove, containsKey, forEachPrimitive |
| top-level / `link/star_dust/faststats/SimpleContext.java` | `` |  | initializeServices, constructSdkInfo, getLoggerFactory, getConfig, getToken, metrics, featureFlagService, featureFlagServiceFactory, errorTrackerService, ready, shutdown, getSdkInfo, errorTrackerService, metrics, featureFlagService, self |
| top-level / `link/star_dust/faststats/SimpleErrorTracker.java` | `` |  | getAttributes, trackError, trackError, isIgnored, ignoreError, ignoreError, ignoreError, anonymize, getFullData, clear, attachErrorContext, detachErrorContext, isContextAttached, setContextErrorHandler |
| top-level / `link/star_dust/faststats/SimpleErrorTrackerService.java` | `` |  | globalErrorTracker, registerErrorTracker, handleUncaughtException, submit, clear, serverType, shutdown |
| top-level / `link/star_dust/faststats/SimpleFeatureFlag.java` | `` |  | getId, getType, getTypeClass, setValue, setLastFetch, getCached, getExpiration, isValid, isExpired, whenReady, fetch, optIn, optOut, getDefaultValue, equals, hashCode, toString |
| top-level / `link/star_dust/faststats/SimpleFeatureFlagService.java` | `` |  | sendOptRequest, createFetch, createRequestBody, send, createRequest, handleFetchResponse, getValue, getAsNumber, getAsBoolean, define, define, define, define, define, define, defineFlag, getAttributes, getTTL, shutdown, serverType, attributes, ttl, create |
| top-level / `link/star_dust/faststats/SimpleMetrics.java` | `` |  | isClientApplication, submit, serverType, appendInternalData, appendCustomData, appendData, createData, shutdown, addMetric, onFlush |
| top-level / `link/star_dust/faststats/SimpleSdkInfo.java` | `` |  | getBuildId, getName, getVersion, getUserAgent, getUserAgent |
| top-level / `link/star_dust/faststats/SimpleTrackedError.java` | `` |  | error, handled, handled, attributes, attributes, equals, hashCode, deepEquals, hash |
| top-level / `link/star_dust/faststats/SubmissionService.java` | `` |  | getServerUrl, submit, hasWarnings, capitalize, isSuccessful, logUnsuccessfulResponse, compress, createSubmissionRequest |
| top-level / `link/star_dust/faststats/Token.java` | `` |  |  |
| top-level / `link/star_dust/faststats/TrackedError.java` | `` |  |  |
| top-level / `link/star_dust/gson/annotations/Expose.java` | `` |  |  |
| top-level / `link/star_dust/gson/annotations/JsonAdapter.java` | `` |  |  |
| top-level / `link/star_dust/gson/annotations/package-info.java` | `` |  |  |
| top-level / `link/star_dust/gson/annotations/SerializedName.java` | `` |  |  |
| top-level / `link/star_dust/gson/annotations/Since.java` | `` |  |  |
| top-level / `link/star_dust/gson/annotations/Until.java` | `` |  |  |
| top-level / `link/star_dust/gson/ExclusionStrategy.java` | `` |  |  |
| top-level / `link/star_dust/gson/FieldAttributes.java` | `` |  | getDeclaringClass, getName, getDeclaredType, getDeclaredClass, getAnnotation, getAnnotations, hasModifier, toString |
| top-level / `link/star_dust/gson/FieldNamingPolicy.java` | `` |  | translateName, translateName, translateName, translateName, translateName, translateName, translateName |
| top-level / `link/star_dust/gson/FieldNamingStrategy.java` | `` |  |  |
| top-level / `link/star_dust/gson/FormattingStyle.java` | `` |  | withNewline, withIndent, withSpaceAfterSeparators, getNewline, getIndent, usesSpaceAfterSeparators |
| top-level / `link/star_dust/gson/Gson.java` | `` |  | newBuilder, excluder, fieldNamingStrategy, serializeNulls, htmlSafe, getAdapter, getAdapter, getDelegateAdapter, toJsonTree, toJsonTree, toJson, toJson, toJson, toJson, toJson, toJson, toJson, toJson, newJsonWriter, newJsonReader, fromJson, fromJson, fromJson, fromJson, fromJson, fromJson, fromJson, fromJson, fromJson, fromJson, fromJson, assertFullConsumption, toString, setDelegate, delegate, getSerializationDelegate, read, write |
| top-level / `link/star_dust/gson/GsonBuilder.java` | `` |  | setVersion, excludeFieldsWithModifiers, generateNonExecutableJson, excludeFieldsWithoutExposeAnnotation, serializeNulls, enableComplexMapKeySerialization, disableInnerClassSerialization, setLongSerializationPolicy, setFieldNamingPolicy, setFieldNamingStrategy, setObjectToNumberStrategy, setNumberToNumberStrategy, setExclusionStrategies, addSerializationExclusionStrategy, addDeserializationExclusionStrategy, setPrettyPrinting, setFormattingStyle, setLenient, setStrictness, disableHtmlEscaping, setDateFormat, setDateFormat, setDateFormat, checkDateFormatStyle, registerTypeAdapter, hasNonOverridableAdapter, registerTypeAdapterFactory, registerTypeHierarchyAdapter, serializeSpecialFloatingPointValues, disableJdkUnsafe, addReflectionAccessFilter, create, doubleAdapter, floatAdapter, addUserDefinedAdapters, addDateTypeAdapters |
| top-level / `link/star_dust/gson/InstanceCreator.java` | `` |  |  |
| top-level / `link/star_dust/gson/internal/bind/ArrayTypeAdapter.java` | `` |  | create, read, write |
| top-level / `link/star_dust/gson/internal/bind/CollectionTypeAdapterFactory.java` | `` |  | create, read, write |
| top-level / `link/star_dust/gson/internal/bind/DefaultDateTypeAdapter.java` | `` |  | create, toString, write, read, deserializeToDate, toString, deserialize, createFactory, createAdapterFactory, createAdapterFactory |
| top-level / `link/star_dust/gson/internal/bind/EnumTypeAdapter.java` | `` |  | create, calculateHashMapCapacity, read, write |
| top-level / `link/star_dust/gson/internal/bind/IgnoreJRERequirement.java` | `` |  |  |
| top-level / `link/star_dust/gson/internal/bind/JavaTimeTypeAdapters.java` | `` |  | read, write, create, get, localDateTime, read, write, offsetDateTime, read, write, offsetTime, read, write, zonedDateTime, read, write, requireNonNullField |
| top-level / `link/star_dust/gson/internal/bind/JsonAdapterAnnotationTypeAdapterFactory.java` | `` |  | getAnnotation, create, createAdapter, putFactoryAndGetCurrent, isClassJsonAdapterFactory, create |
| top-level / `link/star_dust/gson/internal/bind/JsonElementTypeAdapter.java` | `` |  | tryBeginNesting, readTerminal, read, write |
| top-level / `link/star_dust/gson/internal/bind/JsonTreeReader.java` | `` |  | read, close, beginArray, endArray, beginObject, endObject, hasNext, peek, peekStack, popStack, expect, nextName, nextName, nextString, nextBoolean, nextNull, nextDouble, nextLong, nextInt, close, skipValue, toString, promoteNameToValue, push, getPath, getPath, getPreviousPath, locationString |
| top-level / `link/star_dust/gson/internal/bind/JsonTreeWriter.java` | `` |  | write, flush, close, get, peek, put, beginArray, endArray, beginObject, endObject, name, value, value, value, value, value, value, value, nullValue, jsonValue, flush, close |
| top-level / `link/star_dust/gson/internal/bind/MapTypeAdapterFactory.java` | `` |  | create, getKeyAdapter, read, write, keyToString |
| top-level / `link/star_dust/gson/internal/bind/NumberTypeAdapter.java` | `` |  | newFactory, create, getFactory, read, write |
| top-level / `link/star_dust/gson/internal/bind/ObjectTypeAdapter.java` | `` |  | newFactory, create, getFactory, tryBeginNesting, readTerminal, read, write |
| top-level / `link/star_dust/gson/internal/bind/ReflectiveTypeAdapterFactory.java` | `` |  | includeField, getFieldNames, create, read, write, toString, checkAccessible, createBoundField, createDuplicateFieldException, getBoundFields, primitiveDefaults, write, read |
| top-level / `link/star_dust/gson/internal/bind/SerializationDelegatingTypeAdapter.java` | `` |  |  |
| top-level / `link/star_dust/gson/internal/bind/TreeTypeAdapter.java` | `` |  | read, write, delegate, getSerializationDelegate, newFactory, newFactoryWithMatchRawType, newTypeHierarchyFactory, serialize, serialize, deserialize, create |
| top-level / `link/star_dust/gson/internal/bind/TypeAdapterRuntimeTypeWrapper.java` | `` |  | read, write, isReflective, getRuntimeTypeIfMoreSpecific |
| top-level / `link/star_dust/gson/internal/bind/TypeAdapters.java` | `` |  | write, read, read, write, read, write, read, write, read, write, read, write, read, write, read, write, read, write, read, write, read, write, read, write, read, write, read, write, read, write, read, write, read, write, read, write, read, write, read, write, read, write, read, write, read, write, read, write, read, write, atomicLongAdapter, read, write, atomicLongArrayAdapter, read, write, checkValidFloatingPoint, toIntExact, javaTimeTypeAdapterFactory, newFactory, create, newFactory, create, toString, newFactory, create, toString, newFactoryForMultipleTypes, create, toString, newTypeHierarchyFactory, create, write, read, toString, read, write, read, write, read, write |
| top-level / `link/star_dust/gson/internal/bind/util/ISO8601Utils.java` | `` |  | format, format, format, parse, checkOffset, parseInt, padInt, indexOfNonDigit |
| top-level / `link/star_dust/gson/internal/ConstructorConstructor.java` | `` |  | get, get, newSpecialCollectionConstructor, newDefaultConstructor, newDefaultImplementationConstructor, newCollectionConstructor, hasStringKeyType, newMapConstructor, newUnsafeAllocator, toString, construct, construct |
| top-level / `link/star_dust/gson/internal/Excluder.java` | `` |  | clone, withVersion, withModifiers, disableInnerClassSerialization, excludeFieldsWithoutExposeAnnotation, withExclusionStrategy, create, read, write, delegate, excludeField, excludeClass, isInnerClass, isValidVersion, isValidSince, isValidUntil |
| top-level / `link/star_dust/gson/internal/GsonBuildConfig.java` | `` |  |  |
| top-level / `link/star_dust/gson/internal/GsonTypes.java` | `` |  | newParameterizedTypeWithOwner, arrayOf, subtypeOf, supertypeOf, canonicalize, getRawType, equal, equals, typeToString, getGenericSupertype, getSupertype, getArrayComponentType, getCollectionElementType, getMapKeyAndValueTypes, resolve, resolve, resolveTypeVariable, indexOf, declaringClassOf, requiresOwnerType, getActualTypeArguments, getRawType, getOwnerType, equals, hashCodeOrZero, hashCode, toString, getGenericComponentType, equals, hashCode, toString, getUpperBounds, getLowerBounds, equals, hashCode, toString |
| top-level / `link/star_dust/gson/internal/JavaVersion.java` | `` |  | determineMajorJavaVersion, parseDotted, extractBeginningInt, getMajorJavaVersion, isJava9OrLater |
| top-level / `link/star_dust/gson/internal/JsonReaderInternalAccess.java` | `` |  |  |
| top-level / `link/star_dust/gson/internal/LazilyParsedNumber.java` | `` |  | asBigDecimal, intValue, longValue, floatValue, doubleValue, toString, writeReplace, readObject, hashCode, equals |
| top-level / `link/star_dust/gson/internal/LinkedTreeMap.java` | `` |  | compare, size, get, containsKey, put, clear, remove, equal, replaceInParent, rebalance, rotateLeft, rotateRight, entrySet, keySet, writeReplace, readObject, getKey, getValue, setValue, equals, hashCode, toString, first, last, size, iterator, next, contains, remove, clear, size, iterator, next, contains, remove, clear, hasNext, remove |
| top-level / `link/star_dust/gson/internal/NonNullElementWrapperList.java` | `` |  | get, size, nonNull, set, add, remove, clear, remove, removeAll, retainAll, contains, indexOf, lastIndexOf, toArray, toArray, equals, hashCode |
| top-level / `link/star_dust/gson/internal/NumberLimits.java` | `` |  | checkNumberStringLength, parseBigDecimal, parseBigInteger |
| top-level / `link/star_dust/gson/internal/ObjectConstructor.java` | `` |  |  |
| top-level / `link/star_dust/gson/internal/package-info.java` | `` |  |  |
| top-level / `link/star_dust/gson/internal/PreJava9DateFormatProvider.java` | `` |  | getUsDateTimeFormat, getDatePartOfDateTimePattern, getTimePartOfDateTimePattern |
| top-level / `link/star_dust/gson/internal/Primitives.java` | `` |  | isPrimitive, isWrapperType, wrap, unwrap |
| top-level / `link/star_dust/gson/internal/reflect/ReflectionHelper.java` | `` |  | getInaccessibleTroubleshootingSuffix, makeAccessible, getAccessibleObjectDescription, fieldToString, constructorToString, appendExecutableParameters, isStatic, isAnonymousOrNonStaticLocal, tryMakeAccessible, isRecord, getRecordComponentNames, getAccessor, getCanonicalRecordConstructor, createExceptionForUnexpectedIllegalAccess, createExceptionForRecordReflectionException, getCanonicalRecordConstructor, getAccessor, getAccessor |
| top-level / `link/star_dust/gson/internal/ReflectionAccessFilterHelper.java` | `` |  | isJavaType, isJavaType, isAndroidType, isAndroidType, isAnyPlatformType, getFilterResult, canAccess, canAccess, canAccess |
| top-level / `link/star_dust/gson/internal/sql/SqlDateTypeAdapter.java` | `` |  | create, read, write |
| top-level / `link/star_dust/gson/internal/sql/SqlTimestampTypeAdapter.java` | `` |  | create, read, write |
| top-level / `link/star_dust/gson/internal/sql/SqlTimeTypeAdapter.java` | `` |  | create, read, write |
| top-level / `link/star_dust/gson/internal/sql/SqlTypesSupport.java` | `` |  | deserialize, deserialize |
| top-level / `link/star_dust/gson/internal/Streams.java` | `` |  | parse, write, writerForAppendable, write, flush, close, write, write, append, append, length, charAt, subSequence, toString |
| top-level / `link/star_dust/gson/internal/TroubleshootingGuide.java` | `` |  | createUrl |
| top-level / `link/star_dust/gson/internal/UnsafeAllocator.java` | `` |  | assertInstantiable, create, newInstance, newInstance, newInstance, newInstance |
| top-level / `link/star_dust/gson/JsonArray.java` | `` |  | deepCopy, add, add, add, add, add, addAll, set, remove, remove, contains, size, isEmpty, iterator, get, getAsSingleElement, getAsNumber, getAsString, getAsDouble, getAsBigDecimal, getAsBigInteger, getAsFloat, getAsLong, getAsInt, getAsByte, getAsCharacter, getAsShort, getAsBoolean, asList, equals, hashCode |
| top-level / `link/star_dust/gson/JsonDeserializationContext.java` | `` |  |  |
| top-level / `link/star_dust/gson/JsonDeserializer.java` | `` |  |  |
| top-level / `link/star_dust/gson/JsonElement.java` | `` |  | isJsonArray, isJsonObject, isJsonPrimitive, isJsonNull, getAsJsonObject, getAsJsonArray, getAsJsonPrimitive, getAsJsonNull, getAsBoolean, getAsNumber, getAsString, getAsDouble, getAsFloat, getAsLong, getAsInt, getAsByte, getAsCharacter, getAsBigDecimal, getAsBigInteger, getAsShort, toString |
| top-level / `link/star_dust/gson/JsonIOException.java` | `` |  |  |
| top-level / `link/star_dust/gson/JsonNull.java` | `` |  | deepCopy, hashCode, equals |
| top-level / `link/star_dust/gson/JsonObject.java` | `` |  | deepCopy, add, remove, addProperty, addProperty, addProperty, addProperty, entrySet, keySet, size, isEmpty, has, get, getAsJsonPrimitive, getAsJsonArray, getAsJsonObject, asMap, equals, hashCode |
| top-level / `link/star_dust/gson/JsonParseException.java` | `` |  |  |
| top-level / `link/star_dust/gson/JsonParser.java` | `` |  | parseString, parseReader, parseReader, parse, parse, parse |
| top-level / `link/star_dust/gson/JsonPrimitive.java` | `` |  | deepCopy, isBoolean, getAsBoolean, isNumber, getAsNumber, isString, getAsString, getAsDouble, getAsBigDecimal, getAsBigInteger, getAsFloat, getAsLong, getAsShort, getAsInt, getAsByte, getAsCharacter, hashCode, equals, isIntegral |
| top-level / `link/star_dust/gson/JsonSerializationContext.java` | `` |  |  |
| top-level / `link/star_dust/gson/JsonSerializer.java` | `` |  |  |
| top-level / `link/star_dust/gson/JsonStreamParser.java` | `` |  | next, hasNext, remove |
| top-level / `link/star_dust/gson/JsonSyntaxException.java` | `` |  |  |
| top-level / `link/star_dust/gson/LongSerializationPolicy.java` | `` |  | serialize, serialize |
| top-level / `link/star_dust/gson/package-info.java` | `` |  |  |
| top-level / `link/star_dust/gson/reflect/package-info.java` | `` |  |  |
| top-level / `link/star_dust/gson/reflect/TypeToken.java` | `` |  | isCapturingTypeVariablesForbidden, getTypeTokenTypeArgument, verifyNoTypeVariable, getRawType, getType, isAssignableFrom, isAssignableFrom, isAssignableFrom, isAssignableFrom, isAssignableFrom, typeEquals, buildUnsupportedTypeException, matches, hashCode, equals, toString, get, get, getParameterized, getArray |
| top-level / `link/star_dust/gson/ReflectionAccessFilter.java` | `` |  | check, toString, check, toString, check, toString, check, toString |
| top-level / `link/star_dust/gson/stream/JsonReader.java` | `` |  | setLenient, isLenient, setStrictness, getStrictness, setNestingLimit, getNestingLimit, beginArray, endArray, beginObject, endObject, hasNext, peek, peekKeyword, peekNumber, isLiteral, nextName, nextString, nextBoolean, nextNull, nextDouble, nextLong, nextQuotedValue, nextUnquotedValue, skipQuotedValue, skipUnquotedValue, nextInt, close, skipValue, push, fillBuffer, nextNonWhitespace, checkLenient, skipToEndOfLine, skipTo, toString, getPath, getPath, getPreviousPath, readEscapeCharacter, syntaxError, unexpectedTokenError, consumeNonExecutePrefix, validateAscii, promoteNameToValue |
| top-level / `link/star_dust/gson/stream/JsonScope.java` | `` |  |  |
| top-level / `link/star_dust/gson/stream/JsonToken.java` | `` |  |  |
| top-level / `link/star_dust/gson/stream/JsonWriter.java` | `` |  | setIndent, setFormattingStyle, getFormattingStyle, setLenient, isLenient, setStrictness, getStrictness, setHtmlSafe, isHtmlSafe, setSerializeNulls, getSerializeNulls, beginArray, endArray, beginObject, endObject, openScope, closeScope, push, peek, replaceTop, name, writeDeferredName, value, value, value, value, value, value, value, nullValue, jsonValue, flush, close, alwaysCreatesValidJsonNumber, string, newline, beforeName, beforeValue |
| top-level / `link/star_dust/gson/stream/MalformedJsonException.java` | `` |  |  |
| top-level / `link/star_dust/gson/stream/package-info.java` | `` |  |  |
| top-level / `link/star_dust/gson/Strictness.java` | `` |  |  |
| top-level / `link/star_dust/gson/ToNumberPolicy.java` | `` |  | readNumber, readNumber, readNumber, parseAsDouble, readNumber |
| top-level / `link/star_dust/gson/ToNumberStrategy.java` | `` |  |  |
| top-level / `link/star_dust/gson/TypeAdapter.java` | `` |  | toJson, toJson, toJsonTree, fromJson, fromJson, fromJsonTree, nullSafe, write, read, toString |
| top-level / `link/star_dust/gson/TypeAdapterFactory.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/AbstractCommentedConfigurationNode.java` | `` |  | comment, commentIfAbsent, from, mergeFrom, equals, hashCode |
| top-level / `link/star_dust/spongepowered/configurate/AbstractConfigurationNode.java` | `` |  | set, from, insertNewValue, mergeFrom, raw, node, node, hasChild, hasChild, virtual, isNull, isList, isMap, childrenList, childrenMap, empty, child, removeChild, appendListNode, path, options, copy, attachIfNecessary, attachChildIfAbsent, attachChild, clear, visit, visit, visitInternal, hint, ownHints, equals, hashCode, toString |
| top-level / `link/star_dust/spongepowered/configurate/AttributedConfigurationNode.java` | `` |  | factory, root, root, root, root, root, root |
| top-level / `link/star_dust/spongepowered/configurate/AttributedConfigurationNodeImpl.java` | `` |  | tagName, tagName, addAttribute, removeAttribute, attributes, attributes, hasAttributes, empty, createNode, from, mergeFrom, copy, self, implSelf, equals, hashCode, toString |
| top-level / `link/star_dust/spongepowered/configurate/AutoValue_ConfigurationOptions.java` | `` |  | mapFactory, serializers, shouldCopyDefaults, implicitInitialization, toString, equals, hashCode |
| top-level / `link/star_dust/spongepowered/configurate/AutoValue_RepresentationHint.java` | `` |  | identifier, valueType, defaultValue, inheritable, toString, equals, hashCode, identifier, valueType, defaultValue, inheritable, build |
| top-level / `link/star_dust/spongepowered/configurate/BasicConfigurationNode.java` | `` |  | factory, root, root, root, root |
| top-level / `link/star_dust/spongepowered/configurate/BasicConfigurationNodeImpl.java` | `` |  | copy, self, implSelf, createNode |
| top-level / `link/star_dust/spongepowered/configurate/CommentedConfigurationNode.java` | `` |  | factory, root, root, root, root |
| top-level / `link/star_dust/spongepowered/configurate/CommentedConfigurationNodeImpl.java` | `` |  | createNode, copy, self, implSelf, toString |
| top-level / `link/star_dust/spongepowered/configurate/CommentedConfigurationNodeIntermediary.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/ConfigurateException.java` | `` |  | wrap, path, initPath |
| top-level / `link/star_dust/spongepowered/configurate/ConfigurationNode.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/ConfigurationNodeFactory.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/ConfigurationOptions.java` | `` |  | defaults, mapFactory, header, serializers, serializers, nativeTypes, acceptsType, shouldCopyDefaults, implicitInitialization |
| top-level / `link/star_dust/spongepowered/configurate/ConfigurationVisitor.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/ConfigValue.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/ListConfigValue.java` | `` |  | toString, get, unwrapped, set, iterateChildren, copy, isEmpty, detachNodes, clear, equals, hashCode, toString |
| top-level / `link/star_dust/spongepowered/configurate/loader/AbstractConfigurationLoader.java` | `` |  | defaultCommentHandler, loadToReference, load, save, checkCanWrite, writeHeaderInternal, defaultOptions, canLoad, canSave, self, file, path, url, source, sink, headerMode, headerMode, defaultOptions, defaultOptions, defaultOptions, buildAndLoadString, buildAndSaveString |
| top-level / `link/star_dust/spongepowered/configurate/loader/AtomicFiles.java` | `` |  | atomicWriterFactory, atomicBufferedWriter, createDirectoriesIfNecessary, temporaryPath, close |
| top-level / `link/star_dust/spongepowered/configurate/loader/CommentHandler.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/loader/CommentHandlers.java` | `` |  | toComment, toComment, handleSingleLine, toComment |
| top-level / `link/star_dust/spongepowered/configurate/loader/ConfigurationLoader.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/loader/HeaderMode.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/loader/package-info.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/loader/ParsingException.java` | `` |  | wrap, line, column |
| top-level / `link/star_dust/spongepowered/configurate/MapConfigValue.java` | `` |  | newMap, get, unwrapped, set, iterateChildren, copy, isEmpty, detachChildren, clear, equals, hashCode, toString |
| top-level / `link/star_dust/spongepowered/configurate/NodePath.java` | `` |  | of, of, path, path |
| top-level / `link/star_dust/spongepowered/configurate/NodePathImpl.java` | `` |  | get, size, withAppendedChild, with, plus, array, iterator, copy, equals, hashCode, toString |
| top-level / `link/star_dust/spongepowered/configurate/NullConfigValue.java` | `` |  | set, iterateChildren, copy, isEmpty, clear, equals, hashCode, toString |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/AutoValue_Definition.java` | `` |  | toString, equals, hashCode |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/AutoValue_FieldData.java` | `` |  | name, resolvedType, toString, equals, hashCode |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/ConfigSerializable.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/Definition.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/FieldData.java` | `` |  | isValid, validate |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/FieldDiscoverer.java` | `` |  | record, object, object, emptyConstructorObject |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/meta/Comment.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/meta/Constraint.java` | `` |  | required, pattern, localizedPattern |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/meta/Localization.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/meta/Matches.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/meta/NodeKey.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/meta/NodeResolver.java` | `` |  | nodeKey, keyFromSetting, onlyWithAnnotation, onlyWithSetting, nodeFromParent |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/meta/package-info.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/meta/Processor.java` | `` |  | comments, localizedComments |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/meta/Required.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/meta/Setting.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/ObjectFieldDiscoverer.java` | `` |  | begin, complete, complete, canCreateInstances, collectFields |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/ObjectMapper.java` | `` |  | factory, emptyFactoryBuilder, factoryBuilder |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/ObjectMapperFactoryImpl.java` | `` |  | removeEldestEntry, get, asTypeSerializer, computeMapper, makeData, deserialize, instantiableType, serialize, computeFromMap, defaultNamingScheme, addNodeResolver, addDiscoverer, addProcessor, addConstraint, build, fillInStackTrace |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/ObjectMapperImpl.java` | `` |  | load, save, saveSingle, fields, mappedType, canCreateInstances, load |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/package-info.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/objectmapping/RecordFieldDiscoverer.java` | `` |  | begin, complete, canCreateInstances |
| top-level / `link/star_dust/spongepowered/configurate/package-info.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/reactive/AbstractProcessor.java` | `` |  | executor, subscribe, hasSubscribers, onError, onClose, forEachOrRemove, fallbackHandler, closeIfUnsubscribed |
| top-level / `link/star_dust/spongepowered/configurate/reactive/CachedPublisher.java` | `` |  | subscribe, hasSubscribers, cache, cache, executor, get, submit, close |
| top-level / `link/star_dust/spongepowered/configurate/reactive/Disposable.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/reactive/ExecutePublisher.java` | `` |  | subscribe, hasSubscribers, executor |
| top-level / `link/star_dust/spongepowered/configurate/reactive/MappedProcessor.java` | `` |  | subscribe, hasSubscribers, executor, beginTransaction, commit, rollback, onError, onClose, inject, fallbackHandler, closeIfUnsubscribed |
| top-level / `link/star_dust/spongepowered/configurate/reactive/NoOpDisposable.java` | `` |  | dispose |
| top-level / `link/star_dust/spongepowered/configurate/reactive/package-info.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/reactive/Processor.java` | `` |  | create, create, createTransactional, createTransactional |
| top-level / `link/star_dust/spongepowered/configurate/reactive/ProcessorImpl.java` | `` |  | submit, createRegistration |
| top-level / `link/star_dust/spongepowered/configurate/reactive/Publisher.java` | `` |  | execute, execute |
| top-level / `link/star_dust/spongepowered/configurate/reactive/RegistrationImpl.java` | `` |  | dispose, submit, onClose, onError |
| top-level / `link/star_dust/spongepowered/configurate/reactive/Subscriber.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/reactive/TransactionalProcessorImpl.java` | `` |  | submit, beginTransaction, commit, rollback, createRegistration |
| top-level / `link/star_dust/spongepowered/configurate/reactive/TransactionalRegistration.java` | `` |  | holder, beginTransaction, commit, rollback, onClose, onError, holder, beginTransaction, commit, rollback, onClose, onError |
| top-level / `link/star_dust/spongepowered/configurate/reactive/TransactionalSubscriber.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/reactive/TransactionFailedException.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/reference/ConfigurationReference.java` | `` |  | fixed, watching |
| top-level / `link/star_dust/spongepowered/configurate/reference/DirectoryListenerRegistration.java` | `` |  | key, submit, onClose, subscribe, subscribe, hasSubscribers, equals, hashCode, closeIfEmpty |
| top-level / `link/star_dust/spongepowered/configurate/reference/ManualConfigurationReference.java` | `` |  | load, save, save, saveAsync, updateAsync, node, loader, get, get, referenceTo, referenceTo, updates, errors, close |
| top-level / `link/star_dust/spongepowered/configurate/reference/package-info.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/reference/PrefixedNameThreadFactory.java` | `` |  | newThread |
| top-level / `link/star_dust/spongepowered/configurate/reference/ValueReference.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/reference/ValueReferenceImpl.java` | `` |  | set, setAndSave, setAndSaveAsync, update, updateAsync, node, subscribe, hasSubscribers, executor |
| top-level / `link/star_dust/spongepowered/configurate/reference/WatchingConfigurationReference.java` | `` |  | save, close, submit, onError, onClose |
| top-level / `link/star_dust/spongepowered/configurate/reference/WatchServiceListener.java` | `` |  | builder, create, registration, listenToFile, listenToDirectory, listenToConfiguration, close, threadFactory, taskExecutor, fileSystem, build |
| top-level / `link/star_dust/spongepowered/configurate/RepresentationHint.java` | `` |  | of, of, builder, valueType |
| top-level / `link/star_dust/spongepowered/configurate/ScalarConfigValue.java` | `` |  | set, iterateChildren, copy, isEmpty, clear, equals, hashCode, toString |
| top-level / `link/star_dust/spongepowered/configurate/ScopedConfigurationNode.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/serialize/AbstractListChildSerializer.java` | `` |  | deserialize, serialize |
| top-level / `link/star_dust/spongepowered/configurate/serialize/ArraySerializer.java` | `` |  | elementType, createNew, forEachElement, deserializeSingle, createNew, forEachElement, deserializeSingle, createNew, forEachElement, deserializeSingle, createNew, forEachElement, deserializeSingle, createNew, forEachElement, deserializeSingle, createNew, forEachElement, deserializeSingle, createNew, forEachElement, deserializeSingle, createNew, forEachElement, deserializeSingle, accepts, createNew, forEachElement, deserializeSingle |
| top-level / `link/star_dust/spongepowered/configurate/serialize/BooleanSerializer.java` | `` |  | deserialize, serialize |
| top-level / `link/star_dust/spongepowered/configurate/serialize/CharSerializer.java` | `` |  | deserialize, serialize |
| top-level / `link/star_dust/spongepowered/configurate/serialize/CoercionFailedException.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/serialize/ConfigurationNodeSerializer.java` | `` |  | deserialize, serialize |
| top-level / `link/star_dust/spongepowered/configurate/serialize/EnumValueSerializer.java` | `` |  | deserialize, serialize |
| top-level / `link/star_dust/spongepowered/configurate/serialize/FileSerializer.java` | `` |  | deserialize, serialize |
| top-level / `link/star_dust/spongepowered/configurate/serialize/FunctionScalarSerializer.java` | `` |  | deserialize, serialize |
| top-level / `link/star_dust/spongepowered/configurate/serialize/ListSerializer.java` | `` |  | elementType, createNew, forEachElement, deserializeSingle |
| top-level / `link/star_dust/spongepowered/configurate/serialize/MapSerializer.java` | `` |  | deserialize, serialize, emptyValue |
| top-level / `link/star_dust/spongepowered/configurate/serialize/NumericSerializers.java` | `` |  | canRepresentDoubleAsFloat |
| top-level / `link/star_dust/spongepowered/configurate/serialize/package-info.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/serialize/PathSerializer.java` | `` |  | deserialize, serialize |
| top-level / `link/star_dust/spongepowered/configurate/serialize/PatternSerializer.java` | `` |  | deserialize, serialize |
| top-level / `link/star_dust/spongepowered/configurate/serialize/Scalars.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/serialize/ScalarSerializer.java` | `` |  | type, deserialize, deserialize, serialize, serializeToString |
| top-level / `link/star_dust/spongepowered/configurate/serialize/SerializationException.java` | `` |  | initType |
| top-level / `link/star_dust/spongepowered/configurate/serialize/SetSerializer.java` | `` |  | elementType, createNew, forEachElement, deserializeSingle |
| top-level / `link/star_dust/spongepowered/configurate/serialize/StringSerializer.java` | `` |  | deserialize, serialize |
| top-level / `link/star_dust/spongepowered/configurate/serialize/TypeSerializer.java` | `` |  | of, of |
| top-level / `link/star_dust/spongepowered/configurate/serialize/TypeSerializerCollection.java` | `` |  | childBuilder, toString, equals, hashCode, builder, defaults, deserialize, serialize, register, register, register, register, register0, registerExact, registerExact, registerExact, registerExact0, registerAll, registerAnnotatedObjects, build |
| top-level / `link/star_dust/spongepowered/configurate/serialize/UriSerializer.java` | `` |  | deserialize, serialize |
| top-level / `link/star_dust/spongepowered/configurate/serialize/UrlSerializer.java` | `` |  | deserialize, serialize |
| top-level / `link/star_dust/spongepowered/configurate/serialize/UuidSerializer.java` | `` |  | deserialize, serialize |
| top-level / `link/star_dust/spongepowered/configurate/transformation/ChainedConfigurationTransformation.java` | `` |  | apply |
| top-level / `link/star_dust/spongepowered/configurate/transformation/ConfigurationTransformation.java` | `` |  | empty, builder, versionedBuilder, chain, versionKey, addAction, moveStrategy, moveStrategy, build |
| top-level / `link/star_dust/spongepowered/configurate/transformation/MoveStrategy.java` | `` |  | move, move |
| top-level / `link/star_dust/spongepowered/configurate/transformation/MutableNodePath.java` | `` |  | get, size, array, withAppendedChild, with, plus, iterator, copy |
| top-level / `link/star_dust/spongepowered/configurate/transformation/NodePathComparator.java` | `` |  | compare |
| top-level / `link/star_dust/spongepowered/configurate/transformation/package-info.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/transformation/SingleConfigurationTransformation.java` | `` |  | apply, applySingleAction |
| top-level / `link/star_dust/spongepowered/configurate/transformation/TransformAction.java` | `` |  | remove, rename, set, set, set |
| top-level / `link/star_dust/spongepowered/configurate/transformation/VersionedTransformation.java` | `` |  | apply, versionKey, latestVersion |
| top-level / `link/star_dust/spongepowered/configurate/util/CheckedConsumer.java` | `` |  | from |
| top-level / `link/star_dust/spongepowered/configurate/util/CheckedFunction.java` | `` |  | from |
| top-level / `link/star_dust/spongepowered/configurate/util/CheckedSupplier.java` | `` |  | from |
| top-level / `link/star_dust/spongepowered/configurate/util/EnumLookup.java` | `` |  | processKey |
| top-level / `link/star_dust/spongepowered/configurate/util/MapFactories.java` | `` |  | unordered, sorted, sortedNatural, insertionOrdered, create, equals, hashCode, toString, create, create, create |
| top-level / `link/star_dust/spongepowered/configurate/util/MapFactory.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/util/NamingScheme.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/util/NamingSchemes.java` | `` |  | coerce, coerce, coerce, coerce, enforceLowerCaseSeparatorChar |
| top-level / `link/star_dust/spongepowered/configurate/util/package-info.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/util/Strings.java` | `` |  | repeat, isBlank |
| top-level / `link/star_dust/spongepowered/configurate/util/Types.java` | `` |  | isArray, isBoxedPrimitive, unbox, box, makeListType, combinedAnnotations, requireCompleteParameters, allSuperTypes, allSuperTypesAndInterfaces, calculateSuperTypes, isAnnotationPresent, getAnnotations, getAnnotationsByType, getDeclaredAnnotationsByType, getDeclaredAnnotations, hasNext, next, addAllIfUnseen, addIfUnseen, addSuperClassAndInterface |
| top-level / `link/star_dust/spongepowered/configurate/util/UnmodifiableCollections.java` | `` |  | copyOf, copyOf, copyOf, toList, toSet, buildMap, immutableMapEntry |
| top-level / `link/star_dust/spongepowered/configurate/VisitorNodeEnd.java` | `` |  | equals, hashCode |
| top-level / `link/star_dust/spongepowered/configurate/VisitorSafeNoopException.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/yaml/ConfigurateScanner.java` | `` |  | checkToken, peekToken, getToken, needMoreTokens, fetchMoreTokens, nextPossibleSimpleKey, stalePossibleSimpleKeys, savePossibleSimpleKey, removePossibleSimpleKey, unwindIndent, addIndent, fetchStreamStart, fetchStreamEnd, fetchDirective, fetchDocumentStart, fetchDocumentEnd, fetchDocumentIndicator, fetchFlowSequenceStart, fetchFlowMappingStart, fetchFlowCollectionStart, fetchFlowSequenceEnd, fetchFlowMappingEnd, fetchFlowCollectionEnd, fetchFlowEntry, fetchBlockEntry, fetchKey, fetchValue, fetchAlias, fetchAnchor, fetchTag, fetchLiteral, fetchFolded, fetchBlockScalar, fetchSingle, fetchDouble, fetchFlowScalar, fetchPlain, checkDirective, checkDocumentStart, checkDocumentEnd, checkBlockEntry, checkKey, checkValue, checkPlain, scanToNextToken, scanDirective, scanDirectiveName, scanYamlDirectiveValue, scanYamlDirectiveNumber, scanTagDirectiveValue, scanTagDirectiveHandle, scanTagDirectivePrefix, scanDirectiveIgnoredLine, scanAnchor, scanTag, scanBlockScalar, scanBlockScalarIndicators, scanBlockScalarIgnoredLine, scanBlockScalarIndentation, scanBlockScalarBreaks, scanFlowScalar, scanFlowScalarNonSpaces, scanFlowScalarSpaces, scanFlowScalarBreaks, scanPlain, scanPlainSpaces, scanTagHandle, scanTagUri, scanUriEscapes, scanLineBreak, chompTailIsNotFalse, chompTailIsTrue, getIncrement |
| top-level / `link/star_dust/spongepowered/configurate/yaml/ConfigurateYaml.java` | `` |  | loadConfigurate |
| top-level / `link/star_dust/spongepowered/configurate/yaml/NodeStyle.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/yaml/package-info.java` | `` |  |  |
| top-level / `link/star_dust/spongepowered/configurate/yaml/SimpleKey.java` | `` |  | getTokenNumber, getColumn, getMark, getIndex, getLine, isRequired, toString |
| top-level / `link/star_dust/spongepowered/configurate/yaml/YamlConfigurationLoader.java` | `` |  | builder, loadInternal, saveInternal, createNode, indent, indent, nodeStyle, build |
| top-level / `link/star_dust/yaml/snakeyaml/comments/CommentEventsCollector.java` | `` |  | offer, poll, peek, iterator, size, isEventExpected, collectEvents, collectEvents, collectEventsAndPoll, consume, isEmpty |
| top-level / `link/star_dust/yaml/snakeyaml/comments/CommentLine.java` | `` |  | getEndMark, getStartMark, getCommentType, getValue, toString |
| top-level / `link/star_dust/yaml/snakeyaml/comments/CommentType.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/composer/Composer.java` | `` |  | checkNode, getNode, getSingleNode, composeNode, composeScalarNode, composeSequenceNode, composeMappingNode, composeMappingChildren, composeKeyNode, composeValueNode |
| top-level / `link/star_dust/yaml/snakeyaml/composer/ComposerException.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/constructor/AbstractConstruct.java` | `` |  | construct2ndStep |
| top-level / `link/star_dust/yaml/snakeyaml/constructor/BaseConstructor.java` | `` |  | setComposer, checkData, getData, getSingleData, constructDocument, fillRecursive, constructObject, constructObjectNoCheck, getConstructor, constructScalar, createDefaultList, createDefaultSet, createDefaultMap, createArray, finalizeConstruction, newInstance, newInstance, newInstance, newSet, newList, newMap, constructSequence, constructSet, constructArray, constructSequenceStep2, constructArrayStep2, constructSet, constructMapping, constructMapping2ndStep, postponeMapFilling, constructSet2ndStep, postponeSetFilling, setPropertyUtils, getPropertyUtils, addTypeDescription, isExplicitPropertyUtils, isAllowDuplicateKeys, setAllowDuplicateKeys, isWrappedToRootException, setWrappedToRootException, isEnumCaseSensitive, setEnumCaseSensitive, _2, _1 |
| top-level / `link/star_dust/yaml/snakeyaml/constructor/Construct.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/constructor/Constructor.java` | `` |  | checkRoot, check, getClassForNode, getClassForName, construct, wrapIfPrimitive, construct2ndStep, construct, constructStandardJavaInstance, getConstructor, construct, construct2ndStep, construct, construct2ndStep, constructJavaBean2ndStep, newInstance, getProperty |
| top-level / `link/star_dust/yaml/snakeyaml/constructor/ConstructorException.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/constructor/CustomClassLoaderConstructor.java` | `` |  | getClassForName |
| top-level / `link/star_dust/yaml/snakeyaml/constructor/DuplicateKeyException.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/constructor/SafeConstructor.java` | `` |  | flattenMapping, processDuplicateKeys, mergeNode, constructMapping2ndStep, constructSet2ndStep, maxLen, maxLen, createNumber, createLongOrBigInteger, construct, construct, construct2ndStep, construct, construct2ndStep, construct, construct, construct2ndStep, construct, construct, getCalendar, construct, construct, construct, construct, construct, construct |
| top-level / `link/star_dust/yaml/snakeyaml/DumperOptions.java` | `` |  | isAllowUnicode, setAllowUnicode, getDefaultScalarStyle, setDefaultScalarStyle, setIndent, getIndent, setIndicatorIndent, getIndicatorIndent, getIndentWithIndicator, setIndentWithIndicator, setVersion, getVersion, setCanonical, isCanonical, setPrettyFlow, isPrettyFlow, setWidth, getWidth, setSplitLines, getSplitLines, getLineBreak, setDefaultFlowStyle, getDefaultFlowStyle, setLineBreak, isExplicitStart, setExplicitStart, isExplicitEnd, setExplicitEnd, getTags, setTags, isAllowReadOnlyProperties, setAllowReadOnlyProperties, getTimeZone, setTimeZone, getAnchorGenerator, setAnchorGenerator, getMaxSimpleKeyLength, setMaxSimpleKeyLength, getNonPrintableStyle, setNonPrintableStyle, major, minor, getRepresentation, toString, getString, toString, getPlatformLineBreak, fromBoolean, getStyleBoolean, toString, getChar, toString, createStyle |
| top-level / `link/star_dust/yaml/snakeyaml/emitter/Emitable.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/emitter/Emitter.java` | `` |  | emit, needMoreEvents, needEvents, increaseIndent, expectNode, expectAlias, expectScalar, expectFlowSequence, expectFlowMapping, expectBlockSequence, expectBlockMapping, isFoldedOrLiteral, checkEmptySequence, checkEmptyMapping, checkEmptyDocument, checkSimpleKey, processAnchor, processTag, chooseScalarStyle, processScalar, prepareVersion, prepareTagHandle, prepareTagPrefix, prepareTag, analyzeScalar, writeWhitespace, writeLineBreak, writeSingleQuoted, writeDoubleQuoted, writeCommentLines, writeBlockComment, writeInlineComments, determineBlockHints, expect, expect, expect, expect, expect, expect, expect, expect, expect, expect, expect, expect, expect, expect, expect, expect, expect, expect |
| top-level / `link/star_dust/yaml/snakeyaml/emitter/EmitterException.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/emitter/EmitterState.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/emitter/ScalarAnalysis.java` | `` |  | getScalar, isEmpty, isMultiline, isAllowFlowPlain, isAllowBlockPlain, isAllowSingleQuoted, isAllowBlock |
| top-level / `link/star_dust/yaml/snakeyaml/env/EnvScalarConstructor.java` | `` |  | apply, getEnv, construct |
| top-level / `link/star_dust/yaml/snakeyaml/error/Mark.java` | `` |  | toCodePoints, isLineBreak, get_snippet, get_snippet, toString, getName, getLine, getColumn, getIndex, getBuffer, getPointer |
| top-level / `link/star_dust/yaml/snakeyaml/error/MarkedYAMLException.java` | `` |  | getMessage, toString, getContext, getContextMark, getProblem, getProblemMark |
| top-level / `link/star_dust/yaml/snakeyaml/error/MissingEnvironmentVariableException.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/error/YAMLException.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/events/AliasEvent.java` | `` |  | getEventId |
| top-level / `link/star_dust/yaml/snakeyaml/events/CollectionEndEvent.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/events/CollectionStartEvent.java` | `` |  | getTag, getImplicit, getFlowStyle, getArguments, isFlow |
| top-level / `link/star_dust/yaml/snakeyaml/events/CommentEvent.java` | `` |  | getValue, getCommentType, getArguments, getEventId |
| top-level / `link/star_dust/yaml/snakeyaml/events/DocumentEndEvent.java` | `` |  | getExplicit, getEventId |
| top-level / `link/star_dust/yaml/snakeyaml/events/DocumentStartEvent.java` | `` |  | getExplicit, getVersion, getTags, getEventId |
| top-level / `link/star_dust/yaml/snakeyaml/events/Event.java` | `` |  | toString, getStartMark, getEndMark, getArguments, is, equals, hashCode |
| top-level / `link/star_dust/yaml/snakeyaml/events/ImplicitTuple.java` | `` |  | canOmitTagInPlainScalar, canOmitTagInNonPlainScalar, bothFalse, toString |
| top-level / `link/star_dust/yaml/snakeyaml/events/MappingEndEvent.java` | `` |  | getEventId |
| top-level / `link/star_dust/yaml/snakeyaml/events/MappingStartEvent.java` | `` |  | getEventId |
| top-level / `link/star_dust/yaml/snakeyaml/events/NodeEvent.java` | `` |  | getAnchor, getArguments |
| top-level / `link/star_dust/yaml/snakeyaml/events/ScalarEvent.java` | `` |  | getTag, getScalarStyle, getStyle, getValue, getImplicit, getArguments, getEventId, isPlain |
| top-level / `link/star_dust/yaml/snakeyaml/events/SequenceEndEvent.java` | `` |  | getEventId |
| top-level / `link/star_dust/yaml/snakeyaml/events/SequenceStartEvent.java` | `` |  | getEventId |
| top-level / `link/star_dust/yaml/snakeyaml/events/StreamEndEvent.java` | `` |  | getEventId |
| top-level / `link/star_dust/yaml/snakeyaml/events/StreamStartEvent.java` | `` |  | getEventId |
| top-level / `link/star_dust/yaml/snakeyaml/extensions/compactnotation/CompactConstructor.java` | `` |  | constructCompactFormat, createInstance, setProperties, getCompactData, getCompactConstruct, createCompactConstruct, getConstructor, applySequence, getSequencePropertyName, construct2ndStep, construct |
| top-level / `link/star_dust/yaml/snakeyaml/extensions/compactnotation/CompactData.java` | `` |  | getPrefix, getProperties, getArguments, toString |
| top-level / `link/star_dust/yaml/snakeyaml/extensions/compactnotation/PackageCompactConstructor.java` | `` |  | getClassForName |
| top-level / `link/star_dust/yaml/snakeyaml/external/biz/base64Coder/Base64Coder.java` | `` |  | encodeString, encodeLines, encodeLines, encode, encode, encode, decodeString, decodeLines, decode, decode, decode |
| top-level / `link/star_dust/yaml/snakeyaml/external/com/google/gdata/util/common/base/Escaper.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/external/com/google/gdata/util/common/base/PercentEscaper.java` | `` |  | createSafeOctets, nextEscapeIndex, escape, escape |
| top-level / `link/star_dust/yaml/snakeyaml/external/com/google/gdata/util/common/base/UnicodeEscaper.java` | `` |  | initialValue, nextEscapeIndex, escape, escapeSlow, escape, append, append, append, outputChars, codePointAt, growBuffer |
| top-level / `link/star_dust/yaml/snakeyaml/introspector/BeanAccess.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/introspector/FieldProperty.java` | `` |  | set, get, getAnnotations, getAnnotation |
| top-level / `link/star_dust/yaml/snakeyaml/introspector/GenericProperty.java` | `` |  | getActualTypeArguments |
| top-level / `link/star_dust/yaml/snakeyaml/introspector/MethodProperty.java` | `` |  | discoverGenericType, set, get, getAnnotations, getAnnotation, isWritable, isReadable |
| top-level / `link/star_dust/yaml/snakeyaml/introspector/MissingProperty.java` | `` |  | getActualTypeArguments, set, get, getAnnotations, getAnnotation |
| top-level / `link/star_dust/yaml/snakeyaml/introspector/Property.java` | `` |  | getType, getName, toString, compareTo, isWritable, isReadable, hashCode, equals |
| top-level / `link/star_dust/yaml/snakeyaml/introspector/PropertySubstitute.java` | `` |  | getActualTypeArguments, setActualTypeArguments, set, get, getAnnotations, getAnnotation, setTargetType, discoverMethod, getName, getType, isReadable, isWritable, setDelegate |
| top-level / `link/star_dust/yaml/snakeyaml/introspector/PropertyUtils.java` | `` |  | getPropertiesMap, isTransient, getProperties, getProperties, createPropertySet, getProperty, getProperty, setBeanAccess, setAllowReadOnlyProperties, isAllowReadOnlyProperties, setSkipMissingProperties, isSkipMissingProperties |
| top-level / `link/star_dust/yaml/snakeyaml/LoaderOptions.java` | `` |  | isAllowDuplicateKeys, setAllowDuplicateKeys, isWrappedToRootException, setWrappedToRootException, getMaxAliasesForCollections, setMaxAliasesForCollections, setAllowRecursiveKeys, getAllowRecursiveKeys, setProcessComments, isProcessComments, isEnumCaseSensitive, setEnumCaseSensitive |
| top-level / `link/star_dust/yaml/snakeyaml/nodes/AnchorNode.java` | `` |  | getNodeId, getRealNode |
| top-level / `link/star_dust/yaml/snakeyaml/nodes/CollectionNode.java` | `` |  | getFlowStyle, setFlowStyle, setFlowStyle, setEndMark |
| top-level / `link/star_dust/yaml/snakeyaml/nodes/MappingNode.java` | `` |  | getNodeId, getValue, setValue, setOnlyKeyType, setTypes, toString, setMerged, isMerged |
| top-level / `link/star_dust/yaml/snakeyaml/nodes/Node.java` | `` |  | getTag, getEndMark, getStartMark, setTag, equals, getType, setType, setTwoStepsConstruction, isTwoStepsConstruction, hashCode, useClassConstructor, setUseClassConstructor, isResolved, getAnchor, setAnchor, getInLineComments, setInLineComments, getBlockComments, setBlockComments, getEndComments, setEndComments |
| top-level / `link/star_dust/yaml/snakeyaml/nodes/NodeId.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/nodes/NodeTuple.java` | `` |  | getKeyNode, getValueNode, toString |
| top-level / `link/star_dust/yaml/snakeyaml/nodes/ScalarNode.java` | `` |  | getStyle, getScalarStyle, getNodeId, getValue, toString, isPlain |
| top-level / `link/star_dust/yaml/snakeyaml/nodes/SequenceNode.java` | `` |  | getNodeId, getValue, setListType, toString |
| top-level / `link/star_dust/yaml/snakeyaml/nodes/Tag.java` | `` |  | isSecondary, getValue, startsWith, getClassName, toString, equals, hashCode, isCompatible, matches |
| top-level / `link/star_dust/yaml/snakeyaml/parser/Parser.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/parser/ParserException.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/parser/ParserImpl.java` | `` |  | checkEvent, peekEvent, getEvent, produceCommentEvent, processDirectives, parseFlowNode, parseBlockNodeOrIndentlessSequence, parseNode, processEmptyScalar, produce, produce, produce, produce, produce, produce, produce, produce, produce, produce, produce, produce, produce, produce, produce, produce, produce, produce, produce, produce, produce, produce, produce |
| top-level / `link/star_dust/yaml/snakeyaml/parser/Production.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/parser/VersionTagsTuple.java` | `` |  | getVersion, getTags, toString |
| top-level / `link/star_dust/yaml/snakeyaml/reader/ReaderException.java` | `` |  | getName, getCodePoint, getPosition, toString |
| top-level / `link/star_dust/yaml/snakeyaml/reader/StreamReader.java` | `` |  | isPrintable, isPrintable, getMark, forward, forward, peek, peek, prefix, prefixForward, ensureEnoughData, ensureEnoughData, update, getColumn, getIndex, getLine |
| top-level / `link/star_dust/yaml/snakeyaml/reader/UnicodeReader.java` | `` |  | getEncoding, init, close, read |
| top-level / `link/star_dust/yaml/snakeyaml/representer/BaseRepresenter.java` | `` |  | put, represent, representData, representScalar, representScalar, representSequence, representMapping, setDefaultScalarStyle, getDefaultScalarStyle, setDefaultFlowStyle, getDefaultFlowStyle, setPropertyUtils, getPropertyUtils, isExplicitPropertyUtils |
| top-level / `link/star_dust/yaml/snakeyaml/representer/Represent.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/representer/Representer.java` | `` |  | addTypeDescription, setPropertyUtils, representJavaBean, representJavaBeanProperty, checkGlobalTag, resetTag, getProperties, representData |
| top-level / `link/star_dust/yaml/snakeyaml/representer/SafeRepresenter.java` | `` |  | getTag, addClassTag, getTimeZone, setTimeZone, representData, representData, representData, representData, representData, representData, representData, asByteList, asShortList, asIntList, asLongList, asFloatList, asDoubleList, asCharList, asBooleanList, representData, iterator, representData, representData, representData, representData, representData, representData |
| top-level / `link/star_dust/yaml/snakeyaml/resolver/Resolver.java` | `` |  | addImplicitResolvers, addImplicitResolver, resolve |
| top-level / `link/star_dust/yaml/snakeyaml/resolver/ResolverTuple.java` | `` |  | getTag, getRegexp, toString |
| top-level / `link/star_dust/yaml/snakeyaml/scanner/Constant.java` | `` |  | has, hasNo, has, hasNo |
| top-level / `link/star_dust/yaml/snakeyaml/scanner/Scanner.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/scanner/ScannerException.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/scanner/ScannerImpl.java` | `` |  | setEmitComments, isEmitComments, checkToken, peekToken, getToken, needMoreTokens, fetchMoreTokens, nextPossibleSimpleKey, stalePossibleSimpleKeys, savePossibleSimpleKey, removePossibleSimpleKey, unwindIndent, addIndent, fetchStreamStart, fetchStreamEnd, fetchDirective, fetchDocumentStart, fetchDocumentEnd, fetchDocumentIndicator, fetchFlowSequenceStart, fetchFlowMappingStart, fetchFlowCollectionStart, fetchFlowSequenceEnd, fetchFlowMappingEnd, fetchFlowCollectionEnd, fetchFlowEntry, fetchBlockEntry, fetchKey, fetchValue, fetchAlias, fetchAnchor, fetchTag, fetchLiteral, fetchFolded, fetchBlockScalar, fetchSingle, fetchDouble, fetchFlowScalar, fetchPlain, checkDirective, checkDocumentStart, checkDocumentEnd, checkBlockEntry, checkKey, checkValue, checkPlain, scanToNextToken, scanComment, scanDirective, scanDirectiveName, scanYamlDirectiveValue, scanYamlDirectiveNumber, scanTagDirectiveValue, scanTagDirectiveHandle, scanTagDirectivePrefix, scanDirectiveIgnoredLine, scanAnchor, scanTag, scanBlockScalar, scanBlockScalarIndicators, scanBlockScalarIgnoredLine, scanBlockScalarIndentation, scanBlockScalarBreaks, scanFlowScalar, scanFlowScalarNonSpaces, scanFlowScalarSpaces, scanFlowScalarBreaks, scanPlain, scanPlainSpaces, scanTagHandle, scanTagUri, scanUriEscapes, scanLineBreak, makeTokenList, chompTailIsNotFalse, chompTailIsTrue, getIncrement |
| top-level / `link/star_dust/yaml/snakeyaml/scanner/SimpleKey.java` | `` |  | getTokenNumber, getColumn, getMark, getIndex, getLine, isRequired, toString |
| top-level / `link/star_dust/yaml/snakeyaml/serializer/AnchorGenerator.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/serializer/NumberAnchorGenerator.java` | `` |  | nextAnchor |
| top-level / `link/star_dust/yaml/snakeyaml/serializer/Serializer.java` | `` |  | open, close, serialize, anchorNode, serializeNode, serializeComments |
| top-level / `link/star_dust/yaml/snakeyaml/serializer/SerializerException.java` | `` |  |  |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/AliasToken.java` | `` |  | getValue, getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/AnchorToken.java` | `` |  | getValue, getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/BlockEndToken.java` | `` |  | getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/BlockEntryToken.java` | `` |  | getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/BlockMappingStartToken.java` | `` |  | getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/BlockSequenceStartToken.java` | `` |  | getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/CommentToken.java` | `` |  | getCommentType, getValue, getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/DirectiveToken.java` | `` |  | getName, getValue, getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/DocumentEndToken.java` | `` |  | getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/DocumentStartToken.java` | `` |  | getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/FlowEntryToken.java` | `` |  | getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/FlowMappingEndToken.java` | `` |  | getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/FlowMappingStartToken.java` | `` |  | getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/FlowSequenceEndToken.java` | `` |  | getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/FlowSequenceStartToken.java` | `` |  | getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/KeyToken.java` | `` |  | getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/ScalarToken.java` | `` |  | getPlain, getValue, getStyle, getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/StreamEndToken.java` | `` |  | getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/StreamStartToken.java` | `` |  | getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/TagToken.java` | `` |  | getValue, getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/TagTuple.java` | `` |  | getHandle, getSuffix |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/Token.java` | `` |  | getStartMark, getEndMark, toString |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/ValueToken.java` | `` |  | getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/tokens/WhitespaceToken.java` | `` |  | getTokenId |
| top-level / `link/star_dust/yaml/snakeyaml/TypeDescription.java` | `` |  | getTag, setTag, setTag, getType, putListPropertyType, getListPropertyType, putMapPropertyType, getMapKeyType, getMapValueType, addPropertyParameters, toString, checkDelegates, discoverProperty, getProperty, substituteProperty, substituteProperty, setPropertyUtils, setIncludes, setExcludes, getProperties, setupPropertyType, setProperty, newInstance, newInstance, finalizeConstruction |
| top-level / `link/star_dust/yaml/snakeyaml/util/ArrayStack.java` | `` |  | push, pop, isEmpty, clear |
| top-level / `link/star_dust/yaml/snakeyaml/util/ArrayUtils.java` | `` |  | toUnmodifiableList, toUnmodifiableCompositeList, get, size, get, size |
| top-level / `link/star_dust/yaml/snakeyaml/util/EnumUtils.java` | `` |  | findEnumInsensitiveCase |
| top-level / `link/star_dust/yaml/snakeyaml/util/PlatformFeatureDetector.java` | `` |  | isRunningOnAndroid |
| top-level / `link/star_dust/yaml/snakeyaml/util/UriEncoder.java` | `` |  | encode, decode, decode |
| top-level / `link/star_dust/yaml/snakeyaml/Yaml.java` | `` |  | initDumperOptions, dump, represent, dumpAll, dump, dumpAll, dumpAll, dumpAs, dumpAsMap, serialize, serialize, load, load, load, loadAs, loadAs, loadAs, loadFromReader, loadAll, hasNext, next, remove, loadAll, loadAll, compose, composeAll, hasNext, next, remove, addImplicitResolver, toString, getName, setName, parse, hasNext, next, remove, setBeanAccess, addTypeDescription, iterator, iterator, iterator, getEvents, emit |
| top-level / `module-info.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
