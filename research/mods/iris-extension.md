# Iris Extension

Review status: **Evidence inventory; behavioral review pending**

Project: [Iris Extension](https://modrinth.com/mod/iris-extension)
Selected artifact version: `1.0.3+26.3`
Published implementation source: https://github.com/Merlin1809/IrisExtension
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

An extension for the Minecraft shader loader Iris with some useful features for shader developers.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `optional`.

Artifact identity:
- `sha1`: `283165e3af697fcd722c3eb2f613c8b29b611488`
- `sha512`: `99af92b5415fd2198f8ab6d5184f3f950a95050e71d752498e927dfe06a8cba72ccc4c82766e17f9bdad562fbd4827bc4ba06f3b33d403f25a2f066e02371f59`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 13
Reconstructed Java files: 13

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "merlin1809.irisextension.IrisExtension"
  ],
  "client": [
    "merlin1809.irisextension.IrisExtensionClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*",
  "iris": ">=1.11.6"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `merlin1809/irisextension/IrisExtension.java` | `` |  | onInitialize |
| top-level / `merlin1809/irisextension/IrisExtensionClient.java` | `` |  | onInitializeClient |
| top-level / `merlin1809/irisextension/mixin/client/DefineMixin.java` | `value={StandardMacros.class})` | Inject:1 | define, define, addDefines |
| top-level / `merlin1809/irisextension/mixin/client/GetShaderPropertiesMixin.java` | `value={ShaderProperties.class})` | Inject:1 | handleWhitespacedListDirective, getShaderProperties |
| top-level / `merlin1809/irisextension/mixin/client/KeybindMixin.java` | `value={Iris.class})` | Inject:2 | addKeybinds, useKeybinds |
| top-level / `merlin1809/irisextension/mixin/client/ProgramMixin.java` | `value={ProgramSet.class})` | ModifyVariable:1, Redirect:1 | changeTessellation, changeGeometry |
| top-level / `merlin1809/irisextension/mixin/client/ShaderScreenMixin.java` | `value={ShaderPackScreen.class}, remap=false)` | Inject:3 | hasKeybinds, setOptionsWidth, changeOnPackChange, fixOptionWidth, renderKeybindPanel |
| top-level / `merlin1809/irisextension/mixin/client/UniformMixin.java` | `value={IrisExclusiveUniforms.class})` | Inject:1 | addUniformsNewIris |
| top-level / `merlin1809/irisextension/mixin/DragonFightMixin.java` | `value={EnderDragonFight.class})` | Inject:1 | sendDragonStuff, onDragonKilled |
| top-level / `merlin1809/irisextension/mixin/GetDragonKilledMixin.java` | `value={EnderDragonFight.class})` | Accessor:4 |  |
| top-level / `merlin1809/irisextension/mixin/PlayerJoinMixin.java` | `value={PlayerList.class})` | Inject:1 | onPlayerJoin |
| top-level / `merlin1809/irisextension/networking/DragonUniformsPayload.java` | `` |  | type |
| top-level / `merlin1809/irisextension/Variables.java` | `` |  | fromString, getKeyMethod |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
