package thaumicdyes.common.lib.event; 
 
import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.lib.network.PacketHandler;
import thaumcraft.common.lib.network.playerdata.PacketRunicCharge;
import thaumicdyes.common.items.legacy.ItemRunicArmorLegacy;
import thaumicdyes.common.items.legacy.ItemTXRunicArmorEnhanced;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.simpleimpl.IMessage;


public class EventHandlerRunicTX { 
	
  @SubscribeEvent 
    public void entityHurt(LivingHurtEvent event) 
    { 
 
      if ((event.entity instanceof EntityPlayer)) 
      { 
        if ((event.source == DamageSource.drown) || (event.source == DamageSource.wither) || (event.source == DamageSource.outOfWorld) || (event.source == DamageSource.starve)) { 
          return; 
        } 
        ArrayList<Integer> runic = new ArrayList(); 
        EntityPlayer player = (EntityPlayer)event.entity; 
        int kinetic = 0; 
        int healing = 0; 
        int emergency = 0; 
        for (int a = 0; a < 4; a++) { 
          if ((player.inventory.armorItemInSlot(a) != null) && ((player.inventory.armorItemInSlot(a).getItem() instanceof ItemTXRunicArmorEnhanced))) 
          { 
 
            if (ItemTXRunicArmorEnhanced.getUpgrade1(player.inventory.armorItemInSlot(a)) == 3) { 
              kinetic++; 
            } else if (ItemTXRunicArmorEnhanced.getUpgrade1(player.inventory.armorItemInSlot(a)) == 4) { 
              healing++; 
            } else if (ItemTXRunicArmorEnhanced.getUpgrade1(player.inventory.armorItemInSlot(a)) == 6) { 
              emergency++; 
            } 
            if (ItemTXRunicArmorEnhanced.getUpgrade2(player.inventory.armorItemInSlot(a)) == 3) { 
              kinetic++; 
            } else if (ItemTXRunicArmorEnhanced.getUpgrade2(player.inventory.armorItemInSlot(a)) == 4) { 
              healing++; 
            } else if (ItemTXRunicArmorEnhanced.getUpgrade2(player.inventory.armorItemInSlot(a)) == 6) { 
              emergency++; 
 
            } 
            ItemStack is = player.inventory.armorItemInSlot(a); 
            if (is.getItemDamage() < is.getMaxDamage()) { 
              runic.add(Integer.valueOf(a)); 
            } 
          } 
        } 
        //System.out.println(runic.size()); 
        if (runic.size() > 0) 
        { 
        	/*
            int count = 0; 
            while ((runic.size() > 0) && (event.ammount > 0.0F)) 
            { 
              int index = count % runic.size(); 
              player.inventory.armorItemInSlot(((Integer)runic.get(index)).intValue()).setItemDamage(player.inventory.armorItemInSlot(((Integer)runic.get(index)).intValue()).getItemDamage() + 1); 
               
              event.ammount -= 1.0F; 
              if (player.inventory.armorItemInSlot(((Integer)runic.get(index)).intValue()).getItemDamage() >= player.inventory.armorItemInSlot(((Integer)runic.get(index)).intValue()).getMaxDamage()) { 
                runic.remove(index); 
                 
                System.out.println(runic.size()); 
              } 
              count++; 
            } */
            
        
        int total = (Thaumcraft.instance.runicEventHandler.runicInfo.get(Integer.valueOf(player.getEntityId())))[0].intValue();
        int charge = (Thaumcraft.instance.runicEventHandler.runicCharge.get(Integer.valueOf(player.getEntityId()))).intValue();
        
            
          String key = player.getEntityId() + ":" + 3; 
          if (charge <= 0 && (kinetic > 0) && (!EventHandlerRunicLegacy.upgradeCooldown.containsKey(key))) 
          { 
        	  EventHandlerRunicLegacy.upgradeCooldown.put(key, Integer.valueOf(600)); 
            player.worldObj.newExplosion(player, player.posX, player.posY + player.height / 2.0F, player.posZ, 1.0F + kinetic * 0.5F, false, false); 
          } /*
          else 
          { 
            System.out.println((runic.size() == 0) + " " + (kinetic > 0) + " " + (!EventHandlerLegacyRunic.upgradeCooldown.containsKey(key))); 
          } */
          
          
          key = player.getEntityId() + ":" + 4; 
          if (charge <= 0 && (healing > 0) && (!EventHandlerRunicLegacy.upgradeCooldown.containsKey(key))) 
          { 
            //healing--; 
            EventHandlerRunicLegacy.upgradeCooldown.put(key, Integer.valueOf(600)); 
            player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, healing)); 
            player.worldObj.playSoundAtEntity(player, "thaumcraft:runicShieldEffect", 1.0F, 1.0F); 
          } 
          
          
          key = player.getEntityId() + ":" + 6;
          if (charge <= 0 && emergency > 0 && !EventHandlerRunicLegacy.upgradeCooldown.containsKey(key)) {
        	  EventHandlerRunicLegacy.upgradeCooldown.put(key, 2400);
              final int t = 8 * emergency;
              charge = Math.min(Thaumcraft.instance.runicEventHandler.runicInfo.get(player.getEntityId())[0], t);
              //Thaumcraft.instance.runicEventHandler.isDirty = true;
              player.worldObj.playSoundAtEntity((Entity)player, "thaumcraft:runicShieldCharge", 1.0f, 1.0f);
              //System.out.println("emergENH: "+emergency+" "+t+" "+charge);
          }
          
          Thaumcraft.instance.runicEventHandler.runicCharge.put(player.getEntityId(), charge);
          PacketHandler.INSTANCE.sendTo((IMessage)new PacketRunicCharge(player, (short)charge, Thaumcraft.instance.runicEventHandler.runicInfo.get(player.getEntityId())[0]), (EntityPlayerMP)player);
      
          
          
          /*
          key = player.getEntityId() + ":" + 6; 
          if (charge <= 0 && (emergency > 0) && (!EventHandlerLegacyRunic.upgradeCooldown.containsKey(key))) 
          { 
        	  EventHandlerLegacyRunic.upgradeCooldown.put(key, Integer.valueOf(2400)); 
            ArrayList<Integer> runicTemp = new ArrayList(); 
            for (int a = 0; a < 4; a++) { 
              if ((player.inventory.armorItemInSlot(a) != null) && ((player.inventory.armorItemInSlot(a).getItem() instanceof ItemRunicArmorLegacy))) 
              { 
                ItemStack is = player.inventory.armorItemInSlot(a); 
                if (is.getItemDamage() > 0) { 
                  runicTemp.add(Integer.valueOf(a)); 
                } 
              } 
            } 
            count = 8 * emergency; 
            while ((count > 0) && (runicTemp.size() > 0)) 
            { 
              int index = count % runicTemp.size(); 
              player.inventory.armorItemInSlot(((Integer)runicTemp.get(index)).intValue()).setItemDamage(player.inventory.armorItemInSlot(((Integer)runicTemp.get(index)).intValue()).getItemDamage() - 1); 
               
              count--; 
              if (player.inventory.armorItemInSlot(((Integer)runicTemp.get(index)).intValue()).getItemDamage() == 0) { 
                runicTemp.remove(index); 
              } 
            } 
            player.worldObj.playSoundAtEntity(player, "thaumcraft:runicShieldCharge", 1.0F, 1.0F); 
          } */
        } 
      } 
    } 
  } 