# Clumps

Review status: **Evidence inventory; behavioral review pending**

Project: [Clumps](https://modrinth.com/mod/ly-clumps)
Selected artifact version: `v1.1.0+mod`
Published implementation source: https://github.com/lullaby6/data-packs/tree/main/Clumps
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Merge experience orbs and instant pickup experience orbs to reduce lag!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha1`: `5e385b356af7a07d565655fa0dfafe6b8d1d6816`
- `sha512`: `157389eec1fb1b2f0345266aa01b6967b6b84ab909aa2cd3190c17acfc8b538bf0d5b4a679ceead4b5ac31030316cc4f10a8737f51da8a787e4f3de5f7035d26`

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

Resource category counts: `dialog`: 5, `function`: 12, `tags`: 2.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
