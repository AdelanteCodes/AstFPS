# Eternal FPS

Review status: **Evidence inventory; behavioral review pending**

Project: [Eternal FPS](https://modrinth.com/mod/eternal-fps)
Selected artifact version: `4.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A Minecraft performance control mod with customizable profiles, FPS limit, Render Distance, and Simulation Distance controls.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `800fbf09c9c8ab49b93338796f40fc1b8ba3dd73b9804c4d82916cd3fce73bdbd0bf7c835f84573a7bf244230a319466fc8849dcfc5a32b9c827557249316ecc`
- `sha1`: `ee123ef9a1203cc362e9d591dd034a0445d30786`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 2
Reconstructed Java files: 1

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.projetoeternal.eternalfps.EternalFpsClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.0",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": ">=0.160.5"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/projetoeternal/eternalfps/EternalFpsClient.java` | `` |  | onInitializeClient, ensureConfig, loadConfig, saveConfig, clamp, normalizeFps, captureBaseline, restoreBaseline, applySettings, applyFpsOnly, applyRenderOnly, applySimulationOnly, applyMode, modeName, modeDescriptionLine1, modeDescriptionLine2, fpsName, renderName, simulationName, syncFromMinecraft, nearestFpsIndex, menuWidth, menuLeft, menuTop, menuBottom, leftPanelWidth, rightPanelX, rightPanelWidth, setMode, makeEternalFromCurrent, refreshButtonLabels, init, drawButtonOverlay, drawAccentOutline, drawButtonLabel, extractBackground, extractRenderState |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
