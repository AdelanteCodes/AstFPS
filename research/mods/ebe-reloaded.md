# Enhanced Block Entities Reloaded

Review status: **Evidence inventory; behavioral review pending**

Project: [Enhanced Block Entities Reloaded](https://modrinth.com/mod/ebe-reloaded)
Selected artifact version: `fabric-0.13.1+26.3`
Published implementation source: https://github.com/Mat0u5/EnhancedBlockEntitiesReloaded
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

[UNOFFICIAL PORT] Reduce block entity FPS lag with almost no compromises, and improve their visuals

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `8f55da0f2db4da8dcd3d0a55d49bf423f7638199`
- `sha512`: `6469e1114ac65a56176e7719ff209d89180dd218a98436bf4307f23ecc80cd41767c2289e32fd4104ffe60f8625b183f2c7e84ca1fc661fd0abc57a7b7d9278c`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 89
Reconstructed Java files: 66

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "foundationgames.enhancedblockentities.EnhancedBlockEntities"
  ],
  "modmenu": [
    "foundationgames.enhancedblockentities.config.gui.EBEModMenuPlugin"
  ]
}
```

**depends**

```json
{
  "fabric-api": "*",
  "fabricloader": ">=0.12.0",
  "java": ">=25",
  "minecraft": ">=26.3"
}
```

**breaks**

```json
{}
```

**accessWidener**

```json
"aw/26.3.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `foundationgames/enhancedblockentities/client/model/DynamicBakedModel.java` | `` |  | emitQuads, collectParts, particleMaterial, materialFlags, getModels, getSelector, getEffects, getQuads, useAmbientOcclusion, particleMaterial, materialFlags |
| top-level / `foundationgames/enhancedblockentities/client/model/DynamicModelEffects.java` | `` |  | ambientOcclusion, ambientOcclusion, ambientOcclusion, ambientOcclusion, ambientOcclusion, fromId |
| top-level / `foundationgames/enhancedblockentities/client/model/DynamicModelProvidingPlugin.java` | `` |  | register, get |
| top-level / `foundationgames/enhancedblockentities/client/model/DynamicUnbakedModel.java` | `` |  | resolveDependencies, bake, codec, resolveDependencies, bake |
| top-level / `foundationgames/enhancedblockentities/client/model/item/EBEIsChristmasProperty.java` | `` |  | get, type |
| top-level / `foundationgames/enhancedblockentities/client/model/misc/DecoratedPotModelSelector.java` | `` |  | createModelIDs, writeModelIndices, patternIndex |
| top-level / `foundationgames/enhancedblockentities/client/model/ModelIdentifiers.java` | `` |  | init, refreshPotteryPatterns, of, getBakedModel, initialize |
| top-level / `foundationgames/enhancedblockentities/client/model/ModelSelector.java` | `` |  | getParticleModelIndex, fromId, writeModelIndices, getParticleModelIndex, writeModelIndices |
| top-level / `foundationgames/enhancedblockentities/client/render/BlockEntityRenderCondition.java` | `` |  |  |
| top-level / `foundationgames/enhancedblockentities/client/render/BlockEntityRendererOverride.java` | `` |  | render, onModelsReload |
| top-level / `foundationgames/enhancedblockentities/client/render/entity/BellBlockEntityRendererOverride.java` | `` |  | render, getBellModel, onModelsReload |
| top-level / `foundationgames/enhancedblockentities/client/render/entity/ChestBlockEntityRendererOverride.java` | `` |  | render, resolveModels, getLidAnimationHolder, onModelsReload |
| top-level / `foundationgames/enhancedblockentities/client/render/entity/DecoratedPotBlockEntityRendererOverride.java` | `` |  | tryGetModels, render, onModelsReload |
| top-level / `foundationgames/enhancedblockentities/client/render/entity/ShulkerBoxBlockEntityRendererOverride.java` | `` |  | render, onModelsReload |
| top-level / `foundationgames/enhancedblockentities/client/render/entity/SignBlockEntityRendererOverride.java` | `` |  | render |
| top-level / `foundationgames/enhancedblockentities/client/render/gui/SignGuiElementRenderer.java` | `` |  | getRenderStateClass, getTextureLabel, renderToTexture |
| top-level / `foundationgames/enhancedblockentities/client/render/SignRenderManager.java` | `` |  | getRenderedSignAmount, endFrame |
| top-level / `foundationgames/enhancedblockentities/client/resource/AtlasResourceBuilder.java` | `` |  | put, toBytes |
| top-level / `foundationgames/enhancedblockentities/client/resource/EBEPack.java` | `` |  | addAtlasSprite, addSingleBlockSprite, addDirBlockSprites, addResource, addResource, addPlainTextResource, addTemplateResource, addTemplateResource, getRootResource, getResource, listResources, getNamespaces, getMetadataSection, location, close, dump, get, def, build |
| top-level / `foundationgames/enhancedblockentities/client/resource/template/TemplateDefinitions.java` | `` |  | push, pop, def, def, iterator |
| top-level / `foundationgames/enhancedblockentities/client/resource/template/TemplateLoader.java` | `` |  | getOrLoadRaw |
| top-level / `foundationgames/enhancedblockentities/client/resource/template/TemplateProvider.java` | `` |  | load |
| top-level / `foundationgames/enhancedblockentities/config/EBEConfig.java` | `` |  | writeTo, readFrom, save, load, applyCompatConfigModifiers, Override |
| top-level / `foundationgames/enhancedblockentities/config/gui/EBEModMenuPlugin.java` | `` |  | getModConfigScreenFactory |
| top-level / `foundationgames/enhancedblockentities/config/gui/option/ConfigButtonOption.java` | `` |  | getOption, createButton, validateValue, codec |
| top-level / `foundationgames/enhancedblockentities/config/gui/option/EBEOption.java` | `` |  | getValue, getOptionKey, getValueKey, getText, getTooltip, next, isDefault, ConfigView |
| top-level / `foundationgames/enhancedblockentities/config/gui/option/TextPalette.java` | `` |  | rainbow |
| top-level / `foundationgames/enhancedblockentities/config/gui/screen/EBEConfigScreen.java` | `` |  | init, extractMenuBackground, extractRenderState, onClose, applyChanges, addOptions, option |
| top-level / `foundationgames/enhancedblockentities/config/gui/widget/SectionTextWidget.java` | `` |  | visitLines, extractWidgetRenderState |
| top-level / `foundationgames/enhancedblockentities/config/gui/widget/WidgetRowListWidget.java` | `` |  | add, getRowWidth, scrollBarX, extractListBackground, children, narratables, extractContent |
| top-level / `foundationgames/enhancedblockentities/EBESetup.java` | `` |  | values, valueOf, setupRRPChests, setupRRPSigns, setupRRPBells, setupRRPBeds, setupRRPShulkerBoxes, setupRRPDecoratedPots, setupResourceProviders, putCutoutMipped, putCutout, setupChests, copperChestBlocks, setupSigns, setupBells, setupBeds, shulkerBoxByColor, setupShulkerBoxes, setupDecoratedPots |
| top-level / `foundationgames/enhancedblockentities/EnhancedBlockEntities.java` | `` |  | onInitializeClient, initClient, registerLoaderEvents, reload, load |
| top-level / `foundationgames/enhancedblockentities/EnhancedBlockEntityRegistry.java` | `` |  | register, clear, Entry |
| top-level / `foundationgames/enhancedblockentities/event/EBEEvents.java` | `` |  | values, valueOf, register, invoker |
| top-level / `foundationgames/enhancedblockentities/Main.java` | `` |  | onInitialize |
| top-level / `foundationgames/enhancedblockentities/mixin/AbstractBlockStateMixin.java` | `value={BlockBehaviour.BlockStateBase.class})` | Inject:1 | enhanced_bes$overrideRenderType |
| top-level / `foundationgames/enhancedblockentities/mixin/AbstractSignBlockEntityRenderAccessor.java` | `value={AbstractSignRenderer.class})` | Invoker:1, Accessor:1 | enhanced_bes$getRenderDistance |
| top-level / `foundationgames/enhancedblockentities/mixin/BellBlockEntityMixin.java` | `value={BellBlockEntity.class})` | ModifyVariable:1 | enhanced_bes$listenForStopRinging, getModelState, setModelState, getRenderState, setRenderState |
| top-level / `foundationgames/enhancedblockentities/mixin/BlockEntityRenderDispatcherMixin.java` | `value={BlockEntityRenderDispatcher.class})` | Inject:2 | enhanced_bes$isOverridden, enhanced_bes$skipOverriddenExtraction, enhanced_bes$renderOverrides |
| top-level / `foundationgames/enhancedblockentities/mixin/BuiltChunkMixin.java` | `value={SectionRenderDispatcher.RenderSection.class})` | Inject:2 | enhanced_bes$addPostRebuildTask, enhanced_bes$claimPendingTasks, enhanced_bes$runPostRebuildTask, enhanced_bes$getTaskAfterRebuild, enhanced_bes$setTaskAfterRebuild |
| top-level / `foundationgames/enhancedblockentities/mixin/ChestBlockEntityMixin.java` | `value={ChestBlockEntity.class})` | Inject:1 | enhanced_bes$listenForOpenClose, getModelState, setModelState, getRenderState, setRenderState |
| top-level / `foundationgames/enhancedblockentities/mixin/compat/sodium/RenderSectionManagerMixin.java` | `value={RenderSectionManager.class}, remap=false)` | Inject:1 | enhanced_bes$compat_sodium$cacheUpdatingChunk, enhanced_bes$compat_sodium$cacheUpdatingChunk0 |
| top-level / `foundationgames/enhancedblockentities/mixin/compat/sodium/RenderSectionMixin.java` | `value={RenderSection.class}, remap=false)` | Inject:1 | enhanced_bes$compat_sodium$runPostRebuildTask, enhanced_bes$getTaskAfterRebuild, enhanced_bes$setTaskAfterRebuild |
| top-level / `foundationgames/enhancedblockentities/mixin/DecoratedPotBlockEntityMixin.java` | `value={DecoratedPotBlockEntity.class})` | Inject:2 | enhanced_bes$updateChunkOnPatternsLoaded, enhanced_bes$updateOnWobble, getModelState, setModelState, getRenderState, setRenderState |
| top-level / `foundationgames/enhancedblockentities/mixin/EnderChestBlockEntityMixin.java` | `value={EnderChestBlockEntity.class})` | Inject:1 | enhanced_bes$listenForOpenClose, getModelState, setModelState, getRenderState, setRenderState |
| top-level / `foundationgames/enhancedblockentities/mixin/LifecycledResourceManagerImplMixin.java` | `value={MultiPackResourceManager.class})` | ModifyVariable:1, Inject:1 | enhanced_bes$injectBasePack, enhanced_bes$injectTopLevelPack, addPack |
| top-level / `foundationgames/enhancedblockentities/mixin/MinecraftClientMixin.java` | `value={Minecraft.class})` | Inject:1 | enhanced_bes$fireReloadEvent |
| top-level / `foundationgames/enhancedblockentities/mixin/ShulkerBoxBlockEntityMixin.java` | `value={ShulkerBoxBlockEntity.class})` | Inject:1 | enhanced_bes$updateModelState, getModelState, setModelState, getRenderState, setRenderState |
| top-level / `foundationgames/enhancedblockentities/mixin/SignEditScreenMixin.java` | `value={SignEditScreen.class})` | Inject:1 | enhanced_bes$renderBakedModelSign |
| top-level / `foundationgames/enhancedblockentities/mixin/VideoOptionsScreenMixin.java` | `value={VideoSettingsScreen.class})` | Inject:1 | enhanced_bes$addEBEOptionButton |
| top-level / `foundationgames/enhancedblockentities/mixin/WorldRendererMixin.java` | `value={LevelRenderer.class})` | Inject:1 | enhanced_bes$endSignFrame |
| top-level / `foundationgames/enhancedblockentities/platform/fabric/FabricEntrypoint.java` | `` |  | onInitialize |
| top-level / `foundationgames/enhancedblockentities/platform/Platform.java` | `` |  | values, valueOf, getGameDir, getConfigDir, getModRootPaths, isModLoaded, forEachApiEntrypoint |
| top-level / `foundationgames/enhancedblockentities/ReloadType.java` | `` |  | or |
| top-level / `foundationgames/enhancedblockentities/util/ConvUtil.java` | `` |  | values, valueOf, bool, defaultedBool |
| top-level / `foundationgames/enhancedblockentities/util/DateUtil.java` | `` |  | values, valueOf, isChristmas |
| top-level / `foundationgames/enhancedblockentities/util/duck/AppearanceStateHolder.java` | `` |  |  |
| top-level / `foundationgames/enhancedblockentities/util/duck/ChunkRebuildTaskAccess.java` | `` |  |  |
| top-level / `foundationgames/enhancedblockentities/util/EBEUtil.java` | `` |  | values, valueOf, faceFromIndex, potPatternFromSherd, potPatternKeys, potPatternAssetId, angle, rotate, renderBakedModel, isVanillaResourcePack, id, dumpResources |
| top-level / `foundationgames/enhancedblockentities/util/ExecutableRunnableHashSet.java` | `` |  | run |
| top-level / `foundationgames/enhancedblockentities/util/GuiUtil.java` | `` |  | values, valueOf, shorten |
| top-level / `foundationgames/enhancedblockentities/util/hacks/ExperimentalSetup.java` | `` |  | values, valueOf, setup, setupChests, setupBeds, setupSigns, cacheResources |
| top-level / `foundationgames/enhancedblockentities/util/hacks/ResourceHacks.java` | `` |  | values, valueOf, cropAndPutTexture, addChestParticleTexture, addBedParticleTexture, addSignParticleTexture |
| top-level / `foundationgames/enhancedblockentities/util/hacks/TextureHacks.java` | `` |  | values, valueOf, cropImage |
| top-level / `foundationgames/enhancedblockentities/util/ResourceUtil.java` | `` |  | values, valueOf, addChestItemDefinition, addBedItemDefinition, list, kv, kv, dynamicTypeKey, variant, variantY, variantXY, variantRotation16, variantHFacing, addChestLikeModel, addSingleChestModels, addDoubleChestModels, chestParticle, bedParticle, signParticle, addBlockState, addChestBlockStates, addSingleChestOnlyBlockStates, addParentModel, addParentTexModel, addSignTypeModels, addRotation16Models, signAOSuffix, addSignBlockStates, addHangingSignBlockStates, addBellBlockState, addBedModels, addBedBlockState, bedAOSuffix, addShulkerBoxModels, addShulkerBoxBlockStates, addDecoratedPotBlockState, addDecoratedPotPatternModels, resetBasePack, resetTopLevelPack, getBasePack, getTopLevelPack, getPackForCompat, dumpModAssets, dumpAllPacks, append, get |
| top-level / `foundationgames/enhancedblockentities/util/WorldUtil.java` | `` |  | rebuildChunk, rebuildChunkAndThen, scheduleTimed, onEndTick |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
