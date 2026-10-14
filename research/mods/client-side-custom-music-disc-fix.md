# Client-side Custom Music Disc Fix

Review status: **Evidence inventory; behavioral review pending**

Project: [Client-side Custom Music Disc Fix](https://modrinth.com/mod/client-side-custom-music-disc-fix)
Selected artifact version: `1.1.6+26.3`
Published implementation source: https://github.com/Alpha-DS/Client-side-Custom-Music-Disc-Fix
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A simple client-side mod that fixes MC-260346 where custom music discs are cut off if they exceed the vanilla length.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `9ef3e308accafd79add6a311808730dfe7a7a75955389b2db8070fc890ee343809298108d48f6ede9f364988b13f944aed7c1050acab5437d0486c1e23f1f1f1`
- `sha1`: `6bbaab71b396e4bc91836309a160e8cac2a00e40`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 16
Reconstructed Java files: 13

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "dev.alphads.clientside_custom_music_disc_fix.ClientSideCustomMusicDiscFix"
  ],
  "modmenu": [
    "dev.alphads.clientside_custom_music_disc_fix.config.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/alphads/clientside_custom_music_disc_fix/ClientSideCustomMusicDiscFix.java` | `` |  | onInitializeClient |
| top-level / `dev/alphads/clientside_custom_music_disc_fix/config/Config.java` | `` |  | instantiateConfig, generateDefaultConfigFile, readConfigFromFile, validateConfigOptions, saveConfig, getConfigOption, getConfigOption |
| top-level / `dev/alphads/clientside_custom_music_disc_fix/config/ConfigScreen.java` | `` |  | loadConfigOptions, buildScreen |
| top-level / `dev/alphads/clientside_custom_music_disc_fix/config/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `dev/alphads/clientside_custom_music_disc_fix/managers/JukeboxHopperPlaylistManager.java` | `` |  | addSongToPlaylist, getSongFromPlaylist, removePlaylist |
| top-level / `dev/alphads/clientside_custom_music_disc_fix/managers/JukeboxParticleManager.java` | `` |  | addParticleLocation, removeParticleLocation, clearParticleLocations, init, renderParticles |
| top-level / `dev/alphads/clientside_custom_music_disc_fix/mixin/accessors/LevelEventHandlerAccessor.java` | `value={ClientLevel.class})` | Accessor:1 |  |
| top-level / `dev/alphads/clientside_custom_music_disc_fix/mixin/accessors/PlayingSongsAccessor.java` | `value={LevelEventHandler.class})` | Accessor:1 |  |
| top-level / `dev/alphads/clientside_custom_music_disc_fix/mixin/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | Inject:2 | onEntityTrackerUpdateMixin, onParticleMixin, calcParticlePos, calcJukeboxPos |
| top-level / `dev/alphads/clientside_custom_music_disc_fix/mixin/LevelEventHandlerMixin.java` | `value={LevelEventHandler.class})` | Inject:2 | playJukeboxSongMixin, stopJukeboxSongAndNotifyNearbyMixin |
| top-level / `dev/alphads/clientside_custom_music_disc_fix/mixin/LevelExtractorMixin.java` | `value={LevelExtractor.class})` | Inject:1 | blockChangedMixin |
| top-level / `dev/alphads/clientside_custom_music_disc_fix/mixin/SoundEngineMixin.java` | `value={SoundEngine.class})` | Inject:3, WrapOperation:1 | tickMixin, playSongs, playMixin, wrapAttenuationSetup |
| top-level / `dev/alphads/clientside_custom_music_disc_fix/utils/PlayingSongsGetter.java` | `` |  | getPlayingSongs |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
