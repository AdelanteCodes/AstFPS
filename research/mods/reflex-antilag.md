# Reflex AntiLag

Review status: **Evidence inventory; behavioral review pending**

Project: [Reflex AntiLag](https://modrinth.com/mod/reflex-antilag)
Selected artifact version: `1.1.2+fabric-26.3`
Published implementation source: https://github.com/Tythee/Minecraft-Reflex
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Eliminates render queue latency using NVIDIA Reflex architecture. Works on ANY GPU!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `1b695789549e884a44d424a4f60b47f13df8a7a54a3672b30486a7dc46eb0f2d1738bd152c6c02430482c681b053de824c5c3ffc0303d4e2e06a3410ddc4559f`
- `sha1`: `e978a923c64c2e51c2267c5a4d17bd744d453dbd`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 15
Reconstructed Java files: 12

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "io.tythee.fabric.ReflexClientFabric"
  ],
  "modmenu": [
    "io.tythee.fabric.config.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": "*",
  "minecraft": ">=26.3",
  "java": ">=21",
  "fabric-api": "*",
  "cloth-config": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/tythee/config/ConfigScreen.java` | `` |  | create |
| top-level / `io/tythee/config/ModConfig.java` | `` |  | currentMtime, reloadIfChanged, isReflexEnabled, setReflexEnabled, isTimelineDiagram, setTimelineDiagram, isShowLatencyMetrics, setShowLatencyMetrics, isEnableDiagnosticLogging, setEnableDiagnosticLogging, getManualSleepOffsetMs, setManualSleepOffsetMs, getManualSleepOffsetNs, setManualSleepOffsetNs, load, toLogString, toShortLogString, isDevEnvironment, save |
| top-level / `io/tythee/CpuTimeCollector.java` | `` |  | startCollect, endCollect, getCpuTime, reset |
| top-level / `io/tythee/fabric/config/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `io/tythee/fabric/ReflexClientFabric.java` | `` |  | onInitializeClient |
| top-level / `io/tythee/GpuTimeCollector.java` | `` |  | ensureInitialized, getGpuToSystemOffset26, startQueryInsert, endQueryInsert, checkQuery, reset |
| top-level / `io/tythee/mixin/DebugOverlayMixin.java` | `value={DebugScreenOverlay.class})` | Inject:1 | onExtractLines |
| top-level / `io/tythee/mixin/MinecraftClientMixin.java` | `value={Minecraft.class})` | Inject:8 | onFrameStart, afterInputPoll, onSimulationStart, onSimulationEnd, beforeRenderSubmit, afterRenderSubmit, beforePresent, afterPresent |
| top-level / `io/tythee/ObjectPool.java` | `` |  | borrow, returnObject |
| top-level / `io/tythee/ReflexClient.java` | `` |  | init, getScheduler |
| top-level / `io/tythee/ReflexMetrics.java` | `` |  | getInstance, recordFrame, getMetricsLines, pos, alignErrText, markedTrack, timelineBar, timelineRow, timelineRow2, repeatChar, getMetricsString |
| top-level / `io/tythee/ReflexScheduler.java` | `` |  | updateCpuTime, updateSimTime, updateSubmissionTime, updateGpuTime, getEstimateGpuTime, getManualOffsetNs, ms, msSigned, frameBufferSize, getInternalsString, checkCompletedQueries, startFrame, afterInputPoll, beforeSimulation, afterSimulation, beforeRenderSubmit, afterRenderSubmit, beforePresent, endFrame, processCompletedFrame, markSleepDebugDisabled, recordSleepDebug, calculateSleepTime, sleep |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
