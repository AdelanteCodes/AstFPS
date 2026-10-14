# WaterLightingFix

Review status: **Evidence inventory; behavioral review pending**

Project: [WaterLightingFix](https://modrinth.com/mod/waterlightingfix)
Selected artifact version: `1.0.1`
Published implementation source: https://github.com/dopadream/WaterLightingFix
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Fixes MC-227302 (and MC-235474) without Sodium

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `3bc0f65b7802289283c5cd18f311c7b4c451a3e7`
- `sha512`: `309549e9a485479142a0838159e75958c5ef44688ca35eed994987dac367874ff4a0884c388f5e7629a805dbb4694f8a1c4a057e7eae67a86a4fcfd6e3317534`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 7
Reconstructed Java files: 7

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.dopadream.waterfix.WaterLightingFix"
  ],
  "client": [
    "com.dopadream.waterfix.client.WaterLightingFixClient"
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
| top-level / `com/dopadream/waterfix/client/AoFluidVertexConsumer.java` | `` |  | applyAo, lerpLight, addVertex, setLight, fluidLight, computeSmoothLight, isOccluder, setColor, setColor, setUv, setUv1, setUv2, setUv3, setNormal, setLineWidth |
| top-level / `com/dopadream/waterfix/client/config/WaterfixConfig.java` | `` |  | writeTo, readFrom, getFile, getWaterAOOption, save, load, boolFrom |
| top-level / `com/dopadream/waterfix/client/mixin/FluidRendererMixin.java` | `value={FluidRenderer.class})` | ModifyVariable:1 | waterlightingfix$wrapOutput |
| top-level / `com/dopadream/waterfix/client/mixin/VideoOptionsScreenMixin.java` | `value={VideoSettingsScreen.class})` | ModifyArg:1 | waterlightingfix$addWaterAOOptionButton |
| top-level / `com/dopadream/waterfix/client/WaterLightingFixClient.java` | `` |  | onInitializeClient |
| top-level / `com/dopadream/waterfix/mixin/PowderSnowBlockMixin.java` | `value={BlockBehaviour.class})` | Inject:1 |  |
| top-level / `com/dopadream/waterfix/WaterLightingFix.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
