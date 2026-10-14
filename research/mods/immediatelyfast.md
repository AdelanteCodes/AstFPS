# ImmediatelyFast

Review status: **Evidence inventory; behavioral review pending**

Project: [ImmediatelyFast](https://modrinth.com/mod/immediatelyfast)
Selected artifact version: `1.17.1+26.3-fabric`
Published implementation source: https://github.com/RaphiMC/ImmediatelyFast
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Speed up immediate mode rendering in Minecraft

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `f565bbeb201f2305e81761429d3f1f47e1c3a321`
- `sha512`: `8e139589fd995bce3d485a34d92a07243964212f7ed2e4fc2f6de5b9a74d0f59b03252e7ce40c64e006cf3e21bed5de27b830d33ef048b286e041f6178ad8428`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 44
Reconstructed Java files: 43

**environment**

```json
"client"
```

**depends**

```json
{
  "java": ">=25",
  "minecraft": "26.3.x",
  "fabricloader": ">=0.19.3"
}
```

**accessWidener**

```json
"immediatelyfast.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/raphimc/immediatelyfast/fabric/FabricPlatformService.java` | `` |  | getConfigDirectory, getModVersion |
| top-level / `net/raphimc/immediatelyfast/feature/batch_animated_item_updates/AnimatedItemAtlas.java` | `` |  | computeTextureSizeFor, getOrUpdate, endFrame, getLastUsedSlotCount |
| top-level / `net/raphimc/immediatelyfast/feature/core/ImmediatelyFastConfig.java` | `` |  | getBoolean, getInt, getLong, getString |
| top-level / `net/raphimc/immediatelyfast/feature/core/ImmediatelyFastDebugScreenEntry.java` | `` |  | display, isAllowed |
| top-level / `net/raphimc/immediatelyfast/feature/core/ImmediatelyFastRuntimeConfig.java` | `` |  | getBoolean, getInt, getLong, getString |
| top-level / `net/raphimc/immediatelyfast/feature/map_atlas_generation/MapAtlas.java` | `` |  | getAtlasIdFromLocation, getAtlasXFromLocation, getAtlasYFromLocation, getNextLocation, getId, getTextureId, getTexture, getMapCount, close |
| top-level / `net/raphimc/immediatelyfast/feature/resource_pack_conflict_handling/CoreShaderBlacklist.java` | `` |  | getBlacklist |
| top-level / `net/raphimc/immediatelyfast/feature/resource_pack_conflict_handling/ImmediatelyFastResourcePackMetadata.java` | `` |  | ImmediatelyFastResourcePackMetadata |
| top-level / `net/raphimc/immediatelyfast/feature/sign_text_buffering/SignAtlasRenderTarget.java` | `` |  | findSlot, clear, getId, getTextureId, close, markFree, findSlot, removeUnoccupiedSubSlots, hasOccupiedSlot |
| top-level / `net/raphimc/immediatelyfast/feature/sign_text_buffering/SignTextCache.java` | `` |  | clearCache, onResourceManagerReload |
| top-level / `net/raphimc/immediatelyfast/ImmediatelyFast.java` | `` |  | earlyInit, onRenderSystemInit, lateInit, onLevelChange, loadConfig, createRuntimeConfig |
| top-level / `net/raphimc/immediatelyfast/injection/ImmediatelyFastMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `net/raphimc/immediatelyfast/injection/interfaces/IGuiRenderer.java` | `` |  |  |
| top-level / `net/raphimc/immediatelyfast/injection/interfaces/IIris_OuterWrappedRenderType.java` | `` |  |  |
| top-level / `net/raphimc/immediatelyfast/injection/interfaces/IMapRenderState.java` | `` |  |  |
| top-level / `net/raphimc/immediatelyfast/injection/interfaces/IMapTextureManager.java` | `` |  |  |
| top-level / `net/raphimc/immediatelyfast/injection/interfaces/ISignText.java` | `` |  |  |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/avoid_redundant_framebuffer_switching/MixinGlCommandEncoder.java` | `targets={"com.mojang.renderpearl.backend.opengl.GlCommandEncoder"})` | WrapWithCondition:1, Inject:1 | dontUnbindFramebuffer, unbindFramebufferBeforePresenting |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/avoid_redundant_framebuffer_switching/MixinGlSurface.java` | `value={GlSurface.class})` | Inject:1 | unbindFramebufferBeforeSwappingBuffers |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/batch_animated_item_updates/MixinGuiRenderer.java` | `value={GuiRenderer.class})` | Inject:4, ModifyReceiver:1 | prepareAnimatedItemAtlas, useAnimatedItemAtlas, endAnimatedItemAtlasFrame, invalidateAnimatedItemAtlas, closeAnimatedItemAtlas, immediatelyFast$prepareAnimatedItemAtlas, immediatelyFast$closeAnimatedItemAtlas, immediatelyFast$getAnimatedItemAtlas |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/core/MixinDebugScreenEntries.java` | `value={DebugScreenEntries.class})` | Inject:1 | register, addImmediatelyFastEntry |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/core/MixinMinecraft.java` | `value={Minecraft.class})` | Inject:3 | hookRendererInit, hookConstructor, hookLevelChange |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/enhanced_batching/compat/iris/MixinIris_OuterWrappedRenderType.java` | `targets={"net.irisshaders.iris.layer.OuterWrappedRenderType"})` |  | immediatelyFast$getWrapped |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/enhanced_batching/compat/iris/MixinRenderTypeFeatureRenderer_Group.java` | `targets={"net.minecraft.client.renderer.feature.RenderTypeFeatureRenderer$Group"})` | ModifyExpressionValue:1 | fixOrder, immediatelyFast$isBannerPattern |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/enhanced_batching/MixinRenderTypeFeatureRenderer_Group.java` | `targets={"net.minecraft.client.renderer.feature.RenderTypeFeatureRenderer$Group"})` | ModifyVariable:1 | forceReorderability |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/enhanced_batching/MixinScissorState.java` | `value={ScissorState.class})` |  | equals, hashCode |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/fast_text_lookup/MixinTextFeatureRenderer_GlyphRenderer.java` | `targets={"net.minecraft.client.renderer.feature.TextFeatureRenderer$GlyphRenderer"})` | Redirect:1 | reduceGetVertexBuilderCalls |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/fix_slow_buffer_upload_on_apple_gpu/MixinGlCommandEncoder.java` | `targets={"com.mojang.renderpearl.backend.opengl.GlCommandEncoder"})` | Redirect:1 | fixSlowBufferUploadOnAppleGpu |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/font_atlas_resizing/MixinFontTexture.java` | `value={FontTexture.class})` | Inject:1, ModifyConstant:2 | cacheConfigState, modifyTextureSize, modifyTextureSize |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/map_atlas_generation/MixinGuiGraphicsExtractor.java` | `value={GuiGraphicsExtractor.class})` | WrapOperation:1 | modifyTextureCoordinates |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/map_atlas_generation/MixinMapRenderer.java` | `value={MapRenderer.class})` | ModifyArg:1, Inject:1 | modifyTextureCoordinates, setAtlasParameters |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/map_atlas_generation/MixinMapRenderState.java` | `value={MapRenderState.class})` |  | immediatelyFast$getAtlasTextureId, immediatelyFast$setAtlasTextureId, immediatelyFast$getAtlasX, immediatelyFast$setAtlasX, immediatelyFast$getAtlasY, immediatelyFast$setAtlasY |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/map_atlas_generation/MixinMapTextureManager.java` | `value={MapTextureManager.class})` | Inject:2 | resetAtlases, ensureHasAtlasLocation, immediatelyFast$getAtlas, immediatelyFast$getAtlasLocation, immediatelyFast$getAtlases |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/map_atlas_generation/MixinMapTextureManager_MapInstance.java` | `targets={"net.minecraft.client.resources.MapTextureManager$MapInstance"})` | Inject:2 | getAtlasParameters, updateAtlasTexture |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/print_additional_error_information/MixinGlDebug.java` | `value={GlDebug.class})` | ModifyVariable:1, Redirect:1 | enableSyncDebug, appendStackTrace |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/resource_pack_conflict_handling/MixinMinecraft.java` | `value={Minecraft.class})` | Inject:1 | checkResourcePackCompatibility, immediatelyFast$reloadFontStorages, immediatelyFast$reloadMapTextures, immediatelyFast$arePackResourcesEqual |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/sign_text_buffering/MixinAbstractSignRenderer.java` | `value={AbstractSignRenderer.class})` | Inject:1 | renderBufferedSignText, immediatelyFast$getTextWidth |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/sign_text_buffering/MixinSignText.java` | `value={SignText.class})` | Inject:2 | checkShouldCache, invalidateCache, immediatelyFast$shouldCache, immediatelyFast$setShouldCache |
| top-level / `net/raphimc/immediatelyfast/injection/mixins/skip_text_translucency_sorting/MixinRenderTypes.java` | `value={RenderTypes.class}, priority=500)` | Redirect:1 | disableTranslucencySorting |
| top-level / `net/raphimc/immediatelyfast/service/PlatformService.java` | `` |  |  |
| top-level / `net/raphimc/immediatelyfast/util/GpuOnlyTexture.java` | `` |  | dumpContents |
| top-level / `net/raphimc/immediatelyfast/util/RenderTargetTexture.java` | `` |  | close, dumpContents |
| top-level / `net/raphimc/immediatelyfast/util/ServiceUtil.java` | `` |  | load |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
