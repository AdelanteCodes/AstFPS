# Better Trialchamber Loot

Review status: **Evidence inventory; behavioral review pending**

Project: [Better Trialchamber Loot](https://modrinth.com/mod/better-trialchamber-loot)
Selected artifact version: `26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Improves Trial Chamber loot with better Vaults, Chests, Barrels and Pots while keeping rewards balanced and fun

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha512`: `4bc46f1f732fcce772e104ced5e3679e214be77fa9ae3a750020358b765dc5cbeb0d29b4d541e406a16ebef810a0adf8879255632bf83767f270d3c2e276ce9e`
- `sha1`: `a4893ae9ba66386d921be65704ec70b6a1e22aa0`

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

Resource category counts: `loot_table`: 7.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
