package srs1667.objects.blocks;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import srs1667.Mod1667;
import srs1667.init.BlockInit;
import srs1667.init.ItemInit;
import srs1667.objects.blocks.item.ItemBlockVariants;
import srs1667.util.handlers.EnumHandler;
import srs1667.util.interfaces.IHasModel;
import srs1667.util.interfaces.IMetaName;

public class BlockLogs extends BlockLog implements IHasModel
{
    public static final PropertyEnum<EnumHandler.EnumLogAxis> LOG_AXIS = PropertyEnum.<EnumHandler.EnumLogAxis>create("variant", EnumHandler.EnumLogAxis.class);
   
    private String name;
   
    public BlockLogs(String name)
    {
    	 super();
         this.setSoundType(blockSoundType.WOOD);
         setUnlocalizedName(name);
         setRegistryName(name);
         this.name = name;
         setHardness(2);
         
         this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
         setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, EnumHandler.EnumLogAxis.Y));
         
         BlockInit.BLOCKS.add(this);
         ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
       
    }
    
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (worldIn.isAreaLoaded(pos.add(-5, -5, -5), pos.add(5, 5, 5)))
        {
            for (BlockPos blockpos : BlockPos.getAllInBox(pos.add(-4, -4, -4), pos.add(4, 4, 4)))
            {
                IBlockState iblockstate = worldIn.getBlockState(blockpos);
 
                if (iblockstate.getBlock().isLeaves(iblockstate, worldIn, blockpos))
                {
                    iblockstate.getBlock().beginLeavesDecay(iblockstate, worldIn, blockpos);
                }
            }
        }
    }
   
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(LOG_AXIS, EnumHandler.EnumLogAxis.byMetadata(meta));
    }
   
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getStateFromMeta(meta).withProperty(LOG_AXIS, EnumHandler.EnumLogAxis.fromFacingAxis(facing.getAxis()));
    }
   
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumHandler.EnumLogAxis)state.getValue(LOG_AXIS)).getMeta();
    }
   
    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, 0);
    }
   
    @Override
    public boolean canSustainLeaves(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return true;
    }
   
    @Override
    public boolean isWood(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return true;
    }
   
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return 5;
    }
   
    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return getFlammability(world, pos, face) > 0;
    }
   
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return 5;
    }
   
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
    }
   
    @Override
    public int damageDropped(IBlockState state)
    {
        return 0;
    }
   
    @Override
    public void registerModels()
    {
        Mod1667.proxy.registerVariantRenderer(Item.getItemFromBlock(this), 0, this.name, "inventory");
    }
}