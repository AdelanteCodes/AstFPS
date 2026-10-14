# Xe-Mod — project log

Updated: 14 October 2026, IST. Read this file first when continuing the project. Keep the current-state sections short and append a dated entry for each meaningful change.

## Current rules

- Work locally on this PC. Do not upload code or notes to GitHub until requested.
- No builds, automated tests, cloud Minecraft sessions or laptop setup unless requested. The user will test on their laptop when ready.
- Preserve vanilla visuals, native resolution and the chosen render distance. No shader/resource packs or visibility/gameplay cuts.
- Permitted third-party components may be included with their original identities, credits and required notices. Do not relabel their code as original Xe-Mod work.
- Prefer one useful change at a time. Avoid lengthy planning and packaging detours. Keep this log updated.
- Current focus: lower memory usage and add Chunky-style pregeneration before further FPS/rendering work.

## Current state

Repository: https://github.com/KyzerGoated/Xe-Mod — **private**, verified in GitHub settings after the user completed email verification.

Local project: `C:\Users\Multiwings\Documents\Codex\2026-10-14\so-x20\outputs\Xe-Mod`.

Target: Minecraft Java **26.3**, Fabric Loader **0.19.5+**, matching Fabric API **0.162.0+26.3**, Java **25**.

Local source version: **0.2.0-dev**, with uncommitted changes. This version has not been compiled or run. Last synchronized code commit: `2e68b19650e869680bf668368c8828b3345ddad5`. No current development changes have been pushed.

Released version: **0.1.0-alpha.1**. Its JAR is in `outputs\Xe-Mod-release\xe-mod-0.1.0-alpha.1.jar`. It contains the older visibility experiment and diagnostics; it does not contain the new local additions.

## What is currently written

| Change | Location | State |
|---|---|---|
| Exact, frame-scoped frustum visibility cache | `VisibilityMemo.java`, `FrustumMemoMixin.java` | In released alpha; off by default; no demonstrated general FPS gain |
| Frame recorder, FPS/1% low/p99 calculations, local exports | `FrameRecorder.java`, `FrameStats.java`, `XeClient.java` | In released alpha |
| Startup hook receipts, first-failure diagnostics, safe-mode controls | `HookAudit.java`, `FeatureGate.java`, `XeMixinPlugin.java` | In released alpha; local plugin also covers new hooks |
| FerriteCore 9.0.0, unmodified MIT-licensed memory component | `vendor/ferritecore-9.0.0-fabric.jar`, `build.gradle`, `fabric.mod.json` | Added locally and configured for inclusion; unbuilt/unrun |
| ModernFix-mVUS 5.27.20-build.2, memory/loading optimizations | `vendor/modernfix-5.27.20-build.2.jar` | Unmodified local component; compatible version declared by upstream; unbuilt/unrun as a combined Xe-Mod |
| Jasione 1.0.9+26.1.2-fabric, avoids unnecessary enum-array allocation | `vendor/jasione-1.0.9+26.1.2-fabric.jar` | Metadata allows >=26.1, upstream lists 26.3; unbuilt/unrun as a combined Xe-Mod |
| Chunky 1.5.3, terrain pregeneration | `vendor/Chunky-Fabric-1.5.3.jar` | Metadata allows >=26.1 / Java 25; no world generation task started |
| Avoid allocating a new AABB for zero movement when all finite coordinates remain bit-identical | `AabbZeroOffsetMixin.java` | Original code, local only, unbuilt/unrun |
| Release stale crosshair entity/hit references after disconnect/world teardown, only when no client world remains | `WorldTargetCleanupMixin.java` | Original narrow retention mitigation, local only, unbuilt/unrun |
| Show component versions and target-cleanup counts | `XeClient.java`, `XeRuntime.java` | Local only |
| Make CI workflows manual-only | `.github/workflows/` | Local changes; remote workflow files still have their previous triggers |

FerriteCore's MIT notice and the added modules' LGPL/GPL notices are retained locally. Lithium and ImmediatelyFast were briefly staged as dependencies, then removed for the user's focused single-component request. Their source archives/notices remain local reference material; they are **not active dependencies**. `third-party/components.json` now records the active four-component selection, metadata constraints and verified SHA-512 hashes. No copyleft component has been publicly redistributed in this update; corresponding sources and notices must accompany any future distribution.

## Changelog — 14 October 2026

