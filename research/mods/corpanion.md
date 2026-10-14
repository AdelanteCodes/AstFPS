# Corpanion

Review status: **Evidence inventory; behavioral review pending**

Project: [Corpanion](https://modrinth.com/mod/corpanion)
Selected artifact version: `1.19.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Corpanion - The Companion Mod for the German Corpium Minecraft Server.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `ebbd5e6645dab42f34205ed7c0496640018bb9ad`
- `sha512`: `5eec7bf8856a0fed129cdaecad24da113635bc4614181e5c513b9b5280586ff13a77f66fa6763ac449a4e3d0fff60df0ed10455c393c8e7a42678d5a8121ac70`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 8
Reconstructed Java files: 8

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "net.aerulion.corpanion.Corpanion"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": ">=0.162.0+26.3",
  "minecraft": "26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/aerulion/corpanion/Corpanion.java` | `` |  | getMetadata, onInitializeClient |
| top-level / `net/aerulion/corpanion/keybinding/CommandKeyBinding.java` | `` |  |  |
| top-level / `net/aerulion/corpanion/keybinding/CorpanionKeyBinding.java` | `` |  | register |
| top-level / `net/aerulion/corpanion/keybinding/KeyBindingService.java` | `` |  | initialize |
| top-level / `net/aerulion/corpanion/mixin/GuiGraphicsExtractorMixin.java` | `value={GuiGraphicsExtractor.class})` | Inject:1 | calculateOffset, renderRarityIcon |
| top-level / `net/aerulion/corpanion/service/CorpanionService.java` | `` |  |  |
| top-level / `net/aerulion/corpanion/service/CorpanionServiceProvider.java` | `` |  |  |
| top-level / `net/aerulion/corpanion/util/ItemRarity.java` | `` |  | of, getRarityIcon |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
