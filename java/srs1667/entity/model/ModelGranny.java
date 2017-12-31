package srs1667.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * ModelVillager - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelGranny extends ModelBase {
	public ModelRenderer Head;
    public ModelRenderer LArm;
    public ModelRenderer RArm;
    public ModelRenderer FArm;
    public ModelRenderer RLeg;
    public ModelRenderer Torso;
    public ModelRenderer Tunic;
    public ModelRenderer LLeg;
    public ModelRenderer Nose;
    public ModelRenderer Bun;
    public ModelRenderer Glasses;
    public ModelRenderer shape13;
    public ModelRenderer shape14;
    public ModelRenderer shape15;

    public ModelGranny() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Bun = new ModelRenderer(this, 34, 0);
        this.Bun.setRotationPoint(-2.0F, -9.0F, 2.4F);
        this.Bun.addBox(0.0F, -1.0F, -1.0F, 4, 4, 4, 0.0F);
        this.shape14 = new ModelRenderer(this, 42, 11);
        this.shape14.setRotationPoint(0.9F, -4.7F, -6.6F);
        this.shape14.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
        this.shape15 = new ModelRenderer(this, 26, 3);
        this.shape15.setRotationPoint(0.4F, 0.9F, -5.4F);
        this.shape15.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.Glasses = new ModelRenderer(this, 35, 12);
        this.Glasses.setRotationPoint(-1.0F, -4.0F, -6.8F);
        this.Glasses.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        this.RLeg = new ModelRenderer(this, 0, 22);
        this.RLeg.mirror = true;
        this.RLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.RLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Tunic = new ModelRenderer(this, 0, 38);
        this.Tunic.setRotationPoint(0.0F, 0.0F, -0.6F);
        this.Tunic.addBox(-4.0F, 4.0F, -3.0F, 8, 15, 6, 0.5F);
        this.setRotateAngle(Tunic, 0.09599310885968812F, 0.0F, 0.0F);
        this.RArm = new ModelRenderer(this, 44, 22);
        this.RArm.setRotationPoint(0.0F, 7.2F, 1.5F);
        this.RArm.addBox(4.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(RArm, 0.6108652381980153F, 0.0F, 0.0F);
        this.FArm = new ModelRenderer(this, 40, 38);
        this.FArm.setRotationPoint(0.0F, 7.2F, 1.5F);
        this.FArm.addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F);
        this.setRotateAngle(FArm, 0.6108652381980153F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 2);
        this.Head.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -6.0F, 8, 8, 8, 0.0F);
        this.Torso = new ModelRenderer(this, 16, 20);
        this.Torso.setRotationPoint(0.0F, 0.0F, -0.6F);
        this.Torso.addBox(-4.0F, 4.0F, -3.0F, 8, 8, 6, 0.0F);
        this.setRotateAngle(Torso, 0.09599310885968812F, 0.0F, 0.0F);
        this.shape13 = new ModelRenderer(this, 42, 11);
        this.shape13.setRotationPoint(-2.9F, -4.7F, -6.6F);
        this.shape13.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
        this.Nose = new ModelRenderer(this, 24, 0);
        this.Nose.setRotationPoint(0.0F, -2.0F, -2.0F);
        this.Nose.addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
        this.LLeg = new ModelRenderer(this, 0, 22);
        this.LLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.LLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.LArm = new ModelRenderer(this, 44, 22);
        this.LArm.setRotationPoint(0.0F, 7.2F, 1.5F);
        this.LArm.addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(LArm, 0.6108652381980153F, 0.0F, 0.0F);
        this.Head.addChild(this.Bun);
        this.Head.addChild(this.shape14);
        this.Nose.addChild(this.shape15);
        this.Head.addChild(this.Glasses);
        this.Head.addChild(this.shape13);
        this.Head.addChild(this.Nose);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.RLeg.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Tunic.offsetX, this.Tunic.offsetY, this.Tunic.offsetZ);
        GlStateManager.translate(this.Tunic.rotationPointX * f5, this.Tunic.rotationPointY * f5, this.Tunic.rotationPointZ * f5);
        GlStateManager.scale(1.0D, 1.1D, 1.0D);
        GlStateManager.translate(-this.Tunic.offsetX, -this.Tunic.offsetY, -this.Tunic.offsetZ);
        GlStateManager.translate(-this.Tunic.rotationPointX * f5, -this.Tunic.rotationPointY * f5, -this.Tunic.rotationPointZ * f5);
        this.Tunic.render(f5);
        GlStateManager.popMatrix();
        this.RArm.render(f5);
        this.FArm.render(f5);
        this.Head.render(f5);
        this.Torso.render(f5);
        this.LLeg.render(f5);
        this.LArm.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
    	
        this.LLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.RLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.Head.rotateAngleX= headPitch * 0.017453292F;
            
    }
}
