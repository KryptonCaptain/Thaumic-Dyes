package thaumicdyes.common.recipe;

import cpw.mods.fml.common.registry.GameRegistry;

import java.util.ArrayList;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagInt;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumicdyes.common.DyeResearch;
import thaumicdyes.common.recipe.RobeDyes;
import thaumicdyes.common.recipe.FortressDyes;
import thaumicdyes.common.recipe.PraetorDyes;
import thaumicdyes.common.items.ItemHandler;

public class DyesRecipes {

   public static void initRecipes() {
	   
      RecipeSorter.register("forge:TDrobearmordye", RobeDyes.class, Category.SHAPELESS, "after:forge:robearmordye");
      RecipeSorter.register("forge:TDfortressarmordye", FortressDyes.class, Category.SHAPELESS, "after:forge:robearmordye");
      RecipeSorter.register("forge:TDpraetorarmordye", PraetorDyes.class, Category.SHAPELESS, "after:forge:robearmordye");
      RecipeSorter.register("forge:TDknightarmordye", KnightDyes.class, Category.SHAPELESS, "after:forge:robearmordye");
      
      GameRegistry.addRecipe(new RobeDyes());
      GameRegistry.addRecipe(new FortressDyes());
      GameRegistry.addRecipe(new PraetorDyes());
      GameRegistry.addRecipe(new KnightDyes());
      
      //Infusion extras
      
      //Add fortress mask recipes
      
      DyeResearch.recipes.put("HelmGoggles", 												//?src: new NBTTagByte(1)
    		  ThaumcraftApi.addInfusionCraftingRecipe("HELMGOGGLES", new Object[] { "goggles", new NBTTagByte((byte) 1) }, 5, 
    		  new AspectList().add(Aspect.SENSES, 32).add(Aspect.AURA, 16).add(Aspect.ARMOR, 16), 
    		  new ItemStack(ItemHandler.itemHelmetFortress, 1, 32767), 
		      new ItemStack[] { 
		    	  new ItemStack(Items.slime_ball), 
		    	  ItemApi.getItem("itemGoggles", 0) })
	  );
    
      DyeResearch.recipes.put("MaskGrinningDevil",
    		ThaumcraftApi.addInfusionCraftingRecipe("MASKGRINNINGDEVIL", new Object[] { "mask", new NBTTagInt(0) }, 8, 
      		new AspectList().add(Aspect.MIND, 64).add(Aspect.HEAL, 64).add(Aspect.ARMOR, 16), 
      		new ItemStack(ItemHandler.itemHelmetFortress, 1, 32767), 
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
      		new ItemStack(ItemHandler.itemHelmetFortress, 1, 32767), 
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
      		new ItemStack(ItemHandler.itemHelmetFortress, 1, 32767), 
      			new ItemStack[] { new ItemStack(Items.dye, 1, 1), 
      			new ItemStack(Items.iron_ingot), 
      			new ItemStack(Items.leather), 
      			new ItemStack(Items.ghast_tear), 
      			new ItemStack(Items.milk_bucket), 
      			new ItemStack(Items.iron_ingot) })
	  );
           
   }
}
