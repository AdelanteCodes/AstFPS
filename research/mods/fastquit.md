# FastQuit

Review status: **Evidence inventory; behavioral review pending**

Project: [FastQuit](https://modrinth.com/mod/fastquit)
Selected artifact version: `3.1.5+mc26.2`
Published implementation source: https://github.com/contariaa/FastQuit
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Lets you return to the Title Screen early while your world is still saving in the background!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `0977eb0a35e1a1602bc9306ddbbb9177734131f0`
- `sha512`: `cb6e3547e3fd3c6df75cfa8bf948ded35e4ed7ccb81c401184c4f02c4b0694a141c673b238605e8719b4b48d2ba90616a3b921344cde2d68b58da3e33edca477`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 26
Reconstructed Java files: 24

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "me.contaria.fastquit.FastQuit"
  ],
  "modmenu": [
    "me.contaria.fastquit.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16.9",
  "minecraft": ">=26.2",
  "fabric-resource-loader-v0": "*",
  "cloth-config": "*",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/contaria/fastquit/CatalogueIntegration.java` | `` |  | createConfigScreen |
| top-level / `me/contaria/fastquit/FastQuit.java` | `` |  | onInitializeClient, log, warn, error, exit, wait, wait, wait, wait, getSavingWorld, getSavingWorld, getSession |
| top-level / `me/contaria/fastquit/FastQuitConfig.java` | `` |  | allowMultipleServers, createConfigScreen, getKey |
| top-level / `me/contaria/fastquit/mixin/EditWorldScreenMixin.java` | `value={EditWorldScreen.class})` | Inject:1 | waitForSaveOnBackupOrOptimizeWorld_cancellable |
| top-level / `me/contaria/fastquit/mixin/GuiAccessor.java` | `value={Gui.class})` | Accessor:1 |  |
| top-level / `me/contaria/fastquit/mixin/LevelSettingsAccessor.java` | `value={LevelSettings.class})` | Accessor:1 |  |
| top-level / `me/contaria/fastquit/mixin/LevelStorageAccessMixin.java` | `value={LevelStorageSource.LevelStorageAccess.class})` | Inject:4, WrapWithCondition:1 | fastquit$waitForSaveOnBackup, fastquit$editSavingWorldName, fastquit$deleteSavingWorld, fastquit$checkSessionClose, fastquit$warnIfUnSynchronizedSessionAccess, getSavingWorld |
| top-level / `me/contaria/fastquit/mixin/LevelStorageSessionAccessor.java` | `value={LevelStorageSource.LevelStorageAccess.class})` | Accessor:2 |  |
| top-level / `me/contaria/fastquit/mixin/LevelStorageSourceMixin.java` | `value={LevelStorageSource.class})` | Inject:2 | fastquit$waitForSaveOnSessionCreation, fastquit$addCurrentlySavingLevelsToWorldList |
| top-level / `me/contaria/fastquit/mixin/MinecraftAccessor.java` | `value={Minecraft.class})` | Invoker:1 |  |
| top-level / `me/contaria/fastquit/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Redirect:1, WrapOperation:1, Inject:2 | fastquit, fastquit$doNotOpenSaveScreen, fastquit$waitForSaveOnShutdown, fastquit$waitForSaveOnCrash |
| top-level / `me/contaria/fastquit/mixin/MinecraftServerAccessor.java` | `value={MinecraftServer.class})` | Accessor:1 |  |
| top-level / `me/contaria/fastquit/mixin/MinecraftServerMixin.java` | `value={MinecraftServer.class})` | Inject:2, WrapWithCondition:1 | fastquit$finishSaving, fastquit$cancelPlayerSavingIfDeleted, fastquit$cancelSavingIfDeleted, isDeleted |
| top-level / `me/contaria/fastquit/mixin/OptimizeWorldScreenMixin.java` | `value={OptimizeWorldScreen.class})` | Inject:1 | fastquit$waitForSaveOnOptimizeWorld |
| top-level / `me/contaria/fastquit/mixin/PrimaryLevelDataAccessor.java` | `value={PrimaryLevelData.class})` | Accessor:1 |  |
| top-level / `me/contaria/fastquit/mixin/RealmsUploadWorldPackerMixin.java` | `value={RealmsUploadWorldPacker.class})` | Inject:1 | fastquit$waitForSaveOnRealmsUpload |
| top-level / `me/contaria/fastquit/mixin/WorldListWidgetWorldEntryMixin.java` | `value={WorldSelectionList.WorldListEntry.class})` | WrapOperation:2, Inject:2 | fastquit$editSavingWorld, fastquit$deleteSavingWorld, fastquit$openWorldListWhenFailed, fastquit$renderSavingTimeOnWorldList |
| top-level / `me/contaria/fastquit/mixin/WorldOpenFlowsMixin.java` | `value={WorldOpenFlows.class})` | Inject:1 | fastquit$waitForSaveOnWorldLoad_cancellable |
| top-level / `me/contaria/fastquit/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `me/contaria/fastquit/plugin/FastQuitMixinConfigPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `me/contaria/fastquit/plugin/Synchronized.java` | `` |  |  |
| top-level / `me/contaria/fastquit/TextHelper.java` | `` |  | translatable, literal |
| top-level / `me/contaria/fastquit/WaitingScreen.java` | `` |  | init, shouldCloseOnEsc, onClose |
| top-level / `me/contaria/fastquit/WorldInfo.java` | `` |  | getTimeSaving |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
