package thaumicdyes.common;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraft.common.config.ConfigItems;
import thaumicdyes.common.items.ItemHandler;

public class ConfigResearch {
   //public static HashMap recipes = new HashMap();
   public static HashMap<String, Object> recipes = new HashMap();

   
   public static void addResearch() {
      ResearchCategories.registerCategory(
    		  "DYES", 
    		  new ResourceLocation("thaumicdyes:textures/gui/r_td2.png"), 
    		  new ResourceLocation("thaumicdyes:textures/gui/r_tdbg.png")
      );
      
      //Copy research nodes
      //copy(ResearchCategories.getResearchList("ELDRITCH").research.get("VOIDMETAL"),"TD.VOIDMETAL","DYES",0,-1).setConcealed().setHidden().registerResearchItem();
      
      researchCrimson();
      researchCrimsonDyed();
      researchEldritch();
      researchIron();
      researchThaumium();
      researchVoid();
      researchBoots();
      researchRunic();
      
   }
      
      
   //TODO Crimson expansion
   public static void researchCrimson() {
	   
	/////////////
	 //BOOK
	 
	 ShapedArcaneRecipe recipeFabricResource = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSON",
			   new ItemStack(ItemHandler.itemResourceFabric), 
			   (new AspectList()).add(Aspect.ENTROPY, 2).add(Aspect.ORDER, 5), 
			   new Object[]{
					"R",
					"F",
					"V",
					'R',new ItemStack(Items.dye, 1, 1),
					'F',new ItemStack(ConfigItems.itemResource, 1, 7),
					'V',new ItemStack(ConfigItems.itemResource, 1, 17)
					});
	
