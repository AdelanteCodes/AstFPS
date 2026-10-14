# Engineering notes

The repository contains original code. Reference-project research is retained
locally rather than published as comparisons or implementation copies.

## Original visibility memo

The cache saves the most recent Boolean visibility result for one frustum. A hit
requires the same frame and all six bounding-box coordinates to match. Camera,
projection and frustum-copy updates invalidate the entry. Shared-thread use falls
back to the normal computation. No approximate geometric test is substituted.

Invalidation hooks and their signatures still need Minecraft runtime validation.
The cache can be slower on workloads with few repeated queries, so it remains an
experiment until benchmarks support enabling it.

## Correctness rules

- Treat bug reports as hypotheses; inspect maintainer responses and reproduction
  evidence before using them as engineering conclusions.
- Cache invalidation must cover every input that affects a result.
- Do not read mutable world state from new worker threads without an explicit
  ownership/snapshot design.
- Keep all visual geometry, lighting, particles and simulation behavior intact.
- Preserve a vanilla fallback and compare it directly in tests and screenshots.
- Record actual evidence; code being written or decompiled is not proof of
  correctness, compatibility, or a performance gain.
