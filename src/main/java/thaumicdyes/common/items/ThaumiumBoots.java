package thaumicdyes.common.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import thaumcraft.api.IRepairable;
import thaumcraft.api.IRunicArmor;
import thaumcraft.api.IVisDiscountGear;
import thaumcraft.api.ItemApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.items.armor.Hover;
import thaumcraft.common.items.armor.ItemBootsTraveller;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ThaumiumBoots extends ItemBootsTraveller implements IRepairable, IVisDiscountGear, IRunicArmor {
	
   //public IIcon iconBoot;
	
   public ThaumiumBoots(ArmorMaterial enumarmormaterial, int j, int k) {
	      super(enumarmormaterial, j, k);
	      this.setCreativeTab(CreativeTabs.tabCombat);
	      MinecraftForge.EVENT_BUS.register(this);
   }
   
   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister ir)
   {
     this.icon = ir.registerIcon("thaumicdyes:bootsThaumiumTrv");
   }
   
   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
   {
     return "thaumicdyes:textures/models/bootsThaumiumTrv.png";
   }
   
   public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
	      return par2ItemStack.isItemEqual(ItemApi.getItem("itemResource", 2))?true:super.getIsRepairable(par1ItemStack, par2ItemStack);
   }
   
   public int getVisDiscount(ItemStack stack, EntityPlayer player, Aspect aspect)
   {
     return 2;
   }
   
   public int getRunicCharge(ItemStack itemstack)
   {
     return 0;
   }
   
   public EnumRarity getRarity(ItemStack itemstack)
   {
     return EnumRarity.rare;
   }
   
   public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
      list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("tc.visdiscount") + ": " + this.getVisDiscount(stack, player, (Aspect)null) + "%");
      super.addInformation(stack, player, list, par4);
   }
   
   public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
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
         float bonus = 0.085F;
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
       player.fallDistance -= 0.35F;
     }
   }
   
   @SubscribeEvent
   public void playerJumps(LivingEvent.LivingJumpEvent event)
   {
     if (((event.entity instanceof EntityPlayer)) && (((EntityPlayer)event.entity).inventory.armorItemInSlot(0) != null) && (((EntityPlayer)event.entity).inventory.armorItemInSlot(0).getItem() == ItemHandler.itemBootsThaumiumTraveller)) {
       event.entityLiving.motionY += 0.2750000059604645D;
     }
   }
	
}
