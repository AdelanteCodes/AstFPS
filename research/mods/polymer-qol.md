# Polymer - Quality of Life

Review status: **Evidence inventory; behavioral review pending**

Project: [Polymer - Quality of Life](https://modrinth.com/mod/polymer-qol)
Selected artifact version: `1.0.3+26.3`
Published implementation source: https://github.com/DrexHD/polymer-qol
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Client side quality of life improvements on polymer powered servers!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha1`: `0f308fdf09cb6b2bc17f65866f0ec58d19f9ff40`
- `sha512`: `11e9d0f0203c12c571a981306a460f821bcfc1ebdfedb3313b01d92dd5a4a8ff325280c3a5cc2ac782675d5c037f6218e723d388ca646b72e4514f62713cb13c`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 17
Reconstructed Java files: 17

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "me.drex.polymerqol.PolymerQOL"
  ],
  "client": [
    "me.drex.polymerqol.PolymerQOLClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16.14",
  "fabric-api": "*",
  "java": ">=21"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/polymer-core-0.18.2+26.3.jar` | 339 | `polymer-core` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/drex/polymerqol/config/ConfigManager.java` | `` |  | load |
| top-level / `me/drex/polymerqol/config/ServerConfig.java` | `` |  |  |
| top-level / `me/drex/polymerqol/duck/IConnection.java` | `` |  |  |
| top-level / `me/drex/polymerqol/mixin/client/mining/BlockBehaviourMixin.java` | `value={BlockBehaviour.class})` | WrapOperation:3 | clientSideGetDestroySpeed, clientSideHasCorrectToolForDrops, clientSideGetDestroySpeed |
| top-level / `me/drex/polymerqol/mixin/client/mining/PlayerMixin.java` | `value={Player.class})` | WrapOperation:1 | clientSideRequiresCorrectToolForDrops |
| top-level / `me/drex/polymerqol/mixin/client/mining/ToolMixin.java` | `value={Tool.class})` | WrapOperation:1 | clientSideBlockTags |
| top-level / `me/drex/polymerqol/mixin/client/swing/NoteBlockMixin.java` | `value={NoteBlock.class})` | Inject:1 | useWithoutItem |
| top-level / `me/drex/polymerqol/mixin/client/update/BlockBehaviourMixin.java` | `value={BlockBehaviour.BlockStateBase.class})` | WrapOperation:1 | dontUpdatePolymerBlocksOnClient |
| top-level / `me/drex/polymerqol/mixin/ConnectionMixin.java` | `value={Connection.class})` |  | polymer_qol$setConfiguration, polymer_qol$configuration |
| top-level / `me/drex/polymerqol/mixin/mining/PolymerBlockUtilsMixin.java` | `value={PolymerBlockUtils.class})` | WrapOperation:1 | clientSideMining |
| top-level / `me/drex/polymerqol/mixin/ServerCommonPacketListenerImplAccessor.java` | `value={ServerCommonPacketListenerImpl.class})` | Accessor:1 |  |
| top-level / `me/drex/polymerqol/networking/ApplyConfigurationS2CPayload.java` | `` |  | write, type |
| top-level / `me/drex/polymerqol/networking/ClientConfiguration.java` | `` |  | ClientConfiguration, of, applyServerConfiguration, shouldMineClientSide |
| top-level / `me/drex/polymerqol/networking/OfferConfigurationC2SPayload.java` | `` |  | write, type |
| top-level / `me/drex/polymerqol/PolymerQOL.java` | `` |  | onInitialize, getConfiguration |
| top-level / `me/drex/polymerqol/PolymerQOLClient.java` | `` |  | onInitializeClient |
| top-level / `me/drex/polymerqol/util/PolymerQOLMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
