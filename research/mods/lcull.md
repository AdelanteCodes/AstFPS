# LCull

Review status: **Evidence inventory; behavioral review pending**

Project: [LCull](https://modrinth.com/mod/lcull)
Selected artifact version: `mc26.3-1.1.0-fabric`
Published implementation source: https://github.com/Starlevka/LCull
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Cursed, performant Frustum logic for heavy culling scenes

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `221a00132a572b51c794ad71150000b37a221547148e449de4106e583c7983bc6b22765d6997717813af4eef9085177c3c3683085d81876bcba1c309b22a2dce`
- `sha1`: `2c46340bf5ae4f41636836fb287da099a37b9497`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 6
Reconstructed Java files: 5

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "starl.lcull.LCull$Fabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.0",
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `starl/lcull/duck/IFrustum.java` | `` |  |  |
| top-level / `starl/lcull/LCull.java` | `` |  | init, onInitialize |
| top-level / `starl/lcull/mixins/MClientChunkCache.java` | `value={ClientChunkCache.class})` | Redirect:2 | lcull$silenceViewRangeLogBiomes, lcull$silenceViewRangeLogPacket |
| top-level / `starl/lcull/mixins/MEntityRenderer.java` | `value={EntityRenderer.class}, priority=2100)` | Inject:1 | lcull$box, lcull$unaffectedByCulling, lcull$shouldRender, lcull$decide, lcull$frustumVisible, lcull$isVisible, lcull$isVisible, lcull$isVisibleAt, lcull$leashHolderVisible, lcull$effectiveMargin |
| top-level / `starl/lcull/mixins/MFrustum.java` | `value={Frustum.class}, priority=2100)` | Inject:4 | lcull$onCalculateFrustum, lcull$onSet, lcull$rebuildPlanes, lcull$storePlane, lcull$halfExtent, lcull$bucket, lcull$preFoldVisible, lcull$preFoldInside, lcull$aggressiveCameraCube, lcull$isVisible, lcull$fastIsVisible |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
