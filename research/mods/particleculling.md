# Particle Culling

Review status: **Evidence inventory; behavioral review pending**

Project: [Particle Culling](https://modrinth.com/mod/particleculling)
Selected artifact version: `1.0.0+mc26.3`
Published implementation source: https://github.com/Fix85/ParticleCulling
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Block individual particle types via Mod Menu to boost game FPS. / Блокируйте отдельные типы частиц через Mod Menu для повышения FPS.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `dfad5c380f88712848cba73ff00be71257dc976eda64936d5f36d471c9591944f4387539f9665127bb111951b1a57feb5693eccf0e86892ea47c7678d39d289b`
- `sha1`: `e7865bd0e708a4c2e6122050642c12cf4085926b`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 4
Reconstructed Java files: 4

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "dev.fix85.particleculling.ParticleCulling"
  ],
  "modmenu": [
    "dev.fix85.particleculling.ParticleCullingModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.2",
  "minecraft": "26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/cloth-config-fabric-26.3.159.jar` | 625 | `cloth-config` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/fix85/particleculling/Config.java` | `` |  | get, getFilePath, load, save, isParticleBlocked, setParticleBlocked |
| top-level / `dev/fix85/particleculling/mixin/ParticleEngineMixin.java` | `value={ParticleEngine.class})` | Inject:1 | onCreateParticle |
| top-level / `dev/fix85/particleculling/ParticleCulling.java` | `` |  | onInitializeClient |
| top-level / `dev/fix85/particleculling/ParticleCullingModMenu.java` | `` |  | getModConfigScreenFactory |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
