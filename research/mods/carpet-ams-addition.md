# Carpet AMS Addition

Review status: **Evidence inventory; behavioral review pending**

Project: [Carpet AMS Addition](https://modrinth.com/mod/carpet-ams-addition)
Selected artifact version: `mc26.3-v26.4-beta.2`
Published implementation source: https://github.com/Minecraft-AMS/Carpet-AMS-Addition
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A fabric-carpet extension mod. It offers some interesting and useful features.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `848d1b1ce5ce5c0ad780a5a055a8b5cb73de3c28`
- `sha512`: `c88ecb5e3c13e33ed77bcb821870584ef26a35bcc7a113ebf88566bca8d19c564b49a41d24bd11d3afe3f1ca7818693607cf7431a2826e7973df7888509394b8`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 416
Reconstructed Java files: 398

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "preLaunch": [
    "carpetamsaddition.CarpetAMSAdditionPreLaunch"
  ],
  "main": [
    "carpetamsaddition.CarpetAMSAdditionMod"
  ],
  "client": [
    "carpetamsaddition.CarpetAMSAdditionClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3",
  "carpet": ">=26.3"
}
```

**accessWidener**

```json
"carpetamsaddition.accesswidener"
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/AnnotationToolBox-0.3.jar` | 2 | `annotationtoolbox` | No |
| `META-INF/jars/mixinextras-fabric-0.5.5.jar` | 506 | `mixinextras` | No |
| `META-INF/jars/tiny_yaml-1.0.3.jar` | 2 | `top_1024byteeeee_tiny_yaml` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `carpetamsaddition/api/command/AmsCommand.java` | `` |  |  |
| top-level / `carpetamsaddition/api/command/Arguments.java` | `` |  | bool, getName, createType, read, integer, integer, integer, decimal, decimal, decimal, word, string, greedyString, player, players, block, item, dimension, blockPos, suggests, getName, createType, read, suggestions, simple, getName, createType, read |
| top-level / `carpetamsaddition/api/command/BrigadierCommandCompiler.java` | `` |  | register, attach, createBuilder, wrap |
| top-level / `carpetamsaddition/api/command/CommandArgument.java` | `` |  |  |
| top-level / `carpetamsaddition/api/command/CommandBuilder.java` | `` |  | name, carpetRule, permissionLevel, allowAll, requires, executes, route, route, route, append, requireName |
| top-level / `carpetamsaddition/api/command/CommandExecutionContext.java` | `` |  | source, server, player, get, rawContext |
| top-level / `carpetamsaddition/api/command/CommandExecutor.java` | `` |  |  |
| top-level / `carpetamsaddition/api/command/CommandHelper.java` | `` |  | updateAllCommandPermissions, setPermission, canUseCommand, hasPermissionLevel |
| top-level / `carpetamsaddition/api/command/CommandNodeSpec.java` | `` |  | child |
| top-level / `carpetamsaddition/api/command/CommandPath.java` | `` |  | path, literal, argument |
| top-level / `carpetamsaddition/api/command/CommandRegistrationContext.java` | `` |  | dispatcher, buildContext |
| top-level / `carpetamsaddition/api/command/CommandRoute.java` | `` |  | executes |
| top-level / `carpetamsaddition/api/command/suggestionProviders/ListSuggestionProvider.java` | `` |  | of, getSuggestions |
| top-level / `carpetamsaddition/api/command/suggestionProviders/LiteralCommandSuggestionProvider.java` | `` |  | getSuggestions |
| top-level / `carpetamsaddition/api/command/suggestionProviders/PlayerNameSuggestionProvider.java` | `` |  | getSuggestions |
| top-level / `carpetamsaddition/api/command/suggestionProviders/SetSuggestionProvider.java` | `` |  | of, getSuggestions |
| top-level / `carpetamsaddition/api/recipe/AmsRecipeBuilder.java` | `` |  | getInstance, getShapedRecipeList, getShapelessRecipeList, getSmeltingRecipeList, addShapedRecipe, addShapelessRecipe, addSmeltingRecipe |
| top-level / `carpetamsaddition/api/recipe/AmsRecipeManager.java` | `` |  | createRecipeJsonMap, rebuildCustomRecipes, registerCustomRecipes, addRecipe, deserializeRecipe, onPlayerLoggedIn, reloadServerResources, queueReload, reloadRecipes, finishReload, awardMissingRecipes, awardMissingRecipes, getAmsRecipes, getRecipeIdentifier, hasRecipe, awardRecipes |
| top-level / `carpetamsaddition/api/recipe/builder/AbstractRecipeBuilder.java` | `` |  | output, item |
| top-level / `carpetamsaddition/api/recipe/builder/ShapedRecipeBuilder.java` | `` |  | create, pattern, define, build |
| top-level / `carpetamsaddition/api/recipe/builder/ShapelessRecipeBuilder.java` | `` |  | create, addIngredient, build |
| top-level / `carpetamsaddition/api/recipe/builder/SmeltingRecipeBuilder.java` | `` |  | create, material, experience, cookTime, build |
| top-level / `carpetamsaddition/api/recipe/template/RecipeTemplateInterface.java` | `` |  |  |
| top-level / `carpetamsaddition/api/recipe/template/ShapedRecipeTemplate.java` | `` |  | toJson, addToRecipeMap |
| top-level / `carpetamsaddition/api/recipe/template/ShapelessRecipeTemplate.java` | `` |  | toJson, addToRecipeMap |
| top-level / `carpetamsaddition/api/recipe/template/SmeltingRecipeTemplate.java` | `` |  | toJson, addToRecipeMap |
| top-level / `carpetamsaddition/CarpetAMSAdditionClient.java` | `` |  | onInitializeClient, getInstance, getModId, getVersion, onGameJoin, onDisconnect, onTick |
| top-level / `carpetamsaddition/CarpetAMSAdditionCustomRecipes.java` | `` |  | getInstance, buildRecipes |
| top-level / `carpetamsaddition/CarpetAMSAdditionMod.java` | `` |  | onInitialize, getModId, getVersion |
| top-level / `carpetamsaddition/CarpetAMSAdditionPreLaunch.java` | `` |  | onPreLaunch |
| top-level / `carpetamsaddition/CarpetAMSAdditionServer.java` | `` |  | getInstance, getMinecraftServer, init, onGameStarted, version, onTick, registerLoggers, registerCommands, sendS2CPacketOnHandShake, onPlayerLoggedIn, onPlayerLoggedOut, onServerLoaded, onServerClosed, onServerLoadedWorlds, afterServerLoadWorlds, canHasTranslations |
| top-level / `carpetamsaddition/CarpetAMSAdditionSettings.java` | `` |  |  |
| top-level / `carpetamsaddition/commands/AmsCommandRegistry.java` | `` |  | registerAll |
| top-level / `carpetamsaddition/commands/debug/network/AmspCommand.java` | `` |  | define, showSupportClientList, showServerSupportStatus, showClientModVersion, run, showServerModVersion, denyClientConnection, denyAllClientConnections, setServerSupport, requestHandShake, requestHandShake |
| top-level / `carpetamsaddition/commands/rule/amsUpdateSuppressionCrashFix/AmsUpdateSuppressionCrashFixCommand.java` | `` |  | define, setMode |
| top-level / `carpetamsaddition/commands/rule/commandAnvilInteractionDisabled/AnvilInteractionDisabledCommand.java` | `` |  | define, setMode |
| top-level / `carpetamsaddition/commands/rule/commandAtSomeOnePlayer/AtCommand.java` | `` |  | define, execute |
| top-level / `carpetamsaddition/commands/rule/commandCarpetExtensionModWikiHyperlink/CarpetExtensionModWikiHyperlinkCommand.java` | `` |  | define, execute, getUrl, createOpenUrlButton, getCopyHoverText |
| top-level / `carpetamsaddition/commands/rule/commandCustomAntiFireItems/CustomAntiFireItemsCommand.java` | `` |  | define, add, remove, removeAll, list, help, saveToJson, getItemName |
| top-level / `carpetamsaddition/commands/rule/commandCustomBlockBlastResistance/CustomBlockBlastResistanceCommand.java` | `` |  | define, set, remove, removeAll, list, help, getBlockRegisterName, saveToJson |
| top-level / `carpetamsaddition/commands/rule/commandCustomBlockHardness/CustomBlockHardnessCommand.java` | `` |  | define, set, remove, removeAll, getDefaultHardness, list, help, broadcastDataPack, saveToJson |
| top-level / `carpetamsaddition/commands/rule/commandCustomCommandPermissionLevel/CustomCommandPermissionLevelCommand.java` | `` |  | define, set, remove, removeAll, refreshCommandTree, list, help, saveToJson |
| top-level / `carpetamsaddition/commands/rule/commandCustomMovableBlock/CustomMovableBlockCommand.java` | `` |  | define, add, remove, removeAll, list, help, saveToJson, getBlockName |
| top-level / `carpetamsaddition/commands/rule/commandGetClientPlayerFps/GetClientPlayerFpsCommand.java` | `` |  | define, requestFps, sendFpsResult, help |
| top-level / `carpetamsaddition/commands/rule/commandGetHeldItemID/GetHeldItemIDCommand.java` | `` |  | define, execute, buildMessage, createCopyButton, getHeldItemRegisterName |
| top-level / `carpetamsaddition/commands/rule/commandGetPlayerSkull/GetPlayerSkullCommand.java` | `` |  | define, execute |
| top-level / `carpetamsaddition/commands/rule/commandGetSaveSize/GetSaveSizeCommand.java` | `` |  | define, executeGetSaveSize, saveWorld, getSaveFolder, getFolderSize, formatSize |
| top-level / `carpetamsaddition/commands/rule/commandGetSystemInfo/GetSystemInfoCommand.java` | `` |  | define, executeGetSystemInfo, formatInfo |
| top-level / `carpetamsaddition/commands/rule/commandGoto/GotoCommand.java` | `` |  | define, executeTeleport, executeSimpleTeleport, calculatePos, createCompatPos |
| top-level / `carpetamsaddition/commands/rule/commandHere/HereCommand.java` | `` |  | define, sendMessage, highlightPlayer, getPlayerName, getCurrentPos, getOtherPos, message, copyButton |
| top-level / `carpetamsaddition/commands/rule/commandPacketInternetGroper/PingsCommand.java` | `` |  | define, executePing, ping, stopPing, help, sendFinishMessage, run, setInterrupted |
| top-level / `carpetamsaddition/commands/rule/commandPlayerChunkLoadController/PlayerChunkLoadControllerCommand.java` | `` |  | define, setPlayerInteraction, listPlayerInteractions, help |
| top-level / `carpetamsaddition/commands/rule/commandPlayerLeader/LeaderCommand.java` | `` |  | define, broadcastPosTickInterval, tick, canBroadcastPos, add, remove, removeAll, list, help, onPlayerLoggedIn, saveToJson |
| top-level / `carpetamsaddition/commands/rule/commandPlayerNoNetherPortalTeleport/PlayerNoNetherPortalTeleportCommand.java` | `` |  | define, add, remove, clear, list, setGlobalMode, showGlobalModeState, help |
| top-level / `carpetamsaddition/commands/rule/commandSetPlayerPose/SetPlayerPoseCommand.java` | `` |  | define, set, stop, help, broadcastSyncDatapack, triggerPoseUpdate |
| top-level / `carpetamsaddition/commands/rule/commandWhere/WhereCommand.java` | `` |  | define, sendMessage, sendMessage, sendWhoGetWhoMessage, highlightPlayer, getPlayerName, getCurrentPos, getOtherPos, message, copyButton |
| top-level / `carpetamsaddition/config/LoadConfigFromJson.java` | `` |  | load |
| top-level / `carpetamsaddition/config/rule/amsUpdateSuppressionCrashFix/ForceModeCommandConfig.java` | `` |  | saveConfigToJson, loadConfigFromJson, getPath |
| top-level / `carpetamsaddition/config/rule/commandAntiFireItems/CustomAntiFireItemsConfig.java` | `` |  | getInstance, getElementType, getPath |
| top-level / `carpetamsaddition/config/rule/commandCustomBlockBlastResistance/CustomBlockBlastResistanceConfig.java` | `` |  | getInstance, getKeyType, getValueType, loadBlockStates, saveBlockStates, getConfigPath |
| top-level / `carpetamsaddition/config/rule/commandCustomBlockHardness/CustomBlockHardnessConfig.java` | `` |  | getInstance, getKeyType, getValueType, loadBlockStates, saveBlockStates, getConfigPath |
| top-level / `carpetamsaddition/config/rule/commandCustomCommandPermissionLevel/CustomCommandPermissionLevelConfig.java` | `` |  | getInstance, getKeyType, getValueType, getConfigPath |
| top-level / `carpetamsaddition/config/rule/commandCustomMovableBlock/CustomMovableBlockConfig.java` | `` |  | getInstance, getElementType, getPath |
| top-level / `carpetamsaddition/config/rule/commandLeader/LeaderConfig.java` | `` |  | getInstance, getKeyType, getValueType, getConfigPath |
| top-level / `carpetamsaddition/config/rule/welcomeMessage/CustomWelcomeMessageConfig.java` | `` |  | getConfig, handleMessage, sendWelcomeMessage |
| top-level / `carpetamsaddition/config/template/AbstractListJsonConfig.java` | `` |  | loadFromJson, saveToJson |
| top-level / `carpetamsaddition/config/template/AbstractMapJsonConfig.java` | `` |  | loadFromJson, saveToJson |
| top-level / `carpetamsaddition/debug/DebugTools.java` | `` |  | printToChatBar |
| top-level / `carpetamsaddition/fuzz/InvokeFuzzModCommand.java` | `` |  | highlightCoordButton |
| top-level / `carpetamsaddition/helpers/EnvironmentHelper.java` | `` |  | isClient, isServer, getEnvType |
| top-level / `carpetamsaddition/helpers/FakePlayerHelper.java` | `` |  | isFakePlayer |
| top-level / `carpetamsaddition/helpers/FeatureChecker.java` | `` |  | hasMinecartImprovements |
| top-level / `carpetamsaddition/helpers/ParticleHelper.java` | `` |  | spawnParticles, spawnShulkerGolemParticles |
| top-level / `carpetamsaddition/helpers/rule/amsUpdateSuppressionCrashFix/AMS_ThrowableSuppression.java` | `` |  |  |
| top-level / `carpetamsaddition/helpers/rule/amsUpdateSuppressionCrashFix/UpdateSuppressionContext.java` | `` |  | sendMessageToServer, suppressionMessageText, copyButton, getSuppressionPos, getSuppressionDimension, exceptionCauseText |
| top-level / `carpetamsaddition/helpers/rule/amsUpdateSuppressionCrashFix/UpdateSuppressionException.java` | `` |  | isUpdateSuppression |
| top-level / `carpetamsaddition/helpers/rule/blockChunkLoader/BlockChunkLoaderHelper.java` | `` |  | registerTicketType, addNoteBlockTicket, addPistonBlockTicket, addBellBlockTicket |
| top-level / `carpetamsaddition/helpers/rule/blockChunkLoader/BlockLoaderTicketTypeAccess.java` | `` |  |  |
| top-level / `carpetamsaddition/helpers/rule/blockHardnessSyncProtocol/BlockHardnessSyncCache.java` | `` |  | get, put, clear |
| top-level / `carpetamsaddition/helpers/rule/commandHere_commandWhere/CommandHereWhereHelper.java` | `` |  | getPos, getPos |
| top-level / `carpetamsaddition/helpers/rule/commandPlayerChunkLoadController/ChunkLoading.java` | `` |  | setPlayerInteraction, playerFromName |
| top-level / `carpetamsaddition/helpers/rule/customBlockUpdateSuppressor/BlockUpdateSuppressorExceptionHelper.java` | `` |  | getInstance, throwThrowableSuppression |
| top-level / `carpetamsaddition/helpers/rule/enhancedWorldEater/BlockBlackList.java` | `` |  | isIn |
| top-level / `carpetamsaddition/helpers/rule/fancyFakePlayerName/FancyFakePlayerNameTeamController.java` | `` |  | kickFakePlayerFromBotTeam, addBotTeam, removeBotTeam |
| top-level / `carpetamsaddition/helpers/rule/fancyFakePlayerName/FancyNameHelper.java` | `` |  | addBotTeamNamePrefix, addBotNameSuffix |
| top-level / `carpetamsaddition/helpers/rule/headHunter_commandGetPlayerSkull/SkullSkinHelper.java` | `` |  | writeNbtToPlayerSkull, writeNbtToPlayerSkull |
| top-level / `carpetamsaddition/helpers/rule/largeBundle/LargeBundleInventory.java` | `` |  | setChanged, setItem, getItem, getContainerSize, isEmpty, removeItem, removeItemNoUpdate, clearContent, stillValid, canInsert |
| top-level / `carpetamsaddition/helpers/rule/largeEnderChest/LargeEnderChestInventory.java` | `` |  | ensureCapacity |
| top-level / `carpetamsaddition/helpers/rule/optimizedDragonRespawn/BlockPatternHelper.java` | `` |  | partialSearchAround |
| top-level / `carpetamsaddition/helpers/rule/preventAdministratorCheat/PermissionHelper.java` | `` |  | canCheat |
| top-level / `carpetamsaddition/helpers/rule/sendPlayerDeathLocation/PlayerDeathLocationContext.java` | `` |  | sendMessage, realPlayerSendMessage, fakePlayerSendMessage, getPlayerName, getDimension, getPlayerPos, copyButton, formatMessage |
| top-level / `carpetamsaddition/helpers/SoundEffectHelper.java` | `` |  | playFlipSound |
| top-level / `carpetamsaddition/logging/AbstractHUDLogger.java` | `` |  | getName |
| top-level / `carpetamsaddition/logging/AmsCarpetHUDController.java` | `` |  | updateHUD, doHudLogging |
| top-level / `carpetamsaddition/logging/AmsCarpetLoggerRegistry.java` | `` |  | registerLoggers, standardHUDLogger, getLoggerField |
| top-level / `carpetamsaddition/logging/logger/ServerRuntimeHUDLogger.java` | `` |  | getInstance, onHudUpdate |
| top-level / `carpetamsaddition/mixin/carpet/fix/CarpetServerMixin.java` | `value={CarpetServer.class}, remap=false)` | Inject:1 | onlyCallIfServerNotnull |
| top-level / `carpetamsaddition/mixin/carpet/fix/ChunkMapMixin.java` | `value={DummyClass.class})` |  |  |
| top-level / `carpetamsaddition/mixin/carpet/HUDControllerMixin.java` | `value={HUDController.class})` | Inject:1 | update_hud |
| top-level / `carpetamsaddition/mixin/carpet/SettingsManagerMixin.java` | `value={SettingsManager.class})` | Inject:1 | printVersion |
| top-level / `carpetamsaddition/mixin/hooks/client/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | onTick |
| top-level / `carpetamsaddition/mixin/hooks/network/ClientPlayNetworkHandlerMixin.java` | `value={ClientPacketListener.class})` | Inject:1 | onGameJoin |
| top-level / `carpetamsaddition/mixin/hooks/network/MinecraftClientMixin.java` | `value={Minecraft.class})` | Inject:1 | onDisconnect |
| top-level / `carpetamsaddition/mixin/hooks/recipe/FileToIdConverterMixin.java` | `value={FileToIdConverter.class})` | Inject:1 | addCustomRecipes |
| top-level / `carpetamsaddition/mixin/hooks/recipe/RecipeManagerAccessor.java` | `value={RecipeManager.class})` | Accessor:1 |  |
| top-level / `carpetamsaddition/mixin/hooks/recipe/RecipeManagerMixin.java` | `value={DummyClass.class})` |  |  |
| top-level / `carpetamsaddition/mixin/hooks/server/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Inject:1 | afterServerLoadWorld |
| top-level / `carpetamsaddition/mixin/network/ClientPlayNetworkHandlerMixin.java` | `value={ClientCommonPacketListenerImpl.class})` | Inject:1 | onCustomPayload |
| top-level / `carpetamsaddition/mixin/network/CustomPayloadC2SPacketAccessor.java` | `value={DummyInterface.class})` |  |  |
| top-level / `carpetamsaddition/mixin/network/CustomPayloadC2SPacketMixin.java` | `value={ServerboundCustomPayloadPacket.class})` | ModifyArg:1 | registerAMSPayloadC2S |
| top-level / `carpetamsaddition/mixin/network/CustomPayloadS2CPacketAccessor.java` | `value={DummyInterface.class})` |  |  |
| top-level / `carpetamsaddition/mixin/network/CustomPayloadS2CPacketMixin.java` | `value={ClientboundCustomPayloadPacket.class})` | ModifyArg:1 | registerAMSPayloadS2C |
| top-level / `carpetamsaddition/mixin/network/ServerPlayNetworkHandlerMixin.java` | `value={ServerGamePacketListenerImpl.class})` | Inject:1 | onCustomPayload |
| top-level / `carpetamsaddition/mixin/rule/amsUpdateSuppressionCrashFix/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | WrapOperation:1 | tickWorlds |
| top-level / `carpetamsaddition/mixin/rule/amsUpdateSuppressionCrashFix/NeighborUpdaterMixin.java` | `value={NeighborUpdater.class})` | Inject:1 | tryNeighborUpdate |
| top-level / `carpetamsaddition/mixin/rule/bambooCollisionBoxDisabled/BambooStalkBlockMixin.java` | `value={BambooStalkBlock.class})` | ModifyReturnValue:1 | getCollisionShape |
| top-level / `carpetamsaddition/mixin/rule/bambooModelNoOffset/BlockStateBaseInvoker.java` | `value={BlockBehaviour.BlockStateBase.class})` | Invoker:1 |  |
| top-level / `carpetamsaddition/mixin/rule/bambooModelNoOffset/BlockStateBaseMixin.java` | `value={BlockBehaviour.BlockStateBase.class})` | ModifyReturnValue:1 | getModelOffset |
| top-level / `carpetamsaddition/mixin/rule/blockChunkLoader/BellBlockMixin.java` | `value={BellBlock.class})` | Inject:1 | ring |
| top-level / `carpetamsaddition/mixin/rule/blockChunkLoader/BuiltInRegistriesMixin.java` | `value={BuiltInRegistries.class})` | Inject:1 | addAmsTicketType |
| top-level / `carpetamsaddition/mixin/rule/blockChunkLoader/NoteBlockMixin.java` | `value={NoteBlock.class})` | Inject:1 | playNoteMixin, handleChunkLoading, loadChunkIfMatch |
| top-level / `carpetamsaddition/mixin/rule/blockChunkLoader/PistonBaseBlockMixin.java` | `value={PistonBaseBlock.class})` | Inject:1 | onSyncedBlockEvent, handleChunkLoading, loadChunkIfMatch, optionIsBoneBlockOrAll, optionIsBedRockOrAll |
| top-level / `carpetamsaddition/mixin/rule/blockChunkLoader/TicketTypeMixin.java` | `value={TicketType.class})` | ModifyReturnValue:1 | ams$enableBlockLoaderTimeout, blockChunkLoaderTimeout |
| top-level / `carpetamsaddition/mixin/rule/blockHardnessSyncProtocol/BlockStateBaseMixin.java` | `value={BlockBehaviour.BlockStateBase.class}, priority=168)` | Inject:1 | applyServerHardness |
| top-level / `carpetamsaddition/mixin/rule/blockHardnessSyncProtocol/MultiPlayerGameModeMixin.java` | `value={MultiPlayerGameMode.class})` | Inject:1 | requestServerHardness |
| top-level / `carpetamsaddition/mixin/rule/blowUpEverything/BlockMixin.java` | `value={Block.class})` | ModifyReturnValue:1 | getBlastResistance |
| top-level / `carpetamsaddition/mixin/rule/blueSkullController/WitherBossMixin.java` | `value={WitherBoss.class}, priority=168)` | ModifyVariable:1 | shootSkullAt |
| top-level / `carpetamsaddition/mixin/rule/breedableParrots/ParrotMixin.java` | `value={Parrot.class})` | Inject:4 | initGoals, isBreedingItem, canBreedWith, createChild |
| top-level / `carpetamsaddition/mixin/rule/cakeBlockDropOnBreak/BlockMixin.java` | `value={Block.class})` | Inject:1 | onBreak |
| top-level / `carpetamsaddition/mixin/rule/carpetAlwaysSetDefault/Carpet_SettingsManagerMixin.java` | `value={SettingsManager.class})` | Inject:1 | setRule |
| top-level / `carpetamsaddition/mixin/rule/commandAnvilInteractionDisabled/AnvilBlockMixin.java` | `value={AnvilBlock.class})` | Inject:1 | onUse |
| top-level / `carpetamsaddition/mixin/rule/commandCustomAntiFireItems/ItemEntityInvoker.java` | `value={ItemEntity.class})` | Invoker:1 |  |
| top-level / `carpetamsaddition/mixin/rule/commandCustomAntiFireItems/ItemEntityMixin.java` | `value={ItemEntity.class})` | ModifyReturnValue:1 | isFireImmune |
| top-level / `carpetamsaddition/mixin/rule/commandCustomBlockBlastResistance/BlockMixin.java` | `value={Block.class})` | ModifyReturnValue:1 | getBlastResistance |
| top-level / `carpetamsaddition/mixin/rule/commandCustomBlockBlastResistance/FluidStateInvoker.java` | `value={FluidState.class})` | Invoker:1 |  |
| top-level / `carpetamsaddition/mixin/rule/commandCustomBlockBlastResistance/FluidStateMixin.java` | `value={FluidState.class})` | ModifyReturnValue:1 | getBlastResistance |
| top-level / `carpetamsaddition/mixin/rule/commandCustomBlockHardness/BlocksMixin.java` | `value={Blocks.class}, priority=16888)` | Inject:1 | registerCustomBlockHardness |
| top-level / `carpetamsaddition/mixin/rule/commandCustomBlockHardness/BlockStateBaseInvoker.java` | `value={BlockBehaviour.BlockStateBase.class})` | Invoker:1 |  |
| top-level / `carpetamsaddition/mixin/rule/commandCustomBlockHardness/BlockStateBaseMixin.java` | `value={BlockBehaviour.BlockStateBase.class}, priority=16888)` | ModifyReturnValue:1 | modifyHardness |
| top-level / `carpetamsaddition/mixin/rule/commandCustomBlockHardness/PistonBlockMixin.java` | `value={PistonBaseBlock.class}, priority=16888)` | WrapOperation:1 | noPush |
| top-level / `carpetamsaddition/mixin/rule/commandCustomCommandPermissionLevel/CommandDispatcherMixin.java` | `value={CommandDispatcher.class}, priority=1688)` | Inject:2 | saveDefaultRequirement, modifyPermissionLevel |
| top-level / `carpetamsaddition/mixin/rule/commandCustomCommandPermissionLevel/CommandNodeInvoker.java` | `value={CommandNode.class}, remap=false)` | Accessor:1 |  |
| top-level / `carpetamsaddition/mixin/rule/commandCustomMovableBlock/PistonBaseBlockMixin.java` | `value={PistonBaseBlock.class})` | Inject:1 | MovableBlocks |
| top-level / `carpetamsaddition/mixin/rule/commandGetClientPlayerFPS/MinecraftInvoker.java` | `value={Minecraft.class})` | Invoker:1 |  |
| top-level / `carpetamsaddition/mixin/rule/commandPlayerChunkLoadController/ChunkMapMixin.java` | `value={ChunkMap.class})` | Inject:1 | doesNotGenerateChunks |
| top-level / `carpetamsaddition/mixin/rule/commandPlayerLeader/ServerPlayerMixin.java` | `value={ServerPlayer.class})` | Inject:1 | copyFrom |
| top-level / `carpetamsaddition/mixin/rule/commandPlayerNoNetherPortalTeleport/NetherPortalBlockMixin.java` | `value={NetherPortalBlock.class})` | WrapOperation:1 | preventPlayerTeleport, shouldPreventTeleport |
| top-level / `carpetamsaddition/mixin/rule/commandSetPlayerPose/EntityMixin.java` | `value={Entity.class})` | ModifyReturnValue:1 | doSomePose |
| top-level / `carpetamsaddition/mixin/rule/craftableCarvedPumpkin/ShapelessRecipeMixin.java` | `value={ShapelessRecipe.class})` |  | processDurability |
| top-level / `carpetamsaddition/mixin/rule/creativeOneHitKill/EntityAccessorAndInvoker.java` | `value={Entity.class})` | Accessor:1, Invoker:4 |  |
| top-level / `carpetamsaddition/mixin/rule/creativeOneHitKill/PlayerAccessorAndInvoker.java` | `value={Player.class})` | Accessor:1, Invoker:1 |  |
| top-level / `carpetamsaddition/mixin/rule/creativeOneHitKill/PlayerMixin.java` | `value={Player.class})` | Inject:1 | attack, instaKill, aoeAttack, playSweepSoundEffect, playCritSoundEffect |
| top-level / `carpetamsaddition/mixin/rule/creativeShulkerBoxDropsDisabled/ShulkerBoxBlockMixin.java` | `value={ShulkerBoxBlock.class})` | Inject:1 | onBreak |
| top-level / `carpetamsaddition/mixin/rule/cryingObsidianNetherPortal/NetherPortalMixin.java` | `value={PortalShape.class})` | ModifyReturnValue:1 | acceptCryingObsidianCreateNetherPortal |
| top-level / `carpetamsaddition/mixin/rule/cryingObsidianNetherPortal/PortalShapeMixin.java` | `value={PortalShape.class})` | ModifyReturnValue:1 | acceptCryingObsidianCreateNetherPortal |
| top-level / `carpetamsaddition/mixin/rule/customBlockUpdateSuppressor/BlockBehaviourMixin.java` | `value={BlockBehaviour.class})` | Inject:1 | neighborUpdate |
| top-level / `carpetamsaddition/mixin/rule/customizedNetherPortal/BlockStateBaseInvoker.java` | `value={BlockBehaviour.BlockStateBase.class})` | Invoker:1 |  |
| top-level / `carpetamsaddition/mixin/rule/customizedNetherPortal/BlockStateBaseMixin.java` | `value={BlockBehaviour.BlockStateBase.class})` | ModifyReturnValue:1 | canBreakNetherPortalBlock |
| top-level / `carpetamsaddition/mixin/rule/customizedNetherPortal/NetherPortalBlockMixin.java` | `value={NetherPortalBlock.class})` | ModifyReturnValue:1 | noBreak |
| top-level / `carpetamsaddition/mixin/rule/easyCompost/ComposterBlockMixin.java` | `value={ComposterBlock.class})` | ModifyExpressionValue:1 | easyCompost |
| top-level / `carpetamsaddition/mixin/rule/easyGetPitcherPod/BlockMixin.java` | `value={Block.class})` | Inject:1 | onBreak |
| top-level / `carpetamsaddition/mixin/rule/easyMaxLevelBeacon/BeaconBlockEntityMixin.java` | `value={BeaconBlockEntity.class})` | Inject:1 | updateLevel |
| top-level / `carpetamsaddition/mixin/rule/easyMineDragonEgg/DragonEggBlockMixin.java` | `value={DragonEggBlock.class})` | ModifyExpressionValue:1 | teleport |
| top-level / `carpetamsaddition/mixin/rule/easyRefreshTrades/AbstractVillagerInvoker.java` | `value={AbstractVillager.class})` | Invoker:1 |  |
| top-level / `carpetamsaddition/mixin/rule/easyRefreshTrades/VillagerInvoker.java` | `value={Villager.class})` | Invoker:1 |  |
| top-level / `carpetamsaddition/mixin/rule/easyRefreshTrades/VillagerMixin.java` | `value={Villager.class})` | WrapOperation:1, Inject:1 | refreshRecipes, updateRecipes, isNewMerchant |
| top-level / `carpetamsaddition/mixin/rule/easyWitherSkeletonSkullDrop/LivingEntityMixin.java` | `value={LivingEntity.class})` | Inject:1 | dropSkull |
| top-level / `carpetamsaddition/mixin/rule/enderDragonNoDestroyBlock/EnderDragonMixin.java` | `value={EnderDragon.class})` | WrapOperation:1 | enderDragonNoDestroyBlock |
| top-level / `carpetamsaddition/mixin/rule/endermanPickUpDisabled/EndermanTakeBlockGoalMixin.java` | `targets={"net.minecraft.world.entity.monster.Enderman$EndermanTakeBlockGoal"})` | ModifyReturnValue:1 | canStart |
| top-level / `carpetamsaddition/mixin/rule/endermanTeleportRandomlyDisabled/EnderManMixin.java` | `value={Enderman.class})` | Inject:1 | teleportRandomly |
| top-level / `carpetamsaddition/mixin/rule/endPortalChunkLoadDisabled/EndPortalBlockMixin.java` | `value={EndPortalBlock.class})` | WrapOperation:1 | endPortalChunkLoadDisabled |
| top-level / `carpetamsaddition/mixin/rule/enhancedWorldEater/BlockMixin.java` | `value={Block.class})` | Inject:1 | getBlastResistance |
| top-level / `carpetamsaddition/mixin/rule/experimentalContentCheckDisabled/FeatureSetMixin.java` | `value={DummyClass.class})` |  |  |
| top-level / `carpetamsaddition/mixin/rule/experimentalContentCheckDisabled/ToggleableFeatureMixin.java` | `value={DummyInterface.class})` |  |  |
| top-level / `carpetamsaddition/mixin/rule/experimentalMinecart/AbstractMinecartMixin.java` | `value={AbstractMinecart.class}, priority=168)` | ModifyReturnValue:1 | setExMinecartEnabled |
| top-level / `carpetamsaddition/mixin/rule/experimentalMinecart/ExperimentalMinecartControllerMixin.java` | `value={NewMinecartBehavior.class}, priority=168)` | ModifyReturnValue:1 | setMaxSpeed |
| top-level / `carpetamsaddition/mixin/rule/experimentalMinecart/FeatureSetMixin.java` | `value={FeatureFlagSet.class}, priority=168)` | ModifyReturnValue:2 | beVanilla, includeExperimentalMinecart |
| top-level / `carpetamsaddition/mixin/rule/experimentalMinecart/GameRuleCommand_visitMixin.java` | `targets={"net.minecraft.server.commands.GameRuleCommand$1"}, priority=168)` | Inject:1 | test |
| top-level / `carpetamsaddition/mixin/rule/experimentalMinecart/GameRuleCommandMixin.java` | `value={GameRuleCommand.class}, priority=1024)` | Inject:1 | onSet |
| top-level / `carpetamsaddition/mixin/rule/experimentalMinecart/GameRulesMixin.java` | `value={GameRules.class}, priority=168)` | WrapOperation:1 | beVanilla |
| top-level / `carpetamsaddition/mixin/rule/experimentalMinecart/MinecartControllerAccessor.java` | `value={MinecartBehavior.class})` | Accessor:1 |  |
| top-level / `carpetamsaddition/mixin/rule/extinguishedCampfire/CampfireBlockMixin.java` | `value={CampfireBlock.class})` | ModifyReturnValue:1 | setPlacementState |
| top-level / `carpetamsaddition/mixin/rule/fakePeace/NaturalSpawnerMixin.java` | `value={NaturalSpawner.class})` | WrapOperation:1 | allowsSpawning |
| top-level / `carpetamsaddition/mixin/rule/fakePlayerDefaultSurvivalMode/Carpet_PlayerCommandMixin.java` | `value={PlayerCommand.class})` | WrapOperation:1, ModifyExpressionValue:1 | fakePlayerDefaultSurvivalMode, noFly |
| top-level / `carpetamsaddition/mixin/rule/fakePlayerInteractLikeClient/AbstractBoatInvoker.java` | `value={AbstractBoat.class})` | Accessor:1 |  |
| top-level / `carpetamsaddition/mixin/rule/fakePlayerInteractLikeClient/EntityPlayerActionPackActionTypeMixin.java` | `targets={"carpet.helpers.EntityPlayerActionPack$ActionType$1"})` | WrapOperation:2 | onInteractAt, onInteractOn |
| top-level / `carpetamsaddition/mixin/rule/fakePlayerNoScoreboardCounter/PlayerMixin.java` | `value={Player.class})` | Inject:1 | increaseStat |
| top-level / `carpetamsaddition/mixin/rule/fakePlayerPickUpController/ItemEntityMixin.java` | `value={ItemEntity.class})` | Inject:1 | onCanReplaceCurrentItem |
| top-level / `carpetamsaddition/mixin/rule/fakePlayerUseOfflinePlayerUuid/Carpet_EntityPlayerMPFakeMixin.java` | `value={EntityPlayerMPFake.class})` | WrapOperation:1 | useOfflinePlayerUUID |
| top-level / `carpetamsaddition/mixin/rule/fakePlayerUseOfflinePlayerUuid/Carpet_PlayerCommandMixin.java` | `value={PlayerCommand.class})` | WrapOperation:1 | useOfflinePlayerUUID |
| top-level / `carpetamsaddition/mixin/rule/fancyFakePlayerName/CarpetMod_PlayerCommandMixin.java` | `value={PlayerCommand.class})` | WrapOperation:2 | spawn, cantSpawn |
| top-level / `carpetamsaddition/mixin/rule/fancyFakePlayerName/PlayerManagerMixin.java` | `value={PlayerList.class})` | Inject:2 | onPlayerConnects, kickFakePlayerFromBotTeam |
| top-level / `carpetamsaddition/mixin/rule/fasterMovement/PlayerMixin.java` | `value={Player.class})` | Inject:1 | getMovementSpeed |
| top-level / `carpetamsaddition/mixin/rule/fertilizableSmallFlower/BlockMixin.java` | `value={FlowerBlock.class})` |  | isValidBonemealTarget, isBonemealSuccess, performBonemeal |
| top-level / `carpetamsaddition/mixin/rule/flippinCactusExtras/Carpet_BlockRotatorMixin.java` | `value={BlockRotator.class})` | Inject:1 | flipCactusExtras |
| top-level / `carpetamsaddition/mixin/rule/flippinCactusSoundEffect/Carpet_BlockRotatorMixin.java` | `value={BlockRotator.class})` | Inject:1 | playFlipSound |
| top-level / `carpetamsaddition/mixin/rule/foliageGenerateDisabled/FoliagePlacerMixin.java` | `value={FoliagePlacer.class})` | Inject:1 | generateSquare |
| top-level / `carpetamsaddition/mixin/rule/foliageGenerateDisabled/HugeFungusFeatureMixin.java` | `value={HugeFungusFeature.class})` | Inject:2 | generateVines, generateHat |
| top-level / `carpetamsaddition/mixin/rule/fullMoonEveryDay/DimensionTypeMixin.java` | `value={DummyClass.class})` |  |  |
| top-level / `carpetamsaddition/mixin/rule/fullMoonEveryDay/MoonPhaseMixin.java` | `value={MoonPhase.class})` | ModifyReturnValue:1 | fullMoonEveryDay |
| top-level / `carpetamsaddition/mixin/rule/furnaceSmeltingTimeController/AbstractFurnaceBlockEntityMixin.java` | `value={AbstractFurnaceBlockEntity.class})` | ModifyReturnValue:1 | setCookTime |
| top-level / `carpetamsaddition/mixin/rule/headHunter/PlayerMixin.java` | `value={Player.class})` | Inject:1 | dropPlayerSkull |
| top-level / `carpetamsaddition/mixin/rule/hopperSuctionDisabled/HopperBlockEntityMixin.java` | `value={HopperBlockEntity.class})` | ModifyExpressionValue:1 | redirectSuckInItems |
| top-level / `carpetamsaddition/mixin/rule/infiniteDurability/ItemStackMixin.java` | `value={ItemStack.class})` | ModifyVariable:1 | infiniteDurability |
| top-level / `carpetamsaddition/mixin/rule/infiniteTrades/MerchantOfferAccessor.java` | `value={MerchantOffer.class})` | Accessor:1 |  |
| top-level / `carpetamsaddition/mixin/rule/infiniteTrades/MerchantOfferMixin.java` | `value={MerchantOffer.class})` | Inject:1 | resetUses |
| top-level / `carpetamsaddition/mixin/rule/ironGolemNoDropFlower/EntityMixin.java` | `value={Entity.class})` | ModifyVariable:1 | noDropPoppy |
| top-level / `carpetamsaddition/mixin/rule/itemAntiExplosion/ExplosionMixin.java` | `value={DummyClass.class})` |  |  |
| top-level / `carpetamsaddition/mixin/rule/itemAntiExplosion/ItemEntityMixin.java` | `value={ItemEntity.class})` | ModifyVariable:1 | noDamage |
| top-level / `carpetamsaddition/mixin/rule/itemAntiExplosion/ServerExplosionMixin.java` | `value={ServerExplosion.class})` | WrapOperation:1 | onSetVelocity |
| top-level / `carpetamsaddition/mixin/rule/itemEntityCreateNetherPortalDisabled/NetherPortalBlockMixin.java` | `value={NetherPortalBlock.class})` | WrapOperation:1 | itemEntityCreateNetherPortalDisabled |
| top-level / `carpetamsaddition/mixin/rule/jebSheepDropRandomColorWool/SheepMixin.java` | `value={Sheep.class})` | WrapOperation:1 | redirectDropStack, isJebSheep |
| top-level / `carpetamsaddition/mixin/rule/keepWorldTickUpdate/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:1 | tick |
| top-level / `carpetamsaddition/mixin/rule/kirinArm/PlayerMixin.java` | `value={Player.class})` | ModifyReturnValue:1 | getBlockBreakingSpeed |
| top-level / `carpetamsaddition/mixin/rule/largeBundle/BundleItemMixin.java` | `value={BundleItem.class})` | WrapMethod:1, Inject:6 | onUse, onIsItemBarVisible, onGetItemBarStep, onGetTooltipData, onDropAllBundledItems, onClicked, onStackClicked |
| top-level / `carpetamsaddition/mixin/rule/largeBundle/SlotAccessor.java` | `value={Slot.class})` | Accessor:1 |  |
| top-level / `carpetamsaddition/mixin/rule/largeBundle/SlotMixin.java` | `value={Slot.class})` | ModifyReturnValue:1 | canInsert |
| top-level / `carpetamsaddition/mixin/rule/largeEnderChest/EnderChestBlockMixin.java` | `value={EnderChestBlock.class})` | WrapOperation:1 | onUse |
| top-level / `carpetamsaddition/mixin/rule/largeEnderChest/PlayerEnderChestContainerMixin.java` | `value={PlayerEnderChestContainer.class})` | Inject:1 | expandWhenEnabled |
| top-level / `carpetamsaddition/mixin/rule/largeEnderChest/PlayerEntityMixin.java` | `value={Player.class})` | Inject:1 | expandEnderChestWhenEnabled |
| top-level / `carpetamsaddition/mixin/rule/largeEnderChest/SimpleContainerAccessor.java` | `value={SimpleContainer.class})` | Accessor:2 |  |
| top-level / `carpetamsaddition/mixin/rule/largeShulkerBox/ServerGamePacketListenerImplMixin.java` | `value={ServerGamePacketListenerImpl.class})` | Inject:1 | syncLargeShulkerAfterClick |
| top-level / `carpetamsaddition/mixin/rule/largeShulkerBox/ShulkerBoxBlockEntityMixin.java` | `value={ShulkerBoxBlockEntity.class}, priority=1024)` | ModifyReturnValue:1, Inject:2 | size, onTick, ams$updateRuleState, getAvailableSlots |
| top-level / `carpetamsaddition/mixin/rule/largeShulkerBox/ShulkerBoxMenuMixin.java` | `value={ShulkerBoxMenu.class}, priority=1024)` | ModifyArg:2, Inject:1 | getScreenHandlerType, checkLargerSize, addingExtraSlots |
| top-level / `carpetamsaddition/mixin/rule/maxChainUpdateDepth/CollectingNeighborUpdaterAccessor.java` | `value={CollectingNeighborUpdater.class})` | Accessor:1 |  |
| top-level / `carpetamsaddition/mixin/rule/maxChainUpdateDepth/CollectingNeighborUpdaterMixin.java` | `value={CollectingNeighborUpdater.class})` | ModifyExpressionValue:1 | modifyMaxChainDepth |
| top-level / `carpetamsaddition/mixin/rule/maxClientInteractionReachDistance/ClientPlayerInteractionManagerMixin.java` | `value={DummyClass.class})` |  |  |
| top-level / `carpetamsaddition/mixin/rule/maxClientInteractionReachDistance/GameRendererMixin.java` | `value={DummyClass.class})` |  |  |
| top-level / `carpetamsaddition/mixin/rule/maxClientInteractionReachDistance/LocalPlayerMixin.java` | `value={LocalPlayer.class}, priority=1688)` | WrapOperation:2 | modifyBlockInteractionRange, modifyEntityInteractionRange |
| top-level / `carpetamsaddition/mixin/rule/maxClientInteractionReachDistance/PlayerMixin.java` | `value={Player.class}, priority=1688)` |  |  |
| top-level / `carpetamsaddition/mixin/rule/maxPlayerInteractionRange/AbstractContainerMenuMixin.java` | `value={DummyClass.class})` |  |  |
| top-level / `carpetamsaddition/mixin/rule/maxPlayerInteractionRange/AttributeCommandMixin.java` | `value={AttributeCommand.class}, priority=1688)` | WrapOperation:2 | disableBlockInteractionRangeSet, disableEntityInteractionRangeSet |
| top-level / `carpetamsaddition/mixin/rule/maxPlayerInteractionRange/AttributeInstanceInvoker.java` | `value={AttributeInstance.class})` | Invoker:1 |  |
| top-level / `carpetamsaddition/mixin/rule/maxPlayerInteractionRange/AttributeInstanceMixin.java` | `value={AttributeInstance.class}, priority=1688)` | ModifyReturnValue:2 | getPlayerBlockInteractionBaseValue, getPlayerEntityInteractionBaseValue |
| top-level / `carpetamsaddition/mixin/rule/maxPlayerInteractionRange/BlockEntityContainerMixin.java` | `value={DummyClass.class})` |  |  |
| top-level / `carpetamsaddition/mixin/rule/maxPlayerInteractionRange/GameRendererMixin.java` | `value={DummyClass.class})` |  |  |
| top-level / `carpetamsaddition/mixin/rule/maxPlayerInteractionRange/ItemCombinerMenuMixin.java` | `value={AbstractContainerMenu.class})` |  |  |
| top-level / `carpetamsaddition/mixin/rule/maxPlayerInteractionRange/PlayerMixin.java` | `value={Player.class}, priority=1688)` | WrapOperation:2 | canInteractWithBlockAt, canInteractWithEntityAt1 |
| top-level / `carpetamsaddition/mixin/rule/maxPlayerInteractionRange/RangedAttributeMixin.java` | `value={RangedAttribute.class})` | ModifyReturnValue:2 | modifyPlayerBlockInteractionMaxValue, modifyPlayerEntityInteractionMaxValue |
| top-level / `carpetamsaddition/mixin/rule/maxPlayerInteractionRange/ServerPlayerInteractionManagerMixin.java` | `value={DummyClass.class})` |  |  |
| top-level / `carpetamsaddition/mixin/rule/maxPlayerInteractionRange/ServerPlayNetworkHandlerMixin.java` | `value={DummyClass.class})` |  |  |
| top-level / `carpetamsaddition/mixin/rule/meekEnderman/EnderManMixin.java` | `value={Enderman.class})` | ModifyReturnValue:1 | goodBaby |
| top-level / `carpetamsaddition/mixin/rule/mitePearl/ThrownEnderpearlMixin.java` | `value={ThrownEnderpearl.class})` | ModifyExpressionValue:1 | mitePearl |
| top-level / `carpetamsaddition/mixin/rule/netherWaterPlacement/BucketItemMixin.java` | `value={BucketItem.class})` | ModifyExpressionValue:1 | netherWaterPlacement |
| top-level / `carpetamsaddition/mixin/rule/noCakeEating/CakeBlockMixin.java` | `value={CakeBlock.class})` | ModifyReturnValue:1 | noEat |
| top-level / `carpetamsaddition/mixin/rule/noEnchantedGoldenAppleEating/ItemStackMixin.java` | `value={ItemStack.class})` | Inject:1 | use |
| top-level / `carpetamsaddition/mixin/rule/noFamilyPlanning/AgeableMobMixin.java` | `value={AgeableMob.class})` | ModifyReturnValue:1 | getBreedingAge |
| top-level / `carpetamsaddition/mixin/rule/onlyOpCanSpawnRealPlayerInWhitelist/Carpet_PlayerCommandMixin.java` | `value={PlayerCommand.class})` | ModifyExpressionValue:1 | onlyOpCanSpawnRealPlayerInWhitelist |
| top-level / `carpetamsaddition/mixin/rule/onlyPlayerCanCreateNetherPortal/NetherPortalBlockMixin.java` | `value={NetherPortalBlock.class})` | WrapOperation:1 | itemEntityCreateNetherPortalDisabled |
| top-level / `carpetamsaddition/mixin/rule/optimizedDragonRespawn/BlockPatternMixin.java` | `value={BlockPattern.class})` | Invoker:1 |  |
| top-level / `carpetamsaddition/mixin/rule/optimizedDragonRespawn/EndDragonFightMixin.java` | `value={DummyClass.class})` |  |  |
| top-level / `carpetamsaddition/mixin/rule/optimizedDragonRespawn/EnderDragonFightMixin.java` | `value={EnderDragonFight.class}, priority=888)` | WrapMethod:1, Inject:1 | findEndPortal, resetCache |
| top-level / `carpetamsaddition/mixin/rule/perfectInvisibility_sneakInvisibility/EntityInvoker.java` | `value={Entity.class})` | Invoker:2 |  |
| top-level / `carpetamsaddition/mixin/rule/perfectInvisibility_sneakInvisibility/LivingEntityMixin.java` | `value={LivingEntity.class})` | ModifyReturnValue:2 | modifyAttackDistanceScalingFactor, sneakInvisibility |
| top-level / `carpetamsaddition/mixin/rule/phantomSpawnAlert/PhantomSpawnerMixin.java` | `value={PhantomSpawner.class})` | Inject:1 | broadcastMessage |
| top-level / `carpetamsaddition/mixin/rule/pointedDripstoneCollisionBoxDisabled/BlockStateBaseMixin.java` | `value={BlockBehaviour.BlockStateBase.class})` | ModifyReturnValue:1 | getCollisionShape |
| top-level / `carpetamsaddition/mixin/rule/powerfulExpMending/ExperienceOrbMixin.java` | `value={ExperienceOrb.class})` | Inject:1 | fixAllItems, hasMendingEnchantment |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/AdvancementCommandsMixin.java` | `value={AdvancementCommands.class})` | ModifyArg:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/DataCommandsMixin.java` | `value={DataCommands.class})` | ModifyArg:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/DefaultGameModeCommandsMixin.java` | `value={DefaultGameModeCommands.class})` | ModifyArg:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/DifficultyCommandsMixin.java` | `value={DifficultyCommand.class})` | ModifyArg:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/EffectCommandsMixin.java` | `value={EffectCommands.class})` | ModifyArg:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/EnchantCommandsMixin.java` | `value={EnchantCommand.class})` | ModifyArg:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/ExperienceCommandsMixin.java` | `value={ExperienceCommand.class})` | ModifyArg:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/FillCommandsMixin.java` | `value={FillCommand.class})` | ModifyArg:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/GamemodeCommandsMixin.java` | `value={GameModeCommand.class})` | ModifyArg:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/GameRuleCommandsMixin.java` | `value={GameRuleCommand.class})` | ModifyArg:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/GiveCommandsMixin.java` | `value={GiveCommand.class})` | ModifyArg:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/KillCommandsMixin.java` | `value={KillCommand.class})` | ModifyArg:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/ServerGamePacketListenerImplMixin.java` | `value={ServerGamePacketListenerImpl.class})` | WrapOperation:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/SetBlockCommandsMixin.java` | `value={SetBlockCommand.class})` | ModifyArg:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/SummonCommandsMixin.java` | `value={SummonCommand.class})` | ModifyArg:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/TeleportCommandsMixin.java` | `value={TeleportCommand.class})` | ModifyArg:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/TimeCommandsMixin.java` | `value={TimeCommand.class})` | ModifyArg:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventAdministratorCheat/WeatherCommandsMixin.java` | `value={WeatherCommand.class})` | ModifyArg:1 | preventCheat |
| top-level / `carpetamsaddition/mixin/rule/preventEndSpikeRespawn/DragonRespawnStageMixin.java` | `targets={"net/minecraft/world/level/dimension/end/DragonRespawnStage$3"})` | WrapOperation:2 | onRemoveBlock, onCreateExplosion |
| top-level / `carpetamsaddition/mixin/rule/preventEndSpikeRespawn/EndSpikeFeatureMixin.java` | `value={EndSpikeFeature.class})` | WrapOperation:1, Inject:1 | onSetBlockState, onSpawnEntity |
| top-level / `carpetamsaddition/mixin/rule/preventServerPause/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | WrapOperation:1 | preventServerPause |
| top-level / `carpetamsaddition/mixin/rule/quickVillagerLevelUp/VillagerInvoker.java` | `value={Villager.class})` | Invoker:2 |  |
| top-level / `carpetamsaddition/mixin/rule/quickVillagerLevelUp/VillagerMixin.java` | `value={Villager.class})` | Inject:1 | quickLevelUp |
| top-level / `carpetamsaddition/mixin/rule/redstoneComponentSound/DaylightDetectorBlockMixin.java` | `value={DaylightDetectorBlock.class})` | Inject:1 | playSound |
| top-level / `carpetamsaddition/mixin/rule/redstoneComponentSound/RedstoneWireBlockMixin.java` | `value={RedstoneWireBlock.class})` | Inject:1 | playSound |
| top-level / `carpetamsaddition/mixin/rule/redstoneComponentSound/RepeaterBlockMixin.java` | `value={RepeaterBlock.class})` | Inject:1 | playSound |
| top-level / `carpetamsaddition/mixin/rule/regeneratingDragonEgg/EndDragonFightMixin.java` | `value={EnderDragonFight.class})` | ModifyExpressionValue:1 | generateEggAfterEachDragonDeath |
| top-level / `carpetamsaddition/mixin/rule/renewableNetherScrap/EntityMixin.java` | `value={Entity.class})` | Inject:1 | dropNetheriteScrap |
| top-level / `carpetamsaddition/mixin/rule/safeFlight_invulnerable/ServerPlayerMixin.java` | `value={ServerPlayer.class})` | Inject:1 | isInvulnerableTo |
| top-level / `carpetamsaddition/mixin/rule/safePointedDripstone/PointedDripstoneBlockMixin.java` | `value={PointedDripstoneBlock.class})` | Inject:1 | onLandedUpon |
| top-level / `carpetamsaddition/mixin/rule/scheduledRandomTick/BambooStalkBlockMixin.java` | `value={BambooStalkBlock.class})` | Inject:2 | scheduleTickMixinInvoke, scheduleTickMixinTail |
| top-level / `carpetamsaddition/mixin/rule/scheduledRandomTick/CactusBlockMixin.java` | `value={CactusBlock.class})` | Inject:2 | scheduleTickMixinInvoke, scheduleTickMixinTail |
| top-level / `carpetamsaddition/mixin/rule/scheduledRandomTick/ChorusFlowerBlockMixin.java` | `value={ChorusFlowerBlock.class})` | Inject:2 | scheduleTickMixinInvoke, scheduleTickMixinTail |
| top-level / `carpetamsaddition/mixin/rule/scheduledRandomTick/GrowingPlantBlockMixin.java` | `value={GrowingPlantBlock.class})` | Inject:2 | scheduleTickMixinInvoke, scheduleTickMixinTail |
| top-level / `carpetamsaddition/mixin/rule/scheduledRandomTick/SugarCaneBlockMixin.java` | `value={SugarCaneBlock.class})` | Inject:2 | scheduleTickMixinInvoke, scheduleTickMixinTail |
| top-level / `carpetamsaddition/mixin/rule/sendPlayerDeathLocation/ServerPlayerInvoker.java` | `value={ServerPlayer.class})` | Invoker:1 |  |
| top-level / `carpetamsaddition/mixin/rule/sendPlayerDeathLocation/ServerPlayerMixin.java` | `value={ServerPlayer.class})` | Inject:1 | sendDeathLocation |
| top-level / `carpetamsaddition/mixin/rule/sensibleEnderman/EndermanTakeBlockGoalMixin.java` | `targets={"net.minecraft.world.entity.monster.Enderman$EndermanTakeBlockGoal"})` | WrapOperation:1 | isBlockInTag |
| top-level / `carpetamsaddition/mixin/rule/sharedVillagerDiscounts/EntityGossipsInvoker.java` | `targets={"net.minecraft.world.entity.ai.gossip.GossipContainer$EntityGossips"})` | Invoker:1 |  |
| top-level / `carpetamsaddition/mixin/rule/sharedVillagerDiscounts/GossipContainerAccessor.java` | `value={GossipContainer.class})` | Accessor:1 |  |
| top-level / `carpetamsaddition/mixin/rule/sharedVillagerDiscounts/GossipContainerMixin.java` | `value={GossipContainer.class})` | Inject:1 | getReputation |
| top-level / `carpetamsaddition/mixin/rule/shulkerGolem/CarvedPumpkinBlockMixin.java` | `value={CarvedPumpkinBlock.class})` | Inject:1 | trySpawnShulker |
| top-level / `carpetamsaddition/mixin/rule/shulkerHitLevitationDisabled_immuneShulkerBullet/ShulkerBulletMixin.java` | `value={ShulkerBullet.class})` | ModifyArg:1, WrapMethod:1 | noLevitation, immuneShulkerBullet |
| top-level / `carpetamsaddition/mixin/rule/sneakToEatCake/CakeBlockMixin.java` | `value={CakeBlock.class})` | WrapOperation:1 | tryEat |
| top-level / `carpetamsaddition/mixin/rule/sneakToEditSign/SignBlockEntityMixin.java` | `value={DummyClass.class})` |  |  |
| top-level / `carpetamsaddition/mixin/rule/sneakToEditSign/SignBlockMixin.java` | `value={SignBlock.class})` | ModifyExpressionValue:1 | onUse |
| top-level / `carpetamsaddition/mixin/rule/stackableDiscount/GossipTypeAccessor.java` | `value={GossipType.class})` | Accessor:2 |  |
| top-level / `carpetamsaddition/mixin/rule/stringDupeReintroduced/TripwireHookBlockMixin.java` | `value={TripWireHookBlock.class})` | ModifyExpressionValue:1 | stringDupeReintroduced |
| top-level / `carpetamsaddition/mixin/rule/strongLeash/FireworkRocketItemMixin.java` | `value={FireworkRocketItem.class})` | WrapOperation:1 | strongLeash |
| top-level / `carpetamsaddition/mixin/rule/strongLeash/HappyGhastMixin.java` | `value={HappyGhast.class})` | ModifyReturnValue:1 | modifyLeashSnappingDistance |
| top-level / `carpetamsaddition/mixin/rule/strongLeash/LeashableMixin.java` | `value={Leashable.class})` | ModifyReturnValue:1 | modifyLeashSnappingDistance |
| top-level / `carpetamsaddition/mixin/rule/strongLeash/PathfinderMobMixin.java` | `value={PathfinderMob.class})` |  |  |
| top-level / `carpetamsaddition/mixin/rule/superBow/EnchantmentMixin.java` | `value={Enchantment.class})` | ModifyReturnValue:1 | canBeCombined, canBeCombinedEnchantments |
| top-level / `carpetamsaddition/mixin/rule/superLeash/AbstractVillagerMixin.java` | `value={AbstractVillager.class})` | ModifyReturnValue:1 | allowLeashed |
| top-level / `carpetamsaddition/mixin/rule/superLeash/MobMixin.java` | `value={Mob.class})` | ModifyReturnValue:1 | allowLeashed |
| top-level / `carpetamsaddition/mixin/rule/superZombieDoctor/ZombieVillagerAccessor.java` | `value={ZombieVillager.class})` | Accessor:1 |  |
| top-level / `carpetamsaddition/mixin/rule/superZombieDoctor/ZombieVillagerMixin.java` | `value={ZombieVillager.class})` | Inject:1 | modifyConversionTime |
| top-level / `carpetamsaddition/mixin/rule/tntPowerController/PrimedTntMixin.java` | `value={PrimedTnt.class})` | ModifyExpressionValue:1 | modifyTntPower |
| top-level / `carpetamsaddition/mixin/rule/undyingCoral/BaseCoralPlantTypeBlockMixin.java` | `value={BaseCoralPlantTypeBlock.class})` | Inject:1 | checkLivingConditionsMixin |
| top-level / `carpetamsaddition/mixin/rule/undyingCoral/CoralBlockMixin.java` | `value={CoralBlock.class})` | ModifyReturnValue:1 | isInWater |
| top-level / `carpetamsaddition/mixin/rule/useItemCooldownDisabled/ItemCooldownsMixin.java` | `value={ItemCooldowns.class})` | ModifyReturnValue:1 | isCoolingDown |
| top-level / `carpetamsaddition/mixin/rule/witchRedstoneDustDropController_witchGlowstoneDustDropController/LivingEntityMixin.java` | `value={LivingEntity.class})` | Inject:2 | customRedstoneDustDrop, customGlowstoneDustDrop, compatWitchDropStack |
| top-level / `carpetamsaddition/mixin/setting/Carpet_SettingsManagerMixin.java` | `value={SettingsManager.class})` | Inject:5, WrapOperation:2 | persistRuleAsDefault, prepareLazyDefault, notifyLazyDefaultSaved, skipLazyDefaultApplication, skipLazyDefaultReset, notifyLazyDefaultRemoved, resetAmsNetworkRulesOnLoadConfig, rejectUnavailableNetworkRule |
| top-level / `carpetamsaddition/mixin/setting/ParsedRuleAccessor.java` | `value={DummyInterface.class})` |  |  |
| top-level / `carpetamsaddition/mixin/setting/SettingsManagerAccessor.java` | `value={DummyInterface.class})` |  |  |
| top-level / `carpetamsaddition/mixin/translations/HUDControllerMixin.java` | `value={HUDController.class})` | ModifyVariable:1 | applyAMSTranslationToHudLoggerMessage |
| top-level / `carpetamsaddition/mixin/translations/ServerboundClientInformationPacketAccessor.java` | `value={DummyClass.class})` |  |  |
| top-level / `carpetamsaddition/mixin/translations/ServerPlayerMixin.java` | `value={ServerPlayer.class})` | Inject:1, ModifyVariable:1 | getClientLanguage, getClientLanguage$AMS, applyAMSTranslationToSystemMessage |
| top-level / `carpetamsaddition/mixin/translations/TranslatableTextMixin.java` | `value={TranslatableContents.class})` | ModifyArg:1 | applyAMSTranslation |
| top-level / `carpetamsaddition/network/AMS_CustomPayload.java` | `` |  | getPacketId, write, sendC2SPacket, sendS2CPacket |
| top-level / `carpetamsaddition/network/AMS_PayloadCodec.java` | `` |  | decodePayload |
| top-level / `carpetamsaddition/network/AMS_PayloadManager.java` | `` |  | registerPayloads, registerC2SHandlers, registerS2CHandlers, registerPayload, getId, createC2SHandlerChain, createS2CHandlerChain, getC2SHandlerChain, getS2CHandlerChain |
| top-level / `carpetamsaddition/network/AMS_PayloadSender.java` | `` |  | s2c, c2s |
| top-level / `carpetamsaddition/network/PayloadHandlerChain.java` | `` |  | put, getOrCreate, castList, handle, createBridgeConsumer |
| top-level / `carpetamsaddition/network/payloads/AMS_UnknownPayload.java` | `` |  | writeData, handle, create |
| top-level / `carpetamsaddition/network/payloads/core/LazySettingsPayload_S2C.java` | `` |  | writeData, handle, create |
| top-level / `carpetamsaddition/network/payloads/debug/RequestClientModVersionPayload_C2S.java` | `` |  | writeData, handle, create |
| top-level / `carpetamsaddition/network/payloads/debug/RequestClientModVersionPayload_S2C.java` | `` |  | writeData, handle, create |
| top-level / `carpetamsaddition/network/payloads/handshake/HandShakeC2SPayload.java` | `` |  | writeData, handle, create |
| top-level / `carpetamsaddition/network/payloads/handshake/HandShakeS2CPayload.java` | `` |  | writeData, handle, create |
| top-level / `carpetamsaddition/network/payloads/handshake/RequestHandShakeS2CPayload.java` | `` |  | writeData, handle, create |
| top-level / `carpetamsaddition/network/payloads/rule/blockHardnessSyncProtocol/BlockHardnessSyncPayload_C2S.java` | `` |  | writeData, handle, create |
| top-level / `carpetamsaddition/network/payloads/rule/blockHardnessSyncProtocol/BlockHardnessSyncPayload_S2C.java` | `` |  | writeData, handle, create |
| top-level / `carpetamsaddition/network/payloads/rule/commandCustomBlockHardness/CustomBlockHardnessPayload_S2C.java` | `` |  | writeData, handle, create |
| top-level / `carpetamsaddition/network/payloads/rule/commandGetClientPlayerFPS/ClientPlayerFpsPayload_C2S.java` | `` |  | writeData, handle, create |
| top-level / `carpetamsaddition/network/payloads/rule/commandGetClientPlayerFPS/ClientPlayerFpsPayload_S2C.java` | `` |  | writeData, handle, create |
| top-level / `carpetamsaddition/network/payloads/rule/commandSetPlayerPose/UpdatePlayerPosePayload_S2C.java` | `` |  | writeData, handle, create |
| top-level / `carpetamsaddition/observers/network/AmspRuleObserver.java` | `` |  | onValueChange |
| top-level / `carpetamsaddition/observers/recipe/RecipeRuleObserver.java` | `` |  | onValueChange |
| top-level / `carpetamsaddition/observers/rule/fancyFakePlayerName/FancyFakePlayerNameRuleObserver.java` | `` |  | onValueChange |
| top-level / `carpetamsaddition/observers/rule/stackableDiscount/StackableDiscountRuleObserver.java` | `` |  | onValueChange |
| top-level / `carpetamsaddition/settings/AmsRuleCategory.java` | `` |  |  |
| top-level / `carpetamsaddition/settings/AmsRuleMetadata.java` | `` |  | mustSetDefault, activateLazyRules, deactivateLazyRules, shouldDeferLazyRule, validateLazyRuleValue, activeLazyRuleValues, installClientLazyRuleValues, clearClientLazyRuleValues, hasActiveRecipeRule, getFieldValue, setFieldValue, validateValueText, formatValue, validateValue, parseValue, createValidators |
| top-level / `carpetamsaddition/settings/CarpetRuleRegistrar.java` | `` |  | register, parseSettingsClass, parseRule, addRule, registerToCarpet |
| top-level / `carpetamsaddition/settings/LazyRule.java` | `` |  |  |
| top-level / `carpetamsaddition/settings/PersistAsDefault.java` | `` |  |  |
| top-level / `carpetamsaddition/settings/RecipeRule.java` | `` |  |  |
| top-level / `carpetamsaddition/settings/Rule.java` | `` |  |  |
| top-level / `carpetamsaddition/settings/RuleObserver.java` | `` |  | validate |
| top-level / `carpetamsaddition/translations/AMSTranslations.java` | `` |  | loadTranslations, getAvailableLanguages, loadTranslationForLanguage, buildTranslationMap, getServerLanguage, getTranslation, translateKeyToFormattedString, translate, translateTextComponent |
| top-level / `carpetamsaddition/translations/ServerPlayerEntityWithClientLanguage.java` | `` |  |  |
| top-level / `carpetamsaddition/translations/TranslationConstants.java` | `` |  |  |
| top-level / `carpetamsaddition/translations/Translator.java` | `` |  | tr |
| top-level / `carpetamsaddition/utils/AutoMixinAuditExecutor.java` | `` |  | run |
| top-level / `carpetamsaddition/utils/CarpetUtil.java` | `` |  | getRuleName, getRuleDefaultValue, getRuleCurrentValue, hasCategory |
| top-level / `carpetamsaddition/utils/ChainableHashMap.java` | `` |  | cPut |
| top-level / `carpetamsaddition/utils/ChainableList.java` | `` |  | cAdd |
| top-level / `carpetamsaddition/utils/compat/ChunkTicketTypeWrapper.java` | `` |  | register, getNativeType, toChunkPos, addTicket, addTicket |
| top-level / `carpetamsaddition/utils/compat/CustomPacketPayload.java` | `` |  |  |
| top-level / `carpetamsaddition/utils/compat/DimensionWrapper.java` | `` |  | of, of, of, getIdentifier, equals, hashCode, getIdentifierString, toString |
| top-level / `carpetamsaddition/utils/compat/DummyClass.java` | `` |  |  |
| top-level / `carpetamsaddition/utils/compat/DummyInterface.java` | `` |  |  |
| top-level / `carpetamsaddition/utils/compat/TicketTypeWrapper.java` | `` |  | register, register, create, create, convertFlags, getNativeType, addTicket |
| top-level / `carpetamsaddition/utils/CountRulesUtil.java` | `` |  | countRules |
| top-level / `carpetamsaddition/utils/EntityUtil.java` | `` |  | getEntityWorld, getEntityServer |
| top-level / `carpetamsaddition/utils/FileUtil.java` | `` |  | readFile |
| top-level / `carpetamsaddition/utils/IdentifierUtil.java` | `` |  | of, ofId |
| top-level / `carpetamsaddition/utils/Layout.java` | `` |  | getFormatting, toString |
| top-level / `carpetamsaddition/utils/MathUtil.java` | `` |  | square |
| top-level / `carpetamsaddition/utils/messageTextEvent/ClickEventUtil.java` | `` |  | event |
| top-level / `carpetamsaddition/utils/messageTextEvent/HoverEventUtil.java` | `` |  | event |
| top-level / `carpetamsaddition/utils/messenger/Messenger.java` | `` |  | c, s, f, tr, copy, style, __tell, tell, tell, tell, tell, tell, endl, sline, dline, sendServerMessage, sendServerMessage, simpleCmdButtonStyle, simpleCopyButtonStyle, emptyStyle |
| top-level / `carpetamsaddition/utils/messenger/MessengerCompatFactory.java` | `` |  | carpetCompoundText, literalText, translatableText, sendFeedback, sendPlayerMessage, sendPlayerMessage, sendServerMessage, copy |
| top-level / `carpetamsaddition/utils/MinecraftClientUtil.java` | `` |  | getCurrentPlayer, getCurrentClient, clientIsRunning, getClientFps |
| top-level / `carpetamsaddition/utils/MinecraftServerUtil.java` | `` |  | getServer, serverIsRunning, serverIsRunning, getOnlinePlayers, getPlayerList |
| top-level / `carpetamsaddition/utils/MixinUtil.java` | `` |  | audit |
| top-level / `carpetamsaddition/utils/NetworkUtil.java` | `` |  | broadcastDataPack, sendS2CPacket, sendC2SPacket, isClientPacketSupported, isServerPacketSupported, setClientSupportedPackets, getClientSupportedPackets, setServerSupportedPackets, getServerSupportedPackets, getLocalSupportedPackets, removeClientSupportedPackets, clearAllClientSupportedPackets, isSupportClient, setServerSupport, getServerSupportState, supportClientSetIterator, addSupportClient, removeSupportClient, clearClientSupport, executeOnClientThread, executeOnServerThread, readBufString |
| top-level / `carpetamsaddition/utils/Noop.java` | `` |  | noop |
| top-level / `carpetamsaddition/utils/PacketByteBufExtras.java` | `` |  | writeMap, readMap |
| top-level / `carpetamsaddition/utils/PlayerUtil.java` | `` |  | getName, getName, getServerPlayerEntity, getServerPlayerEntity, getPlayerUUID, isInWhitelist, isInWhitelist |
| top-level / `carpetamsaddition/utils/RegexTools.java` | `` |  | getBlockRegisterName, getBlockRegisterName, getItemRegisterName, getItemRegisterName |
| top-level / `carpetamsaddition/utils/WorldUtil.java` | `` |  | isClient |
| top-level / `carpetamsaddition/validators/rule/blockChunkLoaderTimeController/MaxTimeValidator.java` | `` |  | validate, description |
| top-level / `carpetamsaddition/validators/rule/commandPlayerChunkLoadController/MaxRangeValidator.java` | `` |  | validate, description |
| top-level / `carpetamsaddition/validators/rule/easyGetPitcherPod/CountValidator.java` | `` |  | validate, description |
| top-level / `carpetamsaddition/validators/rule/enhancedWorldEater/BlastResistanceValidator.java` | `` |  | validate, description |
| top-level / `carpetamsaddition/validators/rule/experimentalMinecartSpeed/MaxSpeedRangeValidator.java` | `` |  | validate, description |
| top-level / `carpetamsaddition/validators/rule/maxClientInteractionReachDistance/MaxClientInteractionReachDistanceValidator.java` | `` |  | validate, description |
| top-level / `carpetamsaddition/validators/rule/maxPlayerBlockInteractionRange/MaxPlayerBlockInteractionRangeValidator.java` | `` |  | validate, description |
| top-level / `carpetamsaddition/validators/rule/maxPlayerEntityInteractionRange/MaxPlayerEntityInteractionRangeValidator.java` | `` |  | validate, description |
| top-level / `carpetamsaddition/validators/rule/renewableNetherScrap/DropRateValidator.java` | `` |  | validate, description |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
