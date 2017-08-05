package thaumicdyes.common.items.runic;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
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
import net.minecraftforge.common.MinecraftForge;
import thaumcraft.api.IRunicArmor;
import thaumcraft.common.lib.research.ResearchManager;
import thaumicdyes.common.ThaumicDyes;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRunicArmor extends ItemArmor implements ISpecialArmor, IRunicArmor
{
    public IIcon iconHelm;
    public IIcon iconChest;
    public IIcon iconLegs;
    public IIcon iconBoots;
    public static HashMap<Integer, Long> nextTick;
    public int aType;
    public EntityPlayer rPlayer;
    
    public ItemRunicArmor(ArmorMaterial enumarmormaterial, int j, int k) {
        super(enumarmormaterial, j, k);
        this.setCreativeTab(ThaumicDyes.tabTD);
        MinecraftForge.EVENT_BUS.register(this);
        this.aType = k;
    }
    /*
    public boolean isDamageable() {
        return false;
    }*/
    
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
    
    
    public int getRunicCharge(ItemStack itemstack) {
    	//return (this.armorType == 0) ? itemstack.getMaxDamage() : ((this.armorType == 1) ? itemstack.getMaxDamage() : ((this.armorType == 2) ? itemstack.getMaxDamage() : itemstack.getMaxDamage()));
    	//return 0;
    	//math wasn't behaving, so values are manual
    	if ((itemstack.hasTagCompound()) && (itemstack.stackTagCompound.hasKey("upgrade")) && (itemstack.stackTagCompound.getInteger("upgrade") == 2)) {
    		return (this.armorType == 0) ?  12 : ((this.armorType == 1) ? 36 : ((this.armorType == 2) ? 24 : 12 )); //TODO 84 total, TBA
  	  }
    	return (this.armorType == 0) ? 8 : ((this.armorType == 1) ? 24 : ((this.armorType == 2) ? 16 : 8 )); //56 total
    	
	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List list, final boolean par4) {
        //list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("item.runic.charge") + ": " + (stack.getMaxDamage() - stack.getItemDamage()) + "/" + stack.getMaxDamage());
        final int u = getUpgrade(stack);
		if (u > 0) {
			list.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("item.runic.upgrade." + u));
		}
    	if (ResearchManager.isResearchComplete(player.getCommandSenderName(), "TD.RUNICARMORUPGRADES")) {
    		if (u == 0) { list.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal(new StringBuilder().append("item.runic.upgrade.").append(u).toString()) );
    		}
    	}
    	
    	
    }
    
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return "thaumicdyes:textures/items/blank.png";
    }
    
    public EnumRarity getRarity(final ItemStack itemstack) {
        return EnumRarity.rare;
    }
    
    public boolean isBookEnchantable(final ItemStack armor, final ItemStack book) {
        return false;
    }
    
    public boolean isItemTool(ItemStack par1ItemStack) {
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
        ratio = this.damageReduceAmount*2 / 25.0D; //more classic manual values
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
    
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Multimap getAttributeModifiers(ItemStack armor)
    {
    	HashMultimap map = HashMultimap.create();
    	final UUID uuid = new UUID(this.getUnlocalizedName().hashCode(), 0L);
    	
    	if (getUpgrade(armor) == 7 ) {
			map.put(SharedMonsterAttributes.knockbackResistance.getAttributeUnlocalizedName(), 
					new AttributeModifier(uuid, "Runic knockback " + aType, 0.2, 0));
		}
		if (getUpgrade(armor) == 8 ) {
			map.put(SharedMonsterAttributes.maxHealth.getAttributeUnlocalizedName(), 
					new AttributeModifier(uuid, "Runic vitality", 10, 0));;
		}
		if (this.armorType == 3) {
			if (getUpgrade(armor) == 9 ) {
				map.put(SharedMonsterAttributes.movementSpeed.getAttributeUnlocalizedName(), 
						new AttributeModifier(uuid, "Runic speed", 0.03, 0)); //haste1/2/3 is 0.015/0.03/0.045
			}
		}
		if (getUpgrade(armor) == 10 ) {
			map.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), 
					new AttributeModifier(uuid, "Runic ravager", 2, 0));;
		}
    	//map.put(SharedMonsterAttributes.knockbackResistance.getAttributeUnlocalizedName(),new AttributeModifier(uuid, "Abyssal modifier " + aType, this.getArmorDisplay(null, armor, aType) / 20.0, 1)); 
		//this one scales with Hardened effect, but starts lower. Keeping it for reference
		return map;
    }
    
    
    public void damageArmor(final EntityLivingBase entity, final ItemStack stack, final DamageSource source, final int damage, final int slot) {
    }
    
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack armor) {
        if (!world.isRemote && armor.getItemDamage() > 0) {
            final long time = System.currentTimeMillis();
            if (!ItemRunicArmor.nextTick.containsKey(player.ticksExisted)) {
                ItemRunicArmor.nextTick.put(player.ticksExisted, 0L);
            }
            if (time < ItemRunicArmor.nextTick.get(player.ticksExisted)) {
                return;
            }
            if (armor.getItemDamage() > 0) {
                int rate = 1000;
                for (int a = 0; a < 4; ++a) {
                    if (player.inventory.armorItemInSlot(a) != null && player.inventory.armorItemInSlot(a).getItem() instanceof ItemRunicArmor && getUpgrade(player.inventory.armorItemInSlot(a)) == 1) {
                        rate -= 150;
                    }
                }
                if (rate < 200) {
                    rate = 200;
                }
                ItemRunicArmor.nextTick.put(player.ticksExisted, time + rate);
                armor.setItemDamage(armor.getItemDamage() - 1);
                player.inventoryContainer.detectAndSendChanges();
            }
        }
    }
    
    /*
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return false;
    }*/
    
    public static int getUpgrade(final ItemStack armor) {
        if (armor.hasTagCompound() && armor.stackTagCompound.hasKey("upgrade")) {
            return armor.stackTagCompound.getByte("upgrade");
        }
        return 0;
    }
    
    
    static {
        ItemRunicArmor.nextTick = new HashMap<Integer, Long>();

    }

}
