# WhereWaterGo (Bigger Sponge)

Review status: **Evidence inventory; behavioral review pending**

Project: [WhereWaterGo (Bigger Sponge)](https://modrinth.com/mod/wwg)
Selected artifact version: `2.1.2-1.26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Better Sponge, change & configure the Range and Amount of Water

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `c937e4c1fdd81c364c6406837de68810fc7beda947085dde44d9d49c784a68cce4afaab242f605760a5bc0b05053a74cb263045e7445fba4a3238fe979e69b1c`
- `sha1`: `cfea8af1848c23ba2ec4423369f46e87b92069f9`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 5
Reconstructed Java files: 5

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "net.a5ho9999.WhereWaterGo"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/thighfigured-1.1.0.jar` | 81 | `thighfigured` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/a5ho9999/config/ModConfig.java` | `` |  |  |
| top-level / `net/a5ho9999/config/WhereWaterGoConfig.java` | `` |  | modId, registryModId, fileName, titleTranslationKey, titleFallback, accentColor, schema, clampValues, save, load, SuckRadius, SuckRadius, SuckAmount, SuckAmount |
| top-level / `net/a5ho9999/data/SpongeData.java` | `` |  | SpongeData |
| top-level / `net/a5ho9999/mixin/SpongeMixin.java` | `value={SpongeBlock.class})` | Overwrite:1 | removeWaterBreadthFirstSearch |
| top-level / `net/a5ho9999/WhereWaterGo.java` | `` |  | onInitialize, Log |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
