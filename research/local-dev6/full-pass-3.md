# Assigned inventory second pass: indices274–409

136 artifacts have individual dispositions. This is scoped source review, not a claim that every file in all artifacts is understood or runtime validated. Read receipts distinguish excerpt reads, full core reads and inherited earlier evidence.

Implemented distinct native26.3 improvement: PackResourcePathMixin removes String.format/Object[3] from native ZIP lookup path construction. Startup gate/registration and central compile are owned by parent. It changes no cache, resource enumeration, callbacks or lifetime. See work/pack-resource-path-native-javap.txt.

## 274 elytra-chestplate-swapper (2.1.0+26.3-fabric)

Keyboard callback maps press/release into bypass key state and registers custom swap binding. Inventory action helper not traced; gameplay/input tool, exclude.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\elytra-chestplate-swapper.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 dcfb446ccecba84c5520e7da063b6b8603ed5b6b64d92bf24697aa15587b4157
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\elytra-chestplate-swapper\saphjyr\ecs\mixin\client\KeyboardMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 4b08fc6d94a8b2ae8672d6ecc1e9b4a26cbeeb9d35c8aff3e59ed464d0acdc4d
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\elytra-chestplate-swapper\saphjyr\ecs\ECSKeybind.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 1d4739010779708ddcbb07436ef1648ca5a452d1dd02b75ed4399826e852d9cc

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 275 sprint-fix (1.0.0)

Client tick calls custom sprint logic, respawn HEAD/RETURN tracks sprint transition. Movement convenience, no rendering benefit; core SprintClient still untraced.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\sprint-fix.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 9c604d74575e8ae0b43fc43fb5cb5f08aeaff2f66ca519ef0f11a453bbb6ef43
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\sprint-fix\com\afkzstudios\sprintfix\mixin\client\LocalPlayerMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 7868e12c579442555e8d5085c98b09906fb9b12bd3d0c1bbf5436ef44c654fe1
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\sprint-fix\com\afkzstudios\sprintfix\mixin\client\MinecraftMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 7768fa6b2c7b1b99f36dc8e4502a2f02a25e42e5c0473f818adf0edb864bf616

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 276 better-auto-totem (1.0.0)

Fabric END_LEVEL_TICK loops all server players and applies shared tickPlayer; Forge equivalents do player ticks and toggle hotkey. Automated inventory/gameplay behavior; shared logic inspected later, exclude.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\better-auto-totem.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 4beec7bafe7f19252605b842fa673f381db25a0049fd46b5951f026ef35a89d7
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\better-auto-totem\net\zerw\autototem\AutototemFabric.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 b32b79e7292f074d40781ca03f3ca6aa70b13227ade81164a2a891ceb1a73112
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\better-auto-totem\net\zerw\autototem\AutototemForge.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 d839103f696707b0ff1c07d43ef791fc3eb1a31080d27948ccab345218f83af2

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 277 fps-sync (1.0.0)

GameRenderer.render TAIL invokes FrameLimiter; Options slider replaced with -10 FPS Sync sentinel, 10-step values to 1000 and 1010 unlimited; tracker disabled when custom limiter takes over. Pacing utility, not uncapped performance gain; monitor changes and double limiting need audit.

Client benefit: Pacing/latency/idle energy, workload dependent.
Disposition: Optional pacing/power policy only; not an uncapped foreground throughput improvement.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\fps-sync.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 8eeb28c7b5226a111256c23b94f5628637dbf0c58e6595ab1b8e55bb334f30d6
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\fps-sync\com\fpssync\mixin\GameRendererMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 e5206a941544629665493f900c6df9db6ed0b60a529ef145603b519a66b8fe89
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\fps-sync\com\fpssync\mixin\OptionsMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 a4d6700a51e23723fcd77db66e5e7a025fb420c7f568c673c8398368e0361772

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 278 neotooltipfix (1.2.1-26.3)

Tooltip component list copied mutable, wrapped by available width, flipped using static shouldFlip; text reconstructed from styled siblings. UI fix, potential reentrant/static-state and narrow-screen handling concerns, no world FPS benefit.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\neotooltipfix.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 e8a5adb7c32ee2613b425c15addbe78ad7882b1f3c585792f81e1418aa47225c
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\neotooltipfix\dev\ngspace\neotooltipfix\mixin\FixToolTipMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 cf7d5b29428f42e918878cfbe84f19af58fcb0b13dcdd6cd803d2d9f0537edc5
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\neotooltipfix\dev\ngspace\neotooltipfix\Helper.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 67c69a55c82e64305689157f10f50973b21753b2e555f9946e5581a4e5c8242e

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 279 skeleton-ai-fix (26.3.0)

END entity tick forces bowGoal.strafingTime to MIN_VALUE and derives faster attack interval from eased target distance/difficulty/config. Explicit combat AI change, exclude.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\skeleton-ai-fix.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 f6625535ecfed64081dc98a1f8c53c489f81e4c9a4d41cb7d77434ab3d123ea1
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\skeleton-ai-fix\fuzs\skeletonaifix\common\SkeletonAIFix.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 46d6159b63722f6530f876f38bcb90b5cae3404f7f0645390d4afc969c5e8deb
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\skeleton-ai-fix\fuzs\skeletonaifix\fabric\SkeletonAIFixFabric.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 b06407c788b8a41c9a7226bc43ed63e9b376dde662c1fd8eea059641cc4b605d

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 280 cleancut (8.1.0+26.3-fabric)

Attack/use hooks raytrace collidable blocks then closest eligible entity and attack/interact through empty collision-shape vegetation. Excludes allies/tamed/vehicles. Gameplay targeting change, exclude.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\cleancut.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 17246c67b1098b14476b9c9cb36b8f1bc47aafb646f1df2610f4422fce44030f
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\cleancut\zone\rong\cleancut\mixin\MinecraftClientMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 d23ec893119ea417a5f9d9775ab40441c18cf9455efc5f234ad5159a97a5e267
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\cleancut\zone\rong\cleancut\CleanCut.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 ff3e6877dbcbcd24c5f95b7ad6946a2bf36335bf5f829b850eb253177e039cc2
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\cleancut\zone\rong\cleancut\mixin\MinecraftClientMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 d23ec893119ea417a5f9d9775ab40441c18cf9455efc5f234ad5159a97a5e267
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\cleancut\zone\rong\cleancut\CleanCut.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 ff3e6877dbcbcd24c5f95b7ad6946a2bf36335bf5f829b850eb253177e039cc2

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 281 resource-gamma-utils (26.3-2.0.3)

Gamma OptionInstance.get replaced with custom value; Iris toggle substitutes endless local night vision and removes it when disabled. Brightness/effect behavior changed; exclude.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\resource-gamma-utils.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 497a85dd3fbbbbb92211809d00156ee8264c6937dc542d78de9c7e5dfdd78d5a
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\resource-gamma-utils\net\morthen\resource_gamma_util\mixins\OptionInstanceMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 b2c378db02a0f8d1235d492753f38ecc6caee6bc7789992c11636a27bfdf2831
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\resource-gamma-utils\net\morthen\resource_gamma_util\mixins\compat\IrisMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 ee6363dc4cf0ed2e2f28ed4a8954e4751f4368bef7f0304d7cd81dd4749a265e
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\resource-gamma-utils\net\morthen\resource_gamma_util\mixins\OptionInstanceMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 b2c378db02a0f8d1235d492753f38ecc6caee6bc7789992c11636a27bfdf2831
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\resource-gamma-utils\net\morthen\resource_gamma_util\mixins\compat\IrisMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 ee6363dc4cf0ed2e2f28ed4a8954e4751f4368bef7f0304d7cd81dd4749a265e

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 282 get-it-together-drops (v1.5.1)

Item merge routine replaced with tagged custom-radius neighborhood merge, optional Y radius, and stop on removed entity. Changes merge opportunities/order/lifetime; exclude unless defaults proven identical.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\get-it-together-drops.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 0a1d5aab8d4b21b8947751e0cbccf59160cacefc3d0339ddac1fe777bc6f7bf4
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\get-it-together-drops\bl4ckscor3\mod\getittogetherdrops\mixin\ItemEntityMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 2b2d99783d27b65e939e690c46ada227e4e32146b0fb720fd5bc9df8341796b3
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\get-it-together-drops\bl4ckscor3\mod\getittogetherdrops\FabricClientEntrypoint.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 951f8bdcce2604d0b17b9247afbd149931eb44b8567a3b4c09f0a28a72cca4ce
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\get-it-together-drops\bl4ckscor3\mod\getittogetherdrops\mixin\ItemEntityMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 2b2d99783d27b65e939e690c46ada227e4e32146b0fb720fd5bc9df8341796b3
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\get-it-together-drops\bl4ckscor3\mod\getittogetherdrops\FabricClientEntrypoint.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 951f8bdcce2604d0b17b9247afbd149931eb44b8567a3b4c09f0a28a72cca4ce

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 283 cavemushroomfix (1.0.0)

Custom worldgen feature places red/brown mushroom groups in selected underground Overworld biomes with brightness/support checks and bounded attempts. Terrain/worldgen change, exclude baseline.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\cavemushroomfix.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 85b4e68b8289b6f2d7181c4ca28b37f4d57f34ffc0a67114835c1d53ed666222
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\cavemushroomfix\levsidorovi\cavemushroomfix\cavemushroomfixmod\CaveMushroomFeature.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 2395a4d34df943b89b4390a412d310d046e565a69f8723c4fbb55d9be2d71092
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\cavemushroomfix\levsidorovi\cavemushroomfix\cavemushroomfixmod\CaveMushroomFix.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 801d32690a13ea54756ca78c6645883b81e9c9127d8e89ddc3283108b1742d1d
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\cavemushroomfix\levsidorovi\cavemushroomfix\cavemushroomfixmod\CaveMushroomFeature.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 2395a4d34df943b89b4390a412d310d046e565a69f8723c4fbb55d9be2d71092
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\cavemushroomfix\levsidorovi\cavemushroomfix\cavemushroomfixmod\CaveMushroomFix.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 801d32690a13ea54756ca78c6645883b81e9c9127d8e89ddc3283108b1742d1d

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 284 pingfixer (1.0.2+26.1-26.3)

Server-status listener queues retries on disconnect, up to three attempts via concurrent map/queue drained in tick. Cleanup and success paths need full trace; menu/network utility rather than world FPS.

Client benefit: Server-list/session latency only unless further traced.
Disposition: Potential menu/network latency benefit; not a world-render FPS module. Requires scoped native/cleanup validation.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\pingfixer.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 702850477b75277f0d6137a2e9c5a661e524215277088c04f2ee4d7ee653180b
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\pingfixer\de\joker\mixin\ServerStatusPingerMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 f8b298e8f346f94b922b2686e988f38a890dbb11d3800ead20bddd74539cfda5
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\pingfixer\de\joker\ServerPingFixer.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 d94c56fcd3d56225cc57775b48766bf62015b5e20c2c52e22ea7e80cf3e76efb
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\pingfixer\de\joker\mixin\ServerStatusPingerMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 f8b298e8f346f94b922b2686e988f38a890dbb11d3800ead20bddd74539cfda5
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\pingfixer\de\joker\ServerPingFixer.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 d94c56fcd3d56225cc57775b48766bf62015b5e20c2c52e22ea7e80cf3e76efb

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 285 nodynamicfps (1.1.0+26.2)

Custom inactivity enum bypasses vanilla limiter, with out-of-world menu fallback 60; constructor default changed to disabled. Changes background/menu energy/frame policy, optional utility.

Client benefit: Pacing/latency/idle energy, workload dependent.
Disposition: Optional pacing/power policy only; not an uncapped foreground throughput improvement.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\nodynamicfps.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 fd7038182789c47e5552c6b831ecc035e3ae958d43ee3925ac314a96ac18afee
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\nodynamicfps\xyz\bluspring\nodynamicfps\mixin\FramerateLimitTrackerMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 49b8f91e2a1a430376f648a9e6691dff70b3bce8628d3fc4e95f6ebd7844c962
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\nodynamicfps\xyz\bluspring\nodynamicfps\mixin\OptionsMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 d84a186a1ef9dc9386eb52e4184ac90c0e69e34df97ac7051dbbbc3e890ed7a2

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 286 nimbus-2000 (1.0.2)

Registers broom and updates player flight on join/every server tick; food exhaustion canceled while Nimbus survival conditions hold. Gameplay flight/hunger change, exclude.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\nimbus-2000.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 bb3876c4601cab0fc46f2fc2a70aad153a43b16a90f4d3dcb13821225ddd73cb
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\nimbus-2000\com\piotrek\nimbus2000\mixin\PlayerHungerMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 e8dc52ef373c2dab3e5752c32e59bf6cc77ca0d093aa79384f3eedfa9fd8c709
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\nimbus-2000\com\piotrek\nimbus2000\Nimbus2000Mod.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 f58fe11391d28a09e5debabea403eb713740f62431d71dcc7d891ad74e9daa2c

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 287 client-movement (1.1)

