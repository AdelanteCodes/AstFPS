# PulseNet

Review status: **Evidence inventory; behavioral review pending**

Project: [PulseNet](https://modrinth.com/mod/pulsenet)
Selected artifact version: `1.1.0+26.3`
Published implementation source: https://github.com/Pulse-MC/PulseNet/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A server-sided fabric networking optimization mod that uses packet batching and other optimizations. Fully compatible with Krypton.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `8c349ae55e8c404939874676ac8f026df222a5b2`
- `sha512`: `45668a8cd60bc7ee6930f3fef2c5b939cd9d0d7424e5fe3fce351f49cca357013eaa232531f1a0a928062fd07b056610e5660de2f47edf5a9ff777511834110b`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 31
Reconstructed Java files: 26

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "dev.pulsemc.pulsenet.PulseNet"
  ],
  "main": [
    "dev.pulsemc.pulsenet.PulseNet"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "~26.3"
}
```

**accessWidener**

```json
"pulsenet.accesswidener"
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/fabric-permissions-api-0.7.0.jar` | 7 | `fabric-permissions-api-v0` | No |
| `META-INF/jars/server-translations-api-3.2.0+26.3.jar` | 33 | `server_translations_api` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/pulsemc/pulsenet/config/ConfigManager.java` | `` |  | rebuildIndex, read, save, generateCommand, getValue, getValue, getInt, getFloat, getBoolean, getDouble, getList, getStringList, getIntList, getDoubleList, getFloatList, getBooleanList, getEnumList |
| top-level / `dev/pulsemc/pulsenet/config/ConfigSetting.java` | `` |  | makeConfigValue, getId, getName |
| top-level / `dev/pulsemc/pulsenet/config/ConfigValue.java` | `` |  | getName, setValue, validate, setValidator, setOnSet, getComment, getTranslation, getErrorTranslation |
| top-level / `dev/pulsemc/pulsenet/config/IConfigSetting.java` | `` |  |  |
| top-level / `dev/pulsemc/pulsenet/config/Validator.java` | `` |  |  |
| top-level / `dev/pulsemc/pulsenet/config/values/BooleanConfigValue.java` | `` |  | getFromString, getArgumentType, parseArgumentValue, getSuggestions, getValueString |
| top-level / `dev/pulsemc/pulsenet/config/values/DoubleConfigValue.java` | `` |  | getFromString, getArgumentType, parseArgumentValue, getSuggestions, getValueString |
| top-level / `dev/pulsemc/pulsenet/config/values/EnumConfigValue.java` | `` |  | getFromString, getArgumentType, parseArgumentValue, getSuggestions, getValueString, getEnumSuggestions, parseEnum |
| top-level / `dev/pulsemc/pulsenet/config/values/FloatConfigValue.java` | `` |  | getFromString, getArgumentType, parseArgumentValue, getSuggestions, getValueString |
| top-level / `dev/pulsemc/pulsenet/config/values/IntConfigValue.java` | `` |  | getFromString, getArgumentType, parseArgumentValue, getSuggestions, getValueString |
| top-level / `dev/pulsemc/pulsenet/config/values/ListConfigValue.java` | `` |  | getFromString, getArgumentType, parseArgumentValue, getSuggestions, getValueString |
| top-level / `dev/pulsemc/pulsenet/config/values/StringConfigValue.java` | `` |  | getFromString, getArgumentType, parseArgumentValue, getSuggestions, getValueString |
| top-level / `dev/pulsemc/pulsenet/mixins/ConnectionMixin.java` | `value={Connection.class})` | Invoker:1, Inject:1 | pulsenet$flushBeforeChannelRegistration, pulsenet$getChannel, pulsenet$flushChannel, pulsenet$sendNoFlush |
| top-level / `dev/pulsemc/pulsenet/mixins/SectionBlocksUpdatePacketAccessor.java` | `value={ClientboundSectionBlocksUpdatePacket.class})` | Accessor:2 |  |
| top-level / `dev/pulsemc/pulsenet/mixins/ServerCommonPacketListenerImplMixin.java` | `value={ServerCommonPacketListenerImpl.class})` | Inject:2, WrapOperation:1 | pulsenet$initBuffer, pulsenet$getBuffer, pulsenet$wrapConnectionSend, pulsenet$cleanupOnDisconnect |
| top-level / `dev/pulsemc/pulsenet/mixins/ServerGamePacketListenerImplMixin.java` | `value={ServerGamePacketListenerImpl.class})` | Inject:2 | pulsenet$flushOnTickEnd, pulsenet$cleanupOnDisconnect |
| top-level / `dev/pulsemc/pulsenet/network/BatchingMode.java` | `` |  | getSerializedName |
| top-level / `dev/pulsemc/pulsenet/network/ConnectionAccess.java` | `` |  |  |
| top-level / `dev/pulsemc/pulsenet/network/FlushReason.java` | `` |  |  |
| top-level / `dev/pulsemc/pulsenet/network/Metrics.java` | `` |  | start, reload, reset, isMetricsEnabled, getUpdateInterval, isModuleCpuEnabled, isModuleNetworkEnabled, isModuleMemoryEnabled, isModuleWriteQueueEnabled |
| top-level / `dev/pulsemc/pulsenet/network/MetricsBar.java` | `` |  | toggle, removePlayer, addPlayerIfViewer, updateBar, reload |
| top-level / `dev/pulsemc/pulsenet/network/PacketBuffer.java` | `` |  | refreshConfig, ensureClassesInitialized, resolveClasses, setupIntervalTask, cancelIntervalTask, handleOutgoingPacket, flush, getPendingBytes, isBlockUpdate, getChunkKey, processBlockQueue, processCoalesceQueue, getBatchingMode, getFlushInterval, getExplosionThreshold, isExplosionLogEnabled, cleanup, reload, getObservedClassNames, getObservedChannelIds, clearObservedPackets, PacketEntry |
| top-level / `dev/pulsemc/pulsenet/network/PacketBufferAccess.java` | `` |  |  |
| top-level / `dev/pulsemc/pulsenet/PulseNet.java` | `` |  | onInitialize, onInitializeClient, registerConfigSetting |
| top-level / `dev/pulsemc/pulsenet/PulseNetCommands.java` | `` |  | register, getVersion, reloadConfig, toggleBar, sendStats, sendNetworkStats, sendCpuStats, sendRamStats, resetStats, listAllPacketNames, listPacketClasses, listPacketChannels, resetPacketNames |
| top-level / `dev/pulsemc/pulsenet/utils/TextUtils.java` | `` |  | camelToSnake, intToRoman, readableLong, readableInt, readableDouble, readableDouble, removeItalics, removeItalics |

## Data-driven behavior

Resource category counts: `lang`: 1.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
