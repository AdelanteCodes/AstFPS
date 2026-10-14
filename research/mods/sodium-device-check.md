# Sodium/Embeddium Device Check 钠/铷-设备检测

Review status: **Evidence inventory; behavioral review pending**

Project: [Sodium/Embeddium Device Check 钠/铷-设备检测](https://modrinth.com/mod/sodium-device-check)
Selected artifact version: `6.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A minecraft mod can check you hardware and software

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `002dfc6b083ddd93b6fec7327fb12dcfea7f90eb`
- `sha512`: `6832257f90405e4aed4bc44e67e00c83da7333840a0c0c09dcbde13288384e4e7eec8bcb0dbeb1edc553cff884ad66849924520e5396c0302b1597c02c6624d8`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 13
Reconstructed Java files: 10

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "me.loongly.mods.lsdc.fabric.client.LSDCFabricClientMod"
  ],
  "sodium:config_api_user": [
    "me.loongly.mods.lsdc.common.client.options.LSDCConfigBuilder"
  ]
}
```

**depends**

```json
{
  "minecraft": ">=26.1",
  "sodium": ">=0.8.7"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/loongly/mods/lsdc/common/api/system/RefMap.java` | `` |  | containsKey, get, initMapWithPathAndURL, convertJsonToMap, parseString, parseValue, doGet |
| top-level / `me/loongly/mods/lsdc/common/api/system/SystemAndGLInfo.java` | `` |  | initInstance, getInstance, getCpuInfo, getGpuInfoList, getMemoryInfoList, getJVMTotalMemory, initMemoryInfo, initGPUInfo, getMobileGPUNameWithPathNumber, initCPUInfo, getMobileSocNameWithPathNumber, getJDKVersion, getGLVersion, getOSName, getOSVersion, isUsingPojavLauncher, isKnownAndroidPathFragment, getName, getVendor, getFamily, getModel, getCores, getThreads, getFrequency, getName, getVendor, getSize, getClockSpeed, getType, getBankLabel, getName, getVendor, getVRam, getGpuCount |
| top-level / `me/loongly/mods/lsdc/common/client/LSDCClientMod.java` | `` |  | options, onInitClient, caiDan |
| top-level / `me/loongly/mods/lsdc/common/client/options/LSDCConfigBuilder.java` | `` |  | registerConfigLate |
| top-level / `me/loongly/mods/lsdc/common/client/options/LSDCOptions.java` | `` |  | save, load, writeChanges |
| top-level / `me/loongly/mods/lsdc/common/client/util/MethodSignature.java` | `` |  | MethodSignature, fromMethod, equals |
| top-level / `me/loongly/mods/lsdc/common/services/IPlatformHelper.java` | `` |  |  |
| top-level / `me/loongly/mods/lsdc/common/services/Services.java` | `` |  | load |
| top-level / `me/loongly/mods/lsdc/fabric/client/LSDCFabricClientMod.java` | `` |  | onInitializeClient |
| top-level / `me/loongly/mods/lsdc/fabric/services/FabricPlatformHelper.java` | `` |  | getConfigDirectory |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
