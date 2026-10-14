# kennytvs-epic-force-close-loading-screen-mod-for-fabric

Review status: **Evidence inventory; behavioral review pending**

Project: [kennytvs-epic-force-close-loading-screen-mod-for-fabric](https://modrinth.com/mod/forcecloseworldloadingscreen)
Selected artifact version: `2.3.7`
Published implementation source: https://github.com/kennytv/kennytvs-epic-force-close-loading-screen-mod-for-fabric/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Instantly closes the loading terrain screen on world changing and drastically reduces the resource pack loading screen duration

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `9e7fcba8155ef97062d77a5c8929900674740258`
- `sha512`: `ff095f0f74850888f548573358ca1993c9a76b647bbe05faec121846e3b453c6348e2094d51ad466781e915b3332b99bac8acbd12583b45e52a2b7015d3d8fc8`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 10
Reconstructed Java files: 9

**environment**

```json
"client"
```

**entrypoints**

```json
{}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3",
  "java": ">=25"
}
```

**accessWidener**

```json
"forcecloseloadingscreen.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `eu/kennytv/forcecloseloadingscreen/CapturedFrame.java` | `` |  | width, height, backgroundColor, clearCapturedTexture, captureLastFrame, needsResize |
| top-level / `eu/kennytv/forcecloseloadingscreen/mixin/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | Inject:1 | handleLogin |
| top-level / `eu/kennytv/forcecloseloadingscreen/mixin/GuiMixin.java` | `value={Gui.class})` | ModifyVariable:1 | setScreen |
| top-level / `eu/kennytv/forcecloseloadingscreen/mixin/LevelLoadingScreenMixin.java` | `value={LevelLoadingScreen.class})` | Inject:3 | extractRenderState, extractBackground, onClose |
| top-level / `eu/kennytv/forcecloseloadingscreen/mixin/LoadingOverlayMixin.java` | `value={LoadingOverlay.class})` | Inject:2, Redirect:1 | extractRenderState, fadeIn, isReadyToFadeOut |
| top-level / `eu/kennytv/forcecloseloadingscreen/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:2 | clearClientLevel, disconnect |
| top-level / `eu/kennytv/forcecloseloadingscreen/mixin/MouseHandlerMixin.java` | `value={MouseHandler.class})` | Inject:1 | fixSprint |
| top-level / `eu/kennytv/forcecloseloadingscreen/ReconfigBridgeScreen.java` | `` |  | extractRenderState, extractBackground, tick, isPauseScreen, shouldCloseOnEsc, shouldNarrateNavigation |
| top-level / `eu/kennytv/forcecloseloadingscreen/TitleBridgeScreen.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
