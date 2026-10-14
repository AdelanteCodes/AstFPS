# Mob Collision Off

Review status: **Behavioral static review**

Project: [Mob Collision Off](https://modrinth.com/mod/mob-collision-off)
Selected artifact version: `3.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

🗸 Disables collisions between entities, gives better TPS and may slightly increase FPS

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha1`: `1ddba82f178980d93616aed14e6a468bc9c35f91`
- `sha512`: `73ecc8d851b050164275ba99f66957640ce60c32ae95443e6ce701d75e1ed10d1ecb45555d046eba1e84c325b62a77185f914d188fe3f094e6e5c99eb9aa4ebc`

## Reviewed mechanism

All five reconstructed classes reviewed.

- Cancels most Entity.push(Entity) calls. The player-related branch preserves selected interactions but cancels when the incoming entity is a Mob; non-player interactions are cancelled.
- Cancels Player.touch except for experience-orb and item entities. A separate empty collision mixin contributes no operation.

## Lifecycle, correctness, and failure questions

- Changes collision and touch behavior, including crowd mechanics. The player branch is asymmetric and requires both call directions to be checked.

## Checks needed to establish equivalence

- Check player/mob/player pairs in both directions, boats/minecarts, crowd pushing, pickups, and any touch-based entity behavior.

## Relevance to Xe-Mod

Simulation work reduction through changed gameplay; excluded from unchanged-behavior optimization.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 5
Reconstructed Java files: 5

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "gv1per.mobcollisionoff.MobCollisionOff"
  ],
  "client": [
    "gv1per.mobcollisionoff.client.MobCollisionOffClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3 <=27"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `gv1per/mobcollisionoff/client/MobCollisionOffClient.java` | `` |  | onInitializeClient |
| top-level / `gv1per/mobcollisionoff/mixin/EntityCollideMixin.java` | `value={Entity.class})` |  |  |
| top-level / `gv1per/mobcollisionoff/mixin/EntityMixin.java` | `value={Entity.class})` | Inject:1 | onPushByEntity |
| top-level / `gv1per/mobcollisionoff/mixin/PlayerMixin.java` | `value={Player.class})` | Inject:1 | onTouch |
| top-level / `gv1per/mobcollisionoff/MobCollisionOff.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
