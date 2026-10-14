# Skeleton AI Fix

Review status: **Evidence inventory; behavioral review pending**

Project: [Skeleton AI Fix](https://modrinth.com/mod/skeleton-ai-fix)
Selected artifact version: `26.3.0`
Published implementation source: https://github.com/Fuzss/skeletonaifix
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Eliminates awkward strafing – Skeletons now stay focused and shoot faster the closer you get.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `fe9a4469a9062446a2ff0b79822ac61834448a69`
- `sha512`: `43156ea889cfd8fd707994269bfcf3dc4038d6ce57e8cc9e41482a4c45d16477f0803aeca1cbfe429cdd78080a74a9b9aa82a5499a82e148784526c7494363d6`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 7
Reconstructed Java files: 7

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "fuzs.skeletonaifix.fabric.client.SkeletonAIFixFabricClient"
  ],
  "main": [
    "fuzs.skeletonaifix.fabric.SkeletonAIFixFabric"
  ]
}
```

**depends**

```json
{
  "minecraft": "~26.3-",
  "fabricloader": ">=0.19.5",
  "fabric-api": ">=0.160.6",
  "forgeconfigapiport": "*",
  "puzzleslib": ">=26.3.4"
}
```

**accessWidener**

```json
"skeletonaifix.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `fuzs/skeletonaifix/common/client/SkeletonAIFixClient.java` | `` |  |  |
| top-level / `fuzs/skeletonaifix/common/config/ServerConfig.java` | `` |  |  |
| top-level / `fuzs/skeletonaifix/common/data/tags/ModEntityTypeTagProvider.java` | `` |  | addTags |
| top-level / `fuzs/skeletonaifix/common/init/ModRegistry.java` | `` |  | bootstrap |
| top-level / `fuzs/skeletonaifix/common/SkeletonAIFix.java` | `` |  | onConstructMod, registerEventHandlers, onEndEntityTick, getAttackInterval, getMinAttackInterval, easeOutQuad, id |
| top-level / `fuzs/skeletonaifix/fabric/client/SkeletonAIFixFabricClient.java` | `` |  | onInitializeClient |
| top-level / `fuzs/skeletonaifix/fabric/SkeletonAIFixFabric.java` | `` |  | onInitialize |

## Data-driven behavior

Resource category counts: `tags`: 1.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
