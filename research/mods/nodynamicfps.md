# NoDynamicFps

Review status: **Behavioral static review**

Project: [NoDynamicFps](https://modrinth.com/mod/nodynamicfps)
Selected artifact version: `1.1.0+26.2`
Published implementation source: https://github.com/BluSpring/NoDynamicFps
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Adds an option to disable Vanilla's Dynamic FPS implementation

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `cc23688943cb4094abdd9b77e2527aabb3066ea7`
- `sha512`: `cdb7be513a3c8866462a4df480a9b28c4560fe260b261a29dca9642eb6447c95c345b0ac6e0795799cde3c00b9c7c79ab69a9c34c3d8a5d005b5f2d6fcb8c06f`

## Reviewed mechanism

All four reconstructed classes reviewed.

- Adds a disabled inactivity-limit enum option, installs its tooltip/default, and exposes it in a renderer configuration integration.
- When selected, returns the configured cap in a level or unobstructed no-level state, and 60 FPS in other menus, bypassing ordinary inactivity throttles.

## Lifecycle, correctness, and failure questions

- Increases background/idle resource use. Enum extension, option-constructor slices, and tooltip lambda targets are version-sensitive.

## Checks needed to establish equivalence

- Check active/background/minimized states, menus/overlays, saved options, enum serialization, and interactions with other FPS limit mods.

## Relevance to AstFPS

FPS throttle policy, not cheaper frame rendering.

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
  "sodium:config_api_user": [
    "xyz.bluspring.nodynamicfps.compat.sodium.SodiumConfigEntrypoint"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": ">=26.2",
  "fabric-api": "*"
}
```

**accessWidener**

```json
"nodynamicfps.classtweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `xyz/bluspring/nodynamicfps/compat/sodium/SodiumConfigEntrypoint.java` | `` |  | registerConfigLate |
| top-level / `xyz/bluspring/nodynamicfps/mixin/FramerateLimitTrackerMixin.java` | `value={FramerateLimitTracker.class})` | Inject:1 | disableDynamicFps |
| top-level / `xyz/bluspring/nodynamicfps/mixin/InactivityFpsLimitMixin.java` | `value={InactivityFpsLimit.class})` |  |  |
| top-level / `xyz/bluspring/nodynamicfps/mixin/OptionsMixin.java` | `value={Options.class})` | Inject:1, ModifyExpressionValue:1 | useDisabledTooltip, setDefaultInactivityFps |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
