# Dimension tracker + Afk display

Review status: **Evidence inventory; behavioral review pending**

Project: [Dimension tracker + Afk display](https://modrinth.com/mod/dim-tracker-plusafk-display)
Selected artifact version: `1.3+26.3+mod`
Published implementation source: https://github.com/rogalKraft/dim-tracker-afk-display
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Allows you to track in which dimension a player is tabbed, and find out if they are afk.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha1`: `8231a6c5c1b845e03a25980852782af3dc2369ec`
- `sha512`: `2213295e07458a6e534e1e2a48df2b541a5579656028e169da3938aec296fd0d7912777eb94cf47345d5731c138f6fa3094c9f477fd391777ded079099d0dcdd`

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

Resource category counts: `function`: 10, `tags`: 1.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
