# ServerAddressSpaceFix

Review status: **Evidence inventory; behavioral review pending**

Project: [ServerAddressSpaceFix](https://modrinth.com/mod/serveraddressspacefix)
Selected artifact version: `0.2.5`
Published implementation source: https://github.com/TheWhiteDog9487/ServerAddressSpaceFix
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Fix the "unknown host" bug when adding a server or connecting directly to a server with a space at the end of the server address

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `69a4d3bbb4d4a3fc60e3de1d19730dd19602e0172ffa03127c6aa05b2abadf650ec39ff0565d9e3db96d92751880d2bb68ee34ae16d6382f3d9b9b262d7b9652`
- `sha1`: `5e698a2c09fae7bbf4fc6c0ecb1b304c5f764c61`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 9
Reconstructed Java files: 9

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "xyz.thewhitedog9487.ServerAddressSpaceFixClient"
  ],
  "modmenu": [
    "xyz.thewhitedog9487.ModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "fabric-api": ">=0.144.0",
  "minecraft": "26.*",
  "java": ">=25"
}
```

**accessWidener**

```json
"serveraddressspacefix.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `xyz/thewhitedog9487/Event/ClientLifecycleEventsRegister.java` | `` |  | Register |
| top-level / `xyz/thewhitedog9487/mixin/client/DirectJoinServerScreenMixin.java` | `value={DirectJoinServerScreen.class})` | Inject:3 | onInit, onSelect, onRemoved, RemoveSpaceCharacter |
| top-level / `xyz/thewhitedog9487/mixin/client/ManageServerScreenMixin.java` | `value={ManageServerScreen.class})` | Redirect:1 | RedirectIpEditGetValue |
| top-level / `xyz/thewhitedog9487/mixin/client/ServerDataMixin.java` | `value={ServerData.class})` | Redirect:1 | RemoveSpace_Write |
| top-level / `xyz/thewhitedog9487/ModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `xyz/thewhitedog9487/RemoveInFuture.java` | `` |  | MigrateConfiguration |
| top-level / `xyz/thewhitedog9487/ServerAddressSpaceFix.java` | `` |  | onInitialize |
| top-level / `xyz/thewhitedog9487/ServerAddressSpaceFixClient.java` | `` |  | onInitializeClient |
| top-level / `xyz/thewhitedog9487/Settings.java` | `` |  | RegisterConfigFileReloadWatcher |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
