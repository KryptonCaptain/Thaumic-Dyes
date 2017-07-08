package thaumicdyes.common.items.legacy;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import thaumcraft.api.aspects.Aspect;
import net.minecraft.util.StatCollector;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.config.ConfigItems;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.IIcon;
import thaumcraft.api.IGoggles;
import thaumcraft.api.IRepairable;
import thaumcraft.api.IRunicArmor;
import thaumcraft.api.IWarpingGear;
import thaumcraft.api.ItemApi;
import thaumcraft.api.nodes.IRevealer;
import thaumcraft.api.IVisDiscountGear;
import thaumicdyes.common.ThaumicDyes;

public class ItemTXAncientMask extends ItemArmor implements IRepairable, IVisDiscountGear, IRunicArmor, IWarpingGear 
{
    public IIcon iconHelm;
    
    public ItemTXAncientMask(ArmorMaterial enumarmormaterial, int j, int k) {
        super(enumarmormaterial, j, k);
        this.setCreativeTab(ThaumicDyes.tabTD);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(final IIconRegister ir) {
        this.iconHelm = ir.registerIcon("thaumicdyes:maskEvil");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(final int par1) {
        return this.iconHelm;
    }
    
    @Override
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List list, final boolean par4) {

        list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("tc.visdiscount") + ": " + this.getVisDiscount(stack, player, null) + "%");
    }
    
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return "thaumicdyes:textures/models/mask.png";
    }
    
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
      return par2ItemStack.isItemEqual(new ItemStack(ConfigItems.itemResource, 1, 16)) ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
    
    @Override
    public int getVisDiscount(final ItemStack stack, final EntityPlayer player, final Aspect aspect) {
        return 5;
    }
    
    
    @Override
    public EnumRarity getRarity(final ItemStack itemstack) {
        return EnumRarity.rare;
    }

	@Override
	public int getRunicCharge(ItemStack itemstack) {
		return 0;
	}

	@Override
	public int getWarp(ItemStack itemstack, EntityPlayer player) {
		return 1;
	}
}

