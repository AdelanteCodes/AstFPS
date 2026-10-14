# NotEnoughPalette

Review status: **Evidence inventory; behavioral review pending**

Project: [NotEnoughPalette](https://modrinth.com/mod/notenoughpalette)
Selected artifact version: `0.3.0`
Published implementation source: https://github.com/NativeThreading/NotEnoughPalette
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Optimize Minecraft's PalettedContainer

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `4242c7ece04044191395de8ccc506eeaf9b6390b`
- `sha512`: `178af0d7bb48ac5a4308cf83a14a8fe9fc8795d002c8fc96a7c4eccc6ec2cada504f51e26273a142c36abab6685daeae349e16b24f3564254d0c7aa6cc7ec711`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 12
Reconstructed Java files: 5

**environment**

```json
"*"
```

**entrypoints**

```json
{}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/github/uright008/nep/compat/SodiumMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `com/github/uright008/nep/mixin/PalettedContainerFactoryMixin.java` | `value={PalettedContainerFactory.class})` | Inject:2 | nep$createOptimizedBlockStateContainer, nep$createOptimizedBiomeContainer |
| top-level / `com/github/uright008/nep/mixin/PalettedContainerMixin.java` | `value={PalettedContainer.class})` | Inject:1 | nep$unpackOptimizedContainer |
| top-level / `com/github/uright008/nep/mixin/SodiumPalettedContainerExtensionMixin.java` | `value={OptimizedPalettedContainer.class}, priority=1001)` |  | nep$sodium$unpack, nep$sodium$unpack, nep$sodium$copy |
| top-level / `com/github/uright008/nep/palette/OptimizedPalettedContainer.java` | `` |  | unpack, onResize, getAndSet, getAndSetUnchecked, set, get, get, getAll, fillArray, read, write, pack, getSerializedSize, bitsPerEntry, maybeHas, forEachInPalette, count, copy, isUniformAir, entryCount, maxIndirectBits, tracksAir, recreate, getAndSet, set, isAir, growFor, storageFromLocalIds, globalStorageFromIds, containsIdentity, maxIndirectPaletteSize, storageBitsForWire, packedStorageBits, inferStorageBits, ceilLog2, compactGlobal, buildCounts, copyCounts, decrement, incrementOrDrop, incrementOrDrop, indirectBits, requireBits, storageLongs, packBits, packBits, valueAt, idFor, idForExisting, setId, getAll, maybeHas, forEachInPalette, count, write, pack, serializedSize, bits, copy, paletteValues, copyInto, copyInto, bits, idAt, setCellId, cellCount, fill, expandToBytes, valueAt, idFor, idForExisting, setId, getAll, maybeHas, forEachInPalette, count, write, pack, serializedSize, bits, copy, paletteValues, copyInto, copyInto, find, addPaletteEntry, ensurePaletteCapacity, writeAsGlobal, toIntIds, valueAt, idFor, idForExisting, setId, getAll, maybeHas, forEachInPalette, count, write, pack, serializedSize, bits, copy, paletteValues, copyInto, copyInto, setGlobalId, fill, updateCount, toIntIds, valueAt, idFor, idForExisting, setId, getAll, maybeHas, forEachInPalette, count, write, pack, serializedSize, bits, copy, paletteValues, copyInto, copyInto, setGlobalId, fill, updateCount, create |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
