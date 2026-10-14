# Keybind Bug Fixes

Review status: **Evidence inventory; behavioral review pending**

Project: [Keybind Bug Fixes](https://modrinth.com/mod/keybindbugfixes)
Selected artifact version: `1.6.0`
Published implementation source: https://github.com/RayZ-R/keybindbugfixes
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Fixes keybind-related bugs, adds keybind-related tweaks, and adds new keybinds.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `47591b55b8b8887c883a3ceb5900b490b3b9ef406ae203d77c3a5a1aa0945f1e765191cbfa359694897aeb0fb1c9938e7e15d876dbf4c390c6ccae2f6a6a4f8c`
- `sha1`: `500d3ceaa93056a8e8d6566e2b48394904c56c8a`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 42
Reconstructed Java files: 36

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "keybindbugfixes.KeybindBugFixes"
  ],
  "modmenu": [
    "keybindbugfixes.config.ModMenuApiImpl"
  ],
  "debugify": [
    "keybindbugfixes.config.DebugifyApiImpl"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.6",
  "minecraft": ">=26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `keybindbugfixes/config/Config.java` | `` |  | init, configPath, loadJson, saveJson |
| top-level / `keybindbugfixes/config/ConfigListWidget.java` | `` |  | addCategoryEntry, addOptionEntry, getRowWidth, refreshKeyEntries, extractContent, children, narratables, init, extractContent, children, narratables, narrationSupplier, editClicked, resetClicked, refreshEntry, narrationSupplier, editClicked, resetClicked, duplicateComponent, refreshEntry, narrationSupplier |
| top-level / `keybindbugfixes/config/ConfigScreen.java` | `` |  | init, addTitle, addContents, addFooter, repositionElements, mouseClicked, keyPressed, keyReleased, removed, onClose |
| top-level / `keybindbugfixes/config/DebugifyApiImpl.java` | `` |  | getDisabledFixes |
| top-level / `keybindbugfixes/config/ModMenuApiImpl.java` | `` |  | getModConfigScreenFactory |
| top-level / `keybindbugfixes/config/option/BooleanOption.java` | `` |  | toggle, parse, fromJson, toJson |
| top-level / `keybindbugfixes/config/option/KeyOption.java` | `` |  | isUnbound, parse, fromJson, toJson |
| top-level / `keybindbugfixes/config/option/Option.java` | `` |  | init, reset, isDefault |
| top-level / `keybindbugfixes/KeybindBugFixes.java` | `` |  | onInitializeClient |
| top-level / `keybindbugfixes/mixin/AbstractContainerScreenAccessor.java` | `value={AbstractContainerScreen.class})` | Accessor:10, Invoker:1 |  |
| top-level / `keybindbugfixes/mixin/add_keybind_duplicates/controlling/DisplayModeMixin.java` | `value={DisplayMode.class})` | ModifyReturnValue:1 | showModdedDuplicates |
| top-level / `keybindbugfixes/mixin/add_keybind_duplicates/controlling/FreeKeysListMixin.java` | `value={FreeKeysList.class})` | WrapOperation:1 | hideModdedDuplicates |
| top-level / `keybindbugfixes/mixin/add_keybind_duplicates/controlling/KeyEntryMixin.java` | `value={NewKeyBindsList.KeyEntry.class})` | Inject:1 | handleModdedDuplicates |
| top-level / `keybindbugfixes/mixin/add_keybind_duplicates/KeyEntryMixin.java` | `value={KeyBindsList.KeyEntry.class})` | Inject:1 | handleModdedDuplicates |
| top-level / `keybindbugfixes/mixin/drop_when_holding_item/AbstractContainerMenuMixin.java` | `value={AbstractContainerMenu.class})` | ModifyExpressionValue:1 | skipEmptyCarriedCondition |
| top-level / `keybindbugfixes/mixin/fix_debug_conflicts/controlling/DisplayModeMixin.java` | `value={DisplayMode.class})` | WrapOperation:2 | separateDebugKeys, preventDebugModifierConflict |
| top-level / `keybindbugfixes/mixin/fix_debug_conflicts/controlling/FreeKeysListMixin.java` | `value={FreeKeysList.class})` | WrapOperation:1 | skipDebugKeys |
| top-level / `keybindbugfixes/mixin/fix_debug_conflicts/controlling/NewKeyEntryMixin.java` | `value={NewKeyBindsList.KeyEntry.class})` | WrapOperation:2 | separateDebugKeys, preventDebugModifierConflict |
| top-level / `keybindbugfixes/mixin/fix_debug_conflicts/KeyEntryMixin.java` | `value={KeyBindsList.KeyEntry.class})` | WrapOperation:2 | separateDebugKeys, preventDebugModifierConflict |
| top-level / `keybindbugfixes/mixin/fix_dismount_toggle_sneak/EntityMixin.java` | `value={Entity.class})` | Inject:1 | resetShiftKey |
| top-level / `keybindbugfixes/mixin/fix_modifier_sticky_key/amecsapi/KeyMappingMixin.java` | `value={KeyMapping.class})` | Inject:1 | revertAmecsModifierKey |
| top-level / `keybindbugfixes/mixin/fix_modifier_sticky_key/KeyboardHandlerMixin.java` | `value={KeyboardHandler.class})` | Inject:1 | revertNarratorModifierKey |
| top-level / `keybindbugfixes/mixin/fix_modifier_sticky_key/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | revertPickBlockWithNbtModifierKey |
| top-level / `keybindbugfixes/mixin/fix_modifier_sticky_key/MultiPlayerGameModeMixin.java` | `value={MultiPlayerGameMode.class})` | Inject:1 | revertDropStackModifierKey |
| top-level / `keybindbugfixes/mixin/fix_modifier_sticky_key/ToggleKeyMappingMixin.java` | `value={ToggleKeyMapping.class})` | Inject:1 | updateToggleKeyStates |
| top-level / `keybindbugfixes/mixin/fix_pick_key_dragging/AbstractContainerScreenMixin.java` | `value={AbstractContainerScreen.class})` | ModifyExpressionValue:1 | disablePickItemKey |
| top-level / `keybindbugfixes/mixin/fix_pick_key_dragging/GuiEventListenerMixin.java` | `value={GuiEventListener.class})` | Inject:1 |  |
| top-level / `keybindbugfixes/mixin/fix_pick_key_dragging/KeyboardHandlerMixin.java` | `value={KeyboardHandler.class})` | WrapOperation:2 | startPickKeyDragging, stopPickKeyDragging |
| top-level / `keybindbugfixes/mixin/fix_rebind_to_f3/controlling/NewKeyBindsScreenMixin.java` | `value={NewKeyBindsScreen.class})` | Inject:1, ModifyReturnValue:1 | skipNextKeyRelease, skipKeyRelease |
| top-level / `keybindbugfixes/mixin/fix_rebind_to_f3/KeyBindsScreenMixin.java` | `value={KeyBindsScreen.class})` | Inject:1 | skipNextKeyRelease, keyReleased |
| top-level / `keybindbugfixes/mixin/fix_screen_sticky_key_reset/ToggleKeyMappingMixin.java` | `value={ToggleKeyMapping.class})` | ModifyExpressionValue:1 | skipKeyTypeCondition |
| top-level / `keybindbugfixes/mixin/fix_unknown_scancode/KeyMappingMixin.java` | `value={KeyMapping.class})` | Inject:1 | skipUnknownKey |
| top-level / `keybindbugfixes/mixin/KeyMappingAccessor.java` | `value={KeyMapping.class})` | Accessor:2 |  |
| top-level / `keybindbugfixes/mixin/ToggleKeyMappingAccessor.java` | `value={ToggleKeyMapping.class})` | Accessor:1 |  |
| top-level / `keybindbugfixes/MixinPlugin.java` | `` |  | isDisabled, onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `keybindbugfixes/ToggleKeyStates.java` | `` |  | revert, revertControl |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
