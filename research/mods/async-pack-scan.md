# Async Pack Scan

Review status: **Behavioral static review**

Project: [Async Pack Scan](https://modrinth.com/mod/async-pack-scan)
Selected artifact version: `26.3.0`
Published implementation source: https://git.frohnmeyer-wds.de/JfMods/async-pack-scan
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Speeds up the resource pack organizer screen

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `88fb00008e3ae0d8d2e7a32524c4c7e6fc811ca6`
- `sha512`: `a72d8026d82ef00ea386e838a46f2cef458f54aecd724a0d1994431653dbd0e62acaebb50695b864b66bf06da13d32e20cc92b86c239d9573fa1cfdf061632c7`

## Reviewed mechanism

Top-level implementation reviewed; embedded Fabric resource-loader implementation is a dependency, not reviewed here.

- Adds an asynchronous reload interface to PackRepository. A common ForkJoinPool task invokes repository.reload and then a completion callback.
- PackSelectionModel replaces synchronous discovery with one running scan and one coalesced follow-up request. Separate reentrant locks protect scan state and selected/unselected pack collections.
- After discovery it retains still-available selections, rebuilds the unselected list, and removes hidden Fabric packs. Stream access is materialized under the resource lock so callers do not traverse a list being changed by the worker.
- Committing selected packs waits for the outstanding Future before accessing repository state. VoidFuture adapts arbitrary task completion to Future<Void>.

## Lifecycle, correctness, and failure questions

- Moving repository reload to a shared pool requires every invoked pack provider to tolerate that thread. Locking the selection lists does not establish thread safety of external providers.
- The callback reads a one-element Future holder assigned after submit. A sufficiently fast worker could observe the holder before assignment; this is a static concurrency concern, not a reproduced upstream failure.
- Reload/callback exceptions can prevent the scan-finished state transition. Interrupt handling and failure cleanup need explicit tests.

## Checks needed to establish equivalence

- Exercise overlapping scan requests, close/commit during scanning, cancellation, provider exceptions, hidden packs, and interruption. Verify selection order and repository contents match a synchronous baseline.

## Relevance to AstFPS

Resource-pack menu responsiveness; no direct steady-state playing FPS benefit, especially with no external packs.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 9
Reconstructed Java files: 7

**environment**

```json
"*"
```

**depends**

```json
{
  "fabricloader": ">=0.12.0",
  "minecraft": "*",
  "libjf-base": ">=2.1.3"
}
```

**accessWidener**

```json
"async-pack-scan.accesswidener"
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/fabric-resource-loader-v1-3.0.4+fcdff87f02.jar` | 77 | `fabric-resource-loader-v1` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/jfronny/aps/AsyncResourcePackManager.java` | `` |  |  |
| top-level / `dev/jfronny/aps/client/impl/ResourcePackOrganizerLockState.java` | `` |  | lockResources, emitScanFinished, requestScan, ScanFinishedResponse, RequestScanResponse |
| top-level / `dev/jfronny/aps/client/impl/SafeCloseable.java` | `` |  |  |
| top-level / `dev/jfronny/aps/client/mixin/PackSelectionModelMixin.java` | `value={PackSelectionModel.class})` | Overwrite:1, WrapMethod:2 | findNewPacks, aps$startScan, aps$afterScan, filterFabricPacks, joinAsyncScan, synchronizeEntryAccess |
| top-level / `dev/jfronny/aps/impl/AsyncPackScan.java` | `` |  |  |
| top-level / `dev/jfronny/aps/impl/VoidFuture.java` | `` |  | cancel, isCancelled, isDone, get, get |
| top-level / `dev/jfronny/aps/mixin/PackRepositoryMixin.java` | `value={PackRepository.class})` |  | aps$scanPacksAsync |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
