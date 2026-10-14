# Raise Sound Limit Simplified

Review status: **Evidence inventory; behavioral review pending**

Project: [Raise Sound Limit Simplified](https://modrinth.com/mod/rsls)
Selected artifact version: `1.4.0`
Published implementation source: https://github.com/ishland/raise-sound-limit-simplified
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A mod that improves sound engine performance and raises Minecraft sound sources limit in a simple way

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `f04fcfd29d52de8a60f5f24849ec90f32b97d6c8bc70ca37110ed5a8325976ef3b91b971653e169e1ad6bc2372dc08326e807d76ddb337430275c796961ed888`
- `sha1`: `60a95072fa946fa23eec1927b8370593e89d1fd8`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 28
Reconstructed Java files: 28

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.ishland.fabric.rsls.RSLSMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "java": ">=25",
  "minecraft": ">=26.3"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/ishland/fabric/rsls/common/cloth_config/ConfigScreenUtils.java` | `` |  | makeConfigScreen, getConfigButton |
| top-level / `com/ishland/fabric/rsls/common/ListFromSortedSet.java` | `` |  | size, isEmpty, contains, add, remove, containsAll, addAll, addAll, removeAll, retainAll, clear, get, set, add, remove, indexOf, lastIndexOf, replaceAll, sort, addFirst, addLast, getFirst, getLast, removeFirst, removeLast, reversed, toArray, removeIf, forEach, hashCode, equals, toString |
| top-level / `com/ishland/fabric/rsls/common/RSLSConfig.java` | `` |  | init, loadConfig, saveConfig, getInt |
| top-level / `com/ishland/fabric/rsls/common/RSLSConstants.java` | `` |  |  |
| top-level / `com/ishland/fabric/rsls/common/SoundManagerDuck.java` | `` |  |  |
| top-level / `com/ishland/fabric/rsls/common/SoundSystemDuck.java` | `` |  |  |
| top-level / `com/ishland/fabric/rsls/common/SourcesLimitProber.java` | `` |  | probeSourcesLimit, getSourcesCount, checkALCError, getAlcErrorMessage |
| top-level / `com/ishland/fabric/rsls/common/WorldRandomHolder.java` | `` |  | putWorldRandom, isWorldRandom |
| top-level / `com/ishland/fabric/rsls/mixin/access/ISoundExecutor.java` | `value={SoundEngineExecutor.class})` | Accessor:1 |  |
| top-level / `com/ishland/fabric/rsls/mixin/access/ISoundManager.java` | `value={SoundManager.class})` | Accessor:1 |  |
| top-level / `com/ishland/fabric/rsls/mixin/access/ISoundSystem.java` | `value={SoundEngine.class})` | Accessor:2 |  |
| top-level / `com/ishland/fabric/rsls/mixin/access/IThreadExecutor.java` | `value={BlockableEventLoop.class})` | Accessor:2, Invoker:1 |  |
| top-level / `com/ishland/fabric/rsls/mixin/cloth_config/MixinSoundOptionsScreen.java` | `value={SoundOptionsScreen.class})` | Inject:1 | onInit |
| top-level / `com/ishland/fabric/rsls/mixin/MixinAbstractSoundInstance.java` | `value={AbstractSoundInstance.class})` | ModifyVariable:1 | onInit |
| top-level / `com/ishland/fabric/rsls/mixin/MixinBiomeEffectSoundPlayer.java` | `value={BiomeAmbientSoundsHandler.class})` | Inject:1 | replaceRandom |
| top-level / `com/ishland/fabric/rsls/mixin/MixinClientPlayNetworkHandler.java` | `value={ClientPacketListener.class})` | WrapOperation:1, ModifyExpressionValue:1 | handleSoundsAsync, checkWorldExistence |
| top-level / `com/ishland/fabric/rsls/mixin/MixinMusicTracker.java` | `value={MusicManager.class})` | WrapMethod:2, WrapOperation:1 | wrapPlay, wrapPlayListener, wrapTryShowToast |
| top-level / `com/ishland/fabric/rsls/mixin/MixinSoundEngine.java` | `value={Library.class})` | WrapOperation:1, ModifyArg:2, ModifyConstant:1 | modifyMaxSourceFromConfig, modifyStaticSources, modifyStreamingSources, modifyMaxSource |
| top-level / `com/ishland/fabric/rsls/mixin/MixinSoundExecutor.java` | `value={SoundEngineExecutor.class})` |  | pollTask |
| top-level / `com/ishland/fabric/rsls/mixin/MixinSoundLoader.java` | `value={SoundBufferLibrary.class})` | Inject:1 | syncMap |
| top-level / `com/ishland/fabric/rsls/mixin/MixinSoundManager.java` | `value={SoundManager.class})` | Inject:2, WrapMethod:14, WrapOperation:1 | onInit, onPlayNextTick, onPlay, onPlay, onPauseAll, onStopAll, onClose, onTick, onResumeAll, onUpdateSoundVolume, onStop, onSetVolume, onRegisterListener, onUnregisterListener, onStopSounds, wrapResourceReloadReload, wrapReloadSounds, rsls$shouldRunOffthread |
| top-level / `com/ishland/fabric/rsls/mixin/MixinSoundSystem.java` | `value={SoundEngine.class})` | Inject:2, Redirect:7, ModifyReturnValue:2, WrapMethod:1 | onInit, optimizeNextTickIteration, rsls$schedulePlay, onReload, appendDebugString, tickDisableFilter, tickDisableForEach, modifyIsPlaying, wrapTick, redirectTickSound, rsls$playInternal0, redirectDelayedPlay, redirectExecutorStop, redirectExecutorStart |
| top-level / `com/ishland/fabric/rsls/mixin/MixinSubtitlesHud_1_20_3.java` | `value={SubtitleOverlay.class})` | Inject:1 | onSoundPlayedHandler |
| top-level / `com/ishland/fabric/rsls/mixin/MixinWorld.java` | `value={Level.class}, priority=10000)` | Inject:1 | captureWorldRandom |
| top-level / `com/ishland/fabric/rsls/mixin/RSLSMixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `com/ishland/fabric/rsls/RSLSInjectorFFM.java` | `` |  | init |
| top-level / `com/ishland/fabric/rsls/RSLSInjectorLWJGL.java` | `` |  | init |
| top-level / `com/ishland/fabric/rsls/RSLSMod.java` | `` |  | onInitializeClient |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
