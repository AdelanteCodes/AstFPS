# Section record reuse — Minecraft 26.3

Reviewed the local 26.3 client bytecode/decompilation for `DynamicGpuData`,
`DynamicGpuDataStorageMapped` and `DynamicGpuDataStorageNonMapped`. This note
describes the original AstFPS implementation; vanilla source is not copied here.

`ChunkSectionInfo` is an immutable record of three integer origin coordinates
and one floating-point visibility/fade value. It holds no section, world, model
or GPU resource. Both the direct array writer and the indirect list writer
serialize each record's current values into their own storage during preparation.
The non-mapped backend submits a CPU byte buffer, not a retained list of records.
AstFPS does not change that upload/storage lifecycle.

The original terrain stage previously created a new info record for each visible
section with drawable geometry on every preparation. dev.5 reuses the previous
record at the same output slot only if all coordinates and raw visibility bits
match. It still computes fade every frame and constructs a new record if any
value differs. Changed visibility order requires matching the newly assigned slot;
there is no assumption that a section remains at the same slot across frames.

Before either GPU writer runs, the list is truncated to this frame's actual
record count, including zero for an empty scene. On finish, at most 16,384 records
remain per renderer. Records beyond the budget are discarded and oversized list
capacity is trimmed. Renderer close/failure drops the workspace. The bounded
retention trades some live heap for fewer transient allocations; it is not a
claim that total RAM always falls.

Opaque buffer grouping now chains pooled CPU batches directly from each identity
map entry instead of allocating a candidate list per vertex buffer every frame.
The chain is discarded in `finally`, alongside GPU references. Ordered translucent
grouping retains its adjacent-only rule. A reverse command-list view is created
once per pooled batch, rather than per submission, and remains CPU-only.

Expected effect: fewer info records and grouping/view objects allocated in stable
terrain scenes. GPU uploads, geometry, lighting, fade and resource lifetimes are
unchanged. Diagnostic allocated/reused counters quantify which records qualify.
This is an allocation hypothesis, not measured CPU time, FPS or visual parity.
The original terrain stage remains opt-in pending user captures and runtime review.
