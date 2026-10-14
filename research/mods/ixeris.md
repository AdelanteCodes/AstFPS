# Ixeris

Review status: **Evidence inventory; behavioral review pending**

Project: [Ixeris](https://modrinth.com/mod/ixeris)
Selected artifact version: `4.6.8+26.3-fabric`
Published implementation source: https://github.com/decce6/Ixeris
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Buffered raw input and threaded event polling

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `c38a65adc0f1cb4a7e4f493ab32f908f5ee4742e`
- `sha512`: `5bc37bc60b3fa5c48ae097166363f02e5e3dafaa17afa2521c85251747ed2f8f30affad912d1db2816301dc6ae32fe7858a74c2cd0674fe44332150a2ccb6e69`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 438
Reconstructed Java files: 294

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "me.decce.ixeris.fabric.IxerisModFabric"
  ]
}
```

**depends**

```json
{
  "minecraft": ">=26.3",
  "fabricloader": ">=0.16.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/decce/ixeris/api/IxerisApi.java` | `` |  | getInstance, getMainThreadName, isEnabled, isInitialized, isOnMainThreadOrInit, isOnMainThread, runOnMainThread, runNowOnMainThread, runLaterOnMainThread, runAsyncOnMainThread, query, queryAsync, runLaterOnRenderThread |
| top-level / `me/decce/ixeris/api/IxerisFuture.java` | `` |  | cancel, isCancelled, isDone, get, get |
| top-level / `me/decce/ixeris/core/BlockingException.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/Constants.java` | `` |  | getMixins, getMixinClasses, getForgeTransformerClasses, toClassUnchecked, toClassUnchecked, getClassesForTransformation |
| top-level / `me/decce/ixeris/core/DummyEventHandler.java` | `` |  | canPollEvents, pollEvents |
| top-level / `me/decce/ixeris/core/EventHandler.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/FlexibleThreadingManager.java` | `` |  | canUseFlexibleClipboard |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/_334/CallbackDispatchers_334.java` | `` |  | validateAll |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/_334/CommonCallbacks_334.java` | `` |  | initCallbacks, onPreeditCallback, onPreeditCandidateCallback, onImeStatusCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/_334/IMEStatusCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/_334/PreeditCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/_334/PreeditCandidateCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/CallbackDispatchers.java` | `` |  | validateAll |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/CharCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/CharModsCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/CommonCallbacks.java` | `` |  | initCallbacks, onCharCallback, onCharModsCallback, onCursorEnterCallback, onCursorPosCallback, onDropCallback, onErrorCallback, onFramebufferSizeCallback, onKeyCallback, onMonitorCallback, onMouseButtonCallback, onScrollCallback, onWindowCloseCallback, onWindowContentScaleCallback, onWindowFocusCallback, onWindowIconifyCallback, onWindowMaximizeCallback, onWindowPosCallback, onWindowRefreshCallback, onWindowSizeCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/CursorEnterCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/CursorPosCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/DropCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/ErrorCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/FramebufferSizeCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/KeyCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/MonitorCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/MouseButtonCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/ScrollCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/UpcallRunnable.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/WindowCloseCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/WindowContentScaleCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/WindowFocusCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/WindowIconifyCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/WindowMaximizeCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/WindowPosCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/WindowRefreshCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/callback_dispatcher/WindowSizeCallbackDispatcher.java` | `` |  | get, suppressCallbacks, unsuppressCallbacks, registerMainThreadCallback, update, update, validate, onCallback |
| top-level / `me/decce/ixeris/core/glfw/GlfwEventHandler.java` | `` |  | canPollEvents, pollEvents, recordError, replayErrorQueue, clearQueuedCursorPosCallbacks |
| top-level / `me/decce/ixeris/core/glfw/state_caching/GlfwCache.java` | `` |  | isCacheEnabled, enableCache, disableCache |
| top-level / `me/decce/ixeris/core/glfw/state_caching/GlfwCacheManager.java` | `` |  | getGlobalCache, hasWindowCache, getWindowCache, destroyWindowCache |
| top-level / `me/decce/ixeris/core/glfw/state_caching/GlfwGlobalCacheManager.java` | `` |  | keyNames, monitors, cursor |
| top-level / `me/decce/ixeris/core/glfw/state_caching/GlfwWindowCacheManager.java` | `` |  | cursorPos, inputMode, keys, mouseButtons, monitor, windowSize, framebufferSize, contentScale, attrib |
| top-level / `me/decce/ixeris/core/glfw/state_caching/global/GlfwCursorCache.java` | `` |  | create, createStandardCursor, createCursor, get, apply, destroy |
| top-level / `me/decce/ixeris/core/glfw/state_caching/global/GlfwGlobalCache.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/glfw/state_caching/global/GlfwKeyNameCache.java` | `` |  | get, blockingGet, setKey, setScancode, updateLater |
| top-level / `me/decce/ixeris/core/glfw/state_caching/global/GlfwMonitorCache.java` | `` |  | getPrimaryMonitor, blockingGetPrimaryMonitor, initialize, onMonitorCallback |
| top-level / `me/decce/ixeris/core/glfw/state_caching/util/BufferHelper.java` | `` |  | check, check, check, check, check, check |
| top-level / `me/decce/ixeris/core/glfw/state_caching/util/InputModeHelper.java` | `` |  | indexFromMode, isStickyKeys, isStickyMouseButtons |
| top-level / `me/decce/ixeris/core/glfw/state_caching/util/KeyNameHelper.java` | `` |  | isPrintable |
| top-level / `me/decce/ixeris/core/glfw/state_caching/window/GlfwAbstractSizeCache.java` | `` |  | onAbstractSizeCallback, width, height, get, get, blockingGet |
| top-level / `me/decce/ixeris/core/glfw/state_caching/window/GlfwCursorPosCache.java` | `` |  | onCursorPosCallback, get, get, blockingGet |
| top-level / `me/decce/ixeris/core/glfw/state_caching/window/GlfwFramebufferSizeCache.java` | `` |  | registerCallback, blockingGet |
| top-level / `me/decce/ixeris/core/glfw/state_caching/window/GlfwInputModeCache.java` | `` |  | get, consider, blockingGet, set |
| top-level / `me/decce/ixeris/core/glfw/state_caching/window/GlfwKeyCache.java` | `` |  | get, blockingGet, onKeyCallback |
| top-level / `me/decce/ixeris/core/glfw/state_caching/window/GlfwMonitorCache.java` | `` |  | get, blockingGet, set, invalidateCache |
| top-level / `me/decce/ixeris/core/glfw/state_caching/window/GlfwMouseButtonCache.java` | `` |  | get, blockingGet, onMouseButtonCallback |
| top-level / `me/decce/ixeris/core/glfw/state_caching/window/GlfwWindowAttribCache.java` | `` |  | onCursorEnterCallback, onWindowFocusCallback, onWindowIconifyCallback, get, blockingGet |
| top-level / `me/decce/ixeris/core/glfw/state_caching/window/GlfwWindowCache.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/glfw/state_caching/window/GlfwWindowContentScaleCache.java` | `` |  | onWindowContentScaleCallback, get, get, blockingGet |
| top-level / `me/decce/ixeris/core/glfw/state_caching/window/GlfwWindowSizeCache.java` | `` |  | registerCallback, blockingGet |
| top-level / `me/decce/ixeris/core/input/InputManager.java` | `` |  | setup, buffered, pollEvents, grab, release, isRawInputEnabled, shouldHijackSettingRawInput, setRawInput, setCursorPos |
| top-level / `me/decce/ixeris/core/input/RawInputHandler.java` | `` |  | create |
| top-level / `me/decce/ixeris/core/input/win32/KeyboardStateHelper.java` | `` |  | set, setDown, setUp |
| top-level / `me/decce/ixeris/core/input/win32/RawInputDevice.java` | `` |  | register, unregister, _register, getMouseDevice, getKeyboardDevice |
| top-level / `me/decce/ixeris/core/input/win32/RawInputHandlerGlfwWin32.java` | `` |  | onWindowFocusChanged, useRawMouse, useRawKeyboard, createBuffer, growBuffer, grab, release, pollEvents, setCursorPos, supported, setIgnoreNextMove, handleRawInput, setUnsupported, processRawInputBuffer, processKeyboard, centerCursor, processMouse, mulDiv, processCursor, processMouseButton, processScroll, inputCursorPos, inputRawKey, inputRawMouseButton, inputMouseButton, updateKeyState, updateMessageButtonState, dispatchMessage, inputScroll, considerSwapButtons, isWindowFocused, isWindowFocusedAndGrabbed, findMessage, innerFindMessage, shouldAbortMessageReading, handleMessages, processMessage |
| top-level / `me/decce/ixeris/core/Ixeris.java` | `` |  | getEventHandler, createEventHandler, getConfig, isInitialized, isOnMainThread, input |
| top-level / `me/decce/ixeris/core/IxerisConfig.java` | `` |  | isEnabled, isAggressiveCaching, useFlexibleThreading, isFullyBlockingMode, shouldLogPollingCalls, shouldLogBlockingCalls, shouldLogCacheIssues, getEventPollingThreadPriority, getMainThreadSleepTime, isBusyWaitAllowedInFramerateLimiter, isBufferedRawMouse, isBufferedRawKeyboard, getMinRawInputBufferSize, getMaxRawInputBufferSize, getMessageOptimizationStrategy, makeNightConfig, save, load, toNightConfig, fromNightConfig, validate, maybeImportOld |
| top-level / `me/decce/ixeris/core/IxerisMinecraftAccessor.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/IxerisNoopAccessor.java` | `` |  | getMinecraftWindow, setIgnoreFirstMouseMove, isMouseInternallyGrabbed, isOnRenderThread, unlockContext, lockContext |
| top-level / `me/decce/ixeris/core/MixinHelper.java` | `` |  | shouldApply |
| top-level / `me/decce/ixeris/core/mixins/glfw/callback_dispatcher/GLFWMixin.java` | `value={GLFW.class}, remap=false, priority=500)` | Inject:38 | ixeris$glfwSetCharCallback, ixeris$nglfwSetCharCallback, ixeris$glfwSetCharModsCallback, ixeris$nglfwSetCharModsCallback, ixeris$glfwSetCursorEnterCallback, ixeris$nglfwSetCursorEnterCallback, ixeris$glfwSetCursorPosCallback, ixeris$nglfwSetCursorPosCallback, ixeris$glfwSetDropCallback, ixeris$nglfwSetDropCallback, ixeris$glfwSetErrorCallback, ixeris$nglfwSetErrorCallback, ixeris$glfwSetFramebufferSizeCallback, ixeris$nglfwSetFramebufferSizeCallback, ixeris$glfwSetKeyCallback, ixeris$nglfwSetKeyCallback, ixeris$glfwSetMonitorCallback, ixeris$nglfwSetMonitorCallback, ixeris$glfwSetMouseButtonCallback, ixeris$nglfwSetMouseButtonCallback, ixeris$glfwSetScrollCallback, ixeris$nglfwSetScrollCallback, ixeris$glfwSetWindowCloseCallback, ixeris$nglfwSetWindowCloseCallback, ixeris$glfwSetWindowContentScaleCallback, ixeris$nglfwSetWindowContentScaleCallback, ixeris$glfwSetWindowFocusCallback, ixeris$nglfwSetWindowFocusCallback, ixeris$glfwSetWindowIconifyCallback, ixeris$nglfwSetWindowIconifyCallback, ixeris$glfwSetWindowMaximizeCallback, ixeris$nglfwSetWindowMaximizeCallback, ixeris$glfwSetWindowPosCallback, ixeris$nglfwSetWindowPosCallback, ixeris$glfwSetWindowRefreshCallback, ixeris$nglfwSetWindowRefreshCallback, ixeris$glfwSetWindowSizeCallback, ixeris$nglfwSetWindowSizeCallback |
| top-level / `me/decce/ixeris/core/mixins/glfw/callback_dispatcher_334/GLFWMixin.java` | `value={GLFW.class}, remap=false, priority=500)` | Inject:6 | ixeris$glfwSetIMEStatusCallback, ixeris$nglfwSetIMEStatusCallback, ixeris$glfwSetPreeditCallback, ixeris$nglfwSetPreeditCallback, ixeris$glfwSetPreeditCandidateCallback, ixeris$nglfwSetPreeditCandidateCallback |
| top-level / `me/decce/ixeris/core/mixins/glfw/flexible_threading/GLFWMixin.java` | `value={GLFW.class}, remap=false, priority=2000)` | Redirect:16 | ixeris$nglfwGetClipboardString, ixeris$nglfwSetClipboardString, ixeris$glfwGetPrimaryMonitors, ixeris$nglfwGetMonitors, ixeris$nglfwGetMonitorName, ixeris$nglfwGetMonitorName, ixeris$nglfwGetMonitorPhysicalSize, ixeris$nglfwGetMonitorPos, ixeris$nglfwGetWorkarea, ixeris$nglfwGetVideoMode, ixeris$nglfwGetVideoModes, ixeris$nglfwSetGammaRamp, ixeris$nglfwSetGammaRamp, ixeris$nglfwSetGammaRamp, ixeris$nglfwGetCursorPos, ixeris$nglfwGetFramebufferSize |
| top-level / `me/decce/ixeris/core/mixins/glfw/glfw_state_caching/GLFWMixin.java` | `value={GLFW.class}, remap=false, priority=500)` | Inject:21 | ixeris$glfwSetInputMode, ixeris$glfwGetInputMode, ixeris$glfwGetKey, ixeris$glfwGetKeyName, ixeris$glfwGetMouseButton, ixeris$glfwGetPrimaryMonitor, ixeris$glfwGetWindowMonitor, ixeris$glfwSetWindowMonitor, ixeris$glfwCreateCursor, ixeris$glfwCreateStandardCursor, ixeris$glfwDestroyCursor, ixeris$glfwSetCursor, ixeris$glfwGetWindowSize, ixeris$glfwGetWindowSize, ixeris$glfwGetFramebufferSize, ixeris$glfwGetFramebufferSize, ixeris$glfwGetWindowContentScale, ixeris$glfwGetWindowContentScale, ixeris$glfwGetWindowAttrib, ixeris$glfwGetCursorPos, ixeris$glfwGetCursorPos |
| top-level / `me/decce/ixeris/core/mixins/glfw/glfw_threading/GLFWMixin.java` | `value={GLFW.class}, remap=false, priority=500)` | Inject:60 | ixeris$glfwCreateWindow, ixeris$glfwCreateWindow, ixeris$glfwDefaultWindowHints, ixeris$glfwFocusWindow, ixeris$glfwGetClipboardString, ixeris$glfwGetGamepadName, ixeris$glfwGetGamepadState, ixeris$glfwGetGammaRamp, ixeris$glfwGetJoystickAxes, ixeris$glfwGetJoystickButtons, ixeris$glfwGetJoystickGUID, ixeris$glfwGetJoystickHats, ixeris$glfwGetJoystickName, ixeris$glfwGetMonitorContentScale, ixeris$glfwGetMonitorContentScale, ixeris$glfwGetMonitorName, ixeris$glfwGetMonitorPhysicalSize, ixeris$glfwGetMonitorPhysicalSize, ixeris$glfwGetMonitorPos, ixeris$glfwGetMonitorPos, ixeris$glfwGetMonitors, ixeris$glfwGetMonitorWorkarea, ixeris$glfwGetMonitorWorkarea, ixeris$glfwGetVideoMode, ixeris$glfwGetVideoModes, ixeris$glfwGetWindowFrameSize, ixeris$glfwGetWindowFrameSize, ixeris$glfwGetWindowOpacity, ixeris$glfwGetWindowPos, ixeris$glfwGetWindowPos, ixeris$glfwHideWindow, ixeris$glfwIconifyWindow, ixeris$glfwInit, ixeris$glfwInitHint, ixeris$glfwJoystickIsGamepad, ixeris$glfwJoystickPresent, ixeris$glfwMaximizeWindow, ixeris$glfwRawMouseMotionSupported, ixeris$glfwRequestWindowAttention, ixeris$glfwRestoreWindow, ixeris$glfwSetClipboardString, ixeris$glfwSetClipboardString, ixeris$glfwSetGamma, ixeris$glfwSetGammaRamp, ixeris$glfwSetWindowAspectRatio, ixeris$glfwSetWindowAttrib, ixeris$glfwSetWindowIcon, ixeris$glfwSetWindowMonitor, ixeris$glfwSetWindowOpacity, ixeris$glfwSetWindowPos, ixeris$glfwSetWindowSize, ixeris$glfwSetWindowSizeLimits, ixeris$glfwSetWindowTitle, ixeris$glfwSetWindowTitle, ixeris$glfwShowWindow, ixeris$glfwTerminate, ixeris$glfwUpdateGamepadMappings, ixeris$glfwWindowHint, ixeris$glfwWindowHintString, ixeris$glfwWindowHintString |
| top-level / `me/decce/ixeris/core/mixins/glfw/glfw_threading_330/GLFWMixin.java` | `value={GLFW.class}, remap=false, priority=500)` | Inject:1 | ixeris$glfwInitAllocator |
| top-level / `me/decce/ixeris/core/mixins/glfw/glfw_threading_334/GLFWMixin.java` | `value={GLFW.class}, remap=false, priority=500)` | Inject:6 | ixeris$glfwGetPreeditCursorRectangle, ixeris$glfwGetPreeditCursorRectangle, ixeris$glfwSetPreeditCursorRectangle, ixeris$glfwResetPreeditText, ixeris$glfwGetPreeditCandidate, ixeris$glfwGetWindowTitle |
| top-level / `me/decce/ixeris/core/mixins/glfw/GLFWMixin.java` | `value={GLFW.class}, remap=false, priority=500)` | Inject:7 | ixeris$waitEventsTimeout, ixeris$pollOrWaitEvents, ixeris$glfwInit, ixeris$glfwTerminate, ixeris$glfwDestroyWindow, ixeris$glfwSetInputMode, ixeris$glfwSetCursorPos |
| top-level / `me/decce/ixeris/core/mixins/sdl/SDLEventsMixin.java` | `value={SDLEvents.class}, remap=false)` | Inject:2 | ixeris$nSDL_PollEvent, ixeris$nSDL_PeepEvent |
| top-level / `me/decce/ixeris/core/mixins/sdl/SDLInitMixin.java` | `value={SDLInit.class}, remap=false)` | Inject:2 | ixeris$SDL_Init, ixeris$SDL_Quit |
| top-level / `me/decce/ixeris/core/mixins/sdl/threading/SDLEventsMixin.java` | `value={SDLEvents.class}, remap=false)` | Inject:3 | ixeris$SDL_PumpEvents, ixeris$nSDL_WaitEvent, ixeris$nSDL_WaitEventTimeout |
| top-level / `me/decce/ixeris/core/mixins/sdl/threading/SDLInitMixin.java` | `value={SDLInit.class}, remap=false)` | Inject:3 | ixeris$SDL_Init, ixeris$SDL_InitSubSystem, ixeris$SDL_Quit |
| top-level / `me/decce/ixeris/core/mixins/sdl/threading/SDLKeyboardMixin.java` | `value={SDLKeyboard.class}, remap=false)` | Inject:14 | ixeris$SDL_HasKeyboard, ixeris$nSDL_GetKeyboards, ixeris$nSDL_GetKeyboardNameForID, ixeris$SDL_GetKeyboardFocus, ixeris$SDL_ResetKeyboard, ixeris$SDL_StartTextInput, ixeris$SDL_StartTextInputWithProperties, ixeris$SDL_TextInputActive, ixeris$SDL_StopTextInput, ixeris$SDL_ClearComposition, ixeris$nSDL_SetTextInputArea, ixeris$nSDL_GetTextInputArea, ixeris$SDL_HasScreenKeyboardSupport, ixeris$SDL_ScreenKeyboardShown |
| top-level / `me/decce/ixeris/core/mixins/sdl/threading/SDLMessageBoxMixin.java` | `value={SDLMessageBox.class}, remap=false)` | Inject:2 | ixeris$nSDL_ShowMessageBox, ixeris$nSDL_ShowSimpleMessageBox |
| top-level / `me/decce/ixeris/core/mixins/sdl/threading/SDLMouseMixin.java` | `value={SDLMouse.class}, remap=false)` | Inject:24 | ixeris$SDL_HasMouse, ixeris$nSDL_GetMice, ixeris$nSDL_GetMouseNameForID, ixeris$SDL_GetMouseFocus, ixeris$nSDL_GetMouseState, ixeris$nSDL_GetGlobalMouseState, ixeris$nSDL_GetRelativeMouseState, ixeris$SDL_WarpMouseInWindow, ixeris$SDL_WarpMouseGlobal, ixeris$nSDL_SetRelativeMouseTransform, ixeris$SDL_SetWindowRelativeMouseMode, ixeris$SDL_GetWindowRelativeMouseMode, ixeris$SDL_CaptureMouse, ixeris$nSDL_CreateCursor, ixeris$nSDL_CreateColorCursor, ixeris$nSDL_CreateAnimatedCursor, ixeris$SDL_CreateSystemCursor, ixeris$SDL_SetCursor, ixeris$SDL_GetCursor, ixeris$SDL_GetDefaultCursor, ixeris$SDL_DestroyCursor, ixeris$SDL_ShowCursor, ixeris$SDL_HideCursor, ixeris$SDL_CursorVisible |
| top-level / `me/decce/ixeris/core/mixins/sdl/threading/SDLVideoMixin.java` | `value={SDLVideo.class}, remap=false)` | Inject:108 | ixeris$SDL_GetNumVideoDrivers, ixeris$nSDL_GetVideoDriver, ixeris$nSDL_GetCurrentVideoDriver, ixeris$SDL_GetSystemTheme, ixeris$nSDL_GetDisplays, ixeris$SDL_GetPrimaryDisplay, ixeris$SDL_GetDisplayProperties, ixeris$nSDL_GetDisplayName, ixeris$nSDL_GetDisplayBounds, ixeris$nSDL_GetDisplayUsableBounds, ixeris$SDL_GetNaturalDisplayOrientation, ixeris$SDL_GetCurrentDisplayOrientation, ixeris$SDL_GetDisplayContentScale, ixeris$nSDL_GetFullscreenDisplayModes, ixeris$nSDL_GetClosestFullscreenDisplayMode, ixeris$nSDL_GetDesktopDisplayMode, ixeris$nSDL_GetCurrentDisplayMode, ixeris$nSDL_GetDisplayForPoint, ixeris$nSDL_GetDisplayForRect, ixeris$SDL_GetDisplayForWindow, ixeris$SDL_GetWindowPixelDensity, ixeris$SDL_GetWindowDisplayScale, ixeris$nSDL_SetWindowFullscreenMode, ixeris$nSDL_GetWindowFullscreenMode, ixeris$nSDL_GetWindowICCProfile, ixeris$SDL_GetWindowPixelFormat, ixeris$nSDL_GetWindows, ixeris$nSDL_CreateWindow, ixeris$SDL_CreatePopupWindow, ixeris$SDL_CreateWindowWithProperties, ixeris$SDL_GetWindowID, ixeris$SDL_GetWindowFromID, ixeris$SDL_GetWindowParent, ixeris$SDL_GetWindowProperties, ixeris$SDL_GetWindowFlags, ixeris$nSDL_SetWindowTitle, ixeris$nSDL_GetWindowTitle, ixeris$nSDL_SetWindowIcon, ixeris$SDL_SetWindowPosition, ixeris$nSDL_GetWindowPosition, ixeris$SDL_SetWindowSize, ixeris$nSDL_GetWindowSize, ixeris$nSDL_GetWindowSafeArea, ixeris$SDL_SetWindowAspectRatio, ixeris$nSDL_GetWindowAspectRatio, ixeris$nSDL_GetWindowBordersSize, ixeris$nSDL_GetWindowSizeInPixels, ixeris$SDL_SetWindowMinimumSize, ixeris$nSDL_GetWindowMinimumSize, ixeris$SDL_SetWindowMaximumSize, ixeris$nSDL_GetWindowMaximumSize, ixeris$SDL_SetWindowBordered, ixeris$SDL_SetWindowResizable, ixeris$SDL_SetWindowAlwaysOnTop, ixeris$SDL_SetWindowFillDocument, ixeris$SDL_ShowWindow, ixeris$SDL_HideWindow, ixeris$SDL_RaiseWindow, ixeris$SDL_MaximizeWindow, ixeris$SDL_MinimizeWindow, ixeris$SDL_RestoreWindow, ixeris$SDL_SetWindowFullscreen, ixeris$SDL_SyncWindow, ixeris$SDL_WindowHasSurface, ixeris$nSDL_GetWindowSurface, ixeris$SDL_SetWindowSurfaceVSync, ixeris$nSDL_GetWindowSurfaceVSync, ixeris$SDL_UpdateWindowSurface, ixeris$nSDL_UpdateWindowSurfaceRects, ixeris$SDL_DestroyWindowSurface, ixeris$SDL_SetWindowKeyboardGrab, ixeris$SDL_SetWindowMouseGrab, ixeris$SDL_GetWindowKeyboardGrab, ixeris$SDL_GetWindowMouseGrab, ixeris$SDL_GetGrabbedWindow, ixeris$nSDL_SetWindowMouseRect, ixeris$nSDL_GetWindowMouseRect, ixeris$SDL_SetWindowOpacity, ixeris$SDL_GetWindowOpacity, ixeris$SDL_SetWindowParent, ixeris$SDL_SetWindowModal, ixeris$SDL_SetWindowFocusable, ixeris$SDL_ShowWindowSystemMenu, ixeris$nSDL_SetWindowHitTest, ixeris$nSDL_SetWindowShape, ixeris$SDL_FlashWindow, ixeris$SDL_SetWindowProgressState, ixeris$SDL_GetWindowProgressState, ixeris$SDL_SetWindowProgressValue, ixeris$SDL_GetWindowProgressValue, ixeris$SDL_DestroyWindow, ixeris$SDL_ScreenSaverEnabled, ixeris$SDL_EnableScreenSaver, ixeris$SDL_DisableScreenSaver, ixeris$nSDL_GL_LoadLibrary, ixeris$nSDL_EGL_GetProcAddress, ixeris$SDL_GL_UnloadLibrary, ixeris$nSDL_GL_ExtensionSupported, ixeris$SDL_GL_ResetAttributes, ixeris$SDL_GL_SetAttribute, ixeris$nSDL_GL_GetAttribute, ixeris$SDL_GL_CreateContext, ixeris$SDL_GL_MakeCurrent, ixeris$SDL_GL_GetCurrentWindow, ixeris$SDL_EGL_GetCurrentDisplay, ixeris$SDL_EGL_GetCurrentConfig, ixeris$SDL_EGL_GetWindowSurface, ixeris$nSDL_EGL_SetAttributeCallbacks |
| top-level / `me/decce/ixeris/core/natives/win32/RAWHID.java` | `` |  | create, sizeof, dwSizeHid, dwCount, bRawData, bRawData, dwSizeHid, dwCount, bRawData, bRawData, set, set, malloc, calloc, create, create, createSafe, malloc, calloc, create, create, createSafe, malloc, calloc, malloc, calloc, ndwSizeHid, ndwCount, nbRawData, nbRawData, ndwSizeHid, ndwCount, nbRawData, nbRawData, self, create, getElementFactory, dwSizeHid, dwCount, bRawData, bRawData, dwSizeHid, dwCount, bRawData, bRawData |
| top-level / `me/decce/ixeris/core/natives/win32/RAWINPUT.java` | `` |  | create, sizeof, header, mouse, keyboard, hid, header, header, mouse, mouse, keyboard, keyboard, hid, hid, set, malloc, calloc, create, create, createSafe, malloc, calloc, create, create, createSafe, malloc, calloc, malloc, calloc, nheader, nmouse, nkeyboard, nhid, nheader, nmouse, nkeyboard, nhid, validate, self, create, getElementFactory, header, mouse, keyboard, hid, header, header, mouse, mouse, keyboard, keyboard, hid, hid |
| top-level / `me/decce/ixeris/core/natives/win32/RAWINPUTDEVICE.java` | `` |  | create, sizeof, usUsagePage, usUsage, dwFlags, hwndTarget, usUsagePage, usUsage, dwFlags, hwndTarget, set, set, malloc, calloc, create, create, createSafe, malloc, calloc, create, create, createSafe, malloc, calloc, malloc, calloc, nusUsagePage, nusUsage, ndwFlags, nhwndTarget, nusUsagePage, nusUsage, ndwFlags, nhwndTarget, validate, self, create, getElementFactory, usUsagePage, usUsage, dwFlags, hwndTarget, usUsagePage, usUsage, dwFlags, hwndTarget |
| top-level / `me/decce/ixeris/core/natives/win32/RAWINPUTHEADER.java` | `` |  | create, sizeof, dwType, dwSize, hDevice, wParam, dwType, dwSize, hDevice, wParam, set, set, malloc, calloc, create, create, createSafe, malloc, calloc, create, create, createSafe, malloc, calloc, malloc, calloc, ndwType, ndwSize, nhDevice, nwParam, ndwType, ndwSize, nhDevice, nwParam, validate, self, create, getElementFactory, dwType, dwSize, hDevice, wParam, dwType, dwSize, hDevice, wParam |
| top-level / `me/decce/ixeris/core/natives/win32/RAWKEYBOARD.java` | `` |  | create, sizeof, MakeCode, Flags, Reserved, VKey, Message, ExtraInformation, MakeCode, Flags, Reserved, VKey, Message, ExtraInformation, set, set, malloc, calloc, create, create, createSafe, malloc, calloc, create, create, createSafe, malloc, calloc, malloc, calloc, nMakeCode, nFlags, nReserved, nVKey, nMessage, nExtraInformation, nMakeCode, nFlags, nReserved, nVKey, nMessage, nExtraInformation, self, create, getElementFactory, MakeCode, Flags, Reserved, VKey, Message, ExtraInformation, MakeCode, Flags, Reserved, VKey, Message, ExtraInformation |
| top-level / `me/decce/ixeris/core/natives/win32/RAWMOUSE.java` | `` |  | create, sizeof, usFlags, ulButtons, usButtonFlags, usButtonData, ulRawButtons, lLastX, lLastY, ulExtraInformation, usFlags, ulButtons, usButtonFlags, usButtonData, ulRawButtons, lLastX, lLastY, ulExtraInformation, set, malloc, calloc, create, create, createSafe, malloc, calloc, create, create, createSafe, malloc, calloc, malloc, calloc, nusFlags, nulButtons, nusButtonFlags, nusButtonData, nulRawButtons, nlLastX, nlLastY, nulExtraInformation, nusFlags, nulButtons, nusButtonFlags, nusButtonData, nulRawButtons, nlLastX, nlLastY, nulExtraInformation, self, create, getElementFactory, usFlags, ulButtons, usButtonFlags, usButtonData, ulRawButtons, lLastX, lLastY, ulExtraInformation, usFlags, ulButtons, usButtonFlags, usButtonData, ulRawButtons, lLastX, lLastY, ulExtraInformation |
| top-level / `me/decce/ixeris/core/natives/win32/User32Ex.java` | `` |  | nClientToScreen, ClientToScreen, GetActiveWindow, nGetRawInputBuffer, GetRawInputBuffer, RegisterRawInputDevices, nScreenToClient, ScreenToClient, GetKeyState, nGetClientRect, GetClientRect, MapVirtualKeyW, SetFocus, PostMessageW, nGetKeyboardState, GetKeyboardState, nSetKeyboardState, SetKeyboardState |
| top-level / `me/decce/ixeris/core/natives/win32/Win32Exception.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/PollingException.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/RuntimeBackend.java` | `` |  | classResourceExists |
| top-level / `me/decce/ixeris/core/sdl/SdlEventHandler.java` | `` |  | canPollEvents, pollEvents, requestSetTextInputArea, updateTextInputArea, readEvents |
| top-level / `me/decce/ixeris/core/sdl/SdlEventQueue.java` | `` |  | pollEvent, readEvent |
| top-level / `me/decce/ixeris/core/sdl/SdlHelper.java` | `` |  | setWindowTitleLater |
| top-level / `me/decce/ixeris/core/sdl/SdlMemoryHelper.java` | `` |  | copySDL_Rect |
| top-level / `me/decce/ixeris/core/sdl/state_caching/BasicSdlInt2ObjectCache.java` | `` |  | get, blockingGet, scheduleUpdate |
| top-level / `me/decce/ixeris/core/sdl/state_caching/BasicSdlLong2ObjectCache.java` | `` |  | get, blockingGet, scheduleUpdate |
| top-level / `me/decce/ixeris/core/sdl/state_caching/BasicSdlVoid2LongCache.java` | `` |  | get, blockingGet, scheduleUpdate |
| top-level / `me/decce/ixeris/core/sdl/state_caching/SdlDisplayCache.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/sdl/state_caching/SdlGlobalCache.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/sdl/state_caching/SdlStateCache.java` | `` |  | forWindow, forDisplay, global, windowFromId |
| top-level / `me/decce/ixeris/core/sdl/state_caching/SdlWindowCache.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/AbstractCommentedConfig.java` | `` |  | getDefaultCommentMap, getComment, setComment, removeComment, containsComment, commentMap, entrySet, clear, clearComments, getPath, getComment, setComment, removeComment, equals, hashCode, toString |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/AbstractConfig.java` | `` |  | getDefaultMapCreator, getWildcardMapCreator, getRaw, set, add, remove, contains, isNull, getOrCreateMap, getMap, clear, size, valueMap, entrySet, hashCode, equals, toString, getKey, getRawValue, setValue, equals, hashCode |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/CheckedCommentedConfig.java` | `` |  | checked, set, add, valueMap, entrySet, toString, checkValue, checkedValue |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/CheckedConfig.java` | `` |  | checked, set, add, valueMap, entrySet, toString, checkValue, checkedValue |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/CommentedConfig.java` | `` |  | getRaw, getComment, contains, containsComment, size, valueMap, commentMap, getComments, entrySet, configFormat, of, of, ofConcurrent, inMemory, inMemoryConcurrent, wrap, copy, copy, copy, copy, copy, copy, copy, copy, concurrentCopy, concurrentCopy, concurrentCopy, concurrentCopy, fake |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/concurrent/ConcurrentCommentedConfig.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/concurrent/ConcurrentConfig.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/concurrent/StampedConfig.java` | `` |  | replaceContentBy, replaceContentBy, newAccumulator, newAccumulatorCopy, copyValueInAccumulator, mapLockGet, mapLockContains, mapLockRemove, mapLockPut, mapLockPutIfAbsent, getExistingConfig, getOrCreateConfig, size, createSubConfig, configFormat, valueMap, clear, getRaw, contains, add, remove, set, convertSubConfigs, convertValue, putAll, unsafePutAll, unsafeRemoveAll, removeAll, clearComments, removeComment, setComment, containsComment, getComment, commentMap, putAllComments, putAllComments, equals, toString, entrySet, checkStateForBulkOp, checkStateForNormalOp, bulkRead, bulkUpdate, bulkCommentedRead, bulkCommentedUpdate, clear, containsKey, containsValue, entrySet, size, isEmpty, contains, getKey, getRawValue, iterator, hasNext, next, getKey, getValue, setValue, remove, toArray, toArray, add, remove, containsAll, addAll, retainAll, removeAll, clear, get, isEmpty, keySet, values, put, putAll, remove, size, clear, removeAll, putAll, clearComments, createSubConfig, valueMap, entrySet, getKey, getValue, setValue, remove, removeComment, set, setComment, add, removeComment, setComment, setValue, checkValid, commentMap, entrySet, containsComment, getComment, configFormat, contains, getRaw, size, valueMap, toString, equals, getComment, getKey, getRawValue, checkValid, removeComment, setComment, setValue, getKey, getRawValue, getComment, toString, removeComment, setComment, setValue, getKey, getRawValue, getComment, toString, hasNext, next, remove, forEachRemaining, iterator, size, forEach, add, clear, contains, isEmpty, remove, checkValid, replaceValue, clone, createSubConfig, configFormat |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/concurrent/SynchronizedConfig.java` | `` |  | convert, convert, convertSubConfigs, convertValue, replaceContentBy, replaceContentBy, bulkCommentedRead, bulkCommentedUpdate, add, clearComments, commentMap, removeComment, setComment, containsComment, getComment, configFormat, clear, createSubConfig, entrySet, remove, set, toString, contains, equals, getRaw, hashCode, isEmpty, size, valueMap, add, addAll, putAll, remove, removeAll, set, unmodifiable, update, apply, get, isNull, getComments, getComments, putAllComments, putAllComments, forEachRemaining, hasNext, next, remove, add, addAll, clear, contains, containsAll, isEmpty, iterator, remove, removeAll, retainAll, size, toArray, toArray, removeIf, forEach, equals, hashCode, toString, clear, containsKey, containsValue, entrySet, get, isEmpty, keySet, put, putAll, remove, size, values, clone, createSubConfig, configFormat |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/ConcurrentConfigSpec.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/Config.java` | `` |  | getRaw, contains, size, valueMap, entrySet, configFormat, of, of, ofConcurrent, inMemory, inMemoryUniversal, inMemoryConcurrent, inMemoryUniversalConcurrent, wrap, copy, copy, copy, copy, concurrentCopy, concurrentCopy, isInsertionOrderPreserved, setInsertionOrderPreserved, getDefaultMapCreator, getDefaultMapCreator |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/ConfigFormat.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/ConfigSpec.java` | `` |  | define, define, define, define, define, define, defineOfClass, defineOfClass, defineOfClass, defineOfClass, defineInList, defineInList, defineInList, defineInList, defineInRange, defineInRange, defineInRange, defineInRange, defineList, defineList, defineList, defineList, defineEnum, defineEnum, defineEnum, defineEnum, defineRestrictedEnum, defineRestrictedEnum, defineRestrictedEnum, defineRestrictedEnum, undefine, undefine, isDefined, isDefined, isCorrect, isCorrect, isCorrect, isCorrect, correct, correct, correct, correct, correct, handleCorrection, get |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/AbstractConvertedCommentedConfig.java` | `` |  | getComment, containsComment, setComment, removeComment, clearComments, getComments, putAllComments, putAllComments, commentMap, entrySet, getComment, setComment, removeComment, getKey, getRawValue, setValue, createSubConfig |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/AbstractConvertedConfig.java` | `` |  | set, valueMap, getRaw, configFormat, toString |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/AdvancedPath.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/AnnotationUtils.java` | `` |  | checkFieldSpec, checkFieldSpec, checkFieldSpec, checkFieldSpec, checkFieldSpec, checkFieldSpec, checkFieldSpec, checkFieldSpec, checkFieldSpec, checkNotNull, checkClass |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/Conversion.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/ConversionTable.java` | `` |  | put, remove, contains, convert, convertShallow, convertDeep, getConversionFunction, chainThen, wrap, getRaw, valueMap, entrySet, getKey, getRawValue, configFormat, wrapRead, wrapRead, wrapRead, wrapRead, wrapWrite, wrapWrite, wrapWrite, wrapWrite, clone, toString |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/ConvertedCommentedConfig.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/ConvertedCommentedFileConfig.java` | `` |  | getFile, getNioPath, save, load, close, bulkRead, bulkCommentedRead, bulkCommentedUpdate, bulkUpdate, createSubConfig |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/ConvertedConfig.java` | `` |  | entrySet, setValue, getKey, getRawValue |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/ConvertedFileConfig.java` | `` |  | getFile, getNioPath, save, load, close, bulkRead, bulkUpdate, createSubConfig |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/ConvertedFormat.java` | `` |  | createWriter, createParser, createConfig, createConcurrentConfig, createConfig, supportsComments, supportsType |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/Converter.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/ForceBreakdown.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/InvalidValueException.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/ObjectBinder.java` | `` |  | bind, bind, bind, bind, bind, createBoundConfig, convertToField, convertFromField, convertToField, convertFromField, toString, registerField, searchInfosOrConfig, getRaw, contains, set, add, remove, clear, configFormat, createSubConfig, valueMap, entrySet, setValue, getKey, getRawValue, size, toString |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/ObjectConverter.java` | `` |  | toConfig, toConfig, toConfig, toConfig, toObject, toObject, convertToConfig, convertToObject, bottomElementType, detectElementTypes, elementTypes, bottomElementType, convertConfigsToObject, convertObjectsToConfigs, createInstance |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/Path.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/PreserveNotNull.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/ReflectionException.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/SpecClassInArray.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/SpecDoubleInRange.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/SpecEnum.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/SpecFloatInRange.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/SpecIntInRange.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/SpecLongInRange.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/SpecNotNull.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/SpecStringInArray.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/SpecStringInRange.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/conversion/SpecValidator.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/EnumGetMethod.java` | `` |  | isCaseSensitive, isOrdinalOk, get, validate |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/file/AsyncFileConfig.java` | `` |  | saveNow, loadNow, getFile, getNioPath, save, asyncLoad, load, close |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/file/AutoreloadFileConfig.java` | `` |  | autoReload, getFile, getNioPath, save, load, close |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/file/AutosaveCommentedFileConfig.java` | `` |  | autoSave, save, set, add, remove, setComment, removeComment, removeAll, putAll, clear, clearComments, putAllComments, putAllComments, valueMap, commentMap, getFile, getNioPath, load, close, bulkCommentedUpdate, bulkUpdate |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/file/CheckedCommentedFileConfig.java` | `` |  | getNioPath, getFile, save, load, close, bulkCommentedRead, bulkCommentedUpdate, checked, set, add, valueMap, entrySet, toString, checkValue, checkedValue |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/file/CheckedFileConfig.java` | `` |  | getNioPath, getFile, save, load, close, bulkRead, bulkUpdate, checked, set, add, valueMap, entrySet, toString, createSubConfig, checkValue, checkedValue |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/file/CommentedFileConfig.java` | `` |  | of, of, of, of, of, of, ofConcurrent, ofConcurrent, ofConcurrent, ofConcurrent, ofConcurrent, ofConcurrent, builder, builder, builder, builder, builder, builder |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/file/CommentedFileConfigBuilder.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/file/ConfigLoadFilter.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/file/DebouncedRunnable.java` | `` |  | run, andThen |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/file/FileConfig.java` | `` |  | of, of, of, of, of, of, ofConcurrent, ofConcurrent, ofConcurrent, ofConcurrent, ofConcurrent, ofConcurrent, builder, builder, builder, builder, builder, builder |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/file/FileConfigBuilder.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/file/FileNotFoundAction.java` | `` |  | copyData, copyData, copyData, copyData, copyResource |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/file/FileWatcher.java` | `` |  | defaultInstance, addWatch, addWatch, addWatchFuture, setWatch, setWatch, setWatchFuture, addOrPutWatch, removeWatch, removeWatch, removeWatchFuture, removeWatch, stop, stopFuture, failIfStopped, newThread, from, toString, toString, watchDirectory, run |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/file/FormatDetector.java` | `` |  | registerExtension, registerExtension, detect, detect, detectByName, tryLoad |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/file/GenericBuilder.java` | `` |  | charset, writingMode, parsingMode, onFileNotFound, defaultResource, defaultData, defaultData, defaultData, sync, async, asyncWithDebouncing, autosave, autoreload, autoreload, onAutoReload, onAutoSave, onLoad, onSave, onLoadFilter, concurrent, preserveInsertionOrder, backingMapCreator, runnableOrNothing, build, buildAutosave, buildNormal |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/file/NoFormatFoundException.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/file/SyncFileConfig.java` | `` |  | getFile, getNioPath, save, load, close |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/IncompatibleIntermediaryLevelException.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/InMemoryCommentedFormat.java` | `` |  | defaultInstance, withSupport, withUniversalSupport, createWriter, createParser, createConfig, supportsComments, supportsType, isInMemory |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/InMemoryFormat.java` | `` |  | defaultInstance, withSupport, withUniversalSupport, createWriter, createParser, createConfig, supportsComments, supportsType, isInMemory |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/AbstractInput.java` | `` |  | read, readChar, peek, peek, peekChar, peekChar, skipPeeks, pushBack, readUntil, readCharsUntil, consumeDeque |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/AdditionalCharsets.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/ArrayInput.java` | `` |  | directRead, directReadChar, read, readChars |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/CharacterInput.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/CharacterOutput.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/CharsetUnicodeBom.java` | `` |  | canEncode, contains, newDecoder, newEncoder, canEncode, canEncode, isLegalReplacement, implReset, implFlush, encodeLoop, setupDecoder, isAutoDetecting, isCharsetDetected, detectedCharset, implFlush, implReset, decodeLoop |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/CharsWrapper.java` | `` |  | isEmpty, length, charAt, get, set, replaceAll, contains, indexOf, indexOfFirst, equals, equalsIgnoreCase, contentEquals, contentEquals, startsWith, subSequence, subView, subView, trimmedView, toString, hashCode, clone, iterator, hasNext, next, ensureCapacity, append, append, append, append, append, append, append, append, append, append, flush, close, write, write, write, write, write, write, write, length, getChars, get, set, compact, build, build, build, copyAndBuild, copyAndBuild, copyAndBuild, toString, toString, toString |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/ConfigParser.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/ConfigWriter.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/IndentStyle.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/IoUtils.java` | `` |  | tempConfigFileName, retryIfAccessDenied, retryIfAccessDenied |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/NewlineStyle.java` | `` |  | system |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/ParsingException.java` | `` |  | readFailed, notEnoughData |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/ParsingMode.java` | `` |  | prepareParsing, put, put, put |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/ReaderInput.java` | `` |  | directRead, directReadChar, read, readChars |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/Utils.java` | `` |  | arrayContains, arrayIndexOf, parseLong, parseInt, parseDouble |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/WriterOutput.java` | `` |  | write, write, write |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/WritingException.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/io/WritingMode.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/NullObject.java` | `` |  | toString, equals, hashCode |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/AbstractObjectDeserializer.java` | `` |  | deserializeToCollection, deserializeToMap, deserializeFields, deserializeFields, findValueDeserializer, findDefaultValueSupplier |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/AnnotationProcessor.java` | `` |  | resolveAssertPredicate1, resolveSkipDeserializingIfPredicate1, resolveSkipSerializingIfPredicate1, pedicateFromField, combineOr, combineAnd, findCustomPredicate, findFieldOrMethodIn, defaultSupplierFromField, defaultSupplierFromMethod, anyFromField, supplierFromMethod, predicateFromMethod |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/annotations/SerdeAssert.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/annotations/SerdeAssertsContainer.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/annotations/SerdeComment.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/annotations/SerdeCommentsContainer.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/annotations/SerdeDefault.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/annotations/SerdeDefaultsContainer.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/annotations/SerdeKey.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/annotations/SerdePhase.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/annotations/SerdeSkipDeserializingIf.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/annotations/SerdeSkipSerializingIf.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/ConfigToPojoDeserializer.java` | `` |  | deserialize |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/DeserializerContext.java` | `` |  | deserializeValue, deserializeFields, normalizeForDeserialization, configKey, skipField, assertField, preCheck |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/ObjectDeserializer.java` | `` |  | builder, blankBuilder, standard, deserializeToCollection, deserializeToMap, deserializeFields, deserializeFields |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/ObjectDeserializerBuilder.java` | `` |  | build, deserializeTransientFields, withDeserializerForClass, withDeserializerProvider, withDefaultDeserializerProvider, withDefaultDeserializerProvider, registerStandardDeserializers, provide |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/ObjectSerializer.java` | `` |  | builder, blankBuilder, standard, serialize, serializeFields, serializeFields |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/ObjectSerializerBuilder.java` | `` |  | build, withSerializerForExactClass, withSerializerForClass, withSerializerProvider, withDefaultSerializerProvider, withDefaultSerializerProvider, serializeTransientFields, registerStandardSerializers, provide |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/SerdeAssertException.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/SerdeException.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/SerializerContext.java` | `` |  | configFormat, createConfig, createCommentedConfig, serializeValue, serializeFields, configKey, configComment, skipField, assertField, preCheck |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/StandardDeserializers.java` | `` |  | isNumberTypeSupported, deserialize, deserialize, deserialize, deserialize, deserialize, createCollectionInstance, extractCollectionValueType, deserialize, extractMapKVType, createMapInstance, deserialize |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/StandardSerializers.java` | `` |  | serialize, serialize, serialize, serialize, serialize, serialize, serialize, serialize |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/TypeConstraint.java` | `` |  | getFullType, getSatisfyingRawType, resolveTypeArgumentsFor, toString, findSatisfyingRawType, resolveTypeArgumentsFor, resolveIfVariable, findParent, wildcardLowerBound, wildcardUpperBound, getActualTypeArguments, getOwnerType, getRawType, toString, equals, getLowerBounds, getUpperBounds, toString, equals, hashCode |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/Util.java` | `` |  | isEmptyWithReflection, toString, classOrNull |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/ValueDeserializer.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/ValueDeserializerProvider.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/ValueSerializer.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/serde/ValueSerializerProvider.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/SimpleCommentedConfig.java` | `` |  | configFormat, createSubConfig, clone |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/SimpleConfig.java` | `` |  | configFormat, createSubConfig, clone |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/UnmodifiableCommentedConfig.java` | `` |  | fake, getComment, getChildren |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/UnmodifiableConfig.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/AbstractObserved.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/CommentedConfigWrapper.java` | `` |  | getComment, containsComment, setComment, removeComment, commentMap, entrySet, clearComments, putAllComments, putAllComments, getComments, createSubConfig, toString |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/ConcurrentCommentedConfigWrapper.java` | `` |  | createSubConfig, bulkRead, bulkRead, bulkCommentedRead, bulkCommentedRead, bulkUpdate, bulkUpdate, bulkCommentedUpdate, bulkCommentedUpdate |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/ConfigWrapper.java` | `` |  | entrySet, set, add, remove, clear, createSubConfig, toString |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/FakeCommentedConfig.java` | `` |  | unwrap, getComment, containsComment, setComment, removeComment, clearComments, getComments, putAllComments, putAllComments, commentMap, entrySet, createSubConfig, getComment, getKey, getRawValue, setComment, removeComment, setValue |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/FakeUnmodifiableCommentedConfig.java` | `` |  | getComment, containsComment, getComments, commentMap, entrySet, getComment, getKey, getRawValue |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/FastStringReader.java` | `` |  | read, read, skip, markSupported, mark, reset, ready, close |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/IntDeque.java` | `` |  | isPowerOfTwo, nextPowerOfTwo, clear, isEmpty, size, compact, grow, addFirst, addLast, get, getFirst, getLast, removeFirst, removeLast |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/ObservedEntry.java` | `` |  | getKey, getValue, setValue, equals, hashCode |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/ObservedIterator.java` | `` |  | hasNext, next, remove, forEachRemaining, equals, hashCode |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/ObservedMap.java` | `` |  | size, isEmpty, containsKey, containsValue, get, put, remove, putAll, replaceAll, putIfAbsent, remove, replace, replace, computeIfAbsent, computeIfPresent, compute, merge, clear, keySet, values, entrySet, equals, hashCode |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/ObservedSet.java` | `` |  | size, isEmpty, contains, iterator, toArray, toArray, add, remove, containsAll, addAll, retainAll, removeAll, clear, removeIf, equals, hashCode |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/ObservedSet2.java` | `` |  | size, isEmpty, contains, iterator, toArray, toArray, add, remove, containsAll, addAll, retainAll, removeAll, clear, removeIf, equals, hashCode |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/StringUtils.java` | `` |  | split, split, splitLines, splitLines |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/TransformingCollection.java` | `` |  | size, isEmpty, contains, iterator, toArray, toArray, add, remove, containsAll, addAll, removeAll, removeIf, retainAll, clear, spliterator, stream, parallelStream, forEach, hashCode, equals, toString |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/TransformingIterator.java` | `` |  | hasNext, next, remove, forEachRemaining, hashCode, equals, toString |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/TransformingList.java` | `` |  | addAll, get, set, add, remove, indexOf, lastIndexOf, listIterator, listIterator, subList |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/TransformingListIterator.java` | `` |  | hasPrevious, previous, nextIndex, previousIndex, set, add |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/TransformingMap.java` | `` |  | size, isEmpty, containsKey, containsValue, get, put, remove, putAll, clear, keySet, values, entrySet, getOrDefault, forEach, replaceAll, putIfAbsent, remove, replace, replace, computeIfAbsent, computeIfPresent, compute, merge, transform, transform2 |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/TransformingMapEntry.java` | `` |  | getKey, getValue, setValue, equals, hashCode |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/TransformingSet.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/TransformingSpliterator.java` | `` |  | tryAdvance, forEachRemaining, trySplit, estimateSize, getExactSizeIfKnown, characteristics, hasCharacteristics, getComparator, hashCode, equals, toString |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/UnmodifiableConfigWrapper.java` | `` |  | getRaw, valueMap, entrySet, contains, size, isEmpty, equals, hashCode, configFormat |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/core/utils/WriterSupplier.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/toml/ArrayParser.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/toml/ArrayWriter.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/toml/StringParser.java` | `` |  | buildMultilineString, unescape, parseUnicodeCodepoint, isWhitespace |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/toml/StringWriter.java` | `` |  | writeBasicChar |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/toml/TableParser.java` | `` |  | checkDuplicateKeyBecauseOfParents, checkDuplicateKey |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/toml/TableWriter.java` | `` |  | writeWithHeader, writeSubTables, writeArraysOfTables, writeTableArrayName, writeTableName, writeTableName, toString |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/toml/TemporalParser.java` | `` |  | parseDate, parseTime |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/toml/TemporalWriter.java` | `` |  | writeDate, writeHour, writePadded, writePaddedAndTrimmed |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/toml/Toml.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/toml/TomlFormat.java` | `` |  | instance, newConfig, newConfig, newConcurrentConfig, createWriter, createParser, createConfig, supportsComments, supportsType |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/toml/TomlParser.java` | `` |  | clearParsingState, parse, parse, parse, getSubTable, checkContainsOnlySubtables, isLenientWithSeparators, setLenientWithSeparators, isLenientWithBareKeys, setLenientWithBareKeys, setInitialStringBuilderCapacity, setInitialListCapacity, getFormat |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/toml/TomlWriter.java` | `` |  | write, isHidingRedundantLevels, setHideRedundantLevels, isOmitIntermediateLevels, setOmitIntermediateLevels, isLenientWithBareKeys, setLenientWithBareKeys, setWriteTableInlinePredicate, setWriteStringLiteralPredicate, setWriteStringMultilinePredicate, setIndentArrayElementsPredicate, setIndent, setIndent, setNewline, setNewline |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/toml/ValueParser.java` | `` |  | shouldBeTemporal, parseNumber, isDigitChar, simplifyNumber, parseFalse, parseTrue |
| top-level / `me/decce/ixeris/core/shadow/nightconfig/toml/ValueWriter.java` | `` |  | writeString |
| top-level / `me/decce/ixeris/core/threading/MainThreadDispatcher.java` | `` |  | shouldPollEvents, isOnThread, query, run, runLater, sendToMainThread, requestPollEvents, runNow, runNowImpl, replayQueue, findNextTask, pollEvents, await, run, run |
| top-level / `me/decce/ixeris/core/threading/RenderThreadDispatcher.java` | `` |  | runLater, innerRunLater, replayQueue, runTask, runTaskChecked |
| top-level / `me/decce/ixeris/core/transform/ClassLoaderHandler.java` | `` |  | verifyClassLoaders, toClassName, loadCoreClasses, getClassesStream, walkResource, readClassBytes, loadClass, defineClass |
| top-level / `me/decce/ixeris/core/transform/TransformationHelper.java` | `` |  | findBootModule, findBootModule, findGlfwModule, findSdlModule, findLog4jModule, expandGlfwModuleReads, addReads, doTransformation, getTransformerManager |
| top-level / `me/decce/ixeris/core/transform/util/TransformationConstants.java` | `` |  |  |
| top-level / `me/decce/ixeris/core/util/BooleanHolder.java` | `` |  | BooleanHolder, of |
| top-level / `me/decce/ixeris/core/util/LambdaHelper.java` | `` |  | makeRunnable, makeRunnable, makeRunnable, makeRunnable, makeRunnable, makeRunnable, makeRunnable, makeSupplier, makeSupplier, makeSupplier, makeSupplier, makeSupplier, makeSupplier, makeSupplier |
| top-level / `me/decce/ixeris/core/util/LWJGLVersionHelper.java` | `` |  | is330OrGreater, is334OrGreater, is340OrGreater |
| top-level / `me/decce/ixeris/core/util/MemoryHelper.java` | `` |  | copyIntArray, copyString, copyString, copyStringArray, copyByteBuffer, copyGlfwImage, free, free |
| top-level / `me/decce/ixeris/core/util/PlatformHelper.java` | `` |  | isLinux, isWindows, isMacOs, isAndroid, isX64 |
| top-level / `me/decce/ixeris/core/util/ReflectionHelper.java` | `` |  | unreflect, unreflectGetter |
| top-level / `me/decce/ixeris/core/util/UpcallExceptionHelper.java` | `` |  | isSupported, handleUpcallException, getLwjglUpcallExceptionHandler, invokeLwjglUpcallExceptionHandler |
| top-level / `me/decce/ixeris/core/util/VolatileObjectHolder.java` | `` |  | setValue, getValue, of |
| top-level / `me/decce/ixeris/fabric/IxerisModFabric.java` | `` |  | onInitializeClient |
| top-level / `me/decce/ixeris/IxerisCoreMixinPlugin.java` | `` |  | getMixins |
| top-level / `me/decce/ixeris/IxerisMinecraftAccessorImpl.java` | `` |  | getMinecraftWindow, setIgnoreFirstMouseMove, isMouseInternallyGrabbed, isOnRenderThread, lockContext, unlockContext |
| top-level / `me/decce/ixeris/IxerisMixinPlugin.java` | `` |  | shouldApplyMixin, shouldApplyMixin, onLoad, getMixins, getRefMapperConfig, acceptTargets, preApply, postApply |
| top-level / `me/decce/ixeris/IxerisMod.java` | `` |  | init, isOnRenderThread |
| top-level / `me/decce/ixeris/JavaHelper.java` | `` |  | tryGetMajor |
| top-level / `me/decce/ixeris/mixins/enhanced_fps_limiter/RenderSystemMixin.java` | `value={RenderSystem.class}, remap=false)` |  |  |
| top-level / `me/decce/ixeris/mixins/macos/MacosUtilMixin.java` | `value={Window.class}, remap=false)` |  |  |
| top-level / `me/decce/ixeris/mixins/macos/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:2 | ixeris$beforeRender, ixeris$afterRender |
| top-level / `me/decce/ixeris/mixins/MainMixin.java` | `value={Main.class})` | Inject:1 | ixeris$main, ixeris$createRenderThreadRunnable |
| top-level / `me/decce/ixeris/mixins/MinecraftMixin.java` | `value={Minecraft.class}, priority=500)` | Inject:4, ModifyExpressionValue:1 | ixeris$pollEvents, ixeris$updateTextInputArea, ixeris$replayQueue, ixeris$reconfigureSurfaceWhenNeeded, ixeris$postSurfaceConfiguration |
| top-level / `me/decce/ixeris/mixins/MouseHandlerAccessor.java` | `value={MouseHandler.class})` | Accessor:1 |  |
| top-level / `me/decce/ixeris/mixins/MouseHandlerMixin.java` | `value={MouseHandler.class})` | WrapMethod:2 | ixeris$wrapGrabMouse, ixeris$wrapReleaseMouse |
| top-level / `me/decce/ixeris/mixins/RenderSystemMixin.java` | `value={RenderSystem.class}, priority=500, remap=false)` |  |  |
| top-level / `me/decce/ixeris/mixins/TitleScreenMixin.java` | `value={TitleScreen.class})` | Inject:1 | ixeris$init |
| top-level / `me/decce/ixeris/mixins/WindowMixin.java` | `value={Window.class})` |  |  |
| top-level / `me/decce/ixeris/mixins/workarounds/WindowAccessor.java` | `value={Window.class})` | Accessor:1 |  |
| top-level / `me/decce/ixeris/RenderThreadStarter.java` | `` |  | run, tryCreateMinecraft, initGameThread, beginInitialization, finishInitialization |
| top-level / `me/decce/ixeris/VersionCompatUtils.java` | `` |  | profilerPush, profilerPop, profilerPopPush, getMinecraftWindow |
| top-level / `me/decce/ixeris/workarounds/VulkanSwapchainValidityWorkaround.java` | `` |  | init, onFramebufferSizeCallback |
| top-level / `me/decce/ixeris/workarounds/WindowMinimizedStateWorkaround.java` | `` |  | init, onFramebufferSizeCallback |
| top-level / `META-INF/versions/17/me/decce/ixeris/core/shadow/nightconfig/core/serde/ConfigToPojoDeserializer.java` | `` |  | deserialize, deserializeToNormalClass, deserializeToRecord, getCanonicalRecordConstructor |
| top-level / `META-INF/versions/17/me/decce/ixeris/core/shadow/nightconfig/core/serde/ObjectDeserializer.java` | `` |  | builder, blankBuilder, standard, deserializeToCollection, deserializeToMap, deserializeFields, deserializeFields, deserializeToRecord |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
