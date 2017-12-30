package srs1667.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import srs1667.entity.EntityGhost;
import srs1667.entity.EntityGranny;
import srs1667.entity.EntityOx;
import srs1667.entity.model.ModelGhost;
import srs1667.entity.model.ModelGranny;
import srs1667.entity.model.ModelOx;
import srs1667.util.Reference;

public class RenderGranny extends RenderLiving<EntityGranny>
{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/granny.png");
	
	public RenderGranny(RenderManager manager) 
	{
		super(manager, new ModelGranny(), 0.5F);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGranny entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityGranny entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
