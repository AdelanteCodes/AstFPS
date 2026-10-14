# AutoMuteOnAfk

Review status: **Evidence inventory; behavioral review pending**

Project: [AutoMuteOnAfk](https://modrinth.com/mod/automuteonafk)
Selected artifact version: `1.1.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Automatically mutes Minecraft when the window loses focus (alt-tab / AFK) and restores your exact volume when you return.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `19d3ddf3c1131f391a328caa422b442f229f624e`
- `sha512`: `40157359abfbea697f3c82018ba8bc3df6c9896f6d74abe40e698d2b5f405f454676e175f5bf6719e1ee7def751e972964a4ac64cf1c79e658f25d6f68c050f0`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 13
Reconstructed Java files: 13

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "dev.nikrecs.automuteonafk.fabric.AutoMuteOnAfkFabricClient"
  ]
}
```

**depends**

```json
{
  "architectury": "^22.0.1",
  "fabricloader": ">=0.19.5",
  "fabric-api": ">=0.160.5+26.3",
  "minecraft": "26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `architectury_inject_automuteonafk263_common_25eb91092833428390b9de09bed0c113_86aa1ed6c6fedf1d69a293456d54b45c006e0ce89776c74761bc9e23b3271d6dautomuteonafkcommon263110devjar/PlatformMethods.java` | `` |  | getCurrentTarget |
| top-level / `dev/nikrecs/automuteonafk/architectury/ArchitecturyClientRegistration.java` | `` |  | registerClientHooks |
| top-level / `dev/nikrecs/automuteonafk/AutoMuteOnAfkCommon.java` | `` |  | initialize, toggleEnabledAndGetNewState, load, save, resetForTesting, getConfig |
| top-level / `dev/nikrecs/automuteonafk/AutoMuteOnAfkConfig.java` | `` |  | createAndGetDefaults, isEnabled, isShowMessages, setEnabled, setShowMessages |
| top-level / `dev/nikrecs/automuteonafk/AutoMuteOnAfkRuntime.java` | `` |  | runTick, restore |
| top-level / `dev/nikrecs/automuteonafk/client/AutoMuteOnAfkClientController.java` | `` |  | registerKeyMappings, runClientTick, consumeToggleClicks, getTransitionMessageKey |
| top-level / `dev/nikrecs/automuteonafk/client/AutoMuteOnAfkClientRuntime.java` | `` |  | createAndGetInitializedController |
| top-level / `dev/nikrecs/automuteonafk/client/AutoMuteOnAfkMcAccess.java` | `` |  | isWindowFocused, getMasterVolume, setMasterVolumeAndSave, showActionBarMessage, createAndGetKeyMapping, getRegisteredKeyCategory |
| top-level / `dev/nikrecs/automuteonafk/client/McAccess.java` | `` |  |  |
| top-level / `dev/nikrecs/automuteonafk/client/TranslationKeyConstants.java` | `` |  |  |
| top-level / `dev/nikrecs/automuteonafk/fabric/AutoMuteOnAfkFabricClient.java` | `` |  | onInitializeClient |
| top-level / `dev/nikrecs/automuteonafk/VolumeTransition.java` | `` |  | VolumeTransition |
| top-level / `dev/nikrecs/automuteonafk/VolumeTransitionKind.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
