package thaumic.dyes.common;

import java.util.HashMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumic.dyes.common.items.ItemHandler;

public class DyeResearch {
   public static HashMap recipes = new HashMap();
   static InfusionRecipe recipeRobeHelm;
   static InfusionRecipe recipeRobeChest;
   static InfusionRecipe recipeRobeLegs;
   static InfusionRecipe recipePraeHelm;
   static InfusionRecipe recipePraeChest;
   static InfusionRecipe recipePraeLegs;
   static InfusionRecipe recipeFortHelm;
   static InfusionRecipe recipeFortChest;
   static InfusionRecipe recipeFortLegs;
   
   //coming soon(TM) 
   /*
   static InfusionRecipe recipeKniHelm;
   static InfusionRecipe recipeKniChest;
   static InfusionRecipe recipeKniLegs;
   static InfusionRecipe recipeRobeBoots;
   */
   

   public static void addResearch() {
      ResearchCategories.registerCategory(
    		  "DYES", 
    		  new ResourceLocation("thaum:textures/gui/r_td2.png"), 
    		  new ResourceLocation("thaum:textures/gui/r_tdbg.png")
      );
      
      //Copy research nodes
      copy(ResearchCategories.getResearchList("ARTIFICE").research.get("ARMORFORTRESS"),"TD.ARMORFORTRESS","DYES",5,-4).setConcealed().setHidden().registerResearchItem();
      copy(ResearchCategories.getResearchList("ELDRITCH").research.get("VOIDMETAL"),"TD.VOIDMETAL","DYES",0,-1).setConcealed().setHidden().registerResearchItem();
      
      //Crimson Robes
      (new ResearchItem("DYEDROBE", "DYES", (new AspectList()).add(Aspect.CLOTH, 4).add(Aspect.ARMOR, 4).add(Aspect.MAGIC, 4),
    		  -2, -3, 2, 
    		  ItemApi.getItem("itemHelmetCultistRobe", 0)))
    		  .setPages(new ResearchPage[]{
    				  new ResearchPage("tc.research_page.TD.DC.1"), 
    				  new ResearchPage(recipeRobeHelm), 
    				  new ResearchPage(recipeRobeChest), 
    				  new ResearchPage(recipeRobeLegs)/*,
    				  new ResearchPage(recipeRobeBoots)*/})
    		  .setParents("TD.VOIDMETAL")
    		  .registerResearchItem();
	      
      //WIP - Crimson Knight
      /*
      (new ResearchItem("DYEDKNIGHT", "DYES", (new AspectList()).add(Aspect.CLOTH, 4).add(Aspect.ARMOR, 4).add(Aspect.MAGIC, 4),
    		  -3, -1, 2, 
    		  ItemApi.getItem("itemHelmetCultistPlate", 0)))
    		  .setPages(new ResearchPage[]{
    				  new ResearchPage("tc.research_page.TD.DK.1")/*, 
    				  new ResearchPage(recipeKniHelm), 
    				  new ResearchPage(recipeKniChest), 
    				  new ResearchPage(recipeKniLegs)*})
    		  .setParents("TD.VOIDMETAL")
    		  .registerResearchItem();
	  */
    	
      //Crimson Praetor
      (new ResearchItem("DYEDPRAETOR", "DYES", 
    		  (new AspectList()).add(Aspect.CLOTH, 5).add(Aspect.ARMOR, 5).add(Aspect.MAGIC, 5).add(Aspect.DARKNESS, 5),
    		  -6, -2, 3, 
    		  ItemApi.getItem("itemHelmetCultistLeaderPlate", 0)))
    		  .setPages(new ResearchPage[]{
    				  new ResearchPage("tc.research_page.TD.DP.1"), 
    				  new ResearchPage(recipePraeHelm), 
    				  new ResearchPage(recipePraeChest), 
    				  new ResearchPage(recipePraeLegs)})
			  .setParents("DYEDROBE") //change to "DYEDKNIGHT" once implemented
			  .registerResearchItem();
      
      //Thaum Fortress
      (new ResearchItem("DYEDFORTRESS", "DYES", 
    		  (new AspectList()).add(Aspect.AURA, 5).add(Aspect.ARMOR, 5).add(Aspect.MAGIC, 5).add(Aspect.CRAFT, 5),
    		  3, -3, 5, 
    		  new ItemStack(ItemHandler.itemHelmetFortress, 0)))
    		  .setPages(new ResearchPage[]{
    				  new ResearchPage("tc.research_page.TD.DF.1"), 
    				  new ResearchPage(recipeFortHelm), 
    				  new ResearchPage(recipeFortChest), 
    				  new ResearchPage(recipeFortLegs)})
			  .setParents("TD.VOIDMETAL","TD.ARMORFORTRESS")
			  .registerResearchItem();
   }

