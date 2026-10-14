# Chunky Offline

Review status: **Evidence inventory; behavioral review pending**

Project: [Chunky Offline](https://modrinth.com/mod/chunky-offline)
Selected artifact version: `v1.1.0+mod`
Published implementation source: https://github.com/lullaby6/ChunkyOffline
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

An add-on/extension of Chunky to generate chunks when no players are online.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha512`: `12506295bba4909b8882b8e4b8802cadb648877be1ba8dfe3f7d8f9a7dbe5cbc6ff712be7d5a3f3b54cdc4190df1be005ae8bb53ae202b40173064810ffb536e`
- `sha1`: `5783f3ec055a3e5f369cfd169d62c2c2f4da44d4`

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

Resource category counts: `function`: 14, `tags`: 2.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
