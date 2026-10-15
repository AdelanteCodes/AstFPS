package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import dev.adelantecodes.astfps.client.render.TabListSnapshotCache;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.PlayerTabOverlay;
import net.minecraft.client.multiplayer.PlayerInfo;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerTabOverlay.class)
public abstract class PlayerTabSnapshotMixin {
    @Shadow @Final private Minecraft minecraft;
    @Unique private final TabListSnapshotCache astfpsTabSnapshot = new TabListSnapshotCache();

    @WrapMethod(method = "getPlayerInfos")
    private List<PlayerInfo> astfpsSortedPlayers(Operation<List<PlayerInfo>> original) {
        if (((Object) this).getClass() != PlayerTabOverlay.class) return original.call();
        return astfpsTabSnapshot.resolve(minecraft, original);
    }

    @Inject(method = "reset", at = @At("HEAD"))
    private void astfpsClearDisconnectedPlayers(CallbackInfo ci) { astfpsTabSnapshot.clear(); }

    @Inject(method = "setVisible", at = @At("HEAD"))
    private void astfpsClearHiddenPlayers(boolean visible, CallbackInfo ci) {
        if (!visible) astfpsTabSnapshot.clear();
    }
}
