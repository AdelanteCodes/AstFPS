# Hibernate Fabric

Review status: **Evidence inventory; behavioral review pending**

Project: [Hibernate Fabric](https://modrinth.com/mod/hibernate-fabric)
Selected artifact version: `1.2.1+mc26.3`
Published implementation source: https://codeberg.org/VoxelBill/hibernate-fabric
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Lets your Minecraft Fabric server snooze when idle, slashing CPU usage without missing a block!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `ef19c53df6b375d50576bdaf291a83ceb709cbfd0723e971df7d377ed9ef75df629dd85ada13ca5a3f61e95e24b00ca076671de7a06e40a4c39f98c63034e268`
- `sha1`: `c1e5c793da090bf61b574ca090b5ce426d794aaa`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 11
Reconstructed Java files: 8

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "me.voxelbill.hibernate_fabric.HibernateFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/voxelbill/hibernate_fabric/commands/GameRuleHandler.java` | `` |  | register, setHibernationGameRules, mc304138WorkaroundFix, asyncEntitySpawnFixForDevEnv |
| top-level / `me/voxelbill/hibernate_fabric/commands/HibernateCommand.java` | `` |  | register, toggleHibernation, showStatus, showMemoryInfo, forceGarbageCollection, getUsedMemoryMB |
| top-level / `me/voxelbill/hibernate_fabric/config/Config.java` | `` |  | load, save, getJson, setupGson, serialize, deserialize, parseRemoveEntitiesList |
| top-level / `me/voxelbill/hibernate_fabric/config/Upgrader.java` | `` |  | needsUpgrade, upgrade |
| top-level / `me/voxelbill/hibernate_fabric/HibernateFabric.java` | `` |  | onInitialize, isHibernating, setHibernationState |
| top-level / `me/voxelbill/hibernate_fabric/MemoryManager.java` | `` |  | startMemoryOptimization, stopMemoryOptimization, performMemoryCleanup, unloadUnnecessaryChunks, shouldForceGC, performGarbageCollection, getUsedMemoryMB, logMemoryUsage, saveImportantData, shutdown |
| top-level / `me/voxelbill/hibernate_fabric/world/ChunkUnloadHandler.java` | `` |  | register, isEntityInChunk, canEntityBeRemovedDuringHibernation |
| top-level / `me/voxelbill/hibernate_fabric/world/TickEventHandler.java` | `` |  | register, shutdown |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
