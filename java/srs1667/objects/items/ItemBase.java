package srs1667.objects.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import srs1667.Mod1667;
import srs1667.init.ItemInit;
import srs1667.proxy.ClientProxy;
import srs1667.util.interfaces.IHasModel;

public class ItemBase extends Item implements IHasModel
{
	public ItemBase(String name)
	{
	setUnlocalizedName(name);
	setRegistryName(name);
	setCreativeTab(CreativeTabs.MATERIALS);
	
	ItemInit.ITEMS.add(this);
	
	}
	
	@Override
	public void registerModels()
	{
		Mod1667.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