   static {
	   recipeRobeHelm = ThaumcraftApi.addInfusionCraftingRecipe("DYEDCRIM", new ItemStack(ItemHandler.itemHelmetCultistRobe), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8), ItemApi.getItem("itemHelmetCultistRobe", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16)});
	   recipeRobeChest = ThaumcraftApi.addInfusionCraftingRecipe("DYEDCRIM", new ItemStack(ItemHandler.itemChestCultistRobe), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8), ItemApi.getItem("itemChestCultistRobe", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16)});
	   recipeRobeLegs = ThaumcraftApi.addInfusionCraftingRecipe("DYEDCRIM", new ItemStack(ItemHandler.itemLegsCultistRobe), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8), ItemApi.getItem("itemLegsCultistRobe", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16)});
      
	   recipePraeHelm = ThaumcraftApi.addInfusionCraftingRecipe("DYEDPRAETOR", new ItemStack(ItemHandler.itemHelmetCultistLeaderPlate), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8).add(Aspect.DARKNESS, 16), ItemApi.getItem("itemHelmetCultistLeaderPlate", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16)});
	   recipePraeChest = ThaumcraftApi.addInfusionCraftingRecipe("DYEDPRAETOR", new ItemStack(ItemHandler.itemChestCultistLeaderPlate), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8).add(Aspect.DARKNESS, 16), ItemApi.getItem("itemChestCultistLeaderPlate", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16)});
	   recipePraeLegs = ThaumcraftApi.addInfusionCraftingRecipe("DYEDPRAETOR", new ItemStack(ItemHandler.itemLegsCultistLeaderPlate), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8).add(Aspect.DARKNESS, 16), ItemApi.getItem("itemLegsCultistLeaderPlate", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16)});
      
	   recipeFortHelm = ThaumcraftApi.addInfusionCraftingRecipe("DYEDFORTRESS", new ItemStack(ItemHandler.itemHelmetFortress), 5, (new AspectList()).add(Aspect.AURA, 16).add(Aspect.MAGIC, 8).add(Aspect.CRAFT, 16), ItemApi.getItem("itemHelmetFortress", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16)});
	   recipeFortChest = ThaumcraftApi.addInfusionCraftingRecipe("DYEDFORTRESS", new ItemStack(ItemHandler.itemChestFortress), 5, (new AspectList()).add(Aspect.AURA, 16).add(Aspect.MAGIC, 8).add(Aspect.CRAFT, 16), ItemApi.getItem("itemChestFortress", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16)});
	   recipeFortLegs = ThaumcraftApi.addInfusionCraftingRecipe("DYEDFORTRESS", new ItemStack(ItemHandler.itemLegsFortress), 5, (new AspectList()).add(Aspect.AURA, 16).add(Aspect.MAGIC, 8).add(Aspect.CRAFT, 16), ItemApi.getItem("itemLegsFortress", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16)});
   	   
   	   /*
   	   recipeKniHelm = 
   	   recipeKniChest = 
   	   recipeKniLegs = 
   	   recipeRobeBoots   	   
   	   */
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
