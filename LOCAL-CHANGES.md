# Local changes

Updated memory selection: FerriteCore 9.0.0, ModernFix-mVUS 5.27.20-build.2, Jasione 1.0.9+26.1.2-fabric and Chunky 1.5.3 are now present in `vendor/` and configured as included unmodified modules. `third-party/components.json` contains the active versions and hashes. All declare support for this project's Minecraft 26.3/Fabric target; their combined runtime behavior is untested.

The same four JARs are available separately in `outputs/AstFPS-memory-mods`, outside the project directory. They have not been installed into an active Minecraft profile because none was identified. This local set does not include Fabric API, which the target profile must already have. Do not install duplicate copies if the target modpack already contains these modules.

FerriteCore 9.0.0 for Fabric is present locally in `vendor/ferritecore-9.0.0-fabric.jar` and configured as an included, unmodified module in AstFPS. Its MIT license is retained in `vendor/FerriteCore-LICENSE.txt` and in the mod resources under `META-INF/AstFPS/licenses/ferritecore-MIT.txt`.

FerriteCore targets memory consumption. It is not a universal memory-leak repair and no FPS gain has been measured for this integration. Source metadata allows Minecraft 26.1 through versions before 27, including this project's 26.3 target.

The previously staged Lithium and ImmediatelyFast dependency declarations were removed for this focused, single-component addition. Their source archives remain local research material. Original collision-box reuse and world-target cleanup changes also remain locally staged.

No GitHub push, compilation, game launch or new test was performed for this addition. The existing 0.1.0-alpha.1 release JAR does not contain these local changes.

Upstream: https://modrinth.com/mod/ferrite-core and https://github.com/malte0811/FerriteCore

## Single-JAR packaging

Created artifacts/AstFPS-memory-bundle-0.2.0-dev.jar with all four memory/pregeneration modules and the compiled alpha core nested unchanged. Added reproducible packaging script, pinned vendor binaries, manifest, checksums, and installation instructions. No game execution, tests, or GitHub upload. New source hooks are not compiled into this artifact.

## 0.3.0-rc.1: FPS-focused general-purpose candidate

Added ImmediatelyFast and Lithium to the single-JAR package. Compiled current core with Java 25. Removed default experimental frustum injections, made AABB/cleanup opt-in, delayed recorder allocation until start, and stopped inactive epoch writes. Added module/Sodium diagnostics and clear safe-mode scope. Applied supported compatibility overrides for duplicate temperature-cache and palette thread-detector patches. Manifest now drives hash validation and nested packaging. Six-module archive inspection found 24 shared targets; two overlapping implementations were addressed, not blanket compatibility verified.

Local build initially hit Windows Java Unix-domain selector failure; a TCP-only build-JDK patch outside the repo allowed Gradle to run. Loom local-file include failed; switched to manifest-driven unmodified nested resources. Compilation and packaging then succeeded. No Minecraft launch, tests, or FPS measurement. Previous GitHub synchronization is ff4b56b; future updates use the current remote parent through the connector to avoid overwriting divergent local history.

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
