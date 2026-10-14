# Lithium

Review status: **Evidence inventory; behavioral review pending**

Project: [Lithium](https://modrinth.com/mod/lithium)
Selected artifact version: `mc26.3-0.26.2-fabric`
Published implementation source: https://github.com/caffeinemc/lithium-fabric
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

No-compromises game logic optimization mod, useful for both single-player games and multi-player servers.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha512`: `4d7fee66132eedc71feab9390b92c95d7058edbdad0fecfac1d836a2950b97a7ca463afbede61c7ef361ce65e1f927ab9e89dde5bf2e0e0ce486afb5c5dbee40`
- `sha1`: `dd5a4ec2c68d7601d8bce9076f789c55a5f8bef3`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 696
Reconstructed Java files: 609

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "net.caffeinemc.mods.lithium.fabric.LithiumFabricMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "mixinextras": ">=0.5.5"
}
```

**breaks**

```json
{
  "optifabric": "*"
}
```

**accessWidener**

```json
"lithium.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/caffeinemc/mods/lithium/api/inventory/LithiumCooldownReceivingInventory.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/api/inventory/LithiumDefaultedList.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/api/inventory/LithiumInventory.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/api/inventory/LithiumTransferConditionInventory.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/ai/brain/memories/BrainExtended.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/ai/brain/memories/MemoryModificationCounter.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/ai/brain/RunningPolicyNoStream.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/ai/brain/SensorHelper.java` | `` |  | disableSensor, enableSensor, enableSensor |
| top-level / `net/caffeinemc/mods/lithium/common/ai/non_poi_block_search/CheckAndCacheBlockChecker.java` | `` |  | initializeChunks, initializeChunks, getChunkSize, hasUnloadedPossibleChunks, checkChunkSection, checkCachedSection, getCachedChunkAccess, getCachedChunkAccess, shouldStop, checkPosition |
| top-level / `net/caffeinemc/mods/lithium/common/ai/non_poi_block_search/CommonBlockSearchesCheckAndCache.java` | `` |  | hasNoMatch |
| top-level / `net/caffeinemc/mods/lithium/common/ai/non_poi_block_search/LithiumMoveToBlockGoal.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/ai/non_poi_block_search/NonPOISearchDistances.java` | `` |  | getMinimumSortOrderOfChunk, getMinimumSortOrderOfChunk, getRing, getVanillaSortOrderInt |
| top-level / `net/caffeinemc/mods/lithium/common/ai/pathing/BlockStatePathingCache.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/ai/pathing/PathNodeCache.java` | `` |  | isChunkSectionDangerousNeighbor, getPathNodeType, getNeighborPathNodeType, isSectionSafeAsNeighbor, getNodeTypeFromNeighbors |
| top-level / `net/caffeinemc/mods/lithium/common/ai/useless_behaviors/LithiumEmptyBehavior.java` | `` |  | getStatus, getRequiredMemories, tryStart, tickOrStop, doStop, debugString |
| top-level / `net/caffeinemc/mods/lithium/common/ai/WeightedListIterable.java` | `` |  | cast, hasNext, next |
| top-level / `net/caffeinemc/mods/lithium/common/block/BlockCountingSection.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/block/BlockListeningSection.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/block/BlockStateFlagHolder.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/block/BlockStateFlags.java` | `` |  | test, test, test |
| top-level / `net/caffeinemc/mods/lithium/common/block/entity/inventory_change_tracking/InventoryChangeEmitter.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/block/entity/inventory_change_tracking/InventoryChangeListener.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/block/entity/inventory_change_tracking/InventoryChangeTracker.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/block/entity/inventory_comparator_tracking/ComparatorTracker.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/block/entity/inventory_comparator_tracking/ComparatorTracking.java` | `` |  | notifyNearbyBlockEntitiesAboutNewComparator, findNearbyComparators |
| top-level / `net/caffeinemc/mods/lithium/common/block/entity/SetBlockStateHandlingBlockEntity.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/block/entity/SetChangedHandlingBlockEntity.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/block/entity/ShapeUpdateHandlingBlockBehaviour.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/block/entity/sleeping_sculk/GameEventListenerWithCallback.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/block/entity/SleepingBlockEntity.java` | `` |  | tick, isRemoved, getPos, getType |
| top-level / `net/caffeinemc/mods/lithium/common/block/entity/SleepUntilTimeBlockEntityTickInvoker.java` | `` |  | tick, isRemoved, getPos, getType |
| top-level / `net/caffeinemc/mods/lithium/common/block/redstone/RedstoneWirePowerCalculations.java` | `` |  | getNeighborBlockSignal, getNeighborWireSignal, getNeighborSignal, getSignalFromVertical, getSignalFromSide, getDirectSignalTo |
| top-level / `net/caffeinemc/mods/lithium/common/block/TrackedBlockStatePredicate.java` | `` |  | getIndex, getFallbackResult |
| top-level / `net/caffeinemc/mods/lithium/common/client/ClientWorldAccessor.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/client/SharedFields.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/config/LithiumConfig.java` | `` |  | load, addRuleDependency, addMixinRule, readProperties, applyModOverride, getEffectiveOptionForMixin, isOptionEnabled, applyDependencies, applyDependenciesOnce, writeDefaultConfig, getMixinRuleName, getOptionCount, getOptionOverrideCount, getParent |
| top-level / `net/caffeinemc/mods/lithium/common/config/Option.java` | `` |  | setEnabled, addModOverride, isEnabled, isEnabledRecursive, isOverridden, isUserDefined, isModDefined, getName, clearModsDefiningValue, getDefiningMods, addDependency, disableIfDependenciesNotMet |
| top-level / `net/caffeinemc/mods/lithium/common/entity/EntityClassGroup.java` | `` |  | clear, contains, contains, checkDetailedContains |
| top-level / `net/caffeinemc/mods/lithium/common/entity/EquipmentInfo.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/entity/item/ItemEntityLazyIterationConsumer.java` | `` |  | getMergeEntities, accept, predictReceivedItemCount, getTransferAmount |
| top-level / `net/caffeinemc/mods/lithium/common/entity/item/ItemEntityList.java` | `` |  | hashCode, equals, markElementAsOutdated, processOutdated, size, isEmpty, contains, add, addToCategories, addToCategoryList, subscribeElement, isMaxHalfFull, isMaxHalfFull, remove, remove, removeElement, reinitialize, unsubscribeElement, removeFromCategories, removeFromCategoryList, containsAll, clear, equals, hashCode, get, set, indexOf, lastIndexOf, toArray, stream, parallelStream, forEach, lithium$notify, lithium$forceUnsubscribe, lithium$notifyCount, consumeForEntityStacking, consumeElements |
| top-level / `net/caffeinemc/mods/lithium/common/entity/LithiumEntityCollisions.java` | `` |  | getBlockCollisions, doesBoxCollideWithBlocks, doesBoxCollideWithHardEntities, appendEntityCollisions, appendWorldBorderCollision, getEntityWorldBorderCollisionIterable, iterator, computeNext, isWithinWorldBorder, isBoxEmpty, doesBoxCollideWithWorldBorder, getWorldBorderCollision, getSupportingCollisionForEntity, getCollisionShapeBelowEntityFallback, getOffsetShapeIfVanillaWouldIteratePos, addLastBlockCollisionIfRequired, getSmallerBoxForSingleAxisMovement, addEntityCollisionsIfRequired, addWorldBorderCollisionIfRequired |
| top-level / `net/caffeinemc/mods/lithium/common/entity/movement/ChunkAwareBlockCollisionSweeper.java` | `` |  | nextSection, canInteractWithBlock, getCollidedShape, expandMin, expandMax, hasChunkSectionOversizedBlocks |
| top-level / `net/caffeinemc/mods/lithium/common/entity/movement/ChunkAwareBlockCollisionSweeperBlockPos.java` | `` |  | computeNext |
| top-level / `net/caffeinemc/mods/lithium/common/entity/movement/ChunkAwareBlockCollisionSweeperVoxelShape.java` | `` |  | getLastCollision, computeNext, collectAll |
| top-level / `net/caffeinemc/mods/lithium/common/entity/movement/CollisionEntityClassGroups.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/entity/NavigatingEntity.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/entity/PositionedEntityTrackingSection.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/entity/projectile/ProjectileCanHitEntityPredicate.java` | `` |  | test |
| top-level / `net/caffeinemc/mods/lithium/common/entity/projectile/ProjectileEntityClassGroups.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/entity/pushable/EntityPushablePredicate.java` | `` |  | and, test |
| top-level / `net/caffeinemc/mods/lithium/common/entity/pushable/FeetBlockCachingEntity.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/entity/pushable/PushableEntityClassGroup.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/entity/TypeFilterableListInternalAccess.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/explosion/DirectMappedExplosionBlockCache.java` | `` |  | DirectMappedExplosionBlockCache |
| top-level / `net/caffeinemc/mods/lithium/common/explosion/DirectMappedPos2AABBsCache.java` | `` |  | DirectMappedPos2AABBsCache, getEntry, cacheEntry, posToCacheIndex, invalidate |
| top-level / `net/caffeinemc/mods/lithium/common/explosion/ExplosionEntityRays.java` | `` |  | doesRayHitOffsetAABBVolumes, doesRayHitOffsetAABBVolume, doesRayHitAABBSurface |
| top-level / `net/caffeinemc/mods/lithium/common/explosion/LithiumExplosion.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/hopper/BlockStateOnlyInventory.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/hopper/ComparatorUpdatePattern.java` | `` |  | thenUpdate, thenDecrementUpdateIncrementUpdate, apply, thenDecrementUpdateIncrementUpdate, apply, isChainable, apply, isChainable, apply, thenUpdate, thenDecrementUpdateIncrementUpdate, isChainable |
| top-level / `net/caffeinemc/mods/lithium/common/hopper/HopperCachingState.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/hopper/HopperHelper.java` | `` |  | tryMoveSingleItem, tryMoveSingleItem, calculateReducedSignalStrength, determineComparatorUpdatePattern, replaceDoubleInventory, updateHopperOnUpdateSuppression |
| top-level / `net/caffeinemc/mods/lithium/common/hopper/InventoryHelper.java` | `` |  | getLithiumStackList, getLithiumStackListOrNull, upgradeToLithiumStackList |
| top-level / `net/caffeinemc/mods/lithium/common/hopper/LithiumDoubleInventory.java` | `` |  | getLithiumInventory, lithium$emitContentModified, lithium$emitStackListReplaced, lithium$emitRemoved, invalidateChangeListening, lithium$emitFirstComparatorAdded, lithium$forwardContentChangeOnce, lithium$forwardMajorInventoryChanges, lithium$stopForwardingMajorInventoryChanges, getInventoryLithium, setInventoryLithium, lithium$handleInventoryContentModified, lithium$handleInventoryRemoved, lithium$handleComparatorAdded, lithium$onComparatorAdded, lithium$hasAnyComparatorNearby, setDoubleStackList |
| top-level / `net/caffeinemc/mods/lithium/common/hopper/LithiumDoubleStackList.java` | `` |  | getOrCreate, getModCount, changedALot, changed, set, add, remove, clear, getSignalStrength, setReducedSignalStrengthOverride, clearSignalStrengthOverride, runComparatorUpdatePatternOnFailedExtract, get, size, setNextInventoryModificationCallback, removeInventoryModificationCallback, hasSignalStrengthOverride, maybeSendsComparatorUpdatesOnFailedExtract, getOccupiedSlots, getFullSlots, changedInteractionConditions, lithium$notify, lithium$forceUnsubscribe, lithium$notifyCount |
| top-level / `net/caffeinemc/mods/lithium/common/hopper/LithiumStackList.java` | `` |  | getModCount, changedALot, changed, set, add, remove, clear, hasSignalStrengthOverride, getSignalStrength, setReducedSignalStrengthOverride, clearSignalStrengthOverride, runComparatorUpdatePatternOnFailedExtract, maybeSendsComparatorUpdatesOnFailedExtract, getOccupiedSlots, getFullSlots, changedInteractionConditions, setNextInventoryModificationCallback, removeInventoryModificationCallback, lithium$notify, lithium$forceUnsubscribe, lithium$notifyCount |
| top-level / `net/caffeinemc/mods/lithium/common/hopper/UpdateReceiver.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/initialization/BlockInfoInitializer.java` | `` |  | initializeBlockInfo, resetBlockInfo, initializeBlockInfoAndGetFlags |
| top-level / `net/caffeinemc/mods/lithium/common/LithiumMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `net/caffeinemc/mods/lithium/common/LithiumMod.java` | `` |  | onInitialization, logger, getVersion |
| top-level / `net/caffeinemc/mods/lithium/common/reflection/ReflectionUtil.java` | `` |  | hasMethodOverride, isBlockStateEntityTouchable |
| top-level / `net/caffeinemc/mods/lithium/common/services/PlatformEntityAccess.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/services/PlatformMixinOverrides.java` | `` |  | getInstance, MixinOverride |
| top-level / `net/caffeinemc/mods/lithium/common/services/PlatformModCompat.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/services/PlatformRuntimeInformation.java` | `` |  | getInstance |
| top-level / `net/caffeinemc/mods/lithium/common/services/Services.java` | `` |  | load |
| top-level / `net/caffeinemc/mods/lithium/common/shapes/CuboidVoxelSet.java` | `` |  | isFull, fill, firstFull, lastFull, isEmpty |
| top-level / `net/caffeinemc/mods/lithium/common/shapes/lists/OffsetFractionalDoubleList.java` | `` |  | getDouble, size |
| top-level / `net/caffeinemc/mods/lithium/common/shapes/OffsetVoxelShapeCache.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/shapes/pairs/LithiumDoublePairList.java` | `` |  | merge, forMergedIndexes, size, getList, getArray |
| top-level / `net/caffeinemc/mods/lithium/common/shapes/VoxelShapeAlignedCuboid.java` | `` |  | move, collideX, limitMovement, limitMovement, getCoords, get, findIndex, findIndex, getXSegments, getYSegments, getZSegments |
| top-level / `net/caffeinemc/mods/lithium/common/shapes/VoxelShapeAlignedCuboidOffset.java` | `` |  | collideX, limitMovement, limitMovement, getCoords, get, findIndex, findIndex |
| top-level / `net/caffeinemc/mods/lithium/common/shapes/VoxelShapeCaster.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/shapes/VoxelShapeEmpty.java` | `` |  | collideX, getCoords, min, max, isEmpty, intersectsJNE |
| top-level / `net/caffeinemc/mods/lithium/common/shapes/VoxelShapeHelper.java` | `` |  | getClosestPointTo, initVoxelSet, getIndex |
| top-level / `net/caffeinemc/mods/lithium/common/shapes/VoxelShapeMatchesAnywhere.java` | `` |  | cuboidMatchesAnywhere, isTiny, exceedsCube, exceedsCube, intersects |
| top-level / `net/caffeinemc/mods/lithium/common/shapes/VoxelShapeSimpleCube.java` | `` |  | move, collideX, limitMovement, limitMovement, toAabbs, bounds, min, max, get, getCoords, isEmpty, findIndex, intersectsJNE, forAllBoxes |
| top-level / `net/caffeinemc/mods/lithium/common/tracking/block/BlockChangeTracker.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/tracking/block/ChunkSectionChangeCallback.java` | `` |  | init, create, onBlockChange, addTracker, removeTracker, onChunkSectionInvalidated, getSectionPos, getX, getY, getZ |
| top-level / `net/caffeinemc/mods/lithium/common/tracking/block/LithiumBlockCounter.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/tracking/block/SectionedBlockChangeTracker.java` | `` |  | matchesMovedBox, registerAt, getWorldTime, register, unregister, listenToAllSections, setChanged, setChanged, isUnchangedSince, equals, hashCode, onChunkSectionInvalidated |
| top-level / `net/caffeinemc/mods/lithium/common/tracking/entity/EntityMovementTrackerSection.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/tracking/entity/MovementTrackerHelper.java` | `` |  | getNotificationMask, calculateNotificationMask |
| top-level / `net/caffeinemc/mods/lithium/common/tracking/entity/SectionedColliderEntityMovementTracker.java` | `` |  | registerAt |
| top-level / `net/caffeinemc/mods/lithium/common/tracking/entity/SectionedEntityMovementListener.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/tracking/entity/SectionedEntityMovementTracker.java` | `` |  | hashCode, equals, isUnchangedSince, listenToAllSectionsAndGetMaxChangeTime, register, unRegister, onSectionEnteredRange, onSectionLeftRange, setChanged, listenToEntityMovementOnce, emitEntityMovement, notifyAllListeners |
| top-level / `net/caffeinemc/mods/lithium/common/tracking/entity/SectionedInventoryEntityMovementTracker.java` | `` |  | registerAt, getEntities |
| top-level / `net/caffeinemc/mods/lithium/common/tracking/entity/SectionedItemEntityMovementTracker.java` | `` |  | registerAt, getEntities |
| top-level / `net/caffeinemc/mods/lithium/common/tracking/entity/ToggleableMovementTracker.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/tracking/VicinityCache.java` | `` |  | isTracking, initTracking, updateCache, resetTrackedPos, resetCachedInfo, remove, canSkipBlockTouching, setCanSkipBlockTouching, getStationaryFluidHeightOrDefault, setCachedFluidHeight, getIsTouchingFireLava, setCachedTouchingFireLava, getIsSuffocating, setCachedIsSuffocating, canSkipSupportingBlockSearch, setCanSkipSupportingBlockSearch, cacheSupportingBlockState, getCachedSupportingBlock |
| top-level / `net/caffeinemc/mods/lithium/common/tracking/VicinityCacheProvider.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/util/ArrayConstants.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/util/change_tracking/ChangePublisher.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/util/change_tracking/ChangeSubscriber.java` | `` |  | combine, without, without, dataWithout, dataWithout, dataOf, containsSubscriber, lithium$notify, lithium$forceUnsubscribe, lithium$notifyCount, lithium$notifyAfterEnchantmentChange |
| top-level / `net/caffeinemc/mods/lithium/common/util/ChunkConstants.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/util/collections/BucketedList.java` | `` |  | addToBucket, iterator, hasNext, next, get, size |
| top-level / `net/caffeinemc/mods/lithium/common/util/collections/FixedChunkAccessSectionBitBuffer.java` | `` |  | getSectionIndex, getSectionIndex, getChunkSectionBit, getChunkSectionBit, setChunkSectionStatus, getChunkIndex, getChunkIndex, getChunkAccess, getChunkAccess, setChunkAccess, setChunkAccess, hasNoTrueChunkSections, getChunkPosInRange, iterator, getChunkPosInRangeIterator, nextLong, hasNext, getSectionYInRange, iterator, getSectionYInRangeIterator, nextInt, hasNext |
| top-level / `net/caffeinemc/mods/lithium/common/util/collections/HashedReferenceList.java` | `` |  | size, isEmpty, contains, iterator, toArray, toArray, add, remove, containsAll, addAll, addAll, removeAll, retainAll, clear, get, set, add, remove, indexOf, lastIndexOf, listIterator, listIterator, hasNext, next, hasPrevious, previous, nextIndex, previousIndex, remove, set, add, subList, trackReferenceAdded, trackReferenceRemoved |
| top-level / `net/caffeinemc/mods/lithium/common/util/collections/LazyList.java` | `` |  | produceToIndex, get, size, iterator, hasNext, next, set, add, remove, clear, add, isEmpty, addAll |
| top-level / `net/caffeinemc/mods/lithium/common/util/collections/ListeningList.java` | `` |  | onChange, size, isEmpty, contains, iterator, toArray, forEach, toArray, add, remove, containsAll, addAll, addAll, removeAll, removeIf, retainAll, replaceAll, sort, clear, get, set, add, remove, indexOf, lastIndexOf, listIterator, listIterator, hasNext, next, hasPrevious, previous, nextIndex, previousIndex, remove, set, add, subList, spliterator, stream, parallelStream |
| top-level / `net/caffeinemc/mods/lithium/common/util/collections/ListeningLong2ObjectOpenHashMap.java` | `` |  | put, remove |
| top-level / `net/caffeinemc/mods/lithium/common/util/collections/LongJumpChoiceList.java` | `` |  | packOffset, unpackX, unpackY, unpackZ, forCenter, offsetCopy, removeRandomWeightedByDistanceSq, get, isEmpty, size, remove |
| top-level / `net/caffeinemc/mods/lithium/common/util/collections/MaskedList.java` | `` |  | totalSize, addOrSet, setVisible, iterator, hasNext, next, spliterator, tryAdvance, add, remove, get, size |
| top-level / `net/caffeinemc/mods/lithium/common/util/collections/Object2BooleanCacheTable.java` | `` |  | hash, get |
| top-level / `net/caffeinemc/mods/lithium/common/util/collections/PredicateFilterableList.java` | `` |  | onChange, getFiltered, get, size |
| top-level / `net/caffeinemc/mods/lithium/common/util/collections/ReferenceMaskedList.java` | `` |  | totalSize, addOrSet, setVisible, iterator, hasNext, next, spliterator, tryAdvance, add, remove, get, size |
| top-level / `net/caffeinemc/mods/lithium/common/util/deduplication/LithiumInterner.java` | `` |  | getCanonical, deleteCanonical |
| top-level / `net/caffeinemc/mods/lithium/common/util/DirectionConstants.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/util/Distances.java` | `` |  | getMinChunkToBlockDistanceL2Sq, getClosestPosInChunk, isWithinCubeRadius, isWithinSphereRadius, getClosestBlockCoordInSection, getMinSectionDistanceSq, distanceSq, distanceSqInt |
| top-level / `net/caffeinemc/mods/lithium/common/util/functions/FunLongAnd5.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/util/lock/NullLock.java` | `` |  | lock, lockInterruptibly, tryLock, tryLock, unlock, newCondition |
| top-level / `net/caffeinemc/mods/lithium/common/util/lock/NullReadWriteLock.java` | `` |  | readLock, writeLock |
| top-level / `net/caffeinemc/mods/lithium/common/util/math/CompactSineLUT.java` | `` |  | init, sin, cos, lookup |
| top-level / `net/caffeinemc/mods/lithium/common/util/math/MutableVec3d.java` | `` |  | getX, getY, getZ, add, toImmutable |
| top-level / `net/caffeinemc/mods/lithium/common/util/POIRegistryEntries.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/util/Pos.java` | `` |  | getNumYSections, getMinYSectionIndex, getMaxYSectionIndexInclusive, getMaxYSectionIndexExclusive, fromSectionCoord, fromBlockCoord, getNumYSections, getMinYSection, getMaxYSectionInclusive, getMaxYSectionExclusive, fromSectionIndex, fromBlockCoord, fromBlockCoord, fromBlockSize, getYSize, getMinY, getMaxYInclusive, getMaxYExclusive, getMaxInSectionCoord, getMaxYInSectionIndex, getMinInSectionCoord, getMinYInSectionIndex |
| top-level / `net/caffeinemc/mods/lithium/common/util/tuples/Range6Int.java` | `` |  | Range6Int |
| top-level / `net/caffeinemc/mods/lithium/common/util/tuples/RefIntPair.java` | `` |  | equals, hashCode, toString |
| top-level / `net/caffeinemc/mods/lithium/common/util/tuples/SortedPointOfInterest.java` | `` |  | getPos, getX, getY, getZ, poi, distanceSq, isConsumed, setConsumed |
| top-level / `net/caffeinemc/mods/lithium/common/util/tuples/Tuple5Obj1I.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/util/tuples/WorldSectionBox.java` | `` |  | WorldSectionBox, entityAccessBox, relevantExpandedBlocksBox, relevantFluidBox, numSections, matchesRelevantBlocksBox |
| top-level / `net/caffeinemc/mods/lithium/common/world/block_pattern_matching/BlockPatternExtended.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/world/block_pattern_matching/BlockSearch.java` | `` |  | hasAtLeast, countBlocksInBoxInSection |
| top-level / `net/caffeinemc/mods/lithium/common/world/blockentity/BlockEntityGetter.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/world/blockentity/SupportCache.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/world/blockview/SingleBlockBlockView.java` | `` |  | of, getBlockState, getFluidState, getBlockEntity, getHeight, getMinY, getWorldBorder, getChunkForCollisions, isUnobstructed, isUnobstructed, isUnobstructed, noCollision, getEntityCollisions, getCollisions, getBlockCollisions, collidesWithSuffocatingBlock, findFreePosition, fillInStackTrace |
| top-level / `net/caffeinemc/mods/lithium/common/world/chunk/ChunkHolderExtended.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/world/chunk/ChunkStatusTracker.java` | `` |  | registerLoadCallback, registerUnloadCallback, onChunkAccessible, onChunkInaccessible |
| top-level / `net/caffeinemc/mods/lithium/common/world/chunk/ClassGroupFilterableList.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/world/chunk/CompactingPackedIntegerArray.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/world/chunk/heightmap/CombinedHeightmapUpdate.java` | `` |  | updateHeightmaps |
| top-level / `net/caffeinemc/mods/lithium/common/world/chunk/LithiumHashPalette.java` | `` |  | idFor, maybeHas, computeEntry, addEntry, resize, valueFor, recoverMissingPaletteEntryOrCrash, missingPaletteEntryCrash, read, write, getSerializedSize, getSize, copy, clear, getElements, create |
| top-level / `net/caffeinemc/mods/lithium/common/world/ChunkAwareEntityIterable.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/world/ChunkLoadTricks.java` | `` |  | tryRetrieveCurrentlyLoading |
| top-level / `net/caffeinemc/mods/lithium/common/world/ChunkRandomSource.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/world/ChunkView.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/world/ClimbingMobCachingSection.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/world/explosions/ClipContextAccess.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/world/GameEventDispatcherStorage.java` | `` |  | GameEventDispatcherStorage, addChunk, removeChunk, replace, get |
| top-level / `net/caffeinemc/mods/lithium/common/world/in_world_tracking/MaybeInLevelObject.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/world/interests/iterator/NearbyPointOfInterestStream.java` | `` |  | accept, collectPoint, updateMinPoint, tryAdvance, tryAdvancePoint, keepAddingRingsUntilSufficient, sortSectionList, isSectionListEmpty, getMinimumNextPotentialDistanceSq, getNextSectionDistanceSq, getYDistanceFromBitIndex, getPotentialRingDistanceSq, getRingsOfChunksIterator, nextLong, hasNext, getFirst, QueuedSection |
| top-level / `net/caffeinemc/mods/lithium/common/world/interests/iterator/SinglePointOfInterestTypeFilter.java` | `` |  | test, getType |
| top-level / `net/caffeinemc/mods/lithium/common/world/interests/iterator/SphereChunkOrderedPoiSetSpliterator.java` | `` |  | tryAdvance, nextSection, getSectionIterator, nextChunk |
| top-level / `net/caffeinemc/mods/lithium/common/world/interests/PointOfInterestSetExtended.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/world/interests/PointOfInterestStorageExtended.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/world/interests/PoiOrdering.java` | `` |  | compare, compare, compare, compare |
| top-level / `net/caffeinemc/mods/lithium/common/world/interests/RegionBasedStorageSectionExtended.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/world/listeners/WorldBorderListenerOnce.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/world/listeners/WorldBorderPositionListenerMulti.java` | `` |  | add, onAreaReplaced, onSetSize, onLerpSize, onSetCenter, onSetWarningTime, onSetWarningBlocks, onSetDamagePerBlock, onSetSafeZone |
| top-level / `net/caffeinemc/mods/lithium/common/world/LithiumData.java` | `` |  | Data, tryGetOminousBanner |
| top-level / `net/caffeinemc/mods/lithium/common/world/scheduler/OrderedTickQueue.java` | `` |  | clear, iterator, hasNext, next, poll, peek, offer, size, handleCompaction, sort, removeNullsAndConsumed, getTickAtIndex, setTickAtIndex, copyArray, isEmpty |
| top-level / `net/caffeinemc/mods/lithium/common/world/section/LithiumSectionData.java` | `` |  | setCountsByFlag, getCountsByFlag, setChangeListener, getChangeListener, getRandomTickableBlocksByY, setRandomTickableBlocksByY, toString |
| top-level / `net/caffeinemc/mods/lithium/common/world/section/RandomTickingSectionDataHelper.java` | `` |  | naiveInitializeData, handleSectionSingleBlockState, initDataForAllRandomTickingSection, initDataForAllRandomTickingSection, initNonRandomTickingSection, initNonRandomTickingSection, randomTickNthBlock, addAt, removeAt, getMinisectionIndex, pack, unpackX, unpackY, unpackZ |
| top-level / `net/caffeinemc/mods/lithium/common/world/ServerWorldExtended.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/common/world/WorldHelper.java` | `` |  | getEntitiesForCollision, getOtherEntitiesForCollision, getEntityCacheOrNull, getEntitiesOfEntityGroupWithoutDragonPieces, getEntitiesOfEntityGroupPlusDragonPieces, getPushableEntities, areNeighborsWithinSameChunk, areNeighborsWithinSameChunkSection, arePosWithinSameChunk |
| top-level / `net/caffeinemc/mods/lithium/fabric/FabricEntityAccess.java` | `` |  | addEnderDragonParts |
| top-level / `net/caffeinemc/mods/lithium/fabric/FabricMixinOverrides.java` | `` |  | applyLithiumCompat, applyModOverrides |
| top-level / `net/caffeinemc/mods/lithium/fabric/FabricModCompat.java` | `` |  | canHopperInteractWithApiBlockInventory, canFindApiInventory |
| top-level / `net/caffeinemc/mods/lithium/fabric/FabricRuntimeInformation.java` | `` |  | isDevelopmentEnvironment, getGameDirectory, getConfigDirectory, platformHasEarlyLoadingScreen, isModInLoadingList |
| top-level / `net/caffeinemc/mods/lithium/fabric/LithiumFabricMod.java` | `` |  | onInitialize |
| top-level / `net/caffeinemc/mods/lithium/fabric/mixin/block/hopper/LevelMixin.java` | `value={Level.class})` | Inject:1 | updateHopperOnUpdateSuppression |
| top-level / `net/caffeinemc/mods/lithium/fabric/mixin/collections/poi_types/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/fabric/mixin/collections/poi_types/PoiTypesMixin.java` | `value={PoiTypes.class})` |  |  |
| top-level / `net/caffeinemc/mods/lithium/fabric/mixin/compat/worldedit/LevelChunkMixin.java` | `value={LevelChunk.class})` | Inject:1 | updateHoppersIfWorldEditPresent, lithium$updateHopperCachesOnNewInventoryAdded |
| top-level / `net/caffeinemc/mods/lithium/fabric/mixin/compat/worldedit/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/fabric/mixin/util/inventory_change_listening/BlockEntityMixin.java` | `value={BlockEntity.class})` | Inject:1 | emitRemovedOnSetCachedState |
| top-level / `net/caffeinemc/mods/lithium/fabric/mixin/util/inventory_change_listening/ChestBlockEntityMixin.java` | `value={ChestBlockEntity.class}, priority=999)` |  | lithium$handleSetBlockState |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/non_poi_block_search/HoglinSpecificSensorMixin.java` | `value={HoglinSpecificSensor.class})` | WrapOperation:1 | redirectFindNearestRepellent, lithium$isValidRepellent |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/non_poi_block_search/MoveToBlockGoalMixin.java` | `value={MoveToBlockGoal.class})` |  | lithium$findNearestBlock, lithium$vanillaOrderSearch, lithium$chunkAwareSearch |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/non_poi_block_search/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/non_poi_block_search/PiglinSpecificSensorMixin.java` | `value={PiglinSpecificSensor.class})` | WrapOperation:1 | redirectFindNearestRepellent, lithium$isValidRepellent |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/non_poi_block_search/RemoveBlockGoalMixin.java` | `value={RemoveBlockGoal.class})` | Redirect:1 | redirectFindNearestBlock, lithium$isValidTargetBlock, lithium$isValidTargetAbove |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/pathing/BlockStateBaseMixin.java` | `value={BlockBehaviour.BlockStateBase.class})` |  | lithium$clearPathTypeCache, lithium$initializePathNodeTypeCache, lithium$getPathNodeType, lithium$getNeighborPathNodeType |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/pathing/FlyNodeEvaluatorMixin.java` | `value={FlyNodeEvaluator.class})` | Redirect:1 | getNodeTypeFromNeighbors |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/pathing/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/pathing/PathfindingContextAccessor.java` | `value={PathfindingContext.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/pathing/PathfindingContextMixin.java` | `value={PathfindingContext.class})` | WrapOperation:2 | getWorldIfNonNull, getBlockPosIfNonNull |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/pathing/PathNavigationRegionMixin.java` | `value={PathNavigationRegion.class})` | Inject:1, Overwrite:2 | init, getBlockState, getFluidState |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/pathing/WalkNodeEvaluatorMixin.java` | `value={WalkNodeEvaluator.class}, priority=990)` | Inject:2, Redirect:1 | getLithiumCachedCommonNodeType, doNotIteratePositionsIfLithiumSinglePosCall, getNodeTypeFromNeighbors |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/poi/fast_portals/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/poi/fast_portals/PoiManagerMixin.java` | `value={PoiManager.class})` | Overwrite:1 | ensureLoadedAndValid, unpackX, packYX, lithium$getLowestEmptyOrInvalidSection |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/poi/fast_portals/PortalForcerMixin.java` | `value={PortalForcer.class})` | Overwrite:1 | findClosestPortalPosition |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/poi/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/poi/PoiManagerMixin.java` | `value={PoiManager.class})` | Overwrite:7 | getRandom, lithium$getNClosestFirstWithType, find, findClosestWithType, lithium$takeAt, findClosest, findClosest, getCountInRange, getInRange, lithium$findNearestForPortalLogic, withinSquareInL2Range |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/poi/PoiSectionMixin.java` | `value={PoiSection.class})` |  | lithium$collectMatchingPoints, lithium$getL2ClosestMatchingPoint, getL2ClosestMatchingPoint, getL2ClosestMatchingPoint, lithium$collectMatchingPointsL2Limited, collectMatchingPointsL2Limited, collectMatchingPointsL2Limited, lithium$getFirstMatchingPoint, getFirstMatchingPoint, getFirstMatchingPoint, collectWithDynamicTypeFilter, collectWithSingleTypeFilter, lithium$getAt, lithium$iterate, iterateWithSingleTypeFilter, iterateWithDynamicTypeFilter, computeNext |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/poi/SectionStorageMixin.java` | `value={SectionStorage.class})` | Inject:1 | init, onEntryRemoved, onEntryAdded, lithium$getFirstInRangeInChunkColumn, lithium$getInChunkColumn, computeNext, lithium$getNonEmptyPOISections, lithium$getElementAt, lithium$getChunkYMin, lithium$getChunkYMaxInclusive |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/poi/tasks/AcquirePoiMixin.java` | `value={AcquirePoi.class}, priority=500)` | Redirect:3 | takeOptimized, getNull, getNClosestFirstWithType |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/poi/tasks/LocateHidingPlaceMixin.java` | `value={LocateHidingPlace.class})` | Redirect:2 | useFasterPOILookup, useFasterPOILookup |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/poi/tasks/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/poi/tasks/RaiderEntityAttackHomeGoalMixin.java` | `targets={"net.minecraft.world.entity.raid.Raider$RaiderMoveThroughVillageGoal"})` | Redirect:1 | redirect |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/raid/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/raid/Raider$ObtainRaidLeaderBannerGoalMixin.java` | `value={Raider.ObtainRaidLeaderBannerGoal.class})` | Redirect:1 | getOminousBanner |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/raid/RaiderMixin.java` | `value={Raider.class})` | Redirect:1 | getOminousBanner |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/raid/RaidMixin.java` | `value={Raid.class})` | Inject:1, Overwrite:1 | onTick, updateBossbar |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/sensor/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/sensor/replace_streams/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/sensor/replace_streams/tempting/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/sensor/replace_streams/tempting/TemptingSensorMixin.java` | `value={TemptingSensor.class})` | Overwrite:1 | doTick |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/sensor/secondary_poi/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/sensor/secondary_poi/SecondaryPoiSensorMixin.java` | `value={SecondaryPoiSensor.class})` | Inject:1 | skipUselessSense |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/task/launch/BrainMixin.java` | `value={Brain.class})` | Overwrite:2, Inject:6, ModifyVariable:1 | onTasksChanged, onPossibleActivitiesChanged, initPossibleTasks, getPossibleTasks, getCurrentlyRunningTasks, initCurrentlyRunningTasks, startEachNonRunningBehavior, getRunningBehaviors, reinitializeBrainCollections, reinitializeTasksSorted, reinitializeTasksSorted, onPossibleActivitiesChanged, removeStoppedTask, removeTaskIfStopped, addStartedTasks |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/task/launch/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/task/memory_changes/BehaviorMixin.java` | `value={Behavior.class})` | Inject:1, Overwrite:1 | init, hasRequiredMemories |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/task/memory_changes/BrainMixin.java` | `value={Brain.class})` | Inject:2, ModifyArg:1, WrapOperation:3 | increaseMemoryModCount, increaseMemoryModCount, tickExpiringSlotsTrackingChanges, clearTrackingChanges, setTrackingChanges, setTrackingChanges, lithium$getMemoryValueModCount, lithium$onMemoryModified |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/task/memory_changes/MemorySlotMixin.java` | `value={MemorySlot.class})` | Inject:1 | ensureConsistency |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/task/memory_changes/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/task/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/task/replace_streams/GateBehaviorMixin.java` | `value={GateBehavior.class})` | Overwrite:2, WrapOperation:1 | tickOrStop, doStop, tryStart |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/task/replace_streams/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/task/replace_streams/RunningPolicyRunOneMixin.java` | `targets={"net.minecraft.world.entity.ai.behavior.GateBehavior$RunningPolicy$1"})` |  | lithium$apply |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/task/replace_streams/RunningPolicyTryAllMixin.java` | `targets={"net.minecraft.world.entity.ai.behavior.GateBehavior$RunningPolicy$2"})` |  | lithium$apply |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/task/replace_streams/ShufflingListMixin.java` | `value={ShufflingList.class})` |  | iterator |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/task/run/long_jump_weighted_choice/LongJumpToRandomPosMixin.java` | `value={LongJumpToRandomPos.class})` | Inject:1, WrapOperation:1, Redirect:1 | setTargets, getRandomFast, skipRemoveIfAlreadyRemoved |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/task/run/long_jump_weighted_choice/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/task/run/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/useless_behaviors/BrainMixin.java` | `value={Brain.class})` | WrapOperation:1 | filterSentinels |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/useless_behaviors/nitwit_job_search/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/useless_behaviors/nitwit_job_search/VillagerGoalPackagesMixin.java` | `value={VillagerGoalPackages.class})` | Redirect:1 | returnNullIfAcquirePoiIsUseless |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/useless_behaviors/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/useless_sensors/baby_specific_sensors/AgeableMobMixin.java` | `value={AgeableMob.class})` | Inject:2 | disableItemSensor, handleParentSensor, disableOrEnableParentSensor |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/useless_sensors/baby_specific_sensors/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/useless_sensors/BrainAccessor.java` | `value={Brain.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/useless_sensors/goat_item_sensor/GoatMixin.java` | `value={Goat.class})` | Inject:1 | disableItemSensor |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/useless_sensors/goat_item_sensor/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/useless_sensors/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/ai/useless_sensors/SensorAccessor.java` | `value={Sensor.class})` | Accessor:3 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/chunk_random/LevelMixin.java` | `value={Level.class})` |  | lithium$getRandomPosInChunk |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/chunk_random/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/chunk_random/ServerLevelMixin.java` | `value={ServerLevel.class})` | Redirect:1, ModifyArg:2 | redirectTickGetRandomPosInChunk, immutablePos, immutablePos2 |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/composter/ComposterMixin.java` | `targets={"net/minecraft/world/level/block/ComposterBlock$OutputContainer"}); targets={"net/minecraft/world/level/block/ComposterBlock$EmptyContainer"}); targets={"net/minecraft/world/level/block/ComposterBlock$InputContainer"})` | Overwrite:3 | getSlotsForFace, getSlotsForFace, getSlotsForFace |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/composter/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/deep_passengers/EntityMixin.java` | `value={Entity.class})` | Overwrite:4 | getIndirectPassengers, getIndirectPassengersStream, getSelfAndPassengers, getPassengersAndSelf, addPassengersDeep, addPassengersDeepFirst |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/deep_passengers/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/entity_iteration/ClassInstanceMultiMapAccessor.java` | `value={ClassInstanceMultiMap.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/entity_iteration/EntitySectionMixin.java` | `value={EntitySection.class})` | Redirect:1 | directIterator |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/entity_iteration/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/entity_tracker/ChunkMap$TrackedEntityMixin.java` | `value={ChunkMap.TrackedEntity.class})` | Redirect:1 | useFasterCollection |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/entity_tracker/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/enum_values/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/enum_values/piston_block/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/enum_values/piston_block/PistonBaseBlockMixin.java` | `value={PistonBaseBlock.class})` | Redirect:1 | removeAllocation |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/enum_values/piston_handler/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/enum_values/piston_handler/PistonStructureResolverMixin.java` | `value={PistonStructureResolver.class})` | Redirect:1 | removeAllocation |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/enum_values/redstone_wire/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/enum_values/redstone_wire/RedstoneWireBlockMixin.java` | `value={RedstoneWireBlock.class})` | Redirect:2 | removeAllocation1, removeAllocation2 |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/explosion_behavior/EntityBasedExplosionDamageCalculatorMixin.java` | `value={EntityBasedExplosionDamageCalculator.class})` | Overwrite:1 | getBlockExplosionResistance |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/explosion_behavior/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/nbt/CompoundTagMixin.java` | `value={CompoundTag.class}); targets={"net/minecraft/nbt/CompoundTag$1"})` | ModifyArg:1, Redirect:2, Overwrite:1, ModifyVariable:1 | useFasterCollection, removeOldMapAlloc, copy, useFasterCollection, removeOldMapAlloc |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/nbt/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/alloc/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/flatten_states/FluidStateMixin.java` | `value={FluidState.class})` | Inject:1, Overwrite:1 | initFluidCache, isEmpty |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/flatten_states/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/fluid/flow/FlowingFluidMixin.java` | `value={FlowingFluid.class})` | Redirect:1, Inject:1, Overwrite:2 | isSign, getNumIndicesFromRadius, indexFromDiamondXZOffset, getSpread, canPassThrough, isWaterHole, getBlock, removeDirectionsWithoutHoleAccess, canMaybeFlowIntoBlock, calculateComplexFluidFlowDirections, isHoleBelow |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/fluid/flow/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/fluid/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/hopper/AbstractChestBoatMixin.java` | `value={AbstractChestBoat.class}, priority=2000)` |  | rideTick, tickRidingSummarizeMovementNotifications |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/hopper/AbstractContainerMenuMixin.java` | `value={AbstractContainerMenu.class})` | Inject:1 | getFastOutputStrength |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/hopper/BlockBehaviourMixin.java` | `value={BlockBehaviour.class})` | Inject:1 | notifyOnShapeUpdate |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/hopper/ChiseledBookShelfBlockEntityMixin.java` | `value={ChiseledBookShelfBlockEntity.class})` |  | lithium$itemInsertionTestRequiresStackSize1 |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/hopper/ClassInstanceMultiMapMixin.java` | `value={ClassInstanceMultiMap.class}, priority=1010)` | Redirect:1 | isAlwaysAssignable |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/hopper/ComposterMixin.java` | `targets={"net/minecraft/world/level/block/ComposterBlock$OutputContainer"}); targets={"net/minecraft/world/level/block/ComposterBlock$EmptyContainer"}); targets={"net/minecraft/world/level/block/ComposterBlock$InputContainer"})` | Inject:1 | resetDirty |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/hopper/CompoundContainerAccessor.java` | `value={CompoundContainer.class})` | Accessor:2 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/hopper/ContainerMixin.java` | `value={Container.class})` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/hopper/EntityAccessor.java` | `value={Entity.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/hopper/EntityDataAccessorMixin.java` | `value={EntityDataAccessor.class})` | Inject:1 | updateEntityTrackerEngine |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/hopper/EntitySectionAccessor.java` | `value={EntitySection.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/hopper/HopperBlockEntityMixin.java` | `value={HopperBlockEntity.class}, priority=950)` | Redirect:5, Inject:4 | getExtractInventory, lithiumInsert, getLithiumOutputInventory, lithiumExtract, lithiumHopperIsFull, lithiumHopperIsEmpty, lithium$invalidateCacheOnNeighborUpdate, lithium$invalidateCacheOnUndirectedNeighborUpdate, lithium$invalidateCacheOnNeighborUpdate, lithium$getExtractEntityInventory, lithiumGetInputItemEntities, cacheInsertBlockInventory, cacheInsertLithiumInventory, cacheExtractLithiumInventory, cacheExtractBlockInventory, lithium$getExtractBlockInventory, lithium$getInsertBlockInventory, getInsertInventory, initCollectItemEntityTracker, initExtractInventoryTracker, initInsertInventoryTracker, invalidateOnSetCachedState, invalidateCachedData, invalidateInsertionData, invalidateBlockInsertionData, invalidateExtractionData, invalidateBlockExtractionData, checkSleepingConditions, checkSleepingConditions, lithium$handleInventoryContentModified, lithium$handleInventoryRemoved, lithium$handleComparatorAdded, lithium$handleEntityMovement |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/hopper/HopperBlockMixin.java` | `value={HopperBlock.class})` | Inject:2 | lithium$handleShapeUpdate, updateBlockEntity, updateHopper, workAroundVanillaUpdateSuppression |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/hopper/InventoryAccessors.java` | `value={AbstractMinecartContainer.class}); value={ShulkerBoxBlockEntity.class}); value={HopperBlockEntity.class}); value={DispenserBlockEntity.class}); value={ChestBlockEntity.class}); value={BrewingStandBlockEntity.class}); value={BarrelBlockEntity.class}); value={AbstractFurnaceBlockEntity.class})` | Accessor:16 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/hopper/NonNullListAccessor.java` | `value={NonNullList.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/hopper/OldMinecartBehaviorMixin.java` | `value={OldMinecartBehavior.class})` | Inject:2 | avoidNotifyingMovementListeners, notifyMovementListeners |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/hopper/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/moving_block_shapes/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/moving_block_shapes/PistonMovingBlockEntityMixin.java` | `value={PistonMovingBlockEntity.class})` | Inject:1 | skipVoxelShapeUnion, getOffsetAndSimplified, precomputePistonBaseWithMovingHeadShapes, getIndexForMergedShape |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/moving_block_shapes/VoxelShapeMixin.java` | `value={VoxelShape.class})` |  | lithium$setShape, lithium$getOffsetSimplifiedShape, getIndexForOffsetSimplifiedShapes |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/redstone_wire/DefaultRedstoneWireEvaluatorMixin.java` | `value={DefaultRedstoneWireEvaluator.class})` | Inject:1 | calculateTargetStrengthFaster |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/redstone_wire/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/redstone_wire/RedstoneWireBlockMixin.java` | `value={RedstoneWireBlock.class})` | Inject:1 | getBlockSignalFaster |
| top-level / `net/caffeinemc/mods/lithium/mixin/block/redstone_wire/RedstoneWireEvaluatorMixin.java` | `value={RedstoneWireEvaluator.class})` | Inject:1 | getIncomingWireSignalFaster |
| top-level / `net/caffeinemc/mods/lithium/mixin/block_pattern_matching/BlockPatternMixin.java` | `value={BlockPattern.class})` | Inject:1 | countRequiredBlocksBeforeExpensiveSearch, lithium$setRequiredBlock |
| top-level / `net/caffeinemc/mods/lithium/mixin/block_pattern_matching/EnderDragonFightMixin.java` | `value={EnderDragonFight.class})` | Inject:1 | setPatternToDragonPattern |
| top-level / `net/caffeinemc/mods/lithium/mixin/block_pattern_matching/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/cached_hashcode/FlowingFluid$BlockStatePairKeyMixin.java` | `value={FlowingFluid.BlockStatePairKey.class})` | Inject:1, Overwrite:1 | generateHash, hashCode |
| top-level / `net/caffeinemc/mods/lithium/mixin/cached_hashcode/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/chunk/entity_class_groups/ClassInstanceMultiMapMixin.java` | `value={ClassInstanceMultiMap.class})` | ModifyVariable:2 | add, remove, lithium$getAllOfGroupType, createAllOfGroupType |
| top-level / `net/caffeinemc/mods/lithium/mixin/chunk/entity_class_groups/ClientLevelMixin.java` | `value={ClientLevel.class})` |  | lithium$getEntityManager |
| top-level / `net/caffeinemc/mods/lithium/mixin/chunk/entity_class_groups/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/chunk/no_locking/LevelChunkSectionMixin.java` | `value={LevelChunkSection.class})` | Redirect:1 | setBlockStateNoLocking |
| top-level / `net/caffeinemc/mods/lithium/mixin/chunk/no_locking/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/chunk/no_locking/PalettedContainerMixin.java` | `value={PalettedContainer.class})` | Inject:1, Overwrite:2 | removeLockHelper, acquire, release |
| top-level / `net/caffeinemc/mods/lithium/mixin/chunk/no_validation/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/chunk/no_validation/SimpleBitStorageMixin.java` | `value={SimpleBitStorage.class})` | Redirect:1 | skipValidation |
| top-level / `net/caffeinemc/mods/lithium/mixin/chunk/no_validation/ZeroBitStorageMixin.java` | `value={ZeroBitStorage.class})` | Redirect:1 | skipValidation |
| top-level / `net/caffeinemc/mods/lithium/mixin/chunk/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/chunk/palette/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/chunk/palette/StrategyMixin.java` | `value={Strategy.class}); targets={"net/minecraft/world/level/chunk/Strategy$2"}); targets={"net/minecraft/world/level/chunk/Strategy$1"})` | ModifyExpressionValue:6 | getHash3Bit, getHash4Bit, getHash5Bit, getHash6Bit, getHash7Bit, getHash8Bit |
| top-level / `net/caffeinemc/mods/lithium/mixin/chunk/serialization/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/chunk/serialization/PalettedContainerMixin.java` | `value={PalettedContainer.class}, priority=50)` | Overwrite:1, WrapOperation:1, ModifyArg:1, Inject:1 | pack, asOptional, getOrCreate, returnDummyInstance, getFastCountingLambda, fastForEachAndCancelMethod |
| top-level / `net/caffeinemc/mods/lithium/mixin/chunk/serialization/SimpleBitStorageMixin.java` | `value={SimpleBitStorage.class})` |  | lithium$compact |
| top-level / `net/caffeinemc/mods/lithium/mixin/client_tick/entity/base_tick/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/client_tick/entity/base_tick/unused_ambient_sound/MobMixin.java` | `value={Mob.class})` | ModifyExpressionValue:1 | andIsServerSide |
| top-level / `net/caffeinemc/mods/lithium/mixin/client_tick/entity/base_tick/unused_ambient_sound/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/client_tick/entity/base_tick/unused_water_supply/AgeableWaterCreatureMixin.java` | `value={AgeableWaterCreature.class})` | WrapWithCondition:1 | isServerSide |
| top-level / `net/caffeinemc/mods/lithium/mixin/client_tick/entity/base_tick/unused_water_supply/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/client_tick/entity/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/client_tick/entity/unused_brain/AllayMixin.java` | `value={Allay.class})` | WrapWithCondition:1 | isServerSide |
| top-level / `net/caffeinemc/mods/lithium/mixin/client_tick/entity/unused_brain/BrainMixin.java` | `value={Brain.class})` |  | lithium$pretendAllMemoryTypesRegistered |
| top-level / `net/caffeinemc/mods/lithium/mixin/client_tick/entity/unused_brain/CopperGolemMixin.java` | `value={CopperGolem.class})` | WrapWithCondition:1 | isServerSide |
| top-level / `net/caffeinemc/mods/lithium/mixin/client_tick/entity/unused_brain/LivingEntityMixin.java` | `value={LivingEntity.class})` | WrapOperation:1 | doNotCreateClientBrain |
| top-level / `net/caffeinemc/mods/lithium/mixin/client_tick/entity/unused_brain/MemorySlotMixin.java` | `value={MemorySlot.class})` | Inject:1 | cancelIfDummyMemorySlot, throwOnModifyDummyMemorySlot |
| top-level / `net/caffeinemc/mods/lithium/mixin/client_tick/entity/unused_brain/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/client_tick/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/client_tick/particle/biome_particles/AmbientParticleSettingsMixin.java` | `value={AmbientParticle.class})` | Inject:1, ModifyExpressionValue:1 | findMaximumChance, getAdjustedProbability |
| top-level / `net/caffeinemc/mods/lithium/mixin/client_tick/particle/biome_particles/ClientLevelMixin.java` | `value={ClientLevel.class})` | Redirect:1 | evaluateChanceEarly |
| top-level / `net/caffeinemc/mods/lithium/mixin/client_tick/particle/biome_particles/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/client_tick/particle/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/attributes/AttributeMapMixin.java` | `value={AttributeMap.class})` | Inject:1 | initCollections |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/attributes/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/block_entity_tickers/LevelChunkMixin.java` | `value={LevelChunk.class})` | Inject:1 | createFastUtilMap |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/block_entity_tickers/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/brain/BrainMixin.java` | `value={Brain.class})` | Inject:1 | reinitializeBrainCollections |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/brain/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/chunk_tickets/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/chunk_tickets/SortedArraySetMixin.java` | `value={SortedArraySet.class})` |  | removeIf |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/entity_by_type/ClassInstanceMultiMapMixin.java` | `value={ClassInstanceMultiMap.class})` | Inject:1 | init |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/entity_by_type/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/entity_filtering/ClassInstanceMultiMapMixin.java` | `value={ClassInstanceMultiMap.class})` | Overwrite:1 | find, createAllOfType |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/entity_filtering/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/entity_ticking/EntityTickListMixin.java` | `value={EntityTickList.class})` | Overwrite:1 | ensureActiveIsNotIterated |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/entity_ticking/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/mob_spawning/MobSpawnSettingsMixin.java` | `value={MobSpawnSettings.class})` | Inject:1 | reinit |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/mob_spawning/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/mob_spawning/WeightedListMixin.java` | `value={WeightedList.class})` | Redirect:1 | init |
| top-level / `net/caffeinemc/mods/lithium/mixin/collections/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/debug/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/debug/palette/ClientBoundLevelChunkPacketDataAccessor.java` | `value={ClientboundLevelChunkPacketData.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/debug/palette/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | WrapOperation:1 | addExceptionInfo |
| top-level / `net/caffeinemc/mods/lithium/mixin/debug/palette/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/debug/palette/PalettedContainerMixin.java` | `value={PalettedContainer.class})` | Inject:1 | checkConsistency |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/collisions/block_effects/InsideBlockEffectApplier$StepBasedCollectorMixin.java` | `value={InsideBlockEffectApplier.StepBasedCollector.class})` | Inject:2, WrapOperation:8, ModifyReceiver:1, WrapWithCondition:2 | trySkip, avoidAlloc, avoidAlloc, avoidAlloc, replaceNull, isNotNull, isNotNull2, getOrNull, removeOrFalse, addAllNonNull, init, initBeforeAndGet, initAfterAndGet |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/collisions/block_effects/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/collisions/intersection/EntityGetterMixin.java` | `value={EntityGetter.class})` | Redirect:1 | getCollisionEntities |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/collisions/intersection/LevelMixin.java` | `value={Level.class})` |  | noCollision, findSupportingBlock |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/collisions/intersection/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/collisions/movement/EntityMixin.java` | `value={Entity.class})` | Redirect:2, ModifyArg:1, Overwrite:1 | postponeGetEntities, collideMovementWithPostponedGetEntities, collectEntities, collideBoundingBox, lithium$CollideMovement |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/collisions/movement/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/collisions/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/collisions/unpushable_cramming/AbstractBoatMixin.java` | `value={AbstractBoat.class})` | Redirect:1 | getOtherPushableEntities |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/collisions/unpushable_cramming/EntityMixin.java` | `value={Entity.class})` | Inject:3 | onPositionChanged, onBaseTick, onBlockCached, lithium$getCachedFeetBlockState |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/collisions/unpushable_cramming/EntitySectionMixin.java` | `value={EntitySection.class})` | Inject:2 | lithium$collectPushableEntities, startFilteringPushableEntities, stopFilteringPushableEntities, lithium$onEntityModifiedCachedBlock, updatePushabilityOnCachedStateChange, onStartClimbingCachingEntity, onEntityAdded, onEntityRemoved, entityPushableHeuristic |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/collisions/unpushable_cramming/EntitySelectorMixin.java` | `value={EntitySelector.class})` | Redirect:1 | getEntityPushablePredicate |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/collisions/unpushable_cramming/LevelMixin.java` | `value={Level.class})` | Redirect:1 | getOtherPushableEntities |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/collisions/unpushable_cramming/LivingEntityMixin.java` | `value={LivingEntity.class})` |  | lithium$SetClimbingMobCachingSectionUpdateBehavior, lithium$OnFeetBlockCacheDeleted, lithium$OnFeetBlockCacheSet, updateClimbingMobCachingSection |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/collisions/unpushable_cramming/OldMinecartBehaviorMixin.java` | `value={OldMinecartBehavior.class})` | Redirect:1 | getOtherPushableEntities |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/collisions/unpushable_cramming/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/equipment_tracking/enchantment_ticking/LivingEntityMixin.java` | `value={LivingEntity.class})` | WrapWithCondition:1 | maybeHasAnyTickableEnchantments |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/equipment_tracking/enchantment_ticking/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/equipment_tracking/EntityEquipmentMixin.java` | `value={EntityEquipment.class})` | WrapMethod:1, Inject:3 | lithium$isInLevel, lithium$handleAddedToLevel, lithium$handleRemovedFromLevel, lithium$shouldTickEnchantments, lithium$hasUnsentEquipmentChanges, lithium$onEquipmentChangesSent, updateOnSet, updateBeforeSetAll, updateAfterSetAll, updateOnClear, invalidateData, initializeData, onEquipmentReplaced, stackHasTickableEnchantment, lithium$notify, scheduleEnchantmentCheck, processScheduledEnchantmentCheck, lithium$notifyCount, lithium$forceUnsubscribe |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/equipment_tracking/equipment_changes/LivingEntityMixin.java` | `value={LivingEntity.class})` | Inject:2 | skipSentEquipmentComparison, resetEquipmentChanged |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/equipment_tracking/equipment_changes/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/equipment_tracking/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/fast_elytra_check/LivingEntityMixin.java` | `value={LivingEntity.class})` | Inject:1 | skipStopFlying |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/fast_elytra_check/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/fast_powder_snow_check/LivingEntityMixin.java` | `value={LivingEntity.class})` | Redirect:3 | delayGetBlockState, delayAirTest, doDelayedBlockStateAirTest |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/fast_powder_snow_check/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/fast_retrieval/EntitySectionStorageMixin.java` | `value={EntitySectionStorage.class})` | Inject:1 | forEachInBox, forEachInColumn, consumeSection |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/fast_retrieval/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/framed_maps/MapItemSavedDataMixin.java` | `value={MapItemSavedData.class})` | WrapOperation:2 | sizeOrOne, getOrGetThePlayer |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/framed_maps/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/inactive_navigations/HappyGhastMixin.java` | `value={HappyGhast.class})` | Inject:2 | updateRegisteredNavigation, updateRegisteredNavigation1 |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/inactive_navigations/LivingEntityMixin.java` | `value={LivingEntity.class})` | Inject:1 | handleStopRiding |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/inactive_navigations/MobMixin.java` | `value={Mob.class})` | Inject:1 | lithium$isRegisteredToWorld, lithium$setRegisteredToWorld, lithium$getRegisteredNavigation, onNavigationReplacement, lithium$updateNavigationRegistration |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/inactive_navigations/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/inactive_navigations/PathNavigationMixin.java` | `value={PathNavigation.class})` | Inject:3 | updateListeningState, updateListeningState2, stopListening |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/inactive_navigations/ServerLevel$EntityCallbacksMixin.java` | `value={ServerLevel.EntityCallbacks.class})` | Inject:1, Redirect:2 | inj, startListeningOnEntityLoad, stopListeningOnEntityUnload |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/inactive_navigations/ServerLevelMixin.java` | `value={ServerLevel.class})` | Redirect:1, Inject:2 | getActiveListeners, init, lithium$setNavigationActive, lithium$setNavigationInactive, updateActiveListeners, areEntityNavigationsConsistent |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/projectile_projectile_collisions/AbstractArrowMixin.java` | `value={AbstractArrow.class})` | ModifyExpressionValue:1 | getTypedPredicate |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/projectile_projectile_collisions/AbstractHurtingProjectileMixin.java` | `value={AbstractHurtingProjectile.class})` | ModifyExpressionValue:1 | getTypedPredicate |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/projectile_projectile_collisions/FireworkRocketEntityMixin.java` | `value={FireworkRocketEntity.class})` | ModifyExpressionValue:1 | getTypedPredicate |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/projectile_projectile_collisions/FishingHookMixin.java` | `value={FishingHook.class})` | ModifyExpressionValue:1 | getTypedPredicate |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/projectile_projectile_collisions/LlamaSpitMixin.java` | `value={LlamaSpit.class})` | ModifyExpressionValue:1 | getTypedPredicate |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/projectile_projectile_collisions/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/projectile_projectile_collisions/ProjectileUtilMixin.java` | `value={ProjectileUtil.class})` | WrapOperation:1 | getEntitiesForCollision |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/projectile_projectile_collisions/ShulkerBulletMixin.java` | `value={ShulkerBullet.class})` | ModifyExpressionValue:1 | getTypedPredicate |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/projectile_projectile_collisions/ThrowableProjectileMixin.java` | `value={ThrowableProjectile.class})` | ModifyExpressionValue:1 | getTypedPredicate |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/replace_entitytype_predicates/ArmorStandMixin.java` | `value={ArmorStand.class})` | Redirect:1 | getMinecartsDirectly |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/replace_entitytype_predicates/GolemRandomStrollInVillageGoalMixin.java` | `value={GolemRandomStrollInVillageGoal.class})` | Redirect:1 | getEntities |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/replace_entitytype_predicates/LlamaFollowCaravanGoalMixin.java` | `value={LlamaFollowCaravanGoal.class})` | Redirect:1 | getLlamasForCaravan |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/replace_entitytype_predicates/OldMinecartBehaviorMixin.java` | `value={OldMinecartBehavior.class})` | Redirect:1 | getOtherAbstractMinecarts |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/replace_entitytype_predicates/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/sprinting_particles/EntityMixin.java` | `value={Entity.class})` | Redirect:1 | skipParticlesOnServerSide |
| top-level / `net/caffeinemc/mods/lithium/mixin/entity/sprinting_particles/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/experimental/entity/block_caching/block_support/EntityMixin.java` | `value={Entity.class})` | Inject:4 | cancelIfSkippable, cacheSupportingBlockSearch, uncacheSupportingBlockSearch, uncacheSupportingBlockSearch1, lithium$getCollisionShapeBelow |
| top-level / `net/caffeinemc/mods/lithium/mixin/experimental/entity/block_caching/block_support/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/experimental/entity/block_caching/EntityMixin.java` | `value={Entity.class})` | Inject:1 | lithium$getVicinityCache, removeVicinityCache |
| top-level / `net/caffeinemc/mods/lithium/mixin/experimental/entity/block_caching/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/experimental/entity/block_caching/suffocation/EntityMixin.java` | `value={Entity.class})` | Inject:1 | isInsideWall |
| top-level / `net/caffeinemc/mods/lithium/mixin/experimental/entity/block_caching/suffocation/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/experimental/entity/item_entity_merging/ItemEntityMixin.java` | `value={ItemEntity.class})` | Redirect:1 | getItems, consumeItemEntitiesForMerge |
| top-level / `net/caffeinemc/mods/lithium/mixin/experimental/entity/item_entity_merging/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/experimental/entity/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/experimental/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/gen/cached_generator_settings/NoiseBasedChunkGeneratorMixin.java` | `value={NoiseBasedChunkGenerator.class})` | Overwrite:1 | getSeaLevel |
| top-level / `net/caffeinemc/mods/lithium/mixin/gen/cached_generator_settings/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/gen/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/math/fast_blockpos/BlockPosMixin.java` | `value={BlockPos.class})` | Overwrite:12 | above, above, below, below, north, north, south, south, west, west, east, east |
| top-level / `net/caffeinemc/mods/lithium/mixin/math/fast_blockpos/DirectionMixin.java` | `value={Direction.class})` | Inject:1, Overwrite:3 | reinit, getStepX, getStepY, getStepZ |
| top-level / `net/caffeinemc/mods/lithium/mixin/math/fast_blockpos/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/math/fast_util/AABBMixin.java` | `value={AABB.class})` | Overwrite:2 | min, max |
| top-level / `net/caffeinemc/mods/lithium/mixin/math/fast_util/AxisCycleDirectionMixin.java` | `targets={"net/minecraft/core/AxisCycle$3"}); targets={"net/minecraft/core/AxisCycle$2"})` | Overwrite:2 | cycle, cycle |
| top-level / `net/caffeinemc/mods/lithium/mixin/math/fast_util/DirectionMixin.java` | `value={Direction.class})` | Overwrite:2 | getOpposite, getRandom |
| top-level / `net/caffeinemc/mods/lithium/mixin/math/fast_util/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/math/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/math/sine_lut/MthMixin.java` | `value={Mth.class})` | Inject:1, Overwrite:2 | onClassInit, sin, cos |
| top-level / `net/caffeinemc/mods/lithium/mixin/math/sine_lut/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/ai/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/ai/sensor/frog_attackables/FrogAttackablesSensorMixin.java` | `value={FrogAttackablesSensor.class})` | Redirect:2 | checkTypeAndPredicate, skipCheckTypeAgain |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/ai/sensor/frog_attackables/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/ai/sensor/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/collisions/empty_space/ArrayVoxelShapeInvoker.java` | `value={ArrayVoxelShape.class})` | Invoker:1 | init |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/collisions/empty_space/BitSetDiscreteVoxelShapeAccessor.java` | `value={BitSetDiscreteVoxelShape.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/collisions/empty_space/LevelMixin.java` | `value={Level.class})` |  | findFreePosition |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/collisions/empty_space/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/collisions/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/spawning/EntitySectionAccessor.java` | `value={EntitySection.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/spawning/EntitySectionStorageMixin.java` | `value={EntitySectionStorage.class})` |  | lithium$IterateEntitiesInTrackedSections, computeNext |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/spawning/NaturalSpawnerMixin.java` | `value={NaturalSpawner.class})` | Redirect:1 | iterateEntitiesChunkAware |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/spawning/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/spawning/PersistentEntitySectionManagerAccessor.java` | `value={PersistentEntitySectionManager.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/spawning/ServerLevelAccessor.java` | `value={ServerLevel.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/world/block_entity_ticking/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/world/block_entity_ticking/support_cache/BlockEntityMixin.java` | `value={BlockEntity.class})` | Inject:2 | initSupportCache, updateSupportCache, lithium$isSupported |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/world/block_entity_ticking/support_cache/DirectBlockEntityTickInvokerMixin.java` | `targets={"net/minecraft/world/level/chunk/LevelChunk$BoundTickingBlockEntity"})` | Redirect:2 | getCachedState, cachedIsSupported |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/world/block_entity_ticking/support_cache/LevelChunkMixin.java` | `value={LevelChunk.class})` | Redirect:1, Inject:1 | createBlockEntityWithCachedStateFix, fixCachedState |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/world/block_entity_ticking/support_cache/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/world/expiring_chunk_tickets/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/world/expiring_chunk_tickets/TicketStorageMixin.java` | `value={TicketStorage.class})` | Inject:3, ModifyReceiver:1, ModifyExpressionValue:1 | canNoneExpire, registerExpiringTicket, unregisterExpiringTicket, getExpiringTicketsByPosition, removeIfNoTickables, fixOtherCollection |
| top-level / `net/caffeinemc/mods/lithium/mixin/minimal_nonvanilla/world/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/profiler/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/profiler/ProfilerMixin.java` | `value={Profiler.class})` | WrapMethod:1, Inject:2 | lithium$getProfiler, getProfilerFromFields, placeProfilerInStaticFields, removeProfilerFromStaticFields |
| top-level / `net/caffeinemc/mods/lithium/mixin/shapes/blockstate_cache/BlockMixin.java` | `value={Block.class})` | Overwrite:1 | isShapeFullBlock |
| top-level / `net/caffeinemc/mods/lithium/mixin/shapes/blockstate_cache/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/shapes/lazy_shape_context/EntityCollisionContextMixin.java` | `value={EntityCollisionContext.class})` | ModifyConstant:1, Inject:5, WrapOperation:1 | redirectInstanceOf, initFields, isHolding, getHeldItem, initHeldItem, initHeldItem, skipIsDescending, initVars, initIsDescending |
| top-level / `net/caffeinemc/mods/lithium/mixin/shapes/lazy_shape_context/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/shapes/optimized_matching/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/shapes/optimized_matching/ShapesMixin.java` | `value={Shapes.class})` | Inject:1 | cuboidMatchesAnywhere |
| top-level / `net/caffeinemc/mods/lithium/mixin/shapes/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/shapes/precompute_shape_arrays/CubePointRangeMixin.java` | `value={CubePointRange.class})` | Inject:1, Overwrite:1 | initScale, getDouble |
| top-level / `net/caffeinemc/mods/lithium/mixin/shapes/precompute_shape_arrays/CubeVoxelShapeMixin.java` | `value={CubeVoxelShape.class})` | Inject:1, Overwrite:1 | onConstructed, getCoords |
| top-level / `net/caffeinemc/mods/lithium/mixin/shapes/precompute_shape_arrays/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/shapes/shape_merging/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/shapes/shape_merging/ShapesMixin.java` | `value={Shapes.class})` | Inject:1 | injectCustomListPair |
| top-level / `net/caffeinemc/mods/lithium/mixin/shapes/specialized_shapes/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/shapes/specialized_shapes/ShapesMixin.java` | `value={Shapes.class})` | Overwrite:1 | create |
| top-level / `net/caffeinemc/mods/lithium/mixin/shapes/specialized_shapes/VoxelShapeMixin.java` | `value={VoxelShape.class})` | Overwrite:2 | collideX, findIndex |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/accessors/EntitySectionAccessor.java` | `value={EntitySection.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/accessors/ItemEntityAccessor.java` | `value={ItemEntity.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/accessors/LevelAccessor.java` | `value={Level.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/accessors/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/accessors/PersistentEntitySectionManagerAccessor.java` | `value={PersistentEntitySectionManager.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/accessors/ServerLevelAccessor.java` | `value={ServerLevel.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/accessors/StrategyAccessor.java` | `value={Strategy.class})` | Invoker:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/accessors/TransientEntitySectionManagerAccessor.java` | `value={TransientEntitySectionManager.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/block_entity_retrieval/LevelMixin.java` | `value={Level.class})` |  | lithium$getLoadedExistingBlockEntity |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/block_entity_retrieval/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/block_tracking/BlockStateBaseMixin.java` | `value={BlockBehaviour.BlockStateBase.class}, priority=1010)` |  | lithium$initializeFlags, lithium$resetFlags, lithium$getAllFlags, handleUninitializedBlockStateFlags, lithium$getAllFlagsOrNull |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/block_tracking/LevelChunkSection$BlockCounterMixin.java` | `targets={"net.minecraft.world.level.chunk.LevelChunkSection$1BlockCounter"})` | Inject:1 | lithium$initBlockCounter, acceptLithium, addToFlagCount |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/block_tracking/LevelChunkSectionMixin.java` | `value={LevelChunkSection.class})` | Inject:4, ModifyArg:1 | initAirSection, initLithiumBlockCounter, createFlagCounters, resetData, updateFlagCounters, lithium$getCount, lithium$mayContainAny, fastInitClientCounts, lithium$trackBlockStateChange, lithium$addToCallback, lithium$removeFromCallback |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/block_tracking/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/chunk_access/LevelReaderMixin.java` | `value={LevelReader.class})` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/chunk_access/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/chunk_access/PathNavigationRegionMixin.java` | `value={PathNavigationRegion.class})` |  | lithium$getLoadedChunk |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/chunk_status_tracking/ChunkHolderMixin.java` | `value={ChunkHolder.class}, priority=1010)` | Inject:1 | trackUpdate |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/chunk_status_tracking/LevelChunkMixin.java` | `value={LevelChunk.class})` | Inject:1 | onChunkFull |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/chunk_status_tracking/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/data_storage/LevelMixin.java` | `value={Level.class})` | Inject:1 | initLithiumData, lithium$getData |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/data_storage/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/entity_collection_replacement/ClassInstanceMultiMapMixin.java` | `value={ClassInstanceMultiMap.class})` |  | lithium$getOrCreateAllOfTypeRaw, lithium$replaceCollectionAndGet, lithium$replaceCollectionAndGet |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/entity_collection_replacement/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/entity_movement_tracking/EntitySectionMixin.java` | `value={EntitySection.class})` | ModifyReturnValue:1, ModifyVariable:1 | lithium$addListener, lithium$removeListener, lithium$trackEntityMovement, lithium$getChangeTime, modifyIsEmpty, swapStatus, lithium$listenToMovementOnce, lithium$removeListenToMovementOnce |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/entity_movement_tracking/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/entity_movement_tracking/PersistentEntitySectionManagerAccessor.java` | `value={PersistentEntitySectionManager.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/entity_movement_tracking/ServerEntityManagerListenerMixin.java` | `targets={"net/minecraft/world/level/entity/PersistentEntitySectionManager$Callback"})` | Inject:4 | init, updateEntityTrackerEngine, onAddEntity, onRemoveEntity, notifyMovementListeners, lithium$setNotificationMask |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/entity_movement_tracking/ServerLevelAccessor.java` | `value={ServerLevel.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/entity_section_position/EntitySectionMixin.java` | `value={EntitySection.class})` |  | lithium$setPos, lithium$getPos |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/entity_section_position/EntitySectionStorageMixin.java` | `value={EntitySectionStorage.class})` | Inject:1 | rememberPos |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/entity_section_position/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/in_world_tracking/entity/EntityMixin.java` | `value={Entity.class})` | Inject:1 | lithium$isInLevel, emitMaybeInLevelEvents |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/in_world_tracking/entity/LivingEntityMixin.java` | `value={LivingEntity.class})` |  | lithium$handleAddedToLevel, lithium$handleRemovedFromLevel |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/in_world_tracking/entity/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/in_world_tracking/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/initialization/MappedRegistryMixin.java` | `value={MappedRegistry.class})` | Inject:1 | invalidateBlockInfo |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/initialization/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/inventory_change_listening/BaseContainerBlockEntityMixin.java` | `value={BaseContainerBlockEntity.class})` |  | lithium$emitContentModified, lithium$emitStackListReplaced, lithium$emitRemoved, invalidateChangeListening, lithium$emitFirstComparatorAdded, lithium$forwardContentChangeOnce, lithium$forwardMajorInventoryChanges, lithium$stopForwardingMajorInventoryChanges |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/inventory_change_listening/BlockEntityMixin.java` | `value={BlockEntity.class})` | Inject:1 | updateStackListTracking |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/inventory_change_listening/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/inventory_change_listening/StackListReplacementTracking.java` | `value={ShulkerBoxBlockEntity.class}); value={HopperBlockEntity.class}); value={DispenserBlockEntity.class}); value={ChestBlockEntity.class}); value={BarrelBlockEntity.class}); value={BaseContainerBlockEntity.class}); value={BrewingStandBlockEntity.class}); value={AbstractFurnaceBlockEntity.class})` | Inject:6 | setInventoryStackListReplacement, setInventoryStackListReplacement, setInventoryStackListReplacement, setInventoryStackListReplacement, setInventoryStackListReplacement, readNbtStackListReplacement |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/inventory_comparator_tracking/BlockEntityMixin.java` | `value={BlockEntity.class})` | Inject:2 | init, lithium$onComparatorAdded, lithium$hasAnyComparatorNearby, forgetNearbyComparators |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/inventory_comparator_tracking/DiodeBlockMixin.java` | `value={DiodeBlock.class})` | Inject:1 | notifyOnBlockAdded |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/inventory_comparator_tracking/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/item_component_and_count_tracking/ItemEntityMixin.java` | `value={ItemEntity.class})` | Inject:1 | startTrackingChanges, lithium$subscribe, lithium$unsubscribe, lithium$notify, lithium$forceUnsubscribe, lithium$notifyCount, beforeSetStack |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/item_component_and_count_tracking/ItemStackMixin.java` | `value={ItemStack.class})` | Inject:2 | lithium$subscribe, lithium$unsubscribe, lithium$unsubscribeWithData, lithium$isSubscribedWithData, lithium$forceUnsubscribe, startTrackingChanges, beforeChangeCount, lithium$notify, onSetComponent |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/item_component_and_count_tracking/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/item_component_and_count_tracking/PatchedDataComponentMapMixin.java` | `value={PatchedDataComponentMap.class})` | Inject:1 | lithium$subscribe, lithium$unsubscribe, trackBeforeChange |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/section_data_storage/LevelChunkSectionMixin.java` | `value={LevelChunkSection.class})` |  | lithium$getSectionData, lithium$getSectionDataDirect |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/section_data_storage/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/world_border_listener/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/util/world_border_listener/WorldBorderMixin.java` | `value={WorldBorder.class})` | Inject:2, WrapOperation:1 | registerSimpleWorldBorderListenerMulti, addSimpleListenerOnce, getUpdatedArea |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/chunk_tickable/LevelMixin.java` | `value={Level.class})` | Inject:1, Redirect:1 | initPos, optimizedShouldTick |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/chunk_tickable/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/BlockEntityMixin.java` | `value={BlockEntity.class})` | Inject:1 | handleSetChanged |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/brewing_stand/BrewingStandBlockEntityMixin.java` | `value={BrewingStandBlockEntity.class})` | Inject:3 | lithium$getTickWrapper, lithium$setTickWrapper, lithium$getSleepingTicker, lithium$setSleepingTicker, checkSleep, wakeUpOnMarkDirty, checkSleep, wakeUpAfterFromTag, lithium$handleSetChanged |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/brewing_stand/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/campfire/CampfireBlockEntityMixin.java` | `value={CampfireBlockEntity.class})` | Inject:2 | lithium$getTickWrapper, lithium$setTickWrapper, lithium$getSleepingTicker, lithium$setSleepingTicker, wakeUpOnAddItem, wakeUpOnReadNbt |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/campfire/lit/CampfireBlockEntityMixin.java` | `value={CampfireBlockEntity.class})` | Inject:1 | trySleepLit |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/campfire/lit/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/campfire/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/campfire/unlit/CampfireBlockEntityMixin.java` | `value={CampfireBlockEntity.class})` | Inject:1 | trySleepUnlit |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/campfire/unlit/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/chest_animation/ChestBlockEntityMixin.java` | `value={ChestBlockEntity.class})` | Inject:2 | lithium$getTickWrapper, lithium$setTickWrapper, lithium$getSleepingTicker, lithium$setSleepingTicker, wakeUpOnSyncedBlockEvent, sleepOnAnimationEnd, checkSleep |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/chest_animation/EnderChestBlockEntityMixin.java` | `value={EnderChestBlockEntity.class})` | Inject:2 | lithium$getTickWrapper, lithium$setTickWrapper, lithium$getSleepingTicker, lithium$setSleepingTicker, wakeUpOnSyncedBlockEvent, sleepOnAnimationEnd, checkSleep |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/chest_animation/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/crafter/CrafterBlockEntityMixin.java` | `value={CrafterBlockEntity.class})` | Inject:2 | lithium$getTickWrapper, lithium$setTickWrapper, lithium$getSleepingTicker, lithium$setSleepingTicker, checkSleep, checkSleep, wakeUpAfterRemainingTicksChanged, lithium$handleSetChanged |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/crafter/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/furnace/AbstractFurnaceBlockEntityMixin.java` | `value={AbstractFurnaceBlockEntity.class})` | Inject:3 | lithium$getTickWrapper, lithium$setTickWrapper, lithium$getSleepingTicker, lithium$setSleepingTicker, checkSleep, isLit, checkSleep, wakeUpAfterFromTag, handleSetChanged, lithium$handleSetChanged |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/furnace/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/hopper/HopperBlockEntityMixin.java` | `value={HopperBlockEntity.class})` | Inject:2 | sleepIfNoCooldownAndLocked, lithium$getTickWrapper, lithium$setTickWrapper, lithium$getSleepingTicker, lithium$setSleepingTicker, lithium$startSleeping, wakeUpOnCooldownSet |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/hopper/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/LevelChunkMixin.java` | `value={LevelChunk.class})` | Inject:2 | setBlockEntityTickingOrder, setBlockEntityTickingOrder |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/LevelMixin.java` | `value={Level.class})` | WrapOperation:1 | shouldTickBlockPosFilterNull |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/sculk_catalyst/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/sculk_catalyst/SculkCatalystBlockEntityMixin.java` | `value={SculkCatalystBlockEntity.class})` | Inject:3 | lithium$getTickWrapper, lithium$setTickWrapper, lithium$getSleepingTicker, lithium$setSleepingTicker, addCatalystListenerCallback, sleepIfNoCursors, wakeupIfLoadedWithData |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/sculk_catalyst/SculkSpreaderMixin.java` | `value={SculkSpreader.class})` | Inject:1 | listenToCursorAddition, lithium$setGameEventCallback |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/sculk_sensor_shrieker/CalibratedSculkSensorBlockMixin.java` | `value={CalibratedSculkSensorBlock.class})` | Inject:1 | checkSleep |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/sculk_sensor_shrieker/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/sculk_sensor_shrieker/SculkSensorBlockEntityMixin.java` | `value={SculkSensorBlockEntity.class})` | Inject:2 | lithium$getTickWrapper, lithium$setTickWrapper, lithium$getSleepingTicker, lithium$setSleepingTicker, setVibrationListenerListener, wakeupIfLoadedWithData |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/sculk_sensor_shrieker/SculkSensorBlockMixin.java` | `value={SculkSensorBlock.class})` | Inject:1 | checkSleep |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/sculk_sensor_shrieker/SculkShriekerBlockEntityMixin.java` | `value={SculkShriekerBlockEntity.class})` | Inject:2 | lithium$getTickWrapper, lithium$setTickWrapper, lithium$getSleepingTicker, lithium$setSleepingTicker, setVibrationListenerListener, wakeupIfLoadedWithData |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/sculk_sensor_shrieker/SculkShriekerBlockMixin.java` | `value={SculkShriekerBlock.class})` | Inject:1 | checkSleep |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/sculk_sensor_shrieker/VibrationSystemListenerMixin.java` | `value={VibrationSystem.Listener.class})` | Inject:1 | lithium$setGameEventCallback, onCurrentVibrationUpdate |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/ServerLevelMixin.java` | `value={ServerLevel.class})` | Redirect:1 | getPosOrOrigin |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/shulker_box/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/shulker_box/ShulkerBoxBlockEntityMixin.java` | `value={ShulkerBoxBlockEntity.class})` | Inject:2 | lithium$getTickWrapper, lithium$setTickWrapper, lithium$getSleepingTicker, lithium$setSleepingTicker, wakeUpOnSyncedBlockEvent, sleepOnAnimationEnd |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/sleeping/WrappedBlockEntityTickInvokerAccessor.java` | `targets={"net/minecraft/world/level/chunk/LevelChunk$RebindableTickingBlockEntityWrapper"})` | Invoker:1, Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/world_border/DirectBlockEntityTickInvokerMixin.java` | `targets={"net/minecraft/world/level/chunk/LevelChunk$BoundTickingBlockEntity"})` | Redirect:1 | cachedCanTickBlockEntity, isInsideWorldBorder, startWorldBorderCaching, lithium$onWorldBorderShapeChange |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/world_border/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/chunk_access/ChunkHolderMixin.java` | `value={ChunkHolder.class})` |  | lithium$updateLastAccessTime |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/chunk_access/GenerationChunkHolderAccessor.java` | `value={GenerationChunkHolder.class})` | Accessor:1, Invoker:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/chunk_access/LevelMixin.java` | `value={Level.class})` | Overwrite:2 | getChunkAt, getChunk, getChunk, getChunk, getChunkForCollisions |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/chunk_access/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/chunk_access/ServerChunkCacheMixin.java` | `value={ServerChunkCache.class})` | Inject:2, Overwrite:1 | preTick, getChunk, getChunkOffThread, getChunkBlocking, createChunkLoadTicket, createCacheKey, addToCache, onCachesCleared |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/chunk_ticking/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/chunk_ticking/precipitation/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/chunk_ticking/precipitation/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:1 | skipIfAllBiomesDoNotCreateIceOrSnowAtPos |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/chunk_ticking/random_block_ticking/LevelChunkSection$BlockCounterMixin.java` | `targets={"net.minecraft.world.level.chunk.LevelChunkSection$1BlockCounter"})` |  | lithium$initRandomTickingBlockCounter, lithium$finishedCountingMinisection, lithium$wholeSectionSingleBlock, lithium$handleAfterCounting, sanityCheckRandomTickableBlockCount |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/chunk_ticking/random_block_ticking/LevelChunkSectionMixin.java` | `value={LevelChunkSection.class})` | Inject:3, WrapOperation:1 | initAirSection, createFlagCounters, initFlagCountersAndRecalcBlockCounts, updateRandomTickableBlockCounts |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/chunk_ticking/random_block_ticking/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/chunk_ticking/random_block_ticking/PalettedContainerMixin.java` | `value={PalettedContainer.class})` | ModifyArg:1, WrapOperation:1 | initializeRandomTickExtraData, accept, handleWholeSectionSingleBlock |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/chunk_ticking/random_block_ticking/ServerLevelMixin.java` | `value={ServerLevel.class})` | ModifyExpressionValue:1 | lithiumRandomTick, getRandomBlockIndexForRandomTick |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/chunk_ticking/spread_ice/BiomeMixin.java` | `value={Biome.class})` | WrapOperation:1 | getFluidStateFromBlockState |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/chunk_ticking/spread_ice/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/combined_heightmap_update/HeightmapAccessor.java` | `value={Heightmap.class})` | Invoker:1, Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/combined_heightmap_update/LevelChunkMixin.java` | `value={LevelChunk.class})` | Redirect:2, Inject:1 | skipGetHeightmap, skipHeightmapUpdate, updateHeightmapsCombined |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/combined_heightmap_update/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/explosions/block_raycast/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/explosions/block_raycast/ServerExplosionMixin.java` | `value={ServerExplosion.class})` | Inject:2, Redirect:2, ModifyConstant:1 | init, lithium$setSkipAir, lithium$isSkippingAir, lithium$setSkipAirWithoutCounting, initCaches, posToCacheIndex, cacheBlock, getCacheHitIndex, skipNewHashSet, skipLoop, getExplodedPositionCount, collectBlocks, performRayCast, traverseBlock, tryMarkBlockForDestruction |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/explosions/block_raycast/skip_air/no_air_counting/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/explosions/block_raycast/skip_air/no_air_counting/ServerLevelMixin.java` | `value={ServerLevel.class}, priority=10000)` | WrapOperation:2, ModifyVariable:1 | delayExploding, runDelayedExplosion, runDelayedExplosionWithoutCountingBlocks |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/explosions/block_raycast/skip_air/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/explosions/block_raycast/skip_air/ServerExplosionMixin.java` | `value={ServerExplosion.class})` | Inject:1 | init |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/explosions/entity_raycast/ClipContextMixin.java` | `value={ClipContext.class})` |  | lithium$setFrom, lithium$getCollisionContext |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/explosions/entity_raycast/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/explosions/entity_raycast/ServerExplosionMixin.java` | `value={ServerExplosion.class})` | Inject:1, Redirect:2 | createMutableContext, reuseClipContext, simplifyRaycast, blockHitFactory, apply, getBlock |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/explosions/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/game_events/dispatch/GameEventDispatcherMixin.java` | `value={GameEventDispatcher.class})` | Redirect:3 | doNotGetChunk, getNull, handleNullDispatcher |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/game_events/dispatch/LevelChunkMixin.java` | `value={LevelChunk.class})` | Inject:3 | initGameEventDispatchers, removeGameEventDispatcher, initializeCollection, setGameEventListenerRegistrySections |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/game_events/dispatch/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/game_events/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/inline_block_access/LevelChunkMixin.java` | `value={LevelChunk.class}, priority=500)` | Overwrite:2 | getBlockState, getFluidState |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/inline_block_access/LevelMixin.java` | `value={Level.class})` | Overwrite:1 | getBlockState |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/inline_block_access/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/inline_height/LevelChunkMixin.java` | `value={LevelChunk.class})` |  | getMaxY, getMinSectionY, getMaxSectionY, isInsideBuildHeight, getHeight, getMinY, getSectionsCount, isOutsideBuildHeight, isOutsideBuildHeight, getSectionIndex, getSectionIndexFromSectionY, getSectionYFromSectionIndex |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/inline_height/LevelMixin.java` | `value={Level.class})` | Inject:1 | initHeightCache, getHeight, getMinY, getSectionsCount, getMinSectionY, getMaxSectionY, isOutsideBuildHeight, isOutsideBuildHeight, getSectionIndex, getSectionIndexFromSectionY, getSectionYFromSectionIndex, getMaxY |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/inline_height/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/raycast/BlockGetterMixin.java` | `value={BlockGetter.class})` | Overwrite:1 | traverseBlocks, lambda$clip$1, lithium$blockHitFactory, apply, getBlock |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/raycast/ClipContextAccessor.java` | `value={ClipContext.class})` | Accessor:1 |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/raycast/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/temperature_cache/BiomeMixin.java` | `value={Biome.class})` | Overwrite:1 | getTemperature |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/temperature_cache/package-info.java` | `` |  |  |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/tick_scheduler/LevelChunkTicksMixin.java` | `value={LevelChunkTicks.class})` | Inject:1, Overwrite:9 | reinit, tickToInt, fixMissingType2Index, schedule, getBucketKey, updateNextTickQueue, peek, poll, queueTick, hasScheduledTick, removeIf, getAll, count, pack, unpack |
| top-level / `net/caffeinemc/mods/lithium/mixin/world/tick_scheduler/package-info.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
