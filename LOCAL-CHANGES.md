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
