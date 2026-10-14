# Potatoptimize

Review status: **Evidence inventory; behavioral review pending**

Project: [Potatoptimize](https://modrinth.com/mod/potatoptimize)
Selected artifact version: `mc26.2-2.2.2`
Published implementation source: https://github.com/Tater-Certified/Potatoptimize
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Let tater optimize your game!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `2a46c4b1de9b938e93f3791051a02271fdd4953e`
- `sha512`: `4391324b405b7a8d21e237619f658c51540c9508b0d3a7dab066beeba32e3fb482e2cd06069138f48f5fa9a6cc0c3a9935cdcdf8e5fb4291edc39ff6aed1e6e4`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 860
Reconstructed Java files: 693

**environment**

```json
"*"
```

**depends**

```json
{
  "fabricloader": "*",
  "minecraft": ">=26.2"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/github/tatercertified/potatoptimize/config/MixinConfig.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, preApply, postApply |
| top-level / `com/github/tatercertified/potatoptimize/config/mixintree/MixinTree.java` | `` |  | incrementOverrides, getOverrides, isEnabled |
| top-level / `com/github/tatercertified/potatoptimize/config/mixintree/MixinTreeNode.java` | `` |  | setEnabled, addChild, isEnabled |
| top-level / `com/github/tatercertified/potatoptimize/config/mixintree/NodeData.java` | `` |  | NodeData, isUser |
| top-level / `com/github/tatercertified/potatoptimize/config/PotatoptimizeConfig.java` | `` |  | load, readProperties, applyModOverrides, getOverridesFabric, getJarFile, getOverridesSponge, getOverridesForge, getOverridesNeoForge, writeDefaultConfig, slice |
| top-level / `com/github/tatercertified/potatoptimize/mixin/nonvanilla/entity/teleport/portal/NetherPortalMixin.java` | `value={PortalShape.class})` | Inject:1 | findOpenPos |
| top-level / `com/github/tatercertified/potatoptimize/mixin/nonvanilla/player/stats/PlayerEntityStatsMixin.java` | `value={ServerPlayer.class})` | Inject:2, Redirect:1 | potatoptimize$checkForStatsTick, potatoptimize$delayStat, potatoptimize$resetIncrementBool |
| top-level / `com/github/tatercertified/potatoptimize/mixin/semivanilla/entity/navigation/CancelNavigationMixin.java` | `value={PathNavigation.class})` | WrapMethod:1 | potatoptimize$cancelPathFinding |
| top-level / `com/github/tatercertified/potatoptimize/mixin/vanilla/blockentity/ticking/sign/AbstractSignBlockMixin.java` | `value={SignBlock.class})` | Redirect:1 | removeTicker |
| top-level / `com/github/tatercertified/potatoptimize/mixin/vanilla/blockentity/ticking/sign/HangingSignMixin.java` | `value={CeilingHangingSignBlock.class})` | Redirect:1 | removeTicker |
| top-level / `com/github/tatercertified/potatoptimize/mixin/vanilla/blockentity/ticking/sign/SignBlockEntityMixin.java` | `value={SignBlockEntity.class})` | Inject:1 | checkEditor |
| top-level / `com/github/tatercertified/potatoptimize/mixin/vanilla/blockentity/ticking/sign/WallHangingSignMixin.java` | `value={WallHangingSignBlock.class})` | Redirect:1 | removeTicker |
| top-level / `com/github/tatercertified/potatoptimize/mixin/vanilla/entity/halloween/SpecialDatesMixin.java` | `value={SpecialDates.class})` | Overwrite:2, Inject:1 | isHalloween, isExtendedChristmas, potatoptimize$initCache, updateHalloweenCache, updateChristmasCache, isBefore, isDuring, getTimeStamp |
| top-level / `com/github/tatercertified/potatoptimize/mixin/vanilla/entity/spawning/slime/RandomSlimeEntityMixin.java` | `value={Slime.class})` | Inject:1 | simplifySlimeChunkCheck, canSlimeSpawn |
| top-level / `com/github/tatercertified/potatoptimize/mixin/vanilla/entity/spawning/slime/SlimeChunkMixin.java` | `value={LevelChunk.class})` | Inject:3 | assignSlimeChunk1, assignSlimeChunk2, assignSlimeChunk3, isSlimeChunk, setSlimeChunk |
| top-level / `com/github/tatercertified/potatoptimize/Potatoptimize.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/annotations/IfBoolean.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/annotations/IfBooleans.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/annotations/IfDevEnvironment.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/annotations/IfMinecraftVersion.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/annotations/IfModAbsent.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/annotations/IfModAbsents.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/annotations/IfModLoaded.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/annotations/IfModLoadeds.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/checker/AnnotationChecker.java` | `` |  | isConstraintAnnotationNode, checkAnnotationNode, getAnnotationValue |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/checker/ConstraintChecker.java` | `` |  | checkModLoaded, checkBooleanValue, checkModAbsent, checkDevEnvironment, checkMinecraftVersion, isModLoadedWithinVersion |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/ConstraintsMixinPlugin.java` | `` |  | shouldApplyMixin, onLoad, getRefMapperConfig, acceptTargets, getMixins, preApply, postApply |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/FabricAbstractionsImpl.java` | `` |  | isDevEnvironment, getModVersion, isVersionInRange, getPlatformName |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/ForgeAbstractionsImpl.java` | `` |  | isDevEnvironment, getModVersion, isVersionInRange, getPlatformName |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/IgniteAbstractionsImpl.java` | `` |  | isDevEnvironment, getModVersion, isVersionInRange, getPlatformName |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/mixin/ConstraintsMixinExtension.java` | `` |  | checkActive, preApply, postApply, export |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/mixin/MixinConstraintsBootstrap.java` | `` |  | init |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/mixin/MixinTransformer.java` | `` |  | transform, shouldRemoveTarget |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/MixinConstraints.java` | `` |  | shouldApplyMixin, getLoaderName, getLoader, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/NeoForgeAbstractionsImpl.java` | `` |  | isDevEnvironment, getModVersion, isVersionInRange, getPlatformName |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/SpongeAbstractionsImpl.java` | `` |  | isDevEnvironment, getModVersion, isVersionInRange, getPlatformName, getModVersions, readPluginInfo |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/util/Abstractions.java` | `` |  | doesClassExist, getAbstractions, tryLoadAbstractionsFromClassname, isDevelopmentEnvironment, isModLoadedWithinVersion, getLoaderName |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/util/MixinHacks.java` | `` |  | tryInit, registerMixinExtension, getMixinsFor, addExtension |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/util/Pair.java` | `` |  | of |
| top-level / `com/github/tatercertified/potatoptimize/shaded/com/github/tatercertified/mixinconstraints/util/Version.java` | `` |  | compareTo |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/event/Cancellable.java` | `` |  | cancelled, setCancelled |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/event/Event.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/event/EventManager.java` | `` |  | eventClass, register, listeners, invoke |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/logger/impl/ApacheLogger.java` | `` |  | getLogger, info, warn, warn, error, error, debug, trace, fatal |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/logger/impl/JavaLogger.java` | `` |  | getLogger, info, warn, warn, error, error, debug, trace, fatal |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/logger/impl/MixinLogger.java` | `` |  | getLogger, info, warn, warn, error, error, debug, trace, fatal |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/logger/impl/Slf4jLogger.java` | `` |  | getLogger, info, warn, warn, error, error, debug, trace, fatal |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/logger/impl/SystemLogger.java` | `` |  | prependPrefix, getLogger, info, warn, warn, error, error, debug, trace, fatal |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/logger/Logger.java` | `` |  | create |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/anno/AConstraint.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/anno/AConstraints.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/anno/Dependency.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/anno/Range.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/anno/VersionFeature.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/anno/Versions.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/Constraint.java` | `` |  | Constraint, result, equals, hashCode, builder, range, range, range, range, greaterThan, greaterThan, noLessThan, noLessThan, lessThan, lessThan, noGreaterThan, noGreaterThan, evalDeps, evalMappings, evalPlatform, evalSide, evalVersion, evaluate, deps, deps, mappings, mappings, platform, platform, platform, side, side, version, version, version, minInclusive, min, min, maxInclusive, max, max, invert, build, result |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/Constraints.java` | `` |  | result, builder, and, and, and, or, or, or, build, result |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/enums/MinecraftVersion.java` | `` |  | ref |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/enums/Platform.java` | `` |  | ref |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/MetaAPIImpl.java` | `` |  | getInstance, initReflection, isPlatformPresent, meta, isClient, isModLoaded, isModLoaded, areModsLoaded, areModsLoaded, lookup, lookupAll, lookupMCV |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/bukkit/BukkitMeta.java` | `` |  | isClient, isModLoaded, areModsLoaded |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/BungeeCordMeta.java` | `` |  | isClient, isModLoaded, areModsLoaded |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/FabricMeta.java` | `` |  | isClient, isModLoaded, areModsLoaded |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/forge/CPWLoaderMeta.java` | `` |  | isClient, isModLoaded, areModsLoaded, toContainer |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/forge/FMLLoaderMeta.java` | `` |  | isClient, isModLoaded, areModsLoaded |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/forge/ForgeData.java` | `` |  | create |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/forge/ForgeVersion_13_16.java` | `` |  | forgeVersion |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/forge/ForgeVersion_17_21.java` | `` |  | forgeVersion |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/forge/ForgeVersion_7_12.java` | `` |  | forgeVersion |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/forge/MCFLoaderMeta.java` | `` |  | isClient, isModLoaded, areModsLoaded, toContainer |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/IgniteMeta.java` | `` |  | isClient, isModLoaded, areModsLoaded |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/ModContainerImpl.java` | `` |  | parseRange |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/ModInfoImpl.java` | `` |  | parseRange |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/ModResourceImpl.java` | `` |  | close, provider, close, isOpen, isReadOnly, getSeparator, getRootDirectories, getFileStores, supportedFileAttributeViews, getPathMatcher, getUserPrincipalLookupService, newWatchService, closeDelegate |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/neoforge/NeoForgeData.java` | `` |  | dist, versionInfo |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/NeoForgeMeta.java` | `` |  | isClient, isModLoaded, areModsLoaded |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/sponge/SpongeData.java` | `` |  | create |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/sponge/SpongeLegacyMeta.java` | `` |  | isClient, isModLoaded, areModsLoaded |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/sponge/SpongeModernMeta.java` | `` |  | isClient, isModLoaded, areModsLoaded |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/VanillaMeta.java` | `` |  | setServer, isClient, isModLoaded, areModsLoaded |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/meta/VelocityMeta.java` | `` | Inject:1 | isClient, isModLoaded, areModsLoaded |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/platform/PlatformImpl.java` | `` |  | name, detect, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/version/meta/MetaStore.java` | `` |  | getMeta |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/version/meta/MinecraftVersionMetaImpl.java` | `` |  | protocol, protocolType, type, dataVersion, resourcePackFormat, dataPackFormat |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/version/MinecraftVersionImpl.java` | `` |  | of, equals |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/version/provider/BungeeCordMCVProvider.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/version/provider/FabricMCVProvider.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/version/provider/ForgeCPWMCVProvider.java` | `` |  | shouldProvide |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/version/provider/ForgeFMLMCVProvider.java` | `` |  | shouldProvide |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/version/provider/ForgeMCFMCVProvider.java` | `` |  | shouldProvide |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/version/provider/NeoForgeMCVProvider.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/version/provider/PaperMCVProvider.java` | `` |  | shouldProvide |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/version/provider/SpongeLegacyMCVProvider.java` | `` |  | shouldProvide |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/version/provider/SpongeModernMCVProvider.java` | `` |  | shouldProvide |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/version/provider/VanillaMCVProvider.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/version/provider/VelocityMCVProvider.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/WMinecraft.java` | `` |  | getInstance, hasServer, getServer, determineSide |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/impl/WMinecraftServer.java` | `` |  | isDedicatedServer |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/Mappings.java` | `` |  | is, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/MetaAPI.java` | `` |  | instance, isBukkitBased, isBungeeCordBased, isFabricBased, isFabricHybrid, isForgeBased, isForgeHybrid, isNeoForgeBased, isNeoForgeHybrid, isHybrid |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/MinecraftVersion.java` | `` |  | of, fromInt |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/MinecraftVersions.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/ModContainer.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/ModInfo.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/ModResource.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/platform/Bukkit.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/platform/BungeeCord.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/platform/Fabric.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/platform/Forge.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/platform/Hybrid.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/platform/Misc.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/platform/Sponge.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/platform/Vanilla.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/platform/Velocity.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/Platform.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/Platforms.java` | `` |  | get, detectPlatforms, detectPrimary, layerPlatforms |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/ProtocolType.java` | `` |  | fromInt |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/Side.java` | `` |  | isClient, isServer, is |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/version/Alpha.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/version/Beta.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/version/Calver.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/version/Classic.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/version/Indev.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/version/Infdev.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/version/PreClassic.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/version/Release.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/meta/version/VersionComparable.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/mixin/CancellableMixin.java` | `` |  | cancelled, setCancelled, unwrap |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/reflecto/MappingEntry.java` | `` |  | MappingEntry, builder, parentEntry, parentEntry, parentEntry, version, versionRange, official, official, official, mojang, mojang, mojang, spigot, spigot, spigot, legacySpigot, legacySpigot, legacySpigot, searge, searge, searge, legacySearge, legacySearge, legacySearge, mcp, mcp, mcp, yarn, yarn, yarn, yarnIntermediary, yarnIntermediary, yarnIntermediary, legacyIntermediary, legacyIntermediary, legacyIntermediary, babricIntermediary, babricIntermediary, babricIntermediary, calamus, calamus, calamus, hashed, hashed, hashed, build |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/reflecto/Reflecto.java` | `` |  | instance, getStore, getStore, registerClass, registerClass, registerField, registerField, registerMethod, registerMethod, getClass, getField, getStaticField, invokeMethod, invokeStaticMethod |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/registries/AdapterRegistry.java` | `` |  | register, getTo, getFrom, get |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/registries/WrapperRegistry.java` | `` |  | register, wrap |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/serialization/Codec.java` | `` |  | of, encode, decode |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/serialization/codecs/ReversibleCodec.java` | `` |  | encode, decode |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/serialization/Decoder.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/serialization/Encoder.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/serialization/Result.java` | `` |  | success, error, error, unwrap, isSuccess, result, error, unwrap, isSuccess, result, error |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/util/FlexVerComparator.java` | `` |  | compareTo, compare, isAsciiDigit, createComponent, get, codepoints, compareTo, toString, compareTo, removeLeadingZeroes, compareTo |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/util/MixinServiceUtil.java` | `` |  | mcVersion, parseMcJson, checkForClass, checkForMethod, checkForOldMixin, checkForOldMixinClass |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/util/PathUtils.java` | `` |  | getCurrentWorkingDirectory, getModsFolder, getConfigFolder, getPluginsFolder |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/util/ReflectionUtil.java` | `` |  | checkForClass, checkForMethod |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/util/TextUtil.java` | `` |  | ansiParser, substituteSectionSign |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/util/VersionUtil.java` | `` |  | Range, resolve |
| top-level / `com/github/tatercertified/potatoptimize/shaded/dev/neuralnexus/taterapi/Wrapped.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/ANTLRErrorListener.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/ANTLRErrorStrategy.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/ANTLRFileStream.java` | `` |  | load, getSourceName |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/ANTLRInputStream.java` | `` |  | load, reset, consume, LA, LT, index, size, mark, release, seek, getText, getSourceName, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/AbstractPredicateTransition.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/ActionTransition.java` | `` |  | getSerializationType, isEpsilon, matches, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/AmbiguityInfo.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/ArrayPredictionContext.java` | `` |  | isEmpty, size, getParent, getReturnState, equals, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/ATN.java` | `` |  | nextTokens, nextTokens, addState, removeState, defineDecisionState, getDecisionState, getNumberOfDecisions, getExpectedTokens |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/ATNConfig.java` | `` |  | getOuterContextDepth, isPrecedenceFilterSuppressed, setPrecedenceFilterSuppressed, equals, equals, hashCode, toString, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/ATNConfigSet.java` | `` |  | add, add, elements, getStates, getAlts, getPredicates, get, optimizeConfigs, addAll, equals, hashCode, size, isEmpty, contains, containsFast, iterator, clear, isReadonly, setReadonly, toString, toArray, toArray, remove, containsAll, retainAll, removeAll, asElementType, createBuckets, createBucket, hashCode, equals |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/ATNDeserializationOptions.java` | `` |  | getDefaultOptions, isReadOnly, makeReadOnly, isVerifyATN, setVerifyATN, isGenerateRuleBypassTransitions, setGenerateRuleBypassTransitions, throwIfReadOnly |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/ATNDeserializer.java` | `` |  | deserialize, deserialize, deserializeSets, markPrecedenceDecisions, verifyATN, checkCondition, checkCondition, toInt, toInt32, toInt32, edgeFactory, stateFactory, lexerActionFactory, encodeIntsWith16BitWords, decodeIntsEncodedAs16BitWords, decodeIntsEncodedAs16BitWords |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/ATNSerializer.java` | `` |  | serialize, addPreamble, addLexerActions, addDecisionStartStates, addEdges, addSets, addModeStartStates, addRuleStatesAndLexerTokenTypes, addPrecedenceStates, addNonGreedyStates, addEdges, serializeSets, getSerialized |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/ATNSimulator.java` | `` |  | clearDFA, getSharedContextCache, getCachedContext |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/ATNState.java` | `` |  | hashCode, equals, isNonGreedyExitState, toString, getTransitions, getNumberOfTransitions, addTransition, addTransition, transition, setTransition, removeTransition, onlyHasEpsilonTransitions, setRuleIndex |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/ATNType.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/AtomTransition.java` | `` |  | getSerializationType, label, matches, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/BasicBlockStartState.java` | `` |  | getStateType |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/BasicState.java` | `` |  | getStateType |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/BlockEndState.java` | `` |  | getStateType |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/BlockStartState.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/CodePointTransitions.java` | `` |  | createWithCodePoint, createWithCodePointRange |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/ContextSensitivityInfo.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/DecisionEventInfo.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/DecisionInfo.java` | `` |  | toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/DecisionState.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/EmptyPredictionContext.java` | `` |  | isEmpty, size, getParent, getReturnState, equals, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/EpsilonTransition.java` | `` |  | outermostPrecedenceReturn, getSerializationType, isEpsilon, matches, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/ErrorInfo.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/LexerAction.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/LexerActionExecutor.java` | `` |  | append, fixOffsetBeforeMatch, getLexerActions, execute, hashCode, equals |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/LexerActionType.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/LexerATNConfig.java` | `` |  | getLexerActionExecutor, hasPassedThroughNonGreedyDecision, hashCode, equals, checkNonGreedyDecision |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/LexerATNSimulator.java` | `` |  | copyState, match, reset, clearDFA, matchATN, execATN, getExistingTargetState, computeTargetState, failOrAccept, getReachableConfigSet, accept, getReachableTarget, computeStartState, closure, getEpsilonTarget, evaluatePredicate, captureSimState, addDFAEdge, addDFAEdge, addDFAState, getDFA, getText, getLine, setLine, getCharPositionInLine, setCharPositionInLine, consume, getTokenName, reset |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/LexerChannelAction.java` | `` |  | getChannel, getActionType, isPositionDependent, execute, hashCode, equals, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/LexerCustomAction.java` | `` |  | getRuleIndex, getActionIndex, getActionType, isPositionDependent, execute, hashCode, equals |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/LexerIndexedCustomAction.java` | `` |  | getOffset, getAction, getActionType, isPositionDependent, execute, hashCode, equals |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/LexerModeAction.java` | `` |  | getMode, getActionType, isPositionDependent, execute, hashCode, equals, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/LexerMoreAction.java` | `` |  | getActionType, isPositionDependent, execute, hashCode, equals, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/LexerPopModeAction.java` | `` |  | getActionType, isPositionDependent, execute, hashCode, equals, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/LexerPushModeAction.java` | `` |  | getMode, getActionType, isPositionDependent, execute, hashCode, equals, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/LexerSkipAction.java` | `` |  | getActionType, isPositionDependent, execute, hashCode, equals, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/LexerTypeAction.java` | `` |  | getType, getActionType, isPositionDependent, execute, hashCode, equals, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/LL1Analyzer.java` | `` |  | getDecisionLookahead, LOOK, LOOK, _LOOK |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/LookaheadEventInfo.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/LoopEndState.java` | `` |  | getStateType |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/NotSetTransition.java` | `` |  | getSerializationType, matches, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/OrderedATNConfigSet.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/ParseInfo.java` | `` |  | getDecisionInfo, getLLDecisions, getTotalTimeInPrediction, getTotalSLLLookaheadOps, getTotalLLLookaheadOps, getTotalSLLATNLookaheadOps, getTotalLLATNLookaheadOps, getTotalATNLookaheadOps, getDFASize, getDFASize |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/ParserATNSimulator.java` | `` |  | reset, clearDFA, adaptivePredict, execATN, getExistingTargetState, computeTargetState, predicateDFAState, execATNWithFullContext, computeReachSet, removeAllConfigsNotInRuleStopState, computeStartState, applyPrecedenceFilter, getReachableTarget, getPredsForAmbigAlts, getPredicatePredictions, getSynValidOrSemInvalidAltThatFinishedDecisionEntryRule, getAltThatFinishedDecisionEntryRule, splitAccordingToSemanticValidity, evalSemanticContext, evalSemanticContext, closure, closureCheckingStopState, closure_, canDropLoopEntryEdgeInLeftRecursiveRule, getRuleName, getEpsilonTarget, actionTransition, precedenceTransition, predTransition, ruleTransition, getConflictingAlts, getConflictingAltsOrUniqueAlt, getTokenName, getLookaheadName, dumpDeadEndConfigs, noViableAlt, getUniqueAlt, addDFAEdge, addDFAState, reportAttemptingFullContext, reportContextSensitivity, reportAmbiguity, setPredictionMode, getPredictionMode, getParser, getSafeEnv, run |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/PlusBlockStartState.java` | `` |  | getStateType |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/PlusLoopbackState.java` | `` |  | getStateType |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/PrecedencePredicateTransition.java` | `` |  | getSerializationType, isEpsilon, matches, getPredicate, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/PredicateEvalInfo.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/PredicateTransition.java` | `` |  | getSerializationType, isEpsilon, matches, getPredicate, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/PredictionContext.java` | `` |  | fromRuleContext, isEmpty, hasEmptyPath, hashCode, calculateEmptyHashCode, calculateHashCode, calculateHashCode, merge, mergeSingletons, mergeRoot, mergeArrays, combineCommonParents, toDOTString, compare, getCachedContext, getAllContextNodes, getAllContextNodes_, toString, toStrings, toStrings |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/PredictionContextCache.java` | `` |  | add, get, size |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/PredictionMode.java` | `` |  | hasSLLConflictTerminatingPrediction, hasConfigInRuleStopState, allConfigsInRuleStopStates, resolvesToJustOneViableAlt, allSubsetsConflict, hasNonConflictingAltSet, hasConflictingAltSet, allSubsetsEqual, getUniqueAlt, getAlts, getAlts, getConflictingAltSubsets, getStateToAltMap, hasStateAssociatedWithOneAlt, getSingleViableAlt, hashCode, equals |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/ProfilingATNSimulator.java` | `` |  | adaptivePredict, getExistingTargetState, computeTargetState, computeReachSet, evalSemanticContext, reportAttemptingFullContext, reportContextSensitivity, reportAmbiguity, getDecisionInfo, getCurrentState |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/RangeTransition.java` | `` |  | getSerializationType, label, matches, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/RuleStartState.java` | `` |  | getStateType |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/RuleStopState.java` | `` |  | getStateType |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/RuleTransition.java` | `` |  | getSerializationType, isEpsilon, matches |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/SemanticContext.java` | `` |  | evalPrecedence, and, or, filterPrecedencePredicates, getOperands, equals, hashCode, eval, evalPrecedence, toString, getOperands, equals, hashCode, eval, evalPrecedence, toString, eval, evalPrecedence, compareTo, hashCode, equals, toString, eval, hashCode, equals, toString, eval |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/SetTransition.java` | `` |  | getSerializationType, label, matches, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/SingletonPredictionContext.java` | `` |  | create, size, getParent, getReturnState, equals, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/StarBlockStartState.java` | `` |  | getStateType |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/StarLoopbackState.java` | `` |  | getLoopEntryState, getStateType |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/StarLoopEntryState.java` | `` |  | getStateType |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/TokensStartState.java` | `` |  | getStateType |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/Transition.java` | `` |  | isEpsilon, label |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/atn/WildcardTransition.java` | `` |  | getSerializationType, matches, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/BailErrorStrategy.java` | `` |  | recover, recoverInline, sync |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/BaseErrorListener.java` | `` |  | syntaxError, reportAmbiguity, reportAttemptingFullContext, reportContextSensitivity |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/BufferedTokenStream.java` | `` |  | getTokenSource, index, mark, release, reset, seek, size, consume, sync, fetch, get, get, LA, LB, LT, adjustSeekIndex, lazyInit, setup, setTokenSource, getTokens, getTokens, getTokens, getTokens, nextTokenOnChannel, previousTokenOnChannel, getHiddenTokensToRight, getHiddenTokensToRight, getHiddenTokensToLeft, getHiddenTokensToLeft, filterForChannel, getSourceName, getText, getText, getText, getText, fill |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/CharStream.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/CharStreams.java` | `` |  | fromPath, fromPath, fromFileName, fromFileName, fromStream, fromStream, fromStream, fromChannel, fromChannel, fromReader, fromReader, fromString, fromString, fromChannel, fromChannel |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/CodePointBuffer.java` | `` |  | withBytes, withChars, withInts, position, position, remaining, get, builder, build, roundUpToNextPowerOfTwo, ensureRemaining, append, appendArray, appendArrayByte, appendArrayChar, appendArrayInt, byteToCharBuffer, byteToIntBuffer, charToIntBuffer |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/CodePointCharStream.java` | `` |  | fromBuffer, fromBuffer, consume, index, size, mark, release, seek, getSourceName, toString, getText, LA, getText, LA, getText, LA |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/CommonToken.java` | `` |  | getType, setLine, getText, setText, getLine, getCharPositionInLine, setCharPositionInLine, getChannel, setChannel, setType, getStartIndex, setStartIndex, getStopIndex, setStopIndex, getTokenIndex, setTokenIndex, getTokenSource, getInputStream, toString, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/CommonTokenFactory.java` | `` |  | create, create |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/CommonTokenStream.java` | `` |  | adjustSeekIndex, LB, LT, getNumberOfOnChannelTokens |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/ConsoleErrorListener.java` | `` |  | syntaxError |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/DefaultErrorStrategy.java` | `` |  | reset, beginErrorCondition, inErrorRecoveryMode, endErrorCondition, reportMatch, reportError, recover, sync, reportNoViableAlternative, reportInputMismatch, reportFailedPredicate, reportUnwantedToken, reportMissingToken, recoverInline, singleTokenInsertion, singleTokenDeletion, getMissingSymbol, getExpectedTokens, getTokenErrorDisplay, getSymbolText, getSymbolType, escapeWSAndQuote, getErrorRecoverySet, consumeUntil |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/dfa/DFA.java` | `` |  | isPrecedenceDfa, getPrecedenceStartState, setPrecedenceStartState, setPrecedenceDfa, getStates, compare, toString, toString, toString, toLexerString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/dfa/DFASerializer.java` | `` |  | toString, getEdgeLabel, getStateString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/dfa/DFAState.java` | `` |  | getAltSet, hashCode, equals, toString, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/dfa/LexerDFASerializer.java` | `` |  | getEdgeLabel |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/DiagnosticErrorListener.java` | `` |  | reportAmbiguity, reportAttemptingFullContext, reportContextSensitivity, getDecisionDescription, getConflictingAlts |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/FailedPredicateException.java` | `` |  | getRuleIndex, getPredIndex, getPredicate, formatMessage |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/InputMismatchException.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/InterpreterRuleContext.java` | `` |  | getRuleIndex |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/IntStream.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/Lexer.java` | `` |  | reset, nextToken, skip, more, mode, pushMode, popMode, setTokenFactory, getTokenFactory, setInputStream, getSourceName, getInputStream, emit, emit, emitEOF, getLine, getCharPositionInLine, setLine, setCharPositionInLine, getCharIndex, getText, setText, getToken, setToken, setType, getType, setChannel, getChannel, getChannelNames, getModeNames, getTokenNames, getAllTokens, recover, notifyListeners, getErrorDisplay, getErrorDisplay, getCharErrorDisplay, recover |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/LexerInterpreter.java` | `` |  | getATN, getGrammarFileName, getTokenNames, getRuleNames, getChannelNames, getModeNames, getVocabulary |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/LexerNoViableAltException.java` | `` |  | getStartIndex, getDeadEndConfigs, getInputStream, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/ListTokenSource.java` | `` |  | getCharPositionInLine, nextToken, getLine, getInputStream, getSourceName, setTokenFactory, getTokenFactory |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/AbstractEqualityComparator.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/Array2DHashSet.java` | `` |  | getOrAdd, getOrAddImpl, get, getBucket, hashCode, equals, expand, add, size, isEmpty, contains, containsFast, iterator, toArray, toArray, remove, removeFast, containsAll, addAll, retainAll, removeAll, clear, toString, toTableString, asElementType, createBuckets, createBucket, hasNext, next, remove |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/DoubleKeyMap.java` | `` |  | put, get, get, values, keySet, keySet |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/EqualityComparator.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/FlexibleHashMap.java` | `` |  | createEntryListArray, getBucket, get, put, remove, putAll, keySet, values, entrySet, containsKey, containsValue, hashCode, equals, expand, size, isEmpty, clear, toString, toTableString, main, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/IntegerList.java` | `` |  | add, addAll, addAll, addAll, get, contains, set, removeAt, removeRange, isEmpty, size, trimToSize, clear, toArray, sort, equals, hashCode, toString, binarySearch, binarySearch, ensureCapacity, toCharArray, charArraySize |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/IntegerStack.java` | `` |  | push, pop, peek |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/InterpreterDataReader.java` | `` |  | parseFile |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/Interval.java` | `` |  | of, length, equals, hashCode, startsBeforeDisjoint, startsBeforeNonDisjoint, startsAfter, startsAfterDisjoint, startsAfterNonDisjoint, disjoint, adjacent, properlyContains, union, intersection, differenceNotProperlyContained, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/IntervalSet.java` | `` |  | of, of, clear, add, add, add, or, addAll, complement, complement, subtract, subtract, or, and, contains, isNil, getMaxElement, getMinElement, getIntervals, hashCode, equals, toString, toString, toString, toString, elementName, elementName, size, toIntegerList, toList, toSet, get, toArray, remove, isReadonly, setReadonly |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/IntSet.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/LogManager.java` | `` |  | log, log, save, save, toString, main, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/MultiMap.java` | `` |  | map, getPairs |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/MurmurHash.java` | `` |  | initialize, initialize, update, update, finish, hashCode |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/NotNull.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/ObjectEqualityComparator.java` | `` |  | hashCode, equals |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/OrderedHashSet.java` | `` |  | get, set, remove, add, remove, clear, hashCode, equals, iterator, elements, clone, toArray, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/Pair.java` | `` |  | equals, hashCode, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/ParseCancellationException.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/Predicate.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/TestRig.java` | `` |  | main |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/Triple.java` | `` |  | equals, hashCode, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/misc/Utils.java` | `` |  | join, join, numNonnull, removeAllElements, escapeWhitespace, writeFile, writeFile, readFile, readFile, toMap, toCharArray, toSet, expandTabs, spaces, newlines, sequence, count |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/NoViableAltException.java` | `` |  | getStartToken, getDeadEndConfigs |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/Parser.java` | `` |  | reset, match, matchWildcard, setBuildParseTree, getBuildParseTree, setTrimParseTree, getTrimParseTree, getParseListeners, addParseListener, removeParseListener, removeParseListeners, triggerEnterRuleEvent, triggerExitRuleEvent, getNumberOfSyntaxErrors, getTokenFactory, setTokenFactory, getATNWithBypassAlts, compileParseTreePattern, compileParseTreePattern, getErrorHandler, setErrorHandler, getInputStream, setInputStream, getTokenStream, setTokenStream, getCurrentToken, notifyErrorListeners, notifyErrorListeners, consume, createTerminalNode, createErrorNode, addContextToParseTree, enterRule, exitRule, enterOuterAlt, getPrecedence, enterRecursionRule, enterRecursionRule, pushNewRecursionContext, unrollRecursionContexts, getInvokingContext, getContext, setContext, precpred, inContext, isExpectedToken, isMatchedEOF, getExpectedTokens, getExpectedTokensWithinCurrentRule, getRuleIndex, getRuleContext, getRuleInvocationStack, getRuleInvocationStack, getDFAStrings, dumpDFA, dumpDFA, getSourceName, getParseInfo, setProfile, setTrace, isTrace, enterEveryRule, visitTerminal, visitErrorNode, exitEveryRule, enterEveryRule, visitTerminal, visitErrorNode, exitEveryRule |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/ParserInterpreter.java` | `` |  | reset, getATN, getTokenNames, getVocabulary, getRuleNames, getGrammarFileName, parse, enterRecursionRule, getATNState, visitState, visitDecisionState, createInterpreterRuleContext, visitRuleStopState, addDecisionOverride, getOverrideDecisionRoot, recover, recoverInline, getRootContext |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/ParserRuleContext.java` | `` |  | copyFrom, enterRule, exitRule, addAnyChild, addChild, addChild, addErrorNode, addChild, addErrorNode, removeLastChild, getParent, getChild, getChild, getToken, getTokens, getRuleContext, getRuleContexts, getChildCount, getSourceInterval, getStart, getStop, toInfoString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/ProxyErrorListener.java` | `` |  | syntaxError, reportAmbiguity, reportAttemptingFullContext, reportContextSensitivity |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/RecognitionException.java` | `` |  | getOffendingState, setOffendingState, getExpectedTokens, getCtx, getInputStream, getOffendingToken, setOffendingToken, getRecognizer |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/Recognizer.java` | `` |  | getVocabulary, getTokenTypeMap, getRuleIndexMap, getTokenType, getSerializedATN, getInterpreter, getParseInfo, setInterpreter, getErrorHeader, getTokenErrorDisplay, addErrorListener, removeErrorListener, removeErrorListeners, getErrorListeners, getErrorListenerDispatch, sempred, precpred, action, getState, setState |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/RuleContext.java` | `` |  | depth, isEmpty, getSourceInterval, getRuleContext, getParent, getPayload, getText, getRuleIndex, getAltNumber, setAltNumber, setParent, getChild, getChildCount, accept, toStringTree, toStringTree, toStringTree, toString, toString, toString, toString, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/RuleContextWithAltNum.java` | `` |  | getAltNumber, setAltNumber |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/RuntimeMetaData.java` | `` |  | getRuntimeVersion, checkVersion, getMajorMinorVersion |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/Token.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/TokenFactory.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/TokenSource.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/TokenStream.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/TokenStreamRewriter.java` | `` |  | getTokenStream, rollback, rollback, deleteProgram, deleteProgram, insertAfter, insertAfter, insertAfter, insertAfter, insertBefore, insertBefore, insertBefore, insertBefore, replace, replace, replace, replace, replace, replace, delete, delete, delete, delete, delete, delete, getLastRewriteTokenIndex, getLastRewriteTokenIndex, setLastRewriteTokenIndex, getProgram, initializeProgram, getText, getText, getText, getText, reduceToSingleOperationPerIndex, catOpText, getKindOfOps, execute, toString, execute, execute, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/AbstractParseTreeVisitor.java` | `` |  | visit, visitChildren, visitTerminal, visitErrorNode, defaultResult, aggregateResult, shouldVisitNextChild |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/ErrorNode.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/ErrorNodeImpl.java` | `` |  | accept |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/IterativeParseTreeWalker.java` | `` |  | walk |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/ParseTree.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/ParseTreeListener.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/ParseTreeProperty.java` | `` |  | get, put, removeFrom |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/ParseTreeVisitor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/ParseTreeWalker.java` | `` |  | walk, enterRule, exitRule |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/pattern/Chunk.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/pattern/ParseTreeMatch.java` | `` |  | get, getAll, getLabels, getMismatchedNode, succeeded, getPattern, getTree, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/pattern/ParseTreePattern.java` | `` |  | match, matches, findAll, getMatcher, getPattern, getPatternRuleIndex, getPatternTree |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/pattern/ParseTreePatternMatcher.java` | `` |  | setDelimiters, matches, matches, match, match, compile, getLexer, getParser, matchImpl, getRuleTagToken, tokenize, split |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/pattern/RuleTagToken.java` | `` |  | getRuleName, getLabel, getChannel, getText, getType, getLine, getCharPositionInLine, getTokenIndex, getStartIndex, getStopIndex, getTokenSource, getInputStream, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/pattern/TagChunk.java` | `` |  | getTag, getLabel, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/pattern/TextChunk.java` | `` |  | getText, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/pattern/TokenTagToken.java` | `` |  | getTokenName, getLabel, getText, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/RuleNode.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/SyntaxTree.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/TerminalNode.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/TerminalNodeImpl.java` | `` |  | getChild, getSymbol, getParent, setParent, getPayload, getSourceInterval, getChildCount, accept, getText, toStringTree, toString, toStringTree |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/Tree.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/Trees.java` | `` |  | toStringTree, toStringTree, toStringTree, getNodeText, getNodeText, getChildren, getAncestors, isAncestorOf, findAllTokenNodes, findAllRuleNodes, findAllNodes, _findAllNodes, getDescendants, descendants, getRootOfSubtreeEnclosingRegion, stripChildrenOutOfRange, findNodeSuchThat |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/xpath/XPath.java` | `` |  | split, recover, getXPathElement, findAll, evaluate |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/xpath/XPathElement.java` | `` |  | toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/xpath/XPathLexer.java` | `` |  | getGrammarFileName, getRuleNames, getModeNames, getTokenNames, getVocabulary, getATN, nextToken, consume, getCharPositionInLine, matchID, matchString, isNameChar, isNameStartChar |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/xpath/XPathLexerErrorListener.java` | `` |  | syntaxError |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/xpath/XPathRuleAnywhereElement.java` | `` |  | evaluate |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/xpath/XPathRuleElement.java` | `` |  | evaluate |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/xpath/XPathTokenAnywhereElement.java` | `` |  | evaluate |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/xpath/XPathTokenElement.java` | `` |  | evaluate |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/xpath/XPathWildcardAnywhereElement.java` | `` |  | evaluate |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/tree/xpath/XPathWildcardElement.java` | `` |  | evaluate |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/UnbufferedCharStream.java` | `` |  | consume, sync, fill, nextChar, add, LA, mark, release, index, seek, size, getSourceName, getText, getBufferStartIndex |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/UnbufferedTokenStream.java` | `` |  | get, LT, LA, getTokenSource, getText, getText, getText, consume, sync, fill, add, mark, release, index, seek, size, getSourceName, getText, getBufferStartIndex |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/Vocabulary.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/VocabularyImpl.java` | `` |  | fromTokenNames, getMaxTokenType, getLiteralName, getSymbolicName, getDisplayName, getLiteralNames, getSymbolicNames, getDisplayNames |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/antlr/v4/runtime/WritableToken.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/builder/qual/CalledMethods.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/builder/qual/NotCalledMethods.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/builder/qual/ReturnsReceiver.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/calledmethods/qual/CalledMethods.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/calledmethods/qual/CalledMethodsBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/calledmethods/qual/CalledMethodsPredicate.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/calledmethods/qual/EnsuresCalledMethods.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/calledmethods/qual/EnsuresCalledMethodsIf.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/calledmethods/qual/EnsuresCalledMethodsVarArgs.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/calledmethods/qual/RequiresCalledMethods.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/compilermsgs/qual/CompilerMessageKey.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/compilermsgs/qual/CompilerMessageKeyBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/compilermsgs/qual/UnknownCompilerMessageKey.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/AwtAlphaCompositingRule.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/AwtColorSpace.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/AwtCursorType.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/AwtFlowLayout.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/Fenum.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/FenumBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/FenumTop.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/FenumUnqualified.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/PolyFenum.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/SwingBoxOrientation.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/SwingCompassDirection.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/SwingElementOrientation.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/SwingHorizontalOrientation.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/SwingSplitPaneOrientation.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/SwingTextOrientation.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/SwingTitleJustification.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/SwingTitlePosition.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/fenum/qual/SwingVerticalOrientation.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/formatter/qual/ConversionCategory.java` | `` |  | fromConversionChar, arrayToSet, isSubsetOf, intersect, union, isAssignableFrom, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/formatter/qual/Format.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/formatter/qual/FormatBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/formatter/qual/FormatMethod.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/formatter/qual/InvalidFormat.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/formatter/qual/ReturnsFormat.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/formatter/qual/UnknownFormat.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/guieffect/qual/AlwaysSafe.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/guieffect/qual/PolyUI.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/guieffect/qual/PolyUIEffect.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/guieffect/qual/PolyUIType.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/guieffect/qual/SafeEffect.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/guieffect/qual/SafeType.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/guieffect/qual/UI.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/guieffect/qual/UIEffect.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/guieffect/qual/UIPackage.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/guieffect/qual/UIType.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/i18n/qual/LocalizableKey.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/i18n/qual/LocalizableKeyBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/i18n/qual/Localized.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/i18n/qual/UnknownLocalizableKey.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/i18n/qual/UnknownLocalized.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/i18nformatter/qual/I18nChecksFormat.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/i18nformatter/qual/I18nConversionCategory.java` | `` |  | stringToI18nConversionCategory, arrayToSet, isSubsetOf, intersect, union, isAssignableFrom, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/i18nformatter/qual/I18nFormat.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/i18nformatter/qual/I18nFormatBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/i18nformatter/qual/I18nFormatFor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/i18nformatter/qual/I18nInvalidFormat.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/i18nformatter/qual/I18nMakeFormat.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/i18nformatter/qual/I18nUnknownFormat.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/i18nformatter/qual/I18nValidFormat.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/EnsuresLTLengthOf.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/EnsuresLTLengthOfIf.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/GTENegativeOne.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/HasSubsequence.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/IndexFor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/IndexOrHigh.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/IndexOrLow.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/LengthOf.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/LessThan.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/LessThanBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/LessThanUnknown.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/LowerBoundBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/LowerBoundUnknown.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/LTEqLengthOf.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/LTLengthOf.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/LTOMLengthOf.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/NegativeIndexFor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/NonNegative.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/PolyIndex.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/PolyLength.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/PolyLowerBound.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/PolySameLen.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/PolyUpperBound.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/Positive.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/SameLen.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/SameLenBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/SameLenUnknown.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/SearchIndexBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/SearchIndexFor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/SearchIndexUnknown.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/SubstringIndexBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/SubstringIndexFor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/SubstringIndexUnknown.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/UpperBoundBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/UpperBoundLiteral.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/index/qual/UpperBoundUnknown.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/initialization/qual/FBCBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/initialization/qual/Initialized.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/initialization/qual/NotOnlyInitialized.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/initialization/qual/UnderInitialization.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/initialization/qual/UnknownInitialization.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/interning/qual/CompareToMethod.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/interning/qual/EqualsMethod.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/interning/qual/FindDistinct.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/interning/qual/Interned.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/interning/qual/InternedDistinct.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/interning/qual/InternMethod.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/interning/qual/PolyInterned.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/interning/qual/UnknownInterned.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/interning/qual/UsesObjectEquals.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/lock/qual/EnsuresLockHeld.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/lock/qual/EnsuresLockHeldIf.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/lock/qual/GuardedBy.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/lock/qual/GuardedByBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/lock/qual/GuardedByUnknown.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/lock/qual/GuardSatisfied.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/lock/qual/Holding.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/lock/qual/LockHeld.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/lock/qual/LockingFree.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/lock/qual/LockPossiblyHeld.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/lock/qual/MayReleaseLocks.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/lock/qual/NewObject.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/lock/qual/ReleasesNoLocks.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/mustcall/qual/CreatesMustCallFor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/mustcall/qual/InheritableMustCall.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/mustcall/qual/MustCall.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/mustcall/qual/MustCallAlias.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/mustcall/qual/MustCallUnknown.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/mustcall/qual/NotOwning.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/mustcall/qual/Owning.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/mustcall/qual/PolyMustCall.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/nullness/qual/AssertNonNullIfNonNull.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/nullness/qual/EnsuresKeyFor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/nullness/qual/EnsuresKeyForIf.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/nullness/qual/EnsuresNonNull.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/nullness/qual/EnsuresNonNullIf.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/nullness/qual/KeyFor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/nullness/qual/KeyForBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/nullness/qual/MonotonicNonNull.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/nullness/qual/NonNull.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/nullness/qual/Nullable.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/nullness/qual/PolyKeyFor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/nullness/qual/PolyNull.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/nullness/qual/RequiresNonNull.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/nullness/qual/UnknownKeyFor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/optional/qual/MaybePresent.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/optional/qual/OptionalBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/optional/qual/PolyPresent.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/optional/qual/Present.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/propkey/qual/PropertyKey.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/propkey/qual/PropertyKeyBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/propkey/qual/UnknownPropertyKey.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/regex/qual/PartialRegex.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/regex/qual/PolyRegex.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/regex/qual/Regex.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/regex/qual/RegexBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/regex/qual/UnknownRegex.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/ArrayWithoutPackage.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/BinaryName.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/BinaryNameOrPrimitiveType.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/BinaryNameWithoutPackage.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/CanonicalName.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/CanonicalNameAndBinaryName.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/CanonicalNameOrEmpty.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/CanonicalNameOrPrimitiveType.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/ClassGetName.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/ClassGetSimpleName.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/DotSeparatedIdentifiers.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/DotSeparatedIdentifiersOrPrimitiveType.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/FieldDescriptor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/FieldDescriptorForPrimitive.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/FieldDescriptorWithoutPackage.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/FqBinaryName.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/FullyQualifiedName.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/Identifier.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/IdentifierOrPrimitiveType.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/InternalForm.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/MethodDescriptor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/PolySignature.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/PrimitiveType.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/SignatureBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signature/qual/SignatureUnknown.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signedness/qual/PolySigned.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signedness/qual/Signed.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signedness/qual/SignednessBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signedness/qual/SignednessGlb.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signedness/qual/SignedPositive.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signedness/qual/SignedPositiveFromUnsigned.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signedness/qual/UnknownSignedness.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/signedness/qual/Unsigned.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/tainting/qual/PolyTainted.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/tainting/qual/Tainted.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/tainting/qual/Untainted.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/A.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/Acceleration.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/Angle.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/Area.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/C.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/cd.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/Current.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/degrees.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/Force.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/g.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/h.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/K.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/kg.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/km.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/km2.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/km3.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/kmPERh.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/kN.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/Length.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/Luminance.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/m.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/m2.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/m3.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/Mass.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/min.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/MixedUnits.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/mm.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/mm2.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/mm3.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/mol.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/mPERs.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/mPERs2.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/N.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/PolyUnit.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/Prefix.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/radians.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/s.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/Speed.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/Substance.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/t.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/Temperature.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/Time.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/UnitsBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/UnitsMultiple.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/UnitsRelations.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/UnknownUnits.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/checker/units/qual/Volume.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/aliasing/qual/LeakedToResult.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/aliasing/qual/MaybeAliased.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/aliasing/qual/MaybeLeaked.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/aliasing/qual/NonLeaked.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/aliasing/qual/Unique.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/initializedfields/qual/EnsuresInitializedFields.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/initializedfields/qual/InitializedFields.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/initializedfields/qual/InitializedFieldsBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/initializedfields/qual/PolyInitializedFields.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/reflection/qual/ClassBound.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/reflection/qual/ClassVal.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/reflection/qual/ClassValBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/reflection/qual/ForName.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/reflection/qual/GetClass.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/reflection/qual/GetConstructor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/reflection/qual/GetMethod.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/reflection/qual/Invoke.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/reflection/qual/MethodVal.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/reflection/qual/MethodValBottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/reflection/qual/NewInstance.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/reflection/qual/UnknownClass.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/reflection/qual/UnknownMethod.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/returnsreceiver/qual/BottomThis.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/returnsreceiver/qual/This.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/returnsreceiver/qual/UnknownThis.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/subtyping/qual/Bottom.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/subtyping/qual/Unqualified.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/util/report/qual/ReportCall.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/util/report/qual/ReportCreation.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/util/report/qual/ReportInherit.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/util/report/qual/ReportOverride.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/util/report/qual/ReportReadWrite.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/util/report/qual/ReportUnqualified.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/util/report/qual/ReportUse.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/util/report/qual/ReportWrite.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/ArrayLen.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/ArrayLenRange.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/BoolVal.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/BottomVal.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/DoubleVal.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/EnsuresMinLenIf.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/EnumVal.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/IntRange.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/IntRangeFromGTENegativeOne.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/IntRangeFromNonNegative.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/IntRangeFromPositive.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/IntVal.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/MatchesRegex.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/MinLen.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/MinLenFieldInvariant.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/PolyValue.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/StaticallyExecutable.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/StringVal.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/common/value/qual/UnknownVal.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/dataflow/qual/Deterministic.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/dataflow/qual/Pure.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/dataflow/qual/SideEffectFree.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/dataflow/qual/TerminatesExecution.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/AnnotatedFor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/CFComment.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/ConditionalPostconditionAnnotation.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/Covariant.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/DefaultFor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/DefaultQualifier.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/DefaultQualifierForUse.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/DefaultQualifierInHierarchy.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/EnsuresQualifier.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/EnsuresQualifierIf.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/FieldInvariant.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/FromByteCode.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/FromStubFile.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/HasQualifierParameter.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/IgnoreInWholeProgramInference.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/InheritedAnnotation.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/InvisibleQualifier.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/JavaExpression.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/LiteralKind.java` | `` |  | allLiteralKinds, primitiveLiteralKinds |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/MonotonicQualifier.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/NoDefaultQualifierForUse.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/NoQualifierParameter.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/PolymorphicQualifier.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/PostconditionAnnotation.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/PreconditionAnnotation.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/PurityUnqualified.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/QualifierArgument.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/QualifierForLiterals.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/RelevantJavaTypes.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/RequiresQualifier.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/StubFiles.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/SubtypeOf.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/TargetLocations.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/TypeKind.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/TypeUseLocation.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/Unused.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/checkerframework/framework/qual/UpperBoundFor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/AccumulatingErrorListener.java` | `` |  | syntaxError, reportError, reportError, getMessage, getTokenName, getExpected, getExpected, isOnlyQuotes |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/ArrayVisitor.java` | `` |  | visitArrayValue, aggregateResult, defaultResult |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/EmptyTomlArray.java` | `` |  | size, isEmpty, containsStrings, containsLongs, containsDoubles, containsBooleans, containsOffsetDateTimes, containsLocalDateTimes, containsLocalDates, containsLocalTimes, containsArrays, containsTables, get, inputPositionOf, toList |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/EmptyTomlTable.java` | `` |  | size, isEmpty, keySet, keyPathSet, entrySet, entryPathSet, toMap |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/ErrorReporter.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/InlineTableVisitor.java` | `` |  | visitKeyval, aggregateResult, defaultResult, defineOpenTables |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/internal/TomlLexer.java` | `` |  | makeRuleNames, makeLiteralNames, makeSymbolicNames, getTokenNames, getVocabulary, inArray, pushValueModeIfInArray, resetArrayDepth, pushArrayDepth, popArrayDepth, getGrammarFileName, getRuleNames, getSerializedATN, getChannelNames, getModeNames, getATN, action, Equals_action, NewLine_action, ValueQuotationMark_action, ValueTripleQuotationMark_action, ValueApostrophe_action, ValueTripleApostrophe_action, DecimalInteger_action, HexInteger_action, OctalInteger_action, BinaryInteger_action, FloatingPoint_action, FloatingPointInf_action, FloatingPointNaN_action, TrueBoolean_action, FalseBoolean_action, DateStart_action, ArrayStart_action, ArrayEnd_action, InlineTableStart_action, BasicStringNewLine_action, MLBasicStringNewLine_action, LiteralStringNewLine_action, MLLiteralStringNewLine_action, DateNewLine_action, DateArrayEnd_action, InlineTableEnd_action, InlineTableNewLine_action, sempred, DecimalInteger_sempred, DateStart_sempred, MLBasicStringSextEnd_sempred, MLBasicStringEnd_sempred, MLLiteralStringSextEnd_sempred, MLLiteralStringEnd_sempred, TimeDelimiter_sempred |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/internal/TomlParser.java` | `` |  | makeRuleNames, makeLiteralNames, makeSymbolicNames, getTokenNames, getVocabulary, getGrammarFileName, getRuleNames, getSerializedATN, getATN, toml, expression, tomlKey, keyval, key, simpleKey, unquotedKey, quotedKey, val, string, basicString, basicChar, basicUnescaped, escaped, mlBasicString, mlBasicChar, mlBasicUnescaped, literalString, literalBody, mlLiteralString, mlLiteralBody, integer, decInt, hexInt, octInt, binInt, floatValue, regularFloat, regularFloatInf, regularFloatNaN, booleanValue, trueBool, falseBool, dateTime, offsetDateTime, localDateTime, localDate, localTime, date, time, timeOffset, hourOffset, minuteOffset, secondFraction, year, month, day, hour, minute, second, array, arrayValues, arrayValue, table, standardTable, inlineTable, inlineTableValues, arrayTable, EOF, NewLine, NewLine, expression, expression, getRuleIndex, enterRule, exitRule, accept, keyval, table, getRuleIndex, enterRule, exitRule, accept, key, Equals, val, getRuleIndex, enterRule, exitRule, accept, standardTable, arrayTable, getRuleIndex, enterRule, exitRule, accept, key, EOF, getRuleIndex, enterRule, exitRule, accept, simpleKey, simpleKey, Dot, Dot, getRuleIndex, enterRule, exitRule, accept, string, integer, floatValue, booleanValue, dateTime, array, inlineTable, getRuleIndex, enterRule, exitRule, accept, quotedKey, unquotedKey, getRuleIndex, enterRule, exitRule, accept, basicString, literalString, getRuleIndex, enterRule, exitRule, accept, UnquotedKey, getRuleIndex, enterRule, exitRule, accept, QuotationMark, QuotationMark, basicChar, basicChar, getRuleIndex, enterRule, exitRule, accept, Apostrophe, Apostrophe, literalBody, getRuleIndex, enterRule, exitRule, accept, mlBasicString, basicString, mlLiteralString, literalString, getRuleIndex, enterRule, exitRule, accept, decInt, hexInt, octInt, binInt, getRuleIndex, enterRule, exitRule, accept, regularFloat, regularFloatInf, regularFloatNaN, getRuleIndex, enterRule, exitRule, accept, trueBool, falseBool, getRuleIndex, enterRule, exitRule, accept, offsetDateTime, localDateTime, localDate, localTime, getRuleIndex, enterRule, exitRule, accept, ArrayStart, ArrayEnd, arrayValues, NewLine, NewLine, Comma, getRuleIndex, enterRule, exitRule, accept, InlineTableStart, InlineTableEnd, inlineTableValues, getRuleIndex, enterRule, exitRule, accept, TripleQuotationMark, TripleQuotationMark, mlBasicChar, mlBasicChar, getRuleIndex, enterRule, exitRule, accept, TripleApostrophe, TripleApostrophe, mlLiteralBody, getRuleIndex, enterRule, exitRule, accept, basicUnescaped, escaped, getRuleIndex, enterRule, exitRule, accept, StringChar, getRuleIndex, enterRule, exitRule, accept, EscapeSequence, getRuleIndex, enterRule, exitRule, accept, mlBasicUnescaped, escaped, getRuleIndex, enterRule, exitRule, accept, StringChar, getRuleIndex, enterRule, exitRule, accept, StringChar, StringChar, getRuleIndex, enterRule, exitRule, accept, StringChar, StringChar, getRuleIndex, enterRule, exitRule, accept, DecimalInteger, getRuleIndex, enterRule, exitRule, accept, HexInteger, getRuleIndex, enterRule, exitRule, accept, OctalInteger, getRuleIndex, enterRule, exitRule, accept, BinaryInteger, getRuleIndex, enterRule, exitRule, accept, FloatingPoint, getRuleIndex, enterRule, exitRule, accept, FloatingPointInf, getRuleIndex, enterRule, exitRule, accept, FloatingPointNaN, getRuleIndex, enterRule, exitRule, accept, TrueBoolean, getRuleIndex, enterRule, exitRule, accept, FalseBoolean, getRuleIndex, enterRule, exitRule, accept, date, TimeDelimiter, time, timeOffset, getRuleIndex, enterRule, exitRule, accept, date, TimeDelimiter, time, getRuleIndex, enterRule, exitRule, accept, date, getRuleIndex, enterRule, exitRule, accept, time, getRuleIndex, enterRule, exitRule, accept, year, Dash, Dash, month, day, getRuleIndex, enterRule, exitRule, accept, hour, Colon, Colon, minute, second, Dot, secondFraction, getRuleIndex, enterRule, exitRule, accept, Z, hourOffset, Colon, minuteOffset, getRuleIndex, enterRule, exitRule, accept, DateDigits, getRuleIndex, enterRule, exitRule, accept, DateDigits, getRuleIndex, enterRule, exitRule, accept, DateDigits, getRuleIndex, enterRule, exitRule, accept, DateDigits, getRuleIndex, enterRule, exitRule, accept, DateDigits, getRuleIndex, enterRule, exitRule, accept, DateDigits, getRuleIndex, enterRule, exitRule, accept, DateDigits, getRuleIndex, enterRule, exitRule, accept, hour, Dash, Plus, getRuleIndex, enterRule, exitRule, accept, DateDigits, getRuleIndex, enterRule, exitRule, accept, arrayValue, arrayValue, Comma, Comma, NewLine, NewLine, getRuleIndex, enterRule, exitRule, accept, val, NewLine, NewLine, getRuleIndex, enterRule, exitRule, accept, TableKeyStart, TableKeyEnd, key, getRuleIndex, enterRule, exitRule, accept, ArrayTableKeyStart, ArrayTableKeyEnd, key, getRuleIndex, enterRule, exitRule, accept, keyval, keyval, Comma, Comma, getRuleIndex, enterRule, exitRule, accept |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/internal/TomlParserBaseListener.java` | `` |  | enterToml, exitToml, enterExpression, exitExpression, enterTomlKey, exitTomlKey, enterKeyval, exitKeyval, enterKey, exitKey, enterSimpleKey, exitSimpleKey, enterUnquotedKey, exitUnquotedKey, enterQuotedKey, exitQuotedKey, enterVal, exitVal, enterString, exitString, enterBasicString, exitBasicString, enterBasicChar, exitBasicChar, enterBasicUnescaped, exitBasicUnescaped, enterEscaped, exitEscaped, enterMlBasicString, exitMlBasicString, enterMlBasicChar, exitMlBasicChar, enterMlBasicUnescaped, exitMlBasicUnescaped, enterLiteralString, exitLiteralString, enterLiteralBody, exitLiteralBody, enterMlLiteralString, exitMlLiteralString, enterMlLiteralBody, exitMlLiteralBody, enterInteger, exitInteger, enterDecInt, exitDecInt, enterHexInt, exitHexInt, enterOctInt, exitOctInt, enterBinInt, exitBinInt, enterFloatValue, exitFloatValue, enterRegularFloat, exitRegularFloat, enterRegularFloatInf, exitRegularFloatInf, enterRegularFloatNaN, exitRegularFloatNaN, enterBooleanValue, exitBooleanValue, enterTrueBool, exitTrueBool, enterFalseBool, exitFalseBool, enterDateTime, exitDateTime, enterOffsetDateTime, exitOffsetDateTime, enterLocalDateTime, exitLocalDateTime, enterLocalDate, exitLocalDate, enterLocalTime, exitLocalTime, enterDate, exitDate, enterTime, exitTime, enterTimeOffset, exitTimeOffset, enterHourOffset, exitHourOffset, enterMinuteOffset, exitMinuteOffset, enterSecondFraction, exitSecondFraction, enterYear, exitYear, enterMonth, exitMonth, enterDay, exitDay, enterHour, exitHour, enterMinute, exitMinute, enterSecond, exitSecond, enterArray, exitArray, enterArrayValues, exitArrayValues, enterArrayValue, exitArrayValue, enterTable, exitTable, enterStandardTable, exitStandardTable, enterInlineTable, exitInlineTable, enterInlineTableValues, exitInlineTableValues, enterArrayTable, exitArrayTable, enterEveryRule, exitEveryRule, visitTerminal, visitErrorNode |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/internal/TomlParserBaseVisitor.java` | `` |  | visitToml, visitExpression, visitTomlKey, visitKeyval, visitKey, visitSimpleKey, visitUnquotedKey, visitQuotedKey, visitVal, visitString, visitBasicString, visitBasicChar, visitBasicUnescaped, visitEscaped, visitMlBasicString, visitMlBasicChar, visitMlBasicUnescaped, visitLiteralString, visitLiteralBody, visitMlLiteralString, visitMlLiteralBody, visitInteger, visitDecInt, visitHexInt, visitOctInt, visitBinInt, visitFloatValue, visitRegularFloat, visitRegularFloatInf, visitRegularFloatNaN, visitBooleanValue, visitTrueBool, visitFalseBool, visitDateTime, visitOffsetDateTime, visitLocalDateTime, visitLocalDate, visitLocalTime, visitDate, visitTime, visitTimeOffset, visitHourOffset, visitMinuteOffset, visitSecondFraction, visitYear, visitMonth, visitDay, visitHour, visitMinute, visitSecond, visitArray, visitArrayValues, visitArrayValue, visitTable, visitStandardTable, visitInlineTable, visitInlineTableValues, visitArrayTable |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/internal/TomlParserListener.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/internal/TomlParserVisitor.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/JsonOptions.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/JsonSerializer.java` | `` |  | toJson, toJson, appendTomlValue, typeName, appendTomlValueLiteral, append, appendLine, indentLine, escape |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/KeyVisitor.java` | `` |  | visitUnquotedKey, visitQuotedKey, aggregateResult, defaultResult |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/LineVisitor.java` | `` |  | visitKeyval, visitStandardTable, visitArrayTable, aggregateResult, defaultResult, defineOpenTables |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/LocalDateVisitor.java` | `` |  | visitYear, visitMonth, visitDay, visitErrorNode, aggregateResult, defaultResult |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/LocalTimeVisitor.java` | `` |  | visitHour, visitMinute, visitSecond, visitSecondFraction, visitErrorNode, aggregateResult, defaultResult |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/MutableHomogeneousTomlArray.java` | `` |  | containsStrings, containsLongs, containsDoubles, containsBooleans, containsOffsetDateTimes, containsLocalDateTimes, containsLocalDates, containsLocalTimes, containsArrays, containsTables, append |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/MutableTomlArray.java` | `` |  | containsStrings, containsLongs, containsDoubles, containsBooleans, containsOffsetDateTimes, containsLocalDateTimes, containsLocalDates, containsLocalTimes, containsArrays, containsTables, size, isEmpty, get, inputPositionOf, toList |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/MutableTomlTable.java` | `` |  | size, isEmpty, keySet, keyPathSet, entrySet, entryPathSet, getElement, toMap, ensureTable |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/Parser.java` | `` |  | size, isEmpty, keySet, keyPathSet, entrySet, entryPathSet, toMap, errors |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/QuotedStringVisitor.java` | `` |  | visitLiteralBody, visitMlLiteralBody, visitBasicUnescaped, visitMlBasicUnescaped, appendText, visitEscaped, convertUnicodeEscape, aggregateResult, defaultResult |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/TokenName.java` | `` |  | displayName |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/Toml.java` | `` |  | parse, parse, parse, parse, parse, parse, parse, parse, parse, parse, parseDottedKey, joinKeyPath, canonicalDottedKey, tomlEscape, equals, equals |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/TomlArray.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/TomlCommand.java` | `` |  | main |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/TomlInvalidTypeException.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/TomlParseError.java` | `` |  | position, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/TomlParseResult.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/TomlPosition.java` | `` |  | positionAt, line, column, equals, hashCode, toString |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/TomlSerializer.java` | `` |  | toToml, toToml, appendTomlValue, append, indentLine, isTableArray |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/TomlTable.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/TomlType.java` | `` |  | typeName |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/TomlVersion.java` | `` |  |  |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/ValueVisitor.java` | `` |  | visitString, visitDecInt, visitHexInt, visitOctInt, visitBinInt, toLong, visitRegularFloat, visitRegularFloatInf, visitRegularFloatNaN, toDouble, visitTrueBool, visitFalseBool, visitOffsetDateTime, visitLocalDateTime, visitLocalDate, visitLocalTime, visitArray, visitInlineTable, aggregateResult, defaultResult |
| top-level / `com/github/tatercertified/potatoptimize/shaded/org/tomlj/ZoneOffsetVisitor.java` | `` |  | visitHourOffset, visitMinuteOffset, toZoneOffset, visitErrorNode, aggregateResult, defaultResult |
| top-level / `com/github/tatercertified/potatoptimize/utils/interfaces/SlimeChunkInterface.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
