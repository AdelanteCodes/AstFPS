# Panda TNT Fusion

Review status: **Evidence inventory; behavioral review pending**

Project: [Panda TNT Fusion](https://modrinth.com/mod/pandatntfusion)
Selected artifact version: `1.0.0+26.3`
Published implementation source: https://github.com/TreeOfSelf/PandaTNTFusion/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Stop massive amounts of TNT from lagging or crashing your server

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `60036077c3c1799634466d6f1856d6d60d4d2496`
- `sha512`: `3638d7510f182a29d9d4559539384900d752993657d0f48c3203c12e57cf068de64961538ab3c38ab3f7b64383ec26a1a66eff25a5c085823bf74daf786b7746`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 5
Reconstructed Java files: 5

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "me.TreeOfSelf.PandaTNTFusion.PandaTNTFusion"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.6",
  "minecraft": ">=26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/TreeOfSelf/PandaTNTFusion/mixin/TNTBlockMixin.java` | `value={TntBlock.class})` | Inject:1 | getNearestTNTEntity, wasExploded |
| top-level / `me/TreeOfSelf/PandaTNTFusion/mixin/TNTEntityMixin.java` | `value={PrimedTnt.class})` | Inject:1 | pandaTNTFusion$addPower, explode |
| top-level / `me/TreeOfSelf/PandaTNTFusion/PandaTNTConfig.java` | `` |  | loadOrGenerateConfig, generateConfig |
| top-level / `me/TreeOfSelf/PandaTNTFusion/PandaTNTFusion.java` | `` |  | onInitialize, onEntityUnload, onEntityLoad |
| top-level / `me/TreeOfSelf/PandaTNTFusion/TNTEntityAccess.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
