# Xe-Mod 0.4.0-dev.2

A general-purpose Fabric client mod for Minecraft Java 26.3. It uses Java 25,
Fabric Loader 0.19.5+, and matching Fabric API (0.162.0+26.3). No specific CPU,
GPU brand, resolution, or render distance is required beyond Minecraft support.
The client package is for single-player and multiplayer clients, not dedicated servers.

## Install

Use `artifacts/xe-mod-0.4.0-dev.2.jar` with Fabric API in your mods folder.
Remove older Xe-Mod/bundle JARs and separate copies of bundled modules.
Sodium is not required. Our optional original terrain stage bypasses itself if Sodium or a known renderer replacement is loaded. No shaders/resource packs are bundled.
Xe-Mod does not change your graphics options, render distance, or resolution.

## Included optimizations

- ImmediatelyFast 1.17.1+26.3: more efficient immediate rendering buffers and batching for entities, particles, text and HUD.
- Lithium 0.26.2+mc26.3: game-logic, physics, AI and ticking optimizations; useful for integrated-server work in single-player.
- FerriteCore 9.0.0, ModernFix-mVUS 5.27.20-build.2, and Jasione 1.0.9+26.1.2-fabric: memory, startup and allocation optimizations.
- Chunky 1.5.3: opt-in terrain pregeneration onto disk, not permanent chunk residency in RAM. No job starts automatically.

All six modules remain unmodified independent Fabric mods inside one JAR, with
their own authors, versions, configuration and notices. See third-party/components.json.

## Conservative defaults and diagnostics

Benchmark recording is off by default; its 60,000-entry buffer is allocated only
when recording starts. The frame epoch updates only while memoization is active.
Original experimental mixins are excluded at startup unless explicitly enabled:
`-Dxe.enableVisibilityMemo=true`, `-Dxe.enableZeroOffsetReuse=true`, or
`-Dxe.enableWorldTargetCleanup=true`. Memoization also requires `/xe memo true`.
`-Dxe.safeMode=true` disables Xe-Mod optimization hooks, not the bundled modules.
Existing disableZeroOffsetReuse/disableWorldTargetCleanup flags still take precedence.

`/xe status` reports all bundled versions and optional Sodium presence.
`/xe diagnose` exports hook receipts, module versions and failures locally.
`/xe benchmark start|stop` remains available only when the player opts in.

## Compatibility review

Lithium's duplicate biome temperature-cache overwrite is disabled through
`lithium:options`; ModernFix provides the equivalent implementation.
FerriteCore's optional small thread detector is disabled through its metadata
override to avoid overlapping Lithium's palette locking patch.
The static review identifies 24 shared upstream mixin targets. Shared targets
are review candidates, not automatically errors; runtime application remains unverified.
Respect upstream conflicts: OptiFabric/OptiFine, Redirector, Hydrogen <=0.3,
and DashLoader <5.0.0-beta.1. Other modpack compatibility is not established.

## Build and verification

Use Java 25: `gradlew.bat jar sourcesJar -x test -x coreChecks -x check`.
Then run `python scripts/inspect_components.py` and `python scripts/package_release.py`.
The manifest drives both pinned binary validation and nested-module packaging.
The runtime uses freshly compiled current code, not the old alpha core.
Compilation and archive checks passed. Minecraft, unit tests and runtime benchmarks
were not run, as requested. This is a runtime-unverified release candidate;
no FPS percentage or broad stability claim is made.

The sources JAR contains Xe-Mod source and the available pinned Lithium and
ImmediatelyFast source archives. Other upstream source links/notices are retained;
verify complete corresponding-source coverage before broader redistribution.
Read PROJECT_LOG.md for history and continuation notes.

## Original graphics stage

This development build adds original indirect terrain submission code. Opt in with -Dxe.enableTerrainBatcher=true; /xe terrain false|true switches the installed path. The default stays vanilla until user verification. Geometry, visibility, shaders and GPU lifetime management remain owned by Minecraft; this is the first stage, not a completed renderer replacement. See GRAPHICS_ROADMAP.md and benchmarks/USER-CAPTURES.md.

The user will run captures later. 5x remains a target, not a measured result.

The original stage now covers direct and indirect submissions and reuses bounded integer-only command records. GPU resources are not cached across frames.
