# OneHitTreeChopper

Review status: **Evidence inventory; behavioral review pending**

Project: [OneHitTreeChopper](https://modrinth.com/mod/onehittreechopper)
Selected artifact version: `3.0.1`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

OneHitTreeChopper Mod 1.20+ By NonKungCh

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha512`: `0e39c677b0e98cd5abb8d774049454f779372cf6f6cdd0d971934a31e52cb204b3bc1f5200fc0bfee507df12e72b0f5396e1a511ddcd3aa9ea9d062a8b0f27d7`
- `sha1`: `cb2b32273564f4fefb68793eac3d4ba1f6e3039e`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 5
Reconstructed Java files: 5

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "non.onehittreechopper.OneHitTreeChopperMod"
  ],
  "client": [
    "non.onehittreechopper.OneHitTreeChopperClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `non/onehittreechopper/Config.java` | `` |  | load, save |
| top-level / `non/onehittreechopper/OneHitTreeChopperClient.java` | `` |  | onInitializeClient, sendTogglePacket |
| top-level / `non/onehittreechopper/OneHitTreeChopperMod.java` | `` |  | onInitialize |
| top-level / `non/onehittreechopper/TogglePayload.java` | `` |  | type |
| top-level / `non/onehittreechopper/TreeUtils.java` | `` |  | isWood, findTreeBlocks |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
