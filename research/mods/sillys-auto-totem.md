# Silly's Auto Totem

Review status: **Evidence inventory; behavioral review pending**

Project: [Silly's Auto Totem](https://modrinth.com/mod/sillys-auto-totem)
Selected artifact version: `2.3.6`
Published implementation source: https://github.com/sillygoober2/Auto-Totem
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Allows you to automatically reequip a totem after popping one

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `440ff247fd57007d5dcbd76cebfbb18e08e0c6eead96f8e28552e3459294d33d958d4dca07b418b88cc19f51186cffdb06894bf8d503dda9a92dbd72aad18c1e`
- `sha1`: `4fcb1fb8cceabca86b96dcb7bb204ac1b8a872ef`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 12
Reconstructed Java files: 12

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "silly.autototem.FMain"
  ],
  "modmenu": [
    "silly.autototem.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `silly/autototem/AutoTotemConfigScreen.java` | `` |  | getEnabledButtonY, getDynamicIconSize, getIconY, init, coloredOnOffBuilder, getFormattedAlert, getFormattedColorText, extractRenderState, isPauseScreen, onClose |
| top-level / `silly/autototem/CommonClass.java` | `` |  | init, scheduleEquip, onClientTick, getItem, equipSlot, convertToContainerSlot, sendChatAlert |
| top-level / `silly/autototem/ConfigData.java` | `` |  | init, load, save |
| top-level / `silly/autototem/Constants.java` | `` |  |  |
| top-level / `silly/autototem/FCommands.java` | `` |  | onInitializeClient |
| top-level / `silly/autototem/FMain.java` | `` |  | onInitializeClient |
| top-level / `silly/autototem/mixin/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | Inject:1 | onEntityEvent |
| top-level / `silly/autototem/mixin/MixinMinecraft.java` | `value={Minecraft.class})` | Inject:1 | init |
| top-level / `silly/autototem/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `silly/autototem/platform/FabricPlatformHelper.java` | `` |  | getPlatformName, isModLoaded, isDevelopmentEnvironment |
| top-level / `silly/autototem/platform/services/IPlatformHelper.java` | `` |  |  |
| top-level / `silly/autototem/platform/Services.java` | `` |  | load |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
