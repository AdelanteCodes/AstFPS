# Drop2Inv

Review status: **Evidence inventory; behavioral review pending**

Project: [Drop2Inv](https://modrinth.com/mod/drop2inv)
Selected artifact version: `1.2.0+26.1-26.3`
Published implementation source: https://github.com/Guayand0/Minecraft-Mod-Drop2Inv
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This mod adds the function of receiving block and mob drops directly into the inventory without the item falling to the ground.

Not affiliated with Drop2Inv plugin.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `a757b19641611ef9e00027455166d4e75e6eb351e41742d4d49227498720cce0f9ba155affdfba82a461cdd553161e0221ab046916c13d4e4092f4e04f60be7e`
- `sha1`: `155b941bc14b6027dbb2c00dbe8401cf95097f20`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 67
Reconstructed Java files: 44

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "com.guayand0.Drop2InvClient"
  ],
  "main": [
    "com.guayand0.Drop2Inv"
  ],
  "modmenu": [
    "com.guayand0.config.compat.modmenu.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "minecraft": ">=26.1",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/guayand0/blocks/BlockBreakHandler.java` | `` |  | register |
| top-level / `com/guayand0/blocks/CommonBlockBreakHooks.java` | `` |  | shouldCancelBreak |
| top-level / `com/guayand0/blocks/CommonItemEntityHooks.java` | `` |  | shouldDiscard |
| top-level / `com/guayand0/blocks/DropCancelHandler.java` | `` |  | register |
| top-level / `com/guayand0/blocks/DropTracker.java` | `` |  | mark, consume, clear |
| top-level / `com/guayand0/blocks/GiantMushroomBreakHandler.java` | `` |  | breakMushroom, getAdjacent |
| top-level / `com/guayand0/blocks/LeafBreakHandler.java` | `` |  | breakLeavesFromLogs, getAdjacent, manhattan |
| top-level / `com/guayand0/blocks/MushroomCapBreakHandler.java` | `` |  | breakCaps, getAdjacent6, getAdjacentWithDiagonals, manhattan |
| top-level / `com/guayand0/blocks/TreeBreakHandler.java` | `` |  | breakTree |
| top-level / `com/guayand0/blocks/utils/CropUtils.java` | `` |  | giveCropDrops |
| top-level / `com/guayand0/blocks/utils/DropUtils.java` | `` |  | giveDrops, breakBlockToInventory |
| top-level / `com/guayand0/blocks/utils/MushroomUtils.java` | `` |  | isMushroomStem, isMushroomCap, isRed, isBrown |
| top-level / `com/guayand0/blocks/utils/TreeUtils.java` | `` |  | isLog, isLeave |
| top-level / `com/guayand0/blocks/VerticalBreakHandler.java` | `` |  | isVerticalBlock, breakVertical, breakChorus |
| top-level / `com/guayand0/config/compat/cloth/ClothConfigCompat.java` | `` |  | create, MobEntry |
| top-level / `com/guayand0/config/compat/cloth/Drop2InvClothConfig.java` | `` |  | saveToManager |
| top-level / `com/guayand0/config/compat/cloth/NoClothConfigScreen.java` | `` |  | init |
| top-level / `com/guayand0/config/compat/modmenu/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/guayand0/config/Drop2InvConfig.java` | `` |  |  |
| top-level / `com/guayand0/config/Drop2InvConfigManager.java` | `` |  | init, load, save, get, ensureInitialized, copyDefaults |
| top-level / `com/guayand0/containers/ContainerDropUtils.java` | `` |  | shouldHandleBlockContainer, shouldHandleEntityContainer, transferBlockContainerContents, transferEntityContainerContents, transferArmorStandContents, isConfiguredBlockContainer, isConfiguredEntityContainer, transferContainerContents |
| top-level / `com/guayand0/Drop2Inv.java` | `` |  | onInitialize |
| top-level / `com/guayand0/Drop2InvClient.java` | `` |  | onInitializeClient, getConfigScreen |
| top-level / `com/guayand0/Drop2InvCommon.java` | `` |  | init, initClient |
| top-level / `com/guayand0/entities/EntityDropUtils.java` | `` |  | giveStackToPlayer, isConfiguredBoat, isConfiguredChestBoat, isConfiguredMinecart, isConfiguredSpecialMinecart, isConfiguredArmorStand, isConfiguredItemFrame |
| top-level / `com/guayand0/fabric/FabricDrop2InvBootstrap.java` | `` |  | register |
| top-level / `com/guayand0/forge/Drop2InvForge.java` | `` |  | onBlockBreak, onEntityJoinLevel, onLivingDrops, onEntityInteract |
| top-level / `com/guayand0/forge/ForgeConfigScreen.java` | `` |  | init, buildGeneralTab, buildBlocksTab, buildContainersTab, buildSpecialFunctions, buildEntitiesTab, buildMobsTab, addTabButton, addMobsSubTabButton, addPagedToggles, addSectionTitle, addPager, addToggle, saveAndClose, copyConfig, label, mobLabel, sectionWidth, maxPage, nextCategory, buildMobEntries, ToggleEntry, MobEntry |
| top-level / `com/guayand0/mixin/AbstractChestBoatMixin.java` | `value={AbstractChestBoat.class})` | Inject:1 | drop2inv$transferContents |
| top-level / `com/guayand0/mixin/AbstractMinecartContainerMixin.java` | `value={AbstractMinecartContainer.class})` | Inject:1 | drop2inv$transferContents |
| top-level / `com/guayand0/mixin/ArmorStandMixin.java` | `value={ArmorStand.class})` | Inject:1 | drop2inv$transferEquipment |
| top-level / `com/guayand0/mixin/ItemFrameMixin.java` | `value={ItemFrame.class})` | Inject:1 | drop2inv$transferFrame |
| top-level / `com/guayand0/mixin/MinecartTNTMixin.java` | `value={MinecartTNT.class})` | Inject:2 | drop2inv$transferDrops, drop2inv$transferDrops |
| top-level / `com/guayand0/mixin/MobDropMixin.java` | `value={LivingEntity.class})` | Inject:1 | onDropStacks |
| top-level / `com/guayand0/mixin/ServerPlayerGameModeMixin.java` | `value={ServerPlayerGameMode.class})` | Inject:1 | drop2inv$giveDropsToInventory |
| top-level / `com/guayand0/mixin/SheepInteractMixin.java` | `value={Sheep.class})` | Inject:1 | captureShearer |
| top-level / `com/guayand0/mixin/SheepShearMixin.java` | `value={Sheep.class})` | Inject:1 | onSheared |
| top-level / `com/guayand0/mixin/VehicleEntityMixin.java` | `value={VehicleEntity.class})` | Inject:1 | drop2inv$directVehicleDrops |
| top-level / `com/guayand0/mobs/config/MobConfigManager.java` | `` |  | get, load, getPassive, getNeutral, getHostile |
| top-level / `com/guayand0/mobs/logic/MobDropLogic.java` | `` |  | give, give |
| top-level / `com/guayand0/mobs/MobCategory.java` | `` |  |  |
| top-level / `com/guayand0/mobs/utils/MobUtils.java` | `` |  | getCategory, getDefaultCategory |
| top-level / `com/guayand0/neoforge/Drop2InvNeoForge.java` | `` |  | createScreen, onLivingDrops, onEntityInteract |
| top-level / `com/guayand0/neoforge/NeoForgeConfigScreen.java` | `` |  | init, buildGeneralTab, buildBlocksTab, buildContainersTab, buildSpecialFunctions, buildEntitiesTab, buildMobsTab, addTabButton, addMobsSubTabButton, addPagedToggles, addSectionTitle, addPager, addToggle, saveAndClose, copyConfig, label, mobLabel, sectionWidth, maxPage, nextCategory, buildMobEntries, ToggleEntry, MobEntry |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