Server movement-speed snapshots modified to preserve local sprint modifier; metadata assignment ID 6 canceled, ID 0 sprint bit rewritten from local state. Client authority/timing changes risk desync, exclude.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\client-movement.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 e78afbd73cff7fa210ac898437766b62a247464fbff51b82f9360c76e9a55a5a
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\client-movement\ch\zorty\mixin\client\AttributeMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 bff99e1131bf7735b5678b5c13e2f0d509a43ba96da782bcb160770b3f89153b
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\client-movement\ch\zorty\mixin\client\MetadataMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 5e16413da89cbaf83834d076a6a37c1789a976550fa54abbf0d5002539a502fb

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 288 rebind-quick-swap (2.1.0+26.3)

RecipeBook mouseClicked shift check redirected to held custom WLKeyMapping; default keycode 225. Input convenience; no renderer optimization.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\rebind-quick-swap.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 bf309009eeb6815049a1464761a60ce058478b22dc4267a9a15f388f8d1ea509
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\rebind-quick-swap\walksy\quickswaprebinder\mixin\RecipeBookComponentMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 64bf7c893c91cd2b9ff7d4c31c3aeeb9ae2fe5deddc414bd18eb3bfb1a50bd82
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\rebind-quick-swap\walksy\quickswaprebinder\RebindQuickSwapMod.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 66cdd138acfeca237a1f0a51e60b224eae2466b6aee2b7b1aa4717d0595dddec

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 289 player-hider-funnest-edition (1.0.0)

shouldRender returns false for other players when hotkey toggled. Deletes visible players, exclude baseline.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\player-hider-funnest-edition.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 dab30ccb9dd5e0c8626b2b9f5b9d1cc8495052b7c6b910d7b58fee42036c6e31
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\player-hider-funnest-edition\com\playerhider\mixin\EntityRendererMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 e8c7833da2c266c94e562225d2a4ec0a5e6c2bd3c4563d1c813efe46af6d96df
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\player-hider-funnest-edition\com\playerhider\PlayerHiderClient.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 a8814ad34788eda56fc4ddd8e90c83dac486afe24bd8b31f2c729a40d72d0fba

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 290 fast-ip-ping (v1.0.12-mc26.3)

Address resolver post-getByName passes original hostname and InetAddress to patcher to prevent reverse lookup. Relevant menu/network latency work avoidance; IP parser helper traced later, not world FPS gain.

Client benefit: Server-list/session latency only unless further traced.
Disposition: Potential menu/network latency benefit; not a world-render FPS module. Requires scoped native/cleanup validation.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\fast-ip-ping.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 bc389a1449f4db449a6af067175bf8b4385cdd498066270525a05da93dcac1dc
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\fast-ip-ping\me\fallenbreath\fastipping\mixins\AddressResolverMixin.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 8085aa51aaed0cc95500e96fcee9dfe914d6037505d5d74dad5dd140f0021c03
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\fast-ip-ping\me\fallenbreath\fastipping\FastIpPingMod.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 4a27e5a43c66ec5a18ad12115237b7e5992565f51836072d3f9bea4462d5c1ba

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 291 escape-from-the-void-with-totem-of-undying (1.07)

START_LEVEL_TICK checks players 32 blocks below minY, consumes held/offhand totem, teleports to maxY, clears effects then applies buffs. Gameplay rescue, exclude.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\escape-from-the-void-with-totem-of-undying.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 f8edf25a9b6233357ef95f9fc485496c395780b90245bc9c933710c6c283dd05
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\escape-from-the-void-with-totem-of-undying\io\silvicky\tou\Tou.java — selected class body first2400characters, metadata and hooks; large-class remainder not reviewed; SHA256 ccd5cdc19b49fc7e6da2e113d618d6693e142db4c6bfdc53500e638e6e267c76

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 292 enttick (0.2.0)

ChunkMap.tick call removed from ServerChunkCache.tick and moved to ServerLevel.tick TAIL. Entity network tracker timing changes; no redundant-work elimination demonstrated, optional bug fix.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\enttick.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 e933ff07b5b6d0503b73abe5f193c6d9abec15ffc8a016e86cd025da5a83c02f
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\enttick\cintlex\enttick\mixin\DontTickHere.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 4235c9c9ec9e4dd64cc9c662ba249e71808fd7d1e3ca8cd67f35f282a7fdf439
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\enttick\cintlex\enttick\mixin\TickHere.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 7b5d3513e53b83ea1576c5a5932779e6f71d7f10c0807dec90800a384530cad6

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 293 nomorenarrator (26.3-1.1)

Narrator.active forced false; every tick sets narrator OFF and hotkey false. Removes accessibility behavior, exclude.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\nomorenarrator.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 9f03daee217a0f3d942979100b14aee6a0c7573230ef0deccbc9a3bc7ccf2fae
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\nomorenarrator\com\dervarex\nomorenarrator\mixin\client\NarratorManagerMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 f3b93d9431a269d011c32b2dc74f3ebed423c654d9b32063ef8221113258b890
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\nomorenarrator\com\dervarex\nomorenarrator\client\NomorenarratorClient.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 7f7fe6fadc1fcf484a6b90765a3eeb60799b20fc9319c7ded08af5b3f1d4fc4c

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 294 disconnect-packet-fix (2.3.0-fabric)

IdDispatchCodec.encode canceled only when packet type absent from protocol toId and name is disconnect. Avoids invalid disconnect serialization exception; protocol workaround, no FPS mechanism; empty-buffer downstream behavior requires validation.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\disconnect-packet-fix.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 5028113a9dc30594a2a218c05a5f883037a1b91390cc9441cbf0a7dafb5452e2
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\disconnect-packet-fix\dev\ascpixi\dpf\mixin\ConnectionMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 3b449ec6959953d4748e77399000296846b8505b1f66b3af73b0afaa04cddee9
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\disconnect-packet-fix\dev\ascpixi\dpf\DisconnectPacketFix.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 66cd052c702b2b9c975f3455a6bbc2e51e69b4cf1aada8ce5eb98e7ce73c007b

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 295 nondirectionaldamagetiltfix (3.0.0)

Camera hurt direction for sourceless damage cached per DamageSource as random 0/180; directional damage calls original. Changes camera effect, exclude baseline.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\nondirectionaldamagetiltfix.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 3e590ee048652e2b305fdbefe06c595ef6e0699a0a418b947a02524e78d86034
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\nondirectionaldamagetiltfix\cintlex\nondirectionaldamagetiltfix\mixin\tiltmixinB.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 de12d0f12dd0720b25d4b70eda40190d14cab905890fc20415bc9debf29278dd
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\nondirectionaldamagetiltfix\cintlex\nondirectionaldamagetiltfix\NondirectionalDamageTiltFix.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 ccea6d6ad04b173505c548939e15f8c3eba7cd034922b182a7defd0d8aa9fa73

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 296 lite-fps-patrolin (1.0.0)

Limiter overwrite calculates absolute next frame deadline, sleeps whole milliseconds then spins with Thread.onSpinWait, resets if more than frame late. Pacing idea; target_fps zero guard absent locally, catch ignores interrupts, CPU spin tradeoff.

Client benefit: Pacing/latency/idle energy, workload dependent.
Disposition: Optional pacing/power policy only; not an uncapped foreground throughput improvement.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\lite-fps-patrolin.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 203d715f21d544f50ac825c0b9916cbec3da313e7a4b8f00aba0113b9306234d
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\lite-fps-patrolin\patrolin\litefps\mixin\FramerateLimiterMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 f8b0f686c6b70c6f2e18de3a9120063efb04cf583a5bce94ea30b19352708845
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\lite-fps-patrolin\patrolin\litefps\LiteFPS.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 ede0bac964159025f590c2c32da3e319e632b1ca278bca042414c5fb991b9d12

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 297 smoothmenu (26.3-1.0.0)

Framerate limiter returns configured cap for OUT_OF_LEVEL_MENU rather than vanilla throttle. Menu pacing option, no world-render optimization.

Client benefit: Pacing/latency/idle energy, workload dependent.
Disposition: Optional pacing/power policy only; not an uncapped foreground throughput improvement.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\smoothmenu.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 6aeeb57036d0ca205cecfb882821d85f237d4e0661ed2a5536d9f99449ec9dfd
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\smoothmenu\bookercatch\smoothmenu\mixin\SmoothMenuMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 36615f24e4ea9316d63c975a3e2a5361127d25f0e408eb17c947b94651b9499f

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 298 nopackcompatcheck (v0.1.1-fabric-mc26.1+)

PackCompatibility.isCompatible always returns true. Suppresses compatibility check without fixing content; no FPS gain.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\nopackcompatcheck.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 cfed481d1a112ff4fe910350e86693deed1204fd24ac13526f440e444566f238
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\nopackcompatcheck\com\wudji\nopackcompatcheck\mixin\client\MixinResourcePackCompatibility.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 f24fe0cfacc3cf51fbf61d4158c3057f17c484d929bb8542253374afb196ff94
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\nopackcompatcheck\com\wudji\nopackcompatcheck\Nopackcompatcheck.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 e43199e5e64987e8893976f8fa8cd642ed0536e97c6bfb2229d3fd4587f8d402

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 299 borderless-windowed-vulkan (26.3)

Top-level artifact bundles separate 26.1 and 26.3 nested mods, has no top-level classes. Nested 26.3 window-controller and swapchain hook reviewed below; window mode compatibility utility. Nested 26.3 tick stores/restores exclusive fullscreen and sets false when borderless enabled. SwapChain.hasImages reflective checks reject empty/null image list, null depth and nonpositive extent/size. Reflection fallback can inhibit rendering on changed internals. Old 26.1 nested implementation not deeply traced.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\borderless-windowed-vulkan.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 92a27cb10a53b02f24a9f5bffb4e056878f924e429a11d911348714d378028f6
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\borderless-windowed-vulkan--nested--BorderlessVulkan-26.3.jar\me\cutebow\borderless_windowed_vulkan\BorderlessWindowedVulkanWindowController.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 a0cae80a322f323714359df36a78fc45bac4c7d1cffb74d0ba930a0e35b537ff
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\borderless-windowed-vulkan--nested--BorderlessVulkan-26.3.jar\me\cutebow\borderless_windowed_vulkan\mixin\SwapChainImageReadinessMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 f0501dc1da9a46a5d7d116306c7a28a2470f5c5e2faf86ee28df1439087620dc

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 300 datapack-function-library (5.0.0+mod)

Datapack wrapper includes scoreboard initialization and command helper functions for counts/time/storage operations. No JVM implementation; sampled helper functions below, not transparent renderer optimization.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\datapack-function-library.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 e764d20cc6b3514884fe51ba289e41ea48b76e908f292b9254e39890c7a71c7f
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\datapack-function-library\datapack-function-library-5.0.0.jar!/data/dfl/dialog/gpl.json — first1800characters; SHA256 12ebeff07b8ed7037983f0d069d6f8336fa3bd5ada0a3ec1cb89c4a197a12439
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\datapack-function-library\datapack-function-library-5.0.0.jar!/data/dfl/dialog/lgpl.json — first1800characters; SHA256 95d17cd5062c1ed20261b5f90605de2e50b859aa7c222e3976379222481ad47a
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\datapack-function-library\datapack-function-library-5.0.0.jar!/data/dfl/function/dfl_enable.mcfunction — first1800characters; SHA256 3579a54b00d089967b855d69f0a0b6fbfc1242173ef54b10d903a2b519c64693
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\datapack-function-library\datapack-function-library-5.0.0.jar!/data/dfl/function/lib/change_max_health.mcfunction — first1800characters; SHA256 fbdf80cb60b02cc9b0a6cb305bf69d50381b16e1ba11908924fe13b3e024bc07

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 301 better-trialchamber-loot (26.3)

Overrides vanilla trial chest/pot loot tables with changed item weights/counts (corridor 3..5 rolls, tuff/scaffolding/torch; intersection includes iron block/diamond). intersection_barrel.json begins standalone item objects with comma separation, suspicious malformed JSON confirmed by parser below. Gameplay loot changes, exclude.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\better-trialchamber-loot.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 afdb565e52655a29f109b9d797b97009050270d841187e6dd6a06c9237917417
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\better-trialchamber-loot\better-trialchamber-loot-1.21.x-26.2.jar!/pack.mcmeta — first1800characters; SHA256 a4887eca78b5989748a84fa343384f27cf5fef775f3e3b5d929dfb5b0b700884
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\better-trialchamber-loot\better-trialchamber-loot-1.21.x-26.2.jar!/fabric.mod.json — first1800characters; SHA256 802d15d07392c90a26f01cb943ebb4524450ea3248323bdc1776adccc1ca0b45
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\better-trialchamber-loot\better-trialchamber-loot-1.21.x-26.2.jar!/data/minecraft/loot_table/chests/trial_chambers/corridor.json — first1800characters; SHA256 77ef2a72bfdbd69ddc72556ccb52a32bb0b821ea2b85530d4bede3a7a7ef9e4a
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\better-trialchamber-loot\better-trialchamber-loot-1.21.x-26.2.jar!/data/minecraft/loot_table/chests/trial_chambers/intersection.json — first1800characters; SHA256 5d726f9ec7861ee47ed8ee8cb90319066ab277dea972583824c0406f18d9616a

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 302 craftables-datapack (1.16-26.3+mod)

