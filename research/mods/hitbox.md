# PolyHitbox (Custom Hitboxes)

Review status: **Evidence inventory; behavioral review pending**

Project: [PolyHitbox (Custom Hitboxes)](https://modrinth.com/mod/hitbox)
Selected artifact version: `v1.3.2`
Published implementation source: https://github.com/Polyfrost/PolyHitbox
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

An extremely customizable hitbox mod, also improving performance of hitbox rendering

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `3323e87928555280e77f2759d000d8842a2bbb0d`
- `sha512`: `344a259e8005557adfe695ef6e2cf1dd2d0ccf9b1ebdf8a2f2f897fc481b1f19e1a65ab96f2f814e1b347728e065d18e1b70fb93ea4bab585d72e75d3e1b762d`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 25
Reconstructed Java files: 19

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    {
      "value": "org.polyfrost.polyhitbox.PolyHitboxClient",
      "adapter": "kotlin"
    }
  ],
  "modmenu": [
    {
      "value": "org.polyfrost.polyhitbox.integration.PolyHitboxModMenuIntegration",
      "adapter": "kotlin"
    }
  ]
}
```

**depends**

```json
{
  "minecraft": "~26.3",
  "fabricloader": ">=0.19.3",
  "oneconfigv1": ">=1.0.0-beta.6",
  "fabric-language-kotlin": "*"
}
```

**breaks**

```json
{
  "combat-hitboxes": "*"
}
```

**accessWidener**

```json
"polyhitbox.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `org/polyfrost/polyhitbox/api/HitboxColorContext.java` | `` |  |  |
| top-level / `org/polyfrost/polyhitbox/api/HitboxColorProvider.java` | `` |  |  |
| top-level / `org/polyfrost/polyhitbox/api/HitboxColors.java` | `` |  | register, unregister, snapshot$PolyHitbox_polyhitbox, disable$PolyHitbox_polyhitbox |
| top-level / `org/polyfrost/polyhitbox/api/HitboxCondition.java` | `` |  | values, valueOf, getEntries |
| top-level / `org/polyfrost/polyhitbox/api/HitboxElement.java` | `` |  | values, valueOf, getEntries |
| top-level / `org/polyfrost/polyhitbox/config/HitboxCategory.java` | `` |  | getDisplayName, getCondition, getPriority, getConfig, setConfig, values, valueOf, getEntries, _init_$lambda$0, _init_$lambda$1, _init_$lambda$2, _init_$lambda$3, _init_$lambda$4, _init_$lambda$5, _init_$lambda$6, _init_$lambda$7, _init_$lambda$8, _init_$lambda$9, _init_$lambda$10, _init_$lambda$11, _init_$lambda$12, compare, match, resolve, logicOf, visualsOf, anyToggled, anythingVisible, resolveColors |
| top-level / `org/polyfrost/polyhitbox/config/HitboxCategoryKt.java` | `` |  |  |
| top-level / `org/polyfrost/polyhitbox/config/HitboxConfig.java` | `` |  | getShowCondition, setShowCondition, getShowGrounded, setShowGrounded, getOverwriteLogic, setOverwriteLogic, getOverwriteVisuals, setOverwriteVisuals, getLineMode, setLineMode, getDashFactor, setDashFactor, getDrawOverEntity, setDrawOverEntity, getHoverColor, setHoverColor, getIframeColor, setIframeColor, getShowSide, setShowSide, getSideColor, setSideColor, getSideHoverColor, setSideHoverColor, getSideIframeColor, setSideIframeColor, getShowOutline, setShowOutline, getOutlineColor, setOutlineColor, getOutlineHoverColor, setOutlineHoverColor, getOutlineIframeColor, setOutlineIframeColor, getOutlineThickness, setOutlineThickness, getShowEyeHeight, setShowEyeHeight, getEyeHeightColor, setEyeHeightColor, getEyeHeightHoverColor, setEyeHeightHoverColor, getEyeHeightIframeColor, setEyeHeightIframeColor, getEyeHeightThickness, setEyeHeightThickness, getShowViewRay, setShowViewRay, getViewRayColor, setViewRayColor, getViewRayHoverColor, setViewRayHoverColor, getViewRayIframeColor, setViewRayIframeColor, getViewRayThickness, setViewRayThickness, resolveColors |
| top-level / `org/polyfrost/polyhitbox/config/ModConfig.java` | `` |  | getEnabled, setEnabled, getHideInF1, setHideInF1, getAccurateHitboxes, setAccurateHitboxes, getToggled, setToggled, getRetainToggle, setRetainToggle, getToggleKeybind, setToggleKeybind, defaultToggleKeybind, migrateSplitOverride, migrateLegacyStyle, legacyThickness, makeTree, addCategory, revaluateToggleProps, shown, functional, switch, checkbox, dropdown, radio, keybind, color, sliderInt, sliderFloat, defaultToggleKeybind$lambda$0, addCategory$lambda$0, addCategory$lambda$1, addCategory$lambda$2, addCategory$lambda$3, addCategory$lambda$4, addCategory$lambda$5, addCategory$lambda$6, addCategory$lambda$7, addCategory$lambda$8, addCategory$lambda$9, addCategory$lambda$10, addCategory$lambda$11, addCategory$lambda$12, addCategory$lambda$13, addCategory$lambda$14, addCategory$lambda$15, addCategory$lambda$16, addCategory$lambda$17, addCategory$lambda$18, addCategory$lambda$20, addCategory$lambda$21, addCategory$lambda$22, addCategory$lambda$23, addCategory$lambda$24, addCategory$lambda$25, addCategory$lambda$26, addCategory$lambda$27, addCategory$lambda$28, addCategory$lambda$29, addCategory$lambda$30, addCategory$lambda$31, addCategory$lambda$32, addCategory$lambda$33, addCategory$lambda$34, addCategory$lambda$35, addCategory$lambda$36, addCategory$lambda$37, addCategory$lambda$38, addCategory$lambda$39, addCategory$lambda$40, addCategory$lambda$41, addCategory$lambda$42, addCategory$lambda$43, addCategory$lambda$44, addCategory$lambda$45, addCategory$lambda$46, addCategory$lambda$47, addCategory$lambda$48, addCategory$lambda$49, addCategory$lambda$50, addCategory$lambda$51, addCategory$lambda$52, addCategory$lambda$53, addCategory$lambda$54, addCategory$lambda$55, addCategory$lambda$56, addCategory$lambda$57, addCategory$lambda$58, addCategory$lambda$59, addCategory$lambda$60, addCategory$lambda$61, addCategory$lambda$62, addCategory$lambda$63, addCategory$lambda$64, addCategory$lambda$65, addCategory$lambda$66, addCategory$lambda$67, addCategory$lambda$81$0, addCategory$lambda$82, addCategory$lambda$83, addCategory$lambda$84, addCategory$lambda$85, functional$lambda$0, functional$lambda$1 |
| top-level / `org/polyfrost/polyhitbox/integration/PolyHitboxModMenuIntegration.java` | `` |  | getModConfigScreenFactory, getModConfigScreenFactory$lambda$0 |
| top-level / `org/polyfrost/polyhitbox/mixin/FogCaptureMixin.java` | `value={FogRenderer.class})` | Inject:1 | polyhitbox$captureFog |
| top-level / `org/polyfrost/polyhitbox/mixin/FovAccessor.java` | `value={Camera.class})` | Invoker:1 |  |
| top-level / `org/polyfrost/polyhitbox/mixin/HitboxRenderMixin.java` | `value={LevelRenderer.class})` | Inject:1 | polyhitbox$submit |
| top-level / `org/polyfrost/polyhitbox/mixin/VanillaHitboxKeyMixin.java` | `value={KeyboardHandler.class})` | Inject:1 | polyhitbox$suppressVanillaToggle |
| top-level / `org/polyfrost/polyhitbox/mixin/VanillaHitboxMixin.java` | `value={EntityHitboxDebugRenderer.class})` | Inject:1 | polyhitbox$suppressVanillaHitbox |
| top-level / `org/polyfrost/polyhitbox/PolyHitboxClient.java` | `` |  | onInitializeClient |
| top-level / `org/polyfrost/polyhitbox/render/FogPoly.java` | `` |  | getX, getY, getZ, getA, getB, getC, getN, setN, add, add, add, refreshDominance, distance, straddles, split |
| top-level / `org/polyfrost/polyhitbox/render/HitboxFog.java` | `` |  | getCutsA, getCutsB, stepCuts, spherical, cylindrical, capture, linearCuts, beginFrame, distanceA, distanceB, dominance, value, linear, apply, mix |
| top-level / `org/polyfrost/polyhitbox/render/HitboxRenderer.java` | `` |  | active, guiHidden, readCamera, partialTick, effectiveFov, quadsType, beginFrame, updateRibbonScale, hiddenGrounded, drawLevel, vanillaVisible, culled, inIframes, pick, tint, drawEntity, styledBox, styledEdge, ribbon, billboardOffset, setClampBoxes, depthScale, slab, fillBox, quad, triangle, cutPieces, fogCuts, crossesFogCut, take, fan, vertex, submitHitboxes, geometry$lambda$0, getEntity, getElement, has |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
