# BetterGrassify

Review status: **Evidence inventory; behavioral review pending**

Project: [BetterGrassify](https://modrinth.com/mod/bettergrassify)
Selected artifact version: `1.8.8+fabric.26.3`
Published implementation source: https://github.com/UltimatChamp/BetterGrassify
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Gamers can finally touch grass!?

OptiFine's Fancy and Fast better grass implemented on Fabric and NeoForge!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `14cd361bb1f56d207a3e811a25d4af9bfc76d52bcd7bd9aad73ca8f334a7226ff3cb69d9890d4fc3cdd83eb4b630077b36870dcaff8149be178207ee2a9ea90d`
- `sha1`: `626f74d3265d140f80ebb5ca1703f43ba07ff1bd`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 25
Reconstructed Java files: 18

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/ultimatchamp/bettergrass/BetterGrassify.java` | `` |  | onInitializeClient, getBlocks |
| top-level / `dev/ultimatchamp/bettergrass/compat/WilderWildCompat.java` | `` |  | isSnowloggingOn |
| top-level / `dev/ultimatchamp/bettergrass/config/BetterGrassifyConfig.java` | `` |  | load, save, ensureDefaults, createConfigScreen, getKey, getKey |
| top-level / `dev/ultimatchamp/bettergrass/config/ModMenuAPIImpl.java` | `` |  | getModConfigScreenFactory |
| top-level / `dev/ultimatchamp/bettergrass/config/NoClothConfigWarning.java` | `` |  | init, extractBackground |
| top-level / `dev/ultimatchamp/bettergrass/config/OptionsScreen.java` | `` |  | createConfigScreen |
| top-level / `dev/ultimatchamp/bettergrass/config/SodiumOptionsScreenBuilder.java` | `` |  | registerConfigLate |
| top-level / `dev/ultimatchamp/bettergrass/config/SodiumOptionsStorage.java` | `` |  | getData, save |
| top-level / `dev/ultimatchamp/bettergrass/config/TranslatableOption.java` | `` |  |  |
| top-level / `dev/ultimatchamp/bettergrass/mixin/SectionCompilerMixin.java` | `value={SectionCompiler.class})` | Inject:1, ModifyVariable:1 | bettergrass$render, bettergrass$setGrassState |
| top-level / `dev/ultimatchamp/bettergrass/mixin/sodium/ChunkBuilderMeshingTaskMixin.java` | `value={ChunkBuilderMeshingTask.class}, priority=990)` | Inject:1 | bettergrass$execute |
| top-level / `dev/ultimatchamp/bettergrass/mixin/VideoSettingsScreenMixin.java` | `value={VideoSettingsScreen.class})` | Inject:1 | bettergrass$addConfigButton |
| top-level / `dev/ultimatchamp/bettergrass/model/BetterGrassifyBlockStateModel.java` | `` |  | emitQuads, betterGrassify, betterSnowyGrass, isFullQuad, canFullyConnect, canConnect, canConnect, isBelowNonFullBlock, isSnowy, spriteBake |
| top-level / `dev/ultimatchamp/bettergrass/model/BetterGrassifyUnbakedRootBlockStateModel.java` | `` |  | bake, visualEqualityGroup, resolveDependencies |
| top-level / `dev/ultimatchamp/bettergrass/util/BetterGrassifyCacheUtils.java` | `` |  | reloadCaches, initCaches |
| top-level / `dev/ultimatchamp/bettergrass/util/BetterSnowPredicateUtils.java` | `` |  | isBlockWhitelisted, isTagWhitelisted, isBlockExcluded, isTagExcluded, matchesBlock, withoutAttribute, isWhitelistOn |
| top-level / `dev/ultimatchamp/bettergrass/util/BetterSnowUtils.java` | `` |  | getLayerNeighbour, isLayerNeighbourSnow, canHaveGhostSnowLayer, canHaveGhostLayer |
| top-level / `dev/ultimatchamp/bettergrass/util/SpriteCalculator.java` | `` |  | calculateSprite, onResourceManagerReload |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
