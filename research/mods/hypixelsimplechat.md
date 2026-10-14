# Hypixel Simple Chat

Review status: **Evidence inventory; behavioral review pending**

Project: [Hypixel Simple Chat](https://modrinth.com/mod/hypixelsimplechat)
Selected artifact version: `1.9.8`
Published implementation source: https://github.com/Tjiba/HypixelSimpleChat
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

Cleans up  Skyblock chat, 200+ formatted msg , chat tabs, History, search, change color etc...

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha512`: `a8bbc8245e8f1635e1bfe5d85315a568d53fa9c735da91a06203995fb0d793786ddba6345dad63010e5ce4f147e764b1deb54676f939f129ea4ee64d4869ba98`
- `sha1`: `19b706e2a96e9d8b4e9edc2359642e394ed61561`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 137
Reconstructed Java files: 93

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "client": [
    {
      "adapter": "kotlin",
      "value": "com.simplechat.SimpleChatMod"
    }
  ],
  "modmenu": [
    {
      "adapter": "kotlin",
      "value": "com.simplechat.ui.HscModMenu"
    }
  ]
}
```

**depends**

```json
{
  "fabricloader": ">=0.19.5",
  "minecraft": ">=26.1 <26.4",
  "java": ">=25",
  "fabric-api": "*",
  "fabric-language-kotlin": "*"
}
```

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `com/simplechat/BazaarSummary.java` | `` |  | process, preview, stale, displayed, reset$HypixelSimpleChat, parse, order, line, hex, hover, compare, sign, group, plural, num, getLabel, getQty, setQty, getCoins, setCoins, getName, getLabel, getQty, getCoins, getSell |
| top-level / `com/simplechat/CompactRules.java` | `` |  | compact |
| top-level / `com/simplechat/ComponentLegacy.java` | `` |  | of, appendStyle |
| top-level / `com/simplechat/config/ChatMode.java` | `` |  | values, valueOf, getEntries |
| top-level / `com/simplechat/config/ConfigEntry.java` | `` |  | getId, getKind, getTitle, getDescription, getDefault, getEnumConstants, getValue, setValue, getBoolean, setBoolean, getInt, setInt, getString, setString, getEnum, setEnum, getRevision |
| top-level / `com/simplechat/config/ConfigGroup.java` | `` |  | getEntries, register, boolean, int, string, color, enum, addEnum, register$lambda$0, getValue, setValue, boolean$lambda$1, int$lambda$2, string$lambda$3, color$lambda$4, enum$lambda$5 |
| top-level / `com/simplechat/config/EntryKind.java` | `` |  | values, valueOf, getEntries |
| top-level / `com/simplechat/config/EntryMeta.java` | `` |  | getName, setName, getDescription, setDescription |
| top-level / `com/simplechat/config/GuildChat.java` | `` |  | getMode, setMode, getShowRank, setShowRank, getShowGuildRank, setShowGuildRank, getRecolorName, setRecolorName, getNameColor, setNameColor, getGuildPrefix, setGuildPrefix, getGuildPrefixColor, setGuildPrefixColor, getOfficerPrefix, setOfficerPrefix, getOfficerPrefixColor, setOfficerPrefixColor, getBridgeAlias, setBridgeAlias, getBridgeAliasColor, setBridgeAliasColor, getBridgeNameColor, setBridgeNameColor, getRecolorMessage, setRecolorMessage, getMessageColor, setMessageColor, getBotMcName, setBotMcName, getFormatAllGuild, setFormatAllGuild, getVersionTags, setVersionTags, getV1Color, setV1Color, getV2Color, setV2Color, getV3Color, setV3Color, mode_delegate$lambda$0, showRank_delegate$lambda$1, showGuildRank_delegate$lambda$2, recolorName_delegate$lambda$3, nameColor_delegate$lambda$4, guildPrefix_delegate$lambda$5, guildPrefixColor_delegate$lambda$6, officerPrefix_delegate$lambda$7, officerPrefixColor_delegate$lambda$8, bridgeAlias_delegate$lambda$9, bridgeAliasColor_delegate$lambda$10, bridgeNameColor_delegate$lambda$11, recolorMessage_delegate$lambda$12, messageColor_delegate$lambda$13, botMcName_delegate$lambda$14, formatAllGuild_delegate$lambda$15, versionTags_delegate$lambda$16, v1Color_delegate$lambda$17, v2Color_delegate$lambda$18, v3Color_delegate$lambda$19 |
| top-level / `com/simplechat/config/HscCategory.java` | `` |  | getId |
| top-level / `com/simplechat/config/HscConfig.java` | `` |  | getCategories, category, firstLaunch, migrate, load, resetToDefaults, applyPreset, save, readGroup, parseValue, writeGroup |
| top-level / `com/simplechat/config/LobbyCleanup.java` | `` |  | getEnabled, setEnabled, enabled_delegate$lambda$0 |
| top-level / `com/simplechat/config/PartyChat.java` | `` |  | getMode, setMode, getShowRank, setShowRank, getRecolorName, setRecolorName, getNameColor, setNameColor, getPartyPrefix, setPartyPrefix, getPrefixColor, setPrefixColor, getRecolorMessage, setRecolorMessage, getMessageColor, setMessageColor, mode_delegate$lambda$0, showRank_delegate$lambda$1, recolorName_delegate$lambda$2, nameColor_delegate$lambda$3, partyPrefix_delegate$lambda$4, prefixColor_delegate$lambda$5, recolorMessage_delegate$lambda$6, messageColor_delegate$lambda$7 |
| top-level / `com/simplechat/config/PersonalRules.java` | `` |  | getRules, setRules, list, replace, rules_delegate$lambda$0 |
| top-level / `com/simplechat/config/PersonalRuleSettings.java` | `` |  | getEnabled, setEnabled, getText, setText, getAction, setAction, getColor, setColor, getBold, setBold, getItalic, setItalic, getUnderlined, setUnderlined, getChannel, setChannel, getCaseSensitive, setCaseSensitive, rule, enabled_delegate$lambda$0, text_delegate$lambda$1, action_delegate$lambda$2, color_delegate$lambda$3, bold_delegate$lambda$4, italic_delegate$lambda$5, underlined_delegate$lambda$6, channel_delegate$lambda$7, caseSensitive_delegate$lambda$8 |
| top-level / `com/simplechat/config/PublicChat.java` | `` |  | getMode, setMode, getShowRank, setShowRank, getRecolorName, setRecolorName, getNameColor, setNameColor, getHideLevel, setHideLevel, getHideEmblem, setHideEmblem, getRecolorMessage, setRecolorMessage, getMessageColor, setMessageColor, mode_delegate$lambda$0, showRank_delegate$lambda$1, recolorName_delegate$lambda$2, nameColor_delegate$lambda$3, hideLevel_delegate$lambda$4, hideEmblem_delegate$lambda$5, recolorMessage_delegate$lambda$6, messageColor_delegate$lambda$7 |
| top-level / `com/simplechat/config/RuleConfig.java` | `` |  | getMasterEnabled, getLobbyEnabled, getSkyblockEnabled, getSystemEnabled, getGroupRepeats, getSmartCollapse, getActions, getGroupActions, getGuildStyle, getPartyStyle, getPublicStyle, getPartyPrefix, getPrefix, getBridge, getCustomHidePatterns, getMutedPlayers, getSelf, getShowTimestamps, getTimestampColor, getCompactSoloClass, getCompactHoppity, getCompactTheme, getCompactThemeColor, getBazaarItemsColor, getBazaarSalesColor, getPersonalRules, component1, component2, component3, component4, component5, component6, component7, component8, component9, component10, component11, component12, component13, component14, component15, component16, component17, component18, component19, component20, component21, component22, component23, component24, component25, component26, copy, toString, hashCode, equals, current, getDEFAULT, selfPlayer, build |
| top-level / `com/simplechat/config/RuleSettings.java` | `` |  | register, groupActions, overrides, migrate, perPhrase, configId, label, categoryOf |
| top-level / `com/simplechat/config/Settings.java` | `` |  | getMasterEnabled, setMasterEnabled, getGroupRepeats, setGroupRepeats, getSmartCollapse, setSmartCollapse, getUpdateNotifications, setUpdateNotifications, getMaxMessages, setMaxMessages, getShowTimestamps, setShowTimestamps, getTimestampColor, setTimestampColor, getHighlightSelf, setHighlightSelf, getSelfColor, setSelfColor, getMutedPlayers, setMutedPlayers, getCompactTheme, setCompactTheme, getCompactThemeColor, setCompactThemeColor, getChatTabs, setChatTabs, getTabFilterMode, setTabFilterMode, getUnreadNotifications, setUnreadNotifications, mutedList, setMuted, applyRecommended, firstLaunch, migrate, masterEnabled_delegate$lambda$0, groupRepeats_delegate$lambda$1, smartCollapse_delegate$lambda$2, updateNotifications_delegate$lambda$3, maxMessages_delegate$lambda$4, showTimestamps_delegate$lambda$5, timestampColor_delegate$lambda$6, highlightSelf_delegate$lambda$7, selfColor_delegate$lambda$8, mutedPlayers_delegate$lambda$9, compactTheme_delegate$lambda$10, compactThemeColor_delegate$lambda$11, chatTabs_delegate$lambda$12, tabFilterMode_delegate$lambda$13, unreadNotifications_delegate$lambda$14 |
| top-level / `com/simplechat/config/SkyBlockCleanup.java` | `` |  | getEnabled, setEnabled, getSoloClass, setSoloClass, getHoppity, setHoppity, getBazaarItemsColor, setBazaarItemsColor, getBazaarSalesColor, setBazaarSalesColor, getCustomPatterns, setCustomPatterns, enabled_delegate$lambda$0, soloClass_delegate$lambda$1, hoppity_delegate$lambda$2, bazaarItemsColor_delegate$lambda$3, bazaarSalesColor_delegate$lambda$4, customPatterns_delegate$lambda$5 |
| top-level / `com/simplechat/config/SystemCat.java` | `` |  | getEnabled, setEnabled, enabled_delegate$lambda$0 |
| top-level / `com/simplechat/Debug.java` | `` |  | getEnabled, setEnabled, log, logGuard, logRendered, logCollapsed |
| top-level / `com/simplechat/engine/Channel.java` | `` |  | values, valueOf, getEntries |
| top-level / `com/simplechat/engine/ChannelFormat.java` | `` |  | levelColor, messageSegs, format, author, whisperAuthor, channelAuthor, guildAuthor, nameOf, publicHead, formatPublic, formatParty, formatGuild, parseBridge, bridgeSegs, channelBody, rawMessageSlice, rankNameSegs, selfColorOf, rawColored, coloredSlice, codeLenAt, activeColorBefore, indexOfClean, matchesCleanAt, rawSliceForClean, versionOrAliasColor, extractChannelMarker, hasChannelMarker, hasGuildVersionTag, stripLeadingNonVersionTag, getVersion, getName, getMessage, component1, component2, component3, copy, toString, hashCode, equals, getLevel, getEmblem, getRest, component1, component2, component3, copy, toString, hashCode, equals |
| top-level / `com/simplechat/engine/ChannelStyle.java` | `` |  | getEnabled, getCompact, getShowRank, getShowGuildRank, getRecolorName, getNameColor, getPrefixColor, getMessageColor, getRecolorMessage, component1, component2, component3, component4, component5, component6, component7, component8, component9, copy, toString, hashCode, equals |
| top-level / `com/simplechat/engine/ChatChannel.java` | `` |  | route |
| top-level / `com/simplechat/engine/ChatRules.java` | `` |  | clean, stripDiscordWarning, collapseKey, classify, evaluate, theme$HypixelSimpleChat |
| top-level / `com/simplechat/engine/Collapse.java` | `` |  | removeEldestEntry, seen, remember, countable, getCount, setCount, getRendered, setRendered, getCount, getRendered, component1, component2, copy, toString, hashCode, equals |
| top-level / `com/simplechat/engine/CustomHide.java` | `` |  | stripColors, matches |
| top-level / `com/simplechat/engine/GuildBridgeConfig.java` | `` |  | getBotMcName, getBotAlias, getGuildPrefix, getOfficerPrefix, getGuildPrefixColor, getOfficerPrefixColor, getBridgeAliasColor, getBridgeNameColor, getFormatAllGuild, getVersionTagsEnabled, getV1Color, getV2Color, getV3Color, component1, component2, component3, component4, component5, component6, component7, component8, component9, component10, component11, component12, component13, copy, toString, hashCode, equals |
| top-level / `com/simplechat/engine/LegacyText.java` | `` |  | codeFor, parse, parse$flush |
| top-level / `com/simplechat/engine/Mute.java` | `` |  | matches |
| top-level / `com/simplechat/engine/PersonalAction.java` | `` |  | values, valueOf, getEntries |
| top-level / `com/simplechat/engine/PersonalChannel.java` | `` |  | values, valueOf, getEntries |
| top-level / `com/simplechat/engine/PersonalRule.java` | `` |  | getText, getEnabled, getAction, getColor, getChannel, getCaseSensitive, getBold, getItalic, getUnderlined, matches, component1, component2, component3, component4, component5, component6, component7, component8, component9, copy, toString, hashCode, equals, decode, encode |
| top-level / `com/simplechat/engine/PublicPrefixToggles.java` | `` |  | getHideLevel, getHideEmblem, component1, component2, copy, toString, hashCode, equals |
| top-level / `com/simplechat/engine/RuleAction.java` | `` |  | values, valueOf, getEntries |
| top-level / `com/simplechat/engine/Seg.java` | `` |  | component1, component2, component3, component4, component5, component6, component7, copy, toString, hashCode, equals |
| top-level / `com/simplechat/engine/SegRender.java` | `` |  | highlight, toComponent, highlight, highlight, highlight, highlight$lambda$0, toComponent$lambda$2 |
| top-level / `com/simplechat/engine/SelfPlayer.java` | `` |  | getName, getDisplay, getHighlightColor, component1, component2, component3, copy, toString, hashCode, equals |
| top-level / `com/simplechat/engine/UnreadChannels.java` | `` |  | select, received, count, reset |
| top-level / `com/simplechat/engine/Verdict.java` | `` |  | getShortLegacy, getHoverLegacy, component1, component2, copy, toString, hashCode, equals, toString, hashCode, equals, toString, hashCode, equals, getLegacy, component1, copy, toString, hashCode, equals, getSegs, component1, copy, toString, hashCode, equals |
| top-level / `com/simplechat/HoppityCompact.java` | `` |  | process |
| top-level / `com/simplechat/HscChatAccess.java` | `` |  |  |
| top-level / `com/simplechat/IHscChat.java` | `` |  |  |
| top-level / `com/simplechat/LocalPlayer.java` | `` |  | name, display |
| top-level / `com/simplechat/MiningSummary.java` | `` |  | process, end, line, line$lambda$0 |
| top-level / `com/simplechat/mixin/ChatHudMixin.java` | `value={ChatComponent.class})` | Invoker:7, Accessor:3, Inject:2, Redirect:2, ModifyConstant:1 | hsc$register, hsc$setChannelFilter, hsc$applySearch, hsc$reapplyFilter, hsc$channelOf, hsc$headedBy, hsc$stripLead, hsc$keepEverything, hsc$displayIfVisible, hsc$messageAt, hsc$maxHistory, hsc$onAddMessage, hsc$display, hsc$removeLine, hsc$withCount, hsc$hasUrlClick, hsc$withClickables, hsc$withHover, hsc$hoverOf, hsc$treeGiftTotals, hsc$hasActionClick, hsc$hasItemLink, withTimestamp, reAdd, build, buildSegs |
| top-level / `com/simplechat/mixin/ChatScreenMixin.java` | `value={ChatScreen.class})` | Inject:4, ModifyVariable:1 | hsc$tabLabel, hsc$tabRects, hsc$reset, hsc$routeSend, hsc$onClick, hsc$selectTab, hsc$searchKeys, hsc$clearSearch, hsc$overlay |
| top-level / `com/simplechat/Msg.java` | `` |  | getText, get, format, values, valueOf, getEntries |
| top-level / `com/simplechat/PickupStash.java` | `` |  | process, preview, action, isLine, isPickup, trimsPadding, reset$HypixelSimpleChat, stale, displayed, clearBlock, line, process, stale, displayed, reset, process$lambda$1, process$lambda$2 |
| top-level / `com/simplechat/rules/Category.java` | `` |  | values, valueOf, getEntries |
| top-level / `com/simplechat/rules/common/Abilities.java` | `` |  | getABILITIES, getRules, rules$lambda$7$lambda$0, rules$lambda$7$lambda$1, rules$lambda$7$lambda$2, rules$lambda$7$lambda$3, rules$lambda$7$lambda$4, rules$lambda$7$lambda$5, rules$lambda$7$lambda$6, rules$lambda$7 |
| top-level / `com/simplechat/rules/common/Bazaar.java` | `` |  | getBAZAAR, getRules, rules$lambda$5$lambda$0, rules$lambda$5$lambda$1, rules$lambda$5$lambda$2, rules$lambda$5$lambda$3, rules$lambda$5$lambda$4, rules$lambda$5 |
| top-level / `com/simplechat/rules/common/Combat.java` | `` |  | getBOSS, getDAMAGE, getKILL_COMBO, getMOB_ABILITY, getPLAYER_DEATH, getCOMBAT_HEAL, getRules, cause, getSpam, rules$lambda$1$lambda$0, rules$lambda$1, rules$lambda$3$lambda$2, rules$lambda$3, rules$lambda$5$lambda$4, rules$lambda$5, rules$lambda$7$lambda$6, rules$lambda$7, rules$lambda$9$lambda$8, rules$lambda$9, spam$lambda$20$lambda$10, spam$lambda$20$lambda$11, spam$lambda$20$lambda$12, spam$lambda$20$lambda$13, spam$lambda$20$lambda$14, spam$lambda$20$lambda$15, spam$lambda$20$lambda$16, spam$lambda$20$lambda$17, spam$lambda$20$lambda$18, spam$lambda$20$lambda$19, spam$lambda$20 |
| top-level / `com/simplechat/rules/common/Drops.java` | `` |  | getREWARDS, getSKYBLOCK_XP, getSkyblockXp, getRules, skyblockXp$lambda$1$lambda$0, skyblockXp$lambda$1, rules$lambda$8$lambda$2, rules$lambda$8$lambda$3, rules$lambda$8$lambda$4, rules$lambda$8$lambda$5, rules$lambda$8$lambda$6, rules$lambda$8$lambda$7, rules$lambda$8 |
| top-level / `com/simplechat/rules/common/Economy.java` | `` |  | getSACKS, getPICKUP_STASH, getLOOT_SHARE, getGEXP, getRARE_REWARD, getRules, rules$lambda$1$lambda$0, rules$lambda$1, rules$lambda$5$lambda$2, rules$lambda$5$lambda$3, rules$lambda$5$lambda$4, rules$lambda$5, rules$lambda$8$lambda$6, rules$lambda$8$lambda$7, rules$lambda$8, rules$lambda$10$lambda$9, rules$lambda$10, rules$lambda$12$lambda$11, rules$lambda$12 |
| top-level / `com/simplechat/rules/common/Events.java` | `` |  | getEVENTS, getRules, rules$lambda$5$lambda$0, rules$lambda$5$lambda$1, rules$lambda$5$lambda$2, rules$lambda$5$lambda$3, rules$lambda$5$lambda$4, rules$lambda$5 |
| top-level / `com/simplechat/rules/common/Misc.java` | `` |  | getMISC, getRules, rules$lambda$0 |
| top-level / `com/simplechat/rules/common/Npc.java` | `` |  | getNPC_DIALOG, getABIPHONE, getRules, rules$lambda$1$lambda$0, rules$lambda$1, rules$lambda$3$lambda$2, rules$lambda$3 |
| top-level / `com/simplechat/rules/common/Pets.java` | `` |  | getPET_SPAWN, getPET_SUMMON, getAUTOPET, getRules, rules$lambda$1$lambda$0, rules$lambda$1, rules$lambda$3$lambda$2, rules$lambda$3, rules$lambda$5$lambda$4, rules$lambda$5 |
| top-level / `com/simplechat/rules/common/Slayer.java` | `` |  | getSLAYER, getRules, brand, mark, levelLine, process, start, level, stale, displayed, drop, merged, rules$lambda$4$lambda$0, rules$lambda$4$lambda$1, rules$lambda$4$lambda$2, rules$lambda$4$lambda$3, rules$lambda$4 |
| top-level / `com/simplechat/rules/common/Warnings.java` | `` |  | getWARNINGS, getRules, rules$lambda$0 |
| top-level / `com/simplechat/rules/Fmt.java` | `` |  | shortNum, wordToHours, src, stripNpc, indent, rawColor, rawSpan, rawItem |
| top-level / `com/simplechat/rules/Group.java` | `` |  | getId, getTitle, getCategory, getSection, getDefault, getDescription, getTab, getSplit, component1, component2, component3, component4, component5, component6, component7, component8, copy, toString, hashCode, equals |
| top-level / `com/simplechat/rules/islands/Dungeons.java` | `` |  | getDUNGEONS, getNpc, untag, getRules, npc$lambda$4$lambda$0, npc$lambda$4$lambda$1, npc$lambda$4$lambda$2, npc$lambda$4$lambda$3, npc$lambda$4, rules$lambda$16$lambda$5, rules$lambda$16$lambda$6, rules$lambda$16$lambda$7, rules$lambda$16$lambda$8, rules$lambda$16$lambda$9, rules$lambda$16$lambda$10, rules$lambda$16$lambda$11, rules$lambda$16$lambda$12, rules$lambda$16$lambda$15, rules$lambda$16 |
| top-level / `com/simplechat/rules/islands/Foraging.java` | `` |  | getTREE_GIFT, getFLOOR_DROP, getTIMBER, getDAILY_BUFF, getHONEY_TREE, getAPPEARED, getSHARDS, getHUNTING, getBIRDFEEDER, getSAFARI_ENTRY, getSAFARI_CAPTURE, getSAFARI_MANAGER, getSAFARI_SUMMARY, getSAFARI_MILESTONES, getSAFARI_DISABLED, getTORRHUS, getHIVE, getRules, rules$lambda$1$lambda$0, rules$lambda$1, rules$lambda$3$lambda$2, rules$lambda$3, rules$lambda$5$lambda$4, rules$lambda$5, rules$lambda$12$lambda$6, rules$lambda$12$lambda$7, rules$lambda$12$lambda$8, rules$lambda$12$lambda$9, rules$lambda$12$lambda$10, rules$lambda$12$lambda$11, rules$lambda$12, rules$lambda$16$lambda$13, rules$lambda$16$lambda$14, rules$lambda$16$lambda$15, rules$lambda$16, rules$lambda$20$lambda$17, rules$lambda$20$lambda$18, rules$lambda$20$lambda$19, rules$lambda$20, rules$lambda$23$lambda$21, rules$lambda$23$lambda$22, rules$lambda$23, rules$lambda$26$lambda$24, rules$lambda$26$lambda$25, rules$lambda$26, rules$lambda$29$lambda$27, rules$lambda$29$lambda$28, rules$lambda$29, rules$lambda$31$lambda$30, rules$lambda$31, rules$lambda$33$lambda$32, rules$lambda$33, rules$lambda$34, rules$lambda$36$lambda$35, rules$lambda$36, rules$lambda$38$lambda$37, rules$lambda$38, rules$lambda$40$lambda$39, rules$lambda$40, rules$lambda$43$lambda$41, rules$lambda$43$lambda$42, rules$lambda$43, rules$lambda$46$lambda$44, rules$lambda$46$lambda$45, rules$lambda$46 |
| top-level / `com/simplechat/rules/islands/Mining.java` | `` |  | getCHEST_SUMMARY, getCHEST, getTOOL, getSKY_MALL, getPICKAXE, getCRYSTAL, getDETECTOR, getKEEPER, getGUARDS, getAUTOMATON, getRules, rules$lambda$1$lambda$0, rules$lambda$1, rules$lambda$5$lambda$2, rules$lambda$5$lambda$3, rules$lambda$5$lambda$4, rules$lambda$5, rules$lambda$7$lambda$6, rules$lambda$7, rules$lambda$11$lambda$8, rules$lambda$11$lambda$9, rules$lambda$11$lambda$10, rules$lambda$11, rules$lambda$15$lambda$12, rules$lambda$15$lambda$13, rules$lambda$15$lambda$14, rules$lambda$15, rules$lambda$22$lambda$16, rules$lambda$22$lambda$17, rules$lambda$22$lambda$18, rules$lambda$22$lambda$19, rules$lambda$22$lambda$20, rules$lambda$22$lambda$21, rules$lambda$22, rules$lambda$24$lambda$23, rules$lambda$24, rules$lambda$26$lambda$25, rules$lambda$26, rules$lambda$27, rules$lambda$30$lambda$28, rules$lambda$30$lambda$29, rules$lambda$30 |
| top-level / `com/simplechat/rules/lobby/Boosters.java` | `` |  | getBOOSTER, getGENEROSITY, getPLAYTIME, getREWARD_LINK, getRules, rules$lambda$1$lambda$0, rules$lambda$1, rules$lambda$3$lambda$2, rules$lambda$3, rules$lambda$5$lambda$4, rules$lambda$5, rules$lambda$7$lambda$6, rules$lambda$7 |
| top-level / `com/simplechat/rules/lobby/Joins.java` | `` |  | getLOBBY_JOIN, getRules, rules$lambda$1$lambda$0, rules$lambda$1 |
| top-level / `com/simplechat/rules/lobby/Morphs.java` | `` |  | getMORPH, getRules, rules$lambda$1$lambda$0, rules$lambda$1 |
| top-level / `com/simplechat/rules/lobby/Notifications.java` | `` |  | getNOTIFICATIONS, getRules, rules$lambda$5$lambda$0, rules$lambda$5$lambda$1, rules$lambda$5$lambda$2, rules$lambda$5$lambda$3, rules$lambda$5$lambda$4, rules$lambda$5 |
| top-level / `com/simplechat/rules/lobby/Rewards.java` | `` |  | getMYSTERY, getCLAIMED, getRules, rules$lambda$1$lambda$0, rules$lambda$1, rules$lambda$3$lambda$2, rules$lambda$3 |
| top-level / `com/simplechat/rules/Match.java` | `` |  | getClean, getRaw, get |
| top-level / `com/simplechat/rules/Registry.java` | `` |  | getGroups, getRules, getByGroup, find, match, actionOf, enabled |
| top-level / `com/simplechat/rules/Rule.java` | `` |  | getId, getGroup, getDefault, getCompact, getSample, getTitle, match |
| top-level / `com/simplechat/rules/RuleKt.java` | `` |  | rules |
| top-level / `com/simplechat/rules/RuleSet.java` | `` |  | getList, rule |
| top-level / `com/simplechat/rules/Section.java` | `` |  | getTitle, values, valueOf, getEntries |
| top-level / `com/simplechat/rules/system/Server.java` | `` |  | getPROFILE_ID, getROUTING, getRules, rules$lambda$1$lambda$0, rules$lambda$1, rules$lambda$3$lambda$2, rules$lambda$3 |
| top-level / `com/simplechat/rules/system/Transitions.java` | `` |  | getTRANSITIONS, getRules, rules$lambda$10$lambda$0, rules$lambda$10$lambda$1, rules$lambda$10$lambda$2, rules$lambda$10$lambda$3, rules$lambda$10$lambda$4, rules$lambda$10$lambda$5, rules$lambda$10$lambda$6, rules$lambda$10$lambda$7, rules$lambda$10$lambda$8, rules$lambda$10$lambda$9, rules$lambda$10 |
| top-level / `com/simplechat/rules/Tab.java` | `` |  | getTitle, values, valueOf, getEntries |
| top-level / `com/simplechat/SafariSummary.java` | `` |  | process, end, line, line$lambda$0 |
| top-level / `com/simplechat/SimpleChatMod.java` | `` |  | onInitializeClient, muteFeedback, openConfig, onInitializeClient$lambda$11$lambda$0, onInitializeClient$lambda$11$lambda$1, onInitializeClient$lambda$11$lambda$2, onInitializeClient$lambda$11$lambda$3, onInitializeClient$lambda$11$lambda$4, onInitializeClient$lambda$11$lambda$5, onInitializeClient$lambda$11$lambda$6, onInitializeClient$lambda$11$lambda$7, onInitializeClient$lambda$11$lambda$9$lambda$8, onInitializeClient$lambda$11, onInitializeClient$lambda$12, onInitializeClient$lambda$13, onInitializeClient$lambda$14 |
| top-level / `com/simplechat/TreeGiftTotals.java` | `` |  | tree, record, report, reset, parse, header, line, amount, group, num, record$lambda$1, getLabel, getMin, setMin, getMax, setMax, getLabel, getGifts, setGifts, getGains |
| top-level / `com/simplechat/ui/ConfigScreens.java` | `` |  | open |
| top-level / `com/simplechat/ui/HscModMenu.java` | `` |  | getModConfigScreenFactory, getModConfigScreenFactory$lambda$0 |
| top-level / `com/simplechat/ui/MenuLayout.java` | `` |  | getViews, getBulk, getPhraseOwner, getCategoryBulk, getTitles, build, withPhrases |
| top-level / `com/simplechat/ui/MenuScreen.java` | `` |  | setFocused, setSearchFocused, personalRows, winW, winH, winX, winY, regionTop, regionBottom, sideX1, sideX2, mainX1, mainX2, showPreview, settingsX2, previewX1, widgetW, hasTopTabs, searchRect, listTop, viewportH, contentHeight, maxScroll, eachItem, settingTop, widgetBoxAt, toggleBoxAt, categoryConfig, kindOf, bulkRow, categoryRow, commonValue, settingsOf, buildItems, refresh, rebuildPreview, toEntry, select, selectTop, onValueChanged, extractRenderState, renderNav, renderSettings, renderHeader, renderRow, presetButtons, presetBtnY, renderPresetRow, applyPreset, renderPreview, renderFooter, dropdownTop, renderDropdown, mouseClicked, handleRowClick, pickerSqY, openPicker, applyPicker, updateSV, updateHue, renderColorPicker, renderTooltip, tip, wrappedText, mouseDragged, mouseReleased, commitFocused, mouseScrolled, keyPressed, charTyped, onClose, removed, topTabRects, navRects, inRect, outline, rr, rrb, opaque, hex, parseHex, renderSettings$lambda$26, mouseClicked$lambda$29, renderTooltip$lambda$31, getTitle, values, valueOf, getEntries, getIndex, getIndex, getRow, getTitle, getText, getHover, getKey, getLabel, getX1, getY1, getX2, getY2, getEntry, getId, getTitle, getKind, getDesc, getBulkIds |
| top-level / `com/simplechat/ui/MenuTheme.java` | `` |  | tabAccent, sectionTint |
| top-level / `com/simplechat/ui/Preview.java` | `` |  | guild, public, who, level, alwaysGone, blocksFor, msgs, bazaarBatch, pickupStash, render, forSettings, capped, blocksFor$flush, getSegs, getHover, component1, component2, copy, toString, hashCode, equals, getLine, getRaw |
| top-level / `com/simplechat/ui/Screens.java` | `` |  | textInputFocus, set |
| top-level / `com/simplechat/Updater.java` | `` |  | init, checkManually, baseVersion, compareVersions, check, fetchLatest, isHypixel, send, updateMessage, prefix, CURRENT_VERSION$lambda$0, CURRENT_VERSION$lambda$1, MC_VERSION$lambda$2, MC_VERSION$lambda$3, init$lambda$7$lambda$6$lambda$5, init$lambda$7$lambda$6, init$lambda$7, checkManually$lambda$8, check$lambda$12, send$lambda$15, updateMessage$lambda$16 |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
