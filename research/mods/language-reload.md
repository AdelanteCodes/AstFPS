# Language Reload

Review status: **Evidence inventory; behavioral review pending**

Project: [Language Reload](https://modrinth.com/mod/language-reload)
Selected artifact version: `1.7.8+26.3`
Published implementation source: https://github.com/Jerozgen/LanguageReload
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Reduces load times and adds fallbacks for languages

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `e6fd2df83d1d3d0f352a7e45eaf76f4551c136f2`
- `sha512`: `6366596875e9fa33b6b8119d08e5c18f3514662e319a735cedc8addb00bff4cf3179f3a33533b2070c1ddd776f23e6a5f22b69d0da0589f3091f0db9eead1d43`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 37
Reconstructed Java files: 33

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "jerozgen.languagereload.LanguageReload"
  ],
  "modmenu": [
    "jerozgen.languagereload.config.ModMenuEntrypoint"
  ]
}
```

**depends**

```json
{
  "fabric-resource-loader-v0": "*",
  "fabric-key-mapping-api-v1": "*",
  "fabric-lifecycle-events-v1": "*",
  "fabricloader": ">=0.19.0",
  "minecraft": ">=26.3"
}
```

**accessWidener**

```json
"languagereload.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `jerozgen/languagereload/access/IAdvancementsScreen.java` | `` |  |  |
| top-level / `jerozgen/languagereload/access/IAdvancementsTab.java` | `` |  |  |
| top-level / `jerozgen/languagereload/access/IClientLanguage.java` | `` |  |  |
| top-level / `jerozgen/languagereload/access/ILanguage.java` | `` |  |  |
| top-level / `jerozgen/languagereload/access/ILanguageSelectScreen.java` | `` |  |  |
| top-level / `jerozgen/languagereload/config/Config.java` | `` |  | load, save, getInstance, migrateToVersion1 |
| top-level / `jerozgen/languagereload/config/ConfigScreen.java` | `` |  | addOptions |
| top-level / `jerozgen/languagereload/config/ModMenuEntrypoint.java` | `` |  | getModConfigScreenFactory |
| top-level / `jerozgen/languagereload/gui/HeaderEntry.java` | `` |  | extractContent, mouseClicked, getNarration, getCode |
| top-level / `jerozgen/languagereload/gui/LanguageEntry.java` | `` |  | addButton, isDefault, isSelected, isFirst, isLast, toggle, moveUp, moveDown, extractContent, extractButtons, extractDefaultLanguageTooltip, keyPressed, getNarration, mouseClicked, getCode, getLanguage |
| top-level / `jerozgen/languagereload/gui/LanguageEntryButton.java` | `` |  | extractContents |
| top-level / `jerozgen/languagereload/gui/LanguageList.java` | `` |  | set, addEntry, getEntryAtPosition, extractSelection, getHoveredSelectionRight, getScreen, getRowHeight, getRowWidth, scrollBarX, keyPressed, setParent, getParent |
| top-level / `jerozgen/languagereload/LanguageReload.java` | `` |  | onInitializeClient, reloadLanguages, setLanguage, setLanguage |
| top-level / `jerozgen/languagereload/mixin/AdvancementsScreenMixin.java` | `value={AdvancementsScreen.class})` |  | languagereload_recreateWidgets |
| top-level / `jerozgen/languagereload/mixin/AdvancementTabMixin.java` | `value={AdvancementTab.class})` |  | languagereload_recreateWidgets |
| top-level / `jerozgen/languagereload/mixin/AdvancementWidgetAccessor.java` | `value={AdvancementWidget.class})` | Accessor:6 |  |
| top-level / `jerozgen/languagereload/mixin/BookViewScreenAccessor.java` | `value={BookViewScreen.class})` | Accessor:1 |  |
| top-level / `jerozgen/languagereload/mixin/ClientChunkCacheAccessor.java` | `value={ClientChunkCache.class})` | Accessor:1 |  |
| top-level / `jerozgen/languagereload/mixin/ClientChunkCacheStorageAccessor.java` | `value={ClientChunkCache.Storage.class})` | Accessor:1 |  |
| top-level / `jerozgen/languagereload/mixin/ClientLanguageMixin.java` | `value={ClientLanguage.class})` | Inject:2, WrapOperation:1, Redirect:1 | onLoadFrom$applyDeprecatedLanguageData, onLoadFrom, onAppendFrom$saveSeparately, languagereload_get, languagereload_getTargetLanguage, languagereload_setTargetLanguage |
| top-level / `jerozgen/languagereload/mixin/KeyboardHandlerMixin.java` | `value={KeyboardHandler.class})` | Inject:3 | processLanguageReloadKeys, onHandleDebugKeys, onKeyPress, onCharTyped |
| top-level / `jerozgen/languagereload/mixin/KeyMappingAccessor.java` | `value={KeyMapping.class})` | Accessor:1 |  |
| top-level / `jerozgen/languagereload/mixin/LanguageManagerAccessor.java` | `value={LanguageManager.class})` | Accessor:1 | languagereload_getDefaultLanguage |
| top-level / `jerozgen/languagereload/mixin/LanguageManagerMixin.java` | `value={LanguageManager.class})` | Redirect:1, ModifyExpressionValue:1, Inject:1 | setSystemLanguage |
| top-level / `jerozgen/languagereload/mixin/LanguageMixin.java` | `value={Language.class}, priority=990)` | Inject:2 | onInject, afterInject, languagereload_setClientLanguage, languagereload_getClientLanguage |
| top-level / `jerozgen/languagereload/mixin/LanguageSelectionListAccessor.java` | `value={LanguageSelectScreen.LanguageSelectionList.class})` | Invoker:1 | languagereload_init |
| top-level / `jerozgen/languagereload/mixin/LanguageSelectScreenMixin.java` | `value={LanguageSelectScreen.class})` | Inject:4 | addTitle, setFocused, onRepositionElements, onDone, refresh, setInitialFocus, focusSearch, languagereload_focusEntry |
| top-level / `jerozgen/languagereload/mixin/OptionsMixin.java` | `value={Options.class})` | Inject:3 | checkConfigLanguage |
| top-level / `jerozgen/languagereload/mixin/RecipeBookComponentMixin.java` | `value={RecipeBookComponent.class})` | Inject:1 |  |
| top-level / `jerozgen/languagereload/mixin/SessionSearchTreesMixin.java` | `value={SessionSearchTrees.class}, priority=990)` | WrapOperation:1 | addFallbackTranslationsToSearchTooltips |
| top-level / `jerozgen/languagereload/mixin/SignTextAccessor.java` | `value={SignText.class})` | Accessor:1 |  |
| top-level / `jerozgen/languagereload/mixin/TextDisplayAccessor.java` | `value={Display.TextDisplay.class})` | Accessor:1 |  |
| top-level / `jerozgen/languagereload/mixin/TranslatableContentsMixin.java` | `value={TranslatableContents.class})` | WrapOperation:2 |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
