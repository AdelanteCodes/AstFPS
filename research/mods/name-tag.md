# Name Tag (Craft & Drops)

Review status: **Evidence inventory; behavioral review pending**

Project: [Name Tag (Craft & Drops)](https://modrinth.com/mod/name-tag)
Selected artifact version: `v2.2.0.0+mod`
Published implementation source: https://codeberg.org/jodeks-datapacks/Name-Tag
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Adds a crafting recipe + name tags drop from entities when killed

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha512`: `8ed966fa1c69379742ed21ac2b0607b6e28defb9ee48e5edbcba0464404794e316aff97f1d883e2d3054fac40efa7d879295d600a989b83ab1cba69893a206c9`
- `sha1`: `1dd37c6b0fd9327c462868075d623cc2f7f8ba8c`

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

Resource category counts: `advancement`: 2, `function`: 1, `recipe`: 1, `tags`: 1.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
