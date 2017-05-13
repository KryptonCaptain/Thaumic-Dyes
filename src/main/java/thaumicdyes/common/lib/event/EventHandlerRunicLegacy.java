package thaumicdyes.common.lib.event;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.config.Config;
import thaumcraft.common.lib.events.EventHandlerRunic;
import thaumcraft.common.lib.network.PacketHandler;
import thaumcraft.common.lib.network.fx.PacketFXShield;
import thaumcraft.common.lib.network.playerdata.PacketRunicCharge;
import thaumicdyes.common.items.legacy.ItemRunicArmorLegacy;
import thaumicdyes.common.items.legacy.ItemTXRunicArmorEnhanced;
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
        if (event.entity instanceof EntityPlayer) {
            
        	int berserker = 0;
            int kinetic = 0;
            int healing = 0;
            int emergency = 0;
            
            final EntityPlayer player = (EntityPlayer)event.entity;
            
            int total = (Thaumcraft.instance.runicEventHandler.runicInfo.get(Integer.valueOf(player.getEntityId())))[0].intValue();
            int charge = (Thaumcraft.instance.runicEventHandler.runicCharge.get(Integer.valueOf(player.getEntityId()))).intValue();
            
            for (int a = 0; a < 4; ++a) {
                if (player.inventory.armorItemInSlot(a) != null && (player.inventory.armorItemInSlot(a).getItem() instanceof ItemRunicArmorLegacy) )  { //this should cover the enhanced one too
                    
                	if (ItemRunicArmorLegacy.getUpgrade1(player.inventory.armorItemInSlot(a)) == 1) {
                        berserker++;
                    }                	
                	else if (ItemRunicArmorLegacy.getUpgrade1(player.inventory.armorItemInSlot(a)) == 3) {
                		kinetic++;
                    }
                    else if (ItemRunicArmorLegacy.getUpgrade1(player.inventory.armorItemInSlot(a)) == 4) {
                    	healing++;
                    }
                    else if (ItemRunicArmorLegacy.getUpgrade1(player.inventory.armorItemInSlot(a)) == 6) {
                    	emergency++;
                    }
                }
                
                if ((player.inventory.armorItemInSlot(a) != null) && ((player.inventory.armorItemInSlot(a).getItem() instanceof ItemTXRunicArmorEnhanced))) 
    	        { 
    		        if (ItemTXRunicArmorEnhanced.getUpgrade2(player.inventory.armorItemInSlot(a)) == 1) { 
    		        	berserker++; 
    		        }  if (ItemTXRunicArmorEnhanced.getUpgrade2(player.inventory.armorItemInSlot(a)) == 3) { 
    		        	kinetic++; 
    		        } else if (ItemTXRunicArmorEnhanced.getUpgrade2(player.inventory.armorItemInSlot(a)) == 4) { 
    		        	healing++; 
    		        } else if (ItemTXRunicArmorEnhanced.getUpgrade2(player.inventory.armorItemInSlot(a)) == 6) { 
    		        	emergency++; 
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
            
            String key = "0";
            
            key = player.getEntityId() + ":" + 1;
            if (charge <= 0 && berserker > 0 && !this.upgradeCooldown.containsKey(key)) {
                this.upgradeCooldown.put(key, 1200);
                player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 200, berserker));
                if (berserker >= 4) {
                	player.addPotionEffect(new PotionEffect(Potion.resistance.id, 200+(100*(berserker-4)), berserker-3));
                }
                player.worldObj.playSoundAtEntity((Entity)player, "thaumcraft:runicShieldEffect", 1.0f, 1.0f);
            }
            
            key = player.getEntityId() + ":" + 3;
            if (charge <= 0 && kinetic > 0 && !this.upgradeCooldown.containsKey(key)) {
                this.upgradeCooldown.put(key, 600);
                player.worldObj.newExplosion((Entity)player, player.posX, player.posY + player.height / 2.0f, player.posZ, 1.5f + kinetic * 0.5f, false, false);
                //player.worldObj.newExplosion((Entity)player, player.posX, player.posY + player.height / 2.0f, player.posZ, 1.5f + this.runicInfo.get(player.getEntityId())[2] * 0.5f, false, false);
                if (kinetic >= 4) {
                	player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200+(100*(kinetic-4)), kinetic-3));
                }
            }
            
            key = player.getEntityId() + ":" + 4;
            if (charge <= 0 && healing > 0 && !this.upgradeCooldown.containsKey(key)) {
                //healing--;
                this.upgradeCooldown.put(key, 600);
                player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, healing));
                player.worldObj.playSoundAtEntity((Entity)player, "thaumcraft:runicShieldEffect", 1.0f, 1.0f);
            }
            
            key = player.getEntityId() + ":" + 6;
            if (charge <= 0 && emergency > 0 && !this.upgradeCooldown.containsKey(key)) {
                this.upgradeCooldown.put(key, 2400);
                final int t = 8 * emergency;
                charge = Math.min(Thaumcraft.instance.runicEventHandler.runicInfo.get(player.getEntityId())[0], t);
                //Thaumcraft.instance.runicEventHandler.isDirty = true;
                if (emergency >= 4) {
                	player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 200+(100*(emergency-4)), 0 ));
                }
                player.worldObj.playSoundAtEntity((Entity)player, "thaumcraft:runicShieldCharge", 1.0f, 1.0f);
                
            }
            
            Thaumcraft.instance.runicEventHandler.runicCharge.put(player.getEntityId(), charge);
            PacketHandler.INSTANCE.sendTo((IMessage)new PacketRunicCharge(player, (short)charge, Thaumcraft.instance.runicEventHandler.runicInfo.get(player.getEntityId())[0]), (EntityPlayerMP)player);
        
            
        }
    }
    
}
    


