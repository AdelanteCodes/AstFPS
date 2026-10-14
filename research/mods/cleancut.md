# CleanCut

Review status: **Evidence inventory; behavioral review pending**

Project: [CleanCut](https://modrinth.com/mod/cleancut)
Selected artifact version: `8.1.0+26.3-fabric`
Published implementation source: https://github.com/Exoneration/CleanCut
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Fight enemies back through grass and other similar obstructions!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `dbc45bda09aa24ec0d00c17c7f00818cb1f2d7e416d0dfd1d7e0f4fe317c9bbb4b14f1c07efbd6aadadb60d3d7d12fe4fb85a76c9ee1b9324f798ec7f5bb9ac3`
- `sha1`: `7ef798be8ae3e3c6638ad36e3f363274eca2d8d8`

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
  "fabricloader": "*",
  "minecraft": "~26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `zone/rong/cleancut/CleanCut.java` | `` |  | findTarget, reach, stopAtBlock, closestEntity, canTarget, isVehicleOf, accepted |
| top-level / `zone/rong/cleancut/mixin/MinecraftClientMixin.java` | `value={Minecraft.class})` | Redirect:2 | cleancut$attackThroughBlock, cleancut$interactThroughBlock, cleancut$interactEntity |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
