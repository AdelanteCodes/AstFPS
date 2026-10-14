# Auto Sprint Fix

Review status: **Evidence inventory; behavioral review pending**

Project: [Auto Sprint Fix](https://modrinth.com/mod/sprint-fix)
Selected artifact version: `1.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Always Sprint is a lightweight client-side Fabric mod that keeps sprinting smooth and simple. It adds auto sprint, preserves toggle sprint through respawns, and works without Fabric API.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `1f6ad7149156e8bb2d821c1ccb1726293d178226`
- `sha512`: `43330adb87570532f20a7bd8299c6be8d413432f64d4a5847613b5b8d4e9b774bffe6b0a9351b1b0ea624a529fbd21aab78823b1d7c56955ca86da46ca876efe`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 7
Reconstructed Java files: 7

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.afkzstudios.sprintfix.client.SprintClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/afkzstudios/sprintfix/client/SprintClient.java` | `` |  | onInitializeClient, onRespawnStart, onRespawnEnd, isRespawning, onClientTick, sendStatus |
| top-level / `com/afkzstudios/sprintfix/client/SprintSettings.java` | `` |  | load, autoSprintEnabled, respawnFixEnabled, toggleAutoSprint, toggleRespawnFix, save |
| top-level / `com/afkzstudios/sprintfix/mixin/client/LocalPlayerMixin.java` | `value={LocalPlayer.class})` | Inject:2 | sprint$onRespawnStart, sprint$onRespawnEnd |
| top-level / `com/afkzstudios/sprintfix/mixin/client/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | sprint$onClientTick |
| top-level / `com/afkzstudios/sprintfix/mixin/client/OptionsMixin.java` | `value={Options.class})` | Inject:1 | sprint$addKeyMappings |
| top-level / `com/afkzstudios/sprintfix/mixin/client/ToggleKeyMappingMixin.java` | `value={ToggleKeyMapping.class})` | Inject:1 | sprint$keepStickySprintOnRespawn |
| top-level / `com/afkzstudios/sprintfix/SprintFix.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
