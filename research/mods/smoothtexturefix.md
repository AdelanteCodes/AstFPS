# SmoothTextureFix

Review status: **Behavioral static review**

Project: [SmoothTextureFix](https://modrinth.com/mod/smoothtexturefix)
Selected artifact version: `1.0.0+26.3`
Published implementation source: https://github.com/PoeticRainbow/smoothtexturefix
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Pixels were made to be crisp and clean! Fixes texture sampling introduced in 1.21.11+

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `5a752a057c4d1cb02468b43e8eefaacdfe43b5e6ebc667a6deb5f9edc70b42620a7625c06a27994f01654d923a1171365377a774d38418538fe0e12012a4fef0`
- `sha1`: `c7d3fa7eb3dbe0605da7802b8c183bfb3d28cc14`

## Reviewed mechanism

All three reconstructed classes reviewed; exception-heavy config code has decompiler reconstruction limitations.

- Modifies GPU sampler creation in the level main pass, replacing FilterMode arguments with NEAREST while its configuration switch is enabled.
- The command changes the switch, resets the level sampler, and persists the setting. The default enables the override.

## Lifecycle, correctness, and failure questions

- It deliberately changes texture filtering and therefore image appearance. A sampler-call lambda target is version-sensitive.
- Config error handling should be checked against original source/bytecode before asserting exact malformed-file behavior.

## Checks needed to establish equivalence

- Compare texture magnification/minification and mip transitions, command-driven sampler reset, resource reload, and malformed config handling.

## Relevance to Xe-Mod

Visual preference/fix; excluded from an unchanged-visuals optimization design.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 3
Reconstructed Java files: 3

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "io.github.poeticrainbow.smoothtexturefix.SmoothTextureFix"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/github/poeticrainbow/smoothtexturefix/mixin/LevelRendererMixin.java` | `value={LevelRenderer.class})` | ModifyArgs:1 | smoothtexturefix$override_texture_filtering |
| top-level / `io/github/poeticrainbow/smoothtexturefix/ModConfig.java` | `` |  | loadConfig, saveConfig, overrideTextureFilter, overrideTextureFilter |
| top-level / `io/github/poeticrainbow/smoothtexturefix/SmoothTextureFix.java` | `` |  | setFilterOverride, toggleFilterOverride, saveConfig, onInitializeClient |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
