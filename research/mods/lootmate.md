# LootMate

Review status: **Evidence inventory; behavioral review pending**

Project: [LootMate](https://modrinth.com/mod/lootmate)
Selected artifact version: `1.1.1+26.3`
Published implementation source: https://gitlab.com/LucasEDVK/lootmate
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Never miss the best loot again. Intelligent item beams, inventory highlighting, and advanced weapon/armor stat comparisons with support for custom items and a highly customizable config.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `8de41f7d2d2f052e3210ba175c532997ae43fb566af52f12f1db8dc4fe635fb9966ec8586a3b7fac0470bede998b45edb7942b841021fabe90fad9abaf2eed22`
- `sha1`: `f475a7dd3c374cd2630152e90c06aafd036922ed`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 22
Reconstructed Java files: 15

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "de.lucasedvk.lootmate.client.main.LootMateClient"
  ],
  "main": []
}
```

**depends**

```json
{
  "fabric-api": ">=0.160.6",
  "minecraft": "26.3.*"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/midnightlib-1.9.3+26.3-fabric.jar` | 24 | `midnightlib` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `de/lucasedvk/lootmate/client/commands/LootMateCommand.java` | `` |  | register, extractCount, extractHexColor, suggest |
| top-level / `de/lucasedvk/lootmate/client/events/EditTooltips.java` | `` |  | getTooltip |
| top-level / `de/lucasedvk/lootmate/client/events/RenderBeam.java` | `` |  | afterTranslucentFeatures |
| top-level / `de/lucasedvk/lootmate/client/main/LootMateClient.java` | `` |  | onInitializeClient, newThread, iniForbiddenServers |
| top-level / `de/lucasedvk/lootmate/client/mixin/HotbarHighlighter.java` | `value={Hud.class})` | Inject:1 | highlight |
| top-level / `de/lucasedvk/lootmate/client/mixin/InventoryHighlighter.java` | `value={AbstractContainerScreen.class})` | Inject:1 | highlight |
| top-level / `de/lucasedvk/lootmate/client/mixin/OverlayAccessor.java` | `value={Hud.class})` | Accessor:1 |  |
| top-level / `de/lucasedvk/lootmate/client/mixin/ScreenRenderOrder.java` | `value={AbstractContainerScreen.class})` | Inject:1 | changeOrder, renderContainer, renderInventory |
| top-level / `de/lucasedvk/lootmate/client/objects/BeamData.java` | `` |  |  |
| top-level / `de/lucasedvk/lootmate/client/objects/CustomItem.java` | `` |  |  |
| top-level / `de/lucasedvk/lootmate/client/objects/HighlightData.java` | `` |  |  |
| top-level / `de/lucasedvk/lootmate/client/objects/TypeEnum.java` | `` |  |  |
| top-level / `de/lucasedvk/lootmate/client/runnables/Worker.java` | `` |  | run, handleHotbar, prepareInventoryHighlightingAndHotbarMsg, prepareBeams |
| top-level / `de/lucasedvk/lootmate/client/util/Utils.java` | `` |  | sendMessage, sendHotbar, getBetterItem, getBowValue, getArmorDamage, getWeaponDPS, getWeaponDamage, getWeaponSpeed, getEnchantmentLevel, getBestPlayerWeapon, isBestItem, highlight, isComparable, isWeapon, isArmor, isRelevantCustomItem, updateConfigValue, getFullPlayerInventory, getItemCategory, isRelevantItem, serverShowsHotbar |
| top-level / `de/lucasedvk/lootmate/config/Config.java` | `` |  |  |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
