# Stop Pause My Music

Review status: **Evidence inventory; behavioral review pending**

Project: [Stop Pause My Music](https://modrinth.com/mod/stop_pause_my_music)
Selected artifact version: `1.0-26.3`
Published implementation source: https://github.com/lucachinou/StopPauseMyMusic
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Keep listening awesome Minecraft music when playing on multiplayer!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `d88d3afa5130e27d53b1ed377adb2f9e5cc98a6750bf91bd88a24d2bab209746fcd187bb6815c5e22e6dfd5b85beedafb1dd84d6fab2821212bfba8103ff1e5d`
- `sha1`: `6169c7bf25f9539fc6a2846e2745516d8eaff05f`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 6
Reconstructed Java files: 6

**environment**

```json
"client"
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/lucachinou/stoppausemymusic/client/PersistentMusicState.java` | `` |  | keepCurrentMusic, stopAllExceptCurrentMusic, shouldKeepPlaying, validate, clear, preserve |
| top-level / `dev/lucachinou/stoppausemymusic/mixin/client/accessor/MusicTrackerAccessor.java` | `value={MusicManager.class})` | Accessor:1 |  |
| top-level / `dev/lucachinou/stoppausemymusic/mixin/client/accessor/SoundManagerAccessor.java` | `value={SoundManager.class})` | Accessor:1 |  |
| top-level / `dev/lucachinou/stoppausemymusic/mixin/client/accessor/SoundSystemAccessor.java` | `value={SoundEngine.class})` | Accessor:1 |  |
| top-level / `dev/lucachinou/stoppausemymusic/mixin/client/MinecraftClientMixin.java` | `value={Minecraft.class})` | Inject:3, Redirect:1 | stoppausemymusic$preserveCurrentMusicBeforeSetLevel, stoppausemymusic$preserveCurrentMusicBeforeDisconnect, stoppausemymusic$preserveCurrentMusicBeforeClearClientLevel, stoppausemymusic$keepCurrentMusicPlayingDuringWorldSwitch |
| top-level / `dev/lucachinou/stoppausemymusic/mixin/client/MusicTrackerMixin.java` | `value={MusicManager.class})` | Redirect:1, Inject:3 | stoppausemymusic$preventTransitionReplacement, stoppausemymusic$clearExpiredPreservedMusic, stoppausemymusic$keepPreservedMusicOnStop, stoppausemymusic$keepPreservedMusicOnTypedStop |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
