# Pearl Optimizer

Review status: **Evidence inventory; behavioral review pending**

Project: [Pearl Optimizer](https://modrinth.com/mod/pearl_optimizer)
Selected artifact version: `26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Optimizes ender pearls client side to be like zero ping.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `6d5997f37ca5ef3551e70b4f2f3dad39ce6396530cca8c6011c249dd4253b07c0c11cdca2addf80d639d6d129eaf4f56b17dc9f5f5c1de1855f363893fa67684`
- `sha1`: `a37c1d9d62ceee88aa4ff511f2d7335bf457ce55`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 0
Reconstructed Java files: Not available

**environment**

```json
"client"
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.1 <=26.3",
  "pearloptimizer": "*",
  "silicon": "*"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/PearlOptimizer-26.1-26.2.jar` | 13 | `pearloptimizer` | Reconstructed source; semantic review pending |
| `META-INF/jars/PearlOptimizer-26.3.jar` | 13 | `pearloptimizer` | Reconstructed source; semantic review pending |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| META-INF/jars/PearlOptimizer-26.1-26.2.jar / `me/cutebow/pearloptimizer/client/ClientState.java` | `` |  | ready |
| META-INF/jars/PearlOptimizer-26.1-26.2.jar / `me/cutebow/pearloptimizer/client/PearloptimizerClient.java` | `` |  | onInitializeClient |
| META-INF/jars/PearlOptimizer-26.1-26.2.jar / `me/cutebow/pearloptimizer/compat/EntityCullingCompat.java` | `` |  | forceVisible, invoke |
| META-INF/jars/PearlOptimizer-26.1-26.2.jar / `me/cutebow/pearloptimizer/entity/ClientPearl.java` | `` |  | onHit |
| META-INF/jars/PearlOptimizer-26.1-26.2.jar / `me/cutebow/pearloptimizer/mixin/ClientCommonNetworkHandlerMixin.java` | `value={ClientCommonPacketListenerImpl.class})` | Inject:2 | pearlOptimizer$init, pearlOptimizer$handleCustomPayload |
| META-INF/jars/PearlOptimizer-26.1-26.2.jar / `me/cutebow/pearloptimizer/mixin/ClientPlayerEntityMixin.java` | `value={LocalPlayer.class})` | Inject:1 | pearlOptimizer$tick |
| META-INF/jars/PearlOptimizer-26.1-26.2.jar / `me/cutebow/pearloptimizer/mixin/ClientWorldMixin.java` | `value={ClientLevel.class})` | Inject:1 | pearlOptimizer$addEntity |
| META-INF/jars/PearlOptimizer-26.1-26.2.jar / `me/cutebow/pearloptimizer/mixin/EnderPearlItemMixin.java` | `value={EnderpearlItem.class})` | Inject:1 | pearlOptimizer$use |
| META-INF/jars/PearlOptimizer-26.1-26.2.jar / `me/cutebow/pearloptimizer/optout/ServerOptOut.java` | `` |  | reset, handle, disabled |
| META-INF/jars/PearlOptimizer-26.1-26.2.jar / `me/cutebow/pearloptimizer/pearl/PearlBuffer.java` | `` |  | add, remove, all, clear |
| META-INF/jars/PearlOptimizer-26.1-26.2.jar / `me/cutebow/pearloptimizer/pearl/Pearls.java` | `` |  | tick, enabled, throwClientPearl, handleServerPearl, destroy, clear, applyVelocity, nextClientPearlId, decrementClientPearlId |
| META-INF/jars/PearlOptimizer-26.1-26.2.jar / `me/cutebow/pearloptimizer/Pearloptimizer.java` | `` |  | onInitialize |
| META-INF/jars/PearlOptimizer-26.1-26.2.jar / `me/cutebow/pearloptimizer/PearlOptimizerMod.java` | `` |  | onInitializeClient |
| META-INF/jars/PearlOptimizer-26.3.jar / `me/cutebow/pearloptimizer/client/ClientState.java` | `` |  | ready |
| META-INF/jars/PearlOptimizer-26.3.jar / `me/cutebow/pearloptimizer/client/PearloptimizerClient.java` | `` |  | onInitializeClient |
| META-INF/jars/PearlOptimizer-26.3.jar / `me/cutebow/pearloptimizer/compat/EntityCullingCompat.java` | `` |  | forceVisible, invoke |
| META-INF/jars/PearlOptimizer-26.3.jar / `me/cutebow/pearloptimizer/entity/ClientPearl.java` | `` |  | onHit |
| META-INF/jars/PearlOptimizer-26.3.jar / `me/cutebow/pearloptimizer/mixin/ClientCommonNetworkHandlerMixin.java` | `value={ClientCommonPacketListenerImpl.class})` | Inject:2 | pearlOptimizer$init, pearlOptimizer$handleCustomPayload |
| META-INF/jars/PearlOptimizer-26.3.jar / `me/cutebow/pearloptimizer/mixin/ClientPlayerEntityMixin.java` | `value={LocalPlayer.class})` | Inject:1 | pearlOptimizer$tick |
| META-INF/jars/PearlOptimizer-26.3.jar / `me/cutebow/pearloptimizer/mixin/ClientWorldMixin.java` | `value={ClientLevel.class})` | Inject:1 | pearlOptimizer$addEntity |
| META-INF/jars/PearlOptimizer-26.3.jar / `me/cutebow/pearloptimizer/mixin/EnderPearlItemMixin.java` | `value={EnderpearlItem.class})` | Inject:1 | pearlOptimizer$use |
| META-INF/jars/PearlOptimizer-26.3.jar / `me/cutebow/pearloptimizer/optout/ServerOptOut.java` | `` |  | reset, handle, disabled |
| META-INF/jars/PearlOptimizer-26.3.jar / `me/cutebow/pearloptimizer/pearl/PearlBuffer.java` | `` |  | add, remove, all, clear |
| META-INF/jars/PearlOptimizer-26.3.jar / `me/cutebow/pearloptimizer/pearl/Pearls.java` | `` |  | tick, enabled, throwClientPearl, handleServerPearl, destroy, clear, applyVelocity, nextClientPearlId, decrementClientPearlId |
| META-INF/jars/PearlOptimizer-26.3.jar / `me/cutebow/pearloptimizer/Pearloptimizer.java` | `` |  | onInitialize |
| META-INF/jars/PearlOptimizer-26.3.jar / `me/cutebow/pearloptimizer/PearlOptimizerMod.java` | `` |  | onInitializeClient |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
