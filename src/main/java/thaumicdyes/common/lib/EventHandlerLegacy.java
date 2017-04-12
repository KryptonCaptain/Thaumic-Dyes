package thaumicdyes.common.lib;

import net.minecraft.enchantment.Enchantment;
import thaumcraft.common.entities.projectile.EntityPrimalArrow;
import thaumcraft.common.items.equipment.ItemBowBone;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.entities.EntityAspectOrb;
import thaumcraft.common.lib.network.PacketHandler;
import thaumcraft.common.lib.network.fx.PacketFXShield;
import thaumcraft.common.lib.research.ResearchManager;
import thaumcraft.common.lib.research.ScanManager;
import thaumcraft.common.entities.monster.EntityThaumicSlime;
import thaumcraft.common.entities.monster.EntityTaintVillager;
import net.minecraft.entity.passive.EntityVillager;
import thaumcraft.common.entities.monster.EntityTaintChicken;
import net.minecraft.entity.passive.EntityChicken;
import thaumcraft.common.entities.monster.EntityTaintPig;
import net.minecraft.entity.passive.EntityPig;
import thaumcraft.common.entities.monster.EntityTaintCow;
import net.minecraft.entity.passive.EntityCow;
import thaumcraft.common.entities.monster.EntityTaintSheep;
import net.minecraft.entity.passive.EntitySheep;
import thaumcraft.common.entities.monster.EntityTaintCreeper;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraft.entity.Entity;

import java.util.Iterator;

import net.minecraft.tileentity.TileEntity;
import thaumcraft.common.tiles.TileOwned;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import thaumcraft.common.entities.golems.EntityGolemBase;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import thaumcraft.common.items.equipment.ItemElementalSword;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.items.armor.Hover;
import thaumcraft.common.items.armor.ItemHoverHarness;
import thaumcraft.api.IRepairable;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraft.entity.EntityLivingBase;
import thaumcraft.api.IRepairableExtended;
import net.minecraft.enchantment.EnchantmentHelper;
import thaumcraft.common.config.Config;
import thaumicdyes.common.items.legacy.ItemRunicArmorLegacy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.item.ItemTossEvent;

import java.util.ArrayList;
import java.util.HashMap;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class EventHandlerLegacy
{

    public static HashMap<Integer, ArrayList<Integer>> linkedEntities;
    
    
    @SubscribeEvent
    public void livingTick(final LivingEvent.LivingUpdateEvent event) {
        if (event.entity instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)event.entity;
            String key = player.getCommandSenderName() + ":" + 3; //String key = player.field_71092_bJ + ":" + 3;
            if (ItemRunicArmorLegacy.upgradeCooldown.containsKey(key)) {
                final int cooldown = ItemRunicArmorLegacy.upgradeCooldown.get(key);
                if (cooldown <= 0) {
                    ItemRunicArmorLegacy.upgradeCooldown.remove(key);
                }
                else {
                    ItemRunicArmorLegacy.upgradeCooldown.put(key, cooldown - 1);
                }
            }
            key = player.getCommandSenderName() + ":" + 4;
            if (ItemRunicArmorLegacy.upgradeCooldown.containsKey(key)) {
                final int cooldown = ItemRunicArmorLegacy.upgradeCooldown.get(key);
                if (cooldown <= 0) {
                    ItemRunicArmorLegacy.upgradeCooldown.remove(key);
                }
                else {
                    ItemRunicArmorLegacy.upgradeCooldown.put(key, cooldown - 1);
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
            int feedDes = 0;
            int feedReg = 0;
            int feedEmerg = 0;
            for (int a = 0; a < 4; ++a) {
                if (player.inventory.armorItemInSlot(a) != null && player.inventory.armorItemInSlot(a)
                		.getItem() instanceof ItemRunicArmorLegacy) {
                    
                	if (ItemRunicArmorLegacy.getUpgrade(player.inventory.armorItemInSlot(a)) == 3) {
                        ++feedDes;
                    }
                    else if (ItemRunicArmorLegacy.getUpgrade(player.inventory.armorItemInSlot(a)) == 4) {
                        ++feedReg;
                    }
                    else if (ItemRunicArmorLegacy.getUpgrade(player.inventory.armorItemInSlot(a)) == 6) {
                        ++feedEmerg;
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
                }
                String key = player.getCommandSenderName() + ":" + 3;
                if (runic.size() == 0 && feedDes > 0 && !ItemRunicArmorLegacy.upgradeCooldown.containsKey(key)) {
                    ItemRunicArmorLegacy.upgradeCooldown.put(key, 600);
                    player.worldObj.newExplosion((Entity)player, player.posX, player.posY + player.height / 2.0f, player.posZ, 1.0f + feedDes * 0.5f, false, false);
                }
                
                key = player.getCommandSenderName() + ":" + 4;
                if (runic.size() == 0 && feedReg > 0 && !ItemRunicArmorLegacy.upgradeCooldown.containsKey(key)) {
                    --feedReg;
                    ItemRunicArmorLegacy.upgradeCooldown.put(key, 600);
                    player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, feedReg));
                    player.worldObj.playSoundAtEntity((Entity)player, "thaumcraft:runicShieldEffect", 1.0f, 1.0f);
                }
                
                key = player.getCommandSenderName() + ":" + 6;
                if (runic.size() == 0 && feedEmerg > 0 && !ItemRunicArmorLegacy.upgradeCooldown.containsKey(key)) {
                    ItemRunicArmorLegacy.upgradeCooldown.put(key, 2400);
                    final ArrayList<Integer> runicTemp = new ArrayList<Integer>();
                    for (int a2 = 0; a2 < 4; ++a2) {
                        if (player.inventory.armorItemInSlot(a2) != null && player.inventory.armorItemInSlot(a2).getItem() instanceof ItemRunicArmorLegacy) {
                            final ItemStack is2 = player.inventory.armorItemInSlot(a2);
                            if (is2.getItemDamage() > 0) {
                                runicTemp.add(a2);
                            }
                        }
                    }
                    count = 8 * feedEmerg;
                    while (count > 0 && runicTemp.size() > 0) {
                        final int index2 = count % runicTemp.size();
                        /*player.inventory.armorItemInSlot((int)runicTemp.get(index2))
                        .setItemDamage(player.inventory.armorItemInSlot((int)runicTemp.get(index2))
                        		.getItemDamage() - 1);*/
                        --count;
                        if (player.inventory.armorItemInSlot((int)runicTemp.get(index2)).getItemDamage() == 0) {
                            runicTemp.remove(index2);
                        }
                    }
                    player.worldObj.playSoundAtEntity((Entity)player, "thaumcraft:runicShieldCharge", 1.0f, 1.0f);
                }
            }
        }
    }
    
}

