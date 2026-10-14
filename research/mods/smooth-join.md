# Smooth Join

Review status: **Behavioral static review**

Project: [Smooth Join](https://modrinth.com/mod/smooth-join)
Selected artifact version: `1.3.2`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Eliminates lag spikes when joining a world by dynamically adjusting render distance.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `37e38e1a97ec46c2b32c862e771933b209c22e6c`
- `sha512`: `275ff1cea22c3e04e4ced2e364161b09bc8404b9b350bcebf9cbe09813c67379c5229e118dd5f6991fafbe81d65964048d5f497ee0887ba5cbf3d0fcb7f0d072`

## Reviewed mechanism

All four reconstructed classes reviewed.

- At play-connection initialization, saves the current render distance and lowers it to two chunks when enabled for that connection type.
- After join, waits 100 client ticks, then restores two chunks every 20 ticks until the original distance is reached. Disconnect restores immediately and resets state.
- Singleplayer and multiplayer switches are persisted in JSON and exposed through a config screen.

## Lifecycle, correctness, and failure questions

- Temporarily changes visible distance and chunk request/render workload. A user changing render distance during restoration can have their change overwritten by the saved original.

## Checks needed to establish equivalence

- Test interrupted joins, quick reconnects, dimension changes, edits during restoration, options availability, and malformed config.

## Relevance to Xe-Mod

Spreads join work by a temporary distance reduction; excluded from the unchanged-distance requirement.

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
  "client": [
    "com.zhimeow.smoothjoin.SmoothJoinClient"
  ],
  "modmenu": [
    "com.zhimeow.smoothjoin.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.15.0",
  "fabric-api": "*",
  "minecraft": ">=26.3 <27.0",
  "java": ">=21"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/zhimeow/smoothjoin/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/zhimeow/smoothjoin/Smoothjoin.java` | `` |  | onInitialize |
| top-level / `com/zhimeow/smoothjoin/SmoothJoinClient.java` | `` |  | onInitializeClient, finishRestoration, restoreInstantly, resetState |
| top-level / `com/zhimeow/smoothjoin/SmoothJoinConfig.java` | `` |  | load, save |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
