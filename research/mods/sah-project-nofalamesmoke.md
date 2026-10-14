# SAH Project "No Falame&Smoke"

Review status: **Evidence inventory; behavioral review pending**

Project: [SAH Project "No Falame&Smoke"](https://modrinth.com/mod/sah-project-nofalamesmoke)
Selected artifact version: `1.2.2`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Toggle the flame/smoke particles

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `2a32eea28cefb0b548c3ef3e4e1493dd8af76960ece4e50f5b3aa963a21671062376f2dad89777f47366cda7cd34ae18888d43105a02263dd8d4615405610bd3`
- `sha1`: `a63dbb5d5e577d4a46479fb5b7f6d389d778c379`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 18
Reconstructed Java files: 14

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.sah.noflamesmoke.NoFlameSmokeMod"
  ],
  "modmenu": [
    "com.sah.noflamesmoke.integration.ModMenuEntry"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": ">=26.1.2 <26.4",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/sah/noflamesmoke/config/ConfigManager.java` | `` |  | get, configPath, save, save, load, restoreVanilla, applyGlobalToPerBlock, apply, allowFlameVisible, allowSmokeVisible |
| top-level / `com/sah/noflamesmoke/config/NFSConfig.java` | `` |  |  |
| top-level / `com/sah/noflamesmoke/integration/ModMenuEntry.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/sah/noflamesmoke/mixin/AbstractCandleBlockMixin.java` | `value={AbstractCandleBlock.class})` | Inject:1 | nfs$separateCandleParticles |
| top-level / `com/sah/noflamesmoke/mixin/BlastFurnaceBlockMixin.java` | `value={BlastFurnaceBlock.class})` | Inject:1 | nfs$splitParticles |
| top-level / `com/sah/noflamesmoke/mixin/FurnaceBlockMixin.java` | `value={FurnaceBlock.class})` | Inject:1 | nfs$splitParticles |
| top-level / `com/sah/noflamesmoke/mixin/RedstoneTorchBlockMixin.java` | `value={RedstoneTorchBlock.class})` | Inject:1 | nfs$animateTick, add |
| top-level / `com/sah/noflamesmoke/mixin/RedstoneWallTorchBlockMixin.java` | `value={RedstoneWallTorchBlock.class})` | Inject:1 | nfs$animateTick |
| top-level / `com/sah/noflamesmoke/mixin/SmokerBlockMixin.java` | `value={SmokerBlock.class})` | Inject:1 | nfs$splitParticles |
| top-level / `com/sah/noflamesmoke/mixin/TorchBlockMixin.java` | `value={TorchBlock.class})` | Inject:1 | nfs$randomDisplayTick |
| top-level / `com/sah/noflamesmoke/mixin/WallTorchBlockMixin.java` | `value={WallTorchBlock.class})` | Inject:1 | nfs$randomDisplayTick |
| top-level / `com/sah/noflamesmoke/NoFlameSmokeMod.java` | `` |  | onInitializeClient |
| top-level / `com/sah/noflamesmoke/ui/NFSConfigScreen.java` | `` |  | enabledDisabled, extractRenderState, init, getToggle, copyOf, copyT, applyGlobalToPerBlockLocal, restoreVanillaLocal, allTogglesOf |
| top-level / `com/sah/noflamesmoke/ui/NFSListWidget.java` | `` |  | addEntry, getRowWidth, scrollBarX, enabledDisabled, extractContent, narratables, children |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
