package dev.adelantecodes.astfps.client;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import com.mojang.blaze3d.platform.InputConstants;

/** Hold-C client camera zoom. The wheel changes magnification only while zoom is held. */
public final class ZoomController {
    private static KeyMapping key;
    private static volatile boolean active;
    private static volatile float fovScale=0.25f;
    private ZoomController(){}
    public static void initialize(){
        key=KeyMappingHelper.registerKeyMapping(new KeyMapping("key.astfps.zoom",InputConstants.KEY_C,KeyMapping.Category.GAMEPLAY));
        ClientTickEvents.END_CLIENT_TICK.register(client->active=client.level!=null&&client.gui.screen()==null&&key.isDown());
    }
    public static boolean active(){return active;}
    public static float apply(float fov){return active?Math.max(1.0f,fov*fovScale):fov;}
    public static void scroll(double amount){
        if(amount>0)fovScale=Math.max(0.08f,fovScale-0.04f);
        else if(amount<0)fovScale=Math.min(0.85f,fovScale+0.04f);
    }
    public static float scale(){return fovScale;}
    public static void scale(float value){fovScale=Math.max(0.08f,Math.min(0.85f,value));}
}
