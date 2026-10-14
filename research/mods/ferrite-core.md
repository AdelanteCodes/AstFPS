# FerriteCore

Review status: **Evidence inventory; behavioral review pending**

Project: [FerriteCore](https://modrinth.com/mod/ferrite-core)
Selected artifact version: `9.0.0-fabric`
Published implementation source: https://github.com/malte0811/FerriteCore
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Memory usage optimizations

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha512`: `d81fa97e11784c19d42f89c2f433831d007603dd7193cee45fa177e4a6a9c52b384b198586e04a0f7f63cd996fed713322578bde9a8db57e1188854ae5cbe584`
- `sha1`: `eac76ff0f3753422c61b2c44487d0d195d88d4bc`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 48
Reconstructed Java files: 40

**environment**

```json
"*"
```

**depends**

```json
{
  "fabricloader": ">=0.14.21",
  "minecraft": ">=26.1 <27"
}
```

**breaks**

```json
{
  "hydrogen": "<=0.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `malte0811/ferritecore/ducks/BlockStateCacheAccess.java` | `` |  |  |
| top-level / `malte0811/ferritecore/ducks/FastMapStateHolder.java` | `` |  |  |
| top-level / `malte0811/ferritecore/ducks/SmallThreadDetectable.java` | `` |  |  |
| top-level / `malte0811/ferritecore/fastmap/BinaryFastMapKey.java` | `` |  | create, replaceIn, toPartialMapIndex, getFactorToNext, getIndexIn, lowestNBits |
| top-level / `malte0811/ferritecore/fastmap/CompactFastMapKey.java` | `` |  | replaceIn, toPartialMapIndex, getFactorToNext, getIndexIn |
| top-level / `malte0811/ferritecore/fastmap/FastMap.java` | `` |  | with, getIndexOf, insertAtIndex, getValueIndex, getProperties, getIndexUnsafe |
| top-level / `malte0811/ferritecore/fastmap/FastMapKey.java` | `` |  |  |
| top-level / `malte0811/ferritecore/hash/ArrayVoxelShapeHash.java` | `` |  | hashCode, equals |
| top-level / `malte0811/ferritecore/hash/DiscreteVSHash.java` | `` |  | hashCode, hashCode, equals, equals |
| top-level / `malte0811/ferritecore/hash/LambdaBasedHash.java` | `` |  | hashCode, equals |
| top-level / `malte0811/ferritecore/hash/SliceShapeHash.java` | `` |  | hashCode, equals |
| top-level / `malte0811/ferritecore/hash/VoxelShapeHash.java` | `` |  | hashCode, hashCode, equals, equals, isCubeShape |
| top-level / `malte0811/ferritecore/impl/BlockStateCacheImpl.java` | `` |  | deduplicateCachePre, deduplicateCachePost, deduplicateCollisionShape, deduplicateFaceSturdyArray, replaceInternals, replaceInternals, getRenderShape |
| top-level / `malte0811/ferritecore/impl/FastMapStateHolderImpl.java` | `` |  | initializeFastMap, getPropertyValue, getPropertyValue |
| top-level / `malte0811/ferritecore/IPlatformHooks.java` | `` |  |  |
| top-level / `malte0811/ferritecore/mixin/accessors/ArrayVSAccess.java` | `value={ArrayVoxelShape.class})` | Accessor:6 |  |
| top-level / `malte0811/ferritecore/mixin/accessors/BitSetDVSAccess.java` | `value={BitSetDiscreteVoxelShape.class})` | Accessor:7 |  |
| top-level / `malte0811/ferritecore/mixin/accessors/DiscreteVSAccess.java` | `value={DiscreteVoxelShape.class})` | Accessor:3 |  |
| top-level / `malte0811/ferritecore/mixin/accessors/SliceShapeAccess.java` | `value={SliceShape.class})` | Accessor:2 |  |
| top-level / `malte0811/ferritecore/mixin/accessors/StateHolderAccess.java` | `value={StateHolder.class})` | Accessor:1 |  |
| top-level / `malte0811/ferritecore/mixin/accessors/SubShapeAccess.java` | `value={SubShape.class})` | Accessor:7 |  |
| top-level / `malte0811/ferritecore/mixin/accessors/VoxelShapeAccess.java` | `value={VoxelShape.class})` | Accessor:4 |  |
| top-level / `malte0811/ferritecore/mixin/blockstatecache/BlockStateBaseMixin.java` | `value={BlockBehaviour.BlockStateBase.class})` | Inject:2 | cacheStateHead, cacheStateTail |
| top-level / `malte0811/ferritecore/mixin/blockstatecache/BlockStateCacheMixin.java` | `targets={"net.minecraft.world.level.block.state.BlockBehaviour$BlockStateBase$Cache"})` |  | getCollisionShape, setCollisionShape, getFaceSturdy, setFaceSturdy |
| top-level / `malte0811/ferritecore/mixin/blockstatecache/Config.java` | `` |  |  |
| top-level / `malte0811/ferritecore/mixin/blockstatecache/TempMixin.java` | `value={SimpleBitStorage.class})` | Inject:1, Overwrite:1 | copyDataIfNecessary, copy |
| top-level / `malte0811/ferritecore/mixin/config/FerriteConfig.java` | `` |  | createOption, createOptInOption, finish, set, getName, getComment, isEnabled, getDefaultValue |
| top-level / `malte0811/ferritecore/mixin/config/FerriteMixinConfig.java` | `` |  | shouldApplyMixin, onLoad, getRefMapperConfig, acceptTargets, getMixins, preApply, postApply, hasClass, shouldApply |
| top-level / `malte0811/ferritecore/mixin/config/IPlatformConfigHooks.java` | `` |  | loadHooks |
| top-level / `malte0811/ferritecore/mixin/datacomponents/Config.java` | `` |  |  |
| top-level / `malte0811/ferritecore/mixin/datacomponents/PatchedDataComponentMapMixin.java` | `value={PatchedDataComponentMap.class})` | Inject:2 | saveMemoryIfEmpty, saveMemoryIfEmptyWithReturn |
| top-level / `malte0811/ferritecore/mixin/fastmap/Config.java` | `` |  |  |
| top-level / `malte0811/ferritecore/mixin/fastmap/FastMapStateHolderMixin.java` | `value={StateHolder.class}, priority=900)` | Overwrite:2, Redirect:1 | setValueInternal, redirectPropertyValueAccess, ferritecore_setStateMap |
| top-level / `malte0811/ferritecore/mixin/fastmap/StateDefinitionMixin.java` | `value={StateDefinition.class})` | Redirect:2, WrapOperation:1 | initializeNeighborsMultiProp, skipSetNeighbors, initSinglePropertyFastMap |
| top-level / `malte0811/ferritecore/mixin/platform/ConfigFileHandler.java` | `` |  | readAndUpdateConfig, collectDisabledOverrides |
| top-level / `malte0811/ferritecore/mixin/threaddetec/Config.java` | `` |  |  |
| top-level / `malte0811/ferritecore/mixin/threaddetec/PalettedContainerMixin.java` | `value={PalettedContainer.class})` | Inject:1, Overwrite:2 | redirectBuildThreadingDetector, acquire, release, ferritecore$getState, ferritecore$setState |
| top-level / `malte0811/ferritecore/PlatformHooks.java` | `` |  | computeBlockstateCacheFieldName, computeStateHolderValuesName |
| top-level / `malte0811/ferritecore/util/Constants.java` | `` |  |  |
| top-level / `malte0811/ferritecore/util/SmallThreadingDetector.java` | `` |  | acquire, release, startCrash, crashAcquire, crashRelease, crashBystander, getAndWait, waitUntilReady, waitUntilOrCrash |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
