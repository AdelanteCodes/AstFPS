# VulkanCompat

Review status: **Evidence inventory; behavioral review pending**

Project: [VulkanCompat](https://modrinth.com/mod/vulkancompat)
Selected artifact version: `1.2-mc26.3`
Published implementation source: https://github.com/1Yuqas/VulkanCompat
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

VulkanCompat is a Fabric mod that lets Minecraft Vulkan run on older GPUs without dynamic rendering support

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `4a102d180644bdb2a874124616ea7dac4550c9c37b9a8b1d3bb4af554b47b92d8c5fa4d8cd09e695b6b9a084bd9418d13286eddf09804b6933f01b6ab85c0424`
- `sha1`: `27569b58d3068597299ff28cac7ef0216f98c4b3`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 17
Reconstructed Java files: 14

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "one.yuqas.Vulkancompat"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "fabric-api": "*",
  "minecraft": "26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `one/yuqas/compat/device/DeviceSupport.java` | `` |  | supportsDynamicRendering, deviceSupportsDynamicRendering, extensionName, featureName |
| top-level / `one/yuqas/compat/feature/FeatureCompat.java` | `` |  | stripFeatureSet, stripFeatureSets, filterFeatureSetsForDevice |
| top-level / `one/yuqas/compat/render/FramebufferCache.java` | `` |  | getOrCreate, invalidate, equals, hashCode |
| top-level / `one/yuqas/compat/render/LegacyRenderPass.java` | `` |  | invalidateFramebuffers, begin, createGraphicsPipelines |
| top-level / `one/yuqas/compat/render/PipelineCompat.java` | `` |  | createGraphicsPipelines |
| top-level / `one/yuqas/compat/render/RenderPassCache.java` | `` |  | getOrCreate, tryCreateRenderPass2, createRenderPassLegacy, equals, hashCode |
| top-level / `one/yuqas/compat/render/VulkanConstants.java` | `` |  |  |
| top-level / `one/yuqas/compat/view/ViewRegistry.java` | `` |  | pack, register, unregister, getPacked, contains, get, getFormat, getWidth, getHeight |
| top-level / `one/yuqas/mixin/VulkanBackendMixin.java` | `value={VulkanBackend.class})` | ModifyVariable:3 | qadish$filterRequiredFeatureSets, qadish$filterRequiredIfExtensionsAvailable, qadish$filterFindRequired |
| top-level / `one/yuqas/mixin/VulkanCommandEncoderMixin.java` | `value={VulkanCommandEncoder.class})` | Redirect:2 | qadish$beginRenderPass, qadish$endRenderPass |
| top-level / `one/yuqas/mixin/VulkanFeatureSetsMixin.java` | `value={VulkanFeatureSets.class})` | Inject:1 | qadish$stripDynamicRendering |
| top-level / `one/yuqas/mixin/VulkanGpuTextureViewMixin.java` | `value={VulkanGpuTextureView.class})` | Inject:2 | qadish$registerView, qadish$unregisterView |
| top-level / `one/yuqas/mixin/VulkanRenderPipelineMixin.java` | `value={VulkanRenderPipeline.class})` | Redirect:1 | qadish$createGraphicsPipelines |
| top-level / `one/yuqas/Vulkancompat.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
