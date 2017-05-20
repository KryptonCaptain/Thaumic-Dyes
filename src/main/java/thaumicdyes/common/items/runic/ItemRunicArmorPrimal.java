package thaumicdyes.common.items.runic;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import thaumcraft.api.IGoggles;
import thaumcraft.api.IWarpingGear;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.nodes.IRevealer;
import thaumicdyes.client.models.ModelRobesSpecial;
import thaumicdyes.common.ThaumicDyes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemRunicArmorPrimal extends ItemRunicArmor implements IRevealer, IGoggles, IWarpingGear  {

	public ItemRunicArmorPrimal(ItemArmor.ArmorMaterial enumarmormaterial, int j, int k) {
		super(enumarmormaterial, j, k);
		this.setCreativeTab(ThaumicDyes.tabTD);
	}

	
	@Override
    public int getRunicCharge(ItemStack itemstack) {
    	//return (this.armorType == 0) ? itemstack.getMaxDamage() : ((this.armorType == 1) ? itemstack.getMaxDamage() : ((this.armorType == 2) ? itemstack.getMaxDamage() : itemstack.getMaxDamage()));
    	//return 0;
    	//math wasn't behaving, so values are manual
    	if ( (getUpgrade(itemstack) == 2) 
			|| (getUpgrade2(itemstack) == 2)
    		|| (getUpgrade3(itemstack) == 2)  )
    	{
    		if ( (getUpgrade(itemstack) == 2) && (getUpgrade2(itemstack) == 2) 
	    		|| (getUpgrade(itemstack) == 2) && (getUpgrade3(itemstack) == 2)
	    		|| (getUpgrade2(itemstack) == 2) && (getUpgrade3(itemstack) == 2)  )
	    	{
    			if ( (getUpgrade(itemstack) == 2) && (getUpgrade2(itemstack) == 2) && (getUpgrade3(itemstack) == 2) ) 
    			{
    				return (this.armorType == 0) ?  20 : ((this.armorType == 1) ? 60 : ((this.armorType == 2) ? 40 : 20 )); //TODO 140 total
    			}
    			
    			else {
    				return (this.armorType == 0) ?  16 : ((this.armorType == 1) ? 48 : ((this.armorType == 2) ? 32 : 16 )); //TODO 112 total
    			}
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
	      
	    if (getUpgrade(armor) == 5 || getUpgrade2(armor) == 5 || getUpgrade3(armor) == 5) {
		    if ( (getUpgrade(armor) == 5 && getUpgrade2(armor) == 5) 
		    	|| (getUpgrade(armor) == 5 && getUpgrade3(armor) == 5) 
		    	|| (getUpgrade2(armor) == 5 && getUpgrade3(armor) == 5) )
		    {
		    	if (getUpgrade(armor) == 5 && getUpgrade2(armor) == 5 && getUpgrade3(armor) == 5) {
		    		priority = 1;
			        ratio = this.damageReduceAmount / 6.25D; //more classic manual values, 25/4
		    	}
		    	else {
			    	priority = 1;
			        ratio = this.damageReduceAmount / 8.3D; //more classic manual values, 25/3
		    	}
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
		    if ( (getUpgrade(armor) == 5 && getUpgrade2(armor) == 5)
	    		|| (getUpgrade(armor) == 5 && getUpgrade3(armor) == 5)
	    		|| (getUpgrade2(armor) == 5 && getUpgrade3(armor) == 5) )
		    {
		    	if ( (getUpgrade(armor) == 5 && getUpgrade2(armor) == 5 && getUpgrade3(armor) == 5) ) {
		    		dra *= 4;
		    	}
		    	else {
		    		dra *= 3;
		    	}
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
	    } else { list.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal(new StringBuilder().append("item.runic.upgrade.").append(u).toString()) );
	    }
	    u = getUpgrade2(stack);
	    if (u < 7) {
	      list.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal(new StringBuilder().append("item.runic.upgrade.").append(u).toString()) );
	    }else { list.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal(new StringBuilder().append("item.runic.upgrade.").append(u).toString()) );
	    }
	    u = getUpgrade3(stack);
	    if (u < 7) {
	      list.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal(new StringBuilder().append("item.runic.upgrade.").append(u).toString()) );
	    }else { list.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal(new StringBuilder().append("item.runic.upgrade.").append(u).toString()) );
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
	public static int getUpgrade3(ItemStack armor)
	{
	    if ((armor.hasTagCompound()) && (armor.stackTagCompound.hasKey("upgrade3"))) {
	    	return armor.stackTagCompound.getByte("upgrade3");
		}
		return 0;
	}
	
	
	
	@Override
	public EnumRarity getRarity(ItemStack itemstack)
	{
		return EnumRarity.epic; //
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		this.iconHelm = ir.registerIcon("thaumicdyes:runicHelmPrimal");
	    this.iconChest = ir.registerIcon("thaumicdyes:runicChestPrimal");
	    this.iconLegs = ir.registerIcon("thaumicdyes:runicLegsPrimal");
	    //this.iconBoots = ir.registerIcon("thaumicdyes:runicBootsPrimal");
	}
	  
	
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	if (this.getUpgrade(item) <20 && this.getUpgrade2(item) <20 &&this.getUpgrade3(item) <20) {
    		int u1 = this.getUpgrade(item);
    		int u2 = this.getUpgrade2(item);
    		int u3 = this.getUpgrade3(item);
    		item.stackTagCompound.setByte("upgrade",(byte) u2);
    		item.stackTagCompound.setByte("upgrade2",(byte) u3);
    		item.stackTagCompound.setByte("upgrade3",(byte) u1);
    		return true;
    	}
    	return false;
    }
    
    public int getVisDiscount(ItemStack stack, EntityPlayer player, Aspect aspect)
    {
        //return this.armorType == 3 ? 1 : 2;
    	return 5;
    }
    
    public int getWarp(ItemStack itemstack, EntityPlayer player)
    {
      return 3;
    }

	@Override
	public boolean showIngamePopups(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}
	
	@Override
	public boolean showNodes(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}
	
	ModelBiped model1 = null;
	ModelBiped model2 = null;
   	ModelBiped model = null;
   	
   	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return "thaumicdyes:textures/models/guardian_robe_armor1.png";
     }
	
	@SideOnly(Side.CLIENT)
	   public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
	      int type = ((ItemArmor)itemStack.getItem()).armorType;
	      if(this.model1 == null) {
	         this.model1 = new ModelRobesSpecial(1.0F);
	      }

	      if(this.model2 == null) {
	         this.model2 = new ModelRobesSpecial(0.5F);
	      }

	      if(type != 1 && type != 3) {
	         this.model = this.model2;
	      } else {
	         this.model = this.model1;
	      }

	      if(this.model != null) {
	         this.model.bipedHead.showModel = armorSlot == 0;
	         this.model.bipedHeadwear.showModel = armorSlot == 0;
	         this.model.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
	         this.model.bipedRightArm.showModel = armorSlot == 1;
	         this.model.bipedLeftArm.showModel = armorSlot == 1;
	         this.model.bipedRightLeg.showModel = armorSlot == 2;
	         this.model.bipedLeftLeg.showModel = armorSlot == 2;
	         this.model.isSneak = entityLiving.isSneaking();
	         this.model.isRiding = entityLiving.isRiding();
	         this.model.isChild = entityLiving.isChild();
	         this.model.aimedBow = false;
	         this.model.heldItemRight = entityLiving.getHeldItem() != null?1:0;
	         if(entityLiving instanceof EntityPlayer && ((EntityPlayer)entityLiving).getItemInUseDuration() > 0) {
	            EnumAction enumaction = ((EntityPlayer)entityLiving).getItemInUse().getItemUseAction();
	            if(enumaction == EnumAction.block) {
	               this.model.heldItemRight = 3;
	            } else if(enumaction == EnumAction.bow) {
	               this.model.aimedBow = true;
	            }
	         }
	      }

	      return this.model;
	   }

}