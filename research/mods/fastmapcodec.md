# FastMapCodec

Review status: **Behavioral static review**

Project: [FastMapCodec](https://modrinth.com/mod/fastmapcodec)
Selected artifact version: `1.0.4`
Published implementation source: https://github.com/nekotxs/fastmapcodec
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Provides more efficient BaseMapCodec.decode implementation

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `37fac0eb1a9689a0be3de00c32f00c64586a7629`
- `sha512`: `bf38ad840858d7e1c7e1ff8755035b004b20e013003216b581b9ae958ecff39e1746e87da326ce93e1b9543ffd3046f945a84d49d9066c211275abfe216f9af6`

## Reviewed mechanism

All five reconstructed classes reviewed.

- Replaces BaseMapCodec decoding with a fast successful-input pass: materializes entries, parses keys and values, and inserts them into an immutable-map builder.
- If parsing fails or the builder detects duplicate keys, re-runs the complete input through an error-preserving fallback that accumulates partial values and missed input. Encoding still iterates every key/value through the codecs.
- A marker interface and startup probe report whether the codec mixin was applied.

## Lifecycle, correctness, and failure questions

- Calling result() and creating a fresh success can discard Lifecycle information returned by successfully parsed keys/values. Successful decoding equivalence includes metadata, not only the resulting map.
- Fallback reparses entries, so custom codecs with side effects or nondeterministic results may observe additional calls. Materializing the entry stream also consumes memory.

## Checks needed to establish equivalence

- Compare success values, lifecycle metadata, duplicate-key diagnostics, partial failures, iteration order, and codec invocation counts against the original. Benchmark successful and failing inputs separately.

## Relevance to AstFPS

Serialization/load-time optimization candidate; not a direct per-frame rendering optimization.

Research only. No implementation is being added during this research pass.

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
    "dev.neko.fastmapcodec.FastMapCodecFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": ">=1.21",
  "java": ">=21"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/neko/fastmapcodec/Constants.java` | `` |  |  |
| top-level / `dev/neko/fastmapcodec/FastMapCodecFabric.java` | `` |  | onInitialize |
| top-level / `dev/neko/fastmapcodec/mixin/BaseMapCodecMixin.java` | `value={BaseMapCodec.class})` |  | fallbackDecode$fastmapcodec |
| top-level / `dev/neko/fastmapcodec/tests/FastMapCodecApplied.java` | `` |  |  |
| top-level / `dev/neko/fastmapcodec/tests/TestMixinApplied.java` | `` |  | logIfApplied |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
