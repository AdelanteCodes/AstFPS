# AstFPS 1.0

AstFPS is a Fabric client optimization bundle for Minecraft Java 26.3. It combines automatic CPU/render optimizations, three compact visual profiles, diagnostics, zoom and optional experimental cross-vendor frame generation.

## Requirements

- Minecraft Java 26.3
- Java 25
- Fabric Loader 0.19.5 or newer
- Fabric API 0.162.0+26.3

Install `AstFPS-1.0.0.jar` in `.minecraft/mods` and remove older AstFPS JARs. AstFPS bundles compatible versions of ImmediatelyFast, Lithium, FerriteCore, ModernFix, Jasione and Chunky; do not install duplicate copies.

## Profiles

- Maximum Performance: 6-chunk default, reduced effects.
- Balanced Performance: 10-chunk default.
- Best Visuals: 16-chunk default.

The render distance remains editable after choosing a profile. Optimizations are enabled automatically. Open Options → Video Settings to reach the compact AstFPS screen.

## Frame generation

Off, Auto, 2x and 4x modes are available. The compositor retains two real post-processed world frames and inserts one or three GPU-generated presentations. It uses Minecraft's cross-vendor RenderPipeline API rather than NVIDIA-, AMD- or Intel-specific SDKs.

Frame generation pauses during menus, chat, loading, camera cuts, low base frame rate or known GPU saturation. Version 1.0 registers all interpolation pipelines during resource reload, uses exact shader binding names, runs generated presentations through the compositor only, falls back to the current valid frame at disocclusions, and measures real-render cost without counting inserted presentations.

2x/4x describe presentation cadence, not a guarantee of doubled native simulation speed or lower latency. Frame generation remains an optional experimental feature because compatibility depends on the GPU driver and other renderer mods.

## V1 controls

- Hold `C` to zoom and use the scroll wheel while held to adjust magnification.
- Full Bright, Low RAM, culling, chunk smoothing, latency and overlay controls are available in the compact advanced screen.
- The earlier experimental upscaler was removed from V1 after visual-corruption testing. FSR 2/3 and Vulkan are not advertised or bundled.

## Verification

The V1 source passes:

- `clean test coreChecks build`
- static archive, bundled-module, shader and pipeline checks
- clean Minecraft 26.3 resource reload with all six interpolation pipelines
- earlier live TEST WORLD runs on OpenGL/NVIDIA at X2 and X4
- X2 decision: one generated presentation, suspension `NONE`
- X4 decision: three generated presentations, suspension `NONE`
- more than 100,000 X2 and 60,000 X4 generated presentations without a compositor failure

The current V1 package passed a fresh Java 25 clean build, unit suite, core checks and archive inspection. The live frame-generation observations above were collected on the earlier compatible build and are not a universal guarantee. The earlier native comparison was not camera-matched and is intentionally not advertised as a benchmark result.

## Commands

- `/astfps status`
- `/astfps diagnose`
- `/astfps profile maximum|balanced|quality|restore`
- `/astfps benchmark start|stop`
- `/astfps label <scene>`

Diagnostics and benchmark JSON files are written locally under `.minecraft` and include requested/active frame-generation state, suspension reason, native/generated presentation counts, backend capabilities and adaptive-policy data.

## Build

```text
gradlew.bat clean test coreChecks build --no-daemon
python scripts/package_release.py
```

Maintained by AdelanteCodes. Third-party components retain their original licenses and credits.
