# Changelog

## 1.0.0 — 2026-10-15

- Added configurable hold-`C` zoom with scroll-wheel magnification.
- Added Full Bright, Low RAM, culling, chunk-smoothing, latency and performance-overlay controls.
- Added clear red-to-green state buttons and a compact advanced settings screen.
- Added particle and block-entity distance controls for lower-end systems.
- Preserved the three 6/10/16-chunk profiles while keeping render distance editable.
- Kept frame generation optional and isolated from the stable optimization defaults.
- Removed the corrupting experimental spatial upscaler; V1 does not claim FSR 1/2/3 or Vulkan support.
- Passed a fresh Java 25 clean build, unit tests, core checks and release archive validation.

## 0.9.0-beta.1 — 2026-10-15

- Added compact Maximum Performance, Balanced Performance and Best Visuals profiles with visible selection state and 6/10/16-chunk defaults.
- Enabled automatic optimization defaults while keeping render distance user-editable.
- Added cross-vendor Auto, 2x and 4x frame-generation modes.
- Registered interpolation pipelines before Minecraft's shader resource reload.
- Corrected shader resource placement and exact sampler bindings.
- Prevented vanilla late first-person/post passes from overwriting generated presentations.
- Changed disocclusion fallback to the current valid real frame to prevent dark temporal artifacts.
- Corrected frame pacing to measure real render cost instead of real-to-real time containing synthetic frames.
- Added fast-GPU sub-millisecond pacing coverage.
- Disabled history capture and preflight work while frame generation is off.
- Added camera-cut and UI/loading history invalidation.
- Added safe JSON serialization for non-finite benchmark values.
- Reduced settings-screen blur and visual clutter.
- Expanded diagnostics with frame-generation decisions, failure state and native/generated counters.
- Verified X2 and X4 in TEST WORLD with no compositor failure or shader-load error.
