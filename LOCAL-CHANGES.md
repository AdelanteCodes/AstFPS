# Local changes

Updated memory selection: FerriteCore 9.0.0, ModernFix-mVUS 5.27.20-build.2, Jasione 1.0.9+26.1.2-fabric and Chunky 1.5.3 are now present in `vendor/` and configured as included unmodified modules. `third-party/components.json` contains the active versions and hashes. All declare support for this project's Minecraft 26.3/Fabric target; their combined runtime behavior is untested.

The same four JARs are available separately in `outputs/Xe-Mod-memory-mods`, outside the project directory. They have not been installed into an active Minecraft profile because none was identified. This local set does not include Fabric API, which the target profile must already have. Do not install duplicate copies if the target modpack already contains these modules.

FerriteCore 9.0.0 for Fabric is present locally in `vendor/ferritecore-9.0.0-fabric.jar` and configured as an included, unmodified module in Xe-Mod. Its MIT license is retained in `vendor/FerriteCore-LICENSE.txt` and in the mod resources under `META-INF/xe-mod/licenses/ferritecore-MIT.txt`.

FerriteCore targets memory consumption. It is not a universal memory-leak repair and no FPS gain has been measured for this integration. Source metadata allows Minecraft 26.1 through versions before 27, including this project's 26.3 target.

The previously staged Lithium and ImmediatelyFast dependency declarations were removed for this focused, single-component addition. Their source archives remain local research material. Original collision-box reuse and world-target cleanup changes also remain locally staged.

No GitHub push, compilation, game launch or new test was performed for this addition. The existing 0.1.0-alpha.1 release JAR does not contain these local changes.

Upstream: https://modrinth.com/mod/ferrite-core and https://github.com/malte0811/FerriteCore

## Single-JAR packaging

Created artifacts/xe-mod-memory-bundle-0.2.0-dev.jar with all four memory/pregeneration modules and the compiled alpha core nested unchanged. Added reproducible packaging script, pinned vendor binaries, manifest, checksums, and installation instructions. No game execution, tests, or GitHub upload. New source hooks are not compiled into this artifact.

## 0.3.0-rc.1: FPS-focused general-purpose candidate

Added ImmediatelyFast and Lithium to the single-JAR package. Compiled current core with Java 25. Removed default experimental frustum injections, made AABB/cleanup opt-in, delayed recorder allocation until start, and stopped inactive epoch writes. Added module/Sodium diagnostics and clear safe-mode scope. Applied supported compatibility overrides for duplicate temperature-cache and palette thread-detector patches. Manifest now drives hash validation and nested packaging. Six-module archive inspection found 24 shared targets; two overlapping implementations were addressed, not blanket compatibility verified.

Local build initially hit Windows Java Unix-domain selector failure; a TCP-only build-JDK patch outside the repo allowed Gradle to run. Loom local-file include failed; switched to manifest-driven unmodified nested resources. Compilation and packaging then succeeded. No Minecraft launch, tests, or FPS measurement. Previous GitHub synchronization is ff4b56b; future updates use the current remote parent through the connector to avoid overwriting divergent local history.

## 0.4.0-dev.1: original terrain submission stage

User clarified: build our own terrain-rendering code with no Sodium dependency, and keep coding while they perform captures later. Added XeTerrainBatcher and TerrainBatchMixin: identity-based per-layer buffer grouping, empty-layer lookup avoidance, ordered transparent submission and indirect commands via portable Minecraft API. No Sodium code/binary was imported. Vanilla meshing/visibility/shaders/GPU allocation remain in use. Opt-in hook, known-renderer bypass and runtime failure gate preserve a vanilla fallback. Added terrain toggle, diagnostics, per-capture context/frame counts, and user-capture comparison script. Compilation succeeded without Minecraft execution or tests. Full engine and 5x target are unfinished.
