# Nimbus 2000

Review status: **Evidence inventory; behavioral review pending**

Project: [Nimbus 2000](https://modrinth.com/mod/nimbus-2000)
Selected artifact version: `1.0.2`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Fly in Survival with vanilla Creative-style controls — simply hold the Nimbus 2000 broom in either hand.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha1`: `3560202fa0eae89898384fcd32a703df3397f1bc`
- `sha512`: `7a065e1a6e0a3e539971c01f4ed7e53e3de2da7d4e92211990e5c1fb141a909fccbbe70b1031ad29cac7b0fa2d2fa44b9219438e77fe2a27c04a998c6c99de64`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 3
Reconstructed Java files: 3

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.piotrek.nimbus2000.Nimbus2000Mod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/piotrek/nimbus2000/mixin/PlayerHungerMixin.java` | `value={Player.class})` | Inject:1 | nimbus2000$skipExhaustionWhileHoldingBroom |
| top-level / `com/piotrek/nimbus2000/Nimbus2000Mod.java` | `` |  | onInitialize, id |
| top-level / `com/piotrek/nimbus2000/NimbusFlight.java` | `` |  | holdsNimbusBroom, isNimbusSurvivalPlayer, update |

## Data-driven behavior

Resource category counts: `recipe`: 1.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
