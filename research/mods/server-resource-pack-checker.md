# Server Resourcepack Checker

Review status: **Evidence inventory; behavioral review pending**

Project: [Server Resourcepack Checker](https://modrinth.com/mod/server-resource-pack-checker)
Selected artifact version: `fabric-1.2.2+26.3`
Published implementation source: https://github.com/henkelmax/server-resourcepack-checker
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Only load server resource packs when necessary

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `5b5c8bed3ab3edbccd52f1018de777d4f7e440adde0afb042be4148748705a2cf11526303022d03b9a23f63b0f6be0f772210adaa224b0876256dbf15a5801e1`
- `sha1`: `ce97f5fe908011cbb2d0a9bec59288e7e50b2cea`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 58
Reconstructed Java files: 49

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "de.maxhenkel.resourcepackchecker.ResourcePackChecker"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": "26.3.x"
}
```

**breaks**

```json
{
  "fabric-api": "<0.160.5+26.3"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/fabric-api-base-2.0.6+fcdff87f02.jar` | 17 | `fabric-api-base` | No |
| `META-INF/jars/fabric-resource-loader-v1-3.0.4+fcdff87f02.jar` | 77 | `fabric-resource-loader-v1` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `de/maxhenkel/resourcepackchecker/ClientConfig.java` | `` |  |  |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/CommentedProperties.java` | `` |  | addHeaderComment, setHeaderComments, get, getComments, setComments, set, load, readLine, readEscapedCharacter, isWhitespace, isSeparator, save, removeNewLines, escapeKey, escapeValue, escape, size, isEmpty, containsKey, containsValue, get, put, remove, putAll, clear, keySet, values, entrySet, fromInputStream, nextLine, close |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/CommentedPropertyConfig.java` | `` |  | builder, get, set, getProperties, load, reload, saveSync, save, getEntries, path, strict, build |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/Config.java` | `` |  |  |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/ConfigBuilder.java` | `` |  | builder, path, addValueSerializer, removeUnused, strict, keepOrder, saveAfterBuild, saveSyncAfterBuild, build |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/ConfigBuilderImpl.java` | `` |  | header, booleanEntry, integerEntry, longEntry, doubleEntry, floatEntry, stringEntry, enumEntry, entry, entryInternal, getDefaultValueSerializers |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/custom/AbstractValueList.java` | `` |  | size, isEmpty, contains, iterator, toArray, toArray, add, remove, containsAll, addAll, addAll, removeAll, retainAll, clear, get, set, add, remove, indexOf, lastIndexOf, listIterator, listIterator, subList, equals, hashCode, throwException |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/custom/AbstractValueMap.java` | `` |  | size, isEmpty, containsKey, containsValue, get, put, remove, putAll, clear, keySet, values, entrySet, equals, hashCode, throwException, put, putAll |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/custom/IntegerList.java` | `` |  | of, of |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/custom/serializer/IntegerListValueSerializer.java` | `` |  | deserialize, serialize |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/custom/serializer/StringListValueSerializer.java` | `` |  | deserialize, serialize |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/custom/serializer/StringMapValueSerializer.java` | `` |  | deserialize, serialize, escape, unescape |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/custom/serializer/UUIDSerializer.java` | `` |  | deserialize, serialize |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/custom/StringList.java` | `` |  | of, of |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/custom/StringMap.java` | `` |  | of, of, builder, build |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/AbstractConfigEntry.java` | `` |  | reload, get, set, getKey, comment, getComments, reset, syncEntryToProperties, save, saveSync, getDefault, getConfig, getSerializer |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/AbstractRangedConfigEntry.java` | `` |  | getMin, getMax |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/BooleanConfigEntry.java` | `` |  |  |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/ConfigEntry.java` | `` |  |  |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/DoubleConfigEntry.java` | `` |  |  |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/EnumConfigEntry.java` | `` |  |  |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/FloatConfigEntry.java` | `` |  |  |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/GenericConfigEntry.java` | `` |  |  |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/IntegerConfigEntry.java` | `` |  |  |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/LongConfigEntry.java` | `` |  |  |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/RangedConfigEntry.java` | `` |  |  |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/serializer/BooleanSerializer.java` | `` |  | deserialize, serialize |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/serializer/DoubleSerializer.java` | `` |  | deserialize, serialize |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/serializer/EnumSerializer.java` | `` |  | deserialize, serialize |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/serializer/FloatSerializer.java` | `` |  | deserialize, serialize |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/serializer/IntegerSerializer.java` | `` |  | deserialize, serialize |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/serializer/LongSerializer.java` | `` |  | deserialize, serialize |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/serializer/StringSerializer.java` | `` |  | deserialize, serialize |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/serializer/ValueSerializable.java` | `` |  |  |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/serializer/ValueSerializer.java` | `` |  |  |
| top-level / `de/maxhenkel/resourcepackchecker/configbuilder/entry/StringConfigEntry.java` | `` |  |  |
| top-level / `de/maxhenkel/resourcepackchecker/interfaces/ClearableServerPackManager.java` | `` |  |  |
| top-level / `de/maxhenkel/resourcepackchecker/interfaces/FilePackResource.java` | `` |  |  |
| top-level / `de/maxhenkel/resourcepackchecker/interfaces/PackRepository.java` | `` |  |  |
| top-level / `de/maxhenkel/resourcepackchecker/mixin/ClientCommonPacketListenerImplMixin.java` | `value={ClientCommonPacketListenerImpl.class})` | Inject:2 | setServerPack, handleResourcePack, sendSuccessful |
| top-level / `de/maxhenkel/resourcepackchecker/mixin/DownloadedPackSourceMixin.java` | `value={DownloadedPackSource.class})` | Inject:1 | handleResourcePack |
| top-level / `de/maxhenkel/resourcepackchecker/mixin/FilePackResourcesMixin.java` | `value={FilePackResources.class})` |  | resourcepack_checker$getFile |
| top-level / `de/maxhenkel/resourcepackchecker/mixin/OverlayedPackResourcesMixin.java` | `value={OverlayedPackResources.class})` |  | resourcepack_checker$getFile |
| top-level / `de/maxhenkel/resourcepackchecker/mixin/PackRepositoryMixin.java` | `value={PackRepository.class}, priority=0)` |  | resourcepack_checker$addSource |
| top-level / `de/maxhenkel/resourcepackchecker/mixin/ServerPackManagerMixin.java` | `value={ServerPackManager.class})` |  | resourcepack_checker$clear |
| top-level / `de/maxhenkel/resourcepackchecker/repository/ServerPacksCacheRepositorySource.java` | `` |  | loadPacks, load, fileToPack, cachedPackName, isCached, idFromHash |
| top-level / `de/maxhenkel/resourcepackchecker/ResourcePackChecker.java` | `` |  | onInitializeClient |
| top-level / `de/maxhenkel/resourcepackchecker/utils/ApplyPackUtils.java` | `` |  | equipPack, equipPack, equipPack |
| top-level / `de/maxhenkel/resourcepackchecker/utils/ShaUtils.java` | `` |  | getSha1 |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
