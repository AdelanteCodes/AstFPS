# Black Bar Concealer

Review status: **Evidence inventory; behavioral review pending**

Project: [Black Bar Concealer](https://modrinth.com/mod/black-bar-concealer)
Selected artifact version: `1.0.10`
Published implementation source: https://github.com/Gerrygames/BlackBarConcealer
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Conceals black bars of slim skins used on the wide model.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `6d6b31869d362360b459074de1a27810d35a3f4b`
- `sha512`: `a9388ef1f60ddb4434670b03d929a696af07ff57282c3a6818ba982553f4a3db415501d9e6456c3803f868b56fb759b6fa8b12cb9b9d0af4707870fe033495f4`

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
"client"
```

**entrypoints**

```json
{
  "main": [
    "de.gerrygames.blackbarconcealer.BlackBarConcealer"
  ],
  "modmenu": [
    "de.gerrygames.blackbarconcealer.config.BBCModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*",
  "cloth-config": ">=26.2.158",
  "modmenu": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `de/gerrygames/blackbarconcealer/BlackBarConcealer.java` | `` |  | onInitialize |
| top-level / `de/gerrygames/blackbarconcealer/config/BBCConfig.java` | `` |  | toggle, enabled, fillPixels, preferWideModel, withEnabled, withFillPixels, withPreferWideModel |
| top-level / `de/gerrygames/blackbarconcealer/config/BBCModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `de/gerrygames/blackbarconcealer/mixin/MixinPlayerSkin.java` | `value={PlayerSkin.class})` | Inject:2 | onGetBodyTexture, onGetModel, hasThiccArms |
| top-level / `de/gerrygames/blackbarconcealer/mixin/MixinSkinTextureDownloader.java` | `value={SkinTextureDownloader.class})` | Inject:1 | registerTextureInManager, hasThiccArms, convertAlexToSteve |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
