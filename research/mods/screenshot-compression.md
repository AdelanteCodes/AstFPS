# Screenshot Compression

Review status: **Evidence inventory; behavioral review pending**

Project: [Screenshot Compression](https://modrinth.com/mod/screenshot-compression)
Selected artifact version: `26.3.0-1.4-fabric+forge+neo`
Published implementation source: https://github.com/Serilum/Screenshot-Compression
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

📸 Automatically compress screenshots taken in-game to lower file size with various config options.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `eec8b442e1fc807f002cc1dee30c5d5431626be9`
- `sha512`: `8bd9b6163f248dc4e6d644bc2b0d94f305b67ddbcf4638eba2b9990588631c316c237656d62e98ecf19465ffb6f272539e67b8e9c88a085cd483c9bf2583419e`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 45
Reconstructed Java files: 38

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.serilum.screenshotcompression.ModFabric"
  ],
  "client": [
    "com.serilum.screenshotcompression.ModFabricClient"
  ],
  "modmenu": [
    "com.serilum.screenshotcompression.fabric.config.IntegrateModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.0",
  "fabric-api": "*",
  "minecraft": ">=26.3",
  "java": ">=25",
  "collective": ">=8.40"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/serilum/screenshotcompression/fabric/config/IntegrateModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/serilum/screenshotcompression/forge/config/IntegrateForgeConfig.java` | `` |  | registerScreen |
| top-level / `com/serilum/screenshotcompression/ModFabric.java` | `` |  | onInitialize, loadEvents, setGlobalConstants |
| top-level / `com/serilum/screenshotcompression/ModFabricClient.java` | `` |  | onInitializeClient, registerEvents |
| top-level / `com/serilum/screenshotcompression/ModForge.java` | `` |  | loadComplete, setGlobalConstants |
| top-level / `com/serilum/screenshotcompression/ModNeoForge.java` | `` |  | loadComplete, setGlobalConstants |
| top-level / `com/serilum/screenshotcompression/neoforge/config/IntegrateNeoForgeConfig.java` | `` |  | registerScreen, createScreen |
| top-level / `com/serilum/screenshotcompression/util/Placeholder.java` | `` |  |  |
| top-level / `com/serilum/screenshotcompression_common_fabric/compression/ImageCompressor.java` | `` |  | runScreenshotCompressThread, compressPNG, isValidImage |
| top-level / `com/serilum/screenshotcompression_common_fabric/compression/managers/DitheringManager.java` | `` |  | applyDithering, quantizeColor, getNewColorWithError |
| top-level / `com/serilum/screenshotcompression_common_fabric/compression/managers/ImageResizeManager.java` | `` |  | resize |
| top-level / `com/serilum/screenshotcompression_common_fabric/compression/managers/QuantizationManager.java` | `` |  | applyQuantization, extractColors, medianCutQuantization, medianCut, findLargestRange, applyQuantizedColors, findClosestColor, getColorDistance, RGBColor, RGBColorRange, split, getMedianColor, getRangeSize, findMaxDimension, getDimensionValue |
| top-level / `com/serilum/screenshotcompression_common_fabric/compression/managers/StripAlphaManager.java` | `` |  | stripAlphaChannel |
| top-level / `com/serilum/screenshotcompression_common_fabric/config/ConfigHandler.java` | `` |  | initConfig |
| top-level / `com/serilum/screenshotcompression_common_fabric/data/Constants.java` | `` |  |  |
| top-level / `com/serilum/screenshotcompression_common_fabric/mixin/NativeImageMixin.java` | `value={NativeImage.class}, priority=1001)` | Inject:1 | _onWriteToFile |
| top-level / `com/serilum/screenshotcompression_common_fabric/ModCommon.java` | `` |  | init, load |
| top-level / `com/serilum/screenshotcompression_common_fabric/util/Reference.java` | `` |  |  |
| top-level / `com/serilum/screenshotcompression_common_forge/compression/ImageCompressor.java` | `` |  | runScreenshotCompressThread, compressPNG, isValidImage |
| top-level / `com/serilum/screenshotcompression_common_forge/compression/managers/DitheringManager.java` | `` |  | applyDithering, quantizeColor, getNewColorWithError |
| top-level / `com/serilum/screenshotcompression_common_forge/compression/managers/ImageResizeManager.java` | `` |  | resize |
| top-level / `com/serilum/screenshotcompression_common_forge/compression/managers/QuantizationManager.java` | `` |  | applyQuantization, extractColors, medianCutQuantization, medianCut, findLargestRange, applyQuantizedColors, findClosestColor, getColorDistance, RGBColor, RGBColorRange, split, getMedianColor, getRangeSize, findMaxDimension, getDimensionValue |
| top-level / `com/serilum/screenshotcompression_common_forge/compression/managers/StripAlphaManager.java` | `` |  | stripAlphaChannel |
| top-level / `com/serilum/screenshotcompression_common_forge/config/ConfigHandler.java` | `` |  | initConfig |
| top-level / `com/serilum/screenshotcompression_common_forge/data/Constants.java` | `` |  |  |
| top-level / `com/serilum/screenshotcompression_common_forge/mixin/NativeImageMixin.java` | `value={NativeImage.class}, priority=1001)` | Inject:1 | _onWriteToFile |
| top-level / `com/serilum/screenshotcompression_common_forge/ModCommon.java` | `` |  | init, load |
| top-level / `com/serilum/screenshotcompression_common_forge/util/Reference.java` | `` |  |  |
| top-level / `com/serilum/screenshotcompression_common_neoforge/compression/ImageCompressor.java` | `` |  | runScreenshotCompressThread, compressPNG, isValidImage |
| top-level / `com/serilum/screenshotcompression_common_neoforge/compression/managers/DitheringManager.java` | `` |  | applyDithering, quantizeColor, getNewColorWithError |
| top-level / `com/serilum/screenshotcompression_common_neoforge/compression/managers/ImageResizeManager.java` | `` |  | resize |
| top-level / `com/serilum/screenshotcompression_common_neoforge/compression/managers/QuantizationManager.java` | `` |  | applyQuantization, extractColors, medianCutQuantization, medianCut, findLargestRange, applyQuantizedColors, findClosestColor, getColorDistance, RGBColor, RGBColorRange, split, getMedianColor, getRangeSize, findMaxDimension, getDimensionValue |
| top-level / `com/serilum/screenshotcompression_common_neoforge/compression/managers/StripAlphaManager.java` | `` |  | stripAlphaChannel |
| top-level / `com/serilum/screenshotcompression_common_neoforge/config/ConfigHandler.java` | `` |  | initConfig |
| top-level / `com/serilum/screenshotcompression_common_neoforge/data/Constants.java` | `` |  |  |
| top-level / `com/serilum/screenshotcompression_common_neoforge/mixin/NativeImageMixin.java` | `value={NativeImage.class}, priority=1001)` | Inject:1 | _onWriteToFile |
| top-level / `com/serilum/screenshotcompression_common_neoforge/ModCommon.java` | `` |  | init, load |
| top-level / `com/serilum/screenshotcompression_common_neoforge/util/Reference.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
