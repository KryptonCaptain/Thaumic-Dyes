package thaumicdyes.client.proxy;

import cpw.mods.fml.common.FMLCommonHandler;

import java.util.HashMap;

import net.minecraft.client.Minecraft;
import net.minecraft.util.IIcon;
import thaumicdyes.client.handlers.ServerTickHandler;
import thaumicdyes.client.proxy.ServerProxy;
import thaumicdyes.common.ThaumicDyes;
import thaumicdyes.common.lib.packet.TXClientPacketHandler;

public class ClientProxy extends ServerProxy {
	
	private HashMap<String, IIcon> customIcons = new HashMap();

	public void registerRenderInfo() {
      FMLCommonHandler.instance().bus().register(new ServerTickHandler(Minecraft.getMinecraft()));
	}

	public void registerKeyBindings() {
	}

	public void registerRenderers() {
		
		ThaumicDyes.channel.register(new TXClientPacketHandler());
		
	}

	public void initRenderers() {
	}

	public void initSounds() {
	}
}
