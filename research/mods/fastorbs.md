# FastOrbs

Review status: **Behavioral static review**

Project: [FastOrbs](https://modrinth.com/mod/fastorbs)
Selected artifact version: `1.0-SNAPSHOT`
Published implementation source: https://github.com/CraftCanvasMC/FastOrbs
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A server side Fabric mod that optimizes xp orb merging and pickup mechanics for better performance.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `unsupported`. Server support: `required`.

Artifact identity:
- `sha512`: `afe7a7b7a931abbc6bdf0013eeed0da92be80afae53c037e96848af4844296301f5468b60815be900fa5e1b11c982d8eb9235bd93ebbd7729fe4fb1051b15267`
- `sha1`: `8b77a027c6e2d71e502a6c5a20a0575979aaa762`

## Reviewed mechanism

Both reconstructed classes reviewed; upstream repository identity checked.

- Replaces XP award creation with a nearby alive-orb lookup, adds one getExperienceValue(amount) result to an existing orb or spawns one orb, and resets its age.
- Merging accepts any other alive orb, sums values, keeps the younger age, and discards the merged orb. Merge scans run on even server ticks in a slightly expanded bounding box.
- Changes the pickup-delay constant from two ticks to zero.

## Lifecycle, correctness, and failure questions

- The award replacement shows one denomination selection and no loop consuming the remainder of amount. Total XP conservation must be checked against the selected vanilla implementation.
- Merging any alive orb, age resets, enlarged scan region, and zero delay change orb distribution and collection behavior. Summed integer values can overflow at extreme amounts.

## Checks needed to establish equivalence

- For many award amounts, assert total spawned/merged XP equals the award. Check mending allocation, pickup cooldown, despawn, direction, large awards, and repeated merging.

## Relevance to Xe-Mod

Fewer XP entities can save simulation/render work, but this implementation needs conservation and gameplay checks; do not transplant blindly.

Research only. No implementation is being added during this research pass.

## Loader interface

Top-level bytecode classes: 2
Reconstructed Java files: 2

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "io.canvasmc.fastorbs.Fastorbs"
  ]
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/canvasmc/fastorbs/Fastorbs.java` | `` |  | onInitialize |
| top-level / `io/canvasmc/fastorbs/mixin/ExperienceOrbMixin.java` | `value={ExperienceOrb.class})` | Inject:2, Overwrite:3, ModifyConstant:1 | canvas$injectFasterAwardWithDirectionImplementation, canMerge, getExperienceValue, canMerge, canvas$this, canvas$injectAtMerge, canvas$changeTo0XpDelay, scanForMerges |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
