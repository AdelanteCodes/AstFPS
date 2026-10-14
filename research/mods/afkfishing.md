# AFK Fishing

Review status: **Evidence inventory; behavioral review pending**

Project: [AFK Fishing](https://modrinth.com/mod/afkfishing)
Selected artifact version: `26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Automatically reels in and recasts your fishing rod when a catch is detected, perfect for AFK fishing.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `f8ec6e8b64b79bce6c2719b322e037a5e48875d00ebae18d2adb201588b1d063821924260a899bd3b8666c6eab424a5328fec3f188bebcd782a912ea65ff2575`
- `sha1`: `df41223d106d6e86854789e19c2a83f5aa3fbb3e`

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
"client"
```

**entrypoints**

```json
{
  "main": [
    "com.spce_man.autofisher.AutoFisher"
  ],
  "client": [
    "com.spce_man.autofisher.client.AutoFisherClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/spce_man/autofisher/AutoFisher.java` | `` |  | onInitialize |
| top-level / `com/spce_man/autofisher/client/AutoFisherClient.java` | `` |  | onInitializeClient, setEnabled, setHudVisible, handleStatusCommand |
| top-level / `com/spce_man/autofisher/client/mixin/ExampleClientMixin.java` | `value={Minecraft.class})` | Inject:1 | init |
| top-level / `com/spce_man/autofisher/client/mixin/FishingHookAccessor.java` | `value={FishingHook.class})` | Accessor:1 | getBitingAccessor |
| top-level / `com/spce_man/autofisher/client/mixin/MinecraftAccessor.java` | `value={Minecraft.class})` | Invoker:1 |  |
| top-level / `com/spce_man/autofisher/mixin/ExampleMixin.java` | `value={MinecraftServer.class})` | Inject:1 | init |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
