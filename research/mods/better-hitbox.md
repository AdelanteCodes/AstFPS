# Better Hitbox

Review status: **Evidence inventory; behavioral review pending**

Project: [Better Hitbox](https://modrinth.com/mod/better-hitbox)
Selected artifact version: `1.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Hitbox Enchanced by Mayank (afkz studios)

  Colored hitboxes for combat training and PvP

  Hitbox Enchanced replaces Minecraft's vanilla F3+B hitboxes with fully customizable, color-coded hitboxes to help you
  visualize entity hitboxes during combat.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `21a89bdf63f35c14a25b160f4ae6935f0eda814a`
- `sha512`: `89002943ba34fb39afd59abf4684689eb665526d0951ff6f418cbd49febf14efbb8b032b7e597fbfc666acc8fed2e2283b5e80da9d8da08e36ac14336fecadc6`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 7
Reconstructed Java files: 7

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.afkzstudios.hitboxplus.Main"
  ],
  "modmenu": [
    "com.afkzstudios.hitboxplus.ModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16.13",
  "minecraft": "26.3",
  "java": ">=17",
  "cloth-config": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/afkzstudios/hitboxplus/Config.java` | `` |  |  |
| top-level / `com/afkzstudios/hitboxplus/ConfigScreen.java` | `` |  | create |
| top-level / `com/afkzstudios/hitboxplus/Main.java` | `` |  | onInitializeClient |
| top-level / `com/afkzstudios/hitboxplus/mixin/DebugRenderMixin.java` | `value={DebugRenderer.class})` |  |  |
| top-level / `com/afkzstudios/hitboxplus/mixin/HitBoxRenderMixin.java` | `value={EntityHitboxDebugRenderer.class})` | Inject:1 | onDrawHitbox |
| top-level / `com/afkzstudios/hitboxplus/ModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/afkzstudios/hitboxplus/PresetColor.java` | `` |  | getColor, getArgb |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
