# Crafting Refinements: Blast Buff

Review status: **Evidence inventory; behavioral review pending**

Project: [Crafting Refinements: Blast Buff](https://modrinth.com/mod/crafting-refinements-blast-buff)
Selected artifact version: `5.0+mod`
Published implementation source: https://github.com/Fire-Horse27/dp-crafting-refinements
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Raw blocks and sand can now be processed in the blast furnace!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha512`: `07ae35c8a42cbd099ac2ec34788bf2632020acd71bd59e3992b4797deaab49de1b0002651a607a605d592a9523907a4ad6be59a166beed479c82c7b0d363f060`
- `sha1`: `149c2d1496ccb2071b82f1b279c8bdca91882122`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 0
Reconstructed Java files: Not available

**environment**

```json
"*"
```

**depends**

```json
{
  "fabric-resource-loader-v0": "*"
}
```

## Data-driven behavior

Resource category counts: `advancement`: 4, `recipe`: 4.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
