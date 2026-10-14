# Crafting Refinements

Review status: **Evidence inventory; behavioral review pending**

Project: [Crafting Refinements](https://modrinth.com/mod/crafting-refinements)
Selected artifact version: `5.0+mod`
Published implementation source: https://github.com/Fire-Horse27/Crafting-Refinements
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Refines and adds various crafting, blasting, brewing, and stonecutting recipes to provide a balanced, convenient, and consistent crafting experience

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha1`: `b7e9d340b7b294a135cccf41be651b94b5d1e8eb`
- `sha512`: `a70a37614e3a69f907c23285451ae23a4df58d7a4a41b78017e774213505e8fc9e4ba8a2d2caca2783413ee5926b179681f5f1be69d37b8b295d9ceeb9f8f5d5`

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

Resource category counts: `advancement`: 262, `recipe`: 441, `tags`: 11.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
