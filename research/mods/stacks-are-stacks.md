# Stacks Are Stacks

Review status: **Evidence inventory; behavioral review pending**

Project: [Stacks Are Stacks](https://modrinth.com/mod/stacks-are-stacks)
Selected artifact version: `2.1.5-1.26.3`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Increases stack size for all items to 64, including Shulker Boxes, Totems, Enchanted Books & Potions. Now configurable!

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `04aecf4fb256a5554c3508b3b472a29a387c00911e2455c4e20187ae0c6c6ce3c39d15bfed5be4e330d8fade5142c7b083054a360baa4672000fbb5972a4760b`
- `sha1`: `99e334760d7f7bb8810ea1be85d5fcf8b15e4554`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 13
Reconstructed Java files: 13

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "net.a5ho9999.stacksarestacks.StacksAreStacksMod"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3",
  "java": ">=25",
  "fabric-api": "*"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/thighfigured-1.1.0.jar` | 81 | `thighfigured` | No |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `net/a5ho9999/stacksarestacks/mixin/AbstractFurnaceBlockEntityMixin.java` | `value={AbstractFurnaceBlockEntity.class})` | Inject:2 | stack$tick, stack$consumeFuel |
| top-level / `net/a5ho9999/stacksarestacks/mixin/AnvilScreenHandlerMixin.java` | `value={AnvilMenu.class})` | Redirect:1 | stack$onTakeOutput |
| top-level / `net/a5ho9999/stacksarestacks/mixin/AxolotlEntityMixin.java` | `value={Axolotl.class})` | Redirect:1 | stack$eat |
| top-level / `net/a5ho9999/stacksarestacks/mixin/BrewingStandScreenHandlerMixin.java` | `value={BrewingStandMenu.class})` | Redirect:2 | stack$quickMoveGetPotionCount, stack$quickMoveStackedPotion |
| top-level / `net/a5ho9999/stacksarestacks/mixin/BucketableMixin.java` | `value={Bucketable.class})` | Inject:1 | stack$tryBucket |
| top-level / `net/a5ho9999/stacksarestacks/mixin/BundleItemMixin.java` | `value={BundleItem.class})` | Inject:3 | preventStackedBundleInteraction, preventStackedBundleClick, preventStackedBundleUse |
| top-level / `net/a5ho9999/stacksarestacks/mixin/MusicDiscItemMixin.java` | `value={JukeboxPlayable.class})` | Redirect:1 | stack$useOnBlock |
| top-level / `net/a5ho9999/stacksarestacks/mixin/PowderSnowBucketItemMixin.java` | `value={SolidBucketItem.class})` | Redirect:1 | stack$useOnBlock |
| top-level / `net/a5ho9999/stacksarestacks/mixin/ServerPlayerEntityMixin.java` | `value={ServerPlayer.class})` | Redirect:1 | stack$giveOrDrop |
| top-level / `net/a5ho9999/stacksarestacks/StacksAreStacksConfig.java` | `` |  | modId, registryModId, fileName, titleTranslationKey, titleFallback, accentColor, schema, clampValues, save, load, StackSize, StackSize, AffectAll, AffectAll, Exclude, Exclude, ConsumableFix, ConsumableFix |
| top-level / `net/a5ho9999/stacksarestacks/StacksAreStacksMod.java` | `` |  | onInitialize, setStackSizes |
| top-level / `net/a5ho9999/stacksarestacks/StacksAreStacksModConfig.java` | `` |  |  |
| top-level / `net/a5ho9999/stacksarestacks/util/ItemUtil.java` | `` |  | AddOrDropStackWithDecrease, AddOrDropStack, isMatchedPotion, isMatchedBucket |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
