# Fontrast

Review status: **Evidence inventory; behavioral review pending**

Project: [Fontrast](https://modrinth.com/mod/fontrast)
Selected artifact version: `1.1.1`
Published implementation source: https://github.com/Yedelo/Fontrast
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Adds numerous ways to customize the look of text

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `bc046f8b8cb82c380a97a70305283395b6c0323b`
- `sha512`: `ae941800a149961a755896b125280cafaafe1a413b67a62726c594c05bb17deb154fdee5e13d669e41fa41994c252df4ef41903e2df16acaac00af95e431ca0a`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 19
Reconstructed Java files: 18

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "at.yedel.fontrast.Fontrast"
  ],
  "modmenu": [
    "at.yedel.fontrast.utils.FontrastModMenu"
  ],
  "oneconfig:toggle": [
    "at.yedel.fontrast.utils.FontrastModToggle"
  ]
}
```

**depends**

```json
{
  "java": ">=25",
  "fabricloader": ">=0.19.3",
  "minecraft": ">=26.1 <=26.3",
  "fabric-api": "*",
  "yet_another_config_lib_v3": ">=3.9.4+26.1-fabric"
}
```

**accessWidener**

```json
"fontrast.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `at/yedel/fontrast/config/AdvancedControl.java` | `` |  | createCategory |
| top-level / `at/yedel/fontrast/config/ControlOption.java` | `` |  | shouldApply, getDisplayName, controller |
| top-level / `at/yedel/fontrast/config/CustomColors.java` | `` |  | createGroup, register, ColorDefinition |
| top-level / `at/yedel/fontrast/config/FontrastConfig.java` | `` |  | getInstance, init, getScreen, isBold, isItalic, isStrikethrough, isUnderlined, isObfuscated, getTextColor, getShadowColor, getShadowScale, getShadowOffset, getBoldOffset |
| top-level / `at/yedel/fontrast/config/OptionRegistry.java` | `` |  | registerOption, getOptions |
| top-level / `at/yedel/fontrast/config/TextColorControl.java` | `` |  | createCategory |
| top-level / `at/yedel/fontrast/config/TextStyleControl.java` | `` |  | createCategory |
| top-level / `at/yedel/fontrast/Fontrast.java` | `` |  | onInitializeClient |
| top-level / `at/yedel/fontrast/mixin/BakedSheetGlyphMixin.java` | `value={BakedSheetGlyph.class})` | ModifyExpressionValue:8 | fontrast$isBold$left, fontrast$isBold$top, fontrast$isBold$right, fontrast$isBold$bottom, fontrast$isBold$renderChar, fontrast$isItalic$left, fontrast$isItalic$right, fontrast$isItalic$renderChar |
| top-level / `at/yedel/fontrast/mixin/FontMixin_Advanced.java` | `value={Font.class})` | ModifyExpressionValue:1 | fontrast$getShadowOffset$drawInBatch8xOutline |
| top-level / `at/yedel/fontrast/mixin/FontMixin_Basic.java` | `value={Font.class})` | ModifyExpressionValue:3, Inject:1 | fontrast$isBold$init, fontrast$isBold$drawInBatch8xOutline, fontrast$isObfuscated, fontrast$storeTargettedGlyph |
| top-level / `at/yedel/fontrast/mixin/FontSetMixin.java` | `value={FontSet.class})` | Inject:1 | fontrast$useLegacyObfuscation |
| top-level / `at/yedel/fontrast/mixin/GlyphInstanceMixin.java` | `targets={"net.minecraft.client.gui.font.glyphs.BakedSheetGlyph$GlyphInstance"})` | ModifyExpressionValue:1 | fontrast$isBold |
| top-level / `at/yedel/fontrast/mixin/PreparedTextBuilderMixin_Advanced.java` | `targets={"net.minecraft.client.gui.Font$PreparedTextBuilder"})` | ModifyExpressionValue:2 | fontrast$getShadowOffset$accept, fontrast$getBoldOffset |
| top-level / `at/yedel/fontrast/mixin/PreparedTextBuilderMixin_Basic.java` | `targets={"net.minecraft.client.gui.Font$PreparedTextBuilder"})` | ModifyExpressionValue:5, ModifyArg:1 | fontrast$isBold, fontrast$isStrikethrough, fontrast$isUnderlined, fontrast$getTextColor, fontrast$getShadowColor, fontrast$getShadowScale |
| top-level / `at/yedel/fontrast/utils/FontrastModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `at/yedel/fontrast/utils/FontrastModToggle.java` | `` |  | isEnabled, setEnabled |
| top-level / `at/yedel/fontrast/utils/TargettedGlyphInfo.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
