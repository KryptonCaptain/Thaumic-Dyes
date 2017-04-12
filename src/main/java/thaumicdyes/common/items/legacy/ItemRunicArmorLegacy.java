package thaumicdyes.common.items.legacy;

import java.util.HashMap;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.MinecraftForge;
import thaumcraft.api.IRunicArmor;
import thaumcraft.common.Thaumcraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRunicArmorLegacy extends ItemArmor implements ISpecialArmor, IRunicArmor
{
    public IIcon iconHelm;
    public IIcon iconChest;
    public IIcon iconLegs;
    public IIcon iconBoots;
    public static HashMap<Integer, Long> nextTick;
    
    public ItemRunicArmorLegacy(ArmorMaterial enumarmormaterial, int j, int k) {
        super(enumarmormaterial, j, k);
        this.setCreativeTab(Thaumcraft.tabTC);
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    public boolean isDamageable() {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister ir) {
        this.iconHelm = ir.registerIcon("thaumicdyes:runicHelmet");
        this.iconChest = ir.registerIcon("thaumicdyes:runicChest");
        this.iconLegs = ir.registerIcon("thaumicdyes:runicLeggings");
        this.iconBoots = ir.registerIcon("thaumicdyes:runicBoots");
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(final int par1) {
        return (this.armorType == 0) ? this.iconHelm : ((this.armorType == 1) ? this.iconChest : ((this.armorType == 2) ? this.iconLegs : this.iconBoots));
    }
    
    public int getMaxDamage(final ItemStack stack) {
        int md = ((ItemArmor)stack.getItem()).damageReduceAmount * 8;
        if (getUpgrade(stack) == 2) {
            md *= (int)1.5;
        }
        return md;
    }
    
    public int getRunicCharge(ItemStack itemstack) {
    	//return (this.armorType == 0) ? itemstack.getMaxDamage() : ((this.armorType == 1) ? itemstack.getMaxDamage() : ((this.armorType == 2) ? itemstack.getMaxDamage() : itemstack.getMaxDamage()));
    	//return 0;
    	//math wasn't behaving, so values are manual
    	if ((itemstack.hasTagCompound()) && (itemstack.stackTagCompound.hasKey("upgrade")) && (itemstack.stackTagCompound.getInteger("upgrade") == 2)) {
    		return (this.armorType == 0) ?  12 : ((this.armorType == 1) ? 36 : ((this.armorType == 2) ? 24 : 12 ));
  	  }
    	return (this.armorType == 0) ? 8 : ((this.armorType == 1) ? 24 : ((this.armorType == 2) ? 16 : 8 ));
    	
	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List list, final boolean par4) {
        //list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("item.runic.charge") + ": " + (stack.getMaxDamage() - stack.getItemDamage()) + "/" + stack.getMaxDamage());
        final int u = getUpgrade(stack);
        if (u > 0) {
            list.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("item.runic.upgrade." + u));
        }
    }
    
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return "thaumicdyes:textures/items/blank.png";
    }
    
    public EnumRarity getRarity(final ItemStack itemstack) {
        return EnumRarity.rare;
    }
    
    public boolean isBookEnchantable(final ItemStack itemstack1, final ItemStack itemstack2) {
        return false;
    }
    
    /*
    public ArmorProperties getProperties(final EntityLivingBase player, final ItemStack armor, final DamageSource source, final double damage, final int slot) {
        int dra = ((ItemArmor)armor.getItem()).damageReduceAmount;
        if (getUpgrade(armor) == 5) {
            dra *= 4;
        }
        
        return new ISpecialArmor.ArmorProperties(1, dra / 25.0, (int)damage);
        return new ArmorProperties(1, (getArmorMaterial().getDamageReductionAmount(armorType) * 0.05)*3, (int)damage);
        
    }*/
    
    public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
    {
      int priority = 0;
      double ratio = this.damageReduceAmount / 25.0D;
      if (getUpgrade(armor) == 5)
      {
        priority = 1;
        ratio = this.damageReduceAmount / 12.5D;
      }
      else if (source.isUnblockable())
      {
        priority = 0;
        ratio = 0.0D;
      }

      return new ArmorProperties(priority, ratio, armor.getMaxDamage() + 1 - armor.getItemDamage());
    }
    
    
    
    public int getArmorDisplay(final EntityPlayer player, final ItemStack armor, final int slot) {
        int dra = ((ItemArmor)armor.getItem()).damageReduceAmount;
        if (getUpgrade(armor) == 5) {
            dra *= 2;
        }
        return dra;
    }
    
    public void damageArmor(final EntityLivingBase entity, final ItemStack stack, final DamageSource source, final int damage, final int slot) {
    }
    
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack armor) {
        if (!world.isRemote && armor.getItemDamage() > 0) {
            final long time = System.currentTimeMillis();
            if (!ItemRunicArmorLegacy.nextTick.containsKey(player.ticksExisted)) {
                ItemRunicArmorLegacy.nextTick.put(player.ticksExisted, 0L);
            }
            if (time < ItemRunicArmorLegacy.nextTick.get(player.ticksExisted)) {
                return;
            }
            if (armor.getItemDamage() > 0) {
                int rate = 1000;
                for (int a = 0; a < 4; ++a) {
                    if (player.inventory.armorItemInSlot(a) != null && player.inventory.armorItemInSlot(a).getItem() instanceof ItemRunicArmorLegacy && getUpgrade(player.inventory.armorItemInSlot(a)) == 1) {
                        rate -= 150;
                    }
                }
                if (rate < 200) {
                    rate = 200;
                }
                ItemRunicArmorLegacy.nextTick.put(player.ticksExisted, time + rate);
                armor.setItemDamage(armor.getItemDamage() - 1);
                player.inventoryContainer.detectAndSendChanges();
            }
        }
    }
    
    public static int getUpgrade(final ItemStack armor) {
        if (armor.hasTagCompound() && armor.stackTagCompound.hasKey("upgrade")) {
            return armor.stackTagCompound.getByte("upgrade");
        }
        return 0;
    }
    
    static {
        ItemRunicArmorLegacy.nextTick = new HashMap<Integer, Long>();

    }

}
