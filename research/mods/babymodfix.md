# Baby Mob Fix

Review status: **Evidence inventory; behavioral review pending**

Project: [Baby Mob Fix](https://modrinth.com/mod/babymodfix)
Selected artifact version: `1.1.5`
Published implementation source: Not declared in catalogue metadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

With this mod, the textures of baby mobs in Minecraft version 26.1 have been improved and corrected. Their eyes and some textures that some players found disturbing have been corrected.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `7ec7702132463465d61e61c25fcca051747228fb`
- `sha512`: `6793b74689ce4e39bfc6582848ad7093d86cd7d7021f3674859e9649bdb8a97471dfcc68c096e6da2df7ecee95da978983b342f3d9caa20ab24cdd3c975ee230`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 8
Reconstructed Java files: 8

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "levsidorovi.babymobfix.babymobfixmod.BabyMobFix"
  ]
}
```

**depends**

```json
{
  "minecraft": "~26.3",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `levsidorovi/babymobfix/babymobfixmod/BabyMobFix.java` | `` |  | onInitialize |
| top-level / `levsidorovi/babymobfix/babymobfixmod/mixin/BabyDrownedModelFixMixin.java` | `value={BabyDrownedModel.class})` | Inject:1 | fixBabyDrownedArmorHelmet |
| top-level / `levsidorovi/babymobfix/babymobfixmod/mixin/BabyFelineModelMixin.java` | `value={BabyFelineModel.class})` | Inject:1 | fixBabyFelineHead |
| top-level / `levsidorovi/babymobfix/babymobfixmod/mixin/BabyVillagerMixin.java` | `value={BabyVillagerModel.class})` | Inject:1 | fixBabyVillagerHead |
| top-level / `levsidorovi/babymobfix/babymobfixmod/mixin/BabyZombieHeadResizeMixin.java` | `value={BabyZombieModel.class})` | Inject:1 | fixBabyZombieArmorHelmet |
| top-level / `levsidorovi/babymobfix/babymobfixmod/mixin/BabyZombieVillagerHeadResizeMixin.java` | `value={BabyZombieVillagerModel.class})` | Inject:1 | lowerArmsOnly |
| top-level / `levsidorovi/babymobfix/babymobfixmod/mixin/HumanoidModelMixin.java` | `value={HumanoidModel.class})` | Inject:1 | fixBabyZombieHelmet |
| top-level / `levsidorovi/babymobfix/babymobfixmod/ResourcePackManager.java` | `` |  | registerResourcePacks, registerPack, registerResourcePack |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
