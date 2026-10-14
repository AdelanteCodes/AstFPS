# DawnGuiReader

Review status: **Evidence inventory; behavioral review pending**

Project: [DawnGuiReader](https://modrinth.com/mod/dawnguireader)
Selected artifact version: `1.3.0+mc26.3`
Published implementation source: https://github.com/aojiangQAQ/DawnGuiReader/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Reads inventory items, enchantments, hotbar selections, crosshair blocks, and GUI text aloud via system TTS for blind and low-vision players. Includes a high-contrast large-text overlay, per-feature delays, and cross-platform voice support.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `b9d009c6b50345ac0fa97a85e4ed8fa771088121d8fcd68740aeb212442ef40db5a84b6cc798422906d7bebafe0205483cf8c2a981ea68730cf3e1e4f37a637d`
- `sha1`: `40fc47b49f3d0b98d13025f2b8c55cf152f1cad2`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 27
Reconstructed Java files: 23

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "org.dawnteam.accessibility.DawnAccessibilityClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*",
  "cloth-config2": ">=26.3.159"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `org/dawnteam/accessibility/compat/MinecraftScreenCompat.java` | `` |  | currentScreen, guiScreenMethod, readFromMinecraft, minecraftScreenField, logGuiScreenFailure, logMinecraftScreenFailure |
| top-level / `org/dawnteam/accessibility/config/DawnAccessibilityConfig.java` | `` |  | load, save, clamp, clamp, isEnabled, setEnabled, getVolume, setVolume, isContainerReaderEnabled, setContainerReaderEnabled, getHoverDelayMs, setHoverDelayMs, getSpeechRate, setSpeechRate, getVoiceId, setVoiceId, isHotbarReaderEnabled, setHotbarReaderEnabled, getHotbarDelayMs, setHotbarDelayMs, getCrosshairMode, setCrosshairMode, getBlockDelayMs, setBlockDelayMs, isTooltipDetailEnabled, setTooltipDetailEnabled, getTooltipDetailMode, setTooltipDetailMode, getTooltipDetailDelayMs, setTooltipDetailDelayMs, isGuiTextReaderEnabled, setGuiTextReaderEnabled, getGuiTextDelayMs, setGuiTextDelayMs |
| top-level / `org/dawnteam/accessibility/DawnAccessibilityClient.java` | `` |  | onInitializeClient, registerKeyBindings, registerTickHandler, onInputPress, handleKeyBindings, showStatus, config, ttsEngine, hoveredItemReader, hoveredCreativeTabReader, hotbarItemReader, blockTargetReader, guiTextReader, enchantmentScreenReader, toggleReaderKey, repeatItemKey, crosshairReadKey, speak, repeatHoveredItem, findSlotAt |
| top-level / `org/dawnteam/accessibility/gui/BlockTargetReader.java` | `` |  | update, readNow, reset, currentBlockName |
| top-level / `org/dawnteam/accessibility/gui/DawnClothConfigScreen.java` | `` |  | create, addDelayField, addKeybindEntry, toString, fromInt, toString, fromInt, toString |
| top-level / `org/dawnteam/accessibility/gui/EnchantmentScreenReader.java` | `` |  | update, isHovering, resolveEnchantmentName, reset |
| top-level / `org/dawnteam/accessibility/gui/GuiTextReader.java` | `` |  | update, findWidgetText, reset |
| top-level / `org/dawnteam/accessibility/gui/HotbarItemReader.java` | `` |  | update, reset, currentItemName |
| top-level / `org/dawnteam/accessibility/gui/HoveredItemReader.java` | `` |  | update, estimateSpeechDuration, speakDetail, appendEnchantments, isEnchantmentLine, matchesEnchantments, reset, currentItemName |
| top-level / `org/dawnteam/accessibility/gui/HoveredTextReader.java` | `` |  | update, reset, currentText |
| top-level / `org/dawnteam/accessibility/mixin/AbstractContainerScreenAccessor.java` | `value={AbstractContainerScreen.class})` | Accessor:2 |  |
| top-level / `org/dawnteam/accessibility/mixin/AbstractContainerScreenMixin.java` | `value={AbstractContainerScreen.class})` | Inject:1 | dawnAccessibility$removed |
| top-level / `org/dawnteam/accessibility/mixin/CreativeModeInventoryScreenMixin.java` | `value={CreativeModeInventoryScreen.class})` | Inject:4 | dawnAccessibility$beginCreativeTabHoverFrame, dawnAccessibility$readHoveredCreativeTab, dawnAccessibility$endCreativeTabHoverFrame, dawnAccessibility$removed |
| top-level / `org/dawnteam/accessibility/mixin/GameNarratorAccessor.java` | `value={GameNarrator.class})` | Accessor:1 |  |
| top-level / `org/dawnteam/accessibility/mixin/KeyboardHandlerMixin.java` | `value={KeyboardHandler.class})` | Inject:1 | dawnAccessibility$recordPress |
| top-level / `org/dawnteam/accessibility/mixin/KeyMappingAccessor.java` | `value={KeyMapping.class})` | Accessor:1 |  |
| top-level / `org/dawnteam/accessibility/mixin/MouseHandlerMixin.java` | `value={MouseHandler.class})` | Inject:1 | dawnAccessibility$recordPress |
| top-level / `org/dawnteam/accessibility/mixin/PauseScreenMixin.java` | `value={PauseScreen.class})` | Inject:1 | dawnAccessibility$addOptionsButton |
| top-level / `org/dawnteam/accessibility/mixin/TitleScreenMixin.java` | `value={TitleScreen.class})` | Inject:1 | dawnAccessibility$addButton |
| top-level / `org/dawnteam/accessibility/tts/SystemTtsEngine.java` | `` |  | writeWindowsTtsScript, startWindowsProcess, sendWindowsCommand, closeWindowsProcess, speak, stop, listVoices, isAvailable, availabilityMessage, checkAvailability, checkCommand, commandForSpeech, loadVoices, parseVoiceLine, probeTimeoutSeconds, speakWithMinecraftNarrator |
| top-level / `org/dawnteam/accessibility/tts/TtsEngine.java` | `` |  |  |
| top-level / `org/dawnteam/accessibility/tts/TtsOptions.java` | `` |  | TtsOptions, voiceIdOrBlank |
| top-level / `org/dawnteam/accessibility/tts/Voice.java` | `` |  | Voice, none |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
