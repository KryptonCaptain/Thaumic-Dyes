package thaumicdyes.client.models;

import java.util.HashMap;

import org.lwjgl.opengl.GL11;

import thaumicdyes.common.items.RangerArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

/**
 * Cultist_ranger.tcn - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
public class ModelRanger extends ModelBiped {
	
	ModelRenderer Helmet;
	ModelRenderer[] Mask;
    ModelRenderer capsthingy;
    ModelRenderer HelmetB;
    ModelRenderer HelmetR;
    ModelRenderer HelmetL;
    ModelRenderer Chestthing;
    ModelRenderer Mbelt;
    ModelRenderer clothchestL;
    ModelRenderer clothchestR;
    ModelRenderer BeltR;
    ModelRenderer BackpackRoll;
    ModelRenderer MbeltL;
    ModelRenderer MbeltR;
    ModelRenderer BeltL;
    ModelRenderer Chestplate;
    ModelRenderer Backplate;
    ModelRenderer Backpack;
    ModelRenderer ShoulderplateR1;
    ModelRenderer ShoulderplateR2;
    ModelRenderer ShoulderplateR3;
    ModelRenderer ShoulderplateTopR;
    ModelRenderer ShoulderR;
    ModelRenderer ShoulderplateL1;
    ModelRenderer ShoulderplateL2;
    ModelRenderer ShoulderplateL3;
    ModelRenderer ShoulderplateLtop;
    ModelRenderer ShoulderL;

    ModelRenderer bottleR3;
    ModelRenderer bottleR2;
    ModelRenderer bottleR1;

    ModelRenderer bottleL1;
    ModelRenderer bottleL2;
    ModelRenderer bottleL3;
    
	ModelRenderer FrontclothR1;
	ModelRenderer FrontclothR2;
	ModelRenderer FrontclothL1;
	ModelRenderer FrontclothL2;
	ModelRenderer ClothBackR1;
	ModelRenderer ClothBackR2;
	ModelRenderer ClothBackR3;
	ModelRenderer ClothBackL1;
	ModelRenderer ClothBackL2;
	ModelRenderer ClothBackL3;
	ModelRenderer SideclothL2;
	ModelRenderer SideclothR1;
	ModelRenderer SideclothR3;
	ModelRenderer SideclothR2;
	ModelRenderer SidepanelR1;
	ModelRenderer LegpanelR6;
	ModelRenderer LegpanelR5;
	ModelRenderer LegpanelR4;
	ModelRenderer SideclothL3;
	ModelRenderer SideclothL1;
	ModelRenderer SidepanelL1;
	ModelRenderer LegpanelL6;
	ModelRenderer LegpanelL5;
	ModelRenderer LegpanelL4;

    
    private static HashMap hasMask = new HashMap();

    public ModelRanger(float f) {
    	this.textureWidth = 128;
    	this.textureHeight = 64;
        
    	this.Mask = new ModelRenderer[2];
    	
    	this.Mask[0] = new ModelRenderer(this, 74, 3);
    	this.Mask[0].setRotationPoint(0.0F, 0.0F, 0.0F);
    	this.Mask[0].addBox(-4.5F, -5.0F, -4.6F, 9, 5, 1);
       
        this.Mask[1] = new ModelRenderer(this, 96, 3);
        this.Mask[1].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Mask[1].addBox(-4.5F, -5.0F, -4.6F, 9, 5, 1);
        
        /*
        this.Mask = new ModelRenderer(this, 96, 3);
        this.Mask.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Mask.addBox(-4.5F, -5.0F, -4.599999904632568F, 9, 5, 1, 0.0F);
         */
        
        this.Helmet = new ModelRenderer(this, 36, 6);
        this.Helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Helmet.addBox(-4.5F, -9.0F, -4.5F, 9, 4, 9, 0.0F);
        
        this.ShoulderplateL1 = new ModelRenderer(this, 56, 33);
        this.ShoulderplateL1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShoulderplateL1.addBox(3.5F, -1.5F, -3.5F, 1, 4, 7, 0.0F);
        this.setRotateAngle(ShoulderplateL1, 0.0F, -0.0F, -0.43633231520652765F);
        
        this.clothchestR = new ModelRenderer(this, 108, 38);
        this.clothchestR.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.clothchestR.addBox(-6.099999904632568F, -11.5F, -3.5F, 2, 8, 1, 0.0F);

        this.clothchestL = new ModelRenderer(this, 108, 38);
        this.clothchestL.mirror = true;
        this.clothchestL.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.clothchestL.addBox(0.10000000149011612F, -11.5F, -3.5F, 2, 8, 1, 0.0F);
        
        this.Mbelt = new ModelRenderer(this, 16, 55);
        this.Mbelt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Mbelt.addBox(-4.0F, 7.0F, -3.0F, 8, 5, 1, 0.0F);
        
        this.HelmetL = new ModelRenderer(this, 16, 11);
        this.HelmetL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HelmetL.addBox(5.5F, -3.0F, -4.5F, 1, 5, 9, 0.0F);
        this.setRotateAngle(HelmetL, 0.0F, -0.0F, -0.5235987901687622F);
        
        this.ShoulderplateR1 = new ModelRenderer(this, 56, 33);
        this.ShoulderplateR1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShoulderplateR1.addBox(-4.5F, -1.5F, -3.5F, 1, 4, 7, 0.0F);
        this.setRotateAngle(ShoulderplateR1, 0.0F, -0.0F, 0.43633231520652765F);
        
        this.ShoulderplateR3 = new ModelRenderer(this, 40, 33);
        this.ShoulderplateR3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShoulderplateR3.addBox(-2.5F, 3.5F, -3.5F, 1, 3, 7, 0.0F);
        this.setRotateAngle(ShoulderplateR3, 0.0F, -0.0F, 0.43633231520652765F);
        
        this.HelmetB = new ModelRenderer(this, 36, 19);
        this.HelmetB.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HelmetB.addBox(-4.5F, -3.0F, 5.5F, 9, 5, 1, 0.0F);
        this.setRotateAngle(HelmetB, 0.5235987901687622F, -0.0F, 0.0F);
        
        this.Chestthing = new ModelRenderer(this, 56, 50);
        this.Chestthing.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Chestthing.addBox(-2.5F, 1.0F, -4.0F, 5, 7, 1, 0.0F);
        
        this.ShoulderR = new ModelRenderer(this, 16, 45);
        this.ShoulderR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShoulderR.addBox(-3.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
        
        this.capsthingy = new ModelRenderer(this, 21, 0);
        this.capsthingy.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.capsthingy.addBox(-4.5F, -6.0F, -6.5F, 9, 1, 2, 0.0F);
        
        this.ShoulderplateTopR = new ModelRenderer(this, 56, 25);
        this.ShoulderplateTopR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShoulderplateTopR.addBox(-5.5F, -2.5F, -3.5F, 2, 1, 7, 0.0F);
        this.setRotateAngle(ShoulderplateTopR, 0.0F, -0.0F, 0.43633231520652765F);
        
        this.bottleR1 = new ModelRenderer(this, 76, 10);
        this.bottleR1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bottleR1.addBox(-5.550000190734863F, 0.5F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(bottleR1, 0.0F, -0.0F, 0.2617993950843811F);
        
        this.ShoulderplateR2 = new ModelRenderer(this, 40, 33);
        this.ShoulderplateR2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShoulderplateR2.addBox(-3.5F, 1.5F, -3.5F, 1, 3, 7, 0.0F);
        this.setRotateAngle(ShoulderplateR2, 0.0F, -0.0F, 0.43633231520652765F);
        
        this.bottleR3 = new ModelRenderer(this, 88, 10);
        this.bottleR3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bottleR3.addBox(-6.050000190734863F, 2.5F, -2.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(bottleR3, 0.0F, -0.0F, 0.2617993950843811F);
        
        this.BeltL = new ModelRenderer(this, 16, 36);
        this.BeltL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BeltL.addBox(4.0F, 4.0F, -3.0F, 1, 3, 6, 0.0F);
        
        this.bottleL3 = new ModelRenderer(this, 88, 10);
        this.bottleL3.mirror = true;
        this.bottleL3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bottleL3.addBox(1.9500000476837158F, 2.5F, -2.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(bottleL3, 0.0F, -0.0F, -0.2617993950843811F);
        
        this.Chestplate = new ModelRenderer(this, 16, 25);
        this.Chestplate.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Chestplate.addBox(-4.0F, 1.0F, -3.0F, 8, 6, 1, 0.0F);
        
        this.HelmetR = new ModelRenderer(this, 16, 11);
        this.HelmetR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HelmetR.addBox(-6.5F, -3.0F, -4.5F, 1, 5, 9, 0.0F);
        this.setRotateAngle(HelmetR, 0.0F, -0.0F, 0.5235987901687622F);
        
        this.ShoulderplateL3 = new ModelRenderer(this, 40, 33);
        this.ShoulderplateL3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShoulderplateL3.addBox(1.5F, 3.5F, -3.5F, 1, 3, 7, 0.0F);
        this.setRotateAngle(ShoulderplateL3, 0.0F, -0.0F, -0.43633231520652765F);
        
        this.ShoulderplateLtop = new ModelRenderer(this, 56, 25);
        this.ShoulderplateLtop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShoulderplateLtop.addBox(3.5F, -2.5F, -3.5F, 2, 1, 7, 0.0F);
        this.setRotateAngle(ShoulderplateLtop, 0.0F, -0.0F, -0.43633231520652765F);
        
        this.bottleL2 = new ModelRenderer(this, 88, 18);
        this.bottleL2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bottleL2.addBox(2.950000047683716F, 1.5F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(bottleL2, 0.0F, -0.0F, -0.2617993950843811F);
        
        this.BeltR = new ModelRenderer(this, 16, 36);
        this.BeltR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BeltR.addBox(-5.0F, 4.0F, -3.0F, 1, 3, 6, 0.0F);
        
        this.BackpackRoll = new ModelRenderer(this, 76, 32);
        this.BackpackRoll.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BackpackRoll.addBox(-4.5F, 7.0F, 4.0F, 9, 3, 3, 0.0F);
        
        this.MbeltL = new ModelRenderer(this, 16, 36);
        this.MbeltL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.MbeltL.addBox(4.0F, 8.0F, -3.0F, 1, 3, 6, 0.0F);
        
        this.ShoulderL = new ModelRenderer(this, 16, 45);
        this.ShoulderL.mirror = true;
        this.ShoulderL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShoulderL.addBox(-1.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
        
        this.MbeltR = new ModelRenderer(this, 16, 36);
        this.MbeltR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.MbeltR.addBox(-5.0F, 8.0F, -3.0F, 1, 3, 6, 0.0F);
        
        this.ShoulderplateL2 = new ModelRenderer(this, 40, 33);
        this.ShoulderplateL2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShoulderplateL2.addBox(2.5F, 1.5F, -3.5F, 1, 3, 7, 0.0F);
        this.setRotateAngle(ShoulderplateL2, 0.0F, -0.0F, -0.43633231520652765F);
        
        this.bottleR2 = new ModelRenderer(this, 88, 18);
        this.bottleR2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bottleR2.addBox(-5.050000190734863F, 1.5F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(bottleR2, 0.0F, -0.0F, 0.2617993950843811F);
        
        this.bottleL1 = new ModelRenderer(this, 76, 10);
        this.bottleL1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bottleL1.addBox(2.450000047683716F, 0.5F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(bottleL1, 0.0F, -0.0F, -0.2617993950843811F);
        
        this.Backplate = new ModelRenderer(this, 36, 45);
        this.Backplate.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Backplate.addBox(-4.0F, 1.0F, 2.0F, 8, 11, 2, 0.0F);
        
        this.Backpack = new ModelRenderer(this, 79, 45);
        this.Backpack.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Backpack.addBox(-5.5F, 0.0F, 4.0F, 11, 7, 7, 0.0F);
        
        this.FrontclothR1 = new ModelRenderer(this, 108, 38);
        this.FrontclothR1.addBox(0.0F, 0.0F, 0.0F, 3, 8, 1);
        this.FrontclothR1.setRotationPoint(-3.0F, 11.0F, -2.9F);
        this.FrontclothR1.setTextureSize(128, 64);
        setRotateAngle(this.FrontclothR1, -0.1047198F, 0.0F, 0.0F);
        
        this.FrontclothR2 = new ModelRenderer(this, 108, 47);
        this.FrontclothR2.addBox(0.0F, 7.5F, 1.7F, 3, 3, 1);
        this.FrontclothR2.setRotationPoint(-3.0F, 11.0F, -2.9F);
        this.FrontclothR2.setTextureSize(128, 64);
        setRotateAngle(this.FrontclothR2, -0.3316126F, 0.0F, 0.0F);
        
        this.FrontclothL1 = new ModelRenderer(this, 108, 38);
        this.FrontclothL1.mirror = true;
        this.FrontclothL1.addBox(0.0F, 0.0F, 0.0F, 3, 8, 1);
        this.FrontclothL1.setRotationPoint(0.0F, 11.0F, -2.9F);
        this.FrontclothL1.setTextureSize(128, 64);
        setRotateAngle(this.FrontclothL1, -0.1047198F, 0.0F, 0.0F);
        
        this.FrontclothL2 = new ModelRenderer(this, 108, 47);
        this.FrontclothL2.mirror = true;
        this.FrontclothL2.addBox(0.0F, 7.5F, 1.7F, 3, 3, 1);
        this.FrontclothL2.setRotationPoint(0.0F, 11.0F, -2.9F);
        this.FrontclothL2.setTextureSize(128, 64);
        setRotateAngle(this.FrontclothL2, -0.3316126F, 0.0F, 0.0F);
        
        this.ClothBackR1 = new ModelRenderer(this, 118, 16);
        this.ClothBackR1.mirror = true;
        this.ClothBackR1.addBox(0.0F, 0.0F, 0.0F, 4, 8, 1);
        this.ClothBackR1.setRotationPoint(-4.0F, 11.5F, 2.9F);
        this.ClothBackR1.setTextureSize(128, 64);
        setRotateAngle(this.ClothBackR1, 0.1047198F, 0.0F, 0.0F);
        
        this.ClothBackR2 = new ModelRenderer(this, 123, 9);
        this.ClothBackR2.addBox(0.0F, 7.8F, -0.9F, 1, 2, 1);
        this.ClothBackR2.setRotationPoint(-4.0F, 11.5F, 2.9F);
        this.ClothBackR2.setTextureSize(128, 64);
        setRotateAngle(this.ClothBackR2, 0.2268928F, 0.0F, 0.0F);
        
        this.ClothBackR3 = new ModelRenderer(this, 120, 12);
        this.ClothBackR3.mirror = true;
        this.ClothBackR3.addBox(1.0F, 7.8F, -0.9F, 3, 3, 1);
        this.ClothBackR3.setRotationPoint(-4.0F, 11.5F, 2.9F);
        this.ClothBackR3.setTextureSize(128, 64);
        setRotateAngle(this.ClothBackR3, 0.2268928F, 0.0F, 0.0F);
        
        this.ClothBackL1 = new ModelRenderer(this, 118, 16);
        this.ClothBackL1.addBox(0.0F, 0.0F, 0.0F, 4, 8, 1);
        this.ClothBackL1.setRotationPoint(0.0F, 11.5F, 2.9F);
        this.ClothBackL1.setTextureSize(128, 64);
        setRotateAngle(this.ClothBackL1, 0.1047198F, 0.0F, 0.0F);
        
        this.ClothBackL2 = new ModelRenderer(this, 123, 9);
        this.ClothBackL2.mirror = true;
        this.ClothBackL2.addBox(3.0F, 7.8F, -0.9F, 1, 2, 1);
        this.ClothBackL2.setRotationPoint(0.0F, 11.5F, 2.9F);
        this.ClothBackL2.setTextureSize(128, 64);
        setRotateAngle(this.ClothBackL2, 0.2268928F, 0.0F, 0.0F);
        
        this.ClothBackL3 = new ModelRenderer(this, 120, 12);
        this.ClothBackL3.addBox(0.0F, 7.8F, -0.9F, 3, 3, 1);
        this.ClothBackL3.setRotationPoint(0.0F, 11.5F, 2.9F);
        this.ClothBackL3.setTextureSize(128, 64);
        setRotateAngle(this.ClothBackL3, 0.2268928F, 0.0F, 0.0F);
        
        this.SideclothL2 = new ModelRenderer(this, 116, 34);
        this.SideclothL2.addBox(0.5F, 5.5F, -2.5F, 1, 3, 5);
        this.SideclothL2.setTextureSize(128, 64);
        setRotateAngle(this.SideclothL2, 0.0F, 0.0F, -0.296706F);
        
        this.SideclothR1 = new ModelRenderer(this, 116, 42);
        this.SideclothR1.addBox(-2.5F, 0.5F, -2.5F, 1, 5, 5);
        this.SideclothR1.setTextureSize(128, 64);
        setRotateAngle(this.SideclothR1, 0.0F, 0.0F, 0.122173F);
        
        this.SideclothR2 = new ModelRenderer(this, 116, 34);
        this.SideclothR2.addBox(-1.5F, 5.5F, -2.5F, 1, 3, 5);
        this.SideclothR2.setTextureSize(128, 64);
        setRotateAngle(this.SideclothR2, 0.0F, 0.0F, 0.296706F);
        
        this.SideclothR3 = new ModelRenderer(this, 116, 1);
        this.SideclothR3.addBox(0.4F, 8.4F, -2.5F, 1, 3, 5);
        this.SideclothR3.setTextureSize(128, 64);
        setRotateAngle(this.SideclothR3, 0.0F, 0.0F, 0.5235988F);
        
        this.SidepanelR1 = new ModelRenderer(this, 116, 25);
        this.SidepanelR1.addBox(-2.5F, 0.5F, -2.5F, 1, 4, 5);
        this.SidepanelR1.setTextureSize(128, 64);
        this.SidepanelR1.mirror = true;
        setRotateAngle(this.SidepanelR1, 0.0F, 0.0F, 0.4363323F);
        
        this.LegpanelR6 = new ModelRenderer(this, 82, 38);
        this.LegpanelR6.addBox(-3.0F, 4.5F, -1.5F, 2, 3, 1);
        this.LegpanelR6.setTextureSize(128, 64);
        setRotateAngle(this.LegpanelR6, -0.4363323F, 0.0F, 0.0F);
        
        this.LegpanelR5 = new ModelRenderer(this, 76, 42);
        this.LegpanelR5.addBox(-3.0F, 2.5F, -2.5F, 2, 3, 1);
        this.LegpanelR5.setTextureSize(128, 64);
        setRotateAngle(this.LegpanelR5, -0.4363323F, 0.0F, 0.0F);
        
        this.LegpanelR4 = new ModelRenderer(this, 76, 38);
        this.LegpanelR4.addBox(-3.0F, 0.5F, -3.5F, 2, 3, 1);
        this.LegpanelR4.setTextureSize(128, 64);
        setRotateAngle(this.LegpanelR4, -0.4363323F, 0.0F, 0.0F);
        
        this.SideclothL3 = new ModelRenderer(this, 116, 1);
        this.SideclothL3.addBox(-1.4F, 8.4F, -2.5F, 1, 3, 5);
        this.SideclothL3.setTextureSize(128, 64);
        setRotateAngle(this.SideclothL3, 0.0F, 0.0F, -0.5235988F);
        
        this.SideclothL1 = new ModelRenderer(this, 116, 42);
        this.SideclothL1.addBox(1.5F, 0.5F, -2.5F, 1, 5, 5);
        this.SideclothL1.setTextureSize(128, 64);
        setRotateAngle(this.SideclothL1, 0.0F, 0.0F, -0.122173F);
        
        this.LegpanelL4 = new ModelRenderer(this, 76, 38);
        this.LegpanelL4.mirror = true;
        this.LegpanelL4.addBox(1.0F, 0.5F, -3.5F, 2, 3, 1);
        this.LegpanelL4.setTextureSize(128, 64);
        setRotateAngle(this.LegpanelL4, -0.4363323F, 0.0F, 0.0F);
        
        this.LegpanelL5 = new ModelRenderer(this, 76, 42);
        this.LegpanelL5.mirror = true;
        this.LegpanelL5.addBox(1.0F, 2.5F, -2.5F, 2, 3, 1);
        this.LegpanelL5.setTextureSize(128, 64);
        setRotateAngle(this.LegpanelL5, -0.4363323F, 0.0F, 0.0F);
        
        this.LegpanelL6 = new ModelRenderer(this, 82, 38);
        this.LegpanelL6.mirror = true;
        this.LegpanelL6.addBox(1.0F, 4.5F, -1.5F, 2, 3, 1);
        this.LegpanelL6.setTextureSize(128, 64);
        setRotateAngle(this.LegpanelL6, -0.4363323F, 0.0F, 0.0F);
        
        this.SidepanelL1 = new ModelRenderer(this, 116, 25);
        this.SidepanelL1.addBox(1.5F, 0.5F, -2.5F, 1, 4, 5);
        this.SidepanelL1.setTextureSize(128, 64);
        setRotateAngle(this.SidepanelL1, 0.0F, 0.0F, -0.4363323F);
        
        
        
        
        this.bipedHeadwear.cubeList.clear();
        this.bipedHead.cubeList.clear();
        this.bipedHead.addChild(this.Helmet);
        this.bipedHead.addChild(this.HelmetB);
        this.bipedHead.addChild(this.HelmetL);
        this.bipedHead.addChild(this.HelmetR);
        this.bipedHead.addChild(this.capsthingy);
        this.bipedHead.addChild(this.Mask[0]);
        this.bipedHead.addChild(this.Mask[1]);   
        
        this.bipedBody.cubeList.clear();
        this.bipedBody.addChild(this.Mbelt);
        this.bipedBody.addChild(this.MbeltL);
        this.bipedBody.addChild(this.MbeltR);
        if (f < 1.0F)
        {
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
          this.bipedBody.addChild(this.clothchestL);
          this.bipedBody.addChild(this.clothchestR);
          this.bipedBody.addChild(this.BeltL);
          this.bipedBody.addChild(this.BeltR);
          this.bipedBody.addChild(this.Backplate);
          this.bipedBody.addChild(this.Backpack);
          this.bipedBody.addChild(this.BackpackRoll);
        }
        
        this.bipedRightArm.cubeList.clear();
        this.bipedRightArm.addChild(this.ShoulderR);
        this.bipedRightArm.addChild(this.ShoulderplateR1);
        this.bipedRightArm.addChild(this.ShoulderplateR2);
        this.bipedRightArm.addChild(this.ShoulderplateR3);
        this.bipedRightArm.addChild(this.ShoulderplateTopR);
        
        this.bipedLeftArm.cubeList.clear();
        this.bipedLeftArm.addChild(this.ShoulderL);
        this.bipedLeftArm.addChild(this.ShoulderplateL1);
        this.bipedLeftArm.addChild(this.ShoulderplateL2);
        this.bipedLeftArm.addChild(this.ShoulderplateL3);
        this.bipedLeftArm.addChild(this.ShoulderplateLtop);

        
        this.bipedRightLeg.cubeList.clear();
        this.bipedRightLeg.addChild(this.LegpanelR4);
        this.bipedRightLeg.addChild(this.LegpanelR5);
        this.bipedRightLeg.addChild(this.LegpanelR6);
        this.bipedRightLeg.addChild(this.SidepanelR1);
        
        this.bipedRightLeg.addChild(this.SideclothR1);
        this.bipedRightLeg.addChild(this.SideclothR2);
        //this.bipedRightLeg.addChild(this.SideclothR3);
        
        this.bipedRightLeg.addChild(this.bottleR1);
        this.bipedRightLeg.addChild(this.bottleR2);
        this.bipedRightLeg.addChild(this.bottleR3);

        
        this.bipedLeftLeg.cubeList.clear();
        this.bipedLeftLeg.addChild(this.LegpanelL4);
        this.bipedLeftLeg.addChild(this.LegpanelL5);
        this.bipedLeftLeg.addChild(this.LegpanelL6);
        this.bipedLeftLeg.addChild(this.SidepanelL1);
        
        this.bipedLeftLeg.addChild(this.SideclothL1);
        this.bipedLeftLeg.addChild(this.SideclothL2);
        //this.bipedLeftLeg.addChild(this.SideclothL3);
        
        this.bipedLeftLeg.addChild(this.bottleL1);
        this.bipedLeftLeg.addChild(this.bottleL2);
        this.bipedLeftLeg.addChild(this.bottleL3);
        
        
        
    }
    
    private void checkSet(Entity entity) {
        if(entity instanceof EntityLivingBase && entity.ticksExisted % 20 == 0) {
           int set = 0;

           for(int a = 1; a < 4; ++a) {
              ItemStack piece = ((EntityLivingBase)entity).getEquipmentInSlot(a + 1);
              if(piece != null && piece.getItem() instanceof RangerArmor) {
                 ++set;
                 if(a == 3) {
                    if(piece.hasTagCompound() && piece.stackTagCompound.hasKey("mask")) {
                       hasMask.put(Integer.valueOf(entity.getEntityId()), Integer.valueOf(piece.stackTagCompound.getInteger("mask")));
                    } else {
                       hasMask.remove(Integer.valueOf(entity.getEntityId()));
                    }
                 }
              }
           }
        }
     }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	if (((entity instanceof EntitySkeleton)) || ((entity instanceof EntityZombie))) {
    	      setRotationAnglesZombie(f, f1, f2, f3, f4, f5, entity);
    	    } else {
    	      setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	    }
    	    float a = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    	    float b = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
    	    float c = Math.min(a, b);
    	  
    	    this.FrontclothR1.rotateAngleX = (this.FrontclothL1.rotateAngleX = c - 0.1047198F);
    	    this.FrontclothR2.rotateAngleX = (this.FrontclothL2.rotateAngleX = c - 0.3316126F);
    	    
    	    this.ClothBackR1.rotateAngleX = (this.ClothBackL1.rotateAngleX = -c + 0.1047198F);
    	    this.ClothBackR2.rotateAngleX = (this.ClothBackL2.rotateAngleX = this.ClothBackR3.rotateAngleX = this.ClothBackL3.rotateAngleX = -c + 0.2268928F);
    	    
    	    
	    if (this.isChild)
	    {
	      float f6 = 2.0F;
	      GL11.glPushMatrix();
	      GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
	      GL11.glTranslatef(0.0F, 16.0F * f5, 0.0F); //16*
	      this.bipedHead.render(f5);
	      GL11.glPopMatrix();
	      GL11.glPushMatrix();
	      GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
	      GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F); //24*
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
	    
      this.checkSet(entity);
      int mask = hasMask.containsKey(Integer.valueOf(entity.getEntityId()))?((Integer)hasMask.get(Integer.valueOf(entity.getEntityId()))).intValue():-1;
      

      for(int var11 = 0; var11 < 2; ++var11) {
         if(mask == var11) {
            this.Mask[var11].isHidden = false;
         } else {
            this.Mask[var11].isHidden = true;
         }
      }
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
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
