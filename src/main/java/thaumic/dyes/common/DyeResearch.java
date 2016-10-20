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
   static InfusionRecipe chestRecipe;
   static InfusionRecipe helmRecipe;
   static InfusionRecipe legsRecipe;
   static InfusionRecipe chest1Recipe;
   static InfusionRecipe helm1Recipe;
   static InfusionRecipe legs1Recipe;
   static InfusionRecipe chest2Recipe;
   static InfusionRecipe helm2Recipe;
   static InfusionRecipe legs2Recipe;

   public static void addResearch() {
      ResearchCategories.registerCategory("DYES", new ResourceLocation("thaum:textures/gui/r_td.png"), new ResourceLocation("thaum:textures/gui/r_tdbg.png"));
      (new ResearchItem("DYEDCRIM", "DYES", (new AspectList()).add(Aspect.CLOTH, 4).add(Aspect.ARMOR, 4).add(Aspect.MAGIC, 4), -2, 0, 2, ItemApi.getItem("itemResource", 14))).setPages(new ResearchPage[]{new ResearchPage("tc.research_page.TD.DC.1"), new ResearchPage(helmRecipe), new ResearchPage(chestRecipe), new ResearchPage(legsRecipe)}).setParents(new String[]{"INFUSION"}).registerResearchItem();
      (new ResearchItem("DYEDPRAETOR", "DYES", (new AspectList()).add(Aspect.CLOTH, 5).add(Aspect.ARMOR, 5).add(Aspect.MAGIC, 5).add(Aspect.DARKNESS, 5), -4, 1, 3, ItemApi.getItem("itemResource", 14))).setPages(new ResearchPage[]{new ResearchPage("tc.research_page.TD.DP.1"), new ResearchPage(helm1Recipe), new ResearchPage(chest1Recipe), new ResearchPage(legs1Recipe)}).setParents(new String[]{"DYEDCRIM"}).registerResearchItem();
      (new ResearchItem("DYEDFORTRESS", "DYES", (new AspectList()).add(Aspect.AURA, 5).add(Aspect.ARMOR, 5).add(Aspect.MAGIC, 5).add(Aspect.CRAFT, 5), 2, -2, 5, ItemApi.getItem("itemResource", 14))).setPages(new ResearchPage[]{new ResearchPage("tc.research_page.TD.DF.1"), new ResearchPage(helm2Recipe), new ResearchPage(chest2Recipe), new ResearchPage(legs2Recipe)}).setParents(new String[]{"DYEDPRAETOR"}).registerResearchItem();
   }

   static {
      chestRecipe = ThaumcraftApi.addInfusionCraftingRecipe("DYEDCRIM", new ItemStack(ItemHandler.RobesChestplate), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8), ItemApi.getItem("itemChestCultistRobe", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 2)});
      helmRecipe = ThaumcraftApi.addInfusionCraftingRecipe("DYEDCRIM", new ItemStack(ItemHandler.RobesHelmet), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8), ItemApi.getItem("itemHelmetCultistRobe", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 2)});
      legsRecipe = ThaumcraftApi.addInfusionCraftingRecipe("DYEDCRIM", new ItemStack(ItemHandler.RobesLeggings), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8), ItemApi.getItem("itemLegsCultistRobe", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 2)});
      chest1Recipe = ThaumcraftApi.addInfusionCraftingRecipe("DYEDPRAETOR", new ItemStack(ItemHandler.RobesChestplate2), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8).add(Aspect.DARKNESS, 16), ItemApi.getItem("itemChestCultistLeaderPlate", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16)});
      helm1Recipe = ThaumcraftApi.addInfusionCraftingRecipe("DYEDPRAETOR", new ItemStack(ItemHandler.RobesHelmet2), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8).add(Aspect.DARKNESS, 16), ItemApi.getItem("itemHelmetCultistLeaderPlate", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16)});
      legs1Recipe = ThaumcraftApi.addInfusionCraftingRecipe("DYEDPRAETOR", new ItemStack(ItemHandler.RobesLeggings2), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8).add(Aspect.DARKNESS, 16), ItemApi.getItem("itemLegsCultistLeaderPlate", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16)});
      chest2Recipe = ThaumcraftApi.addInfusionCraftingRecipe("DYEDFORTRESS", new ItemStack(ItemHandler.RobesChestplate1), 5, (new AspectList()).add(Aspect.AURA, 16).add(Aspect.MAGIC, 8).add(Aspect.CRAFT, 16), ItemApi.getItem("itemChestFortress", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 16)});
      helm2Recipe = ThaumcraftApi.addInfusionCraftingRecipe("DYEDFORTRESS", new ItemStack(ItemHandler.RobesHelmet1), 5, (new AspectList()).add(Aspect.AURA, 16).add(Aspect.MAGIC, 8).add(Aspect.CRAFT, 16), ItemApi.getItem("itemHelmetFortress", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 16)});
      legs2Recipe = ThaumcraftApi.addInfusionCraftingRecipe("DYEDFORTRESS", new ItemStack(ItemHandler.RobesLeggings1), 5, (new AspectList()).add(Aspect.AURA, 16).add(Aspect.MAGIC, 8).add(Aspect.CRAFT, 16), ItemApi.getItem("itemLegsFortress", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 16)});
   }
}
