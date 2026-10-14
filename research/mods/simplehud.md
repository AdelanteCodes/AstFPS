# SimpleHUD

Review status: **Evidence inventory; behavioral review pending**

Project: [SimpleHUD](https://modrinth.com/mod/simplehud)
Selected artifact version: `2.2`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Displays various infos on HUD.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `7f5a84542293b33e0e8be929d3e8033c4e952d51`
- `sha512`: `302931624394a3848d11edea53600c32d87011a3c2e853e707239ea55cfa7cc7cd118b0ee62bec19942e137013e63267f23d87cdb2f839fddece5e503a5f0e8f`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 25
Reconstructed Java files: 15

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "dev.losterixx.simplehud.client.MainClient"
  ],
  "main": [
    "dev.losterixx.simplehud.Main"
  ],
  "modmenu": [
    {
      "adapter": "kotlin",
      "value": "dev.losterixx.simplehud.client.config.ModMenuIntegration"
    }
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-language-kotlin": ">=1.14.1+kotlin.2.4.20",
  "fabric-api": "*",
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/losterixx/simplehud/client/config/HudAnchor.java` | `` |  | values, valueOf, getEntries |
| top-level / `dev/losterixx/simplehud/client/config/ModConfig.java` | `` |  | getGeneralSettings, setGeneralSettings, getFpsSettings, setFpsSettings, getPingSettings, setPingSettings, getCpsSettings, setCpsSettings, getLocSettings, setLocSettings, getTimeSettings, setTimeSettings, getDateSettings, setDateSettings, getCpsEnabled, setCpsEnabled, getCpsAnchor, setCpsAnchor, getCpsString, setCpsString, getCpsX, setCpsX, getCpsY, setCpsY, getDateEnabled, setDateEnabled, getDateAnchor, setDateAnchor, getDateString, setDateString, getDateX, setDateX, getDateY, setDateY, getFpsEnabled, setFpsEnabled, getFpsAnchor, setFpsAnchor, getFpsString, setFpsString, getFpsX, setFpsX, getFpsY, setFpsY, getHideOnF1, setHideOnF1, getHideOnF3, setHideOnF3, getHideOnChat, setHideOnChat, getHideOnESC, setHideOnESC, getBackgroundEnabled, setBackgroundEnabled, getTextScale, setTextScale, getLocEnabled, setLocEnabled, getLocAnchor, setLocAnchor, getLocString, setLocString, getLocX, setLocX, getLocY, setLocY, getPingEnabled, setPingEnabled, getPingAnchor, setPingAnchor, getPingString, setPingString, getPingX, setPingX, getPingY, setPingY, getTimeEnabled, setTimeEnabled, getTimeAnchor, setTimeAnchor, getTimeString, setTimeString, getTimeX, setTimeX, getTimeY, setTimeY |
| top-level / `dev/losterixx/simplehud/client/config/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory, getModConfigScreenFactory$lambda$0 |
| top-level / `dev/losterixx/simplehud/client/extra/HudEditorScreen.java` | `` |  | getConfig, extractRenderState, drawElementBox, isHovering, mouseClicked, mouseDragged, mouseReleased, onClose, isPauseScreen, elements$lambda$0, elements$lambda$1, elements$lambda$2, elements$lambda$3, elements$lambda$4, elements$lambda$5, elements$lambda$6, elements$lambda$7 |
| top-level / `dev/losterixx/simplehud/client/extra/HudRenderer.java` | `` |  | getConfig, register, getInitDone, setInitDone, onEndTick, onEndTick$lambda$0, onEndTick$lambda$1, onEndTick$lambda$2, onEndTick$lambda$3, handleMouseEvent, renderHud, mouseEventWatch$lambda$0, elements$lambda$0, elements$lambda$1, elements$lambda$2, elements$lambda$3, elements$lambda$4, elements$lambda$5, elements$lambda$6, elements$lambda$7, register$lambda$0 |
| top-level / `dev/losterixx/simplehud/client/hudelements/CpsElement.java` | `` |  | getEnabled, getAnchor, getOffsetX, getOffsetY, resolveText, previewText, setOffset, setAnchor |
| top-level / `dev/losterixx/simplehud/client/hudelements/DateElement.java` | `` |  | getEnabled, getAnchor, getOffsetX, getOffsetY, resolveText, previewText, setOffset, setAnchor |
| top-level / `dev/losterixx/simplehud/client/hudelements/FpsElement.java` | `` |  | getEnabled, getAnchor, getOffsetX, getOffsetY, resolveText, previewText, setOffset, setAnchor |
| top-level / `dev/losterixx/simplehud/client/hudelements/HudElement.java` | `` |  | getTextHeight, render, drawAt, computePosition, computeAnchorAndOffset |
| top-level / `dev/losterixx/simplehud/client/hudelements/LocationElement.java` | `` |  | getEnabled, getAnchor, getOffsetX, getOffsetY, resolveText, previewText, setOffset, setAnchor |
| top-level / `dev/losterixx/simplehud/client/hudelements/PingElement.java` | `` |  | getEnabled, getAnchor, getOffsetX, getOffsetY, resolveText, previewText, setOffset, setAnchor |
| top-level / `dev/losterixx/simplehud/client/hudelements/TimeElement.java` | `` |  | getEnabled, getAnchor, getOffsetX, getOffsetY, resolveText, previewText, setOffset, setAnchor |
| top-level / `dev/losterixx/simplehud/client/MainClient.java` | `` |  | onInitializeClient, onInitializeClient$lambda$0, onInitializeClient$lambda$1 |
| top-level / `dev/losterixx/simplehud/client/utils/TimeUtil.java` | `` |  | getFormattedTime, getFormattedDate |
| top-level / `dev/losterixx/simplehud/Main.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
