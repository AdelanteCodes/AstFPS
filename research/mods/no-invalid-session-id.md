# No Invalid Session ID

Review status: **Evidence inventory; behavioral review pending**

Project: [No Invalid Session ID](https://modrinth.com/mod/no-invalid-session-id)
Selected artifact version: `3.1.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Silently refreshes your Session ID so you don't get that pesky warning. Like ReAuth.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `43074c1969505efd975f2a5ed230c7788a8387b27450a643e1ae9988d6fd5f509f6a6119764f12bc1297b99d9ae89ad63267f409a0f9eaaa1a7b69aa55ac6efb`
- `sha1`: `9037db11325781cd6a1e4fd8253c9a8ea4a2373c`

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
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.Arnav_The_Great.noinvalidsessionid.client.NoinvalidsessionidClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "fabric-api": "*",
  "minecraft": "26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/Arnav_The_Great/noinvalidsessionid/client/mixin/JoinMultiplayerScreenMixin.java` | `value={JoinMultiplayerScreen.class})` | Inject:1 | onInit |
| top-level / `com/Arnav_The_Great/noinvalidsessionid/client/mixin/MinecraftAccessor.java` | `value={Minecraft.class})` | Accessor:1 |  |
| top-level / `com/Arnav_The_Great/noinvalidsessionid/client/NoinvalidsessionidClient.java` | `` |  | onInitializeClient |
| top-level / `com/Arnav_The_Great/noinvalidsessionid/client/SessionRefresher.java` | `` |  | getTokenStorePath, getEncryptionKey, refreshSessionQuietly, silentRefresh, startDeviceCodeFlow, doXblXstsMinecraftChain, updateSession, loadRefreshToken, saveRefreshToken, clearRefreshToken, postJson, postForm |
| top-level / `com/Arnav_The_Great/noinvalidsessionid/client/SessionRefreshScreen.java` | `` |  | init, keyPressed, onClose |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
