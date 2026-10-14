# Decent Freelook

Review status: **Evidence inventory; behavioral review pending**

Project: [Decent Freelook](https://modrinth.com/mod/decentfreelook)
Selected artifact version: `1.3+26.3`
Published implementation source: https://github.com/BloodredX/DecentFreelook
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A simple freelook mod which won't affect performance of your device.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `54f2f9f30d361b2ef12ff7e17164976b1e51f6e339ab54cbbd0570fb4d11d550cebbfc76adf01b517d577a4d20898ee1611e0e2dd87d8ca7ed6cdcc0e20d50f3`
- `sha1`: `df9f4e5e88381587cc4379a94d5f93c79e7ee9e3`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 6
Reconstructed Java files: 6

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "me.bloodred.dfl.DecentFreelookClient"
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
| top-level / `me/bloodred/dfl/DecentFreelookClient.java` | `` |  | onInitializeClient |
| top-level / `me/bloodred/dfl/FreelookKeyBindings.java` | `` |  | register |
| top-level / `me/bloodred/dfl/FreelookManager.java` | `` |  | getInstance, handleKeyInput, startFreelook, stopFreelook, updateRotation, isFreelookEnabled, getCameraYaw, getCameraPitch |
| top-level / `me/bloodred/dfl/mixin/CameraMixin.java` | `value={Camera.class})` | Inject:1 | onAlignWithEntity |
| top-level / `me/bloodred/dfl/mixin/EntityMixin.java` | `value={Entity.class})` | Inject:1 | onTurn |
| top-level / `me/bloodred/dfl/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | onHandleKeybinds |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
