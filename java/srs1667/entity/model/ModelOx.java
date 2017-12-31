package srs1667.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelCow - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelOx extends ModelBase {
    public ModelRenderer Butt;
    public ModelRenderer RLLeg;
    public ModelRenderer FLLeg;
    public ModelRenderer RRLeg;
    public ModelRenderer FRLeg;
    public ModelRenderer Head;
    public ModelRenderer Torso;
    public ModelRenderer Snout;
    public ModelRenderer RHorn;
    public ModelRenderer LHorn;
    public ModelRenderer RTip;
    public ModelRenderer LTip;

    public ModelOx() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.RHorn = new ModelRenderer(this, 22, 0);
        this.RHorn.setRotationPoint(-0.3F, -7.6F, 0.8F);
        this.RHorn.addBox(-5.0F, -5.0F, -4.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(RHorn, 0.0F, 0.0F, -1.5707963267948966F);
        this.FRLeg = new ModelRenderer(this, 0, 16);
        this.FRLeg.setRotationPoint(-4.4F, 12.0F, -6.0F);
        this.FRLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.RLLeg = new ModelRenderer(this, 0, 16);
        this.RLLeg.setRotationPoint(4.0F, 12.0F, 7.0F);
        this.RLLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 5.9F, -11.8F);
        this.Head.addBox(-4.0F, -4.0F, -6.0F, 8, 8, 6, 0.0F);
        this.Butt = new ModelRenderer(this, 18, 4);
        this.Butt.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.Butt.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
        this.setRotateAngle(Butt, 1.5707963267948966F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 0);
        this.Snout.setRotationPoint(-2.5F, 0.3F, -7.4F);
        this.Snout.addBox(0.0F, 0.0F, 0.0F, 5, 3, 2, 0.0F);
        this.RRLeg = new ModelRenderer(this, 0, 16);
        this.RRLeg.setRotationPoint(-4.0F, 12.0F, 7.0F);
        this.RRLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Torso = new ModelRenderer(this, 18, 7);
        this.Torso.setRotationPoint(-7.0F, 12.9F, -13.3F);
        this.Torso.addBox(0.0F, 0.0F, 0.0F, 14, 12, 13, 0.0F);
        this.setRotateAngle(Torso, 1.5707963267948966F, 0.0F, 0.0F);
        this.RTip = new ModelRenderer(this, 22, 0);
        this.RTip.setRotationPoint(-5.0F, -4.3F, -3.9F);
        this.RTip.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(RTip, -0.5516985765554075F, 0.0F, -1.5707963267948966F);
        this.FLLeg = new ModelRenderer(this, 0, 16);
        this.FLLeg.setRotationPoint(4.4F, 12.0F, -6.0F);
        this.FLLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.LHorn = new ModelRenderer(this, 22, 0);
        this.LHorn.setRotationPoint(0.0F, -7.6F, 0.8F);
        this.LHorn.addBox(4.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(LHorn, 0.0F, 0.0F, 1.5707963267948966F);
        this.LTip = new ModelRenderer(this, 22, 0);
        this.LTip.setRotationPoint(5.0F, -5.6F, -3.9F);
        this.LTip.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(LTip, -0.5516985765554075F, 0.0F, 1.5707963267948966F);
        this.Head.addChild(this.RHorn);
        this.Head.addChild(this.Snout);
        this.RHorn.addChild(this.RTip);
        this.Head.addChild(this.LHorn);
        this.LHorn.addChild(this.LTip);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.FRLeg.render(f5);
        this.RLLeg.render(f5);
        this.Head.render(f5);
        this.Butt.render(f5);
        this.RRLeg.render(f5);
        this.Torso.render(f5);
        this.FLLeg.render(f5);
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
    	
        this.FLLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.RLLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.FRLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.RRLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.Head.rotateAngleX= headPitch * 0.017453292F;
            
    }
    
    
}
