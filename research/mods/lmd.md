# Let Me Despawn

Review status: **Evidence inventory; behavioral review pending**

Project: [Let Me Despawn](https://modrinth.com/mod/lmd)
Selected artifact version: `1.26.9.2`
Published implementation source: https://github.com/frikinjay/let-me-despawn
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Improves performance by tweaking mob despawn rules. Say bye to pesky unintentional persistent mobs.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `3678d4413213897ab54e12e3e395b3801c861b05`
- `sha512`: `9870c2293d6c65341bf61fce49ca4d40f0a6c7c4dae51ad68c969c4ed7d3fa9750c8da585eb04fb1d5276e9ff7e31d42c4e6b0a3dc6368a3f5fd8fdefb3c7818`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 14
Reconstructed Java files: 14

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.frikinjay.letmedespawn.LetMeDespawn"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": ">=26.3",
  "java": ">=25",
  "almanac": ">=1.26.7.3"
}
```

**accessWidener**

```json
"letmedespawn.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/frikinjay/letmedespawn/command/LetMeDespawnCommands.java` | `` |  | register, suggestMobNames, suggestConfiguredMobNames, addMob, removeMob, suggestItems, suggestConfiguredItems, addItem, removeItem, setStandardSpawnerDespawn, setTrialSpawnerDespawn |
| top-level / `com/frikinjay/letmedespawn/CommonClass.java` | `` |  | init |
| top-level / `com/frikinjay/letmedespawn/config/LetMeDespawnConfig.java` | `` |  | getMobNames, addMobName, removeMobName, getPersistenceEnablers, addPersistenceEnabler, removePersistenceEnabler, isStandardSpawnerDespawnEnabled, setStandardSpawnerDespawnEnabled, isTrialSpawnerDespawnEnabled, setTrialSpawnerDespawnEnabled, load, save |
| top-level / `com/frikinjay/letmedespawn/Constants.java` | `` |  |  |
| top-level / `com/frikinjay/letmedespawn/LetMeDespawn.java` | `` |  | onInitialize |
| top-level / `com/frikinjay/letmedespawn/mixin/EnderManMixin.java` | `value={Enderman.class})` | Redirect:1 | letmedespawn$ignoreCarriedBlockForPersistence |
| top-level / `com/frikinjay/letmedespawn/mixin/EquipmentDispenseItemBehaviorMixin.java` | `value={EquipmentDispenseItemBehavior.class})` | Inject:1 | letmedespawn$afterEquip |
| top-level / `com/frikinjay/letmedespawn/mixin/MobAccessor.java` | `value={Mob.class})` | Accessor:2 |  |
| top-level / `com/frikinjay/letmedespawn/mixin/MobMixin.java` | `value={Mob.class}, priority=1010)` | Inject:4, Redirect:1 | letmedespawn$trackSpawnReason, letmedespawn$preventSpawnerPersistence, letmedespawn$setItemSlotAndDropWhenKilled, letmedespawn$fixVanillaPersistenceOverride, letmedespawn$yeetusCheckus |
| top-level / `com/frikinjay/letmedespawn/mixin/RegistryCacheClearerMixin.java` | `value={MinecraftServer.class})` |  |  |
| top-level / `com/frikinjay/letmedespawn/platform/FabricPlatformHelper.java` | `` |  | getPlatformName, isModLoaded, isDevelopmentEnvironment |
| top-level / `com/frikinjay/letmedespawn/platform/services/IPlatformHelper.java` | `` |  |  |
| top-level / `com/frikinjay/letmedespawn/platform/Services.java` | `` |  | load |
| top-level / `com/frikinjay/letmedespawn/util/DespawnUtil.java` | `` |  | getItemKey, getMobKey, setPersistence, hasDespawnableName |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
