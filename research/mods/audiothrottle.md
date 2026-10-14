# AudioThrottle

Review status: **Behavioral static review**

Project: [AudioThrottle](https://modrinth.com/mod/audiothrottle)
Selected artifact version: `1.0.1`
Published implementation source: https://github.com/Noslw/AudioThrottle
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Improves the Minecraft sound engine for better performance

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `5dd35c98fd692f8815dc81d7a4b7da909708a786`
- `sha512`: `53b53942a87ad732b194790fe7ddcab1d43a5b732027a1be0819ce29d5e4ec90bccce459b396cd9e4fc47f3db69b9d6b047b7d28f7c9e5b24d3795bdfca02ed9`

## Reviewed mechanism

All four reconstructed source files reviewed, including the nested Entry record.

- Before positional sound playback, scans recent sound events of the same ID within eight blocks. Rejects playback after five matching events in the last 20 game ticks; relative sounds are exempt.
- Maintains a synchronized deque, expires old entries, and clears when the clock moves backward. Uses world game time when present and a nanoTime-derived clock otherwise.
- The play-result hook returns NOT_STARTED for rejected sounds and uses require=0, permitting startup even if the target injection is absent.

## Lifecycle, correctness, and failure questions

- Deliberately removes audible overlapping sounds. A clock switch between worlds with increasing game time can retain unrelated old events until expiry logic catches up.
- The deque has no shown hard capacity, and each check scans it linearly. The separate check/log synchronized calls are not one atomic admission operation across multiple threads.
- A permissive unmatched hook can make the feature silently do nothing.

## Checks needed to establish equivalence

- Test crowded sound sources, relative sounds, dimension/world changes, clock transitions, concurrency, deque growth, and hook application receipts.

## Relevance to Xe-Mod

Sound suppression for crowded scenes; not unchanged sensory output.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 5
Reconstructed Java files: 4

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.noslow.audiothrottle.AudioThrottleClient"
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
| top-level / `com/noslow/audiothrottle/AudioThrottleClient.java` | `` |  | onInitializeClient |
| top-level / `com/noslow/audiothrottle/AudioThrottleConfig.java` | `` |  |  |
| top-level / `com/noslow/audiothrottle/mixin/SoundEngineMixin.java` | `value={SoundEngine.class})` | Inject:1 | audiothrottle$limitCrowdedSoundsWithResult, audiothrottle$shouldCancel, audiothrottle$now |
| top-level / `com/noslow/audiothrottle/SoundTracker.java` | `` |  | shouldThrottle, log, clear, forgetOldSounds, Entry, isSameSoundNear, distanceSquared |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
