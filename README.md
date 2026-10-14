# Xe-Mod memory bundle

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
