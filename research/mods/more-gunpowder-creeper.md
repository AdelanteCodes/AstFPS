# more gunpowder (creeper)

Review status: **Evidence inventory; behavioral review pending**

Project: [more gunpowder (creeper)](https://modrinth.com/mod/more-gunpowder-creeper)
Selected artifact version: `26.3+mod`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A simple vanilla datapack that increases Creeper Gunpowder drops. Perfect for players who want more Gunpowder without changing other gameplay mechanics.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha1`: `da42128e4c38e3226b866b6d0b74edb45a839fff`
- `sha512`: `abd118a1e3a1793a5fec0050e001690f532387c92e0640820f71805aceca64b7ec511a3a9ffb458f2d789530af65d1251e4b0213907c496953bea2b6c52f2e29`

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

Resource category counts: `loot_table`: 1.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
