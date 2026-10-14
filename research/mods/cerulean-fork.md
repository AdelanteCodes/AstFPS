# Cerulean Fork

Review status: **Evidence inventory; behavioral review pending**

Project: [Cerulean Fork](https://modrinth.com/mod/cerulean-fork)
Selected artifact version: `1.0.1`
Published implementation source: https://github.com/noramibu/Cerulean
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Advancements optimization mod, updated fork of Icterine / Cerulean with added features

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `510e8a5d27ffe201b16bd601f081d4c89a1bf33e940da921d7d6eb2ae82f3e1e3a9144aea1d0538f1737133589a8dc336ee6e2abc5be3938ce9215da7b7f014d`
- `sha1`: `137321f1b3886193807d4c7e4e70608f8c1e4ffd`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 25
Reconstructed Java files: 23

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "toni.cerulean.Cerulean"
  ],
  "client": [
    "toni.cerulean.Cerulean"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3 <26.4",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `toni/cerulean/Cerulean.java` | `` |  | onInitialize, onInitializeClient |
| top-level / `toni/cerulean/Common.java` | `` |  | init |
| top-level / `toni/cerulean/foundation/config/AllConfigs.java` | `` |  | client, common, server, byType, register, register, generateTranslations |
| top-level / `toni/cerulean/foundation/config/CClient.java` | `` |  | getName |
| top-level / `toni/cerulean/foundation/config/CCommon.java` | `` |  | getName |
| top-level / `toni/cerulean/foundation/config/CServer.java` | `` |  | getName |
| top-level / `toni/cerulean/foundation/config/RuntimeOptions.java` | `` |  | debugMode, enableSkipTicks, ignoreTriggersForEmptiedStacks, ignoreTriggersForDecreasedStacks, optimizeMultiplePredicateTrigger, initializeInventoryLastSlots, optimizeTriggersForIncreasedStacks, checkCountBeforeItemPredicateMatch |
| top-level / `toni/cerulean/foundation/ReloadListenerHandler.java` | `` |  | getFabricId |
| top-level / `toni/cerulean/iface/IItemPredicateMixin.java` | `` |  |  |
| top-level / `toni/cerulean/iface/IItemStackMixin.java` | `` |  |  |
| top-level / `toni/cerulean/impl/ReloadListenerHandlerBase.java` | `` |  | prepare, apply |
| top-level / `toni/cerulean/impl/StackSizeThresholdManager.java` | `` |  | clear, add, doesStackPassThreshold, debugPrint |
| top-level / `toni/cerulean/mixin/AbstractContainerMenuMixin.java` | `value={AbstractContainerMenu.class})` | Redirect:1, Inject:1 | addSlot, triggerSlotListeners |
| top-level / `toni/cerulean/mixin/InventoryChangeTriggerInstanceMixin.java` | `value={InventoryChangeTrigger.TriggerInstance.class})` | Inject:1, Redirect:1 | matches, itemPredicateMatches |
| top-level / `toni/cerulean/mixin/InventoryChangeTriggerMixin.java` | `value={InventoryChangeTrigger.class})` | Inject:1 | trigger |
| top-level / `toni/cerulean/mixin/ItemPredicateMixin.java` | `value={ItemPredicate.class})` |  | cerulean$fasterMatches |
| top-level / `toni/cerulean/mixin/ItemStackMixin.java` | `value={ItemStack.class})` |  | cerulean$setPreviousStackSize, cerulean$getPreviousStackSize |
| top-level / `toni/cerulean/util/ItemStackUtil.java` | `` |  | processItemStackInTriggerSlotListeners |
| top-level / `toni/cerulean/util/LogHelper.java` | `` |  | debug, debug |
| top-level / `toni/cerulean/util/MixinPlugin.java` | `` |  | onLoad, getRefMapperConfig, shouldApplyMixin, acceptTargets, getMixins, postApply, preApply |
| top-level / `toni/lib/config/ConfigBase.java` | `` |  | group, b, registerAll, onLoad, onReload, loadOrCreateToml, loadToml, saveToml, stripInlineComment, getName, get, set |
| top-level / `toni/lib/utils/PlatformUtils.java` | `` |  | isDedicatedServer |
| top-level / `toni/lib/utils/VersionUtils.java` | `` |  | resource |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
