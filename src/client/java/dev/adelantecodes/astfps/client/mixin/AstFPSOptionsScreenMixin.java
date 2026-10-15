package dev.adelantecodes.astfps.client.mixin;

import dev.adelantecodes.astfps.client.ui.AstFPSSettingsScreen;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OptionsScreen.class)
public abstract class AstFPSOptionsScreenMixin extends Screen {
    protected AstFPSOptionsScreenMixin(Component title) { super(title); }

    @Inject(method = "lambda$init$2", at = @At("HEAD"), cancellable = true)
    private void astfpsVideoScreen(CallbackInfoReturnable<Screen> callback) {
        if (!FabricLoader.getInstance().isModLoaded("sodium")) callback.setReturnValue(new AstFPSSettingsScreen(this));
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void astfpsCompanionButton(CallbackInfo callback) {
        if (FabricLoader.getInstance().isModLoaded("sodium")) {
            addRenderableWidget(Button.builder(Component.literal("AstFPS"), button -> minecraft.gui.setScreen(new AstFPSSettingsScreen(this)))
                .bounds(width - 84, 5, 78, 20).build());
        }
    }
}
