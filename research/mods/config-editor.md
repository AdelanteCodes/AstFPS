# config-editor-render

Review status: **Evidence inventory; behavioral review pending**

Project: [config-editor-render](https://modrinth.com/mod/config-editor)
Selected artifact version: `1.1.11+26.3`
Published implementation source: https://github.com/zhengzhengyiyi/config-editor
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

a improvement for modmenu, supports modmenu, make you can just edit the configure file like text editor, this mod on join reduces lag

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `3b2638235ce0098eb232c0c8bdc407485dbbdfe8`
- `sha512`: `5a286cb245c774ad40da89ae2687e75fe58df15db3f3b237c417ec4ceea34ab84cedfd7d8e2b6a5f0938a3b27d8542bfd4892a5072d75bb35686cec82842901e`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 63
Reconstructed Java files: 42

**environment**

```json
"*"
```

**entrypoints**

```json
{
  "client": [
    "io.github.zhengzhengyiyi.ConfigEditorClient"
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.18.2",
  "minecraft": ">=26.1",
  "java": ">=21",
  "fabric-api": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `io/github/zhengzhengyiyi/addon/AutoBracketCompletionEntrypoint.java` | `` |  | init |
| top-level / `io/github/zhengzhengyiyi/addon/DateTimeDisplayEntrypoint.java` | `` |  | init, onEditerOpen, onEditerClose, onMouseDown, onMouseScroll, getIdentifier, renderButton |
| top-level / `io/github/zhengzhengyiyi/addon/TextStatsEntrypoint.java` | `` |  | init, getIdentifier, onEditerOpen, renderButton |
| top-level / `io/github/zhengzhengyiyi/addon/UndoRedoEntrypoint.java` | `` |  | init, onEditerOpen, onEditerClose, onMouseDown, onMouseScroll, renderButton, saveState, getIdentifier, resetStacks, clearHistory, canUndo, canRedo, setEnabled |
| top-level / `io/github/zhengzhengyiyi/api/AiClient.java` | `` |  | sendChatRequest, extractContentFromResponse, escapeJson, checkServerStatus |
| top-level / `io/github/zhengzhengyiyi/api/ApiEntrypoint.java` | `` |  |  |
| top-level / `io/github/zhengzhengyiyi/api/config/ConfigData.java` | `` |  |  |
| top-level / `io/github/zhengzhengyiyi/api/config/ConfigManager.java` | `` |  | init, load, save, startFileWatcher, getConfig, maybeReload, updateConfig, isWatcherRunning, restartFileWatcher, shutdown |
| top-level / `io/github/zhengzhengyiyi/api/EntryPointRegistry.java` | `` |  | register |
| top-level / `io/github/zhengzhengyiyi/api/FileType.java` | `` |  | getExtension, getHighLighter, drawHighlightedText, getTextWidth, getCharIndexFromTokens, getTextWidthUpToChar |
| top-level / `io/github/zhengzhengyiyi/config/ModConfigData.java` | `` |  |  |
| top-level / `io/github/zhengzhengyiyi/ConfigEditor.java` | `` |  | onInitialize |
| top-level / `io/github/zhengzhengyiyi/ConfigEditorClient.java` | `` |  | onInitializeClient, testLanguageResources |
| top-level / `io/github/zhengzhengyiyi/gui/AIChatScreen.java` | `` |  | init, checkServerAvailability, updateUIState, updateScrollButtons, getMaxScrollOffset, getTotalChatLines, wrapText, scrollUp, scrollDown, mouseScrolled, extractRenderState, getMessageColor, drawScrollBar, keyPressed, sendMessage, clearChat, openSettings, loadPathAndSend, readFileContent, unescapeJsonEscapes, input, onClose |
| top-level / `io/github/zhengzhengyiyi/gui/EditorScreen.java` | `` |  | init, isConfigFile, formatFileName, renderFileList, scrollUp, scrollDown, updateScrollButtons, updateButtonStates, switchFile, loadFile, getFileName, readFileWithFallbackEncoding, loadConfigFilesRecursively, checkIfJson, startSearch, findNext, findPrevious, endSearch, saveFile, setEditorText, saveFileAsync, openConfigFolder, showErrorPopup, openVisualEditor, openAiChat, validateCurrentJson, showMessagePopup, extractRenderState, shouldCloseOnEsc, getTextWidget, toggleSearch, onClose, removed, keyPressed, toggleTheme, getThemeButtonText |
| top-level / `io/github/zhengzhengyiyi/gui/EntityOverlayHubScreen.java` | `` |  | init, toggleEntityOverlay, toggleBlockOverlay, buildEntityLabel, buildBlockLabel, extractRenderState, keyPressed, onClose |
| top-level / `io/github/zhengzhengyiyi/gui/JsonVisualEditorScreen.java` | `` |  | parseJsonObject, init, rebuildFieldEntries, getDepth, getLastPart, getParentPath, removeChildEntries, toggleObjectExpansion, parseValue, scrollUp, scrollDown, updateScrollButtons, extractRenderState, renderFieldTooltip, mouseScrolled, saveChanges, buildJsonObject, addNewField, addNewObject, jsonElementToValue, returnToRawEditor, onClose, keyPressed, toString, toggleType, parseValueForType |
| top-level / `io/github/zhengzhengyiyi/gui/NbtEditorScreen.java` | `` |  | init, nbtToJsonString, saveNbt, extractRenderState |
| top-level / `io/github/zhengzhengyiyi/gui/PluginManagerScreen.java` | `` |  | init, togglePlugin, extractRenderState, onClose |
| top-level / `io/github/zhengzhengyiyi/gui/theme/ThemeManager.java` | `` |  | getInstance, recompute, isDark, getBackgroundColor, getSidebarColor, getPanelColor, getBorderColor, getBorderAccentColor, getTextColor, getMutedTextColor, getAccentColor, getAccentGreen, getAccentRed, getAccentYellow, getAccentMauve, getSelectedRowColor, getHoverRowColor, invalidate, isSystemDarkMode |
| top-level / `io/github/zhengzhengyiyi/gui/widget/AbstractEditor.java` | `` |  |  |
| top-level / `io/github/zhengzhengyiyi/gui/widget/MultilineEditor.java` | `` |  | setFocused, extractWidgetRenderState, calculateMaxLineWidth, renderScrollBars, renderSearchHighlights, renderErrorTooltips, renderSuggestions, isMouseOverError, mouseClicked, mouseScrolled, mouseScrolled, isMouseOverHorizontalScrollBar, keyPressed, charTyped, updateWidgetNarration, getText, setText, setEditable, setChangedListener, onTextChanged, renderErrorUnderlines, calculateLineStartPosition, validateJSON, updateCursorX, getLineStart, getLineEnd, insertTextAtCursor, getCursorPosition, setCursorPosition, setFileName, getFileName, startSearch, findNext, findPrevious, scrollToCurrentMatch, endSearch, getLineIndex, isSearching, getSearchMatchCount, getCurrentSearchIndex, updateSuggestions, hideSuggestions, insertSuggestion, isMouseOverSuggestion, mouseDragged, mouseReleased |
| top-level / `io/github/zhengzhengyiyi/hud/BlockOverlayHudElement.java` | `` |  | extractRenderState |
| top-level / `io/github/zhengzhengyiyi/hud/EntityOverlayHudElement.java` | `` |  | extractRenderState, getRegistryId, getSpawnEgg |
| top-level / `io/github/zhengzhengyiyi/mixin/client/ExampleClientMixin.java` | `value={Minecraft.class})` | Inject:1 | init |
| top-level / `io/github/zhengzhengyiyi/mixin/client/MinecraftMemoryMixin.java` | `value={Minecraft.class})` | Inject:2 | onSetLevel, onClearClientLevel, usedMemoryMb |
| top-level / `io/github/zhengzhengyiyi/mixin/ExampleMixin.java` | `value={MinecraftServer.class})` | Inject:1 | init |
| top-level / `io/github/zhengzhengyiyi/NbtSaver.java` | `` |  | saveAndOpenEditor, readPointedNbt, openEditor |
| top-level / `io/github/zhengzhengyiyi/util/BackupHelper.java` | `` |  | backupConfigFile, backupEntireConfigDirectory, backupDirectoryToZip, getBackupDirectory, createZipFile, visitFile, preVisitDirectory, addToZipFile, getConfigBackupDirectory, listBackups, cleanupOldBackups |
| top-level / `io/github/zhengzhengyiyi/util/CodeSuggester.java` | `` |  | suggestForPosition, isInKeyContext, isInValueContext, isInStringContext, suggestKeys, suggestValues, suggestStringContent, suggestStructural, extractCurrentKey, extractExistingKeys, filterDuplicates, getCommonKeys, getValueSuggestions |
| top-level / `io/github/zhengzhengyiyi/util/FileLockUtil.java` | `` |  | tryLockFile, tryLockFile, releaseLock |
| top-level / `io/github/zhengzhengyiyi/util/highlighter/CfgSyntaxHighlighter.java` | `` |  | getCharIndexFromTokens, getTextWidthUpToChar, drawHighlightedText, tokenizeLine, determineValueType, getTextWidth, getTokenColor |
| top-level / `io/github/zhengzhengyiyi/util/highlighter/HighLighter.java` | `` |  |  |
| top-level / `io/github/zhengzhengyiyi/util/highlighter/JsonSyntaxHighlighter.java` | `` |  | getCharIndexFromTokens, getTextWidthUpToChar, drawHighlightedText, tokenizeLine, getTextWidth, getTokenColor |
| top-level / `io/github/zhengzhengyiyi/util/highlighter/PropertiesSyntaxHighlighter.java` | `` |  | getCharIndexFromTokens, getTextWidthUpToChar, drawHighlightedText, tokenizeLine, getTextWidth, getTokenColor |
| top-level / `io/github/zhengzhengyiyi/util/highlighter/TextSyntaxHighlighter.java` | `` |  | getCharIndexFromTokens, getTextWidthUpToChar, drawHighlightedText, tokenizeLine, createToken, isHeader, isNumber, isURL, isEmail, isBracket, isSymbol, getTextWidth, getTokenColor |
| top-level / `io/github/zhengzhengyiyi/util/highlighter/TomlSyntaxHighlighter.java` | `` |  | getCharIndexFromTokens, getTextWidthUpToChar, drawHighlightedText, tokenizeLine, determineValueType, getTextWidth, getTokenColor |
| top-level / `io/github/zhengzhengyiyi/util/highlighter/YamlSyntaxHighlighter.java` | `` |  | getCharIndexFromTokens, getTextWidthUpToChar, drawHighlightedText, tokenizeLine, extractIndentation, determineValueType, getTextWidth, getTokenColor |
| top-level / `io/github/zhengzhengyiyi/util/JSONError.java` | `` |  |  |
| top-level / `io/github/zhengzhengyiyi/util/JSONValidator.java` | `` |  | validateJSON, parseException, getCleanErrorMessage, findPosition, calculateLineNumber, calculateColumnNumber, findPreciseErrorStart, findPreciseErrorEnd, findBraceBoundary, findBracketBoundary, findColonBoundary, findCommaBoundary, findStringStart, findStringEnd, findTokenBoundary, checkManualErrorDetection, checkBasicErrors, checkStructuralErrors, checkQuotes, checkBrackets, checkCommas |
| top-level / `io/github/zhengzhengyiyi/util/PerformanceMonitor.java` | `` |  | start, getStats, getAllStats, reset, setEnabled, isEnabled, getTotalMemoryUsed, getActiveOperations, getSummary, close, recordError |
| top-level / `io/github/zhengzhengyiyi/util/TextSearchEngine.java` | `` |  | search, hasMatches, getMatchCount, getCurrentMatchIndex, getCurrentMatchPosition, nextMatch, previousMatch, setCaseSensitive, setUseRegex, clear, renderHighlights, setScrollOffset |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
