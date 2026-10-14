# Better Stacking

Review status: **Evidence inventory; behavioral review pending**

Project: [Better Stacking](https://modrinth.com/mod/better-stacking)
Selected artifact version: `26.3-1.0.0-beta1`
Published implementation source: https://github.com/CCPCT/Better-Stacking
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

client configure item, entity, xp stacking

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `5962953d9d56691044455b1275c63a5c25686ad9`
- `sha512`: `29ff389d6baa9e59771040829b5b27c5b2dbaf895a392191eea67a9a18fb07cebc60494cfe24b695979964ca34a91e9a306137a58ffa74443e0348111f07439d`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 11
Reconstructed Java files: 10

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "CCPCT.better_stacking.BetterStacking"
  ],
  "modmenu": [
    "CCPCT.better_stacking.modConfig.ModMenuHandler"
  ]
}
```

**depends**

```json
{
  "fabric-api": "*",
  "fabricloader": "*",
  "minecraft": "~26.3",
  "java": ">=25",
  "modmenu": "*",
  "cloth-config": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `CCPCT/better_stacking/BetterStacking.java` | `` |  | onInitializeClient |
| top-level / `CCPCT/better_stacking/ICustomNameTagSubmitter.java` | `` |  |  |
| top-level / `CCPCT/better_stacking/mixin/EntityRenderer.java` | `value={EntityRenderDispatcher.class})` | Inject:1 | onShouldRender |
| top-level / `CCPCT/better_stacking/mixin/SubmitNodeCollectionMixin.java` | `value={SubmitNodeCollection.class})` |  | betterStacking$submitCustomColorNameTag |
| top-level / `CCPCT/better_stacking/modConfig/ConfigScreen.java` | `` |  | getConfigScreen |
| top-level / `CCPCT/better_stacking/modConfig/ModConfig.java` | `` |  | get, load, save |
| top-level / `CCPCT/better_stacking/modConfig/ModMenuHandler.java` | `` |  | getModConfigScreenFactory |
| top-level / `CCPCT/better_stacking/util/EntityClusterManager.java` | `` |  | getActiveClusters, shouldSkipRender, updateClusterData, ClusterEntry |
| top-level / `CCPCT/better_stacking/util/EntityTypeKey.java` | `` |  | EntityTypeKey, fromEntity |
| top-level / `CCPCT/better_stacking/util/RenderUtil.java` | `` |  | renderLabel, intToEng, intToMC |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
