# OverpoweredMending

Review status: **Evidence inventory; behavioral review pending**

Project: [OverpoweredMending](https://modrinth.com/mod/overpoweredmending)
Selected artifact version: `26.3-26.3.0.2`
Published implementation source: https://github.com/RakambdaOrg/OverpoweredMending
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Changes the behaviour of Mending to repair things in your inventory

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha1`: `4e1c79b7258e6ecbfb0f27358da9ea76624b2f6d`
- `sha512`: `f8692f729087996bdba3573f2d31d16861c69d2f726cab6a7fe93dea18d404c1e634922bcd77a17a1800c12e2211d804054349644b03c1ad93cb7b48267361f9`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 57
Reconstructed Java files: 56

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "fr.rakambda.overpoweredmending.fabric.OverpoweredMending"
  ],
  "client": [
    "fr.rakambda.overpoweredmending.fabric.client.OverpoweredMendingClient"
  ],
  "server": [],
  "modmenu": [
    "fr.rakambda.overpoweredmending.fabric.client.ModMenuImpl"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-resource-loader-v0": "*",
  "fabric-api": ">=0.160",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `fr/rakambda/overpoweredmending/common/config/enums/SelectionMode.java` | `` |  | getComparator, getValues |
| top-level / `fr/rakambda/overpoweredmending/common/config/IConfiguration.java` | `` |  |  |
| top-level / `fr/rakambda/overpoweredmending/common/config/IResettable.java` | `` |  |  |
| top-level / `fr/rakambda/overpoweredmending/common/config/proxy/ProxyConfiguration.java` | `` |  | reset, setSelectionMode |
| top-level / `fr/rakambda/overpoweredmending/common/config/real/ConfigLoader.java` | `` |  |  |
| top-level / `fr/rakambda/overpoweredmending/common/config/real/Configuration.java` | `` |  | read, onUpdate, getConfigPath, setSelectionMode, equals, canEqual, hashCode, toString |
| top-level / `fr/rakambda/overpoweredmending/common/inventory/IInventoryProvider.java` | `` |  |  |
| top-level / `fr/rakambda/overpoweredmending/common/inventory/PlayerInventoryProvider.java` | `` |  |  |
| top-level / `fr/rakambda/overpoweredmending/common/network/ClientPacketHandler.java` | `` |  |  |
| top-level / `fr/rakambda/overpoweredmending/common/network/ConfigurationPacket.java` | `` |  | get, write, read, builder, isDedicated, getSelectionMode, setDedicated, setSelectionMode, equals, canEqual, hashCode, toString, dedicated, selectionMode, build, toString |
| top-level / `fr/rakambda/overpoweredmending/common/network/PacketUtils.java` | `` |  | onClientConfigurationPacket, onClientDisconnect |
| top-level / `fr/rakambda/overpoweredmending/common/network/ServerPacketHandler.java` | `` |  |  |
| top-level / `fr/rakambda/overpoweredmending/common/OverpoweredMendingCommon.java` | `` |  | getConfiguration, addInventoryProvider, onXpPickedUp, getOwnConfiguration, getProxyConfiguration, getPacketUtils, getInventoryProviders |
| top-level / `fr/rakambda/overpoweredmending/common/wrapper/IEnchantment.java` | `` |  |  |
| top-level / `fr/rakambda/overpoweredmending/common/wrapper/IFriendlyByteBuf.java` | `` |  |  |
| top-level / `fr/rakambda/overpoweredmending/common/wrapper/IItemStack.java` | `` |  |  |
| top-level / `fr/rakambda/overpoweredmending/common/wrapper/IPlayer.java` | `` |  |  |
| top-level / `fr/rakambda/overpoweredmending/common/wrapper/IWrapper.java` | `` |  |  |
| top-level / `fr/rakambda/overpoweredmending/common/wrapper/IXpOrb.java` | `` |  |  |
| top-level / `fr/rakambda/overpoweredmending/fabric/client/event/PlayerLeaveListener.java` | `` |  | onPlayDisconnect |
| top-level / `fr/rakambda/overpoweredmending/fabric/client/ModMenuImpl.java` | `` |  |  |
| top-level / `fr/rakambda/overpoweredmending/fabric/client/network/FabricClientPacketHandler.java` | `` |  | registerClient |
| top-level / `fr/rakambda/overpoweredmending/fabric/client/OverpoweredMendingClient.java` | `` |  | onInitializeClient |
| top-level / `fr/rakambda/overpoweredmending/fabric/common/FriendlyByteBufWrapper.java` | `` |  | writeInteger, writeBoolean, readInteger, readBoolean, toString |
| top-level / `fr/rakambda/overpoweredmending/fabric/common/OverpoweredMendingCommonsImpl.java` | `` |  | register, getServerPacketHandler |
| top-level / `fr/rakambda/overpoweredmending/fabric/mixin/ExperienceOrbMixin.java` | `value={ExperienceOrb.class})` | Inject:1 | onPlayerCollision |
| top-level / `fr/rakambda/overpoweredmending/fabric/network/FabricServerPacketHandler.java` | `` |  | registerServer |
| top-level / `fr/rakambda/overpoweredmending/fabric/network/OverpoweredMendingConfigPacket.java` | `` |  | write, getPacket |
| top-level / `fr/rakambda/overpoweredmending/fabric/OverpoweredMending.java` | `` |  | onInitialize, getMod |
| top-level / `fr/rakambda/overpoweredmending/fabric/OverpoweredMendingUtils.java` | `` |  |  |
| top-level / `fr/rakambda/overpoweredmending/fabric/wrapper/ItemStackWrapper.java` | `` |  | hasMendingEnchant, getDamageValue, getMaxDamage, setDamageValue, isDamaged, isDamageableItem, isEmpty, toString |
| top-level / `fr/rakambda/overpoweredmending/fabric/wrapper/PlayerWrapper.java` | `` |  | addExperience, sendPickup, setExperiencePickUpDelay, toString |
| top-level / `fr/rakambda/overpoweredmending/fabric/wrapper/XpOrbWrapper.java` | `` |  | getExperienceAmount, getCount, setCount, discard, toString |
| top-level / `fr/rakambda/overpoweredmending/forge/client/event/PlayerLeaveListener.java` | `` |  | onPlayerLoggedOutEvent |
| top-level / `fr/rakambda/overpoweredmending/forge/common/OverpoweredMendingCommonsImpl.java` | `` |  | registerForge |
| top-level / `fr/rakambda/overpoweredmending/forge/common/wrapper/FriendlyByteBufWrapper.java` | `` |  | writeInteger, writeBoolean, readInteger, readBoolean, toString |
| top-level / `fr/rakambda/overpoweredmending/forge/common/wrapper/ItemStackWrapper.java` | `` |  | hasMendingEnchant, getDamageValue, getMaxDamage, setDamageValue, isDamaged, isDamageableItem, isEmpty, toString |
| top-level / `fr/rakambda/overpoweredmending/forge/common/wrapper/PlayerWrapper.java` | `` |  | addExperience, sendPickup, setExperiencePickUpDelay, toString |
| top-level / `fr/rakambda/overpoweredmending/forge/common/wrapper/XpOrbWrapper.java` | `` |  | getExperienceAmount, getCount, setCount, discard, toString |
| top-level / `fr/rakambda/overpoweredmending/forge/event/PlayerXpPickupEventHandler.java` | `` |  | onPlayerPickupXpEvent |
| top-level / `fr/rakambda/overpoweredmending/forge/network/ForgePacketHandler.java` | `` |  | registerServer, registerClient, handleConfigurationPacket |
| top-level / `fr/rakambda/overpoweredmending/forge/network/OverpoweredMendingConfigPacket.java` | `` |  | write, getPacket |
| top-level / `fr/rakambda/overpoweredmending/forge/network/PlayerJoinListener.java` | `` |  | onPlayerLoggedInEvent |
| top-level / `fr/rakambda/overpoweredmending/forge/OverpoweredMending.java` | `` |  | getMod |
| top-level / `fr/rakambda/overpoweredmending/forge/OverpoweredMendingUtils.java` | `` |  |  |
| top-level / `fr/rakambda/overpoweredmending/neoforge/client/event/PlayerLeaveListener.java` | `` |  | onPlayerLoggedOutEvent |
| top-level / `fr/rakambda/overpoweredmending/neoforge/common/OverpoweredMendingCommonsImpl.java` | `` |  | registerNeoForge |
| top-level / `fr/rakambda/overpoweredmending/neoforge/common/wrapper/FriendlyByteBufWrapper.java` | `` |  | writeInteger, writeBoolean, readInteger, readBoolean, toString |
| top-level / `fr/rakambda/overpoweredmending/neoforge/common/wrapper/ItemStackWrapper.java` | `` |  | hasMendingEnchant, getDamageValue, getMaxDamage, setDamageValue, isDamaged, isDamageableItem, isEmpty, toString |
| top-level / `fr/rakambda/overpoweredmending/neoforge/common/wrapper/PlayerWrapper.java` | `` |  | addExperience, sendPickup, setExperiencePickUpDelay, toString |
| top-level / `fr/rakambda/overpoweredmending/neoforge/common/wrapper/XpOrbWrapper.java` | `` |  | getExperienceAmount, getCount, setCount, discard, toString |
| top-level / `fr/rakambda/overpoweredmending/neoforge/event/PlayerXpPickupEventHandler.java` | `` |  | onPlayerPickupXpEvent |
| top-level / `fr/rakambda/overpoweredmending/neoforge/network/NeoForgePacketHandler.java` | `` |  | register, registerServer, registerClient |
| top-level / `fr/rakambda/overpoweredmending/neoforge/network/OverpoweredMendingConfigPacket.java` | `` |  | write, getPacket |
| top-level / `fr/rakambda/overpoweredmending/neoforge/OverpoweredMending.java` | `` |  | getMod |
| top-level / `fr/rakambda/overpoweredmending/neoforge/OverpoweredMendingUtils.java` | `` |  |  |

## Data-driven behavior

Resource category counts: `tags`: 1.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
