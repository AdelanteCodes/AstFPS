# Blindspot

Review status: **Evidence inventory; behavioral review pending**

Project: [Blindspot](https://modrinth.com/mod/blindspot)
Selected artifact version: `0.3.0`
Published implementation source: https://github.com/Cheter0410/blindspot
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A Minecraft Fabric mod aiming to improve multiple small performance issues.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `a606e5a5acbfaba0bcfa1227f6d6d475b77596b9b40d0b360bfbe09c0e9ce59699c09d3d57127a2d37c3aabad6d78227144d75c194cb29136854318eab1147ab`
- `sha1`: `17263912a7fabbd39dabcec4b1dd73f2749676a7`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 15
Reconstructed Java files: 15

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "com.cheter0410.blindspot.Blindspot"
  ],
  "client": [
    "com.cheter0410.blindspot.client.BlindspotClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/cheter0410/blindspot/Blindspot.java` | `` |  | onInitialize, id |
| top-level / `com/cheter0410/blindspot/client/BlindspotClient.java` | `` |  | onInitializeClient |
| top-level / `com/cheter0410/blindspot/client/cache/CacheVerification.java` | `` |  | hit, miss, logSummaryIfDue |
| top-level / `com/cheter0410/blindspot/client/cache/FriendsCache.java` | `` |  | FriendsCache |
| top-level / `com/cheter0410/blindspot/client/cache/ScoreboardCacheHolder.java` | `` |  |  |
| top-level / `com/cheter0410/blindspot/client/cache/SidebarCache.java` | `` |  | SidebarCache, isValidFor |
| top-level / `com/cheter0410/blindspot/client/cache/TabListCache.java` | `` |  | TabListCache, isValidFor |
| top-level / `com/cheter0410/blindspot/client/cache/TabListCacheHolder.java` | `` |  |  |
| top-level / `com/cheter0410/blindspot/client/cache/TabListVersion.java` | `` |  | get, increment |
| top-level / `com/cheter0410/blindspot/client/mixin/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | ModifyExpressionValue:2 | blindspot$tabListCache, blindspot$setTabListCache, blindspot$onListedChanged, blindspot$onListedRemoved |
| top-level / `com/cheter0410/blindspot/client/mixin/HudMixin.java` | `value={Hud.class})` | WrapOperation:2 | blindspot$useCachedScores, blindspot$captureScores, blindspot$vanillaEntries |
| top-level / `com/cheter0410/blindspot/client/mixin/PlayerInfoMixin.java` | `value={PlayerInfo.class})` | Inject:2 | blindspot$onSetGameMode, blindspot$onSetTabListOrder |
| top-level / `com/cheter0410/blindspot/client/mixin/PlayerSocialManagerMixin.java` | `value={PlayerSocialManager.class})` | WrapOperation:1 | blindspot$useCachedFriends |
| top-level / `com/cheter0410/blindspot/client/mixin/PlayerTabOverlayMixin.java` | `value={PlayerTabOverlay.class})` | WrapMethod:1 | blindspot$useCachedPlayerInfos |
| top-level / `com/cheter0410/blindspot/client/mixin/ScoreboardMixin.java` | `value={Scoreboard.class})` | Inject:8 | blindspot$scoresVersion, blindspot$teamsVersion, blindspot$sidebarCache, blindspot$setSidebarCache, blindspot$onGetOrCreateScore, blindspot$onScoreChanged, blindspot$onResetAllScores, blindspot$onResetSingleScore, blindspot$onRemoveObjective, blindspot$onAddPlayerToTeam, blindspot$onRemovePlayerFromTeam, blindspot$onRemovePlayerTeam |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
