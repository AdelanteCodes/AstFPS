# LightAura

Review status: **Evidence inventory; behavioral review pending**

Project: [LightAura](https://modrinth.com/mod/lightaura)
Selected artifact version: `8.9.7`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A mod that makes the player holding any light source, such as a torch , glowstone, etc, automatically illuminate the surrounding area.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `e4893e1721531082d17774a765246e477d638bbe69cbc29f299c3ddaf7a0e69394c72cdc5eac2445382267a8f0d041923850e606d2c56efd5fe3e467dad12c70`
- `sha1`: `e100e853f7ca852ca111948e098a2edbd56e34ad`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 17
Reconstructed Java files: 11

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.osama.lightaura.LightAuraMod"
  ],
  "client": [
    "com.osama.lightaura.client.LightAuraClient"
  ],
  "fabric-datagen": [
    "com.osama.lightaura.client.LightAuraDataGenerator"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/osama/lightaura/client/LightAuraClient.java` | `` |  | onInitializeClient |
| top-level / `com/osama/lightaura/client/LightAuraDataGenerator.java` | `` |  | onInitializeDataGenerator |
| top-level / `com/osama/lightaura/client/mixin/ExampleClientMixin.java` | `value={Minecraft.class})` | Inject:1 | init |
| top-level / `com/osama/lightaura/client/mixin/LightmapMixin.java` | `value={Minecraft.class})` |  |  |
| top-level / `com/osama/lightaura/ClientEventHandler.java` | `` |  | updateLightItems, onClientTick, cleanupExcessLights, updatePlayerLightLevel, getLightLevel, handlePlayerLighting, applyFlickerEffect, addLightPosition, isBlacklistedBlock, getAdjacentPositions, isAirOrLightBlock, isPlantBlock, isInNonSolidBlock, canHostDynamicLight, handleDroppedItemLighting, refreshDroppedItemLight, hasActiveEntityLight, findSuitableLightPosition, calculateStackedLightLevel, handleSmoothTransitions, cleanupLights, placeLight, placeLight, setDynamicLight, removeLight, removePlayerLight, restoreTrackedItemLightAt, applyLightUpdates, logPerformanceMetrics, reloadConfig, getActiveLightCount, getDroppedItemLightCount |
| top-level / `com/osama/lightaura/DroppedItemLight.java` | `` |  | packChunkKey |
| top-level / `com/osama/lightaura/DynamicLightManager.java` | `` |  | getLight, setLight, removeLight, clear |
| top-level / `com/osama/lightaura/LightAuraConfig.java` | `` |  | init, loadConfig, loadFromProperties, loadLightItems, compileLightItems, validateConfig, saveConfig, generateConfigHeader, migrateNewOptions, putIfMissing, setDefaults, getDefaultLightItems, getIntProperty, getDoubleProperty, getBooleanProperty, logConfigSummary, getLightItems, reloadConfig, isBlacklistedBlock, addLightItem, removeLightItem |
| top-level / `com/osama/lightaura/LightAuraMod.java` | `` |  | onInitialize |
| top-level / `com/osama/lightaura/LightSource.java` | `` |  |  |
| top-level / `com/osama/lightaura/mixin/BlockLightEngineMixin.java` | `value={BlockLightEngine.class})` | Inject:1 | lightaura$getDynamicEmission |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
