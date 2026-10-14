package dev.kyzer.xemod.benchmark;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
@Mixin(CreateWorldScreen.class)
public interface CreateWorldInvoker {
    @Invoker("onCreate") void xeBenchmarkCreate();
}
