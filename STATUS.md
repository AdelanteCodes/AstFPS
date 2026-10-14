# Status

Direction: original code, unchanged vanilla visuals, no repackaged performance
mods and no external shader/resource packs.

Implemented: original frame-scoped visibility memo, invalidation hooks, on/off
control, frame recorder, benchmark exports and Gradle/GitHub build configuration.

Verified locally: Java core checks for FPS statistics, recorder limits/lifecycle,
exact cache queries, changed bounds, epochs, invalidation and thread fallback.

Not yet verified: Java 25 Minecraft compilation, actual mixin application, client
startup, visual equivalence, or an FPS improvement. The local Java 25 download
timed out. Do not interpret core-test success as in-game validation.

Research: 481 broad catalogue matches, 410 downloaded artifacts. Archive and
decompilation inventories are separate from a completed behavioral review.
Reference research remains local; it is not optimization code in this repo.

Next: validate the build and client hooks, then compare cache on/off in controlled
vanilla scenes. No aggressive visual changes are planned.
