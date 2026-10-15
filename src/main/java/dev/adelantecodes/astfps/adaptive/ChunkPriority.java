package dev.adelantecodes.astfps.adaptive;

/** Camera-relative cost used when admitting dirty sections without changing vanilla ownership. */
public final class ChunkPriority {
    private ChunkPriority() { }

    public static int admissionCost(double dx, double dy, double dz, double forwardX, double forwardZ) {
        double horizontalDistanceSquared = dx * dx + dz * dz;
        if (horizontalDistanceSquared <= 16.0) return 1;
        double dot = dx * forwardX + dz * forwardZ;
        int cost = dot < 0 ? 2 : 1;
        if (horizontalDistanceSquared > 144.0 || Math.abs(dy) > 8.0) cost++;
        return cost;
    }
}
