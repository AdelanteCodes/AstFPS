# Client rendering follow-up, 2026-10-15

Primary-source discovery only; these are not implementation audits or measured AstFPS gains.

- EntityCulling: https://github.com/tr7zw/EntityCulling . Client asynchronous occlusion and client tick culling. Candidate for deeper integration, but worker snapshots, stale-result invalidation, conservative visible fallback and custom-renderer exemptions need exact 26.3 review. No server installation required by its documented design.
- MoreCulling: https://github.com/FxMorin/MoreCulling . Hidden-face work elimination. Repository explicitly asks permission for merging into another mod/client; do not transplant implementation on this discovery pass. Native independent algorithms remain a separate design task.
- Exordium: https://github.com/tr7zw/Exordium/releases . Maintainer says not actively maintained and warns of visual problems. Reduced UI refresh changes presentation; not a transparent optimization or immediate inclusion candidate.
- VRAM Tweak: https://github.com/Coconutat/Minecraft-VRAM-Tweak . Current inspected branch targets Fabric 26.2; texture caps, lower precision, frame limits and dynamic draw distance change output. Allocation accounting could inform original diagnostics, but cannot assume graphics correctness from publisher labels. No blind texture-size interception.
- Tessera: https://github.com/PanzerDevOrg/Tessera . NeoForge 1.21.1 texture compression/native encoder project; not a drop-in Fabric 26.3 component. BC7 is lossy, requires supported formats, mip/alpha handling and texture upload integration. Publisher memory claims are not AstFPS benchmarks.

Keep client-only deployment. Server generation accelerators cannot improve a remote server merely by installing AstFPS on the player's client.

## First Optis inspection

Read local reconstructed `optis/texture/TextureDemoter.java` and `optis/scheduler/TextureUploadQueue.java`. Demotion checks main-thread ownership, critical/placeholder status and exact TextureManager mapping before releasing GPU resources and removing a tick listener. Cold demotion discards DynamicTexture pixels only for reloadable resource identifiers. Upload queue deduplicates identifiers, caps tasks per tick and supplies a reload-generation value to task execution; finally clears queued identifiers. Task implementation, generation handling and already-submitted GPU reads are not yet audited. These are useful lifetime-design references, not sufficient evidence to transplant demotion. No Optis code included.

## Next native CPU rendering investigation

Exact eviction-preserving replacement of BlockModelLighter.Cache's 100-entry primitive linked maps could avoid repeated hash/link maintenance in AO. Preserve original FIFO eviction, NaN sentinel behavior and every actual brightness/shade query. Do not simply grow cache or retain results longer: RenderSectionRegion reaches a live LevelLightEngine. This is a candidate, not implemented or measured.
