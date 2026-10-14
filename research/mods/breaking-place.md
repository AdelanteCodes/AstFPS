# Breaking Place

Review status: **Evidence inventory; behavioral review pending**

Project: [Breaking Place](https://modrinth.com/mod/breaking-place)
Selected artifact version: `1.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Adds satisfying block destruction particles every time you place a block.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `d843311a66e415039679be97d5390ce8183394f4`
- `sha512`: `448eac85cc771062604f75690fbed3535c67e70b2cc749bdfaa7905c94789793650731f75f49b844a1acdb562e29bd32b4fdc81cb2f99879ad2a4590328b85fe`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 3
Reconstructed Java files: 3

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "org.xFeneq.breakingplace_fabric_26_1_1.Breakingplace_fabric_26_1_1"
  ],
  "client": [
    "org.xFeneq.breakingplace_fabric_26_1_1.client.Breakingplace_fabric_26_1_1Client"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.16.0",
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `org/xFeneq/breakingplace_fabric_26_1_1/Breakingplace_fabric_26_1_1.java` | `` |  | onInitialize |
| top-level / `org/xFeneq/breakingplace_fabric_26_1_1/client/Breakingplace_fabric_26_1_1Client.java` | `` |  | onInitializeClient |
| top-level / `org/xFeneq/breakingplace_fabric_26_1_1/mixin/BlockItemMixin.java` | `value={BlockItem.class})` | Inject:1 | addParticlesOnPlace |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
