# Shield Fixes

Review status: **Evidence inventory; behavioral review pending**

Project: [Shield Fixes](https://modrinth.com/mod/complete-shield-fixes)
Selected artifact version: `2.1.0+26.3`
Published implementation source: https://github.com/Walksy/ShieldFixes
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Resolves issues with shield sounds and corrects the animation glitch where the player's shield doesn't display blocking properly.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `e9ff0735191df995721026f0daa73319d2c914f5`
- `sha512`: `16a85555235357c0c71b3106a236d53871a03d5560db060a7756d83e5cd05ab5da5a22b8e7bf81d8107fd2e62e2e7843832aa9fd64864cb6ac8a93f857293b5c`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 12
Reconstructed Java files: 11

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "main": [
    "walksy.shieldfixes.ShieldFixes"
  ],
  "walksylib": [
    "walksy.shieldfixes.config.ShieldFixesConfig"
  ]
}
```

**depends**

```json
{
  "minecraft": "26.3",
  "java": ">=25",
  "walksylib": ">=2.0.0"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `walksy/shieldfixes/config/ShieldFixesConfig.java` | `` |  | define |
| top-level / `walksy/shieldfixes/interfaze/ILivingEntity.java` | `` |  |  |
| top-level / `walksy/shieldfixes/manager/EnvironmentEffectShieldManager.java` | `` |  | onExplosion, onDisable, onAttack, shieldBlock, shieldBreak, getNearPlayers, sound, WorldExplosion, getMaxDistance, getBoundingBox |
| top-level / `walksy/shieldfixes/manager/ShieldStateManager.java` | `` |  | syncRemoteShieldUse, isUsingShield, isUsingShield, disablesShield |
| top-level / `walksy/shieldfixes/mixin/AvatarRendererMixin.java` | `value={AvatarRenderer.class})` | Inject:1 | setArmPose |
| top-level / `walksy/shieldfixes/mixin/IsUsingItemMixin.java` | `value={IsUsingItem.class})` | Inject:1 | registerShieldItem |
| top-level / `walksy/shieldfixes/mixin/LivingEntityMixin.java` | `value={LivingEntity.class})` | Inject:1 | setActiveItem, setItemUseTime, onByteStatus |
| top-level / `walksy/shieldfixes/mixin/LocalPlayerMixin.java` | `value={LocalPlayer.class})` | Inject:1 | onTick |
| top-level / `walksy/shieldfixes/mixin/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:1 | doAttack |
| top-level / `walksy/shieldfixes/mixin/ServerExplosionMixin.java` | `value={ServerExplosion.class})` | Inject:1 | onExplosion |
| top-level / `walksy/shieldfixes/ShieldFixes.java` | `` |  | onInitialize, getEnvironmentEffectShieldManager |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
