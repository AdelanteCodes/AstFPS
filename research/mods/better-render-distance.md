# Better Render Distance

Review status: **Evidence inventory; behavioral review pending**

Project: [Better Render Distance](https://modrinth.com/mod/better-render-distance)
Selected artifact version: `1.2.2`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Improves render distance by making it perfectly spherical, culling diagonal chunk sections and entities for better performance.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `05317aa91f04e7b89f245d94024b6e5a490beb11d70eb59532011e6fbbf44033b2c4e1f279b6511676f6908c9541f23a994acfb8225e8489e735e69de74219e5`
- `sha1`: `d02535e3ad5d1df5a6019dbc4aaf97ada723ef76`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 15
Reconstructed Java files: 11

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.warma.betterrenderdistance.BetterRenderDistanceClient"
  ],
  "sodium:config_api_user": [
    "com.warma.betterrenderdistance.compat.sodium.BetterRenderDistanceSodiumConfigEntryPoint"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.1",
  "fabric-lifecycle-events-v1": "*",
  "minecraft": ">=26.3 <26.4",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/warma/betterrenderdistance/BetterRenderDistanceClient.java` | `` |  | onInitializeClient |
| top-level / `com/warma/betterrenderdistance/BRDCullMath.java` | `` |  | isBoxNearestHorizontalWithin, camera, updateRadii, nearestOnRange, nearestToZero |
| top-level / `com/warma/betterrenderdistance/ClientHooks.java` | `` |  | onConfigApplied |
| top-level / `com/warma/betterrenderdistance/compat/distanthorizons/BRDDistantHorizonsCompat.java` | `` |  | init, verifyApiContract, requireMethod, scheduleSetup, finishSetup, registerChangeListener, requireFloat, update, clearTrackedValue, fail, shadersEnabled, calculateRadius, radiusLimit, afterDistantHorizonsInit |
| top-level / `com/warma/betterrenderdistance/compat/sodium/BetterRenderDistanceSodiumConfigEntryPoint.java` | `` |  | key, registerConfigEarly, registerConfigLate |
| top-level / `com/warma/betterrenderdistance/config/BRDConfig.java` | `` |  | load, save, computeAutoVerticalScale, piecewise4, lerp, registerTick |
| top-level / `com/warma/betterrenderdistance/mixin/BetterRenderDistanceMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply, brd$injectionTarget, brd$findMethod, brd$readClass, brd$hasClassResource |
| top-level / `com/warma/betterrenderdistance/mixin/EntityRenderDispatcherCullMixin.java` | `value={EntityRenderDispatcher.class})` | Inject:1 | updateCacheIfNeeded, betterrenderdistance$cullEntitiesEllipsoid, nearestToZero |
| top-level / `com/warma/betterrenderdistance/mixin/LevelExtractorCullMixin.java` | `value={LevelExtractor.class})` | Inject:1 | brd$filterVisibleSections, brd$updateRadii, brd$nearestToZero, brd$filterInPlaceEllipsoidCenter |
| top-level / `com/warma/betterrenderdistance/mixin/physics/PhysicsOceanRendererCullMixin.java` | `targets={"net.diebuddies.render.OceanRenderer"}, remap=false)` | Inject:1 | betterrenderdistance$cullOceanMesh, brd$initMesh, brd$findAabbFieldByShape, brd$looksLikeAabb, brd$initAabb, brd$getMin, brd$getMax, brd$coord, brd$initVector, brd$findField, brd$findMethod |
| top-level / `com/warma/betterrenderdistance/mixin/sodium/SodiumOcclusionCullerMixin.java` | `value={OcclusionCuller.class}, remap=false)` | Inject:1, Redirect:1 | betterrenderdistance$beginFrame, betterrenderdistance$cullRegular, betterrenderdistance$testDistance, betterrenderdistance$vanillaDistance, betterrenderdistance$nearestToZero |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
