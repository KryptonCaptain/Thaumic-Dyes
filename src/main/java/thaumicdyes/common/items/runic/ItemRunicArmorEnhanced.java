package thaumicdyes.common.items.runic;

import java.util.List;
import java.util.UUID;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import thaumcraft.api.IVisDiscountGear;
import thaumcraft.api.aspects.Aspect;
import thaumicdyes.common.ThaumicDyes;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemRunicArmorEnhanced extends ItemRunicArmor implements IVisDiscountGear {

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
	    if (u > 0) {
	      list.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal(new StringBuilder().append("item.runic.upgrade.").append(u).toString()) );
	    }else { list.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal(new StringBuilder().append("item.runic.upgrade.").append(u).toString()) );
	    }
	    u = getUpgrade2(stack);
	    if (u > 0) {
	      list.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal(new StringBuilder().append("item.runic.upgrade.").append(u).toString()) );
	    }else { list.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal(new StringBuilder().append("item.runic.upgrade.").append(u).toString()) );
	    }
	    if (getVisDiscount(stack, player, null) > 0) {
    		list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("tc.visdiscount") + ": " + getVisDiscount(stack, player, null) + "%");
    	}
	    
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
    	if (this.getUpgrade(item) > -1 && this.getUpgrade2(item) > -1) {
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
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Multimap getAttributeModifiers(ItemStack armor)
    {
    	HashMultimap map = HashMultimap.create();
    	final UUID uuid = new UUID(this.getUnlocalizedName().hashCode(), 0L);
    	
    	if (getUpgrade(armor) == 7 || getUpgrade2(armor) == 7 ) {
			map.put(SharedMonsterAttributes.knockbackResistance.getAttributeUnlocalizedName(), 
					new AttributeModifier(uuid, "Runic knockback " + aType, 0.2, 0));
		}
		if (getUpgrade(armor) == 8 || getUpgrade2(armor) == 8 ) {
			map.put(SharedMonsterAttributes.maxHealth.getAttributeUnlocalizedName(), 
					new AttributeModifier(uuid, "Runic vitality", 10, 0));;
		}
		if (this.armorType == 3) {
			if (getUpgrade(armor) == 9 || getUpgrade2(armor) == 9 ) {
				map.put(SharedMonsterAttributes.movementSpeed.getAttributeUnlocalizedName(), 
						new AttributeModifier(uuid, "Runic speed", 0.03, 0)); //haste1/2/3 is 0.015/0.03/0.045
			}
		}
    	
    	//map.put(SharedMonsterAttributes.knockbackResistance.getAttributeUnlocalizedName(),new AttributeModifier(uuid, "Abyssal modifier " + aType, this.getArmorDisplay(null, armor, aType) / 20.0, 1)); 
		//this one scales with Hardened effect, but starts lower. Keeping it for reference
    	return map;
    }

}