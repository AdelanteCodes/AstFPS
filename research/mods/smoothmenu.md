# SmoothMenu Reloaded

Review status: **Behavioral static review**

Project: [SmoothMenu Reloaded](https://modrinth.com/mod/smoothmenu)
Selected artifact version: `26.3-1.0.0`
Published implementation source: https://github.com/noramibu/SmoothMenuReloaded
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Removes the main menu FPS limit. 26.1+ port of SmoothMenu by BookerCatch

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `1f928c62f8a049639b40197f94c2d4d70f7dc94c`
- `sha512`: `17e66039ad3d4c79c53ea3e048c192e61c23c622d94b44a7dc59c255e10c60da9803500f00fb397fa60671669d547497f1f3ea327f3b21dbbfe5ef1c0cd9f707`

## Reviewed mechanism

Entire one-mixin implementation reviewed.

- Intercepts the framerate-limit getter. When vanilla reports OUT_OF_LEVEL_MENU throttling, returns the configured framerate limit rather than the special menu throttle.
- Other throttle reasons use the original result. There is no change to how a gameplay frame is rendered.

## Lifecycle, correctness, and failure questions

- Can increase GPU/CPU consumption in menus. Other FPS limit mods can intercept the same getter.

## Checks needed to establish equivalence

- Check focused menus, gameplay, minimized/unfocused states, and interaction with other limiters.

## Relevance to Xe-Mod

Menu FPS limit behavior; does not make rendering faster.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 1
Reconstructed Java files: 1

**environment**

```json
"client"
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `bookercatch/smoothmenu/mixin/SmoothMenuMixin.java` | `value={FramerateLimitTracker.class})` | Inject:1 | smoothmenu$uncapOutOfLevelMenu |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
