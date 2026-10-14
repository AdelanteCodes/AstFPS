# Podium

Review status: **Evidence inventory; behavioral review pending**

Project: [Podium](https://modrinth.com/mod/podium)
Selected artifact version: `1.1.1`
Published implementation source: https://github.com/RaydanOMGr/Podium
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A tiny mod that disables Sodium's PojavLauncher check.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `a9cb4b21fb2b27faf9a5106c3a6bfb60ab1a4b03`
- `sha512`: `e9714a77f4ee905e8fbd1a16f57518695d189aea9cd4a63a82ae0a9bf32b62f3819c1afff76d586c51180aea176748af2996473aabf65e6964bf8680e7184a90`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 2
Reconstructed Java files: 2

**environment**

```json
"client"
```

**depends**

```json
{
  "fabricloader": ">=0.15",
  "minecraft": ">1.20",
  "java": ">=17",
  "sodium": ">=0.5.13"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/andreasmelone/podium/mixin/PostLaunchChecksMixin.java` | `value={PostLaunchChecks.class})` | Inject:1 | isUsingPojavMixin |
| top-level / `me/andreasmelone/podium/mixin/PreLaunchChecksMixin.java` | `value={PreLaunchChecks.class})` | Inject:1 | checkLwjglRuntimeVersionMixin |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
