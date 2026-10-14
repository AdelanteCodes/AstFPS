# Fast Leaf Decay

Review status: **Evidence inventory; behavioral review pending**

Project: [Fast Leaf Decay](https://modrinth.com/mod/fast_leaf_decay)
Selected artifact version: `2.0.1+mod`
Published implementation source: https://github.com/las-r/fast-leaf-decay
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Makes leaves decay much faster in a minimal, no-setup fashion.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha512`: `9d5702882d4eec564a2307831e42e1c08f2db109ed91add1db89a628fda11065f2691ab4d33a72ee5f5c0747d02440cde072ff47f219dcd98350ce01609794b9`
- `sha1`: `0a1791fdf35858aaeb1d380e608a3c307d9e59ab`

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

Resource category counts: `function`: 1, `tags`: 1.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
