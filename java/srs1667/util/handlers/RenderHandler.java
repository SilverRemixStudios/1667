package srs1667.util.handlers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import srs1667.entity.EntityGhost;
import srs1667.entity.EntityGranny;
import srs1667.entity.EntityOx;
import srs1667.entity.render.RenderGhost;
import srs1667.entity.render.RenderGranny;
import srs1667.entity.render.RenderOx;

public class RenderHandler 
{

	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityOx.class, new IRenderFactory<EntityOx>()
		{
			@Override
			public Render<? super EntityOx> createRenderFor(RenderManager manager)
			{
				return new RenderOx(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityGhost.class, new IRenderFactory<EntityGhost>()
		{
			@Override
			public Render<? super EntityGhost> createRenderFor(RenderManager manager)
			{
				return new RenderGhost(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityGranny.class, new IRenderFactory<EntityGranny>()
		{
			@Override
			public Render<? super EntityGranny> createRenderFor(RenderManager manager)
			{
				return new RenderGranny(manager);
			}
		});
	}
	
	

}
