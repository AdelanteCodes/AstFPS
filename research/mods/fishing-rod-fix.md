# Fishing Rod Fix

Review status: **Evidence inventory; behavioral review pending**

Project: [Fishing Rod Fix](https://modrinth.com/mod/fishing-rod-fix)
Selected artifact version: `26.3-v0.6`
Published implementation source: https://github.com/andrewchik0/fishing-rod-fix
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This mod provides fix for old fishing line rendering bug

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `b09baced81af91899a86111c4798233f1aa1d802`
- `sha512`: `aa1ed602ad647129c8620c63c0076c2d3a7a09ef558888c3a24329ccfef15ed4c7721a11a797c5300840baef40f752ff3fe5d2f88cdbd99c63c258463939c6d7`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 25
Reconstructed Java files: 18

**environment**

```json
"client"
```

**depends**

```json
{
  "fabricloader": ">=0.19.0",
  "minecraft": ">=26.3 <=26.3",
  "java": ">=25"
}
```

**breaks**

```json
{
  "enchanted_fishing_line": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/andrewchik/fishingrodfix/FirstPersonRod.java` | `` |  | armPose, anchorOnRestingRod |
| top-level / `com/andrewchik/fishingrodfix/FishingLineOrigin.java` | `` |  | correct, warnIfHandPassUntracked, applyWorldWarp |
| top-level / `com/andrewchik/fishingrodfix/FishingLineVisibility.java` | `` |  | beginExtraction, onFirstPersonOrigin, lineOnFirstPersonRod, decideLineHidden, shouldHideLine, rodDrawn |
| top-level / `com/andrewchik/fishingrodfix/FishingRodFix.java` | `` |  |  |
| top-level / `com/andrewchik/fishingrodfix/HandPass.java` | `` |  | onFrameExtract, onHandPass, sample, sampleHandGate |
| top-level / `com/andrewchik/fishingrodfix/mixin/client/AbstractClientPlayerMixin.java` | `value={AbstractClientPlayer.class})` |  | fishingrodfix$setBodyRod |
| top-level / `com/andrewchik/fishingrodfix/mixin/client/CameraAccessor.java` | `value={Camera.class})` | Accessor:2 |  |
| top-level / `com/andrewchik/fishingrodfix/mixin/client/FirstPersonHandsAndItemsRendererMixin.java` | `value={FirstPersonHandsAndItemsRenderer.class})` | Inject:1 | fishingrodfix$markHandPass |
| top-level / `com/andrewchik/fishingrodfix/mixin/client/FishingHookMixin.java` | `value={FishingHook.class})` |  | fishingrodfix$wasSeenWithRod, fishingrodfix$markSeenWithRod |
| top-level / `com/andrewchik/fishingrodfix/mixin/client/FishingHookRendererMixin.java` | `value={FishingHookRenderer.class})` | ModifyExpressionValue:1, Inject:3, ModifyVariable:3, WrapWithCondition:1 | fishingrodfix$correctFirstPersonOrigin, fishingrodfix$beginExtraction, fishingrodfix$decideLine, fishingrodfix$placeOnDrawnRod, fishingrodfix$lineX, fishingrodfix$lineY, fishingrodfix$lineZ, fishingrodfix$skipHiddenLine |
| top-level / `com/andrewchik/fishingrodfix/mixin/client/FishingHookRenderStateMixin.java` | `value={FishingHookRenderState.class})` |  | fishingrodfix$isLineHidden, fishingrodfix$setLineHidden, fishingrodfix$ownerPartialTicks, fishingrodfix$samePassOnly, fishingrodfix$setBodyRodOwner |
| top-level / `com/andrewchik/fishingrodfix/mixin/client/GameRendererInvoker.java` | `value={GameRenderer.class})` | Invoker:2 |  |
| top-level / `com/andrewchik/fishingrodfix/mixin/client/GameRendererMixin.java` | `value={GameRenderer.class})` | Inject:1 | fishingrodfix$countFrame |
| top-level / `com/andrewchik/fishingrodfix/mixin/client/ItemInHandLayerMixin.java` | `value={ItemInHandLayer.class}, priority=1500)` | Inject:1 | fishingrodfix$readDrawnRod |
| top-level / `com/andrewchik/fishingrodfix/mixin/client/SpriteContentsAccessor.java` | `value={SpriteContents.class})` | Accessor:1 |  |
| top-level / `com/andrewchik/fishingrodfix/RodSprite.java` | `` |  | measureTip, visiblePixels |
| top-level / `com/andrewchik/fishingrodfix/ThirdPersonLineOrigin.java` | `` |  | onFrameStart, bodyDrawnInFirstPerson, beginExtraction, onFirstPersonVanilla, onHookExtracted, onItemSubmitted, readDrawnRod, onHookSubmitted, lineOffset, remember, bodyYaw, disable |
| top-level / `com/andrewchik/fishingrodfix/ThirdPersonRod.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
