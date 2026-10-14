# Shield Statuses

Review status: **Evidence inventory; behavioral review pending**

Project: [Shield Statuses](https://modrinth.com/mod/shield-statuses)
Selected artifact version: `4.2.1+26.3`
Published implementation source: https://github.com/Walksy/ShieldStatus
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Shows shield states, represented by color. This mod was ported forward and improved on by Walksy.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `e3393b1ee1a186e4c102cfcc22223c35b246600e`
- `sha512`: `ec012c0b5bc3b99731806a1d206d00f1c2e8257578746252557d2fe60c43752e1ea87f7bd4e134841462319d4451c702a3c9e78be7c148d4fbb24d5b1292fb56`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 15
Reconstructed Java files: 12

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "walksy.shieldstatus.ShieldStatus"
  ],
  "walksylib": [
    "walksy.shieldstatus.config.ShieldStatusConfig"
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

**accessWidener**

```json
"shieldstatus.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `walksy/shieldstatus/config/ShieldStatusConfig.java` | `` |  | shows, getColor, isShieldRising, shownBanner, shownDisabledBanner, bannerFor, drawPreview, tint, toggle, toggle, color, define, Phase |
| top-level / `walksy/shieldstatus/config/ShownPlayers.java` | `` |  | next |
| top-level / `walksy/shieldstatus/GrayscaleTextureCache.java` | `` |  | get, convert |
| top-level / `walksy/shieldstatus/mixin/GuiRendererMixin.java` | `value={GuiRenderer.class})` | Inject:1 | prepareItemElements |
| top-level / `walksy/shieldstatus/mixin/LayerRenderStateMixin.java` | `targets={"net.minecraft.client.renderer.item.ItemStackRenderState$LayerRenderState"})` | Inject:1 | redirectShieldSubmit |
| top-level / `walksy/shieldstatus/mixin/PlayerItemInHandLayerMixin.java` | `value={PlayerItemInHandLayer.class})` | Inject:1 | renderItem |
| top-level / `walksy/shieldstatus/mixin/ShieldSpecialRendererMixin.java` | `value={ShieldSpecialRenderer.class})` | Inject:1 | init |
| top-level / `walksy/shieldstatus/render/BannerQuad.java` | `` |  | emit, vertex |
| top-level / `walksy/shieldstatus/render/BannerTextureCache.java` | `` |  | retain, get, build, register, release, copySource, compose, average |
| top-level / `walksy/shieldstatus/render/ShieldSpecialConfigState.java` | `` |  | extractConfigState |
| top-level / `walksy/shieldstatus/render/ShieldSpecialSubmitter.java` | `` |  | submit |
| top-level / `walksy/shieldstatus/ShieldStatus.java` | `` |  | onInitialize, setCurrentFocusedPlayer, checkDisplayContext, setupShieldSpecialSubmitter, getShieldSpecialSubmitter, getFocusedPlayer |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
