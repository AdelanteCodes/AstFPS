# SignalLoss

Review status: **Evidence inventory; behavioral review pending**

Project: [SignalLoss](https://modrinth.com/mod/signalloss)
Selected artifact version: `1.3.0+26.3`
Published implementation source: https://github.com/hexandcube/SignalLoss/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Get notified when your server connection is interrupted

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `8aa28aac30c12c4e7519654d679f305bb949a4bd`
- `sha512`: `c1bf6a77c0bd54073e6b98d672283a3303cb4545d5cf9cabd10cd02f70feb66e89ef81fae6cea837858a2d1ef2f6e8a45cfcb58e1a2c474f054c02eb7c807666`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 6
Reconstructed Java files: 4

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.hexandcube.signalloss.client.SignalLossClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/hexandcube/signalloss/client/SignalLossClient.java` | `` |  | onInitializeClient, render, resetAll, resetLogicState, renderToast |
| top-level / `com/hexandcube/signalloss/commands/SignalLossCommands.java` | `` |  | register, parseColor |
| top-level / `com/hexandcube/signalloss/config/SignalLossConfig.java` | `` |  | load, save, reset |
| top-level / `com/hexandcube/signalloss/mixin/ClientConnectionMixin.java` | `value={Connection.class})` | Inject:1 | onPacketReceived |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
