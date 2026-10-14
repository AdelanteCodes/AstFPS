# Mod implementation research

Research-only work started 14 October 2026 at 13:05 IST. Requested four-hour target: 17:05 IST.

Scope: 481 broad catalogue matches, 410 hash-verified artifacts, 373 top-level JVM reconstructions, and 37 archives with no top-level JVM classes. Some search matches are utilities, gameplay changes, resource packs, or data packs rather than FPS optimizations. Embedded implementations are recorded separately.

Each project has its own note with version identity, purpose, loader dependencies, source navigation, evidence status, and—where reviewed—algorithm, lifecycle, correctness risks, and useful validation cases.

## Coverage

- Artifact unavailable; implementation not verified: **71**
- Behavioral static review: **39**
- Evidence inventory; behavioral review pending: **371**

A generated symbol map is not a completed behavioral review. Large projects and unavailable artifacts remain explicitly pending. No source/JARs are repackaged here, and this research does not claim FPS gains.

## Individual notes

| Project | Selected version | Review status |
|---|---|---|
| [Lithium](mods/lithium.md) | `mc26.3-0.26.2-fabric` | Evidence inventory; behavioral review pending |
| [BadOptimizations](mods/badoptimizations.md) | `2.4.1` | Evidence inventory; behavioral review pending |
| [ImmediatelyFast](mods/immediatelyfast.md) | `1.17.1+26.3-fabric` | Evidence inventory; behavioral review pending |
| [FerriteCore](mods/ferrite-core.md) | `9.0.0-fabric` | Evidence inventory; behavioral review pending |
| [Sodium Extra](mods/sodium-extra.md) | `mc26.3-0.9.4+fabric` | Evidence inventory; behavioral review pending |
| [Language Reload](mods/language-reload.md) | `1.7.8+26.3` | Evidence inventory; behavioral review pending |
| [More Culling](mods/moreculling.md) | `1.9.0` | Evidence inventory; behavioral review pending |
| [Dynamic FPS](mods/dynamic-fps.md) | `3.11.10` | Evidence inventory; behavioral review pending |
| [Remove Reloading Screen](mods/rrls.md) | `5.2.8+mc26.3` | Evidence inventory; behavioral review pending |
| [FastQuit](mods/fastquit.md) | `3.1.5+mc26.2` | Evidence inventory; behavioral review pending |
| [Let Me Despawn](mods/lmd.md) | `1.26.9.2` | Evidence inventory; behavioral review pending |
| [Fast IP Ping](mods/fast-ip-ping.md) | `v1.0.12-mc26.3` | Behavioral static review |
| [BetterGrassify](mods/bettergrassify.md) | `1.8.8+fabric.26.3` | Evidence inventory; behavioral review pending |
| [Packet Fixer](mods/packet-fixer.md) | `3.3.6` | Evidence inventory; behavioral review pending |
| [Particle Core](mods/particle-core.md) | `0.3.3+fix1+26.2` | Evidence inventory; behavioral review pending |
| [ScalableLux](mods/scalablelux.md) | `0.3.0-alpha.0.6+26.3` | Evidence inventory; behavioral review pending |
| [Leaves Be Gone](mods/leaves-be-gone.md) | `26.3.0` | Evidence inventory; behavioral review pending |
| [Alternate Current](mods/alternate-current.md) | `mc26.3-1.9.0` | Evidence inventory; behavioral review pending |
| [Better Block Entities](mods/better-block-entities.md) | `1.3.9+mc26.3` | Evidence inventory; behavioral review pending |
| [Cull Leaves](mods/cull-leaves.md) | `4.1.2+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Ksyxis](mods/ksyxis.md) | `1.4.6` | Evidence inventory; behavioral review pending |
| [Structure Layout Optimizer](mods/structure-layout-optimizer.md) | `1.1.4+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Nvidium](mods/nvidium.md) | `0.4.4-beta7-26.3` | Evidence inventory; behavioral review pending |
| [kennytvs-epic-force-close-loading-screen-mod-for-fabric](mods/forcecloseworldloadingscreen.md) | `2.3.7` | Evidence inventory; behavioral review pending |
| [Chunky](mods/chunky.md) | `1.5.3` | Evidence inventory; behavioral review pending |
| [Shield Statuses](mods/shield-statuses.md) | `4.2.1+26.3` | Evidence inventory; behavioral review pending |
| [Server Pinger Fixer](mods/serverpingerfixer.md) | `1.1.1` | Behavioral static review |
| [Gnetum](mods/gnetum.md) | `4.6.3+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Shield Fixes](mods/complete-shield-fixes.md) | `2.1.0+26.3` | Evidence inventory; behavioral review pending |
| [Raise Sound Limit Simplified](mods/rsls.md) | `1.4.0` | Evidence inventory; behavioral review pending |
| [ServerCore](mods/servercore.md) | `1.5.20+26.3` | Evidence inventory; behavioral review pending |
| [Crosshair Addons Public](mods/crosshair-addons-public.md) | `2.2.0+26.3` | Evidence inventory; behavioral review pending |
| [Stfu](mods/shuttfup.md) | `2.9.1-26.3` | Evidence inventory; behavioral review pending |
| [quick pack](mods/quick-pack.md) | `fabric-1.5.1+26.3` | Evidence inventory; behavioral review pending |
| [RenderScale](mods/renderscale.md) | `1.4.0-alpha.6-fabric+26.3` | Evidence inventory; behavioral review pending |
| [Sound Controller](mods/sound-controller.md) | `1.4.1-mc26.3` | Evidence inventory; behavioral review pending |
| [XXL Packets](mods/xxl-packets.md) | `1.0.6-26.x.x-fabric` | Behavioral static review |
| [Get It Together, Drops!](mods/get-it-together-drops.md) | `v1.5.1` | Evidence inventory; behavioral review pending |
| [Better Biome Blend](mods/better-biome-blend.md) | `26.3-1.4.0-fabric` | Evidence inventory; behavioral review pending |
| [CleanCut](mods/cleancut.md) | `8.1.0+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Jukebox Custom Disc Fix](mods/jukebox-custom-disc-fix.md) | `0.2.0-26.3` | Evidence inventory; behavioral review pending |
| [Skeleton AI Fix](mods/skeleton-ai-fix.md) | `26.3.0` | Evidence inventory; behavioral review pending |
| [ResourcePackCached](mods/resourcepackcached.md) | `1.2.8` | Evidence inventory; behavioral review pending |
| [CrashPatch (Crash Preventer)](mods/crashpatch.md) | `v2.2.1` | Evidence inventory; behavioral review pending |
| [Optimized Block Entities [OBE]](mods/obe.md) | `1.1.52` | Evidence inventory; behavioral review pending |
| [Async Pack Scan](mods/async-pack-scan.md) | `26.3.0` | Behavioral static review |
| [Consumable Optimizer](mods/consumableoptimizer.md) | `2.2.3+26.3` | Evidence inventory; behavioral review pending |
| [Simple Datapacks](mods/simple-datapacks.md) | `2.9.1-fabric+26.1` | Evidence inventory; behavioral review pending |
| [NoRollback](mods/norollback.md) | `2.2.0` | Evidence inventory; behavioral review pending |
| [Clumps](mods/ly-clumps.md) | `v1.1.0+mod` | Evidence inventory; behavioral review pending |
| [ToadLib](mods/toadlib.md) | `1.5.3-26.3-fabric` | Evidence inventory; behavioral review pending |
| [Faster Iris Shadow Mapper [FISM]](mods/fism.md) | `1.0.7` | Evidence inventory; behavioral review pending |
| [Variants-CIT](mods/variants-cit.md) | `5.7.1+26.3` | Evidence inventory; behavioral review pending |
| [Sodium Extra Information](mods/sodium-extra-information.md) | `2.9.1` | Evidence inventory; behavioral review pending |
| [No Death Animation](mods/no-death-animation.md) | `2.1.0+26.3` | Evidence inventory; behavioral review pending |
| [Reflex AntiLag](mods/reflex-antilag.md) | `1.1.2+fabric-26.3` | Evidence inventory; behavioral review pending |
| [Multi Key Bindings](mods/multi-key-bindings.md) | `1.3.5+26.3` | Evidence inventory; behavioral review pending |
| [NoPackCompatCheck](mods/nopackcompatcheck.md) | `v0.1.1-fabric-mc26.1+` | Evidence inventory; behavioral review pending |
| [PolyHitbox (Custom Hitboxes)](mods/hitbox.md) | `v1.3.2` | Evidence inventory; behavioral review pending |
| [Accelerated Decay](mods/accelerated-decay.md) | `26.3.0.1` | Evidence inventory; behavioral review pending |
| [TT20 (TPS Fixer)](mods/tt20.md) | `0.8.5` | Evidence inventory; behavioral review pending |
| [RailOptimization](mods/railoptimization.md) | `2.0` | Evidence inventory; behavioral review pending |
| [Disconnect Packet Fix](mods/disconnect-packet-fix.md) | `2.3.0-fabric` | Behavioral static review |
| [ExploitPreventer](mods/exploitpreventer.md) | `1.2.1+26.3` | Evidence inventory; behavioral review pending |
| [Smart Particles](mods/smart-particles.md) | `1.16.0` | Evidence inventory; behavioral review pending |
| [Better Render Distance](mods/better-render-distance.md) | `1.2.2` | Evidence inventory; behavioral review pending |
| [钠-汉化模组（Sodium Chinese Localization Mod）](mods/mc1.16.5-sodium-chinese-localization-pack.md) | `5.6.7` | Evidence inventory; behavioral review pending |
| [Borderless Windowed Vulkan](mods/borderless-windowed-vulkan.md) | `26.3` | Evidence inventory; behavioral review pending |
| [Client Kits](mods/client-kits.md) | `2.1.0+26.3` | Evidence inventory; behavioral review pending |
| [Lightweight Inventory Sorting](mods/lightweight-inventory-sorting.md) | `1.1.7+26.3` | Evidence inventory; behavioral review pending |
| [Screenshot Compression](mods/screenshot-compression.md) | `26.3.0-1.4-fabric+forge+neo` | Evidence inventory; behavioral review pending |
| [Elytra/Chestplate Swapper](mods/elytra-chestplate-swapper.md) | `2.1.0+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Mob Collision Off](mods/mob-collision-off.md) | `3.0` | Behavioral static review |
| [Fast Surface](mods/zfastsurface.md) | `1.0.0+26.3` | Evidence inventory; behavioral review pending |
| [Custom Block Highlight (Outline / Overlay)](mods/custom-block-highlight.md) | `2.92+26.3` | Evidence inventory; behavioral review pending |
| [AudioThrottle](mods/audiothrottle.md) | `1.0.1` | Behavioral static review |
| [Black Bar Concealer](mods/black-bar-concealer.md) | `1.0.10` | Evidence inventory; behavioral review pending |
| [Disable Fog](mods/disable-fog.md) | `2.2.1` | Evidence inventory; behavioral review pending |
| [Sound Culling](mods/sound-culling.md) | `2.1.0` | Evidence inventory; behavioral review pending |
| [Cull Fewer Leaves](mods/cull-fewer-leaves.md) | `1.1.2` | Evidence inventory; behavioral review pending |
| [Jauml](mods/jauml.md) | `2.3.1+fabric-26.3` | Evidence inventory; behavioral review pending |
| [Audio Engine Tweaks](mods/audio-engine-tweaks.md) | `1.2.16` | Evidence inventory; behavioral review pending |
| [Resource Gamma Util / Fullbright](mods/resource-gamma-utils.md) | `26.3-2.0.3` | Evidence inventory; behavioral review pending |
| [Hide Item Frame](mods/hide-item-frame.md) | `1.5.2-fabric+26.3` | Evidence inventory; behavioral review pending |
| [ServerAddressSpaceFix](mods/serveraddressspacefix.md) | `0.2.5` | Evidence inventory; behavioral review pending |
| [InventoryTweak](mods/inventorytweak.md) | `4.2` | Evidence inventory; behavioral review pending |
| [Toggle Nametags](mods/hidetags.md) | `2.7.9+26.3` | Evidence inventory; behavioral review pending |
| [RecipeCooldown](mods/recipecooldown.md) | `1.1.0+26.2` | Behavioral static review |
| [Clean View](mods/cleanview-particles.md) | `1.0.6-26.3` | Evidence inventory; behavioral review pending |
| [Material Rule Compiler](mods/zmaterial-rule-compiler.md) | `1.1.2+26.3` | Evidence inventory; behavioral review pending |
| [Rebind Quick Swap](mods/rebind-quick-swap.md) | `2.1.0+26.3` | Evidence inventory; behavioral review pending |
| [Shut Up Dead Entities](mods/shut-up-dead-entities.md) | `1.3.1` | Evidence inventory; behavioral review pending |
| [Better Narrator Error](mods/better-narrator-error.md) | `1.0.0` | Behavioral static review |
| [Rabbit Pathfinding Fixed](mods/rabbit-pathfinding-fix.md) | `1.5.0` | Evidence inventory; behavioral review pending |
| [Chunk Pregenerator](mods/chunk-pregenerator.md) | `1.1-mod` | Evidence inventory; behavioral review pending |
| [Not Enough FPS](mods/not-enough-framerate.md) | `26.3-1.1.1` | Evidence inventory; behavioral review pending |
| [The NoFog Mod](mods/the-nofog-mod.md) | `1.0` | Evidence inventory; behavioral review pending |
| [Simple AutoPickup](mods/simple-autopickup.md) | `1.4.17+26.3` | Evidence inventory; behavioral review pending |
| [Chunky Offline](mods/chunky-offline.md) | `v1.1.0+mod` | Evidence inventory; behavioral review pending |
| [Infinite Night Vision](mods/night-vision-datapack.md) | `1.0.0-mod` | Evidence inventory; behavioral review pending |
| [Double Hotbar](mods/double-hotbar.md) | `1.3.4-mc26.3-fabric` | Evidence inventory; behavioral review pending |
| [SettingsManagerLib](mods/settingsmanagerlib.md) | `1.1.3+26.3` | Evidence inventory; behavioral review pending |
| [NoSignGUI](mods/disablesigngui.md) | `4.2.0+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Clean View](mods/cleanview-2.0.md) | `1.0.9` | Evidence inventory; behavioral review pending |
| [Just Enough Book](mods/justenoughbook.md) | `1.1.1-26.3` | Evidence inventory; behavioral review pending |
| [Better Place Bind](mods/better-place-bind.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [Eslium](mods/eslium.md) | `4.6.0` | Evidence inventory; behavioral review pending |
| [LazyAI](mods/lazyai.md) | `1.7.1` | Evidence inventory; behavioral review pending |
| [SmoothTextureFix](mods/smoothtexturefix.md) | `1.0.0+26.3` | Behavioral static review |
| [FixMCStats](mods/fixmcstats.md) | `fabric-2.5.0` | Evidence inventory; behavioral review pending |
| [Disable Portal Checks](mods/disable-portal-checks.md) | `1.0.0` | Behavioral static review |
| [Fishing Rod Fix](mods/fishing-rod-fix.md) | `26.3-v0.6` | Evidence inventory; behavioral review pending |
| [Tick Sync](mods/tick-sync.md) | `1.4.0` | Evidence inventory; behavioral review pending |
| [ Client Side Noteblocks](mods/clientsidenoteblocks.md) | `2.14` | Evidence inventory; behavioral review pending |
| [Vanilla+ TPS](mods/vtps.md) | `2.8.4.3` | Evidence inventory; behavioral review pending |
| [Random Death Drop](mods/random-death-drop.md) | `fabric` | Evidence inventory; behavioral review pending |
| [Vignette Tweaks](mods/vignettetweaks.md) | `2.1.0+26.3` | Evidence inventory; behavioral review pending |
| [DawnGuiReader](mods/dawnguireader.md) | `1.3.0+mc26.3` | Evidence inventory; behavioral review pending |
| [Iris Extension](mods/iris-extension.md) | `1.0.3+26.3` | Evidence inventory; behavioral review pending |
| [LightAura](mods/lightaura.md) | `8.9.7` | Evidence inventory; behavioral review pending |
| [Nondirectional Damage Tilt Fix](mods/nondirectionaldamagetiltfix.md) | `3.0.0` | Evidence inventory; behavioral review pending |
| [CraftSense](mods/craftsense.md) | `2.0.0` | Evidence inventory; behavioral review pending |
| [Flashback Extras](mods/flashback-extras.md) | `1.3.0` | Evidence inventory; behavioral review pending |
| [Optimized Fullbright](mods/optimized-fullbright.md) | `2.0.0+26.2-fabric` | Evidence inventory; behavioral review pending |
| [Slumber](mods/slumber.md) | `mc26.2-2.0.0` | Evidence inventory; behavioral review pending |
| [Whiteout](mods/whiteout.md) | `0.21.0` | Evidence inventory; behavioral review pending |
| [Smooth Join](mods/smooth-join.md) | `1.3.2` | Behavioral static review |
| [Enhanced Celestials 2: Shader Support](mods/enhanced-celestials-2-shader-support.md) | `5.0.0.0-fabric` | Evidence inventory; behavioral review pending |
| [Locator Bar](mods/reworked-locator-bar.md) | `1.2.4+26.3.x-fabric` | Evidence inventory; behavioral review pending |
| [Stonecutter GUI Remastered](mods/stonecutter-gui-remastered.md) | `2.1.1-1.26.3` | Evidence inventory; behavioral review pending |
| [I DON'T WANNA SCROLL AGAIN!](mods/idontwannascrollagain.md) | `1.0.0+26.3` | Evidence inventory; behavioral review pending |
| [Motion Blur](mods/afkz-motion-blur.md) | `1.0-release` | Evidence inventory; behavioral review pending |
| [Block Entity Render Distance](mods/block-entity-rd.md) | `1.0.0` | Behavioral static review |
| [Not Enough Pots](mods/not-enough-pots.md) | `1.5.1` | Evidence inventory; behavioral review pending |
| [KastSize — Aspect Ratio Stretch](mods/kastsize-aspect-ratio-stretch.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [datapack function library](mods/datapack-function-library.md) | `5.0.0+mod` | Evidence inventory; behavioral review pending |
| [Helpful Commands](mods/helpful-commands.md) | `4.2.3` | Evidence inventory; behavioral review pending |
| [Better Resolution](mods/better-resolution.md) | `1.1.0` | Evidence inventory; behavioral review pending |
| ["Limitless" Banners](mods/limitless-banners.md) | `1.4.0` | Evidence inventory; behavioral review pending |
| [WindowFix](mods/window-fix.md) | `1.0.1` | Behavioral static review |
| [FPS-Sync (FPS Limiter)](mods/fps-sync.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [No More Pop-ups](mods/no-more-popups.md) | `2.3.1` | Evidence inventory; behavioral review pending |
| [SimpleHUD](mods/simplehud.md) | `2.2` | Evidence inventory; behavioral review pending |
| [NoDynamicFps](mods/nodynamicfps.md) | `1.1.0+26.2` | Behavioral static review |
| [Serverlist Fix](mods/serverlist-fix.md) | `1.0.2` | Behavioral static review |
| [Nemo's Mending](mods/nemos-mending.md) | `26.3-1.1.2` | Evidence inventory; behavioral review pending |
| [Simple-Warp-Tpa-Home-Back](mods/ziy-swthb.md) | `1.3` | Evidence inventory; behavioral review pending |
| [Fast Recipe](mods/fast-recipe.md) | `1.0.3+26.3+fabric` | Evidence inventory; behavioral review pending |
| [OptiLeaves(Fabric)](mods/optileaves-fabric.md) | `2.0.1` | Evidence inventory; behavioral review pending |
| [Maps of the Unknown](mods/bettermaps.md) | `0.9.1-26.2` | Evidence inventory; behavioral review pending |
| [CarpetGUI](mods/carpetgui.md) | `2.0.0+26.3` | Evidence inventory; behavioral review pending |
| [String Duper](mods/string-dupe.md) | `1.0.3` | Evidence inventory; behavioral review pending |
| [HUD - FPS Veltium](mods/veltium.md) | `0.1.22+26.3` | Evidence inventory; behavioral review pending |
| [Free Cursor](mods/free-cursor.md) | `1.3.1+mc26.3` | Evidence inventory; behavioral review pending |
| [Worldthreader](mods/worldthreader.md) | `mc26.3-3.2.0-fabric` | Evidence inventory; behavioral review pending |
| [Reload Server List](mods/reload-server-list.md) | `2.0` | Evidence inventory; behavioral review pending |
| [KeybindsGalore (HVB007)](mods/keybindsgalore-plus-hvb007.md) | `1.8.0` | Evidence inventory; behavioral review pending |
| [Name Tag (Craft & Drops)](mods/name-tag.md) | `v2.2.0.0+mod` | Evidence inventory; behavioral review pending |
| [Sulkan](mods/sulkan.md) | `0.5.1` | Evidence inventory; behavioral review pending |
| [NeoToolTipFix](mods/neotooltipfix.md) | `1.2.1-26.3` | Evidence inventory; behavioral review pending |
| [GGTU](mods/ggtu.md) | `Neo-1.1.2+mc26.3` | Evidence inventory; behavioral review pending |
| [veinminer++](mods/veinminer-plus-plus.md) | `0.6.0+mc26.3` | Evidence inventory; behavioral review pending |
| [PackForge - Optimized Resource Pack Loading Time](mods/packforge.md) | `1.4.1` | Evidence inventory; behavioral review pending |
| [Async Hotbars](mods/hotbar-lag-fixer.md) | `1.1.1` | Behavioral static review |
| [Inventory Item Groups](mods/inventory-item-groups.md) | `1.5.3-fabric+26.3` | Evidence inventory; behavioral review pending |
| [inputbooster](mods/inputbooster.md) | `4.0.0-fabric-mc263` | Evidence inventory; behavioral review pending |
| [Disable Narrator](mods/disable-narrator.md) | `1.0.0` | Behavioral static review |
| [First Steps](mods/first-step-mod.md) | `2.30` | Evidence inventory; behavioral review pending |
| [Resource Trimmer](mods/resource-trimmer.md) | `26.3.0.1` | Behavioral static review |
| [Panda Anti-Lag](mods/pandaantilag.md) | `2.3.0+26.3` | Evidence inventory; behavioral review pending |
| [Breaking Place](mods/breaking-place.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [Auto Eater](mods/auto-eater.md) | `1.5.1` | Evidence inventory; behavioral review pending |
| [XP Stream](mods/xp-stream.md) | `1.1.8` | Evidence inventory; behavioral review pending |
| [Call Your Cat](mods/call-your-cat.md) | `v2.2.0.0+mod` | Evidence inventory; behavioral review pending |
| [!lag](mods/lag.md) | `3.0.0` | Evidence inventory; behavioral review pending |
| [Shulker & Bundle](mods/shulker-bundle.md) | `1.7` | Evidence inventory; behavioral review pending |
| [PackTest](mods/packtest.md) | `2.7.0` | Evidence inventory; behavioral review pending |
| [Cerulean Fork](mods/cerulean-fork.md) | `1.0.1` | Evidence inventory; behavioral review pending |
| [Far Block Entity Rendering](mods/farblockentityrendering.md) | `2.1+26.3` | Evidence inventory; behavioral review pending |
| [FastChest Update](mods/fastchest-update.md) | `1.10+26.3` | Behavioral static review |
| [NumFlux](mods/numflux.md) | `1.0.6-26.3-fabric` | Evidence inventory; behavioral review pending |
| [Auto Sprint Fix](mods/sprint-fix.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [Explodee](mods/explodee.md) | `1.1+26.1-26.3-fabric` | Evidence inventory; behavioral review pending |
| [Better Hitbox](mods/better-hitbox.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [Keybind Bug Fixes](mods/keybindbugfixes.md) | `1.6.0` | Evidence inventory; behavioral review pending |
| [Optimized Cushions](mods/optimized-cushions.md) | `1.2.0` | Evidence inventory; behavioral review pending |
| [HCsCR](mods/hcscr.md) | `2.1.13+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Generator](mods/chunk_gen.md) | `12+mod` | Evidence inventory; behavioral review pending |
| [Purescale](mods/purescale.md) | `1.2.1` | Evidence inventory; behavioral review pending |
| [MTSAntiCheat](mods/anticheatmts.md) | `0.1.0+26.3` | Evidence inventory; behavioral review pending |
| [Compact F3](mods/compact-f3.md) | `1.3.3` | Evidence inventory; behavioral review pending |
| [Console Spam Fix : Reborn](mods/console-spam-fix-reborn.md) | `2.1.0` | Evidence inventory; behavioral review pending |
| [Yggdrasil Proxy](mods/yggdrasil-proxy.md) | `26.06.1-fabric` | Evidence inventory; behavioral review pending |
| [No Waypoints/Locator Bar](mods/no-way.md) | `1.4.0` | Evidence inventory; behavioral review pending |
| [Disable Lighting](mods/disable-lighting.md) | `1.3.0` | Behavioral static review |
| [Xeno](mods/xeno.md) | `0.1.9` | Evidence inventory; behavioral review pending |
| [cbbg 🥬](mods/cbbg.md) | `1.5.0+mc26.3-fabric` | Evidence inventory; behavioral review pending |
| [AirPlace](mods/airplace.md) | `1.1.1` | Evidence inventory; behavioral review pending |
| [Greedy Meshing Mod](mods/greedy-meshing-mod.md) | `0.6.1+26.3` | Evidence inventory; behavioral review pending |
| [Boosters](mods/boosters.md) | `1.3.4.1-hotfix` | Evidence inventory; behavioral review pending |
| [Entity Stack Rendering](mods/entity-stack-rendering.md) | `1.2` | Evidence inventory; behavioral review pending |
| [Simple Keybinds](mods/simple-keybinds.md) | `1.4.7` | Evidence inventory; behavioral review pending |
| [Fast Leaf Decay](mods/fast_leaf_decay.md) | `2.0.1+mod` | Evidence inventory; behavioral review pending |
| [Log Cleaner Multi Loader](mods/log-cleaner-multiloader.md) | `2.0.0` | Evidence inventory; behavioral review pending |
| [PulseNet](mods/pulsenet.md) | `1.1.0+26.3` | Evidence inventory; behavioral review pending |
| [SeamlessChunks](mods/schunks.md) | `0.1.0-beta.7+26.3-fabric` | Evidence inventory; behavioral review pending |
| [ServerPingFixer](mods/pingfixer.md) | `1.0.2+26.1-26.3` | Behavioral static review |
| [Decent Freelook](mods/decentfreelook.md) | `1.3+26.3` | Evidence inventory; behavioral review pending |
| [ServerLens](mods/serverlens.md) | `2.1.0` | Evidence inventory; behavioral review pending |
| [Panda TNT Fusion](mods/pandatntfusion.md) | `1.0.0+26.3` | Evidence inventory; behavioral review pending |
| [Optis](mods/optis.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [fweigel-util-lib](mods/fweigel-util-lib.md) | `1.7.0` | Evidence inventory; behavioral review pending |
| [config-editor-render](mods/config-editor.md) | `1.1.11+26.3` | Evidence inventory; behavioral review pending |
| [Improved F3](mods/improvedf3.md) | `2.0.1+26.3` | Evidence inventory; behavioral review pending |
| [Better Auto Totem](mods/better-auto-totem.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [MacOS Input Fixes (Neoforged)](mods/mac-input-fixes-neoforged.md) | `26.10.03-p` | Evidence inventory; behavioral review pending |
| [Xaero's Optimal Beacons Add-On](mods/xaeros-optimal-beacons-add-on.md) | `1.3.0` | Evidence inventory; behavioral review pending |
| [FramePacer](mods/framepacer.md) | `1.2.1` | Behavioral static review |
| [Better Left Click](mods/better-left-click.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [OneHitTreeChopper](mods/onehittreechopper.md) | `3.0.1` | Evidence inventory; behavioral review pending |
| [Meow Anti-Xray](mods/meowanti-xray.md) | `1.7.0+mc26.3.fabric` | Evidence inventory; behavioral review pending |
| [ShopShelves](mods/shopshelves.md) | `1.0.14` | Evidence inventory; behavioral review pending |
| [WhereWaterGo (Bigger Sponge)](mods/wwg.md) | `2.1.2-1.26.3` | Evidence inventory; behavioral review pending |
| [FastLeafDecay](mods/fastleafdecay.md) | `2.0.0` | Evidence inventory; behavioral review pending |
| [GeyserFixes](mods/geyserfixes.md) | `1.1.1` | Evidence inventory; behavioral review pending |
| [Dynamic Performance](mods/dynamic-performance.md) | `0.2.0+26.1-fabric` | Evidence inventory; behavioral review pending |
| [AntiFirmament](mods/antifirmament.md) | `1.0.3` | Evidence inventory; behavioral review pending |
| [IG: Item Clumps](mods/ig-item-clumps.md) | `1.0.29+26.3` | Evidence inventory; behavioral review pending |
| [Better Trialchamber Loot](mods/better-trialchamber-loot.md) | `26.3` | Evidence inventory; behavioral review pending |
| [Harvest Simplified](mods/harvest-simplified.md) | `1.1+mod` | Evidence inventory; behavioral review pending |
| [Rhenium](mods/rhenium-mod.md) | `1.2.1` | Behavioral static review |
| [AFK Fishing](mods/afkfishing.md) | `26.3` | Evidence inventory; behavioral review pending |
| [Crafting Tweaks](mods/craftingtweaks.md) | `1.8+mod` | Evidence inventory; behavioral review pending |
| [Careful Break](mods/careful-break.md) | `1.3.1` | Evidence inventory; behavioral review pending |
| [VulkanCompat](mods/vulkancompat.md) | `1.2-mc26.3` | Evidence inventory; behavioral review pending |
| [Scalable](mods/downloadableduck-scalable.md) | `1.0.5-26.2` | Evidence inventory; behavioral review pending |
| [XtremeUtilities](mods/xtremeutilities.md) | `1.0.5` | Evidence inventory; behavioral review pending |
| [SooperDooperScooper](mods/sooperdooperscooper.md) | `1.4.1+26.3` | Evidence inventory; behavioral review pending |
| [Lite FPS](mods/lite-fps-patrolin.md) | `1.0.0` | Behavioral static review |
| [SmoothMenu Reloaded](mods/smoothmenu.md) | `26.3-1.0.0` | Behavioral static review |
| [STFU Disconnect](mods/stfudisconnect.md) | `4.0.0` | Behavioral static review |
| [more gunpowder (creeper)](mods/more-gunpowder-creeper.md) | `26.3+mod` | Evidence inventory; behavioral review pending |
| [Meshelium](mods/meshelium.md) | `1.6.2+mc26.3` | Evidence inventory; behavioral review pending |
| [MeowConsole](mods/meowconsole.md) | `1.5.0+mc26.3` | Evidence inventory; behavioral review pending |
| [expRepair](mods/exprepair.md) | `1.9.5` | Evidence inventory; behavioral review pending |
| [Bypass Fabric Check](mods/bypass-fabric-check.md) | `1.0.11` | Evidence inventory; behavioral review pending |
| [ClickOptimizer](mods/clickoptimizer.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [Craftables](mods/craftables-datapack.md) | `1.16-26.3+mod` | Evidence inventory; behavioral review pending |
| [Antideath-Carpet-addition](mods/antideath-carpet-addition.md) | `v1.6.0-mc26.3` | Evidence inventory; behavioral review pending |
| [Prefer OpenGL](mods/preferopengl.md) | `fabric-26.2-v1.0.0` | Behavioral static review |
| [Client-side Custom Music Disc Fix](mods/client-side-custom-music-disc-fix.md) | `1.1.6+26.3` | Evidence inventory; behavioral review pending |
| [FluidCam](mods/fluidcam.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [No Void](mods/novoid.md) | `0.1.1+mod` | Evidence inventory; behavioral review pending |
| [Woodcutter](mods/woodworking.md) | `1.2+mod` | Evidence inventory; behavioral review pending |
| [No Piglin Brutes](mods/no-piglinbrutes.md) | `1+mod` | Evidence inventory; behavioral review pending |
| [Hibernate Fabric](mods/hibernate-fabric.md) | `1.2.1+mc26.3` | Evidence inventory; behavioral review pending |
| [Elytra Slot](mods/elytra-slot-cafekad.md) | `1.1.0` | Evidence inventory; behavioral review pending |
| [No More Explosions](mods/no-more-explosions.md) | `0.1.2+mod` | Evidence inventory; behavioral review pending |
| [A* Pathfinding](mods/a-star-pathfinding.md) | `0.7.3+mod` | Evidence inventory; behavioral review pending |
| [Bring Blocking Back](mods/bring-blocking-back.md) | `2.3.0-26.3` | Evidence inventory; behavioral review pending |
| [ParaMax](mods/paramax.md) | `v1.3.1+26.3` | Evidence inventory; behavioral review pending |
| [Stop Pause My Music](mods/stop_pause_my_music.md) | `1.0-26.3` | Evidence inventory; behavioral review pending |
| [Deobfuscator](mods/deobfuscator.md) | `1.0.0+26.3` | Evidence inventory; behavioral review pending |
| [Carpet ROF Addition](mods/carpet-rof-addition.md) | `1.6.1` | Evidence inventory; behavioral review pending |
| [Item Blocker](mods/item-blocker.md) | `1.6+26.3` | Evidence inventory; behavioral review pending |
| [Baby Mob Fix](mods/babymodfix.md) | `1.1.5` | Evidence inventory; behavioral review pending |
| [Visually Waxed Golems](mods/visually-waxed-golems.md) | `1.0.1+mod` | Evidence inventory; behavioral review pending |
| [Cast Away](mods/castaway.md) | `3.0.2` | Evidence inventory; behavioral review pending |
| [Escape from the Void with Totem of Undying](mods/escape-from-the-void-with-totem-of-undying.md) | `1.07` | Evidence inventory; behavioral review pending |
| [No More Narrator](mods/nomorenarrator.md) | `26.3-1.1` | Behavioral static review |
| [Glow Squid Spawn Fix](mods/glowsquidspawnfix.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [Corpanion](mods/corpanion.md) | `1.19.0` | Evidence inventory; behavioral review pending |
| [Hot-Reload Resource Packs Forked](mods/hot-reload-resource-packs-forked.md) | `1.2.0` | Evidence inventory; behavioral review pending |
| [WhatIsInThatShelf](mods/wiits.md) | `1.0.1` | Evidence inventory; behavioral review pending |
| [No Invalid Session ID](mods/no-invalid-session-id.md) | `3.1.0` | Evidence inventory; behavioral review pending |
| [AntiFreeze](mods/anti-freeze.md) | `1.1.0` | Evidence inventory; behavioral review pending |
| [Thiepine](mods/thiepine.md) | `1.1.1+mc26.3` | Behavioral static review |
| [Xaero's Biome Filter](mods/xaeros-biome-filter.md) | `1.1.2+26.3` | Evidence inventory; behavioral review pending |
| [ScreenshotMetadata](mods/screenshotmetadata.md) | `1.4.2` | Evidence inventory; behavioral review pending |
| [F3 ADVANCE](mods/f3-advance.md) | `0.1.1+mc26.3` | Evidence inventory; behavioral review pending |
| [Map Rendering Disabler](mods/map-rendering-disabler.md) | `1.0.0+26.1` | Behavioral static review |
| [TradeHall Villager/Farm Optimizer](mods/tradehall-villagers-optimizer.md) | `1.1.0` | Evidence inventory; behavioral review pending |
| [Stronghold Finder (One Eye Updated)](mods/stronghold-finder-one-eye.md) | `1.1+26.3` | Evidence inventory; behavioral review pending |
| [Item Name Gradients](mods/item-name-gradients.md) | `1.0.2` | Evidence inventory; behavioral review pending |
| [Enttick](mods/enttick.md) | `0.2.0` | Evidence inventory; behavioral review pending |
| [Optional Pickup](mods/optional-pickup.md) | `0.1.5-mc26.3` | Evidence inventory; behavioral review pending |
| [LCull](mods/lcull.md) | `mc26.3-1.1.0-fabric` | Evidence inventory; behavioral review pending |
| [Fontrast](mods/fontrast.md) | `1.1.1` | Evidence inventory; behavioral review pending |
| [Command Profiler](mods/command-profiler.md) | `1.4.1+26.3-pre.2` | Evidence inventory; behavioral review pending |
| [Craftable Cobwebs](mods/craftablecobwebs.md) | `1.0.1-1.21.9-26.3+mod` | Evidence inventory; behavioral review pending |
| [Minecraft Custom Day/Night Mod](mods/minecraft-custom-daynight-mod.md) | `2.2.0` | Evidence inventory; behavioral review pending |
| [Mod That Closes The Game When It Opens](mods/modthatclosesthegamewhenitopens.md) | `1.0.0` | Behavioral static review |
| [PinChat](mods/pinchat.md) | `3.2.0-fabric-mc26.3` | Evidence inventory; behavioral review pending |
| [macOS Chat Fixes](mods/macos-chat-fixes.md) | `1.0.1` | Evidence inventory; behavioral review pending |
| [Bellows](mods/smithed-bellows.md) | `1.1.1` | Evidence inventory; behavioral review pending |
| [PathWeaver](mods/pathweaver.md) | `0.9.0+26.3` | Evidence inventory; behavioral review pending |
| [Environmental Fog Disable](mods/environmental-fog-disable.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [Polypheides Resolution Scaler](mods/polypheides-resolution-scaler.md) | `1.2.3+mc26.3` | Evidence inventory; behavioral review pending |
| [FastMapCodec](mods/fastmapcodec.md) | `1.0.4` | Behavioral static review |
| [Client Movement](mods/client-movement.md) | `1.1` | Behavioral static review |
| [Better Stacking](mods/better-stacking.md) | `26.3-1.0.0-beta1` | Evidence inventory; behavioral review pending |
| [Cave Mushroom Fix](mods/cavemushroomfix.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [QuickTrigger](mods/quicktrigger.md) | `1.3.0` | Evidence inventory; behavioral review pending |
| [Eternal FPS](mods/eternal-fps.md) | `4.0.0` | Evidence inventory; behavioral review pending |
| [Potato3D](mods/potato3d.md) | `1.2.0+26.3` | Evidence inventory; behavioral review pending |
| [Lower Shelves](mods/lower-shelves.md) | `1.0.7` | Evidence inventory; behavioral review pending |
| [DripStone Recipe FIX](mods/dripstonerecipefix.md) | `1.2.0+mod` | Evidence inventory; behavioral review pending |
| [Non Persistent Wither Skulls](mods/non-persistent-wither-skulls.md) | `1.0.3-mc-26.3` | Behavioral static review |
| [AutoMuteOnAfk](mods/automuteonafk.md) | `1.1.0` | Evidence inventory; behavioral review pending |
| [Cull Display Entities](mods/cull-display-entities.md) | `1.3.0` | Behavioral static review |
| [Better Clock](mods/betterclock.md) | `1.1.0+26.3` | Evidence inventory; behavioral review pending |
| [Basic Macros](mods/auto-keybinds.md) | `0.0.3` | Evidence inventory; behavioral review pending |
| [Objectively](mods/objectively.md) | `1.0.5` | Evidence inventory; behavioral review pending |
| [Blindspot](mods/blindspot.md) | `0.3.0` | Evidence inventory; behavioral review pending |
| [FastOrbs](mods/fastorbs.md) | `1.0-SNAPSHOT` | Behavioral static review |
| [Mascom (Mass Commands)](mods/mascom.md) | `m1.0+` | Evidence inventory; behavioral review pending |
| [AnvilOrder](mods/anvilorder.md) | `26.3` | Evidence inventory; behavioral review pending |
| [Distant Decorations](mods/distant-decorations.md) | `2.0.0` | Evidence inventory; behavioral review pending |
| [Really Fast Paintings](mods/really-fast-paintings.md) | `2.0.0` | Evidence inventory; behavioral review pending |
| [Zoom Extended](mods/zoom-extended.md) | `1.3.3` | Evidence inventory; behavioral review pending |
| [Disable Spawner Mob Spawns](mods/disable-spawner-mob-spawns.md) | `1+mod` | Evidence inventory; behavioral review pending |
| [VectorX](mods/vectorx.md) | `0.2.0` | Evidence inventory; behavioral review pending |
| [Lobotomy Inc.](mods/lobotomy-inc..md) | `1.5.0+26.3` | Evidence inventory; behavioral review pending |
| [Fix MC-139908](mods/fix_mc-139908.md) | `1.0_4_26.2` | Evidence inventory; behavioral review pending |
| [Crafting Refinements: Blast Buff](mods/crafting-refinements-blast-buff.md) | `5.0+mod` | Evidence inventory; behavioral review pending |
| [Miner's Dreams](mods/miners-dreams.md) | `1.0.1` | Evidence inventory; behavioral review pending |
| [Nimbus 2000](mods/nimbus-2000.md) | `1.0.2` | Evidence inventory; behavioral review pending |
| [(ST) Locator Radar](mods/st-locator-bar.md) | `1.3+mod` | Evidence inventory; behavioral review pending |
| [Forced Render Distance](mods/forced-render-distance.md) | `v1.0+mod` | Evidence inventory; behavioral review pending |
| [Alot Of Enchants -- 300+](mods/alot-of-enchants-300.md) | `1+mod` | Evidence inventory; behavioral review pending |
| [VO: Camera Culling](mods/vo-camera-culling.md) | `1.0.0+26.3` | Evidence inventory; behavioral review pending |
| [Hide Models](mods/hide-models.md) | `mc26.1-26.3-2.1.0-fabric` | Evidence inventory; behavioral review pending |
| [NotEnoughPalette](mods/notenoughpalette.md) | `0.3.0` | Evidence inventory; behavioral review pending |
| [Do I Reload?](mods/do-i-reload.md) | `1.1` | Behavioral static review |
| [Instant Arrow Despawn](mods/instant-arrow-despawn.md) | `v1.0+mod` | Evidence inventory; behavioral review pending |
| [OFFHand KeyBind](mods/offhand-keybind.md) | `2.0.0` | Evidence inventory; behavioral review pending |
| [Get my blocks back](mods/get-my-blocks-back.md) | `1.0.0+mc26.1-26.3` | Evidence inventory; behavioral review pending |
| [Clientify](mods/clientify.md) | `1.0.2+26.3` | Evidence inventory; behavioral review pending |
| [Fallback](mods/fallback.md) | `1.3.0-beta.2` | Evidence inventory; behavioral review pending |
| [YugiTotem](mods/yugitotem.md) | `1.3.0` | Evidence inventory; behavioral review pending |
| [Krypton](mods/krypton.md) | `0.3.2` | Evidence inventory; behavioral review pending |
| [Debugify](mods/debugify.md) | `26.3.0.0` | Evidence inventory; behavioral review pending |
| [Fast Noise](mods/zfastnoise.md) | `1.1.1+26.3` | Evidence inventory; behavioral review pending |
| [Distant Horizons](mods/distanthorizons.md) | `3.3.4-26.3` | Artifact unavailable; implementation not verified |
| [AsyncParticles](mods/asyncparticles.md) | `26.3.2.0-alpha.2` | Evidence inventory; behavioral review pending |
| [Very Many Players (Fabric)](mods/vmp-fabric.md) | `0.2.0+beta.7.238+26.3` | Artifact unavailable; implementation not verified |
| [FPS Reducer](mods/fps-reducer.md) | `26.3-2.18` | Evidence inventory; behavioral review pending |
| [Fast Item Frames](mods/fast-item-frames.md) | `26.3.0` | Evidence inventory; behavioral review pending |
| [Iris Shaders](mods/iris.md) | `1.11.7+26.3-fabric` | Artifact unavailable; implementation not verified |
| [Better Clouds](mods/better-clouds.md) | `1.15.0-beta.3` | Evidence inventory; behavioral review pending |
| [Ixeris](mods/ixeris.md) | `4.6.8+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Borderless Fullscreen](mods/borderless-fullscreen.md) | `2.5.1-26.3` | Artifact unavailable; implementation not verified |
| [Entity View Distance](mods/entity-view-distance.md) | `1.9.0+26.2` | Evidence inventory; behavioral review pending |
| [Boat Item View](mods/boat-item-view.md) | `26.3-0.0.10-fabric` | Artifact unavailable; implementation not verified |
| [CrashExploitFixer](mods/crashexploitfixer.md) | `fabric-2.0.0+26.3` | Artifact unavailable; implementation not verified |
| [Async Logger](mods/asynclogger.md) | `2.2.2+26.1.2-fabric` | Evidence inventory; behavioral review pending |
| [Improved Pillager Outpost](mods/improved-pillager-outpost.md) | `7` | Artifact unavailable; implementation not verified |
| [Sodium](mods/sodium.md) | `mc26.3-0.9.2-fabric` | Artifact unavailable; implementation not verified |
| [Fast Server Pings](mods/fastserverpings.md) | `1.1.5+26.3` | Evidence inventory; behavioral review pending |
| [Podium](mods/podium.md) | `1.1.1` | Evidence inventory; behavioral review pending |
| [Feather remake](mods/feather-remake.md) | `1.4.0` | Artifact unavailable; implementation not verified |
| [ModernFix-mVUS](mods/modernfix-mvus.md) | `5.27.20-build.2` | Evidence inventory; behavioral review pending |
| [Server Resourcepack Checker](mods/server-resource-pack-checker.md) | `fabric-1.2.2+26.3` | Evidence inventory; behavioral review pending |
| [Voxy Server Side](mods/voxy-server-side.md) | `0.18.0` | Artifact unavailable; implementation not verified |
| [Async](mods/async.md) | `0.2.5+alpha-26.3` | Artifact unavailable; implementation not verified |
| [Pearl Optimizer](mods/pearl_optimizer.md) | `26.3` | Evidence inventory; behavioral review pending |
| [Super Resolution](mods/superresolution.md) | `26.3-0.9.2-alpha.2+gl-fabric` | Artifact unavailable; implementation not verified |
| [Better Capes](mods/better-capes.md) | `1.6.2` | Artifact unavailable; implementation not verified |
| [Put A Plug In it! (PAPI)](mods/put-a-plug-in-it.md) | `fabric-26.3-1.3.0` | Evidence inventory; behavioral review pending |
| [Moonrise](mods/moonrise-opt.md) | `1.2.0+61c1328` | Artifact unavailable; implementation not verified |
| [Entity Culling](mods/entityculling.md) | `1.11.3` | Evidence inventory; behavioral review pending |
| [Crash Assistant](mods/crash-assistant.md) | `1.11.14` | Artifact unavailable; implementation not verified |
| [Better Client](mods/better-client-enc.md) | `11.0.2+fabric` | Artifact unavailable; implementation not verified |
| [Jasione](mods/jasione.md) | `1.0.9+26.1.2-fabric` | Evidence inventory; behavioral review pending |
| [Adaptive Performance Tweaks](mods/adaptive-performance-tweaks.md) | `12.10.0` | Artifact unavailable; implementation not verified |
| [Sodium/Embeddium Device Check 钠/铷-设备检测](mods/sodium-device-check.md) | `6.0.0` | Evidence inventory; behavioral review pending |
| [Concurrent Chunk Management Engine (Fabric)](mods/c2me-fabric.md) | `0.4.2-alpha.0.103+26.3` | Artifact unavailable; implementation not verified |
| [Unloaded Activity](mods/unloaded-activity.md) | `0.7.3+26.3` | Evidence inventory; behavioral review pending |
| [Silly's Auto Totem](mods/sillys-auto-totem.md) | `2.3.6` | Evidence inventory; behavioral review pending |
| [Distant Horizons SeedGen](mods/distant-horizons-seedgen.md) | `0.9.1` | Artifact unavailable; implementation not verified |
| [Mercurizer](mods/mercurizer.md) | `0.9.2+mc26.3-1.1` | Evidence inventory; behavioral review pending |
| [Accelerated Recoiling](mods/accelerated-recoiling.md) | `26.3.0-fabric` | Evidence inventory; behavioral review pending |
| [Potatoptimize](mods/potatoptimize.md) | `mc26.2-2.2.2` | Evidence inventory; behavioral review pending |
| [Animal Pens](mods/animalpens.md) | `2.5.1-26.3` | Evidence inventory; behavioral review pending |
| [Opticores](mods/opticores.md) | `v1.1.1.5+26.x` | Artifact unavailable; implementation not verified |
| [Signs Faster](mods/sf-plus.md) | `1.0.3` | Artifact unavailable; implementation not verified |
| [Carpet AMS Addition](mods/carpet-ams-addition.md) | `mc26.3-v26.4-beta.2` | Evidence inventory; behavioral review pending |
| [Axis World Editor](mods/axis.md) | `0.6.1-mod` | Artifact unavailable; implementation not verified |
| [Stacks Are Stacks](mods/stacks-are-stacks.md) | `2.1.5-1.26.3` | Evidence inventory; behavioral review pending |
| [SmoothPlayerAnimations](mods/smoothplayeranimations.md) | `1.1.0+26.3` | Evidence inventory; behavioral review pending |
| [OverpoweredMending](mods/overpoweredmending.md) | `26.3-26.3.0.2` | Evidence inventory; behavioral review pending |
| [LOD Server Support](mods/lod-server-support.md) | `v0.18.0+fabric+mc26.3` | Artifact unavailable; implementation not verified |
| [Sodium Leaf Culling Unofficial](mods/sodiumleafculling-unofficial.md) | `3.3.0+mc26.3-fabric` | Evidence inventory; behavioral review pending |
| [Lomka](mods/lomka.md) | `mc26.3-0.7.0-fabric` | Evidence inventory; behavioral review pending |
| [AutoBuild](mods/autobuild.md) | `2.0.1+26.3` | Artifact unavailable; implementation not verified |
| [Cactus Mod](mods/cactus.md) | `0.15.2` | Artifact unavailable; implementation not verified |
| [Enhanced Block Entities Reloaded](mods/ebe-reloaded.md) | `fabric-0.13.1+26.3` | Evidence inventory; behavioral review pending |
| [Full Bright +](mods/fullbright-plus.md) | `1.0.0+26.3` | Artifact unavailable; implementation not verified |
| [Retromod](mods/retromod.md) | `1.3.4+26.3-fabric` | Artifact unavailable; implementation not verified |
| [Quality of Queso](mods/quality-of-queso.md) | `1.7.18` | Artifact unavailable; implementation not verified |
| [Crossbow Optimizer](mods/crossbow-optimizer.md) | `1.1.0+26.3` | Artifact unavailable; implementation not verified |
| [Fuzz](mods/fuzz.md) | `mc26.3-v1.6.14` | Artifact unavailable; implementation not verified |
| [AutoJump Fix](mods/autojump-fix.md) | `1.0.6+26.3+fabric` | Evidence inventory; behavioral review pending |
| [Subtly Dungeons](mods/subtly-dungeons.md) | `5.0.1` | Artifact unavailable; implementation not verified |
| [NoRender+](mods/norender-plus.md) | `1.0.7,26.3` | Evidence inventory; behavioral review pending |
| [Carpet CuO Addition](mods/carpet_cuo_addition.md) | `1.12.0` | Artifact unavailable; implementation not verified |
| [CrashFixer](mods/crashfixer.md) | `3.1.1+26.3` | Evidence inventory; behavioral review pending |
| [Loom GUI Remastered](mods/loom-gui-remastered.md) | `2.1.1-1.26.3` | Evidence inventory; behavioral review pending |
| [Polymer - Quality of Life](mods/polymer-qol.md) | `1.0.3+26.3` | Evidence inventory; behavioral review pending |
| [Am I Up To Date?](mods/aiutd.md) | `2.7.1-fabric+26.3` | Evidence inventory; behavioral review pending |
| [VulkanFlow](mods/vulkanflow.md) | `0.1.12-alpha` | Evidence inventory; behavioral review pending |
| [Client Projectiles](mods/client-projectiles.md) | `1.1.1+26.3` | Artifact unavailable; implementation not verified |
| [Hudder](mods/hudder.md) | `11.0.0-26.3` | Artifact unavailable; implementation not verified |
| [Oxidizium](mods/oxidizium.md) | `mc26.3-1.3.2-panama` | Artifact unavailable; implementation not verified |
| [UUID Hex](mods/uuid-hex.md) | `1.4+mod` | Evidence inventory; behavioral review pending |
| [PerformanceHUD](mods/performancehud.md) | `1.2.0` | Evidence inventory; behavioral review pending |
| [Offline Mode Fix](mods/offline-mode-fix.md) | `1.0.1+26.3` | Evidence inventory; behavioral review pending |
| [Particle Culling](mods/particleculling.md) | `1.0.0+mc26.3` | Evidence inventory; behavioral review pending |
| [DBTools for Axiom](mods/dbtools.md) | `2.3.1+MC26.3-AX6.1.3` | Artifact unavailable; implementation not verified |
| [Better loading screen](mods/better-loading-screen-mod.md) | `1.4.3+26.3` | Artifact unavailable; implementation not verified |
| [FASTJSON2 Serializer for YACL](mods/fastjson4yacl.md) | `1.0.8-fabric+26.1` | Artifact unavailable; implementation not verified |
| [Flashback Turbo](mods/flashbackturbo.md) | `0.6.2+26.3` | Artifact unavailable; implementation not verified |
| [NoammAddons | Hypixel Skyblock](mods/noammaddons.md) | `1.3.0` | Artifact unavailable; implementation not verified |
| [Ferrite](mods/ferrite.md) | `0.7.4-alpha+26.3` | Artifact unavailable; implementation not verified |
| [Fullscreen Tweaks](mods/fullscreen-tweaks.md) | `2.0.1+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Footprint](mods/footprint.md) | `1.0.2-beta+26.3` | Evidence inventory; behavioral review pending |
| [AntiDeath-Survival-Assistant](mods/antideath-survival-assistant.md) | `v1.7.5-mc26.3` | Evidence inventory; behavioral review pending |
| [LootMate](mods/lootmate.md) | `1.1.1+26.3` | Evidence inventory; behavioral review pending |
| [Fcitx5 Enhancer](mods/fcitx5-enhancer.md) | `0.2.14` | Evidence inventory; behavioral review pending |
| [BetterView](mods/betterview.md) | `2.2.1+fabric` | Artifact unavailable; implementation not verified |
| [Dimension tracker + Afk display](mods/dim-tracker-plusafk-display.md) | `1.3+26.3+mod` | Evidence inventory; behavioral review pending |
| [SignalLoss](mods/signalloss.md) | `1.3.0+26.3` | Evidence inventory; behavioral review pending |
| [Afterburner: Optimized](mods/afterburner-optimized.md) | `0.1.26` | Evidence inventory; behavioral review pending |
| [Hyper Client](mods/hyperclient.md) | `1.3.0` | Artifact unavailable; implementation not verified |
| [Sparkle's Morpher](mods/sparkles-morpher.md) | `2.1.1` | Artifact unavailable; implementation not verified |
| [Auto Totem-Optimized](mods/auto-totem-optimized.md) | `1.5` | Artifact unavailable; implementation not verified |
| [BetterExperience](mods/betterexperience.md) | `0.3.5` | Artifact unavailable; implementation not verified |
| [Metallum](mods/metallum-mc.md) | `0.0.25` | Artifact unavailable; implementation not verified |
| [Drop Stacker](mods/drop-stacker.md) | `1.2.1` | Evidence inventory; behavioral review pending |
| [Crafting Refinements](mods/crafting-refinements.md) | `5.0+mod` | Evidence inventory; behavioral review pending |
| [LinearReader](mods/linearreader.md) | `1.3.0.1` | Artifact unavailable; implementation not verified |
| [Enhanced Biomes Music](mods/enhancedbiomemusic.md) | `2.2.1` | Artifact unavailable; implementation not verified |
| [Zoom In](mods/zoom-in.md) | `26.3-0.5.1` | Artifact unavailable; implementation not verified |
| [Hypixel Simple Chat](mods/hypixelsimplechat.md) | `1.9.8` | Evidence inventory; behavioral review pending |
| [vProxyManager](mods/vproxymanager.md) | `2.0.7+fabric.26.x` | Artifact unavailable; implementation not verified |
| [Storage Tracker](mods/storage-tracker.md) | `1.2.1+26.3` | Artifact unavailable; implementation not verified |
| [Ancient Cities](mods/ancient-cities.md) | `1.6` | Artifact unavailable; implementation not verified |
| [Player Hider (Funnest's Edition)](mods/player-hider-funnest-edition.md) | `1.0.0` | Behavioral static review |
| [VulkShade](mods/vulkshade.md) | `v2.0.0-7` | Artifact unavailable; implementation not verified |
| [ShulkerBoxUtils](mods/shulkerboxutils.md) | `1.4.1` | Artifact unavailable; implementation not verified |
| [Totem Doll](mods/totemdoll.md) | `1.3.2-mc26.3-fabric` | Artifact unavailable; implementation not verified |
| [Calculator](mods/calc.md) | `1.1.0+26.3` | Evidence inventory; behavioral review pending |
| [ParkourCalculator](mods/parkourcalculator.md) | `1.15.0` | Artifact unavailable; implementation not verified |
| [Chat Mod](mods/chat-mod.md) | `2.1.5` | Evidence inventory; behavioral review pending |
| [Simple Sugarcane Farming](mods/simple-sugarcane.md) | `1.2+mod` | Evidence inventory; behavioral review pending |
| [Vanilla DayTime Counter](mods/vanilla-daytime-counter.md) | `1.4.6+26.3` | Artifact unavailable; implementation not verified |
| [AxolotlUtils](mods/axolotlutils.md) | `1.2.1` | Artifact unavailable; implementation not verified |
| [Ev's Mod](mods/evmod.md) | `2.4` | Artifact unavailable; implementation not verified |
| [CoffeeProxy](mods/coffeeproxy.md) | `1.2.1+26.3` | Artifact unavailable; implementation not verified |
| [Lumen Tooltips](mods/lumen-tooltips.md) | `26.3-b8+fabric` | Evidence inventory; behavioral review pending |
| [SAH Project "No Falame&Smoke"](mods/sah-project-nofalamesmoke.md) | `1.2.2` | Evidence inventory; behavioral review pending |
| [AFK Guard](mods/afk-guard.md) | `1.1.0-beta.1` | Evidence inventory; behavioral review pending |
| [EMUtils](mods/emutils.md) | `0.14.0+26.3` | Artifact unavailable; implementation not verified |
| [Drop2Inv](mods/drop2inv.md) | `1.2.0+26.1-26.3` | Evidence inventory; behavioral review pending |
| [WaterLightingFix](mods/waterlightingfix.md) | `1.0.1` | Evidence inventory; behavioral review pending |
| [ZoomHehe](mods/zoomhehe.md) | `4.0.0` | Evidence inventory; behavioral review pending |
| [VerSion](mods/version.md) | `1.1-Mod` | Evidence inventory; behavioral review pending |
| [Rendersnap](mods/rendersnap.md) | `1.3.2` | Evidence inventory; behavioral review pending |
| [Crafting Refinements: Six Stairs](mods/crafting-refinements-six-stairs.md) | `5.0+mod` | Evidence inventory; behavioral review pending |
| [Crafting Refinements: Stonecutter Solutions](mods/crafting-refinements-stonecutter-solutions.md) | `5.0+mod` | Artifact unavailable; implementation not verified |
| [CreeperBoom](mods/creeperboom.md) | `1.1+mc26.3-fabric` | Evidence inventory; behavioral review pending |
| [Player Ping Display](mods/player-ping-display.md) | `1.0.0` | Artifact unavailable; implementation not verified |
| [Pack Tools](mods/pack-tools.md) | `1.26.6.2` | Evidence inventory; behavioral review pending |
| [Windows Priority Boost](mods/windows-priority-boost.md) | `1.0.0` | Artifact unavailable; implementation not verified |
| [Crafting Refinements: Recipe Rebalance](mods/crafting-refinements-recipe-rebalance.md) | `5.0+mod` | Evidence inventory; behavioral review pending |
| [Crafting Refinements: Copper Consistency](mods/crafting-refinements-copper-consistency.md) | `5.0+mod` | Artifact unavailable; implementation not verified |
| [ResourcePackDirectory](mods/resourcepacksdirectory.md) | `26.2-5.0` | Artifact unavailable; implementation not verified |
| [Carpet PRY Addition](mods/carpet-pry-addition.md) | `v1.3.0-mc26.3` | Artifact unavailable; implementation not verified |
| [AutoComplete](mods/autocomplete-2.md) | `1.0.3` | Artifact unavailable; implementation not verified |
| [Compresso](mods/compresso.md) | `1.0.3+26.3-fabric` | Artifact unavailable; implementation not verified |
| [EClean-Modern](mods/ecl-modern.md) | `0.3.8+fabric.26.3` | Artifact unavailable; implementation not verified |
