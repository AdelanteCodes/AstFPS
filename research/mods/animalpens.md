# Animal Pens

Review status: **Evidence inventory; behavioral review pending**

Project: [Animal Pens](https://modrinth.com/mod/animalpens)
Selected artifact version: `2.5.1-26.3`
Published implementation source: https://github.com/BONNePlayground/AnimalPen/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Reduce lag and keep your animals neatly stored while maintaining full interactivity!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha1`: `756af646471eac1c8d263755bf571b77493f46d2`
- `sha512`: `f1dac30c7f41ce94bde0097c2432f8cd44ede4e90674896e1ced64b987289e0b3472eebef7eacd24fdc64a25899875b3e80113145f824a9d287467db44385abd`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 213
Reconstructed Java files: 163

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "lv.id.bonne.animalpen.fabric.AnimalPenFabric"
  ],
  "client": [
    "lv.id.bonne.animalpen.client.fabric.AnimalPenFabricClient"
  ],
  "modmenu": [
    "lv.id.bonne.animalpen.client.fabric.AnimalPenModMenuIntegration"
  ],
  "jei_mod_plugin": [
    "lv.id.bonne.animalpen.integration.jei.JEIPlugin"
  ],
  "fabric-datagen": [
    "lv.id.bonne.animalpen.data.provider.fabric.AnimalPenFabricDataGen"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

**accessWidener**

```json
"animal_pen.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `lv/id/bonne/animalpen/advancements/critereon/AnimalInteractTrigger.java` | `` |  | codec, trigger, matches, wrap, interactAnimal, interactAnimalWithItem, interactAnimalWithItem |
| top-level / `lv/id/bonne/animalpen/advancements/critereon/AnimalItemUseTrigger.java` | `` |  | codec, trigger, matches, wrap, releaseAnimal, caughtAnimalWithItem, caughtWithItem |
| top-level / `lv/id/bonne/animalpen/advancements/critereon/AnimalVariantChangeTrigger.java` | `` |  | codec, trigger, changeVariant |
| top-level / `lv/id/bonne/animalpen/AnimalPen.java` | `` |  | init, config, sendDebug, resourceOf |
| top-level / `lv/id/bonne/animalpen/blocks/AbstractAnimalContainerBlock.java` | `` |  | useItemOn, attack, getDestroyProgress, hasAnalogOutputSignal, getAnalogOutputSignal, isPathfindable, getListener, newBlockEntity, getTicker, createTickerHelper |
| top-level / `lv/id/bonne/animalpen/blocks/AnimalPenBlock.java` | `` |  | getAttackToolTag, getTileType, getContainerItem, createBlockStateDefinition, getStateForPlacement, getShape, getSerializedName |
| top-level / `lv/id/bonne/animalpen/blocks/AquariumBlock.java` | `` |  | getAttackToolTag, getTileType, getContainerItem, propagatesSkylightDown, getVisualShape, getShadeBrightness, createBlockStateDefinition, getStateForPlacement, getShape, getSerializedName |
| top-level / `lv/id/bonne/animalpen/blocks/AviaryBlock.java` | `` |  | getAttackToolTag, getTileType, getContainerItem, useItemOn, createBlockStateDefinition, getStateForPlacement, getShape, getSerializedName |
| top-level / `lv/id/bonne/animalpen/blocks/CopperAviaryBlock.java` | `` |  | randomTick, isRandomlyTicking, getAge |
| top-level / `lv/id/bonne/animalpen/blocks/entities/AbstractAnimalPenBlockEntity.java` | `` |  | canPlaceItem, setChanged, saveAdditional, loadAdditional, getUpdateTag, getUpdatePacket, triggerUpdate, preRemoveSideEffects, tick, processContainer, interactWithPen, interactWithPen, attackThePen, performInteraction, requiresClientUpdate, triggerEndFunctions, triggerStartFunctions, triggerStartFunction, getEntityVariants, updateAnimalVariant, removeAnimalVariant, validateItemStack, getDeathTicker, getTickCounter, getAnimalDisplaySize, setAnimalDisplaySize, getProtectedAmount, setProtectedAmount, getOwner, setOwner, getAnimalCount, updateAnimalCount, getInventory, getItemStack, getStoredAnimal, getCooldownLines, getRedStoneSignal, setAndUpdateBlockState, getDecorationBlockState, InteractionResult |
| top-level / `lv/id/bonne/animalpen/blocks/entities/AnimalPenTileEntity.java` | `` |  | canGrowEntity, validateItemStack, dropPosition, getDecorations, getBlockStateWithDecorationIndex |
| top-level / `lv/id/bonne/animalpen/blocks/entities/AquariumTileEntity.java` | `` |  | canGrowEntity, validateItemStack, triggerUpdate, dropPosition, getDecorations, getBlockStateWithDecorationIndex, getDecorationBlockState |
| top-level / `lv/id/bonne/animalpen/blocks/entities/AviaryTileEntity.java` | `` |  | canGrowEntity, validateItemStack, dropPosition, getDecorations, getBlockStateWithDecorationIndex |
| top-level / `lv/id/bonne/animalpen/blocks/renderer/AbstractAnimalPenRenderer.java` | `` |  | createRenderState, extractRenderState, submit, renderAnimal, renderCounter, renderTextLines, calculateMaxWidth, renderTextLine, configureAnimalPose, getTextLineSpacing, getViewDistance |
| top-level / `lv/id/bonne/animalpen/blocks/renderer/AnimalPenRenderer.java` | `` |  | getAnimalVerticalOffset, getAnimalSize, shouldGrowAnimals, getTextStartHeight, shouldRenderOffScreen, shouldRender, configureAnimalPose |
| top-level / `lv/id/bonne/animalpen/blocks/renderer/AquariumRenderer.java` | `` |  | getAnimalVerticalOffset, getAnimalSize, shouldGrowAnimals, getTextStartHeight, configureAnimalPose, shouldRenderOffScreen, shouldRender |
| top-level / `lv/id/bonne/animalpen/blocks/renderer/AviaryRenderer.java` | `` |  | getAnimalVerticalOffset, getAnimalSize, shouldGrowAnimals, getTextStartHeight, shouldRenderOffScreen, shouldRender, configureAnimalPose |
| top-level / `lv/id/bonne/animalpen/blocks/renderer/MobDisplayAnimator.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/blocks/renderer/state/AnimalPenRenderState.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/blocks/WeatheringCopperAviary.java` | `` |  | getPrevious, getPrevious, getNext |
| top-level / `lv/id/bonne/animalpen/client/AnimalPenClient.java` | `` |  | init |
| top-level / `lv/id/bonne/animalpen/client/fabric/AnimalPenFabricClient.java` | `` |  | onInitializeClient |
| top-level / `lv/id/bonne/animalpen/client/fabric/AnimalPenModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `lv/id/bonne/animalpen/client/screens/renderer/pip/DecorationGUIRenderer.java` | `` |  | getRenderStateClass, getTextureLabel, renderToTexture, textureIsReadyToBlit |
| top-level / `lv/id/bonne/animalpen/client/screens/renderer/state/DecorationGUIRenderState.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/client/screens/VariantsConfigScreen.java` | `` |  | init, extractWidgetRenderState, isValidText, insertText, extractRenderState, extractBackground, onSave, onCancel, saveConfiguration, isPauseScreen, onClose, isValidNumber, extractWidgetRenderState, updateMessage, applyValue, getIntValue, selected, updateWidgetNarration, onPress, extractContents |
| top-level / `lv/id/bonne/animalpen/client/screens/VariantScreenSelection.java` | `` |  | init, rebuildDynamicWidgets, getPosition, update, tick, isPauseScreen, extractRenderState, extractMenuBackground, renderVariantButtons, renderButtonBorder, renderOtherButtons, renderScrollBar, renderTextBar, renderEntity, renderCooldown, renderDecoration, renderTextLine, renderTooltips, needsScrollBars, handleDeleteButton, handleApplyButton, handleVariantButton, handleConfigureButton, handleCooldownButton, handleDecorationButton, scrollBarClicked, entityAreaClicked, mouseClicked, mouseReleased, mouseScrolled, mouseDragged, keyPressed, keyReleased, updateButtonPositions, ensureButtonVisible |
| top-level / `lv/id/bonne/animalpen/client/screens/widget/DecorationButton.java` | `` |  | extractContents |
| top-level / `lv/id/bonne/animalpen/client/screens/widget/EntityButton.java` | `` |  | extractContents |
| top-level / `lv/id/bonne/animalpen/client/WaterTankColor.java` | `` |  | color |
| top-level / `lv/id/bonne/animalpen/commands/AnimalPenCommands.java` | `` |  | register |
| top-level / `lv/id/bonne/animalpen/config/adapters/IdentifierTypeAdapter.java` | `` |  | serialize, deserialize |
| top-level / `lv/id/bonne/animalpen/config/annotations/JsonComment.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/config/annotations/JsonComments.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/config/Configuration.java` | `` |  | isInvalid, setDefaults, getMaximalAnimalCount, getMaximalAnimalCountNormalized, isGrowAnimalPenMob, getAnimalPenMobSize, isGrowAquariumMob, getAquariumMobSize, isGrowAviaryMob, getAviaryMobSize, getGrowthMultiplier, getAttackCooldown, getMaxStoredVariants, isTriggerAdvancements, isIncreaseStatistics, isDebug, isShowCooldownsOnCrouch, isShowAllInteractions, isBlockDispenserInteractions, getDefaultConfig, setGrowAnimalPenMob, setAnimalPenMobSize, setGrowAquariumMob, setAquariumMobSize, setGrowAviaryMob, setAviaryMobSize, setGrowthMultiplier, setShowCooldownsOnCrouch, setShowAllInteractions, setAttackCooldown, setMaximalAnimalCount, setMaxStoredAnimalVariants, setTriggerAdvancements, setIncreaseStatistics, setDebug, setBlockDispenserInteractions |
| top-level / `lv/id/bonne/animalpen/config/ConfigurationManager.java` | `` |  | generateConfig, getConfigFile, readConfig, reloadConfig, reset, isInvalid, writeConfig, getConfiguration |
| top-level / `lv/id/bonne/animalpen/config/screen/AnimalPenConfigScreen.java` | `` |  | createConfigScreen, buildClientConfig, buildServerConfig, isLocalSide, tooltips |
| top-level / `lv/id/bonne/animalpen/config/util/CommentGeneration.java` | `` |  | writeWithComments, serializeObjectWithComments, hasTypeAdapter, serializeCollection, serializeMap, isNotPrimitive |
| top-level / `lv/id/bonne/animalpen/data/helper/SimpleItemTagAppender.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/data/helper/SimpleTagAppender.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/data/listener/AnimalInteractionEntry.java` | `` |  | AnimalInteractionEntry, decode, encode, isActive, of |
| top-level / `lv/id/bonne/animalpen/data/listener/AnimalInteractionReloadListener.java` | `` |  | apply |
| top-level / `lv/id/bonne/animalpen/data/provider/AnimalInteractionProvider.java` | `` |  | run, generateData, getName, generateFood, generateFood, generateAmbientSound, generateBucketable, generateWithInteractions, generateAmbient, generateWithFoodAndAmbient, generateWithFoodAndAmbient, generateAxolotl, generateChicken, generateBee, generateCow, generateMooshroom, generateGoat, generateSheep, generateTurtle, generateFish, generateFrog, generateAllay, generateSniffer, generateArmadillo |
| top-level / `lv/id/bonne/animalpen/data/provider/AnimalPenLootProvider.java` | `` |  | generate |
| top-level / `lv/id/bonne/animalpen/data/provider/fabric/AnimalPenFabricDataGen.java` | `` |  | onInitializeDataGenerator |
| top-level / `lv/id/bonne/animalpen/data/provider/fabric/FabricBlockLootProvider.java` | `` |  | modDropSelf, generate |
| top-level / `lv/id/bonne/animalpen/data/provider/fabric/FabricModAdvancementProvider.java` | `` |  | generateAdvancement, generatePlatformAdvancement |
| top-level / `lv/id/bonne/animalpen/data/provider/fabric/FabricModBlockTagProvider.java` | `` |  | addTags, modTag, add |
| top-level / `lv/id/bonne/animalpen/data/provider/fabric/FabricModEntityTypeTagProvider.java` | `` |  | addTags, modTag, add |
| top-level / `lv/id/bonne/animalpen/data/provider/fabric/FabricModItemTagProvider.java` | `` |  | addTags, modTag, add, copy, optionalTag, tag |
| top-level / `lv/id/bonne/animalpen/data/provider/fabric/FabricModLootProvider.java` | `` |  | generate, run |
| top-level / `lv/id/bonne/animalpen/data/provider/fabric/FabricModModelProvider.java` | `` |  | generateBlockStateModels, generateItemModels, generateAnimalPen, generateAnimalPen, generateAquarium, generateAviary, generateAviary, rotationTranslate |
| top-level / `lv/id/bonne/animalpen/data/provider/fabric/FabricModRecipeProvider.java` | `` |  | createRecipeProvider, getName, buildRecipes, hasItem |
| top-level / `lv/id/bonne/animalpen/data/provider/ModAdvancementProvider.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/data/provider/ModBlockLootProvider.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/data/provider/ModBlockTagsProvider.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/data/provider/ModEntityTypeTagsProvider.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/data/provider/ModItemTagsProvider.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/data/provider/ModRecipeProvider.java` | `` |  | animalPen |
| top-level / `lv/id/bonne/animalpen/data/saveddata/IndividualPenStorage.java` | `` |  | getVariants, setVariants, getOrCreate, delete, type, CODEC |
| top-level / `lv/id/bonne/animalpen/events/CommonClientEvents.java` | `` |  | onRightClickBlock |
| top-level / `lv/id/bonne/animalpen/events/CommonEvents.java` | `` |  | onPlayerJoin |
| top-level / `lv/id/bonne/animalpen/fabric/AnimalPenFabric.java` | `` |  | onInitialize |
| top-level / `lv/id/bonne/animalpen/integration/jei/category/AbstractRecipeCategory.java` | `` |  | getWidth, getHeight, getIcon, setRecipe, draw |
| top-level / `lv/id/bonne/animalpen/integration/jei/category/AnimalCageRecipeCategory.java` | `` |  | getTitle, getRecipeType |
| top-level / `lv/id/bonne/animalpen/integration/jei/category/BirdCageRecipeCategory.java` | `` |  | getTitle, getRecipeType |
| top-level / `lv/id/bonne/animalpen/integration/jei/category/WaterContainerRecipeCategory.java` | `` |  | getTitle, getRecipeType |
| top-level / `lv/id/bonne/animalpen/integration/jei/JEIPlugin.java` | `` |  | getPluginUid, registerCategories, registerRecipes, registerRecipeCatalysts |
| top-level / `lv/id/bonne/animalpen/integration/jei/recipe/ItemInfoRecipe.java` | `` |  | ItemInfoRecipe |
| top-level / `lv/id/bonne/animalpen/interaction/condition/ConditionEntry.java` | `` |  | getSerializedName, matchCondition, matchCondition, matchCondition |
| top-level / `lv/id/bonne/animalpen/interaction/condition/Operator.java` | `` |  | test, test, test, test, test, test, test, test |
| top-level / `lv/id/bonne/animalpen/interaction/cooldown/CooldownEntry.java` | `` |  | getSerializedName, calculateCooldown, calculateCooldown, calculateCooldown |
| top-level / `lv/id/bonne/animalpen/interaction/function/FunctionKey.java` | `` |  | FunctionKey, of, of, of, of, of |
| top-level / `lv/id/bonne/animalpen/interaction/ingredient/ConsumerEntry.java` | `` |  | getSerializedName, getConsumedItem, calculateConsumption, consumeItems, getConsumedItem, calculateConsumption, consumeItems, getConsumedItem, calculateConsumption, consumeItems, getConsumedItem, calculateConsumption, consumeItems |
| top-level / `lv/id/bonne/animalpen/interaction/ingredient/CustomIngredient.java` | `` |  | getItems, dissolve, test, isSameIgnoreDurability, isEmpty, fromValues, of, of, of, of, of, merge, codec, getItems, getItems |
| top-level / `lv/id/bonne/animalpen/interaction/loot/LootEntry.java` | `` |  | LootEntry, processLootTable, of, of, of, of |
| top-level / `lv/id/bonne/animalpen/interaction/model/AnimalInteraction.java` | `` |  | AnimalInteraction, matchAllConditions, normalizeMobCount, applyCooldown, triggerFunctions, triggerFunctions |
| top-level / `lv/id/bonne/animalpen/interaction/model/AnimalInteractionBuilder.java` | `` |  | ingredient, consume, conditions, conditions, lootEntry, even, cooldown, textLines, runFunctions, finishFunctions, sound, redstoneBit, build, create |
| top-level / `lv/id/bonne/animalpen/interaction/textentry/TextEntry.java` | `` |  | TextEntry, animalPenGetLine, getItemIcon, ready, cooldown, cooldown |
| top-level / `lv/id/bonne/animalpen/interaction/textentry/TextEntryVisibility.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/interaction/value/BoolValue.java` | `` |  | getAsInt, getAsBoolean, getAsString |
| top-level / `lv/id/bonne/animalpen/interaction/value/IntValue.java` | `` |  | getAsInt, getAsBoolean, getAsString |
| top-level / `lv/id/bonne/animalpen/interaction/value/LongValue.java` | `` |  | getAsInt, getAsLong, getAsBoolean, getAsString |
| top-level / `lv/id/bonne/animalpen/interaction/value/StringValue.java` | `` |  | getAsInt, getAsLong, getAsBoolean, getAsString |
| top-level / `lv/id/bonne/animalpen/interaction/value/TagValue.java` | `` |  | getAsInt, getAsLong, getAsBoolean, getAsString |
| top-level / `lv/id/bonne/animalpen/interaction/value/Value.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/items/AbstractAnimalStorageItem.java` | `` |  | verifyComponentsAfterLoad, appendHoverText, interactLivingEntity, useOn, captureMob, tryRelease, onDestroyed, decrementStoredAmount, dropEquipment, matchEntity, isFull, error |
| top-level / `lv/id/bonne/animalpen/items/AnimalCageItem.java` | `` |  | tooltipKeyBase, pickableTag, blockEntityHandler |
| top-level / `lv/id/bonne/animalpen/items/AnimalContainerItem.java` | `` |  | tooltipKeyBase, pickableTag, blockEntityHandler |
| top-level / `lv/id/bonne/animalpen/items/BirdCatcherItem.java` | `` |  | tooltipKeyBase, pickableTag, blockEntityHandler |
| top-level / `lv/id/bonne/animalpen/items/component/StoredMob.java` | `` |  | StoredMob, of |
| top-level / `lv/id/bonne/animalpen/items/component/StoredMobData.java` | `` |  | StoredMobData, of |
| top-level / `lv/id/bonne/animalpen/items/component/StoredMobVariantKey.java` | `` |  | StoredMobVariantKey, of, of, of, of, withSize |
| top-level / `lv/id/bonne/animalpen/items/component/StoredMobVariants.java` | `` |  | StoredMobVariants, of |
| top-level / `lv/id/bonne/animalpen/mixin/accessors/EntityAccessor.java` | `value={Entity.class})` | Accessor:1 |  |
| top-level / `lv/id/bonne/animalpen/mixin/accessors/GuiGraphicsAccessor.java` | `value={GuiGraphicsExtractor.class})` | Accessor:1 |  |
| top-level / `lv/id/bonne/animalpen/mixin/accessors/MushroomCowAccessor.java` | `value={MushroomCow.class})` | Accessor:1 |  |
| top-level / `lv/id/bonne/animalpen/mixin/AquariumBlockCollisionPrevention.java` | `value={BlockBehaviour.class})` | Inject:1 | preventBlockPlacementAbove |
| top-level / `lv/id/bonne/animalpen/mixin/DispenserMixin.java` | `value={DispenserBlock.class})` | Inject:1 | animalPen$customDispenseFromAction |
| top-level / `lv/id/bonne/animalpen/mixin/fabric/InfinitePlayerAttack.java` | `value={MultiPlayerGameMode.class})` | Inject:1 | performBlockAttack |
| top-level / `lv/id/bonne/animalpen/mixin/FixAllayPickup.java` | `value={Allay.class})` | Inject:1 | preventPickingCatcher |
| top-level / `lv/id/bonne/animalpen/mixin/FixChestedHorseInteraction.java` | `value={AbstractChestedHorse.class})` | Inject:1 | addAnimalCageException |
| top-level / `lv/id/bonne/animalpen/mixin/FixHorseInteraction.java` | `value={Horse.class})` | Inject:1 | addAnimalCageException |
| top-level / `lv/id/bonne/animalpen/mixin/FixZombieHorseInteraction.java` | `value={ZombieHorse.class})` | Inject:1 | addAnimalCageException |
| top-level / `lv/id/bonne/animalpen/mixin/MigrateEquipmentSlot.java` | `value={EntityEquipment.class})` | Inject:2 | migrateOnCreating, migrateOnEquippingItemStack |
| top-level / `lv/id/bonne/animalpen/mixin/MigrateItemStack.java` | `value={ItemStack.class})` | Inject:4 | migrateOnCreation, migrateOnValidate, migrateOnApplyDataComponentMap, migrateOnApplyPatchedDataComponentMap |
| top-level / `lv/id/bonne/animalpen/mixin/MixinHoneycombItem.java` | `value={HoneycombItem.class})` | Inject:1 | replaceWaxedAviary |
| top-level / `lv/id/bonne/animalpen/mixin/MixinLevelChunk.java` | `value={LevelChunk.class})` | Redirect:1 | injected |
| top-level / `lv/id/bonne/animalpen/mixin/MixinLightingBolt.java` | `value={LightningBolt.class})` | Redirect:2 | aviaryCleaningStep, replaceFirstState |
| top-level / `lv/id/bonne/animalpen/mixin/SheepMixin.java` | `value={Sheep.class})` |  | setShearedState |
| top-level / `lv/id/bonne/animalpen/network/NetworkPackets.java` | `` |  | register |
| top-level / `lv/id/bonne/animalpen/network/packets/AnimalInteractionSyncEndPacket.java` | `` |  | handle, type |
| top-level / `lv/id/bonne/animalpen/network/packets/AnimalInteractionSyncEntityPacket.java` | `` |  | handle, type |
| top-level / `lv/id/bonne/animalpen/network/packets/AnimalInteractionSyncStartPacket.java` | `` |  | handle, type |
| top-level / `lv/id/bonne/animalpen/network/packets/ChangeDecorationData.java` | `` |  | handle, type |
| top-level / `lv/id/bonne/animalpen/network/packets/RemoveDisplayAnimalData.java` | `` |  | handle, type |
| top-level / `lv/id/bonne/animalpen/network/packets/RequestVariantData.java` | `` |  | handle, type |
| top-level / `lv/id/bonne/animalpen/network/packets/UpdateConfigurationData.java` | `` |  | handle, type |
| top-level / `lv/id/bonne/animalpen/network/packets/UpdateDisplayAnimalData.java` | `` |  | handle, type |
| top-level / `lv/id/bonne/animalpen/network/packets/UpdateVariantScreenData.java` | `` |  | handle, type |
| top-level / `lv/id/bonne/animalpen/network/PacketSpec.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/platform/fabric/ItemTransferHelperImpl.java` | `` |  | canInsert, insert, insertIntoVanillaContainer |
| top-level / `lv/id/bonne/animalpen/platform/fabric/NetworkHandlerImpl.java` | `` |  | register, sendToPlayer, sendToServer |
| top-level / `lv/id/bonne/animalpen/platform/fabric/PlatformHelperImpl.java` | `` |  | createBlockEntity, createCreativeTab, isModLoaded, isFake |
| top-level / `lv/id/bonne/animalpen/platform/fabric/RegistryHelperImpl.java` | `` |  | registerBlock, registerItem, registerBlockEntityType, registerFunction, registerDataComponent, registerTrigger, registerCreativeTab, getFunctionValue, getFunctionKey, getRegisterItems, createRegistry |
| top-level / `lv/id/bonne/animalpen/platform/services/IItemTransferHelper.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/platform/services/INetworkHandler.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/platform/services/IPlatformHelper.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/platform/services/IRegistryHelper.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/platform/Services.java` | `` |  | load |
| top-level / `lv/id/bonne/animalpen/processing/executor/AnimalInteractionExecutor.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/processing/executor/DispenserInteractionExecutor.java` | `` |  | countAvailable, consume, drop, damageItem, giveFirst, triggerFunctions, triggerItemUse, removeAndReturnRemining |
| top-level / `lv/id/bonne/animalpen/processing/executor/PlayerInteractionExecutor.java` | `` |  | countAvailable, consume, giveFirst, drop, damageItem, triggerFunctions, triggerItemUse |
| top-level / `lv/id/bonne/animalpen/processing/function/api/EntityFunction.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/processing/function/api/ShearStateAccessor.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/processing/function/core/BucketablePickup.java` | `` |  | interactPlayer, interactDispenser |
| top-level / `lv/id/bonne/animalpen/processing/function/core/DropRequestedLoot.java` | `` |  | processFunction |
| top-level / `lv/id/bonne/animalpen/processing/function/core/Feeding.java` | `` |  | interactPlayer, interactDispenser, processData |
| top-level / `lv/id/bonne/animalpen/processing/function/core/IncrementIntegerDataKey.java` | `` |  | processFunction |
| top-level / `lv/id/bonne/animalpen/processing/function/core/MobSetSheared.java` | `` |  | processFunction |
| top-level / `lv/id/bonne/animalpen/processing/function/core/MooshroomEffectApply.java` | `` |  | interactPlayer |
| top-level / `lv/id/bonne/animalpen/processing/function/core/MooshroomEffectFail.java` | `` |  | interactPlayer |
| top-level / `lv/id/bonne/animalpen/processing/function/core/MooshroomEffectRemove.java` | `` |  | interactPlayer, interactDispenser, removeEffect |
| top-level / `lv/id/bonne/animalpen/processing/function/core/SheepChangeColor.java` | `` |  | interactPlayer, interactDispenser, changeSheepColor |
| top-level / `lv/id/bonne/animalpen/processing/function/core/TurtleScuteDrop.java` | `` |  | processFunction |
| top-level / `lv/id/bonne/animalpen/processing/function/wrapper/EntityFunctionEntry.java` | `` |  | function, interactPlayer, interactDispenser, processFunction |
| top-level / `lv/id/bonne/animalpen/registries/AnimalPenBlockRegistry.java` | `` |  | register, registerBlock, registerBlockItem, registerPen, registerAviary |
| top-level / `lv/id/bonne/animalpen/registries/AnimalPenCriteriaTriggersRegistry.java` | `` |  | register |
| top-level / `lv/id/bonne/animalpen/registries/AnimalPenDataComponentRegistry.java` | `` |  | register |
| top-level / `lv/id/bonne/animalpen/registries/AnimalPenFunctionRegistry.java` | `` |  | register |
| top-level / `lv/id/bonne/animalpen/registries/AnimalPenInteractionRegistry.java` | `` |  | clear, register, register, get, getAll, getAmount, matchInteraction, getInteractions, setEntityCount, containsAllEntities |
| top-level / `lv/id/bonne/animalpen/registries/AnimalPenLootTables.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/registries/AnimalPenMobAnimationsRegistry.java` | `` |  | init |
| top-level / `lv/id/bonne/animalpen/registries/AnimalPenRegistry.java` | `` |  | register |
| top-level / `lv/id/bonne/animalpen/registries/AnimalPensCreativeTabRegistry.java` | `` |  | register |
| top-level / `lv/id/bonne/animalpen/registries/AnimalPensItemRegistry.java` | `` |  | register |
| top-level / `lv/id/bonne/animalpen/registries/AnimalPenTags.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/registries/AnimalPenTileEntityRegistry.java` | `` |  | register |
| top-level / `lv/id/bonne/animalpen/util/AnimalPenCompoundTags.java` | `` |  |  |
| top-level / `lv/id/bonne/animalpen/util/AnimalPenItemHelper.java` | `` |  | getEffectFromItemStack, replacement, itemTag, itemTag, getCooldowns, getMobCount |
| top-level / `lv/id/bonne/animalpen/util/AnimalPenVariantHelper.java` | `` |  | storeAnimalVariant, getAnimalVariants, canMergeAnimalVariants, mergeAnimalVariants, customInteraction, saveMob, loadMob |
| top-level / `lv/id/bonne/animalpen/util/CustomCodec.java` | `` |  | strictOptionalListField, encode, decode, keys |
| top-level / `lv/id/bonne/animalpen/util/DataOrderInjection.java` | `` |  | injectCustomOrder, removeCustomOrder |

## Data-driven behavior

Resource category counts: `advancement`: 95, `advancements`: 2, `animal_interactions`: 44, `loot_table`: 35, `patchouli_books`: 1, `recipe`: 24, `tags`: 10.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
