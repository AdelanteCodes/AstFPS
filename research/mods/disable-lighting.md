# Disable Lighting

Review status: **Behavioral static review**

Project: [Disable Lighting](https://modrinth.com/mod/disable-lighting)
Selected artifact version: `1.3.0`
Published implementation source: https://github.com/NetheriteMiner/DisableLighting
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Disables all lighting calculations. This allows for a fullbright that also improves performance.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `51624c4eda6ae664410d70a6332ebfb374d7b681`
- `sha512`: `febe5a4f01ecf9e95a0bbce7add59f5b538cf2f1ac5fc72db3944fde0e293924f789d3d6c395a2c20e64588a051444ee3887f582346f90c6a595fc5b50de9365`

## Reviewed mechanism

All three reconstructed classes reviewed.

- A client command controls a default-enabled flag. A cancellable HEAD injection skips Lightmap.render while the flag is enabled.
- The command text acknowledges that re-enabling the feature can require a restart. This is unconditional removal of the lightmap render path, not input-aware reuse of an equivalent result.

## Lifecycle, correctness, and failure questions

- Changes lighting appearance and can leave stale lightmap state. Cancelling a render/upload path does not prove all associated CPU calculations are avoided.

## Checks needed to establish equivalence

- Check day/night, dimension changes, darkness/night vision, toggling, and the actual lightmap producer/consumer paths.

## Relevance to AstFPS

Fullbright/lighting removal; incompatible with unchanged vanilla visuals.

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
    "tk.netheriteminer.DisableLightingClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.17.2",
  "minecraft": ">=26.1",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `tk/netheriteminer/commands/LightingCommand.java` | `` |  | registerCommand, isModEnabled |
| top-level / `tk/netheriteminer/DisableLightingClient.java` | `` |  | onInitializeClient |
| top-level / `tk/netheriteminer/mixin/client/LightmapMixin.java` | `value={Lightmap.class})` | Inject:1 | disableLightUpdate |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
