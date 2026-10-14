# ServerLens

Review status: **Evidence inventory; behavioral review pending**

Project: [ServerLens](https://modrinth.com/mod/serverlens)
Selected artifact version: `2.1.0`
Published implementation source: https://github.com/normiklabs/ServerLens
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A client-side mod that brings the full server preview (MOTD, ping, player count, and favicon) to the Direct-Connect Screen.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `f4b80cc5f19007c7bd0f524764dd66f82d854321`
- `sha512`: `e1490189ea19617d003ff1a8b242d2947e1150ffe72cfbafc0d595fcc044327c831f73783f98f1c6e29bba85670ef0250a2ef863c3eae738829662b5db31caa0`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 5
Reconstructed Java files: 4

**entrypoints**

```json
{
  "client": [
    "org.normik.serverlens.Main"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": "~26.3",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `org/normik/serverlens/logic/DirectConnectLogic.java` | `` |  | pingServer, finish, noop |
| top-level / `org/normik/serverlens/Main.java` | `` |  | onInitializeClient, onAddressBarUpdate, cancelPendingPing, isDebugMode, handlePingResult, updateCurrentScreen, normalizedState, logPingResult |
| top-level / `org/normik/serverlens/mixin/DirectConnectScreenMixin.java` | `value={DirectJoinServerScreen.class})` | Inject:1 | serverlensUpdater$updateServerData, serverlensUpdater$updateFavicon, serverlens$renderExtras, serverlens$updateAddressPreview, serverlens$renderServerIcon, serverlens$renderServerText, serverlens$getNameWidth, serverlens$getPlayerCountWidth, serverlens$renderPing, serverlens$renderPlayerCount, serverlens$getPingTexture, serverlens$texture, serverlens$pingTexture, serverlens$clearServerIcon |
| top-level / `org/normik/serverlens/ServerDataUpdater.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
