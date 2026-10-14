# ParaMax

Review status: **Evidence inventory; behavioral review pending**

Project: [ParaMax](https://modrinth.com/mod/paramax)
Selected artifact version: `v1.3.1+26.3`
Published implementation source: https://github.com/AliensToEarth/ParaMax
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Customizable performance & optimization mod with focus on frame pacing (smoothing).

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `2b7d2b7ba293f0f2e3eb8a767e536045a3e255ff953423793053c14dc99ca8755db907fc55102afb4426f90df24af2b1c800c973b39c164c57c98693a8f99e24`
- `sha1`: `9d525f0cb32916c7098a4b8a667d1c402a14a0cc`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 29
Reconstructed Java files: 25

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "dev.alienstoearth.paramax.ParaMaxClient"
  ],
  "modmenu": [
    "dev.alienstoearth.paramax.modmenu.ParaMaxModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": ">=26.2",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/alienstoearth/paramax/config/ParaMaxConfig.java` | `` |  | path, get, load, save, resetToDefaults, clamp |
| top-level / `dev/alienstoearth/paramax/config/ParaMaxPreset.java` | `` |  | apply |
| top-level / `dev/alienstoearth/paramax/governor/ParticleSpawnBudget.java` | `` |  | reset, tryAcquire |
| top-level / `dev/alienstoearth/paramax/governor/PerformanceGovernor.java` | `` |  | recordFrame, anticipate, spikeRatio, tick, reset, level, active, particleMultiplier, halfRateTextureAnimations, maxEntityRenderDistance |
| top-level / `dev/alienstoearth/paramax/mixin/BlockEntityStateReuseMixin.java` | `value={BlockEntityRenderDispatcher.class})` | Inject:1 | paramax$tryExtractRenderState |
| top-level / `dev/alienstoearth/paramax/mixin/CosmeticEntityTickMixin.java` | `value={ClientLevel.class})` | Inject:1 | paramax$halfTickCosmetics |
| top-level / `dev/alienstoearth/paramax/mixin/DynamicFpsMixin.java` | `value={Minecraft.class})` | Inject:1 | paramax$throttleUnfocused |
| top-level / `dev/alienstoearth/paramax/mixin/EntityRenderCullingMixin.java` | `value={EntityRenderer.class})` | Inject:1 | paramax$distanceCull |
| top-level / `dev/alienstoearth/paramax/mixin/EntityRendererInvoker.java` | `value={EntityRenderer.class})` | Invoker:1 |  |
| top-level / `dev/alienstoearth/paramax/mixin/FramePacingMixin.java` | `value={Minecraft.class})` | Inject:1 | paramax$pace, paramax$renderOnlyPercentile, paramax$preciseWait |
| top-level / `dev/alienstoearth/paramax/mixin/ParallelEntityVisibilityMixin.java` | `value={LevelExtractor.class})` | Inject:1, Redirect:1 | paramax$prepass, paramax$lookup |
| top-level / `dev/alienstoearth/paramax/mixin/ParticleSpawnBudgetMixin.java` | `value={ParticleEngine.class})` | Inject:2 | paramax$resetBudget, paramax$budgetedAdd |
| top-level / `dev/alienstoearth/paramax/mixin/ParticleThrottleMixin.java` | `value={ParticleEngine.class})` | Inject:1 | paramax$throttle, paramax$beyondCullDistance |
| top-level / `dev/alienstoearth/paramax/mixin/SmartLightmapMixin.java` | `value={LightmapRenderStateExtractor.class})` | Inject:1 | paramax$smartTick |
| top-level / `dev/alienstoearth/paramax/mixin/SpikeAnticipationMixin.java` | `value={ClientPacketListener.class})` | Inject:2 | paramax$anticipateExplosion, paramax$anticipateParticleBurst |
| top-level / `dev/alienstoearth/paramax/mixin/TemporalEntityLodMixin.java` | `value={EntityRenderer.class})` | Inject:1 | paramax$temporalLod, paramax$fullUpdate |
| top-level / `dev/alienstoearth/paramax/mixin/TextureAnimationRateMixin.java` | `targets={"net.minecraft.client.renderer.texture.SpriteContents$AnimationState"})` | Inject:1 | paramax$halfRate |
| top-level / `dev/alienstoearth/paramax/modmenu/ParaMaxConfigScreen.java` | `` |  | init, addPresetRow, addPresetButton, buildToggles, buildSliders, extractRenderState, onClose, Toggle |
| top-level / `dev/alienstoearth/paramax/modmenu/ParaMaxModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `dev/alienstoearth/paramax/modmenu/ParaMaxSlider.java` | `` |  | clamp, realValue, updateMessage, applyValue |
| top-level / `dev/alienstoearth/paramax/parallel/BlockEntityStateCache.java` | `` |  | get, put, clear, isEmpty, maybeSweep |
| top-level / `dev/alienstoearth/paramax/parallel/ParallelEngine.java` | `` |  | boot, pool, workerCount, isWorkerThread, execute |
| top-level / `dev/alienstoearth/paramax/parallel/TemporalLodCache.java` | `` |  | get, put, clear, isEmpty, maybeSweep |
| top-level / `dev/alienstoearth/paramax/ParaMaxClient.java` | `` |  | onInitializeClient |
| top-level / `dev/alienstoearth/paramax/ParaMaxState.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
