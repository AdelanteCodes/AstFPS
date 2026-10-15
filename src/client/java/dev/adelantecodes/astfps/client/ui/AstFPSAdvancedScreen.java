package dev.adelantecodes.astfps.client.ui;
import dev.adelantecodes.astfps.client.*;
import java.io.IOException;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

final class AstFPSAdvancedScreen extends Screen {
    private final Screen parent; private String status="Changes apply immediately unless stated otherwise.";
    AstFPSAdvancedScreen(Screen parent){super(Component.literal("AstFPS Advanced"));this.parent=parent;}
    private void b(String s,int x,int y,int w,int l,int m,Runnable r){addRenderableWidget(new StateButton(x,y,w,24,s,l,m,r));}
    @Override protected void init(){clearWidgets();int w=Math.min(310,width-32),x=(width-w)/2,y=Math.max(42,height/2-112);
        var c=V1Features.culling();b("Entity / Particle Culling: ["+c+"]",x,y,w,c.ordinal(),3,()->{V1Features.culling(c.next());save();rebuildWidgets();});
        var s=V1Features.chunkSmoothing();b("Chunk-Stutter Smoothing: ["+s+"]",x,y+28,w,s.ordinal(),3,()->{V1Features.chunkSmoothing(s.next());save();rebuildWidgets();});
        var q=V1Features.frameGenQuality();b("Frame-Gen Quality: ["+q+"]",x,y+56,w,q.ordinal(),2,()->{V1Features.frameGenQuality(q.next());save();rebuildWidgets();});
        var l=V1Features.latency();b("Latency Mode: ["+l+"]",x,y+84,w,l.ordinal(),2,()->{V1Features.latency(l.next());save();rebuildWidgets();});
        toggle("Honest FPS Overlay",V1Features.overlay(),x,y+112,w,()->V1Features.overlay(!V1Features.overlay()));
        toggle("Per-World Profiles",V1Features.perWorldProfiles(),x,y+140,w,()->V1Features.perWorldProfiles(!V1Features.perWorldProfiles()));
        toggle("Compatibility Protection",V1Features.compatibilityProtection(),x,y+168,w,()->V1Features.compatibilityProtection(!V1Features.compatibilityProtection()));
        int h=(w-6)/2;b("Save Diagnostics",x,y+200,h,1,1,()->status=AstFPSClient.uiAction("diagnose"));b("Back",x+h+6,y+200,h,1,1,this::onClose);
    }
    private void toggle(String n,boolean v,int x,int y,int w,Runnable change){b(n+": "+(v?"[ON]":"[OFF]"),x,y,w,v?1:0,1,()->{change.run();save();rebuildWidgets();});}
    private void save(){try{AstFPSConfig.saveV1Features();status="Saved.";}catch(IOException e){status="Could not save: "+e.getMessage();}}
    @Override public void onClose(){minecraft.gui.setScreen(parent);}
    @Override public boolean isInGameUi(){return minecraft!=null&&minecraft.level!=null;}
    @Override public void extractRenderState(GuiGraphicsExtractor g,int mx,int my,float d){g.fill(0,0,width,height,0x24101822);String t="AstFPS V1 - Advanced";g.text(font,t,(width-font.width(t))/2,16,0xFF61E7EA);super.extractRenderState(g,mx,my,d);String line=font.plainSubstrByWidth(status,width-20);g.text(font,line,(width-font.width(line))/2,height-17,0xFFD7E0E8);}
}
