# Client Movement

Review status: **Behavioral static review**

Project: [Client Movement](https://modrinth.com/mod/client-movement)
Selected artifact version: `1.1`
Published implementation source: https://github.com/zortler/client-movement
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A minecraft mod that makes sprinting and poses fully client-sided, with no server intervention. Fixes many bugs and issues for player with high ping, especially in parkour.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `988f092161af557f2d306f3c6d41cc8267e506fe9523b47962e900a3b0b06556f95be3d8c30996a8409c13a23c513e66d19de2409a04270eaa1108ed3a5a6eeb`
- `sha1`: `86e0f6f68cc69928a7a870ae99397578a643c8ff`

## Reviewed mechanism

Both reconstructed mixins reviewed.

- For local-player movement-speed attribute updates, reconstructs the server snapshot modifiers so the client's existing sprint modifier is preserved or removed according to local state.
- For local-player synchronized metadata, ignores accessor ID 6 and rewrites flag byte ID 0 to retain the local sprint bit while accepting the other incoming bits.
- Updates for other entities continue normally. The mechanism gives selected local movement state priority over server synchronization.

## Lifecycle, correctness, and failure questions

- Numeric metadata IDs depend on the exact game entity-data layout. Suppressing server corrections changes authoritative behavior and can disagree with server movement rules.
- This is a responsiveness/gameplay change, not an algorithm that reduces rendering work.

## Checks needed to establish equivalence

- Check sprint/pose changes, respawn, spectators, server-imposed movement restrictions, latency, and each targeted metadata ID for the selected game version.

## Relevance to AstFPS

Gameplay synchronization behavior; excluded from unchanged-behavior optimization.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 2
Reconstructed Java files: 2

**environment**

```json
"client"
```

**depends**

```json
{
  "fabricloader": "*",
  "minecraft": ">=26.1",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `ch/zorty/mixin/client/AttributeMixin.java` | `value={ClientPacketListener.class})` | Inject:1 | beforeAddTransientModifiers |
| top-level / `ch/zorty/mixin/client/MetadataMixin.java` | `value={SynchedEntityData.class})` | Inject:1 | onAssignValue |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
