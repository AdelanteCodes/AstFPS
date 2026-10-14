# Craftable Cobwebs

Review status: **Evidence inventory; behavioral review pending**

Project: [Craftable Cobwebs](https://modrinth.com/mod/craftablecobwebs)
Selected artifact version: `1.0.1-1.21.9-26.3+mod`
Published implementation source: https://github.com/theplayerYT/Craftable-Cobwebs
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

a datapack that adds a generous cobweb crafting recipe

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha512`: `b6b5775526ca5511d38346e8207edf80c781710d3eb60120069c12b1724a4ca560efb18e58614a9660774ff9311e724bd4a2d44d4a929d15db902aacabacbf0c`
- `sha1`: `890566ed744a55bd8e3bafc711fffffba9a24882`

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

Resource category counts: `recipe`: 1.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
