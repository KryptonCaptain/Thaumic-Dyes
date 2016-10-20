package thaumic.dyes.client.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import java.util.HashMap;
import net.minecraft.client.Minecraft;
import thaumic.dyes.client.handlers.ServerTickHandler;
import thaumic.dyes.client.proxy.ServerProxy;

public class ClientProxy extends ServerProxy {
   private HashMap customIcons = new HashMap();

   public void registerRenderInfo() {
      FMLCommonHandler.instance().bus().register(new ServerTickHandler(Minecraft.getMinecraft()));
   }

   public void registerKeyBindings() {
   }

   public void registerRenderers() {
   }

   public void initRenderers() {
   }

   public void initSounds() {
   }
}
