# TradeHall Villager/Farm Optimizer

Review status: **Evidence inventory; behavioral review pending**

Project: [TradeHall Villager/Farm Optimizer](https://modrinth.com/mod/tradehall-villagers-optimizer)
Selected artifact version: `1.1.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A client side mod that boosts your FPS in trade halls and farm.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `1d6f6900fb75fa1201dead8a6684e2a12175500a4ff14ef932ce7b9cfc60c9eb0477b667f211b22dc4a2c251ff9cea067336b709257395a726074fa534d97522`
- `sha1`: `50c6d3aa35337c44b25a69c60ceeafec693c8338`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 10
Reconstructed Java files: 7

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "tradehall.optimizer.client.TradeHallVillagersOptimizerClient"
  ],
  "modmenu": [
    "tradehall.optimizer.client.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.15.0",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*",
  "cloth-config": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `tradehall/optimizer/client/config/EntityRuleList.java` | `` |  |  |
| top-level / `tradehall/optimizer/client/config/EntityRuleListGui.java` | `` |  | register, create, createRuleEntry, getFieldName, describe, entityTypesById, clamp, read, write |
| top-level / `tradehall/optimizer/client/config/OptimizerConfig.java` | `` |  |  |
| top-level / `tradehall/optimizer/client/cull/VillagerCuller.java` | `` |  | shouldHide, findRule, isCameraOrVehicle, isTooFar, isOccluded, computeOcclusion, CacheEntry |
| top-level / `tradehall/optimizer/client/mixin/EntityRenderDispatcherMixin.java` | `value={EntityRenderDispatcher.class})` | Inject:1 | tradehall$cullVillagers |
| top-level / `tradehall/optimizer/client/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `tradehall/optimizer/client/TradeHallVillagersOptimizerClient.java` | `` |  | onInitializeClient, config |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
