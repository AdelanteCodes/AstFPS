# Audio Engine Tweaks

Review status: **Evidence inventory; behavioral review pending**

Project: [Audio Engine Tweaks](https://modrinth.com/mod/audio-engine-tweaks)
Selected artifact version: `1.2.16`
Published implementation source: https://github.com/mattymatty97/audio_priority
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

this mod changes how Minecraft schedules sounds in order to prevent the sound pool to fill up

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `24dcd18dd0ac69aa7ad2a3217c30ab46f6c5b352`
- `sha512`: `3300d6229a5a2153c77188fe11a11cc91d2650b3b5228dfcfd4c7089e6859bd617862e82e0019d930f30f566f997b922711701b3cba8ca5753fc0dd42581dfc8`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 26
Reconstructed Java files: 16

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.mattymatty.audio_priority.client.AudioPriority"
  ],
  "modmenu": [
    "com.mattymatty.audio_priority.client.AudioPriorityModMenu"
  ]
}
```

**depends**

```json
{
  "minecraft": [
    "26.3"
  ],
  "fabricloader": [
    ">=0.19.3"
  ]
}
```

**accessWidener**

```json
"audio_priority.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/mattymatty/audio_priority/client/AudioPriority.java` | `` |  | onInitializeClient |
| top-level / `com/mattymatty/audio_priority/client/AudioPriorityModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/mattymatty/audio_priority/Configs.java` | `` |  | getInstance, saveConfig, loadConfig |
| top-level / `com/mattymatty/audio_priority/exceptions/SoundPoolException.java` | `` |  |  |
| top-level / `com/mattymatty/audio_priority/interfaces/SoundSystemAdditions.java` | `` |  |  |
| top-level / `com/mattymatty/audio_priority/mixins/accessors/SoundEngineAccessor.java` | `value={Library.class})` | Accessor:2 |  |
| top-level / `com/mattymatty/audio_priority/mixins/accessors/SoundManagerAccessor.java` | `value={SoundManager.class})` | Accessor:1 |  |
| top-level / `com/mattymatty/audio_priority/mixins/SoundEngineMixin.java` | `value={SoundEngine.class})` | WrapOperation:1, ModifyArg:1, Inject:4, WrapMethod:1 | sound_comparator, getSoundList, audio_priority$refreshSpecificVolume, should_play |
| top-level / `com/mattymatty/audio_priority/mixins/SoundOptionsScreenMixin.java` | `value={SoundOptionsScreen.class})` |  | addFooter |
| top-level / `com/mattymatty/audio_priority/screen/CategoryConfigScreen.java` | `` |  | init, repositionElements, onClose, removed |
| top-level / `com/mattymatty/audio_priority/screen/ConfigScreen.java` | `` |  | init, repositionElements, onClose, removed |
| top-level / `com/mattymatty/audio_priority/screen/InstantConfigScreen.java` | `` |  | init, repositionElements, onClose, removed |
| top-level / `com/mattymatty/audio_priority/screen/SoundListConfigScreen.java` | `` |  | init, repositionElements, onClose, removed |
| top-level / `com/mattymatty/audio_priority/screen/SoundListWidget.java` | `` |  | scrollBarX, getRowWidth, showSearch, addSubEntry, shouldShow, extractContent, updateNarration, OnValueChanged, OnResetValue, drawName, extractContent, shouldShow, getRuleName, getStatus, compareTo, setVolume, updateMessage, applyValue, sliderToVolume, volumeToSlider, dbToVolume, volumeToDb |
| top-level / `com/mattymatty/audio_priority/screen/ThresholdConfigScreen.java` | `` |  | init, repositionElements, onClose, removed, updateMessage, applyValue, updateMessage, applyValue |
| top-level / `com/mattymatty/audio_priority/widget/ClickableListWidget.java` | `` |  | addEntry, addEntry, scrollBarX, getRowWidth, extractContent, getWidget, getDx, getDy |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
