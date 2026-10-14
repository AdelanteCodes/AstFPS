# Bring Blocking Back

Review status: **Evidence inventory; behavioral review pending**

Project: [Bring Blocking Back](https://modrinth.com/mod/bring-blocking-back)
Selected artifact version: `2.3.0-26.3`
Published implementation source: https://github.com/FelpisLipe/BringBlockingBack
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A small mod reintroducing 1.7's sword blocking animation.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `e497d1b5dc5f79e5bc529c9c2ce786efda83b5a7342b8297d74771195c2a68ae8ee9a4411e07632d354d95a2c326cd7dea71c20f5446a01b71817bc539eb68d1`
- `sha1`: `ca65b3f7e25134ed141ab07c6332648ca86f2dbf`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 10
Reconstructed Java files: 10

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "com.felpslipe.bbb.BringBlockingBack"
  ],
  "modmenu": [
    "com.felpslipe.bbb.integration.BBBModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/felpslipe/bbb/BringBlockingBack.java` | `` |  | onInitializeClient |
| top-level / `com/felpslipe/bbb/config/BBBConfigScreen.java` | `` |  | init |
| top-level / `com/felpslipe/bbb/config/Config.java` | `` |  |  |
| top-level / `com/felpslipe/bbb/config/ConfigHelper.java` | `` |  | canBlock |
| top-level / `com/felpslipe/bbb/config/ConfigManager.java` | `` |  | load |
| top-level / `com/felpslipe/bbb/integration/BBBModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/felpslipe/bbb/misc/Utils.java` | `` |  | firstPersonSwordBlock, swordBlockThirdPerson, getSkyBlockId |
| top-level / `com/felpslipe/bbb/mixin/FirstPersonHandsAndItemsRendererMixin.java` | `value={FirstPersonHandsAndItemsRenderer.class})` | Inject:1, Redirect:1 | renderItem, submitArmWithItem |
| top-level / `com/felpslipe/bbb/mixin/ItemInHandLayerMixin.java` | `value={ItemInHandLayer.class})` | Inject:1 | submitArmWithItem |
| top-level / `com/felpslipe/bbb/mixin/PlayerModelMixin.java` | `value={PlayerModel.class})` | Inject:1 | setupAnim |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