1. Collected 481 broadly matched optimization projects. Downloaded and hash-verified 410 artifacts; 71 remained unavailable. These catalogue matches are not all useful, compatible or fully understood.
2. Decompiled 373 top-level JVM artifacts. Audited nested components and data-only behavior separately. Prepared local research inventories and 104 manual notes, including 16 partial reviews. Full review of all mods remains unfinished.
3. Published an earlier research snapshot containing 39 behavioral reviews plus labelled inventories for all 481 projects. Later local notes were not published.
4. Wrote the original visibility-cache experiment, frame recording, diagnostic commands and failure handling. Earlier Java 25 CI build/client checks passed for the alpha, including 12,000 visibility comparisons and safe-mode startup. Those checks do not validate the new local code.
5. Published GitHub prerelease 0.1.0-alpha.1. Fixed a publication permission problem by tagging the release commit while retaining the previously checked artifact. Downloaded its runtime JAR locally and matched its SHA-256.
6. Created a separate normal-game comparison harness. Corrected a mixin-package mistake and integer teleport centering. The cloud comparison workflow eventually completed successfully. The first pair measured about 8.19 FPS without Xe-Mod versus 8.15 FPS with the visibility cache enabled, approximately -0.6%; this preliminary pair does not establish a gain or meaningful regression. Full repeat results/logs have not been analyzed here. Software-renderer results are not laptop/home-PC FPS.
7. User stopped cloud testing, builds and laptop planning. Started code-only changes: staged three optimization components and added the two original hooks listed above, with local diagnostic updates.
8. User requested a simpler local-only addition. Kept FerriteCore as the sole included third-party component, copied its existing verified JAR into the project, retained its MIT notice and removed Lithium/ImmediatelyFast dependency declarations. No new binary was built and no code was uploaded.
9. Changed GitHub repository visibility to private. GitHub required email re-verification; the user completed it. Settings now explicitly report the repository as private.
10. Created this compact master log to preserve state and prevent repeated setup or misleading progress claims.
11. User prioritized memory optimizations and Chunky. Filtered the downloaded collection, retained FerriteCore and added ModernFix-mVUS, Jasione and Chunky as unmodified local JAR dependencies. Checked each archived fabric.mod.json and hash against its recorded download. Updated /xe status component reporting and current component inventory. Prepared a standalone JAR folder under `outputs/Xe-Mod-memory-mods` for the same four modules. No game installation directory was supplied, so this folder is a prepared local set, not a claim of installation into an active Minecraft profile. No build, runtime test, GitHub push, chunk-forcing or pregeneration task was run. Kept the alpha NotEnoughPalette, unverified texture-residency Optis, and broad PAPI cache-clearing patches out of this initial memory selection.

Chunky generates terrain onto disk before exploration, reducing future generation work. It does not permanently keep all those chunks in RAM. Pregeneration itself uses CPU/RAM/disk while running. The task remains opt-in; use its own commands when the user is ready. Multiplayer pregeneration runs on the server, not by adding a client-only Xe-Mod JAR to someone else's server.

## Memory research to retain

