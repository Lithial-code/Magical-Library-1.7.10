package com.lithial.magicbooks.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.lithial.magicbooks.MagicBooks;
import com.lithial.magicbooks.ModInfo;
import com.lithial.magicbooks.handlers.EffectHandler;

public class ItemBookofEclipse extends Item{
	public ItemBookofEclipse()
	{
		setUnlocalizedName(ModInfo.MOD_ID + "_" + "book_of_the_eclipse");
		setTextureName(ModInfo.MOD_ID + ":" + "book_of_the_eclipse");
		setCreativeTab(CreativeTabs.tabMisc);
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		EffectHandler.time = player.worldObj.getWorldTime();;	
		if(player.getHeldItem() !=null && player.getHeldItem().getItem().equals(MagicBooks.BookofEclipse))
		{
			if(player.worldObj.isDaytime())
			{
				EffectHandler.EclipseActivated = true;
				//	player.addChatMessage( new ChatComponentText("Made Night"));
				player.worldObj.setWorldTime(15000);

			}
		}
			return stack ;
		}

	}