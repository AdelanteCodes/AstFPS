# Simple Keybinds

Review status: **Evidence inventory; behavioral review pending**

Project: [Simple Keybinds](https://modrinth.com/mod/simple-keybinds)
Selected artifact version: `1.4.7`
Published implementation source: https://github.com/Dillon8775/Simple-Keybinds
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A Fabric/(Neo)Forge mod that adds simple(r) keybinds to Minecraft.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `9077dd4526ca1d6908c2eb0e3ac177c073086f6a`
- `sha512`: `b63dba51cff5055f963744228ca6eb1cd0ddcf8b7df44b0d770159299522d2ccad131c0d69469c9dafc0342ec2ecb27ea01cc6fe48cb049fb40f56654154fead`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 28
Reconstructed Java files: 27

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "net.dillon.simplekeybinds.SimpleKeybinds"
  ],
  "modmenu": [
    "net.dillon.simplekeybinds.impl.ModMenuImpl"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3 <26.4",
  "java": ">=25",
  "fabric-api": "*",
  "balm-fabric": ">=26.3.0.1",
  "dillonlib": ">=1.2"
}
```

**accessWidener**

```json
"simplekeybinds.accesswidener"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/dillon/simplekeybinds/callback/MuteCallback.java` | `` |  | tickScroll, unscroll, resetMuteCooldown, allowMuting |
| top-level / `net/dillon/simplekeybinds/config/ConfigurationScreen.java` | `` |  | configScreen |
| top-level / `net/dillon/simplekeybinds/debug/ModDebugEntry.java` | `` |  | isAllowed, category |
| top-level / `net/dillon/simplekeybinds/debug/ModDebugEntryBrightness.java` | `` |  | display |
| top-level / `net/dillon/simplekeybinds/debug/ModDebugScreenEntries.java` | `` |  | registerDebugEntries |
| top-level / `net/dillon/simplekeybinds/event/ClientEvents.java` | `` |  | onPlayerJoin |
| top-level / `net/dillon/simplekeybinds/event/FabricClientEvents.java` | `` |  | registerConnectionChecks |
| top-level / `net/dillon/simplekeybinds/helper/ModConstants.java` | `` |  |  |
| top-level / `net/dillon/simplekeybinds/helper/ModHelper.java` | `` |  | simpleKeybindsIdentifier, createMenuButton, initializeSuccess, sendClientMessage, mute, unmute, handleFog, toComponentString, onValueUpdate |
| top-level / `net/dillon/simplekeybinds/impl/ModMenuImpl.java` | `` |  | getModConfigScreenFactory |
| top-level / `net/dillon/simplekeybinds/keybind/ModKeyMappings.java` | `` |  | autoBrightness, message, getChatHud, initKeybinds |
| top-level / `net/dillon/simplekeybinds/main/ClientMain.java` | `` |  | cInitialize |
| top-level / `net/dillon/simplekeybinds/mixin/ConditionalMixinPlugin.java` | `` |  | shouldApplyMixin, onLoad, getRefMapperConfig, acceptTargets, getMixins, preApply, postApply |
| top-level / `net/dillon/simplekeybinds/mixin/FogRendererMixin.java` | `value={FogRenderer.class})` | Inject:1 | modifyFogEnd |
| top-level / `net/dillon/simplekeybinds/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | tickScrolling |
| top-level / `net/dillon/simplekeybinds/mixin/MouseMixin.java` | `value={MouseHandler.class})` | Inject:1 | handleScrollableKeybinds, sendMessage |
| top-level / `net/dillon/simplekeybinds/option/MenuButton.java` | `` |  | enabled, everywhere, getSerializedName |
| top-level / `net/dillon/simplekeybinds/option/Messages.java` | `` |  | overlay, getSerializedName |
| top-level / `net/dillon/simplekeybinds/option/ModClientOptions.java` | `` |  | createDefault, getConfigClass |
| top-level / `net/dillon/simplekeybinds/option/OptionInstances.java` | `` |  | client, updateClient |
| top-level / `net/dillon/simplekeybinds/platform/client/ClientSimpleKeybindsPlatform.java` | `` |  | modId, menuButtons, registerKeyMapping, canSendPacket |
| top-level / `net/dillon/simplekeybinds/platform/mixinsafe/MixinSimpleKeybindsPlatform.java` | `` |  | modId, shouldApplyFullBright |
| top-level / `net/dillon/simplekeybinds/platform/SimpleKeybindsPlatform.java` | `` |  | modId, modVersion, release, platform |
| top-level / `net/dillon/simplekeybinds/platform/SimpleKeybindsPlatforms.java` | `` |  | getPlatform, getMixinPlatform |
| top-level / `net/dillon/simplekeybinds/screen/MainMenuScreen.java` | `` |  | renderModInfo, widgets |
| top-level / `net/dillon/simplekeybinds/SimpleKeybinds.java` | `` |  | onInitializeClient |
| top-level / `net/dillon/simplekeybinds/util/SimpleKeybindsMixinPlugin.java` | `` |  | logger, mixinDirectory, entries |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
