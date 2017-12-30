package srs1667.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy 
{
	public void registerItemRender(Item item, int meta, String id) {}
	public void registerVariantRenderer(Item item, int meta, String filename, String id) {}
	
	
	public void preInit(FMLPreInitializationEvent event)
	{
		//initialise items and blocks
	}
	
	public void init(FMLInitializationEvent event)
	{
		//Initialise renders
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
	public void registerItemRenderer(Item item, int meta, String id)
	{
		
	}
}
