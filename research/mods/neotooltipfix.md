# NeoToolTipFix

Review status: **Evidence inventory; behavioral review pending**

Project: [NeoToolTipFix](https://modrinth.com/mod/neotooltipfix)
Selected artifact version: `1.2.1-26.3`
Published implementation source: https://github.com/NGSpace/neotooltipfix
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Makes tooltips wrap to the next line when going off screen. (Fork of tooltipfix)

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `01cd86b67c5a4061f2d6b3f0c430afa4b976b9027f80a0c7ccdf86ddfa68837ab43db15155de68369f16b904b34c9856531ebf3be36a3950b25b44735e3f88c7`
- `sha1`: `ad18d2b61a4d32c0dbd6ed8a37f85227de902fa6`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 4
Reconstructed Java files: 4

**environment**

```json
"client"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/ngspace/neotooltipfix/Helper.java` | `` |  | newFix, shouldFlip, wrapLongLines, wrapNewLines, textWithChildren |
| top-level / `dev/ngspace/neotooltipfix/mixin/FixToolTipMixin.java` | `value={GuiGraphicsExtractor.class})` | ModifyVariable:2, Inject:1 | makeListMutable, fix, modifyRenderX |
| top-level / `dev/ngspace/neotooltipfix/mixin/OrderedTextToolTipAccessor.java` | `value={ClientTextTooltip.class})` | Accessor:1 |  |
| top-level / `dev/ngspace/neotooltipfix/OrderedTextToTextVisitor.java` | `` |  | accept, getText, get |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
