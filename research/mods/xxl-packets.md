# XXL Packets

Review status: **Behavioral static review**

Project: [XXL Packets](https://modrinth.com/mod/xxl-packets)
Selected artifact version: `1.0.6-26.x.x-fabric`
Published implementation source: https://github.com/lazul1ne/XXLPackets
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

XXL Packets is a fork of XL Packets which raises the packet size limit from 2MB to the Java Integer limit (2.147483647 GB).

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `optional`.

Artifact identity:
- `sha1`: `34e7ee1a82c575ed676a24993dd7dfa2628c03b5`
- `sha512`: `9fc6eda261ebeb3a972d36fdbc10be654c182574ec3950baf7f721b1f131e699d47b4be1a8326b90e2c37a3a895c20be514f14b2cf6b3736b3a904b9f47920bd`

## Reviewed mechanism

All four reconstructed mixin classes reviewed.

- Changes selected constants in custom payload construction, packet encoding, compression decoding, and NBT reading from their existing megabyte-sized budgets to Integer.MAX_VALUE.
- The NBT replacement is a long constant carrying the same enlarged budget. No faster compression, allocation reuse, or packet batching algorithm is present in these classes.

## Lifecycle, correctness, and failure questions

- Larger accepted data can trigger much larger allocations and processing times. Matching exact constants can affect different checks after a version update.
- Client/server protocol and transport limits can still reject enlarged packets. Removing a budget does not make large transfers efficient.

## Checks needed to establish equivalence

- Verify oversized valid and malformed input behavior, bounded memory use, compression expansion, NBT nesting limits, and peer compatibility.

## Relevance to AstFPS

Large-payload compatibility; not an FPS optimization and unsuitable as a general performance default.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 4
Reconstructed Java files: 4

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": []
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "fabric-api": "*",
  "minecraft": ">=26.1",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `tfar/xlpackets/mixin/ClientboundCustomPayloadPacketMixin.java` | `value={ClientboundCustomPayloadPacket.class})` | ModifyConstant:1 | xlPackets |
| top-level / `tfar/xlpackets/mixin/CompressionDecoderMixin.java` | `value={CompressionDecoder.class})` | ModifyConstant:1 | xlPackets |
| top-level / `tfar/xlpackets/mixin/PackeEncoderMixin.java` | `value={PacketEncoder.class})` | ModifyConstant:1 | xlPackets |
| top-level / `tfar/xlpackets/mixin/PacketByteBufMixin.java` | `value={FriendlyByteBuf.class})` | ModifyConstant:1 | xlPackets |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
