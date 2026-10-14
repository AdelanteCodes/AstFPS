# Smart Particles

Review status: **Evidence inventory; behavioral review pending**

Project: [Smart Particles](https://modrinth.com/mod/smart-particles)
Selected artifact version: `1.16.0`
Published implementation source: https://github.com/chedidandrew/Smart_Particles
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A performance mod that greatly optimizes particle rendering and particle limits.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `f8e4ddad9aa14339a15a9c6d70819d5045220fe56a2d03d87fd3eb3b4d312df93e24b99d892aacdc175f16de15a1024f87066478ad06d819792494f46b204594`
- `sha1`: `10d188cd467cde01449579496bfd798b613f0e05`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

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
    "sp.SPMod"
  ],
  "modmenu": [
    "sp.SPModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `sp/mixin/GameRendererAccessor.java` | `value={GameRenderer.class})` | Accessor:1 |  |
| top-level / `sp/mixin/ParticleGroupAccessor.java` | `value={ParticleGroup.class})` | Accessor:1 |  |
| top-level / `sp/mixin/ParticleManagerMixin.java` | `value={ParticleEngine.class})` | Inject:1 | smartparticles$enforceParticleLimit, smartparticles$countParticles, smartparticles$clearAllParticles, smartparticles$cullOutsideCamera, smartparticles$selectBestParticles, smartparticles$getParticles, smartparticles$isInsideCameraCone, smartparticles$ensureBufferCapacity, smartparticles$releaseOversizedBuffers, smartparticles$decrementGroupCount, smartparticles$heapSiftUp, smartparticles$heapSiftDown, smartparticles$swap |
| top-level / `sp/mixin/SPAccessor.java` | `value={Particle.class})` | Accessor:3 |  |
| top-level / `sp/SPConfig.java` | `` |  | get, load, save, clampParticleLimit |
| top-level / `sp/SPConfigScreen.java` | `` |  | init, saveSettings, openLink, onClose, extractRenderState |
| top-level / `sp/SPMod.java` | `` |  | onInitializeClient |
| top-level / `sp/SPModMenuIntegration.java` | `` |  | getModConfigScreenFactory |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
