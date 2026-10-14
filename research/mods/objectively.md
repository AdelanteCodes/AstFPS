# Objectively

Review status: **Evidence inventory; behavioral review pending**

Project: [Objectively](https://modrinth.com/mod/objectively)
Selected artifact version: `1.0.5`
Published implementation source: https://github.com/Tater-Certified/Objectively
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Additions to the vanilla scoreboard objective system

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `aa9b1daa66e059706ddd8adfccdc898cee0a5ed6`
- `sha512`: `4e4ff390d739370e1c1a59a0e3506dca85f127f404b72ab3e1cebeefac46689a5e2f6a46c79669497449155c62cc9c50b731ff5bd53695ee1ebd3b3fe9fd8845`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

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
    "com.github.tatercertified.objectively.Objectively"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.6",
  "fabric-api": "*",
  "minecraft": ">=26.1"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/github/tatercertified/objectively/Command.java` | `` |  | register, setDefault |
| top-level / `com/github/tatercertified/objectively/mixin/ServerPlayerEntityCriteriaMixin.java` | `value={ServerPlayer.class})` | Inject:1 | objectively$reduceScoreboardUpdateFrequency |
| top-level / `com/github/tatercertified/objectively/Objectively.java` | `` |  | onInitialize, saveObjectives, loadObjectives |
| top-level / `com/github/tatercertified/objectively/Objectives.java` | `` |  | notHaveObjective, init |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
