# Disconnect Packet Fix

Review status: **Behavioral static review**

Project: [Disconnect Packet Fix](https://modrinth.com/mod/disconnect-packet-fix)
Selected artifact version: `2.3.0-fabric`
Published implementation source: https://github.com/ascpixi/disconnect-packet-fix
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Works around the MC-271325 bug on Fabric and NeoForge servers (fixes "error sending packet clientbound/minecraft:disconnect")

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `7d08b1d82df696d4e1899a7d535be530991b6894a250c75e902214aea6b9505abd7312fe09dcae4512b7f2367cf77a021364226ec5a875c46f820ceaaa2535c1`
- `sha1`: `f42a4a4594bb313b7e6313719f592cb65c27f1dd`

## Reviewed mechanism

All three reconstructed classes reviewed.

- Intercepts IdDispatchCodec.encode before encoding. It obtains the packet type and checks whether that type exists in the active protocol's ID map.
- Cancels only an unmapped type whose string representation matches the disconnect packet type. Valid mapped disconnect packets and other packet types continue normally.

## Lifecycle, correctness, and failure questions

- The workaround suppresses encoding in one protocol mismatch case; it does not repair the protocol transition itself. String matching depends on the packet type representation.
- Cancellation must not leave a surrounding packet encoder expecting bytes that were never written.

## Checks needed to establish equivalence

- Exercise disconnects during login/configuration/play transitions, valid disconnects, unrelated unmapped packets, and connection cleanup.

## Relevance to AstFPS

Protocol robustness, not steady-state FPS.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 3
Reconstructed Java files: 3

**environment**

```json
"server"
```

**entrypoints**

```json
{
  "main": [
    "dev.ascpixi.dpf.fabric.DisconnectPacketFixFabric"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/ascpixi/dpf/DisconnectPacketFix.java` | `` |  | init |
| top-level / `dev/ascpixi/dpf/fabric/DisconnectPacketFixFabric.java` | `` |  | onInitialize |
| top-level / `dev/ascpixi/dpf/mixin/ConnectionMixin.java` | `value={IdDispatchCodec.class})` | Inject:1 | encodeMixin |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
