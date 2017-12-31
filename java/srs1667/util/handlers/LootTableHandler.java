package srs1667.util.handlers;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import srs1667.util.Reference;

public class LootTableHandler 
{
	public static final ResourceLocation OX = LootTableList.register(new ResourceLocation(Reference.MODID, "ox"));
	public static final ResourceLocation GHOST = LootTableList.register(new ResourceLocation(Reference.MODID, "ghost"));
}
