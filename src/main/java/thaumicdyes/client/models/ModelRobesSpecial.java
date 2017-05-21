package thaumicdyes.client.models;

import java.util.HashMap;
import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import thaumicdyes.common.items.IronFortressArmor;
import thaumicdyes.common.items.runic.ItemRunicArmorPrimal;

public class ModelRobesSpecial extends ModelBiped {
  ModelRenderer Hood1;
  ModelRenderer Hood2;
  ModelRenderer Hood3;
  ModelRenderer Hood4;
  ModelRenderer Chestthing;
  ModelRenderer Mbelt;
  ModelRenderer MbeltB;
  ModelRenderer ClothchestL;
  ModelRenderer ClothchestR;
  ModelRenderer Book;
  ModelRenderer Scroll;
  ModelRenderer BeltR;
  ModelRenderer Backplate;
  ModelRenderer MbeltL;
  ModelRenderer MbeltR;
  ModelRenderer BeltL;
  ModelRenderer Chestplate;
  ModelRenderer ShoulderplateR1;
  ModelRenderer ShoulderplateR2;
  ModelRenderer ShoulderplateR3;
  ModelRenderer ShoulderplateTopR;
  ModelRenderer RArm1;
  ModelRenderer RArm2;
  ModelRenderer RArm3;
  ModelRenderer LArm1;
  ModelRenderer LArm2;
  ModelRenderer LArm3;
  ModelRenderer ShoulderplateL1;
  ModelRenderer ShoulderplateL2;
  ModelRenderer ShoulderplateL3;
  ModelRenderer ShoulderplateTopL;
  ModelRenderer ShoulderL;
  ModelRenderer ShoulderR;
  ModelRenderer ClothBackR3;
  ModelRenderer FrontclothR2;
  ModelRenderer FrontclothR1;
  ModelRenderer SideclothR2;
  ModelRenderer SideclothR1;
  ModelRenderer SideclothR3;
  ModelRenderer ClothBackR1;
  ModelRenderer ClothBackR2;
  ModelRenderer SidepanelR1;
  ModelRenderer LegpanelR6;
  ModelRenderer LegpanelR5;
  ModelRenderer LegpanelR4;
  ModelRenderer FrontclothL2;
  ModelRenderer ClothBackL3;
  ModelRenderer ClothBackL1;
  ModelRenderer FrontclothL1;
  ModelRenderer SideclothL2;
  ModelRenderer SideclothL3;
  ModelRenderer Focipouch;
  ModelRenderer SideclothL1;
  ModelRenderer ClothBackL2;
  ModelRenderer LegpanelL4;
  ModelRenderer LegpanelL5;
  ModelRenderer LegpanelL6;
  ModelRenderer SidepanelL1;
  
  ModelRenderer CloakAtL;
  ModelRenderer CloakAtR;
  ModelRenderer Cloak1;
  ModelRenderer Cloak2;
  ModelRenderer Cloak3;
  
