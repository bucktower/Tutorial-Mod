package org.coderdojoia.tutorialmod;

// Make the needed the libraries accessible
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = TutorialMod.MODID, version = TutorialMod.VERSION) // Forge annotation
public class TutorialMod  // <-- mod class
{
	/* 
	 * Make MODID and VERSION fields:
	 *  - usable everywhere (with 'public')
	 *  - usable without a specific TutorialMod() created (with 'static')
	 *  - unchangeable (with 'final')
	 *  - a String type (instead of an integer, float, char, etc.)
	 * 
	 *  *!*!* By convention, 'final' fields are in ALL CAPS *!*!*
	 */
    public static final String MODID = "tutorialmod";
    public static final String VERSION = "1.0";
    
    /*
     * 
     */
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		/*
		 * some example code: print out the "dirt" block name
		 */
        System.out.println("DIRT BLOCK >> " + Blocks.dirt.getUnlocalizedName());
    }
}
