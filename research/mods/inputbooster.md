# inputbooster

Review status: **Evidence inventory; behavioral review pending**

Project: [inputbooster](https://modrinth.com/mod/inputbooster)
Selected artifact version: `4.0.0-fabric-mc263`
Published implementation source: https://github.com/Ahaduzzamankhan/inputbooster
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

InputBooster – Ultra-fast input polling for Minecraft PvP, capturing missed clicks, maintaining sprint, and improving combat responsiveness, even at low FPS. Compatible with Fabric and performance mods like Sodium & Lithium.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `a3765c2d92ff1b92bde119bfa6311b332b4d365b`
- `sha512`: `4653637f099b076ea390424d4b8f9eeb01873a513fa7a24b6fe3d6f6c66836ea4143e7fb7b6d6fa81770913837e70d55ab3fb1d1e3fb2a98d69cd48821d908f5`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 60
Reconstructed Java files: 50

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "dev.inputbooster.platform.InputBoosterFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.0",
  "fabric-api": ">=0.161.0",
  "minecraft": ">=26.3 <26.4",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/inputbooster/access/MixinAccess.java` | `` |  | boundKeyCode, renderState, pickBlockOrEntity |
| top-level / `dev/inputbooster/ComboKeyPresets.java` | `` |  | press, reset, size |
| top-level / `dev/inputbooster/compat/McVersion.java` | `` |  | isKeyDown, isKeyDown, swingArm, dropHeldItem |
| top-level / `dev/inputbooster/feature/AntiIdleManager.java` | `` |  | tick |
| top-level / `dev/inputbooster/feature/AutoStrafeManager.java` | `` |  | tick |
| top-level / `dev/inputbooster/feature/BurstModeManager.java` | `` |  | tick, isBursting, getBurstTicksLeft |
| top-level / `dev/inputbooster/feature/ConfigTools.java` | `` |  | applyPreset, exportConfig, importConfig |
| top-level / `dev/inputbooster/feature/CpsLimiter.java` | `` |  | allowClick, refill, availableTokens, recordClick, getCps, getMaxCps, tick, reset, effectiveMaxCps, rollWindow, pruneAccepted |
| top-level / `dev/inputbooster/feature/DebugOverlayManager.java` | `` |  | extractRenderState, register, getDebugLines, isInitialized |
| top-level / `dev/inputbooster/feature/EventLog.java` | `` |  | add, snapshot, latest, size, clear |
| top-level / `dev/inputbooster/feature/InputClickSoundManager.java` | `` |  | playFor, isPressedAction |
| top-level / `dev/inputbooster/feature/KeybindConflictDetector.java` | `` |  | tick, readField, callString |
| top-level / `dev/inputbooster/feature/LatencyProfiler.java` | `` |  | recordDrain, getAverageMs, getPeakMs, resetPeak, reset, formatForOverlay |
| top-level / `dev/inputbooster/feature/ModuleManager.java` | `` |  | enabled, setRuntime, statusLine |
| top-level / `dev/inputbooster/feature/OverlayLayout.java` | `` |  | clampOpacity, clampScale, withOpacity, backgroundColor, originX, originY, isRight, isBottom, cpsBarColor, positionName |
| top-level / `dev/inputbooster/feature/PerServerProfileManager.java` | `` |  | load, bind, tick, normalize, persist, detectServerId, reportReflectionFailure, call, callBoolean, findMethod, read |
| top-level / `dev/inputbooster/feature/ProfileManager.java` | `` |  | getProfiles, getActiveIndex, getCount, saveProfile, loadProfile, deleteProfile, load, quarantineCorruptFile, persist, Profile, capture, apply, optString, optInt, optBool |
| top-level / `dev/inputbooster/feature/ReplayRecorder.java` | `` |  | startRecording, stopRecording, toggleRecording, startPlayback, onQueued, tick, stopPlayback, getDroppedEvents, getTruncatedEvents, isRecording, isPlaying, getRecordedCount, statusLine, Frame |
| top-level / `dev/inputbooster/feature/SafeModeManager.java` | `` |  | recordError, disableModule, tick, isKnownModule, isModuleDisabled, isSafeModeActive, statusLine, reset |
| top-level / `dev/inputbooster/feature/SessionStats.java` | `` |  | tick, getSessionStartTime, getSessionUptimeSeconds, getUptimeFormatted, getTotalRecovered, getEstimatedMissedInputs, getCpsHistory, isPollingThreadAlive |
| top-level / `dev/inputbooster/feature/SprintManager.java` | `` |  | tick |
| top-level / `dev/inputbooster/feature/WTapAssist.java` | `` |  | tick, onWRelease |
| top-level / `dev/inputbooster/input/KeyBindingSet.java` | `` |  | code, matches, of, of, map, defaultCodes |
| top-level / `dev/inputbooster/input/RawKeyState.java` | `` |  | of, isAvailable, isDown, window |
| top-level / `dev/inputbooster/InputAction.java` | `` |  | Stamped, of, of, isReplay |
| top-level / `dev/inputbooster/InputActionQueue.java` | `` |  | queue, queue, pendingPhysical, poll, isEmpty, clear, capacity, size |
| top-level / `dev/inputbooster/InputBoosterConfig.java` | `` |  | configDir, load, save, migrate, rename, warnAboutDefaults, checkBool, checkInt, parseFloat, parseInt, parseBool, resetDefaults, getPollRateHz, isPollRateAutoMode, isSprintFixEnabled, isAutoSprintEnabled, isWTapAssistEnabled, isAntiIdleEnabled, isAutoStrafeEnabled, isCpsLimiterEnabled, isBurstModeEnabled, getMaxCps, isComboKeysEnabled, getCpsMode, isReplayEnabled, isSafeModeEnabled, isEventLogEnabled, isKeyConflictWarn, isPerServerProfiles, isClickSoundsEnabled, getClickSoundPitch, getClickSoundVolume, getConfigVersion, isShowF3Info, isShowKeystrokes, getOverlayPosition, getOverlayOpacity, getOverlayScale, isShowActionBar, getFpsCheckInterval, isDebugMode, setPollRateHz, setPollRateAutoMode, setSprintFixEnabled, setAutoSprintEnabled, setWTapAssistEnabled, setAntiIdleEnabled, setAutoStrafeEnabled, setCpsLimiterEnabled, setBurstModeEnabled, setMaxCps, setComboKeysEnabled, setCpsMode, setReplayEnabled, setSafeModeEnabled, setEventLogEnabled, setKeyConflictWarn, setPerServerProfiles, setClickSoundsEnabled, setClickSoundPitch, setClickSoundVolume, setShowF3Info, setShowKeystrokes, setOverlayPosition, setOverlayOpacity, setOverlayScale, setShowActionBar, setFpsCheckInterval, setDebugMode, isCpuOptimizationEnabled, isMemoryOptimizationEnabled, isGpuOptimizationEnabled, isDiskOptimizationEnabled, isChunkOptimizationEnabled, isInputOptimizationEnabled, isAdaptiveOptimizationEnabled, getAdaptiveIntervalTicks, getWriteDebounceMs, setCpuOptimizationEnabled, setMemoryOptimizationEnabled, setGpuOptimizationEnabled, setDiskOptimizationEnabled, setChunkOptimizationEnabled, setInputOptimizationEnabled, setAdaptiveOptimizationEnabled, setAdaptiveIntervalTicks, setWriteDebounceMs, fromHz |
| top-level / `dev/inputbooster/InputBoosterMod.java` | `` |  | createKeyMappings, bootstrap, initialize, onClientTick, handleKeybinds, handleComboKeys, resetComboKeyState, adjustPollRateAuto, adjustPollRateManual, calculateAutoHz, debugMode, currentServerKey, shutdown, publishKeyBindings, slotCode, vanillaDefaults, mouseCode, verifyClientHooks |
| top-level / `dev/inputbooster/InputDrainer.java` | `` |  | beginTick, markAttackHandled, markUseHandled, consumeAttackSuppression, consumeUseSuppression, currentTickId, drainAll, apply |
| top-level / `dev/inputbooster/InputPollingThread.java` | `` |  | setPollRateHz, clampHz, run, shouldPollFast, idleRate, idleCycles, poll, sample, queue, resetPreviousStates, stopPolling, stopPollingAndAwait |
| top-level / `dev/inputbooster/integration/SodiumOptionsBridge.java` | `` |  | register, doRegister, addPage, openSettingsScreen, call, method, invoke |
| top-level / `dev/inputbooster/KeySnapshot.java` | `` |  | fromRaw, matches |
| top-level / `dev/inputbooster/McCompat.java` | `` |  | getFps, isInWater, isClimbing, getFoodLevel, setSneaking |
| top-level / `dev/inputbooster/mixin/GameTickMixin.java` | `value={Minecraft.class})` | Inject:4 | onTickHead, onStartAttack, onStartUseItem, onClose |
| top-level / `dev/inputbooster/mixin/GuiAccessor.java` | `value={Gui.class})` | Accessor:1 |  |
| top-level / `dev/inputbooster/mixin/InGameHudMixin.java` | `value={Gui.class}, priority=900)` | Inject:1 | onExtractRenderStateTail |
| top-level / `dev/inputbooster/mixin/KeyMappingAccessor.java` | `value={KeyMapping.class})` | Accessor:1 |  |
| top-level / `dev/inputbooster/mixin/MinecraftClientAccessor.java` | `value={Minecraft.class})` | Invoker:1 |  |
| top-level / `dev/inputbooster/mixin/OptionsScreenMixin.java` | `value={OptionsScreen.class})` | Inject:1 | addInputBoosterEntry |
| top-level / `dev/inputbooster/perf/AdaptiveEngine.java` | `` |  | shouldRunModules, setIdling, isIdling, evaluations, skippedTicks |
| top-level / `dev/inputbooster/perf/ChunkOptimizer.java` | `` |  | name, enabled, tick, chunksTouched, isDelegated, ticksObserved |
| top-level / `dev/inputbooster/perf/CpuOptimizer.java` | `` |  | name, enabled, tick, observeServer, ticksObserved, serverIdentityChecks |
| top-level / `dev/inputbooster/perf/DiskOptimizer.java` | `` |  | name, enabled, start, stop, requestFlush, startWorker, drain, flushBlocking, writeCount, requestCount, isDirty |
| top-level / `dev/inputbooster/perf/GpuOptimizer.java` | `` |  | name, enabled, tick, engineDrawCalls, hasAlternateRenderer, ticksObserved |
| top-level / `dev/inputbooster/perf/InputOptimizer.java` | `` |  | name, enabled, tick, engineInputEvents, idlePollCycles, ticksObserved |
| top-level / `dev/inputbooster/perf/MemoryOptimizer.java` | `` |  | name, enabled, tick, ticksObserved, rebuildsAvoided |
| top-level / `dev/inputbooster/perf/OptimizationManager.java` | `` |  | get, start, tick, hasWork, onSettingsChanged, shutdown, ticks, cpu, memory, gpu, disk, chunk, input, adaptive, modules, setServerKeySource, reset |
| top-level / `dev/inputbooster/perf/Optimizer.java` | `` |  |  |
| top-level / `dev/inputbooster/platform/InputBoosterFabric.java` | `` |  | onInitializeClient |
| top-level / `dev/inputbooster/screen/InputBoosterScreen.java` | `` |  | addOptions, addPollingSection, addMovementSection, addClickSection, addOverlaySection, addDiagnosticsSection, addPerformanceSection, markSettingsChanged, addStatsSection, addProfilesSection, tick, refreshStats, statsLines, removed, section, big, small, checkbox, cycle, slider, slider, presetButton, updateManualPollAvailability, applyManualPollRate, round, cpsModeIndex, findOptionsGrid, addToOptionsGrid, anchorEntryToContentBottom, updateMessage, applyValue, clampToStep, toFraction, extractWidgetRenderState, updateWidgetNarration |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
