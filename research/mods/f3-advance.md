# F3 ADVANCE

Review status: **Evidence inventory; behavioral review pending**

Project: [F3 ADVANCE](https://modrinth.com/mod/f3-advance)
Selected artifact version: `0.1.1+mc26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A cleaner, organized, color-coded F3 debug HUD for Minecraft Fabric with per-line toggles, performance metrics, and clean visuals.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `84b377b4d5ae3779ccf70ab82fc64ad7ba413cb06953f5d5389263dc1d5b19a993efd1b4ba779d9755788eab57e057e34d9fbee5c27ecbdc6e1666af32da6c99`
- `sha1`: `dbacaf9a10024cd3fcbee1d8427250a2995cf8d6`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 16
Reconstructed Java files: 9

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.f3advanced.client.F3AdvancedClient"
  ],
  "modmenu": [
    "com.f3advanced.client.F3AdvancedModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16.0",
  "minecraft": "26.3",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/f3advanced/client/command/F3AdvancedCommands.java` | `` |  | registerSetting, literal, argument, register, openGui, sendHelp, SettingHandler |
| top-level / `com/f3advanced/client/config/F3AdvancedConfig.java` | `` |  | load, save, ensureDefaults |
| top-level / `com/f3advanced/client/F3AdvancedClient.java` | `` |  | onInitializeClient, openConfigScreen, registerKeys, getCategory, register, onClientTick, toggleSection |
| top-level / `com/f3advanced/client/F3AdvancedModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/f3advanced/client/hud/F3AdvancedHud.java` | `` |  | render, addPosition, addWorld, addPerformance, addPlayer, addTarget, addSystem, drawRows, sampleFps, facing, chunk, slime, biomeName, dimensionName, translationFromId, canHostileSpawn, ticksToClock, weather, moon, fpsColor, airColor, healthColor, effects, formatTicks, graph, safeId, gpuRenderer, title, row, Row |
| top-level / `com/f3advanced/client/hud/F3AdvancedHudRegistrar.java` | `` |  | register |
| top-level / `com/f3advanced/client/mixin/DebugScreenOverlayMixin.java` | `value={DebugScreenOverlay.class})` | Inject:1 | f3advanced$replaceDebugOverlay |
| top-level / `com/f3advanced/client/screen/ClothConfigHelper.java` | `` |  | create, bool, integer |
| top-level / `com/f3advanced/client/screen/F3AdvancedConfigScreen.java` | `` |  | create, init, onClose, extractRenderState, rebuildWidgets, label, buildPages, toggle, Page, Toggle |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
