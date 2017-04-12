package thaumicdyes.common.items.legacy;

import net.minecraft.item.EnumRarity;
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
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.IIcon;
import thaumcraft.api.IGoggles;
import thaumcraft.api.nodes.IRevealer;
import thaumcraft.api.IVisDiscountGear;

public class ItemRunicGoggles extends ItemRunicArmorLegacy implements IVisDiscountGear, IRevealer, IGoggles
{
    public IIcon iconHelm;
    
    public ItemRunicGoggles(ArmorMaterial enumarmormaterial, int j, int k) {
        super(enumarmormaterial, j, k);
        this.setCreativeTab(Thaumcraft.tabTC);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(final IIconRegister ir) {
        this.iconHelm = ir.registerIcon("thaumicdyes:runicGoggles");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(final int par1) {
        return this.iconHelm;
    }
    
    @Override
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List list, final boolean par4) {
        list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("item.runic.charge") + ": " + (stack.getMaxDamage() - stack.getItemDamage()) + "/" + stack.getMaxDamage());
        final int u = ItemRunicArmorLegacy.getUpgrade(stack);
        if (u > 0) {
            list.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("item.runic.upgrade." + u));
        }
        list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("tc.visdiscount") + ": " + this.getVisDiscount(stack, player, null) + "%");
    }
    
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return "thaumicdyes:textures/models/runic_goggles.png";
    }
    
    @Override
    public boolean isBookEnchantable(final ItemStack itemstack1, final ItemStack itemstack2) {
        return false;
    }
    
    @Override
    public int getVisDiscount(final ItemStack stack, final EntityPlayer player, final Aspect aspect) {
        return 5;
    }
    
    @Override
    public boolean showNodes(final ItemStack itemstack, final EntityLivingBase player) {
        return true;
    }
    
    @Override
    public boolean showIngamePopups(final ItemStack itemstack, final EntityLivingBase player) {
        return true;
    }
    
    @Override
    public EnumRarity getRarity(final ItemStack itemstack) {
        return EnumRarity.rare;
    }
}

