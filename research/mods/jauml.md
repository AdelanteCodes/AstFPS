# Jauml

Review status: **Evidence inventory; behavioral review pending**

Project: [Jauml](https://modrinth.com/mod/jauml)
Selected artifact version: `2.3.1+fabric-26.3`
Published implementation source: https://github.com/MeherBenSalem/Jauml
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Jauml is a lightweight configuration library for Minecraft mods, designed to simplify JSON-based config management

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha512`: `9b45664bdddcaca5f762c5167b613608d59c0f94b8e2b4641ecc2e9cf744ece069a8d094cae3bf22da55b796461df8b12a9954a5f58e212929ff4bbbff397d11`
- `sha1`: `b4f10088f7668d2544d22d016ab8c40259d3a6b4`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 17
Reconstructed Java files: 17

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "tn.naizo.jauml.Jauml"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `tn/naizo/jauml/api/ConfigFile.java` | `` |  | reload, reloadIfChanged, updateFileSnapshot, loadFromDisk, handleCorruptedConfig, rotateBackups, save, exists, delete, path, configure, setSchema, setMigrator, setDefaultData, setBackupRotation, setStableSave, asJsonObject, getRoot, getByPath, setByPath, getStringByPath, getStringByPath, getIntByPath, getDoubleByPath, getBooleanByPath, getString, getString, getInt, getInt, getLong, getLong, getDouble, getDouble, getBoolean, getBoolean, set, set, set, set, set, getStringList, addToList, removeFromList, listContains, clearList, hasKey, keys, removeKey |
| top-level / `tn/naizo/jauml/api/JaumlConfig.java` | `` |  | isCompatible, loadPlatformProvider, open, open, open, open, open, configDirectory, platform, isModLoaded, invalidate, invalidate, clearCache |
| top-level / `tn/naizo/jauml/api/JaumlInitializer.java` | `` |  | initialize, initializeWithDemoConfig, runCompatibilityCheck, shouldWriteDemoConfig |
| top-level / `tn/naizo/jauml/api/JsonException.java` | `` |  |  |
| top-level / `tn/naizo/jauml/api/JsonLib.java` | `` |  | safeParse, safeParse, strictParse, stableStringify, sortJsonKeys, deepClone, getByPath, setByPath, merge, normalize, detectVersion, detectVersion |
| top-level / `tn/naizo/jauml/api/JsonMigrator.java` | `` |  | setPreferredVersionKey, getPreferredVersionKey, register, migrate, findPath, updateVersionKey |
| top-level / `tn/naizo/jauml/api/JsonSchema.java` | `` |  | parse, validate, isValid, validate, validateEnum, elementsEqual, checkType, getActualType |
| top-level / `tn/naizo/jauml/Constants.java` | `` |  |  |
| top-level / `tn/naizo/jauml/internal/PathValidator.java` | `` |  | resolveSafe |
| top-level / `tn/naizo/jauml/Jauml.java` | `` |  | onInitialize |
| top-level / `tn/naizo/jauml/JaumlConfigLib.java` | `` |  | createConfigFile, stringExistsInArray, arrayKeyExists, addStringToArray, configFileExists, getArrayLength, getArrayElement, getStringValue, getNumberValue, setStringValue, setNumberValue, getBooleanValue, setBooleanValue, clearArray, removeArrayElement, getArrayAsList, getStringValue, getNumberValue, getBooleanValue, getIntValue, getIntValue, getLongValue, getLongValue, setIntValue, setLongValue, deleteConfigFile, hasKey, getAllKeys, removeKey |
| top-level / `tn/naizo/jauml/platform/FabricPlatformHelper.java` | `` |  | getPlatformName, isModLoaded, isDevelopmentEnvironment, getConfigDirectory |
| top-level / `tn/naizo/jauml/spi/PlatformProvider.java` | `` |  |  |
| top-level / `tn/naizo/jauml/util/JaumlLogger.java` | `` |  | get, get |
| top-level / `tn/naizo/jauml/util/Lifecycle.java` | `` |  | requireCompatibleLibrary, onStartup |
| top-level / `tn/naizo/jauml/util/ModuleVersion.java` | `` |  | ModuleVersion, isCompatibleWith |
| top-level / `tn/naizo/jauml/util/PlatformUtil.java` | `` |  | platformName, configDir, isModLoaded, isDevelopmentEnvironment |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
