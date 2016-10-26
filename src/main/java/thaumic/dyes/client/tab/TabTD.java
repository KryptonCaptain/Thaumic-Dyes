package thaumic.dyes.client.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import thaumic.dyes.common.items.ItemHandler;

public class TabTD {
   public static CreativeTabs TabTD = new CreativeTabs("TabTD") {
      public Item getTabIconItem() {
         return ItemHandler.itemChestCultistRobe;
      }
   };

}
