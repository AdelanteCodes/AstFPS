# AstFPS — project log

Updated: 14 October 2026, IST. Read this file first when continuing the project.

## Current rules

- Work locally. GitHub synchronization and public visibility are authorized.
- Compile and inspect packages when needed; do not launch Minecraft or run runtime tests/benchmarks. The user will capture results on their PC.
- Preserve vanilla visuals, native resolution and chosen render distance. No shader/resource packs or visibility/gameplay cuts.
- Preserve independent third-party module identities and notices.
- Keep changes and records concise. The performance target is 5x in comparable captures, still unmeasured.

## Current state

Account: **AdelanteCodes**, display name **Adelante**, verified in GitHub account settings.
Repository: https://github.com/AdelanteCodes/AstFPS — **public**, verified using GitHub.
Local project: `outputs/AstFPS` in this chat's workspace.
Target: Minecraft Java **26.3**, Fabric Loader **0.19.5+**, Fabric API **0.162.0+26.3**, Java **25**.
Current development package: **0.4.0-dev.5**, adding bounded section record reuse and removing grouping/view allocations from the opt-in terrain stage.
Development JARs are kept under `artifacts/`; packaging and compilation results are recorded there.
The old alpha tag and Git history are historical evidence, not the current development build.

## Current implementation

- Six unmodified nested modules: FerriteCore, ModernFix-mVUS, Jasione, Chunky, ImmediatelyFast and Lithium. Hash pins and notices are retained.
- Original direct/indirect terrain submission and bounded integer command reuse; enabled only with `-Dastfps.enableTerrainBatcher=true`.
- Optional worker helper reuse through weak references; enabled only with `-Dastfps.enableSectionWorkerCache=true`.
- Optional visibility memoization, zero-offset allocation reuse and target cleanup; excluded at startup unless enabled explicitly.
- `/astfps` diagnostics and opt-in capture commands. The recorder buffer is allocated only when recording begins.
- Compilation/archive checks passed for dev.5; runtime behavior, broad compatibility and FPS gain remain unverified. No completed replacement renderer or measured 5x gain is claimed.
- CI workflows are manual only. The cloud benchmark workflow has been retired.

## Historical records

The dated entries below record earlier states; later entries supersede their status descriptions.

## Changelog — 14 October 2026

1. Collected 481 broadly matched optimization projects. Downloaded and hash-verified 410 artifacts; 71 remained unavailable. These catalogue matches are not all useful, compatible or fully understood.
2. Decompiled 373 top-level JVM artifacts. Audited nested components and data-only behavior separately. Prepared local research inventories and 104 manual notes, including 16 partial reviews. Full review of all mods remains unfinished.
3. Published an earlier research snapshot containing 39 behavioral reviews plus labelled inventories for all 481 projects. Later local notes were not published.
4. Wrote the original visibility-cache experiment, frame recording, diagnostic commands and failure handling. Earlier Java 25 CI build/client checks passed for the alpha, including 12,000 visibility comparisons and safe-mode startup. Those checks do not validate the new local code.
5. Published GitHub prerelease 0.1.0-alpha.1. Fixed a publication permission problem by tagging the release commit while retaining the previously checked artifact. Downloaded its runtime JAR locally and matched its SHA-256.
6. Created a separate normal-game comparison harness. Corrected a mixin-package mistake and integer teleport centering. The cloud comparison workflow eventually completed successfully. The first pair measured about 8.19 FPS without AstFPS versus 8.15 FPS with the visibility cache enabled, approximately -0.6%; this preliminary pair does not establish a gain or meaningful regression. Full repeat results/logs have not been analyzed here. Software-renderer results are not laptop/home-PC FPS.
7. User stopped cloud testing, builds and laptop planning. Started code-only changes: staged three optimization components and added the two original hooks listed above, with local diagnostic updates.
8. User requested a simpler local-only addition. Kept FerriteCore as the sole included third-party component, copied its existing verified JAR into the project, retained its MIT notice and removed Lithium/ImmediatelyFast dependency declarations. No new binary was built and no code was uploaded.
9. Changed GitHub repository visibility to private. GitHub required email re-verification; the user completed it. Settings now explicitly report the repository as private.
10. Created this compact master log to preserve state and prevent repeated setup or misleading progress claims.
11. User prioritized memory optimizations and Chunky. Filtered the downloaded collection, retained FerriteCore and added ModernFix-mVUS, Jasione and Chunky as unmodified local JAR dependencies. Checked each archived fabric.mod.json and hash against its recorded download. Updated /astfps status component reporting and current component inventory. Prepared a standalone JAR folder under `outputs/AstFPS-memory-mods` for the same four modules. No game installation directory was supplied, so this folder is a prepared local set, not a claim of installation into an active Minecraft profile. No build, runtime test, GitHub push, chunk-forcing or pregeneration task was run. Kept the alpha NotEnoughPalette, unverified texture-residency Optis, and broad PAPI cache-clearing patches out of this initial memory selection.

