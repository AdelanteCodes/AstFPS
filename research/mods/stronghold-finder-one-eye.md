# Stronghold Finder (One Eye Updated)

Review status: **Evidence inventory; behavioral review pending**

Project: [Stronghold Finder (One Eye Updated)](https://modrinth.com/mod/stronghold-finder-one-eye)
Selected artifact version: `1.1+26.3`
Published implementation source: https://github.com/OliverPerring/one-eye-stronghold-finder
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

One Eye fortress finder updated for 26.2. Saves alot of time working out the maths on servers and personally I find it far to useful

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `d8813fa6a1eaa8f16c43a9c78294830249eee2ef`
- `sha512`: `9dc36d0753aa9ae022079d1a775f720fb490cb7fab610f5fc7540161cda634f14878358ad8485770a69d3f1a8ed97f54ce75bea5cd3adeb88a643fec085e0fb1`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 10
Reconstructed Java files: 7

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "io.github.oliverperring.OESHF.OESHFClient"
  ],
  "journeymap": [
    "io.github.oliverperring.OESHF.integrations.journeymap.JourneyMapClientPlugin"
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
| top-level / `io/github/oliverperring/OESHF/finder/GridFinder.java` | `` |  | next, isInRing, alignToGrid |
| top-level / `io/github/oliverperring/OESHF/finder/Stronghold.java` | `` |  |  |
| top-level / `io/github/oliverperring/OESHF/finder/StrongholdFinderTask.java` | `` |  | run |
| top-level / `io/github/oliverperring/OESHF/integrations/journeymap/JourneyMapBridge.java` | `` |  | isAvailable, addWaypoint |
| top-level / `io/github/oliverperring/OESHF/integrations/journeymap/JourneyMapClientPlugin.java` | `` |  | initialize, getModId |
| top-level / `io/github/oliverperring/OESHF/integrations/journeymap/JourneyMapWaypointCommand.java` | `` |  | register, reportResult |
| top-level / `io/github/oliverperring/OESHF/OESHFClient.java` | `` |  | onInitializeClient |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
