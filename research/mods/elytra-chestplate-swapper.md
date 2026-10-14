# Elytra/Chestplate Swapper

Review status: **Evidence inventory; behavioral review pending**

Project: [Elytra/Chestplate Swapper](https://modrinth.com/mod/elytra-chestplate-swapper)
Selected artifact version: `2.1.0+26.3-fabric`
Published implementation source: https://github.com/Saphjyr/ElytraChestplateSwapper2
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A simple quality of life mod that swaps between chestplate and elytra on a keystroke.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `optional`.

Artifact identity:
- `sha1`: `f39943ee28757994af2fcd1dfecbd5feb734e1e0`
- `sha512`: `f98ed1beaeefebc4990166cb6f7108df30c87298a00dcd52a616243a948be02bf3ec96dbc1954789976416bb97b243271fbc121d938bac619e5f347a935c573e`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 9
Reconstructed Java files: 8

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "saphjyr.ecs.fabric.ElytraChestplateSwapperFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16.14",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `saphjyr/ecs/ChestItem.java` | `` |  |  |
| top-level / `saphjyr/ecs/ECSKeybind.java` | `` |  | create, get |
| top-level / `saphjyr/ecs/fabric/ElytraChestplateSwapperFabric.java` | `` |  | onInitializeClient |
| top-level / `saphjyr/ecs/InventoryUtils.java` | `` |  | swapChestplate, getArmorMenuSlot, getMenuSlot, sendSwapPackets |
| top-level / `saphjyr/ecs/ItemClassifier.java` | `` |  | classify, isElytra, isChestplate |
| top-level / `saphjyr/ecs/mixin/client/KeyboardMixin.java` | `value={KeyboardHandler.class})` | Inject:1 | onKey |
| top-level / `saphjyr/ecs/SwapKeyBinding.java` | `` |  | getKey, setDown, onPressed, isPressedBypass, setPressedBypass, onPressBypass |
| top-level / `saphjyr/ecs/SwapPlanner.java` | `` |  | searchOrder, plan |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
