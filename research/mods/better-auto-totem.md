# Better Auto Totem

Review status: **Evidence inventory; behavioral review pending**

Project: [Better Auto Totem](https://modrinth.com/mod/better-auto-totem)
Selected artifact version: `1.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Auto Totem automatically places and activates a totem of undying to save the player from fatal damage.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `da398d920923997fd8ba7e61d19a1c4d82a229309283ed04aa3c2218cd609f636eb08085ce0ec639a0ae619212101f0f11552e13fe12f305db3a2ff916ff2db1`
- `sha1`: `38540a80b265a79acfd87bc8c8a0834d14e29b1a`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 8
Reconstructed Java files: 6

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "net.zerw.autototem.AutototemFabric"
  ],
  "client": [
    "net.zerw.autototem.client.AutototemFabricClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16.0",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/zerw/autototem/AutototemFabric.java` | `` |  | onInitialize |
| top-level / `net/zerw/autototem/AutototemForge.java` | `` |  | onPlayerTick, registerKeyMappings, onClientTick |
| top-level / `net/zerw/autototem/AutototemLogic.java` | `` |  | isEnabled, toggle, tickPlayer |
| top-level / `net/zerw/autototem/AutototemNeoForge.java` | `` |  | onPlayerTick |
| top-level / `net/zerw/autototem/AutototemNeoForgeClient.java` | `` |  | onClientTick, registerKeyMappings |
| top-level / `net/zerw/autototem/client/AutototemFabricClient.java` | `` |  | onInitializeClient |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
