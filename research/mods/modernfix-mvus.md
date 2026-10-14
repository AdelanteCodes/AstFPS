# ModernFix-mVUS

Review status: **Evidence inventory; behavioral review pending**

Project: [ModernFix-mVUS](https://modrinth.com/mod/modernfix-mvus)
Selected artifact version: `5.27.20-build.2`
Published implementation source: https://github.com/coredex-source/ModernFix---mVUS
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A fork of ModernFix that adds minor version update support.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `b63337e801fbf2cb420a049d69220c56e083f514`
- `sha512`: `b586434056107aac4ef86e9351d66170dac65a45a1e5f8bd48fb931b3012ab2431b16476eb9c256773339e2b4c60f6f3e90a4709180f700b2aea59ff607f4243`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 268
Reconstructed Java files: 225

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "org.embeddedt.modernfix.ModernFixFabric"
  ],
  "client": [
    "org.embeddedt.modernfix.ModernFixClientFabric"
  ],
  "modmenu": [
    "org.embeddedt.modernfix.fabric.modmenu.ModernFixModMenuApiImpl"
  ],
  "preLaunch": [
    "org.embeddedt.modernfix.ModernFixPreLaunchFabric"
  ]
}
```

**depends**

```json
{
  "minecraft": "~26.3-",
  "fabricloader": ">=0.16.10"
}
```

**breaks**

```json
{
  "dashloader": "<5.0.0-beta.1"
}
```

**accessWidener**

```json
"modernfix.accesswidener"
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/mixinextras-fabric-0.5.4.jar` | 506 | `mixinextras` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `org/embeddedt/modernfix/annotation/ClientOnlyMixin.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/annotation/FeatureLevel.java` | `` |  | isAtLeast |
| top-level / `org/embeddedt/modernfix/annotation/IgnoreOutsideDev.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/annotation/RequiresFeatureLevel.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/annotation/RequiresMod.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/api/constants/IntegrationConstants.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/api/entrypoint/ModernFixClientIntegration.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/blockstate/BlockStateCacheHandler.java` | `` |  | invalidateCache |
| top-level / `org/embeddedt/modernfix/blockstate/FakeStateMap.java` | `` |  | size, isEmpty, containsKey, containsValue, getFastLookup, get, put, remove, putAll, clear, asList, keySet, iterator, size, values, entrySet, size, iterator, hasNext, next |
| top-level / `org/embeddedt/modernfix/blockstate/FerriteCorePostProcess.java` | `` |  | postProcess |
| top-level / `org/embeddedt/modernfix/chunk/SafeBlockGetter.java` | `` |  | shouldUse, getChunkSafe, getMaxY, getMinY, getHeight, getBlockEntity, getBlockState, getFluidState |
| top-level / `org/embeddedt/modernfix/command/ModernFixCommands.java` | `` |  | register |
| top-level / `org/embeddedt/modernfix/common/mixin/bugfix/chunk_deadlock/ChunkMapLoadMixin.java` | `value={ChunkStatusTasks.class})` | Redirect:1, Inject:1 | createSurrogateFuture, completeSurrogateFuture |
| top-level / `org/embeddedt/modernfix/common/mixin/bugfix/chunk_deadlock/EntityMixin.java` | `value={Entity.class})` | WrapWithCondition:1 | onlyAddIfSelfChunkLoaded |
| top-level / `org/embeddedt/modernfix/common/mixin/bugfix/chunk_deadlock/ServerChunkCacheAccessor.java` | `value={ServerChunkCache.class})` | Accessor:1 |  |
| top-level / `org/embeddedt/modernfix/common/mixin/bugfix/chunk_deadlock/ServerLevelMixin.java` | `value={ServerLevel.class})` |  | mfix$getSafeBlockGetter |
| top-level / `org/embeddedt/modernfix/common/mixin/bugfix/cofh_core_crash/FlagManagerMixin.java` | `targets={"cofh/lib/util/flags/FlagManager"}, remap=false)` | Redirect:1 | getFlag |
| top-level / `org/embeddedt/modernfix/common/mixin/bugfix/concurrency/MinecraftMixin.java` | `value={Minecraft.class})` |  | managedBlock |
| top-level / `org/embeddedt/modernfix/common/mixin/bugfix/extra_experimental_screen/CreateWorldScreenMixin.java` | `value={CreateWorldScreen.class})` | ModifyArg:1 | setExperimentalFlag, mfix$setConfirmedWarning, mfix$findWarningMember |
| top-level / `org/embeddedt/modernfix/common/mixin/bugfix/missing_block_entities/LevelChunkMixin.java` | `value={LevelChunk.class})` | Inject:1 | validateBlockEntitiesInChunk, scanSectionForBlockEntities, makeBlockEntityIfNotExists |
| top-level / `org/embeddedt/modernfix/common/mixin/bugfix/paper_chunk_patches/SortedArraySetMixin.java` | `value={SortedArraySet.class})` |  | removeIf |
| top-level / `org/embeddedt/modernfix/common/mixin/bugfix/recipe_book_type_desync/RecipeBookSettingsMixin.java` | `value={RecipeBookSettings.class})` |  |  |
| top-level / `org/embeddedt/modernfix/common/mixin/bugfix/restore_old_dragon_movement/EnderDragonMixin.java` | `value={EnderDragon.class})` | ModifyArg:1 | fixVerticalVelocityScale |
| top-level / `org/embeddedt/modernfix/common/mixin/bugfix/unsafe_modded_shape_caches/ShapeCacheCyclicMixin.java` | `targets={"com/lothrazar/cyclic/block/cable/ShapeCache"}, remap=false)` | Inject:1 | mfix$notify |
| top-level / `org/embeddedt/modernfix/common/mixin/bugfix/unsafe_modded_shape_caches/ShapeCacheRSMixin.java` | `targets={"com/refinedmods/refinedstorage/block/shape/ShapeCache"}, remap=false)` | Inject:1 | mfix$notify |
| top-level / `org/embeddedt/modernfix/common/mixin/bugfix/world_leaks/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | clearLevelDataForLeaks |
| top-level / `org/embeddedt/modernfix/common/mixin/bugfix/world_screen_skipped/WorldSelectionListMixin.java` | `value={WorldSelectionList.WorldListEntry.class})` | Inject:1 | preventClosingCreateScreenAfterDelete |
| top-level / `org/embeddedt/modernfix/common/mixin/core/BootstrapMixin.java` | `value={Bootstrap.class})` | Inject:1 | doModernFixBootstrap |
| top-level / `org/embeddedt/modernfix/common/mixin/core/ClientPlayNetHandlerMixin.java` | `value={ClientPacketListener.class}, priority=1500)` | Inject:1 | signalRecipes |
| top-level / `org/embeddedt/modernfix/common/mixin/core/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Inject:1 | mfix$getLastTickStartTime, trackTickTime |
| top-level / `org/embeddedt/modernfix/common/mixin/devenv/MinecraftMixin.java` | `value={Minecraft.class})` | Overwrite:1 | createUserApiService |
| top-level / `org/embeddedt/modernfix/common/mixin/devenv/NarratorMixin.java` | `value={GameNarrator.class})` | Redirect:1 | useDummyNarrator |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/blockentity_incorrect_thread/ChunkAccessMixin.java` | `value={ChunkAccess.class})` | Inject:1 | wrapInConcurrencyDetector |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/blockentity_incorrect_thread/LevelThreadAccessor.java` | `value={Level.class})` | Accessor:1 |  |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/branding/DebugScreenEntriesInvoker.java` | `value={DebugScreenEntries.class})` | Invoker:1 | mfix$register |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/branding/DebugScreenEntriesMixin.java` | `value={DebugScreenEntries.class})` | ModifyVariable:1 | insertIntoDefaultProfile |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/cause_lag_by_disabling_threads/ChunkRenderDispatcherMixin.java` | `value={SectionRenderDispatcher.class})` | ModifyVariable:1 | computeNumThreads, replaceExecutor |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/cause_lag_by_disabling_threads/UtilMixin.java` | `value={Util.class})` |  |  |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/direct_stack_trace/CrashReportMixin.java` | `value={CrashReport.class})` | Inject:1 | dumpStacktrace |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/mcfunction_profiling/ServerFunctionManagerMixin.java` | `value={ServerFunctionManager.class})` | Inject:4 | resetWatches, startWatch, stopWatch, pruneUnusedWatches, mfix$getProfilingResults |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/measure_time/BootstrapMixin.java` | `value={Bootstrap.class})` | Inject:2 | recordStartTime, printStartTime |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/measure_time/ConnectScreenMixin.java` | `value={ConnectScreen.class})` | Inject:1 | recordConnectStartTime |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/measure_time/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:2 | onClientTick, recordWorldLoadStart |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/measure_time/ProfiledReloadInstanceMixin.java` | `value={ProfiledReloadInstance.class})` | ModifyVariable:2 | getWrappedListeners, sortStates |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/measure_time/SimpleReloadInstanceMixin.java` | `value={SimpleReloadInstance.class})` | ModifyVariable:1 | enableDebugReloader |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/measure_time/WorldLoaderMixin.java` | `value={WorldLoader.class})` | Inject:1, ModifyReturnValue:1 | startStopwatch, finishStopwatch |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/remove_chat_signing/ChatTrustLevelMixin.java` | `value={ChatTrustLevel.class})` | Inject:1 | alwaysShowSecure |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/remove_chat_signing/ProfileKeyPairManagerMixin.java` | `value={ProfileKeyPairManager.class})` | Overwrite:1 | create |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/remove_telemetry/ClientTelemetryManagerMixin.java` | `value={ClientTelemetryManager.class}, priority=1500)` | Inject:1 | disableTelemetrySender |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/remove_telemetry/MinecraftMixin_Telemetry.java` | `value={Minecraft.class}, priority=1100)` | Inject:1 | markTelemetryNotAllowed |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/spark_profile_world_join/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | startProfiling |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/spark_profile_world_join/WorldLoaderMixin.java` | `value={WorldLoader.class})` | Inject:1 | startProfiling |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/stalled_chunk_load_detection/ServerChunkCacheMixin.java` | `value={ServerChunkCache.class}, priority=1100)` | Inject:1 | bailIfServerDead |
| top-level / `org/embeddedt/modernfix/common/mixin/feature/suppress_narrator_stacktrace/GameNarratorMixin.java` | `value={GameNarrator.class})` | WrapOperation:1 | suppressStacktracePrinting |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/attribute_supplier_dedup/AttributeSupplierMixin.java` | `value={AttributeSupplier.class})` | Inject:1 | useCompactJavaMap |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/cache_blockstate_cache_arrays/AbstractBlockStateCacheMixin.java` | `value={BlockBehaviour.BlockStateBase.Cache.class})` | Redirect:2 | getVoxelShapeValues, getDirectionAxisValues |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/cache_profile_texture_url/SkinManagerMixin.java` | `targets={"net/minecraft/client/resources/SkinManager$TextureCache"})` | Redirect:1 | useCachedHash |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/cache_strongholds/ChunkGeneratorMixin.java` | `value={ChunkGeneratorStructureState.class})` | WrapMethod:1, Redirect:1 | mfix$setStrongholdCachePath, modernfix$cacheRingPositions, useDedicatedService, mfix$makeCacheKey, mfix$readFromCache, mfix$writeToCache, mfix$getOrLoadCache, mfix$loadCacheFile, mfix$saveCacheFile |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/cache_strongholds/ConcentricRingsStructurePlacementMixin.java` | `value={ConcentricRingsStructurePlacement.class})` | Inject:2 | mfix$computeRadiusBounds, mfix$computeMaxCircleIndex, mfix$earlyRejectByRadius |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/cache_strongholds/ServerLevelMixin.java` | `value={ServerLevel.class})` | WrapOperation:1 | setCachePath |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/chunk_meshing/RebuildTaskMixin.java` | `value={SectionCompiler.class}, priority=2000)` | Redirect:1 | fastBetweenClosed |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/compact_bit_storage/PalettedContainerMixin.java` | `value={PalettedContainer.class})` | Inject:1 | validateData |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/compact_entity_models/CubeDefinitionMixin.java` | `value={CubeDefinition.class})` | WrapOperation:1 | modernfix$deduplicateCube |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/compact_entity_models/package-info.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/compact_imposterprotochunks/ChunkAccessMixin.java` | `value={ChunkAccess.class})` |  |  |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/compact_imposterprotochunks/ImposterProtoChunkMixin.java` | `value={ImposterProtoChunk.class})` | Inject:1 | replaceDuplicateObjects |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/compact_mojang_registries/BlockStateDataMixin.java` | `value={BlockStateData.class}, priority=2000)` | Inject:1 | clearInterner |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/compact_mojang_registries/MappedRegistryMixin.java` | `value={MappedRegistry.class})` | Inject:1 | replaceStorage |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/compact_mojang_registries/VanillaRegistriesMixin.java` | `value={VanillaRegistries.class})` | WrapMethod:1 | modernfix$memoizeLookup |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/compress_unihex_font/GlyphProviderTypeMixin.java` | `value={GlyphProviderType.class})` | ModifyExpressionValue:1 | lazyUnihex |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/compress_unihex_font/UnihexProviderByteContentsMixin.java` | `targets={"net/minecraft/client/gui/font/providers/UnihexProvider$ByteContents"})` | Inject:1 | useCompactIfPossible |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/compress_unihex_font/UnihexProviderShortContentsMixin.java` | `targets={"net/minecraft/client/gui/font/providers/UnihexProvider$ShortContents"})` | Inject:1 | useCompactIfPossible |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/datapack_reload_exceptions/RecipeManagerMixin.java` | `value={RecipeManager.class}, priority=2000)` | Redirect:1 | silenceException |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dedicated_reload_executor/CreateWorldScreenMixin.java` | `value={CreateWorldScreen.class})` | ModifyArg:2 | getReloadExecutorService, getCreationExecutorService |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dedicated_reload_executor/MinecraftMixin.java` | `value={Minecraft.class})` | Redirect:1 | getResourceReloadExecutor |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dedicated_reload_executor/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | ModifyArg:1 | getReloadExecutor |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dedicated_reload_executor/WorldOpenFlowsMixin.java` | `value={WorldOpenFlows.class})` | ModifyArg:1 | getResourceReloadExecutor |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/deduplicate_climate_parameters/ParameterMixin.java` | `value={Climate.Parameter.class, Climate.ParameterPoint.class})` | Redirect:1 | internParameterStatic |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/deduplicate_location/MixinIdentifier.java` | `value={Identifier.class})` | Inject:1 | reinit |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/deduplicate_wall_shapes/WallBlockMixin.java` | `value={WallBlock.class})` | WrapOperation:4 | memoizeColumn, memoizeBoxZ, memoizeRotateHorizontal, memoizeOr |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dynamic_dfu/DataFixersMixin.java` | `value={DataFixers.class})` | ModifyExpressionValue:1 | setupMapBlasting |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dynamic_dfu/DataFixTypesMixin.java` | `value={DataFixTypes.class})` | Inject:1 | kickOnUpdate |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dynamic_entity_renderers/EntityRenderDispatcherMixin.java` | `value={EntityRenderDispatcher.class})` | Inject:2, Redirect:1 | checkNullnessFromEntity, checkNullnessFromState, setRendererField |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dynamic_entity_renderers/EntityRenderersMixin.java` | `value={EntityRenderers.class})` | Inject:1 | createDynamicRendererLoader |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dynamic_languages/ClientLanguageMixin.java` | `value={ClientLanguage.class}, priority=2000)` | WrapOperation:1, ModifyArg:1 | collectResources, modifyLanguageMap |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dynamic_languages/package-info.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dynamic_resources/BlockStateDefinitionsAccessor.java` | `value={BlockStateDefinitions.class})` | Accessor:1 | getStaticDefinitions |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dynamic_resources/IdMapperAccessor.java` | `value={IdMapper.class})` | Accessor:1 |  |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dynamic_resources/MixinBlockState.java` | `value={BlockBehaviour.BlockStateBase.class})` |  | mfix$getModel, mfix$setModel |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dynamic_resources/MixinBlockStateModelLoader.java` | `value={BlockStateModelLoader.class})` | ModifyArg:1 | lambda$loadBlockStates$2, skipAOTBlockStateLoad |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dynamic_resources/MixinClientItemInfoLoader.java` | `value={ClientItemInfoLoader.class})` | ModifyArg:1 | mfix$loadSingleClientItemInfo, skipAOTClientItemLoad |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dynamic_resources/MixinModelBakery.java` | `value={ModelBakery.class})` | Redirect:2, ModifyConstant:1 | dynamicallyBake, dynamicItemProperties, showFullException |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dynamic_resources/MixinModelManager.java` | `value={ModelManager.class}, priority=500)` | ModifyArg:1, Inject:1, Overwrite:2 | skipAOTUnbakedModelLoad, mfix$discoverModelDependencies, buildModelGroups, createBlockStateToModelDispatch |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dynamic_resources/MixinTextureSlots.java` | `value={TextureSlots.class})` | Inject:1 | mfix$handleEmptyTextureReference |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dynamic_resources/ModelDiscoveryAccessor.java` | `value={ModelDiscovery.class})` | Accessor:1 |  |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dynamic_sounds/SoundBufferLibraryMixin.java` | `value={SoundBufferLibrary.class})` |  | onSoundRemoval |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/dynamic_structure_manager/StructureManagerMixin.java` | `value={StructureTemplateManager.class})` | Inject:1 | makeStructuresSafe |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/encoder_cache_leak/ClientConfigurationPacketListenerImplMixin.java` | `value={ClientConfigurationPacketListenerImpl.class})` | Inject:1 | resetEncoderCache |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/encoder_cache_leak/DataComponentsAccessor.java` | `value={DataComponents.class})` | Accessor:1 | mfix$getCache |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/encoder_cache_leak/EncoderCacheAccessor.java` | `value={EncoderCache.class})` | Accessor:1 |  |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/encoder_cache_leak/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | clearEncoderCache |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/encoder_cache_leak/ReloadableServerResourcesMixin.java` | `value={ReloadableServerResources.class})` | ModifyReturnValue:1 | resetEncoderCache |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/faster_item_rendering/GameRendererMixin.java` | `value={GameRenderer.class})` | Inject:2 | markRenderingLevel, markNotRenderingLevel |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/faster_item_rendering/ItemStackRenderStateAccessor.java` | `value={ItemStackRenderState.class})` | Accessor:1 |  |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/faster_item_rendering/package-info.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/faster_texture_stitching/StitcherMixin.java` | `value={Stitcher.class})` | Inject:2 | stitchFast, gatherSpritesFast |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/lazy_search_tree_registry/SessionSearchTreesMixin.java` | `value={SessionSearchTrees.class})` | ModifyArg:1, WrapMethod:1 | mfix$deferProcessing, mfix$processDeferredBuild |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/memoize_creative_tab_build/CreativeModeTabMixin.java` | `value={CreativeModeTab.class})` | WrapMethod:1 | buildContentsIfChanged |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/model_optimizations/PropertyMixin.java` | `value={Property.class})` | ModifyVariable:1, Overwrite:1 | internName, equals |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/model_optimizations/TransformationMatrixMixin.java` | `value={Transformation.class})` | Overwrite:1 | hashCode |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/mojang_registry_size/ResourceKeyInvoker.java` | `value={ResourceKey.class})` | Invoker:1 | mfix$invokeCtor |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/mojang_registry_size/ResourceKeyMixin.java` | `value={ResourceKey.class})` | Inject:1 | createEfficient |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/mojang_registry_size/StateHolderMixin.java` | `value={StateHolder.class})` | Inject:1 | replaceEmptyTable |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/release_protochunks/ChunkHolderMixin.java` | `value={ChunkHolder.class})` | Inject:2 | mfix$resetProtoChunkFutures, recheckSuspensionAfterNeighbor, markForSuspensionOnDemotion, mfix$markAsNeedingProtoChunkDrop |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/release_protochunks/ChunkMapMixin.java` | `value={ChunkMap.class})` | Inject:1 | dropProtoChunks, mfix$markForSuspensionCheck, mfix$getMainThreadExecutor |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/release_protochunks/GenerationChunkHolderAccessor.java` | `value={GenerationChunkHolder.class})` | Accessor:2 |  |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/release_protochunks/ImposterProtoChunkMixin.java` | `value={ImposterProtoChunk.class})` | ModifyExpressionValue:1 | avoidLeakingLiveBE |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/remove_biome_temperature_cache/BiomeMixin.java` | `value={Biome.class})` | Overwrite:1 | getTemperature |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/resourcepacks/FilePackResourcesMixin.java` | `value={FilePackResources.class})` | Inject:3 | mf$getOrCreateIndex, mf$getNamespaces, mf$listResources, mf$invalidateIndex |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/resourcepacks/PathPackResourcesMixin.java` | `value={PathPackResources.class}, priority=1100)` | Inject:1 | cacheResources, generateResourceCache, invalidateCache |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/resourcepacks/SharedZipFileAccessAccessor.java` | `value={FilePackResources.SharedZipFileAccess.class})` | Invoker:1, Accessor:1 |  |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/state_definition_construct/StateDefinitionMixin.java` | `value={StateDefinition.class})` | ModifyVariable:1 | useArrayMap |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/tag_id_caching/TagEntryMixin.java` | `value={TagEntry.class})` | Overwrite:1 | elementOrTag |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/tag_id_caching/TagOrElementLocationMixin.java` | `value={ExtraCodecs.TagOrElementLocation.class})` | Overwrite:1 | decoratedId |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/thread_priorities/IntegratedServerMixin.java` | `value={IntegratedServer.class})` | Inject:1 | adjustServerPriority |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/thread_priorities/UtilMixin.java` | `value={Util.class})` | ModifyArg:1 | adjustPriorityOfThreadFactory |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/ticking_chunk_alloc/BatMixin.java` | `value={Bat.class}, priority=1200)` | Redirect:1 | useCachedLocalDate |
| top-level / `org/embeddedt/modernfix/common/mixin/perf/ticking_chunk_alloc/ChunkAccessMixin.java` | `value={ChunkAccess.class}, priority=800)` | Overwrite:1 | getAllReferences |
| top-level / `org/embeddedt/modernfix/common/mixin/safety/BlockColorsMixin.java` | `value={BlockColors.class}, priority=700)` | Inject:2 | lockMapBeforeAccess, unlockMap |
| top-level / `org/embeddedt/modernfix/common/mixin/safety/LivingEntityRendererMixin.java` | `value={LivingEntityRenderer.class})` | WrapMethod:1 | handleOffThreadLayerAdd |
| top-level / `org/embeddedt/modernfix/core/config/BuiltInOptions.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/core/config/ModernFixEarlyConfig.java` | `` |  | modPresent, sanitize, getPermanentlyDisabledMixins, getAnnotationValue, loadPackageMetadata, getOrLoadPackageMetadata, scanForAndBuildMixinOptions, checkBlockstateCacheRebuilds, checkModelDataManager, disableIfModPresent, addBuiltInOption, addBuiltInOptions, addMixinRule, readJVMProperties, readGlobalProperties, readProperties, getEffectiveOptionForMixin, load, finalizeLoad, save, getMixinRuleName, getOptionCount, getOptionOverrideCount, getOptionMap, getOptionCategoryMap, getOptionValue, putConditionally, put |
| top-level / `org/embeddedt/modernfix/core/config/Option.java` | `` |  | getType, getValue, setValue, addModOverride, getSerializedValue, setFromString, asType, asBoolean, setParent, getParent, getDepth, isEffectivelyDisabledByParent, isOverridden, isUserDefined, isModDefined, getName, getSelfName, getDefiningMods |
| top-level / `org/embeddedt/modernfix/core/config/OptionCategories.java` | `` |  | load, getCategoriesInOrder, getCategoryForOption |
| top-level / `org/embeddedt/modernfix/core/config/OptionType.java` | `` |  | parse, serialize, type, createEnumType, parse, serialize, type, enumType |
| top-level / `org/embeddedt/modernfix/core/ModernFixMixinPlugin.java` | `` |  | run, computeBetterThreadCount, onLoad, getRefMapperConfig, shouldApplyMixin, isOptionEnabled, getOptionValue, activeFeatureLevel, acceptTargets, getMixins, preApply, postApply, applyBlockStateCacheScan |
| top-level / `org/embeddedt/modernfix/dedup/ClimateCache.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/dedup/DeduplicationCache.java` | `` |  | hashCode, equals, deduplicate, clearCache, toString |
| top-level / `org/embeddedt/modernfix/dedup/IdentifierCaches.java` | `` |  | printDebug |
| top-level / `org/embeddedt/modernfix/dfu/DFUBlaster.java` | `` |  | buildTrackedMaps, tryAdd, blastMaps, kick, run |
| top-level / `org/embeddedt/modernfix/duck/IBlockState.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/duck/ICachedMaterialsModel.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/duck/IChunkGenerator.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/duck/IExtendedModelManager.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/duck/ILevelSave.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/duck/IModelHoldingBlockState.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/duck/IProfilingServerFunctionManager.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/duck/ISafeBlockGetter.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/duck/IServerLevel.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/duck/IStructureCheck.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/duck/ITimeTrackingServer.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/duck/release_protochunks/IClearableChunkHolder.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/duck/release_protochunks/ISuspendedHolderTrackingChunkMap.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/duck/reuse_datapacks/ICachingResourceClient.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/dynamiclanguages/DynamicLanguageMap.java` | `` |  | createStorage, forVanillaData, load |
| top-level / `org/embeddedt/modernfix/dynresources/BlockStateModelMap.java` | `` |  | size, isEmpty, containsKey, containsValue, get, getOrDefault, put, remove, putAll, clear, keySet, values, entrySet, resetCache |
| top-level / `org/embeddedt/modernfix/dynresources/DisjointSetUnion.java` | `` |  | assertDisjoint, iterator, size, remove, contains, hashCode |
| top-level / `org/embeddedt/modernfix/dynresources/DynamicModelSystem.java` | `` |  | createCachedResourceBackedMap, load, createDynamicUnbakedModelMap, getAllBlockStates, iterator, contains, size, createDynamicBlockStateLoadedModels, createDynamicClientInfos, createDynamicBakedRegistry, load, size, object2IntEntrySet, getInt, DynamicResolver, resolveModel, resolvedModels, load |
| top-level / `org/embeddedt/modernfix/dynresources/DynamicRegistryMap.java` | `` |  | size, isEmpty, containsKey, containsValue, get, getOrDefault, put, remove, putAll, clear, keySet, values, entrySet, iterator, hasNext, next, size, getKey, getValue, setValue |
| top-level / `org/embeddedt/modernfix/dynresources/DynamicSoundHelpers.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/entity/EntityRendererMap.java` | `` |  | size, isEmpty, containsKey, containsValue, get, put, remove, putAll, clear, keySet, values, entrySet, load |
| top-level / `org/embeddedt/modernfix/entity/ErroredEntityRenderer.java` | `` |  | shouldRender, createRenderState, submit |
| top-level / `org/embeddedt/modernfix/fabric/api/dynresources/ModelScanController.java` | `` |  | shouldScanAndTestWrapping |
| top-level / `org/embeddedt/modernfix/fabric/datagen/RuntimeDatagen.java` | `` |  | runRuntimeDatagen, init |
| top-level / `org/embeddedt/modernfix/fabric/mixin/core/ClientCommonPacketListenerImplMixin.java` | `value={ClientConfigurationPacketListenerImpl.class})` | Inject:1 | signalTags |
| top-level / `org/embeddedt/modernfix/fabric/mixin/core/ClientMinecraftServerMixin.java` | `value={MinecraftServer.class})` | Inject:1 | markServerStarted |
| top-level / `org/embeddedt/modernfix/fabric/mixin/core/MCMixin_Fabric.java` | `value={Minecraft.class})` | Inject:1 | onRenderTickEnd |
| top-level / `org/embeddedt/modernfix/fabric/mixin/core/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Inject:3 | changeServerReference, hookServerStarted, hookServerShutdown |
| top-level / `org/embeddedt/modernfix/fabric/mixin/feature/measure_time/MinecraftMixin_Fabric.java` | `value={Minecraft.class})` | Inject:1 | recordWorldLoadStart |
| top-level / `org/embeddedt/modernfix/fabric/mixin/perf/faster_command_suggestions/SuggestionsBuilderMixin.java` | `value={SuggestionsBuilder.class})` | Redirect:1 | addIfFits |
| top-level / `org/embeddedt/modernfix/fabric/modmenu/ModernFixModMenuApiImpl.java` | `` |  | getModConfigScreenFactory |
| top-level / `org/embeddedt/modernfix/FileWalker.java` | `` |  | load |
| top-level / `org/embeddedt/modernfix/ModernFix.java` | `` |  | resourceReloadExecutor, runAuditIfRequested, onServerStarted, onServerDead |
| top-level / `org/embeddedt/modernfix/ModernFixClient.java` | `` |  | resetWorldLoadStateMachine, onGameLaunchFinish, onRecipesUpdated, onTagsUpdated, onRenderTickEnd, onServerStarted |
| top-level / `org/embeddedt/modernfix/ModernFixClientFabric.java` | `` |  | onInitializeClient |
| top-level / `org/embeddedt/modernfix/ModernFixFabric.java` | `` |  | onInitialize |
| top-level / `org/embeddedt/modernfix/ModernFixPreLaunchFabric.java` | `` |  | onPreLaunch |
| top-level / `org/embeddedt/modernfix/platform/fabric/ModernFixPlatformHooksImpl.java` | `` |  | isClient, isDedicatedServer, getVersionString, modPresent, isDevEnv, getCurrentServer, isEarlyLoadingNormally, isLoadingNormally, getGameDirectory, sendPacket, injectPlatformSpecificHacks, applyASMTransformers, onServerCommandRegister, getCustomModOptions, onLaunchComplete, getPlatformName |
| top-level / `org/embeddedt/modernfix/platform/ModernFixPlatformHooks.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/platform/PlatformHookLoader.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/registry/LifecycleMap.java` | `` |  | put |
| top-level / `org/embeddedt/modernfix/render/FastItemRenderType.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/render/font/CompactUnihexContents.java` | `` |  | extract8Bytes, extractByte, extract4Shorts, extractShort, verifyRoundTrip, line, bitWidth, line, bitWidth |
| top-level / `org/embeddedt/modernfix/render/font/LazyGlyphProvider.java` | `` |  | close, getGlyphProvider, getGlyph, getSupportedGlyphs, wrap, type, unpack, delegate |
| top-level / `org/embeddedt/modernfix/render/RenderState.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/resources/CachedResourcePath.java` | `` |  | CachedResourcePath, CachedResourcePath, hashCode, equals, getFileName, getNameCount, getNameAt, getFullPath |
| top-level / `org/embeddedt/modernfix/resources/ICachingResourcePack.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/resources/NewResourcePackAdapter.java` | `` |  | sendToOutput |
| top-level / `org/embeddedt/modernfix/resources/PackResourcesCacheEngine.java` | `` |  | isValidCachedResourcePath, getNamespaces, doGenerateCache, awaitLoad, hasResource, collectResources, decompose, decomposeCached |
| top-level / `org/embeddedt/modernfix/resources/ReloadExecutor.java` | `` |  | createCustomResourceReloadExecutor, onTermination, handleException |
| top-level / `org/embeddedt/modernfix/resources/ZipPackIndex.java` | `` |  | obtainChannel, readCentralDirectory, buildTree, indexCdEntry, getTrackedTopLevelDirs, getNamespaces, hasResource, listResources, collectResources |
| top-level / `org/embeddedt/modernfix/screen/ModernFixConfigScreen.java` | `` |  | init, onClose, extractRenderState, setLastScrollAmount |
| top-level / `org/embeddedt/modernfix/screen/ModernFixDebugScreen.java` | `` |  | display, isAllowed |
| top-level / `org/embeddedt/modernfix/screen/ModernFixOptionInfoScreen.java` | `` |  | init, onClose, drawMultilineString, extractRenderState |
| top-level / `org/embeddedt/modernfix/screen/OptionList.java` | `` |  | getOptionComponent, updateOptionEntryStatuses, addOption, getRowWidth, extractContent, getOptionMessage, children, mouseClicked, mouseReleased, narratables, extractContent, changeFocus, children, narratables |
| top-level / `org/embeddedt/modernfix/spark/SparkLaunchProfiler.java` | `` |  | checkSparkProfilingAllowed, start, stop, output, getType, getName, getBrand, getVersion, getMinecraftVersion, getName, getUniqueId, hasPermission, sendMessage, getVersion, getPluginDirectory, getCommandName, getCommandSenders, executeAsync, log, log, getPlatformInfo |
| top-level / `org/embeddedt/modernfix/textures/StbStitcher.java` | `` |  | setWrapper, getX, getY, packRects |
| top-level / `org/embeddedt/modernfix/tickables/LoadableTickableObject.java` | `` |  | get, tick |
| top-level / `org/embeddedt/modernfix/tickables/TickableObject.java` | `` |  |  |
| top-level / `org/embeddedt/modernfix/tickables/TickableObjectManager.java` | `` |  | register, runTick |
| top-level / `org/embeddedt/modernfix/util/blockpos/SectionBlockPosIterator.java` | `` |  | hasNext, next |
| top-level / `org/embeddedt/modernfix/util/CacheUtil.java` | `` |  | simpleCacheForLambda, load |
| top-level / `org/embeddedt/modernfix/util/CanonizingStringMap.java` | `` |  | intern, put, putAll, putAllWithoutInterning, deepCopy |
| top-level / `org/embeddedt/modernfix/util/ClassInfoManager.java` | `` |  | clear, accessible, changeLoggerAndRestoreLater, disableLoggers, doClear |
| top-level / `org/embeddedt/modernfix/util/CommonModUtil.java` | `` |  | runWithoutCrash |
| top-level / `org/embeddedt/modernfix/util/ConcurrencySanitizingMap.java` | `` |  | checkThread, size, isEmpty, containsKey, containsValue, get, put, remove, putAll, clear, keySet, values, entrySet |
| top-level / `org/embeddedt/modernfix/util/DirectExecutorService.java` | `` |  | shutdown, shutdownNow, isShutdown, isTerminated, awaitTermination, execute |
| top-level / `org/embeddedt/modernfix/util/DummyList.java` | `` |  | size, isEmpty, contains, iterator, toArray, toArray, add, remove, containsAll, addAll, addAll, removeAll, retainAll, clear, get, set, add, remove, indexOf, lastIndexOf, listIterator, listIterator, subList |
| top-level / `org/embeddedt/modernfix/util/DummyServerConfiguration.java` | `` |  | getDataConfiguration, setDataConfiguration, getRemovedFeatureFlags, wasModded, getKnownServerBrands, setModdedInfo, overworldData, getLevelSettings, createTag, isHardcore, getVersion, getLevelName, getGameType, setGameType, isAllowCommands, setAllowCommands, getDifficulty, setDifficulty, isDifficultyLocked, setDifficultyLocked, getSinglePlayerUUID, isFlatWorld, isDebugWorld, worldGenSettingsLifecycle |
| top-level / `org/embeddedt/modernfix/util/DynamicInt2ObjectMap.java` | `` |  | keySet, values, entrySet, defaultReturnValue, defaultReturnValue, int2ObjectEntrySet, getOrDefault, get, containsKey |
| top-level / `org/embeddedt/modernfix/util/DynamicMap.java` | `` |  | size, isEmpty, containsKey, containsValue, get, put, remove, putAll, clear, keySet, values, entrySet |
| top-level / `org/embeddedt/modernfix/util/DynamicOverridableMap.java` | `` |  | put, get, putAll |
| top-level / `org/embeddedt/modernfix/util/EitherUtil.java` | `` |  | leftOrNull, rightOrNull |
| top-level / `org/embeddedt/modernfix/util/FileUtil.java` | `` |  | childFile, normalize |
| top-level / `org/embeddedt/modernfix/util/ForwardingInclDefaultsMap.java` | `` |  | getOrDefault, forEach, replaceAll, putIfAbsent, remove, replace, replace, computeIfAbsent, computeIfPresent, compute, merge |
| top-level / `org/embeddedt/modernfix/util/LambdaMap.java` | `` |  | size, isEmpty, containsKey, containsValue, get, put, remove, putAll, clear, keySet, values, entrySet |
| top-level / `org/embeddedt/modernfix/util/LayeredForwardingMap.java` | `` |  | size, isEmpty, containsKey, containsValue, get, put, remove, putAll, clear, keySet, values, entrySet |
| top-level / `org/embeddedt/modernfix/util/LRUMap.java` | `` |  | put, get, setPermanentEntries, dropEntriesToMeetSize |
| top-level / `org/embeddedt/modernfix/util/NamedPreparableResourceListener.java` | `` |  | reload, prepareSharedState, getName |
| top-level / `org/embeddedt/modernfix/util/PackTypeHelper.java` | `` |  | isVanillaPackType |
| top-level / `org/embeddedt/modernfix/util/SingleThreadedWorkerService.java` | `` |  | shutdown, shutdownNow, isShutdown, isTerminated, awaitTermination, isForcedAsyncCommand, execute |
| top-level / `org/embeddedt/modernfix/util/TimeFormatter.java` | `` |  | formatNanos, chooseUnit, abbreviate |
| top-level / `org/embeddedt/modernfix/world/IntegratedWatchdog.java` | `` |  | getLastTickStart, run |
| top-level / `org/embeddedt/modernfix/world/StrongholdLocationCache.java` | `` |  | getChunkPosList, setChunkPosList |
| top-level / `org/embeddedt/modernfix/world/ThreadDumper.java` | `` |  | obtainThreadDump |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
