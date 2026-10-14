# 钠-汉化模组（Sodium Chinese Localization Mod）

Review status: **Evidence inventory; behavioral review pending**

Project: [钠-汉化模组（Sodium Chinese Localization Mod）](https://modrinth.com/mod/mc1.16.5-sodium-chinese-localization-pack)
Selected artifact version: `5.6.7`
Published implementation source: https://github.com/Long-Zixuan/Sodium_Chinese_Localization_Package
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A project can translate you sodium mod into Chinese

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `2d524cf19c9dbd9fc1f9ac26caa6b1591fdfc08e`
- `sha512`: `30c3aa4b1aaeedea4aaee4c09d4efd175ed4210ba28e8664ab1597a24a3cf9de04ad202560ad2907bdad684c8126e3fd267587f1b434f96b7dae856c2c2fff94`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 21
Reconstructed Java files: 19

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "me.loongly.mods.sclp.fabric.client.SCLPFabricClientMod"
  ],
  "sodium:config_api_user": [
    "me.loongly.mods.sclp.common.client.options.SCLPConfigBuilder"
  ]
}
```

**depends**

```json
{
  "minecraft": ">=26.1",
  "sodium": ">=0.8.7"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/loongly/mods/sclp/common/client/options/SCLPConfigBuilder.java` | `` |  | registerConfigLate, createOptionsPage, createGeneralPage, createSupportPage, createBirthPage, optionId |
| top-level / `me/loongly/mods/sclp/common/client/options/SCLPOptions.java` | `` |  | setShoudTransModName, getShouldTransModName, setShouldShowSupportPage, getShouldShowSupportPage, save, load, writeChanges |
| top-level / `me/loongly/mods/sclp/common/client/SCLPClientMod.java` | `` |  | options, logger, onInitClient, caiDan, birthCaiDan, birthCaiDan, openSupportWeb, openSupportWeb, openWeb |
| top-level / `me/loongly/mods/sclp/common/client/util/MethodSignature.java` | `` |  | MethodSignature, fromMethod, equals |
| top-level / `me/loongly/mods/sclp/common/language/I18N.java` | `` |  | trans, hadTrans |
| top-level / `me/loongly/mods/sclp/common/language/I18NLanguage.java` | `` |  | getInstance, init, getLanguage |
| top-level / `me/loongly/mods/sclp/common/language/LangFile.java` | `` |  | toMap, initMap, getLangUrl, convertJsonToMap, doGet |
| top-level / `me/loongly/mods/sclp/common/mixin/sodium/MixinModOptionsBuilderImpl.java` | `value={ModOptions.class}, remap=false)` | Inject:1 | modifyName |
| top-level / `me/loongly/mods/sclp/common/mixin/sodium/MixinPageBuilderImpl.java` | `value={PageBuilderImpl.class})` | Inject:1 | injectSetName |
| top-level / `me/loongly/mods/sclp/common/mixin/sodium/MixinScreenPrompt.java` | `value={ScreenPrompt.class})` | Inject:1 | injectInit, close |
| top-level / `me/loongly/mods/sclp/common/mixin/sodium/MixinSodiumVideoSettingsScreen.java` | `value={VideoSettingsScreen.class})` | Inject:1, Redirect:1 | injectRebuild, ifNotInsetX, mixinOpenDonationPrompt |
| top-level / `me/loongly/mods/sclp/common/services/IPlatformHelper.java` | `` |  |  |
| top-level / `me/loongly/mods/sclp/common/services/Services.java` | `` |  | load |
| top-level / `me/loongly/mods/sclp/desktop/LaunchWarn.java` | `` |  | main, showHeadlessError, showGraphicalError, showRichGraphicalDialog, showFallbackGraphicalDialog, showDialogBox, trySetSystemLookAndFeel, trySetSystemFontPreferences, log, log |
| top-level / `me/loongly/mods/sclp/desktop/utils/browse/BrowseUrlHandler.java` | `` |  | createImplementation |
| top-level / `me/loongly/mods/sclp/desktop/utils/browse/CrossPlatformImpl.java` | `` |  | isSupported, browseTo |
| top-level / `me/loongly/mods/sclp/desktop/utils/browse/XDGImpl.java` | `` |  | isSupported, browseTo |
| top-level / `me/loongly/mods/sclp/fabric/client/SCLPFabricClientMod.java` | `` |  | onInitializeClient |
| top-level / `me/loongly/mods/sclp/fabric/services/FabricPlatformHelper.java` | `` |  | getConfigDirectory, getLanguageCode, curVersion |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
