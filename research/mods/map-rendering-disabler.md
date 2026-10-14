# Map Rendering Disabler

Review status: **Behavioral static review**

Project: [Map Rendering Disabler](https://modrinth.com/mod/map-rendering-disabler)
Selected artifact version: `1.0.0+26.1`
Published implementation source: https://github.com/MrKinau/MapRenderingDisablerMod
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Disables the rendering of filled maps, which can be useful for Twitch streamers who want to stream on servers with ToS violating map arts.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `60fc4a2b6f3c3025e6f6003629b43705784c2e27`
- `sha512`: `7e04f36dcfc108555520dd2f1146f10206a1b82f7383ab73074b5408f5a5d10b99b4d52c5a83d5d32e43632e5d3dd5343fb770eaa22bc85ab0729f8e0ac3855a`

## Reviewed mechanism

Both reconstructed classes reviewed.

- Unconditionally cancels MapRenderer.render at method entry. The initializer has no additional behavior.

## Lifecycle, correctness, and failure questions

- Map image content is deliberately removed from rendering; this affects held/frame maps using this path.

## Checks needed to establish equivalence

- Check held maps, item-frame maps, decorations, labels, and other map render integrations.

## Relevance to AstFPS

Content suppression utility, not unchanged-visuals optimization.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 2
Reconstructed Java files: 2

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "dev.kinau.maprenderingdisabler.MapRenderingDisablerMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "minecraft": ">=26.1",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/kinau/maprenderingdisabler/MapRenderingDisablerMod.java` | `` |  | onInitialize |
| top-level / `dev/kinau/maprenderingdisabler/mixin/MapRendererMixin.java` | `value={MapRenderer.class})` | Inject:1 | init |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