Inventory-changed advancements unlock new horse armor/ore/apple/totem recipes; datapack includes load/tick functions and new crafting recipes. Gameplay change; not FPS optimization.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\craftables-datapack.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 07ee84e981d05ca326bbf5bd7e8f30f0786c2a68219385c7a9324ddc87b6fcec
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\craftables-datapack\craftables-datapack-1.16-26.3.jar!/data/craftables/advancement/unlock_recipe/diamond.json — first1800characters; SHA256 f26fcc6724df4d124bd0fb946454f2b5be22af88ff5bed07d79397148041566a
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\craftables-datapack\craftables-datapack-1.16-26.3.jar!/data/craftables/advancement/unlock_recipe/gold.json — first1800characters; SHA256 6e6b9e917f6b63084f96a1c951ac637a1ac3a141c60f5ae57af243220c561c54

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 303 a-star-pathfinding (0.7.3+mod)

Datapack pathfinder uses storage/score context expressions, length-based distance with Y scaling 1.4 and danger/dislike cost penalties 160/80. Core mcfunction loops sampled below; command-engine tool, no unchanged vanilla pathfinding guarantee.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\a-star-pathfinding.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 7a08c88bbecbbdd90f45333955fe93e85c29e9cdd6574bc8e40089f1414db7a8
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\experimental\a-star-pathfinding\a-star-pathfinding-0.7.3.jar!/data/astar/context_float_provider/distance_to_end.json — first1800characters; SHA256 25ed6b9e8998342e6c012578870a1e03626d93febef21a860d857e201f4e2d60
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\experimental\a-star-pathfinding\a-star-pathfinding-0.7.3.jar!/data/astar/context_int_provider/added_cost.json — first1800characters; SHA256 9398e8c0a3f5e01700e86fb2994825003921f005cdd8f2ed41cd18ac606994bd

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 304 mascom (m1.0+)

Macro run stores command and count then recursive function decrements counter, executes interpolated command and recurses unless exactly zero. Zero/negative input may run until command limit; global storage/counter lacks reentrancy isolation. Command repetition utility, exclude.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\mascom.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 70a8b4721daf0839595c0ac3931cff94b573eeb32e26413cbcd88b4f2db18508
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\mascom\mascom-v1.0+.jar!/data/mascom/function/private/actually_run.mcfunction — first1800characters; SHA256 35a28de1b116343c650853bdf310f96fda5451985411b19ef730624760117a77
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\mascom\mascom-v1.0+.jar!/data/mascom/function/private/load.mcfunction — first1800characters; SHA256 2f2b03dc38c207a18d4fa56c5cfe4a2a6d3877b09789ef2ace308ff61bdb7be1

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 305 forced-render-distance (v1.0+mod)

Tick datapack damages each player 0.1 if block position +161 Z is loaded. Does not read client render-distance setting; server loaded-chunk heuristic can punish unrelated loading. Directly violates gameplay/render-distance constraints; exclude.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\forced-render-distance.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 85f158741e3061b38c41fac22fb223a69aec3e063a9374aad67466bbc802713b
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\forced-render-distance\forced-render-distance-v1.0.jar!/data/minecraft/function/run_render_distance.mcfunction — first1800characters; SHA256 6e161c7fa17f5e7014194cf9cd86a74e3309e6e0712a1c8bdb8c7ff5cd0312f2
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\forced-render-distance\forced-render-distance-v1.0.jar!/data/minecraft/tags/function/tick.json — first1800characters; SHA256 7837e9edf4bb7cfae7ae4c642574d5886471adaa1132971aa4c328ced4c13586

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 306 pearl_optimizer (26.3)

Top-level artifact is multi-version nested bundle requiring pearloptimizer and silicon; no top-level classes. Nested 26.3 pearl prediction reviewed below; not transparent optimization. Nested 26.3 EnderpearlItem.use creates ClientPearl for local client player at consume call; concurrent PearlBuffer stores predicted objects with explicit clear/remove methods. Prediction reconciliation/lifetime and silicon dependency remain to audit; gameplay timing changes.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\pearl_optimizer.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 ec92695cd489f1da49dc42a6059a40377a0f3dd2e8695e9023aa6503006bbcee
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\pearl_optimizer--nested--PearlOptimizer-26.3.jar\me\cutebow\pearloptimizer\mixin\EnderPearlItemMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 17a9ae1f068849634c5b67ff9bbb6371957d0c1c94735f06f402b11454501f1a

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 307 simple-sugarcane (1.2+mod)

Appends all-block tag to supports_sugar_cane_adjacently and first-load scoreboard/tellraw. Allows cane without water by changing survival support conditions. Gameplay change, exclude.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks:

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\simple-sugarcane.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 c0aa188b462f0e441f0e919f18cc5aea28caf857a6008be03d8306d0583b1036
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\simple-sugarcane\simple-sugarcane-1.2.jar!/data/hydrated_sugarcane/function/load.mcfunction — first1800characters; SHA256 bda851c2e6707c64ad6524b1c35b1af530b8ecc7934ba67f4264ca9b96be4805
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\simple-sugarcane\simple-sugarcane-1.2.jar!/data/hydrated_sugarcane/tags/block/all_the_blocks.json — first1800characters; SHA256 70520c82307627de0a6f7bb739117b7516b419b90326e6a1806838ec0b3c8bd8

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 308 lithium (mc26.3-0.26.2-fabric)

ServerChunkCache.getChunk uses a four-entry coordinate/status cache; off-thread requests are marshalled to the main executor and joined. Game-event dispatch uses a dimension-owned dispatcher map rather than chunk lookups.

Client benefit: Existing AstFPS bundled coverage.
Disposition: Reuse existing bundled module; avoid duplicate mixins.
Risks: Chunk unload/status transitions, tickets and dispatcher registration must invalidate auxiliary state; blocking joins and overwritten methods conflict with other optimizers.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\lithium.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 86b6c68adf62f3073b297f190065c116cc3de147ef01b2d2bacc0c4ef199d340
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\lithium\net\caffeinemc\mods\lithium\mixin\world\chunk_access\ServerChunkCacheMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 3342919d375202828c92a4aa6235cd19876ef933541cdaa18a6249184c218975

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 309 jasione (1.0.9+26.1.2-fabric)

ASM analysis rewrites only enum values calls passing InterpreterEx safety analysis; generated cache classes retain one VALUES array. Class initializers and extensible-enum package are skipped and analyzer failure leaves calls unchanged.

Client benefit: Existing AstFPS bundled coverage.
Disposition: Reuse existing bundled module; avoid duplicate mixins.
Risks: Must prove alias/mutation analysis sound, enum extension compatibility and classloader initialization; generated arrays are shared forever.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\jasione.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 f8d2d6566d37a030ebbc3b071d89f11a64d32a20844c26ab7e1f814d5eeb3da1
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\jasione\org\spongepowered\asm\mixin\transformer\JasioneMixinCoprocessor.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 b297580a36d73cb35b8093f3e139734ee5c8de85ac8129cbfabbead02676c757

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 310 asynclogger (2.2.2+26.1.2-fabric)

Bootstrapper invokes LoggerConfigurator: replaces global Log4j factory with async selector, restores appenders, configures ring buffer/system streams; optional debug-log deletion.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Only log-heavy workloads benefit; global logging context/appender/shutdown ordering and logging loss policy require dedicated compatibility work. No blanket application.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\asynclogger.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 1cdb0e0c13deaf0095fc6dd4b010682e5906c42d5f9d445b551b49e167e257ae
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\asynclogger\me\decce\asynclogger\mixins\ClientMainMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 20a573d3da370dc4b5ab19d6aab372d5aafdecfeb39d468ecae1c46f75b11cb2
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\asynclogger\me\decce\asynclogger\service\Bootstrapper.java — full substantive class body read in second pass; SHA256 cadbc9ac66495f313ffa1cbc2f379a081036be375331b091793a1ca174b0c2f6
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\asynclogger\me\decce\asynclogger\core\LoggerConfigurator.java — full substantive class body read in second pass; SHA256 5803890d4da3822e6839aac38e14abcc960bdb33db2fac7075ee27ef80e7c495

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger.

## 311 packforge (1.4.1)

SpaceAdvanceCodec admits only exact native codecs, JSON map type and >=256 entries within reload budget; eligibility verifies codepoint/numeric forms; decode accumulates DataResult lifecycles and falls back on malformed/retired data.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Promising pack loading work; 129-file reload executor/archive/atlas infrastructure remains partially traced. Narrow native pack-path Formatter removal implemented separately without borrowing this codec.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\packforge.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 68b05d06097f0aa09b644554038941ac553fad3f914beb48f1d25587c4401c84
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\packforge\com\teenkung\packforge\client\mixin\font\SpaceProviderDefinitionCodecMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 4ed142b55e4d87d8a3378ff2bb14b26492f4e12eb5f54a3bf9288396ffd8baa1
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\packforge\com\teenkung\packforge\client\font\SpaceAdvanceCodec.java — full substantive class body read in second pass; SHA256 53b72ae517d3547f695daa418a6dae86a27ebd993179269fae193a4983c50d60

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger.

## 312 unloaded-activity (0.7.3+26.3)

Block entities persist last_tick/last_ms; next server tick computes elapsed time, optionally wall-clock based, and runs TimeMachine simulation above a configurable threshold before updating timestamps.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Catch-up simulation changes unloaded-world behavior and clock jumps/config multipliers alter gameplay; NBT migration has compatibility requirements.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\unloaded-activity.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 9a1f4957aa48a0fcfb3c91b64473fdba2fa896e370edf6ee6db4de9eb464e581
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\unloaded-activity\dev\moono\unloadedactivity\mixin\BlockEntityMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 8992129250f332cdef4e03e09d83a46a1fd21e25f03057ee1903d37344aec32f

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 313 helpful-commands (4.2.3)

ModCommandManager registers fly, god, repair, teleport, inventory and other commands with categorized permissions.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Commands introduce new gameplay powers, permission surface and persistence; no hot-path FPS improvement established.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\helpful-commands.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 9ee92b4aa87f20fa50bfe570e053e691d384faae3730d02d88c0c3eb66eff1ac
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\helpful-commands\com\expecticament\helpfulcommands\manager\ModCommandManager.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 691926dfc0bd4b57e7244be4f0afeb09c4e0279409d245f4f937e03adab5005d

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 314 carpetgui (2.0.0+26.3)

Replaces Carpet Rules network handler with a wrapper that records manager/value/name entries, then calls the original handler; a mixin plugin conditionally gates old chunk recursion fix.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Rule list lifecycle, manager-qualified keys and unchecked optional NBT fields need review; requires Carpet internals.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\carpetgui.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 e75708077c595142105179144cee8393b519cb3add470cf841d847d361d92f5a
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\carpetgui\ml\mypals\carpetgui\mixin\CarpetClientNetworkMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 24ab232903fd4e494e64ae9747ca70d12e74854243ee7903beafc7b61ff845d7

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 315 pack-tools (1.26.6.2)

ClumpedOrbHandler stores value-to-count maps, caches XP totals, merges maps and ages, processes each original XP amount for repair, and saves counts/values to NBT.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Orb identity/visual counts and pickup timing change; mending ratio is configurable. Other QoL features need separate approval and tracing.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\pack-tools.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 c1678902361ce8c8d5274fab803046dbd7bef7bce79afcbb9d48a42d225218c3
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\pack-tools\com\frikinjay\packtools\mixin\client\features\quickplace\LevelRendererMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 f547e79e6f8a3684054aa920eb37da31972d25f1876363273700ee6f5a01968e

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 316 crashpatch (v2.2.1)

Crash report constructor identifies a suspected mod from stack trace; getDetails appends scanned preceding log errors. A debug property intentionally throws at loader entrypoints.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Crash recovery cannot guarantee restored state; reporting is useful but sampled classes do not establish safe recovery mechanics.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\crashpatch.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 fbb54cb5bd0a89d5ef71d31cd6ed55ca7c052acefc32c2b8b452721ca5baee92
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\crashpatch\org\polyfrost\crashpatch\mixin\Mixin_IdentifySuspiciousMod.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 5a7c0fbcd8fa70c0d8b4fa1161b90011cc540f04ed884e250429c70fb5e920a7

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 317 chunky (1.5.3)

GenerationTask uses a selected shape/iterator, bounded working-count setting, region cache and synchronized progress aggregation; mixin invokers expose chunk futures and main-thread update hooks.

Client benefit: Existing AstFPS bundled coverage.
Disposition: Reuse existing bundled module; avoid duplicate mixins.
Risks: Generation shifts cost earlier and writes world data; cancellation, tickets, disk capacity and main-thread ownership remain to trace.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\chunky.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 bc4c8092785422d540b323ecfaee479caefbe0399f1b1c923522d23572fadb51
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\chunky\org\popcraft\chunky\mixin\ServerChunkCacheMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 b5136f1cfed27f3490ff8108398c442caffa1a6c00dd4a8bfec976f8b4ecd7b6

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 318 better-block-entities (1.3.9+mc26.3)

