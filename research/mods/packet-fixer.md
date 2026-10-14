# Packet Fixer

Review status: **Evidence inventory; behavioral review pending**

Project: [Packet Fixer](https://modrinth.com/mod/packet-fixer)
Selected artifact version: `3.3.6`
Published implementation source: https://github.com/TonimatasDEV/PacketFixer
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A simple mod to fix various problems with packets, nbt and timeouts.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha512`: `8d3139b150ef591c62b086f553be212bc72eb4a32b0b1f8bb5cc069a9b79a85046d31b1147e5aaff23e4b69bb92c76445d41884657a7b652def25e2b73d61613`
- `sha1`: `a71fcdee677e23583da12b9237ab165ae7a0c8b0`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 29
Reconstructed Java files: 29

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "dev.tonimatas.packetfixer.fabric.PacketFixerFabric"
  ]
}
```

**depends**

```json
{
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `architectury_inject_PacketFixer_common_c536fb86fb1d455e8484976b71b0bb52_dc61d5666d628c7679f37e580802b3d399a82ad542982d483691678d96c9e08fPacketFixercommon336devjar/PlatformMethods.java` | `` |  | getCurrentTarget |
| top-level / `dev/tonimatas/packetfixer/fabric/mixins/FabricMixinConfig.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `dev/tonimatas/packetfixer/fabric/mixins/PayloadHelperMixin.java` | `value={PayloadHelper.class})` | Inject:1 | packetfixer$newSize |
| top-level / `dev/tonimatas/packetfixer/fabric/PacketFixerFabric.java` | `` |  | onInitialize |
| top-level / `dev/tonimatas/packetfixer/fabric/platform/FabricPlatformHelper.java` | `` |  | getPlatformName, getModVersion, isModEnabled |
| top-level / `dev/tonimatas/packetfixer/mixins/ClientboundCustomPayloadPacketMixin.java` | `value={ClientboundCustomPayloadPacket.class})` | ModifyConstant:2 | packetfixer$newSize, packetfixer$newSize$2 |
| top-level / `dev/tonimatas/packetfixer/mixins/ClientboundCustomQueryPacketMixin.java` | `value={ClientboundCustomQueryPacket.class})` | ModifyConstant:2 | packetfixer$newSize, packetfixer$newSize |
| top-level / `dev/tonimatas/packetfixer/mixins/ClientboundLevelChunkPacketDataMixin.java` | `value={ClientboundLevelChunkPacketData.class})` | ModifyConstant:1 | packetfixer$newSize |
| top-level / `dev/tonimatas/packetfixer/mixins/CommonMixinPlugin.java` | `` |  | onLoad, shouldApplyMixin |
| top-level / `dev/tonimatas/packetfixer/mixins/CompressionDecoderMixin.java` | `value={CompressionDecoder.class})` | ModifyConstant:1 | packetfixer$newSize |
| top-level / `dev/tonimatas/packetfixer/mixins/CompressionEncoderMixin.java` | `value={CompressionEncoder.class})` | ModifyConstant:1 | packetfixer$newSize |
| top-level / `dev/tonimatas/packetfixer/mixins/ConnectionMixin.java` | `targets={"net.minecraft.network.Connection$1"})` | ModifyConstant:1 | packetfixer$newTimeout |
| top-level / `dev/tonimatas/packetfixer/mixins/FriendlyByteBufMixin.java` | `value={FriendlyByteBuf.class})` | ModifyConstant:3 | packetfixer$readUtf$newSize, packetfixer$writeUtf$newSize, packetfixer$readResourceLocation$newSize |
| top-level / `dev/tonimatas/packetfixer/mixins/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Redirect:1 | packetfixer$playerIdleTimeout |
| top-level / `dev/tonimatas/packetfixer/mixins/NbtAccounterMixin.java` | `value={NbtAccounter.class})` | Redirect:1, ModifyConstant:1 | packetfixer$newSize, packetfixer$defaultQuota$newSize |
| top-level / `dev/tonimatas/packetfixer/mixins/ServerboundCustomPayloadPacketMixin.java` | `value={ServerboundCustomPayloadPacket.class})` | ModifyConstant:1 | packetfixer$newSize |
| top-level / `dev/tonimatas/packetfixer/mixins/ServerboundCustomQueryPacketMixin.java` | `value={ServerboundCustomQueryAnswerPacket.class})` | ModifyConstant:2 | packetfixer$newSize, packetfixer$newMessage |
| top-level / `dev/tonimatas/packetfixer/mixins/ServerCommonPacketListenerImplMixin.java` | `value={ServerCommonPacketListenerImpl.class})` | ModifyConstant:2 | packetfixer$tick$1, packetfixer$checkIfClosed |
| top-level / `dev/tonimatas/packetfixer/mixins/ServerConnectionListenerMixin.java` | `targets={"net.minecraft.server.network.ServerConnectionListener$1"})` | ModifyConstant:1 | packetfixer$newTimeout |
| top-level / `dev/tonimatas/packetfixer/mixins/ServerLoginPacketListenerImplMixin.java` | `value={ServerLoginPacketListenerImpl.class})` | ModifyConstant:1 | packetfixer$tick |
| top-level / `dev/tonimatas/packetfixer/mixins/Varint21FrameDecoderMixin.java` | `value={Varint21FrameDecoder.class})` | Inject:1, ModifyConstant:1 | packetfixer$checkSize, packetfixer$newSize |
| top-level / `dev/tonimatas/packetfixer/mixins/Varint21LengthFieldPrependerMixin.java` | `value={Varint21LengthFieldPrepender.class})` | ModifyConstant:1 | packetfixer$newSize |
| top-level / `dev/tonimatas/packetfixer/mixins/VarIntMixin.java` | `value={VarInt.class})` | ModifyConstant:3 | packetfixer$getByteSize$newSize, packetfixer$read$newSize, packetfixer$read$newSize |
| top-level / `dev/tonimatas/packetfixer/mixins/VarLongMixin.java` | `value={VarLong.class})` | ModifyConstant:3 | packetfixer$getByteSize$newSize, packetfixer$read$newSize, packetfixer$read$newSize |
| top-level / `dev/tonimatas/packetfixer/PacketFixer.java` | `` |  | init |
| top-level / `dev/tonimatas/packetfixer/platform/services/IPlatformHelper.java` | `` |  |  |
| top-level / `dev/tonimatas/packetfixer/platform/Services.java` | `` |  | load |
| top-level / `dev/tonimatas/packetfixer/util/Config.java` | `` |  | runProperties, getNbtMaxSize, getPacketSize, getDecoderSize, getVarInt21Size, getVarIntSize, getVarLong, getStringSize, getChunkPacketData, getReadTimeout, getLoginTimeout, getKeepAliveTimeout, getPlayerIdleTimeout, isForceUnlimitedNbtEnabled, checkVariable, save |
| top-level / `dev/tonimatas/packetfixer/util/Messages.java` | `` |  | getPayloadMessage |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
