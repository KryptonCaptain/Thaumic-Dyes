package thaumicdyes.common.lib.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.config.Config;
import thaumcraft.common.lib.events.EventHandlerRunic;
import thaumcraft.common.lib.network.PacketHandler;
import thaumcraft.common.lib.network.fx.PacketFXShield;
import thaumcraft.common.lib.network.playerdata.PacketRunicCharge;
import thaumicdyes.common.items.runic.ItemRunicArmor;
import thaumicdyes.common.items.runic.ItemRunicArmorEnhanced;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class EventHandlerRunicLegacy {
    public static HashMap<Integer, ArrayList<Integer>> linkedEntities;
    public static HashMap<String, Integer> upgradeCooldown = new HashMap();
    
    
    
    @SubscribeEvent
    public void livingTick(final LivingEvent.LivingUpdateEvent event) {
    	    	
    	if (event.entity instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)event.entity;
            
            
            String key = "0";
            
            key = player.getEntityId() + ":" + 1; 
            if (this.upgradeCooldown.containsKey(key)) {
                final int cooldown = this.upgradeCooldown.get(key);
                if (cooldown <= 0) {
                    this.upgradeCooldown.remove(key);
                }
                else {
                    this.upgradeCooldown.put(key, cooldown - 1);
                }
            }
            
            key = player.getEntityId() + ":" + 3; 
            if (this.upgradeCooldown.containsKey(key)) {
                final int cooldown = this.upgradeCooldown.get(key);
                if (cooldown <= 0) {
                    this.upgradeCooldown.remove(key);
                }
                else {
                    this.upgradeCooldown.put(key, cooldown - 1);
                }
            }
            key = player.getEntityId() + ":" + 4;
            if (this.upgradeCooldown.containsKey(key)) {
                final int cooldown = this.upgradeCooldown.get(key);
                if (cooldown <= 0) {
                    this.upgradeCooldown.remove(key);
                }
                else {
                    this.upgradeCooldown.put(key, cooldown - 1);
                }
            }
            
            key = player.getEntityId() + ":" + 6;
            if (this.upgradeCooldown.containsKey(key)) {
                final int cooldown = this.upgradeCooldown.get(key);
                if (cooldown <= 0) {
                    this.upgradeCooldown.remove(key);
                }
                else {
                    this.upgradeCooldown.put(key, cooldown - 1);
                }
            }
        }
    }
    
    @SubscribeEvent
    public void entityHurt(final LivingHurtEvent event) {
    	if (event.entity != null) {
	        if (event.entity instanceof EntityPlayerMP && (!(event.entity instanceof FakePlayer)) ) {
	            
	        	int berserker = 0;
	            int kinetic = 0;
	            int healing = 0;
	            //int hardened = 0;
	            int emergency = 0;
	            
	            final ArrayList<Integer> runic = new ArrayList<Integer>();
	            
	            final EntityPlayer player = (EntityPlayer)event.entity;
	            
	            //int runicTotal = (Thaumcraft.instance.runicEventHandler.runicInfo.get(Integer.valueOf(player.getEntityId())))[0].intValue();
	            int runicCharge = (Thaumcraft.instance.runicEventHandler.runicCharge.get(Integer.valueOf(player.getEntityId()))).intValue();
	            
	            for (int a = 0; a < 4; a++) {
	                if (player.inventory.armorItemInSlot(a) != null && (player.inventory.armorItemInSlot(a).getItem() instanceof ItemRunicArmor) )  { //this should cover the enhanced one too
	                    
	                	if (getUpgrade(player.inventory.armorItemInSlot(a)) == 1) {
	                        berserker++;
	                    }                	
	                	else if (getUpgrade(player.inventory.armorItemInSlot(a)) == 3) {
	                		kinetic++;
	                    }
	                    else if (getUpgrade(player.inventory.armorItemInSlot(a)) == 4) {
	                    	healing++;
	                    }
	                    else if (getUpgrade(player.inventory.armorItemInSlot(a)) == 6) {
	                    	emergency++;
	                    }
	                    
	                	
	                	final ItemStack is = player.inventory.armorItemInSlot(a);
	                	if (is.getItemDamage() < is.getMaxDamage()) {
	                		runic.add(a);
	            		}
	                }
	                
	                else if ((player.inventory.armorItemInSlot(a) != null) && ((player.inventory.armorItemInSlot(a).getItem() instanceof ItemRunicArmor))) 
	    	        { 
	    		        if (getUpgrade2(player.inventory.armorItemInSlot(a)) == 1) { 
	    		        	berserker++; 
	    		        }  
	    		        else if (getUpgrade2(player.inventory.armorItemInSlot(a)) == 3) { 
	    		        	kinetic++; 
	    		        } 
	    		        else if (getUpgrade2(player.inventory.armorItemInSlot(a)) == 4) { 
	    		        	healing++; 
	    		        } 
	    		        else if (getUpgrade2(player.inventory.armorItemInSlot(a)) == 6) { 
	    		        	emergency++; 
	    		        }  
	    		        
	    		        
	    		        final ItemStack is = player.inventory.armorItemInSlot(a);
	                	if (is.getItemDamage() < is.getMaxDamage()) {
	                		runic.add(a);
	            		}
	    	        }
	                
	                else if ((player.inventory.armorItemInSlot(a) != null) && ((player.inventory.armorItemInSlot(a).getItem() instanceof ItemRunicArmor))) 
	    	        { 
	    		        if (getUpgrade3(player.inventory.armorItemInSlot(a)) == 1) { 
	    		        	berserker++; 
	    		        }  
	    		        else if (getUpgrade3(player.inventory.armorItemInSlot(a)) == 3) { 
	    		        	kinetic++; 
	    		        } 
	    		        else if (getUpgrade3(player.inventory.armorItemInSlot(a)) == 4) { 
	    		        	healing++; 
	    		        } 
	    		        else if (getUpgrade3(player.inventory.armorItemInSlot(a)) == 6) { 
	    		        	emergency++; 
	    		        }
	    		        
	    		        
	    		        final ItemStack is = player.inventory.armorItemInSlot(a);
	                	if (is.getItemDamage() < is.getMaxDamage()) {
	                		runic.add(a);
	            		}
	    	        }
	                
	            }
	            
	            //TODO do a thing if effects are on at least 4 slots
	            /**
	            berserker 4, res 1/2
	            kinetic 4, speed
	            heal 4, absorption 
	            emergency 4, invis
	            
	            fixed effect level, dur*aug STR if >=4
	            
	             */
	            
	            if (runic.size() > 0) {
	            
	            	String key = "0";
	                
	                key = player.getEntityId() + ":" + 1;
	                if (runicCharge <= 0 && berserker > 0 && !this.upgradeCooldown.containsKey(key)) {
	                    this.upgradeCooldown.put(key, 400);
	                    player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, (100*(berserker)), berserker));
	                    if (berserker >= 4) {
	                    	player.addPotionEffect(new PotionEffect(Potion.resistance.id, 200+(100*(berserker-4)), berserker-4));
	                    }
	                    player.worldObj.playSoundAtEntity((Entity)player, "thaumcraft:runicShieldEffect", 1.0f, 1.0f);
	                }
	                
	                key = player.getEntityId() + ":" + 3;
	                if (runicCharge <= 0 && kinetic > 0 && !this.upgradeCooldown.containsKey(key)) {
	                    this.upgradeCooldown.put(key, 600);
	                    player.worldObj.newExplosion((Entity)player, player.posX, player.posY + player.height / 2.0f, player.posZ, 1.5f + kinetic * 0.5f, false, false);
	                    //player.worldObj.newExplosion((Entity)player, player.posX, player.posY + player.height / 2.0f, player.posZ, 1.5f + this.runicInfo.get(player.getEntityId())[2] * 0.5f, false, false);
	
	                    player.worldObj.playSoundAtEntity((Entity)player, "thaumcraft:shock1", 1.0f, 1.0f);
	                }
	                
	                key = player.getEntityId() + ":" + 4;
	                if (runicCharge <= 0 && healing > 0 && !this.upgradeCooldown.containsKey(key)) {
	                    //healing--;
	                    this.upgradeCooldown.put(key, 600);
	                    player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, healing));
	
	                    player.worldObj.playSoundAtEntity((Entity)player, "thaumcraft:runicShieldEffect", 1.0f, 1.0f);
	                }
	                
	                key = player.getEntityId() + ":" + 6;
	                if (runicCharge <= 0 && emergency > 0 && !this.upgradeCooldown.containsKey(key)) {
	                    this.upgradeCooldown.put(key, 2400);
	                    final int t = 8 * emergency;
	                    runicCharge = Math.min(Thaumcraft.instance.runicEventHandler.runicInfo.get(player.getEntityId())[0], t);
	                    //Thaumcraft.instance.runicEventHandler.isDirty = true;
	
	                    player.worldObj.playSoundAtEntity((Entity)player, "thaumcraft:runicShieldCharge", 1.0f, 1.0f);
	                    
	                }
	                
	                Thaumcraft.instance.runicEventHandler.runicCharge.put(player.getEntityId(), runicCharge);
	                PacketHandler.INSTANCE.sendTo((IMessage)new PacketRunicCharge(player, (short)runicCharge, Thaumcraft.instance.runicEventHandler.runicInfo.get(player.getEntityId())[0]), (EntityPlayerMP)player);
	            
	            }
	        }
    	}
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
    
}
    