Alternative render dispatcher reloads alongside vanilla dispatcher; chest item submission conditionally substitutes Christmas sprites and otherwise delegates original model submission.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Hybrid renderer needs animation/light/resource-pack parity, Sodium-independent design and ownership auditing; Christmas substitution is a visual change.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\better-block-entities.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 18bc288ffbc5d1a79e8d8cf82043b69504d756853e27b15a90e29685f8348a38
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\better-block-entities\betterblockentities\mixin\model\item\ChestSpecialRendererMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 32c175d9b0fdd1fecb64c7f15bcd3ab446e577dd4acdd51c417d01bf9341bc60

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 319 config-editor (1.1.11+26.3)

Editor registers plugin entrypoints, keys, HUD overlays and config shutdown. MinecraftMemoryMixin clears particles and calls System.gc on setLevel/clearClientLevel.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Forced GC may create pauses and freed-memory logs are not performance evidence; UI/AI integration lies outside optimization scope.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\config-editor.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 6e1d807b0fa88acee0d2549727343895caed86464431fb0356a869239cd800b6
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\config-editor\io\github\zhengzhengyiyi\mixin\client\ExampleClientMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 19fb6a8704746cc64ee655b44d7fea2a6e0a128697197bd88d465ef5af72710f

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 320 xeno (0.1.9)

Chunk rebuilding redirects background executor and changes compileSync to compileAsync. Terrain group and OIT rendering bind shared index buffers and common uniforms, selecting normal/multi-draw pipelines per layer.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Async region lifetime, cancellation and GPU/index capacity must be audited; overwrites overlap AstFPS renderer. OIT parity is essential.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\xeno.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 19d686544d27c3b30cd5667dc17b95216817a3433d5b7ad5d924c564564e608f
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\xeno\com\xeno\client\mixin\XenoChunkExecutorMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 405d68580a9444e2692e83b9e822de3dc140fe068081311c118665ddf6809b14

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 321 cbbg (1.5.0+mc26.3-fabric)

Frontend render pass adjusts compiled pipelines for floating attachments when shaders are inactive; pipeline cache insertion/resolution records pipeline mappings.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Higher precision can cost bandwidth/VRAM; shader bypass and cache/reload lifetimes require review. This deliberately changes color output.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\cbbg.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 6dbc2b71738055f05755b25d3c07342bd5044a57ee8374b0f434b8f6c8febf68
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\cbbg\com\qb20nh\cbbg\mixin\FrontendRenderPassMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 5a76d6dfd75518befc75cf8052d20bab72870751a3b0563d5b4510bba9623de5

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 322 nvidium (0.4.4-beta7-26.3)

Capability gate requires NVIDIA mesh/bindless/unified-memory/sparse-buffer extensions. Sodium uploadResults is cancelled and uploads rerouted to Nvidium renderer. Fog distance is extended/clamped.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Sodium dependency violates current integration constraint; hardware/driver gate and sparse-memory lifetimes need audit. Fog settings can alter visuals.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\nvidium.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 c36039b5bbc0b6f4b5b83238c5ee1bb79029760179863aece6a263cb4d696174
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\nvidium\me\cortex\nvidium\mixin\minecraft\MixinFogRenderer.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 3ec564129bae33cffd0d9e3641d2bb2fd4617a310d2d0acee1a04490ce3303c7

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 323 hitbox (v1.3.2)

Tail hook submits custom hitboxes; FogCaptureMixin snapshots fog color and environmental/distance limits for hitbox rendering.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Debug overlay changes display and requires render-state/fog lifetime parity; renderer helper internals remain untraced.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\hitbox.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 fd4335e6152c2ad8f876baaff53f14d858cf172850057979a944f48fdde3ba24
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\hitbox\org\polyfrost\polyhitbox\mixin\HitboxRenderMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 d7a433ce9889d899ed1ec5162a2e58ac0859e3bde03ab7ad0e73141a2d97619f

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 324 really-fast-paintings (2.0.0)

Painting placement is intercepted, replacing entity placement with block-backed painting service; client reports success and server shrinks item on success. Distant renderer may scale tiny paintings and uses fullbright lighting.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: World representation, drops, collisions and remote tracking change. Far-LOD scaling/fullbright violates strict visual parity.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\really-fast-paintings.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 0a4d9c846f0d3beab8e6de22445dd1ba64bb5af0ef19c96a2af53e1ba42de9e0
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\really-fast-paintings\me\justbecause\fastpaintings\mixin\HangingEntityItemMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 1b23b30ff2d0d20da6e071de0808a17d04d92bdc00aae55f9dc8af9c7c2822f7

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 325 command-profiler (1.4.1+26.3-pre.2)

Hooks enter/exit profiler around command-block execution and enters function/macro depth using ExecutionContext metadata when profiling is enabled.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Exception paths may leave unbalanced profiler frames; sampling overhead and bounded recording require review.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\command-profiler.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 801202c6a0f6979b90ba4996c9f91c763953d3e2d0d96dc8f0f06536b3286a74
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\command-profiler\dev\epicpix\command_profiler\mixin\BaseCommandBlockMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 198112c0e7b63147705181006adff847ef9579ab207582bad6630a8ef05f62ab

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 326 put-a-plug-in-it (fabric-26.3-1.3.0)

ClientWorldLeaveCleanup polls world presence then reflectively clears ModelManager BlockState maps and maps with BakedModel values; ModFixes dispatches EMF/ETF renderer cleanup and mod-specific world/respawn hooks.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Do not copy heuristic map clearing: native models are shared across worlds/reloads; field identity and owner lifetime must be proved. Identity-hash comparisons can collide. No native26.3 leak demonstrated by this sample.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\put-a-plug-in-it.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 4198b8ce8b1622021ed929346447174ffcd5b6774ece838854f9ac869790606a
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\put-a-plug-in-it\com\dipilodopilasaurus\putapluginit\mixin\alltheleaks\LivingEntityRenderPostMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 4fb5ea73900dea21ba095f5871f84943c5383d0163c0d70ee516a63851306b14
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\put-a-plug-in-it\com\dipilodopilasaurus\putapluginit\modfix\ModFixes.java — full substantive class body read in second pass; SHA256 c18ed50ef8fe3374895c74308c614e375057f7c268a7ac85d7b843ccbf34da00
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\put-a-plug-in-it\com\dipilodopilasaurus\putapluginit\leaks\MinecraftClientMitigations.java — full substantive class body read in second pass; SHA256 205375ba90b5cf9209e1bc7c8e762772d2bc8325ebad9446dd7e9678ccc034ef
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\put-a-plug-in-it\com\dipilodopilasaurus\putapluginit\leaks\ClientWorldLeaveCleanup.java — full substantive class body read in second pass; SHA256 219554bbc36bab2aae9b230122fb88976c94c0990b21cf11829827f173e0e615

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger.

## 327 screenshotmetadata (1.4.2)

Screenshot grab captures prior newest file in ThreadLocal, removes it at TAIL and asynchronously finds the new screenshot on IO pool before collecting/renaming metadata.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Live client/player access on IO thread and simultaneous screenshots may misassociate state/files; no sustained FPS optimization.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\screenshotmetadata.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 9c5d53059c4ab5d164c52a699d9d8f88bc0f41fee3195a12c5e63df72134e8a9
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\screenshotmetadata\com\fentbuscoding\screenshotmetadata\mixin\ScreenshotMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 34feb8f452e6e65534128ae9e15ebacad7cc731a58e4aa01c73f400f5baebb39

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 328 antideath-carpet-addition (v1.6.0-mc26.3)

Fake player mixin adds lock-state field; Carpet HUD update invokes registered logging event hook.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Rule extension requires Carpet and alters gameplay options; sampled lock/log hooks do not establish general optimization.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\antideath-carpet-addition.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 2c6b14cfce416246208457f862b73e1dcb6df415cee24707a2bb091c44c9789a
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\antideath-carpet-addition\io\github\jfglzs\aca\mixin\carpet\EntityPlayerMpFake_Mixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 0fa99ed7cb119248c8105be0dc068a9ae6f09640d78ec7ac672a1c11e47604e0

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 329 pulsenet (1.1.0+26.3)

PacketBuffer is per ServerCommonPacketListenerImpl; queues block/coalesced/other packets separately, flushes in queue-class order and creates clientbound bundles. Coalescing drops individual listeners; explosion threshold replaces changes with full chunk resend.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Server outgoing/network timing feature, not remote client FPS fix. Queue partition changes cross-class order; block resend/coalesce callback semantics differ. Native client send path is not this subsystem.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\pulsenet.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 e3a1f4289245d033dbed2e40a21a7518aefc6db04c785ed9005c91462e066a0d
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\pulsenet\dev\pulsemc\pulsenet\mixins\ConnectionMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 7883cca4d44f115d53e3240cdfbca47857534924a7725ac26fce73b0d0e5bb58
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\pulsenet\dev\pulsemc\pulsenet\network\PacketBuffer.java — full substantive class body read in second pass; SHA256 b3f311346defccd47745f393f0b8fcaef92827a13b9cf551733cb31878c754f8

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger.

## 330 simplehud (2.2)

Registers FPS/ping/CPS/location/time/date HUD elements and an SDL mouse event watcher with per-click timestamp lists.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Event watcher removal, thread ownership and timestamp trimming need audit; added HUD work is diagnostic utility.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\simplehud.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 1ba1a3cac9d65c3cb0e96e160b0c7bec8d50e3166c4b19b2ecaef9768b0d1535
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\simplehud\dev\losterixx\simplehud\client\extra\HudRenderer.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 f224184bf7a2b2f3ce993defbd2f9005493c172d028f41689efac45d20f443ea

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 331 entityculling (1.11.3)

Block-entity render-state extraction returns null for culled entities or inflated-AABB frustum failures; whitelist, globally-rendered and shouldRenderOffScreen cases retain rendering.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks: Async visibility staleness, transparent blockers and custom bounds can hide visible objects. Forced-visible and worker lifecycle need complete tracing.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\entityculling.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 38b7edc443cf58d94b91e006cbed5c9a030ce08285c8242241c65467b15014fe
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\entityculling\dev\tr7zw\entityculling\mixin\BlockEntityRenderDispatcherMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 8c70954e2b978e3ccc7b72413d90b978a0e8939ad19ac0b1b21b340b046c6da1

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 332 immediatelyfast (1.17.1+26.3-fabric)

GUI animated items share an animated atlas; frame-end bookkeeping and invalidate/close hooks manage it. Enhanced batching forces feature-group canReorder true.

Client benefit: Existing AstFPS bundled coverage.
Disposition: Reuse existing bundled module; avoid duplicate mixins.
Risks: Reordering may affect blending, depth and special renderers; atlas identity, texture reload, capacity and cleanup require full parity audit.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\immediatelyfast.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 e9eae1c673f94a58eb1b933a55db72ccde56bcec06054656952498bcefe69983
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\immediatelyfast\net\raphimc\immediatelyfast\injection\mixins\batch_animated_item_updates\MixinGuiRenderer.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 3dc93a0b5f8b0cc1391294a9026fb52f0e784e90d43ec7ab2f92a954bc42c408

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 333 xaeros-optimal-beacons-add-on (1.3.0)

Xaero map context menu adds beacon previews, tiers and planning from selected areas; highlighter is registered before registry freeze.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Map-addon dependencies and persistent overlay state; no rendering optimization mechanism established.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\xaeros-optimal-beacons-add-on.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 4139149d9bb88cc56ad4ebafa76524bb0c5c9b30686aa96f6327497836f2cdeb
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\xaeros-optimal-beacons-add-on\deanxbox\xaeros_beacon_addon\mixin\client\GuiMapMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 03d91ea14a6cbf31077cacb31a3a088dc4a7cb8807cf0244283a94e3e08b1c84

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 334 crashfixer (3.1.1+26.3)

Client entity-add mixin owns recent timestamps/cost queues and per-type loaded-entity maps, indicating resource-limit enforcement; exact thresholds/handling not fully traced.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Rejecting entity/packet work can change visible/server state. Static maps require disconnect cleanup; safety claim remains partial.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\crashfixer.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 b4d180917779174e11a819bbdc857ac4f7198a2926dd3fe1c9d1c8ef674cfd0d
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\crashfixer\cc\modlabs\crashfixer\mixin\ClientPacketListenerMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 b23145e89c060611f8c14fe7f6ab456e735c6b766f01b3617809d0c3fb16c1c1

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 335 shuttfup (2.9.1-26.3)

