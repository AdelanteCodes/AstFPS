# Generator

Review status: **Evidence inventory; behavioral review pending**

Project: [Generator](https://modrinth.com/mod/chunk_gen)
Selected artifact version: `12+mod`
Published implementation source: https://github.com/Lucasv-github/Pregenerator/
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A Minecraft chunk generation datapack

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `required`.

Artifact identity:
- `sha512`: `9de34cd6b1eb9c14724b306dac1819711e281448a3221cc665203e9e97ec2d17fc82fdfc365042f0d7084371db3b1c35fdad4b07abcc7e0807edd0c266de654d`
- `sha1`: `630010977a0d0ba5a131f7b58fa0760a16095d16`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 1
Reconstructed Java files: 1

**environment**

```json
"*"
```

**depends**

```json
{
  "fabric-resource-loader-v0": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/modrinth/mJAm0uFF/ModrinthWrapper.java` | `` |  |  |

## Data-driven behavior

Resource category counts: `function`: 18, `functions`: 18, `tags`: 4.

These resources can implement gameplay without JVM classes. Function bodies, predicates, recipes, loot tables, tags, and schedules require a separate behavioral review.

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
