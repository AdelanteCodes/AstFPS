# Offline Mode Fix

Review status: **Evidence inventory; behavioral review pending**

Project: [Offline Mode Fix](https://modrinth.com/mod/offline-mode-fix)
Selected artifact version: `1.0.1+26.3`
Published implementation source: https://codeberg.org/louiszn/offline-mode-fix/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A Fabric mod that fixes chat lag spikes and UI warnings on offline-mode Minecraft servers

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `18a78da4c9fd0f55b4dfdd24691ca23e22d09c98`
- `sha512`: `e2987f83d4d02fefed55befda8905d27e416ab4f148c866677a3fd1255715efc1c1b8c51639b1e1e2da000bbefebd798de1005e58981c4d4707a7c0e6eb2a438`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 6
Reconstructed Java files: 6

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "xyz.louiszn.offlinemodefix.client.OfflineModeFix"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.17",
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `xyz/louiszn/offlinemodefix/client/mixin/ChatComponentMixin.java` | `value={ChatComponent.class})` | ModifyVariable:1 | removeSidebarTags |
| top-level / `xyz/louiszn/offlinemodefix/client/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:3 | bypassIsBlocked, bypassTextFiltering, bypassPrepareForMultiplayer |
| top-level / `xyz/louiszn/offlinemodefix/client/mixin/PlayerTabOverlayMixin.java` | `value={PlayerTabOverlay.class})` | ModifyVariable:1 | forceHeadDisplay |
| top-level / `xyz/louiszn/offlinemodefix/client/mixin/ToastManagerMixin.java` | `value={ToastManager.class})` | Inject:1 | blockUnsecureToast |
| top-level / `xyz/louiszn/offlinemodefix/client/mixin/YggdrasilMixin.java` | `value={MinecraftServicesKeyInfo.class})` | Inject:1 | bypassSignatureValidation |
| top-level / `xyz/louiszn/offlinemodefix/client/OfflineModeFix.java` | `` |  | onInitializeClient |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
