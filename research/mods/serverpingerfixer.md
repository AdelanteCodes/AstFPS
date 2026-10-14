# Server Pinger Fixer

Review status: **Behavioral static review**

Project: [Server Pinger Fixer](https://modrinth.com/mod/serverpingerfixer)
Selected artifact version: `1.1.1`
Published implementation source: https://github.com/JustAlittleWolf/ServerPingerFixer
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Improves pinging behaviour of the multiplayer server list

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `a39ad7675ea41a3e8620101497a14f3242adce55c2d34fae6d6b335c8a35e554a5fd7a0f603b62ffdf0235571c7958d222f143c13ad1746b230f22d9900aa788`
- `sha1`: `38caf552fa0b3cbde8e9becbcb39cf147fee4844`

## Reviewed mechanism

Entire one-mixin implementation reviewed.

- After server-list class initialization, shuts down the original executor and substitutes a pool with one core thread, a practically unbounded maximum, a SynchronousQueue, and 30-second excess-thread expiry.
- Uses the original thread factory. Direct handoff lets pending server pings start without waiting behind a fixed-size pool.

## Lifecycle, correctness, and failure questions

- A long server list or slow connections can create many concurrent threads. This exchanges queue latency for concurrency/resource pressure.
- Another mod replacing the same static executor can conflict or leave an old executor alive.

## Checks needed to establish equivalence

- Test many slow/unreachable servers, cancellation when leaving the screen, thread expiry, repeat screen openings, and bounded resource use.

## Relevance to AstFPS

Multiplayer-list responsiveness, not in-world FPS.

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
  "fabricloader": ">=0.19.0",
  "minecraft": ">=26.1",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `me/wolfii/serverpingerfixer/mixin/ServerSelectionListMixin.java` | `value={ServerSelectionList.class})` | Inject:1 | overrideThreadPool |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
