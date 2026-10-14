# "Limitless" Banners

Review status: **Evidence inventory; behavioral review pending**

Project: ["Limitless" Banners](https://modrinth.com/mod/limitless-banners)
Selected artifact version: `1.4.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A simple mod that removes the banner pattern limit. The new cap is at 16!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `cddd0bdd159c651c47e09298d74c9eef50676e74667ee3594c32c2f2fc415a1646111f657800744884b3883edb1bf156ab0791a6d9d7b09fd0aa27da3698030f`
- `sha1`: `ff496ccafa4bd17fb6a730687cf7aa3540620603`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 7
Reconstructed Java files: 7

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "us.mikebartosh.minecraft.limitlessbanners.LimitlessBanners"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.2",
  "minecraft": ">=26.1",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `us/mikebartosh/minecraft/limitlessbanners/LimitlessBanners.java` | `` |  | onInitialize |
| top-level / `us/mikebartosh/minecraft/limitlessbanners/LimitlessBannersConfig.java` | `` |  | load, save, get |
| top-level / `us/mikebartosh/minecraft/limitlessbanners/mixin/MixinBannerDuplicateRecipe.java` | `value={BannerDuplicateRecipe.class})` | ModifyConstant:2 | getOriginalLimit, getOriginalCraftingLimit |
| top-level / `us/mikebartosh/minecraft/limitlessbanners/mixin/MixinBannerPatternLayers.java` | `value={BannerPatternLayers.class})` | ModifyConstant:1 | modifyMaxTooltipPatterns |
| top-level / `us/mikebartosh/minecraft/limitlessbanners/mixin/MixinBannerRenderer.java` | `value={BannerRenderer.class})` | ModifyConstant:1 | modifyMaxRenderedPatterns |
| top-level / `us/mikebartosh/minecraft/limitlessbanners/mixin/MixinLoomScreen.java` | `value={LoomScreen.class})` | ModifyConstant:1 | modifyMaxBannerCount |
| top-level / `us/mikebartosh/minecraft/limitlessbanners/mixin/MixinLoomScreenHandler.java` | `value={LoomMenu.class})` | ModifyConstant:1 | modifyMaxBannerCount |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
