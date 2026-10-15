# Batch2 integration decisions
All15 recorded batch2 mods considered; original upstream/repository left read-only; no blanket bundle imports.
Static source/bytecode and mathematical proof only; no unit/runtime tests, Minecraft, network execution or benchmark. Parent owns registration and coordinated compilation.

Implemented: original pure VarInt size arithmetic; parent registration pending.

Native result is smallest k in1..4 with no unsigned bits at or above7k, otherwise5. Define b=32-numberOfLeadingZeros(value|1), hence1<=b<=32; result ceil(b/7)=(b+6)/7. Negative values haveb32 and give5. Native native getByteSize performs no IO, mutates no state and throws no input-specific exception. Replaced arithmetic is independent of byte order, buffers and packet lifetime. getByteSize formula derived independently; no third-party code copied.

Removes variable-count branch/mask loop; leadingZeros lowering and division by constant may depend on JIT. No measured CPU/FPS/heap benefit asserted. Typed method avoids extra callback/varargs allocations.

Mixin must be absent unless astfps.enableVarIntSize=true and safeMode=false; exclude installed Krypton and any known competing VarInt overwrite. Client-side only. No runtime command claims because overwrite installation is startup-only.

## accelerated-recoiling 26.3.0-fabric
not integrated: Native collision batching overlaps Lithium and requires ABI, candidate-order, cramming RNG and mutation-hook parity proof; no native module or gameplay shortcut added.

## potatoptimize mc26.2-2.2.2
not integrated: Selected spawn/navigation changes risk random-stream/gameplay differences and overlap Lithium. Seasonal caching changes wall-clock transition semantics. No blanket transplant.

## lomka mc26.3-0.7.0-fabric
partially derived independently: Existing opt-in terrain CPU record reuse, section-state memo and model-rotation scratch are original narrow mechanisms informed by this study. Cube scratch was rejected because operation bridge allocations can exceed savings. No AO formula, packed writer or GPU slice lifetime changes imported.

## krypton 0.3.2
narrow original CPU optimization implemented: NEW VarIntSize.of(int) plus startup-gated VarIntSizeMixin changes only pure getByteSize arithmetic. Full network compression/framing/native codecs not bundled. Root registration must exclude Krypton because its exact local mixin overwrites the same method.

## zfastnoise 1.1.1+26.3
not integrated: Direct palette writes assume task ownership, palette<=16 and slot-zero AIR; worldgen output/locking/rollback not validated. Does not improve existing terrain render submission.

## zfastsurface 1.0.0+26.3
not integrated: Rule-state completeness, palette relocation, heightmap/fluid postprocessing and external generator ownership unproven; no raw storage mutation.

## zmaterial-rule-compiler 1.1.2+26.3
not integrated: Saved bytecode confirms float narrowing before double return in positional RNG. Unbounded outer specialization keys and generated classes need lifecycle proof. No worldgen compiler adopted.

## better-biome-blend 26.3-1.4.0-fabric
not integrated: OKLab blend intentionally differs from native color sampling/output; slice-key domain and invalidation/lock ownership need proof. Visual parity target excludes replacement.

## structure-layout-optimizer 1.1.4+26.3-fabric
not integrated: Compressed template list narrows coordinate domains and changes collection mutability/aliasing; octree placement tolerance not fully established. No generic collection substitution.

## fast-ip-ping v1.0.12-mc26.3
rejected after additional native audit: Exact native26.3 AddressCheck.isAllowed(ResolvedServerAddress) obtains getHostName and tests both hostname and IP. Numeric-host substitution before this check changes native hostname-policy semantics; IPv6 scope also requires care. No DNS shortcut added.

## do-i-reload 1.1
rejected: Selected private hasChanges has no observed assignment; cancelling native onClose skips guaranteed watcher cleanup. No reload or watcher cancellation.

## server-resource-pack-checker fabric-1.2.2+26.3
rejected: Selected hash match does not prove full ordered stack equivalence; early loaded acknowledgements and stream ownership flaws change lifecycle. No pack handshake/reload shortcuts.

## language-reload 1.7.8+26.3
not integrated: Language-only reload bypasses arbitrary mod listeners and requires complete dependent text/font/cache invalidation. Native reload semantics retained.

## resourcepackcached 1.2.8
rejected: UUID/path existence without digest/ordered-stack equivalence cannot establish correct current resources; retaining server packs across disconnect changes visuals/lifecycle.

## fastserverpings 1.1.5+26.3
rejected: Selected implementation has IPv6 host parsing errors, listener coalescing loss, dropped future tasks and ByteBuf ownership leaks. No ping executor/network lifecycle replacement.
