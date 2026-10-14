# Simple Datapacks

Review status: **Evidence inventory; behavioral review pending**

Project: [Simple Datapacks](https://modrinth.com/mod/simple-datapacks)
Selected artifact version: `2.9.1-fabric+26.1`
Published implementation source: https://github.com/BizCub/simple-datapacks
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Simplifying the use of datapacks

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha512`: `f65f05ceb0b3c1ee6b41a014a9bc69b577e2efa53cf665786c3f17fc3cd32c4d7bf2d4fe3fe674a8a0bb8be06271d368e21905a43283bb1381bc595388b3040a`
- `sha1`: `8d61bc6ca0b2a0f15b89773be610eae10f15f352`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 16
Reconstructed Java files: 13

**entrypoints**

```json
{
  "modmenu": [
    "io.github.bizcub.simpleDatapacks.platform.Fabric$ModMenu"
  ],
  "main": [
    "io.github.bizcub.simpleDatapacks.platform.Fabric"
  ]
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/github/bizcub/simpleDatapacks/config/ClothConfig.java` | `` |  | getInstance, init, copyDatapacks, shouldApplyRequiredPacksToExistingWorld, enableFeatures, globalFeatures, sendRestartWarning, requiredDatapacksPaths, optionalDatapacksPaths |
| top-level / `io/github/bizcub/simpleDatapacks/config/Config.java` | `` |  | get, set |
| top-level / `io/github/bizcub/simpleDatapacks/config/ConfigHelper.java` | `` |  | isModLoaded, isClothConfigLoaded, isSimpleConfigLoaded, getScreen |
| top-level / `io/github/bizcub/simpleDatapacks/config/SimpleConfig.java` | `` |  | getInstance, copyDatapacks, shouldApplyRequiredPacksToExistingWorld, enableFeatures, globalFeatures, sendRestartWarning, requiredDatapacksPaths, optionalDatapacksPaths |
| top-level / `io/github/bizcub/simpleDatapacks/Main.java` | `` |  | init, getAllDatapacksPaths, copyDatapacks, isRequiredDatapack, getRequiredDatapacks |
| top-level / `io/github/bizcub/simpleDatapacks/mixin/CreateWorldScreenMixin.java` | `value={CreateWorldScreen.class})` | ModifyArg:1 | sd$addGlobalFeatures |
| top-level / `io/github/bizcub/simpleDatapacks/mixin/DataPackCommandMixin.java` | `value={DataPackCommand.class})` | Inject:1 | sd$getDisabledPackId |
| top-level / `io/github/bizcub/simpleDatapacks/mixin/FeatureFlagsMixin.java` | `value={FeatureFlagRegistry.Builder.class})` | Inject:1 | sd$addFeatures |
| top-level / `io/github/bizcub/simpleDatapacks/mixin/FolderRepositorySourceMixin.java` | `value={FolderRepositorySource.class})` | ModifyArg:1 | sd$suppressEntryLog |
| top-level / `io/github/bizcub/simpleDatapacks/mixin/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Inject:2, ModifyVariable:1, Redirect:1 | sd$copyDatapacksInit, sd$copyDatapacksReload, sd$reload, sd$preventAutoLoading, sd$copyDatapacks, sd$displayMessage |
| top-level / `io/github/bizcub/simpleDatapacks/mixin/PackRepositoryMixin.java` | `value={PackRepository.class})` | Inject:2 | sd$addSources, sd$refreshSources, sd$isServerRepository, sd$rebuild, sd$add |
| top-level / `io/github/bizcub/simpleDatapacks/mixin/ServerPacksSourceMixin.java` | `value={ServerPacksSource.class})` | Inject:1 | sd$removeFeatures |
| top-level / `io/github/bizcub/simpleDatapacks/platform/Fabric.java` | `` |  | onInitialize, getModConfigScreenFactory |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
