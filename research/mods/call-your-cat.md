# Call Your Cat

Review status: **Evidence inventory; behavioral review pending**

Project: [Call Your Cat](https://modrinth.com/mod/call-your-cat)
Selected artifact version: `v2.2.0.0+mod`
Published implementation source: https://codeberg.org/jodeks-datapacks/Call-Your-Cat
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Easily call (whistle) your cat with a goat horn to teleport it to you

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha1`: `d9b64268c870290b0d16de640277a1619faaa6f9`
- `sha512`: `6aac45f434110e47bd66fb91ad9ebe9a8da025dbaf08be3eb4c7c2ee5a278524facf8eb46a5811bd7a22ae23b1f0728c8a5153cd6aed62abd621a0b532454155`

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

Resource category counts: `advancement`: 2, `function`: 25, `predicate`: 1, `tags`: 2.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
