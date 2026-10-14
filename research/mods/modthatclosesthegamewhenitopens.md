# Mod That Closes The Game When It Opens

Review status: **Behavioral static review**

Project: [Mod That Closes The Game When It Opens](https://modrinth.com/mod/modthatclosesthegamewhenitopens)
Selected artifact version: `1.0.0`
Published implementation source: https://tangled.org/sylv.gay/modthatclosesthegamewhenitopens
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

The mod that closes the game when it opens.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `fa8f818d1725c76564e1c246b4ddac344a5c9c50`
- `sha512`: `e81036e061c4284b5d2ddf790b827460b459c6d069d0920965c873cfd90df30611d866af6ee43bc3a7ddc9d247790418374d508f085f0470f5342c999da601d0`

## Reviewed mechanism

Entire one-class implementation reviewed.

- The Fabric initialization callback calls System.exit(0). There is no rendering, memory, networking, or simulation optimization.

## Lifecycle, correctness, and failure questions

- Installing the mod intentionally terminates the game during startup.

## Checks needed to establish equivalence

- Static call-path inspection is enough to identify the terminating behavior; no execution needed for this research.

## Relevance to AstFPS

Joke/utility result; excluded from performance research candidates.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 1
Reconstructed Java files: 1

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "gay.sylv.modthatclosesthegamewhenitopens.Modthatclosesthegamewhenitopens"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `gay/sylv/modthatclosesthegamewhenitopens/Modthatclosesthegamewhenitopens.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
