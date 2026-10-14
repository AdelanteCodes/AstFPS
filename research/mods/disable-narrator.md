# Disable Narrator

Review status: **Behavioral static review**

Project: [Disable Narrator](https://modrinth.com/mod/disable-narrator)
Selected artifact version: `1.0.0`
Published implementation source: https://github.com/fmg1925/Disable-Narrator
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Disables the narrator completely off the game, no toasts, skips narrator libraries error checking, no text to speech libraries load

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `bafeb4be5f734f400a575a969ba7ece98fcd077ba3ad052f4d82cef3c293523c27e581ba4477a15262606ecdd2b9294c73c06abadbdf2916a3493e68095fe62e`
- `sha1`: `ebe097e3a063dbf83d92584e9e260d07d5ef6b65`

## Reviewed mechanism

All seven reconstructed classes reviewed; Windows native superclass reconstruction is incomplete.

- Redirects GameNarrator construction to Narrator.EMPTY, replaces narration with a no-op, and changes the narrator hotkey option default to false.
- Additional platform-specific mixins cancel portions of Linux/macOS narrator constructors and suppress Windows SAPI initialization and speech methods.

## Lifecycle, correctness, and failure questions

- Removes accessibility functionality. Native constructor cancellation and no-op cleanup must not leave half-initialized native objects reachable.
- The Windows reconstructed class extends an unresolved superclass; native lifetime details require original source or bytecode.

## Checks needed to establish equivalence

- Check each OS's startup, cleanup, absent native libraries, narrator options/hotkeys, and UI consumers of narrator active state.

## Relevance to AstFPS

Accessibility removal/startup workaround; excluded as a general performance default.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 7
Reconstructed Java files: 7

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.fmg1925.disablenarrator.DisableNarrator"
  ],
  "client": [
    "com.fmg1925.disablenarrator.DisableNarratorClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": "*",
  "minecraft": ">1.21.11",
  "java": ">=21"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/fmg1925/disablenarrator/DisableNarrator.java` | `` |  | onInitialize |
| top-level / `com/fmg1925/disablenarrator/DisableNarratorClient.java` | `` |  | onInitializeClient |
| top-level / `com/fmg1925/disablenarrator/mixin/client/NoLinuxNarratorMixin.java` | `value={NarratorLinux.class})` | Inject:1, Overwrite:1 | onInit, say, clear, destroy |
| top-level / `com/fmg1925/disablenarrator/mixin/client/NoMacNarratorMixin.java` | `value={NarratorMac.class})` | Inject:1 | onInit |
| top-level / `com/fmg1925/disablenarrator/mixin/client/NoNarratorKeyboardShortcutMixin.java` | `value={Options.class})` | Inject:1 | onInit |
| top-level / `com/fmg1925/disablenarrator/mixin/client/NoNarratorToastMixin.java` | `value={GameNarrator.class})` | Overwrite:1, Redirect:1 | narrateMessage, getOS |
| top-level / `com/fmg1925/disablenarrator/mixin/client/NoWindowsNarratorMixin.java` | `value={NarratorWindows.class})` | Overwrite:2 | initSAPI, say, clear, destroy |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
