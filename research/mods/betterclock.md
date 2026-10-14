# Better Clock

Review status: **Evidence inventory; behavioral review pending**

Project: [Better Clock](https://modrinth.com/mod/betterclock)
Selected artifact version: `1.1.0+26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Right-click your clock to see the current time and day in-game.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `c1e003886cdf27e0499c2e4c0e54f34b194771f3`
- `sha512`: `324c0c2a780a4637a99d957eafb2bab58f85ac5d22b5a7627bccf7280be58faed9a67d6cc2bd29262bfd6c6e2031e570c7313ef6927ef89bb89ba848361d7599`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 5
Reconstructed Java files: 3

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "io.github.evphub.betterclock.BetterClockClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "=26.3",
  "java": ">=25",
  "fabric-api": ">=0.162.0+26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/github/evphub/betterclock/BetterClockClient.java` | `` |  | onInitializeClient |
| top-level / `io/github/evphub/betterclock/ClockReading.java` | `` |  | ClockReading, at, message, label |
| top-level / `io/github/evphub/betterclock/UseKeyEdge.java` | `` |  | update |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
