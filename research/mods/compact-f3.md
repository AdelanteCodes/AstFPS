# Compact F3

Review status: **Evidence inventory; behavioral review pending**

Project: [Compact F3](https://modrinth.com/mod/compact-f3)
Selected artifact version: `1.3.3`
Published implementation source: https://github.com/user2949/compactf3/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A mod that reduces the useless information from F3, can be toggalable with F8.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `52bccc18ed692ec1d35438df2479e65b1e9a1aacec2708af436719cd867a7722f3296e9d6d0a970f1a7b8987cab927d1548b0686b74e4f94be3c9735393a9634`
- `sha1`: `08d5ebfd79efddd7d3354e6a02812ac5e9adf69a`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 17
Reconstructed Java files: 8

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "username65735.compactf3.CompactF3"
  ],
  "client": [
    "username65735.compactf3.CompactF3Client"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `username65735/compactf3/CompactF3.java` | `` |  | id, onInitialize |
| top-level / `username65735/compactf3/CompactF3Client.java` | `` |  | onInitializeClient, openMenu |
| top-level / `username65735/compactf3/CompactF3GuiSettingsScreen.java` | `` |  | init, applySetting, valueText, applySetting, valueText, applySetting, valueText, extractRenderState, onClose, isPauseScreen, updateMessage, applyValue, settingValue, normalize |
| top-level / `username65735/compactf3/CompactF3Hud.java` | `` |  | toggle, getAnchor, setAnchor, getEdgePadding, setEdgePadding, getOpacityPercent, setOpacityPercent, getRefreshRateHz, setRefreshRateHz, tick, render, requestRefresh, refreshIfNeeded, backgroundColor, drawPanel, maxLineWidth, buildLines, frameTimeMillis, speedLine, formatTimeOfDay, normalizeYaw, formatDirection, formatBiome, label |
| top-level / `username65735/compactf3/CompactF3KeybindsScreen.java` | `` |  | init, extractRenderState, keyPressed, mouseClicked, onClose, isPauseScreen, selectMapping, assignKey, resetBindings, finishBinding, findConflict, bindingMessage, refreshBindingLabels |
| top-level / `username65735/compactf3/CompactF3MenuScreen.java` | `` |  | init, extractRenderState, onClose, isPauseScreen |
| top-level / `username65735/compactf3/CompactF3PositionScreen.java` | `` |  | init, extractRenderState, onClose, isPauseScreen, anchorButton |
| top-level / `username65735/compactf3/MinecraftCompatibility.java` | `` |  | resolveScreenSetter, resolveScreenGetter, resolveHudHiddenGetter, invoke |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
