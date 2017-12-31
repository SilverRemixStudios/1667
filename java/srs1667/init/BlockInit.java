package srs1667.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import srs1667.objects.blocks.BlockBase;
import srs1667.objects.blocks.BlockLeaf;
import srs1667.objects.blocks.BlockLogs;
import srs1667.objects.blocks.BlockMelonLantern;
import srs1667.objects.blocks.BlockOres;
import srs1667.objects.blocks.BlockPlanks;
import srs1667.objects.blocks.BlockSaplings;

public class BlockInit 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block ORE_OVERWORLD = new BlockOres("ore_overworld", "overworld", 1);
	public static final Block ORE_END = new BlockOres("ore_end", "end", 2);
	public static final Block ORE_NETHER = new BlockOres("ore_nether", "nether", 2);
	
	public static final Block PLANKS = new BlockPlanks("planks");
	public static final Block LEAVES = new BlockLeaf("leaves");
	public static final Block SAPLINGS = new BlockSaplings("sapling");
	
	public static final Block LOG_REDWOOD = new BlockLogs("log_redwood");
	public static final Block LOG_MAPLE = new BlockLogs("log_maple");
	public static final Block LOG_BEECH = new BlockLogs("log_beech");
	public static final Block LOG_WALNUT = new BlockLogs("log_walnut");
	
	public static final Block BLOCK_COPPER = new BlockBase("block_copper", Material.IRON);
	public static final Block MELON_LANTERN = new BlockMelonLantern("melon_lantern");
}
