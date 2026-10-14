# Cull Leaves

Review status: **Evidence inventory; behavioral review pending**

Project: [Cull Leaves](https://modrinth.com/mod/cull-leaves)
Selected artifact version: `4.1.2+26.3-fabric`
Published implementation source: https://github.com/TeamMidnightDust/CullLeaves
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Adds culling to leaf blocks, providing a huge performance boost over vanilla.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `8cc1c814dd2c293138cb4f8bedcac8bb531fab2056ed64da85363ad26edd4172691bb16b3735c443306ba8480d2000629ae6f6713d4a76807a3460a6ac38da80`
- `sha1`: `ff792771822c8844fd699493db1fc078611c1acd`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 10
Reconstructed Java files: 9

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "eu.midnightdust.cullleaves.CullLeavesClient"
  ],
  "sodium:config_api_user": [
    "eu.midnightdust.cullleaves.config.SodiumConfigEntryPoint"
  ]
}
```

**depends**

```json
{
  "midnightlib": "*",
  "minecraft": ">=26.3"
}
```

**breaks**

```json
{
  "sodium": "<0.6.0"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/midnightlib-1.9.3+26.3-fabric.jar` | 24 | `midnightlib` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `eu/midnightdust/cullleaves/config/CullLeavesConfig.java` | `` |  | writeChanges |
| top-level / `eu/midnightdust/cullleaves/config/SodiumConfigEntryPoint.java` | `` |  | registerConfigLate |
| top-level / `eu/midnightdust/cullleaves/CullLeavesClient.java` | `` |  | shouldHideBlock, isLeafSideInvisible, isRootSideInvisible, onInitialize, onResourceManagerReload |
| top-level / `eu/midnightdust/cullleaves/CullLeavesMixinPlugin.java` | `` |  | onLoad, shouldApplyMixin, getMixins, getRefMapperConfig, acceptTargets, preApply, postApply |
| top-level / `eu/midnightdust/cullleaves/mixin/MixinBlockModelRenderer.java` | `value={ModelBlockRenderer.class})` | Inject:1 | cullleaves$cancelRendering |
| top-level / `eu/midnightdust/cullleaves/mixin/MixinLeavesBlock.java` | `value={LeavesBlock.class}, priority=1900)` |  | skipRendering |
| top-level / `eu/midnightdust/cullleaves/mixin/MixinMangroveRootsBlock.java` | `value={MangroveRootsBlock.class}, priority=1900)` |  | skipRendering |
| top-level / `eu/midnightdust/cullleaves/mixin/sodium/MixinBlockRenderer.java` | `value={BlockRenderer.class})` | Inject:1 | cullleaves$cancelRendering |
| top-level / `eu/midnightdust/cullleaves/mixin/sodium/MixinSodiumGameOptionPages.java` | `value={MidnightLib.class})` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
