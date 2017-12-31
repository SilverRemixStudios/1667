package srs1667.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * ModelVillager - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelGhost extends ModelBase {
    public ModelRenderer Head;
    public ModelRenderer RightArm;
    public ModelRenderer LeftArm;
    public ModelRenderer Body;
    public ModelRenderer Hood2;
    public ModelRenderer Nose;
    public ModelRenderer Hood1;
    public ModelRenderer Tail1;
    public ModelRenderer Tail2;

    public ModelGhost() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Head = new ModelRenderer(this, 0, 2);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -7.3F, -6.6F, 8, 8, 8, 0.0F);
        this.Tail2 = new ModelRenderer(this, 25, 42);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail2.addBox(-1.9F, 2.8F, -17.9F, 4, 8, 3, 0.0F);
        this.setRotateAngle(Tail2, 1.5111060663766904F, 0.0F, 0.0F);
        this.Hood1 = new ModelRenderer(this, 35, 6);
        this.Hood1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hood1.addBox(-2.5F, -3.4F, 3.6F, 4, 7, 5, 0.0F);
        this.setRotateAngle(Hood1, 1.5707963267948966F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 20);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 6, 0.0F);
        this.setRotateAngle(Body, 0.24452062820440557F, 0.0F, 0.0F);
        this.RightArm = new ModelRenderer(this, 32, 22);
        this.RightArm.setRotationPoint(0.4F, 3.0F, -1.0F);
        this.RightArm.addBox(-8.0F, -9.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(RightArm, 1.5707963267948966F, 0.0F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 32, 22);
        this.LeftArm.mirror = true;
        this.LeftArm.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.LeftArm.addBox(4.0F, -9.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(LeftArm, 1.5707963267948966F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 0, 40);
        this.Tail1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail1.addBox(-3.0F, 8.5F, -7.5F, 6, 8, 5, 0.0F);
        this.setRotateAngle(Tail1, 0.5222025121967034F, 0.0F, 0.0F);
        this.Nose = new ModelRenderer(this, 24, 0);
        this.Nose.setRotationPoint(0.0F, -2.6F, 0.0F);
        this.Nose.addBox(-1.0F, -0.2F, -8.5F, 2, 4, 2, 0.0F);
        this.Hood2 = new ModelRenderer(this, 50, 2);
        this.Hood2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hood2.addBox(-2.0F, 3.2F, 4.6F, 2, 3, 3, 0.0F);
        this.setRotateAngle(Hood2, 1.5707963267948966F, 0.0F, 0.0F);
        this.Body.addChild(this.Tail2);
        this.Head.addChild(this.Hood1);
        this.Body.addChild(this.Tail1);
        this.Head.addChild(this.Nose);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.569F);
        this.Head.render(f5);
        GlStateManager.disableBlend();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.569F);
        this.Body.render(f5);
        GlStateManager.disableBlend();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.RightArm.offsetX, this.RightArm.offsetY, this.RightArm.offsetZ);
        GlStateManager.translate(this.RightArm.rotationPointX * f5, this.RightArm.rotationPointY * f5, this.RightArm.rotationPointZ * f5);
        GlStateManager.scale(1.1D, 1.0D, 1.0D);
        GlStateManager.translate(-this.RightArm.offsetX, -this.RightArm.offsetY, -this.RightArm.offsetZ);
        GlStateManager.translate(-this.RightArm.rotationPointX * f5, -this.RightArm.rotationPointY * f5, -this.RightArm.rotationPointZ * f5);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.569F);
        this.RightArm.render(f5);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.569F);
        this.LeftArm.render(f5);
        GlStateManager.disableBlend();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.569F);
        this.Hood2.render(f5);
        GlStateManager.disableBlend();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
