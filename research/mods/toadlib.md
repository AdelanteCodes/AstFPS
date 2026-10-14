# ToadLib

Review status: **Evidence inventory; behavioral review pending**

Project: [ToadLib](https://modrinth.com/mod/toadlib)
Selected artifact version: `1.5.3-26.3-fabric`
Published implementation source: https://github.com/ITsMrToad/ToadLib-mod/tree/1.19.4
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Library - mod. Needed for my mods.
Contains a set of utilities, custom config, abstractions and more.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha512`: `bb218e55376d5b0697aa5f7c8b864a6d56b11d186825309df7b545b3e4216838293a5c700dd4b5a2835ca3db462afa247d72266e4d34ae0433e606b11c7beb57`
- `sha1`: `1220b8fb5c477c4447907bdeafcedd2928630bc5`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 258
Reconstructed Java files: 209

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.mr_toad.lib.fabric.ToadLib"
  ],
  "client": [
    "com.mr_toad.lib.fabric.ToadLibClient"
  ],
  "modmenu": [
    "com.mr_toad.lib.fabric.ToadLibModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.0",
  "fabric-api": "*",
  "architectury": "*",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/mr_toad/lib/api/client/init/ConfigEntryWidgetsRegistry.java` | `` |  | init, initMakers, registerMaker, registerTicker, getMakerOf, getTickerOf, tooltip |
| top-level / `com/mr_toad/lib/api/client/init/EaseWidgetSettingsRegistry.java` | `` |  | init, registerEase, registerEase, resolve |
| top-level / `com/mr_toad/lib/api/client/screen/config/ToadConfigScreen.java` | `` |  | init, tick, onTurnBack, onClose, extractRenderState, fillEntries, fillEntries |
| top-level / `com/mr_toad/lib/api/client/screen/config/ToadConfigsScreen.java` | `` |  | init |
| top-level / `com/mr_toad/lib/api/client/screen/config/widget/ConfigEntriesSelectionList.java` | `` |  | getEntryAt, extractSelection, getNarration, extractContent, mouseClicked, mouseScrolled, mouseDragged, mouseReleased, keyPressed, charTyped, keyReleased, isMouseOver |
| top-level / `com/mr_toad/lib/api/client/screen/config/widget/ConfigEntryWidgetMaker.java` | `` |  |  |
| top-level / `com/mr_toad/lib/api/client/screen/config/widget/ConfigSelectionList.java` | `` |  | getNarration, extractContent, mouseClicked |
| top-level / `com/mr_toad/lib/api/client/screen/config/widget/UnexpectedEntry.java` | `` |  | extractRenderState, setFocused, isFocused |
| top-level / `com/mr_toad/lib/api/client/screen/ex/ParentableToadLibScreen.java` | `` |  | init, onTurnBack |
| top-level / `com/mr_toad/lib/api/client/screen/ex/ToadLibScreen.java` | `` |  | init |
| top-level / `com/mr_toad/lib/api/client/screen/ex/widget/CloseableWidget.java` | `` |  |  |
| top-level / `com/mr_toad/lib/api/client/screen/ex/widget/color/ColorCellsWidget.java` | `` |  | of, extractWidgetRenderState, mouseClicked, updateWidgetNarration, onChange, setSelected, mapTitleY, isSelected, getValue, getCellsPerRow, size, size, addTitle, setCellSize, setDefaultValue, build |
| top-level / `com/mr_toad/lib/api/client/screen/ex/widget/color/ColorPaletteWidget.java` | `` |  | extractWidgetRenderState, mouseClicked, mouseDragged, setY, updateWidgetNarration, onClose, onChange, updateValue, sliderValueFromMouse, mousePaletteValue, isOnAlpha, getValue, getPalette, getAlphaElement, setAlphaAllowed, render, isMouseOver, setValue, getX, getY, getW, getH, getValue, PaletteTextureListener, create, getColorAtMouse, close |
| top-level / `com/mr_toad/lib/api/client/screen/ex/widget/ExCheckboxV2.java` | `` |  | calculateWidth, calculateHeight, extractContents, onPress, isSelected, updateWidgetNarration, setSelected |
| top-level / `com/mr_toad/lib/api/client/screen/ex/widget/ExEditBox.java` | `` |  | extractWidgetRenderState, setRenderMagnifyingGlass |
| top-level / `com/mr_toad/lib/api/client/screen/ex/widget/ExObjectSelectionList.java` | `` |  | mouseClicked, mouseDragged, mouseScrolled, mouseReleased, addEntry, removeEntry, clearEntries, addAll, getEntryAt |
| top-level / `com/mr_toad/lib/api/client/screen/ex/widget/ExSlider.java` | `` |  | keyPressed, onClick, onDrag, applyValue, updateMessage, getMessage, setRealValue, setValueFromMouse2, toNormalized, toReal, getValueDouble, getValue, getValueLong, getValueInt, getValueString |
| top-level / `com/mr_toad/lib/api/client/screen/ex/widget/LinkButton.java` | `` |  | extractContents, getTexture, u, v, w, h, yDiff |
| top-level / `com/mr_toad/lib/api/client/screen/ex/widget/SpriteButton.java` | `` |  | of, extractContents, renderTexture, setShouldRenderTemp, isShouldRenderTemp, size, uv, imageSize, texSize, setYDiff, setTooltip, addNarration, build, buildWithMappingTexPos, renderTexture, buildCentred |
| top-level / `com/mr_toad/lib/api/client/screen/ex/widget/WidgetSelectionList.java` | `` |  | getRowWidth, scrollBarX, getEntryAt, extractSelection, getNarration, extractContent, mouseClicked, mouseScrolled, mouseDragged, mouseReleased, keyPressed, charTyped, keyReleased, isMouseOver |
| top-level / `com/mr_toad/lib/api/client/screen/interpolation/InterpolationSelectionScreen.java` | `` |  | init, extractRenderState, fillWidgets, updateWidgetAccess, createSlider |
| top-level / `com/mr_toad/lib/api/client/screen/interpolation/widget/InterpolationTypeWidget.java` | `` |  | extractContents, updateWidgetNarration, isSame |
| top-level / `com/mr_toad/lib/api/client/utils/graphics/gl/GLProfiler.java` | `` |  | start, close, destroy, getQueries, targetName |
| top-level / `com/mr_toad/lib/api/client/utils/graphics/gl/GLU.java` | `` |  | getProfiler, destroyProfilers, unbindBuffer, checkErrors, deleteBuffers, getQueryResult |
| top-level / `com/mr_toad/lib/api/client/utils/graphics/Graphics2D.java` | `` |  | point, point, drawIdealText, drawIdealText, fill, fill, fillGradient, scissor, popPush, safePopPush |
| top-level / `com/mr_toad/lib/api/client/utils/graphics/Graphics3D.java` | `` |  | popPush, safePopPush |
| top-level / `com/mr_toad/lib/api/client/utils/graphics/GraphicsException.java` | `` |  | get |
| top-level / `com/mr_toad/lib/api/client/utils/graphics/ToadMemoryUtils.java` | `` |  | fromStream |
| top-level / `com/mr_toad/lib/api/client/utils/StringWidgetBuilder.java` | `` |  | center, x, y, w, h, font, build |
| top-level / `com/mr_toad/lib/api/client/utils/ToadClientUtils.java` | `` |  | createInfoButton, createResetButton, createRefreshButton, createConfigButton, renderMagnifyingGlass, extendTooltip, extendTooltip, openFile, openURL, centred, getCentredStyleOf, getStyleOf |
| top-level / `com/mr_toad/lib/api/config/entry/BoolEntry.java` | `` |  |  |
| top-level / `com/mr_toad/lib/api/config/entry/ColorEntry.java` | `` |  | get, setValue, getDescription, setAllowAlpha, setCellSize, validate, invokeAlpha, invokeRed, invokeGreen, invokeBlue, getCells, getCellSize, isAllowAlpha, getMode |
| top-level / `com/mr_toad/lib/api/config/entry/ConfigEntry.java` | `` |  | dontDrawInScreen, reloadResource, addTitle, addDescription, withTooltipSuffix, addDeprecationRule, addDeprecationRule, addChangeCallback, addChangeCallback, addLoadCallback, addLoadCallback, addResetCallback, addResetCallback, save, load, get, getDisplayValue, setValue, resetValue, loadValue, getType, getDefaultValue, drawInScreen, isDefault, isDeprecated, getTitle, getDescription, getBaseTooltip, mustReloadResource, getSerializationName, equals, hashCode, toString |
| top-level / `com/mr_toad/lib/api/config/entry/DegreeEntry.java` | `` |  | setValue, toRad |
| top-level / `com/mr_toad/lib/api/config/entry/EnumEntry.java` | `` |  | createEnum, get, setValue, loadValue, getBaseTooltip, addVariousTooltip, getValues, getNaming |
| top-level / `com/mr_toad/lib/api/config/entry/PercentEntry.java` | `` |  | setValue, getByPercents, getByPercents, getByPercents, getByPercents |
| top-level / `com/mr_toad/lib/api/config/entry/primitive/ByteEntry.java` | `` |  | setStep, inBounds, safeMin, safeMax |
| top-level / `com/mr_toad/lib/api/config/entry/primitive/DoubleEntry.java` | `` |  | inBounds, safeMin, safeMax |
| top-level / `com/mr_toad/lib/api/config/entry/primitive/FloatEntry.java` | `` |  | inBounds, safeMin, safeMax |
| top-level / `com/mr_toad/lib/api/config/entry/primitive/IntEntry.java` | `` |  | setStep, inBounds, safeMin, safeMax |
| top-level / `com/mr_toad/lib/api/config/entry/primitive/LongEntry.java` | `` |  | setStep, inBounds, safeMin, safeMax |
| top-level / `com/mr_toad/lib/api/config/entry/primitive/NumericEntry.java` | `` |  | setValue, makeFatal, range, setStep, checkBounds, getMax, getMin, getStep |
| top-level / `com/mr_toad/lib/api/config/entry/primitive/ShortEntry.java` | `` |  | setStep, inBounds, safeMin, safeMax |
| top-level / `com/mr_toad/lib/api/config/entry/primitive/StringEntry.java` | `` |  | addFilter, setMaxLength, setProvider, getProvider, getFilter, getMaxLength |
| top-level / `com/mr_toad/lib/api/config/entry/type/ConfigEntryType.java` | `` |  | equals, toString |
| top-level / `com/mr_toad/lib/api/config/entry/type/ConfigEntryTypes.java` | `` |  | registerType, byName |
| top-level / `com/mr_toad/lib/api/config/error/ConfigException.java` | `` |  |  |
| top-level / `com/mr_toad/lib/api/config/io/JSON5IO.java` | `` |  | load, save |
| top-level / `com/mr_toad/lib/api/config/io/LegacyJSONIO.java` | `` |  | load, save |
| top-level / `com/mr_toad/lib/api/config/ToadConfig.java` | `` |  | load, save, register, getEntryByID, indexOf, title, getConfig, tryGetConfigPath, shouldCreateScreen, getOwner |
| top-level / `com/mr_toad/lib/api/config/ToadConfigs.java` | `` |  | create, byId, getConfigs |
| top-level / `com/mr_toad/lib/api/config/util/ConfigPage.java` | `` |  | get, isDefault, drawInScreen, getDescription, dontDrawInScreen, setValue, resetValue, save, load, getTitle, equals |
| top-level / `com/mr_toad/lib/api/config/util/DeprecationRule.java` | `` |  | make, make, make, make, addTooltip, addDisplayValue, hasDisplayValue, isActive, getTooltip, getDisplayValue |
| top-level / `com/mr_toad/lib/api/config/util/PageSeparateLine.java` | `` |  | getFormatted |
| top-level / `com/mr_toad/lib/api/config/util/TooltipSuffix.java` | `` |  |  |
| top-level / `com/mr_toad/lib/api/config/util/TooltipSuffixV2.java` | `` |  | tooltip |
| top-level / `com/mr_toad/lib/api/entity/ai/goal/BlowUpGoal.java` | `` |  | canUse, start, stop, tick, canContinueToUse, canExplode, getSwelling, saveBlowUpData, loadBlowUpData, explode |
| top-level / `com/mr_toad/lib/api/entity/ai/goal/CopyOwnerTrackTargetGoal.java` | `` |  | canUse, start |
| top-level / `com/mr_toad/lib/api/entity/ai/goal/MobFollowAdultMobGoal.java` | `` |  | canUse, canContinueToUse, start, stop, tick, getParentList |
| top-level / `com/mr_toad/lib/api/entity/entitydata/BlowUpDataContainer.java` | `` |  |  |
| top-level / `com/mr_toad/lib/api/entity/entitydata/EntityDataContainer.java` | `` |  |  |
| top-level / `com/mr_toad/lib/api/entity/entitydata/HybridAttackDataContainer.java` | `` |  |  |
| top-level / `com/mr_toad/lib/api/entity/entitydata/ToadlyEntityDataSerializers.java` | `` |  | encode, encode, encode |
| top-level / `com/mr_toad/lib/api/entity/HybridAttackType.java` | `` |  | byName, getId, getSerializedName |
| top-level / `com/mr_toad/lib/api/entity/type/Add2HorseTypes.java` | `` |  | register, register |
| top-level / `com/mr_toad/lib/api/entity/type/Add2ParrotTypes.java` | `` |  | register, register, values |
| top-level / `com/mr_toad/lib/api/entity/type/Add2RabbitTypes.java` | `` |  | register, register |
| top-level / `com/mr_toad/lib/api/entity/type/records/Add2HorseTypesRecord.java` | `` |  | Add2HorseTypesRecord |
| top-level / `com/mr_toad/lib/api/entity/type/records/Add2ParrotTypesRecord.java` | `` |  | Add2ParrotTypesRecord |
| top-level / `com/mr_toad/lib/api/entity/type/records/Add2RabbitTypesRecord.java` | `` |  | Add2RabbitTypesRecord |
| top-level / `com/mr_toad/lib/api/entity/type/TypeSets.java` | `` |  |  |
| top-level / `com/mr_toad/lib/api/helper/BehaviorHelper.java` | `` |  | isWithinDistance, tickConditionsInvolved, tickConditionsInvolved, throwQuarterStack, throwHalfStack, throwCounted |
| top-level / `com/mr_toad/lib/api/helper/registry/BigIdRegistry.java` | `` |  | registry, regName, defaultValue, destroyRegistry, declareDefault, declareDefault, register, register, register, register, nextValidId, getDefault, getDefaultId, equals, hashCode, toString |
| top-level / `com/mr_toad/lib/api/helper/registry/common/IdRegistry.java` | `` |  |  |
| top-level / `com/mr_toad/lib/api/helper/registry/common/RegistryMemberException.java` | `` |  |  |
| top-level / `com/mr_toad/lib/api/helper/registry/common/ToadRegistry.java` | `` |  |  |
| top-level / `com/mr_toad/lib/api/helper/registry/common/ValueHolder.java` | `` |  | stream, get, compareTo, equals, hashCode, toString |
| top-level / `com/mr_toad/lib/api/helper/registry/NameableRegistry.java` | `` |  | registry, destroyRegistry, declareDefault, register, getOrDefault, getOrThrow, getName, getName, keys, replace, replace, getDefaultName, getDefault, equals, hashCode, toString |
| top-level / `com/mr_toad/lib/api/helper/registry/SmallIdRegistry.java` | `` |  | registry, regName, defaultValue, destroyRegistry, declareDefault, declareDefault, register, register, register, register, getDefaultId, nextId, equals, hashCode, toString |
| top-level / `com/mr_toad/lib/api/helper/registry/ToadlyRegistry.java` | `` |  | registerSerializer |
| top-level / `com/mr_toad/lib/api/integration/Integration.java` | `` |  | isLoaded, getAssets, getData, findLocation, tryGetToadConfig |
| top-level / `com/mr_toad/lib/api/util/CapeableMobListener.java` | `` |  | capeTick, getDCapeX, getDCapeY, getDCapeZ, mapTickPCP, mapCPMod |
| top-level / `com/mr_toad/lib/api/util/damagesources/DamageSourceWithRandomMessage.java` | `` |  | getMessagesCount |
| top-level / `com/mr_toad/lib/api/util/LoadablePersistentState.java` | `` |  |  |
| top-level / `com/mr_toad/lib/api/util/serialization/BsonOps.java` | `` |  | empty, emptyList, emptyMap, convertTo, getNumberValue, createNumeric, getBooleanValue, createBoolean, getStringValue, createString, mergeToList, mergeToMap, getMapValues, createMap, getStream, createList, remove, getByteBuffer, createByteList, compressMaps, toString, copyArray, decimalOrDouble, keyToString, numberToString |
| top-level / `com/mr_toad/lib/api/util/serialization/db/AbstractDatabaseInstance.java` | `` |  | initialValue, perTickCheckedSave, save, save, load, setValue, getValue, getFullPath, markDirty, isDirty |
| top-level / `com/mr_toad/lib/api/util/serialization/db/CodecBasedDatabaseInstance.java` | `` |  | bson, bson, nbt, nbt, json5, json5, json5, json5, json, json, json, json, suffix, saveInternal, loadInternal |
| top-level / `com/mr_toad/lib/api/util/serialization/db/KryoDatabaseInstance.java` | `` |  | create, create, suffix, saveInternal, loadInternal |
| top-level / `com/mr_toad/lib/api/util/serialization/db/ToadLibDatabases.java` | `` |  | registerOnWorldLoad, registerOnGameLoad, processEvents |
| top-level / `com/mr_toad/lib/api/util/serialization/Json5Ops.java` | `` |  | empty, convertTo, getNumberValue, createNumeric, getBooleanValue, createBoolean, getStringValue, createString, mergeToList, mergeToMap, getMapValues, createMap, getStream, createList, remove, compressMaps, toString |
| top-level / `com/mr_toad/lib/api/util/serialization/ToadExtraCodecs.java` | `` |  | ints, floats, doubles, intsStream, floatsStream, doublesStream, streamSized, sized |
| top-level / `com/mr_toad/lib/api/util/SpawnerHolder.java` | `` |  | SpawnerHolder |
| top-level / `com/mr_toad/lib/api/util/SpawnLingeringCloudData.java` | `` |  | SpawnLingeringCloudData, withDefaultRadiusPerTick, spawn, spawn |
| top-level / `com/mr_toad/lib/api/util/ToadEntityUtils.java` | `` |  | addParrotImitation, isHero, villagerCraftItem |
| top-level / `com/mr_toad/lib/api/util/ToadResourceUtils.java` | `` |  | pathOf, isURL, readLines, readLines, readLines, readLines |
| top-level / `com/mr_toad/lib/core/config/ToadLibConfig.java` | `` |  | title |
| top-level / `com/mr_toad/lib/core/data/tag/ToadlyTags.java` | `` |  |  |
| top-level / `com/mr_toad/lib/core/mixin/EntityMixin.java` | `value={Entity.class})` | Inject:1 | tl$tick |
| top-level / `com/mr_toad/lib/core/mixin/LivingEntityMixin.java` | `value={LivingEntity.class})` | WrapOperation:6, WrapMethod:2 | tl$effectExpired, tl$dropEvent, tl$dropXPEvent, tl$fall, tl$heal, tl$trackSource, tl$canBeAffected, tl$effectRemove |
| top-level / `com/mr_toad/lib/core/mixin/NameTagItemMixin.java` | `value={NameTagItem.class})` | Inject:1 | interactNonNameable |
| top-level / `com/mr_toad/lib/core/mixin/ScreenMixin.java` | `value={Screen.class})` | Inject:1 | closeWidgets |
| top-level / `com/mr_toad/lib/core/mixin/TooltipMixin.java` | `value={Tooltip.class})` | Inject:1 | splitWithToadLib |
| top-level / `com/mr_toad/lib/core/resource/ConfigReloadListener.java` | `` |  | apply |
| top-level / `com/mr_toad/lib/event/custom/ToadlyEntityEvents.java` | `` |  | getHeal, setHeal, setDistance, setMultiplier, getDistance, getMultiplier |
| top-level / `com/mr_toad/lib/fabric/ToadLib.java` | `` |  | onInitialize |
| top-level / `com/mr_toad/lib/fabric/ToadLibClient.java` | `` |  | onInitializeClient |
| top-level / `com/mr_toad/lib/fabric/ToadLibModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/mr_toad/lib/mtjava/bytes/func/ByteFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/bytes/func/ByteSupplier.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/bytes/func/ToByteFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/bytes/OptionalByte.java` | `` |  | empty, of, getAsByte, isPresent, isEmpty, ifPresent, ifPresentOrElse, stream, orElse, orElseGet, orElseThrow, orElseThrow, equals, hashCode, toString |
| top-level / `com/mr_toad/lib/mtjava/chars/func/Char2CharFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/chars/func/Char2StringFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/chars/func/CharFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/chars/func/CharSupplier.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/chars/func/ToCharFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/chars/OptionalChar.java` | `` |  | empty, of, getAsChar, isPresent, isEmpty, ifPresent, ifPresentOrElse, orElse, orElseGet, orElseThrow, orElseThrow, stream, mapToString, map, map, equals, hashCode, toString |
| top-level / `com/mr_toad/lib/mtjava/collections/execute/ExecutableArrayList.java` | `` |  | run |
| top-level / `com/mr_toad/lib/mtjava/collections/execute/ExecutableHashSet.java` | `` |  | run |
| top-level / `com/mr_toad/lib/mtjava/collections/ImmutableArrayList.java` | `` |  | size, isEmpty, contains, iterator, containsAll, get, indexOf, lastIndexOf, addAll, addAll, removeAll, retainAll, clear, add, remove, set, add, remove, listIterator, listIterator, subList |
| top-level / `com/mr_toad/lib/mtjava/collections/RandomizedList.java` | `` |  | getRandom, removeRandom |
| top-level / `com/mr_toad/lib/mtjava/collections/SimpleArrayDeque.java` | `` |  | popPush, pollAll |
| top-level / `com/mr_toad/lib/mtjava/collections/UniqueList.java` | `` |  | add, addAll |
| top-level / `com/mr_toad/lib/mtjava/collections/UniqueRandomizedList.java` | `` |  | add, addAll |
| top-level / `com/mr_toad/lib/mtjava/concurrent/AtomicByte.java` | `` |  | intValue, longValue, floatValue, doubleValue, get, set, getVolatile, lazySet, getAndSet, compareAndSet, compareAndExchange, getAndAdd, addAndGet, getAndIncrement, getAndDecrement, incrementAndGet, decrementAndGet, getAndUpdate, updateAndGet, getAndAccumulate, accumulateAndGet |
| top-level / `com/mr_toad/lib/mtjava/concurrent/AtomicByteArray.java` | `` |  | get, getAndSet, set, lazySet, get, set, compareAndSet, weakCompareAndSetPlain, getAndAdd, addAndGet, getAndIncrement, getAndDecrement, incrementAndGet, decrementAndGet, length, getAndUpdate, updateAndGet, getAndAccumulate, accumulateAndGet, toString, getPlain, setPlain, getOpaque, setOpaque, getAcquire, setRelease, compareAndExchange, compareAndExchangeAcquire, compareAndExchangeRelease, weakCompareAndSetVolatile, weakCompareAndSetAcquire, weakCompareAndSetRelease |
| top-level / `com/mr_toad/lib/mtjava/concurrent/AtomicFloat.java` | `` |  | get, set, lazySet, getAndSet, compareAndSet, weakCompareAndSet, getAndAdd, addAndGet, getAndAccumulate, accumulateAndGet, getAndUpdate, updateAndGet, toString, intValue, longValue, doubleValue, floatValue, writeObject, readObject |
| top-level / `com/mr_toad/lib/mtjava/concurrent/AtomicFloatArray.java` | `` |  | length, get, set, lazySet, getAndSet, compareAndSet, getAndAdd, addAndGet, getAndAccumulate, accumulateAndGet, getAndUpdate, updateAndGet, toString, writeObject, readObject |
| top-level / `com/mr_toad/lib/mtjava/concurrent/Concurrents.java` | `` |  | uncaught, shutdownService, shutdownService |
| top-level / `com/mr_toad/lib/mtjava/concurrent/LazyCompletableFuture.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/doubles/func/DoubleBiFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/floats/func/FloatBiConsumer.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/floats/func/FloatBiFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/floats/func/FloatFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/floats/func/FloatSupplier.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/floats/func/FloatTriConsumer.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/floats/func/ToFloatBiFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/floats/func/ToFloatFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/floats/OptionalFloat.java` | `` |  | empty, of, getAsFloat, isPresent, isEmpty, ifPresent, ifPresentOrElse, orElse, orElseGet, orElseThrow, orElseThrow, stream, map, map, map, equals, hashCode, toString |
| top-level / `com/mr_toad/lib/mtjava/ints/func/IntBiConsumer.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/ints/func/IntBiFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/io/PathInputStream.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/io/PathOutputStream.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/keyframe/Keyframe.java` | `` |  | Keyframe |
| top-level / `com/mr_toad/lib/mtjava/keyframe/KeyframeChannel.java` | `` |  | getValue, start, stop, tick, add, remove, markDirty, advance, isRunning, getDuration, getCurrentTime, getStartTime, getKeyframes |
| top-level / `com/mr_toad/lib/mtjava/keyframe/KeyframeConverter.java` | `` |  | interpolatef, interpolate, interpolatef, interpolate, interpolatef, interpolate, interpolate, interpolatef, interpolate |
| top-level / `com/mr_toad/lib/mtjava/keyframe/ZeroKeyframeChannel.java` | `` |  | start, stop, tick, add, remove, markDirty, advance, getCurrentTime, getStartTime, getValue, getDuration |
| top-level / `com/mr_toad/lib/mtjava/math/geo/Axis.java` | `` |  | byVanilla, getSerializedName, get, get, directionf, directiond, counterclockwiseDeg, counterclockwiseDeg, clockwiseDeg, clockwiseDeg, counterclockwise, counterclockwise, clockwise, clockwise, get, get, get, get, get, get, get, get, getPlane, vanilla, set, set, set, getMoj3I, isVertical, isHorizontal |
| top-level / `com/mr_toad/lib/mtjava/math/geo/OBB.java` | `` |  | moveCenter, moveCenter, deflate, deflate, inflate, inflate, scale, intersects, intersects, overlapOnAxis, overlapOnAxis, getProjectedRadius, getProjectedRadius, getVertices, getVertices, normalizeOrThrow, normalizeIfNotZero, equals, hashCode, toString |
| top-level / `com/mr_toad/lib/mtjava/math/interpolation/HermiteInterpolation.java` | `` |  | interpolate, name, codec, getTension, getBias, setTension, setBias, getValue, getSerializedName, symbol |
| top-level / `com/mr_toad/lib/mtjava/math/interpolation/Interpolation.java` | `` |  | of, interpolate, name, codec |
| top-level / `com/mr_toad/lib/mtjava/math/interpolation/InterpolationContext.java` | `` |  | InterpolationContext, lerp, invLerp, lerp, map, pow |
| top-level / `com/mr_toad/lib/mtjava/math/interpolation/Interpolations.java` | `` |  | bounce |
| top-level / `com/mr_toad/lib/mtjava/math/MtMath.java` | `` |  | pow, exp, tan, cot, sqrt, cbrt, sin, cos, tan, cot, cot, acos, asin, bfloor, sfloor, clamp, min, max, clamp, min, max, sign, hypot, trunc, average, average, average, length, length, length, lengthSquared, lengthSquared, lengthSquared, length, length, length, lengthSquared, lengthSquared, lengthSquared, length, length, length, lengthSquared, lengthSquared, lengthSquared, fact, isNanOrInfinite, isInfinite, isNan, ceil, ceil, floor, floor, round, round, mapValuesVec, mapValuesVec, getCenter, getCenter |
| top-level / `com/mr_toad/lib/mtjava/math/vec/base/DoubleVec.java` | `` |  | fromList |
| top-level / `com/mr_toad/lib/mtjava/math/vec/base/FloatVec.java` | `` |  | fromList |
| top-level / `com/mr_toad/lib/mtjava/math/vec/base/IntVec.java` | `` |  | fromList |
| top-level / `com/mr_toad/lib/mtjava/math/vec/Vec0d.java` | `` |  | get, set, set, set, add, sub, div, mul, scale, min, max, abs, cross, values, length, lengthSqr, dist, distSqr, dot, zero, create |
| top-level / `com/mr_toad/lib/mtjava/math/vec/Vec0f.java` | `` |  | get, set, set, set, add, sub, mul, div, scale, min, max, abs, cross, values, length, lengthSqr, dist, distSqr, dot, zero, create |
| top-level / `com/mr_toad/lib/mtjava/math/vec/Vec0i.java` | `` |  | get, set, set, set, add, sub, mul, div, scale, min, max, abs, cross, values, length, lengthSqr, dist, distSqr, dot, zero, create |
| top-level / `com/mr_toad/lib/mtjava/math/vec/Vec1d.java` | `` |  | x, setX, set, set, set, add, sub, mul, div, scale, min, max, abs, cross, values, length, lengthSqr, dist, distSqr, dot, zero, create, equals, hashCode, toString |
| top-level / `com/mr_toad/lib/mtjava/math/vec/Vec1f.java` | `` |  | x, setX, set, set, set, add, sub, mul, div, scale, min, max, abs, cross, values, length, lengthSqr, dist, distSqr, dot, zero, create, equals, hashCode, toString |
| top-level / `com/mr_toad/lib/mtjava/math/vec/Vec1i.java` | `` |  | x, setX, set, set, set, add, sub, mul, div, scale, min, max, abs, cross, values, length, lengthSqr, dist, distSqr, dot, zero, create, equals, hashCode, toString |
| top-level / `com/mr_toad/lib/mtjava/math/vec/Vec2d.java` | `` |  | x, y, setX, setY, set, set, set, set, add, sub, mul, div, scale, min, max, abs, cross, values, length, lengthSqr, dist, distSqr, dot, zero, create, equals, hashCode, toString, joml |
| top-level / `com/mr_toad/lib/mtjava/math/vec/Vec2f.java` | `` |  | scale, scale, x, y, setX, setY, set, set, set, set, add, sub, mul, div, scale, min, max, abs, cross, values, length, lengthSqr, dist, distSqr, dot, zero, create, equals, hashCode, toString, joml |
| top-level / `com/mr_toad/lib/mtjava/math/vec/Vec2i.java` | `` |  | x, y, setX, setY, setXY, set, set, set, add, sub, mul, div, scale, min, max, abs, cross, values, length, lengthSqr, dist, distSqr, dot, zero, create, equals, hashCode, toString, joml, minecraft |
| top-level / `com/mr_toad/lib/mtjava/math/vec/Vec3d.java` | `` |  | x, y, z, setX, setY, setZ, set, set, set, set, add, sub, mul, div, scale, min, max, abs, cross, values, length, lengthSqr, dist, distSqr, dot, zero, create, equals, hashCode, toString, add, rotate, rotateX, rotateY, rotateZ, mul, mul, mul, orthogonal, joml, minecraft |
| top-level / `com/mr_toad/lib/mtjava/math/vec/Vec3f.java` | `` |  | scale, scale, x, y, z, setX, setY, setZ, set, set, set, set, add, sub, mul, div, scale, min, max, abs, cross, values, length, lengthSqr, dist, distSqr, dot, zero, create, equals, hashCode, toString, add, rotate, rotateX, rotateY, rotateZ, mul, mul, mul, orthogonal, joml, minecraft, blockPos |
| top-level / `com/mr_toad/lib/mtjava/math/vec/Vec3i.java` | `` |  | x, y, z, setX, setY, setZ, set, set, set, set, add, sub, mul, div, scale, min, max, abs, cross, values, length, lengthSqr, dist, distSqr, dot, zero, create, equals, hashCode, toString, joml, minecraft, blockPos |
| top-level / `com/mr_toad/lib/mtjava/math/vec/Vec4d.java` | `` |  | x, y, z, w, setX, setY, setZ, setW, set, set, set, set, add, sub, mul, div, scale, min, max, abs, cross, values, length, lengthSqr, dist, distSqr, dot, zero, create, equals, hashCode, toString, mul, mul, mul, mulTranspose, mulAffine, mulGeneric, mulAffineTranspose, mulGenericTranspose, joml |
| top-level / `com/mr_toad/lib/mtjava/math/vec/Vec4f.java` | `` |  | x, y, z, w, setX, setY, setZ, setW, set, set, set, set, add, sub, mul, div, scale, min, max, abs, cross, values, length, lengthSqr, dist, distSqr, dot, zero, create, equals, hashCode, toString, mul, mul, mul, mulTranspose, mulAffine, mulGeneric, mulAffineTranspose, mulGenericTranspose, joml |
| top-level / `com/mr_toad/lib/mtjava/math/vec/Vec4i.java` | `` |  | x, y, z, w, setX, setY, setZ, setW, set, set, set, set, add, sub, mul, div, scale, min, max, abs, cross, values, length, lengthSqr, dist, distSqr, dot, zero, create, equals, hashCode, toString, joml, color |
| top-level / `com/mr_toad/lib/mtjava/MtJava.java` | `` |  | toImmutablePair, percents, percents, degrees, degrees, timestamp, rgb2Argb, rgb2Hex |
| top-level / `com/mr_toad/lib/mtjava/nio/MTNIO.java` | `` |  | putId, putString, readString, readString, readString, move |
| top-level / `com/mr_toad/lib/mtjava/shorts/func/ShortFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/shorts/func/ShortSupplier.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/shorts/func/ToShortFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/strings/func/String2CharFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/strings/func/String2StringFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/strings/func/String2TextFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/strings/func/StringConsumer.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/strings/func/StringFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/strings/func/StringPredicate.java` | `` |  | startOrEndsWith |
| top-level / `com/mr_toad/lib/mtjava/strings/func/StringSupplier.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/strings/func/ToStringFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/strings/OptionalString.java` | `` |  | empty, of, ofNullable, getAsString, isPresent, isEmpty, ifPresent, ifPresentOrElse, orElse, orElseGet, orElseThrow, orElseThrow, stream, mapToChar, map, map, equals, hashCode, toString |
| top-level / `com/mr_toad/lib/mtjava/strings/StringPair.java` | `` |  | of |
| top-level / `com/mr_toad/lib/mtjava/timer/SimpleTimer.java` | `` |  | startIfStopped, stopIfStarted, start, tick, tick, activeTick, inactiveTick, stop, toggle, setRunning, onToggle, getDuration, getRemainingTime, getTime, isRunning |
| top-level / `com/mr_toad/lib/mtjava/timer/SystemTimer.java` | `` |  | start, start, stop, getElapsedTime, assertStarted, isStarted |
| top-level / `com/mr_toad/lib/mtjava/util/BiPredicates.java` | `` |  | alwaysTrue, alwaysFalse, isNullBoth, isNullOne, nonNullBoth, nonNullOne, test, test, test, test, test, test, withNarrowedType |
| top-level / `com/mr_toad/lib/mtjava/util/func/SelfFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/util/func/TriFunction.java` | `` |  |  |
| top-level / `com/mr_toad/lib/mtjava/util/ImmutablePair.java` | `` |  | of, mapFirst, mapSecond |
| top-level / `com/mr_toad/lib/mtjava/util/OptionalPair.java` | `` |  | empty, of, ofNullable, getFirst, getSecond, mapFirst, mapSecond, mapAll, firstIsPresent, secondIsPresent, firstIsEmpty, secondIsEmpty, allIsPresent, allIsEmpty, firstIfPresent, secondIfPresent, allIfPresent, ifPresentOrElse, filter, streamFirst, streamSecond, or, inverse, firstOrElse, secondOrElse, firstOrElseGet, secondOrElseGet, orElseThrow, toMap, hashCode, toString |
| top-level / `com/mr_toad/lib/mtjava/util/quad/primitive/ByteQuadruplet.java` | `` |  | of, mapByteFirst, mapByteSecond, mapByteThird, mapByteFourth, convertToInt |
| top-level / `com/mr_toad/lib/mtjava/util/quad/primitive/DoubleQuadruplet.java` | `` |  | of, mapDoubleFirst, mapDoubleSecond, mapDoubleThird, mapDoubleFourth, convertToDouble |
| top-level / `com/mr_toad/lib/mtjava/util/quad/primitive/FloatQuadruplet.java` | `` |  | of, mapFloatFirst, mapFloatSecond, mapFloatThird, mapFloatFourth, convertToDouble |
| top-level / `com/mr_toad/lib/mtjava/util/quad/primitive/IntQuadruplet.java` | `` |  | of, mapIntFirst, mapIntSecond, mapIntThird, mapIntFourth, convertToByte |
| top-level / `com/mr_toad/lib/mtjava/util/quad/primitive/LongQuadruplet.java` | `` |  | of, mapLongFirst, mapLongSecond, mapLongThird, mapLongFourth |
| top-level / `com/mr_toad/lib/mtjava/util/quad/Quadruplet.java` | `` |  | of, getFirst, getSecond, getThird, getFourth, swapFS, swapFT, swapFFR, swapSFR, swapTFR, mapFirst, mapSecond, mapThird, mapFourth, toString, equals, hashCode |
| top-level / `com/mr_toad/lib/mtjava/util/quad/Quadruplets.java` | `` |  | convertTripletToQuadruplet, mapAll |
| top-level / `com/mr_toad/lib/mtjava/util/SimpleARGB.java` | `` |  | getAsInt, set, set, set, set, set, lerp, lerp, setA, setR, setG, setB, setA, setR, setG, setB, alphaFactor, redFactor, greenFactor, blueFactor, alpha, red, green, blue, getColor, getPercent, argb, rgba, compareTo, equals, hashCode, toString |
| top-level / `com/mr_toad/lib/mtjava/util/tri/primitive/ByteTriplet.java` | `` |  | of, mapByteFirst, mapByteSecond, mapByteThird, convertToInt |
| top-level / `com/mr_toad/lib/mtjava/util/tri/primitive/DoubleTriplet.java` | `` |  | of, mapDoubleFirst, mapDoubleSecond, mapDoubleThird, convertToDouble |
| top-level / `com/mr_toad/lib/mtjava/util/tri/primitive/FloatTriplet.java` | `` |  | of, mapFloatFirst, mapFloatSecond, mapFloatThird, convertToDouble |
| top-level / `com/mr_toad/lib/mtjava/util/tri/primitive/IntTriplet.java` | `` |  | of, mapIntFirst, mapIntSecond, mapIntThird, convertToByte |
| top-level / `com/mr_toad/lib/mtjava/util/tri/primitive/LongTriplet.java` | `` |  | of, mapLongFirst, mapLongSecond, mapLongThird |
| top-level / `com/mr_toad/lib/mtjava/util/tri/Triplet.java` | `` |  | of, getFirst, getSecond, getThird, swapFS, swapFT, swapST, mapFirst, mapSecond, mapThird, toTable, toString, equals, hashCode |
| top-level / `com/mr_toad/lib/ToadLibCommon.java` | `` |  | init |

## Data-driven behavior

Resource category counts: `tags`: 6.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
