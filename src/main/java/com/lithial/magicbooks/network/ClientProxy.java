package com.lithial.magicbooks.network;

 

import net.minecraft.client.renderer.entity.RenderBiped;

import com.lithial.magicbooks.EntitySummonSkeleton;
import com.lithial.magicbooks.ModelSummonSkeleton;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{
	
public static void registerModelRenderers() 
	{

		RenderingRegistry.registerEntityRenderingHandler(EntitySummonSkeleton.class, new RenderBiped(new ModelSummonSkeleton(), 0.5F));

	}
}