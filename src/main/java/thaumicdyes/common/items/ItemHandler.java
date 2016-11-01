package thaumicdyes.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import thaumicdyes.client.tab.TabTD;
import thaumicdyes.common.items.CultistRobes;
import thaumicdyes.common.items.FortressArmor;
import thaumicdyes.common.items.PraetorArmor;
import thaumicdyes.common.items.KnightArmor;

public class ItemHandler {
   public static ToolMaterial Robes;
   public static ArmorMaterial RobesArmor;
   public static ArmorMaterial PraetorArmor;
   public static ArmorMaterial FortressArmor;
   public static ArmorMaterial KnightArmor;
   
   public static Item itemHelmetCultistRobe;
   public static Item itemChestCultistRobe;
   public static Item itemLegsCultistRobe;
   public static Item itemBootsCultist;
   
   public static Item itemHelmetFortress;
   public static Item itemChestFortress;
   public static Item itemLegsFortress;
   
   public static Item itemHelmetCultistLeaderPlate;
   public static Item itemChestCultistLeaderPlate;
   public static Item itemLegsCultistLeaderPlate;
   
   public static Item itemHelmetCultistPlate;
   public static Item itemChestCultistPlate;
   public static Item itemLegsCultistPlate;
   
   public static Item itemHelmetInhabitedPlate;
   public static Item itemChestInhabitedPlate;
   public static Item itemLegsInhabitedPlate;


   public static void registerItems() {
      GameRegistry.registerItem(itemHelmetCultistRobe, "CultistRobeHelm");
      GameRegistry.registerItem(itemChestCultistRobe, "CultistRobeChest");
      GameRegistry.registerItem(itemLegsCultistRobe, "CultistRobeLegs");
      //GameRegistry.registerItem(itemBootsCultist, "CultistBoots");
      
      GameRegistry.registerItem(itemHelmetFortress, "FortressHelm");
      GameRegistry.registerItem(itemChestFortress, "FortressChest");
      GameRegistry.registerItem(itemLegsFortress, "FortressLegs");
      
      GameRegistry.registerItem(itemHelmetCultistLeaderPlate, "CultistLeaderHelm");
      GameRegistry.registerItem(itemChestCultistLeaderPlate, "CultistLeaderChest");
      GameRegistry.registerItem(itemLegsCultistLeaderPlate, "CultistLeaderLegs");
      
      GameRegistry.registerItem(itemHelmetCultistPlate, "CultistPlateHelm");
      GameRegistry.registerItem(itemChestCultistPlate, "CultistPlateChest");
      GameRegistry.registerItem(itemLegsCultistPlate, "CultistPlateLegs");
      
      GameRegistry.registerItem(itemHelmetInhabitedPlate, "InhabitedPlateHelm");
      GameRegistry.registerItem(itemChestInhabitedPlate, "InhabitedPlateChest");
      GameRegistry.registerItem(itemLegsInhabitedPlate, "InhabitedPlateLegs");
      
   }

   public static void defineItems() {
	   itemHelmetCultistRobe = (new CultistRobes(RobesArmor, 4, 0)).setUnlocalizedName("CultistRobeHelm").setCreativeTab(TabTD.TabTD);
	   itemChestCultistRobe = (new CultistRobes(RobesArmor, 4, 1)).setUnlocalizedName("CultistRobeChest").setCreativeTab(TabTD.TabTD);
	   itemLegsCultistRobe = (new CultistRobes(RobesArmor, 4, 2)).setUnlocalizedName("CultistRobeLegs").setCreativeTab(TabTD.TabTD);
       //itemBootsCultist = (new CultistRobes(RobesArmor, CultistBootsID, 3)).setUnlocalizedName("CultistBoots").setCreativeTab(TabTD.TabTD);
	   
	   itemHelmetFortress = (new FortressArmor(FortressArmor, 4, 0)).setUnlocalizedName("FortressHelm").setCreativeTab(TabTD.TabTD);
	   itemChestFortress = (new FortressArmor(FortressArmor, 4, 1)).setUnlocalizedName("FortressChest").setCreativeTab(TabTD.TabTD);
	   itemLegsFortress = (new FortressArmor(FortressArmor, 4, 2)).setUnlocalizedName("FortressLegs").setCreativeTab(TabTD.TabTD);
      
	   itemHelmetCultistLeaderPlate = (new PraetorArmor(PraetorArmor, 4, 0)).setUnlocalizedName("CultistLeaderHelm").setCreativeTab(TabTD.TabTD);
	   itemChestCultistLeaderPlate = (new PraetorArmor(PraetorArmor, 4, 1)).setUnlocalizedName("CultistLeaderChest").setCreativeTab(TabTD.TabTD);
	   itemLegsCultistLeaderPlate = (new PraetorArmor(PraetorArmor, 4, 2)).setUnlocalizedName("CultistLeaderLegs").setCreativeTab(TabTD.TabTD);
	   
	   itemHelmetCultistPlate = (new KnightArmor(KnightArmor, 4, 0)).setUnlocalizedName("CultistPlateHelm").setCreativeTab(TabTD.TabTD);
	   itemChestCultistPlate = (new KnightArmor(KnightArmor, 4, 1)).setUnlocalizedName("CultistPlateChest").setCreativeTab(TabTD.TabTD);
	   itemLegsCultistPlate = (new KnightArmor(KnightArmor, 4, 2)).setUnlocalizedName("CultistPlateLegs").setCreativeTab(TabTD.TabTD);
	   
	   itemHelmetInhabitedPlate = (new InhabitedKnightArmor(KnightArmor, 4, 0)).setUnlocalizedName("InhabitedPlateHelm").setCreativeTab(TabTD.TabTD);
	   itemChestInhabitedPlate = (new InhabitedKnightArmor(KnightArmor, 4, 1)).setUnlocalizedName("InhabitedPlateChest").setCreativeTab(TabTD.TabTD);
	   itemLegsInhabitedPlate = (new InhabitedKnightArmor(KnightArmor, 4, 2)).setUnlocalizedName("InhabitedPlateLegs").setCreativeTab(TabTD.TabTD);
	   
   }

   public static void registerToolMaterial() {
      RobesArmor = EnumHelper.addArmorMaterial("ROBESARMOR", 20, new int[]{2, 6, 5, 2}, 10);
      PraetorArmor = EnumHelper.addArmorMaterial("ROBESARMOR", 40, new int[]{3, 8, 7, 2}, 18);
      FortressArmor = EnumHelper.addArmorMaterial("ROBESARMOR", 50, new int[]{4, 8, 7, 4}, 18);
      KnightArmor = EnumHelper.addArmorMaterial("ROBESARMOR", 20, new int[]{3, 7, 6, 3}, 10); 
      
   }
}
