# CarpetGUI

Review status: **Evidence inventory; behavioral review pending**

Project: [CarpetGUI](https://modrinth.com/mod/carpetgui)
Selected artifact version: `2.0.0+26.3`
Published implementation source: https://github.com/hotpad100c/carpetgui
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

An easy to use GUI for CarpetMod

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `optional`.

Artifact identity:
- `sha1`: `a3b2a59f82cbcfd4e1553273e7aa9c6e58c3885b`
- `sha512`: `70331582c5f56266fd7a1656af9c2b0e57d1da6aefd7dcdc2364101d1a88624840c3ad96a0562649a9bb20a220c190611b60566500439b0342b2476d436edec6`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 140
Reconstructed Java files: 90

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "ml.mypals.carpetgui.CarpetGUI"
  ],
  "client": [
    "ml.mypals.carpetgui.CarpetGUIClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": "*",
  "minecraft": "^26.3",
  "carpet": "*",
  "java": ">=25"
}
```

**accessWidener**

```json
"accesswideners/carpetgui-26.1.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `ml/mypals/carpetgui/accessors/CommandSourceStackAccessor.java` | `` |  |  |
| top-level / `ml/mypals/carpetgui/CarpetGUI.java` | `` |  | onInitialize, getRules, getGamerulesAsRules, getGamerules, getManagerIdentifier, getRules, getDefaults, readDefaultSettingsFromConf, readDefaultSettingsFromOrgConf, getCarpetDefaultsConfigFile, getOrgDefaultsConfigFile, onServerLoadedWorlds, onServerClosed, getPrefabManager, forEachCarpetManager |
| top-level / `ml/mypals/carpetgui/CarpetGUIClient.java` | `` |  | onInitializeClient, getServerAddress |
| top-level / `ml/mypals/carpetgui/localChache/RulesCacheManager.java` | `` |  | saveCache, loadCache, saveRawCache, loadRawCache, saveKnownManagers, loadKnownManagers, serializeRules, serializeTopLevelCategories, deserializeRules, mergeLocaleMap, resolveLocale, extractLocaleMap, sanitize, cacheFile, CacheResult, toRuleData |
| top-level / `ml/mypals/carpetgui/mixin/accessors/CommandSourceStackMixin.java` | `value={CommandSourceStack.class})` |  | carpetGUI$setSilent, carpetGUI$getSilent |
| top-level / `ml/mypals/carpetgui/mixin/accessors/GameRulesAccessor.java` | `value={GameRules.class})` |  |  |
| top-level / `ml/mypals/carpetgui/mixin/accessors/KeyMappingAccessor.java` | `value={KeyMapping.class})` | Accessor:1 |  |
| top-level / `ml/mypals/carpetgui/mixin/accessors/SettngsManagerAccessor.java` | `value={SettingsManager.class})` | Invoker:3 |  |
| top-level / `ml/mypals/carpetgui/mixin/accessors/TypeAccessor.java` | `value={Minecraft.class})` |  |  |
| top-level / `ml/mypals/carpetgui/mixin/CarpetClientNetworkMixin.java` | `value={ClientNetworkHandler.class}, remap=false)` | Inject:1 | hookRulesHandler |
| top-level / `ml/mypals/carpetgui/mixin/CarpetGUIMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `ml/mypals/carpetgui/mixin/compat/ChunkMapRecursionFixMixin.java` | `value={ChunkMap.class}, priority=5000)` | Inject:1 | carpetGUI$breakRecursion |
| top-level / `ml/mypals/carpetgui/mixin/GamerulesMixin.java` | `value={Minecraft.class})` |  |  |
| top-level / `ml/mypals/carpetgui/mixin/ui/AbstractWidgetAccessor.java` | `value={AbstractWidget.class})` | Accessor:4 |  |
| top-level / `ml/mypals/carpetgui/mixin/ui/AbstractWidgetMixin.java` | `value={AbstractWidget.class})` | Inject:2 | carpetGUI$inflate, carpetGUI$mount, carpetGUI$dismount, carpetGUI$parent, carpetGUI$focusHandler, carpetGUI$positioning, carpetGUI$positioning, carpetGUI$margins, carpetGUI$margins, carpetGUI$horizontalSizing, carpetGUI$verticalSizing, carpetGUI$horizontalSizing, carpetGUI$verticalSizing, carpetGUI$mouseDown, carpetGUI$x, carpetGUI$y, carpetGUI$width, carpetGUI$height, carpetGUI$draw, carpetGUI$shouldDrawTooltip, carpetGUI$update, carpetGUI$onMouseDown, carpetGUI$onMouseUp, carpetGUI$mouseUp, carpetGUI$mouseScroll, carpetGUI$mouseDrag, carpetGUI$keyPress, carpetGUI$charTyped, carpetGUI$focusGained, carpetGUI$focusLost, carpetGUI$mouseEnter, carpetGUI$mouseLeave, carpetGUI$onMouseScroll, carpetGUI$onMouseDrag, carpetGUI$onKeyPress, carpetGUI$onCharTyped, carpetGUI$canFocus, carpetGUI$onFocusGained, carpetGUI$onFocusLost, carpetGUI$configure, carpetGUI$cursorStyle, carpetGUI$cursorStyle, carpetGUI$tooltip, carpetGUI$tooltip, carpetGUI$id, carpetGUI$id, carpetGUI$getWrapper, carpetGUI$widgetWrapper, carpetGUI$xOffset, carpetGUI$yOffset, carpetGUI$widthOffset, carpetGUI$heightOffset, applyWidthToWrapper, carpetGUI$updateX, carpetGUI$updateY, carpetGUI$preferredCursorStyle, setHovered |
| top-level / `ml/mypals/carpetgui/mixin/ui/ButtonAccessor.java` | `value={Button.class})` | Accessor:1 |  |
| top-level / `ml/mypals/carpetgui/mixin/ui/ClickableStyleFinderAccessor.java` | `value={ActiveTextCollector.ClickableStyleFinder.class})` | Accessor:2 |  |
| top-level / `ml/mypals/carpetgui/mixin/ui/EditBoxAccessor.java` | `value={EditBox.class})` | Accessor:1, Invoker:1 |  |
| top-level / `ml/mypals/carpetgui/mixin/ui/EditBoxMixin.java` | `value={EditBox.class})` | Inject:1, ModifyExpressionValue:2 | callOwoListener, carpetGUI$onFocusGained, injectFilter, injectFilterButDoItAgain |
| top-level / `ml/mypals/carpetgui/mixin/ui/GuiGraphicsExtractorAccessor.java` | `value={GuiGraphicsExtractor.class})` | Accessor:8 |  |
| top-level / `ml/mypals/carpetgui/mixin/ui/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | captureResize |
| top-level / `ml/mypals/carpetgui/mixin/ui/ScreenAccessor.java` | `value={Screen.class})` |  |  |
| top-level / `ml/mypals/carpetgui/mixin/ui/ScreenMixin.java` | `value={Screen.class})` | ModifyExpressionValue:1 | dontCloseOwoScreens |
| top-level / `ml/mypals/carpetgui/network/BufUtils.java` | `` |  | writeCollection, writeList, readList, readListSafe |
| top-level / `ml/mypals/carpetgui/network/client/CarpetGUIClientPacketHandler.java` | `` |  | handleHelloPacket, handleRuleStackSync, handleRulesPacket, handleCompletePacket, getSelectedLanguage, send, send, handlePartialPacket, buildMergedMap, updateExistingCacheEntry, createCacheEntry, reconcileWithServerRules, refreshCachedCategories, refreshDefaultAndFavoriteRules, openRuleEditScreen, openScreenFromCache |
| top-level / `ml/mypals/carpetgui/network/client/RequestRulesPayload.java` | `` |  | write, type |
| top-level / `ml/mypals/carpetgui/network/client/RequestRuleStackPayload.java` | `` |  | write, type |
| top-level / `ml/mypals/carpetgui/network/PacketIDs.java` | `` |  |  |
| top-level / `ml/mypals/carpetgui/network/RuleData.java` | `` |  | write, getRuleType |
| top-level / `ml/mypals/carpetgui/network/server/CarpetGUIServerPacketHandler.java` | `` |  | handleRequestRules, handleRequestRuleStack, convertLayerToInfo, convertChangeToInfo |
| top-level / `ml/mypals/carpetgui/network/server/HelloPacketPayload.java` | `` |  | write, type |
| top-level / `ml/mypals/carpetgui/network/server/RulesPacketPayload.java` | `` |  | write, type |
| top-level / `ml/mypals/carpetgui/network/server/RuleStackSyncPayload.java` | `` |  | write, type, LayerInfo, write, read, ChangeInfo, write, read, ruleName, managerId |
| top-level / `ml/mypals/carpetgui/ruleStack/Prefab.java` | `` |  | fromJson, getName, getCreatedAt, getSize, isEmpty, getLayers, getBaseline, peek, nextId, pushLayer, popLayer, hasFuture, getFutureLayers, pushFuture, popFuture, clearFuture, resolvedState, toJson |
| top-level / `ml/mypals/carpetgui/ruleStack/PrefabManager.java` | `` |  | init, push, pop, popAllWithoutSave, createPrefab, deletePrefab, switchPrefab, getPendingChanges, getActivePrefab, getActiveName, getAllPrefabs, getPrefab, hasPrefab, diff, save, load, PushResult, values, valueOf, $values |
| top-level / `ml/mypals/carpetgui/ruleStack/RuleChange.java` | `` |  | RuleChange, toJson, fromJson |
| top-level / `ml/mypals/carpetgui/ruleStack/RuleLayer.java` | `` |  | getId, getMessage, getTimestamp, getChanges, toJson, fromJson |
| top-level / `ml/mypals/carpetgui/ruleStack/RuleStackCommand.java` | `` |  | register, mgr, guard, ts, snapshotDisplay, renderChange, doPush, doPop, discard, doStatus, doShowTop, doShowById, renderLayer, doDiff, doPrefabList, doPrefabCreate, doPrefabDelete, doPrefabSwitch, send, success, failure |
| top-level / `ml/mypals/carpetgui/ruleStack/RuleValueSnapshot.java` | `` |  | RuleValueSnapshot, toJson, fromJson, equals |
| top-level / `ml/mypals/carpetgui/ruleStack/SettingsWatcher.java` | `` |  | takeSnapshot, readAllDefaults, makeDefaultSnapshot, applyRule, findRule, visit |
| top-level / `ml/mypals/carpetgui/screen/ruleGroup/RuleCommand.java` | `` |  | RuleCommand, toCommand, tryParse, createCustomCommand, isCustomCommand |
| top-level / `ml/mypals/carpetgui/screen/ruleGroup/RuleGroup.java` | `` |  | RuleGroup |
| top-level / `ml/mypals/carpetgui/screen/ruleGroup/RuleGroupLoader.java` | `` |  | loadAll, loadFile, delete, save, getStrings |
| top-level / `ml/mypals/carpetgui/screen/ruleGroup/RuleGroupScreen.java` | `` |  | createAdapter, build, buildMain, onFilesDrop, buildBottomBar, addCommandToCurrentGroup, saveCurrent, executeCurrent, buildGroupEntry, rebuildRightPanel, buildRow, setGroup |
| top-level / `ml/mypals/carpetgui/screen/rulesEditScreen/RulesEditScreen.java` | `` |  | createAdapter, build, buildMain, keyPressed, saveModifiedRulesAsGroup, onSearch, refreshScreen, setCurrentCategory, getRuleDataStream, rebuildRulesList, buildCategoryRow, matchesRule, onClose, values, valueOf, getName, getDisplayName, $values |
| top-level / `ml/mypals/carpetgui/screen/rulesEditScreen/RuleWidget.java` | `` |  | buildComponent, buildBoolToggle, buildTextInput, sendCommand |
| top-level / `ml/mypals/carpetgui/screen/ruleStack/RuleStackData.java` | `` |  | RuleStackData |
| top-level / `ml/mypals/carpetgui/screen/ruleStack/RuleStackScreen.java` | `` |  | ts, tick, createAdapter, build, buildMain, buildLeftPanel, buildRightPanel, buildBottomButtons, togglePrefabPanel, fillPrefabList, fillNewPrefabInput, rebuildTimeline, rebuildPushHint, timelineNode, selectLayer, selectPending, rebuildChanges, changeCard, valueLabel, onSync, clearChangesPane, requestSync, sendCmd, values, valueOf, $values, values, valueOf, $values |
| top-level / `ml/mypals/carpetgui/screen/ScreenTabBar.java` | `` |  | build, onTabClick, values, valueOf, $values |
| top-level / `ml/mypals/carpetgui/screen/ScreenUtils.java` | `` |  | isKeyDown, buildSpriteToggle, makeMasterContainer, rl, swapTexture, makeTexture, createSaveGroupDialog, showSaveGroupDialog, hideSaveDialog, truncateWithEllipsis, btn, buildTooltip, highlight, DialogResult, compute, compute, Result |
| top-level / `ml/mypals/carpetgui/settings/CarpetGUIConfigManager.java` | `` |  | initializeConfig, getFavoriteRulesConfigPath, readFavoriteRules, writeFavoriteRules, addFavoriteRule, removeFavoriteRule |
| top-level / `ml/mypals/carpetgui/settings/GamerulesDefaultValueSorter.java` | `` |  |  |
| top-level / `ml/mypals/carpetgui/translate/TranslationHelper.java` | `` |  | getCategoryTranslation, getNameTranslation, getDescTranslation, collectExtras, clearCache, resolveBaseName, getTranslations, loadTranslationsFromPath |
| top-level / `ml/mypals/carpetgui/ui/base/BaseOwoScreen.java` | `` |  | init, drawComponentTooltip, extractBackground, extractRenderState, keyPressed, mouseDragged, getFocused, removed, dispose |
| top-level / `ml/mypals/carpetgui/ui/base/BaseParentUIComponent.java` | `` |  | carpetGUI$update, parentUpdate, carpetGUI$draw, queue, carpetGUI$focusHandler, verticalAlignment, verticalAlignment, horizontalAlignment, horizontalAlignment, padding, padding, allowOverflow, allowOverflow, surface, surface, carpetGUI$mount, carpetGUI$inflate, updateLayout, runAndDeferEvents, onChildMutated, carpetGUI$onMouseDown, carpetGUI$onMouseUp, carpetGUI$onMouseScroll, carpetGUI$onMouseDrag, carpetGUI$onKeyPress, carpetGUI$onCharTyped, carpetGUI$updateX, carpetGUI$updateY, childMountingOffset, mountChild, drawChildren, lerpInt, calculateChildSpace, carpetGUI$positioning, carpetGUI$margins |
| top-level / `ml/mypals/carpetgui/ui/base/BaseUIComponent.java` | `` |  | determineHorizontalContentSize, determineVerticalContentSize, carpetGUI$inflate, applySizing, notifyParentIfMounted, carpetGUI$configure, runAndDeferEvents, carpetGUI$update, updateHoveredState, carpetGUI$onMouseDown, carpetGUI$mouseDown, carpetGUI$onMouseUp, carpetGUI$mouseUp, carpetGUI$onMouseScroll, carpetGUI$mouseScroll, carpetGUI$onMouseDrag, carpetGUI$mouseDrag, carpetGUI$onKeyPress, carpetGUI$keyPress, carpetGUI$onCharTyped, carpetGUI$charTyped, carpetGUI$onFocusGained, carpetGUI$focusGained, carpetGUI$onFocusLost, carpetGUI$focusLost, carpetGUI$mouseEnter, carpetGUI$mouseLeave, carpetGUI$cursorStyle, carpetGUI$cursorStyle, carpetGUI$tooltip, carpetGUI$tooltip, carpetGUI$mount, carpetGUI$dismount, carpetGUI$parent, carpetGUI$focusHandler, carpetGUI$positioning, carpetGUI$positioning, carpetGUI$margins, carpetGUI$margins, carpetGUI$horizontalSizing, carpetGUI$horizontalSizing, carpetGUI$verticalSizing, carpetGUI$verticalSizing, carpetGUI$id, carpetGUI$id, carpetGUI$x, carpetGUI$updateX, carpetGUI$y, carpetGUI$updateY, carpetGUI$width, carpetGUI$height, baseX, baseY, hasParent, root, remove, moveTo, fullSize, isInBoundingBox, tooltip, tooltip |
| top-level / `ml/mypals/carpetgui/ui/component/ButtonComponent.java` | `` |  | extractContents, textShadow, textShadow, active, active, carpetGUI$preferredCursorStyle |
| top-level / `ml/mypals/carpetgui/ui/component/DropdownComponent.java` | `` |  | surface, carpetGUI$draw, layout, button, removeChild, closeWhenNotHovered, closeWhenNotHovered, setWidth, carpetGUI$onMouseDown, carpetGUI$draw, playInteractionSound |
| top-level / `ml/mypals/carpetgui/ui/component/LabelComponent.java` | `` |  | text, text, maxWidth, maxWidth, shadow, shadow, color, color, verticalTextAlignment, verticalTextAlignment, horizontalTextAlignment, horizontalTextAlignment, lineHeight, lineHeight, lineSpacing, lineSpacing, textClickHandler, textClickHandler, determineHorizontalContentSize, determineVerticalContentSize, carpetGUI$inflate, wrapLines, textHeight, carpetGUI$draw, drawText, drawTooltip, carpetGUI$shouldDrawTooltip, carpetGUI$onMouseDown, styleAt |
| top-level / `ml/mypals/carpetgui/ui/component/TextBoxComponent.java` | `` |  | textValue, setResponder, drawFocusHighlight, keyPressed, updateX, updateY, setBordered, onChanged, text, setFilter, getFilter, setValue, carpetGUI$preferredCursorStyle, newStream |
| top-level / `ml/mypals/carpetgui/ui/component/TextureComponent.java` | `` |  | determineHorizontalContentSize, determineVerticalContentSize, carpetGUI$draw, visibleArea, resetVisibleArea, visibleArea, blend, blend |
| top-level / `ml/mypals/carpetgui/ui/component/UIComponents.java` | `` |  | button, textBox, textBox, label, texture, texture, dropdown, list, wrapVanillaWidget |
| top-level / `ml/mypals/carpetgui/ui/component/VanillaWidgetComponent.java` | `` |  | hovered, carpetGUI$mount, updateHoveredState, applyToWidget, carpetGUI$inflate, carpetGUI$updateX, carpetGUI$updateY, determineHorizontalContentSize, determineVerticalContentSize, carpetGUI$configure, notifyParentIfMounted, carpetGUI$draw, carpetGUI$shouldDrawTooltip, carpetGUI$onMouseScroll, carpetGUI$onMouseDown, carpetGUI$onMouseUp, carpetGUI$onMouseDrag, carpetGUI$onCharTyped, carpetGUI$onKeyPress |
| top-level / `ml/mypals/carpetgui/ui/container/FlowLayout.java` | `` |  | determineHorizontalContentSize, determineVerticalContentSize, layout, child, children, child, children, removeChild, clearChildren, children, gap, gap, carpetGUI$draw, carpetGUI$inspectorDescriptor, inspectorDescriptor, mountEarly, mountLate |
| top-level / `ml/mypals/carpetgui/ui/container/OverlayContainer.java` | `` |  | child, children, removeChild, layout, determineHorizontalContentSize, determineVerticalContentSize, carpetGUI$draw, drawFocusHighlight, carpetGUI$mount, carpetGUI$dismount, carpetGUI$onMouseDown, carpetGUI$onMouseScroll, carpetGUI$canFocus, childMountX, childMountY, closeOnClick, closeOnClick |
| top-level / `ml/mypals/carpetgui/ui/container/ScrollContainer.java` | `` |  | scrollOffset, maxScroll, child, children, removeChild, child, determineHorizontalContentSize, determineVerticalContentSize, layout, childMountX, childMountY, parentUpdate, computeDelta, carpetGUI$draw, carpetGUI$canFocus, carpetGUI$onMouseScroll, carpetGUI$onMouseDown, carpetGUI$onMouseDrag, carpetGUI$onKeyPress, carpetGUI$onMouseUp, childAt, scrollBy, isInScrollbar, scrollTo, scrollTo, scrollbarThiccness, scrollbarThiccness, scrollbar, scrollbar, scrollStep, scrollStep, fixedScrollbarLength, fixedScrollbarLength, flat, values, valueOf, choose, $values |
| top-level / `ml/mypals/carpetgui/ui/container/UIContainers.java` | `` |  | verticalFlow, horizontalFlow, verticalScroll, overlay |
| top-level / `ml/mypals/carpetgui/ui/core/Color.java` | `` |  | Color, ofArgb, ofRgb, ofFormatting, rgb, argb |
| top-level / `ml/mypals/carpetgui/ui/core/CursorStyle.java` | `` |  | values, valueOf, $values |
| top-level / `ml/mypals/carpetgui/ui/core/HorizontalAlignment.java` | `` |  | values, valueOf, align, $values |
| top-level / `ml/mypals/carpetgui/ui/core/Insets.java` | `` |  | Insets, inverted, add, horizontal, vertical, top, bottom, left, right, of, of, vertical, horizontal, none |
| top-level / `ml/mypals/carpetgui/ui/core/OwoUIAdapter.java` | `` |  | create, inflateAndMount, moveAndResize, dispose, x, y, width, height, getDeltaTicks, extractRenderState, drawTooltip, isMouseOver, setFocused, isFocused, mouseClicked, mouseReleased, mouseDragged, keyPressed, charTyped, mouseScrolled, narrationPriority, updateNarration, isRendering, ofClientWindow, ofWindow, ofWindow, applyStyle, dispose |
| top-level / `ml/mypals/carpetgui/ui/core/OwoUIGraphics.java` | `` |  | of, utilityScreen, getMatrixStack, push, pop, translate, translate, scale, intersectsScissor, drawRectOutline, drawRectOutline, blitTexture, blitTexture, blitTexture, drawGradientRect, averageArgb, drawTooltip, drawTooltip, setTooltipForNextFrameInternal, get, handleTextClick |
| top-level / `ml/mypals/carpetgui/ui/core/ParentUIComponent.java` | `` |  |  |
| top-level / `ml/mypals/carpetgui/ui/core/PositionedRectangle.java` | `` |  | of, of, carpetGUI$x, carpetGUI$y, carpetGUI$width, carpetGUI$height |
| top-level / `ml/mypals/carpetgui/ui/core/Positioning.java` | `` |  | isRelative, absolute, relative, layout, equals, hashCode |
| top-level / `ml/mypals/carpetgui/ui/core/Size.java` | `` |  | Size, of, square, zero |
| top-level / `ml/mypals/carpetgui/ui/core/Sizing.java` | `` |  | inflate, fixed, content, content, fill, fill, isContent, contentFactor, equals, hashCode |
| top-level / `ml/mypals/carpetgui/ui/core/Surface.java` | `` |  | blur, flat, outline |
| top-level / `ml/mypals/carpetgui/ui/core/UIComponent.java` | `` |  | values, valueOf, $values, values, valueOf, $values |
| top-level / `ml/mypals/carpetgui/ui/core/VerticalAlignment.java` | `` |  | values, valueOf, align, $values |
| top-level / `ml/mypals/carpetgui/ui/event/UIEvents.java` | `` |  | newStream, newStream, newStream, newStream, newStream, newStream, newStream, newStream, newStream, newStream |
| top-level / `ml/mypals/carpetgui/ui/event/WindowResizeCallback.java` | `` |  |  |
| top-level / `ml/mypals/carpetgui/ui/inject/GreedyInputUIComponent.java` | `` |  |  |
| top-level / `ml/mypals/carpetgui/ui/inject/UIComponentStub.java` | `` |  |  |
| top-level / `ml/mypals/carpetgui/ui/UI.java` | `` |  | id, debugWarn, debugWarn, play, playButtonSound, playInteractionSound |
| top-level / `ml/mypals/carpetgui/ui/util/EventStream.java` | `` |  | sink, subscribe, addSubscriber, removeSubscriber, regenerateSink, cancel |
| top-level / `ml/mypals/carpetgui/ui/util/FocusHandler.java` | `` |  | updateClickFocus, focused, lastFocusSource, cycle, moveFocus, focus |
| top-level / `ml/mypals/carpetgui/ui/util/NinePatchTexture.java` | `` |  | cornerPatchSize, centerPatchSize, draw, draw, draw, draw, drawStretched, drawRepeated, draw, draw, draw, draw, ifPresent, register, PatchSizing, cornerPatchSize, centerPatchSize |
| top-level / `ml/mypals/carpetgui/ui/util/Observable.java` | `` |  | of, observeAll, observeAll, get, set, observe, notifyObservers |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
