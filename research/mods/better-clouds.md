# Better Clouds

Review status: **Evidence inventory; behavioral review pending**

Project: [Better Clouds](https://modrinth.com/mod/better-clouds)
Selected artifact version: `1.15.0-beta.3`
Published implementation source: https://github.com/Qendolin/better-clouds
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Beautiful clouds in touch with the vanilla style

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `b55533b84780fcd9b2a5d594896204bb4761c81ccbe2db7c2734933147c2041cbd2a145e4131094e9987b186cbf33cf599cc349dcba57a6eaa8e021441647155`
- `sha1`: `370bcd8aab874075b9b0c6a05d181784507e89a3`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 219
Reconstructed Java files: 135

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.qendolin.betterclouds.Entrypoint"
  ],
  "modmenu": [
    "com.qendolin.betterclouds.ModMenuIntegration"
  ],
  "preLaunch": [
    "com.qendolin.betterclouds.platform.fabric.Crash_Is_Not_Caused_By_BetterClouds"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.17.2",
  "minecraft": [
    "~26.3"
  ],
  "java": ">=25",
  "fabric-api": "*",
  "yet_another_config_lib_v3": ">=3.9.0"
}
```

**breaks**

```json
{
  "vulkanmod": "*",
  "iris": "<1.6.0",
  "immersive_portals": "*"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/mixinextras-fabric-0.5.3.jar` | 505 | `mixinextras` | No |
| `META-INF/jars/mixinsquared-fabric-0.3.7-beta.3.jar` | 76 | `mixinsquared` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/qendolin/betterclouds/BetterClouds.java` | `` |  | initializeClientEarly, initializeClient, initializeClientEvents, isEnabled, getConfig, getConfigHandler |
| top-level / `com/qendolin/betterclouds/BetterCloudsStatic.java` | `` |  | isInitialized, getVersion, getLogger, getDataDirectory |
| top-level / `com/qendolin/betterclouds/Commands.java` | `` |  | literal, argument, castDispatcher, registerImpl, registerOpenGLCommands, renderdocCommands, sendGpuIncompatibleChatMessage, sendGpuPartiallyIncompatibleChatMessage, sendHardwareMaybeIncompatibleChatMessage, sendCloudsDisabledMessage, sendCrashChatMessage, createCommandClickEvent, createOpenFileClickEvent, fallback, getFallback, set, get |
| top-level / `com/qendolin/betterclouds/compat/BigGlobeCompat.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/compat/DhCompat.java` | `` |  | initialize, instance, isReady, isEnabled, getProjectionMatrix, getDepthTextureId, getDepthTexture, disableLodClouds, isTextureCreateFlagSet, resetTextureCreateFlag, isNativeRenderer |
| top-level / `com/qendolin/betterclouds/compat/DhCompatImpl.java` | `` |  | afterDistantHorizonsInit, beforeRender, onResize, isReady, isEnabled, getProjectionMatrix, getDepthTextureId, getDepthTexture, disableLodClouds, isNativeRenderer, isTextureCreateFlagSet, resetTextureCreateFlag |
| top-level / `com/qendolin/betterclouds/compat/GLCompat.java` | `` |  | getCpuInfo, getRenderer, getVersion, init, isIncompatible, isPartiallyIncompatible, objectLabelDev, objectLabel, pushDebugGroupDev, pushDebugGroup, popDebugGroupDev, popDebugGroup, debugMessage, initDev, enableDebugOutputSynchronous, textureView, drawArraysInstancedBaseInstanceFallback, drawArraysInstancedBaseInstance, texStorage2DFallback, texStorage2D, bufferStorage, vertexAttribDivisor, blendFunci, getString, useBaseInstanceFallback, setUseBaseInstanceFallback, useStencilTextureFallback, setUseStencilTextureFallback, useDepthWriteFallback, setUseDepthWriteFallback, useTexStorageFallback, setUseTexStorageFallback, usedFallbacks, shaderSource |
| top-level / `com/qendolin/betterclouds/compat/HardwareCompat.java` | `` |  | isMaybeIncompatible |
| top-level / `com/qendolin/betterclouds/compat/IrisCompat.java` | `` |  | initialize, isActive, instance, isShadersEnabled, isFrustumCullingDisabled, getPipeline, bindFramebuffer |
| top-level / `com/qendolin/betterclouds/compat/IrisCompatImpl.java` | `` |  | isShadersEnabled, isFrustumCullingDisabled, getPipeline, bindFramebuffer |
| top-level / `com/qendolin/betterclouds/compat/MiddleEarthCompat.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/compat/ModLoaded.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/compat/ProfilerWrapper.java` | `` |  | getProfiler |
| top-level / `com/qendolin/betterclouds/compat/ReflectAccess.java` | `` |  | invoke, of, of |
| top-level / `com/qendolin/betterclouds/compat/SereneSeasonsCompat.java` | `` |  | initialize, isActive, instance, getCloudinessFactor |
| top-level / `com/qendolin/betterclouds/compat/SereneSeasonsCompatImpl.java` | `` |  | seasonName, getRelativeSeason, getSeasonCloudiness, getSubSeasonTicks, getCloudinessFactor, Api, load |
| top-level / `com/qendolin/betterclouds/compat/SodiumExtraCompat.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/compat/VoxyCompat.java` | `` |  | initialize, getProjectionMatrix, getOpaqueDepthTexture, isEnabled |
| top-level / `com/qendolin/betterclouds/compat/VoxyCompatImpl.java` | `` |  | getProjectionMatrix, getOpaqueDepthTexture, isEnabled |
| top-level / `com/qendolin/betterclouds/config/compat/SereneSeasonsConfig.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/config/compat/ShaderPresetConfig.java` | `` |  | gamma |
| top-level / `com/qendolin/betterclouds/config/Config.java` | `` |  | getDefaultDimensions, loadDefaultPresets, loadDefaultPreset, shaderPreset, sortShaderPresets, sortShaderPresets, noisePreset, sortNoisePresets, sortNoisePresets, getCloudTicks, blockDistance, equals, hashCode, getDisplayName, getDisplayName, deserialize, serialize |
| top-level / `com/qendolin/betterclouds/config/ConfigManager.java` | `` |  | handler, instance, isInitialized, initialize, loadWithFailureBackup |
| top-level / `com/qendolin/betterclouds/config/Configs.java` | `` |  | copy, equal, hashCode, copyValue, valuesEqual, listEquals, valueHashCode, serialFields, createSerialFields, createSerialField, instantiate, SerialField, get, set |
| top-level / `com/qendolin/betterclouds/config/gui/ConfigGUI.java` | `` |  | create, assemble |
| top-level / `com/qendolin/betterclouds/config/gui/DimensionsGUI.java` | `` |  | setValues |
| top-level / `com/qendolin/betterclouds/config/gui/NoisePresetGUI.java` | `` |  | formatLastException, setPresetDescription, setPresetDescription, syncPresetOptions, updateNonResponsiveOptions, setOptionEditable, onSave |
| top-level / `com/qendolin/betterclouds/config/gui/SereneSeasonsGUI.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/config/gui/ShaderPresetGUI.java` | `` |  | setPresetDescription, setPresetDescription, updateNonResponsiveOptions, setOptionEditable, onSave |
| top-level / `com/qendolin/betterclouds/config/Migrations.java` | `` |  | migrate |
| top-level / `com/qendolin/betterclouds/config/preset/AbstractPresetConfig.java` | `` |  | markAsCopy |
| top-level / `com/qendolin/betterclouds/config/preset/NoisePresetConfig.java` | `` |  | octavesToStringList, octavesFromStringList |
| top-level / `com/qendolin/betterclouds/config/preset/PresetListSerializer.java` | `` |  | serialize |
| top-level / `com/qendolin/betterclouds/config/preset/PresetLoader.java` | `` |  | presets, load, apply |
| top-level / `com/qendolin/betterclouds/Entrypoint.java` | `` |  | onInitializeClient |
| top-level / `com/qendolin/betterclouds/generator/ChunkedGenerator.java` | `` |  | floorCloudChunk, cacheHash, canGenerate, canSwap, canRender, chunks, points, originX, originZ, renderOriginX, renderOriginZ, config, generating, close, clear, update, generate, refresh, swap, get, put, swap, clear, defaultReturnValue, capacity, get, put, swap, clear, defaultReturnValue, capacity, cancel, id, completed, chunkX, chunkZ, options, cloudiness, chunks, ran, cancelled, elapsedMs, run, bounds, start, count, SamplePoints, Point |
| top-level / `com/qendolin/betterclouds/generator/RandomPath.java` | `` |  | getPathSmooth, getPointCoordinate, catmullRomInterpolate, getPathX, getPathZ, initialize |
| top-level / `com/qendolin/betterclouds/generator/Sampler.java` | `` |  | createDetailNoise, hash, hashToFloat, getSeed, randomOffsetX, randomOffsetZ, sample |
| top-level / `com/qendolin/betterclouds/gui/ConfigScreen.java` | `` |  | init, pendingChanges, extractBackground, extractTransparentBackground, extractMenuBackground, finishOrSave, onClose, shouldCloseOnEsc, extractBackground, extractTransparentBackground, extractMenuBackground, getFocused |
| top-level / `com/qendolin/betterclouds/gui/CustomActionController.java` | `` |  | provideWidget, extractRenderState, extractValueText |
| top-level / `com/qendolin/betterclouds/gui/CustomButtonOption.java` | `` |  | createBuilder, stateManager, addEventListener, name, tooltip, description, action, available, setAvailable, controller, binding, flags, changed, pendingValue, requestSet, applyValue, forgetPendingValue, requestSetDefault, isPendingValueDefault, addListener, getValue, setValue, defaultValue, name, description, action, available, build |
| top-level / `com/qendolin/betterclouds/gui/CustomIntegerFieldController.java` | `` |  | isInputValid |
| top-level / `com/qendolin/betterclouds/gui/CustomScrollableNavigationBar.java` | `` |  | betterclouds$useTranslucentTheme |
| top-level / `com/qendolin/betterclouds/gui/OptionGroupBuilderWrapper.java` | `` |  | name, description, option, options, collapsed, build |
| top-level / `com/qendolin/betterclouds/gui/SelectDropdownController.java` | `` |  | option, formatValue, updateValues, formatValueAtIndex, getValueCount, cycle, provideWidget, getValueText, getUnhoveredControlWidth, getHoveredControlWidth, mouseClicked, keyPressed, unfocus, togglePopup, openPopup, closePopup, removePopupWidget, calculateDimensions, centerOnSelection, extractRenderState, isMouseOverItem, mouseClicked, mouseScrolled, isMouseOver, close, popupTitle |
| top-level / `com/qendolin/betterclouds/gui/YACL36OptionBuilderImpl.java` | `` |  | name, customController, available, build, description, listeners, description, binding, listener, controller, binding, flag, instant |
| top-level / `com/qendolin/betterclouds/gui/YACLOptionBuilder.java` | `` |  | create |
| top-level / `com/qendolin/betterclouds/mixin/duck/BiomeManagerDuck.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/mixin/duck/CustomCategoryTabDuck.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/mixin/duck/CustomOptionListWidgetDuck.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/mixin/duck/ListOptionDuck.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/mixin/duck/OptionDuck.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/mixin/duck/OptionListEntryExtensionDuck.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/mixin/duck/StringControllerDuck.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/mixin/duck/TabNavigationWidgetExtensionDuck.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/mixin/duck/WorldDuck.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/mixin/MixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `com/qendolin/betterclouds/mixin/optional/ExtendedShaderAccessor.java` | `value={ExtendedShader.class}, remap=false)` | Accessor:2 |  |
| top-level / `com/qendolin/betterclouds/mixin/optional/FallbackShaderAccessor.java` | `value={FallbackShader.class}, remap=false)` | Accessor:2 |  |
| top-level / `com/qendolin/betterclouds/mixin/optional/GlCommandEncoderMixin.java` | `targets={"com.mojang.renderpearl.backend.opengl.GlCommandEncoder"}, priority=1500)` | Inject:1 | injectFramebuffer |
| top-level / `com/qendolin/betterclouds/mixin/OptionalMixinPlugin.java` | `` |  | shouldApplyMixin |
| top-level / `com/qendolin/betterclouds/mixin/provider/CloudinessProvider.java` | `` |  | getCloudiness, getTrueRainGradient, getTrueThunderGradient |
| top-level / `com/qendolin/betterclouds/mixin/provider/EffectTintProvider.java` | `` |  | getEffectTint, compositeColor, getCloudsColor, gammaToLinear, linearToGamma, getSunAngleDegrees, getSunAngleRadians |
| top-level / `com/qendolin/betterclouds/mixin/provider/FogProvider.java` | `` |  | Fog |
| top-level / `com/qendolin/betterclouds/mixin/provider/FogProvider1216.java` | `` |  | getFogInternal |
| top-level / `com/qendolin/betterclouds/mixin/required/BiomeManagerMixin.java` | `value={BiomeManager.class})` |  | betterclouds$biomeSeed |
| top-level / `com/qendolin/betterclouds/mixin/required/CloudSettingMixin.java` | `value={Options.class}, priority=1010)` | WrapMethod:1 | overrideCloudRenderMode |
| top-level / `com/qendolin/betterclouds/mixin/required/GameRendererAccessor.java` | `value={GameRenderer.class})` | Accessor:1 |  |
| top-level / `com/qendolin/betterclouds/mixin/required/GameRendererMixin.java` | `value={GameRenderer.class}, priority=1100)` | WrapOperation:1 | iris$renderLevel |
| top-level / `com/qendolin/betterclouds/mixin/required/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:3 | afterSwapBuffers, afterTick, reloadBetterCloudsRenderer |
| top-level / `com/qendolin/betterclouds/mixin/required/RenderSystemMixin.java` | `value={RenderSystem.class})` | Inject:1 | afterInitRenderer |
| top-level / `com/qendolin/betterclouds/mixin/required/TabNavigationWidgetMixin.java` | `value={TabNavigationBar.class})` |  | betterclouds$setRenderBackground |
| top-level / `com/qendolin/betterclouds/mixin/required/WorldMixin.java` | `value={Level.class}, priority=900)` |  | betterclouds$getOriginalRainGradient, betterclouds$getOriginalThunderGradient |
| top-level / `com/qendolin/betterclouds/mixin/required/WorldRendererMixin.java` | `value={LevelRenderer.class}, priority=900)` | Inject:3, WrapWithCondition:2 | captureFrustumAndCheckState, addCloudPass, renderVanillaClouds, renderVanillaOitClouds, close |
| top-level / `com/qendolin/betterclouds/mixin/required/yacl/AbstractWidgetMixin.java` | `value={AbstractWidget.class})` | Inject:1 | betterclouds$drawOutline, onDrawButtonRect, betterclouds$useTranslucentTheme |
| top-level / `com/qendolin/betterclouds/mixin/required/yacl/CategoryTabMixin.java` | `value={YACLScreen.CategoryTab.class}, remap=false)` | WrapMethod:1, Inject:2 | betterclouds$applyOverride, betterclouds$hideOrShow, updateButtons, onTick, onForEachChild |
| top-level / `com/qendolin/betterclouds/mixin/required/yacl/ListOptionMixin.java` | `value={ListOptionImpl.class})` |  | betterclouds$setCollapsed, betterclouds$setForceExpanded, betterclouds$forceExpanded |
| top-level / `com/qendolin/betterclouds/mixin/required/yacl/OptionListWidgetMixin.java` | `value={OptionListWidget.class})` | Inject:1 | betterclouds$applyOverride, onRefreshOptions, extractContent |
| top-level / `com/qendolin/betterclouds/mixin/required/yacl/OptionMixin.java` | `value={OptionImpl.class})` |  | betterclouds$setDescription, betterclouds$appendToDescription |
| top-level / `com/qendolin/betterclouds/mixin/required/yacl/PopupControllerScreenAccessor.java` | `value={PopupControllerScreen.class}, remap=false)` | Accessor:1 |  |
| top-level / `com/qendolin/betterclouds/mixin/required/yacl/ScrollableNavigationBarMixin.java` | `value={ScrollableNavigationBar.class}, remap=false)` | Inject:1 | betterclouds$drawTranslucentBackground |
| top-level / `com/qendolin/betterclouds/mixin/required/yacl/StringControllerMixin.java` | `value={StringController.class}, remap=false)` |  | betterclouds$setDescription |
| top-level / `com/qendolin/betterclouds/mixin/RequiredMixinPlugin.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/mixin/runtime/FogRendererMixin.java` | `value={FogRenderer.class})` | ModifyReturnValue:1 | captureFogData |
| top-level / `com/qendolin/betterclouds/mixin/runtime/GlDebugMixin.java` | `value={GlDebug.class})` | Inject:1 | onDebugMessage |
| top-level / `com/qendolin/betterclouds/mixin/runtime/SimpleOptionAccessor.java` | `value={OptionInstance.class})` | Accessor:1 |  |
| top-level / `com/qendolin/betterclouds/mixin/runtime/yacl/OptionListGroupSeparatorEntryMixin.java` | `value={OptionListWidget.GroupSeparatorEntry.class}, remap=false)` | Inject:3, ModifyReturnValue:1 | preserveExpandedState, betterclouds$onBeforeRender, betterclouds$onAfterRender, onBeforeRender, onAfterRender, betterclouds$setYPadding, betterclouds$getYPadding, betterclouds$setExpanded, modifyYPadding |
| top-level / `com/qendolin/betterclouds/mixin/runtime/yacl/OptionListOptionEntryMixin.java` | `value={OptionListWidget.OptionEntry.class}, remap=false)` | Inject:2, ModifyArg:1 | betterclouds$onBeforeRender, betterclouds$onAfterRender, onBeforeRender, onAfterRender, betterclouds$setYPadding, betterclouds$getYPadding, modifyYPadding |
| top-level / `com/qendolin/betterclouds/mixin/RuntimeMixinPlugin.java` | `` |  | getMixins |
| top-level / `com/qendolin/betterclouds/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/qendolin/betterclouds/platform/EventHooks.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/platform/fabric/Crash_Is_Not_Caused_By_BetterClouds.java` | `` |  | isPreLaunchComplete, onPreLaunch |
| top-level / `com/qendolin/betterclouds/platform/fabric/EventHooksImpl.java` | `` |  | onClientStarted, onWorldJoin, onClientResourcesReload, onClientTick, onClientCommandRegistration |
| top-level / `com/qendolin/betterclouds/platform/fabric/ModLoaderImpl.java` | `` |  | getConfigDir, getGameDir, isModLoaded, isDevelopmentEnvironment, isClientEnvironment, getModVersion |
| top-level / `com/qendolin/betterclouds/platform/fabric/ModVersionImpl.java` | `` |  | isPresent, getFriendlyString, asSemVer |
| top-level / `com/qendolin/betterclouds/platform/ModLoader.java` | `` |  | getConfigDir, getGameDir, isModLoaded, isDevelopmentEnvironment, isClientEnvironment, getModVersion, loadBackend, instantiate |
| top-level / `com/qendolin/betterclouds/platform/ModVersion.java` | `` |  | getFriendlyString, asSemVer, isPresent, fromString, asSemVer, isPresent, getFriendlyString, compareTo, toString |
| top-level / `com/qendolin/betterclouds/renderdoc/CaptureManager.java` | `` |  | capture, writeLaunchConfig, readLaunchConfig, deleteLaunchConfig, onSwapBuffers, LaunchConfig, isExpired |
| top-level / `com/qendolin/betterclouds/renderdoc/RenderDoc.java` | `` |  | init, isAvailable, getAPIVersion, setCaptureOption, getCaptureOption, setCaptureKeys, getOverlayOptions, enableOverlayOptions, disableOverlayOptions, removeHooks, unloadCrashHandler, getCaptureFilePathTemplate, setCaptureFilePathTemplate, getCapture, getNumCaptures, triggerCapture, startFrameCapture, isFrameCapturing, endFrameCapture, isReplayUIConnected, launchReplayUI, showReplayUI, setCaptureComments, Capture, fromInputKey |
| top-level / `com/qendolin/betterclouds/renderdoc/RenderDocLibrary.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/renderdoc/RenderDocLoader.java` | `` |  | getOperatingSystemName, getOperatingSystem, install, uninstall, isAvailable, isAvailable, downloadWindows, downloadLinux, load, libPath |
| top-level / `com/qendolin/betterclouds/rendering/blaze3d/Blaze3DRenderer.java` | `` |  | gpu, isCloudsOpaque, setLevel, reload, render, compositeClouds, getGeneratorConfig, buildRenderPipeline, isReverseZ, drawWithFrustumCulling, uploadPointsToBuffer, createCloudModelViewMatrix, onClose, createModelBuffers |
| top-level / `com/qendolin/betterclouds/rendering/blaze3d/IrisCloudTarget.java` | `` |  | checkComplete, close, Attachment, close |
| top-level / `com/qendolin/betterclouds/rendering/blaze3d/IrisFramebuffer.java` | `` |  | begin, begin, bind, end, isActive |
| top-level / `com/qendolin/betterclouds/rendering/blaze3d/PipelineParams.java` | `` |  | PipelineParams, get, newParameters, paramsChanged |
| top-level / `com/qendolin/betterclouds/rendering/blaze3d/ReadOnlyBuffer.java` | `` |  | recreate, size, gpuBuffer, close |
| top-level / `com/qendolin/betterclouds/rendering/blaze3d/WritableBuffer.java` | `` |  | gpuBuffer, write, close |
| top-level / `com/qendolin/betterclouds/rendering/BorrowedGlTexture.java` | `` |  | close |
| top-level / `com/qendolin/betterclouds/rendering/CloudRenderCoordinator.java` | `` |  | initialize, getRenderer, captureMatrices, captureFrustum, checkState, reload, renderClouds, renderCloudsInternal, close, shouldRenderClouds |
| top-level / `com/qendolin/betterclouds/rendering/CloudRenderer.java` | `` |  | dayTime, reload, reloadGenerator, checkAndRender, close, getWorldSeed, useCubeClouds, timer, stopTiming, startTiming, reloadTimer, deleteTimer, setLevel, updateGenerator |
| top-level / `com/qendolin/betterclouds/rendering/GraphicsCompat.java` | `` |  | initCompat, init, isIncompatible, isPartiallyIncompatible, initDev, pushDebugGroupDev, debugMessage, popDebugGroupDev, popDebugGroup |
| top-level / `com/qendolin/betterclouds/rendering/opengl/Debug.java` | `` |  | clearFrustumCulledBoxes, addFrustumCulledBox, render, drawFrustumCulledBoxes, drawBox, addLine, addVertex, isProfilingEnabled, render |
| top-level / `com/qendolin/betterclouds/rendering/opengl/internal/Buffer.java` | `` |  | allocatePersistent, allocateMutable, setVAPointerToInstance, hasChanged, instanceVertexCount, close, clear, put, swap, swapCount, bind, bindDrawBuffer, unbind |
| top-level / `com/qendolin/betterclouds/rendering/opengl/internal/Mesh.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/rendering/opengl/OpenGLRenderer.java` | `` |  | setFrustumTo, calcBufferSize, reload, reloadBuffer, resources, scaledFramebufferWidth, scaledFramebufferHeight, uploadPointsToBuffer, createShaderParameters, render, isFramebufferStale, clearDepth, setDepthFuncGEqual, drawCoverage, drawCloudsWithFrustumCulling, drawCloudsWithoutFrustumCulling, drawShading, getGeneratorConfig, onClose |
| top-level / `com/qendolin/betterclouds/rendering/opengl/RenderHelper.java` | `` |  | getTextureId, getTextureId, bindTexture, bindTexture, bindTexture, saveShader, restoreShader, colorMask, saveColorMask, restoreColorMask, getSamplerId, bindSampler, bindSampler, depthMask, saveDepthMask, restoreDepthMask, getFogDataAndColor, setFogDataAndColor, unwrapValidationTexture, FogDataAndColor |
| top-level / `com/qendolin/betterclouds/rendering/opengl/Resources.java` | `` |  | unbindVao, unbindVbo, depthShader, coverageShader, shadingShader, debugShader, cubeVao, oitFbo, oitCoverageDepthTexture, oitDataTexture, oitCoverageTexture, fboWidth, fboHeight, failedToLoadCritical, reloadMeshPrimitives, deleteMeshPrimitives, reloadTextures, reloadFramebuffer, createFramebufferAttachments, deleteFramebuffer, deleteFramebufferAttachments, reloadShaders, reloadShadersInternal, deleteShaders, close |
| top-level / `com/qendolin/betterclouds/rendering/opengl/shaders/CoverageShader.java` | `` |  | create |
| top-level / `com/qendolin/betterclouds/rendering/opengl/shaders/DebugShader.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/rendering/opengl/shaders/DepthShader.java` | `` |  | create |
| top-level / `com/qendolin/betterclouds/rendering/opengl/shaders/Shader.java` | `` |  | compileShader, close, isIncomplete, bind, glId, getUniform |
| top-level / `com/qendolin/betterclouds/rendering/opengl/shaders/ShaderParameters.java` | `` |  | ShaderParameters |
| top-level / `com/qendolin/betterclouds/rendering/opengl/shaders/ShadingShader.java` | `` |  | create |
| top-level / `com/qendolin/betterclouds/rendering/opengl/shaders/Uniform.java` | `` |  | toString, setMat4, setMat4, setVec4, checkCache, setCache, setVec3, setVec3, setVec2, setFloat, setInt, setMat4, setMat4, setVec4, setVec3, setVec3, setVec2, setFloat, setInt, setMat4, setMat4, setVec4, setVec3, setVec3, setVec2, setFloat, setInt |
| top-level / `com/qendolin/betterclouds/rendering/opengl/VanillaRenderTarget.java` | `` |  | begin, end |
| top-level / `com/qendolin/betterclouds/rendering/PerfTimer.java` | `` |  | start, stop, gpu, cpu, frames, reset, close, Stats, of, formatted |
| top-level / `com/qendolin/betterclouds/rendering/PrepareResult.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/rendering/TextureWrapper.java` | `` |  | fromBorrowedTexture, fromBorrowedTexture, fromMcTexture, fromTexture, from, get, closeAllWrappers, close, defaultSampler, customSampler, bindTo, view, sampler, asBorrowed |
| top-level / `com/qendolin/betterclouds/util/ChatUtil.java` | `` |  | debugChatMessageKey, debugChatMessage, debugChatMessage |
| top-level / `com/qendolin/betterclouds/util/DataDirectoryMigration.java` | `` |  | runMigration |
| top-level / `com/qendolin/betterclouds/util/MathUtil.java` | `` |  | interpolateDayNightFactor, mapTimeOfDay, map, smoothstep, calculateClippingPlanes |
| top-level / `com/qendolin/betterclouds/util/NamedLogger.java` | `` |  | debug, debug, debug, debug, debug, debug, debug, error, error, error, error, error, error, error, getName, info, info, info, info, info, info, info, warn, warn, warn, warn, warn, warn, warn |
| top-level / `com/qendolin/betterclouds/util/PreLaunchGuard.java` | `` |  | check |
| top-level / `com/qendolin/betterclouds/util/Producer.java` | `` |  |  |
| top-level / `com/qendolin/betterclouds/util/Tuple.java` | `` |  | getA, getB |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
