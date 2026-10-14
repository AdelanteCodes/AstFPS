# AstFPS implementation plan

## Product constraints

Implement original optimization code. Preserve vanilla visual output, native
1440p resolution and the user's chosen 16–20 chunk render distance. Do not remove
visible entities, particles, shadows or lighting, or alter simulation mechanics.
No shader/resource packs, optimization-mod embedding or visual-cutback presets.

## Implementation sequence

1. Establish a reproducible Java 25 / Fabric 26.3 build and client smoke test.
2. Validate frame-scoped, exact-input visibility memoization against vanilla
   results. Keep it off by default until hooks and visual equivalence are tested.
3. Record cache hit rate and frame times on fixed scenes. Remove or revise the
   cache if its overhead outweighs saved work.
4. Profile repeated calculations, allocations and rendering submission work.
   Add one independent optimization at a time, behind a testable feature toggle.
5. Investigate more efficient geometry construction, reuse and draw submission
   only after profiling identifies a material bottleneck. Preserve sorting,
   translucent surfaces and all visible geometry.
6. Add more advanced controls for implementation parameters without changing
   scene appearance. Publish only validated features.

## Acceptance checks

- Build and algorithm tests; actual client startup and world entry.
- Matching visible output with each feature enabled/disabled.
- Fast camera rotation, camera teleport, changed frusta, dimension/world reload,
  transparent blocks, overlapping entities and chunk-boundary geometry.
- Corrupt config recovery without destructive rewrites; bounded memory use.
- Three repeated benchmark runs at both 16 and 20 chunks; average FPS, p99 frame
  time and 1% low FPS. Include dense entities and travel through loaded chunks.
- Compare native-resolution captures on the gaming PC. Hardware performance is
  unverified until that machine is available.

## Target machine

Ryzen 5 5600X, RTX 5060 Ti 16GB, 32GB DDR4, 1440p 300Hz monitor.
The CPU bottleneck remains a hypothesis, not a measured conclusion.
