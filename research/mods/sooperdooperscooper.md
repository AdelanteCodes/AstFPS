# SooperDooperScooper

Review status: **Evidence inventory; behavioral review pending**

Project: [SooperDooperScooper](https://modrinth.com/mod/sooperdooperscooper)
Selected artifact version: `1.4.1+26.3`
Published implementation source: https://github.com/fingerguns83/sooperdooperscooper
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Take the brains and put them somewhere else

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `98e777824aa1959ef000c1aebb72738f615cfd19`
- `sha512`: `18493bb3122cbbb79087fad4493145e5b291329a3dd8207baf5dfa670322f326007dd0d504c5787cc0aad5f7623b394baa4bc77df7cd0e25f2b777b225467135`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 9
Reconstructed Java files: 8

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "net.fg83.sdsfabric.SDS"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3"
}
```

**accessWidener**

```json
"sdsfabric.accesswidener"
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/fabric-permissions-api-0.7.0.jar` | 7 | `fabric-permissions-api-v0` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/fg83/sdsfabric/mixin/VillagerEntityMixin.java` | `value={Villager.class})` | Inject:1 | afterUsing |
| top-level / `net/fg83/sdsfabric/SDS.java` | `` |  | onInitialize |
| top-level / `net/fg83/sdsfabric/service/ConfigManager.java` | `` |  | getConfig, loadConfig, saveConfig |
| top-level / `net/fg83/sdsfabric/service/Lobotomizer.java` | `` |  | lobotomize, buildPermissionNode, testPermissionNode, getTagType, playerHandler, mobHandler, piglinHandler, removeAI, restoreAI |
| top-level / `net/fg83/sdsfabric/service/PiglinManager.java` | `` |  | tick |
| top-level / `net/fg83/sdsfabric/service/VillagerManager.java` | `` |  | calculateRestockInterval, tick |
| top-level / `net/fg83/sdsfabric/util/PlayerMessage.java` | `` |  | send |
| top-level / `net/fg83/sdsfabric/util/SDSConfig.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
