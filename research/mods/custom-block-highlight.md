# Custom Block Highlight (Outline / Overlay)

Review status: **Evidence inventory; behavioral review pending**

Project: [Custom Block Highlight (Outline / Overlay)](https://modrinth.com/mod/custom-block-highlight)
Selected artifact version: `2.92+26.3`
Published implementation source: https://github.com/Tektonikal/CustomBlockHighlight
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Revitalize the block outline.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `9091728ddeae1fe2a54cb837ac94e9ba457d18a3`
- `sha512`: `1e83a028dccbac854ab90d32eccd0ff973de5135af31ff818faf90dd93e230ca8552ee3b1f43778bc44998521c047fc80b6cec03ff8a8d15303382438b341343`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 37
Reconstructed Java files: 27

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "modmenu": [
    "tektonikal.customblockhighlight.config.ModMenuIntegration"
  ],
  "main": [
    "tektonikal.customblockhighlight.CustomBlockHighlight"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "~26.3",
  "yet_another_config_lib_v3": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `tektonikal/customblockhighlight/CBHFeatureRenderer.java` | `` |  | buildGroup, applyExpansion, featureType |
| top-level / `tektonikal/customblockhighlight/config/BlockHighlightConfig.java` | `` |  | getActiveInstance, getLineConfig, lineConfigs, reversedLineConfigs, update, getConfigScreen, update, applyValuesToOptionInstances, getColors, getRainbowCol |
| top-level / `tektonikal/customblockhighlight/config/ConfigManager.java` | `` |  | rethrow, save, save, load, loadPreset, loadFromFile, loadFromJsonString, getPreset |
| top-level / `tektonikal/customblockhighlight/config/EvilInstantStateManager.java` | `` |  | set, get, apply, resetToDefault, sync, isSynced, isDefault, addListener, getBinding |
| top-level / `tektonikal/customblockhighlight/config/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `tektonikal/customblockhighlight/config/screenrenderbullshit/CBHFillRenderInfo.java` | `` |  | CBHFillRenderInfo |
| top-level / `tektonikal/customblockhighlight/config/screenrenderbullshit/CBHLineRenderInfo.java` | `` |  | CBHLineRenderInfo |
| top-level / `tektonikal/customblockhighlight/config/screenrenderbullshit/EvilRenderState.java` | `` |  |  |
| top-level / `tektonikal/customblockhighlight/config/screenrenderbullshit/GuiOutlineRenderer.java` | `` |  | getRenderStateClass, previewRotation, renderToTexture, getTranslateY, getTextureLabel |
| top-level / `tektonikal/customblockhighlight/config/screenrenderbullshit/PresetsScreen.java` | `` |  | loadPreset, init, addButton, extractContents, onClose, extractRenderState, extractBackground, shouldRender |
| top-level / `tektonikal/customblockhighlight/config/Updatable.java` | `` |  |  |
| top-level / `tektonikal/customblockhighlight/CustomBlockHighlight.java` | `` |  | onInitialize, clampTwoOptions, yah, ease, easeFactor, easeF |
| top-level / `tektonikal/customblockhighlight/LineState.java` | `` |  | getEdgeAlpha, getLineFades, fadeOutSides |
| top-level / `tektonikal/customblockhighlight/mixin/GameRendererMixin.java` | `value={GameRenderer.class})` |  |  |
| top-level / `tektonikal/customblockhighlight/mixin/InactivityFpsLimiterMixin.java` | `value={FramerateLimitTracker.class})` | ModifyReturnValue:1 |  |
| top-level / `tektonikal/customblockhighlight/mixin/ShapeOutlineFeatureRendererMixin.java` | `value={ShapeOutlineFeatureRenderer.class})` |  |  |
| top-level / `tektonikal/customblockhighlight/mixin/VoxelShapeAccessor.java` | `value={VoxelShape.class})` | Invoker:1 |  |
| top-level / `tektonikal/customblockhighlight/mixin/YACLScreenMixin.java` | `value={YACLScreen.class})` | WrapMethod:1 |  |
| top-level / `tektonikal/customblockhighlight/Renderer.java` | `` |  | isCubeLike, unitVec3, evilPipeline, getPipeline, withDepth, lineFormat, transformUniform, worldRenderType, startDrawing, finishDraw, flushDraws, drawBoxFill, doEvilMatrixPreparations, drawLineLayer, renderLine, addModelLines, updateModelLines, buildModelLines, syncLines, updateLinesCommon, updateCollisionLines, moveToZero, moveToZero, getSides, isBlockEmpty, getConcealedFaces, getLerpedRGB, getLerpedColor, mainLoop, collectSubmits, drawWorld, tick, isAnythingVisible, usesLineFades, getHitResult, isHoldingValidItem, easeBoxAndEdges, draw, isCrystalObstructed, drawFill, drawOutlines, updateProgresses, exitFades, pick, joinConnected, PendingDraw |
| top-level / `tektonikal/customblockhighlight/util/DepthTestMode.java` | `` |  | getDisplayName |
| top-level / `tektonikal/customblockhighlight/util/FaceMode.java` | `` |  | getDisplayName |
| top-level / `tektonikal/customblockhighlight/util/Line.java` | `` |  | getNormal, moveTo, moveTo, update, render, equals, hashCode |
| top-level / `tektonikal/customblockhighlight/util/OutlineStyle.java` | `` |  | getDisplayName |
| top-level / `tektonikal/customblockhighlight/util/ShapeStyle.java` | `` |  | getDisplayName |
| top-level / `tektonikal/customblockhighlight/util/Tweener.java` | `` |  | update, get, getF, getI, getFloatingRemainder, isAtTarget, getLerped, snapToTarget |
| top-level / `tektonikal/customblockhighlight/util/Util.java` | `` |  | concat, hasNext, next |
| top-level / `tektonikal/customblockhighlight/Vertexer.java` | `` |  | applyExpansion, vertexBoxQuads, vertexQuad, vertexBoxLines, screenSpaceToWorldSpace, worldSpaceToScreenSpace, vertexLine, vertexLine, lineWidth |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
