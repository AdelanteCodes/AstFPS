package dev.adelantecodes.astfps.client.render;

import dev.adelantecodes.astfps.client.AstFPSProfiles;
import dev.adelantecodes.astfps.client.AdaptiveRuntime;
import dev.adelantecodes.astfps.adaptive.ChunkPriority;
import net.minecraft.core.SectionPos;

/** Per-extraction admission control; rejected dirty sections remain eligible next frame. */
public final class ChunkUpdateAdmission {
    private int remaining;
    private double cameraSectionX, cameraSectionY, cameraSectionZ, forwardX, forwardZ;

    public void begin(int queuedJobs, double cameraX, double cameraY, double cameraZ,
                      double lookX, double lookZ) {
        cameraSectionX = cameraX / 16.0;
        cameraSectionY = cameraY / 16.0;
        cameraSectionZ = cameraZ / 16.0;
        forwardX = lookX;
        forwardZ = lookZ;
        var adaptive = AdaptiveRuntime.snapshot();
        int profilePercent = switch (AstFPSProfiles.current()) {
            case "maximum" -> 70;
            case "balanced" -> 100;
            default -> 130;
        };
        int perFrame = Math.max(1, adaptive.chunkJobsPerFrame() * profilePercent / 100);
        int outstandingLimit = Math.max(2, adaptive.chunkQueueLimit() * profilePercent / 100);
        remaining = Math.min(perFrame, Math.max(0, outstandingLimit - Math.max(0, queuedJobs)));
    }

    public boolean admit(long sectionNode, boolean playerChanged) {
        if (playerChanged) return true;
        int cost = ChunkPriority.admissionCost(SectionPos.x(sectionNode) - cameraSectionX,
            SectionPos.y(sectionNode) - cameraSectionY, SectionPos.z(sectionNode) - cameraSectionZ,
            forwardX, forwardZ);
        if (remaining < cost) return false;
        remaining -= cost;
        return true;
    }
}
