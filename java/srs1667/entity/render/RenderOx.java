package srs1667.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import srs1667.entity.EntityOx;
import srs1667.entity.model.ModelOx;
import srs1667.util.Reference;

public class RenderOx extends RenderLiving<EntityOx>
{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/ox.png");
	
	public RenderOx(RenderManager manager) 
	{
		super(manager, new ModelOx(), 0.5F);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityOx entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityOx entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
