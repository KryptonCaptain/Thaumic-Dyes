package thaumicdyes.common;

import java.util.HashMap;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumicdyes.common.items.ItemHandler;

public class DyeResearch {
   //public static HashMap recipes = new HashMap();
   public static HashMap<String, Object> recipes = new HashMap();

   //static InfusionRecipe recipeRobeBoots;
   
   

   public static void addResearch() {
      ResearchCategories.registerCategory(
    		  "DYES", 
    		  new ResourceLocation("thaumicdyes:textures/gui/r_td2.png"), 
    		  new ResourceLocation("thaumicdyes:textures/gui/r_tdbg.png")
      );
      
      //Copy research nodes
      copy(ResearchCategories.getResearchList("ARTIFICE").research.get("ARMORFORTRESS"),"TD.ARMORFORTRESS","DYES",5,-4).setConcealed().setHidden().registerResearchItem();
      copy(ResearchCategories.getResearchList("ELDRITCH").research.get("VOIDMETAL"),"TD.VOIDMETAL","DYES",0,-1).setConcealed().setHidden().registerResearchItem();
      copy(ResearchCategories.getResearchList("ELDRITCH").research.get("ENTEROUTER"),"TD.OUTERARRIVAL","DYES",-1,2).setConcealed().setHidden().registerResearchItem();
      copy(ResearchCategories.getResearchList("ALCHEMY").research.get("THAUMIUM"),"TD.THAUMIUM","DYES",0,-2).setConcealed().setHidden().registerResearchItem();
      
      //TODO Crimson Robes
	   InfusionRecipe recipeRobeHelm = new InfusionRecipe("DYEDCRIM",
			   new ItemStack(ItemHandler.itemHelmetCultistRobe), 5, 
			   (new AspectList()).add(Aspect.ARMOR, 8).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 16).add(Aspect.METAL, 8), 
			   ItemApi.getItem("itemHelmetCultistRobe", 0), 
			   new ItemStack[]{
		   			ItemApi.getItem("itemGoggles", 0),
		   			ItemApi.getItem("itemResource", 7), 
		   			ItemApi.getItem("itemResource", 2), 
		   			ItemApi.getItem("itemResource", 7)});
	   
