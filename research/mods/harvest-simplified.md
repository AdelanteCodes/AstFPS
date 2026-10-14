# Harvest Simplified

Review status: **Evidence inventory; behavioral review pending**

Project: [Harvest Simplified](https://modrinth.com/mod/harvest-simplified)
Selected artifact version: `1.1+mod`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Auto Harvest and Auto Pickup: With Harvest Simplified, you can use your farm more efficiently and no longer need to collect items and replant crops! Customizable for all available crops.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha1`: `fd2888f7ec9a97b0c5e049ad5ace20ccb7d30ad7`
- `sha512`: `5abf058f88ee75cf17c203299477969bc1d319a32dd3e875d7945ebbad4db97307633fe44c96926cad4ae5a9c226c5ca50689f92731decb7650a5593132e0cdd`

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

Resource category counts: `dialog`: 3, `function`: 12, `tags`: 4.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
