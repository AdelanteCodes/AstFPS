# Jukebox Custom Disc Fix

Review status: **Evidence inventory; behavioral review pending**

Project: [Jukebox Custom Disc Fix](https://modrinth.com/mod/jukebox-custom-disc-fix)
Selected artifact version: `0.2.0-26.3`
Published implementation source: https://github.com/eclipseisoffline/jukeboxcustomdiscfix
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This mod fixes bug MC-260346, which causes custom music discs, when played in a jukebox, to be cut off when the vanilla disc would normally end.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha512`: `73e04bb70e1126729eac315758967fa80996be06ffc194f4f5d4b0c8eec802ed82c64e700a0f6627af3498d160351921c5b05b11a6d0b2520a3337621cbb9730`
- `sha1`: `66cd825c273a264506aa1a37c5a5d23f4c5b85e5`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 4
Reconstructed Java files: 4

**environment**

```json
"*"
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `xyz/eclipseisoffline/jukeboxcustomdiscfix/mixin/ClientLevelMixin.java` | `value={ClientLevel.class})` | Inject:1 | checkForJukeboxStateAndStopSong |
| top-level / `xyz/eclipseisoffline/jukeboxcustomdiscfix/mixin/JukeboxSongPlayerMixin.java` | `value={JukeboxSongPlayer.class})` | Inject:1, Redirect:1 | sendStopRecordEvent, onlySendStopRecordEventIfJukeboxEmpty |
| top-level / `xyz/eclipseisoffline/jukeboxcustomdiscfix/mixin/LevelEventHandlerAccessor.java` | `value={LevelEventHandler.class})` | Accessor:1, Invoker:1 |  |
| top-level / `xyz/eclipseisoffline/jukeboxcustomdiscfix/mixin/LevelEventHandlerMixin.java` | `value={LevelEventHandler.class})` | Redirect:1 | cancelStopJukeboxSong |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