Config-gated hooks suppress TextureManager.tick and weather rendering; artifact additionally contains telemetry, chat, loading-screen and log tweaks.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Stopping texture animation/weather explicitly changes visuals. Never include all switches as vanilla-preserving performance gains.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\shuttfup.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 9b077205093d83e8620db7ab859e041c61197139311eaeb7569f5af273a00bb2
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\shuttfup\stfu\mixin\ThreadPriorities\MainMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 f5eed261c840626b236ea6653f8df5d9d4e57174de8bb8879e1ee01b5b72589d

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 336 jauml (2.3.1+fabric-26.3)

ModuleVersion compatibility accepts same major and current minor at least required minor, returning false for missing/malformed versions; constants identify config library.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Patch version and prerelease semantics are not checked; config IO/thread lifecycle not traced. Library adds infrastructure rather than direct FPS.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\jauml.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 43a932193126fdb43da919dabefebc3a9b008f9b1724c3e994108e349378bbaa
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\jauml\tn\naizo\jauml\util\ModuleVersion.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 72edd601535c74fd9cc7035d63aa0f1820674806ecaccc425504f72ec43eca99

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 337 item-name-gradients (1.0.2)

Item hover/styled name RETURN hooks replace components through GradientItemNameRegistry.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Changes visible text and possible repeated component allocations; cache invalidation for item/name/rarity needs review.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\item-name-gradients.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 5f8813fbb97880dd4f9912b14fc8437412d0906274c7a47f25173fd9c8cd363b
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\item-name-gradients\com\thenev\client\mixin\ItemStackNameGradientMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 40271f6e31740cffc767a554234bb5b830775666d0aef0c8049389acf07cfe11

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 338 better-render-distance (1.2.2)

Entity cull cache computes horizontal and vertical ellipsoid inverse radii from effective render distance, vertical scale and entity scale; entities outside shape are culled.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks: Diagonal/high/low visible objects may disappear relative to vanilla; settings cache is handled but shape itself changes coverage.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\better-render-distance.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 1b0966264a9212aed9fca134c26bd6c2462d248ac005511351974a79d84f2419
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\better-render-distance\com\warma\betterrenderdistance\mixin\BetterRenderDistanceMixinPlugin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 bbde42885325069cb0759a79fa9cce062febbbda9569086ce4c2913217781a44

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 339 disable-fog (2.2.1)

Fog type/environment applicability is overridden per dimension and water/lava/powder-snow/blindness/darkness settings; dark sky disc may be disabled.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks: Fog and effect visibility changes gameplay cues and appearance; not a strict visual-parity optimization.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\disable-fog.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 ed2b87cd6a465c7f782a3cbba625d3367434efefdcbfd07e01d5e86591561eec
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\disable-fog\com\sergo467\disablefog\mixin\FogRendererMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 a2d366f427004092fecb6af029642bd6c62d79dfc750a71eafacd570b69a5d9e

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 340 rsls (1.4.0)

SoundExecutor pollTask checks shutdown/execution state and consumes queued runnable directly; sound-packet hook avoids normal thread scheduling but restores original operation if world absent.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Audio thread ownership, source limits, callback ordering and world unload races require tracing; changing source limits may change audio output.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\rsls.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 9d7a814fa545a113902b14453cbbe73dc5782385601b9b31e4a6a688449b1c32
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\rsls\com\ishland\fabric\rsls\mixin\MixinSoundExecutor.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 6915859452a8d74ea0b03f560ac05f7c78a9f33081fe2c274c793d55ed94d6b5

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 341 tt20 (0.8.5)

At server aiStep TAIL, missed ticks accelerate positive/negative mob age towards zero when enabled; commands are registered for control.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Makes time progression wall-clock-like under low TPS; changes farming/cooldown behavior and is not equivalent simulation optimization.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\tt20.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 62d3fcbc86109dffd0ae0f52cc6c386645075e93f61dca2c00aad024c57297e4
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\tt20\net\snackbag\tt20\mixin\AgeableMobMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 d651c67b1967b1bacd12c1c706fd96a5fe3483497e93059812e43effa99b081c

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 342 lightaura (8.9.7)

Tick handler tracks held/dropped dynamic lights in maps, clears them when world/player absent, gates work by update frequency/performance mode.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks: Adds lighting and section-update work; movement/update frequency changes visible lighting. Useful feature but not parity-preserving FPS.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\lightaura.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 24c19230396cc8525e8c32aff56f488742d46511b359bdd2222df6db28c64fc6
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\lightaura\com\osama\lightaura\client\mixin\ExampleClientMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 49082cee043c347cada84b5962cb49b4cadc7aa6f573fecd1426fcae0129d214

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 343 optimized-cushions (1.2.0)

CushionBaker captures model polygons per EntityModelSet identity and facing, emits block BakedQuads with sampled section light. CushionTracker owns entity snapshots/section maps and marks native rendering baked after section tasks.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Same-section changed snapshots do not call markDirty unless section/bakeability changed (update117–135); commitBakedSection153–162 lacks a matching compilation generation token. Dynamic entity light/shading parity and GPU publication contracts remain unresolved.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\optimized-cushions.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 56f5299bc19760e857a99c1b8e6e177f9dd5457ffc9b15697756800db15729c2
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\optimized-cushions\xyz\nikitacartes\optimizedcushions\mixin\CushionRenderStateMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 d7b7ebdfcab2105cad2a2070a4d833047631f9f08b18321530d3d06e5c67f6e1
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\optimized-cushions\xyz\nikitacartes\optimizedcushions\CushionBaker.java — full substantive class body read in second pass; SHA256 cd46fa0af29d8a9f7ca2c18cf7283d93a975c1536534cbf017c7ff80dff19566
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\optimized-cushions\xyz\nikitacartes\optimizedcushions\CushionTracker.java — full substantive class body read in second pass; SHA256 9d08f96fc05e11b69ddce7f71dde0889ee2be9c3c2d578a2043074f554cfa6d1
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\optimized-cushions\xyz\nikitacartes\optimizedcushions\CushionSectionTasks.java — full substantive class body read in second pass; SHA256 fea96a6fd23402376c273dbaf7a03fa15d96a6c7dc211eb4f6a1dfc60200d7bd

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger.

## 344 reflex-antilag (1.1.2+fabric-26.3)

Frame-start scheduler sleeps before input polling and records simulation/render/present timing; debug overlay exposes latency metrics.

Client benefit: Pacing/latency/idle energy, workload dependent.
Disposition: Optional pacing/power policy only; not an uncapped foreground throughput improvement.
Risks: Pacing trades throughput for queue latency; sleep prediction, GPU fences and VSync/limits interaction need audit. Publisher Reflex architecture claim not independently verified.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\reflex-antilag.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 3bfacfba92ffc4eeec4c6359807bd1e468da5b38b930552e08e02d6f56784426
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\reflex-antilag\io\tythee\mixin\MinecraftClientMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 3c3e92c03e8e20bf82740fda75af6ce3afc65210864460fe393830bd7f123625

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 345 boosters (1.3.4.1-hotfix)

Distance multiplier reduces block-entity view distance; entity shouldRender returns false beyond configured max distance and defers to other culling mods.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks: Visible distance reduction conflicts with requirements; described AI throttling/particle reduction would also alter behavior, still needs tracing.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\boosters.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 824ab82e38b6c6bfc023277f7e543478327d56783e46f7cd641243e311df8481
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\boosters\com\boosters\client\mixin\BlockEntityRendererDistanceMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 574097d8776a1bab4315c1604009e1c2a1f6f3789a4ec42992d2b2f7e57bbf15

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 346 mc1.16.5-sodium-chinese-localization-pack (5.6.7)

Sodium option names and pages are translated using I18N and mapping tables.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Sodium internals are version-sensitive and dependency is disallowed for AstFPS; no runtime optimization.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\mc1.16.5-sodium-chinese-localization-pack.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 ebf01094059e3b4e397b35b9277507879c3a623646d4a5443607b40699cdaf73
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\mc1.16.5-sodium-chinese-localization-pack\me\loongly\mods\sclp\common\mixin\sodium\MixinModOptionsBuilderImpl.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 21423554618565097027a160e5516824cfd889a83abd10a5a6b98a88a56f9137

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 347 fastquit (3.1.5+mc26.2)

Storage access mixin waits for background save before backup and marks storage operations synchronized; edit-world actions wait for in-progress save.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: World save ownership, process shutdown and concurrent reopen/delete require full trace; faster exit UI is not FPS improvement.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\fastquit.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 463708bbc02c4b8e6e77a0294f66cf596dea42d1359447bb44bf0632b9e2f9de
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\fastquit\me\contaria\fastquit\mixin\EditWorldScreenMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 ca21a71b69d9c460c4b4e5ab926eb6c652c6162dd1a1cf603bb3ce5444b8f110

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 348 inventory-item-groups (1.5.3-fabric+26.3)

Creative tab collection removes grouped items except icons; click intercept toggles group instead of carried item; displayed icons rotate through group contents.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Changes inventory UI and slot mapping; empty groups and index translation require guards.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\inventory-item-groups.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 9a8ef1c93c90c1c39a7c4cbee931bcaf357a28dd71aac696775ac90bb8c979b2
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\inventory-item-groups\io\github\bizcub\inventoryItemGroups\mixin\CreativeModeInventoryScreenMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 1144ad37e8ee857f8bd504b86fc798378accfb8a48b977575d03196875f5c847

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 349 mac-input-fixes-neoforged (26.10.03-p)

macOS-only control modifiers are merged before keybind handling; native hooks initialize once after load; full-stack drop modifier is rewritten.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Native hook lifetime/OS gate and input semantics need audit; Windows user's FPS project gains nothing direct.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\mac-input-fixes-neoforged.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 d7ffe895099d6cd179a6332c41539e111b9f42d66f9063c5652c9014ff8677c6
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\mac-input-fixes-neoforged\com\hamarb123\macos_input_fixes\mixin\InputWithModifiersMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 ef095b99155a73c5446f0e4e5905c83bcef9088198fd0ba871fdfd632c44a997

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 350 iris-extension (1.0.3+26.3)

Dragon fight state changes send custom payload only to capable clients, thresholding progress changes at 0.025; accessor exposes boss state.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Requires shader/Iris context; synchronization semantics and initial/join payload need proof. No standalone FPS optimization.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\iris-extension.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 e57b979b426e2cb1d12351f0966ceb269a72449017fe8ba64d201881a22dc7b1
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\iris-extension\merlin1809\irisextension\mixin\DragonFightMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 0da69efda38379d424f5f347a8aff6992f3f95442962d2bcb6c36d0716a74600

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 351 sah-project-nofalamesmoke (1.2.2)

Candle and furnace animateTick hooks cancel original and recreate only configured smoke/flame effects.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks: Drops visual effects and can also change sound/random-sequence behavior; excluded under preservation requirements.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\sah-project-nofalamesmoke.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 f375a42d58f66a8f17f847ca1af844c1bb00f8b0d5559d9713df688474750653
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\sah-project-nofalamesmoke\com\sah\noflamesmoke\mixin\AbstractCandleBlockMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 c344c4c203f0e68147f23dcc5048b12e3cfaafcd73a35e27e3956a3e129349c0

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 352 compact-f3 (1.3.3)

HUD element is registered with key-driven menu/toggle and per-client-tick updates.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Debug display changes; F3 overhead measurements might benefit but it is not renderer speedup.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\compact-f3.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 e03f2c7bf0261001bcd82293e8936ed1007b44edb0560e58dd9eae3d459903e2
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\compact-f3\username65735\compactf3\CompactF3Client.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 445a110523a380b1f1a2d3ccf07584d385438079515d2dc92da5854acf31d78d

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 353 dynamic-performance (0.2.0+26.1-fabric)

Periodically reads server MSPT, then scales simulation distance/mob cap/view distance down at lag threshold or up below recovery threshold.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks: Adaptive reduction changes simulation/visibility/spawn counts despite publisher vanilla-preserving wording; not acceptable default.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\dynamic-performance.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 7e29d09dc9c4fc32fb97faa6bea9f559e2a692d1d5b282608e26399662638503
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\dynamic-performance\io\github\nwrenger\dynamicperformance\Common.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 bcaab1eed2bea6689710164e70fc8e47ec848f556212e6a7dfa95974db53eed5

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 354 client-side-custom-music-disc-fix (1.1.6+26.3)

Cancels starting/stopping jukebox songs while a song instance exists; optional hopper playlist and disc entity packet update drive transitions.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Heuristic item entity association and stale songs/playlist state can mis-handle stops; preserves intended long-disc audio but changes vanilla bug behavior.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\client-side-custom-music-disc-fix.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 d62911462568a75c65e22781ce2598bc9750149015b855fb0a2acce74c2d4e2b
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\client-side-custom-music-disc-fix\dev\alphads\clientside_custom_music_disc_fix\mixin\LevelEventHandlerMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 0ecd00ffc38e9eda43cd96cbf48f04d391760e5758774d4c882f4c6535698a04

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 355 string-dupe (1.0.3)

