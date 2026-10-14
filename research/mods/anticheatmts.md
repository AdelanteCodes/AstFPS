# MTSAntiCheat

Review status: **Evidence inventory; behavioral review pending**

Project: [MTSAntiCheat](https://modrinth.com/mod/anticheatmts)
Selected artifact version: `0.1.0+26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This anti-cheat ensures fair gameplay by verifying client mods and textures, blocking hacked clients and unauthorized tools, and giving server owners full visibility and control to keep their SMP secure and competitive.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unknown`. Server support: `unknown`.

Artifact identity:
- `sha512`: `0ba1df8f808b9c60619df38165f455fc1c8eb1fdc6743e7518abfde7585e8ae47216072c710f4010a82aa14481069595f5e502455ba8231d9ea1accb2f57b52c`
- `sha1`: `6fed6f5e1d558677dddac15c63507139649f9914`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 38
Reconstructed Java files: 32

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "net.mtsac.mod.MtsMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.14.0",
  "fabric-api": "*",
  "minecraft": "26.3",
  "java": ">=21"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/mtsac/mod/detect/BaritoneProbe.java` | `` |  | probe, findings, pathingState, origin, load, Result, toFinding |
| top-level / `net/mtsac/mod/detect/JvmInjectionScanner.java` | `` |  | scan, scanJvmAgents, scanClasspathJars, scanKnownClasses, scanThreads |
| top-level / `net/mtsac/mod/detect/LoadedModLister.java` | `` |  | list |
| top-level / `net/mtsac/mod/detect/MovePacketAudit.java` | `` |  | check, offThread, record, hasFindings, drain, Sample |
| top-level / `net/mtsac/mod/detect/ResourcePackTracker.java` | `` |  | update, reset, signature |
| top-level / `net/mtsac/mod/mixin/ConnectionSendMixin.java` | `value={Connection.class})` | Inject:1 | mtsac$auditMove |
| top-level / `net/mtsac/mod/mixin/KeyboardF3AMixin.java` | `value={KeyboardHandler.class})` | Inject:1 | mtsac$blockF3AChunkReload |
| top-level / `net/mtsac/mod/mixin/PiechartMixin.java` | `value={ProfilerPieChart.class})` | Inject:1 | mtsac$blockPiechart |
| top-level / `net/mtsac/mod/MtsClientConfig.java` | `` |  | sharedSecret, load |
| top-level / `net/mtsac/mod/MtsClientState.java` | `` |  | get, session, setSession, hasSession, reset, applyConfig, blockPiechart, blockF3aChunkReload, reportInjectedMods, heartbeatSeconds, bootId, moveAudit |
| top-level / `net/mtsac/mod/MtsMod.java` | `` |  | onInitializeClient, handleFrame, onHello, onConfig, onTick, reportResourcePacks, readAppliedPacks, sendModReport, send, jvmUptime |
| top-level / `net/mtsac/mod/net/ChannelBridge.java` | `` |  | register, send |
| top-level / `net/mtsac/mod/net/Compat.java` | `` |  | gameVersion, onGround, selectedPacks |
| top-level / `net/mtsac/mod/net/MovePacketHook.java` | `` |  | onSend |
| top-level / `net/mtsac/mod/net/MtsPayload.java` | `` |  | type |
| top-level / `net/mtsac/protocol/crypto/BadCiphertextException.java` | `` |  |  |
| top-level / `net/mtsac/protocol/crypto/Hkdf.java` | `` |  | derive, extract, expand |
| top-level / `net/mtsac/protocol/crypto/MtsCipher.java` | `` |  | encrypt, decrypt |
| top-level / `net/mtsac/protocol/crypto/SessionKey.java` | `` |  | derive |
| top-level / `net/mtsac/protocol/MtsChannels.java` | `` |  |  |
| top-level / `net/mtsac/protocol/MtsSession.java` | `` |  | encodeHello, decodeHello, encode, decode |
| top-level / `net/mtsac/protocol/packet/ConfigPacket.java` | `` |  | has, type, write, read |
| top-level / `net/mtsac/protocol/packet/HandshakePacket.java` | `` |  | type, write, read |
| top-level / `net/mtsac/protocol/packet/HeartbeatPacket.java` | `` |  | type, write, read |
| top-level / `net/mtsac/protocol/packet/HelloPacket.java` | `` |  | type, write, read |
| top-level / `net/mtsac/protocol/packet/ModReportPacket.java` | `` |  | type, write, read, Finding |
| top-level / `net/mtsac/protocol/packet/MtsPacket.java` | `` |  |  |
| top-level / `net/mtsac/protocol/packet/ResourcePackStatePacket.java` | `` |  | type, write, read, Entry |
| top-level / `net/mtsac/protocol/PacketType.java` | `` |  | id, byId |
| top-level / `net/mtsac/protocol/wire/ByteReader.java` | `` |  | next, u8, bool, varInt, i64, bytes, str, uuid, strList, hasRemaining |
| top-level / `net/mtsac/protocol/wire/ByteWriter.java` | `` |  | u8, bool, varInt, i64, bytes, bytesRaw, str, uuid, strList, toBytes |
| top-level / `net/mtsac/protocol/wire/WireFormatException.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
