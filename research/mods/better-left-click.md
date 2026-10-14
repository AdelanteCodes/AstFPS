# Better Left Click

Review status: **Evidence inventory; behavioral review pending**

Project: [Better Left Click](https://modrinth.com/mod/better-left-click)
Selected artifact version: `1.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Allows you to use left click bind like normal but not lose out on the competitive and survival advantage of using a keyboard key.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `d9c91985858eeb20a2dd3333c5fb7e017bb96195`
- `sha512`: `fb9063937388f471248eee9dedefa93e9e6284bdd85b3b4340b185295f55e56156d983966ee36f38744a2da084f86bef205a1ff2eff52e94805fed86b50d9a24`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

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
    "com.betterleftclick.BetterLeftClick"
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
| top-level / `com/betterleftclick/BetterLeftClick.java` | `` |  | onInitialize, id |
| top-level / `com/betterleftclick/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | betterLeftClick$onTick |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
