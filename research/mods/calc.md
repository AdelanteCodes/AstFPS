# Calculator

Review status: **Evidence inventory; behavioral review pending**

Project: [Calculator](https://modrinth.com/mod/calc)
Selected artifact version: `1.1.0+26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This project adds a command that allows you to complete math calculations inside your game.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `4015bc4b0118cb897b1f1c38ce929c89398146a1198daf1cd94a3bcc6c32eadb5aca346b41b56d4d3f020094f7839456adf2c0cdbabf1111d03d10516e4b2381`
- `sha1`: `1f0105cc8602b12261d89de9f4a24790a5cb9e37`

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
"client"
```

**entrypoints**

```json
{
  "client": [
    "io.github.evphub.calculator.CalculatorClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "=26.3",
  "java": ">=25",
  "fabric-api": ">=0.162.0+26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/github/evphub/calculator/CalculatorClient.java` | `` |  | onInitializeClient |
| top-level / `io/github/evphub/calculator/ExpressionEvaluator.java` | `` |  | evaluate, sum, product, primary, take, finite, invalid |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
