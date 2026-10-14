# HCsCR

Review status: **Evidence inventory; behavioral review pending**

Project: [HCsCR](https://modrinth.com/mod/hcscr)
Selected artifact version: `2.1.13+26.3-fabric`
Published implementation source: https://github.com/VidTu/HCsCR
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Remove your end crystals before the server even knows you hit 'em! (a "crystal optimizer")

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `223647ffe7d64f20cf2b0b5b6cde24b73b967f51`
- `sha512`: `5c94eea1d79d93dbc0956da2956dc359fe4f51c36b89148b75ccbf2b318674f719d7a1b91a9282838795871424c880e6927ff89afa08aa942efe2b1822ed65cb`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 27
Reconstructed Java files: 20

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "ru.vidtu.hcscr.platform.HFabric"
  ],
  "modmenu": [
    "ru.vidtu.hcscr.platform.HModMenu"
  ]
}
```

**depends**

```json
{
  "minecraft": "26.3",
  "fabric-key-mapping-api-v1": "*",
  "fabric-lifecycle-events-v1": "*",
  "fabric-networking-api-v1": "*",
  "fabric-resource-loader-v1": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `ru/vidtu/hcscr/config/BlockMode.java` | `` |  | toString |
| top-level / `ru/vidtu/hcscr/config/Config.java` | `` |  | load, toString, enable, crystals, crystalsDelay, crystalsResync, blocks, shouldProcess, toggle |
| top-level / `ru/vidtu/hcscr/config/ConfigScreen.java` | `` |  | init, onClose, extractRenderState, createButton, createCheckbox, createSlider, updateMessage, applyValue, toString, calculateWidgetY |
| top-level / `ru/vidtu/hcscr/config/CrystalMode.java` | `` |  | toString |
| top-level / `ru/vidtu/hcscr/handler/BlockClips.java` | `` |  | tick, shouldClip, addClip, removeClip, clearClips |
| top-level / `ru/vidtu/hcscr/handler/HiddenEntities.java` | `` |  | tick, isHidden, hideFor, show, showAll |
| top-level / `ru/vidtu/hcscr/handler/Keys.java` | `` |  | tick, config, toggle |
| top-level / `ru/vidtu/hcscr/handler/ScheduledEntities.java` | `` |  | loop, scheduleAt, unschedule, unscheduleAll |
| top-level / `ru/vidtu/hcscr/HCsCR.java` | `` |  | tick, loop, hit |
| top-level / `ru/vidtu/hcscr/mixin/block/AbstractBedBlockMixin.java` | `value={AbstractBedBlock.class})` | Inject:1 | hcscr_useWithoutItem_head |
| top-level / `ru/vidtu/hcscr/mixin/block/BlockBehaviour_BlockStateBaseMixin.java` | `value={BlockBehaviour.BlockStateBase.class})` | Inject:1 | hcscr_getCollisionShape_head |
| top-level / `ru/vidtu/hcscr/mixin/block/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | Inject:1 | hcscr_handleBlockUpdate_return |
| top-level / `ru/vidtu/hcscr/mixin/block/RespawnAnchorBlockMixin.java` | `value={RespawnAnchorBlock.class})` | Inject:1 | hcscr_useWithoutItem_head |
| top-level / `ru/vidtu/hcscr/mixin/crystal/EntityMixin.java` | `value={Entity.class})` | Inject:1 | hcscr_getBoundingBox_head |
| top-level / `ru/vidtu/hcscr/mixin/crystal/InteractionMixin.java` | `value={Interaction.class})` | Inject:1 | hcscr_skipAttackInteraction_head |
| top-level / `ru/vidtu/hcscr/mixin/crystal/PlayerMixin_E.java` | `value={Player.class})` | WrapOperation:1 | hcscr_attack_hurtOrSimulate |
| top-level / `ru/vidtu/hcscr/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:2 | hcscr_updateLevelInEngines_return, hcscr_runTick_return |
| top-level / `ru/vidtu/hcscr/platform/HFabric.java` | `` |  | onInitializeClient, type, toString, toString |
| top-level / `ru/vidtu/hcscr/platform/HModMenu.java` | `` |  | getModConfigScreenFactory, getUpdateChecker, toString, checkForUpdates, update, toString, isUpdateAvailable, getUpdateMessage, getDownloadLink, getUpdateChannel, toString |
| top-level / `ru/vidtu/hcscr/platform/HStonecutter.java` | `` |  | translate, translate, profilerOfClient |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
