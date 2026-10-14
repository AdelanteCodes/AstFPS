# Block Entity Render Distance

Review status: **Behavioral static review**

Project: [Block Entity Render Distance](https://modrinth.com/mod/block-entity-rd)
Selected artifact version: `1.0.0`
Published implementation source: https://github.com/Lolip-p/Block-Entity-Render-Distance
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Limits the rendering distance of Block Entity

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `9ef700323c42d22a76b54b8a5442e88a84686a02`
- `sha512`: `f259870c8a64994df4e0ae7e7416c02cc8bc6ab2e0b587206e2fdd6002487839f743e39d6eb274cd7f7ed0b668f501ecea706d0019bf47935ab3388ce9bcdb24`

## Reviewed mechanism

All five reconstructed classes and config defaults reviewed.

- Stores squared render distances by block-entity type, with a default of 64 blocks for unspecified types and shorter configured defaults for many vanilla types.
- In per-type mode, replaces shouldRender with squared camera-to-block-center distance comparison. In global mode, replaces the renderer view-distance getter using the global squared value.
- Commands update enabled/global/distance settings and read/write a JSON config. Registry IDs map configured names to live block-entity types.

## Lifecycle, correctness, and failure questions

- Defaults hide visible block entities earlier than vanilla. Replacing shouldRender can bypass specialized renderer rules, not just change a threshold.
- Reloaded config adds entries without a shown map clear, so removed entries can remain in memory. Parse failures can overwrite the existing file with current settings.

## Checks needed to establish equivalence

- Compare per-type visibility, specialized renderers and beams, invalid/removed config entries, mode switching, and resource/world changes.

## Relevance to AstFPS

Distance cutbacks; incompatible with the requested 16â€“20 chunk scene and unchanged visuals.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 5
Reconstructed Java files: 5

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "org.lolip_p.blockentitydistance.client.BlockEntityRenderDistanceClient"
  ],
  "main": []
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `org/lolip_p/blockentitydistance/client/BlockEntityRenderDistanceClient.java` | `` |  | onInitializeClient |
| top-level / `org/lolip_p/blockentitydistance/client/ConfigCommand.java` | `` |  | register, setEnabled, setUseGlobalValue, setGlobalValue, getConfig, reloadConfig |
| top-level / `org/lolip_p/blockentitydistance/client/ConfigHolder.java` | `` |  | put, getDistanceSq, loadConfig, saveConfig |
| top-level / `org/lolip_p/blockentitydistance/client/DistanceChecker.java` | `` |  | shouldRender |
| top-level / `org/lolip_p/blockentitydistance/mixin/BlockEntityRenderDistanceMixin.java` | `value={BlockEntityRenderer.class})` | Inject:2 | overrideDistance, overrideRender |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
