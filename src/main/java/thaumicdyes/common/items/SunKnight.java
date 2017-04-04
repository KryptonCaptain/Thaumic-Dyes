package thaumicdyes.common.items;

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
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
import thaumcraft.api.IGoggles;
import thaumcraft.api.IRepairable;
import thaumcraft.api.IRunicArmor;
import thaumcraft.api.IVisDiscountGear;
import thaumcraft.api.ItemApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.nodes.IRevealer;
import thaumicdyes.client.models.ModelKnight;

public class SunKnight extends ItemArmor implements IRepairable, IRunicArmor/*, ISpecialArmor*/ {
   public IIcon iconHelm;
   public IIcon iconChest;
   public IIcon iconLegs;
   public IIcon iconChestOver;
   public IIcon iconLegsOver;
   public IIcon iconBlank;
   public IIcon iconHelmOver;
   ModelBiped model1 = null;
   ModelBiped model2 = null;
   ModelBiped model = null;

   public SunKnight(ArmorMaterial enumarmormaterial, int j, int k) {
      super(enumarmormaterial, j, k);
      this.setCreativeTab(CreativeTabs.tabCombat);
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister ir) {
      this.iconHelmOver = ir.registerIcon("thaumicdyes:icon/sun_plate_helm");//
      this.iconChestOver = ir.registerIcon("thaumicdyes:icon/sun_plate_chest");//
      this.iconLegsOver = ir.registerIcon("thaumicdyes:icon/cultist_plate_legs");//
      this.iconBlank = ir.registerIcon("thaumicdyes:blank");
      this.iconChest = ir.registerIcon("thaumicdyes:blank");
      this.iconLegs = ir.registerIcon("thaumicdyes:blank");
      this.iconHelm = ir.registerIcon("thaumicdyes:blank");
   }
   /*
   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
      return type == null?"thaumicdyes:textures/models/cultist_knight_overlay.png":"thaumicdyes:textures/models/cultist_knight_base.png";
   }*/
   
   
   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
	      return "thaumicdyes:textures/models/sun_plate_armor.png";
   }

   @SideOnly(Side.CLIENT)
   public boolean requiresMultipleRenderPasses()
   {
     return true;
   }
   
   //helm over
   public IIcon getIconFromDamageForRenderPass(int par1, int par2) {
     return super.armorType == 2?this.iconLegsOver:(super.armorType == 1?this.iconChestOver:(super.armorType == 0?this.iconHelmOver:(super.armorType == 2?this.iconLegs:(super.armorType == 1?this.iconChest:(super.armorType == 0?this.iconHelm:this.iconBlank)))));
   }
   
   public EnumRarity getRarity(ItemStack itemstack) {
      return EnumRarity.uncommon;
   }

   public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
      return par2ItemStack.isItemEqual(new ItemStack(Items.iron_ingot))?true:super.getIsRepairable(par1ItemStack, par2ItemStack);
   }

   /*
   public void onUpdate(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
      super.onUpdate(stack, world, entity, p_77663_4_, p_77663_5_);
      if(!world.isRemote && stack.isItemDamaged() && entity.ticksExisted % 20 == 0 && entity instanceof EntityLivingBase) {
         stack.damageItem(-1, (EntityLivingBase)entity);
      }

   }

   public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
      super.onArmorTick(world, player, armor);
      if(!world.isRemote && armor.getItemDamage() > 0 && player.ticksExisted % 20 == 0) {
         armor.damageItem(-1, player);
      }

   }*/

   public int getRunicCharge(ItemStack itemstack) {
      return 0;
   }


   @SideOnly(Side.CLIENT)
   public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
      int type = ((ItemArmor)itemStack.getItem()).armorType;
      if(this.model1 == null) {
         this.model1 = new ModelKnight(1.0F);
      }

      if(this.model2 == null) {
         this.model2 = new ModelKnight(0.5F);
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

   /*
   public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
      byte priority = 0;
      double ratio = (double)super.damageReduceAmount / 25.0D;
      if(source.isMagicDamage()) {
         priority = 1;
         ratio = (double)super.damageReduceAmount / 35.0D;
      } else if(source.isUnblockable()) {
         priority = 0;
         ratio = 0.0D;
      }

      return new ArmorProperties(priority, ratio, armor.getMaxDamage() + 1 - armor.getItemDamage());
   }

   public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
      return super.damageReduceAmount;
   }*/

   public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
      if(source != DamageSource.fall) {
         stack.damageItem(damage, entity);
      }

   }

}
