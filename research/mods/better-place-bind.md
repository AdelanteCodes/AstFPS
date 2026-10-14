# Better Place Bind

Review status: **Evidence inventory; behavioral review pending**

Project: [Better Place Bind](https://modrinth.com/mod/better-place-bind)
Selected artifact version: `1.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Allows you to use right click for place bind like normal but not lose out on the competitive advantage of using a keyboard key.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `70267f45c4f503baa20568bce07fc080e583890ab6c3d63bb6ef8eaba7cea1f64708b670603657c9888a6e5ae42ca9b3e11e98a39c7da32aa40a3ea137ca4a57`
- `sha1`: `c602a3e9295474191b666b1fc5d27ed0a847186c`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 2
Reconstructed Java files: 2

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.betterplacebind.BetterPlaceBind"
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
| top-level / `com/betterplacebind/BetterPlaceBind.java` | `` |  | onInitialize, id |
| top-level / `com/betterplacebind/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | betterPlaceBind$onTick |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
