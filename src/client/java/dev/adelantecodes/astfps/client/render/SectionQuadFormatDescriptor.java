package dev.adelantecodes.astfps.client.render;

import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.renderpearl.api.vertex.VertexFormat;
import com.mojang.renderpearl.api.vertex.VertexFormatElement;

/** One immutable native BLOCK descriptor; never owns buffers or changes vertex emission. */
public final class SectionQuadFormatDescriptor {
    private static final String[] NAMES = { "Position", "Color", "UV0", "UV1", "UV2", "UV3", "Normal", "LineWidth" };
    private static volatile SectionQuadFormatDescriptor cached;
    private final VertexFormat format;
    private final VertexFormatElement[] elements;

    private SectionQuadFormatDescriptor(VertexFormat format, VertexFormatElement[] elements) {
        this.format = format;
        this.elements = elements;
    }

    public static boolean matches(int index, String name) {
        return index >= 0 && index < NAMES.length && NAMES[index].equals(name);
    }

    public static boolean eligible(BufferBuilder builder, VertexFormat format) {
        return SectionCompilationContext.borrowing(SectionCompilationContext.QUAD)
                && builder.getClass() == BufferBuilder.class && format == DefaultVertexFormat.BLOCK
                && format.getClass() == VertexFormat.class;
    }

    public static SectionQuadFormatDescriptor lookup(VertexFormat format) {
        SectionQuadFormatDescriptor descriptor = cached;
        return descriptor != null && descriptor.format == format ? descriptor : null;
    }

    public VertexFormatElement element(int index) {
        return elements[index];
    }

    public static void publish(VertexFormat format, VertexFormatElement[] elements) {
        if (format == DefaultVertexFormat.BLOCK && format.getClass() == VertexFormat.class) {
            // The completed constructor transfers its private capture array and never writes it again.
            cached = new SectionQuadFormatDescriptor(format, elements);
        }
    }

}
