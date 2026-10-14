# Optional Pickup

Review status: **Evidence inventory; behavioral review pending**

Project: [Optional Pickup](https://modrinth.com/mod/optional-pickup)
Selected artifact version: `0.1.5-mc26.3`
Published implementation source: https://github.com/NightEpiphany/Optional-Pickup/tree/main
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Pick up items with your own choice.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha512`: `c90aae706a70f010bbde859629df76a8da786198b442163941acd99efc286d0db1a41345730306dc1d900c3b6cd47f89ccc0ce68c3365d38c56f514556cf8437`
- `sha1`: `962f7d1d93c662e7c59d2a371267294e77e058f1`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 17
Reconstructed Java files: 13

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.moigferdsrte.optional_pickup.OptionalPickup"
  ],
  "client": [
    "com.moigferdsrte.optional_pickup.client.OptionalPickupClient"
  ],
  "modmenu": [
    "com.moigferdsrte.optional_pickup.compact.ModMenuEntryPoint"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*",
  "cloth-config": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/moigferdsrte/optional_pickup/client/DropCategory.java` | `` |  | sortKey |
| top-level / `com/moigferdsrte/optional_pickup/client/DropSelectionState.java` | `` |  | get, tick, isActive, shouldRender, getVisibility, getPrevVisibility, getLayoutProgress, getPrevLayoutProgress, getPrevWindowStartIndex, getPrevVisibleCount, getPrevIndexFor, getVisibleCount, getWindowStartIndex, getOptionsView, getSelectedIndex, requestPickup, scroll, getSelectedKeyStack, clampIndex, indexOfKey, snapshotKeys, computeSignature, categorize, computeDisplayName, equals, hashCode, DropOption |
| top-level / `com/moigferdsrte/optional_pickup/client/OptionalPickupClient.java` | `` |  | getPickupKeyDisplay, shouldPreferTooltip, onInitializeClient, updateConfig, onEndClientTick |
| top-level / `com/moigferdsrte/optional_pickup/client/OptionalPickupHud.java` | `` |  | render, trim, clamp01, lerp, easeOutExpo, easeInExpo |
| top-level / `com/moigferdsrte/optional_pickup/compact/ModMenuEntryPoint.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/moigferdsrte/optional_pickup/config/OptionalPickupConfig.java` | `` |  |  |
| top-level / `com/moigferdsrte/optional_pickup/mixin/GuiRenderMixin.java` | `value={Gui.class})` | Inject:1 | render |
| top-level / `com/moigferdsrte/optional_pickup/mixin/ItemEntityPickupMixin.java` | `value={ItemEntity.class})` | Inject:1 | optional_pickup$blockAutoPickup |
| top-level / `com/moigferdsrte/optional_pickup/mixin/MouseHandlerMixin.java` | `value={MouseHandler.class})` | Inject:1 | optional_pickup$scrollSelect |
| top-level / `com/moigferdsrte/optional_pickup/network/PickupRequestC2SPayload.java` | `` |  |  |
| top-level / `com/moigferdsrte/optional_pickup/OptionalPickup.java` | `` |  | onInitialize |
| top-level / `com/moigferdsrte/optional_pickup/pickup/ServerPickupService.java` | `` |  | isManualPickup, tryPickup, Request |
| top-level / `com/moigferdsrte/optional_pickup/util/OverwrittenJudge.java` | `` |  | isHoverTextOverridden |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
