package thaumicdyes.common;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagByte;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.common.config.ConfigItems;
import thaumicdyes.common.items.ItemHandler;

public class ConfigRecipes {

	public static void init() {
		//reg things here
		/*
		initCrimsonRecipes();
		initCrimsonDyedRecipes();
		initEldritchRecipes();
		initIronRecipes();
		initThaumiumRecipes();
		initVoidRecipes();
		*/
		initRunicRecipes();
		initRunicUpgrades();
	}
	
	public static void initCrimsonRecipes() {
		
	}
	
	public static void initCrimsonDyedRecipes() {
		
	}
	
	public static void initEldritchRecipes() {
		
	}
	
	public static void initIronRecipes() {
		
	}
	
	public static void initThaumiumRecipes() {
		
	}
	
	public static void initVoidRecipes() {
		
	}
	
	public static void initRunicRecipes() {
		//base
	    ConfigResearch.recipes.put("RunicArmorHelm", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMOR", 
	    		new ItemStack(ItemHandler.itemHelmetRunicLegacy), 4, 
	    		new AspectList().add(Aspect.ARMOR, 30).add(Aspect.MAGIC, 75).add(Aspect.ENERGY, 75), 
	    		new ItemStack(Items.golden_helmet, 1, 32767), 
	    		new ItemStack[] { 
	    			new ItemStack(ConfigItems.itemResource, 1, 15), 
	    			new ItemStack(ConfigItems.itemResource, 1, 6), 
	    			new ItemStack(ConfigItems.itemResource, 1, 7), 
	    			new ItemStack(ConfigItems.itemResource, 1, 1), 
	    			new ItemStack(ConfigItems.itemInkwell) }));
	    
