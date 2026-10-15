package dev.adelantecodes.astfps.client.ui;

import dev.adelantecodes.astfps.client.AstFPSClient;
import dev.adelantecodes.astfps.client.AstFPSConfig;
import dev.adelantecodes.astfps.client.AstFPSProfiles;
import java.io.IOException;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.VideoSettingsScreen;
import net.minecraft.network.chat.Component;
import dev.adelantecodes.astfps.client.render.FrameGenerationController;

/** Compact preset-first screen. Optimizations are automatic; this UI only chooses the visual/performance target. */
public final class AstFPSSettingsScreen extends Screen {
    private final Screen parent;
    private String status = "Optimizations are already enabled.";

    public AstFPSSettingsScreen(Screen parent) {
        super(Component.literal("AstFPS"));
        this.parent = parent;
    }

    private Button button(String label, int x, int y, int width, Runnable action) {
        return addRenderableWidget(Button.builder(Component.literal(label), ignored -> action.run())
            .bounds(x, y, width, 24).build());
    }

    @Override protected void init() {
        clearWidgets();
        int buttonWidth = Math.min(260, width - 40);
        int x = (width - buttonWidth) / 2;
        int y = Math.max(50, height / 2 - 86);
        button(profileLabel(AstFPSProfiles.Profile.MAXIMUM, 6), x, y, buttonWidth,
            () -> apply(AstFPSProfiles.Profile.MAXIMUM));
        button(profileLabel(AstFPSProfiles.Profile.BALANCED, 10), x, y + 30, buttonWidth,
            () -> apply(AstFPSProfiles.Profile.BALANCED));
        button(profileLabel(AstFPSProfiles.Profile.QUALITY, 16), x, y + 60, buttonWidth,
            () -> apply(AstFPSProfiles.Profile.QUALITY));
        button(frameGenerationLabel(), x, y + 94,
            buttonWidth, this::cycleFrameGeneration);
        button("Vanilla Video Settings", x, y + 124, buttonWidth, () ->
            minecraft.gui.setScreen(new VideoSettingsScreen(this, minecraft, minecraft.options)));
        button("Done", x, y + 154, buttonWidth, this::onClose);
    }

    private String profileLabel(AstFPSProfiles.Profile profile, int chunks) {
        boolean selected = AstFPSProfiles.current().equals(profile.name().toLowerCase(java.util.Locale.ROOT));
        return (selected ? "[ON] " : "[  ] ") + AstFPSProfiles.displayName(profile) + " - " + chunks + " chunks";
    }

    private String frameGenerationLabel() {
        var mode = FrameGenerationController.requested();
        return mode == FrameGenerationController.Mode.OFF
            ? "Frame Generation: [OFF]"
            : "Frame Generation: [ON] " + mode.label();
    }

    private void cycleFrameGeneration() {
        var mode = FrameGenerationController.requested().next();
        FrameGenerationController.request(mode);
        try {
            AstFPSConfig.saveFrameGenerationMode(mode);
            status = FrameGenerationController.status();
        } catch (IOException error) {
            status = "Frame Generation preference changed for this session, but could not be saved: " + error.getMessage();
        }
        rebuildWidgets();
    }

    private void apply(AstFPSProfiles.Profile profile) {
        if (AstFPSClient.RECORDER.isRecording()) {
            status = "Stop the benchmark before changing mode.";
            return;
        }
        status = AstFPSProfiles.apply(minecraft, profile);
        try {
            AstFPSConfig.saveProfile(profile);
            minecraft.options.save();
        } catch (IOException error) {
            status = "Mode applied, but could not save it: " + error.getMessage();
        }
        rebuildWidgets();
    }

    @Override public void onClose() { minecraft.gui.setScreen(parent); }

    /** Keep the paused world readable: use Minecraft's translucent in-game backdrop without its blur pass. */
    @Override public boolean isInGameUi() { return minecraft != null && minecraft.level != null; }

    @Override public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
        graphics.fill(0, 0, width, height, 0x38101822);
        graphics.fill(0, 0, width, 2, 0xFF51D9DB);
        String title = "AstFPS 0.9 Beta";
        graphics.text(font, title, (width - font.width(title)) / 2, 18, 0xFF61E7EA);
        String subtitle = "Choose one mode. Everything else is automatic.";
        graphics.text(font, subtitle, (width - font.width(subtitle)) / 2, 34, 0xFFB2BFCC);
        super.extractRenderState(graphics, mouseX, mouseY, delta);
        String line = font.plainSubstrByWidth(status, width - 24);
        graphics.text(font, line, (width - font.width(line)) / 2, height - 22, 0xFFB2BFCC);
    }
}