Chunky generates terrain onto disk before exploration, reducing future generation work. It does not permanently keep all those chunks in RAM. Pregeneration itself uses CPU/RAM/disk while running. The task remains opt-in; use its own commands when the user is ready. Multiplayer pregeneration runs on the server, not by adding a client-only AstFPS JAR to someone else's server.

## Memory research to retain

- FerriteCore reduces memory use; it is not a universal leak fix. [Project](https://modrinth.com/mod/ferrite-core).
- Original Memory Leak Fix lists support through 1.20.4 and says its previously fixed vanilla leaks were addressed in 1.20.5+. Do not install that old binary into 26.3. [Project](https://modrinth.com/mod/memoryleakfix).
- Mem Leak Fix GPU lists NeoForge 1.21.1 support and stale GPU-target cleanup; it is not the matching Fabric 26.3 component. [Project](https://modrinth.com/mod/memleakfixgpu).
- Put A Plug In it has a 26.3 artifact. Catalogue MIT metadata disagrees with the downloaded artifact/upstream LGPL declaration. It includes reflective model-cache cleanup and optional mod fixes. Not included. The stale-target idea was followed up against vanilla teardown bytecode, and AstFPS's own hook was written independently. [Project](https://modrinth.com/mod/put-a-plug-in-it!).
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


The local single-JAR artifact is `artifacts/AstFPS-memory-bundle-0.2.0-dev.jar`.
It contains the unmodified compiled AstFPS 0.1.0-alpha.1 core, FerriteCore 9.0.0,
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
`META-INF/AstFPS` notices, and `artifacts/package-manifest.json` for provenance.
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

User clarified: build our own terrain-rendering code with no Sodium dependency, and keep coding while they perform captures later. Added AstFPSTerrainBatcher and TerrainBatchMixin: identity-based per-layer buffer grouping, empty-layer lookup avoidance, ordered transparent submission and indirect commands via portable Minecraft API. No Sodium code/binary was imported. Vanilla meshing/visibility/shaders/GPU allocation remain in use. Opt-in hook, known-renderer bypass and runtime failure gate preserve a vanilla fallback. Added terrain toggle, diagnostics, per-capture context/frame counts, and user-capture comparison script. Compilation succeeded without Minecraft execution or tests. Full engine and 5x target are unfinished.

## 0.4.0-dev.2: direct submission and bounded CPU command reuse

Added original direct submission alongside indirect submission, selected by the vanilla renderer capability path. Added renderer-owned scratch and exact immutable command record reuse; all five command integers must match. GPU identities and offsets remain fresh per frame. GPU/world references are cleared after preparation; pooled primitive records and arrays have retention limits/high-water trimming; workspace discarded on close/failure. Added allocated/reused command and direct/indirect frame counters. Inspected vanilla synchronous command serialization before allowing scratch reuse. No runtime tests or measurements. 5x remains unproven.

## AstFPS branding

Renamed public branding, Fabric mod ID, package/class names, commands, JVM properties, build artifact names, resources, documentation and changelogs to AstFPS/astfps. Historical compiled packages were archived outside the active repository without changing their bytes; Git history preserves provenance. Chat and GitHub repository are AstFPS. The user requested public visibility. New commands use /astfps and JVM properties use astfps.*. Current config is astfps.json; remove old mod packages before updating. No Minecraft tests were run.

## 0.4.0-dev.3 continuation and publication

Added opt-in section worker helper reuse with worker-local weak references, native
factory delegation, reentrant compilation bypass, and diagnostic counters. Default
is disabled and runtime verification is pending. Renamed the benchmark harness ID
and resources too. Retired the old cloud benchmark workflow as requested; the manual
release workflow now uses the current committed artifacts and checksum manifest.
Historical binaries remain archived outside the active checkout and in Git history.

## 14 October 2026 — AdelanteCodes identity update (0.4.0-dev.4)

The user renamed their GitHub account to AdelanteCodes. Verified the account and
public AstFPS repository under the new owner. Updated active author metadata,
copyright attribution, repository links, local Git remote and current project records.
Refreshed this log's stale current-state summary while preserving dated history.
The previous development binaries are archived outside the active checkout; Git
history remains intact. This update changes identity/package metadata, not optimization behavior.
No Minecraft execution or FPS measurement is part of this update.

Updated owned Java package/group namespace to `dev.adelantecodes.astfps`, including entrypoints, mixin metadata and packaging checks. Mod ID stays `astfps`.

## 0.4.0-dev.5 — terrain preparation allocation reduction

Continued the original graphics stage after the identity update. Reuse immutable
section origin/fade records only when every primitive field matches exactly,
including raw float bits. Still recompute visibility every frame and upload current
data through vanilla storage. Truncate old list tails before every upload; retain
at most 16,384 primitive-only records per renderer. Remove per-vertex candidate-list
allocations with pooled batch chains; reuse reverse command-list views. Clear batch
chains and GPU references in finally. Added section-record allocated/reused counters
to status, diagnostics and capture exports. See research/renderer-section-record-reuse.md
for vanilla writer contracts and the bounded-retention tradeoff. The feature remains
opt-in; no Minecraft execution, FPS gain or visual parity is claimed.