- FerriteCore reduces memory use; it is not a universal leak fix. [Project](https://modrinth.com/mod/ferrite-core).
- Original Memory Leak Fix lists support through 1.20.4 and says its previously fixed vanilla leaks were addressed in 1.20.5+. Do not install that old binary into 26.3. [Project](https://modrinth.com/mod/memoryleakfix).
- Mem Leak Fix GPU lists NeoForge 1.21.1 support and stale GPU-target cleanup; it is not the matching Fabric 26.3 component. [Project](https://modrinth.com/mod/memleakfixgpu).
- Put A Plug In it has a 26.3 artifact. Catalogue MIT metadata disagrees with the downloaded artifact/upstream LGPL declaration. It includes reflective model-cache cleanup and optional mod fixes. Not included. The stale-target idea was followed up against vanilla teardown bytecode, and Xe-Mod's own hook was written independently. [Project](https://modrinth.com/mod/put-a-plug-in-it!).
- Sodium 0.9.2 notes a specific F3 resource-recreation leak fix. Sodium was not bundled. [Release](https://github.com/CaffeineMC/sodium/releases/tag/mc26.3-0.9.2).
- A [Reddit report](https://www.reddit.com/r/MinecraftMod/comments/1ukbb4z/i_need_help_fixing_freezing_or_memory_leaking_in/) says graphics-driver updates resolved apparent memory trouble. Another [report](https://www.reddit.com/r/Minecraft/comments/1td6ux0/memory_bug_causing_lag_spikes_no_idea_how_to_fix/) describes RAM rising then dropping during freezes. These are anecdotes, not proof of a specific leak in the user's game.
- Retained Java objects, heavy allocations/GC, native memory and VRAM leaks require different diagnoses. [Oracle guide](https://docs.oracle.com/en/java/javase/26/troubleshoot/troubleshooting-memory-leaks.html).

## Pending, not completed

- The new local integration/hooks need compilation and laptop verification when the user requests it. Do not report them as working in Minecraft yet.
- No substantial FPS improvement has been established. The user has now prioritized memory use and chunk pregeneration; rendering work comes later.
- Full cloud-log analysis and the larger documentation sprint remain unfinished; do not resume cloud runs or mass documentation automatically.
- README.md, STATUS.md and parts of the component inventory predate the latest direction. This file and LOCAL-CHANGES.md describe the current local work.

## Next-chat starting instruction

Read PROJECT_LOG.md and the actual local source before making changes. Continue the memory-use and pregeneration focus locally, one useful change at a time. No GitHub uploads, builds or cloud tests without a new request. Append the actual outcome to this log, including whether a change was only written or was verified.

## Single-JAR memory bundle (latest local change)


The local single-JAR artifact is `artifacts/xe-mod-memory-bundle-0.2.0-dev.jar`.
It contains the unmodified compiled Xe-Mod 0.1.0-alpha.1 core, FerriteCore 9.0.0,
ModernFix-mVUS 5.27.20-build.2, Jasione 1.0.9+26.1.2-fabric, and Chunky 1.5.3.
Fabric loads the independent nested modules from this one container.

Use Minecraft Java 26.3, Java 25, Fabric Loader 0.19.5 or newer, and matching
Fabric API (0.162.0+26.3). Put the bundle and Fabric API in the profile's mods
folder. Remove separate copies of the five included modules to avoid duplicates.
Do not combine with Redirector, Hydrogen <=0.3, or DashLoader <5.0.0-beta.1;
these are upstream-declared conflicts. Other installed mods remain unassessed.

FerriteCore and ModernFix reduce memory/startup overhead; Jasione reduces certain
temporary enum-array allocations. Chunky pregenerates terrain on disk using its
commands; no job starts automatically and chunks are not kept permanently in RAM.
No visual settings, shaders or resource packs are changed by this packaging.

Pinned hashes, archive integrity, unique module IDs, declared requirements, and
referenced resources were checked. Minecraft and tests were not run for this
bundle. Working together in an actual game is not yet verified; no FPS or RAM
improvement has been measured for this combination.

The new zero-offset AABB and world-target cleanup hooks exist in source only.
They are not in the packaged alpha core. A later Java 25 compilation is needed
to ship those hooks. The source Gradle configuration includes the four modules;
the current artifact uses the existing compiled core to avoid claiming new code
was compiled. Recreate it with `python scripts/package_memory_bundle.py`.

Module identities and notices are preserved. See `third-party/components.json`,
`META-INF/xe-mod` notices, and `artifacts/package-manifest.json` for provenance.
Keep exact corresponding upstream sources with any future copyleft distribution.
All changes and artifacts are saved in the local Git repository. Nothing was
uploaded to GitHub during this integration. Read PROJECT_LOG.md to continue.

## GitHub synchronization requested
User authorized uploading the complete local integration, changelogs and existing research records. Copied the historical audit/inventory/review records into research/records. These records describe prior investigation, not proof that every mod was deeply reviewed. No new Minecraft tests were run.

## 0.3.0-rc.1: FPS-focused general-purpose candidate

Added ImmediatelyFast and Lithium to the single-JAR package. Compiled current core with Java 25. Removed default experimental frustum injections, made AABB/cleanup opt-in, delayed recorder allocation until start, and stopped inactive epoch writes. Added module/Sodium diagnostics and clear safe-mode scope. Applied supported compatibility overrides for duplicate temperature-cache and palette thread-detector patches. Manifest now drives hash validation and nested packaging. Six-module archive inspection found 24 shared targets; two overlapping implementations were addressed, not blanket compatibility verified.

Local build initially hit Windows Java Unix-domain selector failure; a TCP-only build-JDK patch outside the repo allowed Gradle to run. Loom local-file include failed; switched to manifest-driven unmodified nested resources. Compilation and packaging then succeeded. No Minecraft launch, tests, or FPS measurement. Previous GitHub synchronization is ff4b56b; future updates use the current remote parent through the connector to avoid overwriting divergent local history.

Publication: user-authorized private GitHub update includes the compiled 0.3.0-rc.1 artifacts, source package, six-module manifest, static review and changelogs. No automatic cloud workflow is triggered; workflows remain manual.

## 0.4.0-dev.1: original terrain submission stage

User clarified: build our own terrain-rendering code with no Sodium dependency, and keep coding while they perform captures later. Added XeTerrainBatcher and TerrainBatchMixin: identity-based per-layer buffer grouping, empty-layer lookup avoidance, ordered transparent submission and indirect commands via portable Minecraft API. No Sodium code/binary was imported. Vanilla meshing/visibility/shaders/GPU allocation remain in use. Opt-in hook, known-renderer bypass and runtime failure gate preserve a vanilla fallback. Added terrain toggle, diagnostics, per-capture context/frame counts, and user-capture comparison script. Compilation succeeded without Minecraft execution or tests. Full engine and 5x target are unfinished.
