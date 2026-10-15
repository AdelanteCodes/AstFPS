package dev.adelantecodes.astfps.client.ui;
import dev.adelantecodes.astfps.client.*;
import dev.adelantecodes.astfps.client.render.FrameGenerationController;
import java.io.IOException;
import java.util.Locale;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.VideoSettingsScreen;
import net.minecraft.network.chat.Component;

public final class AstFPSSettingsScreen extends Screen {
    private final Screen parent; private String status = "Optimizations are enabled by default.";
    public AstFPSSettingsScreen(Screen parent) { super(Component.literal("AstFPS")); this.parent=parent; }
    private void button(String label,int x,int y,int w,int level,int max,Runnable action){ addRenderableWidget(new StateButton(x,y,w,24,label,level,max,action)); }
    @Override protected void init() {
        clearWidgets(); int w=Math.min(276,width-32),x=(width-w)/2,y=Math.max(28,Math.min(40,height/2-87));
        profile(AstFPSProfiles.Profile.MAXIMUM,6,x,y,w); profile(AstFPSProfiles.Profile.BALANCED,10,x,y+28,w); profile(AstFPSProfiles.Profile.QUALITY,16,x,y+56,w);
        int half=(w-6)/2;
        var fg=FrameGenerationController.requested(); button("Frame Gen: "+(fg==FrameGenerationController.Mode.OFF?"[OFF]":"[ON] "+fg.label()),x,y+88,half,fg.ordinal(),FrameGenerationController.Mode.values().length-1,this::cycleFrameGeneration);
        button("Full Bright: "+onOff(V1Features.fullBright()),x,y+116,half,V1Features.fullBright()?1:0,1,()->{V1Features.fullBright(!V1Features.fullBright());save("Full Bright preference saved.");rebuildWidgets();});
        var ram=V1Features.lowRam(); button("Low RAM: ["+ram+"]",x+half+6,y+116,half,ram.ordinal(),2,()->{V1Features.lowRam(ram.next());save("Low-RAM preference saved.");rebuildWidgets();});
        button("Advanced",x,y+148,half,1,1,()->minecraft.gui.setScreen(new AstFPSAdvancedScreen(this)));
        button("Video Settings",x+half+6,y+148,half,1,1,()->minecraft.gui.setScreen(new VideoSettingsScreen(this,minecraft,minecraft.options)));
        button("Done",x,y+176,w,1,1,this::onClose);
    }
    private void profile(AstFPSProfiles.Profile p,int chunks,int x,int y,int w){ boolean selected=AstFPSProfiles.current().equals(p.name().toLowerCase(Locale.ROOT)); button((selected?"[ON] ":"[OFF] ")+AstFPSProfiles.displayName(p)+" - "+chunks+" chunks",x,y,w,selected?1:0,1,()->apply(p)); }
    private static String onOff(boolean v){return v?"[ON]":"[OFF]";}
    private void save(String ok){try{AstFPSConfig.saveV1Features();status=ok;}catch(IOException e){status="Could not save: "+e.getMessage();}}
    private void cycleFrameGeneration(){var mode=FrameGenerationController.requested().next();FrameGenerationController.request(mode);try{AstFPSConfig.saveFrameGenerationMode(mode);status=FrameGenerationController.status();}catch(IOException e){status="Changed for this session; could not save: "+e.getMessage();}rebuildWidgets();}
    private void apply(AstFPSProfiles.Profile p){if(AstFPSClient.RECORDER.isRecording()){status="Stop the benchmark before changing mode.";return;}status=AstFPSProfiles.apply(minecraft,p);try{AstFPSConfig.saveProfile(p);if(V1Features.perWorldProfiles())AstFPSConfig.saveWorldProfile(AstFPSClient.worldKey(minecraft),p);minecraft.options.save();}catch(IOException e){status="Applied; could not save: "+e.getMessage();}rebuildWidgets();}
    @Override public void onClose(){minecraft.gui.setScreen(parent);}
    @Override public boolean isInGameUi(){return minecraft!=null&&minecraft.level!=null;}
    @Override public void extractRenderState(GuiGraphicsExtractor g,int mx,int my,float delta){g.fill(0,0,width,height,0x24101822);g.fill(0,0,width,2,0xFF51D9DB);String title="AstFPS Release V1";g.text(font,title,(width-font.width(title))/2,14,0xFF61E7EA);super.extractRenderState(g,mx,my,delta);String line=font.plainSubstrByWidth(status,width-24);g.text(font,line,(width-font.width(line))/2,height-16,0xFFD7E0E8);}
}
