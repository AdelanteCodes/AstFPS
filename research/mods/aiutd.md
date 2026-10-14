# Am I Up To Date?

Review status: **Evidence inventory; behavioral review pending**

Project: [Am I Up To Date?](https://modrinth.com/mod/aiutd)
Selected artifact version: `2.7.1-fabric+26.3`
Published implementation source: https://github.com/vesmaybevesper/Am-I-Up-To-Date
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Efficient & customizable update notifications for modpacks on the main menu and in chat. Supports FancyMenu & Rinku!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `51a0ebae006e2710733e4297e7ac0fdf6185cc64`
- `sha512`: `a2e99f2577bdea862e4153f4a6080b6dc12ad89f97de03419b8baa7cb3f3a2942222b9dd0b5369fbca99f0ba6c74ad30b95ab6f17eeb28f069e6f7264e2c9e0e`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 33
Reconstructed Java files: 22

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "dev.vesper.aiutd.platform.fabric.FabricEntrypoint"
  ],
  "client": [
    "dev.vesper.aiutd.platform.fabric.FabricClientEntrypoint"
  ],
  "fabric-datagen": [
    "dev.vesper.aiutd.platform.fabric.datagen.FabricDataGeneratorEntrypoint"
  ],
  "modmenu": [
    "dev.vesper.aiutd.platform.fabric.ModMenuInit"
  ]
}
```

**depends**

```json
{
  "fabric-api": ">=0.160.5+26.3",
  "fabricloader": ">=0.19.3",
  "java": ">=25",
  "minecraft": ">=26.3",
  "yet_another_config_lib_v3": ">=3.9.6+26.3-fabric"
}
```

**breaks**

```json
{}
```

**accessWidener**

```json
"aw/26.3.accesswidener"
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/fastjson2-2.0.65.jar` | 773 | `com_alibaba_fastjson2_fastjson2` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/vesper/aiutd/AIUTD.java` | `` |  | onInitialize, onInitializeClient, createPlatformInstance, id, id, isModLoaded, getApiLink, getChangelogLink |
| top-level / `dev/vesper/aiutd/common/ChangelogOpeners.java` | `` |  | rinku, browser, popUp, pick |
| top-level / `dev/vesper/aiutd/common/ChatMessages.java` | `` |  | openChangelog, ignoreMessage, sendChatMessage |
| top-level / `dev/vesper/aiutd/common/config/Config.java` | `` |  | config |
| top-level / `dev/vesper/aiutd/common/config/EndUserConfig.java` | `` |  |  |
| top-level / `dev/vesper/aiutd/common/fancymenu/FancyMenuIntegration.java` | `` |  | init, registerElements |
| top-level / `dev/vesper/aiutd/common/fancymenu/UpdateNoticeEditorElement.java` | `` |  | init, getElement |
| top-level / `dev/vesper/aiutd/common/fancymenu/UpdateNoticeElement.java` | `` |  | extractRenderState, tick, tickVisibleInvisible, getWidgetsToRegister, getExecutableBlock, getWidget, renderElementWidget, updateWidget, updateWidgetActiveState, updateWidgetNavigatable, updateWidgetVisibility, updateWidgetAlpha, updateWidgetPosition, updateWidgetSize, updateWidgetTooltip, splitTooltipLines, updateWidgetLabels, updateWidgetHoverSound, updateWidgetClickSound, updateWidgetTexture, setWidget |
| top-level / `dev/vesper/aiutd/common/fancymenu/UpdateNoticeElementBuilder.java` | `` |  | buildDefaultInstance, isAnyMouseButtonPressed, deserializeElement, serializeElement, wrapIntoEditorElement, getDisplayName, getDescription |
| top-level / `dev/vesper/aiutd/common/gui/Buttons.java` | `` |  | smallButton, largeButton |
| top-level / `dev/vesper/aiutd/common/gui/UpdateToast.java` | `` |  | getWantedVisibility, update, extractRenderState, width, height, show |
| top-level / `dev/vesper/aiutd/common/rinku/RinkuWindow26.java` | `` |  | init, initNavigationWidgets, getBrowserX, getBrowserY, getBrowserWidth, getBrowserHeight, isInBrowserBounds, mouseX, mouseY, resizeBrowser, resize, onClose, tick, refreshNavigationState, navigateFromUrlField, normalizeUrl, extractRenderState, renderBrowserTexture, renderLoadingIndicator, mouseClicked, mouseReleased, mouseMoved, mouseDragged, mouseScrolled, keyPressed, keyReleased, charTyped |
| top-level / `dev/vesper/aiutd/common/serializer/FastJsonConfigSerializer.java` | `` |  | save, loadSafely, load, tagToJson, jsonToTag, jsonValueToTag, registerDefaultAdapters, setPath, overrideWriterFeatures, appendWriterFeatures, overrideReaderFeatures, appendReaderFeatures, registerTypeWriter, registerTypeReader, build, readObject, write, readObject, write, readObject, write |
| top-level / `dev/vesper/aiutd/common/serializer/FastJsonConfigSerializerBuilder.java` | `` |  | create |
| top-level / `dev/vesper/aiutd/common/UpdateChecker.java` | `` |  | getVersionNumber, findMatchingVersion, matchesGameVersion, matchesLoader, useCachedVersionMsg |
| top-level / `dev/vesper/aiutd/common/Utils.java` | `` |  | setConfigColors, formatColor |
| top-level / `dev/vesper/aiutd/mixin/TitleScreenMixin.java` | `value={TitleScreen.class})` | Inject:1 | addUpdateNotice |
| top-level / `dev/vesper/aiutd/platform/fabric/FabricClientEntrypoint.java` | `` |  | onInitializeClient |
| top-level / `dev/vesper/aiutd/platform/fabric/FabricEntrypoint.java` | `` |  | onInitialize |
| top-level / `dev/vesper/aiutd/platform/fabric/FabricPlatform.java` | `` |  | isModLoaded, loader, mcVersion, isDevelopmentEnvironment |
| top-level / `dev/vesper/aiutd/platform/fabric/ModMenuInit.java` | `` |  | getModConfigScreenFactory |
| top-level / `dev/vesper/aiutd/platform/Platform.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
