package thaumicdyes.common.items.runic;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
import net.minecraftforge.event.entity.living.LivingEvent;
import thaumcraft.api.IRunicArmor;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.items.armor.Hover;
import thaumicdyes.common.ThaumicDyes;
import thaumicdyes.common.items.ItemHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemRunicArmorEnhanced extends ItemRunicArmor  {

	public ItemRunicArmorEnhanced(ItemArmor.ArmorMaterial enumarmormaterial, int j, int k) {
		super(enumarmormaterial, j, k);
		this.setCreativeTab(ThaumicDyes.tabTD);
	}
		
	
	@Override
    public int getRunicCharge(ItemStack itemstack) {
    	//return (this.armorType == 0) ? itemstack.getMaxDamage() : ((this.armorType == 1) ? itemstack.getMaxDamage() : ((this.armorType == 2) ? itemstack.getMaxDamage() : itemstack.getMaxDamage()));
    	//return 0;
    	//math wasn't behaving, so values are manual
    	if ( ((itemstack.hasTagCompound()) && (itemstack.stackTagCompound.hasKey("upgrade")) && (itemstack.stackTagCompound.getInteger("upgrade") == 2))
    		|| ((itemstack.hasTagCompound()) && (itemstack.stackTagCompound.hasKey("upgrade2")) && (itemstack.stackTagCompound.getInteger("upgrade2") == 2)) )
    	{
    		if ( ((itemstack.hasTagCompound()) && (itemstack.stackTagCompound.hasKey("upgrade")) && (itemstack.stackTagCompound.getInteger("upgrade") == 2))
    	    		&& ((itemstack.hasTagCompound()) && (itemstack.stackTagCompound.hasKey("upgrade2")) && (itemstack.stackTagCompound.getInteger("upgrade2") == 2)) )
    	    	{
    			return (this.armorType == 0) ?  16 : ((this.armorType == 1) ? 48 : ((this.armorType == 2) ? 32 : 16 )); //TODO 112 total
    	    	}
    		else {
    			return (this.armorType == 0) ?  12 : ((this.armorType == 1) ? 36 : ((this.armorType == 2) ? 24 : 12 )); //84 total
    		}	
    		
  	  }
    	return (this.armorType == 0) ? 8 : ((this.armorType == 1) ? 24 : ((this.armorType == 2) ? 16 : 8 )); //56 total
    	
	}
	
	
	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
	{
		int priority = 0;
		double ratio = this.damageReduceAmount / 25.0D;
	      
	    if (getUpgrade(armor) == 5 || getUpgrade2(armor) == 5) {
		    if (getUpgrade(armor) == 5 && getUpgrade2(armor) == 5) {
		    	priority = 1;
		        ratio = this.damageReduceAmount / 8.3D; //more classic manual values, 25/3
		    }
		    else {
		    	priority = 1;
		        ratio = this.damageReduceAmount / 12.5D;
		    }
	    }
	    else if (source.isUnblockable())
	      {
	        priority = 0;
	        ratio = 0.0D;
	      }
	    return new ArmorProperties(priority, ratio, armor.getMaxDamage() + 1 - armor.getItemDamage());
	}
	  
	
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
	    int dra = ((ItemArmor)armor.getItem()).damageReduceAmount;
	    if (getUpgrade(armor) == 5 || getUpgrade2(armor) == 5) {
		    if (getUpgrade(armor) == 5 && getUpgrade2(armor) == 5) {
		    	dra *= 3;
		    }
		    else {
		    	dra *= 2;
		    }
	    }
		return dra;
	}
	

	@Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
	    //list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("item.runic.charge") + ": " + (stack.getMaxDamage() - stack.getItemDamage()) + "/" + stack.getMaxDamage());
	    
		int u = getUpgrade(stack);
	    if (u < 7) {
	      list.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal(new StringBuilder().append("item.runic.upgrade.").append(u).toString()) );
	    }
	    u = getUpgrade2(stack);
	    if (u < 7) {
	      list.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal(new StringBuilder().append("item.runic.upgrade.").append(u).toString()) );
	    }
    	if (getVisDiscount(stack, player, null) > 0)
    		list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("tc.visdiscount") + ": " + getVisDiscount(stack, player, null) + "%");

//	    for (Aspect aspect : Aspect.getPrimalAspects()) {
//	    	String tag = "";
//			if (getVisDiscount(stack, player, aspect) > 0) {
//	    		tag = aspect.getTag().substring(0, 1).toUpperCase() + aspect.getTag().substring(1);
//	    	    list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("tc.visdiscount") + " ("+tag+"): " + getVisDiscount(stack, player, aspect) + "%");
//			}
//	    }
    }
	
	
	public static int getUpgrade(ItemStack armor)
	{
	    if ((armor.hasTagCompound()) && (armor.stackTagCompound.hasKey("upgrade"))) {
	    	return armor.stackTagCompound.getByte("upgrade");
		}
		return 0;
	}
	
	public static int getUpgrade2(ItemStack armor)
	{
	    if ((armor.hasTagCompound()) && (armor.stackTagCompound.hasKey("upgrade2"))) {
	    	return armor.stackTagCompound.getByte("upgrade2");
		}
		return 0;
	}
	
	
	@Override
	public EnumRarity getRarity(ItemStack itemstack)
	{
		return EnumRarity.rare;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		this.iconHelm = ir.registerIcon("thaumicdyes:enhancedRunicHelmet");
	    this.iconChest = ir.registerIcon("thaumicdyes:enhancedRunicChest");
	    this.iconLegs = ir.registerIcon("thaumicdyes:enhancedRunicLeggings");
	    this.iconBoots = ir.registerIcon("thaumicdyes:enhancedRunicBoots");
	}
	  
	
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	if (this.getUpgrade(item) <7 && this.getUpgrade2(item) <7) {
    		int u1 = this.getUpgrade(item);
    		int u2 = this.getUpgrade2(item);
    		item.stackTagCompound.setByte("upgrade2",(byte) u1);
    		item.stackTagCompound.setByte("upgrade",(byte) u2);
    		return true;
    	}
    	return false;
    }
    
    public int getVisDiscount(ItemStack stack, EntityPlayer player, Aspect aspect)
    {
        //return this.armorType == 3 ? 1 : 2;
    	return 2;
    }

}