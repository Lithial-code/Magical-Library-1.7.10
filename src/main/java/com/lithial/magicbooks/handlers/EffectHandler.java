package com.lithial.magicbooks.handlers;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingEvent;

import com.lithial.me.enchantments.Enchantments;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EffectHandler {
	public static long time;
	public static boolean EclipseActivated = false;
	public static boolean WitherActivated = false;
	public static boolean HarvestActivated = false;
	Random rand = new Random();
	@SubscribeEvent
	public void Eclipse(LivingEvent event)
	{	

		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			//			System.out.println(player.worldObj.getWorldTime());
			if(EclipseActivated){
				if(player.worldObj.getWorldTime() == 16200){
					player.worldObj.setWorldTime(time);
					EclipseActivated =false;
				}
			}
			if(WitherActivated)
			{

				AxisAlignedBB boundBox = AxisAlignedBB.getBoundingBox(player.posX-6, player.posY-6, player.posZ-6, player.posX+6, player.posY+6, player.posZ+6);

				int j = MathHelper.floor_double(player.posY - 1.0D);
				for (int i = 0; i < 4; i++) {

					for (int l = (int)player.posX -j; l <= player.posX + j; ++l)
					{
						for (int i1 = (int)player.posZ - (i+1); i1 <= player.posZ + i; ++i1)
						{
							Block block = player.worldObj.getBlock(l, j, i1);
							if(isPlant(l,j+1,i1,player,block))
								player.worldObj.setBlock(l, j, i1, block.getBlockById(0));
							if(block.equals(Block.getBlockById(2))||(block.equals(Block.getBlockById(60))))
								player.worldObj.setBlock(l, j, i1, Block.getBlockById(3));

						}

						WitherActivated = false;       
					}

					ArrayList<Entity> targetEntities = new ArrayList<Entity>(player.worldObj.getEntitiesWithinAABBExcludingEntity(event.entity, boundBox));
					ListIterator<Entity> itr = targetEntities.listIterator();
					while(itr.hasNext())
					{
						Entity target = itr.next();
						if(target instanceof EntityLivingBase)
						{
							((EntityLivingBase)target).addPotionEffect(new PotionEffect(Potion.wither.id, (Enchantments.witherAOETimer *20), 6));

						}
						if(target instanceof EntityItem)
						{
							target.setDead();
						}
						WitherActivated = false;
					}

				}


			}
			if(HarvestActivated)
			{

				int j = MathHelper.floor_double(player.posY - 1.0D);
				for (int i = 0; i < 4; i++) {

					for (int l = (int)player.posX -j; l <= player.posX + j; ++l)
					{
						for (int i1 = (int)player.posZ - (i+1); i1 <= player.posZ + i; ++i1)
						{
							Block block = player.worldObj.getBlock(l, j, i1);
							Block blockAbove = player.worldObj.getBlock(l, j+1, i1);

							if(block.equals(block.getBlockById(2))||(block.equals(block.getBlockById(3)))){
								if(blockAbove != block.getBlockById(85)){
									player.worldObj.setBlock(l, j, i1, block.getBlockById(60),7,2);
									player.worldObj.setBlock(l, j+1, i1, block.getBlockById(plantsList()), 7,2);
									//player.worldObj.setBlock(l, j+1, i1, block.getBlockFromName("wheat"));

								}
							}
							HarvestActivated = false;
						}
					}
					if(player.worldObj.getBlock((int)player.posX , (int)player.posY-1, (int)player.posZ -1)!= Block.getBlockById(9))
						player.worldObj.setBlock((int)player.posX , (int)player.posY-1, (int)player.posZ -1, Block.getBlockById(9));
				}
			}
		}
	}
	boolean isPlant(int x, int y, int z,EntityPlayer player,Block block) {
		//Block block = (EntityPlayer) player).getWorldObj().getBlock(x, y, z);
		if(block == Blocks.grass || block == Blocks.leaves || block == Blocks.leaves2  ||block instanceof BlockBush && !(block instanceof BlockCrops) && !(block instanceof BlockSapling)&& !(block instanceof BlockFlower))
			return false;

		Material mat = block.getMaterial();
		return mat != null && (mat == Material.plants || mat == Material.cactus || mat == Material.grass || mat == Material.leaves || mat == Material.gourd);
	}
	int plantsList()
	{
		int item = new Random().nextInt(3) +1;
		int blockid = 0;
		Block block;
		if(item == 1)
			return blockid =59 ;
		if(item == 2)
			return blockid =141 ;
		if(item == 3)
			return blockid =142 ;
		/*	if(item == 1)
		return 0;
		if(item == 1)*/
		/*return 0;*/
		return blockid;


	}
}

