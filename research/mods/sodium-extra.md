# Sodium Extra

Review status: **Evidence inventory; behavioral review pending**

Project: [Sodium Extra](https://modrinth.com/mod/sodium-extra)
Selected artifact version: `mc26.3-0.9.4+fabric`
Published implementation source: https://github.com/FlashyReese/sodium-extra-fabric
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A Sodium addon that adds features that shouldn't be in Sodium.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `a2e8d8416a556b7a351460a06407119eaba62f06636377001720bbda9b797dc881b2bb4528fb75a0459fee34475db529858633b6b86b545a72d0f13cf3c2b7bb`
- `sha1`: `ff2056f222b751fe161123e71e55afd5b2f41da4`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 94
Reconstructed Java files: 74

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "me.flashyreese.mods.sodiumextra.SodiumExtraFabricClientModInitializer"
  ],
  "sodium:config_api_user": [
    "me.flashyreese.mods.sodiumextra.client.config.SodiumExtraConfig"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "sodium": ">=0.9.2+mc26.3",
  "minecraft": "26.3"
}
```

**breaks**

```json
{
  "iris": "<1.7.0",
  "reeses-sodium-options": "<1.8.4"
}
```

**accessWidener**

```json
"sodium-extra.accesswidener"
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/greenlight-api-0.1.0+mc26.3.jar` | 9 | `me_flashyreese_mods_greenlight-api` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/flashyreese/mods/sodiumextra/client/config/ConfigFileIO.java` | `` |  | writeStringAtomically, writeBytesAtomically, moveCorruptFile, writeBytesToTempFile, nextCorruptFilePath, forceDirectory |
| top-level / `me/flashyreese/mods/sodiumextra/client/config/SodiumExtraConfig.java` | `` |  | id, isFogMixinEnabled, isAdvancedFogOptionEnabled, isFogShapeOptionEnabled, isSingleFogOptionEnabled, isDimensionFogOptionEnabled, isDimensionFogShapeOptionEnabled, isProtectedGameplayFogOptionEnabled, isCloudHeightOptionEnabled, isPaniniProjectionOptionEnabled, fogSettings, getDimensionFogEffectIds, addKnownWorldDimensionEffectIds, getDimensionFogEffectId, setAtmosphericFogStart, setAtmosphericFogShape, setAtmosphericCloudFog, setDimensionFogStart, setDimensionFogShape, setDimensionCloudFog, fogOption, compareParticleNamespace, particleNamespaceName, capitalizeNamespacePart, parseVanillaString, translatableName, fallbackName, translatableTooltip, createAnimationsPage, createParticlesPage, createDetailsPage, createRenderPage, createExtraPage, createVerticalSyncOption, registerConfigLate |
| top-level / `me/flashyreese/mods/sodiumextra/client/config/SodiumExtraConfigKeys.java` | `` |  |  |
| top-level / `me/flashyreese/mods/sodiumextra/client/config/SodiumExtraGameOptions.java` | `` |  | load, load, sanitize, writeChanges, moveCorruptConfig, afterSave, sanitize, isParticleEnabled, sanitize, sanitize, sanitize, sanitize, getAtmospheric, getDimensionFogDistance, getDimensionFogStart, getDimensionFogShape, getDimensionCloudFogPercent, getDimensionOrFallback, getOrCreateDimensionOverride, createInheritedAtmospheric, getAtmosphericFallback, getAvailableOptions, getLocalizedName, getAvailableOptions, isAdaptiveSyncSupported, isSupported, getLocalizedName, getLocalizedName, getLocalizedName |
| top-level / `me/flashyreese/mods/sodiumextra/client/fog/FogDistanceHelper.java` | `` |  | getAtmosphericSettings, getFogDistance, getFogDistanceRange, getProtectedGameplayFogDistanceRange, getMaxFogDistance, getMaxFogDistance, getSodiumRenderDistanceMax, getSodiumConfig, getConfigFromState, getStart, applyStartMultiplier, getEnd, getCloudEnd, getCloudRenderDistance, disablesFog, applyRenderDistanceShape, decodeRenderDistanceStart, decodeRenderDistanceEnd, expandCylindricalCullDistance, isExpandedCylindricalCullDistance, testExpandedCylindricalCullDistance, isCylindricalRenderDistanceEncoded, getRenderDistanceShapeOffset, canEncodeRenderDistanceShape, isRenderDistanceShapeEncoded, isBossFogActive, shouldModifyProtectedGameplayFog, getProtectedGameplayFogDistance, getConfiguredProtectedGameplayFogDistance, applyProtectedGameplayFog, getFogSettings, isLocalWorldAllowedForProtectedGameplayFog, getIntAccessor, ExpandedCylindricalCull, matches, ProtectedGameplayFogPolicy, fromJson, clamp, ProtectedFogRule, clamp |
| top-level / `me/flashyreese/mods/sodiumextra/client/fog/FogShaderTransformer.java` | `` |  | isShapeSupported, injectRenderDistanceShape, warnDrift |
| top-level / `me/flashyreese/mods/sodiumextra/client/FrameCounter.java` | `` |  | getInstance, onFrame, computeSmoothFpsFromRecentFrames, getSmoothFps, getAverageFps, getOnePercentLowFps, getPointOnePercentLowFps, computePercentileLow, FrameSample |
| top-level / `me/flashyreese/mods/sodiumextra/client/gui/SodiumExtraDebugEntryCategory.java` | `` |  |  |
| top-level / `me/flashyreese/mods/sodiumextra/client/gui/SodiumExtraDebugEntryCoords.java` | `` |  | display |
| top-level / `me/flashyreese/mods/sodiumextra/client/gui/SodiumExtraDebugEntryFps.java` | `` |  | display, isAllowed |
| top-level / `me/flashyreese/mods/sodiumextra/client/gui/SodiumExtraDebugEntryLightUpdates.java` | `` |  | display, isAllowed |
| top-level / `me/flashyreese/mods/sodiumextra/client/gui/SodiumExtraHud.java` | `` |  | onStartTick, onHudRender, drawString |
| top-level / `me/flashyreese/mods/sodiumextra/client/render/PaniniProjection.java` | `` |  | process, shouldApply, hasValidWindow, updateUniforms, prepareConfigUniform, writeConfigUniform, reciprocalMagnitude, createConfigBuffer |
| top-level / `me/flashyreese/mods/sodiumextra/client/render/vertex/formats/TextureColorVertex.java` | `` |  | write, write |
| top-level / `me/flashyreese/mods/sodiumextra/client/render/vertex/formats/TextureVertex.java` | `` |  | write, write |
| top-level / `me/flashyreese/mods/sodiumextra/client/render/vertex/formats/WeatherVertex.java` | `` |  | put, put |
| top-level / `me/flashyreese/mods/sodiumextra/client/SodiumExtraClientMod.java` | `` |  | logger, options, mixinConfig, loadConfig, onTick, onHudRender, registerAll |
| top-level / `me/flashyreese/mods/sodiumextra/client/util/ToastFilter.java` | `` |  | isEnabled |
| top-level / `me/flashyreese/mods/sodiumextra/common/util/AnimationStateExtended.java` | `` |  |  |
| top-level / `me/flashyreese/mods/sodiumextra/common/util/ControlValueFormatterExtended.java` | `` |  | fogDistance, protectedFogDistance, ticks |
| top-level / `me/flashyreese/mods/sodiumextra/common/util/IdentifierSerializer.java` | `` |  | deserialize, serialize |
| top-level / `me/flashyreese/mods/sodiumextra/common/util/Utils.java` | `` |  | packLight, packPosition, unpackIntegers |
| top-level / `me/flashyreese/mods/sodiumextra/compat/IrisCompat.java` | `` |  | isRenderingShadowPass, isShaderPackInUse, getTerrainFormat, isIrisPresent |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/adaptive_sync/MixinGlSurface.java` | `value={GlSurface.class})` | Inject:1, WrapOperation:1 | sodiumExtra$usesAdaptiveSync, addFifoRelaxedPresentMode, setSwapInterval |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/animation/MixinSpriteContentsAnimationState.java` | `value={SpriteContents.AnimationState.class})` |  | sodium_extra$getSprite, sodium_extra$setSprite |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/animation/MixinTextureAtlas.java` | `value={TextureAtlas.class})` | WrapWithCondition:1, WrapOperation:1 | cycleAnimationFrames, upload, sodium_extra$shouldAnimate |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/biome_colors/MixinBiomeColors.java` | `value={BiomeColors.class})` | Inject:3 | grassColor, waterColor, foliageColor |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/cloud/MixinLevelRenderer.java` | `value={LevelRenderer.class})` | WrapOperation:1 | modifyCloudHeight |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/fog/AccessorIntegratedServer.java` | `targets={"net.minecraft.client.server.IntegratedServer"})` | Invoker:1 |  |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/fog/AccessorMinecraft.java` | `value={Minecraft.class})` | Accessor:1 |  |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/fog/MixinAtmosphericFogEnvironment.java` | `value={AtmosphericFogEnvironment.class})` | Inject:1 | postSetupFog, applyCloudFog |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/fog/MixinBlindnessFogEnvironment.java` | `value={BlindnessFogEnvironment.class})` | Inject:1 | postSetupFog |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/fog/MixinDarknessFogEnvironment.java` | `value={DarknessFogEnvironment.class})` | Inject:1 | postSetupFog |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/fog/MixinFogRenderer.java` | `value={FogRenderer.class}, priority=1300)` | Inject:2, WrapOperation:1, ModifyArgs:1 | resetFogEnvironment, captureFogEnvironment, postFogSetup, sodiumExtra$decodeRenderDistanceForVanillaShaders |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/fog/MixinLavaFogEnvironment.java` | `value={LavaFogEnvironment.class})` | Inject:1 | postSetupFog |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/fog/MixinOcclusionCuller.java` | `value={OcclusionCuller.class})` | ModifyArgs:1, Inject:1 | sodiumExtra$allowExpandedCylindricalVerticalTraversal, sodiumExtra$getOutwardVerticalDirections, sodiumExtra$testExpandedCylindricalDistance |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/fog/MixinPowderedSnowFogEnvironment.java` | `value={PowderedSnowFogEnvironment.class})` | Inject:1 | postSetupFog |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/fog/MixinRenderSectionManager.java` | `value={RenderSectionManager.class})` | ModifyReturnValue:3 | getRenderDistance, sodiumExtra$expandCylindricalFogCullDistance, sodiumExtra$expandCylindricalFogCullTypeDistance, sodiumExtra$expandCylindricalFogSearchDistance |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/fog/MixinShaderManager.java` | `value={ShaderManager.Configs.class})` | ModifyReturnValue:1 | sodiumExtra$injectRenderDistanceShape |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/fog/MixinTraversableTree.java` | `value={TraversableTree.class})` | Inject:1 | sodiumExtra$testExpandedCylindricalDistance |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/fog/MixinWaterFogEnvironment.java` | `value={WaterFogEnvironment.class})` | Inject:1 | postSetupFog |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/fps/MixinGameRenderer.java` | `value={GameRenderer.class})` | Inject:1 | onRender |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/gui/MixinDebugOptionsScreen.java` | `targets={"net.minecraft.client.gui.screens.debug.DebugOptionsScreen$OptionEntry"})` | Inject:1 | redirectExtractContent |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/gui/MixinGui.java` | `value={Gui.class})` | Inject:1 | onRender |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/gui/MixinMinecraftClient.java` | `value={Minecraft.class})` | Inject:1 | onRunTick |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/instant_sneak/MixinCamera.java` | `value={Camera.class})` | Inject:1 | noLerp |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/light_updates/MixinLevelLightEngine.java` | `value={LevelLightEngine.class})` | Inject:2 | checkBlock, doLightUpdates |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/panini_projection/AccessorPostChain.java` | `value={PostChain.class})` | Accessor:1 |  |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/panini_projection/AccessorPostPass.java` | `value={PostPass.class})` | Accessor:1 |  |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/panini_projection/MixinGameRenderer.java` | `value={GameRenderer.class})` | Inject:1 | sodiumExtra$applyPaniniProjection |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/particle/MixinClientLevel.java` | `value={ClientLevel.class})` | Inject:2, WrapWithCondition:1 | addBlockBreakParticles, addBlockBreakingParticles, addRainSplashParticle |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/particle/MixinFireworkParticle.java` | `value={FireworkParticles.Starter.class})` | Inject:1 | addExplosionParticle |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/particle/MixinLevelRenderer.java` | `value={WeatherEffectRenderer.class})` | Inject:1 | renderWeather |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/particle/MixinParticleEngine.java` | `value={ParticleEngine.class})` | Inject:1 | addParticle |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/prevent_shaders/MixinGameRenderer.java` | `value={GameRenderer.class})` | Inject:2 | preventShaders, dontLoadShader |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/reduce_resolution_on_mac/MixinWindow.java` | `value={Window.class})` | ModifyArg:1 | reduceWindowPixelDensity |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/render/block/entity/MixinBeaconRenderer.java` | `value={BeaconRenderer.class}, priority=999)` | Inject:1, WrapOperation:1 | render, modifyMaxY |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/render/block/entity/MixinEnchantingTableBlockEntityRenderer.java` | `value={EnchantTableRenderer.class})` | Inject:1 | render |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/render/block/entity/MixinPistonBlockEntityRenderer.java` | `value={PistonHeadRenderer.class})` | Inject:1 | render |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/render/entity/MixinItemFrameEntityRenderer.java` | `value={ItemFrameRenderer.class})` | Inject:2 | render, hasLabel |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/render/entity/MixinLivingEntityRenderer.java` | `value={LivingEntityRenderer.class})` | Inject:2 | onRender, shouldShowName |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/render/entity/MixinPaintingEntityRenderer.java` | `value={PaintingRenderer.class})` | Inject:1 | render |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/sky/MixinSkyRenderer.java` | `value={SkyRenderer.class})` | Inject:6 | redirectRenderSkyDisc, preRenderEndSky, renderSun, renderMoon, renderStars, renderSunriseAndSunset |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/sky_colors/MixinAtmosphericFogEnvironment.java` | `value={AtmosphericFogEnvironment.class})` | ModifyArg:1 | modifySkyColor |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/SodiumExtraMixinConfigPlugin.java` | `` |  | createConfig, mixinPackageRoot |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/steady_debug_hud/MixinDebugScreenOverlay.java` | `value={DebugScreenOverlay.class})` | Inject:1, WrapOperation:2 | preRender, sodiumExtra$wrapDrawLeftText, sodiumExtra$wrapDrawRightText |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/toasts/MixinToastInstance.java` | `targets={"net.minecraft.client.gui.components.toasts.ToastManager$ToastInstance"})` | Inject:1 | skipDisabledToast |
| top-level / `me/flashyreese/mods/sodiumextra/mixin/toasts/MixinToastManager.java` | `value={ToastManager.class})` | Inject:2 | goodByeToasts, removeDisabledQueuedToasts |
| top-level / `me/flashyreese/mods/sodiumextra/SodiumExtraFabricClientModInitializer.java` | `` |  | initFabric, onInitializeClient |
| top-level / `net/caffeinemc/caffeineconfig/AbstractCaffeineConfigMixinPlugin.java` | `` |  | onLoad, shouldApplyMixin, logger, getRefMapperConfig, acceptTargets, getMixins, preApply, postApply |
| top-level / `net/caffeinemc/caffeineconfig/CaffeineConfig.java` | `` |  | builder, getModName, getLogger, addOptionDependency, addMixinOption, addMixinOption, readProperties, applyOverrideableChecks, applyChildOptionsStateChecks, getEffectiveOptionForMixin, applyDependencies, getParent, writeDefaultConfig, getMixinOptionName, getOptionCount, getOptionOverrideCount, getOptions, addMixinOption, addMixinOption, addOptionDependency, withLogger, withSettingsKey, withInfoUrl, build |
| top-level / `net/caffeinemc/caffeineconfig/CaffeineConfigFabric.java` | `` |  | applyModOverrides |
| top-level / `net/caffeinemc/caffeineconfig/CaffeineConfigPlatform.java` | `` |  |  |
| top-level / `net/caffeinemc/caffeineconfig/Option.java` | `` |  | getName, isEnabled, isEnabledRecursive, isOverridden, isUserDefined, isOverrideable, isModDefined, getDefiningMods |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
