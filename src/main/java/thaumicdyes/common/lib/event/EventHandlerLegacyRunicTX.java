package thaumicdyes.common.lib.event; 
 
import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import thaumcraft.common.Thaumcraft;
import thaumicdyes.common.items.legacy.ItemRunicArmorLegacy;
import thaumicdyes.common.items.legacy.ItemTXRunicArmorEnhanced;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;


public class EventHandlerLegacyRunicTX { 
	
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
        int feedDes = 0; 
        int feedReg = 0; 
        int feedEmerg = 0; 
        for (int a = 0; a < 4; a++) { 
          if ((player.inventory.armorItemInSlot(a) != null) && ((player.inventory.armorItemInSlot(a).getItem() instanceof ItemTXRunicArmorEnhanced))) 
          { 
 
            if (ItemTXRunicArmorEnhanced.getUpgrade1(player.inventory.armorItemInSlot(a)) == 3) { 
              feedDes++; 
            } else if (ItemTXRunicArmorEnhanced.getUpgrade1(player.inventory.armorItemInSlot(a)) == 4) { 
              feedReg++; 
            } else if (ItemTXRunicArmorEnhanced.getUpgrade1(player.inventory.armorItemInSlot(a)) == 6) { 
              feedEmerg++; 
            } 
            if (ItemTXRunicArmorEnhanced.getUpgrade2(player.inventory.armorItemInSlot(a)) == 3) { 
              feedDes++; 
            } else if (ItemTXRunicArmorEnhanced.getUpgrade2(player.inventory.armorItemInSlot(a)) == 4) { 
              feedReg++; 
            } else if (ItemTXRunicArmorEnhanced.getUpgrade2(player.inventory.armorItemInSlot(a)) == 6) { 
              feedEmerg++; 
 
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
          if (charge <= 0 && (feedDes > 0) && (!EventHandlerLegacyRunic.upgradeCooldown.containsKey(key))) 
          { 
        	  EventHandlerLegacyRunic.upgradeCooldown.put(key, Integer.valueOf(600)); 
            player.worldObj.newExplosion(player, player.posX, player.posY + player.height / 2.0F, player.posZ, 1.0F + feedDes * 0.5F, false, false); 
          } /*
          else 
          { 
            System.out.println((runic.size() == 0) + " " + (feedDes > 0) + " " + (!EventHandlerLegacyRunic.upgradeCooldown.containsKey(key))); 
          } */
          
          
          key = player.getEntityId() + ":" + 4; 
          if (charge <= 0 && (feedReg > 0) && (!EventHandlerLegacyRunic.upgradeCooldown.containsKey(key))) 
          { 
            feedReg--; 
            EventHandlerLegacyRunic.upgradeCooldown.put(key, Integer.valueOf(600)); 
            player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, feedReg)); 
            player.worldObj.playSoundAtEntity(player, "thaumcraft:runicShieldEffect", 1.0F, 1.0F); 
          } 
          
          /*
          key = player.getEntityId() + ":" + 6; 
          if (charge <= 0 && (feedEmerg > 0) && (!EventHandlerLegacyRunic.upgradeCooldown.containsKey(key))) 
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
            count = 8 * feedEmerg; 
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