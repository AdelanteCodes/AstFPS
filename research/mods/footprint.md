# Footprint

Review status: **Evidence inventory; behavioral review pending**

Project: [Footprint](https://modrinth.com/mod/footprint)
Selected artifact version: `1.0.2-beta+26.3`
Published implementation source: https://github.com/JowhJy/footprint
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Server-side mod to keep world size down by not saving all chunks

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `70a703e2f7bee646064988f920dc0fb2bddb68bc3491d933cb33a5bcc43fb5ab54f84e7f00435f3c45efaf647b7fbb11363f1084d11dcd7ba989cdea96ea8c9a`
- `sha1`: `cc0b2b0717870f3e3b2b2bb1407ff1338bada042`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 22
Reconstructed Java files: 20

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.jowhjy.Footprint"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/jowhjy/ChunkGetter.java` | `` |  | forceSaveChunksAround |
| top-level / `com/jowhjy/config/FootprintConfigProvider.java` | `` |  | get, addKeyValuePairWithCommentAbove, addKeyValuePair, addComment, addNewline |
| top-level / `com/jowhjy/config/FootprintConfigs.java` | `` |  | registerConfigs, createConfigs, assignConfigs |
| top-level / `com/jowhjy/config/SimpleConfig.java` | `` |  | of, createConfig, loadConfig, parseConfigEntry, get, getOrDefault, getOrDefault, getOrDefault, getOrDefault, isBroken, delete, provider, request, getConfig, empty |
| top-level / `com/jowhjy/Footprint.java` | `` |  | onInitialize |
| top-level / `com/jowhjy/mixin/BaseContainerBlockEntity_Mixin.java` | `value={BaseContainerBlockEntity.class})` | Inject:1 | footprint$forceSaveOnContainerOpen |
| top-level / `com/jowhjy/mixin/BlockItem_Mixin.java` | `value={BlockItem.class})` | Inject:1 | footprint$forceSaveChunkOnBlockPlacedByPlayer |
| top-level / `com/jowhjy/mixin/ChunkAccess_Mixin.java` | `value={ChunkAccess.class})` |  | footprint$isForceSave, footprint$setForceSave |
| top-level / `com/jowhjy/mixin/ChunkMap_Mixin.java` | `value={ChunkMap.class})` | Inject:2 | footprint$chunkSavingConditions, footprint$clearEntitiesWhenUnloadingUnsavedChunk |
| top-level / `com/jowhjy/mixin/ChunkStatusTasks_Mixin.java` | `value={ChunkStatusTasks.class})` | Inject:1 | footprint$clearEntitiesWhenGeneratingEntities |
| top-level / `com/jowhjy/mixin/ItemEntity_Mixin.java` | `value={ItemEntity.class})` | Inject:1 | footprint$forceSaveChunkOnItemPickup |
| top-level / `com/jowhjy/mixin/LivingEntity_Mixin.java` | `value={LivingEntity.class})` | Inject:1 | footprint$alwaysSaveChunkOnEntityDamaged |
| top-level / `com/jowhjy/mixin/PersistentEntitySectionManager_Accessor.java` | `value={PersistentEntitySectionManager.class})` | Accessor:1 |  |
| top-level / `com/jowhjy/mixin/Player_Mixin.java` | `value={Player.class})` | Inject:1 | footprint$alwaysSaveChunkOnEntityInteract |
| top-level / `com/jowhjy/mixin/RandomizableContainerBlockEntity_Mixin.java` | `value={RandomizableContainerBlockEntity.class})` | Inject:1 | footprint$forceSaveOnContainerOpen |
| top-level / `com/jowhjy/mixin/SerializableChunkData_Mixin.java` | `value={SerializableChunkData.class})` | Inject:1 | footprint$alwaysSaveIfSavedBefore |
| top-level / `com/jowhjy/mixin/ServerLevel_Accessor.java` | `value={ServerLevel.class})` | Accessor:1 |  |
| top-level / `com/jowhjy/mixin/ServerPlayerEntity_Mixin.java` | `value={ServerPlayer.class})` | Inject:1 | footprint$alwaysSaveChunkOnItemDroppedByPlayer |
| top-level / `com/jowhjy/mixin/ServerPlayInteractionManager_Mixin.java` | `value={ServerPlayerGameMode.class})` | Inject:1 | footprint$forceSaveChunkOnBlockBrokenByPlayer |
| top-level / `com/jowhjy/mixin_interfaces/IChunkWithForcedSave.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
