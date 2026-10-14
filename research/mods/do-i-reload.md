# Do I Reload?

Review status: **Behavioral static review**

Project: [Do I Reload?](https://modrinth.com/mod/do-i-reload)
Selected artifact version: `1.1`
Published implementation source: https://github.com/bikkypuff/Do-I-Reload
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Only reload the Resource Packs if a change was actually made! The fix for MC-267868.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `148cac8c82e4093c8b0c2acad429cbf5d4221bbd64c345a920538a86e3ca348e0a8a21359ac7590a51f797cafee767ab9a75fe2fec5f402deafc9f00d988cc98`
- `sha1`: `41830e53a90685ab5c98b72b1f1d8a98ec410fb2`

## Reviewed mechanism

All three reconstructed classes reviewed; advertised intent and the observed hook differ.

- Cancels PackSelectionScreen.onClose after committing the selection model. Calls closeWatcher only when its hasChanges field is true.
- The available source shows a newly declared hasChanges field but no assignment or event that sets it. The advertised change detection is therefore not established by this artifact's reconstructed implementation.

## Lifecycle, correctness, and failure questions

- Cancelling the original close method can skip screen transition or watcher cleanup. A missing change-state update can leave the conditional permanently false.
- Need original-source/bytecode verification before concluding this is a real upstream defect.

## Checks needed to establish equivalence

- Inspect field writes in bytecode, close the screen with changed/unchanged selection, edit pack files while the screen is open, and check watcher lifecycle.

## Relevance to Xe-Mod

Avoiding redundant resource reload is useful; this specific observed hook is not evidence of a working optimization.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 3
Reconstructed Java files: 3

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "com.doireload.DoIReload"
  ],
  "client": [
    "com.doireload.client.DoIReloadClient"
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
| top-level / `com/doireload/client/DoIReloadClient.java` | `` |  | onInitializeClient |
| top-level / `com/doireload/client/mixin/SkipIfNotNeeded.java` | `value={PackSelectionScreen.class})` | Inject:1 | closeWatcher, PackSelectionScreen$onClose |
| top-level / `com/doireload/DoIReload.java` | `` |  | onInitialize, id |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