Server tick tracks hooks by dimension, scans opposite hooks, caches structure for 20 ticks and validates every four ticks before farm activation.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: String duplication is gameplay change; sampled hook cache keyed by BlockPos alone risks cross-dimension collision and lifecycle needs audit.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\string-dupe.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 8527bf94d18e05fa161e81ebe0be1295a9161303bc310e5d01b7390b8219ad32
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\string-dupe\com\stringduper\client\mixin\ExampleClientMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 10407a4e9c4f17bf585a8609bf8c591d02c0196b192368cd0ffbfa1c027bb5b2

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 356 loom-gui-remastered (2.1.1-1.26.3)

Adds a picture-in-picture banner renderer and substitutes enlarged banner render state when size-adjust flag is active.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: UI appearance/coordinates change; extra renderer/atlas ownership and resource reload remain to trace.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\loom-gui-remastered.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 dee53c0d9ce1a51834b8c994cb53917e1f4d32172bf62e3db725fb6ba92a3695
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\loom-gui-remastered\net\a5ho999\loom\mixin\GameRendererMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 47c71a5f99cccc130adab94de630b3a25d23655b65ca19c1a5a95a338948585d

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 357 quicktrigger (1.3.0)

Inventory screen buttons close GUI and send trigger spawn/home commands; server payload supplies limits; disconnect resets server-specific state.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Requires teleport datapacks and changes interaction/GUI. Bounds for server maxHomes and icons need audit.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\quicktrigger.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 0a01f2d2f62d92d4b1d1f02a16cbc19f6b5470623e90b0ad3b1feb769c9a3835
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\quicktrigger\com\quicktrigger\ClientState.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 0b2ce3cb33b006eb7f4d50bb9f4101a8bdeb401d01ff6ba5d69bd5badbe5dc17

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 358 zoomhehe (4.0.0)

calculateFov RETURN multiplies original FOV by ZoomController multiplier if meaningfully different from 1.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Changes camera visuals/sensitivity; no direct FPS optimization mechanism.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\zoomhehe.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 0a113e510a02367150f0943f17b5d603ef4353a81d460c8802c2137672bcbfbb
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\zoomhehe\com\adarshhehe\zoomhehe\mixin\GameRendererMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 8881de3eb07b3c44cdab78bbfbbd8fe461256f7f030562c7fe42aa57966f92cf

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 359 stonecutter-gui-remastered (2.1.1-1.26.3)

Moves output/player inventory slot coordinates and adds refill/bulk flags to stonecutter menu.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Slot/network synchronization and automation change interaction semantics; UI-only integration outside current scope.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\stonecutter-gui-remastered.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 baf4bc81ac5390c5e15d1e6c8bb50b912db563ca1eec85cc3adf6cdeb349817b
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\stonecutter-gui-remastered\net\a5ho9999\mixin\item\DrawContextMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 977c6fc380beabb4ad3dc5cdfd23445c3123ef4adc5f14e126c77d95f8792094

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 360 clientsidenoteblocks (2.14)

playSound hook synchronizes a pending cancellation map keyed by BlockPos and consumes counters to suppress duplicated server sounds.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Predictive audio can diverge on rejection and coordinate casting is suspect at negatives; pending map/world cleanup needs tracing.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\clientsidenoteblocks.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 45efc1a46712829b4509e1c1fce36cc4cc3b9f7a5e13cb3f9d94cf994692bc7d
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\clientsidenoteblocks\me\dacubeking\clientsidenoteblocks\mixin\ClientLevelMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 743ef2ce42c0577d68bf15958eb4892305dc19c075587875479b2ecf0a744e0a

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 361 ksyxis (1.4.6)

Spawn-chunk predicate is forced false; entity initialization uses mapped/static field names to reset entity ID counter.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Removing spawn chunks changes persistent-world simulation and ID assumptions; mapping failures are silent.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\ksyxis.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 b584d00b2b2e7946251c73a396928382954792408cb089c02ca77b383d6f9d58
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\ksyxis\ru\vidtu\ksyxis\mixin\EntityMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 59471e8a9dd14aa11807a01ad87e57a70ebe7dd39885e0f296c49d6d188764c2

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 362 numflux (1.0.6-26.3-fabric)

NumFlux replaces tracked-entity update; Util sanitizer lowercases individual UTF16 chars; Mth replacements use bit math, and GivensParameters changes near-zero normalization/trigonometry.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Not exact general arithmetic: positiveModulo(0,-3) produces -3 from signed XOR whereas native double remainder yields0. Unicode whole-string lowercase and zero/negative log2 semantics require proof; do not transplant blanket methods.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\numflux.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 32df660ce4ebed733638e7c76a8742f53c70cf9d0c1e013b26457e6673eceaf0
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\numflux\com\mr_toad\num_flux\mixin\TrackedEntityMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 2441f971150e7a3c88d2e7501675128035a9bc04210b3364d279e2b871436623
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\numflux\com\mr_toad\num_flux\mixin\UtilMixin.java — full substantive class body read in second pass; SHA256 376f615ccd012aeb54453adebfcc6c2ec15bff134232220a3d68a3e9df59c436
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\numflux\com\mr_toad\num_flux\mixin\math\MthMixin.java — full substantive class body read in second pass; SHA256 70da1784a26a1f139a94b89ca8d396f1346438c210f7e19b05998ede2fc0b42f
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\numflux\com\mr_toad\num_flux\mixin\math\GivensParametersMixin.java — full substantive class body read in second pass; SHA256 6c9e8cb81e235e16f4712c11c8be5bec0e1ada837586d69052ae29d79c8f0714

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger.

## 363 resourcepackcached (1.2.8)

Downloaded-pack reload returns completedFuture during startup; connection/local-world configuration invokes onNewConnection and login invokes onGameJoin.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Need exact pack UUID/hash/version identity and invalidation; skipping reload may leave stale assets or leak between servers.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\resourcepackcached.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 e1ee05fe4971ee5fa5c521fc37f66c4fd5bf582171c2a57e1b3910cd0dbb3dc8
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\resourcepackcached\dev\furq\resourcepackcached\mixin\ClientPacketListenerMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 cf85f5098efcfe710ecc67e6cbb2176984f57c0dc7f690874eb9d172ca82a220

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 364 quick-pack (fabric-1.5.1+26.3)

QuickPack indexes ZIP names in TreeSet, enumerates prefix subsets, caches namespaces, clears references on close; font provider overwrites invert traversal and skip previously claimed glyphs.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: ZIP lexicographic order differs from native archive order and duplicate-entry behavior; font callback order changes. Need immutable archive identity, callback ordering, reload/close parity. Distinct native path construction is safe and implemented, without sharing indexes.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\quick-pack.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 7bf52813ea53f5a9807c7819e351421324af82bbbaff62b788d23e1971b17a98
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\quick-pack\me\drex\quickpack\mixin\FilePackResourcesMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 ee44f2b340cafcfe130511a90c0e6b68455f2a5916e13848166e4d0c4282403f
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\quick-pack\me\drex\quickpack\mixin\FilePackResourcesMixin.java — full substantive class body read in second pass; SHA256 ee44f2b340cafcfe130511a90c0e6b68455f2a5916e13848166e4d0c4282403f
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\quick-pack\me\drex\quickpack\mixin\FileResourcesSupplierMixin.java — full substantive class body read in second pass; SHA256 ae584cb67679d148d36d90e9845808f3fca724b2ca63a5e5275ec8e621822576
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\quick-pack\me\drex\quickpack\mixin\FontManagerMixin.java — full substantive class body read in second pass; SHA256 57108141d532c1661a20c0b7616abcc96bdd2ef5c5ec9137212052f43f3b93d0
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\quick-pack\me\drex\quickpack\mixin\FontSetMixin.java — full substantive class body read in second pass; SHA256 171825d57a86e85fe5331606c1199b0fbd9b4cdeb41ca3549502bcf22968738a

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger.

## 365 inventorytweak (4.2)

Keyboard/mouse sort binding dispatches player vs container sorting and registers durability warning tick.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Slot operations alter inventory interaction and packet volume; no rendering benefit established.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\inventorytweak.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 b20f1f11c74596e717b0e1b77c8ec9c27ab688427b1f848a029a2dc0ac8c1526
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\inventorytweak\net\anvian\inventorytweaks\mixin\MixinKeyInputHandler.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 7ce58fddd9944696437767d5f59962be98cd5b8a7ee42624ed28b0696c798fe8

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 366 no-invalid-session-id (3.1.0)

Multiplayer screen init calls SessionRefresher.refreshSessionQuietly.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Authentication/network utility; token refresh, concurrency and failure lifecycle not traced. No FPS fit.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\no-invalid-session-id.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 90ca81d8cb436e41b186b06d044d65653e825341e9545737a606b2b31cb84bb3
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\no-invalid-session-id\com\Arnav_The_Great\noinvalidsessionid\client\mixin\JoinMultiplayerScreenMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 c24e1c7d1452f35888bd954aa4e76a118a49a01c227bf315194b659233e72804

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 367 sooperdooperscooper (1.4.1+26.3)

Registers villager/piglin tick managers and interaction-driven Lobotomizer; no-AI villagers manually level and regenerate after trade.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Disables AI and replaces behavior, clearly gameplay-changing; not a strict optimization.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\sooperdooperscooper.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 d690ee1795bf8d541c522c03405ec1506fecde549802f9df1c8dc7a51c4b87fa
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\sooperdooperscooper\net\fg83\sdsfabric\mixin\VillagerEntityMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 00da159865b817143b3623461a5e4135aa8b6dbafca21c776d993daa191877e2

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 368 cleanview-2.0 (1.0.9)

Particle creation is filtered near first-person camera by type/config; rendered particle alpha is multiplied when opacity enabled.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks: Removes/changes visible particles; per-particle geometric checks add CPU work.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\cleanview-2.0.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 9a494814118e55c035cab394dc4ae2497397b6ba7e6ca1da9975b82e090339f2
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\cleanview-2.0\notzeox\cleanview\mixin\ParticleManagerMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 dabf9308cfebff2f002e34fa1975f0d9daba0b5f14b66d897cce4e418506e855

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 369 forcecloseworldloadingscreen (2.3.7)

Login HEAD captures prior frame and screen selection replaces reconfiguration/title screens with bridge screens.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Visible loading flow changes rather than proven faster resource preparation; captured texture ownership and world transition must be audited.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\forcecloseworldloadingscreen.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 5ea70a425cdd0f21d5cf7d49123a2b3f3aff7665b1f5bfc33e273a4e9f6ad377
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\forcecloseworldloadingscreen\eu\kennytv\forcecloseloadingscreen\mixin\ClientPacketListenerMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 9b9ec1889fd24e52f9d14f9f9bc0094b821e33e2b8d5f6cdd666d90d3d6e0746

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 370 polypheides-resolution-scaler (1.2.3+mc26.3)

renderLevel swaps mainRenderTarget for scaled target, clears it, restores native target and linearly blits scaled image while GUI stays native.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks: Lower resolution violates requirement; RETURN restoration may miss exceptional render paths and target resize/close must be traced.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\polypheides-resolution-scaler.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 f137420ab45870a1c125b871443c633fe369b89cd81f0bd75dc4744c5abd5fff
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\polypheides-resolution-scaler\com\polypheides\resolutionscaler\mixin\GameRendererMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 556e91083c5e3bfe747962cec52a0367709bafacbf5bd453fc3b27a95b6ed8c0

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 371 waterlightingfix (1.0.1)

Fluid tessellation output is wrapped by AoFluidVertexConsumer when ambient occlusion enabled and emission below 10; adds water-AO option.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks: Fix intentionally changes water lighting and adds sampling/vertex work; research for correct fluid renderer but not proven optimization.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\waterlightingfix.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 a467baf250ac88da5073d59309d91b024994cf59c65597288d20b21891dc3e9c
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\waterlightingfix\com\dopadream\waterfix\client\mixin\FluidRendererMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 16929f76c1503aa0ae4e8f4afeff1f9e1aff9919e5433629677e329ddd5304e4

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 372 free-cursor (1.3.1+mc26.3)

Toggle opens screen, optionally hides HUD/disables blur while recording originals; separate key opens config.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: UI/input feature; original restoration and focus handling need trace, no direct FPS fit.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\free-cursor.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 b7e3d6702cffb2837c8603bb9776b78b4fe5f1cb75105e79dd41dfd6c1743e57
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\free-cursor\com\makev1ch\freecursor\FreeCursorClient.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 9d3bf9bc42ed79612854c4c58b78ac84b786960cd88627877dabf202ed6b3a83

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 373 geyserfixes (1.1.1)

Bedrock movement/inventory/spawn listeners registered; movement checks are cancelled for Bedrock players outside respawn protection; chunkreload teleports across dimensions and back next task.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Movement enforcement/gameplay/server integration changes; temporary teleport world safety not established.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\geyserfixes.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 23d0451aeef3f3b9316ca4b37d4d06ac881cdc4ec4ec246df4412c0cb2e3e527
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\geyserfixes\com\areedelahi\geyserfix\GeyserFixesMod.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 b95cf353f34392cacd6bdcc2678dabede9e2808122c90f9db4e36289dafdc19e

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 374 clickoptimizer (1.0.0)

