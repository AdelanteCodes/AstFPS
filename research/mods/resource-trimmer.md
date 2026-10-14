# Resource Trimmer

Review status: **Behavioral static review**

Project: [Resource Trimmer](https://modrinth.com/mod/resource-trimmer)
Selected artifact version: `26.3.0.1`
Published implementation source: https://github.com/Darkhax-Minecraft/Resource-Trimmer
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Reduces unnecessary network overhead.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha1`: `8890fbb3673738fdadd14ae473dd1a579e0decf7`
- `sha512`: `0bbc7fb105c56467fcaccc77d9dd03a5397b4ea6878e5ca5ef7034ed6a3a72eb29b6bbed5f700e693be2ec956b43bbdb103dca35feb50b83ebd7c561a626537a`

## Reviewed mechanism

All four reconstructed classes reviewed.

- When serializing an Identifier in the default minecraft namespace, writes only its path instead of the namespace-prefixed string.
- Replaces the Identifier stream codec with UTF-8 mapping whose decoder uses Identifier.parse and whose encoder applies the same default-namespace shortening. Non-default namespaces keep their complete strings.

## Lifecycle, correctness, and failure questions

- Requires receiver parsing to assign the omitted namespace identically. External protocol consumers may expect an explicitly qualified string.
- Savings depend on how many identifiers are sent; parsing and allocations remain. Compatibility includes wire semantics, not only local round trips.

## Checks needed to establish equivalence

- Round-trip default/custom namespaces and malformed IDs through both encoding paths, connect to ordinary clients/servers, and measure actual encoded bytes.

## Relevance to AstFPS

Small network payload reduction; not a general rendering FPS improvement.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 4
Reconstructed Java files: 4

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "net.darkhax.resourcetrimmer.fabric.ResourceTrimmerFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": ">=26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/darkhax/resourcetrimmer/common/mixin/patch/MixinFriendlyByteBuf.java` | `value={FriendlyByteBuf.class})` | Inject:1 | writeResourceLocation, writeUtf |
| top-level / `net/darkhax/resourcetrimmer/common/mixin/patch/MixinResourceLocation.java` | `value={Identifier.class})` | Inject:1 | inject |
| top-level / `net/darkhax/resourcetrimmer/common/ResourceTrimmer.java` | `` |  |  |
| top-level / `net/darkhax/resourcetrimmer/fabric/ResourceTrimmerFabric.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
