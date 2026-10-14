# AntiDeath-Survival-Assistant

Review status: **Evidence inventory; behavioral review pending**

Project: [AntiDeath-Survival-Assistant](https://modrinth.com/mod/antideath-survival-assistant)
Selected artifact version: `v1.7.5-mc26.3`
Published implementation source: https://github.com/jfglzs/Antideath-survival-assistant
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Client-side survival assistant for Minecraft 1.21.x–26.x. Provides various quality-of-life tools for survival gameplay. Requires MaLiLib.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `990d781ab25220af2816a56041c04419d987a4a2`
- `sha512`: `4dfc8b98eb15fed67bece4cf84ce91bbf2ec3de96276dad8dc74ddc60e437ed32e0f41335776e947c9ef70ee18409952c392b8776fbced6c994f6a169053e2de`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 128
Reconstructed Java files: 108

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "io.github.jfglzs.asa.AsaMod"
  ],
  "modmenu": [
    "io.github.jfglzs.asa.config.ModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16",
  "fabric-api": "*",
  "malilib": "*",
  "minecraft": "26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/github/jfglzs/asa/accessor/IClientPacketListenerAccessor.java` | `` |  |  |
| top-level / `io/github/jfglzs/asa/accessor/IClientPacketListenerAccessor1.java` | `` |  | of |
| top-level / `io/github/jfglzs/asa/accessor/IJoinMultiPlayerScreenAccessor.java` | `` |  |  |
| top-level / `io/github/jfglzs/asa/annotations/Config.java` | `` |  |  |
| top-level / `io/github/jfglzs/asa/AsaMod.java` | `` |  | debugMessage, onInitialize, init, registerEvents, registerCommands, testOnTick, test |
| top-level / `io/github/jfglzs/asa/commands/AutoVaultCommand.java` | `` |  | register, setPlayer, setPos, stop, start |
| top-level / `io/github/jfglzs/asa/commands/PlayerManipulateCommand.java` | `` |  | register, makeCommand, process, startWithAction, getPrefixSuggestions, getActionSuggestions |
| top-level / `io/github/jfglzs/asa/config/Configs.java` | `` |  | switchMode, isInList, isInList, load, save |
| top-level / `io/github/jfglzs/asa/config/ConfigsManager.java` | `` |  | init, addConfig, getConfigs |
| top-level / `io/github/jfglzs/asa/config/ConfigUi.java` | `` |  | initGui, createButton, getConfigs, closeGui, actionPerformedWithButton |
| top-level / `io/github/jfglzs/asa/config/HotkeysCallback.java` | `` |  | init, onKeyAction |
| top-level / `io/github/jfglzs/asa/config/InitHandler.java` | `` |  | registerModHandlers |
| top-level / `io/github/jfglzs/asa/config/InputHandler.java` | `` |  | addKeysToMap, addHotkeys |
| top-level / `io/github/jfglzs/asa/config/ModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `io/github/jfglzs/asa/config/options/AutoCleanWasteMode.java` | `` |  | getStringValue, getDisplayName, cycle, fromString |
| top-level / `io/github/jfglzs/asa/config/options/ItemFrameVisibility.java` | `` |  | getStringValue, getDisplayName, cycle, fromString |
| top-level / `io/github/jfglzs/asa/config/options/LowHealthSendMode.java` | `` |  | getStringValue, getDisplayName, cycle, fromString |
| top-level / `io/github/jfglzs/asa/config/options/OpenFakePlayerInvMode.java` | `` |  | getStringValue, getDisplayName, cycle, fromString |
| top-level / `io/github/jfglzs/asa/config/Tab.java` | `` |  | getTranslate |
| top-level / `io/github/jfglzs/asa/events/base/Event.java` | `` |  | register, update |
| top-level / `io/github/jfglzs/asa/events/base/ReturnableEvent.java` | `` |  | register, update |
| top-level / `io/github/jfglzs/asa/events/ClientTickEvent.java` | `` |  | register, register, register, register, onUpdate, of, of |
| top-level / `io/github/jfglzs/asa/events/HudRenderEvent.java` | `` |  | onExtractGuiOverlayPost, RenderContextWrap |
| top-level / `io/github/jfglzs/asa/events/OpenScreenEvent.java` | `` |  |  |
| top-level / `io/github/jfglzs/asa/events/SendPacketEvent.java` | `` |  |  |
| top-level / `io/github/jfglzs/asa/feature/autoVault/AutoVaultExecutor.java` | `` |  | setBlockPos, set, makeCommand, reset, resetAll, currentWorld, tick, canUseVault |
| top-level / `io/github/jfglzs/asa/feature/autoWasteClean/AutoWasteCleanProcessor.java` | `` |  | init, process, shouldDrop, saveItemToList |
| top-level / `io/github/jfglzs/asa/feature/boxRestock/BoxRestockMannager.java` | `` |  | run, process, canMove, BoxRestockContext |
| top-level / `io/github/jfglzs/asa/feature/boxSplitter/BoxSplitter.java` | `` |  | addTask, run, tick |
| top-level / `io/github/jfglzs/asa/feature/creeperWarn/CreeperCheckClient.java` | `` |  | tick, isCreeperNearby |
| top-level / `io/github/jfglzs/asa/feature/disablePacketKick/ASAFakePacket.java` | `` |  | type, handle |
| top-level / `io/github/jfglzs/asa/feature/fakePlayerKillAura/FakePlayerKillAura.java` | `` |  | kill, canKill |
| top-level / `io/github/jfglzs/asa/feature/lms/ItemStorageDataManager.java` | `` |  | init, submit, removeAll, canSend, addPlayerInventory, calculateInventory, get, getCount, reflushCache, scanMatchedPlayersAndInteract, WAIT_FOR_KILLING, PlayerInventory |
| top-level / `io/github/jfglzs/asa/feature/lowHealthSendCommandOrChat/LowHealthSendCommandOrChat.java` | `` |  | tick |
| top-level / `io/github/jfglzs/asa/feature/optItemFrame/MapItemUpdater.java` | `` |  | tick, update |
| top-level / `io/github/jfglzs/asa/feature/spectatorTeleportMenu/FakePlayerSplitter.java` | `` |  | getFakePlayers, withoutFakePlayers, isRealPlayer |
| top-level / `io/github/jfglzs/asa/feature/spectatorTeleportMenu/TeleportToFakePlayerMenuCategory.java` | `` |  | getName, getPrompt |
| top-level / `io/github/jfglzs/asa/feature/useSignRunCommand/UseSignRunCommand.java` | `` |  | init |
| top-level / `io/github/jfglzs/asa/mixin/event/packetEvent/ClientPacketListener_Mixin.java` | `value={ClientPacketListener.class})` | Inject:1 | handleContainerContent |
| top-level / `io/github/jfglzs/asa/mixin/event/packetEvent/Connection_Mixin.java` | `value={Connection.class})` | WrapMethod:1 | sendPacket |
| top-level / `io/github/jfglzs/asa/mixin/event/screenEvents/ClientPacketListener_Mixin.java` | `value={ClientPacketListener.class})` | Inject:1 | handleOpenScreen |
| top-level / `io/github/jfglzs/asa/mixin/event/screenEvents/Gui_Mixin.java` | `value={Gui.class})` | Inject:1 | setScreen |
| top-level / `io/github/jfglzs/asa/mixin/event/screenEvents/Minecraft_Mixin.java` | `value={Minecraft.class})` | Inject:2 | setScreen_1, setScreen |
| top-level / `io/github/jfglzs/asa/mixin/feature/disables/disableConnectionTimedOut/Connection_Mixin.java` | `value={Connection.class})` | Inject:1 | exceptionCaughtInject |
| top-level / `io/github/jfglzs/asa/mixin/feature/disables/disableContainerBackGround/AbstractContainerScreen_Mixin.java` | `value={DummyClass.class})` |  |  |
| top-level / `io/github/jfglzs/asa/mixin/feature/disables/disableContainerBackGround/Screen_Mixin.java` | `value={Screen.class})` | Inject:1 | extractTransparentBackground |
| top-level / `io/github/jfglzs/asa/mixin/feature/disables/disableItemEntityMulPose/ItemEntityRenderer_Mixin.java` | `value={ItemEntityRenderer.class})` | WrapOperation:1 | submit |
| top-level / `io/github/jfglzs/asa/mixin/feature/disables/disableLoadingScreen/ReceivingLevelScreen_Mixin.java` | `value={LevelLoadingScreen.class})` | Inject:2 | extractBackground, extractRenderState |
| top-level / `io/github/jfglzs/asa/mixin/feature/disables/disablePacketKick/IdDispatchCodec_Mixin.java` | `value={IdDispatchCodec.class})` | WrapMethod:2 | decode, decode |
| top-level / `io/github/jfglzs/asa/mixin/feature/disables/disablePacketKick/PacketDecoder_Mixin.java` | `value={PacketDecoder.class})` | Inject:1 | decode |
| top-level / `io/github/jfglzs/asa/mixin/feature/disables/disablePlayerArmorRendener/HumanoidArmorLayer_Mixin.java` | `value={HumanoidArmorLayer.class})` | Inject:1 | renderArmorPiece |
| top-level / `io/github/jfglzs/asa/mixin/feature/disables/disablePlayerTabOverlayBackGround/PlayerTabOverlay_Mixin.java` | `value={PlayerTabOverlay.class})` | WrapOperation:1 | fill |
| top-level / `io/github/jfglzs/asa/mixin/feature/disables/disableProfiler/Profiler_Mixin.java` | `value={Profiler.class})` | Inject:1 | onGet |
| top-level / `io/github/jfglzs/asa/mixin/feature/disables/disableScoreBoardBackGround/Gui_Mixin.java` | `value={Hud.class})` | WrapOperation:1 | fill |
| top-level / `io/github/jfglzs/asa/mixin/feature/disables/disableSubtitle/MaterialListHudRenderer_Mixin.java` | `value={MaterialListHudRenderer.class})` | Inject:1 | toggleShouldRender_Inject |
| top-level / `io/github/jfglzs/asa/mixin/feature/disables/disableSubtitle/SubtitleOverlay_Mixin.java` | `value={SubtitleOverlay.class})` | Inject:1 | extractRenderState |
| top-level / `io/github/jfglzs/asa/mixin/feature/disables/disableSubtitleOverlayBackGround/SubtitleOverlay_Mixin.java` | `value={SubtitleOverlay.class})` | WrapOperation:1 | extractRenderStateWrap |
| top-level / `io/github/jfglzs/asa/mixin/feature/disables/forceJoinServer/ClientRegistrySyncHandler_Mixin.java` | `value={ClientRegistrySyncHandler.class})` | Inject:1 | apply |
| top-level / `io/github/jfglzs/asa/mixin/feature/disables/preventNetworkProtocolError/ClientCommonPacketListener_Mixin.java` | `value={ClientCommonPacketListenerImpl.class})` | Inject:1 | onPacketError |
| top-level / `io/github/jfglzs/asa/mixin/feature/disables/preventNetworkProtocolError/Connection_Mixin.java` | `value={Connection.class})` | WrapMethod:1 | genericsFtw |
| top-level / `io/github/jfglzs/asa/mixin/feature/functions/autoBoxRestrock/InventoryUtils_Mixin.java` | `value={InventoryUtils.class})` | Inject:2 | preRestockHand, restockNewStackToHand, tryRestrock |
| top-level / `io/github/jfglzs/asa/mixin/feature/functions/canAlwaysDisconnect/ServerReconfigScreen_Mixin.java` | `value={ServerReconfigScreen.class})` | Inject:1 | tick |
| top-level / `io/github/jfglzs/asa/mixin/feature/functions/canOpenMutiPlayerScreenOnGaming/JoinMultiplayerScreen_Mixin.java` | `value={JoinMultiplayerScreen.class})` | Inject:2 | init, join, asa$setCanDisconnect |
| top-level / `io/github/jfglzs/asa/mixin/feature/functions/canOpenMutiPlayerScreenOnGaming/PauseScreen_Mixin.java` | `value={PauseScreen.class})` | Inject:1 | createPauseMenu |
| top-level / `io/github/jfglzs/asa/mixin/feature/functions/confirmScreenAlwaysYes/ClientPacketListener_Mixin.java` | `value={ClientPacketListener.class})` | Inject:1 | onOpenSendConfirmationWindow |
| top-level / `io/github/jfglzs/asa/mixin/feature/functions/customBlockCollision/BlockStateBase_Mixin.java` | `value={BlockBehaviour.BlockStateBase.class})` | Inject:2 | getCollisionShape, getShape, asa$getEntityCollisionContext |
| top-level / `io/github/jfglzs/asa/mixin/feature/functions/customLitematicaBlockReplace/WorldUtils_Mixin.java` | `value={WorldUtils.class})` | WrapOperation:1 | getRequiredBuildItemForState, asa$getBlockMappings |
| top-level / `io/github/jfglzs/asa/mixin/feature/functions/fakePlayerMenu/RootSpectatorMenuCategory_Mixin.java` | `value={RootSpectatorMenuCategory.class})` | Inject:1 | addFakePlayerCategory |
| top-level / `io/github/jfglzs/asa/mixin/feature/functions/fakePlayerMenu/TeleportToPlayerMenuCategory_Mixin.java` | `value={TeleportToPlayerMenuCategory.class})` | ModifyReturnValue:1, ModifyReceiver:1 | filterFakePlayers, isEnabled, filter |
| top-level / `io/github/jfglzs/asa/mixin/feature/functions/flatMining/MultiPlayerGameMode_Mixin.java` | `value={MultiPlayerGameMode.class})` | Inject:2 | startDestroyBlock, continueDestroyBlock, asa$shouldFlatDigger |
| top-level / `io/github/jfglzs/asa/mixin/feature/functions/forceBlockBreakCoolDown/MultiPlayerGameMode_Mixin.java` | `value={MultiPlayerGameMode.class})` | Inject:1 | continueDestroyBlock |
| top-level / `io/github/jfglzs/asa/mixin/feature/functions/forceUseFireWork/Minecraft_Mixin.java` | `value={Minecraft.class})` | Inject:1 | startUseItem |
| top-level / `io/github/jfglzs/asa/mixin/feature/functions/mountLoggersOnMiniHud/ClientPacketListener_Accessor_Mixin.java` | `value={ClientPacketListener.class})` | Inject:1 | handleTabListCustomisation, asa$TabList |
| top-level / `io/github/jfglzs/asa/mixin/feature/functions/mountLoggersOnMiniHud/RenderHandler_Mixin.java` | `value={RenderHandler.class}, priority=1900)` | ModifyReceiver:2, WrapOperation:1 | updateLines_add, updateLines_clear, onRenderGameOverlayPostAdvanced, asa$mountHudInfo |
| top-level / `io/github/jfglzs/asa/mixin/feature/functions/tabFilter/PlayerTabOverlay_Mixin.java` | `value={PlayerTabOverlay.class})` | ModifyVariable:1 | extractRenderState |
| top-level / `io/github/jfglzs/asa/mixin/feature/lms/AbstractContainerScreen_Mixin.java` | `value={AbstractContainerScreen.class})` | Inject:1 | onClose, asa$cacheData |
| top-level / `io/github/jfglzs/asa/mixin/feature/lms/CreativeModeInventoryScreen_Mixin.java` | `value={CreativeModeInventoryScreen.class})` | Inject:4, ModifyExpressionValue:2 | onMouseClick_1, handledScreenTick, onMouseClick_2, getTooltipFromItem, isInCreativeMode, isCreativeLevelTwoOp |
| top-level / `io/github/jfglzs/asa/mixin/feature/lms/MaterialListEntry_Mixin.java` | `value={MaterialListEntry.class})` | ModifyReturnValue:1 | getCountAvailable |
| top-level / `io/github/jfglzs/asa/mixin/feature/lms/WorldUtils_Mixin.java` | `value={WorldUtils.class})` | Inject:1 | doSchematicWorldPickBlock_Inject |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/asyncClientLightUpdate/ClientLevel_Mixin.java` | `value={ClientLevel.class})` | WrapMethod:1 | update |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/asyncLitematicLoad/DataManager_Mixin.java` | `value={DataManager.class})` | WrapMethod:2 | load, fromJson |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/asyncLitematicLoad/GuiSchematicLoad_Mixin.java` | `targets={"fi.dy.masa.litematica.gui.GuiSchematicLoad$ButtonListener"})` | WrapMethod:1, WrapOperation:6, Inject:1 | actionPerformedWithButton, syncAddMessage, openGui, addSchematic, addSchematicPlacement, setSelectedSchematicPlacement, GuiMaterialList, actionPerformedWithButton |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/asyncLitematicLoad/LitematicaSchematic_Mixin.java` | `value={LitematicaSchematic.class})` | WrapMethod:1, WrapOperation:1, Inject:1, ModifyVariable:1 | convertTileEntities_to_1_20_5, convertTileEntities_to_1_20_5, modifyTiles, asa$updateProgress |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/asyncLitematicLoad/OverlayRenderer_Mixin.java` | `value={OverlayRenderer.class})` | Inject:1 | OverlayRenderer |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/fastModelRender/Group_Mixin.java` | `targets={"net.minecraft.client.renderer.feature.RenderTypeFeatureRenderer$Group"})` | WrapMethod:1 | getOrAddDraw |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/optDirection/Direction_Mixin.java` | `value={Direction.class})` | Inject:1 | byName |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/optEntityLight/EntityRenderer_Mixin.java` | `value={EntityRenderer.class})` | Inject:1 | getPackedLightCoords |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/optEntityLight/LightCoordsUtil_Mixin.java` | `value={LightCoordsUtil.class})` | Inject:1 | getLightCoords |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/optItemFrame/ClientLevel_Mixin.java` | `value={ClientLevel.class})` | Inject:4 | getMapData, overrideMapData, addMapData, getAllMapData, getMapItem, putMapItem, getAllMaps, putAllMaps |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/optItemFrame/ClientPacketListener_Mixin.java` | `value={ClientPacketListener.class})` | Inject:2 | handleRespawn, handleMapItemData, asa$getMaps |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/optItemFrame/EntityRenderer_Mixin.java` | `value={EntityRenderer.class})` | Inject:1 | getPackedLightCoords |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/optItemFrame/ItemFrame_Mixin.java` | `value={ItemFrame.class})` |  | isDiscrete, fireImmune, isOnFire |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/optItemFrame/ItemFrameRenderer_Mixin.java` | `value={ItemFrameRenderer.class})` | WrapOperation:4 | updateForItemFrame, submit, submit_1, updateForNonLiving |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/optScoreBoard/ScoreBoard_Mixin.java` | `value={Scoreboard.class})` | WrapMethod:1 | listPlayerScores |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/optSignText/BoundTickingBlockEntity_Mixin.java` | `targets={"net.minecraft.world.level.chunk.LevelChunk$BoundTickingBlockEntity"})` | Inject:1 | tick |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/optSignText/LocalPlayer_Mixin.java` | `value={LocalPlayer.class})` | Inject:1 | isTextFilteringEnabled |
| top-level / `io/github/jfglzs/asa/mixin/feature/optimizations/optSignText/SignText_Mixin.java` | `value={SignText.class})` | Inject:2 | init, hasMessage |
| top-level / `io/github/jfglzs/asa/render/RemainingItemRender.java` | `` |  | init, tick, render |
| top-level / `io/github/jfglzs/asa/utils/ChatUtils.java` | `` |  | clientMess, clientMesswithSound, actionBar, serverMess, c |
| top-level / `io/github/jfglzs/asa/utils/CommandUtils.java` | `` |  | canUseCommand, literal, argument |
| top-level / `io/github/jfglzs/asa/utils/DummyClass.java` | `` |  |  |
| top-level / `io/github/jfglzs/asa/utils/Hardware.java` | `` |  |  |
| top-level / `io/github/jfglzs/asa/utils/MCUtils.java` | `` |  | getTickCount, tick, getMinecraft, getLocalPlayer, getLevel, executeCommand, isModLoaded, getItemID, getBlockID, getBlock, getScreen, setScreen, isPlayerOnline, disconnect, connectToServer, getConnection |
| top-level / `io/github/jfglzs/asa/utils/Mods.java` | `` |  |  |
| top-level / `io/github/jfglzs/asa/utils/PlayerUtils.java` | `` |  | getInventoryItemCount, getInventory, getItem, getItemStack, getAllBoxIndexes, getNotEmptyBoxIndexes, getBoxItemStacks, isBoxFull, isBoxEmpty, checkRemainCount, getPlayerMainHandStack, getPlayerHandStack, isSurvivalMode, isSurvivalMode, isShulkerBox, closeContainer, clickSlot, interactWith, getName, getName, isFakePlayer, isFakePlayer, getPlayerInfo |
| top-level / `io/github/jfglzs/asa/utils/ProgressBar.java` | `` |  | getProgress, getProgress |
| top-level / `io/github/jfglzs/asa/utils/ShulkerUtils.java` | `` |  | open, findBoxToOpen |
| top-level / `io/github/jfglzs/asa/utils/ThreadUtils.java` | `` |  | init, makeTaskThread, parallel, runOnClientThread, runAsync, runOnClientThread, runOnTaskThread |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
