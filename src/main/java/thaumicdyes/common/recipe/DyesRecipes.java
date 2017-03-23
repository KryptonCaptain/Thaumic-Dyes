package thaumicdyes.common.recipe;

import cpw.mods.fml.common.registry.GameRegistry;

import java.util.ArrayList;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagInt;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.lib.crafting.ShapelessNBTOreRecipe;
import thaumicdyes.common.DyeResearch;
import thaumicdyes.common.recipe.CultistRobeDyes;
import thaumicdyes.common.recipe.FortressDyes;
import thaumicdyes.common.recipe.CultistPraetorDyes;
import thaumicdyes.common.items.ItemHandler;

public class DyesRecipes {

   public static void initRecipes() {
	   
	  initDyeRecipes();
	  initInfusionRecipes(); 
	   
	  RecipeSorter.register("forge:shapelessorenbt", ShapelessNBTOreRecipe.class, RecipeSorter.Category.SHAPELESS, "after:forge:shapelessore");
      RecipeSorter.register("forge:TDrobearmordye", CultistRobeDyes.class, Category.SHAPELESS, "after:forge:shapelessorenbt");
      RecipeSorter.register("forge:TDfortressarmordye", FortressDyes.class, Category.SHAPELESS, "after:forge:TDrobearmordye");
      RecipeSorter.register("forge:TDpraetorarmordye", CultistPraetorDyes.class, Category.SHAPELESS, "after:forge:TDrobearmordye");
      RecipeSorter.register("forge:TDknightarmordye", CultistKnightDyes.class, Category.SHAPELESS, "after:forge:TDrobearmordye");
      RecipeSorter.register("forge:TDrangerarmordye", CultistRangerDyes.class, Category.SHAPELESS, "after:forge:TDrobearmordye");
      RecipeSorter.register("forge:TDvoidrobearmordye", VoidRobeDyes.class, Category.SHAPELESS, "after:forge:TDrobearmordye");
      RecipeSorter.register("forge:TDthaumiumrobearmordye", ThaumiumRobeDyes.class, Category.SHAPELESS, "after:forge:TDrobearmordye");
      RecipeSorter.register("forge:TDarcherarmordye", CultistArcherDyes.class, Category.SHAPELESS, "after:forge:TDrobearmordye");
   }
   
   public static void initDyeRecipes() {
	  GameRegistry.addRecipe(new CultistRobeDyes());
      GameRegistry.addRecipe(new FortressDyes());
	  GameRegistry.addRecipe(new CultistPraetorDyes());
      GameRegistry.addRecipe(new CultistKnightDyes());
      GameRegistry.addRecipe(new CultistRangerDyes());
      GameRegistry.addRecipe(new VoidRobeDyes());
      GameRegistry.addRecipe(new ThaumiumRobeDyes());
      GameRegistry.addRecipe(new CultistArcherDyes());
   }
   
      
   public static void initInfusionRecipes() {
	      
     //Add fortress mask recipes
      DyeResearch.recipes.put("HelmGoggles", 												//?src: new NBTTagByte(1)
    		  ThaumcraftApi.addInfusionCraftingRecipe("HELMGOGGLES", new Object[] { "goggles", new NBTTagByte((byte) 1) }, 5, 
    		  new AspectList().add(Aspect.SENSES, 32).add(Aspect.AURA, 16).add(Aspect.ARMOR, 16), 
    		  new ItemStack(ItemHandler.itemHelmetFortressDyed, 1, 32767), 
		      new ItemStack[] { 
		    	  new ItemStack(Items.slime_ball), 
		    	  ItemApi.getItem("itemGoggles", 0) })
	  );
    
      DyeResearch.recipes.put("MaskGrinningDevil",
    		ThaumcraftApi.addInfusionCraftingRecipe("MASKGRINNINGDEVIL", new Object[] { "mask", new NBTTagInt(0) }, 8, 
      		new AspectList().add(Aspect.MIND, 64).add(Aspect.HEAL, 64).add(Aspect.ARMOR, 16), 
      		new ItemStack(ItemHandler.itemHelmetFortressDyed, 1, 32767), 
  			new ItemStack[] { 
  				new ItemStack(Items.dye, 1, 0), 
  				new ItemStack(Items.iron_ingot), 
  				new ItemStack(Items.leather), 
  				ItemApi.getBlock("blockCustomPlant", 2),
  				ItemApi.getItem("itemZombieBrain", 0), 
  				new ItemStack(Items.iron_ingot) })
	  );
      
      DyeResearch.recipes.put("MaskAngryGhost",
    		ThaumcraftApi.addInfusionCraftingRecipe("MASKANGRYGHOST", new Object[] { "mask", new NBTTagInt(1) }, 8, 
      		new AspectList().add(Aspect.ENTROPY, 64).add(Aspect.DEATH, 64).add(Aspect.ARMOR, 16), 
      		new ItemStack(ItemHandler.itemHelmetFortressDyed, 1, 32767), 
      		new ItemStack[] { 
      			new ItemStack(Items.dye, 1, 15), 
      			new ItemStack(Items.iron_ingot), 
      			new ItemStack(Items.leather), 
      			new ItemStack(Items.poisonous_potato), 
      			new ItemStack(Items.skull, 1, 1), 
      			new ItemStack(Items.iron_ingot) })
	  );
    
      DyeResearch.recipes.put("MaskSippingFiend",
    		ThaumcraftApi.addInfusionCraftingRecipe("MASKSIPPINGFIEND", new Object[] { "mask", new NBTTagInt(2) }, 8, 
      		new AspectList().add(Aspect.UNDEAD, 64).add(Aspect.LIFE, 64).add(Aspect.ARMOR, 16), 
      		new ItemStack(ItemHandler.itemHelmetFortressDyed, 1, 32767), 
      			new ItemStack[] { new ItemStack(Items.dye, 1, 1), 
      			new ItemStack(Items.iron_ingot), 
      			new ItemStack(Items.leather), 
      			new ItemStack(Items.ghast_tear), 
      			new ItemStack(Items.milk_bucket), 
      			new ItemStack(Items.iron_ingot) })
	  );
           
   }
   
   static IRecipe oreDictRecipe(ItemStack res, Object[] params)
   {
     IRecipe rec = new ShapedOreRecipe(res, params);
     CraftingManager.getInstance().getRecipeList().add(rec);
     return rec;
   }
   
   static IRecipe shapelessOreDictRecipe(ItemStack res, Object[] params)
   {
     IRecipe rec = new ShapelessOreRecipe(res, params);
     CraftingManager.getInstance().getRecipeList().add(rec);
     return rec;
   }
   
   static IRecipe shapelessNBTOreRecipe(ItemStack res, Object[] params)
   {
     IRecipe rec = new ShapelessNBTOreRecipe(res, params);
     CraftingManager.getInstance().getRecipeList().add(rec);
     return rec;
   }
}
