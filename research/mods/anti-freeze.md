# AntiFreeze

Review status: **Evidence inventory; behavioral review pending**

Project: [AntiFreeze](https://modrinth.com/mod/anti-freeze)
Selected artifact version: `1.1.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

AntiFreeze is an extremely lightweight, lag-free mod that completely prevents water from natural freezing.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `required`.

Artifact identity:
- `sha1`: `ecc613bd5d03172fdb2b55752f33241ec8c0a20e`
- `sha512`: `485b4766545d611ddb8ce9e1c3d384deba9aac7fc9f6c48263f7adcffbd2ef278df1d0b1ccc26f17850e413370ef4f6dc2d76ddc4450f13ddd4a8abc25b6c1f8`

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
"*"
```

**entrypoints**

```json
{
  "client": [
    "org.xFeneq.antifreeze.client.AntifreezeClient"
  ],
  "main": [
    "org.xFeneq.antifreeze.Antifreeze"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "fabric-api": "*",
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `org/xFeneq/antifreeze/Antifreeze.java` | `` |  | onInitialize |
| top-level / `org/xFeneq/antifreeze/client/AntifreezeClient.java` | `` |  | onInitializeClient |
| top-level / `org/xFeneq/antifreeze/mixin/AntiFreezeBiomeMixin.java` | `value={Biome.class})` | Inject:2 | onShouldFreeze, onShouldFreezeTail |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
