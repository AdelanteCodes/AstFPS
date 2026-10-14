# Scalable

Review status: **Evidence inventory; behavioral review pending**

Project: [Scalable](https://modrinth.com/mod/downloadableduck-scalable)
Selected artifact version: `1.0.5-26.2`
Published implementation source: https://github.com/downloadableduck/scalable
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Scale each element of the GUI individually!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `7c0fa07fc15ba8b8a960dde8467b7fcb73efb57b14c2ff353e8ffdab4c29f5ed6ac856d16d9291b8d836078cbbd39b995ec3a5600fcc7aedd8c1bf6c1aa37bec`
- `sha1`: `cfd7545d5638a84e770c351e1dba5d4f59d91108`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 14
Reconstructed Java files: 9

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "com.jeff.scalable.fabric.ScalableFabric"
  ],
  "client": [
    "com.jeff.scalable.fabric.client.ScalableFabricClient"
  ],
  "sodium:config_api_user": [
    "com.jeff.scalable.ScalableSodiumPage"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.2",
  "minecraft": "~26.2",
  "java": ">=25",
  "cloth-config": "*",
  "sodium": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `architectury_inject_scalable_common_4a5b14c75657407d8325f50ce5141e38_8d39c842b7d586f0ee1bdd386a3e746aa742b45f1c2424bc659b14f32fd7ee55scalablecommon105262devjar/PlatformMethods.java` | `` |  | getCurrentTarget |
| top-level / `com/jeff/scalable/fabric/client/ScalableFabricClient.java` | `` |  | onInitializeClient |
| top-level / `com/jeff/scalable/fabric/ScalableFabric.java` | `` |  | onInitialize |
| top-level / `com/jeff/scalable/mixin/InGameHUDMixin.java` | `value={Gui.class})` | Inject:1 | setScreen |
| top-level / `com/jeff/scalable/mixin/OptionsScreenMixin.java` | `value={VideoSettingsScreen.class})` | Inject:1 | addOptions, toString, toString, toString, toString |
| top-level / `com/jeff/scalable/Scalable.java` | `` |  | init |
| top-level / `com/jeff/scalable/ScalableConfig.java` | `` |  |  |
| top-level / `com/jeff/scalable/ScalableSodiumPage.java` | `` |  | registerConfigLate, format |
| top-level / `com/jeff/scalable/Validator.java` | `` |  | min, max, step |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
