# FastLeafDecay

Review status: **Evidence inventory; behavioral review pending**

Project: [FastLeafDecay](https://modrinth.com/mod/fastleafdecay)
Selected artifact version: `2.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

FastLeafDecay support Folia, Bukkit, Paper, Purpur, Spigot, Fabric, Forge, NeoForge

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unknown`. Server support: `unknown`.

Artifact identity:
- `sha1`: `92fff0d70bf5d5b7a166cb0abf0402d7c55f85b5`
- `sha512`: `4486ce55e0c89ac46a6baaf319adf54335d30e6baeae47a6719af114173ace334f601fc3c427f3f00790fdfeba55c32ab9c4a0c27ea142f1f3d68457329ccd50`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 9
Reconstructed Java files: 7

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "me._1mn1ko.leafdecay.fabric.FastLeafDecayFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.15.0",
  "minecraft": ">=1.20 <=26.4",
  "java": ">=17",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/_1mn1ko/leafdecay/compat/Compat.java` | `` |  | isOp |
| top-level / `me/_1mn1ko/leafdecay/Config.java` | `` |  | load, save, sanitize |
| top-level / `me/_1mn1ko/leafdecay/fabric/FastLeafDecayFabric.java` | `` |  | onInitialize |
| top-level / `me/_1mn1ko/leafdecay/FastLeafDecay.java` | `` |  | init, reload, config, lang, isEnabled, setEnabled |
| top-level / `me/_1mn1ko/leafdecay/FldCommands.java` | `` |  | register, build, allowed, send |
| top-level / `me/_1mn1ko/leafdecay/Lang.java` | `` |  | load, read, get, colorize |
| top-level / `me/_1mn1ko/leafdecay/LeafDecayManager.java` | `` |  | clear, tick, onBlockBreak, applySlowness, scan, decayBatch |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
