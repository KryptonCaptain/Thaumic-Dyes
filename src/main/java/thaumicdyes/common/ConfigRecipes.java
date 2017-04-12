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
	    		new ItemStack(ItemHandler.itemHelmetRunicLegacy), 3, 
	    		new AspectList().add(Aspect.ARMOR, 10).add(Aspect.MAGIC, 25).add(Aspect.ENERGY, 25), 
	    		new ItemStack(Items.golden_helmet, 1, 32767), 
	    		new ItemStack[] { 
	    			new ItemStack(ConfigItems.itemResource, 1, 15), 
	    			new ItemStack(ConfigItems.itemResource, 1, 6), 
	    			new ItemStack(ConfigItems.itemResource, 1, 7), 
	    			new ItemStack(ConfigItems.itemResource, 1, 1), 
	    			new ItemStack(ConfigItems.itemInkwell) }));
	    
	    ConfigResearch.recipes.put("RunicArmorBoots", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMOR", 
	    		new ItemStack(ItemHandler.itemBootsRunicLegacy), 3, 
	    		new AspectList().add(Aspect.ARMOR, 10).add(Aspect.MAGIC, 25).add(Aspect.ENERGY, 25), 
	    		new ItemStack(Items.golden_boots, 1, 32767), 
	    		new ItemStack[] { 
	    			new ItemStack(ConfigItems.itemResource, 1, 15), 
	    			new ItemStack(ConfigItems.itemResource, 1, 6), 
	    			new ItemStack(ConfigItems.itemResource, 1, 7), 
	    			new ItemStack(ConfigItems.itemResource, 1, 1), 
	    			new ItemStack(ConfigItems.itemInkwell) }));
	    
	    ConfigResearch.recipes.put("RunicArmorChest", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMOR", 
	    		new ItemStack(ItemHandler.itemChestRunicLegacy), 4, 
	    		new AspectList().add(Aspect.ARMOR, 20).add(Aspect.MAGIC, 35).add(Aspect.ENERGY, 35), 
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
	    		new AspectList().add(Aspect.ARMOR, 15).add(Aspect.MAGIC, 30).add(Aspect.ENERGY, 30), 
	    		new ItemStack(Items.golden_leggings, 1, 32767), 
	    		new ItemStack[] { 
	    			new ItemStack(ConfigItems.itemResource, 1, 15), 
	    			new ItemStack(ConfigItems.itemResource, 1, 6), 
	    			new ItemStack(ConfigItems.itemResource, 1, 7), 
	    			new ItemStack(ConfigItems.itemResource, 1, 1), 
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
		
	  
	}
	
	public static void initRunicUpgrades() {
		//upgrade 1
		/*
	    ConfigResearch.recipes.put("RAU1_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte)1)}, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.ENERGY, 32), new ItemStack(ItemHandler.itemHelmetRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.redstone), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1) }));
	    
	    ConfigResearch.recipes.put("RAU1_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 1) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.ENERGY, 32), new ItemStack(ItemHandler.itemChestRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.redstone), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1) }));
	    
	    ConfigResearch.recipes.put("RAU1_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 1) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.ENERGY, 32), new ItemStack(ItemHandler.itemLegsRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.redstone), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1) }));
	    
	    ConfigResearch.recipes.put("RAU1_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 1) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.ENERGY, 32), new ItemStack(ItemHandler.itemBootsRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.redstone), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1) }));
		*/
		
		//upgrade 2
	    ConfigResearch.recipes.put("RAU2_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 2) }, 3, new AspectList().add(Aspect.MAGIC, 32)
	    		.add(Aspect.ARMOR, 16), new ItemStack(ItemHandler.itemHelmetRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.flint), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4) }));
	    
	    ConfigResearch.recipes.put("RAU2_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 2) }, 3, new AspectList().add(Aspect.MAGIC, 32)
	    		.add(Aspect.ARMOR, 16), new ItemStack(ItemHandler.itemChestRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.flint), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4) }));
	    
	    ConfigResearch.recipes.put("RAU2_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 2) }, 3, new AspectList().add(Aspect.MAGIC, 32)
	    		.add(Aspect.ARMOR, 16), new ItemStack(ItemHandler.itemLegsRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.flint), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4) }));
	    
	    ConfigResearch.recipes.put("RAU2_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 2) }, 3, new AspectList().add(Aspect.MAGIC, 32)
	    		.add(Aspect.ARMOR, 16), new ItemStack(ItemHandler.itemBootsRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.flint), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4) }));
		
		//upgrade 3
	    ConfigResearch.recipes.put("RAU3_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 3) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.AIR, 16).add(Aspect.MOTION, 16), new ItemStack(ItemHandler.itemHelmetRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.gunpowder), new ItemStack(ConfigItems.itemShard, 1, 5), new ItemStack(ConfigItems.itemShard, 1, 5), new ItemStack(ConfigItems.itemShard, 1, 5) }));
	    
	    ConfigResearch.recipes.put("RAU3_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 3) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.AIR, 16).add(Aspect.MOTION, 16), new ItemStack(ItemHandler.itemChestRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.gunpowder), new ItemStack(ConfigItems.itemShard, 1, 5), new ItemStack(ConfigItems.itemShard, 1, 5), new ItemStack(ConfigItems.itemShard, 1, 5) }));
	    
	    ConfigResearch.recipes.put("RAU3_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 3) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.AIR, 16).add(Aspect.MOTION, 16), new ItemStack(ItemHandler.itemLegsRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.gunpowder), new ItemStack(ConfigItems.itemShard, 1, 5), new ItemStack(ConfigItems.itemShard, 1, 5), new ItemStack(ConfigItems.itemShard, 1, 5) }));
	    
	    ConfigResearch.recipes.put("RAU3_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 3) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.AIR, 16).add(Aspect.MOTION, 16), new ItemStack(ItemHandler.itemBootsRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.gunpowder), new ItemStack(ConfigItems.itemShard, 1, 5), new ItemStack(ConfigItems.itemShard, 1, 5), new ItemStack(ConfigItems.itemShard, 1, 5) }));
		
		//upgrade 4
	    ConfigResearch.recipes.put("RAU4_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 4) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.LIFE, 16).add(Aspect.HEAL, 16), new ItemStack(ItemHandler.itemHelmetRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.golden_apple), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2) }));
	    
	    ConfigResearch.recipes.put("RAU4_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 4) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.LIFE, 16).add(Aspect.HEAL, 16), new ItemStack(ItemHandler.itemChestRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.golden_apple), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2) }));
	    
	    ConfigResearch.recipes.put("RAU4_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 4) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.LIFE, 16).add(Aspect.HEAL, 16), new ItemStack(ItemHandler.itemLegsRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.golden_apple), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2) }));
	    
	    ConfigResearch.recipes.put("RAU4_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 4) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.LIFE, 16).add(Aspect.HEAL, 16), new ItemStack(ItemHandler.itemBootsRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.golden_apple), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2) }));
		
		//upgrade 5
	    ConfigResearch.recipes.put("RAU5_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 5) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.EARTH, 16).add(Aspect.METAL, 16), new ItemStack(ItemHandler.itemHelmetRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.iron_ingot), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3) }));
	    
	    ConfigResearch.recipes.put("RAU5_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 5) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.EARTH, 16).add(Aspect.METAL, 16), new ItemStack(ItemHandler.itemChestRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.iron_ingot), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3) }));
	    
	    ConfigResearch.recipes.put("RAU5_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 5) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.EARTH, 16).add(Aspect.METAL, 16), new ItemStack(ItemHandler.itemLegsRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.iron_ingot), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3) }));
	    
	    ConfigResearch.recipes.put("RAU5_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 5) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.EARTH, 16).add(Aspect.METAL, 16), new ItemStack(ItemHandler.itemBootsRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.iron_ingot), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3) }));
		
		//upgrade 6
	    /*
	    ConfigResearch.recipes.put("RAU6_0", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 6) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.ENERGY, 16).add(Aspect.CRYSTAL, 16), new ItemStack(ItemHandler.itemHelmetRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Blocks.glass), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0) }));
	    
	    ConfigResearch.recipes.put("RAU6_1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 6) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.ENERGY, 16).add(Aspect.CRYSTAL, 16), new ItemStack(ItemHandler.itemChestRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Blocks.glass), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0) }));
	    
	    ConfigResearch.recipes.put("RAU6_2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 6) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.ENERGY, 16).add(Aspect.CRYSTAL, 16), new ItemStack(ItemHandler.itemLegsRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Blocks.glass), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0) }));
	    
	    ConfigResearch.recipes.put("RAU6_3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 6) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.ENERGY, 16).add(Aspect.CRYSTAL, 16), new ItemStack(ItemHandler.itemBootsRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Blocks.glass), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0) }));
		*/
	    
	    //goggles
	    /*
	    ConfigResearch.recipes.put("RGU1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 1) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.ENERGY, 32), new ItemStack(ItemHandler.itemGogglesRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.redstone), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1) }));
	    */
	    ConfigResearch.recipes.put("RGU2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 2) }, 3, new AspectList().add(Aspect.MAGIC, 32)
	    		.add(Aspect.ARMOR, 16), new ItemStack(ItemHandler.itemGogglesRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.flint), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4) }));
	    
	    ConfigResearch.recipes.put("RGU3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 3) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.AIR, 16).add(Aspect.MOTION, 16), new ItemStack(ItemHandler.itemGogglesRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.gunpowder), new ItemStack(ConfigItems.itemShard, 1, 5), new ItemStack(ConfigItems.itemShard, 1, 5), new ItemStack(ConfigItems.itemShard, 1, 5) }));
	    
	    ConfigResearch.recipes.put("RGU4", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 4) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.LIFE, 16).add(Aspect.HEAL, 16), new ItemStack(ItemHandler.itemGogglesRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.golden_apple), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2) }));
	    
	    ConfigResearch.recipes.put("RGU5", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 5) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.EARTH, 16).add(Aspect.METAL, 16), new ItemStack(ItemHandler.itemGogglesRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.iron_ingot), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3) }));
	    /*
	    ConfigResearch.recipes.put("RGU6", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 6) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.ENERGY, 16).add(Aspect.CRYSTAL, 16), new ItemStack(ItemHandler.itemGogglesRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Blocks.glass), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0) }));
		*/
	    
		//traveller's boots
	    /*
	    ConfigResearch.recipes.put("RBTU1", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 1) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.ENERGY, 32), new ItemStack(ItemHandler.itemBootsTravellerRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.redstone), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemShard, 1, 1) }));
	    */
	    ConfigResearch.recipes.put("RBTU2", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 2) }, 3, new AspectList().add(Aspect.MAGIC, 32)
	    		.add(Aspect.ARMOR, 16), new ItemStack(ItemHandler.itemBootsTravellerRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.flint), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 4) }));
	    
	    ConfigResearch.recipes.put("RBTU3", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 3) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.AIR, 16).add(Aspect.MOTION, 16), new ItemStack(ItemHandler.itemBootsTravellerRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.gunpowder), new ItemStack(ConfigItems.itemShard, 1, 5), new ItemStack(ConfigItems.itemShard, 1, 5), new ItemStack(ConfigItems.itemShard, 1, 5) }));
	    
	    ConfigResearch.recipes.put("RBTU4", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 4) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.LIFE, 16).add(Aspect.HEAL, 16), new ItemStack(ItemHandler.itemBootsTravellerRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.golden_apple), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemShard, 1, 2) }));
	    
	    ConfigResearch.recipes.put("RBTU5", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 5) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.EARTH, 16).add(Aspect.METAL, 16), new ItemStack(ItemHandler.itemBootsTravellerRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.iron_ingot), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 3) }));
	    /*
	    ConfigResearch.recipes.put("RBTU6", ThaumcraftApi.addInfusionCraftingRecipe("TD.RUNICARMORUPGRADES",
	    		new Object[] { "upgrade", new NBTTagByte((byte) 6) }, 3, new AspectList().add(Aspect.MAGIC, 16)
	    		.add(Aspect.ENERGY, 16).add(Aspect.CRYSTAL, 16), new ItemStack(ItemHandler.itemBootsTravellerRunicLegacy), new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Blocks.glass), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 0) }));
		*/
	}
	
	
}
