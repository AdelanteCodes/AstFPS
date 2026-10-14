# Faster Iris Shadow Mapper [FISM]

Review status: **Evidence inventory; behavioral review pending**

Project: [Faster Iris Shadow Mapper [FISM]](https://modrinth.com/mod/fism)
Selected artifact version: `1.0.7`
Published implementation source: https://github.com/maDU59/FasterIrisShadowMapper
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Slightly improves the speed of Iris' shadow mapper. Built-in in Iris since Iris 1.11.2

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `e89d733559a429aa511eb26b521468ceef411ce24ebeb5dab03fe6c86d1eed51f07925b1b03e28adaa7633355f4a6dc2cd7a8bc54ba7faf245c8812aa47a3caf`
- `sha1`: `316919da6f7e193035722e2ccad841e9b83babbd`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 11
Reconstructed Java files: 11

**environment**

```json
"*"
```

**entrypoints**

```json
{}
```

**depends**

```json
{
  "fabricloader": ">=0.19",
  "minecraft": ">26.2",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `fr/madu59/fastershadowmapper/client/compat/BerylCompat.java` | `` |  | startShadowPass, endShadowPass, isShadowPass |
| top-level / `fr/madu59/fastershadowmapper/client/compat/IrisCompat.java` | `` |  | isShadowPass |
| top-level / `fr/madu59/fastershadowmapper/client/compat/ModCompat.java` | `` |  | isShadowPass, classExist, isIrisLoaded |
| top-level / `fr/madu59/fastershadowmapper/client/compat/OptifineCompat.java` | `` |  | isShadowPass |
| top-level / `fr/madu59/fastershadowmapper/client/mixin/AbstractSignRendererMixin.java` | `value={AbstractSignRenderer.class})` | Inject:1 | fastershadowmapper$cancelSignTextRendering |
| top-level / `fr/madu59/fastershadowmapper/client/mixin/BannerRendererAccessor.java` | `value={BannerRenderer.class})` | Invoker:1 | fastershadowmapper$submitPatternLayerInvoke |
| top-level / `fr/madu59/fastershadowmapper/client/mixin/BannerRendererMixin.java` | `value={BannerRenderer.class})` | Inject:1 | fastershadowmapper$cancelSubmitPatterns |
| top-level / `fr/madu59/fastershadowmapper/client/mixin/compat/beryl/ShadowMapMixin.java` | `value={ShadowMap.class})` | WrapOperation:1 | fastershadowmapper$wrapRenderShadowMap |
| top-level / `fr/madu59/fastershadowmapper/client/mixin/ItemStackMixin.java` | `value={ItemStack.class})` | Inject:1 | fastershadowmapper$cancelGlintRendering |
| top-level / `fr/madu59/fastershadowmapper/client/mixin/MapRendererMixin.java` | `value={MapRenderer.class})` | Inject:1 | fastershadowmapper$cancelMapRendering |
| top-level / `fr/madu59/fastershadowmapper/client/platform/PlatformHelper.java` | `` |  | getPlatformName, isModLoaded, getConfigDir |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
