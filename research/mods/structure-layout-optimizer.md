# Structure Layout Optimizer

Review status: **Evidence inventory; behavioral review pending**

Project: [Structure Layout Optimizer](https://modrinth.com/mod/structure-layout-optimizer)
Selected artifact version: `1.1.4+26.3-fabric`
Published implementation source: https://github.com/TelepathicGrunt/StructureLayoutOptimizer
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Attempts to optimize the generation of Jigsaw Structures and NBT pieces

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha1`: `ce6a03a927297a5441dfa239bf2d6d804931530a`
- `sha512`: `41294726277c99dd6b27fe04ec77ed360349652d1390b6efa00cf255f8230e26c130a6e297b2f23464cf4bd4be9a14d7032a317fada18bae74146955d4ac9caa`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 20
Reconstructed Java files: 18

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "telepathicgrunt.structure_layout_optimizer.fabric.entrypoints.Main"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3",
  "java": ">=25",
  "fabric-api": "*",
  "resourcefulconfig": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `telepathicgrunt/structure_layout_optimizer/fabric/entrypoints/Main.java` | `` |  | onInitialize |
| top-level / `telepathicgrunt/structure_layout_optimizer/fabric/services/FabricPlatformService.java` | `` |  |  |
| top-level / `telepathicgrunt/structure_layout_optimizer/mixins/JigsawPlacementMixin.java` | `value={JigsawPlacement.class})` | WrapOperation:1 | structureLayoutOptimizer$replaceVoxelShape1 |
| top-level / `telepathicgrunt/structure_layout_optimizer/mixins/JigsawPlacementPlacerMixin.java` | `targets={"net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement$Placer"})` | ModifyExpressionValue:2, WrapOperation:1, Redirect:5 | structureLayoutOptimizer$skipBlockedJigsaws, structureLayoutOptimizer$replaceVoxelShape2, structureLayoutOptimizer$replaceVoxelShape3, structureLayoutOptimizer$replaceVoxelShape4, structureLayoutOptimizer$turnOffOldVoxelShapeBehavior1, structureLayoutOptimizer$removeDuplicateTemplatePoolElementLists, structureLayoutOptimizer$skipDuplicateTemplatePoolElementLists1, structureLayoutOptimizer$skipDuplicateTemplatePoolElementLists2 |
| top-level / `telepathicgrunt/structure_layout_optimizer/mixins/SinglePoolElementMixin.java` | `value={SinglePoolElement.class})` | Redirect:2 | structureLayoutOptimizer$fasterJigsawListShuffling1, structureLayoutOptimizer$fasterJigsawListShuffling2 |
| top-level / `telepathicgrunt/structure_layout_optimizer/mixins/StructureTemplateMixin.java` | `value={StructureTemplate.class})` | Redirect:1 | structureLayoutOptimizer$shrinkStructureTemplateBlocksList |
| top-level / `telepathicgrunt/structure_layout_optimizer/mixins/StructureTemplatePaletteMixin.java` | `value={StructureTemplate.Palette.class})` | Inject:1 | structureLayoutOptimizer$shrinkStructureTemplateBlocksList |
| top-level / `telepathicgrunt/structure_layout_optimizer/mixins/StructureTemplatePoolAccessor.java` | `value={StructureTemplatePool.class})` | Accessor:1 |  |
| top-level / `telepathicgrunt/structure_layout_optimizer/services/PlatformService.java` | `` |  |  |
| top-level / `telepathicgrunt/structure_layout_optimizer/SloConfig.java` | `` |  |  |
| top-level / `telepathicgrunt/structure_layout_optimizer/StructureLayoutOptimizerMod.java` | `` |  | init |
| top-level / `telepathicgrunt/structure_layout_optimizer/utils/BoxOctree.java` | `` |  | roundAwayFromZero, subdivide, addBox, boundaryEntirelyContains, boundaryIntersects, withinBoundsButNotIntersectingChildren, intersectsAnyBox, boundaryContains, withinAnyBox |
| top-level / `telepathicgrunt/structure_layout_optimizer/utils/GeneralUtils.java` | `` |  | loadService, shuffleAndPrioritize, getStringMicroOptimised, copyAll |
| top-level / `telepathicgrunt/structure_layout_optimizer/utils/PalettedStructureBlockInfoList.java` | `` |  | bits, indexOf, convertBackToStructureBlockInfoListAndCache, size, isEmpty, iterator, listIterator, listIterator, contains, containsAll, get, indexOf, lastIndexOf, subList, set, add, add, remove, remove, addAll, addAll, removeAll, retainAll, clear, Entry, compress |
| top-level / `telepathicgrunt/structure_layout_optimizer/utils/PalettedStructureBlockInfoListIterator.java` | `` |  | hasNext, next, toIndex, size |
| top-level / `telepathicgrunt/structure_layout_optimizer/utils/StructureTemplateOptimizer.java` | `` |  | getStructureBlockInfosInBounds, isFinalizeProcessor, transform |
| top-level / `telepathicgrunt/structure_layout_optimizer/utils/TrojanArrayList.java` | `` |  |  |
| top-level / `telepathicgrunt/structure_layout_optimizer/utils/TrojanVoxelShape.java` | `` |  | getCoords |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
