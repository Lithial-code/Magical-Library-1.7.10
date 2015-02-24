package com.lithial.magicbooks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderSummonSkeleton extends RenderLiving{

	public RenderSummonSkeleton(ModelBase model, float f) {
		super(model, f);
		model = ((ModelSummonSkeleton)mainModel);
	}
	

	public void renderTutorial(EntitySummonSkeleton entity, double par2, double par4, double par6, float par8, float par9)
	    {
	        super.doRender(entity, par2, par4, par6, par8, par9);
	    }

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	    {
	        renderTutorial((EntitySummonSkeleton)par1EntityLiving, par2, par4, par6, par8, par9);
	    }

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	    {
	        renderTutorial((EntitySummonSkeleton)par1Entity, par2, par4, par6, par8, par9);
	    }
	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		// TODO Auto-generated method stub
		return new ResourceLocation("/assets/minecraft/entity/skeleton/skeleton.png");
	}
    
}
