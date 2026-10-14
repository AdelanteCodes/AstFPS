# Fast IP Ping

Review status: **Behavioral static review**

Project: [Fast IP Ping](https://modrinth.com/mod/fast-ip-ping)
Selected artifact version: `v1.0.12-mc26.3`
Published implementation source: https://github.com/Fallen-Breath/fast-ip-ping
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Yeet the laggy reversed DNS lookup for literal IP server addresses

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `7db094c0a3f4c0d272d41c800838c57fe6bb823e`
- `sha512`: `b81e57aff8e161d75a1ca84576db89c7a0d874da50eb7f8ca17c3391bf75be2243db3d56a76294abdf84bca81eb78bb2613c380f4ab70f0f2c7119f08703b813`

## Reviewed mechanism

All six top-level reconstructed classes reviewed.

- Patches the InetAddress obtained during server address resolution only when the supplied host is a numeric IPv4/IPv6 address.
- Reconstructs the address from the same address bytes and an explicit numeric host string. Subsequent hostname access therefore avoids needing reverse DNS for a literal IP.
- Domain names retain the ordinary resolution path. Two version-specific mixin classes target a dummy class and contain no active hooks in this artifact.

## Lifecycle, correctness, and failure questions

- Targets a generated resolver lambda and an assignment site, which may move between game versions. IPv6 scoped addresses and literal parsing require care.
- This does not bypass DNS for ordinary domains or increase network bandwidth.

## Checks needed to establish equivalence

- Compare address bytes, IPv4/IPv6 connection behavior, hostname connections, and resolver time with deliberately slow reverse DNS.

## Relevance to Xe-Mod

Connection/server-list latency; no direct rendering FPS optimization.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 6
Reconstructed Java files: 6

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "me.fallenbreath.fastipping.FastIpPingMod::fabricInit"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.11.4",
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/fallenbreath/fastipping/FastIpPingMod.java` | `` |  | fabricInit |
| top-level / `me/fallenbreath/fastipping/impl/InetAddressPatcher.java` | `` |  | patch |
| top-level / `me/fallenbreath/fastipping/mixins/AddressResolverMixin.java` | `value={ServerAddressResolver.class})` | ModifyVariable:1 | setHostnameToIpAddressToAvoidReversedDnsLookupOnGetHostname |
| top-level / `me/fallenbreath/fastipping/mixins/ConnectScreenThreadMixin.java` | `value={DummyClass.class})` |  |  |
| top-level / `me/fallenbreath/fastipping/mixins/MultiplayerServerListPingerMixin.java` | `value={DummyClass.class})` |  |  |
| top-level / `me/fallenbreath/fastipping/utils/DummyClass.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
