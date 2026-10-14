# Borderless Windowed Vulkan

Review status: **Evidence inventory; behavioral review pending**

Project: [Borderless Windowed Vulkan](https://modrinth.com/mod/borderless-windowed-vulkan)
Selected artifact version: `26.3`
Published implementation source: https://github.com/cutebow/Borderless-Windowed-Vulkan
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Pretty much cubes without boarders mod but working with vulkan mod - This also works without vulkan incase you just prefer this mod

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `915cbf11bb7c331b7a77fac694c79497a5e19d516bb91e8feb9b429e51ac7c5005470960937658afb969bf5c453a9981f67bcdf4589d948e50965ac6b0dddd9d`
- `sha1`: `b6007d5f86237ddc080cb7ab00d93257d5e31151`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 0
Reconstructed Java files: Not available

**environment**

```json
"client"
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": [
    ">=26.1 <=26.1.2",
    "26.3"
  ],
  "borderless_windowed_vulkan": "*"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/BorderlessVulkan-26.1-26.1.2.jar` | 10 | `borderless_windowed_vulkan` | Reconstructed source; semantic review pending |
| `META-INF/jars/BorderlessVulkan-26.3.jar` | 10 | `borderless_windowed_vulkan` | Reconstructed source; semantic review pending |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| META-INF/jars/BorderlessVulkan-26.1-26.1.2.jar / `me/cutebow/borderless_windowed_vulkan/BorderlessWindowedVulkanClient.java` | `` |  | onInitializeClient |
| META-INF/jars/BorderlessVulkan-26.1-26.1.2.jar / `me/cutebow/borderless_windowed_vulkan/BorderlessWindowedVulkanConfig.java` | `` |  | get, createScreen |
| META-INF/jars/BorderlessVulkan-26.1-26.1.2.jar / `me/cutebow/borderless_windowed_vulkan/BorderlessWindowedVulkanWindowController.java` | `` |  | tick, resetForHandle, applyBorderless, applyWaylandBorderless, restoreNormal, restoreWaylandNormal, isAcceptableBorderlessState, saveBoundsIfSane, updateSavedBoundsIfSane, saveSizeIfSane, isSaneSaved, clampToMonitor, clamp, setAttrib, resolveTargetMonitor, findBestMonitor, getMonitorRect, getWindowRect, getWindowSize, getFramebufferSize, matchesRect, matchesSize, close, isWayland, FramebufferSize, MonitorRect, WindowRect, WindowSize |
| META-INF/jars/BorderlessVulkan-26.1-26.1.2.jar / `me/cutebow/borderless_windowed_vulkan/mixin/SwapChainImageReadinessMixin.java` | `targets={"net.vulkanmod.vulkan.framebuffer.SwapChain"}, remap=false)` | Inject:1 | borderless_windowed_vulkan$hasImages, borderless_windowed_vulkan$getBooleanField, borderless_windowed_vulkan$getObjectField, borderless_windowed_vulkan$getIntField, borderless_windowed_vulkan$getListField, borderless_windowed_vulkan$getCachedField, borderless_windowed_vulkan$findField, borderless_windowed_vulkan$getExtentInt |
| META-INF/jars/BorderlessVulkan-26.1-26.1.2.jar / `me/cutebow/borderless_windowed_vulkan/ModMenuEntry.java` | `` |  | getModConfigScreenFactory |
| META-INF/jars/BorderlessVulkan-26.3.jar / `me/cutebow/borderless_windowed_vulkan/BorderlessWindowedVulkanClient.java` | `` |  | onInitializeClient |
| META-INF/jars/BorderlessVulkan-26.3.jar / `me/cutebow/borderless_windowed_vulkan/BorderlessWindowedVulkanConfig.java` | `` |  | get, createScreen |
| META-INF/jars/BorderlessVulkan-26.3.jar / `me/cutebow/borderless_windowed_vulkan/BorderlessWindowedVulkanWindowController.java` | `` |  | tick, resetForHandle, applyBorderless, applyWaylandBorderless, restoreNormal, restoreWaylandNormal, isAcceptableBorderlessState, saveBoundsIfSane, updateSavedBoundsIfSane, saveSizeIfSane, isSaneSaved, clampToMonitor, clamp, setAttrib, resolveTargetMonitor, findBestMonitor, getMonitorRect, getWindowRect, getWindowSize, getFramebufferSize, matchesRect, matchesSize, close, isWayland, MonitorRect, WindowRect, WindowSize, FramebufferSize |
| META-INF/jars/BorderlessVulkan-26.3.jar / `me/cutebow/borderless_windowed_vulkan/mixin/SwapChainImageReadinessMixin.java` | `targets={"net.vulkanmod.vulkan.framebuffer.SwapChain"}, remap=false)` | Inject:1 | borderless_windowed_vulkan$hasImages, borderless_windowed_vulkan$getBooleanField, borderless_windowed_vulkan$getObjectField, borderless_windowed_vulkan$getIntField, borderless_windowed_vulkan$getListField, borderless_windowed_vulkan$getCachedField, borderless_windowed_vulkan$findField, borderless_windowed_vulkan$getExtentInt |
| META-INF/jars/BorderlessVulkan-26.3.jar / `me/cutebow/borderless_windowed_vulkan/ModMenuEntry.java` | `` |  | getModConfigScreenFactory |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
