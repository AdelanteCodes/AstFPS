# WindowFix

Review status: **Behavioral static review**

Project: [WindowFix](https://modrinth.com/mod/window-fix)
Selected artifact version: `1.0.1`
Published implementation source: https://github.com/huanmeng-qwq/WindowFix
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Used to fix the issue of main loop hang/freeze that may occur in Minecraft under Windows after operating the system menu of the window title bar (right-clicking the title bar, minimizing, restoring, etc.).

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `20052346930e2b58430311adec370d40e8e47b8e`
- `sha512`: `b5e47910f5825e6c4a47e94ff57a378dec5a5b82397a41a1d3a210e6eba2b95847ff9bf3836cedae97d6bd66fb33518635338077817e3509d553411ae166399c`

## Reviewed mechanism

All three reconstructed classes reviewed.

- On Windows client ticks, installs a Win32 window-procedure hook once an SDL window/native HWND exists. Retains the original procedure for forwarding.
- Either blocks selected title-bar/system-menu messages or attempts to set the system menu to modeless mode. Posts a custom empty SDL event around menu/resize/minimize/restore transitions to wake the event loop.
- Native function availability and hook failures are logged; callback exceptions fall back to the original procedure. Window destruction resets installation state.

## Lifecycle, correctness, and failure questions

- Native callback lifetime, HWND recreation, restoring the original procedure, and freeing the callback require careful verification. The shown reset clears state but does not visibly free every native resource.
- Configuration catches I/O exceptions but malformed JSON can throw separately. Native structure sizes/offsets depend on pointer size.

## Checks needed to establish equivalence

- Exercise right-click title bar, Alt+Space, drag-resize, minimize/restore, fullscreen transitions, window recreation, both menu modes, and callback failures on supported Windows architectures.

## Relevance to AstFPS

Windows freeze workaround; not a normal-frame throughput optimization.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 3
Reconstructed Java files: 3

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "me.huanmeng.windowfix.Windowfix"
  ]
}
```

**depends**

```json
{
  "minecraft": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/huanmeng/windowfix/Windowfix.java` | `` |  | onInitializeClient, onClientTick, isWindows |
| top-level / `me/huanmeng/windowfix/WindowfixConfig.java` | `` |  | save |
| top-level / `me/huanmeng/windowfix/WindowMessageFix.java` | `` |  | tryInstall, isWindows, dispatchMessage, handleMessage, callOriginal, configureSystemMenuModeless, resolveFunctionAddress, align, postEmptyEvent, resetHookState |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
