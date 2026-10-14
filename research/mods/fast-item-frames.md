# Fast Item Frames

Review status: **Evidence inventory; behavioral review pending**

Project: [Fast Item Frames](https://modrinth.com/mod/fast-item-frames)
Selected artifact version: `26.3.0`
Published implementation source: https://github.com/Fuzss/fastitemframes
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Supercharged item frames! Less lag, better performance, and now they can change color and vanish!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha512`: `f4ac11ea4c71add00a464d283d783d3d5d97f8e45ecdf31ab1e690db5f7252ee804f35636ba2ee0e245c2f44fb13ab1144230795c0b2c56b52335b17331bf614`
- `sha1`: `462da542fa73b44fd121ea84670d5c0d71df36e5`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 25
Reconstructed Java files: 24

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "fuzs.fastitemframes.fabric.client.FastItemFramesFabricClient"
  ],
  "main": [
    "fuzs.fastitemframes.fabric.FastItemFramesFabric"
  ]
}
```

**depends**

```json
{
  "minecraft": "~26.3-",
  "fabricloader": ">=0.19.4",
  "fabric-api": ">=0.160.6",
  "forgeconfigapiport": "*",
  "puzzleslib": ">=26.3.0"
}
```

**accessWidener**

```json
"fastitemframes.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `fuzs/fastitemframes/common/client/FastItemFramesClient.java` | `` |  | color, colorInWorld, colorAsTerrainParticle, onConstructMod, registerEventHandlers, onRegisterBlockEntityRenderers, onRegisterBlockColorProviders |
| top-level / `fuzs/fastitemframes/common/client/handler/ClientEventHandler.java` | `` |  | onAttackBlock, onExtractEntityRenderState |
| top-level / `fuzs/fastitemframes/common/client/renderer/blockentity/ItemFrameBlockRenderer.java` | `` |  | getItemFrameBlockState, getItemFrameBlock, createRenderState, extractItemFrameRenderState, extractCustomItemFrameRenderState, shouldShowName, submit, getViewDistance |
| top-level / `fuzs/fastitemframes/common/client/renderer/blockentity/state/ItemFrameBlockRenderState.java` | `` |  |  |
| top-level / `fuzs/fastitemframes/common/config/ClientConfig.java` | `` |  |  |
| top-level / `fuzs/fastitemframes/common/config/ServerConfig.java` | `` |  |  |
| top-level / `fuzs/fastitemframes/common/data/client/ModelLocationHelper.java` | `` |  | getBlockModel, getBlockModel, getBlockModel, getBlockModel, getBlockTexture, getBlockTexture, getBlockTexture, getBlockTexture, getBlockLocation, getBlockLocation, getBlockName, getItemModel, getItemModel, getItemModel, getItemModel, getItemTexture, getItemTexture, getItemTexture, getItemTexture, getItemLocation, getItemLocation, getItemName |
| top-level / `fuzs/fastitemframes/common/data/client/ModModelProvider.java` | `` |  | createItemFrameMapping, createItemFrameMapping, addBlockModels, createItemFrame, createGlowItemFrame, createItemFrame, addItemModels, generateItemFrame |
| top-level / `fuzs/fastitemframes/common/data/loot/ModBlockLootProvider.java` | `` |  | generate, createItemFrameDrop |
| top-level / `fuzs/fastitemframes/common/data/ModRecipeProvider.java` | `` |  | buildRecipes |
| top-level / `fuzs/fastitemframes/common/data/tags/ModBlockTagsProvider.java` | `` |  | addTags |
| top-level / `fuzs/fastitemframes/common/data/tags/ModEntityTypeTagsProvider.java` | `` |  | addTags |
| top-level / `fuzs/fastitemframes/common/data/tags/ModItemTagsProvider.java` | `` |  | addTags |
| top-level / `fuzs/fastitemframes/common/FastItemFrames.java` | `` |  | onConstructMod, registerEventHandlers, id |
| top-level / `fuzs/fastitemframes/common/handler/ItemFrameHandler.java` | `` |  | onBreakBlock, onEntityLoad, setItemFrameBlock, getAttachedBlockHitResult, onUseEntity, onAttackEntity |
| top-level / `fuzs/fastitemframes/common/init/ModRegistry.java` | `` |  | bootstrap, itemFrameProperties |
| top-level / `fuzs/fastitemframes/common/mixin/client/ItemFrameRendererMixin.java` | `value={ItemFrameRenderer.class})` | Inject:1 | submit |
| top-level / `fuzs/fastitemframes/common/mixin/GlowItemFrameMixin.java` | `value={GlowItemFrame.class})` | ModifyReturnValue:1 | getFrameItemStack |
| top-level / `fuzs/fastitemframes/common/mixin/HangingEntityItemMixin.java` | `value={HangingEntityItem.class})` | Inject:1 | useOn |
| top-level / `fuzs/fastitemframes/common/mixin/ItemFrameMixin.java` | `value={ItemFrame.class})` | ModifyReturnValue:2 | survives, getFrameItemStack |
| top-level / `fuzs/fastitemframes/common/world/level/block/entity/ItemFrameBlockEntity.java` | `` |  | getId, level, position, getVisualRotationYInDegrees, serverTick, setUpdatedBlockState, tickMapItemSavedData, getItems, stillValid, getEntityType, getItem, removeFramedMap, hasFramedMap, getDropChance, setDropChance, setColor, getRemoveItemSound, getAddItemSound, getRotateItemSound, isGlowItemFrame, loadAdditional, loadLegacyAdditional, saveAdditional, getUpdatePacket, getUpdateTag, setChanged, markUpdated, preRemoveSideEffects, dropItem, applyImplicitComponents, collectImplicitComponents, removeComponentsFromTag |
| top-level / `fuzs/fastitemframes/common/world/level/block/ItemFrameBlock.java` | `` |  | asItem, useItemOn, interact, getShape, getCollisionShape, canSurvive, getStateForPlacement, updateShape, getFluidState, getBlockEntityType, rotate, mirror, createBlockStateDefinition, onProjectileHit, affectNeighborsAfterRemoval, hasAnalogOutputSignal, getAnalogOutputSignal, getCloneItemStack, getPickResult, setItemStackColor |
| top-level / `fuzs/fastitemframes/fabric/client/FastItemFramesFabricClient.java` | `` |  | onInitializeClient |
| top-level / `fuzs/fastitemframes/fabric/FastItemFramesFabric.java` | `` |  | onInitialize |

## Data-driven behavior

Resource category counts: `advancement`: 2, `loot_table`: 2, `recipe`: 2, `tags`: 5.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
