# Async Hotbars

Review status: **Behavioral static review**

Project: [Async Hotbars](https://modrinth.com/mod/hotbar-lag-fixer)
Selected artifact version: `1.1.1`
Published implementation source: https://github.com/xpncvr/hotbar-lag-fixer
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Minecraft mod that reduces brief hotbar lag by handling large item data asynchronously, preventing client freezes when saving or opening the creative saved item hotbar. Fixes freeze stutter when saving hotbars.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `fba165905dc446a09cfbab365bfc503aff45b80352ff036105bb1840b5a43c0174556ed381f8e5b446ebba51355f6febf2a3fe0d919fe9b0c8500f8443c48ea4`
- `sha1`: `dcf1671112b94750098b12d87b224127e8a6c2bf`

## Reviewed mechanism

Both reconstructed classes reviewed.

- Registers a CLIENT_STARTED callback from the hotbar manager constructor, then calls get(0) to eagerly trigger saved-hotbar loading.
- Cancels HotbarManager.save and submits an asynchronous task that reads nine hotbars, codec-encodes them into a versioned CompoundTag, and writes the original options file.

## Lifecycle, correctness, and failure questions

- The worker reads live hotbar objects without a shown immutable snapshot. Concurrent edits and overlapping save tasks can produce inconsistent or out-of-order writes.
- The shared async pool and direct file writes require shutdown, exception, and persistence-order checks. Eager loading shifts work to startup rather than eliminating it.

## Checks needed to establish equivalence

- Edit while saving, request multiple saves, exit immediately after save, inject I/O failure, and verify the last intended state survives restart.

## Relevance to AstFPS

Creative saved-hotbar stutter; useful problem domain, but the observed concurrency pattern needs stronger guarantees.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 2
Reconstructed Java files: 2

**depends**

```json
{
  "minecraft": "~26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `hotbar/lag/fixer/Main.java` | `` |  | onInitialize |
| top-level / `hotbar/lag/fixer/mixin/HotbarManagerMixin.java` | `value={HotbarManager.class})` | Inject:2 | preload, saveAsync |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
