# Not Enough Pots

Review status: **Evidence inventory; behavioral review pending**

Project: [Not Enough Pots](https://modrinth.com/mod/not-enough-pots)
Selected artifact version: `1.5.1`
Published implementation source: https://github.com/anweisemods/NotEnoughPots
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Put all plants into flower pots

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha512`: `c4e7d9c50aa7726c0eecd358c75bc9f8e40468ded9e86d7602c770e0d36dc79986e48226b7050df97a72f82f0bd935c2a424f465f168c490196cf8b7f6b67c22`
- `sha1`: `15f4e6dc145c2552f4ffb3c3ea2d908b7ee1fb95`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 10
Reconstructed Java files: 9

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "net.anweisen.notenoughpots.NotEnoughPotsFabricMod"
  ],
  "client": [
    "net.anweisen.notenoughpots.client.NotEnoughPotsFabricClient"
  ],
  "fabric-datagen": [
    "net.anweisen.notenoughpots.datagen.NotEnoughPotsFabricDataGenerator"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": ">=26.3 <26.4",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/anweisen/notenoughpots/client/NotEnoughPotsFabricClient.java` | `` |  | onInitializeClient, mimicBlockColor, agedStemBlockColor, mimicBlockColor, mimicTintSource, resolve, color, colorInWorld, colorAsTerrainParticle, warmWaterBlockColor, waterPlantBlockColor |
| top-level / `net/anweisen/notenoughpots/datagen/NotEnoughPotsFabricDataGenerator.java` | `` |  | onInitializeDataGenerator |
| top-level / `net/anweisen/notenoughpots/datagen/NotEnoughPotsLootTableProvider.java` | `` |  | generate |
| top-level / `net/anweisen/notenoughpots/IPottedBlockType.java` | `` |  |  |
| top-level / `net/anweisen/notenoughpots/NotEnoughPotsBlockType.java` | `` |  | getLightEmission, getFlowerBlock, getName, findBlock |
| top-level / `net/anweisen/notenoughpots/NotEnoughPotsCommons.java` | `` |  | init, getBridge |
| top-level / `net/anweisen/notenoughpots/NotEnoughPotsFabricMod.java` | `` |  | onInitialize |
| top-level / `net/anweisen/notenoughpots/platform/FabricPlatformBridge.java` | `` |  | registerPottedBlock, registerBuiltIn, finishRegistration, getPottedBlock |
| top-level / `net/anweisen/notenoughpots/platform/IPlatformBridge.java` | `` |  |  |

## Data-driven behavior

Resource category counts: `loot_table`: 109.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
