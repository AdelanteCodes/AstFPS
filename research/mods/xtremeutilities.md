# XtremeUtilities

Review status: **Evidence inventory; behavioral review pending**

Project: [XtremeUtilities](https://modrinth.com/mod/xtremeutilities)
Selected artifact version: `1.0.5`
Published implementation source: https://github.com/no1qq/XtremeUtilities/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

a mod that adds toggle sprint, fullbright, freelook, nohurtcam, a dark loading screen and the fadeless reloading animation to your Minecraft.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `1edab7c8baf462cfec5cc67ee445adc7188735b524449f99d81c87cbfe2e003dc06164b936da53a5c2e576cec3840e48a65251fae19e251647a8a085c8f4da19`
- `sha1`: `2b9b537ad740998263cfc2609770759d4d20a860`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 25
Reconstructed Java files: 21

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.xtremeutilities.XtremeUtilitiesClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.0",
  "minecraft": "26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/xtremeutilities/config/ConfigManager.java` | `` |  | load, save |
| top-level / `com/xtremeutilities/config/ModConfig.java` | `` |  | getInstance, setInstance |
| top-level / `com/xtremeutilities/freelook/FreelookManager.java` | `` |  | getInstance, startFreelook, stopFreelook, updateRotation, isFreelookActive, getCameraYaw, getCameraPitch |
| top-level / `com/xtremeutilities/gui/FreelookConfigScreen.java` | `` |  | init, updateMessage, applyValue, extractRenderState, mouseClicked, mouseReleased, onClose |
| top-level / `com/xtremeutilities/gui/NoHurtCamConfigScreen.java` | `` |  | init, updateMessage, applyValue, extractRenderState, mouseClicked, mouseReleased, onClose |
| top-level / `com/xtremeutilities/gui/SprintHudEditorScreen.java` | `` |  | init, extractRenderState, mouseClicked, mouseMoved, mouseDragged, mouseReleased, onClose |
| top-level / `com/xtremeutilities/gui/ToggleSprintConfigScreen.java` | `` |  | init, extractRenderState, mouseClicked, onClose |
| top-level / `com/xtremeutilities/gui/XtremeConfigScreen.java` | `` |  | init, extractRenderState, mouseClicked, onClose |
| top-level / `com/xtremeutilities/mixin/CameraMixin.java` | `value={Camera.class})` | Inject:1 | onAlignWithEntity |
| top-level / `com/xtremeutilities/mixin/DarkLoadingScreenMixin.java` | `value={LoadingOverlay.class})` | Redirect:1 | modifyBrandBackgroundColor |
| top-level / `com/xtremeutilities/mixin/EntityMixin.java` | `value={Entity.class})` | Inject:1 | onTurn |
| top-level / `com/xtremeutilities/mixin/FadelessReloadMixin.java` | `value={LoadingOverlay.class})` | Inject:1 | bypassFadeOut |
| top-level / `com/xtremeutilities/mixin/FullbrightMixin.java` | `value={LightmapRenderStateExtractor.class})` | Inject:2 | beforeExtract, afterExtract |
| top-level / `com/xtremeutilities/mixin/GameRendererMixin.java` | `value={GameRenderer.class})` | Inject:2 | modifyDamageTilt, onBobHurt |
| top-level / `com/xtremeutilities/mixin/KeyMappingAccessor.java` | `value={KeyMapping.class})` | Accessor:1 |  |
| top-level / `com/xtremeutilities/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | onHandleKeybinds |
| top-level / `com/xtremeutilities/mixin/PauseScreenMixin.java` | `value={PauseScreen.class})` | Inject:1 | addConfigButton |
| top-level / `com/xtremeutilities/mixin/TitleScreenMixin.java` | `value={TitleScreen.class})` | Inject:1 | addConfigButton |
| top-level / `com/xtremeutilities/mixin/ToggleSprintMixin.java` | `value={LocalPlayer.class})` | Inject:1 | canStartSprinting, handleToggleSprint |
| top-level / `com/xtremeutilities/sprint/SmartSprintManager.java` | `` |  | isSmartSprintActive, tick, isTargetPlayerInFovAndReach, restoreForwardKey |
| top-level / `com/xtremeutilities/XtremeUtilitiesClient.java` | `` |  | onInitializeClient |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
