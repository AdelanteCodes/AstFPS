# Shut Up Dead Entities

Review status: **Evidence inventory; behavioral review pending**

Project: [Shut Up Dead Entities](https://modrinth.com/mod/shut-up-dead-entities)
Selected artifact version: `1.3.1`
Published implementation source: https://github.com/diskria-minecraft/shut-up-dead-entities
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A client-side mod that smoothly fades out mob sounds upon death. Mutes dead mobs by fading, silencing, and stopping persistent ghost audio from Endermens, Creepers and Nether portals.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `7d5be36672752a3b477ec5462a5230ac0d1051a4`
- `sha512`: `6d66482c0265ea6c1f1493eb7047738daeff82b7ca5a2e783c2b375228adbdb4106da9f89920a4be005f9341bcff1ebe3257769b7d68ba4a42453eff22d28084`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 17
Reconstructed Java files: 12

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    {
      "value": "io.github.diskria.shut_up_dead_entities.ShutUpDeadEntitiesMod",
      "adapter": "kotlin"
    }
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3",
  "java": ">=25",
  "fabric-language-kotlin": ">=1.13.12+kotlin.2.4.0"
}
```

**accessWidener**

```json
"shut_up_dead_entities.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/github/diskria/shut_up_dead_entities/client/BlockBoundSoundInstance.java` | `` |  | tick |
| top-level / `io/github/diskria/shut_up_dead_entities/client/ClientLevelMixin.java` | `` | WrapOperation:2 | interceptPlay, interceptPlayDelayed, boundSoundToEntityOrNull, invoke, boundSoundToBlockOrNull, boundSoundToBlockOrNull$lambda$0, SOUND_TO_BLOCK_PREDICATES$lambda$0, SOUND_TO_BLOCK_PREDICATES$lambda$1, SOUND_TO_BLOCK_PREDICATES$lambda$2, SOUND_TO_BLOCK_PREDICATES$lambda$3, SOUND_TO_BLOCK_PREDICATES$lambda$4, SOUND_TO_BLOCK_PREDICATES$lambda$5, SOUND_TO_BLOCK_PREDICATES$lambda$6, SOUND_TO_BLOCK_PREDICATES$lambda$7, SOUND_TO_BLOCK_PREDICATES$lambda$8, SOUND_TO_BLOCK_PREDICATES$lambda$9, SOUND_TO_BLOCK_PREDICATES$lambda$10, SOUND_TO_BLOCK_PREDICATES$lambda$11, SOUND_TO_BLOCK_PREDICATES$lambda$12, SOUND_TO_BLOCK_PREDICATES$lambda$13 |
| top-level / `io/github/diskria/shut_up_dead_entities/client/ClientLevelMixin_Impl.java` | `` |  |  |
| top-level / `io/github/diskria/shut_up_dead_entities/client/ClientLevelMixinKt.java` | `` |  | findAliveEntityAt, invoke |
| top-level / `io/github/diskria/shut_up_dead_entities/client/EntityBoundSoundInstanceMixin.java` | `` | WrapOperation:1 | interceptEntityRemovedCheck |
| top-level / `io/github/diskria/shut_up_dead_entities/client/EntityBoundSoundInstanceMixin_Impl.java` | `` |  |  |
| top-level / `io/github/diskria/shut_up_dead_entities/client/LocalPlayerMixin.java` | `` | WrapOperation:1 | interceptPortalTriggerSoundInstance |
| top-level / `io/github/diskria/shut_up_dead_entities/client/mixin/ClientLevelMixin_Generated.java` | `value={ClientLevel.class})` | WrapOperation:2 | shut_up_dead_entities$interceptPlayDelayed |
| top-level / `io/github/diskria/shut_up_dead_entities/client/mixin/EntityBoundSoundInstanceMixin_Generated.java` | `value={EntityBoundSoundInstance.class})` | WrapOperation:1 | shut_up_dead_entities$interceptEntityRemovedCheck |
| top-level / `io/github/diskria/shut_up_dead_entities/client/mixin/LocalPlayerMixin_Generated.java` | `value={LocalPlayer.class})` | WrapOperation:1 |  |
| top-level / `io/github/diskria/shut_up_dead_entities/client/PlayerBoundPortalTriggerSoundInstance.java` | `` |  | isStopped, tick |
| top-level / `io/github/diskria/shut_up_dead_entities/ShutUpDeadEntitiesMod.java` | `` |  | onInitializeClient |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
