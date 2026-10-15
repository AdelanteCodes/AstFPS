package dev.adelantecodes.astfps.client.render;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.world.level.GameType;

/** Reuse native sorted output only after comparing every native ordering input and source position. */
public final class TabListSnapshotCache {
    private static final int LIMIT = 1024;
    private final Thread owner = Thread.currentThread();
    private PlayerInfo[] players = new PlayerInfo[0];
    private String[] names = new String[0];
    private String[] teams = new String[0];
    private int[] orders = new int[0];
    private boolean[] spectators = new boolean[0];
    private int count;
    private int referenceCount;
    private long generation;
    private List<PlayerInfo> result;
    private WeakReference<Object> connection = new WeakReference<>(null);
    private WeakReference<Object> level = new WeakReference<>(null);
    private boolean busy;

    public void clear() {
        generation++;
        if (referenceCount != 0) {
            Arrays.fill(players, 0, referenceCount, null);
            Arrays.fill(names, 0, referenceCount, null);
            Arrays.fill(teams, 0, referenceCount, null);
            referenceCount = 0;
        }
        result = null;
        count = 0;
        connection.clear();
        level.clear();
    }

    public List<PlayerInfo> resolve(Minecraft client, Operation<List<PlayerInfo>> original) {
        if (Thread.currentThread() != owner || !client.isSameThread() || busy) {
            AstFPSRuntime.tabCacheBypasses.increment();
            return original.call();
        }
        if (!AstFPSRuntime.TAB_LIST_CACHE.enabled() || client.player == null || client.level == null) {
            clear();
            AstFPSRuntime.tabCacheBypasses.increment();
            return original.call();
        }
        busy = true;
        boolean delegated = false;
        List<PlayerInfo> nativeResult = null;
        try {
            Object currentConnection = client.player.connection;
            Object currentLevel = client.level;
            Collection<PlayerInfo> listed = client.player.connection.getListedOnlinePlayers();
            if (listed.size() > LIMIT) {
                clear();
                AstFPSRuntime.tabCacheBypasses.increment();
                delegated = true;
                return original.call();
            }
            if (result != null && connection.get() == currentConnection && level.get() == currentLevel
                    && matches(listed) && AstFPSRuntime.TAB_LIST_CACHE.enabled()) {
                AstFPSRuntime.tabCacheHits.increment();
                return result;
            }
            if (result != null) AstFPSRuntime.tabCacheInvalidations.increment();
            clear();
            boolean captured = capture(listed);
            long capturedGeneration = generation;
            AstFPSRuntime.tabCacheMisses.increment();
            delegated = true;
            nativeResult = original.call();
            // A delegate can reenter/reset or change the active level/list. Publish only a stable snapshot.
            if (captured && generation == capturedGeneration && AstFPSRuntime.TAB_LIST_CACHE.enabled() && client.player != null
                    && client.player.connection == currentConnection && client.level == currentLevel
                    && matches(client.player.connection.getListedOnlinePlayers())
                    && nativeResult != null && nativeResult.size() <= 80) {
                List<PlayerInfo> immutable = List.copyOf(nativeResult);
                if (generation == capturedGeneration) {
                    result = immutable;
                    connection = new WeakReference<>(currentConnection);
                    level = new WeakReference<>(currentLevel);
                } else clear();
            } else clear();
            return nativeResult;
        } catch (RuntimeException error) {
            clear();
            reportFailure(error);
            if (delegated) {
                if (nativeResult != null) return nativeResult;
                throw error;
            }
            // Validation failed before the delegate ran. Preserve native callbacks/errors with one invocation.
            return original.call();
        } catch (Error error) {
            clear();
            reportFailure(error);
            throw error;
        } finally {
            busy = false;
        }
    }

    private static void reportFailure(Throwable error) {
        try {
            AstFPSRuntime.tabCacheFailure("PlayerTabOverlay.getPlayerInfos", error);
        } catch (RuntimeException | Error logging) {
            if (logging == error) return;
            try { error.addSuppressed(logging); }
            catch (RuntimeException | Error ignored) { /* Preserve the original failure under memory pressure. */ }
        }
    }

    private boolean capture(Collection<PlayerInfo> listed) {
        long capturedGeneration = generation;
        int expected = listed.size();
        if (expected < 0 || expected > LIMIT) return false;
        if (players.length < expected) {
            players = new PlayerInfo[expected];
            names = new String[expected];
            teams = new String[expected];
            orders = new int[expected];
            spectators = new boolean[expected];
        }
        int i = 0;
        for (PlayerInfo player : listed) {
            if (i >= expected || player == null || player.getClass() != PlayerInfo.class) return false;
            String name = player.getProfile().name();
            var team = player.getTeam();
            String teamName = team == null ? "" : team.getName();
            int order = player.getTabListOrder();
            boolean spectator = player.getGameMode() == GameType.SPECTATOR;
            if (generation != capturedGeneration) return false;
            // Set before the first assignment so partial capture failures also release every reference.
            referenceCount = i + 1;
            players[i] = player;
            names[i] = name;
            teams[i] = teamName;
            orders[i] = order;
            spectators[i] = spectator;
            i++;
        }
        count = i;
        return i == expected && generation == capturedGeneration;
    }

    private boolean matches(Collection<PlayerInfo> listed) {
        long observedGeneration = generation;
        if (listed.size() != count) return false;
        int i = 0;
        for (PlayerInfo player : listed) {
            if (i >= count || player != players[i] || player.getClass() != PlayerInfo.class
                    || player.getTabListOrder() != orders[i]
                    || (player.getGameMode() == GameType.SPECTATOR) != spectators[i]
                    || !Objects.equals(player.getProfile().name(), names[i])) return false;
            var team = player.getTeam();
            if (!Objects.equals(team == null ? "" : team.getName(), teams[i])) return false;
            i++;
        }
        return i == count && generation == observedGeneration;
    }
}
