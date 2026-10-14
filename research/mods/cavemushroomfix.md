# Cave Mushroom Fix

Review status: **Evidence inventory; behavioral review pending**

Project: [Cave Mushroom Fix](https://modrinth.com/mod/cavemushroomfix)
Selected artifact version: `1.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This mod restores mushroom spawning in caves. Mushrooms will now spawn in caves as they did before version 1.18. This fixes MC-244162.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `b71f58ec274fc8450578ab801784a3ceced104078c3f1086acdc4042a24ef6dedfea81229cbc69f3cb003328bb65d87058fb58eda950f03613ba68f95772a99e`
- `sha1`: `111fa55ee589bcc11ef824fb3e2b14b751b87979`

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

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `levsidorovi/cavemushroomfix/cavemushroomfixmod/CaveMushroomFeature.java` | `` |  | codec, place |
| top-level / `levsidorovi/cavemushroomfix/cavemushroomfixmod/CaveMushroomFix.java` | `` |  | registerFeatureType, onInitialize |

## Data-driven behavior

Resource category counts: `worldgen`: 4.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
