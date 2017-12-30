package srs1667.objects.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import srs1667.Mod1667;
import srs1667.init.ItemInit;
import srs1667.util.interfaces.IHasModel;

public class ItemModFood extends ItemFood implements IHasModel
{
	private PotionEffect[] effects;
	
	public ItemModFood (String name, int amount, boolean isWolfFood, PotionEffect...potionEffects)
	{
		super(amount, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.FOOD);
		
		ItemInit.ITEMS.add(this);

		this.effects = potionEffects;
	}
	
	public ItemModFood (String name, int amount, float saturation, boolean isWolfFood, PotionEffect...potionEffects)
	{
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.FOOD);
		this.effects = potionEffects;
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
	{
		for(PotionEffect effect : effects){player.addPotionEffect(effect);}
	}	
	
	@Override
	public void registerModels()
	{
		Mod1667.proxy.registerItemRenderer(this, 0, "inventory");
	}
}