  ModelRenderer BackpanelL1;
  ModelRenderer BackpanelL2;
  ModelRenderer BackpanelL3;
  ModelRenderer BackpanelR1;
  ModelRenderer BackpanelR2;
  ModelRenderer BackpanelR3;
  
  
  private static HashMap hasSet = new HashMap();
  private float partialTicks;

  
  public ModelRobesSpecial(float f)
  {
    super(f, 0.0F, 128, 64);
    this.textureWidth = 128;
    this.textureHeight = 64;
    
    this.Hood1 = new ModelRenderer(this, 16, 7);
    this.Hood1.addBox(-4.5F, -9.0F, -4.6F, 9, 9, 9);
    this.Hood1.setTextureSize(128, 64);
    setRotation(this.Hood1, 0.0F, 0.0F, 0.0F);
    
    this.Hood2 = new ModelRenderer(this, 52, 13);
    this.Hood2.addBox(-4.0F, -9.7F, 2.0F, 8, 9, 3);
    this.Hood2.setTextureSize(128, 64);
    setRotation(this.Hood2, -0.2268928F, 0.0F, 0.0F);
    
    this.Hood3 = new ModelRenderer(this, 52, 14);
    this.Hood3.addBox(-3.5F, -10.0F, 3.5F, 7, 8, 3);
    this.Hood3.setTextureSize(128, 64);
    setRotation(this.Hood3, -0.3490659F, 0.0F, 0.0F);
    
    this.Hood4 = new ModelRenderer(this, 53, 15);
    this.Hood4.addBox(-3.0F, -10.7F, 3.5F, 6, 7, 3);
    this.Hood4.setTextureSize(128, 64);
    setRotation(this.Hood4, -0.5759587F, 0.0F, 0.0F);
    
    this.Chestthing = new ModelRenderer(this, 56, 50);
    this.Chestthing.addBox(-2.5F, 1.0F, -4.0F, 5, 7, 1);
    this.Chestthing.setTextureSize(128, 64);
    setRotation(this.Chestthing, 0.0F, 0.0F, 0.0F);
    
    this.Mbelt = new ModelRenderer(this, 16, 55);
    this.Mbelt.addBox(-4.0F, 7.0F, -3.0F, 8, 5, 1);
    this.Mbelt.setTextureSize(128, 64);
    setRotation(this.Mbelt, 0.0F, 0.0F, 0.0F);
    
    this.MbeltB = new ModelRenderer(this, 16, 55);
    this.MbeltB.addBox(-4.0F, 7.0F, -4.0F, 8, 5, 1);
    this.MbeltB.setTextureSize(128, 64);
    setRotation(this.MbeltB, 0.0F, 3.141593F, 0.0F);
    
    this.ClothchestL = new ModelRenderer(this, 108, 38);
    this.ClothchestL.mirror = true;
    this.ClothchestL.addBox(2.1F, 0.5F, -3.5F, 2, 8, 1);
    this.ClothchestL.setTextureSize(128, 64);
    setRotation(this.ClothchestL, 0.0F, 0.0F, 0.0F);
    
    this.ClothchestR = new ModelRenderer(this, 108, 38);
    this.ClothchestR.addBox(-4.1F, 0.5F, -3.5F, 2, 8, 1);
    this.ClothchestR.setTextureSize(128, 64);
    setRotation(this.ClothchestR, 0.0F, 0.0F, 0.0F);
    
    this.Book = new ModelRenderer(this, 81, 16);
    this.Book.addBox(1.0F, 0.0F, 4.0F, 5, 7, 2);
    this.Book.setTextureSize(128, 64);
    setRotation(this.Book, 0.0F, 0.0F, 0.7679449F);
    
    this.Scroll = new ModelRenderer(this, 78, 25);
    this.Scroll.addBox(-2.0F, 9.5F, 4.0F, 8, 3, 3);
    this.Scroll.setTextureSize(128, 64);
    setRotation(this.Scroll, 0.0F, 0.0F, 0.1919862F);
    
    this.BeltR = new ModelRenderer(this, 16, 36);
    this.BeltR.addBox(-5.0F, 4.0F, -3.0F, 1, 3, 6);
    this.BeltR.setTextureSize(128, 64);
    setRotation(this.BeltR, 0.0F, 0.0F, 0.0F);
    
    this.Backplate = new ModelRenderer(this, 36, 45);
    this.Backplate.addBox(-4.0F, 1.0F, 1.9F, 8, 11, 2);
    this.Backplate.setTextureSize(128, 64);
    setRotation(this.Backplate, 0.0F, 0.0F, 0.0F);
    
    this.MbeltL = new ModelRenderer(this, 16, 36);
    this.MbeltL.addBox(4.0F, 8.0F, -3.0F, 1, 3, 6);
    this.MbeltL.setTextureSize(128, 64);
    setRotation(this.MbeltL, 0.0F, 0.0F, 0.0F);
    
    this.MbeltR = new ModelRenderer(this, 16, 36);
    this.MbeltR.addBox(-5.0F, 8.0F, -3.0F, 1, 3, 6);
    this.MbeltR.setTextureSize(128, 64);
    setRotation(this.MbeltR, 0.0F, 0.0F, 0.0F);
    
    this.BeltL = new ModelRenderer(this, 16, 36);
    this.BeltL.addBox(4.0F, 4.0F, -3.0F, 1, 3, 6);
    this.BeltL.setTextureSize(128, 64);
    setRotation(this.BeltL, 0.0F, 0.0F, 0.0F);
    
    this.Chestplate = new ModelRenderer(this, 16, 25);
    this.Chestplate.addBox(-4.0F, 1.0F, -3.0F, 8, 6, 1);
    this.Chestplate.setTextureSize(128, 64);
    setRotation(this.Chestplate, 0.0F, 0.0F, 0.0F);
    
    this.ShoulderplateR1 = new ModelRenderer(this, 56, 33);
    this.ShoulderplateR1.addBox(-4.5F, -1.5F, -3.5F, 1, 4, 7);
    
    this.ShoulderplateR1.setTextureSize(128, 64);
    setRotation(this.ShoulderplateR1, 0.0F, 0.0F, 0.4363323F);
    
    this.ShoulderplateR2 = new ModelRenderer(this, 40, 33);
    this.ShoulderplateR2.addBox(-3.5F, 1.5F, -3.5F, 1, 3, 7);
    
    this.ShoulderplateR2.setTextureSize(128, 64);
    setRotation(this.ShoulderplateR2, 0.0F, 0.0F, 0.4363323F);
    
    this.ShoulderplateR3 = new ModelRenderer(this, 40, 33);
    this.ShoulderplateR3.addBox(-2.5F, 3.5F, -3.5F, 1, 3, 7);
    
    this.ShoulderplateR3.setTextureSize(128, 64);
    setRotation(this.ShoulderplateR3, 0.0F, 0.0F, 0.4363323F);
    
    this.ShoulderplateTopR = new ModelRenderer(this, 56, 25);
    this.ShoulderplateTopR.addBox(-5.5F, -2.5F, -3.5F, 2, 1, 7);
    
    this.ShoulderplateTopR.setTextureSize(128, 64);
    setRotation(this.ShoulderplateTopR, 0.0F, 0.0F, 0.4363323F);
    
    this.RArm1 = new ModelRenderer(this, 88, 39);
    this.RArm1.addBox(-3.5F, 2.5F, -2.5F, 5, 7, 5);
    
    this.RArm1.setTextureSize(128, 64);
    setRotation(this.RArm1, 0.0F, 0.0F, 0.0F);
    
    this.RArm2 = new ModelRenderer(this, 76, 32);
    this.RArm2.addBox(-3.0F, 5.5F, 2.5F, 4, 4, 2);
    
    this.RArm2.setTextureSize(128, 64);
    setRotation(this.RArm2, 0.0F, 0.0F, 0.0F);
    
    this.RArm3 = new ModelRenderer(this, 88, 32);
    this.RArm3.addBox(-2.5F, 3.5F, 2.5F, 3, 2, 1);
    
    this.RArm3.setTextureSize(128, 64);
    setRotation(this.RArm3, 0.0F, 0.0F, 0.0F);
    
    this.ShoulderplateL1 = new ModelRenderer(this, 56, 33);
    this.ShoulderplateL1.addBox(3.5F, -1.5F, -3.5F, 1, 4, 7);
    
    this.ShoulderplateL1.setTextureSize(128, 64);
    setRotation(this.ShoulderplateL1, 0.0F, 0.0F, -0.4363323F);
    
    this.ShoulderplateL2 = new ModelRenderer(this, 40, 33);
    this.ShoulderplateL2.addBox(2.5F, 1.5F, -3.5F, 1, 3, 7);
    
    this.ShoulderplateL2.setTextureSize(128, 64);
    setRotation(this.ShoulderplateL2, 0.0F, 0.0F, -0.4363323F);
    
    this.ShoulderplateL3 = new ModelRenderer(this, 40, 33);
    this.ShoulderplateL3.addBox(1.5F, 3.5F, -3.5F, 1, 3, 7);
    
    this.ShoulderplateL3.setTextureSize(128, 64);
    setRotation(this.ShoulderplateL3, 0.0F, 0.0F, -0.4363323F);
    
    this.ShoulderplateTopL = new ModelRenderer(this, 56, 25);
    this.ShoulderplateTopL.addBox(3.5F, -2.5F, -3.5F, 2, 1, 7);
    
    this.ShoulderplateTopL.setTextureSize(128, 64);
    setRotation(this.ShoulderplateTopL, 0.0F, 0.0F, -0.4363323F);
    /*
    this.ShoulderR = new ModelRenderer(this, 16, 45);
    this.ShoulderR.mirror = true; //TODO
    this.ShoulderR.addBox(-3.5F, -2.5F, -2.5F, 5, 5, 5);
    
    this.ShoulderR.setTextureSize(128, 64);
    setRotation(this.ShoulderR, 0.0F, 0.0F, 0.0F);
    */
    this.ShoulderR = new ModelRenderer(this, 16, 45);
    this.ShoulderR.addBox(-3.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
    
    this.LArm1 = new ModelRenderer(this, 88, 39);
    this.LArm1.mirror = true;
    this.LArm1.addBox(-1.5F, 2.5F, -2.5F, 5, 7, 5);
    
    this.LArm1.setTextureSize(128, 64);
    setRotation(this.LArm1, 0.0F, 0.0F, 0.0F);
    
    this.LArm2 = new ModelRenderer(this, 76, 32);
    this.LArm2.addBox(-1.0F, 5.5F, 2.5F, 4, 4, 2);
    
    this.LArm2.setTextureSize(128, 64);
    setRotation(this.LArm2, 0.0F, 0.0F, 0.0F);
    
    this.LArm3 = new ModelRenderer(this, 88, 32);
    this.LArm3.addBox(-0.5F, 3.5F, 2.5F, 3, 2, 1);
    
    this.LArm3.setTextureSize(128, 64);
    setRotation(this.LArm3, 0.0F, 0.0F, 0.0F);
    /*
    this.ShoulderL = new ModelRenderer(this, 16, 45);
    this.ShoulderL.addBox(-1.5F, -2.5F, -2.5F, 5, 5, 5);
    
    this.ShoulderL.setTextureSize(128, 64);
    this.ShoulderL.mirror = false; 
    setRotation(this.ShoulderL, 0.0F, 0.0F, 0.0F);
    */
    //TODO
    this.ShoulderL = new ModelRenderer(this, 16, 45);
    this.ShoulderL.mirror = true;
    this.ShoulderL.addBox(-1.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
    
    this.FrontclothR1 = new ModelRenderer(this, 108, 38);
    this.FrontclothR1.addBox(0.0F, 0.0F, 0.0F, 3, 8, 1);
    this.FrontclothR1.setRotationPoint(-3.0F, 11.0F, -2.9F);
    this.FrontclothR1.setTextureSize(128, 64);
    setRotation(this.FrontclothR1, -0.1047198F, 0.0F, 0.0F);
    
    this.FrontclothR2 = new ModelRenderer(this, 108, 47);
    this.FrontclothR2.addBox(0.0F, 7.5F, 1.7F, 3, 3, 1);
    this.FrontclothR2.setRotationPoint(-3.0F, 11.0F, -2.9F);
    this.FrontclothR2.setTextureSize(128, 64);
    setRotation(this.FrontclothR2, -0.3316126F, 0.0F, 0.0F);
    
    this.FrontclothL1 = new ModelRenderer(this, 108, 38);
    this.FrontclothL1.mirror = true;
    this.FrontclothL1.addBox(0.0F, 0.0F, 0.0F, 3, 8, 1);
    this.FrontclothL1.setRotationPoint(0.0F, 11.0F, -2.9F);
    this.FrontclothL1.setTextureSize(128, 64);
    setRotation(this.FrontclothL1, -0.1047198F, 0.0F, 0.0F);
    
    this.FrontclothL2 = new ModelRenderer(this, 108, 47);
    this.FrontclothL2.mirror = true;
    this.FrontclothL2.addBox(0.0F, 7.5F, 1.7F, 3, 3, 1);
    this.FrontclothL2.setRotationPoint(0.0F, 11.0F, -2.9F);
    this.FrontclothL2.setTextureSize(128, 64);
    setRotation(this.FrontclothL2, -0.3316126F, 0.0F, 0.0F);
    
    this.ClothBackR1 = new ModelRenderer(this, 118, 16);
    this.ClothBackR1.mirror = true;
    this.ClothBackR1.addBox(0.0F, 0.0F, 0.0F, 4, 8, 1);
    this.ClothBackR1.setRotationPoint(-4.0F, 11.5F, 2.9F);
    this.ClothBackR1.setTextureSize(128, 64);
    setRotation(this.ClothBackR1, 0.1047198F, 0.0F, 0.0F);
    
    this.ClothBackR2 = new ModelRenderer(this, 123, 9);
    this.ClothBackR2.addBox(0.0F, 7.8F, -0.9F, 1, 2, 1);
    this.ClothBackR2.setRotationPoint(-4.0F, 11.5F, 2.9F);
    this.ClothBackR2.setTextureSize(128, 64);
    setRotation(this.ClothBackR2, 0.2268928F, 0.0F, 0.0F);
    
    this.ClothBackR3 = new ModelRenderer(this, 120, 12);
    this.ClothBackR3.mirror = true;
    this.ClothBackR3.addBox(1.0F, 7.8F, -0.9F, 3, 3, 1);
    this.ClothBackR3.setRotationPoint(-4.0F, 11.5F, 2.9F);
    this.ClothBackR3.setTextureSize(128, 64);
    setRotation(this.ClothBackR3, 0.2268928F, 0.0F, 0.0F);
    
    this.ClothBackL1 = new ModelRenderer(this, 118, 16);
    this.ClothBackL1.addBox(0.0F, 0.0F, 0.0F, 4, 8, 1);
    this.ClothBackL1.setRotationPoint(0.0F, 11.5F, 2.9F);
    this.ClothBackL1.setTextureSize(128, 64);
    setRotation(this.ClothBackL1, 0.1047198F, 0.0F, 0.0F);
    
    this.ClothBackL2 = new ModelRenderer(this, 123, 9);
    this.ClothBackL2.mirror = true;
    this.ClothBackL2.addBox(3.0F, 7.8F, -0.9F, 1, 2, 1);
    this.ClothBackL2.setRotationPoint(0.0F, 11.5F, 2.9F);
    this.ClothBackL2.setTextureSize(128, 64);
    setRotation(this.ClothBackL2, 0.2268928F, 0.0F, 0.0F);
    
    this.ClothBackL3 = new ModelRenderer(this, 120, 12);
    this.ClothBackL3.addBox(0.0F, 7.8F, -0.9F, 3, 3, 1);
    this.ClothBackL3.setRotationPoint(0.0F, 11.5F, 2.9F);
    this.ClothBackL3.setTextureSize(128, 64);
    setRotation(this.ClothBackL3, 0.2268928F, 0.0F, 0.0F);
    
    this.SideclothL2 = new ModelRenderer(this, 116, 34);
    this.SideclothL2.addBox(0.5F, 5.5F, -2.5F, 1, 3, 5);
    
    this.SideclothL2.setTextureSize(128, 64);
    setRotation(this.SideclothL2, 0.0F, 0.0F, -0.296706F);
    
    this.SideclothR1 = new ModelRenderer(this, 116, 42);
    this.SideclothR1.addBox(-2.5F, 0.5F, -2.5F, 1, 5, 5);
    
    this.SideclothR1.setTextureSize(128, 64);
    setRotation(this.SideclothR1, 0.0F, 0.0F, 0.122173F);
    
    this.SideclothR2 = new ModelRenderer(this, 116, 34);
    this.SideclothR2.addBox(-1.5F, 5.5F, -2.5F, 1, 3, 5);
    
    this.SideclothR2.setTextureSize(128, 64);
    setRotation(this.SideclothR2, 0.0F, 0.0F, 0.296706F);
    
    this.SideclothR3 = new ModelRenderer(this, 116, 1);
    this.SideclothR3.addBox(0.4F, 8.4F, -2.5F, 1, 3, 5);
    
    this.SideclothR3.setTextureSize(128, 64);
    setRotation(this.SideclothR3, 0.0F, 0.0F, 0.5235988F);
    
    this.SidepanelR1 = new ModelRenderer(this, 116, 25);
    this.SidepanelR1.addBox(-2.5F, 0.5F, -2.5F, 1, 4, 5);
    
    this.SidepanelR1.setTextureSize(128, 64);
    this.SidepanelR1.mirror = true;
    setRotation(this.SidepanelR1, 0.0F, 0.0F, 0.4363323F);
    
    this.LegpanelR6 = new ModelRenderer(this, 82, 38);
    this.LegpanelR6.addBox(-3.0F, 4.5F, -1.5F, 2, 3, 1);
    
    this.LegpanelR6.setTextureSize(128, 64);
    setRotation(this.LegpanelR6, -0.4363323F, 0.0F, 0.0F);
    
    this.LegpanelR5 = new ModelRenderer(this, 76, 42);
    this.LegpanelR5.addBox(-3.0F, 2.5F, -2.5F, 2, 3, 1);
    
    this.LegpanelR5.setTextureSize(128, 64);
    setRotation(this.LegpanelR5, -0.4363323F, 0.0F, 0.0F);
    
    this.LegpanelR4 = new ModelRenderer(this, 76, 38);
    this.LegpanelR4.addBox(-3.0F, 0.5F, -3.5F, 2, 3, 1);
    
    this.LegpanelR4.setTextureSize(128, 64);
    setRotation(this.LegpanelR4, -0.4363323F, 0.0F, 0.0F);
    
    this.SideclothL3 = new ModelRenderer(this, 116, 1);
    this.SideclothL3.addBox(-1.4F, 8.4F, -2.5F, 1, 3, 5);
    
    this.SideclothL3.setTextureSize(128, 64);
    setRotation(this.SideclothL3, 0.0F, 0.0F, -0.5235988F);
    
    this.Focipouch = new ModelRenderer(this, 100, 20);
    this.Focipouch.addBox(3.5F, 0.5F, -2.5F, 3, 6, 5);
    
    this.Focipouch.setTextureSize(128, 64);
    setRotation(this.Focipouch, 0.0F, 0.0F, -0.122173F);
    
    this.SideclothL1 = new ModelRenderer(this, 116, 42);
    this.SideclothL1.addBox(1.5F, 0.5F, -2.5F, 1, 5, 5);
    
    this.SideclothL1.setTextureSize(128, 64);
    setRotation(this.SideclothL1, 0.0F, 0.0F, -0.122173F);
    
    this.LegpanelL4 = new ModelRenderer(this, 76, 38);
    this.LegpanelL4.mirror = true;
    this.LegpanelL4.addBox(1.0F, 0.5F, -3.5F, 2, 3, 1);
    
    this.LegpanelL4.setTextureSize(128, 64);
    setRotation(this.LegpanelL4, -0.4363323F, 0.0F, 0.0F);
    
    this.LegpanelL5 = new ModelRenderer(this, 76, 42);
    this.LegpanelL5.mirror = true;
    this.LegpanelL5.addBox(1.0F, 2.5F, -2.5F, 2, 3, 1);
    
    this.LegpanelL5.setTextureSize(128, 64);
    setRotation(this.LegpanelL5, -0.4363323F, 0.0F, 0.0F);
    
    this.LegpanelL6 = new ModelRenderer(this, 82, 38);
    this.LegpanelL6.mirror = true;
    this.LegpanelL6.addBox(1.0F, 4.5F, -1.5F, 2, 3, 1);
    
    this.LegpanelL6.setTextureSize(128, 64);
    setRotation(this.LegpanelL6, -0.4363323F, 0.0F, 0.0F);
    
    this.SidepanelL1 = new ModelRenderer(this, 116, 25);
    this.SidepanelL1.addBox(1.5F, 0.5F, -2.5F, 1, 4, 5);
    
    this.SidepanelL1.setTextureSize(128, 64);
    setRotation(this.SidepanelL1, 0.0F, 0.0F, -0.4363323F);
    
    //TODO MOD
    this.CloakAtL = new ModelRenderer(this, 78, 4);
    this.CloakAtL.addBox(2.5F, 1.0F, 2.0F, 2, 1, 3);
    this.CloakAtL.setTextureSize(128, 64);
    setRotation(this.CloakAtL, 0.1396263F, 0.0F, 0.0F);
    
    /*
    this.Cloak1 = new ModelRenderer(this, 78, 8);
    this.Cloak1.addBox(0.0F, 0.0F, 0.0F, 9, 12, 1);
    this.Cloak1.setRotationPoint(-4.5F, 1.3F, 4.2F);
    this.Cloak1.setTextureSize(128, 64);
    setRotation(this.Cloak1, 0.1396263F, 0.0F, 0.0F);
    this.Cloak2 = new ModelRenderer(this, 78, 20);
    this.Cloak2.addBox(0.0F, 11.7F, -2.0F, 9, 4, 1);
    this.Cloak2.setRotationPoint(-4.5F, 1.3F, 4.2F);
    this.Cloak2.setTextureSize(128, 64);
    setRotation(this.Cloak2, 0.3069452F, 0.0F, 0.0F);
    this.Cloak3 = new ModelRenderer(this, 78, 20);
    this.Cloak3.addBox(0.0F, 15.2F, -4.2F, 9, 4, 1);
    this.Cloak3.setRotationPoint(-4.5F, 1.3F, 4.2F);
    this.Cloak3.setTextureSize(128, 64);
    setRotation(this.Cloak3, 0.4465716F, 0.0F, 0.0F);
     */
    //modded
    this.Cloak1 = new ModelRenderer(this, 78, 8);
    this.Cloak1.addBox(0.0F, 0.0F, 0.0F, 9, 12, 1);
    this.Cloak1.setRotationPoint(-4.5F, 1.3F, 4.2F);
    this.Cloak1.setTextureSize(128, 64);
    setRotation(this.Cloak1, 0.1396263F, 0.0F, 0.0F);
    this.Cloak2 = new ModelRenderer(this, 78, 20);
    this.Cloak2.addBox(4.5F, 10.7F, -1.6F, 9, 4, 1);
    this.Cloak2.setRotationPoint(-4.5F, 1.3F, 0.0F);
    this.Cloak2.setTextureSize(128, 64);
    setRotation(this.Cloak2, 0.15F, 0.0F, 0.0F);
    this.Cloak3 = new ModelRenderer(this, 78, 20);
    this.Cloak3.addBox(9F, 12.8F, -4.4F, 9, 4, 1);
    this.Cloak3.setRotationPoint(-4.5F, 1.3F, 0F);
    this.Cloak3.setTextureSize(128, 64);
    setRotation(this.Cloak3, 0.22F, 0.0F, 0.0F);
    
    this.CloakAtR = new ModelRenderer(this, 78, 4);
    this.CloakAtR.addBox(-4.5F, 1.0F, 2.0F, 2, 1, 3);
    this.CloakAtR.setTextureSize(128, 64);
    setRotation(this.CloakAtR, 0.1396263F, 0.0F, 0.0F);
    
    this.BackpanelL1 = new ModelRenderer(this, 0, 18);
    this.BackpanelL1.mirror = true;
    this.BackpanelL1.addBox(-2.0F, 0.5F, 2.5F, 5, 3, 1);
    this.BackpanelL1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.BackpanelL1.setTextureSize(128, 64);
    this.setRotation(this.BackpanelL1, 0.4363323F, 0.0F, 0.0F);
    this.BackpanelL2 = new ModelRenderer(this, 0, 18);
    this.BackpanelL2.mirror = true;
    this.BackpanelL2.addBox(-2.0F, 2.5F, 1.5F, 5, 3, 1);
    this.BackpanelL2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.BackpanelL2.setTextureSize(128, 64);
    this.setRotation(this.BackpanelL2, 0.4363323F, 0.0F, 0.0F);
    this.BackpanelL3 = new ModelRenderer(this, 0, 18);
    this.BackpanelL3.mirror = true;
    this.BackpanelL3.addBox(-2.0F, 4.5F, 0.5F, 5, 3, 1);
    this.BackpanelL3.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.BackpanelL3.setTextureSize(128, 64);
    this.setRotation(this.BackpanelL3, 0.4363323F, 0.0F, 0.0F);
    
    this.BackpanelR1 = new ModelRenderer(this, 0, 18);
    this.BackpanelR1.addBox(-3.0F, 0.5F, 2.5F, 5, 3, 1);
    this.BackpanelR1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.BackpanelR1.setTextureSize(128, 64);
    this.setRotation(this.BackpanelR1, 0.4363323F, 0.0F, 0.0F);
    this.BackpanelR2 = new ModelRenderer(this, 0, 18);
    this.BackpanelR2.addBox(-3.0F, 2.5F, 1.5F, 5, 3, 1);
    this.BackpanelR2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.BackpanelR2.setTextureSize(128, 64);
    this.setRotation(this.BackpanelR2, 0.4363323F, 0.0F, 0.0F);
    this.BackpanelR3 = new ModelRenderer(this, 0, 18);
    this.BackpanelR3.addBox(-3.0F, 4.5F, 0.5F, 5, 3, 1);
    this.BackpanelR3.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.BackpanelR3.setTextureSize(128, 64);
    this.setRotation(this.BackpanelR3, 0.4363323F, 0.0F, 0.0F);
    
    
    
    this.Cloak1.addChild(this.Cloak2);
    this.Cloak2.addChild(this.Cloak3);
    
    this.bipedHeadwear.cubeList.clear();
    this.bipedHead.cubeList.clear();
    this.bipedHead.addChild(this.Hood1);
    this.bipedHead.addChild(this.Hood2);
    this.bipedHead.addChild(this.Hood3);
    this.bipedHead.addChild(this.Hood4);
    
    this.bipedBody.cubeList.clear();
    this.bipedRightLeg.cubeList.clear();
    this.bipedLeftLeg.cubeList.clear();
    this.bipedBody.addChild(this.Mbelt);
    this.bipedBody.addChild(this.MbeltB);
    this.bipedBody.addChild(this.MbeltL);
    this.bipedBody.addChild(this.MbeltR);
    
    
    
    if (f < 1.0F)
    {
      this.bipedLeftLeg.addChild(this.Focipouch);
      this.bipedBody.addChild(this.FrontclothR1);
      this.bipedBody.addChild(this.FrontclothR2);
      this.bipedBody.addChild(this.FrontclothL1);
      this.bipedBody.addChild(this.FrontclothL2);
      
      this.bipedBody.addChild(this.ClothBackR1);
      this.bipedBody.addChild(this.ClothBackR2);
      this.bipedBody.addChild(this.ClothBackR3);
      
      this.bipedBody.addChild(this.ClothBackL1);
      this.bipedBody.addChild(this.ClothBackL2);
      this.bipedBody.addChild(this.ClothBackL3);
    }
    else
    {
      this.bipedBody.addChild(this.Chestplate);
      this.bipedBody.addChild(this.Chestthing);
      this.bipedBody.addChild(this.Scroll);
      this.bipedBody.addChild(this.Backplate);
      this.bipedBody.addChild(this.Book);
      this.bipedBody.addChild(this.ClothchestL);
      this.bipedBody.addChild(this.ClothchestR);
      
      this.bipedBody.addChild(this.Cloak1);
      //this.bipedBody.addChild(this.Cloak2);
      //this.bipedBody.addChild(this.Cloak3);
      this.bipedBody.addChild(this.CloakAtL);
      this.bipedBody.addChild(this.CloakAtR);
    }
    this.bipedRightArm.cubeList.clear();
    this.bipedRightArm.addChild(this.ShoulderR);
    this.bipedRightArm.addChild(this.RArm1);
    this.bipedRightArm.addChild(this.RArm2);
    this.bipedRightArm.addChild(this.RArm3);
    this.bipedRightArm.addChild(this.ShoulderplateTopR);
    this.bipedRightArm.addChild(this.ShoulderplateR1);
    this.bipedRightArm.addChild(this.ShoulderplateR2);
    this.bipedRightArm.addChild(this.ShoulderplateR3);
    
    this.bipedLeftArm.cubeList.clear();
    this.bipedLeftArm.addChild(this.ShoulderL);
    this.bipedLeftArm.addChild(this.LArm1);
    this.bipedLeftArm.addChild(this.LArm2);
    this.bipedLeftArm.addChild(this.LArm3);
    this.bipedLeftArm.addChild(this.ShoulderplateTopL);
    this.bipedLeftArm.addChild(this.ShoulderplateL1);
    this.bipedLeftArm.addChild(this.ShoulderplateL2);
    this.bipedLeftArm.addChild(this.ShoulderplateL3);
    
    this.bipedRightLeg.addChild(this.LegpanelR4);
    this.bipedRightLeg.addChild(this.LegpanelR5);
    this.bipedRightLeg.addChild(this.LegpanelR6);
    this.bipedRightLeg.addChild(this.SidepanelR1);
    
    this.bipedRightLeg.addChild(this.SideclothR1);
    this.bipedRightLeg.addChild(this.SideclothR2);
    this.bipedRightLeg.addChild(this.SideclothR3);
    
    this.bipedRightLeg.addChild(this.BackpanelR1);
    this.bipedRightLeg.addChild(this.BackpanelR2);
    this.bipedRightLeg.addChild(this.BackpanelR3);
    
    this.bipedLeftLeg.addChild(this.LegpanelL4);
    this.bipedLeftLeg.addChild(this.LegpanelL5);
    this.bipedLeftLeg.addChild(this.LegpanelL6);
    this.bipedLeftLeg.addChild(this.SidepanelL1);
    
    this.bipedLeftLeg.addChild(this.SideclothL1);
    this.bipedLeftLeg.addChild(this.SideclothL2);
    this.bipedLeftLeg.addChild(this.SideclothL3);
    
    this.bipedLeftLeg.addChild(this.BackpanelL1);
    this.bipedLeftLeg.addChild(this.BackpanelL2);
    this.bipedLeftLeg.addChild(this.BackpanelL3);
    
    
  }
  
  
  private void checkSet(Entity entity) {
      if(entity instanceof EntityLivingBase && entity.ticksExisted % 20 == 0) {
         int set = 0;

         for(int a = 0; a < 4; a++) {
            ItemStack piece = ((EntityLivingBase)entity).getEquipmentInSlot(a + 1);
            if(piece != null && piece.getItem() instanceof ItemRunicArmorPrimal) {
               set++;
            }
         }

         if(set > 0) {
            hasSet.put(Integer.valueOf(entity.getEntityId()), Integer.valueOf(set));
         } else {
            hasSet.remove(Integer.valueOf(entity.getEntityId()));
         }
      }

   }
  
  public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
  {
    this.partialTicks = p_78086_4_;
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
  	this.checkSet(entity);
	int set = hasSet.containsKey(Integer.valueOf(entity.getEntityId()))?((Integer)hasSet.get(Integer.valueOf(entity.getEntityId()))).intValue():-1;
	//System.out.println("set "+set);
	
	/*
	put 
	this.OrnamentL.isHidden = set < 3;
	etc here
	*/
	
	this.Hood1.isHidden = set < 4;
	this.Hood2.isHidden = set < 4;
	this.Hood3.isHidden = set < 4;
	this.Hood4.isHidden = set < 4;
	this.Chestthing.isHidden = set < 4;
	this.Mbelt.isHidden = set < 4;
	this.MbeltB.isHidden = set < 4;
	this.ClothchestL.isHidden = set < 4;
	this.ClothchestR.isHidden = set < 4;
	this.BeltR.isHidden = set < 4;
	this.Backplate.isHidden = set < 4;
	this.MbeltL.isHidden = set < 4;
	this.MbeltR.isHidden = set < 4;
	this.BeltL.isHidden = set < 4;
	this.Chestplate.isHidden = set < 4;
	this.ShoulderplateR1.isHidden = set < 4;
	this.ShoulderplateR2.isHidden = set < 4;
	this.ShoulderplateR3.isHidden = set < 4;
	this.ShoulderplateTopR.isHidden = set < 4;
	this.RArm1.isHidden = set < 4;
	this.RArm2.isHidden = set < 4;
	this.RArm3.isHidden = set < 4;
	this.LArm1.isHidden = set < 4;
	this.LArm2.isHidden = set < 4;
	this.LArm3.isHidden = set < 4;
	this.ShoulderplateL1.isHidden = set < 4;
	this.ShoulderplateL2.isHidden = set < 4;
	this.ShoulderplateL3.isHidden = set < 4;
	this.ShoulderplateTopL.isHidden = set < 4;
	this.ShoulderL.isHidden = set < 4;
	this.ShoulderR.isHidden = set < 4;
	this.FrontclothR2.isHidden = set < 4;
	this.FrontclothR1.isHidden = set < 4;
	this.SideclothR2.isHidden = set < 4;
	this.SideclothR1.isHidden = set < 4;
	this.SideclothR3.isHidden = set < 4;
	this.SidepanelR1.isHidden = set < 4;
	this.LegpanelR6.isHidden = set < 4;
	this.LegpanelR5.isHidden = set < 4;
	this.LegpanelR4.isHidden = set < 4;
	this.FrontclothL2.isHidden = set < 4;
	this.FrontclothL1.isHidden = set < 4;
	this.SideclothL2.isHidden = set < 4;
	this.SideclothL3.isHidden = set < 4;
	this.SideclothL1.isHidden = set < 4;
	this.LegpanelL4.isHidden = set < 4;
	this.LegpanelL5.isHidden = set < 4;
	this.LegpanelL6.isHidden = set < 4;
	this.SidepanelL1.isHidden = set < 4;
	
	this.CloakAtL.isHidden = set < 4;
	this.CloakAtR.isHidden = set < 4;
	this.Cloak1.isHidden = set < 4;
	this.Cloak2.isHidden = set < 4;
	this.Cloak3.isHidden = set < 4;
	
	
	
	this.ClothBackL1.isHidden = true;
	this.ClothBackL2.isHidden = true;
	this.ClothBackL3.isHidden = true;
	this.ClothBackR1.isHidden = true;
	this.ClothBackR2.isHidden = true;
	this.ClothBackR3.isHidden = true;
	
	this.BackpanelR3.isHidden = true;
	this.BackpanelL3.isHidden = true;
	
	this.Scroll.isHidden = true;
	this.Book.isHidden = true;
	this.Focipouch.isHidden = true;
	
	if (((entity instanceof EntitySkeleton)) || ((entity instanceof EntityZombie))) {
	  setRotationAnglesZombie(f, f1, f2, f3, f4, f5, entity);
	} else {
	  setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
	float a = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
	float b = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
	float c = Math.min(a, b);
	
	//TODO special rotations
	this.FrontclothR1.rotateAngleX = (this.FrontclothL1.rotateAngleX = c - 0.1047198F);
	this.FrontclothR2.rotateAngleX = (this.FrontclothL2.rotateAngleX = c - 0.3316126F);
	
	//this.ClothBackR1.rotateAngleX = (this.ClothBackL1.rotateAngleX = -c + 0.1047198F);
	//this.ClothBackR2.rotateAngleX = (this.ClothBackL2.rotateAngleX = this.ClothBackR3.rotateAngleX = this.ClothBackL3.rotateAngleX = -c + 0.2268928F);
	
	/*
	this.Cloak1.rotateAngleX = (-c / 2.0F + 0.1396263F);
    this.Cloak2.rotateAngleX = (-c / 2.0F + 0.3069452F);
    this.Cloak3.rotateAngleX = (-c / 2.0F + 0.4465716F);
	*/
	this.Cloak1.rotateAngleX = (0.2F + MathHelper.sin((entity.ticksExisted + this.partialTicks) / 7.0F) * 0.08F);
    //this.Cloak2.rotateAngleX = (MathHelper.sin((entity.ticksExisted + this.partialTicks - 5.0F) / 7.0F) * 0.1F);
    //this.Cloak3.rotateAngleX = (MathHelper.sin((entity.ticksExisted + this.partialTicks - 10.0F) / 7.0F) * 0.12F);
	
	GL11.glEnable(3042);
    GL11.glAlphaFunc(516, 0.003921569F);
    GL11.glBlendFunc(770, 771);
	
	if (this.isChild)
	{
	  float f6 = 2.0F;
	  GL11.glPushMatrix();
	  GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
	  GL11.glTranslatef(0.0F, 16.0F * f5, 0.0F);
	  
	  this.bipedHead.render(f5);
	  
	  GL11.glPopMatrix();
	  GL11.glPushMatrix();
	  GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
	  GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
	  this.bipedBody.render(f5);
	  this.bipedRightArm.render(f5);
	  this.bipedLeftArm.render(f5);
	  this.bipedRightLeg.render(f5);
	  this.bipedLeftLeg.render(f5);
	  
	  this.bipedHeadwear.render(f5);
	  
	  GL11.glPopMatrix();
	}
	else
	{
	  GL11.glPushMatrix();
	  GL11.glScalef(1.01F, 1.01F, 1.01F);
	  
	  this.bipedHead.render(f5);
	  GL11.glPopMatrix();
	  this.bipedBody.render(f5);
	  this.bipedRightArm.render(f5);
	  this.bipedLeftArm.render(f5);
	  this.bipedRightLeg.render(f5);
	  this.bipedLeftLeg.render(f5);
	  this.bipedHeadwear.render(f5);
	}
	
	GL11.glDisable(3042);
	GL11.glAlphaFunc(516, 0.1F);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAnglesZombie(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
  {
    super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
    
    float f6 = MathHelper.sin(this.onGround * 3.1415927F);
    float f7 = MathHelper.sin((1.0F - (1.0F - this.onGround) * (1.0F - this.onGround)) * 3.1415927F);
    
    this.bipedRightArm.rotateAngleZ = 0.0F;
    this.bipedLeftArm.rotateAngleZ = 0.0F;
    this.bipedRightArm.rotateAngleY = (-(0.1F - f6 * 0.6F));
    this.bipedLeftArm.rotateAngleY = (0.1F - f6 * 0.6F);
    this.bipedRightArm.rotateAngleX = -1.5707964F;
    this.bipedLeftArm.rotateAngleX = -1.5707964F;
    this.bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
    this.bipedLeftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
    this.bipedRightArm.rotateAngleZ += MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
    this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
    this.bipedRightArm.rotateAngleX += MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
    this.bipedLeftArm.rotateAngleX -= MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
  }
}

