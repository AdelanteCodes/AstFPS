# GeyserFixes

Review status: **Evidence inventory; behavioral review pending**

Project: [GeyserFixes](https://modrinth.com/mod/geyserfixes)
Selected artifact version: `1.1.1`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Make the experience of your bedrock players actually good. (Fixes the long standing gameplay ruining issues for bedrock players on geyserMC and Fabric/PaperMC server)

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `a3eb536ebe96cbf08f0a5fa5e1046cd120d4b1b2`
- `sha512`: `378fe6cb7ad2bca9144856fc2acc32ee43887b86dbe3b208b1d882e4487031296f630b5a49ef9ac37d6e57c14ad4b48df8d45464c8208b1e6c1847c9947b4572`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 7
Reconstructed Java files: 7

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.areedelahi.geyserfix.GeyserFixesMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": "~26.3",
  "java": ">=25",
  "corelib": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/areedelahi/geyserfix/command/ChunkReloadCommand.java` | `` |  | execute |
| top-level / `com/areedelahi/geyserfix/command/OffhandCommand.java` | `` |  | execute |
| top-level / `com/areedelahi/geyserfix/GeyserFixesMod.java` | `` |  | onInitialize |
| top-level / `com/areedelahi/geyserfix/listener/BedrockMovementListener.java` | `` |  | register, onPlayerSpawn, isRespawnProtected |
| top-level / `com/areedelahi/geyserfix/listener/GeyserTransferListener.java` | `` |  | register |
| top-level / `com/areedelahi/geyserfix/listener/InventoryShiftClickListener.java` | `` |  | register, onShiftClick |
| top-level / `com/areedelahi/geyserfix/listener/SpawnProtectionListener.java` | `` |  | register, makeInvulnerable, removeInvulnerability, isInvulnerable, isInvulnerable, isInvulnerable |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
