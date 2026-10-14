# Sound Controller

Review status: **Evidence inventory; behavioral review pending**

Project: [Sound Controller](https://modrinth.com/mod/sound-controller)
Selected artifact version: `1.4.1-mc26.3`
Published implementation source: https://github.com/BVengo/sound-controller
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Have complete control over the volume of every sound in the game, with both global and region-based audio controls.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `2ba3dc78e0161e09274c37d85f49f29d39cfbe2d`
- `sha512`: `e70b81e68785ca4bbf66e6a212c9aedce2990496260e96429980625e3c7325126738b960da61b1606faf11e65f1b18479f254ccaadcff50954c5a0f87577fab6`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 43
Reconstructed Java files: 40

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.bvengo.soundcontroller.FabricSoundController"
  ],
  "modmenu": [
    "com.bvengo.soundcontroller.config.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "minecraft": ">=26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/bvengo/soundcontroller/config/ConfigParser.java` | `` |  | setConfigDir, getConfigDir, getFile, loadConfig, saveConfig, createJsonConfig, saveToJsonFile, parseConfig, moveOldConfig, buildEmptyConfig, addVolumeData, parseConfig4, parseConfigUnversioned |
| top-level / `com/bvengo/soundcontroller/config/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/bvengo/soundcontroller/config/PresetConfig.java` | `` |  | getInstance, getPresets, addPreset, removePreset, save |
| top-level / `com/bvengo/soundcontroller/config/PresetConfigParser.java` | `` |  | getFile, loadConfig, parsePreset, saveConfig, serializePreset |
| top-level / `com/bvengo/soundcontroller/config/PresetData.java` | `` |  | getName, setName, getSounds |
| top-level / `com/bvengo/soundcontroller/config/RegionConfig.java` | `` |  | getInstance, getRegions, addRegion, removeRegion, getActiveRegions, getVolumeForSound, save, loadServer |
| top-level / `com/bvengo/soundcontroller/config/RegionConfigParser.java` | `` |  | getFile, loadConfig, parseRegionsForServer, parseRegion, parseGeometry, saveConfig, readExistingRoot, serializeRegion, serializeGeometry |
| top-level / `com/bvengo/soundcontroller/config/VolumeConfig.java` | `` |  | getInstance, save, updateVolumes, getVolumes, getVolumeData, getAdjustedVolume, shouldSkipStarting, shouldStartSilently, getRegionVolume, areSubtitlesEnabled, toggleSubtitles |
| top-level / `com/bvengo/soundcontroller/FabricSoundController.java` | `` |  | onInitializeClient |
| top-level / `com/bvengo/soundcontroller/gui/AllSoundOptionsScreen.java` | `` |  | init, repositionElements, updateFooterButtons, resize, onClose, removed |
| top-level / `com/bvengo/soundcontroller/gui/buttons/AudioButtonWidget.java` | `` |  | playDownSound |
| top-level / `com/bvengo/soundcontroller/gui/buttons/HoverableButtonWidget.java` | `` |  | getTextureIdentifier, extractContents |
| top-level / `com/bvengo/soundcontroller/gui/buttons/ToggleButtonWidget.java` | `` |  | onPress |
| top-level / `com/bvengo/soundcontroller/gui/buttons/TriggerButtonWidget.java` | `` |  | onPress, onRelease |
| top-level / `com/bvengo/soundcontroller/gui/components/VolumeListWidget.java` | `` |  | addWidgetEntry, getRowWidth, scrollBarX, clearEntries |
| top-level / `com/bvengo/soundcontroller/gui/components/VolumeWidgetEntry.java` | `` |  | setPanelBounds, getPercentageValue, getVolumeFromSlider, addSlider, addPlayButton, addResetButton, init, extractContent, children, narratables |
| top-level / `com/bvengo/soundcontroller/gui/GlobalSoundTab.java` | `` |  | getTabTitle, getTabExtraNarration, visitChildren, doLayout, getLayout, getSearchField, getSearchValue, setSearchValue, loadOptions |
| top-level / `com/bvengo/soundcontroller/gui/presets/PresetEditScreen.java` | `` |  | init, repositionElements, resize, savePreset, onClose, loadSoundOptions |
| top-level / `com/bvengo/soundcontroller/gui/presets/PresetListEntry.java` | `` |  | openEditScreen, confirmDelete, extractContent, children, narratables |
| top-level / `com/bvengo/soundcontroller/gui/presets/PresetListWidget.java` | `` |  | getRowWidth, scrollBarX, clearEntries, addWidgetEntry |
| top-level / `com/bvengo/soundcontroller/gui/presets/PresetPickerScreen.java` | `` |  | init, repositionElements, loadPresets, applyPreset, onClose, closeToParent, getRowWidth, scrollBarX, clearEntries, addWidgetEntry, extractContent, children, narratables |
| top-level / `com/bvengo/soundcontroller/gui/presets/PresetsTab.java` | `` |  | getTabTitle, getTabExtraNarration, visitChildren, doLayout, getLayout, loadPresets |
| top-level / `com/bvengo/soundcontroller/gui/regions/RegionEditScreen.java` | `` |  | init, repositionElements, resize, validateAndSave, onClose |
| top-level / `com/bvengo/soundcontroller/gui/regions/RegionGeneralTab.java` | `` |  | getTabTitle, getTabExtraNarration, visitChildren, doLayout, getLayout, getCurrentName, extractEnabled, extractName, extractGeometry, updateGeometryVisibility, fillPosition, updatePositionButtonState, setPositionButtonState, parseCoord, coordField |
| top-level / `com/bvengo/soundcontroller/gui/regions/RegionListEntry.java` | `` |  | openEditScreen, confirmDelete, extractContent, children, narratables |
| top-level / `com/bvengo/soundcontroller/gui/regions/RegionListWidget.java` | `` |  | getRowWidth, scrollBarX, clearEntries, addWidgetEntry |
| top-level / `com/bvengo/soundcontroller/gui/regions/RegionSoundsTab.java` | `` |  | getTabTitle, getTabExtraNarration, visitChildren, doLayout, getLayout, getSearchValue, setSearchValue, getSoundOverrides, loadSoundOptions |
| top-level / `com/bvengo/soundcontroller/gui/regions/RegionsTab.java` | `` |  | getTabTitle, getTabExtraNarration, visitChildren, doLayout, getLayout, openAddScreen, loadRegions |
| top-level / `com/bvengo/soundcontroller/mixin/OptionsSubScreenMixin.java` | `value={OptionsSubScreen.class})` | WrapMethod:1 | replaceDoneButton, soundcontroller$addLayoutButton |
| top-level / `com/bvengo/soundcontroller/mixin/SoundEngineMixin.java` | `value={SoundEngine.class})` | Inject:1, WrapOperation:2, WrapMethod:1 | skipMutedSounds, adjustInitialVolume, allowRegionMutedMovingSoundToStart, adjustUpdatedVolume |
| top-level / `com/bvengo/soundcontroller/mixin/SubtitleOverlayMixin.java` | `value={SubtitleOverlay.class})` | WrapOperation:3 | replaceSubtitleText, modifyFirstShowSubtitlesCheck, modifySecondShowSubtitlesCheck |
| top-level / `com/bvengo/soundcontroller/region/BoxGeometry.java` | `` |  | contains, getDescription |
| top-level / `com/bvengo/soundcontroller/region/RegionData.java` | `` |  | getName, setName, getServerKey, getWorldKey, getGeometry, setGeometry, isEnabled, setEnabled, getSoundOverrides, setSoundOverrides, hasSoundOverride, getVolumeForSound, canApplyTo, contains, isActive |
| top-level / `com/bvengo/soundcontroller/region/RegionGeometry.java` | `` |  |  |
| top-level / `com/bvengo/soundcontroller/region/SphereGeometry.java` | `` |  | contains, getDescription |
| top-level / `com/bvengo/soundcontroller/SoundController.java` | `` |  | bootstrap, onClientStarted, getConfig, getRegionConfig, getCurrentServerKey, getCurrentWorldKey |
| top-level / `com/bvengo/soundcontroller/SoundReloadListener.java` | `` |  | onResourceManagerReload |
| top-level / `com/bvengo/soundcontroller/Translations.java` | `` |  | translatableOf, getTranslationKey |
| top-level / `com/bvengo/soundcontroller/Utils.java` | `` |  | updateExistingSounds |
| top-level / `com/bvengo/soundcontroller/VolumeData.java` | `` |  | getId, getVolume, setVolume, isModified, inFilter, playSound, toggleSound, isActive |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
