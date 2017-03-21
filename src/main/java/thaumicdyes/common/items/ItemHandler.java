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
import thaumcraft.api.ThaumcraftApi;

public class ItemHandler {
   public static ToolMaterial Robes;
   public static ArmorMaterial RobesArmor;
   public static ArmorMaterial PraetorArmor;
   public static ArmorMaterial FortressArmor;
   public static ArmorMaterial KnightArmor;
   public static ArmorMaterial IronFortressArmor;
   
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
   
   public static Item itemHelmetIronFortress;
   public static Item itemChestIronFortress;
   public static Item itemLegsIronFortress;
   
   public static Item itemHelmetCultistRanger;
   public static Item itemChestCultistRanger;
   public static Item itemLegsCultistRanger;
   
   public static Item itemHelmetVoidRobe;
   public static Item itemChestVoidRobe;
   public static Item itemLegsVoidRobe;
   
   public static Item itemHelmetThaumiumRobe;
   public static Item itemChestThaumiumRobe;
   public static Item itemLegsThaumiumRobe;
   
   public static Item itemBootsThaumiumTraveller;
   public static Item itemBootsVoidTraveller;


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
      
      GameRegistry.registerItem(itemHelmetIronFortress, "IronFortressHelm");
      GameRegistry.registerItem(itemChestIronFortress, "IronFortressChest");
      GameRegistry.registerItem(itemLegsIronFortress, "IronFortressLegs");
      
      GameRegistry.registerItem(itemHelmetCultistRanger, "CultistRangerHelm");
      GameRegistry.registerItem(itemChestCultistRanger, "CultistRangerChest");
      GameRegistry.registerItem(itemLegsCultistRanger, "CultistRangerLegs");
      
      GameRegistry.registerItem(itemHelmetVoidRobe, "VoidRobeHelm");
      GameRegistry.registerItem(itemChestVoidRobe, "VoidRobeChest");
      GameRegistry.registerItem(itemLegsVoidRobe, "VoidRobeLegs");
      
      GameRegistry.registerItem(itemHelmetThaumiumRobe, "ThaumiumRobeHelm");
      GameRegistry.registerItem(itemChestThaumiumRobe, "ThaumiumRobeChest");
      GameRegistry.registerItem(itemLegsThaumiumRobe, "ThaumiumRobeLegs");
      
      GameRegistry.registerItem(itemBootsThaumiumTraveller, "BootsThaumiumTraveller");
      GameRegistry.registerItem(itemBootsVoidTraveller, "BootsVoidTraveller");
      
      
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
	   
	   itemHelmetInhabitedPlate = (new InhabitedKnightArmor(ArmorMaterial.IRON, 4, 0)).setUnlocalizedName("InhabitedPlateHelm").setCreativeTab(TabTD.TabTD);
	   itemChestInhabitedPlate = (new InhabitedKnightArmor(ArmorMaterial.IRON, 4, 1)).setUnlocalizedName("InhabitedPlateChest").setCreativeTab(TabTD.TabTD);
	   itemLegsInhabitedPlate = (new InhabitedKnightArmor(ArmorMaterial.IRON, 4, 2)).setUnlocalizedName("InhabitedPlateLegs").setCreativeTab(TabTD.TabTD);
	   
	   itemHelmetIronFortress = (new IronFortressArmor(IronFortressArmor, 4, 0)).setUnlocalizedName("IronFortressHelm").setCreativeTab(TabTD.TabTD);
	   itemChestIronFortress = (new IronFortressArmor(IronFortressArmor, 4, 1)).setUnlocalizedName("IronFortressChest").setCreativeTab(TabTD.TabTD);
	   itemLegsIronFortress = (new IronFortressArmor(IronFortressArmor, 4, 2)).setUnlocalizedName("IronFortressLegs").setCreativeTab(TabTD.TabTD);
      
	   itemHelmetCultistRanger = (new RangerArmor(RobesArmor, 4, 0)).setUnlocalizedName("CultistRangerHelm").setCreativeTab(TabTD.TabTD);
	   itemChestCultistRanger = (new RangerArmor(RobesArmor, 4, 1)).setUnlocalizedName("CultistRangerChest").setCreativeTab(TabTD.TabTD);
	   itemLegsCultistRanger = (new RangerArmor(RobesArmor, 4, 2)).setUnlocalizedName("CultistRangerLegs").setCreativeTab(TabTD.TabTD);
      
	   itemHelmetVoidRobe = (new VoidRobeArmor(ThaumcraftApi.armorMatVoid, 4, 0)).setUnlocalizedName("VoidRobeHelm").setCreativeTab(TabTD.TabTD);
	   itemChestVoidRobe = (new VoidRobeArmor(ThaumcraftApi.armorMatVoid, 4, 1)).setUnlocalizedName("VoidRobeChest").setCreativeTab(TabTD.TabTD);
	   itemLegsVoidRobe = (new VoidRobeArmor(ThaumcraftApi.armorMatVoid, 4, 2)).setUnlocalizedName("VoidRobeLegs").setCreativeTab(TabTD.TabTD);
       //boot
	   itemBootsVoidTraveller = (new VoidBoots(ThaumcraftApi.armorMatVoid, 4, 3)).setUnlocalizedName("VoidTrvlBoots").setCreativeTab(TabTD.TabTD);
	   
	   itemHelmetThaumiumRobe = (new ThaumiumRobeArmor(ThaumcraftApi.armorMatThaumium, 4, 0)).setUnlocalizedName("ThaumiumRobeHelm").setCreativeTab(TabTD.TabTD);
	   itemChestThaumiumRobe = (new ThaumiumRobeArmor(ThaumcraftApi.armorMatThaumium, 4, 1)).setUnlocalizedName("ThaumiumRobeChest").setCreativeTab(TabTD.TabTD);
	   itemLegsThaumiumRobe = (new ThaumiumRobeArmor(ThaumcraftApi.armorMatThaumium, 4, 2)).setUnlocalizedName("ThaumiumRobeLegs").setCreativeTab(TabTD.TabTD);
       //boot
	   itemBootsThaumiumTraveller = (new ThaumiumBoots(ThaumcraftApi.armorMatThaumium, 4, 3)).setUnlocalizedName("ThaumiumTrvlBoots").setCreativeTab(TabTD.TabTD);
	   
   }

   public static void registerToolMaterial() {
      RobesArmor = EnumHelper.addArmorMaterial("TD_ROBE", 15, new int[]{2, 6, 5, 1}, 15);
      KnightArmor = EnumHelper.addArmorMaterial("TD_KNIGHT", 20, new int[]{2, 6, 5, 1}, 12); 
      PraetorArmor = EnumHelper.addArmorMaterial("TD_PRAE", 45, new int[]{3, 7, 6, 1}, 30);
      FortressArmor = EnumHelper.addArmorMaterial("TD_FORT", 45, new int[]{3, 7, 6, 1}, 30);
      IronFortressArmor = EnumHelper.addArmorMaterial("TD_IRONFORT", 25, new int[]{2, 6, 5, 2}, 12);
      
   }
}
