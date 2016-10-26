package thaumic.dyes.common;

import cpw.mods.fml.common.registry.GameRegistry;
import java.util.ArrayList;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumic.dyes.common.RobeDyes;
import thaumic.dyes.common.FortressDyes;
import thaumic.dyes.common.PraetorDyes;
import thaumic.dyes.common.items.ItemHandler;

public class DyeRecipe {
   public static ArrayList meats = new ArrayList();

   public static void initRecipes() {
      RecipeSorter.register("forge:voidrobearmordye", RobeDyes.class, Category.SHAPELESS, "after:forge:robearmordye");
      ThaumcraftApi.addInfusionCraftingRecipe("DYEDROBES", new ItemStack(ItemHandler.itemChestCultistRobe), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8), ItemApi.getItem("itemChestCultistRobe", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 2)});
      ThaumcraftApi.addInfusionCraftingRecipe("DYEDROBES", new ItemStack(ItemHandler.itemHelmetCultistRobe), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8), ItemApi.getItem("itemHelmetCultistRobe", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 2)});
      ThaumcraftApi.addInfusionCraftingRecipe("DYEDROBES", new ItemStack(ItemHandler.itemLegsCultistRobe), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8), ItemApi.getItem("itemLegsCultistRobe", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 2)});
      ThaumcraftApi.addInfusionCraftingRecipe("DYEDPRAETOR", new ItemStack(ItemHandler.itemChestCultistLeaderPlate), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8).add(Aspect.DARKNESS, 16), ItemApi.getItem("itemChestCultistLeaderPlate", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16)});
      ThaumcraftApi.addInfusionCraftingRecipe("DYEDPRAETOR", new ItemStack(ItemHandler.itemHelmetCultistLeaderPlate), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8).add(Aspect.DARKNESS, 16), ItemApi.getItem("itemHelmetCultistLeaderPlate", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16)});
      ThaumcraftApi.addInfusionCraftingRecipe("DYEDPRAETOR", new ItemStack(ItemHandler.itemLegsCultistLeaderPlate), 5, (new AspectList()).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 8).add(Aspect.DARKNESS, 16), ItemApi.getItem("itemLegsCultistLeaderPlate", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16)});
      ThaumcraftApi.addInfusionCraftingRecipe("DYEDFORTRESS", new ItemStack(ItemHandler.itemChestFortress), 5, (new AspectList()).add(Aspect.AURA, 16).add(Aspect.MAGIC, 8).add(Aspect.CRAFT, 16), ItemApi.getItem("itemChestFortress;", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 16)});
      ThaumcraftApi.addInfusionCraftingRecipe("DYEDFORTRESS", new ItemStack(ItemHandler.itemHelmetFortress), 5, (new AspectList()).add(Aspect.AURA, 16).add(Aspect.MAGIC, 8).add(Aspect.CRAFT, 16), ItemApi.getItem("itemHelmetFortress;", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 16)});
      ThaumcraftApi.addInfusionCraftingRecipe("DYEDFORTRESS", new ItemStack(ItemHandler.itemLegsFortress), 5, (new AspectList()).add(Aspect.AURA, 16).add(Aspect.MAGIC, 8).add(Aspect.CRAFT, 16), ItemApi.getItem("itemLegsFortress;", 0), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 16)});
      GameRegistry.addRecipe(new RobeDyes());
      GameRegistry.addRecipe(new FortressDyes());
      GameRegistry.addRecipe(new PraetorDyes());
      GameRegistry.addRecipe(new KnightDyes());
   }
}
