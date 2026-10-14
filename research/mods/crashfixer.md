# CrashFixer

Review status: **Evidence inventory; behavioral review pending**

Project: [CrashFixer](https://modrinth.com/mod/crashfixer)
Selected artifact version: `3.1.1+26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A simple mod that fixes a few crash exploits in the game

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `7f01a4e475773b6e40f6546c02c1a4a70dee899e`
- `sha512`: `c0639c5bb6ed61a7c95556ab211ffccef76a685879ca08a92028c78bfc2a52d52d3bf9e90804d1f385c209934ca8473b731bedb8f90bfca50c11001fc9a37a25`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 19
Reconstructed Java files: 15

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "modmenu": [
    "cc.modlabs.crashfixer.config.CrashFixerModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "26.3",
  "java": ">=25",
  "yet_another_config_lib_v3": ">=3.9.7+26.3-fabric",
  "fabric-api": ">=0.161.0+26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `cc/modlabs/crashfixer/config/CrashFixerConfig.java` | `` |  | handler, get, defaults, save |
| top-level / `cc/modlabs/crashfixer/config/CrashFixerConfigScreen.java` | `` |  | create, booleanOption, integerSliderOption, integerFieldOption |
| top-level / `cc/modlabs/crashfixer/config/CrashFixerModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `cc/modlabs/crashfixer/Constants.java` | `` |  |  |
| top-level / `cc/modlabs/crashfixer/CrashFixerCall.java` | `` |  |  |
| top-level / `cc/modlabs/crashfixer/DisplayTextSanitizer.java` | `` |  | shouldSimplify, simplifiedText, clampLineWidth, analyze, estimateDirectChars, estimateStyleScore |
| top-level / `cc/modlabs/crashfixer/EntityNameSanitizer.java` | `` |  | shouldSimplify, simplify, analyze, estimateDirectChars, estimateStyleScore |
| top-level / `cc/modlabs/crashfixer/mixin/AreaEffectCloudEntityMixin.java` | `value={AreaEffectCloud.class})` | Redirect:1 | crashfixer$replaceElderGuardianParticle |
| top-level / `cc/modlabs/crashfixer/mixin/ClientPacketListenerMixin.java` | `value={ClientPacketListener.class})` | Inject:4, ModifyVariable:1 | crashfixer$maxParticlesPerPacket, crashfixer$maxClientEntities, crashfixer$maxClientEntityScore, crashfixer$maxEntityAddScorePerWindow, crashfixer$maxSameEntityPerWindow, crashfixer$maxSensitiveEntityPerWindow, crashfixer$maxDisplayEntityPerWindow, crashfixer$maxSameEntityLoaded, crashfixer$maxSensitiveEntityLoaded, crashfixer$maxDisplayEntityLoaded, crashfixer$entityWindowNanos, crashfixer$logWindowNanos, crashfixer$prune, crashfixer$pruneRecentEntityAddScores, crashfixer$isSensitiveEntity, crashfixer$isDisplayEntity, crashfixer$getEntityCost, crashfixer$getMaxPerWindowForType, crashfixer$getMaxLoadedForType, crashfixer$shouldLog, crashfixer$emitOverflowMarker, crashfixer$incrementTrackedCount, crashfixer$decrementTrackedCount, crashfixer$clearTrackedEntities, crashfixer$forgetRemovedEntities, crashfixer$throttleEntityAdds, crashfixer$trackAddedEntity, crashfixer$clampParticlePacket |
| top-level / `cc/modlabs/crashfixer/mixin/DrawableGizmoPrimitivesGroupMixin.java` | `value={DrawableGizmoPrimitives.class})` | Inject:1 | crashfixer$guardGizmoLineRendering |
| top-level / `cc/modlabs/crashfixer/mixin/EntityMixin.java` | `value={Entity.class})` | Inject:1 | crashfixer$simplifyLaggyName |
| top-level / `cc/modlabs/crashfixer/mixin/ParticleManagerMixin.java` | `value={ParticleEngine.class})` | Inject:2 | crashfixer$maxParticlesPerTick, crashfixer$resetCounter, crashfixer$throttleParticles_obj |
| top-level / `cc/modlabs/crashfixer/mixin/SoundSystemMixin.java` | `value={SoundEngine.class})` | Inject:2 | prune, crashfixer$soundCleanupThreshold, crashfixer$soundWindowNanos, crashfixer$maxPlaysPerWindow, crashfixer$maxSameSoundPerWindow, crashfixer$maxSoundsPerTick, crashfixer$maxBlockSoundsPerTick, crashfixer$resetSoundCounters, crashfixer$throttleSoundPlays |
| top-level / `cc/modlabs/crashfixer/mixin/TextDisplayMixin.java` | `value={Display.TextDisplay.class})` | Inject:1 | crashfixer$sanitizeDisplayCache |
| top-level / `cc/modlabs/crashfixer/mixin/TranslatableTextContentMixin.java` | `value={TranslatableContents.class})` | Inject:2, Redirect:2 | crashfixer$guarded, crashfixer$guardPayload, crashfixer$guardStyledPayload, crashfixer$redirectVisit, crashfixer$redirectStyledVisit, crashfixer$payloadGuardEnabled, crashfixer$isPayloadSafe, crashfixer$template, crashfixer$estimateArgumentChars, crashfixer$estimateComponentChars, crashfixer$estimateDirectComponentChars, crashfixer$logPayloadBlocked |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
