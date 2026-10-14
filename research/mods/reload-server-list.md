# Reload Server List

Review status: **Evidence inventory; behavioral review pending**

Project: [Reload Server List](https://modrinth.com/mod/reload-server-list)
Selected artifact version: `2.0`
Published implementation source: https://github.com/LordEnder-Kitty/reload-server-list
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Ctrl+R reloads server selection screen

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `63da4501bebf89d546354a0cad814f824494f51d`
- `sha512`: `ae9a9a31b50c98b472d73fc9d913526d3cb7fdfd9994a1b917e20f0171de5fd550d52333dbe4fd6e834ed6dd8f302746a0f21abbd5f46dfe3dd896cdb38aa2ae`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 4
Reconstructed Java files: 4

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "net.enderkitty.fabric.ReloadServerListFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": "*",
  "minecraft": ">=26.3",
  "java": ">=25",
  "architectury": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `architectury_inject_reload_server_list_common_cc365a4d9ff04f2083ad8dcec2e4db4a_795fb21cd982805cfe7bb5e4f2603910fd42f0a7be70ebf5043a6768c5339f2breload_server_listcommon20devjar/PlatformMethods.java` | `` |  | getCurrentTarget |
| top-level / `net/enderkitty/fabric/ReloadServerListFabric.java` | `` |  | onInitializeClient |
| top-level / `net/enderkitty/mixin/MultiplayerScreenMixin.java` | `value={JoinMultiplayerScreen.class})` | Inject:2 | reloadKey, f5MakeNoise |
| top-level / `net/enderkitty/ReloadServerList.java` | `` |  | init |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
