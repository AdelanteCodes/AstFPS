# Glow Squid Spawn Fix

Review status: **Evidence inventory; behavioral review pending**

Project: [Glow Squid Spawn Fix](https://modrinth.com/mod/glowsquidspawnfix)
Selected artifact version: `1.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Fixes spawning of glow squids in random water columns which leads to unnecessary items in the world.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `483eeff4080e255f45e351a004a185d39a05a6b31da3a8a59bbebc03446ea6a5fc3273dc0e154e4cc48f4077cddf678e52c6d4bfdb87975c2e28d802e9998f53`
- `sha1`: `77d4620a47c0c0db27dcfe725443fdd9912afb4d`

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
  "main": [
    "com.frikinjay.glowsquidspawnfix.fabric.GlowSquidSpawnFixFabric"
  ],
  "client": [
    "com.frikinjay.glowsquidspawnfix.fabric.client.GlowSquidSpawnFixFabricClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.4",
  "minecraft": ">=1.21.1",
  "java": ">=21"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `architectury_inject_glowsquidspawnfix_common_988635a1a2734cbfa48c74cc7e79ab61_c7b63adb186fa83ef60115e2284a639f7594ca154539f63457348ae1cf201125GlowSquidSpawnFix121xcommon100devjar/PlatformMethods.java` | `` |  | getCurrentTarget |
| top-level / `com/frikinjay/glowsquidspawnfix/fabric/client/GlowSquidSpawnFixFabricClient.java` | `` |  | onInitializeClient |
| top-level / `com/frikinjay/glowsquidspawnfix/fabric/GlowSquidSpawnFixFabric.java` | `` |  | onInitialize |
| top-level / `com/frikinjay/glowsquidspawnfix/GlowSquidSpawnFix.java` | `` |  | init |
| top-level / `com/frikinjay/glowsquidspawnfix/mixin/GlowSquidMixin.java` | `value={class_5776.class})` | Inject:1 | restrictSpawningNearAir |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
