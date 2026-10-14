# Resource Gamma Util / Fullbright

Review status: **Evidence inventory; behavioral review pending**

Project: [Resource Gamma Util / Fullbright](https://modrinth.com/mod/resource-gamma-utils)
Selected artifact version: `26.3-2.0.3`
Published implementation source: https://github.com/Stein-N/Resource-Gamma-Utils
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Gamma / Fullbright, making it easy to see in the dark.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `1f618181af8b0899c9059af7650b930258c667c48fb3a46f27c64ffe8829709fa19132a85617fad1c766c2f9b62ec324960b45cc3efb459fd0d1aeba6ff5fa76`
- `sha1`: `7ef2be3578a8a0a2d6dc7f3f8783bf09970fc152`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 6
Reconstructed Java files: 6

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "net.morthen.resource_gamma_util.ResourceGammaUtils"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": ">=0.160.6+26.3",
  "minecraft": "26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/morthen/resource_gamma_util/GammaConstants.java` | `` |  | useHotkey |
| top-level / `net/morthen/resource_gamma_util/mixins/compat/IrisMixin.java` | `value={Iris.class})` | Inject:1 | resource_gamma_util$toggleShader |
| top-level / `net/morthen/resource_gamma_util/mixins/OptionInstanceMixin.java` | `value={OptionInstance.class})` | Inject:1 | resource_gamma_util$set |
| top-level / `net/morthen/resource_gamma_util/ResourceGammaUtils.java` | `` |  | onInitializeClient |
| top-level / `net/morthen/resource_gamma_util/service/FabricGammaHelper.java` | `` |  | isIrisLoaded, isShaderEnabled |
| top-level / `net/morthen/resource_gamma_util/service/IGammaHelper.java` | `` |  | load |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
