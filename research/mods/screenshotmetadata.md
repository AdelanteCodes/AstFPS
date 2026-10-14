# ScreenshotMetadata

Review status: **Evidence inventory; behavioral review pending**

Project: [ScreenshotMetadata](https://modrinth.com/mod/screenshotmetadata)
Selected artifact version: `1.4.2`
Published implementation source: https://github.com/fentbuscoding/ScreenshotMetadata
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A Minecraft Fabric mod that automatically adds comprehensive metadata to your screenshots, making them easier to organize and search.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `e6c46248260c0ddda9daf60953f96b360344284c`
- `sha512`: `6aafa5ed16239e3581fcb5b750c00dea78b7762f1d7022deb0bdc4242e83a2da50a48cf8d0dcc2d2bd88fbdf18495b092c06e967f30080df723db5c6fbcfdc0b`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 14
Reconstructed Java files: 9

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    "com.fentbuscoding.screenshotmetadata.ScreenshotMetadataMod"
  ],
  "modmenu": [
    "com.fentbuscoding.screenshotmetadata.compat.ModMenuIntegration"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.3",
  "fabric-api": "*",
  "minecraft": "~26.3",
  "java": ">=25"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/fentbuscoding/screenshotmetadata/compat/ModMenuIntegration.java` | `` |  | getModConfigScreenFactory, init, drawSection, addToggleButton, addTemplateEditor, addPrivacyPreview, addProfileButtons, createProfileButton, profileLabel, createModernToggleText, updateButtonText, markProfileCustom, resetDefaults, onClose, extractRenderState, extractBackground, shouldCloseOnEsc, mouseScrolled, renderSections, updateLayoutMetrics, clampInt, renderTooltipIfHovered, renderPrivacyPreview, renderTemplateEditorHelp, createTemplatePreview, addCollapseButton, isCollapsed |
| top-level / `com/fentbuscoding/screenshotmetadata/config/ScreenshotMetadataConfig.java` | `` |  | get, load, save, getConfigPath, getMetadataProfile, setMetadataProfile, applyProfile, migrate, normalize, inferProfileIdFromCurrentSettings, matchesProfile, readSchemaVersion, fromId |
| top-level / `com/fentbuscoding/screenshotmetadata/metadata/JsonSidecarContext.java` | `` |  | getResourcePacks, getShaderPack, getMods, getModCount, isModListTruncated |
| top-level / `com/fentbuscoding/screenshotmetadata/metadata/JsonSidecarWriter.java` | `` |  | writeSidecarFile, writeSidecarFile, getJsonFile, generateJsonContent, migrateMetadata, migrateKey, appendModpackContext, appendTags, extractTags, appendStringField, appendNumberField, appendBooleanField, appendStringArrayField, escapeJson |
| top-level / `com/fentbuscoding/screenshotmetadata/metadata/PngMetadataWriter.java` | `` |  | writeMetadata, addStandardTextEntries, addTextEntry, mergeTextMetadata |
| top-level / `com/fentbuscoding/screenshotmetadata/metadata/PngXmpWriter.java` | `` |  | writeMetadata, buildXmpPacket, addDublinCoreFields, addXmpBasicFields, addMinecraftFields, appendIfPresent, mergeXmpChunk, escapeXml |
| top-level / `com/fentbuscoding/screenshotmetadata/metadata/XmpSidecarWriter.java` | `` |  | writeSidecarFile, getXmpFile, generateXmpContent, addDublinCoreMetadata, addXmpBasicMetadata, addMinecraftMetadata, escapeXml |
| top-level / `com/fentbuscoding/screenshotmetadata/mixin/ScreenshotMixin.java` | `value={Screenshot.class})` | Inject:2 | captureScreenshotFile, onScreenshotSaved, processScreenshotMetadata, findNewestScreenshot, waitForNewestScreenshot, findScreenshotInFallbackLocations, isFileStable, collectMetadata, addArmorMetadata, addPotionEffectsMetadata, getBiomeName, getBiomeId, formatBiomeName, formatDimensionName, formatTimeOfDay, addGameModeMetadata, normalizeGameMode, formatDisplayName, getFacingDirection, addMetadataToScreenshot, addWeatherMetadata, collectJsonSidecarContext, collectEnabledResourcePacks, detectShaderPack, tryGetIrisShaderPack, invokeIfPresent, extractNameFromPack, roundToNearest, hashSeed, maybeRenameScreenshot, applyTemplate, sanitizeFileName, writePngMetadataWithRetry |
| top-level / `com/fentbuscoding/screenshotmetadata/ScreenshotMetadataMod.java` | `` |  | onInitializeClient |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
