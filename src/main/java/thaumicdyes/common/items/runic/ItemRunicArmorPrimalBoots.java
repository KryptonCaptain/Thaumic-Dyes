package thaumicdyes.common.items.runic;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import thaumcraft.api.IGoggles;
import thaumcraft.api.IWarpingGear;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.nodes.IRevealer;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.items.armor.Hover;
import thaumicdyes.common.ThaumicDyes;
import thaumicdyes.common.items.ItemHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemRunicArmorPrimalBoots extends ItemRunicArmorPrimal   {

	public ItemRunicArmorPrimalBoots(ItemArmor.ArmorMaterial enumarmormaterial, int j, int k) {
		super(enumarmormaterial, j, k);
		this.setCreativeTab(ThaumicDyes.tabTD);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
	    this.iconBoots = ir.registerIcon("thaumicdyes:runicBootsPrimal");
	}
	
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor)
    {
      if ((!player.capabilities.isFlying) && (player.moveForward > 0.0F))
      {
        if ((player.worldObj.isRemote) && (!player.isSneaking()))
        {
          if (!Thaumcraft.instance.entityEventHandler.prevStep.containsKey(Integer.valueOf(player.getEntityId()))) {
            Thaumcraft.instance.entityEventHandler.prevStep.put(Integer.valueOf(player.getEntityId()), Float.valueOf(player.stepHeight));
          }
          player.stepHeight = 1.0F;
        }
        if (player.onGround)
        {
          float bonus = 0.1F;
          if (player.isInWater()) {
            bonus /= 3.0F;
          }
          player.moveFlying(0.0F, 1.0F, bonus);
        }
        else if (Hover.getHover(player.getEntityId()))
        {
          player.jumpMovementFactor = 0.03F;
        }
        else
        {
          player.jumpMovementFactor = 0.05F;
        }
      }
      if (player.fallDistance > 0.0F) {
        player.fallDistance -= 0.5F;
      }
      
      super.onArmorTick(world, player, armor);
      if ((!world.isRemote) && (armor.getItemDamage() > 0) && (player.ticksExisted % 20 == 0)) {
        armor.damageItem(-1, player);
      }
    }
    
    @SubscribeEvent
    public void playerJumps(LivingEvent.LivingJumpEvent event)
    {
      if (((event.entity instanceof EntityPlayer)) && (((EntityPlayer)event.entity).inventory.armorItemInSlot(0) != null) && (((EntityPlayer)event.entity).inventory.armorItemInSlot(0).getItem() == ItemHandler.itemBootsRunicPrimal)) {
    	  //System.out.println("event.entityLiving.motionY "+event.entityLiving.motionY);
    	  event.entityLiving.motionY += 0.35D;
      }
    }

}