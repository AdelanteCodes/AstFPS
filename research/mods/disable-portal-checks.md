# Disable Portal Checks

Review status: **Behavioral static review**

Project: [Disable Portal Checks](https://modrinth.com/mod/disable-portal-checks)
Selected artifact version: `1.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Disable unnecessary portal checks that cause lag.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `6b354e0164c10df11941d3a301b33824291748e3`
- `sha512`: `ee92ad1d229081643bace5a043b9b33111daeb92bb06642e0c2a680a436961102a58f1606a82b2910461a4711c56bf7753abc1737c986a868899387d5357249e`

## Reviewed mechanism

All four reconstructed classes reviewed; two contain initialization/empty example hooks.

- Intercepts the portal-placement open-position search and immediately returns its supplied fallback position.
- Skips searching for a suitable open destination rather than accelerating an equivalent search. Some reconstructed Minecraft class names remain intermediary names.

## Lifecycle, correctness, and failure questions

- Can change destination placement and collision/suffocation outcomes around portals. Exact class/method mapping must be verified for the artifact's game version.

## Checks needed to establish equivalence

- Compare exits into obstructed areas, oversized entities, portals at borders, and destination collision outcomes.

## Relevance to AstFPS

Removes a gameplay correctness check; not a behavior-preserving optimization.

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
    "net.soronto.disable_portal_checks.DisablePortalChecks"
  ],
  "client": [
    "net.soronto.disable_portal_checks.DisablePortalChecksClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.15.3",
  "minecraft": ">=1.19.3",
  "java": ">=17",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/soronto/disable_portal_checks/DisablePortalChecks.java` | `` |  | onInitialize |
| top-level / `net/soronto/disable_portal_checks/DisablePortalChecksClient.java` | `` |  | onInitializeClient |
| top-level / `net/soronto/disable_portal_checks/mixin/client/ExampleClientMixin.java` | `value={class_310.class})` | Inject:1 | run |
| top-level / `net/soronto/disable_portal_checks/mixin/DisablePortalChecks.java` | `value={class_2424.class})` | Inject:1 | init |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
