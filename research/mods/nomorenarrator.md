# No More Narrator

Review status: **Behavioral static review**

Project: [No More Narrator](https://modrinth.com/mod/nomorenarrator)
Selected artifact version: `26.3-1.1`
Published implementation source: https://github.com/dervarex/NoMoreNarrator
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Removes the annoying narrator that toggles on CTRL + B

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `c13e86dfdfd7ce6c6418038763682a0703189c5b`
- `sha512`: `3d9b6b0d0cba468c5ca031a82bd24cf6b5fd07159570838a01b602e1a43ea218053fd59f0d42c32b03ffe20b7016277fed0149c1210f3a7247e1d3ef857ac074`

## Reviewed mechanism

All four reconstructed classes reviewed.

- On every client tick, forces narrator status to OFF and narrator hotkey to false when needed.
- A narrator active hook always returns false. The remaining initializer/data-generator code adds no optimization path.

## Lifecycle, correctness, and failure questions

- Overrides user accessibility choices and adds per-tick option checks. Does not show avoidance of native narrator construction itself.

## Checks needed to establish equivalence

- Check toggles, saved options, narration startup cost, and whether interface/default-method interception applies to actual implementations.

## Relevance to AstFPS

Feature disabling rather than equivalent work reduction.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 4
Reconstructed Java files: 4

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "fabric-datagen": [
    "com.dervarex.nomorenarrator.client.NomorenarratorDataGenerator"
  ],
  "client": [
    "com.dervarex.nomorenarrator.client.NomorenarratorClient"
  ],
  "main": [
    "com.dervarex.nomorenarrator.Nomorenarrator"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "~26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/dervarex/nomorenarrator/client/NomorenarratorClient.java` | `` |  | onInitializeClient |
| top-level / `com/dervarex/nomorenarrator/client/NomorenarratorDataGenerator.java` | `` |  | onInitializeDataGenerator |
| top-level / `com/dervarex/nomorenarrator/mixin/client/NarratorManagerMixin.java` | `value={Narrator.class})` | Inject:1 | disableNarrator |
| top-level / `com/dervarex/nomorenarrator/Nomorenarrator.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
