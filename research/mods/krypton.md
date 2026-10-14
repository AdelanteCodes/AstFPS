# Krypton

Review status: **Evidence inventory; behavioral review pending**

Project: [Krypton](https://modrinth.com/mod/krypton)
Selected artifact version: `0.3.2`
Published implementation source: https://github.com/astei/krypton
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A mod to optimize the Minecraft networking stack

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `21b21cb88e412f0bce73b6609de6dd6aca958d7d`
- `sha512`: `d1d57ebd41395b75b01f130cd9503eb8d208212424a399ff9f367f50be8fbc1c6472442b33c686e777c3148f6a609520e8fb732c755157c358cb207fd4d1123a`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 25
Reconstructed Java files: 25

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "me.steinborn.krypton.mod.client.KryptonClientInitializer"
  ],
  "server": [
    "me.steinborn.krypton.mod.server.KryptonServerInitializer"
  ],
  "main": [
    "me.steinborn.krypton.mod.shared.KryptonSharedInitializer"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "minecraft": ">=26.2"
}
```

**accessWidener**

```json
"krypton.accesswidener"
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/velocity-native-3.4.0-SNAPSHOT.jar` | 25 | `com_velocitypowered_velocity-native` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/steinborn/krypton/mixin/shared/debugaid/ResourceLeakDetectorDisableConditionalMixin.java` | `value={SharedConstants.class})` | Redirect:1 | clinit$resourceLeakDetectorDisableConditional |
| top-level / `me/steinborn/krypton/mixin/shared/network/microopt/ServerEntityMixin.java` | `value={ServerEntity.class})` | Redirect:1 | construct$initialPassengersListIsGuavaImmutableList |
| top-level / `me/steinborn/krypton/mixin/shared/network/microopt/Utf8StringMixin.java` | `value={Utf8String.class})` | Overwrite:1 | write |
| top-level / `me/steinborn/krypton/mixin/shared/network/microopt/VarIntMixin.java` | `value={VarInt.class})` | Overwrite:2 | getByteSize, write, writeVarIntFull |
| top-level / `me/steinborn/krypton/mixin/shared/network/pipeline/compression/ConnectionMixin.java` | `value={Connection.class})` | Inject:1 | setupCompression, isKryptonOrVanillaDecompressor, isKryptonOrVanillaCompressor |
| top-level / `me/steinborn/krypton/mixin/shared/network/pipeline/encryption/ConnectionMixin.java` | `value={Connection.class})` |  | setupEncryption |
| top-level / `me/steinborn/krypton/mixin/shared/network/pipeline/encryption/ServerLoginPacketListenerImplMixin.java` | `value={ServerLoginPacketListenerImpl.class})` | Redirect:2 | onKey$initializeVelocityCipher, onKey$ignoreMinecraftEncryptionPipelineInjection |
| top-level / `me/steinborn/krypton/mixin/shared/network/pipeline/LegacyQueryHandlerMixin.java` | `value={LegacyQueryHandler.class})` | Inject:1 | channelRead |
| top-level / `me/steinborn/krypton/mixin/shared/network/pipeline/prepender/ConnectionMixin.java` | `value={Connection.class})` | Overwrite:1 | createFrameEncoder |
| top-level / `me/steinborn/krypton/mixin/shared/network/pipeline/Varint21FrameDecoderMixin.java` | `value={Varint21FrameDecoder.class})` | Overwrite:1 | decode, readRawVarInt21, readRawVarintSmallBuf |
| top-level / `me/steinborn/krypton/mod/client/KryptonClientInitializer.java` | `` |  | onInitializeClient |
| top-level / `me/steinborn/krypton/mod/server/KryptonServerInitializer.java` | `` |  | onInitializeServer |
| top-level / `me/steinborn/krypton/mod/shared/KryptonMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `me/steinborn/krypton/mod/shared/KryptonSharedInitializer.java` | `` |  | onInitialize |
| top-level / `me/steinborn/krypton/mod/shared/misc/KryptonPipelineEvent.java` | `` |  |  |
| top-level / `me/steinborn/krypton/mod/shared/network/ClientConnectionEncryptionExtension.java` | `` |  |  |
| top-level / `me/steinborn/krypton/mod/shared/network/compression/MinecraftCompressDecoder.java` | `` |  | decode, handlerRemoved, setThreshold |
| top-level / `me/steinborn/krypton/mod/shared/network/compression/MinecraftCompressEncoder.java` | `` |  | encode, allocateBuffer, handlerRemoved, setThreshold |
| top-level / `me/steinborn/krypton/mod/shared/network/ConfigurableAutoFlush.java` | `` |  |  |
| top-level / `me/steinborn/krypton/mod/shared/network/pipeline/MinecraftCipherDecoder.java` | `` |  | decode, handlerRemoved |
| top-level / `me/steinborn/krypton/mod/shared/network/pipeline/MinecraftCipherEncoder.java` | `` |  | encode, handlerRemoved |
| top-level / `me/steinborn/krypton/mod/shared/network/pipeline/MinecraftVarintPrepender.java` | `` |  | encode |
| top-level / `me/steinborn/krypton/mod/shared/network/util/QuietDecoderException.java` | `` |  | fillInStackTrace |
| top-level / `me/steinborn/krypton/mod/shared/network/util/VarIntUtil.java` | `` |  | getVarIntLength |
| top-level / `me/steinborn/krypton/mod/shared/network/util/WellKnownExceptions.java` | `` |  | values, valueOf |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
