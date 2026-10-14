# Loom GUI Remastered

Review status: **Evidence inventory; behavioral review pending**

Project: [Loom GUI Remastered](https://modrinth.com/mod/loom-gui-remastered)
Selected artifact version: `2.1.1-1.26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Changes the Loom GUI to a more clear with enlarged buttons, icons, previews and improved tool tips

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `cbb4bac79759cdd9829f3e9805364fc155fc8b0f`
- `sha512`: `ab2fb72a476afb7fbf6fd625d81bde6207ec80185875fec8bae8039301a128f2eacb055baac6dd1c04a8934a233b8ba4b3070c4580759ac68c52c9c3c82b6412`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 9
Reconstructed Java files: 9

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "net.a5ho999.loom.LoomRemasteredMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/a5ho999/loom/client/RemasteredGuiBannerResultRenderer.java` | `` |  | renderToTexture |
| top-level / `net/a5ho999/loom/client/RemasteredGuiBannerResultRenderState.java` | `` |  | scale |
| top-level / `net/a5ho999/loom/DrawContextAccess.java` | `` |  |  |
| top-level / `net/a5ho999/loom/LoomRemasteredMod.java` | `` |  | onInitialize, OnLog, Id |
| top-level / `net/a5ho999/loom/mixin/DrawContextMixin.java` | `value={GuiGraphicsExtractor.class})` | Inject:1 | loom_remastered$bannerSize, remastered$addBannerResult |
| top-level / `net/a5ho999/loom/mixin/GameRendererMixin.java` | `value={GameRenderer.class})` | ModifyArg:1 |  |
| top-level / `net/a5ho999/loom/mixin/screen/AbstractContainerScreenAccessor.java` | `value={AbstractContainerScreen.class})` | Accessor:2 |  |
| top-level / `net/a5ho999/loom/mixin/screen/LoomScreenHandlerMixin.java` | `value={LoomMenu.class})` | Redirect:1, ModifyConstant:8 | remastered$overridePlayerInventoryLocation, overrideBannerX, overrideBannerY, overrideDyeX, overrideDyeY, overridePatternX, overridePatternY, overrideOutputX, overrideOutputY |
| top-level / `net/a5ho999/loom/mixin/screen/LoomScreenMixin.java` | `value={LoomScreen.class})` | Inject:6 | LoomScreen, getRows, drawBackground, mouseClicked, mouseDragged, mouseScrolled, remastered$drawBanner |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
