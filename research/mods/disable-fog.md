# Disable Fog

Review status: **Evidence inventory; behavioral review pending**

Project: [Disable Fog](https://modrinth.com/mod/disable-fog)
Selected artifact version: `2.2.1`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Allows you to selectively disable different types of fog.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `f9c1452bf4929031e2e060248cbe6d20778a75c9d0bf06382ef74c08978eae95139ac78e500f84f0a00fcc442229e53c9616b12a48471f19ab71abd6db5b4f14`
- `sha1`: `34eae804d5107ae5d603dbf4a218adc1696abb15`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 39
Reconstructed Java files: 31

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.sergo467.disablefog.fabric.FabricDisableFogMod"
  ],
  "modmenu": [
    "com.sergo467.disablefog.fabric.integration.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": "*",
  "minecraft": ">=26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/sergo467/disablefog/config/ConfigManager.java` | `` |  | load, save, get |
| top-level / `com/sergo467/disablefog/config/ConfigSerializer.java` | `` |  |  |
| top-level / `com/sergo467/disablefog/config/DimensionConfig.java` | `` |  |  |
| top-level / `com/sergo467/disablefog/config/EarlyConfig.java` | `` |  | getFile, readEnableIrisMixins, write |
| top-level / `com/sergo467/disablefog/config/FogSettings.java` | `` |  | createGlobal, createDimension |
| top-level / `com/sergo467/disablefog/config/FogState.java` | `` |  |  |
| top-level / `com/sergo467/disablefog/config/FogStateAccessor.java` | `` |  |  |
| top-level / `com/sergo467/disablefog/config/IrisUniformPatches.java` | `` |  |  |
| top-level / `com/sergo467/disablefog/config/JsonConfigSerializer.java` | `` |  | save, load, toJson, fromJson, write, read, write, read |
| top-level / `com/sergo467/disablefog/config/ModConfig.java` | `` |  | resolve, shouldDisableFog, shouldPatchIrisUniform |
| top-level / `com/sergo467/disablefog/DisableFogMod.java` | `` |  | init |
| top-level / `com/sergo467/disablefog/fabric/FabricDisableFogMod.java` | `` |  | onInitializeClient |
| top-level / `com/sergo467/disablefog/fabric/integration/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/sergo467/disablefog/fabric/services/FabricClientEvents.java` | `` |  | registerEndClientTick |
| top-level / `com/sergo467/disablefog/fabric/services/FabricRegistries.java` | `` |  | registerKeyMapping |
| top-level / `com/sergo467/disablefog/fabric/services/FabricRuntimeInformation.java` | `` |  | isModInLoadingList, getConfigDir |
| top-level / `com/sergo467/disablefog/gui/components/ArrowHeaderWidget.java` | `` |  | buildText, setExpanded, visitLines, updateWidgetNarration |
| top-level / `com/sergo467/disablefog/gui/components/CustomOptionsList.java` | `` |  | clearEntries, addSection, addRow, addRootRow, createRow, getRowWidth, rowLeft, rowRight, labelWidth, clampedLabelWidth, updateSize, addChild, toggle, isExpanded, setVisible, isVisible, getHeight, extractContent, mouseClicked, children, narratables, keyPressed, addChild, setVisible, isVisible, getHeight, extractContent, mouseClicked, children, narratables |
| top-level / `com/sergo467/disablefog/gui/screens/ConfigurationScreen.java` | `` |  | addContents, addFooter, addOptions, onClose, repositionElements, rebuild, captureState, buildRoot, buildIris, buildGlobal, buildDimensions, createLabelComponent, createTooltipComponent, createCycleButton, createResetButton, addRootRow, addRow, addIrisUniformsRows, addFogSettingsRows, updateResetAllButton, isIrisUniformsDefault, isAllDefault, getDimensions, saving, onConfigChanged, values, valueStringifier |
| top-level / `com/sergo467/disablefog/KeybindManager.java` | `` |  | init, tick |
| top-level / `com/sergo467/disablefog/mixin/CameraMixin.java` | `value={Camera.class})` | Inject:1 | fixMobEffectBlockSky |
| top-level / `com/sergo467/disablefog/mixin/compat/iris/ReplaceIrisPreRenderSky.java` | `value={LevelRenderer.class})` |  |  |
| top-level / `com/sergo467/disablefog/mixin/DisableFogMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `com/sergo467/disablefog/mixin/FogRendererMixin.java` | `value={FogRenderer.class})` | Redirect:4, ModifyVariable:1 | overrideFogType, overrideColorApplicability, overrideShouldApply, overrideFogDataConstructor, disableTerrainFog |
| top-level / `com/sergo467/disablefog/mixin/iris/CommonUniformsMixin.java` | `targets={"net.irisshaders.iris.uniforms.CommonUniforms"}, remap=false)` | Inject:3 | getCurrentDimension, disableFogBlindness, disableFogDarkness, onIsEyeInWater |
| top-level / `com/sergo467/disablefog/mixin/SkyRendererMixin.java` | `value={SkyRenderer.class})` | Inject:1 | disableDarkDisc |
| top-level / `com/sergo467/disablefog/services/PlatformClientEvents.java` | `` |  | getInstance |
| top-level / `com/sergo467/disablefog/services/PlatformRegistries.java` | `` |  | getInstance |
| top-level / `com/sergo467/disablefog/services/PlatformRuntimeInformation.java` | `` |  | getInstance |
| top-level / `com/sergo467/disablefog/services/Services.java` | `` |  | load |
| top-level / `com/sergo467/disablefog/utils/ModDetection.java` | `` |  | detectMod |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
