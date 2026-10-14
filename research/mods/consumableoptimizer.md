# Consumable Optimizer

Review status: **Evidence inventory; behavioral review pending**

Project: [Consumable Optimizer](https://modrinth.com/mod/consumableoptimizer)
Selected artifact version: `2.2.3+26.3`
Published implementation source: https://github.com/Walksy/ConsumableOptimizer
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Handles eating client-side, ensuring servers don't slow down the eating process

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `e2877d5259eb95b2b72704085a4cb786b58b2614`
- `sha512`: `6d2ed373a00d81816a7522bfa850e505c9aa753424855a61d91e20582f4ccb4cb444f9249ffb4b0a3973a6fc48769143b4a1bc03f3d69aae57093e3bde61da82`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 10
Reconstructed Java files: 10

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "walksylib": [
    "walksy.consumableoptimizer.config.ConsumableOptimizerConfig"
  ]
}
```

**depends**

```json
{
  "minecraft": "26.3",
  "java": ">=25",
  "fabric-api": "*",
  "walksylib": ">=2.0.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `walksy/consumableoptimizer/config/ConsumableOptimizerConfig.java` | `` |  | shouldOptimize, define |
| top-level / `walksy/consumableoptimizer/data/EntityDataTrackerValues.java` | `` |  | getId |
| top-level / `walksy/consumableoptimizer/handler/ConsumableHandler.java` | `` |  | isConsumable, canConsume, hasConsumable, isWaitingForServer, handleItemStackUsage, handlePacket, handleEntityTrackerUpdate, handleServerSounds, shouldSkipHandAnimationOnSwap, processAudio, consume, finishUsing, playSound, playSound, applyFilteredTracker |
| top-level / `walksy/consumableoptimizer/handler/ConsumptionStateHandler.java` | `` |  | startServerWait, isWaitingForServer, stopServerWait, suppressBurp, suppressEquipmentAnimation, shouldSuppressBurp, shouldSuppressEquipmentAnimation, resetBurpSuppression, setSoundSuppression, isSoundSuppressed, clearSoundSuppression, updateTrack, extractTrackerValue |
| top-level / `walksy/consumableoptimizer/mixin/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | Inject:2 | onPlaySound, onEntityTrackerUpdate |
| top-level / `walksy/consumableoptimizer/mixin/ConnectionMixin.java` | `value={Connection.class})` | Inject:1 | receivePacket |
| top-level / `walksy/consumableoptimizer/mixin/ItemInHandRendererMixin.java` | `value={FirstPersonHandsAndItems.class})` | Inject:1 | shouldSkipHandAnimationOnSwap |
| top-level / `walksy/consumableoptimizer/mixin/LivingEntityMixin.java` | `value={LivingEntity.class})` | Inject:1 | tickItemStackUsage |
| top-level / `walksy/consumableoptimizer/mixin/LocalPlayerMixin.java` | `value={LocalPlayer.class})` | Redirect:1 | applyMovementSpeedFactors |
| top-level / `walksy/consumableoptimizer/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | doItemUse |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
