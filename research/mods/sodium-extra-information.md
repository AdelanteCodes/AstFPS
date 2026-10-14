# Sodium Extra Information

Review status: **Evidence inventory; behavioral review pending**

Project: [Sodium Extra Information](https://modrinth.com/mod/sodium-extra-information)
Selected artifact version: `2.9.1`
Published implementation source: https://github.com/anviaan/SodiumExtraInformation
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A Sodium Extra addon that adds more in-game information.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `5b90a10bb9832846014a71e287294ed5bd1f463925bd2ed5353eae53cdbbb829025b7c0f3dfdeecca4f4f43fe0cc6f6c0c8ea3d8a07ffc6ab7af8b8f6313106b`
- `sha1`: `582efb3e821ed87417cb6b0ee4b62b22dae273b1`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 17
Reconstructed Java files: 9

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "net.anvian.sodiumextrainformation.client.SodiumExtraInformationClientFabricMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.2",
  "sodium": ">=0.8.9",
  "sodium-extra": ">=0.8.7",
  "anvianslib": ">=1.5.0",
  "minecraft": ">=26.1",
  "java": ">=25"
}
```

**breaks**

```json
{
  "iris": "<1.7.0",
  "reeses-sodium-options": "<1.4.2"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/anvian/sodiumextrainformation/client/SodiumExtraInformationClientFabricMod.java` | `` |  | onInitializeClient |
| top-level / `net/anvian/sodiumextrainformation/client/SodiumExtraInformationClientMod.java` | `` |  | options, logger, loadConfig, getTotalTimePlayed, onInitialization |
| top-level / `net/anvian/sodiumextrainformation/mixin/EndTickMixin.java` | `value={Minecraft.class})` | Inject:1 | onEndTick, sodiumExtraInformation$handleClientTick |
| top-level / `net/anvian/sodiumextrainformation/mixin/LevelRendererAccessor.java` | `value={LevelRenderer.class})` | Accessor:1 |  |
| top-level / `net/anvian/sodiumextrainformation/mixin/SodiumExtraConfigMixin.java` | `value={SodiumExtraConfig.class}, remap=false)` | Inject:1 | id, injectCreateExtraPage |
| top-level / `net/anvian/sodiumextrainformation/mixin/SodiumExtraHudMixin.java` | `value={SodiumExtraHud.class})` | Inject:1 | inject, sodiumextrainformation$displayLocalTime, sodiumextrainformation$displayWorldTime, sodiumextrainformation$displaySessionTime, sodiumextrainformation$displayMemoryUsage, sodiumextrainformation$displayTotalEntityCount, sodiumextrainformation$displayRenderedEntities, sodiumextrainformation$displayBiome |
| top-level / `net/anvian/sodiumextrainformation/options/SodiumExtraInformationGameOptions.java` | `` |  | load, writeChanges, afterSave, validateTimeFormat |
| top-level / `net/anvian/sodiumextrainformation/util/RGB.java` | `` |  | rgbToDecimal |
| top-level / `net/anvian/sodiumextrainformation/util/SessionManager.java` | `` |  | startSession, endSession, pauseSession, resumeSession, updateSessionTime, resetSession, isInSession, isPaused, getTotalTimePlayed |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
