# Tick Sync

Review status: **Evidence inventory; behavioral review pending**

Project: [Tick Sync](https://modrinth.com/mod/tick-sync)
Selected artifact version: `1.4.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Reduces the delay between server packets and client ticks.

서버에서 도착한 패킷과 클라이언트 틱 사이의 딜레이를 완화합니다.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `b5143a8f18808c646e68151790ea636ec65a032a`
- `sha512`: `00eb62faa997c36d37dc7ce64ad9c1391d1488ad3ac45de96d81b2994316603f45019cdeea390aa1d81ea3ada5e2d95696764dee95a8a87d5abf99aa68abd473`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 11
Reconstructed Java files: 10

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `loggamja/sync/api/TickSyncAPI.java` | `` |  | setMenuButtonHidden, isMenuButtonHidden, setToggleOption, getToggleOption, resetToDefaults, openSettings |
| top-level / `loggamja/sync/mixin/ClientPlayNetworkHandlerMixin.java` | `value={ClientPacketListener.class})` | Inject:2 | ticksync$onEntityUpdate, ticksync$onUpdateTickRate |
| top-level / `loggamja/sync/mixin/GameMenuScreenMixin.java` | `value={PauseScreen.class})` | Inject:1 | ticksync$addCustomButton |
| top-level / `loggamja/sync/mixin/InGameHudMixin.java` | `value={Hud.class})` | Inject:1 | ticksync$onRender |
| top-level / `loggamja/sync/mixin/MinecraftClientMixin.java` | `value={Minecraft.class})` | Inject:1 | ticksync$uncapClientTickRate |
| top-level / `loggamja/sync/TickSyncConfig.java` | `` |  | load, save |
| top-level / `loggamja/sync/TickSyncHUDManager.java` | `` |  | updateHUD, addToDebugHistogram |
| top-level / `loggamja/sync/TickSyncMain.java` | `` |  | onInitializeClient, onEntityPacket, canSync, onClientTickStart, isMinecraftAtLeast |
| top-level / `loggamja/sync/TickSyncOptionTable.java` | `` |  | findToggle, ToggleDef, stateCount |
| top-level / `loggamja/sync/TickSyncSetting.java` | `` |  | init, extractRenderState, onClose |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
