# Entity View Distance

Review status: **Evidence inventory; behavioral review pending**

Project: [Entity View Distance](https://modrinth.com/mod/entity-view-distance)
Selected artifact version: `1.9.0+26.2`
Published implementation source: https://github.com/Patbox/EntityViewDistance
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This mods allows more precise manipulation of entity view distance on client and server

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha512`: `0a31a8659c163ec241208f0494e3f5b8902bde9773b4ac68bb68a3b023c1fd5953bfd955f059f2f8cb2d790259f0bd6e4f62621339185881f20e8b5631f6a4ea`
- `sha1`: `09ee9afdd2061b2c466ecb88390fc902e2df5645`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 31
Reconstructed Java files: 24

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "eu.pb4.entityviewdistance.EVDMod"
  ],
  "client": [
    "eu.pb4.entityviewdistance.EVDMod"
  ],
  "server": [
    "eu.pb4.entityviewdistance.EVDMod"
  ],
  "preLaunch": [
    "eu.pb4.entityviewdistance.CardboardWarning"
  ],
  "modmenu": [
    "eu.pb4.entityviewdistance.modcompat.ModMenuCompat"
  ],
  "sodium:config_api_user": [
    "eu.pb4.entityviewdistance.modcompat.SodiumCompat"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.14.4",
  "fabric-api": "*",
  "minecraft": ">=26.1-",
  "java": ">=25"
}
```

**accessWidener**

```json
"entityviewdistance.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `eu/pb4/entityviewdistance/CardboardWarning.java` | `` |  | onPreLaunch, checkAndAnnounce |
| top-level / `eu/pb4/entityviewdistance/config/Config.java` | `` |  | toConfigData |
| top-level / `eu/pb4/entityviewdistance/config/ConfigManager.java` | `` |  | getConfig, loadConfig, overrideConfig, overrideConfig |
| top-level / `eu/pb4/entityviewdistance/config/data/ConfigData.java` | `` |  |  |
| top-level / `eu/pb4/entityviewdistance/config/data/VersionConfigData.java` | `` |  |  |
| top-level / `eu/pb4/entityviewdistance/config/EvdOverrideSide.java` | `` |  |  |
| top-level / `eu/pb4/entityviewdistance/EvdCommands.java` | `` |  | register, getEntity, setEntity, reloadConfig, about |
| top-level / `eu/pb4/entityviewdistance/EVDMod.java` | `` |  | onInitialize, onInitializeClient, onInitializeServer |
| top-level / `eu/pb4/entityviewdistance/EvdUtils.java` | `` |  | getText, getKey, id, initialize, updateAll, updateServer |
| top-level / `eu/pb4/entityviewdistance/interfaces/EvdEntityType.java` | `` |  |  |
| top-level / `eu/pb4/entityviewdistance/mixin/ChunkMapAccessor.java` | `value={ChunkMap.class})` | Accessor:1 |  |
| top-level / `eu/pb4/entityviewdistance/mixin/ChunkMapMixin.java` | `value={ChunkMap.class})` | ModifyVariable:1 | evd_replaceDistance |
| top-level / `eu/pb4/entityviewdistance/mixin/client/EntityRenderDispatcherMixin.java` | `value={EntityRenderDispatcher.class})` | ModifyExpressionValue:2 | replaceMap, replaceMap2 |
| top-level / `eu/pb4/entityviewdistance/mixin/client/VideoSettingsScreenMixin.java` | `value={VideoSettingsScreen.class})` | Redirect:1 | entityViewDistance_addOptionButton, createButton, validateValue, codec |
| top-level / `eu/pb4/entityviewdistance/mixin/EditBoxAccessor.java` | `value={EditBox.class})` | Accessor:3, Invoker:1 |  |
| top-level / `eu/pb4/entityviewdistance/mixin/EntityMixin.java` | `value={Entity.class})` | Inject:1 | evd_shouldRender |
| top-level / `eu/pb4/entityviewdistance/mixin/EntityTypeMixin.java` | `value={EntityType.class})` |  | evd_getTrackingDistance, evd_setTrackingDistance |
| top-level / `eu/pb4/entityviewdistance/mixin/TrackedEntityAccessor.java` | `value={ChunkMap.TrackedEntity.class})` | Accessor:2 |  |
| top-level / `eu/pb4/entityviewdistance/modcompat/FabricPermissionBridge.java` | `` |  | checkPermission, checkPermission, checkPermission, checkPermission, require, require |
| top-level / `eu/pb4/entityviewdistance/modcompat/ModMenuCompat.java` | `` |  | getModConfigScreenFactory |
| top-level / `eu/pb4/entityviewdistance/modcompat/SodiumCompat.java` | `` |  | registerConfigLate |
| top-level / `eu/pb4/entityviewdistance/screen/EvdSettingsScreen.java` | `` |  | init, initHeader, initBody, initFooter, initTabNavigation, removed, onClose, updateOptions, saveChanges, addEntry, clearEntries, getRowWidth, create, extractContent, children, narratables, setPos, extract, children, narratables, getHeight, extractContent, extractContent, children, narratables |
| top-level / `eu/pb4/entityviewdistance/screen/EvdValueModifierOption.java` | `` |  | setFocused, insertText, getDefault, getValue, setValue, getActiveText, extractContent, narratables, children |
| top-level / `eu/pb4/entityviewdistance/screen/SpruceSeparatorWidget.java` | `` |  | getTitle, setTitle, extractWidgetRenderState, updateWidgetNarration |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
