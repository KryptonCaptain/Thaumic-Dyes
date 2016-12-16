package thaumicdyes.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import thaumicdyes.client.proxy.ServerProxy;
import thaumicdyes.client.tab.TabTD;
import thaumicdyes.common.recipe.DyesRecipes;
import thaumicdyes.common.DyeResearch;
import thaumicdyes.common.items.ItemHandler;

@Mod(
   modid = "thaumicdyes",
   name = "Thaumic Dyes",
   version = "1.5.1",
   dependencies = "required-after:Thaumcraft@[4.2.3.5,)"
)
public class ThaumicDyes {
   @SidedProxy(
      clientSide = "thaumicdyes.client.proxy.ClientProxy",
      serverSide = "thaumicdyes.client.proxy.ServerProxy"
   )
   public static ServerProxy proxy;

   @EventHandler
   public static void PreLoad(FMLPreInitializationEvent PreEvent) {
      ItemHandler.registerToolMaterial();
      ItemHandler.defineItems();
      ItemHandler.registerItems();

   }

   @EventHandler
   public void init(FMLInitializationEvent event) {
      DyesRecipes.initRecipes();
   }

   @EventHandler
   public static void PostLoad(FMLPostInitializationEvent PostEvent) {
      DyeResearch.addResearch();
   }
}
