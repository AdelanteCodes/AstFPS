# Hide Models

Review status: **Evidence inventory; behavioral review pending**

Project: [Hide Models](https://modrinth.com/mod/hide-models)
Selected artifact version: `mc26.1-26.3-2.1.0-fabric`
Published implementation source: https://github.com/Simuciokas/hidemodels
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Client-side mod hides model pieces from rendering

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `da2afb5853a6d956c731fc1f09d379e6f713196a765f1505780fc93ba00f0d9a5682b0246370b638099f5d67d03864d7d4190bbddc9556193d3567c3f6246ded`
- `sha1`: `609b6ff09a64c8e0fb1189a1cdb1bb36a89437b2`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 26
Reconstructed Java files: 17

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "io.github.simuciokas.hidemodels.fabric.HideModelsFabric"
  ],
  "modmenu": [
    "io.github.simuciokas.hidemodels.fabric.ModMenuEntry"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.0",
  "fabric-api": ">=0.155.3",
  "minecraft": ">=26.1 <=26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/github/simuciokas/hidemodels/ChatOut.java` | `` |  | say, actionBar |
| top-level / `io/github/simuciokas/hidemodels/ClearScreen.java` | `` |  | extractRenderState, extractBackground |
| top-level / `io/github/simuciokas/hidemodels/CommandTree.java` | `` |  | build |
| top-level / `io/github/simuciokas/hidemodels/ConfigText.java` | `` |  |  |
| top-level / `io/github/simuciokas/hidemodels/fabric/Cmd.java` | `` |  | literal |
| top-level / `io/github/simuciokas/hidemodels/fabric/HideModelsFabric.java` | `` |  | onInitializeClient |
| top-level / `io/github/simuciokas/hidemodels/fabric/KeyRegistration.java` | `` |  |  |
| top-level / `io/github/simuciokas/hidemodels/fabric/ModMenuEntry.java` | `` |  | getModConfigScreenFactory |
| top-level / `io/github/simuciokas/hidemodels/HiddenListScreen.java` | `` |  | perPage, showingBones, hiddenFixedRows, serverRows, serverRank, profileNamed, inOpenList, openList, pageCount, nearbyRows, isLookedAt, build, addNameBox, rename, roomX, roomY, lists, openListHead, serverLabel, toggleOpenLine, opensUp, measure, row, hit, tabButton, settings, toggle, numberWidth, stepperWidth, stepRadius, chrome, turn, place, clamp, init, paint, detail, tip, fit, goneCount, header, inside, isPauseScreen, onClose |
| top-level / `io/github/simuciokas/hidemodels/HideModels.java` | `` |  | resolveComponents, itemId, modelNumber, findComponent, registryId, channelId, findMethod, invokeToString, modelIdOf, componentValue, modelIdOfEntity, shouldHide, couldHideAnything, tick, switchOnJoin, currentServer, switchProfilesFor, setProfileServer, matches, hidden, listed, coveredBy, listRadius, isEnabled, isFirstPersonOnly, guiX, guiY, patterns, unsaved, profiles, hidingList, add, remove, removeModel, remove, saveUnsavedAsProfile, addUnsavedToProfile, setProfileOn, renameProfile, deleteProfile, profileText, pasteProfiles, patternsOf, freeName, addToProfile, removeFromProfile, moveUnsaved, freeProfileName, edit, setEnabled, setFirstPersonOnly, setListRadius, setGuiPosition, fraction, parseFraction, directive, fmt, debug, confirm, coveringPattern, reloadNow, parseRadius, inFirstPerson, onServerChannel, clearServerOverride, isServerDisabled, maybeReload, changedSinceRead, rewriteOldNumberLines, load, writeDefaults, computeValue, Profile, Pasted |
| top-level / `io/github/simuciokas/hidemodels/Keys.java` | `` |  | create, category, id, tick, window |
| top-level / `io/github/simuciokas/hidemodels/mixin/ClientCommonPacketListenerMixin.java` | `value={ClientCommonPacketListenerImpl.class})` | Inject:1 | hidemodels$serverControl |
| top-level / `io/github/simuciokas/hidemodels/mixin/EntityRenderDispatcherMixin.java` | `value={EntityRenderDispatcher.class})` | Inject:2 | hidemodels$skipHiddenModels, hidemodels$skipHiddenModelsWithPartialTick |
| top-level / `io/github/simuciokas/hidemodels/mixin/ItemDisplayAccessor.java` | `value={Display.ItemDisplay.class})` | Invoker:1 |  |
| top-level / `io/github/simuciokas/hidemodels/NearbyModels.java` | `` |  | sample, gone, lookedAt, nearby, bones, nearbyIds, withHiddenBones, piecesMatching, say, Nearby, gone |
| top-level / `io/github/simuciokas/hidemodels/Painter.java` | `` |  | fill, text, textWidth, lineHeight |
| top-level / `io/github/simuciokas/hidemodels/Screens.java` | `` |  | open, method |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
