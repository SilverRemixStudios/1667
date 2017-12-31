package srs1667.init;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import srs1667.Mod1667;
import srs1667.entity.EntityGhost;
import srs1667.entity.EntityGranny;
import srs1667.entity.EntityOx;
import srs1667.util.Reference;

public class EntityInit 
{
	public static void registerEntities()
	{
		registerEntity("ox", EntityOx.class, Reference.ENTITY_OX, 50, 1248789, 10782073);
		registerEntity("ghost", EntityGhost.class, Reference.ENTITY_GHOST, 50, 14546674, 13883609);
		registerEntity("granny", EntityGranny.class, Reference.ENTITY_GRANNY, 50, 9468592, 4920657);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int colour1, int colour2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id,  Mod1667.instance, range, 1, true, colour1, colour2);
	}
	
}
