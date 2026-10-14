# Toggle Nametags

Review status: **Evidence inventory; behavioral review pending**

Project: [Toggle Nametags](https://modrinth.com/mod/hidetags)
Selected artifact version: `2.7.9+26.3`
Published implementation source: https://github.com/Greek/ToggleNametags
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Toggle, hide, and style nametags in-game.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `3f2cad4d0299b95bcf54dca4194b79cfe8ff0754`
- `sha512`: `8275e1db3e8026325d981ea4e1b6c8a4ad1010f03b4dde2cdcfa64610a7c27fc88a47eece2a9fcd516372987399b2fb52cc8b254294e4f51a618d65d2960ca34`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 19
Reconstructed Java files: 17

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "sh.ndy.ToggleNametagsClient"
  ],
  "modmenu": [
    "sh.ndy.ToggleNametagsModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.17",
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `sh/ndy/config/Config.java` | `` |  | getOptions, setOptions, saveConfig, loadConfig |
| top-level / `sh/ndy/config/Options.java` | `` |  | getRenderNametags, setRenderNametags, getRenderSelfNametag, setRenderSelfNametag, getRenderBossbar, setRenderBossbar, getNametagOpacity, setNametagOpacity, getNametagBackgroundEnabled, setNametagBackgroundEnabled, getRenderNametagTextShadow, setRenderNametagTextShadow |
| top-level / `sh/ndy/Constants.java` | `` |  |  |
| top-level / `sh/ndy/features/Bindings.java` | `` |  | registerAll, binding |
| top-level / `sh/ndy/features/listeners/BossbarToggleListener.java` | `` |  | handleBinding, handleMixin |
| top-level / `sh/ndy/features/listeners/IBaseBindingListener.java` | `` |  | handleBinding, handleMixin |
| top-level / `sh/ndy/features/listeners/NametagsTextShadowListener.java` | `` |  | handleMixin |
| top-level / `sh/ndy/features/listeners/NametagsToggleListener.java` | `` |  | handleBinding, handleMixin |
| top-level / `sh/ndy/features/listeners/SelfNametagToggleListener.java` | `` |  | handleBinding, handleMixin |
| top-level / `sh/ndy/mixin/client/MixinNametagsBackgroundOpacity.java` | `value={SubmitNodeCollection.class})` | ModifyArg:1 | disableNametag |
| top-level / `sh/ndy/mixin/client/MixinNametagsTextShadow.java` | `value={SubmitNodeCollection.class})` | ModifyArg:1 | render |
| top-level / `sh/ndy/mixin/client/MixinRenderBossBar.java` | `value={BossHealthOverlay.class})` | Inject:1 | render |
| top-level / `sh/ndy/mixin/client/MixinRenderNameTag.java` | `value={EntityRenderer.class})` | Inject:1 | doNotRender |
| top-level / `sh/ndy/mixin/client/MixinRenderSelfNameTag.java` | `value={LivingEntityRenderer.class})` | Inject:1 | viewOwnLabel |
| top-level / `sh/ndy/screens/ConfigScreen.java` | `` |  | getRenderNametagsText, getRenderSelfNametagText, getRenderBossbarText, calcNametagOpacityDisplayVal, getNametagOpacityText, getRenderNametagShadowText, init, extractRenderState, onClose, updateRenderNametagsConfig, updateRenderSelfNametagsConfig, updateNametagShadowConfig, updateRenderBossbarConfig, updateMessage, applyValue |
| top-level / `sh/ndy/ToggleNametagsClient.java` | `` |  | checkForEssentialMod, onInitializeClient |
| top-level / `sh/ndy/ToggleNametagsModMenu.java` | `` |  | getModConfigScreenFactory |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
