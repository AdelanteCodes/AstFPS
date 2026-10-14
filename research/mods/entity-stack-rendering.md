# Entity Stack Rendering

Review status: **Evidence inventory; behavioral review pending**

Project: [Entity Stack Rendering](https://modrinth.com/mod/entity-stack-rendering)
Selected artifact version: `1.2`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A performance mod that massively boosts fps when dealing with a large amount of entities in the same place

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `optional`.

Artifact identity:
- `sha512`: `77e67833ab0822c19fb269d8cab9ec0d529fd558fb0f572fe57a6648a50c2960c8953826054efbf2b2bc58de84ef914574329356b0786c1c6adb9369a796cf76`
- `sha1`: `55d5c9b1950eac140a7edfb51041bbbbf357ee85`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 18
Reconstructed Java files: 14

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "mobius.entitystacking.EntityStackingClient"
  ],
  "modmenu": [
    "mobius.entitystacking.compat.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `mobius/entitystacking/compat/ConfigScreens.java` | `` |  | yaclAvailable, create |
| top-level / `mobius/entitystacking/compat/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `mobius/entitystacking/config/StackingConfig.java` | `` |  | get, load, save, markChanged, clamp, isTypeAllowed, thresholdFor, isListed, setListed, setThreshold, packedColor, labelColor, previewColor, scaleFactor, clampInt |
| top-level / `mobius/entitystacking/EntityStackDetector.java` | `` |  | update, clear, isSuppressed, isRepresentative, getStackCount, thresholdFor, isEligible, StackKey |
| top-level / `mobius/entitystacking/EntityStackingClient.java` | `` |  | onInitializeClient |
| top-level / `mobius/entitystacking/EntityStackingMod.java` | `` |  |  |
| top-level / `mobius/entitystacking/gui/EntityFilterScreen.java` | `` |  | init, addTitle, addOptions, tick, onClose, headerTitle, disabledLabel, sortedTypes, currentValue, updateMessage, applyValue |
| top-level / `mobius/entitystacking/gui/StackingOptionsScreen.java` | `` |  | addOptions, onClose, onOff, colourSlider, refreshPreview, previewText, filterModeText, nextMode, currentValue, updateMessage, applyValue |
| top-level / `mobius/entitystacking/gui/YaclScreenFactory.java` | `` |  | create, channel |
| top-level / `mobius/entitystacking/mixin/EntityRendererMixin.java` | `value={EntityRenderer.class})` | Inject:3 | entitystacking$suppressShouldRender, entitystacking$carryStackData, entitystacking$submitStackLabel |
| top-level / `mobius/entitystacking/mixin/EntityRenderStateMixin.java` | `value={EntityRenderState.class})` |  | entitystacking$setStackCount, entitystacking$getStackCount, entitystacking$setLookedAt, entitystacking$isLookedAt |
| top-level / `mobius/entitystacking/mixin/VideoSettingsScreenMixin.java` | `value={VideoSettingsScreen.class})` | Inject:1 | entitystacking$addSettingsButton |
| top-level / `mobius/entitystacking/StackLabelHolder.java` | `` |  |  |
| top-level / `mobius/entitystacking/StackLabelRenderer.java` | `` |  | carryStackData, submit |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
