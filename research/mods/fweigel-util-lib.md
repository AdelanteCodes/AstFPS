# fweigel-util-lib

Review status: **Evidence inventory; behavioral review pending**

Project: [fweigel-util-lib](https://modrinth.com/mod/fweigel-util-lib)
Selected artifact version: `1.7.0`
Published implementation source: https://github.com/fweigel-dev/fweigel-util-lib
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Shared client-side utility library for my Fabric mods. Provides common rendering, storage, UI, and sound utilities.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `49499e43b335b06760ba3a8f6db81b5e3e7cbbcba2a1aa062208b1dc2bc3c026c64662490a0ef16fcc5850f54c5c0b6742cb440788aebbf1165f9a756e7034ed`
- `sha1`: `bb155be271bf3c2940fe5edffb0d6196eeb56598`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 27
Reconstructed Java files: 19

**environment**

```json
"*"
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3",
  "java": ">=21",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `dev/fweigel/mobutils/core/client/compat/FweigelModMenuBase.java` | `` |  | getModConfigScreenFactory |
| top-level / `dev/fweigel/mobutils/core/client/mixin/SoundEngineMixin.java` | `value={SoundEngine.class})` | ModifyVariable:1 | modifySoundVolume |
| top-level / `dev/fweigel/mobutils/core/client/network/ClientHandshakeTracker.java` | `` |  | startHandshake, onAck, reset, tick, isServerHasMod |
| top-level / `dev/fweigel/mobutils/core/client/network/ModHandshakeClient.java` | `` |  | registerReceiver, onJoin, onDisconnect, tick, isServerHasMod |
| top-level / `dev/fweigel/mobutils/core/client/render/BabyAgeTracker.java` | `` |  | update, getAge, getAll, clear |
| top-level / `dev/fweigel/mobutils/core/client/render/BabyTimerRenderer.java` | `` |  | render |
| top-level / `dev/fweigel/mobutils/core/client/render/WorldTextRenderer.java` | `` |  | renderFloatingText |
| top-level / `dev/fweigel/mobutils/core/client/sound/SoundVolumeRegistry.java` | `` |  | register, getVolume |
| top-level / `dev/fweigel/mobutils/core/client/sound/WrappedSoundInstance.java` | `` |  | getIdentifier, getOrResolve, getSoundEvent, getSound, getSource, isLooping, isRelative, getDelay, getVolume, getPitch, getX, getY, getZ, getAttenuation |
| top-level / `dev/fweigel/mobutils/core/client/storage/WorldIdentifierResolver.java` | `` |  | resolve, sanitize |
| top-level / `dev/fweigel/mobutils/core/client/storage/WorldScopedStorage.java` | `` |  | loadForWorld, save, getActivePath, getSavePath |
| top-level / `dev/fweigel/mobutils/core/client/ui/ModOptionsList.java` | `` |  | getRowWidth, getRowLeft, addWide, addSplit, addCustom, addSplitCard, addSingleCard, isCardClick, drawPauseIndicator, extractContent, children, narratables, extractContent, children, narratables, extractContent, mouseClicked, children, narratables, image, animated, animated, isPausable, isPaused, click, showIndicator, frame, frame, isPausable, isPaused, click, showIndicator, extractContent, mouseClicked, children, narratables |
| top-level / `dev/fweigel/mobutils/core/client/ui/ModScreen.java` | `` |  | renderCard, renderCard, drawSeparator, drawCardPreview, drawCardPreview, drawAnimatedCardPreview, drawAnimatedCardPreview, isPauseScreen |
| top-level / `dev/fweigel/mobutils/core/client/ui/ModSettingsScreen.java` | `` |  | init, onClose, extractRenderState, buildHalfButton, buildWideButton |
| top-level / `dev/fweigel/mobutils/core/client/util/ConfigKeyHelper.java` | `` |  | register |
| top-level / `dev/fweigel/mobutils/core/client/util/ItemStackUtils.java` | `` |  | getUniformItem, getUniformItem |
| top-level / `dev/fweigel/mobutils/core/network/ModHandshake.java` | `` |  | registerPayloads, registerServerReceiver, getHelloType, getHelloPayload, getHelloAckType, getModPlayers |
| top-level / `dev/fweigel/mobutils/core/network/ServerModPlayerRegistry.java` | `` |  | add, contains, getAll |
| top-level / `dev/fweigel/mobutils/core/network/UnitPayload.java` | `` |  | type |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
