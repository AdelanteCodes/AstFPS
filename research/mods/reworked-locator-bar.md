# Locator Bar

Review status: **Evidence inventory; behavioral review pending**

Project: [Locator Bar](https://modrinth.com/mod/reworked-locator-bar)
Selected artifact version: `1.2.4+26.3.x-fabric`
Published implementation source: https://github.com/FuzjaJadrowa/LocatorBar
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Recreated concept of a player locator bar for Minecraft. Simple, clean bar at the top of your screen.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `optional`. Server support: `optional`.

Artifact identity:
- `sha1`: `81d0c44a72df6a1a839a2dbab43982f7aba83385`
- `sha512`: `9a7a7e8421fac9a9b9fcf42f4f3e840ff85aae820790f97fd2d89d7af7e881ab8552f224d28e10f05101965c8791731856169e534fe98584248a27d319a1c758`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in Xe-Mod.

## Loader interface

Top-level bytecode classes: 60
Reconstructed Java files: 38

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "main": [
    "pl.fuzjajadrowa.locatorbar.fabric.LocatorBarFabric"
  ],
  "client": [
    "pl.fuzjajadrowa.locatorbar.fabric.LocatorBarFabricClient"
  ],
  "modmenu": [
    "pl.fuzjajadrowa.locatorbar.fabric.LocatorBarModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.3 <26.4",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `pl/fuzjajadrowa/locatorbar/client/ClassicExperienceBarState.java` | `` |  | shouldShowVanillaExperienceBar, shouldHideVanillaExperienceBar, update, isVanillaExperienceBarVisible |
| top-level / `pl/fuzjajadrowa/locatorbar/client/ClassicLocatorBarHudRenderer.java` | `` |  | render, isVanillaExperienceBarVisible |
| top-level / `pl/fuzjajadrowa/locatorbar/client/ClientWaypointInventory.java` | `` |  | tick |
| top-level / `pl/fuzjajadrowa/locatorbar/client/ConfigList.java` | `` |  | clearList, addEntry, addWaypointEntry, addHeaderEntry, getRowWidth, getScrollbarPosition, renderEntry, narratables, children, toggleVisibility, deleteWaypoint, updateWaypoint, saveDefaultWaypointConfigIfNeeded, renderEntry, narratables, children, renderEntry, narratables, children, extractContent |
| top-level / `pl/fuzjajadrowa/locatorbar/client/ConfigScreenState.java` | `` |  |  |
| top-level / `pl/fuzjajadrowa/locatorbar/client/ConfigSlider.java` | `` |  | updateMessage, applyValue, currentValue, toNormalized, fromNormalized, snap |
| top-level / `pl/fuzjajadrowa/locatorbar/client/LocatorBarConfigScreen.java` | `` |  | init, extractRenderState, renderHeader, onClose, cycleStyle, styleButtonText, toggleShowCoordinates, showCoordinatesButtonText, toggleElementsOnXpBar, elementsOnXpBarButtonText, cycleCoordinatesFormat, coordinatesFormatButtonText, toggleShowDays, showDaysButtonText, cycleDaysDisplayOrder, daysDisplayOrderButtonText, toggleShowWorldDirections, showWorldDirectionsButtonText, cyclePlayerMarkerType, playerMarkerTypeButtonText, togglePlayerMarkerOutline, playerMarkerOutlineButtonText, toggleShowWaypoints, showWaypointsButtonText, toggleShowDeathWaypoint, showDeathWaypointButtonText, updateControlStates, updatePageState, applyRuntime, removed, previousPage, nextPage |
| top-level / `pl/fuzjajadrowa/locatorbar/client/LocatorBarHudHelper.java` | `` |  | collectWaypointMarkers, yaw, position, addWaypointMarker, colorFromWaypointId, collectPlayerMarkers, hasRecoveryCompass, WaypointMarker |
| top-level / `pl/fuzjajadrowa/locatorbar/client/LocatorBarHudRenderer.java` | `` |  | render |
| top-level / `pl/fuzjajadrowa/locatorbar/client/MarkerRenderer.java` | `` |  | renderDirectionMarker, renderWaypointMarker, renderPlayerMarker |
| top-level / `pl/fuzjajadrowa/locatorbar/client/PlayerLocatorClient.java` | `` |  | apply, clear, collectMarkers, collectEntityMarkers, yaw, position, skinTexture, Marker |
| top-level / `pl/fuzjajadrowa/locatorbar/client/RenderCompat.java` | `` |  |  |
| top-level / `pl/fuzjajadrowa/locatorbar/client/ReworkedLocatorBarHudRenderer.java` | `` |  | render, renderInfoText, drawCenteredText |
| top-level / `pl/fuzjajadrowa/locatorbar/client/WaypointConfigPage.java` | `` |  | addManagedWaypoint |
| top-level / `pl/fuzjajadrowa/locatorbar/config/ConfigFile.java` | `` |  |  |
| top-level / `pl/fuzjajadrowa/locatorbar/config/LocatorBarConfig.java` | `` |  | load, normalize, save, getStyle, setStyle, isEnabled, getScale, setScale, getCustomOffsetX, setCustomOffsetX, getCustomOffsetY, setCustomOffsetY, getViewAngle, setViewAngle, isShowCoordinates, setShowCoordinates, isElementsOnXpBar, setElementsOnXpBar, getCoordinatesFormat, setCoordinatesFormat, isShowDays, setShowDays, getDaysDisplayOrder, setDaysDisplayOrder, isShowWorldDirections, setShowWorldDirections, getWorldDirectionsScale, setWorldDirectionsScale, getPlayerMarkerType, setPlayerMarkerType, getPlayerMarkersScale, setPlayerMarkersScale, isPlayerMarkerOutline, setPlayerMarkerOutline, getMaxVisiblePlayers, setMaxVisiblePlayers, getPlayerMarkerFadeStartDistance, setPlayerMarkerFadeStartDistance, getPlayerMarkerFadeToMinDistance, getPlayerMarkerHideDistance, getPlayerMarkerMinAlpha, isShowWaypoints, setShowWaypoints, isShowDeathWaypoint, setShowDeathWaypoint, getWaypointsScale, setWaypointsScale, getMaxVisibleWaypoints, setMaxVisibleWaypoints, getWaypoints, getWaypointConfig, setWaypointConfig, removeWaypointConfig, hasServerSettings, getServerSettings, applyServerSettings, clearServerSettings, clamp, clampInt |
| top-level / `pl/fuzjajadrowa/locatorbar/config/LocatorBarEnums.java` | `` |  | translationKey, next, translationKey, next, translationKey, next, translationKey, next |
| top-level / `pl/fuzjajadrowa/locatorbar/config/LocatorBarServerConfig.java` | `` |  | load, save, get, set, loadFromLegacyToml, readStyle, readBoolean, readInt, readDistance, readFloat, clamp, clampInt, ServerSettings, update, defaults, build |
| top-level / `pl/fuzjajadrowa/locatorbar/fabric/LocatorBarFabric.java` | `` |  | onInitialize |
| top-level / `pl/fuzjajadrowa/locatorbar/fabric/LocatorBarFabricClient.java` | `` |  | onInitializeClient |
| top-level / `pl/fuzjajadrowa/locatorbar/fabric/LocatorBarFabricNetworking.java` | `` |  | initCommon, initClient |
| top-level / `pl/fuzjajadrowa/locatorbar/fabric/LocatorBarModMenuIntegration.java` | `` |  | getModConfigScreenFactory |
| top-level / `pl/fuzjajadrowa/locatorbar/LocatorBar.java` | `` |  | init |
| top-level / `pl/fuzjajadrowa/locatorbar/mixin/client/ExperienceBarMixin.java` | `value={ExperienceBar.class})` | Inject:2 | locatorbar$hideExperienceBarBackground, locatorbar$hideExperienceBar |
| top-level / `pl/fuzjajadrowa/locatorbar/mixin/client/ExperienceLevelMixin.java` | `value={Hud.class})` | Redirect:1 | locatorbar$redirectExtractExperienceLevel |
| top-level / `pl/fuzjajadrowa/locatorbar/mixin/client/GuiMixin.java` | `value={Hud.class})` | Inject:1 | locatorbar$renderHud |
| top-level / `pl/fuzjajadrowa/locatorbar/mixin/client/LocatorBarRendererMixin.java` | `value={LocatorBar.class})` | Inject:2 | locatorbar$hideVanillaLocatorBarBackground, locatorbar$hideVanillaLocatorBar |
| top-level / `pl/fuzjajadrowa/locatorbar/mixin/client/MinecraftTickMixin.java` | `value={Minecraft.class})` | Inject:1 | locatorbar$refreshInventory |
| top-level / `pl/fuzjajadrowa/locatorbar/mixin/client/OptionsScreenMixin.java` | `value={OptionsScreen.class})` | Inject:2 | locatorbar$addConfigShortcut, locatorbar$onRepositionElements, locatorbar$updateButtonPosition, locatorbar$findWidgetByKey |
| top-level / `pl/fuzjajadrowa/locatorbar/mixin/CompassItemMixin.java` | `value={CompassItem.class})` | Inject:1 | locatorbar$setWaypointMetadata |
| top-level / `pl/fuzjajadrowa/locatorbar/network/PlayerLocatorPayload.java` | `` |  | read, write, type, validateEntryCount, Entry |
| top-level / `pl/fuzjajadrowa/locatorbar/network/ServerConfigPayload.java` | `` |  | read, write, type |
| top-level / `pl/fuzjajadrowa/locatorbar/server/LocatorBarCommands.java` | `` |  | register, updateSettings, showServerSettings, showGeneralHelp, showHelp, getType, getDefaultValue, setStyle, setShowCoordinates, setShowDays, setShowWorldDirections, setPlayerMarkerType, setMaxVisiblePlayers, setPlayerMarkerFadeStartDistance, setPlayerMarkerFadeToMinDistance, setPlayerMarkerHideDistance, setPlayerMarkerHideDistanceInf, setPlayerMarkerMinAlphaPercent, setShowWaypoints, setMaxVisibleWaypoints, setShowDeathWaypoint, settingsForUpdate, isMultiplayerOrLan |
| top-level / `pl/fuzjajadrowa/locatorbar/server/PlayerLocatorBroadcaster.java` | `` |  | createPayload, PlayerEntry |
| top-level / `pl/fuzjajadrowa/locatorbar/util/LocatorBarUtils.java` | `` |  | wrapTo180, quantizeToHalfPixel, colorFromId, shouldHidePlayerHead, setBrightness, colorFromPlayerId, forEachBundleItem |
| top-level / `pl/fuzjajadrowa/locatorbar/util/MarkerMath.java` | `` |  | wrapTo180, quantizeToHalfPixel, playerAlpha |
| top-level / `pl/fuzjajadrowa/locatorbar/waypoint/WaypointData.java` | `` |  | ensureWaypointData, ensureWaypointData, ensureClickedLodestoneWaypoint, getOwner, getWaypointId, getWaypointIndex, isHidden, setHidden, getCustomColor, setCustomColor, getWaypointSymbol, setWaypointSymbol, unlinkWaypoint, readWaypointIndexForOwner, getCustomDataTag, getCustomDataTagNullable, putUuid, hasUuid, getUuid, uuidToIntArray, intArrayToUuid |
| top-level / `pl/fuzjajadrowa/locatorbar/waypoint/WaypointInventory.java` | `` |  | forEachStack, forEachLeaf, migrate, unlink, updateStack, updateBundle |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
