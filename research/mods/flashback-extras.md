# Flashback Extras

Review status: **Evidence inventory; behavioral review pending**

Project: [Flashback Extras](https://modrinth.com/mod/flashback-extras)
Selected artifact version: `1.3.0`
Published implementation source: https://github.com/sgerodes/flashback-extras
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Extra tools and quality-of-life improvements for the Flashback replay editor.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `11fefd83cb2ebcad1c2e6f5c9fc5501527c1e35fbf002353916687986d918c20a05b76c8fd603d018ab5f82bdf6f69d27b9a21b5eb049a00953dd4f5226bffc6`
- `sha1`: `647d25a0f3816f91385a6f13fec46afed2de1fe1`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 22
Reconstructed Java files: 17

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "io.serge.flashbackextras.FlashbackExtras"
  ],
  "modmenu": [
    "io.serge.flashbackextras.compat.ModMenuCompat"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3 <26.4",
  "java": ">=25",
  "fabric-api": ">=0.160.5+26.3",
  "flashback": ">=0.43.4"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/serge/flashbackextras/access/FlashbackExtrasEditorStateAccess.java` | `` |  |  |
| top-level / `io/serge/flashbackextras/audio/AudioTimelineContext.java` | `` |  | push, pop, getCurrentOrFetch, getAudioDurationInTicks, resolveKeyframeTick, Scope |
| top-level / `io/serge/flashbackextras/compat/ModMenuCompat.java` | `` |  | getModConfigScreenFactory |
| top-level / `io/serge/flashbackextras/config/FlashbackExtrasConfig.java` | `` |  | load, save, isTimelineHorizontalScrollEnabled, setTimelineHorizontalScrollEnabled, isExportPresetsEnabled, setExportPresetsEnabled, isExportCropGuideEnabled, setExportCropGuideEnabled, isAudioTimelineFixesEnabled, setAudioTimelineFixesEnabled, isExportWarmupEnabled, setExportWarmupEnabled, getCustomExportPresets, getAllExportPresets, saveExportPreset, deleteExportPreset |
| top-level / `io/serge/flashbackextras/export/ExportCapabilityWarmup.java` | `` |  | initialize, getStatus, onConfigChanged, tick, scheduleWarmup, reset, runWarmup, warmCapabilities, warmContainers, cancelScheduledWarmupLocked, newThread |
| top-level / `io/serge/flashbackextras/export/ExportPreset.java` | `` |  | builtIns, builtIn, from, applyTo, builtIn, name, displayName, bitrate, pngSequenceFormat |
| top-level / `io/serge/flashbackextras/FlashbackExtras.java` | `` |  | onInitializeClient |
| top-level / `io/serge/flashbackextras/mixin/AudioKeyframeMixin.java` | `value={AudioKeyframe.class}, remap=false)` | Overwrite:2 | ensureAudioBufferLoaded, flashbackExtras$getDurationInTicks, getCustomWidthInTicks, drawOnTimeline |
| top-level / `io/serge/flashbackextras/mixin/AudioKeyframeTypeMixin.java` | `value={AudioKeyframeType.class}, remap=false)` | Overwrite:1 | customKeyframeChange |
| top-level / `io/serge/flashbackextras/mixin/EditorStateMixin.java` | `value={EditorState.class}, remap=false)` | Invoker:1, Inject:2, Overwrite:1 | currentScene, flashbackExtras$getRealTimeMapping, flashbackExtras$pushRealtimeMapping, flashbackExtras$popRealtimeMapping, calculateRealtimeMappings |
| top-level / `io/serge/flashbackextras/mixin/KeyframeChangePlayAudioMixin.java` | `value={KeyframeChangePlayAudio.class}, remap=false)` | Overwrite:1 | apply |
| top-level / `io/serge/flashbackextras/mixin/ReplayUIMixin.java` | `value={ReplayUI.class}, remap=false)` | Inject:1 | flashbackExtras$drawExportCropGuide |
| top-level / `io/serge/flashbackextras/mixin/SoundManagerAccessor.java` | `value={SoundManager.class})` | Accessor:1 |  |
| top-level / `io/serge/flashbackextras/mixin/StartExportWindowMixin.java` | `value={StartExportWindow.class}, remap=false)` | Inject:1 | flashbackExtras$renderExportPresets, flashbackExtras$renderConfirmPopup, flashbackExtras$applyPreset, flashbackExtras$selectPresetByName |
| top-level / `io/serge/flashbackextras/mixin/TimelineWindowAudioMixin.java` | `value={TimelineWindow.class}, remap=false)` | Inject:2 | flashbackExtras$pushRealtimeMapping, flashbackExtras$popRealtimeMapping |
| top-level / `io/serge/flashbackextras/mixin/TimelineWindowMixin.java` | `value={TimelineWindow.class}, remap=false)` | Inject:1 | flashbackExtras$handleHorizontalScroll |
| top-level / `io/serge/flashbackextras/screen/FlashbackExtrasConfigScreen.java` | `` |  | init, addToggleRow, tabLabel, onClose, extractRenderState |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
