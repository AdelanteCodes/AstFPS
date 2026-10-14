# Bypass Fabric Check

Review status: **Evidence inventory; behavioral review pending**

Project: [Bypass Fabric Check](https://modrinth.com/mod/bypass-fabric-check)
Selected artifact version: `1.0.11`
Published implementation source: https://github.com/tlwsy/bypass-fabric-check
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A Fabric mod that bypasses the handshake check, allowing Vanilla clients to join Fabric servers.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `75171486f6ac1cde893fc70b28d43ea0dc7a0c13e28b0d12dbc0f04a0afec5f2e652ed3875ff23a88e3885b93b0ea06f52a38f38d7516cc90d2483d62e4c5e89`
- `sha1`: `02e7fece3d291d7b5f38142276a40a25e078942e`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 2
Reconstructed Java files: 2

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "me.tlwsy.bypass.BypassFabricCheck"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": ">=26.1 <27.0",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/tlwsy/bypass/BypassFabricCheck.java` | `` |  | onInitialize, sendStatus, setStatus, isChinese |
| top-level / `me/tlwsy/bypass/mixin/BypassFabricCheckMixin.java` | `value={ServerCommonPacketListenerImpl.class})` | Inject:1 | interceptDisconnect, completeTaskAndProgress, prepareReflection |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