Only inspected mouse hook records click timestamps for HUD; initializer registers HUD/config toggle. No frame-level action dispatch was observed in inspected implementation.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Publisher input-lag optimization claim is unproven; must inspect all four source files before accepting mechanism.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\clickoptimizer.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 31dd5a976d72cae6c2f27aa9f0275b51fdbcd09040fe171f2f9f7459726da6f4
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\clickoptimizer\com\subtick\mixin\MouseInputMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 9e1225921a14b1e63c3b5b749db88e456eba12f14020519a2491dd99905df028

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 375 fast-recipe (1.0.3+26.3+fabric)

FSClient result-slot listener detects waited-for Item and invokes QUICK_MOVE on slot0 once; waiting state is static and cleared on recognized result/invalid menu.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Crafting automation/QoL, not recipe evaluation optimization; adds client container actions and global waiting state. Excluded baseline.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\fast-recipe.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 0fcdab02c24c016bfa66f4849e3c862a6fa415fdaf6ea06cad3e7bf7207d84ae
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\fast-recipe\me\zipestudio\fastrecipe\mixin\AbstractContainerMenuMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 057a9d2a9605a8a5f373dd5204dd8a1ce02ae6ecb4e9486a05d4a618b9d00a2a
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\fast-recipe\me\zipestudio\fastrecipe\client\FSClient.java — full substantive class body read in second pass; SHA256 16122d63786be31317c7d840275d5b8c4a8825652a443a293b6cd72bda6ad193

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core.

## 376 onehittreechopper (3.0.1)

Server block-break callback finds all connected tagged wood up to max size, recursively guarded, destroys blocks and damages axe; client sends enable toggles.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Mass tree removal changes gameplay and adds burst work; recursion/player state needs finally cleanup.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\onehittreechopper.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 e13c8ddcb8a865b2427d9956ce04ab2a0a23f07634541f3aba5ff4e6ce140212
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\onehittreechopper\non\onehittreechopper\OneHitTreeChopperClient.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 c25fe58b032ac71361cbb9cca176b3d6c32627aa6d5d0d398abd6494eff7c352

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 377 no-death-animation (2.1.0+26.3)

Render state stores source LivingEntity; rotation setup cancelled for configured targets and hurt/death overlay is overridden.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks: Explicit visual change and strong entity reference can outlive intended frame; not FPS-fit.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\no-death-animation.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 318ef7e93026dae1cb6cb407e4c493749870e12ab28785de955c8fb93e20a82e
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\no-death-animation\walksy\nodeathanimation\mixin\LivingEntityRenderStateMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 4871b654721543b0827d7ebbe1f639059c8fadbaf3646e797ef4723af5729184

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 378 no-way (1.4.0)

LivingEntity isTransmittingWaypoint and ServerPlayer isReceivingWaypoints return false.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Disables gameplay information and HUD feature; reduced networking arises from removed behavior.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\no-way.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 a206a97d6bfe9d4477134751f1104798d7e1f2628be3ab4c5cb182f56e4d7915
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\no-way\net\litetex\noway\mixin\LivingEntityMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 f82e3f0384fc0f25ff005c9e0d01badc411d7ee81207f29c52a304ce7a91fedb

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 379 pandatntfusion (1.0.0+26.3)

When global primed TNT count exceeds threshold, nearest TNT receives additional power and new TNT spawn is cancelled; explosion is replaced using accumulated power capped at 16.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Explosion counts/strength/fuses/distribution change; static global count/world lifetime need auditing.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\pandatntfusion.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 81db0334d8941392beb9774ef51c315e870f9751fd3c5668a373a643663d6ea7
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\pandatntfusion\me\TreeOfSelf\PandaTNTFusion\mixin\TNTBlockMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 300d731e299bb16676baefab11809c9412e7126f11a281c4833651006c3fb08a

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 380 explodee (1.1+26.1-26.3-fabric)

Explosion constants/variables are rewritten to a computed ray count and ExplodeeMath spherical directions with unit length; plugin handles Lithium explosion mixin presence.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Explosion propagation/damage/blocks change and ordinal hooks are fragile; excluded despite potential computational study.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\explodee.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 1fa93ae848a81a7f2cf577a86e5a51d002fc6f01bdf5a389744c1068fb222a91
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\explodee\derg\explodee\mixin\ExplodeeMixinPlugin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 8df892537a53eca8d18cac8494c7f5e8928f42ad05a3cfbb5b51124b92d267ed

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 381 smooth-join (1.3.2)

Connection initialization lowers render distance to 2; after 100 ticks post-join restores two chunks every 20 ticks.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks: Temporarily reduces visible world and must restore on failure/disconnect/manual setting edits; not strict unchanged-distance fit.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\smooth-join.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 b9ef6c9bf021a6d54489ecc757b1d6624f47398a0d3360bd2030dd239954565b
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\smooth-join\com\zhimeow\smoothjoin\ModMenuIntegration.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 8aebd14d24880b2113e471e91080d6355387b734554b28157848ced480b1070c

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 382 particleculling (1.0.0+mc26.3)

ParticleEngine.createParticle returns null for registry IDs blocked in config; menu provides global/type toggles.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks: This artifact is selective particle suppression, not occlusion culling; visual loss violates requirements.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\particleculling.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 bb107723e00d92403e6503ea0b1d40454bf617cfc7ac97f000d149158a0b44ac
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\particleculling\dev\fix85\particleculling\ParticleCullingModMenu.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 29c6bcc0ec8f54c5b89b3b39c66b8769f92b169dfdcba28c72050d8f9b0fb06c

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 383 smoothtexturefix (1.0.0+26.3)

Terrain sampler creation replaces every FilterMode argument with NEAREST when enabled; config defaults true.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks: Changes filtering appearance; no equivalence or FPS evidence and renderer backend hook is version-sensitive.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\smoothtexturefix.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 81ea5e0ed148ee6b23cbf733458ed2158d8db827c1e9fdd0c889c31df846cf8a
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\smoothtexturefix\io\github\poeticrainbow\smoothtexturefix\mixin\LevelRendererMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 8a4391d431450646f4196c6472c159f6c715a828f54835132907c0fb80a4bc54

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 384 jukebox-custom-disc-fix (0.2.0-26.3)

Replaces jukebox stop event invocation with no-op; verified block-state changes stop song if block removed or HAS_RECORD false.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Two implementations of same audio bug fix should not overlap; stopping conditions/reload/world cleanup need trace.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\jukebox-custom-disc-fix.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 1153755a99af0596bf3094eab5db82feaaf23eae32f25ae4a3bc83aa169b1d7f
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\jukebox-custom-disc-fix\xyz\eclipseisoffline\jukeboxcustomdiscfix\mixin\LevelEventHandlerMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 7445ec1f0eae87f7abdbb3e2af880d6ba0de2d437789a1a384808e5b0c065b62

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 385 careful-break (1.3.1)

Drop redirect copies loot into sneaking player's inventory and removes successful original drops; enable file is read on each drop call.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Partial inventory insertion may duplicate remaining items if original list is retained; IO on break and gameplay pickup semantics conflict.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\careful-break.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 3f2a4db2d7643bf2e85bf35d861dbd145bc385a1e31b9b7a208fbc2de3346c4d
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\careful-break\com\yankees88888g\mixin\BlockBreakMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 8b6ea6f0bfc41b6983189413f42e153744a0ac0bb6d85919c56fc38ea6b0ef40

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 386 fastmapcodec (1.0.4)

BaseMapCodec fast path parses entries and builds ImmutableMap; duplicate/failure invokes fallback that parses all entries again; successful fast result is DataResult.success without combining component lifecycle.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Drops original key/value lifecycle contributions and may invoke codec callbacks twice on failure. Unsafe universal codec optimization; no implementation copied.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\fastmapcodec.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 6c2b7af1c62316b707572b2207b919f264d43cc02e9521a3131c1580d4566de1
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\fastmapcodec\dev\neko\fastmapcodec\mixin\BaseMapCodecMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 953d7b2500564aca3425ad05ba0f22dfc3c6e6e818e75342d92c39bcaaf9c243
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\fastmapcodec\dev\neko\fastmapcodec\mixin\BaseMapCodecMixin.java — full substantive class body read in second pass; SHA256 953d7b2500564aca3425ad05ba0f22dfc3c6e6e818e75342d92c39bcaaf9c243

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger.

## 387 recipecooldown (1.1.0+26.2)

Server recipe packet HEAD cancels within configured wall-clock cooldown; TAIL stores player UUID timestamp in static map.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Rate limiting changes rapid craft behavior; map cleanup and monotonic time handling not observed.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\recipecooldown.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 cb62963016cec49b8e4ed2f8c679006e107c70493f9abc36b80dafac30ff874f
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\recipecooldown\com\lx862\recipecooldown\mixin\ServerPlayNetworkHandlerMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 a774e5992d64e21705a1251b53fe7ecf1924b8304aea9a1c2c20f009e92481cd

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 388 calc (1.1.0+26.3)

Client calc command runs bounded recursive parser (4096 chars, depth 128), arithmetic and division-by-zero/finite checks.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Useful utility; parser semantics/edge cases remain, no FPS optimization.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\calc.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 6bde0eac16ca52d419e4268c0afce477164387d7870bc771722999c59b4bdcf5
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\calc\io\github\evphub\calculator\CalculatorClient.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 7c731b01c2ce3c1eb96a52233f3bbb6cdec1641de32269daf9284ecccaea31d5

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 389 better-narrator-error (1.0.0)

Narrator errors are rebuilt with shortened message and optional empty stack; a property can return empty narrator.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Conceals diagnostic detail/changes accessibility if disabled; Linux-specific log utility.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\better-narrator-error.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 e7fae0a363350a3bc87d5ea6fabba83822645989c89c9546ef24123a3110209f
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\better-narrator-error\betternarratorerror\mixin\NarratorLinuxMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 9995789ac0ec83bdb1241053b700e6fe1ccf27aab4ba02f1afddff17b9c9faa4

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 390 preferopengl (fabric-26.2-v1.0.0)

Client initializer rewrites matching backend preference keys in options.txt to preferredGraphicsBackend:opengl, preserving other lines.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Persistent backend preference change and broad alias matching; benefit depends on driver/backend, no benchmark proof.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\preferopengl.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 b703aeb2c49b69ae8e4ac23789fa46f18270e6c8efca418f9e43d48a6124d1c2
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\preferopengl\com\preferopengl\core\RendererPreferenceWriter.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 dd666c432f3ab925cbe9f6f901568b0fa908d7141af8f56d41c1f9750956afc4

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 391 cull-display-entities (1.3.0)

When display width/height zero, forces noCulling false and builds transformed AABB from eight expanded unit-model corners; nonzero dimensions delegate.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks: Text/item/block display geometry may exceed hard-coded model extents, producing false culls; zero-initialized min/max inflate bounds. Interpolation needs audit.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\cull-display-entities.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 480967e43a7504cef2c2864626a5931076a6323b73117746a7605a8c0eec9374
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\cull-display-entities\me\wolfii\culldisplayentities\mixin\DisplayEntityMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 0b41349d033e3af4c3b14505ee1a878c44a0abed520927ef450d6383239d4693

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 392 hotbar-lag-fixer (1.1.1)

Preloads hotbar0 at CLIENT_STARTED and cancels save, then serializes all nine mutable Hotbar entries and writes optionsFile on common pool.

Client benefit: Candidate workload-specific CPU/memory/loading benefit; no measured FPS claim.
Disposition: Do not blanket-integrate; selected core studied, unresolved ownership/callback/version contracts recorded.
Risks: Asynchronous save lacks immutable client-thread snapshot or serial write queue in inspected80-line core; overlapping saves can race and later state can overwrite earlier requested snapshot. Requires redesign, not blind module bundle.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\hotbar-lag-fixer.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 1a9a93b4b554a4cdfc5a36a4767345dc296d6a1490ee7bb3d6ab9d0dd2c4ad9b
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\hotbar-lag-fixer\hotbar\lag\fixer\mixin\HotbarManagerMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 2141c9b2b933ba86b5d260da03541f0643034efe8e15c555fae00d4cce3ada29

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. Remaining helpers/platform hooks and native lifecycle contracts are incomplete; candidate is not certified safe by this ledger. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 393 the-nofog-mod (1.0)

Fog setup RETURN sets distance/environment ends to near Integer.MAX_VALUE except fluid, blindness/darkness cases.

Client benefit: Some reduce work by changing output/policy; parity-preserving gain not established.
Disposition: Do not silently apply: rendering/accessibility output or simulation/distance policy changes.
Risks: Explicit fog removal alters visuals; extra distant rendering can hurt FPS.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\the-nofog-mod.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 c3578dcaae4ac379d6f9594a266ad41f5b28e159e3f21f7b415fea06617d662c
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\the-nofog-mod\net\dillon\nofogmod\mixin\FogRendererMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 d21fabfe519813a86b47e8c69abb1291ed7cccf6c9fc3c4073675da783445dd4

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 394 disable-portal-checks (1.0.0)

