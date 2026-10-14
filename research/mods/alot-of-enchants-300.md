# Alot Of Enchants -- 300+

Review status: **Evidence inventory; behavioral review pending**

Project: [Alot Of Enchants -- 300+](https://modrinth.com/mod/alot-of-enchants-300)
Selected artifact version: `1+mod`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This project adds 300 new UNIQUE enchants!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha1`: `b7f97c6967c0ebe4dbbf914a45d62c985c0071d8`
- `sha512`: `2a576403b34e3d62bd20f22f3343e7175376117ac49b7a504580c7eda33f1bca31e9ac1c471042e5bb27de09181cf088fa83003380f91829a3ee4f471c9bdfe8`

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

Resource category counts: `enchantment`: 386, `function`: 35, `item_modifier`: 1, `predicate`: 11, `tags`: 17.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
