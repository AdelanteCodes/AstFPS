# quick pack

Review status: **Evidence inventory; behavioral review pending**

Project: [quick pack](https://modrinth.com/mod/quick-pack)
Selected artifact version: `fabric-1.5.1+26.3`
Published implementation source: https://github.com/DrexHD/quick-pack
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Optimize datapack / resourcepack zip file loading times

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `4873321d649c3f1fae1ea1308c506777d4d3cbe1`
- `sha512`: `b8b1a4f571a7fa12e5dc1b8da1d30e49b9e7b3f612369304ae05ace215c8610d26be7ff54189fe933a1a8652981f7ea23ecf18ed2e877cd98454b7369bf67542`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 14
Reconstructed Java files: 14

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "me.drex.quickpack.fabric.QuickPackFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.17.3",
  "java": ">=25"
}
```

**accessWidener**

```json
"quick-pack.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/drex/quickpack/config/Config.java` | `` |  |  |
| top-level / `me/drex/quickpack/config/ConfigManager.java` | `` |  | load |
| top-level / `me/drex/quickpack/duck/IFilePackResources.java` | `` |  |  |
| top-level / `me/drex/quickpack/fabric/QuickPackFabric.java` | `` |  | onInitialize |
| top-level / `me/drex/quickpack/mixin/FilePackResourcesAccessor.java` | `value={FilePackResources.class})` | Accessor:2 | getLOGGER |
| top-level / `me/drex/quickpack/mixin/FilePackResourcesMixin.java` | `value={FilePackResources.class})` | WrapOperation:1, WrapMethod:1, Inject:1 | quick_pack$initializeFileTree, fastListResources, fastGetNamespaces, onClose |
| top-level / `me/drex/quickpack/mixin/FileResourcesSupplierMixin.java` | `value={FilePackResources.FileResourcesSupplier.class})` | Inject:2 | initializeFileTree, initializeFileTrees |
| top-level / `me/drex/quickpack/mixin/FontManagerMixin.java` | `value={FontManager.class})` | Overwrite:1 | finalizeProviderLoading |
| top-level / `me/drex/quickpack/mixin/FontSetMixin.java` | `value={FontSet.class})` | Overwrite:1 | selectProviders |
| top-level / `me/drex/quickpack/mixin/GuiMixin.java` | `value={Gui.class})` | ModifyArg:1 | disableFadeIn |
| top-level / `me/drex/quickpack/mixin/LoadingOverlayMixin.java` | `value={LoadingOverlay.class})` | WrapOperation:1 | removeFadeOut |
| top-level / `me/drex/quickpack/mixin/SharedZipFileAccessAccessor.java` | `value={FilePackResources.SharedZipFileAccess.class})` | Invoker:1 |  |
| top-level / `me/drex/quickpack/mixin/SpriteLoaderMixin.java` | `value={SpriteLoader.class})` | WrapOperation:1 | parallelMipmapGeneration |
| top-level / `me/drex/quickpack/QuickPack.java` | `` |  | initializeFileTrees |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
