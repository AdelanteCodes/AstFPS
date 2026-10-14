# Not Enough FPS

Review status: **Evidence inventory; behavioral review pending**

Project: [Not Enough FPS](https://modrinth.com/mod/not-enough-framerate)
Selected artifact version: `26.3-1.1.1`
Published implementation source: https://github.com/Thedustbustr/Not-Enough-FPS
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A small mod that increases Minecraft's FPS limit limit to 1000

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `f9696da67b1b1f97dcc1422736c76d173c97cf2fe0195f0333bcfed8f172e28314d19f4a4a6a417bc673eb89b42e772799df75fe5f1ad2a5ae1cfe66a65f718f`
- `sha1`: `07193b80cb8f5587dce242727e71caf5a7701ea5`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 14
Reconstructed Java files: 13

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": []
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.6",
  "fabric-api": ">=0.153.0",
  "sodium": ">=0.9.2",
  "java": ">=25",
  "minecraft": [
    "26.3"
  ]
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/core-1.0.0.jar` | 6 | `net_thedustbuster_libs_core` | No |
| `META-INF/jars/func-1.1.1.jar` | 19 | `net_thedustbuster_libs_func` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/thedustbuster/nef/adaptors/minecraft/text/TextBlockBuffer.java` | `` |  | getLines, merge, addLine, addLine, addLine, addAllLines, addBlank, build, buildWithNoItalics |
| top-level / `net/thedustbuster/nef/adaptors/minecraft/text/TextBuffer.java` | `` |  | getAllText, getFormattingFromString, getTranslation, blank, merge, addAllText, addText, addText, addText, buildWithNoItalics, build, FormattedText |
| top-level / `net/thedustbuster/nef/client/gui/SliderTypingController.java` | `` |  | forWidget, onMouseClicked, cancelTyping, overrideLabelText, onKeyPressed, digitOf, commit, drawOutline |
| top-level / `net/thedustbuster/nef/client/NotEnoughFPSSettings.java` | `` |  |  |
| top-level / `net/thedustbuster/nef/mixins/client/ControlElementAccessor.java` | `value={ControlElement.class})` | Accessor:1 |  |
| top-level / `net/thedustbuster/nef/mixins/client/ControlValueFormatterImplsMixin.java` | `value={ControlValueFormatterImpls.class})` | ModifyConstant:1 | overrideMaxFPS |
| top-level / `net/thedustbuster/nef/mixins/client/MinecraftMixin.java` | `value={Minecraft.class})` | ModifyConstant:1 | replaceUnlimitedCutoff |
| top-level / `net/thedustbuster/nef/mixins/client/OptionsMixin.java` | `value={Options.class})` | Inject:1 | overrideFpsLimit |
| top-level / `net/thedustbuster/nef/mixins/client/SearchWidgetMixin.java` | `value={SearchWidget.class})` | Inject:1 | releaseSearchBoxFocus |
| top-level / `net/thedustbuster/nef/mixins/client/SliderControlElementMixin.java` | `targets={"net.caffeinemc.mods.sodium.client.gui.options.control.SliderControl$SliderControlElement"})` | Inject:4, ModifyArg:1 | self, typing, onMouseClicked, overrideLabelText, drawInteractionOutline, onKeyPressed, onMouseDragged |
| top-level / `net/thedustbuster/nef/mixins/client/SodiumConfigBuilderMixin.java` | `value={SodiumConfigBuilder.class})` | Redirect:1 | buildGeneralPage |
| top-level / `net/thedustbuster/nef/mixins/compat/rso/client/IntegerSliderOptionRowMixin.java` | `targets={"me.flashyreese.mods.reeses_sodium_options.client.gui.frame.option.IntegerSliderOptionRow"})` | Inject:4, ModifyArg:1 | self, typing, sliderX, onControlMouseClicked, overrideLabelText, drawInteractionOutline, onControlKeyPressed, onMouseDragged |
| top-level / `net/thedustbuster/nef/mixins/compat/rso/RSOMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
