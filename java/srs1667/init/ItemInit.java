package srs1667.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import srs1667.objects.items.ItemBase;
import srs1667.objects.items.ItemModFood;

public class ItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	//Items
	
	//Tools
	
	//Armor
	
	//Metals
	public static final Item INGOT_COPPER = new ItemBase("ingot_copper");
	public static final Item INGOT_SILVER = new ItemBase("ingot_silver");
	public static final Item INGOT_STEEL = new ItemBase("ingot_steel");
	public static final Item INGOT_ELECTRUM = new ItemBase("ingot_electrum");
	public static final Item INGOT_VIBRANT = new ItemBase("ingot_vibrant");
	public static final Item INGOT_MYTHRIL = new ItemBase("ingot_mythril");
	
	
	//Food
	
	public static final Item WALNUT = new ItemModFood("walnut", 2, 0.1F, false );
	public static final Item PEANUT = new ItemModFood("peanut", 1, 0.2F, false );
	public static final Item STRAWBERRY = new ItemModFood("strawberry", 2, 0.2F, true );
	public static final Item CORN = new ItemModFood("corn", 3, 0.3F, true );
	public static final Item PBJ = new ItemModFood("pbj", 8, 0.9F, false );
	public static final Item OXTAIL = new ItemModFood("oxtail", 3, 0.3F, true );
	public static final Item COOKED_OXTAIL = new ItemModFood("cooked_oxtail", 7, 0.9F, true);
	public static final Item CHEESECAKE = new ItemModFood("cheesecake", 8, 0.3F, true);
	public static final Item GRANNYCOOKIE = new ItemModFood("grannycookie", 4, 0.3F, false); //maybe potions?
	public static final Item COOKIEDOUGH = new ItemModFood("cookiedough", 2, 2, true ).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.3F).setAlwaysEdible();
	public static final Item BROWNIE = new ItemModFood("brownie", 2, 2, true, new PotionEffect(Potion.getPotionById(25), 100, 1));;
	
	/*.setAlwaysEdible() < Add to make food always edible
		exampleFood = new ItemModFood("exampleFood", <Hunger>,<Saturation>,<dogfood?>);
		exampleFoodWP = new ItemModFood("exampleFood", <H>,<S>,<D>, new PotionEffect(Potion.getPotionById(#),<duration>,<strength>));		
	*/
	
	//Materials
	//public static final Item HEMPSEED = new ItemBase("hempseed");
	public static final Item HEMP = new ItemBase("hemp");
	public static final Item TWINE = new ItemBase("twine");
	public static final Item ROPE = new ItemBase("rope");
	public static final Item CLOTH = new ItemBase("cloth");
	public static final Item SAIL = new ItemBase("sail");
	//public static final Item WINDMILL_BLADES = new ItemBase("windmill_blades");
	//public static final Item WINDMILL = new ItemBase("windmill")
	
	
	public static final Item QUEENBEE = new ItemBase("queenbee");
	public static final Item HONEYCOMB = new ItemBase("honeycomb");
	public static final Item WAX = new ItemBase("wax");
	public static final Item HONEY = new ItemBase("honey"); // used as Alternative to Slimeball, maybe make clear all potions like milk?
	
	public static final Item FLOUR = new ItemBase("flour");
	public static final Item INK = new ItemBase("ink");
	public static final Item MOLASSES = new ItemBase("molasses");
	
	
	//public static final Item LANTERN = new ItemBase("lantern");
	
	//public static final Item GEAR = new ItemBase ("gear");
	//public static final Item PADDLE = new ItemBase("paddle");
	//public static final Item WATERWHEEL = new ItemBase("waterwheel");
	
	
}
