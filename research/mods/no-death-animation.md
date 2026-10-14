# No Death Animation

Review status: **Evidence inventory; behavioral review pending**

Project: [No Death Animation](https://modrinth.com/mod/no-death-animation)
Selected artifact version: `2.1.0+26.3`
Published implementation source: https://github.com/Walksy/NoDeathAnimation
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Removes the death animation tilt on players.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `f1a575bd69fec15cba39dd6d8a1697a4c6c89d5b`
- `sha512`: `72c7585e92647abc4323329c5cf430b7997861f72fca493355a9ba5f5b3f86a594efdbf1e8b11da98e5d3d826ea5134fbf167c495be36b2f7a22134611862f13`

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

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "walksy.nodeathanimation.NoDeathAnimation"
  ],
  "walksylib": [
    "walksy.nodeathanimation.config.NoDeathAnimationConfig"
  ]
}
```

**depends**

```json
{
  "minecraft": "26.3",
  "java": ">=25",
  "fabric-api": "*",
  "walksylib": ">=2.0.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `walksy/nodeathanimation/config/NoDeathAnimationConfig.java` | `` |  | define |
| top-level / `walksy/nodeathanimation/LivingEntityRenderStateSources.java` | `` |  |  |
| top-level / `walksy/nodeathanimation/mixin/LivingEntityMixin.java` | `value={LivingEntity.class})` | Inject:1 | updateDeathTime |
| top-level / `walksy/nodeathanimation/mixin/LivingEntityRendererMixin.java` | `value={LivingEntityRenderer.class})` | Inject:3 | getAttributes, setupTransforms, getV |
| top-level / `walksy/nodeathanimation/mixin/LivingEntityRenderStateMixin.java` | `value={LivingEntityRenderState.class})` |  | getSourceEntity, setSourceEntity |
| top-level / `walksy/nodeathanimation/NoDeathAnimation.java` | `` |  | onInitialize, shouldOverride, getEntityTypeFromString |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
