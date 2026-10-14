# Elytra Slot

Review status: **Evidence inventory; behavioral review pending**

Project: [Elytra Slot](https://modrinth.com/mod/elytra-slot-cafekad)
Selected artifact version: `1.1.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Added elytra slot in Minecraft

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha1`: `c1fcdc2f47c8cda7c7cdc90b07de9a783964857d`
- `sha512`: `e539438ec2e31e95e235c38dab074ae979f844f0222a6d7e7c82dc811064da102e3fa6684e2166999db72a8919802934b101d9e782ba45a1eb93e5fcfb8813b9`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 16
Reconstructed Java files: 16

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "miku.chaoscubed.ChaosCubed"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `miku/chaoscubed/ChaosCubed.java` | `` |  | onInitialize |
| top-level / `miku/chaoscubed/duck/ChaosCubedRenderStateAccessor.java` | `` |  |  |
| top-level / `miku/chaoscubed/inventory/BodyElytraSlot.java` | `` |  | creativeSlotX, creativeSlotY, mayPlace, setByPlayer, set, onTake, chaoscubed$syncIfCreativeClient, getMaxStackSize, getNoItemIcon |
| top-level / `miku/chaoscubed/mixin/CapeLayerMixin.java` | `value={CapeLayer.class})` | Inject:1 | chaoscubed$hideCapeWhenBodyElytraEquipped |
| top-level / `miku/chaoscubed/mixin/ChaosCubedMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `miku/chaoscubed/mixin/CreativeModeInventoryScreenPositionMixin.java` | `value={CreativeModeInventoryScreen.class})` | ModifyArgs:1 | chaoscubed$overrideElytraSlotPosition |
| top-level / `miku/chaoscubed/mixin/HumanoidMobRendererMixin.java` | `value={HumanoidMobRenderer.class})` | Inject:1 | chaoscubed$fillBodyElytra |
| top-level / `miku/chaoscubed/mixin/HumanoidRenderStateMixin.java` | `value={HumanoidRenderState.class})` |  | chaoscubed$getBodyElytra, chaoscubed$setBodyElytra |
| top-level / `miku/chaoscubed/mixin/InventoryMenuMixin.java` | `value={InventoryMenu.class})` | Inject:1 | chaoscubed$addBodyElytraSlot |
| top-level / `miku/chaoscubed/mixin/ItemUseGliderMixin.java` | `value={Item.class})` | Inject:1 | chaoscubed$equipGliderToBodySlot |
| top-level / `miku/chaoscubed/mixin/LivingEntityCanGlideUsingMixin.java` | `value={LivingEntity.class})` | Inject:1 | chaoscubed$canGlideUsingBodySlot |
| top-level / `miku/chaoscubed/mixin/LivingEntityGliderDurabilityPriorityMixin.java` | `value={LivingEntity.class})` | ModifyVariable:1 | chaoscubed$prioritizeBodySlot |
| top-level / `miku/chaoscubed/mixin/LivingEntityOnEquipItemMixin.java` | `value={LivingEntity.class})` | Inject:1 | chaoscubed$playEquipSoundForBodySlot |
| top-level / `miku/chaoscubed/mixin/WingsLayerMixin.java` | `value={WingsLayer.class})` | ModifyVariable:1 | chaoscubed$useBodyElytraForWings |
| top-level / `miku/chaoscubed/network/ElytraSlotNetworking.java` | `` |  | register |
| top-level / `miku/chaoscubed/network/SetCreativeElytraSlotPayload.java` | `` |  | type |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
