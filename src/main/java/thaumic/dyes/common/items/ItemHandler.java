package thaumic.dyes.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import thaumic.dyes.client.tab.TabTD;
import thaumic.dyes.common.items.RobesArmor;
import thaumic.dyes.common.items.RobesArmor1;
import thaumic.dyes.common.items.RobesArmor2;

public class ItemHandler {
   public static ToolMaterial Robes;
   public static ArmorMaterial RobesArmor;
   public static Item RobesHelmet;
   public static Item RobesChestplate;
   public static Item RobesLeggings;
   public static int RobesHelmetID;
   public static int RobesChestplateID;
   public static int RobesLeggingsID;
   public static Item RobesHelmet1;
   public static Item RobesChestplate1;
   public static Item RobesLeggings1;
   public static int RobesHelmet1ID;
   public static int RobesChestplate1ID;
   public static int RobesLeggings1ID;
   public static Item RobesHelmet2;
   public static Item RobesChestplate2;
   public static Item RobesLeggings2;
   public static int RobesHelmet2ID;
   public static int RobesChestplate2ID;
   public static int RobesLeggings2ID;

   public static void registerItems() {
      GameRegistry.registerItem(RobesHelmet, "RobesHelmet");
      GameRegistry.registerItem(RobesChestplate, "RobesChestplate");
      GameRegistry.registerItem(RobesLeggings, "RobesLeggings");
      GameRegistry.registerItem(RobesHelmet1, "RobesHelmet1");
      GameRegistry.registerItem(RobesChestplate1, "RobesChestplate1");
      GameRegistry.registerItem(RobesLeggings1, "RobesLeggings1");
      GameRegistry.registerItem(RobesHelmet2, "RobesHelmet2");
      GameRegistry.registerItem(RobesChestplate2, "RobesChestplate2");
      GameRegistry.registerItem(RobesLeggings2, "RobesLeggings2");
   }

   public static void defineItems() {
      RobesHelmet = (new RobesArmor(RobesArmor, RobesHelmetID, 0)).setUnlocalizedName("RobesHelmet").setCreativeTab(TabTD.TabTD);
      RobesChestplate = (new RobesArmor(RobesArmor, RobesChestplateID, 1)).setUnlocalizedName("RobesChestplate").setCreativeTab(TabTD.TabTD);
      RobesLeggings = (new RobesArmor(RobesArmor, RobesLeggingsID, 2)).setUnlocalizedName("RobesLeggings").setCreativeTab(TabTD.TabTD);
      RobesHelmet1 = (new RobesArmor1(RobesArmor, RobesHelmet1ID, 0)).setUnlocalizedName("RobesHelmet1").setCreativeTab(TabTD.TabTD);
      RobesChestplate1 = (new RobesArmor1(RobesArmor, RobesChestplate1ID, 1)).setUnlocalizedName("RobesChestplate1").setCreativeTab(TabTD.TabTD);
      RobesLeggings1 = (new RobesArmor1(RobesArmor, RobesLeggings1ID, 2)).setUnlocalizedName("RobesLeggings1").setCreativeTab(TabTD.TabTD);
      RobesHelmet2 = (new RobesArmor2(RobesArmor, RobesHelmet2ID, 0)).setUnlocalizedName("RobesHelmet2").setCreativeTab(TabTD.TabTD);
      RobesChestplate2 = (new RobesArmor2(RobesArmor, RobesChestplate2ID, 1)).setUnlocalizedName("RobesChestplate2").setCreativeTab(TabTD.TabTD);
      RobesLeggings2 = (new RobesArmor2(RobesArmor, RobesLeggings2ID, 2)).setUnlocalizedName("RobesLeggings2").setCreativeTab(TabTD.TabTD);
   }

   public static void registerToolMaterial() {
      RobesArmor = EnumHelper.addArmorMaterial("ROBESARMOR", 50, new int[]{3, 5, 5, 2}, 7);
   }
}
