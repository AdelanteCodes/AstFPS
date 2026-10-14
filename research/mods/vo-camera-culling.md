# VO: Camera Culling

Review status: **Evidence inventory; behavioral review pending**

Project: [VO: Camera Culling](https://modrinth.com/mod/vo-camera-culling)
Selected artifact version: `1.0.0+26.3`
Published implementation source: https://github.com/Rifaditya/Vanilla-Outsider-Camera-Culling
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Unrender the unseen. Lightweight, zero-allocation camera occlusion culling, 2-sided sign text culling & distance texture LOD.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `optional`.

Artifact identity:
- `sha1`: `c83cd86bfb81a020b3875ee757030f707b5c8f27`
- `sha512`: `3f6c556725b996ca4ed641b50ecfb178a98415933b673ffc21bc474b53af90f42fd5217f59b32a4134b40ea2c88df424f090d06a1cb3b22c1608795d72e46832`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

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
    "net.vanillaoutsider.culling.CameraCullingClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": ">=26.3-",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/vanillaoutsider/culling/CameraCullingClient.java` | `` |  | onInitializeClient, isCullingEnabled, setCullingEnabled, isDebugMode, setDebugMode, incrementCulledEntities, incrementRenderedEntities, incrementCulledBlockEntities, incrementRenderedBlockEntities, getCulledEntitiesCount, getRenderedEntitiesCount, getCulledBlockEntitiesCount, getRenderedBlockEntitiesCount |
| top-level / `net/vanillaoutsider/culling/mixin/BlockEntityRenderDispatcherMixin.java` | `value={BlockEntityRenderDispatcher.class})` | Inject:1 | onTryExtractRenderState |
| top-level / `net/vanillaoutsider/culling/mixin/EntityRendererMixin.java` | `value={EntityRenderer.class})` | Inject:1 | onShouldRender |
| top-level / `net/vanillaoutsider/culling/ModVersionGuard.java` | `` |  | checkClass |
| top-level / `net/vanillaoutsider/culling/util/CullingRaycastHelper.java` | `` |  | isEntityOccluded, isBlockEntityOccluded, hasLineOfSight, hasLineOfSightToBlock |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
