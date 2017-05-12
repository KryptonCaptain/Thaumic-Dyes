package thaumicdyes.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumicdyes.client.proxy.ServerProxy;
import thaumicdyes.client.tab.TabTD;
import thaumicdyes.common.recipe.DyesRecipes;
import thaumicdyes.common.ConfigResearch;
import thaumicdyes.common.items.ItemHandler;
import thaumicdyes.common.lib.event.EventHandlerEntity;
import thaumicdyes.common.lib.event.EventHandlerRunicLegacy;
import thaumicdyes.common.lib.event.EventHandlerRunicTX;
import thaumicdyes.common.lib.event.EventHandlerTXMask;


@Mod(
   modid = "thaumicdyes",
   name = "Thaumic Dyes",
   version = "${version}",
   dependencies = "required-after:Thaumcraft@[4.2.3.5,)"
)
public class ThaumicDyes {
   @SidedProxy(
      clientSide = "thaumicdyes.client.proxy.ClientProxy",
      serverSide = "thaumicdyes.client.proxy.ServerProxy"
   )
   public static ServerProxy proxy;
   
   public static FMLEventChannel channel;
   
   public EventHandlerRunicLegacy legacyEventHandler;
   public EventHandlerRunicTX legacyEventHandlerTX;
   public EventHandlerTXMask maskEventHandler;
   public EventHandlerEntity entityEventHandler;
   
   
   @EventHandler
   public void PreInit(FMLPreInitializationEvent PreEvent) {
	   ItemHandler.registerToolMaterial();
	   ItemHandler.defineItems();
	   ItemHandler.registerItems();
      
	   /* Too hard to make behave right now*/
	   this.legacyEventHandler = new EventHandlerRunicLegacy();
	   MinecraftForge.EVENT_BUS.register(this.legacyEventHandler);
	   
	   this.legacyEventHandlerTX = new EventHandlerRunicTX();
	   MinecraftForge.EVENT_BUS.register(this.legacyEventHandlerTX);
	   
	   this.entityEventHandler = new EventHandlerEntity();
	   MinecraftForge.EVENT_BUS.register(this.entityEventHandler);
      
      
   }

   @EventHandler
   public void init(FMLInitializationEvent event) {
	   DyesRecipes.initRecipes();
	   
	   channel = NetworkRegistry.INSTANCE.newEventDrivenChannel("tDyes");
      
	   this.maskEventHandler = new EventHandlerTXMask();
	   MinecraftForge.EVENT_BUS.register(this.maskEventHandler);
      
      
   }

   @EventHandler
   public static void PostInit(FMLPostInitializationEvent PostEvent) {
	   ConfigRecipes.init(); 
	   ConfigResearch.addResearch();
	   ItemHandler.addAspects();
      
	   ThaumcraftApi.registerEntityTag("Thaumcraft.CultistLeader", new AspectList().add(Aspect.ELDRITCH, 2).add(Aspect.MAN, 2).add(Aspect.ENTROPY, 1).add(Aspect.MAGIC, 2), new ThaumcraftApi.EntityTagsNBT[0]);
   }
   
   public static CreativeTabs tabTD = new TabTD(CreativeTabs.getNextID(), "thaumicdyes");
   
}
