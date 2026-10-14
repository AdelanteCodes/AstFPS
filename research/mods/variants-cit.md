# Variants-CIT

Review status: **Evidence inventory; behavioral review pending**

Project: [Variants-CIT](https://modrinth.com/mod/variants-cit)
Selected artifact version: `5.7.1+26.3`
Published implementation source: https://github.com/Estecka/mc-Variants-CIT
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Alternative CIT format for large collections of variants with repeating patterns.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `7ebca7b7b145fb4ee665402a667b38027df14362`
- `sha512`: `816e5e5e7e5db6185e91634ee27f61815210fc13a78ab3c3913ca8527378329e9d2226b453e9ff9072ea7383410ba8c0f7d2f99e7a5acc1e071d1294cdb80874`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 195
Reconstructed Java files: 138

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "fr.estecka.variantscit.VariantsCitMod"
  ]
}
```

**depends**

```json
{
  "minecraft": "^26.3",
  "fabricloader": ">=0.18.4",
  "fabric-api": ">=0.119.4",
  "java": ">=25"
}
```

**accessWidener**

```json
"variants-cit.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `fr/estecka/variantscit/assetgen/EAssetGenPass.java` | `` |  | GetShortInputId, GetOutputResourceId, getSerializedName, toString |
| top-level / `fr/estecka/variantscit/assetgen/FilledTemplate.java` | `` |  | getString, get, ModelParent, Stateless, IdVariables, Backfilled, Frontfilled |
| top-level / `fr/estecka/variantscit/assetgen/GeneratedResourcePack.java` | `` |  | openMetadata, openResources, Reset, GetAll, location, getMetadataSection, GetIcon, listResources, getNamespaces, close |
| top-level / `fr/estecka/variantscit/assetgen/GeneratorPresets.java` | `` |  | ReloadPresets, LegacyGenerator |
| top-level / `fr/estecka/variantscit/assetgen/HotswappableResourceManager.java` | `` |  | Get, Refresh |
| top-level / `fr/estecka/variantscit/assetgen/IAssetGenerator.java` | `` |  | PutAllIfAbsent, ParentedResource, AcceptAsset, Of, Wrap, Unwrap |
| top-level / `fr/estecka/variantscit/assetgen/TemplatedAssetGenerator.java` | `` |  | AcceptAsset, SubstitutePath |
| top-level / `fr/estecka/variantscit/assetgen/TemplateRepository.java` | `` |  | Get, ReloadPatterns, CreateTemplate |
| top-level / `fr/estecka/variantscit/commands/AssetGenCommands.java` | `` |  | Register, RegisterWith, AssetAutofill, AssetPeek, CreatePack, visitFile |
| top-level / `fr/estecka/variantscit/commands/BufferedCommandLogger.java` | `` |  | Info, Error, IsEmpty, Flush, LogEntry |
| top-level / `fr/estecka/variantscit/commands/CommandLogger.java` | `` |  | TextOf, TextFormat, TextFormat, Info, Info, Info, Info, Error, Error, Error, Error, ItemData, ItemData, PackData |
| top-level / `fr/estecka/variantscit/commands/CommandUtil.java` | `` |  | Error, Info, Success, GetOptionalArgument |
| top-level / `fr/estecka/variantscit/commands/IClientEntitySelector.java` | `` |  | AllEntities, GetNearest, GetSelf, GetGroundItem, GetPlayer, GetEntity |
| top-level / `fr/estecka/variantscit/commands/ModuleCommands.java` | `` |  | Register, RegisterWith, GetMeta, GetLibrary, GetBaked, ModuleAutofill, VariantIdAutofill, ModelIdAutofill, Walkthrough, Dump, Summary, VariantId, ModelId, Walkthrough |
| top-level / `fr/estecka/variantscit/commands/ModuleHookArgumentType.java` | `` |  | moduleHook, getModuleHook, listSuggestions, parse |
| top-level / `fr/estecka/variantscit/commands/ModuleTreeCommands.java` | `` |  | Register, RegisterWith, ItemAutofill, PrintTree, TreeNodeOf, TreeNodeOf, ModuleName, Crawl, PrintRoot, PrintNode, NewLine, toString |
| top-level / `fr/estecka/variantscit/commands/WalktroughLogger.java` | `` |  | moduleHook, metamodule, subPrefix, WithSubPrefix, AssetFilename, LayeredAssetFilename, PrintPlainModelTip, PrintVariantIdTip, PrintFileNamesTip |
| top-level / `fr/estecka/variantscit/format/Substitution.java` | `` |  | Substitute, toString, Matches, MatchWarning, Parse, NextLiteral, NextVariable, ValidateVarname, IsVarnameValid, Substitute, toString, Substitute, toString |
| top-level / `fr/estecka/variantscit/hooks/EquippableCache.java` | `` |  | Clear, GetWithAssetId, CopyWithAssetId, GetEquipableVariant |
| top-level / `fr/estecka/variantscit/hooks/MixinGlobals.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/hooks/TrimPatternOverlay.java` | `` |  | TrimPatternOverlay |
| top-level / `fr/estecka/variantscit/itemdata/containers/ComponentContainer.java` | `` |  | OfNullable, asNbt, toText, toString |
| top-level / `fr/estecka/variantscit/itemdata/containers/IDataContainer.java` | `` |  | NullableAsString, printableValue |
| top-level / `fr/estecka/variantscit/itemdata/containers/RawDataContainer.java` | `` |  | OfNullable, toText, toString |
| top-level / `fr/estecka/variantscit/itemdata/extractors/IDataExtractor.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/itemdata/extractors/impl/AMonoComponentProperty.java` | `` |  | Extract, GetCacheKey |
| top-level / `fr/estecka/variantscit/itemdata/extractors/impl/AxolotlVariantProperty.java` | `` |  | GetPropertyValue |
| top-level / `fr/estecka/variantscit/itemdata/extractors/impl/DisplayNameProperty.java` | `` |  | GetCacheKey, GetReference, Extract, toString |
| top-level / `fr/estecka/variantscit/itemdata/extractors/impl/DyedColorProperty.java` | `` |  | GetPropertyValue |
| top-level / `fr/estecka/variantscit/itemdata/extractors/impl/EntityAgeMapProperty.java` | `` |  | GetPropertyValue |
| top-level / `fr/estecka/variantscit/itemdata/extractors/impl/ItemComponentProperty.java` | `` |  | GetCacheKey, Extract, MonostringParse |
| top-level / `fr/estecka/variantscit/itemdata/extractors/impl/ItemCountProperty.java` | `` |  | GetPropertyHash, GetReference, GetCacheKey, Extract, toString |
| top-level / `fr/estecka/variantscit/itemdata/extractors/impl/ItemTypeProperty.java` | `` |  | GetReference, GetCacheKey, Extract, toString |
| top-level / `fr/estecka/variantscit/itemdata/extractors/impl/PaintingVariantProperty.java` | `` |  | GetPropertyValue, GetPropertyId |
| top-level / `fr/estecka/variantscit/itemdata/extractors/TransformableExtractor.java` | `` |  | CodecOf, GetCacheKey, Extract, Unwrap |
| top-level / `fr/estecka/variantscit/itemdata/nbtpath/ArrayIndexToken.java` | `` |  | Resolve, toString, ParseNext |
| top-level / `fr/estecka/variantscit/itemdata/nbtpath/MapIndexToken.java` | `` |  | Resolve, ParseNext, toString |
| top-level / `fr/estecka/variantscit/itemdata/nbtpath/MapKeyToken.java` | `` |  | Resolve, toString, ParseNext, IsCharValid |
| top-level / `fr/estecka/variantscit/itemdata/nbtpath/NbtPath.java` | `` |  | Resolve, LooseTypedTransform, DotSeparatedPath, Parse, toString |
| top-level / `fr/estecka/variantscit/itemdata/nbtpath/Parsed.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/itemdata/nbtpath/Token.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/itemdata/preconditions/ConditionList.java` | `` |  | TypedCodec, Wrap, Unwrap, Matches, GetCacheKeys |
| top-level / `fr/estecka/variantscit/itemdata/preconditions/IItemPrecondition.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/itemdata/preconditions/MonostringConditionBuilder.java` | `` |  | ParseMap, ParseEntry |
| top-level / `fr/estecka/variantscit/itemdata/preconditions/NegativeCondition.java` | `` |  | CodecOf, Wrap, Matches, GetCacheKeys |
| top-level / `fr/estecka/variantscit/itemdata/transforms/DataConversions.java` | `` |  | StricIdentifier, StricIdentifier, StrictString, StrictNumber, StrictRichText, StrictRichTextArray, StrictNbt, StrictSnbt, AggressiveString, AggressiveNumber, SoftCastToString, SoftCastToId, SoftCastToNumber, SoftCastToNbt, SoftCastToText, NbtToText, NbtToTextArray, TextArrayToString |
| top-level / `fr/estecka/variantscit/itemdata/transforms/IDataTransform.java` | `` |  | Test |
| top-level / `fr/estecka/variantscit/itemdata/transforms/impl/AlternativeTransform.java` | `` |  | LooseTypedTransform, Wrap, Unwrap |
| top-level / `fr/estecka/variantscit/itemdata/transforms/impl/CharRemapTransform.java` | `` |  | apply, CharsetParams, FromMap |
| top-level / `fr/estecka/variantscit/itemdata/transforms/impl/FilterlistTransform.java` | `` |  | CreateMapCodec, NullSafeTransform |
| top-level / `fr/estecka/variantscit/itemdata/transforms/impl/ForeachTransform.java` | `` |  | LooseTypedTransform, CompoundEntry, ArrayEntry, StreamIndices, TransformIterator, ValuesIterator, KeysIterator, EntriesIterator, FirstMatch, MatchesAny, MatchesAll |
| top-level / `fr/estecka/variantscit/itemdata/transforms/impl/LogTransform.java` | `` |  | LooseTypedTransform, WithLogger |
| top-level / `fr/estecka/variantscit/itemdata/transforms/impl/MatchesTransform.java` | `` |  | TypedCodec, LooseTypedTransform |
| top-level / `fr/estecka/variantscit/itemdata/transforms/impl/NumberCompareTransform.java` | `` |  | CodecWithBias, LooseTypedTransform, Compare |
| top-level / `fr/estecka/variantscit/itemdata/transforms/impl/RegexTransform.java` | `` |  | apply, ApplyRegex, FirstMatchingLine |
| top-level / `fr/estecka/variantscit/itemdata/transforms/impl/RemapTransform.java` | `` |  | CreateCodec, NullSafeTransform |
| top-level / `fr/estecka/variantscit/itemdata/transforms/impl/StringCompareTransform.java` | `` |  | LooseTypedTransform |
| top-level / `fr/estecka/variantscit/itemdata/transforms/impl/TestTransform.java` | `` |  | LooseTypedTransform |
| top-level / `fr/estecka/variantscit/itemdata/transforms/impl/translate/LanguageRepository.java` | `` |  | Instance, Clear, SetResourceManager, GetLanguage, CreateLanguage |
| top-level / `fr/estecka/variantscit/itemdata/transforms/impl/translate/TranslateTransform.java` | `` |  | NullSafeTransform, Translate |
| top-level / `fr/estecka/variantscit/itemdata/transforms/IStringTransform.java` | `` |  | Sanitize, DiscardNamespace, DiscardPath, AutoSanitize |
| top-level / `fr/estecka/variantscit/itemdata/transforms/OptionalTransform.java` | `` |  | CodecOf, Wrap, Unwrap, IsOptional, GetFallback, LooseTypedTransform |
| top-level / `fr/estecka/variantscit/itemdata/transforms/SuccessiveTransform.java` | `` |  | Unwrap, Wrap, SubTransformList, LooseTypedTransform |
| top-level / `fr/estecka/variantscit/mixin/ClientWorldAccessor.java` | `value={ClientLevel.class})` | Invoker:1 |  |
| top-level / `fr/estecka/variantscit/mixin/EquipmentLayerRendererMixin.java` | `value={EquipmentLayerRenderer.class}); value={PalettedTextureManager.class}); value={EquipmentLayerRenderer.TrimTextureKey.class})` | Inject:1, WrapOperation:1, ModifyArg:1, ModifyExpressionValue:2 | getAtlas, GetTrimSprite, ComputeSprite, ChangePalettedCacheKey, fallbackPaletteKey, overrideTextureId |
| top-level / `fr/estecka/variantscit/mixin/FeatureRendererMixin.java` | `value={WolfArmorLayer.class}); value={SimpleEquipmentLayer.class}); value={LlamaDecorLayer.class}); value={WingsLayer.class}); value={CapeLayer.class}); value={HumanoidArmorLayer.class})` | WrapOperation:6 | GetVariantEquippable, GetVariantEquippable, GetVariantEquippable, GetVariantEquippable, GetVariantEquippable, GetVariantEquippable |
| top-level / `fr/estecka/variantscit/mixin/ItemModelManagerMixin.java` | `value={ItemModelResolver.class})` | WrapOperation:1 | GetVariantModel |
| top-level / `fr/estecka/variantscit/mixin/MinecraftClientMixin.java` | `value={Minecraft.class})` | ModifyArg:1 | AddAssetGenPack |
| top-level / `fr/estecka/variantscit/mixin/ReloadableResourceManagerImplMixin.java` | `value={ReloadableResourceManager.class})` | ModifyArg:1 | reload |
| top-level / `fr/estecka/variantscit/ModuleRepository.java` | `` |  | GetArchModule, GetModelForItem, GetAvailableItems, GetAvailableModules, GetId, GetMeta |
| top-level / `fr/estecka/variantscit/modules/cache/CacheBuilder.java` | `` |  | BuildAll, BuildItem, BuildPriorityGroup, CacheModules |
| top-level / `fr/estecka/variantscit/modules/cache/CacheKeySet.java` | `` |  | Of, Of, Of, OfCacheables, OfList, stream, iterator, isEmpty, MergedWith, CompareTo, equals, hashCode, Comparison, isEqual, isSuperset, isSuperOrEqual, isSubset, isSubsetOrEquam, isMismatch, Similarity |
| top-level / `fr/estecka/variantscit/modules/cache/CacheModule.java` | `` |  | size, Unwrap, GetCacheKeys, GetCachePolicy, Summary, Walkthrough, GetModelForItem, Crawl, ComputeIfAbsent, HashStack, CreateEntry, ExpungeExpiredEntries, CacheEntry |
| top-level / `fr/estecka/variantscit/modules/cache/ComponentCacheKey.java` | `` |  | KeysOf, KeysOf, Extract, GetReference, equals, hashCode, toString |
| top-level / `fr/estecka/variantscit/modules/cache/ECachePolicy.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/modules/cache/ICacheKey.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/modules/IBakedModule.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/modules/IModuleWrapper.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/modules/impl/AMonoComponentModule.java` | `` |  | GetCacheKeys, GetCachePolicy, GetItemModel |
| top-level / `fr/estecka/variantscit/modules/impl/ASimpleMonoComponentModule.java` | `` |  | Of, GetVariantForComponent, Of, GetModelForComponent |
| top-level / `fr/estecka/variantscit/modules/impl/AxolotlBucketModule.java` | `` |  | AcceptsVariant, Bake, Create, CreateAgedModule, CreateAgeInvariantModule |
| top-level / `fr/estecka/variantscit/modules/impl/ComponentDataModule.java` | `` |  | GetCacheKeys, GetCachePolicy, GetItemVariant, Walkthrough |
| top-level / `fr/estecka/variantscit/modules/impl/ComponentThresholdModule.java` | `` |  | GetCacheKeys, GetCachePolicy, GetItemModel, Walkthrough, GetComponentValue |
| top-level / `fr/estecka/variantscit/modules/impl/CustomNameModule.java` | `` |  | GetVariantForComponent |
| top-level / `fr/estecka/variantscit/modules/impl/DurabilityModule.java` | `` |  | GetCacheKeys, GetCachePolicy, GetItemModel |
| top-level / `fr/estecka/variantscit/modules/impl/EnchantmentModule.java` | `` |  | CreateCodec, GetModelForComponent, MatchesPrecondition, GetBestEnchant, CompareEnchants, GetEnchantModel, HasVariantModel, Walkthrough |
| top-level / `fr/estecka/variantscit/modules/impl/EnchantmentVectorModule.java` | `` |  | GetBaker, GetCacheKeys, GetCachePolicy, OrderedSnapMap, VariantId2Map, SafeParseInt, BakeRegex, ValidateSeparator, GetModelForItem, FindEntry, GetEnchantIds, PrintVector, IsPerfectMatch, GetPerfectVariantId, Summary, VariantIdInfo, Walkthrough, Parameters, TruncatedVectorFromComponent, VectorFromMap, hashCode, equals, equals, TaxicabMagnitude, EuclidianSquaredMagnitude, Maximum, Dimensionality, IsWithin, VariantEntry, Bake, AcceptsVariant |
| top-level / `fr/estecka/variantscit/modules/impl/FallbackModule.java` | `` |  | GetItemModel, Walkthrough, GetCacheKeys, GetCachePolicy |
| top-level / `fr/estecka/variantscit/modules/impl/GoatHornModule.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/modules/impl/GroupModule.java` | `` |  | GetCacheKeys, GetCachePolicy, GetModelForItem, Summary, VariantIdInfo, Walkthrough, Bake, AcceptsVariant, SubModuleDefinition |
| top-level / `fr/estecka/variantscit/modules/impl/ItemCountModule.java` | `` |  | GetCacheKeys, GetCachePolicy, GetItemModel |
| top-level / `fr/estecka/variantscit/modules/impl/MultiComponentFormatModule.java` | `` |  | GetCacheKeys, GetCachePolicy, GetItemVariant, Walkthrough |
| top-level / `fr/estecka/variantscit/modules/impl/MusicDiscModule.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/modules/impl/PaintingVariantModule.java` | `` |  | GetPaintingRegistry, GetModelForComponent |
| top-level / `fr/estecka/variantscit/modules/impl/PhonyModule.java` | `` |  | AcceptsVariant, Bake, GetIntrinsicModels, GetCachePolicy, GetCacheKeys, GetModelForItem, Summary, Walkthrough |
| top-level / `fr/estecka/variantscit/modules/impl/PotionEffectModule.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/modules/impl/PotionTypeModule.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/modules/impl/PredicatesModule.java` | `` |  | GetCacheKeys, GetCachePolicy, GetModelForItem, Summary, Walkthrough, PredicatedModel, Resolve, ModelReference, VariantId, Intrinsic, Resolve, GetLabel, AcceptsVariant, GetIntrinsicModels, AcceptsIntrinsic, Bake |
| top-level / `fr/estecka/variantscit/modules/impl/TrimMaterialModule.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/modules/impl/TrimModule.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/modules/impl/TrimPatternModule.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/modules/libraries/GenericBakedModule.java` | `` |  | GetModelForItem, GetCacheKeys, GetCachePolicy, Summary, Walkthrough |
| top-level / `fr/estecka/variantscit/modules/libraries/IDebuggableLibrary.java` | `` |  | GetLibrary, OnTriedVariant, OnTriedSpecial, PrintConclusion |
| top-level / `fr/estecka/variantscit/modules/libraries/IGenericCitModule.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/modules/libraries/ILinearCitModule.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/modules/libraries/ILinearLibrary.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/modules/libraries/ISimpleCitModule.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/modules/libraries/IVariantCitModule.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/modules/libraries/IVariantLibrary.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/modules/libraries/LinearLibrary.java` | `` |  | Fallback, GetWithBias, GetOrLesser, GetOrGreater, Summary, Dump, CreateSnitch, GetWithBias, GetOrGreater, GetOrLesser, LogGet |
| top-level / `fr/estecka/variantscit/modules/libraries/LinearModuleBaker.java` | `` |  | Of, Bake, AcceptsVariant |
| top-level / `fr/estecka/variantscit/modules/libraries/LinearSnapMap.java` | `` |  | size, iterator, CompareEntries, AddEntry, AddEntries, GetClosestIndex, GetClosestValue, GetClosestValue, GetClosestValue |
| top-level / `fr/estecka/variantscit/modules/libraries/VariantLibrary.java` | `` |  | fallbackModel, variantModels, HasVariantModel, GetVariantModel, GetVariantModelStrict, GetVariantCount, isEmpty, GetSubLibrary, Summary, Dump, SortedEntries, CreateSnitch, HasVariantModel, GetVariantModel, GetVariantModelStrict, OnTriedVariant |
| top-level / `fr/estecka/variantscit/modules/libraries/VariantModuleBaker.java` | `` |  | Of, Bake |
| top-level / `fr/estecka/variantscit/modules/ModuleList.java` | `` |  | UnwrapIfSingle, Unwrap, GetModelForItem, Crawl, GetCacheKeys, add, addAll, GetCachePolicy, Summary, Walkthrough |
| top-level / `fr/estecka/variantscit/modules/PreconditionModule.java` | `` |  | GetModelForItem, GetCachePolicy, GetCacheKeys, Walkthrough, VariantIdInfo, Summary |
| top-level / `fr/estecka/variantscit/reload/EAssetType.java` | `` |  | GetModelId, GetVanillaId |
| top-level / `fr/estecka/variantscit/reload/EModuleHook.java` | `` |  | getSerializedName, toString, MapOf |
| top-level / `fr/estecka/variantscit/reload/IUnbakedModule.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/reload/LibraryDefinition.java` | `` |  | LibraryDefinition, FromArray, LegacyHardcoded, DisallowIntrinsic, CreateInitialLibrary, GetVariantIds, AcceptsVariant, GetModelId |
| top-level / `fr/estecka/variantscit/reload/MetaModule.java` | `` |  | MetaModule |
| top-level / `fr/estecka/variantscit/reload/ModuleDefinition.java` | `` |  | ModuleDefinition |
| top-level / `fr/estecka/variantscit/reload/ModuleLoader.java` | `` |  | ReloadModules, ObsoletePathWarning, ItemsFromModule, ItemsFromTarget, ItemsFromModuleId |
| top-level / `fr/estecka/variantscit/reload/VariantAggregator.java` | `` |  | GetLibrary, GatherAll, GatherType, GatherIds, ApplyModelToAll, ApplyModelToModule, UpdateGeneratedPack, OnGeneratedResource, GeneratedAsset |
| top-level / `fr/estecka/variantscit/util/CodecUtil.java` | `` |  | NamespacedIdentifier, VCitIdentifier, ParseRegex, Enum, UnItemifyRaw, UnItemify, UnItemify, ValidateNonEmptyString, NonEmptyString, NonEmptyStringCodec, WithWarning, WithWarning, WithWarning, NoEncode, NoGetter, NoGetter, OneOrMany, WithAlternative, MapWithAlternative, WithAlternatives, MapWithAlternatives, WithAlias, WithDeprecatedAlias, OptionalWithAlias, OptionalWithDeprecatedAlias, AnonymizeMap, Anonymize, ParseString, ShortIdString, ShortIdString, GetComponentNbt, GetComponentNbt, GetResources, AssetIdFromResourceId, ParseResource, ParseResource, ReloadResources |
| top-level / `fr/estecka/variantscit/util/collections/HashMap2.java` | `` |  | CreateSubMap |
| top-level / `fr/estecka/variantscit/util/collections/HashMap3.java` | `` |  | get, computeIfAbsent, put, computeIfAbsent |
| top-level / `fr/estecka/variantscit/util/collections/IdentityHashMap2.java` | `` |  | CreateSubMap |
| top-level / `fr/estecka/variantscit/util/collections/Map2.java` | `` |  |  |
| top-level / `fr/estecka/variantscit/util/collections/NestedMaps.java` | `` |  | Create, Create |
| top-level / `fr/estecka/variantscit/util/CollectionUtil.java` | `` |  | ConcatToString |
| top-level / `fr/estecka/variantscit/util/DecodableRegistry.java` | `` |  | RegisterUnit, RegisterMap, Register, GetDecoder, AssertUnique, Deprecate, Deprecated, encode, keys, decode, keys, WithKeyCodec, WithWrapper, WithDefault, Build |
| top-level / `fr/estecka/variantscit/util/logging/ConsoleLogger.java` | `` |  | Unlabelled, info, warn, error, trace |
| top-level / `fr/estecka/variantscit/util/logging/LogLabelStack.java` | `` |  | pop, GetLabelString, AddLabels, AddLabels |
| top-level / `fr/estecka/variantscit/util/ReloadableRepository.java` | `` |  | Get, GetOptional, Reload |
| top-level / `fr/estecka/variantscit/util/VariantUtil.java` | `` |  | SpecialVariantId, IntrinsicVariantId, IsVariantIntrinsic, GetIntrinsicModelId, RemovePrefix |
| top-level / `fr/estecka/variantscit/VariantsCitMod.java` | `` |  | Identifier, GetModules, onInitializeClient, OnResourceReload |
| top-level / `fr/estecka/variantscit/VCitRegistries.java` | `` |  | RegisterBakedModule, RegisterSimpleModule, RegisterSimpleModule, RegisterLinearModule, RegisterLinearModule, OptionalParameters, RegisterRemoved |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
