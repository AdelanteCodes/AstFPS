# Non Persistent Wither Skulls

Review status: **Behavioral static review**

Project: [Non Persistent Wither Skulls](https://modrinth.com/mod/non-persistent-wither-skulls)
Selected artifact version: `1.0.3-mc-26.3`
Published implementation source: https://github.com/Azyrod/mc-non-persistent-wither-skulls
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Prevents wither skulls from accumulating in unloaded chunks and potentially fly forever

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `145bf70ae6a79315783a97de28ec5b614af744b43a8d4fb08b5b8f8caf40573d6e4f74b88d5cea4f9d9914732104d55327c649e4a8b2b958a877911bb8c94c9f`
- `sha1`: `5d641c89f52a60fe537dce7fc6038056206400d3`

## Reviewed mechanism

Both reconstructed classes reviewed.

- After persistent entity-section visibility changes, checks whether the entity is a moving WitherSkull on a ServerLevel.
- If its position is no longer entity-ticking and velocity is nonzero, discards the skull instead of allowing it to persist through inactive chunks.

## Lifecycle, correctness, and failure questions

- Changes projectile lifetime and future effects after chunk reactivation. Non-ticking is not identical to permanently irrelevant.

## Checks needed to establish equivalence

- Track moving/stationary skulls through chunk unload/reload, ticking boundaries, forced chunks, and world save/restart.

## Relevance to Xe-Mod

Prevents accumulating projectiles by removing them; a server behavior change, not exact optimization.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 2
Reconstructed Java files: 2

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "net.azyrod.nonPersistentWitherSkulls.NonPersistentWitherSkulls"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/azyrod/nonPersistentWitherSkulls/mixins/PersistentEntitySectionManager$CallbackMixin.java` | `targets={"net.minecraft.world.level.entity.PersistentEntitySectionManager$Callback"})` | Inject:1 | updateLoadStatus |
| top-level / `net/azyrod/nonPersistentWitherSkulls/NonPersistentWitherSkulls.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
