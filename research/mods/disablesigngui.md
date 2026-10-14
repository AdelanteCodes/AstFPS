# NoSignGUI

Review status: **Evidence inventory; behavioral review pending**

Project: [NoSignGUI](https://modrinth.com/mod/disablesigngui)
Selected artifact version: `4.2.0+26.3-fabric`
Published implementation source: https://github.com/CoolAid48/DisableSignGUI
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Allows you to toggle the sign text interface off and on

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `cb30d2d6beb45269e0bc58d8e78cc6bd1b23489206aa843e8fad09f2af51cd7028dfc52e5cb45f592ee2d215a6849da55792cc4cfd8c1a89fefc765b46e1c08f`
- `sha1`: `14cc474908b5dbdba63820817a552696d9cb0b20`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 6
Reconstructed Java files: 6

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "me.coolaid.nosigngui.fabric.NoSignGUIFabric"
  ]
}
```

**depends**

```json
{
  "minecraft": "26.3",
  "fabricloader": ">=0.19.5",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `architectury_inject_nosigngui_263_8434036ec66e472aae1fb0baaa069e45_f8983872decda3a01930a49812ea88865b69cb6b59f265fc1bc407b288fe98a0nosignguicommon420263devjar/PlatformMethods.java` | `` |  | getCurrentTarget |
| top-level / `me/coolaid/nosigngui/fabric/NoSignGUIFabric.java` | `` |  | onInitializeClient |
| top-level / `me/coolaid/nosigngui/mixin/MixinClientPacketListener.java` | `value={ClientPacketListener.class})` | Inject:1 | onHandleOpenSignEditor |
| top-level / `me/coolaid/nosigngui/mixin/MixinSignItem.java` | `value={SignBlock.class})` | Inject:1 | onSetPlacedBy |
| top-level / `me/coolaid/nosigngui/NoSignGUI.java` | `` |  | init, isSignGuiEnabled, markPlacedSignForSkippedGui, shouldSkipPlacedSignGui, toggleSignGuiMessage |
| top-level / `me/coolaid/nosigngui/NoSignGUIConfig.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
