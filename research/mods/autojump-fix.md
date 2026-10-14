# AutoJump Fix

Review status: **Evidence inventory; behavioral review pending**

Project: [AutoJump Fix](https://modrinth.com/mod/autojump-fix)
Selected artifact version: `1.0.6+26.3+fabric`
Published implementation source: https://github.com/ZipeStudio/AutoJump-Fix
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Grants auto-jumping a second life by fixing annoying issues, such as auto-jumping too late and causing you to lose your sprint, or making you jump when you scrape the corner of a block.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `24b62070fb356eb5442fcd48717916b3127ff5b73921d5579b8a8d2317f44d20f65d533f9fe7bd792f7caff6fbf579a2082a8cc3ed9a78bf200db606212a8128`
- `sha1`: `ba2b0ffe84660a1faf154da6398beead104f17d3`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 7
Reconstructed Java files: 7

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "me.zipestudio.autojumpfix.entrypoint.CommonEntrypoint"
  ],
  "client": [
    "me.zipestudio.autojumpfix.entrypoint.ClientEntrypoint"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "minecraft": ">=26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

**accessWidener**

```json
"aws/fabric-26.3.classTweaker"
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/zipestudio/autojumpfix/AJF.java` | `` |  | onInitialize |
| top-level / `me/zipestudio/autojumpfix/backend/AJFAction.java` | `` |  | autojumpPlayer, squaredHorizontalDistance, maxJumpHeight, hasHeadSpace, getPlayerWorld, mcDeg2NormalDeg, calcAngle, angleDiff |
| top-level / `me/zipestudio/autojumpfix/client/AJFClient.java` | `` |  | onInitializeClient |
| top-level / `me/zipestudio/autojumpfix/entrypoint/ClientEntrypoint.java` | `` |  | onInitializeClient |
| top-level / `me/zipestudio/autojumpfix/entrypoint/CommonEntrypoint.java` | `` |  | onInitialize |
| top-level / `me/zipestudio/autojumpfix/mixin/EntityInvoker.java` | `value={Entity.class})` | Invoker:1 |  |
| top-level / `me/zipestudio/autojumpfix/mixin/LocalPlayerMixin.java` | `value={LocalPlayer.class})` | Inject:1 | onAutoJump |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
