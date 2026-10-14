# Player Hider (Funnest's Edition)

Review status: **Behavioral static review**

Project: [Player Hider (Funnest's Edition)](https://modrinth.com/mod/player-hider-funnest-edition)
Selected artifact version: `1.0.0`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

This Mod will hide Players from client side which gives you more Fps in loaded minecraft servers

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `aebcc8bf57c9bdeb539a0e707bcc332a066510c2`
- `sha512`: `7ae1e3a8b79e99c85f52d00576ef400465324418a2207ab5e2196da35c765c7d2c7a6308be2b7344486f78b037afeeae2d9380d83fb33c5ca0b9d2bdfc9ed9de`

## Reviewed mechanism

Both reconstructed classes reviewed.

- A key binding toggles a client flag and overlay message. The EntityRenderer.shouldRender hook returns false for Player entities whose UUID differs from the local player's UUID while enabled.
- No spatial occlusion test is involved; other players are hidden regardless of whether visible.

## Lifecycle, correctness, and failure questions

- Visible players disappear. Using render eligibility may affect attached labels/effects depending on the calling renderer.

## Checks needed to establish equivalence

- Check local third-person rendering, other players, spectator/camera states, labels, toggling, and reconnect.

## Relevance to Xe-Mod

Visibility removal; excluded from unchanged visuals.

Research only. No implementation is being added during this research pass.

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
    "com.playerhider.PlayerHiderClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/playerhider/mixin/EntityRendererMixin.java` | `value={EntityRenderer.class})` | Inject:1 | onShouldRender |
| top-level / `com/playerhider/PlayerHiderClient.java` | `` |  | onInitializeClient |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
