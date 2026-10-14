# CrashPatch (Crash Preventer)

Review status: **Evidence inventory; behavioral review pending**

Project: [CrashPatch (Crash Preventer)](https://modrinth.com/mod/crashpatch)
Selected artifact version: `v2.2.1`
Published implementation source: https://github.com/Polyfrost/CrashPatch/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Stop crashes from closing your game!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `55182fc3e630eda66a1e9549dae720ad8825e253d8f4e978a4c29e2a2b1a60793138295cd6c31b1adb3b2703baf14c979bb693c22982db2b3a47d9f7ce84f1fe`
- `sha1`: `8f031ad79730e615b22169fa26ac58ced04c607d`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 63
Reconstructed Java files: 36

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    {
      "value": "org.polyfrost.crashpatch.CrashPatchEntrypoint"
    }
  ]
}
```

**depends**

```json
{
  "minecraft": "~26.3",
  "fabricloader": ">=0.19.5",
  "fabric-language-kotlin": "*",
  "notenoughcrashes": ">=4.5.0",
  "oneconfigv1": ">=1.4.1"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/api-6.2.1.jar` | 50 | `gs_mclo_api` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `org/polyfrost/crashpatch/client/crashes/cache/CacheResult.java` | `` |  | getReason, component1, copy, toString, hashCode, equals, getData, component1, copy, toString, hashCode, equals |
| top-level / `org/polyfrost/crashpatch/client/crashes/cache/CrashDataCache.java` | `` |  | getCacheFile, cache, parse, cacheFile_delegate$lambda$0 |
| top-level / `org/polyfrost/crashpatch/client/crashes/CrashScan.java` | `` |  | getSolutions, component1, copy, toString, hashCode, equals, getName, getSolutions, isCrashReport, component1, component2, component3, copy, toString, hashCode, equals |
| top-level / `org/polyfrost/crashpatch/client/crashes/CrashScanner.java` | `` |  | initialize, submitCacheRequest, scan, compileResponses, registerDefaultPlaceholders, scan, scan, comparator$lambda$0, submitCacheRequest$lambda$0, registerDefaultPlaceholders$lambda$0, registerDefaultPlaceholders$lambda$1, registerDefaultPlaceholders$lambda$2 |
| top-level / `org/polyfrost/crashpatch/client/crashes/data/CrashCause.java` | `` |  | getMethod, getValue, matches, component1, component2, copy, toString, hashCode, equals, CODEC$lambda$0$0, CODEC$lambda$0$1, CODEC$lambda$0$2, CODEC$lambda$0 |
| top-level / `org/polyfrost/crashpatch/client/crashes/data/CrashData.java` | `` |  | getFixes, getFixTypes, getDefaultFixType, resolveId, component1, component2, component3, copy, toString, hashCode, equals, CODEC$lambda$0$0, CODEC$lambda$0$1, CODEC$lambda$0$2, CODEC$lambda$0$3, CODEC$lambda$0 |
| top-level / `org/polyfrost/crashpatch/client/crashes/data/CrashFix.java` | `` |  | getName, getFixTypeId, getFixText, getCauses, getOnlySkyClient, triggersOn, component1, component2, component3, component4, component5, copy, toString, hashCode, equals, CODEC$lambda$0$0, CODEC$lambda$0$1, CODEC$lambda$0$2, CODEC$lambda$0$3, CODEC$lambda$0$4, CODEC$lambda$0$5, CODEC$lambda$0 |
| top-level / `org/polyfrost/crashpatch/client/crashes/data/FixType.java` | `` |  | getName, getNoInGameDisplay, getServerCrashes, component1, component2, component3, copy, toString, hashCode, equals, CODEC$lambda$0$0, CODEC$lambda$0$1, CODEC$lambda$0$2, CODEC$lambda$0$3, CODEC$lambda$0 |
| top-level / `org/polyfrost/crashpatch/client/crashes/data/MatchMethod.java` | `` |  | values, valueOf, getEntries, Companion$CODEC$lambda$0, Companion$CODEC$lambda$1, invoke, from |
| top-level / `org/polyfrost/crashpatch/client/crashes/LogScanner.java` | `` |  | getSuppressedErrors, install, failedModId, modFromMixinError, refineSuspect, reportLines, inspect, truncate, modName, modName$lambda$0, modName$lambda$1, append, getMod, getLines, component1, component2, copy, toString, hashCode, equals |
| top-level / `org/polyfrost/crashpatch/client/crashes/ScanPlaceholder.java` | `` |  | getName, getValue, replace, component1, component2, copy, toString, hashCode, equals |
| top-level / `org/polyfrost/crashpatch/client/CrashPatchClient.java` | `` |  | isCrashRequested, setCrashRequested, preInitialize, initialize, initialize$lambda$0$0, initialize$lambda$0$1, initialize$lambda$0$2, initialize$lambda$0 |
| top-level / `org/polyfrost/crashpatch/client/CrashPatchConfig.java` | `` |  | getInGameCrashPatch, setInGameCrashPatch, getInitCrashPatch, setInitCrashPatch, getDisconnectCrashPatch, setDisconnectCrashPatch, getIgnored, setIgnored, getLeaveLimit, setLeaveLimit, getCrashLimit, setCrashLimit, getCrashLogUploadMethod, setCrashLogUploadMethod, supportDiscord, getText, values, valueOf, getEntries |
| top-level / `org/polyfrost/crashpatch/client/gui/CrashUI.java` | `` |  | getThrowable, getCrashScan, getShouldCrash, setShouldCrash, create, onClose, removed, extractRenderState, compose, ActionButton, ActionButton, translate, compose$lambda$1, compose$lambda$2, compose$lambda$4, compose$lambda$5, crashScan_delegate$lambda$0, compose$lambda$6$0$0$0$0$0$0$0$0, compose$lambda$6$0$0$0$0$1$0$0, compose$lambda$6$0$0$0$0$1$1$0, compose$lambda$6$0$0$1$0, compose$lambda$6$0$0$3$0$0, compose$lambda$6$0$0$3$1, compose$lambda$6$0$0$3$2$0, compose$lambda$6, compose$lambda$7, ActionButton$lambda$0, ActionButton$lambda$1, ActionButton$lambda$4, fallbackLang_delegate$lambda$0, getLeaveWorldCrash, setLeaveWorldCrash, getCurrentInstance, getCurrentUI, getFallbackLang, getTitle, values, valueOf, getEntries |
| top-level / `org/polyfrost/crashpatch/client/LogUploader.java` | `` |  | getMcLogsClient, upload, sanitize, uploadToHastebin, uploadToMclogs, mcLogsClient_delegate$lambda$0 |
| top-level / `org/polyfrost/crashpatch/client/utils/DisconnectedScreenHook.java` | `` |  | onScreenDisplayed, reason |
| top-level / `org/polyfrost/crashpatch/CrashPatchConstants.java` | `` |  | getGameDirectory, gameDirectory_delegate$lambda$0 |
| top-level / `org/polyfrost/crashpatch/CrashPatchEntrypoint.java` | `` |  | onInitializeClient |
| top-level / `org/polyfrost/crashpatch/hooks/CrashReportHook.java` | `` |  |  |
| top-level / `org/polyfrost/crashpatch/identifier/ModIdentifier.java` | `` |  | identifyFromStacktrace, identifying$lambda$0 |
| top-level / `org/polyfrost/crashpatch/identifier/ModMetadata.java` | `` |  | getId, getName, component1, component2, copy, toString, hashCode, equals |
| top-level / `org/polyfrost/crashpatch/mixin/Mixin_AccessDisconnectReason.java` | `value={DisconnectedScreen.class})` | Accessor:1 |  |
| top-level / `org/polyfrost/crashpatch/mixin/Mixin_CrashInitGui.java` | `value={Minecraft.class})` | Inject:1 | crashInitGui |
| top-level / `org/polyfrost/crashpatch/mixin/Mixin_CrashPatchInitUI.java` | `value={Gui.class}, priority=1500)` | ModifyExpressionValue:1, Inject:1 | setScreenDontResetCrashScreen, setScreenDontResetCrashScreen |
| top-level / `org/polyfrost/crashpatch/mixin/Mixin_DebugRequestedCrash.java` | `value={Minecraft.class})` | Inject:1 | debugCrash |
| top-level / `org/polyfrost/crashpatch/mixin/Mixin_EntryPointErrorForceCrashPatchUI.java` | `value={EntryPointCatcher.class})` | ModifyArg:1 | useCrashPatchGui |
| top-level / `org/polyfrost/crashpatch/mixin/Mixin_IdentifySuspiciousMod.java` | `value={CrashReport.class}, priority=500)` | Inject:2 | afterPopulateEnvironment, afterDetails, crashpatch$getSuspectedMod |
| top-level / `org/polyfrost/crashpatch/mixin/Mixin_InGameCatcherForceCrashPatchUI.java` | `value={InGameCatcher.class})` | ModifyArg:2 | captureCrashReport, useCrashPatchGui |
| top-level / `org/polyfrost/crashpatch/mixin/Mixin_InGameCatcherKeepWorld.java` | `value={InGameCatcher.class}, remap=false)` | Inject:2 | crashpatch$keepWorldOnCleanup, crashpatch$keepWorldOnReset, crashpatch$decideKeepWorld |
| top-level / `org/polyfrost/crashpatch/mixin/Mixin_LogCrashWhenScreenSkipped.java` | `value={InGameCatcher.class}, remap=false)` | Inject:1 | crashpatch$reportBeforeBailing |
| top-level / `org/polyfrost/crashpatch/mixin/Mixin_ModLoaders_Debug.java` | `value={ModLoaders.class})` | Inject:2 | debugEntrypointCrashes, debugEntrypointCrashesQuilt |
| top-level / `org/polyfrost/crashpatch/mixin/Mixin_OverrideDisconnectedScreen.java` | `value={Gui.class})` | Inject:1 | onGUIDisplay |
| top-level / `org/polyfrost/crashpatch/mixin/Mixin_PreInitializeCrashPatch.java` | `value={Minecraft.class})` | Inject:1 | preInitialize |
| top-level / `org/polyfrost/crashpatch/mixin/Mixin_RelayWorkerThreadCrash.java` | `value={Util.class})` | Inject:1 | crashpatch$relayWorkerCrash |
| top-level / `org/polyfrost/crashpatch/mixin/Mixin_WarnIfConnectionStuck.java` | `value={ConnectScreen.class})` | Inject:1 | drawWarningText, crashpatch$getText, mouseClicked, crashpatch$drawSplitCenteredString |
| top-level / `org/polyfrost/crashpatch/plugin/MixinPlugin.java` | `` |  | getMixins, getRefMapperConfig, shouldApplyMixin, onLoad, acceptTargets, preApply, postApply |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
