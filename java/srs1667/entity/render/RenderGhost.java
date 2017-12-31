package srs1667.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import srs1667.entity.EntityGhost;
import srs1667.entity.EntityOx;
import srs1667.entity.model.ModelGhost;
import srs1667.entity.model.ModelOx;
import srs1667.util.Reference;

public class RenderGhost extends RenderLiving<EntityGhost>
{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/ghost.png");
	
	public RenderGhost(RenderManager manager) 
	{
		super(manager, new ModelGhost(), 0.5F);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGhost entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityGhost entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
