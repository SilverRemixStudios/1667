package srs1667.entity;

import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAIFollowGolem;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookAtTradePlayer;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.ai.EntityAIVillagerInteract;
import net.minecraft.entity.ai.EntityAIVillagerMate;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import srs1667.util.handlers.LootTableHandler;

public class EntityGranny extends EntityVillager implements ITickable
{
	/*
	 * Make GrannyInteractions occur Once a Day.
	 * An in-game day lasts exactly 24000 ticks, or 20 minutes
	 * /effect @p hunger 5 255 : give player hunger for food testing
	 */
	
	private long ticksIn = 0;
	
	public EntityGranny(World worldIn)
	{
		super(worldIn);
	    this.setProfession(0);
	    this.setSize(0.6F, 1.5F);
	    ((PathNavigateGround)this.getNavigator()).setBreakDoors(true);
	    this.setCanPickUpLoot(true);
	}
	
	
	
	@Override
	protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityEvoker.class, 12.0F, 0.8D, 0.8D));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityVindicator.class, 8.0F, 0.8D, 0.8D));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityVex.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(6, new EntityAIVillagerMate(this));
        this.tasks.addTask(7, new EntityAIFollowGolem(this));
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(9, new EntityAIVillagerInteract(this));
        this.tasks.addTask(9, new EntityAIWanderAvoidWater(this, 0.6D));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
    }

	@Override
	 protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.15D);
	        
	    }
	
	 @SideOnly(Side.CLIENT)
	    private void spawnParticles(EnumParticleTypes particleType)
	    {
	        for (int i = 0; i < 5; ++i)
	        {
	            double d0 = this.rand.nextGaussian() * 0.02D;
	            double d1 = this.rand.nextGaussian() * 0.02D;
	            double d2 = this.rand.nextGaussian() * 0.02D;
	            this.world.spawnParticle(particleType, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 1.0D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);
	        }
	    }
	
	@Override
	  public float getEyeHeight()
	    {
	        return this.isChild() ? 0.81F : 1.2F;
	    }
	
	
	@Override
	protected ResourceLocation getLootTable()
	{
		return LootTableHandler.GHOST;
	}
	
	
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand)
	{
		//Minecraft.getMinecraft().player.sendChatMessage("Hello Dear");
		//return true;
		
		ItemStack itemstack = player.getHeldItem(hand);
		Random gift = new Random ();
		int choice;
		boolean flag = itemstack.getItem() == Items.NAME_TAG;
		if (flag)
	    {
	            itemstack.interactWithEntity(player, this, hand);
	            return true;
	    }

		else if (itemstack.getItem() == Items.APPLE)
        {
        	choice = gift.nextInt(21);
            player.playSound(SoundEvents.ENTITY_VILLAGER_YES, 1.0F, 1.0F);
            itemstack.shrink(1);
        	this.spawnParticles(EnumParticleTypes.HEART);

            if (choice <= 10)
            {
            	 if (itemstack.isEmpty())
                 {
                     player.setHeldItem(hand, new ItemStack(Items.COOKED_PORKCHOP));
                 }
                 else if (!player.inventory.addItemStackToInventory(new ItemStack(Items.COOKED_PORKCHOP)))
                 {
                     player.dropItem(new ItemStack(Items.COOKED_PORKCHOP), false);
                 }
            	 Minecraft.getMinecraft().player.sendChatMessage("Enjoy your Lunch");
                 return true;
            }
            if (choice > 10 && choice <= 15)
            {
            	 if (itemstack.isEmpty())
                 {
                     player.setHeldItem(hand, new ItemStack(Items.GOLD_INGOT));
                 }
                 else if (!player.inventory.addItemStackToInventory(new ItemStack(Items.GOLD_INGOT)))
                 {
                     player.dropItem(new ItemStack(Items.GOLD_INGOT), false);
                 }
            	 Minecraft.getMinecraft().player.sendChatMessage("Here's a Little Something");
                 return true;
            }
            if (choice > 15 && choice < 20)
            {
            	 if (itemstack.isEmpty())
                 {
                     player.setHeldItem(hand, new ItemStack(Items.EMERALD));
                 }
                 else if (!player.inventory.addItemStackToInventory(new ItemStack(Items.EMERALD)))
                 {
                     player.dropItem(new ItemStack(Items.EMERALD), false);
                 }
            	 Minecraft.getMinecraft().player.sendChatMessage("Buy Something Nice");
                 return true;
            }
            if (choice == 20)
            {
            	 if (itemstack.isEmpty())
                 {
                     player.setHeldItem(hand, new ItemStack(Items.PUMPKIN_PIE));
                 }
                 else if (!player.inventory.addItemStackToInventory(new ItemStack(Items.PUMPKIN_PIE)))
                 {
                     player.dropItem(new ItemStack(Items.PUMPKIN_PIE), false);
                 }
            	 Minecraft.getMinecraft().player.sendChatMessage("Happy Birthday");
                 return true;
            }
        }
        else
        {
            return false;
        }
		return flag;

	}
	
	@Override
	public EntityVillager createChild(EntityAgeable ageable)
	{
		return new EntityGranny(world);
	}
	
	/**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else
        {
            Entity entity = source.getTrueSource();
            if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
            {
                amount = (amount + 1.0F) / 2.0F;
            }
            return super.attackEntityFrom(source, amount);
        }
    }



	@Override
	public void update() {
		ticksIn+=1;
        if(ticksIn == 300)
        {
            ticksIn = 0;
            Minecraft.getMinecraft().player.sendChatMessage("300 ticks");
            System.out.println("300 ticks");
            //syntax highlights
        }
		
	}
    
	/* BlockFlower Class
	 	DANDELION(BlockFlower.EnumFlowerColor.YELLOW, 0, "dandelion"),
        POPPY(BlockFlower.EnumFlowerColor.RED, 0, "poppy"),
        BLUE_ORCHID(BlockFlower.EnumFlowerColor.RED, 1, "blue_orchid", "blueOrchid"),
        ALLIUM(BlockFlower.EnumFlowerColor.RED, 2, "allium"),
        HOUSTONIA(BlockFlower.EnumFlowerColor.RED, 3, "houstonia"),
        RED_TULIP(BlockFlower.EnumFlowerColor.RED, 4, "red_tulip", "tulipRed"),
        ORANGE_TULIP(BlockFlower.EnumFlowerColor.RED, 5, "orange_tulip", "tulipOrange"),
        WHITE_TULIP(BlockFlower.EnumFlowerColor.RED, 6, "white_tulip", "tulipWhite"),
        PINK_TULIP(BlockFlower.EnumFlowerColor.RED, 7, "pink_tulip", "tulipPink"),
        OXEYE_DAISY(BlockFlower.EnumFlowerColor.RED, 8, "oxeye_daisy", "oxeyeDaisy");
	 */
}
