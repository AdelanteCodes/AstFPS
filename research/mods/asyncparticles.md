# AsyncParticles

Review status: **Evidence inventory; behavioral review pending**

Project: [AsyncParticles](https://modrinth.com/mod/asyncparticles)
Selected artifact version: `26.3.2.0-alpha.2`
Published implementation source: https://github.com/Harveykang/AsyncParticles
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Async particle tick, GPU accelerated particle rendering.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `0290f5ae5ebd7ee26290582753dd574ad91aba5778acc2450d2266829f7c21473d1d8ea0b3e29914deabc600186c99add90839cfb65c5eeeadee0863c97d3fc1`
- `sha1`: `2da3dd3f6191638fab225181d6dbe6754deb0968`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 244
Reconstructed Java files: 186

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "fun.qu_an.minecraft.asyncparticles.client.fabric.AsyncParticlesClientFabric"
  ],
  "modmenu": [
    "fun.qu_an.minecraft.asyncparticles.client.config.fabric.AsyncParticlesModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": ">26.2.999",
  "mixinextras": ">=0.5.0",
  "mixinsquared": "*"
}
```

**accessWidener**

```json
"asyncparticles-common.accesswidener"
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/mixinsquared-fabric-0.3.7-beta.3.jar` | 76 | `mixinsquared` | No |
| `META-INF/jars/mixinsquared-neoforge-0.3.7-beta.3.jar` | 2 | `Library/unidentified` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `fun/qu_an/minecraft/asyncparticles/client/addon/AsyncTickableParticleGroup.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/addon/GpuParticleAddon.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/addon/GpuParticleGroup.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/addon/GpuQuadParticleRenderState.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/addon/LightCachedParticleAddon.java` | `` |  | compress, decompress |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/addon/ParticleAddon.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/addon/ParticleEngineAddon.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/addon/ParticleGroupAddition.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/addon/ParticleVertexStorageAddition.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/addon/SpinLockProvider.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/addon/WeatherEffectRendererAddon.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/AsyncParticlesClient.java` | `` |  | init |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/compat/a_good_place/AGoodPlaceCompat.java` | `` |  | onParticleEngineClear |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/compat/cloth_config/AbstractConfigEntryAddon.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/compat/cloth_config/AbstractListListEntryAddon.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/compat/fabric/MappingsImpl.java` | `` |  | getTickParticlesMethod, getRenderMethod, getRenderRotatedQuadMethod1, getRenderRotatedQuadMethod2, getFireworkSparkClass |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/compat/fabric/ModListHelperImpl.java` | `` |  | isClient, isModLoaded, versionCheck, versionToString, isDevelopmentEnvironment |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/compat/Mappings.java` | `` |  | getTickParticlesMethod, getRenderMethod, getRenderRotatedQuadMethod1, getRenderRotatedQuadMethod2 |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/compat/ModListHelper.java` | `` |  | isForge, isClient, isModLoaded, versionCheck, versionToString, isForgeModLoaded, isFabricModLoaded, classExists, loadClass |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/compat/neoforge/ModListHelperImpl.java` | `` |  | isClient, isModLoaded, versionCheck, versionToString, isDevelopmentEnvironment |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/compat/particle_core/ParticleCoreCompat.java` | `` |  | shouldRenderParticle |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/compat/particle_core/ParticleCoreEarlyCompat.java` | `` |  | initEarly, shouldDisable |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/compat/particlerain/ParticleRainCompat.java` | `` |  | onParticleEngineClear |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/compat/particletweaks/ParticleTweaksCompat.java` | `` |  | modifyLayer, modifyQuadSize, modifyOColor, modifyColor |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/AsyncParticlesConfig.java` | `` |  | newConfigScreen, fallBackScreen, load, upgrade, save, reset, save, hashCode, flat, fold, flat, fold, flat, fold, flat, fold, flat, fold, flat, fold |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/AsyncParticlesMixinConfig.java` | `` |  | upgrade, fold, read, write, getSet, getBoolean, assertNotGlobal |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/ClothConfigMenus.java` | `` |  | screen, buildParticleCategory, buildTickCategory, buildRenderingCategory, buildIntegrationCategory, buildMobileCategory, buildMixinCategory, buildDevCategory, incompatibilityTooltip, limitedTooltip, create, originalConfig, create, originalConfig |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/CompatibilityTryItButton.java` | `` |  | onPress, extractContents, getComponent, getSelect, isMatch, isMatch, isMatch, isMatch, isMatch, isMatch, isMatch, isMatch, preserve, getComponent, getTooltipComponent |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/ComputeExecutionStage.java` | `` |  | getComponent |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/ConfigHelper.java` | `` |  | isAsyncAnimateTick, particleLightCache, suppressCME, isAsyncParticleTick, isSplitParticleTick, getParticleLimit, getTickFailurePerSecondThreshold, isCullUnderwaterParticleType, isTickWeatherAsync, isDeferredTextureTick, getSyncAnimationClassesTick, getSyncParticleClassesTick, isGpuParticles, isParallelQueueRemoval, isParallelQueueEviction, isAppendNewParticlesToRenderer, isGpuOnlyAsyncParticleTick, mobileCompatMultiDraw, getComputeExecutionStage, isTickRendererOnMainThread, getParticleCleanupStrategy |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/DevRuntimeDebug.java` | `` |  | isSyncAllParticles, apply |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/fabric/AsyncParticlesModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/FailBehavior.java` | `` |  | getComponent |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/FallbackScreen.java` | `` |  | init, getButtonLeftCallback, getButtonRightCallback, repositionElements, getNarrationMessage, shouldCloseOnEsc, tick |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/MixinConfigHelper.java` | `` |  | getNoLightCache, getLockProvider, getLockRequired, getReplaceRandom, isSafeLegacyRandomSource, isSafeClassInstanceMultiMap, isSafeBlockEntityMap, getAsyncTickableParticleGroups |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/ParticleAsyncMode.java` | `` |  | getComponent |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/ParticleCleanupStrategy.java` | `` |  | getComponent |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/ParticleCullingMode.java` | `` |  | getComponent |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/RainEffect.java` | `` |  | getComponent |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/StringListListEntryFixRestart.java` | `` |  | isRequiresRestart |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/SubCategoryListEntryFix.java` | `` |  | isRequiresRestart |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/config/TickMode.java` | `` |  | getComponent |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/backend/Backend.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/backend/Backends.java` | `` |  | getGl, getGlTf, getGlCs, getVkCaps, init, supportsGpuAcceleration, isGl, isVk, debugInfo |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/backend/GlCommands.java` | `` |  | isSupported, directStateAccess, vertexAttribBinding, toString, toString, genTransformFeedback, glBindTransformFeedbackBufferBase, glBindTransformFeedbackBufferRange, isTfObjectSupported, genTransformFeedback, deleteTransformFeedback, glBindTransformFeedbackBufferBase, glBindTransformFeedbackBufferRange, glBindTransformFeedback, glPauseTransformFeedback, glResumeTransformFeedback, isTfObjectSupported, isSupported, genTransformFeedback, deleteTransformFeedback, glBindTransformFeedback, glBindTransformFeedbackBuffer, glBindTransformFeedbackBufferBase, glBindTransformFeedbackBufferRange, glBeginTransformFeedback, glEndTransformFeedback, glPauseTransformFeedback, glResumeTransformFeedback, glTransformFeedbackVaryings, isTfObjectSupported, isSupported, genTransformFeedback, deleteTransformFeedback, glBindTransformFeedback, glBindTransformFeedbackBuffer, glBindTransformFeedbackBufferBase, glBindTransformFeedbackBufferRange, glBeginTransformFeedback, glEndTransformFeedback, glPauseTransformFeedback, glResumeTransformFeedback, glTransformFeedbackVaryings, toString, isSupported, glBindShaderStorageBuffer, glBindShaderStorageBufferBase, glShaderStorageBufferData, isSupported, glBindShaderStorageBuffer, glBindShaderStorageBufferBase, glShaderStorageBufferData, isSupported, glMultiDrawArrays, glCopyBufferSubData, glBufferData, glGenBuffers, glGenVertexArrays, glMapBufferRange, glFlushMappedBufferRange, glUnmapBuffer, glMultiDrawArrays, glCopyBufferSubData, glBufferData, glGenBuffers, glGenVertexArrays, glMapBufferRange, glFlushMappedBufferRange, glUnmapBuffer, glMultiDrawArrays, glCopyBufferSubData, glBufferData, glGenBuffers, glGenVertexArrays, glMapBufferRange, glFlushMappedBufferRange, glUnmapBuffer |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/backend/VkCommands.java` | `` |  | isSupported, pushDescriptor, synchronization2, toString, isSupported |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/Diagnostic.java` | `` |  | sendChat, illegalEntityStorageAccess, illegalBlockEntityStorageAccess, errorAsyncParticleTick, isTemporaryGpuOnlyAsyncParticleTick, errorAsyncGpuParticleTick, isTemporaryDisableAsyncParticleTick, errorAsyncAnimateTick, isTemporaryDisableAnimationTick, errorAsyncWeatherTick, isTemporaryDisableAsyncRainTick |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/fabric/GameUtilImpl.java` | `` |  | infinityAABB |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/GameUtil.java` | `` |  | infinityAABB, id, getReportedException, getLightColorFromNeighbor |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/neoforge/GameUtilImpl.java` | `` |  | infinityAABB |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/gpu_acceleration/ComputeResult.java` | `` |  | ComputeResult, of, ofIndirect, ofIndirect, totalVertexCount, totalIndexCount, isIndirect, maxIndexCount, ParticleSlice, vertexOffset, vertexCount, indexCount, indexOffset |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/gpu_acceleration/GpuParticleBehavior.java` | `` |  | init, getInstance, flushBufferAndSwap, getPerTickCameraPos, canRenderFast, canRenderFast, canRenderFast0, findDeclaringClass, initRendering, setUpNextTickRendering, getPartialTicks, beginFrame, createRenderer, onClearParticles, compute, ensureComputeReady, getOrCreateRenderer, onAddGpu, getParticleLimit, close |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/gpu_acceleration/GpuParticlePipelines.java` | `` |  | of, glBindAttr |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/gpu_acceleration/IParticleRenderer.java` | `` |  | shouldRenderParticle |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/gpu_acceleration/LayerBatch.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/gpu_acceleration/opengl/GlTfParticleRenderer.java` | `` |  | beginFrame, flushBufferAndSwap, acquireSourceSlot, waitForSourceSlot, waitForAllSourceSlots, extractAppendParticles, prepareBuffer, isMapped, isShouldSkip, tick, compute, awaitCompute, buildDrawStuffs, append, resize, getComputeLayers, close, reset |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/gpu_acceleration/opengl/ParticleTransformFeedbackShader.java` | `` |  | use, setup |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/gpu_acceleration/opengl/ParticleVertexBuffer.java` | `` |  | unbind, bind, ensureSize, resize, map, map, mapRange, flush, flush, unmap, flushAndUnmap, delete, delete, getSize, isMapped |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/gpu_acceleration/opengl/ShaderCompiler.java` | `` |  | createShaderProgram, createShaderProgram |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/gpu_acceleration/vulkan/VkCompParticleRenderer.java` | `` |  | createSourceBuffers, createTargetBuffers, createIndirectionBuffers, findMemType, createComputePipeline, loadSpirv, createCommandResources, destroyDescriptorResources, beginFrame, isMapped, isShouldSkip, prepareBuffer, flushBufferAndSwap, extractAppendParticles, acquireSourceSlot, acquireSubmitSlot, tick, append, compute, dispatch, awaitCompute, resize, getComputeLayers, reset, waitForAllSubmissions, close, createBuffer, destroy, recreateBufferPreservingContents, buildLayout, writeSegmentGroups, reset, waitReady, createIndirectionBuffer, ensureIndirectionSize, isPreparedFor, uploadGroupRecords, createTargetBuffer, destroy, isClosed, close, map, ensureTargetSize, clearPrepared, updateDescriptorFor, destroy, waitReady, prepare |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/ParticleHelper.java` | `` |  | newParticleQueue, newParticleQueue, newBusyWaitParticleQueue, newBusyWaitParticleQueue, onClearParticles, doFirstRefresh |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/TaskContainer.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/TaskHelper.java` | `` |  | addTask, addTasks, groupTasks, groupTasks, submitImmediately, submitAll, submitAll, submitAll, waitForCompletion, executor, isRunning, runAllTasks, disposeTasks, taskCount, run, run, runAll |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/tick/AsyncTickBehavior.java` | `` |  | getInstance, ensureLevelRunning, ensureLevelRunning, addTaskEnsureLevelRunning, addTaskEnsureLevelRunning, shouldRemove, preTick, prepareCleanupTasks, doEmittersRemoveIf, doParticlesRemoveIf, doRemoveIf, postTick, reloadLater, tryReload, reload, reset, debugLater, shouldSync, shouldSyncAnimateTick, isTailTick, getExecutor, getTickTaskManager, getCleanupTaskManager, isParticlePhase, dumpParticles, getLevelBundle, getExceptionHandler |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/tick/AsyncTickerThread.java` | `` |  | onTermination |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/tick/AsyncTickParticleGroupBehavior.java` | `` |  | canTickAsync |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/tick/LevelBundle.java` | `` |  | LevelBundle, isLevelRunning, isLevelAvailable, isLevelAvailable, isLevelReset |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/tick/TickExceptionHandler.java` | `` |  | isTolerable, onTickParticleException, tickExceptionally, constructCrashReport, resetCancelled |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/tick/TickParticleRecursiveAction.java` | `` |  | execute, compute |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/particle/tick/TrackedParticleCountsMap.java` | `` |  | containsKey, containsValue, containsValue, addTo, put, get, getInt, clear |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/core/Phase.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/adjusters/AdjusterParticlesAsyncTickableGroup.java` | `` |  | getMixinClassName, getTargets, getRefMapperConfig |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/adjusters/AdjusterParticlesLockProvider.java` | `` |  | getMixinClassName, getTargets, getRefMapperConfig |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/adjusters/AdjusterParticlesLockRequired_Extract.java` | `` |  | getMixinClassName, getTargets, getRefMapperConfig |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/adjusters/AdjusterParticlesLockRequired_Tick.java` | `` |  | getMixinClassName, getTargets, getRefMapperConfig |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/adjusters/AdjusterParticlesNoLightCache.java` | `` |  | getMixinClassName, getTargets, getRefMapperConfig |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/adjusters/AdjusterReplaceRandom.java` | `` |  | getMixinClassName, getTargets, getRefMapperConfig |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/AsyncParticlesMixinErrorHandler.java` | `` |  | onPrepareError, onApplyError |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/AsyncParticlesMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/cancellers/AsyncParticlesMixinCanceller.java` | `` |  | shouldCancel |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/cancellers/AsyncParticlesMixinMemberCanceller.java` | `` |  | preCancel, shouldCancelMethod, shouldCancelField |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/mixin_extension/class_adjuster/ClassAdjusterMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/mixin_extension/class_adjuster/ClassRenamer.java` | `` |  | renameClass |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/mixin_extension/class_adjuster/MixinClassAdjuster.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/mixin_extension/class_adjuster/MixinClassAdjusterApplication.java` | `` |  | init, getInstance, getGeneratedMixinPrefix, getOriginalMixin, shouldApplyMixin, apply, applyAdjuster, remapAt, genClass, preApply, postApply |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/mixin_extension/class_adjuster/MixinClassAdjusterRegistrar.java` | `` |  | register, register |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/mixin_extension/class_adjuster/MixinClassProvider.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/mixin_extension/class_adjuster/MixinServiceWrapper.java` | `` |  | getBytecodeProvider, getClassNode, getClassNode, getClassNode, getName, isValid, prepare, getInitialPhase, offer, init, beginPhase, checkEnv, getReEntranceLock, getClassProvider, getTransformerProvider, getClassTracker, getAuditTrail, getFeatureValidator, getAdviceProvider, getPlatformAgents, getPrimaryContainer, getMixinContainers, getResourceAsStream, getSideName, getMinCompatibilityLevel, getMaxCompatibilityLevel, getLogger |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/mixin_extension/class_adjuster/MixinTransformerExtension.java` | `` |  | getPendingConfigs, tryAs, recursiveGetDelegate |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/mixin_extension/member_canceller/ExtensionMemberCancelApplication.java` | `` |  | checkActive, preApply, cancelMethod, cancelField, postApply, export |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/mixin_extension/member_canceller/MixinMemberCanceller.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/mixin_extension/member_canceller/MixinMemberCancellerRegistrar.java` | `` |  | register |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/MixinUtil.java` | `` |  | tryAs, getRefMapperName |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/coremod/neoforge/APMixinPluginNeoForge.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/fabric/AsyncParticlesClientFabric.java` | `` |  | suggestModId, onInitializeClient |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/fabric/FabricPlatform.java` | `` |  | isForge, isClient, isModLoaded, isForgeModLoaded, isFabricModLoaded, versionCheck, versionToString, isDevelopmentEnvironment, infinityAABB |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/a_good_place/AccessorBlocksParticlesManager.java` | `value={BlocksParticlesManager.class})` | Accessor:1, Invoker:1 | accessor_getHiddenBlocks, invoker_markBlockForRender |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/a_good_place/MixinBlocksParticlesManager.java` | `value={BlocksParticlesManager.class})` | Inject:1 | onInit |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/a_good_place/MixinPlacingBlockParticle.java` | `value={PlacingBlockParticle.class})` |  | remove |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/cloth_config/AbstractConfigEntryAccessor.java` | `value={AbstractConfigEntry.class})` | Accessor:1 |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/cloth_config/AbstractConfigListEntryAccessor.java` | `value={AbstractConfigListEntry.class})` | Accessor:1 |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/cloth_config/AccessorAbstractConfigScreen.java` | `value={AbstractConfigScreen.class})` | Accessor:1 |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/cloth_config/AccessorBaseListEntry.java` | `value={BaseListEntry.class})` | Accessor:2 |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/cloth_config/AccessorSubCategoryListEntry.java` | `value={SubCategoryListEntry.class})` | Accessor:1 |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/cloth_config/MixinAbstractListListEntry.java` | `value={AbstractListListEntry.class})` |  | asyncparticles$setOriginal |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/cloth_config/MixinBooleanListEntry.java` | `value={BooleanListEntry.class})` |  | asyncparticles$setOriginal |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/cloth_config/MixinSelectionListEntry.java` | `value={SelectionListEntry.class})` |  | asyncparticles$setOriginal |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/cloth_config/MixinTextFieldListEntry.java` | `value={TextFieldListEntry.class})` |  | asyncparticles$setOriginal |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/cosycritters/MixinBirdParticle.java` | `value={BirdParticle.class}, remap=false)` | WrapOperation:1, Inject:1 | onInit, onInit |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/modernui/MixinRenderSystem.java` | `value={RenderSystem.class}, priority=1500, remap=false)` | Inject:1 | onRenderThread |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/particlerain/MixinParticleEngine.java` | `value={ParticleEngine.class}, priority=1500)` | Inject:1 | tick |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/particlerain/MixinParticleRain.java` | `value={ParticleRain.class})` | Redirect:1 | modifyParticleCount |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/particlerain/MixinParticleSpawner.java` | `value={ParticleSpawner.class})` | WrapMethod:1, WrapWithCondition:1, ModifyExpressionValue:1 | wrapTick, onTickBlockFX, modifyParticleCount |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/particlerain/MixinWeatherParticle.java` | `value={WeatherParticle.class})` | Redirect:2 | modifyParticleCount, modifyParticleCount |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/particletweaks/MixinMixinSingleQuadParticle.java` | `value={SingleQuadParticle.class}, priority=1500)` | ModifyReturnValue:2, WrapMethod:1, ModifyExpressionValue:1 | wrapGetLayer, wrapGetQuadSize, wrapGetOColor, wrapGetColor |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/sodium_extra/MixinFireworkParticles$Starter.java` | `value={FireworkParticles.Starter.class}, priority=1500)` | Redirect:1 | addExplosionParticle |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/compat/sodium_extra/MixinParticleEngine.java` | `value={ParticleEngine.class}, priority=1500)` | Redirect:1 | addParticle |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/conditional/Mixin_ReplaceRandom.java` | `value={Particle.class, ParticleEngine.class, Font.class}, priority=9000)` | WrapOperation:1 | onCreateRandomSource |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/conditional/MixinAsyncTick_AsyncTickableParticleGroup.java` | `value={QuadParticleGroup.class, ItemPickupParticleGroup.class, ElderGuardianParticleGroup.class})` | Inject:1, ModifyExpressionValue:1, Redirect:3 | injectExtra, wrapNext, asyncparticles$addSyncParticle, asyncparticles$addSyncGpuParticle, redirectStream, redirectForEach, redirectIterator, asyncparticles$canTickAsync, asyncparticles$tickSyncParticles, asyncparticles$isSyncParticle |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/conditional/MixinClassInstanceMultiMap_SafeClassInstanceMultiMap_Off.java` | `value={ClassInstanceMultiMap.class}, priority=1500)` | WrapMethod:3 | onGetAllInstances, onIterator, onFind |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/conditional/MixinClassInstanceMultiMap_SafeClassInstanceMultiMap_On.java` | `value={ClassInstanceMultiMap.class}, priority=1500)` | Inject:1, Redirect:3, ModifyVariable:1 | newHashMap, put, collect1, collect2, modifyCreateAllOfType |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/conditional/MixinLegacyRandomSource.java` | `value={LegacyRandomSource.class})` | Inject:2 | safeify, safeify |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/conditional/MixinLevelChunk_SafeBlockEntityMap_Off.java` | `value={LevelChunk.class}, priority=1500)` | Inject:2 | onGetBlockEntity, onInit1 |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/conditional/MixinLevelChunk_SafeBlockEntityMap_On.java` | `value={LevelChunk.class}, priority=1500)` | Inject:2 | onInit1, onGetBlockEntity |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/conditional/MixinParticles_LightCacheNoRefresh.java` | `value={HugeExplosionParticle.class, AttackSweepParticle.class, FireflyParticle.class, SimpleAnimatedParticle.class, GustParticle.class, TrailParticle.class})` |  | asyncparticles$isStaticLight, asyncparticles$refresh |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/conditional/MixinParticles_LockProvider.java` | `value={Particle.class})` |  | asyncparticles$getSpinLock |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/conditional/MixinParticles_LockRequired_Extract.java` | `value={SingleQuadParticle.class})` | WrapMethod:1 | wrapTick |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/conditional/MixinParticles_LockRequired_Tick.java` | `value={Particle.class})` | WrapMethod:1 | wrapTick |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/animate_tick/MixinClientLevel.java` | `value={ClientLevel.class}, priority=1100)` | WrapMethod:1, Inject:1, WrapOperation:2 | animateTick, onAnimateTickHead, asyncparticles_shouldSyncAnimateTick, asyncparticles_shouldSyncAnimateTick, asyncparticles$getRandom |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/animate_tick/MixinWaterFluid.java` | `value={WaterFluid.class})` | WrapWithCondition:1 | cullUnderWaterParticleType |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/deffered_texture_tick/MixinTextureManager.java` | `value={TextureManager.class})` | WrapMethod:2, Inject:1 | wrapTick, onClose, wrapReload |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/MixinRenderSystem.java` | `value={RenderSystem.class})` | Inject:2 | onInitRenderer, onInitRendererLate |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/gpu_acceleration/MixinDustColorTransitionParticle.java` | `value={DustColorTransitionParticle.class})` |  | asyncparticles$getOColor, asyncparticles$getColor |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/gpu_acceleration/MixinFireworkParticles.java` | `value={FireworkParticles.OverlayParticle.class}); value={FireworkParticles.SparkParticle.class})` |  | asyncparticles$getOColor, asyncparticles$getColor, asyncparticles$shouldRender |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/gpu_acceleration/MixinFlyTowardsPositionParticle.java` | `value={FlyTowardsPositionParticle.class})` |  | asyncparticles$getOColor, asyncparticles$getColor |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/gpu_acceleration/MixinLevelExtractor.java` | `value={LevelExtractor.class})` | Inject:1 | extractLevelHead |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/gpu_acceleration/MixinLevelRenderer.java` | `value={LevelRenderer.class})` | Inject:1 | renderLevelHead |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/gpu_acceleration/MixinMinecraft.java` | `value={Minecraft.class})` | Inject:2 | close, afterSetLevel |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/gpu_acceleration/MixinParticleEngine.java` | `value={ParticleEngine.class}, priority=500)` | Inject:1 | tick, asyncparticles$tickRenderer |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/gpu_acceleration/MixinParticleGroup.java` | `value={ParticleGroup.class})` | WrapOperation:2, ModifyExpressionValue:1, WrapMethod:1 | wrapIsEmpty, injectAdd, wrapAddToQueue, wrapSize |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/gpu_acceleration/MixinQuadParticleFeatureRenderer.java` | `value={QuadParticleFeatureRenderer.class})` | Inject:2 | getOitPipeline, executeGroupPreDraw, executeGroupPostDraw |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/gpu_acceleration/MixinQuadParticleGroup.java` | `value={QuadParticleGroup.class})` | Inject:1 | onInit, asyncparticles$getGpuParticles, asyncparticles$removeDeadGpuParticles |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/gpu_acceleration/MixinQuadParticleRenderState.java` | `value={QuadParticleRenderState.class})` | ModifyExpressionValue:1 | submit, asyncparticles$gpuParticleGroup, asyncparticles$setGroup |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/gpu_acceleration/MixinSingleQuadParticle.java` | `value={SingleQuadParticle.class})` |  | asyncparticles$postTick, asyncparticles$shouldRender, asyncparticles$getQuadSize, asyncparticles$getU0, asyncparticles$getV0, asyncparticles$getU1, asyncparticles$getV1, asyncparticles$getGpuLightCoords, asyncparticles$getXo, asyncparticles$getYo, asyncparticles$getZo, asyncparticles$getX, asyncparticles$getY, asyncparticles$getZ, asyncparticles$getORoll, asyncparticles$getRoll, asyncparticles$getOColor, asyncparticles$getColor, asyncparticles$getLayer, asyncparticles$getAlpha, asyncparticles$getRed, asyncparticles$getGreen, asyncparticles$getBlue |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/light_cache/MixinParticle.java` | `value={Particle.class})` | WrapMethod:1 | wrapGetLightColor, asyncparticles$refresh, asyncparticles$setLight, asyncparticles$getCachedLight |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/light_cache/MixinParticleEngine.java` | `value={ParticleEngine.class})` | Inject:1 | add |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/light_cache/MixinParticleEngine_FixBlackDestroyParticle.java` | `value={ClientLevel.class})` | Inject:2 | fixBlackDestroyParticle1, fixBlackDestroyParticle2 |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/MixinParticle.java` | `value={Particle.class})` |  | asyncparticles$setTicked, asyncparticles$resetTicked, asyncparticles$isTicked, asyncparticles$enableLightCache, asyncparticles$isEnabledLightCache, asyncparticles$invoke_getLightCoords |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/MixinParticleEngine.java` | `value={ParticleEngine.class})` | Inject:2 | initTail, clearParticles |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/tick/MixinElderGuardianParticleGroup$ElderGuardianParticleRenderState.java` | `value={ElderGuardianParticleGroup.class})` | ModifyArg:1 | modifyParticleRecord |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/tick/MixinItemPickupParticleGroup$ParticleInstance.java` | `value={ItemPickupParticleGroup.class})` | ModifyArg:1 | modifyParticleRecord |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/tick/MixinMinecraft.java` | `value={Minecraft.class})` | Inject:3, Redirect:1 | onPreTick, onPostTick, onSetLevel, redirectParticleEngineTick |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/tick/MixinParticleEngine.java` | `value={ParticleEngine.class})` | Overwrite:1 | tick, asyncparticles$forEach, asyncparticles$forEach |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/particle/tick/MixinParticleGroup.java` | `value={ParticleGroup.class})` | WrapOperation:1, Inject:3, ModifyExpressionValue:3 | redirectNewQueue, injectNewQueue, injectTickParticlesHead, injectTickParticlesTick, asyncparticles$tickParticles, modifyParticleLimit1, modifyParticleLimit2, modifyParticleLimit3, asyncparticles$removeDeadParticles |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/core/weather/MixinClientLevel.java` | `value={ClientLevel.class})` | WrapMethod:1 | wrapTickRain |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/fabric/core/particle/render/MixinParticleEngine.java` | `value={ParticleEngine.class})` |  | asyncparticle$addRenderType |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/neoforge/core/particle/render/MixinParticleEngine.java` | `value={ParticleEngine.class})` |  | asyncparticle$addRenderType |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/off_thread_access/MixinClientChunkCache.java` | `value={ClientChunkCache.class}, priority=500)` | Inject:1 | onLightUpdateWrap |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/off_thread_access/MixinClientLevel.java` | `value={ClientLevel.class}, priority=1500)` | Inject:1 | onInit |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/off_thread_access/MixinEntityGetter.java` | `value={EntityGetter.class})` | Inject:1, WrapOperation:2 |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/off_thread_access/MixinLevel.java` | `value={Level.class}, priority=1500)` | WrapOperation:1 | redirectRandomSource |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/off_thread_access/MixinLevelChunkSection.java` | `value={LevelChunkSection.class})` | WrapMethod:3 | onGetBlockState, onGetFluidState, onGetNoiseBiome |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/off_thread_access/MixinLevelExtractor.java` | `value={LevelExtractor.class}, priority=500)` | Inject:4 | injectSetSectionDirty, injectSetBlockDirty, injectSetBlocksDirty, injectSetSectionRangeDirty |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/off_thread_access/MixinSoundEngine.java` | `value={SoundEngine.class}, priority=500)` | WrapOperation:1 | redirectIsActive |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/mixin/off_thread_access/MixinSoundManager.java` | `value={SoundManager.class})` | Inject:12 | injectReload, injectQueueTickingSound, injectPlay, injectPlayDelayed, injectUpdateSource, injectPauseAllExcept, injectRefreshCategoryVolume, injectStop, injectUpdateCategoryVolume, injectAddListener, injectRemoveListener, injectStop |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/neoforge/AsyncParticlesClientNeoForge.java` | `` |  | suggestModId, registerClientCommands |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/neoforge/NeoForgePlatform.java` | `` |  | isForge, isClient, isModLoaded, isForgeModLoaded, isFabricModLoaded, versionCheck, versionToString, isDevelopmentEnvironment, infinityAABB |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/Platform.java` | `` |  | createPlatform |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/AsyncParticleWorkerThread.java` | `` |  | nextThreadLocalIndex, getThreadLocalValue, ensureIndex, setThreadLocalValue |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/BusyWaitEvictingQueue.java` | `` |  | newInstance, newInstance, add, remove, addAll, removeAll, removeIf, parallelRemoveIf, retainAll, clear, offer, remove, poll |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/CollisionResult.java` | `` |  | CollisionResult |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/CombinedIterable.java` | `` |  | iterator, of, of, ofIterator, ofSet, ofIdentitySet, hasNext, next, remove, isLeft |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/ConcurrentLong2ObjectMap.java` | `` |  | size, isEmpty, containsValue, putAll, long2ObjectEntrySet, iterator, hasNext, next, size, keySet, iterator, nextLong, hasNext, size, values, iterator, hasNext, next, size, get, getOrDefault, containsKey, remove, clear, putIfAbsent, replace, replace, computeIfAbsent, computeIfAbsent, computeIfPresent, compute, merge, forEach |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/ExceptionTracker.java` | `` |  | addException, toString, push, toString |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/ExceptionUtil.java` | `` |  | toThrowDirectly, toThrowDirectly0, getRootCause, throwAssertionError |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/IterationSafeArrayList.java` | `` |  | removeElements, addElements, addAll, addAll, removeAll, removeIf, listIterator, previous, hasPrevious, nextIndex, previousIndex, hasNext, next, remove |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/IterationSafeEvictingQueue.java` | `` |  | newInstance, newInstance, offer, poll, peek, size, isEmpty, spliterator, conditionalIterator, hasNext, resize, arraySize, iterator, add, remove, element, containsAll, addAll, removeAll, retainAll, parallelRemoveIf, parallelRemoveIfSequencedEvicting, parallelRemoveIfParallelEvicting, removeIf, removeIndex, clear, contains, remove, roundUpToPowerOfTwo, toString, characteristics, estimateSize, tryAdvance, forEachRemaining, trySplit, hasNext, next, remove |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/MemStackUtil.java` | `` |  | stackPush, stackGet |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/ParticleThreadLocal.java` | `` |  | withInitial, withInitial, setUnsafe, getUnsafe, getMain, setMain, getSafe, getSafe, get, getFallback, newFallbackThreadLocal, set, remove, setUnsafe, getUnsafe, getMain, setMain, newFallbackThreadLocal |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/ReentrantSpinLock.java` | `` |  | lock, unlock |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/SingleSpinLock.java` | `` |  | lock, unlock |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/SpinLock.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/ThreadUtil.java` | `` |  | assertNotParticleThread, assertNotParticleRendererThread, assertParticleRendererThread, assertNotParticleTickerThread, assertParticleTickerThread, isOnParticleThread, isOnParticleRendererThread, isOnParticleTickerThread, isOnClientTickThread, runOnClient, enqueueClientTask, isOnMainThread, assertOnMainThread |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/TrackedWriteMap.java` | `` |  | onWrite, size, isEmpty, containsKey, containsValue, get, put, putAll, remove, clear, keySet, values, entrySet, putIfAbsent, remove, replace, replace, replaceAll, computeIfAbsent, computeIfPresent, compute, merge, forEach, toString, equals, hashCode |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/TranslatableEnum.java` | `` |  |  |
| top-level / `fun/qu_an/minecraft/asyncparticles/client/util/Utils.java` | `` |  | hasNext, next, remove, forEachRemaining, dummyIterator, nullFuture |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
