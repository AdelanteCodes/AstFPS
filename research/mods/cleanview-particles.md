# Clean View

Review status: **Evidence inventory; behavioral review pending**

Project: [Clean View](https://modrinth.com/mod/cleanview-particles)
Selected artifact version: `1.0.6-26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A clean view leads to clean plays

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `d8dc23abc0a56f61a07249e8a140e58abfcbf102b99cd5431cd5d10600daa3a9c140c509b0164048cf4145facbb51ca0d46e0a8845eff65fd56bb294e106e4ef`
- `sha1`: `72fc58e1dcb23ab9c9b90b4a5848c46e8fdc6a69`

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
    "net.nebula.cleanview.client.CleanView",
    "net.nebula.cleanview.ModMenuIntegration"
  ],
  "modmenu": [
    "net.nebula.cleanview.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/nebula/cleanview/CleanViewConfig.java` | `` |  | get, load, save |
| top-level / `net/nebula/cleanview/client/CleanView.java` | `` |  | isDisabled, onInitializeClient, registerCommands |
| top-level / `net/nebula/cleanview/mixin/HeldItemRendererMixin.java` | `value={FirstPersonHandsAndItemsRenderer.class})` | Inject:1 | cleanview$scaleHeldItem |
| top-level / `net/nebula/cleanview/mixin/ParticleManagerMixin.java` | `value={ParticleEngine.class})` | Inject:2 | cleanview$filterParticle, cleanview$isStatusEffectParticle, cleanview$modifyParticle |
| top-level / `net/nebula/cleanview/mixin/ParticleMixin.java` | `value={SingleQuadParticle.class})` | Inject:1 | cleanview$modifyParticleSize |
| top-level / `net/nebula/cleanview/mixin/ScreenEffectRendererMixin.java` | `value={ScreenEffectRenderer.class})` | ModifyArgs:1 | modifyTotemScaleArgs |
| top-level / `net/nebula/cleanview/ModMenuIntegration.java` | `` |  | onInitializeClient, getModConfigScreenFactory |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
