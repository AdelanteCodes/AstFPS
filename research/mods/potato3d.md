# Potato3D

Review status: **Evidence inventory; behavioral review pending**

Project: [Potato3D](https://modrinth.com/mod/potato3d)
Selected artifact version: `1.2.0+26.3`
Published implementation source: https://github.com/Patbox/Potato3D
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

The ~~Future~~ Past of Rendering is Now, and it's all in Java™!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `155cea867e22750c2ce2fb963704dcb5953286a65ff119a796d5a5b875459ba6a5e76754040fdcd44929a8b4d89d233cbb86af803eb1c38622b245ad7fb7d86f`
- `sha1`: `b6e4e820ff5a848fc1722a834b3c52981b7187a3`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 35
Reconstructed Java files: 25

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "eu.pb4.potato3d.Potato3D"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "minecraft": "~26.3-",
  "java": ">=25"
}
```

**breaks**

```json
{
  "sodium": "*",
  "iris": "*",
  "immediatelyfast": "*"
}
```

**accessWidener**

```json
"potato3d.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `eu/pb4/potato3d/blaze3d/shader/EndShader.java` | `` |  | sample |
| top-level / `eu/pb4/potato3d/blaze3d/shader/SampledTexture.java` | `` |  | sample, sampleRaw, sampleRawWrap |
| top-level / `eu/pb4/potato3d/blaze3d/shader/SoftShader.java` | `` |  |  |
| top-level / `eu/pb4/potato3d/blaze3d/SoftBackend.java` | `` |  | getName, loadLibrary, unloadLibrary, createWindow, createDevice |
| top-level / `eu/pb4/potato3d/blaze3d/SoftBuffer.java` | `` |  | size, isClosed, data, close, map |
| top-level / `eu/pb4/potato3d/blaze3d/SoftCommandEncoder.java` | `` |  | submit, transientMemory, createRenderPass, submitRenderPass, clearColorTexture, clearColorAndDepthTextures, clearColorAndDepthTextures, clearDepthTexture, writeToBuffer, copyToBuffer, writeToTexture, copyBufferToTexture, copyTextureToBuffer, copyTextureToBuffer, copyTextureToTexture, createFence, close, awaitCompletion, writeTimestamp |
| top-level / `eu/pb4/potato3d/blaze3d/SoftDevice.java` | `` |  | createSurface, configure, isSuboptimal, acquireNextTexture, blitFromTexture, present, supportedPresentModes, close, createCommandEncoder, createSampler, createTexture, createTextureView, createBuffer, createBuffer, getLastDebugMessages, isDebuggingEnabled, compilePipeline, close, createTimestampQueryPool, size, getValue, getValues, close, getTimestampCalibrationOffset, getDeviceInfo |
| top-level / `eu/pb4/potato3d/blaze3d/SoftRenderPass.java` | `` |  | lerp, copy, pushDebugGroup, popDebugGroup, setUniform, enableScissor, disableScissor, setVertexBuffer, setIndexBuffer, drawIndexed, draw, multiDrawIndexed, multiDrawIndexed, multiDraw, multiDraw, drawIndirect, drawIndexedIndirect, writeTimestamp, pushConstants, setPipeline, drawAnimateSpriteBlit, executeLightmapDraw, executeNoOpDraw, executeDraw, getVertexPos, convertIntoScreenSpace, readVertexFull, clipTriangleWFast, clipLineWFast, signedTriangleArea, drawTriangle, applyDepthBias, drawLine, Scissor, inBounds, inBounds, inBoundsInt, ColorBlender |
| top-level / `eu/pb4/potato3d/blaze3d/SoftRenderPipeline.java` | `` |  | isClosed, close |
| top-level / `eu/pb4/potato3d/blaze3d/SoftSampler.java` | `` |  | getAddressModeU, getAddressModeV, getMinFilter, getMagFilter, getMaxAnisotropy, getMaxLod, isClosed, close |
| top-level / `eu/pb4/potato3d/blaze3d/SoftTexture.java` | `` |  | getRGBA, getRGBA, setRGBA, setRGBA, setDepth, getDepth, close, isClosed, clear, clear, clear, clear, clear, clear, clear, clear |
| top-level / `eu/pb4/potato3d/blaze3d/SoftTextureView.java` | `` |  | texture, close, isClosed |
| top-level / `eu/pb4/potato3d/blaze3d/SoftTransientMemory.java` | `` |  | allocateCpu, rotate, allocateStaging, allocateGpu, allocateGpuMapped, uploadStaging, uploadGpu, multiUploadStaging, multiUploadGpu |
| top-level / `eu/pb4/potato3d/blaze3d/Std140Reader.java` | `` |  | wrap, align, putFloat, putInt, getVec2, getVec2, getIVec2, getVec3, getVec3, getIVec3, getIVec3, getVec4, getVec4, getIVec4, getIVec4, getMat4f, reset |
| top-level / `eu/pb4/potato3d/blaze3d/texture/DepthTexture.java` | `` |  | get, set |
| top-level / `eu/pb4/potato3d/blaze3d/texture/RGBATexture.java` | `` |  | get, set, get, set |
| top-level / `eu/pb4/potato3d/blaze3d/texture/TextureLike.java` | `` |  |  |
| top-level / `eu/pb4/potato3d/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | ModifyExpressionValue:1 | t |
| top-level / `eu/pb4/potato3d/mixin/MouseHandlerMixin.java` | `value={MouseHandler.class})` | Inject:2 | replaceScalingX, replaceScalingY |
| top-level / `eu/pb4/potato3d/mixin/options/OptionsMixin.java` | `value={Options.class})` | ModifyArgs:1, Inject:2 | modifyOptions, modifyInitialOptions, modifyLoadedOptions |
| top-level / `eu/pb4/potato3d/mixin/options/VideoSettingsScreenMixin.java` | `value={VideoSettingsScreen.class})` | WrapWithCondition:1, ModifyReturnValue:3 | hideTheseOptions, hideBrokenDisplayOptions, hideBrokenQualityOptions, hideBrokenPreferenceOptions |
| top-level / `eu/pb4/potato3d/mixin/options/WindowMixin.java` | `value={Window.class})` | Inject:2 | modifyFramebufferSizePostRefresh, modifyNewFramebufferSize |
| top-level / `eu/pb4/potato3d/mixin/SplashManagerMixin.java` | `value={SplashManager.class})` | ModifyExpressionValue:1 | thereIsNoOpenGl |
| top-level / `eu/pb4/potato3d/Potato3D.java` | `` |  | updateRealResolutionAndScaleDown, remapMouseY, remapMouseX, onInitialize |
| top-level / `eu/pb4/potato3d/RGBA.java` | `` |  | alpha, red, green, blue, colorARGB, colorARGB, color, color, multiply, addRgb, subtractRgb, multiplyAlpha, colorRGBA, grey, alphaBlend, alphaBlendChannel, as8BitChannel, alphaFloat, redFloat, greenFloat, blueFloat, from8BitChannel, colorFromFloatRGBA, fromVector4f, toVector4f |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
