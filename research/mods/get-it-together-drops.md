# Get It Together, Drops!

Review status: **Evidence inventory; behavioral review pending**

Project: [Get It Together, Drops!](https://modrinth.com/mod/get-it-together-drops)
Selected artifact version: `v1.5.1`
Published implementation source: https://github.com/bl4ckscor3/GetItTogetherDrops
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Adds tags and configuration options for defining how dropped items should combine.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `9a3baea44ee6dfef6957027798f7aae672c3c18c54076c181b9bb3190c26fe09f1e54b3cd130f16290e770f3f64398a5d5dd7637043fe4aa012d049631d50d7f`
- `sha1`: `585b823a54bab112cdc905689513a2f31500c80e`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 6
Reconstructed Java files: 6

**entrypoints**

```json
{
  "main": [
    "bl4ckscor3.mod.getittogetherdrops.FabricEntrypoint"
  ],
  "client": [
    "bl4ckscor3.mod.getittogetherdrops.FabricClientEntrypoint"
  ]
}
```

**depends**

```json
{
  "fabric-api": "*",
  "minecraft": ">=26.1.1",
  "java": ">=25",
  "forgeconfigapiport": ">=26.1.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `bl4ckscor3/mod/getittogetherdrops/FabricClientEntrypoint.java` | `` |  | onInitializeClient |
| top-level / `bl4ckscor3/mod/getittogetherdrops/FabricEntrypoint.java` | `` |  | onInitialize |
| top-level / `bl4ckscor3/mod/getittogetherdrops/GetItTogetherDrops.java` | `` |  | createItemTag |
| top-level / `bl4ckscor3/mod/getittogetherdrops/GetItTogetherDropsConfig.java` | `` |  | onConfigChange |
| top-level / `bl4ckscor3/mod/getittogetherdrops/mixin/ItemEntityInvoker.java` | `value={ItemEntity.class})` | Invoker:2 |  |
| top-level / `bl4ckscor3/mod/getittogetherdrops/mixin/ItemEntityMixin.java` | `value={ItemEntity.class})` | Inject:1 | mergeWithNeighbours |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