	    ConfigResearch.recipes.put("RunicArmorChest", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMOR", 
	    		new ItemStack(ItemHandler.itemChestRunicLegacy), 4, 
	    		new AspectList().add(Aspect.ARMOR, 60).add(Aspect.MAGIC, 105).add(Aspect.ENERGY, 105), 
	    		new ItemStack(Items.golden_chestplate, 1, 32767), 
	    		new ItemStack[] { 
	    			new ItemStack(ConfigItems.itemResource, 1, 15), 
	    			new ItemStack(ConfigItems.itemResource, 1, 6), 
	    			new ItemStack(ConfigItems.itemResource, 1, 7), 
	    			new ItemStack(ConfigItems.itemResource, 1, 1), 
	    			new ItemStack(ConfigItems.itemResource, 1, 1), 
	    			new ItemStack(ConfigItems.itemResource, 1, 1), 
	    			new ItemStack(ConfigItems.itemInkwell) }));
	    
	    ConfigResearch.recipes.put("RunicArmorLegs", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMOR", 
	    		new ItemStack(ItemHandler.itemLegsRunicLegacy), 4, 
	    		new AspectList().add(Aspect.ARMOR, 45).add(Aspect.MAGIC, 90).add(Aspect.ENERGY, 90), 
	    		new ItemStack(Items.golden_leggings, 1, 32767), 
	    		new ItemStack[] { 
	    			new ItemStack(ConfigItems.itemResource, 1, 15), 
	    			new ItemStack(ConfigItems.itemResource, 1, 6), 
	    			new ItemStack(ConfigItems.itemResource, 1, 7), 
	    			new ItemStack(ConfigItems.itemResource, 1, 1), 
	    			new ItemStack(ConfigItems.itemResource, 1, 1), 
	    			new ItemStack(ConfigItems.itemInkwell) }));
	    
	    ConfigResearch.recipes.put("RunicArmorBoots", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMOR", 
	    		new ItemStack(ItemHandler.itemBootsRunicLegacy), 4, 
	    		new AspectList().add(Aspect.ARMOR, 30).add(Aspect.MAGIC, 75).add(Aspect.ENERGY, 75), 
	    		new ItemStack(Items.golden_boots, 1, 32767), 
	    		new ItemStack[] { 
	    			new ItemStack(ConfigItems.itemResource, 1, 15), 
	    			new ItemStack(ConfigItems.itemResource, 1, 6), 
	    			new ItemStack(ConfigItems.itemResource, 1, 7), 
	    			new ItemStack(ConfigItems.itemResource, 1, 1), 
	    			new ItemStack(ConfigItems.itemInkwell) }));
	    
	    
	    
	    ConfigResearch.recipes.put("RunicGoggles", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICGOGGLES", 
	    		new ItemStack(ItemHandler.itemGogglesRunicLegacy), 4, 
	    		new AspectList().add(Aspect.MAGIC, 25).add(Aspect.EXCHANGE, 25), 
	    		new ItemStack(ConfigItems.itemGoggles, 1, 32767), 
	    		new ItemStack[] { 
	    			new ItemStack(ItemHandler.itemHelmetRunicLegacy), 
	    			new ItemStack(Items.slime_ball) }));
	    
	    ConfigResearch.recipes.put("RunicBootsTraveller", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICBOOTSTRAVELLER", 
	    		new ItemStack(ItemHandler.itemBootsTravellerRunicLegacy), 4, 
	    		new AspectList().add(Aspect.MAGIC, 25).add(Aspect.EXCHANGE, 25), 
	    		new ItemStack(ConfigItems.itemBootsTraveller, 1, 32767), 
	    		new ItemStack[] { 
	    			new ItemStack(ItemHandler.itemBootsRunicLegacy), 
	    			new ItemStack(Items.slime_ball) }));
	    
	    
	    //ENHANCED
	    
	    ConfigResearch.recipes.put("EnhRunicArmor0", ThaumcraftApi.addInfusionCraftingRecipe("TD.ENHANCEDRUNICARMOR", 
	    		new ItemStack(ItemHandler.itemHelmetRunicTX), 8, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 160).add(Aspect.ENERGY, 80).add(Aspect.ELDRITCH, 20).add(Aspect.CLOTH, 24).add(Aspect.CRYSTAL, 16).add(Aspect.EXCHANGE, 20),  
	    		new ItemStack(ItemHandler.itemHelmetRunicLegacy), 
	    		new ItemStack[] { 
					new ItemStack(Items.nether_star),
					new ItemStack(ConfigItems.itemResource,1,7), //fabric7, salis14, p.charm 15, nitor1, amber6
					new ItemStack(ConfigItems.itemResource,1,7),
					new ItemStack(ConfigItems.itemResource,1,7),
					new ItemStack(Items.nether_star),
					new ItemStack(ConfigItems.itemShard,1,6),
					new ItemStack(ConfigItems.itemResource,1,15),
					new ItemStack(ConfigItems.itemResource,1,6),
					}));
	    
	    ConfigResearch.recipes.put("EnhRunicArmor1", ThaumcraftApi.addInfusionCraftingRecipe("TD.ENHANCEDRUNICARMOR", 
	    		new ItemStack(ItemHandler.itemChestRunicTX), 8, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 160).add(Aspect.ENERGY, 80).add(Aspect.ELDRITCH, 20).add(Aspect.CLOTH, 24).add(Aspect.CRYSTAL, 16).add(Aspect.EXCHANGE, 20),  
	    		new ItemStack(ItemHandler.itemChestRunicLegacy), 
	    		new ItemStack[] { 
					new ItemStack(Items.nether_star),
					new ItemStack(ConfigItems.itemResource,1,7), //fabric7, salis14, p.charm 15, nitor1, amber6
					new ItemStack(ConfigItems.itemResource,1,7),
					new ItemStack(ConfigItems.itemResource,1,7),
					new ItemStack(Items.nether_star),
					new ItemStack(ConfigItems.itemShard,1,6),
					new ItemStack(ConfigItems.itemResource,1,15),
					new ItemStack(ConfigItems.itemResource,1,6),
					}));
	    
	    ConfigResearch.recipes.put("EnhRunicArmor2", ThaumcraftApi.addInfusionCraftingRecipe("TD.ENHANCEDRUNICARMOR", 
	    		new ItemStack(ItemHandler.itemLegsRunicTX), 8, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 160).add(Aspect.ENERGY, 80).add(Aspect.ELDRITCH, 20).add(Aspect.CLOTH, 24).add(Aspect.CRYSTAL, 16).add(Aspect.EXCHANGE, 20),  
	    		new ItemStack(ItemHandler.itemLegsRunicLegacy), 
	    		new ItemStack[] { 
	    			new ItemStack(Items.nether_star),
	    			new ItemStack(ConfigItems.itemResource,1,7), //fabric7, salis14, p.charm 15, nitor1, amber6
	    			new ItemStack(ConfigItems.itemResource,1,7),
	    			new ItemStack(ConfigItems.itemResource,1,7),
	    			new ItemStack(Items.nether_star),
	    			new ItemStack(ConfigItems.itemShard,1,6),
	    			new ItemStack(ConfigItems.itemResource,1,15),
	    			new ItemStack(ConfigItems.itemResource,1,6),
	    			}));
	    
	    ConfigResearch.recipes.put("EnhRunicArmor3", ThaumcraftApi.addInfusionCraftingRecipe("TD.ENHANCEDRUNICARMOR", 
	    		new ItemStack(ItemHandler.itemBootsRunicTX), 8, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 160).add(Aspect.ENERGY, 80).add(Aspect.ELDRITCH, 20).add(Aspect.CLOTH, 24).add(Aspect.CRYSTAL, 16).add(Aspect.EXCHANGE, 20), 
	    		new ItemStack(ItemHandler.itemBootsRunicLegacy), 
	    		new ItemStack[] { 
					new ItemStack(Items.nether_star),
					new ItemStack(ConfigItems.itemResource,1,7), //fabric7, salis14, p.charm 15, nitor1, amber6
					new ItemStack(ConfigItems.itemResource,1,7),
					new ItemStack(ConfigItems.itemResource,1,7),
					new ItemStack(Items.nether_star),
					new ItemStack(ConfigItems.itemShard,1,6),
					new ItemStack(ConfigItems.itemResource,1,15),
					new ItemStack(ConfigItems.itemResource,1,6),
					}));
	    
		
	  
	}
	//TODO upgrades
	public static void initRunicUpgrades() {
		
		/**
		item.runic.upgrade.0= - No upgrade
		item.runic.upgrade.1= - Berserker
		item.runic.upgrade.2= - Augmented (+shields)
		item.runic.upgrade.3= - Kinetic Feedback (AOE)
		item.runic.upgrade.4= - Revitalizing Feedback (regen)
		item.runic.upgrade.5= - Hardened (+armour)
		item.runic.upgrade.6= - Emergency Shielding (+8u)
		 */
		
		//upgrade 1
		/*
		
		new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(Items.blaze_powder), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1) }));
		*/
	    ConfigResearch.recipes.put("RAU1_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte)1)}, 6, 
	    		new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
	    		new ItemStack(ItemHandler.itemHelmetRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(Items.blaze_powder), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1) }));
	    
	    ConfigResearch.recipes.put("RAU1_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 1) }, 6, 
	    		new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
	    		new ItemStack(ItemHandler.itemChestRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(Items.blaze_powder), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1) }));
	    
	    ConfigResearch.recipes.put("RAU1_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 1) }, 6, 
	    		new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
	    		new ItemStack(ItemHandler.itemLegsRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(Items.blaze_powder), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1) }));
	    
	    ConfigResearch.recipes.put("RAU1_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 1) }, 6, 
	    		new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
	    		new ItemStack(ItemHandler.itemBootsRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(Items.blaze_powder), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1) }));
		
		
		//upgrade 2 (+shields)
		/*
		new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
		new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemResource, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6) }));
		*/
	    ConfigResearch.recipes.put("RAU2_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 2) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
	    		new ItemStack(ItemHandler.itemHelmetRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemResource, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6) }));
	    
	    ConfigResearch.recipes.put("RAU2_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 2) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
	    		new ItemStack(ItemHandler.itemChestRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemResource, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6) }));
	    
	    ConfigResearch.recipes.put("RAU2_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 2) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
	    		new ItemStack(ItemHandler.itemLegsRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemResource, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6) }));
	    
	    ConfigResearch.recipes.put("RAU2_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 2) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
	    		new ItemStack(ItemHandler.itemBootsRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemResource, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6) }));
		
		//upgrade 3
	    /*
	    new AspectList().add(Aspect.ARMOR, 33).add(Aspect.MAGIC, 55).add(Aspect.AIR, 64),
	    new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(Items.potionitem, 1, 16428), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0) }));
	    */
	    ConfigResearch.recipes.put("RAU3_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 3) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40), 
	    		new ItemStack(ItemHandler.itemHelmetRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(Items.potionitem, 1, 16428), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0) }));
	    
	    ConfigResearch.recipes.put("RAU3_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 3) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40), 
	    		new ItemStack(ItemHandler.itemChestRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(Items.potionitem, 1, 16428), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0) }));
	    
	    ConfigResearch.recipes.put("RAU3_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 3) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40), 
	    		new ItemStack(ItemHandler.itemLegsRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(Items.potionitem, 1, 16428), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0) }));
	    
	    ConfigResearch.recipes.put("RAU3_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 3) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40), 
	    		new ItemStack(ItemHandler.itemBootsRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(Items.potionitem, 1, 16428), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0) }));
		
		//upgrade 4
	    /*
	    new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 48).add(Aspect.WATER, 32).add(Aspect.HEAL, 60), 
	    new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(Items.potionitem, 1, 8257), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2) }));
	    */
	    ConfigResearch.recipes.put("RAU4_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 4) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 48).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
	    		new ItemStack(ItemHandler.itemHelmetRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(Items.potionitem, 1, 8257), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2) }));
	    
	    ConfigResearch.recipes.put("RAU4_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 4) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 48).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
	    		new ItemStack(ItemHandler.itemChestRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(Items.potionitem, 1, 8257), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2) }));
	    
	    ConfigResearch.recipes.put("RAU4_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 4) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 48).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
	    		new ItemStack(ItemHandler.itemLegsRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(Items.potionitem, 1, 8257), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2) }));
	    
	    ConfigResearch.recipes.put("RAU4_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 4) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 48).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
	    		new ItemStack(ItemHandler.itemBootsRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(Items.potionitem, 1, 8257), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2) }));
		
		//upgrade 5 (+armour)
	    /*
	    new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
	    new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(Blocks.iron_block), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4) }));
	    */
	    ConfigResearch.recipes.put("RAU5_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 5) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
	    		new ItemStack(ItemHandler.itemHelmetRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(Blocks.iron_block), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4) }));
	    
	    ConfigResearch.recipes.put("RAU5_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 5) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
	    		new ItemStack(ItemHandler.itemChestRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(Blocks.iron_block), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4) }));
	    
	    ConfigResearch.recipes.put("RAU5_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 5) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
	    		new ItemStack(ItemHandler.itemLegsRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(Blocks.iron_block), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4) }));
	    
	    ConfigResearch.recipes.put("RAU5_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 5) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
	    		new ItemStack(ItemHandler.itemBootsRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(Blocks.iron_block), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4) }));
		
		//upgrade 6 (+emergency)
	    /*
	    new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80), 
	    new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(Items.potionitem, 1, 8233), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3) }));
	    */
	    ConfigResearch.recipes.put("RAU6_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 6) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
	    		new ItemStack(ItemHandler.itemHelmetRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(Items.potionitem, 1, 8233), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3) }));
	    
	    ConfigResearch.recipes.put("RAU6_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 6) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
	    		new ItemStack(ItemHandler.itemChestRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(Items.potionitem, 1, 8233), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3) }));
	    
	    ConfigResearch.recipes.put("RAU6_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 6) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
	    		new ItemStack(ItemHandler.itemLegsRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(Items.potionitem, 1, 8233), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3) }));
	    
	    ConfigResearch.recipes.put("RAU6_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 6) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
	    		new ItemStack(ItemHandler.itemBootsRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(Items.potionitem, 1, 8233), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3) }));
		
	    
	    //goggles
	    
	    ConfigResearch.recipes.put("RGU1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 1) }, 6, 
	    		new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
	    		new ItemStack(ItemHandler.itemGogglesRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(Items.blaze_powder), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1) }));
	    
	    ConfigResearch.recipes.put("RGU2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 2) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
	    		new ItemStack(ItemHandler.itemGogglesRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemResource, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6) }));
	    
	    ConfigResearch.recipes.put("RGU3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 3) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40), 
	    		new ItemStack(ItemHandler.itemGogglesRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(Items.potionitem, 1, 16428), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0) }));
	    
	    ConfigResearch.recipes.put("RGU4", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 4) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 48).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
	    		new ItemStack(ItemHandler.itemGogglesRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(Items.potionitem, 1, 8257), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2) }));
	    
	    ConfigResearch.recipes.put("RGU5", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 5) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
	    		new ItemStack(ItemHandler.itemGogglesRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(Blocks.iron_block), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4) }));
	    
	    ConfigResearch.recipes.put("RGU6", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 6) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
	    		new ItemStack(ItemHandler.itemGogglesRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(Items.potionitem, 1, 8233), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3) }));
		
	    
		//traveller's boots
	    
	    ConfigResearch.recipes.put("RBTU1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 1) }, 6, 
	    		new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
	    		new ItemStack(ItemHandler.itemBootsTravellerRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(Items.blaze_powder), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1) }));
	    
	    ConfigResearch.recipes.put("RBTU2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 2) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
	    		new ItemStack(ItemHandler.itemBootsTravellerRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemResource, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6) }));
	    
	    ConfigResearch.recipes.put("RBTU3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 3) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40), 
	    		new ItemStack(ItemHandler.itemBootsTravellerRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(Items.potionitem, 1, 16428), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0) }));
	    
	    ConfigResearch.recipes.put("RBTU4", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 4) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 48).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
	    		new ItemStack(ItemHandler.itemBootsTravellerRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(Items.potionitem, 1, 8257), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2) }));
	    
	    ConfigResearch.recipes.put("RBTU5", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 5) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
	    		new ItemStack(ItemHandler.itemBootsTravellerRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(Blocks.iron_block), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4) }));
	    
	    ConfigResearch.recipes.put("RBTU6", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 6) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
	    		new ItemStack(ItemHandler.itemBootsTravellerRunicLegacy), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(Items.potionitem, 1, 8233), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3) }));
		
	    
	    
	    //Enhanced
	    
	    //upgrade 1
  	    ConfigResearch.recipes.put("ERAU1_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
  	    		new Object[] { "upgrade", new NBTTagByte((byte)1)}, 6, 
  	    		new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
  	    		new ItemStack(ItemHandler.itemHelmetRunicTX), 
  	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(Items.blaze_powder), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1) }));
  	    
  	    ConfigResearch.recipes.put("ERAU1_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
  	    		new Object[] { "upgrade", new NBTTagByte((byte) 1) }, 6, 
  	    		new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
  	    		new ItemStack(ItemHandler.itemChestRunicTX), 
  	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(Items.blaze_powder), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1) }));
  	    
  	    ConfigResearch.recipes.put("ERAU1_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
  	    		new Object[] { "upgrade", new NBTTagByte((byte) 1) }, 6, 
  	    		new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
  	    		new ItemStack(ItemHandler.itemLegsRunicTX), 
  	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(Items.blaze_powder), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1) }));
  	    
  	    ConfigResearch.recipes.put("ERAU1_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
  	    		new Object[] { "upgrade", new NBTTagByte((byte) 1) }, 6, 
  	    		new AspectList().add(Aspect.WEAPON, 120).add(Aspect.MAGIC, 50).add(Aspect.FIRE, 32),
  	    		new ItemStack(ItemHandler.itemBootsRunicTX), 
  	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(Items.blaze_powder), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1) }));
  		
	    
	    //upgrade 2
	    ConfigResearch.recipes.put("ERAU2_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 2) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
	    		new ItemStack(ItemHandler.itemHelmetRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemResource, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6) }));
	    
	    ConfigResearch.recipes.put("ERAU2_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 2) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
	    		new ItemStack(ItemHandler.itemChestRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemResource, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6) }));
	    
	    ConfigResearch.recipes.put("ERAU2_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 2) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
	    		new ItemStack(ItemHandler.itemLegsRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemResource, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6) }));
	    
	    ConfigResearch.recipes.put("ERAU2_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 2) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 256).add(Aspect.MAGIC, 256).add(Aspect.ENERGY, 512).add(Aspect.CRYSTAL, 32),
	    		new ItemStack(ItemHandler.itemBootsRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemResource, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6) }));
		
		//upgrade 3
	    ConfigResearch.recipes.put("ERAU3_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 3) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40), 
	    		new ItemStack(ItemHandler.itemHelmetRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(Items.potionitem, 1, 16428), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0) }));
	    
	    ConfigResearch.recipes.put("ERAU3_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 3) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40), 
	    		new ItemStack(ItemHandler.itemChestRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(Items.potionitem, 1, 16428), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0) }));
	    
	    ConfigResearch.recipes.put("ERAU3_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 3) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40), 
	    		new ItemStack(ItemHandler.itemLegsRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(Items.potionitem, 1, 16428), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0) }));
	    
	    ConfigResearch.recipes.put("ERAU3_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 3) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 60).add(Aspect.AIR, 80).add(Aspect.MOTION, 40), 
	    		new ItemStack(ItemHandler.itemBootsRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(Items.potionitem, 1, 16428), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0) }));
		
		//upgrade 4
	    ConfigResearch.recipes.put("ERAU4_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 4) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 48).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
	    		new ItemStack(ItemHandler.itemHelmetRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(Items.potionitem, 1, 8257), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2) }));
	    
	    ConfigResearch.recipes.put("ERAU4_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 4) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 48).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
	    		new ItemStack(ItemHandler.itemChestRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(Items.potionitem, 1, 8257), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2) }));
	    
	    ConfigResearch.recipes.put("ERAU4_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 4) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 48).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
	    		new ItemStack(ItemHandler.itemLegsRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(Items.potionitem, 1, 8257), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2) }));
	    
	    ConfigResearch.recipes.put("ERAU4_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 4) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 48).add(Aspect.WATER, 32).add(Aspect.HEAL, 60),
	    		new ItemStack(ItemHandler.itemBootsRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(Items.potionitem, 1, 8257), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2) }));
		
		//upgrade 5
	    ConfigResearch.recipes.put("ERAU5_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 5) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
	    		new ItemStack(ItemHandler.itemHelmetRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(Blocks.iron_block), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4) }));
	    
	    ConfigResearch.recipes.put("ERAU5_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 5) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
	    		new ItemStack(ItemHandler.itemChestRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(Blocks.iron_block), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4) }));
	    
	    ConfigResearch.recipes.put("ERAU5_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 5) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
	    		new ItemStack(ItemHandler.itemLegsRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(Blocks.iron_block), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4) }));
	    
	    ConfigResearch.recipes.put("ERAU5_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 5) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 32).add(Aspect.ORDER, 32).add(Aspect.METAL, 40),
	    		new ItemStack(ItemHandler.itemBootsRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(Blocks.iron_block), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4) }));
		
		//upgrade 6
	    
	    ConfigResearch.recipes.put("ERAU6_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 6) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
	    		new ItemStack(ItemHandler.itemHelmetRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(Items.potionitem, 1, 8233), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3) }));
	    
	    ConfigResearch.recipes.put("ERAU6_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 6) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
	    		new ItemStack(ItemHandler.itemChestRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(Items.potionitem, 1, 8233), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3) }));
	    
	    ConfigResearch.recipes.put("ERAU6_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 6) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
	    		new ItemStack(ItemHandler.itemLegsRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(Items.potionitem, 1, 8233), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3) }));
	    
	    ConfigResearch.recipes.put("ERAU6_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 6) }, 6, 
	    		new AspectList().add(Aspect.ARMOR, 40).add(Aspect.MAGIC, 56).add(Aspect.EARTH, 32).add(Aspect.ENERGY, 80),
	    		new ItemStack(ItemHandler.itemBootsRunicTX), 
	    		new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(Items.potionitem, 1, 8233), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3) }));
	    
	    
	    
	}
	
	
}
