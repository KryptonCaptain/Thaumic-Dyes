package thaumicdyes.common;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumicdyes.client.proxy.ServerProxy;
import thaumicdyes.client.tab.TabTD;
import thaumicdyes.common.recipe.DyesRecipes;
import thaumicdyes.common.DyeResearch;
import thaumicdyes.common.items.ItemHandler;

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

   @EventHandler
   public static void PreInit(FMLPreInitializationEvent PreEvent) {
      ItemHandler.registerToolMaterial();
      ItemHandler.defineItems();
      ItemHandler.registerItems();

   }

   @EventHandler
   public void init(FMLInitializationEvent event) {
      DyesRecipes.initRecipes();
   }

   @EventHandler
   public static void PostInit(FMLPostInitializationEvent PostEvent) {
      DyeResearch.addResearch();
      //ItemHandler.addAspects;
      
      ThaumcraftApi.registerEntityTag("Thaumcraft.CultistLeader", new AspectList().add(Aspect.ELDRITCH, 2).add(Aspect.MAN, 2).add(Aspect.ENTROPY, 1).add(Aspect.MAGIC, 2), new ThaumcraftApi.EntityTagsNBT[0]);
   }
   
   public static CreativeTabs tabTD = new TabTD(CreativeTabs.getNextID(), "thaumicdyes");
   
}
