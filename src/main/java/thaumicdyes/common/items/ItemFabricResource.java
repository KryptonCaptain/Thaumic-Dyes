package thaumicdyes.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import thaumicdyes.client.tab.TabTD;
import thaumicdyes.common.ThaumicDyes;

public class ItemFabricResource extends Item {
	
	@SideOnly(Side.CLIENT)
	public IIcon icon;
	
	public ItemFabricResource()
	{
	  setCreativeTab(ThaumicDyes.tabTD);
	  setHasSubtypes(false);
	}

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister ir) {
      this.icon = ir.registerIcon("thaumicdyes:ItemFabricResource"); //thisone

   }
   
   @SideOnly(Side.CLIENT)
   public IIcon getIconFromDamage(int par1)
   {
     return this.icon;
   }

}
