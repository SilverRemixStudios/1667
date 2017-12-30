package srs1667.objects.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import srs1667.Mod1667;
import srs1667.init.BlockInit;
import srs1667.init.ItemInit;
import srs1667.objects.blocks.item.ItemBlockVariants;
import srs1667.util.handlers.EnumHandler;
import srs1667.util.interfaces.IHasModel;
import srs1667.util.interfaces.IMetaName;
import srs1667.world.gen.generators.WorldGenBeechTree;
import srs1667.world.gen.generators.WorldGenMapleTree;
import srs1667.world.gen.generators.WorldGenRedwoodTree;
import srs1667.world.gen.generators.WorldGenWalnutTree;

public class BlockSaplings extends BlockBush implements IGrowable, IMetaName, IHasModel
{	
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
    
    public static final PropertyEnum<EnumHandler.EnumWoodType> VARIANT = PropertyEnum.<EnumHandler.EnumWoodType>create("variant", EnumHandler.EnumWoodType.class, new Predicate<EnumHandler.EnumWoodType>()
	{
		public boolean apply(@Nullable EnumHandler.EnumWoodType apply)
		{
			return apply.getMeta() < 4;
		}
	});
    
    private String name;
    
    public BlockSaplings(String name) 
    {
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumWoodType.REDWOOD).withProperty(STAGE, Integer.valueOf(0)));
		
		this.name = name;
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}
    
    //Sapling Shape
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
    {
    	return SAPLING_AABB;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) 
    {
    	return NULL_AABB;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state) 
    {
    	return false;
    }
    
    @Override
    public boolean isFullCube(IBlockState state) 
    {
    	return false;
    }
    
    //Variants
    @Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
	{
		for(EnumHandler.EnumWoodType customblockplanks$enumWoodType : EnumHandler.EnumWoodType.values())
		{
			items.add(new ItemStack(this, 1, customblockplanks$enumWoodType.getMeta()));
		}
	}
    
    @Override
	public int damageDropped(IBlockState state) 
	{
		return ((EnumHandler.EnumWoodType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return EnumHandler.EnumWoodType.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumWoodType.byMetadata(meta & 1)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;
		i = i | ((EnumHandler.EnumWoodType)state.getValue(VARIANT)).getMeta();
		i = i | ((Integer)state.getValue(STAGE)).intValue() << 3;
		return i;
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT, STAGE});	
	}
	
	@Override
	public void registerModels() 
	{
		for(int i = 0; i < EnumHandler.EnumWoodType.values().length; i++)
		{
			Mod1667.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "sapling_" + EnumHandler.EnumWoodType.values()[i].getName(), "inventory");
		}
	}
	
	//Tree Code	
	
	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		if(((Integer)state.getValue(STAGE)).intValue() == 0)
		{
			worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
		}
		else
		{
			this.generateTree(worldIn, rand, pos, state);
		}
	}
	
	public void generateTree(World world, Random rand, BlockPos pos, IBlockState state)
	{
		if(!TerrainGen.saplingGrowTree(world, rand, pos)) return;
		WorldGenerator gen = (WorldGenerator)(rand.nextInt(10) == 0 ? new WorldGenBigTree(false) : new WorldGenTrees(false));
		boolean flag = false;
		int i = 0, j = 0;
		
		switch((EnumHandler.EnumWoodType)state.getValue(VARIANT))
		{
		case REDWOOD:
			gen = new WorldGenRedwoodTree();
			break;
		
		case MAPLE:
			gen = new WorldGenMapleTree();
			break;
			
		case BEECH:
			gen = new WorldGenBeechTree();
			break;
			
		case WALNUT:
			gen = new WorldGenWalnutTree();
			break;
		}
		
		IBlockState iblockstate = Blocks.AIR.getDefaultState();
		if(flag)
		{
			world.setBlockState(pos.add(i, 0, j), iblockstate, 4);
			world.setBlockState(pos.add(i + 1, 0, j), iblockstate, 4);
			world.setBlockState(pos.add(i, 0, j + 1), iblockstate, 4);
			world.setBlockState(pos.add(i + 1, 0, j + 1), iblockstate, 4);
		}
		else
		{
			world.setBlockState(pos, iblockstate, 4);
		}
		
		if(!gen.generate(world, rand, pos.add(i, 0, j)))
		{
			if(flag)
			{
				world.setBlockState(pos.add(i, 0, j), iblockstate, 4);
				world.setBlockState(pos.add(i + 1, 0, j), iblockstate, 4);
				world.setBlockState(pos.add(i, 0, j + 1), iblockstate, 4);
				world.setBlockState(pos.add(i + 1, 0, j + 1), iblockstate, 4);
			}
			else
			{
				world.setBlockState(pos, iblockstate, 4);
			}
		}
	}
	
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
	{
		return true;
	}
	
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		return (double)worldIn.rand.nextFloat() < 0.45D;
	}
	
	@Override
	protected boolean canSustainBush(IBlockState state) 
	{
		return state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.FARMLAND  || state.getBlock() == Blocks.FARMLAND;
	}

}
