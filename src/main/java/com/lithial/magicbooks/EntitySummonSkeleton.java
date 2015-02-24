package com.lithial.magicbooks;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntitySummonSkeleton extends EntityMob{

	public EntitySummonSkeleton(World world) {
		super(world);
		 this.getNavigator().setAvoidsWater(true);
	        this.tasks.addTask(1, new EntityAISwimming(this));
	        this.tasks.addTask(2, new EntityAIRestrictSun(this));
	        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.0D, true));
	        //this.tasks.addTask(4, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
	        this.tasks.addTask(5, new EntityAILookIdle(this));
	        //this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
	        //this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
	        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
	  

	}
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        
    }
 
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}
	public int getAttackStrength(Entity par1Entity)
	{
		return 4;
	}
	protected boolean isAIEnabled()
    {
        return true;
    }
}
