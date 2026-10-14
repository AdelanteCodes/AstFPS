# SmoothPlayerAnimations

Review status: **Evidence inventory; behavioral review pending**

Project: [SmoothPlayerAnimations](https://modrinth.com/mod/smoothplayeranimations)
Selected artifact version: `1.1.0+26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Creating smoother animations for players

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `9644765d523cee4360fab588f2aa54b3797dbcafc7b1852489e5eb2bcda775f4a9d6c961d233dc9d6f87d0c9654763a98104f58bdce340bf79aa1a430aa5cb13`
- `sha1`: `76c3b1e2fdf083f82162b7f3759e47fba446bcab`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 147
Reconstructed Java files: 89

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.huaxiaosheng.smoothplayeranimations.SmoothAnimClient"
  ],
  "modmenu": [
    "com.huaxiaosheng.smoothplayeranimations.config.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16.0",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*",
  "player_animation_library": "*",
  "cloth-config": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/AdditiveAnimation.java` | `` |  | neutralProbe, attackAlpha, sourceBone, lerp, isOverride, isActive, tick, setupAnim, get3DTransform, getFirstPersonMode, getFirstPersonConfiguration |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/AimFollowAnimation.java` | `` |  | mirrorSign, isActive, tick, setupAnim, get3DTransform, addAxis, getFirstPersonMode, getFirstPersonConfiguration |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/AnimSpec.java` | `` |  | AnimSpec, on |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/BetterCombatCompat.java` | `` |  | resolveBcWeapon, mainHandHasTwoHandedHoldPose, resolveBcAttack, resolveBcAttackModern, resolveBcAttackLegacy, isBcAttackActive, isBcAttacking, isSharedStack, patchBcAttackAnimations, bcAttackBaseMask, bcAttackKeyframedBones, bcOwnsArms, isBcOwnedLayer |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/BoneGroups.java` | `` |  | parseMask |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/Bones.java` | `` |  | posX, posY, posZ, rotX, rotY, rotZ, scaleX, scaleY, scaleZ, bend, posX, posY, posZ, rotX, rotY, rotZ, scaleX, scaleY, scaleZ, bend, copyTransform, resetNeutral, transform |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/BuiltinHxsGate.java` | `` |  | registerConfigHook, reload, blocked, mitFallback |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/CarryOnCompat.java` | `` |  | present, isCarrying, shouldPose, applyHold, snapshot, query, applyScript, vecComp, resolve |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/CarryOnHoldAnimation.java` | `` |  | isActive, tick, setupAnim, get3DTransform, getFirstPersonMode, getFirstPersonConfiguration |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/CreateCompat.java` | `` |  | isHanging, resolve |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/EasyNpcCompat.java` | `` |  | tick, onRenderer, afterVanillaPose, afterVanillaPose, poseShadow, apply, scanRenderers, install, adopt, findRoot, slim, setModel, driver, resolve, entityId, matchTracked, position, field, customPose, isEasyNpcType, playerType, present, warn, tick, puppet, mirror, copyWalk |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/EmotecraftCompat.java` | `` |  | isPlaying, query, resolve |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/LayeredAnimation.java` | `` |  | isActive, tick, setupAnim, get3DTransform, getFirstPersonMode, getFirstPersonConfiguration |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/MirrorAnimation.java` | `` |  | isKeyframed, isActive, tick, setupAnim, get3DTransform, getFirstPersonMode, getFirstPersonConfiguration |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/MixinAnimCompat.java` | `` |  | ownsArms, armsPosePinnedStanding, musketAiming, queryMusketAiming, musketShouldAimInHand, resolveMusket, watutOwnsArms, resolveWatut, spellEngineCasting, resolveSpell |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/NpcPlayerModel.java` | `` |  | setupAnim |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/ParCoolCompat.java` | `` |  | refresh, isPlaying, resolve, disable |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/PartMaskAnimation.java` | `` |  | delegate, yieldPositionWhenDisplacing, armCrouchCompensation, isArm, compensateArm, normalizeAll, isActive, tick, setupAnim, get3DTransform, passesPositionThrough, isAllowed, normalize, getFirstPersonMode, getFirstPersonConfiguration |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/PlayContext.java` | `` |  | PlayContext, clear, fullBody, masked |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/PlayerAnimManager.java` | `` |  | newSpaLayer, isActive, registerLayers, refreshExclusiveFullBodyOwner, isExclusiveFullBodyOwner, fullBodyOwnedExternally, lanternOwnedExternally, armsOwnedExternally, armsOwnedExternally, lanternAnimation, resetLantern, poseComposer, layer, lowerLayer, upperLayer, getAnimation, clearLengthCaches, cachedLengthTicks, animationLengthTicks, animationEndTick, playerAnimationFor, play, play, playAdditive, playAdditive, playAdditive, playDualAdditive, isOneHandedHold, additiveClip, playAdditiveAttack, play, play, playBase, playBase, playBaseKeyframe, playCemAnimation, layerFor, playMasked, playMasked, pinnedArmCrouchComp, getAsBoolean, retargetBaseArmYield, playCemArmYield, test, isSwinging, swingHand, attackAnim, armYieldsNow, mirrorForHand, isPhysicalRightHand, playMasked, play, playCarryOnHold, playSwapHands, hasOtherActiveLayer, clearAll, clearBase, clearUpper, tickProceduralLayers |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/PunchyCompat.java` | `` |  | isRenderingHands, resolve |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/SittingPlusCompat.java` | `` |  | isSitting, resolve |
| top-level / `com/huaxiaosheng/smoothplayeranimations/anim/SwapHandsAnimation.java` | `` |  | isActive, tick, setupAnim, get3DTransform, apply, envelope, getFirstPersonMode, getFirstPersonConfiguration |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/AirPhase.java` | `` |  | isRising, gaitPlantRight, takeoffPlantRight |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/BetterThirdPersonCompat.java` | `` |  | isActiveFor, resolve |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/CemAnim.java` | `` |  | of, bakesLookFromHeadAngles, applyRootLook, usesHeadAngleIdent, containsIdent, isIdentChar, eval, drivesLocomotion, drivesFace |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/CemContent.java` | `` |  | generation, resourceManager, adoptedPack, facePack, faceAnim, readPackFile, invalidate, rig, clips, newAnimation, hasContent, fullCoverage, isCurrent, bakesLookFromHeadAngles, get, loadFromPack, isFacePack, readSibling, read, readResource, loadBundled, readBundled, AdoptedPack |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/CemLoader.java` | `` |  | loadJem, loadJem, collectFrom |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/CemMath.java` | `` |  |  |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/CemMove.java` | `` |  | project |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/CemPlayerAnimation.java` | `` |  | isDisplacing, onContentReload, isStale, isActive, setupAnim, ensureEvaluated, get3DTransform, reg, restBaseline |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/CemVariableBinding.java` | `` |  | apply, lerp, wrapDeg, renderPartialTick |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/ClipPlayerAnimation.java` | `` |  | onContentReload, isStale, isActive, setupAnim, ensureEvaluated, add, addStride, frac, liveHeadRad, get3DTransform, partIndex |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/ClipSet.java` | `` |  | get, size, parse, requireObject, table, lerpInto |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/EmfCompat.java` | `` |  | bootstrap, onResourceReload, syncPlayerShield, restoreOnExit, tick, isWanted, apply, disabledSet, ownedIds, migrateLegacyMarker, persistOwnedIds |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/EtfFaceCompat.java` | `` |  | resolve, resolveMethods, Skin, vanilla |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/EvalContext.java` | `` |  | get, set, has, clear |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/FaceOverlay.java` | `` |  | invalidate, active, frameId, load, bake, walk, ch, resolvePlayer, resolvePlayer, emit, parsePart, parsePart, addBox, str, texSize, floats, floats4 |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/FaPackAutoReload.java` | `` |  | tick, currentExpressionPackIds |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/FiguraCompat.java` | `` |  | hidesVanillaHead, editAllowed, resolve |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/HeadLookComposition.java` | `` |  | axis |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/HybridPlayerAnimation.java` | `` |  | onContentReload, isStale, isActive, setupAnim, ensureEvaluated, addLayer, clamp01, get3DTransform, partIndex |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/HybridRig.java` | `` |  | clip, clipCount, ctrl, evalVars, pose, sample, idx, evalVec, safe, catmull, rotZYX, mul3, apply3, flip, eulerZYX, parse, parseChan, parseVec |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/LeaWindCompat.java` | `` |  | isActiveFor, resolve, ownsYaw, suppressLookVars |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/MolangExpr.java` | `` |  |  |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/MolangFunctions.java` | `` |  | isFunction, apply, wrapRad, in, random |
| top-level / `com/huaxiaosheng/smoothplayeranimations/cem/MolangParser.java` | `` |  | parse, expr, logicalOr, logicalAnd, equality, comparison, additive, multiplicative, unary, cmp, readRawToken, consumeToMatchingParen, match, primary, identifierOrCall, call, ifCall, number, binary, peekOp, skipWs, peek, expect, isDigit, isIdentStart, isIdentPart |
| top-level / `com/huaxiaosheng/smoothplayeranimations/ClientGui.java` | `` |  | screen, setScreen, overlayOpen |
| top-level / `com/huaxiaosheng/smoothplayeranimations/config/ConfigGui.java` | `` |  | init, registerToggle, request, getValue, getDefaultValue, isEdited, save, extractRenderState, place, children, narratables, getValue, getDefaultValue, isEdited, save, extractRenderState, children, narratables |
| top-level / `com/huaxiaosheng/smoothplayeranimations/config/ItemRulesScreen.java` | `` |  | copyRules, visibleRows, cycle, init, mouseScrolled, scrollTo, mouseClicked, mouseDragged, mouseReleased, extractRenderState, onClose, cols, totalRows, visibleRows, init, mouseScrolled, scrollTo, mouseClicked, mouseDragged, mouseReleased, extractRenderState, onClose |
| top-level / `com/huaxiaosheng/smoothplayeranimations/config/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/huaxiaosheng/smoothplayeranimations/config/SmoothAnimConfig.java` | `` |  | register, normalize, get, toRules, label, label, tooltip, label, tooltip, label, tooltip, swingRule |
| top-level / `com/huaxiaosheng/smoothplayeranimations/motion/PlayerMomentum.java` | `` |  | addRunwardImpulse |
| top-level / `com/huaxiaosheng/smoothplayeranimations/pose/BoneOffset.java` | `` |  | additive, rot, pos |
| top-level / `com/huaxiaosheng/smoothplayeranimations/pose/JellyContributor.java` | `` |  | isActive, tick, contribute, order, reset, lerp, clamp |
| top-level / `com/huaxiaosheng/smoothplayeranimations/pose/LanternItems.java` | `` |  | isLantern |
| top-level / `com/huaxiaosheng/smoothplayeranimations/pose/LanternPhysics.java` | `` |  | tick, pitch, roll, reset, initialize, wrapDegrees, lerp, clamp, tick, reset |
| top-level / `com/huaxiaosheng/smoothplayeranimations/pose/LanternPhysicsAnimation.java` | `` |  | isActive, tick, setupAnim, get3DTransform, itemSide, currentHeldMask, reset |
| top-level / `com/huaxiaosheng/smoothplayeranimations/pose/LeanContributor.java` | `` |  | tick, contribute, reset, isActive, order, isMovingHorizontally, clamp |
| top-level / `com/huaxiaosheng/smoothplayeranimations/pose/PoseBuilder.java` | `` |  | current, boneName, get, set, add |
| top-level / `com/huaxiaosheng/smoothplayeranimations/pose/PoseComposer.java` | `` |  | add, isActive, tick, setupAnim, get3DTransform, getFirstPersonMode, getFirstPersonConfiguration |
| top-level / `com/huaxiaosheng/smoothplayeranimations/pose/PoseContributor.java` | `` |  |  |
| top-level / `com/huaxiaosheng/smoothplayeranimations/pose/Spring.java` | `` |  | addImpulse, tick, value, reset |
| top-level / `com/huaxiaosheng/smoothplayeranimations/render/FaceOverlayLayer.java` | `` |  | submit |
| top-level / `com/huaxiaosheng/smoothplayeranimations/render/FaceOverlayRenderTypes.java` | `` |  | skin, emissive, submit |
| top-level / `com/huaxiaosheng/smoothplayeranimations/render/LanternItemModelProperty.java` | `` |  | enabled, get, type, registerFabric |
| top-level / `com/huaxiaosheng/smoothplayeranimations/SmoothAnim.java` | `` |  | id |
| top-level / `com/huaxiaosheng/smoothplayeranimations/SmoothAnimClient.java` | `` |  | onInitializeClient, getFabricId, onResourceManagerReload, registerCore, onReload, clientTick, resetActivePlayers |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/ActionController.java` | `` |  | clearUpperPlayback, forgetOffHold, resetActionObservation, forceRelease, forceRelease, actionFade, scaledToolFade, handleProjectileRelease, updateChargeTracking, isCrossbowCharged, tick, playHoldIfAvailableElse, handleCarryOn, noteHandSwap, handleSwapHands, handleToolSwing, handleItemUse, handleCrossbowReady, handleHoldRule, matchHold, playDualHold, isLantern, handleMapHold, handleUniversalYield, releaseIfExpired, releaseIfHolding, useActionEnabled, HoldMatch |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/ActionLogic.java` | `` |  | mirrorForHand, minimumReleaseTicks, crossbowFired |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/AirborneHeight.java` | `` |  | liftoff, land, update, peakRise |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/content/Anims.java` | `` |  |  |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/content/IdleItemAnimations.java` | `` |  | entry, forItem, Entry |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/content/ItemAnimationRules.java` | `` |  | applyConfigRules, registerConfigHook, match, reload, parseRule, parseKind, parseType, str, Rule |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/content/RidingAnimations.java` | `` |  | paddles, forVehicle, PaddleStroke, any, turnDir, RideAnims, paddleSelect, select |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/content/ToolAnimations.java` | `` |  | resolveSwing, swingCategoryFor, swingEnabled, isSpear, ResolvedSwing |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/IdleBehaviorController.java` | `` |  | handleIdleFidget, planWindow, tryStartHeldItemIdle, tryPlayFidget |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/movement/BasicMovement.java` | `` |  | addTier, addIdleTier, addIdleTier, addConditionalTier, addConditionalTier, addConditionalTier, addConditionalTier, selectTier, idleTier, select, clipFor, isIdle, pick, Selection |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/movement/BasicMovementRegistry.java` | `` |  | forEnvironment, rideBusy, rideStraight |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/PlayerSnapshot.java` | `` |  | update, updateGroundContact, updateStateFlags, updateBoatPaddles, updateMovementAndSpeed, updateJumpAndDescent, updateSlimeAndFalling, classifyAirborne, updateOrientation, commitHistory, isSupportingSlime, scanSlimeBelow, entityPos, entityWorld |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/PlayerStateMachine.java` | `` |  | tick, maybeApplySkidMomentum, tickUpperBody, debounce, handleFidgetPhase, replayIfChanged, resolvePlayContext, armYieldMask, bundledCovers, applyPlayContext, resolveBasicSelection, isStateEnabled |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/rules/Environment.java` | `` |  | classify, borrowsGroundUpper, usesCemBase |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/rules/EnvironmentRules.java` | `` |  | add, classify, Rule |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/rules/LocomotionRules.java` | `` |  | jumpClipTicks, fallEnd, stepDownFoot, build |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/rules/LocomotionState.java` | `` |  | animId, isBasicMove, group, speedTier, debouncesWith, isSpeedUpFrom |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/rules/StateRule.java` | `` |  | StateRule |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/rules/StateSelector.java` | `` |  | add, select, select |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/SelectionDebouncer.java` | `` |  | update, reset, accept, clearPending |
| top-level / `com/huaxiaosheng/smoothplayeranimations/state/UpperBodyMode.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