Portal findOpenPosition HEAD returns supplied fallback immediately, skipping search.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Collision-safe portal exit search is removed; players/entities may arrive obstructed. Not semantics-preserving.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\disable-portal-checks.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 2219bc847174d72b645b2341e5438ee427bc21d0dda5037e59cb7d3bbdee7135
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\disable-portal-checks\net\soronto\disable_portal_checks\mixin\client\ExampleClientMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 a6f89b9330f4ef9831d9bd6fd8a502cb3b2fc8404bd4835e0108da4846bcd560

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 395 non-persistent-wither-skulls (1.0.3-mc-26.3)

Entity section visibility update discards moving WitherSkull when its position is outside entity-ticking region.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Projectile survival/world persistence changes; removes gameplay state rather than equivalent work.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\non-persistent-wither-skulls.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 03f504835912c7f0ec3ed3759b6842a2c0938089f26edc4e929e107b81059d2c
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\non-persistent-wither-skulls\net\azyrod\nonPersistentWitherSkulls\mixins\PersistentEntitySectionManager$CallbackMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 b4fd118f2163ea953ff56dbd4e2ef2f4bb5bce7c897a8551560b7ff8b7d4688e

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 396 better-place-bind (1.0.0)

While use key held for at least 200 ms, each tick resets rightClickDelay to zero.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Speeds placement cadence and network/gameplay interactions; no renderer optimization.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\better-place-bind.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 a6f303e35689cd2f2571e8557421ac40ed44745f6a1f568780b69172d6f894bf
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\better-place-bind\com\betterplacebind\mixin\MinecraftMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 f4fd5bbc7b59ffcedd1411e8fa3cb334be4aa2832388d37145bfe889be741674

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 397 stfudisconnect (4.0.0)

Connection exception path overrides sending flow to SERVERBOUND for STATUS/HANDSHAKING, otherwise calls original.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Error handling/log behavior changes; inspect exception branch before reuse, no normal-render optimization.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\stfudisconnect.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 b5ad930140154c031a981b69d7ffa768f6e0597874b5fd4657c7355b6b0db976
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\stfudisconnect\com\wfphantom\mixin\ConnectionMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 35fa4e8e600d030ffec97cc84bcea963b1353260bf21ad6f167f66454c96a0d2

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 398 yggdrasil-proxy (26.06.1-fabric)

Authentication service constructor replaces proxy with ProxyConfigReader selection and logs activation.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: Authentication proxy/credential route behavior, platform settings and fallback need trace; unrelated FPS.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\yggdrasil-proxy.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 09aec60a59718c6ca44dd3b071d7ebd6e158c7a6c1f693d4a5c9281250ce5e66
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\yggdrasil-proxy\one\tranic\yggdrasilproxy\mixin\HttpAuthenticationServiceMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 09a716f4c798ba2aab190bafda052d096cdb084c96f69b274a79d113330c14a6

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 399 serverpingerfixer (1.1.1)

Server-list static executor is shut down and replaced with 1-to-Integer.MAX_VALUE pool, SynchronousQueue and 30-second idle timeout.

Client benefit: Server-list/session latency only unless further traced.
Disposition: Potential menu/network latency benefit; not a world-render FPS module. Requires scoped native/cleanup validation.
Risks: Potential unbounded threads for large/unresponsive lists; old queued tasks/lifecycle need audit, not in-world FPS.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\serverpingerfixer.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 e08fdfcb820c1985575efeba8c5dd4dbb4b7db1523d3c4b9566d0b9140c6747c
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\serverpingerfixer\me\wolfii\serverpingerfixer\mixin\ServerSelectionListMixin.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 26805a0b52094e812a6e38d4ab34aa7757b1618d8ef9e56d75eb31920a50996d

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 400 norollback (2.2.0)

Datapack load launches scheduled functions disabling player and elytra movement checks using old/new gamerule names.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Disables movement enforcement; no rendering optimization. Wrapper Java class is empty, real behavior lives in mcfunctions.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\norollback.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 0daff6bbfb8629050797753e97f201626f26d03e29936e13742d26aa2e773f20
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\work\decompiled\norollback\com\modrinth\K4Ytaql5\ModrinthWrapper.java — selected class body first1200characters, metadata and hooks; large-class remainder not reviewed; SHA256 1ffd08a9090708ad0f3e3a597d70ad480e943f05cc26456f73c4ef438979bccf

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 401 chunk-pregenerator (1.1-mod)

Datapack uses scoreboards for chunk radius/progress, schedules generation and cleaner, removes forceload and marker armor stands once loaded.

Client benefit: Feature/diagnostic/loading utility rather than steady rendering optimization.
Disposition: Leave separate utility/content dependency; no transparent world-render CPU work removal shown.
Risks: World generation/forceload persistence and cancellation cleanup need trace; shifts exploration cost earlier rather than speeding rendering.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\chunk-pregenerator.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 f38f5e67a587b2f934b9661fb4af91d9f05c9ab7b6c2849f954a88ac10f72b98
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\chunk-pregenerator\chunk-pregenerator-1.1-26.3.jar!/data/c_pre/function/adjust_center.mcfunction — first1800characters; SHA256 babe9cfc1a044f9334f5aca606b15c6e19e9ae2af1d5e619d9580bda3e1aacd2
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\chunk-pregenerator\chunk-pregenerator-1.1-26.3.jar!/data/c_pre/function/begin.mcfunction — first1800characters; SHA256 7bad5381f19259212588edf965be01f85115f6dabfd13c8e20e2cfd396ca3cfc

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 402 name-tag (v2.2.0.0+mod)

Advancement rewards recipe and entity-interaction function tags custom-named entities for drop logic.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Adds recipe/drop gameplay and scans all custom-name entities; no FPS fit. Loot table/recipe details remain to trace.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\name-tag.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 128547b6b00d545c043a884a8e65c6f1072cc87a19253e1e02bc53ebd2e13944
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\name-tag\name-tag-v2.2.0.0.jar!/data/name_tag/advancement/get_name_tag_recipe.json — first1800characters; SHA256 4d79e1de4a0c345727a5cdad1d9a932af8a756b4822f6ad290dd2263e08c03e0
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\name-tag\name-tag-v2.2.0.0.jar!/data/name_tag/advancement/gave_entity_name_tag.json — first1800characters; SHA256 52f0d4aa344cb843ece609373457f032f7b6b7b89424682a6a925025a07c91d6

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 403 harvest-simplified (1.1+mod)

Tick crop functions scan dropped items above farmland/soul sand, replant crop, kill seeds and teleport nearby items to nearest player.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Changes planting/pickup and may consume unrelated nearby drops; selector cost scales with entities.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\harvest-simplified.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 c9f06148e2f8997b01fbc07bb03128c1b0bcd7f4829f8438bf70f5567b40c2e0
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\harvest-simplified\harvest-simplified-1.1.jar!/data/harvest/function/crops/check.mcfunction — first1800characters; SHA256 f9ed62c8b3cf871fff441525b55e363a2e9dddd50a19c03843d19fb05a7f0479
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\harvest-simplified\harvest-simplified-1.1.jar!/data/harvest/function/crops/place/beetroot.mcfunction — first1800characters; SHA256 78b3b01ee903cff9bdae6804a9c49cfdd480b4b6eb5770fae921ed30e8f65c8d

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 404 novoid (0.1.1+mod)

Tick function tags players below dimension-specific Y limits, applies slow falling and teleports them; overworld/nether also fill air and bedrock platform.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Deletes/replaces world blocks and changes void death; plainly outside optimization scope.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\novoid.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 cef97e0930983161b69d98548f1d1393aeb4046d24f7406df868bb2560905711
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\novoid\novoid-0.1.1.jar!/data/minecraft/tags/function/load.json — first1800characters; SHA256 7a7322bf52c1c745daae753eea5a08823de48f02f47d022bb554e3ec3927afa5
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\novoid\novoid-0.1.1.jar!/data/minecraft/tags/function/tick.json — first1800characters; SHA256 8cd5a33da1ff6e9d66da86c7cf7aabc1fdb16bc8261e1241330fddbdb20f4de5

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 405 visually-waxed-golems (1.0.1+mod)

Advancements/functions put waxed copper golems on waxed team based on next_weather_age=-2, and remove others from teams; trigger enables updates.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Team changes conflict with existing teams and deliberately mark visuals; resource assets not visually inspected.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\visually-waxed-golems.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 1d1f1ca74b5a75710c72d087e5dfd2df50d79a6938af298eb54fa47e419b55c4
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\visually-waxed-golems\visually-waxed-golems-1.0.1.jar!/data/bray/advancement/root.json — first1800characters; SHA256 e5eee98abf38aa276ebf7c285fb1075f46c4782936da05464a93df5abf6a01f8
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\visually-waxed-golems\visually-waxed-golems-1.0.1.jar!/data/bray/advancement/unwaxed.json — first1800characters; SHA256 77e65301a510a28be89ecbd168c4c5fd3930674ebcc715209aac247d83b1e4d3

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 406 disable-spawner-mob-spawns (1+mod)

Load function sets spawnerBlocksEnabled gamerule false.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Disables mob spawners and changes farms/gameplay. Performance achieved by removing simulation.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\disable-spawner-mob-spawns.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 0bd940994869d5c7ccd7547a40de3420044c151eeb2a57035a01f6a6da3ff723
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\disable-spawner-mob-spawns\disable-spawner-mob-spawns-1.jar!/data/minecraft/tags/functions/load.json — first1800characters; SHA256 5cef0e832799eef044a1a315ba0e3da8c5ba1fb2dfb72446437357c434f6f855
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\disable-spawner-mob-spawns\disable-spawner-mob-spawns-1.jar!/data/runterya/advancement/root.json — first1800characters; SHA256 cc4dbc03a5ca273283b323f601fd8936a76e2d97edcbbad5bedc1289296115c8

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 407 alot-of-enchants-300 (1+mod)

Datapack tick runs per-player enchant/movement functions and seeking/reacquire/tracer arrow functions; anvil functions refund levels based on score deltas.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Large gameplay/particle/AI-like feature set adds work. Individual enchants not exhaustively reviewed; no AstFPS inclusion.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\alot-of-enchants-300.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 f1624709f6c3689dcc9f2675ec5b76763185e988427ca521bac72bc4e123847d
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\alot-of-enchants-300\alot-of-enchants-300-1.jar!/data/minecraft/enchantment/quick_charge.json — first1800characters; SHA256 54431adb564aa8677c3e1bd452b51f6f0d755a50483db460d58c37f612428465
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\alot-of-enchants-300\alot-of-enchants-300-1.jar!/data/minecraft/enchantment/mending.json — first1800characters; SHA256 e50fcab57f0905497fd1b4830e2b7f69ab2fced9d0676257b3d28608cde5ba49

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 408 uuid-hex (1.4+mod)

Datapack splits UUID int array into short-sized parts with scoreboard arithmetic, maps through ROM hex strings and formats canonical result using macros.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Shared storage temp/in/out ownership and signed negative-index behavior need proof; large preloaded ROM cost, utility not FPS.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\uuid-hex.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 b3368b8d6060fcc7933aa6b77387a4ba5a7ec3dab58d817ac36033de44f6395c
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\uuid-hex\uuid-hex-1.4.jar!/data/minecraft/tags/function/load.json — first1800characters; SHA256 e35d08896ce0f3a9bb9ae51c7f4de5648a330ebea4e307d906b92b33554419d4
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\uuid-hex\uuid-hex-1.4.jar!/data/minecraft/tags/functions/load.json — first1800characters; SHA256 e35d08896ce0f3a9bb9ae51c7f4de5648a330ebea4e307d906b92b33554419d4

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.

## 409 version (1.1-Mod)

Overlay load functions write version-specific data-format/name into ver:sion storage; base writes Unknown.

Client benefit: No equivalent transparent client FPS benefit established.
Disposition: Exclude from transparent client-performance baseline: changes gameplay/content or input behavior.
Risks: Pack overlay selection/version tables require maintenance, low-frequency utility; no renderer performance mechanism.

Evidence actually read:
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\notes\version.md — research-note file loaded/fingerprinted by script; prior catalog mechanism reviewed separately, note contents not displayed in this pass; SHA256 2118d2440fe4a8295bdd61edb986613d619212593e577f3d4d03b763d60b28c4
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\version\version-1.1.jar!/data/minecraft/tags/function/load.json — first1800characters; SHA256 312bfcec9a076e085b4a1319efccc93d0d440dcf1d11d00347ccfd5529ccc049
- C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\optimization-research\stable\version\version-1.1.jar!/data/minecraft/tags/functions/load.json — first1800characters; SHA256 312bfcec9a076e085b4a1319efccc93d0d440dcf1d11d00347ccfd5529ccc049

Gaps: Source review is scoped to recorded excerpts/classes, not exhaustive artifact understanding. No game, runtime, unit tests, comparative profiling or full combined-mod visual validation. Artifact version/license retained from catalog; no source copied from third-party core. This second pass re-read selected hook/resource excerpts plus existing research notes; larger core may only have prior first-pass evidence.
