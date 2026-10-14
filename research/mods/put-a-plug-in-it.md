# Put A Plug In it! (PAPI)

Review status: **Evidence inventory; behavioral review pending**

Project: [Put A Plug In it! (PAPI)](https://modrinth.com/mod/put-a-plug-in-it)
Selected artifact version: `fabric-26.3-1.3.0`
Published implementation source: https://github.com/dipilo/Put-A-Plug-In-it-
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A small mod that fixes Memory Leak issues, optimizes Memory Usage, and increases version/loader support for features of other Memory Leak Fix/Memory Optimization mods

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `optional`.

Artifact identity:
- `sha1`: `171ad9c9de3c1a342f6d2e88e52a56e9472a2eb9`
- `sha512`: `8ea5e44389d260c6ca689953c344107d1a349af78ba113d2e59ffd6cf2dcc7113634057bd8f42c6311ce677cc838908d37f2c7633ec72ba0c00a9ddccedf6f61`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 47
Reconstructed Java files: 35

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.dipilodopilasaurus.putapluginit.PutAPlugInItFabric"
  ],
  "client": [
    "com.dipilodopilasaurus.putapluginit.PutAPlugInItFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.15",
  "minecraft": ">=26.3 <26.4"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/dipilodopilasaurus/putapluginit/command/PapiLeakCommands.java` | `` |  | register, text, sendSuccess |
| top-level / `com/dipilodopilasaurus/putapluginit/config/ConfigSpecSink.java` | `` |  |  |
| top-level / `com/dipilodopilasaurus/putapluginit/config/ConfigView.java` | `` |  |  |
| top-level / `com/dipilodopilasaurus/putapluginit/config/TomlFileConfig.java` | `` |  | init, getBool, getInt, writeDefaults, bool, integer, appendEntry, read |
| top-level / `com/dipilodopilasaurus/putapluginit/Config.java` | `` |  | defineAll, loadAll, isFixSophisticatedCoreItemStackKeyCacheEnabled, getScItemStackKeyCacheClientClearEveryTicks, getScItemStackKeyCacheClientMinSizeBeforeClear, isScItemStackKeyCacheClearOnServerTickEnd, isLeakCommandsEnabled, isHeapDumpCommandEnabled, isClearModelManagerBlockStateToIdMapOnClientWorldLeaveEnabled, isClearModelManagerBakedModelMapsOnClientWorldLeaveEnabled, getClearModelManagerBakedModelMapsMinSize, isCompatibilityLayerEnabled, isCompatibilityLogDetectedModsEnabled, isImmediatelyFastCompatAutoPatchConfigEnabled, isImmediatelyFastCompatDisableScreenBatchingEnabled, isImmediatelyFastCompatDisableScreenBatchingOnIntelUhdEnabled, isImmediatelyFastCompatDisableAvoidRedundantFramebufferSwitchingOnIntelGpuEnabled, isImmediatelyFastCompatDisableHudBatchingEnabled, isMemoryLeakFixCompatDisableImmediatelyFastScreenBatchingEnabled, isEmiClearHistoryOnRespawnEnabled, isJadeClearCachesOnWorldChangeEnabled, isIcebergClearCachesOnWorldUnloadEnabled, isJeiClearCachesOnWorldChangeEnabled, isSophCoreClearStorageWrappersOnWorldUnloadEnabled, isSophCoreResetCraftingUiOnWorldChangeEnabled, isExpireLastDamageSourceEnabled, isSupplementariesClearCachesOnServerStopEnabled, isEtfClearPlayerTextureMapOnRespawnEnabled, isEtfClearRendererStateOnRenderEndEnabled, isEmfClearRenderContextOnRenderEndEnabled |
| top-level / `com/dipilodopilasaurus/putapluginit/EntityMemoriesLeakFix.java` | `` |  | onEntityRemoved, isEnabled, isModLoaded, isForgeLikeModLoaded, isFabricModLoaded, clearBrainMemories, findMemoriesField |
| top-level / `com/dipilodopilasaurus/putapluginit/ImmediatelyFastCompat.java` | `` |  | onClientTickEnd, shouldDisableScreenBatching, readJson, writeJson, setBoolean, isIntelGpu, isModLoaded, isForgeLikeLoaded, isFabricLoaded |
| top-level / `com/dipilodopilasaurus/putapluginit/leaks/ClientWorldLeaveCleanup.java` | `` |  | onClientTickEnd, isAnyWorldLeaveCleanupEnabled, runWorldLeaveCleanup, cleanupBlockStateToIdMap, cleanupBakedModelMaps |
| top-level / `com/dipilodopilasaurus/putapluginit/leaks/HeapDumper.java` | `` |  | tryDumpHeap, DumpResult |
| top-level / `com/dipilodopilasaurus/putapluginit/leaks/LeakReporter.java` | `` |  | buildReport, appendHeapHeader, appendGcSection, appendWatchedSizes, appendClientModelSection, appendBakedModelMapRow, appendDeltaSection, logAndWriteReport, bytesToMiB, Snapshot, WriteResult, success, failure |
| top-level / `com/dipilodopilasaurus/putapluginit/leaks/MinecraftClientMitigations.java` | `` |  | getMinecraftInstance, getFirstFieldByTypeName, allowReflectiveAccess, findBlockStateToIntMap, readFieldValue, isBlockStateKeyedObject2IntMap, hasBakedModelValues, isInstanceOf, safeMsg |
| top-level / `com/dipilodopilasaurus/putapluginit/leaks/MinecraftClientWatch.java` | `` |  | getMinecraftInstance, getFirstFieldByTypeName, allowReflectiveAccess, findBlockStateToIntMapSize, findLikelyBakedModelMaps, summarizeMapIfBakedModelValues, readFieldValue, isBlockStateKeyedObject2IntMap, getMapSize, sampleMapValues, isInstanceOf, isLikelyBakedModelMap, countMultiParts, implementsInterfaceByName, safeMsg |
| top-level / `com/dipilodopilasaurus/putapluginit/McVersion.java` | `` |  | get, isBetween, is, resolve, fromFabricLoader, fromStaticStringGetter, fromSharedConstants, invokeStatic, invokeStringGetter, compare, numericPrefix, trimToEmpty |
| top-level / `com/dipilodopilasaurus/putapluginit/mixin/alltheleaks/EntityTickListPassiveMixin.java` | `value={EntityTickList.class})` | Inject:1 | papi$clearPassiveAfterTick |
| top-level / `com/dipilodopilasaurus/putapluginit/mixin/alltheleaks/LivingEntityDamageSourceMixin.java` | `value={LivingEntity.class})` | Inject:1 | papi$expireLastDamageSource |
| top-level / `com/dipilodopilasaurus/putapluginit/mixin/alltheleaks/LivingEntityRenderPostMixin.java` | `value={LivingEntityRenderer.class})` | Inject:1 | papi$clearRendererState |
| top-level / `com/dipilodopilasaurus/putapluginit/mixin/memoryleakfix/BiomeThreadLocalMixin.java` | `value={Biome.class})` | Redirect:1 | papiUseSharedThreadLocal |
| top-level / `com/dipilodopilasaurus/putapluginit/mixin/memoryleakfix/MinecraftScreenshotMixin.java` | `value={Minecraft.class})` |  |  |
| top-level / `com/dipilodopilasaurus/putapluginit/mixin/memoryleakfix/TextureUtilFreeBufferMixin.java` | `targets={"com/mojang/blaze3d/platform/TextureUtil", "net/minecraft/client/renderer/texture/TextureUtil"}, remap=false)` | Redirect:2 | papiReadResourceWithoutLeak, papiReadFileChannelWithoutLeak |
| top-level / `com/dipilodopilasaurus/putapluginit/mixin/PapiMixinConfigPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, resolveMinecraftVersion, below, compareVersions, sanitize, parseInt, resolveMemoryLeakFixPresence, isModLoaded, isForgeLikeModLoaded, isFabricModLoaded, acceptTargets, getMixins, preApply, postApply |
| top-level / `com/dipilodopilasaurus/putapluginit/modfix/EmfRenderContextFix.java` | `` |  | initIfNeeded |
| top-level / `com/dipilodopilasaurus/putapluginit/modfix/EmiHistoryFix.java` | `` |  | initIfNeeded |
| top-level / `com/dipilodopilasaurus/putapluginit/modfix/EtfTextureFix.java` | `` |  | retargetRetainedPlayer, initIfNeeded, initRendererFieldsIfNeeded |
| top-level / `com/dipilodopilasaurus/putapluginit/modfix/IcebergCacheFix.java` | `` |  | clearMaps, clearEntities, initIfNeeded, collect |
| top-level / `com/dipilodopilasaurus/putapluginit/modfix/JadeCacheFix.java` | `` |  | clearObjectDataCenter, invalidateHideModNameCache, initIfNeeded, findSingleArgMethod |
| top-level / `com/dipilodopilasaurus/putapluginit/modfix/JeiCacheFix.java` | `` |  | enabled, clearUnsupportedContainers, clearGrindstoneMenu, clearIngredientCodecs, initIfNeeded, findRuntimeAccessor |
| top-level / `com/dipilodopilasaurus/putapluginit/modfix/ModFixes.java` | `` |  | onClientTickEnd, onServerStopped, onLivingEntityRenderPost, dispatchClientRespawn, dispatchClientLevelUnload |
| top-level / `com/dipilodopilasaurus/putapluginit/modfix/ModFixReflection.java` | `` |  | isForgeLikeLoaded, isFabricLoaded |
| top-level / `com/dipilodopilasaurus/putapluginit/modfix/SophisticatedCoreCraftingUiFix.java` | `` |  |  |
| top-level / `com/dipilodopilasaurus/putapluginit/modfix/SophisticatedCoreWrapperFix.java` | `` |  |  |
| top-level / `com/dipilodopilasaurus/putapluginit/modfix/SupplementariesCacheFix.java` | `` |  |  |
| top-level / `com/dipilodopilasaurus/putapluginit/PutAPlugInItFabric.java` | `` |  | onInitialize, onInitializeClient |
| top-level / `com/dipilodopilasaurus/putapluginit/SophisticatedCoreLeakFix.java` | `` |  | allowReflectiveAccess, onClientTickEnd, onServerTickEnd, tryGetItemStackKeyCacheSize, clearIfLargeEnough, initIfNeeded, detectSophisticatedCoreVersion, detectForgeLikeVersion, detectFabricVersion, shouldApplyItemStackKeyFix, parseVersion, getMcSpecificFixedVersion, compareDotVersion, parsePart, mcVersion, scVersion |
| top-level / `com/dipilodopilasaurus/putapluginit/TagKeyLeakFix.java` | `` |  | applyIfNeeded, findStaticInternerField, removeFinalModifier |
| top-level / `com/dipilodopilasaurus/putapluginit/TargetEntityLeakFix.java` | `` |  | onClientTickEnd, isPickRefreshing, findField, clearField |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
