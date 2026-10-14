# Lobotomy Inc.

Review status: **Evidence inventory; behavioral review pending**

Project: [Lobotomy Inc.](https://modrinth.com/mod/lobotomy-inc.)
Selected artifact version: `1.5.0+26.3`
Published implementation source: https://github.com/Tobzi-Dev/lobotomyinc
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Lobotomise and optimise your villagers with nametags. You can configure names in config

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `f75a0b4ede2f91e8d6a447ed83affa804fb91e71`
- `sha512`: `933871a1481bac1c433d6bcba2c4de6396be19b018a3b4c83e4bb554a391388d4b36d0660fbc914edb0f5dc5e2512951b40d0b16b82a7a07950213662cbf1af9`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 10
Reconstructed Java files: 8

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.tobzi.lobotomyinc.LobotomyInc"
  ],
  "modmenu": [
    "com.tobzi.lobotomyinc.client.ModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.5",
  "minecraft": ">=26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/tobzi/lobotomyinc/client/ConfigScreen.java` | `` |  | create, toggle, stringList, clean |
| top-level / `com/tobzi/lobotomyinc/client/ModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/tobzi/lobotomyinc/command/LobotomyCommand.java` | `` |  | register |
| top-level / `com/tobzi/lobotomyinc/config/ModConfig.java` | `` |  | isLobotomizedName, load, loadFromData, save, sanitizeList |
| top-level / `com/tobzi/lobotomyinc/LobotomyInc.java` | `` |  | onInitialize |
| top-level / `com/tobzi/lobotomyinc/mixin/BrainMixin.java` | `value={Brain.class})` | Inject:1 | onTick |
| top-level / `com/tobzi/lobotomyinc/mixin/NameTagItemMixin.java` | `value={NameTagItem.class})` | Inject:1 | preventConsumption |
| top-level / `com/tobzi/lobotomyinc/mixin/VillagerEntityMixin.java` | `value={Villager.class})` | Inject:1 | onTick |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
