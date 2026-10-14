# String Duper

Review status: **Evidence inventory; behavioral review pending**

Project: [String Duper](https://modrinth.com/mod/string-dupe)
Selected artifact version: `1.0.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

StringDuper restores classic tripwire string duping in Minecraft using a controlled tick-based system. Farms only run when the setup, water, and conditions are valid, with safety checks that reduce lag and prevent accidental activation.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `d0ea8b3d07a31745c93a73661468789a504bf169`
- `sha512`: `911cd8952d3ef6f502d3bc111af04742019410c78806460d81023585aa887dacade8db2e91f3b14285ece4b2609b990ec0f0b80ddf15598f97dada30784df9d7`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 14
Reconstructed Java files: 11

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.stringduper.Stringduper"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/stringduper/client/mixin/ExampleClientMixin.java` | `value={Minecraft.class})` | Inject:1 | init |
| top-level / `com/stringduper/client/StringduperClient.java` | `` |  | onInitializeClient |
| top-level / `com/stringduper/ConfigManager.java` | `` |  | load, save, getConfig, validateAndFallback |
| top-level / `com/stringduper/mixin/ExampleMixin.java` | `value={MinecraftServer.class})` | Inject:1 | init |
| top-level / `com/stringduper/mixin/FlowingFluidMixin.java` | `value={FlowingFluid.class})` | Inject:1 | onSpreadTo |
| top-level / `com/stringduper/mixin/LevelMixin.java` | `value={MinecraftServer.class})` | Inject:1 | onServerTick |
| top-level / `com/stringduper/mixin/LeverMixin.java` | `value={LeverBlock.class})` | Inject:1 | onUseWithoutItem |
| top-level / `com/stringduper/mixin/TripWireHookMixin.java` | `value={TripWireHookBlock.class})` | Inject:1 | onCalculateState |
| top-level / `com/stringduper/Stringduper.java` | `` |  | onInitialize |
| top-level / `com/stringduper/StringDuperConfig.java` | `` |  |  |
| top-level / `com/stringduper/StringDuperEventHandler.java` | `` |  | onServerTickPost, buildFarmStructure, scanForOppositeHook, hasTripwireChain, findWetChainBlock, getNearbyPlayers, isLeverPowered, spawnString, registerIfHook, onFluidPlaceBlock, reportFailure, reportFailure, generateChainId, intersects |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
