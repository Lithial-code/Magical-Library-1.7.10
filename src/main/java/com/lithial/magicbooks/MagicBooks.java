package com.lithial.magicbooks;

import java.io.File;
import java.util.logging.Logger;

import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import com.lithial.magicbooks.Items.ItemBookofEclipse;
import com.lithial.magicbooks.Items.ItemBookofHarvest;
import com.lithial.magicbooks.Items.ItemBookofWithering;
import com.lithial.magicbooks.handlers.EffectHandler;
import com.lithial.magicbooks.network.ClientProxy;
import com.lithial.magicbooks.network.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.VERSION)


public class MagicBooks {
  	@Mod.Instance(ModInfo.MOD_ID)
	static MagicBooks instance;

	@SidedProxy(clientSide = ModInfo.CLIENT_PROXY_LOCATION, serverSide = ModInfo.COMMON_PROXY_LOCATION)
	public static CommonProxy proxy;
	static ClientProxy cproxy;
	static Logger log;
    public static Configuration config;
    public static Item BookofEclipse,BookofWithering,BookoftheHarvest;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	 
		File config = new File(event.getModConfigurationDirectory(), "Lithial/MagicBooks.cfg");
		BookofEclipse = new ItemBookofEclipse();
		BookofWithering= new ItemBookofWithering();
		BookoftheHarvest = new ItemBookofHarvest();
	 }

	@EventHandler
	public void Initiate(FMLInitializationEvent Event) 
	{
	 
		proxy.registerEvents();
		cproxy.registerModelRenderers();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new EffectHandler());
		GameRegistry.registerItem(BookofEclipse, "book_of_the_eclipse");
		GameRegistry.registerItem(BookofWithering, "book_of_the_withering");
		GameRegistry.registerItem(BookoftheHarvest, "book_of_the_harvest");
	}


}
