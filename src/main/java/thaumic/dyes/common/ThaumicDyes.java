package thaumic.dyes.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import thaumic.dyes.client.proxy.ServerProxy;
import thaumic.dyes.client.tab.TabTD;
import thaumic.dyes.common.DyeRecipe;
import thaumic.dyes.common.DyeResearch;
import thaumic.dyes.common.items.ItemHandler;

@Mod(
   modid = "TD",
   name = "Thaumic Dyes",
   version = "1.0"
)
public class ThaumicDyes {
   @SidedProxy(
      clientSide = "thaumic.dyes.client.proxy.ClientProxy",
      serverSide = "thaumic.dyes.client.proxy.ServerProxy"
   )
   public static ServerProxy proxy;
   @Instance("TD")
   public static ThaumicDyes modInstance;

   @EventHandler
   public static void PreLoad(FMLPreInitializationEvent PreEvent) {
      ItemHandler.registerToolMaterial();
      ItemHandler.defineItems();
      ItemHandler.registerItems();

   }

   @EventHandler
   public void init(FMLInitializationEvent event) {
      DyeRecipe.initRecipes();
   }

   @EventHandler
   public static void PostLoad(FMLPostInitializationEvent PostEvent) {
      DyeResearch.addResearch();
   }
}
