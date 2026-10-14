# Sound Culling

Review status: **Evidence inventory; behavioral review pending**

Project: [Sound Culling](https://modrinth.com/mod/sound-culling)
Selected artifact version: `2.1.0`
Published implementation source: https://github.com/Cukkoo12/SoundCulling
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Dynamically limits and dampens overlapping sounds to reduce audio clutter and improve performance in sound-heavy areas.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `ac01bd511663ab69f344601282655b9b5087fb49`
- `sha512`: `f905f73b7abaf302192f17c72c69db348cfab6bf9f2502585b0f7db31f1a26e3504ffe5435df7bcc42c3af3252f2f0d7c49ec4bd8c0639f52f8dfff07ba2a28a`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 25
Reconstructed Java files: 10

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.cukkoo.soundculling.SoundCulling"
  ],
  "modmenu": [
    "com.cukkoo.soundculling.integration.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": ">=0.160.5",
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/cukkoo/soundculling/command/SoundCullingCommands.java` | `` |  | register, status, toggle, preset, limit, reset, feedback |
| top-level / `com/cukkoo/soundculling/config/SoundCullingConfig.java` | `` |  | defaultRules, load, migrateFromLegacy, save, validateAndClamp, copy, applyPreset, copyRules, addOrReplaceRule, normalizeAction, copy |
| top-level / `com/cukkoo/soundculling/DampenableSoundInstance.java` | `` |  |  |
| top-level / `com/cukkoo/soundculling/integration/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/cukkoo/soundculling/integration/SoundCullingConfigScreen.java` | `` |  | tr, actionLabel, isPauseScreen, init, tick, refreshUI, hideVanillaButtonSkins, addTab, buildOverview, buildPerformance, buildLive, actionButton, buildAdvanced, addToggle, addNumRow, addRule, removeRule, presetTooltip, cyclePreset, applyLocalPreset, markCustom, prettyPreset, extractRenderState, renderModernControls, drawNumberControls, drawToggleSkin, drawSelectorSkin, drawLiveSoundRow, trimToPixelWidth, drawModernButton, isInside, renderOverview, renderPerformance, renderLive, renderAdvanced, drawStatCard, renderValue, extractBackground, applyAndSave, onClose, layout, trim, Layout |
| top-level / `com/cukkoo/soundculling/mixin/AbstractSoundInstanceMixin.java` | `value={AbstractSoundInstance.class})` | Inject:1 | soundculling$setVolumeMultiplier, soundculling$getVolumeMultiplier, soundculling$modifyVolume |
| top-level / `com/cukkoo/soundculling/mixin/SoundEngineMixin.java` | `value={SoundEngine.class})` | Inject:2 | calculateVolume, soundculling$onPlay, soundculling$updateActiveLoops |
| top-level / `com/cukkoo/soundculling/SoundCulling.java` | `` |  | onInitializeClient, getConfig, setConfig |
| top-level / `com/cukkoo/soundculling/SoundCullingTracker.java` | `` |  | onTick, getCategoryLimit, getVolumeMultiplier, getVolumeMultiplier, getRuntimeLoopMultiplier, evaluateVolumeMultiplier, calculateAdaptivePressure, calculatePriority, calculatePlayerRelation, countNearby, floorCell, packCell, scheduleCleanupIfNeeded, processExpirations, recordDecision, reportEngineFailure, getRecentSounds, getTotalTriggered, getTotalPlayed, getTotalCulled, getTotalDampened, getEventsPerSecond, getAdaptivePressure, getTrackedRegionCount, resetStats, resetRuntime, clamp, lerp, PlayerRelation, NearbyCounts, RegionExpiry, RecentSoundSnapshot, affected |
| top-level / `com/cukkoo/soundculling/SoundRuleEngine.java` | `` |  | resolve, fromAction, matches, namespacePattern, RuleResult |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
