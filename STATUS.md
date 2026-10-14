# Status

Direction: original code, unchanged vanilla visuals, no repackaged performance
mods and no external shader/resource packs.

Implemented: original frame-scoped visibility memo, invalidation hooks, on/off
control, frame recorder, benchmark exports and Gradle/GitHub build configuration.

Verified locally: Java core checks for FPS statistics, recorder limits/lifecycle,
exact cache queries, changed bounds, epochs, invalidation and thread fallback.

Verified in CI: Java 25 build and core checks; actual Minecraft 26.3 client startup
in normal and safe mode; 12,000 generated/expanded visibility comparisons, repeated
queries, camera/frustum invalidation, hook receipts, and running frame capture.
Successful run: https://github.com/KyzerGoated/Xe-Mod/actions/runs/38528794581

Not yet verified: full-world visual equivalence, other-mod compatibility, or an
FPS improvement. The first prerelease publishes the already-built artifact without
new test runs. Experimental memoization stays off by default.

Research: 481 broad catalogue matches, 410 downloaded artifacts. Archive and
decompilation inventories are separate from a completed behavioral review.
Research documentation is published separately under research/. It is not
optimization code in this repo. Incomplete behavioral reviews remain labelled.

Release: 0.1.0-alpha.1, Minecraft 26.3 / Fabric / Java 25. No visual cutbacks.
Next: measure cache on/off in controlled vanilla scenes on the target PC.
