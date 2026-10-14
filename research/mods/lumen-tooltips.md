# Lumen Tooltips

Review status: **Evidence inventory; behavioral review pending**

Project: [Lumen Tooltips](https://modrinth.com/mod/lumen-tooltips)
Selected artifact version: `26.3-b8+fabric`
Published implementation source: https://github.com/noramibu/lumen-tooltips/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

An highly customizable tooltip mod for extending tooltips (with previews and more), anti-crash and bug fixes.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `c064968a409373a4203c432eb459c003eca60f6e82f189058b7f31c0d4ad0fc2dd234ea06cecc1858dbf4e7bf6947ffd20649c4e3436c4a1a220758efdabbcbe`
- `sha1`: `0437d38ed4bcfea4af0070760ebd53c34c88ade8`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 119
Reconstructed Java files: 76

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "me.noramibu.lumentooltips.fabric.FabricLumenTooltips"
  ],
  "modmenu": [
    "me.noramibu.lumentooltips.fabric.LumenModMenu"
  ]
}
```

**depends**

```json
{
  "java": ">=25",
  "minecraft": "~26.3",
  "fabricloader": ">=0.19.3",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/noramibu/lumentooltips/client/FabricItemEditorApi.java` | `` |  | install, openStorage, openInventorySlot, save, saveToTarget, saveFirstAvailable, tryPages, createAndSave, add, duplicate, outcome |
| top-level / `me/noramibu/lumentooltips/client/LumenChat.java` | `` |  | message |
| top-level / `me/noramibu/lumentooltips/client/LumenItemEditor.java` | `` |  | isAvailable, trySaveToStorage, openInventorySlot, saveToStorage, keyReleased, handleStorageLink, finishSave, feedback, showFeedback, from |
| top-level / `me/noramibu/lumentooltips/client/LumenParticleBudget.java` | `` |  | allow |
| top-level / `me/noramibu/lumentooltips/client/LumenParticleEffects.java` | `` |  | group, limit, hasSpace, track, clear |
| top-level / `me/noramibu/lumentooltips/client/screen/LumenConfigScreen.java` | `` |  | init, keyPressed, keyReleased, mouseClicked, extractRenderState, onClose, rebuildPage, addFooter, addPageWidget, changePage, navigateBack, openCategory, resetCurrentMenu, currentMenuOptions, visibleCategories, addAdvancedToggle, isAdvanced, startKeyCapture, stopKeyCapture, renderPreviewTooltips, modifiedPreview, renderDescriptionTooltip, renderTooltip, previewLines, tooltipWidth, tooltipHeight, previewX, previewY, sliderValue, sliderMaxValue, category, subCategory, isHoldBinding, isCentralControl, optionIcon, itemIcon, setConfigValue, createControl, click, reset, changed, controlMessage, conflictMessage, onClick, onRelease, updateMessage, applyValue, sliderConfigValue, Category, CategoryPlacement, insertText |
| top-level / `me/noramibu/lumentooltips/client/screen/LumenContainerOpener.java` | `` |  | tryOpen, isBook, isContainer, open, previewConfig, openBook |
| top-level / `me/noramibu/lumentooltips/client/screen/LumenContainerScreen.java` | `` |  | init, extractLabels, breadcrumbLabel, mouseClicked, mouseReleased, keyPressed, isPauseScreen, onClose, closeSound, createMenu, menuType |
| top-level / `me/noramibu/lumentooltips/client/screen/LumenScreenOpener.java` | `` |  | openConfig, openPending |
| top-level / `me/noramibu/lumentooltips/command/LumenClientCommand.java` | `` |  | register, tryHandle, toggleStatistics, registerAlias, command, feedback |
| top-level / `me/noramibu/lumentooltips/config/ConfigOption.java` | `` |  | ConfigOption, toggle, hiddenComponent, integer, number, percent, numeric, keyBind, text, enumCycle, holdMode, inputHoldMode, enumCycle, create, title, description, translated, matchesSearch, getAsString, valueComponent, colored, durabilityPreview, enchantmentPreview, foodPreview, comparisonPreview, navigationPreview, controlHintPreview, setFromString, cycle, cycleInteger, cycleValue, languageKey, enumValue |
| top-level / `me/noramibu/lumentooltips/config/ContainerPreviewAlignment.java` | `` |  | displayName |
| top-level / `me/noramibu/lumentooltips/config/ContainerPreviewMode.java` | `` |  | displayName |
| top-level / `me/noramibu/lumentooltips/config/ContainerStacking.java` | `` |  | displayName |
| top-level / `me/noramibu/lumentooltips/config/DurabilityPalette.java` | `` |  | color, displayName |
| top-level / `me/noramibu/lumentooltips/config/HoldMode.java` | `` |  | displayName, isActive |
| top-level / `me/noramibu/lumentooltips/config/ItemEditorStorageTarget.java` | `` |  | displayName |
| top-level / `me/noramibu/lumentooltips/config/LumenConfig.java` | `` |  |  |
| top-level / `me/noramibu/lumentooltips/config/LumenConfigManager.java` | `` |  | current, load, load, save, save, apply, editingCopy, validate, validateModules, validateControls, validateTooltip, validateDurability, validatePreview, validateExtraStatistics, validateItemEditor, validateParticleSafety, validateSafety |
| top-level / `me/noramibu/lumentooltips/config/LumenInputBinding.java` | `` |  | normalize, isDown, isDown, displayName, matches, includes, fromEvent, fromEvent, isModifier, withModifiers, addModifier, modifierDown, modifierMask, parse |
| top-level / `me/noramibu/lumentooltips/config/LumenOptionRegistry.java` | `` |  | tooltipFlagOptions, hiddenComponentOption, options, isVisible |
| top-level / `me/noramibu/lumentooltips/config/OptionControl.java` | `` |  |  |
| top-level / `me/noramibu/lumentooltips/config/PreviewDensity.java` | `` |  | displayName |
| top-level / `me/noramibu/lumentooltips/config/SaveMode.java` | `` |  |  |
| top-level / `me/noramibu/lumentooltips/fabric/FabricLumenTooltips.java` | `` |  | onInitializeClient, modVersion, supportsItemEditorApi |
| top-level / `me/noramibu/lumentooltips/fabric/LumenModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `me/noramibu/lumentooltips/LumenTooltips.java` | `` |  | init, modName, fuelTime, compostChance, blastResistance, modVersion, minecraftVersion, buildNumber, Platform |
| top-level / `me/noramibu/lumentooltips/mixin/AbstractContainerScreenMixin.java` | `value={AbstractContainerScreen.class})` | Inject:2, Redirect:1 | lumenTooltips$captureEnderChest, lumenTooltips$handleHoveredItem, lumenTooltips$appendItemEditorHint, lumenTooltips$saveToItemEditor, lumenTooltips$openItemEditor, lumenTooltips$backingSlot |
| top-level / `me/noramibu/lumentooltips/mixin/ChatScreenMixin.java` | `value={ChatScreen.class})` | Inject:2 | lumenTooltips$handleCommand, lumenTooltips$openPendingConfig |
| top-level / `me/noramibu/lumentooltips/mixin/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | Inject:2 | lumenTooltips$registerClientCommands, lumenTooltips$invalidateMapStats |
| top-level / `me/noramibu/lumentooltips/mixin/ClientTooltipComponentMixin.java` | `value={ClientTooltipComponent.class})` | Inject:2 | lumenTooltips$createText, lumenTooltips$create |
| top-level / `me/noramibu/lumentooltips/mixin/ComponentMixin.java` | `value={Component.class})` | ModifyVariable:2, Inject:4 | lumenTooltips$guardPlainText, lumenTooltips$inspectPlainText, lumenTooltips$guardStyledText, lumenTooltips$inspectStyledText, lumenTooltips$finishPlainText, lumenTooltips$finishStyledText |
| top-level / `me/noramibu/lumentooltips/mixin/CreativeModeInventoryScreenMixin.java` | `value={CreativeModeInventoryScreen.class})` | Inject:1 | lumenTooltips$openHoveredItem |
| top-level / `me/noramibu/lumentooltips/mixin/CreativeSlotWrapperAccessor.java` | `targets={"net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen$SlotWrapper"})` | Accessor:1 |  |
| top-level / `me/noramibu/lumentooltips/mixin/DefaultTooltipPositionerMixin.java` | `value={DefaultTooltipPositioner.class})` | Inject:1 | lumenTooltips$positionTooltip |
| top-level / `me/noramibu/lumentooltips/mixin/DialogScreenMixin.java` | `value={DialogScreen.class})` | WrapMethod:1 | lumenTooltips$limitColumns |
| top-level / `me/noramibu/lumentooltips/mixin/EntityAccessor.java` | `value={Entity.class})` | Accessor:1 |  |
| top-level / `me/noramibu/lumentooltips/mixin/GuiGraphicsExtractorMixin.java` | `value={GuiGraphicsExtractor.class})` | Inject:2 | lumenTooltips$wrapComponentTooltip, lumenTooltips$finishTooltipFrame |
| top-level / `me/noramibu/lumentooltips/mixin/GuiMixin.java` | `value={Hud.class})` | ModifyArg:1 | lumenTooltips$guardSelectedItemName |
| top-level / `me/noramibu/lumentooltips/mixin/ItemStackTooltipMixin.java` | `value={ItemStack.class}, priority=1500)` | ModifyVariable:1, Inject:2 | lumenTooltips$showConfiguredComponents, lumenTooltips$appendTooltip, lumenTooltips$getTooltipImage |
| top-level / `me/noramibu/lumentooltips/mixin/KeyboardHandlerMixin.java` | `value={KeyboardHandler.class})` | Inject:1 | lumenTooltips$releaseSaveKey |
| top-level / `me/noramibu/lumentooltips/mixin/MobBucketItemAccessor.java` | `value={MobBucketItem.class})` | Accessor:1 |  |
| top-level / `me/noramibu/lumentooltips/mixin/MouseHandlerMixin.java` | `value={MouseHandler.class})` | Inject:1 | lumenTooltips$scrollTooltip |
| top-level / `me/noramibu/lumentooltips/mixin/OptionsScreenMixin.java` | `value={OptionsScreen.class})` | Inject:1 | lumenTooltips$addConfigButton |
| top-level / `me/noramibu/lumentooltips/mixin/ParticleEngineAccessor.java` | `value={ParticleEngine.class})` | Invoker:1 |  |
| top-level / `me/noramibu/lumentooltips/mixin/ParticleEngineMixin.java` | `value={ParticleEngine.class})` | WrapMethod:1, Inject:1 | lumenTooltips$limitEffects, lumenTooltips$clearEffects |
| top-level / `me/noramibu/lumentooltips/mixin/ParticleSafetyMixin.java` | `value={ClientPacketListener.class})` | Inject:1, ModifyExpressionValue:1 | lumenTooltips$limitParticles, lumenTooltips$boundedParticleCount |
| top-level / `me/noramibu/lumentooltips/mixin/SingleQuadParticleAccessor.java` | `value={SingleQuadParticle.class})` | Accessor:1 |  |
| top-level / `me/noramibu/lumentooltips/mixin/StorageLinkMixin.java` | `value={Screen.class})` | Inject:1 | lumenTooltips$openStorage |
| top-level / `me/noramibu/lumentooltips/mixin/TranslatableContentsMixin.java` | `value={TranslatableContents.class})` | ModifyVariable:2, Inject:4 | lumenTooltips$guardPlainText, lumenTooltips$guardStyledText, lumenTooltips$limitPlainText, lumenTooltips$limitStyledText, lumenTooltips$finishPlainText, lumenTooltips$finishStyledText |
| top-level / `me/noramibu/lumentooltips/service/LumenUsageReporter.java` | `` |  | initialize, enabled, logStatus, send, webhookKey |
| top-level / `me/noramibu/lumentooltips/tooltip/layout/LumenTooltipLayout.java` | `` |  | position, scroll, finishFrame, maxTextWidth, updateScrollBounds, layoutChanged, clampedX, clampedY, resetScroll |
| top-level / `me/noramibu/lumentooltips/tooltip/LumenBookAuthorTooltipComponent.java` | `` |  | getStyle, getContents, getSiblings, getVisualOrderText, accept, getHeight, getWidth, extractImage, skin, load |
| top-level / `me/noramibu/lumentooltips/tooltip/LumenEquipmentComparison.java` | `` |  | differences, add, isNumericModifier, displayLine, Key, Difference |
| top-level / `me/noramibu/lumentooltips/tooltip/LumenExtraStatistics.java` | `` |  | appendFuelTime, referenceValue, appendBlockStatistics, appendToolStatistics, miningLevel, isMiningTool, addPositive, add, add, duration, format, miningLevelName, humanize |
| top-level / `me/noramibu/lumentooltips/tooltip/LumenFoodTooltipComponent.java` | `` |  | getStyle, getContents, getSiblings, getVisualOrderText, accept, getHeight, getWidth, extractImage, drawHunger, drawSaturation, textWidth, saturationTextureX, drawSmallText |
| top-level / `me/noramibu/lumentooltips/tooltip/LumenItemStatistics.java` | `` |  | fuelTime, compostChance |
| top-level / `me/noramibu/lumentooltips/tooltip/LumenNavigationTooltip.java` | `` |  | invalidateMap, appendMap, analyzeMap, analyzePixels, uniquePlayerMarker, isPlayerMarker, isOutsideMarker, mapCoordinate, target, appendTarget, mapDirection, bearing, direction, directionComponent, line, MapStats |
| top-level / `me/noramibu/lumentooltips/tooltip/LumenTextGuard.java` | `` |  | guard, guard, guardComponent, guardComponent, shouldInspect, inspect, protect, protectTooltip, enterTranslation, enterComponent, exitComponent, exitTranslation, reject, reject, enabled, globalEnabled, cast, warningText, warningText, warningText, warningStyle, accept, warning, beginInspection, takeWarning, accept, warning, accept |
| top-level / `me/noramibu/lumentooltips/tooltip/LumenTooltipAppender.java` | `` |  | append, suppressPotionText, appendEnderChestNotice, addBookAuthorHead, appendControlHints, controlHint, enhanceDurability, appendFood, isAppleSkinFoodOverlay, isContainerSummary, isRotten, appendFoodEffects, appendEnchantments, useDecimalEnchantmentLevels, decimalEnchantmentLevel |
| top-level / `me/noramibu/lumentooltips/tooltip/preview/LumenAreaEffectCloudTooltipComponent.java` | `` |  | getHeight, getWidth, extractImage, particleSprite, fillEllipse, ellipseSpan, particleCount, createParticlePositions, effectName |
| top-level / `me/noramibu/lumentooltips/tooltip/preview/LumenBannerTooltipComponent.java` | `` |  | getHeight, getWidth, extractImage |
| top-level / `me/noramibu/lumentooltips/tooltip/preview/LumenBookTooltipComponent.java` | `` |  | create, getHeight, getWidth, showTooltipWithItemInHand, extractImage, scale |
| top-level / `me/noramibu/lumentooltips/tooltip/preview/LumenBundleTooltipComponent.java` | `` |  | getHeight, getWidth, showTooltipWithItemInHand, extractImage, drawSelectedItemTooltip, drawProgressBar |
| top-level / `me/noramibu/lumentooltips/tooltip/preview/LumenContainerContents.java` | `` |  | openableItems, isOpenable, storedContainerItems, isShulker, shulkerColor |
| top-level / `me/noramibu/lumentooltips/tooltip/preview/LumenContainerTooltipComponent.java` | `` |  | getHeight, getWidth, extractImage, headerHeight, drawStrip |
| top-level / `me/noramibu/lumentooltips/tooltip/preview/LumenEnderChestMemory.java` | `` |  | capture, isKnown, items, revision, validateLevel |
| top-level / `me/noramibu/lumentooltips/tooltip/preview/LumenEntityPreviewResolver.java` | `` |  | sourceEnabled, createSpawnEggEntity, createPainting, createBucketEntity, createSpawnerEntity, findSpawnerEntityTag, supportsEntityTag, potentialSpawnDataEntity, spawnDataEntity, prepare |
| top-level / `me/noramibu/lumentooltips/tooltip/preview/LumenEntityTooltipComponent.java` | `` |  | getHeight, getWidth, extractImage, drawEndPortal, drawVisibleName, animationTime, loopingFuse, fixDisplayOrientation, scaleFor, scaleFor |
| top-level / `me/noramibu/lumentooltips/tooltip/preview/LumenFireworkTooltipComponent.java` | `` |  | getHeight, getWidth, showTooltipWithItemInHand, extractImage, drawSimulation, drawRocket, drawExplosion, drawBall, drawShape, drawBurst, drawSpark, drawSparkPoint, sparkColor, visible, sparkAlpha, sparkLifetime, dampedDistance, gravityDrop, rocketProgress, rocketHeight, ballVelocities, burstVelocities, powers, triangular, gaussian, random, drawExplosion, drawSwatches, averageFlightSeconds, flightTicks, durationText, panelWidth, simulationHeight, padding, SparkFrame |
| top-level / `me/noramibu/lumentooltips/tooltip/preview/LumenItemVisualTooltipComponent.java` | `` |  | getHeight, getWidth, extractImage, size, padding |
| top-level / `me/noramibu/lumentooltips/tooltip/preview/LumenMapTooltipComponent.java` | `` |  | getHeight, getWidth, extractImage, size, padding |
| top-level / `me/noramibu/lumentooltips/tooltip/preview/LumenPotionTooltipComponent.java` | `` |  | getHeight, getWidth, extractImage, effectName, duration, padding, rowHeight |
| top-level / `me/noramibu/lumentooltips/tooltip/preview/LumenPreviewStyle.java` | `` |  | sprite |
| top-level / `me/noramibu/lumentooltips/tooltip/preview/LumenSignTooltipComponent.java` | `` |  | getHeight, getWidth, extractImage, drawText, hasText |
| top-level / `me/noramibu/lumentooltips/tooltip/preview/LumenTooltipPreview.java` | `` |  | supports, isPotionPreviewActive, create, currentFlag, createUncached, configSample, createContainerPreview, createEnderChestPreview, createVisualItemPreview, createSignPreview, isSign, hasPaintingEntity, supportsVisualItem, createBundlePreview, supportsItemDetails, createItemDetails, suppressContainerText, containerPreview, containerPreview, containerItems, configBundleSample, configContainerSample, configFireworkSample |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
