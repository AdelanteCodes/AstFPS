# Lite FPS

Review status: **Behavioral static review**

Project: [Lite FPS](https://modrinth.com/mod/lite-fps-patrolin)
Selected artifact version: `1.0.0`
Published implementation source: https://github.com/lunaticbonnie/lite-fps
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Minecraft mod to fix the framerate limiter.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `c3362793e3e9b12ddcf4bd652a236fdb7d75d32120e5b2f07fc82c88cd46d8b4ba31657ba4260b874cf6a404b5bbd398c613071ba140ac9d13b3f6940d585c16`
- `sha1`: `91665858d44fe42bc2defd76d24f36fd61e4282b`

## Reviewed mechanism

Both reconstructed classes reviewed.

- Overwrites the vanilla FPS limiter with nanosecond deadline accounting. Sleeps for whole remaining milliseconds, then spins until the next draw time.
- If it is more than one frame interval late, resets the target to now; otherwise advances using the scheduled deadline to limit drift.

## Lifecycle, correctness, and failure questions

- The final spin uses CPU. InterruptedException is swallowed in the reconstructed implementation. Invalid target FPS values and timer scheduling need testing.
- Whole-millisecond sleep precision varies by OS and load. This changes cap behavior, not rendering throughput.

## Checks needed to establish equivalence

- Compare deadline drift, p99 interval jitter, CPU use, late-frame recovery, and limiter interactions across Windows/Linux.

## Relevance to AstFPS

Frame pacing, not an increase in uncapped rendering capacity.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 2
Reconstructed Java files: 2

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "patrolin.litefps.LiteFPS"
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
| top-level / `patrolin/litefps/LiteFPS.java` | `` |  | onInitialize |
| top-level / `patrolin/litefps/mixin/FramerateLimiterMixin.java` | `value={FramerateLimiter.class})` | Overwrite:1 | limitDisplayFPS |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
