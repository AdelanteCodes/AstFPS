# Ksyxis

Review status: **Evidence inventory; behavioral review pending**

Project: [Ksyxis](https://modrinth.com/mod/ksyxis)
Selected artifact version: `1.4.6`
Published implementation source: https://github.com/VidTu/Ksyxis
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Speed up your world loading by removing unneeded chunks.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `6de6271329e0c83e3ccc0512a0d3cfcc3e790d3f`
- `sha512`: `1571cd9b15b6733002dd164beab4ad1022fab2c904414b39db6fb609a41c48cca394f1751e5634ebc555795d9bd9dba48c2c280c152d9e0f570795d47a91c1d5`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

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
    "ru.vidtu.ksyxis.platform.KFabric"
  ]
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `ru/vidtu/ksyxis/CompatHacks.java` | `` |  |  |
| top-level / `ru/vidtu/ksyxis/mixin/EntityMixin.java` | `targets={"net.minecraft.entity.Entity", "net.minecraft.class_864", "net.minecraft.unmapped.C_0539808"}, remap=false)` | Inject:1 | ksyxis_clinit_return |
| top-level / `ru/vidtu/ksyxis/mixin/LevelMixin.java` | `targets={"net.minecraft.world.World", "net.minecraft.class_1150", "net.minecraft.unmapped.C_5553933"}, remap=false)` | Inject:1 | ksyxis_isSpawnChunk_head |
| top-level / `ru/vidtu/ksyxis/mixin/MinecraftMixin.java` | `targets={"net.minecraft.client.Minecraft", "net.minecraft.client.MinecraftClient", "net.minecraft.class_310"}, remap=false)` | ModifyConstant:1 | ksyxis_doWorldLoad_closeDelayMs |
| top-level / `ru/vidtu/ksyxis/mixin/MinecraftServerMixin.java` | `targets={"net.minecraft.server.MinecraftServer", "net.minecraft.src.C_4977_"}, remap=false)` | ModifyVariable:1, Inject:1, ModifyConstant:3 | ksyxis_prepareLevels_spawnChunkRadius_getInt, ksyxis_prepareLevels_head, ksyxis_prepareLevels_addRegionTicket, ksyxis_prepareLevels_getTickingGenerated, ksyxis_initialWorldChunkLoad_loop |
| top-level / `ru/vidtu/ksyxis/mixin/PrepareSpawnTaskPreparingMixin.java` | `targets={"net.minecraft.server.network.config.PrepareSpawnTask$Preparing", "net.minecraft.server.network.PrepareSpawnTask$LoadPlayerChunks", "net.minecraft.class_11549$class_11550"}, remap=false)` | ModifyConstant:1 | ksyxis_lambdaTick0_addTicketAndLoadWithRadius |
| top-level / `ru/vidtu/ksyxis/mixin/PrepareSpawnTaskReadyMixin.java` | `targets={"net.minecraft.server.network.config.PrepareSpawnTask$Ready", "net.minecraft.server.network.PrepareSpawnTask$PlayerSpawn", "net.minecraft.class_11549$class_11551"}, remap=false)` | ModifyConstant:2 | ksyxis_keepAlive_addTicketAndLoadWithRadius, ksyxis_spawn_waitForEntities |
| top-level / `ru/vidtu/ksyxis/mixin/ServerLevelMixin.java` | `targets={"net.minecraft.server.level.ServerLevel", "net.minecraft.server.world.ServerWorld", "net.minecraft.world.server.ServerWorld", "net.minecraft.class_3218", "net.minecraft.src.C_12_", "net.minecraft.unmapped.C_bdwnwhiu", "net.minecraft.unmapped.C_3865296"}, remap=false)` | ModifyVariable:1, ModifyConstant:1 | ksyxis_setDefaultSpawnPos_spawnChunkRadius_getInt, ksyxis_setDefaultSpawnPos_addRegionTicket |
| top-level / `ru/vidtu/ksyxis/platform/KCore.java` | `` |  | getAccessTransformerClass, getASMTransformerClass, getModContainerClass, getSetupClass, injectData, toString |
| top-level / `ru/vidtu/ksyxis/platform/KFabric.java` | `` |  | onInitialize, toString |
| top-level / `ru/vidtu/ksyxis/platform/KForge.java` | `` |  | toString |
| top-level / `ru/vidtu/ksyxis/platform/KNeoForge.java` | `` |  | toString |
| top-level / `ru/vidtu/ksyxis/platform/KPlugin.java` | `` |  | shouldApplyMixin, onLoad, getRefMapperConfig, acceptTargets, getMixins, preApply, postApply, toString |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
