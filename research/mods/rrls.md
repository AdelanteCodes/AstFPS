# Remove Reloading Screen

Review status: **Evidence inventory; behavioral review pending**

Project: [Remove Reloading Screen](https://modrinth.com/mod/rrls)
Selected artifact version: `5.2.8+mc26.3`
Published implementation source: https://github.com/dima-dencep/rrls
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Makes resource packs load in the background, allowing you to do other things while waiting!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `642eea5dac162c7273f2426cbe3c38d7239a4630924ce05e91ea43bb1e8bca4d780594c4bd8728bd9239eda6859c167b79e6dee3cdb4ed3f0b118186c4e311a9`
- `sha1`: `2b86b92f9c3ad773f5c7d751cee0512ebaccaf60`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 55
Reconstructed Java files: 51

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "org.redlance.dima_dencep.mods.rrls.fabric.RrlsFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3"
}
```

**breaks**

```json
{
  "forgeconfigapiport": "<26.3.0"
}
```

**conflicts**

```json
{
  "dynamicfps": "*",
  "dark-loading-screen": ">=1.6.18"
}
```

**accessWidener**

```json
"rrls.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `org/redlance/dima_dencep/mods/rrls/config/AprilFool.java` | `` |  | canUes |
| top-level / `org/redlance/dima_dencep/mods/rrls/config/DoubleLoad.java` | `` |  | isLoad, getTranslatedName |
| top-level / `org/redlance/dima_dencep/mods/rrls/config/HideType.java` | `` |  | canHide, getTranslatedName |
| top-level / `org/redlance/dima_dencep/mods/rrls/config/impl/FallbackConfigImpl.java` | `` |  | hideType, blockOverlay, miniRender, enableScissor, type, rgbProgress, reloadText, interpolateProgress, interpolateAtEnd, easing, easingArg, animationSpeed, resetResources, reInitScreen, earlyPackStatusSend, doubleLoad, skipForgeOverlay, isServiceActive, getPriority |
| top-level / `org/redlance/dima_dencep/mods/rrls/config/impl/ForgeLikeConfigImpl.java` | `` |  | hideType, blockOverlay, miniRender, enableScissor, type, rgbProgress, reloadText, interpolateProgress, interpolateAtEnd, easing, easingArg, animationSpeed, resetResources, reInitScreen, earlyPackStatusSend, doubleLoad, skipForgeOverlay, isFloatLike, getPriority |
| top-level / `org/redlance/dima_dencep/mods/rrls/config/Type.java` | `` |  | getTranslatedName |
| top-level / `org/redlance/dima_dencep/mods/rrls/duck/OverlayExtender.java` | `` |  |  |
| top-level / `org/redlance/dima_dencep/mods/rrls/fabric/config/FabricConfigImpl.java` | `` |  | isServiceActive, registerConfigScreen |
| top-level / `org/redlance/dima_dencep/mods/rrls/fabric/RrlsFabric.java` | `` |  | onInitializeClient |
| top-level / `org/redlance/dima_dencep/mods/rrls/fabric/services/RrlsReloaderFabric.java` | `` |  | collectEarlyReloaders, isServiceActive, parseModMetadata |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/accessors/ResourceLoaderImplAccessor.java` | `targets={"net.fabricmc.fabric.impl.resource.ResourceLoaderImpl"})` | Accessor:1 |  |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/animation/LoadingOverlayMixin.java` | `value={LoadingOverlay.class}, priority=999)` | ModifyConstant:1 | rrls$changeAnimationSpeed |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/animation/TitleScreenMixin.java` | `value={TitleScreen.class}, priority=999)` | Inject:1, ModifyConstant:1 | rrls$removeFade, rrls$changeAnimationSpeed |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/compat/CubeMapMixin.java` | `value={CubeMap.class})` | WrapOperation:1 | rrls$earlyRegister |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/compat/ItemModelResolverMixin.java` | `value={ItemModelResolver.class})` | WrapOperation:1 | rrls$fixItemsInMenu |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/compat/OverlayMixin.java` | `value={Overlay.class})` | ModifyReturnValue:1 | rrls$getState, rrls$setState, rrls$pausesGame |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/compat/RendererKeyboardMouseMixin.java` | `value={KeyboardHandler.class, MouseHandler.class, FramerateLimitTracker.class})` | WrapOperation:1 | rrls$checkRenderingState |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/compat/ServerPackManagerMixin.java` | `value={ServerPackManager.class})` | Inject:1 | earlyResourcePackStatusSend |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/GuiMixin.java` | `value={Gui.class})` | Inject:1, ModifyReturnValue:1, WrapOperation:1 | rrls$miniRender, rrls$blockOverlay, rrls$enableScissor, rrls$miniRender |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/LoadingOverlayMixin.java` | `value={LoadingOverlay.class})` | Inject:2, WrapWithCondition:3, WrapOperation:3 | rrls$init, rrls$miniRender, rrls$resetProgress, rrls$screenrender, rrls$reinitScreen, rrls$reinitScreen, rrls$_clearColor, rrls$lerp, rrls$rainbowProgress, rrls$interpolateAtEnd, isPausing |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/MinecraftClientMixin.java` | `value={Minecraft.class})` | WrapOperation:4, Inject:4, WrapWithCondition:2, ModifyArg:1 | rrls$screen, rrls$init, rrls$fixDH, rrls$onResourceReloadFailure, rrls$doubleLoad, rrls$doubleLoad, rrls$miniRenderTick, rrls$miniRenderWorldLoad, rrls$removeTick, rrls$fixPanorama, rrls$fixPanorama |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/TranslatableEnumMixin.java` | `value={DoubleLoad.class, HideType.class, Type.class})` |  |  |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/workaround/CommandEncoderMixin.java` | `value={FrontendCommandEncoder.class})` | WrapOperation:1 | rrls$exitRenderPass |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/workaround/CompilationCacheMixin.java` | `value={ShaderManager.PostChainCache.class})` | WrapOperation:1 | rrls$suppressMissingCache |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/workaround/EntityRenderDispatcherMixin.java` | `value={EntityRenderDispatcher.class})` | WrapOperation:2 | rrls$workaroundEntityCrash, rrls$workaroundEntityCrash |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/workaround/GuiGraphicsExtractorMixin.java` | `value={GuiGraphicsExtractor.class})` | WrapOperation:1 | rrls$fixSpriteCrash |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/workaround/opengl/GlCommandEncoderMixin.java` | `targets={"com.mojang.renderpearl.backend.opengl.GlCommandEncoder"})` |  |  |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/workaround/ReloadableResourceManagerMixin.java` | `value={ReloadableResourceManager.class})` | Inject:2 | rrls$initReloader, rrls$initReloaders, rrls$reloadListener, rrls$refreshScreen |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/workaround/TextureManagerMixin.java` | `value={TextureManager.class})` | WrapOperation:1 | rrls$earlyRegister |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/workaround/textures/AbstractTextureMixin.java` | `value={AbstractTexture.class})` | Inject:2 | rrls$useMissingTexture, rrls$useMissingTextureView |
| top-level / `org/redlance/dima_dencep/mods/rrls/mixins/workaround/vulkan/VulkanRenderPassMixin.java` | `targets={"com.mojang.renderpearl.backend.vulkan.VulkanRenderPass"})` |  |  |
| top-level / `org/redlance/dima_dencep/mods/rrls/neoforge/config/NeoForgeConfigImpl.java` | `` |  | isServiceActive |
| top-level / `org/redlance/dima_dencep/mods/rrls/neoforge/mixins/ScreenMixin.java` | `value={Screen.class})` | WrapOperation:1 | rrls$fixTWForest |
| top-level / `org/redlance/dima_dencep/mods/rrls/neoforge/RrlsForge.java` | `` |  |  |
| top-level / `org/redlance/dima_dencep/mods/rrls/neoforge/services/RrlsReloaderNeo.java` | `` |  | collectEarlyReloaders, isServiceActive, parseModMetadata |
| top-level / `org/redlance/dima_dencep/mods/rrls/Rrls.java` | `` |  | onInitializeClient |
| top-level / `org/redlance/dima_dencep/mods/rrls/RrlsConfig.java` | `` |  |  |
| top-level / `org/redlance/dima_dencep/mods/rrls/RrlsMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `org/redlance/dima_dencep/mods/rrls/screens/ConfigurationSectionScreenProxy.java` | `` |  | createSection |
| top-level / `org/redlance/dima_dencep/mods/rrls/screens/ConfigurationSectionScreenWithOverlay.java` | `` |  | resetProgress, onChanged, rebuild, tick, added, removed, done, getActualProgress, isDone |
| top-level / `org/redlance/dima_dencep/mods/rrls/services/AdvancedService.java` | `` |  |  |
| top-level / `org/redlance/dima_dencep/mods/rrls/services/RrlsReloaderService.java` | `` |  | collectEarlyReloaders, isServiceActive |
| top-level / `org/redlance/dima_dencep/mods/rrls/services/ServiceUtils.java` | `` |  | loadServices, tryAdvance, loadServicesSorted, loadService, loadService, loadOptionalService |
| top-level / `org/redlance/dima_dencep/mods/rrls/utils/AtlasUtils.java` | `` |  | reloadAtlasSync, reloadAtlas |
| top-level / `org/redlance/dima_dencep/mods/rrls/utils/DummyGuiGraphics.java` | `` |  | requestCursor, applyCursor, guiWidth, guiHeight, pose, nextStratum, blurBeforeThisStratum, enableScissor, disableScissor, containsPointInScissor, horizontalLine, verticalLine, fill, fill, fillGradient, fill, outline, innerFill, textHighlight, text, text, text, text, text, text, centeredText, centeredText, centeredText, textWithWordWrap, textWithWordWrap, textWithBackdrop, blit, blit, blit, blit, blit, blit, blitSprite, blitSprite, blitSprite, blitSprite, blitSprite, blitSprite, blitSprite, blitSprite, blitNineSlicedSprite, blitNineSliceInnerSegment, blitTiledSprite, innerBlit, innerBlit, innerTiledBlit, item, item, item, item, fakeItem, fakeItem, itemDecorations, itemDecorations, itemBar, itemCount, itemCooldown, map, entity, skin, book, bannerPattern, profilerChart, setTooltipForNextFrame, setTooltipForNextFrame, setTooltipForNextFrame, setTooltipForNextFrame, setTooltipForNextFrame, setTooltipForNextFrame, setTooltipForNextFrame, setTooltipForNextFrame, setTooltipForNextFrame, setComponentTooltipForNextFrame, setComponentTooltipForNextFrame, setTooltipForNextFrame, setTooltipForNextFrame, setTooltipForNextFrame, setTooltipForNextFrameInternal, setTooltipForNextFrameInternal, tooltip, setPreeditOverlay, extractDeferredElements, componentHoverEffect, getSprite, textRendererForWidget, textRenderer, textRenderer, textRenderer, createDefaultTextParameters |
| top-level / `org/redlance/dima_dencep/mods/rrls/utils/Ease.java` | `` |  | invoke, easeIn, easeOut, easeInOut |
| top-level / `org/redlance/dima_dencep/mods/rrls/utils/Easing.java` | `` |  | sine, cubic, quadratic, pow, exp, circle, back, elastic, bounce, step, catmullRom |
| top-level / `org/redlance/dima_dencep/mods/rrls/utils/OverlayHelper.java` | `` |  | lookupState, isCurrentRenderingState, isRenderingState, isRendering |
| top-level / `org/redlance/dima_dencep/mods/rrls/utils/RainbowUtils.java` | `` |  | makeChannel, rainbowColor, rainbowColor |
| top-level / `org/redlance/dima_dencep/mods/rrls/utils/TextureUtils.java` | `` |  | reloadTextureSync, reloadTexture, reloadTextureInternal |
| top-level / `org/redlance/dima_dencep/mods/rrls/utils/WaitingSharedState.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
