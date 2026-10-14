# STFU Disconnect

Review status: **Behavioral static review**

Project: [STFU Disconnect](https://modrinth.com/mod/stfudisconnect)
Selected artifact version: `4.0.0`
Published implementation source: https://github.com/WFPhantom/stfudisconnect/issues
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

this makes disconnect be quiet :)

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `5684a1eca9c1caeb246580643b2c252bd1db5d74`
- `sha512`: `a36aa0f047c72b9fa95fe9c5a205a6371df65012dda73f036d97f0826c3b3a82b44cd6e003f1b43fc2d97de798a60c3cd95198eb9007944f5bbf43430007883a`

## Reviewed mechanism

Both reconstructed classes reviewed.

- Within Connection.exceptionCaught, substitutes SERVERBOUND as the reported sending packet flow when the current listener protocol is STATUS or HANDSHAKING.
- Other protocols call the original flow getter. This changes exception-path decisions without replacing the transport or codecs.

## Lifecycle, correctness, and failure questions

- Misreporting flow can suppress or change disconnect handling, not just shorten a log line. Confirm the surrounding vanilla exception logic for the selected version.

## Checks needed to establish equivalence

- Inspect the caller branch using the substituted flow and test failed handshakes, status pings, ordinary play errors, and channel closure.

## Relevance to Xe-Mod

Exception-path workaround, not a steady-state optimization.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 2
Reconstructed Java files: 2

**environment**

```json
"server"
```

**entrypoints**

```json
{
  "main": [
    "com.wfphantom.STFUDisconnect"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/wfphantom/mixin/ConnectionMixin.java` | `value={Connection.class})` | WrapOperation:1 | shutthefuckup |
| top-level / `com/wfphantom/STFUDisconnect.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
