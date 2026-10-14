# Improved F3

Review status: **Evidence inventory; behavioral review pending**

Project: [Improved F3](https://modrinth.com/mod/improvedf3)
Selected artifact version: `2.0.1+26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This project is an improved F3 Menu with different translations and toggles in the config.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `2b426c3bd907d78aeb636b1a168c9b2331a4f088`
- `sha512`: `1cade4fd4b1ba9f91b1a220242702e18f38cb2044367943f1d418feed4a55248b04bceaf20e04794e37cf4f94b47a0b20c5059f59d43444569b5d0dfbaea28d8`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 17
Reconstructed Java files: 16

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "com.improvedf3.ImprovedF3Mod"
  ],
  "client": [
    "com.improvedf3.ImprovedF3Client"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "26.3",
  "java": ">=25",
  "fabric-api": ">=0.162.0+26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/improvedf3/config/ModConfig.java` | `` |  | getInstance, configFile, load, save |
| top-level / `com/improvedf3/gui/BasicInfoScreen.java` | `` |  | init |
| top-level / `com/improvedf3/gui/ConfigScreen.java` | `` |  | init, category, extractRenderState |
| top-level / `com/improvedf3/gui/LanguageSettingsScreen.java` | `` |  | init, getLanguageName |
| top-level / `com/improvedf3/gui/Layout.java` | `` |  | category, setting, panelScale, Bounds |
| top-level / `com/improvedf3/gui/NetworkInfoScreen.java` | `` |  | init |
| top-level / `com/improvedf3/gui/ScreenCompat.java` | `` |  | setScreen |
| top-level / `com/improvedf3/gui/SettingsScreen.java` | `` |  | addButton, addSettingToggle, addFooter, addDoneButton, open, closeToParent, extractRenderState, onClose |
| top-level / `com/improvedf3/gui/SystemInfoScreen.java` | `` |  | init |
| top-level / `com/improvedf3/gui/VisualSettingsScreen.java` | `` |  | init |
| top-level / `com/improvedf3/gui/WorldInfoScreen.java` | `` |  | init |
| top-level / `com/improvedf3/ImprovedF3Client.java` | `` |  | onInitializeClient |
| top-level / `com/improvedf3/ImprovedF3Mod.java` | `` |  | onInitialize |
| top-level / `com/improvedf3/mixin/client/DebugHudMixin.java` | `value={DebugScreenOverlay.class})` | Inject:1 | improvedf3$extractRenderState, renderPanel, getImprovedLeftText, getImprovedRightText, labelValue, toMiB |
| top-level / `com/improvedf3/util/TranslationHelper.java` | `` |  | translate, translateBiome |
| top-level / `com/improvedf3/util/TranslationResolver.java` | `` |  | translate, translateBiome |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
