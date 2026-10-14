# RecipeCooldown

Review status: **Behavioral static review**

Project: [RecipeCooldown](https://modrinth.com/mod/recipecooldown)
Selected artifact version: `1.1.0+26.2`
Published implementation source: https://github.com/AmberIsFrozen/RecipeCooldown
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Prevents player from spamming excessive recipe book packets to lag out the server

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `d74a5fc172e65a04e68d88735aea232792105478`
- `sha512`: `fc43d4ae1310cb526bb0c31c26b328f7f8030347f03afca078643b2b758568834a90cf3b978e54c607bb5bb648947cf4090a928dfc5f067d6881b2d4a3848e42`

## Reviewed mechanism

All four top-level reconstructed classes reviewed; embedded config library not reviewed.

- At server recipe-placement packet entry, compares wall-clock time to the last accepted craft request by player UUID. Cancels requests within the configured cooldown, default 50 milliseconds.
- A tail hook records the current time after accepted requests. Configuration supports enable/disable and migrates a legacy first-line delay file to the current format.

## Lifecycle, correctness, and failure questions

- Rate limiting drops gameplay requests rather than processing them faster. Wall-clock adjustments can affect cooldown comparisons.
- No logout cleanup of the UUID-to-time map is shown. Long-running servers with many distinct players can retain entries.

## Checks needed to establish equivalence

- Test boundary timing, rapid requests, disabled mode, reconnects, wall-clock changes, malformed legacy config, and long-run map size.

## Relevance to Xe-Mod

Server request-rate protection, not behavior-preserving FPS optimization.

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
    "com.lx862.recipecooldown.RecipeCooldown"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16.0",
  "minecraft": ">=26.1"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/kaleido-config-0.3.3+1.3.2.jar` | 215 | `folk_sisby_kaleido-config` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/lx862/recipecooldown/config/Config.java` | `` |  | init |
| top-level / `com/lx862/recipecooldown/config/LegacyConfig.java` | `` |  | migrate |
| top-level / `com/lx862/recipecooldown/mixin/ServerPlayNetworkHandlerMixin.java` | `value={ServerGamePacketListenerImpl.class})` | Inject:2 | onCraftRequestStart, onCraftRequest |
| top-level / `com/lx862/recipecooldown/RecipeCooldown.java` | `` |  | onInitialize |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
