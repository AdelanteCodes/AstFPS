# OptiLeaves(Fabric)

Review status: **Evidence inventory; behavioral review pending**

Project: [OptiLeaves(Fabric)](https://modrinth.com/mod/optileaves-fabric)
Selected artifact version: `2.0.1`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Optimize leaves rendering and increase FPS without noticeable visual changes. (Fabric version)

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `ba8e897a0930d250adecb61f25d416818e284083d98291645add3bed77ea157c6212154488bdd0755461c5db317807297f5e3fa8e8d4b2b715d6c1379eca1067`
- `sha1`: `a5b415ef0ec08e4c4fa5b1ca19442be03656e21d`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 10
Reconstructed Java files: 10

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "net.norevy.optileaves.OptiLeavesClient"
  ],
  "modmenu": [
    "net.norevy.optileaves.ui.MenuHook"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/norevy/optileaves/config/Settings.java` | `` |  | clampDepth, load, save |
| top-level / `net/norevy/optileaves/core/RenderBridge.java` | `` |  | fancyLeavesActive |
| top-level / `net/norevy/optileaves/LeafCulling.java` | `` |  | shouldCull, shouldCullFromNeighbor |
| top-level / `net/norevy/optileaves/mixin/block/LeafRebuildMixin.java` | `value={ClientLevel.class})` | Inject:2 | optileaves$blockChanged, optileaves$blockDirty, optileaves$markDistantFaces |
| top-level / `net/norevy/optileaves/mixin/render/BlockModelRendererMixin.java` | `value={ModelBlockRenderer.class})` | Inject:1 | optileaves$cull |
| top-level / `net/norevy/optileaves/mixin/sodium/OptionalRendererPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `net/norevy/optileaves/mixin/sodium/SodiumOcclusionMixin.java` | `targets={"net.caffeinemc.mods.sodium.client.render.model.AbstractBlockRenderContext"}, remap=false)` | Inject:1 | optileaves$cull |
| top-level / `net/norevy/optileaves/OptiLeavesClient.java` | `` |  | onInitializeClient, cfg |
| top-level / `net/norevy/optileaves/ui/MenuHook.java` | `` |  | getModConfigScreenFactory |
| top-level / `net/norevy/optileaves/ui/OptiLeavesScreen.java` | `` |  | init, enabledLabel, depthLabel, onClose, extractRenderState |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
