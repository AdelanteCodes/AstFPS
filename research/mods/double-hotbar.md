# Double Hotbar

Review status: **Evidence inventory; behavioral review pending**

Project: [Double Hotbar](https://modrinth.com/mod/double-hotbar)
Selected artifact version: `1.3.4-mc26.3-fabric`
Published implementation source: https://github.com/sidezbros/double_hotbar
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Adds a second hotbar that displays a row of the inventory on the HUD. This provides a dual hotbar setup where you can easily swap/hotswap/cycle which of the two hotbars is active. Improves inventory management.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `b1c7f4852e27d7260601250e3a7cda6433f8feab33dfb76bc4e89948d63e7ecead61ed6c824f15eced53c367cb5797802ecd9a5e7efd1cc856cc871b80f64df5`
- `sha1`: `756a0fc099d4fc592ee45bbb816c603643046dce`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 5
Reconstructed Java files: 5

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "com.sidezbros.double_hotbar.DoubleHotbar"
  ],
  "modmenu": [
    "com.sidezbros.double_hotbar.DHMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "fabric-api": "*",
  "minecraft": "~26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/sidezbros/double_hotbar/DHMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `com/sidezbros/double_hotbar/DHModConfig.java` | `` |  | init |
| top-level / `com/sidezbros/double_hotbar/DoubleHotbar.java` | `` |  | onInitializeClient, swapStack |
| top-level / `com/sidezbros/double_hotbar/mixin/AbstractClientPlayerMixin.java` | `value={AbstractClientPlayer.class})` | Inject:1 | getSkin |
| top-level / `com/sidezbros/double_hotbar/mixin/HudMixin.java` | `value={Hud.class})` | Inject:7 | extractItemHotbar, shiftHotbarSelector, returnHotbarSelector, shiftHotbarItems, extractItemHotbarItems, shiftStatusBars, returnStatusBars |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
