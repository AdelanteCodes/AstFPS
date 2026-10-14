# PinChat

Review status: **Evidence inventory; behavioral review pending**

Project: [PinChat](https://modrinth.com/mod/pinchat)
Selected artifact version: `3.2.0-fabric-mc26.3`
Published implementation source: https://github.com/ivanmikhaylov1/pinchat-mod
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Keep important chat messages on your HUD. Pin, organize, move, and resize message groups—or keep moving with chat open. Client-side, with simple built-in settings.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `296161be788011593d49e93b4bcd157e3f651d7db2416a0ad9b64245972a1cc2f16dc57bd38ba99c56aa3ab71a0c3516a53c87dcfd01cf13d9e161400af71ee7`
- `sha1`: `0fe0a7e7a63b8c597fa470cf07084cb9f300e4ad`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 23
Reconstructed Java files: 22

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "dev.sfafy.pinchat.PinChatMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "minecraft": "26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/sfafy/pinchat/config/ConfigSerializer.java` | `` |  | toJson, fromJson, saveToFile, loadFromFile |
| top-level / `dev/sfafy/pinchat/config/PinChatConfig.java` | `` |  | load, save |
| top-level / `dev/sfafy/pinchat/config/PinChatConfigData.java` | `` |  | reset, getOrCreateDefaultGroup, copy |
| top-level / `dev/sfafy/pinchat/gui/GroupRenameScreen.java` | `` |  | init, extractRenderState, isPauseScreen |
| top-level / `dev/sfafy/pinchat/gui/MoveableChatScreen.java` | `` |  | init, hideChatField, tick, relativeMouseMoved, mouseMoved, removed, isPauseScreen |
| top-level / `dev/sfafy/pinchat/gui/PinChatConfigScreen.java` | `` |  | init, toggleLabel, onClose, extractRenderState |
| top-level / `dev/sfafy/pinchat/input/MoveableChatInput.java` | `` |  | tick, isKeyPressed |
| top-level / `dev/sfafy/pinchat/input/PinChatInput.java` | `` |  | isPressed, isMousePressed, chatButton |
| top-level / `dev/sfafy/pinchat/integration/IntegrationManager.java` | `` |  | detectMods, isMalilibLoaded, isClothConfigLoaded, isModMenuLoaded, isYaclLoaded, getConfigScreen |
| top-level / `dev/sfafy/pinchat/keybindings/PinChatKeyBindings.java` | `` |  | register |
| top-level / `dev/sfafy/pinchat/MessageGroup.java` | `` |  | copy, toString |
| top-level / `dev/sfafy/pinchat/mixin/ChatHudAccessor.java` | `value={ChatComponent.class})` | Accessor:2, Invoker:1 |  |
| top-level / `dev/sfafy/pinchat/mixin/ChatScreenAccessor.java` | `value={ChatScreen.class})` | Accessor:1 |  |
| top-level / `dev/sfafy/pinchat/mixin/ChatScreenMixin.java` | `value={ChatScreen.class})` | Inject:2 | onRender, onMouseClicked |
| top-level / `dev/sfafy/pinchat/mixin/FontAccessor.java` | `value={Font.class})` | Accessor:1 |  |
| top-level / `dev/sfafy/pinchat/mixin/MoveableChatMouseMixin.java` | `value={MouseHandler.class})` | Inject:1 | pinchat$relativeMotion |
| top-level / `dev/sfafy/pinchat/mixin/PinChatKeyBindingAccessor.java` | `value={KeyMapping.class})` | Accessor:1 |  |
| top-level / `dev/sfafy/pinchat/PinChatMod.java` | `` |  | onInitializeClient |
| top-level / `dev/sfafy/pinchat/PinnedHudRenderer.java` | `` |  | register, onRenderGui |
| top-level / `dev/sfafy/pinchat/PinnedMessages.java` | `` |  | normalize, getOrCreateDefaultGroup, toggle, toggle |
| top-level / `dev/sfafy/pinchat/PinnedMessagesManager.java` | `` |  | normalize, createGroup, getOrCreateDefaultGroup, toggle, toggle, getConfig |
| top-level / `dev/sfafy/pinchat/Reference.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
