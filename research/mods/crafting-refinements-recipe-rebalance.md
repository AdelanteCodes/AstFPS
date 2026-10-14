# Crafting Refinements: Recipe Rebalance

Review status: **Evidence inventory; behavioral review pending**

Project: [Crafting Refinements: Recipe Rebalance](https://modrinth.com/mod/crafting-refinements-recipe-rebalance)
Selected artifact version: `5.0+mod`
Published implementation source: https://github.com/Fire-Horse27/dp-crafting-refinements
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Changes some recipes to allow unpacking, makes others cheaper, and overall makes recipes more consistent

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha512`: `65661b672bf9caf76950311ea62041d8de263539bd8eda157071388ac7036ffbfa0d76784abc8da7d749b37470de02750426f9c01748bbf532e652521b9a23c1`
- `sha1`: `3aadb66b5a008602e11c76211587dd51a8772538`

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

Resource category counts: `advancement`: 6, `recipe`: 12.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
