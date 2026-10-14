# Crafting Refinements: Six Stairs

Review status: **Evidence inventory; behavioral review pending**

Project: [Crafting Refinements: Six Stairs](https://modrinth.com/mod/crafting-refinements-six-stairs)
Selected artifact version: `5.0+mod`
Published implementation source: https://github.com/Fire-Horse27/dp-crafting-refinements
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

All stair crafting recipes output six stairs now, including concrete stairs, wool stairs, copper stairs, resin stairs, all wood types and the many types of stone stairs.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha512`: `d7402331057d259cc4cf9e65d7d655f3ab5850b289ce03c071a725626e18118e952dc6196b4ef319acc8f1a757be3fbd3dbcbc7a300241ab3e484c4372de3db3`
- `sha1`: `8bc6c64c55768cbd1f3357216cce3838834de00d`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

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

Resource category counts: `recipe`: 97.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
