# Sodium Leaf Culling Unofficial

Review status: **Evidence inventory; behavioral review pending**

Project: [Sodium Leaf Culling Unofficial](https://modrinth.com/mod/sodiumleafculling-unofficial)
Selected artifact version: `3.3.0+mc26.3-fabric`
Published implementation source: https://github.com/Sumire-Labs/SodiumLeafCulling-Unofficial
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

An unofficial port of SodiumLeafCulling by Txni

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `9062c70d588854fa7b2fc6b078deba77d9c922db`
- `sha512`: `956abf9cc00ef93c762ac0d2b5321e7e29c270af1b125566bcc40e7d339b54a91af9fddae6b910c30c73988eb3cfeef58abd2ba4e6e5480dcbeb60864ec50530`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 9
Reconstructed Java files: 9

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "mixinsquared": [
    "com.sumirelabs.sodiumleafculling.LeafCullingMixinCanceller"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.0",
  "minecraft": "26.3",
  "java": ">=25",
  "fabric-api": "*",
  "sodium": ">=0.9.2",
  "mixinsquared": ">=0.3.3"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/mixinsquared-fabric-0.3.4.jar` | 62 | `mixinsquared` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/sumirelabs/sodiumleafculling/LeafCulling.java` | `` |  | translatable, getQuality, isFacingAir, surroundedByLeaves, shouldCullSide |
| top-level / `com/sumirelabs/sodiumleafculling/LeafCullingMixinCanceller.java` | `` |  | shouldCancel |
| top-level / `com/sumirelabs/sodiumleafculling/LeafCullingQuality.java` | `` |  | getLocalizedName, isSolid |
| top-level / `com/sumirelabs/sodiumleafculling/mixins/AbstractBlockRenderContextAccessor.java` | `value={AbstractBlockRenderContext.class}, remap=false, priority=100)` | Accessor:3 |  |
| top-level / `com/sumirelabs/sodiumleafculling/mixins/BlockOcclusionCacheMixin.java` | `value={AbstractBlockRenderContext.class}, remap=false, priority=100)` | Inject:1 | inject$shouldDrawSide |
| top-level / `com/sumirelabs/sodiumleafculling/mixins/BlockRendererMixin.java` | `value={BlockRenderer.class}, remap=false, priority=100)` | Redirect:1 | inject$forceOpaque |
| top-level / `com/sumirelabs/sodiumleafculling/mixins/PerformanceSettingsMixin.java` | `value={SodiumOptions.PerformanceSettings.class}, remap=false, priority=100)` |  | sodiumleafculling$getQuality, sodiumleafculling$setQuality |
| top-level / `com/sumirelabs/sodiumleafculling/mixins/SodiumGameOptionPagesMixin.java` | `value={SodiumConfigBuilder.class}, remap=false, priority=100)` | Inject:1 | inject$leafcullingoption |
| top-level / `com/sumirelabs/sodiumleafculling/PerformanceSettingsAccessor.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
