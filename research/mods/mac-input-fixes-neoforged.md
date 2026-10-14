# MacOS Input Fixes (Neoforged)

Review status: **Evidence inventory; behavioral review pending**

Project: [MacOS Input Fixes (Neoforged)](https://modrinth.com/mod/mac-input-fixes-neoforged)
Selected artifact version: `26.10.03-p`
Published implementation source: https://github.com/MarkapToGo/MacOSInputFixes-Neoforged
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This mod fixes many Minecraft macOS input bugs and adds new settings in the mouse settings!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `232ffdcf235b30b17e7e2a7f7e67760e8ab95b7a`
- `sha512`: `3d52a11bdd2408f1a696e53f66e40b09b66634c6631eec500e408e3568473c056ee74029ad60cd5212d9091ab9982dcd0cef86b58369d17668dc2172c79e5753`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 19
Reconstructed Java files: 19

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.hamarb123.macos_input_fixes.MacOSInputFixesMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/hamarb123/macos_input_fixes/client/KeyCallback.java` | `` |  |  |
| top-level / `com/hamarb123/macos_input_fixes/client/MacOSInputFixesClientMod.java` | `` |  | ensureLoaded |
| top-level / `com/hamarb123/macos_input_fixes/client/ScrollCallback.java` | `` |  |  |
| top-level / `com/hamarb123/macos_input_fixes/Common.java` | `` |  | debugDropModifier, setLastKeyboardModifiers, physicalStrgKeysDownUncached, physicalStrgKeysDown, vanillaStyleHasControlDown, macStrgParityFullStackModifier, mergeStrgKeysIntoModifierCache, keyEventFromNative, keyActionFromNative, applyCtrlClickEmulation, allowInputOSX, setAllowedInputOSX, allowInputOSX2, setAllowedInputOSX2, omitBuilderKeyText, setOmitBuilderKeyText, asObject, areNativeCallbacksRegistered, setNativeCallbacksRegistered |
| top-level / `com/hamarb123/macos_input_fixes/KeyCallback.java` | `` |  |  |
| top-level / `com/hamarb123/macos_input_fixes/MacOSInputFixesMod.java` | `` |  | onInitializeClient, registerCallbacks, setTrackpadSensitivity, setMomentumScrolling, setInterfaceSmoothScroll, setBlockCommandQQuit |
| top-level / `com/hamarb123/macos_input_fixes/mixin/AbstractContainerScreenMixin.java` | `value={AbstractContainerScreen.class})` | Inject:1 | macosInputFixes$logDropKeyContext |
| top-level / `com/hamarb123/macos_input_fixes/mixin/gui/MouseSettingsScreenMixin.java` | `value={MouseSettingsScreen.class})` | Inject:1 | macosInputFixes$addModOptions |
| top-level / `com/hamarb123/macos_input_fixes/mixin/InputWithModifiersMixin.java` | `value={InputWithModifiers.class})` | Inject:1 | macosInputFixes$ctrlForTextShortcuts |
| top-level / `com/hamarb123/macos_input_fixes/mixin/KeyboardHandlerAccessor.java` | `value={KeyboardHandler.class})` | Invoker:1 |  |
| top-level / `com/hamarb123/macos_input_fixes/mixin/KeyboardMixin.java` | `value={KeyboardHandler.class})` | Inject:1 | onKey |
| top-level / `com/hamarb123/macos_input_fixes/mixin/MacosUtilMixin.java` | `value={MacosUtil.class})` | ModifyVariable:1 | macosInputFixes$keepCtrlClickAsLeftClick |
| top-level / `com/hamarb123/macos_input_fixes/mixin/MinecraftClientAccessor.java` | `value={Minecraft.class})` | Accessor:2 |  |
| top-level / `com/hamarb123/macos_input_fixes/mixin/MinecraftClientMixin.java` | `value={Minecraft.class})` | Inject:3, ModifyArg:1 | macosInputFixes$registerNativeOnFirstRunTick, macosInputFixes$mergeStrgBeforeKeybinds, macosInputFixes$hotbarDropFullStackArg, macosInputFixes$logHotbarDropAttempt, macosInputFixes$registerNativeHooks |
| top-level / `com/hamarb123/macos_input_fixes/mixin/MouseInvokerMixin.java` | `value={MouseHandler.class})` | Invoker:1 |  |
| top-level / `com/hamarb123/macos_input_fixes/mixin/MouseMixin.java` | `value={MouseHandler.class})` | Inject:1, ModifyVariable:2 | onMouseScroll, maybeReverseHScroll, maybeReverseVScroll |
| top-level / `com/hamarb123/macos_input_fixes/ModOptions.java` | `` |  | getModOptions, loadInterface, loadOptions, saveOptions, setTrackpadSensitivity, setMomentumScrolling, setInterfaceSmoothScroll |
| top-level / `com/hamarb123/macos_input_fixes/NativeUtils.java` | `` |  | loadLibraryFromJar, isPosixCompliant, createTempDirectory |
| top-level / `com/hamarb123/macos_input_fixes/ScrollCallback.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
