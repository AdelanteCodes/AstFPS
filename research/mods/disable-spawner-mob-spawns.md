# Disable Spawner Mob Spawns

Review status: **Evidence inventory; behavioral review pending**

Project: [Disable Spawner Mob Spawns](https://modrinth.com/mod/disable-spawner-mob-spawns)
Selected artifact version: `1+mod`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Disables spawner mob spawning with new gamerule

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha1`: `4a02b66088f5cae7df57aa678e86e121c94dc8ef`
- `sha512`: `15daa9da98a0e483756dde678e56f4c6ec7270775c830656279fef1c9f1eef20b8ec9c6ba070c420a96279215e8c1152b3e8d2e8038b4c4dcf35eacb66ac15d1`

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

Resource category counts: `advancement`: 2, `functions`: 1, `tags`: 1.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
