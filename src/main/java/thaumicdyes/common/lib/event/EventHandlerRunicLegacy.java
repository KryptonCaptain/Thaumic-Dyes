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
            String key = player.getEntityId() + ":" + 3; //String key = player.field_71092_bJ + ":" + 3;
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
            if (event.source == DamageSource.drown || event.source == DamageSource.wither || event.source == DamageSource.outOfWorld || event.source == DamageSource.starve) {
                return;
            }
            final ArrayList<Integer> runic = new ArrayList<Integer>();
            final EntityPlayer player = (EntityPlayer)event.entity;
            final long time = System.currentTimeMillis();
            int kinetic = 0;
            int healing = 0;
            int emergency = 0;
            for (int a = 0; a < 4; ++a) {
                if (player.inventory.armorItemInSlot(a) != null && (player.inventory.armorItemInSlot(a)
                		.getItem() instanceof ItemRunicArmorLegacy) )  {
                    
                	if (ItemRunicArmorLegacy.getUpgrade(player.inventory.armorItemInSlot(a)) == 3) {
                        ++kinetic;
                    }
                    else if (ItemRunicArmorLegacy.getUpgrade(player.inventory.armorItemInSlot(a)) == 4) {
                        ++healing;
                    }
                    else if (ItemRunicArmorLegacy.getUpgrade(player.inventory.armorItemInSlot(a)) == 6) {
                        ++emergency;
                    }
                    final ItemStack is = player.inventory.armorItemInSlot(a);
                    if (is.getItemDamage() < is.getMaxDamage()) {
                        runic.add(a);
                    }
                }
            }
            if (runic.size() > 0) {
                int target = -1;
                if (event.source.getEntity() != null) {
                    target = event.source.getEntity().getEntityId();
                }
                if (event.source == DamageSource.fall) {
                    target = -2;
                }
                if (event.source == DamageSource.fallingBlock) {
                    target = -3;
                }
                PacketHandler.INSTANCE.sendToAllAround(new PacketFXShield(event.entity.getEntityId(), target), 
                		new NetworkRegistry.TargetPoint(event.entity.worldObj.provider.dimensionId, event.entity.posX, event.entity.posY, event.entity.posZ, 64.0D));
                
                /*
                int count = 0;
                while (runic.size() > 0 && event.ammount > 0.0f) {
                    final int index = count % runic.size();
                    player.inventory.armorItemInSlot((int)runic.get(index))
                    	.setItemDamage(player.inventory.armorItemInSlot((int)runic.get(index)).getItemDamage() + 1);
                    --event.ammount;
                    
                    if (player.inventory.armorItemInSlot((int)runic.get(index))
                    		.getItemDamage() >= player.inventory.armorItemInSlot((int)runic.get(index)).getMaxDamage()) {
                        runic.remove(index);
                    }
                    ++count;
                }*/
                
                
                /*int charge = runicCharge.get(player.getEntityId());
                if (charge > event.ammount) {
                    charge -= (int)event.ammount;
                    event.ammount = 0.0f;
                }
                else {
                    event.ammount -= charge;
                    charge = 0;
                }*/
                
                //thanks T.Utils, even though I think I wrote that code anyway?
                int total = (Thaumcraft.instance.runicEventHandler.runicInfo.get(Integer.valueOf(player.getEntityId())))[0].intValue();
                int charge = (Thaumcraft.instance.runicEventHandler.runicCharge.get(Integer.valueOf(player.getEntityId()))).intValue();
                
                
                String key = player.getEntityId() + ":" + 3;
                if (charge <= 0 && kinetic > 0 && !this.upgradeCooldown.containsKey(key)) {
                    this.upgradeCooldown.put(key, 600);
                    player.worldObj.newExplosion((Entity)player, player.posX, player.posY + player.height / 2.0f, player.posZ, 1.5f + kinetic * 0.5f, false, false);
                    //player.worldObj.newExplosion((Entity)player, player.posX, player.posY + player.height / 2.0f, player.posZ, 1.5f + this.runicInfo.get(player.getEntityId())[2] * 0.5f, false, false);
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
                    player.worldObj.playSoundAtEntity((Entity)player, "thaumcraft:runicShieldCharge", 1.0f, 1.0f);
                    //System.out.println("emerg: "+emergency+" "+t+" "+charge);
                }
                
                Thaumcraft.instance.runicEventHandler.runicCharge.put(player.getEntityId(), charge);
                PacketHandler.INSTANCE.sendTo((IMessage)new PacketRunicCharge(player, (short)charge, Thaumcraft.instance.runicEventHandler.runicInfo.get(player.getEntityId())[0]), (EntityPlayerMP)player);
            
            }
        }
    }
    
}
    


