# Nemo's Mending

Review status: **Evidence inventory; behavioral review pending**

Project: [Nemo's Mending](https://modrinth.com/mod/nemos-mending)
Selected artifact version: `26.3-1.1.2`
Published implementation source: https://github.com/NemoNotFound/NemosBetterMending
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Repair your mending tools even if they are not in your equipment slots!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `2eeb6a1caef819b948f9abd9db576b967ad80da4`
- `sha512`: `2f24c0c8ae0d8d20ffca5baedea0f15ad7aaaa92dd4070f56b1efe5d6e617f029a10512e1a5051bb3dc012e6133143260ea68ba288efa294095c6af2f40ba7ef`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 9
Reconstructed Java files: 9

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.nemonotfound.nemos.mending.FabricNemosMending"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": ">=26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/nemonotfound/nemos/mending/Common.java` | `` |  | init |
| top-level / `com/nemonotfound/nemos/mending/Constants.java` | `` |  |  |
| top-level / `com/nemonotfound/nemos/mending/FabricNemosMending.java` | `` |  | onInitialize |
| top-level / `com/nemonotfound/nemos/mending/helper/ClumpsRepairGearsHelper.java` | `` |  | isClumpsLoaded, repairDamagedMendingGears |
| top-level / `com/nemonotfound/nemos/mending/helper/RepairGearHelper.java` | `` |  | repairPlayerGear, isRepairable, getMendingRepairCost, getMendingRepairAmount |
| top-level / `com/nemonotfound/nemos/mending/mixin/ExperienceOrbMixin.java` | `value={ExperienceOrb.class})` | ModifyVariable:1 | init |
| top-level / `com/nemonotfound/nemos/mending/platform/FabricModLoaderHelper.java` | `` |  | isModLoaded |
| top-level / `com/nemonotfound/nemos/mending/platform/services/IModLoaderHelper.java` | `` |  |  |
| top-level / `com/nemonotfound/nemos/mending/platform/Services.java` | `` |  | load |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
