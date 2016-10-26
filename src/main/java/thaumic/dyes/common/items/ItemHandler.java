package thaumic.dyes.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import thaumic.dyes.client.tab.TabTD;
import thaumic.dyes.common.items.CultistRobes;
import thaumic.dyes.common.items.FortressArmor;
import thaumic.dyes.common.items.PraetorArmor;

public class ItemHandler {
   public static ToolMaterial Robes;
   public static ArmorMaterial RobesArmor;
   public static ArmorMaterial PraetorArmor;
   public static ArmorMaterial FortressArmor;
   
   public static Item itemHelmetCultistRobe;
   public static Item itemChestCultistRobe;
   public static Item itemLegsCultistRobe;
   //public static Item itemBootsCultist;
   public static int CultistRobeHelmID;
   public static int CultistRobeChestID;
   public static int CultistRobeLegsID;
   
   public static Item itemHelmetFortress;
   public static Item itemChestFortress;
   public static Item itemLegsFortress;
   public static int FortressHelmID;
   public static int FortressChestID;
   public static int FortressLegsID;
   
   public static Item itemHelmetCultistLeaderPlate;
   public static Item itemChestCultistLeaderPlate;
   public static Item itemLegsCultistLeaderPlate;
   public static int CultistLeaderHelmID;
   public static int CultistLeaderChestID;
   public static int CultistLeaderLegsID;
   
   /*
   public static Item itemHelmetCultistPlate;
   public static Item itemChestCultistPlate;
   public static Item itemLegsCultistPlate;
   public static int CultistPlateHelmID;
   public static int CultistPlateChestID;
   public static int CultistPlateLegsID;
   */

   public static void registerItems() {
      GameRegistry.registerItem(itemHelmetCultistRobe, "CultistRobeHelm");
      GameRegistry.registerItem(itemChestCultistRobe, "CultistRobeChest");
      GameRegistry.registerItem(itemLegsCultistRobe, "CultistRobeLegs");
      GameRegistry.registerItem(itemHelmetFortress, "FortressHelm");
      GameRegistry.registerItem(itemChestFortress, "FortressChest");
      GameRegistry.registerItem(itemLegsFortress, "FortressLegs");
      GameRegistry.registerItem(itemHelmetCultistLeaderPlate, "CultistLeaderHelm");
      GameRegistry.registerItem(itemChestCultistLeaderPlate, "CultistLeaderChest");
      GameRegistry.registerItem(itemLegsCultistLeaderPlate, "CultistLeaderLegs");
   }

   public static void defineItems() {
	   itemHelmetCultistRobe = (new CultistRobes(RobesArmor, CultistRobeHelmID, 0)).setUnlocalizedName("CultistRobeHelm").setCreativeTab(TabTD.TabTD);
	   itemChestCultistRobe = (new CultistRobes(RobesArmor, CultistRobeChestID, 1)).setUnlocalizedName("CultistRobeChest").setCreativeTab(TabTD.TabTD);
	   itemLegsCultistRobe = (new CultistRobes(RobesArmor, CultistRobeLegsID, 2)).setUnlocalizedName("CultistRobeLegs").setCreativeTab(TabTD.TabTD);
      
	   itemHelmetFortress = (new FortressArmor(FortressArmor, FortressHelmID, 0)).setUnlocalizedName("FortressHelm").setCreativeTab(TabTD.TabTD);
	   itemChestFortress = (new FortressArmor(FortressArmor, FortressChestID, 1)).setUnlocalizedName("FortressChest").setCreativeTab(TabTD.TabTD);
	   itemLegsFortress = (new FortressArmor(FortressArmor, FortressLegsID, 2)).setUnlocalizedName("FortressLegs").setCreativeTab(TabTD.TabTD);
      
	   itemHelmetCultistLeaderPlate = (new PraetorArmor(PraetorArmor, CultistLeaderHelmID, 0)).setUnlocalizedName("CultistLeaderHelm").setCreativeTab(TabTD.TabTD);
	   itemChestCultistLeaderPlate = (new PraetorArmor(PraetorArmor, CultistLeaderChestID, 1)).setUnlocalizedName("CultistLeaderChest").setCreativeTab(TabTD.TabTD);
	   itemLegsCultistLeaderPlate = (new PraetorArmor(PraetorArmor, CultistLeaderLegsID, 2)).setUnlocalizedName("CultistLeaderLegs").setCreativeTab(TabTD.TabTD);
   }

   public static void registerToolMaterial() {
      RobesArmor = EnumHelper.addArmorMaterial("ROBESARMOR", 20, new int[]{2, 6, 5, 2}, 10);
      PraetorArmor = EnumHelper.addArmorMaterial("ROBESARMOR", 40, new int[]{3, 8, 7, 2}, 18);
      FortressArmor = EnumHelper.addArmorMaterial("ROBESARMOR", 50, new int[]{4, 8, 7, 4}, 18);
      //KnightArmor = EnumHelper.addArmorMaterial("ROBESARMOR", 20, new int[]{3, 7, 6, 3}, 10); 
      
   }
}
