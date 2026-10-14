# BadOptimizations

Review status: **Evidence inventory; behavioral review pending**

Project: [BadOptimizations](https://modrinth.com/mod/badoptimizations)
Selected artifact version: `2.4.1`
Published implementation source: https://github.com/ItsThosea/BadOpitmizations
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Optimization mod that focuses on things other than rendering

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `4cc25ce6217326ff14169f5358921773297e9475`
- `sha512`: `048a0979807afb96bae7801b7445746c985081bb55fab9b80b286036234a9869cc84f83c40ab77a2600b7e06ad44178ee17935b706b751c9b38f87ebc6e180f8`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 35
Reconstructed Java files: 32

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "modmenu": [
    "me.thosea.badoptimizations.fabric.modmenu.BadOptimizationsModMenu"
  ]
}
```

**depends**

```json
{
  "minecraft": ">=26.3",
  "fabricloader": ">=0.18.4"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `architectury_inject_BadOptimizations_common_eb5c47e6319548229146508c5f408a97_82d4f51f3c5f2750cd7edb6c4678fa4de73b384bfa94cb919207830ccbd38d7cBadOptimizationscommon241devjar/PlatformMethods.java` | `` |  | getCurrentTarget |
| top-level / `me/thosea/badoptimizations/config/BOConfigScreen.java` | `` |  | init |
| top-level / `me/thosea/badoptimizations/config/Config.java` | `` |  | init, writeConfig |
| top-level / `me/thosea/badoptimizations/config/ConfigLoadContext.java` | `` |  | loadProp, boolOrDefault, intOrDefault, str, fromExistingFile, dumpConfig, optimization, optimization, option, option |
| top-level / `me/thosea/badoptimizations/config/ConfigOptimization.java` | `` |  | toString |
| top-level / `me/thosea/badoptimizations/config/ModIncompatibilities.java` | `` |  | builtIn, getList, ignoreIncompatibilities, isIncompatible, IncompatibleMod |
| top-level / `me/thosea/badoptimizations/fabric/modmenu/BadOptimizationsModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `me/thosea/badoptimizations/hook/CacheHooks.java` | `` |  | init, invokeCommon, invokeLightmap, invokeSkyColor, CacheHookEntry |
| top-level / `me/thosea/badoptimizations/hook/HookCreator.java` | `` |  | tryCreateHook |
| top-level / `me/thosea/badoptimizations/interfaces/BlockEntityTypeMethods.java` | `` |  |  |
| top-level / `me/thosea/badoptimizations/interfaces/EntityMethods.java` | `` |  |  |
| top-level / `me/thosea/badoptimizations/interfaces/EntityTypeMethods.java` | `` |  |  |
| top-level / `me/thosea/badoptimizations/mixin/accessors/GameRendererAccessor.java` | `value={GameRenderer.class})` | Accessor:1 |  |
| top-level / `me/thosea/badoptimizations/mixin/accessors/PlayerAccessor.java` | `value={LocalPlayer.class})` | Accessor:1 |  |
| top-level / `me/thosea/badoptimizations/mixin/BOMixinPlugin.java` | `` |  | onLoad, shouldApplyMixin, getRefMapperConfig, acceptTargets, getMixins, preApply, postApply |
| top-level / `me/thosea/badoptimizations/mixin/debug/MixinDebugRenderer.java` | `value={DebugRenderer.class})` | Inject:1 | onRender |
| top-level / `me/thosea/badoptimizations/mixin/MixinDebugHud_AddText.java` | `value={DebugScreenEntries.class})` | Inject:1 | onInit, display, isAllowed, register |
| top-level / `me/thosea/badoptimizations/mixin/MixinParticleManager.java` | `value={ParticleEngine.class})` | Inject:1 | onRender |
| top-level / `me/thosea/badoptimizations/mixin/MixinToastComponent.java` | `value={ToastManager.class})` | ModifyExpressionValue:1 | shouldSkipDraw |
| top-level / `me/thosea/badoptimizations/mixin/renderer/blockentity/MixinBlockEntityRenderDispatcher.java` | `value={BlockEntityRenderDispatcher.class}, priority=700)` | Overwrite:1, Inject:1 | getRenderer, afterReload |
| top-level / `me/thosea/badoptimizations/mixin/renderer/blockentity/MixinBlockEntityType.java` | `value={BlockEntityType.class})` |  | bo$getRenderer, bo$setRenderer |
| top-level / `me/thosea/badoptimizations/mixin/renderer/entity/MixinClientPlayer.java` | `value={AbstractClientPlayer.class})` |  | bo$getRenderer |
| top-level / `me/thosea/badoptimizations/mixin/renderer/entity/MixinEntity.java` | `value={Entity.class})` | Inject:1 | afterInit, bo$getRenderer |
| top-level / `me/thosea/badoptimizations/mixin/renderer/entity/MixinEntityRendererDispatcher.java` | `value={EntityRenderDispatcher.class}, priority=700)` | Overwrite:1, Inject:1 | getRenderer, bo$getOtherRenderer, afterReload |
| top-level / `me/thosea/badoptimizations/mixin/renderer/entity/MixinEntityType.java` | `value={EntityType.class})` |  | bo$getRenderer, bo$setRenderer |
| top-level / `me/thosea/badoptimizations/mixin/renderer/entity/MixinMannequinPlayer.java` | `value={ClientMannequin.class})` |  | bo$getRenderer |
| top-level / `me/thosea/badoptimizations/mixin/tick/MixinCamera.java` | `value={Camera.class})` | WrapOperation:1 | getPlayerFov |
| top-level / `me/thosea/badoptimizations/mixin/tick/MixinLightmapExtractor.java` | `value={LightmapRenderStateExtractor.class})` | Inject:2 | onInit, onTick, bo$isDirty |
| top-level / `me/thosea/badoptimizations/mixin/tick/MixinTutorial.java` | `value={Tutorial.class})` | Inject:1 | onTick |
| top-level / `me/thosea/badoptimizations/other/PlayerModelRendererHolder.java` | `` |  | forModel |
| top-level / `me/thosea/badoptimizations/utils/fabric/PlatformMethodsImpl.java` | `` |  | getVersion, getConfigFolder, isModLoaded, isOnServer, streamConfigTemplate, ownModContainer, getModIncompatibilities, getModCacheHooks, getEntry |
| top-level / `me/thosea/badoptimizations/utils/PlatformMethods.java` | `` |  | getVersion, getConfigFolder, isModLoaded, isOnServer, streamConfigTemplate, getModIncompatibilities, getModCacheHooks |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
