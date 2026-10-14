# Thiepine

Review status: **Behavioral static review**

Project: [Thiepine](https://modrinth.com/mod/thiepine)
Selected artifact version: `1.1.1+mc26.3`
Published implementation source: https://gitlab.com/apladokimes/thiepine
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Thiepine stops Minecraft from allocating 4 objects every time it checks if a block touches an entity. Your garbage collector gets a break, your frametime graph gets flatter.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `af856961f0841978fb88973915745b58ab6033df`
- `sha512`: `8ca4f1c03c54dfbb11f98e7498fc0007f6d703b9b8a9e6c13003dab9c7844aee50478d1aeec085c9b3c3ddf0e52006c15b5a50c7593514321f257046236d794e`

## Reviewed mechanism

All three reconstructed classes reviewed.

- Before translating a candidate collision VoxelShape, obtains its axis bounds and adds the integer block offset. If that translated enclosing box cannot intersect the entity query box, returns the shared empty shape without constructing the translated shape.
- For potentially intersecting candidates it performs the ordinary shape translation. This is a conservative broad-phase rejection, not a replacement for precise shape collision.
- A second hook returns the existing immutable AABB for a zero-vector translation. Atomic counters and exponentially spaced logging report skipped translations.

## Lifecycle, correctness, and failure questions

- Broad-phase intersection must have identical boundary semantics to the later exact test. Unusual shapes, non-finite bounds, and overlapping collision optimizations need checks.
- Atomic accounting in a hot path has a cost; the reported four objects per skipped translation is an estimate, not an allocation profile.

## Checks needed to establish equivalence

- Differentially test movement/collision against vanilla on slabs, stairs, fences, pistons, negative coordinates, exact touching faces, empty shapes, and randomized shapes. Profile allocations and CPU separately.

## Relevance to AstFPS

Promising allocation-reduction principle that can preserve visuals and collision behavior when proven conservative.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 3
Reconstructed Java files: 3

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "net.thiepine.ThiepineMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.0",
  "minecraft": ">=26.1 <27",
  "java": ">=25"
}
```

**breaks**

```json
{
  "fabricloader": "<0.19.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/thiepine/mixin/BlockCollisionsMixin.java` | `value={BlockCollisions.class})` | Redirect:1 | thiepine$earlyAABBCheck |
| top-level / `net/thiepine/mixin/EntityMixin.java` | `value={Entity.class})` | Redirect:1 | thiepine$skipZeroAABBMove |
| top-level / `net/thiepine/ThiepineMod.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
