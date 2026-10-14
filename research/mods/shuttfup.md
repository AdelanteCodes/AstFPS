# Stfu

Review status: **Evidence inventory; behavioral review pending**

Project: [Stfu](https://modrinth.com/mod/shuttfup)
Selected artifact version: `2.9.1-26.3`
Published implementation source: https://github.com/ItsFelix5/Stfu
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A mod that fixes some annoyances and speeds up your game!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `605b1c2bda5fb70dd86d0fa2d3f326f26f25e76f8e15e34ee992190e32ca74770e789370f5e1ba3ea42ca96e3dca98d40864f65fab186d5e85a072ff4b770bfd`
- `sha1`: `8e59a426979d600ca0622ba840a2ebee6dd55382`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 51
Reconstructed Java files: 47

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "modmenu": [
    "stfu.config.ModMenu"
  ],
  "main": [
    "stfu.Main"
  ]
}
```

**depends**

```json
{
  "fabric-api": "*",
  "yet_another_config_lib_v3": "*"
}
```

**accessWidener**

```json
"26.3.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `stfu/config/Config.java` | `` |  | get, getDisplayName, getDisplayName |
| top-level / `stfu/config/MixinConfig.java` | `` |  | load, get |
| top-level / `stfu/config/ModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `stfu/DebugEntryFpsHistory.java` | `` |  | display, isAllowed |
| top-level / `stfu/DisableIf.java` | `` |  |  |
| top-level / `stfu/Main.java` | `` |  | onInitialize |
| top-level / `stfu/mixin/AllowScreensInPortals.java` | `value={LocalPlayer.class})` | Redirect:1 | tickNausea |
| top-level / `stfu/mixin/chat/CommandLengthLimit.java` | `value={ChatScreen.class})` | Inject:3 | init, onChatFieldUpdate, normalize |
| top-level / `stfu/mixin/chat/Deduplicate.java` | `value={ChatComponent.class})` | ModifyVariable:1 | compact |
| top-level / `stfu/mixin/chat/Filter.java` | `value={ChatComponent.class})` | Inject:1 | filter |
| top-level / `stfu/mixin/chat/ImprovedCommandSuggestions/CommandSuggestionsMixin.java` | `value={CommandSuggestions.class})` | Inject:1 | getLastWordIndex, sortSuggestions |
| top-level / `stfu/mixin/chat/ImprovedCommandSuggestions/SharedSuggestionProviderMixin.java` | `value={SharedSuggestionProvider.class})` | Inject:2 | filterResources, shouldSuggest |
| top-level / `stfu/mixin/chat/MoreHistory.java` | `value={ChatComponent.class})` | ModifyConstant:1 | moreHistory |
| top-level / `stfu/mixin/chat/RemoveUnsignedIcon.java` | `value={GuiMessage.class})` | Inject:1 | indicator |
| top-level / `stfu/mixin/CombineBars.java` | `value={Hud.class})` | Inject:1, WrapOperation:1 | getCurrentBarType, renderBar |
| top-level / `stfu/mixin/DefaultLANPort.java` | `value={HttpUtil.class})` | ModifyConstant:1 | findLocalPort |
| top-level / `stfu/mixin/DefaultSettings.java` | `value={Options.class})` | Inject:1 | changeOptions |
| top-level / `stfu/mixin/DeleteToTrash/LevelStorageAccessMixin.java` | `value={LevelStorageSource.LevelStorageAccess.class})` | WrapOperation:1 | deleteToTrash |
| top-level / `stfu/mixin/DeleteToTrash/WorldListEntryMixin.java` | `value={WorldSelectionList.WorldListEntry.class})` | ModifyConstant:1 | deleteWarning |
| top-level / `stfu/mixin/DisableLoadingTerrain.java` | `value={Gui.class})` | ModifyVariable:1 | setScreen, tick |
| top-level / `stfu/mixin/DisablePackVersionMismatchScreen.java` | `value={TransferableSelectionList.PackEntry.class})` | Redirect:1 | isCompatible |
| top-level / `stfu/mixin/DisableWorldAdvice.java` | `value={WorldOpenFlows.class})` | Inject:1, Redirect:1 | confirmWorldCreation, openWorldCheckWorldStemCompatibility |
| top-level / `stfu/mixin/FixInventoryTabSwitching.java` | `value={CreativeModeInventoryScreen.class})` | WrapOperation:1, Redirect:1 | checkTabClicked, selectTab |
| top-level / `stfu/mixin/keybinds/MultipleBindingsPerKey/NoReusedModifierKeyWarning.java` | `value={KeyBindsList.KeyEntry.class})` | WrapOperation:2 | shutReusedModifierKeys, shutReusedModifierKeys |
| top-level / `stfu/mixin/keybinds/RemapNarrator.java` | `value={KeyboardHandler.class})` | ModifyConstant:1 | shutNarrator |
| top-level / `stfu/mixin/NoNarratorError.java` | `value={Narrator.class})` | Redirect:1 | noNarratorError |
| top-level / `stfu/mixin/NoNightVisionFlicker.java` | `value={GameRenderer.class})` | Inject:1 | getNightVisionScale |
| top-level / `stfu/mixin/NoTelemetry.java` | `value={ClientTelemetryManager.class})` | Inject:1 | NoopSender |
| top-level / `stfu/mixin/PauseMusic.java` | `value={SoundEngine.class})` | Inject:1 | resume |
| top-level / `stfu/mixin/RemoveOverlay/LoadingOverlayMixin.java` | `value={LoadingOverlay.class})` | ModifyConstant:1, Inject:1, WrapOperation:2 | disableFade, isInGracePeriod, render, render |
| top-level / `stfu/mixin/RemoveOverlay/MinecraftMixin.java` | `value={Minecraft.class})` | Redirect:1 | overlay |
| top-level / `stfu/mixin/RemoveOverlay/MouseHandlerMixin.java` | `value={MouseHandler.class})` | Redirect:1 | getOverlay |
| top-level / `stfu/mixin/RemoveWidgetFade.java` | `value={TitleScreen.class})` | ModifyVariable:1 | shutLoadFade |
| top-level / `stfu/mixin/rendering/DisableParticles.java` | `value={ParticleEngine.class})` | Inject:5 | renderParticles, tick, addEmitter, addParticle, addParticle |
| top-level / `stfu/mixin/rendering/DisableTextureAnimation.java` | `value={Minecraft.class})` | WrapOperation:1 | shouldTickTextures |
| top-level / `stfu/mixin/rendering/DisableToasts.java` | `value={ClientPacketListener.class})` | Redirect:2, Inject:1 | onGameJoin, disableRecipeToasts, disableAdvancementToasts |
| top-level / `stfu/mixin/rendering/DisableWeather.java` | `value={WeatherEffectRenderer.class})` | Inject:1 | renderPrecipitation |
| top-level / `stfu/mixin/rendering/DisableWeatherEffects.java` | `value={ClientLevel.class})` | Inject:1 | addParticlesAndSound |
| top-level / `stfu/mixin/rendering/FixTitleSize.java` | `value={Hud.class})` | ModifyArgs:2 | renderTitle, renderSubTitle |
| top-level / `stfu/mixin/ThreadPriorities/MainMixin.java` | `value={Main.class})` | Redirect:1 | preload |
| top-level / `stfu/mixin/ThreadPriorities/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Redirect:1 | availableProcessors |
| top-level / `stfu/mixin/ThreadPriorities/UtilMixin.java` | `value={Util.class})` | WrapOperation:1 | setName |
| top-level / `stfu/mixin/Tooltips.java` | `value={GuiGraphicsExtractor.class})` | ModifyVariable:1, WrapOperation:1 | wrapLines, visit, visit, reposition |
| top-level / `stfu/mixin/UnfocusedVolumeReducer/SoundEngineMixin.java` | `value={SoundEngine.class})` | WrapMethod:1 | calculateVolume |
| top-level / `stfu/mixin/UnfocusedVolumeReducer/WindowActiveListenerMixin.java` | `value={Window.class})` | Inject:1 | onFocus |
| top-level / `stfu/mixin/UnPinResourcePacks.java` | `value={Pack.class})` | Inject:1 | isFixedPosition |
| top-level / `stfu/MixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
