# VerSion

Review status: **Evidence inventory; behavioral review pending**

Project: [VerSion](https://modrinth.com/mod/version)
Selected artifact version: `1.1-Mod`
Published implementation source: https://github.com/SubBurban/VerSion
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Technical API pack providing the currently running version and pack format.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha512`: `c1d3174431953b30d1294e18e480972b954acc384590bf6f36c84745b1656feab9e740c771619e597559ae95e045cdfa6d08a65310aa787b2bf88dea91a940c7`
- `sha1`: `ea8ea96a7ece7da655ad4ef6805c9dd88539e058`

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

Resource category counts: `function`: 2, `tags`: 2.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
