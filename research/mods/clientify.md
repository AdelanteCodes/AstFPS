# Clientify

Review status: **Evidence inventory; behavioral review pending**

Project: [Clientify](https://modrinth.com/mod/clientify)
Selected artifact version: `1.0.2+26.3`
Published implementation source: https://github.com/xarlaq/clientify
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Combines the most popular HUD, PvP, and quality-of-life features into a single lightweight mod.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `6d9997fa338e80aef385923cd6456654ab325498`
- `sha512`: `2d822bc3a7ceb7173444c7fc901bdc6ad59930bb59f5bf88ecd45d2bccc6927bd8d08e97fad7b5a0aec3bd755f04449f038c087c8304a85c82d9dd0dd97fa318`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 248
Reconstructed Java files: 129

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "dev.clientify.client.ClientifyClient"
  ],
  "modmenu": [
    "dev.clientify.client.compat.ClientifyModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16.0",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": ">=0.161.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/clientify/client/ClientifyClient.java` | `` |  | id, onInitializeClient |
| top-level / `dev/clientify/client/compat/ClientifyModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `dev/clientify/client/config/ClientifyConfig.java` | `` |  | dir, activeProfile, profileNames, global, waypoints, resetWaypoints, resetGlobal, listPrefs, stem, pathFor, holdsPath, load, readShared, readProfiles, applyProfile, snapshot, write, writeShared, writeProfile, save, switchProfile, createProfile, renameProfile, resetProfile, deleteProfile |
| top-level / `dev/clientify/client/config/GlobalSettings.java` | `` |  |  |
| top-level / `dev/clientify/client/config/ModListPrefs.java` | `` |  | normalised |
| top-level / `dev/clientify/client/config/ModuleSettings.java` | `` |  | padsContent, extra, inset, insetInt, extraW, extraH, insetX, insetY, insetXi, insetYi, applyPositionFrom, applyAppearanceFrom, nearest, vanilla, label, a, b, colorAt, argbAt, chrome, copyFrom, label, copyPositionFrom |
| top-level / `dev/clientify/client/config/ServerProfiles.java` | `` |  | currentKey, currentLabel, boundProfile, bind, applyForCurrentWorld |
| top-level / `dev/clientify/client/gui/GlobalSettingsScreen.java` | `` |  | listScreen, backTarget, onModsTab, onSettingsTab, buildRows, serverBindingRow, bindStep, applyToAllRow, backRect, renderRowsHeader, rowsHeaderClicked |
| top-level / `dev/clientify/client/gui/HudEditorScreen.java` | `` |  | init, snapEnabled, snapText, snapLabel, toggleSnap, targets, selected, isSelected, targetAt, extractBackground, extractRenderState, mouseClicked, mouseDragged, snap, mouseReleased, mouseScrolled, keyPressed, nudge, onClose, Target |
| top-level / `dev/clientify/client/gui/ItemCounterSettingsScreen.java` | `` |  | s, initRows, onRowsRenderStart, anyTextFieldFocused, appendTopRows, searchRow, hintRow, suggestionRow, trackedRow, drawStack |
| top-level / `dev/clientify/client/gui/Logo.java` | `` |  | draw, draw, blit |
| top-level / `dev/clientify/client/gui/MenuFont.java` | `` |  | guiScale, baseFont, ensure, build, lineHeight, lineHeight, width, width, width, draw, draw, draw, draw, draw, drawGlyphs, Glyph |
| top-level / `dev/clientify/client/gui/Menus.java` | `` |  | editor, editorFrom, exit |
| top-level / `dev/clientify/client/gui/ModListScreen.java` | `` |  | listScreen, initMain, backTarget, anyTextFieldFocused, matches, filtered, sort, order, lastUsed, used, sortRect, chipRect, cardX, cardY, contentHeight, renderMain, drawGap, extractRenderState, renderCard, trim, mouseDragged, mouseReleased, dropIndexAt, withoutDragged, moveTo, mainClicked, mouseScrolled |
| top-level / `dev/clientify/client/gui/ModuleIcons.java` | `` |  | has, draw |
| top-level / `dev/clientify/client/gui/ModuleSettingsScreen.java` | `` |  | listScreen, backTarget, onModsTab, initRows, refreshTextFields, onRowsRenderStart, anyTextFieldFocused, s, module, defaults, bgExpandedState, toggleBgExpanded, fieldBox, resetAllHit, indentOf, buildRows, appendTopRows, addPairedFieldRows, textFieldRow, pairedFieldRow, drawCompactField, clickCompactField, fieldRow, templateRow, backRect, resetAllRect, resetPosRect, renderRowsHeader, rowsHeaderClicked |
| top-level / `dev/clientify/client/gui/PanelScreen.java` | `` |  | init, mainClicked, onModsTab, onSettingsTab, anyTextFieldFocused, setTooltip, extractRenderState, closeRect, editLayoutRect, newProfileRect, profileRowRect, profilesBottom, modsTabRect, settingsTabRect, extractBackground, customSidebar, renderCustomSidebar, renderCustomSidebarFooter, clickCustomSidebar, scrollCustomSidebar, sidebarFooterRect, sidebarBottom, sidebarTop, trimTracked, startRename, commitRename, endRename, clickSound, mouseClicked, captureRawMouse, clientify$handleClick, keyPressed, mouseScrolled, onClose |
| top-level / `dev/clientify/client/gui/SettingsRowsScreen.java` | `` |  | alwaysOpaque, initMain, initRows, onRowsRenderStart, rowsHeaderClicked, anyTextFieldFocused, resetX, controlRight, drawReset, resetHit, collapsePicker, withTooltip, withTooltip, unsupported, unsupported, note, section, toggle, toggleSliderRow, sliderRow, sliderRowMarked, unavailable, blurToggle, sliderRowRecommended, sliderTrack, sliderRowIcons, tiles, gearClicked, drawGear, dualToggleGear, toggleGear, button, groupCard, dualToggle, keybindRow, keyPressed, charTyped, rawKeybindRow, rawKeyName, captureRawMouse, captureKeybind, iconSlotX, iconSlotHit, infoRow, pixelGrid, cycleRow, addColorRows, addDualColorRows, drawColorCell, colorRow, pickerRow, gradient, speedVisible, spreadVisible, cycleMode, pickerColumnLayout, miniTrack, svRect, hueRect, opacityTrack, grow, activeHex, activeRgb, writeAlpha, writeActive, syncHexBox, applyHex, clamp01, addGeneralAppearanceRows, addGeneralAppearanceRows, addColorAppearanceRows, addColorAppearanceRows, shadowFontRow, borderRow, showBackgroundRow, roundedCornersRow, roundedRow, radiusTrack, resetBackgroundGroup, drawPill, drawPillDim, typingValue, numeric, beginTyping, endTyping, valueLabel, valueHit, drawSlider, renderMain, contentHeight, mainClicked, mouseDragged, onDragFinished, mouseReleased, mouseScrolled, Row |
| top-level / `dev/clientify/client/gui/Textures.java` | `` |  | ensure, register, cornerMask, ringMask, ringMask, ring, icon, glyphMask, search, gear, pencil, arrowLeft, importGlyph, copyGlyph, shareGlyph, onBar, trash, reset, move, inTriangle, sign, close, eye, sun, moon, segDist |
| top-level / `dev/clientify/client/gui/Ui.java` | `` |  | g, accent, accentDim, accentSoft, panel, card, cardHover, str, strShadow, title, sw, swTitle, caps, capsW, card, pill |
| top-level / `dev/clientify/client/gui/WaypointImportScreen.java` | `` |  | init, overAdd, overCancel, extractRenderState, mouseClicked, onClose, isPauseScreen |
| top-level / `dev/clientify/client/gui/WaypointSettingsScreen.java` | `` |  | initRows, startWorldRename, commitWorldRename, onRowsRenderStart, anyTextFieldFocused, all, filtered, serverCount, customSidebar, entries, rowRect, renderCustomSidebar, worldColor, drawEye, trim, renderCustomSidebarFooter, clickCustomSidebar, scrollCustomSidebar, buildRows, deleteRow, searchRow, cardRow, distanceText, expanded, waypointHeaderRow, sharePopupRect, renderSharePopup, sharePopupClicked, setTooltipIfOver, openIconPicker, renderMain, hideRowWidgets, pickerRect, renderIconPicker, confirmRect, renderConfirm, drawConfirmButton, brighten, mouseClicked, mouseScrolled, keyPressed, rowsHeaderClicked, Held, Entry |
| top-level / `dev/clientify/client/gui/widget/GlassButton.java` | `` |  | onPress, extractContents, updateWidgetNarration |
| top-level / `dev/clientify/client/gui/widget/GlassEditBox.java` | `` |  | setPlaceholder, keyPressed, resizeTo, moveTo, extractWidgetRenderState |
| top-level / `dev/clientify/client/hud/BlurBackdrop.java` | `` |  | vFlip, newFrame, unsupportedReason, wantsBlur, blurOverride, clampStrength, prepare, capture, say, ensureTarget, close |
| top-level / `dev/clientify/client/hud/ChromeMask.java` | `` |  | enabled, beginFrame, draw, claim, scissor |
| top-level / `dev/clientify/client/hud/FeatureModule.java` | `` |  | isHudElement, unscaledWidth, unscaledHeight, render |
| top-level / `dev/clientify/client/hud/Fonts.java` | `` |  | style |
| top-level / `dev/clientify/client/hud/HudFrame.java` | `` |  | begin, token |
| top-level / `dev/clientify/client/hud/HudModule.java` | `` |  | id, displayName, category, description, outlineRadius, isHudElement, hasAppearance, hasBackgroundSection, wantsBlur, hasColorSection, tick, appendSettings, textFields, appendTextFieldGear, settingsScreen, pairTextFields, textFieldIcon, hasScaleSlider, drawChromeLocal, paintChromeLocal, drawChromeScreen, drawChromeScreen, paintChromeScreen, settings, setSettings, isEnabled, settingsClass, createDefaultSettings, cycle, bounds, setPosition, clampScale, minScale, maxScale, draggables, bounds, moveTo, scaleBy, partBounds, partMoveTo, Rect, contains, TextField, inGear |
| top-level / `dev/clientify/client/hud/HudText.java` | `` |  | ascent, width, width, trailing, lineHeight, lineHeight, draw, draw, draw, draw, styled, width, width, width, drawsWhole, drawComponent, drawComponent, uniform, draw, draw, Styled |
| top-level / `dev/clientify/client/hud/ModuleManager.java` | `` |  | init, register, warnAboutMissingIcons, all, renderHud, tick, save, profiles, activeProfile, switchProfile, createProfile, renameProfile, resetProfile, deleteProfile |
| top-level / `dev/clientify/client/hud/SmallCaps.java` | `` |  | index, ensure, advance, width, draw, pass, shadowOf |
| top-level / `dev/clientify/client/hud/Templated.java` | `` |  |  |
| top-level / `dev/clientify/client/hud/TextHudModule.java` | `` |  | segments, lineSegments, measureText, ensureLaidOut, effectiveLines, buildLines, ascent, specFor, radius, outlineRadius, lineWidth, unscaledWidth, unscaledHeight, measureWidth, measureHeight, render, renderVanilla, Seg |
| top-level / `dev/clientify/client/modules/ActionBarModule.java` | `` |  | description, hasColorSection, settingsClass, createDefaultSettings, active, get, appendSettings, draggables, textWidth, unscaledWidth, unscaledHeight, renderMessage, render |
| top-level / `dev/clientify/client/modules/ArmorHudModule.java` | `` |  | slotSprite, description, settingsClass, createDefaultSettings, hasColorSection, expand, appendSettings, pieces, stacks, damageColor, duraSegs, lines, segsWidth, segsWidth, linesWidth, linesWidth, lineH, lineH, maxTextW, unscaledWidth, unscaledHeight, rowHeight, connected, textSuppressed, pieceGap, rowPieceGap, rowGap, cell, drawStrip, drawStripVertical, drawIcon, drawLine, pieceSize, pieceSize, drawPieceBlock, draggables, bounds, scaleBy, moveTo, render, applyPositionFrom, PieceRef, TextSeg |
| top-level / `dev/clientify/client/modules/AttackIndicatorModule.java` | `` |  | art, defaultBar, defaultMark, description, category, isHudElement, hasAppearance, hasColorSection, settingsClass, createDefaultSettings, active, vanillaStatus, appliesToHeldItem, isReady, shownProgress, barColor, targetInRange, boxSize, positionFor, atVanillaSpot, changeMode, unscaledWidth, unscaledHeight, draggables, render, tint, fillOf, clipToCharge, renderVanillaStyle, ensureTextures, upload, tick, weaponThresholdText, pixelAt, setPixel, expand, cycleGrid, resize, setLoadingGrid, setReadyGrid, appendSettings, label, label, label, label, sound |
| top-level / `dev/clientify/client/modules/BossBarModule.java` | `` |  | description, hasAppearance, settingsClass, createDefaultSettings, active, get, drawBackdrop, appendSettings, expand, barTint, hideBar, overLimit, hideText, draggables, unscaledWidth, unscaledHeight, render |
| top-level / `dev/clientify/client/modules/CoordsModule.java` | `` |  | description, settingsClass, createDefaultSettings, hasColorSection, appendSettings, toggleExpand, partColorRows, applyColorsToAll, coord, biomeName, prettify, x, y, z, dir, biome, uw, uw, cellW, cellW, lineH, lineH, placeholder, vLines, buildVLines, hostIndex, hCells, buildHCells, dirGap, verticalContentW, verticalLineCount, ensureSized, unscaledWidth, unscaledHeight, measureWidth, measureHeight, drawCell, drawCell, visibleParts, partW, partH, draggables, bounds, scaleBy, moveTo, render, applyAppearanceFrom, applyPositionFrom, Cell, PartRef |
| top-level / `dev/clientify/client/modules/CrosshairModule.java` | `` |  | defaultPixels, resizeGrid, replacesVanilla, renderCurrent, description, category, isHudElement, settingsClass, createDefaultSettings, pixelAt, setPixel, paintPixel, appendSettings, expand, highlightTint, playerVisible, cycleSize, ensureCustomTexture, renderCrosshair, unscaledWidth, unscaledHeight, render, label, label |
| top-level / `dev/clientify/client/modules/CustomTextModule.java` | `` |  | description, hasAppearance, wantsBlur, hasScaleSlider, settingsClass, createDefaultSettings, lines, view, padded, expand, textFields, appendTextFieldGear, appendSettings, paintBox, boxSize, unscaledWidth, unscaledHeight, draggables, bounds, moveTo, scaleBy, render, applyAppearanceFrom, applyPositionFrom |
| top-level / `dev/clientify/client/modules/EffectsHudModule.java` | `` |  | hideVanillaActive, description, settingsClass, createDefaultSettings, appendSettings, iconCell, cellInset, textGap, stripPadX, stripPadY, rowGap, effects, name, time, blinkAlpha, redShift, applyFx, textW, lineH, linesFor, blockSize, maxBlock, unscaledWidth, unscaledHeight, drawEffectBlock, render, label |
| top-level / `dev/clientify/client/modules/FpsModule.java` | `` |  | description, settingsClass, createDefaultSettings, template, setTemplate, placeholder, defaultTemplate, label, value, measureText, segments |
| top-level / `dev/clientify/client/modules/FullbrightModule.java` | `` |  | gammaOverride, description, category, isHudElement, tick, settingsClass, createDefaultSettings, appendSettings, unscaledWidth, unscaledHeight, render |
| top-level / `dev/clientify/client/modules/GuiScaleModule.java` | `` |  | description, category, isHudElement, settingsClass, createDefaultSettings, active, hotbarScale, pushHotbarScale, hotbarScaled, targetScale, menuTarget, canvas, layoutWidth, layoutHeight, beginScreenDraw, endScreenDraw, canvasWidth, canvasHeight, mouseFactor, tagPictureInPicture, scalePictureBounds, beginPictureInPicture, endPictureInPicture, scalePicture, scalePicture, itemAtlasScale, appendSettings, tick, unscaledWidth, unscaledHeight, render |
| top-level / `dev/clientify/client/modules/HitboxModule.java` | `` |  | replacesVanilla, description, category, isHudElement, settingsClass, createDefaultSettings, expand, appendSettings, pair, catBody, unscaledWidth, unscaledHeight, render, catFor, living, boxOf, drawBox, emitGizmos |
| top-level / `dev/clientify/client/modules/HitColorModule.java` | `` |  | description, category, isHudElement, settingsClass, createDefaultSettings, appendSettings, tick, unscaledWidth, unscaledHeight, render, armorFlashEnabled, setArmorOverlay, clearArmorOverlay, overrideArmorOverlay |
| top-level / `dev/clientify/client/modules/ItemCounterModule.java` | `` |  | description, settingsClass, createDefaultSettings, hasAppearance, wantsBlur, hasScaleSlider, settingsScreen, settings2, view, padded, matches, count, countText, textWidth, textHeight, chipSize, displayName, visible, unscaledWidth, unscaledHeight, draggables, bounds, moveTo, scaleBy, appendSettings, appendEntryRows, render, drawChip, paintChip, applyAppearanceFrom, applyPositionFrom, countOnIcon |
| top-level / `dev/clientify/client/modules/KeystrokesModule.java` | `` |  | description, category, settingsClass, createDefaultSettings, hasColorSection, textFields, wantsBlur, hasBackgroundSection, s, prune, sampleClicks, defaultKeys, isDown, rawOf, mapping, actionName, rowName, chipLabel, shortKeyName, chipLabelFor, chipSub, groupedLook, groupedShows, groupedChips, blockChips, chip, keyById, keys, seed, advance, drawRings, animOf, pressT, sizeOf, seedPositions, individualChips, unscaledWidth, unscaledHeight, draggables, bounds, moveTo, scaleBy, render, drawChip, fitted, drawLabel, appendSettings, appendGroupedRows, size, size, radius, radius, outline, outline, outlineThickness, outlineThickness, blur, blur, anim, anim, animSpeed, animSpeed, color, addSpaceRows, appendIndividualRows, fieldIndex, appendKeyCard, freshId, expand, lookAccess, size, size, radius, radius, outline, outline, outlineThickness, outlineThickness, blur, blur, anim, anim, animSpeed, animSpeed, color, appendLookRows, copyFrom, applyAppearanceFrom, applyPositionFrom, label, label, ripples, sinks, Chip |
| top-level / `dev/clientify/client/modules/NametagsModule.java` | `` |  | description, settingsClass, createDefaultSettings, active, takeOver, hideAll, scaleFactor, backgroundArgb, textColor, textShadow, showOwnFor, appendSettings |
| top-level / `dev/clientify/client/modules/OverlayModule.java` | `` |  | expand, expandSub, description, category, isHudElement, settingsClass, createDefaultSettings, active, minimalViewBobbing, fireOverlay, hideFirePlayers, hideFireMobs, offHandScale, shieldHeight, hookOpacity, fishingLineColor, fishingLineThickness, xpOrbColor, overlayOpacity, spyglassOpacity, showGroundArrows, showStuckArrows, hidePlacedSkulls, hideArmor, glintAllowed, stainedGlass, hiddenInWorld, syncFoliage, tick, wantedTextures, cycleGlint, addGlass, appendSettings, unscaledWidth, unscaledHeight, render, glintMode |
| top-level / `dev/clientify/client/modules/PingModule.java` | `` |  | onPongResponse, description, settingsClass, createDefaultSettings, tick, appendSettings, template, setTemplate, placeholder, defaultTemplate, label, value, segments, measureText |
| top-level / `dev/clientify/client/modules/ReachModule.java` | `` |  | description, settingsClass, createDefaultSettings, appendSettings, template, setTemplate, placeholder, defaultTemplate, label, value, segments |
| top-level / `dev/clientify/client/modules/SaturationModule.java` | `` |  | description, settingsClass, createDefaultSettings, mode, selectMode, saturation, survivalHud, appendSettings, label, value, segments, lineSegments, template, setTemplate, placeholder, defaultTemplate, unscaledWidth, unscaledHeight, draggables, render, fillSprite, overlayPalette, ensureOverlayTextures, renderOverlay, renderBar, label |
| top-level / `dev/clientify/client/modules/ScoreboardModule.java` | `` |  | description, hasColorSection, settingsClass, createDefaultSettings, active, get, expand, appendSettings, updateContent, measure, demoLines, editorDemo, boundsTitle, boundsLines, unscaledWidth, unscaledHeight, renderSidebar, drawText, wantsBlur, plate, render, Line |
| top-level / `dev/clientify/client/modules/ShulkerTooltipModule.java` | `` |  | hasPreview, renderLocked, tooltipOf, itemAt, active, hideVanillaText, activeSettings, description, category, isHudElement, settingsClass, createDefaultSettings, appendSettings, unscaledWidth, unscaledHeight, render, slots, cols, rows, getWidth, getHeight, extractImage |
| top-level / `dev/clientify/client/modules/SprintModule.java` | `` |  | description, settingsClass, createDefaultSettings, textFields, appendSettings, boostActive, boostedSpeed, tick, label, value, lineSegments, multiplierText |
| top-level / `dev/clientify/client/modules/TabModule.java` | `` |  | description, hasAppearance, wantsBlur, settingsClass, createDefaultSettings, active, get, fillColor, setTransform, beginFrame, endFrame, drawFill, pingColor, appendSettings, draggables, unscaledWidth, unscaledHeight, render, label |
| top-level / `dev/clientify/client/modules/TimeModule.java` | `` |  | description, category, isHudElement, settingsClass, createDefaultSettings, appendSettings, dayClock, isDayClock, overrideDayTime, unscaledWidth, unscaledHeight, render, label |
| top-level / `dev/clientify/client/modules/TitleModule.java` | `` |  | description, hasColorSection, settingsClass, createDefaultSettings, active, get, appendSettings, draggables, lineHeightAt, boundsTitle, boundsSubtitle, unscaledWidth, unscaledHeight, renderTitle, drawLine, colors, render |
| top-level / `dev/clientify/client/modules/TotemModule.java` | `` |  | halfFovTan, clamp, description, tick, category, hasAppearance, settingsClass, createDefaultSettings, active, hidden, positionLocked, rotationLocked, scale, durationFactor, offset, counting, countFor, countText, countRgb, decorateTabName, decorateNameTag, countComponent, nameTagLine, nameTagLineOffset, counterView, counterLines, lineWidth, counterSize, counterShowing, drawCounter, totem, boxSide, unscaledWidth, unscaledHeight, draggables, bounds, moveTo, scaleBy, minScale, maxScale, render, appendSettings, appendCounterRows, expand, applyPositionFrom, label, ownLine, Line, label |
| top-level / `dev/clientify/client/modules/WaypointsModule.java` | `` |  | captureFrame, captureFov, fovZoom, description, category, hasColorSection, draggables, settingsClass, createDefaultSettings, worldKey, serverPrefix, savedWorlds, registerWorld, worldDisplayName, renameWorld, deleteWorld, alreadyHas, dimensionLabel, prettyDim, worldIcon, waypointsIn, currentDimension, shortDim, current, randomColor, tick, markDeath, trimDeaths, isDeathWaypoint, beginWaypoint, settingsScreen, currentList, setSelected, isSelected, addAtPlayer, selectedWaypoint, textFields, moveTo, parseCoord, appendKeybindRows, appendLabelRows, appendBlockRows, appendPlacementRows, iconStack, resolveIcon, suggestIcons, potionEffectName, potionLevel, roman, titleCase, parsePotion, emitGizmos, emitMergedOutline, unscaledWidth, unscaledHeight, render, centroid, drawChip, anchor, IconSuggestion, label |
| top-level / `dev/clientify/client/modules/WeatherModule.java` | `` |  | forced, description, category, isHudElement, settingsClass, createDefaultSettings, appendSettings, tick, unscaledWidth, unscaledHeight, render, label |
| top-level / `dev/clientify/client/modules/ZoomModule.java` | `` |  | description, category, isHudElement, zooming, advanceFrame, magnification, modifyFov, modifyHandFov, handleScroll, tick, settingsClass, createDefaultSettings, appendSettings, unscaledWidth, unscaledHeight, render |
| top-level / `dev/clientify/client/util/BlockOutline.java` | `` |  | cell, silhouette, onSilhouette, edgeKey, Edge |
| top-level / `dev/clientify/client/util/BlockTextures.java` | `` |  | provider, paintAtLoad, border, glass, recolour, nextToDrawn, hide, cropTop, sync, restoreAll, apply, restore, remip, flush, texturesOf, block, blockAtlas, scaleAlpha, onEdge, forEach, snapshot, Op |
| top-level / `dev/clientify/client/util/Colors.java` | `` |  | timeSeconds, parse, format, withAlpha, lerp, chroma, waveT, hsv, rgbToHsv |
| top-level / `dev/clientify/client/util/Directions.java` | `` |  | of |
| top-level / `dev/clientify/client/util/Draw.java` | `` |  | clampRadius, inset, clamp01, mulAlpha, aaFillCorner, aaBorderCorner, smoothRounded, smoothBorder, thickBorder, roundedFill, roundedBorder, smoothRoundedBordered, backdropRounded, backdropRow, smoothRoundedGradient |
| top-level / `dev/clientify/client/util/GlintContext.java` | `` |  | set, get |
| top-level / `dev/clientify/client/util/HoldableKey.java` | `` |  | isHeld, isHeld, isHeld, mouseButtonDown |
| top-level / `dev/clientify/client/util/HookedOnSelf.java` | `` |  |  |
| top-level / `dev/clientify/client/util/HurtColorAccess.java` | `` |  |  |
| top-level / `dev/clientify/client/util/RectSplit.java` | `` |  | subtract, pixelLo, cover, arcInset, split, R, right, bottom, empty, overlaps |
| top-level / `dev/clientify/client/util/TotemCounts.java` | `` |  | pop, of, entries, isEmpty, reset, followConnection |
| top-level / `dev/clientify/client/util/WaypointShare.java` | `` |  | encode, decode, findCode, chatLine, copyToClipboard, fromClipboard, isCodeChar, hexOr, clamp, sane |
| top-level / `dev/clientify/client/util/WaypointShareHandler.java` | `` |  | init, allow, coords, open |
| top-level / `dev/clientify/mixin/client/AbstractContainerScreenMixin.java` | `value={AbstractContainerScreen.class})` | Inject:1 | clientify$lockTooltip |
| top-level / `dev/clientify/mixin/client/AvatarRendererMixin.java` | `value={AvatarRenderer.class})` | Inject:1 | clientify$showOwnName |
| top-level / `dev/clientify/mixin/client/BlockStateRenderShapeMixin.java` | `value={BlockBehaviour.BlockStateBase.class})` | ModifyReturnValue:1 | clientify$hideFoliage |
| top-level / `dev/clientify/mixin/client/BossHealthOverlayMixin.java` | `value={BossHealthOverlay.class})` | WrapMethod:1, WrapOperation:3 | clientify$bossBars, clientify$limitBars, clientify$barColor, clientify$barName |
| top-level / `dev/clientify/mixin/client/CameraHudFovAccessor.java` | `value={Camera.class})` | Accessor:1 |  |
| top-level / `dev/clientify/mixin/client/CameraMixin.java` | `value={Camera.class})` | ModifyReturnValue:2 | clientify$zoomFov, clientify$handFov |
| top-level / `dev/clientify/mixin/client/ClientClockInstanceMixin.java` | `value={ClientClockManager.ClientClockInstance.class})` | ModifyReturnValue:1 | clientify$overrideDayTime |
| top-level / `dev/clientify/mixin/client/ClientClockManagerMixin.java` | `value={ClientClockManager.class})` | Inject:1 | clientify$noteDayClock |
| top-level / `dev/clientify/mixin/client/ClientifyMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `dev/clientify/mixin/client/ClientLevelPrecipitationMixin.java` | `value={ClientLevel.class})` | ModifyReturnValue:1 | clientify$forcePrecipitation |
| top-level / `dev/clientify/mixin/client/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | Inject:2 | clientify$pong, clientify$totemPop |
| top-level / `dev/clientify/mixin/client/DebugRendererMixin.java` | `value={DebugRenderer.class})` | Inject:1 | clientify$hitboxes |
| top-level / `dev/clientify/mixin/client/EntityHitboxDebugRendererMixin.java` | `value={EntityHitboxDebugRenderer.class})` | Inject:1 | clientify$replaceVanillaHitboxes |
| top-level / `dev/clientify/mixin/client/EntityRendererMixin.java` | `value={EntityRenderer.class})` | Inject:3 | clientify$hideGroundArrows, clientify$hideOthersFire, clientify$totemNameTag |
| top-level / `dev/clientify/mixin/client/EquipmentLayerRendererMixin.java` | `value={EquipmentLayerRenderer.class})` | ModifyExpressionValue:1 | clientify$armorOverlay |
| top-level / `dev/clientify/mixin/client/ExperienceOrbRendererMixin.java` | `value={ExperienceOrbRenderer.class})` | ModifyArgs:1 | clientify$orbColor |
| top-level / `dev/clientify/mixin/client/FirstPersonHandsMixin.java` | `value={FirstPersonHandsAndItemsRenderer.class})` | WrapMethod:1, WrapOperation:1 | clientify$lowerShield, clientify$offHandSize |
| top-level / `dev/clientify/mixin/client/FishingHookAccessor.java` | `value={FishingHook.class})` | Accessor:1 |  |
| top-level / `dev/clientify/mixin/client/FishingHookRendererMixin.java` | `value={FishingHookRenderer.class})` | Inject:2, ModifyArg:4, ModifyExpressionValue:1 | clientify$markHookedTarget, clientify$beginHook, clientify$fadeGeometry, clientify$blendableHook, clientify$hookOpacity, clientify$lineColor, clientify$lineThickness |
| top-level / `dev/clientify/mixin/client/FishingHookRenderStateMixin.java` | `value={FishingHookRenderState.class})` |  | clientify$onSelf, clientify$setOnSelf |
| top-level / `dev/clientify/mixin/client/GameRendererMixin.java` | `value={GameRenderer.class})` | Inject:2, WrapOperation:1 | clientify$advanceZoom, clientify$captureFrame, clientify$minimalBob |
| top-level / `dev/clientify/mixin/client/GuiActionBarMixin.java` | `value={Hud.class})` | Inject:1 | clientify$actionBarTweaks |
| top-level / `dev/clientify/mixin/client/GuiAttackIndicatorMixin.java` | `value={Hud.class})` | ModifyExpressionValue:2 | clientify$crosshairIndicator, clientify$hotbarIndicator |
| top-level / `dev/clientify/mixin/client/GuiCrosshairMixin.java` | `value={Hud.class})` | WrapOperation:1 | clientify$customCrosshair |
| top-level / `dev/clientify/mixin/client/GuiEffectsMixin.java` | `value={Hud.class})` | Inject:1 | clientify$hideVanillaEffects |
| top-level / `dev/clientify/mixin/client/GuiOverlayMixin.java` | `value={Hud.class})` | WrapOperation:2, ModifyArg:1 | clientify$fadeOverlay, clientify$fadeScope, clientify$fadeScopeBars |
| top-level / `dev/clientify/mixin/client/GuiRendererMixin.java` | `value={GuiRenderer.class})` | ModifyExpressionValue:1, Inject:1 | clientify$itemAtlasScale, clientify$captureBlurBackdrop |
| top-level / `dev/clientify/mixin/client/GuiRenderStateMixin.java` | `value={GuiRenderState.class})` | Inject:1, ModifyExpressionValue:1 | clientify$tagPicture, clientify$pictureBounds |
| top-level / `dev/clientify/mixin/client/GuiScoreboardMixin.java` | `value={Hud.class})` | Inject:1 | clientify$sidebarTweaks |
| top-level / `dev/clientify/mixin/client/GuiTitleMixin.java` | `value={Hud.class})` | Inject:1 | clientify$titleTweaks |
| top-level / `dev/clientify/mixin/client/HumanoidArmorLayerMixin.java` | `value={HumanoidArmorLayer.class})` | Inject:3 | clientify$armArmorFlash, clientify$disarmArmorFlash, clientify$hideArmorPiece |
| top-level / `dev/clientify/mixin/client/ItemActivationMixin.java` | `value={ItemActivation.class})` | Inject:1 | clientify$totemLength |
| top-level / `dev/clientify/mixin/client/ItemContainerContentsMixin.java` | `value={ItemContainerContents.class})` | Inject:1 | clientify$hideShulkerText |
| top-level / `dev/clientify/mixin/client/ItemLayerFoilMixin.java` | `value={ItemStackRenderState.LayerRenderState.class})` | ModifyVariable:1 | clientify$foil |
| top-level / `dev/clientify/mixin/client/ItemModelResolverMixin.java` | `value={ItemModelResolver.class})` | Inject:2 | clientify$enter, clientify$exit |
| top-level / `dev/clientify/mixin/client/ItemStackMixin.java` | `value={ItemStack.class})` | Inject:1 | clientify$shulkerGrid |
| top-level / `dev/clientify/mixin/client/LightmapExtractorMixin.java` | `value={LightmapRenderStateExtractor.class})` | ModifyExpressionValue:1 | clientify$fullbrightGamma |
| top-level / `dev/clientify/mixin/client/MouseHandlerMixin.java` | `value={MouseHandler.class})` | Inject:1, ModifyReturnValue:2 | clientify$zoomScroll, clientify$screenSpaceX, clientify$screenSpaceY |
| top-level / `dev/clientify/mixin/client/NameTagSubmitMixin.java` | `value={SubmitNodeCollection.class})` | Inject:1 | submitNameTagPart, clientify$nameTags, clientify$tag |
| top-level / `dev/clientify/mixin/client/OptionsMixin.java` | `value={Options.class})` | Inject:1 | clientify$overrideBlurriness |
| top-level / `dev/clientify/mixin/client/OverlayTextureMixin.java` | `value={OverlayTexture.class})` |  | clientify$setHurtColor |
| top-level / `dev/clientify/mixin/client/PictureInPictureRendererMixin.java` | `value={PictureInPictureRenderer.class})` | Inject:2, ModifyExpressionValue:9 | clientify$beginPicture, clientify$endPicture, clientify$prepareX0, clientify$prepareX1, clientify$prepareY0, clientify$prepareY1, clientify$prepareScale, clientify$blitX0, clientify$blitX1, clientify$blitY0, clientify$blitY1 |
| top-level / `dev/clientify/mixin/client/PlayerTabOverlayMixin.java` | `value={PlayerTabOverlay.class})` | ModifyReturnValue:1, WrapMethod:1, ModifyExpressionValue:2, WrapOperation:2, Inject:1 | clientify$totemCounts, clientify$tabList, clientify$hideHeader, clientify$hideFooter, clientify$hideHeads, clientify$tabFills, clientify$pingTweaks |
| top-level / `dev/clientify/mixin/client/ScreenEffectRendererMixin.java` | `value={ScreenEffectRenderer.class})` | WrapOperation:4, Inject:1, ModifyExpressionValue:1 | clientify$fire, clientify$hideTotem, clientify$totemProgress, clientify$totemPlace, clientify$totemSize, clientify$totemSpin |
| top-level / `dev/clientify/mixin/client/ScreenMixin.java` | `value={Screen.class})` | ModifyVariable:4, WrapMethod:1 | clientify$initWidth, clientify$initHeight, clientify$resizeWidth, clientify$resizeHeight, clientify$scaleScreen |
| top-level / `dev/clientify/mixin/client/SkullBlockRendererMixin.java` | `value={SkullBlockRenderer.class})` | Inject:1 | clientify$hideSkulls |
| top-level / `dev/clientify/mixin/client/SpriteContentsAccessor.java` | `value={SpriteContents.class})` | Accessor:6 |  |
| top-level / `dev/clientify/mixin/client/SpriteContentsPaintMixin.java` | `value={SpriteContents.class})` | Inject:1 | clientify$paintOnLoad |
| top-level / `dev/clientify/mixin/client/StuckInBodyLayerMixin.java` | `value={StuckInBodyLayer.class})` | Inject:1 | clientify$hideStuck |
| top-level / `dev/clientify/mixin/client/TextureAtlasInvoker.java` | `value={TextureAtlas.class})` | Invoker:1, Accessor:1 |  |
| top-level / `dev/clientify/mixin/client/WindowMixin.java` | `value={Window.class})` | ModifyReturnValue:2 | clientify$canvasWidth, clientify$canvasHeight |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
