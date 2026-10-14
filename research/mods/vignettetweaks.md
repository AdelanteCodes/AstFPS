# Vignette Tweaks

Review status: **Evidence inventory; behavioral review pending**

Project: [Vignette Tweaks](https://modrinth.com/mod/vignettetweaks)
Selected artifact version: `2.1.0+26.3`
Published implementation source: https://codeberg.org/chromatic/VignetteTweaks
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A mod that allows you to customize vignette.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `44fb62e1035a928b8962b9388881bf96eae7aa54`
- `sha512`: `94ad614fec0d44b65b2c4a89eeb47d84f5e511e40286569b2f5572659df8b5f2d6bdbe8c20f15019b23b5827961db381d39a1430537ef955b573fdf4143856b9`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 10
Reconstructed Java files: 6

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "org.codeberg.chromatic.vignettetweaks.VignetteTweaks"
  ],
  "modmenu": [
    "org.codeberg.chromatic.vignettetweaks.config.integration.modmenu.VignetteTweaksModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.17",
  "minecraft": "~26.3",
  "fabric-api": "*",
  "oneconfigv1": ">=1.0.0"
}
```

**conflicts**

```json
{
  "ichor": "*",
  "feather": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `org/codeberg/chromatic/vignettetweaks/config/integration/modmenu/VignetteTweaksModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `org/codeberg/chromatic/vignettetweaks/config/VignetteConfig.java` | `` |  | scaled, evaluate, evaluate, evaluate, evaluate |
| top-level / `org/codeberg/chromatic/vignettetweaks/mixin/MixinGui.java` | `value={Hud.class})` | WrapOperation:1, ModifyArgs:1 | setStrength, setColor, pick |
| top-level / `org/codeberg/chromatic/vignettetweaks/util/ColorUtil.java` | `` |  | invert, scale |
| top-level / `org/codeberg/chromatic/vignettetweaks/util/VignetteResult.java` | `` |  | VignetteResult, isActive |
| top-level / `org/codeberg/chromatic/vignettetweaks/VignetteTweaks.java` | `` |  | onInitializeClient |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
