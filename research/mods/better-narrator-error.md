# Better Narrator Error

Review status: **Behavioral static review**

Project: [Better Narrator Error](https://modrinth.com/mod/better-narrator-error)
Selected artifact version: `1.0.0`
Published implementation source: https://github.com/Awakened-Redstone/BetterNarratorError
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Stop printing a huge error on the logs when the Narrator (flite) isn't found on Linux.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `c6855453d497204380a63799f6235d11163a8343a58f73d0212fcadeaa23e80d104210b162e9c4cf0d10072333c4366eecf74c7373cf6a09e61d03edb2174e8e`
- `sha1`: `43f26ba00096a6d85f4a0b862bdf1d95b1e77a4f`

## Reviewed mechanism

All three reconstructed source files reviewed, including the nested native-library mixin.

- Uses JVM properties to select Narrator.EMPTY or control how narrator initialization exceptions are reported.
- Rebuilds the native-library failure cause with shortened resource-path text, optionally empty stack traces, and optionally a replacement cause. Another wrapper clears the throwable stack before logging.

## Lifecycle, correctness, and failure questions

- Trimming exception evidence makes later diagnosis harder. Assumptions about cause messages and parentheses can fail on different native error formats.
- This affects a failure path and startup noise, not normal per-frame work.

## Checks needed to establish equivalence

- Test missing native libraries with all property combinations, null/unusual cause messages, and confirm the original narration fallback remains intact.

## Relevance to AstFPS

Log presentation utility; AstFPS diagnostics should preserve failure evidence instead.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 4
Reconstructed Java files: 3

**environment**

```json
"client"
```

**depends**

```json
{
  "fabricloader": ">=0.16.10",
  "minecraft": ">=1.20.1",
  "java": ">=17"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `betternarratorerror/mixin/NarratorLinuxMixin.java` | `value={NarratorLinux.class}); targets={"com.mojang.text2speech.NarratorLinux$FliteLibrary", "com.mojang.text2speech.NarratorLinux$FliteLibrary$CmuUsKal16"})` | WrapOperation:1 | pleaseDontGenerateAHugeStackTraceThanks |
| top-level / `betternarratorerror/mixin/NarratorMixin.java` | `value={Narrator.class})` | Inject:1, WrapOperation:1 | getNarrator, getNarrator |
| top-level / `betternarratorerror/util/RuntimeProperty.java` | `` |  | getBoolean |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
