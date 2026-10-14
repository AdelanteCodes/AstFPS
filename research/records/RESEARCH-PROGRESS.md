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
| [Lithium](notes/lithium.md) | `mc26.3-0.26.2-fabric` | Evidence inventory; behavioral review pending |
| [BadOptimizations](notes/badoptimizations.md) | `2.4.1` | Evidence inventory; behavioral review pending |
| [ImmediatelyFast](notes/immediatelyfast.md) | `1.17.1+26.3-fabric` | Evidence inventory; behavioral review pending |
| [FerriteCore](notes/ferrite-core.md) | `9.0.0-fabric` | Evidence inventory; behavioral review pending |
| [Sodium Extra](notes/sodium-extra.md) | `mc26.3-0.9.4+fabric` | Evidence inventory; behavioral review pending |
| [Language Reload](notes/language-reload.md) | `1.7.8+26.3` | Evidence inventory; behavioral review pending |
| [More Culling](notes/moreculling.md) | `1.9.0` | Evidence inventory; behavioral review pending |
| [Dynamic FPS](notes/dynamic-fps.md) | `3.11.10` | Evidence inventory; behavioral review pending |
| [Remove Reloading Screen](notes/rrls.md) | `5.2.8+mc26.3` | Evidence inventory; behavioral review pending |
| [FastQuit](notes/fastquit.md) | `3.1.5+mc26.2` | Evidence inventory; behavioral review pending |
| [Let Me Despawn](notes/lmd.md) | `1.26.9.2` | Evidence inventory; behavioral review pending |
| [Fast IP Ping](notes/fast-ip-ping.md) | `v1.0.12-mc26.3` | Behavioral static review |
| [BetterGrassify](notes/bettergrassify.md) | `1.8.8+fabric.26.3` | Evidence inventory; behavioral review pending |
| [Packet Fixer](notes/packet-fixer.md) | `3.3.6` | Evidence inventory; behavioral review pending |
| [Particle Core](notes/particle-core.md) | `0.3.3+fix1+26.2` | Evidence inventory; behavioral review pending |
| [ScalableLux](notes/scalablelux.md) | `0.3.0-alpha.0.6+26.3` | Evidence inventory; behavioral review pending |
| [Leaves Be Gone](notes/leaves-be-gone.md) | `26.3.0` | Evidence inventory; behavioral review pending |
| [Alternate Current](notes/alternate-current.md) | `mc26.3-1.9.0` | Evidence inventory; behavioral review pending |
| [Better Block Entities](notes/better-block-entities.md) | `1.3.9+mc26.3` | Evidence inventory; behavioral review pending |
| [Cull Leaves](notes/cull-leaves.md) | `4.1.2+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Ksyxis](notes/ksyxis.md) | `1.4.6` | Evidence inventory; behavioral review pending |
| [Structure Layout Optimizer](notes/structure-layout-optimizer.md) | `1.1.4+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Nvidium](notes/nvidium.md) | `0.4.4-beta7-26.3` | Evidence inventory; behavioral review pending |
| [kennytvs-epic-force-close-loading-screen-mod-for-fabric](notes/forcecloseworldloadingscreen.md) | `2.3.7` | Evidence inventory; behavioral review pending |
| [Chunky](notes/chunky.md) | `1.5.3` | Evidence inventory; behavioral review pending |
| [Shield Statuses](notes/shield-statuses.md) | `4.2.1+26.3` | Evidence inventory; behavioral review pending |
| [Server Pinger Fixer](notes/serverpingerfixer.md) | `1.1.1` | Behavioral static review |
| [Gnetum](notes/gnetum.md) | `4.6.3+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Shield Fixes](notes/complete-shield-fixes.md) | `2.1.0+26.3` | Evidence inventory; behavioral review pending |
| [Raise Sound Limit Simplified](notes/rsls.md) | `1.4.0` | Evidence inventory; behavioral review pending |
| [ServerCore](notes/servercore.md) | `1.5.20+26.3` | Evidence inventory; behavioral review pending |
| [Crosshair Addons Public](notes/crosshair-addons-public.md) | `2.2.0+26.3` | Evidence inventory; behavioral review pending |
| [Stfu](notes/shuttfup.md) | `2.9.1-26.3` | Evidence inventory; behavioral review pending |
| [quick pack](notes/quick-pack.md) | `fabric-1.5.1+26.3` | Evidence inventory; behavioral review pending |
| [RenderScale](notes/renderscale.md) | `1.4.0-alpha.6-fabric+26.3` | Evidence inventory; behavioral review pending |
| [Sound Controller](notes/sound-controller.md) | `1.4.1-mc26.3` | Evidence inventory; behavioral review pending |
| [XXL Packets](notes/xxl-packets.md) | `1.0.6-26.x.x-fabric` | Behavioral static review |
| [Get It Together, Drops!](notes/get-it-together-drops.md) | `v1.5.1` | Evidence inventory; behavioral review pending |
| [Better Biome Blend](notes/better-biome-blend.md) | `26.3-1.4.0-fabric` | Evidence inventory; behavioral review pending |
| [CleanCut](notes/cleancut.md) | `8.1.0+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Jukebox Custom Disc Fix](notes/jukebox-custom-disc-fix.md) | `0.2.0-26.3` | Evidence inventory; behavioral review pending |
| [Skeleton AI Fix](notes/skeleton-ai-fix.md) | `26.3.0` | Evidence inventory; behavioral review pending |
| [ResourcePackCached](notes/resourcepackcached.md) | `1.2.8` | Evidence inventory; behavioral review pending |
| [CrashPatch (Crash Preventer)](notes/crashpatch.md) | `v2.2.1` | Evidence inventory; behavioral review pending |
| [Optimized Block Entities [OBE]](notes/obe.md) | `1.1.52` | Evidence inventory; behavioral review pending |
| [Async Pack Scan](notes/async-pack-scan.md) | `26.3.0` | Behavioral static review |
| [Consumable Optimizer](notes/consumableoptimizer.md) | `2.2.3+26.3` | Evidence inventory; behavioral review pending |
| [Simple Datapacks](notes/simple-datapacks.md) | `2.9.1-fabric+26.1` | Evidence inventory; behavioral review pending |
| [NoRollback](notes/norollback.md) | `2.2.0` | Evidence inventory; behavioral review pending |
| [Clumps](notes/ly-clumps.md) | `v1.1.0+mod` | Evidence inventory; behavioral review pending |
| [ToadLib](notes/toadlib.md) | `1.5.3-26.3-fabric` | Evidence inventory; behavioral review pending |
| [Faster Iris Shadow Mapper [FISM]](notes/fism.md) | `1.0.7` | Evidence inventory; behavioral review pending |
| [Variants-CIT](notes/variants-cit.md) | `5.7.1+26.3` | Evidence inventory; behavioral review pending |
| [Sodium Extra Information](notes/sodium-extra-information.md) | `2.9.1` | Evidence inventory; behavioral review pending |
| [No Death Animation](notes/no-death-animation.md) | `2.1.0+26.3` | Evidence inventory; behavioral review pending |
| [Reflex AntiLag](notes/reflex-antilag.md) | `1.1.2+fabric-26.3` | Evidence inventory; behavioral review pending |
| [Multi Key Bindings](notes/multi-key-bindings.md) | `1.3.5+26.3` | Evidence inventory; behavioral review pending |
| [NoPackCompatCheck](notes/nopackcompatcheck.md) | `v0.1.1-fabric-mc26.1+` | Evidence inventory; behavioral review pending |
| [PolyHitbox (Custom Hitboxes)](notes/hitbox.md) | `v1.3.2` | Evidence inventory; behavioral review pending |
| [Accelerated Decay](notes/accelerated-decay.md) | `26.3.0.1` | Evidence inventory; behavioral review pending |
| [TT20 (TPS Fixer)](notes/tt20.md) | `0.8.5` | Evidence inventory; behavioral review pending |
| [RailOptimization](notes/railoptimization.md) | `2.0` | Evidence inventory; behavioral review pending |
| [Disconnect Packet Fix](notes/disconnect-packet-fix.md) | `2.3.0-fabric` | Behavioral static review |
| [ExploitPreventer](notes/exploitpreventer.md) | `1.2.1+26.3` | Evidence inventory; behavioral review pending |
| [Smart Particles](notes/smart-particles.md) | `1.16.0` | Evidence inventory; behavioral review pending |
| [Better Render Distance](notes/better-render-distance.md) | `1.2.2` | Evidence inventory; behavioral review pending |
| [钠-汉化模组（Sodium Chinese Localization Mod）](notes/mc1.16.5-sodium-chinese-localization-pack.md) | `5.6.7` | Evidence inventory; behavioral review pending |
| [Borderless Windowed Vulkan](notes/borderless-windowed-vulkan.md) | `26.3` | Evidence inventory; behavioral review pending |
| [Client Kits](notes/client-kits.md) | `2.1.0+26.3` | Evidence inventory; behavioral review pending |
| [Lightweight Inventory Sorting](notes/lightweight-inventory-sorting.md) | `1.1.7+26.3` | Evidence inventory; behavioral review pending |
| [Screenshot Compression](notes/screenshot-compression.md) | `26.3.0-1.4-fabric+forge+neo` | Evidence inventory; behavioral review pending |
| [Elytra/Chestplate Swapper](notes/elytra-chestplate-swapper.md) | `2.1.0+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Mob Collision Off](notes/mob-collision-off.md) | `3.0` | Behavioral static review |
| [Fast Surface](notes/zfastsurface.md) | `1.0.0+26.3` | Evidence inventory; behavioral review pending |
| [Custom Block Highlight (Outline / Overlay)](notes/custom-block-highlight.md) | `2.92+26.3` | Evidence inventory; behavioral review pending |
| [AudioThrottle](notes/audiothrottle.md) | `1.0.1` | Behavioral static review |
| [Black Bar Concealer](notes/black-bar-concealer.md) | `1.0.10` | Evidence inventory; behavioral review pending |
| [Disable Fog](notes/disable-fog.md) | `2.2.1` | Evidence inventory; behavioral review pending |
| [Sound Culling](notes/sound-culling.md) | `2.1.0` | Evidence inventory; behavioral review pending |
| [Cull Fewer Leaves](notes/cull-fewer-leaves.md) | `1.1.2` | Evidence inventory; behavioral review pending |
| [Jauml](notes/jauml.md) | `2.3.1+fabric-26.3` | Evidence inventory; behavioral review pending |
| [Audio Engine Tweaks](notes/audio-engine-tweaks.md) | `1.2.16` | Evidence inventory; behavioral review pending |
| [Resource Gamma Util / Fullbright](notes/resource-gamma-utils.md) | `26.3-2.0.3` | Evidence inventory; behavioral review pending |
| [Hide Item Frame](notes/hide-item-frame.md) | `1.5.2-fabric+26.3` | Evidence inventory; behavioral review pending |
| [ServerAddressSpaceFix](notes/serveraddressspacefix.md) | `0.2.5` | Evidence inventory; behavioral review pending |
| [InventoryTweak](notes/inventorytweak.md) | `4.2` | Evidence inventory; behavioral review pending |
| [Toggle Nametags](notes/hidetags.md) | `2.7.9+26.3` | Evidence inventory; behavioral review pending |
| [RecipeCooldown](notes/recipecooldown.md) | `1.1.0+26.2` | Behavioral static review |
| [Clean View](notes/cleanview-particles.md) | `1.0.6-26.3` | Evidence inventory; behavioral review pending |
| [Material Rule Compiler](notes/zmaterial-rule-compiler.md) | `1.1.2+26.3` | Evidence inventory; behavioral review pending |
| [Rebind Quick Swap](notes/rebind-quick-swap.md) | `2.1.0+26.3` | Evidence inventory; behavioral review pending |
| [Shut Up Dead Entities](notes/shut-up-dead-entities.md) | `1.3.1` | Evidence inventory; behavioral review pending |
| [Better Narrator Error](notes/better-narrator-error.md) | `1.0.0` | Behavioral static review |
| [Rabbit Pathfinding Fixed](notes/rabbit-pathfinding-fix.md) | `1.5.0` | Evidence inventory; behavioral review pending |
| [Chunk Pregenerator](notes/chunk-pregenerator.md) | `1.1-mod` | Evidence inventory; behavioral review pending |
| [Not Enough FPS](notes/not-enough-framerate.md) | `26.3-1.1.1` | Evidence inventory; behavioral review pending |
| [The NoFog Mod](notes/the-nofog-mod.md) | `1.0` | Evidence inventory; behavioral review pending |
| [Simple AutoPickup](notes/simple-autopickup.md) | `1.4.17+26.3` | Evidence inventory; behavioral review pending |
| [Chunky Offline](notes/chunky-offline.md) | `v1.1.0+mod` | Evidence inventory; behavioral review pending |
| [Infinite Night Vision](notes/night-vision-datapack.md) | `1.0.0-mod` | Evidence inventory; behavioral review pending |
| [Double Hotbar](notes/double-hotbar.md) | `1.3.4-mc26.3-fabric` | Evidence inventory; behavioral review pending |
| [SettingsManagerLib](notes/settingsmanagerlib.md) | `1.1.3+26.3` | Evidence inventory; behavioral review pending |
| [NoSignGUI](notes/disablesigngui.md) | `4.2.0+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Clean View](notes/cleanview-2.0.md) | `1.0.9` | Evidence inventory; behavioral review pending |
| [Just Enough Book](notes/justenoughbook.md) | `1.1.1-26.3` | Evidence inventory; behavioral review pending |
| [Better Place Bind](notes/better-place-bind.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [Eslium](notes/eslium.md) | `4.6.0` | Evidence inventory; behavioral review pending |
| [LazyAI](notes/lazyai.md) | `1.7.1` | Evidence inventory; behavioral review pending |
| [SmoothTextureFix](notes/smoothtexturefix.md) | `1.0.0+26.3` | Behavioral static review |
| [FixMCStats](notes/fixmcstats.md) | `fabric-2.5.0` | Evidence inventory; behavioral review pending |
| [Disable Portal Checks](notes/disable-portal-checks.md) | `1.0.0` | Behavioral static review |
| [Fishing Rod Fix](notes/fishing-rod-fix.md) | `26.3-v0.6` | Evidence inventory; behavioral review pending |
| [Tick Sync](notes/tick-sync.md) | `1.4.0` | Evidence inventory; behavioral review pending |
| [ Client Side Noteblocks](notes/clientsidenoteblocks.md) | `2.14` | Evidence inventory; behavioral review pending |
| [Vanilla+ TPS](notes/vtps.md) | `2.8.4.3` | Evidence inventory; behavioral review pending |
| [Random Death Drop](notes/random-death-drop.md) | `fabric` | Evidence inventory; behavioral review pending |
| [Vignette Tweaks](notes/vignettetweaks.md) | `2.1.0+26.3` | Evidence inventory; behavioral review pending |
| [DawnGuiReader](notes/dawnguireader.md) | `1.3.0+mc26.3` | Evidence inventory; behavioral review pending |
| [Iris Extension](notes/iris-extension.md) | `1.0.3+26.3` | Evidence inventory; behavioral review pending |
| [LightAura](notes/lightaura.md) | `8.9.7` | Evidence inventory; behavioral review pending |
| [Nondirectional Damage Tilt Fix](notes/nondirectionaldamagetiltfix.md) | `3.0.0` | Evidence inventory; behavioral review pending |
| [CraftSense](notes/craftsense.md) | `2.0.0` | Evidence inventory; behavioral review pending |
| [Flashback Extras](notes/flashback-extras.md) | `1.3.0` | Evidence inventory; behavioral review pending |
| [Optimized Fullbright](notes/optimized-fullbright.md) | `2.0.0+26.2-fabric` | Evidence inventory; behavioral review pending |
| [Slumber](notes/slumber.md) | `mc26.2-2.0.0` | Evidence inventory; behavioral review pending |
| [Whiteout](notes/whiteout.md) | `0.21.0` | Evidence inventory; behavioral review pending |
| [Smooth Join](notes/smooth-join.md) | `1.3.2` | Behavioral static review |
| [Enhanced Celestials 2: Shader Support](notes/enhanced-celestials-2-shader-support.md) | `5.0.0.0-fabric` | Evidence inventory; behavioral review pending |
| [Locator Bar](notes/reworked-locator-bar.md) | `1.2.4+26.3.x-fabric` | Evidence inventory; behavioral review pending |
| [Stonecutter GUI Remastered](notes/stonecutter-gui-remastered.md) | `2.1.1-1.26.3` | Evidence inventory; behavioral review pending |
| [I DON'T WANNA SCROLL AGAIN!](notes/idontwannascrollagain.md) | `1.0.0+26.3` | Evidence inventory; behavioral review pending |
| [Motion Blur](notes/afkz-motion-blur.md) | `1.0-release` | Evidence inventory; behavioral review pending |
| [Block Entity Render Distance](notes/block-entity-rd.md) | `1.0.0` | Behavioral static review |
| [Not Enough Pots](notes/not-enough-pots.md) | `1.5.1` | Evidence inventory; behavioral review pending |
| [KastSize — Aspect Ratio Stretch](notes/kastsize-aspect-ratio-stretch.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [datapack function library](notes/datapack-function-library.md) | `5.0.0+mod` | Evidence inventory; behavioral review pending |
| [Helpful Commands](notes/helpful-commands.md) | `4.2.3` | Evidence inventory; behavioral review pending |
| [Better Resolution](notes/better-resolution.md) | `1.1.0` | Evidence inventory; behavioral review pending |
| ["Limitless" Banners](notes/limitless-banners.md) | `1.4.0` | Evidence inventory; behavioral review pending |
| [WindowFix](notes/window-fix.md) | `1.0.1` | Behavioral static review |
| [FPS-Sync (FPS Limiter)](notes/fps-sync.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [No More Pop-ups](notes/no-more-popups.md) | `2.3.1` | Evidence inventory; behavioral review pending |
| [SimpleHUD](notes/simplehud.md) | `2.2` | Evidence inventory; behavioral review pending |
| [NoDynamicFps](notes/nodynamicfps.md) | `1.1.0+26.2` | Behavioral static review |
| [Serverlist Fix](notes/serverlist-fix.md) | `1.0.2` | Behavioral static review |
| [Nemo's Mending](notes/nemos-mending.md) | `26.3-1.1.2` | Evidence inventory; behavioral review pending |
| [Simple-Warp-Tpa-Home-Back](notes/ziy-swthb.md) | `1.3` | Evidence inventory; behavioral review pending |
| [Fast Recipe](notes/fast-recipe.md) | `1.0.3+26.3+fabric` | Evidence inventory; behavioral review pending |
| [OptiLeaves(Fabric)](notes/optileaves-fabric.md) | `2.0.1` | Evidence inventory; behavioral review pending |
| [Maps of the Unknown](notes/bettermaps.md) | `0.9.1-26.2` | Evidence inventory; behavioral review pending |
| [CarpetGUI](notes/carpetgui.md) | `2.0.0+26.3` | Evidence inventory; behavioral review pending |
| [String Duper](notes/string-dupe.md) | `1.0.3` | Evidence inventory; behavioral review pending |
| [HUD - FPS Veltium](notes/veltium.md) | `0.1.22+26.3` | Evidence inventory; behavioral review pending |
| [Free Cursor](notes/free-cursor.md) | `1.3.1+mc26.3` | Evidence inventory; behavioral review pending |
| [Worldthreader](notes/worldthreader.md) | `mc26.3-3.2.0-fabric` | Evidence inventory; behavioral review pending |
| [Reload Server List](notes/reload-server-list.md) | `2.0` | Evidence inventory; behavioral review pending |
| [KeybindsGalore (HVB007)](notes/keybindsgalore-plus-hvb007.md) | `1.8.0` | Evidence inventory; behavioral review pending |
| [Name Tag (Craft & Drops)](notes/name-tag.md) | `v2.2.0.0+mod` | Evidence inventory; behavioral review pending |
| [Sulkan](notes/sulkan.md) | `0.5.1` | Evidence inventory; behavioral review pending |
| [NeoToolTipFix](notes/neotooltipfix.md) | `1.2.1-26.3` | Evidence inventory; behavioral review pending |
| [GGTU](notes/ggtu.md) | `Neo-1.1.2+mc26.3` | Evidence inventory; behavioral review pending |
| [veinminer++](notes/veinminer-plus-plus.md) | `0.6.0+mc26.3` | Evidence inventory; behavioral review pending |
| [PackForge - Optimized Resource Pack Loading Time](notes/packforge.md) | `1.4.1` | Evidence inventory; behavioral review pending |
| [Async Hotbars](notes/hotbar-lag-fixer.md) | `1.1.1` | Behavioral static review |
| [Inventory Item Groups](notes/inventory-item-groups.md) | `1.5.3-fabric+26.3` | Evidence inventory; behavioral review pending |
| [inputbooster](notes/inputbooster.md) | `4.0.0-fabric-mc263` | Evidence inventory; behavioral review pending |
| [Disable Narrator](notes/disable-narrator.md) | `1.0.0` | Behavioral static review |
| [First Steps](notes/first-step-mod.md) | `2.30` | Evidence inventory; behavioral review pending |
| [Resource Trimmer](notes/resource-trimmer.md) | `26.3.0.1` | Behavioral static review |
| [Panda Anti-Lag](notes/pandaantilag.md) | `2.3.0+26.3` | Evidence inventory; behavioral review pending |
| [Breaking Place](notes/breaking-place.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [Auto Eater](notes/auto-eater.md) | `1.5.1` | Evidence inventory; behavioral review pending |
| [XP Stream](notes/xp-stream.md) | `1.1.8` | Evidence inventory; behavioral review pending |
| [Call Your Cat](notes/call-your-cat.md) | `v2.2.0.0+mod` | Evidence inventory; behavioral review pending |
| [!lag](notes/lag.md) | `3.0.0` | Evidence inventory; behavioral review pending |
| [Shulker & Bundle](notes/shulker-bundle.md) | `1.7` | Evidence inventory; behavioral review pending |
| [PackTest](notes/packtest.md) | `2.7.0` | Evidence inventory; behavioral review pending |
| [Cerulean Fork](notes/cerulean-fork.md) | `1.0.1` | Evidence inventory; behavioral review pending |
| [Far Block Entity Rendering](notes/farblockentityrendering.md) | `2.1+26.3` | Evidence inventory; behavioral review pending |
| [FastChest Update](notes/fastchest-update.md) | `1.10+26.3` | Behavioral static review |
| [NumFlux](notes/numflux.md) | `1.0.6-26.3-fabric` | Evidence inventory; behavioral review pending |
| [Auto Sprint Fix](notes/sprint-fix.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [Explodee](notes/explodee.md) | `1.1+26.1-26.3-fabric` | Evidence inventory; behavioral review pending |
| [Better Hitbox](notes/better-hitbox.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [Keybind Bug Fixes](notes/keybindbugfixes.md) | `1.6.0` | Evidence inventory; behavioral review pending |
| [Optimized Cushions](notes/optimized-cushions.md) | `1.2.0` | Evidence inventory; behavioral review pending |
| [HCsCR](notes/hcscr.md) | `2.1.13+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Generator](notes/chunk_gen.md) | `12+mod` | Evidence inventory; behavioral review pending |
| [Purescale](notes/purescale.md) | `1.2.1` | Evidence inventory; behavioral review pending |
| [MTSAntiCheat](notes/anticheatmts.md) | `0.1.0+26.3` | Evidence inventory; behavioral review pending |
| [Compact F3](notes/compact-f3.md) | `1.3.3` | Evidence inventory; behavioral review pending |
| [Console Spam Fix : Reborn](notes/console-spam-fix-reborn.md) | `2.1.0` | Evidence inventory; behavioral review pending |
| [Yggdrasil Proxy](notes/yggdrasil-proxy.md) | `26.06.1-fabric` | Evidence inventory; behavioral review pending |
| [No Waypoints/Locator Bar](notes/no-way.md) | `1.4.0` | Evidence inventory; behavioral review pending |
| [Disable Lighting](notes/disable-lighting.md) | `1.3.0` | Behavioral static review |
| [Xeno](notes/xeno.md) | `0.1.9` | Evidence inventory; behavioral review pending |
| [cbbg 🥬](notes/cbbg.md) | `1.5.0+mc26.3-fabric` | Evidence inventory; behavioral review pending |
| [AirPlace](notes/airplace.md) | `1.1.1` | Evidence inventory; behavioral review pending |
| [Greedy Meshing Mod](notes/greedy-meshing-mod.md) | `0.6.1+26.3` | Evidence inventory; behavioral review pending |
| [Boosters](notes/boosters.md) | `1.3.4.1-hotfix` | Evidence inventory; behavioral review pending |
| [Entity Stack Rendering](notes/entity-stack-rendering.md) | `1.2` | Evidence inventory; behavioral review pending |
| [Simple Keybinds](notes/simple-keybinds.md) | `1.4.7` | Evidence inventory; behavioral review pending |
| [Fast Leaf Decay](notes/fast_leaf_decay.md) | `2.0.1+mod` | Evidence inventory; behavioral review pending |
| [Log Cleaner Multi Loader](notes/log-cleaner-multiloader.md) | `2.0.0` | Evidence inventory; behavioral review pending |
| [PulseNet](notes/pulsenet.md) | `1.1.0+26.3` | Evidence inventory; behavioral review pending |
| [SeamlessChunks](notes/schunks.md) | `0.1.0-beta.7+26.3-fabric` | Evidence inventory; behavioral review pending |
| [ServerPingFixer](notes/pingfixer.md) | `1.0.2+26.1-26.3` | Behavioral static review |
| [Decent Freelook](notes/decentfreelook.md) | `1.3+26.3` | Evidence inventory; behavioral review pending |
| [ServerLens](notes/serverlens.md) | `2.1.0` | Evidence inventory; behavioral review pending |
| [Panda TNT Fusion](notes/pandatntfusion.md) | `1.0.0+26.3` | Evidence inventory; behavioral review pending |
| [Optis](notes/optis.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [fweigel-util-lib](notes/fweigel-util-lib.md) | `1.7.0` | Evidence inventory; behavioral review pending |
| [config-editor-render](notes/config-editor.md) | `1.1.11+26.3` | Evidence inventory; behavioral review pending |
| [Improved F3](notes/improvedf3.md) | `2.0.1+26.3` | Evidence inventory; behavioral review pending |
| [Better Auto Totem](notes/better-auto-totem.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [MacOS Input Fixes (Neoforged)](notes/mac-input-fixes-neoforged.md) | `26.10.03-p` | Evidence inventory; behavioral review pending |
| [Xaero's Optimal Beacons Add-On](notes/xaeros-optimal-beacons-add-on.md) | `1.3.0` | Evidence inventory; behavioral review pending |
| [FramePacer](notes/framepacer.md) | `1.2.1` | Behavioral static review |
| [Better Left Click](notes/better-left-click.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [OneHitTreeChopper](notes/onehittreechopper.md) | `3.0.1` | Evidence inventory; behavioral review pending |
| [Meow Anti-Xray](notes/meowanti-xray.md) | `1.7.0+mc26.3.fabric` | Evidence inventory; behavioral review pending |
| [ShopShelves](notes/shopshelves.md) | `1.0.14` | Evidence inventory; behavioral review pending |
| [WhereWaterGo (Bigger Sponge)](notes/wwg.md) | `2.1.2-1.26.3` | Evidence inventory; behavioral review pending |
| [FastLeafDecay](notes/fastleafdecay.md) | `2.0.0` | Evidence inventory; behavioral review pending |
| [GeyserFixes](notes/geyserfixes.md) | `1.1.1` | Evidence inventory; behavioral review pending |
| [Dynamic Performance](notes/dynamic-performance.md) | `0.2.0+26.1-fabric` | Evidence inventory; behavioral review pending |
| [AntiFirmament](notes/antifirmament.md) | `1.0.3` | Evidence inventory; behavioral review pending |
| [IG: Item Clumps](notes/ig-item-clumps.md) | `1.0.29+26.3` | Evidence inventory; behavioral review pending |
| [Better Trialchamber Loot](notes/better-trialchamber-loot.md) | `26.3` | Evidence inventory; behavioral review pending |
| [Harvest Simplified](notes/harvest-simplified.md) | `1.1+mod` | Evidence inventory; behavioral review pending |
| [Rhenium](notes/rhenium-mod.md) | `1.2.1` | Behavioral static review |
| [AFK Fishing](notes/afkfishing.md) | `26.3` | Evidence inventory; behavioral review pending |
| [Crafting Tweaks](notes/craftingtweaks.md) | `1.8+mod` | Evidence inventory; behavioral review pending |
| [Careful Break](notes/careful-break.md) | `1.3.1` | Evidence inventory; behavioral review pending |
| [VulkanCompat](notes/vulkancompat.md) | `1.2-mc26.3` | Evidence inventory; behavioral review pending |
| [Scalable](notes/downloadableduck-scalable.md) | `1.0.5-26.2` | Evidence inventory; behavioral review pending |
| [XtremeUtilities](notes/xtremeutilities.md) | `1.0.5` | Evidence inventory; behavioral review pending |
| [SooperDooperScooper](notes/sooperdooperscooper.md) | `1.4.1+26.3` | Evidence inventory; behavioral review pending |
| [Lite FPS](notes/lite-fps-patrolin.md) | `1.0.0` | Behavioral static review |
| [SmoothMenu Reloaded](notes/smoothmenu.md) | `26.3-1.0.0` | Behavioral static review |
| [STFU Disconnect](notes/stfudisconnect.md) | `4.0.0` | Behavioral static review |
| [more gunpowder (creeper)](notes/more-gunpowder-creeper.md) | `26.3+mod` | Evidence inventory; behavioral review pending |
| [Meshelium](notes/meshelium.md) | `1.6.2+mc26.3` | Evidence inventory; behavioral review pending |
| [MeowConsole](notes/meowconsole.md) | `1.5.0+mc26.3` | Evidence inventory; behavioral review pending |
| [expRepair](notes/exprepair.md) | `1.9.5` | Evidence inventory; behavioral review pending |
| [Bypass Fabric Check](notes/bypass-fabric-check.md) | `1.0.11` | Evidence inventory; behavioral review pending |
| [ClickOptimizer](notes/clickoptimizer.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [Craftables](notes/craftables-datapack.md) | `1.16-26.3+mod` | Evidence inventory; behavioral review pending |
| [Antideath-Carpet-addition](notes/antideath-carpet-addition.md) | `v1.6.0-mc26.3` | Evidence inventory; behavioral review pending |
| [Prefer OpenGL](notes/preferopengl.md) | `fabric-26.2-v1.0.0` | Behavioral static review |
| [Client-side Custom Music Disc Fix](notes/client-side-custom-music-disc-fix.md) | `1.1.6+26.3` | Evidence inventory; behavioral review pending |
| [FluidCam](notes/fluidcam.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [No Void](notes/novoid.md) | `0.1.1+mod` | Evidence inventory; behavioral review pending |
| [Woodcutter](notes/woodworking.md) | `1.2+mod` | Evidence inventory; behavioral review pending |
| [No Piglin Brutes](notes/no-piglinbrutes.md) | `1+mod` | Evidence inventory; behavioral review pending |
| [Hibernate Fabric](notes/hibernate-fabric.md) | `1.2.1+mc26.3` | Evidence inventory; behavioral review pending |
| [Elytra Slot](notes/elytra-slot-cafekad.md) | `1.1.0` | Evidence inventory; behavioral review pending |
| [No More Explosions](notes/no-more-explosions.md) | `0.1.2+mod` | Evidence inventory; behavioral review pending |
| [A* Pathfinding](notes/a-star-pathfinding.md) | `0.7.3+mod` | Evidence inventory; behavioral review pending |
| [Bring Blocking Back](notes/bring-blocking-back.md) | `2.3.0-26.3` | Evidence inventory; behavioral review pending |
| [ParaMax](notes/paramax.md) | `v1.3.1+26.3` | Evidence inventory; behavioral review pending |
| [Stop Pause My Music](notes/stop_pause_my_music.md) | `1.0-26.3` | Evidence inventory; behavioral review pending |
| [Deobfuscator](notes/deobfuscator.md) | `1.0.0+26.3` | Evidence inventory; behavioral review pending |
| [Carpet ROF Addition](notes/carpet-rof-addition.md) | `1.6.1` | Evidence inventory; behavioral review pending |
| [Item Blocker](notes/item-blocker.md) | `1.6+26.3` | Evidence inventory; behavioral review pending |
| [Baby Mob Fix](notes/babymodfix.md) | `1.1.5` | Evidence inventory; behavioral review pending |
| [Visually Waxed Golems](notes/visually-waxed-golems.md) | `1.0.1+mod` | Evidence inventory; behavioral review pending |
| [Cast Away](notes/castaway.md) | `3.0.2` | Evidence inventory; behavioral review pending |
| [Escape from the Void with Totem of Undying](notes/escape-from-the-void-with-totem-of-undying.md) | `1.07` | Evidence inventory; behavioral review pending |
| [No More Narrator](notes/nomorenarrator.md) | `26.3-1.1` | Behavioral static review |
| [Glow Squid Spawn Fix](notes/glowsquidspawnfix.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [Corpanion](notes/corpanion.md) | `1.19.0` | Evidence inventory; behavioral review pending |
| [Hot-Reload Resource Packs Forked](notes/hot-reload-resource-packs-forked.md) | `1.2.0` | Evidence inventory; behavioral review pending |
| [WhatIsInThatShelf](notes/wiits.md) | `1.0.1` | Evidence inventory; behavioral review pending |
| [No Invalid Session ID](notes/no-invalid-session-id.md) | `3.1.0` | Evidence inventory; behavioral review pending |
| [AntiFreeze](notes/anti-freeze.md) | `1.1.0` | Evidence inventory; behavioral review pending |
| [Thiepine](notes/thiepine.md) | `1.1.1+mc26.3` | Behavioral static review |
| [Xaero's Biome Filter](notes/xaeros-biome-filter.md) | `1.1.2+26.3` | Evidence inventory; behavioral review pending |
| [ScreenshotMetadata](notes/screenshotmetadata.md) | `1.4.2` | Evidence inventory; behavioral review pending |
| [F3 ADVANCE](notes/f3-advance.md) | `0.1.1+mc26.3` | Evidence inventory; behavioral review pending |
| [Map Rendering Disabler](notes/map-rendering-disabler.md) | `1.0.0+26.1` | Behavioral static review |
| [TradeHall Villager/Farm Optimizer](notes/tradehall-villagers-optimizer.md) | `1.1.0` | Evidence inventory; behavioral review pending |
| [Stronghold Finder (One Eye Updated)](notes/stronghold-finder-one-eye.md) | `1.1+26.3` | Evidence inventory; behavioral review pending |
| [Item Name Gradients](notes/item-name-gradients.md) | `1.0.2` | Evidence inventory; behavioral review pending |
| [Enttick](notes/enttick.md) | `0.2.0` | Evidence inventory; behavioral review pending |
| [Optional Pickup](notes/optional-pickup.md) | `0.1.5-mc26.3` | Evidence inventory; behavioral review pending |
| [LCull](notes/lcull.md) | `mc26.3-1.1.0-fabric` | Evidence inventory; behavioral review pending |
| [Fontrast](notes/fontrast.md) | `1.1.1` | Evidence inventory; behavioral review pending |
| [Command Profiler](notes/command-profiler.md) | `1.4.1+26.3-pre.2` | Evidence inventory; behavioral review pending |
| [Craftable Cobwebs](notes/craftablecobwebs.md) | `1.0.1-1.21.9-26.3+mod` | Evidence inventory; behavioral review pending |
| [Minecraft Custom Day/Night Mod](notes/minecraft-custom-daynight-mod.md) | `2.2.0` | Evidence inventory; behavioral review pending |
| [Mod That Closes The Game When It Opens](notes/modthatclosesthegamewhenitopens.md) | `1.0.0` | Behavioral static review |
| [PinChat](notes/pinchat.md) | `3.2.0-fabric-mc26.3` | Evidence inventory; behavioral review pending |
| [macOS Chat Fixes](notes/macos-chat-fixes.md) | `1.0.1` | Evidence inventory; behavioral review pending |
| [Bellows](notes/smithed-bellows.md) | `1.1.1` | Evidence inventory; behavioral review pending |
| [PathWeaver](notes/pathweaver.md) | `0.9.0+26.3` | Evidence inventory; behavioral review pending |
| [Environmental Fog Disable](notes/environmental-fog-disable.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [Polypheides Resolution Scaler](notes/polypheides-resolution-scaler.md) | `1.2.3+mc26.3` | Evidence inventory; behavioral review pending |
| [FastMapCodec](notes/fastmapcodec.md) | `1.0.4` | Behavioral static review |
| [Client Movement](notes/client-movement.md) | `1.1` | Behavioral static review |
| [Better Stacking](notes/better-stacking.md) | `26.3-1.0.0-beta1` | Evidence inventory; behavioral review pending |
| [Cave Mushroom Fix](notes/cavemushroomfix.md) | `1.0.0` | Evidence inventory; behavioral review pending |
| [QuickTrigger](notes/quicktrigger.md) | `1.3.0` | Evidence inventory; behavioral review pending |
| [Eternal FPS](notes/eternal-fps.md) | `4.0.0` | Evidence inventory; behavioral review pending |
| [Potato3D](notes/potato3d.md) | `1.2.0+26.3` | Evidence inventory; behavioral review pending |
| [Lower Shelves](notes/lower-shelves.md) | `1.0.7` | Evidence inventory; behavioral review pending |
| [DripStone Recipe FIX](notes/dripstonerecipefix.md) | `1.2.0+mod` | Evidence inventory; behavioral review pending |
| [Non Persistent Wither Skulls](notes/non-persistent-wither-skulls.md) | `1.0.3-mc-26.3` | Behavioral static review |
| [AutoMuteOnAfk](notes/automuteonafk.md) | `1.1.0` | Evidence inventory; behavioral review pending |
| [Cull Display Entities](notes/cull-display-entities.md) | `1.3.0` | Behavioral static review |
| [Better Clock](notes/betterclock.md) | `1.1.0+26.3` | Evidence inventory; behavioral review pending |
| [Basic Macros](notes/auto-keybinds.md) | `0.0.3` | Evidence inventory; behavioral review pending |
| [Objectively](notes/objectively.md) | `1.0.5` | Evidence inventory; behavioral review pending |
| [Blindspot](notes/blindspot.md) | `0.3.0` | Evidence inventory; behavioral review pending |
| [FastOrbs](notes/fastorbs.md) | `1.0-SNAPSHOT` | Behavioral static review |
| [Mascom (Mass Commands)](notes/mascom.md) | `m1.0+` | Evidence inventory; behavioral review pending |
| [AnvilOrder](notes/anvilorder.md) | `26.3` | Evidence inventory; behavioral review pending |
| [Distant Decorations](notes/distant-decorations.md) | `2.0.0` | Evidence inventory; behavioral review pending |
| [Really Fast Paintings](notes/really-fast-paintings.md) | `2.0.0` | Evidence inventory; behavioral review pending |
| [Zoom Extended](notes/zoom-extended.md) | `1.3.3` | Evidence inventory; behavioral review pending |
| [Disable Spawner Mob Spawns](notes/disable-spawner-mob-spawns.md) | `1+mod` | Evidence inventory; behavioral review pending |
| [VectorX](notes/vectorx.md) | `0.2.0` | Evidence inventory; behavioral review pending |
| [Lobotomy Inc.](notes/lobotomy-inc..md) | `1.5.0+26.3` | Evidence inventory; behavioral review pending |
| [Fix MC-139908](notes/fix_mc-139908.md) | `1.0_4_26.2` | Evidence inventory; behavioral review pending |
| [Crafting Refinements: Blast Buff](notes/crafting-refinements-blast-buff.md) | `5.0+mod` | Evidence inventory; behavioral review pending |
| [Miner's Dreams](notes/miners-dreams.md) | `1.0.1` | Evidence inventory; behavioral review pending |
| [Nimbus 2000](notes/nimbus-2000.md) | `1.0.2` | Evidence inventory; behavioral review pending |
| [(ST) Locator Radar](notes/st-locator-bar.md) | `1.3+mod` | Evidence inventory; behavioral review pending |
| [Forced Render Distance](notes/forced-render-distance.md) | `v1.0+mod` | Evidence inventory; behavioral review pending |
| [Alot Of Enchants -- 300+](notes/alot-of-enchants-300.md) | `1+mod` | Evidence inventory; behavioral review pending |
| [VO: Camera Culling](notes/vo-camera-culling.md) | `1.0.0+26.3` | Evidence inventory; behavioral review pending |
| [Hide Models](notes/hide-models.md) | `mc26.1-26.3-2.1.0-fabric` | Evidence inventory; behavioral review pending |
| [NotEnoughPalette](notes/notenoughpalette.md) | `0.3.0` | Evidence inventory; behavioral review pending |
| [Do I Reload?](notes/do-i-reload.md) | `1.1` | Behavioral static review |
| [Instant Arrow Despawn](notes/instant-arrow-despawn.md) | `v1.0+mod` | Evidence inventory; behavioral review pending |
| [OFFHand KeyBind](notes/offhand-keybind.md) | `2.0.0` | Evidence inventory; behavioral review pending |
| [Get my blocks back](notes/get-my-blocks-back.md) | `1.0.0+mc26.1-26.3` | Evidence inventory; behavioral review pending |
| [Clientify](notes/clientify.md) | `1.0.2+26.3` | Evidence inventory; behavioral review pending |
| [Fallback](notes/fallback.md) | `1.3.0-beta.2` | Evidence inventory; behavioral review pending |
| [YugiTotem](notes/yugitotem.md) | `1.3.0` | Evidence inventory; behavioral review pending |
| [Krypton](notes/krypton.md) | `0.3.2` | Evidence inventory; behavioral review pending |
| [Debugify](notes/debugify.md) | `26.3.0.0` | Evidence inventory; behavioral review pending |
| [Fast Noise](notes/zfastnoise.md) | `1.1.1+26.3` | Evidence inventory; behavioral review pending |
| [Distant Horizons](notes/distanthorizons.md) | `3.3.4-26.3` | Artifact unavailable; implementation not verified |
| [AsyncParticles](notes/asyncparticles.md) | `26.3.2.0-alpha.2` | Evidence inventory; behavioral review pending |
| [Very Many Players (Fabric)](notes/vmp-fabric.md) | `0.2.0+beta.7.238+26.3` | Artifact unavailable; implementation not verified |
| [FPS Reducer](notes/fps-reducer.md) | `26.3-2.18` | Evidence inventory; behavioral review pending |
| [Fast Item Frames](notes/fast-item-frames.md) | `26.3.0` | Evidence inventory; behavioral review pending |
| [Iris Shaders](notes/iris.md) | `1.11.7+26.3-fabric` | Artifact unavailable; implementation not verified |
| [Better Clouds](notes/better-clouds.md) | `1.15.0-beta.3` | Evidence inventory; behavioral review pending |
| [Ixeris](notes/ixeris.md) | `4.6.8+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Borderless Fullscreen](notes/borderless-fullscreen.md) | `2.5.1-26.3` | Artifact unavailable; implementation not verified |
| [Entity View Distance](notes/entity-view-distance.md) | `1.9.0+26.2` | Evidence inventory; behavioral review pending |
| [Boat Item View](notes/boat-item-view.md) | `26.3-0.0.10-fabric` | Artifact unavailable; implementation not verified |
| [CrashExploitFixer](notes/crashexploitfixer.md) | `fabric-2.0.0+26.3` | Artifact unavailable; implementation not verified |
| [Async Logger](notes/asynclogger.md) | `2.2.2+26.1.2-fabric` | Evidence inventory; behavioral review pending |
| [Improved Pillager Outpost](notes/improved-pillager-outpost.md) | `7` | Artifact unavailable; implementation not verified |
| [Sodium](notes/sodium.md) | `mc26.3-0.9.2-fabric` | Artifact unavailable; implementation not verified |
| [Fast Server Pings](notes/fastserverpings.md) | `1.1.5+26.3` | Evidence inventory; behavioral review pending |
| [Podium](notes/podium.md) | `1.1.1` | Evidence inventory; behavioral review pending |
| [Feather remake](notes/feather-remake.md) | `1.4.0` | Artifact unavailable; implementation not verified |
| [ModernFix-mVUS](notes/modernfix-mvus.md) | `5.27.20-build.2` | Evidence inventory; behavioral review pending |
| [Server Resourcepack Checker](notes/server-resource-pack-checker.md) | `fabric-1.2.2+26.3` | Evidence inventory; behavioral review pending |
| [Voxy Server Side](notes/voxy-server-side.md) | `0.18.0` | Artifact unavailable; implementation not verified |
| [Async](notes/async.md) | `0.2.5+alpha-26.3` | Artifact unavailable; implementation not verified |
| [Pearl Optimizer](notes/pearl_optimizer.md) | `26.3` | Evidence inventory; behavioral review pending |
| [Super Resolution](notes/superresolution.md) | `26.3-0.9.2-alpha.2+gl-fabric` | Artifact unavailable; implementation not verified |
| [Better Capes](notes/better-capes.md) | `1.6.2` | Artifact unavailable; implementation not verified |
| [Put A Plug In it! (PAPI)](notes/put-a-plug-in-it.md) | `fabric-26.3-1.3.0` | Evidence inventory; behavioral review pending |
| [Moonrise](notes/moonrise-opt.md) | `1.2.0+61c1328` | Artifact unavailable; implementation not verified |
| [Entity Culling](notes/entityculling.md) | `1.11.3` | Evidence inventory; behavioral review pending |
| [Crash Assistant](notes/crash-assistant.md) | `1.11.14` | Artifact unavailable; implementation not verified |
| [Better Client](notes/better-client-enc.md) | `11.0.2+fabric` | Artifact unavailable; implementation not verified |
| [Jasione](notes/jasione.md) | `1.0.9+26.1.2-fabric` | Evidence inventory; behavioral review pending |
| [Adaptive Performance Tweaks](notes/adaptive-performance-tweaks.md) | `12.10.0` | Artifact unavailable; implementation not verified |
| [Sodium/Embeddium Device Check 钠/铷-设备检测](notes/sodium-device-check.md) | `6.0.0` | Evidence inventory; behavioral review pending |
| [Concurrent Chunk Management Engine (Fabric)](notes/c2me-fabric.md) | `0.4.2-alpha.0.103+26.3` | Artifact unavailable; implementation not verified |
| [Unloaded Activity](notes/unloaded-activity.md) | `0.7.3+26.3` | Evidence inventory; behavioral review pending |
| [Silly's Auto Totem](notes/sillys-auto-totem.md) | `2.3.6` | Evidence inventory; behavioral review pending |
| [Distant Horizons SeedGen](notes/distant-horizons-seedgen.md) | `0.9.1` | Artifact unavailable; implementation not verified |
| [Mercurizer](notes/mercurizer.md) | `0.9.2+mc26.3-1.1` | Evidence inventory; behavioral review pending |
| [Accelerated Recoiling](notes/accelerated-recoiling.md) | `26.3.0-fabric` | Evidence inventory; behavioral review pending |
| [Potatoptimize](notes/potatoptimize.md) | `mc26.2-2.2.2` | Evidence inventory; behavioral review pending |
| [Animal Pens](notes/animalpens.md) | `2.5.1-26.3` | Evidence inventory; behavioral review pending |
| [Opticores](notes/opticores.md) | `v1.1.1.5+26.x` | Artifact unavailable; implementation not verified |
| [Signs Faster](notes/sf-plus.md) | `1.0.3` | Artifact unavailable; implementation not verified |
| [Carpet AMS Addition](notes/carpet-ams-addition.md) | `mc26.3-v26.4-beta.2` | Evidence inventory; behavioral review pending |
| [Axis World Editor](notes/axis.md) | `0.6.1-mod` | Artifact unavailable; implementation not verified |
| [Stacks Are Stacks](notes/stacks-are-stacks.md) | `2.1.5-1.26.3` | Evidence inventory; behavioral review pending |
| [SmoothPlayerAnimations](notes/smoothplayeranimations.md) | `1.1.0+26.3` | Evidence inventory; behavioral review pending |
| [OverpoweredMending](notes/overpoweredmending.md) | `26.3-26.3.0.2` | Evidence inventory; behavioral review pending |
| [LOD Server Support](notes/lod-server-support.md) | `v0.18.0+fabric+mc26.3` | Artifact unavailable; implementation not verified |
| [Sodium Leaf Culling Unofficial](notes/sodiumleafculling-unofficial.md) | `3.3.0+mc26.3-fabric` | Evidence inventory; behavioral review pending |
| [Lomka](notes/lomka.md) | `mc26.3-0.7.0-fabric` | Evidence inventory; behavioral review pending |
| [AutoBuild](notes/autobuild.md) | `2.0.1+26.3` | Artifact unavailable; implementation not verified |
| [Cactus Mod](notes/cactus.md) | `0.15.2` | Artifact unavailable; implementation not verified |
| [Enhanced Block Entities Reloaded](notes/ebe-reloaded.md) | `fabric-0.13.1+26.3` | Evidence inventory; behavioral review pending |
| [Full Bright +](notes/fullbright-plus.md) | `1.0.0+26.3` | Artifact unavailable; implementation not verified |
| [Retromod](notes/retromod.md) | `1.3.4+26.3-fabric` | Artifact unavailable; implementation not verified |
| [Quality of Queso](notes/quality-of-queso.md) | `1.7.18` | Artifact unavailable; implementation not verified |
| [Crossbow Optimizer](notes/crossbow-optimizer.md) | `1.1.0+26.3` | Artifact unavailable; implementation not verified |
| [Fuzz](notes/fuzz.md) | `mc26.3-v1.6.14` | Artifact unavailable; implementation not verified |
| [AutoJump Fix](notes/autojump-fix.md) | `1.0.6+26.3+fabric` | Evidence inventory; behavioral review pending |
| [Subtly Dungeons](notes/subtly-dungeons.md) | `5.0.1` | Artifact unavailable; implementation not verified |
| [NoRender+](notes/norender-plus.md) | `1.0.7,26.3` | Evidence inventory; behavioral review pending |
| [Carpet CuO Addition](notes/carpet_cuo_addition.md) | `1.12.0` | Artifact unavailable; implementation not verified |
| [CrashFixer](notes/crashfixer.md) | `3.1.1+26.3` | Evidence inventory; behavioral review pending |
| [Loom GUI Remastered](notes/loom-gui-remastered.md) | `2.1.1-1.26.3` | Evidence inventory; behavioral review pending |
| [Polymer - Quality of Life](notes/polymer-qol.md) | `1.0.3+26.3` | Evidence inventory; behavioral review pending |
| [Am I Up To Date?](notes/aiutd.md) | `2.7.1-fabric+26.3` | Evidence inventory; behavioral review pending |
| [VulkanFlow](notes/vulkanflow.md) | `0.1.12-alpha` | Evidence inventory; behavioral review pending |
| [Client Projectiles](notes/client-projectiles.md) | `1.1.1+26.3` | Artifact unavailable; implementation not verified |
| [Hudder](notes/hudder.md) | `11.0.0-26.3` | Artifact unavailable; implementation not verified |
| [Oxidizium](notes/oxidizium.md) | `mc26.3-1.3.2-panama` | Artifact unavailable; implementation not verified |
| [UUID Hex](notes/uuid-hex.md) | `1.4+mod` | Evidence inventory; behavioral review pending |
| [PerformanceHUD](notes/performancehud.md) | `1.2.0` | Evidence inventory; behavioral review pending |
| [Offline Mode Fix](notes/offline-mode-fix.md) | `1.0.1+26.3` | Evidence inventory; behavioral review pending |
| [Particle Culling](notes/particleculling.md) | `1.0.0+mc26.3` | Evidence inventory; behavioral review pending |
| [DBTools for Axiom](notes/dbtools.md) | `2.3.1+MC26.3-AX6.1.3` | Artifact unavailable; implementation not verified |
| [Better loading screen](notes/better-loading-screen-mod.md) | `1.4.3+26.3` | Artifact unavailable; implementation not verified |
| [FASTJSON2 Serializer for YACL](notes/fastjson4yacl.md) | `1.0.8-fabric+26.1` | Artifact unavailable; implementation not verified |
| [Flashback Turbo](notes/flashbackturbo.md) | `0.6.2+26.3` | Artifact unavailable; implementation not verified |
| [NoammAddons | Hypixel Skyblock](notes/noammaddons.md) | `1.3.0` | Artifact unavailable; implementation not verified |
| [Ferrite](notes/ferrite.md) | `0.7.4-alpha+26.3` | Artifact unavailable; implementation not verified |
| [Fullscreen Tweaks](notes/fullscreen-tweaks.md) | `2.0.1+26.3-fabric` | Evidence inventory; behavioral review pending |
| [Footprint](notes/footprint.md) | `1.0.2-beta+26.3` | Evidence inventory; behavioral review pending |
| [AntiDeath-Survival-Assistant](notes/antideath-survival-assistant.md) | `v1.7.5-mc26.3` | Evidence inventory; behavioral review pending |
| [LootMate](notes/lootmate.md) | `1.1.1+26.3` | Evidence inventory; behavioral review pending |
| [Fcitx5 Enhancer](notes/fcitx5-enhancer.md) | `0.2.14` | Evidence inventory; behavioral review pending |
| [BetterView](notes/betterview.md) | `2.2.1+fabric` | Artifact unavailable; implementation not verified |
| [Dimension tracker + Afk display](notes/dim-tracker-plusafk-display.md) | `1.3+26.3+mod` | Evidence inventory; behavioral review pending |
| [SignalLoss](notes/signalloss.md) | `1.3.0+26.3` | Evidence inventory; behavioral review pending |
| [Afterburner: Optimized](notes/afterburner-optimized.md) | `0.1.26` | Evidence inventory; behavioral review pending |
| [Hyper Client](notes/hyperclient.md) | `1.3.0` | Artifact unavailable; implementation not verified |
| [Sparkle's Morpher](notes/sparkles-morpher.md) | `2.1.1` | Artifact unavailable; implementation not verified |
| [Auto Totem-Optimized](notes/auto-totem-optimized.md) | `1.5` | Artifact unavailable; implementation not verified |
| [BetterExperience](notes/betterexperience.md) | `0.3.5` | Artifact unavailable; implementation not verified |
| [Metallum](notes/metallum-mc.md) | `0.0.25` | Artifact unavailable; implementation not verified |
| [Drop Stacker](notes/drop-stacker.md) | `1.2.1` | Evidence inventory; behavioral review pending |
| [Crafting Refinements](notes/crafting-refinements.md) | `5.0+mod` | Evidence inventory; behavioral review pending |
| [LinearReader](notes/linearreader.md) | `1.3.0.1` | Artifact unavailable; implementation not verified |
| [Enhanced Biomes Music](notes/enhancedbiomemusic.md) | `2.2.1` | Artifact unavailable; implementation not verified |
| [Zoom In](notes/zoom-in.md) | `26.3-0.5.1` | Artifact unavailable; implementation not verified |
| [Hypixel Simple Chat](notes/hypixelsimplechat.md) | `1.9.8` | Evidence inventory; behavioral review pending |
| [vProxyManager](notes/vproxymanager.md) | `2.0.7+fabric.26.x` | Artifact unavailable; implementation not verified |
| [Storage Tracker](notes/storage-tracker.md) | `1.2.1+26.3` | Artifact unavailable; implementation not verified |
| [Ancient Cities](notes/ancient-cities.md) | `1.6` | Artifact unavailable; implementation not verified |
| [Player Hider (Funnest's Edition)](notes/player-hider-funnest-edition.md) | `1.0.0` | Behavioral static review |
| [VulkShade](notes/vulkshade.md) | `v2.0.0-7` | Artifact unavailable; implementation not verified |
| [ShulkerBoxUtils](notes/shulkerboxutils.md) | `1.4.1` | Artifact unavailable; implementation not verified |
| [Totem Doll](notes/totemdoll.md) | `1.3.2-mc26.3-fabric` | Artifact unavailable; implementation not verified |
| [Calculator](notes/calc.md) | `1.1.0+26.3` | Evidence inventory; behavioral review pending |
| [ParkourCalculator](notes/parkourcalculator.md) | `1.15.0` | Artifact unavailable; implementation not verified |
| [Chat Mod](notes/chat-mod.md) | `2.1.5` | Evidence inventory; behavioral review pending |
| [Simple Sugarcane Farming](notes/simple-sugarcane.md) | `1.2+mod` | Evidence inventory; behavioral review pending |
| [Vanilla DayTime Counter](notes/vanilla-daytime-counter.md) | `1.4.6+26.3` | Artifact unavailable; implementation not verified |
| [AxolotlUtils](notes/axolotlutils.md) | `1.2.1` | Artifact unavailable; implementation not verified |
| [Ev's Mod](notes/evmod.md) | `2.4` | Artifact unavailable; implementation not verified |
| [CoffeeProxy](notes/coffeeproxy.md) | `1.2.1+26.3` | Artifact unavailable; implementation not verified |
| [Lumen Tooltips](notes/lumen-tooltips.md) | `26.3-b8+fabric` | Evidence inventory; behavioral review pending |
| [SAH Project "No Falame&Smoke"](notes/sah-project-nofalamesmoke.md) | `1.2.2` | Evidence inventory; behavioral review pending |
| [AFK Guard](notes/afk-guard.md) | `1.1.0-beta.1` | Evidence inventory; behavioral review pending |
| [EMUtils](notes/emutils.md) | `0.14.0+26.3` | Artifact unavailable; implementation not verified |
| [Drop2Inv](notes/drop2inv.md) | `1.2.0+26.1-26.3` | Evidence inventory; behavioral review pending |
| [WaterLightingFix](notes/waterlightingfix.md) | `1.0.1` | Evidence inventory; behavioral review pending |
| [ZoomHehe](notes/zoomhehe.md) | `4.0.0` | Evidence inventory; behavioral review pending |
| [VerSion](notes/version.md) | `1.1-Mod` | Evidence inventory; behavioral review pending |
| [Rendersnap](notes/rendersnap.md) | `1.3.2` | Evidence inventory; behavioral review pending |
| [Crafting Refinements: Six Stairs](notes/crafting-refinements-six-stairs.md) | `5.0+mod` | Evidence inventory; behavioral review pending |
| [Crafting Refinements: Stonecutter Solutions](notes/crafting-refinements-stonecutter-solutions.md) | `5.0+mod` | Artifact unavailable; implementation not verified |
| [CreeperBoom](notes/creeperboom.md) | `1.1+mc26.3-fabric` | Evidence inventory; behavioral review pending |
| [Player Ping Display](notes/player-ping-display.md) | `1.0.0` | Artifact unavailable; implementation not verified |
| [Pack Tools](notes/pack-tools.md) | `1.26.6.2` | Evidence inventory; behavioral review pending |
| [Windows Priority Boost](notes/windows-priority-boost.md) | `1.0.0` | Artifact unavailable; implementation not verified |
| [Crafting Refinements: Recipe Rebalance](notes/crafting-refinements-recipe-rebalance.md) | `5.0+mod` | Evidence inventory; behavioral review pending |
| [Crafting Refinements: Copper Consistency](notes/crafting-refinements-copper-consistency.md) | `5.0+mod` | Artifact unavailable; implementation not verified |
| [ResourcePackDirectory](notes/resourcepacksdirectory.md) | `26.2-5.0` | Artifact unavailable; implementation not verified |
| [Carpet PRY Addition](notes/carpet-pry-addition.md) | `v1.3.0-mc26.3` | Artifact unavailable; implementation not verified |
| [AutoComplete](notes/autocomplete-2.md) | `1.0.3` | Artifact unavailable; implementation not verified |
| [Compresso](notes/compresso.md) | `1.0.3+26.3-fabric` | Artifact unavailable; implementation not verified |
| [EClean-Modern](notes/ecl-modern.md) | `0.3.8+fabric.26.3` | Artifact unavailable; implementation not verified |
