# Cull Display Entities

Review status: **Behavioral static review**

Project: [Cull Display Entities](https://modrinth.com/mod/cull-display-entities)
Selected artifact version: `1.3.0`
Published implementation source: https://github.com/JustAlittleWolf/CullDisplayEntities
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Forces display entities to be culled, improving performance

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `bc7abd163fb45901aea70d43a0845ccd349fca3f`
- `sha512`: `d64bacb9d4e0ed935c5c5f9f8b68dc6e3c32ab5454f0f88c075871ec50de6003141aa4cb7a3b656d1e20e626b372299ebdb46b38f733fe9a76d07bdfb3fadc43`

## Reviewed mechanism

All three reconstructed classes reviewed.

- Wraps Display.updateCulling. Displays with nonzero width and height retain vanilla behavior; otherwise disables noCulling and constructs a world AABB.
- Transforms eight corners of a padded generic model cube through the display transformation, accumulates componentwise minimum/maximum, and translates the bounds to entity position.
- An invoker exposes the display's transformation construction.

## Lifecycle, correctness, and failure questions

- Generic padded cube bounds may not enclose arbitrarily long text, custom item/block models, or interpolated transforms. Conservative bounds must cover the rendered geometry at the actual partial tick.
- Min/max start at the origin, which can enlarge bounds for wholly translated geometry. Extra inclusion is safe for visibility but reduces rejection efficiency.

## Checks needed to establish equivalence

- Test text displays with long lines, nonuniform scaling, rotations, interpolation, negative scales, large custom models, and screen-edge movement.

## Relevance to AstFPS

Potentially useful display culling, but unchanged visuals require geometry-aware conservative bounds.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 3
Reconstructed Java files: 3

**environment**

```json
"client"
```

**entrypoints**

```json
{}
```

**depends**

```json
{
  "fabricloader": ">=0.19.0",
  "minecraft": ">=26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/wolfii/culldisplayentities/DisplayEntityBoundingBoxCalculator.java` | `` |  | getWithTransform |
| top-level / `me/wolfii/culldisplayentities/mixin/DisplayEntityAccessor.java` | `value={Display.class})` | Invoker:1 | invokeCreateTransformation |
| top-level / `me/wolfii/culldisplayentities/mixin/DisplayEntityMixin.java` | `value={Display.class})` | WrapMethod:1 | modifyBoundingBox |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
