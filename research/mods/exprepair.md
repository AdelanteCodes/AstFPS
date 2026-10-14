# expRepair

Review status: **Evidence inventory; behavioral review pending**

Project: [expRepair](https://modrinth.com/mod/exprepair)
Selected artifact version: `1.9.5`
Published implementation source: https://github.com/LunixiaLIVE
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Take control of your Mending enchantment. expRepair lets you decide when and how your gear gets repaired using your stored XP — no more losing XP to random orb pickups at the wrong time.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `198e3aea977c8461b7b8801d4a9aedb2c657bb0704e96a32ad783e1ecb7aa87f2e3f8822c0a5371d42e21cf71e780560d211f77a514b1ed56514d5fab5bd2e11`
- `sha1`: `376dbad2af1b33d4d5171c00c5eddac7312302d3`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 7
Reconstructed Java files: 5

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "net.lunix.exprepair.fabric.ExpRepairFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "fabric-api": "*",
  "minecraft": ">=26.1 <26.4-"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `architectury_inject_expRepair_multi_2613_common_613ef191e237490e9d3ccf019cddb2c1_f0cb4bd056460658d2f71133514521c7e35aaf2163adc1b33371745c3ddce211common195devjar/PlatformMethods.java` | `` |  | getCurrentTarget |
| top-level / `net/lunix/exprepair/Exprepair.java` | `` |  | setup, onServerStarted, onServerStopped, onUseItem, onServerTick, repairEquippedItems, onPlayerJoin, registerCommands, showHelp, toggleFeature, showThreshold, setThreshold, toggleLoginMessage, adminStatus, adminReset, adminSetPassive, adminSetManual, adminSetThreshold, adminReload, getModVersion, showVersion, showPlayerStatus, showServerDefaults, showDefaults, setDefaultPassive, setDefaultManual, setAllowPassive, setAllowManual, showAdminThreshold, showAdminMaxXp, setDefaultThreshold, setDefaultMaxXp, loadConfig, saveConfig, header, statusLabel, suggestButton, runButton, isEligible, getTotalXp, drainXp, getLevelFromXp, getXpToReachLevel |
| top-level / `net/lunix/exprepair/fabric/ExpRepairFabric.java` | `` |  | onInitialize |
| top-level / `net/lunix/exprepair/neoforge/ExpRepairNeoForge.java` | `` |  | onServerStarted, onServerStopped, onServerTick, onUseItem, onPlayerJoin, onRegisterCommands |
| top-level / `net/lunix/exprepair/PlayerDataStore.java` | `` |  | init, load, save, isPassivePermanent, setPassivePermanent, isManualPermanent, setManualPermanent, getPassiveThreshold, setPassiveThreshold, isLoginMessageEnabled, setLoginMessageEnabled |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
