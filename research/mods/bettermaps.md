# Maps of the Unknown

Review status: **Evidence inventory; behavioral review pending**

Project: [Maps of the Unknown](https://modrinth.com/mod/bettermaps)
Selected artifact version: `0.9.1-26.2`
Published implementation source: https://codeberg.org/NerjalNosk/bettermaps
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Improves explorer map creation upon loot-table processing

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `643ecf3e25816ec3b4278065f313fd74f2da0adc`
- `sha512`: `7222bb4a32124a74ff2f72b0ed3fb0f07fcbc0c192592d3bda5574a7d3d50a86a0b47ea23372bf5a995ba20d675e5af24a515c34beeac3623712f779478983d7`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 13
Reconstructed Java files: 12

**environment**

```json
"*"
```

**depends**

```json
{
  "fabricloader": ">=0.19.0",
  "minecraft": ">=26.2",
  "unruled_api": ">=2.3.3"
}
```

**accessWidener**

```json
"bettermaps.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/nerjal/bettermaps/BetterMapItem.java` | `` |  |  |
| top-level / `com/nerjal/bettermaps/Bettermaps.java` | `` |  | id, setClientPaused, isClientPaused, isLootEnabled, isTradeEnabled, isEnabled, createMap, storeMapData, lockMap, run, queue, interrupt, getTaskId, isQueued |
| top-level / `com/nerjal/bettermaps/BetterMapsCommand.java` | `` |  | register, executeList, stopTask |
| top-level / `com/nerjal/bettermaps/mixins/CommandManagerMixin.java` | `value={Commands.class})` | Inject:1 |  |
| top-level / `com/nerjal/bettermaps/mixins/compat/c2me/present/CheckedThreadLocalRandomMixin.java` | `targets={"com.ishland.c2me.fixes.worldgen.threading_issues.common.CheckedThreadLocalRandom;"}, remap=false)` | Inject:1 | onSetSeedCheckIfMapLocationThread |
| top-level / `com/nerjal/bettermaps/mixins/compat/Plugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `com/nerjal/bettermaps/mixins/ExplorationMapLootFunctionMixin.java` | `value={ExplorationMapFunction.class})` | Inject:1, ModifyExpressionValue:1 | processInjector, bettermaps$withDimension, bettermaps$toggle, codecExpand |
| top-level / `com/nerjal/bettermaps/mixins/FilteredFunctionAccessor.java` | `value={FilteredFunction.class})` | Accessor:1 |  |
| top-level / `com/nerjal/bettermaps/mixins/MapItemMixin.java` | `value={EmptyMapItem.class})` | Inject:1 | explorationMapUseInjector, locationTask |
| top-level / `com/nerjal/bettermaps/mixins/MinecraftClientMixin.java` | `value={Minecraft.class})` | Inject:1 | clientTickStopMapThreadsIfPaused |
| top-level / `com/nerjal/bettermaps/mixins/ServerWorldMixin.java` | `value={MinecraftServer.class})` | Inject:2 | serverShutdownStopMapThreadsInjector, beforeStopInterruptMapThreadsInjector |
| top-level / `com/nerjal/bettermaps/mixins/VillagerTradeMixin.java` | `value={VillagerTrade.class})` | ModifyVariable:1 | bettermaps_modifyModifiers |

## Data-driven behavior

Resource category counts: `lang`: 1.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
