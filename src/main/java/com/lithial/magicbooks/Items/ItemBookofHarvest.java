package com.lithial.magicbooks.Items;

import com.lithial.magicbooks.MagicBooks;
import com.lithial.magicbooks.ModInfo;
import com.lithial.magicbooks.handlers.EffectHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBookofHarvest extends Item {
	public ItemBookofHarvest()
	{
		setUnlocalizedName(ModInfo.MOD_ID + "_" + "book_of_the_harvest");
		setTextureName(ModInfo.MOD_ID + ":" + "book_of_the_eclipse");
		setCreativeTab(CreativeTabs.tabMisc);
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		EffectHandler.time = player.worldObj.getWorldTime();;	
		if(player.getHeldItem() !=null && player.getHeldItem().getItem().equals(MagicBooks.BookoftheHarvest))
		{
			if(player.worldObj.isDaytime())
			{
				EffectHandler.HarvestActivated = true;
				//	player.addChatMessage( new ChatComponentText("Made Night"));
			 

			}
		}
			return stack ;
		}

	}