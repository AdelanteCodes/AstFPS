# Crosshair Addons Public

Review status: **Evidence inventory; behavioral review pending**

Project: [Crosshair Addons Public](https://modrinth.com/mod/crosshair-addons-public)
Selected artifact version: `2.2.0+26.3`
Published implementation source: https://github.com/Walksy/Crosshair-Addons
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Provides helpful icons around the crosshair when certain conditions are met.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `0e0b5a5f3596313d7a4efa0f40cce4534fd8e16891f2e7f67149eecf222873845dfe2dc07e0fba8a446ab879839f1a8a4ca0b63a082cc82f474b226507d9ed4a`
- `sha1`: `4828fb5e8a38902d555286475950da76e0ddd82a`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 9
Reconstructed Java files: 8

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "walksy.crosshairaddons.CrosshairAddons"
  ],
  "walksylib": [
    "walksy.crosshairaddons.config.CrosshairAddonsConfig"
  ]
}
```

**depends**

```json
{
  "minecraft": "26.3",
  "java": ">=25",
  "fabric-api": "*",
  "walksylib": ">=2.0.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `walksy/crosshairaddons/config/CrosshairAddonsConfig.java` | `` |  | isEditing, toggle, toggle, define |
| top-level / `walksy/crosshairaddons/config/State.java` | `` |  |  |
| top-level / `walksy/crosshairaddons/CrosshairAddons.java` | `` |  | onInitialize, addonHud, addonsVisible, addonSpaces, getEntityTypeFromString, getStateManager |
| top-level / `walksy/crosshairaddons/manager/AddonStateManager.java` | `` |  | updateCachedEntityTypes, onShieldBreak, onAttackEntity, onArrowHit, tick, checkTarget, get |
| top-level / `walksy/crosshairaddons/mixin/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | Inject:1 | onGameStateChange |
| top-level / `walksy/crosshairaddons/mixin/GuiGraphicsExtractorMixin.java` | `value={GuiGraphicsExtractor.class})` | Inject:2 | moveAttackIndicator, moveAttackIndicatorProgress, crosshairaddons$movedY, crosshairaddons$attackIndicatorY |
| top-level / `walksy/crosshairaddons/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | tick |
| top-level / `walksy/crosshairaddons/mixin/MultiPlayerGameModeMixin.java` | `value={MultiPlayerGameMode.class})` | Inject:1 | onAttackEntity |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
