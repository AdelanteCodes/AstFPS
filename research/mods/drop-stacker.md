# Drop Stacker

Review status: **Evidence inventory; behavioral review pending**

Project: [Drop Stacker](https://modrinth.com/mod/drop-stacker)
Selected artifact version: `1.2.1`
Published implementation source: https://github.com/suwizx/drop-stacker
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Fabric mod for Minecraft that automatically merges dropped item entities on the ground into stacked entities — reducing item lag on servers and singleplayer worlds. Configurable stack size, scan radius, and scan interval.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `64657d06f084245a2723a837394141741d708655`
- `sha512`: `d50d0bb69ce67e236d8b18c7ed1da542842e26dc7864d4f65cc4b6c84c675fa0c397be706a77ee22c734416fc16809c5a8ed0e3544c701eaf2492d372a3a75fa`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 16
Reconstructed Java files: 13

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    {
      "value": "dev.suwizx.dropstacker.DropStacker",
      "adapter": "kotlin"
    }
  ],
  "client": [
    {
      "value": "dev.suwizx.dropstacker.client.DropStackerClient",
      "adapter": "kotlin"
    }
  ],
  "fabric-datagen": [
    {
      "value": "dev.suwizx.dropstacker.client.DropStackerDataGenerator",
      "adapter": "kotlin"
    }
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*",
  "fabric-language-kotlin": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/suwizx/dropstacker/accessor/ItemEntityAccessor.java` | `` |  |  |
| top-level / `dev/suwizx/dropstacker/client/DropStackerClient.java` | `` |  | onInitializeClient |
| top-level / `dev/suwizx/dropstacker/client/DropStackerDataGenerator.java` | `` |  | onInitializeDataGenerator |
| top-level / `dev/suwizx/dropstacker/command/DropStackerCommand.java` | `` |  | register, saved, reply, register$lambda$0, register$lambda$1, register$lambda$2, register$lambda$3, register$lambda$4, register$lambda$5, register$lambda$6, register$lambda$7, reply$lambda$0 |
| top-level / `dev/suwizx/dropstacker/config/AgeInheritance.java` | `` |  | values, valueOf, getEntries |
| top-level / `dev/suwizx/dropstacker/config/DropStackerConfig.java` | `` |  | getEnabled, setEnabled, getMergeOnSpawn, setMergeOnSpawn, getMaxStackSize, setMaxStackSize, getRadius, setRadius, getVerticalRadius, setVerticalRadius, getScanInterval, setScanInterval, getMaxScanInterval, setMaxScanInterval, getMaxMergePerPass, setMaxMergePerPass, getAgeInheritance, setAgeInheritance, getLabelMode, setLabelMode, getShowDespawnTimer, setShowDespawnTimer, getCountLowThreshold, setCountLowThreshold, getCountHighThreshold, setCountHighThreshold, getHideSingleItemLabel, setHideSingleItemLabel, getDespawnTicks, setDespawnTicks, getBlacklist, setBlacklist, getWhitelist, setWhitelist, getOverrides, setOverrides, load, save, snapshot, getEnabled, setEnabled, getMergeOnSpawn, setMergeOnSpawn, getMaxStackSize, setMaxStackSize, getRadius, setRadius, getVerticalRadius, setVerticalRadius, getScanInterval, setScanInterval, getMaxScanInterval, setMaxScanInterval, getMaxMergePerPass, setMaxMergePerPass, getAgeInheritance, setAgeInheritance, getLabelMode, setLabelMode, getShowDespawnTimer, setShowDespawnTimer, getCountLowThreshold, setCountLowThreshold, getCountHighThreshold, setCountHighThreshold, getHideSingleItemLabel, setHideSingleItemLabel, getDespawnTicks, setDespawnTicks, getBlacklist, setBlacklist, getWhitelist, setWhitelist, getOverrides, setOverrides, getScanRadiusX, setScanRadiusX, getScanRadiusY, setScanRadiusY, getScanRadiusZ, setScanRadiusZ, component1, component2, component3, component4, component5, component6, component7, component8, component9, component10, component11, component12, component13, component14, component15, component16, component17, component18, component19, component20, component21, copy, toString, hashCode, equals |
| top-level / `dev/suwizx/dropstacker/config/ItemRules.java` | `` |  | invalidate, ensureResolved, parseInto, isStackable, maxStackSize |
| top-level / `dev/suwizx/dropstacker/config/LabelMode.java` | `` |  | values, valueOf, getEntries |
| top-level / `dev/suwizx/dropstacker/DropStacker.java` | `` |  | onInitialize, onInitialize$lambda$0, onInitialize$lambda$1, onInitialize$lambda$2 |
| top-level / `dev/suwizx/dropstacker/mixin/ItemEntityMixin.java` | `value={ItemEntity.class})` | Inject:7, ModifyArg:1 | dropstacker_pickupDelay, dropstacker_setPickupDelay, dropstacker_setAge, dropstacker_resetBackoff, dropstacker_hasForeignName, dropstacker_refreshLabel, dropstackerOnSetItem, dropstackerOnTick, dropstackerOnMergeWithNeighbours, dropstackerOnIsMergable, dropstackerOnTryToMerge, dropstackerCapSavedStack, dropstackerOnSave, dropstackerOnLoad |
| top-level / `dev/suwizx/dropstacker/mixin/ServerLevelMixin.java` | `value={ServerLevel.class})` | Inject:1 | dropstackerOnAddFreshEntity |
| top-level / `dev/suwizx/dropstacker/stack/StackEngine.java` | `` |  | getMergesPerformed, getEntitiesCollapsed, resetStats, effectiveMax, isMergeable, absorbNeighbours, drain, absorbNeighbours$lambda$0, absorbNeighbours$lambda$1 |
| top-level / `dev/suwizx/dropstacker/stack/StackLabel.java` | `` |  | labelKey, shouldLabel, build |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
