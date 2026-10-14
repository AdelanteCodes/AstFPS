# NoRender+

Review status: **Evidence inventory; behavioral review pending**

Project: [NoRender+](https://modrinth.com/mod/norender-plus)
Selected artifact version: `1.0.7,26.3`
Published implementation source: https://github.com/CIOCOLATA47/NoRender
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Allows you to stop rendering particles,overlays,world  and entity good for pvp and fps

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `85d8f327eb0fc87686577267b61cbe49bf9b5e1e`
- `sha512`: `baf96dfb1be3ede48f102d78778b352ab8b5c671f1b20ae8f8d60fb9fdcc7215245920b85903ad70ec0bfb6a0fb52787e2c7e6af39ffaac6ea65293dcb42ddda`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 36
Reconstructed Java files: 35

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "me.cioco.norender.Main"
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

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/cioco/norender/config/NoRenderCfg.java` | `` |  | saveConfiguration, loadConfiguration, isValidConfigField, getConfigPath |
| top-level / `me/cioco/norender/gui/NoRenderGui.java` | `` |  | init, syncWidgetPositions, applySearch, extractRenderState, mouseScrolled, add, renderSectionGroup, drawStyledPanel, drawScrollBar, getToggleText, onClose, addOverlayButtons, addWorldButtons, addCommonParticleButtons, addNewEraParticleButtons, addTechnicalButtons, addHudButtons, addWorldRenderButtons, addMoreParticleButtons, addExtraParticleButtons, addMoreEntityButtons, addMiscButtons, WidgetEntry |
| top-level / `me/cioco/norender/Main.java` | `` |  | onInitializeClient |
| top-level / `me/cioco/norender/mixin/HideSignTextMixin.java` | `value={AbstractSignRenderer.class})` | Inject:1 | skipSignText |
| top-level / `me/cioco/norender/mixin/MixinBlockBreakParticles.java` | `value={ParticleEngine.class})` | Inject:1 | cancelTerrainParticles |
| top-level / `me/cioco/norender/mixin/MixinCloudRenderer.java` | `value={CloudRenderer.class})` | Inject:2 | norender$onRender, norender$onRenderOit |
| top-level / `me/cioco/norender/mixin/MixinEntityRenderer.java` | `value={EntityRenderer.class})` | Inject:1 | noRenderEntities |
| top-level / `me/cioco/norender/mixin/MixinFireworkStarter.java` | `targets={"net.minecraft.client.particle.FireworkParticles$Starter"})` | Inject:1 | onTick |
| top-level / `me/cioco/norender/mixin/MixinHudElements.java` | `value={Hud.class})` | Inject:6 | onCrosshair, onHotbar, onChat, onTitle, onPlayerList, onAdvancementToast |
| top-level / `me/cioco/norender/mixin/MixinInGameHud.java` | `value={Hud.class})` | Inject:8 | handleSpyglassRender, handlePortalRender, handleVignetteRender, handleNauseaRender, onRenderScoreboardSidebar, handleBossBarRender, handleStatusEffectRender, handleTextureOverlay |
| top-level / `me/cioco/norender/mixin/MixinInGameOverlayRenderer.java` | `value={ScreenEffectRenderer.class})` | Inject:4 | onRenderFire, onRenderLiquid, noInWallOverlay, noTotemAnimation |
| top-level / `me/cioco/norender/mixin/MixinLavaFogEnvironment.java` | `value={LavaFogEnvironment.class})` | Inject:1 | norender$noLavaFog |
| top-level / `me/cioco/norender/mixin/MixinLevelExtractor.java` | `value={LevelExtractor.class})` | Inject:1 | onExtractParticles |
| top-level / `me/cioco/norender/mixin/MixinLevelRenderer.java` | `value={LevelRenderer.class})` | Inject:1 | norender$onAddSkyPass |
| top-level / `me/cioco/norender/mixin/MixinLevelRendererMisc.java` | `value={LevelRenderer.class})` | Inject:2 | onBlockCrack, onEntityHitboxes |
| top-level / `me/cioco/norender/mixin/MixinLevelRendererReadyGuard.java` | `value={LevelRenderer.class})` | Inject:1 | norender$skipUntilReady |
| top-level / `me/cioco/norender/mixin/MixinLightmapRenderStateExtractor.java` | `value={LightmapRenderStateExtractor.class})` | Inject:1 | norender$noDarkness |
| top-level / `me/cioco/norender/mixin/MixinLivingEntity.java` | `value={LivingEntity.class})` | Inject:1 | handleFoodParticleDisplay |
| top-level / `me/cioco/norender/mixin/MixinMobEffectFogEnvironment.java` | `value={MobEffectFogEnvironment.class})` | Inject:1 | norender$onIsApplicable |
| top-level / `me/cioco/norender/mixin/MixinNausea.java` | `value={GameRenderer.class})` | Redirect:1 | norender$noNausea |
| top-level / `me/cioco/norender/mixin/MixinNoFog.java` | `value={FogRenderer.class})` | Inject:1 | norender$killFog |
| top-level / `me/cioco/norender/mixin/MixinNoGrassFlowers.java` | `value={ModelBlockRenderer.class})` | Inject:1 | skipGrassAndFlowers |
| top-level / `me/cioco/norender/mixin/MixinParticleManager.java` | `value={ParticleEngine.class})` | Inject:1 | onAddParticle |
| top-level / `me/cioco/norender/mixin/MixinPowderedSnowFogEnvironment.java` | `value={PowderedSnowFogEnvironment.class})` | Inject:1 | norender$noSnowFog |
| top-level / `me/cioco/norender/mixin/MixinWaterFogEnvironment.java` | `value={WaterFogEnvironment.class})` | Inject:1 | norender$noWaterFog |
| top-level / `me/cioco/norender/mixin/MixinWeatherEffectRenderer.java` | `value={WeatherEffectRenderer.class})` | Inject:1 | norender$cancelWeather |
| top-level / `me/cioco/norender/mixin/NoBeaconBeamMixin.java` | `value={BeaconRenderer.class})` | Inject:1 | cancelBeaconBeam |
| top-level / `me/cioco/norender/mixin/NoConduitEyeMixin.java` | `value={ConduitRenderer.class})` | Inject:1 | cancelConduitEye |
| top-level / `me/cioco/norender/mixin/NoGlowMixin.java` | `value={LivingEntity.class, Entity.class})` | Inject:1 | isglowing |
| top-level / `me/cioco/norender/mixin/NoRenderArmorMixin.java` | `value={HumanoidArmorLayer.class})` | Inject:1 | onSubmit |
| top-level / `me/cioco/norender/mixin/NoRenderHeadFeatureMixin.java` | `value={CustomHeadLayer.class})` | Inject:1 | skipHeadRender |
| top-level / `me/cioco/norender/mixin/sodium/MixinNoGrassFlowersSodium.java` | `targets={"net.caffeinemc.mods.sodium.client.render.chunk.compile.pipeline.BlockRenderer"}, remap=false)` | Inject:1 | skipGrassAndFlowers |
| top-level / `me/cioco/norender/mixin/sodium/MixinSodiumWorldRenderer.java` | `value={SodiumWorldRenderer.class}, remap=false)` | ModifyVariable:1 | norender$killSodiumFog |
| top-level / `me/cioco/norender/MixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `me/cioco/norender/util/NoRenderUtil.java` | `` |  | tick, isGameReady, shouldCancel |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
