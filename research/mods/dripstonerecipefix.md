# DripStone Recipe FIX

Review status: **Evidence inventory; behavioral review pending**

Project: [DripStone Recipe FIX](https://modrinth.com/mod/dripstonerecipefix)
Selected artifact version: `1.2.0+mod`
Published implementation source: https://codeberg.org/LucasTHCR/DripstoneRecipeFix
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This adds a recipe where dripstone blocks can be turned into dripstones.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha1`: `8de1295e26b9f0a473f7c0a74a5b0ab10931d579`
- `sha512`: `a54498b89917fbc2547f567de7f4665fac800b703b51a26a03aeaabe6f78ca9b8841ad51c952b94188b7c3a6c3b421a375a70038c0bfe058c1f2d0d0f443ec33`

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
  "fabricloader": ">=0.14.0",
  "minecraft": ">=1.18",
  "fabric-api": "*"
}
```

## Data-driven behavior

Resource category counts: `advancements`: 1, `recipes`: 1.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
