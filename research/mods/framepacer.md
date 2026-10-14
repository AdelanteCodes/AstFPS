# FramePacer

Review status: **Behavioral static review**

Project: [FramePacer](https://modrinth.com/mod/framepacer)
Selected artifact version: `1.2.1`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

🔥FramePacer - Stable FPS cap without jitters!🔥

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `ec409d1f9bb6178f18a128a34717b24a7ac3ed64`
- `sha512`: `622752640615ada1eef6b610d9302780ca9239bfa0fae2e9661765d7eec2077b42a0ab2ae665f1a4d229db4f9d77efd50f58818c749dffafdb9fa1c86a9b2395`

## Reviewed mechanism

Both reconstructed classes reviewed.

- Cancels the vanilla framerate limiter. Calculates a deadline from the prior pacing time plus one target-frame interval.
- Parks the thread while more than one millisecond remains, then spins with Thread.onSpinWait until the deadline. Retains the last observed timestamp for the next call.

## Lifecycle, correctness, and failure questions

- Busy spinning consumes CPU. Oversleep, zero/invalid FPS arguments, clock scheduling, and interruptions require checks.
- Smoother cap timing does not reduce the cost of rendering a frame or raise an uncapped throughput ceiling.

## Checks needed to establish equivalence

- Measure interval distributions and CPU use at 60/144/300 FPS, under load and oversleep, with VSync, and after a long stall.

## Relevance to AstFPS

Frame pacing; potential smoothness benefit, not a promised FPS gain.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 2
Reconstructed Java files: 2

**environment**

```json
"client"
```

**depends**

```json
{
  "fabricloader": ">=0.14.25",
  "minecraft": ">=26.1 <=26.4"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `framepacer/Forge.java` | `` |  |  |
| top-level / `framepacer/mixin/FramePacer.java` | `targets={"net/minecraft/client/FramerateLimiter"})` | Inject:1 | HybridLimitFPS |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
