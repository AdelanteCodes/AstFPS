package dev.adelantecodes.astfps.client.ui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.network.chat.Component;

final class StateButton extends AbstractWidget {
    private final Runnable action; private final int level; private final int maximum;
    StateButton(int x, int y, int width, int height, String label, int level, int maximum, Runnable action) {
        super(x, y, width, height, Component.literal(label)); this.action = action;
        this.level = Math.max(0, level); this.maximum = Math.max(1, maximum);
    }
    @Override protected void extractWidgetRenderState(GuiGraphicsExtractor g, int mx, int my, float delta) {
        int color = color(level, maximum); if (isHoveredOrFocused()) color = lighten(color);
        g.fill(getX(), getY(), getRight(), getBottom(), 0xFF111820);
        g.fill(getX() + 1, getY() + 1, getRight() - 1, getBottom() - 1, color);
        String text = getMessage().getString(); var font = Minecraft.getInstance().font;
        g.text(font, text, getX() + (getWidth() - font.width(text)) / 2, getY() + (getHeight() - 9) / 2, 0xFFFFFFFF, true);
    }
    @Override public void onClick(MouseButtonEvent event, boolean doubleClick) { if (active) action.run(); }
    @Override protected void updateWidgetNarration(NarrationElementOutput output) { defaultButtonNarrationText(output); }
    private static int color(int level, int max) { float t = Math.min(1f, level / (float) max); int r=(int)(182+(54-182)*t), g=(int)(54+(168-54)*t), b=(int)(54+(82-54)*t); return 0xFF000000|r<<16|g<<8|b; }
    private static int lighten(int c) { int r=Math.min(255,((c>>16)&255)+24),g=Math.min(255,((c>>8)&255)+24),b=Math.min(255,(c&255)+24); return 0xFF000000|r<<16|g<<8|b; }
}
