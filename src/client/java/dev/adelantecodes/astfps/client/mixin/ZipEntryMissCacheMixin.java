package dev.adelantecodes.astfps.client.mixin;

import dev.adelantecodes.astfps.client.resources.ZipEntryMissCache;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.minecraft.server.packs.FilePackResources;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Startup opt-in: preserve native enumeration and all positive lookup/supplier behavior. */
@Mixin(FilePackResources.class)
public abstract class ZipEntryMissCacheMixin {
    @Unique private final ZipEntryMissCache astfpsZipMisses = new ZipEntryMissCache();

    @Redirect(method = "getResource(Ljava/lang/String;)Lnet/minecraft/server/packs/resources/IoSupplier;",
            at = @At(value = "INVOKE", target = "Ljava/util/zip/ZipFile;getEntry(Ljava/lang/String;)Ljava/util/zip/ZipEntry;"))
    private ZipEntry astfpsMissingZipEntry(ZipFile zip, String path) {
        return astfpsZipMisses.lookup(zip, path);
    }

    @Inject(method = "close", at = @At("HEAD"))
    private void astfpsDropZipMisses(CallbackInfo ci) {
        astfpsZipMisses.clear();
    }
}
