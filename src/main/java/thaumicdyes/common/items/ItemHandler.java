package thaumicdyes.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.EnumHelper;
import thaumicdyes.client.tab.TabTD;
import thaumicdyes.common.ThaumicDyes;
import thaumicdyes.common.items.CultistRobesDyed;
import thaumicdyes.common.items.ThaumiumFortressDyed;
import thaumicdyes.common.items.CultistPaladin;
import thaumicdyes.common.items.CultistPraetorDyed;
import thaumicdyes.common.items.CultistKnightDyed;
import thaumicdyes.common.items.legacy.ItemTXAncientMask;
import thaumicdyes.common.items.runic.ItemRunicArmor;
import thaumicdyes.common.items.runic.ItemRunicArmorEnhanced;
import thaumicdyes.common.items.runic.ItemRunicArmorPrimal;
import thaumicdyes.common.items.runic.ItemRunicArmorPrimalBoots;
import thaumicdyes.common.items.runic.ItemRunicBootsTraveller;
import thaumicdyes.common.items.runic.ItemRunicGoggles;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class ItemHandler {
   public static ToolMaterial Robes;
   public static ArmorMaterial RobesArmor;
   public static ArmorMaterial FortressArmor;
   public static ArmorMaterial KnightArmor;
   public static ArmorMaterial IronFortressArmor;
   public static ArmorMaterial RunicArmor;
   public static ArmorMaterial RunicPrimal;

   public static Item itemCultistRobeHelmetDyed;
   public static Item itemCultistRobeChestDyed;
   public static Item itemCultistRobeLegsDyed;
   
   public static Item itemFortressHelmetDyed;
   public static Item itemFortressChestDyed;
   public static Item itemFortressLegsDyed;
   
   public static Item itemCultistLeaderHelmetDyed;
   public static Item itemCultistLeaderChestDyed;
   public static Item itemCultistLeaderLegsDyed;
   
   public static Item itemCultistKnightHelmetDyed;
   public static Item itemCultistKnightChestDyed;
   public static Item itemCultistKnightLegsDyed;
   
   public static Item itemInhabitedPlateHelmet;
   public static Item itemInhabitedPlateChest;
   public static Item itemInhabitedPlateLegs;
   
   public static Item itemIronFortressHelmet;
   public static Item itemIronFortressChest;
   public static Item itemIronFortressLegs;
   
   public static Item itemCultistRangerHelmet;
   public static Item itemCultistRangerChest;
   public static Item itemCultistRangerLegs;
   
   public static Item itemCultistRangerHelmetDyed;
   public static Item itemCultistRangerChestDyed;
   public static Item itemCultistRangerLegsDyed;
   
   public static Item itemVoidRobeHelmetDyed;
   public static Item itemVoidRobeChestDyed;
   public static Item itemVoidRobeLegsDyed;
   
   public static Item itemThaumiumRobeHelmetDyed;
   public static Item itemThaumiumRobeChestDyed;
   public static Item itemThaumiumRobeLegsDyed;
   
   public static Item itemThaumiumBootsTraveller;
   public static Item itemVoidBootsTraveller;
   
   public static Item itemCultistPaladinHelmet;
   
   public static Item itemCultistArcherHelmet;
   public static Item itemCultistArcherChest;
   public static Item itemCultistArcherLegs;
   
   public static Item itemCultistArcherHelmetDyed;
   public static Item itemCultistArcherChestDyed;
   public static Item itemCultistArcherLegsDyed;
   
   public static Item itemResourceFabric;
   
   public static Item itemSunKnightHelmet;
   public static Item itemSunKnightChest;
   
   public static Item itemRunicHelmet;
   public static Item itemRunicChest;
   public static Item itemRunicLegs;
   public static Item itemRunicBoots;
   public static Item itemRunicGoggles;
   public static Item itemRunicBootsTraveller;
   
   public static Item itemHelmetMaskTX;
   
   public static Item itemRunicHelmetEnhanced;
   public static Item itemRunicChestEnhanced;
   public static Item itemRunicLegsEnhanced;
   public static Item itemRunicBootsEnhanced;
   
   public static Item itemRunicHelmetPrimal;
   public static Item itemRunicChestPrimal;
   public static Item itemRunicLegsPrimal;
   public static Item itemRunicBootsPrimal;


   public static void registerItems() {
	   
      GameRegistry.registerItem(itemCultistRobeHelmetDyed, "CultistRobeHelm");
      GameRegistry.registerItem(itemCultistRobeChestDyed, "CultistRobeChest");
      GameRegistry.registerItem(itemCultistRobeLegsDyed, "CultistRobeLegs");
      
      GameRegistry.registerItem(itemFortressHelmetDyed, "FortressHelm");
      GameRegistry.registerItem(itemFortressChestDyed, "FortressChest");
      GameRegistry.registerItem(itemFortressLegsDyed, "FortressLegs");
      
      GameRegistry.registerItem(itemCultistLeaderHelmetDyed, "CultistLeaderHelm");
      GameRegistry.registerItem(itemCultistLeaderChestDyed, "CultistLeaderChest");
      GameRegistry.registerItem(itemCultistLeaderLegsDyed, "CultistLeaderLegs");
      
      GameRegistry.registerItem(itemCultistKnightHelmetDyed, "CultistPlateHelm");
      GameRegistry.registerItem(itemCultistKnightChestDyed, "CultistPlateChest");
      GameRegistry.registerItem(itemCultistKnightLegsDyed, "CultistPlateLegs");
      
      GameRegistry.registerItem(itemInhabitedPlateHelmet, "InhabitedPlateHelm");
      GameRegistry.registerItem(itemInhabitedPlateChest, "InhabitedPlateChest");
      GameRegistry.registerItem(itemInhabitedPlateLegs, "InhabitedPlateLegs");
      
      GameRegistry.registerItem(itemIronFortressHelmet, "IronFortressHelm");
      GameRegistry.registerItem(itemIronFortressChest, "IronFortressChest");
      GameRegistry.registerItem(itemIronFortressLegs, "IronFortressLegs");
      
      GameRegistry.registerItem(itemCultistRangerHelmet, "CultistRangerHelm");
      GameRegistry.registerItem(itemCultistRangerChest, "CultistRangerChest");
      GameRegistry.registerItem(itemCultistRangerLegs, "CultistRangerLegs");
      
      GameRegistry.registerItem(itemCultistRangerHelmetDyed, "CultistRangerHelmDyed");
      GameRegistry.registerItem(itemCultistRangerChestDyed, "CultistRangerChestDyed");
      GameRegistry.registerItem(itemCultistRangerLegsDyed, "CultistRangerLegsDyed");
      
      GameRegistry.registerItem(itemVoidRobeHelmetDyed, "VoidRobeHelm");
      GameRegistry.registerItem(itemVoidRobeChestDyed, "VoidRobeChest");
      GameRegistry.registerItem(itemVoidRobeLegsDyed, "VoidRobeLegs");
      
      GameRegistry.registerItem(itemThaumiumRobeHelmetDyed, "ThaumiumRobeHelm");
      GameRegistry.registerItem(itemThaumiumRobeChestDyed, "ThaumiumRobeChest");
      GameRegistry.registerItem(itemThaumiumRobeLegsDyed, "ThaumiumRobeLegs");
      
      GameRegistry.registerItem(itemThaumiumBootsTraveller, "BootsThaumiumTraveller");
      GameRegistry.registerItem(itemVoidBootsTraveller, "BootsVoidTraveller");
      
      GameRegistry.registerItem(itemCultistArcherHelmet, "CultistArcherHelm");
      GameRegistry.registerItem(itemCultistArcherChest, "CultistArcherChest");
      GameRegistry.registerItem(itemCultistArcherLegs, "CultistArcherLegs");
      
      GameRegistry.registerItem(itemCultistPaladinHelmet, "CultistPaladinHelm");
      
      GameRegistry.registerItem(itemCultistArcherHelmetDyed, "CultistArcherHelmDyed");
      GameRegistry.registerItem(itemCultistArcherChestDyed, "CultistArcherChestDyed");
      GameRegistry.registerItem(itemCultistArcherLegsDyed, "CultistArcherLegsDyed");
      
      GameRegistry.registerItem(itemResourceFabric, "ItemResourceFabric");
      
      GameRegistry.registerItem(itemSunKnightHelmet, "SunKnightHelm");
      GameRegistry.registerItem(itemSunKnightChest, "SunKnightChest");
      
      GameRegistry.registerItem(itemRunicHelmet, "ItemRunicHelmet");
      GameRegistry.registerItem(itemRunicChest, "ItemRunicChest");
      GameRegistry.registerItem(itemRunicLegs, "ItemRunicLegs");
      GameRegistry.registerItem(itemRunicBoots, "ItemRunicBoots");
      GameRegistry.registerItem(itemRunicGoggles, "ItemRunicGoggles");
      GameRegistry.registerItem(itemRunicBootsTraveller, "ItemRunicBootsTraveller");
      
      //GameRegistry.registerItem(itemHelmetMaskTX, "ItemMaskEvil");
      
      GameRegistry.registerItem(itemRunicHelmetEnhanced, "ItemRunicHelmetEnhanced");
      GameRegistry.registerItem(itemRunicChestEnhanced, "ItemRunicChestEnhanced");
      GameRegistry.registerItem(itemRunicLegsEnhanced, "ItemRunicLegsEnhanced");
      GameRegistry.registerItem(itemRunicBootsEnhanced, "ItemRunicBootsEnhanced");
      
      
      GameRegistry.registerItem(itemRunicHelmetPrimal, "ItemRunicHelmetPrimal");
      GameRegistry.registerItem(itemRunicChestPrimal, "ItemRunicChestPrimal");
      GameRegistry.registerItem(itemRunicLegsPrimal, "ItemRunicLegsPrimal");
      GameRegistry.registerItem(itemRunicBootsPrimal, "ItemRunicBootsPrimal");
      
   }

   public static void defineItems() {
	   
	   itemCultistRobeHelmetDyed = (new CultistRobesDyed(RobesArmor, 4, 0)).setUnlocalizedName("itemHelmetCultistRobeDyed").setCreativeTab(ThaumicDyes.tabTD);
	   itemCultistRobeChestDyed = (new CultistRobesDyed(RobesArmor, 4, 1)).setUnlocalizedName("itemChestCultistRobeDyed").setCreativeTab(ThaumicDyes.tabTD);
	   itemCultistRobeLegsDyed = (new CultistRobesDyed(RobesArmor, 4, 2)).setUnlocalizedName("itemLegsCultistRobeDyed").setCreativeTab(ThaumicDyes.tabTD);
       //itemBootsCultist = (new CultistRobes(RobesArmor, CultistBootsID, 3)).setUnlocalizedName("CultistBoots").setCreativeTab(ThaumicDyes.tabTD);
	   
	   itemFortressHelmetDyed = (new ThaumiumFortressDyed(FortressArmor, 4, 0)).setUnlocalizedName("itemHelmetFortressDyed").setCreativeTab(ThaumicDyes.tabTD);
	   itemFortressChestDyed = (new ThaumiumFortressDyed(FortressArmor, 4, 1)).setUnlocalizedName("itemChestFortressDyed").setCreativeTab(ThaumicDyes.tabTD);
	   itemFortressLegsDyed = (new ThaumiumFortressDyed(FortressArmor, 4, 2)).setUnlocalizedName("itemLegsFortressDyed").setCreativeTab(ThaumicDyes.tabTD);
      
	   itemCultistLeaderHelmetDyed = (new CultistPraetorDyed(FortressArmor, 4, 0)).setUnlocalizedName("itemHelmetCultistLeaderDyed").setCreativeTab(ThaumicDyes.tabTD);
	   itemCultistLeaderChestDyed = (new CultistPraetorDyed(FortressArmor, 4, 1)).setUnlocalizedName("itemChestCultistLeaderDyed").setCreativeTab(ThaumicDyes.tabTD);
	   itemCultistLeaderLegsDyed = (new CultistPraetorDyed(FortressArmor, 4, 2)).setUnlocalizedName("itemLegsCultistLeaderDyed").setCreativeTab(ThaumicDyes.tabTD);
	   
	   itemCultistKnightHelmetDyed = (new CultistKnightDyed(KnightArmor, 4, 0)).setUnlocalizedName("itemHelmetCultistKnightDyed").setCreativeTab(ThaumicDyes.tabTD);
	   itemCultistKnightChestDyed = (new CultistKnightDyed(KnightArmor, 4, 1)).setUnlocalizedName("itemChestCultistKnightDyed").setCreativeTab(ThaumicDyes.tabTD);
	   itemCultistKnightLegsDyed = (new CultistKnightDyed(KnightArmor, 4, 2)).setUnlocalizedName("itemLegsCultistKnightDyed").setCreativeTab(ThaumicDyes.tabTD);
	   
	   itemInhabitedPlateHelmet = (new InhabitedKnightArmor(ArmorMaterial.IRON, 4, 0)).setUnlocalizedName("itemHelmetInhabitedPlate").setCreativeTab(ThaumicDyes.tabTD);
	   itemInhabitedPlateChest = (new InhabitedKnightArmor(ArmorMaterial.IRON, 4, 1)).setUnlocalizedName("itemChestInhabitedPlate").setCreativeTab(ThaumicDyes.tabTD);
	   itemInhabitedPlateLegs = (new InhabitedKnightArmor(ArmorMaterial.IRON, 4, 2)).setUnlocalizedName("itemLegsInhabitedPlate").setCreativeTab(ThaumicDyes.tabTD);
	   
	   itemIronFortressHelmet = (new IronFortressArmor(IronFortressArmor, 4, 0)).setUnlocalizedName("itemHelmetIronFortress").setCreativeTab(ThaumicDyes.tabTD);
	   itemIronFortressChest = (new IronFortressArmor(IronFortressArmor, 4, 1)).setUnlocalizedName("itemChestIronFortress").setCreativeTab(ThaumicDyes.tabTD);
	   itemIronFortressLegs = (new IronFortressArmor(IronFortressArmor, 4, 2)).setUnlocalizedName("itemLegsIronFortress").setCreativeTab(ThaumicDyes.tabTD);
      
	   itemCultistRangerHelmet = (new CultistRanger(ArmorMaterial.IRON, 4, 0)).setUnlocalizedName("itemHelmetCultistRanger").setCreativeTab(ThaumicDyes.tabTD);
	   itemCultistRangerChest = (new CultistRanger(ArmorMaterial.IRON, 4, 1)).setUnlocalizedName("itemChestCultistRanger").setCreativeTab(ThaumicDyes.tabTD);
	   itemCultistRangerLegs = (new CultistRanger(ArmorMaterial.IRON, 4, 2)).setUnlocalizedName("itemLegsCultistRanger").setCreativeTab(ThaumicDyes.tabTD);
      
	   itemCultistRangerHelmetDyed = (new CultistRangerDyed(RobesArmor, 4, 0)).setUnlocalizedName("itemHelmetCultistRangerDyed").setCreativeTab(ThaumicDyes.tabTD);
	   itemCultistRangerChestDyed = (new CultistRangerDyed(RobesArmor, 4, 1)).setUnlocalizedName("itemChestCultistRangerDyed").setCreativeTab(ThaumicDyes.tabTD);
	   itemCultistRangerLegsDyed = (new CultistRangerDyed(RobesArmor, 4, 2)).setUnlocalizedName("itemLegsCultistRangerDyed").setCreativeTab(ThaumicDyes.tabTD);
      
	   itemVoidRobeHelmetDyed = (new VoidRobeDyed(ThaumcraftApi.armorMatVoid, 4, 0)).setUnlocalizedName("itemHelmetVoidRobeDyed").setCreativeTab(ThaumicDyes.tabTD);
	   itemVoidRobeChestDyed = (new VoidRobeDyed(ThaumcraftApi.armorMatVoid, 4, 1)).setUnlocalizedName("itemChestVoidRobeDyed").setCreativeTab(ThaumicDyes.tabTD);
	   itemVoidRobeLegsDyed = (new VoidRobeDyed(ThaumcraftApi.armorMatVoid, 4, 2)).setUnlocalizedName("itemLegsVoidRobeDyed").setCreativeTab(ThaumicDyes.tabTD);
       //boot
	   itemVoidBootsTraveller = (new VoidBoots(ThaumcraftApi.armorMatVoid, 4, 3)).setUnlocalizedName("itemBootsVoidTraveller").setCreativeTab(ThaumicDyes.tabTD);
	   
	   itemThaumiumRobeHelmetDyed = (new ThaumiumRobeDyed(ThaumcraftApi.armorMatThaumium, 4, 0)).setUnlocalizedName("itemHelmetThaumiumRobeDyed").setCreativeTab(ThaumicDyes.tabTD);
	   itemThaumiumRobeChestDyed = (new ThaumiumRobeDyed(ThaumcraftApi.armorMatThaumium, 4, 1)).setUnlocalizedName("itemChestThaumiumRobeDyed").setCreativeTab(ThaumicDyes.tabTD);
	   itemThaumiumRobeLegsDyed = (new ThaumiumRobeDyed(ThaumcraftApi.armorMatThaumium, 4, 2)).setUnlocalizedName("itemLegsThaumiumRobeDyed").setCreativeTab(ThaumicDyes.tabTD);
       //boot
	   itemThaumiumBootsTraveller = (new ThaumiumBoots(ThaumcraftApi.armorMatThaumium, 4, 3)).setUnlocalizedName("itemBootsThaumiumTraveller").setCreativeTab(ThaumicDyes.tabTD);
	   
	   itemCultistPaladinHelmet = (new CultistPaladin(FortressArmor, 4, 0)).setUnlocalizedName("itemHelmetCultistPaladin").setCreativeTab(ThaumicDyes.tabTD);
	   
	   itemCultistArcherHelmet = (new CultistArcher(ArmorMaterial.IRON, 4, 0)).setUnlocalizedName("itemHelmetCultistArcher").setCreativeTab(ThaumicDyes.tabTD);
	   itemCultistArcherChest = (new CultistArcher(ArmorMaterial.IRON, 4, 1)).setUnlocalizedName("itemChestCultistArcher").setCreativeTab(ThaumicDyes.tabTD);
	   itemCultistArcherLegs = (new CultistArcher(ArmorMaterial.IRON, 4, 2)).setUnlocalizedName("itemLegsCultistArcher").setCreativeTab(ThaumicDyes.tabTD);
	   
	   itemCultistArcherHelmetDyed = (new CultistArcherDyed(KnightArmor, 4, 0)).setUnlocalizedName("itemHelmetCultistArcherDyed").setCreativeTab(ThaumicDyes.tabTD);
	   itemCultistArcherChestDyed = (new CultistArcherDyed(KnightArmor, 4, 1)).setUnlocalizedName("itemChestCultistArcherDyed").setCreativeTab(ThaumicDyes.tabTD);
	   itemCultistArcherLegsDyed = (new CultistArcherDyed(KnightArmor, 4, 2)).setUnlocalizedName("itemLegsCultistArcherDyed").setCreativeTab(ThaumicDyes.tabTD);
	   	   
	   itemResourceFabric = (new ItemFabricResource()).setUnlocalizedName("itemFabricResource").setCreativeTab(ThaumicDyes.tabTD);
	   
	   itemSunKnightHelmet = (new SunKnight(ArmorMaterial.IRON, 4, 0)).setUnlocalizedName("itemHelmetSunKnight").setCreativeTab(ThaumicDyes.tabTD);
	   itemSunKnightChest = (new SunKnight(ArmorMaterial.IRON, 4, 1)).setUnlocalizedName("itemChestSunKnight").setCreativeTab(ThaumicDyes.tabTD);
	   
	   //legacy runic armor
	   itemRunicHelmet = (new ItemRunicArmor(RunicArmor, 4, 0)).setUnlocalizedName("ItemHelmetRunic").setCreativeTab(ThaumicDyes.tabTD);
	   itemRunicChest = (new ItemRunicArmor(RunicArmor, 4, 1)).setUnlocalizedName("ItemChestRunic").setCreativeTab(ThaumicDyes.tabTD);
	   itemRunicLegs = (new ItemRunicArmor(RunicArmor, 4, 2)).setUnlocalizedName("ItemLegsRunic").setCreativeTab(ThaumicDyes.tabTD);
	   itemRunicBoots = (new ItemRunicArmor(RunicArmor, 4, 3)).setUnlocalizedName("ItemBootsRunic").setCreativeTab(ThaumicDyes.tabTD);;
	   itemRunicGoggles = (new ItemRunicGoggles(RunicArmor, 4, 0)).setUnlocalizedName("ItemGogglesRunic").setCreativeTab(ThaumicDyes.tabTD);
	   itemRunicBootsTraveller = (new ItemRunicBootsTraveller(RunicArmor, 4, 3)).setUnlocalizedName("ItemBootsTravellerRunic").setCreativeTab(ThaumicDyes.tabTD);;
	   
	   //legacy TX
	   itemHelmetMaskTX = (new ItemTXAncientMask(ThaumcraftApi.armorMatSpecial, 2, 0)).setUnlocalizedName("ItemMaskEvil").setCreativeTab(ThaumicDyes.tabTD);
	   
	   itemRunicHelmetEnhanced = (new ItemRunicArmorEnhanced(RunicArmor, 4, 0)).setUnlocalizedName("ItemHelmetRunicEnhanced").setCreativeTab(ThaumicDyes.tabTD);
	   itemRunicChestEnhanced = (new ItemRunicArmorEnhanced(RunicArmor, 4, 1)).setUnlocalizedName("ItemChestRunicEnhanced").setCreativeTab(ThaumicDyes.tabTD);
	   itemRunicLegsEnhanced = (new ItemRunicArmorEnhanced(RunicArmor, 4, 2)).setUnlocalizedName("ItemLegsRunicEnhanced").setCreativeTab(ThaumicDyes.tabTD);
	   itemRunicBootsEnhanced = (new ItemRunicArmorEnhanced(RunicArmor, 4, 3)).setUnlocalizedName("ItemBootsRunicEnhanced").setCreativeTab(ThaumicDyes.tabTD);;
	   
	   
	   itemRunicHelmetPrimal = (new ItemRunicArmorPrimal(RunicArmor, 4, 0)).setUnlocalizedName("ItemHelmetRunicPrimal").setCreativeTab(ThaumicDyes.tabTD);
	   itemRunicChestPrimal = (new ItemRunicArmorPrimal(RunicArmor, 4, 1)).setUnlocalizedName("ItemChestRunicPrimal").setCreativeTab(ThaumicDyes.tabTD);
	   itemRunicLegsPrimal = (new ItemRunicArmorPrimal(RunicArmor, 4, 2)).setUnlocalizedName("ItemLegsRunicPrimal").setCreativeTab(ThaumicDyes.tabTD);
	   itemRunicBootsPrimal = (new ItemRunicArmorPrimalBoots(RunicArmor, 4, 3)).setUnlocalizedName("ItemBootsRunicPrimal").setCreativeTab(ThaumicDyes.tabTD);
	   
	   
   }
   
   public static void addAspects() { //TODO aspects
	   
	   //crimson
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistPaladinHelmet), 
			   new AspectList().add(Aspect.METAL, 6).add(Aspect.GREED, 3).add(Aspect.ELDRITCH, 2));
	   
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistRangerHelmet), 
			   new AspectList().add(Aspect.METAL, 3).add(Aspect.CLOTH, 2).add(Aspect.ELDRITCH, 1).add(Aspect.TRAVEL, 1));
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistRangerChest), 
			   new AspectList().add(Aspect.METAL, 3).add(Aspect.CLOTH, 2).add(Aspect.ELDRITCH, 1).add(Aspect.TRAVEL, 1));
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistRangerLegs), 
			   new AspectList().add(Aspect.METAL, 3).add(Aspect.CLOTH, 2).add(Aspect.ELDRITCH, 1).add(Aspect.TRAVEL, 1));
	   
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistArcherHelmet), 
			   new AspectList().add(Aspect.METAL, 5).add(Aspect.ELDRITCH, 1).add(Aspect.WEAPON, 1));
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistArcherChest), 
			   new AspectList().add(Aspect.METAL, 5).add(Aspect.ELDRITCH, 1).add(Aspect.WEAPON, 1));
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistArcherLegs), 
			   new AspectList().add(Aspect.METAL, 5).add(Aspect.ELDRITCH, 1).add(Aspect.WEAPON, 1));
	   
	   //dyed
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistRobeHelmetDyed), 
			   new AspectList().add(Aspect.METAL, 4).add(Aspect.CLOTH, 3).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.MAGIC, 2));
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistRobeChestDyed), 
			   new AspectList().add(Aspect.METAL, 4).add(Aspect.CLOTH, 3).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.MAGIC, 2));
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistRobeLegsDyed), 
			   new AspectList().add(Aspect.METAL, 4).add(Aspect.CLOTH, 3).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.MAGIC, 2));
	   
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistKnightHelmetDyed), 
			   new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1));
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistKnightChestDyed), 
			   new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1));
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistKnightLegsDyed), 
			   new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1));
	   
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistLeaderHelmetDyed), 
			   new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 2).add(Aspect.SENSES, 1));
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistLeaderChestDyed), 
			   new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 2).add(Aspect.SENSES, 1));
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistLeaderLegsDyed), 
			   new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 2).add(Aspect.SENSES, 1));
	   
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistRangerHelmetDyed), 
			   new AspectList().add(Aspect.METAL, 4).add(Aspect.CLOTH, 3).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.TRAVEL, 1));
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistRangerChestDyed), 
			   new AspectList().add(Aspect.METAL, 4).add(Aspect.CLOTH, 3).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.TRAVEL, 1));
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistRangerLegsDyed), 
			   new AspectList().add(Aspect.METAL, 4).add(Aspect.CLOTH, 3).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.TRAVEL, 1));
	   
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistArcherHelmetDyed), 
			   new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.WEAPON, 1));
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistArcherChestDyed), 
			   new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.WEAPON, 1));
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemCultistArcherLegsDyed), 
			   new AspectList().add(Aspect.METAL, 6).add(Aspect.CLOTH, 1).add(Aspect.ELDRITCH, 1).add(Aspect.SENSES, 1).add(Aspect.WEAPON, 1));
	   
	   //eldritch
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemInhabitedPlateHelmet), 
			   new AspectList().add(Aspect.METAL, 5).add(Aspect.UNDEAD, 1).add(Aspect.ELDRITCH, 4).add(Aspect.ENTROPY, 2));
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemInhabitedPlateChest), 
			   new AspectList().add(Aspect.METAL, 5).add(Aspect.UNDEAD, 1).add(Aspect.ELDRITCH, 4).add(Aspect.ENTROPY, 2));
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemInhabitedPlateLegs), 
			   new AspectList().add(Aspect.METAL, 5).add(Aspect.UNDEAD, 1).add(Aspect.ELDRITCH, 4).add(Aspect.ENTROPY, 2));
	   //iron tier
	   
	   //thaumium tier
	   
	   // void tier
	   
	   //runic
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemRunicHelmet), 
			   new AspectList().add(Aspect.ARMOR, 4).add(Aspect.ENERGY, 12).add(Aspect.MAGIC, 8).add(Aspect.GREED, 5).add(Aspect.VOID, 4) );
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemRunicChest), 
			   new AspectList().add(Aspect.ARMOR, 12).add(Aspect.ENERGY, 36).add(Aspect.MAGIC, 24).add(Aspect.GREED, 5).add(Aspect.VOID, 4) );
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemRunicLegs), 
			   new AspectList().add(Aspect.ARMOR, 8).add(Aspect.ENERGY, 24).add(Aspect.MAGIC, 16).add(Aspect.GREED, 5).add(Aspect.VOID, 4) );
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemRunicBoots), 
			   new AspectList().add(Aspect.ARMOR, 4).add(Aspect.ENERGY, 12).add(Aspect.MAGIC, 8).add(Aspect.GREED, 5).add(Aspect.VOID, 4) );
	   
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemRunicHelmetEnhanced), 
			   new AspectList().add(Aspect.ARMOR, 4).add(Aspect.ENERGY, 12).add(Aspect.MAGIC, 8).add(Aspect.GREED, 10).add(Aspect.VOID, 4).add(Aspect.ORDER, 6) );
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemRunicChestEnhanced), 
			   new AspectList().add(Aspect.ARMOR, 12).add(Aspect.ENERGY, 36).add(Aspect.MAGIC, 24).add(Aspect.GREED, 10).add(Aspect.VOID, 4).add(Aspect.ORDER, 6) );
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemRunicLegsEnhanced), 
			   new AspectList().add(Aspect.ARMOR, 8).add(Aspect.ENERGY, 24).add(Aspect.MAGIC, 16).add(Aspect.GREED, 10).add(Aspect.VOID, 4).add(Aspect.ORDER, 6) );
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemRunicBootsEnhanced), 
			   new AspectList().add(Aspect.ARMOR, 4).add(Aspect.ENERGY, 12).add(Aspect.MAGIC, 8).add(Aspect.GREED, 10).add(Aspect.VOID, 4).add(Aspect.ORDER, 6) );
	   
	   
	   
	   //other
	   ThaumcraftApi.registerObjectTag(new ItemStack(itemResourceFabric), 
			   new AspectList().add(Aspect.CLOTH, 4).add(Aspect.ELDRITCH, 1).add(Aspect.MAGIC, 2));
   
	   /*
	   ThaumcraftApi.registerObjectTag(new ItemStack(), new AspectList().add(Aspect., 1).add(Aspect., 1));
	   
	    
	    	
	    ThaumcraftApi.registerObjectTag(new ItemStack(ConfigItems.itemBootsCultist, 1, 32767), 
	    	new AspectList().add(Aspect.METAL, 4).add(Aspect.ELDRITCH, 1));
	   
	   

	   itemHelmetFortressDyed;
	   itemChestFortressDyed;
	   itemLegsFortressDyed;

	   itemHelmetIronFortress;
	   itemChestIronFortress;
	   itemLegsIronFortress;

	   itemHelmetVoidRobeDyed;
	   itemChestVoidRobeDyed;
	   itemLegsVoidRobeDyed;
	   itemHelmetThaumiumRobeDyed;
	   itemChestThaumiumRobeDyed;
	   itemLegsThaumiumRobeDyed;
	   itemBootsThaumiumTraveller;
	   itemBootsVoidTraveller;

	   itemHelmetSunKnight;
	   itemChestSunKnight;
   		*/
   
   }

   public static void registerToolMaterial() {
      RobesArmor = EnumHelper.addArmorMaterial("TD.ROBE", 15, new int[]{2, 6, 5, 1}, 15);
      KnightArmor = EnumHelper.addArmorMaterial("TD.KNIGHT", 20, new int[]{2, 6, 5, 1}, 12); 
      FortressArmor = EnumHelper.addArmorMaterial("TD.FORT", 45, new int[]{3, 7, 6, 1}, 30);
      IronFortressArmor = EnumHelper.addArmorMaterial("TD.IRONFORT", 25, new int[]{2, 6, 5, 2}, 12);
      RunicArmor = EnumHelper.addArmorMaterial("TD.RUNIC", 25, new int[] { 1, 3, 2, 1 }, 25);
      RunicPrimal = EnumHelper.addArmorMaterial("TD.PRIMAL", 25, new int[] { 2, 6, 5, 2 }, 10);
      
   }
}
