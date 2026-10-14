# AntiFirmament

Review status: **Evidence inventory; behavioral review pending**

Project: [AntiFirmament](https://modrinth.com/mod/antifirmament)
Selected artifact version: `1.0.3`
Published implementation source: https://github.com/axlecoffee/fuckfirmament
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Removes the dreadful packet Firmament attempts to send to servers (e.g., Hypixel), which shows your mod IDs when Fabric itself doesn't.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `751ce419713b06069edd5c110362b964a667036a`
- `sha512`: `f59b26da19547c39068e0842ab6bda40c9ed2817f852c247c80cbefa1bf32bdf75c45d1aafb8befbc065c40e4bac9ea9428ff14b0083c8f35633d62643db3b07`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 2
Reconstructed Java files: 2

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "coffee.axle.antifirm.AntiFirmament"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.15.0",
  "minecraft": ">=26.3",
  "java": ">=21"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/mixinextras-fabric-0.5.5.jar` | 506 | `mixinextras` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `coffee/axle/antifirm/AntiFirmament.java` | `` |  | onInitializeClient |
| top-level / `coffee/axle/antifirm/mixin/ConnectionMixin.java` | `value={Connection.class})` | Inject:1 | antifirm$blockModAnnouncer |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
