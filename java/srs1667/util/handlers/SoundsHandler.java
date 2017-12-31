package srs1667.util.handlers;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import srs1667.util.Reference;

public class SoundsHandler 
{
	public static SoundEvent MELON_LANTERN_LAUGH; //list others with commas

	public static void registerSounds()
	{
		MELON_LANTERN_LAUGH = registerSound("blocks.melonlaugh");
	}

	private static SoundEvent registerSound(String name)
	{
		ResourceLocation location = new ResourceLocation(Reference.MODID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}

}
