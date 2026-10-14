# KeybindsGalore (HVB007)

Review status: **Evidence inventory; behavioral review pending**

Project: [KeybindsGalore (HVB007)](https://modrinth.com/mod/keybindsgalore-plus-hvb007)
Selected artifact version: `1.8.0`
Published implementation source: https://github.com/HVB007og/KeybindsGalore_HVB007
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Resolves Minecraft keybind conflicts: when two actions share a key, choose the one you meant.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `83bf8b23647b7c0e3a74ddd21415db3bf5671230`
- `sha512`: `e4522b748dc4b342ae1369554697ab0e94fe673614417adf5fe701c1adbdcd2cf9dd68256cad8def6d9863fe54a1dc9665ef0d6f40060e0e1b087539b06abf9b`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 60
Reconstructed Java files: 50

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/hvb007/keybindsgalore/api/ActionDescriptor.java` | `` |  | ActionDescriptor, requireText |
| top-level / `net/hvb007/keybindsgalore/api/ApiVersion.java` | `` |  | ApiVersion, current, accepts |
| top-level / `net/hvb007/keybindsgalore/api/BindingDescriptor.java` | `` |  | BindingDescriptor, requireText |
| top-level / `net/hvb007/keybindsgalore/api/BindingRegistry.java` | `` |  | version, registerSource, unregisterSource, discoverBindings, discoverConflicts, invoke, findSource, validateBinding, BindingKey |
| top-level / `net/hvb007/keybindsgalore/api/BindingSource.java` | `` |  |  |
| top-level / `net/hvb007/keybindsgalore/api/ConflictDescriptor.java` | `` |  | ConflictDescriptor |
| top-level / `net/hvb007/keybindsgalore/api/InvocationRequest.java` | `` |  | InvocationRequest, requireText |
| top-level / `net/hvb007/keybindsgalore/api/InvocationResult.java` | `` |  |  |
| top-level / `net/hvb007/keybindsgalore/api/KeybindApi.java` | `` |  |  |
| top-level / `net/hvb007/keybindsgalore/config/ConfigurationCodec.java` | `` |  | parseValue, formatValue, formatRawValue, parseStringList, parseIntegerList, parseList, splitList, parseShort, parseInt |
| top-level / `net/hvb007/keybindsgalore/config/ConfigurationDocument.java` | `` |  | parse, ParseResult |
| top-level / `net/hvb007/keybindsgalore/config/ConfigurationMigrator.java` | `` |  | migrate, migrateFilterDebugKeys, dropRetiredKeys |
| top-level / `net/hvb007/keybindsgalore/config/ConfigurationPersistence.java` | `` |  | write |
| top-level / `net/hvb007/keybindsgalore/config/ConfigurationSnapshot.java` | `` |  | ConfigurationSnapshot, defaults |
| top-level / `net/hvb007/keybindsgalore/config/ConfigurationSnapshotCodec.java` | `` |  | fromMap, fromMap, toMap, toLines, isKnownKey, put, booleanValue, intValue, shortValue, floatValue, stringList, integerList |
| top-level / `net/hvb007/keybindsgalore/configmanager/ActionSelectionScreen.java` | `` |  | init, extractRenderState, onClose |
| top-level / `net/hvb007/keybindsgalore/configmanager/ConfigManager.java` | `` |  | checkConfigFileExists, readConfigFile, setField, printAllConfigs, saveConfigFile, isActiveConfigurations |
| top-level / `net/hvb007/keybindsgalore/configmanager/ConfigScreenBuilder.java` | `` |  | buildConfigScreen, addGeneral, addBehavior, addPieLayout, addPieColors, addPieEffects, addPieLabels, addListVisual |
| top-level / `net/hvb007/keybindsgalore/configmanager/KeyCaptureScreen.java` | `` |  | extractRenderState, keyPressed, mouseClicked, onClose |
| top-level / `net/hvb007/keybindsgalore/configmanager/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `net/hvb007/keybindsgalore/Configurations.java` | `` |  | snapshot, apply |
| top-level / `net/hvb007/keybindsgalore/core/BindingSnapshot.java` | `` |  | BindingSnapshot |
| top-level / `net/hvb007/keybindsgalore/core/ConflictGroup.java` | `` |  | ConflictGroup |
| top-level / `net/hvb007/keybindsgalore/core/ConflictIndexBuilder.java` | `` |  | build, matchesCategory, containsIgnoreCase |
| top-level / `net/hvb007/keybindsgalore/core/InputOwnershipState.java` | `` |  |  |
| top-level / `net/hvb007/keybindsgalore/core/InputOwnershipStateMachine.java` | `` |  | state, selectorOpened, selectionMade, priorityActivated, released, cancelled, reset |
| top-level / `net/hvb007/keybindsgalore/core/PriorityCandidate.java` | `` |  | PriorityCandidate |
| top-level / `net/hvb007/keybindsgalore/core/PriorityResolver.java` | `` |  | resolve, matchesCategory, containsIgnoreCase |
| top-level / `net/hvb007/keybindsgalore/customdata/DataManager.java` | `` |  | readDataFile |
| top-level / `net/hvb007/keybindsgalore/customdata/KeybindData.java` | `` |  |  |
| top-level / `net/hvb007/keybindsgalore/input/minecraft/MinecraftBindingCatalog.java` | `` |  | collect, actionId, categoryId, categoryLabel, Entry |
| top-level / `net/hvb007/keybindsgalore/input/minecraft/MinecraftConflictIndex.java` | `` |  | refresh, lastRefreshReason, refreshCount |
| top-level / `net/hvb007/keybindsgalore/input/minecraft/MinecraftInputController.java` | `` |  | shouldBlockSetDown, handleOnKeyPressed, handleKeyPress, releaseConflictingBindings, sendConflictWarning |
| top-level / `net/hvb007/keybindsgalore/input/minecraft/PulseController.java` | `` |  | start, tick, clearIf, reset, target, ticksRemaining, syncLegacyState, release |
| top-level / `net/hvb007/keybindsgalore/input/minecraft/SelectionActivationService.java` | `` |  | activate, cancel, releaseAll, releaseAllExcept |
| top-level / `net/hvb007/keybindsgalore/integrations/minecraft/MinecraftBindingSource.java` | `` |  | sourceId, discoverBindings, invoke, toBinding |
| top-level / `net/hvb007/keybindsgalore/KeybindCircularScreen.java` | `` |  | init, openProgress, extractRenderState, innerColorFor, clampChannel, renderLabelTexts, ownsKey, onKeyRelease, onKeyRelease, tryFinalize, keyReleased, mouseReleased, onClose, removed, isPauseScreen, renderBackground |
| top-level / `net/hvb007/keybindsgalore/KeybindManager.java` | `` |  | safeGetTranslationKey, safeGetCategory, safeGetCategoryLabel, findAllConflicts, refreshConflicts, validateAndMigratePriorityKeybinds, hasConflicts, openConflictMenu, getConflicts, handleOnKeyPressed, getPriorityKey, handleKeyPress, prioritizeAction, removePriority |
| top-level / `net/hvb007/keybindsgalore/KeybindSelectorScreen.java` | `` |  | extractRenderState, ownsKey, onKeyRelease, onKeyRelease, tryFinalize, keyReleased, mouseReleased, onClose, calculateLayout, renderMenu, renderLabels, drawBox, updateSelection, closeMenu, removed, isPauseScreen, renderBackground |
| top-level / `net/hvb007/keybindsgalore/KeybindsGalore.java` | `` |  | getApi, inputState, saveConfigAndRefresh, startPulse, tickPulse, clearPulseIf, isPriorityTarget, addPriorityTarget, removePriorityTarget, resetInputOwnership, beginCaptureCooldown, shouldBlockCapturedKey, isCaptureKey, tryOpenCaptureScreen, openCaptureScreen, onInitializeClient, debugLog, verboseLog |
| top-level / `net/hvb007/keybindsgalore/mixin/GuiGraphicsExtractorAccessor.java` | `value={GuiGraphicsExtractor.class})` | Accessor:1 |  |
| top-level / `net/hvb007/keybindsgalore/mixin/KeyBindsScreenMixin.java` | `value={KeyBindsScreen.class})` |  | onClose |
| top-level / `net/hvb007/keybindsgalore/mixin/KeyMappingAccessor.java` | `value={KeyMapping.class})` | Accessor:4, Invoker:1 |  |
| top-level / `net/hvb007/keybindsgalore/mixin/KeyMappingMixin.java` | `value={KeyMapping.class})` | Inject:3 | setKeyPressed, onKeyPressed, setPressed |
| top-level / `net/hvb007/keybindsgalore/mixin/MinecraftAccessor.java` | `value={Minecraft.class})` | Accessor:1 |  |
| top-level / `net/hvb007/keybindsgalore/RingRenderer.java` | `` |  | drawRing, drawCircle, buildVertices, pipeline, textureSetup, scissorArea, bounds |
| top-level / `net/hvb007/keybindsgalore/ui/minecraft/ConflictActionPresentation.java` | `` |  | size, action, labels, label, color |
| top-level / `net/hvb007/keybindsgalore/ui/model/CircularMenuGeometry.java` | `` |  | select, Selection |
| top-level / `net/hvb007/keybindsgalore/ui/model/ConflictListLayout.java` | `` |  | calculate, Box, Result |
| top-level / `net/hvb007/keybindsgalore/ui/model/ConflictSelectionModel.java` | `` |  | size, select, selectedIndex, selected, beginFinalization, cancel, isFinalized |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