	   InfusionRecipe recipeRobeChest = new InfusionRecipe("DYEDCRIM", 
			   new ItemStack(ItemHandler.itemChestCultistRobe), 5, 
			   (new AspectList()).add(Aspect.ARMOR, 12).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 24).add(Aspect.METAL, 8),  
			   ItemApi.getItem("itemChestCultistRobe", 0), 
			   new ItemStack[]{
				   ItemApi.getItem("itemResource", 14),
				   ItemApi.getItem("itemResource", 7),
				   ItemApi.getItem("itemResource", 2),
				   ItemApi.getItem("itemResource", 7)});
			   
	   InfusionRecipe recipeRobeLegs = new InfusionRecipe("DYEDCRIM",
			   new ItemStack(ItemHandler.itemLegsCultistRobe), 5, 
			   (new AspectList()).add(Aspect.ARMOR, 10).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 20).add(Aspect.METAL, 8),  
			   ItemApi.getItem("itemLegsCultistRobe", 0), 
			   new ItemStack[]{
				   ItemApi.getItem("itemResource", 14), 
				   ItemApi.getItem("itemResource", 7), 
				   ItemApi.getItem("itemResource", 2), 
				   ItemApi.getItem("itemResource", 7)});

      new ResearchItem("DYEDROBE", "DYES", 
    		  (new AspectList()).add(Aspect.CLOTH, 4).add(Aspect.ARMOR, 4).add(Aspect.MAGIC, 4),
    		  -2, -3, 2, 
    		  ItemApi.getItem("itemHelmetCultistRobe", 0))
    		  .setPages(new ResearchPage[]{
    				  new ResearchPage("tc.research_page.TD.robe.1"), 
    				  new ResearchPage(recipeRobeHelm), 
    				  new ResearchPage(recipeRobeChest), 
    				  new ResearchPage(recipeRobeLegs)})
    		  .setParents("TD.THAUMIUM")
    		  .registerResearchItem();
      
      ThaumcraftApi.getCraftingRecipes().add(recipeRobeHelm);
      ThaumcraftApi.getCraftingRecipes().add(recipeRobeChest);
      ThaumcraftApi.getCraftingRecipes().add(recipeRobeLegs);
	      
      //TODO Crimson Knight
      InfusionRecipe recipeKniHelm = new InfusionRecipe("DYEDKNIGHT",
			   new ItemStack(ItemHandler.itemHelmetCultistPlate), 5, 
			   (new AspectList()).add(Aspect.ELDRITCH, 16).add(Aspect.MAGIC, 8).add(Aspect.CLOTH, 8), 
			   ItemApi.getItem("itemHelmetCultistPlate", 0), 
			   new ItemStack[]{
		   			ItemApi.getItem("itemResource", 14), 
		   			ItemApi.getItem("itemResource", 16), 
		   			ItemApi.getItem("itemResource", 16), 
		   			ItemApi.getItem("itemResource", 16)});
      	
      InfusionRecipe recipeKniChest = new InfusionRecipe("DYEDKNIGHT",
			   new ItemStack(ItemHandler.itemChestCultistPlate), 5, 
			   (new AspectList()).add(Aspect.ELDRITCH, 16).add(Aspect.MAGIC, 8).add(Aspect.CLOTH, 8), 
			   ItemApi.getItem("itemChestCultistPlate", 0), 
			   new ItemStack[]{
		   			ItemApi.getItem("itemResource", 14), 
		   			ItemApi.getItem("itemResource", 16), 
		   			ItemApi.getItem("itemResource", 16), 
		   			ItemApi.getItem("itemResource", 16)});
 	   
      InfusionRecipe recipeKniLegs = new InfusionRecipe("DYEDKNIGHT",
			   new ItemStack(ItemHandler.itemLegsCultistPlate), 5, 
			   (new AspectList()).add(Aspect.ELDRITCH, 16).add(Aspect.MAGIC, 8).add(Aspect.CLOTH, 8), 
			   ItemApi.getItem("itemLegsCultistPlate", 0), 
			   new ItemStack[]{
		   			ItemApi.getItem("itemResource", 14), 
		   			ItemApi.getItem("itemResource", 16), 
		   			ItemApi.getItem("itemResource", 16), 
		   			ItemApi.getItem("itemResource", 16)});
      
      new ResearchItem("DYEDKNIGHT", "DYES", 
    		  (new AspectList()).add(Aspect.CLOTH, 4).add(Aspect.ARMOR, 4).add(Aspect.MAGIC, 4),
    		  -3, -1, 2, 
    		  ItemApi.getItem("itemHelmetCultistPlate", 0))
    		  .setPages(new ResearchPage[]{
    				  new ResearchPage("tc.research_page.TD.knight.1"), 
    				  new ResearchPage(recipeKniHelm), 
    				  new ResearchPage(recipeKniChest), 
    				  new ResearchPage(recipeKniLegs)})
    		  .setParents("TD.THAUMIUM")
    		  .registerResearchItem();
      
      ThaumcraftApi.getCraftingRecipes().add(recipeKniHelm);
      ThaumcraftApi.getCraftingRecipes().add(recipeKniChest);
      ThaumcraftApi.getCraftingRecipes().add(recipeKniLegs);
	  
      //TODO Husk Armour
      InfusionRecipe recipeHuskHelm = new InfusionRecipe("INHABITEDPLATE",
			   new ItemStack(ItemHandler.itemHelmetInhabitedPlate), 5, 
			   (new AspectList()).add(Aspect.ENTROPY, 16).add(Aspect.ELDRITCH, 16).add(Aspect.METAL, 16).add(Aspect.ARMOR, 16), 
			   ItemApi.getItem("itemHelmetCultistPlate", 0), 
			   new ItemStack[]{
		   			ItemApi.getItem("itemShard", 5), 
		   			new ItemStack(Items.iron_ingot), 
		   			ItemApi.getItem("itemResource", 17)});
     	
      InfusionRecipe recipeHuskChest = new InfusionRecipe("INHABITEDPLATE",
			   new ItemStack(ItemHandler.itemChestInhabitedPlate), 5, 
			   (new AspectList()).add(Aspect.ENTROPY, 16).add(Aspect.ELDRITCH, 24).add(Aspect.METAL, 24).add(Aspect.ARMOR, 24), 
			   ItemApi.getItem("itemChestCultistPlate", 0), 
			   new ItemStack[]{
    	 			ItemApi.getItem("itemShard", 5), 
    	 			new ItemStack(Items.iron_ingot), 
    	 			new ItemStack(Items.iron_ingot),
    	 			ItemApi.getItem("itemResource", 17),
    	 			ItemApi.getItem("itemResource", 17)});
	   
      InfusionRecipe recipeHuskLegs = new InfusionRecipe("INHABITEDPLATE",
			   new ItemStack(ItemHandler.itemLegsInhabitedPlate), 5, 
			   (new AspectList()).add(Aspect.ENTROPY, 16).add(Aspect.ELDRITCH, 20).add(Aspect.METAL, 20).add(Aspect.ARMOR, 20), 
			   ItemApi.getItem("itemLegsCultistPlate", 0), 
			   new ItemStack[]{
    	 			ItemApi.getItem("itemShard", 5), 
    	 			new ItemStack(Items.iron_ingot), 
    	 			new ItemStack(Items.iron_ingot),
    	 			ItemApi.getItem("itemResource", 17)});
      
      new ResearchItem("INHABITEDPLATE", "DYES", 
		  (new AspectList()).add(Aspect.ENTROPY, 4).add(Aspect.EXCHANGE, 4).add(Aspect.ELDRITCH, 4),
          -4, 1, 2, 
		  new ItemStack(ItemHandler.itemHelmetInhabitedPlate, 0))
		  .setPages(new ResearchPage[]{
				  new ResearchPage("tc.research_page.TD.husk.1"), 
				  new ResearchPage(recipeHuskHelm), 
				  new ResearchPage(recipeHuskChest), 
				  new ResearchPage(recipeHuskLegs)})
		  .setParents(/*"DYEDKNIGHT",*/ "TD.OUTERARRIVAL")
		  .registerResearchItem();
      
      ThaumcraftApi.getCraftingRecipes().add(recipeHuskHelm);
      ThaumcraftApi.getCraftingRecipes().add(recipeHuskChest);
      ThaumcraftApi.getCraftingRecipes().add(recipeHuskLegs);		  
    	
      //TODO Crimson Praetor
      InfusionRecipe recipePraeHelm = new InfusionRecipe("DYEDPRAETOR", 
			   new ItemStack(ItemHandler.itemHelmetCultistLeaderPlate), 5, 
			   (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8).add(Aspect.DARKNESS, 16), 
			   ItemApi.getItem("itemHelmetCultistLeaderPlate", 0), 
			   new ItemStack[]{
		  			ItemApi.getItem("itemResource", 14), 
		  			ItemApi.getItem("itemResource", 16), 
		  			ItemApi.getItem("itemResource", 16), 
		  			ItemApi.getItem("itemResource", 16)});
	  
      InfusionRecipe recipePraeChest = new InfusionRecipe("DYEDPRAETOR", 
			   new ItemStack(ItemHandler.itemChestCultistLeaderPlate), 5, 
			   (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8).add(Aspect.DARKNESS, 16), 
			   ItemApi.getItem("itemChestCultistLeaderPlate", 0), 
			   new ItemStack[]{
		  			ItemApi.getItem("itemResource", 14), 
		  			ItemApi.getItem("itemResource", 16), 
		  			ItemApi.getItem("itemResource", 16), 
		  			ItemApi.getItem("itemResource", 16)});
	  
      InfusionRecipe recipePraeLegs = new InfusionRecipe("DYEDPRAETOR", 
			   new ItemStack(ItemHandler.itemLegsCultistLeaderPlate), 5, 
			   (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8).add(Aspect.DARKNESS, 16), 
			   ItemApi.getItem("itemLegsCultistLeaderPlate", 0), 
			   new ItemStack[]{
		  			ItemApi.getItem("itemResource", 14), 
		  			ItemApi.getItem("itemResource", 16), 
		  			ItemApi.getItem("itemResource", 16), 
		  			ItemApi.getItem("itemResource", 16)});
     
      
      new ResearchItem("DYEDPRAETOR", "DYES", 
    		  (new AspectList()).add(Aspect.CLOTH, 5).add(Aspect.ARMOR, 5).add(Aspect.MAGIC, 5).add(Aspect.DARKNESS, 5),
    		  -6, -2, 3, 
    		  ItemApi.getItem("itemHelmetCultistLeaderPlate", 0))
    		  .setPages(new ResearchPage[]{
    				  new ResearchPage("tc.research_page.TD.praetor.1"), 
    				  new ResearchPage(recipePraeHelm), 
    				  new ResearchPage(recipePraeChest), 
    				  new ResearchPage(recipePraeLegs)})
			  .setParents("DYEDKNIGHT") //change to "DYEDKNIGHT" once implemented
			  .registerResearchItem();
      
      ThaumcraftApi.getCraftingRecipes().add(recipePraeHelm);
      ThaumcraftApi.getCraftingRecipes().add(recipePraeChest);
      ThaumcraftApi.getCraftingRecipes().add(recipePraeLegs);
      
      //TODO Thaum Fortress
      InfusionRecipe recipeFortHelm = new InfusionRecipe("DYEDFORTRESS", 
			   new ItemStack(ItemHandler.itemHelmetFortress), 5, 
			   (new AspectList()).add(Aspect.AURA, 16).add(Aspect.MAGIC, 8).add(Aspect.CRAFT, 16), 
			   ItemApi.getItem("itemHelmetFortress", 0), 
			   new ItemStack[]{
				   ItemApi.getItem("itemResource", 14), 
				   ItemApi.getItem("itemResource", 16), 
				   ItemApi.getItem("itemResource", 16), 
				   ItemApi.getItem("itemResource", 16)});
			   
      InfusionRecipe recipeFortChest = new InfusionRecipe("DYEDFORTRESS", 
			   new ItemStack(ItemHandler.itemChestFortress), 5, 
			   (new AspectList()).add(Aspect.AURA, 16).add(Aspect.MAGIC, 8).add(Aspect.CRAFT, 16), 
			   ItemApi.getItem("itemChestFortress", 0), 
			   new ItemStack[]{
		   			ItemApi.getItem("itemResource", 14), 
		   			ItemApi.getItem("itemResource", 16), 
		   			ItemApi.getItem("itemResource", 16), 
		   			ItemApi.getItem("itemResource", 16)});
	   
      InfusionRecipe recipeFortLegs = new InfusionRecipe("DYEDFORTRESS", 
			   new ItemStack(ItemHandler.itemLegsFortress), 5, 
			   (new AspectList()).add(Aspect.AURA, 16).add(Aspect.MAGIC, 8).add(Aspect.CRAFT, 16), 
			   ItemApi.getItem("itemLegsFortress", 0), 
			   new ItemStack[]{
		   			ItemApi.getItem("itemResource", 14), 
		   			ItemApi.getItem("itemResource", 16), 
		   			ItemApi.getItem("itemResource", 16), 
		   			ItemApi.getItem("itemResource", 16)});

      
      new ResearchItem("DYEDFORTRESS", "DYES", 
    		  (new AspectList()).add(Aspect.AURA, 5).add(Aspect.ARMOR, 5).add(Aspect.MAGIC, 5).add(Aspect.CRAFT, 5),
    		  3, -3, 5, 
    		  new ItemStack(ItemHandler.itemHelmetFortress, 0))
    		  .setPages(new ResearchPage[]{
    				  new ResearchPage("tc.research_page.TD.fortress.1"), 
    				  new ResearchPage(recipeFortHelm), 
    				  new ResearchPage(recipeFortChest), 
    				  new ResearchPage(recipeFortLegs)})
			  .setParents("TD.VOIDMETAL","TD.ARMORFORTRESS")
			  .registerResearchItem();
      
      ThaumcraftApi.getCraftingRecipes().add(recipeFortHelm);
      ThaumcraftApi.getCraftingRecipes().add(recipeFortChest);
      ThaumcraftApi.getCraftingRecipes().add(recipeFortLegs);
              
   }

   
   //For some things
   //Borrowed from Thaumic Bases. Allows creating copies of research over to a tab
   public static ResearchItem copy(ResearchItem res, String newKey, String newCat, int dC, int dR)
	{
		ResearchItem rItem;
		
		if(res.icon_resource != null)
			rItem = new ResearchItem(newKey,newCat,res.tags,dC,dR,res.getComplexity(),res.icon_resource);
		else
			rItem = new ResearchItem(newKey,newCat,res.tags,dC,dR,res.getComplexity(),res.icon_item);
		
		rItem.parents = res.parents;
		rItem.parentsHidden = res.parentsHidden;
		rItem.siblings = res.siblings;
		rItem.setPages(res.getPages());
		rItem.setAspectTriggers(new Aspect[0]);
		rItem.setEntityTriggers(new String[0]);
		rItem.setItemTriggers(new ItemStack[0]);
		
		if(res.isAutoUnlock())
			rItem.setAutoUnlock();
		
		if(res.isConcealed())
			rItem.setConcealed();
		
		if(res.isHidden())
			rItem.setHidden();
		
		if(res.isLost())
			rItem.setLost();
		
		if(res.isRound())
			rItem.setRound();
		
		if(res.isSecondary())
			rItem.setSecondary();
		
		if(res.isSpecial())
			rItem.setSpecial();
		
		if(res.isStub())
			rItem.setStub();
		
		if(res.siblings != null && res.siblings.length > 0)
		{
			String[] sibStr = new String[res.siblings.length+1];
			for(int i = 0; i < res.siblings.length; ++i)
				sibStr[i] = res.siblings[i];
			
			sibStr[sibStr.length - 1] = newKey;
			
			res.setSiblings(sibStr);
		}else
		{
			res.setSiblings(newKey);
		}
		
		return rItem;
	}
   
  
}
