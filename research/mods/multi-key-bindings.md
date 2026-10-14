# Multi Key Bindings

Review status: **Evidence inventory; behavioral review pending**

Project: [Multi Key Bindings](https://modrinth.com/mod/multi-key-bindings)
Selected artifact version: `1.3.5+26.3`
Published implementation source: https://github.com/kennybc/multi-key-bindings
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Allows players to create multiple keybindings for the same action/function.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `71ad67149e2b665b52753b0d4387fc48146d79b3`
- `sha512`: `199d2d3a436b9263ebc3e7b8e22952a2ebca1cdde5a4c95d85603911ecf3b75ea52c8f49b4923689b33de6b2e88dff0f75ad0135d8977ce5bbe7d9b4fe90d8dc`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 36
Reconstructed Java files: 34

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "us.kenny.MultiKeyBindingClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

**accessWidener**

```json
"multi-key-bindings.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `us/kenny/BindingChord.java` | `` |  |  |
| top-level / `us/kenny/ConfigManager.java` | `` |  | saveConfigFile, loadConfigFile, parseConfigFile, migrateConfig, getFormattedKeyBindings, getFormattedModifiers, serializeModifiers, parseModifiers, convertKeyCodeToKeyName |
| top-level / `us/kenny/core/controlling/ControllingHideableKeyEntry.java` | `` |  |  |
| top-level / `us/kenny/core/controlling/ControllingMultiKeyBindingEntry.java` | `` |  | getParentEntry, setHidden |
| top-level / `us/kenny/core/MultiKeyBinding.java` | `` |  | isUnbound, release, shouldSetOnIngameFocus, getId, getAction, getCategory, setCategory, getKey, setKey, getDisplayName, getTimesPressed, incrementTimesPressed, decrementTimesPressed, getPressed, setPressed, getTranslationKey |
| top-level / `us/kenny/core/MultiKeyBindingEntry.java` | `` |  | getMultiKeyBinding, isPrimary, extractContent, refreshEntry, children, narratables |
| top-level / `us/kenny/core/MultiKeyBindingScreen.java` | `` |  |  |
| top-level / `us/kenny/core/MultiKeyBindingScreenHelper.java` | `` |  | handleMouseClicked, handleKeyPressed, applyKeyPress |
| top-level / `us/kenny/core/StickyMultiKeyBinding.java` | `` |  | isToggleMode, forceSetPressed, setPressed, release, shouldSetOnIngameFocus, shouldRestoreStateOnScreenClosed, untoggle |
| top-level / `us/kenny/KeyEventManager.java` | `` |  | setCurrentAction, isRepeat |
| top-level / `us/kenny/mixin/AbstractButtonMixin.java` | `value={AbstractButton.class})` | Inject:1 | onExtractDefaultLabel |
| top-level / `us/kenny/mixin/AbstractContainerScreenMixin.java` | `value={AbstractContainerScreen.class})` | Inject:1 | closeWithInventoryMouseButton |
| top-level / `us/kenny/mixin/controlling/ControllingConstantsMixin.java` | `value={ControllingConstants.class}, remap=false)` | WrapOperation:1 | testMultiKeyBinding, wrapSearchableComponentCreate |
| top-level / `us/kenny/mixin/controlling/ControllingMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `us/kenny/mixin/controlling/CustomListAccessor.java` | `value={CustomList.class})` | Invoker:1 |  |
| top-level / `us/kenny/mixin/controlling/CustomListMixin.java` | `value={CustomList.class}, remap=false)` | Inject:2 | onGetAllEntries, onAddEntry |
| top-level / `us/kenny/mixin/controlling/DisplayModeMixin.java` | `value={DisplayMode.class}, remap=false)` | Invoker:1, Redirect:1, ModifyReturnValue:1 | init, onConflicting, testMultiKeyBinding, onGetPredicate |
| top-level / `us/kenny/mixin/controlling/KeyEntryMixin.java` | `value={NewKeyBindsList.KeyEntry.class})` | Inject:5, WrapOperation:2 | createCustomKeyBinding, setHidden, onInit, onExtractContent, onResetButtonExtractContent, onChangeKeyButtonExtractContent, onGetHasCollision, onResetButtonClicked, onEditButtonClicked, children, narratables |
| top-level / `us/kenny/mixin/controlling/NewKeyBindsListMixin.java` | `value={NewKeyBindsList.class}, remap=false)` | Inject:1 | addToggleEntries |
| top-level / `us/kenny/mixin/controlling/NewKeyBindsScreenMixin.java` | `value={NewKeyBindsScreen.class}, remap=false)` | Inject:2, WrapOperation:2 | onMouseClicked, onKeyPressed, onFilterKeysSort, onFilterKeysFilter |
| top-level / `us/kenny/mixin/KeyBindsListAccessor.java` | `value={KeyBindsList.class})` | Accessor:1 |  |
| top-level / `us/kenny/mixin/KeyBindsListEntryAccessor.java` | `value={KeyBindsList.KeyEntry.class})` | Accessor:1 |  |
| top-level / `us/kenny/mixin/KeyBindsListEntryMixin.java` | `value={KeyBindsList.KeyEntry.class})` | Inject:5 | createCustomKeyBinding, onInit, onExtractContent, onGetHasCollision, onResetButtonClicked, onEditButtonClicked, children, narratables |
| top-level / `us/kenny/mixin/KeyBindsListMixin.java` | `value={KeyBindsList.class})` | WrapOperation:1, Inject:1 | onAddEntry, addToggleEntries |
| top-level / `us/kenny/mixin/KeyBindsScreenMixin.java` | `value={KeyBindsScreen.class})` | Inject:2 | getSelectedKey, getSelectedMultiKeyBinding, setSelectedKey, setSelectedMultiKeyBinding, setLastKeySelection, onMouseClicked, onKeyPressed |
| top-level / `us/kenny/mixin/KeyboardHandlerMixin.java` | `value={KeyboardHandler.class})` | Inject:2 | onKeyPressHead, onKeyPress |
| top-level / `us/kenny/mixin/KeyMappingAccessor.java` | `value={KeyMapping.class})` | Accessor:4 | getMap |
| top-level / `us/kenny/mixin/KeyMappingMixin.java` | `value={KeyMapping.class})` | Inject:15, Redirect:2 | isVanillaToggleActive, isMultiToggleActive, pruneStaleBindings, onClick, onClickVanilla, onSet, onSetVanilla, onSetAll, onReleaseAll, onRestoreToggleStatesOnScreenClosed, onResetToggleKeys, onIsDown, onConsumeClick, onRelease, onSame, onIsUnbound, onMatchesKey, onMatchesMouse, getLocalizedName, onIsDefault |
| top-level / `us/kenny/mixin/OptionsMixin.java` | `value={Options.class})` | Inject:2 | afterOptionsInit, onSave |
| top-level / `us/kenny/mixin/ToggleKeyMappingAccessor.java` | `value={ToggleKeyMapping.class})` | Accessor:1 |  |
| top-level / `us/kenny/ModifierManager.java` | `` |  | isModifierKey, areModifiersActive, shouldActivate, setModifiers, addModifier, removeModifier, getModifiers, modifiersEqual, bindingsConflict, bindingsConflict, bindingsConflict, getBindingChord, getBindingChord, getBindingChord, isDebugChord, getDisplayName, getAllModifiers |
| top-level / `us/kenny/MultiKeyBindingClient.java` | `` |  | onInitializeClient |
| top-level / `us/kenny/MultiKeyBindingManager.java` | `` |  | getGameOptions, setGameOptions, addKeyBinding, addKeyBinding, getKeyBindings, getKeyBindings, getKeyBindings, syncToggleState, setKeyBinding, removeKeyBinding |
| top-level / `us/kenny/ToggleManager.java` | `` |  | toggleOptions, getToggleOption, isPrimary, getPrimaryId, setPrimary, isToggleAction, stripMultiPrefix, ensurePrimaries, flip, announce, ToggleOption |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
