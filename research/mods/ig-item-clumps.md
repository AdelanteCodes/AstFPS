# IG: Item Clumps

Review status: **Evidence inventory; behavioral review pending**

Project: [IG: Item Clumps](https://modrinth.com/mod/ig-item-clumps)
Selected artifact version: `1.0.29+26.3`
Published implementation source: https://github.com/Rifaditya/IG-item-clumps
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Item Clumps completely redesigns how dropped item entities behave in the world, combining them into lightweight, virtual mega-stacks to maximize both server performance and client-side frame rates.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha512`: `58dd043884d6c69ddce4719419f29531c3ee69bc826bb4df25784a2c1b4f1fc248a6f177283dbbbebbf64e88f0494f95b830a1ab1b0200e41a5c0f5d068045f1`
- `sha1`: `519a0901227f5f85f2724dd329f27ef2eea6ce2f`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 7
Reconstructed Java files: 7

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "net.instantgratification.item_clumps.ItemClumpsFabric"
  ],
  "modmenu": [
    "net.instantgratification.item_clumps.config.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3-",
  "java": ">=25",
  "fabric-api": "*",
  "dasik-library": ">=1.9.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/instantgratification/item_clumps/config/ItemClumpsConfig.java` | `` |  | load, save, get |
| top-level / `net/instantgratification/item_clumps/config/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `net/instantgratification/item_clumps/config/YaclScreenHelper.java` | `` |  | createScreen, buildScreen |
| top-level / `net/instantgratification/item_clumps/ItemClumpsFabric.java` | `` |  | onInitialize |
| top-level / `net/instantgratification/item_clumps/mixin/HopperBlockEntityMixin.java` | `value={HopperBlockEntity.class})` | Inject:1 | item_clumps$customHopperExtract |
| top-level / `net/instantgratification/item_clumps/mixin/ItemEntityMixin.java` | `value={ItemEntity.class})` | Inject:4, ModifyExpressionValue:1 | item_clumps$updateVanillaNameTag, item_clumps$onSetItem, item_clumps$customIsMergable, item_clumps$customInflate, item_clumps$customMerge, item_clumps$smartPickup |
| top-level / `net/instantgratification/item_clumps/util/ModVersionGuard.java` | `` |  | checkClass |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
