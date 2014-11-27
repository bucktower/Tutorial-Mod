package org.coderdojoia.tutorialmod.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import org.coderdojoia.tutorialmod.common.TutorialModCommonProxy;
import fisherman77.zeuscraft.common.mobs.EntityPegasus;
import fisherman77.zeuscraft.common.mobs.ModelPegasus;
import fisherman77.zeuscraft.common.mobs.RenderPegasus;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraftforge.client.MinecraftForgeClient;

public class TutorialModClientProxy extends TutorialModCommonProxy {
        
	public void registerRenderInformation(){
		
	}
	
	public void registerRenderers(){
		float shadowSize = 0.5F;
		
		//RenderingRegistry.registerEntityRenderingHandler(EntityCowboy.class, new RenderCowboy());
	}

}
