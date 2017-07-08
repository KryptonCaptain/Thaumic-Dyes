package thaumicdyes.common.lib.event;

import java.util.List;

import thaumcraft.common.lib.utils.EntityUtils;
import thaumicdyes.common.items.ItemHandler;
import thaumicdyes.common.items.legacy.ItemTXAncientMask;
import thaumicdyes.common.lib.DamageSourceTX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.entity.living.LivingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHandlerEntity {

	
	@SubscribeEvent
	  public void livingTick(LivingEvent.LivingUpdateEvent event)
	  {
	    if ((event.entity instanceof EntityPlayer)) {
	      EntityPlayer player = (EntityPlayer)event.entity;
	
	      if (!event.entity.worldObj.isRemote) {
	        if (player.ticksExisted % 20 == 0) {
        		if ((player.inventory.armorItemInSlot(3) != null) && (player.inventory.armorItemInSlot(3).getItem() instanceof ItemTXAncientMask )) {
		        	//System.out.println("check Death");
		        	checkDeathGaze(player);
		        }
	        }
	        
	      }
	    }
	  }
	
	
	  public static void checkDeathGaze(EntityPlayer player)
	  {

	    int range = 24;
	    List list = player.worldObj.getEntitiesWithinAABBExcludingEntity(player, player.boundingBox.expand(range, range, range));
	    for (int i = 0; i < list.size(); i++)
	    {
	      Entity entity = (Entity)list.get(i);
	      if ((entity.canBeCollidedWith()) && ((entity instanceof EntityLivingBase)) && (((EntityLivingBase)entity).isEntityAlive())) {
	        if (EntityUtils.isVisibleTo(0.75F, player, entity, range)) {
	          if ((entity != null) && (player.canEntityBeSeen(entity)) && 
	            ((!(entity instanceof EntityPlayer)) || (MinecraftServer.getServer().isPVPEnabled())) )
	          {
	            ((EntityLivingBase)entity).setRevengeTarget(player);
	            ((EntityLivingBase)entity).setLastAttacker(player);
	            if ((entity instanceof EntityCreature)) {
	              ((EntityCreature)entity).setTarget(player);
	            }
	            //((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.wither.getId(), 100, 1));
	            //((EntityLivingBase)entity).attackEntityFrom(DamageSourceTX.witherPlayerDamage(player), 1);
	            
	            if (player.inventory.armorItemInSlot(3) != null) {
            		player.inventory.armorItemInSlot(3).damageItem(1, player);
            		if (player.inventory.armorItemInSlot(3).getItemDamage() == player.inventory.armorItemInSlot(3).getMaxDamage()) {
            			player.inventory.armorInventory[3] = null;
            			player.worldObj.playSoundAtEntity(player, "random.break", 0.5F, 1.0F);
            		}
	            }
	            
	            
	            switch (player.worldObj.rand.nextInt(3))
	            {
	            case 0: 
		            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.weakness.getId(), 100, 6)); break;
	            case 1: 
		            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.wither.getId(), 100, 1)); break;
	            case 2: 
	            	((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 100, 3)); break;
	            case 3: 
	            	//do a thing. not sure what the tc2 code did here
	            	((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.blindness.getId(), 100, 6));
	            }
	            
            		
	          }
	        }
	      }
	    }
	  }
}
