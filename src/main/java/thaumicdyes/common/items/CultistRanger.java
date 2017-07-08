package thaumicdyes.common.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
import thaumcraft.api.IGoggles;
import thaumcraft.api.IRepairable;
import thaumcraft.api.IRunicArmor;
import thaumcraft.api.IVisDiscountGear;
import thaumcraft.api.IWarpingGear;
import thaumcraft.api.ItemApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.nodes.IRevealer;
import thaumicdyes.client.models.ModelRanger2;

public class CultistRanger extends ItemArmor implements IRepairable, IRunicArmor, IVisDiscountGear, IWarpingGear/*, ISpecialArmor*/ {
   public IIcon iconHelm;
   public IIcon iconChest;
   public IIcon iconLegs;
   public IIcon iconChestOver;
   public IIcon iconLegsOver;
   public IIcon iconBlank;
   public IIcon iconHelmOver;

   public CultistRanger(ArmorMaterial enumarmormaterial, int j, int k) {
      super(enumarmormaterial, j, k);
      this.setCreativeTab(CreativeTabs.tabCombat);
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister ir) {
      this.iconHelm = ir.registerIcon("thaumicdyes:icon/cultist_ranger_helm"); //
      this.iconChest = ir.registerIcon("thaumicdyes:icon/cultist_ranger_chest2"); //
      this.iconLegs = ir.registerIcon("thaumicdyes:icon/cultist_ranger_legs2"); //
   }

   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
      return "thaumicdyes:textures/models/cultist_ranger_armor.png";
   }
   
   @SideOnly(Side.CLIENT)
   public IIcon getIconFromDamage(int par1)
   {
     return this.armorType == 1 ? this.iconChest : this.armorType == 0 ? this.iconHelm : this.iconLegs;
   }

   public EnumRarity getRarity(ItemStack itemstack) {
      return EnumRarity.uncommon;
   }
   
   public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
      return par2ItemStack.isItemEqual(new ItemStack(Items.iron_ingot))?true:super.getIsRepairable(par1ItemStack, par2ItemStack);
   }
   

   public int getRunicCharge(ItemStack itemstack) {
      return 0;
   }


   public int getVisDiscount(ItemStack stack, EntityPlayer player, Aspect aspect) {
	   return this.armorType == 0 ? 0 : 1;
   }
   
   public int getWarp(ItemStack itemstack, EntityPlayer player) {
	      return 1;
   }
   

   ModelBiped model1 = null;
   ModelBiped model2 = null;
   ModelBiped model = null;
   
   @SideOnly(Side.CLIENT)
   public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
      int type = ((ItemArmor)itemStack.getItem()).armorType;
      if(this.model1 == null) {
         this.model1 = new ModelRanger2(1.0F);
      }

      if(this.model2 == null) {
         this.model2 = new ModelRanger2(0.5F);
      }

      if(type != 1 && type != 3) {
         this.model = this.model2;
      } else {
         this.model = this.model1;
      }

      if(this.model != null) {
         this.model.bipedHead.showModel = armorSlot == 0;
         this.model.bipedHeadwear.showModel = armorSlot == 0;
         this.model.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
         this.model.bipedRightArm.showModel = armorSlot == 1;
         this.model.bipedLeftArm.showModel = armorSlot == 1;
         this.model.bipedRightLeg.showModel = armorSlot == 2;
         this.model.bipedLeftLeg.showModel = armorSlot == 2;
         this.model.isSneak = entityLiving.isSneaking();
         this.model.isRiding = entityLiving.isRiding();
         this.model.isChild = entityLiving.isChild();
         this.model.aimedBow = false;
         this.model.heldItemRight = entityLiving.getHeldItem() != null?1:0;
         if(entityLiving instanceof EntityPlayer && ((EntityPlayer)entityLiving).getItemInUseDuration() > 0) {
            EnumAction enumaction = ((EntityPlayer)entityLiving).getItemInUse().getItemUseAction();
            if(enumaction == EnumAction.block) {
               this.model.heldItemRight = 3;
            } else if(enumaction == EnumAction.bow) {
               this.model.aimedBow = true;
            }
         }
      }

      return this.model;
   }

  
   public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
      if(source != DamageSource.fall) {
         stack.damageItem(damage, entity);
      }

   }
   
   public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
   {
	   if ((stack.hasTagCompound()) && (stack.stackTagCompound.hasKey("mask")) && (stack.stackTagCompound.getInteger("mask") == 0)) {
		   list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("item.ItemGoggles.name"));
	   }
	   if ((stack.hasTagCompound()) && (stack.stackTagCompound.hasKey("mask"))) {
		   list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal(new StringBuilder().append("item.HelmetCultistRanger.mask.").append(stack.stackTagCompound.getInteger("mask")).toString()));
       }
	   if (getVisDiscount(stack, player, null) > 0) {
		   list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("tc.visdiscount") + ": " + getVisDiscount(stack, player, null) + "%");
	   }
	   super.addInformation(stack, player, list, par4);
   }
   
   public boolean showNodes(ItemStack itemstack, EntityLivingBase player)
   {
     return ((itemstack.hasTagCompound()) && (itemstack.stackTagCompound.hasKey("mask")) && (itemstack.stackTagCompound.getInteger("mask") == 0));
   }
   
   public boolean showIngamePopups(ItemStack itemstack, EntityLivingBase player)
   {
     return ((itemstack.hasTagCompound()) && (itemstack.stackTagCompound.hasKey("mask")) && (itemstack.stackTagCompound.getInteger("mask") == 0));
   }
      
}
