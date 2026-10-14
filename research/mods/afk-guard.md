# AFK Guard

Review status: **Evidence inventory; behavioral review pending**

Project: [AFK Guard](https://modrinth.com/mod/afk-guard)
Selected artifact version: `1.1.0-beta.1`
Published implementation source: https://github.com/HLVM04/afk-guard-mod
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Automatic disconnect from game if damaged while AFK.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `1f5cb3c5f711c18eb29c3c098f0ea43501fd3eb6f279d9aeda9a5f6e070a67f9edbbf780af64257d5722f46a2d3499c498561c5273027e2c1327cba2a1e34d5a`
- `sha1`: `ab71e8542ca925d9b3f31169b6c0e7a6e46ce5f0`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 11
Reconstructed Java files: 11

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "hlvm.afkguard.AFKGuard"
  ],
  "client": [
    "hlvm.afkguard.AFKGuardClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `hlvm/afkguard/AFKGuard.java` | `` |  | onInitialize |
| top-level / `hlvm/afkguard/AFKGuardClient.java` | `` |  | onInitializeClient |
| top-level / `hlvm/afkguard/AFKGuardCommands.java` | `` |  | register |
| top-level / `hlvm/afkguard/AFKGuardConfig.java` | `` |  | getInstance, load, save, getAutoAfkDelaySeconds, getAutoAfkDelayMs, shouldShowStatusMessages, shouldIgnorePlayerDamage, setAutoAfkDelaySeconds, setShowStatusMessages, setIgnorePlayerDamage |
| top-level / `hlvm/afkguard/AFKGuardState.java` | `` |  | getInstance, isAfkGuardEnabled, isAutoAfkEnabled, toggleAfkGuard, toggleAutoAfk, setAfkGuardEnabled, registerInput, setLastDamageWasPlayer, wasLastDamagePlayer, tick, onDisconnect, showStatusMessage |
| top-level / `hlvm/afkguard/config/ClothConfigIntegration.java` | `` |  | createConfigScreen |
| top-level / `hlvm/afkguard/config/ModMenuIntegration.java` | `` |  |  |
| top-level / `hlvm/afkguard/mixin/client/DamagePacketMixin.java` | `value={ClientPacketListener.class})` | Inject:1 | onEntityDamage |
| top-level / `hlvm/afkguard/mixin/client/KeyboardMixin.java` | `value={KeyboardHandler.class})` | Inject:1 | onKey |
| top-level / `hlvm/afkguard/mixin/client/MouseMixin.java` | `value={MouseHandler.class})` | Inject:2 | onCursorPos, onMouseButton |
| top-level / `hlvm/afkguard/ModKeybindings.java` | `` |  | register, consumeToggleAfkGuard, consumeToggleAutoAfk, consumeKeyPress |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
