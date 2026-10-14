# Eslium

Review status: **Evidence inventory; behavioral review pending**

Project: [Eslium](https://modrinth.com/mod/eslium)
Selected artifact version: `4.6.0`
Published implementation source: https://github.com/Solmeye/Eslium
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Simulates zero latency by predicting server actions

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha512`: `7576e6f07341e54dec6fa66c643b736ff2fa2f36a8d7a30a12f594c8e9a790ba42ef4814e9ec94f09973852d21e10c224802b295413a612f57f4450ea65f7580`
- `sha1`: `27c30a5f7def7b29d1255f20655588860add864f`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 21
Reconstructed Java files: 21

**environment**

```json
"client"
```

**entrypoints**

```json
{}
```

**depends**

```json
{
  "fabricloader": ">=0.16.0",
  "minecraft": "26.3",
  "java": ">=25"
}
```

**accessWidener**

```json
"eslium.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/solmey/eslium/config/Config.java` | `` |  |  |
| top-level / `net/solmey/eslium/config/ConfigManager.java` | `` |  | initializeConfig, getConfig, loadConfig, saveConfig |
| top-level / `net/solmey/eslium/config/predictions/Crystal.java` | `` |  |  |
| top-level / `net/solmey/eslium/config/predictions/Minecart.java` | `` |  |  |
| top-level / `net/solmey/eslium/data/Data.java` | `` |  | extractPackets, extractPacket |
| top-level / `net/solmey/eslium/Eslium.java` | `` |  | commonInit, ensureDirectoriesReady, getConfigDir, shouldWork |
| top-level / `net/solmey/eslium/mixin/anticheat/ClientLevelMixin.java` | `value={ClientLevel.class})` | Inject:2 | eslium$tickEntitiesHEAD, eslium$tickEntitiesTAIL |
| top-level / `net/solmey/eslium/mixin/anticheat/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:2 | eslium$renderFrameHEAD, eslium$renderFrameTAIl |
| top-level / `net/solmey/eslium/mixin/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | Redirect:1, Inject:1 | eslium$showNetworkCharts, eslium$handleAddEntity |
| top-level / `net/solmey/eslium/mixin/ConnectionMixin.java` | `value={Connection.class})` | Inject:1 | eslium$send |
| top-level / `net/solmey/eslium/mixin/crystal/EndCrystalItemMixin.java` | `value={EndCrystalItem.class})` | Inject:1 | eslium$useOn |
| top-level / `net/solmey/eslium/mixin/entrypoint/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | eslium$onInit |
| top-level / `net/solmey/eslium/mixin/minecart/MinecartItemMixin.java` | `value={MinecartItem.class})` | Inject:1 | eslium$useOn |
| top-level / `net/solmey/eslium/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:3 | eslium$tickHEAD, eslium$tickTAIL, eslium$runTick |
| top-level / `net/solmey/eslium/mixin/PingDebugMonitorMixin.java` | `value={PingDebugMonitor.class})` | Inject:1 | eslium$onPongReceived |
| top-level / `net/solmey/eslium/predictions/UseItemOnPacket.java` | `` |  | onSentPacket |
| top-level / `net/solmey/eslium/rollback/InteractionManager.java` | `` |  | showEntities, hideEntities |
| top-level / `net/solmey/eslium/rollback/Rollback.java` | `` |  | rollback, rollback |
| top-level / `net/solmey/eslium/server/MixinMode.java` | `` |  |  |
| top-level / `net/solmey/eslium/server/SimulatedInventory.java` | `` |  | startServerTick, endServerTick, saveServerInventory, restoreServerInventory, saveRealInventory, restoreRealInventory |
| top-level / `net/solmey/eslium/server/SimulatedLevel.java` | `` |  | newEntityId, addEntity, tick, sendPairingData, getAddEntityPacket |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
