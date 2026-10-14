# Xe-Mod

An original Minecraft Java 26.3 performance mod under development.

The goal is faster rendering and smoother frame times with unchanged vanilla
visuals: native resolution, the same render distance, the same visible entities,
particles, lighting and textures. No shader packs or resource packs are included.

## Current prototype

- Original, frame-scoped visibility memoization. It reuses an exact prior result
  and invalidates on camera/frustum updates. Experimental and off by default.
- A bounded frame-time recorder with average FPS, p99 frame time and 1% low FPS.
- Local benchmark exports and configurable on/off comparison.

This is a research prototype, not a validated FPS upgrade. Core algorithm tests
pass; Minecraft compilation, hook validation and visual smoke testing must also
pass before a release is considered usable. No performance gain is claimed yet.

## Build

Use Java 25 and run `./gradlew build` (Windows: `gradlew.bat build`). The repository
also has a GitHub Actions build. The mod uses Fabric Loader and Fabric API as
framework dependencies; it contains no other performance-mod binaries or code.

## Commands

- `/xe status`: feature state, cache hits/misses and recording status.
- `/xe memo true` / `/xe memo false`: enable/disable the experimental cache.
- `/xe label <text>`: label a benchmark with resolution, distance and scene.
- `/xe benchmark start` / `/xe benchmark stop`: record and export locally.

Exports go to `xe-benchmarks/` in the game folder and are not uploaded. Use the
same world, camera route and settings for comparisons. The FPS measurement
includes frame pacing; it is not a GPU timer or CPU-only render-cost measurement.

## Continue on another PC

Clone https://github.com/KyzerGoated/Xe-Mod, open the folder in Codex, and ask it to
read PLAN.md and STATUS.md. Pull before starting and push completed changes before
switching machines.
