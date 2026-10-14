# OFFHand KeyBind

Review status: **Evidence inventory; behavioral review pending**

Project: [OFFHand KeyBind](https://modrinth.com/mod/offhand-keybind)
Selected artifact version: `2.0.0`
Published implementation source: https://github.com/amirgame197/OFFHand-KeyBind
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A client-side Fabric mod for Minecraft Java that separates off-hand item use from Minecraft's normal Use key.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `5dfc329c61a8e1132c47095e9a19c9f1bcfa3de2f522586fb093e0d6db19d67e09807d91739f46f8c482a5c503939dd0fda94b044d7c6d1dd2f82225f1fd0767`
- `sha1`: `37150e004abd86fb5d0b972a216978eb8e43fc1f`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 3
Reconstructed Java files: 3

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "dev.offhandkeybind.OffhandKeybindClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/offhandkeybind/mixin/MinecraftClientInvoker.java` | `value={Minecraft.class})` | Invoker:1 |  |
| top-level / `dev/offhandkeybind/mixin/MinecraftClientMixin.java` | `value={Minecraft.class})` | Redirect:3, Inject:1 | offhandkeybind$chooseOnlyOneHand, offhandkeybind$skipConflictingPickBlock, offhandkeybind$keepOffhandUseWhileHeld, offhandkeybind$handleDedicatedOffhandKey, offhandkeybind$useOffhandOnly, offhandkeybind$sharesBindingWith |
| top-level / `dev/offhandkeybind/OffhandKeybindClient.java` | `` |  | onInitializeClient, isOffhandUseActive, useOffhandOnly |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
