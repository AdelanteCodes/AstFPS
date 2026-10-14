# Yggdrasil Proxy

Review status: **Evidence inventory; behavioral review pending**

Project: [Yggdrasil Proxy](https://modrinth.com/mod/yggdrasil-proxy)
Selected artifact version: `26.06.1-fabric`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

The proxy in the device is automatically read to speed up Yggdrasil verification.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha512`: `062334838cd0dce61fccc6fe998e6549a0912ca9f654a3a88e61856bc2227ab1d376f7c6da66261b54bff1e088efb302834fc8e6ce4f259d67a833478a01bc77`
- `sha1`: `e9a4c2dc4f7e7ffe8079d4ace212efcfe93299d8`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 2
Reconstructed Java files: 2

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "one.tranic.yggdrasilproxy.YggdrasilProxy"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": [
    ">=26.1"
  ]
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/t-proxy-1.0.0.jar` | 5 | `one_tranic_t-proxy` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `one/tranic/yggdrasilproxy/mixin/HttpAuthenticationServiceMixin.java` | `value={HttpAuthenticationService.class})` | Inject:1 | init |
| top-level / `one/tranic/yggdrasilproxy/YggdrasilProxy.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