	ShapedArcaneRecipe recipeCrimsonBoots = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSON",
			   new ItemStack(ConfigItems.itemBootsCultist), 
			   (new AspectList()).add(Aspect.EARTH, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"R R",
					"R R",
					'R',new ItemStack(ItemHandler.itemResourceFabric)
					});
	 
	 new ResearchItem("TD.CRIMSON", "DYES", 
			  (new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.MAGIC, 4),
			  -2, -1, 2, 
			  new ItemStack(ConfigItems.itemEldritchObject, 1, 1))
			  .setPages(new ResearchPage[]{
					  new ResearchPage("tc.research_page.TD.crimson.1"),
					  new ResearchPage("tc.research_page.TD.crimson.2"),
					  new ResearchPage("tc.research_page.TD.crimson.3"),
					  new ResearchPage(recipeFabricResource),
					  new ResearchPage(recipeCrimsonBoots)
					  })
			  .setParents("CRIMSON", "ENCHFABRIC")
			  .setLost()
			  .setSpecial()
			  .setRound()
			  .setItemTriggers(new ItemStack(ConfigItems.itemEldritchObject, 1, 1))
			  .registerResearchItem();
	 ThaumcraftApi.addWarpToResearch("TD.CRIMSON", 1);
	 
	 
	 /////////////
	 //BANNER
	 
	 ItemStack banner = new ItemStack(ConfigBlocks.blockWoodenDevice,1,8);
	 		//banner.stackTagCompound = new NBTTagCompound();
	 		//banner.stackTagCompound.setByte("color", (byte) -1);
		
	 ItemStack bannerR = new ItemStack(ConfigBlocks.blockWoodenDevice,1,8);
			bannerR.stackTagCompound = new NBTTagCompound();
			bannerR.stackTagCompound.setByte("color", (byte) 14);
	
	 ShapedArcaneRecipe recipeCrimsonBanner = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONBANNER",
			  banner, 
			  (new AspectList()).add(Aspect.ORDER, 5), 
			  new Object[]{
				"g g",
				"gBg",
				"g g",
				'B',bannerR,
				'g',new ItemStack(Items.gold_nugget)
				});
	
	 new ResearchItem("TD.CRIMSONBANNER", "DYES", 
			  (new AspectList()).add(Aspect.CLOTH, 2).add(Aspect.SENSES, 1),
			  -1, -1, 1, 
			  new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 8))
			  .setPages(new ResearchPage[]{
					  new ResearchPage("tc.research_page.TD.crimsonBanner.1"),
					  new ResearchPage(recipeCrimsonBanner)
					  })
			  .setParents("TD.CRIMSON", "BANNERS")
			  .setConcealed()
			  .setSecondary()
			  .registerResearchItem();
		
	 
	 
	 /////////////
	 //CLERIC
	 
	 ShapedArcaneRecipe recipeClericHood = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONCLERIC",
			   new ItemStack(ConfigItems.itemHelmetCultistRobe), 
			   (new AspectList()).add(Aspect.WATER, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"RRR",
					"R R",
					"   ",
					'R',new ItemStack(ItemHandler.itemResourceFabric)
					});
	 
	 ShapedArcaneRecipe recipeClericChest = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONCLERIC",
			   new ItemStack(ConfigItems.itemChestCultistRobe), 
			   (new AspectList()).add(Aspect.WATER, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"R R",
					"RRR",
					"RGR",
					'R',new ItemStack(ItemHandler.itemResourceFabric),
					'G',new ItemStack(Items.gold_ingot)
					});
	 
	 ShapedArcaneRecipe recipeClericLegs = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONCLERIC",
			   new ItemStack(ConfigItems.itemLegsCultistRobe), 
			   (new AspectList()).add(Aspect.WATER, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"RGR",
					"RIR",
					"R R",
					'R',new ItemStack(ItemHandler.itemResourceFabric),
					'I',new ItemStack(Items.iron_ingot),
					'G',new ItemStack(Items.gold_ingot)
					});
	
	
	new ResearchItem("TD.CRIMSONCLERIC", "DYES", 
			  (new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.CLOTH, 4),
			  -5, -2, 1, 
			  new ItemStack(ConfigItems.itemHelmetCultistRobe))
			  .setPages(new ResearchPage[]{
					  new ResearchPage("tc.research_page.TD.crimsonCleric.1"),
					  new ResearchPage(recipeClericHood),
					  new ResearchPage(recipeClericChest),
					  new ResearchPage(recipeClericLegs)
					  })
			  .setParents("TD.CRIMSON")
			  //.setSecondary()
			  .setConcealed()
			  .setLost()
			  .setEntityTriggers("Thaumcraft.CultistCleric")
			  .registerResearchItem();

	/////////////
	//KNIGHT
	     
	ShapedArcaneRecipe recipeKnightHelm = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONKNIGHT",
			   new ItemStack(ConfigItems.itemHelmetCultistPlate), 
			   (new AspectList()).add(Aspect.FIRE, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"III",
					"IGI",
					" R ",
					'R',new ItemStack(ItemHandler.itemResourceFabric),
					'I',new ItemStack(Items.iron_ingot),
					'G',new ItemStack(Items.gold_ingot)
					});
	
	ShapedArcaneRecipe recipeKnightChest = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONKNIGHT",
			   new ItemStack(ConfigItems.itemChestCultistPlate), 
			   (new AspectList()).add(Aspect.FIRE, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"I I",
					"IRI",
					"IRI",
					'R',new ItemStack(ItemHandler.itemResourceFabric),
					'I',new ItemStack(Items.iron_ingot)
					});
	
	ShapedArcaneRecipe recipeKnightLegs = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONKNIGHT",
			   new ItemStack(ConfigItems.itemLegsCultistPlate), 
			   (new AspectList()).add(Aspect.FIRE, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"IGI",
					"IRI",
					"I I",
					'R',new ItemStack(ItemHandler.itemResourceFabric),
					'I',new ItemStack(Items.iron_ingot),
					'G',new ItemStack(Items.gold_ingot)
					});
	
	
	new ResearchItem("TD.CRIMSONKNIGHT", "DYES", 
		  (new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.METAL, 4),
		  -5, -1, 1, 
		  new ItemStack(ConfigItems.itemHelmetCultistPlate))
		  .setPages(new ResearchPage[]{
				  new ResearchPage("tc.research_page.TD.crimsonKnight.1"),
				  new ResearchPage(recipeKnightHelm),
				  new ResearchPage(recipeKnightChest),
				  new ResearchPage(recipeKnightLegs)
				  })
		  .setParents("TD.CRIMSON")
		  //.setSecondary()
		  .setConcealed()
		  .setLost()
		  .setEntityTriggers("Thaumcraft.CultistKnight")
		  .registerResearchItem();
	
	
	/////////////
	//PRAETOR
	
	InfusionRecipe recipeLeaderHelm = ThaumcraftApi.addInfusionCraftingRecipe("TD.CRIMSONLEADER",
			   new ItemStack(ConfigItems.itemHelmetCultistLeaderPlate), 3, 
			   (new AspectList()).add(Aspect.ARMOR, 8).add(Aspect.ELDRITCH, 8).add(Aspect.METAL, 8), 
			   new ItemStack(ConfigItems.itemHelmetCultistPlate), 
			   new ItemStack[]{
		   			new ItemStack(Items.gold_ingot),
		   			new ItemStack(Items.iron_ingot),
		   			new ItemStack(Items.iron_ingot),
		   			new ItemStack(ItemHandler.itemResourceFabric),
		   			new ItemStack(Items.iron_ingot),
		   			new ItemStack(Items.iron_ingot)
		   			});
	   
	   InfusionRecipe recipeLeaderChest = ThaumcraftApi.addInfusionCraftingRecipe("TD.CRIMSONLEADER", 
			   new ItemStack(ConfigItems.itemChestCultistLeaderPlate), 3, 
			   (new AspectList()).add(Aspect.ARMOR, 12).add(Aspect.ELDRITCH, 12).add(Aspect.METAL, 8),  
			   new ItemStack(ConfigItems.itemChestCultistPlate), 
			   new ItemStack[]{
				    new ItemStack(Items.gold_ingot),
		   			new ItemStack(Items.iron_ingot),
		   			new ItemStack(ItemHandler.itemResourceFabric),
		   			new ItemStack(Items.iron_ingot),
		   			new ItemStack(ItemHandler.itemResourceFabric),
		   			new ItemStack(Items.iron_ingot)
				   });
			   
	   InfusionRecipe recipeLeaderLegs = ThaumcraftApi.addInfusionCraftingRecipe("TD.CRIMSONLEADER",
			   new ItemStack(ConfigItems.itemLegsCultistLeaderPlate), 3, 
			   (new AspectList()).add(Aspect.ARMOR, 10).add(Aspect.ELDRITCH, 10).add(Aspect.METAL, 8),  
			   new ItemStack(ConfigItems.itemLegsCultistPlate), 
			   new ItemStack[]{
				    new ItemStack(Items.gold_ingot),
		   			new ItemStack(Items.iron_ingot),
		   			new ItemStack(ItemHandler.itemResourceFabric),
		   			new ItemStack(Items.iron_ingot),
		   			new ItemStack(ItemHandler.itemResourceFabric),
		   			new ItemStack(Items.iron_ingot)
				   });
	
	new ResearchItem("TD.CRIMSONLEADER", "DYES", 
	   		  (new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.METAL, 4).add(Aspect.MAGIC, 4),
	   		  -3, 2, 2, 
	   		  new ItemStack(ConfigItems.itemHelmetCultistLeaderPlate))
	   		  .setPages(new ResearchPage[]{
	   				  new ResearchPage("tc.research_page.TD.crimsonLeader.1"),
	   				  new ResearchPage(recipeLeaderHelm),
	   				  new ResearchPage(recipeLeaderChest),
	   				  new ResearchPage(recipeLeaderLegs)
	   				  })
	   		  .setParents("TD.CRIMSON", "PRIMPEARL")
	   		  .setParentsHidden("TD.CRIMSONCLERIC", "TD.CRIMSONKNIGHT", "TD.CRIMSONRANGER", "TD.CRIMSONARCHER")
	   		  .setConcealed()
	   		  //.setLost()
	   		  //.setEntityTriggers("Thaumcraft.CultistCleric")
	   		  .registerResearchItem();
	
	/////////////
	//PALADIN
	
	ShapedArcaneRecipe recipePaladinHelm = ThaumcraftApi.addArcaneCraftingRecipe("TD.PALADIN",
			   new ItemStack(ItemHandler.itemCultistPaladinHelmet), 
			   (new AspectList()).add(Aspect.FIRE, 20).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 25), 
			   new Object[]{
					" g ",
					"GHG",
					" g ",
					'H',new ItemStack(ConfigItems.itemHelmetCultistLeaderPlate),
					'g',new ItemStack(Items.gold_nugget),
					'G',new ItemStack(Items.gold_ingot)
					});
	
	new ResearchItem("TD.PALADIN", "DYES", 
	   		  (new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.METAL, 4),
	   		  -3, 4, 1, 
	   		  new ItemStack(ItemHandler.itemCultistPaladinHelmet))
	   		  .setPages(new ResearchPage[]{
	   				  new ResearchPage("tc.research_page.TD.paladin.1"),
	   				  new ResearchPage(recipePaladinHelm)
	   				  })
	   		  .setParents("TD.CRIMSONLEADER")
	   		  .setParentsHidden("TD.DYEDPRAETOR")
	   		  //.setSecondary()
	   		  .setConcealed()
	   		  //.setHidden()
	   		  .registerResearchItem();
	
	
	
	/////////////
	//RANGER
	ShapedArcaneRecipe recipeRangerHelm = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONRANGER",
			   new ItemStack(ItemHandler.itemCultistRangerHelmet), 
			   (new AspectList()).add(Aspect.EARTH, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					" I ",
					"IHI",
					" R ",
					'R',new ItemStack(ItemHandler.itemResourceFabric),
					'H',new ItemStack(Items.iron_helmet),
					'I',new ItemStack(Items.iron_ingot)
					});
     
     ShapedArcaneRecipe recipeRangerChest = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONRANGER",
			   new ItemStack(ItemHandler.itemCultistRangerChest), 
			   (new AspectList()).add(Aspect.EARTH, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"c",
					"C",
					"R",
					'C',new ItemStack(ConfigItems.itemChestCultistRobe),
					'c',new ItemStack(Blocks.chest),
					'R',new ItemStack(ItemHandler.itemResourceFabric)
					});
     
     ShapedArcaneRecipe recipeRangerLegs = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONRANGER",
			   new ItemStack(ItemHandler.itemCultistRangerLegs), 
			   (new AspectList()).add(Aspect.EARTH, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"sLs",
					"bBb",
					'B',new ItemStack(Items.blaze_powder),
					'L',new ItemStack(ConfigItems.itemLegsCultistRobe),
					's',new ItemStack(Items.string),
					'b',new ItemStack(Items.glass_bottle)
					});
    

    new ResearchItem("TD.CRIMSONRANGER", "DYES", 
  		  (new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.CLOTH, 4),
  		  -4, -3, 1, 
  		  new ItemStack(ItemHandler.itemCultistRangerChest))
  		  .setPages(new ResearchPage[]{
  				  new ResearchPage("tc.research_page.TD.crimsonRanger.1"),
  				  new ResearchPage(recipeRangerHelm),
  				  new ResearchPage(recipeRangerChest),
  				  new ResearchPage(recipeRangerLegs)
  				  })
  		  .setParents("TD.CRIMSON")
  		  .setParentsHidden("TD.CRIMSONCLERIC")
  		  //.setSecondary()
  		  .setConcealed()
  		  .registerResearchItem();
	
	
	/////////////
	//ARCHER
    ShapedArcaneRecipe recipeArcherHelm = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONARCHER",
			   new ItemStack(ItemHandler.itemCultistArcherHelmet), 
			   (new AspectList()).add(Aspect.AIR, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"IHI",
					" g ",
					'g',new ItemStack(Items.gold_ingot),
					'H',new ItemStack(Items.iron_helmet),
					'I',new ItemStack(Items.iron_ingot)
					});
     
     ShapedArcaneRecipe recipeArcherChest = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONARCHER",
			   new ItemStack(ItemHandler.itemCultistArcherChest), 
			   (new AspectList()).add(Aspect.AIR, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"I I",
					"RIR",
					"IlI",
					'R',new ItemStack(ItemHandler.itemResourceFabric),
					'C',new ItemStack(ConfigItems.itemChestCultistRobe),
					'I',new ItemStack(Items.iron_ingot),
					'l',new ItemStack(Items.leather)
					});
     
     ShapedArcaneRecipe recipeArcherLegs = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONARCHER",
			   new ItemStack(ItemHandler.itemCultistArcherLegs), 
			   (new AspectList()).add(Aspect.AIR, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"ILI",
					" R ",
					'R',new ItemStack(ItemHandler.itemResourceFabric),
					'L',new ItemStack(ConfigItems.itemLegsCultistPlate),
					'I',new ItemStack(Items.iron_ingot)
					});
    

    new ResearchItem("TD.CRIMSONARCHER", "DYES", 
  		  (new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.CLOTH, 4),
  		  -5, 0, 1, 
  		  new ItemStack(ItemHandler.itemCultistArcherHelmet))
  		  .setPages(new ResearchPage[]{
  				  new ResearchPage("tc.research_page.TD.crimsonArcher.1"),
  				  new ResearchPage(recipeArcherHelm),
  				  new ResearchPage(recipeArcherChest),
  				  new ResearchPage(recipeArcherLegs)
  				  })
  		  .setParents("TD.CRIMSON")
  		  .setParentsHidden("TD.CRIMSONKNIGHT")
  		  //.setSecondary()
  		  .setConcealed()
  		  .registerResearchItem();
	   
   }
	   
   //TODO Dyed crimson	
   public static void researchCrimsonDyed() {
	   
			/////////////
			//Cleric
		  InfusionRecipe recipeRobeHelm = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDROBE",
				   new ItemStack(ItemHandler.itemCultistRobeHelmetDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 8).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 16).add(Aspect.METAL, 8), 
				   new ItemStack(ConfigItems.itemHelmetCultistRobe),
				   new ItemStack[]{
			   			new ItemStack(ConfigItems.itemResource,1, 14),
			   			new ItemStack(ConfigItems.itemResource,1, 7), 
			   			new ItemStack(ConfigItems.itemResource,1, 2), 
			   			new ItemStack(ConfigItems.itemResource,1, 7)});
		  
		  InfusionRecipe recipeRobeChest = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDROBE", 
				   new ItemStack(ItemHandler.itemCultistRobeChestDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 12).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 24).add(Aspect.METAL, 8),  
				   new ItemStack(ConfigItems.itemChestCultistRobe),
				   new ItemStack[]{
					   new ItemStack(ConfigItems.itemResource,1, 14),
					   new ItemStack(ConfigItems.itemResource,1, 7),
					   new ItemStack(ConfigItems.itemResource,1, 2),
					   new ItemStack(ConfigItems.itemResource,1, 7)});
				   
		  InfusionRecipe recipeRobeLegs = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDROBE",
				   new ItemStack(ItemHandler.itemCultistRobeLegsDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 10).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 20).add(Aspect.METAL, 8),  
				   new ItemStack(ConfigItems.itemLegsCultistRobe), 
				   new ItemStack[]{
					   new ItemStack(ConfigItems.itemResource,1, 14), 
					   new ItemStack(ConfigItems.itemResource,1, 7), 
					   new ItemStack(ConfigItems.itemResource,1, 2), 
					   new ItemStack(ConfigItems.itemResource,1, 7)});
		
		 new ResearchItem("TD.DYEDROBE", "DYES", 
				  (new AspectList()).add(Aspect.CLOTH, 4).add(Aspect.ARMOR, 4).add(Aspect.MAGIC, 4),
				  -7, -3, 2, 
				  new ItemStack(ItemHandler.itemCultistRobeHelmetDyed, 0))
				  .setPages(new ResearchPage[]{
						  new ResearchPage("tc.research_page.TD.robe.1"), 
						  new ResearchPage("tc.research_page.TD.robe.2"), 
						  new ResearchPage(recipeRobeHelm), 
						  new ResearchPage(recipeRobeChest), 
						  new ResearchPage(recipeRobeLegs)})
				  .setParents("TD.CRIMSONCLERIC")
				  .setConcealed()
				  .setSecondary()
				  .registerResearchItem();
		 
		 
			/////////////
			//KNGIHT
		 InfusionRecipe recipeKniHelm = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDKNIGHT",
				   new ItemStack(ItemHandler.itemCultistKnightHelmetDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
				   new ItemStack(ConfigItems.itemHelmetCultistPlate),
				   new ItemStack[]{
			   			new ItemStack(ConfigItems.itemResource,1, 7), 
			   			new ItemStack(ConfigItems.itemResource,1, 2), 
			   			new ItemStack(ConfigItems.itemResource,1, 7), 
			   			new ItemStack(ConfigItems.itemResource,1, 2)});
		 	
		 InfusionRecipe recipeKniChest = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDKNIGHT",
				   new ItemStack(ItemHandler.itemCultistKnightChestDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
				   new ItemStack(ConfigItems.itemChestCultistPlate),
				   new ItemStack[]{
			   			new ItemStack(ConfigItems.itemResource,1, 7), 
			   			new ItemStack(ConfigItems.itemResource,1, 2), 
			   			new ItemStack(ConfigItems.itemResource,1, 7), 
			   			new ItemStack(ConfigItems.itemResource,1, 2)});
		   
		 InfusionRecipe recipeKniLegs = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDKNIGHT",
				   new ItemStack(ItemHandler.itemCultistKnightLegsDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 20).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
				   new ItemStack(ConfigItems.itemLegsCultistPlate),
				   new ItemStack[]{
			   			new ItemStack(ConfigItems.itemResource,1, 7), 
			   			new ItemStack(ConfigItems.itemResource,1, 2), 
			   			new ItemStack(ConfigItems.itemResource,1, 7), 
			   			new ItemStack(ConfigItems.itemResource,1, 2)});
		 
		 new ResearchItem("TD.DYEDKNIGHT", "DYES", 
				  (new AspectList()).add(Aspect.CLOTH, 4).add(Aspect.ARMOR, 4).add(Aspect.MAGIC, 4),
				  -7, -1, 2, 
				  new ItemStack(ItemHandler.itemCultistKnightChestDyed))
				  .setPages(new ResearchPage[]{
						  new ResearchPage("tc.research_page.TD.knight.1"), 
						  new ResearchPage(recipeKniHelm), 
						  new ResearchPage(recipeKniChest), 
						  new ResearchPage(recipeKniLegs)})
				  .setParents("TD.CRIMSONKNIGHT")
				  .setConcealed()
				  .setSecondary()
				  .registerResearchItem();
		 
		 
			/////////////
			//PRAETOR
		 InfusionRecipe recipePraeHelm = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDPRAETOR", 
				   new ItemStack(ItemHandler.itemCultistLeaderHelmetDyed), 5, 
				   (new AspectList()).add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
				   new ItemStack(ConfigItems.itemHelmetCultistLeaderPlate), 
				   new ItemStack[]{
			  			new ItemStack(ConfigItems.itemResource,1, 7), 
			  			new ItemStack(ConfigItems.itemResource,1, 2), 
			  			new ItemStack(ConfigItems.itemResource,1, 7), 
			  			new ItemStack(ConfigItems.itemResource,1, 2)});
		 
		 InfusionRecipe recipePraeChest = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDPRAETOR", 
				   new ItemStack(ItemHandler.itemCultistLeaderChestDyed), 5, 
				   (new AspectList()).add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16), 
				   new ItemStack(ConfigItems.itemChestCultistLeaderPlate), 
				   new ItemStack[]{
			  			new ItemStack(ConfigItems.itemResource,1, 7), 
			  			new ItemStack(ConfigItems.itemResource,1, 2), 
			  			new ItemStack(ConfigItems.itemResource,1, 7), 
			  			new ItemStack(ConfigItems.itemResource,1, 2)});
		 
		 InfusionRecipe recipePraeLegs = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDPRAETOR", 
				   new ItemStack(ItemHandler.itemCultistLeaderLegsDyed), 5, 
				   (new AspectList()).add(Aspect.ARMOR, 20).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16), 
				   new ItemStack(ConfigItems.itemLegsCultistLeaderPlate),  
				   new ItemStack[]{
			  			new ItemStack(ConfigItems.itemResource,1, 7), 
			  			new ItemStack(ConfigItems.itemResource,1, 2), 
			  			new ItemStack(ConfigItems.itemResource,1, 7), 
			  			new ItemStack(ConfigItems.itemResource,1, 2)});
		
		 
		 new ResearchItem("TD.DYEDPRAETOR", "DYES", 
				  (new AspectList()).add(Aspect.CLOTH, 5).add(Aspect.ARMOR, 5).add(Aspect.MAGIC, 5).add(Aspect.DARKNESS, 5),
				  -5, 3, 3, 
				  new ItemStack(ItemHandler.itemCultistLeaderChestDyed))
				  .setPages(new ResearchPage[]{
						  new ResearchPage("tc.research_page.TD.praetor.1"), 
						  new ResearchPage(recipePraeHelm), 
						  new ResearchPage(recipePraeChest), 
						  new ResearchPage(recipePraeLegs)})
				  .setParents("TD.CRIMSONLEADER") 
				  .setConcealed()
				  .setSecondary()
				  .registerResearchItem();
		 
		 
			/////////////
			//Ranger
		 InfusionRecipe recipeRangerHelmDyed = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDRANGER",
				   new ItemStack(ItemHandler.itemCultistRangerHelmetDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
				   new ItemStack(ItemHandler.itemCultistRangerHelmet),  
				   new ItemStack[]{
			   			new ItemStack(ConfigItems.itemResource,1, 7), 
			   			new ItemStack(ConfigItems.itemResource,1, 2), 
			   			new ItemStack(ConfigItems.itemResource,1, 7), 
			   			new ItemStack(ConfigItems.itemResource,1, 2)});
			
		InfusionRecipe recipeRangerChestDyed = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDRANGER",
				   new ItemStack(ItemHandler.itemCultistRangerChestDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
				   new ItemStack(ItemHandler.itemCultistRangerChest), 
				   new ItemStack[]{
			   			new ItemStack(ConfigItems.itemResource,1, 14), 
			   			new ItemStack(ConfigItems.itemResource,1, 2), 
			   			new ItemStack(ConfigItems.itemResource,1, 7), 
			   			new ItemStack(ConfigItems.itemResource,1, 2)});
		  
		InfusionRecipe recipeRangerLegsDyed = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDRANGER",
				   new ItemStack(ItemHandler.itemCultistRangerLegsDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 20).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
				   new ItemStack(ItemHandler.itemCultistRangerLegs),  
				   new ItemStack[]{
			   			new ItemStack(ConfigItems.itemResource,1, 14), 
			   			new ItemStack(ConfigItems.itemResource,1, 2), 
			   			new ItemStack(ConfigItems.itemResource,1, 7), 
			   			new ItemStack(ConfigItems.itemResource,1, 2)});
		  
			InfusionRecipe recipeRangerHelmGoggles = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDRANGER", new Object[] { "mask", new NBTTagInt(0) }, 3, 
					  new AspectList().add(Aspect.SENSES, 16).add(Aspect.AURA, 8).add(Aspect.ARMOR, 8), 
					  new ItemStack(ItemHandler.itemCultistRangerHelmetDyed, 1, 32767), 
				      new ItemStack[] { 
						  new ItemStack(Items.slime_ball), 
				    	  new ItemStack(ConfigItems.itemGoggles, 1, 32767) });
			  
			InfusionRecipe recipeRangerHelmPlate = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDRANGER", new Object[] { "mask", new NBTTagInt(1) }, 2, 
					  new AspectList().add(Aspect.CRAFT, 8).add(Aspect.ARMOR, 8), 
					  new ItemStack(ItemHandler.itemCultistRangerHelmetDyed, 1, 32767), 
				      new ItemStack[] { 
				    	  new ItemStack(Items.slime_ball), 
				    	  new ItemStack(ConfigItems.itemResource,1, 2) });
		 
		 new ResearchItem("TD.DYEDRANGER", "DYES", 
				  (new AspectList()).add(Aspect.CLOTH, 4).add(Aspect.ARMOR, 4).add(Aspect.MAGIC, 4).add(Aspect.TRAVEL, 4),
				  -5, -5, 2, 
				  new ItemStack(ItemHandler.itemCultistRangerChestDyed))
				  .setPages(new ResearchPage[]{
						  new ResearchPage("tc.research_page.TD.ranger.1"),
						  new ResearchPage(recipeRangerHelmDyed),
						  new ResearchPage(recipeRangerChestDyed),
						  new ResearchPage(recipeRangerLegsDyed),
						  new ResearchPage("tc.research_page.TD.ranger.2"),
						  new ResearchPage(recipeRangerHelmGoggles),
						  new ResearchPage(recipeRangerHelmPlate)
				  			})
				  .setParents("TD.CRIMSONRANGER")
				  .setConcealed()
				  .setSecondary()
				  .registerResearchItem();
		 
		 
			/////////////
			//ARCHER
		 
		 InfusionRecipe recipeArcherHelmDyed = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDARCHER", 
				   new ItemStack(ItemHandler.itemCultistArcherHelmetDyed), 5, 
				   (new AspectList()).add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
				   new ItemStack(ItemHandler.itemCultistArcherHelmet), 
				   new ItemStack[]{
			  			new ItemStack(ConfigItems.itemResource,1, 7), 
			  			new ItemStack(ConfigItems.itemResource,1, 2), 
			  			new ItemStack(ConfigItems.itemResource,1, 7), 
			  			new ItemStack(ConfigItems.itemResource,1, 2)});
		 
		InfusionRecipe recipeArcherChestDyed = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDARCHER", 
				   new ItemStack(ItemHandler.itemCultistArcherChestDyed), 5, 
				   (new AspectList()).add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16), 
				   new ItemStack(ItemHandler.itemCultistArcherChest), 
				   new ItemStack[]{
			  			new ItemStack(ConfigItems.itemResource,1, 7), 
			  			new ItemStack(ConfigItems.itemResource,1, 2), 
			  			new ItemStack(ConfigItems.itemResource,1, 7), 
			  			new ItemStack(ConfigItems.itemResource,1, 2)});
		 
		InfusionRecipe recipeArcherLegsDyed = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDARCHER", 
				   new ItemStack(ItemHandler.itemCultistArcherLegsDyed), 5, 
				   (new AspectList()).add(Aspect.ARMOR, 20).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16), 
				   new ItemStack(ItemHandler.itemCultistArcherLegs), 
				   new ItemStack[]{
			  			new ItemStack(ConfigItems.itemResource,1, 7), 
			  			new ItemStack(ConfigItems.itemResource,1, 2), 
			  			new ItemStack(ConfigItems.itemResource,1, 7), 
			  			new ItemStack(ConfigItems.itemResource,1, 2)});
		 
		 new ResearchItem("TD.DYEDARCHER", "DYES", 
				  (new AspectList()).add(Aspect.CLOTH, 5).add(Aspect.ARMOR, 5).add(Aspect.MAGIC, 5).add(Aspect.WEAPON, 5),
				  -7, 1, 2, 
				  new ItemStack(ItemHandler.itemCultistArcherHelmetDyed))
				  .setPages(new ResearchPage[]{
						  new ResearchPage("tc.research_page.TD.archer.1"), 
						  new ResearchPage(recipeArcherHelmDyed), 
						  new ResearchPage(recipeArcherChestDyed), 
						  new ResearchPage(recipeArcherLegsDyed)
						  })
				  .setParents("TD.CRIMSONARCHER") 
				  .setConcealed()
				  .setSecondary()
				  .registerResearchItem();
		 
		 
		 
		 //Shitposting
		 
			/////////////
			//SUNKNIGHT
		 
		 ShapedArcaneRecipe recipeSunKniHelm = ThaumcraftApi.addArcaneCraftingRecipe("TD.SUNNYD",
				   new ItemStack(ItemHandler.itemSunKnightHelmet), 
				   (new AspectList()).add(Aspect.FIRE, 20).add(Aspect.AIR, 20), 
				   new Object[]{
						" g ",
						"nHn",
						" g ",
						'H',new ItemStack(ItemHandler.itemCultistKnightHelmetDyed),
						'g',new ItemStack(Items.dye, 1, 8),
						'n', "nuggetIron"
						});
		
		ShapedArcaneRecipe recipeSunKniChest = ThaumcraftApi.addArcaneCraftingRecipe("TD.SUNNYD",
				   new ItemStack(ItemHandler.itemSunKnightChest), 
				   (new AspectList()).add(Aspect.FIRE, 20).add(Aspect.AIR, 20),
				   new Object[]{
						"nrn",
						"rCr",
						"nyn",
						'C',new ItemStack(ItemHandler.itemCultistKnightChestDyed),
						'r',new ItemStack(Items.dye, 1, 1),
						'y',new ItemStack(Items.dye, 1, 11),
						'n', "nuggetIron"
						});
		 
		 new ResearchItem("TD.SUNNYD", "DYES", 
				  (new AspectList()).add(Aspect.FIRE, 4).add(Aspect.ARMOR, 4).add(Aspect.AURA, 4),
				  0, -3, 1, 
				  new ItemStack(ItemHandler.itemSunKnightChest))
				  .setPages(new ResearchPage[]{
						  new ResearchPage("tc.research_page.TD.sunnyD.1"), 
						  new ResearchPage(recipeSunKniHelm), 
						  new ResearchPage(recipeSunKniChest)
						  })
				  .setParentsHidden("TD.DYEDKNIGHT")
				  .setConcealed()
				  .registerResearchItem();
	   
   }
      
   //TODO Eldritch
   public static void researchEldritch() {
    	  
    	  copy(ResearchCategories.getResearchList("ELDRITCH").research.get("ENTEROUTER"),"TD.OUTERARRIVAL","DYES",-2,6).setConcealed().setHidden().registerResearchItem();
          
          //Husk Armour
          InfusionRecipe recipeHuskHelm = ThaumcraftApi.addInfusionCraftingRecipe("TD.INHABITEDPLATE",
    			   new ItemStack(ItemHandler.itemInhabitedPlateHelmet), 3, 
    			   (new AspectList()).add(Aspect.ENTROPY, 16).add(Aspect.ELDRITCH, 16).add(Aspect.METAL, 16).add(Aspect.ARMOR, 16), 
    			   new ItemStack(ConfigItems.itemHelmetCultistPlate), 
    			   new ItemStack[]{
    		   			ItemApi.getItem("itemShard", 5), 
    		   			new ItemStack(Items.iron_ingot), 
    		   			new ItemStack(ConfigItems.itemResource,1, 17)});
         	
          InfusionRecipe recipeHuskChest = ThaumcraftApi.addInfusionCraftingRecipe("TD.INHABITEDPLATE",
    			   new ItemStack(ItemHandler.itemInhabitedPlateChest), 3, 
    			   (new AspectList()).add(Aspect.ENTROPY, 16).add(Aspect.ELDRITCH, 24).add(Aspect.METAL, 24).add(Aspect.ARMOR, 24), 
    			   new ItemStack(ConfigItems.itemChestCultistPlate),  
    			   new ItemStack[]{
        	 			ItemApi.getItem("itemShard", 5), 
        	 			new ItemStack(Items.iron_ingot), 
        	 			new ItemStack(Items.iron_ingot),
        	 			new ItemStack(ConfigItems.itemResource,1, 17),
        	 			new ItemStack(ConfigItems.itemResource,1, 17)});
    	   
          InfusionRecipe recipeHuskLegs = ThaumcraftApi.addInfusionCraftingRecipe("TD.INHABITEDPLATE",
    			   new ItemStack(ItemHandler.itemInhabitedPlateLegs), 3, 
    			   (new AspectList()).add(Aspect.ENTROPY, 16).add(Aspect.ELDRITCH, 20).add(Aspect.METAL, 20).add(Aspect.ARMOR, 20), 
    			   new ItemStack(ConfigItems.itemLegsCultistPlate),  
    			   new ItemStack[]{
        	 			ItemApi.getItem("itemShard", 5), 
        	 			new ItemStack(Items.iron_ingot), 
        	 			new ItemStack(Items.iron_ingot),
        	 			new ItemStack(ConfigItems.itemResource,1, 17)});
          
          new ResearchItem("TD.INHABITEDPLATE", "DYES", 
    		  (new AspectList()).add(Aspect.ENTROPY, 4).add(Aspect.EXCHANGE, 4).add(Aspect.ELDRITCH, 4),
              -4, 6, 2, 
    		  new ItemStack(ItemHandler.itemInhabitedPlateHelmet, 0))
    		  .setPages(new ResearchPage[]{
    				  new ResearchPage("tc.research_page.TD.husk.1"), 
    				  new ResearchPage("tc.research_page.TD.husk.2"),
    				  new ResearchPage(recipeHuskHelm), 
    				  new ResearchPage(recipeHuskChest), 
    				  new ResearchPage(recipeHuskLegs)})
    		  .setParents(/*"DYEDKNIGHT",*/ "TD.OUTERARRIVAL")
    		  //.setConcealed()
    		  .registerResearchItem();
          ThaumcraftApi.addWarpToResearch("TD.INHABITEDPLATE", 2);
          
          
          
          //Mask of Cruelty
          ShapedArcaneRecipe recipeMaskEvil = ThaumcraftApi.addArcaneCraftingRecipe("TD.MASKEVIL",
				   new ItemStack(ItemHandler.itemHelmetMaskTX), 
				   (new AspectList()).add(Aspect.ENTROPY, 60).add(Aspect.FIRE, 40).add(Aspect.AIR, 40),
				   new Object[]{
						"LVL",
						"L L",
						"EVE",
						'E',new ItemStack(ConfigItems.itemEldritchObject,1,0),
						'V',new ItemStack(ConfigItems.itemResource,1,16),
						'L',new ItemStack(Items.leather)
						});
         
         new ResearchItem("TD.MASKEVIL", "DYES", 
   		  (new AspectList()).add(Aspect.ENTROPY, 4).add(Aspect.WEAPON, 4).add(Aspect.ELDRITCH, 4),
             0, 7, 2, 
   		  new ItemStack(ItemHandler.itemHelmetMaskTX, 0))
   		  .setPages(new ResearchPage[]{
   				  new ResearchPage("tc.research_page.TD.maskEvil.1"), 
   				  new ResearchPage(recipeMaskEvil)})
   		  .setParents( "VOIDMETAL")
   		  //.setConcealed()
   		  .registerResearchItem();
         ThaumcraftApi.addWarpToResearch("TD.MASKEVIL", 2);
         
          
          
      }
      
   //TODO IRON TIER
   public static void researchIron () {
	   
		/////////////
		//Iron Fortress
	    InfusionRecipe recipeIronFortHelm = ThaumcraftApi.addInfusionCraftingRecipe("TD.IRONFORTRESS", 
				new ItemStack(ItemHandler.itemIronFortressHelmet), 1, 
				(new AspectList()).add(Aspect.ARMOR, 8).add(Aspect.METAL, 8).add(Aspect.CRAFT, 8), 
				   new ItemStack(Items.iron_helmet, 0), 
				   new ItemStack[]{
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.gold_ingot, 0),
					   new ItemStack(Items.diamond, 0),
					   });
				   
	    InfusionRecipe recipeIronFortChest = ThaumcraftApi.addInfusionCraftingRecipe("TD.IRONFORTRESS", 
				new ItemStack(ItemHandler.itemIronFortressChest), 1, 
				(new AspectList()).add(Aspect.ARMOR, 8).add(Aspect.METAL, 8).add(Aspect.CRAFT, 8), 
				   new ItemStack(Items.iron_chestplate, 0), 
				   new ItemStack[]{
			    	   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.gold_ingot, 0),
					   new ItemStack(Items.leather, 0)
			   			});
		   
	    InfusionRecipe recipeIronFortLegs = ThaumcraftApi.addInfusionCraftingRecipe("TD.IRONFORTRESS", 
				new ItemStack(ItemHandler.itemIronFortressLegs), 1, 
				(new AspectList()).add(Aspect.ARMOR, 8).add(Aspect.METAL, 8).add(Aspect.CRAFT, 8), 
				   new ItemStack(Items.iron_leggings, 0), 
				   new ItemStack[]{
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.gold_ingot, 0),
					   new ItemStack(Items.leather, 0)
			   			});
	          
	    new ResearchItem("TD.IRONFORTRESS", "DYES", 
	  		  (new AspectList()).add(Aspect.ARMOR, 5).add(Aspect.METAL, 5).add(Aspect.CRAFT, 5),
	  		  9, -1, 2, 
	  		  new ItemStack(ItemHandler.itemIronFortressHelmet, 0))
	    		  .setPages(new ResearchPage[]{
	  				  new ResearchPage("tc.research_page.TD.ironFortress.1"),
	  				  new ResearchPage("tc.research_page.TD.ironFortress.2"), 
	  				  new ResearchPage(recipeIronFortHelm), 
	  				  new ResearchPage(recipeIronFortChest), 
	  				  new ResearchPage(recipeIronFortLegs)
	  				  })
				  .setParents("TD.ARMORFORTRESS")
				  .setSecondary()
				  //.setConcealed()
				  .registerResearchItem();
			
			
		/////////////
		//Faceplates
		InfusionRecipe recipeIronFortHelmGoggles = ThaumcraftApi.addInfusionCraftingRecipe("TD.IRONHELMGOGGLES", new Object[] { "goggles", new NBTTagByte((byte) 1) }, 5, 
				  new AspectList().add(Aspect.SENSES, 32).add(Aspect.AURA, 16).add(Aspect.ARMOR, 16), 
				  new ItemStack(ItemHandler.itemIronFortressHelmet, 1, 32767), 
			      new ItemStack[] { 
			    	  new ItemStack(Items.slime_ball), 
			    	  new ItemStack(ConfigItems.itemGoggles, 1, 32767) });
		  
		InfusionRecipe recipeIronFortHelmKnight = ThaumcraftApi.addInfusionCraftingRecipe("TD.IRONHELMAESTHETICS", new Object[] { "mask", new NBTTagInt(0) }, 2, 
				  new AspectList().add(Aspect.CRAFT, 8).add(Aspect.ARMOR, 8), 
				  new ItemStack(ItemHandler.itemIronFortressHelmet, 1, 32767), 
			      new ItemStack[] { 
			    	  new ItemStack(Items.slime_ball), 
			    	  new ItemStack(ConfigItems.itemHelmetCultistPlate, 32767) });
		  
		InfusionRecipe recipeIronFortHelmPraetor = ThaumcraftApi.addInfusionCraftingRecipe("TD.IRONHELMAESTHETICS", new Object[] { "mask", new NBTTagInt(1) }, 2, 
				  new AspectList().add(Aspect.CRAFT, 8).add(Aspect.ARMOR, 8), 
				  new ItemStack(ItemHandler.itemIronFortressHelmet, 1, 32767), 
			      new ItemStack[] { 
			    	  new ItemStack(Items.slime_ball), 
			    	  new ItemStack(ConfigItems.itemHelmetCultistLeaderPlate, 32767) });
			
		new ResearchItem("TD.IRONHELMGOGGLES", "DYES", 
				new AspectList().add(Aspect.SENSES, 5).add(Aspect.AURA, 3).add(Aspect.ARMOR, 3), 
				11, -1, 1, 
				new ItemStack(ConfigItems.itemGoggles))
	    		  .setPages(new ResearchPage[]{
	  				  new ResearchPage("tc.research_page.TD.ironHelmGoggles.1"),
	  				  new ResearchPage(recipeIronFortHelmGoggles)})
				  .setParents("TD.IRONFORTRESS", "GOGGLES")
				  .setSecondary()
				  .setConcealed()
				  .registerResearchItem();	
		
		new ResearchItem("TD.IRONHELMAESTHETICS", "DYES", 
				new AspectList().add(Aspect.CRAFT, 5).add(Aspect.ARMOR, 3), 
				11, 0, 1, 
				new ItemStack(ConfigItems.itemHelmetCultistPlate))
	    		  .setPages(new ResearchPage[]{
	  				  new ResearchPage("tc.research_page.TD.ironHelmFace.1"),
	  				  new ResearchPage(recipeIronFortHelmKnight),
	  				  new ResearchPage(recipeIronFortHelmPraetor)
	  				  })
				  .setParents("TD.IRONFORTRESS")
				  .setSecondary()
				  .setConcealed()
				  .registerResearchItem();
		
		InfusionRecipe recipeIronFortHelmHusk = ThaumcraftApi.addInfusionCraftingRecipe("TD.IRONHELMHUSK", 
				new Object[] { "mask", new NBTTagInt(2) }, 2, 
				  new AspectList().add(Aspect.CRAFT, 8).add(Aspect.ARMOR, 8).add(Aspect.ELDRITCH, 4).add(Aspect.EXCHANGE, 4), 
				  new ItemStack(ItemHandler.itemIronFortressHelmet, 1, 32767), 
			      new ItemStack[] { 
			    	  new ItemStack(Items.slime_ball), 
			    	  new ItemStack(ItemHandler.itemInhabitedPlateHelmet, 0),
			    	  });
		
		new ResearchItem("TD.IRONHELMHUSK", "DYES", 
				new AspectList().add(Aspect.CRAFT, 5).add(Aspect.ARMOR, 3).add(Aspect.ELDRITCH, 2), 
				10, 1, 1, 
				new ItemStack(ItemHandler.itemInhabitedPlateHelmet))
	    		  .setPages(new ResearchPage[]{
	  				  new ResearchPage("tc.research_page.TD.ironHelmFace.2"),
	   				  new ResearchPage(recipeIronFortHelmHusk)})
				  .setParents("TD.IRONFORTRESS")
				  .setParentsHidden("TD.INHABITEDPLATE", "TD.IRONHELMAESTHETICS")
				  .setSecondary()
				  .setConcealed()
				  .registerResearchItem();   
	   
   }   
      	  
   //TODO THAUMIUM TIER
   public static void researchThaumium() {
	   
		copy(ResearchCategories.getResearchList("ALCHEMY").research.get("THAUMIUM"),"TD.THAUMIUM","DYES",2,-1).setConcealed().setHidden().registerResearchItem();
		copy(ResearchCategories.getResearchList("ARTIFICE").research.get("ARMORFORTRESS"),"TD.ARMORFORTRESS","DYES",7,-2	).setConcealed().setHidden().registerResearchItem();
		
		/////////////
		//Thaumium Fortress
     InfusionRecipe recipeFortHelm = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDFORTRESS", 
			   new ItemStack(ItemHandler.itemFortressHelmetDyed), 5, 
			   (new AspectList()).add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16), 
			   new ItemStack(ConfigItems.itemHelmetFortress), 
			   new ItemStack[]{
				   new ItemStack(ConfigItems.itemResource,1, 2), 
				   new ItemStack(ConfigItems.itemResource,1, 2), 
				   new ItemStack(ConfigItems.itemResource,1, 7), 
				   new ItemStack(ConfigItems.itemResource,1, 2)});
			   
     InfusionRecipe recipeFortChest = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDFORTRESS", 
			   new ItemStack(ItemHandler.itemFortressChestDyed), 5, 
			   (new AspectList()).add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16), 
			   new ItemStack(ConfigItems.itemChestFortress), 
			   new ItemStack[]{
		   			new ItemStack(ConfigItems.itemResource,1, 2), 
		   			new ItemStack(ConfigItems.itemResource,1, 2), 
		   			new ItemStack(ConfigItems.itemResource,1, 7), 
		   			new ItemStack(ConfigItems.itemResource,1, 2)});
	   
     InfusionRecipe recipeFortLegs = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDFORTRESS", 
			   new ItemStack(ItemHandler.itemFortressLegsDyed), 5, 
			   (new AspectList()).add(Aspect.ARMOR, 20).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
			   new ItemStack(ConfigItems.itemLegsFortress), 
			   new ItemStack[]{
		   			new ItemStack(ConfigItems.itemResource,1, 2), 
		   			new ItemStack(ConfigItems.itemResource,1, 2), 
		   			new ItemStack(ConfigItems.itemResource,1, 7), 
		   			new ItemStack(ConfigItems.itemResource,1, 2)});

     
     new ResearchItem("TD.DYEDFORTRESS", "DYES", 
   		  (new AspectList()).add(Aspect.CLOTH, 5).add(Aspect.ARMOR, 5).add(Aspect.MAGIC, 5),
   		  5, -2, 2, 
   		  new ItemStack(ItemHandler.itemFortressHelmetDyed, 0))
   		  .setPages(new ResearchPage[]{
   				  new ResearchPage("tc.research_page.TD.fortress.1"), 
   				  new ResearchPage(recipeFortHelm), 
   				  new ResearchPage(recipeFortChest), 
   				  new ResearchPage(recipeFortLegs)})
			  .setParents("TD.THAUMIUM","TD.ARMORFORTRESS")
			  .setConcealed()
			  .registerResearchItem();
     
     
		  /////////////
		  //Thaumium Robes				   
	    InfusionRecipe recipeThaumRobeHelm = ThaumcraftApi.addInfusionCraftingRecipe("TD.THAUMIUMROBE", 
				new ItemStack(ItemHandler.itemThaumiumRobeHelmetDyed), 4, 
				new AspectList().add(Aspect.METAL, 16).add(Aspect.SENSES, 16).add(Aspect.ARMOR, 16).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 16), 
				new ItemStack(ConfigItems.itemHelmetThaumium), 
				new ItemStack[] { 
	    			new ItemStack(ConfigItems.itemGoggles), 
	    			new ItemStack(ConfigItems.itemResource, 1, 7), 
	    			new ItemStack(ConfigItems.itemResource, 1, 7), 
	    			new ItemStack(ConfigItems.itemResource, 1, 14), 
	    			new ItemStack(ConfigItems.itemResource, 1, 7), 
	    			new ItemStack(ConfigItems.itemResource, 1, 7) });
			    
	    InfusionRecipe recipeThaumRobeChest = ThaumcraftApi.addInfusionCraftingRecipe("TD.THAUMIUMROBE", 
				new ItemStack(ItemHandler.itemThaumiumRobeChestDyed), 4, 
				new AspectList().add(Aspect.METAL, 24).add(Aspect.ARMOR, 24).add(Aspect.CLOTH, 24).add(Aspect.MAGIC, 16), 
				new ItemStack(ConfigItems.itemChestThaumium), 
				new ItemStack[] { 
	    			new ItemStack(ConfigItems.itemChestRobe), 
	    			new ItemStack(ConfigItems.itemResource, 1, 2), 
	    			new ItemStack(ConfigItems.itemResource, 1, 2), 
	    			new ItemStack(ConfigItems.itemResource, 1, 14), 
	    			new ItemStack(ConfigItems.itemResource, 1, 7), 
	    			new ItemStack(Items.leather) });
			    
	    InfusionRecipe recipeThaumRobeLegs = ThaumcraftApi.addInfusionCraftingRecipe("TD.THAUMIUMROBE", 
				new ItemStack(ItemHandler.itemThaumiumRobeLegsDyed), 4, 
				new AspectList().add(Aspect.METAL, 20).add(Aspect.ARMOR, 20).add(Aspect.CLOTH, 20).add(Aspect.MAGIC, 16), 
				new ItemStack(ConfigItems.itemLegsThaumium), 
				new ItemStack[] { 
	    			new ItemStack(ConfigItems.itemLegsRobe), 
	    			new ItemStack(ConfigItems.itemResource,1, 2), 
	    			new ItemStack(ConfigItems.itemResource,1, 2), 
	    			new ItemStack(ConfigItems.itemResource,1, 14), 
	    			new ItemStack(ConfigItems.itemResource,1, 7), 
	    			new ItemStack(Items.leather) });
				            
	      new ResearchItem("TD.THAUMIUMROBE", "DYES", 
	    		  (new AspectList()).add(Aspect.ARMOR, 5).add(Aspect.CLOTH, 5).add(Aspect.CRAFT, 5),
	    		  3, -4, 2, 
	    		  new ItemStack(ItemHandler.itemThaumiumRobeChestDyed, 0))
	      		  .setPages(new ResearchPage[]{
	    				  new ResearchPage("tc.research_page.TD.thaumrobe.1"),
	    				  new ResearchPage(recipeThaumRobeHelm), 
	    				  new ResearchPage(recipeThaumRobeChest), 
	    				  new ResearchPage(recipeThaumRobeLegs)})
				  .setParents("TD.THAUMIUM", "GOGGLES", "ENCHFABRIC")
				  .registerResearchItem(); 
	   
   }   
	     
   //TODO VOID TIER
   public static void researchVoid() {
	   
	      copy(ResearchCategories.getResearchList("ELDRITCH").research.get("ARMORVOIDFORTRESS"),"TD.VOIDFORTRESS","DYES",2,6).setConcealed().setHidden().registerResearchItem();
	      
		  /////////////
		  //Void Robes
		CrucibleRecipe recipeVoidRobeHelm = ThaumcraftApi.addCrucibleRecipe("TD.VOIDROBE", 
				new ItemStack(ItemHandler.itemVoidRobeHelmetDyed), 
				new ItemStack(ConfigItems.itemHelmetVoidRobe), 
				(new AspectList()).add(Aspect.CLOTH, 8).add(Aspect.ENTROPY, 4).add(Aspect.EXCHANGE, 8));
				   
		CrucibleRecipe recipeVoidRobeChest = ThaumcraftApi.addCrucibleRecipe("TD.VOIDROBE", 
				new ItemStack(ItemHandler.itemVoidRobeChestDyed), 
				new ItemStack(ConfigItems.itemChestVoidRobe), 
				(new AspectList()).add(Aspect.CLOTH, 8).add(Aspect.ENTROPY, 4).add(Aspect.EXCHANGE, 8));
		
		CrucibleRecipe recipeVoidRobeLegs = ThaumcraftApi.addCrucibleRecipe("TD.VOIDROBE", 
				new ItemStack(ItemHandler.itemVoidRobeLegsDyed), 
				new ItemStack(ConfigItems.itemLegsVoidRobe), 
				(new AspectList()).add(Aspect.CLOTH, 8).add(Aspect.ENTROPY, 4).add(Aspect.EXCHANGE, 8));
	          
	   new ResearchItem("TD.VOIDROBE", "DYES", 
	  		  (new AspectList()).add(Aspect.ARMOR, 5).add(Aspect.METAL, 5).add(Aspect.CRAFT, 5),
	  		  4, 6, 2, 
	  		  new ItemStack(ItemHandler.itemVoidRobeHelmetDyed, 0))
	    		  .setPages(new ResearchPage[]{
	  				  new ResearchPage("tc.research_page.TD.voidrobe.1"),
	  				  new ResearchPage(recipeVoidRobeHelm),
	  				  new ResearchPage(recipeVoidRobeChest),
	  				  new ResearchPage(recipeVoidRobeLegs),
	    		  			})
				  .setParents("TD.VOIDFORTRESS")
				  .setSecondary()
				  .setConcealed()
				  .registerResearchItem();
	   
   }
	      
   //TODO boots
   public static void researchBoots() {
	   
	      copy(ResearchCategories.getResearchList("ARTIFICE").research.get("BOOTSTRAVELLER"),"TD.BOOTSTRAVELLER","DYES",4,2).setConcealed().setHidden().registerResearchItem();
	      
		  /////////////
		  //Thaumium boots
	      InfusionRecipe recipeThaumBoots = ThaumcraftApi.addInfusionCraftingRecipe("TD.THAUMIUMBOOTS", 
					new ItemStack(ItemHandler.itemThaumiumBootsTraveller), 4, 
					new AspectList().add(Aspect.METAL, 16).add(Aspect.ARMOR, 16).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 16).add(Aspect.TRAVEL, 8), 
					new ItemStack(ConfigItems.itemBootsTraveller), 
					new ItemStack[] { 
	    	  			new ItemStack(Items.leather), 
		    			new ItemStack(ConfigItems.itemResource, 1, 2), 
		    			new ItemStack(ConfigItems.itemResource, 1, 2), 
		    			new ItemStack(ConfigItems.itemResource, 1, 14), 
		    			new ItemStack(ConfigItems.itemResource, 1, 7), 
		    			new ItemStack(ConfigItems.itemResource, 1, 7)});
	      
	      new ResearchItem("TD.THAUMIUMBOOTS", "DYES", 
	    		  (new AspectList()).add(Aspect.ARMOR, 5).add(Aspect.CLOTH, 5).add(Aspect.TRAVEL, 5),
	    		  2, 1, 2, 
	    		  new ItemStack(ItemHandler.itemThaumiumBootsTraveller, 0))
	      		  .setPages(new ResearchPage[]{
	    				  new ResearchPage("tc.research_page.TD.thaumboots.1"),
	    				  new ResearchPage(recipeThaumBoots)})
				  .setParents("TD.THAUMIUM", "TD.BOOTSTRAVELLER")
				  .setConcealed()
				  .registerResearchItem();
	      
		  /////////////
		  //Void boots
	      InfusionRecipe recipeVoidBoots = ThaumcraftApi.addInfusionCraftingRecipe("TD.VOIDBOOTS", 
					new ItemStack(ItemHandler.itemVoidBootsTraveller), 4, 
					new AspectList().add(Aspect.METAL, 16).add(Aspect.ARMOR, 16).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 16).add(Aspect.TRAVEL, 8).add(Aspect.ELDRITCH, 16).add(Aspect.VOID, 8), 
					new ItemStack(ConfigItems.itemBootsTraveller), 
					new ItemStack[] { 
	    	  			new ItemStack(Items.leather), 
		    			new ItemStack(ConfigItems.itemResource, 1, 16), 
		    			new ItemStack(ConfigItems.itemResource, 1, 2), 
		    			new ItemStack(ConfigItems.itemResource, 1, 14), 
		    			new ItemStack(ConfigItems.itemResource, 1, 7), 
		    			new ItemStack(ConfigItems.itemResource, 1, 7)});
	      
	      new ResearchItem("TD.VOIDBOOTS", "DYES", 
	    		  (new AspectList()).add(Aspect.ARMOR, 5).add(Aspect.CLOTH, 5).add(Aspect.TRAVEL, 5).add(Aspect.ELDRITCH, 5),
	    		  2, 4, 2, 
	    		  new ItemStack(ItemHandler.itemVoidBootsTraveller, 0))
	      		  .setPages(new ResearchPage[]{
	    				  new ResearchPage("tc.research_page.TD.voidboots.1"),
	    				  new ResearchPage(recipeVoidBoots)})
				  .setParents("TD.VOIDFORTRESS", "TD.BOOTSTRAVELLER")
				  .setConcealed()
				  .registerResearchItem();  
	   
   }
	      
   //TODO Runic armour
   //AHM BACK, AND AHM IN ME PRIME!
   //But how?
   //CELTIC RUNES, LADDIE!
   public static void researchRunic() {
	      
      /////////////
      //base
      new ResearchItem("TD.RUNICARMOR", "DYES", 
    		  new AspectList().add(Aspect.ARMOR, 8).add(Aspect.AIR, 5).add(Aspect.MAGIC, 5).add(Aspect.ENERGY, 5).add(Aspect.MIND, 3),
    		  8, 3, 3, 
    		  new ItemStack(ItemHandler.itemRunicChest))
      		  .setPages(new ResearchPage[] { 
      				  new ResearchPage("tc.research_page.TD.RUNICARMOR.1"), 
      				  new ResearchPage("tc.research_page.TD.RUNICARMOR.2"), 
      				  new ResearchPage((InfusionRecipe)recipes.get("RunicArmorHelm")), 
      				  new ResearchPage((InfusionRecipe)recipes.get("RunicArmorChest")), 
      				  new ResearchPage((InfusionRecipe)recipes.get("RunicArmorLegs")), 
      				  new ResearchPage((InfusionRecipe)recipes.get("RunicArmorBoots")) 
      				  })
			  .setParents("INFUSION", "RUNICARMOR")
			  .setConcealed()
			  .setSpecial()
			  .registerResearchItem();
      
      /////////////
      //goggles+boots
      new ResearchItem("TD.RUNICGOGGLES", "DYES", 
    		  new AspectList().add(Aspect.SENSES, 8).add(Aspect.MAGIC, 5).add(Aspect.ARMOR, 5).add(Aspect.AURA, 3),
    		  7, 1, 2, 
    		  new ItemStack(ItemHandler.itemRunicGoggles))
      		  .setPages(new ResearchPage[] { 
      				  new ResearchPage("tc.research_page.TD.RUNICGOGGLES.1"), 
      				  new ResearchPage((InfusionRecipe)recipes.get("RunicGoggles")) 
      				  })
			  .setParents("GOGGLES", "TD.RUNICARMOR")
			  .setSecondary()
			  .setConcealed()
			  .registerResearchItem();
      
      new ResearchItem("TD.RUNICBOOTSTRAVELLER", "DYES",
    		  new AspectList().add(Aspect.TRAVEL, 8).add(Aspect.WATER, 5).add(Aspect.ARMOR, 5).add(Aspect.FLIGHT, 5),
    		  5, 2, 2, 
    		  new ItemStack(ItemHandler.itemRunicBootsTraveller))
      		  .setPages(new ResearchPage[] { 
      				  new ResearchPage("tc.research_page.TD.RUNICBOOTSTRAVELLER.1"), 
      				  new ResearchPage((InfusionRecipe)recipes.get("RunicBootsTraveller")) 
      				  })
			  .setParents("TD.BOOTSTRAVELLER", "TD.RUNICARMOR")
			  .setSecondary()
			  .setConcealed()
			  .registerResearchItem();
      
      /////////////
      //augments
      ArrayList<InfusionRecipe> rc1 = new ArrayList();
      ArrayList<InfusionRecipe> rc2 = new ArrayList();
      ArrayList<InfusionRecipe> rc3 = new ArrayList();
      ArrayList<InfusionRecipe> rc4 = new ArrayList();
      ArrayList<InfusionRecipe> rc5 = new ArrayList();
      ArrayList<InfusionRecipe> rc6 = new ArrayList();
      ArrayList<InfusionRecipe> rc7 = new ArrayList();
      ArrayList<InfusionRecipe> rc8 = new ArrayList();
      ArrayList<InfusionRecipe> rc9 = new ArrayList();
      ArrayList<InfusionRecipe> rc10 = new ArrayList();
      for (int a = 0; a <= 3; a++)
      {
        rc1.add((InfusionRecipe)recipes.get("RAU1_" + a)); //berserker
        rc2.add((InfusionRecipe)recipes.get("RAU2_" + a)); //nexus
        rc3.add((InfusionRecipe)recipes.get("RAU3_" + a)); //kinetic
        rc4.add((InfusionRecipe)recipes.get("RAU4_" + a)); //regen
        rc5.add((InfusionRecipe)recipes.get("RAU5_" + a)); //hardened
        rc6.add((InfusionRecipe)recipes.get("RAU6_" + a)); //emerg
        rc7.add((InfusionRecipe)recipes.get("RAU7_" + a)); //knockback
        rc8.add((InfusionRecipe)recipes.get("RAU8_" + a)); //vital
        rc9.add((InfusionRecipe)recipes.get("RAU9_3")); //haste
        rc10.add((InfusionRecipe)recipes.get("RAU10_" + a)); //ravager
        
      }
      
      new ResearchItem("TD.RUNICARMORUPGRADES", "DYES", 
    		  new AspectList().add(Aspect.MAGIC, 8).add(Aspect.ARMOR, 5).add(Aspect.ORDER, 5).add(Aspect.MIND, 3),
    		  7, 4, 3, 
    		  new ResourceLocation("thaumcraft", "textures/misc/r_runicupg.png"))
		      .setPages(new ResearchPage[] { 
		    		  new ResearchPage("tc.research_page.TD.RUNICARMORUPGRADES.1"), 
		    		  new ResearchPage("tc.research_page.TD.RUNICARMORUPGRADES.2"), 
		    		  new ResearchPage("tc.research_page.TD.RUNICARMORUPGRADES.a1"), 
		    		  new ResearchPage((InfusionRecipe[])rc1.toArray(new InfusionRecipe[0])), 
		    		  new ResearchPage("tc.research_page.TD.RUNICARMORUPGRADES.a2"),
		    		  new ResearchPage((InfusionRecipe[])rc2.toArray(new InfusionRecipe[0])),
		    		  new ResearchPage("tc.research_page.TD.RUNICARMORUPGRADES.a3"),
		    		  new ResearchPage((InfusionRecipe[])rc3.toArray(new InfusionRecipe[0])),
		    		  new ResearchPage("tc.research_page.TD.RUNICARMORUPGRADES.a4"),
		    		  new ResearchPage((InfusionRecipe[])rc4.toArray(new InfusionRecipe[0])), 
		    		  new ResearchPage("tc.research_page.TD.RUNICARMORUPGRADES.a5"),
		    		  new ResearchPage((InfusionRecipe[])rc5.toArray(new InfusionRecipe[0])), 
		    		  new ResearchPage("tc.research_page.TD.RUNICARMORUPGRADES.a6"),
		    		  new ResearchPage((InfusionRecipe[])rc6.toArray(new InfusionRecipe[0])),
		    		  new ResearchPage("tc.research_page.TD.RUNICARMORUPGRADES.a7"),
		    		  new ResearchPage((InfusionRecipe[])rc7.toArray(new InfusionRecipe[0])),
		    		  new ResearchPage("tc.research_page.TD.RUNICARMORUPGRADES.a8"),
		    		  new ResearchPage((InfusionRecipe[])rc8.toArray(new InfusionRecipe[0])),
		    		  new ResearchPage("tc.research_page.TD.RUNICARMORUPGRADES.a9"),
		    		  new ResearchPage((InfusionRecipe[])rc9.toArray(new InfusionRecipe[0])),		    		  
		    		  new ResearchPage("tc.research_page.TD.RUNICARMORUPGRADES.a10"),
		    		  new ResearchPage((InfusionRecipe[])rc10.toArray(new InfusionRecipe[0])),	
		    		  
		    		  
		    		  //new ResearchPage("TD.ENHANCEDRUNICARMOR", "tc.research_page.TD.RUNICARMORUPGRADES.E")
		      })
		      .setParents("TD.RUNICARMOR")
		      .setParentsHidden("RUNICHEALING", "RUNICKINETIC", "RUNICEMERGENCY")
		      .setSecondary()
		      .setConcealed()
		      .registerResearchItem();
      
      
      //enhanced
      ArrayList<InfusionRecipe> enhR = new ArrayList();
      for (int a = 0; a <= 3; a++)
      {
        enhR.add((InfusionRecipe)recipes.get("EnhRunicArmor" + a));
      }
      
      new ResearchItem("TD.ENHANCEDRUNICARMOR", "DYES", 
    		  new AspectList().add(Aspect.ARMOR, 8).add(Aspect.AIR, 5).add(Aspect.MAGIC, 5).add(Aspect.ENERGY, 5).add(Aspect.MIND, 3),
    		  10, 3, 3, 
    		  new ItemStack(ItemHandler.itemRunicChestEnhanced))
      		  .setPages(new ResearchPage[] { 
      				  new ResearchPage("tc.research_page.TD.ENHANCEDRUNICARMOR.1"), 
      				  new ResearchPage("tc.research_page.TD.ENHANCEDRUNICARMOR.2"), 
      				  new ResearchPage((InfusionRecipe[])enhR.toArray(new InfusionRecipe[0])) 
      				 
      				  })
			  .setParents("TD.RUNICARMOR")
			  .setParentsHidden("TD.RUNICARMORUPGRADES")
			  .setConcealed()
			  .registerResearchItem();
       
      
      //primal runic aka abyssal runic
      ArrayList<InfusionRecipe> prmR = new ArrayList();
      for (int a = 0; a <= 3; a++)
      {
        prmR.add((InfusionRecipe)recipes.get("PrmRunicArmor" + a));
      }
      
      new ResearchItem("TD.PRIMALRUNICARMOR", "DYES", 
    		  new AspectList().add(Aspect.ARMOR, 8).add(Aspect.ELDRITCH, 12).add(Aspect.MAGIC, 12).add(Aspect.DARKNESS, 10).add(Aspect.SOUL, 8),
    		  11, 6, 3, 
    		  new ItemStack(ItemHandler.itemRunicChestPrimal))
      		  .setPages(new ResearchPage[] { 
      				  new ResearchPage("tc.research_page.TD.PRIMALRUNICARMOR.1"), 
      				  new ResearchPage("tc.research_page.TD.PRIMALRUNICARMOR.2"), 
      				  new ResearchPage("tc.research_page.TD.PRIMALRUNICARMOR.3"), 
      				  new ResearchPage((InfusionRecipe[])prmR.toArray(new InfusionRecipe[0])) 
      				 
      				  })
			  .setParents("TD.ENHANCEDRUNICARMOR")
			  .setParentsHidden("PRIMPEARL")
			  .setConcealed()
			  .registerResearchItem();
      
      ThaumcraftApi.addWarpToResearch("TD.PRIMALRUNICARMOR", 4);
      
      
      new ResearchItem("TD.PRIMALRUNIC", "DYES", 
    		  new AspectList().add(Aspect.ARMOR, 8).add(Aspect.ELDRITCH, 12).add(Aspect.MAGIC, 12).add(Aspect.DARKNESS, 10).add(Aspect.SOUL, 8),
    		  12, 6, 1, 
    		  new ItemStack(ConfigItems.itemEldritchObject,1,0))
      		  .setPages(new ResearchPage[] { 
      				  new ResearchPage("tc.research_page.TD.PRIMALRUNIC.1"),
      				  new ResearchPage("tc.research_page.TD.PRIMALRUNIC.2"),
      				  new ResearchPage("tc.research_page.TD.PRIMALRUNIC.3"),
      				  new ResearchPage("tc.research_page.TD.PRIMALRUNIC.4"),
      				        				 
      				  })
			  .setParents("TD.PRIMALRUNICARMOR")
			  .setConcealed()
			  .registerResearchItem();
      
			      
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
