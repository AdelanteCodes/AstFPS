# Fallback

Review status: **Evidence inventory; behavioral review pending**

Project: [Fallback](https://modrinth.com/mod/fallback)
Selected artifact version: `1.3.0-beta.2`
Published implementation source: https://github.com/Modcafe/Fallback
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Shared code for Intense's and Modcafe's Data Packs

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `07d8f8d37b8d474468e830cd77ae7908225b7abe`
- `sha512`: `c657626dc57a797caa127799905a1ecf220b9ea0fd34cf1ce63fc92da008f2ec248d42e7f1d4ffef9e1f758366ff1a1343e50e574d80d259d1105baf6463f192`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 10
Reconstructed Java files: 8

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "fabric-datagen": [
    "dev.intensed.fallback.client.FallbackDataGenerator"
  ],
  "client": [
    "dev.intensed.fallback.client.FallbackClient"
  ],
  "main": [
    "dev.intensed.fallback.Fallback"
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
| top-level / `dev/intensed/fallback/api/DateAPI.java` | `` |  | today, time_milliseconds, time, now, day, month, year, dayOfWeek |
| top-level / `dev/intensed/fallback/api/LoggerAPI.java` | `` |  | initialize, info, success, warn, error, send |
| top-level / `dev/intensed/fallback/api/RandomDialogAPI.java` | `` |  | execute, getScoreName, parseBlocked |
| top-level / `dev/intensed/fallback/client/FallbackClient.java` | `` |  | onInitializeClient |
| top-level / `dev/intensed/fallback/client/FallbackDataGenerator.java` | `` |  | onInitializeDataGenerator |
| top-level / `dev/intensed/fallback/Fallback.java` | `` |  | onInitialize |
| top-level / `dev/intensed/fallback/impl/FallbackCommand.java` | `` |  | build, runRandomDialog, runLog, runTest, register |
| top-level / `dev/intensed/fallback/impl/LogLevels.java` | `` |  | getLevel, suggest |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
