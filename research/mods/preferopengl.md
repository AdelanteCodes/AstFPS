# Prefer OpenGL

Review status: **Behavioral static review**

Project: [Prefer OpenGL](https://modrinth.com/mod/preferopengl)
Selected artifact version: `fabric-26.2-v1.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This Fabric client mod rewrites options.txt so the renderer preference is set to OpenGL.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `3c9d4e50670986e324ce0b0f633bd66ae4295e4a`
- `sha512`: `951150d7fc010cd5c230662e12cdbeb35f98172195ea06b4ef222e8934d9914aad02879517de80cf9e1114a86582cee9fa26dc1e573e582d5f7fc6d9a59a8651`

## Reviewed mechanism

All four reconstructed classes reviewed.

- At prelaunch and client initialization, reads options.txt and rewrites recognized backend preference keys to preferredGraphicsBackend:opengl.
- Collapses duplicate candidate keys, preserves unrelated lines, adds the target key when absent, and writes only when content differs. If options.txt is absent, logs and returns.

## Lifecycle, correctness, and failure questions

- Forces a persisted graphics API preference. Actual selection requires the exact game version to recognize the key and available backend.
- Direct replacement has no shown backup or atomic-write protection. Candidate key matching can rewrite old/third-party settings.

## Checks needed to establish equivalence

- Test first launch, existing/multiple keys, unsupported keys, write failure, backend selection, and repeat initialization.

## Relevance to Xe-Mod

Backend preference utility; performance is hardware/driver-dependent, not an independent optimization algorithm.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 4
Reconstructed Java files: 4

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "preLaunch": [
    "com.preferopengl.PreferOpenGLPreLaunch"
  ],
  "client": [
    "com.preferopengl.PreferOpenGLClient"
  ],
  "modmenu": [
    "com.preferopengl.PreferOpenGLModMenu"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16.13",
  "minecraft": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/preferopengl/core/RendererPreferenceWriter.java` | `` |  | enforceOpenGL |
| top-level / `com/preferopengl/PreferOpenGLClient.java` | `` |  | onInitializeClient |
| top-level / `com/preferopengl/PreferOpenGLModMenu.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/preferopengl/PreferOpenGLPreLaunch.java` | `` |  | onPreLaunch |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
