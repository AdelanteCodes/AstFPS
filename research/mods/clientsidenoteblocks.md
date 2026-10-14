#  Client Side Noteblocks

Review status: **Evidence inventory; behavioral review pending**

Project: [ Client Side Noteblocks](https://modrinth.com/mod/clientsidenoteblocks)
Selected artifact version: `2.14`
Published implementation source: https://github.com/varun7654/ClientSideNoteblocks
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Removes lag when playing noteblocks

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `fb4bf7233ed21b38f53c8a70cf6dfdac6d20d55249267a643d860d3a68cad4a04567c9e6d6b06f1d4b8ecda36261213f76e93a8ba5501cb4afcfd2e783140fc9`
- `sha1`: `5da8880a05c7ac72c923e8784a95435aede2750c`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 11
Reconstructed Java files: 10

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "me.dacubeking.clientsidenoteblocks.client.ClientSideNoteblocksClient"
  ],
  "modmenu": [
    "me.dacubeking.clientsidenoteblocks.client.ModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

**accessWidener**

```json
"clientsidenoteblocks.accesswidener"
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/cloth-config-fabric-26.3.158.jar` | 625 | `cloth-config` | No |
| `META-INF/jars/mixinextras-fabric-0.4.1.jar` | 127 | `mixinextras` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/dacubeking/clientsidenoteblocks/client/ClientSideNoteblocksClient.java` | `` |  | isDebug, isEnabled, shouldCancelStraySounds, onInitializeClient |
| top-level / `me/dacubeking/clientsidenoteblocks/client/ModConfig.java` | `` |  |  |
| top-level / `me/dacubeking/clientsidenoteblocks/client/ModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `me/dacubeking/clientsidenoteblocks/expiringmap/SelfExpiringHashMap.java` | `` |  | size, isEmpty, containsKey, containsValue, get, put, put, remove, putAll, renewKey, expireKey, clear, keySet, values, entrySet, cleanup, getKey, equals, hashCode, getDelay, getDelayMillis, renew, expire, compareTo |
| top-level / `me/dacubeking/clientsidenoteblocks/expiringmap/SelfExpiringMap.java` | `` |  |  |
| top-level / `me/dacubeking/clientsidenoteblocks/mixin/ClientLevelMixin.java` | `value={ClientLevel.class})` | Inject:2 | playSound, clientSideNoteblocks$bypassedPlaySound, cancelBlockBreakSound, playSound |
| top-level / `me/dacubeking/clientsidenoteblocks/mixin/NoteblockMixin.java` | `value={NoteBlock.class})` |  | clientSideNoteblocks$getCustomSoundPublic |
| top-level / `me/dacubeking/clientsidenoteblocks/mixininterfaces/ClientLevelInterface.java` | `` |  |  |
| top-level / `me/dacubeking/clientsidenoteblocks/mixininterfaces/NoteblockInterface.java` | `` |  |  |
| top-level / `me/dacubeking/clientsidenoteblocks/mixininterfaces/SoundHandlerInterface.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
