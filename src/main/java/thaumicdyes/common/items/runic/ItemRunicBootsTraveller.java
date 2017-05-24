package thaumicdyes.common.items.runic;

import net.minecraft.util.StatCollector;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.EnumRarity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.items.armor.Hover;
import thaumicdyes.common.items.ItemHandler;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;

public class ItemRunicBootsTraveller extends ItemRunicArmor
{
    public IIcon icon;
    
    public ItemRunicBootsTraveller(ArmorMaterial enumarmormaterial, int j, int k) {
        super(enumarmormaterial, j, k);
        this.setCreativeTab(Thaumcraft.tabTC);
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(final IIconRegister ir) {
        this.icon = ir.registerIcon("thaumicdyes:runicbootstraveler");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(final int par1) {
        return this.icon;
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return "thaumicdyes:textures/models/runicbootstraveler.png";
    }
    
    @Override
    public EnumRarity getRarity(final ItemStack itemstack) {
        return EnumRarity.rare;
    }
    
    @Override
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
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
              float bonus = 0.055F;
              if (player.isInWater()) {
                bonus /= 4.0F;
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
        if (player.fallDistance > 0.0f) {
            player.fallDistance -= 0.25f;
        }
        super.onArmorTick(world, player, itemStack);
    }
    
    @SubscribeEvent
    public void playerJumps(LivingEvent.LivingJumpEvent event)
    {
      if (((event.entity instanceof EntityPlayer)) && (((EntityPlayer)event.entity).inventory.armorItemInSlot(0) != null) && (((EntityPlayer)event.entity).inventory.armorItemInSlot(0).getItem() == ItemHandler.itemRunicBootsTraveller)) {
        event.entityLiving.motionY += 0.2750000059604645D;
      }
    }
    
}

