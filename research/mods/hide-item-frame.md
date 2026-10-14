# Hide Item Frame

Review status: **Evidence inventory; behavioral review pending**

Project: [Hide Item Frame](https://modrinth.com/mod/hide-item-frame)
Selected artifact version: `1.5.2-fabric+26.3`
Published implementation source: https://github.com/BizCub/hide-item-frame
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Hide the frame if it contains an item

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `32ec110951c2ae811283b02581c40c7dd61c51abbc24f60e0797cc7caafcc4b3b86878c82628a97e5b725c577b8fd590a920fa2579b51d15e782b82ece61074f`
- `sha1`: `5f40b9906077667c26b4390c02f77bda96fb4f74`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 10
Reconstructed Java files: 7

**entrypoints**

```json
{
  "modmenu": [
    "io.github.bizcub.hideItemFrame.platform.Fabric$ModMenu"
  ],
  "client": [
    "io.github.bizcub.hideItemFrame.platform.Fabric"
  ]
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/github/bizcub/hideItemFrame/config/ClothConfig.java` | `` |  | getInstance, init, isInvisible, setIsInvisible, isItemOffset, save |
| top-level / `io/github/bizcub/hideItemFrame/config/Config.java` | `` |  | get, set |
| top-level / `io/github/bizcub/hideItemFrame/config/ConfigHelper.java` | `` |  | isModLoaded, isClothConfigLoaded, isSimpleConfigLoaded, getScreen |
| top-level / `io/github/bizcub/hideItemFrame/config/SimpleConfig.java` | `` |  | getInstance, isInvisible, setIsInvisible, isItemOffset, save |
| top-level / `io/github/bizcub/hideItemFrame/Main.java` | `` |  | init, onClientTick |
| top-level / `io/github/bizcub/hideItemFrame/mixin/HideItemFrameMixin.java` | `value={ItemFrameRenderer.class})` | ModifyVariable:1, Redirect:1 | hideItemFrame, isInvisible |
| top-level / `io/github/bizcub/hideItemFrame/platform/Fabric.java` | `` |  | onInitializeClient, getModConfigScreenFactory |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
